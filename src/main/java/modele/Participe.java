/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jerev
 */
@Embeddable
@Table(name = "participe")
public class Participe {
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Participant", joinColumns = {
        @JoinColumn(name = "num_pers")},
            inverseJoinColumns = {
                @JoinColumn(name = "num_pers")
            })
    private Participant unParticipant;
    
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Evenement", joinColumns = {
        @JoinColumn(name = "num_even")},
            inverseJoinColumns = {
                @JoinColumn(name = "num_even")
            })
    private Evenement unEvenement;
    
    public Participe() { }

  
}
