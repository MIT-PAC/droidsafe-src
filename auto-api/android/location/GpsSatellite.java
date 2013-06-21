package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class GpsSatellite {
    boolean mValid;
    boolean mHasEphemeris;
    boolean mHasAlmanac;
    boolean mUsedInFix;
    int mPrn;
    float mSnr;
    float mElevation;
    float mAzimuth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.579 -0400", hash_original_method = "8573EDE4D6155BE2F87E9990A729AEDD", hash_generated_method = "4CEB28A6C794E286C1D49873471269D8")
    @DSModeled(DSC.SAFE)
     GpsSatellite(int prn) {
        dsTaint.addTaint(prn);
        // ---------- Original Method ----------
        //mPrn = prn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.580 -0400", hash_original_method = "6104464C0A9B407CFF88F943228D0F31", hash_generated_method = "40EB644E68689E6F01EEA49F35275D55")
    @DSModeled(DSC.SAFE)
     void setStatus(GpsSatellite satellite) {
        dsTaint.addTaint(satellite.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.580 -0400", hash_original_method = "1CFB1A0ACEFDBC53538E3DE39E0274F8", hash_generated_method = "07DE2C8B56E68833FBD8B4368E148366")
    @DSModeled(DSC.SAFE)
    public int getPrn() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPrn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.580 -0400", hash_original_method = "86375E5795460EBC5BAEFE7343FFC8C2", hash_generated_method = "AE4F3440D617E36243090EB76C281AC8")
    @DSModeled(DSC.SAFE)
    public float getSnr() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mSnr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.581 -0400", hash_original_method = "45660D841120F9B89BAE31417734A703", hash_generated_method = "9F5AD263145310708E3B34D428291A19")
    @DSModeled(DSC.SAFE)
    public float getElevation() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mElevation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.581 -0400", hash_original_method = "F306C300B6B496BB95E6F8AB34665AA0", hash_generated_method = "001707D275D8DB31C4DA677322FA21F9")
    @DSModeled(DSC.SAFE)
    public float getAzimuth() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mAzimuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.581 -0400", hash_original_method = "A2DF67CCEC020DAA7F7D1228AFE48AE4", hash_generated_method = "119D73954CD150440343C92DC70AFCBC")
    @DSModeled(DSC.SAFE)
    public boolean hasEphemeris() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasEphemeris;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.581 -0400", hash_original_method = "6F26EA9283182B6EDEDBB0B351568D69", hash_generated_method = "CC7EE09737537D80C89ACA9DE17BE5DA")
    @DSModeled(DSC.SAFE)
    public boolean hasAlmanac() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasAlmanac;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.582 -0400", hash_original_method = "D2570999F2D51C5CE871F64BF39BACFE", hash_generated_method = "F9D76C7108AB46F76EBEB2A62F476726")
    @DSModeled(DSC.SAFE)
    public boolean usedInFix() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUsedInFix;
    }

    
}

