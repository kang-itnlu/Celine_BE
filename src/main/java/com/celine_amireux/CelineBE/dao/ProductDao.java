package com.celine_amireux.CelineBE.dao;

import com.celine_amireux.CelineBE.model.Comment;
import com.celine_amireux.CelineBE.model.Product;

import java.util.List;


public interface ProductDao {
    void insert(Product product);

    void edit(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();

    List<Product> search(String username);

    List<Product> searchByCategory(int cate_id);

    List<Product> searchByName(String productName, int currentPage, int productsPerPage);

    List<Product> getProductByPage(int currentPage, int productsPerPage);

    int getNoOfProducts();

    int getCateId(int parseInt);

    List<Product> searchByBrand(String brand, int currentPage, int productsPerPage);

    List<String> getMoreImage(int id);

    List<Comment> getAllProductComments(int id);

    List<Product> searchByPrice(String brand, int priceFrom, int priceTo, int currentPage, int productsPerPage);

    List<Product> searchByRating(int rating,int currentPage,int productsPerPage);
}

