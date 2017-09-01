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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yinqinghao
 */
@Entity
@Table(name = "safe_house")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SafeHouse.findAll", query = "SELECT s FROM SafeHouse s")
    , @NamedQuery(name = "SafeHouse.findById", query = "SELECT s FROM SafeHouse s WHERE s.id = :id")
    , @NamedQuery(name = "SafeHouse.findByLongitude", query = "SELECT s FROM SafeHouse s WHERE s.longitude = :longitude")
    , @NamedQuery(name = "SafeHouse.findByLatitude", query = "SELECT s FROM SafeHouse s WHERE s.latitude = :latitude")
    , @NamedQuery(name = "SafeHouse.findByPName", query = "SELECT s FROM SafeHouse s WHERE s.pName = :pName")
    , @NamedQuery(name = "SafeHouse.findByStreetNum", query = "SELECT s FROM SafeHouse s WHERE s.streetNum = :streetNum")
    , @NamedQuery(name = "SafeHouse.findByRoadName", query = "SELECT s FROM SafeHouse s WHERE s.roadName = :roadName")
    , @NamedQuery(name = "SafeHouse.findByRoadType", query = "SELECT s FROM SafeHouse s WHERE s.roadType = :roadType")
    , @NamedQuery(name = "SafeHouse.findByPostcode", query = "SELECT s FROM SafeHouse s WHERE s.postcode = :postcode")
    , @NamedQuery(name = "SafeHouse.findByState", query = "SELECT s FROM SafeHouse s WHERE s.state = :state")
    , @NamedQuery(name = "SafeHouse.findByOrganisationType", query = "SELECT s FROM SafeHouse s WHERE s.organisationType = :organisationType")})
public class SafeHouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Longitude")
    private float longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Latitude")
    private float latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pName")
    private String pName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "StreetNum")
    private String streetNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RoadName")
    private String roadName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RoadType")
    private String roadType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Postcode")
    private int postcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "OrganisationType")
    private String organisationType;

    public SafeHouse() {
    }

    public SafeHouse(Integer id) {
        this.id = id;
    }

    public SafeHouse(Integer id, float longitude, float latitude, String pName, String streetNum, String roadName, String roadType, int postcode, String state, String organisationType) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.pName = pName;
        this.streetNum = streetNum;
        this.roadName = roadName;
        this.roadType = roadType;
        this.postcode = postcode;
        this.state = state;
        this.organisationType = organisationType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(String organisationType) {
        this.organisationType = organisationType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SafeHouse)) {
            return false;
        }
        SafeHouse other = (SafeHouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SafeHouse[ id=" + id + " ]";
    }
    
}
