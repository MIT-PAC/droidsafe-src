package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class Duration implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.244 -0400", hash_original_field = "83EDDDD23EF2D6AE09F491892B0578B3", hash_generated_field = "35448C58A22DDC559F47B71F64B98655")

    public int timeInterval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.244 -0400", hash_original_field = "27925A6F36FEC889D656734B42198E41", hash_generated_field = "E104F5569DCF2B31AE0BB025718138E9")

    public TimeUnit timeUnit;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.244 -0400", hash_original_method = "49A364E6511EE6731DA0B9EFBCF0B191", hash_generated_method = "8F8EFD460557BC387A4BF66295DC5E94")
    public  Duration(int timeInterval, TimeUnit timeUnit) {
        this.timeInterval = timeInterval;
        this.timeUnit = timeUnit;
        // ---------- Original Method ----------
        //this.timeInterval = timeInterval;
        //this.timeUnit = timeUnit;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.245 -0400", hash_original_method = "69931BD60CFF69C2725A634D6D46CC0C", hash_generated_method = "11E9DFB1B0D109A8D4B961250E06B76D")
    private  Duration(Parcel in) {
        timeInterval = in.readInt();
        timeUnit = TimeUnit.values()[in.readInt()];
        // ---------- Original Method ----------
        //timeInterval = in.readInt();
        //timeUnit = TimeUnit.values()[in.readInt()];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.245 -0400", hash_original_method = "7A3E2E3AAE56FB706A1FF7E711848E72", hash_generated_method = "EBBD3A9FB1527FD19B02BDFFB66F95E6")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(timeInterval);
        dest.writeInt(timeUnit.ordinal());
        // ---------- Original Method ----------
        //dest.writeInt(timeInterval);
        //dest.writeInt(timeUnit.ordinal());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.245 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1EB6A3987875E692DF9987CD01B921EB")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1536393969 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342268091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342268091;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public enum TimeUnit {
        MINUTE(0x00),
        SECOND(0x01),
        TENTH_SECOND(0x02);
        private int mValue;
        TimeUnit(int value) {
            mValue = value;
        }
        @DSModeled(DSC.BAN)
        public int value() {
            return mValue;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:20.245 -0400", hash_original_field = "A45E48454A5718B4D58B745F8A75DBD7", hash_generated_field = "3313211CC65C61401C6638CF5336E71F")

    public static final Parcelable.Creator<Duration> CREATOR = new Parcelable.Creator<Duration>() {
        @DSModeled(DSC.BAN)
        public Duration createFromParcel(Parcel in) {
            return new Duration(in);
        }

        @DSModeled(DSC.BAN)
        public Duration[] newArray(int size) {
            return new Duration[size];
        }
    };
}

