package com.celine_amireux.CelineBE.controller.admin;

import com.celine_amireux.CelineBE.model.Blog;
import com.celine_amireux.CelineBE.services.BlogService;
import com.celine_amireux.CelineBE.services.impl.BlogServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogListController", value = "/Admin/blog/list")
public class BlogListController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Blog> blogList = blogService.getAll();
        request.setAttribute("blogList", blogList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/blogManagement.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
