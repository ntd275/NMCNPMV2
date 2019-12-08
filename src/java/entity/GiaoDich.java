/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    , @NamedQuery(name = "GiaoDich.findByThoiGianGiaoHang", query = "SELECT g FROM GiaoDich g WHERE g.thoiGianGiaoHang = :thoiGianGiaoHang")
    , @NamedQuery(name = "GiaoDich.findByTongThanhToan", query = "SELECT g FROM GiaoDich g WHERE g.tongThanhToan = :tongThanhToan")})
public class GiaoDich implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MaGiaoDich")
    private String maGiaoDich;
    @Size(max = 100)
    @Column(name = "DiaChiNhanHang")
    private String diaChiNhanHang;
    @Column(name = "ThoiGianGiaoHang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianGiaoHang;
    @Column(name = "TongThanhToan")
    private Integer tongThanhToan;
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

    public Date getThoiGianGiaoHang() {
        return thoiGianGiaoHang;
    }

    public void setThoiGianGiaoHang(Date thoiGianGiaoHang) {
        this.thoiGianGiaoHang = thoiGianGiaoHang;
    }

    public Integer getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(Integer tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
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
