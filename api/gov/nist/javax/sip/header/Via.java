package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.stack.HopImpl;
import javax.sip.InvalidArgumentException;
import javax.sip.address.Hop;
import javax.sip.header.ViaHeader;
import java.text.ParseException;

public class Via extends ParametersHeader implements javax.sip.header.ViaHeader, ViaHeaderExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.918 -0400", hash_original_field = "610A766B3E0567396106CE73CA862AB1", hash_generated_field = "5B51F01BA670CB6A7B4E1A02DEB8A619")

    protected Protocol sentProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.918 -0400", hash_original_field = "93843F38363D24DFE376CC298A9F7B78", hash_generated_field = "0B1CBB926459AD49C5AAB0F0CD26CCCF")

    protected HostPort sentBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.918 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "F67D9B9E386FB326EF97E9813CA35FC6")

    protected String comment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.918 -0400", hash_original_field = "53C8339148B638BBC1C40E3CA26CBA08", hash_generated_field = "2352712DCFC5BA30D0234B4D1AC22071")

    private boolean rPortFlag = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.918 -0400", hash_original_method = "7D07E05C0BEE96603D98F8B1E7A2E317", hash_generated_method = "05BCC6515CD84F16CEE1E054ED6F0504")
    public  Via() {
        super(NAME);
        sentProtocol = new Protocol();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.919 -0400", hash_original_method = "6B6D36FD3A79EE403682FF6F25A822A5", hash_generated_method = "127B3E11C11E009A649F4474AABDD319")
    public boolean equals(Object other) {
        {
            boolean varBF864F33C9F93117F7F57C5BA4CB58C5_1733129834 = (other==this);
        } 
        {
            final ViaHeader o = (ViaHeader) other;
            boolean varC87927B8F9959A9F22D460E1EC42385E_328570233 = (getProtocol().equalsIgnoreCase( o.getProtocol() )
                && getTransport().equalsIgnoreCase( o.getTransport() )
                && getHost().equalsIgnoreCase( o.getHost() )
                && getPort() == o.getPort()
                && equalParameters( o ));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017280289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017280289;
        
        
        
            
            
                
                
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.919 -0400", hash_original_method = "F03A2761E3B9AF6DF371EC359829DB1F", hash_generated_method = "BD5865EE6009DA74C38FA64F517FEEA8")
    public String getProtocolVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1677883667 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_10117511 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1677883667 = null;
        varB4EAC82CA7396A68D541C85D26508E83_10117511 = sentProtocol.getProtocolVersion();
        String varA7E53CE21691AB073D9660D615818899_223919373; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_223919373 = varB4EAC82CA7396A68D541C85D26508E83_1677883667;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_223919373 = varB4EAC82CA7396A68D541C85D26508E83_10117511;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_223919373.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_223919373;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.920 -0400", hash_original_method = "07C91BB13E357235D0646F9B1302A813", hash_generated_method = "1E5B3B963DDB845EFAD56EC088E915BD")
    public Protocol getSentProtocol() {
        Protocol varB4EAC82CA7396A68D541C85D26508E83_752525077 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_752525077 = sentProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_752525077.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_752525077;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.920 -0400", hash_original_method = "834E4BBD7298D05AE3719FD543779099", hash_generated_method = "7D99C078893DB521528061346A7CEA1A")
    public HostPort getSentBy() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1224016957 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1224016957 = sentBy;
        varB4EAC82CA7396A68D541C85D26508E83_1224016957.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1224016957;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.921 -0400", hash_original_method = "D671032CD8E13BB36667C287933AFA1D", hash_generated_method = "41E4D0218FB730458875EFDAC7076BF3")
    public Hop getHop() {
        Hop varB4EAC82CA7396A68D541C85D26508E83_1840275194 = null; 
        HopImpl hop = new HopImpl(sentBy.getHost().getHostname(),
                sentBy.getPort(),sentProtocol.getTransport());
        varB4EAC82CA7396A68D541C85D26508E83_1840275194 = hop;
        varB4EAC82CA7396A68D541C85D26508E83_1840275194.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1840275194;
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.922 -0400", hash_original_method = "50080B5B5AC1614DCB7B006B51F53E3F", hash_generated_method = "81A9331E44F879FFC51E64A0CDDA29D0")
    public NameValueList getViaParms() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_255014516 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_255014516 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_255014516.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_255014516;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.923 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "431A92BF021FF93C90AB41B75F31C96F")
    public String getComment() {
        String varB4EAC82CA7396A68D541C85D26508E83_101412362 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_101412362 = comment;
        varB4EAC82CA7396A68D541C85D26508E83_101412362.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_101412362;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.924 -0400", hash_original_method = "60E8CE9FCECD3622E03D9910A9625801", hash_generated_method = "A3E4D9363977B2CDB0B931665521D5EC")
    public boolean hasPort() {
        boolean varA9B995C4FEFE1CD5691B349CAE3F341B_554462847 = ((getSentBy()).hasPort());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821566974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821566974;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.924 -0400", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "F189816C6A3825C449808DF420E8142B")
    public boolean hasComment() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_945616086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_945616086;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.924 -0400", hash_original_method = "944AB7146038DECB09A155E81BB22663", hash_generated_method = "79CD3AAB4B019027F3580A1A1672D020")
    public void removePort() {
        sentBy.removePort();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.924 -0400", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "61BD4B46829E380C1561798A83B14603")
    public void removeComment() {
        comment = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.925 -0400", hash_original_method = "EAF98E914AE1C4A3745B20F70C227AC7", hash_generated_method = "3DF319B3995B0254B23B70CA4F88E3FA")
    public void setProtocolVersion(String protocolVersion) {
        sentProtocol = new Protocol();
        sentProtocol.setProtocolVersion(protocolVersion);
        addTaint(protocolVersion.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.925 -0400", hash_original_method = "DC556AA065BEAF9D4C2B976D57E39DA8", hash_generated_method = "67CE5B6EBE01C1896A24187536D934A2")
    public void setHost(Host host) {
        {
            sentBy = new HostPort();
        } 
        sentBy.setHost(host);
        addTaint(host.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.926 -0400", hash_original_method = "F4FB101A445D5E49EE8B10DCE47E32FC", hash_generated_method = "5256462B357CC08BC06E273F7E8B63C4")
    public void setSentProtocol(Protocol s) {
        sentProtocol = s;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.926 -0400", hash_original_method = "543B4EA18E4F8858630BB59B262697DA", hash_generated_method = "63DB9B02D21F6151DDBE43BA55FA92E9")
    public void setSentBy(HostPort s) {
        sentBy = s;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.926 -0400", hash_original_method = "DE8908B9CA5447E854A0D06D0B1B9195", hash_generated_method = "23ECBD58C40560F298AA32A25976DB82")
    public void setComment(String c) {
        comment = c;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.927 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "86AEA15EE97F3D35BD3140623F610B0D")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1990126495 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1990126495 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1990126495.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1990126495;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.927 -0400", hash_original_method = "C937D3FA4F8C32F6B76B74CD5C9B4805", hash_generated_method = "69C218D70C617C142A98352D662ACD7E")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_68237311 = null; 
        sentProtocol.encode(buffer);
        buffer.append(SP);
        sentBy.encode(buffer);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2132730301 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } 
        } 
        {
            buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        } 
        buffer.append(";rport");
        varB4EAC82CA7396A68D541C85D26508E83_68237311 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_68237311.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_68237311;
        
        
        
        
        
            
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.928 -0400", hash_original_method = "A6610C3C674AD8475435D641E21474E9", hash_generated_method = "7349E57A64FCBD8C830A47E873AD6EAC")
    public void setHost(String host) throws ParseException {
        sentBy = new HostPort();
        try 
        {
            Host h = new Host(host);
            sentBy.setHost(h);
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" host parameter is null");
        } 
        addTaint(host.getTaint());
        
        
            
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.928 -0400", hash_original_method = "C40590C8092ADD61F2FE2F813826D182", hash_generated_method = "4BFC53798207294D5BD12F00D22E9E06")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1198632507 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_745791359 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1667097796 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1198632507 = null;
        {
            Host host = sentBy.getHost();
            varB4EAC82CA7396A68D541C85D26508E83_745791359 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1667097796 = host.getHostname();
        } 
        String varA7E53CE21691AB073D9660D615818899_343765563; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_343765563 = varB4EAC82CA7396A68D541C85D26508E83_1198632507;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_343765563 = varB4EAC82CA7396A68D541C85D26508E83_745791359;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_343765563 = varB4EAC82CA7396A68D541C85D26508E83_1667097796;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_343765563.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_343765563;
        
        
            
        
            
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.929 -0400", hash_original_method = "3BFDF83597585B440A29B8E314A4320F", hash_generated_method = "31395B1EC6918101805656AEAD14947A")
    public void setPort(int port) throws InvalidArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
        } 
        sentBy = new HostPort();
        sentBy.setPort(port);
        addTaint(port);
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.930 -0400", hash_original_method = "524778E64DA2B969E2ED4D2BD7E92B55", hash_generated_method = "7B6A17B05EF5967791C55E81D8F72366")
    public void setRPort() {
        rPortFlag = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.930 -0400", hash_original_method = "E4A7E9B0C37CC00BF245A9AEF6038FD8", hash_generated_method = "EB9E8A2B57019F5F8DCF787DA0931F86")
    public int getPort() {
        int var1F971C6C371EAF98B044A213E0F08CE2_1466008569 = (sentBy.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401358288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401358288;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.931 -0400", hash_original_method = "8F51D2BD996E5077EFE382EF5CCB28F7", hash_generated_method = "EAAE22502435C555402A36D03F8F4BFC")
    public int getRPort() {
        String strRport = getParameter(ParameterNames.RPORT);
        {
            boolean var8E95033F2505B01B0D05C3D59477EE79_1609491258 = (strRport != null && ! strRport.equals(""));
            int varAEB3681EA4A53125B3833EAD829AB0EB_2141957277 = (Integer.valueOf(strRport).intValue());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959192482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959192482;
        
        
        
            
         
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.934 -0400", hash_original_method = "2C7D6CB162F307BBDEA3C529EA37600B", hash_generated_method = "2B5A34E5E79DCD49B825F9E8ADC12D68")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1533382386 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_834230029 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1533382386 = null;
        varB4EAC82CA7396A68D541C85D26508E83_834230029 = sentProtocol.getTransport();
        String varA7E53CE21691AB073D9660D615818899_2105119426; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2105119426 = varB4EAC82CA7396A68D541C85D26508E83_1533382386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2105119426 = varB4EAC82CA7396A68D541C85D26508E83_834230029;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2105119426.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2105119426;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.937 -0400", hash_original_method = "DA10FBD3B27193627F0BF00A97E141AB", hash_generated_method = "A1A9F358B7AEDC92892F67FBB5177D9A")
    public void setTransport(String transport) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setTransport(), the transport parameter is null.");
        sentProtocol = new Protocol();
        sentProtocol.setTransport(transport);
        addTaint(transport.getTaint());
        
        
            
                
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.939 -0400", hash_original_method = "076253ECD4074E0CF94E6CAE84ACD031", hash_generated_method = "9A2201789B073A5D63E224B857C3BB87")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_154639537 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_912151870 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_154639537 = null;
        varB4EAC82CA7396A68D541C85D26508E83_912151870 = sentProtocol.getProtocol();
        String varA7E53CE21691AB073D9660D615818899_1049675405; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1049675405 = varB4EAC82CA7396A68D541C85D26508E83_154639537;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1049675405 = varB4EAC82CA7396A68D541C85D26508E83_912151870;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1049675405.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1049675405;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.939 -0400", hash_original_method = "983A1DB4807CBA4F5F74F526664C05F9", hash_generated_method = "87EA733C7E9FA58C34F0937F3D81B7A3")
    public void setProtocol(String protocol) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setProtocol(), the protocol parameter is null.");
        sentProtocol = new Protocol();
        sentProtocol.setProtocol(protocol);
        addTaint(protocol.getTaint());
        
        
            
                
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.940 -0400", hash_original_method = "AB2BF7863E6929FA549276BF1FCB8F41", hash_generated_method = "6E4911D2B9C91C7ABB652F396FB9FAE8")
    public int getTTL() {
        int ttl = getParameterAsInt(ParameterNames.TTL);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534055537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534055537;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.940 -0400", hash_original_method = "275C0FDDD82C74D9D06FF2EBDF31F802", hash_generated_method = "DAC980A428F900A63CE0A2FB51858A48")
    public void setTTL(int ttl) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", Via, setTTL(), the ttl parameter is < 0");
        setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
        addTaint(ttl);
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.941 -0400", hash_original_method = "BA8497BF19C86E6498457C19F33C2BB1", hash_generated_method = "31E1E7A2EBE075220F76EB42E33AA36B")
    public String getMAddr() {
        String varB4EAC82CA7396A68D541C85D26508E83_1567157282 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1567157282 = getParameter(ParameterNames.MADDR);
        varB4EAC82CA7396A68D541C85D26508E83_1567157282.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1567157282;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.942 -0400", hash_original_method = "6AB0C98EE8B2466C821195A9A73846A0", hash_generated_method = "9AF99C65289100B9AA766573B7830607")
    public void setMAddr(String mAddr) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setMAddr(), the mAddr parameter is null.");
        Host host = new Host();
        host.setAddress(mAddr);
        NameValue nameValue = new NameValue(ParameterNames.MADDR, host);
        setParameter(nameValue);
        addTaint(mAddr.getTaint());
        
        
            
                
                    
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.943 -0400", hash_original_method = "25AF7C33721E5D780684174C5845DEAD", hash_generated_method = "ED90BE917627FB4AA1DE27D255B35ECA")
    public String getReceived() {
        String varB4EAC82CA7396A68D541C85D26508E83_839644427 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_839644427 = getParameter(ParameterNames.RECEIVED);
        varB4EAC82CA7396A68D541C85D26508E83_839644427.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_839644427;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.943 -0400", hash_original_method = "F727BD69B2536BBCBA80253D70F95056", hash_generated_method = "40C5C7EFFDEB6A0B9A13D05577FB4BAE")
    public void setReceived(String received) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setReceived(), the received parameter is null.");
        setParameter(ParameterNames.RECEIVED, received);
        addTaint(received.getTaint());
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.945 -0400", hash_original_method = "9A958EF7B290CF5A27A4EB96F15158F0", hash_generated_method = "98448D9E974DC915CF95713FCE39F4F1")
    public String getBranch() {
        String varB4EAC82CA7396A68D541C85D26508E83_701565236 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_701565236 = getParameter(ParameterNames.BRANCH);
        varB4EAC82CA7396A68D541C85D26508E83_701565236.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_701565236;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.945 -0400", hash_original_method = "5A56F4FACEB17A95A8FCAD93BB83EA63", hash_generated_method = "D173C555D2E8D9273B970D33832D20BA")
    public void setBranch(String branch) throws ParseException {
        {
            boolean var4C46677D9B30E6CB7B7BB28849DA9864_310202290 = (branch == null || branch.length()==0);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setBranch(), the branch parameter is null or length 0.");
        } 
        setParameter(ParameterNames.BRANCH, branch);
        addTaint(branch.getTaint());
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.946 -0400", hash_original_method = "252C53006150044E4EBAAC8A002E65B1", hash_generated_method = "5813A9E94B337D9F291ADEBCB12155A3")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_867023884 = null; 
        Via retval = (Via) super.clone();
        retval.sentProtocol = (Protocol) this.sentProtocol.clone();
        retval.sentBy = (HostPort) this.sentBy.clone();
        {
            boolean var0F30CA1BAF298E42629D8419B9FFBC30_1413565853 = (this.getRPort() != -1);
            retval.setParameter(RPORT,this.getRPort());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_867023884 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_867023884.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_867023884;
        
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.947 -0400", hash_original_method = "5347FDDA2C7AAC95D7D1D2F666800B71", hash_generated_method = "44FBB16B0500AACF31AD012AE9B79B58")
    public String getSentByField() {
        String varB4EAC82CA7396A68D541C85D26508E83_1016952775 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_639905831 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1016952775 = sentBy.encode();
        varB4EAC82CA7396A68D541C85D26508E83_639905831 = null;
        String varA7E53CE21691AB073D9660D615818899_1129992070; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1129992070 = varB4EAC82CA7396A68D541C85D26508E83_1016952775;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1129992070 = varB4EAC82CA7396A68D541C85D26508E83_639905831;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1129992070.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1129992070;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.947 -0400", hash_original_method = "128FFEF5D307451BA5388B5193A6BF26", hash_generated_method = "0851E1CC86178F9AAD55347611647425")
    public String getSentProtocolField() {
        String varB4EAC82CA7396A68D541C85D26508E83_2022389492 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1729747746 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2022389492 = sentProtocol.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1729747746 = null;
        String varA7E53CE21691AB073D9660D615818899_1692127068; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1692127068 = varB4EAC82CA7396A68D541C85D26508E83_2022389492;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1692127068 = varB4EAC82CA7396A68D541C85D26508E83_1729747746;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1692127068.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1692127068;
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.947 -0400", hash_original_field = "0179E78CAC3DA14C2FFC9A7D61106327", hash_generated_field = "44E58998010CA4EBABA566C0FB985DB3")

    private static final long serialVersionUID = 5281728373401351378L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.948 -0400", hash_original_field = "EEAA4D02BE43B89B52AFD8DC453B4BFD", hash_generated_field = "22327A98EDD3D141225105CEAD3ABB13")

    public static final String BRANCH = ParameterNames.BRANCH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.948 -0400", hash_original_field = "9B0F9FB69328D59E52F3C0D780928331", hash_generated_field = "4D8C5F2DB4C0964744FED89BE27D1A75")

    public static final String RECEIVED = ParameterNames.RECEIVED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.948 -0400", hash_original_field = "0C3EC7D99BD0916DCE7C7A2913106895", hash_generated_field = "4AA8F81F93B467DE58E70654B3136851")

    public static final String MADDR = ParameterNames.MADDR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.948 -0400", hash_original_field = "A27202196DCCEEDEB9F7293943B39842", hash_generated_field = "EAB3FB3A2E323EFD5528878B03366C28")

    public static final String TTL = ParameterNames.TTL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.948 -0400", hash_original_field = "B1E3516AD1F9BEC949E47B776969F649", hash_generated_field = "180F648B89D676D4D5F0240DFDFE1D7D")

    public static final String RPORT = ParameterNames.RPORT;
}

