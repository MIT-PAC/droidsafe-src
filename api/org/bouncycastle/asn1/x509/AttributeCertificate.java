package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttributeCertificate extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.591 -0400", hash_original_field = "EDA2B26CC47ACE67E5CC2E518DCDA626", hash_generated_field = "B5AE372EF54AD09B5DE33BF4EF964975")

    AttributeCertificateInfo acinfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.591 -0400", hash_original_field = "0C3D482A41621822B95C4386FD1F1FC2", hash_generated_field = "2F7BE616514E885F71195FC5A07117B0")

    AlgorithmIdentifier signatureAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.592 -0400", hash_original_field = "A83E026224A6F552557EF9C7ABF67D37", hash_generated_field = "4A7A5C247FCE2D566D9AC9C1B8CED914")

    DERBitString signatureValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.593 -0400", hash_original_method = "2BEC4272F0342CC60C1E5750AB362553", hash_generated_method = "80C212D7054336F30DC20FF180FC8C79")
    public  AttributeCertificate(
        AttributeCertificateInfo    acinfo,
        AlgorithmIdentifier         signatureAlgorithm,
        DERBitString                signatureValue) {
        this.acinfo = acinfo;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = signatureValue;
        // ---------- Original Method ----------
        //this.acinfo = acinfo;
        //this.signatureAlgorithm = signatureAlgorithm;
        //this.signatureValue = signatureValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.595 -0400", hash_original_method = "B4D994B87261FFD4B0816002B55F0788", hash_generated_method = "9FFE9700D0C01C0356C98D512FDC79ED")
    public  AttributeCertificate(
        ASN1Sequence    seq) {
        if(seq.size() != 3)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_508755090 = new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_508755090.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_508755090;
        } //End block
        this.acinfo = AttributeCertificateInfo.getInstance(seq.getObjectAt(0));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        this.signatureValue = DERBitString.getInstance(seq.getObjectAt(2));
        // ---------- Original Method ----------
        //if (seq.size() != 3)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                    //+ seq.size());
        //}
        //this.acinfo = AttributeCertificateInfo.getInstance(seq.getObjectAt(0));
        //this.signatureAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        //this.signatureValue = DERBitString.getInstance(seq.getObjectAt(2));
    }

    
    @DSModeled(DSC.SPEC)
    public static AttributeCertificate getInstance(Object obj) {
        if (obj instanceof AttributeCertificate)
        {
            return (AttributeCertificate)obj;
        }
        else if (obj != null)
        {
            return new AttributeCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.596 -0400", hash_original_method = "B550BE2A3120BC2739AC35C67600D16E", hash_generated_method = "E8D56C2CB8DD738D40E2DEDDB6295CE5")
    public AttributeCertificateInfo getAcinfo() {
AttributeCertificateInfo varB8168BAF3CCFEADFD88512FAEFB35EEA_572333183 =         acinfo;
        varB8168BAF3CCFEADFD88512FAEFB35EEA_572333183.addTaint(taint);
        return varB8168BAF3CCFEADFD88512FAEFB35EEA_572333183;
        // ---------- Original Method ----------
        //return acinfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.597 -0400", hash_original_method = "7848C69970B1A1FD0A4AF2994EC6E56B", hash_generated_method = "48D873CA5503FCF6A0EC0C5E264279E0")
    public AlgorithmIdentifier getSignatureAlgorithm() {
AlgorithmIdentifier varFDDD2CEACD087E92485B2CF6A2712FDB_2044938263 =         signatureAlgorithm;
        varFDDD2CEACD087E92485B2CF6A2712FDB_2044938263.addTaint(taint);
        return varFDDD2CEACD087E92485B2CF6A2712FDB_2044938263;
        // ---------- Original Method ----------
        //return signatureAlgorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.597 -0400", hash_original_method = "C8410B5B4D26900579B7A994FFDFFA14", hash_generated_method = "AAE81E12B9E8D667D359DDCF02CE0920")
    public DERBitString getSignatureValue() {
DERBitString var31AD78CB3EB86CD4C82203E47E0AA933_1921489783 =         signatureValue;
        var31AD78CB3EB86CD4C82203E47E0AA933_1921489783.addTaint(taint);
        return var31AD78CB3EB86CD4C82203E47E0AA933_1921489783;
        // ---------- Original Method ----------
        //return signatureValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.597 -0400", hash_original_method = "EEF14432CC16BDD5140583520373DF2D", hash_generated_method = "D99712F6497F7F3B1804175C14D5B189")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(acinfo);
        v.add(signatureAlgorithm);
        v.add(signatureValue);
DERObject var0B338F106E3279986C87B595B0F4A439_30599939 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_30599939.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_30599939;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(acinfo);
        //v.add(signatureAlgorithm);
        //v.add(signatureValue);
        //return new DERSequence(v);
    }

    
}

