package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.*;

public class Host extends GenericObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.452 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.452 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.452 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.452 -0400", hash_original_field = "DAB18F803846D30BD59F639E670E0D80", hash_generated_field = "EC06D3E6C812B85A7A5E2E30C0116CD1")

    private InetAddress inetAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.452 -0400", hash_original_method = "11FB0BA24AED11EB92365CE28BAFE602", hash_generated_method = "574F594357DF9FBF615091F7035CC8B1")
    public  Host() {
        addressType = HOSTNAME;
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //addressType = HOSTNAME;
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.453 -0400", hash_original_method = "1C54F901C7075E148109F48E4FA121E8", hash_generated_method = "9AED3A5C1140EFC92586384103DBA8E0")
    public  Host(String hostName) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null host name");
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        setHost(hostName, IPV4ADDRESS);
        addTaint(hostName.getTaint());
        // ---------- Original Method ----------
        //if (hostName == null)
            //throw new IllegalArgumentException("null host name");
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        //setHost(hostName, IPV4ADDRESS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.453 -0400", hash_original_method = "9150DE1483C0BC278AB5442475C15F45", hash_generated_method = "A75D4E51624006C9A100B57F83FB5453")
    public  Host(String name, int addrType) {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        setHost(name, addrType);
        addTaint(name.getTaint());
        addTaint(addrType);
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        //setHost(name, addrType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.454 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "1A6DCC834576C16CA6DB0E3762FEB28B")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1744922568 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1744922568 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1744922568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744922568;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.454 -0400", hash_original_method = "5E49E67C5D7F1A51E2BA67DE70DCB03A", hash_generated_method = "26F8EF52AE7C2596B2E5EA465B689C8A")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1170340071 = null; //Variable for return #1
        {
            boolean varC42F861CC5187346BD2960ED9E9EAA83_1786680329 = (addressType == IPV6ADDRESS && !isIPv6Reference(hostname));
            {
                buffer.append('[').append(hostname).append(']');
            } //End block
            {
                buffer.append(hostname);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1170340071 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1170340071.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170340071;
        // ---------- Original Method ----------
        //if (addressType == IPV6ADDRESS && !isIPv6Reference(hostname)) {
            //buffer.append('[').append(hostname).append(']');
        //} else {
            //buffer.append(hostname);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.455 -0400", hash_original_method = "9C0AAF91E5C10F0884CC4B99F07D9A3D", hash_generated_method = "3FB1C1FFBCB3DDB08081D476D7CB413A")
    public boolean equals(Object obj) {
        {
            boolean varF430D99975F55787AA0688FDA94E30EC_472004228 = (!this.getClass().equals(obj.getClass()));
        } //End collapsed parenthetic
        Host otherHost = (Host) obj;
        boolean varA2609A8AC616E986006CB3180E3E58D7_1089846079 = (otherHost.hostname.equals(hostname));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172274361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172274361;
        // ---------- Original Method ----------
        //if ( obj == null ) return false;
        //if (!this.getClass().equals(obj.getClass())) {
            //return false;
        //}
        //Host otherHost = (Host) obj;
        //return otherHost.hostname.equals(hostname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.456 -0400", hash_original_method = "01D438C7CBE6320DFE75C4BCB8CCFBCD", hash_generated_method = "23BE554520BC05729536EA2F3947E1F7")
    public String getHostname() {
        String varB4EAC82CA7396A68D541C85D26508E83_1397215784 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1397215784 = hostname;
        varB4EAC82CA7396A68D541C85D26508E83_1397215784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1397215784;
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.457 -0400", hash_original_method = "4A9CAFF1CF2BA97BC04195E67D0EDAE7", hash_generated_method = "62B541DCA4A703C28F547BFF50C91E6F")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1126931659 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1126931659 = hostname;
        varB4EAC82CA7396A68D541C85D26508E83_1126931659.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126931659;
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.459 -0400", hash_original_method = "217AB83550ED2E15188C82C367958B30", hash_generated_method = "CFCBA014A88695EDA31F92879FB22FD2")
    public String getIpAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_2058284331 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2058905835 = null; //Variable for return #2
        String rawIpAddress = null;
        varB4EAC82CA7396A68D541C85D26508E83_2058284331 = null;
        {
            try 
            {
                inetAddress = InetAddress.getByName(hostname);
                rawIpAddress = inetAddress.getHostAddress();
            } //End block
            catch (UnknownHostException ex)
            {
                dbgPrint("Could not resolve hostname " + ex);
            } //End block
        } //End block
        {
            rawIpAddress = hostname;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2058905835 = rawIpAddress;
        String varA7E53CE21691AB073D9660D615818899_90723192; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_90723192 = varB4EAC82CA7396A68D541C85D26508E83_2058284331;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_90723192 = varB4EAC82CA7396A68D541C85D26508E83_2058905835;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_90723192.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_90723192;
        // ---------- Original Method ----------
        //String rawIpAddress = null;
        //if (hostname == null)
            //return null;
        //if (addressType == HOSTNAME) {
            //try {
                //if (inetAddress == null)
                    //inetAddress = InetAddress.getByName(hostname);
                //rawIpAddress = inetAddress.getHostAddress();
            //} catch (UnknownHostException ex) {
                //dbgPrint("Could not resolve hostname " + ex);
            //}
        //} else {
            //rawIpAddress = hostname;
        //}
        //return rawIpAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.460 -0400", hash_original_method = "034E33BB1D9418D32D19E4F440D283F7", hash_generated_method = "CB6A117406F83D1214E324F6D778CB2D")
    public void setHostname(String h) {
        setHost(h, HOSTNAME);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //setHost(h, HOSTNAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.462 -0400", hash_original_method = "FD1F209D65B716B09B8932A7E5ED8BB4", hash_generated_method = "BDBF4DC141FEBFC55C51CE5D4CA69539")
    public void setHostAddress(String address) {
        setHost(address, IPV4ADDRESS);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //setHost(address, IPV4ADDRESS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.464 -0400", hash_original_method = "B4E9CFE10688A14DAC1625E8CC87AC41", hash_generated_method = "A8D4533D5E127302A171265D5DA1BA5A")
    private void setHost(String host, int type) {
        inetAddress = null;
        {
            boolean var0347F48FF606A14005C4A51713FA20DF_1105527606 = (isIPv6Address(host));
            addressType = IPV6ADDRESS;
            addressType = type;
        } //End collapsed parenthetic
        {
            hostname = host.trim();
            hostname = hostname.toLowerCase();
            int zoneStart = -1;
            {
                boolean varBCCE67908E18F25EF18442C4798C4DA1_269857210 = (addressType == IPV6ADDRESS
                && stripAddressScopeZones
                && (zoneStart = hostname.indexOf('%'))!= -1);
                {
                    hostname = hostname.substring(0, zoneStart);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //inetAddress = null;
        //if (isIPv6Address(host))
            //addressType = IPV6ADDRESS;
        //else
            //addressType = type;
        //if (host != null){
            //hostname = host.trim();
            //if(addressType == HOSTNAME)
                //hostname = hostname.toLowerCase();
            //int zoneStart = -1;
            //if(addressType == IPV6ADDRESS
                //&& stripAddressScopeZones
                //&& (zoneStart = hostname.indexOf('%'))!= -1){
                //hostname = hostname.substring(0, zoneStart);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.465 -0400", hash_original_method = "40D2051A869C7630B2CBDEFFB67D40A0", hash_generated_method = "95F285FF94B19712D454B3DAD90AD537")
    public void setAddress(String address) {
        this.setHostAddress(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.setHostAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.466 -0400", hash_original_method = "E77AF8452BCCF2463D33B3FB98136CBC", hash_generated_method = "47BA503BD97B1BB9265D6425D12EEBF3")
    public boolean isHostname() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718856582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718856582;
        // ---------- Original Method ----------
        //return addressType == HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.466 -0400", hash_original_method = "99CC342CC6A41D10B099489516EB4814", hash_generated_method = "A939A95544521719ECA0F55250BAF566")
    public boolean isIPAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448127924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448127924;
        // ---------- Original Method ----------
        //return addressType != HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.468 -0400", hash_original_method = "0FE7E7513DCC8527F5BCCDE13498B6DC", hash_generated_method = "1964C90A48907751D155BF5A9C78F409")
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_80589571 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_317199387 = null; //Variable for return #2
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_655108227 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_80589571 = null;
        varB4EAC82CA7396A68D541C85D26508E83_317199387 = inetAddress;
        inetAddress = InetAddress.getByName(hostname);
        varB4EAC82CA7396A68D541C85D26508E83_655108227 = inetAddress;
        InetAddress varA7E53CE21691AB073D9660D615818899_681835297; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_681835297 = varB4EAC82CA7396A68D541C85D26508E83_80589571;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_681835297 = varB4EAC82CA7396A68D541C85D26508E83_317199387;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_681835297 = varB4EAC82CA7396A68D541C85D26508E83_655108227;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_681835297.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_681835297;
        // ---------- Original Method ----------
        //if (hostname == null)
            //return null;
        //if (inetAddress != null)
            //return inetAddress;
        //inetAddress = InetAddress.getByName(hostname);
        //return inetAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.468 -0400", hash_original_method = "22A9CB4332482AECEE114125E6F63C27", hash_generated_method = "D7277A740A1A52CF25B3D798BF41CD43")
    private boolean isIPv6Address(String address) {
        boolean varDA2F3B3113CA9DF23C9D794B020BA074_308019154 = ((address != null && address.indexOf(':') != -1));
        addTaint(address.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184045180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184045180;
        // ---------- Original Method ----------
        //return (address != null && address.indexOf(':') != -1);
    }

    
    public static boolean isIPv6Reference(String address) {
        return address.charAt(0) == '['
            && address.charAt(address.length() - 1) == ']';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.469 -0400", hash_original_method = "0C8DED4D9F69E994518D3B4A84463600", hash_generated_method = "D469139E929175005725DE6746378783")
    @Override
    public int hashCode() {
        int var84D187FFCA49AC864F6DAE98B5BBEA7E_1460595246 = (this.getHostname().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999600940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999600940;
        // ---------- Original Method ----------
        //return this.getHostname().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.469 -0400", hash_original_field = "B026E1CE323EAD08BEDF0A2652E5AE19", hash_generated_field = "8737994A53AACC355E4CFB0E79C3792C")

    private static final long serialVersionUID = -7233564517978323344L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.469 -0400", hash_original_field = "94AAA182DE4276C933B202AECA4ED938", hash_generated_field = "9C094CF4C43BA6559AD1529F30F62BA3")

    protected static final int HOSTNAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.469 -0400", hash_original_field = "54A3D31D83E5B5BA6F4E18655A9B9733", hash_generated_field = "3EB8CD94DCB5E55D14B2CBE38E008462")

    protected static final int IPV4ADDRESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.470 -0400", hash_original_field = "E2806672E22BBB75C2CBFA041210B36A", hash_generated_field = "D2C73E05A7467C9A01517AD42711E4C4")

    protected static final int IPV6ADDRESS = 3;
}

