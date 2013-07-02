package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BerInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "47DA870F49698AFE94AB5C1004A17787")

    protected int offset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

    public int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "57FED7E8E8FF2184EEF7EFF7F0B770B6")

    public Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "0FE9238E05A1761544B80900699E2D71", hash_generated_field = "1C9B4A7A1F753F59487D78BA9637D2A9")

    protected int tagOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "C6CE8DFCFDDF69BCD2C379016D9218BA", hash_generated_field = "EC588CCB12D3A88BA3D161DCA8D8918C")

    protected int contentOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "83218587972461405B9AE8CC9B3DB6F7", hash_generated_field = "0BFC4C9F195DE6B4C0280180D67D78C2")

    public int choiceIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "F2B798F672D4B42C0359CED11D4F10CD", hash_generated_field = "13DDA1F04AC379B354F578F22425463A")

    public int[] times;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "83AC5317DA0C5AED8B38371E24E0E858", hash_generated_field = "022E0C44AE6A598FC1C18F39EC6A5FAB")

    public int oidElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "BE94DE0DE4D9890F5D1C703A2ED7090A", hash_generated_field = "FEA45D225F5AF2828047CBD2A607E879")

    protected boolean isVerify;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "4BB7747F74E36AE6A0B38A70A077C2C7", hash_generated_field = "00FF4B69234D0AC263E1AA84F9B79338")

    protected boolean isIndefinedLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.759 -0400", hash_original_field = "B10A8C0BEDE9EB4EA771B04DB3149F28", hash_generated_field = "052E31DFE5C2BAB4284743C186914165")

    private Object[][] pool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.760 -0400", hash_original_method = "879F2FC8DE697B067D571C3BF31ADD98", hash_generated_method = "D463D36C1F029E44BAE5AEAD9B64564C")
    public  BerInputStream(byte[] encoded) throws IOException {
        this(encoded, 0, encoded.length);
        addTaint(encoded[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.760 -0400", hash_original_method = "FB2C80FA06C3B0FD8EA5024440AD49C3", hash_generated_method = "C3C75CEC3A5726BFCE07739D2F8EAEB2")
    public  BerInputStream(byte[] encoded, int offset, int expectedLength) throws IOException {
        this.in = null;
        this.buffer = encoded;
        this.offset = offset;
        next();
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong content length");
        } 
        addTaint(expectedLength);
        
        
        
        
        
        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.760 -0400", hash_original_method = "43063225C34584E29FE6185CE8AAB05D", hash_generated_method = "3A90B6A336723BC11B1F963E14757334")
    public  BerInputStream(InputStream in) throws IOException {
        this(in, BUF_INCREASE_SIZE);
        addTaint(in.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.761 -0400", hash_original_method = "ED7F15B5071BF063BB4017E313468A57", hash_generated_method = "B068E79BDC8A18DE7D6E6FE6CF402BE1")
    public  BerInputStream(InputStream in, int initialSize) throws IOException {
        this.in = in;
        buffer = new byte[initialSize];
        next();
        {
            {
                byte[] newBuffer = new byte[length + offset];
                System.arraycopy(buffer, 0, newBuffer, 0, offset);
                buffer = newBuffer;
            } 
        } 
        {
            isIndefinedLength = true;
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding indefinite length encoding is not supported");
        } 
        
        
        
        
        
            
                
                
                
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.761 -0400", hash_original_method = "4CCBB4621387969DDD8BDCB7ADDE8473", hash_generated_method = "5C19B2C85550850E24C9B051962F85BD")
    public final void reset(byte[] encoded) throws IOException {
        buffer = encoded;
        next();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.762 -0400", hash_original_method = "E21A3F5A1E5C42E0733DFCD7E2B1A37B", hash_generated_method = "6E5D7E03D0CA27635550EC9996A9C6EC")
    public int next() throws IOException {
        tagOffset = offset;
        tag = read();
        length = read();
        {
            {
                int numOctets = length & 0x7F;
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Too long encoding at [" + tagOffset + "]");
                } 
                length = read();
                {
                    int i = 1;
                    {
                        int ch = read();
                        length = (length << 8) + ch;
                    } 
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Too long encoding at [" + tagOffset + "]");
                } 
            } 
        } 
        {
            length = INDEFINIT_LENGTH;
        } 
        contentOffset = offset;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325970958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325970958;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.763 -0400", hash_original_method = "A15B72AB03BE363B2B31FA8E7C1F64A3", hash_generated_method = "0DEC710C40C2937BF8E71691B5612733")
    public void readBitString() throws IOException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Bitstring: wrong length. Tag at [" + tagOffset + "]");
            } 
            readContent();
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. A number of unused bits MUST be in range 0 to 7");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. For empty string unused bits MUST be 0");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 bitstring  type is not provided");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw expected("bitstring");
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.764 -0400", hash_original_method = "70271B544C5D122FB5ABE2DE9A460926", hash_generated_method = "13C05A00B8BD3C12AA4B45F1E864556D")
    public void readEnumerated() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("enumerated");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 enumerated: wrong length for identifier at ["
                    + tagOffset + "]");
        } 
        readContent();
        {
            int bits = buffer[contentOffset] & 0xFF;
            {
                bits += 0x100;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 enumerated: wrong content at [" + contentOffset
                        + "]. An integer MUST be encoded in minimum number of octets");
            } 
        } 
        
        
            
        
        
            
                    
        
        
        
            
            
                
            
            
                
                        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.765 -0400", hash_original_method = "13F2651D91961A81EAE79BEA9D5230AF", hash_generated_method = "637B7CD8DAC946DEC9D5356E62610BA9")
    public void readBoolean() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("boolean");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong length for ASN.1 boolean at [" + tagOffset + "]");
        } 
        readContent();
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.766 -0400", hash_original_method = "1A3161CCB7646B7891B929A5396BF673", hash_generated_method = "1E711ABE478A7D2F03E555BFEA43E4AD")
    public void readGeneralizedTime() throws IOException {
        {
            readContent();
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime: encoded format is not implemented");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                        + contentOffset + "]");
            } 
            {
                byte char14 = buffer[contentOffset + 14];
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                            + contentOffset + "]");
                } 
            } 
            {
                times = new int[7];
            } 
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
                } 
                {
                    times[6] = times[6] * 10;
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 GeneralizedTime type is not supported");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw expected("GeneralizedTime");
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.766 -0400", hash_original_method = "D1E9408574A13A490CB1D3EF3A359E97", hash_generated_method = "F3F29495B82786F8ADFF0B2734839221")
    public void readUTCTime() throws IOException {
        {
            
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: local time format is not supported");
            
            
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime: wrong length, identifier at " + tagOffset);
            
            readContent();
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 UTCTime wrongly encoded at ["
                        + contentOffset + ']');
            } 
            {
                times = new int[7];
            } 
            times[0] = strToInt(contentOffset, 2);
            {
                times[0] += 1900;
            } 
            {
                times[0] += 2000;
            } 
            times[1] = strToInt(contentOffset + 2, 2);
            times[2] = strToInt(contentOffset + 4, 2);
            times[3] = strToInt(contentOffset + 6, 2);
            times[4] = strToInt(contentOffset + 8, 2);
            {
                times[5] = strToInt(contentOffset + 10, 2);
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 UTCTime type is not supported");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw expected("UTCTime");
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.767 -0400", hash_original_method = "7B8FBAB80C5ADD7C25B56AA6C7A7A7A0", hash_generated_method = "4329F9896FCDF9000467DFE7B8C42A7B")
    private int strToInt(int off, int count) throws ASN1Exception {
        int result = 0;
        {
            int i = off;
            int end = off + count;
            {
                int c = buffer[i] - 48;
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Time encoding has invalid char");
                } 
                result = result * 10 + c;
            } 
        } 
        addTaint(off);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410727094 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410727094;
        
        
        
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.767 -0400", hash_original_method = "8E0BB334F5FA3F917B6C3297724E29A6", hash_generated_method = "367482EB5DC718C2E2D5AABDE69A6719")
    public void readInteger() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("integer");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong length for ASN.1 integer at [" + tagOffset + "]");
        } 
        readContent();
        {
            byte firstByte = buffer[offset - length];
            byte secondByte = (byte) (buffer[offset - length + 1] & 0x80);
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong content for ASN.1 integer at [" + (offset - length) + "]. An integer MUST be encoded in minimum number of octets");
            } 
        } 
        
        
            
        
        
            
        
        
        
            
            
            
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.768 -0400", hash_original_method = "FF10597CCF521EBE62B89D95947AA842", hash_generated_method = "316E1EFF7AA7849D7C98342C5C32CC3B")
    public void readOctetString() throws IOException {
        {
            readContent();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw expected("octetstring");
        } 
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.768 -0400", hash_original_method = "31EAA277FAF0612B23F88A136EEA2499", hash_generated_method = "082B79E9E0722FEA27368C5126D094F6")
    private ASN1Exception expected(String what) throws ASN1Exception {
        addTaint(what.getTaint());
        throw new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.769 -0400", hash_original_method = "1DFB0A727BF9534907B350DDA9E1A15B", hash_generated_method = "043FDD376CCE261D1ABC4FB43D434BDF")
    public void readOID() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("OID");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong length for ASN.1 object identifier at [" + tagOffset + "]");
        } 
        readContent();
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong encoding at [" + (offset - 1) + "]");
        } 
        oidElement = 1;
        {
            int i = 0;
        } 
        
        
            
        
        
            
        
        
        
            
        
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.769 -0400", hash_original_method = "97688987A014CB8C0C54BAB32FA72A4F", hash_generated_method = "2D975BC7B4AAD2CFE71961A79569C61A")
    public void readSequence(ASN1Sequence sequence) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("sequence");
        } 
        int begOffset = offset;
        int endOffset = begOffset + length;
        ASN1Type[] type = sequence.type;
        int i = 0;
        {
            {
                next();
                {
                    boolean var2E238A45E4200E5E112737C7305019BA_1277636392 = (!type[i].checkTag(tag));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        } 
                    } 
                } 
                type[i].decode(this);
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                } 
            } 
        } 
        {
            int seqTagOffset = tagOffset;
            Object[] values = new Object[type.length];
            {
                next();
                {
                    boolean var2E238A45E4200E5E112737C7305019BA_1162610464 = (!type[i].checkTag(tag));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                        } 
                        {
                            values[i] = sequence.DEFAULT[i];
                        } 
                    } 
                } 
                values[i] = type[i].decode(this);
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                } 
                {
                    values[i] = sequence.DEFAULT[i];
                } 
            } 
            content = values;
            tagOffset = seqTagOffset;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        } 
        addTaint(sequence.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.770 -0400", hash_original_method = "48BA5600C2E0D1ED619B576E3555D97D", hash_generated_method = "2594D3D51D8535647BE8369BA6535F13")
    public void readSequenceOf(ASN1SequenceOf sequenceOf) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("sequenceOf");
        } 
        decodeValueCollection(sequenceOf);
        addTaint(sequenceOf.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.770 -0400", hash_original_method = "51B09D41A46E89A1CD0754E5C1F0D1B8", hash_generated_method = "BCBCDAB2832C1DE69187AEA1BF881707")
    public void readSet(ASN1Set set) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("set");
        } 
        if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
        addTaint(set.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.770 -0400", hash_original_method = "8593963787440F0A1F5CC05E2CC3EB6D", hash_generated_method = "B3DEDC9AFA21B548BCC644899815AAC0")
    public void readSetOf(ASN1SetOf setOf) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw expected("setOf");
        } 
        decodeValueCollection(setOf);
        addTaint(setOf.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.771 -0400", hash_original_method = "A1B2FAB02C0A9A6283AF8F291FFC1121", hash_generated_method = "C87584567A9BA5DCA2FE250E587151A3")
    private void decodeValueCollection(ASN1ValueCollection collection) throws IOException {
        int begOffset = offset;
        int endOffset = begOffset + length;
        ASN1Type type = collection.type;
        {
            {
                next();
                type.decode(this);
            } 
        } 
        {
            int seqTagOffset = tagOffset;
            ArrayList<Object> values = new ArrayList<Object>();
            {
                next();
                values.add(type.decode(this));
            } 
            values.trimToSize();
            content = values;
            tagOffset = seqTagOffset;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        } 
        addTaint(collection.getTaint());
        
        
        
        
        
            
                
                
            
        
            
            
            
                
                
            
            
            
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.771 -0400", hash_original_method = "2E006816EDCCACEA53589D73DD63B701", hash_generated_method = "8E7F615A50EBC6C11C1EBF0857F6AD6C")
    public void readString(ASN1StringType type) throws IOException {
        {
            readContent();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw expected("string");
        } 
        addTaint(type.getTaint());
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.771 -0400", hash_original_method = "34E54E473055277C13E19CBB4B194845", hash_generated_method = "6142F2DD6EDCB864B524FB1E5D65FCB7")
    public byte[] getEncoded() {
        byte[] encoded = new byte[offset - tagOffset];
        System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1045873314 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1045873314;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.772 -0400", hash_original_method = "6B125A4F0D6B27C0C7AD41FB42F4DE53", hash_generated_method = "74ABAF354953847EBB38CAC020C0B71B")
    public final byte[] getBuffer() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_547096514 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_547096514;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.772 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "D3C19A5F4D0A1CEB6DF7D201ACADB81D")
    public final int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605577122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605577122;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.772 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "055C95F0F8E1C4042902FB2570E89105")
    public final int getOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027729801 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027729801;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.773 -0400", hash_original_method = "1367D9753B97C5C3A102B7D6550881B9", hash_generated_method = "302B4A6BA2B00771F66D9BF00408B1E3")
    public final int getEndOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085792615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085792615;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.773 -0400", hash_original_method = "1FDDE163F1BBA6CDA778E0FD08E430DE", hash_generated_method = "CB58BCCE637B976FACDB0CD51B5BB9E8")
    public final int getTagOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818012907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818012907;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.774 -0400", hash_original_method = "E5C1E507EA76A704FAE5F4AC771876E5", hash_generated_method = "38A0FA5CCBFAD28A394824D8D2033CBB")
    public final void setVerify() {
        isVerify = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.774 -0400", hash_original_method = "BBFB621282CA0716A19F3267ACDEEE7E", hash_generated_method = "6F9B9A771FDB554D64AEC5D0F1719547")
    protected int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Unexpected end of encoding");
        } 
        {
            int octet = in.read();
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Unexpected end of encoding");
            } 
            buffer[offset++] = (byte) octet;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310737519 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310737519;
        
        
            
        
        
            
        
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.775 -0400", hash_original_method = "73ADE766083E21B57FB910CFDB1C7433", hash_generated_method = "48035C4B9D0E6EA01237C2349ACD0144")
    public void readContent() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Unexpected end of encoding");
        } 
        {
            offset += length;
        } 
        {
            int bytesRead = in.read(buffer, offset, length);
            {
                int c = bytesRead;
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("Failed to read encoded content");
                    } 
                    c = in.read(buffer, offset + bytesRead, length - bytesRead);
                    bytesRead += c;
                } 
            } 
            offset += length;
        } 
        
        
            
        
        
            
        
            
            
                
                
                    
                        
                    
                    
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.776 -0400", hash_original_method = "DCB4E4732715D068A4BB6AF51135E41B", hash_generated_method = "9D814B08D201025B8DFEC1F06F92329B")
    public void compactBuffer() {
        {
            byte[] newBuffer = new byte[offset];
            System.arraycopy(buffer, 0, newBuffer, 0, offset);
            buffer = newBuffer;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.777 -0400", hash_original_method = "AFFB1C62116A7F4F1AC3586F8D79C157", hash_generated_method = "E84E89C0372BA343654E9425AA6C87AC")
    public void put(Object key, Object entry) {
        {
            pool = new Object[2][10];
        } 
        int i = 0;
        {
            {
                pool[1][i] = entry;
            } 
        } 
        {
            Object[][] newPool = new Object[pool[0].length * 2][2];
            System.arraycopy(pool[0], 0, newPool[0], 0, pool[0].length);
            System.arraycopy(pool[1], 0, newPool[1], 0, pool[0].length);
            pool = newPool;
        } 
        {
            pool[0][i] = key;
            pool[1][i] = entry;
        } 
        
        
            
        
        
        
            
                
                
            
        
        
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.778 -0400", hash_original_method = "5B069BEEA06FE3B546FE9A5858249664", hash_generated_method = "4052DC2651E8308650534F6CD007AC04")
    public Object get(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1670465641 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1581654466 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_15512286 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1670465641 = null;
        } 
        {
            int i = 0;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1581654466 = pool[1][i];
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_15512286 = null;
        addTaint(key.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2104049298; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2104049298 = varB4EAC82CA7396A68D541C85D26508E83_1670465641;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2104049298 = varB4EAC82CA7396A68D541C85D26508E83_1581654466;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2104049298 = varB4EAC82CA7396A68D541C85D26508E83_15512286;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2104049298.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2104049298;
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.778 -0400", hash_original_field = "F1EFF4BE8D15EBEF9A90A83AF1B73C89", hash_generated_field = "15AEBAF204B1E1628DA9A9D8B78EB825")

    private static final int BUF_INCREASE_SIZE = 1024 * 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.778 -0400", hash_original_field = "9BAABEE9C3348ECF21AE95935BDB009B", hash_generated_field = "12A8A7878E72ADED3FB919DC5D266C92")

    protected static final int INDEFINIT_LENGTH = -1;
}

