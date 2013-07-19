package org.bouncycastle.asn1.x509;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SubjectPublicKeyInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.832 -0400", hash_original_field = "7E017AD6DBE390CDE33A4543127F45F7", hash_generated_field = "7AD6F6C3D264D25074D6D91921F8050B")

    private AlgorithmIdentifier algId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.832 -0400", hash_original_field = "FBE14519E78E13F41E1D21BCCBD58AF0", hash_generated_field = "B87CF10479B698EDA26B972A47E11904")

    private DERBitString keyData;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.833 -0400", hash_original_method = "DAF161BC79C94F8473696EE08E829AE4", hash_generated_method = "4363098941C5E033671050691A8E48D2")
    public  SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        DEREncodable        publicKey) {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
        // ---------- Original Method ----------
        //this.keyData = new DERBitString(publicKey);
        //this.algId = algId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.834 -0400", hash_original_method = "01C45324BCF6F8FB0A087E5E236F4467", hash_generated_method = "DCA3B9BB1ABF80FCD998139CDB109A4E")
    public  SubjectPublicKeyInfo(
        AlgorithmIdentifier algId,
        byte[]              publicKey) {
        this.keyData = new DERBitString(publicKey);
        this.algId = algId;
        // ---------- Original Method ----------
        //this.keyData = new DERBitString(publicKey);
        //this.algId = algId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.835 -0400", hash_original_method = "6922DB35904CEC4F9CE097AEE1FB704C", hash_generated_method = "5876984261060BDD8A5C485C02022707")
    public  SubjectPublicKeyInfo(
        ASN1Sequence  seq) {
        addTaint(seq.getTaint());
        if(seq.size() != 2)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1552311784 = new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1552311784.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1552311784;
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

    
    @DSModeled(DSC.SAFE)
    public static SubjectPublicKeyInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSModeled(DSC.SAFE)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.836 -0400", hash_original_method = "47532F5520D2937711F415E7F39EF8B8", hash_generated_method = "C5F3189EC598C74B46311C93ED5EC93E")
    public AlgorithmIdentifier getAlgorithmId() {
AlgorithmIdentifier varA285EDCEC70BDAD72C7F53B57CB6849B_1477397614 =         algId;
        varA285EDCEC70BDAD72C7F53B57CB6849B_1477397614.addTaint(taint);
        return varA285EDCEC70BDAD72C7F53B57CB6849B_1477397614;
        // ---------- Original Method ----------
        //return algId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.837 -0400", hash_original_method = "090BC4B735B0EF996158F2D4FCADB97F", hash_generated_method = "EB69673EDCDEF0E6E95A7F98F487C054")
    public DERObject getPublicKey() throws IOException {
        ASN1InputStream aIn = new ASN1InputStream(keyData.getBytes());
DERObject var744C7B728C1BF7AC9370DA8D8B9598D6_293279520 =         aIn.readObject();
        var744C7B728C1BF7AC9370DA8D8B9598D6_293279520.addTaint(taint);
        return var744C7B728C1BF7AC9370DA8D8B9598D6_293279520;
        // ---------- Original Method ----------
        //ASN1InputStream         aIn = new ASN1InputStream(keyData.getBytes());
        //return aIn.readObject();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.837 -0400", hash_original_method = "FD0FC1FA0D4AD47E47F52CC8C4964141", hash_generated_method = "AF31C8B0DD57695F7F34BA6463269520")
    public DERBitString getPublicKeyData() {
DERBitString varE693AFBBC8CDD78D253BF1E5459B5722_1340930718 =         keyData;
        varE693AFBBC8CDD78D253BF1E5459B5722_1340930718.addTaint(taint);
        return varE693AFBBC8CDD78D253BF1E5459B5722_1340930718;
        // ---------- Original Method ----------
        //return keyData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.837 -0400", hash_original_method = "8E6747A0EE688E54DEDDDF71F404B9F7", hash_generated_method = "2F4CCC875B3C111BCEAF48ECF9FF0C1C")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(algId);
        v.add(keyData);
DERObject var0B338F106E3279986C87B595B0F4A439_1226824805 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1226824805.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1226824805;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(algId);
        //v.add(keyData);
        //return new DERSequence(v);
    }

    
}

