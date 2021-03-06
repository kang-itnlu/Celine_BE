package com.celine_amireux.CelineBE.controller.admin;

import com.celine_amireux.CelineBE.services.CommentService;
import com.celine_amireux.CelineBE.services.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CommentDeleteController", value = "/Admin/comment/delete")
public class CommentDeleteController extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        commentService.delete(Integer.parseInt(id));

        response.sendRedirect(request.getContextPath() + "/Admin/comment/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
