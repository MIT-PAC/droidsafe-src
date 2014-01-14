package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class NetworkQuotaInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.535 -0500", hash_original_field = "3C0499E0CA6CDBC941167FB2A1DF2751", hash_generated_field = "E539E13304AD2EFC43281BB48BCCC988")

    public static final long NO_LIMIT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.512 -0400", hash_original_field = "C30C13B2174CCA474AC0B4E26A8A8887", hash_generated_field = "10C90A69725B1168CB9C00401EAC67D7")

    public static final Creator<NetworkQuotaInfo> CREATOR = new Creator<NetworkQuotaInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.553 -0500", hash_original_method = "85674AC106ECA128FFF8A8B0ECC3EA12", hash_generated_method = "8110533B5D5CA0943FB28EE11803FFFC")
        
public NetworkQuotaInfo createFromParcel(Parcel in) {
            return new NetworkQuotaInfo(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.557 -0500", hash_original_method = "2633585C810677A0333642C3ADAC298A", hash_generated_method = "0FF309790105EA5AA7558A8E1C4CED4A")
        
public NetworkQuotaInfo[] newArray(int size) {
            return new NetworkQuotaInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.528 -0500", hash_original_field = "A38F7F791F383038362BEE39280D7276", hash_generated_field = "0C1817B4E94B497C8227D0B7A72FE116")

    private  long mEstimatedBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.530 -0500", hash_original_field = "F9E309F63D19DDC93FB2666C75E586F4", hash_generated_field = "73638FB16A6CA962DBF7ED0C324F9A49")

    private  long mSoftLimitBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.532 -0500", hash_original_field = "40246F8181457662B8D7DBCF9BCBD608", hash_generated_field = "76CD01F9EEF38C6FB9C997FE2E595ECC")

    private  long mHardLimitBytes;

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.538 -0500", hash_original_method = "660F75E1FFA6B2DFE2CDD12BDF75A84D", hash_generated_method = "5CA68D22BCA58F2564379312DD8BF534")
    
public NetworkQuotaInfo(long estimatedBytes, long softLimitBytes, long hardLimitBytes) {
        mEstimatedBytes = estimatedBytes;
        mSoftLimitBytes = softLimitBytes;
        mHardLimitBytes = hardLimitBytes;
    }

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.540 -0500", hash_original_method = "F9FF260BD3516E5193BB69E75EACBCC6", hash_generated_method = "821E75F1BA5DA84279510F1575913F41")
    
public NetworkQuotaInfo(Parcel in) {
        mEstimatedBytes = in.readLong();
        mSoftLimitBytes = in.readLong();
        mHardLimitBytes = in.readLong();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.542 -0500", hash_original_method = "9A1B44DAAD2420BC074FF7BE5F6986CE", hash_generated_method = "7B5797C97FC4868BE78B242DA78472BC")
    
public long getEstimatedBytes() {
        return mEstimatedBytes;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.544 -0500", hash_original_method = "C8858C0BE5B1D5B7AD428D2F09A67941", hash_generated_method = "E451D4FDE91725E866E5C0B1AFE3631C")
    
public long getSoftLimitBytes() {
        return mSoftLimitBytes;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.546 -0500", hash_original_method = "32F0E566D231A4A60EB6312295EBA3AB", hash_generated_method = "3EE034154F6FEC6670C6BDE752990FCB")
    
public long getHardLimitBytes() {
        return mHardLimitBytes;
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.548 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:17.550 -0500", hash_original_method = "62923C632AA7262774DF27E525AA9FBB", hash_generated_method = "0051B31276075989FC1EA1D4E3C5C484")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeLong(mEstimatedBytes);
        out.writeLong(mSoftLimitBytes);
        out.writeLong(mHardLimitBytes);
    }
    // orphaned legacy method
    public NetworkQuotaInfo createFromParcel(Parcel in) {
            return new NetworkQuotaInfo(in);
        }
    
    // orphaned legacy method
    public NetworkQuotaInfo[] newArray(int size) {
            return new NetworkQuotaInfo[size];
        }
    
}

