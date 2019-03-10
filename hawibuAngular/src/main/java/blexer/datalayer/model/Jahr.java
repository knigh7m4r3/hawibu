package blexer.datalayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Jahr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer jahr;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
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

    public static Jahr getJahrByDate(LocalDate date, EntityManager em){
        final List<Jahr> jahrList = em.createQuery("from Jahr j where j.jahr= '" + date.getYear() + "'" ).getResultList();
        if(jahrList.size() == 0){
            final Jahr jahr = new Jahr();
            jahr.jahr = date.getYear();
            return em.merge(jahr);
        }else{
            return jahrList.get(0);
        }
    }

    @Override
    public String toString() {
        return "Jahr{" +
                "jahr=" + jahr +
                '}';
    }
}
