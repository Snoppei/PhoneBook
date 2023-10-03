package com.company;

import com.company.DBImitation.DataImitation;
import com.company.DBImitation.DataStorage;
import com.company.Person;
import com.company.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataImitation dataImitation = new DataStorage();
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Редактировать контакт");
            System.out.println("4. Поиск по фамилии");
            System.out.println("5. Поиск по номеру телефона");
            System.out.println("6. Вывести все контакты");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            Person newPerson = null;

            switch (choice) {
                case 1:
                    // Ввод и добавление нового контакта
                    System.out.print("Введите имя: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Введите фамилию: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    newPerson = new Person(firstName, lastName);
                    newPerson.addPhoneNumber(phoneNumber);
                    phoneBook.addContact(newPerson);
                    break;

                case 2:
                    // Удаление контакта
                    System.out.print("Введите фамилию для удаления: ");
                    String deleteLastName = scanner.nextLine();
                    List<Person> deletedContacts = phoneBook.searchByLastName(deleteLastName);
                    if (!deletedContacts.isEmpty()) {
                        // Вывести найденные контакты и предложить удалить
                        System.out.println("Найденные контакты:");
                        for (int i = 0; i < deletedContacts.size(); i++) {
                            System.out.println((i + 1) + ". " + deletedContacts.get(i));
                        }
                        System.out.print("Введите номер контакта для удаления: ");
                        int deleteChoice = scanner.nextInt();
                        scanner.nextLine(); // Очистка буфера
                        if (deleteChoice >= 1 && deleteChoice <= deletedContacts.size()) {
                            phoneBook.removeContact(deletedContacts.get(deleteChoice - 1));
                            System.out.println("Контакт удален.");
                        } else {
                            System.out.println("Неверный выбор.");
                        }
                    } else {
                        System.out.println("Контакты с фамилией " + deleteLastName + " не найдены.");
                    }
                    break;

                case 3:
                    // Редактирование контакта
                    System.out.print("Введите фамилию для редактирования: ");
                    String editLastName = scanner.nextLine();
                    List<Person> editedContacts = phoneBook.searchByLastName(editLastName);
                    if (!editedContacts.isEmpty()) {
                        // Вывести найденные контакты и предложить редактировать
                        System.out.println("Найденные контакты:");
                        for (int i = 0; i < editedContacts.size(); i++) {
                            System.out.println((i + 1) + ". " + editedContacts.get(i));
                        }
                        System.out.print("Введите номер контакта для редактирования: ");
                        int editChoice = scanner.nextInt();
                        scanner.nextLine(); // Очистка буфера
                        if (editChoice >= 1 && editChoice <= editedContacts.size()) {
                            Person oldPerson = editedContacts.get(editChoice - 1);
                            System.out.print("Введите новое имя: ");
                            String newFirstName = scanner.nextLine();
                            System.out.print("Введите новую фамилию: ");
                            String newLastName = scanner.nextLine();
                            System.out.print("Введите новый номер телефона: ");
                            String newPhoneNumber = scanner.nextLine();
                            newPerson = new Person(newFirstName, newLastName);
                            newPerson.addPhoneNumber(newPhoneNumber);
                            phoneBook.editContact(oldPerson, newPerson);
                            System.out.println("Контакт отредактирован.");
                        } else {
                            System.out.println("Неверный выбор.");
                        }
                    } else {
                        System.out.println("Контакты с фамилией " + editLastName + " не найдены.");
                    }
                    break;

                case 4:
                    // Поиск по фамилии
                    System.out.print("Введите фамилию для поиска: ");
                    String searchLastName = scanner.nextLine();
                    List<Person> foundByLastName = phoneBook.searchByLastName(searchLastName);
                    if (!foundByLastName.isEmpty()) {
                        System.out.println("Найденные контакты:");
                        for (Person person : foundByLastName) {
                            System.out.println(person);
                        }
                    } else {
                        System.out.println("Контакты с фамилией " + searchLastName + " не найдены.");
                    }
                    break;

                case 5:
                    // Поиск по номеру телефона
                    System.out.print("Введите номер телефона для поиска: ");
                    String searchPhoneNumber = scanner.nextLine();
                    List<Person> foundByPhoneNumber = phoneBook.searchByPhoneNumber(searchPhoneNumber);
                    if (!foundByPhoneNumber.isEmpty()) {
                        System.out.println("Найденные контакты:");
                        for (Person person : foundByPhoneNumber) {
                            System.out.println(person);
                        }
                    } else {
                        System.out.println("Контакты с номером " + searchPhoneNumber + " не найдены.");
                    }
                    break;

                case 6:
                    // Вывести все контакты
                    phoneBook.displayContacts();
                    break;

                case 0:
                    // Выход из приложения
                    System.out.println("Выход из приложения.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверная команда.");
            }
        }
    }
}

