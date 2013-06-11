package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.utils.Array;

public final class Certificate {
    private final TBSCertificate tbsCertificate;
    private final AlgorithmIdentifier signatureAlgorithm;
    private final byte[] signatureValue;
    private byte[] encoding;
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]
                {TBSCertificate.ASN1, AlgorithmIdentifier.ASN1, ASN1BitString.getInstance()}) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "E9A0EBC5EB9E7858903883226F7AD5F5", hash_generated_method = "57C96E825AE7CDCA167AAA821807245C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var50B8D1063C7946032D0D4B5ABFFFA47E_393071554 = (new Certificate(
                    (TBSCertificate) values[0],
                    (AlgorithmIdentifier) values[1],
                    ((BitString) values[2]).bytes, 
                    in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new Certificate(
                    //(TBSCertificate) values[0],
                    //(AlgorithmIdentifier) values[1],
                    //((BitString) values[2]).bytes, 
                    //in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "01876C68B36ED76B36AC389852322C04", hash_generated_method = "4DFDFB6335AD7DAC8D3EBA9BF358FC41")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values.dsTaint);
            dsTaint.addTaint(object.dsTaint);
            Certificate cert;
            cert = (Certificate) object;
            values[0] = cert.tbsCertificate;
            values[1] = cert.signatureAlgorithm;
            values[2] = new BitString(cert.signatureValue, 0);
            // ---------- Original Method ----------
            //Certificate cert = (Certificate) object;
            //values[0] = cert.tbsCertificate;
            //values[1] = cert.signatureAlgorithm;
            //values[2] = new BitString(cert.signatureValue, 0);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "36888DF2201C733781C462219C862A19", hash_generated_method = "C4110741165EDBD6FC643E4ECB6603B6")
    @DSModeled(DSC.SAFE)
    public Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue) {
        dsTaint.addTaint(tbsCertificate.dsTaint);
        dsTaint.addTaint(signatureAlgorithm.dsTaint);
        dsTaint.addTaint(signatureValue);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "B77628638E378AC1094C2F162FBF82C6", hash_generated_method = "D24E5DF9AED6944049670096BE951859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Certificate(TBSCertificate tbsCertificate,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertificate, signatureAlgorithm, signatureValue);
        dsTaint.addTaint(tbsCertificate.dsTaint);
        dsTaint.addTaint(signatureAlgorithm.dsTaint);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(signatureValue);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "FF2C12E3D498720C4C6A280928F0E345", hash_generated_method = "5BE72186C941074D18F1FF6089AEEB7E")
    @DSModeled(DSC.SAFE)
    public TBSCertificate getTbsCertificate() {
        return (TBSCertificate)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return tbsCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "8722C62E4FA981F57078A28963CBFC5B", hash_generated_method = "736FECA9B53234AE94C6EAEFB80846B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getSignatureValue() {
        byte[] var5A125AC02AA8E2DE3385FFE660D9090E_1392630106 = (signatureValue.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return signatureValue.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "AB851A8A0A531CFA5FA89690A5B67B6A", hash_generated_method = "C4A9A9F275EE2E681A20AB4E75403422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String varEA70154FDA28CC59402440C6317B57EF_983895589 = (result.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.866 -0400", hash_original_method = "40E68AC9D0BBD7DBB7B922A2DC357EC3", hash_generated_method = "24D2E2ABB331B73EEE543856D01A73EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = Certificate.ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = Certificate.ASN1.encode(this);
        //}
        //return encoding;
    }

    
}


