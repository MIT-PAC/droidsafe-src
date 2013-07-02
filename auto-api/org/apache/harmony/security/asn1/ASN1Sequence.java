package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class ASN1Sequence extends ASN1TypeCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.607 -0400", hash_original_method = "610127CDCC1D4C9ACAEBD8E4C31C3ADC", hash_generated_method = "C9229CAEBA7F81F1D78AC10A5D9D4E4F")
    public  ASN1Sequence(ASN1Type[] type) {
        super(TAG_SEQUENCE, type);
        addTaint(type[0].getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.608 -0400", hash_original_method = "C5F60D3147ABDE99A60159C3AF8B464E", hash_generated_method = "580B453D7A3A1DBFD63A642913CB0D1B")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_832217180 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1392190701 = null; 
        in.readSequence(this);
        {
            varB4EAC82CA7396A68D541C85D26508E83_832217180 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1392190701 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_619967367; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_619967367 = varB4EAC82CA7396A68D541C85D26508E83_832217180;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_619967367 = varB4EAC82CA7396A68D541C85D26508E83_1392190701;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_619967367.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_619967367;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.609 -0400", hash_original_method = "939BEAD5C5B494829F962DC4CEF2A705", hash_generated_method = "D7C9B115337776E24839FA651CD23C56")
    public final void encodeContent(BerOutputStream out) {
        out.encodeSequence(this);
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.609 -0400", hash_original_method = "1B7230BCE7873794BACD95464198B69E", hash_generated_method = "C668CFE3562DA23D5162A2B3952EF9D0")
    public final void setEncodingContent(BerOutputStream out) {
        out.getSequenceLength(this);
        addTaint(out.getTaint());
        
        
    }

    
}

