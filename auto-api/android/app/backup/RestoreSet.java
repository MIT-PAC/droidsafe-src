package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class RestoreSet implements Parcelable {
    public String name;
    public String device;
    public long token;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.895 -0400", hash_original_method = "8F1DCA72C97A5A82D254BEC6432DE3FB", hash_generated_method = "7FCB63EDEACCF2BAFC1B2567162DB769")
    @DSModeled(DSC.SAFE)
    public RestoreSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.895 -0400", hash_original_method = "F547208C80F4E032CD5D9862703EA509", hash_generated_method = "77AB0BAE93E94E0497B90B403E9BCA71")
    @DSModeled(DSC.SAFE)
    public RestoreSet(String _name, String _dev, long _token) {
        dsTaint.addTaint(_dev);
        dsTaint.addTaint(_name);
        dsTaint.addTaint(_token);
        // ---------- Original Method ----------
        //name = _name;
        //device = _dev;
        //token = _token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.896 -0400", hash_original_method = "2219E3A595B9AC7F0E16EAF40A593277", hash_generated_method = "51D20EFA98930AF0C2A02DD261083FF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private RestoreSet(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        name = in.readString();
        device = in.readString();
        token = in.readLong();
        // ---------- Original Method ----------
        //name = in.readString();
        //device = in.readString();
        //token = in.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.896 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.897 -0400", hash_original_method = "6F3E6147075189D34A5652BA91455185", hash_generated_method = "6B6E0EEDDBD2BAE0DBCA716C1041F9D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeString(name);
        out.writeString(device);
        out.writeLong(token);
        // ---------- Original Method ----------
        //out.writeString(name);
        //out.writeString(device);
        //out.writeLong(token);
    }

    
    public static final Parcelable.Creator<RestoreSet> CREATOR = new Parcelable.Creator<RestoreSet>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.898 -0400", hash_original_method = "BAC0E1D02FA6C265C2D5D1FA79671B4B", hash_generated_method = "66371CA090D291097249E03DE63B8A55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RestoreSet createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            RestoreSet var9079338B6CF3C389A49FE1112F1EEA49_794395038 = (new RestoreSet(in));
            return (RestoreSet)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RestoreSet(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.898 -0400", hash_original_method = "03C8EF6AD074BC1F725D7C9C3018C39D", hash_generated_method = "4A1161A72EE0C95AFF36F0A979D713B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RestoreSet[] newArray(int size) {
            dsTaint.addTaint(size);
            RestoreSet[] var9853A6D18DDD36B7F3CAD92DB6352031_91892855 = (new RestoreSet[size]);
            return (RestoreSet[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new RestoreSet[size];
        }

        
}; //Transformed anonymous class
}

