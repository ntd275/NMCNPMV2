/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

import entity.GiaoDich;
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

    public GiaoDich findByCustomer(Object customer) {
        return (GiaoDich) em.createNamedQuery("CustomerOrder.findByCustomer").setParameter("customer",
                customer).getSingleResult();
    }
}
