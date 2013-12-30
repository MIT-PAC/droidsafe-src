package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.PublicKey;

import android.os.Parcel;
import android.os.Parcelable;





public class VerifierInfo implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.877 -0400", hash_original_field = "65964BA23E11E5A5472692A88A281144", hash_generated_field = "5A0B6B9CAD98D6A4E4EBB9028FEA4E95")

    public static final Parcelable.Creator<VerifierInfo> CREATOR
            = new Parcelable.Creator<VerifierInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.627 -0500", hash_original_method = "189C78EFC045E49FDE942E42CD914197", hash_generated_method = "E8A2FB1FB20D2D9475BC39B3F538965B")
        
public VerifierInfo createFromParcel(Parcel source) {
            return new VerifierInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.630 -0500", hash_original_method = "2A57B99D5792DCAD0A00B68B5799D542", hash_generated_method = "E5E5DB557C59E445C4A5042383BB2E88")
        
public VerifierInfo[] newArray(int size) {
            return new VerifierInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.613 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public  String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.615 -0500", hash_original_field = "B73719A7AAE8E737607C294F86B7D620", hash_generated_field = "92C3AC622EF89C18B2E520A4E8042E87")

    public  PublicKey publicKey;

    /**
     * Creates an object that represents a verifier info object.
     *
     * @param packageName the package name in Java-style. Must not be {@code
     *            null} or empty.
     * @param publicKey the public key for the signer encoded in Base64. Must
     *            not be {@code null} or empty.
     * @throws IllegalArgumentException if either argument is null or empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.617 -0500", hash_original_method = "CA1DA71A9B8C344527DB0EB280A0A444", hash_generated_method = "18AF7E792E4462DFF18625B786A09317")
    
public VerifierInfo(String packageName, PublicKey publicKey) {
        if (packageName == null || packageName.length() == 0) {
            throw new IllegalArgumentException("packageName must not be null or empty");
        } else if (publicKey == null) {
            throw new IllegalArgumentException("publicKey must not be null");
        }

        this.packageName = packageName;
        this.publicKey = publicKey;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.620 -0500", hash_original_method = "C00118AB5B5CCE6381E41D90579B27A9", hash_generated_method = "37D1B283BA5C6A792677AB241D3EBB04")
    
private VerifierInfo(Parcel source) {
        packageName = source.readString();
        publicKey = (PublicKey) source.readSerializable();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.622 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.624 -0500", hash_original_method = "F898CE68252B35C4629787E370ED7F66", hash_generated_method = "B752816B1ADC70B7DEA46EE650C9B388")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageName);
        dest.writeSerializable(publicKey);
    }
    // orphaned legacy method
    public VerifierInfo createFromParcel(Parcel source) {
            return new VerifierInfo(source);
        }
    
    // orphaned legacy method
    public VerifierInfo[] newArray(int size) {
            return new VerifierInfo[size];
        }
    
}

