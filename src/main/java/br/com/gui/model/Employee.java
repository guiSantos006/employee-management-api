package br.com.gui.model;


import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private Long id;
    private String name;
    private BigDecimal salary;
    private BigDecimal commission;
    private BigDecimal bonus;
    private LocalDate birthday;

    public Employee() {
    }

    public Employee(String name,
                    BigDecimal salary,
                    BigDecimal commission,
                    BigDecimal bonus,
                    LocalDate birthday) {
        this.name = name;
        this.salary = salary;
        this.commission = commission;
        this.bonus = bonus;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }

        if (!(object instanceof Employee employee)){
            return false;
        }

        return id != null && id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", commission=" + commission +
                ", bonus=" + bonus +
                ", birthday=" + birthday +
                '}';
    }
}
