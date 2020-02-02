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
import java.util.HashSet;
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
import static vue.EvenementInsertion2.createSessionFactory;

/**
 *
 * @author jerev
 */
public class EvenementInsertion2 {

    public static void main(String[] args) {
        SessionFactory session = createSessionFactory();
        Organisateur o = new Organisateur("ls", "truc");
        OrganisateurService ol = new OrganisateurService(session);
        ol.insertOrganisateur(o);
        
        Type_Evenement type = new Type_Evenement("Test");
        TypeEvenementService t = new TypeEvenementService(session);
        t.insertTypeEvenement(type);
        t.insertTypeEvenement(new Type_Evenement("One Piece"));
        
        Scanner sc = new Scanner(System.in);
        Participant p1 = new Participant("test", "toto", "t@gmail.com", "2018-05-05", "Terre", "AB", null);
        HashSet<Participant> p = new HashSet<>();
        p.add(p1);
        ParticipantService pa = new ParticipantService(session);
        pa.insertParticipant(p1);        
        
        Evenement e = new Evenement("echo", "echo", "lance flamme", 0, 0, new java.sql.Timestamp(2000 - 05 - 05), o, type, p);
        EvenementService el = new EvenementService(session);
        el.insertEvenement(e);        
        pa.insertParticipant(p1);
        
        for (Participant q : pa.getAllParticipants()){
            System.out.println(q);
        }/*
        for (Object x: e.getParticipants())
            System.out.println(x);*/
    }

    public static SessionFactory createSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(new File("hibernate.cfg.xml")).build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }
}
