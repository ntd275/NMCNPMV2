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
import entity.*;

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

    @Override
    public void create(DonHang order) {
        em.createNativeQuery("INSERT INTO DonHang VALUES(?,?,?,?)")
                .setParameter(1, order.getDonHangPK().getMaGiaoDich())
                .setParameter(2, order.getDonHangPK().getIdsp())
                .setParameter(3, order.getSoLuongSP())
                .setParameter(4, order.getTrangThai())
                .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }

    public List<DonHang> findByOrderId(String id) {
        return em.createQuery(
                "SELECT c FROM DonHang c WHERE c.donHangPK.maGiaoDich = :orderid")
                .setParameter("orderid", id)
                .setHint("org.hibernate.cacheMode", "IGNORE")
                .getResultList();
    }
    
    public void remove(DonHangPK k){
        em.createNativeQuery(
                "DELETE FROM DonHang WHERE MaGiaoDich= ? and IDSP= ?")
                        .setHint("org.hibernate.cacheMode", "IGNORE")
                        .setParameter(1,k.getMaGiaoDich())
                        .setParameter(2,k.getIdsp())
                        .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }
    
    public void updateTrangThai(DonHangPK k){
        em.createNativeQuery(
                "UPDATE DonHang SET TrangThai='Da Giao' WHERE MaGiaoDich= ? and IDSP= ?")
                        .setHint("org.hibernate.cacheMode", "IGNORE")
                        .setParameter(1,k.getMaGiaoDich())
                        .setParameter(2,k.getIdsp())
                        .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }
    
    public void removeSP(String id){
        em.createNativeQuery(
                "DELETE FROM DonHang WHERE IDSP = ?")
                        .setHint("org.hibernate.cacheMode", "IGNORE")
                        .setParameter(1,id)
                        .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
  
    }
}
