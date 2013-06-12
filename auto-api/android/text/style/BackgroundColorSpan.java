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

public class BackgroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    private final int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.295 -0400", hash_original_method = "1BABE23E25570DA2EF62C4506697834B", hash_generated_method = "0D763C5DAA820F922B45B49001DA5502")
    @DSModeled(DSC.SAFE)
    public BackgroundColorSpan(int color) {
        dsTaint.addTaint(color);
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.295 -0400", hash_original_method = "71157ECE822D307A1BD642C08548B0D3", hash_generated_method = "2D4363DF243C31A75EEC65F3F0D66B6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackgroundColorSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.295 -0400", hash_original_method = "D24F62EA631AC1AF936FF48E9134FC5B", hash_generated_method = "FC96235878AFF4F6C24B8D3676AC591C")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.BACKGROUND_COLOR_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.296 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.296 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "8814D1F6A449877E0272DD2313D0AEC6")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.296 -0400", hash_original_method = "C57B18EE451723AD85B8F6926D247DF6", hash_generated_method = "D43B5A66EF42CC98DF1BB4E7195604B0")
    @DSModeled(DSC.SAFE)
    public int getBackgroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.296 -0400", hash_original_method = "7B660C1B12B91C1F1E71953191ED601F", hash_generated_method = "DC9FFCA1C5A45CF7DAB2990726A28ED3")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.bgColor = mColor;
        // ---------- Original Method ----------
        //ds.bgColor = mColor;
    }

    
}


