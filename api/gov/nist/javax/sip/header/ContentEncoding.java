package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public class ContentEncoding extends SIPHeader implements javax.sip.header.ContentEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.232 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "28D90C4A539A5E5930C5B1B3C4D77F57")

    protected String contentEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.232 -0400", hash_original_method = "AF3A83AEFF326F1AB1D055130F5C4343", hash_generated_method = "484568D4CE2DAF62679DC5CF40341916")
    public  ContentEncoding() {
        super(CONTENT_ENCODING);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.232 -0400", hash_original_method = "4F763B16EA587AFDD37717E0DDC46D04", hash_generated_method = "FE4323D4242D23A5C0F73B251A58E683")
    public  ContentEncoding(String enc) {
        super(CONTENT_ENCODING);
        contentEncoding = enc;
        // ---------- Original Method ----------
        //contentEncoding = enc;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.233 -0400", hash_original_method = "762501862EB015269BBC405DBBAC5194", hash_generated_method = "BA26EDC56CDB3D5059467667256DC40F")
    public String encodeBody() {
String varB77403BF8D1FE544589F5EE718B4AD53_1047715672 =         contentEncoding;
        varB77403BF8D1FE544589F5EE718B4AD53_1047715672.addTaint(taint);
        return varB77403BF8D1FE544589F5EE718B4AD53_1047715672;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.233 -0400", hash_original_method = "13F27076508F7754A69639743C7567EC", hash_generated_method = "B93071657F00148497DD2C0D33B046BF")
    public String getEncoding() {
String varB77403BF8D1FE544589F5EE718B4AD53_1939077777 =         contentEncoding;
        varB77403BF8D1FE544589F5EE718B4AD53_1939077777.addTaint(taint);
        return varB77403BF8D1FE544589F5EE718B4AD53_1939077777;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.233 -0400", hash_original_method = "250F948E1BF6921E6DE1D81CBA749729", hash_generated_method = "6EB923D25B29706303E8CC02C0201946")
    public void setEncoding(String encoding) throws ParseException {
        if(encoding == null)        
        {
        NullPointerException var9A42999D50208B50BE32AFF87EB6A8E8_1327361867 = new NullPointerException(
                "JAIN-SIP Exception, " + " encoding is null");
        var9A42999D50208B50BE32AFF87EB6A8E8_1327361867.addTaint(taint);
        throw var9A42999D50208B50BE32AFF87EB6A8E8_1327361867;
        }
        contentEncoding = encoding;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, " + " encoding is null");
        //contentEncoding = encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.233 -0400", hash_original_field = "75D26B86C4230C10774E429E68B84D0B", hash_generated_field = "A6105BB7D9606B15FED8D5EA58524006")

    private static final long serialVersionUID = 2034230276579558857L;
}

