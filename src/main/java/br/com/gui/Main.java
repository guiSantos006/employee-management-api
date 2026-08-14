package br.com.gui;

import br.com.gui.config.FlywayConfig;
import br.com.gui.facade.EmployeeFacade;
import br.com.gui.model.Employee;
import br.com.gui.repository.EmployeeRepository;
import br.com.gui.repository.EmployeeRepositoryImpl;
import br.com.gui.service.EmployeeService;
import br.com.gui.strategy.BaseSalaryStrategy;
import br.com.gui.strategy.FullCompensationStrategy;
import br.com.gui.strategy.SalaryWithCommissionStrategy;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Main {

    private static final EmployeeRepository repository = new EmployeeRepositoryImpl();

    private static final Faker faker = new Faker(Locale.of("pt", "BR"));

    private static final EmployeeService service = new EmployeeService(repository);

    private static final EmployeeFacade facade = new EmployeeFacade(service);


    public static void main(String[] args) {

        FlywayConfig.migrate();

        // Criando primeiro funcionário
        var employee = new Employee(
                faker.name().fullName(),
                BigDecimal.valueOf(
                        faker.number().randomDouble(2, 1000, 10000)
                ),
                BigDecimal.valueOf(
                        faker.number().randomDouble(2, 0, 2000)
                ),
                BigDecimal.valueOf(
                        faker.number().randomDouble(2, 0, 3000)
                ),
                LocalDate.of(
                        faker.number().numberBetween(1970, 2005),
                        faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1, 28)
                )
        );

        // CREATE
        facade.createEmployee(employee);
        System.out.println("Criado:");
        System.out.println(employee);

        // FIND BY ID
        System.out.println("\nEncontrado:");
        facade.findEmployeeById(employee.getId())
                .ifPresent(System.out::println);

        // Criando segundo funcionário
        var employee2 = new Employee(
                faker.name().fullName(),
                BigDecimal.valueOf(
                        faker.number().randomDouble(2, 1000, 10000)
                ),
                BigDecimal.valueOf(
                        faker.number().randomDouble(2, 0, 2000)
                ),
                BigDecimal.valueOf(
                        faker.number().randomDouble(2, 0, 3000)
                ),
                LocalDate.of(
                        faker.number().numberBetween(1970, 2005),
                        faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1, 28)
                )
        );

        // CREATE
        facade.createEmployee(employee2);
        System.out.println("\nSegundo funcionário criado:");
        System.out.println(employee2);

        // FIND ALL
        System.out.println("\nEncontrados(FIND ALL):");
        System.out.println(facade.findAllEmployees());


        // STRATEGY FUNCIONÁRIO 1
        System.out.println("\nRemuneração funcionário 1:");

        System.out.println(
                "Salário: " +
                        facade.calculateCompensation(
                                employee,
                                new BaseSalaryStrategy()
                        )
        );

        System.out.println(
                "Salário + comissão: " +
                        facade.calculateCompensation(
                                employee,
                                new SalaryWithCommissionStrategy()
                        )
        );

        System.out.println(
                "Remuneração total: " +
                        facade.calculateCompensation(
                                employee,
                                new FullCompensationStrategy()
                        )
        );

        // STRATEGY FUNCIONÁRIO 2
        System.out.println("\nRemuneração funcionário 2:");

        System.out.println(
                "Salário: " +
                        facade.calculateCompensation(
                                employee2,
                                new BaseSalaryStrategy()
                        )
        );

        System.out.println(
                "Salário + comissão: " +
                        facade.calculateCompensation(
                                employee2,
                                new SalaryWithCommissionStrategy()
                        )
        );

        System.out.println(
                "Remuneração total: " +
                        facade.calculateCompensation(
                                employee2,
                                new FullCompensationStrategy()
                        )
        );

        // UPDATE
        employee.setSalary(new BigDecimal("6000.00"));
        facade.updateEmployee(employee);

        System.out.println("\nAtualizado(SALARIO = 6000):");
        facade.findEmployeeById(employee.getId())
                .ifPresent(System.out::println);

        // DELETE
        facade.deleteEmployee(employee.getId());

        System.out.println("\nDepois do delete:");
        System.out.println(
                facade.findEmployeeById(employee.getId())
        );

        // FIND ALL
        System.out.println("\nEncontrados(FIND ALL):");
        System.out.println(facade.findAllEmployees());

        // DELETE
        facade.deleteEmployee(employee2.getId());

        System.out.println("\nDepois do delete:");
        System.out.println(
                facade.findEmployeeById(employee2.getId())
        );

        // FIND ALL
        System.out.println("\nEncontrados(FIND ALL)");
        System.out.println(facade.findAllEmployees());

    }
}
