package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.803 -0400", hash_original_field = "2532E26E563B8CCB0666E9168F784D0B", hash_generated_field = "D0FA22F19C60C7D870BF0A9AE53EB17C")

    private int mMatchRule;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.803 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "A7B8730BE01D0326C5198382C94E4F46")

    private String mSubscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.804 -0400", hash_original_method = "FD7BCAE9218E775535D7C5C898F0D923", hash_generated_method = "CE8152D74D27C01C071E095B44F7971E")
    public  NetworkTemplate(int matchRule, String subscriberId) {
        this.mMatchRule = matchRule;
        this.mSubscriberId = subscriberId;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.804 -0400", hash_original_method = "467A86E8EFDDFF4383A8018B1ADE829F", hash_generated_method = "74AE2D4F62712F633F7706FDACDCA097")
    private  NetworkTemplate(Parcel in) {
        mMatchRule = in.readInt();
        mSubscriberId = in.readString();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static NetworkTemplate buildTemplateMobileAll(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_ALL, subscriberId);
    }

    
    @DSModeled(DSC.SAFE)
    public static NetworkTemplate buildTemplateMobile3gLower(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_3G_LOWER, subscriberId);
    }

    
    @DSModeled(DSC.SAFE)
    public static NetworkTemplate buildTemplateMobile4g(String subscriberId) {
        return new NetworkTemplate(MATCH_MOBILE_4G, subscriberId);
    }

    
    @DSModeled(DSC.SAFE)
    public static NetworkTemplate buildTemplateWifi() {
        return new NetworkTemplate(MATCH_WIFI, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static NetworkTemplate buildTemplateEthernet() {
        return new NetworkTemplate(MATCH_ETHERNET, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.806 -0400", hash_original_method = "16E233F925554B3B88BD36CB1859F60A", hash_generated_method = "2DA687ACC4EBBEDE30E4D536F19C81E9")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mMatchRule);
        dest.writeString(mSubscriberId);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.806 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "84FCC25716E42F41E48E4EB1A99AE330")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520579271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_520579271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.807 -0400", hash_original_method = "743C43E5DEE5FAC4123020B60468B1AB", hash_generated_method = "B69210FB3A891DE0A1B4A93A829E01D7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1344555604 = null; 
        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        varB4EAC82CA7396A68D541C85D26508E83_1344555604 = "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                + scrubSubscriberId;
        varB4EAC82CA7396A68D541C85D26508E83_1344555604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1344555604;
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.807 -0400", hash_original_method = "61F711039243E011B66A7D31CCB469F2", hash_generated_method = "41BB84B445154C62E503F412B6436F78")
    @Override
    public int hashCode() {
        int var5903D3463C4117DDC92BFB75357FD987_1335095277 = (Objects.hashCode(mMatchRule, mSubscriberId));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911061156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911061156;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.808 -0400", hash_original_method = "97109AC3BBA8BEF8ECFCD42700ABFADC", hash_generated_method = "DBCE72DB951FFFC2403FEA1FF21A4D7B")
    @Override
    public boolean equals(Object obj) {
        {
            final NetworkTemplate other = (NetworkTemplate) obj;
            boolean var67D3C77A149DB63592FE7663B20E776D_752450559 = (mMatchRule == other.mMatchRule
                    && Objects.equal(mSubscriberId, other.mSubscriberId));
        } 
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971690633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971690633;
        
        
            
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.808 -0400", hash_original_method = "F3B6429C6B29080B6AB6244CD6E2C6C6", hash_generated_method = "6839325FA8795B9FD8F1219E7E77C438")
    public int getMatchRule() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934873627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934873627;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.809 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "60EAFB33A09F6A93E21E998B4F21C021")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_220187194 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_220187194 = mSubscriberId;
        varB4EAC82CA7396A68D541C85D26508E83_220187194.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_220187194;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.809 -0400", hash_original_method = "9C317DAC08BBC55C4495C595EA5A7F8A", hash_generated_method = "BF633A4FCFB22F79D24CA982BE864329")
    public boolean matches(NetworkIdentity ident) {
        
        boolean var27F3C9C9886A4B3E59CA64C666369B54_1657513911 = (matchesMobile(ident));
        
        
        boolean var997543972248F97D7F290C9235B6C3B4_1538412120 = (matchesMobile3gLower(ident));
        
        
        boolean var279FDC683639FF1E4965F9BB512C163D_1726121207 = (matchesMobile4g(ident));
        
        
        boolean varC14BD0EB62533D621E51A3121D089961_991639771 = (matchesWifi(ident));
        
        
        boolean varD3707DDFF0F39513E3FAE3291923C228_798150153 = (matchesEthernet(ident));
        
        
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown network template");
        
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643304692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643304692;
        
        
            
                
            
                
            
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.810 -0400", hash_original_method = "BBF3C380B9774B27B4245C54F7894533", hash_generated_method = "88DF2053D62B03F31E06F0308F1B7299")
    private boolean matchesMobile(NetworkIdentity ident) {
        {
            boolean var3DC0FC46DFF2E897F05D8E47FB3E143C_1923331170 = ((contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)));
        } 
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845686087 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_845686087;
        
        
            
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.810 -0400", hash_original_method = "0F24D42BACA619E1B4D2A14C838DE427", hash_generated_method = "3F10D4F258249B13E5E826DE57B980CA")
    private boolean matchesMobile3gLower(NetworkIdentity ident) {
        {
            boolean varE122418F6165DABA92A5320632EF3C50_1076505658 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_180467440 = (getNetworkClass(ident.mSubType));
                } 
            } 
        } 
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607679910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607679910;
        
        
            
        
            
                
                
                
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.811 -0400", hash_original_method = "B7894A7F3E04E8F81CBF1F61E6B8AB40", hash_generated_method = "F6489CA9D7785C83891FB513A15E746E")
    private boolean matchesMobile4g(NetworkIdentity ident) {
        {
            boolean varE122418F6165DABA92A5320632EF3C50_45498679 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_1642947615 = (getNetworkClass(ident.mSubType));
                } 
            } 
        } 
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240619118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240619118;
        
        
            
        
            
                
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.811 -0400", hash_original_method = "FC1062696978183943559E1C2F0FCB30", hash_generated_method = "7F64D6F3B26FB518D686EBA5AD93BDDC")
    private boolean matchesWifi(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870191497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870191497;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.811 -0400", hash_original_method = "A66E0F5FCADB4F7B6C8822100B46777D", hash_generated_method = "804AB48D0C541B1E2FC5CE576341C3B8")
    private boolean matchesEthernet(NetworkIdentity ident) {
        addTaint(ident.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789548566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789548566;
        
        
            
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.812 -0400", hash_original_field = "52960A983F9BBB24A5319758FBB3805E", hash_generated_field = "10580A21BB1F38D4B241BBA4C0583CDB")

    public static final int MATCH_MOBILE_ALL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.812 -0400", hash_original_field = "93E9C4C3E4F480B1F22C6421B83BA570", hash_generated_field = "3EEF691932FB8D316E34D113594AEB06")

    public static final int MATCH_MOBILE_3G_LOWER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.812 -0400", hash_original_field = "FEA822AFE5F6A9E63C106E509D6659DB", hash_generated_field = "A98607B1D2E2344818AF66A8664831D7")

    public static final int MATCH_MOBILE_4G = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.812 -0400", hash_original_field = "6A5D598B93027622DF9463ADF84D87AF", hash_generated_field = "218772946764EB383CA6212569A1D95B")

    public static final int MATCH_WIFI = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.812 -0400", hash_original_field = "CB89A2209BD2BE1B17AEC7836C6C7D8B", hash_generated_field = "4AED7ABDBBD241274554C6BF86E04300")

    public static final int MATCH_ETHERNET = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.812 -0400", hash_original_field = "C7C2939A45DE8849F0F84B0ACC427DC9", hash_generated_field = "4DA4B496DC05D75AC80944B686BBFECA")

    private static int[] DATA_USAGE_NETWORK_TYPES;
    static {
        DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(
                com.android.internal.R.array.config_data_usage_network_types);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.812 -0400", hash_original_field = "88BA2DACBA38DAF918A0D3C1F5E00E22", hash_generated_field = "6C4E6CCCA93A0F55B381916949674798")

    public static final Creator<NetworkTemplate> CREATOR = new Creator<NetworkTemplate>() {
        public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }

        public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    };
    
    public NetworkTemplate createFromParcel(Parcel in) {
            return new NetworkTemplate(in);
        }
    
    
    public NetworkTemplate[] newArray(int size) {
            return new NetworkTemplate[size];
        }
    
}

