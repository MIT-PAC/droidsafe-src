package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class ToneSettings implements Parcelable {
    public Duration duration;
    public Tone tone;
    public boolean vibrate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.031 -0400", hash_original_method = "1758CDE2435E3198DD1711D15D7C0A67", hash_generated_method = "DFC35C086DAC5AFB0F1A1FB14BF63858")
    @DSModeled(DSC.SAFE)
    public ToneSettings(Duration duration, Tone tone, boolean vibrate) {
        dsTaint.addTaint(tone.dsTaint);
        dsTaint.addTaint(duration.dsTaint);
        dsTaint.addTaint(vibrate);
        // ---------- Original Method ----------
        //this.duration = duration;
        //this.tone = tone;
        //this.vibrate = vibrate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.032 -0400", hash_original_method = "BF14929F27F95EDB5212CB812386B849", hash_generated_method = "C4E8D73FDEE336F49AEA3982385BD265")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ToneSettings(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        duration = in.readParcelable(null);
        tone = in.readParcelable(null);
        vibrate = in.readInt() == 1;
        // ---------- Original Method ----------
        //duration = in.readParcelable(null);
        //tone = in.readParcelable(null);
        //vibrate = in.readInt() == 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.032 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.032 -0400", hash_original_method = "A5E63ABB35658FAF6D2AA5EF55230C8C", hash_generated_method = "F1CCD4EC21A0CAC299D0250E12ED4B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeParcelable(duration, 0);
        dest.writeParcelable(tone, 0);
        dest.writeInt(vibrate ? 1 : 0);
        // ---------- Original Method ----------
        //dest.writeParcelable(duration, 0);
        //dest.writeParcelable(tone, 0);
        //dest.writeInt(vibrate ? 1 : 0);
    }

    
    public static final Parcelable.Creator<ToneSettings> CREATOR = new Parcelable.Creator<ToneSettings>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.032 -0400", hash_original_method = "0AF8B6A3D7EC6128A504A6DF918A5419", hash_generated_method = "45C0B31A7129B2D17597EA2A95D2DA49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ToneSettings createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ToneSettings varC6A7A1A0165E8602AAA184B3253AC46C_127608370 = (new ToneSettings(in));
            return (ToneSettings)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ToneSettings(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.032 -0400", hash_original_method = "DAFFA5B94F1FE936F2C8E737B7D9ABDB", hash_generated_method = "E14A5A2EA401795760E59F84235B9434")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ToneSettings[] newArray(int size) {
            dsTaint.addTaint(size);
            ToneSettings[] var58ECF436FC61902F60AB6C512022D271_89477935 = (new ToneSettings[size]);
            return (ToneSettings[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ToneSettings[size];
        }

        
}; //Transformed anonymous class
}

