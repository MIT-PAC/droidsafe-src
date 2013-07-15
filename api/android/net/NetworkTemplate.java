package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.246 -0400", hash_original_field = "2532E26E563B8CCB0666E9168F784D0B", hash_generated_field = "D0FA22F19C60C7D870BF0A9AE53EB17C")

    private int mMatchRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.246 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "A7B8730BE01D0326C5198382C94E4F46")

    private String mSubscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.247 -0400", hash_original_method = "FD7BCAE9218E775535D7C5C898F0D923", hash_generated_method = "CE8152D74D27C01C071E095B44F7971E")
    public  NetworkTemplate(int matchRule, String subscriberId) {
        this.mMatchRule = matchRule;
        this.mSubscriberId = subscriberId;
        // ---------- Original Method ----------
        //this.mMatchRule = matchRule;
        //this.mSubscriberId = subscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.248 -0400", hash_original_method = "467A86E8EFDDFF4383A8018B1ADE829F", hash_generated_method = "74AE2D4F62712F633F7706FDACDCA097")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.249 -0400", hash_original_method = "16E233F925554B3B88BD36CB1859F60A", hash_generated_method = "35C553513973EFA3AC4783478FA2D6FC")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mMatchRule);
        dest.writeString(mSubscriberId);
        // ---------- Original Method ----------
        //dest.writeInt(mMatchRule);
        //dest.writeString(mSubscriberId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.250 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4AB8BC44CD569361098FD13833960DFA")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_102665453 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593651353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593651353;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.250 -0400", hash_original_method = "743C43E5DEE5FAC4123020B60468B1AB", hash_generated_method = "AC530EE50EF745AE5E8AAECE796503B7")
    @Override
    public String toString() {
        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
String var0E2445C90F2AA1F9B41E1C80D9B6FAF4_401013337 =         "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                + scrubSubscriberId;
        var0E2445C90F2AA1F9B41E1C80D9B6FAF4_401013337.addTaint(taint);
        return var0E2445C90F2AA1F9B41E1C80D9B6FAF4_401013337;
        // ---------- Original Method ----------
        //final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        //return "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                //+ scrubSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.250 -0400", hash_original_method = "61F711039243E011B66A7D31CCB469F2", hash_generated_method = "9B48EE34A22F0364623AD7AE823182CA")
    @Override
    public int hashCode() {
        int var72B3AA903BB16B9EE6C65F9464B56C62_1198940432 = (Objects.hashCode(mMatchRule, mSubscriberId));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074495633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074495633;
        // ---------- Original Method ----------
        //return Objects.hashCode(mMatchRule, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.251 -0400", hash_original_method = "97109AC3BBA8BEF8ECFCD42700ABFADC", hash_generated_method = "3EBDC86A0AFC706E2B1B9A9E1CCC055F")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj instanceof NetworkTemplate)        
        {
            final NetworkTemplate other = (NetworkTemplate) obj;
            boolean varF097DCBDAA2B0CB7B8EDB48AFA3FAE2D_814632934 = (mMatchRule == other.mMatchRule
                    && Objects.equal(mSubscriberId, other.mSubscriberId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257308816 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_257308816;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1039657182 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1329318015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1329318015;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkTemplate) {
            //final NetworkTemplate other = (NetworkTemplate) obj;
            //return mMatchRule == other.mMatchRule
                    //&& Objects.equal(mSubscriberId, other.mSubscriberId);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.251 -0400", hash_original_method = "F3B6429C6B29080B6AB6244CD6E2C6C6", hash_generated_method = "BACAFD3023DCF4534C3C4D2F37936AB1")
    public int getMatchRule() {
        int var2532E26E563B8CCB0666E9168F784D0B_1192018864 = (mMatchRule);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100997261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100997261;
        // ---------- Original Method ----------
        //return mMatchRule;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.251 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "BD698BFF5F93314AA90551AB4C8DFCAD")
    public String getSubscriberId() {
String varD221C4376DC09E8E422076D12DB9853B_113189750 =         mSubscriberId;
        varD221C4376DC09E8E422076D12DB9853B_113189750.addTaint(taint);
        return varD221C4376DC09E8E422076D12DB9853B_113189750;
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.252 -0400", hash_original_method = "9C317DAC08BBC55C4495C595EA5A7F8A", hash_generated_method = "438B27595FDA2D046211E080DC494204")
    public boolean matches(NetworkIdentity ident) {
        addTaint(ident.getTaint());
switch(mMatchRule){
        case MATCH_MOBILE_ALL:
        boolean var2E5167146883B91593C7B96FC6DDBAF1_405644506 = (matchesMobile(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1050404138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1050404138;
        case MATCH_MOBILE_3G_LOWER:
        boolean var4C1FC854E9FBDC6115CAC0AED51FE8F0_260509721 = (matchesMobile3gLower(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1808096163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1808096163;
        case MATCH_MOBILE_4G:
        boolean var79FA0B5280670534A1220C90C86A2601_1045659331 = (matchesMobile4g(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1184373489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1184373489;
        case MATCH_WIFI:
        boolean var962AB793D4BD4DD28E5FA6036D39CDBE_281469834 = (matchesWifi(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950884421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950884421;
        case MATCH_ETHERNET:
        boolean var09DE9636D2009C1BC8193BCAB25C3B62_390677142 = (matchesEthernet(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485088844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485088844;
        default:
        IllegalArgumentException varF3A68B27E2471C47B13F74F8DD0D3C5D_503418931 = new IllegalArgumentException("unknown network template");
        varF3A68B27E2471C47B13F74F8DD0D3C5D_503418931.addTaint(taint);
        throw varF3A68B27E2471C47B13F74F8DD0D3C5D_503418931;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.252 -0400", hash_original_method = "BBF3C380B9774B27B4245C54F7894533", hash_generated_method = "7E6AED56B3DEB273F9D91CE92B53CC0A")
    private boolean matchesMobile(NetworkIdentity ident) {
        addTaint(ident.getTaint());
    if(ident.mType == TYPE_WIMAX)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_339743327 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899445477 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899445477;
        } //End block
        else
        {
            boolean varF17EE3108088E49AFAD2EFED58BDDCB8_614212292 = ((contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_525011883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_525011883;
        } //End block
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIMAX) {
            //return true;
        //} else {
            //return (contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.252 -0400", hash_original_method = "0F24D42BACA619E1B4D2A14C838DE427", hash_generated_method = "56B2C43D124BE6BFA98815DB45E517A7")
    private boolean matchesMobile3gLower(NetworkIdentity ident) {
        addTaint(ident.getTaint());
    if(ident.mType == TYPE_WIMAX)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1219146043 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827310631 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827310631;
        } //End block
        else
    if(matchesMobile(ident))        
        {
switch(getNetworkClass(ident.mSubType)){
            case NETWORK_CLASS_UNKNOWN:
            case NETWORK_CLASS_2_G:
            case NETWORK_CLASS_3_G:
            boolean varB326B5062B2F0E69046810717534CB09_2010743107 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962641840 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_962641840;
}
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1977785324 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711812462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711812462;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.253 -0400", hash_original_method = "B7894A7F3E04E8F81CBF1F61E6B8AB40", hash_generated_method = "43F6C4EA197AFC8ED24F358E9ED09A42")
    private boolean matchesMobile4g(NetworkIdentity ident) {
        addTaint(ident.getTaint());
    if(ident.mType == TYPE_WIMAX)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1190794829 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742511845 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_742511845;
        } //End block
        else
    if(matchesMobile(ident))        
        {
switch(getNetworkClass(ident.mSubType)){
            case NETWORK_CLASS_4_G:
            boolean varB326B5062B2F0E69046810717534CB09_1308640951 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728558463 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_728558463;
}
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1681360897 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995989000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995989000;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.254 -0400", hash_original_method = "FC1062696978183943559E1C2F0FCB30", hash_generated_method = "3CFE1D5318A65187F0238823E9E94F52")
    private boolean matchesWifi(NetworkIdentity ident) {
        addTaint(ident.getTaint());
    if(ident.mType == TYPE_WIFI)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_718466528 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708839778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708839778;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2077626417 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011705598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011705598;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIFI) {
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.254 -0400", hash_original_method = "A66E0F5FCADB4F7B6C8822100B46777D", hash_generated_method = "8817743E74CE44FBF10A833532324784")
    private boolean matchesEthernet(NetworkIdentity ident) {
        addTaint(ident.getTaint());
    if(ident.mType == TYPE_ETHERNET)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1165804846 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241952729 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241952729;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1897931767 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_849975984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_849975984;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_ETHERNET) {
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.254 -0400", hash_original_field = "52960A983F9BBB24A5319758FBB3805E", hash_generated_field = "10580A21BB1F38D4B241BBA4C0583CDB")

    public static final int MATCH_MOBILE_ALL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.255 -0400", hash_original_field = "93E9C4C3E4F480B1F22C6421B83BA570", hash_generated_field = "3EEF691932FB8D316E34D113594AEB06")

    public static final int MATCH_MOBILE_3G_LOWER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.255 -0400", hash_original_field = "FEA822AFE5F6A9E63C106E509D6659DB", hash_generated_field = "A98607B1D2E2344818AF66A8664831D7")

    public static final int MATCH_MOBILE_4G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.255 -0400", hash_original_field = "6A5D598B93027622DF9463ADF84D87AF", hash_generated_field = "218772946764EB383CA6212569A1D95B")

    public static final int MATCH_WIFI = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.255 -0400", hash_original_field = "CB89A2209BD2BE1B17AEC7836C6C7D8B", hash_generated_field = "4AED7ABDBBD241274554C6BF86E04300")

    public static final int MATCH_ETHERNET = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.255 -0400", hash_original_field = "C7C2939A45DE8849F0F84B0ACC427DC9", hash_generated_field = "4DA4B496DC05D75AC80944B686BBFECA")

    private static int[] DATA_USAGE_NETWORK_TYPES;
    static {
        DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(
                com.android.internal.R.array.config_data_usage_network_types);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.255 -0400", hash_original_field = "88BA2DACBA38DAF918A0D3C1F5E00E22", hash_generated_field = "6C4E6CCCA93A0F55B381916949674798")

    public static final Creator<NetworkTemplate> CREATOR = new Creator<NetworkTemplate>() {
        public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }

        public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    };
    // orphaned legacy method
    public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }
    
    // orphaned legacy method
    public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    
}

