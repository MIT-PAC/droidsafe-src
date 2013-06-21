package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public class ContentEncoding extends SIPHeader implements javax.sip.header.ContentEncodingHeader {
    protected String contentEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.893 -0400", hash_original_method = "AF3A83AEFF326F1AB1D055130F5C4343", hash_generated_method = "484568D4CE2DAF62679DC5CF40341916")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentEncoding() {
        super(CONTENT_ENCODING);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.893 -0400", hash_original_method = "4F763B16EA587AFDD37717E0DDC46D04", hash_generated_method = "72B72DD4A270C861E731A6A4AF24C69C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentEncoding(String enc) {
        super(CONTENT_ENCODING);
        dsTaint.addTaint(enc);
        // ---------- Original Method ----------
        //contentEncoding = enc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.893 -0400", hash_original_method = "762501862EB015269BBC405DBBAC5194", hash_generated_method = "03AA2B3892C43C1B3D402215AFEF9E6E")
    @DSModeled(DSC.SAFE)
    public String encodeBody() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.894 -0400", hash_original_method = "13F27076508F7754A69639743C7567EC", hash_generated_method = "B6AD8FBFE27D12688369DCE459810C05")
    @DSModeled(DSC.SAFE)
    public String getEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.894 -0400", hash_original_method = "250F948E1BF6921E6DE1D81CBA749729", hash_generated_method = "9CC2274ED4A634A8155333E17E0274D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncoding(String encoding) throws ParseException {
        dsTaint.addTaint(encoding);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, " + " encoding is null");
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, " + " encoding is null");
        //contentEncoding = encoding;
    }

    
    private static final long serialVersionUID = 2034230276579558857L;
}

