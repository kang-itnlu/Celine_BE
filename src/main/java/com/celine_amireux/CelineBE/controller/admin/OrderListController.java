package com.celine_amireux.CelineBE.controller.admin;

import com.celine_amireux.CelineBE.model.CartItem;
import com.celine_amireux.CelineBE.services.CartItemService;
import com.celine_amireux.CelineBE.services.CartService;
import com.celine_amireux.CelineBE.services.impl.CartServiceImpl;
import com.celine_amireux.CelineBE.services.impl.CartServiceItemImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Admin/order/list"})
public class OrderListController extends HttpServlet {
    CartItemService cartItemService = new CartServiceItemImpl();
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartItem> listCartItem = cartItemService.getAll();
        req.setAttribute("listCartItem", listCartItem);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/orderManagement.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

