/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import javax.persistence.*;

/**
 *
 * @author jerev
 */
@Entity
@Table (name = "participant")
public class Participant {
    @Id
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;

    public Participant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    
}
