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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.245 -0400", hash_original_method = "02D762C7659C29C6C28E615D4F3B4986", hash_generated_method = "A180A25B080D63F54CAEAC34D9A2E288")
    public  URLParser(String url) {
        addTaint(url.getTaint());
        this.lexer = new Lexer("sip_urlLexer", url);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("sip_urlLexer", url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.246 -0400", hash_original_method = "FF384429583BB1654143EB8FA592B141", hash_generated_method = "7313880486DB469022F6906AFC13E663")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.262 -0400", hash_original_method = "8FE92D5DF4A5AF3ADE92B1ED26FEEDBE", hash_generated_method = "02952C9F6C0D44FF8154BCABE90C445F")
    protected String unreserved() throws ParseException {
        char next = lexer.lookAhead(0);
    if(isUnreserved(next))        
        {
            lexer.consume(1);
String varF074B22DABE8C34FEB920DF798AAA748_1287541371 =             String.valueOf(next);
            varF074B22DABE8C34FEB920DF798AAA748_1287541371.addTaint(taint);
            return varF074B22DABE8C34FEB920DF798AAA748_1287541371;
        } //End block
        else
        {
        java.text.ParseException var570A0D3DF59C26893D723CAA8D05F97B_1083425825 = createParseException("unreserved");
        var570A0D3DF59C26893D723CAA8D05F97B_1083425825.addTaint(taint);
        throw var570A0D3DF59C26893D723CAA8D05F97B_1083425825;
        }
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isUnreserved(next)) {
            //lexer.consume(1);
            //return String.valueOf(next);
        //} else
            //throw createParseException("unreserved");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.263 -0400", hash_original_method = "1041AA48D060026BCCD13967429C5BF3", hash_generated_method = "1D0C1C87CEE034938E43057360929CBB")
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
}    if(isValidChar || isUnreserved(next))            
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
String var9A78A74044906F8BA6AB50FB9A7D58A3_330711942 =         lexer.getBuffer().substring(startIdx, lexer.getPtr());
        var9A78A74044906F8BA6AB50FB9A7D58A3_330711942.addTaint(taint);
        return var9A78A74044906F8BA6AB50FB9A7D58A3_330711942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.264 -0400", hash_original_method = "28DEAB6489C56D85C58F2548442629A5", hash_generated_method = "9457526478232538CC61C5B1A818C828")
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
NameValue var540C13E9E156B687226421B24F2DF178_483553725 =             null;
            var540C13E9E156B687226421B24F2DF178_483553725.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_483553725;
            }
            else
            {
NameValue var706F044EA9006DAC45C94A328BE7F814_2095495415 =             new NameValue(pname, pvalue, isFlagParam);
            var706F044EA9006DAC45C94A328BE7F814_2095495415.addTaint(taint);
            return var706F044EA9006DAC45C94A328BE7F814_2095495415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.273 -0400", hash_original_method = "FFA1DEBB1A42288CA22D82A97ACC067B", hash_generated_method = "24643284EBAD731F8E9C4522DE0FDBF4")
    protected String reserved() throws ParseException {
        char next = lexer.lookAhead(0);
    if(isReserved(next))        
        {
            lexer.consume(1);
String var15B8CCCC42482049DA2C2F49F34A1C30_341627523 =             new StringBuffer().append(next).toString();
            var15B8CCCC42482049DA2C2F49F34A1C30_341627523.addTaint(taint);
            return var15B8CCCC42482049DA2C2F49F34A1C30_341627523;
        } //End block
        else
        {
        java.text.ParseException var6F66CA4F7CAB0729A04069D5CD107DC9_1834338874 = createParseException("reserved");
        var6F66CA4F7CAB0729A04069D5CD107DC9_1834338874.addTaint(taint);
        throw var6F66CA4F7CAB0729A04069D5CD107DC9_1834338874;
        }
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isReserved(next)) {
            //lexer.consume(1);
            //return new StringBuffer().append(next).toString();
        //} else
            //throw createParseException("reserved");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.273 -0400", hash_original_method = "B69B97990375B5870393017EB399692B", hash_generated_method = "15E061FA2EA645CB2D528767870EB25C")
    protected boolean isEscaped() {
        try 
        {
            boolean varEEA6DD48A3DA0E4ADE1B19F51E0C371B_2062811890 = (lexer.lookAhead(0) == '%' &&
                Lexer.isHexDigit(lexer.lookAhead(1)) &&
                Lexer.isHexDigit(lexer.lookAhead(2)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636678948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_636678948;
        } //End block
        catch (Exception ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1118854152 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160467913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160467913;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.289 -0400", hash_original_method = "08A77A9FB0F42402334D6E5EC1EEFB98", hash_generated_method = "58398A195860C3EEDFA250E0B273396F")
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
            java.text.ParseException varCF004BCF4311DF9FA131E2EA9EA48A43_590965754 = createParseException("escaped");
            varCF004BCF4311DF9FA131E2EA9EA48A43_590965754.addTaint(taint);
            throw varCF004BCF4311DF9FA131E2EA9EA48A43_590965754;
            }
String var1B324365A764C077A55854483509F4AB_1632180592 =             retval.toString();
            var1B324365A764C077A55854483509F4AB_1632180592.addTaint(taint);
            return var1B324365A764C077A55854483509F4AB_1632180592;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.303 -0400", hash_original_method = "743AFD3B213C469742C3C78020E0DBC1", hash_generated_method = "5E4BE7D7F05FFBBAFDBFC8686E8C0577")
    protected String mark() throws ParseException {
    if(debug)        
        dbg_enter("mark");
        try 
        {
            char next = lexer.lookAhead(0);
    if(isMark(next))            
            {
                lexer.consume(1);
String varFAB99D17BFBD92AB851EE2696C7A7BCB_291641565 =                 new String( new char[]{next} );
                varFAB99D17BFBD92AB851EE2696C7A7BCB_291641565.addTaint(taint);
                return varFAB99D17BFBD92AB851EE2696C7A7BCB_291641565;
            } //End block
            else
            {
            java.text.ParseException var13C1B0A751EC6CB8402885739980C8B0_286194243 = createParseException("mark");
            var13C1B0A751EC6CB8402885739980C8B0_286194243.addTaint(taint);
            throw var13C1B0A751EC6CB8402885739980C8B0_286194243;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.305 -0400", hash_original_method = "589C84A9F2E2E16C04FA96C5BE216A43", hash_generated_method = "7FB84759FD1DF8D7261C6122FB7CD886")
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
String var421459CFA13E4AD4A1F3737B76442AD2_1567154728 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_1567154728.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_1567154728;
                } //End block
                else
    if(isReserved(la))                
                {
                    lexer.consume(1);
String var421459CFA13E4AD4A1F3737B76442AD2_1427985769 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_1427985769.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_1427985769;
                } //End block
                else
    if(isEscaped())                
                {
                    String retval = lexer.charAsString(3);
                    lexer.consume(3);
String varF9E19AD6135C970F387F77C6F3DE4477_1375388339 =                     retval;
                    varF9E19AD6135C970F387F77C6F3DE4477_1375388339.addTaint(taint);
                    return varF9E19AD6135C970F387F77C6F3DE4477_1375388339;
                } //End block
                else
                {
String var540C13E9E156B687226421B24F2DF178_92761320 =                 null;
                var540C13E9E156B687226421B24F2DF178_92761320.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_92761320;
                }
            } //End block
            catch (Exception ex)
            {
String var540C13E9E156B687226421B24F2DF178_42238856 =                 null;
                var540C13E9E156B687226421B24F2DF178_42238856.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_42238856;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.307 -0400", hash_original_method = "C9EA734307D4CD12B7093594DF2E8530", hash_generated_method = "8E7FC0B6BFC77DF23855AAE70780B8D6")
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
String varF9E19AD6135C970F387F77C6F3DE4477_254237621 =                     retval;
                    varF9E19AD6135C970F387F77C6F3DE4477_254237621.addTaint(taint);
                    return varF9E19AD6135C970F387F77C6F3DE4477_254237621;
                } //End block
                else
    if(isUnreserved(la))                
                {
                    lexer.consume(1);
String var421459CFA13E4AD4A1F3737B76442AD2_469635621 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_469635621.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_469635621;
                } //End block
                else
    if(isReservedNoSlash(la))                
                {
                    lexer.consume(1);
String var421459CFA13E4AD4A1F3737B76442AD2_128978944 =                     Lexer.charAsString(la);
                    var421459CFA13E4AD4A1F3737B76442AD2_128978944.addTaint(taint);
                    return var421459CFA13E4AD4A1F3737B76442AD2_128978944;
                } //End block
                else
                {
String var540C13E9E156B687226421B24F2DF178_531169348 =                 null;
                var540C13E9E156B687226421B24F2DF178_531169348.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_531169348;
                }
            } //End block
            catch (ParseException ex)
            {
String var540C13E9E156B687226421B24F2DF178_1379643910 =                 null;
                var540C13E9E156B687226421B24F2DF178_1379643910.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1379643910;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.310 -0400", hash_original_method = "F8BFDE8FCAA82A1A34C46F55D7711C6B", hash_generated_method = "EA51A338A0FC5A07DA5B76C6ACAB5261")
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
String var1B324365A764C077A55854483509F4AB_1521286240 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1521286240.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1521286240;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.343 -0400", hash_original_method = "877793596C03075095766EB10627CE12", hash_generated_method = "2110464F20E41A32B777BD1F6EBC0C97")
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
                java.text.ParseException var9E4F08C133AB477EE15B30CD0B38A389_1306786050 = createParseException("Expecting \':\'");
                var9E4F08C133AB477EE15B30CD0B38A389_1306786050.addTaint(taint);
                throw var9E4F08C133AB477EE15B30CD0B38A389_1306786050;
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
                java.text.ParseException var9E4F08C133AB477EE15B30CD0B38A389_14874185 = createParseException("Expecting \':\'");
                var9E4F08C133AB477EE15B30CD0B38A389_14874185.addTaint(taint);
                throw var9E4F08C133AB477EE15B30CD0B38A389_14874185;
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
                    java.text.ParseException varB8C80F72F95BF6A850D07F4EC5726C09_1132551056 = createParseException(ex.getMessage());
                    varB8C80F72F95BF6A850D07F4EC5726C09_1132551056.addTaint(taint);
                    throw varB8C80F72F95BF6A850D07F4EC5726C09_1132551056;
                } //End block
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("uriReference");
        } //End block
GenericURI varF9E19AD6135C970F387F77C6F3DE4477_1632864379 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1632864379.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1632864379;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.384 -0400", hash_original_method = "FA28BF7ACB321CCE37D931F114A366BD", hash_generated_method = "5E858483E5A1AC9566C4CCBB63846324")
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
                java.text.ParseException varA3EC2660281D70F01A048754213B9CB1_704375310 = createParseException("unexpected " + w);
                varA3EC2660281D70F01A048754213B9CB1_704375310.addTaint(taint);
                throw varA3EC2660281D70F01A048754213B9CB1_704375310;
                }
            } //End block
String varDE99EC39359AC6BE0E416433FFBB9F13_311157545 =             s.toString();
            varDE99EC39359AC6BE0E416433FFBB9F13_311157545.addTaint(taint);
            return varDE99EC39359AC6BE0E416433FFBB9F13_311157545;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.406 -0400", hash_original_method = "0C6D1452631B0ABABC52FCC37CE65FF7", hash_generated_method = "2F72B72C6C35E3113958DCFC44FE0603")
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
                java.text.ParseException var18DBC56885CA74BF8863593259F53DBA_736203408 = createParseException("unexepcted " + la);
                var18DBC56885CA74BF8863593259F53DBA_736203408.addTaint(taint);
                throw var18DBC56885CA74BF8863593259F53DBA_736203408;
                }
            } //End block
