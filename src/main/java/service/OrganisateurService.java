/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.Objects;
import modele.Organisateur;
import modele.Participant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author jerev
 */
public class OrganisateurService {

    private final SessionFactory sessionFactory;

    public OrganisateurService(SessionFactory session) {
        this.sessionFactory = Objects.requireNonNull(session);
    }

    public void insertOrganisateur(Organisateur organisateur) {
        Objects.requireNonNull(organisateur);
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(organisateur);
        session.getTransaction().commit();
        session.close();
    }

    public boolean getPassword(String login, String password) {
        Session session = this.sessionFactory.openSession();
        Query passwordLogin = session.createQuery("select password from Organisateur where login = :login");
        passwordLogin.setString("login", login);
        //return (Organisateur)passwordLogin.uniqueResult();
        if (password.equals((String) passwordLogin.uniqueResult()))            
            return true;
        else {
            return false;
        }
    }
}
