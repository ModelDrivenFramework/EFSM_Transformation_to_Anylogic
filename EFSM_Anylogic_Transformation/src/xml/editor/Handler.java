/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.editor;

/**
 *
 * @author Tameen
 */
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.efsm.xml.ComponentInfo;
import com.efsm.xml.StateInfo;
import com.efsm.xml.TransitionInfo;
import com.efsm.xml.StateEntryInfo;
import com.efsm.xml.VariableInfo;
import com.efsm.xml.Composition;

public class Handler extends DefaultHandler {


    boolean IsComponent = false;
    boolean IsAdded = false;
    boolean componentId = false; 
    boolean componentName = false;
    
    // define component List
    private List<ComponentInfo> componentList = null;
    private ComponentInfo component = null;
    
    // get componets list    
    public List<ComponentInfo> getComponents() {
        return componentList;
    }
    // define state List
    private List<StateInfo> stateList = null;
    private StateInfo state = null;
    // get state List
    public List<StateInfo> getStates() {
        return stateList;
    }
    
    // define Transition List
    private List<TransitionInfo> transitionList = null;
    private TransitionInfo transition = null;
    // get Transition List
    public List<TransitionInfo> getTransitions() {
        return transitionList;
    }
    // define Variables List
    private List<VariableInfo> variableList = null;
    private VariableInfo variable = null;
    // get Variables List
    public List<VariableInfo> getVariables() {
        return variableList;
    }
    // define Composition List
    private List<Composition> compositionList = null;
    private Composition composition = null;
    // get Composition List
    public List<Composition> getComposition() {
        return compositionList;
    }

    boolean stateId = false;
    boolean stateName = false;
    boolean IsState = false;
    
    
    boolean transitionId = false;
    boolean transitionName = false;
    boolean transitionTarget = false;
    boolean transitionSource = false;
    boolean transitionAction = false;
    boolean transitionEvent = false;
    boolean transitionGuard = false;
    boolean IsTransition = false;
    
    
 
    boolean variableId = false;
    boolean variableName = false;
    boolean variableType = false;
    boolean variableValue = false;
    boolean IsVariable = false;
    
    boolean compositionId = false;
    boolean compositionSender = false;
    boolean compositionReceiver = false;
    boolean compositionTransition = false;
    boolean IsComposition = false;
    boolean IsInitial = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        
        if (qName.equalsIgnoreCase("Component")) {
            IsComponent = true;
            if (componentList == null) {
                componentList = new ArrayList<>();
            }
            component = new ComponentInfo();
        }  else if (qName.equalsIgnoreCase("Id") && IsComponent && !IsAdded) {
            componentId = true;

        } else if (qName.equalsIgnoreCase("Name") && IsComponent && !IsAdded) {
            componentName = true;
          
        } else  if (qName.equalsIgnoreCase("State")) {
                IsState = true;
                if (stateList == null) {
                    stateList = new ArrayList<>();
                }
                state = new StateInfo();                
        } else if (qName.equalsIgnoreCase("Initial") && IsState) {
           // state.setIsInitial(attributes.getValue("Value"));
           // state.setInitialId(attributes.getValue("Id"));
           // state.setInitialName(attributes.getValue("Name"));
           IsInitial = true;
            
        } else if (qName.equalsIgnoreCase("Transition")) {
                IsTransition = true;
                if (transitionList == null) {
                    transitionList = new ArrayList<>();
                }
                transition = new TransitionInfo();
        } else if (qName.equalsIgnoreCase("Id") && IsState) {
            stateId = true;

        } else if (qName.equalsIgnoreCase("Name") && IsState) {
            stateName = true;

        } else if (qName.equalsIgnoreCase("Id") && IsTransition) {
            transitionId = true;

        } else if (qName.equalsIgnoreCase("Name") && IsTransition) {
            transitionName = true;

        } else if (qName.equalsIgnoreCase("Action") && IsTransition) {
            transitionAction = true;

        } else if (qName.equalsIgnoreCase("Event") && IsTransition) {
            transitionEvent = true;

        } else if (qName.equalsIgnoreCase("Properties") && IsTransition) {
            transition.setSource(attributes.getValue("Source"));
            transition.setTarget(attributes.getValue("Target"));
            transition.setType(attributes.getValue("Type"));
        } else if (qName.equalsIgnoreCase("Guard")) {
            transitionGuard = true;
            
        } else if (qName.equalsIgnoreCase("TimeFunction") && IsTransition) {
            transition.setTimeoutUnit(attributes.getValue("Unit"));
            transition.setTimeoutValue(attributes.getValue("Value"));
            transition.setTimeoutType(attributes.getValue("Type"));
        } else if (qName.equalsIgnoreCase("InputVariable") || qName.equalsIgnoreCase("OutputVariable")) {
                 IsVariable = true;
                if (variableList == null) {
                    variableList = new ArrayList<>();
                }
                variable = new VariableInfo();
        } else if (qName.equalsIgnoreCase("Id") && IsVariable) {
            if (qName.equalsIgnoreCase("Id")) {
                variableId = true;
            }
        } else if (qName.equalsIgnoreCase("Name") && IsVariable) {
            variableName = true;
        } else if (qName.equalsIgnoreCase("Properties") && IsVariable) {
            variable.setValue(attributes.getValue("Value"));
            variable.setType(attributes.getValue("Type"));
        } else if (qName.equalsIgnoreCase("composition") && !IsComposition) {
            IsComposition = true;  
            if (compositionList == null) {
                compositionList = new ArrayList<>();
            }
            composition = new Composition();  
        } else if (qName.equalsIgnoreCase("connector") && IsComposition) {
            if (compositionList == null) {
                compositionList = new ArrayList<>();
            }
            composition = new Composition();  
        }
        
