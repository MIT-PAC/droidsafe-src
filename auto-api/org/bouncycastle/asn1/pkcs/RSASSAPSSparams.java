package org.bouncycastle.asn1.pkcs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.185 -0400", hash_original_field = "529531AC18F1767CC4E852E2E88FE44C", hash_generated_field = "95301D0D3F3C5138CAEBA2A55EAA03B8")

    private AlgorithmIdentifier hashAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.185 -0400", hash_original_field = "8F8089894469D184D1303E92DEB5452F", hash_generated_field = "0C0676B8B1B2CA29200010C6CDC67E89")

    private AlgorithmIdentifier maskGenAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.185 -0400", hash_original_field = "7E6D50EECC96E4E475B6F03559AC4236", hash_generated_field = "9C0E664FB46E9E951562D3A75558FEEB")

    private DERInteger saltLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.185 -0400", hash_original_field = "3A4430CC349D3B8A1E847B147ACBA301", hash_generated_field = "769A5A4E0765B0187C45E98EA144F1EB")

    private DERInteger trailerField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.186 -0400", hash_original_method = "E18C025F8AE162B11B2BEFB826A371E0", hash_generated_method = "C5D85E8AEEC1B8922F2BE74806DE4F69")
    public  RSASSAPSSparams() {
        hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        saltLength = DEFAULT_SALT_LENGTH;
        trailerField = DEFAULT_TRAILER_FIELD;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.186 -0400", hash_original_method = "4E350BBAFE5F6E54301E67F504041AFB", hash_generated_method = "1D5CE60D3A372CE46C06DE77C379CB49")
    public  RSASSAPSSparams(
        AlgorithmIdentifier hashAlgorithm,
        AlgorithmIdentifier maskGenAlgorithm,
        DERInteger          saltLength,
        DERInteger          trailerField) {
        this.hashAlgorithm = hashAlgorithm;
        this.maskGenAlgorithm = maskGenAlgorithm;
        this.saltLength = saltLength;
        this.trailerField = trailerField;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.187 -0400", hash_original_method = "BFA6C4C69768336B001E015A810FDA00", hash_generated_method = "7B7587BF36D2DDAAB3A8A354A8CB2DFD")
    public  RSASSAPSSparams(
        ASN1Sequence seq) {
        hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        saltLength = DEFAULT_SALT_LENGTH;
        trailerField = DEFAULT_TRAILER_FIELD;
        {
            int i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_1885416625 = (i != seq.size());
            {
                ASN1TaggedObject o = (ASN1TaggedObject)seq.getObjectAt(i);
                {
                    Object var969449A70EDB6FB54C5B842143D30B18_1886272544 = (o.getTagNo());
                    
                    hashAlgorithm = AlgorithmIdentifier.getInstance(o, true);
                    
                    
                    maskGenAlgorithm = AlgorithmIdentifier.getInstance(o, true);
                    
                    
                    saltLength = DERInteger.getInstance(o, true);
                    
                    
                    trailerField = DERInteger.getInstance(o, true);
                    
                    
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown tag");
                    
                } 
            } 
        } 
        addTaint(seq.getTaint());
        
        
    }

    
    public static RSASSAPSSparams getInstance(
        Object  obj) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.187 -0400", hash_original_method = "987E7AACB66963F632D7C499003CC870", hash_generated_method = "7E472A3693BBAE32F11690930E57A7B0")
    public AlgorithmIdentifier getHashAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1442401704 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1442401704 = hashAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1442401704.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1442401704;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.188 -0400", hash_original_method = "299D9F86E5DBB3444D94BB106A959A17", hash_generated_method = "CE7E2DB91683BCAB8E3EC58D12C400F4")
    public AlgorithmIdentifier getMaskGenAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_925821948 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_925821948 = maskGenAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_925821948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_925821948;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.188 -0400", hash_original_method = "DDACDA0D7B5CB6E5558758D456678E3E", hash_generated_method = "895252323325DA0DBFE2B4999C8E230A")
    public DERInteger getSaltLength() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_632761408 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_632761408 = saltLength;
        varB4EAC82CA7396A68D541C85D26508E83_632761408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_632761408;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.188 -0400", hash_original_method = "EA52051AAE4EFBA3513689CA3A308153", hash_generated_method = "3538EB9ECDFF3EDEA2361F68CEC440A4")
    public DERInteger getTrailerField() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1575625940 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1575625940 = trailerField;
        varB4EAC82CA7396A68D541C85D26508E83_1575625940.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1575625940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.189 -0400", hash_original_method = "AB78784B82028E9E5C0DF1201C6494F4", hash_generated_method = "DE337B40A861419AB7E44780E009755B")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_268974793 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        {
            boolean varBDA6A933599A074F70C6D73A7478ECC9_1100891025 = (!hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM));
            {
                v.add(new DERTaggedObject(true, 0, hashAlgorithm));
            } 
        } 
        {
            boolean varB45B7789D7F53616545B2ECDA8899BD4_476177674 = (!maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION));
            {
                v.add(new DERTaggedObject(true, 1, maskGenAlgorithm));
            } 
        } 
        {
            boolean varA383131856E4F68C0C020C69E91B712C_456412504 = (!saltLength.equals(DEFAULT_SALT_LENGTH));
            {
                v.add(new DERTaggedObject(true, 2, saltLength));
            } 
        } 
        {
            boolean varB529EAD7A03F5793407294891B6CC6B0_965688607 = (!trailerField.equals(DEFAULT_TRAILER_FIELD));
            {
                v.add(new DERTaggedObject(true, 3, trailerField));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_268974793 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_268974793.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_268974793;
        
        
        
        
            
        
        
        
            
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.189 -0400", hash_original_field = "C6C0648ED8BEFF7AFD228084A5ADB506", hash_generated_field = "434EBB65C0C41171ED51AF5ADD48A634")

    public final static AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.189 -0400", hash_original_field = "377975444239160819799587C73C35B0", hash_generated_field = "DC818269C4BD48CE915130CD0F4F1A91")

    public final static AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, DEFAULT_HASH_ALGORITHM);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.189 -0400", hash_original_field = "901C2DBEBF97CCD1216599821DB25015", hash_generated_field = "7F4E8BEA6A8A9C93C7CC070DF70544F5")

    public final static DERInteger          DEFAULT_SALT_LENGTH = new DERInteger(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.189 -0400", hash_original_field = "9020AD957CEDED7F6A2272A9751C8F69", hash_generated_field = "13E516D387FE6AB8B1042BC8F9BFB8F9")

    public final static DERInteger          DEFAULT_TRAILER_FIELD = new DERInteger(1);
}

