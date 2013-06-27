package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;
import android.widget.TextView;

public class EasyEditSpan implements ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.618 -0400", hash_original_method = "A230929293AFFCA631493D5E514D429F", hash_generated_method = "30C43FC9D033188B5BCE7C639844F2F1")
    public  EasyEditSpan() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.619 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8E4F9E36C7DD3844BFD1F5BE47FBD868")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661417964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_661417964;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.619 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "D696427CA240C7E1870A3A5B29EE5303")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.629 -0400", hash_original_method = "B70B692D38FEF311001170F890E9CCAE", hash_generated_method = "B71FD5CFBD3C659C1E67156AED818FC7")
    @Override
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515422269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515422269;
        // ---------- Original Method ----------
        //return TextUtils.EASY_EDIT_SPAN;
    }

    
}

