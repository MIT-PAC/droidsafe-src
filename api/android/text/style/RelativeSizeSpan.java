package android.text.style;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;





public class RelativeSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.076 -0400", hash_original_field = "5B484EED7F441408FBB3DA9CD489795B", hash_generated_field = "F3DE0713F398F5B7918E6C35C0AAE054")

    private float mProportion;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.076 -0400", hash_original_method = "A7FADA85249F1B8943B2C3745C9AD73C", hash_generated_method = "525A76130EC8817067C8B8013EE73EC7")
    public  RelativeSizeSpan(float proportion) {
        mProportion = proportion;
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.077 -0400", hash_original_method = "3E1E83FB4F6546C2007DF6E3D1177212", hash_generated_method = "E62FC47C3538C5889E4F568A97414710")
    public  RelativeSizeSpan(Parcel src) {
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.077 -0400", hash_original_method = "D2254CF1E8362BBCA36C2E8295131004", hash_generated_method = "2FD6F522B7E542EE23B00110421419AB")
    public int getSpanTypeId() {
        int var559471C7BBF138D4D4122D4CE3808EA9_926901207 = (TextUtils.RELATIVE_SIZE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880370778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_880370778;
        // ---------- Original Method ----------
        //return TextUtils.RELATIVE_SIZE_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.078 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6BDBCFC590FE4B3E104ED453BD899316")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_256522019 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254519606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254519606;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.078 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "1D9B7D8754722BA66324688F13492060")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeFloat(mProportion);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.078 -0400", hash_original_method = "E89C4B67E9A9CE5F6854A6F0C8388FE6", hash_generated_method = "941B7D3803BBD58E2D8133BDAE832462")
    public float getSizeChange() {
        float var5B484EED7F441408FBB3DA9CD489795B_1833507213 = (mProportion);
                float var546ADE640B6EDFBC8A086EF31347E768_901793073 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_901793073;
        // ---------- Original Method ----------
        //return mProportion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.079 -0400", hash_original_method = "D87A5BB37ACAA736C762D797F93AD23D", hash_generated_method = "4B3280C26FDB40ECAD310FC1FF292A0A")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.setTextSize(ds.getTextSize() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.079 -0400", hash_original_method = "B20FAC1EC83BD8EFC8CAF1EE401E0C1F", hash_generated_method = "5B7C460548A4616DB555EED0D80A3C5D")
    @Override
    public void updateMeasureState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.setTextSize(ds.getTextSize() * mProportion);
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
}

