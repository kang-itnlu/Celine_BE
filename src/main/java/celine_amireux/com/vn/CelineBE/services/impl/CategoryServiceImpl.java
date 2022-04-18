package celine_amireux.com.vn.CelineBE.services.impl;

import celine_amireux.com.vn.CelineBE.dao.CategoryDao;
import celine_amireux.com.vn.CelineBE.dao.impl.CategoryDaoImpl;
import celine_amireux.com.vn.CelineBE.model.Category;
import celine_amireux.com.vn.CelineBE.model.Product;
import celine_amireux.com.vn.CelineBE.services.CategoryService;

import java.util.List;


public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = (CategoryDao) new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);

    }

    @Override
    public void edit(Category newCategory) {
        Category oldCate = categoryDao.get(newCategory.getId());
        oldCate.setName(newCategory.getName());
        categoryDao.edit(oldCate);

    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);

    }

    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String username) {
        return categoryDao.search(username);
    }


}
