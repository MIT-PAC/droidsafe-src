package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.067 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "B58329F5904269DD97B6B42BAA3B838E")

    private Attributes attributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.068 -0400", hash_original_field = "4374869048AA58B1433401B9C7F5307B", hash_generated_field = "E10AC56F726B2514C26051F710368016")

    JarFile parentJar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.068 -0400", hash_original_field = "2A9DABFB5877C2D88FB685555751D512", hash_generated_field = "278E8EAD2807325636A698ADB675DF9F")

    CodeSigner signers[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.068 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "5868DDDCE4F3C752A45AD023AADEC2C1")

    private CertificateFactory factory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.068 -0400", hash_original_field = "29120CE52A10C079B8CF1D81CB2DEDF9", hash_generated_field = "E4A6C0FA878C2F2F60B68706B8A0D905")

    private boolean isFactoryChecked = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.068 -0400", hash_original_method = "AEA0BF7FF3634BE004E609E393DDAC13", hash_generated_method = "004F45C4360C33A8418FAF75D7A064C4")
    public  JarEntry(String name) {
        super(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.069 -0400", hash_original_method = "506E89BB6203E00495B453235D9825F2", hash_generated_method = "18A7936E08334675DBAB107536A600CD")
    public  JarEntry(ZipEntry entry) {
        super(entry);
        addTaint(entry.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.069 -0400", hash_original_method = "AA77415E9035EF2C32FB40C3C659C5A8", hash_generated_method = "EDB553C4BAF0AAA25B857AC0FD2A6E2F")
    public  JarEntry(JarEntry je) {
        super(je);
        parentJar = je.parentJar;
        attributes = je.attributes;
        signers = je.signers;
        // ---------- Original Method ----------
        //parentJar = je.parentJar;
        //attributes = je.attributes;
        //signers = je.signers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.070 -0400", hash_original_method = "8B6D7741BEFEF015D0439F90F97A5465", hash_generated_method = "99FA186281F81E53BFC1504156B25A17")
    public Attributes getAttributes() throws IOException {
    if(attributes != null || parentJar == null)        
        {
Attributes var4BBC8979DB64A9C3E2328AA1E06CDBB3_1419474156 =             attributes;
            var4BBC8979DB64A9C3E2328AA1E06CDBB3_1419474156.addTaint(taint);
            return var4BBC8979DB64A9C3E2328AA1E06CDBB3_1419474156;
        } //End block
        Manifest manifest = parentJar.getManifest();
    if(manifest == null)        
        {
Attributes var540C13E9E156B687226421B24F2DF178_93679428 =             null;
            var540C13E9E156B687226421B24F2DF178_93679428.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_93679428;
        } //End block
Attributes varEC5B5AF019317A7C65484BE85B3AD11D_2021558255 =         attributes = manifest.getAttributes(getName());
        varEC5B5AF019317A7C65484BE85B3AD11D_2021558255.addTaint(taint);
        return varEC5B5AF019317A7C65484BE85B3AD11D_2021558255;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.070 -0400", hash_original_method = "3CE58A412B40810ECA641FDC022C6998", hash_generated_method = "5A19B3B83CBEA2C94D0649A88B672B8C")
    public Certificate[] getCertificates() {
    if(parentJar == null)        
        {
Certificate[] var540C13E9E156B687226421B24F2DF178_887727380 =             null;
            var540C13E9E156B687226421B24F2DF178_887727380.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_887727380;
        } //End block
        JarVerifier jarVerifier = parentJar.verifier;
    if(jarVerifier == null)        
        {
Certificate[] var540C13E9E156B687226421B24F2DF178_1186562008 =             null;
            var540C13E9E156B687226421B24F2DF178_1186562008.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1186562008;
        } //End block
Certificate[] varD7F6AB131BE738B5E6706A18E82B3D10_217188085 =         jarVerifier.getCertificates(getName());
        varD7F6AB131BE738B5E6706A18E82B3D10_217188085.addTaint(taint);
        return varD7F6AB131BE738B5E6706A18E82B3D10_217188085;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.071 -0400", hash_original_method = "DAF50D69E39A2A8F586C4ACAC36673DD", hash_generated_method = "FDB2887914FAA4104F2D0ED03D0034E5")
     void setAttributes(Attributes attrib) {
        attributes = attrib;
        // ---------- Original Method ----------
        //attributes = attrib;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.071 -0400", hash_original_method = "AC53E883AD9D8ECF5D160A6258BB3798", hash_generated_method = "AD67A2CDB7CAE8C8F87C249686DDD7CA")
    public CodeSigner[] getCodeSigners() {
    if(signers == null)        
        {
            signers = getCodeSigners(getCertificates());
        } //End block
    if(signers == null)        
        {
CodeSigner[] var540C13E9E156B687226421B24F2DF178_883289688 =             null;
            var540C13E9E156B687226421B24F2DF178_883289688.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_883289688;
        } //End block
        CodeSigner[] tmp = new CodeSigner[signers.length];
        System.arraycopy(signers, 0, tmp, 0, tmp.length);
CodeSigner[] var3F12A0424932F6B5155AA6C49B63FE6E_1528799825 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_1528799825.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_1528799825;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.072 -0400", hash_original_method = "3B125BDC3FCBCE7977A58F597174AB72", hash_generated_method = "CECEADE8B9B6F034344F66C3FDF0F540")
    private CodeSigner[] getCodeSigners(Certificate[] certs) {
        addTaint(certs[0].getTaint());
    if(certs == null)        
        {
CodeSigner[] var540C13E9E156B687226421B24F2DF178_1959260804 =             null;
            var540C13E9E156B687226421B24F2DF178_1959260804.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1959260804;
        } //End block
        X500Principal prevIssuer = null;
        ArrayList<Certificate> list = new ArrayList<Certificate>(certs.length);
        ArrayList<CodeSigner> asigners = new ArrayList<CodeSigner>();
for(Certificate element : certs)
        {
    if(!(element instanceof X509Certificate))            
            {
                continue;
            } //End block
            X509Certificate x509 = (X509Certificate) element;
    if(prevIssuer != null)            
            {
                X500Principal subj = x509.getSubjectX500Principal();
    if(!prevIssuer.equals(subj))                
                {
                    addCodeSigner(asigners, list);
                    list.clear();
                } //End block
            } //End block
            prevIssuer = x509.getIssuerX500Principal();
            list.add(x509);
        } //End block
    if(!list.isEmpty())        
        {
            addCodeSigner(asigners, list);
        } //End block
    if(asigners.isEmpty())        
        {
CodeSigner[] var540C13E9E156B687226421B24F2DF178_350637551 =             null;
            var540C13E9E156B687226421B24F2DF178_350637551.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_350637551;
        } //End block
        CodeSigner[] tmp = new CodeSigner[asigners.size()];
        asigners.toArray(tmp);
CodeSigner[] var3F12A0424932F6B5155AA6C49B63FE6E_168649200 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_168649200.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_168649200;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.073 -0400", hash_original_method = "E5BFF52E3E0C861E597B700E67310005", hash_generated_method = "BBE8D0FF01DBAFDFDD4CDE08BFD2261B")
    private void addCodeSigner(ArrayList<CodeSigner> asigners,
            List<Certificate> list) {
        addTaint(list.getTaint());
        addTaint(asigners.getTaint());
        CertPath certPath = null;
    if(!isFactoryChecked)        
        {
            try 
            {
                factory = CertificateFactory.getInstance("X.509");
            } //End block
            catch (CertificateException ex)
            {
            } //End block
            finally 
            {
                isFactoryChecked = true;
            } //End block
        } //End block
    if(factory == null)        
        {
            return;
        } //End block
        try 
        {
            certPath = factory.generateCertPath(list);
        } //End block
        catch (CertificateException ex)
        {
        } //End block
    if(certPath != null)        
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

