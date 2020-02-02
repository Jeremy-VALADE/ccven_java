/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ControlerOrganisateur;
import java.util.Scanner;
import modele.Organisateur;
import service.OrganisateurService;
import modele.Main;
/**
 *
 * @author jerev
 */
public class Connection2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer votre login : ");
        String login = sc.next();
        System.out.println("Entrer votre password : ");
        String password = sc.next();
        
        OrganisateurService o = new OrganisateurService(Main.createSessionFactory());
        ControlerOrganisateur co = new ControlerOrganisateur(o);
        if (co.connection(login, password))
            System.out.println("toto");
        else 
            System.out.println("Mauvais mot de passe");
    }
    
}
