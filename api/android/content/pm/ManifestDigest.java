package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.jar.Attributes;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;

public class ManifestDigest implements Parcelable {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.882 -0500", hash_original_method = "FEFC548E2219D387597583D12BF40859", hash_generated_method = "74E583CFA0C7065024DB130077716962")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.872 -0500", hash_original_field = "98CCFB01B14B5B2BFD0EC02F7FBF0E5B", hash_generated_field = "88D6BED7AF916659B399472DB97A15D0")

    private static final String[] DIGEST_TYPES = {
            "SHA1-Digest", "SHA-Digest", "MD5-Digest",
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.874 -0500", hash_original_field = "9A3541D9231C610BEDCA34744E35F821", hash_generated_field = "A2DC27EB415076BF83C7AA6597F50115")

    private static final String TO_STRING_PREFIX = "ManifestDigest {mDigest=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.159 -0400", hash_original_field = "467DC4F4D4BB0BFC83A7BDE7A2CD4DAD", hash_generated_field = "31F8E142CCE4D2BA50F2866C38F4C78E")

    public static final Parcelable.Creator<ManifestDigest> CREATOR
            = new Parcelable.Creator<ManifestDigest>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.897 -0500", hash_original_method = "D9604F3A5F3129EA7C1BE800F775B005", hash_generated_method = "3911ABB39F4DEDE1FEA0377664D68996")
        
public ManifestDigest createFromParcel(Parcel source) {
            return new ManifestDigest(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.899 -0500", hash_original_method = "16DD9663DEAF5842DB6DA715371B1F9E", hash_generated_method = "583C792F573F47A38635467789A2ABD0")
        
public ManifestDigest[] newArray(int size) {
            return new ManifestDigest[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.870 -0500", hash_original_field = "CF6EE4EA73C0B0BAB9264F7F128D75C1", hash_generated_field = "0913C277DFFA3409C95DA4BDD49D7D83")

    private  byte[] mDigest;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.877 -0500", hash_original_method = "241EA3F870D09C8B7DFC477170347AB4", hash_generated_method = "241EA3F870D09C8B7DFC477170347AB4")
    
ManifestDigest(byte[] digest) {
        mDigest = digest;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.879 -0500", hash_original_method = "95270655529A33593B4B2CDF05A8799C", hash_generated_method = "22F9843B47D89CC41EC0D517C66F1B42")
    
private ManifestDigest(Parcel source) {
        mDigest = source.createByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.885 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.887 -0500", hash_original_method = "47C1315D4986EA9CB4630AE53F1E05CD", hash_generated_method = "8D612405C449B6069FD64C6752869978")
    
@Override
    public boolean equals(Object o) {
        if (!(o instanceof ManifestDigest)) {
            return false;
        }

        final ManifestDigest other = (ManifestDigest) o;
        return toTaintBoolean(o.getTaintInt() + getTaintInt() + 
                             mDigest.getTaintInt() + other.mDigest.getTaintInt());

        //return this == other || Arrays.equals(mDigest, other.mDigest);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.889 -0500", hash_original_method = "E44F66496A9E1D9F549FC1B26A939089", hash_generated_method = "36DCC4708255E87D514E030B24E7ADCA")
    
@Override
    public int hashCode() {
        return Arrays.hashCode(mDigest);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.892 -0500", hash_original_method = "A781DED7FEB614EC5183E2E44D7D4BA6", hash_generated_method = "125DFBEDF15AC7D6E89EBB9B2051A242")
    
@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(TO_STRING_PREFIX.length()
                + (mDigest.length * 3) + 1);

        sb.append(TO_STRING_PREFIX);

        final int N = mDigest.length;
        for (int i = 0; i < N; i++) {
            final byte b = mDigest[i];
            IntegralToString.appendByteAsHex(sb, b, false);
            sb.append(',');
        }
        sb.append('}');

        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.894 -0500", hash_original_method = "E99B09FB599433225D7E730F25E61FEC", hash_generated_method = "473050DFC6C64D66414BBE57A29E61EC")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByteArray(mDigest);
    }
    // orphaned legacy method
    public ManifestDigest createFromParcel(Parcel source) {
            return new ManifestDigest(source);
        }
    
    // orphaned legacy method
    public ManifestDigest[] newArray(int size) {
            return new ManifestDigest[size];
        }
    
}

