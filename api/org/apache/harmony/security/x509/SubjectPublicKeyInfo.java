package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.AlgNameMapper;

public final class SubjectPublicKeyInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.727 -0400", hash_original_field = "BAD9A1E8834FE6320A309045B8A95343", hash_generated_field = "FD325ED8A60C5BD558CCCC00BB18BE1E")

    private AlgorithmIdentifier algorithmID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.727 -0400", hash_original_field = "00E628E96622093192BC4712D031097F", hash_generated_field = "741B868AD923CC223249852F373451D2")

    private byte[] subjectPublicKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.727 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private PublicKey publicKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.728 -0400", hash_original_field = "0281DE09EFFCE9B1D9513C05E900A565", hash_generated_field = "1C126C29BD87C978D05FA9E071D552A8")

    private int unusedBits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.728 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.728 -0400", hash_original_method = "253956FBAD4830165078A1D4A5A10C63", hash_generated_method = "C639D3F7C8633FBC29F6E0517839AEEF")
    public  SubjectPublicKeyInfo(AlgorithmIdentifier algID, byte[] subjectPublicKey) {
        this(algID, subjectPublicKey, 0);
        addTaint(subjectPublicKey[0]);
        addTaint(algID.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.728 -0400", hash_original_method = "D57000139A93CCBF30D6DA3399D9D5D5", hash_generated_method = "67C903E1D0E2A77FC73DDED86F145E23")
    public  SubjectPublicKeyInfo(AlgorithmIdentifier algID, byte[] subjectPublicKey, int unused) {
        this(algID, subjectPublicKey, 0, null);
        addTaint(unused);
        addTaint(subjectPublicKey[0]);
        addTaint(algID.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.730 -0400", hash_original_method = "78E5942A2DBBC7DA4B73868B62747270", hash_generated_method = "55B3A45EAE77C42BF8DBEEB82A2A5BF7")
    private  SubjectPublicKeyInfo(AlgorithmIdentifier algID,
                                 byte[] subjectPublicKey, int unused,
                                 byte[] encoding) {
        this.algorithmID = algID;
        this.subjectPublicKey = subjectPublicKey;
        this.unusedBits = unused;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.algorithmID = algID;
        //this.subjectPublicKey = subjectPublicKey;
        //this.unusedBits = unused;
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.730 -0400", hash_original_method = "D3585B3653154AD3FE820FC3C464AD5E", hash_generated_method = "8CB184A93F1CF835F0BD0D5055C4D981")
    public AlgorithmIdentifier getAlgorithmIdentifier() {
AlgorithmIdentifier varF690486E77F9AF6CA8AE244E3EF93BFA_439409512 =         algorithmID;
        varF690486E77F9AF6CA8AE244E3EF93BFA_439409512.addTaint(taint);
        return varF690486E77F9AF6CA8AE244E3EF93BFA_439409512;
        // ---------- Original Method ----------
        //return algorithmID;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.731 -0400", hash_original_method = "6DD3F56EFCD8D5575183C0DEA4BCE90C", hash_generated_method = "E013F6F4DD273E02E6BE51B3F65D44C2")
    public byte[] getSubjectPublicKey() {
        byte[] var00E628E96622093192BC4712D031097F_1617573409 = (subjectPublicKey);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_753742286 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_753742286;
        // ---------- Original Method ----------
        //return subjectPublicKey;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.731 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "C907296826B86AAB1608DA04808293C6")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1412337955 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_929704985 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_929704985;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.732 -0400", hash_original_method = "FA31FAEA1A381D04C25B0BE6D665660B", hash_generated_method = "3B282664DAE195E2796F30B367A9BABA")
    public PublicKey getPublicKey() {
        if(publicKey == null)        
        {
            String alg_oid = algorithmID.getAlgorithm();
            try 
            {
                String alg = AlgNameMapper.map2AlgName(alg_oid);
                if(alg == null)                
                {
                    alg = alg_oid;
                } //End block
                publicKey = KeyFactory.getInstance(alg)
                    .generatePublic(new X509EncodedKeySpec(getEncoded()));
            } //End block
            catch (InvalidKeySpecException ignored)
            {
            } //End block
            catch (NoSuchAlgorithmException ignored)
            {
            } //End block
            if(publicKey == null)            
            {
                publicKey = new X509PublicKey(alg_oid, getEncoded(),
                        subjectPublicKey);
            } //End block
        } //End block
PublicKey var36BC502DA0D0F28A150F4A1969DBE960_1727366497 =         publicKey;
        var36BC502DA0D0F28A150F4A1969DBE960_1727366497.addTaint(taint);
        return var36BC502DA0D0F28A150F4A1969DBE960_1727366497;
        // ---------- Original Method ----------
        //if (publicKey == null) {
            //String alg_oid = algorithmID.getAlgorithm();
            //try {
                //String alg =
                    //AlgNameMapper.map2AlgName(alg_oid);
                //if (alg == null) {
                    //alg = alg_oid;
                //}
                //publicKey = KeyFactory.getInstance(alg)
                    //.generatePublic(new X509EncodedKeySpec(getEncoded()));
            //} catch (InvalidKeySpecException ignored) {
            //} catch (NoSuchAlgorithmException ignored) {
            //}
            //if (publicKey == null) {
                //publicKey = new X509PublicKey(alg_oid, getEncoded(),
                        //subjectPublicKey);
            //}
        //}
        //return publicKey;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.732 -0400", hash_original_field = "CC42040DA80C5D943F06D4C9E4EAF6E0", hash_generated_field = "48040307EA293E7C22FF1672E7CE9B9C")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            AlgorithmIdentifier.ASN1, ASN1BitString.getInstance() }) {
        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new SubjectPublicKeyInfo(
                    (AlgorithmIdentifier) values[0],
                    ((BitString) values[1]).bytes,
                    ((BitString) values[1]).unusedBits,
                    in.getEncoded());
        }

        @Override protected void getValues(Object object, Object[] values) {
            SubjectPublicKeyInfo spki = (SubjectPublicKeyInfo) object;
            values[0] = spki.algorithmID;
            values[1] = new BitString(spki.subjectPublicKey, spki.unusedBits);
        }
    };
}

