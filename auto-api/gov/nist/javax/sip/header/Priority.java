package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class Priority extends SIPHeader implements PriorityHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.148 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "3213DCF322A558FDF513E235035DAC3E")

    protected String priority;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.148 -0400", hash_original_method = "33A980E78264A96D694E0BA8D4330749", hash_generated_method = "2DAB64ED9F1F75184A9783CA81667401")
    public  Priority() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.149 -0400", hash_original_method = "275A06F50E7B2077A23380B094FCE956", hash_generated_method = "2CF05E6817E7B87C750568B50F7B425F")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_507985144 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_507985144 = priority;
        varB4EAC82CA7396A68D541C85D26508E83_507985144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_507985144;
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.150 -0400", hash_original_method = "6DFC1BDF5FFE5EB6A183C3674CCE0974", hash_generated_method = "C32B372D9BF20F988CF8EAE6AD807CBD")
    public String getPriority() {
        String varB4EAC82CA7396A68D541C85D26508E83_1574033103 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1574033103 = priority;
        varB4EAC82CA7396A68D541C85D26508E83_1574033103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1574033103;
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.150 -0400", hash_original_method = "5B52FF98236754242B91AFCB31F1DBDC", hash_generated_method = "460B0D4664E2B38364BA71E6D9DBE70B")
    public void setPriority(String p) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "Priority, setPriority(), the priority parameter is null");
        priority = p;
        // ---------- Original Method ----------
        //if (p == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "Priority, setPriority(), the priority parameter is null");
        //priority = p;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.150 -0400", hash_original_field = "15599D2D677E6A7B13001FEF9BCBB005", hash_generated_field = "BF345BDED38B186A39388329182236CC")

    private static long serialVersionUID = 3837543366074322106L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.150 -0400", hash_original_field = "B4E1857BDD42E529FF9F0717407D27E3", hash_generated_field = "974D541B27585CA7CCC3558FD38E5F46")

    public static final String EMERGENCY = ParameterNames.EMERGENCY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.150 -0400", hash_original_field = "B5314418DF7687530255EE3F9E5D979D", hash_generated_field = "DC111FCED25D7B0BDCFAF701C81B9E39")

    public static final String URGENT = ParameterNames.URGENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.150 -0400", hash_original_field = "817286F64D1A3CFEF1DCF2231AA95ED7", hash_generated_field = "5C1C119AD4B0CA221BA8B1EA80B22E62")

    public static final String NORMAL = ParameterNames.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.150 -0400", hash_original_field = "1BEBA7101F60A007E5E51365EC3D71E4", hash_generated_field = "8E6E668A799B5A2A683603F90AA71AE4")

    public static final String NON_URGENT = ParameterNames.NON_URGENT;
}

