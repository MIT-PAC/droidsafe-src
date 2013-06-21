package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public class Unsupported extends SIPHeader implements javax.sip.header.UnsupportedHeader {
    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.446 -0400", hash_original_method = "7F4BD1C3AF5762ECCF124F3A56ADDC67", hash_generated_method = "20CE9BE220E1B76B99762452ADA57ECB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Unsupported() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.446 -0400", hash_original_method = "91BBA837F044D0A0A4874364E40F6125", hash_generated_method = "DD0CE22029C16E1F9595EF7F82C40C94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Unsupported(String ot) {
        super(NAME);
        dsTaint.addTaint(ot);
        // ---------- Original Method ----------
        //optionTag = ot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.446 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "1D73C5C06D23FFD27D3158D603422B4A")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.446 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "6F5E99C222699AC771B9EB87EA1363E2")
    @DSModeled(DSC.SAFE)
    public String getOptionTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.446 -0400", hash_original_method = "3B18B091D01592A1C9601DEA63572A7E", hash_generated_method = "5E4F5BC4831A39EBEC6BFED146103304")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOptionTag(String o) throws ParseException {
        dsTaint.addTaint(o);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + " Unsupported, setOptionTag(), The option tag parameter is null");
        // ---------- Original Method ----------
        //if (o == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ " Unsupported, setOptionTag(), The option tag parameter is null");
        //optionTag = o;
    }

    
    private static final long serialVersionUID = -2479414149440236199L;
}

