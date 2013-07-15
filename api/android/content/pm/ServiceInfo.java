package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ServiceInfo extends ComponentInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.432 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.432 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.433 -0400", hash_original_method = "F8437ACFEC0EA098621A29EA36F6AD07", hash_generated_method = "EDCE9066F17AD3973393DCDC0BE762D3")
    public  ServiceInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.433 -0400", hash_original_method = "FE9252C5AEDF7EDCC5A8663E23AE8AA0", hash_generated_method = "80827E1A6781EB150E1C0BFC2BF49268")
    public  ServiceInfo(ServiceInfo orig) {
        super(orig);
        permission = orig.permission;
        flags = orig.flags;
        // ---------- Original Method ----------
        //permission = orig.permission;
        //flags = orig.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.434 -0400", hash_original_method = "03E698CAC1E21FAA46C8FF1C3071D430", hash_generated_method = "035F8275016FB7064BA568ACF174F7FE")
    private  ServiceInfo(Parcel source) {
        super(source);
        permission = source.readString();
        flags = source.readInt();
        // ---------- Original Method ----------
        //permission = source.readString();
        //flags = source.readInt();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.434 -0400", hash_original_method = "DA4A80B9AC3442B8DFBCD8315889AD94", hash_generated_method = "0AC23AB2DDBF37D9D456E8A515940FC8")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        super.dumpFront(pw, prefix);
        pw.println(prefix + "permission=" + permission);
        pw.println(prefix + "flags=0x" + Integer.toHexString(flags));
        // ---------- Original Method ----------
        //super.dumpFront(pw, prefix);
        //pw.println(prefix + "permission=" + permission);
        //pw.println(prefix + "flags=0x" + Integer.toHexString(flags));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.435 -0400", hash_original_method = "59146AE4B3130A7BADEE9DF4447D4A3B", hash_generated_method = "A7B8DB52B053E82E7268D3DEBAD1E58C")
    public String toString() {
String var4EC24595A80F5D9095B74DE6B798A232_2018231761 =         "ServiceInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
        var4EC24595A80F5D9095B74DE6B798A232_2018231761.addTaint(taint);
        return var4EC24595A80F5D9095B74DE6B798A232_2018231761;
        // ---------- Original Method ----------
        //return "ServiceInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.435 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A439ECC93884B3455C21408F7BF75907")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1152261483 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2043804723 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2043804723;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.436 -0400", hash_original_method = "0D65CECC76E553C003E9EF65F2ADA018", hash_generated_method = "CA4BA01953D84C6D9651F2189A6E24D6")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(permission);
        dest.writeInt(flags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeString(permission);
        //dest.writeInt(flags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.436 -0400", hash_original_field = "86CDFFC4E2C34BE0BF1CE72B45C76EE2", hash_generated_field = "BCFC88EA4A2C840BDC8017A6371C1D0B")

    public static final int FLAG_STOP_WITH_TASK = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.436 -0400", hash_original_field = "0617EC2A993DE099179336515C76721A", hash_generated_field = "3C5616FB8F531F1B5A69F671577BAF41")

    public static final Creator<ServiceInfo> CREATOR =
        new Creator<ServiceInfo>() {
        public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
        public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    };
    // orphaned legacy method
    public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
    
    // orphaned legacy method
    public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    
}

