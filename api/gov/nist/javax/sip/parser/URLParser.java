package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.451 -0500", hash_original_method = "2E6BD7BC03AAC930545A17B5C6166288", hash_generated_method = "A897F129E9AD68B314557B18E0D136F1")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.453 -0500", hash_original_method = "61B6A886599823E1FFED1A8154C1D38F", hash_generated_method = "6778DE1D85284BCCE77106DD063CE8F8")
    
protected static boolean isUnreserved(char next) {
        return Lexer.isAlphaDigit(next) || isMark(next);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.457 -0500", hash_original_method = "A1B1E0649BEF68785217FFC4E4C90E5B", hash_generated_method = "8E5EF8226B2CE28CC81A7C9C6E0F43CC")
    
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

    // Missing '=' bug in character set - discovered by interop testing
    // at SIPIT 13 by Bob Johnson and Scott Holben.
    // change . to ; by Bruno Konik
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.459 -0500", hash_original_method = "A89FA61333F1DB9BC647EE95F6903710", hash_generated_method = "366665B92DD852DC5DC7A4F6DCDD495D")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.471 -0500", hash_original_method = "8CB639EA92F114A28489D436D5279FE1", hash_generated_method = "5D229189229BC9C0391F95F5207C20D5")
    
protected static boolean isReserved(char next) {
        switch (next) {
            case ';':
            case '/':
            case '?':
            case ':':
            case '=': // Bug fix by Bruno Konik
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

    // quick test routine for debugging type assignment
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.541 -0500", hash_original_method = "324107E70E741A706B2DC6DBD5064849", hash_generated_method = "F3F3CAE62D778B55DB8CFFB15B79297C")
    
public static void main(String[] args) throws ParseException
    {
        // quick test for sips parsing
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.446 -0500", hash_original_method = "02D762C7659C29C6C28E615D4F3B4986", hash_generated_method = "6CED07A06671C22F98DE1FEEDE458EF4")
    
public URLParser(String url) {
        this.lexer = new Lexer("sip_urlLexer", url);
    }

    // public tag added - issued by Miguel Freitas
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.449 -0500", hash_original_method = "FF384429583BB1654143EB8FA592B141", hash_generated_method = "BE2B4A9DB002337D998A45F1BBF43AA4")
    
public URLParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("sip_urlLexer");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.462 -0500", hash_original_method = "8FE92D5DF4A5AF3ADE92B1ED26FEEDBE", hash_generated_method = "FD40B079F90C1B58E837C982A84C6A55")
    
protected String unreserved() throws ParseException {
        char next = lexer.lookAhead(0);
        if (isUnreserved(next)) {
            lexer.consume(1);
            return String.valueOf(next);
        } else
            throw createParseException("unreserved");

    }

    /** Name or value of a parameter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.465 -0500", hash_original_method = "1041AA48D060026BCCD13967429C5BF3", hash_generated_method = "879D5278FEB8342E2E5E9E41C9B65265")
    
protected String paramNameOrValue() throws ParseException {
        int startIdx = lexer.getPtr();
        while (lexer.hasMoreChars()) {
            char next = lexer.lookAhead(0);
            boolean isValidChar = false;
            switch (next) {
                case '[':
                case ']':// JvB: fixed this one
                case '/':
                case ':':
                case '&':
                case '+':
                case '$':
                    isValidChar = true;
            }
            if (isValidChar || isUnreserved(next)) {
                lexer.consume(1);
            } else if (isEscaped()) {
                lexer.consume(3);
            } else
                break;
        }
        return lexer.getBuffer().substring(startIdx, lexer.getPtr());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.468 -0500", hash_original_method = "28DEAB6489C56D85C58F2548442629A5", hash_generated_method = "B13223F23D353B520FDE65DDFD5D3C0C")
    
private NameValue uriParam() throws ParseException {
        if (debug)
            dbg_enter("uriParam");
        try {
            String pvalue = "";
            String pname = paramNameOrValue();
            char next = lexer.lookAhead(0);
            boolean isFlagParam = true;
            if (next == '=') {
                lexer.consume(1);
                pvalue = paramNameOrValue();
                isFlagParam = false;
            }
            if (pname.length() == 0 &&
                ( pvalue == null ||
                pvalue.length() == 0))
                return null;
            else return new NameValue(pname, pvalue, isFlagParam);
        } finally {
            if (debug)
                dbg_leave("uriParam");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.473 -0500", hash_original_method = "FFA1DEBB1A42288CA22D82A97ACC067B", hash_generated_method = "2C40EEE058E2965B474C5AFBE8BB00BD")
    
protected String reserved() throws ParseException {
        char next = lexer.lookAhead(0);
        if (isReserved(next)) {
            lexer.consume(1);
            return new StringBuffer().append(next).toString();
        } else
            throw createParseException("reserved");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.476 -0500", hash_original_method = "B69B97990375B5870393017EB399692B", hash_generated_method = "7A8AD61F78A100BF571C3F06A053272D")
    
protected boolean isEscaped() {
        try {
            return lexer.lookAhead(0) == '%' &&
                Lexer.isHexDigit(lexer.lookAhead(1)) &&
                Lexer.isHexDigit(lexer.lookAhead(2));
        } catch (Exception ex) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.478 -0500", hash_original_method = "08A77A9FB0F42402334D6E5EC1EEFB98", hash_generated_method = "943D06BACE92F945C8EE51C1E750FE85")
    
protected String escaped() throws ParseException {
        if (debug)
            dbg_enter("escaped");
        try {
            StringBuffer retval = new StringBuffer();
            char next = lexer.lookAhead(0);
            char next1 = lexer.lookAhead(1);
            char next2 = lexer.lookAhead(2);
            if (next == '%'
                && Lexer.isHexDigit(next1)
                && Lexer.isHexDigit(next2)) {
                lexer.consume(3);
                retval.append(next);
                retval.append(next1);
                retval.append(next2);
            } else
                throw createParseException("escaped");
            return retval.toString();
        } finally {
            if (debug)
                dbg_leave("escaped");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.481 -0500", hash_original_method = "743AFD3B213C469742C3C78020E0DBC1", hash_generated_method = "416117654E5017E0ABBAF3D3336ED7AA")
    
protected String mark() throws ParseException {
        if (debug)
            dbg_enter("mark");
        try {
            char next = lexer.lookAhead(0);
            if (isMark(next)) {
                lexer.consume(1);
                return new String( new char[]{next} );
            } else
                throw createParseException("mark");
        } finally {
            if (debug)
                dbg_leave("mark");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.484 -0500", hash_original_method = "589C84A9F2E2E16C04FA96C5BE216A43", hash_generated_method = "9673357D2012B9D4CB8BB05AE3FA85DB")
    
protected String uric() {
        if (debug)
            dbg_enter("uric");
        try {
            try {
                char la = lexer.lookAhead(0);
                if (isUnreserved(la)) {
                    lexer.consume(1);
                    return Lexer.charAsString(la);
                } else if (isReserved(la)) {
                    lexer.consume(1);
                    return Lexer.charAsString(la);
                } else if (isEscaped()) {
                    String retval = lexer.charAsString(3);
                    lexer.consume(3);
                    return retval;
                } else
                    return null;
            } catch (Exception ex) {
                return null;
            }
        } finally {
            if (debug)
                dbg_leave("uric");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.487 -0500", hash_original_method = "C9EA734307D4CD12B7093594DF2E8530", hash_generated_method = "693392AD8880EAC6D6576B336A7B828A")
    
protected String uricNoSlash() {
        if (debug)
            dbg_enter("uricNoSlash");
        try {
            try {
                char la = lexer.lookAhead(0);
                if (isEscaped()) {
                    String retval = lexer.charAsString(3);
                    lexer.consume(3);
                    return retval;
                } else if (isUnreserved(la)) {
                    lexer.consume(1);
                    return Lexer.charAsString(la);
                } else if (isReservedNoSlash(la)) {
                    lexer.consume(1);
                    return Lexer.charAsString(la);
                } else
                    return null;
            } catch (ParseException ex) {
                return null;
            }
        } finally {
            if (debug)
                dbg_leave("uricNoSlash");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.489 -0500", hash_original_method = "F8BFDE8FCAA82A1A34C46F55D7711C6B", hash_generated_method = "3C7062342596FA44BADC096B190ADCA4")
    
protected String uricString() throws ParseException {
        StringBuffer retval = new StringBuffer();
        while (true) {
            String next = uric();
            if (next == null) {
                char la = lexer.lookAhead(0);
                // JvB: allow IPv6 addresses in generic URI strings
                // e.g. http://[::1]
                if ( la == '[' ) {
                    HostNameParser hnp = new HostNameParser(this.getLexer());
                    HostPort hp = hnp.hostPort( false );
                    retval.append(hp.toString());
                    continue;
                }
                break;
            }
            retval.append(next);
        }
        return retval.toString();
    }

    /**
     * Parse and return a structure for a generic URL.
     * Note that non SIP URLs are just stored as a string (not parsed).
     * @return URI is a URL structure for a SIP url.
     * @throws ParseException if there was a problem parsing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.492 -0500", hash_original_method = "877793596C03075095766EB10627CE12", hash_generated_method = "5E593FA63C7CE6AD0FCAF97CBADB09C0")
    
public GenericURI uriReference( boolean inBrackets ) throws ParseException {
        if (debug)
            dbg_enter("uriReference");
        GenericURI retval = null;
        Token[] tokens = lexer.peekNextToken(2);
        Token t1 = (Token) tokens[0];
        Token t2 = (Token) tokens[1];
        try {

            if (t1.getTokenType() == TokenTypes.SIP ||
                    t1.getTokenType() == TokenTypes.SIPS) {
                if (t2.getTokenType() == ':')
                    retval = sipURL( inBrackets );
                else
                    throw createParseException("Expecting \':\'");
            } else if (t1.getTokenType() == TokenTypes.TEL) {
                if (t2.getTokenType() == ':') {
                    retval = telURL( inBrackets );
                } else
                    throw createParseException("Expecting \':\'");
            } else {
                String urlString = uricString();
                try {
                    retval = new GenericURI(urlString);
                } catch (ParseException ex) {
                    throw createParseException(ex.getMessage());
                }
            }
        } finally {
            if (debug)
                dbg_leave("uriReference");
        }
        return retval;
    }

    /**
     * Parser for the base phone number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.495 -0500", hash_original_method = "FA28BF7ACB321CCE37D931F114A366BD", hash_generated_method = "1EAD434B6308133C51665215BA907C7C")
    
private String base_phone_number() throws ParseException {
        StringBuffer s = new StringBuffer();

        if (debug)
            dbg_enter("base_phone_number");
        try {
            int lc = 0;
            while (lexer.hasMoreChars()) {
                char w = lexer.lookAhead(0);
                if (Lexer.isDigit(w)
                    || w == '-'
                    || w == '.'
                    || w == '('
                    || w == ')') {
                    lexer.consume(1);
                    s.append(w);
                    lc++;
                } else if (lc > 0)
                    break;
                else
                    throw createParseException("unexpected " + w);
            }
            return s.toString();
        } finally {
            if (debug)
                dbg_leave("base_phone_number");
        }

    }

    /**
     * Parser for the local phone #.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.498 -0500", hash_original_method = "0C6D1452631B0ABABC52FCC37CE65FF7", hash_generated_method = "9CC6E52B6C6B6AA593DB3A674423C42E")
    
private String local_number() throws ParseException {
        StringBuffer s = new StringBuffer();
        if (debug)
            dbg_enter("local_number");
        try {
            int lc = 0;
            while (lexer.hasMoreChars()) {
                char la = lexer.lookAhead(0);
                if (la == '*'
                    || la == '#'
                    || la == '-'
                    || la == '.'
                    || la == '('
                    || la == ')'
                        // JvB: allow 'A'..'F', should be uppercase
                    || Lexer.isHexDigit(la)) {
                    lexer.consume(1);
                    s.append(la);
                    lc++;
                } else if (lc > 0)
                    break;
                else
                    throw createParseException("unexepcted " + la);
            }
            return s.toString();
        } finally {
            if (debug)
                dbg_leave("local_number");
        }

    }

    /**
     * Parser for telephone subscriber.
     *
     * @return the parsed telephone number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.501 -0500", hash_original_method = "DEDDF1126FB4D34419E3541D3DE0EAF4", hash_generated_method = "2B9870CC5ED016B0226F139B021BA3AB")
    
public final TelephoneNumber parseTelephoneNumber( boolean inBrackets ) 
    	throws ParseException {
        TelephoneNumber tn;

        if (debug)
            dbg_enter("telephone_subscriber");
        lexer.selectLexer("charLexer");
        try {
            char c = lexer.lookAhead(0);
            if (c == '+')
                tn = global_phone_number( inBrackets );
            else if (
                Lexer.isHexDigit(c)// see RFC3966
                    || c == '#'
                    || c == '*'
                    || c == '-'
                    || c == '.'
                    || c == '('
                    || c == ')' ) {
                tn = local_phone_number( inBrackets );
            } else
                throw createParseException("unexpected char " + c);
            return tn;
        } finally {
            if (debug)
                dbg_leave("telephone_subscriber");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.504 -0500", hash_original_method = "0F1ADEC60659CEA5C84BABEF7D06F081", hash_generated_method = "706CF5EC819AD786F25546E4156D6BC0")
    
private final TelephoneNumber global_phone_number( boolean inBrackets ) throws ParseException {
        if (debug)
            dbg_enter("global_phone_number");
        try {
            TelephoneNumber tn = new TelephoneNumber();
            tn.setGlobal(true);
            NameValueList nv = null;
            this.lexer.match(PLUS);
            String b = base_phone_number();
            tn.setPhoneNumber(b);
            if (lexer.hasMoreChars()) {
                char tok = lexer.lookAhead(0);
                if (tok == ';' && inBrackets) {
                    this.lexer.consume(1);
                    nv = tel_parameters();
                    tn.setParameters(nv);
                }
            }
            return tn;
        } finally {
            if (debug)
                dbg_leave("global_phone_number");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.507 -0500", hash_original_method = "883FF19CD75AFF340396001C616EFCAA", hash_generated_method = "B131F4B14E0003573B1D951687E1B53F")
    
private TelephoneNumber local_phone_number( boolean inBrackets ) throws ParseException {
        if (debug)
            dbg_enter("local_phone_number");
        TelephoneNumber tn = new TelephoneNumber();
        tn.setGlobal(false);
        NameValueList nv = null;
        String b = null;
        try {
            b = local_number();
            tn.setPhoneNumber(b);
            if (lexer.hasMoreChars()) {
                Token tok = this.lexer.peekNextToken();
                switch (tok.getTokenType()) {
                    case SEMICOLON:
                        {
                        	if (inBrackets) {
                        		this.lexer.consume(1);
                        		nv = tel_parameters();
                        		tn.setParameters(nv);
                        	}
                            break;
                        }
                    default :
                        {
                            break;
                        }
                }
            }
        } finally {
            if (debug)
                dbg_leave("local_phone_number");
        }
        return tn;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.510 -0500", hash_original_method = "F5BCCE1D5E357F2A71ACB92ADA6046C2", hash_generated_method = "A77E00A603A19DBF2B618F4A5576C61D")
    
private NameValueList tel_parameters() throws ParseException {
        NameValueList nvList = new NameValueList();

        // JvB: Need to handle 'phone-context' specially
        // 'isub' (or 'ext') MUST appear first, but we accept any order here
        NameValue nv;
        while ( true ) {
            String pname = paramNameOrValue();

            // Handle 'phone-context' specially, it may start with '+'
            if ( pname.equalsIgnoreCase("phone-context")) {
                nv = phone_context();
            } else {
                if (lexer.lookAhead(0) == '=') {
                    lexer.consume(1);
                    String value = paramNameOrValue();
                    nv = new NameValue( pname, value, false );
                } else {
                    nv = new NameValue( pname, "", true );// flag param
                }
            }
            nvList.set( nv );

            if ( lexer.lookAhead(0) == ';' ) {
                lexer.consume(1);
            } else {
                return nvList;
            }
        }

    }

    /**
     * Parses the 'phone-context' parameter in tel: URLs
     * @throws ParseException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.513 -0500", hash_original_method = "4B2DA37312785E9B10734C6846FECD1E", hash_generated_method = "50A1AD970DEFC6048EA99E78FE6BABC6")
    
private NameValue phone_context() throws ParseException {
        lexer.match('=');

        char la = lexer.lookAhead(0);
        Object value;
        if (la=='+') {// global-number-digits
            lexer.consume(1);// skip '+'
            value = "+" + base_phone_number();
        } else if ( Lexer.isAlphaDigit(la) ) {
            Token t = lexer.match( Lexer.ID );// more broad than allowed
            value = t.getTokenValue();
        } else {
            throw new ParseException( "Invalid phone-context:" + la , -1 );
        }
        return new NameValue( "phone-context", value, false );
    }

    /**
     * Parse and return a structure for a Tel URL.
     * @return a parsed tel url structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.516 -0500", hash_original_method = "73C5F5A1DB2F1724F7BD39D759918D7C", hash_generated_method = "B7E384896B37F4E6D4D4D652B8D232A7")
    
public TelURLImpl telURL( boolean inBrackets ) throws ParseException {
        lexer.match(TokenTypes.TEL);
        lexer.match(':');
        TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        TelURLImpl telUrl = new TelURLImpl();
        telUrl.setTelephoneNumber(tn);
        return telUrl;

    }

    /**
     * Parse and return a structure for a SIP URL.
     * @return a URL structure for a SIP url.
     * @throws ParseException if there was a problem parsing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.520 -0500", hash_original_method = "7278F7A930851B1FF266754B78180AE2", hash_generated_method = "24B3530AF7E11112C98142AB28B31EE8")
    
public SipUri sipURL( boolean inBrackets ) throws ParseException {
        if (debug)
            dbg_enter("sipURL");
        SipUri retval = new SipUri();
        // pmusgrave - handle sips case
        Token nextToken = lexer.peekNextToken();
        int sipOrSips = TokenTypes.SIP;
        String scheme = TokenNames.SIP;
        if ( nextToken.getTokenType() == TokenTypes.SIPS)
        {
            sipOrSips = TokenTypes.SIPS;
            scheme = TokenNames.SIPS;
        }

        try {
            lexer.match(sipOrSips);
            lexer.match(':');
            retval.setScheme(scheme);
            int startOfUser = lexer.markInputPosition();
            String userOrHost = user();// Note: user may contain ';', host may not...
            String passOrPort = null;

            // name:password or host:port
            if ( lexer.lookAhead() == ':' ) {
                lexer.consume(1);
                passOrPort = password();
            }

            // name@hostPort
            if ( lexer.lookAhead() == '@' ) {
                lexer.consume(1);
                retval.setUser( userOrHost );
                if (passOrPort!=null) retval.setUserPassword( passOrPort );
            } else {
                // then userOrHost was a host, backtrack just in case a ';' was eaten...
                lexer.rewindInputPosition( startOfUser );
            }

            HostNameParser hnp = new HostNameParser(this.getLexer());
            HostPort hp = hnp.hostPort( false );
            retval.setHostPort(hp);

            lexer.selectLexer("charLexer");
            while (lexer.hasMoreChars()) {
            	// If the URI is not enclosed in brackets, parameters belong to header
                if (lexer.lookAhead(0) != ';' || !inBrackets)
                    break;
                lexer.consume(1);
                NameValue parms = uriParam();
                if (parms != null) retval.setUriParameter(parms);
            }

            if (lexer.hasMoreChars() && lexer.lookAhead(0) == '?') {
                lexer.consume(1);
                while (lexer.hasMoreChars()) {
                    NameValue parms = qheader();
                    retval.setQHeader(parms);
                    if (lexer.hasMoreChars() && lexer.lookAhead(0) != '&')
                        break;
                    else
                        lexer.consume(1);
                }
            }
            return retval;
        } finally {
            if (debug)
                dbg_leave("sipURL");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.523 -0500", hash_original_method = "A1AFDB81F6A99AEF965D53D1558A830F", hash_generated_method = "41344050661930E9761FDBD27664260D")
    
public String peekScheme() throws ParseException {
        Token[] tokens = lexer.peekNextToken(1);
        if (tokens.length == 0)
            return null;
        String scheme = ((Token) tokens[0]).getTokenValue();
        return scheme;
    }

    /**
     * Get a name value for a given query header (ie one that comes
     * after the ?).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.525 -0500", hash_original_method = "8CC59A12163BED34BD1BF794F4FF4839", hash_generated_method = "0C6ABD7106EB30CEC8CE93DCC3AE4141")
    
protected NameValue qheader() throws ParseException {
        String name = lexer.getNextToken('=');
        lexer.consume(1);
        String value = hvalue();
        return new NameValue(name, value, false);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.528 -0500", hash_original_method = "44D1D496E84DF1E5395D6148A081CABE", hash_generated_method = "598A14E484F50147B435FD4758739442")
    
protected String hvalue() throws ParseException {
        StringBuffer retval = new StringBuffer();
        while (lexer.hasMoreChars()) {
            char la = lexer.lookAhead(0);
            // Look for a character that can terminate a URL.
            boolean isValidChar = false;
            switch (la) {
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
            }
            if (isValidChar || Lexer.isAlphaDigit(la)) {
                lexer.consume(1);
                retval.append(la);
            } else if (la == '%') {
                retval.append(escaped());
            } else
                break;
        }
        return retval.toString();
    }

    /**
     * Scan forward until you hit a terminating character for a URL.
     * We do not handle non sip urls in this implementation.
     * @return the string that takes us to the end of this URL (i.e. to
     * the next delimiter).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.531 -0500", hash_original_method = "ECAD9C42756FF84B730590BF5F3636AE", hash_generated_method = "724163EF298FFE71935F24A4D2157983")
    
protected String urlString() throws ParseException {
        StringBuffer retval = new StringBuffer();
        lexer.selectLexer("charLexer");

        while (lexer.hasMoreChars()) {
            char la = lexer.lookAhead(0);
            // Look for a character that can terminate a URL.
            if (la == ' '
                || la == '\t'
                || la == '\n'
                || la == '>'
                || la == '<')
                break;
            lexer.consume(0);
            retval.append(la);
        }
        return retval.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.533 -0500", hash_original_method = "9AA60F60D9528CA4DF3AB8B29A4A0237", hash_generated_method = "8F8A40752C7A6879BFCD11D43B961A1A")
    
protected String user() throws ParseException {
        if (debug)
            dbg_enter("user");
        try {
            int startIdx = lexer.getPtr();
            while (lexer.hasMoreChars()) {
                char la = lexer.lookAhead(0);
                if (isUnreserved(la) || isUserUnreserved(la)) {
                    lexer.consume(1);
                } else if (isEscaped()) {
                    lexer.consume(3);
                } else
                    break;
            }
            return lexer.getBuffer().substring(startIdx, lexer.getPtr());
        } finally {
            if (debug)
                dbg_leave("user");
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.536 -0500", hash_original_method = "763B089E3F9716D78CD9674F5B515450", hash_generated_method = "210D0BF1D424A7BD184E930C8625417C")
    
protected String password() throws ParseException {
        int startIdx = lexer.getPtr();
        while (true) {
            char la = lexer.lookAhead(0);
            boolean isValidChar = false;
            switch (la) {
                case '&':
                case '=':
                case '+':
                case '$':
                case ',':
                    isValidChar = true;
            }
            if (isValidChar || isUnreserved(la)) {
                lexer.consume(1);
            } else if (isEscaped()) {
                lexer.consume(3); // bug reported by
                                // Jeff Haynie
            } else
                break;

        }
        return lexer.getBuffer().substring(startIdx, lexer.getPtr());
    }

    /**
     * Default parse method. This method just calls uriReference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:45.538 -0500", hash_original_method = "A2F63CC3A1AD0DF2925153B5F3ECB644", hash_generated_method = "794DAEAA0AA0F6D712FE329AACBE8206")
    
public GenericURI parse() throws ParseException {
        return uriReference( true );
    }

    
}

