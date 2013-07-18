package android.text.style;

// Droidsafe Imports
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class EasyEditSpan implements ParcelableSpan {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.984 -0400", hash_original_method = "A230929293AFFCA631493D5E514D429F", hash_generated_method = "30C43FC9D033188B5BCE7C639844F2F1")
    public  EasyEditSpan() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.985 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F72E79A4B4D5CAF5D5551DB1AD46291D")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1784929274 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145652327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145652327;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.985 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "7434FF73057D7851F1B1D87D94FFF3D5")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.986 -0400", hash_original_method = "B70B692D38FEF311001170F890E9CCAE", hash_generated_method = "0A28395F69112EAF2A30780BA128DE57")
    @Override
    public int getSpanTypeId() {
        int varC884AAB69FE03F39DD13BC8983FA4E84_885412363 = (TextUtils.EASY_EDIT_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086071205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086071205;
        // ---------- Original Method ----------
        //return TextUtils.EASY_EDIT_SPAN;
    }

    
}

