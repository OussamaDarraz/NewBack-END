package com.example.demo.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="employee")

public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long numero;

    private String nom, prenom , dept;

    

    public Employee() {

    }


    public Employee(String nom,
            String prenom , String dept) {
        super();
        this.nom = nom;
        this.prenom=prenom;
        this.dept=dept;
    }


    public long getNumero() {
        return numero;
    }


    public void setNumero(long numero) {
        this.numero = numero;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String toString() {
        return this.getNumero()+" "+this.getNom()+" "+this.getPrenom()+" "+this.getDept();
    }
}
