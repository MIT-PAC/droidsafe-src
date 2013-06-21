package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class NetworkQuotaInfo implements Parcelable {
    private long mEstimatedBytes;
    private long mSoftLimitBytes;
    private long mHardLimitBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.126 -0400", hash_original_method = "660F75E1FFA6B2DFE2CDD12BDF75A84D", hash_generated_method = "39633A8159D658C5651D9CCB7CD87A84")
    @DSModeled(DSC.SAFE)
    public NetworkQuotaInfo(long estimatedBytes, long softLimitBytes, long hardLimitBytes) {
        dsTaint.addTaint(softLimitBytes);
        dsTaint.addTaint(estimatedBytes);
        dsTaint.addTaint(hardLimitBytes);
        // ---------- Original Method ----------
        //mEstimatedBytes = estimatedBytes;
        //mSoftLimitBytes = softLimitBytes;
        //mHardLimitBytes = hardLimitBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.126 -0400", hash_original_method = "F9FF260BD3516E5193BB69E75EACBCC6", hash_generated_method = "08B705ED5947F0B945593E579BDA53C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkQuotaInfo(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mEstimatedBytes = in.readLong();
        mSoftLimitBytes = in.readLong();
        mHardLimitBytes = in.readLong();
        // ---------- Original Method ----------
        //mEstimatedBytes = in.readLong();
        //mSoftLimitBytes = in.readLong();
        //mHardLimitBytes = in.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.127 -0400", hash_original_method = "9A1B44DAAD2420BC074FF7BE5F6986CE", hash_generated_method = "05F686AB5ACE033216E3C50FC71B4D96")
    @DSModeled(DSC.SAFE)
    public long getEstimatedBytes() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mEstimatedBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.127 -0400", hash_original_method = "C8858C0BE5B1D5B7AD428D2F09A67941", hash_generated_method = "D2B0B299087F0687C3A281C610E0ADE1")
    @DSModeled(DSC.SAFE)
    public long getSoftLimitBytes() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mSoftLimitBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.127 -0400", hash_original_method = "32F0E566D231A4A60EB6312295EBA3AB", hash_generated_method = "2DB0B411B2B9FE25973B11FA8C17CDC8")
    @DSModeled(DSC.SAFE)
    public long getHardLimitBytes() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mHardLimitBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.127 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.127 -0400", hash_original_method = "62923C632AA7262774DF27E525AA9FBB", hash_generated_method = "78890832AAE82643A3F89C66375C3C42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeLong(mEstimatedBytes);
        out.writeLong(mSoftLimitBytes);
        out.writeLong(mHardLimitBytes);
        // ---------- Original Method ----------
        //out.writeLong(mEstimatedBytes);
        //out.writeLong(mSoftLimitBytes);
        //out.writeLong(mHardLimitBytes);
    }

    
    public static final long NO_LIMIT = -1;
    public static final Creator<NetworkQuotaInfo> CREATOR = new Creator<NetworkQuotaInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.128 -0400", hash_original_method = "85674AC106ECA128FFF8A8B0ECC3EA12", hash_generated_method = "7C7660DEE652C34E2F1BF7935304A2E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkQuotaInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            NetworkQuotaInfo varEC4A755A980311266D91DE6D7F5C2056_788212902 = (new NetworkQuotaInfo(in));
            return (NetworkQuotaInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkQuotaInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.128 -0400", hash_original_method = "2633585C810677A0333642C3ADAC298A", hash_generated_method = "1E26668A22D9F23E110CC1A2D97F4B5D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkQuotaInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            NetworkQuotaInfo[] var8359C847D2485B31DEA268B179C115FE_1682541961 = (new NetworkQuotaInfo[size]);
            return (NetworkQuotaInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkQuotaInfo[size];
        }

        
}; //Transformed anonymous class
}

