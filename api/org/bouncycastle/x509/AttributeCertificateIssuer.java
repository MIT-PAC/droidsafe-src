package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.723 -0400", hash_original_field = "3FCDB73D36D54F2CC22D0F68E6B6E182", hash_generated_field = "F472E80F733CDF00E48AF589322F06BE")

    ASN1Encodable form;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.724 -0400", hash_original_method = "BBF050FF37EED8F05F0CD887F679CFE4", hash_generated_method = "8F764C03AD36B828C9A7285A3E1B5206")
    public  AttributeCertificateIssuer(AttCertIssuer issuer) {
        form = issuer.getIssuer();
        // ---------- Original Method ----------
        //form = issuer.getIssuer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.724 -0400", hash_original_method = "D6A3C71D8C78168F005DD976BB9D460A", hash_generated_method = "C24B960C0D07622B82E720E4F5D99D83")
    public  AttributeCertificateIssuer(X500Principal principal) throws IOException {
        this(new X509Principal(principal.getEncoded()));
        addTaint(principal.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.725 -0400", hash_original_method = "6459F0ACD6C2225742DF42C099A35AAF", hash_generated_method = "3C855DCA6BE989638579F74FEA16CA18")
    public  AttributeCertificateIssuer(X509Principal principal) {
        form = new V2Form(new GeneralNames(new DERSequence(new GeneralName(principal))));
        // ---------- Original Method ----------
        //form = new V2Form(new GeneralNames(new DERSequence(new GeneralName(principal))));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.726 -0400", hash_original_method = "E1F244CC3C2F69A383C3B6A34635861B", hash_generated_method = "4C949B64BEA8E325E67189DAA1E0C5F2")
    private Object[] getNames() {
        GeneralNames name;
    if(form instanceof V2Form)        
        {
            name = ((V2Form)form).getIssuerName();
        } //End block
        else
        {
            name = (GeneralNames)form;
        } //End block
        GeneralName[] names = name.getNames();
        List l = new ArrayList(names.length);
for(int i = 0;i != names.length;i++)
        {
    if(names[i].getTagNo() == GeneralName.directoryName)            
            {
                try 
                {
                    l.add(new X500Principal(
                        ((ASN1Encodable)names[i].getName()).getEncoded()));
                } //End block
                catch (IOException e)
                {
                    RuntimeException var4980AE888B424D26E0A3FAF1A1097229_1069474429 = new RuntimeException("badly formed Name object");
                    var4980AE888B424D26E0A3FAF1A1097229_1069474429.addTaint(taint);
                    throw var4980AE888B424D26E0A3FAF1A1097229_1069474429;
                } //End block
            } //End block
        } //End block
Object[] var6C26F6EC1F7A67F950053C95FE24CCE6_2035222950 =         l.toArray(new Object[l.size()]);
        var6C26F6EC1F7A67F950053C95FE24CCE6_2035222950.addTaint(taint);
        return var6C26F6EC1F7A67F950053C95FE24CCE6_2035222950;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.727 -0400", hash_original_method = "3DFD2537FFB449B5321668C577E5D216", hash_generated_method = "D40DC32DBEB0777E35CBE184D6E28618")
    public Principal[] getPrincipals() {
        Object[] p = this.getNames();
        List l = new ArrayList();
for(int i = 0;i != p.length;i++)
        {
    if(p[i] instanceof Principal)            
            {
                l.add(p[i]);
            } //End block
        } //End block
Principal[] var2BC6CB15026C258E2509F6CFCF0FEAB1_811810954 =         (Principal[])l.toArray(new Principal[l.size()]);
        var2BC6CB15026C258E2509F6CFCF0FEAB1_811810954.addTaint(taint);
        return var2BC6CB15026C258E2509F6CFCF0FEAB1_811810954;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.728 -0400", hash_original_method = "DB608757031C3F022268BBCAE1434BBE", hash_generated_method = "D6B373F555998B86660374262BF9935A")
    private boolean matchesDN(X500Principal subject, GeneralNames targets) {
        addTaint(targets.getTaint());
        addTaint(subject.getTaint());
        GeneralName[] names = targets.getNames();
for(int i = 0;i != names.length;i++)
        {
            GeneralName gn = names[i];
    if(gn.getTagNo() == GeneralName.directoryName)            
            {
                try 
                {
    if(new X500Principal(((ASN1Encodable)gn.getName()).getEncoded()).equals(subject))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1697963758 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874089458 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874089458;
                    } //End block
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_521296753 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_956911489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_956911489;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.729 -0400", hash_original_method = "3AF2A857F3C742FB55D3884093F02C4D", hash_generated_method = "FF324CFD729A99AD6FD8BC215CF903F3")
    public Object clone() {
Object varDACB60B4A9E3539334B4EC7C8A572E76_1681813759 =         new AttributeCertificateIssuer(AttCertIssuer.getInstance(form));
        varDACB60B4A9E3539334B4EC7C8A572E76_1681813759.addTaint(taint);
        return varDACB60B4A9E3539334B4EC7C8A572E76_1681813759;
        // ---------- Original Method ----------
        //return new AttributeCertificateIssuer(AttCertIssuer.getInstance(form));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.729 -0400", hash_original_method = "743F0CF49EF8F89EFC9B72FE9124B1C1", hash_generated_method = "C59CD124C574720A88C98AAD630E5AAE")
    public boolean match(Certificate cert) {
        addTaint(cert.getTaint());
    if(!(cert instanceof X509Certificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_866146734 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683009693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683009693;
        } //End block
        X509Certificate x509Cert = (X509Certificate)cert;
    if(form instanceof V2Form)        
        {
            V2Form issuer = (V2Form)form;
    if(issuer.getBaseCertificateID() != null)            
            {
                boolean varC23C002EA2F687F9C5AFBF47EE576B4B_1047197408 = (issuer.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(x509Cert.getIssuerX500Principal(), issuer.getBaseCertificateID().getIssuer()));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1278801146 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1278801146;
            } //End block
            GeneralNames name = issuer.getIssuerName();
    if(matchesDN(x509Cert.getSubjectX500Principal(), name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_855113238 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029960114 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029960114;
            } //End block
        } //End block
        else
        {
            GeneralNames name = (GeneralNames)form;
    if(matchesDN(x509Cert.getSubjectX500Principal(), name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_912708132 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536491050 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_536491050;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_875125921 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1521792393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1521792393;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.730 -0400", hash_original_method = "F6888345D31D77DF02A0F426A3C9D5A0", hash_generated_method = "D593755F6D25767EA857FAC110BF00AB")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1366495515 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926312688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_926312688;
        } //End block
    if(!(obj instanceof AttributeCertificateIssuer))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1439644574 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588933984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_588933984;
        } //End block
        AttributeCertificateIssuer other = (AttributeCertificateIssuer)obj;
        boolean varCF24DFE3C963EC5254560A1E23DAEC9B_544475465 = (this.form.equals(other.form));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453800280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453800280;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.730 -0400", hash_original_method = "0B7A1B2982787E7750666F5D71BB8845", hash_generated_method = "9695A5C444606A833FB5F9C1A3DA3174")
    public int hashCode() {
        int var2B374B3BF0704C747879C70CC6564E97_15731814 = (this.form.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780465293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780465293;
        // ---------- Original Method ----------
        //return this.form.hashCode();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.731 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "34E4672FF82A2409A64AF3E5AB856EA9")
    public boolean match(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof X509Certificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1137633311 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993777846 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_993777846;
        } //End block
        boolean varADA7754756F13D45E6E9A386DF7AABD4_919853541 = (match((Certificate)obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807802742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_807802742;
        // ---------- Original Method ----------
        //if (!(obj instanceof X509Certificate))
        //{
            //return false;
        //}
        //return match((Certificate)obj);
    }

    
}

