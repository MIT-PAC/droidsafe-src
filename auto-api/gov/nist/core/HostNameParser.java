package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public class HostNameParser extends ParserCore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.166 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.170 -0400", hash_original_method = "BDF66B8A6A6E733FD4317463FD36B54D", hash_generated_method = "E6190D95AF09B5C58BFF34773236830D")
    public  HostNameParser(String hname) {
        this.lexer = new LexerCore("charLexer", hname);
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        addTaint(hname.getTaint());
        // ---------- Original Method ----------
        //this.lexer = new LexerCore("charLexer", hname);
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.175 -0400", hash_original_method = "DE9D0F52F3286ED66509E4F5CE87141D", hash_generated_method = "EC6DD46E0D41FAD9C9496A5F35065F0B")
    public  HostNameParser(LexerCore lexer) {
        this.lexer = lexer;
        lexer.selectLexer("charLexer");
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //lexer.selectLexer("charLexer");
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.176 -0400", hash_original_method = "4DE693D4586CFA412C55EF35C3691C08", hash_generated_method = "DBA796E5CE34881D94534DF82F8B2BCD")
    protected void consumeDomainLabel() throws ParseException {
        dbg_enter("domainLabel");
        try 
        {
            lexer.consumeValidChars(VALID_DOMAIN_LABEL_CHAR);
        } //End block
        finally 
        {
            dbg_leave("domainLabel");
        } //End block
        // ---------- Original Method ----------
        //if (debug)
            //dbg_enter("domainLabel");
        //try {
            //lexer.consumeValidChars(VALID_DOMAIN_LABEL_CHAR);
        //} finally {
            //if (debug)
                //dbg_leave("domainLabel");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.194 -0400", hash_original_method = "12990E16E23A1648F6B6EE2410C75196", hash_generated_method = "3B477BDC83215F8D5F5515AFF0878065")
    protected String ipv6Reference() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_1434326285 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1816203162 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_927329479 = null; //Variable for return #3
        StringBuffer retval;
        retval = new StringBuffer();
        dbg_enter("ipv6Reference");
        try 
        {
            {
                {
                    boolean var255E8660353F5362DB4A60C2DDB0C461_59975736 = (lexer.hasMoreChars());
                    {
                        char la;
                        la = lexer.lookAhead(0);
                        {
                            boolean var994371892917A87989057591FFA23B92_318701294 = (LexerCore.isHexDigit(la) || la == '.' || la == ':'
                            || la == '[');
                            {
                                lexer.consume(1);
                                retval.append(la);
                            } //End block
                            {
                                lexer.consume(1);
                                retval.append(la);
                                varB4EAC82CA7396A68D541C85D26508E83_1434326285 = retval.toString();
                            } //End block
                            {
                                lexer.consume(1);
                                String rest;
                                rest = lexer.getRest();
                                {
                                    boolean varDA96287E1E04F81963DCAB3B1D387F7E_548280544 = (rest == null || rest.length() == 0);
                                } //End collapsed parenthetic
                                int stripLen;
                                stripLen = rest.indexOf(']');
                                lexer.consume(stripLen+1);
                                retval.append("]");
                                varB4EAC82CA7396A68D541C85D26508E83_1816203162 = retval.toString();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var255E8660353F5362DB4A60C2DDB0C461_322838417 = (lexer.hasMoreChars());
                    {
                        char la;
                        la = lexer.lookAhead(0);
                        {
                            boolean var2AC4EE193842A47EBFC6B489F345C5C3_1179157563 = (LexerCore.isHexDigit(la) || la == '.'
                            || la == ':' || la == '[');
                            {
                                lexer.consume(1);
                                retval.append(la);
                            } //End block
                            {
                                lexer.consume(1);
                                retval.append(la);
                                varB4EAC82CA7396A68D541C85D26508E83_927329479 = retval.toString();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ParseException(
                lexer.getBuffer() + ": Illegal Host name ",
                lexer.getPtr());
        } //End block
        finally 
        {
            dbg_leave("ipv6Reference");
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1343878004; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1343878004 = varB4EAC82CA7396A68D541C85D26508E83_1434326285;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1343878004 = varB4EAC82CA7396A68D541C85D26508E83_1816203162;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1343878004 = varB4EAC82CA7396A68D541C85D26508E83_927329479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1343878004.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1343878004;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.200 -0400", hash_original_method = "59E4521A394425B7E70180091A99EC01", hash_generated_method = "7779F7BDA2D7A9A26D047B8B81A3B300")
    public Host host() throws ParseException {
        Host varB4EAC82CA7396A68D541C85D26508E83_825966942 = null; //Variable for return #1
        dbg_enter("host");
        try 
        {
            String hostname;
            {
                boolean var7F8AD6B3877B097A231B70CAA2872139_1040210046 = (lexer.lookAhead(0) == '[');
                {
                    hostname = ipv6Reference();
                } //End block
                {
                    boolean var6B42F0A72918D59DEEB13AEDBC33A87B_1326133871 = (isIPv6Address(lexer.getRest()));
                    {
                        int startPtr;
                        startPtr = lexer.getPtr();
                        lexer.consumeValidChars(
                        new char[] {LexerCore.ALPHADIGIT_VALID_CHARS, ':'});
                        hostname
                    = new StringBuffer("[").append(
                        lexer.getBuffer().substring(startPtr, lexer.getPtr()))
                        .append("]").toString();
                    } //End block
                    {
                        int startPtr;
                        startPtr = lexer.getPtr();
                        consumeDomainLabel();
                        hostname = lexer.getBuffer().substring(startPtr, lexer.getPtr());
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                boolean var382EE341A83DD8661DDB0D795F508391_782509311 = (hostname.length() == 0);
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    lexer.getBuffer() + ": Missing host name",
                    lexer.getPtr());
                varB4EAC82CA7396A68D541C85D26508E83_825966942 = new Host(hostname);
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("host");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_825966942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825966942;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.208 -0400", hash_original_method = "9EB0AD05F46BCDC3EFC8C7DBA5311E53", hash_generated_method = "4EB775195268F02814635B805947DBB1")
    private boolean isIPv6Address(String uriHeader) {
        int hostEnd;
        hostEnd = uriHeader.indexOf(Lexer.QUESTION);
        int semiColonIndex;
        semiColonIndex = uriHeader.indexOf(Lexer.SEMICOLON);
        hostEnd = semiColonIndex;
        hostEnd = uriHeader.length();
        String host;
        host = uriHeader.substring(0, hostEnd);
        int firstColonIndex;
        firstColonIndex = host.indexOf(Lexer.COLON);
        int secondColonIndex;
        secondColonIndex = host.indexOf(Lexer.COLON, firstColonIndex + 1);
        addTaint(uriHeader.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955841785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955841785;
        // ---------- Original Method ----------
        //int hostEnd = uriHeader.indexOf(Lexer.QUESTION);
        //int semiColonIndex = uriHeader.indexOf(Lexer.SEMICOLON);
        //if ( hostEnd == -1
            //|| (semiColonIndex!= -1 && hostEnd > semiColonIndex) )
            //hostEnd = semiColonIndex;
        //if ( hostEnd == -1 )
            //hostEnd = uriHeader.length();
        //String host = uriHeader.substring(0, hostEnd);
        //int firstColonIndex = host.indexOf(Lexer.COLON);
        //if(firstColonIndex == -1)
            //return false;
        //int secondColonIndex = host.indexOf(Lexer.COLON, firstColonIndex + 1);
        //if(secondColonIndex == -1)
            //return false;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.224 -0400", hash_original_method = "E96E49B49C2326325B1DB743C3D726B3", hash_generated_method = "987C0BCD8DCCF96E274F2C5FED346C8D")
    public HostPort hostPort( boolean allowWS ) throws ParseException {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1109447109 = null; //Variable for return #1
        dbg_enter("hostPort");
        try 
        {
            Host host;
            host = this.host();
            HostPort hp;
            hp = new HostPort();
            hp.setHost(host);
            lexer.SPorHT();
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_1366310496 = (lexer.hasMoreChars());
                {
                    char la;
                    la = lexer.lookAhead(0);
                    //Begin case ':' 
                    lexer.consume(1);
                    //End case ':' 
                    //Begin case ':' 
                    lexer.SPorHT();
                    //End case ':' 
                    //Begin case ':' 
                    try 
                    {
                        String port;
                        port = lexer.number();
                        hp.setPort(Integer.parseInt(port));
                    } //End block
                    catch (NumberFormatException nfe)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                            lexer.getBuffer() + " :Error parsing port ",
                            lexer.getPtr());
                    } //End block
                    //End case ':' 
                    //Begin case default 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ParseException( lexer.getBuffer() +
                                " Illegal character in hostname:" + lexer.lookAhead(0),
                                lexer.getPtr() );
                    } //End block
                    //End case default 
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1109447109 = hp;
        } //End block
        finally 
        {
            dbg_leave("hostPort");
        } //End block
        addTaint(allowWS);
        varB4EAC82CA7396A68D541C85D26508E83_1109447109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1109447109;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static void main(String args[]) throws ParseException {
        String hostNames[] =
            {
                "foo.bar.com:1234",
                "proxima.chaplin.bt.co.uk",
                "129.6.55.181:2345",
                ":1234",
                "foo.bar.com:         1234",
                "foo.bar.com     :      1234   ",
                "MIK_S:1234"
            };
        for (int i = 0; i < hostNames.length; i++) {
            try {
                HostNameParser hnp = new HostNameParser(hostNames[i]);
                HostPort hp = hnp.hostPort(true);
                System.out.println("["+hp.encode()+"]");
            } catch (ParseException ex) {
                System.out.println("exception text = " + ex.getMessage());
            }
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.225 -0400", hash_original_field = "C99C8065D9A0587B2171CA8644CAC62D", hash_generated_field = "4B5B85298DF145B841626211C3E3FFCD")

    private static LexerCore Lexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.225 -0400", hash_original_field = "C9B256903191AC18D0771348A2030DD4", hash_generated_field = "831AAAE78EEEB4185035FA2C669A3DBD")

    private static char[] VALID_DOMAIN_LABEL_CHAR = new char[] {LexerCore.ALPHADIGIT_VALID_CHARS, '-', '.'};
}

