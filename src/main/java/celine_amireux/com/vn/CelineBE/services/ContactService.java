package celine_amireux.com.vn.CelineBE.services;

import celine_amireux.com.vn.CelineBE.model.Contact;
import celine_amireux.com.vn.CelineBE.model.Product;

import java.util.List;

public interface ContactService {
    void insert(Contact contact);

    void edit(Contact newContact);

    void delete(int id);

   Contact get(int id);

    List<Contact> getAll();

    List<Contact> search(String name);

}
