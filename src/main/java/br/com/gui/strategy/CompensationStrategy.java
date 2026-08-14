package br.com.gui.strategy;

import br.com.gui.model.Employee;

import java.math.BigDecimal;

public interface CompensationStrategy {

    BigDecimal calculate(Employee employee);

}
