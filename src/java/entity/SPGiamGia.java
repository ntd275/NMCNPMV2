/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ntd27
 */
@Entity
@Table(name = "SPGiamGia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SPGiamGia.findAll", query = "SELECT s FROM SPGiamGia s")
    , @NamedQuery(name = "SPGiamGia.findByMaGiamGia", query = "SELECT s FROM SPGiamGia s WHERE s.maGiamGia = :maGiamGia")
    , @NamedQuery(name = "SPGiamGia.findByHeSoGiam", query = "SELECT s FROM SPGiamGia s WHERE s.heSoGiam = :heSoGiam")
    , @NamedQuery(name = "SPGiamGia.findByThoiGianBD", query = "SELECT s FROM SPGiamGia s WHERE s.thoiGianBD = :thoiGianBD")
    , @NamedQuery(name = "SPGiamGia.findByThoiGianKT", query = "SELECT s FROM SPGiamGia s WHERE s.thoiGianKT = :thoiGianKT")})
public class SPGiamGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MaGiamGia")
    private String maGiamGia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HeSoGiam")
    private int heSoGiam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThoiGianBD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianBD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThoiGianKT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianKT;
    @JoinColumn(name = "IDSP", referencedColumnName = "IDSP")
    @ManyToOne(optional = false)
    private SanPham idsp;

    public SPGiamGia() {
    }

    public SPGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public SPGiamGia(String maGiamGia, int heSoGiam, Date thoiGianBD, Date thoiGianKT) {
        this.maGiamGia = maGiamGia;
        this.heSoGiam = heSoGiam;
        this.thoiGianBD = thoiGianBD;
        this.thoiGianKT = thoiGianKT;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public int getHeSoGiam() {
        return heSoGiam;
    }

    public void setHeSoGiam(int heSoGiam) {
        this.heSoGiam = heSoGiam;
    }

    public Date getThoiGianBD() {
        return thoiGianBD;
    }

    public void setThoiGianBD(Date thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public Date getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(Date thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }

    public SanPham getIdsp() {
        return idsp;
    }

    public void setIdsp(SanPham idsp) {
        this.idsp = idsp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGiamGia != null ? maGiamGia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SPGiamGia)) {
            return false;
        }
        SPGiamGia other = (SPGiamGia) object;
        if ((this.maGiamGia == null && other.maGiamGia != null) || (this.maGiamGia != null && !this.maGiamGia.equals(other.maGiamGia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SPGiamGia[ maGiamGia=" + maGiamGia + " ]";
    }
    
}
