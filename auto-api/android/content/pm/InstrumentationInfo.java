package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final Parcelable.Creator<InstrumentationInfo> CREATOR = new Parcelable.Creator<InstrumentationInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.866 -0400", hash_original_method = "616D094A5F6275D1C36A99C64CA287B0", hash_generated_method = "A534DAB86D09704BCCE6F5C2EE94B25E")
        @DSModeled(DSC.SAFE)
        public InstrumentationInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (InstrumentationInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InstrumentationInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.866 -0400", hash_original_method = "869873A5A987B871AAF44C10B123D622", hash_generated_method = "4D62DA3C2732717E034B9CEA50396189")
        @DSModeled(DSC.SAFE)
        public InstrumentationInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (InstrumentationInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InstrumentationInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.867 -0400", hash_original_method = "34F974A68EBB10BE10D867312E044FDF", hash_generated_method = "1CC35172339CE758B95136124349842E")
    @DSModeled(DSC.SAFE)
    public InstrumentationInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.867 -0400", hash_original_method = "33EE44CD2D02810ECD9B8B62FE0C07D7", hash_generated_method = "B13AB78AAD84C604C42F0B99596E8A35")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.867 -0400", hash_original_method = "2F2A6843358187D56B8BE4AE48B0B4F7", hash_generated_method = "7BC577189B18969913B97BE1615CAB9A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.867 -0400", hash_original_method = "B5CF3592446C27C5B1615F6776EEEE26", hash_generated_method = "7772158E90CB0B1F75BC3EEE04EF3412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var55F4E7B35BC4B86BDF186A16D192D63A_1332996228 = ("InstrumentationInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + packageName + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "InstrumentationInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + packageName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.868 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.868 -0400", hash_original_method = "6CE0B2B52F0EF507C684C63B39230F74", hash_generated_method = "63730CCDE8C82450FD69A70FF8B76AE0")
    @DSModeled(DSC.SAFE)
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

    
}


