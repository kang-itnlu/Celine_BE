package celine_amireux.com.vn.CelineBE.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import celine_amireux.com.vn.CelineBE.model.Product;
import celine_amireux.com.vn.CelineBE.services.ProductService;
import celine_amireux.com.vn.CelineBE.services.impl.ProductServiceImpl;

@WebServlet(urlPatterns="/product/search")
public class ProductSearchByName extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        List<Product> productSearchByName =productService.searchByName(name);
        request.setAttribute("productSearchByName", productSearchByName);
        request.getRequestDispatcher("/view/client/view/product-search-by-name.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doGet(request, response);
    }
}
