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

public class SuggestionRangeSpan extends CharacterStyle implements ParcelableSpan {
    private int mBackgroundColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.943 -0400", hash_original_method = "BE3451A654F6E9FD9B583E5F598309FD", hash_generated_method = "3DDFC0E11D5F7709FC0BC9167F9698B2")
    @DSModeled(DSC.SAFE)
    public SuggestionRangeSpan() {
        mBackgroundColor = 0;
        // ---------- Original Method ----------
        //mBackgroundColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.949 -0400", hash_original_method = "C19BD23169B457337D3E2C544633849E", hash_generated_method = "56474B72E3755601534E2D26231B0CAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionRangeSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mBackgroundColor = src.readInt();
        // ---------- Original Method ----------
        //mBackgroundColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.950 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.950 -0400", hash_original_method = "2D196358A51E993023DA9656E12C24CE", hash_generated_method = "6BFDC4FAE08210A40365CB1765082F4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mBackgroundColor);
        // ---------- Original Method ----------
        //dest.writeInt(mBackgroundColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.950 -0400", hash_original_method = "C317BC4F0E850D3D8EACD128701AD14B", hash_generated_method = "A1A3FFBCACC91A84DD6590B04B101DE6")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUGGESTION_RANGE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.950 -0400", hash_original_method = "E6A11EC9B3E2DA21777E259CEAE43825", hash_generated_method = "29F2C5CB58A5DB062E26BCA698AAFF05")
    @DSModeled(DSC.SAFE)
    public void setBackgroundColor(int backgroundColor) {
        dsTaint.addTaint(backgroundColor);
        // ---------- Original Method ----------
        //mBackgroundColor = backgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.950 -0400", hash_original_method = "DC157379F92590C2B130D316844D8B74", hash_generated_method = "897BA5DD0D3EBBE94F57BE33D33A56DA")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.bgColor = mBackgroundColor;
        // ---------- Original Method ----------
        //tp.bgColor = mBackgroundColor;
    }

    
}

