package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public class ContentEncoding extends SIPHeader implements javax.sip.header.ContentEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.846 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "28D90C4A539A5E5930C5B1B3C4D77F57")

    protected String contentEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.846 -0400", hash_original_method = "AF3A83AEFF326F1AB1D055130F5C4343", hash_generated_method = "484568D4CE2DAF62679DC5CF40341916")
    public  ContentEncoding() {
        super(CONTENT_ENCODING);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.855 -0400", hash_original_method = "4F763B16EA587AFDD37717E0DDC46D04", hash_generated_method = "FE4323D4242D23A5C0F73B251A58E683")
    public  ContentEncoding(String enc) {
        super(CONTENT_ENCODING);
        contentEncoding = enc;
        // ---------- Original Method ----------
        //contentEncoding = enc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.856 -0400", hash_original_method = "762501862EB015269BBC405DBBAC5194", hash_generated_method = "19F2FEEC561457A58965272D85AE69E8")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_2018899716 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2018899716 = contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_2018899716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2018899716;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.857 -0400", hash_original_method = "13F27076508F7754A69639743C7567EC", hash_generated_method = "7682C011FE7FA36E3D04ECB21EF27BAD")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1515001254 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1515001254 = contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1515001254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1515001254;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.857 -0400", hash_original_method = "250F948E1BF6921E6DE1D81CBA749729", hash_generated_method = "92B9C22D537903AE5A4411BECDEEB83A")
    public void setEncoding(String encoding) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, " + " encoding is null");
        contentEncoding = encoding;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, " + " encoding is null");
        //contentEncoding = encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.857 -0400", hash_original_field = "75D26B86C4230C10774E429E68B84D0B", hash_generated_field = "2801A464B6916FD5B5D5521A388340BF")

    private static long serialVersionUID = 2034230276579558857L;
}

