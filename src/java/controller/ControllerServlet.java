/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cart.ShoppingCart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.*;
import java.util.ArrayList;
import session_bean.*;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import client.TryOn;
@WebServlet(name = "ControllerServlet",
        urlPatterns = {"/ControllerServlet",
            "/category",
            "/product",
            "/addToCart",
            "/viewCart",
            "/contact",
            "/login",
            "/register",
            "/logout",
            "/tryOn"
        })
public class ControllerServlet extends HttpServlet {

    @EJB
    private ProductSessionBean ProductSB;
    @EJB
    private ProductDetailSessionBean ProductDetailSB;
    @EJB
    private UserSessionBean UserSB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();

        if (userPath.equals("/login")) {
            request.setAttribute("title", "Login");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username != null) {
                KhachHang user = null;
                try {
                    user = UserSB.FindByUserName(username);
                } catch (Exception e) {

                }
                if (user == null) {
                    request.setAttribute("error", "Invalid User Name");
                } else {
                    if (!user.getMatKhau().equals(password)) {
                        request.setAttribute("error", "Wrong Password");
                    } else {
                        session.setAttribute("user", user);
                        userPath = "/index";
                    }
                }
            }
        }

        if (userPath.equals("/logout")) {
            session.setAttribute("user", null);
            userPath = "/index";
        }
        if (userPath.equals("/profile")) {
          request.setAttribute("title", "Profile");
        }
        if (userPath.equals("/register")) {
            request.setAttribute("title", "Register");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            if (username != null) {
                KhachHang user = new KhachHang(username, username, password, name, address);
                user.setSoDT(phone);
                user.setEmail(username);
                try {
                    UserSB.Insert(user);
                    userPath = "/index";
                    session.setAttribute("user", user);
                } catch (Exception e) {
                    request.setAttribute("error", "Email has been used");
                }
            }
        }

        if (userPath.equals("/category")) {
            String categoryId = request.getQueryString();
            //System.out.println(userPath);
            if (categoryId.equals("Sale")) {
                List<SanPham> categoryProducts;
                categoryProducts = (List<SanPham>) ProductSB.findRange(new int[]{0, 9});
                session.setAttribute("categoryProducts", categoryProducts);
                session.setAttribute("try", "false");
                request.setAttribute("title", categoryId);
            } 
            else if(categoryId.equals("TryClothes")){
                List<SanPham> categoryProducts;
                categoryProducts = new ArrayList<>();
                categoryProducts.add(new SanPham("7", "T-Shirt", "ab", "top", 100000, "do", 7,"NMCNPM/7.jpg"));
                categoryProducts.add(new SanPham("8", "Ao ren xanh dam", "ab", "top", 80000, "do", 8,"NMCNPM/8.jpg"));
                categoryProducts.add(new SanPham("9", "So mi dai tay", "ab", "top", 60000, "do",9,"NMCNPM/9.jpg"));
                categoryProducts.add(new SanPham("1", "Ao thun do dai tay", "ab", "top", 200000, "do", 1,"NMCNPM/1.jpg"));
                categoryProducts.add(new SanPham("2", "Ao thun xam dai tay", "ab", "top", 800000, "do", 2,"NMCNPM/2.jpg"));
                categoryProducts.add(new SanPham("3", "Ao thun do ngan tay", "ab", "top", 900000, "do", 3,"NMCNPM/3.jpg"));
                categoryProducts.add(new SanPham("4", "Ao thun xam ngan tay", "ab", "top", 1200000, "do", 4,"NMCNPM/4.jpg"));
                categoryProducts.add(new SanPham("5", "Ao ngan tay", "ab", "top", 700000, "do", 5,"NMCNPM/5.jpg"));
                categoryProducts.add(new SanPham("6", "Ao den", "ab", "top", 60000, "do", 6,"NMCNPM/6.jpg"));

                session.setAttribute("try", "true");
                
                session.setAttribute("categoryProducts", categoryProducts);
                request.setAttribute("title", categoryId);
            
            }
            
            else if (categoryId != null) {
                List<SanPham> categoryProducts;
                categoryProducts = (List<SanPham>) ProductSB.FindByCategory(categoryId);
                session.setAttribute("categoryProducts", categoryProducts);
                session.setAttribute("try", "false");
                request.setAttribute("title", categoryId);
            }

        }
        if (userPath.equals("/tryOn")) {
        
            // if user is adding item to cart for first time
            // create cart object and attach it to user session
            String id = request.getQueryString();
            TryOn tt = new TryOn();
            String link = "";
            link = tt.tryOn(Integer.parseInt(id));
            session.setAttribute("link", link);
            request.setAttribute("title", "Result Try-on");
        }
        if (userPath.equals("/product")) {
            String productId = request.getQueryString();
            if (productId != null) {
                SanPham product;
                product = (SanPham) ProductSB.find(productId);
                session.setAttribute("product", product);
                LinkAnh images;
                images = (LinkAnh) ProductDetailSB.find(productId);
                if (images == null) {
                    System.out.println("null");
                }
                session.setAttribute("images", images);
                request.setAttribute("title", "Product");
            }
        }

        if (userPath.equals("/viewCart")) {
            String clear = request.getParameter("clear");
            request.setAttribute("title", "View Cart");
            if ((clear != null) && clear.equals("true")) {
                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                if (cart == null) {
                    cart = new ShoppingCart();
                    session.setAttribute("cart", cart);
                }
                cart.clear();
            }
        }

        if (userPath.equals("/addToCart")) {
            // if user is adding item to cart for first time
            // create cart object and attach it to user session
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            // get user input from request
            String productId = request.getQueryString();
            if (!productId.isEmpty()) {
                SanPham product = ProductSB.find(productId);
                cart.addItem(product);
                request.setAttribute("title", product.getLoai());
            }
            String userView = (String) session.getAttribute("view");

            userPath = userView;
        }

        
        
        if (userPath.equals("/update")) {
            // if user is adding item to cart for first time
            // create cart object and attach it to user session
            request.setAttribute("title", "View Cart");
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("cart", cart);
            }
            // get user input from request
            String productId = request.getQueryString();
            if (!productId.isEmpty()) {
                SanPham product = ProductSB.find(productId);
                cart.update(product, "0");
            }
            String userView = (String) session.getAttribute("view");
            userPath = userView;
        }

        if (userPath.equals("/contact")) {
            request.setAttribute("title", "Contact");
        }

        String url = userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
