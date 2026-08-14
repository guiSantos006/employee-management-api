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
```

## Exemplo Output (Valores Fictícios utilizando Datafaker)

```
> Task :br.com.gui.Main.main()
Criado:
Employee{id=7, name='Giovanna Banheira', salary=6612.34, commission=1923.81, bonus=582.8, birthday=1990-02-10}

Encontrado:
Employee{id=7, name='Giovanna Banheira', salary=6612.34, commission=1923.81, bonus=582.80, birthday=1990-02-10}

Segundo funcion�rio criado:
Employee{id=8, name='C�sar Fontes', salary=9885.56, commission=427.46, bonus=1130.27, birthday=1998-10-22}

Encontrados(FIND ALL):
[Employee{id=8, name='C�sar Fontes', salary=9885.56, commission=427.46, bonus=1130.27, birthday=1998-10-22}, Employee{id=7, name='Giovanna Banheira', salary=6612.34, commission=1923.81, bonus=582.80, birthday=1990-02-10}]

Remunera��o funcion�rio 1:
Sal�rio: 6612.34
Sal�rio + comiss�o: 8536.15
Remunera��o total: 9118.95

Remunera��o funcion�rio 2:
Sal�rio: 9885.56
Sal�rio + comiss�o: 10313.02
Remunera��o total: 11443.29

Atualizado(SALARIO = 6000):
Employee{id=7, name='Giovanna Banheira', salary=6000.00, commission=1923.81, bonus=582.80, birthday=1990-02-10}

Depois do delete:
Optional.empty

Encontrados(FIND ALL):
[Employee{id=8, name='C�sar Fontes', salary=9885.56, commission=427.46, bonus=1130.27, birthday=1998-10-22}]

Depois do delete:
Optional.empty

Encontrados(FIND ALL)
[]

BUILD SUCCESSFUL in 1s
```
