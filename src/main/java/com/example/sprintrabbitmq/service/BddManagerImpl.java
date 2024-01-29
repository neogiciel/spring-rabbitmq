package com.example.sprintrabbitmq.service;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.annotation.ApplicationScope;

import com.example.sprintrabbitmq.model.Message;
import com.example.sprintrabbitmq.util.Trace;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class BddManagerImpl implements BddManager{
    
    /*
     * EntityManager
     */
    @PersistenceContext
    EntityManager em;
    
    /*
     * getListMessage
     */
    public List<Message> getListMessages(){
        Trace.info("[BddManager] select * from MESSAGE");
        @SuppressWarnings("unchecked")
        List<Message> liste =  em.createNativeQuery("select * from MESSAGE",Message.class).getResultList();
        return liste;
	}

   /*
     * addPersonne
     */
    @Transactional
    public Long addMessage(Message message){
        Trace.info("[BddManager] addMessage");
        em.persist(message);
        em.flush();
        Trace.info("[BddManager] id = "+ message.id);
    	return message.id;
    }


   	/*
     * addMessageSQL
     */
    @Transactional
    public Long addMessageSQL(Message message){
        Trace.info("[BddManager] addMessageSQL");
        String sql = "INSERT INTO MESSAGE(MESSAGE) values ('" + message.message + "')";
        em.createNativeQuery(sql,Message.class).executeUpdate();
        Long id = (Long) em.createNativeQuery("SELECT LAST_INSERT_ID() AS ID FROM MESSAGE WHERE IDMESSAGE = LAST_INSERT_ID()").getSingleResult();
        return id;
    }



}
