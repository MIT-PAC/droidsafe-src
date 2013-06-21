package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.text.Collator;
import java.util.Comparator;

public class InstrumentationInfo extends PackageItemInfo implements Parcelable {
    public String targetPackage;
    public String sourceDir;
    public String publicSourceDir;
    public String dataDir;
    public String nativeLibraryDir;
    public boolean handleProfiling;
    public boolean functionalTest;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.040 -0400", hash_original_method = "34F974A68EBB10BE10D867312E044FDF", hash_generated_method = "9D87916FE1B410C75B139D4D86872585")
    @DSModeled(DSC.SAFE)
    public InstrumentationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.041 -0400", hash_original_method = "33EE44CD2D02810ECD9B8B62FE0C07D7", hash_generated_method = "F12A5898C66A26695DE1CDBFABC1E091")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InstrumentationInfo(InstrumentationInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
        targetPackage = orig.targetPackage;
        sourceDir = orig.sourceDir;
        publicSourceDir = orig.publicSourceDir;
        dataDir = orig.dataDir;
        nativeLibraryDir = orig.nativeLibraryDir;
        handleProfiling = orig.handleProfiling;
        functionalTest = orig.functionalTest;
        // ---------- Original Method ----------
        //targetPackage = orig.targetPackage;
        //sourceDir = orig.sourceDir;
        //publicSourceDir = orig.publicSourceDir;
        //dataDir = orig.dataDir;
        //nativeLibraryDir = orig.nativeLibraryDir;
        //handleProfiling = orig.handleProfiling;
        //functionalTest = orig.functionalTest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.041 -0400", hash_original_method = "2F2A6843358187D56B8BE4AE48B0B4F7", hash_generated_method = "F6AD74E9FDD38F16F2EE01D4ABF182C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InstrumentationInfo(Parcel source) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        targetPackage = source.readString();
        sourceDir = source.readString();
        publicSourceDir = source.readString();
        dataDir = source.readString();
        nativeLibraryDir = source.readString();
        handleProfiling = source.readInt() != 0;
        functionalTest = source.readInt() != 0;
        // ---------- Original Method ----------
        //targetPackage = source.readString();
        //sourceDir = source.readString();
        //publicSourceDir = source.readString();
        //dataDir = source.readString();
        //nativeLibraryDir = source.readString();
        //handleProfiling = source.readInt() != 0;
        //functionalTest = source.readInt() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.041 -0400", hash_original_method = "B5CF3592446C27C5B1615F6776EEEE26", hash_generated_method = "2721E74FCE32C24A8E67400BD08B09D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var55F4E7B35BC4B86BDF186A16D192D63A_2082033741 = ("InstrumentationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "InstrumentationInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + packageName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.042 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.042 -0400", hash_original_method = "6CE0B2B52F0EF507C684C63B39230F74", hash_generated_method = "7D72ED0F5BD99674B13C926FC63C8E15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        super.writeToParcel(dest, parcelableFlags);
        dest.writeString(targetPackage);
        dest.writeString(sourceDir);
        dest.writeString(publicSourceDir);
        dest.writeString(dataDir);
        dest.writeString(nativeLibraryDir);
        dest.writeInt((handleProfiling == false) ? 0 : 1);
        dest.writeInt((functionalTest == false) ? 0 : 1);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeString(targetPackage);
        //dest.writeString(sourceDir);
        //dest.writeString(publicSourceDir);
        //dest.writeString(dataDir);
        //dest.writeString(nativeLibraryDir);
        //dest.writeInt((handleProfiling == false) ? 0 : 1);
        //dest.writeInt((functionalTest == false) ? 0 : 1);
    }

    
    public static final Parcelable.Creator<InstrumentationInfo> CREATOR = new Parcelable.Creator<InstrumentationInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.042 -0400", hash_original_method = "616D094A5F6275D1C36A99C64CA287B0", hash_generated_method = "1E1667095871CC8E1A3D04DBEB7BFBAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstrumentationInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            InstrumentationInfo var14B8AB5B552237523D10CC4DD258B2FA_1898210234 = (new InstrumentationInfo(source));
            return (InstrumentationInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InstrumentationInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.043 -0400", hash_original_method = "869873A5A987B871AAF44C10B123D622", hash_generated_method = "6A7854EBA999B80D6DE8D428C69A1D69")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstrumentationInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            InstrumentationInfo[] var5404B6F234D2A2314C1986278A0F407F_1079422187 = (new InstrumentationInfo[size]);
            return (InstrumentationInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InstrumentationInfo[size];
        }

        
}; //Transformed anonymous class
}

