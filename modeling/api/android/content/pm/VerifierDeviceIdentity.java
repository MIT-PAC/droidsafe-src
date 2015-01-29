package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

import android.os.Parcel;
import android.os.Parcelable;

public class VerifierDeviceIdentity implements Parcelable {

    /**
     * Generate a new device identity.
     *
     * @return random uniformly-distributed device identity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.266 -0500", hash_original_method = "C4B44017F6EDBED8E8D2629BE0073616", hash_generated_method = "8AC9D8AE721AB8AA18DE7A3074F45273")
    
public static VerifierDeviceIdentity generate() {
        final SecureRandom sr = new SecureRandom();
        return generate(sr);
    }

    /**
     * Generate a new device identity using a provided random number generator
     * class. This is used for testing.
     *
     * @param rng random number generator to retrieve the next long from
     * @return verifier device identity based on the input from the provided
     *         random number generator
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.268 -0500", hash_original_method = "D6D944AADFC67B4BD42C933C55928E5B", hash_generated_method = "F6BDA7C6CF6CB05237F22F1D1A010B33")
    
static VerifierDeviceIdentity generate(Random rng) {
        long identity = rng.nextLong();
        return new VerifierDeviceIdentity(identity);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.276 -0500", hash_original_method = "0014F878462E6AB7B3A39DD713651CE2", hash_generated_method = "D1885278B7FEFFEE8CB7FF91673E9D18")
    
private static final String encodeBase32(long input) {
        final char[] alphabet = ENCODE;

        /*
         * Make a character array with room for the separators between each
         * group.
         */
        final char encoded[] = new char[LONG_SIZE + (LONG_SIZE / GROUP_SIZE)];

        int index = encoded.length;
        for (int i = 0; i < LONG_SIZE; i++) {
            /*
             * Make sure we don't put a separator at the beginning. Since we're
             * building from the rear of the array, we use (LONG_SIZE %
             * GROUP_SIZE) to make the odd-size group appear at the end instead
             * of the beginning.
             */
            if (i > 0 && (i % GROUP_SIZE) == (LONG_SIZE % GROUP_SIZE)) {
                encoded[--index] = SEPARATOR;
            }

            /*
             * Extract 5 bits of data, then shift it out.
             */
            final int group = (int) (input & 0x1F);
            input >>>= 5;

            encoded[--index] = alphabet[group];
        }

        return String.valueOf(encoded);
    }

    // TODO move this out to its own class (android.util.Base32)
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.279 -0500", hash_original_method = "67756D280C9AED60DD12C4FC81EE50DF", hash_generated_method = "444EFF4D618771059A5D2938B9F360A4")
    
