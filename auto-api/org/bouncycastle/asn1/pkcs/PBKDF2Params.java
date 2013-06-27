package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.505 -0400", hash_original_field = "BD51790A210EE16740CDE57FF37E7CB2", hash_generated_field = "C4E024966702B2B3513608BAFCBB1CD2")

    ASN1OctetString octStr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.505 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "445B4EB2AC4E7AC0887283D0FCFD8571")

    DERInteger iterationCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.506 -0400", hash_original_field = "5AF8CF094F8763C1015439D66C86D8D4", hash_generated_field = "20DCD247C63016DB3D80E9C4D5F28082")

    DERInteger keyLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.506 -0400", hash_original_method = "5BA909CEBC7BF7CD8A582DB2DCC88322", hash_generated_method = "9293987A5EC39CF4E6E60D9B1251A6DF")
    public  PBKDF2Params(
        byte[]  salt,
        int     iterationCount) {
        this.octStr = new DEROctetString(salt);
        this.iterationCount = new DERInteger(iterationCount);
        // ---------- Original Method ----------
        //this.octStr = new DEROctetString(salt);
        //this.iterationCount = new DERInteger(iterationCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.515 -0400", hash_original_method = "04097C22B31A4C58A7AF2A76FBE1FC77", hash_generated_method = "609915CBF1294DE0985EA5C3277B23AB")
    public  PBKDF2Params(
        ASN1Sequence  seq) {
        Enumeration e;
        e = seq.getObjects();
        octStr = (ASN1OctetString)e.nextElement();
        iterationCount = (DERInteger)e.nextElement();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_67581797 = (e.hasMoreElements());
            {
                keyLength = (DERInteger)e.nextElement();
            } //End block
            {
                keyLength = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        //Enumeration e = seq.getObjects();
        //octStr = (ASN1OctetString)e.nextElement();
        //iterationCount = (DERInteger)e.nextElement();
        //if (e.hasMoreElements())
        //{
            //keyLength = (DERInteger)e.nextElement();
        //}
        //else
        //{
            //keyLength = null;
        //}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.518 -0400", hash_original_method = "5423221662EFD73C70147CAB8114C396", hash_generated_method = "47624561DE1BDEAA0846A1FDE343D0C7")
    public byte[] getSalt() {
        byte[] var59A5FB87189D41C68C894440CB748384_1647099666 = (octStr.getOctets());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_675868439 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_675868439;
        // ---------- Original Method ----------
        //return octStr.getOctets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.520 -0400", hash_original_method = "1C8F1DF1E9A7C9D74F917C50A0F9295E", hash_generated_method = "586F6B6A70FB94514B77778B69E8376E")
    public BigInteger getIterationCount() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1169907965 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1169907965 = iterationCount.getValue();
        varB4EAC82CA7396A68D541C85D26508E83_1169907965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1169907965;
        // ---------- Original Method ----------
        //return iterationCount.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.526 -0400", hash_original_method = "05FD7C7D47C946F5351B5DDBB4ABDC60", hash_generated_method = "A97A093F6348F274FFF79D0AAEA13842")
    public BigInteger getKeyLength() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_429908179 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_169593971 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_429908179 = keyLength.getValue();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_169593971 = null;
        BigInteger varA7E53CE21691AB073D9660D615818899_1969217533; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1969217533 = varB4EAC82CA7396A68D541C85D26508E83_429908179;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1969217533 = varB4EAC82CA7396A68D541C85D26508E83_169593971;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1969217533.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1969217533;
        // ---------- Original Method ----------
        //if (keyLength != null)
        //{
            //return keyLength.getValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.528 -0400", hash_original_method = "B60CD10E8E03E12312566D8BFE3F0B82", hash_generated_method = "BCCB6CDDE5405FF6562A9917EF80FBC0")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2014518247 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(octStr);
        v.add(iterationCount);
        {
            v.add(keyLength);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2014518247 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_2014518247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2014518247;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(octStr);
        //v.add(iterationCount);
        //if (keyLength != null)
        //{
            //v.add(keyLength);
        //}
        //return new DERSequence(v);
    }

    
}

