package org.bouncycastle.asn1.pkcs;

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
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class RSASSAPSSparams extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.593 -0400", hash_original_field = "529531AC18F1767CC4E852E2E88FE44C", hash_generated_field = "95301D0D3F3C5138CAEBA2A55EAA03B8")

    private AlgorithmIdentifier hashAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.594 -0400", hash_original_field = "8F8089894469D184D1303E92DEB5452F", hash_generated_field = "0C0676B8B1B2CA29200010C6CDC67E89")

    private AlgorithmIdentifier maskGenAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.594 -0400", hash_original_field = "7E6D50EECC96E4E475B6F03559AC4236", hash_generated_field = "9C0E664FB46E9E951562D3A75558FEEB")

    private DERInteger saltLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.594 -0400", hash_original_field = "3A4430CC349D3B8A1E847B147ACBA301", hash_generated_field = "769A5A4E0765B0187C45E98EA144F1EB")

    private DERInteger trailerField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.594 -0400", hash_original_method = "E18C025F8AE162B11B2BEFB826A371E0", hash_generated_method = "C5D85E8AEEC1B8922F2BE74806DE4F69")
    public  RSASSAPSSparams() {
        hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        saltLength = DEFAULT_SALT_LENGTH;
        trailerField = DEFAULT_TRAILER_FIELD;
        // ---------- Original Method ----------
        //hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        //maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        //saltLength = DEFAULT_SALT_LENGTH;
        //trailerField = DEFAULT_TRAILER_FIELD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.602 -0400", hash_original_method = "4E350BBAFE5F6E54301E67F504041AFB", hash_generated_method = "1D5CE60D3A372CE46C06DE77C379CB49")
    public  RSASSAPSSparams(
        AlgorithmIdentifier hashAlgorithm,
        AlgorithmIdentifier maskGenAlgorithm,
        DERInteger          saltLength,
        DERInteger          trailerField) {
        this.hashAlgorithm = hashAlgorithm;
        this.maskGenAlgorithm = maskGenAlgorithm;
        this.saltLength = saltLength;
        this.trailerField = trailerField;
        // ---------- Original Method ----------
        //this.hashAlgorithm = hashAlgorithm;
        //this.maskGenAlgorithm = maskGenAlgorithm;
        //this.saltLength = saltLength;
        //this.trailerField = trailerField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.603 -0400", hash_original_method = "BFA6C4C69768336B001E015A810FDA00", hash_generated_method = "93E23451A91A1F838CF6D6AD6F06092B")
    public  RSASSAPSSparams(
        ASN1Sequence seq) {
        hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        saltLength = DEFAULT_SALT_LENGTH;
        trailerField = DEFAULT_TRAILER_FIELD;
        {
            int i;
            i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_1294108746 = (i != seq.size());
            {
                ASN1TaggedObject o;
                o = (ASN1TaggedObject)seq.getObjectAt(i);
                {
                    Object var969449A70EDB6FB54C5B842143D30B18_39474107 = (o.getTagNo());
                    //Begin case 0 
                    hashAlgorithm = AlgorithmIdentifier.getInstance(o, true);
                    //End case 0 
                    //Begin case 1 
                    maskGenAlgorithm = AlgorithmIdentifier.getInstance(o, true);
                    //End case 1 
                    //Begin case 2 
                    saltLength = DERInteger.getInstance(o, true);
                    //End case 2 
                    //Begin case 3 
                    trailerField = DERInteger.getInstance(o, true);
                    //End case 3 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown tag");
                    //End case default 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.610 -0400", hash_original_method = "987E7AACB66963F632D7C499003CC870", hash_generated_method = "C9D89BEBB8F5D7D8481E626393F9E556")
    public AlgorithmIdentifier getHashAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1087284314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1087284314 = hashAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1087284314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1087284314;
        // ---------- Original Method ----------
        //return hashAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.610 -0400", hash_original_method = "299D9F86E5DBB3444D94BB106A959A17", hash_generated_method = "67F551174C23782EF2B7887219916C7C")
    public AlgorithmIdentifier getMaskGenAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1847007506 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1847007506 = maskGenAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1847007506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847007506;
        // ---------- Original Method ----------
        //return maskGenAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.611 -0400", hash_original_method = "DDACDA0D7B5CB6E5558758D456678E3E", hash_generated_method = "306CA30C5B0797DCB8F1016F6116A195")
    public DERInteger getSaltLength() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1438910950 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1438910950 = saltLength;
        varB4EAC82CA7396A68D541C85D26508E83_1438910950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1438910950;
        // ---------- Original Method ----------
        //return saltLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.612 -0400", hash_original_method = "EA52051AAE4EFBA3513689CA3A308153", hash_generated_method = "73512C4D133EF2F6DD3F564D5CAAE74A")
    public DERInteger getTrailerField() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_1223155671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1223155671 = trailerField;
        varB4EAC82CA7396A68D541C85D26508E83_1223155671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1223155671;
        // ---------- Original Method ----------
        //return trailerField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.621 -0400", hash_original_method = "AB78784B82028E9E5C0DF1201C6494F4", hash_generated_method = "D143002349F4C02083A1A1084188CC92")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1514574721 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        {
            boolean varBDA6A933599A074F70C6D73A7478ECC9_1222651571 = (!hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM));
            {
                v.add(new DERTaggedObject(true, 0, hashAlgorithm));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB45B7789D7F53616545B2ECDA8899BD4_580312175 = (!maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION));
            {
                v.add(new DERTaggedObject(true, 1, maskGenAlgorithm));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA383131856E4F68C0C020C69E91B712C_162918968 = (!saltLength.equals(DEFAULT_SALT_LENGTH));
            {
                v.add(new DERTaggedObject(true, 2, saltLength));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB529EAD7A03F5793407294891B6CC6B0_784197733 = (!trailerField.equals(DEFAULT_TRAILER_FIELD));
            {
                v.add(new DERTaggedObject(true, 3, trailerField));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1514574721 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1514574721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514574721;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //if (!hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM))
        //{
            //v.add(new DERTaggedObject(true, 0, hashAlgorithm));
        //}
        //if (!maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION))
        //{
            //v.add(new DERTaggedObject(true, 1, maskGenAlgorithm));
        //}
        //if (!saltLength.equals(DEFAULT_SALT_LENGTH))
        //{
            //v.add(new DERTaggedObject(true, 2, saltLength));
        //}
        //if (!trailerField.equals(DEFAULT_TRAILER_FIELD))
        //{
            //v.add(new DERTaggedObject(true, 3, trailerField));
        //}
        //return new DERSequence(v);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.621 -0400", hash_original_field = "C6C0648ED8BEFF7AFD228084A5ADB506", hash_generated_field = "434EBB65C0C41171ED51AF5ADD48A634")

    public final static AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.621 -0400", hash_original_field = "377975444239160819799587C73C35B0", hash_generated_field = "DC818269C4BD48CE915130CD0F4F1A91")

    public final static AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, DEFAULT_HASH_ALGORITHM);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.621 -0400", hash_original_field = "901C2DBEBF97CCD1216599821DB25015", hash_generated_field = "7F4E8BEA6A8A9C93C7CC070DF70544F5")

    public final static DERInteger          DEFAULT_SALT_LENGTH = new DERInteger(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.621 -0400", hash_original_field = "9020AD957CEDED7F6A2272A9751C8F69", hash_generated_field = "13E516D387FE6AB8B1042BC8F9BFB8F9")

    public final static DERInteger          DEFAULT_TRAILER_FIELD = new DERInteger(1);
}

