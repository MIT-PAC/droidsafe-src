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
    private int mMatchRule;
    private String mSubscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.334 -0400", hash_original_method = "FD7BCAE9218E775535D7C5C898F0D923", hash_generated_method = "D7D2FA0465E27F9E5F6080FA65C38311")
    @DSModeled(DSC.SAFE)
    public NetworkTemplate(int matchRule, String subscriberId) {
        dsTaint.addTaint(matchRule);
        dsTaint.addTaint(subscriberId);
        // ---------- Original Method ----------
        //this.mMatchRule = matchRule;
        //this.mSubscriberId = subscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.334 -0400", hash_original_method = "467A86E8EFDDFF4383A8018B1ADE829F", hash_generated_method = "42AFDB912A5811F766969A22C01D29BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NetworkTemplate(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.335 -0400", hash_original_method = "16E233F925554B3B88BD36CB1859F60A", hash_generated_method = "54FA3C79025FDE79A2FFF6919F384F6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mMatchRule);
        dest.writeString(mSubscriberId);
        // ---------- Original Method ----------
        //dest.writeInt(mMatchRule);
        //dest.writeString(mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.335 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.336 -0400", hash_original_method = "743C43E5DEE5FAC4123020B60468B1AB", hash_generated_method = "698B821798BAC23E4B977E316D04D61D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String scrubSubscriberId;
        scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        String var1F2C9367797C1ADC74DE688691A21E96_716009839 = ("NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                + scrubSubscriberId);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        //return "NetworkTemplate: matchRule=" + getMatchRuleName(mMatchRule) + ", subscriberId="
                //+ scrubSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.336 -0400", hash_original_method = "61F711039243E011B66A7D31CCB469F2", hash_generated_method = "60F15ADA375DE19346A17ED953568A87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var5903D3463C4117DDC92BFB75357FD987_743644702 = (Objects.hashCode(mMatchRule, mSubscriberId));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Objects.hashCode(mMatchRule, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.336 -0400", hash_original_method = "97109AC3BBA8BEF8ECFCD42700ABFADC", hash_generated_method = "74B45A9E0EA2E906CD5B452F35DF459F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            NetworkTemplate other;
            other = (NetworkTemplate) obj;
            boolean var67D3C77A149DB63592FE7663B20E776D_1264087488 = (mMatchRule == other.mMatchRule
                    && Objects.equal(mSubscriberId, other.mSubscriberId));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj instanceof NetworkTemplate) {
            //final NetworkTemplate other = (NetworkTemplate) obj;
            //return mMatchRule == other.mMatchRule
                    //&& Objects.equal(mSubscriberId, other.mSubscriberId);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.336 -0400", hash_original_method = "F3B6429C6B29080B6AB6244CD6E2C6C6", hash_generated_method = "AF4113FBCE96EBAE2F73C59716B8FB30")
    @DSModeled(DSC.SAFE)
    public int getMatchRule() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMatchRule;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.337 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "452EEB44588F6444389E255A7A41699A")
    @DSModeled(DSC.SAFE)
    public String getSubscriberId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.337 -0400", hash_original_method = "9C317DAC08BBC55C4495C595EA5A7F8A", hash_generated_method = "A7B133B72D30B7454CBB086D428BC56D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean matches(NetworkIdentity ident) {
        dsTaint.addTaint(ident.dsTaint);
        //Begin case MATCH_MOBILE_ALL 
        boolean var27F3C9C9886A4B3E59CA64C666369B54_825344550 = (matchesMobile(ident));
        //End case MATCH_MOBILE_ALL 
        //Begin case MATCH_MOBILE_3G_LOWER 
        boolean var997543972248F97D7F290C9235B6C3B4_1501166673 = (matchesMobile3gLower(ident));
        //End case MATCH_MOBILE_3G_LOWER 
        //Begin case MATCH_MOBILE_4G 
        boolean var279FDC683639FF1E4965F9BB512C163D_80825747 = (matchesMobile4g(ident));
        //End case MATCH_MOBILE_4G 
        //Begin case MATCH_WIFI 
        boolean varC14BD0EB62533D621E51A3121D089961_423035440 = (matchesWifi(ident));
        //End case MATCH_WIFI 
        //Begin case MATCH_ETHERNET 
        boolean varD3707DDFF0F39513E3FAE3291923C228_2060576092 = (matchesEthernet(ident));
        //End case MATCH_ETHERNET 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown network template");
        //End case default 
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.338 -0400", hash_original_method = "BBF3C380B9774B27B4245C54F7894533", hash_generated_method = "2E760CDF9BCBEDF35BD44FB5B858CF2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean matchesMobile(NetworkIdentity ident) {
        dsTaint.addTaint(ident.dsTaint);
        {
            boolean var3DC0FC46DFF2E897F05D8E47FB3E143C_954269512 = ((contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIMAX) {
            //return true;
        //} else {
            //return (contains(DATA_USAGE_NETWORK_TYPES, ident.mType)
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.339 -0400", hash_original_method = "0F24D42BACA619E1B4D2A14C838DE427", hash_generated_method = "79B36879537BA9C90D7875B32989C0A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean matchesMobile3gLower(NetworkIdentity ident) {
        dsTaint.addTaint(ident.dsTaint);
        {
            boolean varE122418F6165DABA92A5320632EF3C50_113938575 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_205830572 = (getNetworkClass(ident.mSubType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.340 -0400", hash_original_method = "B7894A7F3E04E8F81CBF1F61E6B8AB40", hash_generated_method = "E3F2E088CCAC25DEFADE01C4D6187EF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean matchesMobile4g(NetworkIdentity ident) {
        dsTaint.addTaint(ident.dsTaint);
        {
            boolean varE122418F6165DABA92A5320632EF3C50_924613168 = (matchesMobile(ident));
            {
                {
                    Object varDA555F932848EC9B6BF71EDF358E9CF0_1249401121 = (getNetworkClass(ident.mSubType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.341 -0400", hash_original_method = "FC1062696978183943559E1C2F0FCB30", hash_generated_method = "DE0390DD54A6CA7ED33A9826EB24BA4C")
    @DSModeled(DSC.SAFE)
    private boolean matchesWifi(NetworkIdentity ident) {
        dsTaint.addTaint(ident.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (ident.mType == TYPE_WIFI) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.341 -0400", hash_original_method = "A66E0F5FCADB4F7B6C8822100B46777D", hash_generated_method = "4CD71A6D644A2F206586629347B9CE9D")
    @DSModeled(DSC.SAFE)
    private boolean matchesEthernet(NetworkIdentity ident) {
        dsTaint.addTaint(ident.dsTaint);
        return dsTaint.getTaintBoolean();
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

    
    public static final int MATCH_MOBILE_ALL = 1;
    public static final int MATCH_MOBILE_3G_LOWER = 2;
    public static final int MATCH_MOBILE_4G = 3;
    public static final int MATCH_WIFI = 4;
    public static final int MATCH_ETHERNET = 5;
    private static final int[] DATA_USAGE_NETWORK_TYPES;
    static {
        DATA_USAGE_NETWORK_TYPES = Resources.getSystem().getIntArray(
                com.android.internal.R.array.config_data_usage_network_types);
    }
    
    public static final Creator<NetworkTemplate> CREATOR = new Creator<NetworkTemplate>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.341 -0400", hash_original_method = "38251DACB68583A45907072FCF0CAE23", hash_generated_method = "7F9F4B2C184E4D40E43268C99864EEEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkTemplate createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            NetworkTemplate var086DC2C4101E710043052DE4E159E54D_1142910993 = (new NetworkTemplate(in));
            return (NetworkTemplate)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkTemplate(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.342 -0400", hash_original_method = "FDF754026684D312F9EC33474C401CC0", hash_generated_method = "BF6B5ED5C2595AEBF07419FB45914924")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkTemplate[] newArray(int size) {
            dsTaint.addTaint(size);
            NetworkTemplate[] var845B23F1861663923E29758B2F978B54_324033189 = (new NetworkTemplate[size]);
            return (NetworkTemplate[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkTemplate[size];
        }

        
}; //Transformed anonymous class
}

