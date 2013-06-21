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
    private long mIdentity;
    private String mIdentityString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.001 -0400", hash_original_method = "E059465E7DB8A2431674A21301113B59", hash_generated_method = "4D7AB171B04DCBF272DF77FA02555B05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public VerifierDeviceIdentity(long identity) {
        dsTaint.addTaint(identity);
        mIdentityString = encodeBase32(identity);
        // ---------- Original Method ----------
        //mIdentity = identity;
        //mIdentityString = encodeBase32(identity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.001 -0400", hash_original_method = "C7AE44830E0FC5E69D8DADD2D1F4EE49", hash_generated_method = "2F9642FF5A74F4FCCE4F0A73385A1FB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private VerifierDeviceIdentity(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        long identity;
        identity = source.readLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.003 -0400", hash_original_method = "A24AB6F6393E3B1D0D15482B7A9B6B3D", hash_generated_method = "A2A93272874FF904A382EBDF2FA0A73A")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) mIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.003 -0400", hash_original_method = "C98AD9093350C34D0EE60C856A2859EF", hash_generated_method = "EB525C1252415333C7B11172C506907C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        VerifierDeviceIdentity o;
        o = (VerifierDeviceIdentity) other;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(other instanceof VerifierDeviceIdentity)) {
            //return false;
        //}
        //final VerifierDeviceIdentity o = (VerifierDeviceIdentity) other;
        //return mIdentity == o.mIdentity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.003 -0400", hash_original_method = "515E509B017A25F880CBE7C878F2607B", hash_generated_method = "4C9F180527F9FDCB081C49974D6CD688")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.004 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.004 -0400", hash_original_method = "74CC0770FB4A8F3105F468C0A6751DF9", hash_generated_method = "8EA3EF1FA0EC64A97F2317B97AE47E75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeLong(mIdentity);
        // ---------- Original Method ----------
        //dest.writeLong(mIdentity);
    }

    
    private static final int LONG_SIZE = 13;
    private static final int GROUP_SIZE = 4;
    private static final char ENCODE[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', '2', '3', '4', '5', '6', '7',
    };
    private static final char SEPARATOR = '-';
    public static final Parcelable.Creator<VerifierDeviceIdentity> CREATOR = new Parcelable.Creator<VerifierDeviceIdentity>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.004 -0400", hash_original_method = "99DD28BEE7AB4272AC90CC3853107043", hash_generated_method = "E4CBAE6C5AD2A68A8599AD4775702BC7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public VerifierDeviceIdentity createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            VerifierDeviceIdentity varC3A14096080170F7CCEB1F3EF736145D_831074383 = (new VerifierDeviceIdentity(source));
            return (VerifierDeviceIdentity)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new VerifierDeviceIdentity(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.005 -0400", hash_original_method = "014F73E1B6F7F4E2290AEA380B8CCE84", hash_generated_method = "0CA84725D8E14B03837D967C5527EBAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public VerifierDeviceIdentity[] newArray(int size) {
            dsTaint.addTaint(size);
            VerifierDeviceIdentity[] var2B82618F348BB06C7F69DB30B47D1B69_2137655500 = (new VerifierDeviceIdentity[size]);
            return (VerifierDeviceIdentity[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new VerifierDeviceIdentity[size];
        }

        
}; //Transformed anonymous class
}

