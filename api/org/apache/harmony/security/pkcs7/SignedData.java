package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x509.AlgorithmIdentifier;
import org.apache.harmony.security.x509.Certificate;
import org.apache.harmony.security.x509.CertificateList;

public final class SignedData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.080 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.080 -0400", hash_original_field = "C695788DA0067E56F21C4D4787A45BF6", hash_generated_field = "24EB4DE16B60219F5B4B1A4A8853A314")

    private List<?> digestAlgorithms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.080 -0400", hash_original_field = "A3E2FE12F47E74149FD3DEA1E9CED58E", hash_generated_field = "AE3F5213A506E923E6FE7BDB355D2265")

    private ContentInfo contentInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.080 -0400", hash_original_field = "3CC41D0F46073BA8D93EA9DB2412437F", hash_generated_field = "35B56F34A6EFCC0A8EBE1E2BF1E1853A")

    private List<Certificate> certificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.081 -0400", hash_original_field = "3DC1AE7D16A32AC445EE6E6D730742A4", hash_generated_field = "CF1C0D364AFC27B6CEFE4E39A3F0DAA8")

    private List<CertificateList> crls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.081 -0400", hash_original_field = "D3475CD0C6A552244FFC3E64D91D5A88", hash_generated_field = "28723D91F47C17A811E3E22E9132A9AF")

    private List<SignerInfo> signerInfos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.082 -0400", hash_original_method = "86716568313110DB160A45E25CDB2037", hash_generated_method = "A7163F81F2CB05006B0F1E02C351C027")
    private  SignedData(int version, List<?> digestAlgorithms, ContentInfo contentInfo,
            List<Certificate> certificates, List<CertificateList> crls,
            List<SignerInfo> signerInfos) {
        this.version = version;
        this.digestAlgorithms = digestAlgorithms;
        this.contentInfo = contentInfo;
        this.certificates = certificates;
        this.crls = crls;
        this.signerInfos = signerInfos;
        // ---------- Original Method ----------
        //this.version = version;
        //this.digestAlgorithms = digestAlgorithms;
        //this.contentInfo = contentInfo;
        //this.certificates = certificates;
        //this.crls = crls;
        //this.signerInfos = signerInfos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.083 -0400", hash_original_method = "1A3C998CB17E3A8C920AD81B84D716FA", hash_generated_method = "FE16CB99B6F962B666ECC0B85EED73EE")
    public List<Certificate> getCertificates() {
List<Certificate> varD990E2E05C44BAB0ED4D7DA357BC9641_599342651 =         certificates;
        varD990E2E05C44BAB0ED4D7DA357BC9641_599342651.addTaint(taint);
        return varD990E2E05C44BAB0ED4D7DA357BC9641_599342651;
        // ---------- Original Method ----------
        //return certificates;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.083 -0400", hash_original_method = "3C90A6221E72080B8CAD1325BD108F88", hash_generated_method = "2F21BAF43BA200964A1DFE7E3394033B")
    public List<CertificateList> getCRLs() {
List<CertificateList> var2E0E0B1D9DF9C775250CA6863C9BD42A_9321736 =         crls;
        var2E0E0B1D9DF9C775250CA6863C9BD42A_9321736.addTaint(taint);
        return var2E0E0B1D9DF9C775250CA6863C9BD42A_9321736;
        // ---------- Original Method ----------
        //return crls;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.084 -0400", hash_original_method = "4845FE90A50A204EC6BC5DCC20DC666F", hash_generated_method = "2D3C306830A4926D6B8AD7CE4BE5D371")
    public List<SignerInfo> getSignerInfos() {
List<SignerInfo> var7B0F5615FE64201092B96D782E134CD6_1749819000 =         signerInfos;
        var7B0F5615FE64201092B96D782E134CD6_1749819000.addTaint(taint);
        return var7B0F5615FE64201092B96D782E134CD6_1749819000;
        // ---------- Original Method ----------
        //return signerInfos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.084 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "1ADD661C9F22BD5462641C16BAD00C28")
    public int getVersion() {
        int var2AF72F100C356273D46284F6FD1DFC08_2122886808 = (version);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109317764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109317764;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.085 -0400", hash_original_method = "39B5111592E9C9F7E25B09890D35A8D3", hash_generated_method = "4D98D2D84A6E1DBC6D08AF597ADA110C")
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("---- SignedData:");
        res.append("\nversion: ");
        res.append(version);
        res.append("\ndigestAlgorithms: ");
        res.append(digestAlgorithms.toString());
        res.append("\ncontentInfo: ");
        res.append(contentInfo.toString());
        res.append("\ncertificates: ");
        if(certificates != null)        
        {
            res.append(certificates.toString());
        } //End block
        res.append("\ncrls: ");
        if(crls != null)        
        {
            res.append(crls.toString());
        } //End block
        res.append("\nsignerInfos:\n");
        res.append(signerInfos.toString());
        res.append("\n---- SignedData End\n]");
String varEC7EB75EF3C7FA633C54FC66A0358174_1686436304 =         res.toString();
        varEC7EB75EF3C7FA633C54FC66A0358174_1686436304.addTaint(taint);
        return varEC7EB75EF3C7FA633C54FC66A0358174_1686436304;
        // ---------- Original Method ----------
        //StringBuilder res = new StringBuilder();
        //res.append("---- SignedData:");
        //res.append("\nversion: ");
        //res.append(version);
        //res.append("\ndigestAlgorithms: ");
        //res.append(digestAlgorithms.toString());
        //res.append("\ncontentInfo: ");
        //res.append(contentInfo.toString());
        //res.append("\ncertificates: ");
        //if (certificates != null) {
            //res.append(certificates.toString());
        //}
        //res.append("\ncrls: ");
        //if (crls != null) {
            //res.append(crls.toString());
        //}
        //res.append("\nsignerInfos:\n");
        //res.append(signerInfos.toString());
        //res.append("\n---- SignedData End\n]");
        //return res.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.085 -0400", hash_original_field = "66AD73A95F936B6DD0CB325A6F75C006", hash_generated_field = "7C30870EFF5611301CC32AE0B5790DCF")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(),
            new ASN1SetOf(AlgorithmIdentifier.ASN1),
            ContentInfo.ASN1,
            new ASN1Implicit(0, new ASN1SetOf(Certificate.ASN1)),
            new ASN1Implicit(1, new ASN1SetOf(CertificateList.ASN1)),
            new ASN1SetOf(SignerInfo.ASN1)
            }) {
        {
            setOptional(3); 
            setOptional(4); 
        }

        @Override protected void getValues(Object object, Object[] values) {
            SignedData sd = (SignedData) object;
            values[0] = new byte[] {(byte)sd.version};
            values[1] = sd.digestAlgorithms;
            values[2] = sd.contentInfo;
            values[3] = sd.certificates;
            values[4] = sd.crls;
            values[5] = sd.signerInfos;
        }

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new SignedData(
                        ASN1Integer.toIntValue(values[0]),
                        (List<?>) values[1],
                        (ContentInfo) values[2],
                        (List<Certificate>) values[3],
                        (List<CertificateList>) values[4],
                        (List<SignerInfo>) values[5]
                    );
        }
    };
}

