package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

public class VerifierDeviceIdentity implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.534 -0400", hash_original_field = "925EF8231AAA68ACC2C87B01BF3AC56C", hash_generated_field = "C881F5DFD1BC7D567E596FEF17B3CE41")

    private long mIdentity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.546 -0400", hash_original_field = "2379041CD5DCC44567F03DDDCCCA7E14", hash_generated_field = "2E79569F54EEBC27B02253CAB547B720")

    private String mIdentityString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.548 -0400", hash_original_method = "E059465E7DB8A2431674A21301113B59", hash_generated_method = "5B40BFFB7D43821ECE66CFA15D91A5D5")
    public  VerifierDeviceIdentity(long identity) {
        mIdentity = identity;
        mIdentityString = encodeBase32(identity);
        // ---------- Original Method ----------
        //mIdentity = identity;
        //mIdentityString = encodeBase32(identity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.593 -0400", hash_original_method = "C7AE44830E0FC5E69D8DADD2D1F4EE49", hash_generated_method = "DD754348401602469B0F1F4BE5C1FED7")
    private  VerifierDeviceIdentity(Parcel source) {
        long identity;
        identity = source.readLong();
        mIdentity = identity;
        mIdentityString = encodeBase32(identity);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //final long identity = source.readLong();
        //mIdentity = identity;
        //mIdentityString = encodeBase32(identity);
    }

    
        public static VerifierDeviceIdentity generate() {
        final SecureRandom sr = new SecureRandom();
        return generate(sr);
    }

    
        static VerifierDeviceIdentity generate(Random rng) {
        long identity = rng.nextLong();
        return new VerifierDeviceIdentity(identity);
    }

    
        private static final String encodeBase32(long input) {
        final char[] alphabet = ENCODE;
        final char encoded[] = new char[LONG_SIZE + (LONG_SIZE / GROUP_SIZE)];
        int index = encoded.length;
        for (int i = 0; i < LONG_SIZE; i++) {
            if (i > 0 && (i % GROUP_SIZE) == (LONG_SIZE % GROUP_SIZE)) {
                encoded[--index] = SEPARATOR;
            }
            final int group = (int) (input & 0x1F);
            input >>>= 5;
            encoded[--index] = alphabet[group];
        }
        return String.valueOf(encoded);
    }

    
        private static final long decodeBase32(byte[] input) throws IllegalArgumentException {
        long output = 0L;
        int numParsed = 0;
        final int N = input.length;
        for (int i = 0; i < N; i++) {
            final int group = input[i];
            final int value;
            if ('A' <= group && group <= 'Z') {
                value = group - 'A';
            } else if ('2' <= group && group <= '7') {
                value = group - ('2' - 26);
            } else if (group == SEPARATOR) {
                continue;
            } else if ('a' <= group && group <= 'z') {
                value = group - 'a';
            } else if (group == '0') {
                value = 'O' - 'A';
            } else if (group == '1') {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.605 -0400", hash_original_method = "A24AB6F6393E3B1D0D15482B7A9B6B3D", hash_generated_method = "572DBD9A8111EF46E7BB1FE1B0552EA1")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135807637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135807637;
        // ---------- Original Method ----------
        //return (int) mIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.627 -0400", hash_original_method = "C98AD9093350C34D0EE60C856A2859EF", hash_generated_method = "7DA24E2CC65EA2FEE41F5767C5FF8EB0")
    @Override
    public boolean equals(Object other) {
        VerifierDeviceIdentity o;
        o = (VerifierDeviceIdentity) other;
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692107740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_692107740;
        // ---------- Original Method ----------
        //if (!(other instanceof VerifierDeviceIdentity)) {
            //return false;
        //}
        //final VerifierDeviceIdentity o = (VerifierDeviceIdentity) other;
        //return mIdentity == o.mIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.628 -0400", hash_original_method = "515E509B017A25F880CBE7C878F2607B", hash_generated_method = "21C8ABF7368271C51BAC1B5C57150556")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_404828195 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_404828195 = mIdentityString;
        varB4EAC82CA7396A68D541C85D26508E83_404828195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_404828195;
        // ---------- Original Method ----------
        //return mIdentityString;
    }

    
        public static VerifierDeviceIdentity parse(String deviceIdentity) throws IllegalArgumentException {
        final byte[] input;
        try {
            input = deviceIdentity.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("bad base-32 characters in input");
        }
        return new VerifierDeviceIdentity(decodeBase32(input));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.629 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DF3604C0B45B11F2C82389994A2D87B3")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319660907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319660907;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.630 -0400", hash_original_method = "74CC0770FB4A8F3105F468C0A6751DF9", hash_generated_method = "0BB03E06E4B5A233260C88A5B9CB1211")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mIdentity);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeLong(mIdentity);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.630 -0400", hash_original_field = "A572ACD36A87BD71592D358A7B3194D2", hash_generated_field = "2C8E5830BE421ED01CF532150D307B89")

    private static int LONG_SIZE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.630 -0400", hash_original_field = "8B311A5067EB27AB6377B5E7A06B9A7C", hash_generated_field = "847C655DEB34070B548DD092516D51E7")

    private static int GROUP_SIZE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.630 -0400", hash_original_field = "1FC596195D1F9CC23B8ACF683A79358C", hash_generated_field = "D5FC599A58FB61139E4A2315AE6E7360")

    private static char ENCODE[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', '2', '3', '4', '5', '6', '7',
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.630 -0400", hash_original_field = "0964217270BCAAEFE573E27015C0D565", hash_generated_field = "764588F89BA68F9BA523D6EA789FD917")

    private static char SEPARATOR = '-';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.630 -0400", hash_original_field = "5D332226985CE193A54C57E93EC669C5", hash_generated_field = "B66ADEA0D2643455DE07784BB9BD72C0")

    public static final Parcelable.Creator<VerifierDeviceIdentity> CREATOR
            = new Parcelable.Creator<VerifierDeviceIdentity>() {
        public VerifierDeviceIdentity createFromParcel(Parcel source) {
            return new VerifierDeviceIdentity(source);
        }

        public VerifierDeviceIdentity[] newArray(int size) {
            return new VerifierDeviceIdentity[size];
        }
    };
}

