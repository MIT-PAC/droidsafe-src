package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;






public class ObjectDigestInfo extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.788 -0400", hash_original_field = "2F36EF4E04A227D77A0591889E0028A1", hash_generated_field = "1EBFC1EA7BE5FBB19EED6A7F33E7C5E0")

    DEREnumerated digestedObjectType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.788 -0400", hash_original_field = "56901C98B310B291FF68D057482ABC69", hash_generated_field = "2E52D7500B72C9A66D7BDA7C325C8111")

    DERObjectIdentifier otherObjectTypeID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.788 -0400", hash_original_field = "2D805113072BCF9647830D1BB8E51D08", hash_generated_field = "CA29728B9069A9E1C4E28C8A9BC0FDFA")

    AlgorithmIdentifier digestAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.788 -0400", hash_original_field = "09663AF14956BC25D64997F543CD42EF", hash_generated_field = "A8067FEC006B3B31C7D2F37BC96A1A60")

    DERBitString objectDigest;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.789 -0400", hash_original_method = "2BCF3A62675E792C7E57D418D30ED426", hash_generated_method = "75E3F9ED95C8E74D2BC5DFC3FA84301F")
    public  ObjectDigestInfo(
        int digestedObjectType,
        String otherObjectTypeID,
        AlgorithmIdentifier digestAlgorithm,
        byte[] objectDigest) {
        this.digestedObjectType = new DEREnumerated(digestedObjectType);
        if(digestedObjectType == otherObjectDigest)        
        {
            this.otherObjectTypeID = new DERObjectIdentifier(otherObjectTypeID);
        } //End block
        this.digestAlgorithm = digestAlgorithm;
        this.objectDigest = new DERBitString(objectDigest);
        // ---------- Original Method ----------
        //this.digestedObjectType = new DEREnumerated(digestedObjectType);
        //if (digestedObjectType == otherObjectDigest)
        //{
            //this.otherObjectTypeID = new DERObjectIdentifier(otherObjectTypeID);
        //}
        //this.digestAlgorithm = digestAlgorithm;
        //this.objectDigest = new DERBitString(objectDigest);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.790 -0400", hash_original_method = "44BAD3DCA2A27D701ACA3AA084450844", hash_generated_method = "1D304374910F889AE071F2170D1FDBCD")
    private  ObjectDigestInfo(
        ASN1Sequence seq) {
        if(seq.size() > 4 || seq.size() < 3)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1283567901 = new IllegalArgumentException("Bad sequence size: "
                + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1283567901.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1283567901;
        } //End block
        digestedObjectType = DEREnumerated.getInstance(seq.getObjectAt(0));
        int offset = 0;
        if(seq.size() == 4)        
        {
            otherObjectTypeID = DERObjectIdentifier.getInstance(seq.getObjectAt(1));
            offset++;
        } //End block
        digestAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1 + offset));
        objectDigest = DERBitString.getInstance(seq.getObjectAt(2 + offset));
        // ---------- Original Method ----------
        //if (seq.size() > 4 || seq.size() < 3)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                //+ seq.size());
        //}
        //digestedObjectType = DEREnumerated.getInstance(seq.getObjectAt(0));
        //int offset = 0;
        //if (seq.size() == 4)
        //{
            //otherObjectTypeID = DERObjectIdentifier.getInstance(seq.getObjectAt(1));
            //offset++;
        //}
        //digestAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1 + offset));
        //objectDigest = DERBitString.getInstance(seq.getObjectAt(2 + offset));
    }

    
    @DSModeled(DSC.SAFE)
    public static ObjectDigestInfo getInstance(
        Object obj) {
        if (obj == null || obj instanceof ObjectDigestInfo)
        {
            return (ObjectDigestInfo)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new ObjectDigestInfo((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: "
            + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static ObjectDigestInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.792 -0400", hash_original_method = "6F0ED6AFEE9055594DCEF2A3E1A2F111", hash_generated_method = "A6DF700D8E722A0446E3B8B55E82055D")
    public DEREnumerated getDigestedObjectType() {
DEREnumerated varBB51C18A55805846B64487D1DBD2CFE5_860224110 =         digestedObjectType;
        varBB51C18A55805846B64487D1DBD2CFE5_860224110.addTaint(taint);
        return varBB51C18A55805846B64487D1DBD2CFE5_860224110;
        // ---------- Original Method ----------
        //return digestedObjectType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.792 -0400", hash_original_method = "ED88D29FA12F8D28E30CF15EC0719828", hash_generated_method = "AB3F8C299074D054B0DED460136F1924")
    public DERObjectIdentifier getOtherObjectTypeID() {
DERObjectIdentifier varCA62BB60C11C0113F3CD8E01BF7E92A9_732520647 =         otherObjectTypeID;
        varCA62BB60C11C0113F3CD8E01BF7E92A9_732520647.addTaint(taint);
        return varCA62BB60C11C0113F3CD8E01BF7E92A9_732520647;
        // ---------- Original Method ----------
        //return otherObjectTypeID;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.793 -0400", hash_original_method = "80A095D2CD5C912E5290805C4F2E95A6", hash_generated_method = "4FD841F0A4D2BE107F0ECC9EF4A21024")
    public AlgorithmIdentifier getDigestAlgorithm() {
AlgorithmIdentifier var8B0C3F647118591D6E144CA7824FEB70_595634638 =         digestAlgorithm;
        var8B0C3F647118591D6E144CA7824FEB70_595634638.addTaint(taint);
        return var8B0C3F647118591D6E144CA7824FEB70_595634638;
        // ---------- Original Method ----------
        //return digestAlgorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.794 -0400", hash_original_method = "591AAD603948030260B8B2B98E27FE31", hash_generated_method = "9DB51AE1FABB29EE56F192A7448EFF02")
    public DERBitString getObjectDigest() {
DERBitString var1128EBB681DA936639CDE82641A6C31D_1838698614 =         objectDigest;
        var1128EBB681DA936639CDE82641A6C31D_1838698614.addTaint(taint);
        return var1128EBB681DA936639CDE82641A6C31D_1838698614;
        // ---------- Original Method ----------
        //return objectDigest;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.795 -0400", hash_original_method = "2916DBD20BE914B0B076A9BFA9563581", hash_generated_method = "227923D6FCB358E80F3547E3942AF8A9")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(digestedObjectType);
        if(otherObjectTypeID != null)        
        {
            v.add(otherObjectTypeID);
        } //End block
        v.add(digestAlgorithm);
        v.add(objectDigest);
DERObject var0B338F106E3279986C87B595B0F4A439_2117525618 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_2117525618.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_2117525618;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(digestedObjectType);
        //if (otherObjectTypeID != null)
        //{
            //v.add(otherObjectTypeID);
        //}
        //v.add(digestAlgorithm);
        //v.add(objectDigest);
        //return new DERSequence(v);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.795 -0400", hash_original_field = "752F38030C2CA3C1E0739EB6D0FC76D7", hash_generated_field = "BF5C05C05CEF80A8322320530D7E74F5")

    public final static int publicKey = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.795 -0400", hash_original_field = "4A31A9953191C61E9EB9240C1B2548FC", hash_generated_field = "1D343F3859B75D9882E9DA17F4BBF575")

    public final static int publicKeyCert = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.795 -0400", hash_original_field = "510EA9022C6F3C0451A31F12813E0EF7", hash_generated_field = "425AF1E78D83F4CF88C7FADF880769E7")

    public final static int otherObjectDigest = 2;
}

