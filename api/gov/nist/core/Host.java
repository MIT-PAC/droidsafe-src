package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Host extends GenericObject {

    /**
     * Verifies whether the ipv6reference, i.e. whether it enclosed in
     * square brackets
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.137 -0500", hash_original_method = "E9F0477F2CE17224EFC5A824AF02534D", hash_generated_method = "9283CCC4E13A24806ACE928243B74A32")
    
public static boolean isIPv6Reference(String address) {
        return address.charAt(0) == '['
            && address.charAt(address.length() - 1) == ']';
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.075 -0500", hash_original_field = "0AA768C7A8F01F6ADC4D7D134E7DD601", hash_generated_field = "8737994A53AACC355E4CFB0E79C3792C")

    private static final long serialVersionUID = -7233564517978323344L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.077 -0500", hash_original_field = "96AE0B41E8B753AE85E5B5858F41BF45", hash_generated_field = "9C094CF4C43BA6559AD1529F30F62BA3")

    protected static final int HOSTNAME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.080 -0500", hash_original_field = "917A054DC786B7A26715F09A15F818E7", hash_generated_field = "3EB8CD94DCB5E55D14B2CBE38E008462")

    protected static final int IPV4ADDRESS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.082 -0500", hash_original_field = "C0EF3581A456F1414698FC6B0D4F8277", hash_generated_field = "D2C73E05A7467C9A01517AD42711E4C4")

    protected static final int IPV6ADDRESS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.072 -0500", hash_original_field = "8C10C55A9BEAD35C9C3822ED5A78B55A", hash_generated_field = "0D2878F1D6B0CD805C869443DA7FE75E")

    private boolean stripAddressScopeZones = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.085 -0500", hash_original_field = "6B66041FD39815DF98C48C22668D1653", hash_generated_field = "A498A0C52EAEC26516CFC120F651D2CE")

    protected String hostname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.087 -0500", hash_original_field = "4869FD8940D9617B6A2FA4DD94896EC8", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.089 -0500", hash_original_field = "81650C71E6DA0E6758B361EDF219BF2B", hash_generated_field = "EC06D3E6C812B85A7A5E2E30C0116CD1")

    private InetAddress inetAddress;

    /** default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.093 -0500", hash_original_method = "11FB0BA24AED11EB92365CE28BAFE602", hash_generated_method = "7E8DEF282BCE0FE74D10AA663220ABD9")
    
public Host() {
        addressType = HOSTNAME;

        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");
    }

    /** Constructor given host name or IP address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.095 -0500", hash_original_method = "1C54F901C7075E148109F48E4FA121E8", hash_generated_method = "2EC0A8B9450CF91367DABD881CDD4280")
    
public Host(String hostName) throws IllegalArgumentException {
        if (hostName == null)
            throw new IllegalArgumentException("null host name");

        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");

        setHost(hostName, IPV4ADDRESS);
    }

    /** constructor
     * @param name String to set
     * @param addrType int to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.098 -0500", hash_original_method = "9150DE1483C0BC278AB5442475C15F45", hash_generated_method = "85C50C0553630F7B663D8FC2E36FAC7F")
    
public Host(String name, int addrType) {
        stripAddressScopeZones
            = Boolean.getBoolean("gov.nist.core.STRIP_ADDR_SCOPES");

        setHost(name, addrType);
    }

    /**
     * Return the host name in encoded form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.100 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.103 -0500", hash_original_method = "5E49E67C5D7F1A51E2BA67DE70DCB03A", hash_generated_method = "A85BDF8FE021DFF45787BDE1D14EDF7C")
    
public StringBuffer encode(StringBuffer buffer) {
        if (addressType == IPV6ADDRESS && !isIPv6Reference(hostname)) {
            buffer.append('[').append(hostname).append(']');
        } else {
            buffer.append(hostname);
        }
        return buffer;
    }

    /**
     * Compare for equality of hosts.
     * Host names are compared by textual equality. No dns lookup
     * is performed.
     * @param obj Object to set
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.106 -0500", hash_original_method = "9C0AAF91E5C10F0884CC4B99F07D9A3D", hash_generated_method = "EF1D778E7B4E29BECA56E28251938EAF")
    
public boolean equals(Object obj) {
        if ( obj == null ) return false;
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Host otherHost = (Host) obj;
        return otherHost.hostname.equals(hostname);

    }

    /** get the HostName field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.109 -0500", hash_original_method = "01D438C7CBE6320DFE75C4BCB8CCFBCD", hash_generated_method = "4277FADEC361BC1DBEF941BCB6F85214")
    
public String getHostname() {
        return hostname;
    }

    /** get the Address field
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.111 -0500", hash_original_method = "4A9CAFF1CF2BA97BC04195E67D0EDAE7", hash_generated_method = "7E0763923BEDBB9E8CCF39F1BED51224")
    
public String getAddress() {
        return hostname;
    }

    /**
     * Convenience function to get the raw IP destination address
     * of a SIP message as a String.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.114 -0500", hash_original_method = "217AB83550ED2E15188C82C367958B30", hash_generated_method = "CFB0C442581C5DC2E6C02DD12F3E3D89")
    
public String getIpAddress() {
        String rawIpAddress = null;
        if (hostname == null)
            return null;
        if (addressType == HOSTNAME) {
            try {
                if (inetAddress == null)
                    inetAddress = InetAddress.getByName(hostname);
                rawIpAddress = inetAddress.getHostAddress();
            } catch (UnknownHostException ex) {
                dbgPrint("Could not resolve hostname " + ex);
            }
        } else {
            rawIpAddress = hostname;
        }
        return rawIpAddress;
    }

    /**
     * Set the hostname member.
     * @param h String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.116 -0500", hash_original_method = "034E33BB1D9418D32D19E4F440D283F7", hash_generated_method = "4B5D30EB4E40D64412565A4B52700947")
    
public void setHostname(String h) {
        setHost(h, HOSTNAME);
    }

    /** Set the IP Address.
     *@param address is the address string to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.119 -0500", hash_original_method = "FD1F209D65B716B09B8932A7E5ED8BB4", hash_generated_method = "BFCD9DFB9B8D53A5A751A38926BE8578")
    
public void setHostAddress(String address) {
        setHost(address, IPV4ADDRESS);
    }

    /**
     * Sets the host address or name of this object.
     *
     * @param host that host address/name value
     * @param type determines whether host is an address or a host name
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.121 -0500", hash_original_method = "B4E9CFE10688A14DAC1625E8CC87AC41", hash_generated_method = "A1F702A5C3B497AA0A8C613F30D62133")
    
private void setHost(String host, int type){
        //set inetAddress to null so that it would be reinited
        //upon next call to getInetAddress()
        inetAddress = null;

        if (isIPv6Address(host))
            addressType = IPV6ADDRESS;
        else
            addressType = type;

        // Null check bug fix sent in by jpaulo@ipb.pt
        if (host != null){
            hostname = host.trim();

            //if this is an FQDN, make it lowercase to simplify processing
            if(addressType == HOSTNAME)
                hostname = hostname.toLowerCase();

            //remove address scope zones if this is an IPv6 address as they
            //are not allowed by the RFC
            int zoneStart = -1;
            if(addressType == IPV6ADDRESS
                && stripAddressScopeZones
                && (zoneStart = hostname.indexOf('%'))!= -1){

                hostname = hostname.substring(0, zoneStart);
            }
        }
    }

    /**
     * Set the address member
     * @param address address String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.124 -0500", hash_original_method = "40D2051A869C7630B2CBDEFFB67D40A0", hash_generated_method = "CFE567B63DF82A750020F3B3375AD609")
    
public void setAddress(String address) {
        this.setHostAddress(address);
    }

    /** Return true if the address is a DNS host name
     *  (and not an IPV4 address)
     *@return true if the hostname is a DNS name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.126 -0500", hash_original_method = "E77AF8452BCCF2463D33B3FB98136CBC", hash_generated_method = "7FB4C87EAC575769303E942AFBF1366E")
    
public boolean isHostname() {
        return addressType == HOSTNAME;
    }

    /** Return true if the address is a DNS host name
     *  (and not an IPV4 address)
     *@return true if the hostname is host address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.129 -0500", hash_original_method = "99CC342CC6A41D10B099489516EB4814", hash_generated_method = "951170F6072EBEE7723E27BC6697DA22")
    
public boolean isIPAddress() {
        return addressType != HOSTNAME;
    }

    /** Get the inet address from this host.
     * Caches the inet address returned from dns lookup to avoid
     * lookup delays.
     *
     *@throws UnkownHostexception when the host name cannot be resolved.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.131 -0500", hash_original_method = "0FE7E7513DCC8527F5BCCDE13498B6DC", hash_generated_method = "622B241C8F3A66290D0E87F3F36442E5")
    
public InetAddress getInetAddress() throws java.net.UnknownHostException {
        if (hostname == null)
            return null;
        if (inetAddress != null)
            return inetAddress;
        inetAddress = InetAddress.getByName(hostname);
        return inetAddress;

    }

    //----- IPv6
    /**
     * Verifies whether the <code>address</code> could
     * be an IPv6 address
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.134 -0500", hash_original_method = "22A9CB4332482AECEE114125E6F63C27", hash_generated_method = "1BF27C0DE5B5341ACCEFFB6DF77280E8")
    
private boolean isIPv6Address(String address) {
        return (address != null && address.indexOf(':') != -1);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.140 -0500", hash_original_method = "0C8DED4D9F69E994518D3B4A84463600", hash_generated_method = "B42CD6D823F30CBFC25048C054FB286E")
    
@Override
    public int hashCode() {
        return this.getHostname().hashCode();
        
    }
}

