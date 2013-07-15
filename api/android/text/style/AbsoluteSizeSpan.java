package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class AbsoluteSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.104 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.104 -0400", hash_original_field = "C9C3429D544FE62304830077F3FFD086", hash_generated_field = "2907C85C29B7CCA19FB98273C79A6D33")

    private boolean mDip;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.104 -0400", hash_original_method = "9F182F09B08FED6314DBE96ECAD38ABB", hash_generated_method = "808C7C6BBA9410B93532F64C75FFF2BB")
    public  AbsoluteSizeSpan(int size) {
        mSize = size;
        // ---------- Original Method ----------
        //mSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.105 -0400", hash_original_method = "452A1F4FB6807BADBE67E3FEF1703DF6", hash_generated_method = "D6608B6B61B74F52F734D2B318918E9F")
    public  AbsoluteSizeSpan(int size, boolean dip) {
        mSize = size;
        mDip = dip;
        // ---------- Original Method ----------
        //mSize = size;
        //mDip = dip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.105 -0400", hash_original_method = "11A22A410F4688830BCA693D188465D5", hash_generated_method = "1DCCD9D6C7E3D190DB37D22C39654879")
    public  AbsoluteSizeSpan(Parcel src) {
        mSize = src.readInt();
        mDip = src.readInt() != 0;
        // ---------- Original Method ----------
        //mSize = src.readInt();
        //mDip = src.readInt() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.106 -0400", hash_original_method = "8ECE4916687DC9B660DB4531FCB16044", hash_generated_method = "F771A3695D28B56BABF1036DA6229B6D")
    public int getSpanTypeId() {
        int var9068B6C2E687F6C10064A03FAE28FEA4_491209253 = (TextUtils.ABSOLUTE_SIZE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895646878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895646878;
        // ---------- Original Method ----------
        //return TextUtils.ABSOLUTE_SIZE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.106 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "69970F3341480C60FAE5E1679E566E99")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1934575857 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109803552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109803552;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.106 -0400", hash_original_method = "8027C06709F3FF60199965EEE92D48C7", hash_generated_method = "0B3F0AADA2DBF09F9BA1E055B20B8465")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mSize);
        dest.writeInt(mDip ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSize);
        //dest.writeInt(mDip ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.107 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "A765D0A5D5E45828E31F1BA1A1EBA164")
    public int getSize() {
        int var27DFA0EFE73BCB065533443A05E9DEE4_1527047093 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883977810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883977810;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.107 -0400", hash_original_method = "E1A5B960016F06729A9EBA9A98D5F008", hash_generated_method = "88CD2586E8FE8CE36284C006E06F313D")
    public boolean getDip() {
        boolean varC9C3429D544FE62304830077F3FFD086_1900731050 = (mDip);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934368742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934368742;
        // ---------- Original Method ----------
        //return mDip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.107 -0400", hash_original_method = "EA2263AF61F8EA4B1854731646B3D093", hash_generated_method = "74682F8618092BE68EC92A660F6A35E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.108 -0400", hash_original_method = "1F6CC548E4C5BF47656F78351153B803", hash_generated_method = "6FE9C85205AE319DE4CC32B815005A21")
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

