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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.826 -0400", hash_original_field = "B0F13C43E094802743B3161861C2DD0D", hash_generated_field = "73DC8498A7AED0DB7B89805A8124EB6C")

    protected Hashtable currentLexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.826 -0400", hash_original_field = "C1B2DFD6C6DC23006E47A698CF2EB941", hash_generated_field = "CBCC5F8F420E7C818FCF47E1FDA6C4BE")

    protected String currentLexerName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.826 -0400", hash_original_field = "2FD6DA3C66080705F49ACC8A63DD8192", hash_generated_field = "A0375D48FDB0A7A220B130B3BD520E09")

    protected Token currentMatch;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.827 -0400", hash_original_method = "F81A1A23CDDF7D21ADD1D8559F70EDF8", hash_generated_method = "19E7A347F27B6A740B2625DD5BBF0D5D")
    protected  LexerCore() {
        this.currentLexer = new Hashtable();
        this.currentLexerName = "charLexer";
        // ---------- Original Method ----------
        //this.currentLexer = new Hashtable();
        //this.currentLexerName = "charLexer";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.827 -0400", hash_original_method = "E63C8DBFE6FAFFBE522AAC8B0CA2CC77", hash_generated_method = "67804AD9BDCB78E6E3CD1796DD12C767")
    public  LexerCore(String lexerName, String buffer) {
        super(buffer);
        this.currentLexerName = lexerName;
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        //this.currentLexerName = lexerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.828 -0400", hash_original_method = "AD96F60DA08AE9E896CB042D3CC5B1A1", hash_generated_method = "64E40A0CE845270E43631E4F90A522AF")
    protected void addKeyword(String name, int value) {
        Integer val;
        val = Integer.valueOf(value);
        currentLexer.put(name, val);
        {
            boolean var6BCD19598A2E704832C01FED740DFE30_1823098668 = (!globalSymbolTable.containsKey(val));
            globalSymbolTable.put(val, name);
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //Integer val = Integer.valueOf(value);
        //currentLexer.put(name, val);
        //if (!globalSymbolTable.containsKey(val))
            //globalSymbolTable.put(val, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.829 -0400", hash_original_method = "3D857462C470E4A1F5CD1262364F803E", hash_generated_method = "2D6AE08C0D8A2966ADAF46E5FC025575")
    public String lookupToken(int value) {
        String varB4EAC82CA7396A68D541C85D26508E83_1817807481 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1402762634 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1817807481 = (String) globalSymbolTable.get(Integer.valueOf(value));
        } //End block
        {
            Character ch;
            ch = Character.valueOf((char) value);
            varB4EAC82CA7396A68D541C85D26508E83_1402762634 = ch.toString();
        } //End block
        addTaint(value);
        String varA7E53CE21691AB073D9660D615818899_2059897570; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2059897570 = varB4EAC82CA7396A68D541C85D26508E83_1817807481;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2059897570 = varB4EAC82CA7396A68D541C85D26508E83_1402762634;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2059897570.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2059897570;
        // ---------- Original Method ----------
        //if (value > START) {
            //return (String) globalSymbolTable.get(Integer.valueOf(value));
        //} else {
            //Character ch = Character.valueOf((char) value);
            //return ch.toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.840 -0400", hash_original_method = "A9968CF51D1D67FF8D3FB6DE23BFC8AA", hash_generated_method = "F4B13AA4ED195473442AD8FC6093B59A")
    protected Hashtable addLexer(String lexerName) {
        Hashtable varB4EAC82CA7396A68D541C85D26508E83_1181906840 = null; //Variable for return #1
        currentLexer = (Hashtable) lexerTables.get(lexerName);
        {
            currentLexer = new Hashtable();
            lexerTables.put(lexerName, currentLexer);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1181906840 = currentLexer;
        varB4EAC82CA7396A68D541C85D26508E83_1181906840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1181906840;
        // ---------- Original Method ----------
        //currentLexer = (Hashtable) lexerTables.get(lexerName);
        //if (currentLexer == null) {
            //currentLexer = new Hashtable();
            //lexerTables.put(lexerName, currentLexer);
        //}
        //return currentLexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.840 -0400", hash_original_method = "D20C9FA92CD9B4968A44EC6CC8CD338F", hash_generated_method = "B54E7BB236C631028B1E4228D89A1C2D")
    public void selectLexer(String lexerName) {
        this.currentLexerName = lexerName;
        // ---------- Original Method ----------
        //this.currentLexerName = lexerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.845 -0400", hash_original_method = "490BF814B9BDCA5834E18A73438F6256", hash_generated_method = "4FCDE6FCFC23281AA293B52982DB4BD7")
    public String peekNextId() {
        String varB4EAC82CA7396A68D541C85D26508E83_783722305 = null; //Variable for return #1
        int oldPtr;
        oldPtr = ptr;
        String retval;
        retval = ttoken();
        savedPtr = ptr;
        ptr = oldPtr;
        varB4EAC82CA7396A68D541C85D26508E83_783722305 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_783722305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_783722305;
        // ---------- Original Method ----------
        //int oldPtr = ptr;
        //String retval = ttoken();
        //savedPtr = ptr;
        //ptr = oldPtr;
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.851 -0400", hash_original_method = "7F6D0FFBB3DD0E896E18057F7DC876B2", hash_generated_method = "8A3821961F6712BED181E57DDB8EBAFE")
    public String getNextId() {
        String varB4EAC82CA7396A68D541C85D26508E83_41176541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_41176541 = ttoken();
        varB4EAC82CA7396A68D541C85D26508E83_41176541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_41176541;
        // ---------- Original Method ----------
        //return ttoken();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.852 -0400", hash_original_method = "DD3F66B83694243DF059D5B5621ADB54", hash_generated_method = "9500C8FDABA6CE6BD47B3393D79434E4")
    public Token getNextToken() {
        Token varB4EAC82CA7396A68D541C85D26508E83_869633536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_869633536 = this.currentMatch;
        varB4EAC82CA7396A68D541C85D26508E83_869633536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_869633536;
        // ---------- Original Method ----------
        //return this.currentMatch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.852 -0400", hash_original_method = "7245F245408FA6FEC683585F2431BE34", hash_generated_method = "484012F99843F7B57841C2A8C7DCF3A6")
    public Token peekNextToken() throws ParseException {
        Token varB4EAC82CA7396A68D541C85D26508E83_1366958437 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1366958437 = (Token) peekNextToken(1)[0];
        varB4EAC82CA7396A68D541C85D26508E83_1366958437.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366958437;
        // ---------- Original Method ----------
        //return (Token) peekNextToken(1)[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.902 -0400", hash_original_method = "E053A5C6A0917BEE124D59DA4B3EBFD6", hash_generated_method = "4148776BAF28FC0878DF0518A646B659")
    public Token[] peekNextToken(int ntokens) throws ParseException {
        Token[] varB4EAC82CA7396A68D541C85D26508E83_860579729 = null; //Variable for return #1
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
                    boolean var808A01B8DFB0078CD3F27D970C0BFA4C_2007279938 = (startsId());
                    {
                        String id;
                        id = ttoken();
                        tok.tokenValue = id;
                        String idUppercase;
                        idUppercase = id.toUpperCase();
                        {
                            boolean var7C3CBD715CA3E1F2E8D49970A8279609_1459502513 = (currentLexer.containsKey(idUppercase));
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
                            boolean varBFE1D722068425B257052762429B9184_1449438753 = (isAlpha(nextChar));
                            {
                                tok.tokenType = ALPHA;
                            } //End block
                            {
                                boolean var5DD5E4511A8FB8DAC33F081A94D239C7_1902541705 = (isDigit(nextChar));
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
        varB4EAC82CA7396A68D541C85D26508E83_860579729 = retval;
        addTaint(ntokens);
        varB4EAC82CA7396A68D541C85D26508E83_860579729.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_860579729;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.913 -0400", hash_original_method = "EF527252962F704D7452C6B99500917D", hash_generated_method = "CB0BC57320915E6653554CB844635EF2")
    public Token match(int tok) throws ParseException {
        Token varB4EAC82CA7396A68D541C85D26508E83_233570816 = null; //Variable for return #1
        {
            Debug.println("match " + tok);
        } //End block
        {
            {
                {
                    boolean var6E2CC31084E3F8D8952DBE336CCE3669_55224700 = (!startsId());
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
                    boolean var546D2F1C74D692B241A5033F36725EA8_2069766279 = (!startsSafeToken());
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
                    boolean varE112BC08B4707BFF9A5CA13818AF0550_39903362 = (cur == null || cur.intValue() != tok);
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
                    boolean varBC6D825D0D339757C6F1B31506495F57_211971594 = (!isDigit(next));
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
                    boolean varD257F4500317009031DA40167F5103F8_206035416 = (!isAlpha(next));
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
        varB4EAC82CA7396A68D541C85D26508E83_233570816 = this.currentMatch;
        varB4EAC82CA7396A68D541C85D26508E83_233570816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_233570816;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.914 -0400", hash_original_method = "2A2C3BB94776A03619BA392D0DD9FA22", hash_generated_method = "7DA0F9D1483FCAF705CC36C8D638227B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.915 -0400", hash_original_method = "F58976B32EA8A9502EE0AC2AF2B6A7AB", hash_generated_method = "2BE6D206EC14A6ABAA4D565826C10A11")
    public boolean startsId() {
        try 
        {
            char nextChar;
            nextChar = lookAhead(0);
            boolean varC9CB33171B8AC07DD05859930688B5A3_252796101 = (isTokenChar(nextChar));
        } //End block
        catch (ParseException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684999817 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_684999817;
        // ---------- Original Method ----------
        //try {
            //char nextChar = lookAhead(0);
            //return isTokenChar(nextChar);
        //} catch (ParseException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.915 -0400", hash_original_method = "F94CBEE0A9F2E4712D2EBE65CDCE3A2F", hash_generated_method = "C369843114DAFD9C66087479498800D3")
    public boolean startsSafeToken() {
        try 
        {
            char nextChar;
            nextChar = lookAhead(0);
            {
                boolean varB9799D33A7FAD7D3A9B64C6D30D5EE67_642984223 = (isAlphaDigit(nextChar));
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1338240526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1338240526;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.925 -0400", hash_original_method = "263A0804A198D7BD9F45ED20C20E2FC4", hash_generated_method = "F49C85A0AD2D9CB2AC35DF9E3234C0BF")
    public String ttoken() {
        String varB4EAC82CA7396A68D541C85D26508E83_1874009094 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1558507881 = null; //Variable for return #2
        int startIdx;
        startIdx = ptr;
        try 
        {
            {
                boolean var7ABBAD2DD6310FB5D553A45B366333BD_1638586167 = (hasMoreChars());
                {
                    char nextChar;
                    nextChar = lookAhead(0);
                    {
                        boolean varF08C6CED36AB15EBFFC61DC416694C63_1115014364 = (isTokenChar(nextChar));
                        {
                            consume(1);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1874009094 = buffer.substring(startIdx, ptr);
        } //End block
        catch (ParseException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1558507881 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1650578530; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1650578530 = varB4EAC82CA7396A68D541C85D26508E83_1874009094;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1650578530 = varB4EAC82CA7396A68D541C85D26508E83_1558507881;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1650578530.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1650578530;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.933 -0400", hash_original_method = "888B4B5B30F6453059C386257A5A6804", hash_generated_method = "86CDDA866CAD3EDF451FF0E2E1E3FF48")
    public String ttokenSafe() {
        String varB4EAC82CA7396A68D541C85D26508E83_26247337 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_316995959 = null; //Variable for return #2
        int startIdx;
        startIdx = ptr;
        try 
        {
            {
                boolean var7ABBAD2DD6310FB5D553A45B366333BD_2142749388 = (hasMoreChars());
                {
                    char nextChar;
                    nextChar = lookAhead(0);
                    {
                        boolean var6BD0A8D80AA92D21A2EFDD59A567221A_673749827 = (isAlphaDigit(nextChar));
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
            varB4EAC82CA7396A68D541C85D26508E83_26247337 = buffer.substring(startIdx, ptr);
        } //End block
        catch (ParseException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_316995959 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_20919069; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_20919069 = varB4EAC82CA7396A68D541C85D26508E83_26247337;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_20919069 = varB4EAC82CA7396A68D541C85D26508E83_316995959;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_20919069.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_20919069;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.934 -0400", hash_original_method = "8CC0A9D05C89C60DBFAAF7C7ED88483F", hash_generated_method = "97E74D181543B547808B91FA51258132")
    public void consumeValidChars(char[] validChars) {
        int validCharsLength;
        validCharsLength = validChars.length;
        try 
        {
            {
                boolean var7ABBAD2DD6310FB5D553A45B366333BD_1107515416 = (hasMoreChars());
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
        addTaint(validChars[0]);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.950 -0400", hash_original_method = "17D25E29F0B0C1524A5E10AF751238A3", hash_generated_method = "5661F5C8DDB0BCFFAE63844619B11898")
    public String quotedString() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1375404449 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_590541286 = null; //Variable for return #2
        int startIdx;
        startIdx = ptr + 1;
        {
            boolean var1A3B0F27C9B40ABA2B7F84D92888D260_1389646590 = (lookAhead(0) != '\"');
            varB4EAC82CA7396A68D541C85D26508E83_1375404449 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_590541286 = buffer.substring(startIdx, ptr - 1);
        String varA7E53CE21691AB073D9660D615818899_816562644; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_816562644 = varB4EAC82CA7396A68D541C85D26508E83_1375404449;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_816562644 = varB4EAC82CA7396A68D541C85D26508E83_590541286;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_816562644.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_816562644;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.951 -0400", hash_original_method = "0DEFD663D479F88E7A114CE703AF8835", hash_generated_method = "AF17403A904777EE8A823EF2EF9180FB")
    public String comment() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1238141572 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1898455995 = null; //Variable for return #2
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varA3777A54AF9C0C8A86BF4BF49027F727_957842592 = (lookAhead(0) != '(');
            varB4EAC82CA7396A68D541C85D26508E83_1238141572 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1898455995 = retval.toString();
        String varA7E53CE21691AB073D9660D615818899_2074539454; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2074539454 = varB4EAC82CA7396A68D541C85D26508E83_1238141572;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2074539454 = varB4EAC82CA7396A68D541C85D26508E83_1898455995;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2074539454.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2074539454;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.952 -0400", hash_original_method = "86F26DE68AB39CE9DEE1E486630D72BD", hash_generated_method = "517CD6A944A7631276B368E8DDC4A5B0")
    public String byteStringNoSemicolon() {
        String varB4EAC82CA7396A68D541C85D26508E83_1866711985 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2119033401 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1866711985 = retval.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2119033401 = retval.toString();
        String varA7E53CE21691AB073D9660D615818899_1771837523; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1771837523 = varB4EAC82CA7396A68D541C85D26508E83_1866711985;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1771837523 = varB4EAC82CA7396A68D541C85D26508E83_2119033401;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1771837523.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1771837523;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.952 -0400", hash_original_method = "B2A0AA5C97E9078316CA6FEBE65DB0C3", hash_generated_method = "5BD7E29608B67EE7C2C60686F2CB19A2")
    public String byteStringNoSlash() {
        String varB4EAC82CA7396A68D541C85D26508E83_1704030352 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1687516182 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1704030352 = retval.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1687516182 = retval.toString();
        String varA7E53CE21691AB073D9660D615818899_2020098116; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2020098116 = varB4EAC82CA7396A68D541C85D26508E83_1704030352;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2020098116 = varB4EAC82CA7396A68D541C85D26508E83_1687516182;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2020098116.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2020098116;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.960 -0400", hash_original_method = "03994A77D1324F910A7EC2E8D4C779CB", hash_generated_method = "BCDC52D7BDC6A549B420CE620E9F82B0")
    public String byteStringNoComma() {
        String varB4EAC82CA7396A68D541C85D26508E83_1550455878 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1550455878 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1550455878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1550455878;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.968 -0400", hash_original_method = "5A32401256C252E56BBB94CC59C2BA04", hash_generated_method = "6CB24CEEA52032A79549B05974A7D352")
    public String charAsString(int nchars) {
        String varB4EAC82CA7396A68D541C85D26508E83_748950648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_748950648 = buffer.substring(ptr, ptr + nchars);
        addTaint(nchars);
        varB4EAC82CA7396A68D541C85D26508E83_748950648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_748950648;
        // ---------- Original Method ----------
        //return buffer.substring(ptr, ptr + nchars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.968 -0400", hash_original_method = "322A7AA8BD0B180616D94A352B3FE7FA", hash_generated_method = "2ADD7E9C7C99B59838D865A367937588")
    public String number() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1358375942 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_173539630 = null; //Variable for return #2
        int startIdx;
        startIdx = ptr;
        try 
        {
            {
                boolean varB404E60D4EDC0D4770B627A4319B05C1_1099955769 = (!isDigit(lookAhead(0)));
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
                    boolean var6D60BC145196548E6219EEB7B8C58E26_1323911175 = (isDigit(next));
                    {
                        consume(1);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1358375942 = buffer.substring(startIdx, ptr);
        } //End block
        catch (ParseException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_173539630 = buffer.substring(startIdx, ptr);
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1347036760; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1347036760 = varB4EAC82CA7396A68D541C85D26508E83_1358375942;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1347036760 = varB4EAC82CA7396A68D541C85D26508E83_173539630;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1347036760.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1347036760;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.969 -0400", hash_original_method = "8137BED0F2B5219001CD3D42EAB84127", hash_generated_method = "61158A9800BD6DC2E26FA06FF3442962")
    public int markInputPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102759906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102759906;
        // ---------- Original Method ----------
        //return ptr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.969 -0400", hash_original_method = "4FFD881D960C22E5DF32EAF983DA52C6", hash_generated_method = "D413B9EF62DAB37108B918E35BA715C3")
    public void rewindInputPosition(int position) {
        this.ptr = position;
        addTaint(position);
        // ---------- Original Method ----------
        //this.ptr = position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.969 -0400", hash_original_method = "2FDB8C189AB11331619907255B1EC94B", hash_generated_method = "950DA6AFE762F52C05A5C17FD67139A2")
    public String getRest() {
        String varB4EAC82CA7396A68D541C85D26508E83_1643291864 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_974830561 = null; //Variable for return #2
        {
            boolean var192220A640380CAF8B177C93C71998C2_1070741570 = (ptr >= buffer.length());
            varB4EAC82CA7396A68D541C85D26508E83_1643291864 = null;
            varB4EAC82CA7396A68D541C85D26508E83_974830561 = buffer.substring(ptr);
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_549650196; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_549650196 = varB4EAC82CA7396A68D541C85D26508E83_1643291864;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_549650196 = varB4EAC82CA7396A68D541C85D26508E83_974830561;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_549650196.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_549650196;
        // ---------- Original Method ----------
        //if (ptr >= buffer.length())
            //return null;
        //else
            //return buffer.substring(ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.970 -0400", hash_original_method = "720A9C8698AD8EBEF63DE1F048944846", hash_generated_method = "5112CC5AC9B180A817903B6AD1573E54")
    public String getString(char c) throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_856172563 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_856172563 = retval.toString();
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_856172563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_856172563;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.970 -0400", hash_original_method = "976AE9BCD44A20D9CC809F6C91A5525F", hash_generated_method = "3AC6FF17F188F369F71DC691F5AA0E1C")
    public int getPtr() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291504174 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291504174;
        // ---------- Original Method ----------
        //return this.ptr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_method = "E132864DD50CA73C29855C29E535CA90", hash_generated_method = "D93BB3727334C4AD68F0AACC54B19805")
    public String getBuffer() {
        String varB4EAC82CA7396A68D541C85D26508E83_1606914648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1606914648 = this.buffer;
        varB4EAC82CA7396A68D541C85D26508E83_1606914648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1606914648;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_method = "3D7442B3A5CE831DBB9C36AFA9551D12", hash_generated_method = "6A560AFC01B3D086F4FFDE3E69CA0039")
    public ParseException createParseException() {
        ParseException varB4EAC82CA7396A68D541C85D26508E83_1774634467 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1774634467 = new ParseException(this.buffer, this.ptr);
        varB4EAC82CA7396A68D541C85D26508E83_1774634467.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1774634467;
        // ---------- Original Method ----------
        //return new ParseException(this.buffer, this.ptr);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_field = "45E2E84CB7CD217D9439690A6AD02870", hash_generated_field = "42FCC650A8DCEEE6AA1C2C58CC59524F")

    public static final int START = 2048;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_field = "909ADB9B799B090DC750F3C6C224136E", hash_generated_field = "4D6E959ADFA99AA4AA54B17A19891BBC")

    public static final int END = START + 2048;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_field = "6A1823CE555BAD1530FAA32FE4807F14", hash_generated_field = "F67FCD2E62BF19D4DCBD11EB4FDC57CB")

    public static final int ID = END - 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_field = "91F23EE6E02708E1C67F6FB7FF4D8A29", hash_generated_field = "9F05BDB481A04F2AAF5084878ADCF1FB")

    public static final int SAFE = END - 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_field = "196A4373E6C79548553EC6425328468D", hash_generated_field = "C17723D563FB32573D21F1791836F81A")

    public static final int WHITESPACE = END + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_field = "4077E74EB6F3642E86DA8CA2770B1BB8", hash_generated_field = "F28563C191C95FA92F1C4D0946BEBD84")

    public static final int DIGIT = END + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.971 -0400", hash_original_field = "B571C6630A9F6D9A3529A53EF885D2CE", hash_generated_field = "FCC8A042E3C973A365D943D306241AEF")

    public static final int ALPHA = END + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "157D37D85B070AC4459BE50E1A9ED2F2", hash_generated_field = "E2E5343A09E9903C4D1A5A78F45ECA36")

    public static final int BACKSLASH = (int) '\\';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "72522E824EC4AB6DEC0E429B100587CD", hash_generated_field = "008AC3E66AF32B5DBAFEB8ED408692BF")

    public static final int QUOTE = (int) '\'';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "080D19EAA888BFE703755843727A6161", hash_generated_field = "0E63DD0BBE26268078E2DBF6C03CF049")

    public static final int AT = (int) '@';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "5CC4DC2EEAF5AD62452BCAC12EF8E8D0", hash_generated_field = "65A0FF9BC1214F9DC13DF3F98E49A358")

    public static final int SP = (int) ' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "B4DEBC25618854B73BD6851E7991C145", hash_generated_field = "A5CE1F2E561873DF97B24EDC61B6E021")

    public static final int HT = (int) '\t';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "0882A5D458F2B9742EDE1060769CCB30", hash_generated_field = "D7E6C3010C38900FC22DEBEF5CCC0BAF")

    public static final int COLON = (int) ':';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "4F1926BC1CF620426A944ECC1A8D81DA", hash_generated_field = "5577E36B751431D0650DCAB0614F5191")

    public static final int STAR = (int) '*';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "FB21676A9E64A5285C1D1A6B1E11821A", hash_generated_field = "231FAE26C0C2B9FBC64DCFC753F1AC1B")

    public static final int DOLLAR = (int) '$';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "639734FDFFFDB1045E467E778CA47E92", hash_generated_field = "C62A528B6CDE9BA9CC913A79EC1A48BA")

    public static final int PLUS = (int) '+';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "8F64723D950A98135D932BF85ED552D6", hash_generated_field = "4B930043CB5FB0157482480B46607D54")

    public static final int POUND = (int) '#';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "60A935DDA1D4D1FC920825BBE9AD3967", hash_generated_field = "2A069EBC792AD71EBEEF3ED900453580")

    public static final int MINUS = (int) '-';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "2997360C2592DECAC45E67F168675859", hash_generated_field = "698ADD1884DA7FE94B15F67D55E1FCDA")

    public static final int DOUBLEQUOTE = (int) '\"';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "D3CAB47DAD619EC2066E7A17B08085D8", hash_generated_field = "292F6240589161556EC3428CE3789C07")

    public static final int TILDE = (int) '~';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "06FE865DAC48273E0D30B35FB9574A15", hash_generated_field = "4891B8D8EDA80AEA9A9D9833D5CE8769")

    public static final int BACK_QUOTE = (int) '`';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "BDC94DF62ED4DBADC431CA620E58A0E3", hash_generated_field = "6F22E0D1261A966DAEE18D177D7331F8")

    public static final int NULL = (int) '\0';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "95202F5E42E363A640E15A267FB3485C", hash_generated_field = "94F502FA8271B6C9F53A58E364FD31A0")

    public static final int EQUALS = (int) '=';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "9BEB907FD2E6587529AD2C25FB6D663E", hash_generated_field = "3B7D3591D25BBAA77F0237477D39C2A8")

    public static final int SEMICOLON = (int) ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "B95BAAF4E11E7CD22040F2A50C3E6F4A", hash_generated_field = "4296368DF34F2F6EE376EFA924B0864B")

    public static final int SLASH = (int) '/';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "4633B1C3218683401759608C7A3491BC", hash_generated_field = "4C993680785AFCD43E6BC94D781CB373")

    public static final int L_SQUARE_BRACKET = (int) '[';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "2B537F63F65B55BF45FDD45E1B10291F", hash_generated_field = "D6D5110A208194AF7B1EC486B63405DD")

    public static final int R_SQUARE_BRACKET = (int) ']';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "3AF47DE7A0EA5F5D9680D66195B3C048", hash_generated_field = "A1E2A4AF20AABBE655EBFE36649C9595")

    public static final int R_CURLY = (int) '}';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "8A15FAC2DB530359A3730FF8F82A5CD6", hash_generated_field = "6D77C6B80D66382592FDE34848F4C1FF")

    public static final int L_CURLY = (int) '{';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "BB22EC4153DCA2A75B45CC62C32AED22", hash_generated_field = "763AD424A9EB120D14D6402087824468")

    public static final int HAT = (int) '^';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "86359D9D43ADF12190BB0F22F3A8211A", hash_generated_field = "E4EEAF80F73B9E93D9CF6DEED4993BAE")

    public static final int BAR = (int) '|';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "2B05C3EFB51DE9AE8B52E25FF84979A6", hash_generated_field = "09D2F8A6FE8AA7284E3E06A6C6C606EF")

    public static final int DOT = (int) '.';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "60492EC0D9978B2FEBE79AAC26AEB785", hash_generated_field = "45631F45802F5CBBB666B8BF83AB239B")

    public static final int EXCLAMATION = (int) '!';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "B6DD371B5C053CBC61DAECD2E866C0F3", hash_generated_field = "F2FC2CAE354F85A66D31202E3AFC6343")

    public static final int LPAREN = (int) '(';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "16F9EE492B04EEC96841CDC898ABFC58", hash_generated_field = "E7AE3F587B3D4886E7DB9CFDDC53E2EA")

    public static final int RPAREN = (int) ')';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "FC386E7F83638266966F4988C7DA71A1", hash_generated_field = "65D1F17C93E1F09812E4B69F43BE3B23")

    public static final int GREATER_THAN = (int) '>';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "7A9C3B20ACB2AA5CF6BB8BF6FC7B6DD2", hash_generated_field = "9205B2F85DE81720CBD2E7916081200F")

    public static final int LESS_THAN = (int) '<';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "80F7AB32F26C12B891C528D54015D4CC", hash_generated_field = "36822253DE16D15C507CA4AD98B0D4AF")

    public static final int PERCENT = (int) '%';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.972 -0400", hash_original_field = "D49343D49E879CC1DB9DA9184C150067", hash_generated_field = "C59D2238695EF14FB400F2DEBCEFB200")

    public static final int QUESTION = (int) '?';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.973 -0400", hash_original_field = "4FAA412D23BC6BBEFFE744E3077105FB", hash_generated_field = "95AD51D349B8D0A02402803B1A69149C")

    public static final int AND = (int) '&';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.973 -0400", hash_original_field = "940E6C77EDC9B0432CAB6E5EA71DD3E8", hash_generated_field = "D9C0E3D2A8514389A067E4ACE778BC68")

    public static final int UNDERSCORE = (int) '_';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.973 -0400", hash_original_field = "5EF8D1EC4592F88FD84C3F9EDC2843B2", hash_generated_field = "9A4439847AD02C063A85CA312E27B5B7")

    protected static Hashtable globalSymbolTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.973 -0400", hash_original_field = "63E429E4D7FA682FCC2A304EFC9F41AE", hash_generated_field = "94CD673D75FBEC685CA66860DE29769A")

    protected static Hashtable lexerTables;
    static {
        globalSymbolTable = new Hashtable();
        lexerTables = new Hashtable();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.973 -0400", hash_original_field = "D6C2FADA4E648D6ED587DBD7AB15EEA5", hash_generated_field = "7C917C954853A09048DCB3AF2A3FA162")

    static char ALPHA_VALID_CHARS = Character.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.973 -0400", hash_original_field = "3604F0FAE73F23527368BA3FCFA619FE", hash_generated_field = "A317246ACD2FCE905A66CA68F0573123")

    static char DIGIT_VALID_CHARS = Character.MAX_VALUE - 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.973 -0400", hash_original_field = "8E7F1A747D1012C4EE86D23FB14ECEA3", hash_generated_field = "5C2AFCC587E4CBB58A40B454CC899E43")

    static char ALPHADIGIT_VALID_CHARS = Character.MAX_VALUE - 2;
}

