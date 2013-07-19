package android.text;

// Droidsafe Imports
import android.os.Parcel;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Annotation implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.374 -0400", hash_original_field = "7E690C9CC141370A5EC6E7A98DC6FF62", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.374 -0400", hash_original_field = "CBAFE11E7BAE23358D70D54D132C3064", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private String mValue;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.375 -0400", hash_original_method = "5C517E50CA4FB031ECF94CDBC8F3DBD0", hash_generated_method = "D01E642451DA9153C6330C1E5A2AA584")
    public  Annotation(String key, String value) {
        mKey = key;
        mValue = value;
        // ---------- Original Method ----------
        //mKey = key;
        //mValue = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.376 -0400", hash_original_method = "C131D9D20BBD02754AB0621772B33421", hash_generated_method = "26B358E42EFE096E6E83C377C90A9476")
    public  Annotation(Parcel src) {
        mKey = src.readString();
        mValue = src.readString();
        // ---------- Original Method ----------
        //mKey = src.readString();
        //mValue = src.readString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.376 -0400", hash_original_method = "4B5D387D9B07EBC2B6CC4E1F3474D3AE", hash_generated_method = "07CC1AA8045E21BB9D1ECFE0C89F8CAC")
    public int getSpanTypeId() {
        int var3541C98393BE70256A1600A4412AFC14_2502081 = (TextUtils.ANNOTATION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830901844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830901844;
        // ---------- Original Method ----------
        //return TextUtils.ANNOTATION;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.376 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5A1F342A306B89A5AF6DCA3006AF7443")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2146297747 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707623242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707623242;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.377 -0400", hash_original_method = "5E98CA8EC4399E1C3E6F7EE2C72DE36F", hash_generated_method = "D9BB75ADA6848B2BE840CEA3952341E7")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.377 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "8C9EC21F5B53E16A5497E79B3A2BF6BB")
    public String getKey() {
String var79CD36FEA8F0B12D4023EF117F6A9A00_752362146 =         mKey;
        var79CD36FEA8F0B12D4023EF117F6A9A00_752362146.addTaint(taint);
        return var79CD36FEA8F0B12D4023EF117F6A9A00_752362146;
        // ---------- Original Method ----------
        //return mKey;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.378 -0400", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "2E32D19D213D149788657F739700A569")
    public String getValue() {
String varD1FEA3F5EE4618A9C3646312F018E4AC_1121696202 =         mValue;
        varD1FEA3F5EE4618A9C3646312F018E4AC_1121696202.addTaint(taint);
        return varD1FEA3F5EE4618A9C3646312F018E4AC_1121696202;
        // ---------- Original Method ----------
        //return mValue;
    }

    
}

