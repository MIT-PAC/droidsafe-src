package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.006 -0500", hash_original_field = "F472E80F733CDF00E48AF589322F06BE", hash_generated_field = "F472E80F733CDF00E48AF589322F06BE")

     ASN1Encodable form;

    /**
     * Set the issuer directly with the ASN.1 structure.
     * 
     * @param issuer The issuer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.008 -0500", hash_original_method = "BBF050FF37EED8F05F0CD887F679CFE4", hash_generated_method = "04ECA89011DBD82E72A31991912E536D")
    
public AttributeCertificateIssuer(AttCertIssuer issuer)
    {
        form = issuer.getIssuer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.012 -0500", hash_original_method = "D6A3C71D8C78168F005DD976BB9D460A", hash_generated_method = "E346B61EA4016D264FB0D1E7983120F1")
    
public AttributeCertificateIssuer(X500Principal principal)
        throws IOException
    {
        this(new X509Principal(principal.getEncoded()));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.015 -0500", hash_original_method = "6459F0ACD6C2225742DF42C099A35AAF", hash_generated_method = "968A5678DAF967AE3FA794662CB4448E")
    
public AttributeCertificateIssuer(X509Principal principal)
    {
        form = new V2Form(new GeneralNames(new DERSequence(new GeneralName(principal))));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.017 -0500", hash_original_method = "E1F244CC3C2F69A383C3B6A34635861B", hash_generated_method = "0A50B512A51F6F9ED9CD9C8DB79C5C1D")
    
private Object[] getNames()
    {
        GeneralNames name;

        if (form instanceof V2Form)
        {
            name = ((V2Form)form).getIssuerName();
        }
        else
        {
            name = (GeneralNames)form;
        }

        GeneralName[] names = name.getNames();

        List l = new ArrayList(names.length);

        for (int i = 0; i != names.length; i++)
        {
            if (names[i].getTagNo() == GeneralName.directoryName)
            {
                try
                {
                    l.add(new X500Principal(
                        ((ASN1Encodable)names[i].getName()).getEncoded()));
                }
                catch (IOException e)
                {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }

        return l.toArray(new Object[l.size()]);
    }

    /**
     * Return any principal objects inside the attribute certificate issuer
     * object.
     * 
     * @return an array of Principal objects (usually X500Principal)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.020 -0500", hash_original_method = "3DFD2537FFB449B5321668C577E5D216", hash_generated_method = "C58D3BD8E679A4CFDA03E05527619D76")
    
public Principal[] getPrincipals()
    {
        Object[] p = this.getNames();
        List l = new ArrayList();

        for (int i = 0; i != p.length; i++)
        {
            if (p[i] instanceof Principal)
            {
                l.add(p[i]);
            }
        }

        return (Principal[])l.toArray(new Principal[l.size()]);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.022 -0500", hash_original_method = "DB608757031C3F022268BBCAE1434BBE", hash_generated_method = "ADA157C70E1BD88F937B563160F12EED")
    
private boolean matchesDN(X500Principal subject, GeneralNames targets)
    {
        GeneralName[] names = targets.getNames();

        for (int i = 0; i != names.length; i++)
        {
            GeneralName gn = names[i];

            if (gn.getTagNo() == GeneralName.directoryName)
            {
                try
                {
                    if (new X500Principal(((ASN1Encodable)gn.getName()).getEncoded()).equals(subject))
                    {
                        return true;
                    }
                }
                catch (IOException e)
                {
                }
            }
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.025 -0500", hash_original_method = "3AF2A857F3C742FB55D3884093F02C4D", hash_generated_method = "95C1135E2B576437E98ABE50F6386AA5")
    
public Object clone()
    {
        return new AttributeCertificateIssuer(AttCertIssuer.getInstance(form));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.027 -0500", hash_original_method = "743F0CF49EF8F89EFC9B72FE9124B1C1", hash_generated_method = "4C80225690BD963BD0A28770402768F3")
    
public boolean match(Certificate cert)
    {
        if (!(cert instanceof X509Certificate))
        {
            return false;
        }

        X509Certificate x509Cert = (X509Certificate)cert;

        if (form instanceof V2Form)
        {
            V2Form issuer = (V2Form)form;
            if (issuer.getBaseCertificateID() != null)
            {
                return issuer.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(x509Cert.getIssuerX500Principal(), issuer.getBaseCertificateID().getIssuer());
            }

            GeneralNames name = issuer.getIssuerName();
            if (matchesDN(x509Cert.getSubjectX500Principal(), name))
            {
                return true;
            }
        }
        else
        {
            GeneralNames name = (GeneralNames)form;
            if (matchesDN(x509Cert.getSubjectX500Principal(), name))
            {
                return true;
            }
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.030 -0500", hash_original_method = "F6888345D31D77DF02A0F426A3C9D5A0", hash_generated_method = "950E577FCAC1E0C0F13F96E3817B6171")
    
public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof AttributeCertificateIssuer))
        {
            return false;
        }

        AttributeCertificateIssuer other = (AttributeCertificateIssuer)obj;

        return this.form.equals(other.form);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.032 -0500", hash_original_method = "0B7A1B2982787E7750666F5D71BB8845", hash_generated_method = "B596598D02F60D16A04AAAD4DE667F48")
    
public int hashCode()
    {
        return this.form.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:41.035 -0500", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "6E7E49F8C9AD7B022B606400C3B5F385")
    
public boolean match(Object obj)
    {
        if (!(obj instanceof X509Certificate))
        {
            return false;
        }

        return match((Certificate)obj);
    }
    
}

