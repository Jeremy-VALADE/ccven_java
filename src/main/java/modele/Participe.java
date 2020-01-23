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
@Table(name = "participe")
public class Participe {

    @EmbeddedId
    private Participe participe = new Participe();
    
    @ManyToOne
    @MapsId("participantId")
    private Participant participant;
    
    @ManyToOne
    @MapsId("evenementId")
    private Evenement evenement;
 
    public Participe() { }

    public Participe(Participant participant, Evenement evenement) {        
        this.participant = participant;
        this.evenement = evenement;
    }  
    
}
