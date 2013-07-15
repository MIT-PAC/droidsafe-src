package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class InputEvent implements Parcelable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.844 -0400", hash_original_method = "5E30BC92EB346FB6C373466BBBDCD9C6", hash_generated_method = "4C32157640739D892888BF135F5DE17B")
      InputEvent() {
        // ---------- Original Method ----------
    }

    
    public abstract int getDeviceId();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.844 -0400", hash_original_method = "65C564B77C92C924B4A35B510EAEB2C6", hash_generated_method = "A6C89CCA7484DA93702774C3CDF7A5A3")
    public final InputDevice getDevice() {
InputDevice var6CAF134A410F580D974FCD91E6F3C893_1278464903 =         InputDevice.getDevice(getDeviceId());
        var6CAF134A410F580D974FCD91E6F3C893_1278464903.addTaint(taint);
        return var6CAF134A410F580D974FCD91E6F3C893_1278464903;
        // ---------- Original Method ----------
        //return InputDevice.getDevice(getDeviceId());
    }

    
    public abstract int getSource();

    
    public abstract void setSource(int source);

    
    public abstract InputEvent copy();

    
    public abstract void recycle();

    
    public abstract boolean isTainted();

    
    public abstract void setTainted(boolean tainted);

    
    public abstract long getEventTimeNano();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.845 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F9C9269EB841FC58029A536B61F02A8D")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1863099920 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376219471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_376219471;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.846 -0400", hash_original_field = "9FCAD6001E54B39BF7B91756522D50FA", hash_generated_field = "62C44C836E8114E8865353F1FB18E80F")

    protected static final int PARCEL_TOKEN_MOTION_EVENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.846 -0400", hash_original_field = "32C6904ED6B2400200DEC29637EE8125", hash_generated_field = "1AF89CAACCDFDF81F11811438489CC29")

    protected static final int PARCEL_TOKEN_KEY_EVENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:49.846 -0400", hash_original_field = "04B291F0A19F70F4DCABF30040F87AB0", hash_generated_field = "DFF9DB35F1A192334CC0B98EE577AF20")

    public static final Parcelable.Creator<InputEvent> CREATOR
            = new Parcelable.Creator<InputEvent>() {
        public InputEvent createFromParcel(Parcel in) {
            int token = in.readInt();
            if (token == PARCEL_TOKEN_KEY_EVENT) {
                return KeyEvent.createFromParcelBody(in);
            } else if (token == PARCEL_TOKEN_MOTION_EVENT) {
                return MotionEvent.createFromParcelBody(in);
            } else {
                throw new IllegalStateException("Unexpected input event type token in parcel.");
            }
        }
        
        public InputEvent[] newArray(int size) {
            return new InputEvent[size];
        }
    };
    // orphaned legacy method
    public InputEvent createFromParcel(Parcel in) {
            int token = in.readInt();
            if (token == PARCEL_TOKEN_KEY_EVENT) {
                return KeyEvent.createFromParcelBody(in);
            } else if (token == PARCEL_TOKEN_MOTION_EVENT) {
                return MotionEvent.createFromParcelBody(in);
            } else {
                throw new IllegalStateException("Unexpected input event type token in parcel.");
            }
        }
    
    // orphaned legacy method
    public InputEvent[] newArray(int size) {
            return new InputEvent[size];
        }
    
}

