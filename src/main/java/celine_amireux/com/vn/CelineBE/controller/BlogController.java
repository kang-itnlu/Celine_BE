package celine_amireux.com.vn.CelineBE.controller;

import celine_amireux.com.vn.CelineBE.model.Blog;
import celine_amireux.com.vn.CelineBE.model.Product;
import celine_amireux.com.vn.CelineBE.services.BlogService;
import celine_amireux.com.vn.CelineBE.services.impl.BlogServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogController", value = "/blog")
public class BlogController extends HttpServlet {
    BlogService blogService = new BlogServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = 1;
        int blogsPerPage = 3;
        if (request.getParameter("page") != null)
            currentPage = Integer.parseInt(
                    request.getParameter("page"));
        List<Blog> blogList = blogService.getBlogByPage(currentPage,blogsPerPage);
        request.setAttribute("blog", blogList);
        int numOfBlog = blogService.numOfBlogs();
        int numOfPages = numOfBlog/ blogsPerPage;
        if(numOfPages % blogsPerPage >0){
            numOfPages++;
        }
        request.setAttribute("numOfPages", numOfPages );
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("blogsPerPage",blogsPerPage);
        request.getRequestDispatcher("/view/client/view/blog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
