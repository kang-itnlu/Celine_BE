package celine_amireux.com.vn.CelineBE.controller.admin;

import celine_amireux.com.vn.CelineBE.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminWaiting", value = "/AdminWaiting")
public class AdminWaiting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        if(session != null && session.getAttribute("account") != null) {
            User u=(User) session.getAttribute("account");
            request.setAttribute("username", u.getUsername());
            if(u.getRoleId()==1) {
                response.sendRedirect(request.getContextPath()+"/Admin/Welcome");
            }else {
                response.sendRedirect(request.getContextPath()+"/welcome");
            }

        }else {
            response.sendRedirect(request.getContextPath()+"/AdminLogin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
