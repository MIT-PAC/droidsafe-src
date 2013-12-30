package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;






class ComprehensionTlv {

    /**
     * Parses a list of COMPREHENSION-TLV objects from a byte array.
     *
     * @param data A byte array containing data to be parsed
     * @param startIndex Index in data at which to start parsing
     * @return A list of COMPREHENSION-TLV objects parsed
     * @throws ResultException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.959 -0500", hash_original_method = "F2BDC8EF225CC7A51A21F48B4E490296", hash_generated_method = "75E24165127208B8AF8739F55AB06C6E")
    
public static List<ComprehensionTlv> decodeMany(byte[] data, int startIndex)
            throws ResultException {
        ArrayList<ComprehensionTlv> items = new ArrayList<ComprehensionTlv>();
        int endIndex = data.length;
        while (startIndex < endIndex) {
            ComprehensionTlv ctlv = ComprehensionTlv.decode(data, startIndex);
            if (ctlv != null) {
                items.add(ctlv);
                startIndex = ctlv.mValueIndex + ctlv.mLength;
            } else {
                CatLog.d(LOG_TAG, "decodeMany: ctlv is null, stop decoding");
                items.clear();
                break;
            }
        }

        return items;
    }

    /**
     * Parses an COMPREHENSION-TLV object from a byte array.
     *
     * @param data A byte array containing data to be parsed
     * @param startIndex Index in data at which to start parsing
     * @return A COMPREHENSION-TLV object parsed
     * @throws ResultException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.963 -0500", hash_original_method = "528D0C1B73FE44D3972E9181B60A9BF2", hash_generated_method = "E9E31F6841952F2FAD4091E09A2999A9")
    
public static ComprehensionTlv decode(byte[] data, int startIndex)
            throws ResultException {
        try {
            int curIndex = startIndex;
            int endIndex = data.length;

            /* tag */
            int tag;
            boolean cr; // Comprehension required flag
            int temp = data[curIndex++] & 0xff;
            switch (temp) {
            case 0:
            case 0xff:
            case 0x80:
                // for error handling
                // these one make exception while decoding the abnormal command.
                // (in case of Ghana MTN simcard , JDI simcard)
                return null;

            case 0x7f: // tag is in three-byte format
                tag = ((data[curIndex] & 0xff) << 8)
                        | (data[curIndex + 1] & 0xff);
                cr = (tag & 0x8000) != 0;
                tag &= ~0x8000;
                curIndex += 2;
                break;

            default: // tag is in single-byte format
                tag = temp;
                cr = (tag & 0x80) != 0;
                tag &= ~0x80;
                break;
            }

            /* length */
            int length;
            temp = data[curIndex++] & 0xff;
            if (temp < 0x80) {
                length = temp;
            } else if (temp == 0x81) {
                length = data[curIndex++] & 0xff;
                if (length < 0x80) {
                    throw new ResultException(
                            ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
            } else if (temp == 0x82) {
                length = ((data[curIndex] & 0xff) << 8)
                        | (data[curIndex + 1] & 0xff);
                curIndex += 2;
                if (length < 0x100) {
                    throw new ResultException(
                            ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
            } else if (temp == 0x83) {
                length = ((data[curIndex] & 0xff) << 16)
                        | ((data[curIndex + 1] & 0xff) << 8)
                        | (data[curIndex + 2] & 0xff);
                curIndex += 3;
                if (length < 0x10000) {
                    throw new ResultException(
                            ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
            } else {
                throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
            }

            return new ComprehensionTlv(tag, cr, length, data, curIndex);

        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.930 -0500", hash_original_field = "93C378DA4B20D682E3D08E343F202592", hash_generated_field = "0B14812E52CC10D1258CE11D062EA057")

    private static final String LOG_TAG = "ComprehensionTlv";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.933 -0500", hash_original_field = "9984816B5FE48640B78EE6DAAAF27384", hash_generated_field = "BFBA40DE531B5000F1981B7BBF1ED026")

    private int mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.935 -0500", hash_original_field = "EB4718B1AFAD906A4CF1451EA480383E", hash_generated_field = "615830BA9729410C3098ECFE977B653E")

    private boolean mCr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.937 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.940 -0500", hash_original_field = "D3F503AB139D9847C7D4824FC80DA4C1", hash_generated_field = "8FECB3720B086D527CFAD02FEE0B0CCC")

    private int mValueIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.942 -0500", hash_original_field = "6419001B6D695E00C32BADFF6D4AC694", hash_generated_field = "5744D2EFAB71BD258B36C43D2ECBE57E")

    private byte[] mRawValue;

    /**
     * Constructor. Private on purpose. Use
     * {@link #decodeMany(byte[], int) decodeMany} or
     * {@link #decode(byte[], int) decode} method.
     *
     * @param tag The tag for this object
     * @param cr Comprehension Required flag
     * @param length Length of the value
     * @param data Byte array containing the value
     * @param valueIndex Index in data at which the value starts
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.945 -0500", hash_original_method = "F083BF2976A39A70E87A329F21B5205D", hash_generated_method = "AE0D9CC43A95EC4C53C84D11F1B63E3F")
    
protected ComprehensionTlv(int tag, boolean cr, int length, byte[] data,
            int valueIndex) {
        mTag = tag;
        mCr = cr;
        mLength = length;
        mValueIndex = valueIndex;
        mRawValue = data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.947 -0500", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "92179372CE49E6423B644726BDCEE63E")
    
public int getTag() {
        return mTag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.949 -0500", hash_original_method = "BBBB347994ECBB1AA0023AC2A90F5AE7", hash_generated_method = "D1AF91C0ADCD09E68B7F291518F63C97")
    
public boolean isComprehensionRequired() {
        return mCr;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.952 -0500", hash_original_method = "6E6502D65176BC2328E9B790ED2B205C", hash_generated_method = "544B3A7F11FA8D9AB474295517BA3BC2")
    
public int getLength() {
        return mLength;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.954 -0500", hash_original_method = "6B24631B893BC9498B1E30027D9EDCB1", hash_generated_method = "C9F0841A43D3E17AA9D4067501A54E3F")
    
public int getValueIndex() {
        return mValueIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.956 -0500", hash_original_method = "2E1D90837620CE8C27D1ADC653AC7836", hash_generated_method = "6CD4DDF687E624B08BD9D8D0A92D95AE")
    
public byte[] getRawValue() {
        return mRawValue;
    }
}

