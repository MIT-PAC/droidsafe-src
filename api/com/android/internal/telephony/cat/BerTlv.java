package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.List;

class BerTlv {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.682 -0400", hash_original_field = "585F79BD9B4089B48441D6A5455747E1", hash_generated_field = "39FE9CD97B9AFEAEBF1F07C1BE8432FF")

    private int mTag = BER_UNKNOWN_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.682 -0400", hash_original_field = "3FF1C48858768C6F47B2C17D93779E9A", hash_generated_field = "D44204BE63F06CA8F47FCF402390D741")

    private List<ComprehensionTlv> mCompTlvs = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.682 -0400", hash_original_method = "5C874FE61091A7FA99CA633BD5413E3E", hash_generated_method = "07694EC6CD4A63F924055EE17B7B86F1")
    private  BerTlv(int tag, List<ComprehensionTlv> ctlvs) {
        mTag = tag;
        mCompTlvs = ctlvs;
        // ---------- Original Method ----------
        //mTag = tag;
        //mCompTlvs = ctlvs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.682 -0400", hash_original_method = "4DB54AB9F503DA894E5725BF1F0BC01C", hash_generated_method = "3BC88D542242D2BE8714F52886B4ED00")
    public List<ComprehensionTlv> getComprehensionTlvs() {
List<ComprehensionTlv> varEED3324DF316BCB609D1536A9D775114_429141878 =         mCompTlvs;
        varEED3324DF316BCB609D1536A9D775114_429141878.addTaint(taint);
        return varEED3324DF316BCB609D1536A9D775114_429141878;
        // ---------- Original Method ----------
        //return mCompTlvs;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.683 -0400", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "C949633633E8504B81F7E86821BB39FC")
    public int getTag() {
        int var07496860B5C53FDD66588727158D5F73_1727397498 = (mTag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437290665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437290665;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.683 -0400", hash_original_field = "B0EB1CD9955738163D0392247E75DD4F", hash_generated_field = "51019AD6C5CC55D9C6AF4E6FA65C2CFC")

    public static final int BER_UNKNOWN_TAG             = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.683 -0400", hash_original_field = "5BD88AF5C61996DC0ED969D9203DF556", hash_generated_field = "849EF9FE5E783A4D18EB93EBEF07AF92")

    public static final int BER_PROACTIVE_COMMAND_TAG   = 0xd0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.683 -0400", hash_original_field = "3A9A690DC355DD28E8580E7CEE146F3E", hash_generated_field = "FD25A090599EDE67E1DA85645D40DBBC")

    public static final int BER_MENU_SELECTION_TAG      = 0xd3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.683 -0400", hash_original_field = "6F7C1AF9FBC46A0A3EA3348D9E5B33BA", hash_generated_field = "037978F26D244A2F18B40FEF8C880C0F")

    public static final int BER_EVENT_DOWNLOAD_TAG      = 0xd6;
}

