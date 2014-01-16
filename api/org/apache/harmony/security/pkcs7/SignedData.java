package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.861 -0500", hash_original_method = "4AF6B822CF0192F42AAC6B52E7B50875", hash_generated_method = "09EA6B4B9B9BE1B3449E861C7CB509E6")
        
@Override protected void getValues(Object object, Object[] values) {
            SignedData sd = (SignedData) object;
            values[0] = new byte[] {(byte)sd.version};
            values[1] = sd.digestAlgorithms;
            values[2] = sd.contentInfo;
            values[3] = sd.certificates;
            values[4] = sd.crls;
            values[5] = sd.signerInfos;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.864 -0500", hash_original_method = "EAF9E9892E8B4A07D2257D3D67BC0D9F", hash_generated_method = "008860324E8B66D3ECC8CA51B1362E90")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.830 -0500", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.833 -0500", hash_original_field = "2B2AC5B6C5C697E3C8B002A0EE153969", hash_generated_field = "24EB4DE16B60219F5B4B1A4A8853A314")

    private  List<?> digestAlgorithms;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.836 -0500", hash_original_field = "D6F1B5D469F54D5CE29E78FCEC158920", hash_generated_field = "AE3F5213A506E923E6FE7BDB355D2265")

    private  ContentInfo contentInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.838 -0500", hash_original_field = "66379239EA65BEB4BF4B138EB0084E10", hash_generated_field = "35B56F34A6EFCC0A8EBE1E2BF1E1853A")

    private  List<Certificate> certificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.840 -0500", hash_original_field = "56E1E4D58FEE1D3E8CF51B94348C4547", hash_generated_field = "CF1C0D364AFC27B6CEFE4E39A3F0DAA8")

    private  List<CertificateList> crls;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.843 -0500", hash_original_field = "29D6C94A840C4A6D4A7A8478DFEDE3ED", hash_generated_field = "28723D91F47C17A811E3E22E9132A9AF")

    private  List<SignerInfo> signerInfos;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.846 -0500", hash_original_method = "86716568313110DB160A45E25CDB2037", hash_generated_method = "6F83AF46B5F5A6D1B05AFAC1C4AD1B3D")
    
private SignedData(int version, List<?> digestAlgorithms, ContentInfo contentInfo,
            List<Certificate> certificates, List<CertificateList> crls,
            List<SignerInfo> signerInfos) {
        this.version = version;
        this.digestAlgorithms = digestAlgorithms;
        this.contentInfo = contentInfo;
        this.certificates = certificates;
        this.crls = crls;
        this.signerInfos = signerInfos;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.848 -0500", hash_original_method = "1A3C998CB17E3A8C920AD81B84D716FA", hash_generated_method = "620FAA7733945E23D5E3EFED777E3A37")
    
public List<Certificate> getCertificates() {
        return certificates;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.850 -0500", hash_original_method = "3C90A6221E72080B8CAD1325BD108F88", hash_generated_method = "5E0DA5D6BCAB96458B82459A8675CC1C")
    
public List<CertificateList> getCRLs() {
        return crls;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.852 -0500", hash_original_method = "4845FE90A50A204EC6BC5DCC20DC666F", hash_generated_method = "D7C0A291242EC943EAED715DA8544CEA")
    
public List<SignerInfo> getSignerInfos() {
        return signerInfos;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.854 -0500", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.857 -0500", hash_original_method = "39B5111592E9C9F7E25B09890D35A8D3", hash_generated_method = "49D08EA134648FEBBFF0C054185A5BA8")
    
@Override public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("---- SignedData:");
        res.append("\nversion: ");
        res.append(version);
        res.append("\ndigestAlgorithms: ");
        res.append(digestAlgorithms.toString());
        res.append("\ncontentInfo: ");
        res.append(contentInfo.toString());
        res.append("\ncertificates: ");
        if (certificates != null) {
            res.append(certificates.toString());
        }
        res.append("\ncrls: ");
        if (crls != null) {
            res.append(crls.toString());
        }
        res.append("\nsignerInfos:\n");
        res.append(signerInfos.toString());
        res.append("\n---- SignedData End\n]");
        return res.toString();
    }
}

