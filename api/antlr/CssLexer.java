// $ANTLR 3.4 D:\\Dev\\Java\\arui\\api\\antlr\\Css.g 2012-02-14 11:14:20

	package aurelienribon.ui.css;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CssLexer extends Lexer {
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
    public String getGrammarFileName() { return "D:\\Dev\\Java\\arui\\api\\antlr\\Css.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:12:7: ( '(' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:12:9: '('
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:13:7: ( ')' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:13:9: ')'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:14:7: ( ',' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:14:9: ','
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:15:7: ( '.' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:15:9: '.'
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:16:7: ( ':' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:16:9: ':'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:17:7: ( ';' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:17:9: ';'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:18:7: ( '{' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:18:9: '{'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:19:7: ( '}' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:19:9: '}'
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
    // $ANTLR end "T__20"

    // $ANTLR start "COLOR"
    public final void mCOLOR() throws RecognitionException {
        try {
            int _type = COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:126:2: ( '#' HEX HEX HEX HEX HEX HEX HEX HEX | '#' HEX HEX HEX HEX HEX HEX | '#' HEX HEX HEX HEX | '#' HEX HEX HEX )
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:126:4: '#' HEX HEX HEX HEX HEX HEX HEX HEX
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:127:4: '#' HEX HEX HEX HEX HEX HEX
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:128:4: '#' HEX HEX HEX HEX
                    {
                    match('#'); 

                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    mHEX(); 


                    }
                    break;
                case 4 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:129:4: '#' HEX HEX HEX
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
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:132:5: ( ( '0' .. '9' )+ | '0x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ | '0X' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:132:7: ( '0' .. '9' )+
                    {
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:132:7: ( '0' .. '9' )+
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
                    	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:133:4: '0x' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    {
                    match("0x"); 



                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:133:9: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
                    	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:134:4: '0X' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
                    {
                    match("0X"); 



                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:134:9: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
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
                    	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:138:2: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* | '.' ( '0' .. '9' )+ )
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:138:4: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
                    {
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:138:4: ( '0' .. '9' )+
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
                    	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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

                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:138:20: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:139:4: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:139:8: ( '0' .. '9' )+
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
                    	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:143:2: ( ( 'true' | 'false' ) )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:143:4: ( 'true' | 'false' )
            {
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:143:4: ( 'true' | 'false' )
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
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:143:5: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:143:12: 'false'
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:146:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' )* )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:146:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' )*
            {
            if ( input.LA(1)=='-'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:146:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '-' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='-'||(LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:150:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\\\' | '\"' ) )* '\"' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:150:4: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:150:8: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) |~ ( '\\\\' | '\"' ) )*
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
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:150:10: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:150:54: ~ ( '\\\\' | '\"' )
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
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:154:2: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:
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
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:157:4: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:157:6: ( ' ' | '\\t' | '\\r' | '\\n' )
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
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:161:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:161:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:161:9: ( options {greedy=false; } : . )*
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
            	    // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:161:37: .
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
        // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | COLOR | INT | FLOAT | BOOLEAN | ID | STRING | WS | COMMENT )
        int alt14=16;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:10: T__13
                {
                mT__13(); 


                }
                break;
            case 2 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:16: T__14
                {
                mT__14(); 


                }
                break;
            case 3 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:22: T__15
                {
                mT__15(); 


                }
                break;
            case 4 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:28: T__16
                {
                mT__16(); 


                }
                break;
            case 5 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:34: T__17
                {
                mT__17(); 


                }
                break;
            case 6 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:40: T__18
                {
                mT__18(); 


                }
                break;
            case 7 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:46: T__19
                {
                mT__19(); 


                }
                break;
            case 8 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:52: T__20
                {
                mT__20(); 


                }
                break;
            case 9 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:58: COLOR
                {
                mCOLOR(); 


                }
                break;
            case 10 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:64: INT
                {
                mINT(); 


                }
                break;
            case 11 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:68: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 12 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:74: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 13 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:82: ID
                {
                mID(); 


                }
                break;
            case 14 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:85: STRING
                {
                mSTRING(); 


                }
                break;
            case 15 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:92: WS
                {
                mWS(); 


                }
                break;
            case 16 :
                // D:\\Dev\\Java\\arui\\api\\antlr\\Css.g:1:95: COMMENT
                {
                mCOMMENT(); 


                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\4\uffff\1\22\5\uffff\2\24\2\16\7\uffff\4\16\1\33\1\16\1\uffff\1"+
        "\33";
    static final String DFA14_eofS =
        "\35\uffff";
    static final String DFA14_minS =
        "\1\11\3\uffff\1\60\5\uffff\2\56\1\162\1\141\7\uffff\1\165\1\154"+
        "\1\145\1\163\1\55\1\145\1\uffff\1\55";
    static final String DFA14_maxS =
        "\1\175\3\uffff\1\71\5\uffff\2\71\1\162\1\141\7\uffff\1\165\1\154"+
        "\1\145\1\163\1\172\1\145\1\uffff\1\172";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\6\1\7\1\10\1\11\4\uffff\1\15"+
        "\1\16\1\17\1\20\1\4\1\13\1\12\6\uffff\1\14\1\uffff";
    static final String DFA14_specialS =
        "\35\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\20\2\uffff\1\20\22\uffff\1\20\1\uffff\1\17\1\11\4\uffff\1"+
            "\1\1\2\2\uffff\1\3\1\16\1\4\1\21\1\12\11\13\1\5\1\6\5\uffff"+
            "\32\16\4\uffff\1\16\1\uffff\5\16\1\15\15\16\1\14\6\16\1\7\1"+
            "\uffff\1\10",
            "",
            "",
            "",
            "\12\23",
            "",
            "",
            "",
            "",
            "",
            "\1\23\1\uffff\12\13",
            "\1\23\1\uffff\12\13",
            "\1\25",
            "\1\26",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\34",
            "",
            "\1\16\2\uffff\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16"
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | COLOR | INT | FLOAT | BOOLEAN | ID | STRING | WS | COMMENT );";
        }
    }
 

}