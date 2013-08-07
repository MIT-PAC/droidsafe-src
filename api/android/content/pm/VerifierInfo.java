package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.PublicKey;

import android.os.Parcel;
import android.os.Parcelable;





public class VerifierInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.872 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.872 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "92C3AC622EF89C18B2E520A4E8042E87")

    public PublicKey publicKey;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.874 -0400", hash_original_method = "CA1DA71A9B8C344527DB0EB280A0A444", hash_generated_method = "6D1D7EFF4AE49334C9DE82052C4CD5C0")
    public  VerifierInfo(String packageName, PublicKey publicKey) {
        if(packageName == null || packageName.length() == 0)        
        {
            IllegalArgumentException varFF6190EF0E0E6C3A9D34F6FD43CD8DE4_2061437682 = new IllegalArgumentException("packageName must not be null or empty");
            varFF6190EF0E0E6C3A9D34F6FD43CD8DE4_2061437682.addTaint(taint);
            throw varFF6190EF0E0E6C3A9D34F6FD43CD8DE4_2061437682;
        } //End block
        else
        if(publicKey == null)        
        {
            IllegalArgumentException varCAF1F0A35716EA1405F16973B546B3C5_2068517564 = new IllegalArgumentException("publicKey must not be null");
            varCAF1F0A35716EA1405F16973B546B3C5_2068517564.addTaint(taint);
            throw varCAF1F0A35716EA1405F16973B546B3C5_2068517564;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.875 -0400", hash_original_method = "C00118AB5B5CCE6381E41D90579B27A9", hash_generated_method = "538AC1C4CA2AF3E4936D2D0C0FFD434A")
    private  VerifierInfo(Parcel source) {
        packageName = source.readString();
        publicKey = (PublicKey) source.readSerializable();
        // ---------- Original Method ----------
        //packageName = source.readString();
        //publicKey = (PublicKey) source.readSerializable();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.876 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BCE028BE5E5719CC8CAFA80A14706011")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1101129652 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404673101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404673101;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.877 -0400", hash_original_method = "F898CE68252B35C4629787E370ED7F66", hash_generated_method = "218A7E4B012B0800AE36210D3AF91041")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(packageName);
        dest.writeSerializable(publicKey);
        // ---------- Original Method ----------
        //dest.writeString(packageName);
        //dest.writeSerializable(publicKey);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.877 -0400", hash_original_field = "65964BA23E11E5A5472692A88A281144", hash_generated_field = "5A0B6B9CAD98D6A4E4EBB9028FEA4E95")

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

