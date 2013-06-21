package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;

class BerTlv {
    private int mTag = BER_UNKNOWN_TAG;
    private List<ComprehensionTlv> mCompTlvs = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.619 -0400", hash_original_method = "5C874FE61091A7FA99CA633BD5413E3E", hash_generated_method = "D24C715011C067A3D2DA949FCC97198B")
    @DSModeled(DSC.SAFE)
    private BerTlv(int tag, List<ComprehensionTlv> ctlvs) {
        dsTaint.addTaint(ctlvs.dsTaint);
        dsTaint.addTaint(tag);
        // ---------- Original Method ----------
        //mTag = tag;
        //mCompTlvs = ctlvs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.619 -0400", hash_original_method = "4DB54AB9F503DA894E5725BF1F0BC01C", hash_generated_method = "2DC37AE08BE395177B74F5BBD982F960")
    @DSModeled(DSC.SAFE)
    public List<ComprehensionTlv> getComprehensionTlvs() {
        return (List<ComprehensionTlv>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCompTlvs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.620 -0400", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "48EB4F475AC96BE46AF0C5DC5A3DD5D5")
    @DSModeled(DSC.SAFE)
    public int getTag() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTag;
    }

    
        public static BerTlv decode(byte[] data) throws ResultException {
        int curIndex = 0;
        int endIndex = data.length;
        int tag, length = 0;
        try {
            tag = data[curIndex++] & 0xff;
            if (tag == BER_PROACTIVE_COMMAND_TAG) {
                int temp = data[curIndex++] & 0xff;
                if (temp < 0x80) {
                    length = temp;
                } else if (temp == 0x81) {
                    temp = data[curIndex++] & 0xff;
                    if (temp < 0x80) {
                        throw new ResultException(
                                ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                    }
                    length = temp;
                } else {
                    throw new ResultException(
                            ResultCode.CMD_DATA_NOT_UNDERSTOOD);
                }
            } else {
                if (ComprehensionTlvTag.COMMAND_DETAILS.value() == (tag & ~0x80)) {
                    tag = BER_UNKNOWN_TAG;
                    curIndex = 0;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new ResultException(ResultCode.REQUIRED_VALUES_MISSING);
        } catch (ResultException e) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        if (endIndex - curIndex < length) {
            throw new ResultException(ResultCode.CMD_DATA_NOT_UNDERSTOOD);
        }
        List<ComprehensionTlv> ctlvs = ComprehensionTlv.decodeMany(data,
                curIndex);
        return new BerTlv(tag, ctlvs);
    }

    
    public static final int BER_UNKNOWN_TAG             = 0x00;
    public static final int BER_PROACTIVE_COMMAND_TAG   = 0xd0;
    public static final int BER_MENU_SELECTION_TAG      = 0xd3;
    public static final int BER_EVENT_DOWNLOAD_TAG      = 0xd6;
}

