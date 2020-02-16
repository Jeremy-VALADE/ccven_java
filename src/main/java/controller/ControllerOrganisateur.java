/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import modele.Organisateur;
import service.OrganisateurService;

/**
 *
 * @author jerev
 */
public class ControllerOrganisateur {

    public static Organisateur organisateur = null;
    private OrganisateurService service = null;

    public ControllerOrganisateur(OrganisateurService service) {
        this.service = service;
    }

    public boolean connection(String login, String password) {
        return true;
    }

}
