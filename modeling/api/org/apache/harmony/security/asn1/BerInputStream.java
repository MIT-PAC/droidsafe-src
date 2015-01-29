package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class BerInputStream {

    /**
     * Returns the length of the encoding
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.832 -0500", hash_original_method = "0FB1A1C4D911EA5AEA102491DDF03FDC", hash_generated_method = "6646F2D5F31AFA5B8CC7AB9E51AFAFE7")
    
public static int getLength(byte[] encoding) {
        int length = encoding[1] & 0xFF;
        int numOctets = 0;
        if ((length & 0x80) != 0) { // long form
            numOctets = length & 0x7F;

            // collect this value length
            length = encoding[2] & 0xFF;
            for (int i = 3; i < numOctets + 2; i++) {
                length = (length << 8) + (encoding[i] & 0xFF);
            }
        }
        //    tag length long_form content
        return 1 + 1 + numOctets + length;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.799 -0500", hash_original_field = "0FA804C035B510D7C5380E04A76E7C66", hash_generated_field = "15AEBAF204B1E1628DA9A9D8B78EB825")

    private static final int BUF_INCREASE_SIZE = 1024 * 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.802 -0500", hash_original_field = "33C8385A41AD10C36334085F976010B5", hash_generated_field = "12A8A7878E72ADED3FB919DC5D266C92")

    protected static final int INDEFINIT_LENGTH = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.792 -0500", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private  InputStream in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.795 -0500", hash_original_field = "3923F3F9F9ECABE8D28493E863FC2CD8", hash_generated_field = "FBA3E90E1AEF84B9DE40F7F93AE8B84B")

    protected byte[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.797 -0500", hash_original_field = "B57AAF7BF5F2E3B125D28448999D0D18", hash_generated_field = "47DA870F49698AFE94AB5C1004A17787")

    protected int offset = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.804 -0500", hash_original_field = "0870A130AAC33D99955FFBF59B769627", hash_generated_field = "FE8BF0CD5CB8CBF698330270CCCC9D95")

    public int tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.806 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.808 -0500", hash_original_field = "D0B8E49E3D027D4128A52EE40E051281", hash_generated_field = "57FED7E8E8FF2184EEF7EFF7F0B770B6")

    public Object content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.811 -0500", hash_original_field = "9EFA788A5F443B270B3D9BE618E7DEB5", hash_generated_field = "1C9B4A7A1F753F59487D78BA9637D2A9")

    protected int tagOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.813 -0500", hash_original_field = "37C4062A644D024415A63A1C2A78204E", hash_generated_field = "EC588CCB12D3A88BA3D161DCA8D8918C")

    protected int contentOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.842 -0500", hash_original_field = "D28F4FB31ED5415017DA18AD47F033DA", hash_generated_field = "0BFC4C9F195DE6B4C0280180D67D78C2")

    public int choiceIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.844 -0500", hash_original_field = "56EBD0F85C51178751B3A06611A0EB2B", hash_generated_field = "13DDA1F04AC379B354F578F22425463A")

    public int[] times;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.862 -0500", hash_original_field = "647293CF90373655D1AC2C7923B61AC3", hash_generated_field = "022E0C44AE6A598FC1C18F39EC6A5FAB")

    public int oidElement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.896 -0500", hash_original_field = "F646C758AA6F4358F9A1160050DDC9A9", hash_generated_field = "7DEBAA72E1DC386A76CC44BDD6E3E330")

    // FIXME it is used only for one case
    // decoding PCKS#8 Private Key Info notation
    // remove this option because it does decoding more complex
    protected boolean isVerify;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.901 -0500", hash_original_field = "618295DE556A36F1EBEE6FF2FD372580", hash_generated_field = "00FF4B69234D0AC263E1AA84F9B79338")

    protected boolean isIndefinedLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.911 -0500", hash_original_field = "73851E582412D1434EEB107AE68FCCD6", hash_generated_field = "052E31DFE5C2BAB4284743C186914165")

    private Object[][] pool;

    /**
     * Creates stream for decoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.816 -0500", hash_original_method = "879F2FC8DE697B067D571C3BF31ADD98", hash_generated_method = "B1F77C3D14748D4B11A7AB0A42350225")
    
public BerInputStream(byte[] encoded) throws IOException {
        this(encoded, 0, encoded.length);
    }

    /**
     * Creates stream for decoding.
     *
     * @param encoded bytes array to be decoded
     * @param offset the encoding offset
     * @param expectedLength expected length of full encoding, this includes
     *     identifier, length an content octets
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.818 -0500", hash_original_method = "FB2C80FA06C3B0FD8EA5024440AD49C3", hash_generated_method = "4C5B9C290142B7ABBA04B3A95FCA1458")
    
public BerInputStream(byte[] encoded, int offset, int expectedLength) throws IOException {
        this.in = null;
        this.buffer = encoded;
        this.offset = offset;

        next();

        // compare expected and decoded length
        if (length != INDEFINIT_LENGTH
                && (offset + expectedLength) != (this.offset + this.length)) {
            throw new ASN1Exception("Wrong content length");
        }
    }

    /**
     * Creates stream for decoding.
     *
     * Allocates initial buffer of default size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.821 -0500", hash_original_method = "43063225C34584E29FE6185CE8AAB05D", hash_generated_method = "5B27F14D1A097ACF1D8099A8852C2B0F")
    
public BerInputStream(InputStream in) throws IOException {
        this(in, BUF_INCREASE_SIZE);
    }

    /**
     * Creates stream for decoding.
     *
     * @param initialSize the internal buffer initial size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.824 -0500", hash_original_method = "ED7F15B5071BF063BB4017E313468A57", hash_generated_method = "D5D72AC315056B38568B3C9B6CCCE6B0")
    
public BerInputStream(InputStream in, int initialSize) throws IOException {
        this.in = in;
        buffer = new byte[initialSize];

        next();

        if (length != INDEFINIT_LENGTH) {
            // input stream has definite length encoding
            // check allocated length to avoid further reallocations
            if (buffer.length < (length + offset)) {
                byte[] newBuffer = new byte[length + offset];
                System.arraycopy(buffer, 0, newBuffer, 0, offset);
                buffer = newBuffer;
            }
        } else {
            isIndefinedLength = true;
            throw new ASN1Exception("Decoding indefinite length encoding is not supported");
        }
    }

    /**
     * Resets this stream to initial state.
     *
     * @param encoded a new bytes array to be decoded
     * @throws IOException if an error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.826 -0500", hash_original_method = "4CCBB4621387969DDD8BDCB7ADDE8473", hash_generated_method = "8F69CBE71464DCC55756BC94777E36CD")
    
public final void reset(byte[] encoded) throws IOException {
        buffer = encoded;
        next();
    }

    /**
     * Decodes next encoded type.
     * Initializes tag, length, tagOffset and contentOffset variables
     *
     * @return next decoded tag
     * @throws IOException if error occured
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.829 -0500", hash_original_method = "E21A3F5A1E5C42E0733DFCD7E2B1A37B", hash_generated_method = "F242D0BB1D05951AAF636A0347CCA641")
    
public int next() throws IOException {
        tagOffset = offset;

        // read tag
        tag = read();

        // read length
        length = read();
        if (length != 0x80) { // definite form
            // long or short length form
            if ((length & 0x80) != 0) { // long form
                int numOctets = length & 0x7F;

                if (numOctets > 5) {
                    throw new ASN1Exception("Too long encoding at [" + tagOffset + "]"); //FIXME message
                }

                // collect this value length
                length = read();
                for (int i = 1; i < numOctets; i++) {
                    int ch = read();
                    length = (length << 8) + ch;//read();
                }

                if (length > 0xFFFFFF) {
                    throw new ASN1Exception("Too long encoding at [" + tagOffset + "]"); //FIXME message
                }
            }
        } else { //indefinite form
            length = INDEFINIT_LENGTH;
        }
        contentOffset = offset;

        return tag;
    }

    /**
     * Decodes ASN.1 bitstring type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.834 -0500", hash_original_method = "A15B72AB03BE363B2B31FA8E7C1F64A3", hash_generated_method = "BC24E837C6B5DC7579AF418877B8F41A")
    
public void readBitString() throws IOException {
        if (tag == ASN1Constants.TAG_BITSTRING) {

            if (length == 0) {
                throw new ASN1Exception("ASN.1 Bitstring: wrong length. Tag at [" + tagOffset + "]");
            }

            readContent();

            // content: check unused bits
            if (buffer[contentOffset] > 7) {
                throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. A number of unused bits MUST be in range 0 to 7");
            }

            if (length == 1 && buffer[contentOffset] != 0) {
                throw new ASN1Exception("ASN.1 Bitstring: wrong content at [" + contentOffset
                        + "]. For empty string unused bits MUST be 0");
            }

        } else if (tag == ASN1Constants.TAG_C_BITSTRING) {
            throw new ASN1Exception("Decoding constructed ASN.1 bitstring  type is not provided");
        } else {
            throw expected("bitstring");
        }
    }

    /**
     * Decodes ASN.1 Enumerated type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.837 -0500", hash_original_method = "70271B544C5D122FB5ABE2DE9A460926", hash_generated_method = "2C7F5A6016FB2375F5ECCDF33662112A")
    
public void readEnumerated() throws IOException {
        if (tag != ASN1Constants.TAG_ENUM) {
            throw expected("enumerated");
        }

        // check encoded length
        if (length == 0) {
            throw new ASN1Exception("ASN.1 enumerated: wrong length for identifier at ["
                    + tagOffset + "]");
        }

        readContent();

        // check encoded content
        if (length > 1) {
            int bits = buffer[contentOffset] & 0xFF;
            if (buffer[contentOffset + 1] < 0) {
                bits += 0x100;
            }

            if (bits == 0 || bits == 0x1FF) {
                throw new ASN1Exception("ASN.1 enumerated: wrong content at [" + contentOffset
                        + "]. An integer MUST be encoded in minimum number of octets");
            }
        }
    }

    /**
     * Decodes ASN.1 boolean type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.840 -0500", hash_original_method = "13F2651D91961A81EAE79BEA9D5230AF", hash_generated_method = "F96484BD6430558F4E312AE6332A922F")
    
public void readBoolean() throws IOException {
        if (tag != ASN1Constants.TAG_BOOLEAN) {
            throw expected("boolean");
        }

        // check encoded length
        if (length != 1) {
            throw new ASN1Exception("Wrong length for ASN.1 boolean at [" + tagOffset + "]");
        }

        readContent();
    }

    /**
     * Decodes ASN.1 GeneralizedTime type
     *
     * @throws IOException if error occured
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.847 -0500", hash_original_method = "1A3161CCB7646B7891B929A5396BF673", hash_generated_method = "A3365AF0BC0474D9A717D764CF6C5240")
    
public void readGeneralizedTime() throws IOException {
        if (tag == ASN1Constants.TAG_GENERALIZEDTIME) {
            // FIXME: any other optimizations?
            readContent();
            // FIXME store string somewhere to allow a custom time type perform
            // additional checks

            // check syntax: the last char MUST be Z
            if (buffer[offset - 1] != 'Z') {
                // FIXME support only format that is acceptable for DER
                throw new ASN1Exception("ASN.1 GeneralizedTime: encoded format is not implemented");
            }

            // check syntax: MUST be YYYYMMDDHHMMSS[(./,)DDD]'Z'
            if (length != 15 && (length < 17 || length > 19)) {
                throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                        + contentOffset + "]");
            }

            // check content: milliseconds
            if (length > 16) {
                byte char14 = buffer[contentOffset + 14];
                if (char14 != '.' && char14 != ',') {
                    throw new ASN1Exception("ASN.1 GeneralizedTime wrongly encoded at ["
                            + contentOffset + "]");
                }
            }

            if (times == null) {
                times = new int[7];
            }
            times[0] = strToInt(contentOffset, 4); // year
            times[1] = strToInt(contentOffset + 4, 2); // month
            times[2] = strToInt(contentOffset + 6, 2); // day
            times[3] = strToInt(contentOffset + 8, 2); // hour
            times[4] = strToInt(contentOffset + 10, 2); // minute
            times[5] = strToInt(contentOffset + 12, 2); // second

            if (length > 16) {
                // FIXME optimize me
                times[6] = strToInt(contentOffset + 15, length - 16);

                if (length == 17) {
                    times[6] = times[6] * 100;
                } else if (length == 18) {
                    times[6] = times[6] * 10;
                }
            }

            // FIXME check all values for valid numbers!!!
        } else if (tag == ASN1Constants.TAG_C_GENERALIZEDTIME) {
            throw new ASN1Exception("Decoding constructed ASN.1 GeneralizedTime type is not supported");
        } else {
            throw expected("GeneralizedTime");
        }
    }

    /**
     * Decodes ASN.1 UTCTime type
     *
     * @throws IOException if an I/O error occurs or the end of the stream is reached
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.850 -0500", hash_original_method = "D1E9408574A13A490CB1D3EF3A359E97", hash_generated_method = "9A6122537C22D78D35FE6D79FCF7903D")
    
public void readUTCTime() throws IOException {
        if (tag == ASN1Constants.TAG_UTCTIME) {
            switch (length) {
            case ASN1UTCTime.UTC_HM:
            case ASN1UTCTime.UTC_HMS:
                break;
            case ASN1UTCTime.UTC_LOCAL_HM:
            case ASN1UTCTime.UTC_LOCAL_HMS:
                // FIXME only coordinated universal time formats are supported
                throw new ASN1Exception("ASN.1 UTCTime: local time format is not supported");
            default:
                throw new ASN1Exception("ASN.1 UTCTime: wrong length, identifier at " + tagOffset);
            }

            // FIXME: any other optimizations?
            readContent();

            // FIXME store string somewhere to allow a custom time type perform
            // additional checks

            // check syntax: the last char MUST be Z
            if (buffer[offset - 1] != 'Z') {
                throw new ASN1Exception("ASN.1 UTCTime wrongly encoded at ["
                        + contentOffset + ']');
            }

            if (times == null) {
                times = new int[7];
            }

            times[0] = strToInt(contentOffset, 2); // year
            if (times[0] > 49) {
                times[0] += 1900;
            } else {
                times[0] += 2000;
            }

            times[1] = strToInt(contentOffset + 2, 2); // month
            times[2] = strToInt(contentOffset + 4, 2); // day
            times[3] = strToInt(contentOffset + 6, 2); // hour
            times[4] = strToInt(contentOffset + 8, 2); // minute

            if (length == ASN1UTCTime.UTC_HMS) {
                times[5] = strToInt(contentOffset + 10, 2); // second
            }

            // FIXME check all time values for valid numbers!!!
        } else if (tag == ASN1Constants.TAG_C_UTCTIME) {
            throw new ASN1Exception("Decoding constructed ASN.1 UTCTime type is not supported");
        } else {
            throw expected("UTCTime");
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.852 -0500", hash_original_method = "7B8FBAB80C5ADD7C25B56AA6C7A7A7A0", hash_generated_method = "BF4901166FF4288F10D96DDB30749C00")
    
private int strToInt(int off, int count) throws ASN1Exception {
        int result = 0;
        for (int i = off, end = off + count; i < end; i++) {
            int c = buffer[i] - 48;
            if (c < 0 || c > 9) {
                throw new ASN1Exception("Time encoding has invalid char");
            }
            result = result * 10 + c;
        }
        return result;
    }

    /**
     * Decodes ASN.1 Integer type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.856 -0500", hash_original_method = "8E0BB334F5FA3F917B6C3297724E29A6", hash_generated_method = "F12DA633716B414DEB1D1B8126ED0973")
    
public void readInteger() throws IOException {
        if (tag != ASN1Constants.TAG_INTEGER) {
            throw expected("integer");
        }

        // check encoded length
        if (length < 1) {
            throw new ASN1Exception("Wrong length for ASN.1 integer at [" + tagOffset + "]");
        }

        readContent();

        // check encoded content
        if (length > 1) {
            byte firstByte = buffer[offset - length];
            byte secondByte = (byte) (buffer[offset - length + 1] & 0x80);

            if (firstByte == 0 && secondByte == 0 || firstByte == (byte) 0xFF
                    && secondByte == (byte) 0x80) {
                throw new ASN1Exception("Wrong content for ASN.1 integer at [" + (offset - length) + "]. An integer MUST be encoded in minimum number of octets");
            }
        }
    }

    /**
     * Decodes ASN.1 Octetstring type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.858 -0500", hash_original_method = "FF10597CCF521EBE62B89D95947AA842", hash_generated_method = "C08A570AB37737F096BEEA638CE020CD")
    
public void readOctetString() throws IOException {
        if (tag == ASN1Constants.TAG_OCTETSTRING) {
            readContent();
        } else if (tag == ASN1Constants.TAG_C_OCTETSTRING) {
            throw new ASN1Exception("Decoding constructed ASN.1 octet string type is not supported");
        } else {
            throw expected("octetstring");
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.860 -0500", hash_original_method = "31EAA277FAF0612B23F88A136EEA2499", hash_generated_method = "98D15EB49171CF1D1DF9A8863A93D604")
    
private ASN1Exception expected(String what) throws ASN1Exception {
        throw new ASN1Exception("ASN.1 " + what + " identifier expected at [" + tagOffset + "], got " + Integer.toHexString(tag));
    }

    /**
     * Decodes ASN.1 ObjectIdentifier type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.865 -0500", hash_original_method = "1DFB0A727BF9534907B350DDA9E1A15B", hash_generated_method = "92AFDADAC888175B664EA1D35DE74759")
    
public void readOID() throws IOException {
        if (tag != ASN1Constants.TAG_OID) {
            throw expected("OID");
        }

        // check encoded length
        if (length < 1) {
            throw new ASN1Exception("Wrong length for ASN.1 object identifier at [" + tagOffset + "]");
        }

        readContent();

        // check content: last encoded byte (8th bit MUST be zero)
        if ((buffer[offset - 1] & 0x80) != 0) {
            throw new ASN1Exception("Wrong encoding at [" + (offset - 1) + "]");
        }

        oidElement = 1;
        for (int i = 0; i < length; i++, ++oidElement) {
            while ((buffer[contentOffset + i] & 0x80) == 0x80) {
                i++;
            }
        }
    }

    /**
     * Decodes ASN.1 Sequence type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.869 -0500", hash_original_method = "97688987A014CB8C0C54BAB32FA72A4F", hash_generated_method = "56E445559C692A12AD7C40B5297E4C77")
    
public void readSequence(ASN1Sequence sequence) throws IOException {
        if (tag != ASN1Constants.TAG_C_SEQUENCE) {
            throw expected("sequence");
        }

        int begOffset = offset;
        int endOffset = begOffset + length;

        ASN1Type[] type = sequence.type;

        int i = 0;

        if (isVerify) {

            for (; (offset < endOffset) && (i < type.length); i++) {

                next();
                while (!type[i].checkTag(tag)) {
                    // check whether it is optional component or not
                    if (!sequence.OPTIONAL[i] || (i == type.length - 1)) {
                        throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                    }
                    i++;
                }

                type[i].decode(this);
            }

            // check the rest of components
            for (; i < type.length; i++) {
                if (!sequence.OPTIONAL[i]) {
                    throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                }
            }

        } else {
            int seqTagOffset = tagOffset; //store tag offset

            Object[] values = new Object[type.length];
            for (; (offset < endOffset) && (i < type.length); i++) {

                next();
                while (!type[i].checkTag(tag)) {
                    // check whether it is optional component or not
                    if (!sequence.OPTIONAL[i] || (i == type.length - 1)) {
                        throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                    }

                    // sets default value
                    if (sequence.DEFAULT[i] != null) {
                        values[i] = sequence.DEFAULT[i];
                    }
                    i++;
                }
                values[i] = type[i].decode(this);
            }

            // check the rest of components
            for (; i < type.length; i++) {
                if (!sequence.OPTIONAL[i]) {
                    throw new ASN1Exception("ASN.1 Sequence: mandatory value is missing at [" + tagOffset + "]");
                }
                if (sequence.DEFAULT[i] != null) {
                    values[i] = sequence.DEFAULT[i];
                }
            }
            content = values;

            tagOffset = seqTagOffset; //retrieve tag offset
        }

        if (offset != endOffset) {
            throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        }
    }

    /**
     * Decodes ASN.1 SequenceOf type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.871 -0500", hash_original_method = "48BA5600C2E0D1ED619B576E3555D97D", hash_generated_method = "0CC713B470916D3231056DE79519FD81")
    
public void readSequenceOf(ASN1SequenceOf sequenceOf) throws IOException {
        if (tag != ASN1Constants.TAG_C_SEQUENCEOF) {
            throw expected("sequenceOf");
        }

        decodeValueCollection(sequenceOf);
    }

    /**
     * Decodes ASN.1 Set type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.873 -0500", hash_original_method = "51B09D41A46E89A1CD0754E5C1F0D1B8", hash_generated_method = "4DB41399A5FE1C6CA2B074D6BDF7F6D9")
    
public void readSet(ASN1Set set) throws IOException {
        if (tag != ASN1Constants.TAG_C_SET) {
            throw expected("set");
        }

        throw new ASN1Exception("Decoding ASN.1 Set type is not supported");
    }

    /**
     * Decodes ASN.1 SetOf type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.876 -0500", hash_original_method = "8593963787440F0A1F5CC05E2CC3EB6D", hash_generated_method = "16077805191F7D77C37AE6EE44605C7C")
    
public void readSetOf(ASN1SetOf setOf) throws IOException {
        if (tag != ASN1Constants.TAG_C_SETOF) {
            throw expected("setOf");
        }

        decodeValueCollection(setOf);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.878 -0500", hash_original_method = "A1B2FAB02C0A9A6283AF8F291FFC1121", hash_generated_method = "B9C167807FCDB2A0145E6F7A34AB8F20")
    
private void decodeValueCollection(ASN1ValueCollection collection) throws IOException {
        int begOffset = offset;
        int endOffset = begOffset + length;

        ASN1Type type = collection.type;

        if (isVerify) {
            while (endOffset > offset) {
                next();
                type.decode(this);
            }
        } else {
            int seqTagOffset = tagOffset; //store tag offset

            ArrayList<Object> values = new ArrayList<Object>();
            while (endOffset > offset) {
                next();
                values.add(type.decode(this));
            }

            values.trimToSize();
            content = values;

            tagOffset = seqTagOffset; //retrieve tag offset
        }

        if (offset != endOffset) {
            throw new ASN1Exception("Wrong encoding at [" + begOffset + "]. Content's length and encoded length are not the same");
        }
    }

    /**
     * Decodes ASN.1 String type
     *
     * @throws IOException if an I/O error occurs or the end of the stream is reached
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.881 -0500", hash_original_method = "2E006816EDCCACEA53589D73DD63B701", hash_generated_method = "6079A4EA9337F722AA40E9EFA0393ECC")
    
public void readString(ASN1StringType type) throws IOException {
        if (tag == type.id) {
            readContent();
        } else if (tag == type.constrId) {
            throw new ASN1Exception("Decoding constructed ASN.1 string type is not provided");
        } else {
            throw expected("string");
        }
    }

    /**
     * Returns encoded array.
     *
     * MUST be invoked after decoding corresponding ASN.1 notation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.883 -0500", hash_original_method = "34E54E473055277C13E19CBB4B194845", hash_generated_method = "9F7D27206220B1C6BB0A3D2077D8922B")
    
public byte[] getEncoded() {
        byte[] encoded = new byte[offset - tagOffset];
        System.arraycopy(buffer, tagOffset, encoded, 0, encoded.length);
        return encoded;
    }

    /**
     * Returns internal buffer used for decoding
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.885 -0500", hash_original_method = "6B125A4F0D6B27C0C7AD41FB42F4DE53", hash_generated_method = "C7AA0F3765AE0D7530A2123ADC8CD16C")
    
public final byte[] getBuffer() {
        return buffer;
    }

    /**
     * Returns length of the current content for decoding
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.887 -0500", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "457BD045D11BE603E9FA82675B77CCA1")
    
public final int getLength() {
        return length;
    }

    /**
     * Returns the current offset
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.889 -0500", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "55949A0CABF96E769EA6A463034457D4")
    
public final int getOffset() {
        return offset;
    }

    /**
     * Returns end offset for the current encoded type
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.892 -0500", hash_original_method = "1367D9753B97C5C3A102B7D6550881B9", hash_generated_method = "1302397FD0CD46F574A94D04F7233E3D")
    
public final int getEndOffset() {
        return offset + length;
    }

    /**
     * Returns start offset for the current encoded type
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.894 -0500", hash_original_method = "1FDDE163F1BBA6CDA778E0FD08E430DE", hash_generated_method = "37CD9E2F6EB7780DBCCB9488B3F60BC8")
    
public final int getTagOffset() {
        return tagOffset;
    }

    /**
     * Sets verify mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.898 -0500", hash_original_method = "E5C1E507EA76A704FAE5F4AC771876E5", hash_generated_method = "14563CAD6B795428AAB3BBE9E533A583")
    
public final void setVerify() {
        isVerify = true;
    }

    /**
     * Reads the next encoded byte from the encoded input stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.903 -0500", hash_original_method = "BBFB621282CA0716A19F3267ACDEEE7E", hash_generated_method = "D4439C1BC1A6C37C21C21979D42281B9")
    
protected int read() throws IOException {
        if (offset == buffer.length) {
            throw new ASN1Exception("Unexpected end of encoding");
        }

        if (in == null) {
            return buffer[offset++] & 0xFF;
        } else {
            int octet = in.read();
            if (octet == -1) {
                throw new ASN1Exception("Unexpected end of encoding");
            }

            buffer[offset++] = (byte) octet;

            return octet;
        }
    }

    /**
     * Reads the next encoded content from the encoded input stream.
     * The method MUST be used for reading a primitive encoded content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.905 -0500", hash_original_method = "73ADE766083E21B57FB910CFDB1C7433", hash_generated_method = "91229CCB0E4F2ABB90EF56194A1717B7")
    
public void readContent() throws IOException {
        if (offset + length > buffer.length) {
            throw new ASN1Exception("Unexpected end of encoding");
        }

        if (in == null) {
            offset += length;
        } else {
            int bytesRead = in.read(buffer, offset, length);

            if (bytesRead != length) {
                // if input stream didn't return all data at once
                // try to read it in several blocks
                int c = bytesRead;
                do {
                    if (c < 1 || bytesRead > length) {
                        throw new ASN1Exception("Failed to read encoded content");
                    }
                    c = in.read(buffer, offset + bytesRead, length - bytesRead);
                    bytesRead += c;
                } while (bytesRead != length);
            }

            offset += length;
        }
    }

    /**
     * Reallocates the buffer in order to make it
     * exactly the size of data it contains
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.909 -0500", hash_original_method = "DCB4E4732715D068A4BB6AF51135E41B", hash_generated_method = "E7066A332B9B947C96E6CE4759DE1E6C")
    
public void compactBuffer() {
        if (offset != buffer.length) {
            byte[] newBuffer = new byte[offset];
            // restore buffer content
            System.arraycopy(buffer, 0, newBuffer, 0, offset);
            // set new buffer
            buffer = newBuffer;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.913 -0500", hash_original_method = "AFFB1C62116A7F4F1AC3586F8D79C157", hash_generated_method = "B774AA0E95A529D00C7B293D7701E1C1")
    
public void put(Object key, Object entry) {
        if (pool == null) {
            pool = new Object[2][10];
        }

        int i = 0;
        for (; i < pool[0].length && pool[0][i] != null; i++) {
            if (pool[0][i] == key) {
                pool[1][i] = entry;
                return;
            }
        }

        if (i == pool[0].length) {
            Object[][] newPool = new Object[pool[0].length * 2][2];
            System.arraycopy(pool[0], 0, newPool[0], 0, pool[0].length);
            System.arraycopy(pool[1], 0, newPool[1], 0, pool[0].length);
            pool = newPool;
        } else {
            pool[0][i] = key;
            pool[1][i] = entry;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.915 -0500", hash_original_method = "5B069BEEA06FE3B546FE9A5858249664", hash_generated_method = "7E6E220E3DBFA6208B9C98B1EDDD7533")
    
public Object get(Object key) {
        if (pool == null) {
            return null;
        }

        for (int i = 0; i < pool[0].length; i++) {
            if (pool[0][i] == key) {
                return pool[1][i];
            }
        }
        return null;
    }
}

