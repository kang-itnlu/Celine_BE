package celine_amireux.com.vn.CelineBE.controller;

import celine_amireux.com.vn.CelineBE.model.Comment;
import celine_amireux.com.vn.CelineBE.model.User;
import celine_amireux.com.vn.CelineBE.services.CommentService;
import celine_amireux.com.vn.CelineBE.services.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet(name = "CommentController", value = "/comment")
public class CommentController extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        Comment cmt = new Comment();
        String path = "/product/detail?id=" + id;
        if (session != null && session.getAttribute("account") != null) {
            User u = (User) session.getAttribute("account");
            cmt.setUsername(u.getUsername());
            cmt.setProduct_id(id);
            cmt.setAvatar(u.getAvatar());
            cmt.setRating(rating);
            cmt.setContent(request.getParameter("message1"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            cmt.setTime(date);
            ;
            commentService.insert(cmt);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        response.sendRedirect(request.getContextPath() + path);
    }
}
