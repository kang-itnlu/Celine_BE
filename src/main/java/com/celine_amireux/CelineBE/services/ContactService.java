package com.celine_amireux.CelineBE.services;

import com.celine_amireux.CelineBE.model.Contact;

import java.util.List;

public interface ContactService {
    void insert(Contact contact);

    void edit(Contact newContact);

    void delete(int id);

    Contact get(int id);

    List<Contact> getAll();

    List<Contact> search(String name);

}
