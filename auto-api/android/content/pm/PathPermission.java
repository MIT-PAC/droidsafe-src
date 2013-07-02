package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;

public class PathPermission extends PatternMatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.808 -0400", hash_original_field = "3805826D63CBE0EFB018A286F189CC44", hash_generated_field = "F91CBC541AE5EA168107190D1A494CD8")

    private String mReadPermission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.808 -0400", hash_original_field = "EA3BA31BE3E977A5CA4A690ADA101637", hash_generated_field = "02101D3B9ECFAAEB0689EF2DAEF4A808")

    private String mWritePermission;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.809 -0400", hash_original_method = "79E6B4567C92E932C6F7E4E0D19FFE51", hash_generated_method = "7B2AAAE0C79BCAC81171896ABFB8C04B")
    public  PathPermission(String pattern, int type, String readPermission,
            String writePermission) {
        super(pattern, type);
        mReadPermission = readPermission;
        mWritePermission = writePermission;
        addTaint(pattern.getTaint());
        addTaint(type);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.809 -0400", hash_original_method = "385FCFD08A13461BC5260866E3C7CF08", hash_generated_method = "2CFA3C43C9AE7BF1B7EC3DE937629DFA")
    public  PathPermission(Parcel src) {
        super(src);
        mReadPermission = src.readString();
        mWritePermission = src.readString();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.810 -0400", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "0DAF6CCE6B23C8899D3B527A176C6422")
    public String getReadPermission() {
        String varB4EAC82CA7396A68D541C85D26508E83_14313277 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_14313277 = mReadPermission;
        varB4EAC82CA7396A68D541C85D26508E83_14313277.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_14313277;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.811 -0400", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "E7A20165DD87389976C1D8557F80481C")
    public String getWritePermission() {
        String varB4EAC82CA7396A68D541C85D26508E83_1857978498 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1857978498 = mWritePermission;
        varB4EAC82CA7396A68D541C85D26508E83_1857978498.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1857978498;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.812 -0400", hash_original_method = "A803A7F07F4B7A6BE15492168684C07E", hash_generated_method = "F1C24807E2269AD76A15750144754D03")
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(mReadPermission);
        dest.writeString(mWritePermission);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.812 -0400", hash_original_field = "BF769DDFB95FE3C86E626C9171120430", hash_generated_field = "B147657571B9F640821DBBF9A7AC44F7")

    public static final Parcelable.Creator<PathPermission> CREATOR
            = new Parcelable.Creator<PathPermission>() {
        public PathPermission createFromParcel(Parcel source) {
            return new PathPermission(source);
        }

        public PathPermission[] newArray(int size) {
            return new PathPermission[size];
        }
    };
    
    public PathPermission createFromParcel(Parcel source) {
            return new PathPermission(source);
        }
    
    
    public PathPermission[] newArray(int size) {
            return new PathPermission[size];
        }
    
}

