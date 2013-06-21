package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.*;

public final class HostPort extends GenericObject {
    protected Host host;
    protected int port;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.612 -0400", hash_original_method = "53C1CBAC5F64E6F014615AADE272B0C0", hash_generated_method = "A8DA055BA683C65FA6DCC1F530F578DA")
    @DSModeled(DSC.SAFE)
    public HostPort() {
        host = null;
        port = -1;
        // ---------- Original Method ----------
        //host = null;
        //port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.613 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "E39D5B0A290B685B6024F605C27E0E64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_1790519419 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.613 -0400", hash_original_method = "9895EDF602B81195878A0876FA0B4C29", hash_generated_method = "4259AAA353A0D9A34123AC2ED73968FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        host.encode(buffer);
        buffer.append(COLON).append(port);
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //host.encode(buffer);
        //if (port != -1)
            //buffer.append(COLON).append(port);
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.613 -0400", hash_original_method = "86C54BFDD185E9407C74F8F297BEF1D3", hash_generated_method = "515BD3EC4EB1598E3DC00C4A0200882C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean var877A20298FB5E9D29EBE53EB7125AC7B_706326508 = (getClass () != other.getClass ());
        } //End collapsed parenthetic
        HostPort that;
        that = (HostPort) other;
        boolean varAD6C8C9FD0C6E51369F7190B1BF287BD_311761859 = (port == that.port && host.equals(that.host));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other == null) return false;
        //if (getClass () != other.getClass ()) {
            //return false;
        //}
        //HostPort that = (HostPort) other;
        //return port == that.port && host.equals(that.host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.613 -0400", hash_original_method = "46CD61CB12D2C2108CCC2BF62B36641B", hash_generated_method = "3555F8D06B8312AE2575A4D004B477C9")
    @DSModeled(DSC.SAFE)
    public Host getHost() {
        return (Host)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.614 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8BF4A6FA909B3C248D759F576AC567CD")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.614 -0400", hash_original_method = "B050407BAA043C3F798F83BEFE766D07", hash_generated_method = "51F49D42E04F3A06C4FE12BA75C69B35")
    @DSModeled(DSC.SAFE)
    public boolean hasPort() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return port != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.614 -0400", hash_original_method = "7FD66A68FF224A3837669EDD9AB43DAE", hash_generated_method = "A49641C3828C7BB69086DC31891642EB")
    @DSModeled(DSC.SAFE)
    public void removePort() {
        port = -1;
        // ---------- Original Method ----------
        //port = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.614 -0400", hash_original_method = "7261FADCCAAD2D84DAF8700A574E33AD", hash_generated_method = "DD14537673D972D335C4195D71A98C1C")
    @DSModeled(DSC.SAFE)
    public void setHost(Host h) {
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
        //host = h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.614 -0400", hash_original_method = "77F84B839458179E7DBAF505404F4852", hash_generated_method = "A66CC22EB53B418D578E63E47A6C1529")
    @DSModeled(DSC.SAFE)
    public void setPort(int p) {
        dsTaint.addTaint(p);
        // ---------- Original Method ----------
        //port = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.614 -0400", hash_original_method = "1454562F409CD451F70F3E17F975E5B5", hash_generated_method = "B1F1BC0307A9AEEAA849EC432A2501C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getInetAddress() throws java.net.UnknownHostException {
        InetAddress varBE16BC0F8C790C266308CAAD581B454F_1079982616 = (host.getInetAddress());
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (host == null)
            //return null;
        //else
            //return host.getInetAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.615 -0400", hash_original_method = "02B5610089173D5B9ACA58E6AEBD3C51", hash_generated_method = "06BD34F06372670553A4787A2AF1525A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void merge(Object mergeObject) {
        dsTaint.addTaint(mergeObject.dsTaint);
        super.merge (mergeObject);
        port = ((HostPort) mergeObject).port;
        // ---------- Original Method ----------
        //super.merge (mergeObject);
        //if (port == -1)
            //port = ((HostPort) mergeObject).port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.615 -0400", hash_original_method = "723102D689B5DB9C81F9B317715D80D3", hash_generated_method = "035C242EBBBFA47EF737F7DFB2239FC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        HostPort retval;
        retval = (HostPort) super.clone();
        retval.host = (Host) this.host.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HostPort retval = (HostPort) super.clone();
        //if (this.host != null)
            //retval.host = (Host) this.host.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.615 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "2F46B9F798B368B8EB42388360BE1E2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_338827863 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.615 -0400", hash_original_method = "576865B2F50CE751C00A8F417860D16A", hash_generated_method = "5537D05239F5B0A6943EA8CC8628CF28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var14E0AE1CC7FA6DD48510DA0394F19DF9_576877076 = (this.host.hashCode() + this.port);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.host.hashCode() + this.port;
    }

    
    private static final long serialVersionUID = -7103412227431884523L;
}

