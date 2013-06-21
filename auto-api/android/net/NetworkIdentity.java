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
    int mType;
    int mSubType;
    String mSubscriberId;
    boolean mRoaming;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.051 -0400", hash_original_method = "D66D82649648EB29DB5225580D369B63", hash_generated_method = "49186E616B171B23F87ACB9202A56A93")
    @DSModeled(DSC.SAFE)
    public NetworkIdentity(int type, int subType, String subscriberId, boolean roaming) {
        dsTaint.addTaint(subType);
        dsTaint.addTaint(subscriberId);
        dsTaint.addTaint(roaming);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //this.mType = type;
        //this.mSubType = subType;
        //this.mSubscriberId = subscriberId;
        //this.mRoaming = roaming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.051 -0400", hash_original_method = "70DBA97D9C7155A4770B35E22D7D5A29", hash_generated_method = "134AF97B940244DFFB6664546258107D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var180097A2FC7C0D8A7CF53DF1EA547AFE_19893203 = (Objects.hashCode(mType, mSubType, mSubscriberId));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Objects.hashCode(mType, mSubType, mSubscriberId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.052 -0400", hash_original_method = "A5A3AB07A0E4347DBE654AC710955A89", hash_generated_method = "ED35753FECB468653F71881492273D7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            NetworkIdentity ident;
            ident = (NetworkIdentity) obj;
            boolean varE6012A89FF9DADFCDC03AE9040B57E62_729872727 = (mType == ident.mType && mSubType == ident.mSubType
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)
                    && mRoaming == ident.mRoaming);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj instanceof NetworkIdentity) {
            //final NetworkIdentity ident = (NetworkIdentity) obj;
            //return mType == ident.mType && mSubType == ident.mSubType
                    //&& Objects.equal(mSubscriberId, ident.mSubscriberId)
                    //&& mRoaming == ident.mRoaming;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.052 -0400", hash_original_method = "750D47FEDF778AEB33FDF257D4CBFC36", hash_generated_method = "20A65F9ED3AE1BA29CB1EF1A190BD675")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String typeName;
        typeName = ConnectivityManager.getNetworkTypeName(mType);
        String subTypeName;
        {
            boolean varCA2BB1C0C80CEB853FC320C25F6CE5D0_1834828838 = (ConnectivityManager.isNetworkTypeMobile(mType));
            {
                subTypeName = TelephonyManager.getNetworkTypeName(mSubType);
            } //End block
            {
                subTypeName = Integer.toString(mSubType);
            } //End block
        } //End collapsed parenthetic
        String scrubSubscriberId;
        scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        String roaming;
        roaming = ", ROAMING";
        roaming = "";
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.053 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "66DFEA4B0062EB4492784966BCFD516E")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.053 -0400", hash_original_method = "A4DDC328E17941CDB6FA9336B74814D9", hash_generated_method = "37A46DC48DEB778B1150686438BA6C92")
    @DSModeled(DSC.SAFE)
    public int getSubType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.053 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "452EEB44588F6444389E255A7A41699A")
    @DSModeled(DSC.SAFE)
    public String getSubscriberId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSubscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.054 -0400", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "5280D29668A9F15E0335FD1E001CD3A1")
    @DSModeled(DSC.SAFE)
    public boolean getRoaming() {
        return dsTaint.getTaintBoolean();
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

