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

public class SpellCheckSpan implements ParcelableSpan {
    private boolean mSpellCheckInProgress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.921 -0400", hash_original_method = "F1D4E96290AC8C7754627E362363B9DA", hash_generated_method = "26BD444D89119A2293FF0670908802DE")
    @DSModeled(DSC.SAFE)
    public SpellCheckSpan() {
        mSpellCheckInProgress = false;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.922 -0400", hash_original_method = "9BB9BE3CC699053708AEB172BEE11085", hash_generated_method = "E7E1E899A4943C4011CB5A0AAA55ED0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mSpellCheckInProgress = (src.readInt() != 0);
        // ---------- Original Method ----------
        //mSpellCheckInProgress = (src.readInt() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.922 -0400", hash_original_method = "712093FDA6926C8B5E44D517F24CE2ED", hash_generated_method = "FA6F6FF9FC22F055C4408A4F2087AD74")
    @DSModeled(DSC.SAFE)
    public void setSpellCheckInProgress(boolean inProgress) {
        dsTaint.addTaint(inProgress);
        // ---------- Original Method ----------
        //mSpellCheckInProgress = inProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.922 -0400", hash_original_method = "DF88C425EC6702745B81C07A898C5194", hash_generated_method = "C7371D4F1AA6DD6D3F4CF068DD5200A9")
    @DSModeled(DSC.SAFE)
    public boolean isSpellCheckInProgress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSpellCheckInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.922 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.922 -0400", hash_original_method = "4374405C13E287E9F22B8DE100EB99A0", hash_generated_method = "55BFF41C5D7B5951AE8C9A06D11E33A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mSpellCheckInProgress ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSpellCheckInProgress ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.923 -0400", hash_original_method = "8BC137FF3CFAC8D1FC70CD10E3E0E733", hash_generated_method = "C7A2D1D6D385E30AC2211CF4FCA02FF9")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SPELL_CHECK_SPAN;
    }

    
}

