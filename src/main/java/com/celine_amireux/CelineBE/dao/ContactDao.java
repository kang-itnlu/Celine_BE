package com.celine_amireux.CelineBE.dao;

import com.celine_amireux.CelineBE.model.Contact;

import java.util.List;

public interface ContactDao {
    void insert(Contact contact);

    void edit(Contact contact);

    void delete(int id);

    Contact get(int id);

    List<Contact> getAll();

    List<Contact> search(String name);
}
