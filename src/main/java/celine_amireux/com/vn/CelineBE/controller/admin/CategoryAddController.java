package celine_amireux.com.vn.CelineBE.controller.admin;

import celine_amireux.com.vn.CelineBE.model.Category;
import celine_amireux.com.vn.CelineBE.services.CategoryService;
import celine_amireux.com.vn.CelineBE.services.impl.CategoryServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Admin/category/add" })
public class CategoryAddController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/addCategory.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");


        Category category = new Category();
        category.setName(name);


        cateService.insert(category);

        response.sendRedirect(request.getContextPath() + "/Admin/category/list");

    }
}

