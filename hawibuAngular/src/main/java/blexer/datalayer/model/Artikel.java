package blexer.datalayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Proxy(lazy = false)
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private Kategorie kategorie;

    @OneToMany
    @JsonIgnore
    private List<Posten> postenList;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kategorie getKategorie() {
        return this.kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public List<Posten> getPostenList() {
        return this.postenList;
    }

    public void setPostenList(List<Posten> postenList) {
        this.postenList = postenList;
    }

    @Override
    public String toString() {
        return name;
    }
}
