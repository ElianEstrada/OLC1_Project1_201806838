
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615
//----------------------------------------------------

package com.elian_estrada.analyzers;

import com.elian_estrada.classes.*;
import java.util.*;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\041\000\002\002\004\000\002\002\010\000\002\002" +
    "\003\000\002\003\004\000\002\003\003\000\002\003\005" +
    "\000\002\005\003\000\002\005\003\000\002\006\010\000" +
    "\002\007\004\000\002\011\003\000\002\011\003\000\002" +
    "\011\003\000\002\010\004\000\002\010\003\000\002\012" +
    "\005\000\002\012\002\000\002\013\006\000\002\014\005" +
    "\000\002\014\005\000\002\014\004\000\002\014\004\000" +
    "\002\014\004\000\002\014\005\000\002\014\003\000\002" +
    "\014\003\000\002\014\003\000\002\014\003\000\002\004" +
    "\004\000\002\004\003\000\002\004\004\000\002\004\004" +
    "\000\002\015\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\102\000\006\003\005\011\004\001\002\000\010\003" +
    "\011\027\014\031\012\001\002\000\004\002\uffff\001\002" +
    "\000\004\002\007\001\002\000\004\002\001\001\002\000" +
    "\012\003\ufffa\015\ufffa\027\ufffa\031\ufffa\001\002\000\004" +
    "\004\103\001\002\000\004\013\055\001\002\000\004\015" +
    "\040\001\002\000\004\006\020\001\002\000\012\003\ufffb" +
    "\015\ufffb\027\ufffb\031\ufffb\001\002\000\012\003\011\015" +
    "\ufffd\027\014\031\012\001\002\000\004\015\ufffe\001\002" +
    "\000\004\031\021\001\002\000\004\013\022\001\002\000" +
    "\010\024\027\032\024\036\023\001\002\000\010\004\ufff7" +
    "\005\ufff7\014\ufff7\001\002\000\010\004\ufff6\005\ufff6\014" +
    "\ufff6\001\002\000\010\004\ufff1\005\031\014\032\001\002" +
    "\000\004\004\030\001\002\000\010\004\ufff5\005\ufff5\014" +
    "\ufff5\001\002\000\012\003\ufff9\015\ufff9\027\ufff9\031\ufff9" +
    "\001\002\000\010\024\027\032\024\036\023\001\002\000" +
    "\010\024\027\032\024\036\023\001\002\000\004\004\ufff3" +
    "\001\002\000\004\004\ufff8\001\002\000\004\004\ufff4\001" +
    "\002\000\006\004\ufff1\005\031\001\002\000\004\004\ufff2" +
    "\001\002\000\004\015\041\001\002\000\006\003\042\031" +
    "\043\001\002\000\010\003\042\012\053\031\043\001\002" +
    "\000\004\006\050\001\002\000\010\003\042\012\uffe4\031" +
    "\043\001\002\000\004\012\046\001\002\000\004\002\000" +
    "\001\002\000\004\012\uffe5\001\002\000\004\030\051\001" +
    "\002\000\004\004\052\001\002\000\010\003\uffe1\012\uffe1" +
    "\031\uffe1\001\002\000\004\012\uffe2\001\002\000\004\012" +
    "\uffe3\001\002\000\026\011\061\016\065\017\060\020\062" +
    "\021\066\022\057\030\064\033\056\034\070\035\067\001" +
    "\002\000\030\004\uffe8\011\uffe8\016\uffe8\017\uffe8\020\uffe8" +
    "\021\uffe8\022\uffe8\030\uffe8\033\uffe8\034\uffe8\035\uffe8\001" +
    "\002\000\026\011\061\016\065\017\060\020\062\021\066" +
    "\022\057\030\064\033\056\034\070\035\067\001\002\000" +
    "\026\011\061\016\065\017\060\020\062\021\066\022\057" +
    "\030\064\033\056\034\070\035\067\001\002\000\004\031" +
    "\077\001\002\000\026\011\061\016\065\017\060\020\062" +
    "\021\066\022\057\030\064\033\056\034\070\035\067\001" +
    "\002\000\004\004\074\001\002\000\030\004\uffe9\011\uffe9" +
    "\016\uffe9\017\uffe9\020\uffe9\021\uffe9\022\uffe9\030\uffe9\033" +
    "\uffe9\034\uffe9\035\uffe9\001\002\000\026\011\061\016\065" +
    "\017\060\020\062\021\066\022\057\030\064\033\056\034" +
    "\070\035\067\001\002\000\026\011\061\016\065\017\060" +
    "\020\062\021\066\022\057\030\064\033\056\034\070\035" +
    "\067\001\002\000\030\004\uffe6\011\uffe6\016\uffe6\017\uffe6" +
    "\020\uffe6\021\uffe6\022\uffe6\030\uffe6\033\uffe6\034\uffe6\035" +
    "\uffe6\001\002\000\030\004\uffe7\011\uffe7\016\uffe7\017\uffe7" +
    "\020\uffe7\021\uffe7\022\uffe7\030\uffe7\033\uffe7\034\uffe7\035" +
    "\uffe7\001\002\000\026\011\061\016\065\017\060\020\062" +
    "\021\066\022\057\030\064\033\056\034\070\035\067\001" +
    "\002\000\030\004\uffee\011\uffee\016\uffee\017\uffee\020\uffee" +
    "\021\uffee\022\uffee\030\uffee\033\uffee\034\uffee\035\uffee\001" +
    "\002\000\030\004\uffec\011\uffec\016\uffec\017\uffec\020\uffec" +
    "\021\uffec\022\uffec\030\uffec\033\uffec\034\uffec\035\uffec\001" +
    "\002\000\012\003\ufff0\015\ufff0\027\ufff0\031\ufff0\001\002" +
    "\000\026\011\061\016\065\017\060\020\062\021\066\022" +
    "\057\030\064\033\056\034\070\035\067\001\002\000\030" +
    "\004\uffef\011\uffef\016\uffef\017\uffef\020\uffef\021\uffef\022" +
    "\uffef\030\uffef\033\uffef\034\uffef\035\uffef\001\002\000\004" +
    "\012\100\001\002\000\030\004\uffea\011\uffea\016\uffea\017" +
    "\uffea\020\uffea\021\uffea\022\uffea\030\uffea\033\uffea\034\uffea" +
    "\035\uffea\001\002\000\030\004\uffed\011\uffed\016\uffed\017" +
    "\uffed\020\uffed\021\uffed\022\uffed\030\uffed\033\uffed\034\uffed" +
    "\035\uffed\001\002\000\030\004\uffeb\011\uffeb\016\uffeb\017" +
    "\uffeb\020\uffeb\021\uffeb\022\uffeb\030\uffeb\033\uffeb\034\uffeb" +
    "\035\uffeb\001\002\000\010\003\011\027\014\031\012\001" +
    "\002\000\004\015\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\102\000\004\002\005\001\001\000\012\003\012\005" +
    "\015\006\014\013\007\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\003\016\005\015\006\014\013" +
    "\007\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\007\025\011\024\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\010\033\012\032\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\011\035\001\001\000\004\011\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\012" +
    "\036\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\004\044\015\043\001\001\000\006\004\053\015\043\001" +
    "\001\000\002\001\001\000\006\004\046\015\043\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\014\062\001\001\000" +
    "\002\001\001\000\004\014\101\001\001\000\004\014\100" +
    "\001\001\000\002\001\001\000\004\014\074\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\014\072\001\001" +
    "\000\004\014\070\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\014\071\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\014\075\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\003\103\005\015\006" +
    "\014\013\007\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


 

    int countErrors = 0;
    public boolean errors = false;
    public ArrayList<SintacticError> sintacticError = new ArrayList<SintacticError>();

    /*Metodo para errores sintacticos*/
    public void syntax_error(Symbol s){
        errors = true;
        System.out.println("Error sintactico en la linea: " + (s.left) + 
        " columna: " + s.right + ". No se esperaba este componente: " + s.value + 
        ".");
        countErrors++;
        sintacticError.add(new SintacticError(countErrors, "No se esperaba: " + s.value + ".", s.left, s.right));

    }

    /*Metodo para errores fatales*/
    
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception {
        errors = true;
        System.out.println("Error sintactico irrecuperable en la linea: " + 
        (s.left) + " columna: " + s.right + ". Componente: " + s.value + 
        " no reconocido.");
        countErrors++;
        sintacticError.add(new SintacticError(countErrors, "Fatal Error, no se esperaba: " + s.value + ".", s.left, s.right));
        System.out.println(sintacticError);
    }

    public String drawing (ArrayList<SintacticError> errorlist){
        
        String tables = "<div class=\"collapsible-body\">\n<table class =\"striped\">\n"
                + "<thead>\n<tr>\n<th> No. </th>\n<th> Description </th>\n<th> Line </th>\n<th> Column </th>\n</thead>\n<tbody>\n";
        for (int i = 0; i < errorlist.size(); i++){
            tables += "<tr>\n<td> " + errorlist.get(i).getId() + " </td>\n"
                    + "<td> " + errorlist.get(i).getDescription() + "</td>\n"
                    + "<td> " + errorlist.get(i).getLine() + "</td>\n"
                    + "<td> " + errorlist.get(i).getColumn() + "</td>\n</tr>\n";
        }
        
        tables += "</tbody>\n</table>\n</div>\n";
        
        return tables;
    }




