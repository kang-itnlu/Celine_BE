package celine_amireux.com.vn.CelineBE.dao.impl;

import celine_amireux.com.vn.CelineBE.dao.ProductDao;
import celine_amireux.com.vn.CelineBE.jdbc.JDBCConnection;
import celine_amireux.com.vn.CelineBE.model.Category;
import celine_amireux.com.vn.CelineBE.model.Comment;
import celine_amireux.com.vn.CelineBE.model.Product;
import celine_amireux.com.vn.CelineBE.services.CategoryService;
import celine_amireux.com.vn.CelineBE.services.impl.CategoryServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl extends JDBCConnection implements ProductDao {
    CategoryService categortService = new CategoryServiceImpl();

    @Override
    public void insert(Product product) {
        String sql = "INSERT INTO Product(name, price, salePrice, stock,image, cate_id, des,isLiked,rating,soldQuantity,brand,manufacturer,product_detail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setLong(2, product.getPrice());
            ps.setInt(2, product.getStock());
            ps.setLong(3, product.getSalePrice());
            ps.setString(4, product.getImage());
            ps.setInt(5, product.getCategory().getId());
            ps.setString(6, product.getDes());
            ps.setInt(7, product.isLiked());
            ps.setInt(8, product.getRating());
            ps.setInt(9, product.getSoldQuantity());
            ps.setString(10, product.getBrand());
            ps.setString(11, product.getManufacturer());
            ps.setString(12, product.getProduct_detail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product product) {
        String sql = "UPDATE Product SET Product.name = ? , price = ?,stock=?,salePrice=?, image = ?,cate_id=?, des=?,isLiked=?,rating=?,soldQuantity=?,brand=?,manufacturer=?,product_detail=? WHERE id = ?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(2, product.getStock());
            ps.setDouble(3, product.getSalePrice());
            ps.setString(4, product.getImage());
            ps.setInt(5, product.getCategory().getId());
            ps.setString(6, product.getDes());
            ps.setInt(7, product.isLiked());
            ps.setInt(8, product.getRating());
            ps.setInt(9, product.getSoldQuantity());
            ps.setString(10, product.getBrand());
            ps.setString(11, product.getManufacturer());
            ps.setString(12, product.getProduct_detail());
            ps.setInt(13, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Product WHERE id=?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Product get(int id) {
        String sql = "SELECT product.id, product.name AS p_name, product.price,product.stock,product.salePrice, product.image,product.des, category.cate_name AS c_name, category.cate_id AS c_id ,product.isLiked,product.rating,product.soldQuantity,product.brand,product.manufacturer,product.product_detail"
                + " FROM product INNER JOIN category " + "ON product.cate_id = category.cate_id WHERE product.id=?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));

                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSalePrice(rs.getLong("salePrice"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setLiked(rs.getInt("isLiked"));
                product.setRating(rs.getInt("rating"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setBrand(rs.getString("brand"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setProduct_detail(rs.getString("product_detail"));
                return product;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {

        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price,product.stock,product.salePrice, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id,product.isLiked,product.rating,product.soldQuantity,product.brand,product.manufacturer,product.product_detail"
                + " FROM product INNER JOIN category " + "ON product.cate_id = category.cate_id";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSalePrice(rs.getLong("salePrice"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setLiked(rs.getInt("isLiked"));
                product.setRating(rs.getInt("rating"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setBrand(rs.getString("brand"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setProduct_detail(rs.getString("product_detail"));
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM product WHERE name LIKE ? ";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSalePrice(rs.getLong("salePrice"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));

                Category category = new Category();
                category.setId(rs.getInt("c_id"));
                category.setName(rs.getString("c_name"));
                product.setCategory(category);
                product.setLiked(rs.getInt("isLiked"));
                product.setRating(rs.getInt("rating"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setBrand(rs.getString("brand"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setProduct_detail(rs.getString("product_detail"));
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> searchByCategory(int cate_id) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price,product.stock,product.salePrice, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id,product.isLiked,product.rating,product.soldQuantity,product.brand,product.manufacturer,product.product_detail 				 FROM Product join Category   on product.cate_id = category.cate_id where product.cate_id=?";
        Connection conn = getJDBCConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cate_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSalePrice(rs.getLong("salePrice"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                product.setCategory(category);
                product.setLiked(rs.getInt("isLiked"));
                product.setRating(rs.getInt("rating"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setBrand(rs.getString("brand"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setProduct_detail(rs.getString("product_detail"));
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> searchByName(String productName) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price,product.stock,product.salePrice, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id,product.isLiked,product.rating,product.soldQuantity,product.brand,product.manufacturer,product.product_detail  				"
                + " FROM Product , Category   where product.cate_id = category.cate_id and Product.name like ? ";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + productName + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSalePrice(rs.getLong("salePrice"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                product.setCategory(category);
                product.setLiked(rs.getInt("isLiked"));
                product.setRating(rs.getInt("rating"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setBrand(rs.getString("brand"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setProduct_detail(rs.getString("product_detail"));
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> getProductByPage(int currentPage, int productsPerPage) {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price,product.stock,product.salePrice, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id,product.isLiked,product.rating,product.soldQuantity,product.brand,product.manufacturer,product.product_detail"
                + " FROM product INNER JOIN category " + "ON product.cate_id = category.cate_id LIMIT ?,?";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentPage * productsPerPage - productsPerPage);
            ps.setInt(2, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSalePrice(rs.getLong("salePrice"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setLiked(rs.getInt("isLiked"));
                product.setRating(rs.getInt("rating"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setBrand(rs.getString("brand"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setProduct_detail(rs.getString("product_detail"));
                list.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getNoOfProducts() {
        return getAll().size();
    }

    @Override
    public int getCateId(int parseInt) {
        String sql = "SELECT product.cate_id  FROM Product  where product.id=?";
        Connection conn = getJDBCConnection();
        int result = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, parseInt);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getInt("cate_id");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Product> searchByBrand(String brand) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price,product.stock,product.salePrice, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id,product.isLiked,product.rating,product.soldQuantity,product.brand,product.manufacturer,product.product_detail  				"
                + " FROM Product , Category   where product.cate_id = category.cate_id and Product.brand like ? ";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + brand + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSalePrice(rs.getLong("salePrice"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                product.setCategory(category);
                product.setLiked(rs.getInt("isLiked"));
                product.setRating(rs.getInt("rating"));
                product.setSoldQuantity(rs.getInt("soldQuantity"));
                product.setBrand(rs.getString("brand"));
                product.setManufacturer(rs.getString("manufacturer"));
                product.setProduct_detail(rs.getString("product_detail"));
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<String> getMoreImage(int id) {
        ArrayList<String> listImg = new ArrayList<String>();
        String sql = "SELECT url FROM moreimage where product_id=?";
        Connection conn = getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                listImg.add(rs.getString("url"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listImg;
    }

    @Override
    public List<Comment> getAllProductComments(int id) {
        List<Comment> listComment = new ArrayList<Comment>();
        String sql = "SELECT username,avatar,rating,content,time "
                + " FROM Comment " + " WHERE product_id=?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                Comment comment = new Comment();
                comment.setUsername(rs.getString("username"));
                comment.setAvatar(rs.getString("avatar"));
                comment.setRating(rs.getInt("rating"));
                comment.setContent(rs.getString("content"));
                comment.setTime(rs.getDate("time"));
                listComment.add(comment);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listComment;
    }

    public static void main(String[] args) {
        List<Comment> list = new ProductDaoImpl().getAllProductComments(1);
        for (Comment comment : list) {
            System.out.println(comment);
        }
    }

}

