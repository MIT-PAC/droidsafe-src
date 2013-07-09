package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;

public class Annotation implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.490 -0400", hash_original_field = "7E690C9CC141370A5EC6E7A98DC6FF62", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.490 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private String mValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.490 -0400", hash_original_method = "5C517E50CA4FB031ECF94CDBC8F3DBD0", hash_generated_method = "D01E642451DA9153C6330C1E5A2AA584")
    public  Annotation(String key, String value) {
        mKey = key;
        mValue = value;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.490 -0400", hash_original_method = "C131D9D20BBD02754AB0621772B33421", hash_generated_method = "26B358E42EFE096E6E83C377C90A9476")
    public  Annotation(Parcel src) {
        mKey = src.readString();
        mValue = src.readString();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.491 -0400", hash_original_method = "4B5D387D9B07EBC2B6CC4E1F3474D3AE", hash_generated_method = "19660273B6A52CDB66D00C97653C687C")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1035921873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1035921873;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.491 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B12C75F2EEDFF1A0A3D580EEC49DF895")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052589213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052589213;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.491 -0400", hash_original_method = "5E98CA8EC4399E1C3E6F7EE2C72DE36F", hash_generated_method = "050C587251250F58D52303A17D41175F")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mKey);
        dest.writeString(mValue);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.492 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "35F1BA94969B9742D79EE6BEE319442C")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1550153472 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1550153472 = mKey;
        varB4EAC82CA7396A68D541C85D26508E83_1550153472.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1550153472;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.493 -0400", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "E6D7CB48D260B2C9D2FFD5CBCDA37A55")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_617250636 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_617250636 = mValue;
        varB4EAC82CA7396A68D541C85D26508E83_617250636.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_617250636;
        
        
    }

    
}

