package jdbc.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class EmployeeEntity {

    private long id;

    private String name;

    private BigDecimal salary;

    private OffsetDateTime birthday;

    private ContactEntity contact;

    private List<ContactEntity> contacts;

    private List<ModuleEntity> modules;

    public EmployeeEntity(String name, BigDecimal salary, OffsetDateTime birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public EmployeeEntity() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }
}
