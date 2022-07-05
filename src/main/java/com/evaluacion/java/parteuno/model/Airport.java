package com.evaluacion.java.parteuno.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "code")
    private String code;

    /*@OneToMany
    @JoinTable(name = "airport_country",
            joinColumns = @JoinColumn(name= "id"),
            inverseJoinColumns = @JoinColumn(name="id"))
    private Set<Country> id_country = new HashSet<>();*/

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
