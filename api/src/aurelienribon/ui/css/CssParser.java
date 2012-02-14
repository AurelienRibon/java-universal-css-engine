// $ANTLR 3.4 D:\\Dev\\Java\\arui\\api\\antlr\\Css.g 2012-02-14 11:14:20

	package aurelienribon.ui.css;
	
	import java.awt.Color;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COLOR", "COMMENT", "FLOAT", "HEX", "ID", "INT", "STRING", "WS", "'('", "')'", "','", "'.'", "':'", "';'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int BOOLEAN=4;
    public static final int COLOR=5;
    public static final int COMMENT=6;
    public static final int FLOAT=7;
    public static final int HEX=8;
    public static final int ID=9;
    public static final int INT=10;
    public static final int STRING=11;
    public static final int WS=12;

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
    public String getGrammarFileName() { return "D:\\Dev\\Java\\arui\\api\\antlr\\Css.g"; }


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
    		boolean alpha = s.length() == 9 || s.length() == 4;
    		
    		if (alpha) a = Integer.parseInt(s.substring(i,i+=incr), 16);
    		r = Integer.parseInt(s.substring(i,i+=incr), 16);
    		g = Integer.parseInt(s.substring(i,i+=incr), 16);
    		b = Integer.parseInt(s.substring(i,i+=incr), 16);
    		return new Color(r, g, b, a);
    	}



    // $ANTLR start "stylesheet"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:59:1: stylesheet returns [Map<String, Map<String, List<Object>>> classes] : ( styleclass )* ;
    public final Map<String, Map<String, List<Object>>> stylesheet() throws RecognitionException {
        Map<String, Map<String, List<Object>>> classes = null;


        CssParser.styleclass_return styleclass1 =null;


        classes = new LinkedHashMap<String, Map<String, List<Object>>>();
        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:61:2: ( ( styleclass )* )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:61:4: ( styleclass )*
            {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:61:4: ( styleclass )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:61:5: styleclass
            	    {
            	    pushFollow(FOLLOW_styleclass_in_stylesheet51);
            	    styleclass1=styleclass();

            	    state._fsp--;


            	    put(classes, (styleclass1!=null?styleclass1.sels:null), (styleclass1!=null?styleclass1.rules:null));

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
        return classes;
    }
    // $ANTLR end "stylesheet"


    public static class styleclass_return extends ParserRuleReturnScope {
        public List<String> sels;
        public Map<String, List<Object>> rules;
    };


    // $ANTLR start "styleclass"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:65:1: styleclass returns [List<String> sels, Map<String, List<Object>> rules] : selector_list_list '{' ( rule )* '}' ;
    public final CssParser.styleclass_return styleclass() throws RecognitionException {
        CssParser.styleclass_return retval = new CssParser.styleclass_return();
        retval.start = input.LT(1);


        List<String> selector_list_list2 =null;

        CssParser.rule_return rule3 =null;


        retval.rules = new HashMap<String, List<Object>>();
        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:67:2: ( selector_list_list '{' ( rule )* '}' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:67:4: selector_list_list '{' ( rule )* '}'
            {
            pushFollow(FOLLOW_selector_list_list_in_styleclass79);
            selector_list_list2=selector_list_list();

            state._fsp--;


            match(input,19,FOLLOW_19_in_styleclass81); 

            retval.sels = selector_list_list2;

            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:68:3: ( rule )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:68:4: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_styleclass88);
            	    rule3=rule();

            	    state._fsp--;


            	    retval.rules.put((rule3!=null?rule3.key:null), (rule3!=null?rule3.values:null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,20,FOLLOW_20_in_styleclass114); 

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
    // $ANTLR end "styleclass"



    // $ANTLR start "selector_list_list"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:72:1: selector_list_list returns [List<String> sels] : ss1= selector_list ( ',' ss2= selector_list )* ;
    public final List<String> selector_list_list() throws RecognitionException {
        List<String> sels = null;


        String ss1 =null;

        String ss2 =null;


        sels = new ArrayList<String>();
        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:74:2: (ss1= selector_list ( ',' ss2= selector_list )* )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:74:4: ss1= selector_list ( ',' ss2= selector_list )*
            {
            pushFollow(FOLLOW_selector_list_in_selector_list_list138);
            ss1=selector_list();

            state._fsp--;


            sels.add(ss1);

            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:75:3: ( ',' ss2= selector_list )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:75:4: ',' ss2= selector_list
            	    {
            	    match(input,15,FOLLOW_15_in_selector_list_list150); 

            	    pushFollow(FOLLOW_selector_list_in_selector_list_list154);
            	    ss2=selector_list();

            	    state._fsp--;


            	    sels.add(ss2);

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
        return sels;
    }
    // $ANTLR end "selector_list_list"



    // $ANTLR start "selector_list"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:79:1: selector_list returns [String sel] : ( selector )+ ;
    public final String selector_list() throws RecognitionException {
        String sel = null;


        CssParser.selector_return selector4 =null;


        sel = "";
        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:82:2: ( ( selector )+ )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:82:4: ( selector )+
            {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:82:4: ( selector )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ID||LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:82:5: selector
            	    {
            	    pushFollow(FOLLOW_selector_in_selector_list189);
            	    selector4=selector();

            	    state._fsp--;


            	    sel += (selector4!=null?input.toString(selector4.start,selector4.stop):null) + " ";

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

            sel = sel.trim();
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return sel;
    }
    // $ANTLR end "selector_list"


    public static class selector_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "selector"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:86:1: selector : ( '.' ID | ID );
    public final CssParser.selector_return selector() throws RecognitionException {
        CssParser.selector_return retval = new CssParser.selector_return();
        retval.start = input.LT(1);


        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:87:2: ( '.' ID | ID )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:87:4: '.' ID
                    {
                    match(input,16,FOLLOW_16_in_selector208); 

                    match(input,ID,FOLLOW_ID_in_selector210); 

                    }
                    break;
                case 2 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:88:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_selector215); 

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
    // $ANTLR end "selector"


    public static class rule_return extends ParserRuleReturnScope {
        public String key;
        public List<Object> values;
    };


    // $ANTLR start "rule"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:91:1: rule returns [String key, List<Object> values] : ID ':' ( rule_value )+ ';' ;
    public final CssParser.rule_return rule() throws RecognitionException {
        CssParser.rule_return retval = new CssParser.rule_return();
        retval.start = input.LT(1);


        Token ID5=null;
        Object rule_value6 =null;


        retval.values = new ArrayList<Object>();
        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:93:2: ( ID ':' ( rule_value )+ ';' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:93:4: ID ':' ( rule_value )+ ';'
            {
            ID5=(Token)match(input,ID,FOLLOW_ID_in_rule236); 

            match(input,17,FOLLOW_17_in_rule238); 

            retval.key = (ID5!=null?ID5.getText():null);

            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:94:3: ( rule_value )+
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
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:94:4: rule_value
            	    {
            	    pushFollow(FOLLOW_rule_value_in_rule250);
            	    rule_value6=rule_value();

            	    state._fsp--;


            	    retval.values.add(rule_value6);

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


            match(input,18,FOLLOW_18_in_rule259); 

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



    // $ANTLR start "rule_value"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:98:1: rule_value returns [Object o] : ( function | param );
    public final Object rule_value() throws RecognitionException {
        Object o = null;


        Function function7 =null;

        Object param8 =null;


        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:99:2: ( function | param )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==13) ) {
                    alt7=1;
                }
                else if ( ((LA7_1 >= BOOLEAN && LA7_1 <= COLOR)||LA7_1==FLOAT||(LA7_1 >= ID && LA7_1 <= STRING)||LA7_1==18) ) {
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:99:4: function
                    {
                    pushFollow(FOLLOW_function_in_rule_value275);
                    function7=function();

                    state._fsp--;


                    o = function7;

                    }
                    break;
                case 2 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:100:4: param
                    {
                    pushFollow(FOLLOW_param_in_rule_value282);
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
    // $ANTLR end "rule_value"



    // $ANTLR start "function"
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:103:1: function returns [Function f] : ID '(' (f1= function_param ( ',' f2= function_param )* )? ')' ;
    public final Function function() throws RecognitionException {
        Function f = null;


        Token ID9=null;
        Object f1 =null;

        Object f2 =null;


        List<Object> params = new ArrayList<Object>();
        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:105:2: ( ID '(' (f1= function_param ( ',' f2= function_param )* )? ')' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:105:4: ID '(' (f1= function_param ( ',' f2= function_param )* )? ')'
            {
            ID9=(Token)match(input,ID,FOLLOW_ID_in_function309); 

            match(input,13,FOLLOW_13_in_function311); 

            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:106:3: (f1= function_param ( ',' f2= function_param )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0 >= BOOLEAN && LA9_0 <= COLOR)||LA9_0==FLOAT||(LA9_0 >= ID && LA9_0 <= STRING)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:106:4: f1= function_param ( ',' f2= function_param )*
                    {
                    pushFollow(FOLLOW_function_param_in_function318);
                    f1=function_param();

                    state._fsp--;


                    params.add(f1);

                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:107:3: ( ',' f2= function_param )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==15) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:107:4: ',' f2= function_param
                    	    {
                    	    match(input,15,FOLLOW_15_in_function330); 

                    	    pushFollow(FOLLOW_function_param_in_function334);
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


            match(input,14,FOLLOW_14_in_function346); 

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
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:111:1: function_param returns [Object o] : ( function | param );
    public final Object function_param() throws RecognitionException {
        Object o = null;


        Function function10 =null;

        Object param11 =null;


        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:112:2: ( function | param )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==13) ) {
                    alt10=1;
                }
                else if ( ((LA10_1 >= 14 && LA10_1 <= 15)) ) {
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:112:4: function
                    {
                    pushFollow(FOLLOW_function_in_function_param377);
                    function10=function();

                    state._fsp--;


                    o = function10;

                    }
                    break;
                case 2 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:113:4: param
                    {
                    pushFollow(FOLLOW_param_in_function_param384);
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
    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:116:1: param returns [Object o] : ( INT | FLOAT | BOOLEAN | STRING | ID | COLOR );
    public final Object param() throws RecognitionException {
        Object o = null;


        Token INT12=null;
        Token FLOAT13=null;
        Token BOOLEAN14=null;
        Token STRING15=null;
        Token ID16=null;
        Token COLOR17=null;

        try {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:117:2: ( INT | FLOAT | BOOLEAN | STRING | ID | COLOR )
            int alt11=6;
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
            case STRING:
                {
                alt11=4;
                }
                break;
            case ID:
                {
                alt11=5;
                }
                break;
            case COLOR:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:117:4: INT
                    {
                    INT12=(Token)match(input,INT,FOLLOW_INT_in_param405); 

                    o = Integer.parseInt((INT12!=null?INT12.getText():null));

                    }
                    break;
                case 2 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:118:4: FLOAT
                    {
                    FLOAT13=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_param416); 

                    o = Float.parseFloat((FLOAT13!=null?FLOAT13.getText():null));

                    }
                    break;
                case 3 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:119:4: BOOLEAN
                    {
                    BOOLEAN14=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_param425); 

                    o = Boolean.parseBoolean((BOOLEAN14!=null?BOOLEAN14.getText():null));

                    }
                    break;
                case 4 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:120:4: STRING
                    {
                    STRING15=(Token)match(input,STRING,FOLLOW_STRING_in_param432); 

                    o = (STRING15!=null?STRING15.getText():null).substring(1, (STRING15!=null?STRING15.getText():null).length()-1);

                    }
                    break;
                case 5 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:121:4: ID
                    {
                    ID16=(Token)match(input,ID,FOLLOW_ID_in_param440); 

                    o = (ID16!=null?ID16.getText():null);

                    }
                    break;
                case 6 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:122:4: COLOR
                    {
                    COLOR17=(Token)match(input,COLOR,FOLLOW_COLOR_in_param452); 

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


 

    public static final BitSet FOLLOW_styleclass_in_stylesheet51 = new BitSet(new long[]{0x0000000000010202L});
    public static final BitSet FOLLOW_selector_list_list_in_styleclass79 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_styleclass81 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_rule_in_styleclass88 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_20_in_styleclass114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_list_in_selector_list_list138 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_selector_list_list150 = new BitSet(new long[]{0x0000000000010200L});
    public static final BitSet FOLLOW_selector_list_in_selector_list_list154 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_selector_in_selector_list189 = new BitSet(new long[]{0x0000000000010202L});
    public static final BitSet FOLLOW_16_in_selector208 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_selector210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selector215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_rule236 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rule238 = new BitSet(new long[]{0x0000000000000EB0L});
    public static final BitSet FOLLOW_rule_value_in_rule250 = new BitSet(new long[]{0x0000000000040EB0L});
    public static final BitSet FOLLOW_18_in_rule259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_rule_value275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_rule_value282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_function309 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_function311 = new BitSet(new long[]{0x0000000000004EB0L});
    public static final BitSet FOLLOW_function_param_in_function318 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_function330 = new BitSet(new long[]{0x0000000000000EB0L});
    public static final BitSet FOLLOW_function_param_in_function334 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_function346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_function_param377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_function_param384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_param405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_param416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_param425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_param432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_param452 = new BitSet(new long[]{0x0000000000000002L});

}