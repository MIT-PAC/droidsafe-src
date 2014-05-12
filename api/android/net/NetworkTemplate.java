package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.net.ConnectivityManager.TYPE_ETHERNET;
import static android.net.ConnectivityManager.TYPE_WIFI;
import static android.net.ConnectivityManager.TYPE_WIMAX;
import static android.net.NetworkIdentity.scrubSubscriberId;
import static android.telephony.TelephonyManager.NETWORK_CLASS_2_G;
import static android.telephony.TelephonyManager.NETWORK_CLASS_3_G;
import static android.telephony.TelephonyManager.NETWORK_CLASS_4_G;
import static android.telephony.TelephonyManager.NETWORK_CLASS_UNKNOWN;
import static android.telephony.TelephonyManager.getNetworkClass;
import static com.android.internal.util.ArrayUtils.contains;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.internal.util.Objects;

public class NetworkTemplate implements Parcelable {

    /**
     * Template to combine all {@link ConnectivityManager#TYPE_MOBILE} style
     * networks together. Only uses statistics for requested IMSI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.236 -0500", hash_original_method = "920CB6632367AA381B5D560425D2DF20", hash_generated_method = "EA71056DA2B1A02ED128F6ED0A05EEBD")
    
public static NetworkTemplate buildTemplateMobileAll(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_ALL, subscriberId);
    }

    /**
     * Template to combine all {@link ConnectivityManager#TYPE_MOBILE} style
     * networks together that roughly meet a "3G" definition, or lower. Only
     * uses statistics for requested IMSI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.238 -0500", hash_original_method = "378BD8666BC55ABE6C983AC88ECBC618", hash_generated_method = "DC657F41F62A6673D5FD7AAE5954B4BB")
    
public static NetworkTemplate buildTemplateMobile3gLower(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_3G_LOWER, subscriberId);
    }

    /**
     * Template to combine all {@link ConnectivityManager#TYPE_MOBILE} style
     * networks together that meet a "4G" definition. Only uses statistics for
     * requested IMSI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.240 -0500", hash_original_method = "625AEC735922F17CEE313AF44A76136E", hash_generated_method = "D40B1130F21A38070042A8099FA4282A")
    
public static NetworkTemplate buildTemplateMobile4g(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_4G, subscriberId);
    }

    /**
     * Template to combine all {@link ConnectivityManager#TYPE_WIFI} style
     * networks together.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.242 -0500", hash_original_method = "C5E2D2F11A35E2DE15FA31E404F7C085", hash_generated_method = "E06606B56ECCAD8C11CA21D8EBD92BDC")
    
public static NetworkTemplate buildTemplateWifi() {
        return new NetworkTemplate(MATCH_WIFI, null);
    }

    /**
     * Template to combine all {@link ConnectivityManager#TYPE_ETHERNET} style
     * networks together.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.244 -0500", hash_original_method = "398BE69070B39916D26D1D3EEC5FBD2E", hash_generated_method = "DFBDB481ADE05FC6B3DA7F310124510C")
    
public static NetworkTemplate buildTemplateEthernet() {
        return new NetworkTemplate(MATCH_ETHERNET, null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.285 -0500", hash_original_method = "5D128FE1E1960C433A71FB9376C09E8B", hash_generated_method = "CD778DE40340D3A6528F1F05DA956F2B")
    
private static String getMatchRuleName(int matchRule) {
        switch (matchRule) {
            case MATCH_MOBILE_3G_LOWER:
                return "MOBILE_3G_LOWER";
            case MATCH_MOBILE_4G:
                return "MOBILE_4G";
            case MATCH_MOBILE_ALL:
                return "MOBILE_ALL";
            case MATCH_WIFI:
                return "WIFI";
            case MATCH_ETHERNET:
                return "ETHERNET";
            default:
                return "UNKNOWN";
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.221 -0500", hash_original_field = "F7E1170448B1C53CABCCBEF7D84B4861", hash_generated_field = "10580A21BB1F38D4B241BBA4C0583CDB")

    public static final int MATCH_MOBILE_ALL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.224 -0500", hash_original_field = "367AAB070AC33266EF10C2767426A6D0", hash_generated_field = "3EEF691932FB8D316E34D113594AEB06")

    public static final int MATCH_MOBILE_3G_LOWER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.226 -0500", hash_original_field = "0930E51D82F46073665B3F7113C1F5AE", hash_generated_field = "A98607B1D2E2344818AF66A8664831D7")

    public static final int MATCH_MOBILE_4G = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.228 -0500", hash_original_field = "4BA346A34A97F961FDBC02539D3D7D51", hash_generated_field = "218772946764EB383CA6212569A1D95B")

    public static final int MATCH_WIFI = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.231 -0500", hash_original_field = "15D899F1411D2581E6849A905F4706D2", hash_generated_field = "4AED7ABDBBD241274554C6BF86E04300")

    public static final int MATCH_ETHERNET = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.233 -0500", hash_original_field = "C1B6E6FA79E27C8EC11D97098CAE3516", hash_generated_field = "4DA4B496DC05D75AC80944B686BBFECA")

    private static  int[] DATA_USAGE_NETWORK_TYPES;
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.014 -0400", hash_original_field = "88BA2DACBA38DAF918A0D3C1F5E00E22", hash_generated_field = "6C4E6CCCA93A0F55B381916949674798")

    public static final Creator<NetworkTemplate> CREATOR = new Creator<NetworkTemplate>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.288 -0500", hash_original_method = "38251DACB68583A45907072FCF0CAE23", hash_generated_method = "C9F3E3BC10A7876F5B5B128018549657")
        
public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.290 -0500", hash_original_method = "FDF754026684D312F9EC33474C401CC0", hash_generated_method = "7D199B4AE48F2BA90F49C97710AAED7F")
        
public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.246 -0500", hash_original_field = "61586E75DF1F9E362569C967C6545B95", hash_generated_field = "D0FA22F19C60C7D870BF0A9AE53EB17C")

    private  int mMatchRule;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.248 -0500", hash_original_field = "4CB6146C3E5C68A8736082D04D2233DE", hash_generated_field = "A7B8730BE01D0326C5198382C94E4F46")

    private  String mSubscriberId;

    /** {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.251 -0500", hash_original_method = "FD7BCAE9218E775535D7C5C898F0D923", hash_generated_method = "8F65189ABDF3F7AE8798289F464D079C")
    
public NetworkTemplate(int matchRule, String subscriberId) {
        this.mMatchRule = matchRule;
        this.mSubscriberId = subscriberId;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.253 -0500", hash_original_method = "467A86E8EFDDFF4383A8018B1ADE829F", hash_generated_method = "9F06E2CA4A827A21DFFE6A004A55A4D7")
    
private NetworkTemplate(Parcel in) {
        mMatchRule = in.readInt();
        mSubscriberId = in.readString();
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.256 -0500", hash_original_method = "16E233F925554B3B88BD36CB1859F60A", hash_generated_method = "A497A67544D8FA876B63E7B30D5EEFF4")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mMatchRule);
        dest.writeString(mSubscriberId);
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.258 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.260 -0500", hash_original_method = "743C43E5DEE5FAC4123020B60468B1AB", hash_generated_method = "DFDA57643119B4A1B3F31BCCCA687D48")
    
@Override
    public String toString() {
        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        return "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                + scrubSubscriberId;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.262 -0500", hash_original_method = "61F711039243E011B66A7D31CCB469F2", hash_generated_method = "0062B5AEF7C3F879FE2711F0AFA531AF")
    
@Override
    public int hashCode() {
        return Objects.hashCode(mMatchRule, mSubscriberId);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.265 -0500", hash_original_method = "97109AC3BBA8BEF8ECFCD42700ABFADC", hash_generated_method = "24681A499EAF23F43EAED06C644E4B5D")
    
@Override
    public boolean equals(Object obj) {
        if (obj instanceof NetworkTemplate) {
            final NetworkTemplate other = (NetworkTemplate) obj;
            return mMatchRule == other.mMatchRule
                    && Objects.equal(mSubscriberId, other.mSubscriberId);
        }
        return false;
    }

    /** {@hide} */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.267 -0500", hash_original_method = "F3B6429C6B29080B6AB6244CD6E2C6C6", hash_generated_method = "4FE6FFDE74FB6A449F71EEE91B6C997E")
    
public int getMatchRule() {
        return mMatchRule;
    }

