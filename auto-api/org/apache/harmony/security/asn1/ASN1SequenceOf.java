package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class ASN1SequenceOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.617 -0400", hash_original_method = "21EE3E508EAE978A6E4C8F66A4495FB2", hash_generated_method = "6AA343111503CCCABA03EAC384BEDE01")
    public  ASN1SequenceOf(ASN1Type type) {
        super(TAG_SEQUENCE, type);
        addTaint(type.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.619 -0400", hash_original_method = "1210CAF0851F865D477F96ED0B5EA47B", hash_generated_method = "1560FDEA7151AF9E41E0D9DDFB59A1E8")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_446169439 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2116197697 = null; 
        in.readSequenceOf(this);
        {
            varB4EAC82CA7396A68D541C85D26508E83_446169439 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2116197697 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1192547210; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1192547210 = varB4EAC82CA7396A68D541C85D26508E83_446169439;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1192547210 = varB4EAC82CA7396A68D541C85D26508E83_2116197697;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1192547210.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1192547210;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.619 -0400", hash_original_method = "501E4537A812C53E7A97F9D07A5FDD79", hash_generated_method = "7CBAA074EE40169E508399A1B9082F42")
    public final void encodeContent(BerOutputStream out) {
        out.encodeSequenceOf(this);
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.619 -0400", hash_original_method = "7ECE29473F04DAB7CB66888A658BFD1F", hash_generated_method = "28AD3CE6EEB3CFB920F23788E1BA81B5")
    public final void setEncodingContent(BerOutputStream out) {
        out.getSequenceOfLength(this);
        addTaint(out.getTaint());
        
        
    }

    
}

