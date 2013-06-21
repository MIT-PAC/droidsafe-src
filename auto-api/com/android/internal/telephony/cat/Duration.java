package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class Duration implements Parcelable {
    public int timeInterval;
    public TimeUnit timeUnit;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.890 -0400", hash_original_method = "49A364E6511EE6731DA0B9EFBCF0B191", hash_generated_method = "0CD9751810AF7E5481052C44AB6D9B2E")
    @DSModeled(DSC.SAFE)
    public Duration(int timeInterval, TimeUnit timeUnit) {
        dsTaint.addTaint(timeInterval);
        dsTaint.addTaint(timeUnit.dsTaint);
        // ---------- Original Method ----------
        //this.timeInterval = timeInterval;
        //this.timeUnit = timeUnit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.890 -0400", hash_original_method = "69931BD60CFF69C2725A634D6D46CC0C", hash_generated_method = "6594ED53B2D47F4E9F6E131CC64A90C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Duration(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        timeInterval = in.readInt();
        timeUnit = TimeUnit.values()[in.readInt()];
        // ---------- Original Method ----------
        //timeInterval = in.readInt();
        //timeUnit = TimeUnit.values()[in.readInt()];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.890 -0400", hash_original_method = "7A3E2E3AAE56FB706A1FF7E711848E72", hash_generated_method = "C215457F8A5BCF39E76570B4904E2DE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(timeInterval);
        dest.writeInt(timeUnit.ordinal());
        // ---------- Original Method ----------
        //dest.writeInt(timeInterval);
        //dest.writeInt(timeUnit.ordinal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.890 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
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
        public int value() {
            return mValue;
        }
    }

    
    public static final Parcelable.Creator<Duration> CREATOR = new Parcelable.Creator<Duration>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.891 -0400", hash_original_method = "68D9516041C92E7EB281A6DDCC1708DE", hash_generated_method = "55E7A37FC55693299BB942189AE3A0EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Duration createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Duration var4CA2023526B2EBE9BAE6BF18ADB250CE_1633787437 = (new Duration(in));
            return (Duration)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Duration(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.891 -0400", hash_original_method = "FA2B9C14FB9C286DB1C90150CBF11069", hash_generated_method = "2FDEA6FA032A67F963C623374E4DAE62")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Duration[] newArray(int size) {
            dsTaint.addTaint(size);
            Duration[] varE53A5EC0C7DF647975C772EEA28FD723_1682907850 = (new Duration[size]);
            return (Duration[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Duration[size];
        }

        
}; //Transformed anonymous class
}

