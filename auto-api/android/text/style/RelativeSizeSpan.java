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

public class RelativeSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    private final float mProportion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "A7FADA85249F1B8943B2C3745C9AD73C", hash_generated_method = "446014CF0231AF41EDF5E5A45E917631")
    @DSModeled(DSC.SAFE)
    public RelativeSizeSpan(float proportion) {
        dsTaint.addTaint(proportion);
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "3E1E83FB4F6546C2007DF6E3D1177212", hash_generated_method = "5DB722B55FE3AA0795695296FB14A7C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RelativeSizeSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "D2254CF1E8362BBCA36C2E8295131004", hash_generated_method = "10252252693C98A5EFCA8B99D9DE96DB")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.RELATIVE_SIZE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "6C77D81947D60E58B922710733852F9A")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeFloat(mProportion);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "E89C4B67E9A9CE5F6854A6F0C8388FE6", hash_generated_method = "6FCC79EF57427FE436AA0D1D171FA75A")
    @DSModeled(DSC.SAFE)
    public float getSizeChange() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mProportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "D87A5BB37ACAA736C762D797F93AD23D", hash_generated_method = "4C76DB67322926811C30B85A7DA5CFCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextSize(ds.getTextSize() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.310 -0400", hash_original_method = "B20FAC1EC83BD8EFC8CAF1EE401E0C1F", hash_generated_method = "6262144ADC7F08426DE75B8AF539B1F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateMeasureState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setTextSize(ds.getTextSize() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
}


