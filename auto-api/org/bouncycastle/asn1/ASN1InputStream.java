package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream implements DERTags {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.731 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.731 -0400", hash_original_field = "677A3369D53E6980D2B72D680BD4755C", hash_generated_field = "479E5A76190EF85C722BCE9E91B363C1")

    private boolean lazyEvaluate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.734 -0400", hash_original_method = "A509F95CC009C058902019FB1EA46111", hash_generated_method = "712E96BD7D3E62F77404E58E95566D4B")
    public  ASN1InputStream(
        InputStream is) {
        this(is, findLimit(is));
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.734 -0400", hash_original_method = "00EF7E908C3752F726679FF101FABBAF", hash_generated_method = "3463856FAA2DB77D2CE4E16A57C8AE31")
    public  ASN1InputStream(
        byte[] input) {
        this(new ByteArrayInputStream(input), input.length);
        addTaint(input[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.735 -0400", hash_original_method = "B0ECE654E14AB45AF60FAFEB349CC4AF", hash_generated_method = "D55842404E18CAF7EE185C1B0387A1D0")
    public  ASN1InputStream(
        byte[] input,
        boolean lazyEvaluate) {
        this(new ByteArrayInputStream(input), input.length, lazyEvaluate);
        addTaint(input[0]);
        addTaint(lazyEvaluate);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.735 -0400", hash_original_method = "EDCCEC3121F6C5E9B0FA391DCCD578AC", hash_generated_method = "F776935DC3708D07DBD0165894BAE729")
    public  ASN1InputStream(
        InputStream input,
        int         limit) {
        this(input, limit, false);
        addTaint(input.getTaint());
        addTaint(limit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.736 -0400", hash_original_method = "B7677C48F68A4418B50D4EB3534A5CED", hash_generated_method = "B052FF37F1736B0FA46C2A76485BAB38")
    public  ASN1InputStream(
        InputStream input,
        int         limit,
        boolean     lazyEvaluate) {
        super(input);
        this.limit = limit;
        this.lazyEvaluate = lazyEvaluate;
        addTaint(input.getTaint());
        // ---------- Original Method ----------
        //this.limit = limit;
        //this.lazyEvaluate = lazyEvaluate;
    }

    
        static int findLimit(InputStream in) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.736 -0400", hash_original_method = "CF3BC7CE74758708D5C7508F6ABCFCEC", hash_generated_method = "84A0B1DE62C6ED51AFC1E433C792EE6D")
    protected int readLength() throws IOException {
        int varFC54B06A18C5F743D076DE1A30D2E8CA_1591088362 = (readLength(this, limit));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592486226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592486226;
        // ---------- Original Method ----------
        //return readLength(this, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.737 -0400", hash_original_method = "BA47F8F31DF51652E381DF5AC1EDFDE7", hash_generated_method = "D25B242C610F1061D3D6849C357E21B1")
    protected void readFully(
        byte[]  bytes) throws IOException {
        {
            boolean var011D91AC74BB7BF8D52D2193E1C46108_394723371 = (Streams.readFully(this, bytes) != bytes.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException("EOF encountered in middle of object");
            } //End block
        } //End collapsed parenthetic
        addTaint(bytes[0]);
        // ---------- Original Method ----------
        //if (Streams.readFully(this, bytes) != bytes.length)
        //{
            //throw new EOFException("EOF encountered in middle of object");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.739 -0400", hash_original_method = "FB275304C6A60067CFDA4B800CA085AD", hash_generated_method = "A1834B00800C3096631FB34D964F09CA")
    protected DERObject buildObject(
        int       tag,
        int       tagNo,
        int       length) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_261924516 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1761238745 = null; //Variable for return #2
        DERObject varB4EAC82CA7396A68D541C85D26508E83_542823765 = null; //Variable for return #3
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1456973254 = null; //Variable for return #4
        DERObject varB4EAC82CA7396A68D541C85D26508E83_815502039 = null; //Variable for return #5
        DERObject varB4EAC82CA7396A68D541C85D26508E83_877155487 = null; //Variable for return #6
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1439638418 = null; //Variable for return #7
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1408520259 = null; //Variable for return #8
        DERObject varB4EAC82CA7396A68D541C85D26508E83_173600253 = null; //Variable for return #9
        boolean isConstructed;
        isConstructed = (tag & CONSTRUCTED) != 0;
        DefiniteLengthInputStream defIn;
        defIn = new DefiniteLengthInputStream(this, length);
        {
            varB4EAC82CA7396A68D541C85D26508E83_261924516 = new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1761238745 = new ASN1StreamParser(defIn).readTaggedObject(isConstructed, tagNo);
        } //End block
        {
            //Begin case OCTET_STRING 
            varB4EAC82CA7396A68D541C85D26508E83_542823765 = new BERConstructedOctetString(buildDEREncodableVector(defIn).v);
            //End case OCTET_STRING 
            //Begin case SEQUENCE 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1456973254 = new LazyDERSequence(defIn.toByteArray());
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_815502039 = DERFactory.createSequence(buildDEREncodableVector(defIn));
            } //End block
            //End case SEQUENCE 
            //Begin case SET 
            varB4EAC82CA7396A68D541C85D26508E83_877155487 = DERFactory.createSet(buildDEREncodableVector(defIn), false);
            //End case SET 
            //Begin case EXTERNAL 
            varB4EAC82CA7396A68D541C85D26508E83_1439638418 = new DERExternal(buildDEREncodableVector(defIn));
            //End case EXTERNAL 
            //Begin case default 
            varB4EAC82CA7396A68D541C85D26508E83_1408520259 = new DERUnknownTag(true, tagNo, defIn.toByteArray());
            //End case default 
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_173600253 = createPrimitiveDERObject(tagNo, defIn.toByteArray());
        addTaint(tag);
        addTaint(tagNo);
        addTaint(length);
        DERObject varA7E53CE21691AB073D9660D615818899_513228530; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_261924516;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_1761238745;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_542823765;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_1456973254;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_815502039;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_877155487;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_1439638418;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_1408520259;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_513228530 = varB4EAC82CA7396A68D541C85D26508E83_173600253;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_513228530.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_513228530;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.741 -0400", hash_original_method = "3644C80D3B1C21E0DE1F50623D57B77E", hash_generated_method = "9BCC4B97C4967BBD2B8E3366B8AC2951")
     ASN1EncodableVector buildEncodableVector() throws IOException {
        ASN1EncodableVector varB4EAC82CA7396A68D541C85D26508E83_1611587018 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        DERObject o;
        {
            boolean var1E1A0CFD9EF9D741150732B571DE4596_424758240 = ((o = readObject()) != null);
            {
                v.add(o);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1611587018 = v;
        varB4EAC82CA7396A68D541C85D26508E83_1611587018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1611587018;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //DERObject o;
        //while ((o = readObject()) != null)
        //{
            //v.add(o);
        //}
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.758 -0400", hash_original_method = "758DE99B8F596F62A95AD037BCF1A83C", hash_generated_method = "EFA0195ABFBA5AE6E2FAE981BC415E55")
     ASN1EncodableVector buildDEREncodableVector(
        DefiniteLengthInputStream dIn) throws IOException {
        ASN1EncodableVector varB4EAC82CA7396A68D541C85D26508E83_1624570618 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1624570618 = new ASN1InputStream(dIn).buildEncodableVector();
        addTaint(dIn.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1624570618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1624570618;
        // ---------- Original Method ----------
        //return new ASN1InputStream(dIn).buildEncodableVector();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.773 -0400", hash_original_method = "14F17C52EA17CC32DA8A973E14D77B9E", hash_generated_method = "07AA3D21EEC97F907F1332CB7E764633")
    public DERObject readObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_534457758 = null; //Variable for return #1
        DERObject varB4EAC82CA7396A68D541C85D26508E83_169060811 = null; //Variable for return #2
        DERObject varB4EAC82CA7396A68D541C85D26508E83_650942777 = null; //Variable for return #3
        DERObject varB4EAC82CA7396A68D541C85D26508E83_315213767 = null; //Variable for return #4
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1920639250 = null; //Variable for return #5
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1281702429 = null; //Variable for return #6
        DERObject varB4EAC82CA7396A68D541C85D26508E83_33822616 = null; //Variable for return #7
        DERObject varB4EAC82CA7396A68D541C85D26508E83_610916340 = null; //Variable for return #8
        int tag;
        tag = read();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected end-of-contents marker");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_534457758 = null;
        } //End block
        int tagNo;
        tagNo = readTagNumber(this, tag);
        boolean isConstructed;
        isConstructed = (tag & CONSTRUCTED) != 0;
        int length;
        length = readLength();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("indefinite length primitive encoding encountered");
            } //End block
            IndefiniteLengthInputStream indIn;
            indIn = new IndefiniteLengthInputStream(this, limit);
            ASN1StreamParser sp;
            sp = new ASN1StreamParser(indIn, limit);
            {
                varB4EAC82CA7396A68D541C85D26508E83_169060811 = new BERApplicationSpecificParser(tagNo, sp).getLoadedObject();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_650942777 = new BERTaggedObjectParser(true, tagNo, sp).getLoadedObject();
            } //End block
            //Begin case OCTET_STRING 
            varB4EAC82CA7396A68D541C85D26508E83_315213767 = new BEROctetStringParser(sp).getLoadedObject();
            //End case OCTET_STRING 
            //Begin case SEQUENCE 
            varB4EAC82CA7396A68D541C85D26508E83_1920639250 = new BERSequenceParser(sp).getLoadedObject();
            //End case SEQUENCE 
            //Begin case SET 
            varB4EAC82CA7396A68D541C85D26508E83_1281702429 = new BERSetParser(sp).getLoadedObject();
            //End case SET 
            //Begin case EXTERNAL 
            varB4EAC82CA7396A68D541C85D26508E83_33822616 = new DERExternalParser(sp).getLoadedObject();
            //End case EXTERNAL 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IOException("unknown BER object encountered");
            //End case default 
        } //End block
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_610916340 = buildObject(tag, tagNo, length);
            } //End block
            catch (IllegalArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("corrupted stream detected", e);
            } //End block
        } //End block
        DERObject varA7E53CE21691AB073D9660D615818899_72962016; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_534457758;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_169060811;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_650942777;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_315213767;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_1920639250;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_1281702429;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_33822616;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_72962016 = varB4EAC82CA7396A68D541C85D26508E83_610916340;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_72962016.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_72962016;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static int readTagNumber(InputStream s, int tag) throws IOException {
        int tagNo = tag & 0x1f;
        if (tagNo == 0x1f)
        {
            tagNo = 0;
            int b = s.read();
            if ((b & 0x7f) == 0) 
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

    
        static int readLength(InputStream s, int limit) throws IOException {
        int length = s.read();
        if (length < 0)
        {
            throw new EOFException("EOF found when length expected");
        }
        if (length == 0x80)
        {
            return -1;      
        }
        if (length > 127)
        {
            int size = length & 0x7f;
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
            if (length >= limit)   
            {
                throw new IOException("corrupted stream - out of bounds length found");
            }
        }
        return length;
    }

    
        static DERObject createPrimitiveDERObject(
        int     tagNo,
        byte[]  bytes) {
        switch (tagNo)
        {
            case BIT_STRING:
                return DERBitString.fromOctetString(bytes);
            case BMP_STRING:
                return new DERBMPString(bytes);
            case BOOLEAN:
                return DERBoolean.getInstance(bytes);
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
                return DERNull.INSTANCE;   
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

    
}

