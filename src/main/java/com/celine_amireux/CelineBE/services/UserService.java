package com.celine_amireux.CelineBE.services;

import com.celine_amireux.CelineBE.model.User;

import java.util.List;


public interface UserService {
    void insert(User user);

    void edit(User user);

    void delete(int id);

    User get(String username);

    User get(int id);

    User login(String username, String password);

    User loginAdmin(String email, String password);

    boolean register(String email, String password, String username);

    List<User> getAll();

    List<User> search(String keyword);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

}
