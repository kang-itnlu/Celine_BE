package com.celine_amireux.CelineBE.controller;

import com.celine_amireux.CelineBE.model.CartItem;
import com.celine_amireux.CelineBE.model.Product;
import com.celine_amireux.CelineBE.model.User;
import com.celine_amireux.CelineBE.services.CartItemService;
import com.celine_amireux.CelineBE.services.CartService;
import com.celine_amireux.CelineBE.services.UserService;
import com.celine_amireux.CelineBE.services.impl.CartServiceImpl;
import com.celine_amireux.CelineBE.services.impl.CartServiceItemImpl;
import com.celine_amireux.CelineBE.services.impl.UserServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/member/myAccount"})
public class MyAccountController extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CartItemService cartItemService = new CartServiceItemImpl();
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CartItem> listCartItem = new ArrayList<CartItem>();
        String id = request.getParameter("id");
        listCartItem = cartItemService.getByUserID(Integer.parseInt(id));
        String idCart = listCartItem.get(0).getId();
        request.setAttribute("idCart", idCart);
        request.setAttribute("listCartItem",listCartItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/view/myAccount.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = "";
        User user = new User();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    id = item.getString();
                    user.setId(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("email")) {
                    user.setEmail(item.getString());
                } else if (item.getFieldName().equals("username")) {
                    user.setUsername(item.getString());
                } else if (item.getFieldName().equals("password")) {
                    user.setPassword(item.getString());
                } else if (item.getFieldName().equals("role")) {
                    user.setRoleId(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("avatar")) {
                    if (item.getSize() > 0) {// neu co file d
                        final String dir = "E:\\upload";
                        String originalFileName = item.getName();
                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;
                        File file = new File(dir + "/" + fileName);
                        item.write(file);

                        user.setAvatar(fileName);
                    } else {
                        user.setAvatar(null);
                    }
                }
            }

            userService.edit(user);
            User u = userService.get(Integer.parseInt(id));
            HttpSession session = request.getSession(true);
            session.setAttribute("account", u);

            response.sendRedirect(request.getContextPath() + "/member/myAccount");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/member/myAccount");
        }

    }
}
