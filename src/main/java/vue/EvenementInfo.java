/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.io.File;
import modele.Evenement;
import modele.Participant;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import service.EvenementService;
import static vue.EvenementInsertion.createSessionFactory;

/**
 *
 * @author jerev
 */
public class EvenementInfo {

    public static void main(String[] args) {
         EvenementService el = new EvenementService(createSessionFactory());         
         System.out.println(el.getAllEvenement()); 
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
