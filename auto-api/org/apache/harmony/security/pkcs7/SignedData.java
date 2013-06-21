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
    private int version;
    private List<?> digestAlgorithms;
    private ContentInfo contentInfo;
    private List<Certificate> certificates;
    private List<CertificateList> crls;
    private List<SignerInfo> signerInfos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.176 -0400", hash_original_method = "86716568313110DB160A45E25CDB2037", hash_generated_method = "4D87AA160E66ECE0211D5BC51FCED5C3")
    @DSModeled(DSC.SAFE)
    private SignedData(int version, List<?> digestAlgorithms, ContentInfo contentInfo,
            List<Certificate> certificates, List<CertificateList> crls,
            List<SignerInfo> signerInfos) {
        dsTaint.addTaint(contentInfo.dsTaint);
        dsTaint.addTaint(crls.dsTaint);
        dsTaint.addTaint(digestAlgorithms.dsTaint);
        dsTaint.addTaint(signerInfos.dsTaint);
        dsTaint.addTaint(certificates.dsTaint);
        dsTaint.addTaint(version);
        // ---------- Original Method ----------
        //this.version = version;
        //this.digestAlgorithms = digestAlgorithms;
        //this.contentInfo = contentInfo;
        //this.certificates = certificates;
        //this.crls = crls;
        //this.signerInfos = signerInfos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.177 -0400", hash_original_method = "1A3C998CB17E3A8C920AD81B84D716FA", hash_generated_method = "F51547A2C94F4D2FF38B3EF6ABD0C7CF")
    @DSModeled(DSC.SAFE)
    public List<Certificate> getCertificates() {
        return (List<Certificate>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return certificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.177 -0400", hash_original_method = "3C90A6221E72080B8CAD1325BD108F88", hash_generated_method = "D066F66D7B9A66F41F0504A37CA753A3")
    @DSModeled(DSC.SAFE)
    public List<CertificateList> getCRLs() {
        return (List<CertificateList>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return crls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.177 -0400", hash_original_method = "4845FE90A50A204EC6BC5DCC20DC666F", hash_generated_method = "D62F3A21C99AD7FDFD8DFBB226F00E70")
    @DSModeled(DSC.SAFE)
    public List<SignerInfo> getSignerInfos() {
        return (List<SignerInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return signerInfos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.177 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0E228D4E97C578C96F5A709D7390E3F7")
    @DSModeled(DSC.SAFE)
    public int getVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.178 -0400", hash_original_method = "39B5111592E9C9F7E25B09890D35A8D3", hash_generated_method = "D167186D58D716EAA3852FB1CBA83035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var3F7A63C0290A7D59CE78DF2F46EB4AAE_131878834 = (res.toString());
        return dsTaint.getTaintString();
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

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(),
            new ASN1SetOf(AlgorithmIdentifier.ASN1),
            ContentInfo.ASN1,
            new ASN1Implicit(0, new ASN1SetOf(Certificate.ASN1)),
            new ASN1Implicit(1, new ASN1SetOf(CertificateList.ASN1)),
            new ASN1SetOf(SignerInfo.ASN1)
            }) {        {
            setOptional(3); 
            setOptional(4); 
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.179 -0400", hash_original_method = "4AF6B822CF0192F42AAC6B52E7B50875", hash_generated_method = "A7CC82D9B37AC15876F3496D8593F821")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            SignedData sd;
            sd = (SignedData) object;
            values[0] = new byte[] {(byte)sd.version};
            values[1] = sd.digestAlgorithms;
            values[2] = sd.contentInfo;
            values[3] = sd.certificates;
            values[4] = sd.crls;
            values[5] = sd.signerInfos;
            // ---------- Original Method ----------
            //SignedData sd = (SignedData) object;
            //values[0] = new byte[] {(byte)sd.version};
            //values[1] = sd.digestAlgorithms;
            //values[2] = sd.contentInfo;
            //values[3] = sd.certificates;
            //values[4] = sd.crls;
            //values[5] = sd.signerInfos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.180 -0400", hash_original_method = "EAF9E9892E8B4A07D2257D3D67BC0D9F", hash_generated_method = "B7C4EB6CC9C62F457B8035132D747160")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var61F48B272537623BB27DDC577196FF04_920882492 = (new SignedData(
                        ASN1Integer.toIntValue(values[0]),
                        (List<?>) values[1],
                        (ContentInfo) values[2],
                        (List<Certificate>) values[3],
                        (List<CertificateList>) values[4],
                        (List<SignerInfo>) values[5]
                    ));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new SignedData(
                        //ASN1Integer.toIntValue(values[0]),
                        //(List<?>) values[1],
                        //(ContentInfo) values[2],
                        //(List<Certificate>) values[3],
                        //(List<CertificateList>) values[4],
                        //(List<SignerInfo>) values[5]
                    //);
        }

        
}; //Transformed anonymous class
}

