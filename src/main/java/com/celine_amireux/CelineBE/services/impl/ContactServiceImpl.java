package com.celine_amireux.CelineBE.services.impl;

import com.celine_amireux.CelineBE.dao.ContactDao;
import com.celine_amireux.CelineBE.dao.impl.ContactDaoImpl;
import com.celine_amireux.CelineBE.model.Contact;
import com.celine_amireux.CelineBE.services.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDao contactDao = new ContactDaoImpl();

    @Override
    public void insert(Contact contact) {
        contactDao.insert(contact);
    }

    @Override
    public void edit(Contact newContact) {
        Contact oldContact = contactDao.get(newContact.getId());

        oldContact.setName(newContact.getName());
        oldContact.setEmail(newContact.getEmail());
        oldContact.setTitle(newContact.getTitle());
        oldContact.setMessage(newContact.getMessage());


        contactDao.edit(oldContact);

    }

    @Override
    public void delete(int id) {
        contactDao.delete(id);
    }

    @Override
    public Contact get(int id) {
        return contactDao.get(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactDao.getAll();
    }

    @Override
    public List<Contact> search(String name) {
        return contactDao.search(name);
    }
}
