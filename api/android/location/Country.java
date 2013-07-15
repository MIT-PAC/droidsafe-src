package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public class Country implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.632 -0400", hash_original_field = "C7E1D84BBBBD6E2342AD8875187F4659", hash_generated_field = "A4787DDEE2CB6821D6A9300F5DB86C40")

    private String mCountryIso;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.632 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "D564CAA4C2DB0DC0AAAD32F1767ED66A")

    private int mSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.632 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.633 -0400", hash_original_method = "180A74FA9B2C94F60E7E0D1924EE6005", hash_generated_method = "87CD4BE822E9DFDD6DC87B3A3215EECE")
    public  Country(final String countryIso, final int source) {
    if(countryIso == null || source < COUNTRY_SOURCE_NETWORK
                || source > COUNTRY_SOURCE_LOCALE)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_915415573 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_915415573.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_915415573;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.633 -0400", hash_original_method = "E5422BF754D1EEFE24F783DEE0DEB6C8", hash_generated_method = "93FC7471C9A9942792321C1DF9B6A336")
    public  Country(Country country) {
        mCountryIso = country.mCountryIso;
        mSource = country.mSource;
        // ---------- Original Method ----------
        //mCountryIso = country.mCountryIso;
        //mSource = country.mSource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.634 -0400", hash_original_method = "5F3223376651F8BE6A8AF3345618A060", hash_generated_method = "89ED025A37336A1B5370A70AD21CB011")
    public final String getCountryIso() {
String varABD26FAEF97E5A889B52BBA304F6F7F1_97258137 =         mCountryIso;
        varABD26FAEF97E5A889B52BBA304F6F7F1_97258137.addTaint(taint);
        return varABD26FAEF97E5A889B52BBA304F6F7F1_97258137;
        // ---------- Original Method ----------
        //return mCountryIso;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.634 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "C2850DA76CA845F72D04A5438A1D1787")
    public final int getSource() {
        int var6917951DFB797D97827BAAA584F128DE_1900625072 = (mSource);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534003878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534003878;
        // ---------- Original Method ----------
        //return mSource;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.634 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BEDADB0F2AEBFB57D44D10426198402F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2090165108 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620498585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620498585;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.635 -0400", hash_original_method = "FCA327E6B3FDBBC7798ED2309FF9DDE2", hash_generated_method = "C9942526C4E1080AA8DDF55A21E17068")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeString(mCountryIso);
        parcel.writeInt(mSource);
        // ---------- Original Method ----------
        //parcel.writeString(mCountryIso);
        //parcel.writeInt(mSource);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.636 -0400", hash_original_method = "A4E8BAE44F340138225E9939A030C872", hash_generated_method = "C7629E21A426F06506109A5B779FCBB9")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_342621820 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580326931 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580326931;
        } //End block
    if(object instanceof Country)        
        {
            Country c = (Country) object;
            boolean var5FC13BC6A32FB31F79551723D6CD596A_168535472 = (mCountryIso.equals(c.getCountryIso()) && mSource == c.getSource());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125039279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125039279;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1193212138 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149167862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149167862;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.637 -0400", hash_original_method = "B421DD13AECD8D681C930C2BD9632735", hash_generated_method = "9F5FAE7A74ADE9B9720B316AA0F23D79")
    @Override
    public int hashCode() {
        int hash = mHashCode;
    if(hash == 0)        
        {
            hash = 17;
            hash = hash * 13 + mCountryIso.hashCode();
            hash = hash * 13 + mSource;
            mHashCode = hash;
        } //End block
        int varD1324C907E3C733CA9E17C8F90836F79_422341651 = (mHashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529771839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529771839;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.638 -0400", hash_original_method = "1D459D842605CA34811091FC29FDA2D4", hash_generated_method = "760CC8901E7035A1D0C72DCF1F6DB47C")
    public boolean equalsIgnoreSource(Country country) {
        addTaint(country.getTaint());
        boolean varFFFECAA58B78103A8116914F7E63689B_795074183 = (country != null && mCountryIso.equals(country.getCountryIso()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983096147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983096147;
        // ---------- Original Method ----------
        //return country != null && mCountryIso.equals(country.getCountryIso());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.638 -0400", hash_original_field = "9CB5B59BF87299CC5FD1EE6D4FA1EA37", hash_generated_field = "92DDDD9D36EEE5E4A82A6D2A8125DA06")

    public static final int COUNTRY_SOURCE_NETWORK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.638 -0400", hash_original_field = "A034BDAF7B0EBD8EF628F43CAC605566", hash_generated_field = "E621B42B3BCFCE5A4BEE8EF55832C00E")

    public static final int COUNTRY_SOURCE_LOCATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.638 -0400", hash_original_field = "379282355702284215225F24078FC66E", hash_generated_field = "6DEBAD6B9569D1A6DA2BAF807389E01A")

    public static final int COUNTRY_SOURCE_SIM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.638 -0400", hash_original_field = "B9D53DF042DB1EC7F220E6C42904313F", hash_generated_field = "8DD0E261E5B0CC34B2FBFF0101C7083A")

    public static final int COUNTRY_SOURCE_LOCALE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.639 -0400", hash_original_field = "48FE3108061C8FB14165724DC6609E10", hash_generated_field = "2CCF073B8A235B66F6A4E81108680C92")

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        public Country createFromParcel(Parcel in) {
            return new Country(in.readString(), in.readInt());
        }

        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
    // orphaned legacy method
    public Country createFromParcel(Parcel in) {
            return new Country(in.readString(), in.readInt());
        }
    
    // orphaned legacy method
    public Country[] newArray(int size) {
            return new Country[size];
        }
    
}

