package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class ScaleXSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.868 -0400", hash_original_field = "5B484EED7F441408FBB3DA9CD489795B", hash_generated_field = "F3DE0713F398F5B7918E6C35C0AAE054")

    private float mProportion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.868 -0400", hash_original_method = "5A8420DEA89D3BA24C51E3449203D410", hash_generated_method = "07EA7FB4A78397A0402CFA97CFD413F0")
    public  ScaleXSpan(float proportion) {
        mProportion = proportion;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.868 -0400", hash_original_method = "84B8294F7669FCC40D337D5712D24934", hash_generated_method = "6A0BF93ECB06D20C8DD707C448ED318A")
    public  ScaleXSpan(Parcel src) {
        mProportion = src.readFloat();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.869 -0400", hash_original_method = "305A59DEF4DC94D07B224B5DAB862393", hash_generated_method = "1F56113BF21C5A41FD5E2E89FA19BD02")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850449203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850449203;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.869 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F9572253427EF66A06D063D464DFD2A1")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414620154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414620154;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.869 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "C2C298C420AE56AA07A619B100DBDBD3")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(mProportion);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.869 -0400", hash_original_method = "EC544E0B7E0BD00BAC5AC8960BBAB7C7", hash_generated_method = "63190EBD4BF453345281EEB23842C977")
    public float getScaleX() {
        float var546ADE640B6EDFBC8A086EF31347E768_592127436 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_592127436;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.871 -0400", hash_original_method = "E20B555A657035EC86C04FC249B48C55", hash_generated_method = "5A84D9E60174F1A20E98CED094E6C361")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        addTaint(ds.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.873 -0400", hash_original_method = "7988BDF035A46DF7E155ADF4B90D7F9B", hash_generated_method = "C6603EBC47F573F3A8D403131C444302")
    @Override
    public void updateMeasureState(TextPaint ds) {
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        addTaint(ds.getTaint());
        
        
    }

    
}

