package com.company.DBImitation;

import java.util.List;
import com.company.Person;

public interface DataImitation {
    List<Person> loadContacts();

    void saveContacts(List<Person> contacts);
}
