package br.com.gui;

import br.com.gui.config.FlywayConfig;
import br.com.gui.model.Employee;
import br.com.gui.repository.EmployeeRepository;
import br.com.gui.repository.EmployeeRepositoryImpl;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Main {

    private final static EmployeeRepository repository = new EmployeeRepositoryImpl();

    private final static Faker faker = new Faker(Locale.of("pt", "BR"));

    public static void main(String[] args) {
        FlywayConfig.migrate();
        System.out.println("Migration executada com sucesso!");

        /*
        // TESTES DO EMPLOYEE REPOSITORY

        var faker = new Faker();

        // Criando 10 usuários para teste
        for (int i = 0; i < 10; i++) {

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

            repository.insert(employee);
            System.out.println(employee);
        }

        // Criando usuário para fazer um CRUD completo
        var employee = new Employee(
                faker.name().fullName(),
                BigDecimal.valueOf(faker.number().randomDouble(2, 1000, 10000)),
                BigDecimal.valueOf(faker.number().randomDouble(2, 0, 2000)),
                BigDecimal.valueOf(faker.number().randomDouble(2, 0, 3000)),
                LocalDate.of(
                        faker.number().numberBetween(1970, 2005),
                        faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1, 28)
                )
        );

        // Inserindo o usuário
        repository.insert(employee);
        System.out.println("Inserido:");
        System.out.println(employee);

        // Selecionando o usuário
        repository.findById(employee.getId())
                .ifPresent(found -> {
                    System.out.println("Encontrado:");
                    System.out.println(found);
                });

        // Atualizando o usuário
        employee.setSalary(new BigDecimal("15000.00"));
        repository.update(employee);
        System.out.println("Atualizado:");
        System.out.println(
                repository.findById(employee.getId())
        );

        // Removendo o usuário
        repository.delete(employee.getId());
        System.out.println("Depois do delete:");
        System.out.println(
                repository.findById(employee.getId())
        );
        */

    }


}
