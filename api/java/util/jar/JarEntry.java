package java.util.jar;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.561 -0500", hash_original_field = "14CC0F9D3F04FE972837D6018D833138", hash_generated_field = "B58329F5904269DD97B6B42BAA3B838E")

    private Attributes attributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.565 -0500", hash_original_field = "E10AC56F726B2514C26051F710368016", hash_generated_field = "E10AC56F726B2514C26051F710368016")

    JarFile parentJar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.569 -0500", hash_original_field = "278E8EAD2807325636A698ADB675DF9F", hash_generated_field = "278E8EAD2807325636A698ADB675DF9F")

    CodeSigner signers[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.573 -0500", hash_original_field = "5ADDC3687C0D2332122E19DFD2FBBE25", hash_generated_field = "5868DDDCE4F3C752A45AD023AADEC2C1")

    private CertificateFactory factory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.576 -0500", hash_original_field = "346F62713CBD19CC8ED42787A40B2075", hash_generated_field = "E4A6C0FA878C2F2F60B68706B8A0D905")

    private boolean isFactoryChecked = false;

    /**
     * Creates a new {@code JarEntry} named name.
     *
     * @param name
     *            The name of the new {@code JarEntry}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.580 -0500", hash_original_method = "AEA0BF7FF3634BE004E609E393DDAC13", hash_generated_method = "8AA59FC24C0EBBA738B0C9EF6B870A0D")
    
public JarEntry(String name) {
        super(name);
    }

    /**
     * Creates a new {@code JarEntry} using the values obtained from entry.
     *
     * @param entry
     *            The ZipEntry to obtain values from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.593 -0500", hash_original_method = "506E89BB6203E00495B453235D9825F2", hash_generated_method = "12B972B2E5039535BB717C01C9A22741")
    
public JarEntry(ZipEntry entry) {
        super(entry);
    }

    /**
     * Create a new {@code JarEntry} using the values obtained from the
     * argument.
     *
     * @param je
     *            The {@code JarEntry} to obtain values from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.605 -0500", hash_original_method = "AA77415E9035EF2C32FB40C3C659C5A8", hash_generated_method = "CCFCB2DB8D256D3162B57F94E65AE071")
    
public JarEntry(JarEntry je) {
        super(je);
        parentJar = je.parentJar;
        attributes = je.attributes;
        signers = je.signers;
    }

    /**
     * Returns the {@code Attributes} object associated with this entry or
     * {@code null} if none exists.
     *
     * @return the {@code Attributes} for this entry.
     * @exception IOException
     *                If an error occurs obtaining the {@code Attributes}.
     * @see Attributes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.596 -0500", hash_original_method = "8B6D7741BEFEF015D0439F90F97A5465", hash_generated_method = "01772515427EE7A6E87F03C886405BA1")
    
public Attributes getAttributes() throws IOException {
        if (attributes != null || parentJar == null) {
            return attributes;
        }
        Manifest manifest = parentJar.getManifest();
        if (manifest == null) {
            return null;
        }
        return attributes = manifest.getAttributes(getName());
    }

    /**
     * Returns an array of {@code Certificate} Objects associated with this
     * entry or {@code null} if none exists. Make sure that the everything is
     * read from the input stream before calling this method, or else the method
     * returns {@code null}.
     *
     * @return the certificate for this entry.
     * @see java.security.cert.Certificate
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.599 -0500", hash_original_method = "3CE58A412B40810ECA641FDC022C6998", hash_generated_method = "D51C318AD9E10263B0A1440BAD94130D")
    
public Certificate[] getCertificates() {
        if (parentJar == null) {
            return null;
        }
        JarVerifier jarVerifier = parentJar.verifier;
        if (jarVerifier == null) {
            return null;
        }
        return jarVerifier.getCertificates(getName());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.602 -0500", hash_original_method = "DAF50D69E39A2A8F586C4ACAC36673DD", hash_generated_method = "DAF50D69E39A2A8F586C4ACAC36673DD")
    
void setAttributes(Attributes attrib) {
        attributes = attrib;
    }

    /**
     * Returns the code signers for the digital signatures associated with the
     * JAR file. If there is no such code signer, it returns {@code null}. Make
     * sure that the everything is read from the input stream before calling
     * this method, or else the method returns {@code null}.
     *
     * @return the code signers for the JAR entry.
     * @see CodeSigner
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.608 -0500", hash_original_method = "AC53E883AD9D8ECF5D160A6258BB3798", hash_generated_method = "A813CC59DD53731C777BD1BABDF3A3DA")
    
public CodeSigner[] getCodeSigners() {
        if (signers == null) {
            signers = getCodeSigners(getCertificates());
        }
        if (signers == null) {
            return null;
        }

        CodeSigner[] tmp = new CodeSigner[signers.length];
        System.arraycopy(signers, 0, tmp, 0, tmp.length);
        return tmp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.611 -0500", hash_original_method = "3B125BDC3FCBCE7977A58F597174AB72", hash_generated_method = "1A48D5118AFBCB71D52D18C8C964E387")
    
private CodeSigner[] getCodeSigners(Certificate[] certs) {
        if (certs == null) {
            return null;
        }

        X500Principal prevIssuer = null;
        ArrayList<Certificate> list = new ArrayList<Certificate>(certs.length);
        ArrayList<CodeSigner> asigners = new ArrayList<CodeSigner>();

        for (Certificate element : certs) {
            if (!(element instanceof X509Certificate)) {
                // Only X509Certificate-s are taken into account - see API spec.
                continue;
            }
            X509Certificate x509 = (X509Certificate) element;
            if (prevIssuer != null) {
                X500Principal subj = x509.getSubjectX500Principal();
                if (!prevIssuer.equals(subj)) {
                    // Ok, this ends the previous chain,
                    // so transform this one into CertPath ...
                    addCodeSigner(asigners, list);
                    // ... and start a new one
                    list.clear();
                }// else { it's still the same chain }

            }
            prevIssuer = x509.getIssuerX500Principal();
            list.add(x509);
        }
        if (!list.isEmpty()) {
            addCodeSigner(asigners, list);
        }
        if (asigners.isEmpty()) {
            // 'signers' is 'null' already
            return null;
        }

        CodeSigner[] tmp = new CodeSigner[asigners.size()];
        asigners.toArray(tmp);
        return tmp;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:56.614 -0500", hash_original_method = "E5BFF52E3E0C861E597B700E67310005", hash_generated_method = "5B2036D63A49C709C779700B21318669")
    
private void addCodeSigner(ArrayList<CodeSigner> asigners,
            List<Certificate> list) {
        CertPath certPath = null;
        if (!isFactoryChecked) {
            try {
                factory = CertificateFactory.getInstance("X.509");
            } catch (CertificateException ex) {
                // do nothing
            } finally {
                isFactoryChecked = true;
            }
        }
        if (factory == null) {
            return;
        }
        try {
            certPath = factory.generateCertPath(list);
        } catch (CertificateException ex) {
            // do nothing
        }
        if (certPath != null) {
            asigners.add(new CodeSigner(certPath, null));
        }
    }
    
}

