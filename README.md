<p><strong>EFSM XML Transformation to Anylogic:</strong></p>
<p>There are two types of XML provided to Transformation Tool:</p>
<ol>
<li>Base Component XML</li>
<li>Composed Model XML</li>
</ol>
<p><strong>Base Component XML: </strong>It is the xml of an independent component. Each base component has following:</p>
<table>
<tbody>
<tr>
<td width="573">
<ul>
<li><strong>Id: </strong>The id of the Base Component. It is a unique 13 digit integer value.</li>
<li><strong>Name: </strong>The name of the Base Component.</li>
<li><strong>Description: </strong>The small text description to define the functionality of the component.</li>
<li><strong>Input Variables: </strong>provides values to an action when it is triggered.</li>
<li><strong>Input Variable Properties:</strong>
<ul>
<li><strong>Id: </strong>&nbsp;The id of variable. It is a unique 13 digit integer value.</li>
<li><strong>Name:</strong> The name of variable. It uses to identify the variable.</li>
</ul>
</li>
<li><strong>Properties:</strong>
<ul>
<li><strong>Type: </strong>It defines the type of variable i.e. Integer, String.</li>
<li><strong>Value: </strong>holds value of variable to initialize.</li>
</ul>
</li>
<li><strong>Output Variables: </strong>stores output of the action.</li>
<li><strong>Output Variable Properties:</strong>
<ul>
<li><strong>Id: </strong>&nbsp;The id of variable. It is a unique 13 digit integer value.</li>
<li><strong>Name:</strong> The name of variable. It uses to identify the variable.</li>
</ul>
</li>
<li><strong>Properties:</strong>
<ul>
<li><strong>Type: </strong>It defines the type of variable i.e. Integer, String.</li>
<li><strong>Value: </strong>holds value of variable to initialize.</li>
</ul>
</li>
</ul>
<p><strong>&nbsp;</strong></p>
<ul>
<li><strong>State: </strong>represents a location of control with a particular set of reactions to conditions and/or events.</li>
<li><strong>State Properties:</strong>
<ul>
<li><strong>Id: </strong>&nbsp;The id of State. It is a unique 13 digit integer value.</li>
<li><strong>Name:</strong> The name of State. It uses to identify the State.</li>
<li><strong>Initialize: </strong>It defines either the State is initial or not. It has a Boolean type values i.e. true or false. In case of true it considers as an initial state.</li>
</ul>
</li>
</ul>
<p><strong>&nbsp;</strong></p>
<ul>
<li><strong>Transition:</strong> A transition denotes a switch from one state to another. A transition indicates that if the specified trigger event occurs and the specified guard condition is true, the statechart switches from one state to another and performs the specified action.</li>
<li><strong>Transition Properties:</strong>
<ul>
<li><strong>Id: </strong>&nbsp;The id of Transition. It is a unique 13 digit integer value.</li>
<li><strong>Name:</strong> The name of Transition. It uses to identify the Transition.</li>
<li><strong>Guard: </strong>A guard is implemented on transitions. Transitions fire if the condition defined in guard comes true.</li>
<li><strong>Event:&nbsp; </strong>The name of Event. It has String data type.</li>
<li><strong>Properties:</strong>
<ul>
<li><strong>Source: </strong>The Id of the State to which it belongs.</li>
<li><strong>Target: </strong>The Id of the targeted State to which it has to move.</li>
<li><strong>Type: </strong>An event has two types:
<ul>
<li><strong>Receive: </strong>It waits for a defined message expected from connected components to receive.</li>
<li><strong>Send</strong>:&nbsp; It sends message to the connected components with the time delay of zero seconds. A message can be of type &lsquo;String&rsquo; or a complex object containing message parameters.</li>
<li><strong>Action: </strong>&nbsp;It implements the defined function. It uses to set input variables and write on to the output variables.</li>
</ul>
</li>
<li><strong>TimeFunction: </strong>It defines how much a transition has to wait before it triggers
<ul>
<li><strong>Type: </strong>It defines the type of time constraint.</li>
<li><strong>Value: </strong>It stores the integer type time value.</li>
<li><strong>Unit: </strong>It defines the unit of time in milliseconds, seconds, minute, hour.<strong>&nbsp;</strong></li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
</ul>
</td>
</tr>
</tbody>
</table>
<p><strong>Composed Model XML: </strong>It is the xml of composed components in model, schema of Composed Model is as follows:</p>
<table>
<tbody>
<tr>
<td width="573">
<ul>
<li><strong>Id: </strong>The id of connector. It is a unique 13 digit integer value.</li>
<li><strong>Transition: </strong>The name of Transition which is a source of connection between components.</li>
<li><strong>Sender: </strong>The id of Sender connector.</li>
<li><strong>Receiver: </strong>The id of Receiver connector.&nbsp;</li>
</ul>
</td>
</tr>
</tbody>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><strong>Player&rsquo;s Example:</strong></p>
<p>We have provided a Player Example to understand the transformation work. Suppose there are two players Player A and Player B. They are sending and receiving messages from each other via connected ports.</p>
<p>There would be three files required to make this model work:</p>
<ol>
<li>Base Component File (<strong>PlayerA.xml, PlayerB.xml</strong>):</li>
</ol>
<p style="padding-left: 60px;">&nbsp;These two files have input, output variables, state and transition details.</p>
<ol start="2">
<li>Composed Model File (<strong>Composition.xml</strong>): It has sender, receiver, transition and connector details.</li>
</ol>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><strong>How to Run:</strong></p>
<ol>
<li>Download Source Code.</li>
<li>Open it using any Net Beans.</li>
<li>Run the File</li>
<li>Provide EFSM XML file parameters like: <em>PlayerA.xml,PlayerB.xml,Composition.xml</em></li>
</ol>
