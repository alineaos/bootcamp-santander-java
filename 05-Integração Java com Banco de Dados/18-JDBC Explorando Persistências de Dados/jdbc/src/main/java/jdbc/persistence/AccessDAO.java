package jdbc.persistence;

import com.mysql.cj.jdbc.StatementImpl;
import jdbc.persistence.entity.EmployeeEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import static java.time.ZoneOffset.UTC;

public class AccessDAO {

    public void insert(final long employeeId, final long moduleId) {
        try (
                Connection connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "INSERT INTO accesses (employee_id, module_id) values (?, ?)"
                )
        ) {
            statement.setLong(1, employeeId);
            statement.setLong(2, moduleId );
            statement.executeUpdate();
            System.out.printf("%s registro(s) foi/foram inserido(s) da base de dados\n", statement.getUpdateCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
