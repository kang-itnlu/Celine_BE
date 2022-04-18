package celine_amireux.com.vn.CelineBE.controller;

import celine_amireux.com.vn.CelineBE.model.Product;
import celine_amireux.com.vn.CelineBE.services.ProductService;
import celine_amireux.com.vn.CelineBE.services.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/product/category")
public class ProductSearchByCategory extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cate_id=request.getParameter("cate_id");
        List<Product> productSearchByCategory =productService.searchByCategory(Integer.parseInt(cate_id));
        request.setAttribute("productSearchByCategory", productSearchByCategory);
        request.getRequestDispatcher("/view/client/view/productSearchByCategory.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
