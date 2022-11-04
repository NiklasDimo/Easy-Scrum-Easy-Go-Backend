package com.example.ESEG.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Impressum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String str;
    private String plz;
    private String telefon;
    private String telefax;
    private String email;

    public Impressum(){

    }

    public Impressum(Integer id, String name, String str, String plz, String telefon, String telefax, String email) {
        this.id = id;
        this.name = name;
        this.str = str;
        this.plz = plz;
        this.telefon = telefon;
        this.telefax = telefax;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefax() {
        return telefax;
    }

    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
