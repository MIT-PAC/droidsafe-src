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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "13196B050486260F665DAFD2DCB1423F", hash_generated_field = "1A506D6FCBAE89E5ED8986984C204EDF")

    private int mHorizontalAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "0E3223CDB10E8518132E5C3C8949A857", hash_generated_field = "9C948891D51E1ECED7D5B42EA88A1980")

    private int mVerticalAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "13BEB683610F4CA34C01AD5B72FB840D", hash_generated_field = "4206F17114FC87E89D5E2D934FD265D1")

    private int mSpeedAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "C8601B5B1BC4F79D3CFF6EFC67E5AFBF", hash_generated_field = "AFE00C78DEAD58C36FFBF596A3087BA3")

    private int mBearingAccuracy = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "02F1E7376BDB45AD1CE174FBAE2021E0", hash_generated_field = "F89FA2DF8DA48BD5497DB50DA1CA47F5")

    private int mPowerRequirement = NO_REQUIREMENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "575F35BF19BB272643940F388D2E2DB4", hash_generated_field = "1ABEB241EAFF3EEBFF568528AFCBA219")

    private boolean mAltitudeRequired = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "9A6402C26B24D09EFCAC163486A70A18", hash_generated_field = "0299E987BE1DC1D0B0A7571822B9D8AA")

    private boolean mBearingRequired = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "11B7FA9A4B9DEE5D16188AFC702520C8", hash_generated_field = "9B3C565095BC4FCEC789B430DD2467DF")

    private boolean mSpeedRequired = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_field = "767BA11EBC9E4746FB44A19596372104", hash_generated_field = "4FF764166F8A934C7C88D2C8472DFB24")

    private boolean mCostAllowed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.198 -0400", hash_original_method = "56D25A23ADD1F3C93CB7F827DA5DFB02", hash_generated_method = "3EFEE149D939DD3A0C00E9F5B56EE461")
    public  Criteria() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.199 -0400", hash_original_method = "4027197A668FB712D0A5A09027B96247", hash_generated_method = "AF9F22AB717402C29CAE5B27F1850449")
    public  Criteria(Criteria criteria) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.199 -0400", hash_original_method = "F7CDA1AEB030C3E960B93BFBD444E4B1", hash_generated_method = "E8749775A6252B6CEA2B3082A99CCBF8")
    public void setHorizontalAccuracy(int accuracy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        mHorizontalAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mHorizontalAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.199 -0400", hash_original_method = "2F566A20A5A9A3E4947DCE83AA9DF67E", hash_generated_method = "87D315583638E675C7D50D38F354F121")
    public int getHorizontalAccuracy() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298580329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298580329;
        // ---------- Original Method ----------
        //return mHorizontalAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.199 -0400", hash_original_method = "A234CD6EE2124B9B176BE728225522DE", hash_generated_method = "168D8439CFFEE937D49C7BF7E30F44B4")
    public void setVerticalAccuracy(int accuracy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        mVerticalAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mVerticalAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.200 -0400", hash_original_method = "E46E133CF34270F0210C8D2BD309B3F5", hash_generated_method = "1811B02F0D21293C8B6F30EEA37C134C")
    public int getVerticalAccuracy() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474651999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_474651999;
        // ---------- Original Method ----------
        //return mVerticalAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.200 -0400", hash_original_method = "7DA41913012CB9940E77425DCF2D2731", hash_generated_method = "CB9C9C478342B4624B1115D0372BCDEE")
    public void setSpeedAccuracy(int accuracy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        mSpeedAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mSpeedAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.200 -0400", hash_original_method = "87339E07174611DFFFF3AC3EA0F5BF3F", hash_generated_method = "648F8BB5E03BEE103F52F8EF160F78E7")
    public int getSpeedAccuracy() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716302242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716302242;
        // ---------- Original Method ----------
        //return mSpeedAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.201 -0400", hash_original_method = "7D38552738106C949C369F73EBC07BAD", hash_generated_method = "416287711FC5E0955426ED7533EDC32B")
    public void setBearingAccuracy(int accuracy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        mBearingAccuracy = accuracy;
        // ---------- Original Method ----------
        //if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            //throw new IllegalArgumentException("accuracy=" + accuracy);
        //}
        //mBearingAccuracy = accuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.202 -0400", hash_original_method = "0A4814C8F779184929A4F3680AE62C8F", hash_generated_method = "B63D379458CE3B3EA4500AB43E64A301")
    public int getBearingAccuracy() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927686867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927686867;
        // ---------- Original Method ----------
        //return mBearingAccuracy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.202 -0400", hash_original_method = "F2B3644622DFC41E9C3EF3B6293185D6", hash_generated_method = "1032FF480DDEF47453FA060D6D10F4C2")
    public void setAccuracy(int accuracy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("accuracy=" + accuracy);
        } //End block
        {
            mHorizontalAccuracy = ACCURACY_HIGH;
        } //End block
        {
            mHorizontalAccuracy = ACCURACY_LOW;
        } //End block
        addTaint(accuracy);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.203 -0400", hash_original_method = "738CC4C555122D617CAE26F950A7954B", hash_generated_method = "F7FAFC8F20ECF20FE198CCACE5E24A67")
    public int getAccuracy() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407154540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407154540;
        // ---------- Original Method ----------
        //if (mHorizontalAccuracy >= ACCURACY_HIGH) {
            //return ACCURACY_FINE;
        //} else {
            //return ACCURACY_COARSE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.204 -0400", hash_original_method = "91C2D38607A4F9F70C65E1811565AAD2", hash_generated_method = "3704BC2673B57DB61DA0B07ED4AB4CCE")
    public void setPowerRequirement(int level) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("level=" + level);
        } //End block
        mPowerRequirement = level;
        // ---------- Original Method ----------
        //if (level < NO_REQUIREMENT || level > POWER_HIGH) {
            //throw new IllegalArgumentException("level=" + level);
        //}
        //mPowerRequirement = level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.204 -0400", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "E16555ADF87B8923D29922C92147667A")
    public int getPowerRequirement() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767987971 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767987971;
        // ---------- Original Method ----------
        //return mPowerRequirement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.204 -0400", hash_original_method = "F89CAE570739AB3028DA707B2893B5C5", hash_generated_method = "443B9DB636371A2B7B02DF32D76227F5")
    public void setCostAllowed(boolean costAllowed) {
        mCostAllowed = costAllowed;
        // ---------- Original Method ----------
        //mCostAllowed = costAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.205 -0400", hash_original_method = "A41D9C3F2D62A3EB42A9C94631C7A3C6", hash_generated_method = "E7B1C0EF6BAE54D6D28F0D8D8460915B")
    public boolean isCostAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_913937874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_913937874;
        // ---------- Original Method ----------
        //return mCostAllowed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.205 -0400", hash_original_method = "22D4EC779FEBEFBD7A04B35673FD6242", hash_generated_method = "524AA438AB1E72E536604C84A2FEE4DD")
    public void setAltitudeRequired(boolean altitudeRequired) {
        mAltitudeRequired = altitudeRequired;
        // ---------- Original Method ----------
        //mAltitudeRequired = altitudeRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.205 -0400", hash_original_method = "B960582E2C1A3651AC20223DA8436091", hash_generated_method = "9490361B9104B8DBE91D5DB04619D504")
    public boolean isAltitudeRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151687576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151687576;
        // ---------- Original Method ----------
        //return mAltitudeRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.206 -0400", hash_original_method = "6A27513D0E2583F73F00042D0FDBD9E3", hash_generated_method = "8525723E1D70E6CFA504642A945EA5E3")
    public void setSpeedRequired(boolean speedRequired) {
        mSpeedRequired = speedRequired;
        // ---------- Original Method ----------
        //mSpeedRequired = speedRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.206 -0400", hash_original_method = "F6BA7163C74D6BF39003C6333C2CFD6D", hash_generated_method = "52AD71CB869875458A7E294CB777925B")
    public boolean isSpeedRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511689564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_511689564;
        // ---------- Original Method ----------
        //return mSpeedRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.206 -0400", hash_original_method = "B68158C6EC7F405A349EABCD21ABA300", hash_generated_method = "9B323C768409D641E011EE1EA543FD58")
    public void setBearingRequired(boolean bearingRequired) {
        mBearingRequired = bearingRequired;
        // ---------- Original Method ----------
        //mBearingRequired = bearingRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.206 -0400", hash_original_method = "17013BC273E96D7EA584C9522A6EEB48", hash_generated_method = "971AA724A9477C2978FB1C6273BD474B")
    public boolean isBearingRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_619323178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_619323178;
        // ---------- Original Method ----------
        //return mBearingRequired;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6F4A6F84C95026BE400F408F265CB885")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064427878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064427878;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_method = "F656AD17D4B37BFDE841686B6FE00CD9", hash_generated_method = "C28FA2939785A6D59F56795BF92C71CD")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mHorizontalAccuracy);
        parcel.writeInt(mVerticalAccuracy);
        parcel.writeInt(mSpeedAccuracy);
        parcel.writeInt(mBearingAccuracy);
        parcel.writeInt(mPowerRequirement);
        parcel.writeInt(mAltitudeRequired ? 1 : 0);
        parcel.writeInt(mBearingRequired ? 1 : 0);
        parcel.writeInt(mSpeedRequired ? 1 : 0);
        parcel.writeInt(mCostAllowed ? 1 : 0);
        addTaint(parcel.getTaint());
        addTaint(flags);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "B7D400F2964C178B086E2679800E2D89", hash_generated_field = "26610DC2B1083D7D7A6C941CAD5368F1")

    public static final int NO_REQUIREMENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "AE41CE7BE0BEFEA4A6A38E49E0B398ED", hash_generated_field = "2A8F870C36199E6F65F6D3EB71E31BF0")

    public static final int POWER_LOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "890CC80159603097DD27C3C84AD4AF57", hash_generated_field = "DFA9FE4C32E292E3C452D97E2C3C6CDA")

    public static final int POWER_MEDIUM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "182F660573A26FA2AD27A11CD10B27F6", hash_generated_field = "38275E31E5C855126379B323DE5DD9C7")

    public static final int POWER_HIGH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "124724F4BB45C3449013006EF5FEA6CE", hash_generated_field = "A366216338BB755942AC27704C9B79D8")

    public static final int ACCURACY_FINE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "EBA62E10E6E74191D33F5BCBA6CC9B50", hash_generated_field = "DD89026FA5904F8FEA9BF61E65028781")

    public static final int ACCURACY_COARSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "5E61442237B10B60E07735DE8E99BF3F", hash_generated_field = "FEEA110B2F23E156C40D0225E9C1F5E7")

    public static final int ACCURACY_LOW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "6A771DF807E4482FD6D3523C2295A4D1", hash_generated_field = "B88A3F805E6768C02C982D1B682E62DD")

    public static final int ACCURACY_MEDIUM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.207 -0400", hash_original_field = "1B20A5794EC66BE757CB2A24617C63E2", hash_generated_field = "DD965F02FCC4D35F6D665F7E61154460")

    public static final int ACCURACY_HIGH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.208 -0400", hash_original_field = "40988B39F05D9D61C63D1AD45A024C82", hash_generated_field = "3FE2F16195852B6CF068FB9D971A81E2")

    public static final Parcelable.Creator<Criteria> CREATOR =
        new Parcelable.Creator<Criteria>() {
        public Criteria createFromParcel(Parcel in) {
            Criteria c = new Criteria();
            c.mHorizontalAccuracy = in.readInt();
            c.mVerticalAccuracy = in.readInt();
            c.mSpeedAccuracy = in.readInt();
            c.mBearingAccuracy = in.readInt();
            c.mPowerRequirement = in.readInt();
            c.mAltitudeRequired = in.readInt() != 0;
            c.mBearingRequired = in.readInt() != 0;
            c.mSpeedRequired = in.readInt() != 0;
            c.mCostAllowed = in.readInt() != 0;
            return c;
        }

        public Criteria[] newArray(int size) {
            return new Criteria[size];
        }
    };
    // orphaned legacy method
    public Criteria createFromParcel(Parcel in) {
            Criteria c = new Criteria();
            c.mHorizontalAccuracy = in.readInt();
            c.mVerticalAccuracy = in.readInt();
            c.mSpeedAccuracy = in.readInt();
            c.mBearingAccuracy = in.readInt();
            c.mPowerRequirement = in.readInt();
            c.mAltitudeRequired = in.readInt() != 0;
            c.mBearingRequired = in.readInt() != 0;
            c.mSpeedRequired = in.readInt() != 0;
            c.mCostAllowed = in.readInt() != 0;
            return c;
        }
    
    // orphaned legacy method
    public Criteria[] newArray(int size) {
            return new Criteria[size];
        }
    
}

