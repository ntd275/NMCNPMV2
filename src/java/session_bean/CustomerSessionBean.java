/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

import entity.KhachHang;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author minhh
 */

@Stateless
public class CustomerSessionBean extends AbstractSessionBean<KhachHang> {

    @PersistenceContext(unitName = "FontendPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerSessionBean() {
        super(KhachHang.class);
    }
}
