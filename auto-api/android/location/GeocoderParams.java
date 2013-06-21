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
    private Locale mLocale;
    private String mPackageName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.572 -0400", hash_original_method = "6AA13481A09E5725F329ED6947D74643", hash_generated_method = "4E4A64F08F1F24D9E300D4DF6C20E04E")
    @DSModeled(DSC.SAFE)
    private GeocoderParams() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.573 -0400", hash_original_method = "E27B65887C9418FA89109125506244DE", hash_generated_method = "E0532ED376E92841F4D404923FD03718")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeocoderParams(Context context, Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mPackageName = context.getPackageName();
        // ---------- Original Method ----------
        //mLocale = locale;
        //mPackageName = context.getPackageName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.573 -0400", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "86D85F4533F23F6C8349F9F12D00A3F1")
    @DSModeled(DSC.SAFE)
    public Locale getLocale() {
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.573 -0400", hash_original_method = "1D100AD0503AB463478DA14DEA58A5D8", hash_generated_method = "0A7F0DBA8343DA95EC4FB2C67A9EDF5E")
    @DSModeled(DSC.SAFE)
    public String getClientPackage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.573 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.574 -0400", hash_original_method = "B02571ABD79129FBD5D7E40D8169B3C2", hash_generated_method = "4772FC88E38A3724106DD8507EEE22ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
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

    
    public static final Parcelable.Creator<GeocoderParams> CREATOR = new Parcelable.Creator<GeocoderParams>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.574 -0400", hash_original_method = "5BB7C3731AFCBE3C98518839DE06C7C6", hash_generated_method = "9FF91A732B9F4FD621DDCA9E2E507243")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public GeocoderParams createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            GeocoderParams gp;
            gp = new GeocoderParams();
            String language;
            language = in.readString();
            String country;
            country = in.readString();
            String variant;
            variant = in.readString();
            gp.mLocale = new Locale(language, country, variant);
            gp.mPackageName = in.readString();
            return (GeocoderParams)dsTaint.getTaint();
            // ---------- Original Method ----------
            //GeocoderParams gp = new GeocoderParams();
            //String language = in.readString();
            //String country = in.readString();
            //String variant = in.readString();
            //gp.mLocale = new Locale(language, country, variant);
            //gp.mPackageName = in.readString();
            //return gp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.574 -0400", hash_original_method = "61AEAF94E13F0EC536A398851C924871", hash_generated_method = "DE21CFE56666492CD1F5FE7BA5B67BEA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public GeocoderParams[] newArray(int size) {
            dsTaint.addTaint(size);
            GeocoderParams[] var543AF91DBEAA49CC28C951D7C9EBDC22_549956012 = (new GeocoderParams[size]);
            return (GeocoderParams[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GeocoderParams[size];
        }

        
}; //Transformed anonymous class
}

