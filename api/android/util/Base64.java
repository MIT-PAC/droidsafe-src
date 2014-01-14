package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;

public class Base64 {

    //  --------------------------------------------------------
    //  decoding
    //  --------------------------------------------------------

    /**
     * Decode the Base64-encoded data in input and return the data in
     * a new byte array.
     *
     * <p>The padding '=' characters at the end are considered optional, but
     * if any are present, there must be the correct number of them.
     *
     * @param str    the input String to decode, which is converted to
     *               bytes using the default charset
     * @param flags  controls certain features of the decoded output.
     *               Pass {@code DEFAULT} to decode standard Base64.
     *
     * @throws IllegalArgumentException if the input contains
     * incorrect padding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.839 -0500", hash_original_method = "D2F55864406EBEBDF4F8980B58236A85", hash_generated_method = "66ADEDD57E8DF67551C8904E7C1A8996")
    
public static byte[] decode(String str, int flags) {
        return decode(str.getBytes(), flags);
    }

    /**
     * Decode the Base64-encoded data in input and return the data in
     * a new byte array.
     *
     * <p>The padding '=' characters at the end are considered optional, but
     * if any are present, there must be the correct number of them.
     *
     * @param input the input array to decode
     * @param flags  controls certain features of the decoded output.
     *               Pass {@code DEFAULT} to decode standard Base64.
     *
     * @throws IllegalArgumentException if the input contains
     * incorrect padding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.841 -0500", hash_original_method = "ACD53DE2D88BBAB4B72FDF61BEE83076", hash_generated_method = "F3FD65D235E64E72F9A5E7B532538D46")
    
public static byte[] decode(byte[] input, int flags) {
        return decode(input, 0, input.length, flags);
    }

    /**
     * Decode the Base64-encoded data in input and return the data in
     * a new byte array.
     *
     * <p>The padding '=' characters at the end are considered optional, but
     * if any are present, there must be the correct number of them.
     *
     * @param input  the data to decode
     * @param offset the position within the input array at which to start
     * @param len    the number of bytes of input to decode
     * @param flags  controls certain features of the decoded output.
     *               Pass {@code DEFAULT} to decode standard Base64.
     *
     * @throws IllegalArgumentException if the input contains
     * incorrect padding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.844 -0500", hash_original_method = "795AFD2FD16C81A1775B830E04DF9E9F", hash_generated_method = "E1784E1E0B1A65AD0A028EC0396E05B0")
    
public static byte[] decode(byte[] input, int offset, int len, int flags) {
        // Allocate space for the most data the input could represent.
        // (It could contain less if it contains whitespace, etc.)
        Decoder decoder = new Decoder(flags, new byte[len*3/4]);

        if (!decoder.process(input, offset, len, true)) {
            throw new IllegalArgumentException("bad base-64");
        }

        // Maybe we got lucky and allocated exactly enough output space.
        if (decoder.op == decoder.output.length) {
            return decoder.output;
        }

        // Need to shorten the array, so allocate a new one of the
        // right size and copy.
        byte[] temp = new byte[decoder.op];
        System.arraycopy(decoder.output, 0, temp, 0, decoder.op);
        return temp;
    }

    //  --------------------------------------------------------
    //  encoding
    //  --------------------------------------------------------

    /**
     * Base64-encode the given data and return a newly allocated
     * String with the result.
     *
     * @param input  the data to encode
     * @param flags  controls certain features of the encoded output.
     *               Passing {@code DEFAULT} results in output that
     *               adheres to RFC 2045.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.883 -0500", hash_original_method = "9F8B8F16A23EE15117AB1FE2B512CD16", hash_generated_method = "5678F807C5ED664186D0648015429F71")
    
public static String encodeToString(byte[] input, int flags) {
        try {
            return new String(encode(input, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            // US-ASCII is guaranteed to be available.
            throw new AssertionError(e);
        }
    }

    /**
     * Base64-encode the given data and return a newly allocated
     * String with the result.
     *
     * @param input  the data to encode
     * @param offset the position within the input array at which to
     *               start
     * @param len    the number of bytes of input to encode
     * @param flags  controls certain features of the encoded output.
     *               Passing {@code DEFAULT} results in output that
     *               adheres to RFC 2045.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.885 -0500", hash_original_method = "A12D3DC1982AC39840BA4C25FDD2D3BE", hash_generated_method = "047A122D3A75AEB424BF4A43E04D2130")
    
public static String encodeToString(byte[] input, int offset, int len, int flags) {
        try {
            return new String(encode(input, offset, len, flags), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            // US-ASCII is guaranteed to be available.
            throw new AssertionError(e);
        }
    }

    /**
     * Base64-encode the given data and return a newly allocated
     * byte[] with the result.
     *
     * @param input  the data to encode
     * @param flags  controls certain features of the encoded output.
     *               Passing {@code DEFAULT} results in output that
     *               adheres to RFC 2045.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.887 -0500", hash_original_method = "7D93E16B367D9ED35C3EE948B04BB0A6", hash_generated_method = "8EA208C8C2B286660EC1A107CC3ADB9E")
    
public static byte[] encode(byte[] input, int flags) {
        return encode(input, 0, input.length, flags);
    }

    /**
     * Base64-encode the given data and return a newly allocated
     * byte[] with the result.
     *
     * @param input  the data to encode
     * @param offset the position within the input array at which to
     *               start
     * @param len    the number of bytes of input to encode
     * @param flags  controls certain features of the encoded output.
     *               Passing {@code DEFAULT} results in output that
     *               adheres to RFC 2045.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.894 -0500", hash_original_method = "E1555B173FAD4BF288A7EC4FC77FC937", hash_generated_method = "40D1FF3B844E6AB8871233CF1984FB22")
    
public static byte[] encode(byte[] input, int offset, int len, int flags) {
        Encoder encoder = new Encoder(flags, null);

        // Compute the exact length of the array we will produce.
        int output_len = len / 3 * 4;

        // Account for the tail of the data and the padding bytes, if any.
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

        // Account for the newlines, if any.
        if (encoder.do_newline && len > 0) {
            output_len += (((len-1) / (3 * Encoder.LINE_GROUPS)) + 1) *
                (encoder.do_cr ? 2 : 1);
        }

        encoder.output = new byte[output_len];
        encoder.process(input, offset, len, true);

        assert encoder.op == output_len;

        return encoder.output;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.813 -0500", hash_original_field = "83EA75ECA2D71F21AD72E47BF00B465F", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

    public static final int DEFAULT = 0;
    
    static abstract class Coder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.828 -0500", hash_original_field = "DC78FA07CC10DBEB15408EF44F988DA2", hash_generated_field = "D105CC424D01A80053DB00A4050DABF0")

        public byte[] output;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.830 -0500", hash_original_field = "FFDD70CACFDCC6D3BE3A85B514D02D77", hash_generated_field = "2CC8ED7F6ECA7F350E8D1039E35F5E73")

        public int op;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.575 -0400", hash_original_method = "1EFD9A0D338C10B7A776AFC361894E38", hash_generated_method = "1EFD9A0D338C10B7A776AFC361894E38")
        public Coder ()
        {
            //Synthesized constructor
        }

        /**
         * Encode/decode another block of input data.  this.output is
         * provided by the caller, and must be big enough to hold all
         * the coded data.  On exit, this.opwill be set to the length
         * of the coded data.
         *
         * @param finish true if this is the final call to process for
         *        this object.  Will finalize the coder state and
         *        include any final bytes in the output.
         *
         * @return true if the input so far is good; false if some
         *         error has been detected in the input stream..
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.833 -0500", hash_original_method = "75EE07B248864EAE893E28029B66362E", hash_generated_method = "2450F1E12888A2FB60B9FCD35235052A")
        
public abstract boolean process(byte[] input, int offset, int len, boolean finish);

        /**
         * @return the maximum number of bytes a call to process()
         * could produce for the given number of input bytes.  This may
         * be an overestimate.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.835 -0500", hash_original_method = "00005B72510A57CC06F375BAC4161ADC", hash_generated_method = "8FC7EA328F9FD1DA3A7C48BE37C3997A")
        
public abstract int maxOutputSize(int len);
        
    }
    
    static class Decoder extends Coder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.849 -0500", hash_original_field = "4734027D7CB76D9F75A473B448E011A2", hash_generated_field = "C476360DF9D857A2925681052DA07C19")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.853 -0500", hash_original_field = "E5E062587C885B1589151F2A04C932C3", hash_generated_field = "D484883C2C35399CF99348476C2D0A97")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.856 -0500", hash_original_field = "DF77CA57276F4D8160BCFF9791738856", hash_generated_field = "4F546CF4B8E245683DB60010E7DCC5AA")

        private static final int SKIP = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.859 -0500", hash_original_field = "455BE393DF2EDF8F7552DA930393D960", hash_generated_field = "15968FF04D715A124A2832120101F3DA")

        private static final int EQUALS = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.861 -0500", hash_original_field = "962E680994F097CBCF73193974918C63", hash_generated_field = "26F20A2ED327951B7F331D22F1CEEC90")

        private int state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.863 -0500", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "810C3DA5CE7DA1BA423D6BE76816E5C9")

        private int value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.865 -0500", hash_original_field = "8346BBC6668B394F591BA98D61419AC5", hash_generated_field = "B4B64C8D6FAE0E02F5E7C4A49CB38458")

         private int[] alphabet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.867 -0500", hash_original_method = "28200CA179B3214BB831C341BA07009C", hash_generated_method = "BFDC7A7997A76245AF50D66FA4CA33AE")
        
public Decoder(int flags, byte[] output) {
            this.output = output;

            alphabet = ((flags & URL_SAFE) == 0) ? DECODE : DECODE_WEBSAFE;
            state = 0;
            value = 0;
        }

        /**
         * @return an overestimate for the number of bytes {@code
         * len} bytes could decode to.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.870 -0500", hash_original_method = "006B314D1443F75FACC9C9CF957F4174", hash_generated_method = "8C053730630C91682B0D48109BFD4C9B")
        
public int maxOutputSize(int len) {
            return len * 3/4 + 10;
        }

        /**
         * Decode another block of input data.
         *
         * @return true if the state machine is still healthy.  false if
         *         bad base-64 data has been detected in the input stream.
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.875 -0500", hash_original_method = "5E49CA254C7BA97645BE526448794F2D", hash_generated_method = "D0DA8E8FC33BE93729D64D25C1A83448")
        
public boolean process(byte[] input, int offset, int len, boolean finish) {
            if (this.state == 6) return false;

            int p = offset;
            len += offset;

            // Using local variables makes the decoder about 12%
            // faster than if we manipulate the member variables in
            // the loop.  (Even alphabet makes a measurable
            // difference, which is somewhat surprising to me since
            // the member variable is final.)
            int state = this.state;
            int value = this.value;
            int op = 0;
            final byte[] output = this.output;
            final int[] alphabet = this.alphabet;

            while (p < len) {
                // Try the fast path:  we're starting a new tuple and the
                // next four bytes of the input stream are all data
                // bytes.  This corresponds to going through states
                // 0-1-2-3-0.  We expect to use this method for most of
                // the data.
                //
                // If any of the next four bytes of input are non-data
                // (whitespace, etc.), value will end up negative.  (All
                // the non-data values in decode are small negative
                // numbers, so shifting any of them up and or'ing them
                // together will result in a value with its top bit set.)
                //
                // You can remove this whole block and the output should
                // be the same, just slower.
                if (state == 0) {
                    while (p+4 <= len &&
                           (value = ((alphabet[input[p] & 0xff] << 18) |
                                     (alphabet[input[p+1] & 0xff] << 12) |
                                     (alphabet[input[p+2] & 0xff] << 6) |
                                     (alphabet[input[p+3] & 0xff]))) >= 0) {
                        output[op+2] = (byte) value;
                        output[op+1] = (byte) (value >> 8);
                        output[op] = (byte) (value >> 16);
                        op += 3;
                        p += 4;
                    }
                    if (p >= len) break;
                }

                // The fast path isn't available -- either we've read a
                // partial tuple, or the next four input bytes aren't all
                // data, or whatever.  Fall back to the slower state
                // machine implementation.

                int d = alphabet[input[p++] & 0xff];

                switch (state) {
                case 0:
                    if (d >= 0) {
                        value = d;
                        ++state;
                    } else if (d != SKIP) {
                        this.state = 6;
                        return false;
                    }
                    break;

                case 1:
                    if (d >= 0) {
                        value = (value << 6) | d;
                        ++state;
                    } else if (d != SKIP) {
                        this.state = 6;
                        return false;
                    }
                    break;

                case 2:
                    if (d >= 0) {
                        value = (value << 6) | d;
                        ++state;
                    } else if (d == EQUALS) {
                        // Emit the last (partial) output tuple;
                        // expect exactly one more padding character.
                        output[op++] = (byte) (value >> 4);
                        state = 4;
                    } else if (d != SKIP) {
                        this.state = 6;
                        return false;
                    }
                    break;

                case 3:
                    if (d >= 0) {
                        // Emit the output triple and return to state 0.
                        value = (value << 6) | d;
                        output[op+2] = (byte) value;
                        output[op+1] = (byte) (value >> 8);
                        output[op] = (byte) (value >> 16);
                        op += 3;
                        state = 0;
                    } else if (d == EQUALS) {
                        // Emit the last (partial) output tuple;
                        // expect no further data or padding characters.
                        output[op+1] = (byte) (value >> 2);
                        output[op] = (byte) (value >> 10);
                        op += 2;
                        state = 5;
                    } else if (d != SKIP) {
                        this.state = 6;
                        return false;
                    }
                    break;

                case 4:
                    if (d == EQUALS) {
                        ++state;
                    } else if (d != SKIP) {
                        this.state = 6;
                        return false;
                    }
                    break;

                case 5:
                    if (d != SKIP) {
                        this.state = 6;
                        return false;
                    }
                    break;
                }
            }

            if (!finish) {
                // We're out of input, but a future call could provide
                // more.
                this.state = state;
                this.value = value;
                this.op = op;
                return true;
            }

            // Done reading input.  Now figure out where we are left in
            // the state machine and finish up.

            switch (state) {
            case 0:
                // Output length is a multiple of three.  Fine.
                break;
            case 1:
                // Read one extra input byte, which isn't enough to
                // make another output byte.  Illegal.
                this.state = 6;
                return false;
            case 2:
                // Read two extra input bytes, enough to emit 1 more
                // output byte.  Fine.
                output[op++] = (byte) (value >> 4);
                break;
            case 3:
                // Read three extra input bytes, enough to emit 2 more
                // output bytes.  Fine.
                output[op++] = (byte) (value >> 10);
                output[op++] = (byte) (value >> 2);
                break;
            case 4:
                // Read one padding '=' when we expected 2.  Illegal.
                this.state = 6;
                return false;
            case 5:
                // Read all the padding '='s we expected and no more.
                // Fine.
                break;
            }

            this.state = state;
            this.op = op;
            return true;
        }
    }
    
    static class Encoder extends Coder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.898 -0500", hash_original_field = "32DE0AEE9A9AD44E0EAA72456C29CB84", hash_generated_field = "AEA37AD1BAA7CFE9FF857DBCC9155C6B")

        public static final int LINE_GROUPS = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.900 -0500", hash_original_field = "D9D68994C5CB1D774E15DB341D18872C", hash_generated_field = "99FC3B7700D42E7A1429B46B2DABA37C")

        private static final byte ENCODE[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/',
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.903 -0500", hash_original_field = "EB1BFC2ABF225B31ECEC8B9032333287", hash_generated_field = "DD402FEA9A4EE03692FE1322010C2742")

        private static final byte ENCODE_WEBSAFE[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_',
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.906 -0500", hash_original_field = "40F5D2974BD0024720371B89C57AA7FB", hash_generated_field = "3976D48215D9CD369B9FF1E7AF7204AD")

         private byte[] tail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.907 -0500", hash_original_field = "7F978AE0FA51DCF6FD5C73F0C45A5FAC", hash_generated_field = "7F978AE0FA51DCF6FD5C73F0C45A5FAC")
 int tailLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.910 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

        private int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.912 -0500", hash_original_field = "959BD29AF9EB12C06F64B2F61624FED0", hash_generated_field = "4E0FC1C064D8F3218FE12A1DD5866176")

         public boolean do_padding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.914 -0500", hash_original_field = "F60F42998F372F78CCD1317E069EF47C", hash_generated_field = "232A0ACDB2D945A1E8AF0B685CCC1422")

         public boolean do_newline;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.917 -0500", hash_original_field = "CDBF013D90D57D08BE469AE1EF4D8833", hash_generated_field = "C3A36DCB9AD646054DE6D44BB1B8EC47")

         public boolean do_cr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.919 -0500", hash_original_field = "3A387067914E47222CDF80CD1F5FF5E3", hash_generated_field = "01F03DE41626851E3A4CAC48E94745D3")

         private byte[] alphabet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.922 -0500", hash_original_method = "248AE984D731F285F53C3C8EA52608A3", hash_generated_method = "EFEF80418BA1735EA6DF13A0B10FC032")
        
public Encoder(int flags, byte[] output) {
            this.output = output;

            do_padding = (flags & NO_PADDING) == 0;
            do_newline = (flags & NO_WRAP) == 0;
            do_cr = (flags & CRLF) != 0;
            alphabet = ((flags & URL_SAFE) == 0) ? ENCODE : ENCODE_WEBSAFE;

            tail = new byte[2];
            tailLen = 0;

            count = do_newline ? LINE_GROUPS : -1;
        }

        /**
         * @return an overestimate for the number of bytes {@code
         * len} bytes could encode to.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.924 -0500", hash_original_method = "9D3D65123317D09985A4DE210ACBFBB3", hash_generated_method = "DEEDEF9FAB68ADAB7777BDE4B742D0C3")
        
public int maxOutputSize(int len) {
            return len * 8/5 + 10;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.930 -0500", hash_original_method = "551D84DD57FDEAF562D9C2C55207FB04", hash_generated_method = "E24CD75C7DBE44D1CE459EE219769AC3")
        
public boolean process(byte[] input, int offset, int len, boolean finish) {
            // Using local variables makes the encoder about 9% faster.
            final byte[] alphabet = this.alphabet;
            final byte[] output = this.output;
            int op = 0;
            int count = this.count;

            int p = offset;
            len += offset;
            int v = -1;

            // First we need to concatenate the tail of the previous call
            // with any input bytes available now and see if we can empty
            // the tail.

            switch (tailLen) {
                case 0:
                    // There was no tail.
                    break;

                case 1:
                    if (p+2 <= len) {
                        // A 1-byte tail with at least 2 bytes of
                        // input available now.
                        v = ((tail[0] & 0xff) << 16) |
                            ((input[p++] & 0xff) << 8) |
                            (input[p++] & 0xff);
                        tailLen = 0;
                    };
                    break;

                case 2:
                    if (p+1 <= len) {
                        // A 2-byte tail with at least 1 byte of input.
                        v = ((tail[0] & 0xff) << 16) |
                            ((tail[1] & 0xff) << 8) |
                            (input[p++] & 0xff);
                        tailLen = 0;
                    }
                    break;
            }

            if (v != -1) {
                output[op++] = alphabet[(v >> 18) & 0x3f];
                output[op++] = alphabet[(v >> 12) & 0x3f];
                output[op++] = alphabet[(v >> 6) & 0x3f];
                output[op++] = alphabet[v & 0x3f];
                if (--count == 0) {
                    if (do_cr) output[op++] = '\r';
                    output[op++] = '\n';
                    count = LINE_GROUPS;
                }
            }

            // At this point either there is no tail, or there are fewer
            // than 3 bytes of input available.

            // The main loop, turning 3 input bytes into 4 output bytes on
            // each iteration.
            while (p+3 <= len) {
                v = ((input[p] & 0xff) << 16) |
                    ((input[p+1] & 0xff) << 8) |
                    (input[p+2] & 0xff);
                output[op] = alphabet[(v >> 18) & 0x3f];
                output[op+1] = alphabet[(v >> 12) & 0x3f];
                output[op+2] = alphabet[(v >> 6) & 0x3f];
                output[op+3] = alphabet[v & 0x3f];
                p += 3;
                op += 4;
                if (--count == 0) {
                    if (do_cr) output[op++] = '\r';
                    output[op++] = '\n';
                    count = LINE_GROUPS;
                }
            }

            if (finish) {
                // Finish up the tail of the input.  Note that we need to
                // consume any bytes in tail before any bytes
                // remaining in input; there should be at most two bytes
                // total.

                if (p-tailLen == len-1) {
                    int t = 0;
                    v = ((tailLen > 0 ? tail[t++] : input[p++]) & 0xff) << 4;
                    tailLen -= t;
                    output[op++] = alphabet[(v >> 6) & 0x3f];
                    output[op++] = alphabet[v & 0x3f];
                    if (do_padding) {
                        output[op++] = '=';
                        output[op++] = '=';
                    }
                    if (do_newline) {
                        if (do_cr) output[op++] = '\r';
                        output[op++] = '\n';
                    }
                } else if (p-tailLen == len-2) {
                    int t = 0;
                    v = (((tailLen > 1 ? tail[t++] : input[p++]) & 0xff) << 10) |
                        (((tailLen > 0 ? tail[t++] : input[p++]) & 0xff) << 2);
                    tailLen -= t;
                    output[op++] = alphabet[(v >> 12) & 0x3f];
                    output[op++] = alphabet[(v >> 6) & 0x3f];
                    output[op++] = alphabet[v & 0x3f];
                    if (do_padding) {
                        output[op++] = '=';
                    }
                    if (do_newline) {
                        if (do_cr) output[op++] = '\r';
                        output[op++] = '\n';
                    }
                } else if (do_newline && op > 0 && count != LINE_GROUPS) {
                    if (do_cr) output[op++] = '\r';
                    output[op++] = '\n';
                }

                assert tailLen == 0;
                assert p == len;
            } else {
                // Save the leftovers in tail to be consumed on the next
                // call to encodeInternal.

                if (p == len-1) {
                    tail[tailLen++] = input[p];
                } else if (p == len-2) {
                    tail[tailLen++] = input[p];
                    tail[tailLen++] = input[p+1];
                }
            }

            this.op = op;
            this.count = count;

            return true;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.815 -0500", hash_original_field = "F77A9A566C76A821318FEBE33179B60F", hash_generated_field = "90B2069C15AB13D219B27D01B76F7345")

    public static final int NO_PADDING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.818 -0500", hash_original_field = "DCA6A36C3C0DE146F3DEABF2E82D68C1", hash_generated_field = "DD1DB73525C3F37E3BC419AB114C4B75")

    public static final int NO_WRAP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.820 -0500", hash_original_field = "DABBD105F6BB7795E87C5B29AE89EF7F", hash_generated_field = "2556AB718F122F12992982C57F5C3502")

    public static final int CRLF = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.822 -0500", hash_original_field = "1955709B6B8F6C5BD784C32B86A98D23", hash_generated_field = "E5A3AC6BA5190912C47BD41618AC8C0F")

    public static final int URL_SAFE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.824 -0500", hash_original_field = "3743B5F5902C950C19B85FE84F180E0B", hash_generated_field = "F8D813B2752942D8E0142FAF2E00BDCC")

    public static final int NO_CLOSE = 16;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:23.936 -0500", hash_original_method = "B12DC6BE1A1E2EB3A4F484EDEACB8E03", hash_generated_method = "C3084AA7D5019852EF92F271F4A0E81D")
    
private Base64() { }
}

