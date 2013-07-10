package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public final class ASN1Enumerated extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.469 -0400", hash_original_method = "AA03F41F75612EB5366E32BDDDAEA1AC", hash_generated_method = "11C6DEF098A19B58952BF9C0E3E54B4B")
    public  ASN1Enumerated() {
        super(TAG_ENUM);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1Enumerated getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.470 -0400", hash_original_method = "810B1EC4B5D81C8B87770AF406E0EFF5", hash_generated_method = "251A8419209CADB2232C4ED46A9375D6")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_262106284 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1741799247 = null; 
        in.readEnumerated();
        {
            varB4EAC82CA7396A68D541C85D26508E83_262106284 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1741799247 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_627945919; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_627945919 = varB4EAC82CA7396A68D541C85D26508E83_262106284;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_627945919 = varB4EAC82CA7396A68D541C85D26508E83_1741799247;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_627945919.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_627945919;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.471 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "99110FE3DA173E6AD2DC0424D71B61FA")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_788643281 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_788643281 = Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_788643281.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_788643281;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.471 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "BAA11C0A71C0484BDDB971998BB29CEF")
    public void encodeContent(BerOutputStream out) {
        out.encodeInteger();
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.471 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "28412896F17AF4B874C6F607DA4D2993")
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.471 -0400", hash_original_field = "19E9747C25CFD9985C0EA6DB9F3FBE5D", hash_generated_field = "E1CAA2576C780B35F20FCEF265B3C62C")

    private static final ASN1Enumerated ASN1 = new ASN1Enumerated();
}

