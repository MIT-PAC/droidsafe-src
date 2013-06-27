package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class ForegroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.624 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.630 -0400", hash_original_method = "CCAF801A87F70F53C246D8BAD4668254", hash_generated_method = "91483188A00DC05189FE5D6D1699D52B")
    public  ForegroundColorSpan(int color) {
        mColor = color;
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.631 -0400", hash_original_method = "C1959654A903860C71D5E98AD17C38DB", hash_generated_method = "1D056DE5D0944B8683CDFCC48DB97D3F")
    public  ForegroundColorSpan(Parcel src) {
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.631 -0400", hash_original_method = "8155995CA89F113B2E7BEC17CF09D49D", hash_generated_method = "3456A4CF68C069DB4A3F2EA507394C4F")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029499580 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029499580;
        // ---------- Original Method ----------
        //return TextUtils.FOREGROUND_COLOR_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.632 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C617B5E1F40162D67ED3842F0EB66431")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829801362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829801362;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.632 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "4434B22B71E34F3AE6C4E59891B471B8")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.632 -0400", hash_original_method = "7DE99734F4F039B37C58D21552D08DBC", hash_generated_method = "818CC6B0DE4618BB794A04B854A9E2B5")
    public int getForegroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800436168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800436168;
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.632 -0400", hash_original_method = "119B8D3BB9F53DFAB442699FA205FF8F", hash_generated_method = "2F1C2E8F6B8BD6A6D6757FC91916A06D")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(mColor);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.setColor(mColor);
    }

    
}

