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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.929 -0400", hash_original_field = "C7E1D84BBBBD6E2342AD8875187F4659", hash_generated_field = "A4787DDEE2CB6821D6A9300F5DB86C40")

    private String mCountryIso;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.929 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "D564CAA4C2DB0DC0AAAD32F1767ED66A")

    private int mSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.929 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.931 -0400", hash_original_method = "180A74FA9B2C94F60E7E0D1924EE6005", hash_generated_method = "5F63E8D487E9A7B97A8E0BFB5D9A0BC2")
    public  Country(final String countryIso, final int source) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        mCountryIso = countryIso.toUpperCase(Locale.US);
        mSource = source;
        // ---------- Original Method ----------
        //if (countryIso == null || source < COUNTRY_SOURCE_NETWORK
                //|| source > COUNTRY_SOURCE_LOCALE) {
            //throw new IllegalArgumentException();
        //}
        //mCountryIso = countryIso.toUpperCase(Locale.US);
        //mSource = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.931 -0400", hash_original_method = "E5422BF754D1EEFE24F783DEE0DEB6C8", hash_generated_method = "93FC7471C9A9942792321C1DF9B6A336")
    public  Country(Country country) {
        mCountryIso = country.mCountryIso;
        mSource = country.mSource;
        // ---------- Original Method ----------
        //mCountryIso = country.mCountryIso;
        //mSource = country.mSource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.932 -0400", hash_original_method = "5F3223376651F8BE6A8AF3345618A060", hash_generated_method = "C78CB9E025EC8E01C84F1B1AE5AD85D6")
    public final String getCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_485162760 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_485162760 = mCountryIso;
        varB4EAC82CA7396A68D541C85D26508E83_485162760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_485162760;
        // ---------- Original Method ----------
        //return mCountryIso;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.932 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "C8331F7ECA5F5C28BC4767001B592648")
    public final int getSource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478847730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478847730;
        // ---------- Original Method ----------
        //return mSource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.012 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0B7D64DE26C1B0BB40D318F62A2F21BD")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994455682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994455682;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.013 -0400", hash_original_method = "FCA327E6B3FDBBC7798ED2309FF9DDE2", hash_generated_method = "9B95CF37261D750B9974AD81E9274708")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mCountryIso);
        parcel.writeInt(mSource);
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //parcel.writeString(mCountryIso);
        //parcel.writeInt(mSource);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.016 -0400", hash_original_method = "A4E8BAE44F340138225E9939A030C872", hash_generated_method = "6EDBF8524CE4D16DCE02100A3A45543D")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_1473512862 = (object == this);
        } //End collapsed parenthetic
        {
            Country c;
            c = (Country) object;
            boolean var5D7043958EF95E0F56528FF7D9B5EEB9_2091776387 = (mCountryIso.equals(c.getCountryIso()) && mSource == c.getSource());
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772099950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_772099950;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.018 -0400", hash_original_method = "B421DD13AECD8D681C930C2BD9632735", hash_generated_method = "84656EC89B8EA0CA2B45729DFA7DD3B7")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670074013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670074013;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.021 -0400", hash_original_method = "1D459D842605CA34811091FC29FDA2D4", hash_generated_method = "A3C4D7C6B67729CC51A533B104861761")
    public boolean equalsIgnoreSource(Country country) {
        boolean varD619BC2A0E08DE4307B63AC091555062_397133597 = (country != null && mCountryIso.equals(country.getCountryIso()));
        addTaint(country.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284215184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284215184;
        // ---------- Original Method ----------
        //return country != null && mCountryIso.equals(country.getCountryIso());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.022 -0400", hash_original_field = "9CB5B59BF87299CC5FD1EE6D4FA1EA37", hash_generated_field = "92DDDD9D36EEE5E4A82A6D2A8125DA06")

    public static final int COUNTRY_SOURCE_NETWORK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.022 -0400", hash_original_field = "A034BDAF7B0EBD8EF628F43CAC605566", hash_generated_field = "E621B42B3BCFCE5A4BEE8EF55832C00E")

    public static final int COUNTRY_SOURCE_LOCATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.022 -0400", hash_original_field = "379282355702284215225F24078FC66E", hash_generated_field = "6DEBAD6B9569D1A6DA2BAF807389E01A")

    public static final int COUNTRY_SOURCE_SIM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.023 -0400", hash_original_field = "B9D53DF042DB1EC7F220E6C42904313F", hash_generated_field = "8DD0E261E5B0CC34B2FBFF0101C7083A")

    public static final int COUNTRY_SOURCE_LOCALE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:16.024 -0400", hash_original_field = "48FE3108061C8FB14165724DC6609E10", hash_generated_field = "2CCF073B8A235B66F6A4E81108680C92")

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        public Country createFromParcel(Parcel in) {
            return new Country(in.readString(), in.readInt());
        }

        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}

