package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public class ContentEncoding extends SIPHeader implements javax.sip.header.ContentEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.393 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "28D90C4A539A5E5930C5B1B3C4D77F57")

    protected String contentEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.393 -0400", hash_original_method = "AF3A83AEFF326F1AB1D055130F5C4343", hash_generated_method = "484568D4CE2DAF62679DC5CF40341916")
    public  ContentEncoding() {
        super(CONTENT_ENCODING);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.394 -0400", hash_original_method = "4F763B16EA587AFDD37717E0DDC46D04", hash_generated_method = "FE4323D4242D23A5C0F73B251A58E683")
    public  ContentEncoding(String enc) {
        super(CONTENT_ENCODING);
        contentEncoding = enc;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.394 -0400", hash_original_method = "762501862EB015269BBC405DBBAC5194", hash_generated_method = "1F6717C577604E4E8F6C9D9705E053A6")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_370338622 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_370338622 = contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_370338622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_370338622;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.395 -0400", hash_original_method = "13F27076508F7754A69639743C7567EC", hash_generated_method = "7307962E1CA8DA39222318A7EDB6C47D")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1060360505 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1060360505 = contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1060360505.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1060360505;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.395 -0400", hash_original_method = "250F948E1BF6921E6DE1D81CBA749729", hash_generated_method = "92B9C22D537903AE5A4411BECDEEB83A")
    public void setEncoding(String encoding) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, " + " encoding is null");
        contentEncoding = encoding;
        
        
            
                
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.395 -0400", hash_original_field = "75D26B86C4230C10774E429E68B84D0B", hash_generated_field = "A6105BB7D9606B15FED8D5EA58524006")

    private static final long serialVersionUID = 2034230276579558857L;
}

