package com.android.internal.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public class LegacyVpnInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "9594FABAACFBD659AE1FC0B0C9AAFC8C")

    public String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_field = "B13C44E6D5EBF461207B2405F8395031", hash_generated_field = "924108B50A94C58AFBCA8A5C60C836A0")

    public int state = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "31DE5AC1D3B2F19AF941DBEFA8955100")

    public PendingIntent intent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_method = "1DAFF6D63CD8989C4DEAE95F675849A5", hash_generated_method = "1DAFF6D63CD8989C4DEAE95F675849A5")
    public LegacyVpnInfo ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F10488E5245CA4584E47D0E92E73D6A7")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1783636368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1783636368;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_method = "25107BEE45DBA0B67087A892F5280105", hash_generated_method = "06F92F96FBFDFC988983F0CBC9239A5F")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(key);
        out.writeInt(state);
        out.writeParcelable(intent, flags);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_field = "2D50E5D85E482FA800E087638A951161", hash_generated_field = "84173E1866F23EE943EF8008ED8CFAFC")

    public static final int STATE_DISCONNECTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.372 -0400", hash_original_field = "375B43DCBA2E95256FCD63BC8A7B176E", hash_generated_field = "016514EB1A66CD51C2D290D20A5E5DC8")

    public static final int STATE_INITIALIZING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.373 -0400", hash_original_field = "A557C7FFCE5597B603CBD2B12D1E2517", hash_generated_field = "2B29FF010792E2F84CB7FF35F9F85DB2")

    public static final int STATE_CONNECTING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.373 -0400", hash_original_field = "EFF9863FE4F990343B121C90EABFE87B", hash_generated_field = "F45CAA90922497D9AAAEEE9457397413")

    public static final int STATE_CONNECTED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.373 -0400", hash_original_field = "99E3B7D7F8072E68D049E47470993498", hash_generated_field = "B2AE2095C3FC0C47E40CB9745CC51691")

    public static final int STATE_TIMEOUT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.373 -0400", hash_original_field = "A42B17C4417CC9707937EF3E9207B907", hash_generated_field = "9955981CE50F2033FFB238F1C66B89BF")

    public static final int STATE_FAILED = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.373 -0400", hash_original_field = "FA0AC8AE4D497C7BADBA4EE7157745FE", hash_generated_field = "38D4AA579EFE31A36382C36119A7DA33")

    public static final Parcelable.Creator<LegacyVpnInfo> CREATOR =
            new Parcelable.Creator<LegacyVpnInfo>() {
        @Override
        public LegacyVpnInfo createFromParcel(Parcel in) {
            LegacyVpnInfo info = new LegacyVpnInfo();
            info.key = in.readString();
            info.state = in.readInt();
            info.intent = in.readParcelable(null);
            return info;
        }

        @Override
        public LegacyVpnInfo[] newArray(int size) {
            return new LegacyVpnInfo[size];
        }
    };
}

