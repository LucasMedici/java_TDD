package com.javaTDD.ex_02;

import com.javaTDD.ex_02.Cargo;
import com.javaTDD.ex_02.Funcionario;

public class CalculadoraSalario {

    public double calcular(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        Cargo cargo = funcionario.getCargo();

        if (cargo == Cargo.DESENVOLVEDOR) {
            if (salarioBase >= 3000.00) {
                return salarioBase * 0.80;
            } else {
                return salarioBase * 0.90;
            }
        } else if (cargo == Cargo.DBA || cargo == Cargo.TESTADOR) {
            if (salarioBase >= 2000.00) {
                return salarioBase * 0.75;
            } else {
                return salarioBase * 0.85;
            }
        } else if (cargo == Cargo.GERENTE) {
            if (salarioBase >= 5000.00) {
                return salarioBase * 0.70;
            } else {
                return salarioBase * 0.80;
            }
        }

        throw new IllegalArgumentException("Cargo inválido");
    }
}
