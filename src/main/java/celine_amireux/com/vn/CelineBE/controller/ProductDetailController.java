package celine_amireux.com.vn.CelineBE.controller;

import celine_amireux.com.vn.CelineBE.model.Category;
import celine_amireux.com.vn.CelineBE.model.Product;
import celine_amireux.com.vn.CelineBE.services.CategoryService;
import celine_amireux.com.vn.CelineBE.services.ProductService;
import celine_amireux.com.vn.CelineBE.services.impl.CategoryServiceImpl;
import celine_amireux.com.vn.CelineBE.services.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/product/detail")
public class ProductDetailController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productService.get(Integer.parseInt(id));
        int id_cate = productService.getCateId(Integer.parseInt(id));
        List<Product> categories = productService.searchByCategory(id_cate);
        request.setAttribute("categories", categories);

        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/view/product-detail.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);
    }
}
