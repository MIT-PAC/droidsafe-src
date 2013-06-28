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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.710 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "71A10845724278118CE924D88491742A")

    public IInputMethodSession method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.710 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "8B7CEC29663CDE44174BD9618FC65EBC")

    public String id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.710 -0400", hash_original_field = "FA1C731EAD93E333A9180E16F968C01E", hash_generated_field = "AA45D51908C57BB809E4FBCC2CD22135")

    public int sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.710 -0400", hash_original_method = "42A6111FE2D2686864FA2FE8E1A98CEE", hash_generated_method = "0E19872E754A1ACA2FE96A430449E1DF")
    public  InputBindResult(IInputMethodSession _method, String _id, int _sequence) {
        method = _method;
        id = _id;
        sequence = _sequence;
        // ---------- Original Method ----------
        //method = _method;
        //id = _id;
        //sequence = _sequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.711 -0400", hash_original_method = "26E767C4231C3DD46E94F9C79DE09374", hash_generated_method = "5B5FD2FBFE93BA5F669C51F8EABAEAB0")
      InputBindResult(Parcel source) {
        method = IInputMethodSession.Stub.asInterface(source.readStrongBinder());
        id = source.readString();
        sequence = source.readInt();
        // ---------- Original Method ----------
        //method = IInputMethodSession.Stub.asInterface(source.readStrongBinder());
        //id = source.readString();
        //sequence = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.711 -0400", hash_original_method = "7D3C8FC32444FE9148F633706CA9BDDA", hash_generated_method = "EA4DC0C457A69A0FE7B3513F57AAF4CC")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_898204275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_898204275 = "InputBindResult{" + method + " " + id
                + " #" + sequence + "}";
        varB4EAC82CA7396A68D541C85D26508E83_898204275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898204275;
        // ---------- Original Method ----------
        //return "InputBindResult{" + method + " " + id
                //+ " #" + sequence + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.711 -0400", hash_original_method = "D059CB42BC9C8F046048FBE3BCB19D52", hash_generated_method = "06820C64692AE69B031442EB94319C6B")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongInterface(method);
        dest.writeString(id);
        dest.writeInt(sequence);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeStrongInterface(method);
        //dest.writeString(id);
        //dest.writeInt(sequence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.711 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "64F78688B362091983B9CC17145AD1A4")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290140338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290140338;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.711 -0400", hash_original_field = "9B42CE6945265EB3AAD05FA61558E605", hash_generated_field = "736115F46CE1FBBCCD2B323047A41AE5")

    static final String TAG = "InputBindResult";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.711 -0400", hash_original_field = "5B120F1D91D62CFFE41182DB1B3AC094", hash_generated_field = "FB8CFB6623F2A703564B3A10377DAF9A")

    public static final Parcelable.Creator<InputBindResult> CREATOR = new Parcelable.Creator<InputBindResult>() {
        public InputBindResult createFromParcel(Parcel source) {
            return new InputBindResult(source);
        }

        public InputBindResult[] newArray(int size) {
            return new InputBindResult[size];
        }
    };
    // orphaned legacy method
    public InputBindResult createFromParcel(Parcel source) {
            return new InputBindResult(source);
        }
    
    // orphaned legacy method
    public InputBindResult[] newArray(int size) {
            return new InputBindResult[size];
        }
    
}

