package celine_amireux.com.vn.CelineBE.controller;

import celine_amireux.com.vn.CelineBE.util.Constant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        session.removeAttribute("account"); //remove session

        Cookie[] cookies = request.getCookies();

        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(Constant.COOKIE_REMEMBER.equals(cookie.getName())){
                    cookie.setMaxAge(0); // <=> remove cookie
                    response.addCookie(cookie); // add again
                    break;
                }
            }
        }

        response.sendRedirect("./login");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
