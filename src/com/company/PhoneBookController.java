package com.company;

import com.company.DBImitation.DataStorage;

import java.util.List;
import java.util.Scanner;

public class PhoneBookController {
    private PhoneBook phoneBook;
    private Scanner scanner;

    public PhoneBookController() {
        DataStorage dataImitation = new DataStorage();
        phoneBook = new PhoneBook(dataImitation);
        scanner = new Scanner(System.in);
    }

    public void run() {
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

            switch (choice) {
                case 1:
                    // Ввод и добавление нового контакта
                    System.out.print("Введите имя: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Введите фамилию: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    Person newPerson = new Person(firstName, lastName);
                    newPerson.addPhoneNumber(phoneNumber);
                    phoneBook.addContact(newPerson);
                    break;

                case 2:
                    // Удаление контакта
                    System.out.print("Введите фамилию контакта, который вы хотите удалить: ");
                    String lastNameToRemove = scanner.nextLine();
                    List<Person> personsToDelete = phoneBook.searchByLastName(lastNameToRemove);
                    if (personsToDelete.isEmpty()) {
                        System.out.println("Контакт с фамилией " + lastNameToRemove + " не найден.");
                    } else {
                        //////// доделать
                    }
                    break;

                case 3:
                    // Редактирование контакта
                    System.out.print("Введите фамилию контакта, который вы хотите отредактировать: ");
                    String lastNameToEdit = scanner.nextLine();
                    List<Person> personsToEdit = phoneBook.searchByLastName(lastNameToEdit);
                    if (personsToEdit.isEmpty()) {
                        System.out.println("Контакт с фамилией " + lastNameToEdit + " не найден.");
                    } else {
                        ////////// доделать
                    }
                    break;

                case 4:
                    // Поиск по фамилии
                    System.out.print("Введите фамилию для поиска: ");
                    String searchLastName = scanner.nextLine();
                    List<Person> foundByLastName = phoneBook.searchByLastName(searchLastName);
                    if (foundByLastName.isEmpty()) {
                        System.out.println("Контакты с фамилией " + searchLastName + " не найдены.");
                    } else {
                        for (Person person : foundByLastName) {
                            System.out.println(person);
                        }
                    }
                    break;

                case 5:
                    // Поиск по номеру телефона
                    System.out.print("Введите номер телефона для поиска: ");
                    String searchPhoneNumber = scanner.nextLine();
                    List<Person> foundByPhoneNumber = phoneBook.searchByPhoneNumber(searchPhoneNumber);
                    if (foundByPhoneNumber.isEmpty()) {
                        System.out.println("Контакты с номером телефона " + searchPhoneNumber + " не найдены.");
                    } else {
                        for (Person person : foundByPhoneNumber) {
                            System.out.println(person);
                        }
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

