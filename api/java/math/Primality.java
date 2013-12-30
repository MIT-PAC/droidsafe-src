package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;




class Primality {

    /**
     * It uses the sieve of Eratosthenes to discard several composite numbers in
     * some appropriate range (at the moment {@code [this, this + 1024]}). After
     * this process it applies the Miller-Rabin test to the numbers that were
     * not discarded in the sieve.
     *
     * @see BigInteger#nextProbablePrime()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.698 -0500", hash_original_method = "03EAD52EF6C4F384E7E8361BBED5D4F8", hash_generated_method = "1C5C9667967D12828A8772423BE465C9")
    
static BigInteger nextProbablePrime(BigInteger n) {
        // PRE: n >= 0
        int i, j;
//        int certainty;
        int gapSize = 1024; // for searching of the next probable prime number
        int[] modules = new int[primes.length];
        boolean isDivisible[] = new boolean[gapSize];
        BigInt ni = n.getBigInt();
        // If n < "last prime of table" searches next prime in the table
        if (ni.bitLength() <= 10) {
            int l = (int)ni.longInt();
            if (l < primes[primes.length - 1]) {
                for (i = 0; l >= primes[i]; i++) {}
                return BIprimes[i];
            }
        }

        BigInt startPoint = ni.copy();
        BigInt probPrime = new BigInt();

        // Fix startPoint to "next odd number":
        startPoint.addPositiveInt(BigInt.remainderByPositiveInt(ni, 2) + 1);

//        // To set the improved certainty of Miller-Rabin
//        j = startPoint.bitLength();
//        for (certainty = 2; j < BITS[certainty]; certainty++) {
//            ;
//        }

        // To calculate modules: N mod p1, N mod p2, ... for first primes.
        for (i = 0; i < primes.length; i++) {
            modules[i] = BigInt.remainderByPositiveInt(startPoint, primes[i]) - gapSize;
        }
        while (true) {
            // At this point, all numbers in the gap are initialized as
            // probably primes
            Arrays.fill(isDivisible, false);
            // To discard multiples of first primes
            for (i = 0; i < primes.length; i++) {
                modules[i] = (modules[i] + gapSize) % primes[i];
                j = (modules[i] == 0) ? 0 : (primes[i] - modules[i]);
                for (; j < gapSize; j += primes[i]) {
                    isDivisible[j] = true;
                }
            }
            // To execute Miller-Rabin for non-divisible numbers by all first
            // primes
            for (j = 0; j < gapSize; j++) {
                if (!isDivisible[j]) {
                    probPrime.putCopy(startPoint);
                    probPrime.addPositiveInt(j);
                    if (probPrime.isPrime(100)) {
                        return new BigInteger(probPrime);
                    }
                }
            }
            startPoint.addPositiveInt(gapSize);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.692 -0500", hash_original_field = "C3DA734B26E9CB4D731987BCAE74BCEA", hash_generated_field = "C83F4D8599BBB0CEE3395F15A4E154B6")

    private static final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
            103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167,
            173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
            241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313,
            317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
            401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467,
            479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569,
            571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643,
            647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
            739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823,
            827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911,
            919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009,
            1013, 1019, 1021 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.695 -0500", hash_original_field = "E4B2B472C21ECCC0FAF6F73441D5C348", hash_generated_field = "694815BADD9AFBE18A40D6B05D39F7EA")

    private static final BigInteger BIprimes[] = new BigInteger[primes.length];

    /** Just to denote that this class can't be instantiated. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.688 -0500", hash_original_method = "3E56E5809677C3FC79921E23C4FBCC34", hash_generated_method = "3C90B9653382FF7F7553ECE11AC58DB1")
    
private Primality() {}
    static {
        for (int i = 0; i < primes.length; i++) {
            BIprimes[i] = BigInteger.valueOf(primes[i]);
        }
    }
    
}

