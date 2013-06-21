package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import java.util.Hashtable;

public class LexerCore extends StringTokenizer {
    protected Hashtable currentLexer;
    protected String currentLexerName;
    protected Token currentMatch;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.657 -0400", hash_original_method = "F81A1A23CDDF7D21ADD1D8559F70EDF8", hash_generated_method = "19E7A347F27B6A740B2625DD5BBF0D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LexerCore() {
        this.currentLexer = new Hashtable();
        this.currentLexerName = "charLexer";
        // ---------- Original Method ----------
        //this.currentLexer = new Hashtable();
        //this.currentLexerName = "charLexer";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.657 -0400", hash_original_method = "E63C8DBFE6FAFFBE522AAC8B0CA2CC77", hash_generated_method = "A55D84981E388F997AD2AD897FD3B342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LexerCore(String lexerName, String buffer) {
        super(buffer);
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(lexerName);
        // ---------- Original Method ----------
        //this.currentLexerName = lexerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.658 -0400", hash_original_method = "AD96F60DA08AE9E896CB042D3CC5B1A1", hash_generated_method = "32B9C9CC46BFCC30980143386740D0FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void addKeyword(String name, int value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Integer val;
        val = Integer.valueOf(value);
        currentLexer.put(name, val);
        {
            boolean var6BCD19598A2E704832C01FED740DFE30_1155716372 = (!globalSymbolTable.containsKey(val));
            globalSymbolTable.put(val, name);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Integer val = Integer.valueOf(value);
        //currentLexer.put(name, val);
        //if (!globalSymbolTable.containsKey(val))
            //globalSymbolTable.put(val, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.658 -0400", hash_original_method = "3D857462C470E4A1F5CD1262364F803E", hash_generated_method = "A67C1BBB5ECF29D2306EAB87AF17A322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String lookupToken(int value) {
        dsTaint.addTaint(value);
        {
            String varC6F5F8D083B479311864D0E2412AA971_422489246 = ((String) globalSymbolTable.get(Integer.valueOf(value)));
        } //End block
        {
            Character ch;
            ch = Character.valueOf((char) value);
            String var9DF4C34DEB754CE3C0793D17E246FC14_959666399 = (ch.toString());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (value > START) {
            //return (String) globalSymbolTable.get(Integer.valueOf(value));
        //} else {
            //Character ch = Character.valueOf((char) value);
            //return ch.toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.658 -0400", hash_original_method = "A9968CF51D1D67FF8D3FB6DE23BFC8AA", hash_generated_method = "64A58A0C42CA3D0A15203C6BE5CCF8D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Hashtable addLexer(String lexerName) {
        dsTaint.addTaint(lexerName);
        currentLexer = (Hashtable) lexerTables.get(lexerName);
        {
            currentLexer = new Hashtable();
            lexerTables.put(lexerName, currentLexer);
        } //End block
        return (Hashtable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //currentLexer = (Hashtable) lexerTables.get(lexerName);
        //if (currentLexer == null) {
            //currentLexer = new Hashtable();
            //lexerTables.put(lexerName, currentLexer);
        //}
        //return currentLexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.658 -0400", hash_original_method = "D20C9FA92CD9B4968A44EC6CC8CD338F", hash_generated_method = "9E95FF434A3F5228064F6C50AAE2E5E8")
    @DSModeled(DSC.SAFE)
    public void selectLexer(String lexerName) {
        dsTaint.addTaint(lexerName);
        // ---------- Original Method ----------
        //this.currentLexerName = lexerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.658 -0400", hash_original_method = "490BF814B9BDCA5834E18A73438F6256", hash_generated_method = "C6A9F1B4C0CFA39103E45C563CF895B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String peekNextId() {
        int oldPtr;
        oldPtr = ptr;
        String retval;
        retval = ttoken();
        savedPtr = ptr;
        ptr = oldPtr;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int oldPtr = ptr;
        //String retval = ttoken();
        //savedPtr = ptr;
        //ptr = oldPtr;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.659 -0400", hash_original_method = "7F6D0FFBB3DD0E896E18057F7DC876B2", hash_generated_method = "92049EA7CED42E2481E54CA85B8D7BE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNextId() {
        String var2A3161B84E636882F21731FB06227111_655294195 = (ttoken());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ttoken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.659 -0400", hash_original_method = "DD3F66B83694243DF059D5B5621ADB54", hash_generated_method = "4C32B8E3B8E3D685E3E9BCBEE701E22F")
    @DSModeled(DSC.SAFE)
    public Token getNextToken() {
        return (Token)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.currentMatch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.659 -0400", hash_original_method = "7245F245408FA6FEC683585F2431BE34", hash_generated_method = "C90A2E8F9BBB5F62129E31FF840A024C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Token peekNextToken() throws ParseException {
        Token var71F79395A253A694B3C3A52009B42BC9_888298835 = ((Token) peekNextToken(1)[0]);
        return (Token)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Token) peekNextToken(1)[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.659 -0400", hash_original_method = "E053A5C6A0917BEE124D59DA4B3EBFD6", hash_generated_method = "533F3768DAF0AE833EABCAE551F9A236")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Token[] peekNextToken(int ntokens) throws ParseException {
        dsTaint.addTaint(ntokens);
        int old;
        old = ptr;
        Token[] retval;
        retval = new Token[ntokens];
        {
            int i;
            i = 0;
            {
                Token tok;
                tok = new Token();
                {
                    boolean var808A01B8DFB0078CD3F27D970C0BFA4C_491214067 = (startsId());
                    {
                        String id;
                        id = ttoken();
                        tok.tokenValue = id;
                        String idUppercase;
                        idUppercase = id.toUpperCase();
                        {
                            boolean var7C3CBD715CA3E1F2E8D49970A8279609_115887899 = (currentLexer.containsKey(idUppercase));
                            {
                                Integer type;
                                type = (Integer) currentLexer.get(idUppercase);
                                tok.tokenType = type.intValue();
                            } //End block
                            tok.tokenType = ID;
                        } //End collapsed parenthetic
                    } //End block
                    {
                        char nextChar;
                        nextChar = getNextChar();
                        tok.tokenValue = String.valueOf(nextChar);
                        {
                            boolean varBFE1D722068425B257052762429B9184_1522041007 = (isAlpha(nextChar));
                            {
                                tok.tokenType = ALPHA;
                            } //End block
                            {
                                boolean var5DD5E4511A8FB8DAC33F081A94D239C7_359003843 = (isDigit(nextChar));
                                {
                                    tok.tokenType = DIGIT;
                                } //End block
                                tok.tokenType = (int) nextChar;
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                retval[i] = tok;
            } //End block
        } //End collapsed parenthetic
        savedPtr = ptr;
        ptr = old;
        return (Token[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.660 -0400", hash_original_method = "EF527252962F704D7452C6B99500917D", hash_generated_method = "4C29ABD779A174DB1F93CD4B99EDD59B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Token match(int tok) throws ParseException {
        dsTaint.addTaint(tok);
        {
            Debug.println("match " + tok);
        } //End block
        {
            {
                {
                    boolean var6E2CC31084E3F8D8952DBE336CCE3669_921933860 = (!startsId());
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(buffer + "\nID expected", ptr);
                } //End collapsed parenthetic
                String id;
                id = getNextId();
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = id;
                this.currentMatch.tokenType = ID;
            } //End block
            {
                {
                    boolean var546D2F1C74D692B241A5033F36725EA8_1687936325 = (!startsSafeToken());
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(buffer + "\nID expected", ptr);
                } //End collapsed parenthetic
                String id;
                id = ttokenSafe();
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = id;
                this.currentMatch.tokenType = SAFE;
            } //End block
            {
                String nexttok;
                nexttok = getNextId();
                Integer cur;
                cur = (Integer) currentLexer.get(nexttok.toUpperCase());
                {
                    boolean varE112BC08B4707BFF9A5CA13818AF0550_1195484328 = (cur == null || cur.intValue() != tok);
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(
                        buffer + "\nUnexpected Token : " + nexttok,
                        ptr);
                } //End collapsed parenthetic
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = nexttok;
                this.currentMatch.tokenType = tok;
            } //End block
        } //End block
        {
            char next;
            next = lookAhead(0);
            {
                {
                    boolean varBC6D825D0D339757C6F1B31506495F57_1452798715 = (!isDigit(next));
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(buffer + "\nExpecting DIGIT", ptr);
                } //End collapsed parenthetic
                this.currentMatch = new Token();
                this.currentMatch.tokenValue =
                    String.valueOf(next);
                this.currentMatch.tokenType = tok;
                consume(1);
            } //End block
            {
                {
                    boolean varD257F4500317009031DA40167F5103F8_361257714 = (!isAlpha(next));
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(buffer + "\nExpecting ALPHA", ptr);
                } //End collapsed parenthetic
                this.currentMatch = new Token();
                this.currentMatch.tokenValue =
                    String.valueOf(next);
                this.currentMatch.tokenType = tok;
                consume(1);
            } //End block
        } //End block
        {
            char ch;
            ch = (char) tok;
            char next;
            next = lookAhead(0);
            {
                consume(1);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    buffer + "\nExpecting  >>>" + ch + "<<< got >>>"
                    + next + "<<<", ptr);
        } //End block
        return (Token)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.661 -0400", hash_original_method = "2A2C3BB94776A03619BA392D0DD9FA22", hash_generated_method = "7DA0F9D1483FCAF705CC36C8D638227B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void SPorHT() {
        try 
        {
            char c;
            c = lookAhead(0);
            {
                consume(1);
                c = lookAhead(0);
            } //End block
        } //End block
        catch (ParseException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //char c = lookAhead(0);
            //while (c == ' ' || c == '\t') {
                //consume(1);
                //c = lookAhead(0);
            //}
        //} catch (ParseException ex) {
        //}
    }

    
        public static final boolean isTokenChar( char c ) {
        if ( isAlphaDigit(c) ) return true;
        else switch (c)
        {
            case '-':
            case '.':
            case '!':
            case '%':
            case '*':
            case '_':
            case '+':
            case '`':
            case '\'':
            case '~':
                return true;
            default:
                return false;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.661 -0400", hash_original_method = "F58976B32EA8A9502EE0AC2AF2B6A7AB", hash_generated_method = "018736B1AF3261084CB30B0E3B72FDA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startsId() {
        try 
        {
            char nextChar;
            nextChar = lookAhead(0);
            boolean varC9CB33171B8AC07DD05859930688B5A3_1227422808 = (isTokenChar(nextChar));
        } //End block
        catch (ParseException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //char nextChar = lookAhead(0);
            //return isTokenChar(nextChar);
        //} catch (ParseException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.661 -0400", hash_original_method = "F94CBEE0A9F2E4712D2EBE65CDCE3A2F", hash_generated_method = "AD8925F00FC5BEB654995B7F517D3BF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean startsSafeToken() {
        try 
        {
            char nextChar;
            nextChar = lookAhead(0);
            {
                boolean varB9799D33A7FAD7D3A9B64C6D30D5EE67_1776598507 = (isAlphaDigit(nextChar));
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.661 -0400", hash_original_method = "263A0804A198D7BD9F45ED20C20E2FC4", hash_generated_method = "A7E01809F5B8EC8C47961CA99D6A9209")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String ttoken() {
        int startIdx;
        startIdx = ptr;
        try 
        {
            {
                boolean var7ABBAD2DD6310FB5D553A45B366333BD_607985385 = (hasMoreChars());
                {
                    char nextChar;
                    nextChar = lookAhead(0);
                    {
                        boolean varF08C6CED36AB15EBFFC61DC416694C63_1992288416 = (isTokenChar(nextChar));
                        {
                            consume(1);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            String var4C777906613112F8CAB3770294DE4A62_965726498 = (buffer.substring(startIdx, ptr));
        } //End block
        catch (ParseException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int startIdx = ptr;
        //try {
            //while (hasMoreChars()) {
                //char nextChar = lookAhead(0);
                //if ( isTokenChar(nextChar) ) {
                    //consume(1);
                //} else {
                    //break;
                //}
            //}
            //return buffer.substring(startIdx, ptr);
        //} catch (ParseException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.662 -0400", hash_original_method = "888B4B5B30F6453059C386257A5A6804", hash_generated_method = "56EB1322B765D14CF816AD7CBA6E2446")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String ttokenSafe() {
        int startIdx;
        startIdx = ptr;
        try 
        {
            {
                boolean var7ABBAD2DD6310FB5D553A45B366333BD_437407771 = (hasMoreChars());
                {
                    char nextChar;
                    nextChar = lookAhead(0);
                    {
                        boolean var6BD0A8D80AA92D21A2EFDD59A567221A_1255662938 = (isAlphaDigit(nextChar));
                        {
                            consume(1);
                        } //End block
                        {
                            boolean isValidChar;
                            isValidChar = false;
                            //Begin case '_' '+' '-' '!' '`' '\'' '.' '/' '}' '{' ']' '[' '^' '|' '~' '%' '#' '@' '$' ':' ';' '?' '\"' '*' 
                            isValidChar = true;
                            //End case '_' '+' '-' '!' '`' '\'' '.' '/' '}' '{' ']' '[' '^' '|' '~' '%' '#' '@' '$' ':' ';' '?' '\"' '*' 
                            {
                                consume(1);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            String var4C777906613112F8CAB3770294DE4A62_128555283 = (buffer.substring(startIdx, ptr));
        } //End block
        catch (ParseException ex)
        { }
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.662 -0400", hash_original_method = "8CC0A9D05C89C60DBFAAF7C7ED88483F", hash_generated_method = "F344E198BF8D37F2AD70C10E245E9F6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void consumeValidChars(char[] validChars) {
        dsTaint.addTaint(validChars[0]);
        int validCharsLength;
        validCharsLength = validChars.length;
        try 
        {
            {
                boolean var7ABBAD2DD6310FB5D553A45B366333BD_1194814269 = (hasMoreChars());
                {
                    char nextChar;
                    nextChar = lookAhead(0);
                    boolean isValid;
                    isValid = false;
                    {
                        int i;
                        i = 0;
                        {
                            char validChar;
                            validChar = validChars[i];
                            //Begin case ALPHA_VALID_CHARS 
                            isValid = isAlpha(nextChar);
                            //End case ALPHA_VALID_CHARS 
                            //Begin case DIGIT_VALID_CHARS 
                            isValid = isDigit(nextChar);
                            //End case DIGIT_VALID_CHARS 
                            //Begin case ALPHADIGIT_VALID_CHARS 
                            isValid = isAlphaDigit(nextChar);
                            //End case ALPHADIGIT_VALID_CHARS 
                            //Begin case default 
                            isValid = nextChar == validChar;
                            //End case default 
                        } //End block
                    } //End collapsed parenthetic
                    {
                        consume(1);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.663 -0400", hash_original_method = "17D25E29F0B0C1524A5E10AF751238A3", hash_generated_method = "51AF65BBB1029829B4D7F072CB666B33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String quotedString() throws ParseException {
        int startIdx;
        startIdx = ptr + 1;
        {
            boolean var1A3B0F27C9B40ABA2B7F84D92888D260_1894165737 = (lookAhead(0) != '\"');
        } //End collapsed parenthetic
        consume(1);
        {
            char next;
            next = getNextChar();
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    this.buffer + " :unexpected EOL",
                    this.ptr);
            } //End block
            {
                consume(1);
            } //End block
        } //End block
        String var3278BACCABFB7434741997FF6CAEF7F8_1893575656 = (buffer.substring(startIdx, ptr - 1));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int startIdx = ptr + 1;
        //if (lookAhead(0) != '\"')
            //return null;
        //consume(1);
        //while (true) {
            //char next = getNextChar();
            //if (next == '\"') {
                //break;
            //} else if (next == '\0') {
                //throw new ParseException(
                    //this.buffer + " :unexpected EOL",
                    //this.ptr);
            //} else if (next == '\\') {
                //consume(1);
            //}
        //}
        //return buffer.substring(startIdx, ptr - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.663 -0400", hash_original_method = "0DEFD663D479F88E7A114CE703AF8835", hash_generated_method = "A747B3E34BA3F3C87FFF6B99F859DB97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String comment() throws ParseException {
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA3777A54AF9C0C8A86BF4BF49027F727_488719039 = (lookAhead(0) != '(');
        } //End collapsed parenthetic
        consume(1);
        {
            char next;
            next = getNextChar();
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    this.buffer + " :unexpected EOL",
                    this.ptr);
            } //End block
            {
                retval.append(next);
                next = getNextChar();
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                        this.buffer + " : unexpected EOL",
                        this.ptr);
                retval.append(next);
            } //End block
            {
                retval.append(next);
            } //End block
        } //End block
        String var0F1F65BA89BF920BA1A29FC87F91B969_790028680 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.663 -0400", hash_original_method = "86F26DE68AB39CE9DEE1E486630D72BD", hash_generated_method = "91F043AD90434394EB575605CE0AC1CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String byteStringNoSemicolon() {
        StringBuffer retval;
        retval = new StringBuffer();
        try 
        {
            {
                char next;
                next = lookAhead(0);
                {
                    consume(1);
                    retval.append(next);
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        {
            String var483CEEB9C5A7974916DC48CE5ADA42C7_1327456107 = (retval.toString());
        } //End block
        String var0F1F65BA89BF920BA1A29FC87F91B969_157938888 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //try {
            //while (true) {
                //char next = lookAhead(0);
                //if (next == '\0' || next == '\n' || next == ';' || next == ',' ) {
                    //break;
                //} else {
                    //consume(1);
                    //retval.append(next);
                //}
            //}
        //} catch (ParseException ex) {
            //return retval.toString();
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.663 -0400", hash_original_method = "B2A0AA5C97E9078316CA6FEBE65DB0C3", hash_generated_method = "A9FF9E1232D905C5F33DE74B95987E07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String byteStringNoSlash() {
        StringBuffer retval;
        retval = new StringBuffer();
        try 
        {
            {
                char next;
                next = lookAhead(0);
                {
                    consume(1);
                    retval.append(next);
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        {
            String var483CEEB9C5A7974916DC48CE5ADA42C7_1883693481 = (retval.toString());
        } //End block
        String var0F1F65BA89BF920BA1A29FC87F91B969_203459470 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //try {
            //while (true) {
                //char next = lookAhead(0);
                //if (next == '\0' || next == '\n' || next == '/'  ) {
                    //break;
                //} else {
                    //consume(1);
                    //retval.append(next);
                //}
            //}
        //} catch (ParseException ex) {
            //return retval.toString();
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.664 -0400", hash_original_method = "03994A77D1324F910A7EC2E8D4C779CB", hash_generated_method = "C42F1500134F88552CB48F0D990FBAD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String byteStringNoComma() {
        StringBuffer retval;
        retval = new StringBuffer();
        try 
        {
            {
                char next;
                next = lookAhead(0);
                {
                    consume(1);
                    retval.append(next);
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        { }
        String var0F1F65BA89BF920BA1A29FC87F91B969_372676658 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //try {
            //while (true) {
                //char next = lookAhead(0);
                //if (next == '\n' || next == ',') {
                    //break;
                //} else {
                    //consume(1);
                    //retval.append(next);
                //}
            //}
        //} catch (ParseException ex) {
        //}
        //return retval.toString();
    }

    
        public static String charAsString(char ch) {
        return String.valueOf(ch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.664 -0400", hash_original_method = "5A32401256C252E56BBB94CC59C2BA04", hash_generated_method = "4ABF80E0C2903B619804AAC849995FF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String charAsString(int nchars) {
        dsTaint.addTaint(nchars);
        String var9608D027D9E720FBBC2E94160E11C3D7_1327017017 = (buffer.substring(ptr, ptr + nchars));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return buffer.substring(ptr, ptr + nchars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.664 -0400", hash_original_method = "322A7AA8BD0B180616D94A352B3FE7FA", hash_generated_method = "2E9298D0B26EEABD577D6F0F6E0B96A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String number() throws ParseException {
        int startIdx;
        startIdx = ptr;
        try 
        {
            {
                boolean varB404E60D4EDC0D4770B627A4319B05C1_573547187 = (!isDigit(lookAhead(0)));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    buffer + ": Unexpected token at " + lookAhead(0),
                    ptr);
                } //End block
            } //End collapsed parenthetic
            consume(1);
            {
                char next;
                next = lookAhead(0);
                {
                    boolean var6D60BC145196548E6219EEB7B8C58E26_222291384 = (isDigit(next));
                    {
                        consume(1);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            String var4C777906613112F8CAB3770294DE4A62_1315468131 = (buffer.substring(startIdx, ptr));
        } //End block
        catch (ParseException ex)
        {
            String var4C777906613112F8CAB3770294DE4A62_2092889994 = (buffer.substring(startIdx, ptr));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int startIdx = ptr;
        //try {
            //if (!isDigit(lookAhead(0))) {
                //throw new ParseException(
                    //buffer + ": Unexpected token at " + lookAhead(0),
                    //ptr);
            //}
            //consume(1);
            //while (true) {
                //char next = lookAhead(0);
                //if (isDigit(next)) {
                    //consume(1);
                //} else
                    //break;
            //}
            //return buffer.substring(startIdx, ptr);
        //} catch (ParseException ex) {
            //return buffer.substring(startIdx, ptr);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.664 -0400", hash_original_method = "8137BED0F2B5219001CD3D42EAB84127", hash_generated_method = "3AB5F56FF1A23CC152A60D6068244621")
    @DSModeled(DSC.SAFE)
    public int markInputPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ptr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.665 -0400", hash_original_method = "4FFD881D960C22E5DF32EAF983DA52C6", hash_generated_method = "CD430B8966471FCAF49234A494B62F6D")
    @DSModeled(DSC.SAFE)
    public void rewindInputPosition(int position) {
        dsTaint.addTaint(position);
        this.ptr = position;
        // ---------- Original Method ----------
        //this.ptr = position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.665 -0400", hash_original_method = "2FDB8C189AB11331619907255B1EC94B", hash_generated_method = "823B1B7FE2AECC6BA2E0DAE7A18759A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRest() {
        {
            boolean var192220A640380CAF8B177C93C71998C2_1818633412 = (ptr >= buffer.length());
            String varF71A5DD80186EA6CFCCF2D17AFC91F25_1852967987 = (buffer.substring(ptr));
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (ptr >= buffer.length())
            //return null;
        //else
            //return buffer.substring(ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.665 -0400", hash_original_method = "720A9C8698AD8EBEF63DE1F048944846", hash_generated_method = "2CDEEC8238BC851B6D6DECA96ABB2C80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(char c) throws ParseException {
        dsTaint.addTaint(c);
        StringBuffer retval;
        retval = new StringBuffer();
        {
            char next;
            next = lookAhead(0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    this.buffer + "unexpected EOL",
                    this.ptr);
            } //End block
            {
                consume(1);
            } //End block
            {
                consume(1);
                char nextchar;
                nextchar = lookAhead(0);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParseException(
                        this.buffer + "unexpected EOL",
                        this.ptr);
                } //End block
                {
                    consume(1);
                    retval.append(nextchar);
                } //End block
            } //End block
            {
                consume(1);
                retval.append(next);
            } //End block
        } //End block
        String var0F1F65BA89BF920BA1A29FC87F91B969_1266023490 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.665 -0400", hash_original_method = "976AE9BCD44A20D9CC809F6C91A5525F", hash_generated_method = "30C3B3619F4A0E115AD6A39E949F8E7C")
    @DSModeled(DSC.SAFE)
    public int getPtr() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.ptr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.665 -0400", hash_original_method = "E132864DD50CA73C29855C29E535CA90", hash_generated_method = "84D1547377F4E8C6A344ABB2AA9B5BCD")
    @DSModeled(DSC.SAFE)
    public String getBuffer() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.666 -0400", hash_original_method = "3D7442B3A5CE831DBB9C36AFA9551D12", hash_generated_method = "7C667B58714FFD5917A22E82A1F76A96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParseException createParseException() {
        ParseException var024953D2DEA05120F1EA289A0E2678E4_2130043787 = (new ParseException(this.buffer, this.ptr));
        return (ParseException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ParseException(this.buffer, this.ptr);
    }

    
    public static final int START = 2048;
    public static final int END = START + 2048;
    public static final int ID = END - 1;
    public static final int SAFE = END - 2;
    public static final int WHITESPACE = END + 1;
    public static final int DIGIT = END + 2;
    public static final int ALPHA = END + 3;
    public static final int BACKSLASH = (int) '\\';
    public static final int QUOTE = (int) '\'';
    public static final int AT = (int) '@';
    public static final int SP = (int) ' ';
    public static final int HT = (int) '\t';
    public static final int COLON = (int) ':';
    public static final int STAR = (int) '*';
    public static final int DOLLAR = (int) '$';
    public static final int PLUS = (int) '+';
    public static final int POUND = (int) '#';
    public static final int MINUS = (int) '-';
    public static final int DOUBLEQUOTE = (int) '\"';
    public static final int TILDE = (int) '~';
    public static final int BACK_QUOTE = (int) '`';
    public static final int NULL = (int) '\0';
    public static final int EQUALS = (int) '=';
    public static final int SEMICOLON = (int) ';';
    public static final int SLASH = (int) '/';
    public static final int L_SQUARE_BRACKET = (int) '[';
    public static final int R_SQUARE_BRACKET = (int) ']';
    public static final int R_CURLY = (int) '}';
    public static final int L_CURLY = (int) '{';
    public static final int HAT = (int) '^';
    public static final int BAR = (int) '|';
    public static final int DOT = (int) '.';
    public static final int EXCLAMATION = (int) '!';
    public static final int LPAREN = (int) '(';
    public static final int RPAREN = (int) ')';
    public static final int GREATER_THAN = (int) '>';
    public static final int LESS_THAN = (int) '<';
    public static final int PERCENT = (int) '%';
    public static final int QUESTION = (int) '?';
    public static final int AND = (int) '&';
    public static final int UNDERSCORE = (int) '_';
    protected static final Hashtable globalSymbolTable;
    protected static final Hashtable lexerTables;
    static {
        globalSymbolTable = new Hashtable();
        lexerTables = new Hashtable();
    }
    
    static final char ALPHA_VALID_CHARS = Character.MAX_VALUE;
    static final char DIGIT_VALID_CHARS = Character.MAX_VALUE - 1;
    static final char ALPHADIGIT_VALID_CHARS = Character.MAX_VALUE - 2;
}

