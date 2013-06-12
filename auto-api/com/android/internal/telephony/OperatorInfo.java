package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public class OperatorInfo implements Parcelable {
    private String operatorAlphaLong;
    private String operatorAlphaShort;
    private String operatorNumeric;
    private State state = State.UNKNOWN;
    public static final Creator<OperatorInfo> CREATOR = new Creator<OperatorInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.334 -0400", hash_original_method = "C8813B4601E45790F7843A2D1EA70A49", hash_generated_method = "F28BCA57EBF322709F80A6D2FF6837E0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OperatorInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            OperatorInfo opInfo;
            opInfo = new OperatorInfo(
                        in.readString(), 
                        in.readString(), 
                        in.readString(), 
                        (State) in.readSerializable());
            return (OperatorInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //OperatorInfo opInfo = new OperatorInfo(
                        //in.readString(), 
                        //in.readString(), 
                        //in.readString(), 
                        //(State) in.readSerializable());
            //return opInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.334 -0400", hash_original_method = "D4A51B315C2BA10170C89BF0A01D1AB2", hash_generated_method = "8419380515FCAB856D3A5DDE01647CF9")
        @DSModeled(DSC.SAFE)
        public OperatorInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (OperatorInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new OperatorInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.334 -0400", hash_original_method = "4475B64A2C44E2D075CC5ECE1CB355AC", hash_generated_method = "9368249DDCD6B990F884B5E91CFEE1DA")
    @DSModeled(DSC.SAFE)
     OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                State state) {
        dsTaint.addTaint(operatorAlphaLong);
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(operatorAlphaShort);
        dsTaint.addTaint(operatorNumeric);
        // ---------- Original Method ----------
        //this.operatorAlphaLong = operatorAlphaLong;
        //this.operatorAlphaShort = operatorAlphaShort;
        //this.operatorNumeric = operatorNumeric;
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.334 -0400", hash_original_method = "22D6EAAD8ACDCB5BD2588D137EBB558E", hash_generated_method = "3F061BA8C9008F0E19F20E9ECF35AD85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                String stateString) {
        this (operatorAlphaLong, operatorAlphaShort,
                operatorNumeric, rilStateToState(stateString));
        dsTaint.addTaint(operatorAlphaLong);
        dsTaint.addTaint(operatorAlphaShort);
        dsTaint.addTaint(operatorNumeric);
        dsTaint.addTaint(stateString);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "B51FA3C3765E71F08A241B1C8BA79C96", hash_generated_method = "99583776691B9F8EFB48605FABE5CA9A")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaLong() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return operatorAlphaLong;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "A8269EAEF0CA69A19C2F3D33BBF8152B", hash_generated_method = "5F716151E21BA42A7BBC8A62854AD555")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaShort() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return operatorAlphaShort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "06DBB2F851A1F540C7CE21639E1F11FC", hash_generated_method = "8F10ABEA2CB0C39550A6166C48A6A888")
    @DSModeled(DSC.SAFE)
    public String getOperatorNumeric() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return operatorNumeric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "8133026F827EEDDA12F622808DEDA458")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "B75A0123EB9E93271674922114827A6A", hash_generated_method = "2C67034D5A4E1466D6D1F951CC1C5CFB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "3A69A53B1D569DD83E423933B58E91F0", hash_generated_method = "FC7E20CA934FBFBFEFF102996DEBE50B")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "OperatorInfo " + operatorAlphaLong
                //+ "/" + operatorAlphaShort
                //+ "/" + operatorNumeric
                //+ "/" + state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.335 -0400", hash_original_method = "8E3E997094B6FE23C6A87821AE0A248F", hash_generated_method = "90D7455BEB3A0AE27CD17660BE30E9C2")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeString(operatorAlphaLong);
        dest.writeString(operatorAlphaShort);
        dest.writeString(operatorNumeric);
        dest.writeSerializable(state);
        // ---------- Original Method ----------
        //dest.writeString(operatorAlphaLong);
        //dest.writeString(operatorAlphaShort);
        //dest.writeString(operatorNumeric);
        //dest.writeSerializable(state);
    }

    
    public enum State {
        UNKNOWN,
        AVAILABLE,
        CURRENT,
        FORBIDDEN;
    }

    
}


