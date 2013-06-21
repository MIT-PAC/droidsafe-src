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

public class ForegroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    private int mColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.851 -0400", hash_original_method = "CCAF801A87F70F53C246D8BAD4668254", hash_generated_method = "45B1A04F3FFCF3615521C9ADB5076B35")
    @DSModeled(DSC.SAFE)
    public ForegroundColorSpan(int color) {
        dsTaint.addTaint(color);
        // ---------- Original Method ----------
        //mColor = color;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.852 -0400", hash_original_method = "C1959654A903860C71D5E98AD17C38DB", hash_generated_method = "4280C92825D2C94A37CEDC8B075F7B9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ForegroundColorSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mColor = src.readInt();
        // ---------- Original Method ----------
        //mColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.852 -0400", hash_original_method = "8155995CA89F113B2E7BEC17CF09D49D", hash_generated_method = "974A4437C9ED69BCFD7362A10A36B397")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.FOREGROUND_COLOR_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.852 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.853 -0400", hash_original_method = "F35F8912B3182FC877D8B21825C3ABAF", hash_generated_method = "DAA3747B1D479B36DA20B141F586B8AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mColor);
        // ---------- Original Method ----------
        //dest.writeInt(mColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.853 -0400", hash_original_method = "7DE99734F4F039B37C58D21552D08DBC", hash_generated_method = "47C2A803CA92A113D0CDEFBE930D7243")
    @DSModeled(DSC.SAFE)
    public int getForegroundColor() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.853 -0400", hash_original_method = "119B8D3BB9F53DFAB442699FA205FF8F", hash_generated_method = "CF694B7B3DBA34D0DFA3EEE7791187BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setColor(mColor);
        // ---------- Original Method ----------
        //ds.setColor(mColor);
    }

    
}

