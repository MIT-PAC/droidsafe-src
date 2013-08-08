package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.jar.Attributes;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;





public class ManifestDigest implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.153 -0400", hash_original_field = "B8FE4F34D4AED3B4DC97BF8FB1EDF7B9", hash_generated_field = "0913C277DFFA3409C95DA4BDD49D7D83")

    private byte[] mDigest;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.154 -0400", hash_original_method = "241EA3F870D09C8B7DFC477170347AB4", hash_generated_method = "2AB590B81F932E0A610817C3AFE1AF52")
      ManifestDigest(byte[] digest) {
        mDigest = digest;
        // ---------- Original Method ----------
        //mDigest = digest;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.155 -0400", hash_original_method = "95270655529A33593B4B2CDF05A8799C", hash_generated_method = "81E6E9333D28391C1F01F5EDAEBA2B05")
    private  ManifestDigest(Parcel source) {
        mDigest = source.createByteArray();
        // ---------- Original Method ----------
        //mDigest = source.createByteArray();
    }

    
    @DSModeled(DSC.BAN)
    static ManifestDigest fromAttributes(Attributes attributes) {
        if (attributes == null) {
            return null;
        }
        String encodedDigest = null;
        for (int i = 0; i < DIGEST_TYPES.length; i++) {
            final String value = attributes.getValue(DIGEST_TYPES[i]);
            if (value != null) {
                encodedDigest = value;
                break;
            }
        }
        if (encodedDigest == null) {
            return null;
        }
        final byte[] digest = Base64.decode(encodedDigest, Base64.DEFAULT);
        return new ManifestDigest(digest);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.156 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7FA8EBE9F82B31446E91E969A84BE35A")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1260491915 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028804095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028804095;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.157 -0400", hash_original_method = "47C1315D4986EA9CB4630AE53F1E05CD", hash_generated_method = "3D7007CC4701018016CF1F0A22AB3E5D")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof ManifestDigest))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2069706866 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345189050 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345189050;
        } //End block
        final ManifestDigest other = (ManifestDigest) o;
        boolean varEC6894E4244360D23FB7E1DEE71DDD52_1989396869 = (this == other || Arrays.equals(mDigest, other.mDigest));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233827462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_233827462;
        // ---------- Original Method ----------
        //if (!(o instanceof ManifestDigest)) {
            //return false;
        //}
        //final ManifestDigest other = (ManifestDigest) o;
        //return this == other || Arrays.equals(mDigest, other.mDigest);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.157 -0400", hash_original_method = "E44F66496A9E1D9F549FC1B26A939089", hash_generated_method = "AD318753F25A44A9BD33DD7DFAC3BFE7")
    @Override
    public int hashCode() {
        int varB7779D66595E29BE488B7CF2CDC93AED_363916621 = (Arrays.hashCode(mDigest));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202088226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202088226;
        // ---------- Original Method ----------
        //return Arrays.hashCode(mDigest);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.158 -0400", hash_original_method = "A781DED7FEB614EC5183E2E44D7D4BA6", hash_generated_method = "BF14F45DC2AA7CA978B60019DEC51F42")
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(TO_STRING_PREFIX.length()
                + (mDigest.length * 3) + 1);
        sb.append(TO_STRING_PREFIX);
        final int N = mDigest.length;
for(int i = 0;i < N;i++)
        {
            final byte b = mDigest[i];
            IntegralToString.appendByteAsHex(sb, b, false);
            sb.append(',');
        } //End block
        sb.append('}');
String var2460B846747F8B22185AD8BE722266A5_626166886 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_626166886.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_626166886;
        // ---------- Original Method ----------
        //final StringBuilder sb = new StringBuilder(TO_STRING_PREFIX.length()
                //+ (mDigest.length * 3) + 1);
        //sb.append(TO_STRING_PREFIX);
        //final int N = mDigest.length;
        //for (int i = 0; i < N; i++) {
            //final byte b = mDigest[i];
            //IntegralToString.appendByteAsHex(sb, b, false);
            //sb.append(',');
        //}
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.158 -0400", hash_original_method = "E99B09FB599433225D7E730F25E61FEC", hash_generated_method = "B27DCC9A5085A4FBFEA2182A7249C9E5")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeByteArray(mDigest);
        // ---------- Original Method ----------
        //dest.writeByteArray(mDigest);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.158 -0400", hash_original_field = "91249911BF34B4362AA46CDC794D87D7", hash_generated_field = "88D6BED7AF916659B399472DB97A15D0")

    private static final String[] DIGEST_TYPES = {
            "SHA1-Digest", "SHA-Digest", "MD5-Digest",
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.159 -0400", hash_original_field = "B3A4A86856F371DFAD12576CDC6C6F4D", hash_generated_field = "A2DC27EB415076BF83C7AA6597F50115")

    private static final String TO_STRING_PREFIX = "ManifestDigest {mDigest=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.159 -0400", hash_original_field = "467DC4F4D4BB0BFC83A7BDE7A2CD4DAD", hash_generated_field = "31F8E142CCE4D2BA50F2866C38F4C78E")

    public static final Parcelable.Creator<ManifestDigest> CREATOR
            = new Parcelable.Creator<ManifestDigest>() {
        @DSModeled(DSC.BAN)
        public ManifestDigest createFromParcel(Parcel source) {
            return new ManifestDigest(source);
        }

        @DSModeled(DSC.BAN)
        public ManifestDigest[] newArray(int size) {
            return new ManifestDigest[size];
        }
    };
    // orphaned legacy method
    public ManifestDigest createFromParcel(Parcel source) {
            return new ManifestDigest(source);
        }
    
    // orphaned legacy method
    public ManifestDigest[] newArray(int size) {
            return new ManifestDigest[size];
        }
    
}

