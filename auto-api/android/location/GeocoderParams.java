package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public class GeocoderParams implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.985 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.986 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.987 -0400", hash_original_method = "6AA13481A09E5725F329ED6947D74643", hash_generated_method = "4E4A64F08F1F24D9E300D4DF6C20E04E")
    private  GeocoderParams() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.988 -0400", hash_original_method = "E27B65887C9418FA89109125506244DE", hash_generated_method = "6DE3CA200355C6BC57CBBF9FD12981D0")
    public  GeocoderParams(Context context, Locale locale) {
        mLocale = locale;
        mPackageName = context.getPackageName();
        // ---------- Original Method ----------
        //mLocale = locale;
        //mPackageName = context.getPackageName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.018 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "DAEB89DDA3EE7C009891ACCC93FE863E")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_283897114 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_283897114 = mLocale;
        varB4EAC82CA7396A68D541C85D26508E83_283897114.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_283897114;
        // ---------- Original Method ----------
        //return mLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.019 -0400", hash_original_method = "1D100AD0503AB463478DA14DEA58A5D8", hash_generated_method = "0A9BDB35B3EFB7DED88895A5A4632C90")
    public String getClientPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1011721695 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1011721695 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_1011721695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011721695;
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.020 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B0D52C91E853C6B5D4B4564D117613CB")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370946004 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370946004;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.043 -0400", hash_original_method = "B02571ABD79129FBD5D7E40D8169B3C2", hash_generated_method = "0820B6FA43C5732F898E56D008BDDA93")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        parcel.writeString(mLocale.getVariant());
        parcel.writeString(mPackageName);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeString(mLocale.getLanguage());
        //parcel.writeString(mLocale.getCountry());
        //parcel.writeString(mLocale.getVariant());
        //parcel.writeString(mPackageName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:18.043 -0400", hash_original_field = "8570E1762A50A570C61281C2FF8E12DF", hash_generated_field = "155F5A7D3EEE4C94F4CF4E96BB87A9DD")

    public static final Parcelable.Creator<GeocoderParams> CREATOR =
        new Parcelable.Creator<GeocoderParams>() {
        public GeocoderParams createFromParcel(Parcel in) {
            GeocoderParams gp = new GeocoderParams();
            String language = in.readString();
            String country = in.readString();
            String variant = in.readString();
            gp.mLocale = new Locale(language, country, variant);
            gp.mPackageName = in.readString();
            return gp;
        }

        public GeocoderParams[] newArray(int size) {
            return new GeocoderParams[size];
        }
    };
}

