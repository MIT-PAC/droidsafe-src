package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class SIPIfMatch extends SIPHeader implements SIPIfMatchHeader, ExtensionHeader {
    protected String entityTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.359 -0400", hash_original_method = "BAD2DC814CD45D5939615C62F83835FA", hash_generated_method = "BC1325341205D047D33E2F234910D97F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPIfMatch() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.359 -0400", hash_original_method = "3D0893288CE2D1B79B07387D603E62DB", hash_generated_method = "B90A823C50806D96B6FD24BFEBB70B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPIfMatch(String etag) throws ParseException {
        this();
        dsTaint.addTaint(etag);
        this.setETag( etag );
        // ---------- Original Method ----------
        //this.setETag( etag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.359 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "636B374C7B93A5766F5E246D0C2C15A8")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.359 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "F6ABDD3B5595056CCEEF93EE803CE4D3")
    @DSModeled(DSC.SAFE)
    public String getETag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.359 -0400", hash_original_method = "FF09F62ACDB51364A1C119FC09E0694A", hash_generated_method = "9C69CCCA16FE041D91A35DB20552E5F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setETag(String etag) throws ParseException {
        dsTaint.addTaint(etag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-If-Match, setETag(), the etag parameter is null");
        // ---------- Original Method ----------
        //if (etag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "SIP-If-Match, setETag(), the etag parameter is null");
        //this.entityTag = etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.360 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "CF21B5212322E378989362596128EFDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        this.setETag(value);
        // ---------- Original Method ----------
        //this.setETag(value);
    }

    
    private static final long serialVersionUID = 3833745477828359730L;
}

