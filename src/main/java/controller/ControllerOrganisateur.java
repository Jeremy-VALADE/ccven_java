/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import modele.Organisateur;
import org.hibernate.SessionFactory;
import service.OrganisateurService;
import vue.Connexion;

/**
 *
 * @author jerev
 */
public class ControllerOrganisateur {

    private OrganisateurService serviceOrganisateur = null;
    public static Organisateur organisateur = null;

    public ControllerOrganisateur(SessionFactory session) {
        this.serviceOrganisateur = new OrganisateurService(session);
    }

    public boolean connection(String login, String password) {       
        if (login.isEmpty() || password.isEmpty()) {
            return false;
        }
        organisateur = serviceOrganisateur.getPassword(login, password);
        if (organisateur != null) {
            return true;
        } else {
            return false;
        }
    }

}
