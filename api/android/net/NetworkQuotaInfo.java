package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class NetworkQuotaInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.507 -0400", hash_original_field = "E081766EDB5BBAB91596FB5A1B03B4B8", hash_generated_field = "0C1817B4E94B497C8227D0B7A72FE116")

    private long mEstimatedBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.507 -0400", hash_original_field = "407B6D18E17605524108F73C59330777", hash_generated_field = "73638FB16A6CA962DBF7ED0C324F9A49")

    private long mSoftLimitBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.507 -0400", hash_original_field = "A2D5EBBE48D8BF149BE44E9240D2555E", hash_generated_field = "76CD01F9EEF38C6FB9C997FE2E595ECC")

    private long mHardLimitBytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.508 -0400", hash_original_method = "660F75E1FFA6B2DFE2CDD12BDF75A84D", hash_generated_method = "91C439B321E81D734DBCF25192A8DAA4")
    public  NetworkQuotaInfo(long estimatedBytes, long softLimitBytes, long hardLimitBytes) {
        mEstimatedBytes = estimatedBytes;
        mSoftLimitBytes = softLimitBytes;
        mHardLimitBytes = hardLimitBytes;
        // ---------- Original Method ----------
        //mEstimatedBytes = estimatedBytes;
        //mSoftLimitBytes = softLimitBytes;
        //mHardLimitBytes = hardLimitBytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.509 -0400", hash_original_method = "F9FF260BD3516E5193BB69E75EACBCC6", hash_generated_method = "506083803062B317728026A841CC5B03")
    public  NetworkQuotaInfo(Parcel in) {
        mEstimatedBytes = in.readLong();
        mSoftLimitBytes = in.readLong();
        mHardLimitBytes = in.readLong();
        // ---------- Original Method ----------
        //mEstimatedBytes = in.readLong();
        //mSoftLimitBytes = in.readLong();
        //mHardLimitBytes = in.readLong();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.509 -0400", hash_original_method = "9A1B44DAAD2420BC074FF7BE5F6986CE", hash_generated_method = "F338335B926C73074A1807253A7AD454")
    public long getEstimatedBytes() {
        long varE081766EDB5BBAB91596FB5A1B03B4B8_309740539 = (mEstimatedBytes);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_545992415 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_545992415;
        // ---------- Original Method ----------
        //return mEstimatedBytes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.510 -0400", hash_original_method = "C8858C0BE5B1D5B7AD428D2F09A67941", hash_generated_method = "710C9E269537935C068A137C62BD5FD2")
    public long getSoftLimitBytes() {
        long var407B6D18E17605524108F73C59330777_2099925558 = (mSoftLimitBytes);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_135395729 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_135395729;
        // ---------- Original Method ----------
        //return mSoftLimitBytes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.510 -0400", hash_original_method = "32F0E566D231A4A60EB6312295EBA3AB", hash_generated_method = "35E801095CFCF38E8937380259D4385D")
    public long getHardLimitBytes() {
        long varA2D5EBBE48D8BF149BE44E9240D2555E_1209933865 = (mHardLimitBytes);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1336519472 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1336519472;
        // ---------- Original Method ----------
        //return mHardLimitBytes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.511 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5FA075CA2F267F629737C5186F9E75C4")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1228425815 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674091824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674091824;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.512 -0400", hash_original_method = "62923C632AA7262774DF27E525AA9FBB", hash_generated_method = "068BB645A106698A95318ECF8F142BC4")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeLong(mEstimatedBytes);
        out.writeLong(mSoftLimitBytes);
        out.writeLong(mHardLimitBytes);
        // ---------- Original Method ----------
        //out.writeLong(mEstimatedBytes);
        //out.writeLong(mSoftLimitBytes);
        //out.writeLong(mHardLimitBytes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.512 -0400", hash_original_field = "3A6F0957B225CC85FBDC5752E5B857F6", hash_generated_field = "E539E13304AD2EFC43281BB48BCCC988")

    public static final long NO_LIMIT = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.512 -0400", hash_original_field = "C30C13B2174CCA474AC0B4E26A8A8887", hash_generated_field = "10C90A69725B1168CB9C00401EAC67D7")

    public static final Creator<NetworkQuotaInfo> CREATOR = new Creator<NetworkQuotaInfo>() {
        public NetworkQuotaInfo createFromParcel(Parcel in) {
            return new NetworkQuotaInfo(in);
        }

        public NetworkQuotaInfo[] newArray(int size) {
            return new NetworkQuotaInfo[size];
        }
    };
    // orphaned legacy method
    public NetworkQuotaInfo createFromParcel(Parcel in) {
            return new NetworkQuotaInfo(in);
        }
    
    // orphaned legacy method
    public NetworkQuotaInfo[] newArray(int size) {
            return new NetworkQuotaInfo[size];
        }
    
}

