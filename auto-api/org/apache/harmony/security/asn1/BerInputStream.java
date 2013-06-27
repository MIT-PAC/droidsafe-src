package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BerInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.716 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.716 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.716 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "47DA870F49698AFE94AB5C1004A17787")

    protected int offset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.716 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

    public int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.717 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.717 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "57FED7E8E8FF2184EEF7EFF7F0B770B6")

    public Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.720 -0400", hash_original_field = "0FE9238E05A1761544B80900699E2D71", hash_generated_field = "1C9B4A7A1F753F59487D78BA9637D2A9")

    protected int tagOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.721 -0400", hash_original_field = "C6CE8DFCFDDF69BCD2C379016D9218BA", hash_generated_field = "EC588CCB12D3A88BA3D161DCA8D8918C")

    protected int contentOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.721 -0400", hash_original_field = "83218587972461405B9AE8CC9B3DB6F7", hash_generated_field = "0BFC4C9F195DE6B4C0280180D67D78C2")

    public int choiceIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.721 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "13DDA1F04AC379B354F578F22425463A")

    public int[] times;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.721 -0400", hash_original_field = "83AC5317DA0C5AED8B38371E24E0E858", hash_generated_field = "022E0C44AE6A598FC1C18F39EC6A5FAB")

    public int oidElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.721 -0400", hash_original_field = "BE94DE0DE4D9890F5D1C703A2ED7090A", hash_generated_field = "FEA45D225F5AF2828047CBD2A607E879")

    protected boolean isVerify;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.721 -0400", hash_original_field = "4BB7747F74E36AE6A0B38A70A077C2C7", hash_generated_field = "00FF4B69234D0AC263E1AA84F9B79338")

    protected boolean isIndefinedLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.721 -0400", hash_original_field = "B10A8C0BEDE9EB4EA771B04DB3149F28", hash_generated_field = "052E31DFE5C2BAB4284743C186914165")

    private Object[][] pool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.724 -0400", hash_original_method = "879F2FC8DE697B067D571C3BF31ADD98", hash_generated_method = "D463D36C1F029E44BAE5AEAD9B64564C")
    public  BerInputStream(byte[] encoded) throws IOException {
        this(encoded, 0, encoded.length);
        addTaint(encoded[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.734 -0400", hash_original_method = "FB2C80FA06C3B0FD8EA5024440AD49C3", hash_generated_method = "C3C75CEC3A5726BFCE07739D2F8EAEB2")
    public  BerInputStream(byte[] encoded, int offset, int expectedLength) throws IOException {
        this.in = null;
        this.buffer = encoded;
        this.offset = offset;
        next();
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong content length");
        } //End block
        addTaint(expectedLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.734 -0400", hash_original_method = "43063225C34584E29FE6185CE8AAB05D", hash_generated_method = "3A90B6A336723BC11B1F963E14757334")
    public  BerInputStream(InputStream in) throws IOException {
        this(in, BUF_INCREASE_SIZE);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.736 -0400", hash_original_method = "ED7F15B5071BF063BB4017E313468A57", hash_generated_method = "13D42CA6C1803222BD9CAFDD3A327367")
    public  BerInputStream(InputStream in, int initialSize) throws IOException {
        this.in = in;
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
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding indefinite length encoding is not supported");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.738 -0400", hash_original_method = "4CCBB4621387969DDD8BDCB7ADDE8473", hash_generated_method = "5C19B2C85550850E24C9B051962F85BD")
    public final void reset(byte[] encoded) throws IOException {
        buffer = encoded;
        next();
        // ---------- Original Method ----------
        //buffer = encoded;
        //next();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.744 -0400", hash_original_method = "E21A3F5A1E5C42E0733DFCD7E2B1A37B", hash_generated_method = "06C6CBC92AF36B7DC69332426DB616AA")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_614804494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_614804494;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.745 -0400", hash_original_method = "A15B72AB03BE363B2B31FA8E7C1F64A3", hash_generated_method = "0DEC710C40C2937BF8E71691B5612733")
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
            if (DroidSafeAndroidRuntime.control) throw expected("bitstring");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.750 -0400", hash_original_method = "70271B544C5D122FB5ABE2DE9A460926", hash_generated_method = "B04EF58B5AE7F40B5FEBAD5E16F7D731")
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
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 enumerated: wrong content at [" + contentOffset
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.752 -0400", hash_original_method = "13F2651D91961A81EAE79BEA9D5230AF", hash_generated_method = "637B7CD8DAC946DEC9D5356E62610BA9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.766 -0400", hash_original_method = "1A3161CCB7646B7891B929A5396BF673", hash_generated_method = "3D5AD4206FA2785BB8F59D73CAB1ADA3")
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
            if (DroidSafeAndroidRuntime.control) throw expected("GeneralizedTime");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.774 -0400", hash_original_method = "D1E9408574A13A490CB1D3EF3A359E97", hash_generated_method = "F3F29495B82786F8ADFF0B2734839221")
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
            if (DroidSafeAndroidRuntime.control) throw expected("UTCTime");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.775 -0400", hash_original_method = "7B8FBAB80C5ADD7C25B56AA6C7A7A7A0", hash_generated_method = "6B68C2756642FD3BC3E5ABE8A72474B3")
    private int strToInt(int off, int count) throws ASN1Exception {
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
        addTaint(off);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577442002 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577442002;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.775 -0400", hash_original_method = "8E0BB334F5FA3F917B6C3297724E29A6", hash_generated_method = "61A60DC43DA2513BA5D56102014FE4A8")
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
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong content for ASN.1 integer at [" + (offset - length) + "]. An integer MUST be encoded in minimum number of octets");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.783 -0400", hash_original_method = "FF10597CCF521EBE62B89D95947AA842", hash_generated_method = "316E1EFF7AA7849D7C98342C5C32CC3B")
    public void readOctetString() throws IOException {
        {
            readContent();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw expected("octetstring");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.784 -0400", hash_original_method = "31EAA277FAF0612B23F88A136EEA2499", hash_generated_method = "082B79E9E0722FEA27368C5126D094F6")
    private ASN1Exception expected(String what) throws ASN1Exception {
        if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //throw new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.784 -0400", hash_original_method = "1DFB0A727BF9534907B350DDA9E1A15B", hash_generated_method = "B26975F49FD81D2F760AAD3258AE180A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.794 -0400", hash_original_method = "97688987A014CB8C0C54BAB32FA72A4F", hash_generated_method = "9A93732653F1F7409DCA691D63E2ED67")
    public void readSequence(ASN1Sequence sequence) throws IOException {
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
                    boolean var2E238A45E4200E5E112737C7305019BA_1447671350 = (!type[i].checkTag(tag));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        } //End block
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
                    boolean var2E238A45E4200E5E112737C7305019BA_1194081828 = (!type[i].checkTag(tag));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        } //End block
                        {
                            values[i] = sequence.DEFAULT[i];
                        } //End block
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
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        } //End block
        addTaint(sequence.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.794 -0400", hash_original_method = "48BA5600C2E0D1ED619B576E3555D97D", hash_generated_method = "2594D3D51D8535647BE8369BA6535F13")
    public void readSequenceOf(ASN1SequenceOf sequenceOf) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("sequenceOf");
        } //End block
        decodeValueCollection(sequenceOf);
        addTaint(sequenceOf.getTaint());
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SEQUENCEOF) {
            //throw expected("sequenceOf");
        //}
        //decodeValueCollection(sequenceOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.803 -0400", hash_original_method = "51B09D41A46E89A1CD0754E5C1F0D1B8", hash_generated_method = "BCBCDAB2832C1DE69187AEA1BF881707")
    public void readSet(ASN1Set set) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("set");
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
        addTaint(set.getTaint());
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SET) {
            //throw expected("set");
        //}
        //throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.808 -0400", hash_original_method = "8593963787440F0A1F5CC05E2CC3EB6D", hash_generated_method = "B3DEDC9AFA21B548BCC644899815AAC0")
    public void readSetOf(ASN1SetOf setOf) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("setOf");
        } //End block
        decodeValueCollection(setOf);
        addTaint(setOf.getTaint());
        // ---------- Original Method ----------
        //if (tag != ASN1Constants.TAG_C_SETOF) {
            //throw expected("setOf");
        //}
        //decodeValueCollection(setOf);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.810 -0400", hash_original_method = "A1B2FAB02C0A9A6283AF8F291FFC1121", hash_generated_method = "8F1823B36BA71B5A0E2F4398D67BBD61")
    private void decodeValueCollection(ASN1ValueCollection collection) throws IOException {
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
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        } //End block
        addTaint(collection.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.810 -0400", hash_original_method = "2E006816EDCCACEA53589D73DD63B701", hash_generated_method = "8E7F615A50EBC6C11C1EBF0857F6AD6C")
    public void readString(ASN1StringType type) throws IOException {
        {
            readContent();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw expected("string");
        } //End block
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //if (tag == type.id) {
            //readContent();
        //} else if (tag == type.constrId) {
            //throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        //} else {
            //throw expected("string");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.811 -0400", hash_original_method = "34E54E473055277C13E19CBB4B194845", hash_generated_method = "184B60B8CBD16D571422BC41DE757D81")
    public byte[] getEncoded() {
        byte[] encoded;
        encoded = new byte[offset - tagOffset];
        System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1259228894 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1259228894;
        // ---------- Original Method ----------
        //byte[] encoded = new byte[offset - tagOffset];
        //System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        //return encoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.811 -0400", hash_original_method = "6B125A4F0D6B27C0C7AD41FB42F4DE53", hash_generated_method = "956464AE5CC1692881602D40780758D4")
    public final byte[] getBuffer() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_407321284 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_407321284;
        // ---------- Original Method ----------
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.811 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "0091E0C607B45CB2BF6133FCEE371124")
    public final int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932011802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932011802;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.811 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "A23202676FB586971F6149509482A8F0")
    public final int getOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434054455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434054455;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.820 -0400", hash_original_method = "1367D9753B97C5C3A102B7D6550881B9", hash_generated_method = "0023EAEF8B622D7ED7CCBD8056F3954A")
    public final int getEndOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536714046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536714046;
        // ---------- Original Method ----------
        //return offset + length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.820 -0400", hash_original_method = "1FDDE163F1BBA6CDA778E0FD08E430DE", hash_generated_method = "4B3014A0C945471A6EA4618AB05C8465")
    public final int getTagOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032885193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032885193;
        // ---------- Original Method ----------
        //return tagOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.821 -0400", hash_original_method = "E5C1E507EA76A704FAE5F4AC771876E5", hash_generated_method = "38A0FA5CCBFAD28A394824D8D2033CBB")
    public final void setVerify() {
        isVerify = true;
        // ---------- Original Method ----------
        //isVerify = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.821 -0400", hash_original_method = "BBFB621282CA0716A19F3267ACDEEE7E", hash_generated_method = "E77F86D2799F67CD0FEAB6BEED56BA60")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468969552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468969552;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.834 -0400", hash_original_method = "73ADE766083E21B57FB910CFDB1C7433", hash_generated_method = "21FF3E4A36E51F5E31FD4998546EB73E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.835 -0400", hash_original_method = "DCB4E4732715D068A4BB6AF51135E41B", hash_generated_method = "FAD2789C1F8F3DF0BDFF824E48071CB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.841 -0400", hash_original_method = "AFFB1C62116A7F4F1AC3586F8D79C157", hash_generated_method = "32CE91C68A306B2E11786A812737B954")
    public void put(Object key, Object entry) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.847 -0400", hash_original_method = "5B069BEEA06FE3B546FE9A5858249664", hash_generated_method = "95AADCDF2F4E31A9037C5BE2F562E2BC")
    public Object get(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_151194558 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1994367439 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_74422948 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_151194558 = null;
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1994367439 = pool[1][i];
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_74422948 = null;
        addTaint(key.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_707026595; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_707026595 = varB4EAC82CA7396A68D541C85D26508E83_151194558;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_707026595 = varB4EAC82CA7396A68D541C85D26508E83_1994367439;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_707026595 = varB4EAC82CA7396A68D541C85D26508E83_74422948;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_707026595.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_707026595;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.848 -0400", hash_original_field = "F1EFF4BE8D15EBEF9A90A83AF1B73C89", hash_generated_field = "E0184693587FB309354E503D90507973")

    private static int BUF_INCREASE_SIZE = 1024 * 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.848 -0400", hash_original_field = "9BAABEE9C3348ECF21AE95935BDB009B", hash_generated_field = "11761D7B9942FDC87FD691C869BC125D")

    protected static int INDEFINIT_LENGTH = -1;
}

