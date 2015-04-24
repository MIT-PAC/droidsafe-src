/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.asn1.x509.ObjectDigestInfo;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

public class AttributeCertificateHolder implements CertSelector, Selector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.781 -0500", hash_original_field = "81EEF30676831ECD3948BE1C9E69FB41", hash_generated_field = "81EEF30676831ECD3948BE1C9E69FB41")

     Holder holder;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.783 -0500", hash_original_method = "5CADDEA19B83B0D9A5BBB8113D1E397F", hash_generated_method = "5CADDEA19B83B0D9A5BBB8113D1E397F")
    
AttributeCertificateHolder(ASN1Sequence seq)
    {
        holder = Holder.getInstance(seq);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.786 -0500", hash_original_method = "36C6FF42848B06325DA653927B354FB6", hash_generated_method = "53EB7C07AEFA7DFE07E6C13B3296A863")
    
public AttributeCertificateHolder(X509Principal issuerName,
        BigInteger serialNumber)
    {
        holder = new org.bouncycastle.asn1.x509.Holder(new IssuerSerial(
            new GeneralNames(new DERSequence(new GeneralName(issuerName))),
            new DERInteger(serialNumber)));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.789 -0500", hash_original_method = "AB8EF4A9C8EF2BF3AB56D333BEC2C930", hash_generated_method = "C3D5F26B2BD4732FDEA383D7E3778741")
    
public AttributeCertificateHolder(X500Principal issuerName,
        BigInteger serialNumber)
    {
        this(X509Util.convertPrincipal(issuerName), serialNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.792 -0500", hash_original_method = "38A3680A490D691786DB1D5D606419F8", hash_generated_method = "C0307B4B0D6F4EE21D0823545ECCCC1B")
    
public AttributeCertificateHolder(X509Certificate cert)
        throws CertificateParsingException
    {
        X509Principal name;

        try
        {
            name = PrincipalUtil.getIssuerX509Principal(cert);
        }
        catch (Exception e)
        {
            throw new CertificateParsingException(e.getMessage());
        }

        holder = new Holder(new IssuerSerial(generateGeneralNames(name),
            new DERInteger(cert.getSerialNumber())));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.795 -0500", hash_original_method = "BB3F8ED7A12081786FFA678549853DD7", hash_generated_method = "7D27FC8504D0D8DDAB73C46175D778CA")
    
public AttributeCertificateHolder(X509Principal principal)
    {
        holder = new Holder(generateGeneralNames(principal));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.798 -0500", hash_original_method = "8754A1CB9EC37CB6374A9BB4689D9463", hash_generated_method = "F4FA4B348B8067B66227E99ED1976FE0")
    
public AttributeCertificateHolder(X500Principal principal)
    {
        this(X509Util.convertPrincipal(principal));
    }

    /**
     * Constructs a holder for v2 attribute certificates with a hash value for
     * some type of object.
     * <p>
     * <code>digestedObjectType</code> can be one of the following:
     * <ul>
     * <li>0 - publicKey - A hash of the public key of the holder must be
     * passed.
     * <li>1 - publicKeyCert - A hash of the public key certificate of the
     * holder must be passed.
     * <li>2 - otherObjectDigest - A hash of some other object type must be
     * passed. <code>otherObjectTypeID</code> must not be empty.
     * </ul>
     * <p>
     * This cannot be used if a v1 attribute certificate is used.
     * 
     * @param digestedObjectType The digest object type.
     * @param digestAlgorithm The algorithm identifier for the hash.
     * @param otherObjectTypeID The object type ID if
     *            <code>digestedObjectType</code> is
     *            <code>otherObjectDigest</code>.
     * @param objectDigest The hash value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.800 -0500", hash_original_method = "058E2AA05CCDB81429F1E94E1527F7B6", hash_generated_method = "69A5F55463B1296017A10AC41D0F057D")
    
public AttributeCertificateHolder(int digestedObjectType,
        String digestAlgorithm, String otherObjectTypeID, byte[] objectDigest)
    {
        holder = new Holder(new ObjectDigestInfo(digestedObjectType,
            otherObjectTypeID, new AlgorithmIdentifier(digestAlgorithm), Arrays
                .clone(objectDigest)));
    }

    /**
     * Returns the digest object type if an object digest info is used.
     * <p>
     * <ul>
     * <li>0 - publicKey - A hash of the public key of the holder must be
     * passed.
     * <li>1 - publicKeyCert - A hash of the public key certificate of the
     * holder must be passed.
     * <li>2 - otherObjectDigest - A hash of some other object type must be
     * passed. <code>otherObjectTypeID</code> must not be empty.
     * </ul>
     * 
     * @return The digest object type or -1 if no object digest info is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.803 -0500", hash_original_method = "5DC58025DAD5ABD5E5609ED391A96DAB", hash_generated_method = "5044D4C4C00912E9D709D80E0876FE0A")
    
public int getDigestedObjectType()
    {
        if (holder.getObjectDigestInfo() != null)
        {
            return holder.getObjectDigestInfo().getDigestedObjectType()
                .getValue().intValue();
        }
        return -1;
    }

    /**
     * Returns the other object type ID if an object digest info is used.
     * 
     * @return The other object type ID or <code>null</code> if no object
     *         digest info is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.805 -0500", hash_original_method = "44CC065F66E7FDD5B9E2538C14A00A59", hash_generated_method = "8FB11EA63D07638A70124DE0AB34DB9C")
    
public String getDigestAlgorithm()
    {
        if (holder.getObjectDigestInfo() != null)
        {
            return holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                .getId();
        }
        return null;
    }

    /**
     * Returns the hash if an object digest info is used.
     * 
     * @return The hash or <code>null</code> if no object digest info is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.808 -0500", hash_original_method = "4B9D866BC14850DF9DC3D05B3C536D79", hash_generated_method = "6029C1D750AF1B3F075FE4E4028AB894")
    
public byte[] getObjectDigest()
    {
        if (holder.getObjectDigestInfo() != null)
        {
            return holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    /**
     * Returns the digest algorithm ID if an object digest info is used.
     * 
     * @return The digest algorithm ID or <code>null</code> if no object
     *         digest info is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.810 -0500", hash_original_method = "D91C38C78BDA175ED1B06895DD027E8A", hash_generated_method = "678AF50AFE809F9FB282B7A90CD5350A")
    
public String getOtherObjectTypeID()
    {
        if (holder.getObjectDigestInfo() != null)
        {
            holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        }
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.812 -0500", hash_original_method = "813AC8AE1843F5B7087E11CB016E8403", hash_generated_method = "98328AD328EBFE4EA80E7D61F0CB4312")
    
private GeneralNames generateGeneralNames(X509Principal principal)
    {
        return new GeneralNames(new DERSequence(new GeneralName(principal)));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.816 -0500", hash_original_method = "938EE7D821BB407EF13AE79847029298", hash_generated_method = "481DB24D8DF1CE280CA62F711FE67824")
    
private boolean matchesDN(X509Principal subject, GeneralNames targets)
    {
        GeneralName[] names = targets.getNames();

        for (int i = 0; i != names.length; i++)
        {
            GeneralName gn = names[i];

            if (gn.getTagNo() == GeneralName.directoryName)
            {
                try
                {
                    if (new X509Principal(((ASN1Encodable)gn.getName())
                        .getEncoded()).equals(subject))
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.818 -0500", hash_original_method = "7552EC21B75F1C8319E3B7352977E9CE", hash_generated_method = "2E3F6A22E66BCDAAA8D6F8DE536543B1")
    
private Object[] getNames(GeneralName[] names)
    {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.821 -0500", hash_original_method = "2BE9B6F72BB32A06F2A43AB8DF17A2B5", hash_generated_method = "BE89667838AC79A107867130DACF47F1")
    
private Principal[] getPrincipals(GeneralNames names)
    {
        Object[] p = this.getNames(names.getNames());
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

    /**
     * Return any principal objects inside the attribute certificate holder
     * entity names field.
     * 
     * @return an array of Principal objects (usually X500Principal), null if no
     *         entity names field is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.823 -0500", hash_original_method = "DB0C376D8871308D29988D3B3AAF17FC", hash_generated_method = "494FABAFF98DAA763B7F63A0C7368C63")
    
public Principal[] getEntityNames()
    {
        if (holder.getEntityName() != null)
        {
            return getPrincipals(holder.getEntityName());
        }

        return null;
    }

    /**
     * Return the principals associated with the issuer attached to this holder
     * 
     * @return an array of principals, null if no BaseCertificateID is set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.825 -0500", hash_original_method = "4F5AD36C2F60574BEE36BBEC8A3F8872", hash_generated_method = "E9B9579B9C7EF6293EA5435CA72C22CA")
    
public Principal[] getIssuer()
    {
        if (holder.getBaseCertificateID() != null)
        {
            return getPrincipals(holder.getBaseCertificateID().getIssuer());
        }

        return null;
    }

    /**
     * Return the serial number associated with the issuer attached to this
     * holder.
     * 
     * @return the certificate serial number, null if no BaseCertificateID is
     *         set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.828 -0500", hash_original_method = "6708CF3972ED2FC7BE75744CEC7FD162", hash_generated_method = "30ABFD7ECE66A89FF1501A923639BAFC")
    
public BigInteger getSerialNumber()
    {
        if (holder.getBaseCertificateID() != null)
        {
            return holder.getBaseCertificateID().getSerial().getValue();
        }

        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.830 -0500", hash_original_method = "53037C58AFDDBA87577A0806677CF7E3", hash_generated_method = "82E4EBA62ECBE8670A018DE7BA7CF507")
    
public Object clone()
    {
        return new AttributeCertificateHolder((ASN1Sequence)holder
            .toASN1Object());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.833 -0500", hash_original_method = "656B19C882F86A200CE16DF3E12BB617", hash_generated_method = "DF3C718C38E5065C0AA6DEDE0191C64D")
    
public boolean match(Certificate cert)
    {
        if (!(cert instanceof X509Certificate))
        {
            return false;
        }

        X509Certificate x509Cert = (X509Certificate)cert;

        try
        {
            if (holder.getBaseCertificateID() != null)
            {
                return holder.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Cert), holder.getBaseCertificateID().getIssuer());
            }

            if (holder.getEntityName() != null)
            {
                if (matchesDN(PrincipalUtil.getSubjectX509Principal(x509Cert),
                    holder.getEntityName()))
                {
                    return true;
                }
            }
            if (holder.getObjectDigestInfo() != null)
            {
                MessageDigest md = null;
                try
                {
                    md = MessageDigest.getInstance(getDigestAlgorithm(), "BC");

                }
                catch (Exception e)
                {
                    return false;
                }
                switch (getDigestedObjectType())
                {
                case ObjectDigestInfo.publicKey:
                    // TODO: DSA Dss-parms
                    md.update(cert.getPublicKey().getEncoded());
                    break;
                case ObjectDigestInfo.publicKeyCert:
                    md.update(cert.getEncoded());
                    break;
                }
                if (!Arrays.areEqual(md.digest(), getObjectDigest()))
                {
                    return false;
                }
            }
        }
        catch (CertificateEncodingException e)
        {
            return false;
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.836 -0500", hash_original_method = "DF0F926A4C6973AE80CA99906EB348D1", hash_generated_method = "C2D4CA41F63C2534B5385FD46D0F086D")
    
public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof AttributeCertificateHolder))
        {
            return false;
        }

        AttributeCertificateHolder other = (AttributeCertificateHolder)obj;

        return this.holder.equals(other.holder);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.838 -0500", hash_original_method = "D89AAACD9C01672ED8F506F3741EB875", hash_generated_method = "20DAB20065F43CF84CDD0862E826D4EE")
    
public int hashCode()
    {
        return this.holder.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:40.840 -0500", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "6E7E49F8C9AD7B022B606400C3B5F385")
    
public boolean match(Object obj)
    {
        if (!(obj instanceof X509Certificate))
        {
            return false;
        }

        return match((Certificate)obj);
    }
    
}

