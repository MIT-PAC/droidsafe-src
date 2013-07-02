package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class BackgroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.693 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.694 -0400", hash_original_method = "1BABE23E25570DA2EF62C4506697834B", hash_generated_method = "35000CFE38870CD7CB814F81DF321DBD")
    public  BackgroundColorSpan(int color) {
        mColor = color;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.694 -0400", hash_original_method = "71157ECE822D307A1BD642C08548B0D3", hash_generated_method = "70CE0565CAAE91A6A441B8AAAAA665D4")
    public  BackgroundColorSpan(Parcel src) {
        mColor = src.readInt();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.694 -0400", hash_original_method = "D24F62EA631AC1AF936FF48E9134FC5B", hash_generated_method = "D47E5336F576939262F78563AEBD36F3")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974712376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_974712376;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.695 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FAA51F16051FCB5660B286F1E88159C4")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359148305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_359148305;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.695 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "4434B22B71E34F3AE6C4E59891B471B8")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.695 -0400", hash_original_method = "C57B18EE451723AD85B8F6926D247DF6", hash_generated_method = "87A4D2B20C39E783D439C059EF1AE401")
    public int getBackgroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083152408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2083152408;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.696 -0400", hash_original_method = "7B660C1B12B91C1F1E71953191ED601F", hash_generated_method = "FE903F01EB757874AA05BAA565DE1FFA")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.bgColor = mColor;
        addTaint(ds.getTaint());
        
        
    }

    
}

