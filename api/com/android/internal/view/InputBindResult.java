package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class InputBindResult implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.678 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "71A10845724278118CE924D88491742A")

    public IInputMethodSession method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.678 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "8B7CEC29663CDE44174BD9618FC65EBC")

    public String id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.678 -0400", hash_original_field = "FA1C731EAD93E333A9180E16F968C01E", hash_generated_field = "AA45D51908C57BB809E4FBCC2CD22135")

    public int sequence;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.678 -0400", hash_original_method = "42A6111FE2D2686864FA2FE8E1A98CEE", hash_generated_method = "0E19872E754A1ACA2FE96A430449E1DF")
    public  InputBindResult(IInputMethodSession _method, String _id, int _sequence) {
        method = _method;
        id = _id;
        sequence = _sequence;
        // ---------- Original Method ----------
        //method = _method;
        //id = _id;
        //sequence = _sequence;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.678 -0400", hash_original_method = "26E767C4231C3DD46E94F9C79DE09374", hash_generated_method = "5B5FD2FBFE93BA5F669C51F8EABAEAB0")
      InputBindResult(Parcel source) {
        method = IInputMethodSession.Stub.asInterface(source.readStrongBinder());
        id = source.readString();
        sequence = source.readInt();
        // ---------- Original Method ----------
        //method = IInputMethodSession.Stub.asInterface(source.readStrongBinder());
        //id = source.readString();
        //sequence = source.readInt();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.679 -0400", hash_original_method = "7D3C8FC32444FE9148F633706CA9BDDA", hash_generated_method = "1D60892CC6A47CAF5C02D4606316A23F")
    @Override
    public String toString() {
String var7FC001ADC5B990238F8DB3504F6EAF2D_396878583 =         "InputBindResult{" + method + " " + id
                + " #" + sequence + "}";
        var7FC001ADC5B990238F8DB3504F6EAF2D_396878583.addTaint(taint);
        return var7FC001ADC5B990238F8DB3504F6EAF2D_396878583;
        // ---------- Original Method ----------
        //return "InputBindResult{" + method + " " + id
                //+ " #" + sequence + "}";
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.679 -0400", hash_original_method = "D059CB42BC9C8F046048FBE3BCB19D52", hash_generated_method = "1C24C4C8ED4286407B25B2860CBEC00D")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeStrongInterface(method);
        dest.writeString(id);
        dest.writeInt(sequence);
        // ---------- Original Method ----------
        //dest.writeStrongInterface(method);
        //dest.writeString(id);
        //dest.writeInt(sequence);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.679 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DAD5BE9ED3AAD5F6D193E00331C5E8AA")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1816105931 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545368929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545368929;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.679 -0400", hash_original_field = "9B42CE6945265EB3AAD05FA61558E605", hash_generated_field = "736115F46CE1FBBCCD2B323047A41AE5")

    static final String TAG = "InputBindResult";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.679 -0400", hash_original_field = "5B120F1D91D62CFFE41182DB1B3AC094", hash_generated_field = "FB8CFB6623F2A703564B3A10377DAF9A")

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

