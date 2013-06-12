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

public class AbsoluteSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    private final int mSize;
    private boolean mDip;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.292 -0400", hash_original_method = "9F182F09B08FED6314DBE96ECAD38ABB", hash_generated_method = "4033D79EAB67B23B94401AA1168889C7")
    @DSModeled(DSC.SAFE)
    public AbsoluteSizeSpan(int size) {
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //mSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.292 -0400", hash_original_method = "452A1F4FB6807BADBE67E3FEF1703DF6", hash_generated_method = "E532A7F2C98179E6572C258BBE3CE413")
    @DSModeled(DSC.SAFE)
    public AbsoluteSizeSpan(int size, boolean dip) {
        dsTaint.addTaint(dip);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //mSize = size;
        //mDip = dip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.292 -0400", hash_original_method = "11A22A410F4688830BCA693D188465D5", hash_generated_method = "D395C4361DEF46BF26F49954D58E0959")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteSizeSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mSize = src.readInt();
        mDip = src.readInt() != 0;
        // ---------- Original Method ----------
        //mSize = src.readInt();
        //mDip = src.readInt() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.292 -0400", hash_original_method = "8ECE4916687DC9B660DB4531FCB16044", hash_generated_method = "BF17A89AEF4B3A6A804CA6A0725328DA")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.ABSOLUTE_SIZE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.292 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.292 -0400", hash_original_method = "8027C06709F3FF60199965EEE92D48C7", hash_generated_method = "B3F55B07A927CD46487071B2F37C1F47")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mSize);
        dest.writeInt(mDip ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSize);
        //dest.writeInt(mDip ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.293 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "DBFFD0F952E77AFBB9389794A17CF659")
    @DSModeled(DSC.SAFE)
    public int getSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.293 -0400", hash_original_method = "E1A5B960016F06729A9EBA9A98D5F008", hash_generated_method = "2A3FD5848DC94F4931E119B3629C03FE")
    @DSModeled(DSC.SAFE)
    public boolean getDip() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.293 -0400", hash_original_method = "EA2263AF61F8EA4B1854731646B3D093", hash_generated_method = "D2AEF072850B12B993D9941B966CD07E")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        {
            ds.setTextSize(mSize * ds.density);
        } //End block
        {
            ds.setTextSize(mSize);
        } //End block
        // ---------- Original Method ----------
        //if (mDip) {
            //ds.setTextSize(mSize * ds.density);
        //} else {
            //ds.setTextSize(mSize);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.293 -0400", hash_original_method = "1F6CC548E4C5BF47656F78351153B803", hash_generated_method = "06B185A858EA8CC7589F621E334D7220")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateMeasureState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        {
            ds.setTextSize(mSize * ds.density);
        } //End block
        {
            ds.setTextSize(mSize);
        } //End block
        // ---------- Original Method ----------
        //if (mDip) {
            //ds.setTextSize(mSize * ds.density);
        //} else {
            //ds.setTextSize(mSize);
        //}
    }

    
}


