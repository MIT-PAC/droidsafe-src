package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public class Country implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.108 -0400", hash_original_field = "C7E1D84BBBBD6E2342AD8875187F4659", hash_generated_field = "A4787DDEE2CB6821D6A9300F5DB86C40")

    private String mCountryIso;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.108 -0400", hash_original_field = "6917951DFB797D97827BAAA584F128DE", hash_generated_field = "D564CAA4C2DB0DC0AAAD32F1767ED66A")

    private int mSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.108 -0400", hash_original_field = "D1324C907E3C733CA9E17C8F90836F79", hash_generated_field = "A977E573260D0E2786C71BC0961278A2")

    private int mHashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.109 -0400", hash_original_method = "180A74FA9B2C94F60E7E0D1924EE6005", hash_generated_method = "5F63E8D487E9A7B97A8E0BFB5D9A0BC2")
    public  Country(final String countryIso, final int source) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        mCountryIso = countryIso.toUpperCase(Locale.US);
        mSource = source;
        
        
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.109 -0400", hash_original_method = "E5422BF754D1EEFE24F783DEE0DEB6C8", hash_generated_method = "93FC7471C9A9942792321C1DF9B6A336")
    public  Country(Country country) {
        mCountryIso = country.mCountryIso;
        mSource = country.mSource;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.110 -0400", hash_original_method = "5F3223376651F8BE6A8AF3345618A060", hash_generated_method = "C15558D19831258D2B1AA150694A49B7")
    public final String getCountryIso() {
        String varB4EAC82CA7396A68D541C85D26508E83_353682618 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_353682618 = mCountryIso;
        varB4EAC82CA7396A68D541C85D26508E83_353682618.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_353682618;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.110 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "ACB961A21E3A01FAC83A038690E0B148")
    public final int getSource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908227077 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908227077;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.111 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "39B45423AF7CCD67FD65D19693CB6732")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348339501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348339501;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.111 -0400", hash_original_method = "FCA327E6B3FDBBC7798ED2309FF9DDE2", hash_generated_method = "9B95CF37261D750B9974AD81E9274708")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mCountryIso);
        parcel.writeInt(mSource);
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.112 -0400", hash_original_method = "A4E8BAE44F340138225E9939A030C872", hash_generated_method = "53BE73A4783D305989CF3FC66C7AB8F1")
    @Override
    public boolean equals(Object object) {
        {
            boolean var3F549205D4C262003697A031F89E5954_985483022 = (object == this);
        } 
        {
            Country c = (Country) object;
            boolean var5D7043958EF95E0F56528FF7D9B5EEB9_1889916921 = (mCountryIso.equals(c.getCountryIso()) && mSource == c.getSource());
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_424647447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_424647447;
        
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.113 -0400", hash_original_method = "B421DD13AECD8D681C930C2BD9632735", hash_generated_method = "9FDCDBC44DA72B52F219071A8FEFE0EE")
    @Override
    public int hashCode() {
        int hash = mHashCode;
        {
            hash = 17;
            hash = hash * 13 + mCountryIso.hashCode();
            hash = hash * 13 + mSource;
            mHashCode = hash;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479218057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479218057;
        
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.113 -0400", hash_original_method = "1D459D842605CA34811091FC29FDA2D4", hash_generated_method = "E00933D671352B04EE8D185579C4B2C9")
    public boolean equalsIgnoreSource(Country country) {
        boolean varD619BC2A0E08DE4307B63AC091555062_685534996 = (country != null && mCountryIso.equals(country.getCountryIso()));
        addTaint(country.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428544805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428544805;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.113 -0400", hash_original_field = "9CB5B59BF87299CC5FD1EE6D4FA1EA37", hash_generated_field = "92DDDD9D36EEE5E4A82A6D2A8125DA06")

    public static final int COUNTRY_SOURCE_NETWORK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.113 -0400", hash_original_field = "A034BDAF7B0EBD8EF628F43CAC605566", hash_generated_field = "E621B42B3BCFCE5A4BEE8EF55832C00E")

    public static final int COUNTRY_SOURCE_LOCATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.113 -0400", hash_original_field = "379282355702284215225F24078FC66E", hash_generated_field = "6DEBAD6B9569D1A6DA2BAF807389E01A")

    public static final int COUNTRY_SOURCE_SIM = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.113 -0400", hash_original_field = "B9D53DF042DB1EC7F220E6C42904313F", hash_generated_field = "8DD0E261E5B0CC34B2FBFF0101C7083A")

    public static final int COUNTRY_SOURCE_LOCALE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.113 -0400", hash_original_field = "48FE3108061C8FB14165724DC6609E10", hash_generated_field = "2CCF073B8A235B66F6A4E81108680C92")

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        public Country createFromParcel(Parcel in) {
            return new Country(in.readString(), in.readInt());
        }

        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
    
    public Country createFromParcel(Parcel in) {
            return new Country(in.readString(), in.readInt());
        }
    
    
    public Country[] newArray(int size) {
            return new Country[size];
        }
    
}

