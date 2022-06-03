package com.celine_amireux.CelineBE.dao;

import com.celine_amireux.CelineBE.model.Cart;

import java.util.List;


public interface CartDao {
    void insert(Cart cart);

    void edit(Cart cart);

    void delete(int id);

    Cart get(String name);

    Cart get(int id);

    List<Cart> getAll();

    List<Cart> search(String name);
}

