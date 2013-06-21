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

public class ScaleXSpan extends MetricAffectingSpan implements ParcelableSpan {
    private float mProportion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.918 -0400", hash_original_method = "5A8420DEA89D3BA24C51E3449203D410", hash_generated_method = "EA351EC46BCB3D60D8B44022D949309F")
    @DSModeled(DSC.SAFE)
    public ScaleXSpan(float proportion) {
        dsTaint.addTaint(proportion);
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.918 -0400", hash_original_method = "84B8294F7669FCC40D337D5712D24934", hash_generated_method = "2917E67DF6AB12FA51442C0B0A875638")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ScaleXSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.919 -0400", hash_original_method = "305A59DEF4DC94D07B224B5DAB862393", hash_generated_method = "16F977C435D5DC17E5F48D9AC517061A")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SCALE_X_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.919 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.919 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "97924548B786DADC377DD90BA4D73D55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeFloat(mProportion);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.919 -0400", hash_original_method = "EC544E0B7E0BD00BAC5AC8960BBAB7C7", hash_generated_method = "05CACA2E6CD119E144D8918A8DAA47C3")
    @DSModeled(DSC.SAFE)
    public float getScaleX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mProportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.920 -0400", hash_original_method = "E20B555A657035EC86C04FC249B48C55", hash_generated_method = "AE1EE255887D1EE6865C3784412512A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.920 -0400", hash_original_method = "7988BDF035A46DF7E155ADF4B90D7F9B", hash_generated_method = "A989F7AD022F83D4E9A87E4E9A0C9A96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
}

