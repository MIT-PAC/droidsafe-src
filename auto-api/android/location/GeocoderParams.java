package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public class GeocoderParams implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.243 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.243 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.244 -0400", hash_original_method = "6AA13481A09E5725F329ED6947D74643", hash_generated_method = "4E4A64F08F1F24D9E300D4DF6C20E04E")
    private  GeocoderParams() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.244 -0400", hash_original_method = "E27B65887C9418FA89109125506244DE", hash_generated_method = "6DE3CA200355C6BC57CBBF9FD12981D0")
    public  GeocoderParams(Context context, Locale locale) {
        mLocale = locale;
        mPackageName = context.getPackageName();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.245 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "BDF0AD892EE84DA6B5E9D9066AE06F8F")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1169682137 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1169682137 = mLocale;
        varB4EAC82CA7396A68D541C85D26508E83_1169682137.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1169682137;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.245 -0400", hash_original_method = "1D100AD0503AB463478DA14DEA58A5D8", hash_generated_method = "8A536B9B62A0210ABE3BD78A627D9B0D")
    public String getClientPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1604319787 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1604319787 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_1604319787.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1604319787;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.246 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EA4BA20476297900614DA5DBCD6B5589")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531109004 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531109004;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.246 -0400", hash_original_method = "B02571ABD79129FBD5D7E40D8169B3C2", hash_generated_method = "0820B6FA43C5732F898E56D008BDDA93")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        parcel.writeString(mLocale.getVariant());
        parcel.writeString(mPackageName);
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.246 -0400", hash_original_field = "8570E1762A50A570C61281C2FF8E12DF", hash_generated_field = "155F5A7D3EEE4C94F4CF4E96BB87A9DD")

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
    
}

