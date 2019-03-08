package blexer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Monat {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Jahr jahr;

    private Integer monat;

    private String name;

    @OneToMany
    private List<Bon> bonList;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jahr getJahr() {
        return this.jahr;
    }

    public void setJahr(Jahr jahr) {
        this.jahr = jahr;
    }

    public Integer getMonat() {
        return this.monat;
    }

    public void setMonat(Integer monat) {
        this.monat = monat;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bon> getBonList() {
        return this.bonList;
    }

    public void setBonList(List<Bon> bonList) {
        this.bonList = bonList;
    }
}
