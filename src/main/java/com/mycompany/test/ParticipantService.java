/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author jerev
 */
public class ParticipantService {
    private final SessionFactory sessionFactory;

    public ParticipantService(SessionFactory session) {
        this.sessionFactory = Objects.requireNonNull(session);
    }
    
    public void insertParticipant(Participant participant) {
        Objects.requireNonNull(participant);
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(participant);
        session.getTransaction().commit();
        session.close();        
    }
}
