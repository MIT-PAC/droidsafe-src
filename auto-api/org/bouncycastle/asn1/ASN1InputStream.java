package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream implements DERTags {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.869 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.869 -0400", hash_original_field = "677A3369D53E6980D2B72D680BD4755C", hash_generated_field = "479E5A76190EF85C722BCE9E91B363C1")

    private boolean lazyEvaluate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.871 -0400", hash_original_method = "A509F95CC009C058902019FB1EA46111", hash_generated_method = "712E96BD7D3E62F77404E58E95566D4B")
    public  ASN1InputStream(
        InputStream is) {
        this(is, findLimit(is));
        addTaint(is.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.872 -0400", hash_original_method = "00EF7E908C3752F726679FF101FABBAF", hash_generated_method = "3463856FAA2DB77D2CE4E16A57C8AE31")
    public  ASN1InputStream(
        byte[] input) {
        this(new ByteArrayInputStream(input), input.length);
        addTaint(input[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.874 -0400", hash_original_method = "B0ECE654E14AB45AF60FAFEB349CC4AF", hash_generated_method = "D55842404E18CAF7EE185C1B0387A1D0")
    public  ASN1InputStream(
        byte[] input,
        boolean lazyEvaluate) {
        this(new ByteArrayInputStream(input), input.length, lazyEvaluate);
        addTaint(input[0]);
        addTaint(lazyEvaluate);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.875 -0400", hash_original_method = "EDCCEC3121F6C5E9B0FA391DCCD578AC", hash_generated_method = "F776935DC3708D07DBD0165894BAE729")
    public  ASN1InputStream(
        InputStream input,
        int         limit) {
        this(input, limit, false);
        addTaint(input.getTaint());
        addTaint(limit);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.876 -0400", hash_original_method = "B7677C48F68A4418B50D4EB3534A5CED", hash_generated_method = "B052FF37F1736B0FA46C2A76485BAB38")
    public  ASN1InputStream(
        InputStream input,
        int         limit,
        boolean     lazyEvaluate) {
        super(input);
        this.limit = limit;
        this.lazyEvaluate = lazyEvaluate;
        addTaint(input.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.876 -0400", hash_original_method = "CF3BC7CE74758708D5C7508F6ABCFCEC", hash_generated_method = "F249F1FC182FFE507585B476EA125C66")
    protected int readLength() throws IOException {
        int varFC54B06A18C5F743D076DE1A30D2E8CA_464363553 = (readLength(this, limit));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929009657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929009657;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.877 -0400", hash_original_method = "BA47F8F31DF51652E381DF5AC1EDFDE7", hash_generated_method = "54D5078B5F78A9DACBC7856BC77E69FD")
    protected void readFully(
        byte[]  bytes) throws IOException {
        {
            boolean var011D91AC74BB7BF8D52D2193E1C46108_842887630 = (Streams.readFully(this, bytes) != bytes.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException("EOF encountered in middle of object");
            } 
        } 
        addTaint(bytes[0]);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.877 -0400", hash_original_method = "FB275304C6A60067CFDA4B800CA085AD", hash_generated_method = "6F938048964F7BFA71C0E03CC3477FA7")
    protected DERObject buildObject(
        int       tag,
        int       tagNo,
        int       length) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1744970237 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1165734597 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_352796934 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_51861899 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1293107389 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2013140273 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1604564340 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1174394075 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2094822087 = null; 
        boolean isConstructed = (tag & CONSTRUCTED) != 0;
        DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(this, length);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1744970237 = new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1165734597 = new ASN1StreamParser(defIn).readTaggedObject(isConstructed, tagNo);
        } 
        {
            
            varB4EAC82CA7396A68D541C85D26508E83_352796934 = new BERConstructedOctetString(buildDEREncodableVector(defIn).v);
            
            
            {
                varB4EAC82CA7396A68D541C85D26508E83_51861899 = new LazyDERSequence(defIn.toByteArray());
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1293107389 = DERFactory.createSequence(buildDEREncodableVector(defIn));
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_2013140273 = DERFactory.createSet(buildDEREncodableVector(defIn), false);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1604564340 = new DERExternal(buildDEREncodableVector(defIn));
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1174394075 = new DERUnknownTag(true, tagNo, defIn.toByteArray());
            
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2094822087 = createPrimitiveDERObject(tagNo, defIn.toByteArray());
        addTaint(tag);
        addTaint(tagNo);
        addTaint(length);
        DERObject varA7E53CE21691AB073D9660D615818899_830254886; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_1744970237;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_1165734597;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_352796934;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_51861899;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_1293107389;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_2013140273;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_1604564340;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_1174394075;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_830254886 = varB4EAC82CA7396A68D541C85D26508E83_2094822087;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_830254886.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_830254886;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.878 -0400", hash_original_method = "3644C80D3B1C21E0DE1F50623D57B77E", hash_generated_method = "E84C8F1432D410654782CCB0881C5808")
     ASN1EncodableVector buildEncodableVector() throws IOException {
        ASN1EncodableVector varB4EAC82CA7396A68D541C85D26508E83_45290143 = null; 
        ASN1EncodableVector v = new ASN1EncodableVector();
        DERObject o;
        {
            boolean var1E1A0CFD9EF9D741150732B571DE4596_116528186 = ((o = readObject()) != null);
            {
                v.add(o);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_45290143 = v;
        varB4EAC82CA7396A68D541C85D26508E83_45290143.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_45290143;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.878 -0400", hash_original_method = "758DE99B8F596F62A95AD037BCF1A83C", hash_generated_method = "AF9CA2358AA510706F294449D89A6378")
     ASN1EncodableVector buildDEREncodableVector(
        DefiniteLengthInputStream dIn) throws IOException {
        ASN1EncodableVector varB4EAC82CA7396A68D541C85D26508E83_1093366288 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1093366288 = new ASN1InputStream(dIn).buildEncodableVector();
        addTaint(dIn.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1093366288.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1093366288;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.879 -0400", hash_original_method = "14F17C52EA17CC32DA8A973E14D77B9E", hash_generated_method = "D74E3FC7E8B0F9A455CC2B55D9EA349A")
    public DERObject readObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_358428242 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_587120542 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2105385923 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_163828216 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_328179564 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1322065336 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_743533586 = null; 
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1463793807 = null; 
        int tag = read();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("unexpected end-of-contents marker");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_358428242 = null;
        } 
        int tagNo = readTagNumber(this, tag);
        boolean isConstructed = (tag & CONSTRUCTED) != 0;
        int length = readLength();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("indefinite length primitive encoding encountered");
            } 
            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(this, limit);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, limit);
            {
                varB4EAC82CA7396A68D541C85D26508E83_587120542 = new BERApplicationSpecificParser(tagNo, sp).getLoadedObject();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2105385923 = new BERTaggedObjectParser(true, tagNo, sp).getLoadedObject();
            } 
            
            varB4EAC82CA7396A68D541C85D26508E83_163828216 = new BEROctetStringParser(sp).getLoadedObject();
            
            
            varB4EAC82CA7396A68D541C85D26508E83_328179564 = new BERSequenceParser(sp).getLoadedObject();
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1322065336 = new BERSetParser(sp).getLoadedObject();
            
            
            varB4EAC82CA7396A68D541C85D26508E83_743533586 = new DERExternalParser(sp).getLoadedObject();
            
            
            if (DroidSafeAndroidRuntime.control) throw new IOException("unknown BER object encountered");
            
        } 
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1463793807 = buildObject(tag, tagNo, length);
            } 
            catch (IllegalArgumentException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("corrupted stream detected", e);
            } 
        } 
        DERObject varA7E53CE21691AB073D9660D615818899_1469711084; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_358428242;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_587120542;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_2105385923;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_163828216;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_328179564;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_1322065336;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_743533586;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1469711084 = varB4EAC82CA7396A68D541C85D26508E83_1463793807;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1469711084.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1469711084;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

