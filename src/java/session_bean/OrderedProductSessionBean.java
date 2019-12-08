/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

import entity.DonHang;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author minhh
 */
@Stateless
public class OrderedProductSessionBean extends
        AbstractSessionBean<DonHang> {

    @PersistenceContext(unitName = "FontendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderedProductSessionBean() {
        super(DonHang.class);
    }

    public List<DonHang> findByOrderId(Object id) {
        return em.createNamedQuery("OrderedProduct.findByOrderId").setParameter("orderId",
                id).getResultList();
    }
}
