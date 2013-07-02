package gov.nist.javax.sip.parser;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.869 -0400", hash_original_method = "02D762C7659C29C6C28E615D4F3B4986", hash_generated_method = "4050C74595F73B4864EDAB05EDDAE34E")
    public  URLParser(String url) {
        this.lexer = new Lexer("sip_urlLexer", url);
        addTaint(url.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.869 -0400", hash_original_method = "FF384429583BB1654143EB8FA592B141", hash_generated_method = "F0DA21DB293A6090D56A070DB3F88AF5")
    public  URLParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("sip_urlLexer");
        addTaint(lexer.getTaint());
        
        
        
    }

    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.870 -0400", hash_original_method = "8FE92D5DF4A5AF3ADE92B1ED26FEEDBE", hash_generated_method = "A45A4C9587E9434E9EAB698A5F267372")
    protected String unreserved() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1419716217 = null; 
        char next = lexer.lookAhead(0);
        {
            boolean var1389A34E9A875BE3049166D07D13716A_1520927687 = (isUnreserved(next));
            {
                lexer.consume(1);
                varB4EAC82CA7396A68D541C85D26508E83_1419716217 = String.valueOf(next);
            } 
            if (DroidSafeAndroidRuntime.control) throw createParseException("unreserved");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1419716217.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1419716217;
        
        
        
            
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.871 -0400", hash_original_method = "1041AA48D060026BCCD13967429C5BF3", hash_generated_method = "A3EF27C112FA113EAB0D74C1BCB41619")
    protected String paramNameOrValue() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_294772441 = null; 
        int startIdx = lexer.getPtr();
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_1766084107 = (lexer.hasMoreChars());
            {
                char next = lexer.lookAhead(0);
                boolean isValidChar = false;
                
                isValidChar = true;
                
                {
                    boolean varEBB6542C58D63C944BB22BBBEBD45AAF_705924429 = (isValidChar || isUnreserved(next));
                    {
                        lexer.consume(1);
                    } 
                    {
                        boolean varF7C5BA76C493C7F02FA07B27C1AF3316_1251540691 = (isEscaped());
                        {
                            lexer.consume(3);
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_294772441 = lexer.getBuffer().substring(startIdx, lexer.getPtr());
        varB4EAC82CA7396A68D541C85D26508E83_294772441.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_294772441;
        
        
        
            
            
            
                
                
                
                
                
                
                
                    
            
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.873 -0400", hash_original_method = "28DEAB6489C56D85C58F2548442629A5", hash_generated_method = "A98DA96D392069A126C86B4366175AF4")
    private NameValue uriParam() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_866331269 = null; 
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1950796285 = null; 
        dbg_enter("uriParam");
        try 
        {
            String pvalue = "";
            String pname = paramNameOrValue();
            char next = lexer.lookAhead(0);
            boolean isFlagParam = true;
            {
                lexer.consume(1);
                pvalue = paramNameOrValue();
                isFlagParam = false;
            } 
            {
                boolean varA946C0818D54984040C780DFCE924753_1383480572 = (pname.length() == 0 &&
                ( pvalue == null ||
                pvalue.length() == 0));
                varB4EAC82CA7396A68D541C85D26508E83_866331269 = null;
                varB4EAC82CA7396A68D541C85D26508E83_1950796285 = new NameValue(pname, pvalue, isFlagParam);
            } 
        } 
        finally 
        {
            dbg_leave("uriParam");
        } 
        NameValue varA7E53CE21691AB073D9660D615818899_1370363463; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1370363463 = varB4EAC82CA7396A68D541C85D26508E83_866331269;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1370363463 = varB4EAC82CA7396A68D541C85D26508E83_1950796285;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1370363463.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1370363463;
        
        
            
        
            
            
            
            
            
                
                
                
            
            
                
                
                
            
        
            
                
        
    }

    
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.874 -0400", hash_original_method = "FFA1DEBB1A42288CA22D82A97ACC067B", hash_generated_method = "E2F87B172D6D447B7336F7A30FD91633")
    protected String reserved() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_525311873 = null; 
        char next = lexer.lookAhead(0);
        {
            boolean varAE7675CD56F874911E26881E5AAACF61_1635571882 = (isReserved(next));
            {
                lexer.consume(1);
                varB4EAC82CA7396A68D541C85D26508E83_525311873 = new StringBuffer().append(next).toString();
            } 
            if (DroidSafeAndroidRuntime.control) throw createParseException("reserved");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_525311873.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_525311873;
        
        
        
            
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.874 -0400", hash_original_method = "B69B97990375B5870393017EB399692B", hash_generated_method = "AC8E78CB1DFCE1106A4BEB8B06F2EA59")
    protected boolean isEscaped() {
        try 
        {
            boolean var3F9254A4E7823F8753251F2B55C56EF1_2089360006 = (lexer.lookAhead(0) == '%' &&
                Lexer.isHexDigit(lexer.lookAhead(1)) &&
                Lexer.isHexDigit(lexer.lookAhead(2)));
        } 
        catch (Exception ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611686365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611686365;
        
        
            
                
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.875 -0400", hash_original_method = "08A77A9FB0F42402334D6E5EC1EEFB98", hash_generated_method = "9D0C94ADD983C575142837DB3230DED7")
    protected String escaped() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1357336054 = null; 
        dbg_enter("escaped");
        try 
        {
            StringBuffer retval = new StringBuffer();
            char next = lexer.lookAhead(0);
            char next1 = lexer.lookAhead(1);
            char next2 = lexer.lookAhead(2);
            {
                boolean var60B80A984C77CCEA3BBF72B827F48A07_885095848 = (next == '%'
                && Lexer.isHexDigit(next1)
                && Lexer.isHexDigit(next2));
                {
                    lexer.consume(3);
                    retval.append(next);
                    retval.append(next1);
                    retval.append(next2);
                } 
                if (DroidSafeAndroidRuntime.control) throw createParseException("escaped");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1357336054 = retval.toString();
        } 
        finally 
        {
            dbg_leave("escaped");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1357336054.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1357336054;
        
        
            
        
            
            
            
            
            
                
                
                
                
                
                
            
                
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.876 -0400", hash_original_method = "743AFD3B213C469742C3C78020E0DBC1", hash_generated_method = "CD4B534C39E2054F8DA46832BD679179")
    protected String mark() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1727919091 = null; 
        dbg_enter("mark");
        try 
        {
            char next = lexer.lookAhead(0);
            {
                boolean varE0C748D002BB162804157081E5A97AF7_1617001440 = (isMark(next));
                {
                    lexer.consume(1);
                    varB4EAC82CA7396A68D541C85D26508E83_1727919091 = new String( new char[]{next} );
                } 
                if (DroidSafeAndroidRuntime.control) throw createParseException("mark");
            } 
        } 
        finally 
        {
            dbg_leave("mark");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1727919091.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1727919091;
        
        
            
        
            
            
                
                
            
                
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.877 -0400", hash_original_method = "589C84A9F2E2E16C04FA96C5BE216A43", hash_generated_method = "936CD67D5904454A5D2A4532173140D6")
    protected String uric() {
        String varB4EAC82CA7396A68D541C85D26508E83_884364539 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_630094479 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_840565527 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_755437085 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_214688952 = null; 
        dbg_enter("uric");
        try 
        {
            try 
            {
                char la = lexer.lookAhead(0);
                {
                    boolean var4DEDA407E3BC616B4A5AC7CEF8C961B8_1525217601 = (isUnreserved(la));
                    {
                        lexer.consume(1);
                        varB4EAC82CA7396A68D541C85D26508E83_884364539 = Lexer.charAsString(la);
                    } 
                    {
                        boolean var967F4E910D4BCCE057AC7DAD96CB80FB_70299505 = (isReserved(la));
                        {
                            lexer.consume(1);
                            varB4EAC82CA7396A68D541C85D26508E83_630094479 = Lexer.charAsString(la);
                        } 
                        {
                            boolean var7DDEF0E08361E9C02AADC7953802FC99_1704906215 = (isEscaped());
                            {
                                String retval = lexer.charAsString(3);
                                lexer.consume(3);
                                varB4EAC82CA7396A68D541C85D26508E83_840565527 = retval;
                            } 
                            varB4EAC82CA7396A68D541C85D26508E83_755437085 = null;
                        } 
                    } 
                } 
            } 
            catch (Exception ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_214688952 = null;
            } 
        } 
        finally 
        {
            dbg_leave("uric");
        } 
        String varA7E53CE21691AB073D9660D615818899_738481779; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_738481779 = varB4EAC82CA7396A68D541C85D26508E83_884364539;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_738481779 = varB4EAC82CA7396A68D541C85D26508E83_630094479;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_738481779 = varB4EAC82CA7396A68D541C85D26508E83_840565527;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_738481779 = varB4EAC82CA7396A68D541C85D26508E83_755437085;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_738481779 = varB4EAC82CA7396A68D541C85D26508E83_214688952;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_738481779.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_738481779;
        
        
            
        
            
                
                
                    
                    
                
                    
                    
                
                    
                    
                    
                
                    
            
                
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.878 -0400", hash_original_method = "C9EA734307D4CD12B7093594DF2E8530", hash_generated_method = "77C21701BCE71557B0194325A3221790")
    protected String uricNoSlash() {
        String varB4EAC82CA7396A68D541C85D26508E83_1375018648 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1096286121 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1066591979 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1031940164 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1154867675 = null; 
        dbg_enter("uricNoSlash");
        try 
        {
            try 
            {
                char la = lexer.lookAhead(0);
                {
                    boolean varD0BEBBDFA3B284B77894A2ED39B07738_976628169 = (isEscaped());
                    {
                        String retval = lexer.charAsString(3);
                        lexer.consume(3);
                        varB4EAC82CA7396A68D541C85D26508E83_1375018648 = retval;
                    } 
                    {
                        boolean var7C808D9F6303ECB25ED4BAECB34B9B56_1043904450 = (isUnreserved(la));
                        {
                            lexer.consume(1);
                            varB4EAC82CA7396A68D541C85D26508E83_1096286121 = Lexer.charAsString(la);
                        } 
                        {
                            boolean varCAF58582C5F6188CEA5D8F016BCE21F5_1525253192 = (isReservedNoSlash(la));
                            {
                                lexer.consume(1);
                                varB4EAC82CA7396A68D541C85D26508E83_1066591979 = Lexer.charAsString(la);
                            } 
                            varB4EAC82CA7396A68D541C85D26508E83_1031940164 = null;
                        } 
                    } 
                } 
            } 
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1154867675 = null;
            } 
        } 
        finally 
        {
            dbg_leave("uricNoSlash");
        } 
        String varA7E53CE21691AB073D9660D615818899_1309069453; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1309069453 = varB4EAC82CA7396A68D541C85D26508E83_1375018648;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1309069453 = varB4EAC82CA7396A68D541C85D26508E83_1096286121;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1309069453 = varB4EAC82CA7396A68D541C85D26508E83_1066591979;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1309069453 = varB4EAC82CA7396A68D541C85D26508E83_1031940164;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1309069453 = varB4EAC82CA7396A68D541C85D26508E83_1154867675;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1309069453.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1309069453;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.878 -0400", hash_original_method = "F8BFDE8FCAA82A1A34C46F55D7711C6B", hash_generated_method = "773DFFC7B02325E6FBD8BBBCFC11F09F")
    protected String uricString() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_645634710 = null; 
        StringBuffer retval = new StringBuffer();
        {
            String next = uric();
            {
                char la = lexer.lookAhead(0);
                {
                    HostNameParser hnp = new HostNameParser(this.getLexer());
                    HostPort hp = hnp.hostPort( false );
                    retval.append(hp.toString());
                } 
            } 
            retval.append(next);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_645634710 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_645634710.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_645634710;
        
        
        
            
            
                
                
                    
                    
                    
                    
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.879 -0400", hash_original_method = "877793596C03075095766EB10627CE12", hash_generated_method = "CFC951B1D25204E9AF3C6FB6936436CE")
    public GenericURI uriReference( boolean inBrackets ) throws ParseException {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1986268732 = null; 
        dbg_enter("uriReference");
        GenericURI retval = null;
        Token[] tokens = lexer.peekNextToken(2);
        Token t1 = (Token) tokens[0];
        Token t2 = (Token) tokens[1];
        try 
        {
            {
                boolean var3E3C08E681A70CFCD29256F591BA9F85_301930809 = (t1.getTokenType() == TokenTypes.SIP ||
                    t1.getTokenType() == TokenTypes.SIPS);
                {
                    {
                        boolean var19C34D70DBF4E04E87D5E554663CED0B_350589874 = (t2.getTokenType() == ':');
                        retval = sipURL( inBrackets );
                        if (DroidSafeAndroidRuntime.control) throw createParseException("Expecting \':\'");
                    } 
                } 
                {
                    boolean var9DCC9A019F767A37C0CD3E2554D567B2_1839669741 = (t1.getTokenType() == TokenTypes.TEL);
                    {
                        {
                            boolean var6E0AC27A3BCD64EF8F081ACBDDD022E3_251101416 = (t2.getTokenType() == ':');
                            {
                                retval = telURL( inBrackets );
                            } 
                            if (DroidSafeAndroidRuntime.control) throw createParseException("Expecting \':\'");
                        } 
                    } 
                    {
                        String urlString = uricString();
                        try 
                        {
                            retval = new GenericURI(urlString);
                        } 
                        catch (ParseException ex)
                        {
                            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            dbg_leave("uriReference");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1986268732 = retval;
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1986268732.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1986268732;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.880 -0400", hash_original_method = "FA28BF7ACB321CCE37D931F114A366BD", hash_generated_method = "9EB59861587822ED941BA3B4FE3AF8ED")
    private String base_phone_number() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_704006671 = null; 
        StringBuffer s = new StringBuffer();
        dbg_enter("base_phone_number");
        try 
        {
            int lc = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_52841130 = (lexer.hasMoreChars());
                {
                    char w = lexer.lookAhead(0);
                    {
                        boolean var558B9976D373EA13678F300ACFC57D1F_1018766092 = (Lexer.isDigit(w)
                    || w == '-'
                    || w == '.'
                    || w == '('
                    || w == ')');
                        {
                            lexer.consume(1);
                            s.append(w);
                        } 
                        if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected " + w);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_704006671 = s.toString();
        } 
        finally 
        {
            dbg_leave("base_phone_number");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_704006671.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_704006671;
        
        
        
            
        
            
            
                
                
                    
                    
                    
                    
                    
                    
                    
                
                    
                
                    
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.881 -0400", hash_original_method = "0C6D1452631B0ABABC52FCC37CE65FF7", hash_generated_method = "064200ABEB2258A36DCE9EA2162191C4")
    private String local_number() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_956197851 = null; 
        StringBuffer s = new StringBuffer();
        dbg_enter("local_number");
        try 
        {
            int lc = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_773013738 = (lexer.hasMoreChars());
                {
                    char la = lexer.lookAhead(0);
                    {
                        boolean var20C700F69E25677794711EF4694FACAC_1253963166 = (la == '*'
                    || la == '#'
                    || la == '-'
                    || la == '.'
                    || la == '('
                    || la == ')'
                    || Lexer.isHexDigit(la));
                        {
                            lexer.consume(1);
                            s.append(la);
                        } 
                        if (DroidSafeAndroidRuntime.control) throw createParseException("unexepcted " + la);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_956197851 = s.toString();
        } 
        finally 
        {
            dbg_leave("local_number");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_956197851.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_956197851;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.883 -0400", hash_original_method = "DEDDF1126FB4D34419E3541D3DE0EAF4", hash_generated_method = "D8E350BF15C5FF8585843B2E234BC1DC")
    public final TelephoneNumber parseTelephoneNumber( boolean inBrackets ) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_776355097 = null; 
        TelephoneNumber tn;
        dbg_enter("telephone_subscriber");
        lexer.selectLexer("charLexer");
        try 
        {
            char c = lexer.lookAhead(0);
            tn = global_phone_number( inBrackets );
            {
                boolean var507D5F8498D0167D369439A5884A0378_1884560811 = (Lexer.isHexDigit(c)
                    || c == '#'
                    || c == '*'
                    || c == '-'
                    || c == '.'
                    || c == '('
                    || c == ')');
                {
                    tn = local_phone_number( inBrackets );
                } 
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char " + c);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_776355097 = tn;
        } 
        finally 
        {
            dbg_leave("telephone_subscriber");
        } 
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_776355097.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_776355097;
        
        
        
            
        
        
            
            
                
            
                
                    
                    
                    
                    
                    
                    
                
            
                
            
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.885 -0400", hash_original_method = "0F1ADEC60659CEA5C84BABEF7D06F081", hash_generated_method = "D3EC337B20E3FC13A9448BCDB9945841")
    private final TelephoneNumber global_phone_number( boolean inBrackets ) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1374596785 = null; 
        dbg_enter("global_phone_number");
        try 
        {
            TelephoneNumber tn = new TelephoneNumber();
            tn.setGlobal(true);
            NameValueList nv = null;
            this.lexer.match(PLUS);
            String b = base_phone_number();
            tn.setPhoneNumber(b);
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1217237992 = (lexer.hasMoreChars());
                {
                    char tok = lexer.lookAhead(0);
                    {
                        this.lexer.consume(1);
                        nv = tel_parameters();
                        tn.setParameters(nv);
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1374596785 = tn;
        } 
        finally 
        {
            dbg_leave("global_phone_number");
        } 
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1374596785.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1374596785;
        
        
            
        
            
            
            
            
            
            
            
                
                
                    
                    
                    
                
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.886 -0400", hash_original_method = "883FF19CD75AFF340396001C616EFCAA", hash_generated_method = "C80FF05195950B4B4B49B12F71012AA9")
    private TelephoneNumber local_phone_number( boolean inBrackets ) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1038345167 = null; 
        dbg_enter("local_phone_number");
        TelephoneNumber tn = new TelephoneNumber();
        tn.setGlobal(false);
        NameValueList nv = null;
        String b = null;
        try 
        {
            b = local_number();
            tn.setPhoneNumber(b);
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_279882928 = (lexer.hasMoreChars());
                {
                    Token tok = this.lexer.peekNextToken();
                    {
                        Object varD3D97B347F6C533E598B0CFBC725AF99_1332239870 = (tok.getTokenType());
                        
                        {
                            {
                                this.lexer.consume(1);
                                nv = tel_parameters();
                                tn.setParameters(nv);
                            } 
                        } 
                        
                    } 
                } 
            } 
        } 
        finally 
        {
            dbg_leave("local_phone_number");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1038345167 = tn;
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1038345167.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1038345167;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.887 -0400", hash_original_method = "F5BCCE1D5E357F2A71ACB92ADA6046C2", hash_generated_method = "31B74F72D8F0D775F701303F7D60F777")
    private NameValueList tel_parameters() throws ParseException {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1632131556 = null; 
        NameValueList nvList = new NameValueList();
        NameValue nv;
        {
            String pname = paramNameOrValue();
            {
                boolean varC10FDE306D9280D8B230EFFEBE7BBCAD_1271281727 = (pname.equalsIgnoreCase("phone-context"));
                {
                    nv = phone_context();
                } 
                {
                    {
                        boolean var58840CF471CB22F21A5C8437922569C5_1879053044 = (lexer.lookAhead(0) == '=');
                        {
                            lexer.consume(1);
                            String value = paramNameOrValue();
                            nv = new NameValue( pname, value, false );
                        } 
                        {
                            nv = new NameValue( pname, "", true );
                        } 
                    } 
                } 
            } 
            nvList.set( nv );
            {
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_1685223094 = (lexer.lookAhead(0) == ';');
                {
                    lexer.consume(1);
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1632131556 = nvList;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1632131556.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1632131556;
        
        
        
        
            
            
                
            
                
                    
                    
                    
                
                    
                
            
            
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.888 -0400", hash_original_method = "4B2DA37312785E9B10734C6846FECD1E", hash_generated_method = "2D274681C4A13E6218EDBC0CBAAFE305")
    private NameValue phone_context() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_512762003 = null; 
        lexer.match('=');
        char la = lexer.lookAhead(0);
        Object value;
        {
            lexer.consume(1);
            value = "+" + base_phone_number();
        } 
        {
            boolean varCB62C5C9B3FAF6D4CFE708D2749449C5_1791885845 = (Lexer.isAlphaDigit(la));
            {
                Token t = lexer.match( Lexer.ID );
                value = t.getTokenValue();
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException( "Invalid phone-context:" + la , -1 );
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_512762003 = new NameValue( "phone-context", value, false );
        varB4EAC82CA7396A68D541C85D26508E83_512762003.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_512762003;
        
        
        
        
        
            
            
        
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.889 -0400", hash_original_method = "73C5F5A1DB2F1724F7BD39D759918D7C", hash_generated_method = "FEDC6A5BDDA7EA42CD053699C7C86680")
    public TelURLImpl telURL( boolean inBrackets ) throws ParseException {
        TelURLImpl varB4EAC82CA7396A68D541C85D26508E83_506833878 = null; 
        lexer.match(TokenTypes.TEL);
        lexer.match(':');
        TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        TelURLImpl telUrl = new TelURLImpl();
        telUrl.setTelephoneNumber(tn);
        varB4EAC82CA7396A68D541C85D26508E83_506833878 = telUrl;
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_506833878.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_506833878;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.890 -0400", hash_original_method = "7278F7A930851B1FF266754B78180AE2", hash_generated_method = "9B841774313ED45F9F5D174720E54239")
    public SipUri sipURL( boolean inBrackets ) throws ParseException {
        SipUri varB4EAC82CA7396A68D541C85D26508E83_669671367 = null; 
        dbg_enter("sipURL");
        SipUri retval = new SipUri();
        Token nextToken = lexer.peekNextToken();
        int sipOrSips = TokenTypes.SIP;
        String scheme = TokenNames.SIP;
        {
            boolean var428A8649D9DE71F3027322B0FB5BC374_483002703 = (nextToken.getTokenType() == TokenTypes.SIPS);
            {
                sipOrSips = TokenTypes.SIPS;
                scheme = TokenNames.SIPS;
            } 
        } 
        try 
        {
            lexer.match(sipOrSips);
            lexer.match(':');
            retval.setScheme(scheme);
            int startOfUser = lexer.markInputPosition();
            String userOrHost = user();
            String passOrPort = null;
            {
                boolean varA481248E93D84F444CD01FB31AAFDF62_486306514 = (lexer.lookAhead() == ':');
                {
                    lexer.consume(1);
                    passOrPort = password();
                } 
            } 
            {
                boolean var8F99848E84C59D67D6EAE42041875FCD_230278705 = (lexer.lookAhead() == '@');
                {
                    lexer.consume(1);
                    retval.setUser( userOrHost );
                    retval.setUserPassword( passOrPort );
                } 
                {
                    lexer.rewindInputPosition( startOfUser );
                } 
            } 
            HostNameParser hnp = new HostNameParser(this.getLexer());
            HostPort hp = hnp.hostPort( false );
            retval.setHostPort(hp);
            lexer.selectLexer("charLexer");
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_6030972 = (lexer.hasMoreChars());
                {
                    {
                        boolean var586A81C98915AF015E02FB22E05826EF_635372195 = (lexer.lookAhead(0) != ';' || !inBrackets);
                    } 
                    lexer.consume(1);
                    NameValue parms = uriParam();
                    retval.setUriParameter(parms);
                } 
            } 
            {
                boolean var7C875628E08B715321EFB433C7824D95_1735628585 = (lexer.hasMoreChars() && lexer.lookAhead(0) == '?');
                {
                    lexer.consume(1);
                    {
                        boolean var4CB791BD05839AFD9F3514E9302D9DE3_654887304 = (lexer.hasMoreChars());
                        {
                            NameValue parms = qheader();
                            retval.setQHeader(parms);
                            {
                                boolean var052F98E1E244F24861DEF6838918EED5_186242684 = (lexer.hasMoreChars() && lexer.lookAhead(0) != '&');
                                lexer.consume(1);
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_669671367 = retval;
        } 
        finally 
        {
            dbg_leave("sipURL");
        } 
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_669671367.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_669671367;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.892 -0400", hash_original_method = "A1AFDB81F6A99AEF965D53D1558A830F", hash_generated_method = "2C5D2EBB0AB510B1FFD0F868943B2E44")
    public String peekScheme() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1579624067 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1990566406 = null; 
        Token[] tokens = lexer.peekNextToken(1);
        varB4EAC82CA7396A68D541C85D26508E83_1579624067 = null;
        String scheme = ((Token) tokens[0]).getTokenValue();
        varB4EAC82CA7396A68D541C85D26508E83_1990566406 = scheme;
        String varA7E53CE21691AB073D9660D615818899_251962524; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_251962524 = varB4EAC82CA7396A68D541C85D26508E83_1579624067;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_251962524 = varB4EAC82CA7396A68D541C85D26508E83_1990566406;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_251962524.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_251962524;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.893 -0400", hash_original_method = "8CC59A12163BED34BD1BF794F4FF4839", hash_generated_method = "4F7203B06BCD480F268C5A442A7DEB82")
    protected NameValue qheader() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_341297754 = null; 
        String name = lexer.getNextToken('=');
        lexer.consume(1);
        String value = hvalue();
        varB4EAC82CA7396A68D541C85D26508E83_341297754 = new NameValue(name, value, false);
        varB4EAC82CA7396A68D541C85D26508E83_341297754.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_341297754;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.895 -0400", hash_original_method = "44D1D496E84DF1E5395D6148A081CABE", hash_generated_method = "CC50E9A3D4D42AA4CF21A76B2144CB48")
    protected String hvalue() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1556992578 = null; 
        StringBuffer retval = new StringBuffer();
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_284923089 = (lexer.hasMoreChars());
            {
                char la = lexer.lookAhead(0);
                boolean isValidChar = false;
                
                isValidChar = true;
                
                {
                    boolean var8510A3B3F6999B2E9C748C1C619B9E8B_1270548305 = (isValidChar || Lexer.isAlphaDigit(la));
                    {
                        lexer.consume(1);
                        retval.append(la);
                    } 
                    {
                        retval.append(escaped());
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1556992578 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1556992578.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1556992578;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.900 -0400", hash_original_method = "ECAD9C42756FF84B730590BF5F3636AE", hash_generated_method = "1BD32879AFAF445DA23E8A2F4B8A929E")
    protected String urlString() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1768042789 = null; 
        StringBuffer retval = new StringBuffer();
        lexer.selectLexer("charLexer");
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_1846327407 = (lexer.hasMoreChars());
            {
                char la = lexer.lookAhead(0);
                lexer.consume(0);
                retval.append(la);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1768042789 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1768042789.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1768042789;
        
        
        
        
            
            
                
                
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.902 -0400", hash_original_method = "9AA60F60D9528CA4DF3AB8B29A4A0237", hash_generated_method = "E3971387552F7AADD15AADB484F25429")
    protected String user() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1489115499 = null; 
        dbg_enter("user");
        try 
        {
            int startIdx = lexer.getPtr();
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1305147433 = (lexer.hasMoreChars());
                {
                    char la = lexer.lookAhead(0);
                    {
                        boolean var8FDE9D716FC62805FC36EA151FDB086E_92869907 = (isUnreserved(la) || isUserUnreserved(la));
                        {
                            lexer.consume(1);
                        } 
                        {
                            boolean var7DDEF0E08361E9C02AADC7953802FC99_1321009030 = (isEscaped());
                            {
                                lexer.consume(3);
                            } 
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1489115499 = lexer.getBuffer().substring(startIdx, lexer.getPtr());
        } 
        finally 
        {
            dbg_leave("user");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1489115499.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1489115499;
        
        
            
        
            
            
                
                
                    
                
                    
                
                    
            
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.904 -0400", hash_original_method = "763B089E3F9716D78CD9674F5B515450", hash_generated_method = "A36064AA6CB7359B61D3C02A6B1D108F")
    protected String password() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1245878043 = null; 
        int startIdx = lexer.getPtr();
        {
            char la = lexer.lookAhead(0);
            boolean isValidChar = false;
            
            isValidChar = true;
            
            {
                boolean var042E4D2F12E6FAE99880DE236F6282DE_1788332722 = (isValidChar || isUnreserved(la));
                {
                    lexer.consume(1);
                } 
                {
                    boolean varD0BEBBDFA3B284B77894A2ED39B07738_450261720 = (isEscaped());
                    {
                        lexer.consume(3);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1245878043 = lexer.getBuffer().substring(startIdx, lexer.getPtr());
        varB4EAC82CA7396A68D541C85D26508E83_1245878043.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1245878043;
        
        
        
            
            
            
                
                
                
                
                
                    
            
            
                
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.905 -0400", hash_original_method = "A2F63CC3A1AD0DF2925153B5F3ECB644", hash_generated_method = "E8E80DF758D483A8634D455FE221F63A")
    public GenericURI parse() throws ParseException {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1104761960 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1104761960 = uriReference( true );
        varB4EAC82CA7396A68D541C85D26508E83_1104761960.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1104761960;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

