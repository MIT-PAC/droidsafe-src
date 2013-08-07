package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.121 -0400", hash_original_field = "529531AC18F1767CC4E852E2E88FE44C", hash_generated_field = "95301D0D3F3C5138CAEBA2A55EAA03B8")

    private AlgorithmIdentifier hashAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.121 -0400", hash_original_field = "8F8089894469D184D1303E92DEB5452F", hash_generated_field = "0C0676B8B1B2CA29200010C6CDC67E89")

    private AlgorithmIdentifier maskGenAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.121 -0400", hash_original_field = "7E6D50EECC96E4E475B6F03559AC4236", hash_generated_field = "9C0E664FB46E9E951562D3A75558FEEB")

    private DERInteger saltLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.121 -0400", hash_original_field = "3A4430CC349D3B8A1E847B147ACBA301", hash_generated_field = "769A5A4E0765B0187C45E98EA144F1EB")

    private DERInteger trailerField;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.122 -0400", hash_original_method = "E18C025F8AE162B11B2BEFB826A371E0", hash_generated_method = "C5D85E8AEEC1B8922F2BE74806DE4F69")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.124 -0400", hash_original_method = "4E350BBAFE5F6E54301E67F504041AFB", hash_generated_method = "1D5CE60D3A372CE46C06DE77C379CB49")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.125 -0400", hash_original_method = "BFA6C4C69768336B001E015A810FDA00", hash_generated_method = "AE5B4868256FDA0D9A15A7139EA64DEC")
    public  RSASSAPSSparams(
        ASN1Sequence seq) {
        addTaint(seq.getTaint());
        hashAlgorithm = DEFAULT_HASH_ALGORITHM;
        maskGenAlgorithm = DEFAULT_MASK_GEN_FUNCTION;
        saltLength = DEFAULT_SALT_LENGTH;
        trailerField = DEFAULT_TRAILER_FIELD;
for(int i = 0;i != seq.size();i++)
        {
            ASN1TaggedObject o = (ASN1TaggedObject)seq.getObjectAt(i);
switch(o.getTagNo()){
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
            IllegalArgumentException var70F80A81529BC32ECB922462EAF3303A_26671209 = new IllegalArgumentException("unknown tag");
            var70F80A81529BC32ECB922462EAF3303A_26671209.addTaint(taint);
            throw var70F80A81529BC32ECB922462EAF3303A_26671209;
}
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.126 -0400", hash_original_method = "987E7AACB66963F632D7C499003CC870", hash_generated_method = "C453F4A69C3505ADE0DBCCA3353934B1")
    public AlgorithmIdentifier getHashAlgorithm() {
AlgorithmIdentifier varF85DDCD03B4CF10D8B09A6ADFA8421BD_1444057145 =         hashAlgorithm;
        varF85DDCD03B4CF10D8B09A6ADFA8421BD_1444057145.addTaint(taint);
        return varF85DDCD03B4CF10D8B09A6ADFA8421BD_1444057145;
        // ---------- Original Method ----------
        //return hashAlgorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.126 -0400", hash_original_method = "299D9F86E5DBB3444D94BB106A959A17", hash_generated_method = "5666C21009900DEC03A26699096919FF")
    public AlgorithmIdentifier getMaskGenAlgorithm() {
AlgorithmIdentifier var50B0CBAD1CBE25CFB7A74F2139ECC5EC_1875462461 =         maskGenAlgorithm;
        var50B0CBAD1CBE25CFB7A74F2139ECC5EC_1875462461.addTaint(taint);
        return var50B0CBAD1CBE25CFB7A74F2139ECC5EC_1875462461;
        // ---------- Original Method ----------
        //return maskGenAlgorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.127 -0400", hash_original_method = "DDACDA0D7B5CB6E5558758D456678E3E", hash_generated_method = "14BEECAFB52C3D366F50162E17A5DBAA")
    public DERInteger getSaltLength() {
DERInteger varA393991B281E94FBC9FB108ABD1E1E46_262882431 =         saltLength;
        varA393991B281E94FBC9FB108ABD1E1E46_262882431.addTaint(taint);
        return varA393991B281E94FBC9FB108ABD1E1E46_262882431;
        // ---------- Original Method ----------
        //return saltLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.127 -0400", hash_original_method = "EA52051AAE4EFBA3513689CA3A308153", hash_generated_method = "2AA2D07255B1A571DE911AD6AF6EFAA8")
    public DERInteger getTrailerField() {
DERInteger var3B01E18491BDB360626EFB4A43588DCD_1917691414 =         trailerField;
        var3B01E18491BDB360626EFB4A43588DCD_1917691414.addTaint(taint);
        return var3B01E18491BDB360626EFB4A43588DCD_1917691414;
        // ---------- Original Method ----------
        //return trailerField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.127 -0400", hash_original_method = "AB78784B82028E9E5C0DF1201C6494F4", hash_generated_method = "98CAF10B815FE34AEE0EC3FB71DF0EBA")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        if(!hashAlgorithm.equals(DEFAULT_HASH_ALGORITHM))        
        {
            v.add(new DERTaggedObject(true, 0, hashAlgorithm));
        } //End block
        if(!maskGenAlgorithm.equals(DEFAULT_MASK_GEN_FUNCTION))        
        {
            v.add(new DERTaggedObject(true, 1, maskGenAlgorithm));
        } //End block
        if(!saltLength.equals(DEFAULT_SALT_LENGTH))        
        {
            v.add(new DERTaggedObject(true, 2, saltLength));
        } //End block
        if(!trailerField.equals(DEFAULT_TRAILER_FIELD))        
        {
            v.add(new DERTaggedObject(true, 3, trailerField));
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_256969782 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_256969782.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_256969782;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.128 -0400", hash_original_field = "C6C0648ED8BEFF7AFD228084A5ADB506", hash_generated_field = "434EBB65C0C41171ED51AF5ADD48A634")

    public final static AlgorithmIdentifier DEFAULT_HASH_ALGORITHM = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.128 -0400", hash_original_field = "377975444239160819799587C73C35B0", hash_generated_field = "DC818269C4BD48CE915130CD0F4F1A91")

    public final static AlgorithmIdentifier DEFAULT_MASK_GEN_FUNCTION = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, DEFAULT_HASH_ALGORITHM);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.128 -0400", hash_original_field = "901C2DBEBF97CCD1216599821DB25015", hash_generated_field = "7F4E8BEA6A8A9C93C7CC070DF70544F5")

    public final static DERInteger          DEFAULT_SALT_LENGTH = new DERInteger(20);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.128 -0400", hash_original_field = "9020AD957CEDED7F6A2272A9751C8F69", hash_generated_field = "13E516D387FE6AB8B1042BC8F9BFB8F9")

    public final static DERInteger          DEFAULT_TRAILER_FIELD = new DERInteger(1);
}

