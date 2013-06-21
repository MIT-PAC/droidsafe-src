package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

class ComprehensionTlv {
    private int mTag;
    private boolean mCr;
    private int mLength;
    private int mValueIndex;
    private byte[] mRawValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.881 -0400", hash_original_method = "F083BF2976A39A70E87A329F21B5205D", hash_generated_method = "A93C94D171D6B175A29F918B3897D2FB")
    @DSModeled(DSC.SAFE)
    protected ComprehensionTlv(int tag, boolean cr, int length, byte[] data,
            int valueIndex) {
        dsTaint.addTaint(cr);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(valueIndex);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(length);
        // ---------- Original Method ----------
        //mTag = tag;
        //mCr = cr;
        //mLength = length;
        //mValueIndex = valueIndex;
        //mRawValue = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.882 -0400", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "48EB4F475AC96BE46AF0C5DC5A3DD5D5")
    @DSModeled(DSC.SAFE)
    public int getTag() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.882 -0400", hash_original_method = "BBBB347994ECBB1AA0023AC2A90F5AE7", hash_generated_method = "6030F7139640AC680DCA92A41622BDEC")
    @DSModeled(DSC.SAFE)
    public boolean isComprehensionRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.882 -0400", hash_original_method = "6E6502D65176BC2328E9B790ED2B205C", hash_generated_method = "69A5447F2179C1E4D83456F316EA279F")
    @DSModeled(DSC.SAFE)
    public int getLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.882 -0400", hash_original_method = "6B24631B893BC9498B1E30027D9EDCB1", hash_generated_method = "D499973267F3AE3AF3D089F41295566D")
    @DSModeled(DSC.SAFE)
    public int getValueIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValueIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.882 -0400", hash_original_method = "2E1D90837620CE8C27D1ADC653AC7836", hash_generated_method = "1D0DC9B7A0E89948A87B9AD5FFCAB6AB")
    @DSModeled(DSC.SAFE)
    public byte[] getRawValue() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mRawValue;
    }

    
        public static List<ComprehensionTlv> decodeMany(byte[] data, int startIndex) throws ResultException {
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

    
        public static ComprehensionTlv decode(byte[] data, int startIndex) throws ResultException {
        try {
            int curIndex = startIndex;
            int endIndex = data.length;
            int tag;
            boolean cr; 
            int temp = data[curIndex++] & 0xff;
            switch (temp) {
            case 0:
            case 0xff:
            case 0x80:
                return null;
            case 0x7f: 
                tag = ((data[curIndex] & 0xff) << 8)
                        | (data[curIndex + 1] & 0xff);
                cr = (tag & 0x8000) != 0;
                tag &= ~0x8000;
                curIndex += 2;
                break;
            default: 
                tag = temp;
                cr = (tag & 0x80) != 0;
                tag &= ~0x80;
                break;
            }
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

    
    private static final String LOG_TAG = "ComprehensionTlv";
}

