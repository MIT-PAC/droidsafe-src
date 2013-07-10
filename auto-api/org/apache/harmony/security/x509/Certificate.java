package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

public final class Certificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.701 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "9248E33E3F77CE913BD8C48F1C53B58B")

    private TBSCertificate tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.701 -0400", hash_original_field = "0C3D482A41621822B95C4386FD1F1FC2", hash_generated_field = "4CC78CEDF5C854EC0CED71E47BBFC813")

    private AlgorithmIdentifier signatureAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.701 -0400", hash_original_field = "A83E026224A6F552557EF9C7ABF67D37", hash_generated_field = "9AB01BF01A2AD28FB638C6788268D049")

    private byte[] signatureValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.701 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.701 -0400", hash_original_method = "36888DF2201C733781C462219C862A19", hash_generated_method = "81C885C148B3C16180728AD93FDD6FDA")
    public  Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue) {
        this.tbsCertificate = tbsCertificate;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, this.signatureValue, 0,
                                                    signatureValue.length);
        
        
        
        
        
                                                    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.702 -0400", hash_original_method = "B77628638E378AC1094C2F162FBF82C6", hash_generated_method = "A9DD32282182E6E2710F90ABD0122AB6")
    private  Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertificate, signatureAlgorithm, signatureValue);
        this.encoding = encoding;
        addTaint(tbsCertificate.getTaint());
        addTaint(signatureAlgorithm.getTaint());
        addTaint(signatureValue[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.702 -0400", hash_original_method = "FF2C12E3D498720C4C6A280928F0E345", hash_generated_method = "A06651FC0689D5034782185952D9C44F")
    public TBSCertificate getTbsCertificate() {
        TBSCertificate varB4EAC82CA7396A68D541C85D26508E83_296734477 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_296734477 = tbsCertificate;
        varB4EAC82CA7396A68D541C85D26508E83_296734477.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_296734477;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.703 -0400", hash_original_method = "8722C62E4FA981F57078A28963CBFC5B", hash_generated_method = "7869767622DC82E8572188313C3E7482")
    public byte[] getSignatureValue() {
        byte[] var5A125AC02AA8E2DE3385FFE660D9090E_1224363853 = (signatureValue.clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1264243800 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1264243800;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.703 -0400", hash_original_method = "AB851A8A0A531CFA5FA89690A5B67B6A", hash_generated_method = "47F03003999A5A1FBED609845913FD10")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_949158102 = null; 
        StringBuilder result = new StringBuilder();
        result.append("X.509 Certificate:\n[\n");
        tbsCertificate.dumpValue(result);
        result.append("\n  Algorithm: [");
        signatureAlgorithm.dumpValue(result);
        result.append(']');
        result.append("\n  Signature Value:\n");
        result.append(Array.toString(signatureValue, ""));
        result.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_949158102 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_949158102.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_949158102;
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.703 -0400", hash_original_method = "40E68AC9D0BBD7DBB7B922A2DC357EC3", hash_generated_method = "52FE063BFF3A72433947EB742A614B0B")
    public byte[] getEncoded() {
        {
            encoding = Certificate.ASN1.encode(this);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_995299383 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_995299383;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.704 -0400", hash_original_field = "8339CCCD344A2DCCCDFE1DAEDAF1FA1B", hash_generated_field = "23BC4A8E936707952E42A4866427E16B")

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

