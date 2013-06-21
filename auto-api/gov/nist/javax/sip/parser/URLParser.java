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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.679 -0400", hash_original_method = "02D762C7659C29C6C28E615D4F3B4986", hash_generated_method = "CC19D458C6D45954DB91858D58BFC54A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URLParser(String url) {
        dsTaint.addTaint(url);
        this.lexer = new Lexer("sip_urlLexer", url);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("sip_urlLexer", url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.679 -0400", hash_original_method = "FF384429583BB1654143EB8FA592B141", hash_generated_method = "4BC85498A9D86EADEE5DECE84125ACC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URLParser(Lexer lexer) {
        dsTaint.addTaint(lexer.dsTaint);
        this.lexer = lexer;
        this.lexer.selectLexer("sip_urlLexer");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.680 -0400", hash_original_method = "8FE92D5DF4A5AF3ADE92B1ED26FEEDBE", hash_generated_method = "6BC14D80E569C82745EF2DC92C0BE6F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String unreserved() throws ParseException {
        char next;
        next = lexer.lookAhead(0);
        {
            boolean var1389A34E9A875BE3049166D07D13716A_1732370376 = (isUnreserved(next));
            {
                lexer.consume(1);
                String var0B07531530222147A92BE6062F38A56B_2052899518 = (String.valueOf(next));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw createParseException("unreserved");
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isUnreserved(next)) {
            //lexer.consume(1);
            //return String.valueOf(next);
        //} else
            //throw createParseException("unreserved");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.681 -0400", hash_original_method = "1041AA48D060026BCCD13967429C5BF3", hash_generated_method = "5929B19549F1429FE4E6ED417F6F1508")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String paramNameOrValue() throws ParseException {
        int startIdx;
        startIdx = lexer.getPtr();
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_342480316 = (lexer.hasMoreChars());
            {
                char next;
                next = lexer.lookAhead(0);
                boolean isValidChar;
                isValidChar = false;
                //Begin case '[' ']' '/' ':' '&' '+' '$' 
                isValidChar = true;
                //End case '[' ']' '/' ':' '&' '+' '$' 
                {
                    boolean varEBB6542C58D63C944BB22BBBEBD45AAF_656159890 = (isValidChar || isUnreserved(next));
                    {
                        lexer.consume(1);
                    } //End block
                    {
                        boolean varF7C5BA76C493C7F02FA07B27C1AF3316_623349192 = (isEscaped());
                        {
                            lexer.consume(3);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String var8BBE38D283B56B0D5F053B2EF75BA637_1877195699 = (lexer.getBuffer().substring(startIdx, lexer.getPtr()));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.681 -0400", hash_original_method = "28DEAB6489C56D85C58F2548442629A5", hash_generated_method = "D54ED566090FCDAB195D56943D4BA264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NameValue uriParam() throws ParseException {
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
                boolean varA946C0818D54984040C780DFCE924753_342120722 = (pname.length() == 0 &&
                ( pvalue == null ||
                pvalue.length() == 0));
                NameValue var7136089CC4C658ABBF584736DDDB59DA_1107588052 = (new NameValue(pname, pvalue, isFlagParam));
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("uriParam");
        } //End block
        return (NameValue)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.681 -0400", hash_original_method = "FFA1DEBB1A42288CA22D82A97ACC067B", hash_generated_method = "5BF28D49C601700470AD9AE2C25CC7B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String reserved() throws ParseException {
        char next;
        next = lexer.lookAhead(0);
        {
            boolean varAE7675CD56F874911E26881E5AAACF61_588169082 = (isReserved(next));
            {
                lexer.consume(1);
                String var64C5F2166C7AD8AFC15B9D42FD888907_1935370777 = (new StringBuffer().append(next).toString());
            } //End block
            if (DroidSafeAndroidRuntime.control) throw createParseException("reserved");
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //char next = lexer.lookAhead(0);
        //if (isReserved(next)) {
            //lexer.consume(1);
            //return new StringBuffer().append(next).toString();
        //} else
            //throw createParseException("reserved");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.682 -0400", hash_original_method = "B69B97990375B5870393017EB399692B", hash_generated_method = "BE32BC9BBC6D00DBDD68B1ADD447760A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isEscaped() {
        try 
        {
            boolean var3F9254A4E7823F8753251F2B55C56EF1_1028691065 = (lexer.lookAhead(0) == '%' &&
                Lexer.isHexDigit(lexer.lookAhead(1)) &&
                Lexer.isHexDigit(lexer.lookAhead(2)));
        } //End block
        catch (Exception ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return lexer.lookAhead(0) == '%' &&
                //Lexer.isHexDigit(lexer.lookAhead(1)) &&
                //Lexer.isHexDigit(lexer.lookAhead(2));
        //} catch (Exception ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.682 -0400", hash_original_method = "08A77A9FB0F42402334D6E5EC1EEFB98", hash_generated_method = "48AF1378B0EEA55CA783763434B811EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String escaped() throws ParseException {
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
                boolean var60B80A984C77CCEA3BBF72B827F48A07_677863063 = (next == '%'
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
            String var483CEEB9C5A7974916DC48CE5ADA42C7_987899515 = (retval.toString());
        } //End block
        finally 
        {
            dbg_leave("escaped");
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.682 -0400", hash_original_method = "743AFD3B213C469742C3C78020E0DBC1", hash_generated_method = "04AFA47CCED6202FD8EE93F6C54A20F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String mark() throws ParseException {
        dbg_enter("mark");
        try 
        {
            char next;
            next = lexer.lookAhead(0);
            {
                boolean varE0C748D002BB162804157081E5A97AF7_75543284 = (isMark(next));
                {
                    lexer.consume(1);
                    String var6C4438755E22FDE9EE931BA6C9BC8617_192288934 = (new String( new char[]{next} ));
                } //End block
                if (DroidSafeAndroidRuntime.control) throw createParseException("mark");
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("mark");
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.683 -0400", hash_original_method = "589C84A9F2E2E16C04FA96C5BE216A43", hash_generated_method = "A3B74C29A8FDC71611DD8FF40683641B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String uric() {
        dbg_enter("uric");
        try 
        {
            try 
            {
                char la;
                la = lexer.lookAhead(0);
                {
                    boolean var4DEDA407E3BC616B4A5AC7CEF8C961B8_651726836 = (isUnreserved(la));
                    {
                        lexer.consume(1);
                        String var04A8FCEDD3DB55C764109166163F25AD_1997251537 = (Lexer.charAsString(la));
                    } //End block
                    {
                        boolean var967F4E910D4BCCE057AC7DAD96CB80FB_575844771 = (isReserved(la));
                        {
                            lexer.consume(1);
                            String var972E5CA9107B3079D110D8987823CC29_1944639007 = (Lexer.charAsString(la));
                        } //End block
                        {
                            boolean var7DDEF0E08361E9C02AADC7953802FC99_1420375892 = (isEscaped());
                            {
                                String retval;
                                retval = lexer.charAsString(3);
                                lexer.consume(3);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            catch (Exception ex)
            { }
        } //End block
        finally 
        {
            dbg_leave("uric");
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.683 -0400", hash_original_method = "C9EA734307D4CD12B7093594DF2E8530", hash_generated_method = "DCBCD8E83CCEABC23EE4F1FB8CFEEDCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String uricNoSlash() {
        dbg_enter("uricNoSlash");
        try 
        {
            try 
            {
                char la;
                la = lexer.lookAhead(0);
                {
                    boolean varD0BEBBDFA3B284B77894A2ED39B07738_2020695697 = (isEscaped());
                    {
                        String retval;
                        retval = lexer.charAsString(3);
                        lexer.consume(3);
                    } //End block
                    {
                        boolean var7C808D9F6303ECB25ED4BAECB34B9B56_2124261010 = (isUnreserved(la));
                        {
                            lexer.consume(1);
                            String var972E5CA9107B3079D110D8987823CC29_128495703 = (Lexer.charAsString(la));
                        } //End block
                        {
                            boolean varCAF58582C5F6188CEA5D8F016BCE21F5_1065170082 = (isReservedNoSlash(la));
                            {
                                lexer.consume(1);
                                String varFBCE0F21194BE37F95023F9AC9051D18_938280825 = (Lexer.charAsString(la));
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            catch (ParseException ex)
            { }
        } //End block
        finally 
        {
            dbg_leave("uricNoSlash");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.683 -0400", hash_original_method = "F8BFDE8FCAA82A1A34C46F55D7711C6B", hash_generated_method = "0407F083FF8A6D58AC46C1E3958D2D61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String uricString() throws ParseException {
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
        String var0F1F65BA89BF920BA1A29FC87F91B969_1498677280 = (retval.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.684 -0400", hash_original_method = "877793596C03075095766EB10627CE12", hash_generated_method = "FABC0EFD37AB2D40B7807DC48D50C621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GenericURI uriReference( boolean inBrackets ) throws ParseException {
        dsTaint.addTaint(inBrackets);
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
                boolean var3E3C08E681A70CFCD29256F591BA9F85_1526859636 = (t1.getTokenType() == TokenTypes.SIP ||
                    t1.getTokenType() == TokenTypes.SIPS);
                {
                    {
                        boolean var19C34D70DBF4E04E87D5E554663CED0B_945016295 = (t2.getTokenType() == ':');
                        retval = sipURL( inBrackets );
                        if (DroidSafeAndroidRuntime.control) throw createParseException("Expecting \':\'");
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var9DCC9A019F767A37C0CD3E2554D567B2_1692110700 = (t1.getTokenType() == TokenTypes.TEL);
                    {
                        {
                            boolean var6E0AC27A3BCD64EF8F081ACBDDD022E3_874275852 = (t2.getTokenType() == ':');
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
        return (GenericURI)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.685 -0400", hash_original_method = "FA28BF7ACB321CCE37D931F114A366BD", hash_generated_method = "AB6A09E17B134E4E3C94946243B12B7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String base_phone_number() throws ParseException {
        StringBuffer s;
        s = new StringBuffer();
        dbg_enter("base_phone_number");
        try 
        {
            int lc;
            lc = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1690496247 = (lexer.hasMoreChars());
                {
                    char w;
                    w = lexer.lookAhead(0);
                    {
                        boolean var558B9976D373EA13678F300ACFC57D1F_161811043 = (Lexer.isDigit(w)
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
            String varA1B485F703F905A168BAEB58087F4368_1939841827 = (s.toString());
        } //End block
        finally 
        {
            dbg_leave("base_phone_number");
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.685 -0400", hash_original_method = "0C6D1452631B0ABABC52FCC37CE65FF7", hash_generated_method = "D2C46631481E8307EF105A804CFCB8B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String local_number() throws ParseException {
        StringBuffer s;
        s = new StringBuffer();
        dbg_enter("local_number");
        try 
        {
            int lc;
            lc = 0;
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1989767319 = (lexer.hasMoreChars());
                {
                    char la;
                    la = lexer.lookAhead(0);
                    {
                        boolean var20C700F69E25677794711EF4694FACAC_260079121 = (la == '*'
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
            String varA1B485F703F905A168BAEB58087F4368_558664172 = (s.toString());
        } //End block
        finally 
        {
            dbg_leave("local_number");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.686 -0400", hash_original_method = "DEDDF1126FB4D34419E3541D3DE0EAF4", hash_generated_method = "C212E67F912D4E463E195F1A80C6FD94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TelephoneNumber parseTelephoneNumber( boolean inBrackets ) throws ParseException {
        dsTaint.addTaint(inBrackets);
        TelephoneNumber tn;
        dbg_enter("telephone_subscriber");
        lexer.selectLexer("charLexer");
        try 
        {
            char c;
            c = lexer.lookAhead(0);
            tn = global_phone_number( inBrackets );
            {
                boolean var507D5F8498D0167D369439A5884A0378_662319004 = (Lexer.isHexDigit(c)
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
        } //End block
        finally 
        {
            dbg_leave("telephone_subscriber");
        } //End block
        return (TelephoneNumber)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.686 -0400", hash_original_method = "0F1ADEC60659CEA5C84BABEF7D06F081", hash_generated_method = "DBF543E6FC6404F67F5614489405DA46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final TelephoneNumber global_phone_number( boolean inBrackets ) throws ParseException {
        dsTaint.addTaint(inBrackets);
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
                boolean var9783FB04504A12AC5E4CB1806E828D43_396533312 = (lexer.hasMoreChars());
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
        } //End block
        finally 
        {
            dbg_leave("global_phone_number");
        } //End block
        return (TelephoneNumber)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.686 -0400", hash_original_method = "883FF19CD75AFF340396001C616EFCAA", hash_generated_method = "56E9CC7792E0D65BFCC3A86A854D4599")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TelephoneNumber local_phone_number( boolean inBrackets ) throws ParseException {
        dsTaint.addTaint(inBrackets);
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
                boolean var9783FB04504A12AC5E4CB1806E828D43_955055328 = (lexer.hasMoreChars());
                {
                    Token tok;
                    tok = this.lexer.peekNextToken();
                    {
                        Object varD3D97B347F6C533E598B0CFBC725AF99_563688543 = (tok.getTokenType());
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
        return (TelephoneNumber)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.687 -0400", hash_original_method = "F5BCCE1D5E357F2A71ACB92ADA6046C2", hash_generated_method = "DA17F9DE241F4097E922B99855CB2EAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NameValueList tel_parameters() throws ParseException {
        NameValueList nvList;
        nvList = new NameValueList();
        NameValue nv;
        {
            String pname;
            pname = paramNameOrValue();
            {
                boolean varC10FDE306D9280D8B230EFFEBE7BBCAD_570560396 = (pname.equalsIgnoreCase("phone-context"));
                {
                    nv = phone_context();
                } //End block
                {
                    {
                        boolean var58840CF471CB22F21A5C8437922569C5_911192292 = (lexer.lookAhead(0) == '=');
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
                boolean var23D2B54EEDE70417D1C6C30933AF4A72_1487992111 = (lexer.lookAhead(0) == ';');
                {
                    lexer.consume(1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (NameValueList)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.687 -0400", hash_original_method = "4B2DA37312785E9B10734C6846FECD1E", hash_generated_method = "B8D51BCC69A9153182E64A7A6B820036")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NameValue phone_context() throws ParseException {
        lexer.match('=');
        char la;
        la = lexer.lookAhead(0);
        Object value;
        {
            lexer.consume(1);
            value = "+" + base_phone_number();
        } //End block
        {
            boolean varCB62C5C9B3FAF6D4CFE708D2749449C5_127678226 = (Lexer.isAlphaDigit(la));
            {
                Token t;
                t = lexer.match( Lexer.ID );
                value = t.getTokenValue();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException( "Invalid phone-context:" + la , -1 );
            } //End block
        } //End collapsed parenthetic
        NameValue varD9C9DC119243641067BFC1F47315B070_522056345 = (new NameValue( "phone-context", value, false ));
        return (NameValue)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.687 -0400", hash_original_method = "73C5F5A1DB2F1724F7BD39D759918D7C", hash_generated_method = "E0C2618FBD00CCF344F0EE10930DA6C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TelURLImpl telURL( boolean inBrackets ) throws ParseException {
        dsTaint.addTaint(inBrackets);
        lexer.match(TokenTypes.TEL);
        lexer.match(':');
        TelephoneNumber tn;
        tn = this.parseTelephoneNumber(inBrackets);
        TelURLImpl telUrl;
        telUrl = new TelURLImpl();
        telUrl.setTelephoneNumber(tn);
        return (TelURLImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //lexer.match(TokenTypes.TEL);
        //lexer.match(':');
        //TelephoneNumber tn = this.parseTelephoneNumber(inBrackets);
        //TelURLImpl telUrl = new TelURLImpl();
        //telUrl.setTelephoneNumber(tn);
        //return telUrl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.688 -0400", hash_original_method = "7278F7A930851B1FF266754B78180AE2", hash_generated_method = "761E01ED062010029854402977574D0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipUri sipURL( boolean inBrackets ) throws ParseException {
        dsTaint.addTaint(inBrackets);
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
            boolean var428A8649D9DE71F3027322B0FB5BC374_455215891 = (nextToken.getTokenType() == TokenTypes.SIPS);
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
                boolean varA481248E93D84F444CD01FB31AAFDF62_1400950069 = (lexer.lookAhead() == ':');
                {
                    lexer.consume(1);
                    passOrPort = password();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var8F99848E84C59D67D6EAE42041875FCD_332609508 = (lexer.lookAhead() == '@');
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
                boolean var9783FB04504A12AC5E4CB1806E828D43_2107421208 = (lexer.hasMoreChars());
                {
                    {
                        boolean var586A81C98915AF015E02FB22E05826EF_202995503 = (lexer.lookAhead(0) != ';' || !inBrackets);
                    } //End collapsed parenthetic
                    lexer.consume(1);
                    NameValue parms;
                    parms = uriParam();
                    retval.setUriParameter(parms);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var7C875628E08B715321EFB433C7824D95_1111588736 = (lexer.hasMoreChars() && lexer.lookAhead(0) == '?');
                {
                    lexer.consume(1);
                    {
                        boolean var4CB791BD05839AFD9F3514E9302D9DE3_1300890448 = (lexer.hasMoreChars());
                        {
                            NameValue parms;
                            parms = qheader();
                            retval.setQHeader(parms);
                            {
                                boolean var052F98E1E244F24861DEF6838918EED5_719281 = (lexer.hasMoreChars() && lexer.lookAhead(0) != '&');
                                lexer.consume(1);
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("sipURL");
        } //End block
        return (SipUri)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.688 -0400", hash_original_method = "A1AFDB81F6A99AEF965D53D1558A830F", hash_generated_method = "0E859429B229DAA35A589195709EA261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String peekScheme() throws ParseException {
        Token[] tokens;
        tokens = lexer.peekNextToken(1);
        String scheme;
        scheme = ((Token) tokens[0]).getTokenValue();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Token[] tokens = lexer.peekNextToken(1);
        //if (tokens.length == 0)
            //return null;
        //String scheme = ((Token) tokens[0]).getTokenValue();
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.688 -0400", hash_original_method = "8CC59A12163BED34BD1BF794F4FF4839", hash_generated_method = "ADB906AC8D001227154938F82DDF99F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected NameValue qheader() throws ParseException {
        String name;
        name = lexer.getNextToken('=');
        lexer.consume(1);
        String value;
        value = hvalue();
        NameValue var67EE4685FE7338F821A30DFA000F3631_1623917828 = (new NameValue(name, value, false));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String name = lexer.getNextToken('=');
        //lexer.consume(1);
        //String value = hvalue();
        //return new NameValue(name, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.689 -0400", hash_original_method = "44D1D496E84DF1E5395D6148A081CABE", hash_generated_method = "E89CF9761BEA113C9646176963A7DC87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String hvalue() throws ParseException {
        StringBuffer retval;
        retval = new StringBuffer();
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_225551109 = (lexer.hasMoreChars());
            {
                char la;
                la = lexer.lookAhead(0);
                boolean isValidChar;
                isValidChar = false;
                //Begin case '+' '?' ':' '[' ']' '/' '$' '_' '-' '"' '!' '~' '*' '.' '(' ')' 
                isValidChar = true;
                //End case '+' '?' ':' '[' ']' '/' '$' '_' '-' '"' '!' '~' '*' '.' '(' ')' 
                {
                    boolean var8510A3B3F6999B2E9C748C1C619B9E8B_1500665753 = (isValidChar || Lexer.isAlphaDigit(la));
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
        String var0F1F65BA89BF920BA1A29FC87F91B969_1968475130 = (retval.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.689 -0400", hash_original_method = "ECAD9C42756FF84B730590BF5F3636AE", hash_generated_method = "C568E5C0073E68DDA5FC607C16A0882A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String urlString() throws ParseException {
        StringBuffer retval;
        retval = new StringBuffer();
        lexer.selectLexer("charLexer");
        {
            boolean varB3E35DF23794987B0693F5DD7A2B9357_1743712816 = (lexer.hasMoreChars());
            {
                char la;
                la = lexer.lookAhead(0);
                lexer.consume(0);
                retval.append(la);
            } //End block
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_1877900380 = (retval.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.689 -0400", hash_original_method = "9AA60F60D9528CA4DF3AB8B29A4A0237", hash_generated_method = "1AB2E2CE188B04955CDA00D61C4C5C77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String user() throws ParseException {
        dbg_enter("user");
        try 
        {
            int startIdx;
            startIdx = lexer.getPtr();
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_2094303563 = (lexer.hasMoreChars());
                {
                    char la;
                    la = lexer.lookAhead(0);
                    {
                        boolean var8FDE9D716FC62805FC36EA151FDB086E_1292660127 = (isUnreserved(la) || isUserUnreserved(la));
                        {
                            lexer.consume(1);
                        } //End block
                        {
                            boolean var7DDEF0E08361E9C02AADC7953802FC99_643169616 = (isEscaped());
                            {
                                lexer.consume(3);
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            String varDC062448BADF9B5EA4A40E76B609D6D5_1561116175 = (lexer.getBuffer().substring(startIdx, lexer.getPtr()));
        } //End block
        finally 
        {
            dbg_leave("user");
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.690 -0400", hash_original_method = "763B089E3F9716D78CD9674F5B515450", hash_generated_method = "FA37D7DE9A257CD132D07E6798679E54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String password() throws ParseException {
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
                boolean var042E4D2F12E6FAE99880DE236F6282DE_502720366 = (isValidChar || isUnreserved(la));
                {
                    lexer.consume(1);
                } //End block
                {
                    boolean varD0BEBBDFA3B284B77894A2ED39B07738_1950052813 = (isEscaped());
                    {
                        lexer.consume(3);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        String var8BBE38D283B56B0D5F053B2EF75BA637_1016166489 = (lexer.getBuffer().substring(startIdx, lexer.getPtr()));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.690 -0400", hash_original_method = "A2F63CC3A1AD0DF2925153B5F3ECB644", hash_generated_method = "946227F897E4207CE836F844AD6FD856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GenericURI parse() throws ParseException {
        GenericURI var8D744C0E01AC5464FF8E84A31D113DDA_105575398 = (uriReference( true ));
        return (GenericURI)dsTaint.getTaint();
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

