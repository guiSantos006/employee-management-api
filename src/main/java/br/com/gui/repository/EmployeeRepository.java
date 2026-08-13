package br.com.gui.repository;

import br.com.gui.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee insert(Employee employee);

    Employee update(Employee employee);

    void delete(long id);

    Optional<Employee> findById(long id);

    List<Employee> findAll();




}
