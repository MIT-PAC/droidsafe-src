package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class InputEvent implements Parcelable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.883 -0400", hash_original_method = "5E30BC92EB346FB6C373466BBBDCD9C6", hash_generated_method = "4C32157640739D892888BF135F5DE17B")
    @DSModeled(DSC.SAFE)
     InputEvent() {
        // ---------- Original Method ----------
    }

    
    public abstract int getDeviceId();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.884 -0400", hash_original_method = "65C564B77C92C924B4A35B510EAEB2C6", hash_generated_method = "128A7EEA70B7517CE95B7ABF3B109734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputDevice getDevice() {
        InputDevice var8976E3AEF9BC842E9D5212F39B20D649_875823050 = (InputDevice.getDevice(getDeviceId()));
        return (InputDevice)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.885 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    protected static final int PARCEL_TOKEN_MOTION_EVENT = 1;
    protected static final int PARCEL_TOKEN_KEY_EVENT = 2;
    public static final Parcelable.Creator<InputEvent> CREATOR = new Parcelable.Creator<InputEvent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.885 -0400", hash_original_method = "1E6CF60294C8C01670FD09697A2C8F1E", hash_generated_method = "752CAF85549C10F8DD62C070F4DD2032")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputEvent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int token;
            token = in.readInt();
            {
                InputEvent varF62C4D46AE56930B650DC43D329C3220_990020332 = (KeyEvent.createFromParcelBody(in));
            } //End block
            {
                InputEvent varF54134CFC3F42A3F36017A362089264C_673920123 = (MotionEvent.createFromParcelBody(in));
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Unexpected input event type token in parcel.");
            } //End block
            return (InputEvent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int token = in.readInt();
            //if (token == PARCEL_TOKEN_KEY_EVENT) {
                //return KeyEvent.createFromParcelBody(in);
            //} else if (token == PARCEL_TOKEN_MOTION_EVENT) {
                //return MotionEvent.createFromParcelBody(in);
            //} else {
                //throw new IllegalStateException("Unexpected input event type token in parcel.");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.885 -0400", hash_original_method = "7DD87234BD0A6395014BBD1487432510", hash_generated_method = "A894F5E80F3898E780981226253BEF80")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InputEvent[] newArray(int size) {
            dsTaint.addTaint(size);
            InputEvent[] var40E69ABFBCADE6447C6D56F5C150F104_521366124 = (new InputEvent[size]);
            return (InputEvent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputEvent[size];
        }

        
}; //Transformed anonymous class
}

