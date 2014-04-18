package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Formatter;
import java.util.Locale;

public class PrintWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.496 -0500", hash_original_field = "EBCE22DD0E30FF0E4040ABB2E7F29C97", hash_generated_field = "8FF81F1EABE94AA2FE1148793CBBDC2D")

    protected Writer out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.499 -0500", hash_original_field = "B8E55DCF378C62700C874FE9D168DA3C", hash_generated_field = "C89C47EA16E34DEBAC0E78BF779BC70F")

    private boolean ioError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.501 -0500", hash_original_field = "E18E64283FE6FFBC087BABE45EE375FC", hash_generated_field = "C3BCA0E638347F15CBD7648899C5AE35")

    private boolean autoFlush;

    /**
     * Constructs a new {@code PrintWriter} with {@code out} as its target
     * stream. By default, the new print writer does not automatically flush its
     * contents to the target stream when a newline is encountered.
     *
     * @param out
     *            the target output stream.
     * @throws NullPointerException
     *             if {@code out} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.504 -0500", hash_original_method = "009ECF78166A7569006BEB577877B2F6", hash_generated_method = "016F1B5DF0E9611CE429BA74AC14E049")
    
public PrintWriter(OutputStream out) {
        this(new OutputStreamWriter(out), false);
    }

    /**
     * Constructs a new {@code PrintWriter} with {@code out} as its target
     * stream. The parameter {@code autoFlush} determines if the print writer
     * automatically flushes its contents to the target stream when a newline is
     * encountered.
     *
     * @param out
     *            the target output stream.
     * @param autoFlush
     *            indicates whether contents are flushed upon encountering a
     *            newline sequence.
     * @throws NullPointerException
     *             if {@code out} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.507 -0500", hash_original_method = "A0422DBDFA7D458C1211AD61A93CCD24", hash_generated_method = "E02E08E658297747CB5D56D2AE60B416")
    
public PrintWriter(OutputStream out, boolean autoFlush) {
        this(new OutputStreamWriter(out), autoFlush);
    }

    /**
     * Constructs a new {@code PrintWriter} with {@code wr} as its target
     * writer. By default, the new print writer does not automatically flush its
     * contents to the target writer when a newline is encountered.
     *
     * @param wr
     *            the target writer.
     * @throws NullPointerException
     *             if {@code wr} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.510 -0500", hash_original_method = "7F68156580476879DAEA9DC9BCB75B06", hash_generated_method = "7254B85D902F7A0D22543F60341BFF81")
    
public PrintWriter(Writer wr) {
        this(wr, false);
    }

    /**
     * Constructs a new {@code PrintWriter} with {@code out} as its target
     * writer. The parameter {@code autoFlush} determines if the print writer
     * automatically flushes its contents to the target writer when a newline is
     * encountered.
     *
     * @param wr
     *            the target writer.
     * @param autoFlush
     *            indicates whether to flush contents upon encountering a
     *            newline sequence.
     * @throws NullPointerException
     *             if {@code out} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.513 -0500", hash_original_method = "C1927249B88242DCE6CFA0FA4F3C29B3", hash_generated_method = "24E2FCE2F914460E15A5623901838257")
    
public PrintWriter(Writer wr, boolean autoFlush) {
        super(wr);
        this.autoFlush = autoFlush;
        out = wr;
    }

    /**
     * Constructs a new {@code PrintWriter} with {@code file} as its target. The
     * VM's default character set is used for character encoding.
     * The print writer does not automatically flush its contents to the target
     * file when a newline is encountered. The output to the file is buffered.
     *
     * @param file
     *            the target file. If the file already exists, its contents are
     *            removed, otherwise a new file is created.
     * @throws FileNotFoundException
     *             if an error occurs while opening or creating the target file.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.515 -0500", hash_original_method = "2C96C347B82CB5135A3ACEC685E09DC1", hash_generated_method = "5E7BD4D2062E5956DF9D0017BCA53370")
    
public PrintWriter(File file) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file))), false);
    }

    /**
     * Constructs a new {@code PrintWriter} with {@code file} as its target. The
     * character set named {@code csn} is used for character encoding.
     * The print writer does not automatically flush its contents to the target
     * file when a newline is encountered. The output to the file is buffered.
     *
     * @param file
     *            the target file. If the file already exists, its contents are
     *            removed, otherwise a new file is created.
     * @param csn
     *            the name of the character set used for character encoding.
     * @throws FileNotFoundException
     *             if an error occurs while opening or creating the target file.
     * @throws NullPointerException
     *             if {@code csn} is {@code null}.
     * @throws UnsupportedEncodingException
     *             if the encoding specified by {@code csn} is not supported.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.518 -0500", hash_original_method = "B162E67684B075ABE078C3780599A018", hash_generated_method = "9A72481833823E60E6BF5B75933FFA90")
    
public PrintWriter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)), csn),
                false);
    }

    /**
     * Constructs a new {@code PrintWriter} with the file identified by {@code
     * fileName} as its target. The VM's default character set is
     * used for character encoding. The print writer does not automatically
     * flush its contents to the target file when a newline is encountered. The
     * output to the file is buffered.
     *
     * @param fileName
     *            the target file's name. If the file already exists, its
     *            contents are removed, otherwise a new file is created.
     * @throws FileNotFoundException
     *             if an error occurs while opening or creating the target file.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.521 -0500", hash_original_method = "BB4A7F43BD82DE5EABC7964AA01AA735", hash_generated_method = "B1DEA64D4F44773B2D075032C17409F7")
    
public PrintWriter(String fileName) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName))),
                false);
    }

     /**
     * Constructs a new {@code PrintWriter} with the file identified by {@code
     * fileName} as its target. The character set named {@code csn} is used for
     * character encoding. The print writer does not automatically flush its
     * contents to the target file when a newline is encountered. The output to
     * the file is buffered.
     *
     * @param fileName
     *            the target file's name. If the file already exists, its
     *            contents are removed, otherwise a new file is created.
     * @param csn
     *            the name of the character set used for character encoding.
     * @throws FileNotFoundException
     *             if an error occurs while opening or creating the target file.
     * @throws NullPointerException
     *             if {@code csn} is {@code null}.
     * @throws UnsupportedEncodingException
     *             if the encoding specified by {@code csn} is not supported.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.524 -0500", hash_original_method = "75ACA8D301D7B4385F5F1D6D811FAD95", hash_generated_method = "299D4174F3DFC34A1C29CA836AC50A4D")
    
public PrintWriter(String fileName, String csn)
            throws FileNotFoundException, UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName)), csn),
                false);
    }

    /**
     * Flushes this writer and returns the value of the error flag.
     *
     * @return {@code true} if either an {@code IOException} has been thrown
     *         previously or if {@code setError()} has been called;
     *         {@code false} otherwise.
     * @see #setError()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.527 -0500", hash_original_method = "0D2606A00F6397A8DDF12D981BAB88CA", hash_generated_method = "7EC1ADE4A5EF65AE6B08A626DAB7189B")
    
public boolean checkError() {
        Writer delegate = out;
        if (delegate == null) {
            return ioError;
        }

        flush();
        return ioError || delegate.checkError();
    }

    /**
     * Sets the error state of the stream to false.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.529 -0500", hash_original_method = "9EE080B9329CC6FAACC493ECC7141CFB", hash_generated_method = "9831B42DF1CE5AD51AC68D738DCBFA72")
    
protected void clearError() {
        synchronized (lock) {
            ioError = false;
        }
    }

    /**
     * Closes this print writer. Flushes this writer and then closes the target.
     * If an I/O error occurs, this writer's error flag is set to {@code true}.
     */
    @DSComment("PrintWriter class")
    @DSSafe(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.532 -0500", hash_original_method = "914ABB48E88E0FB5E2AF825917F549B2", hash_generated_method = "0DD80271147924135BA0F03FF3D404CE")
    
@Override
    public void close() {
        /*
        synchronized (lock) {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    setError();
                }
                out = null;
            }
        }
        */
    }

    /**
     * Ensures that all pending data is sent out to the target. It also
     * flushes the target. If an I/O error occurs, this writer's error
     * state is set to {@code true}.
     */
    @DSComment("PrintWriter class")
    @DSSafe(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.534 -0500", hash_original_method = "3747E1B1C7FB1936BAC6943C89A67163", hash_generated_method = "6555AC8DF092B1F6499D2697C5833C35")
    
@Override
    public void flush() {
        /*
        synchronized (lock) {
            if (out != null) {
                try {
                    out.flush();
                } catch (IOException e) {
                    setError();
                }
            } else {
                setError();
            }
        }
        */
    }

    /**
     * Formats {@code args} according to the format string {@code format}, and writes the result
     * to this stream. This method uses the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     * If automatic flushing is enabled then the buffer is flushed as well.
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this writer.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.536 -0500", hash_original_method = "68BF859C2EE72E22FD2B6E3C884D672F", hash_generated_method = "C83B536B3B84E2F36ACC0E6CD007F14D")
    
public PrintWriter format(String format, Object... args) {
        addTaint(format.getTaint());
        for (Object arg: args){
            addTaint(arg.getTaint());
        }
        return this;
        //return format(Locale.getDefault(), format, args);
    }

    /**
     * Writes a string formatted by an intermediate {@code Formatter} to the
     * target using the specified locale, format string and arguments. If
     * automatic flushing is enabled then this writer is flushed.
     *
     * @param l
     *            the locale used in the method. No localization will be applied
     *            if {@code l} is {@code null}.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this writer.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.539 -0500", hash_original_method = "D5634586266B3A8B702A8EF418739481", hash_generated_method = "B62E20BF8D5E687EAB63A992A8B8C0BB")
    
public PrintWriter format(Locale l, String format, Object... args) {
        if (format == null) {
            throw new NullPointerException("format == null");
        }
        new Formatter(this, l).format(format, args);
        if (autoFlush) {
            flush();
        }
        return this;
    }

    /**
     * Prints a formatted string. The behavior of this method is the same as
     * this writer's {@code #format(String, Object...)} method.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this writer.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.541 -0500", hash_original_method = "D4B734B1529E4ABCC31A727EC1C73F87", hash_generated_method = "81B4F8B8310B30E35E449EF24058566B")
    
public PrintWriter printf(String format, Object... args) {
        return format(format, args);
    }

    /**
     * Prints a formatted string. The behavior of this method is the same as
     * this writer's {@code #format(Locale, String, Object...)} method.
     *
     * @param l
     *            the locale used in the method. No localization will be applied
     *            if {@code l} is {@code null}.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this writer.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.543 -0500", hash_original_method = "31E00ED7FA07EDC8A599E35C64000277", hash_generated_method = "382C78792335BD37C0C9AF345A4DDC94")
    
public PrintWriter printf(Locale l, String format, Object... args) {
        return format(l, format, args);
    }

    /**
     * Prints the string representation of the specified character array
     * to the target.
     *
     * @param charArray
     *            the character array to print to the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.546 -0500", hash_original_method = "9BEBBB6A7E36A898084CFD13E6678C15", hash_generated_method = "D33A34F7753A9832F3E175389FBAA7AF")
    
public void print(char[] charArray) {
        print(new String(charArray, 0, charArray.length));
    }

    /**
     * Prints the string representation of the specified character to the
     * target.
     *
     * @param ch
     *            the character to print to the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.549 -0500", hash_original_method = "F35E4DD8AE097731F5674B94681A91A4", hash_generated_method = "190691A934291496E1915F4AC2ED5E60")
    
public void print(char ch) {
        print(String.valueOf(ch));
    }

    /**
     * Prints the string representation of the specified double to the target.
     *
     * @param dnum
     *            the double value to print to the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.551 -0500", hash_original_method = "1B10CD3CDAEEB6B80C16851B9025C53B", hash_generated_method = "06DB7B3814A8BF1C5F5E3702E706FE88")
    
public void print(double dnum) {
        print(String.valueOf(dnum));
    }

    /**
     * Prints the string representation of the specified float to the target.
     *
     * @param fnum
     *            the float value to print to the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.553 -0500", hash_original_method = "1CE43F20E63C9B7E63DE59186E96F9C3", hash_generated_method = "3190AE531435AD6F4E7B61C43FE32679")
    
public void print(float fnum) {
        print(String.valueOf(fnum));
    }

    /**
     * Prints the string representation of the specified integer to the target.
     *
     * @param inum
     *            the integer value to print to the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.556 -0500", hash_original_method = "7E641CDBDB4194A4ABD6D1C9C473BCDE", hash_generated_method = "926C6B4F4B203D16211A7DFF9C2165F3")
    
public void print(int inum) {
        print(String.valueOf(inum));
    }

    /**
     * Prints the string representation of the specified long to the target.
     *
     * @param lnum
     *            the long value to print to the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.558 -0500", hash_original_method = "A3B835CD89D15A13CD365E547F38E002", hash_generated_method = "1C0143F5B519E6A20A126F40B2CE8261")
    
public void print(long lnum) {
        print(String.valueOf(lnum));
    }

    /**
     * Prints the string representation of the specified object to the target.
     *
     * @param obj
     *            the object to print to the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.560 -0500", hash_original_method = "649E6082D773CF70C752E5716C5CC7C1", hash_generated_method = "EAB1D91353181ABAEA72D7E1487AC34B")
    
public void print(Object obj) {
        //print(String.valueOf(obj));
        addTaint(obj.getTaint());
    }

    /**
     * Prints a string to the target. The string is converted to an array of
     * bytes using the encoding chosen during the construction of this writer.
     * The bytes are then written to the target with {@code write(int)}.
     * <p>
     * If an I/O error occurs, this writer's error flag is set to {@code true}.
     *
     * @param str
     *            the string to print to the target.
     * @see #write(int)
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.563 -0500", hash_original_method = "28AE2923CB2E212C4A1D24DC5B3A947D", hash_generated_method = "36277E61AA4A266FE3AE5B9152D6A6DD")
    
public void print(String str) {
        write(str != null ? str : String.valueOf((Object) null));
    }

    /**
     * Prints the string representation of the specified boolean to the target.
     *
     * @param bool
     *            the boolean value to print the target.
     * @see #print(String)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.565 -0500", hash_original_method = "55BF6AEFB35D15A1E34ADB671F9CB185", hash_generated_method = "7C2EDF016FE2419B26B3D48D16F69833")
    
public void print(boolean bool) {
        print(String.valueOf(bool));
    }

    /**
     * Prints a newline. Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.568 -0500", hash_original_method = "F64EE4A89E44550272E2ED021897135C", hash_generated_method = "7F9921E118814F069608AD604993C5DF")
    
public void println() {
        /*
        synchronized (lock) {
            print(System.lineSeparator());
            if (autoFlush) {
                flush();
            }
        }
        */
    }

    /**
     * Prints the string representation of the character array {@code chars} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.570 -0500", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "401BCD9244EE35B0A776F2A2CEDD37CF")
    
public void println(char[] chars) {
        println(new String(chars, 0, chars.length));
    }

    /**
     * Prints the string representation of the char {@code c} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.573 -0500", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "82BB46696338001ACA80E01920212F73")
    
public void println(char c) {
        println(String.valueOf(c));
    }

    /**
     * Prints the string representation of the double {@code d} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.576 -0500", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "84BC8C6D54950BCAF58BC3BD27296799")
    
public void println(double d) {
        println(String.valueOf(d));
    }

    /**
     * Prints the string representation of the float {@code f} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.578 -0500", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "9D7FF09A264CAD926D6BBFC063392F4E")
    
public void println(float f) {
        println(String.valueOf(f));
    }

    /**
     * Prints the string representation of the int {@code i} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.580 -0500", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "98B5DD023B996103C774771444368106")
    
public void println(int i) {
        println(String.valueOf(i));
    }

    /**
     * Prints the string representation of the long {@code l} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.582 -0500", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "82CA901E151A642E436F396BAF71A3BB")
    
public void println(long l) {
        println(String.valueOf(l));
    }

    /**
     * Prints the string representation of the object {@code o}, or {@code "null},
     * followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.584 -0500", hash_original_method = "1CC054989EBE4FE044F6C09E43625828", hash_generated_method = "0B5F9A06B0F5163B563B261D2A61BA8F")
    
public void println(Object obj) {
        println(String.valueOf(obj));
    }

    /**
     * Prints the string representation of the string {@code s} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     *
     * <p>The string is converted to an array of bytes using the
     * encoding chosen during the construction of this writer. The bytes are
     * then written to the target with {@code write(int)}. Finally, this writer
     * is flushed if the autoFlush flag is set to {@code true}.
     *
     * <p>If an I/O error occurs, this writer's error flag is set to {@code true}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.586 -0500", hash_original_method = "78EB2001D4D66C9EDDEA85708AB1EA5C", hash_generated_method = "B93838DE4CA8FEA833991BA73C84BE94")
    
public void println(String str) {
        synchronized (lock) {
            print(str);
            println();
        }
    }

    /**
     * Prints the string representation of the boolean {@code b} followed by a newline.
     * Flushes this writer if the autoFlush flag is set to {@code true}.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.589 -0500", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "D2EE9655DC271F139DF31A427D683083")
    
public void println(boolean b) {
        println(String.valueOf(b));
    }

    /**
     * Sets the error flag of this writer to true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.592 -0500", hash_original_method = "03F201CD8682A0C64485926BB6B35745", hash_generated_method = "3700635144080F2DAD1C426AA0E11A4B")
    
protected void setError() {
        synchronized (lock) {
            ioError = true;
        }
    }

    /**
     * Writes the character buffer {@code buf} to the target.
     *
     * @param buf
     *            the non-null array containing characters to write.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.594 -0500", hash_original_method = "A3159CA9C79B3AD467B0FCF29995C9CC", hash_generated_method = "332FA8CEBD234C482814A35911B9C13B")
    
@Override
    public void write(char[] buf) {
        write(buf, 0, buf.length);
    }

    /**
     * Writes {@code count} characters from {@code buffer} starting at {@code
     * offset} to the target.
     * <p>
     * This writer's error flag is set to {@code true} if this writer is closed
     * or an I/O error occurs.
     *
     * @param buf
     *            the buffer to write to the target.
     * @param offset
     *            the index of the first character in {@code buffer} to write.
     * @param count
     *            the number of characters in {@code buffer} to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the length of {@code buf}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.597 -0500", hash_original_method = "F47BE159FF15FE26B09EE65FDEAB6B8C", hash_generated_method = "1B9EBB736966FD3B4151C6D420711072")
    
@Override
    public void write(char[] buf, int offset, int count) {
        doWrite(buf, offset, count);
    }

    /**
     * Writes one character to the target. Only the two least significant bytes
     * of the integer {@code oneChar} are written.
     * <p>
     * This writer's error flag is set to {@code true} if this writer is closed
     * or an I/O error occurs.
     *
     * @param oneChar
     *            the character to write to the target.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.599 -0500", hash_original_method = "28E681395D573BD9F19024ECEBC35F4A", hash_generated_method = "F690F85F2F542ED1043C2E683ECEDCFF")
    
@Override
    public void write(int oneChar) {
        doWrite(new char[] { (char) oneChar }, 0, 1);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.602 -0500", hash_original_method = "A7437F4A37204482B8F05D868AC831D8", hash_generated_method = "45DD7E2CBEC3C1BAC560BA8D3552A6CE")
    
private final void doWrite(char[] buf, int offset, int count) {
        /*
        synchronized (lock) {
            if (out != null) {
                try {
                    out.write(buf, offset, count);
                } catch (IOException e) {
                    setError();
                }
            } else {
                setError();
            }
        }
        */
        addTaint(buf[0] + offset + count);  
    }

    /**
     * Writes the characters from the specified string to the target.
     *
     * @param str
     *            the non-null string containing the characters to write.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.604 -0500", hash_original_method = "CF32CDDE2940A658D82FD10746BC6D29", hash_generated_method = "FFEB530BBD04B1626761EF212111F721")
    
@Override
    public void write(String str) {
        write(str.toCharArray());
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
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the length of {@code str}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.607 -0500", hash_original_method = "63C99944EF00B97313C46973AD4FFC8C", hash_generated_method = "B2605DFCA974A1A538F9BAD52C8E3544")
    
@Override
    public void write(String str, int offset, int count) {
        write(str.substring(offset, offset + count).toCharArray());
    }

    /**
     * Appends the character {@code c} to the target.
     *
     * @param c
     *            the character to append to the target.
     * @return this writer.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.609 -0500", hash_original_method = "4FD83DFE8717316B104D560444A12EF3", hash_generated_method = "C3F32695E29C5D8F69A4DC79938AD393")
    
@Override
    public PrintWriter append(char c) {
        write(c);
        return this;
    }

    /**
     * Appends the character sequence {@code csq} to the target. This
     * method works the same way as {@code PrintWriter.print(csq.toString())}.
     * If {@code csq} is {@code null}, then the string "null" is written
     * to the target.
     *
     * @param csq
     *            the character sequence appended to the target.
     * @return this writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.612 -0500", hash_original_method = "EC867D10B212AD9763F84A42EB42848B", hash_generated_method = "4D8F3ACDD5BAE69F7B73FFEABACE5366")
    
@Override
    public PrintWriter append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        append(csq, 0, csq.length());
        return this;
    }

    /**
     * Appends a subsequence of the character sequence {@code csq} to the
     * target. This method works the same way as {@code
     * PrintWriter.print(csq.subsequence(start, end).toString())}. If {@code
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
     * @throws StringIndexOutOfBoundsException
     *             if {@code start > end}, {@code start < 0}, {@code end < 0} or
     *             either {@code start} or {@code end} are greater or equal than
     *             the length of {@code csq}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:51.615 -0500", hash_original_method = "3313C31A52AD9501A690D6955A7EC57D", hash_generated_method = "0136AE3FC0D886253B0CCF22F93AB902")
    
@Override
    public PrintWriter append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        return this;
    }
    
}

