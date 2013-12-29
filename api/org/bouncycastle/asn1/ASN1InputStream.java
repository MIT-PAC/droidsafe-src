package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bouncycastle.util.io.Streams;




public class ASN1InputStream extends FilterInputStream implements DERTags {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.283 -0500", hash_original_method = "56C5DD58FFCBA746AFAAE3CCE77D0D4C", hash_generated_method = "2EFE9504CAEE1F28DAD59FA269FE7C96")
    static int findLimit(InputStream in)
    {
        if (in instanceof LimitedInputStream)
        {
            return ((LimitedInputStream)in).getRemaining();
        }
        else if (in instanceof ByteArrayInputStream)
        {
            return ((ByteArrayInputStream)in).available();
        }

        return Integer.MAX_VALUE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.294 -0500", hash_original_method = "1DCCD4E2CDE5FA32E7F11DE6F1BB2883", hash_generated_method = "4BD58928B028E7C8B1DD93EDC0FE3668")
    static int readTagNumber(InputStream s, int tag) 
        throws IOException
    {
        int tagNo = tag & 0x1f;

        //
        // with tagged object tag number is bottom 5 bits, or stored at the start of the content
        //
        if (tagNo == 0x1f)
        {
            tagNo = 0;

            int b = s.read();

            // X.690-0207 8.1.2.4.2
            // "c) bits 7 to 1 of the first subsequent octet shall not all be zero."
            if ((b & 0x7f) == 0) // Note: -1 will pass
            {
                throw new IOException("corrupted stream - invalid high tag number found");
            }

            while ((b >= 0) && ((b & 0x80) != 0))
            {
                tagNo |= (b & 0x7f);
                tagNo <<= 7;
                b = s.read();
            }

            if (b < 0)
            {
                throw new EOFException("EOF found inside tag value.");
            }
            
            tagNo |= (b & 0x7f);
        }
        
        return tagNo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.295 -0500", hash_original_method = "63E43EDBC26513D9E818C92C4647F38B", hash_generated_method = "C0D00F990A4CF89576AD099E203B28C4")
    static int readLength(InputStream s, int limit)
        throws IOException
    {
        int length = s.read();
        if (length < 0)
        {
            throw new EOFException("EOF found when length expected");
        }

        if (length == 0x80)
        {
            return -1;      // indefinite-length encoding
        }

        if (length > 127)
        {
            int size = length & 0x7f;

            // Note: The invalid long form "0xff" (see X.690 8.1.3.5c) will be caught here
            if (size > 4)
            {
                throw new IOException("DER length more than 4 bytes: " + size);
            }

            length = 0;
            for (int i = 0; i < size; i++)
            {
                int next = s.read();

                if (next < 0)
                {
                    throw new EOFException("EOF found reading length");
                }

                length = (length << 8) + next;
            }

            if (length < 0)
            {
                throw new IOException("corrupted stream - negative length found");
            }

            if (length >= limit)   // after all we must have read at least 1 byte
            {
                throw new IOException("corrupted stream - out of bounds length found");
            }
        }

        return length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.296 -0500", hash_original_method = "D692ED4887C8C432B51B506F951E79C0", hash_generated_method = "14D5E0AE02194870EE4AEEDF65AA7B8C")
    static DERObject createPrimitiveDERObject(
        int     tagNo,
        byte[]  bytes)
    {
        switch (tagNo)
        {
            case BIT_STRING:
                return DERBitString.fromOctetString(bytes);
            case BMP_STRING:
                return new DERBMPString(bytes);
            case BOOLEAN:
                // BEGIN android-changed
                return DERBoolean.getInstance(bytes);
                // END android-changed
            case ENUMERATED:
                return new ASN1Enumerated(bytes);
            case GENERALIZED_TIME:
                return new ASN1GeneralizedTime(bytes);
            case GENERAL_STRING:
                return new DERGeneralString(bytes);
            case IA5_STRING:
                return new DERIA5String(bytes);
            case INTEGER:
                return new ASN1Integer(bytes);
            case NULL:
                return DERNull.INSTANCE;   // actual content is ignored (enforce 0 length?)
            case NUMERIC_STRING:
                return new DERNumericString(bytes);
            case OBJECT_IDENTIFIER:
                return new ASN1ObjectIdentifier(bytes);
            case OCTET_STRING:
                return new DEROctetString(bytes);
            case PRINTABLE_STRING:
                return new DERPrintableString(bytes);
            case T61_STRING:
                return new DERT61String(bytes);
            case UNIVERSAL_STRING:
                return new DERUniversalString(bytes);
            case UTC_TIME:
                return new ASN1UTCTime(bytes);
            case UTF8_STRING:
                return new DERUTF8String(bytes);
            case VISIBLE_STRING:
                return new DERVisibleString(bytes);
            default:
                return new DERUnknownTag(false, tagNo, bytes);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.281 -0500", hash_original_field = "136FDC88CA742E83C109AD31983DA2BF", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private  int limit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.282 -0500", hash_original_field = "11614E2594037FAB52150874C7E95CCD", hash_generated_field = "479E5A76190EF85C722BCE9E91B363C1")

    private  boolean lazyEvaluate;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.284 -0500", hash_original_method = "A509F95CC009C058902019FB1EA46111", hash_generated_method = "BA3E4D0FD6E7D5DDB1E283FEFA913242")
    public ASN1InputStream(
        InputStream is)
    {
        this(is, findLimit(is));
    }

    /**
     * Create an ASN1InputStream based on the input byte array. The length of DER objects in
     * the stream is automatically limited to the length of the input array.
     * 
     * @param input array containing ASN.1 encoded data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.285 -0500", hash_original_method = "00EF7E908C3752F726679FF101FABBAF", hash_generated_method = "0858B38F2818FEC2F00BB6525F26816C")
    public ASN1InputStream(
        byte[] input)
    {
        this(new ByteArrayInputStream(input), input.length);
    }

    /**
     * Create an ASN1InputStream based on the input byte array. The length of DER objects in
     * the stream is automatically limited to the length of the input array.
     *
     * @param input array containing ASN.1 encoded data.
     * @param lazyEvaluate true if parsing inside constructed objects can be delayed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.286 -0500", hash_original_method = "B0ECE654E14AB45AF60FAFEB349CC4AF", hash_generated_method = "FBBFE33036216904AA78E9E00D413B8F")
    public ASN1InputStream(
        byte[] input,
        boolean lazyEvaluate)
    {
        this(new ByteArrayInputStream(input), input.length, lazyEvaluate);
    }
    
    /**
     * Create an ASN1InputStream where no DER object will be longer than limit.
     * 
     * @param input stream containing ASN.1 encoded data.
     * @param limit maximum size of a DER encoded object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.287 -0500", hash_original_method = "EDCCEC3121F6C5E9B0FA391DCCD578AC", hash_generated_method = "42BD6C6AD200AF45DBF1A2C083230116")
    public ASN1InputStream(
        InputStream input,
        int         limit)
    {
        this(input, limit, false);
    }

    /**
     * Create an ASN1InputStream where no DER object will be longer than limit, and constructed
     * objects such as sequences will be parsed lazily.
     *
     * @param input stream containing ASN.1 encoded data.
     * @param limit maximum size of a DER encoded object.
     * @param lazyEvaluate true if parsing inside constructed objects can be delayed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.288 -0500", hash_original_method = "B7677C48F68A4418B50D4EB3534A5CED", hash_generated_method = "2E8AC4FC6D94F381FAC5EA98D7D7234A")
    public ASN1InputStream(
        InputStream input,
        int         limit,
        boolean     lazyEvaluate)
    {
        super(input);
        this.limit = limit;
        this.lazyEvaluate = lazyEvaluate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.289 -0500", hash_original_method = "CF3BC7CE74758708D5C7508F6ABCFCEC", hash_generated_method = "814F65BD9EF77ECB672C4B678F0E4C4C")
    protected int readLength()
        throws IOException
    {
        return readLength(this, limit);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.289 -0500", hash_original_method = "BA47F8F31DF51652E381DF5AC1EDFDE7", hash_generated_method = "05FFB8CA5C4AE1C1968D573832C8E3E0")
    protected void readFully(
        byte[]  bytes)
        throws IOException
    {
        if (Streams.readFully(this, bytes) != bytes.length)
        {
            throw new EOFException("EOF encountered in middle of object");
        }
    }

    /**
     * build an object given its tag and the number of bytes to construct it from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.290 -0500", hash_original_method = "FB275304C6A60067CFDA4B800CA085AD", hash_generated_method = "B0D60E7C0E7958119A198825437CB9DE")
    protected DERObject buildObject(
        int       tag,
        int       tagNo,
        int       length)
        throws IOException
    {
        boolean isConstructed = (tag & CONSTRUCTED) != 0;

        DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(this, length);

        if ((tag & APPLICATION) != 0)
        {
            return new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
        }

        if ((tag & TAGGED) != 0)
        {
            return new ASN1StreamParser(defIn).readTaggedObject(isConstructed, tagNo);
        }

        if (isConstructed)
        {
            // TODO There are other tags that may be constructed (e.g. BIT_STRING)
            switch (tagNo)
            {
                case OCTET_STRING:
                    //
                    // yes, people actually do this...
                    //
                    return new BERConstructedOctetString(buildDEREncodableVector(defIn).v);
                case SEQUENCE:
                    if (lazyEvaluate)
                    {
                        return new LazyDERSequence(defIn.toByteArray());
                    }
                    else
                    {
                        return DERFactory.createSequence(buildDEREncodableVector(defIn));   
                    }
                case SET:
                    return DERFactory.createSet(buildDEREncodableVector(defIn), false);
                case EXTERNAL:
                    return new DERExternal(buildDEREncodableVector(defIn));                
                default:
                    return new DERUnknownTag(true, tagNo, defIn.toByteArray());
            }
        }

        return createPrimitiveDERObject(tagNo, defIn.toByteArray());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.291 -0500", hash_original_method = "3644C80D3B1C21E0DE1F50623D57B77E", hash_generated_method = "3644C80D3B1C21E0DE1F50623D57B77E")
    ASN1EncodableVector buildEncodableVector()
        throws IOException
    {
        ASN1EncodableVector v = new ASN1EncodableVector();
        DERObject o;

        while ((o = readObject()) != null)
        {
            v.add(o);
        }

        return v;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.292 -0500", hash_original_method = "758DE99B8F596F62A95AD037BCF1A83C", hash_generated_method = "758DE99B8F596F62A95AD037BCF1A83C")
    ASN1EncodableVector buildDEREncodableVector(
        DefiniteLengthInputStream dIn) throws IOException
    {
        return new ASN1InputStream(dIn).buildEncodableVector();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:50.293 -0500", hash_original_method = "14F17C52EA17CC32DA8A973E14D77B9E", hash_generated_method = "CB1662CDD04B84BA10F754CA5AEDFA95")
    public DERObject readObject()
        throws IOException
    {
        int tag = read();
        if (tag <= 0)
        {
            if (tag == 0)
            {
                throw new IOException("unexpected end-of-contents marker");
            }

            return null;
        }

        //
        // calculate tag number
        //
        int tagNo = readTagNumber(this, tag);

        boolean isConstructed = (tag & CONSTRUCTED) != 0;

        //
        // calculate length
        //
        int length = readLength();

        if (length < 0) // indefinite length method
        {
            if (!isConstructed)
            {
                throw new IOException("indefinite length primitive encoding encountered");
            }

            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(this, limit);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, limit);

            if ((tag & APPLICATION) != 0)
            {
                return new BERApplicationSpecificParser(tagNo, sp).getLoadedObject();
            }

            if ((tag & TAGGED) != 0)
            {
                return new BERTaggedObjectParser(true, tagNo, sp).getLoadedObject();
            }

            // TODO There are other tags that may be constructed (e.g. BIT_STRING)
            switch (tagNo)
            {
                case OCTET_STRING:
                    return new BEROctetStringParser(sp).getLoadedObject();
                case SEQUENCE:
                    return new BERSequenceParser(sp).getLoadedObject();
                case SET:
                    return new BERSetParser(sp).getLoadedObject();
                case EXTERNAL:
                    return new DERExternalParser(sp).getLoadedObject();
                default:
                    throw new IOException("unknown BER object encountered");
            }
        }
        else
        {
            try
            {
                return buildObject(tag, tagNo, length);
            }
            catch (IllegalArgumentException e)
            {
                throw new ASN1Exception("corrupted stream detected", e);
            }
        }
    }

    
}

