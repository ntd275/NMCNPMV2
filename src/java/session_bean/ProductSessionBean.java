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
import entity.SanPham;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductSessionBean extends AbstractSessionBean<SanPham> {

    @PersistenceContext(unitName = "FontendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductSessionBean() {
        super(SanPham.class);
    }

    public List<SanPham> FindByCategory(String categoryname) {
        return em.createQuery(
                "SELECT c FROM SanPham c WHERE c.loai = :name")
                .setParameter("name", categoryname)
                .getResultList();
    }
    
    public List<SanPham> FindSale() {
        return em.createQuery(
                "SELECT c.idsp FROM SPGiamGia c") 
                .getResultList();
    }
       public List<SanPham> FindSalePage(int page) {
        return em.createQuery(
                "SELECT c.idsp FROM SPGiamGia c") 
                .setFirstResult((page-1)*9)
                .setMaxResults(9)
                .getResultList();
    }

    public SanPham FindByID(String id) {
        return (SanPham) em.createQuery(
                "SELECT c FROM SanPham c WHERE c.idsp = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    public String NextID() {
        SanPham last = (SanPham) em.createQuery(
                "SELECT c FROM SanPham c ORDER BY c.idsp DESC")
                .setMaxResults(1)
                .getSingleResult();
        String curID = last.getIdsp();
        return "SP" + Integer.toString(1 + Integer.parseInt(curID.substring(2)));
    }

    @Override
    public void create(SanPham p) {
        em.createNativeQuery(
                "INSERT INTO SanPham VALUES (?,?,?,?,?,?,?,?,?,?)")
                .setParameter(1, p.getIdsp())
                .setParameter(2, p.getTenSanPham())
                .setParameter(3, p.getLoai())
                .setParameter(4, p.getGiaTien())
                .setParameter(5, p.getSize())
                .setParameter(6, p.getAnhDaiDien())
                .setParameter(7, p.getSoLuong())
                .setParameter(8, p.getMauSac())
                .setParameter(9, p.getMoTa())
                .setParameter(10,p.getThuongHieu())
                .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }
    
    public void remove(String id){
        em.createNativeQuery(
                "DELETE FROM SanPham WHERE IDSP= ?")
                        .setHint("org.hibernate.cacheMode", "IGNORE")
                        .setParameter(1,id)
                        .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }
    
    public void edit(SanPham p){
        em.createNativeQuery(
                "UPDATE SanPham SET IDSP = ?, TenSanPham = ?, ThuongHieu=?, AnhDaiDien=?,Loai=?,GiaTien=?,Size=?,MauSac=?,SoLuong=?,MoTa=? WHERE IDSP=?")
                .setParameter(1, p.getIdsp())
                .setParameter(2, p.getTenSanPham())
                .setParameter(3, p.getThuongHieu())
                .setParameter(4, p.getAnhDaiDien())
                .setParameter(5, p.getLoai())
                .setParameter(6, p.getGiaTien())
                .setParameter(7, p.getSize())
                .setParameter(8, p.getMauSac())
                .setParameter(9, p.getSoLuong())
                .setParameter(10, p.getMoTa())
                .setParameter(11, p.getIdsp())
                .executeUpdate();
        em.getEntityManagerFactory().getCache().evictAll();
    }
    
    public List<SanPham> findPagebyCategory(String categoryname, int page) {
        return em.createQuery(
                "SELECT c FROM SanPham c WHERE c.loai = :name")
                .setParameter("name", categoryname)
                .setFirstResult((page - 1) * 9)
                .setMaxResults(9)
                .getResultList();
    }
    
    
}
