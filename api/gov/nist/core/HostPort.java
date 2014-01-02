package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;






public final class HostPort extends GenericObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.497 -0500", hash_original_field = "B6E681907C040B7EF7D33B2A253A060B", hash_generated_field = "7CD9CF316407E65EA07641A462BD6002")



    private static final long serialVersionUID = -7103412227431884523L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.500 -0500", hash_original_field = "A363FAEC1547C26806CDCFD82B7C056A", hash_generated_field = "8605987B023B37FAF2F8A47F30F9F11E")

    /** host field
     */
    protected Host host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.502 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.505 -0500", hash_original_method = "53C1CBAC5F64E6F014615AADE272B0C0", hash_generated_method = "69D61C714181FF9F621B4F053D667AD2")
    
public HostPort() {

        host = null;
        port = -1; // marker for not set.
    }

    /**
     * Encode this hostport into its string representation.
     * Note that this could be different from the string that has
     * been parsed if something has been edited.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.507 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.509 -0500", hash_original_method = "9895EDF602B81195878A0876FA0B4C29", hash_generated_method = "E44FBFB5A25BC842FFE4CBB37F7951D7")
    
public StringBuffer encode(StringBuffer buffer) {
        host.encode(buffer);
        if (port != -1)
            buffer.append(COLON).append(port);
        return buffer;
    }

    /** returns true if the two objects are equals, false otherwise.
     * @param other Object to set
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.512 -0500", hash_original_method = "86C54BFDD185E9407C74F8F297BEF1D3", hash_generated_method = "D42344E68A0C28B13AFC8777935ED35F")
    
public boolean equals(Object other) {
        if (other == null) return false;
        if (getClass () != other.getClass ()) {
            return false;
        }
        HostPort that = (HostPort) other;
        return port == that.port && host.equals(that.host);
    }

    /** get the Host field
     * @return host field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.514 -0500", hash_original_method = "46CD61CB12D2C2108CCC2BF62B36641B", hash_generated_method = "5379DCB35524413734142E611B5B78DE")
    
public Host getHost() {
        return host;
    }

    /** get the port field
     * @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.518 -0500", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8D4984D37D0017078DF4701090E35F25")
    
public int getPort() {
        return port;
    }

    /**
     * Returns boolean value indicating if Header has port
     * @return boolean value indicating if Header has port
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.520 -0500", hash_original_method = "B050407BAA043C3F798F83BEFE766D07", hash_generated_method = "FF3362D7E65E851E017CC900CB892AF0")
    
public boolean hasPort() {
        return port != -1;
    }

    /** remove port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.522 -0500", hash_original_method = "7FD66A68FF224A3837669EDD9AB43DAE", hash_generated_method = "34E928B984490C5205728B0498CEFEA8")
    
public void removePort() {
        port = -1;
    }

    /**
         * Set the host member
         * @param h Host to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.525 -0500", hash_original_method = "7261FADCCAAD2D84DAF8700A574E33AD", hash_generated_method = "445F2588C06EA7033D06357561366546")
    
public void setHost(Host h) {
        host = h;
    }

    /**
         * Set the port member
         * @param p int to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.527 -0500", hash_original_method = "77F84B839458179E7DBAF505404F4852", hash_generated_method = "260B712BA02ECDA7BBAEB0F29725D6EF")
    
public void setPort(int p) {
        port = p;
    }

    /** Return the internet address corresponding to the host.
     *@throws java.net.UnkownHostException if host name cannot be resolved.
     *@return the inet address for the host.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.529 -0500", hash_original_method = "1454562F409CD451F70F3E17F975E5B5", hash_generated_method = "E075F8A89FA6E570386CA142FD7370B1")
    
public InetAddress getInetAddress() throws java.net.UnknownHostException {
        if (host == null)
            return null;
        else
            return host.getInetAddress();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.531 -0500", hash_original_method = "02B5610089173D5B9ACA58E6AEBD3C51", hash_generated_method = "8ADFF6DDFF60BDFC65B2EC949A487A51")
    
public void merge(Object mergeObject) {
        super.merge (mergeObject);
        if (port == -1)
            port = ((HostPort) mergeObject).port;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.534 -0500", hash_original_method = "723102D689B5DB9C81F9B317715D80D3", hash_generated_method = "4D852C4A3F4277324E3CB29753C3FBAF")
    
public Object clone() {
        HostPort retval = (HostPort) super.clone();
        if (this.host != null)
            retval.host = (Host) this.host.clone();
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.537 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.539 -0500", hash_original_method = "576865B2F50CE751C00A8F417860D16A", hash_generated_method = "7645E3FF5B5484912DD685607842AD47")
    
@Override
    public int hashCode() {
        return this.host.hashCode() + this.port;
    }
}

