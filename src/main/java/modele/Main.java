/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import service.ParticipantService;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import service.OrganisateurService;
/**
 *
 * @author jerev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory s = createSessionFactory();
        //ParticipantService p = new ParticipantService(s);
       // p.insertParticipant(new Participant("test", "toto","t@gmail.com","2018-05-05","Terre","AB"));
        //p.insertParticipant(new Participant("test", "toto","t@gmail.com","2018-05-05","Terre","AB"));
       // for (Participant e : p.getAllParticipants())
         //   System.out.println(e);
         
         Organisateur o = new Organisateur("Test","lance flamme");
         OrganisateurService l = new OrganisateurService(s);
         l.insertOrganisateur(o);
         System.out.println(l.getPassword("one"));
        
    }
    
    private static SessionFactory createSessionFactory(){
        final StandardServiceRegistry registry =  new StandardServiceRegistryBuilder()
                .configure(new File("hibernate.cfg.xml")).build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch(Exception e){
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }
}
