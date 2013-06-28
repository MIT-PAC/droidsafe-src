package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class TechListParcel implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.266 -0400", hash_original_field = "65E8F261CDFB5B09FDC146D238F5202C", hash_generated_field = "C36B9D5CB222403FE3E00F43AA3D1F77")

    private String[][] mTechLists;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.267 -0400", hash_original_method = "6AB5FDB623A6EE108E2E4847F2947558", hash_generated_method = "29ED8984ECDC1B919999AD1AE8CACA72")
    public  TechListParcel(String[]... strings) {
        mTechLists = strings;
        // ---------- Original Method ----------
        //mTechLists = strings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.267 -0400", hash_original_method = "6EF67533858F398D5EC0425F1D475F89", hash_generated_method = "AE4EDA506435CF0047C3E77FF008A59D")
    public String[][] getTechLists() {
        String[][] varB4EAC82CA7396A68D541C85D26508E83_1997914361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1997914361 = mTechLists;
        varB4EAC82CA7396A68D541C85D26508E83_1997914361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1997914361;
        // ---------- Original Method ----------
        //return mTechLists;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.268 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F1B7540030A37B11A43D3DB75C741E68")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88733940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88733940;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.268 -0400", hash_original_method = "B19E49B45A2ACFBF18675BF33A9FB41F", hash_generated_method = "5131CA29C431B28CD575758AE389F757")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        int count = mTechLists.length;
        dest.writeInt(count);
        {
            int i = 0;
            {
                String[] techList = mTechLists[i];
                dest.writeStringArray(techList);
            } //End block
        } //End collapsed parenthetic
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //int count = mTechLists.length;
        //dest.writeInt(count);
        //for (int i = 0; i < count; i++) {
            //String[] techList = mTechLists[i];
            //dest.writeStringArray(techList);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.268 -0400", hash_original_field = "3EF1D37F275B16491C644A6C6C17DFAE", hash_generated_field = "26E56EC2A9AB9ADBEAAD9C9C0A9E8ECF")

    public static final Creator<TechListParcel> CREATOR = new Creator<TechListParcel>() {
        @Override
        public TechListParcel createFromParcel(Parcel source) {
            int count = source.readInt();
            String[][] techLists = new String[count][];
            for (int i = 0; i < count; i++) {
                techLists[i] = source.readStringArray();
            }
            return new TechListParcel(techLists);
        }

        @Override
        public TechListParcel[] newArray(int size) {
            return new TechListParcel[size];
        }
    };
    // orphaned legacy method
    @Override
        public TechListParcel createFromParcel(Parcel source) {
            int count = source.readInt();
            String[][] techLists = new String[count][];
            for (int i = 0; i < count; i++) {
                techLists[i] = source.readStringArray();
            }
            return new TechListParcel(techLists);
        }
    
    // orphaned legacy method
    @Override
        public TechListParcel[] newArray(int size) {
            return new TechListParcel[size];
        }
    
}

