package blexer.datalayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Bon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date date;

    @OneToMany(fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<Posten> postenList;

    @ManyToOne
    private Geschaeft geschaeft;

    @ManyToOne
    private Monat monat;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Geschaeft getGeschaeft() {
        return this.geschaeft;
    }

    public void setGeschaeft(Geschaeft geschaeft) {
        this.geschaeft = geschaeft;
    }

    public List<Posten> getPostenList() {
        return this.postenList;
    }

    public void setPostenList(List<Posten> postenList) {
        this.postenList = postenList;
    }

    public Monat getMonat() {
        return this.monat;
    }

    public void setMonat(Monat monat) {
        this.monat = monat;
    }
}
