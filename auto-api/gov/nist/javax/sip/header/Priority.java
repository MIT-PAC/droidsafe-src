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
    protected String priority;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.067 -0400", hash_original_method = "33A980E78264A96D694E0BA8D4330749", hash_generated_method = "2DAB64ED9F1F75184A9783CA81667401")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Priority() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.067 -0400", hash_original_method = "275A06F50E7B2077A23380B094FCE956", hash_generated_method = "C3A8652ED7B6D843FC1880F90C75D2EE")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.068 -0400", hash_original_method = "6DFC1BDF5FFE5EB6A183C3674CCE0974", hash_generated_method = "D7ADD2A55735A3D2A529EBD78EA59A86")
    @DSModeled(DSC.SAFE)
    public String getPriority() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.068 -0400", hash_original_method = "5B52FF98236754242B91AFCB31F1DBDC", hash_generated_method = "01CCC054148A8CC9DFAB2C20FC7A1377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPriority(String p) throws ParseException {
        dsTaint.addTaint(p);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "Priority, setPriority(), the priority parameter is null");
        // ---------- Original Method ----------
        //if (p == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "Priority, setPriority(), the priority parameter is null");
        //priority = p;
    }

    
    private static final long serialVersionUID = 3837543366074322106L;
    public static final String EMERGENCY = ParameterNames.EMERGENCY;
    public static final String URGENT = ParameterNames.URGENT;
    public static final String NORMAL = ParameterNames.NORMAL;
    public static final String NON_URGENT = ParameterNames.NON_URGENT;
}

