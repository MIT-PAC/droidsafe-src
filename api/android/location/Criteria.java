package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class Criteria implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.251 -0500", hash_original_field = "63CBE5A41264DBB1C341FCA49432714F", hash_generated_field = "26610DC2B1083D7D7A6C941CAD5368F1")

    public static final int NO_REQUIREMENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.254 -0500", hash_original_field = "010D61EF0A509733DE2414B50C329E4F", hash_generated_field = "2A8F870C36199E6F65F6D3EB71E31BF0")

    public static final int POWER_LOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.256 -0500", hash_original_field = "25FCD11FFD22604D046B1576D342D939", hash_generated_field = "DFA9FE4C32E292E3C452D97E2C3C6CDA")

    public static final int POWER_MEDIUM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.259 -0500", hash_original_field = "5FF8AFECBBB1534C95EEBF6542758C17", hash_generated_field = "38275E31E5C855126379B323DE5DD9C7")

    public static final int POWER_HIGH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.261 -0500", hash_original_field = "DEC7CDCFADCAE7F0EC3648335F977BAB", hash_generated_field = "A366216338BB755942AC27704C9B79D8")

    public static final int ACCURACY_FINE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.263 -0500", hash_original_field = "8246CA30F4F9B225B886772D0A5A9825", hash_generated_field = "DD89026FA5904F8FEA9BF61E65028781")

    public static final int ACCURACY_COARSE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.266 -0500", hash_original_field = "83A8E5A324F04564547EC7B1D33C7017", hash_generated_field = "FEEA110B2F23E156C40D0225E9C1F5E7")

    public static final int ACCURACY_LOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.269 -0500", hash_original_field = "3F7A6FC693F3A2E08497D8F5D9694901", hash_generated_field = "B88A3F805E6768C02C982D1B682E62DD")

    public static final int ACCURACY_MEDIUM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.272 -0500", hash_original_field = "50AC762D15A43641B6E9BF142DAC344F", hash_generated_field = "DD965F02FCC4D35F6D665F7E61154460")

    public static final int ACCURACY_HIGH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.031 -0400", hash_original_field = "40988B39F05D9D61C63D1AD45A024C82", hash_generated_field = "3FE2F16195852B6CF068FB9D971A81E2")

    public static final Parcelable.Creator<Criteria> CREATOR =
        new Parcelable.Creator<Criteria>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.343 -0500", hash_original_method = "30491C0C577618E547D91203358C6C24", hash_generated_method = "11A7C9509B71460E736768A86BF2D488")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.346 -0500", hash_original_method = "C6BB0D5E0D629C065866F485B5D61E63", hash_generated_method = "E08DDDDCBD7FC498BFD02550407DD5F5")
        
