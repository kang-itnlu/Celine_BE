package com.celine_amireux.CelineBE.controller.admin;

import com.celine_amireux.CelineBE.model.User;
import com.celine_amireux.CelineBE.services.UserService;
import com.celine_amireux.CelineBE.services.impl.UserServiceImpl;
import com.celine_amireux.CelineBE.util.Constant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginController", value = "/AdminLogin")
public class AdminLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath() + "/AdminWaiting");
            return;
        }
        // Check cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/AdminWaiting");
                    return;
                }
            }
        }
        request.getRequestDispatcher("/view/admin/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        String password = request.getParameter("password");

        boolean isRememberMe = false;
        String remember = request.getParameter("remember");

        if ("on".equals(remember)) {
            isRememberMe = true;
        }
        String alertMsg = "";

        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Vui lòng không để trống các ô bên dưới!";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/view/admin/view/login.jsp").forward(request, response);
            return;
        }

        UserService service = new UserServiceImpl();

        User user = service.login(username, password);


        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);

            if (isRememberMe) {
                saveRememberMe(response, username);
            }

            response.sendRedirect(request.getContextPath() + "/AdminWaiting");

        } else {
            alertMsg = "Sai thông tin đăng nhập";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/view/admin/view/login.jsp").forward(request, response);
        }
    }

    private void saveRememberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }
}

