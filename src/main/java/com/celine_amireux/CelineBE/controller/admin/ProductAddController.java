package com.celine_amireux.CelineBE.controller.admin;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.celine_amireux.CelineBE.model.Product;
import com.celine_amireux.CelineBE.services.CategoryService;
import com.celine_amireux.CelineBE.services.ProductService;
import com.celine_amireux.CelineBE.services.impl.CategoryServiceImpl;
import com.celine_amireux.CelineBE.services.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/Admin/product/add"})
public class ProductAddController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("User") == null) {
//            String errorString = "Bạn cần đăng nhập trước";
//            request.setAttribute("errorString", errorString);
//            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
//            dispatcher.forward(request, response);
//        } else {
//
//            String errorString = null;
//            ArrayList<Category> list = null;
//
//            try {
//                list = categoryBO.listCategory();
//            } catch (Exception e) {
//                e.printStackTrace();
//                errorString = e.getMessage();
//            }
//            if (request.getAttribute("errorString") != null) {
//                errorString = (String) request.getAttribute("errorString");
//            }
//            // Lưu thông tin vào request attribute trước khi forward sang views.
//            request.setAttribute("errorString", errorString);
//            request.setAttribute("categoryList", list);
//            request.getSession().setAttribute("Check", "AddBook");
//            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/add_book.jsp");
//            dispatcher.forward(request, response);
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view/addProduct.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String des = request.getParameter("des");
        int category = Integer.parseInt(request.getParameter("category"));


        Part file = request.getPart("image");
//		String path = getServletContext().getRealPath("/") + "Resources/images/";
        String savePath = getServletContext().getRealPath("/") + "view\\admin\\static\\dist\\img";
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String fileName = extractfilename(file);
        file.write(savePath + File.separator + fileName);
//		String filePath = savePath + File.separator + fileName;
        Product pro = new Product();
        pro.setName(name);
        pro.setPrice(Integer.parseInt(price));
        pro.setStock(Integer.parseInt(stock));
        pro.setDes(des);
        pro.setCategory(categoryService.get(category));

        productService.insert(pro);
        request.setAttribute("errorString", "Thêm sách thành công");
        doGet(request, response);
    }

    private String extractfilename(Part file) {
        String cd = file.getHeader("content-disposition");
        String[] items = cd.split(";");
        for (String string : items) {
            if (string.trim().startsWith("filename")) {
                return string.substring(string.indexOf("=") + 2, string.length() - 1);
            }
        }
        return "";
    }


}

