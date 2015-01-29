package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class Writer implements Appendable, Closeable, Flushable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.977 -0500", hash_original_field = "5E7C45D6B25B1E31F92C48548080E9E3", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;

    /**
     * Constructs a new {@code Writer} with {@code this} as the object used to
     * synchronize critical sections.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.980 -0500", hash_original_method = "673B7AADE5290DAEA83488F65491132B", hash_generated_method = "A127FC3D7486266B886A0A3E8AB5F70C")
    
protected Writer() {
        lock = this;
    }

    /**
     * Constructs a new {@code Writer} with {@code lock} used to synchronize
     * critical sections.
     *
     * @param lock
     *            the {@code Object} used to synchronize critical sections.
     * @throws NullPointerException
     *             if {@code lock} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.983 -0500", hash_original_method = "D96C97132BD2547E52536C41B19A9E8C", hash_generated_method = "3FC050CD4B4869AC2C3CEE0B92F4DF88")
    
protected Writer(Object lock) {
        if (lock == null) {
            throw new NullPointerException();
        }
        this.lock = lock;
    }

    /**
     * Closes this writer. Implementations of this method should free any
     * resources associated with the writer.
     *
     * @throws IOException
     *             if an error occurs while closing this writer.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.985 -0500", hash_original_method = "4E507319564A7E0BFD2A58D57A800811", hash_generated_method = "2228FF14FE1AFC53EB7399AA035D1509")
    
public abstract void close() throws IOException;

    /**
     * Flushes this writer. Implementations of this method should ensure that
     * all buffered characters are written to the target.
     *
     * @throws IOException
     *             if an error occurs while flushing this writer.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.988 -0500", hash_original_method = "19CA02765A6BC90E1BC39264DF2DA8FE", hash_generated_method = "39634ABBFA297A919A191B73454200E1")
    
public abstract void flush() throws IOException;

    /**
     * Writes the entire character buffer {@code buf} to the target.
     *
     * @param buf
     *            the non-null array containing characters to write.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.991 -0500", hash_original_method = "3613EF644BBA13BB917F4671227467C0", hash_generated_method = "2208C03B9A25BFF9A5B9BAA905622943")
    
public void write(char[] buf) throws IOException {
        write(buf, 0, buf.length);
    }

    /**
     * Writes {@code count} characters starting at {@code offset} in {@code buf}
     * to the target.
     *
     * @param buf
     *            the non-null character array to write.
     * @param offset
     *            the index of the first character in {@code buf} to write.
     * @param count
     *            the maximum number of characters to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the size of {@code buf}.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.993 -0500", hash_original_method = "FA39B0B4ACD833F007B6A5EFA706DF90", hash_generated_method = "1F14AD35BDAC531FAF76D6C9A1E9B3E0")
    
public abstract void write(char[] buf, int offset, int count) throws IOException;

    /**
     * Writes one character to the target. Only the two least significant bytes
     * of the integer {@code oneChar} are written.
     *
     * @param oneChar
     *            the character to write to the target.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.996 -0500", hash_original_method = "8F6AF6BA5D86D88C527DBF804753FF5E", hash_generated_method = "C859C0025341C99F461E09BD67095F70")
    
public void write(int oneChar) throws IOException {
        synchronized (lock) {
            char[] oneCharArray = new char[1];
            oneCharArray[0] = (char) oneChar;
            write(oneCharArray);
        }
    }

    /**
     * Writes the characters from the specified string to the target.
     *
     * @param str
     *            the non-null string containing the characters to write.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO}) 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.998 -0500", hash_original_method = "2CB0ACB6DB74A20D3FAA9874B0AAEB97", hash_generated_method = "56B10BCA62907989A5623B6EAB45E393")
    
public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /**
     * Writes {@code count} characters from {@code str} starting at {@code
     * offset} to the target.
     *
     * @param str
     *            the non-null string containing the characters to write.
     * @param offset
     *            the index of the first character in {@code str} to write.
     * @param count
     *            the number of characters from {@code str} to write.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the length of {@code str}.
     */
    
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.000 -0500", hash_original_method = "2D3658401DD29E26DBD40724F9EE6A10", hash_generated_method = "2978E341BDA8E299BF1EDFE8C666FC03")
    
public void write(String str, int offset, int count) throws IOException {
        if ((offset | count) < 0 || offset > str.length() - count) {
            throw new StringIndexOutOfBoundsException(str, offset, count);
        }
        char[] buf = new char[count];
        str.getChars(offset, offset + count, buf, 0);
        synchronized (lock) {
            write(buf, 0, buf.length);
        }
    }

    /**
     * Appends the character {@code c} to the target. This method works the same
     * way as {@link #write(int)}.
     *
     * @param c
     *            the character to append to the target stream.
     * @return this writer.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.003 -0500", hash_original_method = "9D99658000F160BDAECAED91EC9BFB5D", hash_generated_method = "022A80F08D04342A5DF811349E2DCDBA")
    
public Writer append(char c) throws IOException {
        write(c);
        return this;
    }

    /**
     * Appends the character sequence {@code csq} to the target. This method
     * works the same way as {@code Writer.write(csq.toString())}. If {@code
     * csq} is {@code null}, then the string "null" is written to the target
     * stream.
     *
     * @param csq
     *            the character sequence appended to the target.
     * @return this writer.
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     */
    
    @DSSink({DSSinkKind.IO})
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.006 -0500", hash_original_method = "D993D81DE6953743EFA25FF281FB0E15", hash_generated_method = "67EEA4752C6409E1426DEAE33FD9BE03")
    
public Writer append(CharSequence csq) throws IOException {
        if (csq == null) {
            csq = "null";
        }
        write(csq.toString());
        return this;
    }

    /**
     * Appends a subsequence of the character sequence {@code csq} to the
     * target. This method works the same way as {@code
     * Writer.writer(csq.subsequence(start, end).toString())}. If {@code
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
     * @throws IOException
     *             if this writer is closed or another I/O error occurs.
     * @throws IndexOutOfBoundsException
     *             if {@code start > end}, {@code start < 0}, {@code end < 0} or
     *             either {@code start} or {@code end} are greater or equal than
     *             the length of {@code csq}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.008 -0500", hash_original_method = "44B7413EC481F793F1919C886AE2AD0E", hash_generated_method = "A43CF055AB530ECD1E514ED408FF5339")
    
public Writer append(CharSequence csq, int start, int end) throws IOException {
        if (csq == null) {
            csq = "null";
        }
        write(csq.subSequence(start, end).toString());
        return this;
    }

    /**
     * Returns true if this writer has encountered and suppressed an error. Used
     * by PrintWriters as an alternative to checked exceptions.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.010 -0500", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8")
    
boolean checkError() {
        return false;
    }
    
}

