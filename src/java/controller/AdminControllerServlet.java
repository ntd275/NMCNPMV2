/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.SanPham;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import session_bean.ProductDetailSessionBean;
import session_bean.ProductSessionBean;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import entity.*;
import session_bean.*;

/**
 *
 * @author ntd27
 */
@WebServlet(name = "AdminControllerServlet",
        urlPatterns = {"/adminindex",
            "/addproduct",
            "/addproducttodb",
            "/managerorder",
            "/giaohang",
            "/deleteorder",
            "/editproduct",
            "/deleteproduct",
        })
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class AdminControllerServlet extends HttpServlet {
    @EJB
    private ProductSessionBean ProductSB;
    @EJB
    private ProductDetailSessionBean ProductDetailSB;
    @EJB
    private OrderedProductSessionBean OrderSB;
    
    String SAVE_DIR = "images/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();

        if (userPath.equals("/adminindex")) {
            request.setAttribute("title", "Manage Product");
            List<SanPham> Products;
            Products = (List<SanPham>) ProductSB.findAll();
            session.setAttribute("Products", Products);
        }

        if (userPath.equals("/addproduct")) {
            request.setAttribute("title", "Add Product");
        }
        
        if(userPath.equals("/addproducttodb")){
            SanPham p = (SanPham)session.getAttribute("product");
            LinkAnh pd =(LinkAnh)session.getAttribute("images");
            ProductSB.create(p);
            ProductDetailSB.create(pd);
            request.getRequestDispatcher("/adminindex").forward(request, response);
        }
        
        if(userPath.equals("/managerorder")){
            request.setAttribute("title", "Manage Order");
            List<DonHang> orders = OrderSB.findAll();
            session.setAttribute("ordered", orders);
        }
        
        if(userPath.equals("/deleteorder")){
            DonHangPK k = new DonHangPK((String)request.getParameter("magd"),(String)request.getParameter("idsp"));
            OrderSB.remove(k);
            request.setAttribute("title", "Manage Order");
            request.getRequestDispatcher("/managerorder").forward(request, response);
            
        }
        
        if(userPath.equals("/giaohang")){
            DonHangPK k = new DonHangPK((String)request.getParameter("magd"),(String)request.getParameter("idsp"));
            OrderSB.updateTrangThai(k);
            request.setAttribute("title", "Manager Order");
            request.getRequestDispatcher("/managerorder").forward(request, response);
        }
        
        if(userPath.equals("/deleteproduct")){
            String idsp = request.getQueryString();
            ProductDetailSB.remove(idsp);
            OrderSB.removeSP(idsp);
            ProductSB.remove(idsp);
            request.getRequestDispatcher("/adminindex").forward(request, response);
        }
        
        if(userPath.equals("/updateproducttodb")){
            SanPham p = (SanPham)session.getAttribute("product");
            LinkAnh pd =(LinkAnh)session.getAttribute("images");
            ProductSB.edit(p);
            ProductDetailSB.edit(pd);
            request.getRequestDispatcher("/adminindex").forward(request, response);
        }
        
        if(userPath.equals("/editproduct")){
            String idsp = request.getQueryString();
            SanPham p = ProductSB.FindByID(idsp);
            LinkAnh images = ProductDetailSB.FindByID(idsp);
            session.setAttribute("product", p);
            session.setAttribute("images", images);
            request.setAttribute("title", "Edit Product");
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
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        if (userPath.equals("/addproduct")) {
            Part part1 = request.getPart("AnhDaiDien");
            Part part2 = request.getPart("Anh1");
            Part part3 = request.getPart("Anh2");
            Part part4 = request.getPart("Anh3");
            SanPham p = new SanPham();
            LinkAnh pd = new LinkAnh();
            String nextID = ProductSB.NextID();
            p.setIdsp(nextID);
            pd.setIdsp(p);
            p.setTenSanPham((String) request.getParameter("txtNameProduct"));
            p.setThuongHieu((String) request.getParameter("txtbrand"));
            p.setLoai((String) request.getParameter("txtcategory"));
            p.setGiaTien(Integer.parseInt(request.getParameter("txtPrice")));
            p.setSize((String) request.getParameter("size"));
            p.setMauSac((String) request.getParameter("txtColor"));
            p.setMoTa((String) request.getParameter("txtmota"));
            p.setSoLuong(Integer.parseInt(request.getParameter("txtQuanlity")));
            p.setAnhDaiDien(Upload(part1, request));
            pd.setAnh1(Upload(part2,request));
            pd.setAnh2(Upload(part3,request));
            pd.setAnh3(Upload(part4,request));
            
            session.setAttribute("product", p);
            session.setAttribute("images",pd);
           
            request.getRequestDispatcher("/preview").forward(request, response);
        }
        
        if(userPath.equals("/updateproduct")){
            Part part1 = request.getPart("AnhDaiDien");
            Part part2 = request.getPart("Anh1");
            Part part3 = request.getPart("Anh2");
            Part part4 = request.getPart("Anh3");
            SanPham p = new SanPham();
            LinkAnh pd = new LinkAnh();
            SanPham oldsp = (SanPham)session.getAttribute("product");
            LinkAnh oldla = (LinkAnh)session.getAttribute("images");
            p.setIdsp(oldsp.getIdsp());
            pd.setIdsp(oldsp);
            p.setTenSanPham((String) request.getParameter("txtNameProduct"));
            p.setThuongHieu((String) request.getParameter("txtbrand"));
            p.setLoai((String) request.getParameter("txtcategory"));
            p.setGiaTien(Integer.parseInt(request.getParameter("txtPrice")));
            p.setSize((String) request.getParameter("size"));
            p.setMauSac((String) request.getParameter("txtColor"));
            p.setMoTa((String) request.getParameter("txtmota"));
            p.setSoLuong(Integer.parseInt(request.getParameter("txtQuanlity")));
            p.setAnhDaiDien(Upload(part1, request) == null?oldsp.getAnhDaiDien():Upload(part1, request));
            pd.setAnh1(Upload(part1, request) == null?oldla.getAnh1():Upload(part1, request));
            pd.setAnh2(Upload(part1, request) == null?oldla.getAnh2():Upload(part1, request));
            pd.setAnh3(Upload(part1, request) == null?oldla.getAnh3():Upload(part1, request));
            
            session.setAttribute("product", p);
            session.setAttribute("images",pd);
            request.setAttribute("update", "1");
            request.getRequestDispatcher("/preview").forward(request, response);
        }
        
        if(userPath.equals("/preview")){
            request.setAttribute("title", "Preview");
        }

        String url = userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    public String Upload(Part part, HttpServletRequest request)
            throws IOException {
        String fileName = extractFileName(part);
        if(fileName.equals("")) return null;
        fileName = new File(fileName).getName();
        String applicationPath = request.getServletContext().getRealPath("");
        String basePath = applicationPath + File.separator + "/" +SAVE_DIR + File.separator;
        File outputFilePath = new File(basePath + fileName);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        inputStream = part.getInputStream();
        outputStream = new FileOutputStream(outputFilePath);
        int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        if (outputStream != null) {
            outputStream.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return SAVE_DIR + fileName;
    }
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
