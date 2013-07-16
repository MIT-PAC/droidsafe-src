package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class ScaleXSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.269 -0400", hash_original_field = "5B484EED7F441408FBB3DA9CD489795B", hash_generated_field = "F3DE0713F398F5B7918E6C35C0AAE054")

    private float mProportion;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.270 -0400", hash_original_method = "5A8420DEA89D3BA24C51E3449203D410", hash_generated_method = "07EA7FB4A78397A0402CFA97CFD413F0")
    public  ScaleXSpan(float proportion) {
        mProportion = proportion;
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.270 -0400", hash_original_method = "84B8294F7669FCC40D337D5712D24934", hash_generated_method = "6A0BF93ECB06D20C8DD707C448ED318A")
    public  ScaleXSpan(Parcel src) {
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.271 -0400", hash_original_method = "305A59DEF4DC94D07B224B5DAB862393", hash_generated_method = "9DB37001B179B0A7C0CCFE040572F552")
    public int getSpanTypeId() {
        int varFA9E0D050343C0B13D9082A9421123DE_1569336667 = (TextUtils.SCALE_X_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807901729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_807901729;
        // ---------- Original Method ----------
        //return TextUtils.SCALE_X_SPAN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.271 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6AF0A1DC5992FF10A5CD23E21293250A")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_402131090 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1642833067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1642833067;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.272 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "1D9B7D8754722BA66324688F13492060")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeFloat(mProportion);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.272 -0400", hash_original_method = "EC544E0B7E0BD00BAC5AC8960BBAB7C7", hash_generated_method = "CA5546D3C2D20D7F4ED51D9B409A3114")
    public float getScaleX() {
        float var5B484EED7F441408FBB3DA9CD489795B_1997118466 = (mProportion);
                float var546ADE640B6EDFBC8A086EF31347E768_1194334111 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1194334111;
        // ---------- Original Method ----------
        //return mProportion;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.272 -0400", hash_original_method = "E20B555A657035EC86C04FC249B48C55", hash_generated_method = "4611C787D146151071AB38733242E0EA")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.273 -0400", hash_original_method = "7988BDF035A46DF7E155ADF4B90D7F9B", hash_generated_method = "BC74BFDF54E7B608B13B1CB023F1D465")
    @Override
    public void updateMeasureState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.setTextScaleX(ds.getTextScaleX() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextScaleX(ds.getTextScaleX() * mProportion);
    }

    
}

