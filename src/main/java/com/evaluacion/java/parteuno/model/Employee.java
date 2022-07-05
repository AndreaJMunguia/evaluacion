package com.evaluacion.java.parteuno.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="surname")
    private String surname;

    @Column(name="firstname")
    private String firstname;

    /*@OneToMany
    @JoinTable(name = "employee_language",
            joinColumns = @JoinColumn(name= "id"),
            inverseJoinColumns = @JoinColumn(name="id"))
    private Set<Language> id_language = new HashSet<>();

    @OneToMany
    @JoinTable(name = "employee_country",
            joinColumns = @JoinColumn(name= "id"),
            inverseJoinColumns = @JoinColumn(name="id"))
    private Set<Country> id_country = new HashSet<>();*/

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}
