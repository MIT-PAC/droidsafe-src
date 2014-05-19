package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteOrder;
import java.util.Random;

import libcore.io.Memory;
import libcore.io.SizeOf;

import org.apache.harmony.security.fortress.Engine;
import org.apache.harmony.security.fortress.Services;
import org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl;

public class SecureRandom extends Random {

    /**
     * Returns a new instance of {@code SecureRandom} that utilizes the
     * specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @return a new instance of {@code SecureRandom} that utilizes the
     *         specified algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.241 -0500", hash_original_method = "4857474807562CBFBD7813A9B58F56F0", hash_generated_method = "FDEBE827545D7E04D2A1C0D6CBDBD07B")
    
public static SecureRandom getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new SecureRandom((SecureRandomSpi) sap.spi, sap.provider,
                                algorithm);
    }

    /**
     * Returns a new instance of {@code SecureRandom} that utilizes the
     * specified algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            the name of the provider.
     * @return a new instance of {@code SecureRandom} that utilizes the
     *         specified algorithm from the specified provider.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NoSuchProviderException
     *             if the specified provider is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.RANDOM_NUMBER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.244 -0500", hash_original_method = "DE97096A3B9FE3F043FDC55F6D0E2300", hash_generated_method = "6146C77DBE8442048A0AABE34E0AE58D")
    
public static SecureRandom getInstance(String algorithm, String provider)
                                throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    /**
     * Returns a new instance of {@code SecureRandom} that utilizes the
     * specified algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            the security provider.
     * @return a new instance of {@code SecureRandom} that utilizes the
     *         specified algorithm from the specified provider.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.RANDOM_NUMBER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.247 -0500", hash_original_method = "AC11452CE9958E1D0E60D203EE825B8B", hash_generated_method = "3E3FB0A7C163821919ECD821587E5937")
    
public static SecureRandom getInstance(String algorithm, Provider provider)
            throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new SecureRandom((SecureRandomSpi) spi, provider, algorithm);
    }

    /**
     * Generates and returns the specified number of seed bytes, computed using
     * the seed generation algorithm used by this {@code SecureRandom}.
     *
     * @param numBytes
     *            the number of seed bytes.
     * @return the seed bytes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.266 -0500", hash_original_method = "3FA575BF722059F581C0BCCB1A57BEED", hash_generated_method = "36C646621AEC0E6BFFBA681007B6F7FF")
    
public static byte[] getSeed(int numBytes) {
        SecureRandom result = internalSecureRandom;
        if (result == null) {
            // single-check idiom
            internalSecureRandom = result = new SecureRandom();
        }
        return result.generateSeed(numBytes);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.211 -0500", hash_original_field = "0F8DF6F7D5A29B785D719D0DF577DFCC", hash_generated_field = "F54DA2B97CCF38D28060376DCA270C3F")

    private static final long serialVersionUID = 4940670005562187L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.214 -0500", hash_original_field = "DF770A67945C1861EE188A90255B7E65", hash_generated_field = "C89A6BFB64905EC5F61459987A032A82")

    private static final String SERVICE = "SecureRandom";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.216 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.226 -0500", hash_original_field = "365CEC96F3ED2C718BBF3BEEC73C24F0", hash_generated_field = "31989AA54DF24BBD5CAEA96810169BB6")

    private static volatile SecureRandom internalSecureRandom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.219 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.221 -0500", hash_original_field = "342C842580F0D9FD4A327B49B64AE3CF", hash_generated_field = "3A956A531DB9FE4A5E154E058CE99C7C")

    private  SecureRandomSpi secureRandomSpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.224 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Constructs a new {@code SecureRandom} that uses the default algorithm.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.230 -0500", hash_original_method = "33F8886B5EAC6FEC4DE9DFB0ACBA3485", hash_generated_method = "252724BA8862B8C576B1F1E26130777D")
    
public SecureRandom() {
        super(0);
        Services.refresh();
        Provider.Service service = Services.getSecureRandomService();
        if (service == null) {
            this.provider = null;
            this.secureRandomSpi = new SHA1PRNG_SecureRandomImpl();
            this.algorithm = "SHA1PRNG";
        } else {
            try {
                this.provider = service.getProvider();
                this.secureRandomSpi = (SecureRandomSpi)service.newInstance(null);
                this.algorithm = service.getAlgorithm();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Constructs a new seeded {@code SecureRandom} that uses the default
     * algorithm. <a href="#insecure_seed">Seeding {@code SecureRandom} may be
     * insecure</a>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.233 -0500", hash_original_method = "9BC52FCDF813ED3C3D5BC6E2620A6B25", hash_generated_method = "1322A8C23B60E858E9FB47FB0253C196")
    
public SecureRandom(byte[] seed) {
        this();
        setSeed(seed);
    }

    /**
     * Constructs a new instance of {@code SecureRandom} using the given
     * implementation from the specified provider.
     *
     * @param secureRandomSpi
     *            the implementation.
     * @param provider
     *            the security provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.235 -0500", hash_original_method = "BD02DB0E23AA7BAA028ADD51586ACEB6", hash_generated_method = "ABEC4753AB7DB76EB0A023D81E2F35F2")
    
protected SecureRandom(SecureRandomSpi secureRandomSpi,
                           Provider provider) {
        this(secureRandomSpi, provider, "unknown");
    }

    // Constructor
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.238 -0500", hash_original_method = "8ED38FDA0C5F7DDB2E6327092A1339E9", hash_generated_method = "A1C1C19A9D69A1250E20DBF8F2964DE2")
    
private SecureRandom(SecureRandomSpi secureRandomSpi,
                         Provider provider,
                         String algorithm) {
        super(0);
        this.provider = provider;
        this.algorithm = algorithm;
        this.secureRandomSpi = secureRandomSpi;
    }

    /**
     * Returns the provider associated with this {@code SecureRandom}.
     *
     * @return the provider associated with this {@code SecureRandom}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.250 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the name of the algorithm of this {@code SecureRandom}.
     *
     * @return the name of the algorithm of this {@code SecureRandom}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.252 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    
public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Seeds this {@code SecureRandom} instance with the specified {@code
     * seed}. <a href="#insecure_seed">Seeding {@code SecureRandom} may be
     * insecure</a>.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.255 -0500", hash_original_method = "8CEEFEAA85939144164B3CD7D68FA666", hash_generated_method = "6FF2926EB5B9780E8AC4BC4B5C744C2E")
    
public synchronized void setSeed(byte[] seed) {
        secureRandomSpi.engineSetSeed(seed);
    }

    /**
     * Seeds this {@code SecureRandom} instance with the specified eight-byte
     * {@code seed}. <a href="#insecure_seed">Seeding {@code SecureRandom} may
     * be insecure</a>.
     */
    @DSSpec(DSCat.TRIGGER)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.258 -0500", hash_original_method = "9FF68F20EA17830E094095398C2F5999", hash_generated_method = "AF8EB673506CC4F044372F33AC110FA0")
    
@Override
    public void setSeed(long seed) {
        if (seed == 0) {    // skip call from Random
            return;
        }
        byte[] byteSeed = new byte[SizeOf.LONG];
        Memory.pokeLong(byteSeed, 0, seed, ByteOrder.BIG_ENDIAN);
        setSeed(byteSeed);
    }

