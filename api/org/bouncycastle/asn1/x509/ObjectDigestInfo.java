package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.939 -0500", hash_original_method = "2CD790E0C71507799B4BE3E59BBB8EAE", hash_generated_method = "76E77CEA22755578C54A024CD1511B21")
    
public static ObjectDigestInfo getInstance(
        Object obj)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.941 -0500", hash_original_method = "C30465F92FB3CC5205423B414A99B2EF", hash_generated_method = "D8FBC5317DFD01A92182EA8EFCF1B938")
    
public static ObjectDigestInfo getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.922 -0500", hash_original_field = "8B8C4CCF9E91EBB4F2D19105A8AA7CB0", hash_generated_field = "BF5C05C05CEF80A8322320530D7E74F5")

    public final static int publicKey = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.924 -0500", hash_original_field = "48E02432E2649BC46B7B2C4B98F65913", hash_generated_field = "1D343F3859B75D9882E9DA17F4BBF575")

    public final static int publicKeyCert = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.927 -0500", hash_original_field = "50A69D19EBC4880EF4E50D214FE5A93E", hash_generated_field = "425AF1E78D83F4CF88C7FADF880769E7")

    public final static int otherObjectDigest = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.929 -0500", hash_original_field = "1EBFC1EA7BE5FBB19EED6A7F33E7C5E0", hash_generated_field = "1EBFC1EA7BE5FBB19EED6A7F33E7C5E0")

    DEREnumerated digestedObjectType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.932 -0500", hash_original_field = "2E52D7500B72C9A66D7BDA7C325C8111", hash_generated_field = "2E52D7500B72C9A66D7BDA7C325C8111")

    DERObjectIdentifier otherObjectTypeID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.934 -0500", hash_original_field = "CA29728B9069A9E1C4E28C8A9BC0FDFA", hash_generated_field = "CA29728B9069A9E1C4E28C8A9BC0FDFA")

    AlgorithmIdentifier digestAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.936 -0500", hash_original_field = "A8067FEC006B3B31C7D2F37BC96A1A60", hash_generated_field = "A8067FEC006B3B31C7D2F37BC96A1A60")

    DERBitString objectDigest;

    /**
     * Constructor from given details.
     * <p>
     * If <code>digestedObjectType</code> is not {@link #publicKeyCert} or
     * {@link #publicKey} <code>otherObjectTypeID</code> must be given,
     * otherwise it is ignored.
     * 
     * @param digestedObjectType The digest object type.
     * @param otherObjectTypeID The object type ID for
     *            <code>otherObjectDigest</code>.
     * @param digestAlgorithm The algorithm identifier for the hash.
     * @param objectDigest The hash value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.944 -0500", hash_original_method = "2BCF3A62675E792C7E57D418D30ED426", hash_generated_method = "8157C0B61FBFF065CD0538F90871F220")
    
public ObjectDigestInfo(
        int digestedObjectType,
        String otherObjectTypeID,
        AlgorithmIdentifier digestAlgorithm,
        byte[] objectDigest)
    {
        this.digestedObjectType = new DEREnumerated(digestedObjectType);
        if (digestedObjectType == otherObjectDigest)
        {
            this.otherObjectTypeID = new DERObjectIdentifier(otherObjectTypeID);
        }

        this.digestAlgorithm = digestAlgorithm;

        this.objectDigest = new DERBitString(objectDigest);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.947 -0500", hash_original_method = "44BAD3DCA2A27D701ACA3AA084450844", hash_generated_method = "F5795BB3BB754F4FF3944D5CBE349893")
    
private ObjectDigestInfo(
        ASN1Sequence seq)
    {
        if (seq.size() > 4 || seq.size() < 3)
        {
            throw new IllegalArgumentException("Bad sequence size: "
                + seq.size());
        }

        digestedObjectType = DEREnumerated.getInstance(seq.getObjectAt(0));

        int offset = 0;

        if (seq.size() == 4)
        {
            otherObjectTypeID = DERObjectIdentifier.getInstance(seq.getObjectAt(1));
            offset++;
        }

        digestAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1 + offset));

        objectDigest = DERBitString.getInstance(seq.getObjectAt(2 + offset));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.950 -0500", hash_original_method = "6F0ED6AFEE9055594DCEF2A3E1A2F111", hash_generated_method = "781CB81F7C46C75C41831C8A0D93C7E7")
    
public DEREnumerated getDigestedObjectType()
    {
        return digestedObjectType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.952 -0500", hash_original_method = "ED88D29FA12F8D28E30CF15EC0719828", hash_generated_method = "B9EE42F7A2F80539B6C6EDD9B650D93F")
    
public DERObjectIdentifier getOtherObjectTypeID()
    {
        return otherObjectTypeID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.954 -0500", hash_original_method = "80A095D2CD5C912E5290805C4F2E95A6", hash_generated_method = "C94BF258F34342A4A81A6345F3A6D573")
    
public AlgorithmIdentifier getDigestAlgorithm()
    {
        return digestAlgorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.956 -0500", hash_original_method = "591AAD603948030260B8B2B98E27FE31", hash_generated_method = "EC6EAA3EEA1D0EB0F2B844565C08B81E")
    
public DERBitString getObjectDigest()
    {
        return objectDigest;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * 
     * <pre>
     *  
     *    ObjectDigestInfo ::= SEQUENCE {
     *         digestedObjectType  ENUMERATED {
     *                 publicKey            (0),
     *                 publicKeyCert        (1),
     *                 otherObjectTypes     (2) },
     *                         -- otherObjectTypes MUST NOT
     *                         -- be used in this profile
     *         otherObjectTypeID   OBJECT IDENTIFIER OPTIONAL,
     *         digestAlgorithm     AlgorithmIdentifier,
     *         objectDigest        BIT STRING
     *    }
     *   
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.959 -0500", hash_original_method = "2916DBD20BE914B0B076A9BFA9563581", hash_generated_method = "579357A74C4FAE6D9C01A7A74AEF0017")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        v.add(digestedObjectType);

        if (otherObjectTypeID != null)
        {
            v.add(otherObjectTypeID);
        }

        v.add(digestAlgorithm);
        v.add(objectDigest);

        return new DERSequence(v);
    }
}

