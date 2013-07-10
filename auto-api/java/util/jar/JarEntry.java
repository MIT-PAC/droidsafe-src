package java.util.jar;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.038 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "B58329F5904269DD97B6B42BAA3B838E")

    private Attributes attributes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.038 -0400", hash_original_field = "4374869048AA58B1433401B9C7F5307B", hash_generated_field = "E10AC56F726B2514C26051F710368016")

    JarFile parentJar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.039 -0400", hash_original_field = "2A9DABFB5877C2D88FB685555751D512", hash_generated_field = "278E8EAD2807325636A698ADB675DF9F")

    CodeSigner signers[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.039 -0400", hash_original_field = "9549DD6065D019211460C59A86DD6536", hash_generated_field = "5868DDDCE4F3C752A45AD023AADEC2C1")

    private CertificateFactory factory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.039 -0400", hash_original_field = "29120CE52A10C079B8CF1D81CB2DEDF9", hash_generated_field = "E4A6C0FA878C2F2F60B68706B8A0D905")

    private boolean isFactoryChecked = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.039 -0400", hash_original_method = "AEA0BF7FF3634BE004E609E393DDAC13", hash_generated_method = "004F45C4360C33A8418FAF75D7A064C4")
    public  JarEntry(String name) {
        super(name);
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.039 -0400", hash_original_method = "506E89BB6203E00495B453235D9825F2", hash_generated_method = "18A7936E08334675DBAB107536A600CD")
    public  JarEntry(ZipEntry entry) {
        super(entry);
        addTaint(entry.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.039 -0400", hash_original_method = "AA77415E9035EF2C32FB40C3C659C5A8", hash_generated_method = "EDB553C4BAF0AAA25B857AC0FD2A6E2F")
    public  JarEntry(JarEntry je) {
        super(je);
        parentJar = je.parentJar;
        attributes = je.attributes;
        signers = je.signers;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.040 -0400", hash_original_method = "8B6D7741BEFEF015D0439F90F97A5465", hash_generated_method = "84F524C6C364670542FA69B8F22B79F1")
    public Attributes getAttributes() throws IOException {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_2068322921 = null; 
        Attributes varB4EAC82CA7396A68D541C85D26508E83_750731192 = null; 
        Attributes varB4EAC82CA7396A68D541C85D26508E83_1695553883 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2068322921 = attributes;
        } 
        Manifest manifest = parentJar.getManifest();
        {
            varB4EAC82CA7396A68D541C85D26508E83_750731192 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1695553883 = attributes = manifest.getAttributes(getName());
        Attributes varA7E53CE21691AB073D9660D615818899_430224287; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_430224287 = varB4EAC82CA7396A68D541C85D26508E83_2068322921;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_430224287 = varB4EAC82CA7396A68D541C85D26508E83_750731192;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_430224287 = varB4EAC82CA7396A68D541C85D26508E83_1695553883;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_430224287.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_430224287;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.040 -0400", hash_original_method = "3CE58A412B40810ECA641FDC022C6998", hash_generated_method = "7AEC2867165D9FAB7A8271BBF5E7E743")
    public Certificate[] getCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_2018776045 = null; 
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1281555500 = null; 
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_870815610 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2018776045 = null;
        } 
        JarVerifier jarVerifier = parentJar.verifier;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1281555500 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_870815610 = jarVerifier.getCertificates(getName());
        Certificate[] varA7E53CE21691AB073D9660D615818899_1490217182; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1490217182 = varB4EAC82CA7396A68D541C85D26508E83_2018776045;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1490217182 = varB4EAC82CA7396A68D541C85D26508E83_1281555500;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1490217182 = varB4EAC82CA7396A68D541C85D26508E83_870815610;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1490217182.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1490217182;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.041 -0400", hash_original_method = "DAF50D69E39A2A8F586C4ACAC36673DD", hash_generated_method = "FDB2887914FAA4104F2D0ED03D0034E5")
     void setAttributes(Attributes attrib) {
        attributes = attrib;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.041 -0400", hash_original_method = "AC53E883AD9D8ECF5D160A6258BB3798", hash_generated_method = "E0C428A33E9B966047109A7878FB2C50")
    public CodeSigner[] getCodeSigners() {
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_918901429 = null; 
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_1467594303 = null; 
        {
            signers = getCodeSigners(getCertificates());
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_918901429 = null;
        } 
        CodeSigner[] tmp = new CodeSigner[signers.length];
        System.arraycopy(signers, 0, tmp, 0, tmp.length);
        varB4EAC82CA7396A68D541C85D26508E83_1467594303 = tmp;
        CodeSigner[] varA7E53CE21691AB073D9660D615818899_918078447; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_918078447 = varB4EAC82CA7396A68D541C85D26508E83_918901429;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_918078447 = varB4EAC82CA7396A68D541C85D26508E83_1467594303;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_918078447.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_918078447;
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.050 -0400", hash_original_method = "3B125BDC3FCBCE7977A58F597174AB72", hash_generated_method = "2C354A2F402CE2A39B8E7C4EA9B1845A")
    private CodeSigner[] getCodeSigners(Certificate[] certs) {
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_480608007 = null; 
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_46532397 = null; 
        CodeSigner[] varB4EAC82CA7396A68D541C85D26508E83_1251061539 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_480608007 = null;
        } 
        X500Principal prevIssuer = null;
        ArrayList<Certificate> list = new ArrayList<Certificate>(certs.length);
        ArrayList<CodeSigner> asigners = new ArrayList<CodeSigner>();
        {
            Certificate element = certs[0];
            {
                X509Certificate x509 = (X509Certificate) element;
                {
                    X500Principal subj = x509.getSubjectX500Principal();
                    {
                        boolean var443FE31389A264BD2D1ABC6CE6C29DCD_1753876513 = (!prevIssuer.equals(subj));
                        {
                            addCodeSigner(asigners, list);
                            list.clear();
                        } 
                    } 
                } 
                prevIssuer = x509.getIssuerX500Principal();
                list.add(x509);
            } 
        } 
        {
            boolean var5E5AA647E3562849B3BEAAC2D9F07249_308107733 = (!list.isEmpty());
            {
                addCodeSigner(asigners, list);
            } 
        } 
        {
            boolean var82604B50DE04A430CD629E3A547123FD_1744283242 = (asigners.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_46532397 = null;
            } 
        } 
        CodeSigner[] tmp = new CodeSigner[asigners.size()];
        asigners.toArray(tmp);
        varB4EAC82CA7396A68D541C85D26508E83_1251061539 = tmp;
        addTaint(certs[0].getTaint());
        CodeSigner[] varA7E53CE21691AB073D9660D615818899_1902004504; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1902004504 = varB4EAC82CA7396A68D541C85D26508E83_480608007;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1902004504 = varB4EAC82CA7396A68D541C85D26508E83_46532397;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1902004504 = varB4EAC82CA7396A68D541C85D26508E83_1251061539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1902004504.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1902004504;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.051 -0400", hash_original_method = "E5BFF52E3E0C861E597B700E67310005", hash_generated_method = "293B8F0E9D88372891DB2BBA2B64ED65")
    private void addCodeSigner(ArrayList<CodeSigner> asigners,
            List<Certificate> list) {
        CertPath certPath = null;
        {
            try 
            {
                factory = CertificateFactory.getInstance("X.509");
            } 
            catch (CertificateException ex)
            { }
            finally 
            {
                isFactoryChecked = true;
            } 
        } 
        try 
        {
            certPath = factory.generateCertPath(list);
        } 
        catch (CertificateException ex)
        { }
        {
            asigners.add(new CodeSigner(certPath, null));
        } 
        addTaint(asigners.getTaint());
        addTaint(list.getTaint());
        
        
        
            
                
            
            
                
            
        
        
            
        
        
            
        
        
        
            
        
    }

    
}

