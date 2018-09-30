/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efsm.xml;

/**
 *
 * @author Tameen
 */
public class Composition {
    
    private String id="";
    private String name="";
    private String sender="";
    private String receiver="";
    private String transition="";
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    
     public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    public String getTransition() {
        return transition;
    }
    public void setTransition(String transition) {
        this.transition = transition;
    }

    @Override
    public String toString() {
        return "Component Id="+this.id+" Sender=" + this.sender+" Receiver=" + this.receiver+" Transition=" + this.transition;
    }
    
}
