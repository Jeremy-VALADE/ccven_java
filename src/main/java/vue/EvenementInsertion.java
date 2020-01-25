/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.ControlerOrganisateur;
import java.io.File;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modele.*;
import service.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import service.EvenementService;
import service.OrganisateurService;
import static vue.EvenementInsertion.createSessionFactory;

/**
 *
 * @author jerev
 */
public class EvenementInsertion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Participant p1 = new Participant("test", "toto","t@gmail.com","2018-05-05","Terre","AB");
        ArrayList<Participant> p = new ArrayList<>();
        p.add(p1);
        ParticipantService pa = new ParticipantService(createSessionFactory());
        pa.insertParticipant(p1);
        Type_Evenement type = new Type_Evenement("Test");
        TypeEvenementService t = new TypeEvenementService(createSessionFactory());
        t.insertTypeEvenement(type);
        Organisateur o = new Organisateur("ls","truc");
        OrganisateurService ol = new OrganisateurService(createSessionFactory());
       
        Evenement e = new Evenement("echo", "echo", "lance flamme", 0, 0, new java.sql.Timestamp(2000-05-05), o, type, p);
        //EvenementService el = new EvenementService(createSessionFactory());
        //el.insertEvenement(e);
        p1.setEvenements(e);
        pa.insertParticipant(p1);
    }
    
      public static SessionFactory createSessionFactory(){
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
