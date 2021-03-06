package com.celine_amireux.CelineBE.controller;

import com.celine_amireux.CelineBE.model.User;
import com.celine_amireux.CelineBE.services.UserService;
import com.celine_amireux.CelineBE.services.impl.UserServiceImpl;
import com.celine_amireux.CelineBE.tools.SendEmail;
import com.celine_amireux.CelineBE.util.Constant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }
        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }

        req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        UserService service = new UserServiceImpl();
        String alertMsg = "";
        if (email == "" || password == "" || username == "") {
            alertMsg = "Vui l??ng kh??ng ????? tr???ng c??c ??!";
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }
        if (service.checkExistEmail(email)) {
            alertMsg = "Email ???? t???n t???i!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }
        if (service.checkExistUsername(username)) {
            alertMsg = "T??n ng?????i d??ng ???? t???n t???i!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }
        if (password.length() <= 6) {
            alertMsg = "M???t kh???u ph???i c?? ??t nh???t 6 k?? t???!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
            return;
        }

//        boolean isSuccess = service.register(username, SecurityUtils.hash(password), email);

//        if (isSuccess) {
        SendEmail sm = new SendEmail();
        String code = sm.getRandom();
        User user = new User(email, username, code, password);
        sm.sendMail(email, "Celine-Email of verification", "Welcome to Celine. Here is your verification code: " + user.getCode() + " .Thanks !");
        HttpSession session = req.getSession();
        session.setAttribute("authcode", user);
        resp.sendRedirect(req.getContextPath() + "/redirect");
//        } else {
//            alertMsg = "System error!";
//            req.setAttribute("alert", alertMsg);
//            req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);

    }
}
