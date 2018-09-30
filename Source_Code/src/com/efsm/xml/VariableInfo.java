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
public class VariableInfo {
    
    private String id;
    private String name;
    private String componentName;
    private String value = "0";
    private String type = "double";
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
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getComponentName() {
        return componentName;
    }
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    @Override
    public String toString() {
      //  return "States Id="+this.id+" Name=" + this.name;
      return "var "+this.name+"="+this.value+";";
    }
    
}


