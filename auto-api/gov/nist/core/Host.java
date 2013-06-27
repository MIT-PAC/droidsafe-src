package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.*;

public class Host extends GenericObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.619 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.619 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.619 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.619 -0400", hash_original_field = "DAB18F803846D30BD59F639E670E0D80", hash_generated_field = "EC06D3E6C812B85A7A5E2E30C0116CD1")

    private InetAddress inetAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.620 -0400", hash_original_method = "11FB0BA24AED11EB92365CE28BAFE602", hash_generated_method = "574F594357DF9FBF615091F7035CC8B1")
    public  Host() {
        addressType = HOSTNAME;
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //addressType = HOSTNAME;
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.620 -0400", hash_original_method = "1C54F901C7075E148109F48E4FA121E8", hash_generated_method = "9AED3A5C1140EFC92586384103DBA8E0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.628 -0400", hash_original_method = "9150DE1483C0BC278AB5442475C15F45", hash_generated_method = "A75D4E51624006C9A100B57F83FB5453")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.629 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "DF5681103EBC4837D20B207E7CDF0372")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1969991441 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1969991441 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1969991441.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1969991441;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.632 -0400", hash_original_method = "5E49E67C5D7F1A51E2BA67DE70DCB03A", hash_generated_method = "FABC9DA218A41C412B9F2E8465124BDD")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1286662726 = null; //Variable for return #1
        {
            boolean varC42F861CC5187346BD2960ED9E9EAA83_828776755 = (addressType == IPV6ADDRESS && !isIPv6Reference(hostname));
            {
                buffer.append('[').append(hostname).append(']');
            } //End block
            {
                buffer.append(hostname);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1286662726 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1286662726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1286662726;
        // ---------- Original Method ----------
        //if (addressType == IPV6ADDRESS && !isIPv6Reference(hostname)) {
            //buffer.append('[').append(hostname).append(']');
        //} else {
            //buffer.append(hostname);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.632 -0400", hash_original_method = "9C0AAF91E5C10F0884CC4B99F07D9A3D", hash_generated_method = "EC72AFBAC63DF253564ED0A63715EC1E")
    public boolean equals(Object obj) {
        {
            boolean varF430D99975F55787AA0688FDA94E30EC_1496921046 = (!this.getClass().equals(obj.getClass()));
        } //End collapsed parenthetic
        Host otherHost;
        otherHost = (Host) obj;
        boolean varA2609A8AC616E986006CB3180E3E58D7_395568515 = (otherHost.hostname.equals(hostname));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480825642 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480825642;
        // ---------- Original Method ----------
        //if ( obj == null ) return false;
        //if (!this.getClass().equals(obj.getClass())) {
            //return false;
        //}
        //Host otherHost = (Host) obj;
        //return otherHost.hostname.equals(hostname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.633 -0400", hash_original_method = "01D438C7CBE6320DFE75C4BCB8CCFBCD", hash_generated_method = "190598BBCB031AF03A17154F92A7605E")
    public String getHostname() {
        String varB4EAC82CA7396A68D541C85D26508E83_1374743463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1374743463 = hostname;
        varB4EAC82CA7396A68D541C85D26508E83_1374743463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374743463;
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.633 -0400", hash_original_method = "4A9CAFF1CF2BA97BC04195E67D0EDAE7", hash_generated_method = "5706B39B0BB1C8A73B11F8563ED11D6E")
    public String getAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1159561875 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1159561875 = hostname;
        varB4EAC82CA7396A68D541C85D26508E83_1159561875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1159561875;
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.652 -0400", hash_original_method = "217AB83550ED2E15188C82C367958B30", hash_generated_method = "90FB2C408AE7C3C24BA259458DF3265F")
    public String getIpAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_136015251 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1164986504 = null; //Variable for return #2
        String rawIpAddress;
        rawIpAddress = null;
        varB4EAC82CA7396A68D541C85D26508E83_136015251 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1164986504 = rawIpAddress;
        String varA7E53CE21691AB073D9660D615818899_1301878038; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1301878038 = varB4EAC82CA7396A68D541C85D26508E83_136015251;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1301878038 = varB4EAC82CA7396A68D541C85D26508E83_1164986504;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1301878038.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1301878038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.652 -0400", hash_original_method = "034E33BB1D9418D32D19E4F440D283F7", hash_generated_method = "CB6A117406F83D1214E324F6D778CB2D")
    public void setHostname(String h) {
        setHost(h, HOSTNAME);
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        //setHost(h, HOSTNAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.653 -0400", hash_original_method = "FD1F209D65B716B09B8932A7E5ED8BB4", hash_generated_method = "BDBF4DC141FEBFC55C51CE5D4CA69539")
    public void setHostAddress(String address) {
        setHost(address, IPV4ADDRESS);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //setHost(address, IPV4ADDRESS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.653 -0400", hash_original_method = "B4E9CFE10688A14DAC1625E8CC87AC41", hash_generated_method = "E6C9915AD1010DADE9EFE8DC0336E1CD")
    private void setHost(String host, int type) {
        inetAddress = null;
        {
            boolean var0347F48FF606A14005C4A51713FA20DF_997869605 = (isIPv6Address(host));
            addressType = IPV6ADDRESS;
            addressType = type;
        } //End collapsed parenthetic
        {
            hostname = host.trim();
            hostname = hostname.toLowerCase();
            int zoneStart;
            zoneStart = -1;
            {
                boolean varBCCE67908E18F25EF18442C4798C4DA1_903167943 = (addressType == IPV6ADDRESS
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.654 -0400", hash_original_method = "40D2051A869C7630B2CBDEFFB67D40A0", hash_generated_method = "95F285FF94B19712D454B3DAD90AD537")
    public void setAddress(String address) {
        this.setHostAddress(address);
        addTaint(address.getTaint());
        // ---------- Original Method ----------
        //this.setHostAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.654 -0400", hash_original_method = "E77AF8452BCCF2463D33B3FB98136CBC", hash_generated_method = "9CFC7EB6C25F3D3FFFC464FD81122F5F")
    public boolean isHostname() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610145130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_610145130;
        // ---------- Original Method ----------
        //return addressType == HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.654 -0400", hash_original_method = "99CC342CC6A41D10B099489516EB4814", hash_generated_method = "6FCE9FD4EBA3A7477C38AA3C1383EAB5")
    public boolean isIPAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1063707572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1063707572;
        // ---------- Original Method ----------
        //return addressType != HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.655 -0400", hash_original_method = "0FE7E7513DCC8527F5BCCDE13498B6DC", hash_generated_method = "BE011333748BB62E6FEC6379486613F5")
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2043633146 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1102258638 = null; //Variable for return #2
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_450123784 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_2043633146 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1102258638 = inetAddress;
        inetAddress = InetAddress.getByName(hostname);
        varB4EAC82CA7396A68D541C85D26508E83_450123784 = inetAddress;
        InetAddress varA7E53CE21691AB073D9660D615818899_615134749; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_615134749 = varB4EAC82CA7396A68D541C85D26508E83_2043633146;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_615134749 = varB4EAC82CA7396A68D541C85D26508E83_1102258638;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_615134749 = varB4EAC82CA7396A68D541C85D26508E83_450123784;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_615134749.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_615134749;
        // ---------- Original Method ----------
        //if (hostname == null)
            //return null;
        //if (inetAddress != null)
            //return inetAddress;
        //inetAddress = InetAddress.getByName(hostname);
        //return inetAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.656 -0400", hash_original_method = "22A9CB4332482AECEE114125E6F63C27", hash_generated_method = "62723AF8C1AC2897AC7872161B146F04")
    private boolean isIPv6Address(String address) {
        boolean varDA2F3B3113CA9DF23C9D794B020BA074_546877091 = ((address != null && address.indexOf(':') != -1));
        addTaint(address.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651928850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651928850;
        // ---------- Original Method ----------
        //return (address != null && address.indexOf(':') != -1);
    }

    
        public static boolean isIPv6Reference(String address) {
        return address.charAt(0) == '['
            && address.charAt(address.length() - 1) == ']';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.667 -0400", hash_original_method = "0C8DED4D9F69E994518D3B4A84463600", hash_generated_method = "58BDEBAC3385FFDC0F790D0FEB1F79A8")
    @Override
    public int hashCode() {
        int var84D187FFCA49AC864F6DAE98B5BBEA7E_1682330743 = (this.getHostname().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720869415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720869415;
        // ---------- Original Method ----------
        //return this.getHostname().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.668 -0400", hash_original_field = "B026E1CE323EAD08BEDF0A2652E5AE19", hash_generated_field = "96911DDD64EA33F2747F16B920202F7B")

    private static long serialVersionUID = -7233564517978323344L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.668 -0400", hash_original_field = "94AAA182DE4276C933B202AECA4ED938", hash_generated_field = "8E41396E6280FA55B750BEA79C43C74D")

    protected static int HOSTNAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.668 -0400", hash_original_field = "54A3D31D83E5B5BA6F4E18655A9B9733", hash_generated_field = "674154749CADC92194F794DB7DFB39B0")

    protected static int IPV4ADDRESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.668 -0400", hash_original_field = "E2806672E22BBB75C2CBFA041210B36A", hash_generated_field = "1EDA0CA7FFD4EDB3C624F40D466746AA")

    protected static int IPV6ADDRESS = 3;
}

