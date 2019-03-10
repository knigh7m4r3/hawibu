package blexer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Kategorie kategorie;

    @OneToMany
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
