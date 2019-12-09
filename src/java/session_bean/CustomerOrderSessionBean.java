/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

import entity.GiaoDich;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author minhh
 */

@Stateless
public class CustomerOrderSessionBean extends
        AbstractSessionBean<GiaoDich> {

    @PersistenceContext(unitName = "FontendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerOrderSessionBean() {
        super(GiaoDich.class);
    }

    public GiaoDich find(Object id) {
        GiaoDich order = em.find(GiaoDich.class, id);
        em.refresh(order);
        return order;
    }
    
    @Override
    public void create(GiaoDich order) {
        em.createNativeQuery("INSERT INTO GiaoDich VALUES(?,?,?,?,?,?,?)")
                .setParameter(1, order.getMaGiaoDich())
                .setParameter(2, order.getIdkh().getIdkh())
                .setParameter(3, order.getDiaChiNhanHang())
                .setParameter(4, order.getTongThanhToan())
                .setParameter(5, order.getTenNguoiNhan())
                .setParameter(6, order.getEmail())
                .setParameter(7, order.getSoDT())
                .executeUpdate();
    }

    public GiaoDich findByCustomer(Object customer) {
        return (GiaoDich) em.createNamedQuery("CustomerOrder.findByCustomer").setParameter("customer",
                customer).getSingleResult();
    }
    
    public String getNewOrderId() {
        List<GiaoDich> order = em.createQuery("SELECT c FROM GiaoDich c").getResultList();
        if (order == null) {
            return "1";
        } else {
            int a, max = 0;
            String s;
            for (GiaoDich x : order) {
                a = parseInt(x.getMaGiaoDich());
                if (a > max) {
                    max = a;
                }
            }
            return Integer.toString(max + 1);
        }
    }
}
