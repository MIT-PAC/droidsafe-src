package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class SubjectPublicKeyInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.418 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.418 -0400", hash_original_field = "FBE14519E78E13F41E1D21BCCBD58AF0", hash_generated_field = "B87CF10479B698EDA26B972A47E11904")

    private DERBitString keyData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.418 -0400", hash_original_method = "DAF161BC79C94F8473696EE08E829AE4", hash_generated_method = "4363098941C5E033671050691A8E48D2")
    public  SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        DEREncodable        publicKey) {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
        // ---------- Original Method ----------
        //this.keyData = new DERBitString(publicKey);
        //this.algId = algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.419 -0400", hash_original_method = "01C45324BCF6F8FB0A087E5E236F4467", hash_generated_method = "DCA3B9BB1ABF80FCD998139CDB109A4E")
    public  SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              publicKey) {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
        // ---------- Original Method ----------
        //this.keyData = new DERBitString(publicKey);
        //this.algId = algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.420 -0400", hash_original_method = "6922DB35904CEC4F9CE097AEE1FB704C", hash_generated_method = "367B8CD3B1B588EC55AC601CA73E2728")
    public  SubjectPublicKeyInfo(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
    if(seq.size() != 2)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_835325337 = new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_835325337.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_835325337;
        } //End block
        Enumeration e = seq.getObjects();
        this.algId = AlgorithmIdentifier.getInstance(e.nextElement());
        this.keyData = DERBitString.getInstance(e.nextElement());
        // ---------- Original Method ----------
        //if (seq.size() != 2)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                    //+ seq.size());
        //}
        //Enumeration         e = seq.getObjects();
        //this.algId = AlgorithmIdentifier.getInstance(e.nextElement());
        //this.keyData = DERBitString.getInstance(e.nextElement());
    }

    
        public static SubjectPublicKeyInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static SubjectPublicKeyInfo getInstance(
        Object  obj) {
        if (obj instanceof SubjectPublicKeyInfo)
        {
            return (SubjectPublicKeyInfo)obj;
        }
        else if (obj != null)
        {
            return new SubjectPublicKeyInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.420 -0400", hash_original_method = "47532F5520D2937711F415E7F39EF8B8", hash_generated_method = "840056B1C1925045E309B9E4BACA04C4")
    public AlgorithmIdentifier getAlgorithmId() {
AlgorithmIdentifier varA285EDCEC70BDAD72C7F53B57CB6849B_1093986887 =         algId;
        varA285EDCEC70BDAD72C7F53B57CB6849B_1093986887.addTaint(taint);
        return varA285EDCEC70BDAD72C7F53B57CB6849B_1093986887;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.421 -0400", hash_original_method = "090BC4B735B0EF996158F2D4FCADB97F", hash_generated_method = "CEDBA66837CF9134E0D9BEE7353F5168")
    public DERObject getPublicKey() throws IOException {
        ASN1InputStream aIn = new ASN1InputStream(keyData.getBytes());
DERObject var744C7B728C1BF7AC9370DA8D8B9598D6_1963335834 =         aIn.readObject();
        var744C7B728C1BF7AC9370DA8D8B9598D6_1963335834.addTaint(taint);
        return var744C7B728C1BF7AC9370DA8D8B9598D6_1963335834;
        // ---------- Original Method ----------
        //ASN1InputStream         aIn = new ASN1InputStream(keyData.getBytes());
        //return aIn.readObject();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.421 -0400", hash_original_method = "FD0FC1FA0D4AD47E47F52CC8C4964141", hash_generated_method = "9DCF1C495BE1AF55E59A7D624250FA8B")
    public DERBitString getPublicKeyData() {
DERBitString varE693AFBBC8CDD78D253BF1E5459B5722_1855969778 =         keyData;
        varE693AFBBC8CDD78D253BF1E5459B5722_1855969778.addTaint(taint);
        return varE693AFBBC8CDD78D253BF1E5459B5722_1855969778;
        // ---------- Original Method ----------
        //return keyData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.421 -0400", hash_original_method = "8E6747A0EE688E54DEDDDF71F404B9F7", hash_generated_method = "0D55757FE218126CBCF23B60680079AE")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(algId);
        v.add(keyData);
DERObject var0B338F106E3279986C87B595B0F4A439_1628341767 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1628341767.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1628341767;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(algId);
        //v.add(keyData);
        //return new DERSequence(v);
    }

    
}

