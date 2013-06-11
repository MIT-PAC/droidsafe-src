package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ServiceInfo extends ComponentInfo implements Parcelable {
    public String permission;
    public static final int FLAG_STOP_WITH_TASK = 0x0001;
    public int flags;
    public static final Creator<ServiceInfo> CREATOR = new Creator<ServiceInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.172 -0400", hash_original_method = "8978DD753FD4CAD4F30EAB16B876BC2A", hash_generated_method = "413308CCA47B0DE70FA2F411F69EC102")
        @DSModeled(DSC.SAFE)
        public ServiceInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ServiceInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.172 -0400", hash_original_method = "A983BB1A64296EC543A70CA925936DDB", hash_generated_method = "AD1DE88103F6FD7F48BA2CDFD4D96D1D")
        @DSModeled(DSC.SAFE)
        public ServiceInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ServiceInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ServiceInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.173 -0400", hash_original_method = "F8437ACFEC0EA098621A29EA36F6AD07", hash_generated_method = "D89098FEE90079F93DE89D569D08986C")
    @DSModeled(DSC.SAFE)
    public ServiceInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.173 -0400", hash_original_method = "FE9252C5AEDF7EDCC5A8663E23AE8AA0", hash_generated_method = "FA5750A4988C6AA9A381FBDEF57BAEC2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.173 -0400", hash_original_method = "03E698CAC1E21FAA46C8FF1C3071D430", hash_generated_method = "25FAB989EB43AD091CAA7400302E02EE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.173 -0400", hash_original_method = "DA4A80B9AC3442B8DFBCD8315889AD94", hash_generated_method = "8E2916DB3305A810B39880F6B39AA4DA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.173 -0400", hash_original_method = "59146AE4B3130A7BADEE9DF4447D4A3B", hash_generated_method = "D2A8775586614C045729F3609889100B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var9DC1DFC9378ADB3ABB2A214490D7C96A_507177302 = ("ServiceInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ServiceInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.174 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.174 -0400", hash_original_method = "0D65CECC76E553C003E9EF65F2ADA018", hash_generated_method = "50EBE759D9FA94B96A4E0A0AA9867201")
    @DSModeled(DSC.SAFE)
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

    
}


