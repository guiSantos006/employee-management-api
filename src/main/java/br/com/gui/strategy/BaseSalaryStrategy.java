package br.com.gui.strategy;

import br.com.gui.model.Employee;

import java.math.BigDecimal;

public class BaseSalaryStrategy implements CompensationStrategy {

    @Override
    public BigDecimal calculate(Employee employee) {
        return employee.getSalary();
    }
}
