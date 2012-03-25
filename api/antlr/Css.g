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
		
	// ---------------------------------------------------------------------------
	
	public static class Rule {
		public List<Selector> selectors = new ArrayList<Selector>();
		public Map<String, List<Object>> declarations = new LinkedHashMap<String, List<Object>>();
	}
	
	public static class Selector {
		public String str;
	}
	
	public static class Function {
		public String name;
		public List<Object> params = new ArrayList<Object>();
	}
	
	public static class Color {
		public String str;
	}
	
	// ---------------------------------------------------------------------------
	
	public final List<Rule> rules = new ArrayList<Rule>();
	private Rule tRule;
	private List<Object> tParams;
		
	private void beginRule() {
		tRule = new Rule();
		rules.add(tRule);
	}
	
	private void selector(String str) {
		Selector sel = new Selector();
		sel.str = str;
		tRule.selectors.add(sel);
	}
	
	private void beginDecl(String prop) {
		tParams = new ArrayList<Object>();
		tRule.declarations.put(prop, tParams);
	}
	
	private void param(Object o) {
		tParams.add(o);
	}
	
	// ---------------------------------------------------------------------------
	
	private Object number(String str) {
		if (str.contains(".")) return Float.parseFloat(str);
		return Integer.parseInt(str);
	}
}

// ----------------------------------------------------------------------------
// Parser rules
// ----------------------------------------------------------------------------

stylesheet
	:	rule*
	;
	
rule
@init {beginRule();}
	:	selector_list '{' declaration* '}'
	;
		
selector_list
	:	selector (COMMA selector)*
	;
	
selector
@after {selector($text);}
	:	selector_atom+ selector_pseudo?
	;
	
selector_atom
	:	(IDENT | STAR) ((HASH | DOT)=> (HASH | DOT IDENT))*
	|	((HASH | DOT)=> (HASH | DOT IDENT))+
	;
	
selector_pseudo
	:	COLON IDENT
	;
	
selector_attr
	:	LBRACKET IDENT EQUAL STRING RBRACKET
	;
	
declaration
	:	IDENT         {beginDecl($IDENT.text);}
		COLON (param  {param($param.o);}
		)+ SEMI
	;
	
param returns [Object o]
	:	function    {$o = $function.f;}
	|	param_atom  {$o = $param_atom.o;}
	;
		
function returns [Function f]
	:	IDENT LBRACE     {$f = new Function(); $f.name = $IDENT.text;}
		(p1=param        {$f.params.add($p1.o);}
		(COMMA p2=param  {$f.params.add($p2.o);})*
		)? RBRACE
	;
	
param_atom returns [Object o]
	:	NUMBER  {$o = number($NUMBER.text);}
	|	TRUE    {$o = Boolean.TRUE;}
	|	FALSE   {$o = Boolean.FALSE;}
	|	NULL    {$o = null;}
	|	STRING  {$o = $STRING.text.substring(1, $STRING.text.length()-1);}
	|	IDENT   {$o = $IDENT.text;}
	|	HASH    {$o = new Color(); ((Color)$o).str = $HASH.text;}
	;
	
// ----------------------------------------------------------------------------
// Lexer rules
// ----------------------------------------------------------------------------

fragment NAMESTART
	:	'_'
	|	'a'..'z'
	|	'A'..'Z'
	;

fragment NAMECHAR
	:	'_'
	|	'a'..'z'
	|	'A'..'Z'
	|	'0'..'9'
	|	'-'
	;

HASH	:	'#' NAMECHAR+;
DOT		:	'.';
STAR	:	'*';
COLON	:	':';
SEMI	:	';';
COMMA	:	',';
LBRACKET:	'[';
RBRACKET:	']';
EQUAL	:	'=';
LBRACE	:	'(';
RBRACE	:	')';
LCURLY	:	'{';
RCURLY	:	'}';
TRUE	:	'true';
FALSE	:	'false';
NULL	:	'null';
	
STRING
	:	'"' ( ~('"') )* '"'
	;
						
IDENT
	:	'-'? NAMESTART NAMECHAR*
	;

NUMBER
	:	'0'..'9'+ ('.' '0'..'9'+)? | '.' '0'..'9'+
	;
	
WS
	:	(' '|'\t'|'\r'|'\n')+ {$channel = HIDDEN;}
	;
		
COMMENT
	:	'/*' ( options {greedy=false;} : . )* '*/' {skip();}
	;
