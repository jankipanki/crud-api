package mjankowski.crudapi.family;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String familyName;
    private int nrOfAdults;
    private int nrOfChildren;
    private int nrOfInfants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfChildren() {
        return nrOfChildren;
    }

    public void setNrOfChildren(int nrOfChildren) {
        this.nrOfChildren = nrOfChildren;
    }

    public int getNrOfInfants() {
        return nrOfInfants;
    }

    public void setNrOfInfants(int nrOfInfants) {
        this.nrOfInfants = nrOfInfants;
    }
}
