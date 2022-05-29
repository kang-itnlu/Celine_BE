package celine_amireux.com.vn.CelineBE.controller;

import celine_amireux.com.vn.CelineBE.model.Cart;
import celine_amireux.com.vn.CelineBE.model.CartItem;
import celine_amireux.com.vn.CelineBE.model.User;
import celine_amireux.com.vn.CelineBE.services.CartItemService;
import celine_amireux.com.vn.CelineBE.services.CartService;
import celine_amireux.com.vn.CelineBE.services.UserService;
import celine_amireux.com.vn.CelineBE.services.impl.CartServiceImpl;
import celine_amireux.com.vn.CelineBE.services.impl.CartServiceItemImpl;
import celine_amireux.com.vn.CelineBE.services.impl.UserServiceImpl;
import celine_amireux.com.vn.CelineBE.tools.SendEmail;
import celine_amireux.com.vn.CelineBE.util.RandomUUID;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CartService cartService = new CartServiceImpl();
    CartItemService cartItemService = new CartServiceItemImpl();
    long time = System.currentTimeMillis();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("account");
        User buyer = (User) obj;
        Cart cart = new Cart();
        cart.setBuyer(buyer);
        cart.setBuyDate(new java.sql.Date(time));
        cart.setId(RandomUUID.getRandomID());
        cartService.insert(cart);

        Object objCart = session.getAttribute("cart");
        if (objCart != null) {
            // ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
            Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;

            for (CartItem cartItem : map.values()) {
                cartItem.setCart(cart);
                cartItem.setId(RandomUUID.getRandomID());
                SendEmail sm = new SendEmail();
                sm.sendMail(cart.getBuyer().getEmail(), "Celine", "Payment success. We will contact you soon ! ");
                cartItemService.insert(cartItem);

            }

        }
        session.removeAttribute("cart");
        resp.sendRedirect(req.getContextPath() + "/welcome");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
