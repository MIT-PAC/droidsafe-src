package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public class ASN1OctetString extends ASN1StringType {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.552 -0400", hash_original_method = "FE8C061A61754FEAD4E80D2F91CDD232", hash_generated_method = "D6ED9BA2FC4CE32BD81039A4C8CEA95C")
    public  ASN1OctetString() {
        super(TAG_OCTETSTRING);
        
    }

    
    public static ASN1OctetString getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.553 -0400", hash_original_method = "28376DFC29A2213C4817BE9D28454968", hash_generated_method = "85601DA74930495F13EF675D05152C8D")
    @Override
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_673367888 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1464774990 = null; 
        in.readOctetString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_673367888 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1464774990 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_601976857; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_601976857 = varB4EAC82CA7396A68D541C85D26508E83_673367888;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_601976857 = varB4EAC82CA7396A68D541C85D26508E83_1464774990;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_601976857.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_601976857;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.553 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "EB1DE5FB5EF87F60533870610C6EFA2A")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1376504915 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1376504915 = Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1376504915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1376504915;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.553 -0400", hash_original_method = "612A16573B17613AF81AE7469C8D7FB4", hash_generated_method = "7710C605F6B7AC9571C65835E736DE71")
    @Override
    public void encodeContent(BerOutputStream out) {
        out.encodeOctetString();
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.553 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "E76CC36EECA306EE3B96C1FF22DE2414")
    @Override
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.553 -0400", hash_original_field = "25107E945D1756F345B685F812B017DB", hash_generated_field = "BBC2F7EF6217ADF6A8ED0EF7FBD1ADB4")

    private static final ASN1OctetString ASN1 = new ASN1OctetString();
}

