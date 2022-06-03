package com.celine_amireux.CelineBE.controller.admin;

import com.celine_amireux.CelineBE.model.Category;
import com.celine_amireux.CelineBE.services.BlogService;
import com.celine_amireux.CelineBE.services.impl.BlogServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BlogAddController", value = "/Admin/blog/add")
public class BlogAddController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/addBlog.jsp");
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

        response.sendRedirect(request.getContextPath() + "/Admin/category/list");
    }
}
