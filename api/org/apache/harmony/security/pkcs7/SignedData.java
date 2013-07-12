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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.126 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.126 -0400", hash_original_field = "C695788DA0067E56F21C4D4787A45BF6", hash_generated_field = "24EB4DE16B60219F5B4B1A4A8853A314")

    private List<?> digestAlgorithms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.126 -0400", hash_original_field = "A3E2FE12F47E74149FD3DEA1E9CED58E", hash_generated_field = "AE3F5213A506E923E6FE7BDB355D2265")

    private ContentInfo contentInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.126 -0400", hash_original_field = "3CC41D0F46073BA8D93EA9DB2412437F", hash_generated_field = "35B56F34A6EFCC0A8EBE1E2BF1E1853A")

    private List<Certificate> certificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.126 -0400", hash_original_field = "3DC1AE7D16A32AC445EE6E6D730742A4", hash_generated_field = "CF1C0D364AFC27B6CEFE4E39A3F0DAA8")

    private List<CertificateList> crls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.126 -0400", hash_original_field = "D3475CD0C6A552244FFC3E64D91D5A88", hash_generated_field = "28723D91F47C17A811E3E22E9132A9AF")

    private List<SignerInfo> signerInfos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.128 -0400", hash_original_method = "86716568313110DB160A45E25CDB2037", hash_generated_method = "A7163F81F2CB05006B0F1E02C351C027")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.128 -0400", hash_original_method = "1A3C998CB17E3A8C920AD81B84D716FA", hash_generated_method = "AEF10E3A1578B9923E48A97481329B98")
    public List<Certificate> getCertificates() {
List<Certificate> varD990E2E05C44BAB0ED4D7DA357BC9641_1111347277 =         certificates;
        varD990E2E05C44BAB0ED4D7DA357BC9641_1111347277.addTaint(taint);
        return varD990E2E05C44BAB0ED4D7DA357BC9641_1111347277;
        // ---------- Original Method ----------
        //return certificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.128 -0400", hash_original_method = "3C90A6221E72080B8CAD1325BD108F88", hash_generated_method = "07931AB975D4174B4B2210E7ECE5968B")
    public List<CertificateList> getCRLs() {
List<CertificateList> var2E0E0B1D9DF9C775250CA6863C9BD42A_1369666574 =         crls;
        var2E0E0B1D9DF9C775250CA6863C9BD42A_1369666574.addTaint(taint);
        return var2E0E0B1D9DF9C775250CA6863C9BD42A_1369666574;
        // ---------- Original Method ----------
        //return crls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.128 -0400", hash_original_method = "4845FE90A50A204EC6BC5DCC20DC666F", hash_generated_method = "C6696F190E2AE30DE65E8C928B4C1E9F")
    public List<SignerInfo> getSignerInfos() {
List<SignerInfo> var7B0F5615FE64201092B96D782E134CD6_2001901246 =         signerInfos;
        var7B0F5615FE64201092B96D782E134CD6_2001901246.addTaint(taint);
        return var7B0F5615FE64201092B96D782E134CD6_2001901246;
        // ---------- Original Method ----------
        //return signerInfos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.129 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "C775DB713C5F736EB10EC46CBDCCFA37")
    public int getVersion() {
        int var2AF72F100C356273D46284F6FD1DFC08_1372719458 = (version);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740710577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740710577;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.129 -0400", hash_original_method = "39B5111592E9C9F7E25B09890D35A8D3", hash_generated_method = "55A0B2268ED591B9A2DF075638008F9C")
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
String varEC7EB75EF3C7FA633C54FC66A0358174_751078197 =         res.toString();
        varEC7EB75EF3C7FA633C54FC66A0358174_751078197.addTaint(taint);
        return varEC7EB75EF3C7FA633C54FC66A0358174_751078197;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.129 -0400", hash_original_field = "66AD73A95F936B6DD0CB325A6F75C006", hash_generated_field = "7C30870EFF5611301CC32AE0B5790DCF")

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

