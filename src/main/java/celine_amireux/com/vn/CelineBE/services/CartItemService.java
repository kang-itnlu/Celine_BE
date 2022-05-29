package celine_amireux.com.vn.CelineBE.services;

import celine_amireux.com.vn.CelineBE.model.CartItem;

import java.util.List;


public interface CartItemService {
    void insert(CartItem cartItem);

    void edit(CartItem cartItem);

    void delete(String id);

    CartItem get(int id);

    List<CartItem> getAll();

    List<CartItem> search(String keyword);
}
