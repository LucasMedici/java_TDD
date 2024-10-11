package com.javaTDD.ex_02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraSalarioTest {

    @Test
    public void deveCalcularSalarioDesenvolvedorAcimaDe3000() {
        Funcionario desenvolvedor = new Funcionario("João", "joao@empresa.com", 3500.00, Cargo.DESENVOLVEDOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcular(desenvolvedor);
        assertEquals(2800.00, salarioLiquido, 0.01);
    }

    @Test
    public void deveCalcularSalarioDesenvolvedorAbaixoDe3000() {
        Funcionario desenvolvedor = new Funcionario("Maria", "maria@empresa.com", 2500.00, Cargo.DESENVOLVEDOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcular(desenvolvedor);
        assertEquals(2250.00, salarioLiquido, 0.01);
    }

    @Test
    public void deveCalcularSalarioDBAAcimaDe2000() {
        Funcionario dba = new Funcionario("Carlos", "carlos@empresa.com", 2500.00, Cargo.DBA);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcular(dba);
        assertEquals(1875.00, salarioLiquido, 0.01);
    }

    @Test
    public void deveCalcularSalarioGerenteAbaixoDe5000() {
        Funcionario gerente = new Funcionario("Ana", "ana@empresa.com", 4500.00, Cargo.GERENTE);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcular(gerente);
        assertEquals(3600.00, salarioLiquido, 0.01);
    }

}
