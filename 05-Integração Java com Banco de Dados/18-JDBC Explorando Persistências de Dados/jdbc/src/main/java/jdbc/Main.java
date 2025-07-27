package jdbc;


import jdbc.persistence.ContactDAO;
import jdbc.persistence.EmployeeAuditDAO;
import jdbc.persistence.EmployeeDAO;
import jdbc.persistence.EmployeeParamDAO;
import jdbc.persistence.ModuleDAO;
import jdbc.persistence.entity.ContactEntity;
import jdbc.persistence.entity.EmployeeEntity;
import jdbc.persistence.entity.ModuleEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class Main {
    // employee antigo sem parametros que é frágil contra ataque hackers
//private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static EmployeeParamDAO employeeDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR"));
    private final static ContactDAO contactDAO = new ContactDAO();
    private final static ModuleDAO moduleDAO = new ModuleDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc", "root", "root")
                .load();
        // flyway.repair();
        flyway.migrate();


        //EmployeeEntity employeeInsert = new EmployeeEntity("Miguel", new BigDecimal(2800), OffsetDateTime.now().minusYears(18));
        //employeeDAO.insert(employeeInsert);

        //employeeDAO.findAll().forEach(System.out::println);

        //System.out.println(employeeDAO.findById(3));

        /*EmployeeEntity employeeUpdate = new EmployeeEntity("Gabriel", new BigDecimal(5500), OffsetDateTime.now().minusYears(21).minusDays(8));
        employeeUpdate.setId(employeeInsert.getId());
        employeeDAO.update(employeeUpdate);


        employeeDAO.delete(employeeInsert.getId());*/

        //employeeAuditDAO.findAll().forEach(System.out::println);

        List<EmployeeEntity> entities = Stream.generate(() -> {
            String name = faker.name().fullName();
            BigDecimal salary = new BigDecimal(faker.number().digits(4));
            OffsetDateTime birthday = OffsetDateTime.of(LocalDateTime.now().minusYears(faker.number().numberBetween(40, 20)), UTC);
            EmployeeEntity employee = new EmployeeEntity(name, salary, birthday);
            employee.setModules(new ArrayList<>());
            var moduleAmount = faker.number().numberBetween(1,4);
            for (int i = 0; i < moduleAmount; i++) {
                ModuleEntity module = new ModuleEntity();
                module.setId(i+1);
                employee.getModules().add(module);
            }
            return employee;
        }).limit(5).toList();
        entities.forEach(employeeDAO::insert);

        /*
        ContactEntity contactInsert = new ContactEntity("miguel@miguel.com", "e-mail", employeeInsert);
        ContactEntity contactInsert2 = new ContactEntity("4976537568", "celular", employeeInsert);
        contactDAO.insert(contactInsert);
        contactDAO.insert(contactInsert2);
        */

        moduleDAO.findAll().forEach(System.out::println);

    }

}
