package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public class Protocol extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.202 -0400", hash_original_field = "0AACAAD803286A486455DA9B0035B980", hash_generated_field = "C766D4C5CA44A223EF8697E2A0C74072")

    protected String protocolName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.202 -0400", hash_original_field = "E5EB1B1AE3E23C45B744E3125FC5B3E7", hash_generated_field = "D5DF73E283251EA2D1226355FFEB1D1C")

    protected String protocolVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.202 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.203 -0400", hash_original_method = "B029C737A70A786967A2F293EBAB35D1", hash_generated_method = "DEE5EC031EDC612478B0E1C953847222")
    public  Protocol() {
        protocolName = "SIP";
        protocolVersion = "2.0";
        transport = "UDP";
        // ---------- Original Method ----------
        //protocolName = "SIP";
        //protocolVersion = "2.0";
        //transport = "UDP";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.213 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "BCDE715F3314838B3D9ECC1A7E398008")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_452240194 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_452240194 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_452240194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_452240194;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.223 -0400", hash_original_method = "5917804CC8541DAC2CA5A0DEC050E620", hash_generated_method = "D2A03CA0B8420B7E67C8D095C22C4E9C")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_2125719509 = null; //Variable for return #1
        buffer.append(protocolName.toUpperCase())
                .append(SLASH)
                .append(protocolVersion)
                .append(SLASH)
                .append(transport.toUpperCase());
        varB4EAC82CA7396A68D541C85D26508E83_2125719509 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2125719509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2125719509;
        // ---------- Original Method ----------
        //buffer.append(protocolName.toUpperCase())
                //.append(SLASH)
                //.append(protocolVersion)
                //.append(SLASH)
                //.append(transport.toUpperCase());
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.224 -0400", hash_original_method = "0EA6E7D3A9B59E59CEEBB8D3EE9D071C", hash_generated_method = "2A390C0E79380C6130076D0353646B13")
    public String getProtocolName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2051960201 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2051960201 = protocolName;
        varB4EAC82CA7396A68D541C85D26508E83_2051960201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2051960201;
        // ---------- Original Method ----------
        //return protocolName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.224 -0400", hash_original_method = "B8FA221EC0DA8944EFD0CEB861346936", hash_generated_method = "80B8C0697EB652280E1B5AF55C7D2917")
    public String getProtocolVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1744021962 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1744021962 = protocolVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1744021962.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744021962;
        // ---------- Original Method ----------
        //return protocolVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.224 -0400", hash_original_method = "3E5201C0CB5C46DC512CD40707A0CB06", hash_generated_method = "158A7CE16AF4656E4B56CDC635A452E3")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1798812797 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1798812797 = protocolName + '/' + protocolVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1798812797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798812797;
        // ---------- Original Method ----------
        //return protocolName + '/' + protocolVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.226 -0400", hash_original_method = "095B78DD27D74EBF49777967A681F20E", hash_generated_method = "77FED0A6D22F9C071E34E50A1DA35BB6")
    public void setProtocol( String name_and_version ) throws ParseException {
        int slash;
        slash = name_and_version.indexOf('/');
        {
            this.protocolName = name_and_version.substring(0,slash);
            this.protocolVersion = name_and_version.substring( slash+1 );
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new ParseException( "Missing '/' in protocol", 0 );
        // ---------- Original Method ----------
        //int slash = name_and_version.indexOf('/');
        //if (slash>0) {
            //this.protocolName = name_and_version.substring(0,slash);
            //this.protocolVersion = name_and_version.substring( slash+1 );
        //} else throw new ParseException( "Missing '/' in protocol", 0 );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.245 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "894813C626B4C78406E90D99B078E417")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_1631875303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1631875303 = transport;
        varB4EAC82CA7396A68D541C85D26508E83_1631875303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1631875303;
        // ---------- Original Method ----------
        //return transport;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.245 -0400", hash_original_method = "D424701D0BAFF5CEC55A80344E30BD30", hash_generated_method = "B4D21ACCA657B794F87AC481BEFA63A6")
    public void setProtocolName(String p) {
        protocolName = p;
        // ---------- Original Method ----------
        //protocolName = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.246 -0400", hash_original_method = "2A792840748FAB978DAA68C8F2495344", hash_generated_method = "3746DD0FB723CD5F349A9341429551FC")
    public void setProtocolVersion(String p) {
        protocolVersion = p;
        // ---------- Original Method ----------
        //protocolVersion = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.246 -0400", hash_original_method = "2F1F81EB1D8D9B12E2B4CE0AEE6CB155", hash_generated_method = "6E2B7DAB33C44857128202FB176B4870")
    public void setTransport(String t) {
        transport = t;
        // ---------- Original Method ----------
        //transport = t;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.246 -0400", hash_original_field = "0425D558ED819B68833B3D1A2F581952", hash_generated_field = "8A26D4B569528F850BBB9E58FCEA6233")

    private static long serialVersionUID = 2216758055974073280L;
}

