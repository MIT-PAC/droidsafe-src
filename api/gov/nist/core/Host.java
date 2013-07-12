package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.*;

public class Host extends GenericObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.308 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.308 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.308 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.308 -0400", hash_original_field = "DAB18F803846D30BD59F639E670E0D80", hash_generated_field = "EC06D3E6C812B85A7A5E2E30C0116CD1")

    private InetAddress inetAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.308 -0400", hash_original_method = "11FB0BA24AED11EB92365CE28BAFE602", hash_generated_method = "574F594357DF9FBF615091F7035CC8B1")
    public  Host() {
        addressType = HOSTNAME;
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //addressType = HOSTNAME;
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.309 -0400", hash_original_method = "1C54F901C7075E148109F48E4FA121E8", hash_generated_method = "2183289EF83E6FC62A753E6F52BB9E05")
    public  Host(String hostName) throws IllegalArgumentException {
        addTaint(hostName.getTaint());
    if(hostName == null)        
        {
        IllegalArgumentException var4BB926A870642C6C5AD1915679F24303_1467736271 = new IllegalArgumentException("null host name");
        var4BB926A870642C6C5AD1915679F24303_1467736271.addTaint(taint);
        throw var4BB926A870642C6C5AD1915679F24303_1467736271;
        }
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        setHost(hostName, IPV4ADDRESS);
        // ---------- Original Method ----------
        //if (hostName == null)
            //throw new IllegalArgumentException("null host name");
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        //setHost(hostName, IPV4ADDRESS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.309 -0400", hash_original_method = "9150DE1483C0BC278AB5442475C15F45", hash_generated_method = "54C21396F552F1DE0AA0C4CFFD8F2FE8")
    public  Host(String name, int addrType) {
        addTaint(addrType);
        addTaint(name.getTaint());
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        setHost(name, addrType);
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        //setHost(name, addrType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.310 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3FFB189F3E8021A3F90630F3C68FF7F8")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_382899007 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_382899007.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_382899007;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.310 -0400", hash_original_method = "5E49E67C5D7F1A51E2BA67DE70DCB03A", hash_generated_method = "8F49074C4911863852DCDEE306DCC8FB")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(addressType == IPV6ADDRESS && !isIPv6Reference(hostname))        
        {
            buffer.append('[').append(hostname).append(']');
        } //End block
        else
        {
            buffer.append(hostname);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_232446915 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_232446915.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_232446915;
        // ---------- Original Method ----------
        //if (addressType == IPV6ADDRESS && !isIPv6Reference(hostname)) {
            //buffer.append('[').append(hostname).append(']');
        //} else {
            //buffer.append(hostname);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.311 -0400", hash_original_method = "9C0AAF91E5C10F0884CC4B99F07D9A3D", hash_generated_method = "FD40018CF2098967EE4DD59D56662570")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1609591375 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046392138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046392138;
        }
    if(!this.getClass().equals(obj.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_748770384 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18350529 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_18350529;
        } //End block
        Host otherHost = (Host) obj;
        boolean var1A5182139048712E37B0EF2C9A57B958_1310004061 = (otherHost.hostname.equals(hostname));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369330232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369330232;
        // ---------- Original Method ----------
        //if ( obj == null ) return false;
        //if (!this.getClass().equals(obj.getClass())) {
            //return false;
        //}
        //Host otherHost = (Host) obj;
        //return otherHost.hostname.equals(hostname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.312 -0400", hash_original_method = "01D438C7CBE6320DFE75C4BCB8CCFBCD", hash_generated_method = "216FB4FD74BC28D2EDA319F66F1086A7")
    public String getHostname() {
String varA422790FD25D792954B908E37198A455_342248920 =         hostname;
        varA422790FD25D792954B908E37198A455_342248920.addTaint(taint);
        return varA422790FD25D792954B908E37198A455_342248920;
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.312 -0400", hash_original_method = "4A9CAFF1CF2BA97BC04195E67D0EDAE7", hash_generated_method = "FCBFB17EBAB4E995F8C760BB6FD1DA12")
    public String getAddress() {
String varA422790FD25D792954B908E37198A455_1123884881 =         hostname;
        varA422790FD25D792954B908E37198A455_1123884881.addTaint(taint);
        return varA422790FD25D792954B908E37198A455_1123884881;
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.313 -0400", hash_original_method = "217AB83550ED2E15188C82C367958B30", hash_generated_method = "82767D59AA1F3DE1E5AF06CC7BBC3DD7")
    public String getIpAddress() {
        String rawIpAddress = null;
    if(hostname == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1890430648 =         null;
        var540C13E9E156B687226421B24F2DF178_1890430648.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1890430648;
        }
    if(addressType == HOSTNAME)        
        {
            try 
            {
    if(inetAddress == null)                
                inetAddress = InetAddress.getByName(hostname);
                rawIpAddress = inetAddress.getHostAddress();
            } //End block
            catch (UnknownHostException ex)
            {
                dbgPrint("Could not resolve hostname " + ex);
            } //End block
        } //End block
        else
        {
            rawIpAddress = hostname;
        } //End block
String varB9A086326A3B77E8D4CF1FBB7004D18C_437636372 =         rawIpAddress;
        varB9A086326A3B77E8D4CF1FBB7004D18C_437636372.addTaint(taint);
        return varB9A086326A3B77E8D4CF1FBB7004D18C_437636372;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.314 -0400", hash_original_method = "034E33BB1D9418D32D19E4F440D283F7", hash_generated_method = "DB42AB4E4ECBBC545008BA4A93A2CA7D")
    public void setHostname(String h) {
        addTaint(h.getTaint());
        setHost(h, HOSTNAME);
        // ---------- Original Method ----------
        //setHost(h, HOSTNAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.315 -0400", hash_original_method = "FD1F209D65B716B09B8932A7E5ED8BB4", hash_generated_method = "0D4212529688F498CF9EAE46CE6D9701")
    public void setHostAddress(String address) {
        addTaint(address.getTaint());
        setHost(address, IPV4ADDRESS);
        // ---------- Original Method ----------
        //setHost(address, IPV4ADDRESS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.317 -0400", hash_original_method = "B4E9CFE10688A14DAC1625E8CC87AC41", hash_generated_method = "3D20A7BC34C8C596A0A4F2AE40E8EBF4")
    private void setHost(String host, int type) {
        inetAddress = null;
    if(isIPv6Address(host))        
        addressType = IPV6ADDRESS;
        else
        addressType = type;
    if(host != null)        
        {
            hostname = host.trim();
    if(addressType == HOSTNAME)            
            hostname = hostname.toLowerCase();
            int zoneStart = -1;
    if(addressType == IPV6ADDRESS
                && stripAddressScopeZones
                && (zoneStart = hostname.indexOf('%'))!= -1)            
            {
                hostname = hostname.substring(0, zoneStart);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.318 -0400", hash_original_method = "40D2051A869C7630B2CBDEFFB67D40A0", hash_generated_method = "941CA92A97EE75971DE6587F975186B7")
    public void setAddress(String address) {
        addTaint(address.getTaint());
        this.setHostAddress(address);
        // ---------- Original Method ----------
        //this.setHostAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.318 -0400", hash_original_method = "E77AF8452BCCF2463D33B3FB98136CBC", hash_generated_method = "449660CC9CA5490C83F532C90C7B002A")
    public boolean isHostname() {
        boolean var6E3CB3F008131D3B4FB6746FA4728512_124297713 = (addressType == HOSTNAME);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287497700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_287497700;
        // ---------- Original Method ----------
        //return addressType == HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.319 -0400", hash_original_method = "99CC342CC6A41D10B099489516EB4814", hash_generated_method = "88C25E434A816B6B3B1C24C846A7EC1A")
    public boolean isIPAddress() {
        boolean varC972EE7FCD416E02DAA769124D36D639_570061487 = (addressType != HOSTNAME);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970655818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970655818;
        // ---------- Original Method ----------
        //return addressType != HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.319 -0400", hash_original_method = "0FE7E7513DCC8527F5BCCDE13498B6DC", hash_generated_method = "55E2D81E875AA1AED69D2C46B2919EC4")
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
    if(hostname == null)        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_329354729 =         null;
        var540C13E9E156B687226421B24F2DF178_329354729.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_329354729;
        }
    if(inetAddress != null)        
        {
InetAddress varC7DF9E11D1E8039B1F9825069E449303_997682014 =         inetAddress;
        varC7DF9E11D1E8039B1F9825069E449303_997682014.addTaint(taint);
        return varC7DF9E11D1E8039B1F9825069E449303_997682014;
        }
        inetAddress = InetAddress.getByName(hostname);
InetAddress varC7DF9E11D1E8039B1F9825069E449303_584328922 =         inetAddress;
        varC7DF9E11D1E8039B1F9825069E449303_584328922.addTaint(taint);
        return varC7DF9E11D1E8039B1F9825069E449303_584328922;
        // ---------- Original Method ----------
        //if (hostname == null)
            //return null;
        //if (inetAddress != null)
            //return inetAddress;
        //inetAddress = InetAddress.getByName(hostname);
        //return inetAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.320 -0400", hash_original_method = "22A9CB4332482AECEE114125E6F63C27", hash_generated_method = "4912F57598AAA11863F23BD1E16F216D")
    private boolean isIPv6Address(String address) {
        addTaint(address.getTaint());
        boolean var9CA069146A536C62FFECE56588387ECE_2083848677 = ((address != null && address.indexOf(':') != -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_357453024 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_357453024;
        // ---------- Original Method ----------
        //return (address != null && address.indexOf(':') != -1);
    }

    
        public static boolean isIPv6Reference(String address) {
        return address.charAt(0) == '['
            && address.charAt(address.length() - 1) == ']';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.321 -0400", hash_original_method = "0C8DED4D9F69E994518D3B4A84463600", hash_generated_method = "9D8A9A2E7E27F69573053B50D17BB804")
    @Override
    public int hashCode() {
        int var54ADA8303F7B76F9E7A18BC10A78C88E_177998090 = (this.getHostname().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034422728 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034422728;
        // ---------- Original Method ----------
        //return this.getHostname().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.321 -0400", hash_original_field = "B026E1CE323EAD08BEDF0A2652E5AE19", hash_generated_field = "8737994A53AACC355E4CFB0E79C3792C")

    private static final long serialVersionUID = -7233564517978323344L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.321 -0400", hash_original_field = "94AAA182DE4276C933B202AECA4ED938", hash_generated_field = "9C094CF4C43BA6559AD1529F30F62BA3")

    protected static final int HOSTNAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.321 -0400", hash_original_field = "54A3D31D83E5B5BA6F4E18655A9B9733", hash_generated_field = "3EB8CD94DCB5E55D14B2CBE38E008462")

    protected static final int IPV4ADDRESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.321 -0400", hash_original_field = "E2806672E22BBB75C2CBFA041210B36A", hash_generated_field = "D2C73E05A7467C9A01517AD42711E4C4")

    protected static final int IPV6ADDRESS = 3;
}

