package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;




public class EasyEditSpan implements ParcelableSpan {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.046 -0500", hash_original_method = "A230929293AFFCA631493D5E514D429F", hash_generated_method = "37C9EA6078415747890F9889C5AC3A63")
    public EasyEditSpan() {
        // Empty
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.047 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    @Override
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.048 -0500", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "769DF2486ED6940F8E62EC11EEC3116C")
    @Override
public void writeToParcel(Parcel dest, int flags) {
        // Empty
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:52.048 -0500", hash_original_method = "B70B692D38FEF311001170F890E9CCAE", hash_generated_method = "31275165529ED4EB50CEF948BA58301D")
    @Override
public int getSpanTypeId() {
        return TextUtils.EASY_EDIT_SPAN;
    }

    
}

