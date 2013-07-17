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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.989 -0400", hash_original_field = "2532E26E563B8CCB0666E9168F784D0B", hash_generated_field = "D0FA22F19C60C7D870BF0A9AE53EB17C")

    private int mMatchRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.989 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "A7B8730BE01D0326C5198382C94E4F46")

    private String mSubscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.990 -0400", hash_original_method = "FD7BCAE9218E775535D7C5C898F0D923", hash_generated_method = "CE8152D74D27C01C071E095B44F7971E")
    public  NetworkTemplate(int matchRule, String subscriberId) {
        this.mMatchRule = matchRule;
        this.mSubscriberId = subscriberId;
        // ---------- Original Method ----------
        //this.mMatchRule = matchRule;
        //this.mSubscriberId = subscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.990 -0400", hash_original_method = "467A86E8EFDDFF4383A8018B1ADE829F", hash_generated_method = "74AE2D4F62712F633F7706FDACDCA097")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.010 -0400", hash_original_method = "16E233F925554B3B88BD36CB1859F60A", hash_generated_method = "35C553513973EFA3AC4783478FA2D6FC")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.010 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E61E3387AD0150ACB343351915C4E788")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_333488581 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87713848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87713848;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.010 -0400", hash_original_method = "743C43E5DEE5FAC4123020B60468B1AB", hash_generated_method = "A65626757C409527D7CB889A29449862")
    @Override
    public String toString() {
        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
String var0E2445C90F2AA1F9B41E1C80D9B6FAF4_2024865222 =         "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                + scrubSubscriberId;
        var0E2445C90F2AA1F9B41E1C80D9B6FAF4_2024865222.addTaint(taint);
        return var0E2445C90F2AA1F9B41E1C80D9B6FAF4_2024865222;
        // ---------- Original Method ----------
        //final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        //return "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                //+ scrubSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.010 -0400", hash_original_method = "61F711039243E011B66A7D31CCB469F2", hash_generated_method = "45569EE3500C6F5153C5F5C35F8D4CB7")
    @Override
    public int hashCode() {
        int var72B3AA903BB16B9EE6C65F9464B56C62_1892234049 = (Objects.hashCode(mMatchRule, mSubscriberId));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145859030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145859030;
        // ---------- Original Method ----------
        //return Objects.hashCode(mMatchRule, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.011 -0400", hash_original_method = "97109AC3BBA8BEF8ECFCD42700ABFADC", hash_generated_method = "EBBB609A3615A72DBFE0BD038EA9736B")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj instanceof NetworkTemplate)        
        {
            final NetworkTemplate other = (NetworkTemplate) obj;
            boolean varF097DCBDAA2B0CB7B8EDB48AFA3FAE2D_1819595386 = (mMatchRule == other.mMatchRule
                    && Objects.equal(mSubscriberId, other.mSubscriberId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081862717 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081862717;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1509560273 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1943752900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1943752900;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkTemplate) {
            //final NetworkTemplate other = (NetworkTemplate) obj;
            //return mMatchRule == other.mMatchRule
                    //&& Objects.equal(mSubscriberId, other.mSubscriberId);
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.011 -0400", hash_original_method = "F3B6429C6B29080B6AB6244CD6E2C6C6", hash_generated_method = "69B72BD55EA37F269100E7CD95841272")
    public int getMatchRule() {
        int var2532E26E563B8CCB0666E9168F784D0B_181029143 = (mMatchRule);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674893676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674893676;
        // ---------- Original Method ----------
        //return mMatchRule;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.011 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "9074180FFBEF062CA885461E24E2DDB6")
    public String getSubscriberId() {
String varD221C4376DC09E8E422076D12DB9853B_2111694230 =         mSubscriberId;
        varD221C4376DC09E8E422076D12DB9853B_2111694230.addTaint(taint);
        return varD221C4376DC09E8E422076D12DB9853B_2111694230;
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.011 -0400", hash_original_method = "9C317DAC08BBC55C4495C595EA5A7F8A", hash_generated_method = "F77494D6B20F97C2EEAC3756F1722919")
    public boolean matches(NetworkIdentity ident) {
        addTaint(ident.getTaint());
switch(mMatchRule){
        case MATCH_MOBILE_ALL:
        boolean var2E5167146883B91593C7B96FC6DDBAF1_1083675950 = (matchesMobile(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141636157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141636157;
        case MATCH_MOBILE_3G_LOWER:
        boolean var4C1FC854E9FBDC6115CAC0AED51FE8F0_1937845184 = (matchesMobile3gLower(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495196343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495196343;
        case MATCH_MOBILE_4G:
        boolean var79FA0B5280670534A1220C90C86A2601_1106287382 = (matchesMobile4g(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164777234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_164777234;
        case MATCH_WIFI:
        boolean var962AB793D4BD4DD28E5FA6036D39CDBE_1256453357 = (matchesWifi(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_239847594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_239847594;
        case MATCH_ETHERNET:
        boolean var09DE9636D2009C1BC8193BCAB25C3B62_168481984 = (matchesEthernet(ident));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201863682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201863682;
        default:
        IllegalArgumentException varF3A68B27E2471C47B13F74F8DD0D3C5D_217444401 = new IllegalArgumentException("unknown network template");
        varF3A68B27E2471C47B13F74F8DD0D3C5D_217444401.addTaint(taint);
        throw varF3A68B27E2471C47B13F74F8DD0D3C5D_217444401;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.012 -0400", hash_original_method = "BBF3C380B9774B27B4245C54F7894533", hash_generated_method = "C5C4CE7AA0DCEB31F017E1926B89C04E")
    private boolean matchesMobile(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        if(ident.mType == TYPE_WIMAX)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1504281420 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1223362587 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1223362587;
        } //End block
        else
        {
            boolean varF17EE3108088E49AFAD2EFED58BDDCB8_963636082 = ((contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879725335 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879725335;
        } //End block
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIMAX) {
            //return true;
        //} else {
            //return (contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.012 -0400", hash_original_method = "0F24D42BACA619E1B4D2A14C838DE427", hash_generated_method = "5AE5D9F8E6C164597AF8A819D6C71EF0")
    private boolean matchesMobile3gLower(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        if(ident.mType == TYPE_WIMAX)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1083677657 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809113209 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809113209;
        } //End block
        else
        if(matchesMobile(ident))        
        {
switch(getNetworkClass(ident.mSubType)){
            case NETWORK_CLASS_UNKNOWN:
            case NETWORK_CLASS_2_G:
            case NETWORK_CLASS_3_G:
            boolean varB326B5062B2F0E69046810717534CB09_1271797806 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370983155 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370983155;
}
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_518555446 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_477575457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_477575457;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_method = "B7894A7F3E04E8F81CBF1F61E6B8AB40", hash_generated_method = "77B1C6F187ABDA7957CB5329547CA583")
    private boolean matchesMobile4g(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        if(ident.mType == TYPE_WIMAX)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1487490079 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161091302 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161091302;
        } //End block
        else
        if(matchesMobile(ident))        
        {
switch(getNetworkClass(ident.mSubType)){
            case NETWORK_CLASS_4_G:
            boolean varB326B5062B2F0E69046810717534CB09_1458102756 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310801424 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310801424;
}
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1435820475 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637341743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637341743;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_method = "FC1062696978183943559E1C2F0FCB30", hash_generated_method = "8E1A0D65FCBCED408D3E24474A63235F")
    private boolean matchesWifi(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        if(ident.mType == TYPE_WIFI)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_749249449 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609594779 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609594779;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_499353932 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_320957240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_320957240;
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIFI) {
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_method = "A66E0F5FCADB4F7B6C8822100B46777D", hash_generated_method = "75D0F87D1D3876C713F6EC73B5411EAC")
    private boolean matchesEthernet(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        if(ident.mType == TYPE_ETHERNET)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1674483345 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745070341 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_745070341;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1058542668 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547300516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547300516;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_field = "52960A983F9BBB24A5319758FBB3805E", hash_generated_field = "10580A21BB1F38D4B241BBA4C0583CDB")

    public static final int MATCH_MOBILE_ALL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_field = "93E9C4C3E4F480B1F22C6421B83BA570", hash_generated_field = "3EEF691932FB8D316E34D113594AEB06")

    public static final int MATCH_MOBILE_3G_LOWER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_field = "FEA822AFE5F6A9E63C106E509D6659DB", hash_generated_field = "A98607B1D2E2344818AF66A8664831D7")

    public static final int MATCH_MOBILE_4G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_field = "6A5D598B93027622DF9463ADF84D87AF", hash_generated_field = "218772946764EB383CA6212569A1D95B")

    public static final int MATCH_WIFI = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_field = "CB89A2209BD2BE1B17AEC7836C6C7D8B", hash_generated_field = "4AED7ABDBBD241274554C6BF86E04300")

    public static final int MATCH_ETHERNET = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.013 -0400", hash_original_field = "C7C2939A45DE8849F0F84B0ACC427DC9", hash_generated_field = "4DA4B496DC05D75AC80944B686BBFECA")

    private static int[] DATA_USAGE_NETWORK_TYPES;
    static {
        DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(
                com.android.internal.R.array.config_data_usage_network_types);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.014 -0400", hash_original_field = "88BA2DACBA38DAF918A0D3C1F5E00E22", hash_generated_field = "6C4E6CCCA93A0F55B381916949674798")

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

