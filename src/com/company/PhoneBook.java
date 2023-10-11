package com.company;

import com.company.DBImitation.DataStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private List<Person> contacts;
    private DataStorage dataImitation;

    public PhoneBook(DataStorage dataImitation) {
        this.dataImitation = dataImitation;
        // Загружаем контакты при создании экземпляра PhoneBook
        contacts = dataImitation.loadContacts();
    }

    public void addContact(Person person) {
        contacts.add(person);
        Collections.sort(contacts);
        // Сохраняем контакты после добавления
        dataImitation.saveContacts(contacts);
    }

    public void removeContact(Person person) {
        contacts.remove(person);
        // Сохраняем контакты после удаления
        dataImitation.saveContacts(contacts);
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
            Collections.sort(contacts);
            // Сохраняем контакты после редактирования
            dataImitation.saveContacts(contacts);
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
