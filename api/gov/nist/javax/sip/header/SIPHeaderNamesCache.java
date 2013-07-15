package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class SIPHeaderNamesCache {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.319 -0400", hash_original_method = "8D520759A4CF14512CFF6A3164E1C68E", hash_generated_method = "8D520759A4CF14512CFF6A3164E1C68E")
    public SIPHeaderNamesCache ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
    public static String toLowerCase(String headerName) {
        String lowerCase = (String) lowercaseMap.get(headerName);
        if (lowerCase == null) {
            return headerName.toLowerCase();
        }
        else {
            return lowerCase;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.320 -0400", hash_original_field = "7EA7D47C7AEAA930B2D0AB7396FF38A8", hash_generated_field = "020672DDF8B640C88D89F337A5ED11A7")

    private static final HashMap lowercaseMap = new HashMap();
    static {
        Field[] fields = SIPHeaderNames.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.getType().equals(String.class) && Modifier.isStatic(field.getModifiers())) {
                try {
                    String value = (String) field.get(null);
                    String lowerCase = value.toLowerCase();
                    lowercaseMap.put(value, lowerCase);
                    lowercaseMap.put(lowerCase, lowerCase);
                } catch (IllegalAccessException e) {
                }
            }
        }
    }
    
}

