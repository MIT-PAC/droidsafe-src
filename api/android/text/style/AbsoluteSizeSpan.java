package android.text.style;

// Droidsafe Imports
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AbsoluteSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.894 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.894 -0400", hash_original_field = "C9C3429D544FE62304830077F3FFD086", hash_generated_field = "2907C85C29B7CCA19FB98273C79A6D33")

    private boolean mDip;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.894 -0400", hash_original_method = "9F182F09B08FED6314DBE96ECAD38ABB", hash_generated_method = "808C7C6BBA9410B93532F64C75FFF2BB")
    public  AbsoluteSizeSpan(int size) {
        mSize = size;
        // ---------- Original Method ----------
        //mSize = size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.895 -0400", hash_original_method = "452A1F4FB6807BADBE67E3FEF1703DF6", hash_generated_method = "D6608B6B61B74F52F734D2B318918E9F")
    public  AbsoluteSizeSpan(int size, boolean dip) {
        mSize = size;
        mDip = dip;
        // ---------- Original Method ----------
        //mSize = size;
        //mDip = dip;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.896 -0400", hash_original_method = "11A22A410F4688830BCA693D188465D5", hash_generated_method = "1DCCD9D6C7E3D190DB37D22C39654879")
    public  AbsoluteSizeSpan(Parcel src) {
        mSize = src.readInt();
        mDip = src.readInt() != 0;
        // ---------- Original Method ----------
        //mSize = src.readInt();
        //mDip = src.readInt() != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.896 -0400", hash_original_method = "8ECE4916687DC9B660DB4531FCB16044", hash_generated_method = "26BB40718B271B840D27E995A6F6D80C")
    public int getSpanTypeId() {
        int var9068B6C2E687F6C10064A03FAE28FEA4_1011012144 = (TextUtils.ABSOLUTE_SIZE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534621191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534621191;
        // ---------- Original Method ----------
        //return TextUtils.ABSOLUTE_SIZE_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.896 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E7C8321ADB214D1C99CDE318238D0427")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_457969452 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098154552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098154552;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.897 -0400", hash_original_method = "8027C06709F3FF60199965EEE92D48C7", hash_generated_method = "0B3F0AADA2DBF09F9BA1E055B20B8465")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mSize);
        dest.writeInt(mDip ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSize);
        //dest.writeInt(mDip ? 1 : 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.897 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "A893E241BB0F0D4113DCA95526158FFB")
    public int getSize() {
        int var27DFA0EFE73BCB065533443A05E9DEE4_2032902000 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959566477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959566477;
        // ---------- Original Method ----------
        //return mSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.897 -0400", hash_original_method = "E1A5B960016F06729A9EBA9A98D5F008", hash_generated_method = "066A361E5B0C427F0DADA47350179B8B")
    public boolean getDip() {
        boolean varC9C3429D544FE62304830077F3FFD086_2112498839 = (mDip);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847704378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_847704378;
        // ---------- Original Method ----------
        //return mDip;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.898 -0400", hash_original_method = "EA2263AF61F8EA4B1854731646B3D093", hash_generated_method = "74682F8618092BE68EC92A660F6A35E6")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        if(mDip)        
        {
            ds.setTextSize(mSize * ds.density);
        } //End block
        else
        {
            ds.setTextSize(mSize);
        } //End block
        // ---------- Original Method ----------
        //if (mDip) {
            //ds.setTextSize(mSize * ds.density);
        //} else {
            //ds.setTextSize(mSize);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.898 -0400", hash_original_method = "1F6CC548E4C5BF47656F78351153B803", hash_generated_method = "6FE9C85205AE319DE4CC32B815005A21")
    @Override
    public void updateMeasureState(TextPaint ds) {
        addTaint(ds.getTaint());
        if(mDip)        
        {
            ds.setTextSize(mSize * ds.density);
        } //End block
        else
        {
            ds.setTextSize(mSize);
        } //End block
        // ---------- Original Method ----------
        //if (mDip) {
            //ds.setTextSize(mSize * ds.density);
        //} else {
            //ds.setTextSize(mSize);
        //}
    }

    
}

