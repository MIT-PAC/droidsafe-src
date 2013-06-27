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

public class BackgroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.476 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.478 -0400", hash_original_method = "1BABE23E25570DA2EF62C4506697834B", hash_generated_method = "35000CFE38870CD7CB814F81DF321DBD")
    public  BackgroundColorSpan(int color) {
        mColor = color;
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.478 -0400", hash_original_method = "71157ECE822D307A1BD642C08548B0D3", hash_generated_method = "70CE0565CAAE91A6A441B8AAAAA665D4")
    public  BackgroundColorSpan(Parcel src) {
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.478 -0400", hash_original_method = "D24F62EA631AC1AF936FF48E9134FC5B", hash_generated_method = "C85D87A8F7BBA7DDA2BEA2A3D0452C3D")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193301390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193301390;
        // ---------- Original Method ----------
        //return TextUtils.BACKGROUND_COLOR_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.479 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4641839C838A792D45D7D02123826444")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986230062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986230062;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.479 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "4434B22B71E34F3AE6C4E59891B471B8")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.479 -0400", hash_original_method = "C57B18EE451723AD85B8F6926D247DF6", hash_generated_method = "59C67B26B007A288E7A3843E4390D96F")
    public int getBackgroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628410746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628410746;
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.480 -0400", hash_original_method = "7B660C1B12B91C1F1E71953191ED601F", hash_generated_method = "FE903F01EB757874AA05BAA565DE1FFA")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.bgColor = mColor;
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.bgColor = mColor;
    }

    
}

