###### Elian Saúl Estrada Urbina - 201806838

# Manual Técnico



1. Clases
   
   1. AdjacencyList
      
      Clase para alamacenar, recorrer y generar el Grafico del AFD
      
      ```java
      public class AdjacencyList {
      
          private ArrayList<Vertex> listVertex;
      
          public AdjacencyList() {
              this.setListVertex(new ArrayList<Vertex>());
          }
      
          public boolean addVertex(State state) {
              Vertex newVertex = new Vertex(state.getCurrentState());
      
              Vertex exist = searchVertex(newVertex.getName());
      
              if (exist != null) {
                  exist.addNeighbors(state.getDestinationState(), state.getTransitionName(), state.getTransitionValue(), state.isAcceptance());
              } else {
                  newVertex.addNeighbors(state.getDestinationState(), state.getTransitionName(), state.getTransitionValue(), state.isAcceptance());
                  listVertex.add(newVertex);
              }
      
              return true;
          }
      
          public Vertex searchVertex(String name) {
              if (!this.listVertex.isEmpty()) {
                  Vertex aux;
                  int count = 0;
      
                  while (count < listVertex.size()) {
                      aux = listVertex.get(count);
                      if (aux.getName().equals(name)) {
                          return aux;
                      }
                      count++;
                  }
              }
      
              return null;
          }
      
          public String print(String name) {
              StringBuilder dot = new StringBuilder();
              String path = "";
              dot.append("digraph G {\nbgcolor = \"#1a1a1a\"\nrankdir=LR\nedge[fontcolor = white, color=white]\n"
                      + "node [shape = \"circle\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n");
              if (!this.listVertex.isEmpty()) {
                  Vertex aux;
                  int count = 0;
      
                  while (count < this.listVertex.size()) {
                      aux = listVertex.get(count);
                      aux.print(dot);
                      count++;
                  }
              }
      
              dot.append("}");
              System.out.println(dot);
      
              try {
                  File dir = new File(new File(".").getCanonicalPath() + "/AFD_201806838");
                  dir.mkdir();
                  File file = new File(dir.getAbsolutePath() + "/" + name + ".dot");
                  file.createNewFile();
      
                  FileWriter write = new FileWriter(file);
                  write.write(dot.toString());
                  write.close();
      
                  path = "AFD_201806838/" + name;
      
              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Don't create File.");
              }
      
              return path;
      
          }
      
          public boolean validation(String input) {
      
              input += "¿";
              String c;
              boolean acceptable = false;
              Vertex aux = new Vertex();
              aux = this.listVertex.get(0);
      
              for (int i = 0; i < input.length(); i++) {
                  c = "" + input.charAt(i);
      
                  if (!c.equals("¿")) {
                      if (aux != null) {
                          for (Vertex item : aux.getNeighbors()) {
                              if (item.getValues().matcher(c).find()) {
                                  acceptable = item.isAcceptance();
                                  aux = this.searchVertex(item.getName());
                                  break;
                              }
                          }
                      }
                  }
              }
              
              return acceptable;
          }
      
          public ArrayList<Vertex> getListVertex() {
              return listVertex;
          }
      
          public void setListVertex(ArrayList<Vertex> listVertex) {
              this.listVertex = listVertex;
          }
      
      }
      
      ```
      
      
      
      
      
      
   
   2. Expression
      
      Clase para almacenar la inforamación de todos los reportes generados por una expresión regular.
      
      ```java
      public class Expression {
          
          private String pathTree;
          private String pathTransitions;
          private String pathFollow;
          private String pathAFD;
          private String pathAFN;
          private AdjacencyList afd;
          
          public Expression(String pathTree, String pathTransitions, String pathFollow, String pathAFD, String pathAFN, AdjacencyList afd){
              
              this.setPathTree(pathTree);
              this.setPathTransitions(pathTransitions);
              this.setPathFollow(pathFollow);
              this.setPathAFD(pathAFD);
              this.setPathAFN(pathAFN);
              this.setAfd(afd);
          }
      
          public String getPathTree() {
              return pathTree;
          }
      
          public void setPathTree(String pathTree) {
              this.pathTree = pathTree;
          }
      
          public String getPathTransitions() {
              return pathTransitions;
          }
      
          public void setPathTransitions(String pathTransitions) {
              this.pathTransitions = pathTransitions;
          }
      
          public String getPathFollow() {
              return pathFollow;
          }
      
          public void setPathFollow(String pathFollow) {
              this.pathFollow = pathFollow;
          }
      
          public String getPathAFD() {
              return pathAFD;
          }
      
          public void setPathAFD(String pathAFD) {
              this.pathAFD = pathAFD;
          }
      
          public String getPathAFN() {
              return pathAFN;
          }
      
          public void setPathAFN(String pathAFN) {
              this.pathAFN = pathAFN;
          }
      
          public AdjacencyList getAfd() {
              return afd;
          }
      
          public void setAfd(AdjacencyList afd) {
              this.afd = afd;
          }
      
      }
      ```
   
   3. InputString
      
      Clase para Guardar la cadena de entrada al momento de verificarlas.
      
      ```java
      public class InputString {
      
          private String name;
          private String input;
          private Validation validations;
          private Hashtable<String, SymbolTable> symbolTable;
      
          public InputString(String name, String input, Hashtable<String, SymbolTable> symbolTable) {
              this.setName(name);
              this.setInput(input);
              this.setSymbolTable(symbolTable);
              this.setValidations(new Validation(input, name));
          }
      
          public Validation validation() {
              SymbolTable symbol = this.symbolTable.get(this.name);
              Expression expression;
              if (symbol != null) {
                  expression = symbol.getExpresion();
      
                  if (expression != null) {
                      AdjacencyList afd = expression.getAfd();
                      
                      this.validations.setResult(afd.validation(this.input));
                  }
              }
      
              return this.validations;
          }
      
          public String getName() {
              return name;
          }
      
          public void setName(String name) {
              this.name = name;
          }
      
          public Hashtable<String, SymbolTable> getSymbolTable() {
              return symbolTable;
          }
      
          public void setSymbolTable(Hashtable<String, SymbolTable> symbolTable) {
              this.symbolTable = symbolTable;
          }
      
          public String getInput() {
              return input;
          }
      
          public void setInput(String input) {
              this.input = input;
          }
      
          public Validation getValidations() {
              return validations;
          }
      
          public void setValidations(Validation validations) {
              this.validations = validations;
          }
      }
      ```
   
   4. LexicalError
      
      Clase para los errores lexicos encontrados a lo largo del analisis.
      
      ```java
      public class LexicalError extends SintacticError{
          
          
          public LexicalError(int id, String description, int line, int column){
              super(id, description, line, column);
          }
      
          @Override
          public String toString() {
              return "LexicalError{" + "id=" + id + ", description=" + description + ", line=" + line + ", column=" + column + '}';
          }
          
      }
      ```
   
   5. NodeTree
      
      Clase para Los nodos del Arbol del "Metodo del Arbol"
      
      ```java
      public class NodeTree {
          
          private NodeTree left;
          private NodeTree right;
          private String name;
          private String afnd;
          private int id;
          private ArrayList<NodeTree> first;
          private ArrayList<NodeTree> last;
          private ArrayList<NodeTree> follows;
          private boolean voidable;
          
          
          public NodeTree(String name, NodeTree left, NodeTree right, Hashtable<Integer, ArrayList<NodeTree>> leaves){
              this.setName(name);
              this.setLeft(left);
              this.setRight(right);
              this.setId(0);
              this.setFirst(new ArrayList<NodeTree>());
              this.setLast(new ArrayList<NodeTree>());
              this.calculations(name, leaves);
          }
      
          public NodeTree(String name, int id, Hashtable<Integer, ArrayList<NodeTree>> leaves){
              this.setName(name);
              this.setId(id);
              this.setVoidable(false);
              this.setLeft(null);
              this.setRight(null);
              this.setFirst(new ArrayList<NodeTree>());
              this.getFirst().add(this);
              this.setLast(new ArrayList<NodeTree>());
              this.getLast().add(this);
              this.setFollows(new ArrayList<NodeTree>());
              leaves.put(id, new ArrayList<NodeTree>());
          }
          
          
          private void calculations(String name, Hashtable<Integer, ArrayList<NodeTree>> leaves){
              switch(name){
                  case "*":
                      this.setVoidable(true);
                      this.setFirst(this.left.getFirst());
                      this.setLast(this.left.getLast());
                      calculateFollows(name, this.getLeft(), this.getRight(), leaves);
                      break;
                  case "+":
                      if(left.isVoidable()){
                          this.setVoidable(true);
                      }else{
                          this.setVoidable(false);
                      }
                      this.setFirst(this.left.getFirst());
                      this.setLast(this.left.getLast());
                      calculateFollows(name, this.getLeft(), this.getRight(), leaves);
                      break;
                  case "?":
                      this.setVoidable(true);
                      this.setFirst(this.left.getFirst());
                      this.setLast(this.left.getLast());
                      break;
                  case ".":
                      if (left.isVoidable() && right.isVoidable()) {
                          this.setVoidable(true);
                      }else if(left.isVoidable()){
                          this.getFirst().addAll(this.left.getFirst());
                          this.getFirst().addAll(this.right.getFirst());
                          this.setLast(this.right.getLast());
                      }else if (right.isVoidable()){
                          this.setFirst(left.getFirst());
                          this.getLast().addAll(this.left.getLast());
                          this.getLast().addAll(this.right.getLast());
                      }else{
                          this.setVoidable(false);
                          this.setFirst(left.getFirst());
                          this.setLast(this.right.getLast());
                      }
                      calculateFollows(name, this.getLeft(), this.getRight(), leaves);
                      break;
                  case "|":
                      if(left.isVoidable() || right.isVoidable()){
                          this.setVoidable(true);
                      }else{
                          this.setVoidable(false);
                      }
                      this.getFirst().addAll(this.left.getFirst());
                      this.getFirst().addAll(this.right.getFirst());
                      this.getLast().addAll(this.left.getLast());
                      this.getLast().addAll(this.right.getLast());
                      break;
              }
          }
          
          public void calculateFollows(String name, NodeTree left, NodeTree right, Hashtable<Integer, ArrayList<NodeTree>> leaves){
              switch(name){
                  case ".":
                      for(NodeTree las: left.getLast()){
                          leaves.get(las.getId()).addAll(right.getFirst());
                      }
                      break;
                  case "+":
                  case "*":
                      for(NodeTree las: left.getLast()){
                          leaves.get(las.getId()).addAll(left.getFirst());
                      }
                      break;
              }
          }
          
          public NodeTree getLeft() {
              return left;
          }
      
          public void setLeft(NodeTree left) {
              this.left = left;
          }
      
          public NodeTree getRight() {
              return right;
          }
      
          public void setRight(NodeTree right) {
              this.right = right;
          }
      
          public String getName() {
              return name;
          }
      
          public void setName(String name) {
              this.name = name;
          }
      
          public int getId() {
              return id;
          }
      
          public void setId(int id) {
              this.id = id;
          }
      
          public ArrayList<NodeTree> getFirst() {
              return first;
          }
          
          public String toStringFist(){
              String firstString = first.get(0).getId()+"";
              if (first.size() > 0){
                  for (NodeTree fir: first.subList(1, first.size())){
                      firstString += "," + fir.getId();
                  }
              }
              
              return firstString;
          }
      
          public void setFirst(ArrayList<NodeTree> first) {
              this.first = first;
          }
      
          public ArrayList<NodeTree> getLast() {
              return last;
          }
      
          public String toStringLast(){
              String lastString = last.get(0).getId()+"";
              if (last.size() > 0){
                  for (NodeTree las: last.subList(1, last.size())){
                      lastString += "," + las.getId();
                  }
              }
              
              return lastString;
          }
          
          public void setLast(ArrayList<NodeTree> last) {
              this.last = last;
          }
      
          public ArrayList<NodeTree> getFollows() {
              return follows;
          }
      
          public void setFollows(ArrayList<NodeTree> follows) {
              this.follows = follows;
          }
      
          public boolean isVoidable() {
              return voidable;
          }
      
          public void setVoidable(boolean voidable) {
              this.voidable = voidable;
          }
      
          public String getAfnd() {
              return afnd;
          }
      
          public void setAfnd(String afnd) {
              this.afnd = afnd;
          }
      
          
          @Override
          public String toString() {
              return "" + id;
          }
      
          
      }
      
      ```
   
   6. SintacticError
      
      Clase para los errores sintacticos encontrados a lo largo del analisis.
      
      ```java
      public class SintacticError {
          
          protected int id;
          protected String description;
          protected int line;
          protected int column;
          
          public SintacticError(int id, String description, int line, int column){
              this.setId(id);
              this.setDescription(description);
              this.setLine(line);
              this.setColumn(column);
          }
      
          public int getId() {
              return id;
          }
      
          public void setId(int id) {
              this.id = id;
          }
      
          public String getDescription() {
              return description;
          }
      
          public void setDescription(String description) {
              this.description = description;
          }
      
          public int getLine() {
              return line;
          }
      
          public void setLine(int line) {
              this.line = line;
          }
      
          public int getColumn() {
              return column;
          }
      
          public void setColumn(int column) {
              this.column = column;
          }
      
          @Override
          public String toString() {
              return "SintacticError{" + "id=" + id + ", description=" + description + ", line=" + line + ", column=" + column + '}';
          }
          
      }
      ```
   
   7. State
      
      Clase para las transiciones del AFD
      
      ```java
      public class State {
          
          private String currentState;
          private String destinationState;
          private String transitionName;
          private Pattern transitionValue;
          private boolean acceptance;
          
          public State(String currentState, String destinationState, String transitionName, Pattern transitionValue, boolean acceptance){
              this.setCurrentState(currentState);
              this.setDestinationState(destinationState);
              this.setTransitionName(transitionName);
              this.setTransitionValue(transitionValue);
              this.setAcceptance(acceptance);
          }
          
          public State(String currentState){
              this.setCurrentState(currentState);
          }
      
          public String getCurrentState() {
              return currentState;
          }
      
          public void setCurrentState(String currentState) {
              this.currentState = currentState;
          }
      
          public String getDestinationState() {
              return destinationState;
          }
      
          public void setDestinationState(String destinationState) {
              this.destinationState = destinationState;
          }
      
          public String getTransitionName() {
              return transitionName;
          }
      
          public void setTransitionName(String transitionName) {
              this.transitionName = transitionName;
          }
      
          public Pattern getTransitionValue() {
              return transitionValue;
          }
      
          public void setTransitionValue(Pattern transitionValue) {
              this.transitionValue = transitionValue;
          }
      
          public boolean isAcceptance() {
              return acceptance;
          }
      
          public void setAcceptance(boolean acceptance) {
              this.acceptance = acceptance;
          }
      
          @Override
          public String toString() {
              return currentState + "-" + transitionName + "->" + destinationState + " acceptance: " + this.acceptance + "\n";
          }
      }
      ```
   
   8. SymbolTable
      
      Clase para los simbolos a almacenar a lo largo de la ejecución.
      
      ```java
      public class SymbolTable {
          
          private String name;
          private Pattern values;
          private String[] charactters;
          private Expression expresion;
          
          public SymbolTable(String name, String values){
              String options = "";
              setName(name);
              if (values.contains("~")){
                  String[] range = values.split("~");
                  setValues(Pattern.compile("[" + range[0] + "-" + range[1] + "]"));
              }else{
                  this.setCharactters(values.split(","));
                  for(int i = 0; i < this.getCharactters().length; i++){
                      options += this.getCharactters()[i].replace(" ", "");
                  }
                  
                  setValues(Pattern.compile("["+ options + "]"));
              }
          }
      
          public SymbolTable(String name, Expression expression){
              this.setName(name);
              this.expresion = expression;
          }
          
          public String getName() {
              return name;
          }
      
          public void setName(String name) {
              this.name = name;
          }
      
          public Pattern getValues() {
              return values;
          }
      
          public void setValues(Pattern values) {
              this.values = values;
          }
      
          public String[] getCharactters() {
              return charactters;
          }
      
          public void setCharactters(String[] charactters) {
              this.charactters = charactters;
          }
      
          @Override
          public String toString() {
              return "SymbolTable{" + "name=" + name + ", values=" + values + ", charactters=" + charactters + '}';
          }
      
          public Expression getExpresion() {
              return expresion;
          }
          
          
      }
      ```
   
   9. Tree
      
      Clase en la que se genera el árbol con ayuda de la clase NodeTree, en esta clase se generan todos los reportes que tienen que ver con el reconocimiento de expresiones regulares.
      
      ```java
      public class Tree {
      
          private NodeTree root;
          private String name;
          private int count;
          private int countStates = 1;
          private int countT = 1;
          private ArrayList<String> terminals;
          private ArrayList<State> states;
          private Stack<ArrayList<NodeTree>> valuateState;
          private Hashtable<ArrayList<NodeTree>, String> listStates;
          private Hashtable<Integer, ArrayList<NodeTree>> leaves;
          private Hashtable<String, SymbolTable> symbolTable;
      
          //For SymbolTable
          private String pathTree;
          private String pathAFD;
          private String pathAFND;
          private String pathTransitions;
          private String pathFollows;
          private AdjacencyList afd;
      
          public Tree() {
              this.setRoot(null);
          }
      
          public Tree(NodeTree root, String name, ArrayList<String> terminals) {
              this.setRoot(root);
              this.setName(name);
              this.terminals = terminals;
              this.valuateState = new Stack<ArrayList<NodeTree>>();
              this.listStates = new Hashtable<ArrayList<NodeTree>, String>();
              count = 0;
          }
      
          public void reports(Hashtable<Integer, ArrayList<NodeTree>> leaves, Hashtable<String, SymbolTable> symbolTable) {
              this.chart();
              this.followTable(leaves);
              this.transitionsTable(leaves, symbolTable);
      
              symbolTable.put(this.name, new SymbolTable(this.name, new Expression(this.pathTree, this.pathTransitions, this.pathFollows, this.pathAFD, this.pathAFND, this.afd)));
          }
      
          public String followTable(Hashtable<Integer, ArrayList<NodeTree>> leaves) {
      
              String symbols = searchNode(1);
              String leaf = 1 + "";
              String follows = (leaves.get(1) + "").replace("[", "").replace("]", "");
      
              for (int i = 2; i <= leaves.size(); i++) {
                  symbols += "|" + searchNode(i);
                  leaf += "|" + i;
                  follows += "|" + (leaves.get(i).isEmpty() ? "-" : (leaves.get(i) + "").replace("[", "").replace("]", ""));
              }
      
              String follow = "digraph G{\nbgcolor = \"#1a1a1a\"\nrankdir=TB\nedge[fontcolor = white, color=white]\n"
                      + "node [shape = \"record\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n"
                      + this.getName() + " [label = \"{ Symbols|" + symbols + "} | { Leaf|" + leaf + "} | {Follow|" + follows + "}\"]\n}";
      
              System.out.println(follow);
      
              try {
                  File dir = new File(new File(".").getCanonicalPath() + "/Follows_201806838");
                  dir.mkdir();
                  File file = new File(dir.getAbsolutePath() + "/" + this.name + ".dot");
                  file.createNewFile();
      
                  FileWriter write = new FileWriter(file);
                  write.write(follow);
                  write.close();
      
                  this.pathFollows = "Follows_201806838/" + this.name;
      
              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Don't create File.");
              }
      
              return follow;
          }
      
          public String transitionsTable(Hashtable<Integer, ArrayList<NodeTree>> leaves, Hashtable<String, SymbolTable> symbolTable) {
      
              this.leaves = leaves;
              this.symbolTable = symbolTable;
              this.states = new ArrayList<State>();
      
              AdjacencyList adjacencyList = new AdjacencyList();
              this.listStates.put(this.getRoot().getFirst(), "S0");
              this.valuateState.add(this.getRoot().getFirst());
      
              Vertex aux = new Vertex("S0");
              State state = new State("S0");
              ArrayList<NodeTree> copy = new ArrayList<NodeTree>();
              ArrayList<NodeTree> result = new ArrayList<NodeTree>();
              SymbolTable symbol;
              int index = 0;
              while (!this.valuateState.empty()) {
                  for (int i = 0; i < this.terminals.size(); i++) {
                      for (int j = 0; j < this.valuateState.get(0).size(); j++) {
                          if (this.valuateState.get(0).get(j).getName().equals(this.terminals.get(i))) {
                              if (result.isEmpty()) {
                                  result = this.leaves.get(this.valuateState.get(0).get(j).getId());
                                  state.setTransitionName(this.terminals.get(i));
                              } else {
                                  copy = this.leaves.get(this.valuateState.get(0).get(j).getId());
                                  for (int k = 0; k < copy.size(); k++) {
                                      if (!result.contains(copy.get(k).getId())) {
                                          result.add(copy.get(k));
                                      }
                                  }
                              }
                          }
                      }
                      if (this.listStates.get(result) == null && result.size() != 0) {
                          this.listStates.put(result, "S" + this.countStates);
                          state.setDestinationState("S" + this.countStates);
                          symbol = this.symbolTable.get(state.getTransitionName());
                          if (symbol == null) {
                              state.setTransitionValue(Pattern.compile(state.getTransitionName()));
                          } else {
                              state.setTransitionValue(symbol.getValues());
                          }
                          if (result.contains(this.getRoot().getRight())) {
                              state.setAcceptance(true);
                          } else {
                              state.setAcceptance(false);
                          }
                          this.states.add(state);
                          //state = new State(this.listStates.get(this.valuateState.get(0)));
                          this.valuateState.addElement(result);
                          this.countStates++;
                      } else if (result.size() != 0) {
                          state.setDestinationState(this.listStates.get(result));
                          symbol = this.symbolTable.get(state.getTransitionName());
                          if (symbol == null) {
                              state.setTransitionValue(Pattern.compile(state.getTransitionName()));
                          } else {
                              state.setTransitionValue(symbol.getValues());
                          }
                          if (result.contains(this.getRoot().getRight())) {
                              state.setAcceptance(true);
                          } else {
                              state.setAcceptance(false);
                          }
                          this.states.add(state);
                          //state = new State(this.listStates.get(this.valuateState.get(0)));
                      }
                      state = new State(this.listStates.get(this.valuateState.get(0)));
                      result = new ArrayList<NodeTree>();
                      copy = new ArrayList<NodeTree>();
                  }
                  this.valuateState.remove(0);
                  if (!this.valuateState.isEmpty()) {
                      state = new State(this.listStates.get(this.valuateState.get(0)));
                  }
              }
      
              for (State afd : this.states) {
                  adjacencyList.addVertex(afd);
              }
              this.pathAFD = adjacencyList.print(this.getName());
              this.afd = adjacencyList;
      
              String transitions = "digraph G{\nbgcolor = \"#1a1a1a\"\nrankdir=TB\nedge[fontcolor = white, color=white]\n"
                      + "node [shape = \"plaintext\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n";
              transitions += "transition [label = <\n<table border = \"0\" cellborder = \"1\" cellspacing = \"0\">\n<tr>\n<td rowspan = \"2\">States</td>\n"
                      + "<td colspan = \" " + this.terminals.size() + "\">Terminals</td>\n</tr>\n<tr>\n";
              for (String terminal : this.terminals) {
                  transitions += "<td>" + terminal + "</td>\n";
              }
              transitions += "</tr>\n";
      
              for (Vertex vertex : adjacencyList.getListVertex()) {
                  transitions += "<tr>\n<td>" + vertex.getName() + "</td>\n";
                  for (String terminal : this.terminals) {
                      transitions += "<td>" + existTerminal(vertex.getNeighbors(), terminal) + "</td>\n";
                  }
                  transitions += "</tr>\n";
              }
      
              transitions += "</table>\n>];\n}";
      
              try {
                  File dir = new File(new File(".").getCanonicalPath() + "/Transitions_201806838");
                  dir.mkdir();
                  File file = new File(dir.getAbsolutePath() + "/" + this.name + ".dot");
                  file.createNewFile();
      
                  FileWriter write = new FileWriter(file);
                  write.write(transitions);
                  write.close();
      
                  this.pathTransitions = "Transitions_201806838/" + this.name;
      
              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Don't create File.");
              }
      
              System.out.println(transitions);
              return "";
          }
      
          public String existTerminal(ArrayList<Vertex> neighbors, String terminal) {
              for (Vertex vertex : neighbors) {
                  if (terminal.equals(vertex.getEdge())) {
                      return vertex.getName();
                  }
              }
      
              return "---";
          }
      
          public String searchNode(int id) {
              return search(root, id);
          }
      
          public String search(NodeTree node, int id) {
              if (node == null) {
                  return "";
              } else {
                  if (isLeaf(node) && node.getId() == id) {
                      return node.getName();
                  }
      
                  String name;
      
                  name = search(node.getLeft(), id);
      
                  if (name.equals("")) {
                      name = search(node.getRight(), id);
                  }
      
                  return name;
              }
          }
      
          public String chart() {
      
              String graph = "digraph G {\nbgcolor = \"#1a1a1a\"\nrankdir=TB\nedge[fontcolor = white, color=white]\n"
                      + "node [shape = \"record\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n"
                      + "root [label = \"" + root.toStringFist() + " | { "
                      + (root.isVoidable() ? "A" : "N") + " | " + root.getName() + " | id: " + root.getId() + " } | " + root.toStringLast() + " \"]\n";;
      
              graph += "root->" + preOrder(this.getRoot().getLeft());
              graph += "root->" + preOrder(this.getRoot().getRight()) + "\n}";
      
              try {
                  File dir = new File(new File(".").getCanonicalPath() + "/Tree_201806838");
                  dir.mkdir();
                  File file = new File(dir.getAbsolutePath() + "/" + this.name + ".dot");
                  file.createNewFile();
      
                  FileWriter write = new FileWriter(file);
                  write.write(graph);
                  write.close();
      
                  this.pathTree = "Tree_201806838/" + this.name;
      
              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Don't create File.");
              }
      
              return graph;
          }
      
          public String preOrder(NodeTree node) {
      
              String nodeTree = "";
              int idNode = 0;
      
              if (isLeaf(node)) {
                  nodeTree = "\"" + node.getId() + "\"\n\"" + node.getId() + "\" [label = \"" + node.toStringFist() + " | { "
                          + (node.isVoidable() ? "A" : "N") + " | " + ((node.getName().equals("|") || node.getName().equals("\\n")) ? "\\"
                          + node.getName() : node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";
              } else if (node.getRight() == null) {
      
                  count++;
                  idNode = count;
                  nodeTree = "\"" + count + node.getId() + node.getName() + "\"\n\""
                          + count + node.getId() + node.getName() + "\" [label = \"" + node.toStringFist() + " | { "
                          + (node.isVoidable() ? "A" : "N") + " | " + ((node.getName().equals("|") || node.getName().equals("\\n")) ? "\\"
                          + node.getName() : node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";
      
                  nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getLeft()) + "\n";
      
              } else {
      
                  count++;
                  idNode = count;
                  nodeTree = "\"" + idNode + node.getId() + node.getName() + "\"\n\""
                          + count + node.getId() + node.getName() + "\" [label = \"" + node.toStringFist() + " | { "
                          + (node.isVoidable() ? "A" : "N") + " | " + ((node.getName().equals("|") || node.getName().equals("\\n")) ? "\\"
                          + node.getName() : node.getName()) + " | id: " + node.getId() + " } | " + node.toStringLast() + " \"]\n";
      
                  nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getLeft());
                  nodeTree += "\"" + idNode + node.getId() + node.getName() + "\"->" + preOrder(node.getRight());
              }
      
              return nodeTree;
          }
      
          public String thompsonMethod() {
      
              String graph = "digraph G {\nbgcolor = \"#1a1a1a\"\nrankdir=TB\nedge[fontcolor = white, color=white]\n"
                      + "node [shape = \"circle\" style=filled fillcolor = \"#313638\" fontcolor = white color = \"#007acc\"];\n"
                      + "S0";
      
              graph += "S0->" + preOrderAfnd(this.getRoot().getLeft());
              graph += "S0->" + preOrderAfnd(this.getRoot().getRight()) + "\n}";
      
              try {
                  File dir = new File(new File(".").getCanonicalPath() + "/Tree_201806838");
                  dir.mkdir();
                  File file = new File(dir.getAbsolutePath() + "/" + this.name + ".dot");
                  file.createNewFile();
      
                  FileWriter write = new FileWriter(file);
                  write.write(graph);
                  write.close();
      
                  this.pathTree = "Tree_201806838/" + this.name;
      
              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Don't create File.");
              }
      
              return graph;
          }
      
          public String preOrderAfnd(NodeTree node) {
              String eps = "Ɛ";
              String method = "";
      
              if (this.isLeaf(node)) {
                  return node.getName();
              } else {
                  switch (node.getName()) {
                      case ".":
                          method += "S" + this.countT + "\nedge[label = \"\"]";
                          break;
                      case "|":
                          break;
                      case "*":
                          break;
                      case "+":
                          break;
                      case "?":
                          break;
                  }
              }
      
              return method;
          }
      
          public boolean isLeaf(NodeTree node) {
              return node.getLeft() == null && node.getRight() == null;
          }
      
          public NodeTree getRoot() {
              return root;
          }
      
          public void setRoot(NodeTree root) {
              this.root = root;
          }
      
          public String getName() {
              return name;
          }
      
          public void setName(String name) {
              this.name = name;
          }
      
      }
      
      ```
   
   10. Validation
       
       Clase de estructura para las cadenas Validas a la hora de verificar las entradas.
       
       ```java
       public class Validation {
           
           private String value;
           private String regular;
           private boolean result;
           
           
           public Validation(String value, String regular, boolean result){
               this.setValue(value);
               this.setRegular(regular);
               this.setResult(result);
           }
       
           public Validation(String value, String regular){
               this.setValue(value);
               this.setRegular(regular);
           }
           
           public String getValue() {
               return value;
           }
       
           public void setValue(String value) {
               this.value = value;
           }
       
           public String getRegular() {
               return regular;
           }
       
           public void setRegular(String regular) {
               this.regular = regular;
           }
       
           public boolean isResult() {
               return result;
           }
       
           public void setResult(boolean result) {
               this.result = result;
           }
       
           @Override
           public String toString() {
               if(this.result){
                   return "La expresion \"" + this.value + "\" es valida con la expresion regular: " + this.regular;
               }else{
                   return "La expresion \"" + this.value + "\" no es valida con la expresion regular: " + this.regular;
               }
           }
           
           
       }
       ```
   
   11. Vertex
       
       Clase para la creación de vertices en el Grafo del AFD.
       
       ```java
       public class Vertex {
       
           private String name;
           private Pattern values;
           private String edge;
           private ArrayList<Vertex> neighbors;
           private boolean acceptance;
       
           public Vertex(String name) {
       
               this.setName(name);
               this.setValues(null);
               this.setEdge("");
               this.setNeighbors(new ArrayList<Vertex>());
               this.setAcceptance(false);
       
           }
       
           public Vertex(){
               
           }
           
           public String getEdge() {
               return edge;
           }
       
           public void setEdge(String edge) {
               this.edge = edge;
           }
       
           public Vertex(String name, String edge, Pattern values, boolean acceptance) {
               this.setName(name);
               this.setEdge(edge);
               this.setValues(values);
               this.setAcceptance(acceptance);
           }
       
           public boolean addNeighbors(String name, String edge, Pattern values, boolean acceptance) {
       
               Vertex vertex = new Vertex(name);
               vertex.setValues(values);
               vertex.setEdge(edge);
               vertex.setAcceptance(acceptance);
               this.getNeighbors().add(vertex);
       
               return true;
           }
       
           public void print(StringBuilder dot) {
               Vertex aux;
               int count = 0;
               while (count < this.neighbors.size()) {
                   aux = this.neighbors.get(count);
                   if (aux.isAcceptance()) {
                       dot.append("node [shape = \"doublecircle\"];\n");
                   }
                   switch(aux.getEdge()){
                       case "\\n":
                           dot.append("edge[label = \"\\").append(aux.getEdge()).append("\" fontseize = 5]\n").append(this.getName());
                           break;
                       case "\"":
                           dot.append("edge[label = \"\\" + aux.getEdge() + "\" fontseize = 5]\n" + this.getName());
                           break;
                       case " ":
                           dot.append("edge[label = \"\\\"" + aux.getEdge() + "\\\"\" fontseize = 5]\n" + this.getName());
                           break;
                       default: 
                           dot.append("edge[label = \"" + aux.getEdge() + "\" fontseize = 5]\n" + this.getName());
                           break;
                   }
                   dot.append("->" + aux.getName() + ";\n");
       
                   count++;
               }
           }
       
           public String getName() {
               return name;
           }
       
           public void setName(String name) {
               this.name = name;
           }
       
           public Pattern getValues() {
               return values;
           }
       
           public void setValues(Pattern values) {
               this.values = values;
           }
       
           public ArrayList<Vertex> getNeighbors() {
               return neighbors;
           }
       
           public void setNeighbors(ArrayList<Vertex> neighbors) {
               this.neighbors = neighbors;
           }
       
           public boolean isAcceptance() {
               return acceptance;
           }
       
           public void setAcceptance(boolean acceptance) {
               this.acceptance = acceptance;
           }
       
       }
       ```

