package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;






public class HostNameParser extends ParserCore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.363 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.364 -0400", hash_original_method = "BDF66B8A6A6E733FD4317463FD36B54D", hash_generated_method = "51CABFAB96FAD259535C251BF896922A")
    public  HostNameParser(String hname) {
        addTaint(hname.getTaint());
        this.lexer = new LexerCore("charLexer", hname);
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //this.lexer = new LexerCore("charLexer", hname);
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.364 -0400", hash_original_method = "DE9D0F52F3286ED66509E4F5CE87141D", hash_generated_method = "20CF374D4AA9C817A729173439D1F500")
    public  HostNameParser(LexerCore lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        lexer.selectLexer("charLexer");
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //lexer.selectLexer("charLexer");
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.364 -0400", hash_original_method = "4DE693D4586CFA412C55EF35C3691C08", hash_generated_method = "DEF01A9C369D53079E6221F8E32BA4EB")
    protected void consumeDomainLabel() throws ParseException {
        if(debug)        
        dbg_enter("domainLabel");
        try 
        {
            lexer.consumeValidChars(VALID_DOMAIN_LABEL_CHAR);
        } //End block
        finally 
        {
            if(debug)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.365 -0400", hash_original_method = "12990E16E23A1648F6B6EE2410C75196", hash_generated_method = "194DC6C5237046C4DCF790E9780BDE84")
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
                    } //End block
                    else
                    if(la == ']')                    
                    {
                        lexer.consume(1);
                        retval.append(la);
String var1B324365A764C077A55854483509F4AB_856625966 =                         retval.toString();
                        var1B324365A764C077A55854483509F4AB_856625966.addTaint(taint);
                        return var1B324365A764C077A55854483509F4AB_856625966;
                    } //End block
                    else
                    if(la == '%')                    
                    {
                        lexer.consume(1);
                        String rest = lexer.getRest();
                        if(rest == null || rest.length() == 0)                        
                        {
                            break;
                        } //End block
                        int stripLen = rest.indexOf(']');
                        if(stripLen == -1)                        
                        {
                            break;
                        } //End block
                        lexer.consume(stripLen+1);
                        retval.append("]");
String var1B324365A764C077A55854483509F4AB_870324589 =                         retval.toString();
                        var1B324365A764C077A55854483509F4AB_870324589.addTaint(taint);
                        return var1B324365A764C077A55854483509F4AB_870324589;
                    } //End block
                    else
                    break;
                } //End block
            } //End block
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
                    } //End block
                    else
                    if(la == ']')                    
                    {
                        lexer.consume(1);
                        retval.append(la);
String var1B324365A764C077A55854483509F4AB_1768909437 =                         retval.toString();
                        var1B324365A764C077A55854483509F4AB_1768909437.addTaint(taint);
                        return var1B324365A764C077A55854483509F4AB_1768909437;
                    } //End block
                    else
                    break;
                } //End block
            } //End block
            ParseException var11981E79D9C4D841C3C725ECD1A8474C_451596512 = new ParseException(
                lexer.getBuffer() + ": Illegal Host name ",
                lexer.getPtr());
            var11981E79D9C4D841C3C725ECD1A8474C_451596512.addTaint(taint);
            throw var11981E79D9C4D841C3C725ECD1A8474C_451596512;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("ipv6Reference");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.368 -0400", hash_original_method = "59E4521A394425B7E70180091A99EC01", hash_generated_method = "DA27DCB9B83E5C572753EDDC414AAF34")
    public Host host() throws ParseException {
        if(debug)        
        dbg_enter("host");
        try 
        {
            String hostname;
            if(lexer.lookAhead(0) == '[')            
            {
                hostname = ipv6Reference();
            } //End block
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
            } //End block
            else
            {
                int startPtr = lexer.getPtr();
                consumeDomainLabel();
                hostname = lexer.getBuffer().substring(startPtr, lexer.getPtr());
            } //End block
            if(hostname.length() == 0)            
            {
            ParseException var3A0984BE1714E3EA18F6143A3F3738D7_2134348157 = new ParseException(
                    lexer.getBuffer() + ": Missing host name",
                    lexer.getPtr());
            var3A0984BE1714E3EA18F6143A3F3738D7_2134348157.addTaint(taint);
            throw var3A0984BE1714E3EA18F6143A3F3738D7_2134348157;
            }
            else
            {
Host varF0B534F137321120478D6E10D568F47B_1490071819 =             new Host(hostname);
            varF0B534F137321120478D6E10D568F47B_1490071819.addTaint(taint);
            return varF0B534F137321120478D6E10D568F47B_1490071819;
            }
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("host");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.369 -0400", hash_original_method = "9EB0AD05F46BCDC3EFC8C7DBA5311E53", hash_generated_method = "6B6CCD4F5A21EBF4005A2F082A81615E")
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
        boolean var68934A3E9455FA72420237EB05902327_1523970746 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829213815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829213815;
        }
        int secondColonIndex = host.indexOf(Lexer.COLON, firstColonIndex + 1);
        if(secondColonIndex == -1)        
        {
        boolean var68934A3E9455FA72420237EB05902327_665428834 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074538145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074538145;
        }
        boolean varB326B5062B2F0E69046810717534CB09_635909604 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099005161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099005161;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.371 -0400", hash_original_method = "E96E49B49C2326325B1DB743C3D726B3", hash_generated_method = "A09835A8C007807A75B44A092743A5A3")
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
                } //End block
                catch (NumberFormatException nfe)
                {
                    ParseException varDA00022791EC73E5638854EA9316EE2B_959143250 = new ParseException(
                            lexer.getBuffer() + " :Error parsing port ",
                            lexer.getPtr());
                    varDA00022791EC73E5638854EA9316EE2B_959143250.addTaint(taint);
                    throw varDA00022791EC73E5638854EA9316EE2B_959143250;
                } //End block
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
                } //End block
                default:
                if(!allowWS)                
                {
                    ParseException var34A0E2FAB5FDEDAFA01A0EB0BC99C064_668310250 = new ParseException( lexer.getBuffer() +
                                " Illegal character in hostname:" + lexer.lookAhead(0),
                                lexer.getPtr() );
                    var34A0E2FAB5FDEDAFA01A0EB0BC99C064_668310250.addTaint(taint);
                    throw var34A0E2FAB5FDEDAFA01A0EB0BC99C064_668310250;
                } //End block
}
            } //End block
HostPort var33B70901B4FF652A00D06638A0ABE5C1_583871500 =             hp;
            var33B70901B4FF652A00D06638A0ABE5C1_583871500.addTaint(taint);
            return var33B70901B4FF652A00D06638A0ABE5C1_583871500;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("hostPort");
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.372 -0400", hash_original_field = "C99C8065D9A0587B2171CA8644CAC62D", hash_generated_field = "4B5B85298DF145B841626211C3E3FFCD")

    private static LexerCore Lexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.372 -0400", hash_original_field = "C9B256903191AC18D0771348A2030DD4", hash_generated_field = "3EE0A4DA75CB4D9B776B1D397345B183")

    private static final char[] VALID_DOMAIN_LABEL_CHAR = new char[] {LexerCore.ALPHADIGIT_VALID_CHARS, '-', '.'};
}

