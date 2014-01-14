package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;

public class StringWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.088 -0500", hash_original_field = "AE723DBE63A0A007DD0888E4AE2CF636", hash_generated_field = "EB9E5A2DAF0C9C70707F8B833E05E535")

    private StringBuffer buf;

    /**
     * Constructs a new {@code StringWriter} which has a {@link StringBuffer}
     * allocated with the default size of 16 characters. The {@code
     * StringBuffer} is also the {@code lock} used to synchronize access to this
     * writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.091 -0500", hash_original_method = "70E0091DAD5CA0CE69DCEADFA1D1533C", hash_generated_method = "7E2C64E64DC268AFCDD2C66951952544")
    
public StringWriter() {
        buf = new StringBuffer(16);
        lock = buf;
    }

    /**
     * Constructs a new {@code StringWriter} which has a {@link StringBuffer}
     * allocated with a size of {@code initialSize} characters. The {@code
     * StringBuffer} is also the {@code lock} used to synchronize access to this
     * writer.
     *
     * @param initialSize
     *            the intial size of the target string buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.094 -0500", hash_original_method = "9AACBAF662EC7E043DE68391EFC0EC82", hash_generated_method = "C2FFDDB811278DE495C1C31F5BEAB90C")
    
public StringWriter(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException();
        }
        buf = new StringBuffer(initialSize);
        lock = buf;
    }

    /**
     * Calling this method has no effect. In contrast to most {@code Writer} subclasses,
     * the other methods in {@code StringWriter} do not throw an {@code IOException} if
     * {@code close()} has been called.
     *
     * @throws IOException
     *             if an error occurs while closing this writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.096 -0500", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "18141BA36FD6959CD13F78BAD6F7E786")
    
@Override
    public void close() throws IOException {
        /* empty */
    }

    /**
     * Calling this method has no effect.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.098 -0500", hash_original_method = "336EB9AA03C5B902D3CE726BD69F433F", hash_generated_method = "0687F2D6ADC2467547D72E32B4897227")
    
@Override
    public void flush() {
        /* empty */
    }

    /**
     * Gets a reference to this writer's internal {@link StringBuffer}. Any
     * changes made to the returned buffer are reflected in this writer.
     *
     * @return a reference to this writer's internal {@code StringBuffer}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.101 -0500", hash_original_method = "A7A377F1952FAEFB7BC2FB8A1C51454F", hash_generated_method = "9DACA42F3BBA428D705F71B19D733A93")
    
public StringBuffer getBuffer() {
        return buf;
    }

    /**
     * Gets a copy of the contents of this writer as a string.
     *
     * @return this writer's contents as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.104 -0500", hash_original_method = "B210C316A5935A34586C62D959011891", hash_generated_method = "1774137BABF77D6332E3E77ADE4EE85A")
    
@Override
    public String toString() {
        return buf.toString();
    }

    /**
     * Writes {@code count} characters starting at {@code offset} in {@code buf}
     * to this writer's {@code StringBuffer}.
     *
     * @param chars
     *            the non-null character array to write.
     * @param offset
     *            the index of the first character in {@code chars} to write.
     * @param count
     *            the maximum number of characters to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the size of {@code buf}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.106 -0500", hash_original_method = "B574F1A893A28468E9B79E59C4419CC6", hash_generated_method = "9CDF0FF8BCA96E90FC2C10775DCA5372")
    
@Override
    public void write(char[] chars, int offset, int count) {
        Arrays.checkOffsetAndCount(chars.length, offset, count);
        if (count == 0) {
            return;
        }
        buf.append(chars, offset, count);
    }

    /**
     * Writes one character to this writer's {@code StringBuffer}. Only the two
     * least significant bytes of the integer {@code oneChar} are written.
     *
     * @param oneChar
     *            the character to write to this writer's {@code StringBuffer}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.109 -0500", hash_original_method = "9E74599A1E38039394CB519CF0982BB0", hash_generated_method = "C5C3795F9028875601BFA514394360DA")
    
@Override
    public void write(int oneChar) {
        buf.append((char) oneChar);
    }

    /**
     * Writes the characters from the specified string to this writer's {@code
     * StringBuffer}.
     *
     * @param str
     *            the non-null string containing the characters to write.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.111 -0500", hash_original_method = "C709310F14478B827E3F0AC974DDA1E9", hash_generated_method = "B9E6C838B077F39FFE8F290B8FE54952")
    
@Override
    public void write(String str) {
        buf.append(str);
    }

    /**
     * Writes {@code count} characters from {@code str} starting at {@code
     * offset} to this writer's {@code StringBuffer}.
     *
     * @param str
     *            the non-null string containing the characters to write.
     * @param offset
     *            the index of the first character in {@code str} to write.
     * @param count
     *            the number of characters from {@code str} to write.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the length of {@code str}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.114 -0500", hash_original_method = "944E85902A11A60E741C7A4261619164", hash_generated_method = "A8BBB0A5273822517081196A431752C3")
    
@Override
    public void write(String str, int offset, int count) {
        String sub = str.substring(offset, offset + count);
        buf.append(sub);
    }

    /**
     * Appends the character {@code c} to this writer's {@code StringBuffer}.
     * This method works the same way as {@link #write(int)}.
     *
     * @param c
     *            the character to append to the target stream.
     * @return this writer.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.116 -0500", hash_original_method = "15F384D8A1FFEEB0786C49990EC18DEC", hash_generated_method = "245948B56E5876E69D845B1347DB8EB8")
    
@Override
    public StringWriter append(char c) {
        write(c);
        return this;
    }

    /**
     * Appends the character sequence {@code csq} to this writer's {@code
     * StringBuffer}. This method works the same way as {@code
     * StringWriter.write(csq.toString())}. If {@code csq} is {@code null}, then
     * the string "null" is written to the target stream.
     *
     * @param csq
     *            the character sequence appended to the target.
     * @return this writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.119 -0500", hash_original_method = "4F8B551F847F79C820191D7A1919C8D2", hash_generated_method = "B284D98AD1C78CD17BCF774DB4E26F37")
    
@Override
    public StringWriter append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        write(csq.toString());
        return this;
    }

    /**
     * Appends a subsequence of the character sequence {@code csq} to this
     * writer's {@code StringBuffer}. This method works the same way as {@code
     * StringWriter.writer(csq.subsequence(start, end).toString())}. If {@code
     * csq} is {@code null}, then the specified subsequence of the string "null"
     * will be written to the target.
     *
     * @param csq
     *            the character sequence appended to the target.
     * @param start
     *            the index of the first char in the character sequence appended
     *            to the target.
     * @param end
     *            the index of the character following the last character of the
     *            subsequence appended to the target.
     * @return this writer.
     * @throws IndexOutOfBoundsException
     *             if {@code start > end}, {@code start < 0}, {@code end < 0} or
     *             either {@code start} or {@code end} are greater or equal than
     *             the length of {@code csq}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:49.121 -0500", hash_original_method = "D18F40A53A7260972FC6506FD741C13E", hash_generated_method = "A23470303E65CCE10FA1B68E37099E96")
    
@Override
    public StringWriter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        return this;
    }
    
}

