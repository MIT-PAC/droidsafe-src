package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public final class InputBindResult implements Parcelable {
    static final String TAG = "InputBindResult";
    public final IInputMethodSession method;
    public final String id;
    public final int sequence;
    public static final Parcelable.Creator<InputBindResult> CREATOR = new Parcelable.Creator<InputBindResult>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.936 -0400", hash_original_method = "0DC17695F8002017E94E8D176AF259A9", hash_generated_method = "CD7F7660CF68D146C56CCEDF68240565")
        @DSModeled(DSC.SAFE)
        public InputBindResult createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (InputBindResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputBindResult(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.936 -0400", hash_original_method = "95F5C3EE4EE7A3EB96C435695C7EF89F", hash_generated_method = "9D190CD07CD0CD527E09F3ED986E9AAB")
        @DSModeled(DSC.SAFE)
        public InputBindResult[] newArray(int size) {
            dsTaint.addTaint(size);
            return (InputBindResult[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputBindResult[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.936 -0400", hash_original_method = "42A6111FE2D2686864FA2FE8E1A98CEE", hash_generated_method = "368686797FD1342073AC45865A6AA36A")
    @DSModeled(DSC.SAFE)
    public InputBindResult(IInputMethodSession _method, String _id, int _sequence) {
        dsTaint.addTaint(_id);
        dsTaint.addTaint(_sequence);
        dsTaint.addTaint(_method.dsTaint);
        // ---------- Original Method ----------
        //method = _method;
        //id = _id;
        //sequence = _sequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.936 -0400", hash_original_method = "26E767C4231C3DD46E94F9C79DE09374", hash_generated_method = "8A9482BA64A0484CF0F17A7169017553")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InputBindResult(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        method = IInputMethodSession.Stub.asInterface(source.readStrongBinder());
        id = source.readString();
        sequence = source.readInt();
        // ---------- Original Method ----------
        //method = IInputMethodSession.Stub.asInterface(source.readStrongBinder());
        //id = source.readString();
        //sequence = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.936 -0400", hash_original_method = "7D3C8FC32444FE9148F633706CA9BDDA", hash_generated_method = "04E622ED15CD2B88A6117A27ED99323A")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "InputBindResult{" + method + " " + id
                //+ " #" + sequence + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.936 -0400", hash_original_method = "D059CB42BC9C8F046048FBE3BCB19D52", hash_generated_method = "64569813EA3F2E36FC6243F76A254BB7")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeStrongInterface(method);
        dest.writeString(id);
        dest.writeInt(sequence);
        // ---------- Original Method ----------
        //dest.writeStrongInterface(method);
        //dest.writeString(id);
        //dest.writeInt(sequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.936 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
}