private static final long decodeBase32(byte[] input) throws IllegalArgumentException {
        long output = 0L;
        int numParsed = 0;

        final int N = input.length;
        for (int i = 0; i < N; i++) {
            final int group = input[i];

            /*
             * This essentially does the reverse of the ENCODED alphabet above
             * without a table. A..Z are 0..25 and 2..7 are 26..31.
             */
            final int value;
            if ('A' <= group && group <= 'Z') {
                value = group - 'A';
            } else if ('2' <= group && group <= '7') {
                value = group - ('2' - 26);
            } else if (group == SEPARATOR) {
                continue;
            } else if ('a' <= group && group <= 'z') {
                /* Lowercase letters should be the same as uppercase for Base32 */
                value = group - 'a';
            } else if (group == '0') {
                /* Be nice to users that mistake O (letter) for 0 (zero) */
                value = 'O' - 'A';
            } else if (group == '1') {
                /* Be nice to users that mistake I (letter) for 1 (one) */
                value = 'I' - 'A';
            } else {
                throw new IllegalArgumentException("base base-32 character: " + group);
            }

            output = (output << 5) | value;
            numParsed++;

            if (numParsed == 1) {
                if ((value & 0xF) != value) {
                    throw new IllegalArgumentException("illegal start character; will overflow");
                }
            } else if (numParsed > 13) {
                throw new IllegalArgumentException("too long; should have 13 characters");
            }
        }

        if (numParsed != 13) {
            throw new IllegalArgumentException("too short; should have 13 characters");
        }

        return output;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.288 -0500", hash_original_method = "0CF285BB5A0F181276C01C8423A1EAF5", hash_generated_method = "04BCABD61BEDC681C225F79F9070AD72")
    
public static VerifierDeviceIdentity parse(String deviceIdentity)
            throws IllegalArgumentException {
        final byte[] input;
        try {
            input = deviceIdentity.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("bad base-32 characters in input");
        }

        return new VerifierDeviceIdentity(decodeBase32(input));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.251 -0500", hash_original_field = "393557AB25A20492A27AE09DAE140BCF", hash_generated_field = "7E38ED9569F38626C4A028FD8A2B8485")

    private static final int LONG_SIZE = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.254 -0500", hash_original_field = "3A20339031AAF8A9E59332C3AF82EC39", hash_generated_field = "7A01EEFF778BCF3738D765B30759018C")

    private static final int GROUP_SIZE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.271 -0500", hash_original_field = "75833F281B694B8CD3EC4A9C17B09CC1", hash_generated_field = "20D44E9FEF188B57242BE5C99167ADCE")

    private static final char ENCODE[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', '2', '3', '4', '5', '6', '7',
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.273 -0500", hash_original_field = "A3C2DE947E21D26C1577F395B426F934", hash_generated_field = "1700CA6C584107CCD7EC123C22C80E8A")

    private static final char SEPARATOR = '-';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.860 -0400", hash_original_field = "5D332226985CE193A54C57E93EC669C5", hash_generated_field = "B66ADEA0D2643455DE07784BB9BD72C0")

    public static final Parcelable.Creator<VerifierDeviceIdentity> CREATOR
            = new Parcelable.Creator<VerifierDeviceIdentity>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.296 -0500", hash_original_method = "99DD28BEE7AB4272AC90CC3853107043", hash_generated_method = "CB7F11B01B5E9F7B1F70E0E46EB55613")
        
public VerifierDeviceIdentity createFromParcel(Parcel source) {
            return new VerifierDeviceIdentity(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.298 -0500", hash_original_method = "014F73E1B6F7F4E2290AEA380B8CCE84", hash_generated_method = "92560B600CB1D25AB1B2F0602EC3A8FF")
        
public VerifierDeviceIdentity[] newArray(int size) {
            return new VerifierDeviceIdentity[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.256 -0500", hash_original_field = "F7C6E4AF32F5AF287AD04BA4BC64B135", hash_generated_field = "C881F5DFD1BC7D567E596FEF17B3CE41")

    private  long mIdentity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.258 -0500", hash_original_field = "5CA1432964717A942B99C303AF57A60F", hash_generated_field = "2E79569F54EEBC27B02253CAB547B720")

    private  String mIdentityString;

    /**
     * Create a verifier device identity from a long.
     *
     * @param identity device identity in a 64-bit integer.
     * @throws
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.261 -0500", hash_original_method = "E059465E7DB8A2431674A21301113B59", hash_generated_method = "1A707BAEF53A6874C071D1ABA4CECFE1")
    
public VerifierDeviceIdentity(long identity) {
        mIdentity = identity;
        mIdentityString = encodeBase32(identity);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.263 -0500", hash_original_method = "C7AE44830E0FC5E69D8DADD2D1F4EE49", hash_generated_method = "43B8624D78594E3A043D0F331A7711FC")
    
private VerifierDeviceIdentity(Parcel source) {
        final long identity = source.readLong();

        mIdentity = identity;
        mIdentityString = encodeBase32(identity);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.281 -0500", hash_original_method = "A24AB6F6393E3B1D0D15482B7A9B6B3D", hash_generated_method = "75A0F641DEED391E9C73ABF86D6CF76B")
    
@Override
    public int hashCode() {
        return (int) mIdentity;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.283 -0500", hash_original_method = "C98AD9093350C34D0EE60C856A2859EF", hash_generated_method = "8B5A81F4BB84A602E9EE5396544674BF")
    
@Override
    public boolean equals(Object other) {
        if (!(other instanceof VerifierDeviceIdentity)) {
            return false;
        }

        final VerifierDeviceIdentity o = (VerifierDeviceIdentity) other;
        return 1 == (getTaintInt() + o.getTaintInt() + 
                              mIdentity +  o.mIdentity);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.286 -0500", hash_original_method = "515E509B017A25F880CBE7C878F2607B", hash_generated_method = "08E30F2EC0373C28DD87D94073A647CC")
    
@Override
    public String toString() {
        return mIdentityString;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.290 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.293 -0500", hash_original_method = "74CC0770FB4A8F3105F468C0A6751DF9", hash_generated_method = "512AE2A823FE454BD71B54875643FE11")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mIdentity);
    }
    // orphaned legacy method
    public VerifierDeviceIdentity createFromParcel(Parcel source) {
            return new VerifierDeviceIdentity(source);
        }
    
    // orphaned legacy method
    public VerifierDeviceIdentity[] newArray(int size) {
            return new VerifierDeviceIdentity[size];
        }
    
}

