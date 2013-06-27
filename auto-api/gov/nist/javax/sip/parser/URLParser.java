package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.685 -0400", hash_original_method = "02D762C7659C29C6C28E615D4F3B4986", hash_generated_method = "4050C74595F73B4864EDAB05EDDAE34E")
    public  URLParser(String url) {
        this.lexer = new Lexer("sip_urlLexer", url);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //this.lexer = new Lexer("sip_urlLexer", url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.686 -0400", hash_original_method = "FF384429583BB1654143EB8FA592B141", hash_generated_method = "F0DA21DB293A6090D56A070DB3F88AF5")
    public  URLParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("sip_urlLexer");
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("sip_urlLexer");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.708 -0400", hash_original_method = "8FE92D5DF4A5AF3ADE92B1ED26FEEDBE", hash_generated_method = "0654834468726B4B10CB1A397B9F9EE2")
    protected String unreserved() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1370878059 = null; //Variable for return #1
        char next;
        next = lexer.lookAhead(0);
        {
            boolean var1389A34E9A875BE3049166D07D13716A_108384690 = (isUnreserved(next));
            {
                lexer.consume(1);
                varB4EAC82CA7396A68D541C85D26508E83_1370878059 = String.valueOf(next);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw createParseException("unreserved");
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1370878059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1370878059;
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isUnreserved(next)) {
            //lexer.consume(1);
            //return String.valueOf(next);
        //} else
            //throw createParseException("unreserved");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.708 -0400", hash_original_method = "1041AA48D060026BCCD13967429C5BF3", hash_generated_method = "4767F6D53F067C6780306A80815228E1")
    protected String paramNameOrValue() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1250112470 = null; //Variable for return #1
        int startIdx;
        startIdx = lexer.getPtr();
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_1999485226 = (lexer.hasMoreChars());
            {
                char next;
                next = lexer.lookAhead(0);
                boolean isValidChar;
                isValidChar = false;
                //Begin case '[' ']' '/' ':' '&' '+' '$' 
                isValidChar = true;
                //End case '[' ']' '/' ':' '&' '+' '$' 
                {
                    boolean varEBB6542C58D63C944BB22BBBEBD45AAF_1179682833 = (isValidChar || isUnreserved(next));
                    {
                        lexer.consume(1);
                    } //End block
                    {
                        boolean varF7C5BA76C493C7F02FA07B27C1AF3316_130607276 = (isEscaped());
                        {
                            lexer.consume(3);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1250112470 = lexer.getBuffer().substring(startIdx, lexer.getPtr());
        varB4EAC82CA7396A68D541C85D26508E83_1250112470.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1250112470;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.709 -0400", hash_original_method = "28DEAB6489C56D85C58F2548442629A5", hash_generated_method = "DB6A3C21D73469412CACF591E34E49B8")
    private NameValue uriParam() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1719366369 = null; //Variable for return #1
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1657184094 = null; //Variable for return #2
        dbg_enter("uriParam");
        try 
        {
            String pvalue;
            pvalue = "";
            String pname;
            pname = paramNameOrValue();
            char next;
            next = lexer.lookAhead(0);
            boolean isFlagParam;
            isFlagParam = true;
            {
                lexer.consume(1);
                pvalue = paramNameOrValue();
                isFlagParam = false;
            } //End block
            {
                boolean varA946C0818D54984040C780DFCE924753_711801668 = (pname.length() == 0 &&
                ( pvalue == null ||
                pvalue.length() == 0));
                varB4EAC82CA7396A68D541C85D26508E83_1719366369 = null;
                varB4EAC82CA7396A68D541C85D26508E83_1657184094 = new NameValue(pname, pvalue, isFlagParam);
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("uriParam");
        } //End block
        NameValue varA7E53CE21691AB073D9660D615818899_1191528062; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1191528062 = varB4EAC82CA7396A68D541C85D26508E83_1719366369;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1191528062 = varB4EAC82CA7396A68D541C85D26508E83_1657184094;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1191528062.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1191528062;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.718 -0400", hash_original_method = "FFA1DEBB1A42288CA22D82A97ACC067B", hash_generated_method = "DDDAA02BF0A0DB023CACFCE4916A278B")
    protected String reserved() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_2105778595 = null; //Variable for return #1
        char next;
        next = lexer.lookAhead(0);
        {
            boolean varAE7675CD56F874911E26881E5AAACF61_1227310897 = (isReserved(next));
            {
                lexer.consume(1);
                varB4EAC82CA7396A68D541C85D26508E83_2105778595 = new StringBuffer().append(next).toString();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw createParseException("reserved");
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2105778595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2105778595;
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isReserved(next)) {
            //lexer.consume(1);
            //return new StringBuffer().append(next).toString();
        //} else
            //throw createParseException("reserved");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.718 -0400", hash_original_method = "B69B97990375B5870393017EB399692B", hash_generated_method = "7826917A54DA6A71971BBF7C33FBB557")
    protected boolean isEscaped() {
        try 
        {
            boolean var3F9254A4E7823F8753251F2B55C56EF1_1692802995 = (lexer.lookAhead(0) == '%' &&
                Lexer.isHexDigit(lexer.lookAhead(1)) &&
                Lexer.isHexDigit(lexer.lookAhead(2)));
        } //End block
        catch (Exception ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662017176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662017176;
        // ---------- Original Method ----------
        //try {
            //return lexer.lookAhead(0) == '%' &&
                //Lexer.isHexDigit(lexer.lookAhead(1)) &&
                //Lexer.isHexDigit(lexer.lookAhead(2));
        //} catch (Exception ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.719 -0400", hash_original_method = "08A77A9FB0F42402334D6E5EC1EEFB98", hash_generated_method = "2AC7828A72EBB4499780FFA85B2C212C")
    protected String escaped() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_32115592 = null; //Variable for return #1
        dbg_enter("escaped");
        try 
        {
            StringBuffer retval;
            retval = new StringBuffer();
            char next;
            next = lexer.lookAhead(0);
            char next1;
            next1 = lexer.lookAhead(1);
            char next2;
            next2 = lexer.lookAhead(2);
            {
                boolean var60B80A984C77CCEA3BBF72B827F48A07_1711199426 = (next == '%'
                && Lexer.isHexDigit(next1)
                && Lexer.isHexDigit(next2));
                {
                    lexer.consume(3);
                    retval.append(next);
                    retval.append(next1);
                    retval.append(next2);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("escaped");
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_32115592 = retval.toString();
        } //End block
        finally 
        {
            dbg_leave("escaped");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_32115592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_32115592;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.729 -0400", hash_original_method = "743AFD3B213C469742C3C78020E0DBC1", hash_generated_method = "23331E970FB11928550CACA7383A7792")
    protected String mark() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_435827817 = null; //Variable for return #1
        dbg_enter("mark");
        try 
        {
            char next;
            next = lexer.lookAhead(0);
            {
                boolean varE0C748D002BB162804157081E5A97AF7_1770443998 = (isMark(next));
                {
                    lexer.consume(1);
                    varB4EAC82CA7396A68D541C85D26508E83_435827817 = new String( new char[]{next} );
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("mark");
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("mark");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_435827817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_435827817;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.731 -0400", hash_original_method = "589C84A9F2E2E16C04FA96C5BE216A43", hash_generated_method = "FA0D3B13EAA47ADDBF6EFD9E99F197A4")
    protected String uric() {
        String varB4EAC82CA7396A68D541C85D26508E83_777509371 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_204444798 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1096958438 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_2036832179 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_465903298 = null; //Variable for return #5
        dbg_enter("uric");
        try 
        {
            try 
            {
                char la;
                la = lexer.lookAhead(0);
                {
                    boolean var4DEDA407E3BC616B4A5AC7CEF8C961B8_1174683989 = (isUnreserved(la));
                    {
                        lexer.consume(1);
                        varB4EAC82CA7396A68D541C85D26508E83_777509371 = Lexer.charAsString(la);
                    } //End block
                    {
                        boolean var967F4E910D4BCCE057AC7DAD96CB80FB_982412568 = (isReserved(la));
                        {
                            lexer.consume(1);
                            varB4EAC82CA7396A68D541C85D26508E83_204444798 = Lexer.charAsString(la);
                        } //End block
                        {
                            boolean var7DDEF0E08361E9C02AADC7953802FC99_811196095 = (isEscaped());
                            {
                                String retval;
                                retval = lexer.charAsString(3);
                                lexer.consume(3);
                                varB4EAC82CA7396A68D541C85D26508E83_1096958438 = retval;
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_2036832179 = null;
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_465903298 = null;
            } //End block
        } //End block
        finally 
        {
            dbg_leave("uric");
        } //End block
        String varA7E53CE21691AB073D9660D615818899_799317472; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_799317472 = varB4EAC82CA7396A68D541C85D26508E83_777509371;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_799317472 = varB4EAC82CA7396A68D541C85D26508E83_204444798;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_799317472 = varB4EAC82CA7396A68D541C85D26508E83_1096958438;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_799317472 = varB4EAC82CA7396A68D541C85D26508E83_2036832179;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_799317472 = varB4EAC82CA7396A68D541C85D26508E83_465903298;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_799317472.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_799317472;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.737 -0400", hash_original_method = "C9EA734307D4CD12B7093594DF2E8530", hash_generated_method = "863943AC89ACE15845639EF2365A4107")
    protected String uricNoSlash() {
        String varB4EAC82CA7396A68D541C85D26508E83_1441799706 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1573461487 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1034333739 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_90897407 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_2116148964 = null; //Variable for return #5
        dbg_enter("uricNoSlash");
        try 
        {
            try 
            {
                char la;
                la = lexer.lookAhead(0);
                {
                    boolean varD0BEBBDFA3B284B77894A2ED39B07738_1381461250 = (isEscaped());
                    {
                        String retval;
                        retval = lexer.charAsString(3);
                        lexer.consume(3);
                        varB4EAC82CA7396A68D541C85D26508E83_1441799706 = retval;
                    } //End block
                    {
                        boolean var7C808D9F6303ECB25ED4BAECB34B9B56_174551482 = (isUnreserved(la));
                        {
                            lexer.consume(1);
                            varB4EAC82CA7396A68D541C85D26508E83_1573461487 = Lexer.charAsString(la);
                        } //End block
                        {
                            boolean varCAF58582C5F6188CEA5D8F016BCE21F5_12652327 = (isReservedNoSlash(la));
                            {
                                lexer.consume(1);
                                varB4EAC82CA7396A68D541C85D26508E83_1034333739 = Lexer.charAsString(la);
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_90897407 = null;
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_2116148964 = null;
            } //End block
        } //End block
        finally 
        {
            dbg_leave("uricNoSlash");
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1804961956; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1804961956 = varB4EAC82CA7396A68D541C85D26508E83_1441799706;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1804961956 = varB4EAC82CA7396A68D541C85D26508E83_1573461487;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1804961956 = varB4EAC82CA7396A68D541C85D26508E83_1034333739;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1804961956 = varB4EAC82CA7396A68D541C85D26508E83_90897407;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1804961956 = varB4EAC82CA7396A68D541C85D26508E83_2116148964;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1804961956.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1804961956;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.743 -0400", hash_original_method = "F8BFDE8FCAA82A1A34C46F55D7711C6B", hash_generated_method = "537E0407818000B77442419344E0FB77")
    protected String uricString() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_143258468 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        {
            String next;
            next = uric();
            {
                char la;
                la = lexer.lookAhead(0);
                {
                    HostNameParser hnp;
                    hnp = new HostNameParser(this.getLexer());
                    HostPort hp;
                    hp = hnp.hostPort( false );
                    retval.append(hp.toString());
                } //End block
            } //End block
            retval.append(next);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_143258468 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_143258468.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_143258468;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.754 -0400", hash_original_method = "877793596C03075095766EB10627CE12", hash_generated_method = "77FA65F2C35694B9DCA8664DADDF9017")
    public GenericURI uriReference( boolean inBrackets ) throws ParseException {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_1794355554 = null; //Variable for return #1
        dbg_enter("uriReference");
        GenericURI retval;
        retval = null;
        Token[] tokens;
        tokens = lexer.peekNextToken(2);
        Token t1;
        t1 = (Token) tokens[0];
        Token t2;
        t2 = (Token) tokens[1];
        try 
        {
            {
                boolean var3E3C08E681A70CFCD29256F591BA9F85_1198217701 = (t1.getTokenType() == TokenTypes.SIP ||
                    t1.getTokenType() == TokenTypes.SIPS);
                {
                    {
                        boolean var19C34D70DBF4E04E87D5E554663CED0B_221371577 = (t2.getTokenType() == ':');
                        retval = sipURL( inBrackets );
                        if (DroidSafeAndroidRuntime.control) throw createParseException("Expecting \':\'");
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var9DCC9A019F767A37C0CD3E2554D567B2_1086917266 = (t1.getTokenType() == TokenTypes.TEL);
                    {
                        {
                            boolean var6E0AC27A3BCD64EF8F081ACBDDD022E3_1943604484 = (t2.getTokenType() == ':');
                            {
                                retval = telURL( inBrackets );
                            } //End block
                            if (DroidSafeAndroidRuntime.control) throw createParseException("Expecting \':\'");
                        } //End collapsed parenthetic
                    } //End block
                    {
                        String urlString;
                        urlString = uricString();
                        try 
                        {
                            retval = new GenericURI(urlString);
                        } //End block
                        catch (ParseException ex)
                        {
                            if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("uriReference");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1794355554 = retval;
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1794355554.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1794355554;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.766 -0400", hash_original_method = "FA28BF7ACB321CCE37D931F114A366BD", hash_generated_method = "E7FBAF11C79461B29A04579FF4A8945D")
    private String base_phone_number() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1023077994 = null; //Variable for return #1
        StringBuffer s;
        s = new StringBuffer();
        dbg_enter("base_phone_number");
        try 
        {
            int lc;
            lc = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1178831393 = (lexer.hasMoreChars());
                {
                    char w;
                    w = lexer.lookAhead(0);
                    {
                        boolean var558B9976D373EA13678F300ACFC57D1F_643036680 = (Lexer.isDigit(w)
                    || w == '-'
                    || w == '.'
                    || w == '('
                    || w == ')');
                        {
                            lexer.consume(1);
                            s.append(w);
                        } //End block
                        if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected " + w);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1023077994 = s.toString();
        } //End block
        finally 
        {
            dbg_leave("base_phone_number");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1023077994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1023077994;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.782 -0400", hash_original_method = "0C6D1452631B0ABABC52FCC37CE65FF7", hash_generated_method = "EA2E07DBE4061B71D4A7D43CEA095D3C")
    private String local_number() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_552747738 = null; //Variable for return #1
        StringBuffer s;
        s = new StringBuffer();
        dbg_enter("local_number");
        try 
        {
            int lc;
            lc = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_892768296 = (lexer.hasMoreChars());
                {
                    char la;
                    la = lexer.lookAhead(0);
                    {
                        boolean var20C700F69E25677794711EF4694FACAC_41533253 = (la == '*'
                    || la == '#'
                    || la == '-'
                    || la == '.'
                    || la == '('
                    || la == ')'
                    || Lexer.isHexDigit(la));
                        {
                            lexer.consume(1);
                            s.append(la);
                        } //End block
                        if (DroidSafeAndroidRuntime.control) throw createParseException("unexepcted " + la);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_552747738 = s.toString();
        } //End block
        finally 
        {
            dbg_leave("local_number");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_552747738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_552747738;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.797 -0400", hash_original_method = "DEDDF1126FB4D34419E3541D3DE0EAF4", hash_generated_method = "DC37591910F5C6F3DD0EE6258072B6AD")
    public final TelephoneNumber parseTelephoneNumber( boolean inBrackets ) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_866785573 = null; //Variable for return #1
        TelephoneNumber tn;
        dbg_enter("telephone_subscriber");
        lexer.selectLexer("charLexer");
        try 
        {
            char c;
            c = lexer.lookAhead(0);
            tn = global_phone_number( inBrackets );
            {
                boolean var507D5F8498D0167D369439A5884A0378_1041403518 = (Lexer.isHexDigit(c)
                    || c == '#'
                    || c == '*'
                    || c == '-'
                    || c == '.'
                    || c == '('
                    || c == ')');
                {
                    tn = local_phone_number( inBrackets );
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("unexpected char " + c);
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_866785573 = tn;
        } //End block
        finally 
        {
            dbg_leave("telephone_subscriber");
        } //End block
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_866785573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_866785573;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.805 -0400", hash_original_method = "0F1ADEC60659CEA5C84BABEF7D06F081", hash_generated_method = "B3198566E4E6B8F7E6728872C3A2374D")
    private final TelephoneNumber global_phone_number( boolean inBrackets ) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1358798905 = null; //Variable for return #1
        dbg_enter("global_phone_number");
        try 
        {
            TelephoneNumber tn;
            tn = new TelephoneNumber();
            tn.setGlobal(true);
            NameValueList nv;
            nv = null;
            this.lexer.match(PLUS);
            String b;
            b = base_phone_number();
            tn.setPhoneNumber(b);
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1450154430 = (lexer.hasMoreChars());
                {
                    char tok;
                    tok = lexer.lookAhead(0);
                    {
                        this.lexer.consume(1);
                        nv = tel_parameters();
                        tn.setParameters(nv);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1358798905 = tn;
        } //End block
        finally 
        {
            dbg_leave("global_phone_number");
        } //End block
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1358798905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1358798905;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.814 -0400", hash_original_method = "883FF19CD75AFF340396001C616EFCAA", hash_generated_method = "77B028C1F81185EFABA98C51A63536CB")
    private TelephoneNumber local_phone_number( boolean inBrackets ) throws ParseException {
        TelephoneNumber varB4EAC82CA7396A68D541C85D26508E83_1804119383 = null; //Variable for return #1
        dbg_enter("local_phone_number");
        TelephoneNumber tn;
        tn = new TelephoneNumber();
        tn.setGlobal(false);
        NameValueList nv;
        nv = null;
        String b;
        b = null;
        try 
        {
            b = local_number();
            tn.setPhoneNumber(b);
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_80248160 = (lexer.hasMoreChars());
                {
                    Token tok;
                    tok = this.lexer.peekNextToken();
                    {
                        Object varD3D97B347F6C533E598B0CFBC725AF99_1588593364 = (tok.getTokenType());
                        //Begin case SEMICOLON 
                        {
                            {
                                this.lexer.consume(1);
                                nv = tel_parameters();
                                tn.setParameters(nv);
                            } //End block
                        } //End block
                        //End case SEMICOLON 
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("local_phone_number");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1804119383 = tn;
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1804119383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1804119383;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.820 -0400", hash_original_method = "F5BCCE1D5E357F2A71ACB92ADA6046C2", hash_generated_method = "BEE6E0AB241C6DCE8D117909F4F2C203")
    private NameValueList tel_parameters() throws ParseException {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_831671735 = null; //Variable for return #1
        NameValueList nvList;
        nvList = new NameValueList();
        NameValue nv;
        {
            String pname;
            pname = paramNameOrValue();
            {
                boolean varC10FDE306D9280D8B230EFFEBE7BBCAD_719558253 = (pname.equalsIgnoreCase("phone-context"));
                {
                    nv = phone_context();
                } //End block
                {
                    {
                        boolean var58840CF471CB22F21A5C8437922569C5_1960884044 = (lexer.lookAhead(0) == '=');
                        {
                            lexer.consume(1);
                            String value;
                            value = paramNameOrValue();
                            nv = new NameValue( pname, value, false );
                        } //End block
                        {
                            nv = new NameValue( pname, "", true );
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            nvList.set( nv );
            {
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_34561455 = (lexer.lookAhead(0) == ';');
                {
                    lexer.consume(1);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_831671735 = nvList;
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_831671735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_831671735;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.821 -0400", hash_original_method = "4B2DA37312785E9B10734C6846FECD1E", hash_generated_method = "7D511D0CA69703C38F5E5ADB0D1C8EC4")
    private NameValue phone_context() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_2047479003 = null; //Variable for return #1
        lexer.match('=');
        char la;
        la = lexer.lookAhead(0);
        Object value;
        {
            lexer.consume(1);
            value = "+" + base_phone_number();
        } //End block
        {
            boolean varCB62C5C9B3FAF6D4CFE708D2749449C5_60184645 = (Lexer.isAlphaDigit(la));
            {
                Token t;
                t = lexer.match( Lexer.ID );
                value = t.getTokenValue();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException( "Invalid phone-context:" + la , -1 );
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2047479003 = new NameValue( "phone-context", value, false );
        varB4EAC82CA7396A68D541C85D26508E83_2047479003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047479003;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.839 -0400", hash_original_method = "73C5F5A1DB2F1724F7BD39D759918D7C", hash_generated_method = "03E8DCB2B21D3879AF4A12C150C4159B")
    public TelURLImpl telURL( boolean inBrackets ) throws ParseException {
        TelURLImpl varB4EAC82CA7396A68D541C85D26508E83_1612178019 = null; //Variable for return #1
        lexer.match(TokenTypes.TEL);
        lexer.match(':');
        TelephoneNumber tn;
        tn = this.parseTelephoneNumber(inBrackets);
        TelURLImpl telUrl;
        telUrl = new TelURLImpl();
        telUrl.setTelephoneNumber(tn);
        varB4EAC82CA7396A68D541C85D26508E83_1612178019 = telUrl;
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1612178019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1612178019;
        // ---------- Original Method ----------
        //lexer.match(TokenTypes.TEL);
        //lexer.match(':');
        //TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        //TelURLImpl telUrl = new TelURLImpl();
        //telUrl.setTelephoneNumber(tn);
        //return telUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.842 -0400", hash_original_method = "7278F7A930851B1FF266754B78180AE2", hash_generated_method = "D37A9339BF1DF9D16D5737143AEA33B6")
    public SipUri sipURL( boolean inBrackets ) throws ParseException {
        SipUri varB4EAC82CA7396A68D541C85D26508E83_1345906826 = null; //Variable for return #1
        dbg_enter("sipURL");
        SipUri retval;
        retval = new SipUri();
        Token nextToken;
        nextToken = lexer.peekNextToken();
        int sipOrSips;
        sipOrSips = TokenTypes.SIP;
        String scheme;
        scheme = TokenNames.SIP;
        {
            boolean var428A8649D9DE71F3027322B0FB5BC374_76585574 = (nextToken.getTokenType() == TokenTypes.SIPS);
            {
                sipOrSips = TokenTypes.SIPS;
                scheme = TokenNames.SIPS;
            } //End block
        } //End collapsed parenthetic
        try 
        {
            lexer.match(sipOrSips);
            lexer.match(':');
            retval.setScheme(scheme);
            int startOfUser;
            startOfUser = lexer.markInputPosition();
            String userOrHost;
            userOrHost = user();
            String passOrPort;
            passOrPort = null;
            {
                boolean varA481248E93D84F444CD01FB31AAFDF62_1755826465 = (lexer.lookAhead() == ':');
                {
                    lexer.consume(1);
                    passOrPort = password();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var8F99848E84C59D67D6EAE42041875FCD_985133794 = (lexer.lookAhead() == '@');
                {
                    lexer.consume(1);
                    retval.setUser( userOrHost );
                    retval.setUserPassword( passOrPort );
                } //End block
                {
                    lexer.rewindInputPosition( startOfUser );
                } //End block
            } //End collapsed parenthetic
            HostNameParser hnp;
            hnp = new HostNameParser(this.getLexer());
            HostPort hp;
            hp = hnp.hostPort( false );
            retval.setHostPort(hp);
            lexer.selectLexer("charLexer");
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_834023481 = (lexer.hasMoreChars());
                {
                    {
                        boolean var586A81C98915AF015E02FB22E05826EF_392917800 = (lexer.lookAhead(0) != ';' || !inBrackets);
                    } //End collapsed parenthetic
                    lexer.consume(1);
                    NameValue parms;
                    parms = uriParam();
                    retval.setUriParameter(parms);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var7C875628E08B715321EFB433C7824D95_1620233841 = (lexer.hasMoreChars() && lexer.lookAhead(0) == '?');
                {
                    lexer.consume(1);
                    {
                        boolean var4CB791BD05839AFD9F3514E9302D9DE3_1712616114 = (lexer.hasMoreChars());
                        {
                            NameValue parms;
                            parms = qheader();
                            retval.setQHeader(parms);
                            {
                                boolean var052F98E1E244F24861DEF6838918EED5_835191748 = (lexer.hasMoreChars() && lexer.lookAhead(0) != '&');
                                lexer.consume(1);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1345906826 = retval;
        } //End block
        finally 
        {
            dbg_leave("sipURL");
        } //End block
        addTaint(inBrackets);
        varB4EAC82CA7396A68D541C85D26508E83_1345906826.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1345906826;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.843 -0400", hash_original_method = "A1AFDB81F6A99AEF965D53D1558A830F", hash_generated_method = "EA78A4D190D6B7C83AA23DD0509ED392")
    public String peekScheme() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_18370927 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_302806372 = null; //Variable for return #2
        Token[] tokens;
        tokens = lexer.peekNextToken(1);
        varB4EAC82CA7396A68D541C85D26508E83_18370927 = null;
        String scheme;
        scheme = ((Token) tokens[0]).getTokenValue();
        varB4EAC82CA7396A68D541C85D26508E83_302806372 = scheme;
        String varA7E53CE21691AB073D9660D615818899_1001364200; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1001364200 = varB4EAC82CA7396A68D541C85D26508E83_18370927;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1001364200 = varB4EAC82CA7396A68D541C85D26508E83_302806372;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1001364200.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1001364200;
        // ---------- Original Method ----------
        //Token[] tokens = lexer.peekNextToken(1);
        //if (tokens.length == 0)
            //return null;
        //String scheme = ((Token) tokens[0]).getTokenValue();
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.861 -0400", hash_original_method = "8CC59A12163BED34BD1BF794F4FF4839", hash_generated_method = "F3C026DA5CC38569F6BC21D28ABAD6C3")
    protected NameValue qheader() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_226538237 = null; //Variable for return #1
        String name;
        name = lexer.getNextToken('=');
        lexer.consume(1);
        String value;
        value = hvalue();
        varB4EAC82CA7396A68D541C85D26508E83_226538237 = new NameValue(name, value, false);
        varB4EAC82CA7396A68D541C85D26508E83_226538237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_226538237;
        // ---------- Original Method ----------
        //String name = lexer.getNextToken('=');
        //lexer.consume(1);
        //String value = hvalue();
        //return new NameValue(name, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.862 -0400", hash_original_method = "44D1D496E84DF1E5395D6148A081CABE", hash_generated_method = "0090E522DDA4F03C5E2DD30575C5845A")
    protected String hvalue() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_2010351450 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_544959991 = (lexer.hasMoreChars());
            {
                char la;
                la = lexer.lookAhead(0);
                boolean isValidChar;
                isValidChar = false;
                //Begin case '+' '?' ':' '[' ']' '/' '$' '_' '-' '"' '!' '~' '*' '.' '(' ')' 
                isValidChar = true;
                //End case '+' '?' ':' '[' ']' '/' '$' '_' '-' '"' '!' '~' '*' '.' '(' ')' 
                {
                    boolean var8510A3B3F6999B2E9C748C1C619B9E8B_1865978174 = (isValidChar || Lexer.isAlphaDigit(la));
                    {
                        lexer.consume(1);
                        retval.append(la);
                    } //End block
                    {
                        retval.append(escaped());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2010351450 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2010351450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010351450;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.863 -0400", hash_original_method = "ECAD9C42756FF84B730590BF5F3636AE", hash_generated_method = "6A88653DF53EFE416C553B8DA4AE39A2")
    protected String urlString() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_988382594 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        lexer.selectLexer("charLexer");
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_639412474 = (lexer.hasMoreChars());
            {
                char la;
                la = lexer.lookAhead(0);
                lexer.consume(0);
                retval.append(la);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_988382594 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_988382594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_988382594;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.864 -0400", hash_original_method = "9AA60F60D9528CA4DF3AB8B29A4A0237", hash_generated_method = "9E0727F456CD9D3D6AB7B525AEE0881D")
    protected String user() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1230336445 = null; //Variable for return #1
        dbg_enter("user");
        try 
        {
            int startIdx;
            startIdx = lexer.getPtr();
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1659153316 = (lexer.hasMoreChars());
                {
                    char la;
                    la = lexer.lookAhead(0);
                    {
                        boolean var8FDE9D716FC62805FC36EA151FDB086E_931093181 = (isUnreserved(la) || isUserUnreserved(la));
                        {
                            lexer.consume(1);
                        } //End block
                        {
                            boolean var7DDEF0E08361E9C02AADC7953802FC99_2099973599 = (isEscaped());
                            {
                                lexer.consume(3);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1230336445 = lexer.getBuffer().substring(startIdx, lexer.getPtr());
        } //End block
        finally 
        {
            dbg_leave("user");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1230336445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230336445;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.878 -0400", hash_original_method = "763B089E3F9716D78CD9674F5B515450", hash_generated_method = "95FE32991EEF50B58F1823782F8246B7")
    protected String password() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1865573122 = null; //Variable for return #1
        int startIdx;
        startIdx = lexer.getPtr();
        {
            char la;
            la = lexer.lookAhead(0);
            boolean isValidChar;
            isValidChar = false;
            //Begin case '&' '=' '+' '$' ',' 
            isValidChar = true;
            //End case '&' '=' '+' '$' ',' 
            {
                boolean var042E4D2F12E6FAE99880DE236F6282DE_2029236649 = (isValidChar || isUnreserved(la));
                {
                    lexer.consume(1);
                } //End block
                {
                    boolean varD0BEBBDFA3B284B77894A2ED39B07738_2095394682 = (isEscaped());
                    {
                        lexer.consume(3);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1865573122 = lexer.getBuffer().substring(startIdx, lexer.getPtr());
        varB4EAC82CA7396A68D541C85D26508E83_1865573122.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865573122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.879 -0400", hash_original_method = "A2F63CC3A1AD0DF2925153B5F3ECB644", hash_generated_method = "5F1EA4E08B6252440A053013AF872252")
    public GenericURI parse() throws ParseException {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_773873946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_773873946 = uriReference( true );
        varB4EAC82CA7396A68D541C85D26508E83_773873946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_773873946;
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

