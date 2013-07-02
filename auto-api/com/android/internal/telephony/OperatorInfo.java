package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class OperatorInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.316 -0400", hash_original_field = "EBA1AB368B4E5EA262B356E9FEB5DBFF", hash_generated_field = "F0150DE98C56463E8FBA5168FF9D36D5")

    private String operatorAlphaLong;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.317 -0400", hash_original_field = "A5CE4261E3685149463BEBC361CCAE61", hash_generated_field = "DAF789E03D68464206271876E158DD07")

    private String operatorAlphaShort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.317 -0400", hash_original_field = "283D783309AC858AFD001B18F5F912C5", hash_generated_field = "F850CA9B7337FD15ABEEE29EB55D046F")

    private String operatorNumeric;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.317 -0400", hash_original_field = "6EB48CFDD43F97FA1C757559C440D695", hash_generated_field = "8632897B42EA54355D7D05C4187E6C0B")

    private State state = State.UNKNOWN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.317 -0400", hash_original_method = "4475B64A2C44E2D075CC5ECE1CB355AC", hash_generated_method = "DD36DA18EB148E635450102FC6720221")
      OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                State state) {
        this.operatorAlphaLong = operatorAlphaLong;
        this.operatorAlphaShort = operatorAlphaShort;
        this.operatorNumeric = operatorNumeric;
        this.state = state;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.317 -0400", hash_original_method = "22D6EAAD8ACDCB5BD2588D137EBB558E", hash_generated_method = "7E102A2C2F6E1E6D0D53A25329971327")
    public  OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                String stateString) {
        this (operatorAlphaLong, operatorAlphaShort,
                operatorNumeric, rilStateToState(stateString));
        addTaint(operatorAlphaLong.getTaint());
        addTaint(operatorAlphaShort.getTaint());
        addTaint(operatorNumeric.getTaint());
        addTaint(stateString.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.318 -0400", hash_original_method = "B51FA3C3765E71F08A241B1C8BA79C96", hash_generated_method = "1CF12C97C5F9A3EAB10934BFD15CD016")
    public String getOperatorAlphaLong() {
        String varB4EAC82CA7396A68D541C85D26508E83_1250520272 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1250520272 = operatorAlphaLong;
        varB4EAC82CA7396A68D541C85D26508E83_1250520272.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1250520272;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.318 -0400", hash_original_method = "A8269EAEF0CA69A19C2F3D33BBF8152B", hash_generated_method = "6B4ED1DA5AB4FDACD4A3818A92E99B85")
    public String getOperatorAlphaShort() {
        String varB4EAC82CA7396A68D541C85D26508E83_1285069017 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1285069017 = operatorAlphaShort;
        varB4EAC82CA7396A68D541C85D26508E83_1285069017.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1285069017;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.318 -0400", hash_original_method = "06DBB2F851A1F540C7CE21639E1F11FC", hash_generated_method = "89A11062C5D0CD123F2B63A5AF7D724F")
    public String getOperatorNumeric() {
        String varB4EAC82CA7396A68D541C85D26508E83_1185635879 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1185635879 = operatorNumeric;
        varB4EAC82CA7396A68D541C85D26508E83_1185635879.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1185635879;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.319 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "2580255178973BBD21138857068BBD3F")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_1427492831 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1427492831 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1427492831.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1427492831;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static State rilStateToState(String s) {
        if (s.equals("unknown")) {
            return State.UNKNOWN;
        } else if (s.equals("available")) {
            return State.AVAILABLE;
        } else if (s.equals("current")) {
            return State.CURRENT;
        } else if (s.equals("forbidden")) {
            return State.FORBIDDEN;
        } else {
            throw new RuntimeException(
                "RIL impl error: Invalid network state '" + s + "'");
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.319 -0400", hash_original_method = "3A69A53B1D569DD83E423933B58E91F0", hash_generated_method = "678FB19E809BB0D1A1018020524727F3")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_95958623 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_95958623 = "OperatorInfo " + operatorAlphaLong
                + "/" + operatorAlphaShort
                + "/" + operatorNumeric
                + "/" + state;
        varB4EAC82CA7396A68D541C85D26508E83_95958623.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_95958623;
        
        
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.320 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "419BE8171D9DD8C7AF3548BD9D550886")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521660289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521660289;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.320 -0400", hash_original_method = "8E3E997094B6FE23C6A87821AE0A248F", hash_generated_method = "6E5BA4C7E7E7495AE3AECBBDBB1C1037")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(operatorAlphaLong);
        dest.writeString(operatorAlphaShort);
        dest.writeString(operatorNumeric);
        dest.writeSerializable(state);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
    }

    
    public enum State {
        UNKNOWN,
        AVAILABLE,
        CURRENT,
        FORBIDDEN;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.320 -0400", hash_original_field = "CE4D84BB5D80D6F1E7F23127D57FA1E7", hash_generated_field = "244DE5599F688C0C7CE39BEE35E6AF81")

    public static final Creator<OperatorInfo> CREATOR =
        new Creator<OperatorInfo>() {
            public OperatorInfo createFromParcel(Parcel in) {
                OperatorInfo opInfo = new OperatorInfo(
                        in.readString(), 
                        in.readString(), 
                        in.readString(), 
                        (State) in.readSerializable()); 
                return opInfo;
            }

            public OperatorInfo[] newArray(int size) {
                return new OperatorInfo[size];
            }
        };
}

