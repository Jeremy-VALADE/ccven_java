/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.*;

/**
 *
 * @author jerev
 */
@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(generator = "increment")
    private int num_pers;
    private String nom;    
    private String prenom;
    private String email;
    private String date_naiss;
    private String organisations;
    private String observations;

    public Participant(){}
    
    public Participant(String nom, String prenom, String email, String date_naiss, String organisations, String observations) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisations = organisations;
        this.observations = observations;
    }

}
