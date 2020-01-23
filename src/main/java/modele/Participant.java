/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;
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
    private String date_naiss;
    private String organisations;
    private String observations;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "participe", joinColumns = {
        @JoinColumn(name = "num_pers")},
            inverseJoinColumns = {
                @JoinColumn(name = "num_even")
            })
    private List<Evenement> evenements;

    public Participant() {
    }

    public Participant(int num_pers, String nom, String prenom, String email, String date_naiss, String organisations, String observations, List<Evenement> evenements) {
        this.num_pers = num_pers;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisations = organisations;
        this.observations = observations;
        this.evenements = evenements;
    }

}
