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

public class UnderlineSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.361 -0400", hash_original_method = "0961EBA9EB7C20D52B677528162BDFE2", hash_generated_method = "B870B13607B7A39AABEEC566DC497E8C")
    @DSModeled(DSC.SAFE)
    public UnderlineSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.361 -0400", hash_original_method = "2F10E98AFC8F657229593A567035B72B", hash_generated_method = "352A2673BD067A86ABD357CA0E7B4829")
    @DSModeled(DSC.SAFE)
    public UnderlineSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.361 -0400", hash_original_method = "98FDD0C5C920ADC9B5642E26AAA3CBE6", hash_generated_method = "9795C7A9040CA8630CC67CBA79B2A5B0")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.UNDERLINE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.362 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.362 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "3D9BE3A3714B4F82FD0627A2AF4A91CB")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.362 -0400", hash_original_method = "0AB5A88A5517CF0706AB68CD6097189A", hash_generated_method = "85CF10689535761C137142123C9B6B6D")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setUnderlineText(true);
        // ---------- Original Method ----------
        //ds.setUnderlineText(true);
    }

    
}


