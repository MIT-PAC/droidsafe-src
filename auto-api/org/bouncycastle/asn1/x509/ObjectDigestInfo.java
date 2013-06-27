package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.033 -0400", hash_original_field = "2F36EF4E04A227D77A0591889E0028A1", hash_generated_field = "1EBFC1EA7BE5FBB19EED6A7F33E7C5E0")

    DEREnumerated digestedObjectType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.033 -0400", hash_original_field = "56901C98B310B291FF68D057482ABC69", hash_generated_field = "2E52D7500B72C9A66D7BDA7C325C8111")

    DERObjectIdentifier otherObjectTypeID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.033 -0400", hash_original_field = "2D805113072BCF9647830D1BB8E51D08", hash_generated_field = "CA29728B9069A9E1C4E28C8A9BC0FDFA")

    AlgorithmIdentifier digestAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.033 -0400", hash_original_field = "09663AF14956BC25D64997F543CD42EF", hash_generated_field = "A8067FEC006B3B31C7D2F37BC96A1A60")

    DERBitString objectDigest;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.034 -0400", hash_original_method = "2BCF3A62675E792C7E57D418D30ED426", hash_generated_method = "74A571619A6A2776FA2875749036B521")
    public  ObjectDigestInfo(
        int digestedObjectType,
        String otherObjectTypeID,
        AlgorithmIdentifier digestAlgorithm,
        byte[] objectDigest) {
        this.digestedObjectType = new DEREnumerated(digestedObjectType);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.041 -0400", hash_original_method = "44BAD3DCA2A27D701ACA3AA084450844", hash_generated_method = "5C96C3AE59A9034DE3605831B481A4A2")
    private  ObjectDigestInfo(
        ASN1Sequence seq) {
        {
            boolean varDBA2BDF5A09A07BAB06B20BE323B617B_1898533454 = (seq.size() > 4 || seq.size() < 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                + seq.size());
            } //End block
        } //End collapsed parenthetic
        digestedObjectType = DEREnumerated.getInstance(seq.getObjectAt(0));
        int offset;
        offset = 0;
        {
            boolean varD198700A8B4B6B137665E7A32DD2A838_1275204456 = (seq.size() == 4);
            {
                otherObjectTypeID = DERObjectIdentifier.getInstance(seq.getObjectAt(1));
            } //End block
        } //End collapsed parenthetic
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

    
        public static ObjectDigestInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.042 -0400", hash_original_method = "6F0ED6AFEE9055594DCEF2A3E1A2F111", hash_generated_method = "02D7D93B102BB862F88D6332F76118CE")
    public DEREnumerated getDigestedObjectType() {
        DEREnumerated varB4EAC82CA7396A68D541C85D26508E83_1872747935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1872747935 = digestedObjectType;
        varB4EAC82CA7396A68D541C85D26508E83_1872747935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1872747935;
        // ---------- Original Method ----------
        //return digestedObjectType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.043 -0400", hash_original_method = "ED88D29FA12F8D28E30CF15EC0719828", hash_generated_method = "FFF24F7A36641892DA2488C978E3DC8A")
    public DERObjectIdentifier getOtherObjectTypeID() {
        DERObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_1663429571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1663429571 = otherObjectTypeID;
        varB4EAC82CA7396A68D541C85D26508E83_1663429571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1663429571;
        // ---------- Original Method ----------
        //return otherObjectTypeID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.043 -0400", hash_original_method = "80A095D2CD5C912E5290805C4F2E95A6", hash_generated_method = "72798DE6C2EE435BE2F410D9F7FDFAB2")
    public AlgorithmIdentifier getDigestAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1147100694 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1147100694 = digestAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1147100694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1147100694;
        // ---------- Original Method ----------
        //return digestAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.059 -0400", hash_original_method = "591AAD603948030260B8B2B98E27FE31", hash_generated_method = "ADFC53C5896EA48A330FEA618AA6B8A3")
    public DERBitString getObjectDigest() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1816801516 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1816801516 = objectDigest;
        varB4EAC82CA7396A68D541C85D26508E83_1816801516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1816801516;
        // ---------- Original Method ----------
        //return objectDigest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.059 -0400", hash_original_method = "2916DBD20BE914B0B076A9BFA9563581", hash_generated_method = "C983746A30ADB94989E4E62159283785")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_749061655 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(digestedObjectType);
        {
            v.add(otherObjectTypeID);
        } //End block
        v.add(digestAlgorithm);
        v.add(objectDigest);
        varB4EAC82CA7396A68D541C85D26508E83_749061655 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_749061655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_749061655;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.059 -0400", hash_original_field = "752F38030C2CA3C1E0739EB6D0FC76D7", hash_generated_field = "BF5C05C05CEF80A8322320530D7E74F5")

    public final static int publicKey = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.059 -0400", hash_original_field = "4A31A9953191C61E9EB9240C1B2548FC", hash_generated_field = "1D343F3859B75D9882E9DA17F4BBF575")

    public final static int publicKeyCert = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.060 -0400", hash_original_field = "510EA9022C6F3C0451A31F12813E0EF7", hash_generated_field = "425AF1E78D83F4CF88C7FADF880769E7")

    public final static int otherObjectDigest = 2;
}

