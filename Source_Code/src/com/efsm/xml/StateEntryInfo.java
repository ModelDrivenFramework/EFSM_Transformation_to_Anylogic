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
public class StateEntryInfo {
    private String id="";
    private String name="";
    private String source="";
    private String target="";
    private String action="";
    private String expression="";
    private String guard="";
    private String trigger="";
    private String timeout="";
    private String timeoutUnit="";
    private String component = "";
    
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    
    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }
    
    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
    
    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
    
    public String getTimeoutUnit() {
        return timeoutUnit;
    }

    public void setTimeoutUnit(String timeoutUnit) {
        this.timeoutUnit = timeoutUnit;
    }
   
    public String getComponent() {
        return component;
    }
    public void setComponent(String component) {
        this.component = component;
    }
    

    @Override
    public String toString() {
       return "Transition Id=" + this.id + " Name=" + this.name + "Target=" +this.target + " Source=" + this.source + " Action=" + this.action + " Expression=" + this.expression + "Guard"+this.guard;
    }

}
