package celine_amireux.com.vn.CelineBE.dao;


import celine_amireux.com.vn.CelineBE.model.CartItem;

import java.util.List;



public interface CartItemDao {
    void insert(CartItem cartItem);

    void edit(CartItem cartItem);

    void delete(String id);

    CartItem get(String name);

    CartItem get(int id);

    List<CartItem> getAll();

    List<CartItem> search(String name);
}
