package com.javaTDD.ex_01;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person person) {
        List<String> errors = new ArrayList<>();

        // Validação do nome
        if (person.getName() == null || !isValidName(person.getName())) {
            errors.add("Nome inválido: deve conter ao menos duas partes compostas por letras.");
        }

        // Validação da idade
        if (person.getAge() < 1 || person.getAge() > 200) {
            errors.add("Idade inválida: deve estar entre 1 e 200.");
        }

        // Validação de emails associados
        if (person.getEmails() == null || person.getEmails().isEmpty()) {
            errors.add("Person deve ter pelo menos um email associado.");
        } else {
            // Validação do formato do email
            for (Email email : person.getEmails()) {
                if (!isValidEmail(email.getName())) {
                    errors.add("Email inválido: deve seguir o formato ___@___.___");
                }
            }
        }

        return errors;
    }

    private boolean isValidName(String name) {
        String[] parts = name.split(" ");
        if (parts.length < 2) {
            return false;
        }
        for (String part : parts) {
            if (!part.matches("[a-zA-Z]+")) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[^@]+@[^@]+\\.[^@]+$");
    }
}
