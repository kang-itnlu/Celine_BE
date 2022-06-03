package com.celine_amireux.CelineBE.services.impl;

import com.celine_amireux.CelineBE.dao.ProductDao;
import com.celine_amireux.CelineBE.dao.impl.ProductDaoImpl;
import com.celine_amireux.CelineBE.model.Comment;
import com.celine_amireux.CelineBE.model.Product;
import com.celine_amireux.CelineBE.services.ProductService;

import java.io.File;
import java.util.List;


public class ProductServiceImpl implements ProductService {
    ProductDao productDao = (ProductDao) new ProductDaoImpl();

    @Override
    public void insert(Product product) {
        productDao.insert(product);

    }

    @Override
    public void edit(Product newProduct) {
        Product oldProduct = productDao.get(newProduct.getId());

        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setCategory(newProduct.getCategory());
        if (newProduct.getImage() != null) {
            // XOA ANH CU DI
            String fileName = oldProduct.getImage();
            final String dir = "F:\\upload";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }

            oldProduct.setImage(newProduct.getImage());
        }

        productDao.edit(oldProduct);

    }

    @Override
    public void delete(int id) {
        productDao.delete(id);

    }

    @Override
    public Product get(int id) {
        return productDao.get(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> search(String product) {
        return productDao.search(product);
    }

    @Override
    public List<Product> searchByCategory(int cate_id) {
        return productDao.searchByCategory(cate_id);
    }

    @Override
    public List<Product> searchByName(String productName, int currentPage, int productsPerPage) {
        return productDao.searchByName(productName, currentPage, productsPerPage);
    }

    @Override
    public List<Product> getProductByPage(int currentPage, int productsPerPage) {
        return productDao.getProductByPage(currentPage, productsPerPage);
    }

    @Override
    public int numOfProducts() {
        return productDao.getNoOfProducts();
    }

    @Override
    public int getCateId(int parseInt) {
        return productDao.getCateId(parseInt);
    }

    @Override
    public List<Comment> getAllProductComments(int id) {
        return productDao.getAllProductComments(id);
    }

    @Override
    public List<Product> searchByBrand(String brand, int currentPage, int productsPerPage) {
        return productDao.searchByBrand(brand, currentPage, productsPerPage);
    }

    @Override
    public List<String> getMoreImage(int id) {
        return productDao.getMoreImage(id);
    }

    @Override
    public List<Product> searchByPrice(String brand, int priceFrom, int priceTo, int currentPage, int productsPerPage) {
        return productDao.searchByPrice(brand, priceFrom, priceTo, currentPage,productsPerPage);
    }

    @Override
    public List<Product> searchByRating(int rating, int currentPage, int productsPerPage) {
        return productDao.searchByRating(rating,currentPage,productsPerPage);
    }

}
