package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class RSAPublicKeyStructure extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.178 -0400", hash_original_field = "06EFBA23B1F3A9B846A25C6B49F30348", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.178 -0400", hash_original_field = "81999BDC63C67199D52FF9A6FC17D274", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.179 -0400", hash_original_method = "48EB528539A20A4AFED405FA2E9D9E5C", hash_generated_method = "4144DD2AAFD9958A803584B776141B25")
    public  RSAPublicKeyStructure(
        BigInteger  modulus,
        BigInteger  publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
        // ---------- Original Method ----------
        //this.modulus = modulus;
        //this.publicExponent = publicExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.179 -0400", hash_original_method = "E4CEBF5DEC44F0033674466A43F99CB9", hash_generated_method = "FDDD8766B9368D327DF42B41A3EE7E43")
    public  RSAPublicKeyStructure(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
    if(seq.size() != 2)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_2036386849 = new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_2036386849.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_2036386849;
        } //End block
        Enumeration e = seq.getObjects();
        modulus = DERInteger.getInstance(e.nextElement()).getPositiveValue();
        publicExponent = DERInteger.getInstance(e.nextElement()).getPositiveValue();
        // ---------- Original Method ----------
        //if (seq.size() != 2)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                    //+ seq.size());
        //}
        //Enumeration e = seq.getObjects();
        //modulus = DERInteger.getInstance(e.nextElement()).getPositiveValue();
        //publicExponent = DERInteger.getInstance(e.nextElement()).getPositiveValue();
    }

    
        public static RSAPublicKeyStructure getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static RSAPublicKeyStructure getInstance(
        Object obj) {
        if(obj == null || obj instanceof RSAPublicKeyStructure) 
        {
            return (RSAPublicKeyStructure)obj;
        }
        if(obj instanceof ASN1Sequence) 
        {
            return new RSAPublicKeyStructure((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("Invalid RSAPublicKeyStructure: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.181 -0400", hash_original_method = "A6C1BE2632CACEB59AFFE6BB866E7B69", hash_generated_method = "7810B0F321E67C8DBBDE639191D2EBDB")
    public BigInteger getModulus() {
BigInteger varCC3CF2CBE0D806C40D550889F76A52A1_1414098726 =         modulus;
        varCC3CF2CBE0D806C40D550889F76A52A1_1414098726.addTaint(taint);
        return varCC3CF2CBE0D806C40D550889F76A52A1_1414098726;
        // ---------- Original Method ----------
        //return modulus;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.181 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "7D573F776CD631F9DEAB27B3A7374720")
    public BigInteger getPublicExponent() {
BigInteger varB360105573401CCC465D10C242BA5623_2035082422 =         publicExponent;
        varB360105573401CCC465D10C242BA5623_2035082422.addTaint(taint);
        return varB360105573401CCC465D10C242BA5623_2035082422;
        // ---------- Original Method ----------
        //return publicExponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.182 -0400", hash_original_method = "2A6A9DB413CE77685147AC30675BFEF2", hash_generated_method = "B9331FEF6ABC8785D6F240DCF9B00C49")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DERInteger(getModulus()));
        v.add(new DERInteger(getPublicExponent()));
DERObject var0B338F106E3279986C87B595B0F4A439_1358389652 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1358389652.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1358389652;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(new DERInteger(getModulus()));
        //v.add(new DERInteger(getPublicExponent()));
        //return new DERSequence(v);
    }

    
}

