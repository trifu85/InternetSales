package internetsales;
// Generated Dec 6, 2015 2:04:05 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Contract generated by hbm2java
 */
@Entity
@Table(name="contract",catalog="internetsales")
public class Contract  implements java.io.Serializable {


     private Integer id;
     private String firstName;
     private String lastName;
     private String address;
     private String internetSpeed;
     private String trafficLimit;
     private String contractLenght;
     private Date lastUpdate;

    public Contract() {
    }

	
    public Contract(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Contract(String firstName, String lastName, String address, String internetSpeed, String trafficLimit, String contractLenght, Date lastUpdate) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.address = address;
       this.internetSpeed = internetSpeed;
       this.trafficLimit = trafficLimit;
       this.contractLenght = contractLenght;
       this.lastUpdate = lastUpdate;
    }
    
    public Contract(Integer id, String firstName, String lastName, String address, String internetSpeed, String trafficLimit, String contractLenght, Date lastUpdate) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.address = address;
       this.internetSpeed = internetSpeed;
       this.trafficLimit = trafficLimit;
       this.contractLenght = contractLenght;
       this.lastUpdate = lastUpdate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="firstName", length=50)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="lastName", length=50)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="address", length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="internetSpeed", length=3)
    public String getInternetSpeed() {
        return this.internetSpeed;
    }
    
    public void setInternetSpeed(String internetSpeed) {
        this.internetSpeed = internetSpeed;
    }

    
    @Column(name="trafficLimit", length=9)
    public String getTrafficLimit() {
        return this.trafficLimit;
    }
    
    public void setTrafficLimit(String trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    
    @Column(name="contractLenght", length=2)
    public String getContractLenght() {
        return this.contractLenght;
    }
    
    public void setContractLenght(String contractLenght) {
        this.contractLenght = contractLenght;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="lastUpdate", nullable=false, length=19, insertable=false, updatable=false)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }




}


