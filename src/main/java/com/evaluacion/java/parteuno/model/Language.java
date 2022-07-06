package com.evaluacion.java.parteuno.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="language_id")
    private long language_id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    /*@ManyToMany(mappedBy = "spokenLanguages", cascade = CascadeType.ALL)
    List<Employee> speaks;*/

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /*public List<Employee> getSpeaks() {
        return speaks;
    }

    public void setSpeaks(List<Employee> speaks) {
        this.speaks = speaks;
    }*/
}
