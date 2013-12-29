package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;






public class DERExternal extends ASN1Object {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.204 -0500", hash_original_field = "6D2BDBA72520295A7C15B183E0D9C569", hash_generated_field = "8B451B3DBA24F8A6DD2DAC687FC92958")

    private DERObjectIdentifier directReference;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.204 -0500", hash_original_field = "2706744C03E9CE7CD043CB09D0DB3E56", hash_generated_field = "4BDDE807B370ABCD06D1D8B56EE5C7C4")

    private DERInteger indirectReference;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.205 -0500", hash_original_field = "6E0492DF5D2E32AF5B232A66187FCC27", hash_generated_field = "A8803A57E0AB1FAD59A5878D307FCE93")

    private ASN1Object dataValueDescriptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.206 -0500", hash_original_field = "39D1C9E1C270FCBF267B46BFEA8420E2", hash_generated_field = "E77A569AB1DC34BFC03164971297EE8D")

    private int encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.207 -0500", hash_original_field = "83C54432A38192D55E4EDA3FC93939BE", hash_generated_field = "8CF4A9E6D02D0338F11DF53BC2A4E23F")

    private DERObject externalContent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.208 -0500", hash_original_method = "5B6E321D0FF0F6E358DB9222EA98BCB7", hash_generated_method = "7728BB12B8EE48190D28CA18979AEC82")
    public DERExternal(ASN1EncodableVector vector)
    {
        int offset = 0;

        DERObject enc = getObjFromVector(vector, offset);
        if (enc instanceof DERObjectIdentifier)
        {
            directReference = (DERObjectIdentifier)enc;
            offset++;
            enc = getObjFromVector(vector, offset);
        }
        if (enc instanceof DERInteger)
        {
            indirectReference = (DERInteger) enc;
            offset++;
            enc = getObjFromVector(vector, offset);
        }
        if (!(enc instanceof DERTaggedObject))
        {
            dataValueDescriptor = (ASN1Object) enc;
            offset++;
            enc = getObjFromVector(vector, offset);
        }

        if (vector.size() != offset + 1)
        {
            throw new IllegalArgumentException("input vector too large");
        }

        if (!(enc instanceof DERTaggedObject))
        {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
        DERTaggedObject obj = (DERTaggedObject)enc;
        setEncoding(obj.getTagNo());
        externalContent = obj.getObject();
    }
    /**
     * Creates a new instance of DERExternal
     * See X.690 for more informations about the meaning of these parameters
     * @param directReference The direct reference or <code>null</code> if not set.
     * @param indirectReference The indirect reference or <code>null</code> if not set.
     * @param dataValueDescriptor The data value descriptor or <code>null</code> if not set.
     * @param externalData The external data in its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.210 -0500", hash_original_method = "3E78E5A9498D2FA8094C2F6169A192AD", hash_generated_method = "8C83FF4C61A9DB1335C855AB0D226F3A")
    public DERExternal(DERObjectIdentifier directReference, DERInteger indirectReference, ASN1Object dataValueDescriptor, DERTaggedObject externalData)
    {
        this(directReference, indirectReference, dataValueDescriptor, externalData.getTagNo(), externalData.getDERObject());
    }

    /**
     * Creates a new instance of DERExternal.
     * See X.690 for more informations about the meaning of these parameters
     * @param directReference The direct reference or <code>null</code> if not set.
     * @param indirectReference The indirect reference or <code>null</code> if not set.
     * @param dataValueDescriptor The data value descriptor or <code>null</code> if not set.
     * @param encoding The encoding to be used for the external data
     * @param externalData The external data
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.211 -0500", hash_original_method = "865736B8E6D41CC27E8C4571B72736D6", hash_generated_method = "2FBFF2774EBE1C709D4520ED4335CEEE")
    public DERExternal(DERObjectIdentifier directReference, DERInteger indirectReference, ASN1Object dataValueDescriptor, int encoding, DERObject externalData)
    {
        setDirectReference(directReference);
        setIndirectReference(indirectReference);
        setDataValueDescriptor(dataValueDescriptor);
        setEncoding(encoding);
        setExternalContent(externalData.getDERObject());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.209 -0500", hash_original_method = "B967C566758213AD266FDB24FA14151A", hash_generated_method = "AE6FE7C100D471CEA69C459B25610E4F")
    private DERObject getObjFromVector(ASN1EncodableVector v, int index)
    {
        if (v.size() <= index)
        {
            throw new IllegalArgumentException("too few objects in input vector");
        }

        return v.get(index).getDERObject();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.212 -0500", hash_original_method = "E789B91521559DD1093D7E9087176FAE", hash_generated_method = "328CE02F6EDF9C2A733D326777F84E3D")
    public int hashCode()
    {
        int ret = 0;
        if (directReference != null)
        {
            ret = directReference.hashCode();
        }
        if (indirectReference != null)
        {
            ret ^= indirectReference.hashCode();
        }
        if (dataValueDescriptor != null)
        {
            ret ^= dataValueDescriptor.hashCode();
        }
        ret ^= externalContent.hashCode();
        return ret;
    }

    /* (non-Javadoc)
     * @see org.bouncycastle.asn1.DERObject#encode(org.bouncycastle.asn1.DEROutputStream)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.213 -0500", hash_original_method = "95E5CCE7002362171E5372628ECC5970", hash_generated_method = "95E5CCE7002362171E5372628ECC5970")
    void encode(DEROutputStream out)
        throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (directReference != null)
        {
            baos.write(directReference.getDEREncoded());
        }
        if (indirectReference != null)
        {
            baos.write(indirectReference.getDEREncoded());
        }
        if (dataValueDescriptor != null)
        {
            baos.write(dataValueDescriptor.getDEREncoded());
        }
        DERTaggedObject obj = new DERTaggedObject(encoding, externalContent);
        baos.write(obj.getDEREncoded());
        out.writeEncoded(DERTags.CONSTRUCTED, DERTags.EXTERNAL, baos.toByteArray());
    }

    /* (non-Javadoc)
     * @see org.bouncycastle.asn1.ASN1Object#asn1Equals(org.bouncycastle.asn1.DERObject)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.214 -0500", hash_original_method = "B6A4F973EBC78A6793C4703762E4E562", hash_generated_method = "B6A4F973EBC78A6793C4703762E4E562")
    boolean asn1Equals(DERObject o)
    {
        if (!(o instanceof DERExternal))
        {
            return false;
        }
        if (this == o)
        {
            return true;
        }
        DERExternal other = (DERExternal)o;
        if (directReference != null)
        {
            if (other.directReference == null || !other.directReference.equals(directReference))  
            {
                return false;
            }
        }
        if (indirectReference != null)
        {
            if (other.indirectReference == null || !other.indirectReference.equals(indirectReference))
            {
                return false;
            }
        }
        if (dataValueDescriptor != null)
        {
            if (other.dataValueDescriptor == null || !other.dataValueDescriptor.equals(dataValueDescriptor))
            {
                return false;
            }
        }
        return externalContent.equals(other.externalContent);
    }

    /**
     * Returns the data value descriptor
     * @return The descriptor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.214 -0500", hash_original_method = "0B6DEA5056C96F68CB576A145B8163A4", hash_generated_method = "5BE064B6780DCA66F3DF81BD238BADF7")
    public ASN1Object getDataValueDescriptor()
    {
        return dataValueDescriptor;
    }

    /**
     * Returns the direct reference of the external element
     * @return The reference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.216 -0500", hash_original_method = "5D19E791BF0146D74AAC703832ECF7B9", hash_generated_method = "8644DACE81C95FF3786E6E3F267D627F")
    public DERObjectIdentifier getDirectReference()
    {
        return directReference;
    }

    /**
     * Returns the encoding of the content. Valid values are
     * <ul>
     * <li><code>0</code> single-ASN1-type</li>
     * <li><code>1</code> OCTET STRING</li>
     * <li><code>2</code> BIT STRING</li>
     * </ul>
     * @return The encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.216 -0500", hash_original_method = "20B2CEB64A03B59C5CB213FEC1AC33C9", hash_generated_method = "6D73038C04B33A6E25C9669C77EB73A4")
    public int getEncoding()
    {
        return encoding;
    }
    
    /**
     * Returns the content of this element
     * @return The content
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.217 -0500", hash_original_method = "A31A01A5BEAE5C1C675F68CA7DEBC312", hash_generated_method = "BC4F5A67533FEFDD0C9D6DED00CDF132")
    public DERObject getExternalContent()
    {
        return externalContent;
    }
    
    /**
     * Returns the indirect reference of this element
     * @return The reference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.218 -0500", hash_original_method = "A48170CD86EA456F3F5BDA9638D90BB1", hash_generated_method = "195BA8FFE19ACF28C661887D7E7EBF53")
    public DERInteger getIndirectReference()
    {
        return indirectReference;
    }
    
    /**
     * Sets the data value descriptor
     * @param dataValueDescriptor The descriptor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.218 -0500", hash_original_method = "0BD65C140FCC2077661040D20B226912", hash_generated_method = "A8B65273DA2E679E635CBC93ACDFB1FE")
    private void setDataValueDescriptor(ASN1Object dataValueDescriptor)
    {
        this.dataValueDescriptor = dataValueDescriptor;
    }

    /**
     * Sets the direct reference of the external element
     * @param directReferemce The reference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.219 -0500", hash_original_method = "A83523D5E22547A02A231238C93C9842", hash_generated_method = "77F970611B4E55BB9C3550410A2F0B04")
    private void setDirectReference(DERObjectIdentifier directReferemce)
    {
        this.directReference = directReferemce;
    }
    
    /**
     * Sets the encoding of the content. Valid values are
     * <ul>
     * <li><code>0</code> single-ASN1-type</li>
     * <li><code>1</code> OCTET STRING</li>
     * <li><code>2</code> BIT STRING</li>
     * </ul>
     * @param encoding The encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.220 -0500", hash_original_method = "D6EB4173694568A37E5CF8BEC224CE9C", hash_generated_method = "39FE93F559C112B4809D9178EAA6F995")
    private void setEncoding(int encoding)
    {
        if (encoding < 0 || encoding > 2)
        {
            throw new IllegalArgumentException("invalid encoding value: " + encoding);
        }
        this.encoding = encoding;
    }
    
    /**
     * Sets the content of this element
     * @param externalContent The content
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.221 -0500", hash_original_method = "DE6F2795286824746E38E92F0B41BA33", hash_generated_method = "82C51007B051D24EC707A5180654B8C9")
    private void setExternalContent(DERObject externalContent)
    {
        this.externalContent = externalContent;
    }
    
    /**
     * Sets the indirect reference of this element
     * @param indirectReference The reference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.221 -0500", hash_original_method = "0014F60DB99B68C720B34F07B78773E4", hash_generated_method = "69C3211E041A1D148A3AD1FC8D11B5CF")
    private void setIndirectReference(DERInteger indirectReference)
    {
        this.indirectReference = indirectReference;
    }

    
}

