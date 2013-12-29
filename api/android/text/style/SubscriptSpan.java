package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;




public class SubscriptSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.869 -0500", hash_original_method = "416865739F2C1ABBE61451113480FAB4", hash_generated_method = "0CB790850FD74946AAEC04BCE4135935")
    public SubscriptSpan() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.870 -0500", hash_original_method = "71E3921D1341E00E4D27F607004C29AC", hash_generated_method = "81944CEF93831A86D705003C06F8ADDF")
    public SubscriptSpan(Parcel src) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.870 -0500", hash_original_method = "CB8400634E0A005DFA226D39FFA147D9", hash_generated_method = "550460EB366598CA0BA56CCC3EA2B074")
    public int getSpanTypeId() {
        return TextUtils.SUBSCRIPT_SPAN;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.871 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.872 -0500", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "ED3C20853EE283140D61863E7CC05F99")
    public void writeToParcel(Parcel dest, int flags) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.873 -0500", hash_original_method = "9DCCA482100D1E9EC8F2615F051D6490", hash_generated_method = "22B85FF5BBBAA9866626E0EA880FE7AB")
    @Override
public void updateDrawState(TextPaint tp) {
        tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.874 -0500", hash_original_method = "7DFDD8213FBD02BEC2253684A70AD5F4", hash_generated_method = "655C8882E5C7D3CDA43F6AAF73B7BC9E")
    @Override
public void updateMeasureState(TextPaint tp) {
        tp.baselineShift -= (int) (tp.ascent() / 2);
    }

    
}

