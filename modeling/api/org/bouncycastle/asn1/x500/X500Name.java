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


package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.X509Name;

public class X500Name extends ASN1Encodable implements ASN1Choice {

    /**
     * Return a X509Name based on the passed in tagged object.
     * 
     * @param obj tag object holding name.
     * @param explicit true if explicitly tagged false otherwise.
     * @return the X509Name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.768 -0500", hash_original_method = "54F5B51825A77F17059C9913B0A6802B", hash_generated_method = "380A19ABD2B579B70A5A6B4DA86FCCA8")
    
public static X500Name getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        // must be true as choice item
        return getInstance(ASN1Sequence.getInstance(obj, true));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.770 -0500", hash_original_method = "23202990696956C2606C2EB9F39F37D8", hash_generated_method = "069A9E3E4A0179F9BED82AB3515CFBE3")
    
public static X500Name getInstance(
        Object  obj)
    {
        if (obj instanceof X500Name)
        {
            return (X500Name)obj;
        }
        else if (obj instanceof X509Name)
        {
            return new X500Name(ASN1Sequence.getInstance(((X509Name)obj).getDERObject()));
        }
        else if (obj != null)
        {
            return new X500Name(ASN1Sequence.getInstance(obj));
        }

        return null;
    }

    /**
     * Set the default style for X500Name construction.
     *
     * @param style  an X500NameStyle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.805 -0500", hash_original_method = "966B398A79477C16C7C6FACCA94FA253", hash_generated_method = "A370AAB83926CB6968E5DDFF2E54B7B8")
    
public static void setDefaultStyle(X500NameStyle style)
    {
        if (style == null)
        {
            throw new NullPointerException("cannot set style to null");
        }

        defaultStyle = style;
    }

    /**
     * Return the current default style.
     *
     * @return default style for X500Name construction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.807 -0500", hash_original_method = "EDFAD14145CE2054657D525F76BE2B9E", hash_generated_method = "BAEDC9D5147B3DF8B3EC3E376A79E85E")
    
public static X500NameStyle getDefaultStyle()
    {
        return defaultStyle;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.752 -0500", hash_original_field = "F183032796F58A090FB2C77FE4D78719", hash_generated_field = "0022D6097CD2C8C1CB15974BBD83B021")

    private static X500NameStyle    defaultStyle = BCStyle.INSTANCE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.755 -0500", hash_original_field = "B6293280C3B6F91ED7F24C3952096C1C", hash_generated_field = "FFD3E18FB59EA084D3FD8E8945E2AACA")

    private boolean                 isHashCodeCalculated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.758 -0500", hash_original_field = "2D42E71DE4D8857610CF43708417333A", hash_generated_field = "D4D90810E0E6D99534BB2E8797B7FFA9")

    private int                     hashCodeValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.760 -0500", hash_original_field = "1562F63C243CCAE34D8562CE45D834EF", hash_generated_field = "ADD2EF6022A4B310B9B3CAE42CBA0F8A")

    private X500NameStyle style;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.763 -0500", hash_original_field = "15A3760B913BD02CDC7A3EA6E90C0664", hash_generated_field = "E6F265C5A2A75524751364DE8BEDA76F")

    private RDN[] rdns;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.765 -0500", hash_original_method = "A073765FBB48105361A5471731765C3D", hash_generated_method = "D4B2FBF47363A7BD5C403841D8AB5759")
    
public X500Name(X500NameStyle style, X500Name name)
    {
        this.rdns = name.rdns;
        this.style = style;
    }

    /**
     * Constructor from ASN1Sequence
     *
     * the principal will be a list of constructed sets, each containing an (OID, String) pair.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.773 -0500", hash_original_method = "90B05234255C50E94C255BAB8A26A1D2", hash_generated_method = "AA9DF5223EC8BF953F09F62DE00FBC56")
    
private X500Name(
        ASN1Sequence  seq)
    {
        this(defaultStyle, seq);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.776 -0500", hash_original_method = "8A5D5B23394E3163B760506B172464EC", hash_generated_method = "4F8227E0D6CC8E1E9CBA4C83D19EF178")
    
private X500Name(
        X500NameStyle style,
        ASN1Sequence  seq)
    {
        this.style = style;
        this.rdns = new RDN[seq.size()];

        int index = 0;

        for (Enumeration e = seq.getObjects(); e.hasMoreElements();)
        {
            rdns[index++] = RDN.getInstance(e.nextElement());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.778 -0500", hash_original_method = "A1AF24A6A66F9AA8032E8762CECAE163", hash_generated_method = "7F6B495A9ABED2C42E64ED3FC4144CD6")
    
public X500Name(
        RDN[] rDNs)
    {
        this(defaultStyle, rDNs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.781 -0500", hash_original_method = "DBB344B9E2C452B4F0EF3A22549C0276", hash_generated_method = "EB8649B68594E4CF47AC1604D6804A81")
    
public X500Name(
        X500NameStyle style,
        RDN[]         rDNs)
    {
        this.rdns = rDNs;
        this.style = style;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.784 -0500", hash_original_method = "3F7EF5F2D5D32EA7D1792E59FB00B21E", hash_generated_method = "84D3B7694E26613072CEBBFBAD9B0035")
    
public X500Name(
        String dirName)
    {
        this(defaultStyle, dirName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.787 -0500", hash_original_method = "1876E348797BFE6D82540F4D5D4BC70E", hash_generated_method = "3BB48728B28A94FCF9CCA5DE25E9F20A")
    
public X500Name(
        X500NameStyle style,
        String        dirName)
    {
        this(style.fromString(dirName));

        this.style = style;
    }

    /**
     * return an array of RDNs in structure order.
     *
     * @return an array of RDN objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.789 -0500", hash_original_method = "075988A0D732A4D3EE3D4A08C1D0111C", hash_generated_method = "8DF3259E131047C142A2E5722E0926D2")
    
public RDN[] getRDNs()
    {
        RDN[] tmp = new RDN[this.rdns.length];

        System.arraycopy(rdns, 0, tmp, 0, tmp.length);

        return tmp;
    }

    /**
     * return an array of RDNs containing the attribute type given by OID in structure order.
     *
     * @param oid the type OID we are looking for.
     * @return an array, possibly zero length, of RDN objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.793 -0500", hash_original_method = "58CE63756668BEA23514975180A77707", hash_generated_method = "BC8C6BF94BE3849C2F3EDD72FC9D4FCE")
    
public RDN[] getRDNs(ASN1ObjectIdentifier oid)
    {
        RDN[] res = new RDN[rdns.length];
        int   count = 0;

        for (int i = 0; i != rdns.length; i++)
        {
            RDN rdn = rdns[i];

            if (rdn.isMultiValued())
            {
                AttributeTypeAndValue[] attr = rdn.getTypesAndValues();
                for (int j = 0; j != attr.length; j++)
                {
                    if (attr[j].getType().equals(oid))
                    {
                        res[count++] = rdn;
                        break;
                    }
                }
            }
            else
            {
                if (rdn.getFirst().getType().equals(oid))
                {
                    res[count++] = rdn;
                }
            }
        }

        RDN[] tmp = new RDN[count];

        System.arraycopy(res, 0, tmp, 0, tmp.length);

        return tmp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.795 -0500", hash_original_method = "F0EEE66F5B12B6A45E4A635050172EB9", hash_generated_method = "D1ACBC884815656AB4E740C0CDE09818")
    
public DERObject toASN1Object()
    {
        return new DERSequence(rdns);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.797 -0500", hash_original_method = "ECFD9A32E241F4FBD41987B44388CEAF", hash_generated_method = "034D4431D1069929675B7274A736C484")
    
public int hashCode()
    {
        if (isHashCodeCalculated)
        {
            return hashCodeValue;
        }

        isHashCodeCalculated = true;

        hashCodeValue = style.calculateHashCode(this);

        return hashCodeValue;
    }

    /**
     * test for equality - note: case is ignored.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.799 -0500", hash_original_method = "75F09C9D81AE7E21861BB145326A0585", hash_generated_method = "39627E1086EAE975BD62CE1141382E57")
    
public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof X500Name || obj instanceof ASN1Sequence))
        {
            return false;
        }
        
        DERObject derO = ((DEREncodable)obj).getDERObject();

        if (this.getDERObject().equals(derO))
        {
            return true;
        }

        try
        {
            return style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((DEREncodable)obj).getDERObject())));
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.802 -0500", hash_original_method = "567E5D4F3D1A0F74E3A26BABA7FE2561", hash_generated_method = "11302A94DF0CD8D713F895CEE7CF5332")
    
public String toString()
    {
        return style.toString(this);
    }
}

