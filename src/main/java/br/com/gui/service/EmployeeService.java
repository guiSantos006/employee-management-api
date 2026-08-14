package br.com.gui.service;

import br.com.gui.model.Employee;
import br.com.gui.repository.EmployeeRepository;
import br.com.gui.strategy.CompensationStrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(final EmployeeRepository repository) {
        this.repository = repository;
    }

    public BigDecimal calculateCompensation(
            final Employee employee,
            final CompensationStrategy strategy
    ) {
        return strategy.calculate(employee);
    }

    public Employee create(final Employee employee) {
        validate(employee);

        return repository.insert(employee);
    }

    public Employee update(final Employee employee) {
        validate(employee);

        if (employee.getId() == null) {
            throw new IllegalArgumentException(
                    "O funcionário precisa possuir um ID para ser atualizado"
            );
        }

        return repository.update(employee);
    }

    public void delete(final long id) {
        repository.delete(id);
    }

    public Optional<Employee> findById(final long id) {
        return repository.findById(id);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    private void validate(final Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException(
                    "Funcionário não pode ser nulo"
            );
        }

        if (employee.getName() == null || employee.getName().isBlank()) {
            throw new IllegalArgumentException(
                    "Nome do funcionário é obrigatório"
            );
        }

        if (employee.getSalary() == null ||
                employee.getSalary().signum() < 0) {
            throw new IllegalArgumentException(
                    "Salário deve ser maior ou igual a zero"
            );
        }

        if (employee.getBirthday() == null) {
            throw new IllegalArgumentException(
                    "Data de nascimento é obrigatória"
            );
        }
    }
}
