package net.nortlam.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name="Person") @Table(name = "PERSON")
@NamedQueries({
   @NamedQuery(name=Person.FIND_BY_ID, query="SELECT person FROM Person person WHERE person.ID = :ID")  
})
public class Person implements Serializable {
    
    public static final String FIND_BY_ID = "Person.findByID";

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PERSON_ID", nullable = false, columnDefinition = "INT", unique = false, insertable = true)
    @XmlAttribute(name = "ID", required = true)
    private int ID;
    
    public static final int LENGTH_NAME = 35;
    @Column(name="NAME", nullable = false, columnDefinition = "VARCHAR(35)", length = LENGTH_NAME, unique = false, insertable = true, updatable = true)
    @XmlElement(name="Name", type=String.class, required=true)
    private String name;
    
    public static final int LENGTH_POSITION = 35;
    @Column(name="POSITION", nullable = true, columnDefinition = "VARCHAR(35)", length = LENGTH_POSITION,  unique = false, insertable = true, updatable = true)
    @XmlElement(name="Position", type=String.class, required=false)
    private String position;
    
    public Person() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.ID;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.position);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }

}
