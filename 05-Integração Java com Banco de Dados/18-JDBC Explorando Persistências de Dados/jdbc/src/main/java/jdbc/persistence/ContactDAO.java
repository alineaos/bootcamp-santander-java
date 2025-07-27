package jdbc.persistence;

import com.mysql.cj.jdbc.StatementImpl;
import jdbc.persistence.entity.ContactEntity;
import jdbc.persistence.entity.EmployeeEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ContactDAO {
    public void insert(final ContactEntity entity) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "INSERT INTO contacts (description, type, employee_id) values (?, ?, ?)"
                )
        ) {
            statement.setString(1, entity.getDescription());
            statement.setString(2, entity.getType());
            statement.setLong(3, entity.getEmployee().getId());
            statement.executeUpdate();
            System.out.printf("%s registro(s) foi/foram inserido(s) da base de dados\n", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl) {
                entity.setId(impl.getLastInsertID());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ContactEntity> findByEmployeeId(final long employeeId) {
        List<ContactEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "SELECT * FROM contacts WHERE employee_id = ?"
                )
        ) {
            statement.setLong(1, employeeId);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next()){
                ContactEntity entity = new ContactEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setDescription(resultSet.getString("description"));
                entity.setType(resultSet.getString("type"));
                entity.setEmployee(new EmployeeEntity());
                entity.getEmployee().setId(resultSet.getLong("employee_id"));
                entities.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }
}
