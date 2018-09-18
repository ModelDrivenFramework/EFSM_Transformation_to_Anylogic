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
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import com.efsm.xml.ComponentInfo;
import com.efsm.xml.StateEntryInfo;
import com.efsm.xml.StateInfo;
import com.efsm.xml.TransitionInfo;
import com.efsm.xml.VariableInfo;
import com.efsm.xml.Composition;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class XMLParser {
    
   public static String FilterStateName(String filter, List<StateInfo> slist) {
        for (StateInfo s : slist) {
            if (s.getId().equals(filter)) {
                return s.getName();
            }
        }
        return "";
    }

    public static String FilterTransitionSourceTarget(String filter, List<TransitionInfo> tlist, String trigger) {
        switch (trigger) {
            case "source":
                for (TransitionInfo t : tlist) {
                    if (t.getTarget().equals(filter)) {
                        return t.getSource();
                    }
                }
                break;
            case "target":
                for (TransitionInfo t : tlist) {
                    if (t.getSource().equals(filter)) {
                        return t.getTarget();
                    }
                }
                break;
        }

        return "";
    }
    
     public static List<ComponentInfo> AddComponent(Handler handler, List<ComponentInfo> componentList) {

        List<ComponentInfo> clist = handler.getComponents();
        if (clist != null && !clist.isEmpty()) {

            for (ComponentInfo obj : clist) {
                
                componentList.add(obj);
            }
        }
        return componentList;
     }
    public static String ReadComponent(Handler handler) {
        String output_display = "";

        List<ComponentInfo> clist = handler.getComponents();
        
    
        if (clist != null && !clist.isEmpty()) {

            for (ComponentInfo obj : clist) {
;
                output_display += "<Id>" + obj.getId() + "</Id>\n"
                        + "			<Name><![CDATA[" + obj.getName() + "]]></Name>\n"
                        + "			\n"
                        + "			<GenericParameter>\n"
                        + "				<Id>" + obj.getId() + "</Id>\n"
                        + "				<Name><![CDATA[" + obj.getId() + "]]></Name>\n"
                        + "				<GenericParameterValue Class=\"CodeValue\">\n"
                        + "					<Code><![CDATA[T extends Agent]]></Code>\n"
                        + "				</GenericParameterValue>\n"
                        + "				<GenericParameterLabel><![CDATA[Generic parameter:]]></GenericParameterLabel>\n"
                        + "			</GenericParameter>\n"
                        + "\n"
                        + "			<FlowChartsUsage>ENTITY</FlowChartsUsage>\n"
                        + "			\n"
                        + "			<AgentProperties>\n"
                        + "	 			<SpaceType>CONTINUOUS</SpaceType>			\n"
                        + "				<EnvironmentDefinesInitialLocation>true</EnvironmentDefinesInitialLocation>\n"
                        + "				<RotateAnimationTowardsMovement>true</RotateAnimationTowardsMovement>\n"
                        + "				<RotateAnimationVertically>false</RotateAnimationVertically>\n"
                        + "				<VelocityCode Class=\"CodeUnitValue\">\n"
                        + "					<Code><![CDATA[10]]></Code>\n"
                        + "					<Unit Class=\"SpeedUnits\"><![CDATA[MPS]]></Unit>\n"
                        + "				</VelocityCode>\n"
                        + "			</AgentProperties>\n"
                        + "\n"
                        + "	\n"
                        + "			\n";

                output_display += "<Ports>\n"
                        + "				<Port>\n"
                        + "					<Id>1469136621862</Id>\n"
                        + "					<Name><![CDATA[SendPort]]></Name>\n"
                        + "					<X>25</X><Y>0</Y>\n"
                        + "					<Label><X>3</X><Y>0</Y></Label>\n"
                        + "					<PublicFlag>true</PublicFlag>\n"
                        + "					<PresentationFlag>true</PresentationFlag>\n"
                        + "					<ShowLabel>true</ShowLabel>\n"
                        + "					<IncomingMessageType><![CDATA[Object]]></IncomingMessageType>\n"
                        + "					<OutgoingMessageType><![CDATA[Object]]></OutgoingMessageType>\n"
                        + "				</Port>\n"
                        + "				<Port>\n"
                        + "					<Id>1469138846409</Id>\n"
                        + "					<Name><![CDATA[ReceivePort]]></Name>\n"
                        + "					<X>-25</X><Y>0</Y>\n"
                        + "					<Label><X>-35</X><Y>0</Y></Label>\n"
                        + "					<PublicFlag>true</PublicFlag>\n"
                        + "					<PresentationFlag>true</PresentationFlag>\n"
                        + "					<ShowLabel>true</ShowLabel>\n"
                        + "					<IncomingMessageType><![CDATA[Object]]></IncomingMessageType>\n"
                        + "					<OutgoingMessageType><![CDATA[Object]]></OutgoingMessageType>\n"
                        + "				</Port>\n"
                        + "\n"
                        + "\n"
                        + "			</Ports>";
            }
        }
        return output_display;
    }

    public static String ReadStartup(Handler handler) {
        String output_display = "";
        List<StateInfo> slist = handler.getStates();
        for (StateInfo sobj : slist) {
                   if ((sobj.getIsInitial() != null) && !sobj.getIsInitial().trim().isEmpty() && sobj.getIsInitial().equalsIgnoreCase("true")) {
                        output_display += "<StartupCode><![CDATA[ReceivePort.map(" + sobj.getInitialName()+ ");]]></StartupCode>";

                          
                    }
                }
        
        return output_display;
    }

    public static String ReadStates(Handler handler) {
        String output_display = "";

        List<StateInfo> slist = handler.getStates();
        if (slist != null && !slist.isEmpty()) {

            for (StateInfo sobj : slist) {

                if ((sobj.getId() != null) && !sobj.getId().trim().isEmpty()) {
                    output_display += "<StatechartElement Class=\"State\" ParentState=\"ROOT_NODE\">\n"
                            + "<Id>" + sobj.getId() + "</Id>\n"
                            + "<Name><![CDATA[" + sobj.getName() + "]]></Name><X>150</X><Y>90</Y>\n"
                            + "					<Label><X>30</X><Y>15</Y></Label>\n"
                            + "					<PublicFlag>false</PublicFlag>\n"
                            + "					<PresentationFlag>true</PresentationFlag>\n"
                            + "					<ShowLabel>true</ShowLabel>\n"
                            + "					<Properties Width=\"100\" Height=\"30\">\n"
                            + "					</Properties>\n"
                            + "				</StatechartElement>\n";
                }
                if ((sobj.getIsInitial() != null) && !sobj.getIsInitial().trim().isEmpty() && sobj.getIsInitial().equalsIgnoreCase("true")) {
                    output_display += "<StatechartElement Class=\"EntryPoint\" ParentState=\"ROOT_NODE\">\n"
                            + "					<Id>" + sobj.getInitialId() + "</Id>\n"
                            + "					<Name><![CDATA[" + sobj.getInitialName() + "]]></Name>\n "
                            + "					<X>230</X><Y>300</Y>\n"
                            + "					<Label><X>10</X><Y>0</Y></Label>\n"
                            + "					<PublicFlag>false</PublicFlag>\n"
                            + "					<PresentationFlag>true</PresentationFlag>\n"
                            + "					<ShowLabel>true</ShowLabel>\n"
                            + "					<Points>\n"
                            + "						<Point><X>0</X><Y>0</Y></Point>\n"
                            + "						<Point><X>0</X><Y>-70</Y></Point>\n"
                            + "					</Points>\n"
                            + "					<Properties Target=\"" + sobj.getId() + "\">\n"
                            + "					</Properties>	\n"
                            + "				</StatechartElement>";
                }
            }
        }
        return output_display;
    }
    
     public static String ReadTransitions(Handler handler) {
        String output_display = "";

        List<TransitionInfo> tlist = handler.getTransitions();
        tlist = handler.getTransitions();
        if (tlist != null && !tlist.isEmpty()) {

            for (TransitionInfo tobj : tlist) {
                 if ((tobj != null)) {
                String id = tobj.getId();
                String name = tobj.getName();
                String source = tobj.getSource();
                String target = tobj.getTarget();
                String action = tobj.getAction();
                String guard = tobj.getGuard();
                String event = tobj.getEvent();
                String type = tobj.getType();
                String timeType = tobj.getTimeoutType();
                String timeValue = tobj.getTimeoutValue();
                String timeUnit = tobj.getTimeoutUnit();
            

                if (type.equals("Receive")) {

                    output_display += "<StatechartElement Class=\"Transition\" ParentState=\"ROOT_NODE\">\n"
                            + "					<Id>" + id + "</Id>\n"
                            + "					<Name><![CDATA[" +name + "]]></Name>\n"
                            + "					<X>170</X><Y>200</Y>\n"
                            + "					<Label><X>10</X><Y>0</Y></Label>\n"
                            + "					<PublicFlag>false</PublicFlag>\n"
                            + "					<PresentationFlag>true</PresentationFlag>\n"
                            + "					<ShowLabel>false</ShowLabel>\n"
                            + "					<Points>\n"
                            + "						<Point><X>0</X><Y>0</Y></Point>\n"
                            + "						<Point><X>0</X><Y>-80</Y></Point>\n"
                            + "					</Points>\n"
                            + "					<IconOffset>20.0</IconOffset>\n"
                            + "					<Properties Source=\"" + source + "\" Target=\"" + target + "\" Trigger=\"message\">\n"
                            + "					<Guard><![CDATA[" + guard + "]]></Guard>"
                            + "					<Action><![CDATA[" + action + "]]></Action>\n"
                            + "						<Condition><![CDATA[true]]></Condition>\n"
                            + "						<MessageType><![CDATA[Object]]></MessageType>\n"
                            + "						<DefaultTransition>true</DefaultTransition>\n"
                            + "						<FilterType><![CDATA[equalsTo]]></FilterType>\n"
                            + "						<EqualsExpression><![CDATA[\"" + event + "\"]]></EqualsExpression>\n"
                            + "						<SatisfiesExpression><![CDATA[true]]></SatisfiesExpression>\n"
                            + "					</Properties>	\n"
                            + "				</StatechartElement>";

                } else if (type.equals("Send")) {

                    output_display += "<StatechartElement Class=\"Transition\" ParentState=\"ROOT_NODE\">\n"
                            + "					<Id>" + id + "</Id>\n"
                            + "					<Name><![CDATA[" + name + "]]></Name>\n"
                            + "					<X>170</X><Y>200</Y>\n"
                            + "					<Label><X>10</X><Y>0</Y></Label>\n"
                            + "					<PublicFlag>false</PublicFlag>\n"
                            + "					<PresentationFlag>true</PresentationFlag>\n"
                            + "					<ShowLabel>false</ShowLabel>\n"
                            + "					<Points>\n"
                            + "						<Point><X>0</X><Y>0</Y></Point>\n"
                            + "						<Point><X>0</X><Y>-80</Y></Point>\n"
                            + "					</Points>\n"
                            + "					<IconOffset>20.0</IconOffset>\n"
                            + "					<Properties Source=\"" + source + "\" Target=\"" + target + "\" Trigger=\"timeout\">\n"
                            + "					<Guard><![CDATA[" + guard + "]]></Guard>";
               if(event!=null && !event.trim().isEmpty())
                                        {
                            
                    output_display +="				<Action><![CDATA[SendPort.send(\"" + event + "\");" + action + "]]></Action>\n";
                                        }
                                    else
                                        {
                    output_display +="				<Action><![CDATA[" + action + "]]></Action>\n";
                    }
                    output_display +="	<Timeout Class=\"CodeUnitValue\">\n"
                            + "						<Code><![CDATA[" + timeValue + "]]></Code>\n"
                            + "					<Unit Class=\"TimeUnits\"><![CDATA[" + timeUnit + "]]></Unit>\n"
                            + "					</Timeout>\n"
                            + "					<Condition><![CDATA[true]]></Condition>\n"
                            + "					<MessageType><![CDATA[Object]]></MessageType>\n"
                            + "					<DefaultTransition>true</DefaultTransition>\n"
                            + "					<FilterType><![CDATA[unconditionally]]></FilterType>\n"
                            + "					<EqualsExpression><![CDATA[\"\"]]></EqualsExpression>\n"
                            + "					<SatisfiesExpression><![CDATA[true]]></SatisfiesExpression>\n"
                            + "					</Properties>	\n"
                            + "				</StatechartElement>";

                }

            }

        }
        }

        return output_display;
    }

    public static String ReadVariables(Handler handler) {
        String output_display = "";
        List<VariableInfo> vlist = handler.getVariables();

        if (vlist != null && !vlist.isEmpty()) {
            for (VariableInfo vobj : vlist) {
                 if ((vobj.getId() != null) && !vobj.getId().trim().isEmpty()) {
                output_display += "<Variable Class=\"PlainVariable\">\n"
                        + "					<Id>" + vobj.getId() + "</Id>\n"
                        + "					<Name><![CDATA[" + vobj.getName() + "]]></Name>\n"
                        + "<X>100</X><Y>150</Y>\n"
                        + "					<Label><X>10</X><Y>0</Y></Label>\n"
                        + "					<PublicFlag>false</PublicFlag>\n"
                        + "					<PresentationFlag>true</PresentationFlag>\n"
                        + "					<ShowLabel>true</ShowLabel>\n"
                        + "					<Properties SaveInSnapshot=\"true\" Constant=\"false\" AccessType=\"public\" StaticVariable=\"false\">\n"
                        + "						<Type><![CDATA[" + vobj.getType() + "]]></Type>        \n"
                        + "						<InitialValue Class=\"CodeValue\">\n"
                        + "							<Code><![CDATA[" + vobj.getValue() + "]]></Code>\n"
                        + "						</InitialValue>\n"
                        + "					</Properties>"
                        + "				</Variable>";
            }
            }
        }
        return output_display;
    }

   
    public static String ReadEmbeddedObjects(Handler handler) {
        String output_display = "";

        List<ComponentInfo> clist = handler.getComponents();
        if (clist != null && !clist.isEmpty()) {
            for (ComponentInfo obj : clist) {

                output_display += "<EmbeddedObject>\n"
                        + "					<Id>" + obj.getId() + "</Id>\n"
                        + "					<Name><![CDATA[" + obj.getName() + "]]></Name>\n"
                        + "					<X>260</X><Y>190</Y>\n"
                        + "					<Label><X>10</X><Y>-35</Y></Label>\n"
                        + "					<PublicFlag>false</PublicFlag>\n"
                        + "					<PresentationFlag>true</PresentationFlag>\n"
                        + "					<ShowLabel>true</ShowLabel>\n"
                        + "					<ActiveObjectClass>\n"
                        + "						<PackageName><![CDATA[model]]></PackageName>\n"
                        + "						<ClassName><![CDATA[" + obj.getName() + "]]></ClassName>\n"
                        + "					</ActiveObjectClass>\n"
                        + "					<GenericParameterSubstitute>\n"
                        + "						<GenericParameterSubstituteReference>\n"
                        + "							<PackageName><![CDATA[model]]></PackageName>\n"
                        + "							<ClassName><![CDATA[" + obj.getName() + "]]></ClassName>\n"
                        + "							<ItemName><![CDATA[" + obj.getId() + "]]></ItemName>\n"
                        + "						</GenericParameterSubstituteReference>\n"
                        + "					</GenericParameterSubstitute>\n"
                        + "					<Parameters>\n"
                        + "					</Parameters>\n"
                        + "					<ReplicationFlag>false</ReplicationFlag>\n"
                        + "					<Replication Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[100]]></Code>\n"
                        + "					</Replication>\n"
                        + "					<CollectionType>ARRAY_LIST_BASED</CollectionType>\n"
                        + "					<InEnvironment>true</InEnvironment>	\n"
                        + "					<InitialLocationType>AT_ANIMATION_POSITION</InitialLocationType>\n"
                        + "					<XCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[0]]></Code>\n"
                        + "					</XCode>\n"
                        + "					<YCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[0]]></Code>\n"
                        + "					</YCode>\n"
                        + "					<ZCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[0]]></Code>\n"
                        + "					</ZCode>\n"
                        + "					<ColumnCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[0]]></Code>\n"
                        + "					</ColumnCode>\n"
                        + "					<RowCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[0]]></Code>\n"
                        + "					</RowCode>\n"
                        + "					<LatitudeCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[0]]></Code>\n"
                        + "					</LatitudeCode>\n"
                        + "					<LongitudeCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[0]]></Code>\n"
                        + "					</LongitudeCode>\n"
                        + "					<LocationNameCode Class=\"CodeValue\">\n"
                        + "						<Code><![CDATA[\"\"]]></Code>\n"
                        + "					</LocationNameCode>\n"
                        + "					<InitializationType>SPECIFIED_NUMBER</InitializationType>\n"
                        + "					<InitializationDatabaseTableQuery>\n"
                        + "						<TableReference>\n"
                        + "						</TableReference>\n"
                        + "					</InitializationDatabaseTableQuery>\n"
                        + "					<InitializationDatabaseType>ONE_AGENT_PER_DATABASE_RECORD</InitializationDatabaseType>\n"
                        + "					<QuantityColumn>\n"
                        + "					</QuantityColumn>\n"
                        + "				</EmbeddedObject>\n";

            }
        }
        return output_display;

    }

    public static String ReadComposition(Handler handler, List<ComponentInfo> componentList) {
        String output_display = "";
        List<Composition> clist = handler.getComposition();
        
        if (clist != null && !clist.isEmpty()) {
       
            String connections = "";
            for (Composition obj : clist) {
                String Id = obj.getId();
                String Sender = "";
                String Receiver = "";
                for (ComponentInfo cobj : componentList) {
                  
                    if(cobj.getId().equals(obj.getSender()))
                    {
        
                        Sender = cobj.getName();
                    }
                    
                    if(cobj.getId().equals(obj.getReceiver()))
                    {
                        Receiver = cobj.getName();
                    }
              }
                 
               if(!Sender.isEmpty() && !Receiver.isEmpty())   
               {
                 
                if (connections.contains("{[" + Sender + "_" + Receiver + "]}")) {

                } else {
             
                    connections += "{[" + Sender + "_" + Receiver + "]}";
                    output_display += "<Connector>\n"
                            + "					<Id>" + Id + "</Id>\n"
                            + "					<Name><![CDATA[" + Sender + "_" + Receiver + "]]></Name>\n"
                            + "					<X>175</X><Y>190</Y>\n"
                            + "					<Label><X>10</X><Y>0</Y></Label>\n"
                            + "					<PublicFlag>false</PublicFlag>\n"
                            + "					<PresentationFlag>true</PresentationFlag>\n"
                            + "					<ShowLabel>false</ShowLabel>\n"
                            + "					<SourceEmbeddedObjectReference>\n"
                            + "						<PackageName><![CDATA[model]]></PackageName>\n"
                            + "						<ClassName><![CDATA[Main]]></ClassName>\n"
                            + "						<ItemName><![CDATA[" + Sender + "]]></ItemName>\n"
                            + "					</SourceEmbeddedObjectReference>\n"
                            + "					<SourceConnectableItemReference>\n"
                            + "						<PackageName><![CDATA[model]]></PackageName>\n"
                            + "						<ClassName><![CDATA[" + Sender + "]]></ClassName>\n"
                            + "						<ItemName><![CDATA[ReceivePort]]></ItemName>\n"
                            + "					</SourceConnectableItemReference>\n"
                            + "					<TargetEmbeddedObjectReference>\n"
                            + "						<PackageName><![CDATA[model]]></PackageName>\n"
                            + "						<ClassName><![CDATA[Main]]></ClassName>\n"
                            + "						<ItemName><![CDATA[" + Receiver + "]]></ItemName>\n"
                            + "					</TargetEmbeddedObjectReference>\n"
                            + "					<TargetConnectableItemReference>\n"
                            + "						<PackageName><![CDATA[model]]></PackageName>\n"
                            + "						<ClassName><![CDATA[" + Receiver + "]]></ClassName>\n"
                            + "						<ItemName><![CDATA[SendPort]]></ItemName>\n"
                            + "					</TargetConnectableItemReference>\n"
                            + "					<Points>\n"
                            + "						<Point><X>0</X><Y>0</Y></Point>\n"
                            + "						<Point><X>95</X><Y>-50</Y></Point>\n"
                            + "						<Point><X>80</X><Y>-90</Y></Point>\n"
                            + "					</Points>\n"
                            + "				</Connector>";
                    
                } 
            }
            }
        }
        return output_display;
    }

    public static void main(String[] args) {

        
        String output_display = "";
        List<ComponentInfo> componentList = new ArrayList<>();
        try {

         
        
            
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            Handler handler = new Handler();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("SystemEnvironment.xml"), handler);  
            
            
            SAXParserFactory saxParserFactoryb = SAXParserFactory.newInstance();
            Handler handlerb = new Handler();
            SAXParser saxParserb = saxParserFactoryb.newSAXParser();
            saxParserb.parse(new File("Sensor.xml"), handlerb);
            
            SAXParserFactory saxParserFactoryc = SAXParserFactory.newInstance();
            Handler handlerc = new Handler();
            SAXParser saxParserc = saxParserFactoryc.newSAXParser();
            saxParserc.parse(new File("Controller.xml"), handlerc);
            
            SAXParserFactory saxParserFactoryd = SAXParserFactory.newInstance();
            Handler handlerd = new Handler();
            SAXParser saxParserd = saxParserFactoryd.newSAXParser();
            saxParserd.parse(new File("Actuator.xml"), handlerd);

            output_display += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "<!--\n"
                    + "*************************************************\n"
                    + "	         AnyLogic Project File \n"
                    + "*************************************************	         \n"
                    + "-->\n"
                    + "<AnyLogicWorkspace WorkspaceVersion=\"1.9\" AnyLogicVersion=\"7.3.4.201605201237\" AlpVersion=\"7.3.3\">\n"
                    + "<Model>\n"
                    + "	<Id>1469124059737</Id>\n"
                    + "	<Name><![CDATA[Model]]></Name>\n"
                    + "	<EngineVersion>6</EngineVersion>\n"
                    + "	<JavaPackageName><![CDATA[model]]></JavaPackageName>\n"
                    + "	<ModelTimeUnit><![CDATA[Second]]></ModelTimeUnit>\n"
                    + "\n"
                    + "<ActiveObjectClasses>\n <!--   =========   Active Object Class   ========  -->\n"
                    + "		<ActiveObjectClass>\n"
                    + "			<Id>1469124059739</Id>\n"
                    + "			<Name><![CDATA[Main]]></Name>\n"
                    + "			<ClientAreaTopLeft><X>0</X><Y>0</Y></ClientAreaTopLeft>\n"
                    + "			<PresentationTopGroupPersistent>true</PresentationTopGroupPersistent>\n"
                    + "			<IconTopGroupPersistent>true</IconTopGroupPersistent>\n"
                    + "			<Generic>false</Generic>\n"
                    + "			<GenericParameter>\n"
                    + "				<Id>1469134246247</Id>\n"
                    + "				<Name><![CDATA[1469134246247]]></Name>\n"
                    + "				<GenericParameterValue Class=\"CodeValue\">\n"
                    + "					<Code><![CDATA[T]]></Code>\n"
                    + "				</GenericParameterValue>\n"
                    + "				<GenericParameterLabel><![CDATA[Generic parameters:]]></GenericParameterLabel>\n"
                    + "			</GenericParameter>\n"
                    + "			<FlowChartsUsage>ENTITY</FlowChartsUsage>\n"
                    + "			<SamplesToKeep>100</SamplesToKeep>\n"
                    + "			<LimitNumberOfArrayElements>false</LimitNumberOfArrayElements>\n"
                    + "			<ElementsLimitValue>100</ElementsLimitValue>\n"
                    + "			<MakeDefaultViewArea>true</MakeDefaultViewArea>\n"
                    + "			<SceneGridColor/>\n"
                    + "			<SceneBackgroundColor/>\n"
                    + "			<AgentProperties>\n"
                    + "	 			<SpaceType>CONTINUOUS</SpaceType>			\n"
                    + "				<EnvironmentDefinesInitialLocation>true</EnvironmentDefinesInitialLocation>\n"
                    + "				<RotateAnimationTowardsMovement>true</RotateAnimationTowardsMovement>\n"
                    + "				<RotateAnimationVertically>false</RotateAnimationVertically>\n"
                    + "			</AgentProperties>\n"
                    + "<EnvironmentProperties>\n"
                    + "					<EnableSteps>false</EnableSteps>\n"
                    + "					<StepDurationCode Class=\"CodeUnitValue\">\n"
                    + "						<Code><![CDATA[1.0]]></Code>\n"
                    + "						<Unit Class=\"TimeUnits\"><![CDATA[SECOND]]></Unit>\n"
                    + "					</StepDurationCode>\n"
                    + "					<SpaceType>CONTINUOUS</SpaceType>\n"
                    + "					<WidthCode><![CDATA[500]]></WidthCode>\n"
                    + "					<HeightCode><![CDATA[500]]></HeightCode>\n"
                    + "					<ZHeightCode><![CDATA[0]]></ZHeightCode>\n"
                    + "					<ColumnsCountCode><![CDATA[100]]></ColumnsCountCode>\n"
                    + "					<RowsCountCode><![CDATA[100]]></RowsCountCode>\n"
                    + "					<NeigborhoodType>MOORE</NeigborhoodType>\n"
                    + "					<LayoutType>USER_DEF</LayoutType>\n"
                    + "					<LayoutTypeApplyOnStartup>true</LayoutTypeApplyOnStartup>\n"
                    + "					<NetworkType>USER_DEF</NetworkType>\n"
                    + "					<NetworkTypeApplyOnStartup>true</NetworkTypeApplyOnStartup>\n"
                    + "					<ConnectionsPerAgentCode><![CDATA[2]]></ConnectionsPerAgentCode>\n"
                    + "					<ConnectionsRangeCode><![CDATA[50]]></ConnectionsRangeCode>\n"
                    + "					<NeighborLinkFractionCode><![CDATA[0.95]]></NeighborLinkFractionCode>\n"
                    + "					<MCode><![CDATA[10]]></MCode>\n"
                    + "			</EnvironmentProperties>\n"
                    + "			<DatasetsCreationProperties>\n"
                    + "				<AutoCreate>true</AutoCreate>\n"
                    + "					<OccurrenceAtTime>true</OccurrenceAtTime>\n"
                    + "					<OccurrenceDate>1537084800000</OccurrenceDate>\n"
                    + "					<OccurrenceTime Class=\"CodeUnitValue\">\n"
                    + "						<Code><![CDATA[0]]></Code>\n"
                    + "						<Unit Class=\"TimeUnits\"><![CDATA[SECOND]]></Unit>\n"
                    + "					</OccurrenceTime>\n"
                    + "					<RecurrenceCode Class=\"CodeUnitValue\">\n"
                    + "						<Code><![CDATA[1]]></Code>\n"
                    + "						<Unit Class=\"TimeUnits\"><![CDATA[SECOND]]></Unit>\n"
                    + "					</RecurrenceCode>\n"
                    + "			</DatasetsCreationProperties>\n"
                    + "			<ScaleRuler>\n"
                    + "				<Id>1537081567638</Id>\n"
                    + "				<Name><![CDATA[scale]]></Name>\n"
                    + "				<X>0</X><Y>-150</Y>\n"
                    + "				<PublicFlag>false</PublicFlag>\n"
                    + "				<PresentationFlag>false</PresentationFlag>\n"
                    + "				<ShowLabel>false</ShowLabel>\n"
                    + "				<DrawMode>SHAPE_DRAW_2D3D</DrawMode>\n"
                    + "				<Length>100</Length>\n"
                    + "				<Rotation>0</Rotation>\n"
                    + "				<ScaleType>BASED_ON_LENGTH</ScaleType>\n"
                    + "				<ModelLength>10</ModelLength>\n"
                    + "				<LengthUnits>METER</LengthUnits>\n"
                    + "				<Scale>10</Scale>\n"
                    + "				<InheritedFromParentAgentType>true</InheritedFromParentAgentType>\n"
                    + "			</ScaleRuler>\n";

            output_display += "<ConnectionsId>1537080611596</ConnectionsId>\n"
                    + "<Connectors>";
            SAXParserFactory saxParserFactoryComposition = SAXParserFactory.newInstance();
            Handler handlerComposition = new Handler();
            SAXParser saxParserComposition = saxParserFactoryComposition.newSAXParser();
            saxParserComposition.parse(new File("Composition.xml"), handlerComposition);
            // System.out.println(handlerComposition.getComposition());
            
           componentList.addAll(AddComponent(handler, componentList));
           componentList.addAll(AddComponent(handlerb, componentList));
           componentList.addAll(AddComponent(handlerc, componentList));
           componentList.addAll(AddComponent(handlerd, componentList));

            output_display += ReadComposition(handlerComposition, componentList); 
            output_display += "</Connectors>\n";
            output_display += "<AgentLinks>\n"
                    + "				<AgentLink>\n"
                    + "					<Id>1537080611596</Id>\n"
                    + "					<Name><![CDATA[connections]]></Name>\n"
                    + "					<X>50</X><Y>-50</Y>\n"
                    + "					<Label><X>15</X><Y>0</Y></Label>\n"
                    + "					<PublicFlag>false</PublicFlag>\n"
                    + "					<PresentationFlag>true</PresentationFlag>\n"
                    + "					<ShowLabel>true</ShowLabel>\n"
                    + "					<HandleReceiveInConnections>false</HandleReceiveInConnections>\n"
                    + "					<AgentLinkType>COLLECTION_OF_LINKS</AgentLinkType>\n"
                    + "					<AgentLinkBidirectional>true</AgentLinkBidirectional>\n"
                    + "					<MessageType><![CDATA[Object]]></MessageType>\n"
                    + "					<LineStyle>SOLID</LineStyle>\n"
                    + "					<LineWidth>1</LineWidth>\n"
                    + "					<LineColor>-16777216</LineColor>\n"
                    + "					<LineZOrder>UNDER_AGENTS</LineZOrder>\n"
                    + "					<LineArrow>NONE</LineArrow>\n"
                    + "					<LineArrowPosition>END</LineArrowPosition>\n"
                    + "				</AgentLink>\n"
                    + "			</AgentLinks>";

            
            
            output_display += "<EmbeddedObjects>";
            output_display +=ReadEmbeddedObjects(handler);
            output_display +=ReadEmbeddedObjects(handlerb);
            output_display +=ReadEmbeddedObjects(handlerc);
            output_display +=ReadEmbeddedObjects(handlerd);
            output_display += "</EmbeddedObjects>";
            output_display += "</ActiveObjectClass>\n";
            output_display += "<ActiveObjectClass>\n";
            output_display += ReadStartup(handler);
            output_display += ReadComponent(handler);
           
            
            
            output_display += "<StatechartElements>\n";
            output_display += ReadStates(handler);
            output_display += ReadTransitions(handler);
            output_display += "</StatechartElements>\n";
            
            output_display += "<Variables>\n";
            output_display += ReadVariables(handler);
            output_display += "</Variables>\n";
            output_display += "</ActiveObjectClass>";
            
           
            output_display += "<ActiveObjectClass>\n";
            output_display += ReadStartup(handlerb);
            output_display += ReadComponent(handlerb);
          
            
            output_display += "<StatechartElements>\n";
            output_display += ReadStates(handlerb);
            output_display += ReadTransitions(handlerb);
            output_display += "</StatechartElements>\n";

            output_display += "<Variables>\n";
            output_display += ReadVariables(handlerb);
            output_display += "</Variables>\n";
            output_display += "</ActiveObjectClass>";
            
            
            
            output_display += "<ActiveObjectClass>\n";
            output_display += ReadStartup(handlerc);
            output_display += ReadComponent(handlerc);
          
            
            output_display += "<StatechartElements>\n";
            output_display += ReadStates(handlerc);
            output_display += ReadTransitions(handlerc);
            output_display += "</StatechartElements>\n";

            output_display += "<Variables>\n";
            output_display += ReadVariables(handlerc);
            output_display += "</Variables>\n";
            output_display += "</ActiveObjectClass>";
            
            
            
            output_display += "<ActiveObjectClass>\n";
            output_display += ReadStartup(handlerd);
            output_display += ReadComponent(handlerd);
          
            
            output_display += "<StatechartElements>\n";
            output_display += ReadStates(handlerd);
            output_display += ReadTransitions(handlerd);
            output_display += "</StatechartElements>\n";

            output_display += "<Variables>\n";
            output_display += ReadVariables(handlerd);
            output_display += "</Variables>\n";
            output_display += "</ActiveObjectClass>";

            //System.err.println(handlerb.getComponents());
            //System.err.println(handlerb.getStates());

            PrintWriter writer = new PrintWriter("Anylogic-Transformation.alp", "UTF-8");

            output_display += "</ActiveObjectClasses>	\n"
                    + "\n"
                    + "\n"
                    + "	<DifferentialEquationsMethod>EULER</DifferentialEquationsMethod>\n"
                    + "	<MixedEquationsMethod>RK45_NEWTON</MixedEquationsMethod>\n"
                    + "	<AlgebraicEquationsMethod>MODIFIED_NEWTON</AlgebraicEquationsMethod>\n"
                    + "	<AbsoluteAccuracy>1.0E-5</AbsoluteAccuracy>\n"
                    + "	<FixedTimeStep>0.001</FixedTimeStep>\n"
                    + "	<RelativeAccuracy>1.0E-5</RelativeAccuracy>\n"
                    + "	<TimeAccuracy>1.0E-5</TimeAccuracy>\n"
                    + "	<Database>\n"
                    + "		<Logging>false</Logging>\n"
                    + "		<AutoExport>false</AutoExport>\n"
                    + "		<ImportSettings>\n"
                    + "		</ImportSettings>\n"
                    + "		<ExportSettings>\n"
                    + "			<ExportExcelFilePath><![CDATA[]]></ExportExcelFilePath>\n"
                    + "		</ExportSettings>\n"
                    + "	</Database>	\n"
                    + "	<Experiments>	\n"
                    + "		<!--   =========   Simulation Experiment   ========  -->\n"
                    + "		<SimulationExperiment ActiveObjectClassId=\"1469124059739\">\n"
                    + "			<Id>1469124059753</Id>\n"
                    + "			<Name><![CDATA[Simulation]]></Name>\n"
                    + "			<ClientAreaTopLeft><X>0</X><Y>0</Y></ClientAreaTopLeft>\n"
                    + "			<PresentationTopGroupPersistent>true</PresentationTopGroupPersistent>\n"
                    + "			<IconTopGroupPersistent>true</IconTopGroupPersistent>\n"
                    + "			<Frame>\n"
                    + "				<X>0</X>\n"
                    + "				<Y>0</Y>\n"
                    + "				<Width>1000</Width>\n"
                    + "				<Height>600</Height>\n"
                    + "				<Maximized>false</Maximized>\n"
                    + "				<CloseConfirmation>false</CloseConfirmation>\n"
                    + "			</Frame>\n"
                    + "			<CommandLineArguments><![CDATA[]]></CommandLineArguments>\n"
                    + "			<MaximumMemory>256</MaximumMemory>\n"
                    + "			<RandomNumberGenerationType>randomSeed</RandomNumberGenerationType>\n"
                    + "			<CustomGeneratorCode>new Random()</CustomGeneratorCode>\n"
                    + "			<SeedValue>1</SeedValue>\n"
                    + "			<SelectionModeForSimultaneousEvents>LIFO</SelectionModeForSimultaneousEvents>\n"
                    + "			<VmArgs><![CDATA[]]></VmArgs>\n"
                    + "			<LoadRootFromSnapshot>false</LoadRootFromSnapshot>\n"
                    + "			<SnapshotFile></SnapshotFile>\n"
                    + "\n"
                    + "			<Shapes>\n"
                    + "				<Text>\n"
                    + "					<Id>1469124059754</Id>\n"
                    + "					<Name><![CDATA[text]]></Name>\n"
                    + "					<X>40</X><Y>30</Y>\n"
                    + "					<Label><X>10</X><Y>0</Y></Label>\n"
                    + "					<PublicFlag>true</PublicFlag>\n"
                    + "					<PresentationFlag>true</PresentationFlag>\n"
                    + "					<ShowLabel>false</ShowLabel>\n"
                    + "					<DrawMode>SHAPE_DRAW_2D3D</DrawMode>\n"
                    + "					<AsObject>true</AsObject>\n"
                    + "					<EmbeddedIcon>false</EmbeddedIcon>\n"
                    + "					<Z>0</Z>\n"
                    + "					<Rotation>0.0</Rotation>\n"
                    + "					<Color>-12490271</Color>\n"
                    + "					<Text><![CDATA[Model]]></Text>\n"
                    + "					<Font>\n"
                    + "						<Name>SansSerif</Name>\n"
                    + "						<Size>24</Size>\n"
                    + "						<Style>0</Style>\n"
                    + "					</Font>\n"
                    + "					<Alignment>LEFT</Alignment>\n"
                    + "				</Text>\n"
                    + "			</Shapes>\n"
                    + "			<Controls>\n"
                    + "				<Control Type=\"Button\">\n"
                    + "				 	<EmbeddedIcon>false</EmbeddedIcon>				\n"
                    + "					<Id>1469124059755</Id>\n"
                    + "					<Name><![CDATA[button]]></Name>\n"
                    + "					<X>40</X><Y>80</Y>\n"
                    + "					<Label><X>10</X><Y>0</Y></Label>\n"
                    + "					<PublicFlag>true</PublicFlag>\n"
                    + "					<PresentationFlag>true</PresentationFlag>\n"
                    + "					<ShowLabel>false</ShowLabel>\n"
                    + "					<BasicProperties Width=\"100\" Height=\"30\" \n"
                    + "				AsObject=\"true\">\n"
                    + "                        <EmbeddedIcon>false</EmbeddedIcon>				\n"
                    + "						<FillColor/>\n"
                    + "						<TextColor/>\n"
                    + "						<Enabled>true</Enabled>\n"
                    + "						<ActionCode><![CDATA[if ( getState() == IDLE )\n"
                    + "	run();\n"
                    + "getPresentation().setPresentable( getEngine().getRoot() );]]></ActionCode>\n"
                    + "					</BasicProperties>\n"
                    + "					<ExtendedProperties>\n"
                    + "						<Font Name=\"Dialog\" Size=\"11\" Style=\"0\"/>\n"
                    + "						<LabelText><![CDATA[Run]]></LabelText>\n"
                    + "						<LabelCode><![CDATA[getState() == IDLE ?\n"
                    + "	\"Run\" :\n"
                    + "	\"Top level agent\"]]></LabelCode>\n"
                    + "					</ExtendedProperties>\n"
                    + "				</Control>\n"
                    + "			</Controls>\n"
                    + "\n"
                    + "			<Parameters>			\n"
                    + "			</Parameters>			\n"
                    + "			<PresentationProperties \n"
                    + "				EnableAdaptiveFrameManagement=\"true\" \n"
                    + "				EnableAntiAliasing=\"true\"\n"
                    + "				EnableEnhancedModelElementsAnimation=\"true\"\n"
                    + "				EnablePanning=\"true\"\n"
                    + "				ToolbarCustomizableAtRuntime=\"true\"\n"
                    + "				EnableZoom=\"true\">\n"
                    + "				<ExecutionMode><![CDATA[realTimeScaled]]></ExecutionMode>\n"
                    + "				<CpuRatio><![CDATA[ratio_1_2]]></CpuRatio>	        \n"
                    + "				<Title><![CDATA[Model : Simulation]]></Title>	\n"
                    + "				<FramesPerSecond><![CDATA[20.0]]></FramesPerSecond>\n"
                    + "				<RealTimeScale>1.0</RealTimeScale>\n"
                    + "				<UIProperty Name=\"Experiment Progress\" Value=\"false\"/>\n"
                    + "				<UIProperty Name=\"Simulation Progress\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Events Per Second\" Value=\"false\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Frames Per Second\" Value=\"false\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Memory\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Model Date\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Model Step\" Value=\"false\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Model Time\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Real Time Of Simulation\" Value=\"false\"/>\n"
                    + "				<UIProperty Name=\"Statusbar Status\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Toolbar Animation setup\" Value=\"false\"/>\n"
                    + "				<UIProperty Name=\"Toolbar Execution control\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Toolbar File\" Value=\"false\"/>\n"
                    + "				<UIProperty Name=\"Toolbar Model navigation\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Toolbar Time scale setup\" Value=\"true\"/>\n"
                    + "				<UIProperty Name=\"Toolbar View\" Value=\"false\"/>\n"
                    + "			</PresentationProperties>\n"
                    + "			<ModelTimeProperties>\n"
                    + "				<StopOption><![CDATA[Never]]></StopOption>\n"
                    + "				<InitialDate><![CDATA[1469059200000]]></InitialDate>	\n"
                    + "				<InitialTime><![CDATA[0.0]]></InitialTime>	\n"
                    + "				<FinalDate><![CDATA[1471737600000]]></FinalDate>	\n"
                    + "				<FinalTime><![CDATA[100.0]]></FinalTime>	\n"
                    + "			</ModelTimeProperties>\n"
                    + "		</SimulationExperiment>	\n"
                    + "	</Experiments>\n"
                    + "    <RequiredLibraryReference>\n"
                    + "		<LibraryName><![CDATA[com.anylogic.libraries.processmodeling]]></LibraryName>\n"
                    + "		<VersionMajor>7</VersionMajor>\n"
                    + "		<VersionMinor>2</VersionMinor>\n"
                    + "		<VersionBuild>0</VersionBuild>\n"
                    + "    </RequiredLibraryReference>\n "
                    + "	<JavaClasses>\n"
                    + "		<!--   =========   Java Class   ========  -->\n"
                    + "		<JavaClass>\n"
                    + "			<Id>1525403027454</Id>\n"
                    + "			<Name><![CDATA[MessageEFSM_old]]></Name>\n"
                    + "			<ExcludeFromBuild>true</ExcludeFromBuild>\n"
                    + "			<Text><![CDATA[/**\n"
                    + " * MessageEFSM\n"
                    + " */	\n"
                    + "import java.util.*;\n"
                    + "import java.lang.*;\n"
                    + "\n"
                    + "public class MessageEFSM {\n"
                    + "\n"
                    + "    /**\n"
                    + "     * Default constructor\n"
                    + "     */\n"
                    + "	private String  name;\n"
                    + "	private List<Object> lstobj = new ArrayList<Object>();\n"
                    + "\n"
                    + "	\n"
                    + "    public MessageEFSM(String name,List<Object> lstobj)\n"
                    + "	{\n"
                    + "	 this.name = name;\n"
                    + "	 this.lstobj = lstobj;\n"
                    + "	}\n"
                    + "	\n"
                    + "	public String getName()\n"
                    + "	{\n"
                    + "	    return name;\n"
                    + "	}\n"
                    + "\n"
                    + "	public List<Object> getlstobj()\n"
                    + "	{\n"
                    + "	    return lstobj;\n"
                    + "	}\n"
                    + "	 \n"
                    + "	@Override\n"
                    + "	public String toString() {\n"
                    + "		return super.toString();\n"
                    + "	}\n"
                    + "	 \n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "}]]></Text>\n"
                    + "		</JavaClass>\n"
                    + "	</JavaClasses>"
                    + "</Model>\n"
                    + "</AnyLogicWorkspace>";
            System.out.print("User XML has been successfully Transformed!\n");
            System.out.print("Please view file with name Anylogic-XML in your folder!\n");
            System.out.print("File Output:\n");
            System.out.print(output_display);
            writer.println(output_display);
            writer.close();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
