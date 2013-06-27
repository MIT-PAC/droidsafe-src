package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.Uri;
import android.os.Parcelable;
import android.os.Parcel;

public class ContentProviderResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.026 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

    public Uri uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.027 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "F85BE5307E9B96D5B0C722FEC3E9F10D")

    public Integer count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.028 -0400", hash_original_method = "D6E18454D2E4039ABD60A78819D956A0", hash_generated_method = "2F01B12EDA33C4E7EBA32AF6135D8E30")
    public  ContentProviderResult(Uri uri) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri must not be null");
        this.uri = uri;
        this.count = null;
        // ---------- Original Method ----------
        //if (uri == null) throw new IllegalArgumentException("uri must not be null");
        //this.uri = uri;
        //this.count = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.053 -0400", hash_original_method = "5670F9D71891732E7FC99BCF350F686F", hash_generated_method = "AA7EB08A3CDF6F6C603956BBE8C417DA")
    public  ContentProviderResult(int count) {
        this.count = count;
        this.uri = null;
        // ---------- Original Method ----------
        //this.count = count;
        //this.uri = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.054 -0400", hash_original_method = "1A17E80C5D5F7715CF5E56754C18C8A6", hash_generated_method = "45A891647584D44C020EF809F025D15B")
    public  ContentProviderResult(Parcel source) {
        int type;
        type = source.readInt();
        {
            count = source.readInt();
            uri = null;
        } //End block
        {
            count = null;
            uri = Uri.CREATOR.createFromParcel(source);
        } //End block
        // ---------- Original Method ----------
        //int type = source.readInt();
        //if (type == 1) {
            //count = source.readInt();
            //uri = null;
        //} else {
            //count = null;
            //uri = Uri.CREATOR.createFromParcel(source);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.055 -0400", hash_original_method = "9CD6B2E6D05DCE725086FF1495B545F8", hash_generated_method = "04C621D876EF5C5E14440926A4621C34")
    public void writeToParcel(Parcel dest, int flags) {
        {
            dest.writeInt(1);
            dest.writeInt(count);
        } //End block
        {
            dest.writeInt(2);
            uri.writeToParcel(dest, 0);
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //if (uri == null) {
            //dest.writeInt(1);
            //dest.writeInt(count);
        //} else {
            //dest.writeInt(2);
            //uri.writeToParcel(dest, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.056 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2308EFEC5D4C63BF92658ED2098E7AE5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267731606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267731606;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.072 -0400", hash_original_method = "892D2D0BDFABE856512808AB86E3168D", hash_generated_method = "1733A88D7A914C3F9DA17A5B203260D8")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1774359957 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1496929170 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1774359957 = "ContentProviderResult(uri=" + uri.toString() + ")";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1496929170 = "ContentProviderResult(count=" + count + ")";
        String varA7E53CE21691AB073D9660D615818899_1390972298; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1390972298 = varB4EAC82CA7396A68D541C85D26508E83_1774359957;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1390972298 = varB4EAC82CA7396A68D541C85D26508E83_1496929170;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1390972298.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1390972298;
        // ---------- Original Method ----------
        //if (uri != null) {
            //return "ContentProviderResult(uri=" + uri.toString() + ")";
        //}
        //return "ContentProviderResult(count=" + count + ")";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.072 -0400", hash_original_field = "F018B6EF0D315D56317D0DF9DCDA6979", hash_generated_field = "CFE4FC623FC720B7BBEAC41F3A8161D9")

    public static final Creator<ContentProviderResult> CREATOR =
            new Creator<ContentProviderResult>() {
        public ContentProviderResult createFromParcel(Parcel source) {
            return new ContentProviderResult(source);
        }

        public ContentProviderResult[] newArray(int size) {
            return new ContentProviderResult[size];
        }
    };
}

