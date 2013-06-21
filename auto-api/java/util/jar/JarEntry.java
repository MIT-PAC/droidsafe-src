package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.CodeSigner;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import javax.security.auth.x500.X500Principal;

public class JarEntry extends ZipEntry {
    private Attributes attributes;
    JarFile parentJar;
    CodeSigner signers[];
    private CertificateFactory factory;
    private boolean isFactoryChecked = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.325 -0400", hash_original_method = "AEA0BF7FF3634BE004E609E393DDAC13", hash_generated_method = "2A9AA7E13CEB9220AF008D421A8CDF36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarEntry(String name) {
        super(name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.325 -0400", hash_original_method = "506E89BB6203E00495B453235D9825F2", hash_generated_method = "E8EAA04B87AA39061DEC6890B041CD06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarEntry(ZipEntry entry) {
        super(entry);
        dsTaint.addTaint(entry.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.325 -0400", hash_original_method = "AA77415E9035EF2C32FB40C3C659C5A8", hash_generated_method = "981C9AC29173AADC20159905D6ED08B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public JarEntry(JarEntry je) {
        super(je);
        dsTaint.addTaint(je.dsTaint);
        parentJar = je.parentJar;
        attributes = je.attributes;
        signers = je.signers;
        // ---------- Original Method ----------
        //parentJar = je.parentJar;
        //attributes = je.attributes;
        //signers = je.signers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.326 -0400", hash_original_method = "8B6D7741BEFEF015D0439F90F97A5465", hash_generated_method = "ACABA3E32C18287276AC3E313D7996E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attributes getAttributes() throws IOException {
        Manifest manifest;
        manifest = parentJar.getManifest();
        Attributes var364C947974B7DF6B4D5F89483F9F6BAF_51814040 = (attributes = manifest.getAttributes(getName()));
        return (Attributes)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (attributes != null || parentJar == null) {
            //return attributes;
        //}
        //Manifest manifest = parentJar.getManifest();
        //if (manifest == null) {
            //return null;
        //}
        //return attributes = manifest.getAttributes(getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.326 -0400", hash_original_method = "3CE58A412B40810ECA641FDC022C6998", hash_generated_method = "6D3A57BAC96DFDBBF53A086F715350EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Certificate[] getCertificates() {
        JarVerifier jarVerifier;
        jarVerifier = parentJar.verifier;
        Certificate[] var46BE39C749D6257F3A1AF79E0807FCCF_358907088 = (jarVerifier.getCertificates(getName()));
        return (Certificate[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (parentJar == null) {
            //return null;
        //}
        //JarVerifier jarVerifier = parentJar.verifier;
        //if (jarVerifier == null) {
            //return null;
        //}
        //return jarVerifier.getCertificates(getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.326 -0400", hash_original_method = "DAF50D69E39A2A8F586C4ACAC36673DD", hash_generated_method = "96240E72B2F3B9AACFF60095D9ACBDB3")
    @DSModeled(DSC.SAFE)
     void setAttributes(Attributes attrib) {
        dsTaint.addTaint(attrib.dsTaint);
        // ---------- Original Method ----------
        //attributes = attrib;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.326 -0400", hash_original_method = "AC53E883AD9D8ECF5D160A6258BB3798", hash_generated_method = "FD69136332BC266DD9685427E5910C2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CodeSigner[] getCodeSigners() {
        {
            signers = getCodeSigners(getCertificates());
        } //End block
        CodeSigner[] tmp;
        tmp = new CodeSigner[signers.length];
        System.arraycopy(signers, 0, tmp, 0, tmp.length);
        return (CodeSigner[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (signers == null) {
            //signers = getCodeSigners(getCertificates());
        //}
        //if (signers == null) {
            //return null;
        //}
        //CodeSigner[] tmp = new CodeSigner[signers.length];
        //System.arraycopy(signers, 0, tmp, 0, tmp.length);
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.331 -0400", hash_original_method = "3B125BDC3FCBCE7977A58F597174AB72", hash_generated_method = "76E666D0411CDF497A38E8FE7B570695")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CodeSigner[] getCodeSigners(Certificate[] certs) {
        dsTaint.addTaint(certs[0].dsTaint);
        X500Principal prevIssuer;
        prevIssuer = null;
        ArrayList<Certificate> list;
        list = new ArrayList<Certificate>(certs.length);
        ArrayList<CodeSigner> asigners;
        asigners = new ArrayList<CodeSigner>();
        {
            Certificate element = certs[0];
            {
                X509Certificate x509;
                x509 = (X509Certificate) element;
                {
                    X500Principal subj;
                    subj = x509.getSubjectX500Principal();
                    {
                        boolean var443FE31389A264BD2D1ABC6CE6C29DCD_694890102 = (!prevIssuer.equals(subj));
                        {
                            addCodeSigner(asigners, list);
                            list.clear();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                prevIssuer = x509.getIssuerX500Principal();
                list.add(x509);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5E5AA647E3562849B3BEAAC2D9F07249_208133109 = (!list.isEmpty());
            {
                addCodeSigner(asigners, list);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var82604B50DE04A430CD629E3A547123FD_665383546 = (asigners.isEmpty());
        } //End collapsed parenthetic
        CodeSigner[] tmp;
        tmp = new CodeSigner[asigners.size()];
        asigners.toArray(tmp);
        return (CodeSigner[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.332 -0400", hash_original_method = "E5BFF52E3E0C861E597B700E67310005", hash_generated_method = "CCCF7F5E26A4E138FE91D09CB7642440")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addCodeSigner(ArrayList<CodeSigner> asigners,
            List<Certificate> list) {
        dsTaint.addTaint(list.dsTaint);
        dsTaint.addTaint(asigners.dsTaint);
        CertPath certPath;
        certPath = null;
        {
            try 
            {
                factory = CertificateFactory.getInstance("X.509");
            } //End block
            catch (CertificateException ex)
            { }
            finally 
            {
                isFactoryChecked = true;
            } //End block
        } //End block
        try 
        {
            certPath = factory.generateCertPath(list);
        } //End block
        catch (CertificateException ex)
        { }
        {
            asigners.add(new CodeSigner(certPath, null));
        } //End block
        // ---------- Original Method ----------
        //CertPath certPath = null;
        //if (!isFactoryChecked) {
            //try {
                //factory = CertificateFactory.getInstance("X.509");
            //} catch (CertificateException ex) {
            //} finally {
                //isFactoryChecked = true;
            //}
        //}
        //if (factory == null) {
            //return;
        //}
        //try {
            //certPath = factory.generateCertPath(list);
        //} catch (CertificateException ex) {
        //}
        //if (certPath != null) {
            //asigners.add(new CodeSigner(certPath, null));
        //}
    }

    
}

