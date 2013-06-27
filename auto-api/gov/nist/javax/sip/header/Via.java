package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.125 -0400", hash_original_field = "610A766B3E0567396106CE73CA862AB1", hash_generated_field = "5B51F01BA670CB6A7B4E1A02DEB8A619")

    protected Protocol sentProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.125 -0400", hash_original_field = "93843F38363D24DFE376CC298A9F7B78", hash_generated_field = "0B1CBB926459AD49C5AAB0F0CD26CCCF")

    protected HostPort sentBy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.125 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "F67D9B9E386FB326EF97E9813CA35FC6")

    protected String comment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.126 -0400", hash_original_field = "53C8339148B638BBC1C40E3CA26CBA08", hash_generated_field = "2352712DCFC5BA30D0234B4D1AC22071")

    private boolean rPortFlag = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.126 -0400", hash_original_method = "7D07E05C0BEE96603D98F8B1E7A2E317", hash_generated_method = "05BCC6515CD84F16CEE1E054ED6F0504")
    public  Via() {
        super(NAME);
        sentProtocol = new Protocol();
        // ---------- Original Method ----------
        //sentProtocol = new Protocol();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.127 -0400", hash_original_method = "6B6D36FD3A79EE403682FF6F25A822A5", hash_generated_method = "4D18CA573380D71EFB841339B5D33EDC")
    public boolean equals(Object other) {
        {
            boolean varBF864F33C9F93117F7F57C5BA4CB58C5_1961578947 = (other==this);
        } //End collapsed parenthetic
        {
            ViaHeader o;
            o = (ViaHeader) other;
            boolean varC87927B8F9959A9F22D460E1EC42385E_2108793340 = (getProtocol().equalsIgnoreCase( o.getProtocol() )
                && getTransport().equalsIgnoreCase( o.getTransport() )
                && getHost().equalsIgnoreCase( o.getHost() )
                && getPort() == o.getPort()
                && equalParameters( o ));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473317813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473317813;
        // ---------- Original Method ----------
        //if (other==this) return true;
        //if (other instanceof ViaHeader) {
            //final ViaHeader o = (ViaHeader) other;
            //return getProtocol().equalsIgnoreCase( o.getProtocol() )
                //&& getTransport().equalsIgnoreCase( o.getTransport() )
                //&& getHost().equalsIgnoreCase( o.getHost() )
                //&& getPort() == o.getPort()
                //&& equalParameters( o );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.128 -0400", hash_original_method = "F03A2761E3B9AF6DF371EC359829DB1F", hash_generated_method = "E6238807AA2599EF9E17CD8E8E4E03E9")
    public String getProtocolVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_255003042 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_404426326 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_255003042 = null;
        varB4EAC82CA7396A68D541C85D26508E83_404426326 = sentProtocol.getProtocolVersion();
        String varA7E53CE21691AB073D9660D615818899_357114284; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_357114284 = varB4EAC82CA7396A68D541C85D26508E83_255003042;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_357114284 = varB4EAC82CA7396A68D541C85D26508E83_404426326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_357114284.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_357114284;
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //else
            //return sentProtocol.getProtocolVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.141 -0400", hash_original_method = "07C91BB13E357235D0646F9B1302A813", hash_generated_method = "A2E73F777BE960BA92D3F6067123AC56")
    public Protocol getSentProtocol() {
        Protocol varB4EAC82CA7396A68D541C85D26508E83_1782279237 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1782279237 = sentProtocol;
        varB4EAC82CA7396A68D541C85D26508E83_1782279237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1782279237;
        // ---------- Original Method ----------
        //return sentProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.142 -0400", hash_original_method = "834E4BBD7298D05AE3719FD543779099", hash_generated_method = "D33981A18802B1773DBB71CDD8CA84C6")
    public HostPort getSentBy() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1207598981 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1207598981 = sentBy;
        varB4EAC82CA7396A68D541C85D26508E83_1207598981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1207598981;
        // ---------- Original Method ----------
        //return sentBy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.143 -0400", hash_original_method = "D671032CD8E13BB36667C287933AFA1D", hash_generated_method = "165DCAB6B07066A6982AB59CD44CF06C")
    public Hop getHop() {
        Hop varB4EAC82CA7396A68D541C85D26508E83_1162091976 = null; //Variable for return #1
        HopImpl hop;
        hop = new HopImpl(sentBy.getHost().getHostname(),
                sentBy.getPort(),sentProtocol.getTransport());
        varB4EAC82CA7396A68D541C85D26508E83_1162091976 = hop;
        varB4EAC82CA7396A68D541C85D26508E83_1162091976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1162091976;
        // ---------- Original Method ----------
        //HopImpl hop = new HopImpl(sentBy.getHost().getHostname(),
                //sentBy.getPort(),sentProtocol.getTransport());
        //return hop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.143 -0400", hash_original_method = "50080B5B5AC1614DCB7B006B51F53E3F", hash_generated_method = "688018FC4628E76BDE76A0B2BAB6FAEA")
    public NameValueList getViaParms() {
        NameValueList varB4EAC82CA7396A68D541C85D26508E83_1786430350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1786430350 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1786430350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1786430350;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.158 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "C5AE2CE1F82C28E69A419BEE7C72D946")
    public String getComment() {
        String varB4EAC82CA7396A68D541C85D26508E83_1995175214 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1995175214 = comment;
        varB4EAC82CA7396A68D541C85D26508E83_1995175214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1995175214;
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.159 -0400", hash_original_method = "60E8CE9FCECD3622E03D9910A9625801", hash_generated_method = "CC11BBB55E05014C74BA31B5F671C35B")
    public boolean hasPort() {
        boolean varA9B995C4FEFE1CD5691B349CAE3F341B_786231793 = ((getSentBy()).hasPort());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111363566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111363566;
        // ---------- Original Method ----------
        //return (getSentBy()).hasPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.161 -0400", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "BF47DEFEE095350B7F5EAACD7192D688")
    public boolean hasComment() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672241307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672241307;
        // ---------- Original Method ----------
        //return comment != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.162 -0400", hash_original_method = "944AB7146038DECB09A155E81BB22663", hash_generated_method = "79CD3AAB4B019027F3580A1A1672D020")
    public void removePort() {
        sentBy.removePort();
        // ---------- Original Method ----------
        //sentBy.removePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.162 -0400", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "61BD4B46829E380C1561798A83B14603")
    public void removeComment() {
        comment = null;
        // ---------- Original Method ----------
        //comment = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.162 -0400", hash_original_method = "EAF98E914AE1C4A3745B20F70C227AC7", hash_generated_method = "3DF319B3995B0254B23B70CA4F88E3FA")
    public void setProtocolVersion(String protocolVersion) {
        sentProtocol = new Protocol();
        sentProtocol.setProtocolVersion(protocolVersion);
        addTaint(protocolVersion.getTaint());
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setProtocolVersion(protocolVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.162 -0400", hash_original_method = "DC556AA065BEAF9D4C2B976D57E39DA8", hash_generated_method = "67CE5B6EBE01C1896A24187536D934A2")
    public void setHost(Host host) {
        {
            sentBy = new HostPort();
        } //End block
        sentBy.setHost(host);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
        //if (sentBy == null) {
            //sentBy = new HostPort();
        //}
        //sentBy.setHost(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.163 -0400", hash_original_method = "F4FB101A445D5E49EE8B10DCE47E32FC", hash_generated_method = "5256462B357CC08BC06E273F7E8B63C4")
    public void setSentProtocol(Protocol s) {
        sentProtocol = s;
        // ---------- Original Method ----------
        //sentProtocol = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.163 -0400", hash_original_method = "543B4EA18E4F8858630BB59B262697DA", hash_generated_method = "63DB9B02D21F6151DDBE43BA55FA92E9")
    public void setSentBy(HostPort s) {
        sentBy = s;
        // ---------- Original Method ----------
        //sentBy = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.163 -0400", hash_original_method = "DE8908B9CA5447E854A0D06D0B1B9195", hash_generated_method = "23ECBD58C40560F298AA32A25976DB82")
    public void setComment(String c) {
        comment = c;
        // ---------- Original Method ----------
        //comment = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.164 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "45BEE1DB6799E679E66883E7D286F6E3")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1924992084 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1924992084 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1924992084.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1924992084;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.181 -0400", hash_original_method = "C937D3FA4F8C32F6B76B74CD5C9B4805", hash_generated_method = "1285D751FADE83996B5362F4547407CA")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_266012426 = null; //Variable for return #1
        sentProtocol.encode(buffer);
        buffer.append(SP);
        sentBy.encode(buffer);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1959114047 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        {
            buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        } //End block
        buffer.append(";rport");
        varB4EAC82CA7396A68D541C85D26508E83_266012426 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_266012426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_266012426;
        // ---------- Original Method ----------
        //sentProtocol.encode(buffer);
        //buffer.append(SP);
        //sentBy.encode(buffer);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //if (comment != null) {
            //buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        //}
        //if (rPortFlag) buffer.append(";rport");
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.181 -0400", hash_original_method = "A6610C3C674AD8475435D641E21474E9", hash_generated_method = "7028DE4B1331C92B58042C73DFDF4B11")
    public void setHost(String host) throws ParseException {
        sentBy = new HostPort();
        try 
        {
            Host h;
            h = new Host(host);
            sentBy.setHost(h);
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" host parameter is null");
        } //End block
        addTaint(host.getTaint());
        // ---------- Original Method ----------
        //if (sentBy == null)
            //sentBy = new HostPort();
        //try {
            //Host h = new Host(host);
            //sentBy.setHost(h);
        //} catch (Exception e) {
            //throw new NullPointerException(" host parameter is null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.182 -0400", hash_original_method = "C40590C8092ADD61F2FE2F813826D182", hash_generated_method = "3D5EC285DCDC4E2041E52C4CE1E2917E")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1035637736 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1317978876 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1955772509 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1035637736 = null;
        {
            Host host;
            host = sentBy.getHost();
            varB4EAC82CA7396A68D541C85D26508E83_1317978876 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1955772509 = host.getHostname();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1654818363; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1654818363 = varB4EAC82CA7396A68D541C85D26508E83_1035637736;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1654818363 = varB4EAC82CA7396A68D541C85D26508E83_1317978876;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1654818363 = varB4EAC82CA7396A68D541C85D26508E83_1955772509;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1654818363.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1654818363;
        // ---------- Original Method ----------
        //if (sentBy == null)
            //return null;
        //else {
            //Host host = sentBy.getHost();
            //if (host == null)
                //return null;
            //else
                //return host.getHostname();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.186 -0400", hash_original_method = "3BFDF83597585B440A29B8E314A4320F", hash_generated_method = "31395B1EC6918101805656AEAD14947A")
    public void setPort(int port) throws InvalidArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
        } //End block
        sentBy = new HostPort();
        sentBy.setPort(port);
        addTaint(port);
        // ---------- Original Method ----------
        //if ( port!=-1 && (port<1 || port>65535)) {
            //throw new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
        //}
        //if (sentBy == null)
            //sentBy = new HostPort();
        //sentBy.setPort(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.187 -0400", hash_original_method = "524778E64DA2B969E2ED4D2BD7E92B55", hash_generated_method = "7B6A17B05EF5967791C55E81D8F72366")
    public void setRPort() {
        rPortFlag = true;
        // ---------- Original Method ----------
        //rPortFlag = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.187 -0400", hash_original_method = "E4A7E9B0C37CC00BF245A9AEF6038FD8", hash_generated_method = "2C4E92D21893E105566641783EB274F7")
    public int getPort() {
        int var1F971C6C371EAF98B044A213E0F08CE2_2115021665 = (sentBy.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805330520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805330520;
        // ---------- Original Method ----------
        //if (sentBy == null)
            //return -1;
        //return sentBy.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.191 -0400", hash_original_method = "8F51D2BD996E5077EFE382EF5CCB28F7", hash_generated_method = "D1E96BD983489430FD9E5B4CAE63B023")
    public int getRPort() {
        String strRport;
        strRport = getParameter(ParameterNames.RPORT);
        {
            boolean var8E95033F2505B01B0D05C3D59477EE79_1617196608 = (strRport != null && ! strRport.equals(""));
            int varAEB3681EA4A53125B3833EAD829AB0EB_478078876 = (Integer.valueOf(strRport).intValue());
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292884712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292884712;
        // ---------- Original Method ----------
        //String strRport = getParameter(ParameterNames.RPORT);
        //if (strRport != null && ! strRport.equals(""))
            //return Integer.valueOf(strRport).intValue();
         //else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.191 -0400", hash_original_method = "2C7D6CB162F307BBDEA3C529EA37600B", hash_generated_method = "AD4B5C3BE85970DB58EAD1805288E286")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1590275981 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2031210834 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1590275981 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2031210834 = sentProtocol.getTransport();
        String varA7E53CE21691AB073D9660D615818899_98250547; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_98250547 = varB4EAC82CA7396A68D541C85D26508E83_1590275981;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_98250547 = varB4EAC82CA7396A68D541C85D26508E83_2031210834;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_98250547.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_98250547;
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //return sentProtocol.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.195 -0400", hash_original_method = "DA10FBD3B27193627F0BF00A97E141AB", hash_generated_method = "A1A9F358B7AEDC92892F67FBB5177D9A")
    public void setTransport(String transport) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setTransport(), the transport parameter is null.");
        sentProtocol = new Protocol();
        sentProtocol.setTransport(transport);
        addTaint(transport.getTaint());
        // ---------- Original Method ----------
        //if (transport == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setTransport(), the transport parameter is null.");
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setTransport(transport);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.198 -0400", hash_original_method = "076253ECD4074E0CF94E6CAE84ACD031", hash_generated_method = "D502367D3E251BE549B25CCF2F23A3A0")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1333888018 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1993638231 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1333888018 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1993638231 = sentProtocol.getProtocol();
        String varA7E53CE21691AB073D9660D615818899_1083857943; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1083857943 = varB4EAC82CA7396A68D541C85D26508E83_1333888018;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1083857943 = varB4EAC82CA7396A68D541C85D26508E83_1993638231;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1083857943.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1083857943;
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //return sentProtocol.getProtocol();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.198 -0400", hash_original_method = "983A1DB4807CBA4F5F74F526664C05F9", hash_generated_method = "87EA733C7E9FA58C34F0937F3D81B7A3")
    public void setProtocol(String protocol) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setProtocol(), the protocol parameter is null.");
        sentProtocol = new Protocol();
        sentProtocol.setProtocol(protocol);
        addTaint(protocol.getTaint());
        // ---------- Original Method ----------
        //if (protocol == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setProtocol(), the protocol parameter is null.");
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setProtocol(protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.212 -0400", hash_original_method = "AB2BF7863E6929FA549276BF1FCB8F41", hash_generated_method = "8679CEBCC65984BE54BC357EC7FBFC77")
    public int getTTL() {
        int ttl;
        ttl = getParameterAsInt(ParameterNames.TTL);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523846518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523846518;
        // ---------- Original Method ----------
        //int ttl = getParameterAsInt(ParameterNames.TTL);
        //return ttl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.215 -0400", hash_original_method = "275C0FDDD82C74D9D06FF2EBDF31F802", hash_generated_method = "DAC980A428F900A63CE0A2FB51858A48")
    public void setTTL(int ttl) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", Via, setTTL(), the ttl parameter is < 0");
        setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
        addTaint(ttl);
        // ---------- Original Method ----------
        //if (ttl < 0 && ttl != -1)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", Via, setTTL(), the ttl parameter is < 0");
        //setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.217 -0400", hash_original_method = "BA8497BF19C86E6498457C19F33C2BB1", hash_generated_method = "114398CC111917C0152F862AE551FBCB")
    public String getMAddr() {
        String varB4EAC82CA7396A68D541C85D26508E83_1038669707 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1038669707 = getParameter(ParameterNames.MADDR);
        varB4EAC82CA7396A68D541C85D26508E83_1038669707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1038669707;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.MADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.218 -0400", hash_original_method = "6AB0C98EE8B2466C821195A9A73846A0", hash_generated_method = "1D4BCA81089D43B878640406644F940A")
    public void setMAddr(String mAddr) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setMAddr(), the mAddr parameter is null.");
        Host host;
        host = new Host();
        host.setAddress(mAddr);
        NameValue nameValue;
        nameValue = new NameValue(ParameterNames.MADDR, host);
        setParameter(nameValue);
        addTaint(mAddr.getTaint());
        // ---------- Original Method ----------
        //if (mAddr == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setMAddr(), the mAddr parameter is null.");
        //Host host = new Host();
        //host.setAddress(mAddr);
        //NameValue nameValue = new NameValue(ParameterNames.MADDR, host);
        //setParameter(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.218 -0400", hash_original_method = "25AF7C33721E5D780684174C5845DEAD", hash_generated_method = "CD1138FAD854F7AD64C0073818203B7A")
    public String getReceived() {
        String varB4EAC82CA7396A68D541C85D26508E83_1255248515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1255248515 = getParameter(ParameterNames.RECEIVED);
        varB4EAC82CA7396A68D541C85D26508E83_1255248515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1255248515;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.RECEIVED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.218 -0400", hash_original_method = "F727BD69B2536BBCBA80253D70F95056", hash_generated_method = "40C5C7EFFDEB6A0B9A13D05577FB4BAE")
    public void setReceived(String received) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setReceived(), the received parameter is null.");
        setParameter(ParameterNames.RECEIVED, received);
        addTaint(received.getTaint());
        // ---------- Original Method ----------
        //if (received == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setReceived(), the received parameter is null.");
        //setParameter(ParameterNames.RECEIVED, received);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.223 -0400", hash_original_method = "9A958EF7B290CF5A27A4EB96F15158F0", hash_generated_method = "464E5DD4536FCC01AB97BF6374FD8D06")
    public String getBranch() {
        String varB4EAC82CA7396A68D541C85D26508E83_1245725143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1245725143 = getParameter(ParameterNames.BRANCH);
        varB4EAC82CA7396A68D541C85D26508E83_1245725143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1245725143;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.BRANCH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.225 -0400", hash_original_method = "5A56F4FACEB17A95A8FCAD93BB83EA63", hash_generated_method = "967C4689396F87A556FF0D6E6BD9E609")
    public void setBranch(String branch) throws ParseException {
        {
            boolean var4C46677D9B30E6CB7B7BB28849DA9864_1764113378 = (branch == null || branch.length()==0);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setBranch(), the branch parameter is null or length 0.");
        } //End collapsed parenthetic
        setParameter(ParameterNames.BRANCH, branch);
        addTaint(branch.getTaint());
        // ---------- Original Method ----------
        //if (branch == null || branch.length()==0)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setBranch(), the branch parameter is null or length 0.");
        //setParameter(ParameterNames.BRANCH, branch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.228 -0400", hash_original_method = "252C53006150044E4EBAAC8A002E65B1", hash_generated_method = "24A6E9E63D7200F128C759B4FFA7C05E")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1977618627 = null; //Variable for return #1
        Via retval;
        retval = (Via) super.clone();
        retval.sentProtocol = (Protocol) this.sentProtocol.clone();
        retval.sentBy = (HostPort) this.sentBy.clone();
        {
            boolean var0F30CA1BAF298E42629D8419B9FFBC30_1933021278 = (this.getRPort() != -1);
            retval.setParameter(RPORT,this.getRPort());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1977618627 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1977618627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1977618627;
        // ---------- Original Method ----------
        //Via retval = (Via) super.clone();
        //if (this.sentProtocol != null)
            //retval.sentProtocol = (Protocol) this.sentProtocol.clone();
        //if (this.sentBy != null)
            //retval.sentBy = (HostPort) this.sentBy.clone();
        //if ( this.getRPort() != -1)
            //retval.setParameter(RPORT,this.getRPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.232 -0400", hash_original_method = "5347FDDA2C7AAC95D7D1D2F666800B71", hash_generated_method = "717F83D65AE5547BD0C42E74778F8BBE")
    public String getSentByField() {
        String varB4EAC82CA7396A68D541C85D26508E83_1045376834 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1442856920 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1045376834 = sentBy.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1442856920 = null;
        String varA7E53CE21691AB073D9660D615818899_2122280120; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2122280120 = varB4EAC82CA7396A68D541C85D26508E83_1045376834;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2122280120 = varB4EAC82CA7396A68D541C85D26508E83_1442856920;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2122280120.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2122280120;
        // ---------- Original Method ----------
        //if(sentBy != null)
            //return sentBy.encode();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.232 -0400", hash_original_method = "128FFEF5D307451BA5388B5193A6BF26", hash_generated_method = "04859D8D9E52D019C92FC598BE757DA2")
    public String getSentProtocolField() {
        String varB4EAC82CA7396A68D541C85D26508E83_1182950784 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2117647648 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1182950784 = sentProtocol.encode();
        varB4EAC82CA7396A68D541C85D26508E83_2117647648 = null;
        String varA7E53CE21691AB073D9660D615818899_1336118073; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1336118073 = varB4EAC82CA7396A68D541C85D26508E83_1182950784;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1336118073 = varB4EAC82CA7396A68D541C85D26508E83_2117647648;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1336118073.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1336118073;
        // ---------- Original Method ----------
        //if(sentProtocol != null)
            //return sentProtocol.encode();
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.232 -0400", hash_original_field = "0179E78CAC3DA14C2FFC9A7D61106327", hash_generated_field = "7FA609527638C654E68F7927FC1C898D")

    private static long serialVersionUID = 5281728373401351378L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.232 -0400", hash_original_field = "EEAA4D02BE43B89B52AFD8DC453B4BFD", hash_generated_field = "22327A98EDD3D141225105CEAD3ABB13")

    public static final String BRANCH = ParameterNames.BRANCH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.232 -0400", hash_original_field = "9B0F9FB69328D59E52F3C0D780928331", hash_generated_field = "4D8C5F2DB4C0964744FED89BE27D1A75")

    public static final String RECEIVED = ParameterNames.RECEIVED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.232 -0400", hash_original_field = "0C3EC7D99BD0916DCE7C7A2913106895", hash_generated_field = "4AA8F81F93B467DE58E70654B3136851")

    public static final String MADDR = ParameterNames.MADDR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.232 -0400", hash_original_field = "A27202196DCCEEDEB9F7293943B39842", hash_generated_field = "EAB3FB3A2E323EFD5528878B03366C28")

    public static final String TTL = ParameterNames.TTL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.233 -0400", hash_original_field = "B1E3516AD1F9BEC949E47B776969F649", hash_generated_field = "180F648B89D676D4D5F0240DFDFE1D7D")

    public static final String RPORT = ParameterNames.RPORT;
}

