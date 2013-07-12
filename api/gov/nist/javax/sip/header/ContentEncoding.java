package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public class ContentEncoding extends SIPHeader implements javax.sip.header.ContentEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.246 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "28D90C4A539A5E5930C5B1B3C4D77F57")

    protected String contentEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.247 -0400", hash_original_method = "AF3A83AEFF326F1AB1D055130F5C4343", hash_generated_method = "484568D4CE2DAF62679DC5CF40341916")
    public  ContentEncoding() {
        super(CONTENT_ENCODING);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.247 -0400", hash_original_method = "4F763B16EA587AFDD37717E0DDC46D04", hash_generated_method = "FE4323D4242D23A5C0F73B251A58E683")
    public  ContentEncoding(String enc) {
        super(CONTENT_ENCODING);
        contentEncoding = enc;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.247 -0400", hash_original_method = "762501862EB015269BBC405DBBAC5194", hash_generated_method = "CA9D50E0C7061F275FEAB55835FACD60")
    public String encodeBody() {
String varB77403BF8D1FE544589F5EE718B4AD53_2091267711 =         contentEncoding;
        varB77403BF8D1FE544589F5EE718B4AD53_2091267711.addTaint(taint);
        return varB77403BF8D1FE544589F5EE718B4AD53_2091267711;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.247 -0400", hash_original_method = "13F27076508F7754A69639743C7567EC", hash_generated_method = "9DE7ACA7C3D1F3E5B7CD9AC65272E62F")
    public String getEncoding() {
String varB77403BF8D1FE544589F5EE718B4AD53_1068949585 =         contentEncoding;
        varB77403BF8D1FE544589F5EE718B4AD53_1068949585.addTaint(taint);
        return varB77403BF8D1FE544589F5EE718B4AD53_1068949585;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.248 -0400", hash_original_method = "250F948E1BF6921E6DE1D81CBA749729", hash_generated_method = "B74F1976F5352CCE44B60702E8F769F1")
    public void setEncoding(String encoding) throws ParseException {
    if(encoding == null)        
        {
        NullPointerException var9A42999D50208B50BE32AFF87EB6A8E8_1578938866 = new NullPointerException(
                "JAIN-SIP Exception, " + " encoding is null");
        var9A42999D50208B50BE32AFF87EB6A8E8_1578938866.addTaint(taint);
        throw var9A42999D50208B50BE32AFF87EB6A8E8_1578938866;
        }
        contentEncoding = encoding;
        
        
            
                
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.248 -0400", hash_original_field = "75D26B86C4230C10774E429E68B84D0B", hash_generated_field = "A6105BB7D9606B15FED8D5EA58524006")

    private static final long serialVersionUID = 2034230276579558857L;
}

