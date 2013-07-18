package java.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MissingResourceException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.313 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "CA6BE7A479C5F3E68F3687DBA3A4A48F")

    String className;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.313 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

    String key;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.314 -0400", hash_original_method = "0B71E2B2311543F4039A5E1A5B0E2A4E", hash_generated_method = "D2D270E5678C7D6AEC3024600B6F3596")
    public  MissingResourceException(String detailMessage, String className,
            String resourceName) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        this.className = className;
        key = resourceName;
        // ---------- Original Method ----------
        //this.className = className;
        //key = resourceName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.315 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "511FA33C51D01ED4640212B642429E89")
    public String getClassName() {
String varF57DF2C3C72C0BA8574176BD3A4AA127_1134743078 =         className;
        varF57DF2C3C72C0BA8574176BD3A4AA127_1134743078.addTaint(taint);
        return varF57DF2C3C72C0BA8574176BD3A4AA127_1134743078;
        // ---------- Original Method ----------
        //return className;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.315 -0400", hash_original_method = "C39C8C9D5BC81C2FE68967748762171F", hash_generated_method = "22261759181CEFE63983E19FE565A151")
    public String getKey() {
String var6A95247616A3A8B93CFF7783DABD08D4_180784284 =         key;
        var6A95247616A3A8B93CFF7783DABD08D4_180784284.addTaint(taint);
        return var6A95247616A3A8B93CFF7783DABD08D4_180784284;
        // ---------- Original Method ----------
        //return key;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.315 -0400", hash_original_field = "44400619BCAA2353344518B6666297C1", hash_generated_field = "31A19D95C3D0097D3CB81CFACA273934")

    private static final long serialVersionUID = -4876345176062000401L;
}

