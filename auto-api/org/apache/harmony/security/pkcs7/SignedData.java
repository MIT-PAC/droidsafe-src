package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.795 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.795 -0400", hash_original_field = "C695788DA0067E56F21C4D4787A45BF6", hash_generated_field = "24EB4DE16B60219F5B4B1A4A8853A314")

    private List<?> digestAlgorithms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.795 -0400", hash_original_field = "A3E2FE12F47E74149FD3DEA1E9CED58E", hash_generated_field = "AE3F5213A506E923E6FE7BDB355D2265")

    private ContentInfo contentInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.795 -0400", hash_original_field = "3CC41D0F46073BA8D93EA9DB2412437F", hash_generated_field = "35B56F34A6EFCC0A8EBE1E2BF1E1853A")

    private List<Certificate> certificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.795 -0400", hash_original_field = "3DC1AE7D16A32AC445EE6E6D730742A4", hash_generated_field = "CF1C0D364AFC27B6CEFE4E39A3F0DAA8")

    private List<CertificateList> crls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.795 -0400", hash_original_field = "D3475CD0C6A552244FFC3E64D91D5A88", hash_generated_field = "28723D91F47C17A811E3E22E9132A9AF")

    private List<SignerInfo> signerInfos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.796 -0400", hash_original_method = "86716568313110DB160A45E25CDB2037", hash_generated_method = "A7163F81F2CB05006B0F1E02C351C027")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.796 -0400", hash_original_method = "1A3C998CB17E3A8C920AD81B84D716FA", hash_generated_method = "95C403A1C6BD546BC35798E3E1D9BB0C")
    public List<Certificate> getCertificates() {
        List<Certificate> varB4EAC82CA7396A68D541C85D26508E83_1866780991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1866780991 = certificates;
        varB4EAC82CA7396A68D541C85D26508E83_1866780991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1866780991;
        // ---------- Original Method ----------
        //return certificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.796 -0400", hash_original_method = "3C90A6221E72080B8CAD1325BD108F88", hash_generated_method = "091E3702AE7DDE15CB175E9029AE2392")
    public List<CertificateList> getCRLs() {
        List<CertificateList> varB4EAC82CA7396A68D541C85D26508E83_1106213674 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1106213674 = crls;
        varB4EAC82CA7396A68D541C85D26508E83_1106213674.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1106213674;
        // ---------- Original Method ----------
        //return crls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.806 -0400", hash_original_method = "4845FE90A50A204EC6BC5DCC20DC666F", hash_generated_method = "AAFF12287B37D2B229DC532762DFF655")
    public List<SignerInfo> getSignerInfos() {
        List<SignerInfo> varB4EAC82CA7396A68D541C85D26508E83_859523497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_859523497 = signerInfos;
        varB4EAC82CA7396A68D541C85D26508E83_859523497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_859523497;
        // ---------- Original Method ----------
        //return signerInfos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.806 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "56E5D834E8FD8FE05998F357667923FB")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185952264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185952264;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.807 -0400", hash_original_method = "39B5111592E9C9F7E25B09890D35A8D3", hash_generated_method = "080F4F9C9D25C2E0560F1B03E805F095")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_514432170 = null; //Variable for return #1
        StringBuilder res;
        res = new StringBuilder();
        res.append("---- SignedData:");
        res.append("\nversion: ");
        res.append(version);
        res.append("\ndigestAlgorithms: ");
        res.append(digestAlgorithms.toString());
        res.append("\ncontentInfo: ");
        res.append(contentInfo.toString());
        res.append("\ncertificates: ");
        {
            res.append(certificates.toString());
        } //End block
        res.append("\ncrls: ");
        {
            res.append(crls.toString());
        } //End block
        res.append("\nsignerInfos:\n");
        res.append(signerInfos.toString());
        res.append("\n---- SignedData End\n]");
        varB4EAC82CA7396A68D541C85D26508E83_514432170 = res.toString();
        varB4EAC82CA7396A68D541C85D26508E83_514432170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514432170;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.807 -0400", hash_original_field = "66AD73A95F936B6DD0CB325A6F75C006", hash_generated_field = "7C30870EFF5611301CC32AE0B5790DCF")

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

