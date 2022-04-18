package celine_amireux.com.vn.CelineBE.dao;

import celine_amireux.com.vn.CelineBE.model.Product;

import java.util.List;


public interface ProductDao {
    void insert(Product product);

    void edit(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();

    List<Product> search(String username);

    List<Product> searchByCategory(int cate_id);

    List<Product> searchByName(String productName);

    List<Product> getProductByPage(int currentPage, int productsPerPage);

    int getNoOfProducts();

    int getCateId(int parseInt);
}

