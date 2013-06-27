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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.902 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "B7178EBD81D0CF23E79BD79FD4385F5A")

    protected String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.902 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "C021A045CC358C8C262F3483738B3278")

    protected int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.902 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.902 -0400", hash_original_field = "F35E88995B01DD639351EFA9D1C5FAAA", hash_generated_field = "507947F99EFE636A32340E3AA843BB3D")

    protected boolean defaultRoute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.906 -0400", hash_original_field = "177A6DC537A1CE75A7A6EEB2280E832A", hash_generated_field = "F6D3A083A27E3AA80C885284DEF016AB")

    protected boolean uriRoute;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.907 -0400", hash_original_method = "0B5C776E3038172CE320CE66ECCB4725", hash_generated_method = "402F01CFB92DB557C0548537A2EE7D01")
    public  HopImpl(String hostName, int portNumber, String trans) {
        host = hostName;
        {
            boolean var63E8E567575335608860CF93ABED8209_1350033819 = (host.indexOf(":") >= 0);
            {
                boolean varFD50F873716FDE8220E1F82E415385FD_1617044095 = (host.indexOf("[") < 0);
                host = "[" + host + "]";
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        port = portNumber;
        transport = trans;
        // ---------- Original Method ----------
        //host = hostName;
        //if(host.indexOf(":") >= 0)
            //if(host.indexOf("[") < 0)
                //host = "[" + host + "]";
        //port = portNumber;
        //transport = trans;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.913 -0400", hash_original_method = "54879B5E9B62042FEEDC1EE4ADCFBB66", hash_generated_method = "0EDA5379AAA66309F72E6C427D6610A2")
      HopImpl(String hop) throws IllegalArgumentException {
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
                this.host = hop;
                this.transport = "UDP";
                this.port = 5060;
            } //End block
        } //End block
        {
            boolean var94DC33FE018780F22BEC5E2E9D5AFB43_599443434 = (host == null || host.length() == 0);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no host!");
        } //End collapsed parenthetic
        this.host = this.host.trim();
        this.transport = this.transport.trim();
        {
            boolean varEED6ACEF7545F30C1494588FA7A0B086_786730257 = ((brack>0) && host.charAt(0)!='[');
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad IPv6 reference spec");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE3C10444A14B2F33E1A5F230EB346878_702451595 = (transport.compareToIgnoreCase("UDP") != 0
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.916 -0400", hash_original_method = "E930BE940ED709A9E92F64EC28520C28", hash_generated_method = "AA790B9C855EFF8F789B0DE827602454")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1693367394 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1693367394 = host + ":" + port + "/" + transport;
        varB4EAC82CA7396A68D541C85D26508E83_1693367394.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1693367394;
        // ---------- Original Method ----------
        //return host + ":" + port + "/" + transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.924 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "51E74685844C4736B8C6CB005BE62B84")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1868402540 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1868402540 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1868402540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868402540;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.924 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "5EED186C9D112D7A08F5CC8CE0AE36C9")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163522541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163522541;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.927 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "C0A77A415856B4FD47AA06FFA8B4590E")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1991753615 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1991753615 = transport;
        varB4EAC82CA7396A68D541C85D26508E83_1991753615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1991753615;
        // ---------- Original Method ----------
        //return transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.928 -0400", hash_original_method = "7B7F5CA7C760A6206185BE96F86E54F2", hash_generated_method = "9D969EB6D21EEAB7BB5A53F71A973FA7")
    public boolean isURIRoute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764170633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764170633;
        // ---------- Original Method ----------
        //return uriRoute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.937 -0400", hash_original_method = "4D177A2C7A5E9A8C62FF46DC5D4CFB65", hash_generated_method = "B3EF0D7F68E6E1C436677D2677199934")
    public void setURIRouteFlag() {
        uriRoute = true;
        // ---------- Original Method ----------
        //uriRoute = true;
    }

    
}

