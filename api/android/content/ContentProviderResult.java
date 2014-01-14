package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class ContentProviderResult implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.102 -0400", hash_original_field = "F018B6EF0D315D56317D0DF9DCDA6979", hash_generated_field = "CFE4FC623FC720B7BBEAC41F3A8161D9")

    public static final Creator<ContentProviderResult> CREATOR =
            new Creator<ContentProviderResult>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.026 -0500", hash_original_method = "0C8258457979985FA0D5E299A051E461", hash_generated_method = "1F82CDEB48A42374AD4E4DED63387DEB")
        
public ContentProviderResult createFromParcel(Parcel source) {
            return new ContentProviderResult(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.028 -0500", hash_original_method = "5088D34CAD75AD433E47CE2C22D5303F", hash_generated_method = "910AA34B81A606965877BC56897E587F")
        
public ContentProviderResult[] newArray(int size) {
            return new ContentProviderResult[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.009 -0500", hash_original_field = "F30A3503738FDB118E2076C7F22FF172", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

    public  Uri uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.011 -0500", hash_original_field = "A5D0B1C028B755945F5DBF238139CFF8", hash_generated_field = "F85BE5307E9B96D5B0C722FEC3E9F10D")

    public  Integer count;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.013 -0500", hash_original_method = "D6E18454D2E4039ABD60A78819D956A0", hash_generated_method = "19D349256280893D207984CAC84545A2")
    
public ContentProviderResult(Uri uri) {
        if (uri == null) throw new IllegalArgumentException("uri must not be null");
        this.uri = uri;
        this.count = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.016 -0500", hash_original_method = "5670F9D71891732E7FC99BCF350F686F", hash_generated_method = "1B443DB134CA5F5FEBBE60F472AD7EC9")
    
public ContentProviderResult(int count) {
        this.count = count;
        this.uri = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.019 -0500", hash_original_method = "1A17E80C5D5F7715CF5E56754C18C8A6", hash_generated_method = "B100772DFA30699206854EEB061672A3")
    
public ContentProviderResult(Parcel source) {
        int type = source.readInt();
        if (type == 1) {
            count = source.readInt();
            uri = null;
        } else {
            count = null;
            uri = Uri.CREATOR.createFromParcel(source);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.021 -0500", hash_original_method = "9CD6B2E6D05DCE725086FF1495B545F8", hash_generated_method = "CE8FF229D3F429077C3F103CC7EC30FE")
    
public void writeToParcel(Parcel dest, int flags) {
        if (uri == null) {
            dest.writeInt(1);
            dest.writeInt(count);
        } else {
            dest.writeInt(2);
            uri.writeToParcel(dest, 0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.023 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:37.033 -0500", hash_original_method = "892D2D0BDFABE856512808AB86E3168D", hash_generated_method = "C3D4B8EAC4CC3E860B01088872CFE1E5")
    
public String toString() {
        if (uri != null) {
            return "ContentProviderResult(uri=" + uri.toString() + ")";
        }
        return "ContentProviderResult(count=" + count + ")";
    }
    // orphaned legacy method
    public ContentProviderResult createFromParcel(Parcel source) {
            return new ContentProviderResult(source);
        }
    
    // orphaned legacy method
    public ContentProviderResult[] newArray(int size) {
            return new ContentProviderResult[size];
        }
    
}

