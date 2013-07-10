package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.List;

class BerTlv {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.137 -0400", hash_original_field = "585F79BD9B4089B48441D6A5455747E1", hash_generated_field = "39FE9CD97B9AFEAEBF1F07C1BE8432FF")

    private int mTag = BER_UNKNOWN_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.137 -0400", hash_original_field = "3FF1C48858768C6F47B2C17D93779E9A", hash_generated_field = "D44204BE63F06CA8F47FCF402390D741")

    private List<ComprehensionTlv> mCompTlvs = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.137 -0400", hash_original_method = "5C874FE61091A7FA99CA633BD5413E3E", hash_generated_method = "07694EC6CD4A63F924055EE17B7B86F1")
    private  BerTlv(int tag, List<ComprehensionTlv> ctlvs) {
        mTag = tag;
        mCompTlvs = ctlvs;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.138 -0400", hash_original_method = "4DB54AB9F503DA894E5725BF1F0BC01C", hash_generated_method = "8CA3AAD47FB1C671B56B4D8BAA069B68")
    public List<ComprehensionTlv> getComprehensionTlvs() {
        List<ComprehensionTlv> varB4EAC82CA7396A68D541C85D26508E83_399602149 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_399602149 = mCompTlvs;
        varB4EAC82CA7396A68D541C85D26508E83_399602149.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_399602149;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.138 -0400", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "8E581A1687D99A048424981FC1F748E6")
    public int getTag() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674238906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674238906;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.138 -0400", hash_original_field = "B0EB1CD9955738163D0392247E75DD4F", hash_generated_field = "51019AD6C5CC55D9C6AF4E6FA65C2CFC")

    public static final int BER_UNKNOWN_TAG             = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.138 -0400", hash_original_field = "5BD88AF5C61996DC0ED969D9203DF556", hash_generated_field = "849EF9FE5E783A4D18EB93EBEF07AF92")

    public static final int BER_PROACTIVE_COMMAND_TAG   = 0xd0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.138 -0400", hash_original_field = "3A9A690DC355DD28E8580E7CEE146F3E", hash_generated_field = "FD25A090599EDE67E1DA85645D40DBBC")

    public static final int BER_MENU_SELECTION_TAG      = 0xd3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.138 -0400", hash_original_field = "6F7C1AF9FBC46A0A3EA3348D9E5B33BA", hash_generated_field = "037978F26D244A2F18B40FEF8C880C0F")

    public static final int BER_EVENT_DOWNLOAD_TAG      = 0xd6;
}

