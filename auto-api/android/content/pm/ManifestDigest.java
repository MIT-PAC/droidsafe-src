package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.util.Arrays;
import java.util.jar.Attributes;

public class ManifestDigest implements Parcelable {
    private final byte[] mDigest;
    private static final String[] DIGEST_TYPES = {
            "SHA1-Digest", "SHA-Digest", "MD5-Digest",
    };
    private static final String TO_STRING_PREFIX = "ManifestDigest {mDigest=";
    public static final Parcelable.Creator<ManifestDigest> CREATOR = new Parcelable.Creator<ManifestDigest>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.102 -0400", hash_original_method = "D9604F3A5F3129EA7C1BE800F775B005", hash_generated_method = "C45AD81383A56AC965C0FDD17392B586")
        @DSModeled(DSC.SAFE)
        public ManifestDigest createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ManifestDigest)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ManifestDigest(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.102 -0400", hash_original_method = "16DD9663DEAF5842DB6DA715371B1F9E", hash_generated_method = "5BD92C39FC8CCCE9AC33508A726611E2")
        @DSModeled(DSC.SAFE)
        public ManifestDigest[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ManifestDigest[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ManifestDigest[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.103 -0400", hash_original_method = "241EA3F870D09C8B7DFC477170347AB4", hash_generated_method = "11F90BBCB97A08AE784174A832D452FB")
    @DSModeled(DSC.SAFE)
     ManifestDigest(byte[] digest) {
        dsTaint.addTaint(digest);
        mDigest = digest;
        // ---------- Original Method ----------
        //mDigest = digest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.103 -0400", hash_original_method = "95270655529A33593B4B2CDF05A8799C", hash_generated_method = "8C3F2F9E126766B34F8D6FB289BDBA6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ManifestDigest(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mDigest = source.createByteArray();
        // ---------- Original Method ----------
        //mDigest = source.createByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.103 -0400", hash_original_method = "FEFC548E2219D387597583D12BF40859", hash_generated_method = "74E583CFA0C7065024DB130077716962")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.103 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.104 -0400", hash_original_method = "47C1315D4986EA9CB4630AE53F1E05CD", hash_generated_method = "8278A8FCF6816B5B2CCC63D5D358B72C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        final ManifestDigest other;
        other = (ManifestDigest) o;
        boolean varCD147D09FBC77CDD6F33A2EC20812A95_1960397885 = (this == other || Arrays.equals(mDigest, other.mDigest));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(o instanceof ManifestDigest)) {
            //return false;
        //}
        //final ManifestDigest other = (ManifestDigest) o;
        //return this == other || Arrays.equals(mDigest, other.mDigest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.104 -0400", hash_original_method = "E44F66496A9E1D9F549FC1B26A939089", hash_generated_method = "5456EE107DA4F61DB3B5C80EA199CE01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var6E9AC0E3B14DAD3191BBB8CF2D620D1E_2097272490 = (Arrays.hashCode(mDigest));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Arrays.hashCode(mDigest);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.104 -0400", hash_original_method = "A781DED7FEB614EC5183E2E44D7D4BA6", hash_generated_method = "104825A65680D403BF5D5D8DA676F63E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder(TO_STRING_PREFIX.length()
                + (mDigest.length * 3) + 1);
        sb.append(TO_STRING_PREFIX);
        final int N;
        N = mDigest.length;
        {
            int i;
            i = 0;
            {
                final byte b;
                b = mDigest[i];
                IntegralToString.appendByteAsHex(sb, b, false);
                sb.append(',');
            } //End block
        } //End collapsed parenthetic
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_1599132280 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.104 -0400", hash_original_method = "E99B09FB599433225D7E730F25E61FEC", hash_generated_method = "48D3857B0C199A19F1977E506AFC3268")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeByteArray(mDigest);
        // ---------- Original Method ----------
        //dest.writeByteArray(mDigest);
    }

    
}


