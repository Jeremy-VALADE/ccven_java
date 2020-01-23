/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jerev
 */
@Entity
@Table
public class Type_Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_type_even;
    private String intitule;

    public Type_Evenement() {}

    public Type_Evenement(int num_type_even, String nom) {
        this.num_type_even = num_type_even;
        this.intitule = nom;
    }

    public int getNum_type_even() {
        return num_type_even;
    }

    public String getIntitule() {
        return intitule;
    }
}
