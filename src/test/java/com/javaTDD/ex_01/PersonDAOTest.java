package com.javaTDD.ex_01;

import static org.junit.jupiter.api.Assertions.*;

import com.javaTDD.ex_01.Email;
import com.javaTDD.ex_01.Person;
import com.javaTDD.ex_01.PersonDAO;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOTest {

    @Test
    public void testIsValidToInclude_ValidPerson() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(25);

        List<Email> emails = new ArrayList<>();
        Email email = new Email();
        email.setName("john@example.com");
        emails.add(email);
        person.setEmails(emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.isEmpty());
    }

    @Test
    public void testIsValidToInclude_InvalidName() {
        Person person = new Person();
        person.setName("John");
        person.setAge(25);

        List<Email> emails = new ArrayList<>();
        Email email = new Email();
        email.setName("john@example.com");
        emails.add(email);
        person.setEmails(emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertEquals(1, errors.size());
        assertTrue(errors.contains("Nome inválido: deve conter ao menos duas partes compostas por letras."));
    }

    @Test
    public void testIsValidToInclude_InvalidAge() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(250);

        List<Email> emails = new ArrayList<>();
        Email email = new Email();
        email.setName("john@example.com");
        emails.add(email);
        person.setEmails(emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertEquals(1, errors.size());
        assertTrue(errors.contains("Idade inválida: deve estar entre 1 e 200."));
    }

    @Test
    public void testIsValidToInclude_InvalidEmail() {
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(25);

        List<Email> emails = new ArrayList<>();
        Email email = new Email();
        email.setName("johnexample.com");
        emails.add(email);
        person.setEmails(emails);

        PersonDAO dao = new PersonDAO();
        List<String> errors = dao.isValidToInclude(person);

        assertEquals(1, errors.size());
        assertTrue(errors.contains("Email inválido: deve seguir o formato ___@___.___"));
    }
}
