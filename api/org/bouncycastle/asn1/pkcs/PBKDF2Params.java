package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class PBKDF2Params extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.091 -0400", hash_original_field = "BD51790A210EE16740CDE57FF37E7CB2", hash_generated_field = "C4E024966702B2B3513608BAFCBB1CD2")

    ASN1OctetString octStr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.091 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "445B4EB2AC4E7AC0887283D0FCFD8571")

    DERInteger iterationCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.091 -0400", hash_original_field = "5AF8CF094F8763C1015439D66C86D8D4", hash_generated_field = "20DCD247C63016DB3D80E9C4D5F28082")

    DERInteger keyLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.091 -0400", hash_original_method = "5BA909CEBC7BF7CD8A582DB2DCC88322", hash_generated_method = "9293987A5EC39CF4E6E60D9B1251A6DF")
    public  PBKDF2Params(
        byte[]  salt,
        int     iterationCount) {
        this.octStr = new DEROctetString(salt);
        this.iterationCount = new DERInteger(iterationCount);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.091 -0400", hash_original_method = "04097C22B31A4C58A7AF2A76FBE1FC77", hash_generated_method = "6F140B85FE6923143FBDD1A69656914E")
    public  PBKDF2Params(
        ASN1Sequence  seq) {
        Enumeration e = seq.getObjects();
        octStr = (ASN1OctetString)e.nextElement();
        iterationCount = (DERInteger)e.nextElement();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_2140542533 = (e.hasMoreElements());
            {
                keyLength = (DERInteger)e.nextElement();
            } 
            {
                keyLength = null;
            } 
        } 
        addTaint(seq.getTaint());
        
        
        
        
        
        
            
        
        
        
            
        
    }

    
    public static PBKDF2Params getInstance(
        Object  obj) {
        if (obj instanceof PBKDF2Params)
        {
            return (PBKDF2Params)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new PBKDF2Params((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.092 -0400", hash_original_method = "5423221662EFD73C70147CAB8114C396", hash_generated_method = "48F7A2D7717953171F7E307E2526CC5B")
    public byte[] getSalt() {
        byte[] var59A5FB87189D41C68C894440CB748384_1206579989 = (octStr.getOctets());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1397331365 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1397331365;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.092 -0400", hash_original_method = "1C8F1DF1E9A7C9D74F917C50A0F9295E", hash_generated_method = "185731F795B9664B6192DCD5C9787FC7")
    public BigInteger getIterationCount() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_375847283 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_375847283 = iterationCount.getValue();
        varB4EAC82CA7396A68D541C85D26508E83_375847283.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_375847283;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.092 -0400", hash_original_method = "05FD7C7D47C946F5351B5DDBB4ABDC60", hash_generated_method = "BDD8BB0F0E5A18DE92E49A45157450AF")
    public BigInteger getKeyLength() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1977729410 = null; 
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1474667136 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1977729410 = keyLength.getValue();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1474667136 = null;
        BigInteger varA7E53CE21691AB073D9660D615818899_162088481; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_162088481 = varB4EAC82CA7396A68D541C85D26508E83_1977729410;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_162088481 = varB4EAC82CA7396A68D541C85D26508E83_1474667136;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_162088481.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_162088481;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.093 -0400", hash_original_method = "B60CD10E8E03E12312566D8BFE3F0B82", hash_generated_method = "EE3FEFF0F9AA6C8D7F6838D12D2F09AF")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_985477756 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(octStr);
        v.add(iterationCount);
        {
            v.add(keyLength);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_985477756 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_985477756.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_985477756;
        
        
        
        
        
        
            
        
        
    }

    
}

