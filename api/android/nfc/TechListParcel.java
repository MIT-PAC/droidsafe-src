package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class TechListParcel implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.777 -0400", hash_original_field = "65E8F261CDFB5B09FDC146D238F5202C", hash_generated_field = "C36B9D5CB222403FE3E00F43AA3D1F77")

    private String[][] mTechLists;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.778 -0400", hash_original_method = "6AB5FDB623A6EE108E2E4847F2947558", hash_generated_method = "29ED8984ECDC1B919999AD1AE8CACA72")
    public  TechListParcel(String[]... strings) {
        mTechLists = strings;
        // ---------- Original Method ----------
        //mTechLists = strings;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.778 -0400", hash_original_method = "6EF67533858F398D5EC0425F1D475F89", hash_generated_method = "AC8DB8CDE1C2FC5EFD31303A56D5B56C")
    public String[][] getTechLists() {
String[][] var56AA0989E3CC6CA3FAE900904C158736_168993499 =         mTechLists;
        var56AA0989E3CC6CA3FAE900904C158736_168993499.addTaint(taint);
        return var56AA0989E3CC6CA3FAE900904C158736_168993499;
        // ---------- Original Method ----------
        //return mTechLists;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.779 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F39F6D7560C3618581D5E90E25932665")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1892772330 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24644026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24644026;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.779 -0400", hash_original_method = "B19E49B45A2ACFBF18675BF33A9FB41F", hash_generated_method = "C7AD5E61CF40D85AB54C8170AEFE0267")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        int count = mTechLists.length;
        dest.writeInt(count);
for(int i = 0;i < count;i++)
        {
            String[] techList = mTechLists[i];
            dest.writeStringArray(techList);
        } //End block
        // ---------- Original Method ----------
        //int count = mTechLists.length;
        //dest.writeInt(count);
        //for (int i = 0; i < count; i++) {
            //String[] techList = mTechLists[i];
            //dest.writeStringArray(techList);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.779 -0400", hash_original_field = "3EF1D37F275B16491C644A6C6C17DFAE", hash_generated_field = "26E56EC2A9AB9ADBEAAD9C9C0A9E8ECF")

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
}

