package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.983 -0400", hash_original_field = "3FCDB73D36D54F2CC22D0F68E6B6E182", hash_generated_field = "F472E80F733CDF00E48AF589322F06BE")

    ASN1Encodable form;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.986 -0400", hash_original_method = "BBF050FF37EED8F05F0CD887F679CFE4", hash_generated_method = "8F764C03AD36B828C9A7285A3E1B5206")
    public  AttributeCertificateIssuer(AttCertIssuer issuer) {
        form = issuer.getIssuer();
        // ---------- Original Method ----------
        //form = issuer.getIssuer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.987 -0400", hash_original_method = "D6A3C71D8C78168F005DD976BB9D460A", hash_generated_method = "C24B960C0D07622B82E720E4F5D99D83")
    public  AttributeCertificateIssuer(X500Principal principal) throws IOException {
        this(new X509Principal(principal.getEncoded()));
        addTaint(principal.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.987 -0400", hash_original_method = "6459F0ACD6C2225742DF42C099A35AAF", hash_generated_method = "3C855DCA6BE989638579F74FEA16CA18")
    public  AttributeCertificateIssuer(X509Principal principal) {
        form = new V2Form(new GeneralNames(new DERSequence(new GeneralName(principal))));
        // ---------- Original Method ----------
        //form = new V2Form(new GeneralNames(new DERSequence(new GeneralName(principal))));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.988 -0400", hash_original_method = "E1F244CC3C2F69A383C3B6A34635861B", hash_generated_method = "23E1670329C773FE17D00DB31BAFF869")
    private Object[] getNames() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1470348383 = null; //Variable for return #1
        GeneralNames name;
        {
            name = ((V2Form)form).getIssuerName();
        } //End block
        {
            name = (GeneralNames)form;
        } //End block
        GeneralName[] names;
        names = name.getNames();
        List l;
        l = new ArrayList(names.length);
        {
            int i;
            i = 0;
            {
                {
                    boolean var6E81B5710B8121FC654755546F549F39_967997133 = (names[i].getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            l.add(new X500Principal(
                        ((ASN1Encodable)names[i].getName()).getEncoded()));
                        } //End block
                        catch (IOException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("badly formed Name object");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1470348383 = l.toArray(new Object[l.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1470348383.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470348383;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.991 -0400", hash_original_method = "3DFD2537FFB449B5321668C577E5D216", hash_generated_method = "50C9764E60D73C77E24BF5330858F0BF")
    public Principal[] getPrincipals() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1500185128 = null; //Variable for return #1
        Object[] p;
        p = this.getNames();
        List l;
        l = new ArrayList();
        {
            int i;
            i = 0;
            {
                {
                    l.add(p[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1500185128 = (Principal[])l.toArray(new Principal[l.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1500185128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1500185128;
        // ---------- Original Method ----------
        //Object[] p = this.getNames();
        //List l = new ArrayList();
        //for (int i = 0; i != p.length; i++)
        //{
            //if (p[i] instanceof Principal)
            //{
                //l.add(p[i]);
            //}
        //}
        //return (Principal[])l.toArray(new Principal[l.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.993 -0400", hash_original_method = "DB608757031C3F022268BBCAE1434BBE", hash_generated_method = "C3567D09773E2EFF592BEEE12A600585")
    private boolean matchesDN(X500Principal subject, GeneralNames targets) {
        GeneralName[] names;
        names = targets.getNames();
        {
            int i;
            i = 0;
            {
                GeneralName gn;
                gn = names[i];
                {
                    boolean varA8A9F7FA995044FDF9256505CA308CC1_350550920 = (gn.getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            {
                                boolean var80109587AFBD92D225629C2436B16574_1099282186 = (new X500Principal(((ASN1Encodable)gn.getName()).getEncoded()).equals(subject));
                            } //End collapsed parenthetic
                        } //End block
                        catch (IOException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(subject.getTaint());
        addTaint(targets.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972756345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972756345;
        // ---------- Original Method ----------
        //GeneralName[] names = targets.getNames();
        //for (int i = 0; i != names.length; i++)
        //{
            //GeneralName gn = names[i];
            //if (gn.getTagNo() == GeneralName.directoryName)
            //{
                //try
                //{
                    //if (new X500Principal(((ASN1Encodable)gn.getName()).getEncoded()).equals(subject))
                    //{
                        //return true;
                    //}
                //}
                //catch (IOException e)
                //{
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.001 -0400", hash_original_method = "3AF2A857F3C742FB55D3884093F02C4D", hash_generated_method = "87D0BE7D5F2E73DC22629D549136CDAD")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1388746445 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1388746445 = new AttributeCertificateIssuer(AttCertIssuer.getInstance(form));
        varB4EAC82CA7396A68D541C85D26508E83_1388746445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388746445;
        // ---------- Original Method ----------
        //return new AttributeCertificateIssuer(AttCertIssuer.getInstance(form));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.001 -0400", hash_original_method = "743F0CF49EF8F89EFC9B72FE9124B1C1", hash_generated_method = "D86FF46C98C2512F3C81D9E6D700650A")
    public boolean match(Certificate cert) {
        X509Certificate x509Cert;
        x509Cert = (X509Certificate)cert;
        {
            V2Form issuer;
            issuer = (V2Form)form;
            {
                boolean var85D386E7F16F3F6A5CAD98FFAB46A17C_733387293 = (issuer.getBaseCertificateID() != null);
                {
                    boolean var6081E98808D58A01B24386A62506A60D_2029257464 = (issuer.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(x509Cert.getIssuerX500Principal(), issuer.getBaseCertificateID().getIssuer()));
                } //End block
            } //End collapsed parenthetic
            GeneralNames name;
            name = issuer.getIssuerName();
            {
                boolean varFBB2EAF0E5FF1FCF6F8C2CAE5B84969C_341960613 = (matchesDN(x509Cert.getSubjectX500Principal(), name));
            } //End collapsed parenthetic
        } //End block
        {
            GeneralNames name;
            name = (GeneralNames)form;
            {
                boolean varFBB2EAF0E5FF1FCF6F8C2CAE5B84969C_1806586510 = (matchesDN(x509Cert.getSubjectX500Principal(), name));
            } //End collapsed parenthetic
        } //End block
        addTaint(cert.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_716130479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_716130479;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.003 -0400", hash_original_method = "F6888345D31D77DF02A0F426A3C9D5A0", hash_generated_method = "561DDC03070B1F00375D6A9A9E678A66")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_838264318 = (obj == this);
        } //End collapsed parenthetic
        AttributeCertificateIssuer other;
        other = (AttributeCertificateIssuer)obj;
        boolean var74D2ABABE2893C3E81F17C42650E04E7_323247499 = (this.form.equals(other.form));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364611014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_364611014;
        // ---------- Original Method ----------
        //if (obj == this)
        //{
            //return true;
        //}
        //if (!(obj instanceof AttributeCertificateIssuer))
        //{
            //return false;
        //}
        //AttributeCertificateIssuer other = (AttributeCertificateIssuer)obj;
        //return this.form.equals(other.form);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.003 -0400", hash_original_method = "0B7A1B2982787E7750666F5D71BB8845", hash_generated_method = "51070312E2757F135558FC7685A9718D")
    public int hashCode() {
        int var4A73454119DFDB88AE7C96BBABF6C856_2090160876 = (this.form.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369542057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369542057;
        // ---------- Original Method ----------
        //return this.form.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.007 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "223435FBE071356EC367165FCE2B14E9")
    public boolean match(Object obj) {
        boolean var05F15056D8F2045991D944D9B27E1F9C_1400408540 = (match((Certificate)obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823671816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823671816;
        // ---------- Original Method ----------
        //if (!(obj instanceof X509Certificate))
        //{
            //return false;
        //}
        //return match((Certificate)obj);
    }

    
}

