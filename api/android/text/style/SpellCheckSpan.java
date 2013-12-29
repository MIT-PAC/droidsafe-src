package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextUtils;





public class SpellCheckSpan implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.810 -0500", hash_original_field = "084B0C868B1F8BD7E3BE83E6B71E75D7", hash_generated_field = "CD03D035E3A34C62C050AB1056925600")


    private boolean mSpellCheckInProgress;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.811 -0500", hash_original_method = "F1D4E96290AC8C7754627E362363B9DA", hash_generated_method = "312C28E8749A7E188B801215CF7716D6")
    public SpellCheckSpan() {
        mSpellCheckInProgress = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.812 -0500", hash_original_method = "9BB9BE3CC699053708AEB172BEE11085", hash_generated_method = "41A090A41E901AC537DECBBCA35AA278")
    public SpellCheckSpan(Parcel src) {
        mSpellCheckInProgress = (src.readInt() != 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.812 -0500", hash_original_method = "712093FDA6926C8B5E44D517F24CE2ED", hash_generated_method = "324125E7FB933C86372919A4522CE772")
    public void setSpellCheckInProgress(boolean inProgress) {
        mSpellCheckInProgress = inProgress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.813 -0500", hash_original_method = "DF88C425EC6702745B81C07A898C5194", hash_generated_method = "1A353917CBE465CDA9B6B2EE4E80CC0F")
    public boolean isSpellCheckInProgress() {
        return mSpellCheckInProgress;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.814 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    @Override
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.815 -0500", hash_original_method = "4374405C13E287E9F22B8DE100EB99A0", hash_generated_method = "F3587621251199042C93B6CF48312F2D")
    @Override
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSpellCheckInProgress ? 1 : 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:51.816 -0500", hash_original_method = "8BC137FF3CFAC8D1FC70CD10E3E0E733", hash_generated_method = "707A5D23ABAB90A54C1D8C1E36C59126")
    @Override
public int getSpanTypeId() {
        return TextUtils.SPELL_CHECK_SPAN;
    }

    
}

