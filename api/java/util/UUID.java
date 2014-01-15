package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import libcore.io.Memory;

public final class UUID implements Serializable, Comparable<UUID> {

    /**
     * <p>
     * Generates a variant 2, version 4 (randomly generated number) UUID as per
     * <a href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.
     *
     * @return an UUID instance.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.038 -0500", hash_original_method = "062E55715164230436BF863A3994A273", hash_generated_method = "29D0A8B9D260A09CC32C49AB2CD937C9")
    
public static UUID randomUUID() {
        byte[] data = new byte[16];
        // lock on the class to protect lazy init
        synchronized (UUID.class) {
            if (rng == null) {
                rng = new SecureRandom();
            }
        }
        rng.nextBytes(data);
        return makeUuid(data, 4);
    }

    /**
     * <p>
     * Generates a variant 2, version 3 (name-based, MD5-hashed) UUID as per <a
     * href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.
     *
     * @param name
     *            the name used as byte array to create an UUID.
     * @return an UUID instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.041 -0500", hash_original_method = "ADE744546D5EDC5F1118EE072B40943A", hash_generated_method = "F912BC9FD1D619B64EE1F4B0C6A632F3")
    
public static UUID nameUUIDFromBytes(byte[] name) {
        if (name == null) {
            throw new NullPointerException();
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return makeUuid(md.digest(name), 3);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.044 -0500", hash_original_method = "9E98E00BE8824DAD14A3C091F30213C3", hash_generated_method = "AD54A954ABC3BE59A4B71DACEFCE0467")
    
private static UUID makeUuid(byte[] hash, int version) {
        long msb = Memory.peekLong(hash, 0, ByteOrder.BIG_ENDIAN);
        long lsb = Memory.peekLong(hash, 8, ByteOrder.BIG_ENDIAN);
        // Set the version field.
        msb &= ~(0xfL << 12);
        msb |= ((long) version) << 12;
        // Set the variant field to 2. Note that the variant field is variable-width,
        // so supporting other variants is not just a matter of changing the constant 2 below!
        lsb &= ~(0x3L << 62);
        lsb |= 2L << 62;
        return new UUID(msb, lsb);
    }

    /**
     * <p>
     * Parses a UUID string with the format defined by {@link #toString()}.
     *
     * @param uuid
     *            the UUID string to parse.
     * @return an UUID instance.
     * @throws NullPointerException
     *             if {@code uuid} is {@code null}.
     * @throws IllegalArgumentException
     *             if {@code uuid} is not formatted correctly.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.048 -0500", hash_original_method = "91976DDD0DF6E7445909995B535A77C8", hash_generated_method = "A51362772C45D6E1A99F12EB4EFB1AE6")
    
public static UUID fromString(String uuid) {
        if (uuid == null) {
            throw new NullPointerException();
        }

        int[] position = new int[5];
        int lastPosition = 1;
        int startPosition = 0;

        int i = 0;
        for (; i < position.length && lastPosition > 0; i++) {
            position[i] = uuid.indexOf("-", startPosition);
            lastPosition = position[i];
            startPosition = position[i] + 1;
        }

        // should have and only can have four "-" in UUID
        if (i != position.length || lastPosition != -1) {
            throw new IllegalArgumentException("Invalid UUID: " + uuid);
        }

        long m1 = Long.parseLong(uuid.substring(0, position[0]), 16);
        long m2 = Long.parseLong(uuid.substring(position[0] + 1, position[1]), 16);
        long m3 = Long.parseLong(uuid.substring(position[1] + 1, position[2]), 16);

        long lsb1 = Long.parseLong(uuid.substring(position[2] + 1, position[3]), 16);
        long lsb2 = Long.parseLong(uuid.substring(position[3] + 1), 16);

        long msb = (m1 << 32) | (m2 << 16) | m3;
        long lsb = (lsb1 << 48) | lsb2;

        return new UUID(msb, lsb);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.008 -0500", hash_original_field = "5CDDBC3B8FA8D7F612FD471D9CFE74D5", hash_generated_field = "091C22832E79DC74DEA4ADB3F391327C")

    private static final long serialVersionUID = -4856846361193249489L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.011 -0500", hash_original_field = "21F405F8CC9F93FAD1F4753A00726900", hash_generated_field = "A9867F7F1BA5EDFF98FD827A1CEF8FD3")

    private static SecureRandom rng;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.013 -0500", hash_original_field = "0F762932F80AC8DAB307969FF1CE2B08", hash_generated_field = "E05311E58F38272D7C9B90EC864288E6")

    private long mostSigBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.016 -0500", hash_original_field = "0835F98F890E38C6CF15225FB4DA9AC1", hash_generated_field = "76D70F6EAB49CBC32F6DF9DF520746D2")

    private long leastSigBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.018 -0500", hash_original_field = "47DF7A5E2AD811615D5B7885C50AD7F1", hash_generated_field = "ED6112CF1FA2DA1876E57F9A6D2E2836")

    private transient int variant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.021 -0500", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "BAD42B86A408081FE78996E122739899")

    private transient int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.023 -0500", hash_original_field = "145039C09D0281F07AE1DE322AF921C0", hash_generated_field = "C23704E529A178DBBDAFF49586FA6DE5")

    private transient long timestamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.025 -0500", hash_original_field = "ED9A37752C0A5C555F392E9F85BEE67E", hash_generated_field = "40191C6E13CEA31DB65CE03BDD6C6CBD")

    private transient int clockSequence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.028 -0500", hash_original_field = "42F97C738A85E2B80817A0D2AE02511D", hash_generated_field = "65A72028038C4267F57DA36CF8BC58D6")

    private transient long node;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.030 -0500", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;

    /**
     * <p>
     * Constructs an instance with the specified bits.
     *
     * @param mostSigBits
     *            The 64 most significant bits of the UUID.
     * @param leastSigBits
     *            The 64 least significant bits of the UUID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.033 -0500", hash_original_method = "ED635EB76A78F00DCB10AED73CFEDC4B", hash_generated_method = "11D84901F7C11F43D6F6B0A18CF21732")
    
public UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
        init();
    }

    /**
     * <p>
     * Sets up the transient fields of this instance based on the current values
     * of the {@code mostSigBits} and {@code leastSigBits} fields.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.036 -0500", hash_original_method = "F8E8987A89D640EB2120FADDC9242C3F", hash_generated_method = "06EC0B1949340F2A3EB7AF13AF6BBD5C")
    
private void init() {
        // setup hash field
        int msbHash = (int) (mostSigBits ^ (mostSigBits >>> 32));
        int lsbHash = (int) (leastSigBits ^ (leastSigBits >>> 32));
        hash = msbHash ^ lsbHash;

        // setup variant field
        if ((leastSigBits & 0x8000000000000000L) == 0) {
            // MSB0 not set, NCS backwards compatibility variant
            variant = 0;
        } else if ((leastSigBits & 0x4000000000000000L) != 0) {
            // MSB1 set, either MS reserved or future reserved
            variant = (int) ((leastSigBits & 0xE000000000000000L) >>> 61);
        } else {
            // MSB1 not set, RFC 4122 variant
            variant = 2;
        }

        // setup version field
        version = (int) ((mostSigBits & 0x000000000000F000) >>> 12);

        if (variant != 2 && version != 1) {
            return;
        }

        // setup timestamp field
        long timeLow = (mostSigBits & 0xFFFFFFFF00000000L) >>> 32;
        long timeMid = (mostSigBits & 0x00000000FFFF0000L) << 16;
        long timeHigh = (mostSigBits & 0x0000000000000FFFL) << 48;
        timestamp = timeLow | timeMid | timeHigh;

        // setup clock sequence field
        clockSequence = (int) ((leastSigBits & 0x3FFF000000000000L) >>> 48);

        // setup node field
        node = (leastSigBits & 0x0000FFFFFFFFFFFFL);
    }

    /**
     * <p>
     * The 64 least significant bits of the UUID.
     *
     * @return the 64 least significant bits.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.050 -0500", hash_original_method = "A0E7F1AB7FAB66E1A72A040241F18680", hash_generated_method = "0F5FC44ACDB839899508AF1E5C082750")
    
public long getLeastSignificantBits() {
        return leastSigBits;
    }

    /**
     * <p>
     * The 64 most significant bits of the UUID.
     *
     * @return the 64 most significant bits.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.053 -0500", hash_original_method = "6EF0A7C64F608CC6275528428E67572B", hash_generated_method = "4BCCED70E8636580E4C52D6A665113BF")
    
public long getMostSignificantBits() {
        return mostSigBits;
    }

    /**
     * <p>
     * The version of the variant 2 UUID as per <a
     * href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>. If the variant
     * is not 2, then the version will be 0.
     * <ul>
     * <li>1 - Time-based UUID</li>
     * <li>2 - DCE Security UUID</li>
     * <li>3 - Name-based with MD5 hashing UUID ({@link #nameUUIDFromBytes(byte[])})</li>
     * <li>4 - Randomly generated UUID ({@link #randomUUID()})</li>
     * <li>5 - Name-based with SHA-1 hashing UUID</li>
     * </ul>
     *
     * @return an {@code int} value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.055 -0500", hash_original_method = "33CA23C03592D558650D6881FB39BD17", hash_generated_method = "A9B36DF3A23FE7A3AEE1DADC87E725DC")
    
public int version() {
        return version;
    }

    /**
     * <p>
     * The variant of the UUID as per <a
     * href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.
     * <ul>
     * <li>0 - Reserved for NCS compatibility</li>
     * <li>2 - RFC 4122/Leach-Salz</li>
     * <li>6 - Reserved for Microsoft Corporation compatibility</li>
     * <li>7 - Reserved for future use</li>
     * </ul>
     *
     * @return an {@code int} value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.057 -0500", hash_original_method = "F3E55A7ADD1B924C0020F2B2D27D2CBA", hash_generated_method = "31413DCEDDB1BC04FDF5FC122CF638E7")
    
public int variant() {
        return variant;
    }

    /**
     * <p>
     * The timestamp value of the version 1, variant 2 UUID as per <a
     * href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.
     *
     * @return a {@code long} value.
     * @throws UnsupportedOperationException
     *             if {@link #version()} is not 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.060 -0500", hash_original_method = "BC9161978762C6E74741C357EC2A66B7", hash_generated_method = "02CF73D626607FB8E47E0621DEB845B1")
    
public long timestamp() {
        if (version != 1) {
            throw new UnsupportedOperationException();
        }
        return timestamp;
    }

    /**
     * <p>
     * The clock sequence value of the version 1, variant 2 UUID as per <a
     * href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.
     *
     * @return a {@code long} value.
     * @throws UnsupportedOperationException
     *             if {@link #version()} is not 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.062 -0500", hash_original_method = "22D2FA35D30B9562E8F9B8FBAC9604FC", hash_generated_method = "88D563792C86D28CDA44D828651551F6")
    
public int clockSequence() {
        if (version != 1) {
            throw new UnsupportedOperationException();
        }
        return clockSequence;
    }

    /**
     * <p>
     * The node value of the version 1, variant 2 UUID as per <a
     * href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.
     *
     * @return a {@code long} value.
     * @throws UnsupportedOperationException
     *             if {@link #version()} is not 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.064 -0500", hash_original_method = "F570F6113919571E2190BC663D44A8A0", hash_generated_method = "FE36934490D31E4E3A8AB2A433A505F0")
    
public long node() {
        if (version != 1) {
            throw new UnsupportedOperationException();
        }
        return node;
    }

    /**
     * <p>
     * Compares this UUID to the specified UUID. The natural ordering of UUIDs
     * is based upon the value of the bits from most significant to least
     * significant.
     *
     * @param uuid
     *            the UUID to compare to.
     * @return a value of -1, 0 or 1 if this UUID is less than, equal to or
     *         greater than {@code uuid}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.067 -0500", hash_original_method = "BF37BBD9CA2A2DE01ED617F2C2EA69AA", hash_generated_method = "3B0CFEE9CA9904EF17EDFCD35393AA9C")
    
public int compareTo(UUID uuid) {
        if (uuid == this) {
            return 0;
        }

        if (this.mostSigBits != uuid.mostSigBits) {
            return this.mostSigBits < uuid.mostSigBits ? -1 : 1;
        }

        assert this.mostSigBits == uuid.mostSigBits;

        if (this.leastSigBits != uuid.leastSigBits) {
            return this.leastSigBits < uuid.leastSigBits ? -1 : 1;
        }

        assert this.leastSigBits == uuid.leastSigBits;

        return 0;
    }

    /**
     * <p>
     * Compares this UUID to another object for equality. If {@code object}
     * is not {@code null}, is a UUID instance, and all bits are equal, then
     * {@code true} is returned.
     *
     * @param object
     *            the {@code Object} to compare to.
     * @return {@code true} if this UUID is equal to {@code object}
     *         or {@code false} if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.070 -0500", hash_original_method = "A38435ECE2C3D40D1AE6B3B8E9BB77AD", hash_generated_method = "DAC5BFD454F218AA43C5BFBD266BFE3D")
    
@Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this == object) {
            return true;
        }

        if (!(object instanceof UUID)) {
            return false;
        }

        UUID that = (UUID) object;

        return (this.leastSigBits == that.leastSigBits)
                && (this.mostSigBits == that.mostSigBits);
    }

    /**
     * <p>
     * Returns a hash value for this UUID that is consistent with the
     * {@link #equals(Object)} method.
     *
     * @return an {@code int} value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.072 -0500", hash_original_method = "2C05F06EE2A592A2D5972AF8C500920F", hash_generated_method = "42F78C5D38BF7B44D96FA3AD3E18463A")
    
@Override
    public int hashCode() {
        return hash;
    }

    /**
     * <p>
     * Returns a string representation of this UUID in the following format, as
     * per <a href="http://www.ietf.org/rfc/rfc4122.txt">RFC 4122</a>.
     *
     * <pre>
     *            UUID                   = time-low &quot;-&quot; time-mid &quot;-&quot;
     *                                     time-high-and-version &quot;-&quot;
     *                                     clock-seq-and-reserved
     *                                     clock-seq-low &quot;-&quot; node
     *            time-low               = 4hexOctet
     *            time-mid               = 2hexOctet
     *            time-high-and-version  = 2hexOctet
     *            clock-seq-and-reserved = hexOctet
     *            clock-seq-low          = hexOctet
     *            node                   = 6hexOctet
     *            hexOctet               = hexDigit hexDigit
     *            hexDigit =
     *                &quot;0&quot; / &quot;1&quot; / &quot;2&quot; / &quot;3&quot; / &quot;4&quot; / &quot;5&quot; / &quot;6&quot; / &quot;7&quot; / &quot;8&quot; / &quot;9&quot; /
     *                &quot;a&quot; / &quot;b&quot; / &quot;c&quot; / &quot;d&quot; / &quot;e&quot; / &quot;f&quot; /
     *                &quot;A&quot; / &quot;B&quot; / &quot;C&quot; / &quot;D&quot; / &quot;E&quot; / &quot;F&quot;
     * </pre>
     *
     * @return a String instance.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.076 -0500", hash_original_method = "2C7CA3FB1758723F3B30AD693E280579", hash_generated_method = "279F062792C198058C3199DAE4C411FA")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder(36);
        String msbStr = Long.toHexString(mostSigBits);
        if (msbStr.length() < 16) {
            int diff = 16 - msbStr.length();
            for (int i = 0; i < diff; i++) {
                builder.append('0');
            }
        }
        builder.append(msbStr);
        builder.insert(8, '-');
        builder.insert(13, '-');
        builder.append('-');
        String lsbStr = Long.toHexString(leastSigBits);
        if (lsbStr.length() < 16) {
            int diff = 16 - lsbStr.length();
            for (int i = 0; i < diff; i++) {
                builder.append('0');
            }
        }
        builder.append(lsbStr);
        builder.insert(23, '-');
        return builder.toString();
    }

    /**
     * <p>
     * Resets the transient fields to match the behavior of the constructor.
     *
     * @param in
     *            the {@code InputStream} to read from.
     * @throws IOException
     *             if {@code in} throws it.
     * @throws ClassNotFoundException
     *             if {@code in} throws it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.078 -0500", hash_original_method = "2009CB8B2416921986707AD76596B398", hash_generated_method = "AE005D9470B3BE63E266195D5DB3C857")
    
private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        // read in non-transient fields
        in.defaultReadObject();
        // setup transient fields
        init();
    }
}

