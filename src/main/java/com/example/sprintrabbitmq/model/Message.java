package com.example.sprintrabbitmq.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "MESSAGE")
@Table(name = "MESSAGE")
public class Message {
   
    @Id //@GeneratedValue
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IDMESSAGE")
    public long id;
    
    @Column(name="MESSAGE")
    public String message;


    /*
     * Constructeur
    */
    public Message(){
    }

    /*
     * Constructeur
    */
    public Message(String message){
        this.message = message;
    }

    /*
     * toJSON
     */
    public JSONObject toJSON(Message m) {

        JSONObject obj = new JSONObject();
        obj.put("id", m.id);
        obj.put("message", m.message);
            
        return obj;
    }    



    /*
     * totListeJSON
     */
    public JSONArray totListeJSON( List<Message> liste ) {

        JSONArray jsonArray = new JSONArray();


        for (int i= 0; i < liste.size(); i++ ){
            Message m = liste.get(i);
            JSONObject obj = new JSONObject();
            obj.put("id", m.id);
            obj.put("message", m.message);
            jsonArray.put(obj);
        }
        return jsonArray;
    } 


}
