package celine_amireux.com.vn.CelineBE.controller;

import celine_amireux.com.vn.CelineBE.model.Contact;
import celine_amireux.com.vn.CelineBE.services.ContactService;
import celine_amireux.com.vn.CelineBE.services.impl.ContactServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "SendContactController", value = "/sendContact")
public class SendContactController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        String alert = "";
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        Contact contact = new Contact(random.nextInt(1000), name, email, title, message);
        ContactService contactService = new ContactServiceImpl();
        contactService.insert(contact);
        alert = "Đã gửi liên hệ thành công!";
        request.setAttribute("alert", alert);
        request.getRequestDispatcher("view/client/view/contact-us.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