public Criteria[] newArray(int size) {
            return new Criteria[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.274 -0500", hash_original_field = "E2741479255CBADB4ACA5A82DB917D12", hash_generated_field = "1A506D6FCBAE89E5ED8986984C204EDF")

    private int mHorizontalAccuracy    = NO_REQUIREMENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.276 -0500", hash_original_field = "D302B9EC3FF6A3B0F1FD7C3A3214A831", hash_generated_field = "9C948891D51E1ECED7D5B42EA88A1980")

    private int mVerticalAccuracy      = NO_REQUIREMENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.278 -0500", hash_original_field = "56C6CA8B32681E7A813455A9AEDB27C4", hash_generated_field = "4206F17114FC87E89D5E2D934FD265D1")

    private int mSpeedAccuracy         = NO_REQUIREMENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.279 -0500", hash_original_field = "2588554745FA1F044A1C4D13AC18A12C", hash_generated_field = "AFE00C78DEAD58C36FFBF596A3087BA3")

    private int mBearingAccuracy       = NO_REQUIREMENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.281 -0500", hash_original_field = "2DC6C28639296467C40C948BC3E6A984", hash_generated_field = "F89FA2DF8DA48BD5497DB50DA1CA47F5")

    private int mPowerRequirement      = NO_REQUIREMENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.284 -0500", hash_original_field = "C5EFCD856686A6D0716FCD0D7F6EFA21", hash_generated_field = "1ABEB241EAFF3EEBFF568528AFCBA219")

    private boolean mAltitudeRequired  = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.286 -0500", hash_original_field = "1D45BEC15AD60F3EC84FD72A73A0CBB1", hash_generated_field = "0299E987BE1DC1D0B0A7571822B9D8AA")

    private boolean mBearingRequired   = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.288 -0500", hash_original_field = "DE0438371E0B9CB3DFA6661645DE34A4", hash_generated_field = "9B3C565095BC4FCEC789B430DD2467DF")

    private boolean mSpeedRequired     = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.290 -0500", hash_original_field = "03E05C4E7441ED7AED911104212295B7", hash_generated_field = "4FF764166F8A934C7C88D2C8472DFB24")

    private boolean mCostAllowed       = false;

    /**
     * Constructs a new Criteria object.  The new object will have no
     * requirements on accuracy, power, or response time; will not
     * require altitude, speed, or bearing; and will not allow monetary
     * cost.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.293 -0500", hash_original_method = "56D25A23ADD1F3C93CB7F827DA5DFB02", hash_generated_method = "B843D41D9AC4259E19148AB7E4644051")
    
public Criteria() {}

    /**
     * Constructs a new Criteria object that is a copy of the given criteria.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.295 -0500", hash_original_method = "4027197A668FB712D0A5A09027B96247", hash_generated_method = "9253179FA8FD9943E9EC8B7E0F2095E8")
    
public Criteria(Criteria criteria) {
        mHorizontalAccuracy = criteria.mHorizontalAccuracy;
        mVerticalAccuracy = criteria.mVerticalAccuracy;
        mSpeedAccuracy = criteria.mSpeedAccuracy;
        mBearingAccuracy = criteria.mBearingAccuracy;
        mPowerRequirement = criteria.mPowerRequirement;
        mAltitudeRequired = criteria.mAltitudeRequired;
        mBearingRequired = criteria.mBearingRequired;
        mSpeedRequired = criteria.mSpeedRequired;
        mCostAllowed = criteria.mCostAllowed;
    }

    /**
     * Indicates the desired horizontal accuracy (latitude and longitude).
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_MEDIUM},
     * {@link #ACCURACY_HIGH} or {@link #NO_REQUIREMENT}.
     * More accurate location may consume more power and may take longer.
     *
     * @throws IllegalArgumentException if accuracy is not one of the supported constants
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.298 -0500", hash_original_method = "F7CDA1AEB030C3E960B93BFBD444E4B1", hash_generated_method = "395B5793E2926228F28A8561FDBE5527")
    
public void setHorizontalAccuracy(int accuracy) {
        if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            throw new IllegalArgumentException("accuracy=" + accuracy);
        }
        mHorizontalAccuracy = accuracy;
    }

    /**
     * Returns a constant indicating the desired horizontal accuracy (latitude and longitude).
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_MEDIUM},
     * {@link #ACCURACY_HIGH} or {@link #NO_REQUIREMENT}.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.300 -0500", hash_original_method = "2F566A20A5A9A3E4947DCE83AA9DF67E", hash_generated_method = "EB8464243AF7ED99CEFF9EF12492C38F")
    
public int getHorizontalAccuracy() {
        return mHorizontalAccuracy;
    }

    /**
     * Indicates the desired vertical accuracy (altitude).
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_MEDIUM},
     * {@link #ACCURACY_HIGH} or {@link #NO_REQUIREMENT}.
     * More accurate location may consume more power and may take longer.
     *
     * @throws IllegalArgumentException if accuracy is not one of the supported constants
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.303 -0500", hash_original_method = "A234CD6EE2124B9B176BE728225522DE", hash_generated_method = "F6901B2897EB48139E1616D80DCE46DA")
    
public void setVerticalAccuracy(int accuracy) {
        if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            throw new IllegalArgumentException("accuracy=" + accuracy);
        }
        mVerticalAccuracy = accuracy;
    }

    /**
     * Returns a constant indicating the desired vertical accuracy (altitude).
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
     * or {@link #NO_REQUIREMENT}.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.305 -0500", hash_original_method = "E46E133CF34270F0210C8D2BD309B3F5", hash_generated_method = "94819062ECBCBB5F4BA9A798966004AB")
    
public int getVerticalAccuracy() {
        return mVerticalAccuracy;
    }

    /**
     * Indicates the desired speed accuracy.
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
     * or {@link #NO_REQUIREMENT}.
     * More accurate location may consume more power and may take longer.
     *
     * @throws IllegalArgumentException if accuracy is not one of the supported constants
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.307 -0500", hash_original_method = "7DA41913012CB9940E77425DCF2D2731", hash_generated_method = "568CD3A2211FD367988935DD52811040")
    
public void setSpeedAccuracy(int accuracy) {
        if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            throw new IllegalArgumentException("accuracy=" + accuracy);
        }
        mSpeedAccuracy = accuracy;
    }

    /**
     * Returns a constant indicating the desired speed accuracy
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
     * or {@link #NO_REQUIREMENT}.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.309 -0500", hash_original_method = "87339E07174611DFFFF3AC3EA0F5BF3F", hash_generated_method = "D84B90D39E5AACB43C21888DD25278A3")
    
public int getSpeedAccuracy() {
        return mSpeedAccuracy;
    }

    /**
     * Indicates the desired bearing accuracy.
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
     * or {@link #NO_REQUIREMENT}.
     * More accurate location may consume more power and may take longer.
     *
     * @throws IllegalArgumentException if accuracy is not one of the supported constants
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.311 -0500", hash_original_method = "7D38552738106C949C369F73EBC07BAD", hash_generated_method = "D2B2D29706A8B5EF4D11A9B04D9C0103")
    
public void setBearingAccuracy(int accuracy) {
        if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_HIGH) {
            throw new IllegalArgumentException("accuracy=" + accuracy);
        }
        mBearingAccuracy = accuracy;
    }

    /**
     * Returns a constant indicating the desired bearing accuracy.
     * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
     * or {@link #NO_REQUIREMENT}.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.313 -0500", hash_original_method = "0A4814C8F779184929A4F3680AE62C8F", hash_generated_method = "7697EC11E830EBC0BE062129992E126B")
    
public int getBearingAccuracy() {
        return mBearingAccuracy;
    }

    /**
     * Indicates the desired accuracy for latitude and longitude. Accuracy
     * may be {@link #ACCURACY_FINE} if desired location
     * is fine, else it can be {@link #ACCURACY_COARSE}.
     * More accurate location may consume more power and may take longer.
     *
     * @throws IllegalArgumentException if accuracy is not one of the supported constants
     */
    @DSComment("Used for thresholding")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.316 -0500", hash_original_method = "F2B3644622DFC41E9C3EF3B6293185D6", hash_generated_method = "1A102D596F6E2D9DAE1D224E05ADE788")
    
public void setAccuracy(int accuracy) {
        if (accuracy < NO_REQUIREMENT || accuracy > ACCURACY_COARSE) {
            throw new IllegalArgumentException("accuracy=" + accuracy);
        }
        if (accuracy == ACCURACY_FINE) {
            mHorizontalAccuracy = ACCURACY_HIGH;
        } else {
            mHorizontalAccuracy = ACCURACY_LOW;
        }
    }

    /**
     * Returns a constant indicating desired accuracy of location
     * Accuracy may be {@link #ACCURACY_FINE} if desired location
     * is fine, else it can be {@link #ACCURACY_COARSE}.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.318 -0500", hash_original_method = "738CC4C555122D617CAE26F950A7954B", hash_generated_method = "00869F8EC38CFA4A6F3EE3578ACFA369")
    
public int getAccuracy() {
        if (mHorizontalAccuracy >= ACCURACY_HIGH) {
            return ACCURACY_FINE;
        } else {
            return ACCURACY_COARSE;
        }
    }

    /**
     * Indicates the desired maximum power level.  The level parameter
     * must be one of NO_REQUIREMENT, POWER_LOW, POWER_MEDIUM, or
     * POWER_HIGH.
     */
    @DSComment("Used for thresholding")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.320 -0500", hash_original_method = "91C2D38607A4F9F70C65E1811565AAD2", hash_generated_method = "0EF8DF914CF98349FC7CDF24CF89D3FA")
    
public void setPowerRequirement(int level) {
        if (level < NO_REQUIREMENT || level > POWER_HIGH) {
            throw new IllegalArgumentException("level=" + level);
        }
        mPowerRequirement = level;
    }

    /**
     * Returns a constant indicating the desired power requirement.  The
     * returned
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.323 -0500", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "3E881DFE958F83CAFAEFC8ECCCA7BA30")
    
public int getPowerRequirement() {
        return mPowerRequirement;
    }

    /**
     * Indicates whether the provider is allowed to incur monetary cost.
     */
    @DSComment("Used for thresholding")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.325 -0500", hash_original_method = "F89CAE570739AB3028DA707B2893B5C5", hash_generated_method = "6C6BEAC76587EDC68F07B4308B80DDA6")
    
public void setCostAllowed(boolean costAllowed) {
        mCostAllowed = costAllowed;
    }

    /**
     * Returns whether the provider is allowed to incur monetary cost.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.327 -0500", hash_original_method = "A41D9C3F2D62A3EB42A9C94631C7A3C6", hash_generated_method = "133E4BC88C6EBF706004D4C070670023")
    
public boolean isCostAllowed() {
        return mCostAllowed;
    }

    /**
     * Indicates whether the provider must provide altitude information.
     * Not all fixes are guaranteed to contain such information.
     */
    @DSComment("Used for thresholding")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.329 -0500", hash_original_method = "22D4EC779FEBEFBD7A04B35673FD6242", hash_generated_method = "57CCF4C061CD44F3AC28D9C851A3B818")
    
public void setAltitudeRequired(boolean altitudeRequired) {
        mAltitudeRequired = altitudeRequired;
    }

    /**
     * Returns whether the provider must provide altitude information.
     * Not all fixes are guaranteed to contain such information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.331 -0500", hash_original_method = "B960582E2C1A3651AC20223DA8436091", hash_generated_method = "90D760E4C8F665F8BC5239D7CE47F7BE")
    
public boolean isAltitudeRequired() {
        return mAltitudeRequired;
    }

    /**
     * Indicates whether the provider must provide speed information.
     * Not all fixes are guaranteed to contain such information.
     */
    @DSComment("Used for thresholding")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.333 -0500", hash_original_method = "6A27513D0E2583F73F00042D0FDBD9E3", hash_generated_method = "ED70CA5983122935A64226B480B75ED9")
    
public void setSpeedRequired(boolean speedRequired) {
        mSpeedRequired = speedRequired;
    }

    /**
     * Returns whether the provider must provide speed information.
     * Not all fixes are guaranteed to contain such information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.335 -0500", hash_original_method = "F6BA7163C74D6BF39003C6333C2CFD6D", hash_generated_method = "5BE759E173072751C08E54289964369D")
    
public boolean isSpeedRequired() {
        return mSpeedRequired;
    }

    /**
     * Indicates whether the provider must provide bearing information.
     * Not all fixes are guaranteed to contain such information.
     */
    @DSComment("Used for thresholding")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.337 -0500", hash_original_method = "B68158C6EC7F405A349EABCD21ABA300", hash_generated_method = "CCFB5BA3E59FE9614A29061580CF2070")
    
public void setBearingRequired(boolean bearingRequired) {
        mBearingRequired = bearingRequired;
    }

    /**
     * Returns whether the provider must provide bearing information.
     * Not all fixes are guaranteed to contain such information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.340 -0500", hash_original_method = "17013BC273E96D7EA584C9522A6EEB48", hash_generated_method = "385B4ABCA4BDC4FB2BF9CA212825AA83")
    
public boolean isBearingRequired() {
        return mBearingRequired;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.351 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.353 -0500", hash_original_method = "F656AD17D4B37BFDE841686B6FE00CD9", hash_generated_method = "7041913C16F7BEE4C7291DA8472BBABC")
    
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
    }
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

