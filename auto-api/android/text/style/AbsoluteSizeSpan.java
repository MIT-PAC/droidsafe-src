package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class AbsoluteSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.681 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.681 -0400", hash_original_field = "C9C3429D544FE62304830077F3FFD086", hash_generated_field = "2907C85C29B7CCA19FB98273C79A6D33")

    private boolean mDip;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.682 -0400", hash_original_method = "9F182F09B08FED6314DBE96ECAD38ABB", hash_generated_method = "808C7C6BBA9410B93532F64C75FFF2BB")
    public  AbsoluteSizeSpan(int size) {
        mSize = size;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.682 -0400", hash_original_method = "452A1F4FB6807BADBE67E3FEF1703DF6", hash_generated_method = "D6608B6B61B74F52F734D2B318918E9F")
    public  AbsoluteSizeSpan(int size, boolean dip) {
        mSize = size;
        mDip = dip;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.682 -0400", hash_original_method = "11A22A410F4688830BCA693D188465D5", hash_generated_method = "1DCCD9D6C7E3D190DB37D22C39654879")
    public  AbsoluteSizeSpan(Parcel src) {
        mSize = src.readInt();
        mDip = src.readInt() != 0;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.683 -0400", hash_original_method = "8ECE4916687DC9B660DB4531FCB16044", hash_generated_method = "65D1F5393F541B6AA6BAB8E744C765EE")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472463000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472463000;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.683 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E7054EC177DD077FBF33CFBB65DAE000")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439417021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439417021;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.683 -0400", hash_original_method = "8027C06709F3FF60199965EEE92D48C7", hash_generated_method = "26CEBB8D0BDD141847570BC6592CF472")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSize);
        dest.writeInt(mDip ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.684 -0400", hash_original_method = "2098B918320D3D5229820CAB47C60E59", hash_generated_method = "7C3AE240F98F26F303E9EE9A4B3915A1")
    public int getSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015675062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015675062;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.684 -0400", hash_original_method = "E1A5B960016F06729A9EBA9A98D5F008", hash_generated_method = "FC163C2C92B6943A62528EE41980AF31")
    public boolean getDip() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207828961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207828961;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.684 -0400", hash_original_method = "EA2263AF61F8EA4B1854731646B3D093", hash_generated_method = "42B5C509E8B03CDBA484CF53DFA48AEA")
    @Override
    public void updateDrawState(TextPaint ds) {
        {
            ds.setTextSize(mSize * ds.density);
        } 
        {
            ds.setTextSize(mSize);
        } 
        addTaint(ds.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.685 -0400", hash_original_method = "1F6CC548E4C5BF47656F78351153B803", hash_generated_method = "69E0A7F9D006906EC06EA3AA2EBD66D2")
    @Override
    public void updateMeasureState(TextPaint ds) {
        {
            ds.setTextSize(mSize * ds.density);
        } 
        {
            ds.setTextSize(mSize);
        } 
        addTaint(ds.getTaint());
        
        
            
        
            
        
    }

    
}

