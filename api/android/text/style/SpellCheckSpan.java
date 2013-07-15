package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;

public class SpellCheckSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.278 -0400", hash_original_field = "2CD5FC4A7984A2B11D32D28D974733BE", hash_generated_field = "CD03D035E3A34C62C050AB1056925600")

    private boolean mSpellCheckInProgress;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.278 -0400", hash_original_method = "F1D4E96290AC8C7754627E362363B9DA", hash_generated_method = "26BD444D89119A2293FF0670908802DE")
    public  SpellCheckSpan() {
        mSpellCheckInProgress = false;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.279 -0400", hash_original_method = "9BB9BE3CC699053708AEB172BEE11085", hash_generated_method = "612B7223728EBFB58F40A6C5D42F0175")
    public  SpellCheckSpan(Parcel src) {
        mSpellCheckInProgress = (src.readInt() != 0);
        // ---------- Original Method ----------
        //mSpellCheckInProgress = (src.readInt() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.279 -0400", hash_original_method = "712093FDA6926C8B5E44D517F24CE2ED", hash_generated_method = "7790FF52440767842592CC146F06EEF2")
    public void setSpellCheckInProgress(boolean inProgress) {
        mSpellCheckInProgress = inProgress;
        // ---------- Original Method ----------
        //mSpellCheckInProgress = inProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.279 -0400", hash_original_method = "DF88C425EC6702745B81C07A898C5194", hash_generated_method = "DC9C45346AB7DA21FA63901D5536E134")
    public boolean isSpellCheckInProgress() {
        boolean var2CD5FC4A7984A2B11D32D28D974733BE_1513344906 = (mSpellCheckInProgress);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295334060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295334060;
        // ---------- Original Method ----------
        //return mSpellCheckInProgress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.280 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1EB5211ACBB32D04FFA443E5A61CA753")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1573085472 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616837343 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1616837343;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.280 -0400", hash_original_method = "4374405C13E287E9F22B8DE100EB99A0", hash_generated_method = "448EE4D4692C1BFEBF526385C12DC1A0")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mSpellCheckInProgress ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeInt(mSpellCheckInProgress ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.280 -0400", hash_original_method = "8BC137FF3CFAC8D1FC70CD10E3E0E733", hash_generated_method = "A9122AACE9CAC4107FCF31D7ABBDBF78")
    @Override
    public int getSpanTypeId() {
        int var79FCCBCEF5901E6D092D46C1EE251DAE_1397076291 = (TextUtils.SPELL_CHECK_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198195379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198195379;
        // ---------- Original Method ----------
        //return TextUtils.SPELL_CHECK_SPAN;
    }

    
}

