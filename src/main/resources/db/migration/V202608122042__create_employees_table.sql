CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL CHECK (salary >= 0),
    commission DECIMAL(10, 2) CHECK (commission >= 0),
    bonus DECIMAL(10, 2) CHECK (bonus >= 0),
    birthday DATE NOT NULL
);