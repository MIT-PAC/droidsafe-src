package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class SuggestionRangeSpan extends CharacterStyle implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.595 -0500", hash_original_field = "9413B7CAD54A5CFB690F08E0547B483E", hash_generated_field = "CC64588E1E08B8E0993874A8A69D251D")

    private int mBackgroundColor;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.598 -0500", hash_original_method = "BE3451A654F6E9FD9B583E5F598309FD", hash_generated_method = "B973EA819EA16286EAAE8A0719DFF0FB")
    
public SuggestionRangeSpan() {
        // 0 is a fully transparent black. Has to be set using #setBackgroundColor
        mBackgroundColor = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.601 -0500", hash_original_method = "C19BD23169B457337D3E2C544633849E", hash_generated_method = "A6A3F3C10F6A654F90CA212F2F376F73")
    
public SuggestionRangeSpan(Parcel src) {
        mBackgroundColor = src.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.603 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.606 -0500", hash_original_method = "2D196358A51E993023DA9656E12C24CE", hash_generated_method = "D610F7570041B4E85AB5A37A072B8B2D")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mBackgroundColor);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.609 -0500", hash_original_method = "C317BC4F0E850D3D8EACD128701AD14B", hash_generated_method = "30B28F1C3E21EAB670C42B16DFC6F4C0")
    
@Override
    public int getSpanTypeId() {
        return TextUtils.SUGGESTION_RANGE_SPAN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.611 -0500", hash_original_method = "E6A11EC9B3E2DA21777E259CEAE43825", hash_generated_method = "93F908A8FEA2FE61395CD9C1531DD807")
    
public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:09.614 -0500", hash_original_method = "DC157379F92590C2B130D316844D8B74", hash_generated_method = "C76719BC0F422DE732DDF03D89FF82BB")
    
@Override
    public void updateDrawState(TextPaint tp) {
        tp.bgColor = mBackgroundColor;
    }
    
}

