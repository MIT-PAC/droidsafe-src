package java.math;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

class Division {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.891 -0400", hash_original_method = "1CA90C9F74D165C3A16F193EF3A664DD", hash_generated_method = "1CA90C9F74D165C3A16F193EF3A664DD")
    public Division ()
    {
        //Synthesized constructor
    }


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
                long aPos = temp >>> 1;
                long bPos = divisor >>> 1;
                quot = aPos / bPos;
                rem = aPos % bPos;
                rem = (rem << 1) + (temp & 1);
                if ((divisor & 1) != 0) {
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

    
}

