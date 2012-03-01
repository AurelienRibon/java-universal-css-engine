grammar Css;

@lexer::header {
	package aurelienribon.ui.css.antlr;
}

@lexer::members {
	@Override
	public void emitErrorMessage(String msg) {
		throw new RuntimeException(msg);
	}
}

@header {
	package aurelienribon.ui.css.antlr;
	
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.HashMap;
	import java.util.LinkedHashMap;
}

@members {
	@Override
	public void emitErrorMessage(String msg) {
		throw new RuntimeException(msg);
	}
	
	public class Function {
		public final String name;
		public final List<Object> params;
		public Function(String name, List<Object> params) {
			this.name = name;
			this.params = params;
		}
	}
	
	public class Color {
		public final int r, g, b, a;
		public Color(int r, int g, int b, int a) {
			this.r = r;
			this.g = g;
			this.b = b;
			this.a = a;
		}
	}
	
	private void put(Map<String, Map<String, List<Object>>> rules, List<String> ss, Map<String, List<Object>> ds) {
		for (String s : ss) if (!rules.containsKey(s)) rules.put(s, new HashMap<String, List<Object>>());
		for (String s : ss) rules.get(s).putAll(ds);
	}
	
	private Color parseColor(String s) {
   		int r, g, b, a = 255, i = 1;

    	int incr = s.length() == 9 || s.length() == 7 ? 2 : 1;
   		boolean alpha = s.length() == 9 || s.length() == 5;

    	if (alpha) a = parseColorHex(s.substring(i,i+=incr));
   		r = parseColorHex(s.substring(i,i+=incr));
   		g = parseColorHex(s.substring(i,i+=incr));
   		b = parseColorHex(s.substring(i,i+=incr));
   		return new Color(r, g, b, a);
   	}

	private int parseColorHex(String s) {
		if (s.length() == 1) s = s.concat(s);
		return Integer.parseInt(s, 16);
	}
}

stylesheet returns [Map<String, Map<String, List<Object>>> rules]
@init {$rules = new LinkedHashMap<String, Map<String, List<Object>>>();}
	:	(rule {put(rules, $rule.ss, $rule.ds);}
		)*
	;
	
rule returns [List<String> ss, Map<String, List<Object>> ds]
@init {$ds = new LinkedHashMap<String, List<Object>>();}
	:	selector_list '{' {$ss = $selector_list.ss;}
		(declaration      {$ds.put($declaration.prop, $declaration.params);}
		)* '}'
	;
		
selector_list returns [List<String> ss]
@init {$ss = new ArrayList<String>();}
	:	s1=selector      {$ss.add($s1.s);}
		(',' s2=selector {$ss.add($s2.s);}
		)*
	;
	
selector returns [String s]
@init  {$s = "";}
@after {$s = $s.trim();}
	:	(selector_name {$s += $selector_name.text + " ";}
		)+ (selector_pseudo {$s += $selector_pseudo.text;})?
	;
	
selector_name
	:	('.' | '#')? ID
	;
	
selector_pseudo
	:	':' ('hover'|'focus'|'active'|'disabled')
	;
	
declaration returns [String prop, List<Object> params]
@init {$params = new ArrayList<Object>();}
	:	ID ':'             {$prop = $ID.text;}
		(declaration_param {$params.add($declaration_param.o);}
		)+ ';'
	;
	
declaration_param returns [Object o]
	:	function {$o = $function.f;}
	|	param    {$o = $param.o;}
	;
	
function returns [Function f]
@init  {List<Object> params = new ArrayList<Object>();}
	:	ID '('
		(f1=function_param     {params.add($f1.o);} 
		(',' f2=function_param {params.add($f2.o);}
		)* )? ')'              {$f = new Function($ID.text, params);}
	;
	
function_param returns [Object o]
	:	function {$o = $function.f;}
	|	param    {$o = $param.o;}
	;
	
param returns [Object o]
	:	INT     {$o = Integer.parseInt($INT.text);}
	|	FLOAT   {$o = Float.parseFloat($FLOAT.text);}
	|	BOOLEAN {$o = Boolean.parseBoolean($BOOLEAN.text);}
	|	NULL    {$o = null;}
	|	STRING  {$o = $STRING.text.substring(1, $STRING.text.length()-1);}
	|	ID      {$o = $ID.text;}
	|	COLOR   {$o = parseColor($COLOR.text);}
	;
		
COLOR
	:	'#' HEX HEX HEX HEX HEX HEX HEX HEX
	|	'#' HEX HEX HEX HEX HEX HEX
	|	'#' HEX HEX HEX HEX
	|	'#' HEX HEX HEX
	;

INT :	'0'..'9'+
	|	'0x' ('0'..'9'|'a'..'f'|'A'..'F')+
	|	'0X' ('0'..'9'|'a'..'f'|'A'..'F')+
	;

FLOAT
	:	('0'..'9')+ '.' ('0'..'9')*
	|	'.' ('0'..'9')+
	;
				
BOOLEAN
	:	('true'|'false')
	;
	
NULL
	:	'null'
	;
	
ID	:	('a'..'z'|'A'..'Z'|'_'|'-') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-')*
	;

STRING
	:	'"' ( '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\') | ~('\\'|'"') )* '"'
	;
	
fragment HEX
	:	'0'..'9'|'a'..'f'|'A'..'F'
	;
	
WS	:	(' '|'\t'|'\r'|'\n') {$channel=HIDDEN;}
	;
		
COMMENT
	:	'/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
	;
