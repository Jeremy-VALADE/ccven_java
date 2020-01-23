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
public class ControlerOrganisateur {
    public static Organisateur organisateur = null;
    private OrganisateurService service = null;

    public ControlerOrganisateur(OrganisateurService service) {
        this.service = service;
    }
    
    public boolean connection(String login, String password) {
        if (password.equals(service.getPassword(login))) {
            organisateur = new Organisateur(login, password);
            return true;
        }
        else 
            return false;
    }
    
}
