package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;

public class Require extends SIPHeader implements RequireHeader {
    protected String optionTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.148 -0400", hash_original_method = "7D717471F4A5D7EAD23BC013F4963192", hash_generated_method = "FB2DC2E91D950F6C620B24801FE2D28F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Require() {
        super(REQUIRE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.148 -0400", hash_original_method = "BECC14DD123F4F96D2EA3BD4716F0CF2", hash_generated_method = "84F55EE1A25DD6A033F44B6BB091BF43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Require(String s) {
        super(REQUIRE);
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //optionTag = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.148 -0400", hash_original_method = "9C711BE19A8C0E0A7CB116A3F753C6F0", hash_generated_method = "1D73C5C06D23FFD27D3158D603422B4A")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.149 -0400", hash_original_method = "61D4CA895F679FC1977776F5CD42A467", hash_generated_method = "634D644C4F4FB6711DC8602C2CCCFD4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOptionTag(String optionTag) throws ParseException {
        dsTaint.addTaint(optionTag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, Require, "
                    + "setOptionTag(), the optionTag parameter is null");
        // ---------- Original Method ----------
        //if (optionTag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, Require, "
                    //+ "setOptionTag(), the optionTag parameter is null");
        //this.optionTag = optionTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.150 -0400", hash_original_method = "CE304AE728C556B979775346D4C5B456", hash_generated_method = "6F5E99C222699AC771B9EB87EA1363E2")
    @DSModeled(DSC.SAFE)
    public String getOptionTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return optionTag;
    }

    
    private static final long serialVersionUID = -3743425404884053281L;
}

