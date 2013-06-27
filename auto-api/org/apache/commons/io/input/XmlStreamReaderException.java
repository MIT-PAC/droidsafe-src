package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class XmlStreamReaderException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.166 -0400", hash_original_field = "80295347C22A84C1E48F4B0A7D979301", hash_generated_field = "EC82926CAB066F06AAFC3726EF2F5BF5")

    private String bomEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.166 -0400", hash_original_field = "66A09F1DEC3A37A5B2FFCE17F416FE0B", hash_generated_field = "293562CF19517A35BB931BB29CBF3076")

    private String xmlGuessEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.166 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.166 -0400", hash_original_field = "A79DC203C305015E0EAEB00A8435D90C", hash_generated_field = "CF0AADC5E49F7DC7EC0DF8E902974BFE")

    private String contentTypeMime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.167 -0400", hash_original_field = "B4C5F58B09A24EE223B1946103129D32", hash_generated_field = "C4A1C9E33654E0FF1EF148FC95CCA1FD")

    private String contentTypeEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.167 -0400", hash_original_method = "B1FC8025A53E034082D8F586CBC4D3DF", hash_generated_method = "BDBFD07160188FE8640F3EDC8CAFB68A")
    public  XmlStreamReaderException(String msg, String bomEnc,
            String xmlGuessEnc, String xmlEnc) {
        this(msg, null, null, bomEnc, xmlGuessEnc, xmlEnc);
        addTaint(msg.getTaint());
        addTaint(bomEnc.getTaint());
        addTaint(xmlGuessEnc.getTaint());
        addTaint(xmlEnc.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.168 -0400", hash_original_method = "67214B0FED640930AABB3A175A226E31", hash_generated_method = "8BFA447725E46D79E414E3229EAF49CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.168 -0400", hash_original_method = "8E6ACC549621DB046C39AAF67FE47CA0", hash_generated_method = "02FE94E5680B8422113DF29AFFB62C6B")
    public String getBomEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_996915367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_996915367 = bomEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_996915367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_996915367;
        // ---------- Original Method ----------
        //return bomEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.175 -0400", hash_original_method = "93213E0474402E85CBBF9C6807083224", hash_generated_method = "7D811AC79185F9D21D7DEC4D30CD9657")
    public String getXmlGuessEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_447379554 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_447379554 = xmlGuessEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_447379554.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_447379554;
        // ---------- Original Method ----------
        //return xmlGuessEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.175 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "3FEDADB1E936725F6576410E7F0BA57A")
    public String getXmlEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_474045547 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_474045547 = xmlEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_474045547.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_474045547;
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.176 -0400", hash_original_method = "AF89DB06972BD6AFB50AFEC4B946DE00", hash_generated_method = "5F0CF655DE4F277E7DD00FBDFB00EEDE")
    public String getContentTypeMime() {
        String varB4EAC82CA7396A68D541C85D26508E83_1791863556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1791863556 = contentTypeMime;
        varB4EAC82CA7396A68D541C85D26508E83_1791863556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1791863556;
        // ---------- Original Method ----------
        //return contentTypeMime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.176 -0400", hash_original_method = "D63D11323318AB5C82EE37F5F9D391F2", hash_generated_method = "E3A7835439EE7F1EFB4F8F88426C37EB")
    public String getContentTypeEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1955925776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1955925776 = contentTypeEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1955925776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1955925776;
        // ---------- Original Method ----------
        //return contentTypeEncoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.176 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "027A87B98733155076ED3CAB6436C7AB")

    private static long serialVersionUID = 1L;
}

