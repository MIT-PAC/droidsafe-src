package com.android.internal.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public class LegacyVpnInfo implements Parcelable {
    public String key;
    public int state = -1;
    public PendingIntent intent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.178 -0400", hash_original_method = "05A01399A13D9C5E7AC4169FDF632198", hash_generated_method = "05A01399A13D9C5E7AC4169FDF632198")
        public LegacyVpnInfo ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.178 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.178 -0400", hash_original_method = "25107BEE45DBA0B67087A892F5280105", hash_generated_method = "9D9C647F87FE65B106D775338455B58E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(key);
        out.writeInt(state);
        out.writeParcelable(intent, flags);
        // ---------- Original Method ----------
        //out.writeString(key);
        //out.writeInt(state);
        //out.writeParcelable(intent, flags);
    }

    
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_INITIALIZING = 1;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_TIMEOUT = 4;
    public static final int STATE_FAILED = 5;
    public static final Parcelable.Creator<LegacyVpnInfo> CREATOR = new Parcelable.Creator<LegacyVpnInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.179 -0400", hash_original_method = "A46B4E61A6786E2EC5A02BFF9297FE09", hash_generated_method = "9CEB6E0B96A07EE9595E1162DAEFC3E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public LegacyVpnInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            LegacyVpnInfo info;
            info = new LegacyVpnInfo();
            info.key = in.readString();
            info.state = in.readInt();
            info.intent = in.readParcelable(null);
            return (LegacyVpnInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //LegacyVpnInfo info = new LegacyVpnInfo();
            //info.key = in.readString();
            //info.state = in.readInt();
            //info.intent = in.readParcelable(null);
            //return info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.179 -0400", hash_original_method = "7CBE873F158E21B5DF85DE752E212EE2", hash_generated_method = "43AD23ABFF2C39DABF8A18CFC2922B3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public LegacyVpnInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            LegacyVpnInfo[] var9FADBA4BF8884B6A54CDBC3889CCA4EC_88419316 = (new LegacyVpnInfo[size]);
            return (LegacyVpnInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LegacyVpnInfo[size];
        }

        
}; //Transformed anonymous class
}

