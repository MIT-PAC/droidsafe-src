package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.util.Arrays;

public class X509V2AttributeCertificate implements X509AttributeCertificate {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.493 -0500", hash_original_method = "E51ACADAD0BF3CFBCB6D5EA7D75AFA69", hash_generated_method = "E9FD2D447A63E89B6FF9C7535FD3ECCF")
    
private static AttributeCertificate getObject(InputStream in)
        throws IOException
    {
        try
        {
            return AttributeCertificate.getInstance(new ASN1InputStream(in).readObject());
        }
        catch (IOException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new IOException("exception decoding certificate structure: " + e.toString());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.486 -0500", hash_original_field = "0A7EAD8A01D5FE450C0BB7CF2FA42006", hash_generated_field = "AFD6C6D10463457A355EBA6B8E3CE0C1")

    private AttributeCertificate    cert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.488 -0500", hash_original_field = "939E4B8755FEFDE7585F0609AA03F4F6", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private Date                    notBefore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.490 -0500", hash_original_field = "BBDBC72835865CDFD7A55064C8322889", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private Date                    notAfter;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.495 -0500", hash_original_method = "511310A6550A73E5129DCD139E553E6F", hash_generated_method = "E1638FDB2A9265492B484538A46AEAB9")
    
public X509V2AttributeCertificate(
        InputStream encIn)
        throws IOException
    {
        this(getObject(encIn));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.498 -0500", hash_original_method = "B127BB0A829E4BFD3E32578437EC0EFB", hash_generated_method = "58C70FBE2FDDFC2928DF474D2B5A2D3B")
    
public X509V2AttributeCertificate(
        byte[]  encoded)
        throws IOException
    {
        this(new ByteArrayInputStream(encoded));
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.500 -0500", hash_original_method = "FF0916A499ED21133E7F47C29CF6DD83", hash_generated_method = "FF0916A499ED21133E7F47C29CF6DD83")
    
X509V2AttributeCertificate(
        AttributeCertificate    cert)
        throws IOException
    {
        this.cert = cert;
        
        try
        {
            this.notAfter = cert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime().getDate();
            this.notBefore = cert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime().getDate();
        }
        catch (ParseException e)
        {
            throw new IOException("invalid data structure in certificate!");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.503 -0500", hash_original_method = "5FE4A45F92CB5E44CD6499FACBF2EDEC", hash_generated_method = "442CAC297C8D6783AAD91CBCC9706CBA")
    
public int getVersion()
    {
        return cert.getAcinfo().getVersion().getValue().intValue() + 1;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.505 -0500", hash_original_method = "6D79F8D94B9C23855CFDC1454EEDA264", hash_generated_method = "C010F2AF96B7D211EE16A096154BA05C")
    
public BigInteger getSerialNumber()
    {
        return cert.getAcinfo().getSerialNumber().getValue();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.507 -0500", hash_original_method = "020DE1897FEFE364249BEA87F131F85A", hash_generated_method = "2C4930EC49A71A5E20C70023CCDF1704")
    
public AttributeCertificateHolder getHolder()
    {
        return new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.509 -0500", hash_original_method = "BBF141CF5A1E02D76A470DA06D7E0741", hash_generated_method = "E9A408A104CFC375E01FD80C27C68C48")
    
public AttributeCertificateIssuer getIssuer()
    {
        return new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.511 -0500", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "04488B711A48D81B20A16D9A63805F99")
    
public Date getNotBefore()
    {
        return notBefore;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.513 -0500", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "F084439CBA509EBC5DE73DA83B400817")
    
public Date getNotAfter()
    {
        return notAfter;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.517 -0500", hash_original_method = "9BC89181E6C1277EBE257648E61E1A79", hash_generated_method = "054CA102DF2120226EE337E46E52AAEA")
    
public boolean[] getIssuerUniqueID()
    {
        DERBitString    id = cert.getAcinfo().getIssuerUniqueID();

        if (id != null)
        {
            byte[]          bytes = id.getBytes();
            boolean[]       boolId = new boolean[bytes.length * 8 - id.getPadBits()];

            for (int i = 0; i != boolId.length; i++)
            {
                boolId[i] = (bytes[i / 8] & (0x80 >>> (i % 8))) != 0;
            }

            return boolId;
        }
            
        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.519 -0500", hash_original_method = "21EA5C7301B68DB7B0091D4882BC7F7A", hash_generated_method = "AFF7FBE1B8D64688FC34DB86CDE96F1C")
    
public void checkValidity() 
        throws CertificateExpiredException, CertificateNotYetValidException
    {
        this.checkValidity(new Date());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.522 -0500", hash_original_method = "C7ABADDDE42159C03B4715171CE7A75D", hash_generated_method = "3BCD7638EAC45BC104731DF123EDA355")
    
public void checkValidity(
        Date    date)
        throws CertificateExpiredException, CertificateNotYetValidException
    {
        if (date.after(this.getNotAfter()))
        {
            throw new CertificateExpiredException("certificate expired on " + this.getNotAfter());
        }

        if (date.before(this.getNotBefore()))
        {
            throw new CertificateNotYetValidException("certificate not valid till " + this.getNotBefore());
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.524 -0500", hash_original_method = "12695EBC2BF1A0C9FFF47E032B23EFDD", hash_generated_method = "A0FF5694EC581C852B57C23231D24F7D")
    
public byte[] getSignature()
    {
        return cert.getSignatureValue().getBytes();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.526 -0500", hash_original_method = "00EE60C525B48F0703DB78FF90B15573", hash_generated_method = "B8028C486434F1BE3B83F86005DFD265")
    
public final void verify(
            PublicKey   key,
            String      provider)
            throws CertificateException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException, SignatureException
    {
        Signature   signature = null;

        if (!cert.getSignatureAlgorithm().equals(cert.getAcinfo().getSignature()))
        {
            throw new CertificateException("Signature algorithm in certificate info not same as outer certificate");
        }

        signature = Signature.getInstance(cert.getSignatureAlgorithm().getObjectId().getId(), provider);

        signature.initVerify(key);

        try
        {
            signature.update(cert.getAcinfo().getEncoded());
        }
        catch (IOException e)
        {
            throw new SignatureException("Exception encoding certificate info object");
        }

        if (!signature.verify(this.getSignature()))
        {
            throw new InvalidKeyException("Public key presented not for certificate signature");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.529 -0500", hash_original_method = "C092EBBC5365A2A25EF301186F9FC908", hash_generated_method = "587A9FE3343E81FD250F69E04722A028")
    
public byte[] getEncoded()
        throws IOException
    {
        return cert.getEncoded();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.531 -0500", hash_original_method = "174EB6531B05B4A912F07FC1EA279D8F", hash_generated_method = "021DFD33B02C492760BD111EB88E51D9")
    
public byte[] getExtensionValue(String oid) 
    {
        X509Extensions  extensions = cert.getAcinfo().getExtensions();

        if (extensions != null)
        {
            X509Extension   ext = extensions.getExtension(new DERObjectIdentifier(oid));

            if (ext != null)
            {
                try
                {
                    return ext.getValue().getEncoded(ASN1Encodable.DER);
                }
                catch (Exception e)
                {
                    throw new RuntimeException("error encoding " + e.toString());
                }
            }
        }

        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.534 -0500", hash_original_method = "EEE6D6FB39ABCE0441C4E0B5FB99D1CC", hash_generated_method = "7B0EA9C8E0D55BAB8E7CB5AB27C645CF")
    
private Set getExtensionOIDs(
        boolean critical) 
    {
        X509Extensions  extensions = cert.getAcinfo().getExtensions();

        if (extensions != null)
        {
            Set             set = new HashSet();
            Enumeration     e = extensions.oids();

            while (e.hasMoreElements())
            {
                DERObjectIdentifier oid = (DERObjectIdentifier)e.nextElement();
                X509Extension       ext = extensions.getExtension(oid);

                if (ext.isCritical() == critical)
                {
                    set.add(oid.getId());
                }
            }

            return set;
        }

        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.536 -0500", hash_original_method = "5436A1880A3E8EACEF801692C5DC1E5D", hash_generated_method = "B39E2DED8BA7440416AD430886190969")
    
public Set getNonCriticalExtensionOIDs() 
    {
        return getExtensionOIDs(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.538 -0500", hash_original_method = "95A4F309A27080538E4E315B4E15DBCF", hash_generated_method = "F915AB1631F4A025BB7CD0C6F0971952")
    
public Set getCriticalExtensionOIDs() 
    {
        return getExtensionOIDs(true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.540 -0500", hash_original_method = "DC43BBF9B96B5410825BE22446F9B294", hash_generated_method = "2244EF7C1D1AC62F89251DC5CBD17C42")
    
public boolean hasUnsupportedCriticalExtension()
    {
        Set  extensions = getCriticalExtensionOIDs();

        return extensions != null && !extensions.isEmpty();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.542 -0500", hash_original_method = "D9A39E0FBB510DE2D7B256831A61B9D2", hash_generated_method = "CB37D97E1AD62827E626D80FBAB8C621")
    
public X509Attribute[] getAttributes()
    {
        ASN1Sequence    seq = cert.getAcinfo().getAttributes();
        X509Attribute[] attrs = new X509Attribute[seq.size()];
        
        for (int i = 0; i != seq.size(); i++)
        {
            attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
        }
        
        return attrs;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.545 -0500", hash_original_method = "1BDF84262F391CC05FF0C51BDEDDB7BE", hash_generated_method = "2F1DB9E0C3674BFA23BE00DA3344AA1D")
    
public X509Attribute[] getAttributes(String oid)
    {
        ASN1Sequence    seq = cert.getAcinfo().getAttributes();
        List            list = new ArrayList();
        
        for (int i = 0; i != seq.size(); i++)
        {
            X509Attribute attr = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
            if (attr.getOID().equals(oid))
            {
                list.add(attr);
            }
        }
        
        if (list.size() == 0)
        {
            return null;
        }
        
        return (X509Attribute[])list.toArray(new X509Attribute[list.size()]);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.547 -0500", hash_original_method = "60181B32C72761B75B31B405BBC4804E", hash_generated_method = "030463A25E8B1BD01267EAF961D024DD")
    
public boolean equals(
        Object o)
    {
        if (o == this)
        {
            return true;
        }

        if (!(o instanceof X509AttributeCertificate))
        {
            return false;
        }

        X509AttributeCertificate other = (X509AttributeCertificate)o;

        try
        {
            byte[] b1 = this.getEncoded();
            byte[] b2 = other.getEncoded();

            return Arrays.areEqual(b1, b2);
        }
        catch (IOException e)
        {
            return false;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.550 -0500", hash_original_method = "C5506CF7B2024CB4E09A9FBA2D111DDF", hash_generated_method = "EA0C2A58E7CEC2CA556617425637CA25")
    
public int hashCode()
    {
        try
        {
            return Arrays.hashCode(this.getEncoded());
        }
        catch (IOException e)
        {
            return 0;
        }
    }
    
}

