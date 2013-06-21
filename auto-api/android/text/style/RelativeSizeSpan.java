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

public class RelativeSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    private float mProportion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.904 -0400", hash_original_method = "A7FADA85249F1B8943B2C3745C9AD73C", hash_generated_method = "E0C6B3750CF20313EAAEC1A98701CDCC")
    @DSModeled(DSC.SAFE)
    public RelativeSizeSpan(float proportion) {
        dsTaint.addTaint(proportion);
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.904 -0400", hash_original_method = "3E1E83FB4F6546C2007DF6E3D1177212", hash_generated_method = "E5A6305C827F8B42980A69E0C9743FCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RelativeSizeSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.904 -0400", hash_original_method = "D2254CF1E8362BBCA36C2E8295131004", hash_generated_method = "608F505DC6C738B7B0B7BE11F3F0C613")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.RELATIVE_SIZE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.904 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.904 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "97924548B786DADC377DD90BA4D73D55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeFloat(mProportion);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.905 -0400", hash_original_method = "E89C4B67E9A9CE5F6854A6F0C8388FE6", hash_generated_method = "2ACE2991598B582A566F415868849EFE")
    @DSModeled(DSC.SAFE)
    public float getSizeChange() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mProportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.908 -0400", hash_original_method = "D87A5BB37ACAA736C762D797F93AD23D", hash_generated_method = "4FFC2390B6EF1BEFE64D78587CAE9328")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextSize(ds.getTextSize() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.908 -0400", hash_original_method = "B20FAC1EC83BD8EFC8CAF1EE401E0C1F", hash_generated_method = "F684F0305907A078B522DE63BC969492")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextSize(ds.getTextSize() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
}

