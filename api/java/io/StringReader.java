package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class StringReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.754 -0500", hash_original_field = "8D1932428116A452F4A363260F8684E7", hash_generated_field = "787A2B4D426AC144FB23E0D0502FE70E")

    private String str;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.756 -0500", hash_original_field = "AA082170A07E47DD757AA0D276241BD9", hash_generated_field = "D9BE4F291B7CF1E403126100EC51CB87")

    private int markpos = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.758 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.761 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;

    /**
     * Construct a new {@code StringReader} with {@code str} as source. The size
     * of the reader is set to the {@code length()} of the string and the Object
     * to synchronize access through is set to {@code str}.
     *
     * @param str
     *            the source string for this reader.
     */
    @DSComment("not sensitive, memory stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.764 -0500", hash_original_method = "FB44DCC8276A9B32CF15DCC88FC63BEE", hash_generated_method = "6947F25B438E6AE482E8E023AF1349D8")
    
public StringReader(String str) {
        this.str = str;
        this.count = str.length();
    }

    /**
     * Closes this reader. Once it is closed, read operations on this reader
     * will throw an {@code IOException}. Only the first invocation of this
     * method has any effect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.766 -0500", hash_original_method = "827A4A30AD2891E9194C78AEA719C92F", hash_generated_method = "4AA1355CB20EA7F230BFADCED89C2935")
    
@Override
    public void close() {
        str = null;
    }

    /**
     * Returns a boolean indicating whether this reader is closed.
     *
     * @return {@code true} if closed, otherwise {@code false}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.769 -0500", hash_original_method = "E02036AA0C500209CBC33A804345F86B", hash_generated_method = "6527F0BA57A980BF6CB039A1D9CEA605")
    
private boolean isClosed() {
        //return str == null;
        return str.getTaintBoolean();
    }

    /**
     * Sets a mark position in this reader. The parameter {@code readLimit} is
     * ignored for this class. Calling {@code reset()} will reposition the
     * reader back to the marked position.
     *
     * @param readLimit
     *            ignored for {@code StringReader} instances.
     * @throws IllegalArgumentException
     *             if {@code readLimit < 0}.
     * @throws IOException
     *             if this reader is closed.
     * @see #markSupported()
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.772 -0500", hash_original_method = "F8F979F8EBA759C2F6A839AF0D90FFA4", hash_generated_method = "CAEFA9F9FC72532B2549A04756D90732")
    
@Override
    public void mark(int readLimit) throws IOException {
        if (readLimit < 0) {
            throw new IllegalArgumentException();
        }

        synchronized (lock) {
            checkNotClosed();
            markpos = pos;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.775 -0500", hash_original_method = "52097AD3D6FE0975840C468FF1E0F766", hash_generated_method = "8E2E90CC0F7CC6CA4F243AB52DE19121")
    
private void checkNotClosed() throws IOException {
        if (isClosed()) {
            throw new IOException("StringReader is closed");
        }
    }

    /**
     * Indicates whether this reader supports the {@code mark()} and {@code
     * reset()} methods. This implementation returns {@code true}.
     *
     * @return always {@code true}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.777 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
    
@Override
    public boolean markSupported() {
        return true;
    }

    /**
     * Reads a single character from the source string and returns it as an
     * integer with the two higher-order bytes set to 0. Returns -1 if the end
     * of the source string has been reached.
     *
     * @return the character read or -1 if the end of the source string has been
     *         reached.
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.779 -0500", hash_original_method = "7FFE2BA54C7A195E9FE8B5D995EC9572", hash_generated_method = "85FFC9978267B1E67AAF608E98C06023")
    
@Override
    public int read() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            if (pos != count) {
                return str.charAt(pos++);
            }
            return -1;
        }
    }

    /**
     * Reads at most {@code len} characters from the source string and stores
     * them at {@code offset} in the character array {@code buf}. Returns the
     * number of characters actually read or -1 if the end of the source string
     * has been reached.
     *
     * @param buf
     *            the character array to store the characters read.
     * @param offset
     *            the initial position in {@code buffer} to store the characters
     *            read from this reader.
     * @param len
     *            the maximum number of characters to read.
     * @return the number of characters read or -1 if the end of the reader has
     *         been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code len < 0}, or if
     *             {@code offset + len} is greater than the size of {@code buf}.
     * @throws IOException
     *             if this reader is closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.782 -0500", hash_original_method = "85EEB2DAA826BA4238F8F98E34D3FBD9", hash_generated_method = "4EA1787DEA8553F64FE2035C6AED16CA")
    
@Override
    public int read(char[] buf, int offset, int len) throws IOException {
        synchronized (lock) {
            checkNotClosed();
            Arrays.checkOffsetAndCount(buf.length, offset, len);
            if (len == 0) {
                return 0;
            }
            if (pos == this.count) {
                return -1;
            }
            int end = pos + len > this.count ? this.count : pos + len;
            str.getChars(pos, end, buf, offset);
            int read = end - pos;
            pos = end;
            return read;
        }
    }

    /**
     * Indicates whether this reader is ready to be read without blocking. This
     * implementation always returns {@code true}.
     *
     * @return always {@code true}.
     * @throws IOException
     *             if this reader is closed.
     * @see #read()
     * @see #read(char[], int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.785 -0500", hash_original_method = "3162F271739E7EAF4DA155264EC5FC94", hash_generated_method = "82422747FE057A76BDD75E84FA12D054")
    
@Override
    public boolean ready() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            return true;
        }
    }

    /**
     * Resets this reader's position to the last {@code mark()} location.
     * Invocations of {@code read()} and {@code skip()} will occur from this new
     * location. If this reader has not been marked, it is reset to the
     * beginning of the source string.
     *
     * @throws IOException
     *             if this reader is closed.
     * @see #mark(int)
     * @see #markSupported()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.787 -0500", hash_original_method = "038BDF0065CA5B8ADE3B96C7C6A96C49", hash_generated_method = "41EADE0FC52598FB47990BB2C6983730")
    
@Override
    public void reset() throws IOException {
        synchronized (lock) {
            checkNotClosed();
            pos = markpos != -1 ? markpos : 0;
        }
    }

    /**
     * Moves {@code charCount} characters in the source string. Unlike the {@link
     * Reader#skip(long) overridden method}, this method may skip negative skip
     * distances: this rewinds the input so that characters may be read again.
     * When the end of the source string has been reached, the input cannot be
     * rewound.
     *
     * @param charCount
     *            the maximum number of characters to skip. Positive values skip
     *            forward; negative values skip backward.
     * @return the number of characters actually skipped. This is bounded below
     *            by the number of characters already read and above by the
     *            number of characters remaining:<br> {@code -(num chars already
     *            read) <= distance skipped <= num chars remaining}.
     * @throws IOException
     *             if this reader is closed.
     * @see #mark(int)
     * @see #markSupported()
     * @see #reset()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.791 -0500", hash_original_method = "62CF7546C0F2369A3238D86713E4D3AD", hash_generated_method = "AEDA2BADC8C7353D3C34B57D9C758E02")
    
@Override
    public long skip(long charCount) throws IOException {
        synchronized (lock) {
            checkNotClosed();

            int minSkip = -pos;
            int maxSkip = count - pos;

            if (maxSkip == 0 || charCount > maxSkip) {
                charCount = maxSkip; // no rewinding if we're at the end
            } else if (charCount < minSkip) {
                charCount = minSkip;
            }

            pos += charCount;
            return charCount;
        }
    }
    
}

