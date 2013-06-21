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

public class AbsoluteSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    private int mSize;
    private boolean mDip;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.813 -0400", hash_original_method = "9F182F09B08FED6314DBE96ECAD38ABB", hash_generated_method = "C829A67FC4C5909BD19B83861F56B4AC")
    @DSModeled(DSC.SAFE)
    public AbsoluteSizeSpan(int size) {
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //mSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.813 -0400", hash_original_method = "452A1F4FB6807BADBE67E3FEF1703DF6", hash_generated_method = "789907A7C958C40E5A2C211736C391FD")
    @DSModeled(DSC.SAFE)
    public AbsoluteSizeSpan(int size, boolean dip) {
        dsTaint.addTaint(dip);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
        //mSize = size;
        //mDip = dip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.813 -0400", hash_original_method = "11A22A410F4688830BCA693D188465D5", hash_generated_method = "0AE0881679C54214B1B529FFEDB3232C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbsoluteSizeSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mSize = src.readInt();
        mDip = src.readInt() != 0;
        // ---------- Original Method ----------
        //mSize = src.readInt();
        //mDip = src.readInt() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.814 -0400", hash_original_method = "8ECE4916687DC9B660DB4531FCB16044", hash_generated_method = "F797C0FB86933CB1CFBA64B845A4245C")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.ABSOLUTE_SIZE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.814 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.814 -0400", hash_original_method = "8027C06709F3FF60199965EEE92D48C7", hash_generated_method = "27F5CF65FB812AF6D0BBDA59A186D0F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mSize);
        dest.writeInt(mDip ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSize);
        //dest.writeInt(mDip ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.814 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "207A3638E898A3E1BCC3A8ED35B62B90")
    @DSModeled(DSC.SAFE)
    public int getSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.814 -0400", hash_original_method = "E1A5B960016F06729A9EBA9A98D5F008", hash_generated_method = "37596A157F4716AEA16E1794DCDE28D4")
    @DSModeled(DSC.SAFE)
    public boolean getDip() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.815 -0400", hash_original_method = "EA2263AF61F8EA4B1854731646B3D093", hash_generated_method = "0D1EE3696AC66FEFFBF1D40FB68F022A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.815 -0400", hash_original_method = "1F6CC548E4C5BF47656F78351153B803", hash_generated_method = "738C0A99E8716680C51EC593BAC67565")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

