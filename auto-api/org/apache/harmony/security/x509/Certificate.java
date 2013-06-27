package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

public final class Certificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.455 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "9248E33E3F77CE913BD8C48F1C53B58B")

    private TBSCertificate tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.455 -0400", hash_original_field = "0C3D482A41621822B95C4386FD1F1FC2", hash_generated_field = "4CC78CEDF5C854EC0CED71E47BBFC813")

    private AlgorithmIdentifier signatureAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.455 -0400", hash_original_field = "A83E026224A6F552557EF9C7ABF67D37", hash_generated_field = "9AB01BF01A2AD28FB638C6788268D049")

    private byte[] signatureValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.455 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.455 -0400", hash_original_method = "36888DF2201C733781C462219C862A19", hash_generated_method = "81C885C148B3C16180728AD93FDD6FDA")
    public  Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue) {
        this.tbsCertificate = tbsCertificate;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, this.signatureValue, 0,
                                                    signatureValue.length);
        // ---------- Original Method ----------
        //this.tbsCertificate = tbsCertificate;
        //this.signatureAlgorithm = signatureAlgorithm;
        //this.signatureValue = new byte[signatureValue.length];
        //System.arraycopy(signatureValue, 0, this.signatureValue, 0,
                                                    //signatureValue.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.456 -0400", hash_original_method = "B77628638E378AC1094C2F162FBF82C6", hash_generated_method = "A9DD32282182E6E2710F90ABD0122AB6")
    private  Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertificate, signatureAlgorithm, signatureValue);
        this.encoding = encoding;
        addTaint(tbsCertificate.getTaint());
        addTaint(signatureAlgorithm.getTaint());
        addTaint(signatureValue[0]);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.477 -0400", hash_original_method = "FF2C12E3D498720C4C6A280928F0E345", hash_generated_method = "3966DB75B417F847E908D3CED175A825")
    public TBSCertificate getTbsCertificate() {
        TBSCertificate varB4EAC82CA7396A68D541C85D26508E83_695165946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_695165946 = tbsCertificate;
        varB4EAC82CA7396A68D541C85D26508E83_695165946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_695165946;
        // ---------- Original Method ----------
        //return tbsCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.477 -0400", hash_original_method = "8722C62E4FA981F57078A28963CBFC5B", hash_generated_method = "2DE0268C30FC60CDC6A042043CE42292")
    public byte[] getSignatureValue() {
        byte[] var5A125AC02AA8E2DE3385FFE660D9090E_300731639 = (signatureValue.clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1601378419 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1601378419;
        // ---------- Original Method ----------
        //return signatureValue.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.478 -0400", hash_original_method = "AB851A8A0A531CFA5FA89690A5B67B6A", hash_generated_method = "2E6487E6E9A1529FEF1B042CA08A28E4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1715108135 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder();
        result.append("X.509 Certificate:\n[\n");
        tbsCertificate.dumpValue(result);
        result.append("\n  Algorithm: [");
        signatureAlgorithm.dumpValue(result);
        result.append(']');
        result.append("\n  Signature Value:\n");
        result.append(Array.toString(signatureValue, ""));
        result.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1715108135 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1715108135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1715108135;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //result.append("X.509 Certificate:\n[\n");
        //tbsCertificate.dumpValue(result);
        //result.append("\n  Algorithm: [");
        //signatureAlgorithm.dumpValue(result);
        //result.append(']');
        //result.append("\n  Signature Value:\n");
        //result.append(Array.toString(signatureValue, ""));
        //result.append(']');
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.478 -0400", hash_original_method = "40E68AC9D0BBD7DBB7B922A2DC357EC3", hash_generated_method = "B7E37276885397AAFDEE28A12573B893")
    public byte[] getEncoded() {
        {
            encoding = Certificate.ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_488969000 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_488969000;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = Certificate.ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.478 -0400", hash_original_field = "8339CCCD344A2DCCCDFE1DAEDAF1FA1B", hash_generated_field = "23BC4A8E936707952E42A4866427E16B")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[]
                {TBSCertificate.ASN1, AlgorithmIdentifier.ASN1, ASN1BitString.getInstance()}) {

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new Certificate(
                    (TBSCertificate) values[0],
                    (AlgorithmIdentifier) values[1],
                    ((BitString) values[2]).bytes, 
                    in.getEncoded());
        }

        @Override protected void getValues(Object object, Object[] values) {
            Certificate cert = (Certificate) object;
            values[0] = cert.tbsCertificate;
            values[1] = cert.signatureAlgorithm;
            values[2] = new BitString(cert.signatureValue, 0);
        }
    };
}

