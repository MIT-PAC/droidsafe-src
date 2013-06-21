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

public class BackgroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.819 -0400", hash_original_method = "1BABE23E25570DA2EF62C4506697834B", hash_generated_method = "A9B68E35088FF6AA6F147E65CE222501")
    @DSModeled(DSC.SAFE)
    public BackgroundColorSpan(int color) {
        dsTaint.addTaint(color);
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.819 -0400", hash_original_method = "71157ECE822D307A1BD642C08548B0D3", hash_generated_method = "A414A18A41DC2707EF718A3F22595558")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackgroundColorSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.820 -0400", hash_original_method = "D24F62EA631AC1AF936FF48E9134FC5B", hash_generated_method = "B5563758418BA23F9C4B447B47C706A7")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.BACKGROUND_COLOR_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.820 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.820 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "DAA3747B1D479B36DA20B141F586B8AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.820 -0400", hash_original_method = "C57B18EE451723AD85B8F6926D247DF6", hash_generated_method = "528F222F0A4D73F6871335DBCC364684")
    @DSModeled(DSC.SAFE)
    public int getBackgroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.820 -0400", hash_original_method = "7B660C1B12B91C1F1E71953191ED601F", hash_generated_method = "D37B08F252975CE02E58CF269EE46CAF")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.bgColor = mColor;
        // ---------- Original Method ----------
        //ds.bgColor = mColor;
    }

    
}

