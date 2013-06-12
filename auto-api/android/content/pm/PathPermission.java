package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;

public class PathPermission extends PatternMatcher {
    private final String mReadPermission;
    private final String mWritePermission;
    public static final Parcelable.Creator<PathPermission> CREATOR = new Parcelable.Creator<PathPermission>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.132 -0400", hash_original_method = "FB68BFC6586F43B368BF10107C1ED83E", hash_generated_method = "187708B11D50FF41A05D709AFB80AC2B")
        @DSModeled(DSC.SAFE)
        public PathPermission createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (PathPermission)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PathPermission(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.132 -0400", hash_original_method = "53F8BB5AC790624D851E4D5B8884399B", hash_generated_method = "55E68CF3AF25582FD5B6A10B3210E25F")
        @DSModeled(DSC.SAFE)
        public PathPermission[] newArray(int size) {
            dsTaint.addTaint(size);
            return (PathPermission[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PathPermission[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.132 -0400", hash_original_method = "79E6B4567C92E932C6F7E4E0D19FFE51", hash_generated_method = "326D5AC6749A73CCE41D3C36782E592F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PathPermission(String pattern, int type, String readPermission,
            String writePermission) {
        super(pattern, type);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(type);
        mReadPermission = readPermission;
        mWritePermission = writePermission;
        // ---------- Original Method ----------
        //mReadPermission = readPermission;
        //mWritePermission = writePermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.132 -0400", hash_original_method = "385FCFD08A13461BC5260866E3C7CF08", hash_generated_method = "A3A2AC74BEBBE26980FA112552C7ED7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PathPermission(Parcel src) {
        super(src);
        dsTaint.addTaint(src.dsTaint);
        mReadPermission = src.readString();
        mWritePermission = src.readString();
        // ---------- Original Method ----------
        //mReadPermission = src.readString();
        //mWritePermission = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.132 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "A762B9BF7EECC4892591487883677204")
    @DSModeled(DSC.SAFE)
    public String getReadPermission() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mReadPermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.133 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "F1D384BC6F345E53858DE0AE28C2B704")
    @DSModeled(DSC.SAFE)
    public String getWritePermission() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWritePermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.133 -0400", hash_original_method = "A803A7F07F4B7A6BE15492168684C07E", hash_generated_method = "FFF62B18D157AD8BF38A38B8E252F869")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        super.writeToParcel(dest, flags);
        dest.writeString(mReadPermission);
        dest.writeString(mWritePermission);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, flags);
        //dest.writeString(mReadPermission);
        //dest.writeString(mWritePermission);
    }

    
}


