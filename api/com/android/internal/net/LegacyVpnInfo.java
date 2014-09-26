package com.android.internal.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public class LegacyVpnInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.899 -0500", hash_original_field = "1D68C8F7C30276313FF74EEBEDEBB1AC", hash_generated_field = "84173E1866F23EE943EF8008ED8CFAFC")

    public static final int STATE_DISCONNECTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.903 -0500", hash_original_field = "BC1512AF2F9077AD288B172B1426373D", hash_generated_field = "016514EB1A66CD51C2D290D20A5E5DC8")

    public static final int STATE_INITIALIZING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.905 -0500", hash_original_field = "63A81BB9A1BD0AD00E27BB05F2FE05BE", hash_generated_field = "2B29FF010792E2F84CB7FF35F9F85DB2")

    public static final int STATE_CONNECTING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.908 -0500", hash_original_field = "E15AA924CB9B2A6A031056C34BB0AEEE", hash_generated_field = "F45CAA90922497D9AAAEEE9457397413")

    public static final int STATE_CONNECTED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.911 -0500", hash_original_field = "8DD4CF3F07F37D1B80A03F51693F5E31", hash_generated_field = "B2AE2095C3FC0C47E40CB9745CC51691")

    public static final int STATE_TIMEOUT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.913 -0500", hash_original_field = "2A17A91081D01946EB0D1C764C5EC2BB", hash_generated_field = "9955981CE50F2033FFB238F1C66B89BF")

    public static final int STATE_FAILED = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.405 -0400", hash_original_field = "FA0AC8AE4D497C7BADBA4EE7157745FE", hash_generated_field = "38D4AA579EFE31A36382C36119A7DA33")

    public static final Parcelable.Creator<LegacyVpnInfo> CREATOR =
            new Parcelable.Creator<LegacyVpnInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.930 -0500", hash_original_method = "A46B4E61A6786E2EC5A02BFF9297FE09", hash_generated_method = "87A9E08394118D8E716C2510A919BB7E")
        
@Override
        public LegacyVpnInfo createFromParcel(Parcel in) {
            LegacyVpnInfo info = new LegacyVpnInfo();
            info.key = in.readString();
            info.state = in.readInt();
            info.intent = in.readParcelable(null);
            return info;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.933 -0500", hash_original_method = "7CBE873F158E21B5DF85DE752E212EE2", hash_generated_method = "493DF19A92B07FB82320463828A8C766")
        
@Override
        public LegacyVpnInfo[] newArray(int size) {
            return new LegacyVpnInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.916 -0500", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "9594FABAACFBD659AE1FC0B0C9AAFC8C")

    public String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.919 -0500", hash_original_field = "17C36326B9683FA933B8773DE02D4EFE", hash_generated_field = "924108B50A94C58AFBCA8A5C60C836A0")

    public int state = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.921 -0500", hash_original_field = "9FBC825B56F85F39712131C7EB761CD4", hash_generated_field = "31DE5AC1D3B2F19AF941DBEFA8955100")

    public PendingIntent intent;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.404 -0400", hash_original_method = "1DAFF6D63CD8989C4DEAE95F675849A5", hash_generated_method = "1DAFF6D63CD8989C4DEAE95F675849A5")
    public LegacyVpnInfo ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.924 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:58.926 -0500", hash_original_method = "25107BEE45DBA0B67087A892F5280105", hash_generated_method = "06B4553160E8C5D16029F506EF5B23BD")
    
@Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(key);
        out.writeInt(state);
        out.writeParcelable(intent, flags);
    }
}

