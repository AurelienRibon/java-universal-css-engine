// $ANTLR 3.4 C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g 2012-02-27 14:23:15

	package aurelienribon.ui.css.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CssLexer extends Lexer {
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

    	@Override
    	public void emitErrorMessage(String msg) {
    		throw new RuntimeException(msg);
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CssLexer() {} 
    public CssLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CssLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:12:7: ( '#' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:12:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:13:7: ( '(' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:14:7: ( ')' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:15:7: ( ',' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:15:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:16:7: ( '.' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:16:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:17:7: ( ':' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:17:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:18:7: ( ';' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:18:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:19:7: ( '{' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:19:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:20:7: ( '}' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:20:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "COLOR"
    public final void mCOLOR() throws RecognitionException {
        try {
            int _type = COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:142:2: ( '#' HEX HEX HEX HEX HEX HEX HEX HEX | '#' HEX HEX HEX HEX HEX HEX | '#' HEX HEX HEX HEX | '#' HEX HEX HEX )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='#') ) {
                int LA1_1 = input.LA(2);

                if ( ((LA1_1 >= '0' && LA1_1 <= '9')||(LA1_1 >= 'A' && LA1_1 <= 'F')||(LA1_1 >= 'a' && LA1_1 <= 'f')) ) {
                    int LA1_2 = input.LA(3);

                    if ( ((LA1_2 >= '0' && LA1_2 <= '9')||(LA1_2 >= 'A' && LA1_2 <= 'F')||(LA1_2 >= 'a' && LA1_2 <= 'f')) ) {
                        int LA1_3 = input.LA(4);

                        if ( ((LA1_3 >= '0' && LA1_3 <= '9')||(LA1_3 >= 'A' && LA1_3 <= 'F')||(LA1_3 >= 'a' && LA1_3 <= 'f')) ) {
                            int LA1_4 = input.LA(5);

                            if ( ((LA1_4 >= '0' && LA1_4 <= '9')||(LA1_4 >= 'A' && LA1_4 <= 'F')||(LA1_4 >= 'a' && LA1_4 <= 'f')) ) {
                                int LA1_6 = input.LA(6);

                                if ( ((LA1_6 >= '0' && LA1_6 <= '9')||(LA1_6 >= 'A' && LA1_6 <= 'F')||(LA1_6 >= 'a' && LA1_6 <= 'f')) ) {
                                    int LA1_8 = input.LA(7);

                                    if ( ((LA1_8 >= '0' && LA1_8 <= '9')||(LA1_8 >= 'A' && LA1_8 <= 'F')||(LA1_8 >= 'a' && LA1_8 <= 'f')) ) {
                                        int LA1_9 = input.LA(8);

                                        if ( ((LA1_9 >= '0' && LA1_9 <= '9')||(LA1_9 >= 'A' && LA1_9 <= 'F')||(LA1_9 >= 'a' && LA1_9 <= 'f')) ) {
                                            alt1=1;
                                        }
                                        else {
                                            alt1=2;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 1, 8, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    alt1=3;
                                }
                            }
                            else {
                                alt1=4;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:142:4: '#' HEX HEX HEX HEX HEX HEX HEX HEX
                    {
                    match('#'); 

                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:143:4: '#' HEX HEX HEX HEX HEX HEX
                    {
                    match('#'); 

                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    }
                    break;
                case 3 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:144:4: '#' HEX HEX HEX HEX
                    {
                    match('#'); 

                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    }
                    break;
                case 4 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:145:4: '#' HEX HEX HEX
                    {
                    match('#'); 

                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLOR"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:148:5: ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ | '0X' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'x':
                    {
                    alt5=2;
                    }
                    break;
                case 'X':
                    {
                    alt5=3;
                    }
                    break;
                default:
                    alt5=1;
                }

            }
            else if ( ((LA5_0 >= '1' && LA5_0 <= '9')) ) {
                alt5=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:148:7: ( '0' .. '9' )+
                    {
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:148:7: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:149:4: '0x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    {
                    match("0x"); 



                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:149:9: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'F')||(LA3_0 >= 'a' && LA3_0 <= 'f')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:150:4: '0X' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    {
                    match("0X"); 



                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:150:9: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'F')||(LA4_0 >= 'a' && LA4_0 <= 'f')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


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
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:154:2: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* | '.' ( '0' .. '9' )+ )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
                alt9=1;
            }
            else if ( (LA9_0=='.') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:154:4: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
                    {
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:154:4: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


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


                    match('.'); 

                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:154:20: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:155:4: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:155:8: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:159:2: ( ( 'true' | 'false' ) )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:159:4: ( 'true' | 'false' )
            {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:159:4: ( 'true' | 'false' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='t') ) {
                alt10=1;
            }
            else if ( (LA10_0=='f') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:159:5: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:159:12: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:163:2: ( 'null' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:163:4: 'null'
            {
            match("null"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:166:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' )* )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:166:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' )*
            {
            if ( input.LA(1)=='-'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:166:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='-'||(LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:170:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\\\' | '\"' ) )* '\"' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:170:4: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:170:8: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\\\' | '\"' ) )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\\') ) {
                    alt12=1;
                }
                else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= '\uFFFF')) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:170:10: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 

            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:170:54: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:174:2: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:177:4: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:177:6: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:181:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:181:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:181:9: ( options {greedy=false; } : . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='*') ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1=='/') ) {
                        alt13=2;
                    }
                    else if ( ((LA13_1 >= '\u0000' && LA13_1 <= '.')||(LA13_1 >= '0' && LA13_1 <= '\uFFFF')) ) {
                        alt13=1;
                    }


                }
                else if ( ((LA13_0 >= '\u0000' && LA13_0 <= ')')||(LA13_0 >= '+' && LA13_0 <= '\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:181:37: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | COLOR | INT | FLOAT | BOOLEAN | NULL | ID | STRING | WS | COMMENT )
        int alt14=18;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:10: T__14
                {
                mT__14(); 


                }
                break;
            case 2 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:16: T__15
                {
                mT__15(); 


                }
                break;
            case 3 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:22: T__16
                {
                mT__16(); 


                }
                break;
            case 4 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:28: T__17
                {
                mT__17(); 


                }
                break;
            case 5 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:34: T__18
                {
                mT__18(); 


                }
                break;
            case 6 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:40: T__19
                {
                mT__19(); 


                }
                break;
            case 7 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:46: T__20
                {
                mT__20(); 


                }
                break;
            case 8 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:52: T__21
                {
                mT__21(); 


                }
                break;
            case 9 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:58: T__22
                {
                mT__22(); 


                }
                break;
            case 10 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:64: COLOR
                {
                mCOLOR(); 


                }
                break;
            case 11 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:70: INT
                {
                mINT(); 


                }
                break;
            case 12 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:74: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 13 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:80: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 14 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:88: NULL
                {
                mNULL(); 


                }
                break;
            case 15 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:93: ID
                {
                mID(); 


                }
                break;
            case 16 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:96: STRING
                {
                mSTRING(); 


                }
                break;
            case 17 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:103: WS
                {
                mWS(); 


                }
                break;
            case 18 :
                // C:\\Users\\Aurelien\\Home\\Dev\\Java\\css-engine\\api\\antlr\\Css.g:1:106: COMMENT
                {
                mCOMMENT(); 


                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\23\3\uffff\1\25\4\uffff\2\27\3\17\11\uffff\6\17\1\41"+
        "\1\17\1\43\1\uffff\1\41\1\uffff";
    static final String DFA14_eofS =
        "\44\uffff";
    static final String DFA14_minS =
        "\1\11\1\60\3\uffff\1\60\4\uffff\2\56\1\162\1\141\1\165\11\uffff"+
        "\1\165\2\154\1\145\1\163\1\154\1\55\1\145\1\55\1\uffff\1\55\1\uffff";
    static final String DFA14_maxS =
        "\1\175\1\146\3\uffff\1\71\4\uffff\2\71\1\162\1\141\1\165\11\uffff"+
        "\1\165\2\154\1\145\1\163\1\154\1\172\1\145\1\172\1\uffff\1\172\1"+
        "\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\uffff\1\6\1\7\1\10\1\11\5\uffff\1\17\1\20"+
        "\1\21\1\22\1\1\1\12\1\5\1\14\1\13\11\uffff\1\15\1\uffff\1\16";
    static final String DFA14_specialS =
        "\44\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\21\2\uffff\1\21\22\uffff\1\21\1\uffff\1\20\1\1\4\uffff\1"+
            "\2\1\3\2\uffff\1\4\1\17\1\5\1\22\1\12\11\13\1\6\1\7\5\uffff"+
            "\32\17\4\uffff\1\17\1\uffff\5\17\1\15\7\17\1\16\5\17\1\14\6"+
            "\17\1\10\1\uffff\1\11",
            "\12\24\7\uffff\6\24\32\uffff\6\24",
            "",
            "",
            "",
            "\12\26",
            "",
            "",
            "",
            "",
            "\1\26\1\uffff\12\13",
            "\1\26\1\uffff\12\13",
            "\1\30",
            "\1\31",
            "\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\17\2\uffff\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "\1\42",
            "\1\17\2\uffff\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            "",
            "\1\17\2\uffff\12\17\7\uffff\32\17\4\uffff\1\17\1\uffff\32\17",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | COLOR | INT | FLOAT | BOOLEAN | NULL | ID | STRING | WS | COMMENT );";
        }
    }
 

}