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
public class StateInfo {
    private String id;
    private String name;
    private String component;
    private String isInitial;
    private String InitialId;
    private String InitialName;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getComponent() {
        return component;
    }
    public void setComponent(String component) {
        this.component = component;
    }
    
    public String getIsInitial() {
        return isInitial;
    }
    public void setIsInitial(String isInitial) {
        this.isInitial = isInitial;
    }
    
    public String getInitialId() {
        return InitialId;
    }
    
    public void setInitialId(String InitialId) {
        this.InitialId = InitialId;
    } 
    
    public String getInitialName() {
        return InitialName;
    }
    
    public void setInitialName(String InitialName) {
        this.InitialName = InitialName;
    } 
    

    @Override
    public String toString() {
      //  return "States Id="+this.id+" Name=" + this.name;
      return this.name;
    }
    
}


