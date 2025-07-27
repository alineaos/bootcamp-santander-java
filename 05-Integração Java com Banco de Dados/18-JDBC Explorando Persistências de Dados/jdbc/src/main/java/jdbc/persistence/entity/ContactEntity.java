package jdbc.persistence.entity;

import lombok.Data;

@Data
public class ContactEntity {
    private long id;
    private String description;
    private String type;
    private EmployeeEntity employee;

    public ContactEntity() {
    }

    public ContactEntity(String description, String type, EmployeeEntity employee) {
        this.description = description;
        this.type = type;
        this.employee = employee;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
