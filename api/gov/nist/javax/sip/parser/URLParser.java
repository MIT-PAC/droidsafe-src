package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.HostNameParser;
import gov.nist.core.HostPort;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.core.Token;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.address.SipUri;
import gov.nist.javax.sip.address.TelURLImpl;
import gov.nist.javax.sip.address.TelephoneNumber;
import java.text.ParseException;

public class URLParser extends Parser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.223 -0400", hash_original_method = "02D762C7659C29C6C28E615D4F3B4986", hash_generated_method = "A180A25B080D63F54CAEAC34D9A2E288")
    public  URLParser(String url) {
        addTaint(url.getTaint());
        this.lexer = new Lexer("sip_urlLexer", url);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("sip_urlLexer", url);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.223 -0400", hash_original_method = "FF384429583BB1654143EB8FA592B141", hash_generated_method = "7313880486DB469022F6906AFC13E663")
    public  URLParser(Lexer lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        this.lexer.selectLexer("sip_urlLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("sip_urlLexer");
    }

    
    @DSModeled(DSC.SAFE)
    protected static boolean isMark(char next) {
        switch (next) {
            case '-':
            case '_':
            case '.':
            case '!':
            case '~':
            case '*':
            case '\'':
            case '(':
            case ')':
                return true;
            default:
                return false;
        }
    }

    
    @DSModeled(DSC.SAFE)
    protected static boolean isUnreserved(char next) {
        return Lexer.isAlphaDigit(next) || isMark(next);
    }

    
    @DSModeled(DSC.SAFE)
    protected static boolean isReservedNoSlash(char next) {
        switch (next) {
            case ';':
            case '?':
            case ':':
            case '@':
            case '&':
            case '+':
            case '$':
            case ',':
                return true;
            default:
                return false;
        }
    }

    
    @DSModeled(DSC.SAFE)
    protected static boolean isUserUnreserved(char la) {
        switch (la) {
            case '&':
            case '?':
            case '+':
            case '$':
            case '#':
            case '/':
            case ',':
            case ';':
            case '=':
                return true;
            default:
                return false;
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.232 -0400", hash_original_method = "8FE92D5DF4A5AF3ADE92B1ED26FEEDBE", hash_generated_method = "06DC8BC1991473FF9D0462A1EEEC1656")
    protected String unreserved() throws ParseException {
        char next = lexer.lookAhead(0);
        if(isUnreserved(next))        
        {
            lexer.consume(1);
String varF074B22DABE8C34FEB920DF798AAA748_477964669 =             String.valueOf(next);
            varF074B22DABE8C34FEB920DF798AAA748_477964669.addTaint(taint);
            return varF074B22DABE8C34FEB920DF798AAA748_477964669;
        } //End block
        else
        {
        java.text.ParseException var570A0D3DF59C26893D723CAA8D05F97B_300721992 = createParseException("unreserved");
        var570A0D3DF59C26893D723CAA8D05F97B_300721992.addTaint(taint);
        throw var570A0D3DF59C26893D723CAA8D05F97B_300721992;
        }
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isUnreserved(next)) {
            //lexer.consume(1);
            //return String.valueOf(next);
        //} else
            //throw createParseException("unreserved");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.233 -0400", hash_original_method = "1041AA48D060026BCCD13967429C5BF3", hash_generated_method = "1EC3134EC950C832CD26D3A3F3EE8337")
    protected String paramNameOrValue() throws ParseException {
        int startIdx = lexer.getPtr();
        while
(lexer.hasMoreChars())        
        {
            char next = lexer.lookAhead(0);
            boolean isValidChar = false;
switch(next){
            case '[':
            case ']':
            case '/':
            case ':':
            case '&':
            case '+':
            case '$':
            isValidChar = true;
}            if(isValidChar || isUnreserved(next))            
            {
                lexer.consume(1);
            } //End block
            else
            if(isEscaped())            
            {
                lexer.consume(3);
            } //End block
            else
            break;
        } //End block
String var9A78A74044906F8BA6AB50FB9A7D58A3_693650322 =         lexer.getBuffer().substring(startIdx, lexer.getPtr());
        var9A78A74044906F8BA6AB50FB9A7D58A3_693650322.addTaint(taint);
        return var9A78A74044906F8BA6AB50FB9A7D58A3_693650322;
        // ---------- Original Method ----------
        //int startIdx = lexer.getPtr();
        //while (lexer.hasMoreChars()) {
            //char next = lexer.lookAhead(0);
            //boolean isValidChar = false;
            //switch (next) {
                //case '[':
                //case ']':
                //case '/':
                //case ':':
                //case '&':
                //case '+':
                //case '$':
                    //isValidChar = true;
            //}
            //if (isValidChar || isUnreserved(next)) {
                //lexer.consume(1);
            //} else if (isEscaped()) {
                //lexer.consume(3);
            //} else
                //break;
        //}
        //return lexer.getBuffer().substring(startIdx, lexer.getPtr());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.234 -0400", hash_original_method = "28DEAB6489C56D85C58F2548442629A5", hash_generated_method = "D7CA72A0241B168CF9B76F559DB866D3")
    private NameValue uriParam() throws ParseException {
        if(debug)        
        dbg_enter("uriParam");
        try 
        {
            String pvalue = "";
            String pname = paramNameOrValue();
            char next = lexer.lookAhead(0);
            boolean isFlagParam = true;
            if(next == '=')            
            {
                lexer.consume(1);
                pvalue = paramNameOrValue();
                isFlagParam = false;
            } //End block
            if(pname.length() == 0 &&
                ( pvalue == null ||
                pvalue.length() == 0))            
            {
NameValue var540C13E9E156B687226421B24F2DF178_552683865 =             null;
            var540C13E9E156B687226421B24F2DF178_552683865.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_552683865;
            }
            else
            {
NameValue var706F044EA9006DAC45C94A328BE7F814_1490816405 =             new NameValue(pname, pvalue, isFlagParam);
            var706F044EA9006DAC45C94A328BE7F814_1490816405.addTaint(taint);
            return var706F044EA9006DAC45C94A328BE7F814_1490816405;
            }
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("uriParam");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("uriParam");
        //try {
            //String pvalue = "";
            //String pname = paramNameOrValue();
            //char next = lexer.lookAhead(0);
            //boolean isFlagParam = true;
            //if (next == '=') {
                //lexer.consume(1);
                //pvalue = paramNameOrValue();
                //isFlagParam = false;
            //}
            //if (pname.length() == 0 &&
                //( pvalue == null ||
                //pvalue.length() == 0))
                //return null;
            //else return new NameValue(pname, pvalue, isFlagParam);
        //} finally {
            //if (debug)
                //dbg_leave("uriParam");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    protected static boolean isReserved(char next) {
        switch (next) {
            case ';':
            case '/':
            case '?':
            case ':':
            case '=': 
            case '@':
            case '&':
            case '+':
            case '$':
            case ',':
                return true;
            default:
                return false;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.243 -0400", hash_original_method = "FFA1DEBB1A42288CA22D82A97ACC067B", hash_generated_method = "07C878352CD410D77DBBA977A66476AF")
    protected String reserved() throws ParseException {
        char next = lexer.lookAhead(0);
        if(isReserved(next))        
        {
            lexer.consume(1);
String var15B8CCCC42482049DA2C2F49F34A1C30_1362384529 =             new StringBuffer().append(next).toString();
            var15B8CCCC42482049DA2C2F49F34A1C30_1362384529.addTaint(taint);
            return var15B8CCCC42482049DA2C2F49F34A1C30_1362384529;
        } //End block
        else
        {
        java.text.ParseException var6F66CA4F7CAB0729A04069D5CD107DC9_1132916800 = createParseException("reserved");
        var6F66CA4F7CAB0729A04069D5CD107DC9_1132916800.addTaint(taint);
        throw var6F66CA4F7CAB0729A04069D5CD107DC9_1132916800;
        }
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isReserved(next)) {
            //lexer.consume(1);
            //return new StringBuffer().append(next).toString();
        //} else
            //throw createParseException("reserved");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.244 -0400", hash_original_method = "B69B97990375B5870393017EB399692B", hash_generated_method = "4DCF75BEEBB554CF87F24BCAA3BFE794")
    protected boolean isEscaped() {
        try 
        {
            boolean varEEA6DD48A3DA0E4ADE1B19F51E0C371B_1940996719 = (lexer.lookAhead(0) == '%' &&
                Lexer.isHexDigit(lexer.lookAhead(1)) &&
                Lexer.isHexDigit(lexer.lookAhead(2)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156160265 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_156160265;
        } //End block
        catch (Exception ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1441097590 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_398679867 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_398679867;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return lexer.lookAhead(0) == '%' &&
                //Lexer.isHexDigit(lexer.lookAhead(1)) &&
                //Lexer.isHexDigit(lexer.lookAhead(2));
        //} catch (Exception ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.266 -0400", hash_original_method = "08A77A9FB0F42402334D6E5EC1EEFB98", hash_generated_method = "63F325503701694FB771CC6454F39763")
    protected String escaped() throws ParseException {
        if(debug)        
        dbg_enter("escaped");
        try 
        {
            StringBuffer retval = new StringBuffer();
            char next = lexer.lookAhead(0);
            char next1 = lexer.lookAhead(1);
            char next2 = lexer.lookAhead(2);
            if(next == '%'
                && Lexer.isHexDigit(next1)
                && Lexer.isHexDigit(next2))            
            {
                lexer.consume(3);
                retval.append(next);
                retval.append(next1);
                retval.append(next2);
            } //End block
            else
            {
            java.text.ParseException varCF004BCF4311DF9FA131E2EA9EA48A43_1944487509 = createParseException("escaped");
            varCF004BCF4311DF9FA131E2EA9EA48A43_1944487509.addTaint(taint);
            throw varCF004BCF4311DF9FA131E2EA9EA48A43_1944487509;
            }
String var1B324365A764C077A55854483509F4AB_807636128 =             retval.toString();
            var1B324365A764C077A55854483509F4AB_807636128.addTaint(taint);
            return var1B324365A764C077A55854483509F4AB_807636128;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("escaped");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("escaped");
        //try {
            //StringBuffer retval = new StringBuffer();
            //char next = lexer.lookAhead(0);
            //char next1 = lexer.lookAhead(1);
            //char next2 = lexer.lookAhead(2);
            //if (next == '%'
                //&& Lexer.isHexDigit(next1)
                //&& Lexer.isHexDigit(next2)) {
                //lexer.consume(3);
                //retval.append(next);
                //retval.append(next1);
                //retval.append(next2);
            //} else
                //throw createParseException("escaped");
            //return retval.toString();
        //} finally {
            //if (debug)
                //dbg_leave("escaped");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.287 -0400", hash_original_method = "743AFD3B213C469742C3C78020E0DBC1", hash_generated_method = "16934D3B8949885A04A46F0B4B8725DA")
    protected String mark() throws ParseException {
        if(debug)        
        dbg_enter("mark");
        try 
        {
            char next = lexer.lookAhead(0);
            if(isMark(next))            
            {
                lexer.consume(1);
String varFAB99D17BFBD92AB851EE2696C7A7BCB_1764854973 =                 new String( new char[]{next} );
                varFAB99D17BFBD92AB851EE2696C7A7BCB_1764854973.addTaint(taint);
                return varFAB99D17BFBD92AB851EE2696C7A7BCB_1764854973;
            } //End block
            else
            {
            java.text.ParseException var13C1B0A751EC6CB8402885739980C8B0_1025159999 = createParseException("mark");
            var13C1B0A751EC6CB8402885739980C8B0_1025159999.addTaint(taint);
            throw var13C1B0A751EC6CB8402885739980C8B0_1025159999;
            }
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("mark");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("mark");
        //try {
            //char next = lexer.lookAhead(0);
            //if (isMark(next)) {
                //lexer.consume(1);
                //return new String( new char[]{next} );
            //} else
                //throw createParseException("mark");
        //} finally {
            //if (debug)
                //dbg_leave("mark");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.287 -0400", hash_original_method = "589C84A9F2E2E16C04FA96C5BE216A43", hash_generated_method = "D31CED0C0DB55F9D539D6A3517BAD27B")
    protected String uric() {
        if(debug)        
        dbg_enter("uric");
        try 
        {
            try 
            {
                char la = lexer.lookAhead(0);
                if(isUnreserved(la))                
                {
                    lexer.consume(1);
String var421459CFA13E4AD4A1F3737B76442AD2_1865487242 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_1865487242.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_1865487242;
                } //End block
                else
                if(isReserved(la))                
                {
                    lexer.consume(1);
String var421459CFA13E4AD4A1F3737B76442AD2_1367187207 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_1367187207.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_1367187207;
                } //End block
                else
                if(isEscaped())                
                {
                    String retval = lexer.charAsString(3);
                    lexer.consume(3);
String varF9E19AD6135C970F387F77C6F3DE4477_1072761592 =                     retval;
                    varF9E19AD6135C970F387F77C6F3DE4477_1072761592.addTaint(taint);
                    return varF9E19AD6135C970F387F77C6F3DE4477_1072761592;
                } //End block
                else
                {
String var540C13E9E156B687226421B24F2DF178_672665786 =                 null;
                var540C13E9E156B687226421B24F2DF178_672665786.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_672665786;
                }
            } //End block
            catch (Exception ex)
            {
String var540C13E9E156B687226421B24F2DF178_745023102 =                 null;
                var540C13E9E156B687226421B24F2DF178_745023102.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_745023102;
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("uric");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("uric");
        //try {
            //try {
                //char la = lexer.lookAhead(0);
                //if (isUnreserved(la)) {
                    //lexer.consume(1);
                    //return Lexer.charAsString(la);
                //} else if (isReserved(la)) {
                    //lexer.consume(1);
                    //return Lexer.charAsString(la);
                //} else if (isEscaped()) {
                    //String retval = lexer.charAsString(3);
                    //lexer.consume(3);
                    //return retval;
                //} else
                    //return null;
            //} catch (Exception ex) {
                //return null;
            //}
        //} finally {
            //if (debug)
                //dbg_leave("uric");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.289 -0400", hash_original_method = "C9EA734307D4CD12B7093594DF2E8530", hash_generated_method = "FBDAFB58D6A83F57CB16FB957122529B")
    protected String uricNoSlash() {
        if(debug)        
        dbg_enter("uricNoSlash");
        try 
        {
            try 
            {
                char la = lexer.lookAhead(0);
                if(isEscaped())                
                {
                    String retval = lexer.charAsString(3);
                    lexer.consume(3);
String varF9E19AD6135C970F387F77C6F3DE4477_1122485522 =                     retval;
                    varF9E19AD6135C970F387F77C6F3DE4477_1122485522.addTaint(taint);
                    return varF9E19AD6135C970F387F77C6F3DE4477_1122485522;
                } //End block
                else
                if(isUnreserved(la))                
                {
                    lexer.consume(1);
String var421459CFA13E4AD4A1F3737B76442AD2_961606263 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_961606263.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_961606263;
                } //End block
                else
                if(isReservedNoSlash(la))                
                {
                    lexer.consume(1);
String var421459CFA13E4AD4A1F3737B76442AD2_1855448465 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_1855448465.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_1855448465;
                } //End block
                else
                {
String var540C13E9E156B687226421B24F2DF178_229834463 =                 null;
                var540C13E9E156B687226421B24F2DF178_229834463.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_229834463;
                }
            } //End block
            catch (ParseException ex)
            {
String var540C13E9E156B687226421B24F2DF178_1893665915 =                 null;
                var540C13E9E156B687226421B24F2DF178_1893665915.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1893665915;
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("uricNoSlash");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.291 -0400", hash_original_method = "F8BFDE8FCAA82A1A34C46F55D7711C6B", hash_generated_method = "60DC5CC75D0590A94EB8CAB819C7DFD6")
    protected String uricString() throws ParseException {
        StringBuffer retval = new StringBuffer();
        while
(true)        
        {
            String next = uric();
            if(next == null)            
            {
                char la = lexer.lookAhead(0);
                if(la == '[')                
                {
                    HostNameParser hnp = new HostNameParser(this.getLexer());
                    HostPort hp = hnp.hostPort( false );
                    retval.append(hp.toString());
                    continue;
                } //End block
                break;
            } //End block
            retval.append(next);
        } //End block
String var1B324365A764C077A55854483509F4AB_1358234252 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1358234252.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1358234252;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //while (true) {
            //String next = uric();
            //if (next == null) {
                //char la = lexer.lookAhead(0);
                //if ( la == '[' ) {
                    //HostNameParser hnp = new HostNameParser(this.getLexer());
                    //HostPort hp = hnp.hostPort( false );
                    //retval.append(hp.toString());
                    //continue;
                //}
                //break;
            //}
            //retval.append(next);
        //}
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.328 -0400", hash_original_method = "877793596C03075095766EB10627CE12", hash_generated_method = "C2CA449DC1FE1701E2C26C5CB6B4EF80")
    public GenericURI uriReference( boolean inBrackets ) throws ParseException {
        addTaint(inBrackets);
        if(debug)        
        dbg_enter("uriReference");
        GenericURI retval = null;
        Token[] tokens = lexer.peekNextToken(2);
        Token t1 = (Token) tokens[0];
        Token t2 = (Token) tokens[1];
        try 
        {
            if(t1.getTokenType() == TokenTypes.SIP ||
                    t1.getTokenType() == TokenTypes.SIPS)            
            {
                if(t2.getTokenType() == ':')                
                retval = sipURL( inBrackets );
                else
                {
                java.text.ParseException var9E4F08C133AB477EE15B30CD0B38A389_877252025 = createParseException("Expecting \':\'");
                var9E4F08C133AB477EE15B30CD0B38A389_877252025.addTaint(taint);
                throw var9E4F08C133AB477EE15B30CD0B38A389_877252025;
                }
            } //End block
            else
            if(t1.getTokenType() == TokenTypes.TEL)            
            {
                if(t2.getTokenType() == ':')                
                {
                    retval = telURL( inBrackets );
                } //End block
                else
                {
                java.text.ParseException var9E4F08C133AB477EE15B30CD0B38A389_1025948865 = createParseException("Expecting \':\'");
                var9E4F08C133AB477EE15B30CD0B38A389_1025948865.addTaint(taint);
                throw var9E4F08C133AB477EE15B30CD0B38A389_1025948865;
                }
            } //End block
            else
            {
                String urlString = uricString();
                try 
                {
                    retval = new GenericURI(urlString);
                } //End block
                catch (ParseException ex)
                {
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_260502087 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_260502087.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_260502087;
                } //End block
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("uriReference");
        } //End block
GenericURI varF9E19AD6135C970F387F77C6F3DE4477_226862894 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_226862894.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_226862894;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.359 -0400", hash_original_method = "FA28BF7ACB321CCE37D931F114A366BD", hash_generated_method = "8FEAE8ADBD99624C12132D9B8BEDADE9")
    private String base_phone_number() throws ParseException {
        StringBuffer s = new StringBuffer();
        if(debug)        
        dbg_enter("base_phone_number");
        try 
        {
            int lc = 0;
            while
(lexer.hasMoreChars())            
            {
                char w = lexer.lookAhead(0);
                if(Lexer.isDigit(w)
                    || w == '-'
                    || w == '.'
                    || w == '('
                    || w == ')')                
                {
                    lexer.consume(1);
                    s.append(w);
                    lc++;
                } //End block
                else
                if(lc > 0)                
                break;
                else
                {
                java.text.ParseException varA3EC2660281D70F01A048754213B9CB1_1987249708 = createParseException("unexpected " + w);
                varA3EC2660281D70F01A048754213B9CB1_1987249708.addTaint(taint);
                throw varA3EC2660281D70F01A048754213B9CB1_1987249708;
                }
            } //End block
String varDE99EC39359AC6BE0E416433FFBB9F13_1543142773 =             s.toString();
            varDE99EC39359AC6BE0E416433FFBB9F13_1543142773.addTaint(taint);
            return varDE99EC39359AC6BE0E416433FFBB9F13_1543142773;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("base_phone_number");
        } //End block
        // ---------- Original Method ----------
        //StringBuffer s = new StringBuffer();
        //if (debug)
            //dbg_enter("base_phone_number");
        //try {
            //int lc = 0;
            //while (lexer.hasMoreChars()) {
                //char w = lexer.lookAhead(0);
                //if (Lexer.isDigit(w)
                    //|| w == '-'
                    //|| w == '.'
                    //|| w == '('
                    //|| w == ')') {
                    //lexer.consume(1);
                    //s.append(w);
                    //lc++;
                //} else if (lc > 0)
                    //break;
                //else
                    //throw createParseException("unexpected " + w);
            //}
            //return s.toString();
        //} finally {
            //if (debug)
                //dbg_leave("base_phone_number");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.388 -0400", hash_original_method = "0C6D1452631B0ABABC52FCC37CE65FF7", hash_generated_method = "5D2CA8D546FA861DA6188BEBC70281BC")
    private String local_number() throws ParseException {
        StringBuffer s = new StringBuffer();
        if(debug)        
        dbg_enter("local_number");
        try 
        {
            int lc = 0;
            while
(lexer.hasMoreChars())            
            {
                char la = lexer.lookAhead(0);
                if(la == '*'
                    || la == '#'
                    || la == '-'
                    || la == '.'
                    || la == '('
                    || la == ')'
                    || Lexer.isHexDigit(la))                
                {
                    lexer.consume(1);
                    s.append(la);
                    lc++;
                } //End block
                else
                if(lc > 0)                
                break;
                else
                {
                java.text.ParseException var18DBC56885CA74BF8863593259F53DBA_441828812 = createParseException("unexepcted " + la);
                var18DBC56885CA74BF8863593259F53DBA_441828812.addTaint(taint);
                throw var18DBC56885CA74BF8863593259F53DBA_441828812;
                }
            } //End block
String varDE99EC39359AC6BE0E416433FFBB9F13_882999804 =             s.toString();
            varDE99EC39359AC6BE0E416433FFBB9F13_882999804.addTaint(taint);
            return varDE99EC39359AC6BE0E416433FFBB9F13_882999804;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("local_number");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.411 -0400", hash_original_method = "DEDDF1126FB4D34419E3541D3DE0EAF4", hash_generated_method = "9AB8E94B06486754A99FF7A821B19A0D")
    public final TelephoneNumber parseTelephoneNumber( boolean inBrackets ) throws ParseException {
        addTaint(inBrackets);
        TelephoneNumber tn;
        if(debug)        
        dbg_enter("telephone_subscriber");
        lexer.selectLexer("charLexer");
        try 
        {
            char c = lexer.lookAhead(0);
            if(c == '+')            
            tn = global_phone_number( inBrackets );
            else
            if(Lexer.isHexDigit(c)
                    || c == '#'
                    || c == '*'
                    || c == '-'
                    || c == '.'
                    || c == '('
                    || c == ')')            
            {
                tn = local_phone_number( inBrackets );
            } //End block
            else
            {
            java.text.ParseException var068409E4232E3F54EE46F9EEEFA4C17A_1663756042 = createParseException("unexpected char " + c);
            var068409E4232E3F54EE46F9EEEFA4C17A_1663756042.addTaint(taint);
            throw var068409E4232E3F54EE46F9EEEFA4C17A_1663756042;
            }
TelephoneNumber varC1D4D5C1C91533F312FAF0BF887574CF_740685850 =             tn;
            varC1D4D5C1C91533F312FAF0BF887574CF_740685850.addTaint(taint);
            return varC1D4D5C1C91533F312FAF0BF887574CF_740685850;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("telephone_subscriber");
        } //End block
        // ---------- Original Method ----------
        //TelephoneNumber tn;
        //if (debug)
            //dbg_enter("telephone_subscriber");
        //lexer.selectLexer("charLexer");
        //try {
            //char c = lexer.lookAhead(0);
            //if (c == '+')
                //tn = global_phone_number( inBrackets );
            //else if (
                //Lexer.isHexDigit(c)
                    //|| c == '#'
                    //|| c == '*'
                    //|| c == '-'
                    //|| c == '.'
                    //|| c == '('
                    //|| c == ')' ) {
                //tn = local_phone_number( inBrackets );
            //} else
                //throw createParseException("unexpected char " + c);
            //return tn;
        //} finally {
            //if (debug)
                //dbg_leave("telephone_subscriber");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.412 -0400", hash_original_method = "0F1ADEC60659CEA5C84BABEF7D06F081", hash_generated_method = "3619E6713742DB20411BBBD5E2118EBB")
    private final TelephoneNumber global_phone_number( boolean inBrackets ) throws ParseException {
        addTaint(inBrackets);
        if(debug)        
        dbg_enter("global_phone_number");
        try 
        {
            TelephoneNumber tn = new TelephoneNumber();
            tn.setGlobal(true);
            NameValueList nv = null;
            this.lexer.match(PLUS);
            String b = base_phone_number();
            tn.setPhoneNumber(b);
            if(lexer.hasMoreChars())            
            {
                char tok = lexer.lookAhead(0);
                if(tok == ';' && inBrackets)                
                {
                    this.lexer.consume(1);
                    nv = tel_parameters();
                    tn.setParameters(nv);
                } //End block
            } //End block
TelephoneNumber varC1D4D5C1C91533F312FAF0BF887574CF_1715288892 =             tn;
            varC1D4D5C1C91533F312FAF0BF887574CF_1715288892.addTaint(taint);
            return varC1D4D5C1C91533F312FAF0BF887574CF_1715288892;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("global_phone_number");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("global_phone_number");
        //try {
            //TelephoneNumber tn = new TelephoneNumber();
            //tn.setGlobal(true);
            //NameValueList nv = null;
            //this.lexer.match(PLUS);
            //String b = base_phone_number();
            //tn.setPhoneNumber(b);
            //if (lexer.hasMoreChars()) {
                //char tok = lexer.lookAhead(0);
                //if (tok == ';' && inBrackets) {
                    //this.lexer.consume(1);
                    //nv = tel_parameters();
                    //tn.setParameters(nv);
                //}
            //}
            //return tn;
        //} finally {
            //if (debug)
                //dbg_leave("global_phone_number");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.414 -0400", hash_original_method = "883FF19CD75AFF340396001C616EFCAA", hash_generated_method = "545F1A43C9A44115D387793798FD50D2")
    private TelephoneNumber local_phone_number( boolean inBrackets ) throws ParseException {
        addTaint(inBrackets);
        if(debug)        
        dbg_enter("local_phone_number");
        TelephoneNumber tn = new TelephoneNumber();
        tn.setGlobal(false);
        NameValueList nv = null;
        String b = null;
        try 
        {
            b = local_number();
            tn.setPhoneNumber(b);
            if(lexer.hasMoreChars())            
            {
                Token tok = this.lexer.peekNextToken();
switch(tok.getTokenType()){
                case SEMICOLON:
                {
                    if(inBrackets)                    
                    {
                        this.lexer.consume(1);
                        nv = tel_parameters();
                        tn.setParameters(nv);
                    } //End block
                    break;
                } //End block
                default :
                {
                    break;
                } //End block
}
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("local_phone_number");
        } //End block
TelephoneNumber varC1D4D5C1C91533F312FAF0BF887574CF_818095830 =         tn;
        varC1D4D5C1C91533F312FAF0BF887574CF_818095830.addTaint(taint);
        return varC1D4D5C1C91533F312FAF0BF887574CF_818095830;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.415 -0400", hash_original_method = "F5BCCE1D5E357F2A71ACB92ADA6046C2", hash_generated_method = "B4CE6267F3B60340E755BCA985D6F8AB")
    private NameValueList tel_parameters() throws ParseException {
        NameValueList nvList = new NameValueList();
        NameValue nv;
        while
(true)        
        {
            String pname = paramNameOrValue();
            if(pname.equalsIgnoreCase("phone-context"))            
            {
                nv = phone_context();
            } //End block
            else
            {
                if(lexer.lookAhead(0) == '=')                
                {
                    lexer.consume(1);
                    String value = paramNameOrValue();
                    nv = new NameValue( pname, value, false );
                } //End block
                else
                {
                    nv = new NameValue( pname, "", true );
                } //End block
            } //End block
            nvList.set( nv );
            if(lexer.lookAhead(0) == ';')            
            {
                lexer.consume(1);
            } //End block
            else
            {
NameValueList var6DFD9DB88C9F14F93E00B2BFA73F7706_2016449333 =                 nvList;
                var6DFD9DB88C9F14F93E00B2BFA73F7706_2016449333.addTaint(taint);
                return var6DFD9DB88C9F14F93E00B2BFA73F7706_2016449333;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //NameValueList nvList = new NameValueList();
        //NameValue nv;
        //while ( true ) {
            //String pname = paramNameOrValue();
            //if ( pname.equalsIgnoreCase("phone-context")) {
                //nv = phone_context();
            //} else {
                //if (lexer.lookAhead(0) == '=') {
                    //lexer.consume(1);
                    //String value = paramNameOrValue();
                    //nv = new NameValue( pname, value, false );
                //} else {
                    //nv = new NameValue( pname, "", true );
                //}
            //}
            //nvList.set( nv );
            //if ( lexer.lookAhead(0) == ';' ) {
                //lexer.consume(1);
            //} else {
                //return nvList;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.417 -0400", hash_original_method = "4B2DA37312785E9B10734C6846FECD1E", hash_generated_method = "2C2CB78E54004E893EEA03EE9526ED86")
    private NameValue phone_context() throws ParseException {
        lexer.match('=');
        char la = lexer.lookAhead(0);
        Object value;
        if(la=='+')        
        {
            lexer.consume(1);
            value = "+" + base_phone_number();
        } //End block
        else
        if(Lexer.isAlphaDigit(la))        
        {
            Token t = lexer.match( Lexer.ID );
            value = t.getTokenValue();
        } //End block
        else
        {
            ParseException var56A9EB0A9826019A67827CD993695C48_348024763 = new ParseException( "Invalid phone-context:" + la , -1 );
            var56A9EB0A9826019A67827CD993695C48_348024763.addTaint(taint);
            throw var56A9EB0A9826019A67827CD993695C48_348024763;
        } //End block
NameValue var4ADDE443C97C638732822930C3F06B26_850228824 =         new NameValue( "phone-context", value, false );
        var4ADDE443C97C638732822930C3F06B26_850228824.addTaint(taint);
        return var4ADDE443C97C638732822930C3F06B26_850228824;
        // ---------- Original Method ----------
        //lexer.match('=');
        //char la = lexer.lookAhead(0);
        //Object value;
        //if (la=='+') {
            //lexer.consume(1);
            //value = "+" + base_phone_number();
        //} else if ( Lexer.isAlphaDigit(la) ) {
            //Token t = lexer.match( Lexer.ID );
            //value = t.getTokenValue();
        //} else {
            //throw new ParseException( "Invalid phone-context:" + la , -1 );
        //}
        //return new NameValue( "phone-context", value, false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.418 -0400", hash_original_method = "73C5F5A1DB2F1724F7BD39D759918D7C", hash_generated_method = "28C98224183E30B81DBB4D1468BBBA9C")
    public TelURLImpl telURL( boolean inBrackets ) throws ParseException {
        addTaint(inBrackets);
        lexer.match(TokenTypes.TEL);
        lexer.match(':');
        TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        TelURLImpl telUrl = new TelURLImpl();
        telUrl.setTelephoneNumber(tn);
TelURLImpl varAED221150EF42577B2F716DF972053BA_603117004 =         telUrl;
        varAED221150EF42577B2F716DF972053BA_603117004.addTaint(taint);
        return varAED221150EF42577B2F716DF972053BA_603117004;
        // ---------- Original Method ----------
        //lexer.match(TokenTypes.TEL);
        //lexer.match(':');
        //TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        //TelURLImpl telUrl = new TelURLImpl();
        //telUrl.setTelephoneNumber(tn);
        //return telUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.419 -0400", hash_original_method = "7278F7A930851B1FF266754B78180AE2", hash_generated_method = "C08D7A57E3BF4BB5BEA0ED4AE2D3FC5C")
    public SipUri sipURL( boolean inBrackets ) throws ParseException {
        addTaint(inBrackets);
        if(debug)        
        dbg_enter("sipURL");
        SipUri retval = new SipUri();
        Token nextToken = lexer.peekNextToken();
        int sipOrSips = TokenTypes.SIP;
        String scheme = TokenNames.SIP;
        if(nextToken.getTokenType() == TokenTypes.SIPS)        
        {
            sipOrSips = TokenTypes.SIPS;
            scheme = TokenNames.SIPS;
        } //End block
        try 
        {
            lexer.match(sipOrSips);
            lexer.match(':');
            retval.setScheme(scheme);
            int startOfUser = lexer.markInputPosition();
            String userOrHost = user();
            String passOrPort = null;
            if(lexer.lookAhead() == ':')            
            {
                lexer.consume(1);
                passOrPort = password();
            } //End block
            if(lexer.lookAhead() == '@')            
            {
                lexer.consume(1);
                retval.setUser( userOrHost );
                if(passOrPort!=null)                
                retval.setUserPassword( passOrPort );
            } //End block
            else
            {
                lexer.rewindInputPosition( startOfUser );
            } //End block
            HostNameParser hnp = new HostNameParser(this.getLexer());
            HostPort hp = hnp.hostPort( false );
            retval.setHostPort(hp);
            lexer.selectLexer("charLexer");
            while
(lexer.hasMoreChars())            
            {
                if(lexer.lookAhead(0) != ';' || !inBrackets)                
                break;
                lexer.consume(1);
                NameValue parms = uriParam();
                if(parms != null)                
                retval.setUriParameter(parms);
            } //End block
            if(lexer.hasMoreChars() && lexer.lookAhead(0) == '?')            
            {
                lexer.consume(1);
                while
(lexer.hasMoreChars())                
                {
                    NameValue parms = qheader();
                    retval.setQHeader(parms);
                    if(lexer.hasMoreChars() && lexer.lookAhead(0) != '&')                    
                    break;
                    else
                    lexer.consume(1);
                } //End block
            } //End block
SipUri varF9E19AD6135C970F387F77C6F3DE4477_1963171598 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1963171598.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1963171598;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("sipURL");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.420 -0400", hash_original_method = "A1AFDB81F6A99AEF965D53D1558A830F", hash_generated_method = "E52D883079B26860E369EE483F18719D")
    public String peekScheme() throws ParseException {
        Token[] tokens = lexer.peekNextToken(1);
        if(tokens.length == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_1870643766 =         null;
        var540C13E9E156B687226421B24F2DF178_1870643766.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1870643766;
        }
        String scheme = ((Token) tokens[0]).getTokenValue();
String varFD3305CF8340E40F0AC0AB554909AEBC_1865896343 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_1865896343.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_1865896343;
        // ---------- Original Method ----------
        //Token[] tokens = lexer.peekNextToken(1);
        //if (tokens.length == 0)
            //return null;
        //String scheme = ((Token) tokens[0]).getTokenValue();
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.421 -0400", hash_original_method = "8CC59A12163BED34BD1BF794F4FF4839", hash_generated_method = "2714051089B9965A41E6D7CA3118C624")
    protected NameValue qheader() throws ParseException {
        String name = lexer.getNextToken('=');
        lexer.consume(1);
        String value = hvalue();
NameValue var490BC75DB78FF72329C5E669FB8E80F5_1594517134 =         new NameValue(name, value, false);
        var490BC75DB78FF72329C5E669FB8E80F5_1594517134.addTaint(taint);
        return var490BC75DB78FF72329C5E669FB8E80F5_1594517134;
        // ---------- Original Method ----------
        //String name = lexer.getNextToken('=');
        //lexer.consume(1);
        //String value = hvalue();
        //return new NameValue(name, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.421 -0400", hash_original_method = "44D1D496E84DF1E5395D6148A081CABE", hash_generated_method = "D7558EA8E2C4353FEC0BA330563A302F")
    protected String hvalue() throws ParseException {
        StringBuffer retval = new StringBuffer();
        while
(lexer.hasMoreChars())        
        {
            char la = lexer.lookAhead(0);
            boolean isValidChar = false;
switch(la){
            case '+':
            case '?':
            case ':':
            case '[':
            case ']':
            case '/':
            case '$':
            case '_':
            case '-':
            case '"':
            case '!':
            case '~':
            case '*':
            case '.':
            case '(':
            case ')':
            isValidChar = true;
}            if(isValidChar || Lexer.isAlphaDigit(la))            
            {
                lexer.consume(1);
                retval.append(la);
            } //End block
            else
            if(la == '%')            
            {
                retval.append(escaped());
            } //End block
            else
            break;
        } //End block
String var1B324365A764C077A55854483509F4AB_523597078 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_523597078.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_523597078;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.422 -0400", hash_original_method = "ECAD9C42756FF84B730590BF5F3636AE", hash_generated_method = "E61437E10AFE6944E85DE72ADC65769D")
    protected String urlString() throws ParseException {
        StringBuffer retval = new StringBuffer();
        lexer.selectLexer("charLexer");
        while
(lexer.hasMoreChars())        
        {
            char la = lexer.lookAhead(0);
            if(la == ' '
                || la == '\t'
                || la == '\n'
                || la == '>'
                || la == '<')            
            break;
            lexer.consume(0);
            retval.append(la);
        } //End block
String var1B324365A764C077A55854483509F4AB_1634919649 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1634919649.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1634919649;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //lexer.selectLexer("charLexer");
        //while (lexer.hasMoreChars()) {
            //char la = lexer.lookAhead(0);
            //if (la == ' '
                //|| la == '\t'
                //|| la == '\n'
                //|| la == '>'
                //|| la == '<')
                //break;
            //lexer.consume(0);
            //retval.append(la);
        //}
        //return retval.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.422 -0400", hash_original_method = "9AA60F60D9528CA4DF3AB8B29A4A0237", hash_generated_method = "C877296817052F60A1262957A6E3884B")
    protected String user() throws ParseException {
        if(debug)        
        dbg_enter("user");
        try 
        {
            int startIdx = lexer.getPtr();
            while
(lexer.hasMoreChars())            
            {
                char la = lexer.lookAhead(0);
                if(isUnreserved(la) || isUserUnreserved(la))                
                {
                    lexer.consume(1);
                } //End block
                else
                if(isEscaped())                
                {
                    lexer.consume(3);
                } //End block
                else
                break;
            } //End block
String var9A78A74044906F8BA6AB50FB9A7D58A3_1046496927 =             lexer.getBuffer().substring(startIdx, lexer.getPtr());
            var9A78A74044906F8BA6AB50FB9A7D58A3_1046496927.addTaint(taint);
            return var9A78A74044906F8BA6AB50FB9A7D58A3_1046496927;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("user");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("user");
        //try {
            //int startIdx = lexer.getPtr();
            //while (lexer.hasMoreChars()) {
                //char la = lexer.lookAhead(0);
                //if (isUnreserved(la) || isUserUnreserved(la)) {
                    //lexer.consume(1);
                //} else if (isEscaped()) {
                    //lexer.consume(3);
                //} else
                    //break;
            //}
            //return lexer.getBuffer().substring(startIdx, lexer.getPtr());
        //} finally {
            //if (debug)
                //dbg_leave("user");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.423 -0400", hash_original_method = "763B089E3F9716D78CD9674F5B515450", hash_generated_method = "9B123CBD790A2E3093CF237ED6D622DC")
    protected String password() throws ParseException {
        int startIdx = lexer.getPtr();
        while
(true)        
        {
            char la = lexer.lookAhead(0);
            boolean isValidChar = false;
switch(la){
            case '&':
            case '=':
            case '+':
            case '$':
            case ',':
            isValidChar = true;
}            if(isValidChar || isUnreserved(la))            
            {
                lexer.consume(1);
            } //End block
            else
            if(isEscaped())            
            {
                lexer.consume(3);
            } //End block
            else
            break;
        } //End block
String var9A78A74044906F8BA6AB50FB9A7D58A3_1847833227 =         lexer.getBuffer().substring(startIdx, lexer.getPtr());
        var9A78A74044906F8BA6AB50FB9A7D58A3_1847833227.addTaint(taint);
        return var9A78A74044906F8BA6AB50FB9A7D58A3_1847833227;
        // ---------- Original Method ----------
        //int startIdx = lexer.getPtr();
        //while (true) {
            //char la = lexer.lookAhead(0);
            //boolean isValidChar = false;
            //switch (la) {
                //case '&':
                //case '=':
                //case '+':
                //case '$':
                //case ',':
                    //isValidChar = true;
            //}
            //if (isValidChar || isUnreserved(la)) {
                //lexer.consume(1);
            //} else if (isEscaped()) {
                //lexer.consume(3); 
            //} else
                //break;
        //}
        //return lexer.getBuffer().substring(startIdx, lexer.getPtr());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.424 -0400", hash_original_method = "A2F63CC3A1AD0DF2925153B5F3ECB644", hash_generated_method = "C3B784D81790E333AD31D41BDF991C7D")
    public GenericURI parse() throws ParseException {
GenericURI varAA7B0A69EFD6E6C1F0AECD215B234D62_431677700 =         uriReference( true );
        varAA7B0A69EFD6E6C1F0AECD215B234D62_431677700.addTaint(taint);
        return varAA7B0A69EFD6E6C1F0AECD215B234D62_431677700;
        // ---------- Original Method ----------
        //return uriReference( true );
    }

    
    public static void main(String[] args) throws ParseException {
        String[] test = { "sip:alice@example.com",
                    "sips:alice@examples.com" ,
                    "sip:3Zqkv5dajqaaas0tCjCxT0xH2ZEuEMsFl0xoasip%3A%2B3519116786244%40siplab.domain.com@213.0.115.163:7070"};
        for ( int i = 0; i < test.length; i++)
        {
            URLParser p  = new URLParser(test[i]);
                GenericURI uri = p.parse();
                System.out.println("uri type returned " + uri.getClass().getName());
                System.out.println(test[i] + " is SipUri? " + uri.isSipURI()
                        + ">" + uri.encode());
        }
    }

    
}

