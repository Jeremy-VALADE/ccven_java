/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modele.Organisateur;
import service.EvenementService;
import service.TypeEvenementService;
import org.hibernate.SessionFactory;

/**
 *
 * @author jerev
 */
public class ControlerEvenement {

    private EvenementService serviceEvenement = null;
    private TypeEvenementService serviceTyeEvenement = null;
    private Organisateur organisateur = null;

    public ControlerEvenement(SessionFactory session) {
        this.serviceEvenement = new EvenementService(session);
        this.serviceTyeEvenement = new TypeEvenementService(session);
        this.organisateur = ControllerOrganisateur.organisateur;
    }

    public void addEvenement() {
        
    }
}
