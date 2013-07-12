package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import static android.net.ConnectivityManager.isNetworkTypeMobile;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.android.internal.util.Objects;

public class NetworkIdentity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.656 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

    int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.656 -0400", hash_original_field = "9626C0B267A1B4C2C31F3FFD0E237EB6", hash_generated_field = "BCF34990D5BD6C62B9906AA3AA07B984")

    int mSubType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.656 -0400", hash_original_field = "742C66A57AD769F98E0E69DE23964AB5", hash_generated_field = "4CB6146C3E5C68A8736082D04D2233DE")

    String mSubscriberId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.656 -0400", hash_original_field = "53676CF9ACC69A311F8B40D8878A560F", hash_generated_field = "443BCEF3EEBE54B39D5E3E92FF87E1E4")

    boolean mRoaming;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.657 -0400", hash_original_method = "D66D82649648EB29DB5225580D369B63", hash_generated_method = "C3CF55C2AC8127625AA75BCBD592237A")
    public  NetworkIdentity(int type, int subType, String subscriberId, boolean roaming) {
        this.mType = type;
        this.mSubType = subType;
        this.mSubscriberId = subscriberId;
        this.mRoaming = roaming;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.658 -0400", hash_original_method = "70DBA97D9C7155A4770B35E22D7D5A29", hash_generated_method = "104CFEACAD2AAEE774FEEA77BCE74FE0")
    @Override
    public int hashCode() {
        int varB41F65015920D960CDE3EE03D0FF5496_2048553352 = (Objects.hashCode(mType, mSubType, mSubscriberId));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401255253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401255253;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.658 -0400", hash_original_method = "A5A3AB07A0E4347DBE654AC710955A89", hash_generated_method = "17FEB60D81F928F6371F40ADD37AE9ED")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj instanceof NetworkIdentity)        
        {
            final NetworkIdentity ident = (NetworkIdentity) obj;
            boolean varDC2B84D20BB772F85604A54288B37A56_1471751073 = (mType == ident.mType && mSubType == ident.mSubType
                    && Objects.equal(mSubscriberId, ident.mSubscriberId)
                    && mRoaming == ident.mRoaming);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598814392 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598814392;
        } 
        boolean var68934A3E9455FA72420237EB05902327_452523029 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825760507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825760507;
        
        
            
            
                    
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.659 -0400", hash_original_method = "750D47FEDF778AEB33FDF257D4CBFC36", hash_generated_method = "3A94BBB8B863CAD56353271AA4DB623B")
    @Override
    public String toString() {
        final String typeName = ConnectivityManager.getNetworkTypeName(mType);
        String subTypeName;
    if(ConnectivityManager.isNetworkTypeMobile(mType))        
        {
            subTypeName = TelephonyManager.getNetworkTypeName(mSubType);
        } 
        else
        {
            subTypeName = Integer.toString(mSubType);
        } 
        final String scrubSubscriberId = scrubSubscriberId(mSubscriberId);
        final String roaming = mRoaming ? ", ROAMING" : "";
String varC04A558420C11F186DEAB34E29860899_995045713 =         "[type=" + typeName + ", subType=" + subTypeName + ", subscriberId="
                + scrubSubscriberId + roaming + "]";
        varC04A558420C11F186DEAB34E29860899_995045713.addTaint(taint);
        return varC04A558420C11F186DEAB34E29860899_995045713;
        
        
        
        
            
        
            
        
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.660 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "DA8730D76A1A758BB4F57A9CD5C2BBB6")
    public int getType() {
        int var3462A1A18A0EE070E8953CCF1DD788C0_1450963976 = (mType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618192417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618192417;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.661 -0400", hash_original_method = "A4DDC328E17941CDB6FA9336B74814D9", hash_generated_method = "6B67AD1A631A48137AEC2C6D96C3CA78")
    public int getSubType() {
        int var9626C0B267A1B4C2C31F3FFD0E237EB6_1771885959 = (mSubType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308015712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308015712;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.661 -0400", hash_original_method = "DC04D62E493D044F593223B75A4808C0", hash_generated_method = "0F1459C8F075726F20CB8688EBAC21C3")
    public String getSubscriberId() {
String varD221C4376DC09E8E422076D12DB9853B_1612038187 =         mSubscriberId;
        varD221C4376DC09E8E422076D12DB9853B_1612038187.addTaint(taint);
        return varD221C4376DC09E8E422076D12DB9853B_1612038187;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.662 -0400", hash_original_method = "27B48B56BD1E05F31D9E74CC53E25407", hash_generated_method = "AAB51D164379572B9A82734802CFF5B8")
    public boolean getRoaming() {
        boolean var53676CF9ACC69A311F8B40D8878A560F_1612845011 = (mRoaming);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666958031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666958031;
        
        
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

