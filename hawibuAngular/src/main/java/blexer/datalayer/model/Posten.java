package blexer.datalayer.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
public class Posten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artikel artikel;

    @ManyToOne
    private Bon bon;

    private Double preis;

    private Integer menge;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Artikel getArtikel() {
        return this.artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bon getBon() {
        return this.bon;
    }

    public void setBon(Bon bon) {
        this.bon = bon;
    }

    public Double getPreis() {
        return this.preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Integer getMenge() {
        return this.menge;
    }

    public void setMenge(Integer menge) {
        this.menge = menge;
    }
}
