package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;
import android.widget.TextView;

public class EasyEditSpan implements ParcelableSpan {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.176 -0400", hash_original_method = "A230929293AFFCA631493D5E514D429F", hash_generated_method = "30C43FC9D033188B5BCE7C639844F2F1")
    public  EasyEditSpan() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.177 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DF3C1CA5E79303D94F4C742D0AB74276")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_220666361 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825369105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825369105;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.177 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "7434FF73057D7851F1B1D87D94FFF3D5")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.177 -0400", hash_original_method = "B70B692D38FEF311001170F890E9CCAE", hash_generated_method = "97F1B302AF8C9196994669B1E5816F38")
    @Override
    public int getSpanTypeId() {
        int varC884AAB69FE03F39DD13BC8983FA4E84_953962231 = (TextUtils.EASY_EDIT_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223319910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223319910;
        // ---------- Original Method ----------
        //return TextUtils.EASY_EDIT_SPAN;
    }

    
}

