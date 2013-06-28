package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import static android.net.ConnectivityManager.isNetworkTypeMobile;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.android.internal.util.Objects;

public class NetworkIdentity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.306 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

    int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.306 -0400", hash_original_field = "9626C0B267A1B4C2C31F3FFD0E237EB6", hash_generated_field = "BCF34990D5BD6C62B9906AA3AA07B984")

    int mSubType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.306 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "4CB6146C3E5C68A8736082D04D2233DE")

    String mSubscriberId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.306 -0400", hash_original_field = "53676CF9ACC69A311F8B40D8878A560F", hash_generated_field = "443BCEF3EEBE54B39D5E3E92FF87E1E4")

    boolean mRoaming;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.307 -0400", hash_original_method = "D66D82649648EB29DB5225580D369B63", hash_generated_method = "C3CF55C2AC8127625AA75BCBD592237A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.307 -0400", hash_original_method = "70DBA97D9C7155A4770B35E22D7D5A29", hash_generated_method = "FFCA4AD6DF7B10AE03817BE6256A4649")
    @Override
    public int hashCode() {
        int var180097A2FC7C0D8A7CF53DF1EA547AFE_1654056441 = (Objects.hashCode(mType, mSubType, mSubscriberId));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646435596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646435596;
        // ---------- Original Method ----------
        //return Objects.hashCode(mType, mSubType, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.308 -0400", hash_original_method = "A5A3AB07A0E4347DBE654AC710955A89", hash_generated_method = "97A7A147F342F57E6883E155D6EF3EA7")
    @Override
    public boolean equals(Object obj) {
        {
            final NetworkIdentity ident = (NetworkIdentity) obj;
            boolean varE6012A89FF9DADFCDC03AE9040B57E62_496331983 = (mType == ident.mType && mSubType == ident.mSubType
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)
                    && mRoaming == ident.mRoaming);
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160267046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160267046;
        // ---------- Original Method ----------
        //if (obj instanceof NetworkIdentity) {
            //final NetworkIdentity ident = (NetworkIdentity) obj;
            //return mType == ident.mType && mSubType == ident.mSubType
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId)
                    //&& mRoaming == ident.mRoaming;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.309 -0400", hash_original_method = "750D47FEDF778AEB33FDF257D4CBFC36", hash_generated_method = "F146E1AE28CD5FC2EF2B0C903533C5C3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_248266963 = null; //Variable for return #1
        final String typeName = ConnectivityManager.getNetworkTypeName(mType);
        String subTypeName;
        {
            boolean varCA2BB1C0C80CEB853FC320C25F6CE5D0_1746191995 = (ConnectivityManager.isNetworkTypeMobile(mType));
            {
                subTypeName = TelephonyManager.getNetworkTypeName(mSubType);
            } //End block
            {
                subTypeName = Integer.toString(mSubType);
            } //End block
        } //End collapsed parenthetic
        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        String roaming;
        roaming = ", ROAMING";
        roaming = "";
        varB4EAC82CA7396A68D541C85D26508E83_248266963 = "[type=" + typeName + ", subType=" + subTypeName + ", subscriberId="
                + scrubSubscriberId + roaming + "]";
        varB4EAC82CA7396A68D541C85D26508E83_248266963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_248266963;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.309 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "6DBE1AD23085E7DFBC579428E3138DBF")
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029230281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029230281;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.310 -0400", hash_original_method = "A4DDC328E17941CDB6FA9336B74814D9", hash_generated_method = "F450C8245920FB4A823D88F2EEE65927")
    public int getSubType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947303700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947303700;
        // ---------- Original Method ----------
        //return mSubType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.310 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "7A346E59F055E04BBFC69A878C5023F1")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_55726439 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_55726439 = mSubscriberId;
        varB4EAC82CA7396A68D541C85D26508E83_55726439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_55726439;
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.311 -0400", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "85ED911FBD1187756699D448E2E9159A")
    public boolean getRoaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313575061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313575061;
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

