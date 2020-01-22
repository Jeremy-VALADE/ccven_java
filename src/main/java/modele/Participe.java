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
@Table(name="participe")
public class Participe {
    @Id
    @ManyToMany    
    private Participant participant;
    @Id
    @ManyToMany
    private Evenement even;
}
