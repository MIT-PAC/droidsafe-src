package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.security.PublicKey;

public class VerifierInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.294 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.294 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "92C3AC622EF89C18B2E520A4E8042E87")

    public PublicKey publicKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.294 -0400", hash_original_method = "CA1DA71A9B8C344527DB0EB280A0A444", hash_generated_method = "4A0F34EF7686DD6BB3338D978F247E05")
    public  VerifierInfo(String packageName, PublicKey publicKey) {
        {
            boolean var81EEFDB302B8570AE8CB400E9D1576A0_1445976933 = (packageName == null || packageName.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("packageName must not be null or empty");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("publicKey must not be null");
            } //End block
        } //End collapsed parenthetic
        this.packageName = packageName;
        this.publicKey = publicKey;
        // ---------- Original Method ----------
        //if (packageName == null || packageName.length() == 0) {
            //throw new IllegalArgumentException("packageName must not be null or empty");
        //} else if (publicKey == null) {
            //throw new IllegalArgumentException("publicKey must not be null");
        //}
        //this.packageName = packageName;
        //this.publicKey = publicKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.295 -0400", hash_original_method = "C00118AB5B5CCE6381E41D90579B27A9", hash_generated_method = "538AC1C4CA2AF3E4936D2D0C0FFD434A")
    private  VerifierInfo(Parcel source) {
        packageName = source.readString();
        publicKey = (PublicKey) source.readSerializable();
        // ---------- Original Method ----------
        //packageName = source.readString();
        //publicKey = (PublicKey) source.readSerializable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.296 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "458150CCDE56699DB1F11C464BAE5B45")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928948445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_928948445;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.297 -0400", hash_original_method = "F898CE68252B35C4629787E370ED7F66", hash_generated_method = "514387663936A778AA1B269259E3670F")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageName);
        dest.writeSerializable(publicKey);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(packageName);
        //dest.writeSerializable(publicKey);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:28.297 -0400", hash_original_field = "65964BA23E11E5A5472692A88A281144", hash_generated_field = "5A0B6B9CAD98D6A4E4EBB9028FEA4E95")

    public static final Parcelable.Creator<VerifierInfo> CREATOR
            = new Parcelable.Creator<VerifierInfo>() {
        public VerifierInfo createFromParcel(Parcel source) {
            return new VerifierInfo(source);
        }

        public VerifierInfo[] newArray(int size) {
            return new VerifierInfo[size];
        }
    };
    // orphaned legacy method
    public VerifierInfo createFromParcel(Parcel source) {
            return new VerifierInfo(source);
        }
    
    // orphaned legacy method
    public VerifierInfo[] newArray(int size) {
            return new VerifierInfo[size];
        }
    
}

