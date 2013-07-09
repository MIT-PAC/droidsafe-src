package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class ForegroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.742 -0400", hash_original_field = "D2A5DB085B68088532B9E8FB544C2EAD", hash_generated_field = "118704B52DA650C4DCD23A9FC0B970FC")

    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.742 -0400", hash_original_method = "CCAF801A87F70F53C246D8BAD4668254", hash_generated_method = "91483188A00DC05189FE5D6D1699D52B")
    public  ForegroundColorSpan(int color) {
        mColor = color;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.742 -0400", hash_original_method = "C1959654A903860C71D5E98AD17C38DB", hash_generated_method = "1D056DE5D0944B8683CDFCC48DB97D3F")
    public  ForegroundColorSpan(Parcel src) {
        mColor = src.readInt();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.743 -0400", hash_original_method = "8155995CA89F113B2E7BEC17CF09D49D", hash_generated_method = "4618688A465CA157BA921858B86D23AB")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117520752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117520752;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.743 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8F2AB1C99768CA0FAD03F8E23A70FC20")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007819904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007819904;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.744 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "4434B22B71E34F3AE6C4E59891B471B8")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.744 -0400", hash_original_method = "7DE99734F4F039B37C58D21552D08DBC", hash_generated_method = "30BF266DBFA96F3F6BFA9FCEC897E750")
    public int getForegroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884282762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884282762;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.745 -0400", hash_original_method = "119B8D3BB9F53DFAB442699FA205FF8F", hash_generated_method = "2F1C2E8F6B8BD6A6D6757FC91916A06D")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(mColor);
        addTaint(ds.getTaint());
        
        
    }

    
}

