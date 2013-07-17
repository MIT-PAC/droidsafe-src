package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class BackgroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.915 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.916 -0400", hash_original_method = "1BABE23E25570DA2EF62C4506697834B", hash_generated_method = "35000CFE38870CD7CB814F81DF321DBD")
    public  BackgroundColorSpan(int color) {
        mColor = color;
        // ---------- Original Method ----------
        //mColor = color;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.916 -0400", hash_original_method = "71157ECE822D307A1BD642C08548B0D3", hash_generated_method = "70CE0565CAAE91A6A441B8AAAAA665D4")
    public  BackgroundColorSpan(Parcel src) {
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.917 -0400", hash_original_method = "D24F62EA631AC1AF936FF48E9134FC5B", hash_generated_method = "523AF21F274BF5214A55550066A5CF89")
    public int getSpanTypeId() {
        int varA0EE110E9B489DD27DAF1072CAF7882A_229859804 = (TextUtils.BACKGROUND_COLOR_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574578958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574578958;
        // ---------- Original Method ----------
        //return TextUtils.BACKGROUND_COLOR_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.917 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1E86DD1D7C133373553F3A1ABC4EA007")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1654457931 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960204772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960204772;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.917 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "2AA9C9BA7FF737DFF4D6096156FE1247")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.917 -0400", hash_original_method = "C57B18EE451723AD85B8F6926D247DF6", hash_generated_method = "07ECCCF43698141BB03CE1A97A2650C2")
    public int getBackgroundColor() {
        int varD2A5DB085B68088532B9E8FB544C2EAD_1157638584 = (mColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547984847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547984847;
        // ---------- Original Method ----------
        //return mColor;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.918 -0400", hash_original_method = "7B660C1B12B91C1F1E71953191ED601F", hash_generated_method = "8734ACA1123536311BF5E2675A3C6DA9")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.bgColor = mColor;
        // ---------- Original Method ----------
        //ds.bgColor = mColor;
    }

    
}

