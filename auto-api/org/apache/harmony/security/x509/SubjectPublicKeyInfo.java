package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private AlgorithmIdentifier algorithmID;
    private byte[] subjectPublicKey;
    private PublicKey publicKey;
    private int unusedBits;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.925 -0400", hash_original_method = "253956FBAD4830165078A1D4A5A10C63", hash_generated_method = "DFADFBA9D1A1B2C280F3873E6AA22D48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubjectPublicKeyInfo(AlgorithmIdentifier algID, byte[] subjectPublicKey) {
        this(algID, subjectPublicKey, 0);
        dsTaint.addTaint(algID.dsTaint);
        dsTaint.addTaint(subjectPublicKey[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.925 -0400", hash_original_method = "D57000139A93CCBF30D6DA3399D9D5D5", hash_generated_method = "070D6889C1301E7D94535F25630E89F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubjectPublicKeyInfo(AlgorithmIdentifier algID, byte[] subjectPublicKey, int unused) {
        this(algID, subjectPublicKey, 0, null);
        dsTaint.addTaint(algID.dsTaint);
        dsTaint.addTaint(subjectPublicKey[0]);
        dsTaint.addTaint(unused);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.925 -0400", hash_original_method = "78E5942A2DBBC7DA4B73868B62747270", hash_generated_method = "799731842DE9D20B1C43571131BEED1F")
    @DSModeled(DSC.SAFE)
    private SubjectPublicKeyInfo(AlgorithmIdentifier algID,
                                 byte[] subjectPublicKey, int unused,
                                 byte[] encoding) {
        dsTaint.addTaint(algID.dsTaint);
        dsTaint.addTaint(subjectPublicKey[0]);
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(unused);
        // ---------- Original Method ----------
        //this.algorithmID = algID;
        //this.subjectPublicKey = subjectPublicKey;
        //this.unusedBits = unused;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.925 -0400", hash_original_method = "D3585B3653154AD3FE820FC3C464AD5E", hash_generated_method = "20A717370F06DE2EAE6E9AFBD41205B3")
    @DSModeled(DSC.SAFE)
    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return (AlgorithmIdentifier)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return algorithmID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.925 -0400", hash_original_method = "6DD3F56EFCD8D5575183C0DEA4BCE90C", hash_generated_method = "4AAD602FF9D28AB46488339835F8BA14")
    @DSModeled(DSC.SAFE)
    public byte[] getSubjectPublicKey() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return subjectPublicKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.926 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.926 -0400", hash_original_method = "FA31FAEA1A381D04C25B0BE6D665660B", hash_generated_method = "83788718D12820DFD7C60C3355A57649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PublicKey getPublicKey() {
        {
            String alg_oid;
            alg_oid = algorithmID.getAlgorithm();
            try 
            {
                String alg;
                alg = AlgNameMapper.map2AlgName(alg_oid);
                {
                    alg = alg_oid;
                } //End block
                publicKey = KeyFactory.getInstance(alg)
                    .generatePublic(new X509EncodedKeySpec(getEncoded()));
            } //End block
            catch (InvalidKeySpecException ignored)
            { }
            catch (NoSuchAlgorithmException ignored)
            { }
            {
                publicKey = new X509PublicKey(alg_oid, getEncoded(),
                        subjectPublicKey);
            } //End block
        } //End block
        return (PublicKey)dsTaint.getTaint();
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

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            AlgorithmIdentifier.ASN1, ASN1BitString.getInstance() }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.926 -0400", hash_original_method = "FD8EB31EDCB420BB285954F02E88B28A", hash_generated_method = "BF53F1B8883AD6E1C06BCB4A60BE0E95")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object varDD5775E3CDEA988CD2D50257A3F04524_779123750 = (new SubjectPublicKeyInfo(
                    (AlgorithmIdentifier) values[0],
                    ((BitString) values[1]).bytes,
                    ((BitString) values[1]).unusedBits,
                    in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new SubjectPublicKeyInfo(
                    //(AlgorithmIdentifier) values[0],
                    //((BitString) values[1]).bytes,
                    //((BitString) values[1]).unusedBits,
                    //in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.927 -0400", hash_original_method = "FDCC5514DD513A693728A41D76C4BE17", hash_generated_method = "F668CDC54600DD85A73569168CD4ED9C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            SubjectPublicKeyInfo spki;
            spki = (SubjectPublicKeyInfo) object;
            values[0] = spki.algorithmID;
            values[1] = new BitString(spki.subjectPublicKey, spki.unusedBits);
            // ---------- Original Method ----------
            //SubjectPublicKeyInfo spki = (SubjectPublicKeyInfo) object;
            //values[0] = spki.algorithmID;
            //values[1] = new BitString(spki.subjectPublicKey, spki.unusedBits);
        }

        
}; //Transformed anonymous class
}

