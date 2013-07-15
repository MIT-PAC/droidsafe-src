package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class GpsSatellite {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.779 -0400", hash_original_field = "AB06C0B5FE02AF09E4F911D76AAEE4B2", hash_generated_field = "ED254D523CA59D4B79795578544CDA27")

    boolean mValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.779 -0400", hash_original_field = "1BB4442A7B56CDDEE767ED05D3590BD6", hash_generated_field = "1F3B5AD166020F5DF09464A3271AAA66")

    boolean mHasEphemeris;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.779 -0400", hash_original_field = "E68B23DC59703B040C712D12BBDF6819", hash_generated_field = "C3FF9F0F1710360264B3429C92C2C819")

    boolean mHasAlmanac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.780 -0400", hash_original_field = "58B7DD923591F4D9C406BAB76F587492", hash_generated_field = "63D621938B69E0E166A0ECC00B52A7F3")

    boolean mUsedInFix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.780 -0400", hash_original_field = "39B6494BF22923FA615DB7A950E4B17F", hash_generated_field = "1CDF0C01817EB541ECDA40BE76A880FD")

    int mPrn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.780 -0400", hash_original_field = "AD69F0075A5F4B9FBEDF266D65B8DE6C", hash_generated_field = "C91061B0C817384B77DAE63F2FE6ECD1")

    float mSnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.780 -0400", hash_original_field = "73EF287C5421704A6E0C080AC7468F1F", hash_generated_field = "3AD7268F8E4AA2FD03CE7A30AF454A89")

    float mElevation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.780 -0400", hash_original_field = "C420BB9211C88FD36C417728E5662AB8", hash_generated_field = "77AAD50693AA57F0F2E57E4972ADD329")

    float mAzimuth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.781 -0400", hash_original_method = "8573EDE4D6155BE2F87E9990A729AEDD", hash_generated_method = "26007B6C3D73BE506F995952BD6015AF")
      GpsSatellite(int prn) {
        mPrn = prn;
        // ---------- Original Method ----------
        //mPrn = prn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.782 -0400", hash_original_method = "6104464C0A9B407CFF88F943228D0F31", hash_generated_method = "2E85106BF30CF89569D5A3C5F4EF082E")
     void setStatus(GpsSatellite satellite) {
        mValid = satellite.mValid;
        mHasEphemeris = satellite.mHasEphemeris;
        mHasAlmanac = satellite.mHasAlmanac;
        mUsedInFix = satellite.mUsedInFix;
        mSnr = satellite.mSnr;
        mElevation = satellite.mElevation;
        mAzimuth = satellite.mAzimuth;
        // ---------- Original Method ----------
        //mValid = satellite.mValid;
        //mHasEphemeris = satellite.mHasEphemeris;
        //mHasAlmanac = satellite.mHasAlmanac;
        //mUsedInFix = satellite.mUsedInFix;
        //mSnr = satellite.mSnr;
        //mElevation = satellite.mElevation;
        //mAzimuth = satellite.mAzimuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.782 -0400", hash_original_method = "1CFB1A0ACEFDBC53538E3DE39E0274F8", hash_generated_method = "86714093C9950BC61E29A42B45DAED37")
    public int getPrn() {
        int var39B6494BF22923FA615DB7A950E4B17F_1921513678 = (mPrn);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171312476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171312476;
        // ---------- Original Method ----------
        //return mPrn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.782 -0400", hash_original_method = "86375E5795460EBC5BAEFE7343FFC8C2", hash_generated_method = "15E7FB4C030262786C4E5DA0CC043CB8")
    public float getSnr() {
        float varAD69F0075A5F4B9FBEDF266D65B8DE6C_373379227 = (mSnr);
                float var546ADE640B6EDFBC8A086EF31347E768_1824676973 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1824676973;
        // ---------- Original Method ----------
        //return mSnr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.783 -0400", hash_original_method = "45660D841120F9B89BAE31417734A703", hash_generated_method = "35F2E69792825C03E61F4BA550D80BF4")
    public float getElevation() {
        float var73EF287C5421704A6E0C080AC7468F1F_712972785 = (mElevation);
                float var546ADE640B6EDFBC8A086EF31347E768_750530891 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_750530891;
        // ---------- Original Method ----------
        //return mElevation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.783 -0400", hash_original_method = "F306C300B6B496BB95E6F8AB34665AA0", hash_generated_method = "F9636104EFC9EB99814595FACF8EFCEB")
    public float getAzimuth() {
        float varC420BB9211C88FD36C417728E5662AB8_787103171 = (mAzimuth);
                float var546ADE640B6EDFBC8A086EF31347E768_758925923 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_758925923;
        // ---------- Original Method ----------
        //return mAzimuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.783 -0400", hash_original_method = "A2DF67CCEC020DAA7F7D1228AFE48AE4", hash_generated_method = "1448904401EFEB260C6A1C4363652417")
    public boolean hasEphemeris() {
        boolean var1BB4442A7B56CDDEE767ED05D3590BD6_1078958167 = (mHasEphemeris);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1343766932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1343766932;
        // ---------- Original Method ----------
        //return mHasEphemeris;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.783 -0400", hash_original_method = "6F26EA9283182B6EDEDBB0B351568D69", hash_generated_method = "43FF2C2CC7E2563512D90A62A4D22DCC")
    public boolean hasAlmanac() {
        boolean varE68B23DC59703B040C712D12BBDF6819_252862259 = (mHasAlmanac);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560288215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560288215;
        // ---------- Original Method ----------
        //return mHasAlmanac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.784 -0400", hash_original_method = "D2570999F2D51C5CE871F64BF39BACFE", hash_generated_method = "A90D5ECDE56BF40A69FFEF7CEA80B206")
    public boolean usedInFix() {
        boolean var58B7DD923591F4D9C406BAB76F587492_130173389 = (mUsedInFix);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414065674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414065674;
        // ---------- Original Method ----------
        //return mUsedInFix;
    }

    
}

