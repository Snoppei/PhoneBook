package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private List<Person> contacts = new ArrayList<>();

    public void addContact(Person person) {
        contacts.add(person);
        // Сортируем контакты после добавления
        Collections.sort(contacts);
    }

    public void removeContact(Person person) {
        contacts.remove(person);
    }

    public List<Person> searchByLastName(String lastName) {
        List<Person> result = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> searchByPhoneNumber(String phoneNumber) {
        List<Person> result = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getPhoneNumbers().contains(phoneNumber)) {
                result.add(person);
            }
        }
        return result;
    }

    public void editContact(Person oldPerson, Person newPerson) {
        if (contacts.contains(oldPerson)) {
            contacts.remove(oldPerson);
            contacts.add(newPerson);
            // Сортируем контакты после редактирования
            Collections.sort(contacts);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Телефонная книга пуста.");
        } else {
            System.out.println("Список контактов:");
            for (Person person : contacts) {
                System.out.println(person);
            }
        }
    }
}
