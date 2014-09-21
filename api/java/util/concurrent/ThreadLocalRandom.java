/*
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Random;

/**
 * A random number generator isolated to the current thread.  Like the
 * global {@link java.util.Random} generator used by the {@link
 * java.lang.Math} class, a {@code ThreadLocalRandom} is initialized
 * with an internally generated seed that may not otherwise be
 * modified. When applicable, use of {@code ThreadLocalRandom} rather
 * than shared {@code Random} objects in concurrent programs will
 * typically encounter much less overhead and contention.  Use of
 * {@code ThreadLocalRandom} is particularly appropriate when multiple
 * tasks (for example, each a {@link ForkJoinTask}) use random numbers
 * in parallel in thread pools.
 *
 * <p>Usages of this class should typically be of the form:
 * {@code ThreadLocalRandom.current().nextX(...)} (where
 * {@code X} is {@code Int}, {@code Long}, etc).
 * When all usages are of this form, it is never possible to
 * accidently share a {@code ThreadLocalRandom} across multiple threads.
 *
 * <p>This class also provides additional commonly used bounded random
 * generation methods.
 *
 * @since 1.7
 * @hide
 * @author Doug Lea
 */
public class ThreadLocalRandom extends Random {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.133 -0400", hash_original_field = "F1B750E2EABB3E11212C9629B1E23594", hash_generated_field = "D1830FDB7DDE0BF1BF869DFB9E8B8F55")

    private static final long multiplier = 0x5DEECE66DL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.134 -0400", hash_original_field = "CC215367C342950D6B70B84DC492FCA5", hash_generated_field = "14378D5F0BAFFB9905A9AC00F7064617")

    private static final long addend = 0xBL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.134 -0400", hash_original_field = "4A227D2460FFC009910731E615563BF8", hash_generated_field = "FD08DBAA5B5D50F7022406A63F09ACDC")

    private static final long mask = (1L << 48) - 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.136 -0400", hash_original_field = "D0DDDE36BA783F13AF6D0C2D88882F95", hash_generated_field = "90487ACC8BCA296EC310B2A33C19FC74")

    private static final ThreadLocal<ThreadLocalRandom> localRandom =
        new ThreadLocal<ThreadLocalRandom>() {
            protected ThreadLocalRandom initialValue() {
                return new ThreadLocalRandom();
            }
    };

