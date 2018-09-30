## EFSM XML Transformation to Anylogic:
There are two types of XML provided to Transformation Tool:
![efsm](https://user-images.githubusercontent.com/43378781/46250765-354b5e80-c45b-11e8-8e2d-adc9f5a9b716.png)


**Base Component XML:** It is the xml of an independent component. Each base component has following:

- **Id:** The id of the Base Component. It is a unique 13 digit integer value.
- **Name:** The name of the Base Component.
- **Description:** The small text description to define the functionality of the component.
- **Input Variables:** provides values to an action when it is triggered.
- **Input Variable Properties:**
  - **Id:**  The id of variable. It is a unique 13 digit integer value.
  - **Name:**  The name of variable. It uses to identify the variable.
- **Properties:**
  - **Type:** It defines the type of variable i.e. Integer, String.
  - **Value:** holds value of variable to initialize.
- **Output Variables:** stores output of the action.
- **Output Variable Properties:**
  - **Id:**  The id of variable. It is a unique 13 digit integer value.
  - **Name:**  The name of variable. It uses to identify the variable.
- **Properties:**
  - **Type:** It defines the type of variable i.e. Integer, String.
  - **Value:** holds value of variable to initialize.

- **State:** represents a location of control with a particular set of reactions to conditions and/or events.
- **State Properties:**
  - **Id:**  The id of State. It is a unique 13 digit integer value.
  - **Name:**  The name of State. It uses to identify the State.
  - **Initialize:** It defines either the State is initial or not. It has a Boolean type values i.e. true or false. In case of true it considers as an initial state.

- **Transition:**  A transition denotes a switch from one state to another. A transition indicates that if the specified trigger event occurs and the specified guard condition is true, the statechart switches from one state to another and performs the specified action.
- **Transition Properties:**
  - **Id:**  The id of Transition. It is a unique 13 digit integer value.
  - **Name:**  The name of Transition. It uses to identify the Transition.
  - **Guard: ** A guard is implemented on transitions. Transitions fire if the condition defined in guard comes true.
  - **Event:** The name of Event. It has String data type.
  - **Properties:**
    - **Source:** The Id of the State to which it belongs.
    - **Target:** The Id of the targeted State to which it has to move.
    - **Type:** An event has two types:
      - **Receive: ** It waits for a defined message expected from connected components to receive.
      - **Send** :  It sends message to the connected components with the time delay of zero seconds. A message can be of type &#39;String&#39; or a complex object containing message parameters.
      - **Action:**  It implements the defined function. It uses to set input variables and write on to the output variables.
    - **TimeFunction:** It defines how much a transition has to wait before it triggers
      - **Type:** It defines the type of time constraint.
      - **Value:** It stores the integer type time value.
      - **Unit:** It defines the unit of time in milliseconds, seconds, minute, hour. ** **

**Composed Model XML:** It is the xml of composed components in model, schema of Composed Model is as follows:

- **Id:** The id of connector. It is a unique 13 digit integer value.
- **Transition:** The name of Transition which is a source of connection between components.
- **Sender:** The id of Sender connector.
- **Receiver:** The id of Receiver connector.

**Player&#39;s Example:**

We have provided a Player Example to understand the transformation work. Suppose there are two players Player A and Player B. They are sending and receiving messages from each other via connected ports.

There would be three files required to make this model work:

1. Base Component File ( **PlayerA.xml, PlayerB.xml** ): These two files have input, output variables, state and transition details.

2. Composed Model File ( **Composition.xml** ): It has sender, receiver, transition and connector details.


**How to Run:**

1. Download Source Code.
2. Run the File and provide EFSM XML file names along their paths: _PlayerA.xml,PlayerB.xml,Composition.xml_
> java -jar Source_Code.jar

![efsmv3](https://user-images.githubusercontent.com/43378781/46258646-cb2ccb00-c4e7-11e8-8788-1e3b6367ae1c.png)
