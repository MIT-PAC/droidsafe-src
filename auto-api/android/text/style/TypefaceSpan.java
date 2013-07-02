package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class TypefaceSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.016 -0400", hash_original_field = "BAA635101CF6E107BAC89837AE69780A", hash_generated_field = "9590C932BAED724FD12B55F1BADC30FA")

    private String mFamily;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.017 -0400", hash_original_method = "30225DE18E1EF58337803047C2C7576B", hash_generated_method = "4B1F3B13B466F40663FF030C15840841")
    public  TypefaceSpan(String family) {
        mFamily = family;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.017 -0400", hash_original_method = "EBFC14963D531976FE4CEA16F8670D1D", hash_generated_method = "3E595017B09B3F0687BA6DDD205A5770")
    public  TypefaceSpan(Parcel src) {
        mFamily = src.readString();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.017 -0400", hash_original_method = "07DD5A556D8AFD5FB18137B3F1261BE3", hash_generated_method = "DC63DD27E3F071497C525CF9F56C7C0E")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611696744 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611696744;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.018 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "73FCAD67DB6C3E43426BA6904C0A3FE8")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705971458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705971458;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.018 -0400", hash_original_method = "3222DFE1438A7B94741074BF5C471F95", hash_generated_method = "D26860DEEE980AB4FE83689224D2C7A5")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFamily);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.018 -0400", hash_original_method = "A22822B6578A7051FA8E71732705B93C", hash_generated_method = "0160D7DFE8D7846EE22198FF9FBEC36E")
    public String getFamily() {
        String varB4EAC82CA7396A68D541C85D26508E83_668463616 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_668463616 = mFamily;
        varB4EAC82CA7396A68D541C85D26508E83_668463616.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_668463616;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.019 -0400", hash_original_method = "1FF2F211A2A46041B93FC8FF91A72EF9", hash_generated_method = "D6E17F64C32DE5AE9C0B5EC44C5485C6")
    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, mFamily);
        addTaint(ds.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.019 -0400", hash_original_method = "EDA342B19CEA5F662FF3BE7187A11677", hash_generated_method = "E4F11EF2759E0EF2A66647C9FEB9AFF6")
    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, mFamily);
        addTaint(paint.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void apply(Paint paint, String family) {
        int oldStyle;
        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }
        Typeface tf = Typeface.create(family, oldStyle);
        int fake = oldStyle & ~tf.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(tf);
    }

    
}

