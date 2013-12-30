package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;






public class RSASSAPSSparams extends ASN1Encodable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.458 -0500", hash_original_method = "387A0A7ABC761B36BE33A4E0140F6D37", hash_generated_method = "0497DBAAF708A7A444B1E708EBB3C15A")
    
public static RSASSAPSSparams getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof RSASSAPSSparams)
        {
            return (RSASSAPSSparams)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new RSASSAPSSparams((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.448 -0500", hash_original_field = "560133D35B855785418F8F80D1B14C05", hash_generated_field = "434EBB65C0C41171ED51AF5ADD48A634")

    public final static AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.451 -0500", hash_original_field = "DF80E905DD1267F50D33EB30A99951F5", hash_generated_field = "DC818269C4BD48CE915130CD0F4F1A91")

    public final static AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, DEFAULT_HASH_ALGORITHM);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.453 -0500", hash_original_field = "14265EF31362A4736C773C365C16D4F7", hash_generated_field = "7F4E8BEA6A8A9C93C7CC070DF70544F5")

    public final static DERInteger          DEFAULT_SALT_LENGTH = new DERInteger(20);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.456 -0500", hash_original_field = "9E225F5C45970A425D9D2D560658252F", hash_generated_field = "13E516D387FE6AB8B1042BC8F9BFB8F9")

    public final static DERInteger          DEFAULT_TRAILER_FIELD = new DERInteger(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.437 -0500", hash_original_field = "23A3DEEFE615FD4BC9752D149716E84E", hash_generated_field = "95301D0D3F3C5138CAEBA2A55EAA03B8")

    private AlgorithmIdentifier hashAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.440 -0500", hash_original_field = "113BC753B3B8370AB8870A90752372BB", hash_generated_field = "0C0676B8B1B2CA29200010C6CDC67E89")

    private AlgorithmIdentifier maskGenAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.443 -0500", hash_original_field = "EB84E50AF2549718E1E0CA1782EE446E", hash_generated_field = "9C0E664FB46E9E951562D3A75558FEEB")

    private DERInteger          saltLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.445 -0500", hash_original_field = "23138BFF8E8C6389BBBA8359FA5EC22A", hash_generated_field = "769A5A4E0765B0187C45E98EA144F1EB")

    private DERInteger          trailerField;
    
    /**
     * The default version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.461 -0500", hash_original_method = "E18C025F8AE162B11B2BEFB826A371E0", hash_generated_method = "D18BE62B7BD542E701B03C7182DE5FBD")
    
public RSASSAPSSparams()
    {
        hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        saltLength = DEFAULT_SALT_LENGTH;
        trailerField = DEFAULT_TRAILER_FIELD;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.463 -0500", hash_original_method = "4E350BBAFE5F6E54301E67F504041AFB", hash_generated_method = "763B936D2316479B0B2C607FBD35166B")
    
public RSASSAPSSparams(
        AlgorithmIdentifier hashAlgorithm,
        AlgorithmIdentifier maskGenAlgorithm,
        DERInteger          saltLength,
        DERInteger          trailerField)
    {
        this.hashAlgorithm = hashAlgorithm;
        this.maskGenAlgorithm = maskGenAlgorithm;
        this.saltLength = saltLength;
        this.trailerField = trailerField;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.467 -0500", hash_original_method = "BFA6C4C69768336B001E015A810FDA00", hash_generated_method = "6B3DB4D03A24162E848C5871DAF15B01")
    
public RSASSAPSSparams(
        ASN1Sequence seq)
    {
        hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        saltLength = DEFAULT_SALT_LENGTH;
        trailerField = DEFAULT_TRAILER_FIELD;
        
        for (int i = 0; i != seq.size(); i++)
        {
            ASN1TaggedObject    o = (ASN1TaggedObject)seq.getObjectAt(i);
            
            switch (o.getTagNo())
            {
            case 0:
                hashAlgorithm = AlgorithmIdentifier.getInstance(o, true);
                break;
            case 1:
                maskGenAlgorithm = AlgorithmIdentifier.getInstance(o, true);
                break;
            case 2:
                saltLength = DERInteger.getInstance(o, true);
                break;
            case 3:
                trailerField = DERInteger.getInstance(o, true);
                break;
            default:
                throw new IllegalArgumentException("unknown tag");
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.470 -0500", hash_original_method = "987E7AACB66963F632D7C499003CC870", hash_generated_method = "8F793D9FA6C4CC7B61E33FE4FBD641F2")
    
public AlgorithmIdentifier getHashAlgorithm()
    {
        return hashAlgorithm;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.472 -0500", hash_original_method = "299D9F86E5DBB3444D94BB106A959A17", hash_generated_method = "E113445526CC37ADD47C1FE550CEFA79")
    
public AlgorithmIdentifier getMaskGenAlgorithm()
    {
        return maskGenAlgorithm;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.474 -0500", hash_original_method = "DDACDA0D7B5CB6E5558758D456678E3E", hash_generated_method = "0465C1FE50556FF0B69CE1DC3C69D85C")
    
public DERInteger getSaltLength()
    {
        return saltLength;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.477 -0500", hash_original_method = "EA52051AAE4EFBA3513689CA3A308153", hash_generated_method = "B0598A580287076DE12EDBF1FC743817")
    
public DERInteger getTrailerField()
    {
        return trailerField;
    }
    
    /**
     * <pre>
     * RSASSA-PSS-params ::= SEQUENCE {
     *   hashAlgorithm      [0] OAEP-PSSDigestAlgorithms  DEFAULT sha1,
     *    maskGenAlgorithm   [1] PKCS1MGFAlgorithms  DEFAULT mgf1SHA1,
     *    saltLength         [2] INTEGER  DEFAULT 20,
     *    trailerField       [3] TrailerField  DEFAULT trailerFieldBC
     *  }
     *
     * OAEP-PSSDigestAlgorithms    ALGORITHM-IDENTIFIER ::= {
     *    { OID id-sha1 PARAMETERS NULL   }|
     *    { OID id-sha256 PARAMETERS NULL }|
     *    { OID id-sha384 PARAMETERS NULL }|
     *    { OID id-sha512 PARAMETERS NULL },
     *    ...  -- Allows for future expansion --
     * }
     *
     * PKCS1MGFAlgorithms    ALGORITHM-IDENTIFIER ::= {
     *   { OID id-mgf1 PARAMETERS OAEP-PSSDigestAlgorithms },
     *    ...  -- Allows for future expansion --
     * }
     * 
     * TrailerField ::= INTEGER { trailerFieldBC(1) }
     * </pre>
     * @return the asn1 primitive representing the parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:14.480 -0500", hash_original_method = "AB78784B82028E9E5C0DF1201C6494F4", hash_generated_method = "58EB747266E61E41496BE2CD27E9F779")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();
        
        if (!hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM))
        {
            v.add(new DERTaggedObject(true, 0, hashAlgorithm));
        }
        
        if (!maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION))
        {
            v.add(new DERTaggedObject(true, 1, maskGenAlgorithm));
        }
        
        if (!saltLength.equals(DEFAULT_SALT_LENGTH))
        {
            v.add(new DERTaggedObject(true, 2, saltLength));
        }
        
        if (!trailerField.equals(DEFAULT_TRAILER_FIELD))
        {
            v.add(new DERTaggedObject(true, 3, trailerField));
        }
        
        return new DERSequence(v);
    }
}

