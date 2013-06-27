package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.848 -0400", hash_original_field = "2532E26E563B8CCB0666E9168F784D0B", hash_generated_field = "D0FA22F19C60C7D870BF0A9AE53EB17C")

    private int mMatchRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.848 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "A7B8730BE01D0326C5198382C94E4F46")

    private String mSubscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.850 -0400", hash_original_method = "FD7BCAE9218E775535D7C5C898F0D923", hash_generated_method = "CE8152D74D27C01C071E095B44F7971E")
    public  NetworkTemplate(int matchRule, String subscriberId) {
        this.mMatchRule = matchRule;
        this.mSubscriberId = subscriberId;
        // ---------- Original Method ----------
        //this.mMatchRule = matchRule;
        //this.mSubscriberId = subscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.851 -0400", hash_original_method = "467A86E8EFDDFF4383A8018B1ADE829F", hash_generated_method = "74AE2D4F62712F633F7706FDACDCA097")
    private  NetworkTemplate(Parcel in) {
        mMatchRule = in.readInt();
        mSubscriberId = in.readString();
        // ---------- Original Method ----------
        //mMatchRule = in.readInt();
        //mSubscriberId = in.readString();
    }

    
        public static NetworkTemplate buildTemplateMobileAll(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_ALL, subscriberId);
    }

    
        public static NetworkTemplate buildTemplateMobile3gLower(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_3G_LOWER, subscriberId);
    }

    
        public static NetworkTemplate buildTemplateMobile4g(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_4G, subscriberId);
    }

    
        public static NetworkTemplate buildTemplateWifi() {
        return new NetworkTemplate(MATCH_WIFI, null);
    }

    
        public static NetworkTemplate buildTemplateEthernet() {
        return new NetworkTemplate(MATCH_ETHERNET, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.863 -0400", hash_original_method = "16E233F925554B3B88BD36CB1859F60A", hash_generated_method = "2DA687ACC4EBBEDE30E4D536F19C81E9")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mMatchRule);
        dest.writeString(mSubscriberId);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mMatchRule);
        //dest.writeString(mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.864 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B35F9EC9EBA64A9015F2A8D3EE9A50BD")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258656572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258656572;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.885 -0400", hash_original_method = "743C43E5DEE5FAC4123020B60468B1AB", hash_generated_method = "07D6ED82A31B410609D6696410135EAB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_508561636 = null; //Variable for return #1
        String scrubSubscriberId;
        scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        varB4EAC82CA7396A68D541C85D26508E83_508561636 = "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                + scrubSubscriberId;
        varB4EAC82CA7396A68D541C85D26508E83_508561636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_508561636;
        // ---------- Original Method ----------
        //final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        //return "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                //+ scrubSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.886 -0400", hash_original_method = "61F711039243E011B66A7D31CCB469F2", hash_generated_method = "5FB836D0D97071FDA029D5A167EC4350")
    @Override
    public int hashCode() {
        int var5903D3463C4117DDC92BFB75357FD987_1529894477 = (Objects.hashCode(mMatchRule, mSubscriberId));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_186657109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_186657109;
        // ---------- Original Method ----------
        //return Objects.hashCode(mMatchRule, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.887 -0400", hash_original_method = "97109AC3BBA8BEF8ECFCD42700ABFADC", hash_generated_method = "A539A302A6DAAAD9DFB7B86FA9515628")
    @Override
    public boolean equals(Object obj) {
        {
            NetworkTemplate other;
            other = (NetworkTemplate) obj;
            boolean var67D3C77A149DB63592FE7663B20E776D_2106510850 = (mMatchRule == other.mMatchRule
                    && Objects.equal(mSubscriberId, other.mSubscriberId));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1325473669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1325473669;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkTemplate) {
            //final NetworkTemplate other = (NetworkTemplate) obj;
            //return mMatchRule == other.mMatchRule
                    //&& Objects.equal(mSubscriberId, other.mSubscriberId);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.887 -0400", hash_original_method = "F3B6429C6B29080B6AB6244CD6E2C6C6", hash_generated_method = "19910834F9906A9148B9B8C954F78007")
    public int getMatchRule() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836546297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836546297;
        // ---------- Original Method ----------
        //return mMatchRule;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.888 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "FA3E5FB368EECDFF47E542A3454D2D3C")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1700451960 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1700451960 = mSubscriberId;
        varB4EAC82CA7396A68D541C85D26508E83_1700451960.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1700451960;
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.901 -0400", hash_original_method = "9C317DAC08BBC55C4495C595EA5A7F8A", hash_generated_method = "75821DF43C87FF1BD7A3862BF89C6F1F")
    public boolean matches(NetworkIdentity ident) {
        //Begin case MATCH_MOBILE_ALL 
        boolean var27F3C9C9886A4B3E59CA64C666369B54_2065865689 = (matchesMobile(ident));
        //End case MATCH_MOBILE_ALL 
        //Begin case MATCH_MOBILE_3G_LOWER 
        boolean var997543972248F97D7F290C9235B6C3B4_1948224736 = (matchesMobile3gLower(ident));
        //End case MATCH_MOBILE_3G_LOWER 
        //Begin case MATCH_MOBILE_4G 
        boolean var279FDC683639FF1E4965F9BB512C163D_575409798 = (matchesMobile4g(ident));
        //End case MATCH_MOBILE_4G 
        //Begin case MATCH_WIFI 
        boolean varC14BD0EB62533D621E51A3121D089961_2005431733 = (matchesWifi(ident));
        //End case MATCH_WIFI 
        //Begin case MATCH_ETHERNET 
        boolean varD3707DDFF0F39513E3FAE3291923C228_1771893579 = (matchesEthernet(ident));
        //End case MATCH_ETHERNET 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown network template");
        //End case default 
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996325661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996325661;
        // ---------- Original Method ----------
        //switch (mMatchRule) {
            //case MATCH_MOBILE_ALL:
                //return matchesMobile(ident);
            //case MATCH_MOBILE_3G_LOWER:
                //return matchesMobile3gLower(ident);
            //case MATCH_MOBILE_4G:
                //return matchesMobile4g(ident);
            //case MATCH_WIFI:
                //return matchesWifi(ident);
            //case MATCH_ETHERNET:
                //return matchesEthernet(ident);
            //default:
                //throw new IllegalArgumentException("unknown network template");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.912 -0400", hash_original_method = "BBF3C380B9774B27B4245C54F7894533", hash_generated_method = "E126A0FFFBDB1AC320CAF4117CE0F317")
    private boolean matchesMobile(NetworkIdentity ident) {
        {
            boolean var3DC0FC46DFF2E897F05D8E47FB3E143C_790721135 = ((contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)));
        } //End block
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421720765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421720765;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIMAX) {
            //return true;
        //} else {
            //return (contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.913 -0400", hash_original_method = "0F24D42BACA619E1B4D2A14C838DE427", hash_generated_method = "BC99B195BA08E80F8A85FB96C73EB1E1")
    private boolean matchesMobile3gLower(NetworkIdentity ident) {
        {
            boolean varE122418F6165DABA92A5320632EF3C50_1020070135 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_797151444 = (getNetworkClass(ident.mSubType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018270217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018270217;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIMAX) {
            //return false;
        //} else if (matchesMobile(ident)) {
            //switch (getNetworkClass(ident.mSubType)) {
                //case NETWORK_CLASS_UNKNOWN:
                //case NETWORK_CLASS_2_G:
                //case NETWORK_CLASS_3_G:
                    //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.913 -0400", hash_original_method = "B7894A7F3E04E8F81CBF1F61E6B8AB40", hash_generated_method = "A6F5BCC919076751DE60403FDC395391")
    private boolean matchesMobile4g(NetworkIdentity ident) {
        {
            boolean varE122418F6165DABA92A5320632EF3C50_1257374993 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_1313472537 = (getNetworkClass(ident.mSubType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140516285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140516285;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIMAX) {
            //return true;
        //} else if (matchesMobile(ident)) {
            //switch (getNetworkClass(ident.mSubType)) {
                //case NETWORK_CLASS_4_G:
                    //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.914 -0400", hash_original_method = "FC1062696978183943559E1C2F0FCB30", hash_generated_method = "DE4888D1534E96E86BCB776A84598E7B")
    private boolean matchesWifi(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1403476256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1403476256;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIFI) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.926 -0400", hash_original_method = "A66E0F5FCADB4F7B6C8822100B46777D", hash_generated_method = "D466EB208DB5B2F4247992FD3D0E4DAC")
    private boolean matchesEthernet(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_887338283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_887338283;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_ETHERNET) {
            //return true;
        //}
        //return false;
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.927 -0400", hash_original_field = "52960A983F9BBB24A5319758FBB3805E", hash_generated_field = "10580A21BB1F38D4B241BBA4C0583CDB")

    public static final int MATCH_MOBILE_ALL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.927 -0400", hash_original_field = "93E9C4C3E4F480B1F22C6421B83BA570", hash_generated_field = "3EEF691932FB8D316E34D113594AEB06")

    public static final int MATCH_MOBILE_3G_LOWER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.927 -0400", hash_original_field = "FEA822AFE5F6A9E63C106E509D6659DB", hash_generated_field = "A98607B1D2E2344818AF66A8664831D7")

    public static final int MATCH_MOBILE_4G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.928 -0400", hash_original_field = "6A5D598B93027622DF9463ADF84D87AF", hash_generated_field = "218772946764EB383CA6212569A1D95B")

    public static final int MATCH_WIFI = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.928 -0400", hash_original_field = "CB89A2209BD2BE1B17AEC7836C6C7D8B", hash_generated_field = "4AED7ABDBBD241274554C6BF86E04300")

    public static final int MATCH_ETHERNET = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.928 -0400", hash_original_field = "C7C2939A45DE8849F0F84B0ACC427DC9", hash_generated_field = "4DA4B496DC05D75AC80944B686BBFECA")

    private static int[] DATA_USAGE_NETWORK_TYPES;
    static {
        DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(
                com.android.internal.R.array.config_data_usage_network_types);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:19.928 -0400", hash_original_field = "88BA2DACBA38DAF918A0D3C1F5E00E22", hash_generated_field = "6C4E6CCCA93A0F55B381916949674798")

    public static final Creator<NetworkTemplate> CREATOR = new Creator<NetworkTemplate>() {
        public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }

        public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    };
}

