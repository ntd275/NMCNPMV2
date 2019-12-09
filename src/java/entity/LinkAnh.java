/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ntd27
 */
@Entity
@Table(name = "LinkAnh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinkAnh.findAll", query = "SELECT l FROM LinkAnh l")
    , @NamedQuery(name = "LinkAnh.findByAnh1", query = "SELECT l FROM LinkAnh l WHERE l.anh1 = :anh1")
    , @NamedQuery(name = "LinkAnh.findByAnh2", query = "SELECT l FROM LinkAnh l WHERE l.anh2 = :anh2")
    , @NamedQuery(name = "LinkAnh.findByAnh3", query = "SELECT l FROM LinkAnh l WHERE l.anh3 = :anh3")
    , @NamedQuery(name = "LinkAnh.findByAnh4", query = "SELECT l FROM LinkAnh l WHERE l.anh4 = :anh4")
    , @NamedQuery(name = "LinkAnh.findByAnh5", query = "SELECT l FROM LinkAnh l WHERE l.anh5 = :anh5")
    , @NamedQuery(name = "LinkAnh.findByAnh6", query = "SELECT l FROM LinkAnh l WHERE l.anh6 = :anh6")})
public class LinkAnh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Anh1")
    private String anh1;
    @Size(max = 200)
    @Column(name = "Anh2")
    private String anh2;
    @Size(max = 200)
    @Column(name = "Anh3")
    private String anh3;
    @Size(max = 200)
    @Column(name = "Anh4")
    private String anh4;
    @Size(max = 200)
    @Column(name = "Anh5")
    private String anh5;
    @Size(max = 200)
    @Column(name = "Anh6")
    private String anh6;
    @JoinColumn(name = "IDSP", referencedColumnName = "IDSP")
    @ManyToOne(optional = false)
    private SanPham idsp;

    public LinkAnh() {
    }

    public LinkAnh(String anh1) {
        this.anh1 = anh1;
    }

    public String getAnh1() {
        return anh1;
    }

    public void setAnh1(String anh1) {
        this.anh1 = anh1;
    }

    public String getAnh2() {
        return anh2;
    }

    public void setAnh2(String anh2) {
        this.anh2 = anh2;
    }

    public String getAnh3() {
        return anh3;
    }

    public void setAnh3(String anh3) {
        this.anh3 = anh3;
    }

    public String getAnh4() {
        return anh4;
    }

    public void setAnh4(String anh4) {
        this.anh4 = anh4;
    }

    public String getAnh5() {
        return anh5;
    }

    public void setAnh5(String anh5) {
        this.anh5 = anh5;
    }

    public String getAnh6() {
        return anh6;
    }

    public void setAnh6(String anh6) {
        this.anh6 = anh6;
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
        hash += (anh1 != null ? anh1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinkAnh)) {
            return false;
        }
        LinkAnh other = (LinkAnh) object;
        if ((this.anh1 == null && other.anh1 != null) || (this.anh1 != null && !this.anh1.equals(other.anh1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LinkAnh[ anh1=" + anh1 + " ]";
    }
    
}
