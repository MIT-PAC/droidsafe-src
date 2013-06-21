package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;

public class PathPermission extends PatternMatcher {
    private String mReadPermission;
    private String mWritePermission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.716 -0400", hash_original_method = "79E6B4567C92E932C6F7E4E0D19FFE51", hash_generated_method = "BAE5597F3FD3E1016EE58C9BE545BCCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PathPermission(String pattern, int type, String readPermission,
            String writePermission) {
        super(pattern, type);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //mReadPermission = readPermission;
        //mWritePermission = writePermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.716 -0400", hash_original_method = "385FCFD08A13461BC5260866E3C7CF08", hash_generated_method = "2EDBC9639CE58143F6B77409C2410E1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.716 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "20F31BA46BDBE20CE90A935B7144038F")
    @DSModeled(DSC.SAFE)
    public String getReadPermission() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mReadPermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.717 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "A2D09960EE73568DCD73EE58FF8DA1C2")
    @DSModeled(DSC.SAFE)
    public String getWritePermission() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mWritePermission;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.717 -0400", hash_original_method = "A803A7F07F4B7A6BE15492168684C07E", hash_generated_method = "B53F4598FB1FE9DE965F77FD76DD3327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        super.writeToParcel(dest, flags);
        dest.writeString(mReadPermission);
        dest.writeString(mWritePermission);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, flags);
        //dest.writeString(mReadPermission);
        //dest.writeString(mWritePermission);
    }

    
    public static final Parcelable.Creator<PathPermission> CREATOR = new Parcelable.Creator<PathPermission>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.717 -0400", hash_original_method = "FB68BFC6586F43B368BF10107C1ED83E", hash_generated_method = "264C35734DE598BDE49C9677B6E9993E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PathPermission createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            PathPermission varF0F846C70A3F6F0CBE05AEFFF6A88795_891882070 = (new PathPermission(source));
            return (PathPermission)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PathPermission(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.718 -0400", hash_original_method = "53F8BB5AC790624D851E4D5B8884399B", hash_generated_method = "C0779AFAF6F071B491FDC5DDCB409BB0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PathPermission[] newArray(int size) {
            dsTaint.addTaint(size);
            PathPermission[] varAEDD9D892501321E2785B42DF5F99AE8_1828811337 = (new PathPermission[size]);
            return (PathPermission[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PathPermission[size];
        }

        
}; //Transformed anonymous class
}