String varDE99EC39359AC6BE0E416433FFBB9F13_419087727 =             s.toString();
            varDE99EC39359AC6BE0E416433FFBB9F13_419087727.addTaint(taint);
            return varDE99EC39359AC6BE0E416433FFBB9F13_419087727;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("local_number");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.434 -0400", hash_original_method = "DEDDF1126FB4D34419E3541D3DE0EAF4", hash_generated_method = "419F63A1541CE8E1818BEDE6131B00D2")
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
            java.text.ParseException var068409E4232E3F54EE46F9EEEFA4C17A_1032012870 = createParseException("unexpected char " + c);
            var068409E4232E3F54EE46F9EEEFA4C17A_1032012870.addTaint(taint);
            throw var068409E4232E3F54EE46F9EEEFA4C17A_1032012870;
            }
TelephoneNumber varC1D4D5C1C91533F312FAF0BF887574CF_446050238 =             tn;
            varC1D4D5C1C91533F312FAF0BF887574CF_446050238.addTaint(taint);
            return varC1D4D5C1C91533F312FAF0BF887574CF_446050238;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.436 -0400", hash_original_method = "0F1ADEC60659CEA5C84BABEF7D06F081", hash_generated_method = "996B57E0F9B0EF2BDDBED5B7539DCDE9")
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
TelephoneNumber varC1D4D5C1C91533F312FAF0BF887574CF_191651483 =             tn;
            varC1D4D5C1C91533F312FAF0BF887574CF_191651483.addTaint(taint);
            return varC1D4D5C1C91533F312FAF0BF887574CF_191651483;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.437 -0400", hash_original_method = "883FF19CD75AFF340396001C616EFCAA", hash_generated_method = "1B7E174987FB804C48B7576DF8539BE6")
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
TelephoneNumber varC1D4D5C1C91533F312FAF0BF887574CF_734194560 =         tn;
        varC1D4D5C1C91533F312FAF0BF887574CF_734194560.addTaint(taint);
        return varC1D4D5C1C91533F312FAF0BF887574CF_734194560;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.440 -0400", hash_original_method = "F5BCCE1D5E357F2A71ACB92ADA6046C2", hash_generated_method = "44F87AB743112EAFBDD859D63CE668CB")
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
NameValueList var6DFD9DB88C9F14F93E00B2BFA73F7706_1694558310 =                 nvList;
                var6DFD9DB88C9F14F93E00B2BFA73F7706_1694558310.addTaint(taint);
                return var6DFD9DB88C9F14F93E00B2BFA73F7706_1694558310;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.441 -0400", hash_original_method = "4B2DA37312785E9B10734C6846FECD1E", hash_generated_method = "57386D544FC0B019DD13C3545769203A")
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
            ParseException var56A9EB0A9826019A67827CD993695C48_2015683296 = new ParseException( "Invalid phone-context:" + la , -1 );
            var56A9EB0A9826019A67827CD993695C48_2015683296.addTaint(taint);
            throw var56A9EB0A9826019A67827CD993695C48_2015683296;
        } //End block
