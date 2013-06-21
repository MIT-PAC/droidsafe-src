package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;

public class Base64 {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.120 -0400", hash_original_method = "B12DC6BE1A1E2EB3A4F484EDEACB8E03", hash_generated_method = "96F9E0BDD170E9FC5C3951236F2EB54E")
    @DSModeled(DSC.SAFE)
    private Base64() {
        // ---------- Original Method ----------
    }

    
        public static byte[] decode(String str, int flags) {
        return decode(str.getBytes(), flags);
    }

    
        public static byte[] decode(byte[] input, int flags) {
        return decode(input, 0, input.length, flags);
    }

    
        public static byte[] decode(byte[] input, int offset, int len, int flags) {
        Decoder decoder = new Decoder(flags, new byte[len*3/4]);
        if (!decoder.process(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.op == decoder.output.length) {
            return decoder.output;
        }
        byte[] temp = new byte[decoder.op];
        System.arraycopy(decoder.output, 0, temp, 0, decoder.op);
        return temp;
    }

    
        public static String encodeToString(byte[] input, int flags) {
        try {
            return new String(encode(input, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    
        public static String encodeToString(byte[] input, int offset, int len, int flags) {
        try {
            return new String(encode(input, offset, len, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    
        public static byte[] encode(byte[] input, int flags) {
        return encode(input, 0, input.length, flags);
    }

    
        public static byte[] encode(byte[] input, int offset, int len, int flags) {
        Encoder encoder = new Encoder(flags, null);
        int output_len = len / 3 * 4;
        if (encoder.do_padding) {
            if (len % 3 > 0) {
                output_len += 4;
            }
        } else {
            switch (len % 3) {
                case 0: break;
                case 1: output_len += 2; break;
                case 2: output_len += 3; break;
            }
        }
        if (encoder.do_newline && len > 0) {
            output_len += (((len-1) / (3 * Encoder.LINE_GROUPS)) + 1) *
                (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[output_len];
        encoder.process(input, offset, len, true);
        assert encoder.op == output_len;
        return encoder.output;
    }

    
    static abstract class Coder {
        public byte[] output;
        public int op;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.122 -0400", hash_original_method = "8FC1AFFA0997BC8EDEF9ED889C046442", hash_generated_method = "8FC1AFFA0997BC8EDEF9ED889C046442")
                public Coder ()
        {
        }


        public abstract boolean process(byte[] input, int offset, int len, boolean finish);

        
        public abstract int maxOutputSize(int len);

        
    }


    
    static class Decoder extends Coder {
        private int state;
        private int value;
        private int[] alphabet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.123 -0400", hash_original_method = "28200CA179B3214BB831C341BA07009C", hash_generated_method = "27DB96CEB95363984A72E61439EA0F4C")
        @DSModeled(DSC.SAFE)
        public Decoder(int flags, byte[] output) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(output[0]);
            this.output = output;
            alphabet = ((flags & URL_SAFE) == 0) ? DECODE : DECODE_WEBSAFE;
            state = 0;
            value = 0;
            // ---------- Original Method ----------
            //this.output = output;
            //alphabet = ((flags & URL_SAFE) == 0) ? DECODE : DECODE_WEBSAFE;
            //state = 0;
            //value = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.123 -0400", hash_original_method = "006B314D1443F75FACC9C9CF957F4174", hash_generated_method = "4204FE44A6CED616C12E30F8D7012DAC")
        @DSModeled(DSC.SAFE)
        public int maxOutputSize(int len) {
            dsTaint.addTaint(len);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return len * 3/4 + 10;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.126 -0400", hash_original_method = "5E49CA254C7BA97645BE526448794F2D", hash_generated_method = "2BF2F63C65EA2462D08BC53E10FE8552")
        @DSModeled(DSC.SAFE)
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            dsTaint.addTaint(finish);
            dsTaint.addTaint(input[0]);
            dsTaint.addTaint(len);
            dsTaint.addTaint(offset);
            int p;
            p = offset;
            len += offset;
            int state;
            state = this.state;
            int value;
            value = this.value;
            int op;
            op = 0;
            byte[] output;
            output = this.output;
            int[] alphabet;
            alphabet = this.alphabet;
            {
                {
                    {
                        boolean var352F1CA5F42B44E4BE0B087C79C4F4FB_1619895021 = (p+4 <= len &&
                           (value = ((alphabet[input[p] & 0xff] << 18) |
                                     (alphabet[input[p+1] & 0xff] << 12) |
                                     (alphabet[input[p+2] & 0xff] << 6) |
                                     (alphabet[input[p+3] & 0xff]))) >= 0);
                        {
                            output[op+2] = (byte) value;
                            output[op+1] = (byte) (value >> 8);
                            output[op] = (byte) (value >> 16);
                            op += 3;
                            p += 4;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                int d;
                d = alphabet[input[p++] & 0xff];
                //Begin case 0 
                {
                    value = d;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 0 
                //Begin case 1 
                {
                    value = (value << 6) | d;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 1 
                //Begin case 2 
                {
                    value = (value << 6) | d;
                } //End block
                {
                    output[op++] = (byte) (value >> 4);
                    state = 4;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 2 
                //Begin case 3 
                {
                    value = (value << 6) | d;
                    output[op+2] = (byte) value;
                    output[op+1] = (byte) (value >> 8);
                    output[op] = (byte) (value >> 16);
                    op += 3;
                    state = 0;
                } //End block
                {
                    output[op+1] = (byte) (value >> 2);
                    output[op] = (byte) (value >> 10);
                    op += 2;
                    state = 5;
                } //End block
                {
                    this.state = 6;
                } //End block
                //End case 3 
                //Begin case 4 
                {
                    this.state = 6;
                } //End block
                //End case 4 
                //Begin case 5 
                {
                    this.state = 6;
                } //End block
                //End case 5 
            } //End block
            {
                this.state = state;
                this.value = value;
                this.op = op;
            } //End block
            //Begin case 1 
            this.state = 6;
            //End case 1 
            //Begin case 2 
            output[op++] = (byte) (value >> 4);
            //End case 2 
            //Begin case 3 
            output[op++] = (byte) (value >> 10);
            //End case 3 
            //Begin case 3 
            output[op++] = (byte) (value >> 2);
            //End case 3 
            //Begin case 4 
            this.state = 6;
            //End case 4 
            this.state = state;
            this.op = op;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int DECODE[] = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1,
            -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };
        private static final int DECODE_WEBSAFE[] = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1,
            -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };
        private static final int SKIP = -1;
        private static final int EQUALS = -2;
    }


    
    static class Encoder extends Coder {
        private byte[] tail;
        int tailLen;
        private int count;
        public boolean do_padding;
        public boolean do_newline;
        public boolean do_cr;
        private byte[] alphabet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.127 -0400", hash_original_method = "248AE984D731F285F53C3C8EA52608A3", hash_generated_method = "0AAB8284B6B4A45571A5282E53EA1A3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Encoder(int flags, byte[] output) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(output[0]);
            this.output = output;
            do_padding = (flags & NO_PADDING) == 0;
            do_newline = (flags & NO_WRAP) == 0;
            do_cr = (flags & CRLF) != 0;
            alphabet = ((flags & URL_SAFE) == 0) ? ENCODE : ENCODE_WEBSAFE;
            tail = new byte[2];
            tailLen = 0;
            count = do_newline ? LINE_GROUPS : -1;
            // ---------- Original Method ----------
            //this.output = output;
            //do_padding = (flags & NO_PADDING) == 0;
            //do_newline = (flags & NO_WRAP) == 0;
            //do_cr = (flags & CRLF) != 0;
            //alphabet = ((flags & URL_SAFE) == 0) ? ENCODE : ENCODE_WEBSAFE;
            //tail = new byte[2];
            //tailLen = 0;
            //count = do_newline ? LINE_GROUPS : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.127 -0400", hash_original_method = "9D3D65123317D09985A4DE210ACBFBB3", hash_generated_method = "A446354B1FAC920764BC883E147E7F31")
        @DSModeled(DSC.SAFE)
        public int maxOutputSize(int len) {
            dsTaint.addTaint(len);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return len * 8/5 + 10;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.129 -0400", hash_original_method = "551D84DD57FDEAF562D9C2C55207FB04", hash_generated_method = "8C73DE4C612C4A1C357A3F9F9109EE75")
        @DSModeled(DSC.SAFE)
        public boolean process(byte[] input, int offset, int len, boolean finish) {
            dsTaint.addTaint(finish);
            dsTaint.addTaint(input[0]);
            dsTaint.addTaint(len);
            dsTaint.addTaint(offset);
            byte[] alphabet;
            alphabet = this.alphabet;
            byte[] output;
            output = this.output;
            int op;
            op = 0;
            int count;
            count = this.count;
            int p;
            p = offset;
            len += offset;
            int v;
            v = -1;
            //Begin case 1 
            {
                v = ((tail[0] & 0xff) << 16) |
                            ((input[p++] & 0xff) << 8) |
                            (input[p++] & 0xff);
                tailLen = 0;
            } //End block
            //End case 1 
            //Begin case 1 
            ;
            //End case 1 
            //Begin case 2 
            {
                v = ((tail[0] & 0xff) << 16) |
                            ((tail[1] & 0xff) << 8) |
                            (input[p++] & 0xff);
                tailLen = 0;
            } //End block
            //End case 2 
            {
                output[op++] = alphabet[(v >> 18) & 0x3f];
                output[op++] = alphabet[(v >> 12) & 0x3f];
                output[op++] = alphabet[(v >> 6) & 0x3f];
                output[op++] = alphabet[v & 0x3f];
                {
                    output[op++] = '\r';
                    output[op++] = '\n';
                    count = LINE_GROUPS;
                } //End block
            } //End block
            {
                v = ((input[p] & 0xff) << 16) |
                    ((input[p+1] & 0xff) << 8) |
                    (input[p+2] & 0xff);
                output[op] = alphabet[(v >> 18) & 0x3f];
                output[op+1] = alphabet[(v >> 12) & 0x3f];
                output[op+2] = alphabet[(v >> 6) & 0x3f];
                output[op+3] = alphabet[v & 0x3f];
                p += 3;
                op += 4;
                {
                    output[op++] = '\r';
                    output[op++] = '\n';
                    count = LINE_GROUPS;
                } //End block
            } //End block
            {
                {
                    int t;
                    t = 0;
                    v = ((tailLen > 0 ? tail[t++] : input[p++]) & 0xff) << 4;
                    tailLen -= t;
                    output[op++] = alphabet[(v >> 6) & 0x3f];
                    output[op++] = alphabet[v & 0x3f];
                    {
                        output[op++] = '=';
                        output[op++] = '=';
                    } //End block
                    {
                        output[op++] = '\r';
                        output[op++] = '\n';
                    } //End block
                } //End block
                {
                    int t;
                    t = 0;
                    v = (((tailLen > 1 ? tail[t++] : input[p++]) & 0xff) << 10) |
                        (((tailLen > 0 ? tail[t++] : input[p++]) & 0xff) << 2);
                    tailLen -= t;
                    output[op++] = alphabet[(v >> 12) & 0x3f];
                    output[op++] = alphabet[(v >> 6) & 0x3f];
                    output[op++] = alphabet[v & 0x3f];
                    {
                        output[op++] = '=';
                    } //End block
                    {
                        output[op++] = '\r';
                        output[op++] = '\n';
                    } //End block
                } //End block
                {
                    output[op++] = '\r';
                    output[op++] = '\n';
                } //End block
            } //End block
            {
                {
                    tail[tailLen++] = input[p];
                } //End block
                {
                    tail[tailLen++] = input[p];
                    tail[tailLen++] = input[p+1];
                } //End block
            } //End block
            this.op = op;
            this.count = count;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public static final int LINE_GROUPS = 19;
        private static final byte ENCODE[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/',
        };
        private static final byte ENCODE_WEBSAFE[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_',
        };
    }


    
    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int CRLF = 4;
    public static final int URL_SAFE = 8;
    public static final int NO_CLOSE = 16;
}