    /**
     * Returns the current thread's {@code ThreadLocalRandom}.
     *
     * @return the current thread's {@code ThreadLocalRandom}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.137 -0400", hash_original_method = "92C53BDAD95F58D492137B2FB8E11036", hash_generated_method = "F19ABD2F124D4FC12EDE55146FFDD4CE")
    
public static ThreadLocalRandom current() {
        return localRandom.get();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.140 -0400", hash_original_field = "69C0FF7A18B285945A9C2A9CBC507E3D", hash_generated_field = "1BE793533417FE4217C3112B19621A96")


    private static final long serialVersionUID = -5851777807851030925L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.134 -0400", hash_original_field = "2E10D215A3536F129AA1EECC56C1D3B6", hash_generated_field = "997D85AD8E3EEFE20E532831FE48F646")

    private long rnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.135 -0400", hash_original_field = "6FBE6536E7CE204510C4979FD7989151", hash_generated_field = "6FBE6536E7CE204510C4979FD7989151")

    boolean initialized;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.135 -0400", hash_original_field = "DDFDE0B926EDE34070EFC4AFE5DC2431", hash_generated_field = "E2227F46DBC619B65AC86E7BABDFD933")

    // different TLRs in the common case that they are located near
    // each other.
    private long pad0, pad1, pad2, pad3, pad4, pad5, pad6, pad7;


    /**
     * Constructor called only by localRandom.initialValue.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.136 -0400", hash_original_method = "73B652EBB9BEA76BA5095CB491DFDFF3", hash_generated_method = "73B652EBB9BEA76BA5095CB491DFDFF3")
    
ThreadLocalRandom() {
        super();
        initialized = true;
    }

    /**
     * Throws {@code UnsupportedOperationException}.  Setting seeds in
     * this generator is not supported.
     *
     * @throws UnsupportedOperationException always
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.137 -0400", hash_original_method = "617AB233AFC7979B41E12F087774E053", hash_generated_method = "4AA34BBC54BF16362F94EBB71F93ABA5")
    
public void setSeed(long seed) {
        if (initialized)
            throw new UnsupportedOperationException();
        rnd = (seed ^ multiplier) & mask;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.138 -0400", hash_original_method = "38F6E38F95B03801173FBE4896B18837", hash_generated_method = "89B1B5FA277BD01761AC878BE2A00E5F")
    
protected int next(int bits) {
        rnd = (rnd * multiplier + addend) & mask;
        return (int) (rnd >>> (48-bits));
    }

    /**
     * Returns a pseudorandom, uniformly distributed value between the
     * given least value (inclusive) and bound (exclusive).
     *
     * @param least the least value returned
     * @param bound the upper bound (exclusive)
     * @throws IllegalArgumentException if least greater than or equal
     * to bound
     * @return the next value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.138 -0400", hash_original_method = "5CC57CD7C5B9408E54C315A9BE16050C", hash_generated_method = "E0C143C4A578FB33A41B66D46278449D")
    
public int nextInt(int least, int bound) {
        if (least >= bound)
            throw new IllegalArgumentException();
        return nextInt(bound - least) + least;
    }

    /**
     * Returns a pseudorandom, uniformly distributed value
     * between 0 (inclusive) and the specified value (exclusive).
     *
     * @param n the bound on the random number to be returned.  Must be
     *        positive.
     * @return the next value
     * @throws IllegalArgumentException if n is not positive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.139 -0400", hash_original_method = "A039A94973265D95AF9C2DFD00E2C3B5", hash_generated_method = "6C9EE81C7AF2B1F55666053A7C3BDC7D")
    
public long nextLong(long n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must be positive");
        // Divide n by two until small enough for nextInt. On each
        // iteration (at most 31 of them but usually much less),
        // randomly choose both whether to include high bit in result
        // (offset) and whether to continue with the lower vs upper
        // half (which makes a difference only if odd).
        long offset = 0;
        while (n >= Integer.MAX_VALUE) {
            int bits = next(2);
            long half = n >>> 1;
            long nextn = ((bits & 2) == 0) ? half : n - half;
            if ((bits & 1) == 0)
                offset += n - nextn;
            n = nextn;
        }
        return offset + nextInt((int) n);
    }

    /**
     * Returns a pseudorandom, uniformly distributed value between the
     * given least value (inclusive) and bound (exclusive).
     *
     * @param least the least value returned
     * @param bound the upper bound (exclusive)
     * @return the next value
     * @throws IllegalArgumentException if least greater than or equal
     * to bound
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.139 -0400", hash_original_method = "22D629DDEBB48B37E092B39B773F8203", hash_generated_method = "1CC2AFDFE85EF85E31B7370C537CF09C")
    
public long nextLong(long least, long bound) {
        if (least >= bound)
            throw new IllegalArgumentException();
        return nextLong(bound - least) + least;
    }

    /**
     * Returns a pseudorandom, uniformly distributed {@code double} value
     * between 0 (inclusive) and the specified value (exclusive).
     *
     * @param n the bound on the random number to be returned.  Must be
     *        positive.
     * @return the next value
     * @throws IllegalArgumentException if n is not positive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.140 -0400", hash_original_method = "318657712C1B4E0634FC01830F2E251D", hash_generated_method = "E6223E3B2987D52C0F1878D4AC03D6D3")
    
public double nextDouble(double n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must be positive");
        return nextDouble() * n;
    }

    /**
     * Returns a pseudorandom, uniformly distributed value between the
     * given least value (inclusive) and bound (exclusive).
     *
     * @param least the least value returned
     * @param bound the upper bound (exclusive)
     * @return the next value
     * @throws IllegalArgumentException if least greater than or equal
     * to bound
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:20.140 -0400", hash_original_method = "FABE38E7FF870272BD571F7FA7AA9964", hash_generated_method = "F5FB2BAE343044A31DBE45EFCCEF0172")
    
public double nextDouble(double least, double bound) {
        if (least >= bound)
            throw new IllegalArgumentException();
        return nextDouble() * (bound - least) + least;
    }
}
