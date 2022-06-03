package com.celine_amireux.CelineBE.controller;

import com.celine_amireux.CelineBE.model.Product;
import com.celine_amireux.CelineBE.services.ProductService;
import com.celine_amireux.CelineBE.services.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductSearchByPrice", value = "/productSearchByPrice")
public class ProductSearchByPrice extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        int productsPerPage = 12;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
         String brand = request.getParameter("brands");
         String priceFrom = request.getParameter("priceFrom");
        String priceTo = request.getParameter("priceTo");
        request.setAttribute("br", brand);
        request.setAttribute("pf", priceFrom);
        request.setAttribute("pt", priceTo);
        List<Product> productSearchByPrice = productService.searchByPrice(brand,Integer.parseInt(priceFrom),Integer.parseInt(priceTo), currentPage, productsPerPage);
        request.setAttribute("productSearchByPrice", productSearchByPrice);
        int numOfProduct = productSearchByPrice.size();
        int numOfPages = numOfProduct / productsPerPage;
        if (numOfPages % productsPerPage > 0) {
            numOfPages++;
        }
        request.setAttribute("numOfPages", numOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productsPerPage", productsPerPage);
        request.getRequestDispatcher("/view/client/view/productSearchByPrice.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
