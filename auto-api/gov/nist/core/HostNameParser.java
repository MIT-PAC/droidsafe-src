package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public class HostNameParser extends ParserCore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.508 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.509 -0400", hash_original_method = "BDF66B8A6A6E733FD4317463FD36B54D", hash_generated_method = "E6190D95AF09B5C58BFF34773236830D")
    public  HostNameParser(String hname) {
        this.lexer = new LexerCore("charLexer", hname);
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        addTaint(hname.getTaint());
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.509 -0400", hash_original_method = "DE9D0F52F3286ED66509E4F5CE87141D", hash_generated_method = "EC6DD46E0D41FAD9C9496A5F35065F0B")
    public  HostNameParser(LexerCore lexer) {
        this.lexer = lexer;
        lexer.selectLexer("charLexer");
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        addTaint(lexer.getTaint());
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.509 -0400", hash_original_method = "4DE693D4586CFA412C55EF35C3691C08", hash_generated_method = "DBA796E5CE34881D94534DF82F8B2BCD")
    protected void consumeDomainLabel() throws ParseException {
        dbg_enter("domainLabel");
        try 
        {
            lexer.consumeValidChars(VALID_DOMAIN_LABEL_CHAR);
        } 
        finally 
        {
            dbg_leave("domainLabel");
        } 
        
        
            
        
            
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.512 -0400", hash_original_method = "12990E16E23A1648F6B6EE2410C75196", hash_generated_method = "B5C9A4B4F0CE10EB3E579950C27A8330")
    protected String ipv6Reference() throws ParseException {
        String varB4EAC82CA7396A68D541C85D26508E83_697701878 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_681908480 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_790458039 = null; 
        StringBuffer retval = new StringBuffer();
        dbg_enter("ipv6Reference");
        try 
        {
            {
                {
                    boolean var255E8660353F5362DB4A60C2DDB0C461_889873297 = (lexer.hasMoreChars());
                    {
                        char la = lexer.lookAhead(0);
                        {
                            boolean var994371892917A87989057591FFA23B92_371666820 = (LexerCore.isHexDigit(la) || la == '.' || la == ':'
                            || la == '[');
                            {
                                lexer.consume(1);
                                retval.append(la);
                            } 
                            {
                                lexer.consume(1);
                                retval.append(la);
                                varB4EAC82CA7396A68D541C85D26508E83_697701878 = retval.toString();
                            } 
                            {
                                lexer.consume(1);
                                String rest = lexer.getRest();
                                {
                                    boolean varDA96287E1E04F81963DCAB3B1D387F7E_649976825 = (rest == null || rest.length() == 0);
                                } 
                                int stripLen = rest.indexOf(']');
                                lexer.consume(stripLen+1);
                                retval.append("]");
                                varB4EAC82CA7396A68D541C85D26508E83_681908480 = retval.toString();
                            } 
                        } 
                    } 
                } 
            } 
            {
                {
                    boolean var255E8660353F5362DB4A60C2DDB0C461_34289017 = (lexer.hasMoreChars());
                    {
                        char la = lexer.lookAhead(0);
                        {
                            boolean var2AC4EE193842A47EBFC6B489F345C5C3_175964075 = (LexerCore.isHexDigit(la) || la == '.'
                            || la == ':' || la == '[');
                            {
                                lexer.consume(1);
                                retval.append(la);
                            } 
                            {
                                lexer.consume(1);
                                retval.append(la);
                                varB4EAC82CA7396A68D541C85D26508E83_790458039 = retval.toString();
                            } 
                        } 
                    } 
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new ParseException(
                lexer.getBuffer() + ": Illegal Host name ",
                lexer.getPtr());
        } 
        finally 
        {
            dbg_leave("ipv6Reference");
        } 
        String varA7E53CE21691AB073D9660D615818899_802575203; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_802575203 = varB4EAC82CA7396A68D541C85D26508E83_697701878;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_802575203 = varB4EAC82CA7396A68D541C85D26508E83_681908480;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_802575203 = varB4EAC82CA7396A68D541C85D26508E83_790458039;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_802575203.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_802575203;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.515 -0400", hash_original_method = "59E4521A394425B7E70180091A99EC01", hash_generated_method = "E4AFEDD59896DF872B670D365C76810C")
    public Host host() throws ParseException {
        Host varB4EAC82CA7396A68D541C85D26508E83_1850762359 = null; 
        dbg_enter("host");
        try 
        {
            String hostname;
            {
                boolean var7F8AD6B3877B097A231B70CAA2872139_1923973629 = (lexer.lookAhead(0) == '[');
                {
                    hostname = ipv6Reference();
                } 
                {
                    boolean var6B42F0A72918D59DEEB13AEDBC33A87B_1214700816 = (isIPv6Address(lexer.getRest()));
                    {
                        int startPtr = lexer.getPtr();
                        lexer.consumeValidChars(
                        new char[] {LexerCore.ALPHADIGIT_VALID_CHARS, ':'});
                        hostname
                    = new StringBuffer("[").append(
                        lexer.getBuffer().substring(startPtr, lexer.getPtr()))
                        .append("]").toString();
                    } 
                    {
                        int startPtr = lexer.getPtr();
                        consumeDomainLabel();
                        hostname = lexer.getBuffer().substring(startPtr, lexer.getPtr());
                    } 
                } 
            } 
            {
                boolean var382EE341A83DD8661DDB0D795F508391_2130373405 = (hostname.length() == 0);
                if (DroidSafeAndroidRuntime.control) throw new ParseException(
                    lexer.getBuffer() + ": Missing host name",
                    lexer.getPtr());
                varB4EAC82CA7396A68D541C85D26508E83_1850762359 = new Host(hostname);
            } 
        } 
        finally 
        {
            dbg_leave("host");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1850762359.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1850762359;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.516 -0400", hash_original_method = "9EB0AD05F46BCDC3EFC8C7DBA5311E53", hash_generated_method = "923D63ED612FE0EAD97A4A2270F5E9DB")
    private boolean isIPv6Address(String uriHeader) {
        int hostEnd = uriHeader.indexOf(Lexer.QUESTION);
        int semiColonIndex = uriHeader.indexOf(Lexer.SEMICOLON);
        hostEnd = semiColonIndex;
        hostEnd = uriHeader.length();
        String host = uriHeader.substring(0, hostEnd);
        int firstColonIndex = host.indexOf(Lexer.COLON);
        int secondColonIndex = host.indexOf(Lexer.COLON, firstColonIndex + 1);
        addTaint(uriHeader.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342497152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342497152;
        
        
        
        
            
            
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.517 -0400", hash_original_method = "E96E49B49C2326325B1DB743C3D726B3", hash_generated_method = "07D536380F2D5EDF7D4DA6007A969542")
    public HostPort hostPort( boolean allowWS ) throws ParseException {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_146017615 = null; 
        dbg_enter("hostPort");
        try 
        {
            Host host = this.host();
            HostPort hp = new HostPort();
            hp.setHost(host);
            lexer.SPorHT();
            {
                boolean var9783FB04504A12AC5E4CB1806E828D43_332254729 = (lexer.hasMoreChars());
                {
                    char la = lexer.lookAhead(0);
                    
                    lexer.consume(1);
                    
                    
                    lexer.SPorHT();
                    
                    
                    try 
                    {
                        String port = lexer.number();
                        hp.setPort(Integer.parseInt(port));
                    } 
                    catch (NumberFormatException nfe)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ParseException(
                            lexer.getBuffer() + " :Error parsing port ",
                            lexer.getPtr());
                    } 
                    
                    
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ParseException( lexer.getBuffer() +
                                " Illegal character in hostname:" + lexer.lookAhead(0),
                                lexer.getPtr() );
                    } 
                    
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_146017615 = hp;
        } 
        finally 
        {
            dbg_leave("hostPort");
        } 
        addTaint(allowWS);
        varB4EAC82CA7396A68D541C85D26508E83_146017615.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_146017615;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.517 -0400", hash_original_field = "C99C8065D9A0587B2171CA8644CAC62D", hash_generated_field = "4B5B85298DF145B841626211C3E3FFCD")

    private static LexerCore Lexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.517 -0400", hash_original_field = "C9B256903191AC18D0771348A2030DD4", hash_generated_field = "3EE0A4DA75CB4D9B776B1D397345B183")

    private static final char[] VALID_DOMAIN_LABEL_CHAR = new char[] {LexerCore.ALPHADIGIT_VALID_CHARS, '-', '.'};
}

