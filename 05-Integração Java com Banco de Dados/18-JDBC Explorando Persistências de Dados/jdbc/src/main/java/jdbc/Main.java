package jdbc;

import jdbc.persistence.ConnectionUtil;
import jdbc.persistence.EmployeeDAO;
import jdbc.persistence.entity.EmployeeEntity;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc", "root", "root")
                .load();
        flyway.migrate();
    }
}
