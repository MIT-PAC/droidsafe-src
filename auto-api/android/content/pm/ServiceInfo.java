package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ServiceInfo extends ComponentInfo implements Parcelable {
    public String permission;
    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.963 -0400", hash_original_method = "F8437ACFEC0EA098621A29EA36F6AD07", hash_generated_method = "EDCE9066F17AD3973393DCDC0BE762D3")
    @DSModeled(DSC.SAFE)
    public ServiceInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.963 -0400", hash_original_method = "FE9252C5AEDF7EDCC5A8663E23AE8AA0", hash_generated_method = "13A36E92E533E40609F860D5E0F6E63C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceInfo(ServiceInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
        permission = orig.permission;
        flags = orig.flags;
        // ---------- Original Method ----------
        //permission = orig.permission;
        //flags = orig.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.963 -0400", hash_original_method = "03E698CAC1E21FAA46C8FF1C3071D430", hash_generated_method = "71E0DB250691AD7C7AD414FCE0A4EA14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ServiceInfo(Parcel source) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        permission = source.readString();
        flags = source.readInt();
        // ---------- Original Method ----------
        //permission = source.readString();
        //flags = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.964 -0400", hash_original_method = "DA4A80B9AC3442B8DFBCD8315889AD94", hash_generated_method = "0A7AC559E0709CABFA6509ACA1D51AAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        super.dumpFront(pw, prefix);
        pw.println(prefix + "permission=" + permission);
        pw.println(prefix + "flags=0x" + Integer.toHexString(flags));
        // ---------- Original Method ----------
        //super.dumpFront(pw, prefix);
        //pw.println(prefix + "permission=" + permission);
        //pw.println(prefix + "flags=0x" + Integer.toHexString(flags));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.964 -0400", hash_original_method = "59146AE4B3130A7BADEE9DF4447D4A3B", hash_generated_method = "8F8AC2560966FC37E517B34E73E36E3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var9DC1DFC9378ADB3ABB2A214490D7C96A_1319833587 = ("ServiceInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ServiceInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.964 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.964 -0400", hash_original_method = "0D65CECC76E553C003E9EF65F2ADA018", hash_generated_method = "428438BF9E5CDA466DE3364DA35275B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(permission);
        dest.writeInt(flags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeString(permission);
        //dest.writeInt(flags);
    }

    
    public static final int FLAG_STOP_WITH_TASK = 0x0001;
    public static final Creator<ServiceInfo> CREATOR = new Creator<ServiceInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.965 -0400", hash_original_method = "8978DD753FD4CAD4F30EAB16B876BC2A", hash_generated_method = "F840F58E0A4BE1860DA430B5D8B1A783")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ServiceInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ServiceInfo varC5AFB410BB859DE83F1BC1E85587AF3C_1910241098 = (new ServiceInfo(source));
            return (ServiceInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.965 -0400", hash_original_method = "A983BB1A64296EC543A70CA925936DDB", hash_generated_method = "68BA80B9CC8DB17E010BC91823AC0958")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ServiceInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            ServiceInfo[] var4615BC9904FF862CF4331AC15040243E_1314621157 = (new ServiceInfo[size]);
            return (ServiceInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceInfo[size];
        }

        
}; //Transformed anonymous class
}

