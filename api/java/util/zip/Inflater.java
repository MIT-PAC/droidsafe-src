package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.util.Arrays;

import dalvik.system.CloseGuard;

public class Inflater {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.288 -0500", hash_original_field = "A2FC62482F8FC5A7B00D9127EAC6F44C", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.291 -0500", hash_original_field = "26AE1163BD027CE87ED65D36070B90DA", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.293 -0500", hash_original_field = "59CD61E3A383ACAD01F8F1AA33285180", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.296 -0500", hash_original_field = "08F981D2052F2054FBA17453D5812FDB", hash_generated_field = "ABAE73DF8C1106FF2AA116571646D44D")

    private boolean needsDictionary;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.298 -0500", hash_original_field = "29B64591123A903836B90C66F6149507", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.301 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();

    /**
     * This constructor creates an inflater that expects a header from the input
     * stream. Use {@link #Inflater(boolean)} if the input comes without a ZLIB
     * header.
     */
    @DSComment("No action/impact")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.303 -0500", hash_original_method = "52564046B1BB792C24EFCB3BD00F948F", hash_generated_method = "8EDD147117DB7DE8BA64CEAE40395168")
    
public Inflater() {
        this(false);
    }

    /**
     * This constructor allows to create an inflater that expects no header from
     * the input stream.
     *
     * @param noHeader
     *            {@code true} indicates that no ZLIB header comes with the
     *            input.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.307 -0500", hash_original_method = "6E14F1A8283580C2FF6B640CB113BDBB", hash_generated_method = "9BFEE4EEF9C6E938FDF49B7E4E659932")
    
public Inflater(boolean noHeader) {
        streamHandle = createStream(noHeader);
        guard.open("end");
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.625 -0400", hash_original_method = "EB8AEE543E2EBA4CEDE95D04C6068F47", hash_generated_method = "1BF33FBB5B725B8E0BAC4087BE6A0EF6")
    
    private long createStream(boolean noHeader1){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((noHeader1) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    /**
     * Releases resources associated with this {@code Inflater}. Any unused
     * input or output is discarded. This method should be called explicitly in
     * order to free native resources as soon as possible. After {@code end()} is
     * called, other methods will typically throw {@code IllegalStateException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.313 -0500", hash_original_method = "2BA55F9CC22F910CD3563C29BAA19EFA", hash_generated_method = "A03D9EE6B4731A54CC53F8A4E54BC04E")
    
public synchronized void end() {
        guard.close();
        if (streamHandle != -1) {
            endImpl(streamHandle);
            inRead = 0;
            inLength = 0;
            streamHandle = -1;
        }
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.626 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "D37840FF1F65E54A18F1909F3D74BED2")
    
    private void endImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.320 -0500", hash_original_method = "C6D54AF1AC1AC75675A3D536A7405AD5", hash_generated_method = "D608C6F2150995D96F3D1297805B81FD")
    
@Override protected void finalize() {
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
            end();
        } finally {
            try {
                super.finalize();
            } catch (Throwable t) {
                throw new AssertionError(t);
            }
        }
    }

    /**
     * Indicates if the {@code Inflater} has inflated the entire deflated
     * stream. If deflated bytes remain and {@link #needsInput} returns {@code
     * true} this method will return {@code false}. This method should be
     * called after all deflated input is supplied to the {@code Inflater}.
     *
     * @return {@code true} if all input has been inflated, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.323 -0500", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "9EE93713E74AD8A78F696927ADB1433F")
    
public synchronized boolean finished() {
        return finished;
    }

    /**
     * Returns the {@link Adler32} checksum of the bytes inflated so far, or the
     * checksum of the preset dictionary if {@link #needsDictionary} returns true.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.325 -0500", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "82F839CE56BEDC13EDBA911A4636B0D0")
    
public synchronized int getAdler() {
        checkOpen();
        return getAdlerImpl(streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.628 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "61AA5FDACEC6651845F52881D1AA45E1")
    
    private int getAdlerImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    /**
     * Returns the total number of bytes read by the {@code Inflater}. This
     * method is the same as {@link #getTotalIn} except that it returns a
     * {@code long} value instead of an integer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.332 -0500", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "FCE91DCC2F170EFCCC587BDC96E02BDA")
    
public synchronized long getBytesRead() {
        checkOpen();
        return getTotalInImpl(streamHandle);
    }

    /**
     * Returns a the total number of bytes written by this {@code Inflater}. This
     * method is the same as {@code getTotalOut} except it returns a
     * {@code long} value instead of an integer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.334 -0500", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "6759B83D7E1BB8BF4188E4F21BEAB91C")
    
public synchronized long getBytesWritten() {
        checkOpen();
        return getTotalOutImpl(streamHandle);
    }

    /**
     * Returns the number of bytes of current input remaining to be read by this
     * inflater.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.337 -0500", hash_original_method = "32C3A4ADD77E37876C3BDB6A1F021118", hash_generated_method = "9A84D4A4AEB0773F1C62663156C386B1")
    
public synchronized int getRemaining() {
        return inLength - inRead;
    }

    /**
     * Returns the total number of bytes of input read by this {@code Inflater}. This
     * method is limited to 32 bits; use {@link #getBytesRead} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.340 -0500", hash_original_method = "9AAB506621EC0609B7127649800D2F50", hash_generated_method = "1A53CA58166D1EB399DA650885596A85")
    
public synchronized int getTotalIn() {
        checkOpen();
        return (int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.630 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "FB76E0894AEC3C0AE237576E4437CBE2")
    
    private long getTotalInImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    /**
     * Returns the total number of bytes written to the output buffer by this {@code
     * Inflater}. The method is limited to 32 bits; use {@link #getBytesWritten} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.347 -0500", hash_original_method = "FABA8B5ADD5ED280AE5319590E5362F9", hash_generated_method = "A3D7A2E164A55A300A14496BC870B17F")
    
public synchronized int getTotalOut() {
        checkOpen();
        return (int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.631 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "5AF6B3DE8DAA8B45ECC40138EB65121D")
    
    private long getTotalOutImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (long)taintDouble;
    }

    /**
     * Inflates bytes from the current input and stores them in {@code buf}.
     *
     * @param buf
     *            the buffer where decompressed data bytes are written.
     * @return the number of bytes inflated.
     * @throws DataFormatException
     *             if the underlying stream is corrupted or was not compressed
     *             using a {@code Deflater}.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.354 -0500", hash_original_method = "7C5FBD7958B67E2748697C6AE75EF54A", hash_generated_method = "B75641034F3607F953153800C3BBCF63")
    
public int inflate(byte[] buf) throws DataFormatException {
        return inflate(buf, 0, buf.length);
    }

    /**
     * Inflates up to {@code byteCount} bytes from the current input and stores them in
     * {@code buf} starting at {@code offset}.
     *
     * @throws DataFormatException
     *             if the underlying stream is corrupted or was not compressed
     *             using a {@code Deflater}.
     * @return the number of bytes inflated.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.357 -0500", hash_original_method = "A9BECE182D792DD8518CBB91F9F00FF9", hash_generated_method = "F8D3D9A7BB2AD5CD0AD38F517D82B6DE")
    
public synchronized int inflate(byte[] buf, int offset, int byteCount) throws DataFormatException {
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);

        checkOpen();

        if (needsInput()) {
            return 0;
        }

        boolean neededDict = needsDictionary;
        needsDictionary = false;
        int result = inflateImpl(buf, offset, byteCount, streamHandle);
        if (needsDictionary && neededDict) {
            throw new DataFormatException("Needs dictionary");
        }
        return result;
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.633 -0400", hash_original_method = "A8B950E858D2B61E3A45CBD5749ED1E4", hash_generated_method = "7C499CD96631CE30A44602D6BA0E1735")
    
    private int inflateImpl(byte[] buf, int offset, int byteCount, long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buf[0];
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    /**
     * Returns true if the input bytes were compressed with a preset
     * dictionary. This method should be called if the first call to {@link #inflate} returns 0,
     * to determine whether a dictionary is required. If so, {@link #setDictionary}
     * should be called with the appropriate dictionary before calling {@code
     * inflate} again. Use {@link #getAdler} to determine which dictionary is required.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.363 -0500", hash_original_method = "2E859AFCAB2941AC9B20C295FD1D1EA5", hash_generated_method = "7779CF9192F834EB5DBB79D67EDAE91E")
    
public synchronized boolean needsDictionary() {
        return needsDictionary;
    }

    /**
     * Returns true if {@link #setInput} must be called before inflation can continue.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.366 -0500", hash_original_method = "2FEA461389DC997E7C6EFE4743DC8941", hash_generated_method = "F8FBBC33C128BF4DED150384F0563506")
    
public synchronized boolean needsInput() {
        return inRead == inLength;
    }

    /**
     * Resets this {@code Inflater}. Should be called prior to inflating a new
     * set of data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.368 -0500", hash_original_method = "0513FF2BBDC9BF2AA8F8AFEEBE87C2FB", hash_generated_method = "9546DE8913EC7F787A05110861B43122")
    
public synchronized void reset() {
        checkOpen();
        finished = false;
        needsDictionary = false;
        inLength = inRead = 0;
        resetImpl(streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.635 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "E5AD6996270CB0317F4EFC6A63FC0EF4")
    
    private void resetImpl(long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    /**
     * Sets the preset dictionary to be used for inflation to {@code dictionary}.
     * See {@link #needsDictionary} for details.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.375 -0500", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "F6FF8080941571D4EFC7702CBA6FE6E3")
    
public synchronized void setDictionary(byte[] dictionary) {
        setDictionary(dictionary, 0, dictionary.length);
    }

    /**
     * Sets the preset dictionary to be used for inflation to a subsequence of {@code dictionary}
     * starting at {@code offset} and continuing for {@code byteCount} bytes. See {@link
     * #needsDictionary} for details.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.378 -0500", hash_original_method = "568AFB946554DE560CCB8443B419A0F6", hash_generated_method = "342670F05D2F90ED6E0980D6B3D2DA3A")
    
public synchronized void setDictionary(byte[] dictionary, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(dictionary.length, offset, byteCount);
        setDictionaryImpl(dictionary, offset, byteCount, streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.636 -0400", hash_original_method = "3A877A890ED74FC0EF087E03CFE5648B", hash_generated_method = "985E0C981F77D7E8CE479BE055BF30F2")
    
    private void setDictionaryImpl(byte[] dictionary, int offset, int byteCount, long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += dictionary[0];
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    /**
     * Sets the current input to to be decompressed. This method should only be
     * called if {@link #needsInput} returns {@code true}.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.384 -0500", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "2F3B40F86F19A07DE7F3CED216B3F40D")
    
public synchronized void setInput(byte[] buf) {
        setInput(buf, 0, buf.length);
    }

    /**
     * Sets the current input to to be decompressed. This method should only be
     * called if {@link #needsInput} returns {@code true}.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.387 -0500", hash_original_method = "D18140A9F42CF395349CBB05A8109835", hash_generated_method = "6A01D937CA709A5F6CB7B04E9366B285")
    
public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inRead = 0;
        inLength = byteCount;
        setInputImpl(buf, offset, byteCount, streamHandle);
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.638 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "D0CB44C44F11094BAD5A989A17A93627")
    
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += buf[0];
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += handle;
    	addTaint(taintDouble);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.394 -0500", hash_original_method = "AC4A3418B937D51D6E31ACAFC1E07B42", hash_generated_method = "D7FD83AC4F4EC149280CBB982D991F10")
    
synchronized int setFileInput(FileDescriptor fd, long offset, int byteCount) {
        checkOpen();
        inRead = 0;
        inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        return inLength;
    }

    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:58.639 -0400", hash_original_method = "E3E6A66CB79BDD3B7E592B29E67DC77B", hash_generated_method = "43BB6AFA525CFA3411DA6AD0705FE347")
    
    private int setFileInputImpl(FileDescriptor fd, long offset, int byteCount, long handle){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += fd.getTaintInt();
    	taintDouble += offset;
    	taintDouble += byteCount;
    	taintDouble += handle;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.401 -0500", hash_original_method = "477FE56B6846A3E6E3ED71C242A2D9F4", hash_generated_method = "F4E3EB0422165BBFE20A7C412A60C694")
    
private void checkOpen() {
        if (streamHandle == -1) {
            throw new IllegalStateException("attempt to use Inflater after calling end");
        }
    }
    
}

