/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jerev
 */
@Entity
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_pers;
    private String nom;
    private String prenom;
    private String email;
    private Date date_naiss;  
    private String organisations;
    private String observations;
    
   @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
     @JoinTable(name = "participe",
            joinColumns = {
                @JoinColumn(name = "num_pers")},
            inverseJoinColumns = {
                @JoinColumn(name = "num_even")
            }
     )
   // @ManyToMany(fetch = FetchType.EAGER,mappedBy = "participants")
    private Set<Evenement> evenements =  new HashSet<Evenement>();

    public Participant() {
    }

    public Participant(String nom, String prenom, String email, Date date_naiss, String organisations, String observations,Set<Evenement> evenements) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisations = organisations;
        this.observations = observations;
        this.evenements = evenements;
    }

    public Participant(String nom, String prenom, String email, String organisations, String observations, Date date_naiss, Evenement even) {
         this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisations = organisations;
        this.observations = observations;
        this.evenements.add(even);
    }
    
    public void setEvenements(Evenement unEvenement){
        evenements.add(unEvenement);
    }

    @Override
    public String toString() {
        return "Participant{" + "num_pers=" + num_pers + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", date_naiss=" + date_naiss + ", organisations=" + organisations + ", observations=" + observations + ", evenements=" +  + '}';
    }
    
    
}
