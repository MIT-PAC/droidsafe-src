package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.840 -0500", hash_original_field = "0AF8B53607342E2932B67C3C39DDF67E", hash_generated_field = "AD9BC78DBAEEEA7F3095C3D4235D31E3")

    private  InputStream _in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.843 -0500", hash_original_field = "ADA4D5F0AAE64549A210DC56084FD197", hash_generated_field = "CC1F761CCB044A54710FD1E5F22ED61A")

    private  int         _limit;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.845 -0500", hash_original_method = "DBA5BC9F59C3649B70C3A3387D909190", hash_generated_method = "BAE0FCF7C6B0631AA209089D9032CDB1")
    
public ASN1StreamParser(
        InputStream in)
    {
        this(in, ASN1InputStream.findLimit(in));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.848 -0500", hash_original_method = "6581181C0F10BA1424D0E617E42FF352", hash_generated_method = "8AA58FCB9481546333D8BD072ABE2005")
    
public ASN1StreamParser(
        InputStream in,
        int         limit)
    {
        this._in = in;
        this._limit = limit;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.851 -0500", hash_original_method = "2384F9E8B7C9F8CABF70D53041DA5305", hash_generated_method = "AD730A8C8B52879F4F0751AE2D6F8CB5")
    
public ASN1StreamParser(
        byte[] encoding)
    {
        this(new ByteArrayInputStream(encoding), encoding.length);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.853 -0500", hash_original_method = "C3E0BE0AC09DBB98B8E162DDEE686364", hash_generated_method = "F26828307F2BB67D67D8475A095865AB")
    
DEREncodable readIndef(int tagValue) throws IOException
    {
        // Note: INDEF => CONSTRUCTED

        // TODO There are other tags that may be constructed (e.g. BIT_STRING)
        switch (tagValue)
        {
            case DERTags.EXTERNAL:
                return new DERExternalParser(this);
            case DERTags.OCTET_STRING:
                return new BEROctetStringParser(this);
            case DERTags.SEQUENCE:
                return new BERSequenceParser(this);
            case DERTags.SET:
                return new BERSetParser(this);
            default:
                throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(tagValue));
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.856 -0500", hash_original_method = "CAB584B2B56E52E14F26B47F81A64976", hash_generated_method = "53A03EBCA02B4F64398F1CB47E4F7014")
    
DEREncodable readImplicit(boolean constructed, int tag) throws IOException
    {
        if (_in instanceof IndefiniteLengthInputStream)
        {
            if (!constructed)
            {
                throw new IOException("indefinite length primitive encoding encountered");
            }
            
            return readIndef(tag);
        }

        if (constructed)
        {
            switch (tag)
            {
                case DERTags.SET:
                    return new DERSetParser(this);
                case DERTags.SEQUENCE:
                    return new DERSequenceParser(this);
                case DERTags.OCTET_STRING:
                    return new BEROctetStringParser(this);
            }
        }
        else
        {
            switch (tag)
            {
                case DERTags.SET:
                    throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
                case DERTags.SEQUENCE:
                    throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
                case DERTags.OCTET_STRING:
                    return new DEROctetStringParser((DefiniteLengthInputStream)_in);
            }
        }

        // TODO ASN1Exception
        throw new RuntimeException("implicit tagging not implemented");
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.858 -0500", hash_original_method = "52179F915187689C742CC095EFF2DB0F", hash_generated_method = "6EBBC96986A4DF17FEF4820E878DDFC1")
    
DERObject readTaggedObject(boolean constructed, int tag) throws IOException
    {
        if (!constructed)
        {
            // Note: !CONSTRUCTED => IMPLICIT
            DefiniteLengthInputStream defIn = (DefiniteLengthInputStream)_in;
            return new DERTaggedObject(false, tag, new DEROctetString(defIn.toByteArray()));
        }

        ASN1EncodableVector v = readVector();

        if (_in instanceof IndefiniteLengthInputStream)
        {
            return v.size() == 1
                ?   new BERTaggedObject(true, tag, v.get(0))
                :   new BERTaggedObject(false, tag, BERFactory.createSequence(v));
        }

        return v.size() == 1
            ?   new DERTaggedObject(true, tag, v.get(0))
            :   new DERTaggedObject(false, tag, DERFactory.createSequence(v));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.862 -0500", hash_original_method = "8294A0F9B070E477A3BFFFBCF1187D7F", hash_generated_method = "C4E1948F478189E4460B57988A21D92F")
    
public DEREncodable readObject()
        throws IOException
    {
        int tag = _in.read();
        if (tag == -1)
        {
            return null;
        }

        //
        // turn of looking for "00" while we resolve the tag
        //
        set00Check(false);

        //
        // calculate tag number
        //
        int tagNo = ASN1InputStream.readTagNumber(_in, tag);

        boolean isConstructed = (tag & DERTags.CONSTRUCTED) != 0;

        //
        // calculate length
        //
        int length = ASN1InputStream.readLength(_in, _limit);

        if (length < 0) // indefinite length method
        {
            if (!isConstructed)
            {
                throw new IOException("indefinite length primitive encoding encountered");
            }

            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(_in, _limit);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, _limit);

            if ((tag & DERTags.APPLICATION) != 0)
            {
                return new BERApplicationSpecificParser(tagNo, sp);
            }

            if ((tag & DERTags.TAGGED) != 0)
            {
                return new BERTaggedObjectParser(true, tagNo, sp);
            }

            return sp.readIndef(tagNo);
        }
        else
        {
            DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(_in, length);

            if ((tag & DERTags.APPLICATION) != 0)
            {
                return new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
            }

            if ((tag & DERTags.TAGGED) != 0)
            {
                return new BERTaggedObjectParser(isConstructed, tagNo, new ASN1StreamParser(defIn));
            }

            if (isConstructed)
            {
                // TODO There are other tags that may be constructed (e.g. BIT_STRING)
                switch (tagNo)
                {
                    case DERTags.OCTET_STRING:
                        //
                        // yes, people actually do this...
                        //
                        return new BEROctetStringParser(new ASN1StreamParser(defIn));
                    case DERTags.SEQUENCE:
                        return new DERSequenceParser(new ASN1StreamParser(defIn));
                    case DERTags.SET:
                        return new DERSetParser(new ASN1StreamParser(defIn));
                    case DERTags.EXTERNAL:
                        return new DERExternalParser(new ASN1StreamParser(defIn));
                    default:
                        // TODO Add DERUnknownTagParser class?
                        return new DERUnknownTag(true, tagNo, defIn.toByteArray());
                }
            }

            // Some primitive encodings can be handled by parsers too...
            switch (tagNo)
            {
                case DERTags.OCTET_STRING:
                    return new DEROctetStringParser(defIn);
            }

            try
            {
                return ASN1InputStream.createPrimitiveDERObject(tagNo, defIn.toByteArray());
            }
            catch (IllegalArgumentException e)
            {
                throw new ASN1Exception("corrupted stream detected", e);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.865 -0500", hash_original_method = "4F333A451CCAA8C49D86BC8C0430A606", hash_generated_method = "40DC3822BFE66D04E675FE3600FC1C84")
    
private void set00Check(boolean enabled)
    {
        if (_in instanceof IndefiniteLengthInputStream)
        {
            ((IndefiniteLengthInputStream)_in).setEofOn00(enabled);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.867 -0500", hash_original_method = "0431F63F80CE6652BCE08CECE2E42AA0", hash_generated_method = "0431F63F80CE6652BCE08CECE2E42AA0")
    
ASN1EncodableVector readVector() throws IOException
    {
        ASN1EncodableVector v = new ASN1EncodableVector();

        DEREncodable obj;
        while ((obj = readObject()) != null)
        {
            if (obj instanceof InMemoryRepresentable)
            {
                v.add(((InMemoryRepresentable)obj).getLoadedObject());
            }
            else
            {
                v.add(obj.getDERObject());
            }
        }

        return v;
    }
    
}

