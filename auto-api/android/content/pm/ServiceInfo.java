package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ServiceInfo extends ComponentInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.207 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.207 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.208 -0400", hash_original_method = "F8437ACFEC0EA098621A29EA36F6AD07", hash_generated_method = "EDCE9066F17AD3973393DCDC0BE762D3")
    public  ServiceInfo() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.208 -0400", hash_original_method = "FE9252C5AEDF7EDCC5A8663E23AE8AA0", hash_generated_method = "80827E1A6781EB150E1C0BFC2BF49268")
    public  ServiceInfo(ServiceInfo orig) {
        super(orig);
        permission = orig.permission;
        flags = orig.flags;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.209 -0400", hash_original_method = "03E698CAC1E21FAA46C8FF1C3071D430", hash_generated_method = "035F8275016FB7064BA568ACF174F7FE")
    private  ServiceInfo(Parcel source) {
        super(source);
        permission = source.readString();
        flags = source.readInt();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.210 -0400", hash_original_method = "DA4A80B9AC3442B8DFBCD8315889AD94", hash_generated_method = "073CA30EFB52483F0D041DCEDE3CE0A0")
    public void dump(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        pw.println(prefix + "permission=" + permission);
        pw.println(prefix + "flags=0x" + Integer.toHexString(flags));
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.211 -0400", hash_original_method = "59146AE4B3130A7BADEE9DF4447D4A3B", hash_generated_method = "53D54E7C7E7BE3BDCC5A161ACA1B98B2")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1368330506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1368330506 = "ServiceInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1368330506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1368330506;
        
        
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.212 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B54CE6B1B586F6D971392C758CDA594E")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694368049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694368049;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.212 -0400", hash_original_method = "0D65CECC76E553C003E9EF65F2ADA018", hash_generated_method = "E1047CAE5411B78A9C5E1417C489A103")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(permission);
        dest.writeInt(flags);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.213 -0400", hash_original_field = "86CDFFC4E2C34BE0BF1CE72B45C76EE2", hash_generated_field = "BCFC88EA4A2C840BDC8017A6371C1D0B")

    public static final int FLAG_STOP_WITH_TASK = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.213 -0400", hash_original_field = "0617EC2A993DE099179336515C76721A", hash_generated_field = "3C5616FB8F531F1B5A69F671577BAF41")

    public static final Creator<ServiceInfo> CREATOR =
        new Creator<ServiceInfo>() {
        public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
        public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    };
    
    public ServiceInfo createFromParcel(Parcel source) {
            return new ServiceInfo(source);
        }
    
    
    public ServiceInfo[] newArray(int size) {
            return new ServiceInfo[size];
        }
    
}

