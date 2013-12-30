package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;




import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class NativeConverter {


    @DSModeled(DSC.SAFE)
    public static int decode(long converterHandle, byte[] input, int inEnd,
            char[] output, int outEnd, int[] data, boolean flush) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734718063 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734718063;
    }

    
    @DSModeled(DSC.SAFE)
    public static int encode(long converterHandle, char[] input, int inEnd,
            byte[] output, int outEnd, int[] data, boolean flush) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482483034 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482483034;
    }

    
    @DSModeled(DSC.SAFE)
    public static long openConverter(String encoding) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1093574736 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1093574736;
    }

    
    @DSModeled(DSC.SAFE)
    public static void closeConverter(long converterHandle) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetByteToChar(long converterHandle) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void resetCharToByte(long converterHandle) {
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] getSubstitutionBytes(long converterHandle) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2075683128 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2075683128;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getMaxBytesPerChar(long converterHandle) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485540835 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485540835;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getMinBytesPerChar(long converterHandle) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295075292 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295075292;
    }

    
    @DSModeled(DSC.SAFE)
    public static float getAveBytesPerChar(long converterHandle) {
                float var546ADE640B6EDFBC8A086EF31347E768_65193943 = DSUtils.UNKNOWN_FLOAT;
        return var546ADE640B6EDFBC8A086EF31347E768_65193943;
    }

    
    @DSModeled(DSC.SAFE)
    public static float getAveCharsPerByte(long converterHandle) {
                float var546ADE640B6EDFBC8A086EF31347E768_293980650 = DSUtils.UNKNOWN_FLOAT;
        return var546ADE640B6EDFBC8A086EF31347E768_293980650;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean contains(String converterName1, String converterName2) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181634740 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181634740;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean canEncode(long converterHandle, int codeUnit) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751980040 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751980040;
    }

    
    @DSModeled(DSC.SAFE)
    public static String[] getAvailableCharsetNames() {
    	String [] ret = new String[1];
    	ret[0] = new String();
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static Charset charsetForName(String charsetName) {
    	return new Charset(charsetName, null) {
			@DSModeled(DSC.SAFE)
        @Override
			public CharsetEncoder newEncoder() {
				return new CharsetEncoder(this, 0, 0) {
					@DSModeled(DSC.SAFE)
            @Override
					protected CoderResult encodeLoop(CharBuffer in, ByteBuffer out) {
						out.addTaint(in.getTaint());
						CoderResult res;
						switch (DroidSafeAndroidRuntime.switchControl) {
						case 0:
							res = CoderResult.OVERFLOW;
							break;
						case 1:
							res = CoderResult.UNDERFLOW;
							break;
						case 2:
							res = CoderResult.malformedForLength(in.length() + out.capacity());
							break;
						default:
							res = CoderResult.unmappableForLength(in.length() + out.capacity());
							break;
						}
						if(DroidSafeAndroidRuntime.control) {
							res.addTaint(in.getTaint());
							res.addTaint(out.getTaint());
							return res;
						} else {
							return null;
						}
					}
				};
			}
			@DSModeled(DSC.SAFE)
        @Override
			public CharsetDecoder newDecoder() {
				return new CharsetDecoder(this, 0, 0) {
					@DSModeled(DSC.SAFE)
            @Override
					protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
						out.addTaint(in.getTaint());
						CoderResult res;
						switch (DroidSafeAndroidRuntime.switchControl) {
						case 0:
							res = CoderResult.OVERFLOW;
							break;
						case 1:
							res = CoderResult.UNDERFLOW;
							break;
						case 2:
							res = CoderResult.malformedForLength(out.length() + in.capacity());
							break;
						default:
							res = CoderResult.unmappableForLength(out.length() + in.capacity());
							break;
						}
						if(DroidSafeAndroidRuntime.control) {
							res.addTaint(in.getTaint());
							res.addTaint(out.getTaint());
							return res;
						} else {
							return null;
						}
					}
				};
			}
			@Override
			public boolean contains(Charset charset) {
				return false;
			}
		};
    }

    // Translates from Java's enum to the magic numbers #defined in "NativeConverter.cpp".
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.534 -0500", hash_original_method = "E4DEB0C107DDB25A537EF0E89F1C04F8", hash_generated_method = "2E76AFD8C90588F5139C0C2D28CAEA05")
    
private static int translateCodingErrorAction(CodingErrorAction action) {
        if (action == CodingErrorAction.REPORT) {
            return 0;
        } else if (action == CodingErrorAction.IGNORE) {
            return 1;
        } else if (action == CodingErrorAction.REPLACE) {
            return 2;
        } else {
            throw new AssertionError(); // Someone changed the enum.
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.537 -0500", hash_original_method = "1ECDF97E0F5711F64AED893C5903CD77", hash_generated_method = "6AD673FE560AB907D663F74DF6336835")
    
public static int setCallbackDecode(long converterHandle, CharsetDecoder decoder) {
        return setCallbackDecode(converterHandle,
                translateCodingErrorAction(decoder.malformedInputAction()),
                translateCodingErrorAction(decoder.unmappableCharacterAction()),
                decoder.replacement());
    }

    
    @DSModeled(DSC.SAFE)
    private static int setCallbackDecode(long converterHandle, int onMalformedInput, int onUnmappableInput, String subChars) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385874043 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385874043;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:04.543 -0500", hash_original_method = "C9EC92733E72FDFF26006CD6BB2B521C", hash_generated_method = "E0EEB07D09DCA82B0AC3252F2CCCFCC5")
    
public static int setCallbackEncode(long converterHandle, CharsetEncoder encoder) {
        return setCallbackEncode(converterHandle,
                translateCodingErrorAction(encoder.malformedInputAction()),
                translateCodingErrorAction(encoder.unmappableCharacterAction()),
                encoder.replacement());
    }

    
    @DSModeled(DSC.SAFE)
    private static int setCallbackEncode(long converterHandle, int onMalformedInput, int onUnmappableInput, byte[] subBytes) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89262015 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89262015;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:22.997 -0400", hash_original_method = "B3DE170E5D5FA99ECB84F9E7CDF4AF7D", hash_generated_method = "B3DE170E5D5FA99ECB84F9E7CDF4AF7D")
    public NativeConverter ()
    {
        //Synthesized constructor
    }

    
}

