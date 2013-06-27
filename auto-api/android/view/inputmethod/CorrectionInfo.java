package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class CorrectionInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.958 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "F358652CEEA6BACE7E593752AA27CBE6")

    private int mOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.958 -0400", hash_original_field = "584DB9839E8990DC7A624740F928A86B", hash_generated_field = "21F81963919AD1B6FEAE170B2FD8DF2A")

    private CharSequence mOldText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.958 -0400", hash_original_field = "E3FE29B0EC2FDC3E4AC20859BAA967E2", hash_generated_field = "919C489EB83DD5B1D70C52520AF2491D")

    private CharSequence mNewText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.958 -0400", hash_original_method = "4BC4C4C6E34B6ABB755CFB5627F6324D", hash_generated_method = "EA69ED117B11915946ED99C129695DDB")
    public  CorrectionInfo(int offset, CharSequence oldText, CharSequence newText) {
        mOffset = offset;
        mOldText = oldText;
        mNewText = newText;
        // ---------- Original Method ----------
        //mOffset = offset;
        //mOldText = oldText;
        //mNewText = newText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.959 -0400", hash_original_method = "ACB844101F7B730F0891325C0B2B59C5", hash_generated_method = "B20EB25A9119C4194DCBE441924D46CF")
    private  CorrectionInfo(Parcel source) {
        mOffset = source.readInt();
        mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        mNewText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //mOffset = source.readInt();
        //mOldText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        //mNewText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.959 -0400", hash_original_method = "FB2FFBF84EFDF3FAC1DB07E1BCD653F5", hash_generated_method = "6A73C13513D16C2C0B2D7ADC62BC8944")
    public int getOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716961783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716961783;
        // ---------- Original Method ----------
        //return mOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.960 -0400", hash_original_method = "B5F6375A5B3C1F7513E2C762D0A387DE", hash_generated_method = "4434E4D114AF27BB7C0BCE5DFB33A60C")
    public CharSequence getOldText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1305512546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1305512546 = mOldText;
        varB4EAC82CA7396A68D541C85D26508E83_1305512546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305512546;
        // ---------- Original Method ----------
        //return mOldText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.960 -0400", hash_original_method = "A44877BB52BDCF0EDD87983832FB9E30", hash_generated_method = "E57892F80A59C1794F0689E31781BBDA")
    public CharSequence getNewText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1826592309 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1826592309 = mNewText;
        varB4EAC82CA7396A68D541C85D26508E83_1826592309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1826592309;
        // ---------- Original Method ----------
        //return mNewText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.961 -0400", hash_original_method = "7D587C528DCE451F3ED32B059F93B063", hash_generated_method = "3E57977F61B8B9C94F8392F7108FA142")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1524851856 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1524851856 = "CorrectionInfo{#" + mOffset + " \"" + mOldText + "\" -> \"" + mNewText + "\"}";
        varB4EAC82CA7396A68D541C85D26508E83_1524851856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1524851856;
        // ---------- Original Method ----------
        //return "CorrectionInfo{#" + mOffset + " \"" + mOldText + "\" -> \"" + mNewText + "\"}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.961 -0400", hash_original_method = "4D2AAA8E4AD44FCBAED8BA48A77A4AE0", hash_generated_method = "671231449B77525163AD7B2EC53AAFEC")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mOffset);
        TextUtils.writeToParcel(mOldText, dest, flags);
        TextUtils.writeToParcel(mNewText, dest, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mOffset);
        //TextUtils.writeToParcel(mOldText, dest, flags);
        //TextUtils.writeToParcel(mNewText, dest, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.961 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D5CCEF069677EE91E8F71133D8209ADA")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391963902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391963902;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:57.961 -0400", hash_original_field = "0802A0FE3EDE98511D93025B888127A6", hash_generated_field = "545C65D572FA367719FAFB5FF700B68D")

    public static final Parcelable.Creator<CorrectionInfo> CREATOR
            = new Parcelable.Creator<CorrectionInfo>() {
        public CorrectionInfo createFromParcel(Parcel source) {
            return new CorrectionInfo(source);
        }

        public CorrectionInfo[] newArray(int size) {
            return new CorrectionInfo[size];
        }
    };
}

