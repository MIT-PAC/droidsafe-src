package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.*;

public class Host extends GenericObject {
    private boolean stripAddressScopeZones = false;
    protected String hostname;
    protected int addressType;
    private InetAddress inetAddress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.584 -0400", hash_original_method = "11FB0BA24AED11EB92365CE28BAFE602", hash_generated_method = "574F594357DF9FBF615091F7035CC8B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Host() {
        addressType = HOSTNAME;
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        // ---------- Original Method ----------
        //addressType = HOSTNAME;
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.585 -0400", hash_original_method = "1C54F901C7075E148109F48E4FA121E8", hash_generated_method = "CB966A1212231822A762E5C51C84D792")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Host(String hostName) throws IllegalArgumentException {
        dsTaint.addTaint(hostName);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("null host name");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.585 -0400", hash_original_method = "9150DE1483C0BC278AB5442475C15F45", hash_generated_method = "A7901A622F9585F438E17302126D22E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Host(String name, int addrType) {
        dsTaint.addTaint(addrType);
        dsTaint.addTaint(name);
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        setHost(name, addrType);
        // ---------- Original Method ----------
        //stripAddressScopeZones
            //= Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
        //setHost(name, addrType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.586 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "9FF1887E765B83B9161244A7BC364C6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_649972360 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.586 -0400", hash_original_method = "5E49E67C5D7F1A51E2BA67DE70DCB03A", hash_generated_method = "5D6556FEBBD45F1612057F8A797AEA2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            boolean varC42F861CC5187346BD2960ED9E9EAA83_685884859 = (addressType == IPV6ADDRESS && !isIPv6Reference(hostname));
            {
                buffer.append('[').append(hostname).append(']');
            } //End block
            {
                buffer.append(hostname);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (addressType == IPV6ADDRESS && !isIPv6Reference(hostname)) {
            //buffer.append('[').append(hostname).append(']');
        //} else {
            //buffer.append(hostname);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.586 -0400", hash_original_method = "9C0AAF91E5C10F0884CC4B99F07D9A3D", hash_generated_method = "3A7FFCE2DB4071C56F0A18534438FAEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean varF430D99975F55787AA0688FDA94E30EC_596360842 = (!this.getClass().equals(obj.getClass()));
        } //End collapsed parenthetic
        Host otherHost;
        otherHost = (Host) obj;
        boolean varA2609A8AC616E986006CB3180E3E58D7_2121054371 = (otherHost.hostname.equals(hostname));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if ( obj == null ) return false;
        //if (!this.getClass().equals(obj.getClass())) {
            //return false;
        //}
        //Host otherHost = (Host) obj;
        //return otherHost.hostname.equals(hostname);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.586 -0400", hash_original_method = "01D438C7CBE6320DFE75C4BCB8CCFBCD", hash_generated_method = "B50130FE3F932BF3796F26996DDF44FB")
    @DSModeled(DSC.SAFE)
    public String getHostname() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.587 -0400", hash_original_method = "4A9CAFF1CF2BA97BC04195E67D0EDAE7", hash_generated_method = "1727FD4A8A8A9781BC306C12F71F3E21")
    @DSModeled(DSC.SAFE)
    public String getAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.587 -0400", hash_original_method = "217AB83550ED2E15188C82C367958B30", hash_generated_method = "A96B9B57C1E395CC1E4352E8C76E6C12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIpAddress() {
        String rawIpAddress;
        rawIpAddress = null;
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.587 -0400", hash_original_method = "034E33BB1D9418D32D19E4F440D283F7", hash_generated_method = "72DF5B4D5E8064DD5F707198E4D96049")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHostname(String h) {
        dsTaint.addTaint(h);
        setHost(h, HOSTNAME);
        // ---------- Original Method ----------
        //setHost(h, HOSTNAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.587 -0400", hash_original_method = "FD1F209D65B716B09B8932A7E5ED8BB4", hash_generated_method = "7E3AA9D3D6E729A9BC2BDEB19353836F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHostAddress(String address) {
        dsTaint.addTaint(address);
        setHost(address, IPV4ADDRESS);
        // ---------- Original Method ----------
        //setHost(address, IPV4ADDRESS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.588 -0400", hash_original_method = "B4E9CFE10688A14DAC1625E8CC87AC41", hash_generated_method = "BCFB1CE6786D58DCD371AFB4F218719F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setHost(String host, int type) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(type);
        inetAddress = null;
        {
            boolean var0347F48FF606A14005C4A51713FA20DF_316525764 = (isIPv6Address(host));
            addressType = IPV6ADDRESS;
        } //End collapsed parenthetic
        {
            hostname = host.trim();
            hostname = hostname.toLowerCase();
            int zoneStart;
            zoneStart = -1;
            {
                boolean varBCCE67908E18F25EF18442C4798C4DA1_2104346292 = (addressType == IPV6ADDRESS
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.588 -0400", hash_original_method = "40D2051A869C7630B2CBDEFFB67D40A0", hash_generated_method = "A0C4C20F2CD4B416ED35EAF054549882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAddress(String address) {
        dsTaint.addTaint(address);
        this.setHostAddress(address);
        // ---------- Original Method ----------
        //this.setHostAddress(address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.588 -0400", hash_original_method = "E77AF8452BCCF2463D33B3FB98136CBC", hash_generated_method = "6E146356BA22E1B7281F5AA1E95188FE")
    @DSModeled(DSC.SAFE)
    public boolean isHostname() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addressType == HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.588 -0400", hash_original_method = "99CC342CC6A41D10B099489516EB4814", hash_generated_method = "0305F08C638DDED56A601EE99269BD91")
    @DSModeled(DSC.SAFE)
    public boolean isIPAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addressType != HOSTNAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.588 -0400", hash_original_method = "0FE7E7513DCC8527F5BCCDE13498B6DC", hash_generated_method = "EF3304CBCEE14BAD5B17D7D8CD7A03C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
        inetAddress = InetAddress.getByName(hostname);
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (hostname == null)
            //return null;
        //if (inetAddress != null)
            //return inetAddress;
        //inetAddress = InetAddress.getByName(hostname);
        //return inetAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.589 -0400", hash_original_method = "22A9CB4332482AECEE114125E6F63C27", hash_generated_method = "C51CC0BDB0E1D9E60994CB4FCEEE51BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isIPv6Address(String address) {
        dsTaint.addTaint(address);
        boolean varDA2F3B3113CA9DF23C9D794B020BA074_2068479299 = ((address != null && address.indexOf(':') != -1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (address != null && address.indexOf(':') != -1);
    }

    
        public static boolean isIPv6Reference(String address) {
        return address.charAt(0) == '['
            && address.charAt(address.length() - 1) == ']';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.589 -0400", hash_original_method = "0C8DED4D9F69E994518D3B4A84463600", hash_generated_method = "D72E58DAF2B77866735F92B44BE12502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var84D187FFCA49AC864F6DAE98B5BBEA7E_323783239 = (this.getHostname().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getHostname().hashCode();
    }

    
    private static final long serialVersionUID = -7233564517978323344L;
    protected static final int HOSTNAME = 1;
    protected static final int IPV4ADDRESS = 2;
    protected static final int IPV6ADDRESS = 3;
}

