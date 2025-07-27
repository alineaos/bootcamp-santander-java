package jdbc.persistence;

import jdbc.persistence.entity.EmployeeAuditEntity;
import jdbc.persistence.entity.OperationEnum;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;
import static java.util.Objects.isNull;

public class EmployeeAuditDAO {
    public List<EmployeeAuditEntity> findAll(){
    List<EmployeeAuditEntity> entities = new ArrayList<>();
        try(
    Connection connection = ConnectionUtil.getConnection();
    var statement = connection.createStatement()
        )

    {
        statement.executeQuery("Select * FROM view_employee_audit");
        var resultSet = statement.getResultSet();
        while (resultSet.next()) {
            var birthday = OffsetDateTime.ofInstant(resultSet.getTimestamp("birthday").toInstant(), UTC);
            entities.add(new EmployeeAuditEntity(
               resultSet.getLong("employee_id"),
               resultSet.getString("name"),
               resultSet.getString("old_name"),
               resultSet.getBigDecimal("salary"),
               resultSet.getBigDecimal("old_salary"),
               getDateTimeOrNull(resultSet, "birthday"),
               getDateTimeOrNull(resultSet, "old_birthday"),
               OperationEnum.getByDbOperation(resultSet.getString("operation"))
            ));
        }
    } catch(SQLException e) {
        e.printStackTrace();
    }
        return entities;
}
    public OffsetDateTime getDateTimeOrNull(final ResultSet resultSet, final String field) throws SQLException{
        return isNull(resultSet.getTimestamp(field)) ? null :
                OffsetDateTime.ofInstant(resultSet.getTimestamp(field).toInstant(), UTC);
    }
}
