package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class OperatorInfo implements Parcelable {

    /**
     * See state strings defined in ril.h RIL_REQUEST_QUERY_AVAILABLE_NETWORKS
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.357 -0500", hash_original_method = "B75A0123EB9E93271674922114827A6A", hash_generated_method = "2C67034D5A4E1466D6D1F951CC1C5CFB")
    
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.569 -0400", hash_original_field = "CE4D84BB5D80D6F1E7F23127D57FA1E7", hash_generated_field = "244DE5599F688C0C7CE39BEE35E6AF81")

    public static final Creator<OperatorInfo> CREATOR =
        new Creator<OperatorInfo>() {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.367 -0500", hash_original_method = "C8813B4601E45790F7843A2D1EA70A49", hash_generated_method = "E2399B99ED9146E351F847DAEB58514F")
        
public OperatorInfo createFromParcel(Parcel in) {
                OperatorInfo opInfo = new OperatorInfo(
                        in.readString(), /*operatorAlphaLong*/
                        in.readString(), /*operatorAlphaShort*/
                        in.readString(), /*operatorNumeric*/
                        (State) in.readSerializable()); /*state*/
                return opInfo;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.371 -0500", hash_original_method = "D4A51B315C2BA10170C89BF0A01D1AB2", hash_generated_method = "6284CFBC60EDB0571D64AD7A418EE8AC")
        
public OperatorInfo[] newArray(int size) {
                return new OperatorInfo[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.332 -0500", hash_original_field = "D5205C75E0728BD5532E96497C7DFA52", hash_generated_field = "F0150DE98C56463E8FBA5168FF9D36D5")

    private String operatorAlphaLong;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.335 -0500", hash_original_field = "F2D71A9A98F61830E20D376D8C079200", hash_generated_field = "DAF789E03D68464206271876E158DD07")

    private String operatorAlphaShort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.338 -0500", hash_original_field = "EDEB2AE49295E0D0131E5CCBDF250E4F", hash_generated_field = "F850CA9B7337FD15ABEEE29EB55D046F")

    private String operatorNumeric;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.340 -0500", hash_original_field = "D84B2AF2604659345A0E663E537B31A2", hash_generated_field = "8632897B42EA54355D7D05C4187E6C0B")

    private State state = State.UNKNOWN;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.351 -0500", hash_original_method = "4475B64A2C44E2D075CC5ECE1CB355AC", hash_generated_method = "4475B64A2C44E2D075CC5ECE1CB355AC")
    
OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                State state) {

        this.operatorAlphaLong = operatorAlphaLong;
        this.operatorAlphaShort = operatorAlphaShort;
        this.operatorNumeric = operatorNumeric;

        this.state = state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.354 -0500", hash_original_method = "22D6EAAD8ACDCB5BD2588D137EBB558E", hash_generated_method = "721BE0088A3EE450F273F79299951737")
    
public OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                String stateString) {
        this (operatorAlphaLong, operatorAlphaShort,
                operatorNumeric, rilStateToState(stateString));
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.342 -0500", hash_original_method = "B51FA3C3765E71F08A241B1C8BA79C96", hash_generated_method = "CB638F59BD0B25A23177222101C9E3B6")
    
public String
    getOperatorAlphaLong() {
        return operatorAlphaLong;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.344 -0500", hash_original_method = "A8269EAEF0CA69A19C2F3D33BBF8152B", hash_generated_method = "FB481291A527FECB4BD90F8095874EFC")
    
public String
    getOperatorAlphaShort() {
        return operatorAlphaShort;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.347 -0500", hash_original_method = "06DBB2F851A1F540C7CE21639E1F11FC", hash_generated_method = "839AF192B0AA543A2D859FC12F24D1D0")
    
public String
    getOperatorNumeric() {
        return operatorNumeric;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.349 -0500", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "501DC0DCEBE66E1C2384E415192C6550")
    
public State
    getState() {
        return state;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.359 -0500", hash_original_method = "3A69A53B1D569DD83E423933B58E91F0", hash_generated_method = "4BB95C078DA1404522803CF8E4B187E1")
    
public String toString() {
        return "OperatorInfo " + operatorAlphaLong
                + "/" + operatorAlphaShort
                + "/" + operatorNumeric
                + "/" + state;
    }

    /**
     * Parcelable interface implemented below.
     * This is a simple effort to make OperatorInfo parcelable rather than
     * trying to make the conventional containing object (AsyncResult),
     * implement parcelable.  This functionality is needed for the
     * NetworkQueryService to fix 1128695.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.361 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    
    public enum State {
        UNKNOWN,
        AVAILABLE,
        CURRENT,
        FORBIDDEN;
    }

    /**
     * Implement the Parcelable interface.
     * Method to serialize a OperatorInfo object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.364 -0500", hash_original_method = "8E3E997094B6FE23C6A87821AE0A248F", hash_generated_method = "BD0D062C8941F4451D8E454E02FFD499")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(operatorAlphaLong);
        dest.writeString(operatorAlphaShort);
        dest.writeString(operatorNumeric);
        dest.writeSerializable(state);
    }
}

