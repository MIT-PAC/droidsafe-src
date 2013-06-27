package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class XmlStreamReaderException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.078 -0400", hash_original_field = "80295347C22A84C1E48F4B0A7D979301", hash_generated_field = "EC82926CAB066F06AAFC3726EF2F5BF5")

    private String bomEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.078 -0400", hash_original_field = "66A09F1DEC3A37A5B2FFCE17F416FE0B", hash_generated_field = "293562CF19517A35BB931BB29CBF3076")

    private String xmlGuessEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.078 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.078 -0400", hash_original_field = "A79DC203C305015E0EAEB00A8435D90C", hash_generated_field = "CF0AADC5E49F7DC7EC0DF8E902974BFE")

    private String contentTypeMime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.078 -0400", hash_original_field = "B4C5F58B09A24EE223B1946103129D32", hash_generated_field = "C4A1C9E33654E0FF1EF148FC95CCA1FD")

    private String contentTypeEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.079 -0400", hash_original_method = "B1FC8025A53E034082D8F586CBC4D3DF", hash_generated_method = "BDBFD07160188FE8640F3EDC8CAFB68A")
    public  XmlStreamReaderException(String msg, String bomEnc,
            String xmlGuessEnc, String xmlEnc) {
        this(msg, null, null, bomEnc, xmlGuessEnc, xmlEnc);
        addTaint(msg.getTaint());
        addTaint(bomEnc.getTaint());
        addTaint(xmlGuessEnc.getTaint());
        addTaint(xmlEnc.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.088 -0400", hash_original_method = "67214B0FED640930AABB3A175A226E31", hash_generated_method = "8BFA447725E46D79E414E3229EAF49CF")
    public  XmlStreamReaderException(String msg, String ctMime, String ctEnc,
            String bomEnc, String xmlGuessEnc, String xmlEnc) {
        super(msg);
        contentTypeMime = ctMime;
        contentTypeEncoding = ctEnc;
        bomEncoding = bomEnc;
        xmlGuessEncoding = xmlGuessEnc;
        xmlEncoding = xmlEnc;
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //contentTypeMime = ctMime;
        //contentTypeEncoding = ctEnc;
        //bomEncoding = bomEnc;
        //xmlGuessEncoding = xmlGuessEnc;
        //xmlEncoding = xmlEnc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.089 -0400", hash_original_method = "8E6ACC549621DB046C39AAF67FE47CA0", hash_generated_method = "C17F750625D493E708465770F12A0472")
    public String getBomEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1949173809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1949173809 = bomEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1949173809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1949173809;
        // ---------- Original Method ----------
        //return bomEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.089 -0400", hash_original_method = "93213E0474402E85CBBF9C6807083224", hash_generated_method = "1FFB6C1098B206321D8E32B0BF1E699A")
    public String getXmlGuessEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1458876886 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1458876886 = xmlGuessEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1458876886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1458876886;
        // ---------- Original Method ----------
        //return xmlGuessEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.089 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "322B2EC892A0547412474AD56AC752D4")
    public String getXmlEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1732741564 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1732741564 = xmlEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1732741564.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1732741564;
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.090 -0400", hash_original_method = "AF89DB06972BD6AFB50AFEC4B946DE00", hash_generated_method = "25B8912E4E71D7EA1A245077E176C2C9")
    public String getContentTypeMime() {
        String varB4EAC82CA7396A68D541C85D26508E83_892054600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_892054600 = contentTypeMime;
        varB4EAC82CA7396A68D541C85D26508E83_892054600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_892054600;
        // ---------- Original Method ----------
        //return contentTypeMime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.090 -0400", hash_original_method = "D63D11323318AB5C82EE37F5F9D391F2", hash_generated_method = "16C24BFA557BF67BD7B08183606340ED")
    public String getContentTypeEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_842843325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_842843325 = contentTypeEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_842843325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_842843325;
        // ---------- Original Method ----------
        //return contentTypeEncoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.090 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

