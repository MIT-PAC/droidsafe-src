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

public final class Certificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.725 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "9248E33E3F77CE913BD8C48F1C53B58B")

    private TBSCertificate tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.725 -0400", hash_original_field = "0C3D482A41621822B95C4386FD1F1FC2", hash_generated_field = "4CC78CEDF5C854EC0CED71E47BBFC813")

    private AlgorithmIdentifier signatureAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.725 -0400", hash_original_field = "A83E026224A6F552557EF9C7ABF67D37", hash_generated_field = "9AB01BF01A2AD28FB638C6788268D049")

    private byte[] signatureValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.725 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.726 -0400", hash_original_method = "36888DF2201C733781C462219C862A19", hash_generated_method = "81C885C148B3C16180728AD93FDD6FDA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.727 -0400", hash_original_method = "B77628638E378AC1094C2F162FBF82C6", hash_generated_method = "D80EEAF44C2D99307EC0712A02DD9BAA")
    private  Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertificate, signatureAlgorithm, signatureValue);
        addTaint(signatureValue[0]);
        addTaint(signatureAlgorithm.getTaint());
        addTaint(tbsCertificate.getTaint());
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.727 -0400", hash_original_method = "FF2C12E3D498720C4C6A280928F0E345", hash_generated_method = "302F2B894EE6F2488E9D086F40059DAB")
    public TBSCertificate getTbsCertificate() {
TBSCertificate var1857F9BA3F27C149AD964AF4EA223803_563352471 =         tbsCertificate;
        var1857F9BA3F27C149AD964AF4EA223803_563352471.addTaint(taint);
        return var1857F9BA3F27C149AD964AF4EA223803_563352471;
        // ---------- Original Method ----------
        //return tbsCertificate;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.727 -0400", hash_original_method = "8722C62E4FA981F57078A28963CBFC5B", hash_generated_method = "238F50C45B458510F0CDF673432AA32F")
    public byte[] getSignatureValue() {
        byte[] varB5FB8CAD04B397AF118846FC12B421DC_1761925505 = (signatureValue.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_143567972 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_143567972;
        // ---------- Original Method ----------
        //return signatureValue.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.728 -0400", hash_original_method = "AB851A8A0A531CFA5FA89690A5B67B6A", hash_generated_method = "5D7BEC20C9646996446D0CB2B791E31D")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("X.509 Certificate:\n[\n");
        tbsCertificate.dumpValue(result);
        result.append("\n  Algorithm: [");
        signatureAlgorithm.dumpValue(result);
        result.append(']');
        result.append("\n  Signature Value:\n");
        result.append(Array.toString(signatureValue, ""));
        result.append(']');
String varE65B3A02759122992CB82C0E651AD408_676307960 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_676307960.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_676307960;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.728 -0400", hash_original_method = "40E68AC9D0BBD7DBB7B922A2DC357EC3", hash_generated_method = "FEA4137395A42777D7B63D2696AEA9B1")
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = Certificate.ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_811763806 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_585276303 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_585276303;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = Certificate.ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.728 -0400", hash_original_field = "8339CCCD344A2DCCCDFE1DAEDAF1FA1B", hash_generated_field = "23BC4A8E936707952E42A4866427E16B")

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

