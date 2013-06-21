package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class Criteria implements Parcelable {
    private int mHorizontalAccuracy    = NO_REQUIREMENT;
    private int mVerticalAccuracy      = NO_REQUIREMENT;
    private int mSpeedAccuracy         = NO_REQUIREMENT;
    private int mBearingAccuracy       = NO_REQUIREMENT;
    private int mPowerRequirement      = NO_REQUIREMENT;
    private boolean mAltitudeRequired  = false;
    private boolean mBearingRequired   = false;
    private boolean mSpeedRequired     = false;
    private boolean mCostAllowed       = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.558 -0400", hash_original_method = "56D25A23ADD1F3C93CB7F827DA5DFB02", hash_generated_method = "3EFEE149D939DD3A0C00E9F5B56EE461")
    @DSModeled(DSC.SAFE)
    public Criteria() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.558 -0400", hash_original_method = "4027197A668FB712D0A5A09027B96247", hash_generated_method = "8DBAAD40BEC05A6970917F37A9057F86")
    @DSModeled(DSC.SAFE)
    public Criteria(Criteria criteria) {
        dsTaint.addTaint(criteria.dsTaint);
        mHorizontalAccuracy = criteria.mHorizontalAccuracy;
        mVerticalAccuracy = criteria.mVerticalAccuracy;
        mSpeedAccuracy = criteria.mSpeedAccuracy;
        mBearingAccuracy = criteria.mBearingAccuracy;
        mPowerRequirement = criteria.mPowerRequirement;
        mAltitudeRequired = criteria.mAltitudeRequired;
        mBearingRequired = criteria.mBearingRequired;
        mSpeedRequired = criteria.mSpeedRequired;
        mCostAllowed = criteria.mCostAllowed;
        // ---------- Original Method ----------
        //mHorizontalAccuracy = criteria.mHorizontalAccuracy;
        //mVerticalAccuracy = criteria.mVerticalAccuracy;
        //mSpeedAccuracy = criteria.mSpeedAccuracy;
        //mBearingAccuracy = criteria.mBearingAccuracy;
        //mPowerRequirement = criteria.mPowerRequirement;
        //mAltitudeRequired = criteria.mAltitudeRequired;
        //mBearingRequired = criteria.mBearingRequired;
        //mSpeedRequired = criteria.mSpeedRequired;
        //mCostAllowed = criteria.mCostAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.559 -0400", hash_original_method = "F7CDA1AEB030C3E960B93BFBD444E4B1", hash_generated_method = "0B044D2E8A6E18E233D48349F03847CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHorizontalAccuracy(int accuracy) {
        dsTaint.addTaint(accuracy);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mHorizontalAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.559 -0400", hash_original_method = "2F566A20A5A9A3E4947DCE83AA9DF67E", hash_generated_method = "70290A21F7990A790156386B25DCD7DA")
    @DSModeled(DSC.SAFE)
    public int getHorizontalAccuracy() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHorizontalAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.560 -0400", hash_original_method = "A234CD6EE2124B9B176BE728225522DE", hash_generated_method = "45A50621B4F77C42EE8C6BFD0131EF4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVerticalAccuracy(int accuracy) {
        dsTaint.addTaint(accuracy);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mVerticalAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.560 -0400", hash_original_method = "E46E133CF34270F0210C8D2BD309B3F5", hash_generated_method = "EA61D5DA9FE83E43AB9710731EF59D30")
    @DSModeled(DSC.SAFE)
    public int getVerticalAccuracy() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVerticalAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.561 -0400", hash_original_method = "7DA41913012CB9940E77425DCF2D2731", hash_generated_method = "A049C5C25F2CDB4440E8C8E1C346A744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSpeedAccuracy(int accuracy) {
        dsTaint.addTaint(accuracy);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mSpeedAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.562 -0400", hash_original_method = "87339E07174611DFFFF3AC3EA0F5BF3F", hash_generated_method = "879BCD13C1F9F069BB98232E90D6FEB3")
    @DSModeled(DSC.SAFE)
    public int getSpeedAccuracy() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSpeedAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.563 -0400", hash_original_method = "7D38552738106C949C369F73EBC07BAD", hash_generated_method = "37D10B511CC0355A7DADD2FC038F9502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBearingAccuracy(int accuracy) {
        dsTaint.addTaint(accuracy);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mBearingAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.563 -0400", hash_original_method = "0A4814C8F779184929A4F3680AE62C8F", hash_generated_method = "9AE2D68F26BE0EBC44CFF02777133C63")
    @DSModeled(DSC.SAFE)
    public int getBearingAccuracy() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBearingAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.563 -0400", hash_original_method = "F2B3644622DFC41E9C3EF3B6293185D6", hash_generated_method = "A251D41762144D2ABF47851651322012")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAccuracy(int accuracy) {
        dsTaint.addTaint(accuracy);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        {
            mHorizontalAccuracy = ACCURACY_HIGH;
        } //End block
        {
            mHorizontalAccuracy = ACCURACY_LOW;
        } //End block
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_COARSE) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //if (accuracy == ACCURACY_FINE) {
            //mHorizontalAccuracy = ACCURACY_HIGH;
        //} else {
            //mHorizontalAccuracy = ACCURACY_LOW;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.564 -0400", hash_original_method = "738CC4C555122D617CAE26F950A7954B", hash_generated_method = "AF657FCF8CBBD294D7CD7261A2CE5C67")
    @DSModeled(DSC.SAFE)
    public int getAccuracy() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mHorizontalAccuracy >= ACCURACY_HIGH) {
            //return ACCURACY_FINE;
        //} else {
            //return ACCURACY_COARSE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.564 -0400", hash_original_method = "91C2D38607A4F9F70C65E1811565AAD2", hash_generated_method = "BC7A9FAA641CB7CAF334B782FA7F503F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPowerRequirement(int level) {
        dsTaint.addTaint(level);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("level=" + level);
        } //End block
        // ---------- Original Method ----------
        //if (level < NO_REQUIREMENT || level > POWER_HIGH) {
            //throw new IllegalArgumentException("level=" + level);
        //}
        //mPowerRequirement = level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.564 -0400", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "EB9B54582F63466D038DF03D194EED66")
    @DSModeled(DSC.SAFE)
    public int getPowerRequirement() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPowerRequirement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.564 -0400", hash_original_method = "F89CAE570739AB3028DA707B2893B5C5", hash_generated_method = "1310B919F21F7AA970D2B4E8EF53A71F")
    @DSModeled(DSC.SAFE)
    public void setCostAllowed(boolean costAllowed) {
        dsTaint.addTaint(costAllowed);
        // ---------- Original Method ----------
        //mCostAllowed = costAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.565 -0400", hash_original_method = "A41D9C3F2D62A3EB42A9C94631C7A3C6", hash_generated_method = "CE395122D963CCD5A3186ECA589026D7")
    @DSModeled(DSC.SAFE)
    public boolean isCostAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCostAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.565 -0400", hash_original_method = "22D4EC779FEBEFBD7A04B35673FD6242", hash_generated_method = "CD4FBFB0303146B9D3F16856EF1F01DE")
    @DSModeled(DSC.SAFE)
    public void setAltitudeRequired(boolean altitudeRequired) {
        dsTaint.addTaint(altitudeRequired);
        // ---------- Original Method ----------
        //mAltitudeRequired = altitudeRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.565 -0400", hash_original_method = "B960582E2C1A3651AC20223DA8436091", hash_generated_method = "3EC745736E806B7410F08CD6CC346F83")
    @DSModeled(DSC.SAFE)
    public boolean isAltitudeRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAltitudeRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.565 -0400", hash_original_method = "6A27513D0E2583F73F00042D0FDBD9E3", hash_generated_method = "ABB26717E0A83CBCCEC7A2C43427A463")
    @DSModeled(DSC.SAFE)
    public void setSpeedRequired(boolean speedRequired) {
        dsTaint.addTaint(speedRequired);
        // ---------- Original Method ----------
        //mSpeedRequired = speedRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.566 -0400", hash_original_method = "F6BA7163C74D6BF39003C6333C2CFD6D", hash_generated_method = "F0D5B8527C46647B1FBE54216EEF91C2")
    @DSModeled(DSC.SAFE)
    public boolean isSpeedRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSpeedRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.566 -0400", hash_original_method = "B68158C6EC7F405A349EABCD21ABA300", hash_generated_method = "F7AE942E8C79294A7F7EE731DEF73CE4")
    @DSModeled(DSC.SAFE)
    public void setBearingRequired(boolean bearingRequired) {
        dsTaint.addTaint(bearingRequired);
        // ---------- Original Method ----------
        //mBearingRequired = bearingRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.566 -0400", hash_original_method = "17013BC273E96D7EA584C9522A6EEB48", hash_generated_method = "8849DBCDC69572E332E12E6884CB0476")
    @DSModeled(DSC.SAFE)
    public boolean isBearingRequired() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBearingRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.566 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.567 -0400", hash_original_method = "F656AD17D4B37BFDE841686B6FE00CD9", hash_generated_method = "DF512271A85B1FF65B41CC0B61BB590A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(mHorizontalAccuracy);
        parcel.writeInt(mVerticalAccuracy);
        parcel.writeInt(mSpeedAccuracy);
        parcel.writeInt(mBearingAccuracy);
        parcel.writeInt(mPowerRequirement);
        parcel.writeInt(mAltitudeRequired ? 1 : 0);
        parcel.writeInt(mBearingRequired ? 1 : 0);
        parcel.writeInt(mSpeedRequired ? 1 : 0);
        parcel.writeInt(mCostAllowed ? 1 : 0);
        // ---------- Original Method ----------
        //parcel.writeInt(mHorizontalAccuracy);
        //parcel.writeInt(mVerticalAccuracy);
        //parcel.writeInt(mSpeedAccuracy);
        //parcel.writeInt(mBearingAccuracy);
        //parcel.writeInt(mPowerRequirement);
        //parcel.writeInt(mAltitudeRequired ? 1 : 0);
        //parcel.writeInt(mBearingRequired ? 1 : 0);
        //parcel.writeInt(mSpeedRequired ? 1 : 0);
        //parcel.writeInt(mCostAllowed ? 1 : 0);
    }

    
    public static final int NO_REQUIREMENT = 0;
    public static final int POWER_LOW = 1;
    public static final int POWER_MEDIUM = 2;
    public static final int POWER_HIGH = 3;
    public static final int ACCURACY_FINE = 1;
    public static final int ACCURACY_COARSE = 2;
    public static final int ACCURACY_LOW = 1;
    public static final int ACCURACY_MEDIUM = 2;
    public static final int ACCURACY_HIGH = 3;
    public static final Parcelable.Creator<Criteria> CREATOR = new Parcelable.Creator<Criteria>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.567 -0400", hash_original_method = "30491C0C577618E547D91203358C6C24", hash_generated_method = "6FC5C5F98076514BE51C78084529EE3E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Criteria createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Criteria c;
            c = new Criteria();
            c.mHorizontalAccuracy = in.readInt();
            c.mVerticalAccuracy = in.readInt();
            c.mSpeedAccuracy = in.readInt();
            c.mBearingAccuracy = in.readInt();
            c.mPowerRequirement = in.readInt();
            c.mAltitudeRequired = in.readInt() != 0;
            c.mBearingRequired = in.readInt() != 0;
            c.mSpeedRequired = in.readInt() != 0;
            c.mCostAllowed = in.readInt() != 0;
            return (Criteria)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Criteria c = new Criteria();
            //c.mHorizontalAccuracy = in.readInt();
            //c.mVerticalAccuracy = in.readInt();
            //c.mSpeedAccuracy = in.readInt();
            //c.mBearingAccuracy = in.readInt();
            //c.mPowerRequirement = in.readInt();
            //c.mAltitudeRequired = in.readInt() != 0;
            //c.mBearingRequired = in.readInt() != 0;
            //c.mSpeedRequired = in.readInt() != 0;
            //c.mCostAllowed = in.readInt() != 0;
            //return c;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.568 -0400", hash_original_method = "C6BB0D5E0D629C065866F485B5D61E63", hash_generated_method = "93A996733A2EF4FF030E53674A690EFA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Criteria[] newArray(int size) {
            dsTaint.addTaint(size);
            Criteria[] varA4904759761C80207CA8DCA7EB70728F_1418446497 = (new Criteria[size]);
            return (Criteria[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Criteria[size];
        }

        
}; //Transformed anonymous class
}

