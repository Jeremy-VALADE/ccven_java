/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.Objects;
import modele.Evenement;
import modele.Type_Evenement;
import modele.Participe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.Date;
import modele.Participant;

/**
 *
 * @author jerev
 */

public class EvenementService {

    private final SessionFactory sessionFactory;

    public EvenementService(SessionFactory session) {
        this.sessionFactory = Objects.requireNonNull(session);
    }

    public void insertEvenement(Evenement even) {
        Objects.requireNonNull(even);
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(even);
        session.getTransaction().commit();
        session.close();
    }

    public Evenement getAllEvenement() {
        Session session = this.sessionFactory.openSession();
       Evenement evenements = (Evenement)session.get(Evenement.class, 2);
       evenements.getNum_even();
        session.close();
        return evenements;
    }

    public List<Evenement> getAllEvenements() {
        Session session = this.sessionFactory.openSession();
        List<Evenement> evenements = session.createQuery("from Evenement").list();
        session.close();
        return evenements;
    }

    public List<Evenement> getAllEvenements(String theme) {
        Session session = this.sessionFactory.openSession();
        Query evenements = session.createQuery("from evenement where theme = :theme");
        evenements.setString("theme", theme);
        List<Evenement> evens = evenements.list();
        session.close();
        return evens;
    }

    public List<Evenement> getAllEvenements(Type_Evenement type) {
        Session session = this.sessionFactory.openSession();
        Query evenements = session.createQuery("from evenement where type_even = :type");
        evenements.setString("type", type.getIntitule());
        List<Evenement> evens = evenements.list();
        session.close();
        return evens;
    }

    public List<Evenement> getAllEvenements(Date dateDebut, Date dateFin) {
        Session session = this.sessionFactory.openSession();
        Query evenements = session.createQuery("from evenement where date_debut between :date1 and :date2");
        evenements.setString(":date1", dateDebut.toString());
        evenements.setString(":date2", dateFin.toString());
        List<Evenement> evens = evenements.list();
        session.close();
        return evens;
    }

}
