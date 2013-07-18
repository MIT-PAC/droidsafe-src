package android.text.style;

// Droidsafe Imports
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SuggestionRangeSpan extends CharacterStyle implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.151 -0400", hash_original_field = "F28F2DF30FA0A384EA442393DFFC03BB", hash_generated_field = "CC64588E1E08B8E0993874A8A69D251D")

    private int mBackgroundColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.151 -0400", hash_original_method = "BE3451A654F6E9FD9B583E5F598309FD", hash_generated_method = "3DDFC0E11D5F7709FC0BC9167F9698B2")
    public  SuggestionRangeSpan() {
        mBackgroundColor = 0;
        // ---------- Original Method ----------
        //mBackgroundColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.152 -0400", hash_original_method = "C19BD23169B457337D3E2C544633849E", hash_generated_method = "4C2C2E3ED2D787E1EE455D3C2928ACB7")
    public  SuggestionRangeSpan(Parcel src) {
        mBackgroundColor = src.readInt();
        // ---------- Original Method ----------
        //mBackgroundColor = src.readInt();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.152 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "55FDC437DC5A444C27125533E93E4950")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_40455986 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008057051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008057051;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.152 -0400", hash_original_method = "2D196358A51E993023DA9656E12C24CE", hash_generated_method = "94932DE2D690D0DD467BEBF42724FEBC")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mBackgroundColor);
        // ---------- Original Method ----------
        //dest.writeInt(mBackgroundColor);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.153 -0400", hash_original_method = "C317BC4F0E850D3D8EACD128701AD14B", hash_generated_method = "268977E963FC1DE91B3D5D2311337BF7")
    @Override
    public int getSpanTypeId() {
        int var957E460B1AD03C6B97E81D65008028EF_1722945599 = (TextUtils.SUGGESTION_RANGE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635117469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635117469;
        // ---------- Original Method ----------
        //return TextUtils.SUGGESTION_RANGE_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.153 -0400", hash_original_method = "E6A11EC9B3E2DA21777E259CEAE43825", hash_generated_method = "C1EDFD39139B52FAB44D8473BFF01E1A")
    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
        // ---------- Original Method ----------
        //mBackgroundColor = backgroundColor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.153 -0400", hash_original_method = "DC157379F92590C2B130D316844D8B74", hash_generated_method = "D9B2C529838BFD3E2CD1211E4608BF4D")
    @Override
    public void updateDrawState(TextPaint tp) {
        addTaint(tp.getTaint());
        tp.bgColor = mBackgroundColor;
        // ---------- Original Method ----------
        //tp.bgColor = mBackgroundColor;
    }

    
}

