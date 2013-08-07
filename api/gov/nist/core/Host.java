package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.net.InetAddress;
import java.net.UnknownHostException;






public class Host extends GenericObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.316 -0400", hash_original_field = "6FA63D73209D74D0D54BC416A32DB10D", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.316 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.316 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.316 -0400", hash_original_field = "DAB18F803846D30BD59F639E670E0D80", hash_generated_field = "EC06D3E6C812B85A7A5E2E30C0116CD1")

    private InetAddress inetAddress;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.316 -0400", hash_original_method = "11FB0BA24AED11EB92365CE28BAFE602", hash_generated_method = "574F594357DF9FBF615091F7035CC8B1")
    public  Host() {
        addressType = HOSTNAME;
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //addressType = HOSTNAME;
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.316 -0400", hash_original_method = "1C54F901C7075E148109F48E4FA121E8", hash_generated_method = "8740F404EC5394B5D024134EF11AD4CA")
    public  Host(String hostName) throws IllegalArgumentException {
        addTaint(hostName.getTaint());
        if(hostName == null)        
        {
        IllegalArgumentException var4BB926A870642C6C5AD1915679F24303_773675474 = new IllegalArgumentException("null host name");
        var4BB926A870642C6C5AD1915679F24303_773675474.addTaint(taint);
        throw var4BB926A870642C6C5AD1915679F24303_773675474;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.317 -0400", hash_original_method = "9150DE1483C0BC278AB5442475C15F45", hash_generated_method = "54C21396F552F1DE0AA0C4CFFD8F2FE8")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.317 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "0E43944F7B52B1AC9777DE7A111904A4")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1539468373 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1539468373.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1539468373;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.318 -0400", hash_original_method = "5E49E67C5D7F1A51E2BA67DE70DCB03A", hash_generated_method = "66C324901C6B49B1BAEF500166748387")
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
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_118167707 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_118167707.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_118167707;
        // ---------- Original Method ----------
        //if (addressType == IPV6ADDRESS && !isIPv6Reference(hostname)) {
            //buffer.append('[').append(hostname).append(']');
        //} else {
            //buffer.append(hostname);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.318 -0400", hash_original_method = "9C0AAF91E5C10F0884CC4B99F07D9A3D", hash_generated_method = "241A880DB38E3DE1A13AFCEEAF7E036C")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_416712669 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498084261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_498084261;
        }
        if(!this.getClass().equals(obj.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1525590040 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931175958 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_931175958;
        } //End block
        Host otherHost = (Host) obj;
        boolean var1A5182139048712E37B0EF2C9A57B958_2017542662 = (otherHost.hostname.equals(hostname));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_231300444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_231300444;
        // ---------- Original Method ----------
        //if ( obj == null ) return false;
        //if (!this.getClass().equals(obj.getClass())) {
            //return false;
        //}
        //Host otherHost = (Host) obj;
        //return otherHost.hostname.equals(hostname);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.319 -0400", hash_original_method = "01D438C7CBE6320DFE75C4BCB8CCFBCD", hash_generated_method = "FF5802EC0849484907FA267AA573F082")
    public String getHostname() {
String varA422790FD25D792954B908E37198A455_640521910 =         hostname;
        varA422790FD25D792954B908E37198A455_640521910.addTaint(taint);
        return varA422790FD25D792954B908E37198A455_640521910;
        // ---------- Original Method ----------
        //return hostname;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.319 -0400", hash_original_method = "4A9CAFF1CF2BA97BC04195E67D0EDAE7", hash_generated_method = "483543E6577B8840EFBFDBC6EBF47045")
    public String getAddress() {
String varA422790FD25D792954B908E37198A455_1230298465 =         hostname;
        varA422790FD25D792954B908E37198A455_1230298465.addTaint(taint);
        return varA422790FD25D792954B908E37198A455_1230298465;
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.319 -0400", hash_original_method = "217AB83550ED2E15188C82C367958B30", hash_generated_method = "37F3CFE424F188F153658219D4590848")
    public String getIpAddress() {
        String rawIpAddress = null;
        if(hostname == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1748444799 =         null;
        var540C13E9E156B687226421B24F2DF178_1748444799.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1748444799;
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
String varB9A086326A3B77E8D4CF1FBB7004D18C_1033684749 =         rawIpAddress;
        varB9A086326A3B77E8D4CF1FBB7004D18C_1033684749.addTaint(taint);
        return varB9A086326A3B77E8D4CF1FBB7004D18C_1033684749;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.320 -0400", hash_original_method = "034E33BB1D9418D32D19E4F440D283F7", hash_generated_method = "DB42AB4E4ECBBC545008BA4A93A2CA7D")
    public void setHostname(String h) {
        addTaint(h.getTaint());
        setHost(h, HOSTNAME);
        // ---------- Original Method ----------
        //setHost(h, HOSTNAME);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.320 -0400", hash_original_method = "FD1F209D65B716B09B8932A7E5ED8BB4", hash_generated_method = "0D4212529688F498CF9EAE46CE6D9701")
    public void setHostAddress(String address) {
        addTaint(address.getTaint());
        setHost(address, IPV4ADDRESS);
        // ---------- Original Method ----------
        //setHost(address, IPV4ADDRESS);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.322 -0400", hash_original_method = "B4E9CFE10688A14DAC1625E8CC87AC41", hash_generated_method = "3D20A7BC34C8C596A0A4F2AE40E8EBF4")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.322 -0400", hash_original_method = "40D2051A869C7630B2CBDEFFB67D40A0", hash_generated_method = "941CA92A97EE75971DE6587F975186B7")
    public void setAddress(String address) {
        addTaint(address.getTaint());
        this.setHostAddress(address);
        // ---------- Original Method ----------
        //this.setHostAddress(address);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.323 -0400", hash_original_method = "E77AF8452BCCF2463D33B3FB98136CBC", hash_generated_method = "72E3BD18633B2FE348F39E17150F841B")
    public boolean isHostname() {
        boolean var6E3CB3F008131D3B4FB6746FA4728512_1537326156 = (addressType == HOSTNAME);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676286170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676286170;
        // ---------- Original Method ----------
        //return addressType == HOSTNAME;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.323 -0400", hash_original_method = "99CC342CC6A41D10B099489516EB4814", hash_generated_method = "75266E695A183B1F1C00DBD7036C8205")
    public boolean isIPAddress() {
        boolean varC972EE7FCD416E02DAA769124D36D639_1718216964 = (addressType != HOSTNAME);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319255013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_319255013;
        // ---------- Original Method ----------
        //return addressType != HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.323 -0400", hash_original_method = "0FE7E7513DCC8527F5BCCDE13498B6DC", hash_generated_method = "9DD1EC7F373CD6744340E1A3A132ED85")
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
        if(hostname == null)        
        {
InetAddress var540C13E9E156B687226421B24F2DF178_1091172281 =         null;
        var540C13E9E156B687226421B24F2DF178_1091172281.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1091172281;
        }
        if(inetAddress != null)        
        {
InetAddress varC7DF9E11D1E8039B1F9825069E449303_802352387 =         inetAddress;
        varC7DF9E11D1E8039B1F9825069E449303_802352387.addTaint(taint);
        return varC7DF9E11D1E8039B1F9825069E449303_802352387;
        }
        inetAddress = InetAddress.getByName(hostname);
InetAddress varC7DF9E11D1E8039B1F9825069E449303_1092639714 =         inetAddress;
        varC7DF9E11D1E8039B1F9825069E449303_1092639714.addTaint(taint);
        return varC7DF9E11D1E8039B1F9825069E449303_1092639714;
        // ---------- Original Method ----------
        //if (hostname == null)
            //return null;
        //if (inetAddress != null)
            //return inetAddress;
        //inetAddress = InetAddress.getByName(hostname);
        //return inetAddress;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.324 -0400", hash_original_method = "22A9CB4332482AECEE114125E6F63C27", hash_generated_method = "23B14F91F3F7D637059E32DAE56670CA")
    private boolean isIPv6Address(String address) {
        addTaint(address.getTaint());
        boolean var9CA069146A536C62FFECE56588387ECE_1188077993 = ((address != null && address.indexOf(':') != -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666340542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666340542;
        // ---------- Original Method ----------
        //return (address != null && address.indexOf(':') != -1);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isIPv6Reference(String address) {
        return address.charAt(0) == '['
            && address.charAt(address.length() - 1) == ']';
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.324 -0400", hash_original_method = "0C8DED4D9F69E994518D3B4A84463600", hash_generated_method = "CBF7F9DF7E0A5452869692BB2F814F09")
    @Override
    public int hashCode() {
        int var54ADA8303F7B76F9E7A18BC10A78C88E_2144115323 = (this.getHostname().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720472411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720472411;
        // ---------- Original Method ----------
        //return this.getHostname().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.324 -0400", hash_original_field = "B026E1CE323EAD08BEDF0A2652E5AE19", hash_generated_field = "8737994A53AACC355E4CFB0E79C3792C")

    private static final long serialVersionUID = -7233564517978323344L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.324 -0400", hash_original_field = "94AAA182DE4276C933B202AECA4ED938", hash_generated_field = "9C094CF4C43BA6559AD1529F30F62BA3")

    protected static final int HOSTNAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.324 -0400", hash_original_field = "54A3D31D83E5B5BA6F4E18655A9B9733", hash_generated_field = "3EB8CD94DCB5E55D14B2CBE38E008462")

    protected static final int IPV4ADDRESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.324 -0400", hash_original_field = "E2806672E22BBB75C2CBFA041210B36A", hash_generated_field = "D2C73E05A7467C9A01517AD42711E4C4")

    protected static final int IPV6ADDRESS = 3;
}