2. Controladores
   
   1. Menu
      
      Controlador que maneja todos los metodos de escritura y lectura de la interfaz grafica.
      
      ```java
      public class Menu {
      
          private boolean flagEdit;
          private String filePath;
          private String absolutePath = "/media/elian_estrada/Documents/Elian/2021/Usac/Primer_Semestre/Compi1/Lab";
      
          public Menu() {
              this.flagEdit = false;
              this.filePath = "";
          }
      
          public void newFile(String text) {
              if (this.flagEdit) {
      
                  if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null, "Do you want to save this file",
                          "Save", JOptionPane.YES_NO_OPTION)) {
                      this.saveFile(text);
                  }
              }
              
              this.filePath = "";
          }
          
          public StringBuffer openFile(String text){
              
              this.newFile(text);
              StringBuffer content = new StringBuffer();
              
              JFileChooser openFile = new JFileChooser();
              openFile.setAcceptAllFileFilterUsed(false);
              openFile.setFileFilter(new FileNameExtensionFilter("*." + "olc", "olc"));
              openFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
              openFile.setCurrentDirectory(new File(this.absolutePath));
      
              int result = openFile.showOpenDialog(null);
      
              if (result != JFileChooser.CANCEL_OPTION) {
                  File file = openFile.getSelectedFile();
                  try{
                      BufferedReader read = new BufferedReader(new FileReader(file));
                      
                      String line = read.readLine();
                      
                      while(line != null){
                          content.append(line+"\n");
                          line = read.readLine();
                      }
                      
                      read.close();
                      
                      this.filePath = file.getAbsoluteFile().toString();
                      this.flagEdit = false;
                      return content;
                      
                  }catch(Exception e){
                      JOptionPane.showMessageDialog(null, "Error reading file");
                  }
              }
              
              return null;
          }
      
          public String saveFile(String text) {
              if (flagEdit && filePath != "") {
                  this.writeFile(text);
              } else if (flagEdit) {
                  return this.saveAsFile(text);
              }
      
              return "";
          }
      
          public String saveAsFile(String text) {
      
              JFileChooser saveFile = new JFileChooser();
              saveFile.setAcceptAllFileFilterUsed(false);
              saveFile.setFileFilter(new FileNameExtensionFilter("*." + "olc", "olc"));
              saveFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
              saveFile.setCurrentDirectory(new File(this.absolutePath));
      
              int result = saveFile.showSaveDialog(null);
      
              if (result != JFileChooser.CANCEL_OPTION) {
                  File file = saveFile.getSelectedFile();
                  if (file.getName().contains(".")) {
                      if (new File(file.getAbsoluteFile().toString()).exists()) {
                          if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(saveFile, "The file already exists, do you want to replace it?",
                                  "Remplace", JOptionPane.YES_NO_OPTION)) {
                              this.filePath = file.getAbsoluteFile().toString();
                          } else {
                              return "";
                          }
                      } else {
                          this.filePath = file.getAbsoluteFile().toString();
                      }
                  } else {
                      if (new File(file.getAbsoluteFile() + ".olc").exists()) {
                          if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(saveFile, "The file already exists, do you want to replace it?",
                                  "Remplace", JOptionPane.YES_NO_OPTION)) {
                              this.filePath = file.getAbsolutePath() + ".olc";
                          } else {
                              return "";
                          }
                      } else {
                          this.filePath = file.getAbsolutePath() + ".olc";
                      }
                  }
      
                  if (this.writeFile(text)) {
                      return file.getName();
                  }
              }
      
              return "";
      
          }
      
          private boolean writeFile(String text) {
              FileWriter file = null;
      
              try {
                  file = new FileWriter(this.filePath);
                  file.write(text);
                  file.close();
      
                  return true;
      
              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Error writing to file");
                  if (file != null) {
                      try {
                          file.close();
                      } catch (IOException eIO) {
                          //
                      }
                  }
              }
              return false;
          }
      
          public boolean getFlagEdit() {
              return flagEdit;
          }
      
          public void setFlagEdit(boolean flagEdit) {
              this.flagEdit = flagEdit;
          }
      
          public String getFilePath() {
              return filePath;
          }
      
          public void setFilePath(String filePath) {
              this.filePath = filePath;
          }
      
      }
      ```
      
      
