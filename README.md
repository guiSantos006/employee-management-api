# Employee Management API

Projeto desenvolvido em Java para demonstrar a aplicação
de Design Patterns utilizando JDBC e MySQL.

A base do projeto veio de uma inspiração da aula de "JDBC: Explorando Persistência de Dados com Java", 
onde o projeto "jdbc-sample" serviu muito bem de base na parte do banco de dados, mas também como ponto de partida
para explorar outros caminhos. Eu também utilizei o Datafaker apresentado na aula para fazer testes e a
implementação também permitiu transformar conceitos de Design Patterns que eu já conhecia teoricamente 
em uma aplicação prática. O Strategy foi talvez o padrão mais perceptível na elaboração do projeto.

## Tecnologias

- Java
- JDBC
- MySQL
- Flyway
- Gradle
- DataFaker

## Design Patterns

### Repository

Responsável por abstrair o acesso ao banco de dados.

### Strategy

Utilizado para diferentes formas de cálculo da remuneração:

- Salário
- Salário + comissão
- Salário + comissão + bônus

### Facade

Fornece uma interface simplificada para as operações
relacionadas aos funcionários.

### Singleton

Não utilizado, pois não existe no projeto um recurso
que necessite de uma única instância global.

## Funcionalidades

- Criar funcionário
- Buscar funcionário por ID
- Buscar todos os funcionários
- Atualizar funcionário
- Excluir funcionário
- Calcular remuneração utilizando Strategy

## Configuração do banco de dados

O projeto utiliza MySQL.

1. Crie um banco chamado `employee_management`.
2. Renomeie o arquivo:

`application.example.properties`

para:

`application.properties`

3. Configure suas credenciais do MySQL:

```properties
db.url=jdbc:mysql://localhost:3306/employee_management
db.username=root
db.password=YOUR_PASSWORD
