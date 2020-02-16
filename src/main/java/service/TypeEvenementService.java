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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author jerev
 */
public class TypeEvenementService {

    private final SessionFactory sessionFactory;

    public TypeEvenementService(SessionFactory session) {
        this.sessionFactory = Objects.requireNonNull(session);
    }

    public void insertTypeEvenement(Type_Evenement typeEven) {
        Objects.requireNonNull(typeEven);
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(typeEven);
        session.getTransaction().commit();
        session.close();
    }
    
    public Type_Evenement getTypeEvenement(String nom) {
         Session session = this.sessionFactory.openSession();
        Query evenements = session.createQuery("from Type_Evenement where intitule = '" + nom +"'");
        Type_Evenement type = (Type_Evenement)evenements.getSingleResult();
        session.close();
        return type;
    }
    
    
    
    public List<Type_Evenement> getAllTypeEvenements() {
        Session session = this.sessionFactory.openSession();
        List<Type_Evenement> result = session.createQuery("from Type_Evenement").list();
        session.close();
        return result;
    }
}
