package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public final class ASN1Boolean extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.419 -0400", hash_original_method = "FD99504F4E1A7A3268A56063556CF13F", hash_generated_method = "02BFB4CEBA233BD3B2DAAA4AB6F0DE78")
    public  ASN1Boolean() {
        super(TAG_BOOLEAN);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1Boolean getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.420 -0400", hash_original_method = "4CABEEE4334687B876309AFB865CC60D", hash_generated_method = "B0F988CAD207D4FE0B037A9ADE4EFF06")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_978617186 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_126358477 = null; 
        in.readBoolean();
        {
            varB4EAC82CA7396A68D541C85D26508E83_978617186 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_126358477 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2099054792; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2099054792 = varB4EAC82CA7396A68D541C85D26508E83_978617186;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2099054792 = varB4EAC82CA7396A68D541C85D26508E83_126358477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2099054792.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2099054792;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.421 -0400", hash_original_method = "61E80FB6E60B72FAF41ECC8283C8390E", hash_generated_method = "62BDFDB1221DE361153D1EE3D09846C1")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_600425241 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1787615387 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_600425241 = Boolean.FALSE;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1787615387 = Boolean.TRUE;
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_960703541; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_960703541 = varB4EAC82CA7396A68D541C85D26508E83_600425241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_960703541 = varB4EAC82CA7396A68D541C85D26508E83_1787615387;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_960703541.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_960703541;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.421 -0400", hash_original_method = "6CB7A1753C32BDECF173E6F0AF328B6D", hash_generated_method = "683299BC050C2E06B18C4827F7AB4A6F")
    public void encodeContent(BerOutputStream out) {
        out.encodeBoolean();
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.421 -0400", hash_original_method = "E10D3150F01479FE85EBF9E119EE1844", hash_generated_method = "E5F019B44A8D9708611B427F89C6C298")
    public void setEncodingContent(BerOutputStream out) {
        out.length = 1;
        addTaint(out.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.422 -0400", hash_original_field = "7BCAFF74B89ECED52EBB0375DE737548", hash_generated_field = "7128E6C29F8DA081B0F9E7466343FAEE")

    private static final ASN1Boolean ASN1 = new ASN1Boolean();
}

