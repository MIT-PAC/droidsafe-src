package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class GpsSatellite {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.247 -0400", hash_original_field = "AB06C0B5FE02AF09E4F911D76AAEE4B2", hash_generated_field = "ED254D523CA59D4B79795578544CDA27")

    boolean mValid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.247 -0400", hash_original_field = "1BB4442A7B56CDDEE767ED05D3590BD6", hash_generated_field = "1F3B5AD166020F5DF09464A3271AAA66")

    boolean mHasEphemeris;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.247 -0400", hash_original_field = "E68B23DC59703B040C712D12BBDF6819", hash_generated_field = "C3FF9F0F1710360264B3429C92C2C819")

    boolean mHasAlmanac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.247 -0400", hash_original_field = "58B7DD923591F4D9C406BAB76F587492", hash_generated_field = "63D621938B69E0E166A0ECC00B52A7F3")

    boolean mUsedInFix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.253 -0400", hash_original_field = "39B6494BF22923FA615DB7A950E4B17F", hash_generated_field = "1CDF0C01817EB541ECDA40BE76A880FD")

    int mPrn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.253 -0400", hash_original_field = "AD69F0075A5F4B9FBEDF266D65B8DE6C", hash_generated_field = "C91061B0C817384B77DAE63F2FE6ECD1")

    float mSnr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.253 -0400", hash_original_field = "73EF287C5421704A6E0C080AC7468F1F", hash_generated_field = "3AD7268F8E4AA2FD03CE7A30AF454A89")

    float mElevation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.254 -0400", hash_original_field = "C420BB9211C88FD36C417728E5662AB8", hash_generated_field = "77AAD50693AA57F0F2E57E4972ADD329")

    float mAzimuth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.254 -0400", hash_original_method = "8573EDE4D6155BE2F87E9990A729AEDD", hash_generated_method = "26007B6C3D73BE506F995952BD6015AF")
      GpsSatellite(int prn) {
        mPrn = prn;
        // ---------- Original Method ----------
        //mPrn = prn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.259 -0400", hash_original_method = "6104464C0A9B407CFF88F943228D0F31", hash_generated_method = "2E85106BF30CF89569D5A3C5F4EF082E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.260 -0400", hash_original_method = "1CFB1A0ACEFDBC53538E3DE39E0274F8", hash_generated_method = "BA01C7580A7B97E6BBBC883DBE1F9AF7")
    public int getPrn() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733148526 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733148526;
        // ---------- Original Method ----------
        //return mPrn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.275 -0400", hash_original_method = "86375E5795460EBC5BAEFE7343FFC8C2", hash_generated_method = "211CA0ACB86C8910185B34AF4F63C9A8")
    public float getSnr() {
        float var546ADE640B6EDFBC8A086EF31347E768_1131700470 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1131700470;
        // ---------- Original Method ----------
        //return mSnr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.289 -0400", hash_original_method = "45660D841120F9B89BAE31417734A703", hash_generated_method = "7CCE82A510366F01EA70BE5D606CFD9F")
    public float getElevation() {
        float var546ADE640B6EDFBC8A086EF31347E768_623995906 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_623995906;
        // ---------- Original Method ----------
        //return mElevation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.290 -0400", hash_original_method = "F306C300B6B496BB95E6F8AB34665AA0", hash_generated_method = "C226EEE0673FAD8977E3F86E94BD41C1")
    public float getAzimuth() {
        float var546ADE640B6EDFBC8A086EF31347E768_2105457718 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2105457718;
        // ---------- Original Method ----------
        //return mAzimuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.292 -0400", hash_original_method = "A2DF67CCEC020DAA7F7D1228AFE48AE4", hash_generated_method = "B9F0781CA7270F3535982B2E529F02A2")
    public boolean hasEphemeris() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16826088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16826088;
        // ---------- Original Method ----------
        //return mHasEphemeris;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.292 -0400", hash_original_method = "6F26EA9283182B6EDEDBB0B351568D69", hash_generated_method = "C919B4B27F6FD727A17FC3869D421EEB")
    public boolean hasAlmanac() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1722463866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1722463866;
        // ---------- Original Method ----------
        //return mHasAlmanac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.293 -0400", hash_original_method = "D2570999F2D51C5CE871F64BF39BACFE", hash_generated_method = "3048276AAE9379DF575811BE25785E46")
    public boolean usedInFix() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28570784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_28570784;
        // ---------- Original Method ----------
        //return mUsedInFix;
    }

    
}

