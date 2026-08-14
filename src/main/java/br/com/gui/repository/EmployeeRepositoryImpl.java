package br.com.gui.repository;

import br.com.gui.config.ConnectionFactory;
import br.com.gui.model.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Employee insert(final Employee employee) {
        try (
                var connection = ConnectionFactory.getConnection();
                var statement = connection.prepareStatement(
                        "INSERT INTO employees (name, salary, commission, bonus, birthday)" +
                                " values (?, ?, ?, ?, ?);",
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            statement.setString(1, employee.getName());
            statement.setBigDecimal(2, employee.getSalary());
            statement.setBigDecimal(3, employee.getCommission());
            statement.setBigDecimal(4, employee.getBonus());
            statement.setDate(5, Date.valueOf(employee.getBirthday()));

            statement.executeUpdate();

            try (var generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId(generatedKeys.getLong(1));
                }
            }

            return employee;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir funcionário", ex);
        }
    }

    @Override
    public Employee update(Employee employee) {
        try (
                var connection = ConnectionFactory.getConnection();
                var statement = connection.prepareStatement(
                        "UPDATE employees set name = ?, salary = ?, commission = ?," +
                                " bonus = ?, birthday = ? WHERE id = ?"
                )
        ) {
            statement.setString(1, employee.getName());
            statement.setBigDecimal(2, employee.getSalary());
            statement.setBigDecimal(3, employee.getCommission());
            statement.setBigDecimal(4, employee.getBonus());
            statement.setDate(5, Date.valueOf(employee.getBirthday()));
            statement.setLong(6, employee.getId());

            statement.executeUpdate();

            return employee;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar funcionário", ex);
        }
    }

    @Override
    public void delete(long id) {
        try (
                var connection = ConnectionFactory.getConnection();
                var statement = connection.prepareStatement(
                        "DELETE FROM employees WHERE id = ?"
                )
        ) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover funcionário", ex);
        }
    }

    @Override
    public Optional<Employee> findById(final long id) {
        try (
                var connection = ConnectionFactory.getConnection();
                var statement = connection.prepareStatement(
                        "SELECT * FROM employees WHERE id = ?"
                )
        ) {
            statement.setLong(1, id);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapEmployee(resultSet));
            }
            return Optional.empty();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar funcionário", ex);
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (
                var connection = ConnectionFactory.getConnection();
                var statement = connection.createStatement()
        ) {
            var resultSet = statement.executeQuery("SELECT * FROM employees ORDER BY name");
            while (resultSet.next()) {
                employees.add(mapEmployee(resultSet));
            }
            return employees;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar os funcionários", ex);
        }
    }

    private static Employee mapEmployee(ResultSet resultSet) throws SQLException {
        var employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setSalary(resultSet.getBigDecimal("salary"));
        employee.setCommission(resultSet.getBigDecimal("commission"));
        employee.setBonus(resultSet.getBigDecimal("bonus"));
        employee.setBirthday(
                resultSet.getDate("birthday").toLocalDate()
        );
        return employee;
    }
}
