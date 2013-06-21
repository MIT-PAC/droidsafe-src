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

public final class CertificateList {
    private TBSCertList tbsCertList;
    private AlgorithmIdentifier signatureAlgorithm;
    private byte[] signatureValue;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.583 -0400", hash_original_method = "08126E4FD8546D7C66517E47FC438E4A", hash_generated_method = "A95B3A6D84979FC27EBEC881820CDE75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateList(TBSCertList tbsCertList,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue) {
        dsTaint.addTaint(tbsCertList.dsTaint);
        dsTaint.addTaint(signatureAlgorithm.dsTaint);
        dsTaint.addTaint(signatureValue[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.583 -0400", hash_original_method = "296A8B306ED3B280093A8F830EEE1E41", hash_generated_method = "CF1BE6900BB2FC7C6DF2D2BFDD61FE46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CertificateList(TBSCertList tbsCertList,
                       AlgorithmIdentifier signatureAlgorithm,
                       byte[] signatureValue, byte[] encoding) {
        this(tbsCertList, signatureAlgorithm, signatureValue);
        dsTaint.addTaint(tbsCertList.dsTaint);
        dsTaint.addTaint(signatureAlgorithm.dsTaint);
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(signatureValue[0]);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.583 -0400", hash_original_method = "C6096C9759CF7088E874A2A2D3801E56", hash_generated_method = "FAFFEFEF36DCB0008A099C4848BB07CA")
    @DSModeled(DSC.SAFE)
    public TBSCertList getTbsCertList() {
        return (TBSCertList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return tbsCertList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.583 -0400", hash_original_method = "FD6792B7396143D84E51253527677292", hash_generated_method = "6684587C2B930C7D9213E4ABD03144AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getSignatureValue() {
        byte[] result;
        result = new byte[signatureValue.length];
        System.arraycopy(signatureValue, 0, result, 0, signatureValue.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] result = new byte[signatureValue.length];
        //System.arraycopy(signatureValue, 0, result, 0, signatureValue.length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.583 -0400", hash_original_method = "80C69E334C5CE31111385C23EECA9331", hash_generated_method = "ACC119C03F9CC88A38526759D7BDB756")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder();
        tbsCertList.dumpValue(result);
        result.append("\nSignature Value:\n");
        result.append(Array.toString(signatureValue, ""));
        String varEA70154FDA28CC59402440C6317B57EF_1291803331 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //tbsCertList.dumpValue(result);
        //result.append("\nSignature Value:\n");
        //result.append(Array.toString(signatureValue, ""));
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.584 -0400", hash_original_method = "32DCE62651649D85CD3AB4D018999455", hash_generated_method = "D919CD81FAC8A355BC8048EC1E08A86E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = CertificateList.ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = CertificateList.ASN1.encode(this);
        //}
        //return encoding;
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[]
                {TBSCertList.ASN1, AlgorithmIdentifier.ASN1,
                    ASN1BitString.getInstance()}) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.584 -0400", hash_original_method = "AC0862005B3ED7BF3B72B40A50B20B3D", hash_generated_method = "944A2A5A20FFBDF46092571C0DC81DAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object varE173F78A43A0096578F234CEF6080FEF_767177257 = (new CertificateList(
                    (TBSCertList) values[0],
                    (AlgorithmIdentifier) values[1],
                    ((BitString) values[2]).bytes, 
                    in.getEncoded()
                    ));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new CertificateList(
                    //(TBSCertList) values[0],
                    //(AlgorithmIdentifier) values[1],
                    //((BitString) values[2]).bytes, 
                    //in.getEncoded()
                    //);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.584 -0400", hash_original_method = "A02258897C0BA2BA079F5C92BD0C8E9B", hash_generated_method = "1FC38989546D6A757F0DCDC5A39CB861")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            CertificateList certificateList;
            certificateList = (CertificateList) object;
            values[0] = certificateList.tbsCertList;
            values[1] = certificateList.signatureAlgorithm;
            values[2] = new BitString(certificateList.signatureValue, 0);
            // ---------- Original Method ----------
            //CertificateList certificateList = (CertificateList) object;
            //values[0] = certificateList.tbsCertList;
            //values[1] = certificateList.signatureAlgorithm;
            //values[2] = new BitString(certificateList.signatureValue, 0);
        }

        
}; //Transformed anonymous class
}

