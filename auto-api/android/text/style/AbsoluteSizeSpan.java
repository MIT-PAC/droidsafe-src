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

public class AbsoluteSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.386 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.387 -0400", hash_original_field = "C9C3429D544FE62304830077F3FFD086", hash_generated_field = "2907C85C29B7CCA19FB98273C79A6D33")

    private boolean mDip;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.389 -0400", hash_original_method = "9F182F09B08FED6314DBE96ECAD38ABB", hash_generated_method = "808C7C6BBA9410B93532F64C75FFF2BB")
    public  AbsoluteSizeSpan(int size) {
        mSize = size;
        // ---------- Original Method ----------
        //mSize = size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.390 -0400", hash_original_method = "452A1F4FB6807BADBE67E3FEF1703DF6", hash_generated_method = "D6608B6B61B74F52F734D2B318918E9F")
    public  AbsoluteSizeSpan(int size, boolean dip) {
        mSize = size;
        mDip = dip;
        // ---------- Original Method ----------
        //mSize = size;
        //mDip = dip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.390 -0400", hash_original_method = "11A22A410F4688830BCA693D188465D5", hash_generated_method = "1DCCD9D6C7E3D190DB37D22C39654879")
    public  AbsoluteSizeSpan(Parcel src) {
        mSize = src.readInt();
        mDip = src.readInt() != 0;
        // ---------- Original Method ----------
        //mSize = src.readInt();
        //mDip = src.readInt() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.391 -0400", hash_original_method = "8ECE4916687DC9B660DB4531FCB16044", hash_generated_method = "CDDC8A08923A6826737FDE6004FB6ADF")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579095415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579095415;
        // ---------- Original Method ----------
        //return TextUtils.ABSOLUTE_SIZE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.391 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "74415DB8E0FD676BA2459ADA5AA87AE9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375683518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1375683518;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.411 -0400", hash_original_method = "8027C06709F3FF60199965EEE92D48C7", hash_generated_method = "26CEBB8D0BDD141847570BC6592CF472")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSize);
        dest.writeInt(mDip ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mSize);
        //dest.writeInt(mDip ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.412 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "8F95D2BF40B298D147C10C388EC1F932")
    public int getSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509647411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509647411;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.412 -0400", hash_original_method = "E1A5B960016F06729A9EBA9A98D5F008", hash_generated_method = "7CB915DAD1D2A02C84FCEABFF02062A4")
    public boolean getDip() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925128027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925128027;
        // ---------- Original Method ----------
        //return mDip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.412 -0400", hash_original_method = "EA2263AF61F8EA4B1854731646B3D093", hash_generated_method = "42B5C509E8B03CDBA484CF53DFA48AEA")
    @Override
    public void updateDrawState(TextPaint ds) {
        {
            ds.setTextSize(mSize * ds.density);
        } //End block
        {
            ds.setTextSize(mSize);
        } //End block
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //if (mDip) {
            //ds.setTextSize(mSize * ds.density);
        //} else {
            //ds.setTextSize(mSize);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.413 -0400", hash_original_method = "1F6CC548E4C5BF47656F78351153B803", hash_generated_method = "69E0A7F9D006906EC06EA3AA2EBD66D2")
    @Override
    public void updateMeasureState(TextPaint ds) {
        {
            ds.setTextSize(mSize * ds.density);
        } //End block
        {
            ds.setTextSize(mSize);
        } //End block
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //if (mDip) {
            //ds.setTextSize(mSize * ds.density);
        //} else {
            //ds.setTextSize(mSize);
        //}
    }

    
}

