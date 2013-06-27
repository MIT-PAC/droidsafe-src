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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.844 -0400", hash_original_field = "2CD5FC4A7984A2B11D32D28D974733BE", hash_generated_field = "CD03D035E3A34C62C050AB1056925600")

    private boolean mSpellCheckInProgress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.844 -0400", hash_original_method = "F1D4E96290AC8C7754627E362363B9DA", hash_generated_method = "26BD444D89119A2293FF0670908802DE")
    public  SpellCheckSpan() {
        mSpellCheckInProgress = false;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.845 -0400", hash_original_method = "9BB9BE3CC699053708AEB172BEE11085", hash_generated_method = "612B7223728EBFB58F40A6C5D42F0175")
    public  SpellCheckSpan(Parcel src) {
        mSpellCheckInProgress = (src.readInt() != 0);
        // ---------- Original Method ----------
        //mSpellCheckInProgress = (src.readInt() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.845 -0400", hash_original_method = "712093FDA6926C8B5E44D517F24CE2ED", hash_generated_method = "7790FF52440767842592CC146F06EEF2")
    public void setSpellCheckInProgress(boolean inProgress) {
        mSpellCheckInProgress = inProgress;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = inProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.846 -0400", hash_original_method = "DF88C425EC6702745B81C07A898C5194", hash_generated_method = "F498208D7550810981855D76CFC5A3C9")
    public boolean isSpellCheckInProgress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1289352830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1289352830;
        // ---------- Original Method ----------
        //return mSpellCheckInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.859 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8B90B76AD0384481CF5C9DFBCA873D69")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395417630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395417630;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.859 -0400", hash_original_method = "4374405C13E287E9F22B8DE100EB99A0", hash_generated_method = "D6A868E4BA800D91740464B23B852E81")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSpellCheckInProgress ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mSpellCheckInProgress ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.987 -0400", hash_original_method = "8BC137FF3CFAC8D1FC70CD10E3E0E733", hash_generated_method = "3BD2B8DFDDDA9DEFC314D2FB52D349C1")
    @Override
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1766336151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1766336151;
        // ---------- Original Method ----------
        //return TextUtils.SPELL_CHECK_SPAN;
    }

    
}

