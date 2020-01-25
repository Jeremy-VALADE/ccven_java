/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.Objects;
import modele.Type_Evenement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    
    public List<Type_Evenement> getAllEvenements() {
        Session session = this.sessionFactory.openSession();
        List<Type_Evenement> result = session.createQuery("from type_evenement").list();
        session.close();
        return result;
    }
}
