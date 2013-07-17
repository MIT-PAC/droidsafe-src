package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import static android.net.ConnectivityManager.isNetworkTypeMobile;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.android.internal.util.Objects;

public class NetworkIdentity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.336 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

    int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.336 -0400", hash_original_field = "9626C0B267A1B4C2C31F3FFD0E237EB6", hash_generated_field = "BCF34990D5BD6C62B9906AA3AA07B984")

    int mSubType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.336 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "4CB6146C3E5C68A8736082D04D2233DE")

    String mSubscriberId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.336 -0400", hash_original_field = "53676CF9ACC69A311F8B40D8878A560F", hash_generated_field = "443BCEF3EEBE54B39D5E3E92FF87E1E4")

    boolean mRoaming;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.337 -0400", hash_original_method = "D66D82649648EB29DB5225580D369B63", hash_generated_method = "C3CF55C2AC8127625AA75BCBD592237A")
    public  NetworkIdentity(int type, int subType, String subscriberId, boolean roaming) {
        this.mType = type;
        this.mSubType = subType;
        this.mSubscriberId = subscriberId;
        this.mRoaming = roaming;
        // ---------- Original Method ----------
        //this.mType = type;
        //this.mSubType = subType;
        //this.mSubscriberId = subscriberId;
        //this.mRoaming = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.337 -0400", hash_original_method = "70DBA97D9C7155A4770B35E22D7D5A29", hash_generated_method = "8CAA0525E4F7517ADFB6951E2A530A49")
    @Override
    public int hashCode() {
        int varB41F65015920D960CDE3EE03D0FF5496_1774556377 = (Objects.hashCode(mType, mSubType, mSubscriberId));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831807017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831807017;
        // ---------- Original Method ----------
        //return Objects.hashCode(mType, mSubType, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.337 -0400", hash_original_method = "A5A3AB07A0E4347DBE654AC710955A89", hash_generated_method = "F3EB6444DC18DA6F9D2E3AF3C325E737")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj instanceof NetworkIdentity)        
        {
            final NetworkIdentity ident = (NetworkIdentity) obj;
            boolean varDC2B84D20BB772F85604A54288B37A56_1562719365 = (mType == ident.mType && mSubType == ident.mSubType
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)
                    && mRoaming == ident.mRoaming);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435575878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_435575878;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_184306257 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187072860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187072860;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkIdentity) {
            //final NetworkIdentity ident = (NetworkIdentity) obj;
            //return mType == ident.mType && mSubType == ident.mSubType
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId)
                    //&& mRoaming == ident.mRoaming;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.338 -0400", hash_original_method = "750D47FEDF778AEB33FDF257D4CBFC36", hash_generated_method = "A04ECE4F03530F1C7FB07D8DDC95AD71")
    @Override
    public String toString() {
        final String typeName = ConnectivityManager.getNetworkTypeName(mType);
        String subTypeName;
        if(ConnectivityManager.isNetworkTypeMobile(mType))        
        {
            subTypeName = TelephonyManager.getNetworkTypeName(mSubType);
        } //End block
        else
        {
            subTypeName = Integer.toString(mSubType);
        } //End block
        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        final String roaming = mRoaming ? ", ROAMING" : "";
String varC04A558420C11F186DEAB34E29860899_378201177 =         "[type=" + typeName + ", subType=" + subTypeName + ", subscriberId="
                + scrubSubscriberId + roaming + "]";
        varC04A558420C11F186DEAB34E29860899_378201177.addTaint(taint);
        return varC04A558420C11F186DEAB34E29860899_378201177;
        // ---------- Original Method ----------
        //final String typeName = ConnectivityManager.getNetworkTypeName(mType);
        //final String subTypeName;
        //if (ConnectivityManager.isNetworkTypeMobile(mType)) {
            //subTypeName = TelephonyManager.getNetworkTypeName(mSubType);
        //} else {
            //subTypeName = Integer.toString(mSubType);
        //}
        //final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        //final String roaming = mRoaming ? ", ROAMING" : "";
        //return "[type=" + typeName + ", subType=" + subTypeName + ", subscriberId="
                //+ scrubSubscriberId + roaming + "]";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.338 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "40C360F128B0931C41877FA8E0348531")
    public int getType() {
        int var3462A1A18A0EE070E8953CCF1DD788C0_323109062 = (mType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392862575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392862575;
        // ---------- Original Method ----------
        //return mType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.338 -0400", hash_original_method = "A4DDC328E17941CDB6FA9336B74814D9", hash_generated_method = "ED178F4B0E566AF60F56E790E67B992D")
    public int getSubType() {
        int var9626C0B267A1B4C2C31F3FFD0E237EB6_1266972738 = (mSubType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238993470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238993470;
        // ---------- Original Method ----------
        //return mSubType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.338 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "B0B0F3BFDAB0ABB7A5BDC6A0408E817D")
    public String getSubscriberId() {
String varD221C4376DC09E8E422076D12DB9853B_1319501581 =         mSubscriberId;
        varD221C4376DC09E8E422076D12DB9853B_1319501581.addTaint(taint);
        return varD221C4376DC09E8E422076D12DB9853B_1319501581;
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.338 -0400", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "5DB7D39A77121E41D8F19900F512328F")
    public boolean getRoaming() {
        boolean var53676CF9ACC69A311F8B40D8878A560F_655786716 = (mRoaming);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943857967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943857967;
        // ---------- Original Method ----------
        //return mRoaming;
    }

    
    public static String scrubSubscriberId(String subscriberId) {
        if ("eng".equals(Build.TYPE)) {
            return subscriberId;
        } else {
            return subscriberId != null ? "valid" : "null";
        }
    }

    
    public static NetworkIdentity buildNetworkIdentity(Context context, NetworkState state) {
        final int type = state.networkInfo.getType();
        final int subType = state.networkInfo.getSubtype();
        final String subscriberId;
        final boolean roaming;
        if (isNetworkTypeMobile(type)) {
            final TelephonyManager telephony = (TelephonyManager) context.getSystemService(
                    Context.TELEPHONY_SERVICE);
            roaming = telephony.isNetworkRoaming();
            if (state.subscriberId != null) {
                subscriberId = state.subscriberId;
            } else {
                subscriberId = telephony.getSubscriberId();
            }
        } else {
            subscriberId = null;
            roaming = false;
        }
        return new NetworkIdentity(type, subType, subscriberId, roaming);
    }

    
}

