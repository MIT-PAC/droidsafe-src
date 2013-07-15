package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;

public class Annotation implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.701 -0400", hash_original_field = "7E690C9CC141370A5EC6E7A98DC6FF62", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.702 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private String mValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.703 -0400", hash_original_method = "5C517E50CA4FB031ECF94CDBC8F3DBD0", hash_generated_method = "D01E642451DA9153C6330C1E5A2AA584")
    public  Annotation(String key, String value) {
        mKey = key;
        mValue = value;
        // ---------- Original Method ----------
        //mKey = key;
        //mValue = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.704 -0400", hash_original_method = "C131D9D20BBD02754AB0621772B33421", hash_generated_method = "26B358E42EFE096E6E83C377C90A9476")
    public  Annotation(Parcel src) {
        mKey = src.readString();
        mValue = src.readString();
        // ---------- Original Method ----------
        //mKey = src.readString();
        //mValue = src.readString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.704 -0400", hash_original_method = "4B5D387D9B07EBC2B6CC4E1F3474D3AE", hash_generated_method = "3D418974F10C44B68FF2628BD6ACEF28")
    public int getSpanTypeId() {
        int var3541C98393BE70256A1600A4412AFC14_840905849 = (TextUtils.ANNOTATION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571180795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571180795;
        // ---------- Original Method ----------
        //return TextUtils.ANNOTATION;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.705 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BD09C9AFAB472701C50B201853B0E5FC")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1441703063 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624595056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_624595056;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.706 -0400", hash_original_method = "5E98CA8EC4399E1C3E6F7EE2C72DE36F", hash_generated_method = "D9BB75ADA6848B2BE840CEA3952341E7")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mKey);
        dest.writeString(mValue);
        // ---------- Original Method ----------
        //dest.writeString(mKey);
        //dest.writeString(mValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.706 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "850BEB7A6D522D808FFE2FAC09874BF1")
    public String getKey() {
String var79CD36FEA8F0B12D4023EF117F6A9A00_158336419 =         mKey;
        var79CD36FEA8F0B12D4023EF117F6A9A00_158336419.addTaint(taint);
        return var79CD36FEA8F0B12D4023EF117F6A9A00_158336419;
        // ---------- Original Method ----------
        //return mKey;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.706 -0400", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "AA3D5748985F94068D44D68681968640")
    public String getValue() {
String varD1FEA3F5EE4618A9C3646312F018E4AC_1041065069 =         mValue;
        varD1FEA3F5EE4618A9C3646312F018E4AC_1041065069.addTaint(taint);
        return varD1FEA3F5EE4618A9C3646312F018E4AC_1041065069;
        // ---------- Original Method ----------
        //return mValue;
    }

    
}

