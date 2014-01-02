package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.nio.charset.Charset;

import libcore.icu.LocaleData;
import libcore.icu.NativeDecimalFormat;
import libcore.io.IoUtils;





public final class Formatter implements Closeable, Flushable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.828 -0500", hash_original_field = "481409682F49E12073A8312D2241CF0A", hash_generated_field = "936B09C441C4FA32E24FFDE50779B4D5")

    private static final char[] ZEROS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.533 -0400", hash_original_field = "2E22D2BB824CAE76137397D7BB1A476C", hash_generated_field = "A22626209D6F7C1DAB7E829778351877")

    private static final ThreadLocal<CachedDecimalFormat> cachedDecimalFormat = new ThreadLocal<CachedDecimalFormat>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.533 -0400", hash_original_method = "3BF85501572F336E7CB9026A6524A649", hash_generated_method = "1EC7F54F0E895EC060EFCA96009F4258")
        @Override
        protected CachedDecimalFormat initialValue() {
            CachedDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_1389458477 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1389458477 = new CachedDecimalFormat();
            varB4EAC82CA7396A68D541C85D26508E83_1389458477.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1389458477;
            
            
        }

        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.833 -0500", hash_original_field = "968B872E966CD720BD66C6524EB8F888", hash_generated_field = "3DC9338DC786F95D1A95A8961D85A2A6")

    private Appendable out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.835 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.838 -0500", hash_original_field = "731451AEA22B3A0242CA1F1170F5CD90", hash_generated_field = "613B0CE96D5332BFAF1329D4F111938C")

    private Object arg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.840 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.843 -0500", hash_original_field = "027222D104F570F8E72A93293503415F", hash_generated_field = "FB61E2282DE2F9A3C415CEE063007787")

    private FormatToken formatToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.845 -0500", hash_original_field = "2D64161965ACCFD5E6EAFC7F1C573898", hash_generated_field = "94160D1F6EC5CF5867F2CCE7946E9FCB")

    private IOException lastIOException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.847 -0500", hash_original_field = "DB46E25AFEC1F3807D3B16F0DA164B7F", hash_generated_field = "C9E2992A298A3ADEBF6945150F771649")

    private LocaleData localeData;

    /**
     * Constructs a {@code Formatter}.
     *
     * <p>The output is written to a {@code StringBuilder} which can be acquired by invoking
     * {@link #out()} and whose content can be obtained by calling {@code toString}.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.873 -0500", hash_original_method = "776A8092D7EB6A8CE9FA3707C90FDC71", hash_generated_method = "9A9797ACDC79BA7B3F09BEE8969079B8")
    
public Formatter() {
        this(new StringBuilder(), Locale.getDefault());
    }

    /**
     * Constructs a {@code Formatter} whose output will be written to the
     * specified {@code Appendable}.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param a
     *            the output destination of the {@code Formatter}. If {@code a} is {@code null},
     *            then a {@code StringBuilder} will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.876 -0500", hash_original_method = "C10A7E7C6014F1D5457B2868B8DDD5FA", hash_generated_method = "F7151103E2DD674DB089FF9C6FE6456E")
    
public Formatter(Appendable a) {
        this(a, Locale.getDefault());
    }

    /**
     * Constructs a {@code Formatter} with the specified {@code Locale}.
     *
     * <p>The output is written to a {@code StringBuilder} which can be acquired by invoking
     * {@link #out()} and whose content can be obtained by calling {@code toString}.
     *
     * @param l
     *            the {@code Locale} of the {@code Formatter}. If {@code l} is {@code null},
     *            then no localization will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.878 -0500", hash_original_method = "949ED46E62E9C1FD97345CAB1F572157", hash_generated_method = "246D69465AB23352D4DC5064665D1630")
    
public Formatter(Locale l) {
        this(new StringBuilder(), l);
    }

    /**
     * Constructs a {@code Formatter} with the specified {@code Locale}
     * and whose output will be written to the
     * specified {@code Appendable}.
     *
     * @param a
     *            the output destination of the {@code Formatter}. If {@code a} is {@code null},
     *            then a {@code StringBuilder} will be used.
     * @param l
     *            the {@code Locale} of the {@code Formatter}. If {@code l} is {@code null},
     *            then no localization will be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.881 -0500", hash_original_method = "731A0E308D6775F1250BD9086CA3748C", hash_generated_method = "84A13253DC62E49805B98130B56A070B")
    
public Formatter(Appendable a, Locale l) {
        if (a == null) {
            out = new StringBuilder();
        } else {
            out = a;
        }
        locale = l;
    }

    /**
     * Constructs a {@code Formatter} whose output is written to the specified file.
     *
     * <p>The charset of the {@code Formatter} is the default charset.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param fileName
     *            the filename of the file that is used as the output
     *            destination for the {@code Formatter}. The file will be truncated to
     *            zero size if the file exists, or else a new file will be
     *            created. The output of the {@code Formatter} is buffered.
     * @throws FileNotFoundException
     *             if the filename does not denote a normal and writable file,
     *             or if a new file cannot be created, or if any error arises when
     *             opening or creating the file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.884 -0500", hash_original_method = "55110CB3A063CDDA9DDF2A6FEEDBC4D6", hash_generated_method = "E2516CD8790738277E2A830706970BAE")
    
public Formatter(String fileName) throws FileNotFoundException {
        this(new File(fileName));

    }

    /**
     * Constructs a {@code Formatter} whose output is written to the specified file.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param fileName
     *            the filename of the file that is used as the output
     *            destination for the {@code Formatter}. The file will be truncated to
     *            zero size if the file exists, or else a new file will be
     *            created. The output of the {@code Formatter} is buffered.
     * @param csn
     *            the name of the charset for the {@code Formatter}.
     * @throws FileNotFoundException
     *             if the filename does not denote a normal and writable file,
     *             or if a new file cannot be created, or if any error arises when
     *             opening or creating the file.
     * @throws UnsupportedEncodingException
     *             if the charset with the specified name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.887 -0500", hash_original_method = "D05AE6CA9B3694824C73C0B398D66198", hash_generated_method = "1C11F64184B1D8B3FB30344D931F04E0")
    
public Formatter(String fileName, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new File(fileName), csn);
    }

    /**
     * Constructs a {@code Formatter} with the given {@code Locale} and charset,
     * and whose output is written to the specified file.
     *
     * @param fileName
     *            the filename of the file that is used as the output
     *            destination for the {@code Formatter}. The file will be truncated to
     *            zero size if the file exists, or else a new file will be
     *            created. The output of the {@code Formatter} is buffered.
     * @param csn
     *            the name of the charset for the {@code Formatter}.
     * @param l
     *            the {@code Locale} of the {@code Formatter}. If {@code l} is {@code null},
     *            then no localization will be used.
     * @throws FileNotFoundException
     *             if the filename does not denote a normal and writable file,
     *             or if a new file cannot be created, or if any error arises when
     *             opening or creating the file.
     * @throws UnsupportedEncodingException
     *             if the charset with the specified name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.890 -0500", hash_original_method = "106406A68116E4DC11358A25DB96C9D8", hash_generated_method = "70ECB7DF7F3F2102097FB3A2CC47AE17")
    
public Formatter(String fileName, String csn, Locale l)
            throws FileNotFoundException, UnsupportedEncodingException {

        this(new File(fileName), csn, l);
    }

    /**
     * Constructs a {@code Formatter} whose output is written to the specified {@code File}.
     *
     * The charset of the {@code Formatter} is the default charset.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param file
     *            the {@code File} that is used as the output destination for the
     *            {@code Formatter}. The {@code File} will be truncated to zero size if the {@code File}
     *            exists, or else a new {@code File} will be created. The output of the
     *            {@code Formatter} is buffered.
     * @throws FileNotFoundException
     *             if the {@code File} is not a normal and writable {@code File}, or if a
     *             new {@code File} cannot be created, or if any error rises when opening or
     *             creating the {@code File}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.892 -0500", hash_original_method = "56C5088BBC7ACEBB0E3B42C5FC534A61", hash_generated_method = "1E278F601A97B10D889C4119BC6EE3D0")
    
public Formatter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
    }

    /**
     * Constructs a {@code Formatter} with the given charset,
     * and whose output is written to the specified {@code File}.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param file
     *            the {@code File} that is used as the output destination for the
     *            {@code Formatter}. The {@code File} will be truncated to zero size if the {@code File}
     *            exists, or else a new {@code File} will be created. The output of the
     *            {@code Formatter} is buffered.
     * @param csn
     *            the name of the charset for the {@code Formatter}.
     * @throws FileNotFoundException
     *             if the {@code File} is not a normal and writable {@code File}, or if a
     *             new {@code File} cannot be created, or if any error rises when opening or
     *             creating the {@code File}.
     * @throws UnsupportedEncodingException
     *             if the charset with the specified name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.895 -0500", hash_original_method = "15C3BB1BBEBB7DA2B256558B7A83F1D2", hash_generated_method = "AF5C4DDCF65FEF3DA60CA2DAE4F5A25C")
    
public Formatter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(file, csn, Locale.getDefault());
    }

    /**
     * Constructs a {@code Formatter} with the given {@code Locale} and charset,
     * and whose output is written to the specified {@code File}.
     *
     * @param file
     *            the {@code File} that is used as the output destination for the
     *            {@code Formatter}. The {@code File} will be truncated to zero size if the {@code File}
     *            exists, or else a new {@code File} will be created. The output of the
     *            {@code Formatter} is buffered.
     * @param csn
     *            the name of the charset for the {@code Formatter}.
     * @param l
     *            the {@code Locale} of the {@code Formatter}. If {@code l} is {@code null},
     *            then no localization will be used.
     * @throws FileNotFoundException
     *             if the {@code File} is not a normal and writable {@code File}, or if a
     *             new {@code File} cannot be created, or if any error rises when opening or
     *             creating the {@code File}.
     * @throws UnsupportedEncodingException
     *             if the charset with the specified name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.897 -0500", hash_original_method = "11FC304A866A57AD6707E0AE5ACD74C6", hash_generated_method = "C8D60A65F1BC72C5573899240A7C8234")
    
public Formatter(File file, String csn, Locale l)
            throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            out = new BufferedWriter(new OutputStreamWriter(fout, csn));
        } catch (RuntimeException e) {
            IoUtils.closeQuietly(fout);
            throw e;
        } catch (UnsupportedEncodingException e) {
            IoUtils.closeQuietly(fout);
            throw e;
        }

        locale = l;
    }

    /**
     * Constructs a {@code Formatter} whose output is written to the specified {@code OutputStream}.
     *
     * <p>The charset of the {@code Formatter} is the default charset.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param os
     *            the stream to be used as the destination of the {@code Formatter}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.901 -0500", hash_original_method = "18094D8509766CE6FC608D9540C5972B", hash_generated_method = "A3D7CDD42DF9DFFBFB4990BBFE10E2B6")
    
public Formatter(OutputStream os) {
        out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        locale = Locale.getDefault();
    }

    /**
     * Constructs a {@code Formatter} with the given charset,
     * and whose output is written to the specified {@code OutputStream}.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param os
     *            the stream to be used as the destination of the {@code Formatter}.
     * @param csn
     *            the name of the charset for the {@code Formatter}.
     * @throws UnsupportedEncodingException
     *             if the charset with the specified name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.903 -0500", hash_original_method = "F6295FD9F7AB3AB7F721531D402E7F81", hash_generated_method = "2137A29D938C10AD69137A4A7C0B324D")
    
public Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault());
    }

    /**
     * Constructs a {@code Formatter} with the given {@code Locale} and charset,
     * and whose output is written to the specified {@code OutputStream}.
     *
     * @param os
     *            the stream to be used as the destination of the {@code Formatter}.
     * @param csn
     *            the name of the charset for the {@code Formatter}.
     * @param l
     *            the {@code Locale} of the {@code Formatter}. If {@code l} is {@code null},
     *            then no localization will be used.
     * @throws UnsupportedEncodingException
     *             if the charset with the specified name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.906 -0500", hash_original_method = "339D31BAB557832A3B8A75EB377C0635", hash_generated_method = "A3D139E97C9CE1BF978AF0113011FC9C")
    
public Formatter(OutputStream os, String csn, Locale l) throws UnsupportedEncodingException {
        out = new BufferedWriter(new OutputStreamWriter(os, csn));
        locale = l;
    }

    /**
     * Constructs a {@code Formatter} whose output is written to the specified {@code PrintStream}.
     *
     * <p>The charset of the {@code Formatter} is the default charset.
     *
     * <p>The {@code Locale} used is the user's default locale.
     * See "<a href="../util/Locale.html#default_locale">Be wary of the default locale</a>".
     *
     * @param ps
     *            the {@code PrintStream} used as destination of the {@code Formatter}. If
     *            {@code ps} is {@code null}, then a {@code NullPointerException} will
     *            be raised.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.909 -0500", hash_original_method = "6A92C9283CC7B01627E24F0E27824A3B", hash_generated_method = "408F6162334A84F1D56AF1BFA6C17338")
    
public Formatter(PrintStream ps) {
        if (ps == null) {
            throw new NullPointerException();
        }
        out = ps;
        locale = Locale.getDefault();
    }

    /**
     * Creates a native peer if we don't already have one, or reconfigures an existing one.
     * This means we get to reuse the peer in cases like "x=%.2f y=%.2f".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.870 -0500", hash_original_method = "9D62CCD9646FE324AC0FFA6EB7C17C6C", hash_generated_method = "0917A02FDC016644C8B13A56EA337A3E")
    
private NativeDecimalFormat getDecimalFormat(String pattern) {
        return cachedDecimalFormat.get().update(localeData, pattern);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.912 -0500", hash_original_method = "E3DA6A4C963B6E9187963221C571CEC2", hash_generated_method = "100F2A9DD176368CC3F8A0D7D3210923")
    
private void checkNotClosed() {
        if (closed) {
            throw new FormatterClosedException();
        }
    }

    /**
     * Returns the {@code Locale} of the {@code Formatter}.
     *
     * @return the {@code Locale} for the {@code Formatter} or {@code null} for no {@code Locale}.
     * @throws FormatterClosedException
     *             if the {@code Formatter} has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.914 -0500", hash_original_method = "B5A8A4A4A455286143E3BD4E75C6F0FE", hash_generated_method = "CC072A6C582FD239C024A4889119E0FF")
    
public Locale locale() {
        checkNotClosed();
        return locale;
    }

    /**
     * Returns the output destination of the {@code Formatter}.
     *
     * @return the output destination of the {@code Formatter}.
     * @throws FormatterClosedException
     *             if the {@code Formatter} has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.916 -0500", hash_original_method = "D73A5BF8E95D39CBD6819B9B1AA13C8D", hash_generated_method = "FE0E5852C6DE222F08138AD38C62ED36")
    
public Appendable out() {
        checkNotClosed();
        return out;
    }

    /**
     * Returns the content by calling the {@code toString()} method of the output
     * destination.
     *
     * @return the content by calling the {@code toString()} method of the output
     *         destination.
     * @throws FormatterClosedException
     *             if the {@code Formatter} has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.919 -0500", hash_original_method = "39CF8FB3A631311648D12D228411CE26", hash_generated_method = "6DA3D729E44B0341A1ABC59559EF1572")
    
@Override
    public String toString() {
        checkNotClosed();
        return out.toString();
    }

    /**
     * Flushes the {@code Formatter}. If the output destination is {@link Flushable},
     * then the method {@code flush()} will be called on that destination.
     *
     * @throws FormatterClosedException
     *             if the {@code Formatter} has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.921 -0500", hash_original_method = "E9CBCF5548B5D691C8801114F0C41C59", hash_generated_method = "7551384FE3FF07BC096BE243C3F007BA")
    
public void flush() {
        checkNotClosed();
        if (out instanceof Flushable) {
            try {
                ((Flushable) out).flush();
            } catch (IOException e) {
                lastIOException = e;
            }
        }
    }

    /**
     * Closes the {@code Formatter}. If the output destination is {@link Closeable},
     * then the method {@code close()} will be called on that destination.
     *
     * If the {@code Formatter} has been closed, then calling the this method will have no
     * effect.
     *
     * Any method but the {@link #ioException()} that is called after the
     * {@code Formatter} has been closed will raise a {@code FormatterClosedException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.923 -0500", hash_original_method = "16C1939C51EF65BBD0A872F925CE78BF", hash_generated_method = "5959B1B6060902934AAAD616AD5F40BD")
    
public void close() {
        if (!closed) {
            closed = true;
            try {
                if (out instanceof Closeable) {
                    ((Closeable) out).close();
                }
            } catch (IOException e) {
                lastIOException = e;
            }
        }
    }

    /**
     * Returns the last {@code IOException} thrown by the {@code Formatter}'s output
     * destination. If the {@code append()} method of the destination does not throw
     * {@code IOException}s, the {@code ioException()} method will always return {@code null}.
     *
     * @return the last {@code IOException} thrown by the {@code Formatter}'s output
     *         destination.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.926 -0500", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "9021EA20032F11132D2B9F300EA6476A")
    
public IOException ioException() {
        return lastIOException;
    }

    /**
     * Writes a formatted string to the output destination of the {@code Formatter}.
     *
     * @param format
     *            a format string.
     * @param args
     *            the arguments list used in the {@code format()} method. If there are
     *            more arguments than those specified by the format string, then
     *            the additional arguments are ignored.
     * @return this {@code Formatter}.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, or if fewer arguments are sent than those required by
     *             the format string, or any other illegal situation.
     * @throws FormatterClosedException
     *             if the {@code Formatter} has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.928 -0500", hash_original_method = "EE9FCF62B0D200225753D8BA586AA3F5", hash_generated_method = "C4D83BBCFDE4A21103D799255677161F")
    
public Formatter format(String format, Object... args) {
        return format(this.locale, format, args);
    }

    /**
     * Writes a formatted string to the output destination of the {@code Formatter}.
     *
     * @param l
     *            the {@code Locale} used in the method. If {@code locale} is
     *            {@code null}, then no localization will be applied. This
     *            parameter does not change this Formatter's default {@code Locale}
     *            as specified during construction, and only applies for the
     *            duration of this call.
     * @param format
     *            a format string.
     * @param args
     *            the arguments list used in the {@code format()} method. If there are
     *            more arguments than those specified by the format string, then
     *            the additional arguments are ignored.
     * @return this {@code Formatter}.
     * @throws IllegalFormatException
     *             if the format string is illegal or incompatible with the
     *             arguments, or if fewer arguments are sent than those required by
     *             the format string, or any other illegal situation.
     * @throws FormatterClosedException
     *             if the {@code Formatter} has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.931 -0500", hash_original_method = "F45273151F6DD69ACB6CCC03C59753A4", hash_generated_method = "ED22431379AC5785B8BAB430FCFA2F68")
    
public Formatter format(Locale l, String format, Object... args) {
        Locale originalLocale = locale;
        try {
            this.locale = (l == null ? Locale.US : l);
            this.localeData = LocaleData.get(locale);
            doFormat(format, args);
        } finally {
            this.locale = originalLocale;
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.934 -0500", hash_original_method = "960E24FB807777DEBBE8328729AF6A3F", hash_generated_method = "4FFC364C6BF6D06DE53F6A13340A9F36")
    
private void doFormat(String format, Object... args) {
        checkNotClosed();

        FormatSpecifierParser fsp = new FormatSpecifierParser(format);
        int currentObjectIndex = 0;
        Object lastArgument = null;
        boolean hasLastArgumentSet = false;

        int length = format.length();
        int i = 0;
        while (i < length) {
            // Find the maximal plain-text sequence...
            int plainTextStart = i;
            int nextPercent = format.indexOf('%', i);
            int plainTextEnd = (nextPercent == -1) ? length : nextPercent;
            // ...and output it.
            if (plainTextEnd > plainTextStart) {
                outputCharSequence(format, plainTextStart, plainTextEnd);
            }
            i = plainTextEnd;
            // Do we have a format specifier?
            if (i < length) {
                FormatToken token = fsp.parseFormatToken(i + 1);

                Object argument = null;
                if (token.requireArgument()) {
                    int index = token.getArgIndex() == FormatToken.UNSET ? currentObjectIndex++ : token.getArgIndex();
                    argument = getArgument(args, index, fsp, lastArgument, hasLastArgumentSet);
                    lastArgument = argument;
                    hasLastArgumentSet = true;
                }

                CharSequence substitution = transform(token, argument);
                // The substitution is null if we called Formattable.formatTo.
                if (substitution != null) {
                    outputCharSequence(substitution, 0, substitution.length());
                }
                i = fsp.i;
            }
        }
    }

    // Fixes http://code.google.com/p/android/issues/detail?id=1767.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.936 -0500", hash_original_method = "4A93F3F0DF6F4E45CC93AF5660722832", hash_generated_method = "A6EC27CF5AA0395A9E82675C400128BE")
    
private void outputCharSequence(CharSequence cs, int start, int end) {
        try {
            out.append(cs, start, end);
        } catch (IOException e) {
            lastIOException = e;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.939 -0500", hash_original_method = "4EF20CF84298D39EE17983F53878C341", hash_generated_method = "AA897667F085C7D308DB2DB9684C374A")
    
private Object getArgument(Object[] args, int index, FormatSpecifierParser fsp,
            Object lastArgument, boolean hasLastArgumentSet) {
        if (index == FormatToken.LAST_ARGUMENT_INDEX && !hasLastArgumentSet) {
            throw new MissingFormatArgumentException("<");
        }

        if (args == null) {
            return null;
        }

        if (index >= args.length) {
            throw new MissingFormatArgumentException(fsp.getFormatSpecifierText());
        }

        if (index == FormatToken.LAST_ARGUMENT_INDEX) {
            return lastArgument;
        }

        return args[index];
    }

    /*
     * Gets the formatted string according to the format token and the
     * argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.033 -0500", hash_original_method = "0237F1DF7BD7A386A4F4D1B44D43876F", hash_generated_method = "D8DF17018452355B63D218271B35E099")
    
private CharSequence transform(FormatToken token, Object argument) {
        this.formatToken = token;
        this.arg = argument;

        // There are only two format specifiers that matter: "%d" and "%s".
        // Nothing else is common in the wild. We fast-path these two to
        // avoid the heavyweight machinery needed to cope with flags, width,
        // and precision.
        if (token.isDefault()) {
            switch (token.getConversionType()) {
            case 's':
                if (arg == null) {
                    return "null";
                } else if (!(arg instanceof Formattable)) {
                    return arg.toString();
                }
                break;
            case 'd':
                boolean needLocalizedDigits = (localeData.zeroDigit != '0');
                if (out instanceof StringBuilder && !needLocalizedDigits) {
                    if (arg instanceof Integer || arg instanceof Short || arg instanceof Byte) {
                        IntegralToString.appendInt((StringBuilder) out, ((Number) arg).intValue());
                        return null;
                    } else if (arg instanceof Long) {
                        IntegralToString.appendLong((StringBuilder) out, ((Long) arg).longValue());
                        return null;
                    }
                }
                if (arg instanceof Integer || arg instanceof Long || arg instanceof Short || arg instanceof Byte) {
                    String result = arg.toString();
                    return needLocalizedDigits ? localizeDigits(result) : result;
                }
            }
        }

        formatToken.checkFlags(arg);
        CharSequence result;
        switch (token.getConversionType()) {
        case 'B': case 'b':
            result = transformFromBoolean();
            break;
        case 'H': case 'h':
            result = transformFromHashCode();
            break;
        case 'S': case 's':
            result = transformFromString();
            break;
        case 'C': case 'c':
            result = transformFromCharacter();
            break;
        case 'd': case 'o': case 'x': case 'X':
            if (arg == null || arg instanceof BigInteger) {
                result = transformFromBigInteger();
            } else {
                result = transformFromInteger();
            }
            break;
        case 'A': case 'a': case 'E': case 'e': case 'f': case 'G': case 'g':
            result = transformFromFloat();
            break;
        case '%':
            result = transformFromPercent();
            break;
        case 'n':
            result = System.lineSeparator();
            break;
        case 't': case 'T':
            result = transformFromDateTime();
            break;
        default:
            throw token.unknownFormatConversionException();
        }

        if (Character.isUpperCase(token.getConversionType())) {
            if (result != null) {
                result = result.toString().toUpperCase(locale);
            }
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.036 -0500", hash_original_method = "D44F27ADB431306CEB9F9E1F25036901", hash_generated_method = "1DDD60EECF3A47736937602E05B6BFD4")
    
private IllegalFormatConversionException badArgumentType() {
        throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
    }

    /**
     * Returns a CharSequence corresponding to {@code s} with all the ASCII digits replaced
     * by digits appropriate to this formatter's locale. Other characters remain unchanged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.038 -0500", hash_original_method = "8CD3AC57424B332A3611698407D98FD3", hash_generated_method = "72450092AE3AEA069DA2B7D6897A339C")
    
private CharSequence localizeDigits(CharSequence s) {
        int length = s.length();
        int offsetToLocalizedDigits = localeData.zeroDigit - '0';
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                ch += offsetToLocalizedDigits;
            }
            result.append(ch);
        }
        return result;
    }

    /**
     * Inserts the grouping separator every 3 digits. DecimalFormat lets you configure grouping
     * size, but you can't access that from Formatter, and the default is every 3 digits.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.041 -0500", hash_original_method = "CC3FF2DA7072A05A8664F97319F6C752", hash_generated_method = "073681E100119D78CF7FBB2AB770DDDB")
    
private CharSequence insertGrouping(CharSequence s) {
        StringBuilder result = new StringBuilder(s.length() + s.length()/3);

        // A leading '-' doesn't want to be included in the grouping.
        int digitsLength = s.length();
        int i = 0;
        if (s.charAt(0) == '-') {
            --digitsLength;
            ++i;
            result.append('-');
        }

        // Append the digits that come before the first separator.
        int headLength = digitsLength % 3;
        if (headLength == 0) {
            headLength = 3;
        }
        result.append(s, i, i + headLength);
        i += headLength;

        // Append the remaining groups.
        for (; i < s.length(); i += 3) {
            result.append(localeData.groupingSeparator);
            result.append(s, i, i + 3);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.044 -0500", hash_original_method = "54F34C95EDCEEE411BD250D07A12E500", hash_generated_method = "42D869C9517CA8E6D9A571BB6B82DCC6")
    
private CharSequence transformFromBoolean() {
        CharSequence result;
        if (arg instanceof Boolean) {
            result = arg.toString();
        } else if (arg == null) {
            result = "false";
        } else {
            result = "true";
        }
        return padding(result, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.047 -0500", hash_original_method = "FEE63D21FF5AA7B8F21641D7D3CB6697", hash_generated_method = "84BC48557AB0D6DA3AE36CBA26FC16F1")
    
private CharSequence transformFromHashCode() {
        CharSequence result;
        if (arg == null) {
            result = "null";
        } else {
            result = Integer.toHexString(arg.hashCode());
        }
        return padding(result, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.049 -0500", hash_original_method = "41FDF272148D1D909A3CC241D4F2B404", hash_generated_method = "6D0CFDAEF623EC0B769D8D42EB91873E")
    
private CharSequence transformFromString() {
        if (arg instanceof Formattable) {
            int flags = 0;
            if (formatToken.flagMinus) {
                flags |= FormattableFlags.LEFT_JUSTIFY;
            }
            if (formatToken.flagSharp) {
                flags |= FormattableFlags.ALTERNATE;
            }
            if (Character.isUpperCase(formatToken.getConversionType())) {
                flags |= FormattableFlags.UPPERCASE;
            }
            ((Formattable) arg).formatTo(this, flags, formatToken.getWidth(),
                    formatToken.getPrecision());
            // all actions have been taken out in the
            // Formattable.formatTo, thus there is nothing to do, just
            // returns null, which tells the Parser to add nothing to the
            // output.
            return null;
        }
        CharSequence result = arg != null ? arg.toString() : "null";
        return padding(result, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.052 -0500", hash_original_method = "78103310C8550D540C751775D2E73F1B", hash_generated_method = "A72ED8B2E80EE72828A262D7E1BE1332")
    
private CharSequence transformFromCharacter() {
        if (arg == null) {
            return padding("null", 0);
        }
        if (arg instanceof Character) {
            return padding(String.valueOf(arg), 0);
        } else if (arg instanceof Byte || arg instanceof Short || arg instanceof Integer) {
            int codePoint = ((Number) arg).intValue();
            if (!Character.isValidCodePoint(codePoint)) {
                throw new IllegalFormatCodePointException(codePoint);
            }
            CharSequence result = (codePoint < Character.MIN_SUPPLEMENTARY_CODE_POINT)
                    ? String.valueOf((char) codePoint)
                    : String.valueOf(Character.toChars(codePoint));
            return padding(result, 0);
        } else {
            throw badArgumentType();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.054 -0500", hash_original_method = "1802F533F155B8AA49557FA5A74B7DBE", hash_generated_method = "EDB7C4DB553D8CF5987D07634BD5D1E3")
    
private CharSequence transformFromPercent() {
        return padding("%", 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.057 -0500", hash_original_method = "EF7726D1BC858C4C5BDC40B9ACBD3ABF", hash_generated_method = "B7F440B7197569919B9910A1F3D3DD7B")
    
private CharSequence padding(CharSequence source, int startIndex) {
        int start = startIndex;
        int width = formatToken.getWidth();
        int precision = formatToken.getPrecision();

        int length = source.length();
        if (precision >= 0) {
            length = Math.min(length, precision);
            if (source instanceof StringBuilder) {
                ((StringBuilder) source).setLength(length);
            } else {
                source = source.subSequence(0, length);
            }
        }
        if (width > 0) {
            width = Math.max(source.length(), width);
        }
        if (length >= width) {
            return source;
        }

        char paddingChar = '\u0020'; // space as padding char.
        if (formatToken.flagZero) {
            if (formatToken.getConversionType() == 'd') {
                paddingChar = localeData.zeroDigit;
            } else {
                paddingChar = '0'; // No localized digits for bases other than decimal.
            }
        } else {
            // if padding char is space, always pad from the start.
            start = 0;
        }
        char[] paddingChars = new char[width - length];
        Arrays.fill(paddingChars, paddingChar);

        boolean paddingRight = formatToken.flagMinus;
        StringBuilder result = toStringBuilder(source);
        if (paddingRight) {
            result.append(paddingChars);
        } else {
            result.insert(start, paddingChars);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.059 -0500", hash_original_method = "AA67EEFB247ACC7BDA1BABCD03B30A80", hash_generated_method = "803D855AAC16BD20768E3BA7C1A197CC")
    
private StringBuilder toStringBuilder(CharSequence cs) {
        return cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.062 -0500", hash_original_method = "CE1A2CC9741A13D14659E3953A660AC1", hash_generated_method = "8DA802C33D58DC2074DB11232F93FB44")
    
private StringBuilder wrapParentheses(StringBuilder result) {
        result.setCharAt(0, '('); // Replace the '-'.
        if (formatToken.flagZero) {
            formatToken.setWidth(formatToken.getWidth() - 1);
            result = (StringBuilder) padding(result, 1);
            result.append(')');
        } else {
            result.append(')');
            result = (StringBuilder) padding(result, 0);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.066 -0500", hash_original_method = "FADDE3D8C4FA639F028B03B661D10023", hash_generated_method = "86EEF139DF110EA40C77F1DAF2842D9E")
    
private CharSequence transformFromInteger() {
        int startIndex = 0;
        StringBuilder result = new StringBuilder();
        char currentConversionType = formatToken.getConversionType();

        long value;
        if (arg instanceof Long) {
            value = ((Long) arg).longValue();
        } else if (arg instanceof Integer) {
            value = ((Integer) arg).longValue();
        } else if (arg instanceof Short) {
            value = ((Short) arg).longValue();
        } else if (arg instanceof Byte) {
            value = ((Byte) arg).longValue();
        } else {
            throw badArgumentType();
        }

        if (formatToken.flagSharp) {
            if (currentConversionType == 'o') {
                result.append("0");
                startIndex += 1;
            } else {
                result.append("0x");
                startIndex += 2;
            }
        }

        if (currentConversionType == 'd') {
            CharSequence digits = Long.toString(value);
            if (formatToken.flagComma) {
                digits = insertGrouping(digits);
            }
            if (localeData.zeroDigit != '0') {
                digits = localizeDigits(digits);
            }
            result.append(digits);

            if (value < 0) {
                if (formatToken.flagParenthesis) {
                    return wrapParentheses(result);
                } else if (formatToken.flagZero) {
                    startIndex++;
                }
            } else {
                if (formatToken.flagPlus) {
                    result.insert(0, '+');
                    startIndex += 1;
                } else if (formatToken.flagSpace) {
                    result.insert(0, ' ');
                    startIndex += 1;
                }
            }
        } else {
            // Undo sign-extension, since we'll be using Long.to(Octal|Hex)String.
            if (arg instanceof Byte) {
                value &= 0xffL;
            } else if (arg instanceof Short) {
                value &= 0xffffL;
            } else if (arg instanceof Integer) {
                value &= 0xffffffffL;
            }
            if (currentConversionType == 'o') {
                result.append(Long.toOctalString(value));
            } else {
                result.append(Long.toHexString(value));
            }
        }

        return padding(result, startIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.068 -0500", hash_original_method = "15D0DEB8422EE33E04C98AFC872D1D51", hash_generated_method = "0A8BBCB7E1E7FFF5E2CABF84DA3F9F81")
    
private CharSequence transformFromNull() {
        formatToken.flagZero = false;
        return padding("null", 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.071 -0500", hash_original_method = "28740AE89E2FC451EFE3093F54121A6C", hash_generated_method = "F6AA55727746C890E01D16D469CE5C7E")
    
private CharSequence transformFromBigInteger() {
        int startIndex = 0;
        StringBuilder result = new StringBuilder();
        BigInteger bigInt = (BigInteger) arg;
        char currentConversionType = formatToken.getConversionType();

        if (bigInt == null) {
            return transformFromNull();
        }

        boolean isNegative = (bigInt.compareTo(BigInteger.ZERO) < 0);

        if (currentConversionType == 'd') {
            CharSequence digits = bigInt.toString(10);
            if (formatToken.flagComma) {
                digits = insertGrouping(digits);
            }
            result.append(digits);
        } else if (currentConversionType == 'o') {
            // convert BigInteger to a string presentation using radix 8
            result.append(bigInt.toString(8));
        } else {
            // convert BigInteger to a string presentation using radix 16
            result.append(bigInt.toString(16));
        }
        if (formatToken.flagSharp) {
            startIndex = isNegative ? 1 : 0;
            if (currentConversionType == 'o') {
                result.insert(startIndex, "0");
                startIndex += 1;
            } else if (currentConversionType == 'x' || currentConversionType == 'X') {
                result.insert(startIndex, "0x");
                startIndex += 2;
            }
        }

        if (!isNegative) {
            if (formatToken.flagPlus) {
                result.insert(0, '+');
                startIndex += 1;
            }
            if (formatToken.flagSpace) {
                result.insert(0, ' ');
                startIndex += 1;
            }
        }

        /* pad paddingChar to the output */
        if (isNegative && formatToken.flagParenthesis) {
            return wrapParentheses(result);
        }
        if (isNegative && formatToken.flagZero) {
            startIndex++;
        }
        return padding(result, startIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.074 -0500", hash_original_method = "3FA485DEFE055FA59E9A89B7029B3055", hash_generated_method = "76673F0D4EE450FC95EB14E624A75410")
    
private CharSequence transformFromDateTime() {
        if (arg == null) {
            return transformFromNull();
        }

        Calendar calendar;
        if (arg instanceof Calendar) {
            calendar = (Calendar) arg;
        } else {
            Date date = null;
            if (arg instanceof Long) {
                date = new Date(((Long) arg).longValue());
            } else if (arg instanceof Date) {
                date = (Date) arg;
            } else {
                throw badArgumentType();
            }
            calendar = Calendar.getInstance(locale);
            calendar.setTime(date);
        }

        StringBuilder result = new StringBuilder();
        if (!appendT(result, formatToken.getDateSuffix(), calendar)) {
            throw formatToken.unknownFormatConversionException();
        }
        return padding(result, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.079 -0500", hash_original_method = "6A85D50A5F6F83B5DE3D767D1CCF3B76", hash_generated_method = "E37C4EEDCFB4D6691204CCD9A1D97C2B")
    
private boolean appendT(StringBuilder result, char conversion, Calendar calendar) {
        switch (conversion) {
        case 'A':
            result.append(localeData.longWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
            return true;
        case 'a':
            result.append(localeData.shortWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
            return true;
        case 'B':
            result.append(localeData.longMonthNames[calendar.get(Calendar.MONTH)]);
            return true;
        case 'b': case 'h':
            result.append(localeData.shortMonthNames[calendar.get(Calendar.MONTH)]);
            return true;
        case 'C':
            appendLocalized(result, calendar.get(Calendar.YEAR) / 100, 2);
            return true;
        case 'D':
            appendT(result, 'm', calendar);
            result.append('/');
            appendT(result, 'd', calendar);
            result.append('/');
            appendT(result, 'y', calendar);
            return true;
        case 'F':
            appendT(result, 'Y', calendar);
            result.append('-');
            appendT(result, 'm', calendar);
            result.append('-');
            appendT(result, 'd', calendar);
            return true;
        case 'H':
            appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 2);
            return true;
        case 'I':
            appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 2);
            return true;
        case 'L':
            appendLocalized(result, calendar.get(Calendar.MILLISECOND), 3);
            return true;
        case 'M':
            appendLocalized(result, calendar.get(Calendar.MINUTE), 2);
            return true;
        case 'N':
            appendLocalized(result, calendar.get(Calendar.MILLISECOND) * 1000000L, 9);
            return true;
        case 'Q':
            appendLocalized(result, calendar.getTimeInMillis(), 0);
            return true;
        case 'R':
            appendT(result, 'H', calendar);
            result.append(':');
            appendT(result, 'M', calendar);
            return true;
        case 'S':
            appendLocalized(result, calendar.get(Calendar.SECOND), 2);
            return true;
        case 'T':
            appendT(result, 'H', calendar);
            result.append(':');
            appendT(result, 'M', calendar);
            result.append(':');
            appendT(result, 'S', calendar);
            return true;
        case 'Y':
            appendLocalized(result, calendar.get(Calendar.YEAR), 4);
            return true;
        case 'Z':
            TimeZone timeZone = calendar.getTimeZone();
            result.append(timeZone.getDisplayName(timeZone.inDaylightTime(calendar.getTime()),
                    TimeZone.SHORT, locale));
            return true;
        case 'c':
            appendT(result, 'a', calendar);
            result.append(' ');
            appendT(result, 'b', calendar);
            result.append(' ');
            appendT(result, 'd', calendar);
            result.append(' ');
            appendT(result, 'T', calendar);
            result.append(' ');
            appendT(result, 'Z', calendar);
            result.append(' ');
            appendT(result, 'Y', calendar);
            return true;
        case 'd':
            appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 2);
            return true;
        case 'e':
            appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 0);
            return true;
        case 'j':
            appendLocalized(result, calendar.get(Calendar.DAY_OF_YEAR), 3);
            return true;
        case 'k':
            appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 0);
            return true;
        case 'l':
            appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 0);
            return true;
        case 'm':
            // Calendar.JANUARY is 0; humans want January represented as 1.
            appendLocalized(result, calendar.get(Calendar.MONTH) + 1, 2);
            return true;
        case 'p':
            result.append(localeData.amPm[calendar.get(Calendar.AM_PM)].toLowerCase(locale));
            return true;
        case 'r':
            appendT(result, 'I', calendar);
            result.append(':');
            appendT(result, 'M', calendar);
            result.append(':');
            appendT(result, 'S', calendar);
            result.append(' ');
            result.append(localeData.amPm[calendar.get(Calendar.AM_PM)]);
            return true;
        case 's':
            appendLocalized(result, calendar.getTimeInMillis() / 1000, 0);
            return true;
        case 'y':
            appendLocalized(result, calendar.get(Calendar.YEAR) % 100, 2);
            return true;
        case 'z':
            long offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
            char sign = '+';
            if (offset < 0) {
                sign = '-';
                offset = -offset;
            }
            result.append(sign);
            appendLocalized(result, offset / 3600000, 2);
            appendLocalized(result, (offset % 3600000) / 60000, 2);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.081 -0500", hash_original_method = "07C369462F22245026E1280008B34AEC", hash_generated_method = "88D3F2B05C061151E69206A2ED2DA3E8")
    
private int to12Hour(int hour) {
        return hour == 0 ? 12 : hour;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.084 -0500", hash_original_method = "60B30B4DC0B127EF94D361BC9EB2AF90", hash_generated_method = "3F42CCC2826A012E928DEBCDFC044B21")
    
private void appendLocalized(StringBuilder result, long value, int width) {
        int paddingIndex = result.length();
        char zeroDigit = localeData.zeroDigit;
        if (zeroDigit == '0') {
            result.append(value);
        } else {
            result.append(localizeDigits(Long.toString(value)));
        }
        int zeroCount = width - (result.length() - paddingIndex);
        if (zeroCount <= 0) {
            return;
        }
        if (zeroDigit == '0') {
            result.insert(paddingIndex, ZEROS, 0, zeroCount);
        } else {
            for (int i = 0; i < zeroCount; ++i) {
                result.insert(paddingIndex, zeroDigit);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.087 -0500", hash_original_method = "977B62B975352D4F075C1101DB18FB73", hash_generated_method = "1B297E1F6EAC53366C4B69EA4AD51576")
    
private CharSequence transformFromSpecialNumber(double d) {
        String source = null;
        if (Double.isNaN(d)) {
            source = "NaN";
        } else if (d == Double.POSITIVE_INFINITY) {
            if (formatToken.flagPlus) {
                source = "+Infinity";
            } else if (formatToken.flagSpace) {
                source = " Infinity";
            } else {
                source = "Infinity";
            }
        } else if (d == Double.NEGATIVE_INFINITY) {
            if (formatToken.flagParenthesis) {
                source = "(Infinity)";
            } else {
                source = "-Infinity";
            }
        } else {
            return null;
        }

        formatToken.setPrecision(FormatToken.UNSET);
        formatToken.flagZero = false;
        return padding(source, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.091 -0500", hash_original_method = "DECF7ECF8109F764E81E2CF8101BCB0C", hash_generated_method = "4A099C0072244A8B089AEB8E542AF738")
    
private CharSequence transformFromFloat() {
        if (arg == null) {
            return transformFromNull();
        } else if (arg instanceof Float || arg instanceof Double) {
            Number number = (Number) arg;
            double d = number.doubleValue();
            if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
                return transformFromSpecialNumber(d);
            }
        } else if (arg instanceof BigDecimal) {
            // BigDecimal can't represent NaN or infinities, but its doubleValue method will return
            // infinities if the BigDecimal is too big for a double.
        } else {
            throw badArgumentType();
        }

        char conversionType = formatToken.getConversionType();
        if (conversionType != 'a' && conversionType != 'A' && !formatToken.isPrecisionSet()) {
            formatToken.setPrecision(FormatToken.DEFAULT_PRECISION);
        }

        StringBuilder result = new StringBuilder();
        switch (conversionType) {
        case 'a': case 'A':
            transformA(result);
            break;
        case 'e': case 'E':
            transformE(result);
            break;
        case 'f':
            transformF(result);
            break;
        case 'g':
        case 'G':
            transformG(result);
            break;
        default:
            throw formatToken.unknownFormatConversionException();
        }

        formatToken.setPrecision(FormatToken.UNSET);

        int startIndex = 0;
        if (result.charAt(0) == localeData.minusSign) {
            if (formatToken.flagParenthesis) {
                return wrapParentheses(result);
            }
        } else {
            if (formatToken.flagSpace) {
                result.insert(0, ' ');
                startIndex++;
            }
            if (formatToken.flagPlus) {
                result.insert(0, '+');
                startIndex++;
            }
        }

        char firstChar = result.charAt(0);
        if (formatToken.flagZero && (firstChar == '+' || firstChar == localeData.minusSign)) {
            startIndex = 1;
        }

        if (conversionType == 'a' || conversionType == 'A') {
            startIndex += 2;
        }
        return padding(result, startIndex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.094 -0500", hash_original_method = "43DA2A76094CCA7D42287B4466035D61", hash_generated_method = "C71E3720A0C279CDA790F6C54C55F2CD")
    
private void transformE(StringBuilder result) {
        // All zeros in this method are *pattern* characters, so no localization.
        final int precision = formatToken.getPrecision();
        String pattern = "0E+00";
        if (precision > 0) {
            StringBuilder sb = new StringBuilder("0.");
            char[] zeros = new char[precision];
            Arrays.fill(zeros, '0');
            sb.append(zeros);
            sb.append("E+00");
            pattern = sb.toString();
        }

        NativeDecimalFormat nf = getDecimalFormat(pattern);
        char[] chars;
        if (arg instanceof BigDecimal) {
            chars = nf.formatBigDecimal((BigDecimal) arg, null);
        } else {
            chars = nf.formatDouble(((Number) arg).doubleValue(), null);
        }
        // Unlike %f, %e uses 'e' (regardless of what the DecimalFormatSymbols would have us use).
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == 'E') {
                chars[i] = 'e';
            }
        }
        result.append(chars);
        // The # flag requires that we always output a decimal separator.
        if (formatToken.flagSharp && precision == 0) {
            int indexOfE = result.indexOf("e");
            result.insert(indexOfE, localeData.decimalSeparator);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.097 -0500", hash_original_method = "1973123C0DFAE44325340FD650EA833E", hash_generated_method = "F20BDA7075602500B17127ABA27240FD")
    
private void transformG(StringBuilder result) {
        int precision = formatToken.getPrecision();
        if (precision == 0) {
            precision = 1;
        }
        formatToken.setPrecision(precision);

        double d = ((Number) arg).doubleValue();
        if (d == 0.0) {
            precision--;
            formatToken.setPrecision(precision);
            transformF(result);
            return;
        }

        boolean requireScientificRepresentation = true;
        d = Math.abs(d);
        if (Double.isInfinite(d)) {
            precision = formatToken.getPrecision();
            precision--;
            formatToken.setPrecision(precision);
            transformE(result);
            return;
        }
        BigDecimal b = new BigDecimal(d, new MathContext(precision));
        d = b.doubleValue();
        long l = b.longValue();

        if (d >= 1 && d < Math.pow(10, precision)) {
            if (l < Math.pow(10, precision)) {
                requireScientificRepresentation = false;
                precision -= String.valueOf(l).length();
                precision = precision < 0 ? 0 : precision;
                l = Math.round(d * Math.pow(10, precision + 1));
                if (String.valueOf(l).length() <= formatToken.getPrecision()) {
                    precision++;
                }
                formatToken.setPrecision(precision);
            }
        } else {
            l = b.movePointRight(4).longValue();
            if (d >= Math.pow(10, -4) && d < 1) {
                requireScientificRepresentation = false;
                precision += 4 - String.valueOf(l).length();
                l = b.movePointRight(precision + 1).longValue();
                if (String.valueOf(l).length() <= formatToken.getPrecision()) {
                    precision++;
                }
                l = b.movePointRight(precision).longValue();
                if (l >= Math.pow(10, precision - 4)) {
                    formatToken.setPrecision(precision);
                }
            }
        }
        if (requireScientificRepresentation) {
            precision = formatToken.getPrecision();
            precision--;
            formatToken.setPrecision(precision);
            transformE(result);
        } else {
            transformF(result);
        }
    }

    
    public enum BigDecimalLayoutForm {
        SCIENTIFIC,
        DECIMAL_FLOAT
    }

    
    private static class CachedDecimalFormat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.850 -0500", hash_original_field = "3879AF6134847E75DC69FA81FC5E83C6", hash_generated_field = "57B03D121D93C35DC4CD446F8684FFFD")

        public NativeDecimalFormat decimalFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.852 -0500", hash_original_field = "EAE6F170545439F96DE104C8054F4EA7", hash_generated_field = "F1A921FEF7693E6D4DF1F57B4D8F992B")

        public LocaleData currentLocaleData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.854 -0500", hash_original_field = "45EC74D885BDE93DF733724B2AA3F074", hash_generated_field = "79B878750A67D50688DF69A25D47682C")

        public String currentPattern;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.857 -0500", hash_original_method = "3AB4302EBBD3C6ECF16B79A91E887CC6", hash_generated_method = "AA87D92A8081D9CB1A65F0D0ED37AE83")
        
public CachedDecimalFormat() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.860 -0500", hash_original_method = "784B3214258603820EA00D340F6FA563", hash_generated_method = "1CEA59D578CB0BC70F6D326AE69028BA")
        
public NativeDecimalFormat update(LocaleData localeData, String pattern) {
            if (decimalFormat == null) {
                currentPattern = pattern;
                currentLocaleData = localeData;
                decimalFormat = new NativeDecimalFormat(currentPattern, currentLocaleData);
            }
            if (!pattern.equals(currentPattern)) {
                decimalFormat.applyPattern(pattern);
                currentPattern = pattern;
            }
            if (localeData != currentLocaleData) {
                decimalFormat.setDecimalFormatSymbols(localeData);
                currentLocaleData = localeData;
            }
            return decimalFormat;
        }

        
    }


    
    private static class FormatToken {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.942 -0500", hash_original_field = "1034ED376B9CE7AFECDABB8633010401", hash_generated_field = "1BAD064282D47A986023D9014C2CC686")

        static final int LAST_ARGUMENT_INDEX = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.944 -0500", hash_original_field = "5EC817CD37AD06221688220B9719F247", hash_generated_field = "DE29D11B6980854EC22F3C15E7DA3A93")


        static final int UNSET = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.947 -0500", hash_original_field = "6CC503CB3A4F59C7D268F53881C4E777", hash_generated_field = "6514D206AC3CB1872EE1D615A4517002")


        static final int FLAGS_UNSET = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.950 -0500", hash_original_field = "F283ED3480F93B27A62C2341EAE8BFC4", hash_generated_field = "5A822570BEDDD49CF98C09711A50F2C5")


        static final int DEFAULT_PRECISION = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.952 -0500", hash_original_field = "EC86762E8E6BAAC1FFDEC14B5366BAE7", hash_generated_field = "9C5453ECCDBB9489F68E15932C42DB5C")


        static final int FLAG_ZERO = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.954 -0500", hash_original_field = "1C8EE75F2FDF5A241BF584AA4E7F380A", hash_generated_field = "772417271F7F0BDFEA0E64414172A084")


        private int argIndex = UNSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.957 -0500", hash_original_field = "98479ABC53D035AE015748B6501BED19", hash_generated_field = "5FD21D85E4FA69DEC7ADDBE8881DD4B2")

        // and accessed via methods, but Android's JIT doesn't yet do a good job of such code.
        // Direct field access, on the other hand, is fast.
        boolean flagComma;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.959 -0500", hash_original_field = "84E0FE8767B1823F9BD483DE94C8D5B6", hash_generated_field = "84E0FE8767B1823F9BD483DE94C8D5B6")

        boolean flagMinus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.962 -0500", hash_original_field = "6268F94D7EC6432771FAC9A81C06B277", hash_generated_field = "6268F94D7EC6432771FAC9A81C06B277")

        boolean flagParenthesis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.964 -0500", hash_original_field = "B18F735AA5B0F0DABBD7E427068CC4C3", hash_generated_field = "B18F735AA5B0F0DABBD7E427068CC4C3")

        boolean flagPlus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.966 -0500", hash_original_field = "C720CA7CDB619DB58116FBA407D9470B", hash_generated_field = "C720CA7CDB619DB58116FBA407D9470B")

        boolean flagSharp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.968 -0500", hash_original_field = "A2EE573CAED7292D13BAD741251059A4", hash_generated_field = "A2EE573CAED7292D13BAD741251059A4")

        boolean flagSpace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.970 -0500", hash_original_field = "79C0F430E2F3E53D9DF49552E4733685", hash_generated_field = "79C0F430E2F3E53D9DF49552E4733685")

        boolean flagZero;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.972 -0500", hash_original_field = "00D05875EC9234EBE131D924AC26759B", hash_generated_field = "E9F667FE63992DF0A85E5D7A0685E01F")


        private char conversionType = (char) UNSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.975 -0500", hash_original_field = "221748B84F7BF298114DF8AA61DD5AC8", hash_generated_field = "6AC9B9E35F29643906A8717247B50CCB")

        private char dateSuffix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.978 -0500", hash_original_field = "B39FA5AC1459207963DD56309C47ED42", hash_generated_field = "1A5EEC185E39D6E54480D34E352CE283")


        private int precision = UNSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.980 -0500", hash_original_field = "B7FC249EC0A2F898360BE8AE0E32982A", hash_generated_field = "7F084C83D0F1982A47DE9354FC0CF9F1")

        private int width = UNSET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.982 -0500", hash_original_field = "AEE43FE2CE39E86D95015273C6643E7E", hash_generated_field = "0527ECB4D15D76D63A180FF8CBB184B2")


        private StringBuilder strFlags;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:08.346 -0400", hash_original_method = "98998A93ECCA1CEE378BE6F5FF82B45F", hash_generated_method = "98998A93ECCA1CEE378BE6F5FF82B45F")
        public FormatToken ()
        {
            //Synthesized constructor
        }

        // Tests whether there were no flags, no width, and no precision specified.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.985 -0500", hash_original_method = "A7B957B3122A1E0264F586D374F2E6B7", hash_generated_method = "A7B957B3122A1E0264F586D374F2E6B7")
        
boolean isDefault() {
            return !flagComma && !flagMinus && !flagParenthesis && !flagPlus && !flagSharp &&
                    !flagSpace && !flagZero && width == UNSET && precision == UNSET;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.987 -0500", hash_original_method = "A13969ECEC9F8D1C94EA6A52CDFB6E17", hash_generated_method = "A13969ECEC9F8D1C94EA6A52CDFB6E17")
        
boolean isPrecisionSet() {
            return precision != UNSET;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.989 -0500", hash_original_method = "3A74106121887CCA509F985D60DB5637", hash_generated_method = "3A74106121887CCA509F985D60DB5637")
        
int getArgIndex() {
            return argIndex;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.991 -0500", hash_original_method = "27CE41687BF54420F4C00D2CFB6A73FA", hash_generated_method = "27CE41687BF54420F4C00D2CFB6A73FA")
        
void setArgIndex(int index) {
            argIndex = index;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.994 -0500", hash_original_method = "40140C97EC91863535630C305615FEC1", hash_generated_method = "40140C97EC91863535630C305615FEC1")
        
int getWidth() {
            return width;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.996 -0500", hash_original_method = "5C954D9C93DF99E2E990960A3CC1749D", hash_generated_method = "5C954D9C93DF99E2E990960A3CC1749D")
        
void setWidth(int width) {
            this.width = width;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:44.998 -0500", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "71BCDCF9E73C85D95AB18BEF6635FA18")
        
int getPrecision() {
            return precision;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.000 -0500", hash_original_method = "7515FB19ACE3C47DEBBD3E8357F6915C", hash_generated_method = "7515FB19ACE3C47DEBBD3E8357F6915C")
        
void setPrecision(int precise) {
            this.precision = precise;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.003 -0500", hash_original_method = "837A02C50E03265F058B23775F6F6197", hash_generated_method = "837A02C50E03265F058B23775F6F6197")
        
String getStrFlags() {
            return (strFlags != null) ? strFlags.toString() : "";
        }

        /*
         * Sets qualified char as one of the flags. If the char is qualified,
         * sets it as a flag and returns true. Or else returns false.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.006 -0500", hash_original_method = "E6ACD7E32E6ABC5AE16C357DB8116DB3", hash_generated_method = "396D2A5658270F2187B86860C13278C8")
        
boolean setFlag(int ch) {
            boolean dupe = false;
            switch (ch) {
            case ',':
                dupe = flagComma;
                flagComma = true;
                break;
            case '-':
                dupe = flagMinus;
                flagMinus = true;
                break;
            case '(':
                dupe = flagParenthesis;
                flagParenthesis = true;
                break;
            case '+':
                dupe = flagPlus;
                flagPlus = true;
                break;
            case '#':
                dupe = flagSharp;
                flagSharp = true;
                break;
            case ' ':
                dupe = flagSpace;
                flagSpace = true;
                break;
            case '0':
                dupe = flagZero;
                flagZero = true;
                break;
            default:
                return false;
            }
            if (dupe) {
                // The RI documentation implies we're supposed to report all the flags, not just
                // the first duplicate, but the RI behaves the same as we do.
                throw new DuplicateFormatFlagsException(String.valueOf(ch));
            }
            if (strFlags == null) {
                strFlags = new StringBuilder(7); // There are seven possible flags.
            }
            strFlags.append((char) ch);
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.008 -0500", hash_original_method = "563B5213711441DEFA9BB3355CD61032", hash_generated_method = "563B5213711441DEFA9BB3355CD61032")
        
char getConversionType() {
            return conversionType;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.010 -0500", hash_original_method = "6C3279116A999B7A879305F448E4C7E6", hash_generated_method = "6C3279116A999B7A879305F448E4C7E6")
        
void setConversionType(char c) {
            conversionType = c;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.012 -0500", hash_original_method = "EE45DA1AFAF958B13872135C146745E9", hash_generated_method = "EE45DA1AFAF958B13872135C146745E9")
        
char getDateSuffix() {
            return dateSuffix;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.015 -0500", hash_original_method = "6F4F20E9A23952874C5B1A6A80E321B4", hash_generated_method = "6F4F20E9A23952874C5B1A6A80E321B4")
        
void setDateSuffix(char c) {
            dateSuffix = c;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.017 -0500", hash_original_method = "67F4DE623207C5AE23B919ACAD45AA0B", hash_generated_method = "67F4DE623207C5AE23B919ACAD45AA0B")
        
boolean requireArgument() {
            return conversionType != '%' && conversionType != 'n';
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.023 -0500", hash_original_method = "34D9D8688BA6BF211700F1E1A866C731", hash_generated_method = "6609DCC3599DEBEC4BE0FC7FE103CFB4")
        
void checkFlags(Object arg) {
            // Work out which flags are allowed.
            boolean allowComma = false;
            boolean allowMinus = true;
            boolean allowParenthesis = false;
            boolean allowPlus = false;
            boolean allowSharp = false;
            boolean allowSpace = false;
            boolean allowZero = false;
            // Precision and width?
            boolean allowPrecision = true;
            boolean allowWidth = true;
            // Argument?
            boolean allowArgument = true;
            switch (conversionType) {
            // Character and date/time.
            case 'c': case 'C': case 't': case 'T':
                // Only '-' is allowed.
                allowPrecision = false;
                break;

            // String.
            case 's': case 'S':
                if (arg instanceof Formattable) {
                    allowSharp = true;
                }
                break;

            // Floating point.
            case 'g': case 'G':
                allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
                break;
            case 'f':
                allowComma = allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
                break;
            case 'e': case 'E':
                allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
                break;
            case 'a': case 'A':
                allowPlus = allowSharp = allowSpace = allowZero = true;
                break;

            // Integral.
            case 'd':
                allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
                allowPrecision = false;
                break;
            case 'o': case 'x': case 'X':
                allowSharp = allowZero = true;
                if (arg == null || arg instanceof BigInteger) {
                    allowParenthesis = allowPlus = allowSpace = true;
                }
                allowPrecision = false;
                break;

            // Special.
            case 'n':
                // Nothing is allowed.
                allowMinus = false;
                allowArgument = allowPrecision = allowWidth = false;
                break;
            case '%':
                // The only flag allowed is '-', and no argument or precision is allowed.
                allowArgument = false;
                allowPrecision = false;
                break;

            // Booleans and hash codes.
            case 'b': case 'B': case 'h': case 'H':
                break;

            default:
                throw unknownFormatConversionException();
            }

            // Check for disallowed flags.
            String mismatch = null;
            if (!allowComma && flagComma) {
                mismatch = ",";
            } else if (!allowMinus && flagMinus) {
                mismatch = "-";
            } else if (!allowParenthesis && flagParenthesis) {
                mismatch = "(";
            } else if (!allowPlus && flagPlus) {
                mismatch = "+";
            } else if (!allowSharp && flagSharp) {
                mismatch = "#";
            } else if (!allowSpace && flagSpace) {
                mismatch = " ";
            } else if (!allowZero && flagZero) {
                mismatch = "0";
            }
            if (mismatch != null) {
                if (conversionType == 'n') {
                    // For no good reason, %n is a special case...
                    throw new IllegalFormatFlagsException(mismatch);
                } else {
                    throw new FormatFlagsConversionMismatchException(mismatch, conversionType);
                }
            }

            // Check for a missing width with flags that require a width.
            if ((flagMinus || flagZero) && width == UNSET) {
                throw new MissingFormatWidthException("-" + conversionType);
            }

            // Check that no-argument conversion types don't have an argument.
            // Note: the RI doesn't enforce this.
            if (!allowArgument && argIndex != UNSET) {
                throw new IllegalFormatFlagsException("%" + conversionType +
                        " doesn't take an argument");
            }

            // Check that we don't have a precision or width where they're not allowed.
            if (!allowPrecision && precision != UNSET) {
                throw new IllegalFormatPrecisionException(precision);
            }
            if (!allowWidth && width != UNSET) {
                throw new IllegalFormatWidthException(width);
            }

            // Some combinations make no sense...
            if (flagPlus && flagSpace) {
                throw new IllegalFormatFlagsException("the '+' and ' ' flags are incompatible");
            }
            if (flagMinus && flagZero) {
                throw new IllegalFormatFlagsException("the '-' and '0' flags are incompatible");
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.026 -0500", hash_original_method = "ECFEC3AA46FEEC6BDD34290E5303C5C1", hash_generated_method = "FEF8AA6699AA82B26868F57373733FC1")
        
public UnknownFormatConversionException unknownFormatConversionException() {
            if (conversionType == 't' || conversionType == 'T') {
                throw new UnknownFormatConversionException(String.format("%c%c",
                        conversionType, dateSuffix));
            }
            throw new UnknownFormatConversionException(String.valueOf(conversionType));
        }
    }


    
    private static class FormatSpecifierParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.106 -0500", hash_original_field = "9E5B91A51CAB853C854D305CDF095F62", hash_generated_field = "3AFBEC2146BDEA5BFCBD2772D27C43DD")

        private String format;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.108 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private int length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.111 -0500", hash_original_field = "DD436961B9F44559E20E98178E4FCC9C", hash_generated_field = "4DF8ED554EC7B2C7483518163DCC894C")


        private int startIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.113 -0500", hash_original_field = "D6F1C227CD4638FDFF82091176AFA0F7", hash_generated_field = "DDFC4038967415E2F22993ABFD9A3B3F")

        private int i;

        /**
         * Constructs a new parser for the given format string.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.116 -0500", hash_original_method = "2EAAE714EE0AE41BF39DBCA3F91B9104", hash_generated_method = "2EAAE714EE0AE41BF39DBCA3F91B9104")
        
FormatSpecifierParser(String format) {
            this.format = format;
            this.length = format.length();
        }

        /**
         * Returns a FormatToken representing the format specifier starting at 'offset'.
         * @param offset the first character after the '%'
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.118 -0500", hash_original_method = "F77740880648C3886F14C74FD023BD3A", hash_generated_method = "F77740880648C3886F14C74FD023BD3A")
        
FormatToken parseFormatToken(int offset) {
            this.startIndex = offset;
            this.i = offset;
            return parseArgumentIndexAndFlags(new FormatToken());
        }

        /**
         * Returns a string corresponding to the last format specifier that was parsed.
         * Used to construct error messages.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.120 -0500", hash_original_method = "7C388C74117CDF3E7844B526DC734D8C", hash_generated_method = "7C388C74117CDF3E7844B526DC734D8C")
        
String getFormatSpecifierText() {
            return format.substring(startIndex, i);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.124 -0500", hash_original_method = "6521B9C02DA744FF180556D39A74ED44", hash_generated_method = "18DD17E9C6A2CF56FCD457474B08DCAB")
        
private int peek() {
            return (i < length) ? format.charAt(i) : -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.126 -0500", hash_original_method = "F520742ED92EBACDB47FBF0D0B1F08F4", hash_generated_method = "FB586B6D773033594CB9B9A418252FB1")
        
private char advance() {
            if (i >= length) {
                throw unknownFormatConversionException();
            }
            return format.charAt(i++);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.128 -0500", hash_original_method = "DFAEBB829CC6A7AFE465DA1B9A0C1D5A", hash_generated_method = "6C6C5076F052DDBA953D8E7572AF6935")
        
private UnknownFormatConversionException unknownFormatConversionException() {
            throw new UnknownFormatConversionException(getFormatSpecifierText());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.131 -0500", hash_original_method = "AD27190704DEC79DF3778A7C88589CDF", hash_generated_method = "5CEBD63CE6C7946733AF18A640CA1812")
        
private FormatToken parseArgumentIndexAndFlags(FormatToken token) {
            // Parse the argument index, if there is one.
            int position = i;
            int ch = peek();
            if (Character.isDigit(ch)) {
                int number = nextInt();
                if (peek() == '$') {
                    // The number was an argument index.
                    advance(); // Swallow the '$'.
                    if (number == FormatToken.UNSET) {
                        throw new MissingFormatArgumentException(getFormatSpecifierText());
                    }
                    // k$ stands for the argument whose index is k-1 except that
                    // 0$ and 1$ both stand for the first element.
                    token.setArgIndex(Math.max(0, number - 1));
                } else {
                    if (ch == '0') {
                        // The digit zero is a format flag, so reparse it as such.
                        i = position;
                    } else {
                        // The number was a width. This means there are no flags to parse.
                        return parseWidth(token, number);
                    }
                }
            } else if (ch == '<') {
                token.setArgIndex(FormatToken.LAST_ARGUMENT_INDEX);
                advance();
            }

            // Parse the flags.
            while (token.setFlag(peek())) {
                advance();
            }

            // What comes next?
            ch = peek();
            if (Character.isDigit(ch)) {
                return parseWidth(token, nextInt());
            } else if (ch == '.') {
                return parsePrecision(token);
            } else {
                return parseConversionType(token);
            }
        }

        // We pass the width in because in some cases we've already parsed it.
        // (Because of the ambiguity between argument indexes and widths.)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.134 -0500", hash_original_method = "F4C6E47C7F58A93445972E2EDFDFCD5C", hash_generated_method = "C82FA8E638C638FFA5FB8F9E8A91716D")
        
private FormatToken parseWidth(FormatToken token, int width) {
            token.setWidth(width);
            int ch = peek();
            if (ch == '.') {
                return parsePrecision(token);
            } else {
                return parseConversionType(token);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.136 -0500", hash_original_method = "06DE93E908B11B43F41251F270A468F2", hash_generated_method = "AB1C210C060B3158DBC993FDB335183D")
        
private FormatToken parsePrecision(FormatToken token) {
            advance(); // Swallow the '.'.
            int ch = peek();
            if (Character.isDigit(ch)) {
                token.setPrecision(nextInt());
                return parseConversionType(token);
            } else {
                // The precision is required but not given by the format string.
                throw unknownFormatConversionException();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.139 -0500", hash_original_method = "779E7C7A9E24C2B8C7A984530163E241", hash_generated_method = "4599C3289A059E1AD2F02B5B9503BE85")
        
private FormatToken parseConversionType(FormatToken token) {
            char conversionType = advance(); // A conversion type is mandatory.
            token.setConversionType(conversionType);
            if (conversionType == 't' || conversionType == 'T') {
                char dateSuffix = advance(); // A date suffix is mandatory for 't' or 'T'.
                token.setDateSuffix(dateSuffix);
            }
            return token;
        }

        // Parses an integer (of arbitrary length, but typically just one digit).
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.142 -0500", hash_original_method = "ADF8322FF676CF5038257F50E4E4E6DC", hash_generated_method = "1E7FDC304C48728374EA176C6AE9E3A6")
        
private int nextInt() {
            long value = 0;
            while (i < length && Character.isDigit(format.charAt(i))) {
                value = 10 * value + (format.charAt(i++) - '0');
                if (value > Integer.MAX_VALUE) {
                    return failNextInt();
                }
            }
            return (int) value;
        }

        // Swallow remaining digits to resync our attempted parse, but return failure.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.144 -0500", hash_original_method = "F2814F47D4EB7F1D4CA24D9FE1C3918D", hash_generated_method = "7E2F5E84092B17E0458A7640B08C3898")
        
private int failNextInt() {
            while (Character.isDigit(peek())) {
                advance();
            }
            return FormatToken.UNSET;
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.100 -0500", hash_original_method = "DF70A96812FA1EE536149F6B5D8F4C45", hash_generated_method = "E3454FB5606CD94AE81394A56A815DC2")
    
private void transformF(StringBuilder result) {
        // All zeros in this method are *pattern* characters, so no localization.
        String pattern = "0.000000";
        final int precision = formatToken.getPrecision();
        if (formatToken.flagComma || precision != FormatToken.DEFAULT_PRECISION) {
            StringBuilder patternBuilder = new StringBuilder();
            if (formatToken.flagComma) {
                patternBuilder.append(',');
                int groupingSize = 3;
                char[] sharps = new char[groupingSize - 1];
                Arrays.fill(sharps, '#');
                patternBuilder.append(sharps);
            }
            patternBuilder.append('0');
            if (precision > 0) {
                patternBuilder.append('.');
                for (int i = 0; i < precision; ++i) {
                    patternBuilder.append('0');
                }
            }
            pattern = patternBuilder.toString();
        }

        NativeDecimalFormat nf = getDecimalFormat(pattern);
        if (arg instanceof BigDecimal) {
            result.append(nf.formatBigDecimal((BigDecimal) arg, null));
        } else {
            result.append(nf.formatDouble(((Number) arg).doubleValue(), null));
        }
        // The # flag requires that we always output a decimal separator.
        if (formatToken.flagSharp && precision == 0) {
            result.append(localeData.decimalSeparator);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:45.103 -0500", hash_original_method = "DCC3844221755C0C14FA659BF8647E6B", hash_generated_method = "2746D41A3817A710906CF6A8008697C0")
    
private void transformA(StringBuilder result) {
        if (arg instanceof Float) {
            result.append(Float.toHexString(((Float) arg).floatValue()));
        } else if (arg instanceof Double) {
            result.append(Double.toHexString(((Double) arg).doubleValue()));
        } else {
            throw badArgumentType();
        }

        if (!formatToken.isPrecisionSet()) {
            return;
        }

        int precision = formatToken.getPrecision();
        if (precision == 0) {
            precision = 1;
        }
        int indexOfFirstFractionalDigit = result.indexOf(".") + 1;
        int indexOfP = result.indexOf("p");
        int fractionalLength = indexOfP - indexOfFirstFractionalDigit;

        if (fractionalLength == precision) {
            return;
        }

        if (fractionalLength < precision) {
            char[] zeros = new char[precision - fractionalLength];
            Arrays.fill(zeros, '0'); // %a shouldn't be localized.
            result.insert(indexOfP, zeros);
            return;
        }
        result.delete(indexOfFirstFractionalDigit + precision, indexOfP);
    }
}

