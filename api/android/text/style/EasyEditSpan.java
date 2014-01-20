package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class EasyEditSpan implements ParcelableSpan {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.230 -0500", hash_original_method = "A230929293AFFCA631493D5E514D429F", hash_generated_method = "37C9EA6078415747890F9889C5AC3A63")
    
public EasyEditSpan() {
        // Empty
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.233 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.236 -0500", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "769DF2486ED6940F8E62EC11EEC3116C")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        // Empty
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.238 -0500", hash_original_method = "B70B692D38FEF311001170F890E9CCAE", hash_generated_method = "31275165529ED4EB50CEF948BA58301D")
    
@Override
    public int getSpanTypeId() {
        return TextUtils.EASY_EDIT_SPAN;
    }
    
}

