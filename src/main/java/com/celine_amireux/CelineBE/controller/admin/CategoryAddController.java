package com.celine_amireux.CelineBE.controller.admin;

import com.celine_amireux.CelineBE.model.Category;
import com.celine_amireux.CelineBE.services.CategoryService;
import com.celine_amireux.CelineBE.services.impl.CategoryServiceImpl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Admin/category/add"})
public class CategoryAddController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/addCategory.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        Category category = new Category();
        category.setId(Integer.parseInt(id));
        category.setName(name);
        cateService.insert(category);
        response.sendRedirect(request.getContextPath() + "/Admin/category/list");

    }
}

