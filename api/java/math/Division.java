package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;


class Division {

    /**
     * Divides an array by an integer value. Implements the Knuth's division
     * algorithm. See D. Knuth, The Art of Computer Programming, vol. 2.
     *
     * @return remainder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.250 -0500", hash_original_method = "E1E264751E5195BA90C2FFC7352846D5", hash_generated_method = "C2300A69C9E396B7E6838C00C51A153A")
    
static int divideArrayByInt(int[] quotient, int[] dividend, final int dividendLength,
            final int divisor) {

        long rem = 0;
        long bLong = divisor & 0xffffffffL;

        for (int i = dividendLength - 1; i >= 0; i--) {
            long temp = (rem << 32) | (dividend[i] & 0xffffffffL);
            long quot;
            if (temp >= 0) {
                quot = (temp / bLong);
                rem = (temp % bLong);
            } else {
                /*
                 * make the dividend positive shifting it right by 1 bit then
                 * get the quotient an remainder and correct them properly
                 */
                long aPos = temp >>> 1;
                long bPos = divisor >>> 1;
                quot = aPos / bPos;
                rem = aPos % bPos;
                // double the remainder and add 1 if a is odd
                rem = (rem << 1) + (temp & 1);
                if ((divisor & 1) != 0) {
                    // the divisor is odd
                    if (quot <= rem) {
                        rem -= quot;
                    } else {
                        if (quot - rem <= bLong) {
                            rem += bLong - quot;
                            quot -= 1;
                        } else {
                            rem += (bLong << 1) - quot;
                            quot -= 2;
                        }
                    }
                }
            }
            quotient[i] = (int) (quot & 0xffffffffL);
        }
        return (int) rem;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.891 -0400", hash_original_method = "1CA90C9F74D165C3A16F193EF3A664DD", hash_generated_method = "1CA90C9F74D165C3A16F193EF3A664DD")
    public Division ()
    {
        //Synthesized constructor
    }

    
}

