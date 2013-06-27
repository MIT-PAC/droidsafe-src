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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.758 -0400", hash_original_field = "2CD5FC4A7984A2B11D32D28D974733BE", hash_generated_field = "CD03D035E3A34C62C050AB1056925600")

    private boolean mSpellCheckInProgress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.758 -0400", hash_original_method = "F1D4E96290AC8C7754627E362363B9DA", hash_generated_method = "26BD444D89119A2293FF0670908802DE")
    public  SpellCheckSpan() {
        mSpellCheckInProgress = false;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.759 -0400", hash_original_method = "9BB9BE3CC699053708AEB172BEE11085", hash_generated_method = "612B7223728EBFB58F40A6C5D42F0175")
    public  SpellCheckSpan(Parcel src) {
        mSpellCheckInProgress = (src.readInt() != 0);
        // ---------- Original Method ----------
        //mSpellCheckInProgress = (src.readInt() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.759 -0400", hash_original_method = "712093FDA6926C8B5E44D517F24CE2ED", hash_generated_method = "7790FF52440767842592CC146F06EEF2")
    public void setSpellCheckInProgress(boolean inProgress) {
        mSpellCheckInProgress = inProgress;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = inProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.760 -0400", hash_original_method = "DF88C425EC6702745B81C07A898C5194", hash_generated_method = "F26418FB5BB2EB247AA7251A5388B931")
    public boolean isSpellCheckInProgress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9639128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_9639128;
        // ---------- Original Method ----------
        //return mSpellCheckInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.760 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "097C4C3ACB1F9331B5F785BC764F10EB")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825769905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825769905;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.760 -0400", hash_original_method = "4374405C13E287E9F22B8DE100EB99A0", hash_generated_method = "D6A868E4BA800D91740464B23B852E81")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSpellCheckInProgress ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mSpellCheckInProgress ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.761 -0400", hash_original_method = "8BC137FF3CFAC8D1FC70CD10E3E0E733", hash_generated_method = "D33EB2477462928A71EAE20FD57EB856")
    @Override
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385199950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385199950;
        // ---------- Original Method ----------
        //return TextUtils.SPELL_CHECK_SPAN;
    }

    
}

