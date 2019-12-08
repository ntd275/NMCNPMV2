/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ntd27
 */
@Entity
@Table(name = "KhachHang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k")
    , @NamedQuery(name = "KhachHang.findByIdkh", query = "SELECT k FROM KhachHang k WHERE k.idkh = :idkh")
    , @NamedQuery(name = "KhachHang.findByTenDangNhap", query = "SELECT k FROM KhachHang k WHERE k.tenDangNhap = :tenDangNhap")
    , @NamedQuery(name = "KhachHang.findByMatKhau", query = "SELECT k FROM KhachHang k WHERE k.matKhau = :matKhau")
    , @NamedQuery(name = "KhachHang.findByTenKH", query = "SELECT k FROM KhachHang k WHERE k.tenKH = :tenKH")
    , @NamedQuery(name = "KhachHang.findBySoDT", query = "SELECT k FROM KhachHang k WHERE k.soDT = :soDT")
    , @NamedQuery(name = "KhachHang.findByEmail", query = "SELECT k FROM KhachHang k WHERE k.email = :email")
    , @NamedQuery(name = "KhachHang.findByDiaChi", query = "SELECT k FROM KhachHang k WHERE k.diaChi = :diaChi")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "IDKH")
    private String idkh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TenDangNhap")
    private String tenDangNhap;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MatKhau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TenKH")
    private String tenKH;
    @Size(max = 10)
    @Column(name = "SoDT")
    private String soDT;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DiaChi")
    private String diaChi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkh")
    private Collection<GiaoDich> giaoDichCollection;

    public KhachHang() {
    }

    public KhachHang(String idkh) {
        this.idkh = idkh;
    }

    public KhachHang(String idkh, String tenDangNhap, String matKhau, String tenKH, String diaChi) {
        this.idkh = idkh;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @XmlTransient
    public Collection<GiaoDich> getGiaoDichCollection() {
        return giaoDichCollection;
    }

    public void setGiaoDichCollection(Collection<GiaoDich> giaoDichCollection) {
        this.giaoDichCollection = giaoDichCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkh != null ? idkh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.idkh == null && other.idkh != null) || (this.idkh != null && !this.idkh.equals(other.idkh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KhachHang[ idkh=" + idkh + " ]";
    }
    
}
