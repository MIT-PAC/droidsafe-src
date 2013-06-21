package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public class Country implements Parcelable {
    private String mCountryIso;
    private int mSource;
    private int mHashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.512 -0400", hash_original_method = "180A74FA9B2C94F60E7E0D1924EE6005", hash_generated_method = "043B7E89F07DCAF2EC7D95DE6FF8A11B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Country(final String countryIso, final int source) {
        dsTaint.addTaint(source);
        dsTaint.addTaint(countryIso);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        mCountryIso = countryIso.toUpperCase(Locale.US);
        // ---------- Original Method ----------
        //if (countryIso == null || source < COUNTRY_SOURCE_NETWORK
                //|| source > COUNTRY_SOURCE_LOCALE) {
            //throw new IllegalArgumentException();
        //}
        //mCountryIso = countryIso.toUpperCase(Locale.US);
        //mSource = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.512 -0400", hash_original_method = "E5422BF754D1EEFE24F783DEE0DEB6C8", hash_generated_method = "431797570E50F75EAD020CA04FBD4C0A")
    @DSModeled(DSC.SAFE)
    public Country(Country country) {
        dsTaint.addTaint(country.dsTaint);
        mCountryIso = country.mCountryIso;
        mSource = country.mSource;
        // ---------- Original Method ----------
        //mCountryIso = country.mCountryIso;
        //mSource = country.mSource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.513 -0400", hash_original_method = "5F3223376651F8BE6A8AF3345618A060", hash_generated_method = "47419400A931D2C87A584AC1DE1D2C87")
    @DSModeled(DSC.SAFE)
    public final String getCountryIso() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCountryIso;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.513 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "826CFACE410D87DBD371F08661BCB2B6")
    @DSModeled(DSC.SAFE)
    public final int getSource() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.513 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.513 -0400", hash_original_method = "FCA327E6B3FDBBC7798ED2309FF9DDE2", hash_generated_method = "6B5B3DCC854562628507DE9F400B4BCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeString(mCountryIso);
        parcel.writeInt(mSource);
        // ---------- Original Method ----------
        //parcel.writeString(mCountryIso);
        //parcel.writeInt(mSource);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.514 -0400", hash_original_method = "A4E8BAE44F340138225E9939A030C872", hash_generated_method = "60D2465802622741DE62087EB5653429")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var3F549205D4C262003697A031F89E5954_20270040 = (object == this);
        } //End collapsed parenthetic
        {
            Country c;
            c = (Country) object;
            boolean var5D7043958EF95E0F56528FF7D9B5EEB9_771631852 = (mCountryIso.equals(c.getCountryIso()) && mSource == c.getSource());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (object == this) {
            //return true;
        //}
        //if (object instanceof Country) {
            //Country c = (Country) object;
            //return mCountryIso.equals(c.getCountryIso()) && mSource == c.getSource();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.514 -0400", hash_original_method = "B421DD13AECD8D681C930C2BD9632735", hash_generated_method = "E3076C5C37C92D3836B326DB86BEA7A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int hash;
        hash = mHashCode;
        {
            hash = 17;
            hash = hash * 13 + mCountryIso.hashCode();
            hash = hash * 13 + mSource;
            mHashCode = hash;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hash = mHashCode;
        //if (hash == 0) {
            //hash = 17;
            //hash = hash * 13 + mCountryIso.hashCode();
            //hash = hash * 13 + mSource;
            //mHashCode = hash;
        //}
        //return mHashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.522 -0400", hash_original_method = "1D459D842605CA34811091FC29FDA2D4", hash_generated_method = "B5052467D34EF1B6ED8C1176FBB9A869")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equalsIgnoreSource(Country country) {
        dsTaint.addTaint(country.dsTaint);
        boolean varD619BC2A0E08DE4307B63AC091555062_1725232570 = (country != null && mCountryIso.equals(country.getCountryIso()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return country != null && mCountryIso.equals(country.getCountryIso());
    }

    
    public static final int COUNTRY_SOURCE_NETWORK = 0;
    public static final int COUNTRY_SOURCE_LOCATION = 1;
    public static final int COUNTRY_SOURCE_SIM = 2;
    public static final int COUNTRY_SOURCE_LOCALE = 3;
    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.524 -0400", hash_original_method = "062ED6F072D371D548C69ADA6C3CEA1B", hash_generated_method = "3E3FB2AE89BF209813CF7F02580E7A9E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Country createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Country var3F33341C47FCE822B18708DAA2882BE9_1530147789 = (new Country(in.readString(), in.readInt()));
            return (Country)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Country(in.readString(), in.readInt());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.525 -0400", hash_original_method = "DCB9C4FC05104CFCD2DE5AB98C4AFE87", hash_generated_method = "48A7D58F8E39F77272836E0EFFE222B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Country[] newArray(int size) {
            dsTaint.addTaint(size);
            Country[] varC7380F5F70BDA6EB736A24284779BA17_681545722 = (new Country[size]);
            return (Country[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Country[size];
        }

        
}; //Transformed anonymous class
}

