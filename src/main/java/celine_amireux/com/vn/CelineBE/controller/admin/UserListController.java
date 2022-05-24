package celine_amireux.com.vn.CelineBE.controller.admin;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import celine_amireux.com.vn.CelineBE.model.User;
import celine_amireux.com.vn.CelineBE.services.UserService;
import celine_amireux.com.vn.CelineBE.services.impl.UserServiceImpl;
@WebServlet(urlPatterns= {"/Admin/user/list"})
public class UserListController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.getAll();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/accountManagement.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}