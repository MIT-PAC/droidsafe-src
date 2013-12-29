package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;





public class ServiceInfo extends ComponentInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.009 -0500", hash_original_field = "C7C0637C46F344602F3BBA0296ACE08D", hash_generated_field = "BCFC88EA4A2C840BDC8017A6371C1D0B")

    public static final int FLAG_STOP_WITH_TASK = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.708 -0400", hash_original_field = "0617EC2A993DE099179336515C76721A", hash_generated_field = "3C5616FB8F531F1B5A69F671577BAF41")

    public static final Creator<ServiceInfo> CREATOR =
        new Creator<ServiceInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.016 -0500", hash_original_method = "8978DD753FD4CAD4F30EAB16B876BC2A", hash_generated_method = "9BF65EB054B247A0818D16F348DD5D11")
        public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.017 -0500", hash_original_method = "A983BB1A64296EC543A70CA925936DDB", hash_generated_method = "B37CFDF0F34099E8B5BF731DF89760DD")
        public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.009 -0500", hash_original_field = "6CAD99B186075AF38B34666A3804B23C", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.010 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.011 -0500", hash_original_method = "F8437ACFEC0EA098621A29EA36F6AD07", hash_generated_method = "CD2038A4FA51EE8D98D0458B3EFA463A")
    public ServiceInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.012 -0500", hash_original_method = "FE9252C5AEDF7EDCC5A8663E23AE8AA0", hash_generated_method = "F747DDC11F6DBB4835D8388B8D559EDA")
    public ServiceInfo(ServiceInfo orig) {
        super(orig);
        permission = orig.permission;
        flags = orig.flags;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.019 -0500", hash_original_method = "03E698CAC1E21FAA46C8FF1C3071D430", hash_generated_method = "2FD656109B3013C5E4FDE714D28C7218")
    private ServiceInfo(Parcel source) {
        super(source);
        permission = source.readString();
        flags = source.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.013 -0500", hash_original_method = "DA4A80B9AC3442B8DFBCD8315889AD94", hash_generated_method = "EB15B241B0E3029C6BA03D8227806BD3")
    public void dump(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        pw.println(prefix + "permission=" + permission);
        pw.println(prefix + "flags=0x" + Integer.toHexString(flags));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.014 -0500", hash_original_method = "59146AE4B3130A7BADEE9DF4447D4A3B", hash_generated_method = "4F27970B040085460F0C06B7720A2D63")
    public String toString() {
        return "ServiceInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.015 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:07.015 -0500", hash_original_method = "0D65CECC76E553C003E9EF65F2ADA018", hash_generated_method = "FBE9D1BF041597956272BE112BB8DFFD")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(permission);
        dest.writeInt(flags);
    }
    // orphaned legacy method
    public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
    
    // orphaned legacy method
    public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    
}

