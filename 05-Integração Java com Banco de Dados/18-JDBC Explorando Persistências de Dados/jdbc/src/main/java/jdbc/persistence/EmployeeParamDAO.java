package jdbc.persistence;

import com.mysql.cj.jdbc.StatementImpl;
import jdbc.persistence.entity.ContactEntity;
import jdbc.persistence.entity.EmployeeEntity;
import jdbc.persistence.entity.ModuleEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.TimeZone.LONG;

public class EmployeeParamDAO {
    private final static ContactDAO contactDAO = new ContactDAO();
    private final static AccessDAO accessDAO = new AccessDAO();
    public void insert(final EmployeeEntity entity) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "INSERT INTO employees (name, salary, birthday) values (?, ?, ?)"
                )
        ) {
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime()));
            statement.executeUpdate();
            if (statement instanceof StatementImpl impl) {
                entity.setId(impl.getLastInsertID());
                entity.getModules().stream()
                        .map(ModuleEntity::getId)
                        .forEach(m -> accessDAO.insert(entity.getId(), m));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertWithProducedure(final EmployeeEntity entity) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareCall(
                        "call prc_insert_employee(?, ?, ?, ?)"
                )
        ) {
            statement.registerOutParameter(1, LONG);
            statement.setString(2, entity.getName());
            statement.setBigDecimal(3, entity.getSalary());
            statement.setTimestamp(4, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime()));
            statement.execute();
            entity.setId(statement.getLong(1));
            System.out.printf("%s registro(s) foi/foram inserido(s) da base de dados\n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl) {
                entity.setId(impl.getLastInsertID());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(final List<EmployeeEntity> entities) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO employees (name, salary, birthday) values (?, ?, ?);";
            try (var statement = connection.prepareStatement(sql)) {
                connection.setAutoCommit(false);
                int i = 0;
                for (EmployeeEntity entity : entities) {
                    statement.setString(1, entity.getName());
                    statement.setBigDecimal(2, entity.getSalary());
                    Timestamp timestamp = Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime());
                    statement.setTimestamp(3, timestamp);
                    statement.addBatch();
                    i++;
                    if (i % 1000 == 0 || i == entities.size() - 1) {
                        statement.executeBatch();
                    }
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "UPDATE employees set name = ?, salary = ?, birthday = ? WHERE id = ?"
                )
        ) {
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3, Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime()));
            statement.setLong(4, entity.getId());
            statement.execute();
            System.out.printf(" %s registro(s) foi/foram atualizado(s) da base de dados\n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl) {
                entity.setId(impl.getLastInsertID());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(final long id) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?")
        ) {
            statement.setLong(1, id);
            statement.execute();
            System.out.printf(" %s registro(s) foi/foram deletado(s) da base de dados\n", statement.getUpdateCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            statement.executeQuery("Select * FROM employees");
            var resultSet = statement.getResultSet();
            while (resultSet.next()) {
                EmployeeEntity entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entity.setContacts(contactDAO.findByEmployeeId(resultSet.getLong("id")));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final long id) {
        EmployeeEntity entity = new EmployeeEntity();
        String sql = "SELECT e.id employee_id,\n" +
                "       e.name,\n" +
                "       e.salary,\n" +
                "       e.birthday,\n" +
                "       c.id contact_id,\n" +
                "       c.description,\n" +
                "       c.type\n" +
                "  FROM employees e\n" +
                " LEFT JOIN contacts c\n" +
                "   ON c.employee_id = e.id \n" +
                "WHERE e.id = ?";
        ;
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(sql)
        ) {
            statement.setLong(1, id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if (resultSet.next()) {
                entity.setId(resultSet.getLong("employee_id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entity.setContacts(new ArrayList<>());
                do {
                    ContactEntity contact = new ContactEntity();
                    contact.setId(resultSet.getLong("contact_id"));
                    contact.setDescription(resultSet.getString("description"));
                    contact.setType(resultSet.getString("type"));
                    entity.getContacts().add(contact);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime) {
        OffsetDateTime utcDateTime = dateTime.withOffsetSameInstant(UTC);
        return utcDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
