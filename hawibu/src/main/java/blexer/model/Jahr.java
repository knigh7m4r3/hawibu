package blexer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Jahr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer jahr;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Monat> monat;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJahr() {
        return this.jahr;
    }

    public void setJahr(Integer jahr) {
        this.jahr = jahr;
    }

    public List<Monat> getMonat() {
        return this.monat;
    }

    public void setMonat(List<Monat> monat) {
        this.monat = monat;
    }
}
