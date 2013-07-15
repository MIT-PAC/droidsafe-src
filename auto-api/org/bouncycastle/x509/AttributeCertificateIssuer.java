package org.bouncycastle.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AttCertIssuer;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.V2Form;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Selector;

public class AttributeCertificateIssuer implements CertSelector, Selector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.488 -0400", hash_original_field = "3FCDB73D36D54F2CC22D0F68E6B6E182", hash_generated_field = "F472E80F733CDF00E48AF589322F06BE")

    ASN1Encodable form;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.488 -0400", hash_original_method = "BBF050FF37EED8F05F0CD887F679CFE4", hash_generated_method = "8F764C03AD36B828C9A7285A3E1B5206")
    public  AttributeCertificateIssuer(AttCertIssuer issuer) {
        form = issuer.getIssuer();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.488 -0400", hash_original_method = "D6A3C71D8C78168F005DD976BB9D460A", hash_generated_method = "C24B960C0D07622B82E720E4F5D99D83")
    public  AttributeCertificateIssuer(X500Principal principal) throws IOException {
        this(new X509Principal(principal.getEncoded()));
        addTaint(principal.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.489 -0400", hash_original_method = "6459F0ACD6C2225742DF42C099A35AAF", hash_generated_method = "3C855DCA6BE989638579F74FEA16CA18")
    public  AttributeCertificateIssuer(X509Principal principal) {
        form = new V2Form(new GeneralNames(new DERSequence(new GeneralName(principal))));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.489 -0400", hash_original_method = "E1F244CC3C2F69A383C3B6A34635861B", hash_generated_method = "83A6FB2AFC6557CEC4A8A0048D253345")
    private Object[] getNames() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_281383708 = null; 
        GeneralNames name;
        {
            name = ((V2Form)form).getIssuerName();
        } 
        {
            name = (GeneralNames)form;
        } 
        GeneralName[] names = name.getNames();
        List l = new ArrayList(names.length);
        {
            int i = 0;
            {
                {
                    boolean var6E81B5710B8121FC654755546F549F39_1739375981 = (names[i].getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            l.add(new X500Principal(
                        ((ASN1Encodable)names[i].getName()).getEncoded()));
                        } 
                        catch (IOException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("badly formed Name object");
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_281383708 = l.toArray(new Object[l.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_281383708.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_281383708;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.490 -0400", hash_original_method = "3DFD2537FFB449B5321668C577E5D216", hash_generated_method = "DE9D5597BB208102F207D7245F49BBC1")
    public Principal[] getPrincipals() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1877775953 = null; 
        Object[] p = this.getNames();
        List l = new ArrayList();
        {
            int i = 0;
            {
                {
                    l.add(p[i]);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1877775953 = (Principal[])l.toArray(new Principal[l.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1877775953.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1877775953;
        
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.491 -0400", hash_original_method = "DB608757031C3F022268BBCAE1434BBE", hash_generated_method = "364BAE1F1F36D12C3A4FC80A2FA4173D")
    private boolean matchesDN(X500Principal subject, GeneralNames targets) {
        GeneralName[] names = targets.getNames();
        {
            int i = 0;
            {
                GeneralName gn = names[i];
                {
                    boolean varA8A9F7FA995044FDF9256505CA308CC1_1489382452 = (gn.getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            {
                                boolean var80109587AFBD92D225629C2436B16574_297701250 = (new X500Principal(((ASN1Encodable)gn.getName()).getEncoded()).equals(subject));
                            } 
                        } 
                        catch (IOException e)
                        { }
                    } 
                } 
            } 
        } 
        addTaint(subject.getTaint());
        addTaint(targets.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008043557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008043557;
        
        
        
        
            
            
            
                
                
                    
                    
                        
                    
                
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.492 -0400", hash_original_method = "3AF2A857F3C742FB55D3884093F02C4D", hash_generated_method = "BC5DF134EDC00F6201E23CBC0E139FC9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_111250835 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_111250835 = new AttributeCertificateIssuer(AttCertIssuer.getInstance(form));
        varB4EAC82CA7396A68D541C85D26508E83_111250835.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_111250835;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.493 -0400", hash_original_method = "743F0CF49EF8F89EFC9B72FE9124B1C1", hash_generated_method = "D321508834B4A8DBBD2FBCF85A8F7453")
    public boolean match(Certificate cert) {
        X509Certificate x509Cert = (X509Certificate)cert;
        {
            V2Form issuer = (V2Form)form;
            {
                boolean var85D386E7F16F3F6A5CAD98FFAB46A17C_1373995923 = (issuer.getBaseCertificateID() != null);
                {
                    boolean var6081E98808D58A01B24386A62506A60D_722796272 = (issuer.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(x509Cert.getIssuerX500Principal(), issuer.getBaseCertificateID().getIssuer()));
                } 
            } 
            GeneralNames name = issuer.getIssuerName();
            {
                boolean varFBB2EAF0E5FF1FCF6F8C2CAE5B84969C_735622508 = (matchesDN(x509Cert.getSubjectX500Principal(), name));
            } 
        } 
        {
            GeneralNames name = (GeneralNames)form;
            {
                boolean varFBB2EAF0E5FF1FCF6F8C2CAE5B84969C_543244755 = (matchesDN(x509Cert.getSubjectX500Principal(), name));
            } 
        } 
        addTaint(cert.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080462212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080462212;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.493 -0400", hash_original_method = "F6888345D31D77DF02A0F426A3C9D5A0", hash_generated_method = "99C9C29A81723546CA905777200D2774")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1872707747 = (obj == this);
        } 
        AttributeCertificateIssuer other = (AttributeCertificateIssuer)obj;
        boolean var74D2ABABE2893C3E81F17C42650E04E7_1173652899 = (this.form.equals(other.form));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1357122836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1357122836;
        
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.494 -0400", hash_original_method = "0B7A1B2982787E7750666F5D71BB8845", hash_generated_method = "7F84551DD775C41BCE9D327862084729")
    public int hashCode() {
        int var4A73454119DFDB88AE7C96BBABF6C856_1521798092 = (this.form.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647864960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_647864960;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.494 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "2F7DF5843EE586A535823AA6A9D61986")
    public boolean match(Object obj) {
        boolean var05F15056D8F2045991D944D9B27E1F9C_348126378 = (match((Certificate)obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512696502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512696502;
        
        
        
            
        
        
    }

    
}

