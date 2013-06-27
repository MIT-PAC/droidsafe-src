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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.850 -0400", hash_original_field = "5B484EED7F441408FBB3DA9CD489795B", hash_generated_field = "F3DE0713F398F5B7918E6C35C0AAE054")

    private float mProportion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.857 -0400", hash_original_method = "5A8420DEA89D3BA24C51E3449203D410", hash_generated_method = "07EA7FB4A78397A0402CFA97CFD413F0")
    public  ScaleXSpan(float proportion) {
        mProportion = proportion;
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.858 -0400", hash_original_method = "84B8294F7669FCC40D337D5712D24934", hash_generated_method = "6A0BF93ECB06D20C8DD707C448ED318A")
    public  ScaleXSpan(Parcel src) {
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.981 -0400", hash_original_method = "305A59DEF4DC94D07B224B5DAB862393", hash_generated_method = "C036B06736A695716B7D102DB5C54A2C")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544774688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544774688;
        // ---------- Original Method ----------
        //return TextUtils.SCALE_X_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.981 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2B007D8CF733547012B7DF5BE1809F1C")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561834413 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561834413;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.982 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "C2C298C420AE56AA07A619B100DBDBD3")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(mProportion);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.983 -0400", hash_original_method = "EC544E0B7E0BD00BAC5AC8960BBAB7C7", hash_generated_method = "BB77B8449E3A198A2D39402CC50A8358")
    public float getScaleX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1968662578 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1968662578;
        // ---------- Original Method ----------
        //return mProportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.988 -0400", hash_original_method = "E20B555A657035EC86C04FC249B48C55", hash_generated_method = "5A84D9E60174F1A20E98CED094E6C361")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.990 -0400", hash_original_method = "7988BDF035A46DF7E155ADF4B90D7F9B", hash_generated_method = "C6603EBC47F573F3A8D403131C444302")
    @Override
    public void updateMeasureState(TextPaint ds) {
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
}

