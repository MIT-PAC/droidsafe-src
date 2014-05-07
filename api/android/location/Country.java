package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.520 -0500", hash_original_field = "AEC0DD2E1091B824A6C9D8C63E13BCDD", hash_generated_field = "92DDDD9D36EEE5E4A82A6D2A8125DA06")

    public static final int COUNTRY_SOURCE_NETWORK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.522 -0500", hash_original_field = "857D3933BC1A9161CC912D2D2324872F", hash_generated_field = "E621B42B3BCFCE5A4BEE8EF55832C00E")

    public static final int COUNTRY_SOURCE_LOCATION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.525 -0500", hash_original_field = "B97A22D5AA44E7CB4B36ACF1668018DD", hash_generated_field = "6DEBAD6B9569D1A6DA2BAF807389E01A")

    public static final int COUNTRY_SOURCE_SIM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.527 -0500", hash_original_field = "E2FE7516600A87279F3AEA0831EA1661", hash_generated_field = "8DD0E261E5B0CC34B2FBFF0101C7083A")

    public static final int COUNTRY_SOURCE_LOCALE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.923 -0400", hash_original_field = "48FE3108061C8FB14165724DC6609E10", hash_generated_field = "2CCF073B8A235B66F6A4E81108680C92")

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.547 -0500", hash_original_method = "062ED6F072D371D548C69ADA6C3CEA1B", hash_generated_method = "4F690E3F27FC9ACEBAFFB68E1F795670")
        
public Country createFromParcel(Parcel in) {
            return new Country(in.readString(), in.readInt());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.550 -0500", hash_original_method = "DCB9C4FC05104CFCD2DE5AB98C4AFE87", hash_generated_method = "02153A23FAB368E218EAB0165D5BE7FA")
        
public Country[] newArray(int size) {
            return new Country[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.529 -0500", hash_original_field = "FE7E6816F59111E17355050C7EE545FA", hash_generated_field = "A4787DDEE2CB6821D6A9300F5DB86C40")

    private  String mCountryIso;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.533 -0500", hash_original_field = "11DA1CE39E46044FC7D0DA0865E06F43", hash_generated_field = "D564CAA4C2DB0DC0AAAD32F1767ED66A")

    private  int mSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.535 -0500", hash_original_field = "A13152B9FE22A291FA8BF7E71C005049", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    /**
     *
     * @param countryIso the ISO 3166-1 two letters country code.
     * @param source where the countryIso came from, could be one of below
     *        values
     *        <p>
     *        <ul>
     *        <li>{@link #COUNTRY_SOURCE_NETWORK}</li>
     *        <li>{@link #COUNTRY_SOURCE_LOCATION}</li>
     *        <li>{@link #COUNTRY_SOURCE_SIM}</li>
     *        <li>{@link #COUNTRY_SOURCE_LOCALE}</li>
     *        </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.537 -0500", hash_original_method = "180A74FA9B2C94F60E7E0D1924EE6005", hash_generated_method = "083C4539ABFBC136A42B157FC2D8856A")
    
public Country(final String countryIso, final int source) {
        if (countryIso == null || source < COUNTRY_SOURCE_NETWORK
                || source > COUNTRY_SOURCE_LOCALE) {
            throw new IllegalArgumentException();
        }
        mCountryIso = countryIso.toUpperCase(Locale.US);
        mSource = source;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.540 -0500", hash_original_method = "E5422BF754D1EEFE24F783DEE0DEB6C8", hash_generated_method = "31998D31EDE42B51D57A302AE292AABA")
    
public Country(Country country) {
        mCountryIso = country.mCountryIso;
        mSource = country.mSource;
    }

    /**
     * @return the ISO 3166-1 two letters country code
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.542 -0500", hash_original_method = "5F3223376651F8BE6A8AF3345618A060", hash_generated_method = "FE03559B487B253CD88FB05A6271FD9E")
    
public final String getCountryIso() {
        return mCountryIso;
    }

    /**
     * @return where the country code came from, could be one of below values
     *         <p>
     *         <ul>
     *         <li>{@link #COUNTRY_SOURCE_NETWORK}</li>
     *         <li>{@link #COUNTRY_SOURCE_LOCATION}</li>
     *         <li>{@link #COUNTRY_SOURCE_SIM}</li>
     *         <li>{@link #COUNTRY_SOURCE_LOCALE}</li>
     *         </ul>
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.544 -0500", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "140E77934072FF233DC1E12178DC3B39")
    
public final int getSource() {
        return mSource;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.554 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.557 -0500", hash_original_method = "FCA327E6B3FDBBC7798ED2309FF9DDE2", hash_generated_method = "EA466C23B98FC3A204659CA41954B808")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mCountryIso);
        parcel.writeInt(mSource);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.559 -0500", hash_original_method = "A4E8BAE44F340138225E9939A030C872", hash_generated_method = "7951D731103527902A8E33B3D2E36AC9")
    
@Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Country) {
            Country c = (Country) object;
            return mCountryIso.equals(c.getCountryIso()) && mSource == c.getSource();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.561 -0500", hash_original_method = "B421DD13AECD8D681C930C2BD9632735", hash_generated_method = "BBA12A447AFEF1E2DAC9E9CD2149A577")
    
@Override
    public int hashCode() {
        int hash = mHashCode;
        if (hash == 0) {
            hash = 17;
            hash = hash * 13 + mCountryIso.hashCode();
            hash = hash * 13 + mSource;
            mHashCode = hash;
        }
        return mHashCode;
    }

    /**
     * Compare the specified country to this country object ignoring the mSource
     * field, return true if the countryIso fields are equal
     *
     * @param country the country to compare
     * @return true if the specified country's countryIso field is equal to this
     *         country's, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.564 -0500", hash_original_method = "1D459D842605CA34811091FC29FDA2D4", hash_generated_method = "8821A1AED5D498E9724C6CD02B3F85B9")
    
public boolean equalsIgnoreSource(Country country) {
        return country != null && mCountryIso.equals(country.getCountryIso());
    }
    // orphaned legacy method
    public Country createFromParcel(Parcel in) {
            return new Country(in.readString(), in.readInt());
        }
    
    // orphaned legacy method
    public Country[] newArray(int size) {
            return new Country[size];
        }
    
}

