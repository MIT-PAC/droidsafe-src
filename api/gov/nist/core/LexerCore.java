package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.Hashtable;






public class LexerCore extends StringTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.484 -0400", hash_original_field = "B0F13C43E094802743B3161861C2DD0D", hash_generated_field = "73DC8498A7AED0DB7B89805A8124EB6C")

    protected Hashtable currentLexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.484 -0400", hash_original_field = "C1B2DFD6C6DC23006E47A698CF2EB941", hash_generated_field = "CBCC5F8F420E7C818FCF47E1FDA6C4BE")

    protected String currentLexerName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.484 -0400", hash_original_field = "2FD6DA3C66080705F49ACC8A63DD8192", hash_generated_field = "A0375D48FDB0A7A220B130B3BD520E09")

    protected Token currentMatch;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.485 -0400", hash_original_method = "F81A1A23CDDF7D21ADD1D8559F70EDF8", hash_generated_method = "19E7A347F27B6A740B2625DD5BBF0D5D")
    protected  LexerCore() {
        this.currentLexer = new Hashtable();
        this.currentLexerName = "charLexer";
        // ---------- Original Method ----------
        //this.currentLexer = new Hashtable();
        //this.currentLexerName = "charLexer";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.485 -0400", hash_original_method = "E63C8DBFE6FAFFBE522AAC8B0CA2CC77", hash_generated_method = "0CD5C881208739B291EFCEA06D660F21")
    public  LexerCore(String lexerName, String buffer) {
        super(buffer);
        addTaint(buffer.getTaint());
        this.currentLexerName = lexerName;
        // ---------- Original Method ----------
        //this.currentLexerName = lexerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.486 -0400", hash_original_method = "AD96F60DA08AE9E896CB042D3CC5B1A1", hash_generated_method = "61703AB8DEDD3BC5F24035A8BD547ACA")
    protected void addKeyword(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        Integer val = Integer.valueOf(value);
        currentLexer.put(name, val);
        if(!globalSymbolTable.containsKey(val))        
        globalSymbolTable.put(val, name);
        // ---------- Original Method ----------
        //Integer val = Integer.valueOf(value);
        //currentLexer.put(name, val);
        //if (!globalSymbolTable.containsKey(val))
            //globalSymbolTable.put(val, name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.487 -0400", hash_original_method = "3D857462C470E4A1F5CD1262364F803E", hash_generated_method = "3CD454ED8215B8AEEE270F9455A43E62")
    public String lookupToken(int value) {
        addTaint(value);
        if(value > START)        
        {
String var9393DB40296C442A01EB4F6BC4836FE8_1274675464 =             (String) globalSymbolTable.get(Integer.valueOf(value));
            var9393DB40296C442A01EB4F6BC4836FE8_1274675464.addTaint(taint);
            return var9393DB40296C442A01EB4F6BC4836FE8_1274675464;
        } //End block
        else
        {
            Character ch = Character.valueOf((char) value);
String varE40BD3D60B6E3E9CBE4DAE78046C1312_300404088 =             ch.toString();
            varE40BD3D60B6E3E9CBE4DAE78046C1312_300404088.addTaint(taint);
            return varE40BD3D60B6E3E9CBE4DAE78046C1312_300404088;
        } //End block
        // ---------- Original Method ----------
        //if (value > START) {
            //return (String) globalSymbolTable.get(Integer.valueOf(value));
        //} else {
            //Character ch = Character.valueOf((char) value);
            //return ch.toString();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.488 -0400", hash_original_method = "A9968CF51D1D67FF8D3FB6DE23BFC8AA", hash_generated_method = "6AF492B86042B44136F8C356EEFC744A")
    protected Hashtable addLexer(String lexerName) {
        currentLexer = (Hashtable) lexerTables.get(lexerName);
        if(currentLexer == null)        
        {
            currentLexer = new Hashtable();
            lexerTables.put(lexerName, currentLexer);
        } //End block
Hashtable varB406B65E78DE5EEA723ABCBB6A241AA3_1462135137 =         currentLexer;
        varB406B65E78DE5EEA723ABCBB6A241AA3_1462135137.addTaint(taint);
        return varB406B65E78DE5EEA723ABCBB6A241AA3_1462135137;
        // ---------- Original Method ----------
        //currentLexer = (Hashtable) lexerTables.get(lexerName);
        //if (currentLexer == null) {
            //currentLexer = new Hashtable();
            //lexerTables.put(lexerName, currentLexer);
        //}
        //return currentLexer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.488 -0400", hash_original_method = "D20C9FA92CD9B4968A44EC6CC8CD338F", hash_generated_method = "B54E7BB236C631028B1E4228D89A1C2D")
    public void selectLexer(String lexerName) {
        this.currentLexerName = lexerName;
        // ---------- Original Method ----------
        //this.currentLexerName = lexerName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.489 -0400", hash_original_method = "490BF814B9BDCA5834E18A73438F6256", hash_generated_method = "77B971CB1542EB2940D17FEC93ABCC21")
    public String peekNextId() {
        int oldPtr = ptr;
        String retval = ttoken();
        savedPtr = ptr;
        ptr = oldPtr;
String varF9E19AD6135C970F387F77C6F3DE4477_1002229796 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1002229796.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1002229796;
        // ---------- Original Method ----------
        //int oldPtr = ptr;
        //String retval = ttoken();
        //savedPtr = ptr;
        //ptr = oldPtr;
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.489 -0400", hash_original_method = "7F6D0FFBB3DD0E896E18057F7DC876B2", hash_generated_method = "4BE9CFEF28082AFE3D7D3A85E97365D8")
    public String getNextId() {
String var8A2ECCBCB7CC49E68555F1F70EC6B023_269579606 =         ttoken();
        var8A2ECCBCB7CC49E68555F1F70EC6B023_269579606.addTaint(taint);
        return var8A2ECCBCB7CC49E68555F1F70EC6B023_269579606;
        // ---------- Original Method ----------
        //return ttoken();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.489 -0400", hash_original_method = "DD3F66B83694243DF059D5B5621ADB54", hash_generated_method = "60BBFDEB0CAB618275369F29884F812A")
    public Token getNextToken() {
Token var4F2F48FA7E0E08F3309FEA0E4F1D3813_1791138060 =         this.currentMatch;
        var4F2F48FA7E0E08F3309FEA0E4F1D3813_1791138060.addTaint(taint);
        return var4F2F48FA7E0E08F3309FEA0E4F1D3813_1791138060;
        // ---------- Original Method ----------
        //return this.currentMatch;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.489 -0400", hash_original_method = "7245F245408FA6FEC683585F2431BE34", hash_generated_method = "79484296148C99BA84ACFA27E1D1F04A")
    public Token peekNextToken() throws ParseException {
Token var56EDAF3C69C0E5C2B44B57EEDFB6EDC8_1216930936 =         (Token) peekNextToken(1)[0];
        var56EDAF3C69C0E5C2B44B57EEDFB6EDC8_1216930936.addTaint(taint);
        return var56EDAF3C69C0E5C2B44B57EEDFB6EDC8_1216930936;
        // ---------- Original Method ----------
        //return (Token) peekNextToken(1)[0];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.491 -0400", hash_original_method = "E053A5C6A0917BEE124D59DA4B3EBFD6", hash_generated_method = "2C052BE94B70458FA34FCF63411B249D")
    public Token[] peekNextToken(int ntokens) throws ParseException {
        addTaint(ntokens);
        int old = ptr;
        Token[] retval = new Token[ntokens];
for(int i = 0;i < ntokens;i++)
        {
            Token tok = new Token();
            if(startsId())            
            {
                String id = ttoken();
                tok.tokenValue = id;
                String idUppercase = id.toUpperCase();
                if(currentLexer.containsKey(idUppercase))                
                {
                    Integer type = (Integer) currentLexer.get(idUppercase);
                    tok.tokenType = type.intValue();
                } //End block
                else
                tok.tokenType = ID;
            } //End block
            else
            {
                char nextChar = getNextChar();
                tok.tokenValue = String.valueOf(nextChar);
                if(isAlpha(nextChar))                
                {
                    tok.tokenType = ALPHA;
                } //End block
                else
                if(isDigit(nextChar))                
                {
                    tok.tokenType = DIGIT;
                } //End block
                else
                tok.tokenType = (int) nextChar;
            } //End block
            retval[i] = tok;
        } //End block
        savedPtr = ptr;
        ptr = old;
Token[] varF9E19AD6135C970F387F77C6F3DE4477_553453569 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_553453569.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_553453569;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.493 -0400", hash_original_method = "EF527252962F704D7452C6B99500917D", hash_generated_method = "804C116AB8A4D982309AC747B966B387")
    public Token match(int tok) throws ParseException {
        if(Debug.parserDebug)        
        {
            Debug.println("match " + tok);
        } //End block
        if(tok > START && tok < END)        
        {
            if(tok == ID)            
            {
                if(!startsId())                
                {
                ParseException varE99E5868FF58E96492079DE825C1BBB8_90758463 = new ParseException(buffer + "\nID expected", ptr);
                varE99E5868FF58E96492079DE825C1BBB8_90758463.addTaint(taint);
                throw varE99E5868FF58E96492079DE825C1BBB8_90758463;
                }
                String id = getNextId();
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = id;
                this.currentMatch.tokenType = ID;
            } //End block
            else
            if(tok == SAFE)            
            {
                if(!startsSafeToken())                
                {
                ParseException varE99E5868FF58E96492079DE825C1BBB8_1146988881 = new ParseException(buffer + "\nID expected", ptr);
                varE99E5868FF58E96492079DE825C1BBB8_1146988881.addTaint(taint);
                throw varE99E5868FF58E96492079DE825C1BBB8_1146988881;
                }
                String id = ttokenSafe();
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = id;
                this.currentMatch.tokenType = SAFE;
            } //End block
            else
            {
                String nexttok = getNextId();
                Integer cur = (Integer) currentLexer.get(nexttok.toUpperCase());
                if(cur == null || cur.intValue() != tok)                
                {
                ParseException var5DB5CFF30BB4941AF3EF64D5D7DEB48C_1031218509 = new ParseException(
                        buffer + "\nUnexpected Token : " + nexttok,
                        ptr);
                var5DB5CFF30BB4941AF3EF64D5D7DEB48C_1031218509.addTaint(taint);
                throw var5DB5CFF30BB4941AF3EF64D5D7DEB48C_1031218509;
                }
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = nexttok;
                this.currentMatch.tokenType = tok;
            } //End block
        } //End block
        else
        if(tok > END)        
        {
            char next = lookAhead(0);
            if(tok == DIGIT)            
            {
                if(!isDigit(next))                
                {
                ParseException var39DFAE5471B37CEA0870581BDAE99644_1290151164 = new ParseException(buffer + "\nExpecting DIGIT", ptr);
                var39DFAE5471B37CEA0870581BDAE99644_1290151164.addTaint(taint);
                throw var39DFAE5471B37CEA0870581BDAE99644_1290151164;
                }
                this.currentMatch = new Token();
                this.currentMatch.tokenValue =
                    String.valueOf(next);
                this.currentMatch.tokenType = tok;
                consume(1);
            } //End block
            else
            if(tok == ALPHA)            
            {
                if(!isAlpha(next))                
                {
                ParseException varBCD924D377C26FE56B0685C063CDC360_775812440 = new ParseException(buffer + "\nExpecting ALPHA", ptr);
                varBCD924D377C26FE56B0685C063CDC360_775812440.addTaint(taint);
                throw varBCD924D377C26FE56B0685C063CDC360_775812440;
                }
                this.currentMatch = new Token();
                this.currentMatch.tokenValue =
                    String.valueOf(next);
                this.currentMatch.tokenType = tok;
                consume(1);
            } //End block
        } //End block
        else
        {
            char ch = (char) tok;
            char next = lookAhead(0);
            if(next == ch)            
            {
                consume(1);
            } //End block
            else
            {
            ParseException varE6EC81A34D518475E96BC58DBDD8703E_49863200 = new ParseException(
                    buffer + "\nExpecting  >>>" + ch + "<<< got >>>"
                    + next + "<<<", ptr);
            varE6EC81A34D518475E96BC58DBDD8703E_49863200.addTaint(taint);
            throw varE6EC81A34D518475E96BC58DBDD8703E_49863200;
            }
        } //End block
Token var4F2F48FA7E0E08F3309FEA0E4F1D3813_1116266735 =         this.currentMatch;
        var4F2F48FA7E0E08F3309FEA0E4F1D3813_1116266735.addTaint(taint);
        return var4F2F48FA7E0E08F3309FEA0E4F1D3813_1116266735;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.494 -0400", hash_original_method = "2A2C3BB94776A03619BA392D0DD9FA22", hash_generated_method = "4050FC46B793FE5A4471DF1021454707")
    public void SPorHT() {
        try 
        {
            char c = lookAhead(0);
            while
(c == ' ' || c == '\t')            
            {
                consume(1);
                c = lookAhead(0);
            } //End block
        } //End block
        catch (ParseException ex)
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.494 -0400", hash_original_method = "F58976B32EA8A9502EE0AC2AF2B6A7AB", hash_generated_method = "CD638620C92ECA7E8B884F5D7350A73B")
    public boolean startsId() {
        try 
        {
            char nextChar = lookAhead(0);
            boolean var5558415573AA7398411027BF092861EF_1590202952 = (isTokenChar(nextChar));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864484324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864484324;
        } //End block
        catch (ParseException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_2090437541 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682368742 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682368742;
        } //End block
        // ---------- Original Method ----------
        //try {
            //char nextChar = lookAhead(0);
            //return isTokenChar(nextChar);
        //} catch (ParseException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.494 -0400", hash_original_method = "F94CBEE0A9F2E4712D2EBE65CDCE3A2F", hash_generated_method = "8D925A757A9CB06DCAFAEB97DB93949B")
    public boolean startsSafeToken() {
        try 
        {
            char nextChar = lookAhead(0);
            if(isAlphaDigit(nextChar))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1949942346 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97111892 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_97111892;
            } //End block
            else
            {
switch(nextChar){
                case '_':
                case '+':
                case '-':
                case '!':
                case '`':
                case '\'':
                case '.':
                case '/':
                case '}':
                case '{':
                case ']':
                case '[':
                case '^':
                case '|':
                case '~':
                case '%':
                case '#':
                case '@':
                case '$':
                case ':':
                case ';':
                case '?':
                case '\"':
                case '*':
                case '=':
                boolean varB326B5062B2F0E69046810717534CB09_1216176328 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382933522 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382933522;
                default:
                boolean var68934A3E9455FA72420237EB05902327_1624426466 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1926308640 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1926308640;
}
            } //End block
        } //End block
        catch (ParseException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_25034005 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306834289 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306834289;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.495 -0400", hash_original_method = "263A0804A198D7BD9F45ED20C20E2FC4", hash_generated_method = "29E4224764B2BEE5E26FDFE4FF0EDD04")
    public String ttoken() {
        int startIdx = ptr;
        try 
        {
            while
(hasMoreChars())            
            {
                char nextChar = lookAhead(0);
                if(isTokenChar(nextChar))                
                {
                    consume(1);
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
String var6AFF5978BAB12C2506D33445AED98631_399969516 =             buffer.substring(startIdx, ptr);
            var6AFF5978BAB12C2506D33445AED98631_399969516.addTaint(taint);
            return var6AFF5978BAB12C2506D33445AED98631_399969516;
        } //End block
        catch (ParseException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1154880251 =             null;
            var540C13E9E156B687226421B24F2DF178_1154880251.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1154880251;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.495 -0400", hash_original_method = "888B4B5B30F6453059C386257A5A6804", hash_generated_method = "EB89B3E8DF836BF562AB103748BF92A8")
    public String ttokenSafe() {
        int startIdx = ptr;
        try 
        {
            while
(hasMoreChars())            
            {
                char nextChar = lookAhead(0);
                if(isAlphaDigit(nextChar))                
                {
                    consume(1);
                } //End block
                else
                {
                    boolean isValidChar = false;
switch(nextChar){
                    case '_':
                    case '+':
                    case '-':
                    case '!':
                    case '`':
                    case '\'':
                    case '.':
                    case '/':
                    case '}':
                    case '{':
                    case ']':
                    case '[':
                    case '^':
                    case '|':
                    case '~':
                    case '%':
                    case '#':
                    case '@':
                    case '$':
                    case ':':
                    case ';':
                    case '?':
                    case '\"':
                    case '*':
                    isValidChar = true;
}                    if(isValidChar)                    
                    {
                        consume(1);
                    } //End block
                    else
                    {
                        break;
                    } //End block
                } //End block
            } //End block
String var6AFF5978BAB12C2506D33445AED98631_1645191571 =             buffer.substring(startIdx, ptr);
            var6AFF5978BAB12C2506D33445AED98631_1645191571.addTaint(taint);
            return var6AFF5978BAB12C2506D33445AED98631_1645191571;
        } //End block
        catch (ParseException ex)
        {
String var540C13E9E156B687226421B24F2DF178_448145471 =             null;
            var540C13E9E156B687226421B24F2DF178_448145471.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_448145471;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.497 -0400", hash_original_method = "8CC0A9D05C89C60DBFAAF7C7ED88483F", hash_generated_method = "52BA2DA413C23889FAD9CFE9C7EB3FCD")
    public void consumeValidChars(char[] validChars) {
        addTaint(validChars[0]);
        int validCharsLength = validChars.length;
        try 
        {
            while
(hasMoreChars())            
            {
                char nextChar = lookAhead(0);
                boolean isValid = false;
for(int i = 0;i < validCharsLength;i++)
                {
                    char validChar = validChars[i];
switch(validChar){
                    case ALPHA_VALID_CHARS:
                    isValid = isAlpha(nextChar);
                    break;
                    case DIGIT_VALID_CHARS:
                    isValid = isDigit(nextChar);
                    break;
                    case ALPHADIGIT_VALID_CHARS:
                    isValid = isAlphaDigit(nextChar);
                    break;
                    default:
                    isValid = nextChar == validChar;
}                    if(isValid)                    
                    {
                        break;
                    } //End block
                } //End block
                if(isValid)                
                {
                    consume(1);
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.498 -0400", hash_original_method = "17D25E29F0B0C1524A5E10AF751238A3", hash_generated_method = "C0C96D758F025F2C6A6100DB19F4B6FB")
    public String quotedString() throws ParseException {
        int startIdx = ptr + 1;
        if(lookAhead(0) != '\"')        
        {
String var540C13E9E156B687226421B24F2DF178_841968733 =         null;
        var540C13E9E156B687226421B24F2DF178_841968733.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_841968733;
        }
        consume(1);
        while
(true)        
        {
            char next = getNextChar();
            if(next == '\"')            
            {
                break;
            } //End block
            else
            if(next == '\0')            
            {
                ParseException var0186FD84B679163F3F2BC190810829DF_1179220904 = new ParseException(
                    this.buffer + " :unexpected EOL",
                    this.ptr);
                var0186FD84B679163F3F2BC190810829DF_1179220904.addTaint(taint);
                throw var0186FD84B679163F3F2BC190810829DF_1179220904;
            } //End block
            else
            if(next == '\\')            
            {
                consume(1);
            } //End block
        } //End block
String var99047E80C8D908E7450B95CA048E9A1B_2094692887 =         buffer.substring(startIdx, ptr - 1);
        var99047E80C8D908E7450B95CA048E9A1B_2094692887.addTaint(taint);
        return var99047E80C8D908E7450B95CA048E9A1B_2094692887;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.498 -0400", hash_original_method = "0DEFD663D479F88E7A114CE703AF8835", hash_generated_method = "2A8B5ED1F07ED40924A52CFCCAF2E886")
    public String comment() throws ParseException {
        StringBuffer retval = new StringBuffer();
        if(lookAhead(0) != '(')        
        {
String var540C13E9E156B687226421B24F2DF178_792214734 =         null;
        var540C13E9E156B687226421B24F2DF178_792214734.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_792214734;
        }
        consume(1);
        while
(true)        
        {
            char next = getNextChar();
            if(next == ')')            
            {
                break;
            } //End block
            else
            if(next == '\0')            
            {
                ParseException var0186FD84B679163F3F2BC190810829DF_1725326455 = new ParseException(
                    this.buffer + " :unexpected EOL",
                    this.ptr);
                var0186FD84B679163F3F2BC190810829DF_1725326455.addTaint(taint);
                throw var0186FD84B679163F3F2BC190810829DF_1725326455;
            } //End block
            else
            if(next == '\\')            
            {
                retval.append(next);
                next = getNextChar();
                if(next == '\0')                
                {
                ParseException var87433E446363A112F72D21FC15898A10_1894750937 = new ParseException(
                        this.buffer + " : unexpected EOL",
                        this.ptr);
                var87433E446363A112F72D21FC15898A10_1894750937.addTaint(taint);
                throw var87433E446363A112F72D21FC15898A10_1894750937;
                }
                retval.append(next);
            } //End block
            else
            {
                retval.append(next);
            } //End block
        } //End block
String var1B324365A764C077A55854483509F4AB_63772602 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_63772602.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_63772602;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.499 -0400", hash_original_method = "86F26DE68AB39CE9DEE1E486630D72BD", hash_generated_method = "0B56F780EE001BEB9DF59C5FBFD9240E")
    public String byteStringNoSemicolon() {
        StringBuffer retval = new StringBuffer();
        try 
        {
            while
(true)            
            {
                char next = lookAhead(0);
                if(next == '\0' || next == '\n' || next == ';' || next == ',')                
                {
                    break;
                } //End block
                else
                {
                    consume(1);
                    retval.append(next);
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        {
String var1B324365A764C077A55854483509F4AB_647870088 =             retval.toString();
            var1B324365A764C077A55854483509F4AB_647870088.addTaint(taint);
            return var1B324365A764C077A55854483509F4AB_647870088;
        } //End block
String var1B324365A764C077A55854483509F4AB_505165004 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_505165004.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_505165004;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.499 -0400", hash_original_method = "B2A0AA5C97E9078316CA6FEBE65DB0C3", hash_generated_method = "5235B0B1E85B186686139B46BB8CC4E7")
    public String byteStringNoSlash() {
        StringBuffer retval = new StringBuffer();
        try 
        {
            while
(true)            
            {
                char next = lookAhead(0);
                if(next == '\0' || next == '\n' || next == '/')                
                {
                    break;
                } //End block
                else
                {
                    consume(1);
                    retval.append(next);
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        {
String var1B324365A764C077A55854483509F4AB_2129352147 =             retval.toString();
            var1B324365A764C077A55854483509F4AB_2129352147.addTaint(taint);
            return var1B324365A764C077A55854483509F4AB_2129352147;
        } //End block
String var1B324365A764C077A55854483509F4AB_901928 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_901928.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_901928;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.499 -0400", hash_original_method = "03994A77D1324F910A7EC2E8D4C779CB", hash_generated_method = "E8FF5D9F58A003AB9C68C082D5F04E22")
    public String byteStringNoComma() {
        StringBuffer retval = new StringBuffer();
        try 
        {
            while
(true)            
            {
                char next = lookAhead(0);
                if(next == '\n' || next == ',')                
                {
                    break;
                } //End block
                else
                {
                    consume(1);
                    retval.append(next);
                } //End block
            } //End block
        } //End block
        catch (ParseException ex)
        {
        } //End block
String var1B324365A764C077A55854483509F4AB_2095785736 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_2095785736.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_2095785736;
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

    
    @DSModeled(DSC.SAFE)
    public static String charAsString(char ch) {
        return String.valueOf(ch);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.499 -0400", hash_original_method = "5A32401256C252E56BBB94CC59C2BA04", hash_generated_method = "B3B9C2E85F7A0812457E7C6F8298A1F5")
    public String charAsString(int nchars) {
        addTaint(nchars);
String var0F966DE49562217014D14DFD47D907D7_1350558822 =         buffer.substring(ptr, ptr + nchars);
        var0F966DE49562217014D14DFD47D907D7_1350558822.addTaint(taint);
        return var0F966DE49562217014D14DFD47D907D7_1350558822;
        // ---------- Original Method ----------
        //return buffer.substring(ptr, ptr + nchars);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.500 -0400", hash_original_method = "322A7AA8BD0B180616D94A352B3FE7FA", hash_generated_method = "DC587EEDBAF2D1D657353D69883A275B")
    public String number() throws ParseException {
        int startIdx = ptr;
        try 
        {
            if(!isDigit(lookAhead(0)))            
            {
                ParseException var4B10CC6340744AC14885E10C44FD629B_1393354303 = new ParseException(
                    buffer + ": Unexpected token at " + lookAhead(0),
                    ptr);
                var4B10CC6340744AC14885E10C44FD629B_1393354303.addTaint(taint);
                throw var4B10CC6340744AC14885E10C44FD629B_1393354303;
            } //End block
            consume(1);
            while
(true)            
            {
                char next = lookAhead(0);
                if(isDigit(next))                
                {
                    consume(1);
                } //End block
                else
                break;
            } //End block
String var6AFF5978BAB12C2506D33445AED98631_1119537087 =             buffer.substring(startIdx, ptr);
            var6AFF5978BAB12C2506D33445AED98631_1119537087.addTaint(taint);
            return var6AFF5978BAB12C2506D33445AED98631_1119537087;
        } //End block
        catch (ParseException ex)
        {
String var6AFF5978BAB12C2506D33445AED98631_879077918 =             buffer.substring(startIdx, ptr);
            var6AFF5978BAB12C2506D33445AED98631_879077918.addTaint(taint);
            return var6AFF5978BAB12C2506D33445AED98631_879077918;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.500 -0400", hash_original_method = "8137BED0F2B5219001CD3D42EAB84127", hash_generated_method = "BE8F6134414DF0DE9485BE421F395A17")
    public int markInputPosition() {
        int var4D9AD2B37053671B594B237BD061B3F2_1588999567 = (ptr);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545391484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545391484;
        // ---------- Original Method ----------
        //return ptr;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.500 -0400", hash_original_method = "4FFD881D960C22E5DF32EAF983DA52C6", hash_generated_method = "21CE12940DD457309624138D4ECF311D")
    public void rewindInputPosition(int position) {
        addTaint(position);
        this.ptr = position;
        // ---------- Original Method ----------
        //this.ptr = position;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.500 -0400", hash_original_method = "2FDB8C189AB11331619907255B1EC94B", hash_generated_method = "CCAAC0802EF81D0BC57F9041B4E9F78A")
    public String getRest() {
        if(ptr >= buffer.length())        
        {
String var540C13E9E156B687226421B24F2DF178_321426263 =         null;
        var540C13E9E156B687226421B24F2DF178_321426263.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_321426263;
        }
        else
        {
String var80E0A1BD12E9EB1E52F54BB94AE35FBC_719064184 =         buffer.substring(ptr);
        var80E0A1BD12E9EB1E52F54BB94AE35FBC_719064184.addTaint(taint);
        return var80E0A1BD12E9EB1E52F54BB94AE35FBC_719064184;
        }
        // ---------- Original Method ----------
        //if (ptr >= buffer.length())
            //return null;
        //else
            //return buffer.substring(ptr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.500 -0400", hash_original_method = "720A9C8698AD8EBEF63DE1F048944846", hash_generated_method = "7B75C943CEB9264BFA78D6088E2DB5C7")
    public String getString(char c) throws ParseException {
        addTaint(c);
        StringBuffer retval = new StringBuffer();
        while
(true)        
        {
            char next = lookAhead(0);
            if(next == '\0')            
            {
                ParseException var2FA1F83C364AF67F045C4459F3EDC3B1_317295194 = new ParseException(
                    this.buffer + "unexpected EOL",
                    this.ptr);
                var2FA1F83C364AF67F045C4459F3EDC3B1_317295194.addTaint(taint);
                throw var2FA1F83C364AF67F045C4459F3EDC3B1_317295194;
            } //End block
            else
            if(next == c)            
            {
                consume(1);
                break;
            } //End block
            else
            if(next == '\\')            
            {
                consume(1);
                char nextchar = lookAhead(0);
                if(nextchar == '\0')                
                {
                    ParseException var2FA1F83C364AF67F045C4459F3EDC3B1_639904691 = new ParseException(
                        this.buffer + "unexpected EOL",
                        this.ptr);
                    var2FA1F83C364AF67F045C4459F3EDC3B1_639904691.addTaint(taint);
                    throw var2FA1F83C364AF67F045C4459F3EDC3B1_639904691;
                } //End block
                else
                {
                    consume(1);
                    retval.append(nextchar);
                } //End block
            } //End block
            else
            {
                consume(1);
                retval.append(next);
            } //End block
        } //End block
String var1B324365A764C077A55854483509F4AB_1114026764 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1114026764.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1114026764;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.500 -0400", hash_original_method = "976AE9BCD44A20D9CC809F6C91A5525F", hash_generated_method = "DEA6E0F395B02DB3B2952D0BDA0973AA")
    public int getPtr() {
        int varD9EB9EEDFEDE792C88EE68853ADFE49F_1840541258 = (this.ptr);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199644283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199644283;
        // ---------- Original Method ----------
        //return this.ptr;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.500 -0400", hash_original_method = "E132864DD50CA73C29855C29E535CA90", hash_generated_method = "BCB1F234C75F5F2BFAAE96CCE8CABBB2")
    public String getBuffer() {
String var45A7A4931E21905A5463F27B77E1344A_787007459 =         this.buffer;
        var45A7A4931E21905A5463F27B77E1344A_787007459.addTaint(taint);
        return var45A7A4931E21905A5463F27B77E1344A_787007459;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_method = "3D7442B3A5CE831DBB9C36AFA9551D12", hash_generated_method = "EF41F50FB2953D1FBB17159EF8AA3C07")
    public ParseException createParseException() {
ParseException var9A65CD9ED84788A978C315F5B36906E5_407746767 =         new ParseException(this.buffer, this.ptr);
        var9A65CD9ED84788A978C315F5B36906E5_407746767.addTaint(taint);
        return var9A65CD9ED84788A978C315F5B36906E5_407746767;
        // ---------- Original Method ----------
        //return new ParseException(this.buffer, this.ptr);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "45E2E84CB7CD217D9439690A6AD02870", hash_generated_field = "42FCC650A8DCEEE6AA1C2C58CC59524F")

    public static final int START = 2048;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "909ADB9B799B090DC750F3C6C224136E", hash_generated_field = "4D6E959ADFA99AA4AA54B17A19891BBC")

    public static final int END = START + 2048;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "6A1823CE555BAD1530FAA32FE4807F14", hash_generated_field = "F67FCD2E62BF19D4DCBD11EB4FDC57CB")

    public static final int ID = END - 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "91F23EE6E02708E1C67F6FB7FF4D8A29", hash_generated_field = "9F05BDB481A04F2AAF5084878ADCF1FB")

    public static final int SAFE = END - 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "196A4373E6C79548553EC6425328468D", hash_generated_field = "C17723D563FB32573D21F1791836F81A")

    public static final int WHITESPACE = END + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "4077E74EB6F3642E86DA8CA2770B1BB8", hash_generated_field = "F28563C191C95FA92F1C4D0946BEBD84")

    public static final int DIGIT = END + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "B571C6630A9F6D9A3529A53EF885D2CE", hash_generated_field = "FCC8A042E3C973A365D943D306241AEF")

    public static final int ALPHA = END + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "157D37D85B070AC4459BE50E1A9ED2F2", hash_generated_field = "E2E5343A09E9903C4D1A5A78F45ECA36")

    public static final int BACKSLASH = (int) '\\';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "72522E824EC4AB6DEC0E429B100587CD", hash_generated_field = "008AC3E66AF32B5DBAFEB8ED408692BF")

    public static final int QUOTE = (int) '\'';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "080D19EAA888BFE703755843727A6161", hash_generated_field = "0E63DD0BBE26268078E2DBF6C03CF049")

    public static final int AT = (int) '@';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "5CC4DC2EEAF5AD62452BCAC12EF8E8D0", hash_generated_field = "65A0FF9BC1214F9DC13DF3F98E49A358")

    public static final int SP = (int) ' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "B4DEBC25618854B73BD6851E7991C145", hash_generated_field = "A5CE1F2E561873DF97B24EDC61B6E021")

    public static final int HT = (int) '\t';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "0882A5D458F2B9742EDE1060769CCB30", hash_generated_field = "D7E6C3010C38900FC22DEBEF5CCC0BAF")

    public static final int COLON = (int) ':';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "4F1926BC1CF620426A944ECC1A8D81DA", hash_generated_field = "5577E36B751431D0650DCAB0614F5191")

    public static final int STAR = (int) '*';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "FB21676A9E64A5285C1D1A6B1E11821A", hash_generated_field = "231FAE26C0C2B9FBC64DCFC753F1AC1B")

    public static final int DOLLAR = (int) '$';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "639734FDFFFDB1045E467E778CA47E92", hash_generated_field = "C62A528B6CDE9BA9CC913A79EC1A48BA")

    public static final int PLUS = (int) '+';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "8F64723D950A98135D932BF85ED552D6", hash_generated_field = "4B930043CB5FB0157482480B46607D54")

    public static final int POUND = (int) '#';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "60A935DDA1D4D1FC920825BBE9AD3967", hash_generated_field = "2A069EBC792AD71EBEEF3ED900453580")

    public static final int MINUS = (int) '-';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "2997360C2592DECAC45E67F168675859", hash_generated_field = "698ADD1884DA7FE94B15F67D55E1FCDA")

    public static final int DOUBLEQUOTE = (int) '\"';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "D3CAB47DAD619EC2066E7A17B08085D8", hash_generated_field = "292F6240589161556EC3428CE3789C07")

    public static final int TILDE = (int) '~';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "06FE865DAC48273E0D30B35FB9574A15", hash_generated_field = "4891B8D8EDA80AEA9A9D9833D5CE8769")

    public static final int BACK_QUOTE = (int) '`';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "BDC94DF62ED4DBADC431CA620E58A0E3", hash_generated_field = "6F22E0D1261A966DAEE18D177D7331F8")

    public static final int NULL = (int) '\0';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "95202F5E42E363A640E15A267FB3485C", hash_generated_field = "94F502FA8271B6C9F53A58E364FD31A0")

    public static final int EQUALS = (int) '=';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "9BEB907FD2E6587529AD2C25FB6D663E", hash_generated_field = "3B7D3591D25BBAA77F0237477D39C2A8")

    public static final int SEMICOLON = (int) ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "B95BAAF4E11E7CD22040F2A50C3E6F4A", hash_generated_field = "4296368DF34F2F6EE376EFA924B0864B")

    public static final int SLASH = (int) '/';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "4633B1C3218683401759608C7A3491BC", hash_generated_field = "4C993680785AFCD43E6BC94D781CB373")

    public static final int L_SQUARE_BRACKET = (int) '[';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "2B537F63F65B55BF45FDD45E1B10291F", hash_generated_field = "D6D5110A208194AF7B1EC486B63405DD")

    public static final int R_SQUARE_BRACKET = (int) ']';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "3AF47DE7A0EA5F5D9680D66195B3C048", hash_generated_field = "A1E2A4AF20AABBE655EBFE36649C9595")

    public static final int R_CURLY = (int) '}';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "8A15FAC2DB530359A3730FF8F82A5CD6", hash_generated_field = "6D77C6B80D66382592FDE34848F4C1FF")

    public static final int L_CURLY = (int) '{';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "BB22EC4153DCA2A75B45CC62C32AED22", hash_generated_field = "763AD424A9EB120D14D6402087824468")

    public static final int HAT = (int) '^';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.501 -0400", hash_original_field = "86359D9D43ADF12190BB0F22F3A8211A", hash_generated_field = "E4EEAF80F73B9E93D9CF6DEED4993BAE")

    public static final int BAR = (int) '|';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "2B05C3EFB51DE9AE8B52E25FF84979A6", hash_generated_field = "09D2F8A6FE8AA7284E3E06A6C6C606EF")

    public static final int DOT = (int) '.';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "60492EC0D9978B2FEBE79AAC26AEB785", hash_generated_field = "45631F45802F5CBBB666B8BF83AB239B")

    public static final int EXCLAMATION = (int) '!';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "B6DD371B5C053CBC61DAECD2E866C0F3", hash_generated_field = "F2FC2CAE354F85A66D31202E3AFC6343")

    public static final int LPAREN = (int) '(';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "16F9EE492B04EEC96841CDC898ABFC58", hash_generated_field = "E7AE3F587B3D4886E7DB9CFDDC53E2EA")

    public static final int RPAREN = (int) ')';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "FC386E7F83638266966F4988C7DA71A1", hash_generated_field = "65D1F17C93E1F09812E4B69F43BE3B23")

    public static final int GREATER_THAN = (int) '>';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "7A9C3B20ACB2AA5CF6BB8BF6FC7B6DD2", hash_generated_field = "9205B2F85DE81720CBD2E7916081200F")

    public static final int LESS_THAN = (int) '<';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "80F7AB32F26C12B891C528D54015D4CC", hash_generated_field = "36822253DE16D15C507CA4AD98B0D4AF")

    public static final int PERCENT = (int) '%';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "D49343D49E879CC1DB9DA9184C150067", hash_generated_field = "C59D2238695EF14FB400F2DEBCEFB200")

    public static final int QUESTION = (int) '?';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "4FAA412D23BC6BBEFFE744E3077105FB", hash_generated_field = "95AD51D349B8D0A02402803B1A69149C")

    public static final int AND = (int) '&';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "940E6C77EDC9B0432CAB6E5EA71DD3E8", hash_generated_field = "D9C0E3D2A8514389A067E4ACE778BC68")

    public static final int UNDERSCORE = (int) '_';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "5EF8D1EC4592F88FD84C3F9EDC2843B2", hash_generated_field = "9A4439847AD02C063A85CA312E27B5B7")

    protected static Hashtable globalSymbolTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "63E429E4D7FA682FCC2A304EFC9F41AE", hash_generated_field = "94CD673D75FBEC685CA66860DE29769A")

    protected static Hashtable lexerTables;
    static {
        globalSymbolTable = new Hashtable();
        lexerTables = new Hashtable();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "D6C2FADA4E648D6ED587DBD7AB15EEA5", hash_generated_field = "98DA5713B8CB9625620DDB4ECDE10877")

    static final char ALPHA_VALID_CHARS = Character.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "3604F0FAE73F23527368BA3FCFA619FE", hash_generated_field = "A91B938778BCC54CB153A8DC19B91D12")

    static final char DIGIT_VALID_CHARS = Character.MAX_VALUE - 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.502 -0400", hash_original_field = "8E7F1A747D1012C4EE86D23FB14ECEA3", hash_generated_field = "1A8926B139F3055FA0C68CABB3D5FDC9")

    static final char ALPHADIGIT_VALID_CHARS = Character.MAX_VALUE - 2;
}

