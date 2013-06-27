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

public class RelativeSizeSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.721 -0400", hash_original_field = "5B484EED7F441408FBB3DA9CD489795B", hash_generated_field = "F3DE0713F398F5B7918E6C35C0AAE054")

    private float mProportion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.734 -0400", hash_original_method = "A7FADA85249F1B8943B2C3745C9AD73C", hash_generated_method = "525A76130EC8817067C8B8013EE73EC7")
    public  RelativeSizeSpan(float proportion) {
        mProportion = proportion;
        // ---------- Original Method ----------
        //mProportion = proportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.735 -0400", hash_original_method = "3E1E83FB4F6546C2007DF6E3D1177212", hash_generated_method = "E62FC47C3538C5889E4F568A97414710")
    public  RelativeSizeSpan(Parcel src) {
        mProportion = src.readFloat();
        // ---------- Original Method ----------
        //mProportion = src.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.735 -0400", hash_original_method = "D2254CF1E8362BBCA36C2E8295131004", hash_generated_method = "035D29564FF3EC6D8C0E39FCB60AEAE2")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975010041 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975010041;
        // ---------- Original Method ----------
        //return TextUtils.RELATIVE_SIZE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.735 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "869C3A679160985D7CF1C4A9CCD9868E")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527164500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527164500;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.736 -0400", hash_original_method = "0FDF8A7C1083C0A4BBAF4047CBF27DA9", hash_generated_method = "C2C298C420AE56AA07A619B100DBDBD3")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(mProportion);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeFloat(mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.736 -0400", hash_original_method = "E89C4B67E9A9CE5F6854A6F0C8388FE6", hash_generated_method = "5FEE9D75F5097742626D75AE45BA9C80")
    public float getSizeChange() {
        float var546ADE640B6EDFBC8A086EF31347E768_541449094 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_541449094;
        // ---------- Original Method ----------
        //return mProportion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.740 -0400", hash_original_method = "D87A5BB37ACAA736C762D797F93AD23D", hash_generated_method = "299E2FA7287C0FF7949B43ACCFBC895E")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setTextSize(ds.getTextSize() * mProportion);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.740 -0400", hash_original_method = "B20FAC1EC83BD8EFC8CAF1EE401E0C1F", hash_generated_method = "D3E4F74AF44F717AE1B403FB6AC95049")
    @Override
    public void updateMeasureState(TextPaint ds) {
        ds.setTextSize(ds.getTextSize() * mProportion);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.setTextSize(ds.getTextSize() * mProportion);
    }

    
}

