/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Rob
 */
@Entity
@Table(name = "productdetails")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Productdetails.findAll", query = "SELECT p FROM Productdetails p")
      //  , @NamedQuery(name = "Productdetails.brand", query = "SELECT p FROM Productdetails p WHERE p.brand = :brand")
     ,@NamedQuery(name = "Productdetails.findTop10", query = "SELECT s FROM Productdetails s ORDER BY s.product")
          //   ,@NamedQuery(name = "Productdetails.findTop10", query = "SELECT p FROM Productdetails p ORDER BY p.product")
    , @NamedQuery(name = "Productdetails.getBrand", query = "SELECT p FROM Productdetails p WHERE p.brand = :brand")
    , @NamedQuery(name = "Productdetails.findByProductId", query = "SELECT p FROM Productdetails p WHERE p.productId = :productId")
    , @NamedQuery(name = "Productdetails.findByProduct", query = "SELECT p FROM Productdetails p WHERE p.product = :product")
    , @NamedQuery(name = "Productdetails.findByBrand", query = "SELECT p FROM Productdetails p WHERE p.brand = :brand")
    , @NamedQuery(name = "Productdetails.findByDateTime", query = "SELECT p FROM Productdetails p WHERE p.dateTime = :dateTime")
    , @NamedQuery(name = "Productdetails.findByUserID", query = "SELECT p FROM Productdetails p WHERE p.userID = :userID")})
public class Productdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductId")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Product")
    private String product;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserID")
    private int userID;

    public Productdetails() {
    }

    public Productdetails(Integer productId) {
        this.productId = productId;
    }

    public Productdetails(Integer productId, String product, String brand, Date dateTime, int userID) {
        this.productId = productId;
        this.product = product;
        this.brand = brand;
        this.dateTime = dateTime;
        this.userID = userID;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productdetails)) {
            return false;
        }
        Productdetails other = (Productdetails) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Productdetails[ productId=" + productId + " ]";
    }
    
}
