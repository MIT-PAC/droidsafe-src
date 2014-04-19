package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public class Random implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.524 -0500", hash_original_field = "645BBA5F6E052EA6F8DB46F041512967", hash_generated_field = "63446CA233A38FF14BDAECA22D4F71C5")

    private static final long serialVersionUID = 3905348978240129619L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.527 -0500", hash_original_field = "2C764257CF60FD56D7C31603D487D669", hash_generated_field = "4AD8AC8BB1A82B02783A527C57BED92C")

    private static final long multiplier = 0x5deece66dL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.530 -0500", hash_original_field = "B180422C5850693466917F0C904BA80C", hash_generated_field = "A0E7DD206941887D2E6CA8DF3E4D9ABA")

    private boolean haveNextNextGaussian;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.532 -0500", hash_original_field = "ACAA0EFBC3AC63B559ED9234DE8E9D11", hash_generated_field = "0A68B6B74A0B1CC3A4B82347BF535A0F")

    private long seed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.534 -0500", hash_original_field = "0F21761F73F7C42657DBF9BD2C7333A3", hash_generated_field = "4242C7D6216524A8B0CAD6576C1275B5")

    private double nextNextGaussian;

    /**
     * Constructs a random generator with an initial state that is
     * unlikely to be duplicated by a subsequent instantiation.
     *
     * <p>The initial state (that is, the seed) is <i>partially</i> based
     * on the current time of day in milliseconds.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.537 -0500", hash_original_method = "3173C51AF7594D647EC1C2CFA488A448", hash_generated_method = "3003E66E4DF5DBAF130E361D30BBC461")
    
public Random() {
        // Note: Using identityHashCode() to be hermetic wrt subclasses.
        /*
        setSeed(System.currentTimeMillis() + System.identityHashCode(this));
        */
    }

    /**
     * Construct a random generator with the given {@code seed} as the
     * initial state. Equivalent to {@code Random r = new Random(); r.setSeed(seed);}.
     *
     * <p>This constructor is mainly useful for <i>predictability</i> in tests.
     * The default constructor is likely to provide better randomness.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.540 -0500", hash_original_method = "D88C1F5B76368386940C522DAEBBB898", hash_generated_method = "2AB029D1B592D6FE924D1C32E74CCD2F")
    
public Random(long seed) {
        setSeed(seed);
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code int} value of
     * the number of bits specified by the argument {@code bits} as
     * described by Donald E. Knuth in <i>The Art of Computer Programming,
     * Volume 2: Seminumerical Algorithms</i>, section 3.2.1.
     *
     * <p>Most applications will want to use one of this class' convenience methods instead.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.542 -0500", hash_original_method = "9E0494734DCD804B33C2E0A263F97885", hash_generated_method = "E5A67C6FBB96F11803063CFC8E129E2A")
    
protected synchronized int next(int bits) {
        seed = (seed * multiplier + 0xbL) & ((1L << 48) - 1);
        return (int) (seed >>> (48 - bits));
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code boolean}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.544 -0500", hash_original_method = "D8D2D3A52478C6F30DF9DDCAD352622E", hash_generated_method = "96A3AB85C6CB4661F9BF2127F4B47037")
    
public boolean nextBoolean() {
        return next(1) != 0;
    }

    /**
     * Fills {@code buf} with random bytes.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.547 -0500", hash_original_method = "43464E5BE3E8DA331BE8CD0E59C0FE2A", hash_generated_method = "CB818010546B2FB965A370CDDE73FCA0")
    
public void nextBytes(byte[] buf) {
        int rand = 0, count = 0, loop = 0;
        while (count < buf.length) {
            if (loop == 0) {
                rand = nextInt();
                loop = 3;
            } else {
                loop--;
            }
            buf[count++] = (byte) rand;
            rand >>= 8;
        }
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code double}
     * in the half-open range [0.0, 1.0).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.549 -0500", hash_original_method = "B5A1D72A0CE7841EEF7745ACB102A3D0", hash_generated_method = "754206675C2AB6563F9CD0ADBE060AC9")
    
public double nextDouble() {
        return ((((long) next(26) << 27) + next(27)) / (double) (1L << 53));
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code float}
     * in the half-open range [0.0, 1.0).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.552 -0500", hash_original_method = "D1E3B2B06AA527A72663F03AD501BB2B", hash_generated_method = "E1B32F836E7FF48D1F800BD66C08D467")
    
public float nextFloat() {
        return (next(24) / 16777216f);
    }

    /**
     * Returns a pseudo-random (approximately) normally distributed
     * {@code double} with mean 0.0 and standard deviation 1.0.
     * This method uses the <i>polar method</i> of G. E. P. Box, M.
     * E. Muller, and G. Marsaglia, as described by Donald E. Knuth in <i>The
     * Art of Computer Programming, Volume 2: Seminumerical Algorithms</i>,
     * section 3.4.1, subsection C, algorithm P.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.554 -0500", hash_original_method = "ABAEC318233CC46845A76D8E695280DE", hash_generated_method = "038AA887BE37FEC3B034B16CD1F54DA8")
    
public synchronized double nextGaussian() {
        if (haveNextNextGaussian) { // if X1 has been returned, return the
                                    // second Gaussian
            haveNextNextGaussian = false;
            return nextNextGaussian;
        }

        double v1, v2, s;
        do {
            v1 = 2 * nextDouble() - 1; // Generates two independent random
                                        // variables U1, U2
            v2 = 2 * nextDouble() - 1;
            s = v1 * v1 + v2 * v2;
        } while (s >= 1);
        double norm = Math.sqrt(-2 * Math.log(s) / s);
        nextNextGaussian = v2 * norm; // should that not be norm instead
                                        // of multiplier ?
        haveNextNextGaussian = true;
        return v1 * norm; // should that not be norm instead of multiplier
                            // ?
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code int}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.557 -0500", hash_original_method = "82F6347EB6C4A01CB76B611DAE5AF092", hash_generated_method = "7AD0ED41A8CDF10FE07383EE86DBA893")
    
public int nextInt() {
        return next(32);
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code int}
     * in the half-open range [0, n).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.560 -0500", hash_original_method = "173DEE1A34208F3BEEC0CED47E74657B", hash_generated_method = "60545AE716FFD98B148A918FF295A2FC")
    
public int nextInt(int n) {
        if (n > 0) {
            if ((n & -n) == n) {
                return (int) ((n * (long) next(31)) >> 31);
            }
            int bits, val;
            do {
                bits = next(31);
                val = bits % n;
            } while (bits - val + (n - 1) < 0);
            return val;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Returns a pseudo-random uniformly distributed {@code long}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.562 -0500", hash_original_method = "A03CC01D80C9639D8965955A7EA1BA6B", hash_generated_method = "E82AC7D0F737FA6181E233560E307496")
    
public long nextLong() {
        return ((long) next(32) << 32) + next(32);
    }

    /**
     * Modifies the seed using a linear congruential formula presented in <i>The
     * Art of Computer Programming, Volume 2</i>, Section 3.2.1.
     */
    @DSComment("From safe class list")
    @DSSpec(DSCat.SECURITY_VIOLATION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:29.565 -0500", hash_original_method = "7BB21D33F15BE2B6645BBF6EE498410D", hash_generated_method = "958B70DFEDEAC53E8F47EC09205A4BC7")
    
public synchronized void setSeed(long seed) {
        this.seed = (seed ^ multiplier) & ((1L << 48) - 1);
        haveNextNextGaussian = false;
    }
}

