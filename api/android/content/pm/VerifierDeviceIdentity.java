package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

public class VerifierDeviceIdentity implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.845 -0400", hash_original_field = "925EF8231AAA68ACC2C87B01BF3AC56C", hash_generated_field = "C881F5DFD1BC7D567E596FEF17B3CE41")

    private long mIdentity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.845 -0400", hash_original_field = "2379041CD5DCC44567F03DDDCCCA7E14", hash_generated_field = "2E79569F54EEBC27B02253CAB547B720")

    private String mIdentityString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.846 -0400", hash_original_method = "E059465E7DB8A2431674A21301113B59", hash_generated_method = "5B40BFFB7D43821ECE66CFA15D91A5D5")
    public  VerifierDeviceIdentity(long identity) {
        mIdentity = identity;
        mIdentityString = encodeBase32(identity);
        // ---------- Original Method ----------
        //mIdentity = identity;
        //mIdentityString = encodeBase32(identity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.849 -0400", hash_original_method = "C7AE44830E0FC5E69D8DADD2D1F4EE49", hash_generated_method = "5C44CB16F71B67511D6C83722F03ED32")
    private  VerifierDeviceIdentity(Parcel source) {
        addTaint(source.getTaint());
        final long identity = source.readLong();
        mIdentity = identity;
        mIdentityString = encodeBase32(identity);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.853 -0400", hash_original_method = "A24AB6F6393E3B1D0D15482B7A9B6B3D", hash_generated_method = "B4F50AB02B61378161411FD53AA98AF3")
    @Override
    public int hashCode() {
        int var79C5FA9051D508BFCD08A85A1A16733E_1959089356 = ((int) mIdentity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689151227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689151227;
        // ---------- Original Method ----------
        //return (int) mIdentity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.854 -0400", hash_original_method = "C98AD9093350C34D0EE60C856A2859EF", hash_generated_method = "12BC311C40A346F2C7A0ACD1EA484688")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof VerifierDeviceIdentity))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1136801698 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646919777 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646919777;
        } //End block
        final VerifierDeviceIdentity o = (VerifierDeviceIdentity) other;
        boolean var3ED808479E599241B8207A449ECF3DA0_1740083389 = (mIdentity == o.mIdentity);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097488739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097488739;
        // ---------- Original Method ----------
        //if (!(other instanceof VerifierDeviceIdentity)) {
            //return false;
        //}
        //final VerifierDeviceIdentity o = (VerifierDeviceIdentity) other;
        //return mIdentity == o.mIdentity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.856 -0400", hash_original_method = "515E509B017A25F880CBE7C878F2607B", hash_generated_method = "046F03065E63D22CEDD9E95E87A193BC")
    @Override
    public String toString() {
String var07D462A050FE03B4C86B74A2A5E47504_1066338075 =         mIdentityString;
        var07D462A050FE03B4C86B74A2A5E47504_1066338075.addTaint(taint);
        return var07D462A050FE03B4C86B74A2A5E47504_1066338075;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.858 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1EC836F445439AEFA6104863DE9EC49F")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_532452813 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242054998 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242054998;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.858 -0400", hash_original_method = "74CC0770FB4A8F3105F468C0A6751DF9", hash_generated_method = "8BCE8B1E8B7ED052E466B701D8E34A4B")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeLong(mIdentity);
        // ---------- Original Method ----------
        //dest.writeLong(mIdentity);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.859 -0400", hash_original_field = "A572ACD36A87BD71592D358A7B3194D2", hash_generated_field = "7E38ED9569F38626C4A028FD8A2B8485")

    private static final int LONG_SIZE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.859 -0400", hash_original_field = "8B311A5067EB27AB6377B5E7A06B9A7C", hash_generated_field = "7A01EEFF778BCF3738D765B30759018C")

    private static final int GROUP_SIZE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.859 -0400", hash_original_field = "1FC596195D1F9CC23B8ACF683A79358C", hash_generated_field = "20D44E9FEF188B57242BE5C99167ADCE")

    private static final char ENCODE[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', '2', '3', '4', '5', '6', '7',
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.859 -0400", hash_original_field = "0964217270BCAAEFE573E27015C0D565", hash_generated_field = "1700CA6C584107CCD7EC123C22C80E8A")

    private static final char SEPARATOR = '-';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.860 -0400", hash_original_field = "5D332226985CE193A54C57E93EC669C5", hash_generated_field = "B66ADEA0D2643455DE07784BB9BD72C0")

    public static final Parcelable.Creator<VerifierDeviceIdentity> CREATOR
            = new Parcelable.Creator<VerifierDeviceIdentity>() {
        public VerifierDeviceIdentity createFromParcel(Parcel source) {
            return new VerifierDeviceIdentity(source);
        }

        public VerifierDeviceIdentity[] newArray(int size) {
            return new VerifierDeviceIdentity[size];
        }
    };
    // orphaned legacy method
    public VerifierDeviceIdentity createFromParcel(Parcel source) {
            return new VerifierDeviceIdentity(source);
        }
    
    // orphaned legacy method
    public VerifierDeviceIdentity[] newArray(int size) {
            return new VerifierDeviceIdentity[size];
        }
    
}

