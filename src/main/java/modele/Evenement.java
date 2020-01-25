/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    @ManyToOne
    private Organisateur organisateur;
    @ManyToOne
    private Type_Evenement type;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "evenements")
    private List<Participant> participants;

    public Evenement() {
    }

    public Evenement(String intitule, String theme, String description, int duree, int nb_part_max, Timestamp date_debut, Organisateur organisateur, Type_Evenement type, List<Participant> participants) {
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

    public List<Participant> getParticipants() {
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

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    public void setType(Type_Evenement type) {
        this.type = type;
    }
    
}
