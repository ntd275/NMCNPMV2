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
import entity.KhachHang;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserSessionBean extends AbstractSessionBean<KhachHang> {

    @PersistenceContext(unitName = "FontendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserSessionBean() {
        super(KhachHang.class);
    }

    public KhachHang FindByUserName(String username) {
        return (KhachHang)em.createQuery(
                "SELECT c FROM KhachHang c WHERE c.tenDangNhap = :name")
                .setParameter("name", username)
                .getSingleResult();
    }
    
    public void Insert(KhachHang user) {
                em.createNativeQuery(
                "INSERT INTO KhachHang VALUES (?,?,?,?,?,?,?)")
                        .setParameter(1,user.getIdkh())
                        .setParameter(2,user.getTenDangNhap())
                        .setParameter(3,user.getMatKhau())
                        .setParameter(4,user.getTenKH())
                        .setParameter(5,user.getSoDT())
                        .setParameter(6,user.getEmail())
                        .setParameter(7,user.getDiaChi())
                        .executeUpdate();
    }
}
