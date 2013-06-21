package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class SIPETag extends SIPHeader implements SIPETagHeader, ExtensionHeader {
    protected String entityTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.273 -0400", hash_original_method = "BAC01810EAA501495132ECB89EEE2B88", hash_generated_method = "5AAB108C68C33BB6DA943351B9383C7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPETag() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.273 -0400", hash_original_method = "85BBFA4AA70935C1ADD9E51D03FF73BB", hash_generated_method = "E6DF51071B4D0D11E69D49BB736FCE5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPETag( String tag ) throws ParseException {
        this();
        dsTaint.addTaint(tag);
        this.setETag( tag );
        // ---------- Original Method ----------
        //this.setETag( tag );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.273 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "636B374C7B93A5766F5E246D0C2C15A8")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.274 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "F6ABDD3B5595056CCEEF93EE803CE4D3")
    @DSModeled(DSC.SAFE)
    public String getETag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return entityTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.274 -0400", hash_original_method = "3B3373A48DF283BBF1E69590D4AF600C", hash_generated_method = "E8D5A0020CDB338136CD44ED2923E3A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setETag(String etag) throws ParseException {
        dsTaint.addTaint(etag);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-ETag, setETag(), the etag parameter is null");
        // ---------- Original Method ----------
        //if (etag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "SIP-ETag, setETag(), the etag parameter is null");
        //this.entityTag = etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.274 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "CF21B5212322E378989362596128EFDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        this.setETag(value);
        // ---------- Original Method ----------
        //this.setETag(value);
    }

    
    private static final long serialVersionUID = 3837543366074322107L;
}

