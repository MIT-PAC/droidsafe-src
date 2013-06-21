package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public final class InputBindResult implements Parcelable {
    public IInputMethodSession method;
    public String id;
    public int sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.299 -0400", hash_original_method = "42A6111FE2D2686864FA2FE8E1A98CEE", hash_generated_method = "F79F5668D4A7D27625838C971D672754")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.299 -0400", hash_original_method = "26E767C4231C3DD46E94F9C79DE09374", hash_generated_method = "391A13214E0C8A4168BFC8234ACC9DEC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.300 -0400", hash_original_method = "7D3C8FC32444FE9148F633706CA9BDDA", hash_generated_method = "3638B19D546AED62F1F1E0DC23168B81")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "InputBindResult{" + method + " " + id
                //+ " #" + sequence + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.300 -0400", hash_original_method = "D059CB42BC9C8F046048FBE3BCB19D52", hash_generated_method = "9EF1CADC86D370680A3FB756804B84D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeStrongInterface(method);
        dest.writeString(id);
        dest.writeInt(sequence);
        // ---------- Original Method ----------
        //dest.writeStrongInterface(method);
        //dest.writeString(id);
        //dest.writeInt(sequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.300 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    static final String TAG = "InputBindResult";
    public static final Parcelable.Creator<InputBindResult> CREATOR = new Parcelable.Creator<InputBindResult>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.300 -0400", hash_original_method = "0DC17695F8002017E94E8D176AF259A9", hash_generated_method = "387FC75380A2FB3C242353DC2E347F3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputBindResult createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            InputBindResult var99F7A71B0E8873B74E194C8047B29004_1935216210 = (new InputBindResult(source));
            return (InputBindResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputBindResult(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.301 -0400", hash_original_method = "95F5C3EE4EE7A3EB96C435695C7EF89F", hash_generated_method = "AEE5F0EF1128A2A59D07D7677A6C65DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputBindResult[] newArray(int size) {
            dsTaint.addTaint(size);
            InputBindResult[] var96A8F453FDB7386F31B20FB679329C97_1632663446 = (new InputBindResult[size]);
            return (InputBindResult[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputBindResult[size];
        }

        
}; //Transformed anonymous class
}

