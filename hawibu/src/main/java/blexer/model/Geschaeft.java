package blexer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Geschaeft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private List<Bon> bonList;

    private String name;

    private String ort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public List<Bon> getBonList() {
        return bonList;
    }

    public void setBonList(List<Bon> bonList) {
        this.bonList = bonList;
    }
}
