package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;





public class Annotation implements ParcelableSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.064 -0500", hash_original_field = "4666685C3669B68C1BDAE5D25D295D9D", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private  String mKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.068 -0500", hash_original_field = "1160D21D7F9CB66571466142BB3983BB", hash_generated_field = "FA33B8039DB7AC1B219DF637773A1B0E")

    private  String mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.071 -0500", hash_original_method = "5C517E50CA4FB031ECF94CDBC8F3DBD0", hash_generated_method = "50917E9E0646276629A5B13A0A3EF412")
    
public Annotation(String key, String value) {
        mKey = key;
        mValue = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.073 -0500", hash_original_method = "C131D9D20BBD02754AB0621772B33421", hash_generated_method = "158C59F3E8D982FE475098943EB2FE6D")
    
public Annotation(Parcel src) {
        mKey = src.readString();
        mValue = src.readString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.076 -0500", hash_original_method = "4B5D387D9B07EBC2B6CC4E1F3474D3AE", hash_generated_method = "A700127CFF2C5288EB40F7C71DF026B6")
    
public int getSpanTypeId() {
        return TextUtils.ANNOTATION;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.078 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.081 -0500", hash_original_method = "5E98CA8EC4399E1C3E6F7EE2C72DE36F", hash_generated_method = "43CF9B28544DD66AC37BE4AF255A20DB")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mKey);
        dest.writeString(mValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.084 -0500", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "514BD3D6C2A52F2979AA1634D452B51C")
    
public String getKey() {
        return mKey;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:15.086 -0500", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "A248978541C494C9EDC5F8C81B52BA84")
    
public String getValue() {
        return mValue;
    }

    
}

