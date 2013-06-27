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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.762 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "B58329F5904269DD97B6B42BAA3B838E")

    private Attributes attributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.762 -0400", hash_original_field = "4374869048AA58B1433401B9C7F5307B", hash_generated_field = "E10AC56F726B2514C26051F710368016")

    JarFile parentJar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.762 -0400", hash_original_field = "2A9DABFB5877C2D88FB685555751D512", hash_generated_field = "278E8EAD2807325636A698ADB675DF9F")

    CodeSigner signers[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.762 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "5868DDDCE4F3C752A45AD023AADEC2C1")

    private CertificateFactory factory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.762 -0400", hash_original_field = "29120CE52A10C079B8CF1D81CB2DEDF9", hash_generated_field = "E4A6C0FA878C2F2F60B68706B8A0D905")

    private boolean isFactoryChecked = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.762 -0400", hash_original_method = "AEA0BF7FF3634BE004E609E393DDAC13", hash_generated_method = "004F45C4360C33A8418FAF75D7A064C4")
    public  JarEntry(String name) {
        super(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.763 -0400", hash_original_method = "506E89BB6203E00495B453235D9825F2", hash_generated_method = "18A7936E08334675DBAB107536A600CD")
    public  JarEntry(ZipEntry entry) {
        super(entry);
        addTaint(entry.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.764 -0400", hash_original_method = "AA77415E9035EF2C32FB40C3C659C5A8", hash_generated_method = "EDB553C4BAF0AAA25B857AC0FD2A6E2F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.765 -0400", hash_original_method = "8B6D7741BEFEF015D0439F90F97A5465", hash_generated_method = "2B403D4034BCF9C67A7E0C0FEC92C4E9")
    public Attributes getAttributes() throws IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_1341278814 = null; //Variable for return #1
        Attributes varB4EAC82CA7396A68D541C85D26508E83_825796033 = null; //Variable for return #2
        Attributes varB4EAC82CA7396A68D541C85D26508E83_878886958 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1341278814 = attributes;
        } //End block
        Manifest manifest;
        manifest = parentJar.getManifest();
        {
            varB4EAC82CA7396A68D541C85D26508E83_825796033 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_878886958 = attributes = manifest.getAttributes(getName());
        Attributes varA7E53CE21691AB073D9660D615818899_1894625107; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1894625107 = varB4EAC82CA7396A68D541C85D26508E83_1341278814;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1894625107 = varB4EAC82CA7396A68D541C85D26508E83_825796033;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1894625107 = varB4EAC82CA7396A68D541C85D26508E83_878886958;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1894625107.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1894625107;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.780 -0400", hash_original_method = "3CE58A412B40810ECA641FDC022C6998", hash_generated_method = "F28BD18EE4E3A3FA50C2509A8B8D2B23")
    public Certificate[] getCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1061926371 = null; //Variable for return #1
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_247762267 = null; //Variable for return #2
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1033410253 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1061926371 = null;
        } //End block
        JarVerifier jarVerifier;
        jarVerifier = parentJar.verifier;
        {
            varB4EAC82CA7396A68D541C85D26508E83_247762267 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1033410253 = jarVerifier.getCertificates(getName());
        Certificate[] varA7E53CE21691AB073D9660D615818899_1719860964; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1719860964 = varB4EAC82CA7396A68D541C85D26508E83_1061926371;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1719860964 = varB4EAC82CA7396A68D541C85D26508E83_247762267;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1719860964 = varB4EAC82CA7396A68D541C85D26508E83_1033410253;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1719860964.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1719860964;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.781 -0400", hash_original_method = "DAF50D69E39A2A8F586C4ACAC36673DD", hash_generated_method = "FDB2887914FAA4104F2D0ED03D0034E5")
     void setAttributes(Attributes attrib) {
        attributes = attrib;
        // ---------- Original Method ----------
        //attributes = attrib;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.782 -0400", hash_original_method = "AC53E883AD9D8ECF5D160A6258BB3798", hash_generated_method = "FD5847D48F32B9FF5C2B7F583D3055B4")
    public CodeSigner[] getCodeSigners() {
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_1877151271 = null; //Variable for return #1
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_2053219982 = null; //Variable for return #2
        {
            signers = getCodeSigners(getCertificates());
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1877151271 = null;
        } //End block
        CodeSigner[] tmp;
        tmp = new CodeSigner[signers.length];
        System.arraycopy(signers, 0, tmp, 0, tmp.length);
        varB4EAC82CA7396A68D541C85D26508E83_2053219982 = tmp;
        CodeSigner[] varA7E53CE21691AB073D9660D615818899_1661929866; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1661929866 = varB4EAC82CA7396A68D541C85D26508E83_1877151271;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1661929866 = varB4EAC82CA7396A68D541C85D26508E83_2053219982;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1661929866.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1661929866;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.830 -0400", hash_original_method = "3B125BDC3FCBCE7977A58F597174AB72", hash_generated_method = "FA0D34F193D288CFDA5D7E505EAF05FE")
    private CodeSigner[] getCodeSigners(Certificate[] certs) {
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_1455884686 = null; //Variable for return #1
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_751693625 = null; //Variable for return #2
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_1306557018 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1455884686 = null;
        } //End block
        X500Principal prevIssuer;
        prevIssuer = null;
        ArrayList<Certificate> list;
        list = new ArrayList<Certificate>(certs.length);
        ArrayList<CodeSigner> asigners;
        asigners = new ArrayList<CodeSigner>();
        {
            Iterator<Certificate> varD1313BC228A7A8662D310FF7C4BF885D_1948948141 = (certs).iterator();
            varD1313BC228A7A8662D310FF7C4BF885D_1948948141.hasNext();
            Certificate element = varD1313BC228A7A8662D310FF7C4BF885D_1948948141.next();
            {
                X509Certificate x509;
                x509 = (X509Certificate) element;
                {
                    X500Principal subj;
                    subj = x509.getSubjectX500Principal();
                    {
                        boolean var443FE31389A264BD2D1ABC6CE6C29DCD_1830001131 = (!prevIssuer.equals(subj));
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
            boolean var5E5AA647E3562849B3BEAAC2D9F07249_1496582459 = (!list.isEmpty());
            {
                addCodeSigner(asigners, list);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var82604B50DE04A430CD629E3A547123FD_504394080 = (asigners.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_751693625 = null;
            } //End block
        } //End collapsed parenthetic
        CodeSigner[] tmp;
        tmp = new CodeSigner[asigners.size()];
        asigners.toArray(tmp);
        varB4EAC82CA7396A68D541C85D26508E83_1306557018 = tmp;
        addTaint(certs[0].getTaint());
        CodeSigner[] varA7E53CE21691AB073D9660D615818899_1501032302; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1501032302 = varB4EAC82CA7396A68D541C85D26508E83_1455884686;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1501032302 = varB4EAC82CA7396A68D541C85D26508E83_751693625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1501032302 = varB4EAC82CA7396A68D541C85D26508E83_1306557018;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1501032302.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1501032302;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.842 -0400", hash_original_method = "E5BFF52E3E0C861E597B700E67310005", hash_generated_method = "578780A8E38B289F11224D5CC527F7B9")
    private void addCodeSigner(ArrayList<CodeSigner> asigners,
            List<Certificate> list) {
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
        addTaint(asigners.getTaint());
        addTaint(list.getTaint());
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

