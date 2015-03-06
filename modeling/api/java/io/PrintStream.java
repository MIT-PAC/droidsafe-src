/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

public class PrintStream extends FilterOutputStream implements Appendable, Closeable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.005 -0500", hash_original_field = "B8E55DCF378C62700C874FE9D168DA3C", hash_generated_field = "C89C47EA16E34DEBAC0E78BF779BC70F")

    private boolean ioError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.008 -0500", hash_original_field = "E18E64283FE6FFBC087BABE45EE375FC", hash_generated_field = "C3BCA0E638347F15CBD7648899C5AE35")

    private boolean autoFlush;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.010 -0500", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;

    /**
     * Constructs a new {@code PrintStream} with {@code out} as its target
     * stream. By default, the new print stream does not automatically flush its
     * contents to the target stream when a newline is encountered.
     *
     * @param out
     *            the target output stream.
     * @throws NullPointerException
     *             if {@code out} is {@code null}.
     */
    @DSComment("Spec is marked when opening raw stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.013 -0500", hash_original_method = "DA75705BB6C20C2B5C6B266426BAE0E0", hash_generated_method = "75B61BC554C1596260D713DFDCFA50C9")
    
public PrintStream(OutputStream out) {
        super(out);
        if (out == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Constructs a new {@code PrintStream} with {@code out} as its target
     * stream. The parameter {@code autoFlush} determines if the print stream
     * automatically flushes its contents to the target stream when a newline is
     * encountered.
     *
     * @param out
     *            the target output stream.
     * @param autoFlush
     *            indicates whether to flush contents upon encountering a
     *            newline sequence.
     * @throws NullPointerException
     *             if {@code out} is {@code null}.
     */
    @DSComment("Spec is marked when opening raw stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.016 -0500", hash_original_method = "4DF55F7DB2EC2DB5AB84BECA03073608", hash_generated_method = "0F3B6D2546CA2DCE1EE0ECD7A536C6C0")
    
public PrintStream(OutputStream out, boolean autoFlush) {
        super(out);
        if (out == null) {
            throw new NullPointerException();
        }
        this.autoFlush = autoFlush;
    }

    /**
     * Constructs a new {@code PrintStream} with {@code out} as its target
     * stream and using the character encoding {@code enc} while writing. The
     * parameter {@code autoFlush} determines if the print stream automatically
     * flushes its contents to the target stream when a newline is encountered.
     *
     * @param out
     *            the target output stream.
     * @param autoFlush
     *            indicates whether or not to flush contents upon encountering a
     *            newline sequence.
     * @param enc
     *            the non-null string describing the desired character encoding.
     * @throws NullPointerException
     *             if {@code out} or {@code enc} are {@code null}.
     * @throws UnsupportedEncodingException
     *             if the encoding specified by {@code enc} is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.019 -0500", hash_original_method = "88526CF0A98EC9AB97C7088D88161C3A", hash_generated_method = "C8BD5832E5EC910C132DE3F1D8AF5182")
    
public PrintStream(OutputStream out, boolean autoFlush, String enc)
            throws UnsupportedEncodingException {
        super(out);
        if (out == null || enc == null) {
            throw new NullPointerException();
        }
        this.autoFlush = autoFlush;
        try {
            if (!Charset.isSupported(enc)) {
                throw new UnsupportedEncodingException(enc);
            }
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(enc);
        }
        encoding = enc;
    }

    /**
     * Constructs a new {@code PrintStream} with {@code file} as its target. The
     * VM's default character set is used for character encoding.
     *
     * @param file
     *            the target file. If the file already exists, its contents are
     *            removed, otherwise a new file is created.
     * @throws FileNotFoundException
     *             if an error occurs while opening or creating the target file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.021 -0500", hash_original_method = "029BA830A503765157243541D9849231", hash_generated_method = "1EAB385A2069599FAC05C66B6FA7928D")
    
public PrintStream(File file) throws FileNotFoundException {
        super(new FileOutputStream(file));
    }

    /**
     * Constructs a new {@code PrintStream} with {@code file} as its target. The
     * character set named {@code csn} is used for character encoding.
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.025 -0500", hash_original_method = "7BD29578480474358E31B9B912D3F437", hash_generated_method = "175C82E760110A6597BD34EC1DA71962")
    
public PrintStream(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        super(new FileOutputStream(file));
        if (csn == null) {
            throw new NullPointerException();
        }
        if (!Charset.isSupported(csn)) {
            throw new UnsupportedEncodingException(csn);
        }
        encoding = csn;
    }

    /**
     * Constructs a new {@code PrintStream} with the file identified by
     * {@code fileName} as its target. The VM's default character
     * set is used for character encoding.
     *
     * @param fileName
     *            the target file's name. If the file already exists, its
     *            contents are removed, otherwise a new file is created.
     * @throws FileNotFoundException
     *             if an error occurs while opening or creating the target file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.028 -0500", hash_original_method = "75348CDEFC68D9839C10010605892932", hash_generated_method = "E3C9AFC9C4BC886E80C53B895B4D5BAC")
    
public PrintStream(String fileName) throws FileNotFoundException {
        this(new File(fileName));
    }

    /**
     * Constructs a new {@code PrintStream} with the file identified by
     * {@code fileName} as its target. The character set named {@code csn} is
     * used for character encoding.
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.031 -0500", hash_original_method = "8131D7469DBCAB446E9D65623F4F3558", hash_generated_method = "7FBBBB5348ED91BFF4D6BF5319B51BA2")
    
public PrintStream(String fileName, String csn)
            throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn);
    }

    /**
     * Flushes this stream and returns the value of the error flag.
     *
     * @return {@code true} if either an {@code IOException} has been thrown
     *         previously or if {@code setError()} has been called;
     *         {@code false} otherwise.
     * @see #setError()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.034 -0500", hash_original_method = "DD851A8041FFB3055294FF15D1DC9C59", hash_generated_method = "30EE3B42F5C6B086AF598CBF64677C2F")
    
public boolean checkError() {
        OutputStream delegate = out;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.036 -0500", hash_original_method = "785F4CCF429F72C42E20A1AABCB6C5CE", hash_generated_method = "075905FDD441758AAED077D2A076C316")
    
protected void clearError() {
        ioError = false;
    }

    /**
     * Closes this print stream. Flushes this stream and then closes the target
     * stream. If an I/O error occurs, this stream's error state is set to
     * {@code true}.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.038 -0500", hash_original_method = "43C4845D6E61D29AF25E893F4FEF10C8", hash_generated_method = "084C41C8180277B84887369DD4B0E622")
    
@Override
    public synchronized void close() {
        flush();
        if (out != null) {
            try {
                out.close();
                out = null;
            } catch (IOException e) {
                setError();
            }
        }
    }

    /**
     * Ensures that all pending data is sent out to the target stream. It also
     * flushes the target stream. If an I/O error occurs, this stream's error
     * state is set to {@code true}.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.041 -0500", hash_original_method = "02B2E054E74BF295FB5EB637205E6B35", hash_generated_method = "3C8D1A6118D423ADD64926B1139D4505")
    
@Override
    public synchronized void flush() {
        /*        if (out != null) {
            try {
                out.flush();
                return;
            } catch (IOException e) {
                // Ignored, fall through to setError
            }
        }
        setError();
        */
    }

    /**
     * Formats {@code args} according to the format string {@code format}, and writes the result
     * to this stream. This method uses the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this stream.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.043 -0500", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "D0E8C8C1362771CFD28131DEFE60204D")
    
public PrintStream format(String format, Object... args) {
        return format(Locale.getDefault(), format, args);
    }

    /**
     * Writes a string formatted by an intermediate {@link Formatter} to this
     * stream using the specified locale, format string and arguments.
     *
     * @param l
     *            the locale used in the method. No localization will be applied
     *            if {@code l} is {@code null}.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this stream.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.046 -0500", hash_original_method = "A0786364FBC116E551740BAAD4532E24", hash_generated_method = "C1FAA506AEBAF707B9693792FA852381")
    
public PrintStream format(Locale l, String format, Object... args) {
        /*if (format == null) {
            throw new NullPointerException("format == null");
        }
        new Formatter(this, l).format(format, args);*/
        return this;
    }

    /**
     * Prints a formatted string. The behavior of this method is the same as
     * this stream's {@code #format(String, Object...)} method.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this stream.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.049 -0500", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "4289AA1E34294762A281E81EC632CE31")
    
public PrintStream printf(String format, Object... args) {
        return format(format, args);
    }

    /**
     * Prints a formatted string. The behavior of this method is the same as
     * this stream's {@code #format(Locale, String, Object...)} method.
     *
     * @param l
     *            the locale used in the method. No localization will be applied
     *            if {@code l} is {@code null}.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return this stream.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, if there are not enough arguments or if any other
     *             error regarding the format string or arguments is detected.
     * @throws NullPointerException if {@code format == null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.052 -0500", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "7FF92F5F2A23577E4AA6EF79C86D6193")
    
public PrintStream printf(Locale l, String format, Object... args) {
        return format(l, format, args);
    }

    /**
     * Put the line separator String onto the print stream.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.054 -0500", hash_original_method = "171496FE667133D572716C296277B927", hash_generated_method = "D3FD447AE5153B73BF6854A34B2A5107")
    
private void newline() {
        print(System.lineSeparator());
    }

    /**
     * Prints the string representation of the character array {@code chars}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.057 -0500", hash_original_method = "4DD9E13DA9D3ED57FA18E838A052301E", hash_generated_method = "11ED1780228B502450BA8A221394877E")
    
public void print(char[] chars) {
        print(new String(chars, 0, chars.length));
    }

    /**
     * Prints the string representation of the char {@code c}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.059 -0500", hash_original_method = "C9EF4F31D0CD27922D7B220DA437A7D8", hash_generated_method = "6CEBC2F82D21BF559E12C90A3D8E19A5")
    
public void print(char c) {
        print(String.valueOf(c));
    }

    /**
     * Prints the string representation of the double {@code d}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.062 -0500", hash_original_method = "7C6D053B4D54D80C9838D841006F1F5C", hash_generated_method = "58A01733132BC6CCDEB5D240F498B36F")
    
public void print(double d) {
        print(String.valueOf(d));
    }

    /**
     * Prints the string representation of the float {@code f}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.064 -0500", hash_original_method = "A190B4C4751A586A57985573C64F773B", hash_generated_method = "962C13EEE455314007099C3A6CD2D084")
    
public void print(float f) {
        print(String.valueOf(f));
    }

    /**
     * Prints the string representation of the int {@code i}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.066 -0500", hash_original_method = "9B0E5210436ABAF1CDC241F3CE945D0E", hash_generated_method = "FADE47AC1A634AD994A0F184BE398837")
    
public void print(int i) {
        print(String.valueOf(i));
    }

    /**
     * Prints the string representation of the long {@code l}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.068 -0500", hash_original_method = "ABA84580B4C740A85A05D502E7787C38", hash_generated_method = "C45FEB84A6EFC606463B784C6B78DFA2")
    
public void print(long l) {
        print(String.valueOf(l));
    }

    /**
     * Prints the string representation of the Object {@code o}, or {@code "null"}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.071 -0500", hash_original_method = "56B00C0EF01C99C01A3E7CAB0AC14873", hash_generated_method = "581D9A606F1CEDFB3C9C70F6CC66072B")
    
public void print(Object o) {
        print(String.valueOf(o));
    }

    /**
     * Prints a string to the target stream. The string is converted to an array
     * of bytes using the encoding chosen during the construction of this
     * stream. The bytes are then written to the target stream with
     * {@code write(int)}.
     *
     * <p>If an I/O error occurs, this stream's error state is set to {@code true}.
     *
     * @param str
     *            the string to print to the target stream.
     * @see #write(int)
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.073 -0500", hash_original_method = "EC0BC9FFC97B234EE7DA16C4D893B8BD", hash_generated_method = "489F7F4EEA6ECCC433FBCD9535D0F2B2")
    
public synchronized void print(String str) {
        if (out == null) {
            setError();
            return;
        }
        if (str == null) {
            print("null");
            return;
        }

        try {
            if (encoding == null) {
                write(str.getBytes());
            } else {
                write(str.getBytes(encoding));
            }
        } catch (IOException e) {
            setError();
        }
    }

    /**
     * Prints the string representation of the boolean {@code b}.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.076 -0500", hash_original_method = "D26761927DA4C2D28104AACA6719892E", hash_generated_method = "ABD327A177FABF113139187D82522D24")
    
public void print(boolean b) {
        print(String.valueOf(b));
    }

    /**
     * Prints a newline.
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.078 -0500", hash_original_method = "9182DD9F41FA957369047C0FC9C79FCF", hash_generated_method = "2FB2249EAF550DB99337C4213777CDD2")
    
public void println() {
        newline();
    }

    /**
     * Prints the string representation of the character array {@code chars} followed by a newline.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.081 -0500", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "401BCD9244EE35B0A776F2A2CEDD37CF")
    
public void println(char[] chars) {
        println(new String(chars, 0, chars.length));
    }

    /**
     * Prints the string representation of the char {@code c} followed by a newline.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.083 -0500", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "82BB46696338001ACA80E01920212F73")
    
public void println(char c) {
        println(String.valueOf(c));
    }

    /**
     * Prints the string representation of the double {@code d} followed by a newline.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.086 -0500", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "84BC8C6D54950BCAF58BC3BD27296799")
    
public void println(double d) {
        println(String.valueOf(d));
    }

    /**
     * Prints the string representation of the float {@code f} followed by a newline.
     */
   @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.088 -0500", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "9D7FF09A264CAD926D6BBFC063392F4E")
    
