package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

public final class CertificateList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.748 -0400", hash_original_field = "434A8DAF2056B5C3BDA6E59178AA316C", hash_generated_field = "77B3A284D6DF0EF4A47E1206333ED0FE")

    private TBSCertList tbsCertList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.748 -0400", hash_original_field = "0C3D482A41621822B95C4386FD1F1FC2", hash_generated_field = "4CC78CEDF5C854EC0CED71E47BBFC813")

    private AlgorithmIdentifier signatureAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.748 -0400", hash_original_field = "A83E026224A6F552557EF9C7ABF67D37", hash_generated_field = "9AB01BF01A2AD28FB638C6788268D049")

    private byte[] signatureValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.748 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.749 -0400", hash_original_method = "08126E4FD8546D7C66517E47FC438E4A", hash_generated_method = "83B6B6743FC51D8D2C6FB4B4C0C94E98")
    public  CertificateList(TBSCertList tbsCertList,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue) {
        this.tbsCertList = tbsCertList;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, this.signatureValue, 0,
                                                    signatureValue.length);
        // ---------- Original Method ----------
        //this.tbsCertList = tbsCertList;
        //this.signatureAlgorithm = signatureAlgorithm;
        //this.signatureValue = new byte[signatureValue.length];
        //System.arraycopy(signatureValue, 0, this.signatureValue, 0,
                                                    //signatureValue.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.749 -0400", hash_original_method = "296A8B306ED3B280093A8F830EEE1E41", hash_generated_method = "17F3BE8A0536D3DD761284DABCBA7EF4")
    private  CertificateList(TBSCertList tbsCertList,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertList, signatureAlgorithm, signatureValue);
        addTaint(signatureValue[0]);
        addTaint(signatureAlgorithm.getTaint());
        addTaint(tbsCertList.getTaint());
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.750 -0400", hash_original_method = "C6096C9759CF7088E874A2A2D3801E56", hash_generated_method = "4582F37393BDDB793DCEB508EABDA3A5")
    public TBSCertList getTbsCertList() {
TBSCertList varF641072E9F7501C501F295828FE4FD8B_2041002438 =         tbsCertList;
        varF641072E9F7501C501F295828FE4FD8B_2041002438.addTaint(taint);
        return varF641072E9F7501C501F295828FE4FD8B_2041002438;
        // ---------- Original Method ----------
        //return tbsCertList;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.750 -0400", hash_original_method = "FD6792B7396143D84E51253527677292", hash_generated_method = "B9732AD77287B8637889313CE620C7AA")
    public byte[] getSignatureValue() {
        byte[] result = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, result, 0, signatureValue.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_964953015 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_263856938 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_263856938;
        // ---------- Original Method ----------
        //byte[] result = new byte[signatureValue.length];
        //System.arraycopy(signatureValue, 0, result, 0, signatureValue.length);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.751 -0400", hash_original_method = "80C69E334C5CE31111385C23EECA9331", hash_generated_method = "12F947220160DAF1208D27265A770607")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        tbsCertList.dumpValue(result);
        result.append("\nSignature Value:\n");
        result.append(Array.toString(signatureValue, ""));
String varE65B3A02759122992CB82C0E651AD408_2001035972 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_2001035972.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_2001035972;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //tbsCertList.dumpValue(result);
        //result.append("\nSignature Value:\n");
        //result.append(Array.toString(signatureValue, ""));
        //return result.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.751 -0400", hash_original_method = "32DCE62651649D85CD3AB4D018999455", hash_generated_method = "7EE7F33058955113CB17583A9DF35404")
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = CertificateList.ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1340675355 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1180505359 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1180505359;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = CertificateList.ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.751 -0400", hash_original_field = "736366582672C5EC0590C01C14D1FD1B", hash_generated_field = "CEEF377160D4527069F2AE9EE6F61908")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[]
                {TBSCertList.ASN1, AlgorithmIdentifier.ASN1,
                    ASN1BitString.getInstance()}) {

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new CertificateList(
                    (TBSCertList) values[0],
                    (AlgorithmIdentifier) values[1],
                    ((BitString) values[2]).bytes, 
                    in.getEncoded()
                    );
        }

        @Override protected void getValues(Object object, Object[] values) {
            CertificateList certificateList = (CertificateList) object;
            values[0] = certificateList.tbsCertList;
            values[1] = certificateList.signatureAlgorithm;
            values[2] = new BitString(certificateList.signatureValue, 0);
        }
    };
}

