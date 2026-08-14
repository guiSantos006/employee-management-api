package br.com.gui.facade;

import br.com.gui.model.Employee;
import br.com.gui.service.EmployeeService;
import br.com.gui.strategy.CompensationStrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class EmployeeFacade {

    private final EmployeeService service;

    public EmployeeFacade(final EmployeeService service) {
        this.service = service;
    }

    public Employee createEmployee(final Employee employee) {
        return service.create(employee);
    }

    public Employee updateEmployee(final Employee employee) {
        return service.update(employee);
    }

    public void deleteEmployee(final long id) {
        service.delete(id);
    }

    public Optional<Employee> findEmployeeById(final long id) {
        return service.findById(id);
    }

    public List<Employee> findAllEmployees() {
        return service.findAll();
    }

    public BigDecimal calculateCompensation(
            final Employee employee,
            final CompensationStrategy strategy
    ) {
        return service.calculateCompensation(employee, strategy);
    }
}
