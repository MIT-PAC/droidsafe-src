package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class SuggestionRangeSpan extends CharacterStyle implements ParcelableSpan {
    private int mBackgroundColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.319 -0400", hash_original_method = "BE3451A654F6E9FD9B583E5F598309FD", hash_generated_method = "A9F5E8C4527265DED8828E8351A9F055")
    @DSModeled(DSC.SAFE)
    public SuggestionRangeSpan() {
        mBackgroundColor = 0;
        // ---------- Original Method ----------
        //mBackgroundColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.319 -0400", hash_original_method = "C19BD23169B457337D3E2C544633849E", hash_generated_method = "DA69BFB56B7D11FED808CAA355D7DF53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuggestionRangeSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mBackgroundColor = src.readInt();
        // ---------- Original Method ----------
        //mBackgroundColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.319 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.319 -0400", hash_original_method = "2D196358A51E993023DA9656E12C24CE", hash_generated_method = "3384F4D77F9B11CA50B21E890C7DA450")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mBackgroundColor);
        // ---------- Original Method ----------
        //dest.writeInt(mBackgroundColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.320 -0400", hash_original_method = "C317BC4F0E850D3D8EACD128701AD14B", hash_generated_method = "F14C79A2E7159D2C705084D6D4D2938F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SUGGESTION_RANGE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.320 -0400", hash_original_method = "E6A11EC9B3E2DA21777E259CEAE43825", hash_generated_method = "0B1E2526D59517758CCE540A4AECA10A")
    @DSModeled(DSC.SAFE)
    public void setBackgroundColor(int backgroundColor) {
        dsTaint.addTaint(backgroundColor);
        // ---------- Original Method ----------
        //mBackgroundColor = backgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.320 -0400", hash_original_method = "DC157379F92590C2B130D316844D8B74", hash_generated_method = "C6815906ADE601901628E6500EC880D5")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        tp.bgColor = mBackgroundColor;
        // ---------- Original Method ----------
        //tp.bgColor = mBackgroundColor;
    }

    
}


