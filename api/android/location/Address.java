package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.894 -0400", hash_original_field = "34AF13FB5BC8BAFBEC9B029562C77C94", hash_generated_field = "B4FB2F104B558E1CA23D02F180C08BB7")

    public static final Parcelable.Creator<Address> CREATOR =
        new Parcelable.Creator<Address>() {
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.040 -0500", hash_original_method = "9DD3D24D0AAD4627E69FB2E9DF778B8A", hash_generated_method = "9D04A4E818D392AFC2DFE4BD73D09C8E")
        
public Address createFromParcel(Parcel in) {
            String language = in.readString();
            String country = in.readString();
            Locale locale = country.length() > 0 ?
                new Locale(language, country) :
                new Locale(language);
            Address a = new Address(locale);

            int N = in.readInt();
            if (N > 0) {
                a.mAddressLines = new HashMap<Integer, String>(N);
                for (int i = 0; i < N; i++) {
                    int index = in.readInt();
                    String line = in.readString();
                    a.mAddressLines.put(index, line);
                    a.mMaxAddressLineIndex =
                        Math.max(a.mMaxAddressLineIndex, index);
                }
            } else {
                a.mAddressLines = null;
                a.mMaxAddressLineIndex = -1;
            }
            a.mFeatureName = in.readString();
            a.mAdminArea = in.readString();
            a.mSubAdminArea = in.readString();
            a.mLocality = in.readString();
            a.mSubLocality = in.readString();
            a.mThoroughfare = in.readString();
            a.mSubThoroughfare = in.readString();
            a.mPremises = in.readString();
            a.mPostalCode = in.readString();
            a.mCountryCode = in.readString();
            a.mCountryName = in.readString();
            a.mHasLatitude = in.readInt() == 0 ? false : true;
            if (a.mHasLatitude) {
                a.mLatitude = in.readDouble();
            }
            a.mHasLongitude = in.readInt() == 0 ? false : true;
            if (a.mHasLongitude) {
                a.mLongitude = in.readDouble();
            }
            a.mPhone = in.readString();
            a.mUrl = in.readString();
            a.mExtras = in.readBundle();
            return a;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.042 -0500", hash_original_method = "814279382DFD395E3EB63F703FD02AFD", hash_generated_method = "A16044108C17045F0B23C8BE2178BA43")
        
public Address[] newArray(int size) {
            return new Address[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.897 -0500", hash_original_field = "D959780368C6CA232CF8C3906CDDEDF3", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

    private Locale mLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.899 -0500", hash_original_field = "3AC35F1DC6C865760AE25027C922FC5A", hash_generated_field = "885B87E22D2EF7CC7C342A420B72EF3E")

    private String mFeatureName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.902 -0500", hash_original_field = "945C593342AC1D9FF615087D26726968", hash_generated_field = "267F6B9285B603FF477C20775D29AA60")

    private HashMap<Integer, String> mAddressLines;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.904 -0500", hash_original_field = "D23B356E6EC3A4B044C64CFF26C34A45", hash_generated_field = "61A068F86D173398FFF3F86ABD61DF78")

    private int mMaxAddressLineIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.906 -0500", hash_original_field = "1721929E44BA7DAC7C5070DC84824851", hash_generated_field = "9E4BAF383B0085BDBE33EFF069DD6A8A")

    private String mAdminArea;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.908 -0500", hash_original_field = "0F4650F0A15137C6F16DCE8B4BA2172E", hash_generated_field = "5914F416D26BAEA83D36B07CC8123017")

    private String mSubAdminArea;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.910 -0500", hash_original_field = "13CDC06FD085E58AC8A1E7E90F52F4A2", hash_generated_field = "B27EC088B31F0C4F3FC5FD8261A96829")

    private String mLocality;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.913 -0500", hash_original_field = "4D0A9EB7AA61D32C2B2A1E1F7AD93546", hash_generated_field = "54AA36C926071A6092BD97F68F4B1C69")

    private String mSubLocality;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.916 -0500", hash_original_field = "0032C54EA8D4D3EAD39D75A9C80A931A", hash_generated_field = "572923B079894AE27884BBD950702954")

    private String mThoroughfare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.918 -0500", hash_original_field = "EE4C5F26B22A1582DF351682D4D7294F", hash_generated_field = "01630869675F1DA42810C4AF0E092889")

    private String mSubThoroughfare;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.920 -0500", hash_original_field = "808003FFD461C8FBB45436081C405EA2", hash_generated_field = "CF559618A1D4E648B6B2F354F5258741")

    private String mPremises;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.922 -0500", hash_original_field = "EC71C0AB6D22525921B755F73CF5522A", hash_generated_field = "C69EE2CA15E3AA7242875015CFA55C01")

    private String mPostalCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.924 -0500", hash_original_field = "0AC2C06F8EE53F85205C02F7F0579D57", hash_generated_field = "9C7911CE25730D113ABA8C07F7DE1F24")

    private String mCountryCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.926 -0500", hash_original_field = "E13B1F4BED2120E9A6947F23D5D2DFA7", hash_generated_field = "4CCD8712180BD60CFDB41FE6E2DEDB0D")

    private String mCountryName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.928 -0500", hash_original_field = "CEE411F80E303D76022150F53CF134DD", hash_generated_field = "9EF15EBC1351E9950D0EE5BCAD1038B0")

    private double mLatitude;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.930 -0500", hash_original_field = "9AF3427D79167FDBC3353A07B091874C", hash_generated_field = "5D603DAFF57AB40C16D9A89FCAF92AF2")

    private double mLongitude;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.932 -0500", hash_original_field = "042079230A53EA2A1A61D7A6EF9AA337", hash_generated_field = "92513C87CE591BDB601C26AA959D3DE3")

    private boolean mHasLatitude = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.935 -0500", hash_original_field = "C8D73D14A2C0F70B347B533CE8424F63", hash_generated_field = "4581B045B6697DC4EF5E7E35CB7E72AE")

    private boolean mHasLongitude = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.937 -0500", hash_original_field = "42E28087654B307160AF67FA9CF5F52C", hash_generated_field = "1D4D63140ABF8732CCB2AA5286B163C3")

    private String mPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.939 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.942 -0500", hash_original_field = "5F5A32CDFB5156D2D59483EBF50BAC14", hash_generated_field = "F67EBBE51D94FDD3154517E86441117D")

    private Bundle mExtras = null;

    /**
     * Constructs a new Address object set to the given Locale and with all
     * other fields initialized to null or false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.944 -0500", hash_original_method = "8C8D8A006008D0E9588030A46EE6B5B9", hash_generated_method = "8A3393F2730E42F7A1FEBCB27514EF12")
    
public Address(Locale locale) {
        mLocale = locale;
    }

    /**
     * Returns the Locale associated with this address.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.947 -0500", hash_original_method = "95F8746C49CE2A7FBF7EA83DF206E003", hash_generated_method = "A1D784B67B002754E37DDB902EBC5ECA")
    
public Locale getLocale() {
        return mLocale;
    }

    /**
     * Returns the largest index currently in use to specify an address line.
     * If no address lines are specified, -1 is returned.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.949 -0500", hash_original_method = "E1E6237F606789C7A5294059179DF025", hash_generated_method = "B30732385F679D009FA9475F8F07188B")
    
public int getMaxAddressLineIndex() {
        return mMaxAddressLineIndex;
    }

    /**
     * Returns a line of the address numbered by the given index
     * (starting at 0), or null if no such line is present.
     *
     * @throws IllegalArgumentException if index < 0
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.951 -0500", hash_original_method = "D824FE2CFE40DB25058DC1465F2D4439", hash_generated_method = "E07AE75D76B73CCF005AADE236B3948A")
    
public String getAddressLine(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index = " + index + " < 0");
        }
        return mAddressLines == null? null :  mAddressLines.get(index);
    }

    /**
     * Sets the line of the address numbered by index (starting at 0) to the
     * given String, which may be null.
     *
     * @throws IllegalArgumentException if index < 0
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.953 -0500", hash_original_method = "5C23144E8A22EAB5D8930884A1255DAC", hash_generated_method = "4D3DF28EF6A597356077D2CF7605F2A4")
    
public void setAddressLine(int index, String line) {
        if (index < 0) {
            throw new IllegalArgumentException("index = " + index + " < 0");
        }
        if (mAddressLines == null) {
            mAddressLines = new HashMap<Integer, String>();
        }
        mAddressLines.put(index, line);

        if (line == null) {
            // We've eliminated a line, recompute the max index
            mMaxAddressLineIndex = -1;
            for (Integer i : mAddressLines.keySet()) {
                mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, i);
            }
        } else {
            mMaxAddressLineIndex = Math.max(mMaxAddressLineIndex, index);
        }
    }

    /**
     * Returns the feature name of the address, for example, "Golden Gate Bridge", or null
     * if it is unknown
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.955 -0500", hash_original_method = "D108F727B4ED1E44A68F4DDDAA8864A4", hash_generated_method = "FB47B831AC1CCB642EA8CD38A1FB24D4")
    
public String getFeatureName() {
        return mFeatureName;
    }

    /**
     * Sets the feature name of the address to the given String, which may be null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.957 -0500", hash_original_method = "49225B599976EB86160DDAF83CE5BC7F", hash_generated_method = "CD38B1EC8543E5F846161FEF918BC6EB")
    
public void setFeatureName(String featureName) {
        mFeatureName = featureName;
    }

    /**
     * Returns the administrative area name of the address, for example, "CA", or null if
     * it is unknown
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.959 -0500", hash_original_method = "EDE4D65E7936029E84B8376D150F4DDE", hash_generated_method = "AFCAB53B8CC6CE56AE2B9E8199BA7D7B")
    
public String getAdminArea() {
        return mAdminArea;
    }

    /**
     * Sets the administrative area name of the address to the given String, which may be null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.962 -0500", hash_original_method = "C8D449D9A4FBB2AF83806F488A8CAC1C", hash_generated_method = "C2C7957A29EA2B57C87DD7CA0274CC40")
    
public void setAdminArea(String adminArea) {
        this.mAdminArea = adminArea;
    }

    /**
     * Returns the sub-administrative area name of the address, for example, "Santa Clara County",
     * or null if it is unknown
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.964 -0500", hash_original_method = "84D73E83BF1D1209648491141222963A", hash_generated_method = "DE94FA12C502F4B42BCBA80B3C079F65")
    
public String getSubAdminArea() {
        return mSubAdminArea;
    }

    /**
     * Sets the sub-administrative area name of the address to the given String, which may be null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.966 -0500", hash_original_method = "4DF91F489D35ACCA2DC2AF8A5398BD9E", hash_generated_method = "58F5999AB8C27C4BA4937D3A74F29F29")
    
public void setSubAdminArea(String subAdminArea) {
        this.mSubAdminArea = subAdminArea;
    }

    /**
     * Returns the locality of the address, for example "Mountain View", or null if it is unknown.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.968 -0500", hash_original_method = "3743C626E0A5809CC359BBE60C0BEF8D", hash_generated_method = "73AFC5AD3CD0A46E156C307263BEDE45")
    
public String getLocality() {
        return mLocality;
    }

    /**
     * Sets the locality of the address to the given String, which may be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.971 -0500", hash_original_method = "E848A60937105A6FB0F90F11784FAFAB", hash_generated_method = "A27869F257AB3FD8BB3CF77C05B54550")
    
public void setLocality(String locality) {
        mLocality = locality;
    }

    /**
     * Returns the sub-locality of the address, or null if it is unknown.
     * For example, this may correspond to the neighborhood of the locality.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.973 -0500", hash_original_method = "4565445A715D9E082E3330822780EE14", hash_generated_method = "0F1DA46038847C235A541B3BE19AD8AC")
    
public String getSubLocality() {
        return mSubLocality;
    }

    /**
     * Sets the sub-locality of the address to the given String, which may be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.975 -0500", hash_original_method = "FBC28BB3F834CBCC388544379D8FF1EB", hash_generated_method = "9423C7A993C5E833F5CC52F1C07C7F48")
    
public void setSubLocality(String sublocality) {
        mSubLocality = sublocality;
    }

    /**
     * Returns the thoroughfare name of the address, for example, "1600 Ampitheater Parkway",
     * which may be null
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.977 -0500", hash_original_method = "1512262039F5521B933A04882815530C", hash_generated_method = "8D3E8923D4D77C2126FFFBBF22470494")
    
public String getThoroughfare() {
        return mThoroughfare;
    }

    /**
     * Sets the thoroughfare name of the address, which may be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.979 -0500", hash_original_method = "30509B10242C2769144E7C2C070721FD", hash_generated_method = "B70CDB45334435F12354FF6F6A0E8EB2")
    
public void setThoroughfare(String thoroughfare) {
        this.mThoroughfare = thoroughfare;
    }

    /**
     * Returns the sub-thoroughfare name of the address, which may be null.
     * This may correspond to the street number of the address.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.981 -0500", hash_original_method = "8EFF44F66BA44D813DFBCA9FC34B8EF5", hash_generated_method = "70675E1BD9C4434040F5220B076FC66F")
    
public String getSubThoroughfare() {
        return mSubThoroughfare;
    }

    /**
     * Sets the sub-thoroughfare name of the address, which may be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.984 -0500", hash_original_method = "ED99ECE32AF3E65AA637AE926CEFB8FE", hash_generated_method = "950137E9888299B5A915E366B3532014")
    
public void setSubThoroughfare(String subthoroughfare) {
        this.mSubThoroughfare = subthoroughfare;
    }

    /**
     * Returns the premises of the address, or null if it is unknown.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.986 -0500", hash_original_method = "C1BF40685BD6E248364BFB485F611555", hash_generated_method = "2A5BBEF6B0F64414B9EDDA6C2E5DC49D")
    
public String getPremises() {
        return mPremises;
    }

    /**
     * Sets the premises of the address to the given String, which may be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.988 -0500", hash_original_method = "C9E9B1B8FA21E47AD4B139D64075E36A", hash_generated_method = "130C233CA0E605F838509A54A78284F0")
    
public void setPremises(String premises) {
        mPremises = premises;
    }

    /**
     * Returns the postal code of the address, for example "94110",
     * or null if it is unknown.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.990 -0500", hash_original_method = "9B5379769D21EFABDDB2785674C4DE4D", hash_generated_method = "807D83B90E9CDF129CBC03CA17E8BD00")
    
public String getPostalCode() {
        return mPostalCode;
    }

    /**
     * Sets the postal code of the address to the given String, which may
     * be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.992 -0500", hash_original_method = "21CF31250DB9EF4FD9B8F171A3FE8B16", hash_generated_method = "4FC43757748A3C5B6DE81CD260A930C4")
    
public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
    }

    /**
     * Returns the country code of the address, for example "US",
     * or null if it is unknown.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.994 -0500", hash_original_method = "E8D66F74FB4E1AF79CCB258931950FBE", hash_generated_method = "97553366601A44B32E9FBEBAF3F0CAE5")
    
public String getCountryCode() {
        return mCountryCode;
    }

    /**
     * Sets the country code of the address to the given String, which may
     * be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.996 -0500", hash_original_method = "DD5F97427C040B47F9123BA4F8DC93A2", hash_generated_method = "C1A18211AF5B9DD8FA0581C4C10C0A3D")
    
public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
    }

    /**
     * Returns the localized country name of the address, for example "Iceland",
     * or null if it is unknown.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:56.998 -0500", hash_original_method = "A82A5DCEE67796EF014C1F79656EFD25", hash_generated_method = "9CF145F0ECFD07227D18E7F299E97839")
    
public String getCountryName() {
        return mCountryName;
    }

    /**
     * Sets the country name of the address to the given String, which may
     * be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.000 -0500", hash_original_method = "F7767E8D2EF25B1D1399497900992B14", hash_generated_method = "4A7D36F15A0AC90130EEB28EEEAEEFE3")
    
public void setCountryName(String countryName) {
        mCountryName = countryName;
    }

    /**
     * Returns true if a latitude has been assigned to this Address,
     * false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.002 -0500", hash_original_method = "AB4D7FB4B745E9B023209032D37DF18F", hash_generated_method = "ED2B9CE29D09758C9886F01DAC5AACB5")
    
public boolean hasLatitude() {
        return mHasLatitude;
    }

    /**
     * Returns the latitude of the address if known.
     *
     * @throws IllegalStateException if this Address has not been assigned
     * a latitude.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.004 -0500", hash_original_method = "74A963FE4AC8482F316E1B3E19ABA2D8", hash_generated_method = "4A3E9D32F12678BE5FC881662775EF32")
    
public double getLatitude() {
        if (mHasLatitude) {
            return mLatitude;
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Sets the latitude associated with this address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.007 -0500", hash_original_method = "E7EB84DA300898C528161A7CBF9FB7F9", hash_generated_method = "2E45C2CC1B9C7F7E45647A6AEB578D51")
    
public void setLatitude(double latitude) {
        mLatitude = latitude;
        mHasLatitude = true;
    }

    /**
     * Removes any latitude associated with this address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.009 -0500", hash_original_method = "4BCAF53DCD4CF7BB362561C1B9A79F13", hash_generated_method = "6EBD84B5F4FE5B40F139ADA83A610D0F")
    
public void clearLatitude() {
        mHasLatitude = false;
    }

    /**
     * Returns true if a longitude has been assigned to this Address,
     * false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.011 -0500", hash_original_method = "44F26BDA1ACBDD9862A3D8D8968B3507", hash_generated_method = "15895C6225025901E093E5A729C5E4E1")
    
public boolean hasLongitude() {
        return mHasLongitude;
    }

    /**
     * Returns the longitude of the address if known.
     *
     * @throws IllegalStateException if this Address has not been assigned
     * a longitude.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.014 -0500", hash_original_method = "90E38F72A8C0EDFD5CFCC6EABD3BD432", hash_generated_method = "32D9DFBF78F14745340DA7BDD1496829")
    
public double getLongitude() {
        if (mHasLongitude) {
            return mLongitude;
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Sets the longitude associated with this address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.016 -0500", hash_original_method = "C4D556739F3557653F6C8D616289AA29", hash_generated_method = "85D4163C31C0BE4A9F747AB2983E6E92")
    
public void setLongitude(double longitude) {
        mLongitude = longitude;
        mHasLongitude = true;
    }

    /**
     * Removes any longitude associated with this address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.019 -0500", hash_original_method = "D5786F30716C18CE0A0AB74556D12A22", hash_generated_method = "708578452BD67272299AEC24AF7B5510")
    
public void clearLongitude() {
        mHasLongitude = false;
    }

    /**
     * Returns the phone number of the address if known,
     * or null if it is unknown.
     *
     * @throws IllegalStateException if this Address has not been assigned
     * a latitude.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.021 -0500", hash_original_method = "EB9EE516F482EB01602422E9FA56CA5C", hash_generated_method = "7269D5F8AA84063A166ED918C8F457BD")
    
public String getPhone() {
        return mPhone;
    }

    /**
     * Sets the phone number associated with this address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.023 -0500", hash_original_method = "5023DDC820B0F6BE06303CFCE3A71EDF", hash_generated_method = "BB24277CC336BED4E8D975045628559B")
    
public void setPhone(String phone) {
        mPhone = phone;
    }

    /**
     * Returns the public URL for the address if known,
     * or null if it is unknown.
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.026 -0500", hash_original_method = "13CE30FBE362EA44FDCE282CA01E7BBC", hash_generated_method = "B64A7CF604F22C84E5CFF07E83B9389F")
    
public String getUrl() {
        return mUrl;
    }

    /**
     * Sets the public URL associated with this address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.028 -0500", hash_original_method = "A94A57C3BD4A508E7FC3D69DE1774EEC", hash_generated_method = "53258E687E805CAFD552721AE359CD97")
    
public void setUrl(String Url) {
        mUrl = Url;
    }

    /**
     * Returns additional provider-specific information about the
     * address as a Bundle.  The keys and values are determined
     * by the provider.  If no additional information is available,
     * null is returned.
     *
     * <!--
     * <p> A number of common key/value pairs are listed
     * below. Providers that use any of the keys on this list must
     * provide the corresponding value as described below.
     *
     * <ul>
     * </ul>
     * -->
     */
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.030 -0500", hash_original_method = "CF33C86C13BFD55DE499066ECC955562", hash_generated_method = "4808B2FAD06A275B25AB6F7116EE8421")
    
public Bundle getExtras() {
        return mExtras;
    }

    /**
     * Sets the extra information associated with this fix to the
     * given Bundle.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.033 -0500", hash_original_method = "0A734FEAEEC80691783BCF1D3384CC6B", hash_generated_method = "7B33C94C8485B596F89F9E6A5A10A83A")
    
public void setExtras(Bundle extras) {
        mExtras = (extras == null) ? null : new Bundle(extras);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.036 -0500", hash_original_method = "F2CDEB7D6ECCED8CC4C514EA700B26BB", hash_generated_method = "C7F1A618984BF16555BE41E35CBE58B9")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address[addressLines=[");
        for (int i = 0; i <= mMaxAddressLineIndex; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(i);
            sb.append(':');
            String line = mAddressLines.get(i);
            if (line == null) {
                sb.append("null");
            } else {
                sb.append('\"');
                sb.append(line);
                sb.append('\"');
            }
        }
        sb.append(']');
        sb.append(",feature=");
        sb.append(mFeatureName);
        sb.append(",admin=");
        sb.append(mAdminArea);
        sb.append(",sub-admin=");
        sb.append(mSubAdminArea);
        sb.append(",locality=");
        sb.append(mLocality);
        sb.append(",thoroughfare=");
        sb.append(mThoroughfare);
        sb.append(",postalCode=");
        sb.append(mPostalCode);
        sb.append(",countryCode=");
        sb.append(mCountryCode);
        sb.append(",countryName=");
        sb.append(mCountryName);
        sb.append(",hasLatitude=");
        sb.append(mHasLatitude);
        sb.append(",latitude=");
        sb.append(mLatitude);
        sb.append(",hasLongitude=");
        sb.append(mHasLongitude);
        sb.append(",longitude=");
        sb.append(mLongitude);
        sb.append(",phone=");
        sb.append(mPhone);
        sb.append(",url=");
        sb.append(mUrl);
        sb.append(",extras=");
        sb.append(mExtras);
        sb.append(']');
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.047 -0500", hash_original_method = "2C347F4A4F86FFA77F246DC5FD21E5D6", hash_generated_method = "9EEEEB4CB0AEAD087048579D4D41C88C")
    
public int describeContents() {
        return (mExtras != null) ? mExtras.describeContents() : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:57.050 -0500", hash_original_method = "609BCF0D5B324DA0FE8A594DDD7486F2", hash_generated_method = "F42E65639112D955FC1D1BB5643094C7")
    
public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mLocale.getLanguage());
        parcel.writeString(mLocale.getCountry());
        if (mAddressLines == null) {
            parcel.writeInt(0);
        } else {
            Set<Map.Entry<Integer, String>> entries = mAddressLines.entrySet();
            parcel.writeInt(entries.size());
            for (Map.Entry<Integer, String> e : entries) {
                parcel.writeInt(e.getKey());
                parcel.writeString(e.getValue());
            }
        }
        parcel.writeString(mFeatureName);
        parcel.writeString(mAdminArea);
        parcel.writeString(mSubAdminArea);
        parcel.writeString(mLocality);
        parcel.writeString(mSubLocality);
        parcel.writeString(mThoroughfare);
        parcel.writeString(mSubThoroughfare);
        parcel.writeString(mPremises);
        parcel.writeString(mPostalCode);
        parcel.writeString(mCountryCode);
        parcel.writeString(mCountryName);
        parcel.writeInt(mHasLatitude ? 1 : 0);
        if (mHasLatitude) {
            parcel.writeDouble(mLatitude);
        }
        parcel.writeInt(mHasLongitude ? 1 : 0);
        if (mHasLongitude){
            parcel.writeDouble(mLongitude);
        }
        parcel.writeString(mPhone);
        parcel.writeString(mUrl);
        parcel.writeBundle(mExtras);
    }
    // orphaned legacy method
    public Address createFromParcel(Parcel in) {
            String language = in.readString();
            String country = in.readString();
            Locale locale = country.length() > 0 ?
                new Locale(language, country) :
                new Locale(language);
            Address a = new Address(locale);

            int N = in.readInt();
            if (N > 0) {
                a.mAddressLines = new HashMap<Integer, String>(N);
                for (int i = 0; i < N; i++) {
                    int index = in.readInt();
                    String line = in.readString();
                    a.mAddressLines.put(index, line);
                    a.mMaxAddressLineIndex =
                        Math.max(a.mMaxAddressLineIndex, index);
                }
            } else {
                a.mAddressLines = null;
                a.mMaxAddressLineIndex = -1;
            }
            a.mFeatureName = in.readString();
            a.mAdminArea = in.readString();
            a.mSubAdminArea = in.readString();
            a.mLocality = in.readString();
            a.mSubLocality = in.readString();
            a.mThoroughfare = in.readString();
            a.mSubThoroughfare = in.readString();
            a.mPremises = in.readString();
            a.mPostalCode = in.readString();
            a.mCountryCode = in.readString();
            a.mCountryName = in.readString();
            a.mHasLatitude = in.readInt() == 0 ? false : true;
            if (a.mHasLatitude) {
                a.mLatitude = in.readDouble();
            }
            a.mHasLongitude = in.readInt() == 0 ? false : true;
            if (a.mHasLongitude) {
                a.mLongitude = in.readDouble();
            }
            a.mPhone = in.readString();
            a.mUrl = in.readString();
            a.mExtras = in.readBundle();
            return a;
        }
    
    // orphaned legacy method
    public Address[] newArray(int size) {
            return new Address[size];
        }
    
}

