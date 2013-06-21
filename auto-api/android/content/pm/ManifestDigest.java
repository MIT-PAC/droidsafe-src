package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.util.Arrays;
import java.util.jar.Attributes;

public class ManifestDigest implements Parcelable {
    private byte[] mDigest;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.047 -0400", hash_original_method = "241EA3F870D09C8B7DFC477170347AB4", hash_generated_method = "1B6285EA342714F5CB72A0F54604F82F")
    @DSModeled(DSC.SAFE)
     ManifestDigest(byte[] digest) {
        dsTaint.addTaint(digest[0]);
        // ---------- Original Method ----------
        //mDigest = digest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.047 -0400", hash_original_method = "95270655529A33593B4B2CDF05A8799C", hash_generated_method = "496D95572E4F988574348FAF07A54E99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ManifestDigest(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mDigest = source.createByteArray();
        // ---------- Original Method ----------
        //mDigest = source.createByteArray();
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.048 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.048 -0400", hash_original_method = "47C1315D4986EA9CB4630AE53F1E05CD", hash_generated_method = "9EE350C8E234C995CC6872402F7BC802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        ManifestDigest other;
        other = (ManifestDigest) o;
        boolean varCD147D09FBC77CDD6F33A2EC20812A95_27998070 = (this == other || Arrays.equals(mDigest, other.mDigest));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(o instanceof ManifestDigest)) {
            //return false;
        //}
        //final ManifestDigest other = (ManifestDigest) o;
        //return this == other || Arrays.equals(mDigest, other.mDigest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.048 -0400", hash_original_method = "E44F66496A9E1D9F549FC1B26A939089", hash_generated_method = "14E31C24B47E459AD0A1A7824B09A119")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var6E9AC0E3B14DAD3191BBB8CF2D620D1E_622569574 = (Arrays.hashCode(mDigest));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Arrays.hashCode(mDigest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.049 -0400", hash_original_method = "A781DED7FEB614EC5183E2E44D7D4BA6", hash_generated_method = "6F9D8B34E5FDFBF8EA21207618045997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(TO_STRING_PREFIX.length()
                + (mDigest.length * 3) + 1);
        sb.append(TO_STRING_PREFIX);
        int N;
        N = mDigest.length;
        {
            int i;
            i = 0;
            {
                byte b;
                b = mDigest[i];
                IntegralToString.appendByteAsHex(sb, b, false);
                sb.append(',');
            } //End block
        } //End collapsed parenthetic
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_986518831 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.049 -0400", hash_original_method = "E99B09FB599433225D7E730F25E61FEC", hash_generated_method = "015EA0E8DC4A6FB9944AABB0370EBB6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeByteArray(mDigest);
        // ---------- Original Method ----------
        //dest.writeByteArray(mDigest);
    }

    
    private static final String[] DIGEST_TYPES = {
            "SHA1-Digest", "SHA-Digest", "MD5-Digest",
    };
    private static final String TO_STRING_PREFIX = "ManifestDigest {mDigest=";
    public static final Parcelable.Creator<ManifestDigest> CREATOR = new Parcelable.Creator<ManifestDigest>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.049 -0400", hash_original_method = "D9604F3A5F3129EA7C1BE800F775B005", hash_generated_method = "A5344693A2431C4BC9966E667F83E9EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ManifestDigest createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ManifestDigest var030CE7C04AD1810C54FB0523174A1C51_1780776652 = (new ManifestDigest(source));
            return (ManifestDigest)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ManifestDigest(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.050 -0400", hash_original_method = "16DD9663DEAF5842DB6DA715371B1F9E", hash_generated_method = "A2D852532097AB683A91E8C5B3E9925C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ManifestDigest[] newArray(int size) {
            dsTaint.addTaint(size);
            ManifestDigest[] var5390833FC4120AA36ED512B8B1A2F124_640137700 = (new ManifestDigest[size]);
            return (ManifestDigest[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ManifestDigest[size];
        }

        
}; //Transformed anonymous class
}

