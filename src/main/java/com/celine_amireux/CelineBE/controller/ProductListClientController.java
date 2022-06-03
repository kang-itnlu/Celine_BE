package com.celine_amireux.CelineBE.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.celine_amireux.CelineBE.model.Product;
import com.celine_amireux.CelineBE.services.CategoryService;
import com.celine_amireux.CelineBE.services.ProductService;
import com.celine_amireux.CelineBE.services.impl.CategoryServiceImpl;
import com.celine_amireux.CelineBE.services.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/product/list"})
public class ProductListClientController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        int productsPerPage = 12;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
        List<Product> productList = productService.getProductByPage(currentPage, productsPerPage);
//        Collections.sort(productList, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return o1.getSalePrice()>o2.getSalePrice() ? -1: (o1.getSalePrice()<o2.getSalePrice())?1:0;
//            }
//        });
        request.setAttribute("productList", productList);
        int numOfProduct = productService.numOfProducts();
        int numOfPages = numOfProduct / productsPerPage;
        if (numOfPages % productsPerPage > 0) {
            numOfPages++;
        }
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productsPerPage", productsPerPage);

//        List<Product> productList = productService.getAll();
//        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/view/product-list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}