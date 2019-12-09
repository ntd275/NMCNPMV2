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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GiaoDich")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GiaoDich.findAll", query = "SELECT g FROM GiaoDich g")
    , @NamedQuery(name = "GiaoDich.findByMaGiaoDich", query = "SELECT g FROM GiaoDich g WHERE g.maGiaoDich = :maGiaoDich")
    , @NamedQuery(name = "GiaoDich.findByDiaChiNhanHang", query = "SELECT g FROM GiaoDich g WHERE g.diaChiNhanHang = :diaChiNhanHang")
    , @NamedQuery(name = "GiaoDich.findByTongThanhToan", query = "SELECT g FROM GiaoDich g WHERE g.tongThanhToan = :tongThanhToan")
    , @NamedQuery(name = "GiaoDich.findByTenNguoiNhan", query = "SELECT g FROM GiaoDich g WHERE g.tenNguoiNhan = :tenNguoiNhan")
    , @NamedQuery(name = "GiaoDich.findByEmail", query = "SELECT g FROM GiaoDich g WHERE g.email = :email")
    , @NamedQuery(name = "GiaoDich.findBySoDT", query = "SELECT g FROM GiaoDich g WHERE g.soDT = :soDT")})
public class GiaoDich implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MaGiaoDich")
    private String maGiaoDich;
    @Size(max = 100)
    @Column(name = "DiaChiNhanHang")
    private String diaChiNhanHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TongThanhToan")
    private int tongThanhToan;
    @Size(max = 30)
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "Email")
    private String email;
    @Size(max = 10)
    @Column(name = "SoDT")
    private String soDT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giaoDich")
    private Collection<DonHang> donHangCollection;
    @JoinColumn(name = "IDKH", referencedColumnName = "IDKH")
    @ManyToOne(optional = false)
    private KhachHang idkh;

    public GiaoDich() {
    }

    public GiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public GiaoDich(String maGiaoDich, int tongThanhToan) {
        this.maGiaoDich = maGiaoDich;
        this.tongThanhToan = tongThanhToan;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public int getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(int tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    @XmlTransient
    public Collection<DonHang> getDonHangCollection() {
        return donHangCollection;
    }

    public void setDonHangCollection(Collection<DonHang> donHangCollection) {
        this.donHangCollection = donHangCollection;
    }

    public KhachHang getIdkh() {
        return idkh;
    }

    public void setIdkh(KhachHang idkh) {
        this.idkh = idkh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGiaoDich != null ? maGiaoDich.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GiaoDich)) {
            return false;
        }
        GiaoDich other = (GiaoDich) object;
        if ((this.maGiaoDich == null && other.maGiaoDich != null) || (this.maGiaoDich != null && !this.maGiaoDich.equals(other.maGiaoDich))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GiaoDich[ maGiaoDich=" + maGiaoDich + " ]";
    }
    
}
