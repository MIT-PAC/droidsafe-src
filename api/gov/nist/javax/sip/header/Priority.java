package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.text.ParseException;

public class Priority extends SIPHeader implements PriorityHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "3213DCF322A558FDF513E235035DAC3E")

    protected String priority;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_method = "33A980E78264A96D694E0BA8D4330749", hash_generated_method = "2DAB64ED9F1F75184A9783CA81667401")
    public  Priority() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_method = "275A06F50E7B2077A23380B094FCE956", hash_generated_method = "6F108122CE9DBE8CE66B2C636A4DE140")
    public String encodeBody() {
String var9141C1D2D467F4F6FF150C27DE3F01A3_1754981098 =         priority;
        var9141C1D2D467F4F6FF150C27DE3F01A3_1754981098.addTaint(taint);
        return var9141C1D2D467F4F6FF150C27DE3F01A3_1754981098;
        // ---------- Original Method ----------
        //return priority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_method = "6DFC1BDF5FFE5EB6A183C3674CCE0974", hash_generated_method = "34466CCC91BC14A30897C912A837CF05")
    public String getPriority() {
String var9141C1D2D467F4F6FF150C27DE3F01A3_345002813 =         priority;
        var9141C1D2D467F4F6FF150C27DE3F01A3_345002813.addTaint(taint);
        return var9141C1D2D467F4F6FF150C27DE3F01A3_345002813;
        // ---------- Original Method ----------
        //return priority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_method = "5B52FF98236754242B91AFCB31F1DBDC", hash_generated_method = "0BA2DA62C6F0917C4ED256C9B4FD9D37")
    public void setPriority(String p) throws ParseException {
        if(p == null)        
        {
        NullPointerException var80B54727C42D176719B12B809902E010_608672526 = new NullPointerException(
                "JAIN-SIP Exception,"
                    + "Priority, setPriority(), the priority parameter is null");
        var80B54727C42D176719B12B809902E010_608672526.addTaint(taint);
        throw var80B54727C42D176719B12B809902E010_608672526;
        }
        priority = p;
        // ---------- Original Method ----------
        //if (p == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "Priority, setPriority(), the priority parameter is null");
        //priority = p;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_field = "15599D2D677E6A7B13001FEF9BCBB005", hash_generated_field = "08C77E58ECE13B5F92FDDB2CA5776347")

    private static final long serialVersionUID = 3837543366074322106L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_field = "B4E1857BDD42E529FF9F0717407D27E3", hash_generated_field = "974D541B27585CA7CCC3558FD38E5F46")

    public static final String EMERGENCY = ParameterNames.EMERGENCY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_field = "B5314418DF7687530255EE3F9E5D979D", hash_generated_field = "DC111FCED25D7B0BDCFAF701C81B9E39")

    public static final String URGENT = ParameterNames.URGENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_field = "817286F64D1A3CFEF1DCF2231AA95ED7", hash_generated_field = "5C1C119AD4B0CA221BA8B1EA80B22E62")

    public static final String NORMAL = ParameterNames.NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.708 -0400", hash_original_field = "1BEBA7101F60A007E5E51365EC3D71E4", hash_generated_field = "8E6E668A799B5A2A683603F90AA71AE4")

    public static final String NON_URGENT = ParameterNames.NON_URGENT;
}

