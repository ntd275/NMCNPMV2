/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

/**
 *
 * @author ntd27
 */
import entity.LinkAnh;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductDetailSessionBean extends AbstractSessionBean<LinkAnh> {

    @PersistenceContext(unitName = "FontendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductDetailSessionBean() {
        super(LinkAnh.class);
    }
    
     public void create(LinkAnh pd) {
        em.createNativeQuery(
                "INSERT INTO LinkAnh VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, pd.getIdsp().getIdsp())
                .setParameter(2, pd.getAnh1())
                .setParameter(3, pd.getAnh2())
                .setParameter(4, pd.getAnh3())
                .setParameter(5, pd.getAnh4())
                .setParameter(6, pd.getAnh5())
                .setParameter(7, pd.getAnh6())
                .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }
     
     public void remove(String id){
        em.createNativeQuery(
                "DELETE FROM LinkAnh WHERE IDSP= ?")
                        .setHint("org.hibernate.cacheMode", "IGNORE")
                        .setParameter(1,id)
                        .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }
     
     public void edit(LinkAnh pd){
         em.createNativeQuery(
                "UPDATE LinkAnh SET IDSP=?,Anh1=?,Anh2=?,Anh3=? WHERE IDSP=?")
                .setParameter(1, pd.getIdsp().getIdsp())
                .setParameter(2, pd.getAnh1())
                .setParameter(3, pd.getAnh2())
                .setParameter(4, pd.getAnh3())
                .setParameter(5, pd.getIdsp().getIdsp())
                .executeUpdate();
         em.getEntityManagerFactory().getCache().evictAll();
     }
     
     public LinkAnh FindByID(String id) {
        return (LinkAnh) em.createQuery(
                "SELECT c FROM LinkAnh c WHERE c.idsp.idsp = :id")
                .setParameter("id", id)
                .setHint("org.hibernate.cacheMode", "IGNORE")
                .getSingleResult();
    }
}