    /** {@hide} */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.269 -0500", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "A7AB8B338BFAABE54CF6CD80FDE63752")
    
public String getSubscriberId() {
        return mSubscriberId;
    }

    /**
     * Test if given {@link NetworkIdentity} matches this template.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.271 -0500", hash_original_method = "9C317DAC08BBC55C4495C595EA5A7F8A", hash_generated_method = "8E6695FA61F4A9F4833B35BC39B54C68")
    
public boolean matches(NetworkIdentity ident) {
        switch (mMatchRule) {
            case MATCH_MOBILE_ALL:
                return matchesMobile(ident);
            case MATCH_MOBILE_3G_LOWER:
                return matchesMobile3gLower(ident);
            case MATCH_MOBILE_4G:
                return matchesMobile4g(ident);
            case MATCH_WIFI:
                return matchesWifi(ident);
            case MATCH_ETHERNET:
                return matchesEthernet(ident);
            default:
                throw new IllegalArgumentException("unknown network template");
        }
    }

    /**
     * Check if mobile network with matching IMSI.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.274 -0500", hash_original_method = "BBF3C380B9774B27B4245C54F7894533", hash_generated_method = "29490970C6EB4A3079390A7C66417EFB")
    
private boolean matchesMobile(NetworkIdentity ident) {
        if (ident.mType == TYPE_WIMAX) {
            // TODO: consider matching against WiMAX subscriber identity
            return true;
        } else {
            return (contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    && Objects.equal(mSubscriberId, ident.mSubscriberId));
        }
    }

    /**
     * Check if mobile network classified 3G or lower with matching IMSI.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.276 -0500", hash_original_method = "0F24D42BACA619E1B4D2A14C838DE427", hash_generated_method = "9376876B8BA8AD4F52F5BDE11BD4D48B")
    
private boolean matchesMobile3gLower(NetworkIdentity ident) {
        if (ident.mType == TYPE_WIMAX) {
            return false;
        } else if (matchesMobile(ident)) {
            switch (getNetworkClass(ident.mSubType)) {
                case NETWORK_CLASS_UNKNOWN:
                case NETWORK_CLASS_2_G:
                case NETWORK_CLASS_3_G:
                    return true;
            }
        }
        return false;
    }

    /**
     * Check if mobile network classified 4G with matching IMSI.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.278 -0500", hash_original_method = "B7894A7F3E04E8F81CBF1F61E6B8AB40", hash_generated_method = "EA548961B2D594DB52CFED05B98ABA05")
    
private boolean matchesMobile4g(NetworkIdentity ident) {
        if (ident.mType == TYPE_WIMAX) {
            // TODO: consider matching against WiMAX subscriber identity
            return true;
        } else if (matchesMobile(ident)) {
            switch (getNetworkClass(ident.mSubType)) {
                case NETWORK_CLASS_4_G:
                    return true;
            }
        }
        return false;
    }

    /**
     * Check if matches Wi-Fi network template.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.281 -0500", hash_original_method = "FC1062696978183943559E1C2F0FCB30", hash_generated_method = "13F6F1E90AEE0599F591A3C893AFE89C")
    
private boolean matchesWifi(NetworkIdentity ident) {
        if (ident.mType == TYPE_WIFI) {
            return true;
        }
        return false;
    }
    static {
        DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(
                com.android.internal.R.array.config_data_usage_network_types);
    }

    /**
     * Check if matches Ethernet network template.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:19.283 -0500", hash_original_method = "A66E0F5FCADB4F7B6C8822100B46777D", hash_generated_method = "77039782A0E5E9CBF61566D85A23A4AD")
    
private boolean matchesEthernet(NetworkIdentity ident) {
        if (ident.mType == TYPE_ETHERNET) {
            return true;
        }
        return false;
    }
    // orphaned legacy method
    public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }
    
    // orphaned legacy method
    public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    
}

