package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;






public class CharArrayWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.947 -0500", hash_original_field = "40514AFF00B14ABD40D54C723F22A0B4", hash_generated_field = "F3184E7FC423A3DB65CA949884DB59BD")

    protected char[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.950 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;

    /**
     * Constructs a new {@code CharArrayWriter} which has a buffer allocated
     * with the default size of 32 characters. This buffer is also used as the
     * {@code lock} to synchronize access to this writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.952 -0500", hash_original_method = "C9452FB9491532C2A6C52BB5B3D25E39", hash_generated_method = "AC61405EE6F47B88139B96681DCA2767")
    
public CharArrayWriter() {
        buf = new char[32];
        lock = buf;
    }

    /**
     * Constructs a new {@code CharArrayWriter} which has a buffer allocated
     * with the size of {@code initialSize} characters. The buffer is also used
     * as the {@code lock} to synchronize access to this writer.
     *
     * @param initialSize
     *            the initial size of this CharArrayWriters buffer.
     * @throws IllegalArgumentException
     *             if {@code initialSize < 0}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.956 -0500", hash_original_method = "71C0EC52128D22FED2D8659A81B00E37", hash_generated_method = "8B3FDA113EAC363886398798A426D69C")
    
public CharArrayWriter(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("size < 0");
        }
        buf = new char[initialSize];
        lock = buf;
    }

    /**
     * Closes this writer. The implementation in {@code CharArrayWriter} does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.958 -0500", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "4C888A472B6C97DE4C7EB736D1B2C05B")
    
@Override
    public void close() {
        /* empty */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.961 -0500", hash_original_method = "74E26FDF253668E5689F73596E4C1217", hash_generated_method = "F9CAD98CB28716B01793247C42A0E08E")
    
private void expand(int i) {
        /* Can the buffer handle @i more chars, if not expand it */
        if (count + i <= buf.length) {
            return;
        }

        int newLen = Math.max(2 * buf.length, count + i);
        char[] newbuf = new char[newLen];
        System.arraycopy(buf, 0, newbuf, 0, count);
        buf = newbuf;
    }

    /**
     * Flushes this writer. The implementation in {@code CharArrayWriter} does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.963 -0500", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "0687F2D6ADC2467547D72E32B4897227")
    
@Override
    public void flush() {
        /* empty */
    }

    /**
     * Resets this writer. The current write position is reset to the beginning
     * of the buffer. All written characters are lost and the size of this
     * writer is set to 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.966 -0500", hash_original_method = "41854ED78018FCB86E06DA2ADE584B53", hash_generated_method = "05174864F600E13245A5A7EDE7280700")
    
public void reset() {
        synchronized (lock) {
            count = 0;
        }
    }

    /**
     * Returns the size of this writer, that is the number of characters it
     * stores. This number changes if this writer is reset or when more
     * characters are written to it.
     *
     * @return this CharArrayWriter's current size in characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.968 -0500", hash_original_method = "796F2451CF9DC3EF411446EADA3F03C7", hash_generated_method = "84A93E38E91160823E4F8547DE56768C")
    
public int size() {
        synchronized (lock) {
            return count;
        }
    }

    /**
     * Returns the contents of the receiver as a char array. The array returned
     * is a copy and any modifications made to this writer after calling this
     * method are not reflected in the result.
     *
     * @return this CharArrayWriter's contents as a new char array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.970 -0500", hash_original_method = "A3DCAA229974F9979554B7E0F1F4EF9F", hash_generated_method = "BD6D76D575FBB2C104F30D78DCB06376")
    
public char[] toCharArray() {
        synchronized (lock) {
            char[] result = new char[count];
            System.arraycopy(buf, 0, result, 0, count);
            return result;
        }
    }

    /**
     * Returns the contents of this {@code CharArrayWriter} as a string. The
     * string returned is a copy and any modifications made to this writer after
     * calling this method are not reflected in the result.
     *
     * @return this CharArrayWriters contents as a new string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.973 -0500", hash_original_method = "F9B2EF7C65F2F351A8955F413D7A1883", hash_generated_method = "5CF6BB0100429CC0A5A9B43FB635DFAF")
    
@Override
    public String toString() {
        synchronized (lock) {
            return new String(buf, 0, count);
        }
    }

    /**
     * Writes {@code count} characters starting at {@code offset} in {@code c}
     * to this writer.
     *
     * @param buffer
     *            the non-null array containing characters to write.
     * @param offset
     *            the index of the first character in {@code buf} to write.
     * @param len
     *            maximum number of characters to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code len < 0}, or if
     *             {@code offset + len} is bigger than the size of {@code c}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.975 -0500", hash_original_method = "17F94D6158075BE971F02096E85AEF33", hash_generated_method = "D05819EC49701A68141E334F53010F6E")
    
@Override
    public void write(char[] buffer, int offset, int len) {
        Arrays.checkOffsetAndCount(buffer.length, offset, len);
        synchronized (lock) {
            expand(len);
            System.arraycopy(buffer, offset, this.buf, this.count, len);
            this.count += len;
        }
    }

    /**
     * Writes the specified character {@code oneChar} to this writer.
     * This implementation writes the two low order bytes of the integer
     * {@code oneChar} to the buffer.
     *
     * @param oneChar
     *            the character to write.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.978 -0500", hash_original_method = "F6D5648087F216C6BFDCFB078373F01B", hash_generated_method = "BEB90F0F1A4B1BFB1C416DEF88CD5B71")
    
@Override
    public void write(int oneChar) {
        synchronized (lock) {
            expand(1);
            buf[count++] = (char) oneChar;
        }
    }

    /**
     * Writes {@code count} characters starting at {@code offset} from
     * the string {@code str} to this CharArrayWriter.
     *
     * @throws NullPointerException
     *             if {@code str} is {@code null}.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is bigger than the length of
     *             {@code str}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.981 -0500", hash_original_method = "9F8082FBB1391041DAA8F1A348E27C2A", hash_generated_method = "76C128EDB2BECC536B898FE91B833CDA")
    
@Override
    public void write(String str, int offset, int count) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        if ((offset | count) < 0 || offset > str.length() - count) {
            throw new StringIndexOutOfBoundsException(str, offset, count);
        }
        synchronized (lock) {
            expand(count);
            str.getChars(offset, offset + count, buf, this.count);
            this.count += count;
        }
    }

    /**
     * Writes the contents of this {@code CharArrayWriter} to another {@code
     * Writer}. The output is all the characters that have been written to the
     * receiver since the last reset or since it was created.
     *
     * @param out
     *            the non-null {@code Writer} on which to write the contents.
     * @throws NullPointerException
     *             if {@code out} is {@code null}.
     * @throws IOException
     *             if an error occurs attempting to write out the contents.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.984 -0500", hash_original_method = "C2C534AA9A22A4D0AC70B4A5DCDA6B73", hash_generated_method = "C2F103D95D0F750FD4DD08ABFD623CD3")
    
public void writeTo(Writer out) throws IOException {
        synchronized (lock) {
            out.write(buf, 0, count);
        }
    }

    /**
     * Appends a char {@code c} to the {@code CharArrayWriter}. The method works
     * the same way as {@code write(c)}.
     *
     * @param c
     *            the character appended to the CharArrayWriter.
     * @return this CharArrayWriter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.986 -0500", hash_original_method = "98F1E9A8C1E20678242580E2421D983C", hash_generated_method = "DBB08E576F65CCCD5C3E9BE56838F079")
    
@Override
    public CharArrayWriter append(char c) {
        write(c);
        return this;
    }

    /**
     * Appends a {@code CharSequence} to the {@code CharArrayWriter}. The method
     * works the same way as {@code write(csq.toString())}. If {@code csq} is
     * {@code null}, then it will be substituted with the string {@code "null"}.
     *
     * @param csq
     *            the {@code CharSequence} appended to the {@code
     *            CharArrayWriter}, may be {@code null}.
     * @return this CharArrayWriter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.988 -0500", hash_original_method = "B584B42D7A9874698AA3457A3A1D3154", hash_generated_method = "B0D9F55CEB5EB64DE6B6451E971F9863")
    
@Override
    public CharArrayWriter append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        append(csq, 0, csq.length());
        return this;
    }

    /**
     * Append a subsequence of a {@code CharSequence} to the {@code
     * CharArrayWriter}. The first and last characters of the subsequence are
     * specified by the parameters {@code start} and {@code end}. A call to
     * {@code CharArrayWriter.append(csq)} works the same way as {@code
     * CharArrayWriter.write(csq.subSequence(start, end).toString)}. If {@code
     * csq} is {@code null}, then it will be substituted with the string {@code
     * "null"}.
     *
     * @param csq
     *            the {@code CharSequence} appended to the {@code
     *            CharArrayWriter}, may be {@code null}.
     * @param start
     *            the index of the first character in the {@code CharSequence}
     *            appended to the {@code CharArrayWriter}.
     * @param end
     *            the index of the character after the last one in the {@code
     *            CharSequence} appended to the {@code CharArrayWriter}.
     * @return this CharArrayWriter.
     * @throws IndexOutOfBoundsException
     *             if {@code start < 0}, {@code end < 0}, {@code start > end},
     *             or if {@code end} is greater than the length of {@code csq}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.991 -0500", hash_original_method = "A1054C6BA24908274B5EEDCC4DAC29F7", hash_generated_method = "E128318E3EFD4C4F858E05627685254F")
    
@Override
    public CharArrayWriter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        return this;
    }

    
}

