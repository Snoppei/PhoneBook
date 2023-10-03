package com.company.DBImitation;
import com.company.Person;

import java.util.ArrayList;
import java.util.List;

public class DataStorage implements DataImitation{
    private List<Person> contacts = new ArrayList<>();

    @Override
    public List<Person> loadContacts() {
        return new ArrayList<>(contacts);
    }

    @Override
    public void saveContacts(List<Person> contacts) {
        this.contacts = new ArrayList<>(contacts);
    }
}
