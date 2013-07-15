package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public class Protocol extends SIPObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.903 -0400", hash_original_field = "0AACAAD803286A486455DA9B0035B980", hash_generated_field = "C766D4C5CA44A223EF8697E2A0C74072")

    protected String protocolName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.903 -0400", hash_original_field = "E5EB1B1AE3E23C45B744E3125FC5B3E7", hash_generated_field = "D5DF73E283251EA2D1226355FFEB1D1C")

    protected String protocolVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.903 -0400", hash_original_field = "7B334B7260361141659FA9862E803476", hash_generated_field = "B1CF55BB145913C3C7A70130704FABEE")

    protected String transport;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.904 -0400", hash_original_method = "B029C737A70A786967A2F293EBAB35D1", hash_generated_method = "DEE5EC031EDC612478B0E1C953847222")
    public  Protocol() {
        protocolName = "SIP";
        protocolVersion = "2.0";
        transport = "UDP";
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.905 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "0B181F3EDB6EB0EE1EFD603A8C84075E")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1379987448 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1379987448 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1379987448.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1379987448;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.907 -0400", hash_original_method = "5917804CC8541DAC2CA5A0DEC050E620", hash_generated_method = "57592BF2AE20178AFEFED49DA4220691")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1862150179 = null; 
        buffer.append(protocolName.toUpperCase())
                .append(SLASH)
                .append(protocolVersion)
                .append(SLASH)
                .append(transport.toUpperCase());
        varB4EAC82CA7396A68D541C85D26508E83_1862150179 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1862150179.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1862150179;
        
        
                
                
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.907 -0400", hash_original_method = "0EA6E7D3A9B59E59CEEBB8D3EE9D071C", hash_generated_method = "9349E67D59714C7CF6BF9A3A291B04C0")
    public String getProtocolName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1846244041 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1846244041 = protocolName;
        varB4EAC82CA7396A68D541C85D26508E83_1846244041.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1846244041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.908 -0400", hash_original_method = "B8FA221EC0DA8944EFD0CEB861346936", hash_generated_method = "62D207042B1A6A27F153E8138AE5B411")
    public String getProtocolVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_82582625 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_82582625 = protocolVersion;
        varB4EAC82CA7396A68D541C85D26508E83_82582625.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_82582625;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.909 -0400", hash_original_method = "3E5201C0CB5C46DC512CD40707A0CB06", hash_generated_method = "195F8463BA37318E9932FB1C9C4F5406")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_306739729 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_306739729 = protocolName + '/' + protocolVersion;
        varB4EAC82CA7396A68D541C85D26508E83_306739729.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_306739729;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.910 -0400", hash_original_method = "095B78DD27D74EBF49777967A681F20E", hash_generated_method = "268EA6A5C8AF5A7E7D33B5849DADAD76")
    public void setProtocol( String name_and_version ) throws ParseException {
        int slash = name_and_version.indexOf('/');
        {
            this.protocolName = name_and_version.substring(0,slash);
            this.protocolVersion = name_and_version.substring( slash+1 );
        } 
        if (DroidSafeAndroidRuntime.control) throw new ParseException( "Missing '/' in protocol", 0 );
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.911 -0400", hash_original_method = "43848E528F960D9C1F3B13D7D65AA4A4", hash_generated_method = "E283E5D9798CD2D1B7A0CC9E129671FA")
    public String getTransport() {
        String varB4EAC82CA7396A68D541C85D26508E83_823648470 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_823648470 = transport;
        varB4EAC82CA7396A68D541C85D26508E83_823648470.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_823648470;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.912 -0400", hash_original_method = "D424701D0BAFF5CEC55A80344E30BD30", hash_generated_method = "B4D21ACCA657B794F87AC481BEFA63A6")
    public void setProtocolName(String p) {
        protocolName = p;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.912 -0400", hash_original_method = "2A792840748FAB978DAA68C8F2495344", hash_generated_method = "3746DD0FB723CD5F349A9341429551FC")
    public void setProtocolVersion(String p) {
        protocolVersion = p;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.912 -0400", hash_original_method = "2F1F81EB1D8D9B12E2B4CE0AEE6CB155", hash_generated_method = "6E2B7DAB33C44857128202FB176B4870")
    public void setTransport(String t) {
        transport = t;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.912 -0400", hash_original_field = "0425D558ED819B68833B3D1A2F581952", hash_generated_field = "51FBF3C81D0285A3EC2B590DCDB910C8")

    private static final long serialVersionUID = 2216758055974073280L;
}

