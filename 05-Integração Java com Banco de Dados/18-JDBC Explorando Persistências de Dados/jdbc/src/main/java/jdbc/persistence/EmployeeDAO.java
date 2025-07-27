package jdbc.persistence;

import jdbc.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class EmployeeDAO {

    public void insert(final EmployeeEntity entity){
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO employees (name, salary, birthday) values ('%s', %s, '%s')",
                    entity.getName(), entity.getSalary().toString(), formatOffsetDateTime(entity.getBirthday()));
            statement.executeUpdate(sql);
            System.out.printf("%s registro(s) foi/foram inserido(s) da base de dados\n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE employees set name = '%s', salary = %s, birthday = '%s' WHERE id = %s",
                    entity.getName(), entity.getSalary().toString(), formatOffsetDateTime(entity.getBirthday()), entity.getId());
            statement.executeUpdate(sql);
            System.out.printf("%s registro(s) foi/foram atualizado(s) da base de dados\n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl){
                entity.setId(impl.getLastInsertID());
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(final long id){
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM employees WHERE id = %s", id);
            statement.executeUpdate(sql);
            System.out.printf(" %s registro(s) foi/foram deletado(s) da base de dados\n", statement.getUpdateCount());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<EmployeeEntity> findAll(){
        List<EmployeeEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            statement.executeQuery("Select * FROM employees");
            var resultSet = statement.getResultSet();
            while(resultSet.next()){
                EmployeeEntity entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entities.add(entity);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final long id){
        EmployeeEntity entity = new EmployeeEntity();
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
        ) {
            statement.executeQuery("Select * FROM employees WHERE id = "+ id);
            var resultSet = statement.getResultSet();
            while(resultSet.next()){
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return entity;
    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime){
        OffsetDateTime utcDateTime = dateTime.withOffsetSameInstant(UTC);
        return utcDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
