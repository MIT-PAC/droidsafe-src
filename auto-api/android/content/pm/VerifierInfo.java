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
    public String packageName;
    public PublicKey publicKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.008 -0400", hash_original_method = "CA1DA71A9B8C344527DB0EB280A0A444", hash_generated_method = "4A6B1C13184DA83350628133A1E4A404")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public VerifierInfo(String packageName, PublicKey publicKey) {
        dsTaint.addTaint(publicKey.dsTaint);
        dsTaint.addTaint(packageName);
        {
            boolean var81EEFDB302B8570AE8CB400E9D1576A0_999150561 = (packageName == null || packageName.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("packageName must not be null or empty");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("publicKey must not be null");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (packageName == null || packageName.length() == 0) {
            //throw new IllegalArgumentException("packageName must not be null or empty");
        //} else if (publicKey == null) {
            //throw new IllegalArgumentException("publicKey must not be null");
        //}
        //this.packageName = packageName;
        //this.publicKey = publicKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.008 -0400", hash_original_method = "C00118AB5B5CCE6381E41D90579B27A9", hash_generated_method = "DC8A0574B688EE3D1EC10BD45E3FC788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private VerifierInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        packageName = source.readString();
        publicKey = (PublicKey) source.readSerializable();
        // ---------- Original Method ----------
        //packageName = source.readString();
        //publicKey = (PublicKey) source.readSerializable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.009 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.009 -0400", hash_original_method = "F898CE68252B35C4629787E370ED7F66", hash_generated_method = "351462D33CC56FF28226A3427B375024")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(packageName);
        dest.writeSerializable(publicKey);
        // ---------- Original Method ----------
        //dest.writeString(packageName);
        //dest.writeSerializable(publicKey);
    }

    
    public static final Parcelable.Creator<VerifierInfo> CREATOR = new Parcelable.Creator<VerifierInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.009 -0400", hash_original_method = "189C78EFC045E49FDE942E42CD914197", hash_generated_method = "71353320124CA4D659A2818CBBD626A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public VerifierInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            VerifierInfo varC5696981DF5C836582975A6EBF4A411E_2098810492 = (new VerifierInfo(source));
            return (VerifierInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new VerifierInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.010 -0400", hash_original_method = "2A57B99D5792DCAD0A00B68B5799D542", hash_generated_method = "C3885C48F87E95696DA449328423C016")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public VerifierInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            VerifierInfo[] var1A8EDADFBC9F8C6C3CDC4246E55DAC90_1308579725 = (new VerifierInfo[size]);
            return (VerifierInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new VerifierInfo[size];
        }

        
}; //Transformed anonymous class
}

