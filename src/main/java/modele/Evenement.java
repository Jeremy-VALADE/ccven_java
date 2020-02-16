/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
@Table(name = "evenement")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_even;
    private String intitule, theme, description;
    private int duree, nb_part_max;
    private Timestamp date_debut;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Organisateur organisateur;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Type_Evenement type;

    //@ManyToMany(targetEntity = Participant.class, fetch = FetchType.EAGER)
    //@JoinTable(name = "participe")
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinTable(name = "participe",
            joinColumns = {
                @JoinColumn(name = "num_even")},
            inverseJoinColumns = {
                @JoinColumn(name = "num_pers")})
    private Set<Participant> participants;

    public Evenement() {
    }

    public Evenement(String intitule, String theme, String description, int duree, int nb_part_max, Timestamp date_debut, Organisateur organisateur, Type_Evenement type) {
        this.num_even = num_even;
        this.intitule = intitule;
        this.theme = theme;
        this.description = description;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.date_debut = date_debut;
        this.organisateur = organisateur;
        this.type = type;       
    }

    public Evenement(String intitule, String theme, String description, int duree, int nb_part_max, Timestamp date_debut, Organisateur organisateur, Type_Evenement type, Set<Participant> participants) {
        this.num_even = num_even;
        this.intitule = intitule;
        this.theme = theme;
        this.description = description;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.date_debut = date_debut;
        this.organisateur = organisateur;
        this.type = type;
        this.participants = participants;
    }

    public int getNum_even() {
        return num_even;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getTheme() {
        return theme;
    }

    public String getDescription() {
        return description;
    }

    public int getDuree() {
        return duree;
    }

    public int getNb_part_max() {
        return nb_part_max;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public Type_Evenement getType() {
        return type;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void addParticipants(Participant unParticipant) {
        participants.add(unParticipant);
    }

    public void setNum_even(int num_even) {
        this.num_even = num_even;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setNb_part_max(int nb_part_max) {
        this.nb_part_max = nb_part_max;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    public void setType(Type_Evenement type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Evenement{" + "num_even=" + num_even + ", intitule=" + intitule + ", theme=" + theme + ", description=" + description + ", duree=" + duree + ", nb_part_max=" + nb_part_max + ", date_debut=" + date_debut + ", organisateur=" + organisateur + ", type=" + type + ", participants=" +  '}';
    }

}
