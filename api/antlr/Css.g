grammar Css;

@lexer::header {
	package aurelienribon.ui.css;
}

@lexer::members {
	@Override
	public void emitErrorMessage(String msg) {
		throw new RuntimeException(msg);
	}
}

@header {
	package aurelienribon.ui.css;
	
	import java.awt.Color;
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
	
	private void put(Map<String, Map<String, List<Object>>> classes, List<String> sels, Map<String, List<Object>> rules) {
		for (String sel : sels) if (!classes.containsKey(sel)) classes.put(sel, new HashMap<String, List<Object>>());
		for (String sel : sels) classes.get(sel).putAll(rules);
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

stylesheet returns [Map<String, Map<String, List<Object>>> classes]
@init {$classes = new LinkedHashMap<String, Map<String, List<Object>>>();}
	:	(styleclass {put(classes, $styleclass.sels, $styleclass.rules);}
		)*
	;
	
styleclass returns [List<String> sels, Map<String, List<Object>> rules]
@init {$rules = new HashMap<String, List<Object>>();}
	:	selector_list_list '{' {$sels = $selector_list_list.sels;}
		(rule                  {$rules.put($rule.key, $rule.values);}
		)* '}'
	;
		
selector_list_list returns [List<String> sels]
@init {$sels = new ArrayList<String>();}
	:	ss1=selector_list      {$sels.add($ss1.sel);}
		(',' ss2=selector_list {$sels.add($ss2.sel);}
		)*
	;
	
selector_list returns [String sel]
@init  {$sel = "";}
@after {$sel = $sel.trim();}
	:	(selector {$sel += $selector.text + " ";}
		)+
	;
	
selector
	: '.' ID
	| ID
	;
	
rule returns [String key, List<Object> values]
@init {$values = new ArrayList<Object>();}
	:	ID ':'      {$key = $ID.text;}
		(rule_value {$values.add($rule_value.o);}
		)+ ';'
	;
	
rule_value returns [Object o]
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
