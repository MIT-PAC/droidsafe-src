package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.886 -0400", hash_original_field = "2F36EF4E04A227D77A0591889E0028A1", hash_generated_field = "1EBFC1EA7BE5FBB19EED6A7F33E7C5E0")

    DEREnumerated digestedObjectType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.886 -0400", hash_original_field = "56901C98B310B291FF68D057482ABC69", hash_generated_field = "2E52D7500B72C9A66D7BDA7C325C8111")

    DERObjectIdentifier otherObjectTypeID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.886 -0400", hash_original_field = "2D805113072BCF9647830D1BB8E51D08", hash_generated_field = "CA29728B9069A9E1C4E28C8A9BC0FDFA")

    AlgorithmIdentifier digestAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.886 -0400", hash_original_field = "09663AF14956BC25D64997F543CD42EF", hash_generated_field = "A8067FEC006B3B31C7D2F37BC96A1A60")

    DERBitString objectDigest;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.887 -0400", hash_original_method = "2BCF3A62675E792C7E57D418D30ED426", hash_generated_method = "74A571619A6A2776FA2875749036B521")
    public  ObjectDigestInfo(
        int digestedObjectType,
        String otherObjectTypeID,
        AlgorithmIdentifier digestAlgorithm,
        byte[] objectDigest) {
        this.digestedObjectType = new DEREnumerated(digestedObjectType);
        {
            this.otherObjectTypeID = new DERObjectIdentifier(otherObjectTypeID);
        } 
        this.digestAlgorithm = digestAlgorithm;
        this.objectDigest = new DERBitString(objectDigest);
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.887 -0400", hash_original_method = "44BAD3DCA2A27D701ACA3AA084450844", hash_generated_method = "C6BE57C3F054BE6F6CE4A4AF64C44FBD")
    private  ObjectDigestInfo(
        ASN1Sequence seq) {
        {
            boolean varDBA2BDF5A09A07BAB06B20BE323B617B_405030303 = (seq.size() > 4 || seq.size() < 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                + seq.size());
            } 
        } 
        digestedObjectType = DEREnumerated.getInstance(seq.getObjectAt(0));
        int offset = 0;
        {
            boolean varD198700A8B4B6B137665E7A32DD2A838_1864011833 = (seq.size() == 4);
            {
                otherObjectTypeID = DERObjectIdentifier.getInstance(seq.getObjectAt(1));
            } 
        } 
        digestAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1 + offset));
        objectDigest = DERBitString.getInstance(seq.getObjectAt(2 + offset));
        
        
        
            
                
        
        
        
        
        
            
            
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.889 -0400", hash_original_method = "6F0ED6AFEE9055594DCEF2A3E1A2F111", hash_generated_method = "E8371BFBF1FF93DDC63B315557947B9F")
    public DEREnumerated getDigestedObjectType() {
        DEREnumerated varB4EAC82CA7396A68D541C85D26508E83_1083914246 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1083914246 = digestedObjectType;
        varB4EAC82CA7396A68D541C85D26508E83_1083914246.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1083914246;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.889 -0400", hash_original_method = "ED88D29FA12F8D28E30CF15EC0719828", hash_generated_method = "6CEB4331D7C2DBC6D6E8DCDF1262285D")
    public DERObjectIdentifier getOtherObjectTypeID() {
        DERObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_1659388549 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1659388549 = otherObjectTypeID;
        varB4EAC82CA7396A68D541C85D26508E83_1659388549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1659388549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.890 -0400", hash_original_method = "80A095D2CD5C912E5290805C4F2E95A6", hash_generated_method = "96232E5FCF4C563D230942DAA11BBC1C")
    public AlgorithmIdentifier getDigestAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1410955927 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1410955927 = digestAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1410955927.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1410955927;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.890 -0400", hash_original_method = "591AAD603948030260B8B2B98E27FE31", hash_generated_method = "22D0C8E40C7D9F7CEDBD164FDA0D69B2")
    public DERBitString getObjectDigest() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1544294810 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1544294810 = objectDigest;
        varB4EAC82CA7396A68D541C85D26508E83_1544294810.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1544294810;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.892 -0400", hash_original_method = "2916DBD20BE914B0B076A9BFA9563581", hash_generated_method = "E8AAB17CB174657931F6EAC85D74B10E")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1870366940 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(digestedObjectType);
        {
            v.add(otherObjectTypeID);
        } 
        v.add(digestAlgorithm);
        v.add(objectDigest);
        varB4EAC82CA7396A68D541C85D26508E83_1870366940 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1870366940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1870366940;
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.892 -0400", hash_original_field = "752F38030C2CA3C1E0739EB6D0FC76D7", hash_generated_field = "BF5C05C05CEF80A8322320530D7E74F5")

    public final static int publicKey = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.892 -0400", hash_original_field = "4A31A9953191C61E9EB9240C1B2548FC", hash_generated_field = "1D343F3859B75D9882E9DA17F4BBF575")

    public final static int publicKeyCert = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.892 -0400", hash_original_field = "510EA9022C6F3C0451A31F12813E0EF7", hash_generated_field = "425AF1E78D83F4CF88C7FADF880769E7")

    public final static int otherObjectDigest = 2;
}

