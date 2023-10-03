package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private List<String> phoneNumbers = new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPhoneNumbers() {
        return Collections.unmodifiableList(phoneNumbers);
    }

    public void addPhoneNumber(String phoneNumber) {
        if (phoneNumbers.size() < 3) {
            phoneNumbers.add(phoneNumber);
        } else {
            System.out.println("Нельзя добавить больше трех номеров телефонов.");
        }
    }

    public void removePhoneNumber(String phoneNumber) {
        phoneNumbers.remove(phoneNumber);
    }

    @Override
    public int compareTo(Person other) {
        // Сравниваем по фамилии, затем по имени, и если они совпадают, сравниваем по номерам телефонов
        int lastNameComparison = lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        int firstNameComparison = firstName.compareTo(other.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        // Сравниваем номера телефонов
        for (int i = 0; i < phoneNumbers.size(); i++) {
            if (i >= other.phoneNumbers.size()) {
                return 1; // У текущего контакта больше номеров телефонов
            }
            int phoneNumberComparison = phoneNumbers.get(i).compareTo(other.phoneNumbers.get(i));
            if (phoneNumberComparison != 0) {
                return phoneNumberComparison;
            }
        }

        if (phoneNumbers.size() < other.phoneNumbers.size()) {
            return -1; // У текущего контакта меньше номеров телефонов
        } else {
            return 0; // Контакты идентичны
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstName).append(" ").append(lastName).append(": ");
        for (String phoneNumber : phoneNumbers) {
            builder.append(phoneNumber).append(", ");
        }
        // Удаляем последнюю запятую и пробел
        if (!phoneNumbers.isEmpty()) {
            builder.delete(builder.length() - 2, builder.length());
        }
        return builder.toString();
    }
}

