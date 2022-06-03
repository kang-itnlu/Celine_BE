package com.celine_amireux.CelineBE.controller;

import com.celine_amireux.CelineBE.model.Product;
import com.celine_amireux.CelineBE.services.ProductService;
import com.celine_amireux.CelineBE.services.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductSearchByBrand", value = "/productSearchByBrand")
public class ProductSearchByBrand extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        int productsPerPage = 12;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
        final String brand = request.getParameter("brands");
        request.setAttribute("brand", brand);
        List<Product> productSearchByBrand = productService.searchByBrand(brand, currentPage, productsPerPage);
        request.setAttribute("productSearchByBrand", productSearchByBrand);
        int numOfProduct = productSearchByBrand.size();
        int numOfPages = numOfProduct / productsPerPage;
        if (numOfPages % productsPerPage > 0) {
            numOfPages++;
        }
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productsPerPage", productsPerPage);

        request.getRequestDispatcher("/view/client/view/productSearchByBrand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
