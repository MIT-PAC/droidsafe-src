package org.apache.harmony.security.provider.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SHA1Impl implements SHA1_Data {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.274 -0400", hash_original_method = "B6630204F62CDE245E871046BDD8B7F9", hash_generated_method = "B6630204F62CDE245E871046BDD8B7F9")
    public SHA1Impl ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    static void computeHash(int[] arrW) {
        int  a = arrW[HASH_OFFSET   ];
        int  b = arrW[HASH_OFFSET +1];
        int  c = arrW[HASH_OFFSET +2];
        int  d = arrW[HASH_OFFSET +3];
        int  e = arrW[HASH_OFFSET +4];
        int temp;
        for ( int t = 16; t < 80 ; t++ ) {
            temp  = arrW[t-3] ^ arrW[t-8] ^ arrW[t-14] ^ arrW[t-16];
            arrW[t] = ( temp<<1 ) | ( temp>>>31 );
        }
        for ( int t = 0 ; t < 20 ; t++ ) {
            temp = ( ( a<<5 ) | ( a>>>27 )   ) +
                   ( ( b & c) | ((~b) & d)   ) +
                   ( e + arrW[t] + 0x5A827999 ) ;
            e = d;
            d = c;
            c = ( b<<30 ) | ( b>>>2 ) ;
            b = a;
            a = temp;
        }
        for ( int t = 20 ; t < 40 ; t++ ) {
            temp = ((( a<<5 ) | ( a>>>27 ))) + (b ^ c ^ d) + (e + arrW[t] + 0x6ED9EBA1) ;
            e = d;
            d = c;
            c = ( b<<30 ) | ( b>>>2 ) ;
            b = a;
            a = temp;
        }
        for ( int t = 40 ; t < 60 ; t++ ) {
            temp = (( a<<5 ) | ( a>>>27 )) + ((b & c) | (b & d) | (c & d)) +
                                                             (e + arrW[t] + 0x8F1BBCDC) ;
            e = d;
            d = c;
            c = ( b<<30 ) | ( b>>>2 ) ;
            b = a;
            a = temp;
        }
        for ( int t = 60 ; t < 80 ; t++ ) {
            temp = ((( a<<5 ) | ( a>>>27 ))) + (b ^ c ^ d) + (e + arrW[t] + 0xCA62C1D6) ;
            e = d;
            d = c;
            c = ( b<<30 ) | ( b>>>2 ) ;
            b = a;
            a = temp;
        }
        arrW[HASH_OFFSET   ] += a;
        arrW[HASH_OFFSET +1] += b;
        arrW[HASH_OFFSET +2] += c;
        arrW[HASH_OFFSET +3] += d;
        arrW[HASH_OFFSET +4] += e;
    }

    
    static void updateHash(int[] intArray, byte[] byteInput, int fromByte, int toByte) {
        int index = intArray[BYTES_OFFSET];
        int i = fromByte;
        int maxWord;
        int nBytes;
        int wordIndex = index >>2;
        int byteIndex = index & 0x03;
        intArray[BYTES_OFFSET] = ( index + toByte - fromByte + 1 ) & 077 ;
        if ( byteIndex != 0 ) {       
            for ( ; ( i <= toByte ) && ( byteIndex < 4 ) ; i++ ) {
                intArray[wordIndex] |= ( byteInput[i] & 0xFF ) << ((3 - byteIndex)<<3) ;
                byteIndex++;
            }
            if ( byteIndex == 4 ) {
                wordIndex++;
                if ( wordIndex == 16 ) {          
                    computeHash(intArray);
                    wordIndex = 0;
                }
            }
            if ( i > toByte ) {                 
                return ;
            }
        }
        maxWord = (toByte - i + 1) >> 2;
        for ( int k = 0; k < maxWord ; k++ ) {
            intArray[wordIndex] = ( ((int) byteInput[i   ] & 0xFF) <<24 ) |
                                  ( ((int) byteInput[i +1] & 0xFF) <<16 ) |
                                  ( ((int) byteInput[i +2] & 0xFF) <<8  ) |
                                  ( ((int) byteInput[i +3] & 0xFF)      )  ;
            i += 4;
            wordIndex++;
            if ( wordIndex < 16 ) {     
                continue;
            }
            computeHash(intArray);      
            wordIndex = 0;
        }
        nBytes = toByte - i +1;
        if ( nBytes != 0 ) {
            int w =  ((int) byteInput[i] & 0xFF) <<24 ;
            if ( nBytes != 1 ) {
                w |= ((int) byteInput[i +1] & 0xFF) <<16 ;
                if ( nBytes != 2) {
                    w |= ((int) byteInput[i +2] & 0xFF) <<8 ;
                }
            }
            intArray[wordIndex] = w;
        }
        return ;
    }

    
}

