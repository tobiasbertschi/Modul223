package ch.zli.m223.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Raum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean einzel;

    @OneToMany(mappedBy = "raum")
    @JsonIgnore
    //@JsonIgnoreProperties("raum")
    @Fetch(FetchMode.JOIN)
    private Set<Buchung> buchung;

    @OneToMany(mappedBy = "raum")
    //@JsonIgnoreProperties("raum")
    @Fetch(FetchMode.JOIN)
    private Set<Platz> platz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEinzel() {
        return einzel;
    }

    public void setEinzel(boolean einzel) {
        this.einzel = einzel;
    }

    public Set<Buchung> getBuchung() {
        return buchung;
    }

    public void setBuchung(Set<Buchung> buchung) {
        this.buchung = buchung;
    }

    public Set<Platz> getPlatz() {
        return platz;
    }

    public void setPlatz(Set<Platz> platz) {
        this.platz = platz;
    }

}