package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;






public class AlgorithmIdentifier extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.651 -0500", hash_original_method = "317843A167A77103A4FC2B5E62EBE869", hash_generated_method = "D7BA62414F7F569F2F0A37672DF46AC8")
    
public static AlgorithmIdentifier getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.654 -0500", hash_original_method = "31ACB0BF76FBEDE764C5CF5BD9F2FF59", hash_generated_method = "E165536C5B1A1F2FA269F487DAA6B251")
    
public static AlgorithmIdentifier getInstance(
        Object  obj)
    {
        if (obj== null || obj instanceof AlgorithmIdentifier)
        {
            return (AlgorithmIdentifier)obj;
        }
        
        if (obj instanceof DERObjectIdentifier)
        {
            return new AlgorithmIdentifier((DERObjectIdentifier)obj);
        }

        if (obj instanceof String)
        {
            return new AlgorithmIdentifier((String)obj);
        }

        if (obj instanceof ASN1Sequence)
        {
            return new AlgorithmIdentifier((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.644 -0500", hash_original_field = "76AB6FE87C0FD4F2CC7F03F4D8F80674", hash_generated_field = "75A30ECCFB17A30D42DFB8DB7660AF4A")

    private DERObjectIdentifier objectId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.647 -0500", hash_original_field = "E7745D2C64492C41B0EB9042B613D517", hash_generated_field = "41947DC48C64F495997946BB65CC2C26")

    private DEREncodable        parameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.649 -0500", hash_original_field = "717C680DC462F299787A367CE839116D", hash_generated_field = "6ED074FF68FD154F1B7E3E532F3955CD")

    private boolean             parametersDefined = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.656 -0500", hash_original_method = "93A0883FD6E1F9293F6274682F4F2B4C", hash_generated_method = "744D5390E693C206D670C925CC1DDD52")
    
public AlgorithmIdentifier(
        DERObjectIdentifier     objectId)
    {
        this.objectId = objectId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.659 -0500", hash_original_method = "2C0F45B70A770504C9769255F4669C3E", hash_generated_method = "FFDE1F8EADE0AC742028249674FE9668")
    
public AlgorithmIdentifier(
        String     objectId)
    {
        this.objectId = new DERObjectIdentifier(objectId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.663 -0500", hash_original_method = "3ADDA70B8CE4A49F17EDAA7C48E2C341", hash_generated_method = "DA7F32834DF89F4738DE153A1AF347EE")
    
public AlgorithmIdentifier(
        DERObjectIdentifier     objectId,
        DEREncodable            parameters)
    {
        parametersDefined = true;
        this.objectId = objectId;
        this.parameters = parameters;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.666 -0500", hash_original_method = "DB91F54486D8AF4EDC548543A54F560A", hash_generated_method = "86031D8D6938F4224D785D16D7310395")
    
public AlgorithmIdentifier(
        ASN1Sequence   seq)
    {
        if (seq.size() < 1 || seq.size() > 2)
        {
            throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
        }
        
        objectId = DERObjectIdentifier.getInstance(seq.getObjectAt(0));

        if (seq.size() == 2)
        {
            parametersDefined = true;
            parameters = seq.getObjectAt(1);
        }
        else
        {
            parameters = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.669 -0500", hash_original_method = "CD881EFC58E30EDA4D15D9E8685CDAFE", hash_generated_method = "CDBD609AC5874894244102D86B35EC01")
    
public ASN1ObjectIdentifier getAlgorithm()
    {
        return new ASN1ObjectIdentifier(objectId.getId());
    }

    /**
     * @deprecated use getAlgorithm
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.671 -0500", hash_original_method = "494BC62B0A8F124F83635D3540B715A4", hash_generated_method = "90FE20CECD15FEFB6D1DA4DF7503128D")
    
public DERObjectIdentifier getObjectId()
    {
        return objectId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.673 -0500", hash_original_method = "89C55006FD45E6E61AF55DE1360B9A68", hash_generated_method = "FE797D7AD5D2351D19CF74038FDB2E2D")
    
public DEREncodable getParameters()
    {
        return parameters;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *      AlgorithmIdentifier ::= SEQUENCE {
     *                            algorithm OBJECT IDENTIFIER,
     *                            parameters ANY DEFINED BY algorithm OPTIONAL }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.676 -0500", hash_original_method = "51F3CA499FC5330FCCD6B589EECABC9B", hash_generated_method = "D5CBCE8E5539FF2DA27BF9748BC1839B")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(objectId);

        if (parametersDefined)
        {
            if (parameters != null)
            {
                v.add(parameters);
            }
            else
            {
                v.add(DERNull.INSTANCE);
            }
        }

        return new DERSequence(v);
    }

    
}

