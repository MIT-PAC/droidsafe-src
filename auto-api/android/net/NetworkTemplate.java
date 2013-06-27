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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.496 -0400", hash_original_field = "2532E26E563B8CCB0666E9168F784D0B", hash_generated_field = "D0FA22F19C60C7D870BF0A9AE53EB17C")

    private int mMatchRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.496 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "A7B8730BE01D0326C5198382C94E4F46")

    private String mSubscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.497 -0400", hash_original_method = "FD7BCAE9218E775535D7C5C898F0D923", hash_generated_method = "CE8152D74D27C01C071E095B44F7971E")
    public  NetworkTemplate(int matchRule, String subscriberId) {
        this.mMatchRule = matchRule;
        this.mSubscriberId = subscriberId;
        // ---------- Original Method ----------
        //this.mMatchRule = matchRule;
        //this.mSubscriberId = subscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.498 -0400", hash_original_method = "467A86E8EFDDFF4383A8018B1ADE829F", hash_generated_method = "74AE2D4F62712F633F7706FDACDCA097")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.515 -0400", hash_original_method = "16E233F925554B3B88BD36CB1859F60A", hash_generated_method = "2DA687ACC4EBBEDE30E4D536F19C81E9")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mMatchRule);
        dest.writeString(mSubscriberId);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mMatchRule);
        //dest.writeString(mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.516 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D81E6E3B5195D914502623FA3A9EAA75")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652373713 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652373713;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.523 -0400", hash_original_method = "743C43E5DEE5FAC4123020B60468B1AB", hash_generated_method = "CDD0C205EA2FC03D3647F234F36D7386")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_941300388 = null; //Variable for return #1
        String scrubSubscriberId;
        scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        varB4EAC82CA7396A68D541C85D26508E83_941300388 = "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                + scrubSubscriberId;
        varB4EAC82CA7396A68D541C85D26508E83_941300388.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_941300388;
        // ---------- Original Method ----------
        //final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        //return "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                //+ scrubSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.526 -0400", hash_original_method = "61F711039243E011B66A7D31CCB469F2", hash_generated_method = "E4BF80DD0471B55CC3FE6246E8518077")
    @Override
    public int hashCode() {
        int var5903D3463C4117DDC92BFB75357FD987_1278584731 = (Objects.hashCode(mMatchRule, mSubscriberId));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719625096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719625096;
        // ---------- Original Method ----------
        //return Objects.hashCode(mMatchRule, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.529 -0400", hash_original_method = "97109AC3BBA8BEF8ECFCD42700ABFADC", hash_generated_method = "638F34E49180B5E33E394617B14D422A")
    @Override
    public boolean equals(Object obj) {
        {
            NetworkTemplate other;
            other = (NetworkTemplate) obj;
            boolean var67D3C77A149DB63592FE7663B20E776D_453820349 = (mMatchRule == other.mMatchRule
                    && Objects.equal(mSubscriberId, other.mSubscriberId));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500502331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500502331;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkTemplate) {
            //final NetworkTemplate other = (NetworkTemplate) obj;
            //return mMatchRule == other.mMatchRule
                    //&& Objects.equal(mSubscriberId, other.mSubscriberId);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.529 -0400", hash_original_method = "F3B6429C6B29080B6AB6244CD6E2C6C6", hash_generated_method = "7151F9B6782FA90910B03D12F029481B")
    public int getMatchRule() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699566494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699566494;
        // ---------- Original Method ----------
        //return mMatchRule;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.541 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "2D8C0F8D186D84797D5EC42FD2C56C92")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_439651289 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_439651289 = mSubscriberId;
        varB4EAC82CA7396A68D541C85D26508E83_439651289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439651289;
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.542 -0400", hash_original_method = "9C317DAC08BBC55C4495C595EA5A7F8A", hash_generated_method = "D652079EC26D6333C3B18470F66C2ADD")
    public boolean matches(NetworkIdentity ident) {
        //Begin case MATCH_MOBILE_ALL 
        boolean var27F3C9C9886A4B3E59CA64C666369B54_321508925 = (matchesMobile(ident));
        //End case MATCH_MOBILE_ALL 
        //Begin case MATCH_MOBILE_3G_LOWER 
        boolean var997543972248F97D7F290C9235B6C3B4_2136662089 = (matchesMobile3gLower(ident));
        //End case MATCH_MOBILE_3G_LOWER 
        //Begin case MATCH_MOBILE_4G 
        boolean var279FDC683639FF1E4965F9BB512C163D_421393398 = (matchesMobile4g(ident));
        //End case MATCH_MOBILE_4G 
        //Begin case MATCH_WIFI 
        boolean varC14BD0EB62533D621E51A3121D089961_375330197 = (matchesWifi(ident));
        //End case MATCH_WIFI 
        //Begin case MATCH_ETHERNET 
        boolean varD3707DDFF0F39513E3FAE3291923C228_1017494040 = (matchesEthernet(ident));
        //End case MATCH_ETHERNET 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown network template");
        //End case default 
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737518377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737518377;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.543 -0400", hash_original_method = "BBF3C380B9774B27B4245C54F7894533", hash_generated_method = "C9A44B5BF2C7D151B54020C3BF63A25F")
    private boolean matchesMobile(NetworkIdentity ident) {
        {
            boolean var3DC0FC46DFF2E897F05D8E47FB3E143C_1358213164 = ((contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)));
        } //End block
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046612504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046612504;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIMAX) {
            //return true;
        //} else {
            //return (contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.549 -0400", hash_original_method = "0F24D42BACA619E1B4D2A14C838DE427", hash_generated_method = "84508425C074DBADD8B0316E426ED3E1")
    private boolean matchesMobile3gLower(NetworkIdentity ident) {
        {
            boolean varE122418F6165DABA92A5320632EF3C50_1084027370 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_821128697 = (getNetworkClass(ident.mSubType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548721576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548721576;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.550 -0400", hash_original_method = "B7894A7F3E04E8F81CBF1F61E6B8AB40", hash_generated_method = "3E6B514620A9331E66A27B9639317B70")
    private boolean matchesMobile4g(NetworkIdentity ident) {
        {
            boolean varE122418F6165DABA92A5320632EF3C50_2136216373 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_81989964 = (getNetworkClass(ident.mSubType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472011338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472011338;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.555 -0400", hash_original_method = "FC1062696978183943559E1C2F0FCB30", hash_generated_method = "199811FB06729835CC58278C357B7533")
    private boolean matchesWifi(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117809563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_117809563;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIFI) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.555 -0400", hash_original_method = "A66E0F5FCADB4F7B6C8822100B46777D", hash_generated_method = "C5B296F33335332D7E3A2EF1213E7E2C")
    private boolean matchesEthernet(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070911187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070911187;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.558 -0400", hash_original_field = "52960A983F9BBB24A5319758FBB3805E", hash_generated_field = "10580A21BB1F38D4B241BBA4C0583CDB")

    public static final int MATCH_MOBILE_ALL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.558 -0400", hash_original_field = "93E9C4C3E4F480B1F22C6421B83BA570", hash_generated_field = "3EEF691932FB8D316E34D113594AEB06")

    public static final int MATCH_MOBILE_3G_LOWER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.559 -0400", hash_original_field = "FEA822AFE5F6A9E63C106E509D6659DB", hash_generated_field = "A98607B1D2E2344818AF66A8664831D7")

    public static final int MATCH_MOBILE_4G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.559 -0400", hash_original_field = "6A5D598B93027622DF9463ADF84D87AF", hash_generated_field = "218772946764EB383CA6212569A1D95B")

    public static final int MATCH_WIFI = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.562 -0400", hash_original_field = "CB89A2209BD2BE1B17AEC7836C6C7D8B", hash_generated_field = "4AED7ABDBBD241274554C6BF86E04300")

    public static final int MATCH_ETHERNET = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.562 -0400", hash_original_field = "C7C2939A45DE8849F0F84B0ACC427DC9", hash_generated_field = "4DA4B496DC05D75AC80944B686BBFECA")

    private static int[] DATA_USAGE_NETWORK_TYPES;
    static {
        DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(
                com.android.internal.R.array.config_data_usage_network_types);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:21.562 -0400", hash_original_field = "88BA2DACBA38DAF918A0D3C1F5E00E22", hash_generated_field = "6C4E6CCCA93A0F55B381916949674798")

    public static final Creator<NetworkTemplate> CREATOR = new Creator<NetworkTemplate>() {
        public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }

        public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    };
}

