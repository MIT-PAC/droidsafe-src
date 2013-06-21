package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class ProxyRequire extends SIPHeader implements ProxyRequireHeader {
    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.083 -0400", hash_original_method = "313262BBE47BF259092F8848A4D13338", hash_generated_method = "8A94E0C1BEC1D37D30D767A123DE1038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyRequire() {
        super(PROXY_REQUIRE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.083 -0400", hash_original_method = "3BC392B937FA3D9900D8752B431D0DD9", hash_generated_method = "7C83D718D57F2BD89FFE53446E4CD8D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyRequire(String s) {
        super(PROXY_REQUIRE);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //optionTag = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.084 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "1D73C5C06D23FFD27D3158D603422B4A")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.084 -0400", hash_original_method = "DE0D7BEB729218B451469620CB6256C4", hash_generated_method = "000DA7C40252159727311230B4F9F975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOptionTag(String optionTag) throws ParseException {
        dsTaint.addTaint(optionTag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException("JAIN-SIP Exception, ProxyRequire, setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.084 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "6F5E99C222699AC771B9EB87EA1363E2")
    @DSModeled(DSC.SAFE)
    public String getOptionTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    private static final long serialVersionUID = -3269274234851067893L;
}

