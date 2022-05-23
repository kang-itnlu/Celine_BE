package celine_amireux.com.vn.CelineBE.services.impl;

import celine_amireux.com.vn.CelineBE.dao.ProductDao;
import celine_amireux.com.vn.CelineBE.dao.impl.ProductDaoImpl;
import celine_amireux.com.vn.CelineBE.model.Product;
import celine_amireux.com.vn.CelineBE.services.ProductService;

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
    public List<Product> searchByName(String productName) {
        return productDao.searchByName(productName);
    }

    @Override
    public List<Product> getProductByPage(int currentPage, int productsPerPage) {
        return productDao.getProductByPage(currentPage,productsPerPage);
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
    public List<Product> searchByBrand(String brand) {
        return productDao.searchByBrand(brand);
    }

}
