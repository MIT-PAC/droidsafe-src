package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;






class ComprehensionTlv {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.225 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "BFBA40DE531B5000F1981B7BBF1ED026")

    private int mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.225 -0400", hash_original_field = "0F17E746BE153E70A72E97F8AE4B0967", hash_generated_field = "615830BA9729410C3098ECFE977B653E")

    private boolean mCr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.225 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.225 -0400", hash_original_field = "23B7A8A7152E7007B08DAF983B584CA9", hash_generated_field = "8FECB3720B086D527CFAD02FEE0B0CCC")

    private int mValueIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.225 -0400", hash_original_field = "68EFE75FA9F684BF74FD95FB591C4772", hash_generated_field = "5744D2EFAB71BD258B36C43D2ECBE57E")

    private byte[] mRawValue;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.225 -0400", hash_original_method = "F083BF2976A39A70E87A329F21B5205D", hash_generated_method = "020782AEA4213AFDFBB86D391AADBE72")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.225 -0400", hash_original_method = "F4331D0775C023B121D08D63B25AAACE", hash_generated_method = "4206AB0B45A7D08A5FE33A89D2DEF033")
    public int getTag() {
        int var07496860B5C53FDD66588727158D5F73_1029471151 = (mTag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797630369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797630369;
        // ---------- Original Method ----------
        //return mTag;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.226 -0400", hash_original_method = "BBBB347994ECBB1AA0023AC2A90F5AE7", hash_generated_method = "5737F8DFF9BA7823422C6720BE9CBD6D")
    public boolean isComprehensionRequired() {
        boolean var0F17E746BE153E70A72E97F8AE4B0967_819088903 = (mCr);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2230433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2230433;
        // ---------- Original Method ----------
        //return mCr;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.226 -0400", hash_original_method = "6E6502D65176BC2328E9B790ED2B205C", hash_generated_method = "51B627784D1264335A46790F0F30066D")
    public int getLength() {
        int var429F431E8CD8AC287AA27460675EAEFE_1558811804 = (mLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407125858 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407125858;
        // ---------- Original Method ----------
        //return mLength;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.226 -0400", hash_original_method = "6B24631B893BC9498B1E30027D9EDCB1", hash_generated_method = "85E17D2048BD263B640FCD6EB6A8C20B")
    public int getValueIndex() {
        int var23B7A8A7152E7007B08DAF983B584CA9_675960075 = (mValueIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932496037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932496037;
        // ---------- Original Method ----------
        //return mValueIndex;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.226 -0400", hash_original_method = "2E1D90837620CE8C27D1ADC653AC7836", hash_generated_method = "824240204B08DF9CE88FE6F5BCEB6B6D")
    public byte[] getRawValue() {
        byte[] var68EFE75FA9F684BF74FD95FB591C4772_313875150 = (mRawValue);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1131274995 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1131274995;
        // ---------- Original Method ----------
        //return mRawValue;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.227 -0400", hash_original_field = "528B030C1EBA87EE28DC417B1C2A985B", hash_generated_field = "0B14812E52CC10D1258CE11D062EA057")

    private static final String LOG_TAG = "ComprehensionTlv";
}