public void println(float f) {
        println(String.valueOf(f));
    }

   /**
     * Prints the string representation of the int {@code i} followed by a newline.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.090 -0500", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "98B5DD023B996103C774771444368106")
    
public void println(int i) {
        println(String.valueOf(i));
    }

    /**
     * Prints the string representation of the long {@code l} followed by a newline.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.093 -0500", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "82CA901E151A642E436F396BAF71A3BB")
    
public void println(long l) {
        println(String.valueOf(l));
    }

    /**
     * Prints the string representation of the Object {@code o}, or {@code "null"},
     * followed by a newline.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.096 -0500", hash_original_method = "320F49F677524EBEDCEEC6E202E646D4", hash_generated_method = "69578B780CE18EFA9BFBB5EC9A3A6677")
    
public void println(Object o) {
        println(String.valueOf(o));
    }

    /**
     * Prints a string followed by a newline. The string is converted to an array of bytes using
     * the encoding chosen during the construction of this stream. The bytes are
     * then written to the target stream with {@code write(int)}.
     *
     * <p>If an I/O error occurs, this stream's error state is set to {@code true}.
     *
     * @param str
     *            the string to print to the target stream.
     * @see #write(int)
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.098 -0500", hash_original_method = "0E73500566456C691BD3FFBE8C8D630F", hash_generated_method = "4A512F9EF154A49E278AEE766A83050C")
    
public synchronized void println(String str) {
        print(str);
        newline();
    }

    /**
     * Prints the string representation of the boolean {@code b} followed by a newline.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.101 -0500", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "D2EE9655DC271F139DF31A427D683083")
    
public void println(boolean b) {
        println(String.valueOf(b));
    }

    /**
     * Sets the error flag of this print stream to true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.103 -0500", hash_original_method = "203605AE3CB77711209DB798B89166F2", hash_generated_method = "B72650C135282FC171600ACE0FA9C219")
    
protected void setError() {
        ioError = true;
    }

    /**
     * Writes {@code count} bytes from {@code buffer} starting at {@code offset}
     * to the target stream. If autoFlush is set, this stream gets flushed after
     * writing the buffer.
     *
     * <p>This stream's error flag is set to {@code true} if this stream is closed
     * or an I/O error occurs.
     *
     * @param buffer
     *            the buffer to be written.
     * @param offset
     *            the index of the first byte in {@code buffer} to write.
     * @param length
     *            the number of bytes in {@code buffer} to write.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is bigger than the length of {@code buffer}.
     * @see #flush()
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.106 -0500", hash_original_method = "F607EA18611E8A10720BC492B203762D", hash_generated_method = "7562AB976D042B765C95D22DF08E1782")
    
@Override
    public void write(byte[] buffer, int offset, int length) {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        synchronized (this) {
            if (out == null) {
                setError();
                return;
            }
            try {
                out.write(buffer, offset, length);
                if (autoFlush) {
                    flush();
                }
            } catch (IOException e) {
                setError();
            }
        }
    }

    /**
     * Writes one byte to the target stream. Only the least significant byte of
     * the integer {@code oneByte} is written. This stream is flushed if
     * {@code oneByte} is equal to the character {@code '\n'} and this stream is
     * set to autoFlush.
     * <p>
     * This stream's error flag is set to {@code true} if it is closed or an I/O
     * error occurs.
     *
     * @param oneByte
     *            the byte to be written
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.109 -0500", hash_original_method = "18F006677191AEE023EC3E30B84DCBEE", hash_generated_method = "83A206AAFDBAE22539ADABBF4F92F72F")
    
@Override
    public synchronized void write(int oneByte) {
        if (out == null) {
            setError();
            return;
        }
        try {
            out.write(oneByte);
            int b = oneByte & 0xFF;
            // 0x0A is ASCII newline, 0x15 is EBCDIC newline.
            boolean isNewline = b == 0x0A || b == 0x15;
            if (autoFlush && isNewline) {
                flush();
            }
        } catch (IOException e) {
            setError();
        }
    }

    /**
     * Appends the char {@code c}.
     * @return this stream.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.111 -0500", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "567388336315194D44F6B3A0E6810A6D")
    
public PrintStream append(char c) {
        print(c);
        return this;
    }

    /**
     * Appends the CharSequence {@code charSequence}, or {@code "null"}.
     * @return this stream.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.113 -0500", hash_original_method = "FC28086FFC8546AD8E2DD12638EADD5B", hash_generated_method = "CBEF6036EF5324F7F8E9482B27D68A9B")
    
public PrintStream append(CharSequence charSequence) {
        if (charSequence == null) {
            print("null");
        } else {
            print(charSequence.toString());
        }
        return this;
    }

    /**
     * Appends a subsequence of CharSequence {@code charSequence}, or {@code "null"}.
     *
     * @param charSequence
     *            the character sequence appended to the target stream.
     * @param start
     *            the index of the first char in the character sequence appended
     *            to the target stream.
     * @param end
     *            the index of the character following the last character of the
     *            subsequence appended to the target stream.
     * @return this stream.
     * @throws IndexOutOfBoundsException
     *             if {@code start > end}, {@code start < 0}, {@code end < 0} or
     *             either {@code start} or {@code end} are greater or equal than
     *             the length of {@code charSequence}.
     */
    
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.116 -0500", hash_original_method = "E6E1D45C488E30FA7AAEB51CD532F3E9", hash_generated_method = "2CCB3331F640FEC4F2ECC7BDFC23CD2A")
    
public PrintStream append(CharSequence charSequence, int start, int end) {
        if (charSequence == null) {
            charSequence = "null";
        }
        print(charSequence.subSequence(start, end).toString());
        return this;
    }
    
}

