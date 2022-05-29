package celine_amireux.com.vn.CelineBE.services;


import celine_amireux.com.vn.CelineBE.model.Category;
import celine_amireux.com.vn.CelineBE.model.Product;

import java.util.List;


public interface CategoryService {
    void insert(Category category);

    void edit(Category category);

    void delete(int id);

    Category get(int id);

    Category get(String name);

    List<Category> getAll();

    List<Category> search(String username);

}