NameValue var4ADDE443C97C638732822930C3F06B26_1163310782 =         new NameValue( "phone-context", value, false );
        var4ADDE443C97C638732822930C3F06B26_1163310782.addTaint(taint);
        return var4ADDE443C97C638732822930C3F06B26_1163310782;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.442 -0400", hash_original_method = "73C5F5A1DB2F1724F7BD39D759918D7C", hash_generated_method = "1AFDADED254103D0CD308C04F4D37328")
    public TelURLImpl telURL( boolean inBrackets ) throws ParseException {
        addTaint(inBrackets);
        lexer.match(TokenTypes.TEL);
        lexer.match(':');
        TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        TelURLImpl telUrl = new TelURLImpl();
        telUrl.setTelephoneNumber(tn);
TelURLImpl varAED221150EF42577B2F716DF972053BA_335624282 =         telUrl;
        varAED221150EF42577B2F716DF972053BA_335624282.addTaint(taint);
        return varAED221150EF42577B2F716DF972053BA_335624282;
        // ---------- Original Method ----------
        //lexer.match(TokenTypes.TEL);
        //lexer.match(':');
        //TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        //TelURLImpl telUrl = new TelURLImpl();
        //telUrl.setTelephoneNumber(tn);
        //return telUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.443 -0400", hash_original_method = "7278F7A930851B1FF266754B78180AE2", hash_generated_method = "B1AC40A08D9F3B3302C59F054F5C525E")
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
SipUri varF9E19AD6135C970F387F77C6F3DE4477_1163710353 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1163710353.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1163710353;
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("sipURL");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.444 -0400", hash_original_method = "A1AFDB81F6A99AEF965D53D1558A830F", hash_generated_method = "515B513651E7D12057567205D7345075")
    public String peekScheme() throws ParseException {
        Token[] tokens = lexer.peekNextToken(1);
    if(tokens.length == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_150336481 =         null;
        var540C13E9E156B687226421B24F2DF178_150336481.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_150336481;
        }
        String scheme = ((Token) tokens[0]).getTokenValue();
String varFD3305CF8340E40F0AC0AB554909AEBC_989773979 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_989773979.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_989773979;
        // ---------- Original Method ----------
        //Token[] tokens = lexer.peekNextToken(1);
        //if (tokens.length == 0)
            //return null;
        //String scheme = ((Token) tokens[0]).getTokenValue();
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.444 -0400", hash_original_method = "8CC59A12163BED34BD1BF794F4FF4839", hash_generated_method = "2A26BCCF96E160FA6D4A581576CF36CD")
    protected NameValue qheader() throws ParseException {
        String name = lexer.getNextToken('=');
        lexer.consume(1);
        String value = hvalue();
NameValue var490BC75DB78FF72329C5E669FB8E80F5_1571555057 =         new NameValue(name, value, false);
        var490BC75DB78FF72329C5E669FB8E80F5_1571555057.addTaint(taint);
        return var490BC75DB78FF72329C5E669FB8E80F5_1571555057;
        // ---------- Original Method ----------
        //String name = lexer.getNextToken('=');
        //lexer.consume(1);
        //String value = hvalue();
        //return new NameValue(name, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.445 -0400", hash_original_method = "44D1D496E84DF1E5395D6148A081CABE", hash_generated_method = "6141AE2EB645265F231658B735B2A738")
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
}    if(isValidChar || Lexer.isAlphaDigit(la))            
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
String var1B324365A764C077A55854483509F4AB_1311301082 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1311301082.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1311301082;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.446 -0400", hash_original_method = "ECAD9C42756FF84B730590BF5F3636AE", hash_generated_method = "FE766ACB20ACBEE0B3DCC89F88FB4C41")
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
String var1B324365A764C077A55854483509F4AB_750384469 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_750384469.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_750384469;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.447 -0400", hash_original_method = "9AA60F60D9528CA4DF3AB8B29A4A0237", hash_generated_method = "244F559F21A496E3DE0CA31DF6233C0D")
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
String var9A78A74044906F8BA6AB50FB9A7D58A3_1271485431 =             lexer.getBuffer().substring(startIdx, lexer.getPtr());
            var9A78A74044906F8BA6AB50FB9A7D58A3_1271485431.addTaint(taint);
            return var9A78A74044906F8BA6AB50FB9A7D58A3_1271485431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.449 -0400", hash_original_method = "763B089E3F9716D78CD9674F5B515450", hash_generated_method = "392049B8D3B2B6161E0DDD5CD6DE2669")
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
}    if(isValidChar || isUnreserved(la))            
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
String var9A78A74044906F8BA6AB50FB9A7D58A3_1200809812 =         lexer.getBuffer().substring(startIdx, lexer.getPtr());
        var9A78A74044906F8BA6AB50FB9A7D58A3_1200809812.addTaint(taint);
        return var9A78A74044906F8BA6AB50FB9A7D58A3_1200809812;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:42.449 -0400", hash_original_method = "A2F63CC3A1AD0DF2925153B5F3ECB644", hash_generated_method = "FFF78CBED25A5DF059D48E623D51E5C6")
    public GenericURI parse() throws ParseException {
GenericURI varAA7B0A69EFD6E6C1F0AECD215B234D62_247192021 =         uriReference( true );
        varAA7B0A69EFD6E6C1F0AECD215B234D62_247192021.addTaint(taint);
        return varAA7B0A69EFD6E6C1F0AECD215B234D62_247192021;
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

