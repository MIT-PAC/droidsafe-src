package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class OperatorInfo implements Parcelable {
    private String operatorAlphaLong;
    private String operatorAlphaShort;
    private String operatorNumeric;
    private State state = State.UNKNOWN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.542 -0400", hash_original_method = "4475B64A2C44E2D075CC5ECE1CB355AC", hash_generated_method = "029058025B5E75BD85CD5B615FDC48E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.542 -0400", hash_original_method = "22D6EAAD8ACDCB5BD2588D137EBB558E", hash_generated_method = "7312381FEE8C9330F90D1F45AF04ABF7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.542 -0400", hash_original_method = "B51FA3C3765E71F08A241B1C8BA79C96", hash_generated_method = "D34777581843FDD9257A0AEDEF30C9A8")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaLong() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return operatorAlphaLong;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.543 -0400", hash_original_method = "A8269EAEF0CA69A19C2F3D33BBF8152B", hash_generated_method = "A0EF361BBA3A3A8109E3248F7FB3BBAE")
    @DSModeled(DSC.SAFE)
    public String getOperatorAlphaShort() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return operatorAlphaShort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.543 -0400", hash_original_method = "06DBB2F851A1F540C7CE21639E1F11FC", hash_generated_method = "412090D29EBE4D239CEE29E9D11D391F")
    @DSModeled(DSC.SAFE)
    public String getOperatorNumeric() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return operatorNumeric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.543 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "F5E227F5D2B96691C815C4C56ED31889")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return state;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.543 -0400", hash_original_method = "3A69A53B1D569DD83E423933B58E91F0", hash_generated_method = "C542FF02E6E7359FA2A573116FAEBE2D")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "OperatorInfo " + operatorAlphaLong
                //+ "/" + operatorAlphaShort
                //+ "/" + operatorNumeric
                //+ "/" + state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.543 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.544 -0400", hash_original_method = "8E3E997094B6FE23C6A87821AE0A248F", hash_generated_method = "8E60D36A28E58F95458FA73A845F96A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    public static final Creator<OperatorInfo> CREATOR = new Creator<OperatorInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.544 -0400", hash_original_method = "C8813B4601E45790F7843A2D1EA70A49", hash_generated_method = "16B6B3D6AEACD9EA0BE8A6B278896A3E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.544 -0400", hash_original_method = "D4A51B315C2BA10170C89BF0A01D1AB2", hash_generated_method = "6EB4EDB84A414EB4B63C801E99021430")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public OperatorInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            OperatorInfo[] varF8D60F74B3710ECB8B580D251D74FD5B_1018016780 = (new OperatorInfo[size]);
            return (OperatorInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new OperatorInfo[size];
        }

        
}; //Transformed anonymous class
}

