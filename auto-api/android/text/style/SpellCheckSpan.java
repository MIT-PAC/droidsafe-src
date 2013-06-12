package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class SpellCheckSpan implements ParcelableSpan {
    private boolean mSpellCheckInProgress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.313 -0400", hash_original_method = "F1D4E96290AC8C7754627E362363B9DA", hash_generated_method = "870A82BA33B36BE69057567D399DB25D")
    @DSModeled(DSC.SAFE)
    public SpellCheckSpan() {
        mSpellCheckInProgress = false;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.313 -0400", hash_original_method = "9BB9BE3CC699053708AEB172BEE11085", hash_generated_method = "E3D552221296C807008EAA494D7164CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckSpan(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mSpellCheckInProgress = (src.readInt() != 0);
        // ---------- Original Method ----------
        //mSpellCheckInProgress = (src.readInt() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.313 -0400", hash_original_method = "712093FDA6926C8B5E44D517F24CE2ED", hash_generated_method = "4D2A32EDEDAD7BE5F0FB6098202DBD56")
    @DSModeled(DSC.SAFE)
    public void setSpellCheckInProgress(boolean inProgress) {
        dsTaint.addTaint(inProgress);
        // ---------- Original Method ----------
        //mSpellCheckInProgress = inProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.313 -0400", hash_original_method = "DF88C425EC6702745B81C07A898C5194", hash_generated_method = "0A3B0ED6F7DCFBE08516087022585F14")
    @DSModeled(DSC.SAFE)
    public boolean isSpellCheckInProgress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSpellCheckInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.313 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.313 -0400", hash_original_method = "4374405C13E287E9F22B8DE100EB99A0", hash_generated_method = "F1BC3F59BCB51C9A05E666BF1F743FF2")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mSpellCheckInProgress ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSpellCheckInProgress ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.313 -0400", hash_original_method = "8BC137FF3CFAC8D1FC70CD10E3E0E733", hash_generated_method = "59C9765F53BAA6CC470D670690B1A44F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.SPELL_CHECK_SPAN;
    }

    
}


