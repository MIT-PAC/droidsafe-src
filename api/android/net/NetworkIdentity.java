package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.net.ConnectivityManager.isNetworkTypeMobile;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.android.internal.util.Objects;






public class NetworkIdentity {

    /**
     * Scrub given IMSI on production builds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.038 -0500", hash_original_method = "4BE093C11D479D0397F563135FCE31CE", hash_generated_method = "2C80080EF4C7396B9E92D8DE282373A4")
    
public static String scrubSubscriberId(String subscriberId) {
        if ("eng".equals(Build.TYPE)) {
            return subscriberId;
        } else {
            return subscriberId != null ? "valid" : "null";
        }
    }

    /**
     * Build a {@link NetworkIdentity} from the given {@link NetworkState},
     * assuming that any mobile networks are using the current IMSI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.041 -0500", hash_original_method = "A1B551EBFE60B760F1915D4D252977B7", hash_generated_method = "679A44E866A29FD84A3F572B18F5FE7E")
    
public static NetworkIdentity buildNetworkIdentity(Context context, NetworkState state) {
        final int type = state.networkInfo.getType();
        final int subType = state.networkInfo.getSubtype();

        // TODO: consider moving subscriberId over to LinkCapabilities, so it
        // comes from an authoritative source.

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.009 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

     int mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.012 -0500", hash_original_field = "BCF34990D5BD6C62B9906AA3AA07B984", hash_generated_field = "BCF34990D5BD6C62B9906AA3AA07B984")

     int mSubType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.014 -0500", hash_original_field = "4CB6146C3E5C68A8736082D04D2233DE", hash_generated_field = "4CB6146C3E5C68A8736082D04D2233DE")

     String mSubscriberId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.016 -0500", hash_original_field = "443BCEF3EEBE54B39D5E3E92FF87E1E4", hash_generated_field = "443BCEF3EEBE54B39D5E3E92FF87E1E4")

     boolean mRoaming;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.019 -0500", hash_original_method = "D66D82649648EB29DB5225580D369B63", hash_generated_method = "33DF76630AC5B021A93FDB4BBA2ACBEF")
    
public NetworkIdentity(int type, int subType, String subscriberId, boolean roaming) {
        this.mType = type;
        this.mSubType = subType;
        this.mSubscriberId = subscriberId;
        this.mRoaming = roaming;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.022 -0500", hash_original_method = "70DBA97D9C7155A4770B35E22D7D5A29", hash_generated_method = "E00E75E8B615CA371DA18D4C16FAF210")
    
@Override
    public int hashCode() {
        return Objects.hashCode(mType, mSubType, mSubscriberId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.025 -0500", hash_original_method = "A5A3AB07A0E4347DBE654AC710955A89", hash_generated_method = "6534FACE73C9A29038A916D1A0E42084")
    
@Override
    public boolean equals(Object obj) {
        if (obj instanceof NetworkIdentity) {
            final NetworkIdentity ident = (NetworkIdentity) obj;
            return mType == ident.mType && mSubType == ident.mSubType
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)
                    && mRoaming == ident.mRoaming;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.027 -0500", hash_original_method = "750D47FEDF778AEB33FDF257D4CBFC36", hash_generated_method = "EE7CB84F497B89197DA4CCB1CCFA08F8")
    
@Override
    public String toString() {
        final String typeName = ConnectivityManager.getNetworkTypeName(mType);
        final String subTypeName;
        if (ConnectivityManager.isNetworkTypeMobile(mType)) {
            subTypeName = TelephonyManager.getNetworkTypeName(mSubType);
        } else {
            subTypeName = Integer.toString(mSubType);
        }

        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        final String roaming = mRoaming ? ", ROAMING" : "";
        return "[type=" + typeName + ", subType=" + subTypeName + ", subscriberId="
                + scrubSubscriberId + roaming + "]";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.029 -0500", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "32498FCDA3AC1E9A676800B51A331335")
    
public int getType() {
        return mType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.031 -0500", hash_original_method = "A4DDC328E17941CDB6FA9336B74814D9", hash_generated_method = "9D4666CD302A26D0071E781A6FD2DF73")
    
public int getSubType() {
        return mSubType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.033 -0500", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "A7AB8B338BFAABE54CF6CD80FDE63752")
    
public String getSubscriberId() {
        return mSubscriberId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:30.036 -0500", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "CC0583C9CA1287F8D242AB48312C845D")
    
public boolean getRoaming() {
        return mRoaming;
    }

    
}

