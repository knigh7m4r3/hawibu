package blexer.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Monat {


    public final static Map<Integer, String> MONATMAPPINGMAP = new HashMap<Integer, String>(){
        {
            put(1, "Januar");
            put(2, "Februar");
            put(3, "März");
            put(4, "April");
            put(5, "Mai");
            put(6, "Juni");
            put(7, "Juli");
            put(8, "August");
            put(9, "September");
            put(10, "Oktober");
            put(11, "November");
            put(12, "Dezember");

        }
    };

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

    public static Monat getMonatByDate(LocalDate date, EntityManager em){
        final String monatJahr = Monat.MONATMAPPINGMAP.get(date.getMonthValue()) + " " + (date.getYear() - 2000);
        final List<Monat> monatList = em.createQuery("from Monat m where m.name = '" + monatJahr + "'" ).getResultList();
        if(monatList.size() == 0 ){
            Monat monat = new Monat();
            monat.setMonat(date.getMonthValue());
            monat.setName(monatJahr);

            final Jahr jahr = Jahr.getJahrByDate(date, em);
            monat.setJahr(jahr);
            monat = em.merge(monat);
            em.flush();
            return monat;

        }else{
            return monatList.get(0);
        }
    }

    @Override
    public String toString() {
        return "Monat{" +
                "jahr=" + jahr +
                ", monat=" + monat +
                ", name='" + name + '\'' +
                '}';
    }
}
