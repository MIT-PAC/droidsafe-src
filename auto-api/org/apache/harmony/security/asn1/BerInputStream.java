package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BerInputStream {
    private final InputStream in;
    protected byte[] buffer;
    protected int offset = 0;
    private static final int BUF_INCREASE_SIZE = 1024 * 16;
    protected static final int INDEFINIT_LENGTH = -1;
    public int tag;
    protected int length;
    public Object content;
    protected int tagOffset;
    protected int contentOffset;
    public int choiceIndex;
    public int[] times;
    public int oidElement;
    protected boolean isVerify;
    protected boolean isIndefinedLength;
    private Object[][] pool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.692 -0400", hash_original_method = "879F2FC8DE697B067D571C3BF31ADD98", hash_generated_method = "B04472EDE478FFC6BAC4B9EEC87D0B0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BerInputStream(byte[] encoded) throws IOException {
        this(encoded, 0, encoded.length);
        dsTaint.addTaint(encoded);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.692 -0400", hash_original_method = "FB2C80FA06C3B0FD8EA5024440AD49C3", hash_generated_method = "9D3795A013FD9D17D5011E9AD437E58A")
    @DSModeled(DSC.SAFE)
    public BerInputStream(byte[] encoded, int offset, int expectedLength) throws IOException {
        dsTaint.addTaint(expectedLength);
        dsTaint.addTaint(encoded);
        dsTaint.addTaint(offset);
        this.in = null;
        next();
        {
            throw new ASN1Exception("Wrong content length");
        } //End block
        // ---------- Original Method ----------
        //this.in = null;
        //this.buffer = encoded;
        //this.offset = offset;
        //next();
        //if (length != INDEFINIT_LENGTH
                //&& (offset + expectedLength) != (this.offset + this.length)) {
            //throw new ASN1Exception("Wrong content length");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.692 -0400", hash_original_method = "43063225C34584E29FE6185CE8AAB05D", hash_generated_method = "B6491FB9A31CE16B15C889E70E1B32E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BerInputStream(InputStream in) throws IOException {
        this(in, BUF_INCREASE_SIZE);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.692 -0400", hash_original_method = "ED7F15B5071BF063BB4017E313468A57", hash_generated_method = "F364192B4F8D3FE70EB9683882D9E0CB")
    @DSModeled(DSC.SAFE)
    public BerInputStream(InputStream in, int initialSize) throws IOException {
        dsTaint.addTaint(initialSize);
        dsTaint.addTaint(in.dsTaint);
        buffer = new byte[initialSize];
        next();
        {
            {
                byte[] newBuffer;
                newBuffer = new byte[length + offset];
                System.arraycopy(buffer, 0, newBuffer, 0, offset);
                buffer = newBuffer;
            } //End block
        } //End block
        {
            isIndefinedLength = true;
            throw new ASN1Exception("Decoding indefinite length encoding is not supported");
        } //End block
        // ---------- Original Method ----------
        //this.in = in;
        //buffer = new byte[initialSize];
        //next();
        //if (length != INDEFINIT_LENGTH) {
            //if (buffer.length < (length + offset)) {
                //byte[] newBuffer = new byte[length + offset];
                //System.arraycopy(buffer, 0, newBuffer, 0, offset);
                //buffer = newBuffer;
            //}
        //} else {
            //isIndefinedLength = true;
            //throw new ASN1Exception("Decoding indefinite length encoding is not supported");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.692 -0400", hash_original_method = "4CCBB4621387969DDD8BDCB7ADDE8473", hash_generated_method = "8261ECD2C78A5C458C99E780D65E5B1C")
    @DSModeled(DSC.SAFE)
    public final void reset(byte[] encoded) throws IOException {
        dsTaint.addTaint(encoded);
        next();
        // ---------- Original Method ----------
        //buffer = encoded;
        //next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.692 -0400", hash_original_method = "E21A3F5A1E5C42E0733DFCD7E2B1A37B", hash_generated_method = "C15AFD9D91DC8BD57BB2D17A6EB1EB03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int next() throws IOException {
        tagOffset = offset;
        tag = read();
        length = read();
        {
            {
                int numOctets;
                numOctets = length & 0x7F;
                {
                	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Too long encoding at [" + tagOffset + "]");
                } //End block
                length = read();
                {
                    int i;
                    i = 1;
                    {
                        int ch;
                        ch = read();
                        length = (length << 8) + ch;
                    } //End block
                } //End collapsed parenthetic
                {
                	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Too long encoding at [" + tagOffset + "]");
                } //End block
            } //End block
        } //End block
        {
            length = INDEFINIT_LENGTH;
        } //End block
        contentOffset = offset;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.692 -0400", hash_original_method = "0FB1A1C4D911EA5AEA102491DDF03FDC", hash_generated_method = "E755A778E4E44F1166A369813D42A1EA")
    public static int getLength(byte[] encoding) {
        int length = encoding[1] & 0xFF;
        int numOctets = 0;
        if ((length & 0x80) != 0) { 
            numOctets = length & 0x7F;
            length = encoding[2] & 0xFF;
            for (int i = 3; i < numOctets + 2; i++) {
                length = (length << 8) + (encoding[i] & 0xFF);
            }
        }
        return 1 + 1 + numOctets + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.693 -0400", hash_original_method = "A15B72AB03BE363B2B31FA8E7C1F64A3", hash_generated_method = "28A4A2431C556D636929AAD01B8D088A")
    @DSModeled(DSC.SAFE)
    public void readBitString() throws IOException {
        {
            {
            	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Bitstring: wrong length. Tag at [" + tagOffset + "]");
            } //End block
            readContent();
            {
            	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. A number of unused bits MUST be in range 0 to 7");
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. For empty string unused bits MUST be 0");
            } //End block
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 bitstring  type is not provided");
        } //End block
        {
            throw expected("bitstring");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.693 -0400", hash_original_method = "70271B544C5D122FB5ABE2DE9A460926", hash_generated_method = "9120E8151B81025F3C19AAB358E6FC57")
    @DSModeled(DSC.SAFE)
    public void readEnumerated() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("enumerated");
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 enumerated: wrong length for identifier at ["
                    + tagOffset + "]");
        } //End block
        readContent();
        {
            int bits;
            bits = buffer[contentOffset] & 0xFF;
            {
                bits += 0x100;
            } //End block
            {
                throw new ASN1Exception("ASN.1 enumerated: wrong content at [" + contentOffset
                        + "]. An integer MUST be encoded in minimum number of octets");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_ENUM) {
            //throw expected("enumerated");
        //}
        //if (length == 0) {
            //throw new ASN1Exception("ASN.1 enumerated: wrong length for identifier at ["
                    //+ tagOffset + "]");
        //}
        //readContent();
        //if (length > 1) {
            //int bits = buffer[contentOffset] & 0xFF;
            //if (buffer[contentOffset + 1] < 0) {
                //bits += 0x100;
            //}
            //if (bits == 0 || bits == 0x1FF) {
                //throw new ASN1Exception("ASN.1 enumerated: wrong content at [" + contentOffset
                        //+ "]. An integer MUST be encoded in minimum number of octets");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.693 -0400", hash_original_method = "13F2651D91961A81EAE79BEA9D5230AF", hash_generated_method = "573382286708A4FEF41CBD3842A14FE0")
    @DSModeled(DSC.SAFE)
    public void readBoolean() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("boolean");
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong length for ASN.1 boolean at [" + tagOffset + "]");
        } //End block
        readContent();
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_BOOLEAN) {
            //throw expected("boolean");
        //}
        //if (length != 1) {
            //throw new ASN1Exception("Wrong length for ASN.1 boolean at [" + tagOffset + "]");
        //}
        //readContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.693 -0400", hash_original_method = "1A3161CCB7646B7891B929A5396BF673", hash_generated_method = "8F479E2A79BF4D17D70EF32460C26282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readGeneralizedTime() throws IOException {
        {
            readContent();
            {
            	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime: encoded format is not implemented");
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                        + contentOffset + "]");
            } //End block
            {
                byte char14;
                char14 = buffer[contentOffset + 14];
                {
                	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                            + contentOffset + "]");
                } //End block
            } //End block
            {
                times = new int[7];
            } //End block
            times[0] = strToInt(contentOffset, 4);
            times[1] = strToInt(contentOffset + 4, 2);
            times[2] = strToInt(contentOffset + 6, 2);
            times[3] = strToInt(contentOffset + 8, 2);
            times[4] = strToInt(contentOffset + 10, 2);
            times[5] = strToInt(contentOffset + 12, 2);
            {
                times[6] = strToInt(contentOffset + 15, length - 16);
                {
                    times[6] = times[6] * 100;
                } //End block
                {
                    times[6] = times[6] * 10;
                } //End block
            } //End block
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 GeneralizedTime type is not supported");
        } //End block
        {
            throw expected("GeneralizedTime");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.694 -0400", hash_original_method = "D1E9408574A13A490CB1D3EF3A359E97", hash_generated_method = "B3F805A26A037D9444E5BF21853E06F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readUTCTime() throws IOException {
        {
            //Begin case ASN1UTCTime.UTC_LOCAL_HM ASN1UTCTime.UTC_LOCAL_HMS 
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: local time format is not supported");
            //End case ASN1UTCTime.UTC_LOCAL_HM ASN1UTCTime.UTC_LOCAL_HMS 
            //Begin case default 
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: wrong length, identifier at " + tagOffset);
            //End case default 
            readContent();
            {
            	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime wrongly encoded at ["
                        + contentOffset + ']');
            } //End block
            {
                times = new int[7];
            } //End block
            times[0] = strToInt(contentOffset, 2);
            {
                times[0] += 1900;
            } //End block
            {
                times[0] += 2000;
            } //End block
            times[1] = strToInt(contentOffset + 2, 2);
            times[2] = strToInt(contentOffset + 4, 2);
            times[3] = strToInt(contentOffset + 6, 2);
            times[4] = strToInt(contentOffset + 8, 2);
            {
                times[5] = strToInt(contentOffset + 10, 2);
            } //End block
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 UTCTime type is not supported");
        } //End block
        {
            throw expected("UTCTime");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.694 -0400", hash_original_method = "7B8FBAB80C5ADD7C25B56AA6C7A7A7A0", hash_generated_method = "3858DBE0FB95B79CB0B8CE94152609C2")
    @DSModeled(DSC.SAFE)
    private int strToInt(int off, int count) throws ASN1Exception {
        dsTaint.addTaint(count);
        dsTaint.addTaint(off);
        int result;
        result = 0;
        {
            int i, end;
            i = off;
            end = off + count;
            {
                int c;
                c = buffer[i] - 48;
                {
                	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Time encoding has invalid char");
                } //End block
                result = result * 10 + c;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 0;
        //for (int i = off, end = off + count; i < end; i++) {
            //int c = buffer[i] - 48;
            //if (c < 0 || c > 9) {
                //throw new ASN1Exception("Time encoding has invalid char");
            //}
            //result = result * 10 + c;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.694 -0400", hash_original_method = "8E0BB334F5FA3F917B6C3297724E29A6", hash_generated_method = "5E7C21802A186546E3244CBC18766BC2")
    @DSModeled(DSC.SAFE)
    public void readInteger() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("integer");
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong length for ASN.1 integer at [" + tagOffset + "]");
        } //End block
        readContent();
        {
            byte firstByte;
            firstByte = buffer[offset - length];
            byte secondByte;
            secondByte = (byte) (buffer[offset - length + 1] & 0x80);
            {
                throw new ASN1Exception("Wrong content for ASN.1 integer at [" + (offset - length) + "]. An integer MUST be encoded in minimum number of octets");
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_INTEGER) {
            //throw expected("integer");
        //}
        //if (length < 1) {
            //throw new ASN1Exception("Wrong length for ASN.1 integer at [" + tagOffset + "]");
        //}
        //readContent();
        //if (length > 1) {
            //byte firstByte = buffer[offset - length];
            //byte secondByte = (byte) (buffer[offset - length + 1] & 0x80);
            //if (firstByte == 0 && secondByte == 0 || firstByte == (byte) 0xFF
                    //&& secondByte == (byte) 0x80) {
                //throw new ASN1Exception("Wrong content for ASN.1 integer at [" + (offset - length) + "]. An integer MUST be encoded in minimum number of octets");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.694 -0400", hash_original_method = "FF10597CCF521EBE62B89D95947AA842", hash_generated_method = "A7470BD5DF5347644CE5E8847482C3EC")
    @DSModeled(DSC.SAFE)
    public void readOctetString() throws IOException {
        {
            readContent();
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
        } //End block
        {
            throw expected("octetstring");
        } //End block
        // ---------- Original Method ----------
        //if (tag == ASN1Constants.TAG_OCTETSTRING) {
            //readContent();
        //} else if (tag == ASN1Constants.TAG_C_OCTETSTRING) {
            //throw new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
        //} else {
            //throw expected("octetstring");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.694 -0400", hash_original_method = "31EAA277FAF0612B23F88A136EEA2499", hash_generated_method = "26F39A920D3E0D7E537CA8DAF11D4A24")
    @DSModeled(DSC.SAFE)
    private ASN1Exception expected(String what) throws ASN1Exception {
        dsTaint.addTaint(what);
        if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
        return (ASN1Exception)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.694 -0400", hash_original_method = "1DFB0A727BF9534907B350DDA9E1A15B", hash_generated_method = "AD61B3A1ABFCDA08FE678040107CFC7A")
    @DSModeled(DSC.SAFE)
    public void readOID() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("OID");
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong length for ASN.1 object identifier at [" + tagOffset + "]");
        } //End block
        readContent();
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong encoding at [" + (offset - 1) + "]");
        } //End block
        oidElement = 1;
        {
            int i;
            i = 0;
            {
                {
                    i++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_OID) {
            //throw expected("OID");
        //}
        //if (length < 1) {
            //throw new ASN1Exception("Wrong length for ASN.1 object identifier at [" + tagOffset + "]");
        //}
        //readContent();
        //if ((buffer[offset - 1] & 0x80) != 0) {
            //throw new ASN1Exception("Wrong encoding at [" + (offset - 1) + "]");
        //}
        //oidElement = 1;
        //for (int i = 0; i < length; i++, ++oidElement) {
            //while ((buffer[contentOffset + i] & 0x80) == 0x80) {
                //i++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "97688987A014CB8C0C54BAB32FA72A4F", hash_generated_method = "1816E08556FA2D3C2CFCAD2179C7A854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readSequence(ASN1Sequence sequence) throws IOException {
        dsTaint.addTaint(sequence.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("sequence");
        } //End block
        int begOffset;
        begOffset = offset;
        int endOffset;
        endOffset = begOffset + length;
        ASN1Type[] type;
        type = sequence.type;
        int i;
        i = 0;
        {
            {
                next();
                {
                    boolean var2E238A45E4200E5E112737C7305019BA_1992570584 = (!type[i].checkTag(tag));
                    {
                        {
                        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        } //End block
                        i++;
                    } //End block
                } //End collapsed parenthetic
                type[i].decode(this);
            } //End block
            {
                {
                	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                } //End block
            } //End block
        } //End block
        {
            int seqTagOffset;
            seqTagOffset = tagOffset;
            Object[] values;
            values = new Object[type.length];
            {
                next();
                {
                    boolean var2E238A45E4200E5E112737C7305019BA_2078475741 = (!type[i].checkTag(tag));
                    {
                        {
                        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        } //End block
                        {
                            values[i] = sequence.DEFAULT[i];
                        } //End block
                        i++;
                    } //End block
                } //End collapsed parenthetic
                values[i] = type[i].decode(this);
            } //End block
            {
                {
                	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                } //End block
                {
                    values[i] = sequence.DEFAULT[i];
                } //End block
            } //End block
            content = values;
            tagOffset = seqTagOffset;
        } //End block
        {
            throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "48BA5600C2E0D1ED619B576E3555D97D", hash_generated_method = "D97AC676DB718E399F1EEB46AA583F8E")
    @DSModeled(DSC.SAFE)
    public void readSequenceOf(ASN1SequenceOf sequenceOf) throws IOException {
        dsTaint.addTaint(sequenceOf.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("sequenceOf");
        } //End block
        decodeValueCollection(sequenceOf);
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SEQUENCEOF) {
            //throw expected("sequenceOf");
        //}
        //decodeValueCollection(sequenceOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "51B09D41A46E89A1CD0754E5C1F0D1B8", hash_generated_method = "1EC5475B20947B6F7726A596919582F2")
    @DSModeled(DSC.SAFE)
    public void readSet(ASN1Set set) throws IOException {
        dsTaint.addTaint(set.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("set");
        } //End block
        throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SET) {
            //throw expected("set");
        //}
        //throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "8593963787440F0A1F5CC05E2CC3EB6D", hash_generated_method = "BA4F82B0B79778CB8BB1AF4BC02011C1")
    @DSModeled(DSC.SAFE)
    public void readSetOf(ASN1SetOf setOf) throws IOException {
        dsTaint.addTaint(setOf.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw expected("setOf");
        } //End block
        decodeValueCollection(setOf);
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SETOF) {
            //throw expected("setOf");
        //}
        //decodeValueCollection(setOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "A1B2FAB02C0A9A6283AF8F291FFC1121", hash_generated_method = "448301AE2E40A65B26FD8D2BAA3BD680")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void decodeValueCollection(ASN1ValueCollection collection) throws IOException {
        dsTaint.addTaint(collection.dsTaint);
        int begOffset;
        begOffset = offset;
        int endOffset;
        endOffset = begOffset + length;
        ASN1Type type;
        type = collection.type;
        {
            {
                next();
                type.decode(this);
            } //End block
        } //End block
        {
            int seqTagOffset;
            seqTagOffset = tagOffset;
            ArrayList<Object> values;
            values = new ArrayList<Object>();
            {
                next();
                values.add(type.decode(this));
            } //End block
            values.trimToSize();
            content = values;
            tagOffset = seqTagOffset;
        } //End block
        {
            throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        } //End block
        // ---------- Original Method ----------
        //int begOffset = offset;
        //int endOffset = begOffset + length;
        //ASN1Type type = collection.type;
        //if (isVerify) {
            //while (endOffset > offset) {
                //next();
                //type.decode(this);
            //}
        //} else {
            //int seqTagOffset = tagOffset; 
            //ArrayList<Object> values = new ArrayList<Object>();
            //while (endOffset > offset) {
                //next();
                //values.add(type.decode(this));
            //}
            //values.trimToSize();
            //content = values;
            //tagOffset = seqTagOffset; 
        //}
        //if (offset != endOffset) {
            //throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "2E006816EDCCACEA53589D73DD63B701", hash_generated_method = "212337D84531C3C21030A5E7D0794938")
    @DSModeled(DSC.SAFE)
    public void readString(ASN1StringType type) throws IOException {
        dsTaint.addTaint(type.dsTaint);
        {
            readContent();
        } //End block
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        } //End block
        {
            throw expected("string");
        } //End block
        // ---------- Original Method ----------
        //if (tag == type.id) {
            //readContent();
        //} else if (tag == type.constrId) {
            //throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        //} else {
            //throw expected("string");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "34E54E473055277C13E19CBB4B194845", hash_generated_method = "8DA977CD16FCF12264770D325DAA9097")
    @DSModeled(DSC.SAFE)
    public byte[] getEncoded() {
        byte[] encoded;
        encoded = new byte[offset - tagOffset];
        System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] encoded = new byte[offset - tagOffset];
        //System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        //return encoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "6B125A4F0D6B27C0C7AD41FB42F4DE53", hash_generated_method = "E12F17D59A7ECFBAE3B120BFC5C8B5F4")
    @DSModeled(DSC.SAFE)
    public final byte[] getBuffer() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "0871B05172E7E6942D8451DFB6AC8136")
    @DSModeled(DSC.SAFE)
    public final int getLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "D84240EC9E64699FD3C198F20DF79661")
    @DSModeled(DSC.SAFE)
    public final int getOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "1367D9753B97C5C3A102B7D6550881B9", hash_generated_method = "489877DCC4276F88B737B1A634232EC2")
    @DSModeled(DSC.SAFE)
    public final int getEndOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "1FDDE163F1BBA6CDA778E0FD08E430DE", hash_generated_method = "CC7611A5EE9C1D02F5D45891FF37FB37")
    @DSModeled(DSC.SAFE)
    public final int getTagOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return tagOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "E5C1E507EA76A704FAE5F4AC771876E5", hash_generated_method = "C40866982B85682AE4337290D9FD2E90")
    @DSModeled(DSC.SAFE)
    public final void setVerify() {
        isVerify = true;
        // ---------- Original Method ----------
        //isVerify = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.695 -0400", hash_original_method = "BBFB621282CA0716A19F3267ACDEEE7E", hash_generated_method = "49E69A78EB52FFAFC46B0BFC332443C1")
    @DSModeled(DSC.SAFE)
    protected int read() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Unexpected end of encoding");
        } //End block
        {
            int octet;
            octet = in.read();
            {
            	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Unexpected end of encoding");
            } //End block
            buffer[offset++] = (byte) octet;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (offset == buffer.length) {
            //throw new ASN1Exception("Unexpected end of encoding");
        //}
        //if (in == null) {
            //return buffer[offset++] & 0xFF;
        //} else {
            //int octet = in.read();
            //if (octet == -1) {
                //throw new ASN1Exception("Unexpected end of encoding");
            //}
            //buffer[offset++] = (byte) octet;
            //return octet;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.696 -0400", hash_original_method = "73ADE766083E21B57FB910CFDB1C7433", hash_generated_method = "53F4CB4A8CC5275DBD7D6ECD8F20515B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readContent() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Unexpected end of encoding");
        } //End block
        {
            offset += length;
        } //End block
        {
            int bytesRead;
            bytesRead = in.read(buffer, offset, length);
            {
                int c;
                c = bytesRead;
                {
                    {
                    	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Failed to read encoded content");
                    } //End block
                    c = in.read(buffer, offset + bytesRead, length - bytesRead);
                    bytesRead += c;
                } //End block
            } //End block
            offset += length;
        } //End block
        // ---------- Original Method ----------
        //if (offset + length > buffer.length) {
            //throw new ASN1Exception("Unexpected end of encoding");
        //}
        //if (in == null) {
            //offset += length;
        //} else {
            //int bytesRead = in.read(buffer, offset, length);
            //if (bytesRead != length) {
                //int c = bytesRead;
                //do {
                    //if (c < 1 || bytesRead > length) {
                        //throw new ASN1Exception("Failed to read encoded content");
                    //}
                    //c = in.read(buffer, offset + bytesRead, length - bytesRead);
                    //bytesRead += c;
                //} while (bytesRead != length);
            //}
            //offset += length;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.696 -0400", hash_original_method = "DCB4E4732715D068A4BB6AF51135E41B", hash_generated_method = "A936A9A336D019B8AFF397E4B62A27E1")
    @DSModeled(DSC.SAFE)
    public void compactBuffer() {
        {
            byte[] newBuffer;
            newBuffer = new byte[offset];
            System.arraycopy(buffer, 0, newBuffer, 0, offset);
            buffer = newBuffer;
        } //End block
        // ---------- Original Method ----------
        //if (offset != buffer.length) {
            //byte[] newBuffer = new byte[offset];
            //System.arraycopy(buffer, 0, newBuffer, 0, offset);
            //buffer = newBuffer;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.696 -0400", hash_original_method = "AFFB1C62116A7F4F1AC3586F8D79C157", hash_generated_method = "F7ABC2B9A1E50651B603AC6BD3622064")
    @DSModeled(DSC.SAFE)
    public void put(Object key, Object entry) {
        dsTaint.addTaint(entry.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            pool = new Object[2][10];
        } //End block
        int i;
        i = 0;
        {
            {
                pool[1][i] = entry;
            } //End block
        } //End block
        {
            Object[][] newPool;
            newPool = new Object[pool[0].length * 2][2];
            System.arraycopy(pool[0], 0, newPool[0], 0, pool[0].length);
            System.arraycopy(pool[1], 0, newPool[1], 0, pool[0].length);
            pool = newPool;
        } //End block
        {
            pool[0][i] = key;
            pool[1][i] = entry;
        } //End block
        // ---------- Original Method ----------
        //if (pool == null) {
            //pool = new Object[2][10];
        //}
        //int i = 0;
        //for (; i < pool[0].length && pool[0][i] != null; i++) {
            //if (pool[0][i] == key) {
                //pool[1][i] = entry;
                //return;
            //}
        //}
        //if (i == pool[0].length) {
            //Object[][] newPool = new Object[pool[0].length * 2][2];
            //System.arraycopy(pool[0], 0, newPool[0], 0, pool[0].length);
            //System.arraycopy(pool[1], 0, newPool[1], 0, pool[0].length);
            //pool = newPool;
        //} else {
            //pool[0][i] = key;
            //pool[1][i] = entry;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.696 -0400", hash_original_method = "5B069BEEA06FE3B546FE9A5858249664", hash_generated_method = "CA52DE523A39CCC5BC2CE02BFA8C8CAE")
    @DSModeled(DSC.SAFE)
    public Object get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (pool == null) {
            //return null;
        //}
        //for (int i = 0; i < pool[0].length; i++) {
            //if (pool[0][i] == key) {
                //return pool[1][i];
            //}
        //}
        //return null;
    }

    
}


