package com.celine_amireux.CelineBE.controller.admin;

import com.celine_amireux.CelineBE.services.CartItemService;
import com.celine_amireux.CelineBE.services.impl.CartServiceItemImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Admin/order/delete")
public class OrderDeleteController extends HttpServlet {
    CartItemService cartItemService = new CartServiceItemImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        cartItemService.delete(id);
        response.sendRedirect(request.getContextPath() + "/Admin/order/list");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

