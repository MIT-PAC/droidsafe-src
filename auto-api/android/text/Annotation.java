package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;

public class Annotation implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.233 -0400", hash_original_field = "7E690C9CC141370A5EC6E7A98DC6FF62", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.233 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private String mValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.246 -0400", hash_original_method = "5C517E50CA4FB031ECF94CDBC8F3DBD0", hash_generated_method = "D01E642451DA9153C6330C1E5A2AA584")
    public  Annotation(String key, String value) {
        mKey = key;
        mValue = value;
        // ---------- Original Method ----------
        //mKey = key;
        //mValue = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.246 -0400", hash_original_method = "C131D9D20BBD02754AB0621772B33421", hash_generated_method = "26B358E42EFE096E6E83C377C90A9476")
    public  Annotation(Parcel src) {
        mKey = src.readString();
        mValue = src.readString();
        // ---------- Original Method ----------
        //mKey = src.readString();
        //mValue = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.262 -0400", hash_original_method = "4B5D387D9B07EBC2B6CC4E1F3474D3AE", hash_generated_method = "54776E600B4579F01E80F1EB5F2FE178")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849572920 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849572920;
        // ---------- Original Method ----------
        //return TextUtils.ANNOTATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.265 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1D262BC7BD18419E85D83F1D28021C8A")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832644528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832644528;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.266 -0400", hash_original_method = "5E98CA8EC4399E1C3E6F7EE2C72DE36F", hash_generated_method = "050C587251250F58D52303A17D41175F")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mKey);
        dest.writeString(mValue);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(mKey);
        //dest.writeString(mValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.267 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "78757E03EE052749908234F39C6ED217")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_674302862 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_674302862 = mKey;
        varB4EAC82CA7396A68D541C85D26508E83_674302862.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_674302862;
        // ---------- Original Method ----------
        //return mKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:38.268 -0400", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "45C4DC72E7134EB7B7A9790D473E0283")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_894465463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_894465463 = mValue;
        varB4EAC82CA7396A68D541C85D26508E83_894465463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894465463;
        // ---------- Original Method ----------
        //return mValue;
    }

    
}

