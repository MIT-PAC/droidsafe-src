package org.apache.commons.io.input;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class XmlStreamReaderException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.456 -0400", hash_original_field = "80295347C22A84C1E48F4B0A7D979301", hash_generated_field = "EC82926CAB066F06AAFC3726EF2F5BF5")

    private String bomEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.456 -0400", hash_original_field = "66A09F1DEC3A37A5B2FFCE17F416FE0B", hash_generated_field = "293562CF19517A35BB931BB29CBF3076")

    private String xmlGuessEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.456 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.456 -0400", hash_original_field = "A79DC203C305015E0EAEB00A8435D90C", hash_generated_field = "CF0AADC5E49F7DC7EC0DF8E902974BFE")

    private String contentTypeMime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.456 -0400", hash_original_field = "B4C5F58B09A24EE223B1946103129D32", hash_generated_field = "C4A1C9E33654E0FF1EF148FC95CCA1FD")

    private String contentTypeEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.457 -0400", hash_original_method = "B1FC8025A53E034082D8F586CBC4D3DF", hash_generated_method = "BDBFD07160188FE8640F3EDC8CAFB68A")
    public  XmlStreamReaderException(String msg, String bomEnc,
            String xmlGuessEnc, String xmlEnc) {
        this(msg, null, null, bomEnc, xmlGuessEnc, xmlEnc);
        addTaint(msg.getTaint());
        addTaint(bomEnc.getTaint());
        addTaint(xmlGuessEnc.getTaint());
        addTaint(xmlEnc.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.457 -0400", hash_original_method = "67214B0FED640930AABB3A175A226E31", hash_generated_method = "8BFA447725E46D79E414E3229EAF49CF")
    public  XmlStreamReaderException(String msg, String ctMime, String ctEnc,
            String bomEnc, String xmlGuessEnc, String xmlEnc) {
        super(msg);
        contentTypeMime = ctMime;
        contentTypeEncoding = ctEnc;
        bomEncoding = bomEnc;
        xmlGuessEncoding = xmlGuessEnc;
        xmlEncoding = xmlEnc;
        addTaint(msg.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.459 -0400", hash_original_method = "8E6ACC549621DB046C39AAF67FE47CA0", hash_generated_method = "F39DD0F8710A956A124E20D5DE2A8BD3")
    public String getBomEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_183093814 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_183093814 = bomEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_183093814.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_183093814;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.460 -0400", hash_original_method = "93213E0474402E85CBBF9C6807083224", hash_generated_method = "0BAFCA6D52866273DEDD45DE2599303F")
    public String getXmlGuessEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1442299868 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1442299868 = xmlGuessEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1442299868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1442299868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.462 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "0474B0481C0648E92C636184352FE3B2")
    public String getXmlEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1471431543 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1471431543 = xmlEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1471431543.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1471431543;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.462 -0400", hash_original_method = "AF89DB06972BD6AFB50AFEC4B946DE00", hash_generated_method = "7D5612D42CB26253A0228BF421CD7711")
    public String getContentTypeMime() {
        String varB4EAC82CA7396A68D541C85D26508E83_835103185 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_835103185 = contentTypeMime;
        varB4EAC82CA7396A68D541C85D26508E83_835103185.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_835103185;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.463 -0400", hash_original_method = "D63D11323318AB5C82EE37F5F9D391F2", hash_generated_method = "CEB875373D1672EEB451E1912CBD0DEA")
    public String getContentTypeEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_572352456 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_572352456 = contentTypeEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_572352456.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_572352456;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.463 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