    /**
     * Generates and stores random bytes in the given {@code byte[]} for each
     * array element.
     *
     * @param bytes
     *            the {@code byte[]} to be filled with random bytes.
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.260 -0500", hash_original_method = "AD0BFB52D4FF32A1ADE4FBCCEAA68479", hash_generated_method = "4DBBCF564FF0BC95B21F356DF0A5EC03")
    
@Override
    public synchronized void nextBytes(byte[] bytes) {
        secureRandomSpi.engineNextBytes(bytes);
    }

    /**
     * Generates and returns an {@code int} containing the specified number of
     * random bits (right justified, with leading zeros).
     *
     * @param numBits
     *            number of bits to be generated. An input value should be in
     *            the range [0, 32].
     * @return an {@code int} containing the specified number of random bits.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.263 -0500", hash_original_method = "5D37488B96B0B99188E69118313D10F5", hash_generated_method = "B34786A408A262A02502287FC66E8FD4")
    
@Override
    protected final int next(int numBits) {
        if (numBits < 0) {
            numBits = 0;
        } else {
            if (numBits > 32) {
                numBits = 32;
            }
        }
        int bytes = (numBits+7)/8;
        byte[] next = new byte[bytes];
        int ret = 0;

        nextBytes(next);
        for (int i = 0; i < bytes; i++) {
            ret = (next[i] & 0xFF) | (ret << 8);
        }
        ret = ret >>> (bytes*8 - numBits);
        return ret;
    }

    /**
     * Generates and returns the specified number of seed bytes, computed using
     * the seed generation algorithm used by this {@code SecureRandom}.
     *
     * @param numBytes
     *            the number of seed bytes.
     * @return the seed bytes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.268 -0500", hash_original_method = "D819275281A9132149A7C81B1EB64271", hash_generated_method = "A7B2C1EFA5C2C930FBA9FA88AC8C3587")
    
public byte[] generateSeed(int numBytes) {
        return secureRandomSpi.engineGenerateSeed(numBytes);
    }
}

