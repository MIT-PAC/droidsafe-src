package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FeatureInfo implements Parcelable {
    public String name;
    public int reqGlEsVersion;
    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.730 -0400", hash_original_method = "41B0CF3D831DF05554CAE06DC339C2C3", hash_generated_method = "28CCD5FE48E24B28094FDFB6399BB826")
    @DSModeled(DSC.SAFE)
    public FeatureInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.730 -0400", hash_original_method = "72E19FF88F50F4C463F65FF457EE5FBC", hash_generated_method = "2A12F01704B22B1FE477D9D24258B37B")
    @DSModeled(DSC.SAFE)
    public FeatureInfo(FeatureInfo orig) {
        dsTaint.addTaint(orig.dsTaint);
        name = orig.name;
        reqGlEsVersion = orig.reqGlEsVersion;
        flags = orig.flags;
        // ---------- Original Method ----------
        //name = orig.name;
        //reqGlEsVersion = orig.reqGlEsVersion;
        //flags = orig.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.730 -0400", hash_original_method = "759BB7759C525D4DCDEBEE87E6E15A1A", hash_generated_method = "7D41BE047C2D42036DC59F387550C6A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FeatureInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        name = source.readString();
        reqGlEsVersion = source.readInt();
        flags = source.readInt();
        // ---------- Original Method ----------
        //name = source.readString();
        //reqGlEsVersion = source.readInt();
        //flags = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.731 -0400", hash_original_method = "CEFF2831199A05D6B9B0449BE07C0CC4", hash_generated_method = "EF24E00EF617FC2CC536A9A238BA58FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        {
            String var0B56A8FA4B59AE14673E2EB8E1105045_2024647576 = ("FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " " + name + " fl=0x" + Integer.toHexString(flags) + "}");
        } //End block
        {
            String var5FCB32548AC3ABE5EABF651C7ED8C5CD_192250033 = ("FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " glEsVers=" + getGlEsVersion()
                    + " fl=0x" + Integer.toHexString(flags) + "}");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (name != null) {
            //return "FeatureInfo{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " " + name + " fl=0x" + Integer.toHexString(flags) + "}";
        //} else {
            //return "FeatureInfo{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " glEsVers=" + getGlEsVersion()
                    //+ " fl=0x" + Integer.toHexString(flags) + "}";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.731 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.731 -0400", hash_original_method = "2C0CF9F313C5756E6D4A273445A14FD5", hash_generated_method = "EFAE0C38CAD358684E2D7ED235B9F85D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(name);
        dest.writeInt(reqGlEsVersion);
        dest.writeInt(flags);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeInt(reqGlEsVersion);
        //dest.writeInt(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.732 -0400", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "3094DABCBAD823B30C57F30B62B7CBE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getGlEsVersion() {
        int major;
        major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor;
        minor = reqGlEsVersion & 0x0000ffff;
        String var3CDB58B0CDECF20616EF79109A7E8415_621717426 = (String.valueOf(major)+"."+String.valueOf(minor));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        //int minor = reqGlEsVersion & 0x0000ffff;
        //return String.valueOf(major)+"."+String.valueOf(minor);
    }

    
    public static final int GL_ES_VERSION_UNDEFINED = 0;
    public static final int FLAG_REQUIRED = 0x0001;
    public static final Creator<FeatureInfo> CREATOR = new Creator<FeatureInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.732 -0400", hash_original_method = "795598BB85F5A7B4341D7421A827595B", hash_generated_method = "6A20E6C8C8AFF1018E7FD08B6904BCAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FeatureInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            FeatureInfo varB4DBB0DE3FCC82A652AA3ABCA99CB647_1006479796 = (new FeatureInfo(source));
            return (FeatureInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new FeatureInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.732 -0400", hash_original_method = "CE8FBC12368E74E2CE1E47198E761C2C", hash_generated_method = "AE1FC4577F4D71FF23110EA21D95B518")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FeatureInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            FeatureInfo[] var27DEAD0E3DFD1C2BBB4D8F637A23FC6F_383697274 = (new FeatureInfo[size]);
            return (FeatureInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new FeatureInfo[size];
        }

        
}; //Transformed anonymous class
}

