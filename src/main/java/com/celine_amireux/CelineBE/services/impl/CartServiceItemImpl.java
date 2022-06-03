package com.celine_amireux.CelineBE.services.impl;

import com.celine_amireux.CelineBE.dao.CartItemDao;
import com.celine_amireux.CelineBE.dao.impl.CartItemDaoImpl;
import com.celine_amireux.CelineBE.model.CartItem;
import com.celine_amireux.CelineBE.services.CartItemService;

import java.util.List;


public class CartServiceItemImpl implements CartItemService {
    CartItemDao cartItemDao = (CartItemDao) new CartItemDaoImpl();

    @Override
    public void insert(CartItem cartItem) {
        cartItemDao.insert(cartItem);

    }

    @Override
    public void edit(CartItem newCartItem) {
        CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
        oldCartItem.setCart(newCartItem.getCart());
        oldCartItem.setProduct(newCartItem.getProduct());
        oldCartItem.setQuantity(newCartItem.getQuantity());
        oldCartItem.setUnitPrice(newCartItem.getUnitPrice());

        cartItemDao.edit(oldCartItem);
    }

    @Override
    public void delete(String id) {
        cartItemDao.delete(id);
    }

    @Override
    public CartItem get(int id) {
        return cartItemDao.get(id);
    }

    @Override
    public List<CartItem> getAll() {
        return cartItemDao.getAll();
    }

    @Override
    public List<CartItem> search(String keyword) {
        return cartItemDao.search(keyword);
    }

    @Override
    public List<CartItem> getByUserID(int id) {
        return cartItemDao.getByUserID(id);
    }


}
