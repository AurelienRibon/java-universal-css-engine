// $ANTLR 3.4 C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g 2012-02-29 15:32:59

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "COLOR", "COMMENT", "FLOAT", "HEX", "ID", "INT", "NULL", "STRING", "WS", "'#'", "'('", "')'", "','", "'.'", "':'", "';'", "'active'", "'disabled'", "'focus'", "'hover'", "'{'", "'}'"
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
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
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


            match(input,25,FOLLOW_25_in_rule81); 

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


            match(input,26,FOLLOW_26_in_rule102); 

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
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:93:1: selector returns [String s] : ( selector_name )+ ( selector_pseudo )? ;
    public final String selector() throws RecognitionException {
        String s = null;


        CssParser.selector_name_return selector_name4 =null;

        CssParser.selector_pseudo_return selector_pseudo5 =null;


        s = "";
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:2: ( ( selector_name )+ ( selector_pseudo )? )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:4: ( selector_name )+ ( selector_pseudo )?
            {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:4: ( selector_name )+
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
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:96:5: selector_name
            	    {
            	    pushFollow(FOLLOW_selector_name_in_selector177);
            	    selector_name4=selector_name();

            	    state._fsp--;


            	    s += (selector_name4!=null?input.toString(selector_name4.start,selector_name4.stop):null) + " ";

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


            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:97:6: ( selector_pseudo )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==19) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:97:7: selector_pseudo
                    {
                    pushFollow(FOLLOW_selector_pseudo_in_selector187);
                    selector_pseudo5=selector_pseudo();

                    state._fsp--;


                    s += (selector_pseudo5!=null?input.toString(selector_pseudo5.start,selector_pseudo5.stop):null);

                    }
                    break;

            }


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


    public static class selector_name_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "selector_name"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:100:1: selector_name : ( '.' | '#' )? ID ;
    public final CssParser.selector_name_return selector_name() throws RecognitionException {
        CssParser.selector_name_return retval = new CssParser.selector_name_return();
        retval.start = input.LT(1);


        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:101:2: ( ( '.' | '#' )? ID )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:101:4: ( '.' | '#' )? ID
            {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:101:4: ( '.' | '#' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14||LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
                    {
                    if ( input.LA(1)==14||input.LA(1)==18 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            match(input,ID,FOLLOW_ID_in_selector_name212); 

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
    // $ANTLR end "selector_name"


    public static class selector_pseudo_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "selector_pseudo"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:104:1: selector_pseudo : ':' ( 'hover' | 'focus' | 'active' | 'disabled' ) ;
    public final CssParser.selector_pseudo_return selector_pseudo() throws RecognitionException {
        CssParser.selector_pseudo_return retval = new CssParser.selector_pseudo_return();
        retval.start = input.LT(1);


        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:105:2: ( ':' ( 'hover' | 'focus' | 'active' | 'disabled' ) )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:105:4: ':' ( 'hover' | 'focus' | 'active' | 'disabled' )
            {
            match(input,19,FOLLOW_19_in_selector_pseudo224); 

            if ( (input.LA(1) >= 21 && input.LA(1) <= 24) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "selector_pseudo"


    public static class declaration_return extends ParserRuleReturnScope {
        public String prop;
        public List<Object> params;
    };


    // $ANTLR start "declaration"
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:108:1: declaration returns [String prop, List<Object> params] : ID ':' ( declaration_param )+ ';' ;
    public final CssParser.declaration_return declaration() throws RecognitionException {
        CssParser.declaration_return retval = new CssParser.declaration_return();
        retval.start = input.LT(1);


        Token ID6=null;
        Object declaration_param7 =null;


        retval.params = new ArrayList<Object>();
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:110:2: ( ID ':' ( declaration_param )+ ';' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:110:4: ID ':' ( declaration_param )+ ';'
            {
            ID6=(Token)match(input,ID,FOLLOW_ID_in_declaration255); 

            match(input,19,FOLLOW_19_in_declaration257); 

            retval.prop = (ID6!=null?ID6.getText():null);

            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:111:3: ( declaration_param )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= BOOLEAN && LA7_0 <= COLOR)||LA7_0==FLOAT||(LA7_0 >= ID && LA7_0 <= STRING)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:111:4: declaration_param
            	    {
            	    pushFollow(FOLLOW_declaration_param_in_declaration276);
            	    declaration_param7=declaration_param();

            	    state._fsp--;


            	    retval.params.add(declaration_param7);

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            match(input,20,FOLLOW_20_in_declaration285); 

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
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:115:1: declaration_param returns [Object o] : ( function | param );
    public final Object declaration_param() throws RecognitionException {
        Object o = null;


        Function function8 =null;

        Object param9 =null;


        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:116:2: ( function | param )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==15) ) {
                    alt8=1;
                }
                else if ( ((LA8_1 >= BOOLEAN && LA8_1 <= COLOR)||LA8_1==FLOAT||(LA8_1 >= ID && LA8_1 <= STRING)||LA8_1==20) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA8_0 >= BOOLEAN && LA8_0 <= COLOR)||LA8_0==FLOAT||(LA8_0 >= INT && LA8_0 <= STRING)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:116:4: function
                    {
                    pushFollow(FOLLOW_function_in_declaration_param301);
                    function8=function();

                    state._fsp--;


                    o = function8;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:117:4: param
                    {
                    pushFollow(FOLLOW_param_in_declaration_param308);
                    param9=param();

                    state._fsp--;


                    o = param9;

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
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:120:1: function returns [Function f] : ID '(' (f1= function_param ( ',' f2= function_param )* )? ')' ;
    public final Function function() throws RecognitionException {
        Function f = null;


        Token ID10=null;
        Object f1 =null;

        Object f2 =null;


        List<Object> params = new ArrayList<Object>();
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:122:2: ( ID '(' (f1= function_param ( ',' f2= function_param )* )? ')' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:122:4: ID '(' (f1= function_param ( ',' f2= function_param )* )? ')'
            {
            ID10=(Token)match(input,ID,FOLLOW_ID_in_function335); 

            match(input,15,FOLLOW_15_in_function337); 

            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:123:3: (f1= function_param ( ',' f2= function_param )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0 >= BOOLEAN && LA10_0 <= COLOR)||LA10_0==FLOAT||(LA10_0 >= ID && LA10_0 <= STRING)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:123:4: f1= function_param ( ',' f2= function_param )*
                    {
                    pushFollow(FOLLOW_function_param_in_function344);
                    f1=function_param();

                    state._fsp--;


                    params.add(f1);

                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:124:3: ( ',' f2= function_param )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==17) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:124:4: ',' f2= function_param
                    	    {
                    	    match(input,17,FOLLOW_17_in_function356); 

                    	    pushFollow(FOLLOW_function_param_in_function360);
                    	    f2=function_param();

                    	    state._fsp--;


                    	    params.add(f2);

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,16,FOLLOW_16_in_function372); 

            f = new Function((ID10!=null?ID10.getText():null), params);

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
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:128:1: function_param returns [Object o] : ( function | param );
    public final Object function_param() throws RecognitionException {
        Object o = null;


        Function function11 =null;

        Object param12 =null;


        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:129:2: ( function | param )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==15) ) {
                    alt11=1;
                }
                else if ( ((LA11_1 >= 16 && LA11_1 <= 17)) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA11_0 >= BOOLEAN && LA11_0 <= COLOR)||LA11_0==FLOAT||(LA11_0 >= INT && LA11_0 <= STRING)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:129:4: function
                    {
                    pushFollow(FOLLOW_function_in_function_param403);
                    function11=function();

                    state._fsp--;


                    o = function11;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:130:4: param
                    {
                    pushFollow(FOLLOW_param_in_function_param410);
                    param12=param();

                    state._fsp--;


                    o = param12;

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
    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:133:1: param returns [Object o] : ( INT | FLOAT | BOOLEAN | NULL | STRING | ID | COLOR );
    public final Object param() throws RecognitionException {
        Object o = null;


        Token INT13=null;
        Token FLOAT14=null;
        Token BOOLEAN15=null;
        Token STRING16=null;
        Token ID17=null;
        Token COLOR18=null;

        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:134:2: ( INT | FLOAT | BOOLEAN | NULL | STRING | ID | COLOR )
            int alt12=7;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt12=1;
                }
                break;
            case FLOAT:
                {
                alt12=2;
                }
                break;
            case BOOLEAN:
                {
                alt12=3;
                }
                break;
            case NULL:
                {
                alt12=4;
                }
                break;
            case STRING:
                {
                alt12=5;
                }
                break;
            case ID:
                {
                alt12=6;
                }
                break;
            case COLOR:
                {
                alt12=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:134:4: INT
                    {
                    INT13=(Token)match(input,INT,FOLLOW_INT_in_param431); 

                    o = Integer.parseInt((INT13!=null?INT13.getText():null));

                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:135:4: FLOAT
                    {
                    FLOAT14=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_param442); 

                    o = Float.parseFloat((FLOAT14!=null?FLOAT14.getText():null));

                    }
                    break;
                case 3 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:136:4: BOOLEAN
                    {
                    BOOLEAN15=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_param451); 

                    o = Boolean.parseBoolean((BOOLEAN15!=null?BOOLEAN15.getText():null));

                    }
                    break;
                case 4 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:137:4: NULL
                    {
                    match(input,NULL,FOLLOW_NULL_in_param458); 

                    o = null;

                    }
                    break;
                case 5 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:138:4: STRING
                    {
                    STRING16=(Token)match(input,STRING,FOLLOW_STRING_in_param468); 

                    o = (STRING16!=null?STRING16.getText():null).substring(1, (STRING16!=null?STRING16.getText():null).length()-1);

                    }
                    break;
                case 6 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:139:4: ID
                    {
                    ID17=(Token)match(input,ID,FOLLOW_ID_in_param476); 

                    o = (ID17!=null?ID17.getText():null);

                    }
                    break;
                case 7 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:140:4: COLOR
                    {
                    COLOR18=(Token)match(input,COLOR,FOLLOW_COLOR_in_param488); 

                    o = parseColor((COLOR18!=null?COLOR18.getText():null));

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
    public static final BitSet FOLLOW_selector_list_in_rule79 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_rule81 = new BitSet(new long[]{0x0000000004000200L});
    public static final BitSet FOLLOW_declaration_in_rule88 = new BitSet(new long[]{0x0000000004000200L});
    public static final BitSet FOLLOW_26_in_rule102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_selector_list126 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_selector_list138 = new BitSet(new long[]{0x0000000000044200L});
    public static final BitSet FOLLOW_selector_in_selector_list142 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_selector_name_in_selector177 = new BitSet(new long[]{0x00000000000C4202L});
    public static final BitSet FOLLOW_selector_pseudo_in_selector187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_selector_name212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_selector_pseudo224 = new BitSet(new long[]{0x0000000001E00000L});
    public static final BitSet FOLLOW_set_in_selector_pseudo226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_declaration255 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_declaration257 = new BitSet(new long[]{0x0000000000001EB0L});
    public static final BitSet FOLLOW_declaration_param_in_declaration276 = new BitSet(new long[]{0x0000000000101EB0L});
    public static final BitSet FOLLOW_20_in_declaration285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_declaration_param301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_declaration_param308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_function335 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_function337 = new BitSet(new long[]{0x0000000000011EB0L});
    public static final BitSet FOLLOW_function_param_in_function344 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_function356 = new BitSet(new long[]{0x0000000000001EB0L});
    public static final BitSet FOLLOW_function_param_in_function360 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_function372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_function_param403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_function_param410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_param431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_param442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_param451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_param458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_param468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLOR_in_param488 = new BitSet(new long[]{0x0000000000000002L});

}