package com.celine_amireux.CelineBE.controller;

import com.celine_amireux.CelineBE.model.User;
import com.celine_amireux.CelineBE.services.UserService;
import com.celine_amireux.CelineBE.services.impl.UserServiceImpl;
import com.celine_amireux.CelineBE.tools.SendEmail;
import com.celine_amireux.CelineBE.util.Constant;
import com.celine_amireux.CelineBE.util.SecurityUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VerifyController", value = "/verify")
public class VerifyController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("authcode");

        String code = request.getParameter("code");
        SendEmail sm = new SendEmail();
        if (code.equals(user.getCode())) {
            userService.register(user.getEmail(), user.getUsername(), SecurityUtils.hash(user.getPassword()));
            sm.sendMail(user.getEmail(), "Celine-Welcome", "Welcome to Celine. Your account has been verified!");

            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            sm.sendMail(user.getEmail(), "Celine-Welcome", "Welcome to Celine. Failed to verify your account!");

            request.getRequestDispatcher(Constant.Path.REGISTER).forward(request, response);
        }
    }
}
