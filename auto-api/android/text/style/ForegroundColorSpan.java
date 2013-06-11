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

public class ForegroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    private final int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.303 -0400", hash_original_method = "CCAF801A87F70F53C246D8BAD4668254", hash_generated_method = "A880820899CB2F35166BD3F7428C5C2B")
    @DSModeled(DSC.SAFE)
    public ForegroundColorSpan(int color) {
        dsTaint.addTaint(color);
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.303 -0400", hash_original_method = "C1959654A903860C71D5E98AD17C38DB", hash_generated_method = "B5B3D3A4089B531E4E27494DBA0E9BFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ForegroundColorSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.303 -0400", hash_original_method = "8155995CA89F113B2E7BEC17CF09D49D", hash_generated_method = "E927C95EDD3D61E1B4AC3A9C1FE3D11E")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.FOREGROUND_COLOR_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.303 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.303 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "8814D1F6A449877E0272DD2313D0AEC6")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.303 -0400", hash_original_method = "7DE99734F4F039B37C58D21552D08DBC", hash_generated_method = "C8B09BBDE7DCB6D86D29C158812C2597")
    @DSModeled(DSC.SAFE)
    public int getForegroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.303 -0400", hash_original_method = "119B8D3BB9F53DFAB442699FA205FF8F", hash_generated_method = "20600DD7B4A265CB523871395F7C2151")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setColor(mColor);
        // ---------- Original Method ----------
        //ds.setColor(mColor);
    }

    
}


