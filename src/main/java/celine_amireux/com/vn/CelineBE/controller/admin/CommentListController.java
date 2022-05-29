package celine_amireux.com.vn.CelineBE.controller.admin;

import celine_amireux.com.vn.CelineBE.model.Comment;
import celine_amireux.com.vn.CelineBE.services.CommentService;
import celine_amireux.com.vn.CelineBE.services.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CommentListController", value = "/Admin/comment/list")
public class CommentListController extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> commentList = commentService.getAll();
        request.setAttribute("commentList", commentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/commentManagement.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