        else if (qName.equalsIgnoreCase("Id") && IsComposition) {

            compositionId = true;
        }
        
        else if (qName.equalsIgnoreCase("Sender") && IsComposition) {

            compositionSender = true;
        }
        
        else if (qName.equalsIgnoreCase("Receiver") && IsComposition) {

            compositionReceiver = true;
        }
        
        else if (qName.equalsIgnoreCase("Transistion") && IsComposition) {
            compositionTransition = true;
        }
        
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Component")) {
             IsAdded=false;
            componentList.add(component);
            IsComponent = false;
        } else if (qName.equalsIgnoreCase("State") && IsState) {
            stateList.add(state);
            IsState = false;
        } else if (qName.equalsIgnoreCase("Transition") && IsTransition) {
            transitionList.add(transition);
            IsTransition = false;
        } else if ((qName.equalsIgnoreCase("InputVariable") || qName.equalsIgnoreCase("OutputVariable")) && IsVariable) {
            variableList.add(variable);
            IsVariable = false;
        }  else if (qName.equalsIgnoreCase("composition") && IsComposition) {
            compositionTransition = false;
            IsComposition = false;
        } else if (qName.equalsIgnoreCase("connector") && IsComposition) {
           
            compositionList.add(composition);
            compositionId = false;
            compositionSender = false;
            compositionReceiver = false;
            compositionTransition = false;
            compositionTransition = false;
        }
    }
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (componentId && !IsAdded) {
            component.setId(new String(ch, start, length));
            componentId = false;
        } else if (componentName && !IsAdded) {
            component.setName(new String(ch, start, length));
            componentName = false;
            IsAdded=true;
        } else if (stateId) {
            state.setId(new String(ch, start, length));
            stateId = false;
        } else if (stateName) {
            state.setName(new String(ch, start, length));
            stateName = false;
        } else if (transitionId) {
            transition.setId(new String(ch, start, length));
            transitionId = false;
        } else if (transitionName) {
            transition.setName(new String(ch, start, length));
            transitionName = false;
        } else if (transitionAction) {
            String result = new String(ch, start, length);
            if (!result.trim().isEmpty()) {
            transition.setAction(result);
            }
            transitionAction = false;
        } else if (transitionEvent) {
            String result = new String(ch, start, length);
            if (!result.isEmpty()) {
                transition.setEvent(result);
            }
            transitionEvent = false;
        } else if (transitionGuard) {
            transition.setGuard(""+new String(ch, start, length)+"");
            transitionGuard = false;
        } else if (variableId) {
            variable.setId(new String(ch, start, length));
            variableId = false;
        } else if (variableName) {
            variable.setName(new String(ch, start, length));
            variableName = false;
        } else if (IsInitial) {
            String s = new String(ch, start, length);
            if (s.equalsIgnoreCase("true"))
                    {
                        state.setIsInitial(s);
                        state.setInitialId("1536569694013");
                        state.setInitialName("StateChart"); 
                    }
             IsInitial = false;
        } else if (compositionId) {
            composition.setId(new String(ch, start, length));
            compositionId = false;
        } else if (compositionSender) {
            composition.setSender(new String(ch, start, length));
            compositionSender = false;
        } else if (compositionReceiver) {
            composition.setReceiver(new String(ch, start, length));
            compositionReceiver = false;
        } else if (compositionTransition) {
            composition.setTransition(new String(ch, start, length));
            compositionTransition = false;
        } 
        

    }
}

