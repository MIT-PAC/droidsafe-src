package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.StringTokenizer;

public final class HopImpl extends Object implements javax.sip.address.Hop, Serializable {
    protected String host;
    protected int port;
    protected String transport;
    protected boolean defaultRoute;
    protected boolean uriRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.831 -0400", hash_original_method = "0B5C776E3038172CE320CE66ECCB4725", hash_generated_method = "54A38758D8AC909CBAD035B3F85E0067")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HopImpl(String hostName, int portNumber, String trans) {
        dsTaint.addTaint(portNumber);
        dsTaint.addTaint(trans);
        dsTaint.addTaint(hostName);
        {
            boolean var63E8E567575335608860CF93ABED8209_1764279944 = (host.indexOf(":") >= 0);
            {
                boolean varFD50F873716FDE8220E1F82E415385FD_24023949 = (host.indexOf("[") < 0);
                host = "[" + host + "]";
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //host = hostName;
        //if(host.indexOf(":") >= 0)
            //if(host.indexOf("[") < 0)
                //host = "[" + host + "]";
        //port = portNumber;
        //transport = trans;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.831 -0400", hash_original_method = "54879B5E9B62042FEEDC1EE4ADCFBB66", hash_generated_method = "F70E964D4A6603329788DEC6B0233F01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HopImpl(String hop) throws IllegalArgumentException {
        dsTaint.addTaint(hop);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null arg!");
        int brack;
        brack = hop.indexOf(']');
        int colon;
        colon = hop.indexOf(':',brack);
        int slash;
        slash = hop.indexOf('/',colon);
        {
            this.host = hop.substring(0,colon);
            String portstr;
            {
                portstr = hop.substring(colon+1,slash);
                this.transport = hop.substring(slash+1);
            } //End block
            {
                portstr = hop.substring(colon+1);
                this.transport = "UDP";
            } //End block
            try 
            {
                port = Integer.parseInt(portstr);
            } //End block
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad port spec");
            } //End block
        } //End block
        {
            {
                this.host = hop.substring(0,slash);
                this.transport = hop.substring(slash+1);
                this.port = transport.equalsIgnoreCase("TLS") ? 5061 : 5060;
            } //End block
            {
                this.transport = "UDP";
                this.port = 5060;
            } //End block
        } //End block
        {
            boolean var94DC33FE018780F22BEC5E2E9D5AFB43_3135771 = (host == null || host.length() == 0);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no host!");
        } //End collapsed parenthetic
        this.host = this.host.trim();
        this.transport = this.transport.trim();
        {
            boolean varEED6ACEF7545F30C1494588FA7A0B086_1114719102 = ((brack>0) && host.charAt(0)!='[');
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad IPv6 reference spec");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE3C10444A14B2F33E1A5F230EB346878_527917178 = (transport.compareToIgnoreCase("UDP") != 0
            && transport.compareToIgnoreCase("TLS") != 0
            && transport.compareToIgnoreCase("TCP") != 0);
            {
                System.err.println("Bad transport string " + transport);
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(hop);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.832 -0400", hash_original_method = "E930BE940ED709A9E92F64EC28520C28", hash_generated_method = "2191ED3335988B22EA8BBA265CF424D6")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host + ":" + port + "/" + transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.832 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "5963FFD88478AF2B93ECD8C406035DCE")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.832 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8BF4A6FA909B3C248D759F576AC567CD")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.832 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "A383C7CD7096907044A0294560B62BAB")
    @DSModeled(DSC.SAFE)
    public String getTransport() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.832 -0400", hash_original_method = "7B7F5CA7C760A6206185BE96F86E54F2", hash_generated_method = "D980A4BCF8E2E6583EAE38544FBEAABC")
    @DSModeled(DSC.SAFE)
    public boolean isURIRoute() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return uriRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.832 -0400", hash_original_method = "4D177A2C7A5E9A8C62FF46DC5D4CFB65", hash_generated_method = "B3EF0D7F68E6E1C436677D2677199934")
    @DSModeled(DSC.SAFE)
    public void setURIRouteFlag() {
        uriRoute = true;
        // ---------- Original Method ----------
        //uriRoute = true;
    }

    
}

