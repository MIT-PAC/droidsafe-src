package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;

class ComprehensionTlv {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.134 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "BFBA40DE531B5000F1981B7BBF1ED026")

    private int mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.134 -0400", hash_original_field = "0F17E746BE153E70A72E97F8AE4B0967", hash_generated_field = "615830BA9729410C3098ECFE977B653E")

    private boolean mCr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.134 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.134 -0400", hash_original_field = "23B7A8A7152E7007B08DAF983B584CA9", hash_generated_field = "8FECB3720B086D527CFAD02FEE0B0CCC")

    private int mValueIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.134 -0400", hash_original_field = "68EFE75FA9F684BF74FD95FB591C4772", hash_generated_field = "5744D2EFAB71BD258B36C43D2ECBE57E")

    private byte[] mRawValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.135 -0400", hash_original_method = "F083BF2976A39A70E87A329F21B5205D", hash_generated_method = "020782AEA4213AFDFBB86D391AADBE72")
    protected  ComprehensionTlv(int tag, boolean cr, int length, byte[] data,
            int valueIndex) {
        mTag = tag;
        mCr = cr;
        mLength = length;
        mValueIndex = valueIndex;
        mRawValue = data;
        // ---------- Original Method ----------
        //mTag = tag;
        //mCr = cr;
        //mLength = length;
        //mValueIndex = valueIndex;
        //mRawValue = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.135 -0400", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "2AE000A5DF4ED958074908FF622EA6CE")
    public int getTag() {
        int var07496860B5C53FDD66588727158D5F73_515258997 = (mTag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357290975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357290975;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.135 -0400", hash_original_method = "BBBB347994ECBB1AA0023AC2A90F5AE7", hash_generated_method = "73F8ABEA9AEE8DA2E374CC1C40CC3A85")
    public boolean isComprehensionRequired() {
        boolean var0F17E746BE153E70A72E97F8AE4B0967_1348843952 = (mCr);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225627125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225627125;
        // ---------- Original Method ----------
        //return mCr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.135 -0400", hash_original_method = "6E6502D65176BC2328E9B790ED2B205C", hash_generated_method = "D06B24289DEDA53864BE899E01E1D479")
    public int getLength() {
        int var429F431E8CD8AC287AA27460675EAEFE_2107959859 = (mLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067414913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067414913;
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.135 -0400", hash_original_method = "6B24631B893BC9498B1E30027D9EDCB1", hash_generated_method = "B54F8DE7C7C684B0448C7C961D3CFCCF")
    public int getValueIndex() {
        int var23B7A8A7152E7007B08DAF983B584CA9_1290884707 = (mValueIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857442144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857442144;
        // ---------- Original Method ----------
        //return mValueIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.136 -0400", hash_original_method = "2E1D90837620CE8C27D1ADC653AC7836", hash_generated_method = "F3840B454BCC88C4D82CF4E42DE80A24")
    public byte[] getRawValue() {
        byte[] var68EFE75FA9F684BF74FD95FB591C4772_56666222 = (mRawValue);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1019930081 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1019930081;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.137 -0400", hash_original_field = "528B030C1EBA87EE28DC417B1C2A985B", hash_generated_field = "0B14812E52CC10D1258CE11D062EA057")

    private static final String LOG_TAG = "ComprehensionTlv";
}

