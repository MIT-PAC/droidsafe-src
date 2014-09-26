package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class GeocoderParams implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.094 -0400", hash_original_field = "8570E1762A50A570C61281C2FF8E12DF", hash_generated_field = "155F5A7D3EEE4C94F4CF4E96BB87A9DD")

    public static final Parcelable.Creator<GeocoderParams> CREATOR =
        new Parcelable.Creator<GeocoderParams>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.643 -0500", hash_original_method = "5BB7C3731AFCBE3C98518839DE06C7C6", hash_generated_method = "FE30200ABAAC02C5AB703BF15D44730E")
        
public GeocoderParams createFromParcel(Parcel in) {
            GeocoderParams gp = new GeocoderParams();
            String language = in.readString();
            String country = in.readString();
            String variant = in.readString();
            gp.mLocale = new Locale(language, country, variant);
            gp.mPackageName = in.readString();
            return gp;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.645 -0500", hash_original_method = "61AEAF94E13F0EC536A398851C924871", hash_generated_method = "E92BDBCCBEBEFD28A78F5FD932B1F007")
        
public GeocoderParams[] newArray(int size) {
            return new GeocoderParams[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.628 -0500", hash_original_field = "D959780368C6CA232CF8C3906CDDEDF3", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.630 -0500", hash_original_field = "7A5990DF4A54BF373C395B6501E20B02", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;

    // used only for parcelling
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.632 -0500", hash_original_method = "6AA13481A09E5725F329ED6947D74643", hash_generated_method = "C263E3A863BA6E7AAC4F2F56CD08B269")
    
private GeocoderParams() {
    }

    /**
     * This object is only constructed by the Geocoder class
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.635 -0500", hash_original_method = "E27B65887C9418FA89109125506244DE", hash_generated_method = "C0EBA0A96B7D50D39A4319F2C61949A8")
    
public GeocoderParams(Context context, Locale locale) {
        mLocale = locale;
        mPackageName = context.getPackageName();
    }

    /**
     * returns the Geocoder's locale
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.637 -0500", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "A1D784B67B002754E37DDB902EBC5ECA")
    
public Locale getLocale() {
        return mLocale;
    }

    /**
     * returns the package name of the Geocoder's client
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.639 -0500", hash_original_method = "1D100AD0503AB463478DA14DEA58A5D8", hash_generated_method = "BB49A55CA21AD4F9D20F8C5BD4864262")
    
public String getClientPackage() {
        return mPackageName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.650 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:00.653 -0500", hash_original_method = "B02571ABD79129FBD5D7E40D8169B3C2", hash_generated_method = "5B4D21BD14933F3F00B7129084FC0058")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        parcel.writeString(mLocale.getVariant());
        parcel.writeString(mPackageName);
    }
    // orphaned legacy method
    public GeocoderParams createFromParcel(Parcel in) {
            GeocoderParams gp = new GeocoderParams();
            String language = in.readString();
            String country = in.readString();
            String variant = in.readString();
            gp.mLocale = new Locale(language, country, variant);
            gp.mPackageName = in.readString();
            return gp;
        }
    
    // orphaned legacy method
    public GeocoderParams[] newArray(int size) {
            return new GeocoderParams[size];
        }
    
}

