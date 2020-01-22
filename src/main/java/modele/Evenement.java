/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author jerev
 */
@Entity
@Table(name = "evenement")
public class Evenement {
    @Id
    @GeneratedValue(generator = "increment")
    private int num_even;
    private String intitule, theme, description;
    private int duree, nb_part_max;
    private Date date_debut;
    @ManyToOne
    private Organisateur organisateur; 
    @ManyToOne
    private Type_Evenement type;

    public Evenement() {}

    public Evenement(int num_even, String intitule, String theme, String description, int duree, int nb_part_max, Date date_debut, Organisateur organisateur, Type_Evenement type) {
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

    
}
