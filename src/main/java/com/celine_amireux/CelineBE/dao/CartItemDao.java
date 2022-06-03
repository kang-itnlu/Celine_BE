package com.celine_amireux.CelineBE.dao;


import com.celine_amireux.CelineBE.model.CartItem;

import java.util.List;


public interface CartItemDao {
    void insert(CartItem cartItem);

    void edit(CartItem cartItem);

    void delete(String id);

    CartItem get(String name);

    CartItem get(int id);

    List<CartItem> getAll();

    List<CartItem> search(String name);

    List<CartItem> getByUserID(int id);
}
