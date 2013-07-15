package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class RestoreSet implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.790 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.790 -0400", hash_original_field = "913F9C49DCB544E2087CEE284F4A00B7", hash_generated_field = "0631FBD4EFF378254463BB4235C76180")

    public String device;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.790 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "D837BDC3597836EC3D401AFD06D9D644")

    public long token;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.790 -0400", hash_original_method = "8F1DCA72C97A5A82D254BEC6432DE3FB", hash_generated_method = "7FCB63EDEACCF2BAFC1B2567162DB769")
    public  RestoreSet() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.791 -0400", hash_original_method = "F547208C80F4E032CD5D9862703EA509", hash_generated_method = "A2BEDB96F1DE1981EA8EAA97E414F2A2")
    public  RestoreSet(String _name, String _dev, long _token) {
        name = _name;
        device = _dev;
        token = _token;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.791 -0400", hash_original_method = "2219E3A595B9AC7F0E16EAF40A593277", hash_generated_method = "515D016B6FCBFDE2EE05BA656DC5FEA2")
    private  RestoreSet(Parcel in) {
        name = in.readString();
        device = in.readString();
        token = in.readLong();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.792 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3157D68484F4EC8986062B89700A9624")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335997475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335997475;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.793 -0400", hash_original_method = "6F3E6147075189D34A5652BA91455185", hash_generated_method = "F1258177722E9F0EC5E6487116BC2722")
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeString(device);
        out.writeLong(token);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.793 -0400", hash_original_field = "CE8E8F9B87B41BD54B3EF7D5C775C91C", hash_generated_field = "FA29E88161E42230CFC58EC9483694A2")

    public static final Parcelable.Creator<RestoreSet> CREATOR
            = new Parcelable.Creator<RestoreSet>() {
        public RestoreSet createFromParcel(Parcel in) {
            return new RestoreSet(in);
        }

        public RestoreSet[] newArray(int size) {
            return new RestoreSet[size];
        }
    };
    
    public RestoreSet createFromParcel(Parcel in) {
            return new RestoreSet(in);
        }
    
    
    public RestoreSet[] newArray(int size) {
            return new RestoreSet[size];
        }
    
}

