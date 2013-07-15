package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FeatureInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.225 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.225 -0400", hash_original_field = "25C79D11416B49B4C9D823C1A9BE9381", hash_generated_field = "D9CA7B199E4287467AAA0CAF1003E688")

    public int reqGlEsVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.226 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.226 -0400", hash_original_method = "41B0CF3D831DF05554CAE06DC339C2C3", hash_generated_method = "28CCD5FE48E24B28094FDFB6399BB826")
    public  FeatureInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.227 -0400", hash_original_method = "72E19FF88F50F4C463F65FF457EE5FBC", hash_generated_method = "39FC86B33CA984BD49B1ABCF202820B4")
    public  FeatureInfo(FeatureInfo orig) {
        name = orig.name;
        reqGlEsVersion = orig.reqGlEsVersion;
        flags = orig.flags;
        // ---------- Original Method ----------
        //name = orig.name;
        //reqGlEsVersion = orig.reqGlEsVersion;
        //flags = orig.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.228 -0400", hash_original_method = "759BB7759C525D4DCDEBEE87E6E15A1A", hash_generated_method = "56ABA0EEF53305BE40084530A2DE504A")
    private  FeatureInfo(Parcel source) {
        name = source.readString();
        reqGlEsVersion = source.readInt();
        flags = source.readInt();
        // ---------- Original Method ----------
        //name = source.readString();
        //reqGlEsVersion = source.readInt();
        //flags = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.229 -0400", hash_original_method = "CEFF2831199A05D6B9B0449BE07C0CC4", hash_generated_method = "C929723B7C9E6A0D206A059338C9C892")
    public String toString() {
    if(name != null)        
        {
String var1ABE0A01753EF3AF1977E10E80411927_1519987217 =             "FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " " + name + " fl=0x" + Integer.toHexString(flags) + "}";
            var1ABE0A01753EF3AF1977E10E80411927_1519987217.addTaint(taint);
            return var1ABE0A01753EF3AF1977E10E80411927_1519987217;
        } //End block
        else
        {
String var33136C0B98D667EDEA5CF1AE6E0FF7BF_79951397 =             "FeatureInfo{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " glEsVers=" + getGlEsVersion()
                    + " fl=0x" + Integer.toHexString(flags) + "}";
            var33136C0B98D667EDEA5CF1AE6E0FF7BF_79951397.addTaint(taint);
            return var33136C0B98D667EDEA5CF1AE6E0FF7BF_79951397;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.230 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1F73C037D8A088F82DE8765FB3C21419")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1011705154 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335084964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335084964;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.232 -0400", hash_original_method = "2C0CF9F313C5756E6D4A273445A14FD5", hash_generated_method = "1A06C7ACFE4F5B9D1AE89B74E6412362")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        dest.writeString(name);
        dest.writeInt(reqGlEsVersion);
        dest.writeInt(flags);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeInt(reqGlEsVersion);
        //dest.writeInt(flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.232 -0400", hash_original_method = "6B16AB9E297007D3C91B331171401C71", hash_generated_method = "E43070AF14DE762701AB1BBD915FA75A")
    public String getGlEsVersion() {
        int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        int minor = reqGlEsVersion & 0x0000ffff;
String var53423E0996054EE339CEF146F3A9158D_586493880 =         String.valueOf(major)+"."+String.valueOf(minor);
        var53423E0996054EE339CEF146F3A9158D_586493880.addTaint(taint);
        return var53423E0996054EE339CEF146F3A9158D_586493880;
        // ---------- Original Method ----------
        //int major = ((reqGlEsVersion & 0xffff0000) >> 16);
        //int minor = reqGlEsVersion & 0x0000ffff;
        //return String.valueOf(major)+"."+String.valueOf(minor);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.232 -0400", hash_original_field = "5F3DA35A2CF223A14FA4283DD701279B", hash_generated_field = "783C36C8508F1DD83B69876DC88244AC")

    public static final int GL_ES_VERSION_UNDEFINED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.233 -0400", hash_original_field = "63AE3BDDDC2A4A70865F736A9BEF81BA", hash_generated_field = "8372D183E011A9DBCF8D97F3AB5A3E78")

    public static final int FLAG_REQUIRED = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:12.233 -0400", hash_original_field = "95A1EF5D9EC2F517FC7C5B12B1988350", hash_generated_field = "38F34883BED9DBE78BA7458130C48695")

    public static final Creator<FeatureInfo> CREATOR =
        new Creator<FeatureInfo>() {
        public FeatureInfo createFromParcel(Parcel source) {
            return new FeatureInfo(source);
        }
        public FeatureInfo[] newArray(int size) {
            return new FeatureInfo[size];
        }
    };
    // orphaned legacy method
    public FeatureInfo createFromParcel(Parcel source) {
            return new FeatureInfo(source);
        }
    
    // orphaned legacy method
    public FeatureInfo[] newArray(int size) {
            return new FeatureInfo[size];
        }
    
}