/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {



    public Hashtable<String, SymbolTable> symbolTable = new Hashtable<String, SymbolTable>();
    public Hashtable<Integer, ArrayList<NodeTree>> leaves = new Hashtable<Integer, ArrayList<NodeTree>>();
    //public Tree tree;
    public int count = 0;

  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Init EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Init ::= LLAVIZQ Statement PORCENT PORCENT Validation LLAVDER 
            {
              Object RESULT =null;
		if(errors){System.out.println(sintacticError);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Init",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Init ::= error 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Init",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Statement ::= StatementInstrucctions Statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Statement",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Statement ::= StatementInstrucctions 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Statement",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Statement ::= error PTCOMA Statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Statement",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // StatementInstrucctions ::= Set 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors) { System.out.println(symbolTable); }
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("StatementInstrucctions",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // StatementInstrucctions ::= RegularPhrase 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Tree a = (Tree)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                                                                                    if(!errors) {count = 0; a.followTable(leaves); 
                                                                                        System.out.println(a.chart()); leaves.clear(); }
                                                                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("StatementInstrucctions",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Set ::= CONJ DOSPUN IDENTIFICADOR ASIG SetType PTCOMA 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String d = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
                                                                                    if(!errors) { symbolTable.put(b, new SymbolTable(b, d)); RESULT = a; }
                                                                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Set",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // SetType ::= Signs SetTypeP 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = a.toString() + b.toString();
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("SetType",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Signs ::= SIMBOLS 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Signs",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // Signs ::= LETTER 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Signs",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // Signs ::= DIGIT 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Signs",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // SetTypeP ::= RANG Signs 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = "~" + a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("SetTypeP",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // SetTypeP ::= ListSet 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = a;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("SetTypeP",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // ListSet ::= COMA Signs ListSet 
            {
              String RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		RESULT = ", " + a + b;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ListSet",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // ListSet ::= 
            {
              String RESULT =null;
		RESULT = "";
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ListSet",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // RegularPhrase ::= IDENTIFICADOR ASIG Expression PTCOMA 
            {
              Tree RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		NodeTree a = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 
                                                                                    if(!errors){
                                                                                        count++; 
                                                                                        RESULT = new Tree(new NodeTree(".", a, new NodeTree("¿", count, leaves), leaves), b);
                                                                                    }
                                                                                
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("RegularPhrase",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // Expression ::= CONCAT Expression Expression 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		NodeTree a = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodeTree b = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){RESULT = new NodeTree(".", a, b, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // Expression ::= DISYN Expression Expression 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		NodeTree a = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodeTree b = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){RESULT = new NodeTree("|", a, b, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // Expression ::= POS Expression 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodeTree a = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){RESULT = new NodeTree("+", a, null, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // Expression ::= KLEAN Expression 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodeTree a = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){RESULT = new NodeTree("*", a, null, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // Expression ::= BOOL Expression 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodeTree a = (NodeTree)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){RESULT = new NodeTree("?", a, null, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // Expression ::= LLAVIZQ IDENTIFICADOR LLAVDER 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		if(!errors){count++; RESULT = new NodeTree(a, count, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // Expression ::= CADENA_TEXTO 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){count++; RESULT = new NodeTree(a, count, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // Expression ::= NLINE 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){count++; RESULT = new NodeTree(a, count, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // Expression ::= COMILLA 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){count++; RESULT = new NodeTree(a, count, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // Expression ::= COMDOBLE 
            {
              NodeTree RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		if(!errors){count++; RESULT = new NodeTree(a, count, leaves);}
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Expression",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // Validation ::= ValidationInstrucctions Validation 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Validation",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // Validation ::= ValidationInstrucctions 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Validation",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // Validation ::= error Validation 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Validation",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // Validation ::= error LLAVDER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("Validation",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // ValidationInstrucctions ::= IDENTIFICADOR DOSPUN CADENA_TEXTO PTCOMA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("ValidationInstrucctions",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}