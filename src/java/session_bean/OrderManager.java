/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import entity.KhachHang;
import entity.GiaoDich;
import entity.DonHang;
import entity.DonHangPK;
import entity.SanPham;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author minhh
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager {

    @EJB
    private CustomerOrderSessionBean customerOrderSB;
    @EJB
    private ProductSessionBean productSB;
    @EJB
    private OrderedProductSessionBean orderedProductSB;
    @EJB
    private CustomerSessionBean customerSB;

    @PersistenceContext(unitName = "FontendPU")
    private EntityManager em;
    @Resource
    private SessionContext context;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String placeOrder(String name, String email, String phone, String address, ShoppingCart cart) {
        try {
            KhachHang customer = addCustomer(name, email, phone, address);
            GiaoDich order = addOrder(customer, cart);
            addOrderedItems(order, cart);
            return order.getMaGiaoDich();
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return "0";
        }
    }

    private KhachHang addCustomer(String name, String email, String phone,
            String address) {
        KhachHang customer = new KhachHang();
        customer.setTenKH(name);
        customer.setEmail(email);
        customer.setSoDT(phone);
        customer.setDiaChi(address);
        customerSB.create(customer);
        return customer;
    }

    private GiaoDich addOrder(KhachHang customer, ShoppingCart cart) {
        // set up customer order
        GiaoDich order = new GiaoDich();
        order.setIdkh(customer);
        order.setTongThanhToan(((int)cart.getTotal()));
        customerOrderSB.create(order);
        return order;
    }

    private void addOrderedItems(GiaoDich order, ShoppingCart cart) {
        List<ShoppingCartItem> items = cart.getItems();
        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {
            String productId = scItem.getProduct().getIdsp();
            // set up primary key object
            DonHangPK orderedProductPK = new DonHangPK();
            orderedProductPK.setMaGiaoDich(order.getMaGiaoDich());
            orderedProductPK.setIdsp(productId);
            // create ordered item using PK object
            DonHang orderedItem = new DonHang(orderedProductPK);
            // set quantity
            orderedItem.setSoLuongSP(scItem.getQuantity());
            orderedProductSB.create(orderedItem);
        }
    }

    public Map getOrderDetails(String orderId) {
        Map orderMap = new HashMap();
        // get order
        GiaoDich order = customerOrderSB.find(orderId);
        // get customer
        KhachHang customer = order.getIdkh();
        // get all ordered products
        List<DonHang> orderedProducts
                = orderedProductSB.findByOrderId(orderId);
        // get product details for ordered items
        List<SanPham> products = new ArrayList<SanPham>();
        for (DonHang op : orderedProducts) {
            SanPham p = (SanPham) productSB.find(op.getDonHangPK().getIdsp());
            products.add(p);
        }
        // add each item to orderMap
        orderMap.put("orderRecord", order);
        orderMap.put("customer", customer);
        orderMap.put("orderedProducts", orderedProducts);
        orderMap.put("products", products);
        return orderMap;
    }
}
