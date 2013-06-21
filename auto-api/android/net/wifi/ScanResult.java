package android.net.wifi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;

public class ScanResult implements Parcelable {
    public String SSID;
    public String BSSID;
    public String capabilities;
    public int level;
    public int frequency;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.505 -0400", hash_original_method = "B81746E5555BB1C130130EC15E62207F", hash_generated_method = "4759EC99377E8CBEB251A636D247B692")
    @DSModeled(DSC.SAFE)
    public ScanResult(String SSID, String BSSID, String caps, int level, int frequency) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(caps);
        dsTaint.addTaint(SSID);
        dsTaint.addTaint(frequency);
        dsTaint.addTaint(BSSID);
        // ---------- Original Method ----------
        //this.SSID = SSID;
        //this.BSSID = BSSID;
        //this.capabilities = caps;
        //this.level = level;
        //this.frequency = frequency;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.505 -0400", hash_original_method = "3BF3B5ECD6A260296AD88686E08D9EA2", hash_generated_method = "BA99BF7D23FE4621DAC3D2F32F2A2517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuffer sb;
        sb = new StringBuffer();
        String none;
        none = "<none>";
        sb.append("SSID: ").
            append(SSID == null ? none : SSID).
            append(", BSSID: ").
            append(BSSID == null ? none : BSSID).
            append(", capabilities: ").
            append(capabilities == null ? none : capabilities).
            append(", level: ").
            append(level).
            append(", frequency: ").
            append(frequency);
        String var806458D832AB974D230FEE4CBBDBD390_189105610 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer sb = new StringBuffer();
        //String none = "<none>";
        //sb.append("SSID: ").
            //append(SSID == null ? none : SSID).
            //append(", BSSID: ").
            //append(BSSID == null ? none : BSSID).
            //append(", capabilities: ").
            //append(capabilities == null ? none : capabilities).
            //append(", level: ").
            //append(level).
            //append(", frequency: ").
            //append(frequency);
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.506 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.506 -0400", hash_original_method = "8ED27770F672F68987FCE9C19DB9995F", hash_generated_method = "B14F6C36D7192C313C66974623DE6AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(SSID);
        dest.writeString(BSSID);
        dest.writeString(capabilities);
        dest.writeInt(level);
        dest.writeInt(frequency);
        // ---------- Original Method ----------
        //dest.writeString(SSID);
        //dest.writeString(BSSID);
        //dest.writeString(capabilities);
        //dest.writeInt(level);
        //dest.writeInt(frequency);
    }

    
    public static final Creator<ScanResult> CREATOR = new Creator<ScanResult>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.506 -0400", hash_original_method = "BC0BC21C35AE7AEEA6D20EE623F1DB0A", hash_generated_method = "011E3B554801B3F8365A59A5F92DAF4E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScanResult createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ScanResult varF0E1C3F438EAB86B05F6AB0DE8943FF8_1230736182 = (new ScanResult(
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readInt(),
                    in.readInt()
                ));
            return (ScanResult)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ScanResult(
                    //in.readString(),
                    //in.readString(),
                    //in.readString(),
                    //in.readInt(),
                    //in.readInt()
                //);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.506 -0400", hash_original_method = "26455827E25EAA2F9112FF9001164636", hash_generated_method = "D3250FEEFEE7BD8A403F39A9E5AC3AF7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScanResult[] newArray(int size) {
            dsTaint.addTaint(size);
            ScanResult[] var4047A0601BC5981E62DCADB3F6CBAF01_958621811 = (new ScanResult[size]);
            return (ScanResult[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ScanResult[size];
        }

        
}; //Transformed anonymous class
}

