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

public class ScaleXSpan extends MetricAffectingSpan implements ParcelableSpan {
    private final float mProportion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "5A8420DEA89D3BA24C51E3449203D410", hash_generated_method = "76083B49FBA762C9117FB7639D7B54BE")
    @DSModeled(DSC.SAFE)
    public ScaleXSpan(float proportion) {
        dsTaint.addTaint(proportion);
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "84B8294F7669FCC40D337D5712D24934", hash_generated_method = "B5617D5C8CD6F04AEB32E05C10F916C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScaleXSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "305A59DEF4DC94D07B224B5DAB862393", hash_generated_method = "34EF9EE8E3886805165C6D214386566D")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SCALE_X_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "6C77D81947D60E58B922710733852F9A")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeFloat(mProportion);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "EC544E0B7E0BD00BAC5AC8960BBAB7C7", hash_generated_method = "C4F3889515A802EF670286D3B686C736")
    @DSModeled(DSC.SAFE)
    public float getScaleX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mProportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "E20B555A657035EC86C04FC249B48C55", hash_generated_method = "EB652121C015EA5676B13CE14FB02B86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.312 -0400", hash_original_method = "7988BDF035A46DF7E155ADF4B90D7F9B", hash_generated_method = "AA47B8F3F54CB080B6D46B72A53AFDC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
}


