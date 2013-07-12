package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.404 -0400", hash_original_field = "BD51790A210EE16740CDE57FF37E7CB2", hash_generated_field = "C4E024966702B2B3513608BAFCBB1CD2")

    ASN1OctetString octStr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.404 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "445B4EB2AC4E7AC0887283D0FCFD8571")

    DERInteger iterationCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.404 -0400", hash_original_field = "5AF8CF094F8763C1015439D66C86D8D4", hash_generated_field = "20DCD247C63016DB3D80E9C4D5F28082")

    DERInteger keyLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.405 -0400", hash_original_method = "5BA909CEBC7BF7CD8A582DB2DCC88322", hash_generated_method = "9293987A5EC39CF4E6E60D9B1251A6DF")
    public  PBKDF2Params(
        byte[]  salt,
        int     iterationCount) {
        this.octStr = new DEROctetString(salt);
        this.iterationCount = new DERInteger(iterationCount);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.405 -0400", hash_original_method = "04097C22B31A4C58A7AF2A76FBE1FC77", hash_generated_method = "57D9F28ABD320FAFD2784AD29197BA1E")
    public  PBKDF2Params(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
        Enumeration e = seq.getObjects();
        octStr = (ASN1OctetString)e.nextElement();
        iterationCount = (DERInteger)e.nextElement();
    if(e.hasMoreElements())        
        {
            keyLength = (DERInteger)e.nextElement();
        } 
        else
        {
            keyLength = null;
        } 
        
        
        
        
        
        
            
        
        
        
            
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.406 -0400", hash_original_method = "5423221662EFD73C70147CAB8114C396", hash_generated_method = "A8B55C30954256E5CC5FAD3305F83656")
    public byte[] getSalt() {
        byte[] var225742414AAD58D749DE2AEF6A3EF7B3_880256056 = (octStr.getOctets());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1159480977 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1159480977;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.407 -0400", hash_original_method = "1C8F1DF1E9A7C9D74F917C50A0F9295E", hash_generated_method = "2950AB7DA2DB9B34E2A9C32ED87152F1")
    public BigInteger getIterationCount() {
BigInteger var53FCCDFC6E49719A6EF34AD5B4B147C7_157933525 =         iterationCount.getValue();
        var53FCCDFC6E49719A6EF34AD5B4B147C7_157933525.addTaint(taint);
        return var53FCCDFC6E49719A6EF34AD5B4B147C7_157933525;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.407 -0400", hash_original_method = "05FD7C7D47C946F5351B5DDBB4ABDC60", hash_generated_method = "82AEBEE068DE6527BB847139428822A8")
    public BigInteger getKeyLength() {
    if(keyLength != null)        
        {
BigInteger varEEEC002E18B33BD5FAFEC405DB0C2802_1880973791 =             keyLength.getValue();
            varEEEC002E18B33BD5FAFEC405DB0C2802_1880973791.addTaint(taint);
            return varEEEC002E18B33BD5FAFEC405DB0C2802_1880973791;
        } 
BigInteger var540C13E9E156B687226421B24F2DF178_1321302839 =         null;
        var540C13E9E156B687226421B24F2DF178_1321302839.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1321302839;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.407 -0400", hash_original_method = "B60CD10E8E03E12312566D8BFE3F0B82", hash_generated_method = "BC724238365FE4F2FCD44952E385544D")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(octStr);
        v.add(iterationCount);
    if(keyLength != null)        
        {
            v.add(keyLength);
        } 
DERObject var0B338F106E3279986C87B595B0F4A439_298494330 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_298494330.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_298494330;
        
        
        
        
        
        
            
        
        
    }

    
}

