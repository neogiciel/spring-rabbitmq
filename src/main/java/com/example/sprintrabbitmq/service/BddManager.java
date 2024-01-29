package com.example.sprintrabbitmq.service;

import java.util.List;

import com.example.sprintrabbitmq.model.Message;

public interface BddManager {

     /*
     * Table Message
     */
    public List<Message> getListMessages();
    public Long addMessage(Message message);
    public Long addMessageSQL(Message message);

    /*
     * Table Personne
     */
    //public List<Personne> getListPersonnes();
    //public List<Personne> getListPersonnesSQL();
    //public Long addPersonne(Personne personne);
    //public Long addPersonneSQL(Personne personne);
	//public Personne getPersonneFromId(int Id);
    //public Personne getPersonneFromIdSQL(int Id);
    //public void deletePersonne(int id);
	//public void deletePersonneSQL(int id);
	//public void updatePersonne(Personne personne);
	//public void updatePersonneSQL(Personne personne);

    /*
     * Table Service
     */
    //public List<Service> getListServices();
    //public Service getServiceFromId(int Id);
    //public Long addService(Service service);
    //public void deleteService(int id);
    //public void updateService(Service service);


}
