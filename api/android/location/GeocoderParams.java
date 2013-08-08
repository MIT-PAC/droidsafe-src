package android.location;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;





public class GeocoderParams implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.087 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.088 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.088 -0400", hash_original_method = "6AA13481A09E5725F329ED6947D74643", hash_generated_method = "4E4A64F08F1F24D9E300D4DF6C20E04E")
    private  GeocoderParams() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.090 -0400", hash_original_method = "E27B65887C9418FA89109125506244DE", hash_generated_method = "6DE3CA200355C6BC57CBBF9FD12981D0")
    public  GeocoderParams(Context context, Locale locale) {
        mLocale = locale;
        mPackageName = context.getPackageName();
        // ---------- Original Method ----------
        //mLocale = locale;
        //mPackageName = context.getPackageName();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.090 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "2F14296E7E4A52100F9D852C5C100F40")
    public Locale getLocale() {
Locale varD4470AF088C85BDC4D13A941A003DD34_1497316478 =         mLocale;
        varD4470AF088C85BDC4D13A941A003DD34_1497316478.addTaint(taint);
        return varD4470AF088C85BDC4D13A941A003DD34_1497316478;
        // ---------- Original Method ----------
        //return mLocale;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.091 -0400", hash_original_method = "1D100AD0503AB463478DA14DEA58A5D8", hash_generated_method = "9EE063D267FB582E10430E723F71FD8C")
    public String getClientPackage() {
String var5601F77C1E784C31FA233AB799182FA6_1988991985 =         mPackageName;
        var5601F77C1E784C31FA233AB799182FA6_1988991985.addTaint(taint);
        return var5601F77C1E784C31FA233AB799182FA6_1988991985;
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.092 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7B27E1F88A19D03A6454DA53144A4360")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_906781075 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429847729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429847729;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.094 -0400", hash_original_method = "B02571ABD79129FBD5D7E40D8169B3C2", hash_generated_method = "5D99D76CB0FE42E0D5A546C6D46F0B4B")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        parcel.writeString(mLocale.getVariant());
        parcel.writeString(mPackageName);
        // ---------- Original Method ----------
        //parcel.writeString(mLocale.getLanguage());
        //parcel.writeString(mLocale.getCountry());
        //parcel.writeString(mLocale.getVariant());
        //parcel.writeString(mPackageName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.094 -0400", hash_original_field = "8570E1762A50A570C61281C2FF8E12DF", hash_generated_field = "155F5A7D3EEE4C94F4CF4E96BB87A9DD")

    public static final Parcelable.Creator<GeocoderParams> CREATOR =
        new Parcelable.Creator<GeocoderParams>() {
        @DSModeled(DSC.BAN)
        public GeocoderParams createFromParcel(Parcel in) {
            GeocoderParams gp = new GeocoderParams();
            String language = in.readString();
            String country = in.readString();
            String variant = in.readString();
            gp.mLocale = new Locale(language, country, variant);
            gp.mPackageName = in.readString();
            return gp;
        }

        @DSModeled(DSC.BAN)
        public GeocoderParams[] newArray(int size) {
            return new GeocoderParams[size];
        }
    };
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

