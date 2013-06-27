package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

class Primality {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.814 -0400", hash_original_method = "3E56E5809677C3FC79921E23C4FBCC34", hash_generated_method = "BF7E1FB696DD619FEE28860391904779")
    private  Primality() {
        // ---------- Original Method ----------
    }

    
        static BigInteger nextProbablePrime(BigInteger n) {
        int i, j;
        int gapSize = 1024;
        int[] modules = new int[primes.length];
        boolean isDivisible[] = new boolean[gapSize];
        BigInt ni = n.getBigInt();
        if (ni.bitLength() <= 10) {
            int l = (int)ni.longInt();
            if (l < primes[primes.length - 1]) {
                for (i = 0; l >= primes[i]; i++) {}
                return BIprimes[i];
            }
        }
        BigInt startPoint = ni.copy();
        BigInt probPrime = new BigInt();
        startPoint.addPositiveInt(BigInt.remainderByPositiveInt(ni, 2) + 1);
        for (i = 0; i < primes.length; i++) {
            modules[i] = BigInt.remainderByPositiveInt(startPoint, primes[i]) - gapSize;
        }
        while (true) {
            Arrays.fill(isDivisible, false);
            for (i = 0; i < primes.length; i++) {
                modules[i] = (modules[i] + gapSize) % primes[i];
                j = (modules[i] == 0) ? 0 : (primes[i] - modules[i]);
                for (; j < gapSize; j += primes[i]) {
                    isDivisible[j] = true;
                }
            }
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.815 -0400", hash_original_field = "A30A479233D903EB994AD7FFD4E8F32C", hash_generated_field = "94CDB0562F6B0E21CA676590172598A7")

    private static int[] primes = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.815 -0400", hash_original_field = "6B29DE19A7248E70046FAC8FB4519EC0", hash_generated_field = "23ECF4515BE8C57E69FEED2F43A626C5")

    private static BigInteger BIprimes[] = new BigInteger[primes.length];
    static {
        for (int i = 0; i < primes.length; i++) {
            BIprimes[i] = BigInteger.valueOf(primes[i]);
        }
    }
    
}

