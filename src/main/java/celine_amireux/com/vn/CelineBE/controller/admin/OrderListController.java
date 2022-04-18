package celine_amireux.com.vn.CelineBE.controller.admin;

import celine_amireux.com.vn.CelineBE.model.CartItem;
import celine_amireux.com.vn.CelineBE.services.CartItemService;
import celine_amireux.com.vn.CelineBE.services.CartService;
import celine_amireux.com.vn.CelineBE.services.impl.CartServiceImpl;
import celine_amireux.com.vn.CelineBE.services.impl.CartServiceItemImpl;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns= {"/admin/order/list"})
public class OrderListController extends HttpServlet {
    CartItemService cartItemService=new CartServiceItemImpl();
    CartService cartService=new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartItem> listCartItem =cartItemService.getAll();
        req.setAttribute("listCartItem", listCartItem);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/view/list-order.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

