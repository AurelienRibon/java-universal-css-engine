// $ANTLR 3.4 C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g 2012-02-27 14:23:15

	package aurelienribon.ui.css.antlr;
	
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.HashMap;
	import java.util.LinkedHashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CssParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COLOR", "COMMENT", "FLOAT", "HEX", "ID", "INT", "NULL", "STRING", "WS", "'#'", "'('", "')'", "','", "'.'", "':'", "';'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int BOOLEAN=4;
    public static final int COLOR=5;
    public static final int COMMENT=6;
    public static final int FLOAT=7;
    public static final int HEX=8;
    public static final int ID=9;
    public static final int INT=10;
    public static final int NULL=11;
    public static final int STRING=12;
    public static final int WS=13;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CssParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CssParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return CssParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g"; }


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



    // $ANTLR start "stylesheet"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:73:1: stylesheet returns [Map<String, Map<String, List<Object>>> rules] : ( rule )* ;
    public final Map<String, Map<String, List<Object>>> stylesheet() throws RecognitionException {
        Map<String, Map<String, List<Object>>> rules = null;


        CssParser.rule_return rule1 =null;


        rules = new LinkedHashMap<String, Map<String, List<Object>>>();
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:75:2: ( ( rule )* )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:75:4: ( rule )*
            {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:75:4: ( rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==14||LA1_0==18) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:75:5: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_stylesheet51);
            	    rule1=rule();

            	    state._fsp--;


            	    put(rules, (rule1!=null?rule1.ss:null), (rule1!=null?rule1.ds:null));

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return rules;
    }
    // $ANTLR end "stylesheet"


    public static class rule_return extends ParserRuleReturnScope {
        public List<String> ss;
        public Map<String, List<Object>> ds;
    };


    // $ANTLR start "rule"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:79:1: rule returns [List<String> ss, Map<String, List<Object>> ds] : selector_list '{' ( declaration )* '}' ;
    public final CssParser.rule_return rule() throws RecognitionException {
        CssParser.rule_return retval = new CssParser.rule_return();
        retval.start = input.LT(1);


        List<String> selector_list2 =null;

        CssParser.declaration_return declaration3 =null;


        retval.ds = new LinkedHashMap<String, List<Object>>();
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:81:2: ( selector_list '{' ( declaration )* '}' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:81:4: selector_list '{' ( declaration )* '}'
            {
            pushFollow(FOLLOW_selector_list_in_rule79);
            selector_list2=selector_list();

            state._fsp--;


            match(input,21,FOLLOW_21_in_rule81); 

            retval.ss = selector_list2;

            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:82:3: ( declaration )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:82:4: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_rule88);
            	    declaration3=declaration();

            	    state._fsp--;


            	    retval.ds.put((declaration3!=null?declaration3.prop:null), (declaration3!=null?declaration3.params:null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,22,FOLLOW_22_in_rule102); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rule"



    // $ANTLR start "selector_list"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:86:1: selector_list returns [List<String> ss] : s1= selector ( ',' s2= selector )* ;
    public final List<String> selector_list() throws RecognitionException {
        List<String> ss = null;


        String s1 =null;

        String s2 =null;


        ss = new ArrayList<String>();
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:88:2: (s1= selector ( ',' s2= selector )* )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:88:4: s1= selector ( ',' s2= selector )*
            {
            pushFollow(FOLLOW_selector_in_selector_list126);
            s1=selector();

            state._fsp--;


            ss.add(s1);

            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:89:3: ( ',' s2= selector )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:89:4: ',' s2= selector
            	    {
            	    match(input,17,FOLLOW_17_in_selector_list138); 

            	    pushFollow(FOLLOW_selector_in_selector_list142);
            	    s2=selector();

            	    state._fsp--;


            	    ss.add(s2);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ss;
    }
    // $ANTLR end "selector_list"



    // $ANTLR start "selector"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:93:1: selector returns [String s] : ( selector_atom )+ ;
    public final String selector() throws RecognitionException {
        String s = null;


        CssParser.selector_atom_return selector_atom4 =null;


        s = "";
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:2: ( ( selector_atom )+ )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:4: ( selector_atom )+
            {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:4: ( selector_atom )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ID||LA4_0==14||LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:5: selector_atom
            	    {
            	    pushFollow(FOLLOW_selector_atom_in_selector177);
            	    selector_atom4=selector_atom();

            	    state._fsp--;


            	    s += (selector_atom4!=null?input.toString(selector_atom4.start,selector_atom4.stop):null) + " ";

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            s = s.trim();
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return s;
    }
    // $ANTLR end "selector"


    public static class selector_atom_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "selector_atom"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:100:1: selector_atom : ( '.' ID | '#' ID | ID );
    public final CssParser.selector_atom_return selector_atom() throws RecognitionException {
        CssParser.selector_atom_return retval = new CssParser.selector_atom_return();
        retval.start = input.LT(1);


        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:101:2: ( '.' ID | '#' ID | ID )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt5=1;
                }
                break;
            case 14:
                {
                alt5=2;
                }
                break;
            case ID:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:101:4: '.' ID
                    {
                    match(input,18,FOLLOW_18_in_selector_atom196); 

                    match(input,ID,FOLLOW_ID_in_selector_atom198); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:102:4: '#' ID
                    {
                    match(input,14,FOLLOW_14_in_selector_atom203); 

                    match(input,ID,FOLLOW_ID_in_selector_atom205); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:103:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_selector_atom210); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "selector_atom"


    public static class declaration_return extends ParserRuleReturnScope {
        public String prop;
        public List<Object> params;
    };


    // $ANTLR start "declaration"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:106:1: declaration returns [String prop, List<Object> params] : ID ':' ( declaration_param )+ ';' ;
    public final CssParser.declaration_return declaration() throws RecognitionException {
        CssParser.declaration_return retval = new CssParser.declaration_return();
        retval.start = input.LT(1);


        Token ID5=null;
        Object declaration_param6 =null;


        retval.params = new ArrayList<Object>();
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:108:2: ( ID ':' ( declaration_param )+ ';' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:108:4: ID ':' ( declaration_param )+ ';'
            {
            ID5=(Token)match(input,ID,FOLLOW_ID_in_declaration231); 

            match(input,19,FOLLOW_19_in_declaration233); 

            retval.prop = (ID5!=null?ID5.getText():null);

            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:109:3: ( declaration_param )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= BOOLEAN && LA6_0 <= COLOR)||LA6_0==FLOAT||(LA6_0 >= ID && LA6_0 <= STRING)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:109:4: declaration_param
            	    {
            	    pushFollow(FOLLOW_declaration_param_in_declaration252);
            	    declaration_param6=declaration_param();

            	    state._fsp--;


            	    retval.params.add(declaration_param6);

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            match(input,20,FOLLOW_20_in_declaration261); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declaration"



    // $ANTLR start "declaration_param"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:113:1: declaration_param returns [Object o] : ( function | param );
    public final Object declaration_param() throws RecognitionException {
        Object o = null;


        Function function7 =null;

        Object param8 =null;


        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:114:2: ( function | param )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==15) ) {
                    alt7=1;
                }
                else if ( ((LA7_1 >= BOOLEAN && LA7_1 <= COLOR)||LA7_1==FLOAT||(LA7_1 >= ID && LA7_1 <= STRING)||LA7_1==20) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA7_0 >= BOOLEAN && LA7_0 <= COLOR)||LA7_0==FLOAT||(LA7_0 >= INT && LA7_0 <= STRING)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:114:4: function
                    {
                    pushFollow(FOLLOW_function_in_declaration_param277);
                    function7=function();

                    state._fsp--;


                    o = function7;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:115:4: param
                    {
                    pushFollow(FOLLOW_param_in_declaration_param284);
                    param8=param();

                    state._fsp--;


                    o = param8;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o;
    }
    // $ANTLR end "declaration_param"



    // $ANTLR start "function"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:118:1: function returns [Function f] : ID '(' (f1= function_param ( ',' f2= function_param )* )? ')' ;
    public final Function function() throws RecognitionException {
        Function f = null;


        Token ID9=null;
        Object f1 =null;

        Object f2 =null;


        List<Object> params = new ArrayList<Object>();
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:120:2: ( ID '(' (f1= function_param ( ',' f2= function_param )* )? ')' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:120:4: ID '(' (f1= function_param ( ',' f2= function_param )* )? ')'
            {
            ID9=(Token)match(input,ID,FOLLOW_ID_in_function311); 

            match(input,15,FOLLOW_15_in_function313); 

            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:121:3: (f1= function_param ( ',' f2= function_param )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0 >= BOOLEAN && LA9_0 <= COLOR)||LA9_0==FLOAT||(LA9_0 >= ID && LA9_0 <= STRING)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:121:4: f1= function_param ( ',' f2= function_param )*
                    {
                    pushFollow(FOLLOW_function_param_in_function320);
                    f1=function_param();

                    state._fsp--;


                    params.add(f1);

                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:122:3: ( ',' f2= function_param )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:122:4: ',' f2= function_param
                    	    {
                    	    match(input,17,FOLLOW_17_in_function332); 

                    	    pushFollow(FOLLOW_function_param_in_function336);
                    	    f2=function_param();

                    	    state._fsp--;


                    	    params.add(f2);

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,16,FOLLOW_16_in_function348); 

            f = new Function((ID9!=null?ID9.getText():null), params);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return f;
    }
    // $ANTLR end "function"



    // $ANTLR start "function_param"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:126:1: function_param returns [Object o] : ( function | param );
    public final Object function_param() throws RecognitionException {
        Object o = null;


        Function function10 =null;

        Object param11 =null;


        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:127:2: ( function | param )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==15) ) {
                    alt10=1;
                }
                else if ( ((LA10_1 >= 16 && LA10_1 <= 17)) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA10_0 >= BOOLEAN && LA10_0 <= COLOR)||LA10_0==FLOAT||(LA10_0 >= INT && LA10_0 <= STRING)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:127:4: function
                    {
                    pushFollow(FOLLOW_function_in_function_param379);
                    function10=function();

                    state._fsp--;


                    o = function10;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:128:4: param
                    {
                    pushFollow(FOLLOW_param_in_function_param386);
                    param11=param();

                    state._fsp--;


                    o = param11;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o;
    }
    // $ANTLR end "function_param"



    // $ANTLR start "param"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:131:1: param returns [Object o] : ( INT | FLOAT | BOOLEAN | NULL | STRING | ID | COLOR );
    public final Object param() throws RecognitionException {
        Object o = null;


        Token INT12=null;
        Token FLOAT13=null;
        Token BOOLEAN14=null;
        Token STRING15=null;
        Token ID16=null;
        Token COLOR17=null;

        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:132:2: ( INT | FLOAT | BOOLEAN | NULL | STRING | ID | COLOR )
            int alt11=7;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt11=1;
                }
                break;
            case FLOAT:
                {
                alt11=2;
                }
                break;
            case BOOLEAN:
                {
                alt11=3;
                }
                break;
            case NULL:
                {
                alt11=4;
                }
                break;
            case STRING:
                {
                alt11=5;
                }
                break;
            case ID:
                {
                alt11=6;
                }
                break;
            case COLOR:
                {
                alt11=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:132:4: INT
                    {
                    INT12=(Token)match(input,INT,FOLLOW_INT_in_param407); 

                    o = Integer.parseInt((INT12!=null?INT12.getText():null));

                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:133:4: FLOAT
                    {
                    FLOAT13=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_param418); 

                    o = Float.parseFloat((FLOAT13!=null?FLOAT13.getText():null));

                    }
                    break;
                case 3 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:134:4: BOOLEAN
                    {
                    BOOLEAN14=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_param427); 

                    o = Boolean.parseBoolean((BOOLEAN14!=null?BOOLEAN14.getText():null));

                    }
                    break;
                case 4 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:135:4: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_param434); 

                    o = null;

                    }
                    break;
                case 5 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:136:4: STRING
                    {
                    STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_param444); 

                    o = (STRING15!=null?STRING15.getText():null).substring(1, (STRING15!=null?STRING15.getText():null).length()-1);

                    }
                    break;
                case 6 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:137:4: ID
                    {
                    ID16=(Token)match(input,ID,FOLLOW_ID_in_param452); 

                    o = (ID16!=null?ID16.getText():null);

                    }
                    break;
                case 7 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:138:4: COLOR
                    {
                    COLOR17=(Token)match(input,COLOR,FOLLOW_COLOR_in_param464); 

                    o = parseColor((COLOR17!=null?COLOR17.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return o;
    }
    // $ANTLR end "param"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_stylesheet51 = new BitSet(new long[]{0x0000000000044202L});
    public static final BitSet FOLLOW_selector_list_in_rule79 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_rule81 = new BitSet(new long[]{0x0000000000400200L});
    public static final BitSet FOLLOW_declaration_in_rule88 = new BitSet(new long[]{0x0000000000400200L});
    public static final BitSet FOLLOW_22_in_rule102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_selector_list126 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_selector_list138 = new BitSet(new long[]{0x0000000000044200L});
    public static final BitSet FOLLOW_selector_in_selector_list142 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_selector_atom_in_selector177 = new BitSet(new long[]{0x0000000000044202L});
    public static final BitSet FOLLOW_18_in_selector_atom196 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_selector_atom198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_selector_atom203 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_selector_atom205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selector_atom210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_declaration231 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_declaration233 = new BitSet(new long[]{0x0000000000001EB0L});
    public static final BitSet FOLLOW_declaration_param_in_declaration252 = new BitSet(new long[]{0x0000000000101EB0L});
    public static final BitSet FOLLOW_20_in_declaration261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_declaration_param277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_declaration_param284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_function311 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_function313 = new BitSet(new long[]{0x0000000000011EB0L});
    public static final BitSet FOLLOW_function_param_in_function320 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_function332 = new BitSet(new long[]{0x0000000000001EB0L});
    public static final BitSet FOLLOW_function_param_in_function336 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_function348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_function_param379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_function_param386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_param407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_param418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_param427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_param434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_param444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_param464 = new BitSet(new long[]{0x0000000000000002L});

}