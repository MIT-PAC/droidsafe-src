package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MissingResourceException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.285 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "CA6BE7A479C5F3E68F3687DBA3A4A48F")

    String className;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.285 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.286 -0400", hash_original_method = "0B71E2B2311543F4039A5E1A5B0E2A4E", hash_generated_method = "D2D270E5678C7D6AEC3024600B6F3596")
    public  MissingResourceException(String detailMessage, String className,
            String resourceName) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        this.className = className;
        key = resourceName;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.286 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "BCDF9EF1EB85A5B172EE18B490AF1ECF")
    public String getClassName() {
String varF57DF2C3C72C0BA8574176BD3A4AA127_1617116821 =         className;
        varF57DF2C3C72C0BA8574176BD3A4AA127_1617116821.addTaint(taint);
        return varF57DF2C3C72C0BA8574176BD3A4AA127_1617116821;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.286 -0400", hash_original_method = "C39C8C9D5BC81C2FE68967748762171F", hash_generated_method = "FD18491E0AEF9A2C8A51BA5895998B95")
    public String getKey() {
String var6A95247616A3A8B93CFF7783DABD08D4_1489785482 =         key;
        var6A95247616A3A8B93CFF7783DABD08D4_1489785482.addTaint(taint);
        return var6A95247616A3A8B93CFF7783DABD08D4_1489785482;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.287 -0400", hash_original_field = "44400619BCAA2353344518B6666297C1", hash_generated_field = "31A19D95C3D0097D3CB81CFACA273934")

    private static final long serialVersionUID = -4876345176062000401L;
}

