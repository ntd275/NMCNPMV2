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
@Table(name = "SanPham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")
    , @NamedQuery(name = "SanPham.findByIdsp", query = "SELECT s FROM SanPham s WHERE s.idsp = :idsp")
    , @NamedQuery(name = "SanPham.findByTenSanPham", query = "SELECT s FROM SanPham s WHERE s.tenSanPham = :tenSanPham")
    , @NamedQuery(name = "SanPham.findByLoai", query = "SELECT s FROM SanPham s WHERE s.loai = :loai")
    , @NamedQuery(name = "SanPham.findByGiaTien", query = "SELECT s FROM SanPham s WHERE s.giaTien = :giaTien")
    , @NamedQuery(name = "SanPham.findBySize", query = "SELECT s FROM SanPham s WHERE s.size = :size")
    , @NamedQuery(name = "SanPham.findByAnhDaiDien", query = "SELECT s FROM SanPham s WHERE s.anhDaiDien = :anhDaiDien")
    , @NamedQuery(name = "SanPham.findBySoLuong", query = "SELECT s FROM SanPham s WHERE s.soLuong = :soLuong")
    , @NamedQuery(name = "SanPham.findByMauSac", query = "SELECT s FROM SanPham s WHERE s.mauSac = :mauSac")
    , @NamedQuery(name = "SanPham.findByMoTa", query = "SELECT s FROM SanPham s WHERE s.moTa = :moTa")
    , @NamedQuery(name = "SanPham.findByThuongHieu", query = "SELECT s FROM SanPham s WHERE s.thuongHieu = :thuongHieu")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDSP")
    private String idsp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TenSanPham")
    private String tenSanPham;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Loai")
    private String loai;
    @Column(name = "GiaTien")
    private Integer giaTien;
    @Size(max = 5)
    @Column(name = "Size")
    private String size;
    @Size(max = 200)
    @Column(name = "AnhDaiDien")
    private String anhDaiDien;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Size(max = 30)
    @Column(name = "MauSac")
    private String mauSac;
    @Size(max = 300)
    @Column(name = "MoTa")
    private String moTa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ThuongHieu")
    private String thuongHieu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanPham")
    private Collection<DonHang> donHangCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsp")
    private Collection<LinkAnh> linkAnhCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsp")
    private Collection<SPGiamGia> sPGiamGiaCollection;

    public SanPham() {
    }

    public SanPham(String idsp) {
        this.idsp = idsp;
    }

    public SanPham(String idsp, String tenSanPham, String loai, String thuongHieu) {
        this.idsp = idsp;
        this.tenSanPham = tenSanPham;
        this.loai = loai;
        this.thuongHieu = thuongHieu;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }
    
    public SanPham(String idsp, String tenSanPham, String thuongHieu, String loai, int giaTien, String mausac, int soluong,String anhDaiDien) {
        this.idsp = idsp;
        this.tenSanPham = tenSanPham;
        this.thuongHieu = thuongHieu;
        this.loai = loai;
        this.giaTien = giaTien;
        this.mauSac = mausac;
        this.soLuong = soluong;
        this.anhDaiDien = anhDaiDien;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Integer getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Integer giaTien) {
        this.giaTien = giaTien;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    @XmlTransient
    public Collection<DonHang> getDonHangCollection() {
        return donHangCollection;
    }

    public void setDonHangCollection(Collection<DonHang> donHangCollection) {
        this.donHangCollection = donHangCollection;
    }

    @XmlTransient
    public Collection<LinkAnh> getLinkAnhCollection() {
        return linkAnhCollection;
    }

    public void setLinkAnhCollection(Collection<LinkAnh> linkAnhCollection) {
        this.linkAnhCollection = linkAnhCollection;
    }

    @XmlTransient
    public Collection<SPGiamGia> getSPGiamGiaCollection() {
        return sPGiamGiaCollection;
    }

    public void setSPGiamGiaCollection(Collection<SPGiamGia> sPGiamGiaCollection) {
        this.sPGiamGiaCollection = sPGiamGiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsp != null ? idsp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.idsp == null && other.idsp != null) || (this.idsp != null && !this.idsp.equals(other.idsp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SanPham[ idsp=" + idsp + " ]";
    }
    
}
