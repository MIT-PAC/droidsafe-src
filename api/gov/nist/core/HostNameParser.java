package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public class HostNameParser extends ParserCore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.381 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.381 -0400", hash_original_method = "BDF66B8A6A6E733FD4317463FD36B54D", hash_generated_method = "51CABFAB96FAD259535C251BF896922A")
    public  HostNameParser(String hname) {
        addTaint(hname.getTaint());
        this.lexer = new LexerCore("charLexer", hname);
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.381 -0400", hash_original_method = "DE9D0F52F3286ED66509E4F5CE87141D", hash_generated_method = "20CF374D4AA9C817A729173439D1F500")
    public  HostNameParser(LexerCore lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        lexer.selectLexer("charLexer");
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.382 -0400", hash_original_method = "4DE693D4586CFA412C55EF35C3691C08", hash_generated_method = "DEF01A9C369D53079E6221F8E32BA4EB")
    protected void consumeDomainLabel() throws ParseException {
    if(debug)        
        dbg_enter("domainLabel");
        try 
        {
            lexer.consumeValidChars(VALID_DOMAIN_LABEL_CHAR);
        } 
        finally 
        {
    if(debug)            
            dbg_leave("domainLabel");
        } 
        
        
            
        
            
        
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.382 -0400", hash_original_method = "12990E16E23A1648F6B6EE2410C75196", hash_generated_method = "177F42D557EEE838894A4459BB5CF88C")
    protected String ipv6Reference() throws ParseException {
        StringBuffer retval = new StringBuffer();
    if(debug)        
        dbg_enter("ipv6Reference");
        try 
        {
    if(stripAddressScopeZones)            
            {
                while
(lexer.hasMoreChars())                
                {
                    char la = lexer.lookAhead(0);
    if(LexerCore.isHexDigit(la) || la == '.' || la == ':'
                            || la == '[')                    
                    {
                        lexer.consume(1);
                        retval.append(la);
                    } 
                    else
    if(la == ']')                    
                    {
                        lexer.consume(1);
                        retval.append(la);
String var1B324365A764C077A55854483509F4AB_2021404684 =                         retval.toString();
                        var1B324365A764C077A55854483509F4AB_2021404684.addTaint(taint);
                        return var1B324365A764C077A55854483509F4AB_2021404684;
                    } 
                    else
    if(la == '%')                    
                    {
                        lexer.consume(1);
                        String rest = lexer.getRest();
    if(rest == null || rest.length() == 0)                        
                        {
                            break;
                        } 
                        int stripLen = rest.indexOf(']');
    if(stripLen == -1)                        
                        {
                            break;
                        } 
                        lexer.consume(stripLen+1);
                        retval.append("]");
String var1B324365A764C077A55854483509F4AB_78171056 =                         retval.toString();
                        var1B324365A764C077A55854483509F4AB_78171056.addTaint(taint);
                        return var1B324365A764C077A55854483509F4AB_78171056;
                    } 
                    else
                    break;
                } 
            } 
            else
            {
                while
(lexer.hasMoreChars())                
                {
                    char la = lexer.lookAhead(0);
    if(LexerCore.isHexDigit(la) || la == '.'
                            || la == ':' || la == '[')                    
                    {
                        lexer.consume(1);
                        retval.append(la);
                    } 
                    else
    if(la == ']')                    
                    {
                        lexer.consume(1);
                        retval.append(la);
String var1B324365A764C077A55854483509F4AB_20135514 =                         retval.toString();
                        var1B324365A764C077A55854483509F4AB_20135514.addTaint(taint);
                        return var1B324365A764C077A55854483509F4AB_20135514;
                    } 
                    else
                    break;
                } 
            } 
            ParseException var11981E79D9C4D841C3C725ECD1A8474C_2131576433 = new ParseException(
                lexer.getBuffer() + ": Illegal Host name ",
                lexer.getPtr());
            var11981E79D9C4D841C3C725ECD1A8474C_2131576433.addTaint(taint);
            throw var11981E79D9C4D841C3C725ECD1A8474C_2131576433;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("ipv6Reference");
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.384 -0400", hash_original_method = "59E4521A394425B7E70180091A99EC01", hash_generated_method = "7CA5434B92E9AEB815F6890BB745E082")
    public Host host() throws ParseException {
    if(debug)        
        dbg_enter("host");
        try 
        {
            String hostname;
    if(lexer.lookAhead(0) == '[')            
            {
                hostname = ipv6Reference();
            } 
            else
    if(isIPv6Address(lexer.getRest()))            
            {
                int startPtr = lexer.getPtr();
                lexer.consumeValidChars(
                        new char[] {LexerCore.ALPHADIGIT_VALID_CHARS, ':'});
                hostname
                    = new StringBuffer("[").append(
                        lexer.getBuffer().substring(startPtr, lexer.getPtr()))
                        .append("]").toString();
            } 
            else
            {
                int startPtr = lexer.getPtr();
                consumeDomainLabel();
                hostname = lexer.getBuffer().substring(startPtr, lexer.getPtr());
            } 
    if(hostname.length() == 0)            
            {
            ParseException var3A0984BE1714E3EA18F6143A3F3738D7_579997536 = new ParseException(
                    lexer.getBuffer() + ": Missing host name",
                    lexer.getPtr());
            var3A0984BE1714E3EA18F6143A3F3738D7_579997536.addTaint(taint);
            throw var3A0984BE1714E3EA18F6143A3F3738D7_579997536;
            }
            else
            {
Host varF0B534F137321120478D6E10D568F47B_772642229 =             new Host(hostname);
            varF0B534F137321120478D6E10D568F47B_772642229.addTaint(taint);
            return varF0B534F137321120478D6E10D568F47B_772642229;
            }
        } 
        finally 
        {
    if(debug)            
            dbg_leave("host");
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.384 -0400", hash_original_method = "9EB0AD05F46BCDC3EFC8C7DBA5311E53", hash_generated_method = "6036025105EDB7733A9FC960EED230A8")
    private boolean isIPv6Address(String uriHeader) {
        addTaint(uriHeader.getTaint());
        int hostEnd = uriHeader.indexOf(Lexer.QUESTION);
        int semiColonIndex = uriHeader.indexOf(Lexer.SEMICOLON);
    if(hostEnd == -1
            || (semiColonIndex!= -1 && hostEnd > semiColonIndex))        
        hostEnd = semiColonIndex;
    if(hostEnd == -1)        
        hostEnd = uriHeader.length();
        String host = uriHeader.substring(0, hostEnd);
        int firstColonIndex = host.indexOf(Lexer.COLON);
    if(firstColonIndex == -1)        
        {
        boolean var68934A3E9455FA72420237EB05902327_673346790 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290275054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290275054;
        }
        int secondColonIndex = host.indexOf(Lexer.COLON, firstColonIndex + 1);
    if(secondColonIndex == -1)        
        {
        boolean var68934A3E9455FA72420237EB05902327_995461034 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1183136853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1183136853;
        }
        boolean varB326B5062B2F0E69046810717534CB09_1541354537 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264324718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264324718;
        
        
        
        
            
            
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.385 -0400", hash_original_method = "E96E49B49C2326325B1DB743C3D726B3", hash_generated_method = "C83AF658E91A46AE8315B062A2730270")
    public HostPort hostPort( boolean allowWS ) throws ParseException {
        addTaint(allowWS);
    if(debug)        
        dbg_enter("hostPort");
        try 
        {
            Host host = this.host();
            HostPort hp = new HostPort();
            hp.setHost(host);
    if(allowWS)            
            lexer.SPorHT();
    if(lexer.hasMoreChars())            
            {
                char la = lexer.lookAhead(0);
switch(la){
                case ':':
                lexer.consume(1);
    if(allowWS)                
                lexer.SPorHT();
                try 
                {
                    String port = lexer.number();
                    hp.setPort(Integer.parseInt(port));
                } 
                catch (NumberFormatException nfe)
                {
                    ParseException varDA00022791EC73E5638854EA9316EE2B_939238970 = new ParseException(
                            lexer.getBuffer() + " :Error parsing port ",
                            lexer.getPtr());
                    varDA00022791EC73E5638854EA9316EE2B_939238970.addTaint(taint);
                    throw varDA00022791EC73E5638854EA9316EE2B_939238970;
                } 
                break;
                case ',':
                case ';':
                case '?':
                case '>':
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                case '/':
                break;
                case '%':
    if(stripAddressScopeZones)                
                {
                    break;
                } 
                default:
    if(!allowWS)                
                {
                    ParseException var34A0E2FAB5FDEDAFA01A0EB0BC99C064_1484109805 = new ParseException( lexer.getBuffer() +
                                " Illegal character in hostname:" + lexer.lookAhead(0),
                                lexer.getPtr() );
                    var34A0E2FAB5FDEDAFA01A0EB0BC99C064_1484109805.addTaint(taint);
                    throw var34A0E2FAB5FDEDAFA01A0EB0BC99C064_1484109805;
                } 
}
            } 
HostPort var33B70901B4FF652A00D06638A0ABE5C1_1202994521 =             hp;
            var33B70901B4FF652A00D06638A0ABE5C1_1202994521.addTaint(taint);
            return var33B70901B4FF652A00D06638A0ABE5C1_1202994521;
        } 
        finally 
        {
    if(debug)            
            dbg_leave("hostPort");
        } 
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.385 -0400", hash_original_field = "C99C8065D9A0587B2171CA8644CAC62D", hash_generated_field = "4B5B85298DF145B841626211C3E3FFCD")

    private static LexerCore Lexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.385 -0400", hash_original_field = "C9B256903191AC18D0771348A2030DD4", hash_generated_field = "3EE0A4DA75CB4D9B776B1D397345B183")

    private static final char[] VALID_DOMAIN_LABEL_CHAR = new char[] {LexerCore.ALPHADIGIT_VALID_CHARS, '-', '.'};
}

