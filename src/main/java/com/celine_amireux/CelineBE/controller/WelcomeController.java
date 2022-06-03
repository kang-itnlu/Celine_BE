package com.celine_amireux.CelineBE.controller;

import com.celine_amireux.CelineBE.model.Product;
import com.celine_amireux.CelineBE.services.CategoryService;
import com.celine_amireux.CelineBE.services.ProductService;
import com.celine_amireux.CelineBE.services.impl.CategoryServiceImpl;
import com.celine_amireux.CelineBE.services.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/welcome")

public class WelcomeController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//                1: gợi ý hôm nay
//                2: Tìm kiếm nhiều
//                3: Sale sập sàn
//                4: Freeship
//                  5: Bán chạy cuối tuần
        List<Product> listToday = productService.searchByCategory(1);
        List<Product> listSearch = productService.searchByCategory(2);
        List<Product> listSale = productService.searchByCategory(3);
        List<Product> listFreeship = productService.searchByCategory(4);
        List<Product> listHotWeek = productService.searchByCategory(5);
        List<Product> listShow = productService.searchByCategory(6);
        request.setAttribute("pwelcome", listShow);
        request.setAttribute("ptoday", listToday);
        request.setAttribute("psearch", listSearch);
        request.setAttribute("psale", listSale);
        request.setAttribute("pfreeship", listFreeship);
        request.setAttribute("photWeek", listHotWeek);
        request.getRequestDispatcher("/view/client/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
