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

public class SuggestionRangeSpan extends CharacterStyle implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.823 -0400", hash_original_field = "F28F2DF30FA0A384EA442393DFFC03BB", hash_generated_field = "CC64588E1E08B8E0993874A8A69D251D")

    private int mBackgroundColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.833 -0400", hash_original_method = "BE3451A654F6E9FD9B583E5F598309FD", hash_generated_method = "3DDFC0E11D5F7709FC0BC9167F9698B2")
    public  SuggestionRangeSpan() {
        mBackgroundColor = 0;
        // ---------- Original Method ----------
        //mBackgroundColor = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.834 -0400", hash_original_method = "C19BD23169B457337D3E2C544633849E", hash_generated_method = "4C2C2E3ED2D787E1EE455D3C2928ACB7")
    public  SuggestionRangeSpan(Parcel src) {
        mBackgroundColor = src.readInt();
        // ---------- Original Method ----------
        //mBackgroundColor = src.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.834 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "FA2DE12656BE62177371B0642DA3AA2E")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262295481 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262295481;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.834 -0400", hash_original_method = "2D196358A51E993023DA9656E12C24CE", hash_generated_method = "EB35B27ED1ECFBFDC6A89B4A90E736F0")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mBackgroundColor);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mBackgroundColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.848 -0400", hash_original_method = "C317BC4F0E850D3D8EACD128701AD14B", hash_generated_method = "52191F6F13981D3A27A3A549D7E265BD")
    @Override
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104570179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_104570179;
        // ---------- Original Method ----------
        //return TextUtils.SUGGESTION_RANGE_SPAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.852 -0400", hash_original_method = "E6A11EC9B3E2DA21777E259CEAE43825", hash_generated_method = "C1EDFD39139B52FAB44D8473BFF01E1A")
    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
        // ---------- Original Method ----------
        //mBackgroundColor = backgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.852 -0400", hash_original_method = "DC157379F92590C2B130D316844D8B74", hash_generated_method = "F5F2C9C58794B83BE0C607308DD51751")
    @Override
    public void updateDrawState(TextPaint tp) {
        tp.bgColor = mBackgroundColor;
        addTaint(tp.getTaint());
        // ---------- Original Method ----------
        //tp.bgColor = mBackgroundColor;
    }

    
}

