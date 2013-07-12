package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class ForegroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.181 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.182 -0400", hash_original_method = "CCAF801A87F70F53C246D8BAD4668254", hash_generated_method = "91483188A00DC05189FE5D6D1699D52B")
    public  ForegroundColorSpan(int color) {
        mColor = color;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.182 -0400", hash_original_method = "C1959654A903860C71D5E98AD17C38DB", hash_generated_method = "1D056DE5D0944B8683CDFCC48DB97D3F")
    public  ForegroundColorSpan(Parcel src) {
        mColor = src.readInt();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.183 -0400", hash_original_method = "8155995CA89F113B2E7BEC17CF09D49D", hash_generated_method = "1F40510F59B347E964F9B65259ABAA44")
    public int getSpanTypeId() {
        int var2B510775B0084BF38A6D9BB3C8737B96_362967972 = (TextUtils.FOREGROUND_COLOR_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389067087 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389067087;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.183 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AFA658F62BAF0B0F5B87587759041E1E")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_741814657 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414509226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414509226;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.184 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "2AA9C9BA7FF737DFF4D6096156FE1247")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mColor);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.184 -0400", hash_original_method = "7DE99734F4F039B37C58D21552D08DBC", hash_generated_method = "D30F7E9935DFC0F097D3EADBE15C8CA2")
    public int getForegroundColor() {
        int varD2A5DB085B68088532B9E8FB544C2EAD_1012726610 = (mColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991657910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991657910;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.185 -0400", hash_original_method = "119B8D3BB9F53DFAB442699FA205FF8F", hash_generated_method = "443762873CFF0ADB728081F2147DF217")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.setColor(mColor);
        
        
    }

    
}

