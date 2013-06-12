package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    private static final char[] ZEROS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0' };
    private Appendable out;
    private Locale locale;
    private Object arg;
    private boolean closed = false;
    private FormatToken formatToken;
    private IOException lastIOException;
    private LocaleData localeData;
    private static final ThreadLocal<CachedDecimalFormat> cachedDecimalFormat = new ThreadLocal<CachedDecimalFormat>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.208 -0400", hash_original_method = "3BF85501572F336E7CB9026A6524A649", hash_generated_method = "A5A3D99741BAB7569B0058DCA5279DAC")
        @DSModeled(DSC.SAFE)
        @Override
        protected CachedDecimalFormat initialValue() {
            return (CachedDecimalFormat)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CachedDecimalFormat();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "776A8092D7EB6A8CE9FA3707C90FDC71", hash_generated_method = "A225AF77F890B90A56D0C6A1BB0BD5AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter() {
        this(new StringBuilder(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "C10A7E7C6014F1D5457B2868B8DDD5FA", hash_generated_method = "9946ECCF4A6B4DD946393C5A9E515A12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(Appendable a) {
        this(a, Locale.getDefault());
        dsTaint.addTaint(a.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "949ED46E62E9C1FD97345CAB1F572157", hash_generated_method = "A480C055EA151132D368D53103615F59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(Locale l) {
        this(new StringBuilder(), l);
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "731A0E308D6775F1250BD9086CA3748C", hash_generated_method = "3726A6BC7135098A40640DFFBF9B01DA")
    @DSModeled(DSC.SAFE)
    public Formatter(Appendable a, Locale l) {
        dsTaint.addTaint(a.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        {
            out = new StringBuilder();
        } //End block
        // ---------- Original Method ----------
        //if (a == null) {
            //out = new StringBuilder();
        //} else {
            //out = a;
        //}
        //locale = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "55110CB3A063CDDA9DDF2A6FEEDBC4D6", hash_generated_method = "E9AE57F2DCE853FF1AED9EF299ABC2C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        dsTaint.addTaint(fileName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "D05AE6CA9B3694824C73C0B398D66198", hash_generated_method = "D537880C6255204A4007101972F50F0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(String fileName, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new File(fileName), csn);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "106406A68116E4DC11358A25DB96C9D8", hash_generated_method = "E368DD53D823B2C2BC8BE9146ADA940E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(String fileName, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn, l);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "56C5088BBC7ACEBB0E3B42C5FC534A61", hash_generated_method = "E6CDAA38940DA3C761FE9B0F983D3BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "15C3BB1BBEBB7DA2B256558B7A83F1D2", hash_generated_method = "9A8E27C94AFB08B5265EF26512B6710F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(file, csn, Locale.getDefault());
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "11FC304A866A57AD6707E0AE5ACD74C6", hash_generated_method = "16BF38C4E29AFDB790E095ABF9B9C06F")
    @DSModeled(DSC.SAFE)
    public Formatter(File file, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(csn);
        FileOutputStream fout;
        fout = null;
        try 
        {
            fout = new FileOutputStream(file);
            out = new BufferedWriter(new OutputStreamWriter(fout, csn));
        } //End block
        catch (RuntimeException e)
        {
            IoUtils.closeQuietly(fout);
            throw e;
        } //End block
        catch (UnsupportedEncodingException e)
        {
            IoUtils.closeQuietly(fout);
            throw e;
        } //End block
        // ---------- Original Method ----------
        //FileOutputStream fout = null;
        //try {
            //fout = new FileOutputStream(file);
            //out = new BufferedWriter(new OutputStreamWriter(fout, csn));
        //} catch (RuntimeException e) {
            //IoUtils.closeQuietly(fout);
            //throw e;
        //} catch (UnsupportedEncodingException e) {
            //IoUtils.closeQuietly(fout);
            //throw e;
        //}
        //locale = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "18094D8509766CE6FC608D9540C5972B", hash_generated_method = "2A6ABDBFEEEC5F4B1D7ED33EB0BE610A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(OutputStream os) {
        dsTaint.addTaint(os.dsTaint);
        out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        locale = Locale.getDefault();
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        //locale = Locale.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "F6295FD9F7AB3AB7F721531D402E7F81", hash_generated_method = "F3F84147944E2D60B74D46B5F82FB279")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault());
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "339D31BAB557832A3B8A75EB377C0635", hash_generated_method = "80945AF5FA307C0FC9642E967FE7AA0C")
    @DSModeled(DSC.SAFE)
    public Formatter(OutputStream os, String csn, Locale l) throws UnsupportedEncodingException {
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(csn);
        out = new BufferedWriter(new OutputStreamWriter(os, csn));
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, csn));
        //locale = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "6A92C9283CC7B01627E24F0E27824A3B", hash_generated_method = "79DBAD96885223C04D2ED3472659F6AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(PrintStream ps) {
        dsTaint.addTaint(ps.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        locale = Locale.getDefault();
        // ---------- Original Method ----------
        //if (ps == null) {
            //throw new NullPointerException();
        //}
        //out = ps;
        //locale = Locale.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "9D62CCD9646FE324AC0FFA6EB7C17C6C", hash_generated_method = "5194E8A6F9A635DCB33F9268E7499E22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NativeDecimalFormat getDecimalFormat(String pattern) {
        dsTaint.addTaint(pattern);
        NativeDecimalFormat var05CD216C6F15BCB71649928EDE58E914_1001118866 = (cachedDecimalFormat.get().update(localeData, pattern));
        return (NativeDecimalFormat)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cachedDecimalFormat.get().update(localeData, pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "E3DA6A4C963B6E9187963221C571CEC2", hash_generated_method = "AECA585602FF685A94E2437841B75FB4")
    @DSModeled(DSC.SAFE)
    private void checkNotClosed() {
        {
            throw new FormatterClosedException();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new FormatterClosedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "B5A8A4A4A455286143E3BD4E75C6F0FE", hash_generated_method = "2918A0CCE0158B5A0B3CA25FAA628DF1")
    @DSModeled(DSC.SAFE)
    public Locale locale() {
        checkNotClosed();
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "D73A5BF8E95D39CBD6819B9B1AA13C8D", hash_generated_method = "013A1F5CB8D08F420ABB6DADCF2A6474")
    @DSModeled(DSC.SAFE)
    public Appendable out() {
        checkNotClosed();
        return (Appendable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.209 -0400", hash_original_method = "39CF8FB3A631311648D12D228411CE26", hash_generated_method = "7EA45DEC0ADB2812727685B96AC9E37C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        checkNotClosed();
        String var91AA98D26314697B1A25ED8404F7DE4C_1773143789 = (out.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "E9CBCF5548B5D691C8801114F0C41C59", hash_generated_method = "BCDB2AFE58ED9B0681599BD7B9E5AE50")
    @DSModeled(DSC.SAFE)
    public void flush() {
        checkNotClosed();
        {
            try 
            {
                ((Flushable) out).flush();
            } //End block
            catch (IOException e)
            {
                lastIOException = e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (out instanceof Flushable) {
            //try {
                //((Flushable) out).flush();
            //} catch (IOException e) {
                //lastIOException = e;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "16C1939C51EF65BBD0A872F925CE78BF", hash_generated_method = "8E0C2AFB5E4B9CB3C818CBEF561AACE4")
    @DSModeled(DSC.SAFE)
    public void close() {
        {
            closed = true;
            try 
            {
                {
                    ((Closeable) out).close();
                } //End block
            } //End block
            catch (IOException e)
            {
                lastIOException = e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!closed) {
            //closed = true;
            //try {
                //if (out instanceof Closeable) {
                    //((Closeable) out).close();
                //}
            //} catch (IOException e) {
                //lastIOException = e;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "83BE836CC85FD1AD0B3E6A7DC68B210B")
    @DSModeled(DSC.SAFE)
    public IOException ioException() {
        return (IOException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lastIOException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "EE9FCF62B0D200225753D8BA586AA3F5", hash_generated_method = "0892EB456A7D769EF04FD067A4A14615")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter format(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        Formatter var5B9D05694FA5D917B581106730AA8E29_2117286438 = (format(this.locale, format, args));
        return (Formatter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(this.locale, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "F45273151F6DD69ACB6CCC03C59753A4", hash_generated_method = "CE9634A36FB07454AA31DC335975C836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter format(Locale l, String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        Locale originalLocale;
        originalLocale = locale;
        try 
        {
            this.locale = (l == null ? Locale.US : l);
            this.localeData = LocaleData.get(locale);
            doFormat(format, args);
        } //End block
        finally 
        {
            this.locale = originalLocale;
        } //End block
        return (Formatter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Locale originalLocale = locale;
        //try {
            //this.locale = (l == null ? Locale.US : l);
            //this.localeData = LocaleData.get(locale);
            //doFormat(format, args);
        //} finally {
            //this.locale = originalLocale;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "960E24FB807777DEBBE8328729AF6A3F", hash_generated_method = "A57BFE28F2BE9465A4C122D4699D65D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doFormat(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        checkNotClosed();
        FormatSpecifierParser fsp;
        fsp = new FormatSpecifierParser(format);
        int currentObjectIndex;
        currentObjectIndex = 0;
        Object lastArgument;
        lastArgument = null;
        boolean hasLastArgumentSet;
        hasLastArgumentSet = false;
        int length;
        length = format.length();
        int i;
        i = 0;
        {
            int plainTextStart;
            plainTextStart = i;
            int nextPercent;
            nextPercent = format.indexOf('%', i);
            int plainTextEnd;
            plainTextEnd = length;
            plainTextEnd = nextPercent;
            {
                outputCharSequence(format, plainTextStart, plainTextEnd);
            } //End block
            i = plainTextEnd;
            {
                FormatToken token;
                token = fsp.parseFormatToken(i + 1);
                Object argument;
                argument = null;
                {
                    boolean var15437F24151F4B9BB4CF0F9304E51BA9_1357568498 = (token.requireArgument());
                    {
                        int index;
                        boolean varE3D8046091E4D6BBC992AF3D15742E1E_2112864008 = (token.getArgIndex() == FormatToken.UNSET);
                        index = currentObjectIndex++;
                        index = token.getArgIndex();
                        argument = getArgument(args, index, fsp, lastArgument, hasLastArgumentSet);
                        lastArgument = argument;
                        hasLastArgumentSet = true;
                    } //End block
                } //End collapsed parenthetic
                CharSequence substitution;
                substitution = transform(token, argument);
                {
                    outputCharSequence(substitution, 0, substitution.length());
                } //End block
                i = fsp.i;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "4A93F3F0DF6F4E45CC93AF5660722832", hash_generated_method = "5F6A42A72AB72244E73A6661F76B0CD8")
    @DSModeled(DSC.SAFE)
    private void outputCharSequence(CharSequence cs, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dsTaint.addTaint(cs);
        try 
        {
            out.append(cs, start, end);
        } //End block
        catch (IOException e)
        {
            lastIOException = e;
        } //End block
        // ---------- Original Method ----------
        //try {
            //out.append(cs, start, end);
        //} catch (IOException e) {
            //lastIOException = e;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.210 -0400", hash_original_method = "4EF20CF84298D39EE17983F53878C341", hash_generated_method = "8FD65D7819A8307EF7F631B08ABE89D2")
    @DSModeled(DSC.SAFE)
    private Object getArgument(Object[] args, int index, FormatSpecifierParser fsp,
            Object lastArgument, boolean hasLastArgumentSet) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(fsp.dsTaint);
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(hasLastArgumentSet);
        dsTaint.addTaint(lastArgument.dsTaint);
        if (DroidSafeAndroidRuntime.control){
            throw new MissingFormatArgumentException("<");
        } //End block
        if (DroidSafeAndroidRuntime.control){
            throw new MissingFormatArgumentException(fsp.getFormatSpecifierText());
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (index == FormatToken.LAST_ARGUMENT_INDEX && !hasLastArgumentSet) {
            //throw new MissingFormatArgumentException("<");
        //}
        //if (args == null) {
            //return null;
        //}
        //if (index >= args.length) {
            //throw new MissingFormatArgumentException(fsp.getFormatSpecifierText());
        //}
        //if (index == FormatToken.LAST_ARGUMENT_INDEX) {
            //return lastArgument;
        //}
        //return args[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.211 -0400", hash_original_method = "0237F1DF7BD7A386A4F4D1B44D43876F", hash_generated_method = "513E8A739FC9B11AB8E3312E81545434")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transform(FormatToken token, Object argument) {
        dsTaint.addTaint(argument.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        {
            boolean var774D16194421B6759CE7C28102870BC1_1146829979 = (token.isDefault());
            {
                {
                    Object var3AF4190693AD8752FD689B6D6C2F4FD0_1910284524 = (token.getConversionType());
                    //Begin case 's' 
                    {
                        CharSequence varF00D2AACA373F717945507CC159D3E81_90446132 = (arg.toString());
                    } //End block
                    //End case 's' 
                    //Begin case 'd' 
                    boolean needLocalizedDigits;
                    needLocalizedDigits = (localeData.zeroDigit != '0');
                    //End case 'd' 
                    //Begin case 'd' 
                    {
                        {
                            IntegralToString.appendInt((StringBuilder) out, ((Number) arg).intValue());
                        } //End block
                        {
                            IntegralToString.appendLong((StringBuilder) out, ((Long) arg).longValue());
                        } //End block
                    } //End block
                    //End case 'd' 
                    //Begin case 'd' 
                    {
                        String result;
                        result = arg.toString();
                        {
                            Object varC69EE22EAA81A122340C191FB6828A6C_1944798920 = (localizeDigits(result));
                        } //End flattened ternary
                    } //End block
                    //End case 'd' 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        formatToken.checkFlags(arg);
        CharSequence result;
        {
            Object var1A1A65DF413B75C3108F1920C1E23A5B_1031591033 = (token.getConversionType());
            //Begin case 'B' 'b' 
            result = transformFromBoolean();
            //End case 'B' 'b' 
            //Begin case 'H' 'h' 
            result = transformFromHashCode();
            //End case 'H' 'h' 
            //Begin case 'S' 's' 
            result = transformFromString();
            //End case 'S' 's' 
            //Begin case 'C' 'c' 
            result = transformFromCharacter();
            //End case 'C' 'c' 
            //Begin case 'd' 'o' 'x' 'X' 
            {
                result = transformFromBigInteger();
            } //End block
            {
                result = transformFromInteger();
            } //End block
            //End case 'd' 'o' 'x' 'X' 
            //Begin case 'A' 'a' 'E' 'e' 'f' 'G' 'g' 
            result = transformFromFloat();
            //End case 'A' 'a' 'E' 'e' 'f' 'G' 'g' 
            //Begin case '%' 
            result = transformFromPercent();
            //End case '%' 
            //Begin case 'n' 
            result = System.lineSeparator();
            //End case 'n' 
            //Begin case 't' 'T' 
            result = transformFromDateTime();
            //End case 't' 'T' 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) {
            	throw token.unknownFormatConversionException();
            }
            //End case default 
        } //End collapsed parenthetic
        {
            boolean var1DB4C6B053C2BBEFBDA3D42D86D066E6_1975584659 = (Character.isUpperCase(token.getConversionType()));
            {
                {
                    result = result.toString().toUpperCase(locale);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.211 -0400", hash_original_method = "D44F27ADB431306CEB9F9E1F25036901", hash_generated_method = "0F25791C21BC6BB10333CAF052888EB3")
    @DSModeled(DSC.SAFE)
    private IllegalFormatConversionException badArgumentType() {
        if (DroidSafeAndroidRuntime.control) {
        	throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
        }
        return (IllegalFormatConversionException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.211 -0400", hash_original_method = "8CD3AC57424B332A3611698407D98FD3", hash_generated_method = "2E4C81691F2A0C8B4A0A3E1BCAD99988")
    @DSModeled(DSC.SAFE)
    private CharSequence localizeDigits(CharSequence s) {
        dsTaint.addTaint(s);
        int length;
        length = s.length();
        int offsetToLocalizedDigits;
        offsetToLocalizedDigits = localeData.zeroDigit - '0';
        StringBuilder result;
        result = new StringBuilder(length);
        {
            int i;
            i = 0;
            {
                char ch;
                ch = s.charAt(i);
                {
                    ch += offsetToLocalizedDigits;
                } //End block
                result.append(ch);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int length = s.length();
        //int offsetToLocalizedDigits = localeData.zeroDigit - '0';
        //StringBuilder result = new StringBuilder(length);
        //for (int i = 0; i < length; ++i) {
            //char ch = s.charAt(i);
            //if (ch >= '0' && ch <= '9') {
                //ch += offsetToLocalizedDigits;
            //}
            //result.append(ch);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.211 -0400", hash_original_method = "CC3FF2DA7072A05A8664F97319F6C752", hash_generated_method = "9F9326D8752528D7EB2E629A5B885D1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence insertGrouping(CharSequence s) {
        dsTaint.addTaint(s);
        StringBuilder result;
        result = new StringBuilder(s.length() + s.length()/3);
        int digitsLength;
        digitsLength = s.length();
        int i;
        i = 0;
        {
            boolean var9A0E6F317753A236C52C55D585498BB1_1632990356 = (s.charAt(0) == '-');
            {
                --digitsLength;
                ++i;
                result.append('-');
            } //End block
        } //End collapsed parenthetic
        int headLength;
        headLength = digitsLength % 3;
        {
            headLength = 3;
        } //End block
        result.append(s, i, i + headLength);
        i += headLength;
        {
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_1051313013 = (i < s.length());
            i += 3;
            {
                result.append(localeData.groupingSeparator);
                result.append(s, i, i + 3);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(s.length() + s.length()/3);
        //int digitsLength = s.length();
        //int i = 0;
        //if (s.charAt(0) == '-') {
            //--digitsLength;
            //++i;
            //result.append('-');
        //}
        //int headLength = digitsLength % 3;
        //if (headLength == 0) {
            //headLength = 3;
        //}
        //result.append(s, i, i + headLength);
        //i += headLength;
        //for (; i < s.length(); i += 3) {
            //result.append(localeData.groupingSeparator);
            //result.append(s, i, i + 3);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.212 -0400", hash_original_method = "54F34C95EDCEEE411BD250D07A12E500", hash_generated_method = "EAB41ED2CE62CE31524A9C5C823461C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromBoolean() {
        CharSequence result;
        {
            result = arg.toString();
        } //End block
        {
            result = "false";
        } //End block
        {
            result = "true";
        } //End block
        CharSequence var011EA2072D70C65DC591519D0B53769C_936560111 = (padding(result, 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //CharSequence result;
        //if (arg instanceof Boolean) {
            //result = arg.toString();
        //} else if (arg == null) {
            //result = "false";
        //} else {
            //result = "true";
        //}
        //return padding(result, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.212 -0400", hash_original_method = "FEE63D21FF5AA7B8F21641D7D3CB6697", hash_generated_method = "5943F06A903780E7A2D2D85F13C462C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromHashCode() {
        CharSequence result;
        {
            result = "null";
        } //End block
        {
            result = Integer.toHexString(arg.hashCode());
        } //End block
        CharSequence var011EA2072D70C65DC591519D0B53769C_1873456045 = (padding(result, 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //CharSequence result;
        //if (arg == null) {
            //result = "null";
        //} else {
            //result = Integer.toHexString(arg.hashCode());
        //}
        //return padding(result, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.212 -0400", hash_original_method = "41FDF272148D1D909A3CC241D4F2B404", hash_generated_method = "3B0F09938BF28A42D03C0D503AA45563")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromString() {
        {
            int flags;
            flags = 0;
            {
                flags |= FormattableFlags.LEFT_JUSTIFY;
            } //End block
            {
                flags |= FormattableFlags.ALTERNATE;
            } //End block
            {
                boolean varE5047B2B0C3ABA50902192D0CF9C9641_2036862822 = (Character.isUpperCase(formatToken.getConversionType()));
                {
                    flags |= FormattableFlags.UPPERCASE;
                } //End block
            } //End collapsed parenthetic
            ((Formattable) arg).formatTo(this, flags, formatToken.getWidth(),
                    formatToken.getPrecision());
        } //End block
        CharSequence result;
        result = arg.toString();
        result = "null";
        CharSequence var011EA2072D70C65DC591519D0B53769C_1775772677 = (padding(result, 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (arg instanceof Formattable) {
            //int flags = 0;
            //if (formatToken.flagMinus) {
                //flags |= FormattableFlags.LEFT_JUSTIFY;
            //}
            //if (formatToken.flagSharp) {
                //flags |= FormattableFlags.ALTERNATE;
            //}
            //if (Character.isUpperCase(formatToken.getConversionType())) {
                //flags |= FormattableFlags.UPPERCASE;
            //}
            //((Formattable) arg).formatTo(this, flags, formatToken.getWidth(),
                    //formatToken.getPrecision());
            //return null;
        //}
        //CharSequence result = arg != null ? arg.toString() : "null";
        //return padding(result, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.212 -0400", hash_original_method = "78103310C8550D540C751775D2E73F1B", hash_generated_method = "27B43002CB379856E29CAEFF4722D748")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromCharacter() {
        {
            CharSequence var110FEB5E002D3B12E0D41B94578BEF77_835490569 = (padding("null", 0));
        } //End block
        {
            CharSequence var903E70783DB183030BB4031B6620F35A_225652798 = (padding(String.valueOf(arg), 0));
        } //End block
        {
            int codePoint;
            codePoint = ((Number) arg).intValue();
            {
                boolean var6F543C204E9C4F46177946447429AAE1_780567521 = (!Character.isValidCodePoint(codePoint));
                if (DroidSafeAndroidRuntime.control){
                    throw new IllegalFormatCodePointException(codePoint);
                } //End block
            } //End collapsed parenthetic
            CharSequence result;
            result = String.valueOf((char) codePoint);
            result = String.valueOf(Character.toChars(codePoint));
            CharSequence varD52663FB252B32832B0DD96BE06E99D2_102327229 = (padding(result, 0));
        } //End block
        if (DroidSafeAndroidRuntime.control){
            throw badArgumentType();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (arg == null) {
            //return padding("null", 0);
        //}
        //if (arg instanceof Character) {
            //return padding(String.valueOf(arg), 0);
        //} else if (arg instanceof Byte || arg instanceof Short || arg instanceof Integer) {
            //int codePoint = ((Number) arg).intValue();
            //if (!Character.isValidCodePoint(codePoint)) {
                //throw new IllegalFormatCodePointException(codePoint);
            //}
            //CharSequence result = (codePoint < Character.MIN_SUPPLEMENTARY_CODE_POINT)
                    //? String.valueOf((char) codePoint)
                    //: String.valueOf(Character.toChars(codePoint));
            //return padding(result, 0);
        //} else {
            //throw badArgumentType();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.212 -0400", hash_original_method = "1802F533F155B8AA49557FA5A74B7DBE", hash_generated_method = "B5DDDCA8DD66C5C093CA32F24E31B015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromPercent() {
        CharSequence var127E49E72FC3D889FEBDC11FC78B3E63_434715259 = (padding("%", 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return padding("%", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.212 -0400", hash_original_method = "EF7726D1BC858C4C5BDC40B9ACBD3ABF", hash_generated_method = "045FE335CB1994F753F84AC61BA55292")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence padding(CharSequence source, int startIndex) {
        dsTaint.addTaint(startIndex);
        dsTaint.addTaint(source);
        int start;
        start = startIndex;
        int width;
        width = formatToken.getWidth();
        int precision;
        precision = formatToken.getPrecision();
        int length;
        length = source.length();
        {
            length = Math.min(length, precision);
            {
                ((StringBuilder) source).setLength(length);
            } //End block
            {
                source = source.subSequence(0, length);
            } //End block
        } //End block
        {
            width = Math.max(source.length(), width);
        } //End block
        char paddingChar;
        paddingChar = '\u0020';
        {
            {
                boolean var5580C15E55C4240F2395BB7B30D9E99A_1824687900 = (formatToken.getConversionType() == 'd');
                {
                    paddingChar = localeData.zeroDigit;
                } //End block
                {
                    paddingChar = '0';
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            start = 0;
        } //End block
        char[] paddingChars;
        paddingChars = new char[width - length];
        Arrays.fill(paddingChars, paddingChar);
        boolean paddingRight;
        paddingRight = formatToken.flagMinus;
        StringBuilder result;
        result = toStringBuilder(source);
        {
            result.append(paddingChars);
        } //End block
        {
            result.insert(start, paddingChars);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.212 -0400", hash_original_method = "AA67EEFB247ACC7BDA1BABCD03B30A80", hash_generated_method = "AE8F27CBACB95CB3B40C26E04C8FDC52")
    @DSModeled(DSC.SAFE)
    private StringBuilder toStringBuilder(CharSequence cs) {
        dsTaint.addTaint(cs);
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.213 -0400", hash_original_method = "CE1A2CC9741A13D14659E3953A660AC1", hash_generated_method = "DDA0F95F155B85372792F6FF0551BCF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringBuilder wrapParentheses(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        result.setCharAt(0, '(');
        {
            formatToken.setWidth(formatToken.getWidth() - 1);
            result = (StringBuilder) padding(result, 1);
            result.append(')');
        } //End block
        {
            result.append(')');
            result = (StringBuilder) padding(result, 0);
        } //End block
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //result.setCharAt(0, '(');
        //if (formatToken.flagZero) {
            //formatToken.setWidth(formatToken.getWidth() - 1);
            //result = (StringBuilder) padding(result, 1);
            //result.append(')');
        //} else {
            //result.append(')');
            //result = (StringBuilder) padding(result, 0);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.213 -0400", hash_original_method = "FADDE3D8C4FA639F028B03B661D10023", hash_generated_method = "84D344060E3C408CB5649B5BB604DE5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromInteger() {
        int startIndex;
        startIndex = 0;
        StringBuilder result;
        result = new StringBuilder();
        char currentConversionType;
        currentConversionType = formatToken.getConversionType();
        long value;
        {
            value = ((Long) arg).longValue();
        } //End block
        {
            value = ((Integer) arg).longValue();
        } //End block
        {
            value = ((Short) arg).longValue();
        } //End block
        {
            value = ((Byte) arg).longValue();
        } //End block
        if (DroidSafeAndroidRuntime.control){
            throw badArgumentType();
        } //End block
        {
            {
                result.append("0");
                startIndex += 1;
            } //End block
            {
                result.append("0x");
                startIndex += 2;
            } //End block
        } //End block
        {
            CharSequence digits;
            digits = Long.toString(value);
            {
                digits = insertGrouping(digits);
            } //End block
            {
                digits = localizeDigits(digits);
            } //End block
            result.append(digits);
            {
                {
                    CharSequence var55C578ADD9A87615405C43B1C9B54B88_504349823 = (wrapParentheses(result));
                } //End block
                {
                    startIndex++;
                } //End block
            } //End block
            {
                {
                    result.insert(0, '+');
                    startIndex += 1;
                } //End block
                {
                    result.insert(0, ' ');
                    startIndex += 1;
                } //End block
            } //End block
        } //End block
        {
            {
                value &= 0xffL;
            } //End block
            {
                value &= 0xffffL;
            } //End block
            {
                value &= 0xffffffffL;
            } //End block
            {
                result.append(Long.toOctalString(value));
            } //End block
            {
                result.append(Long.toHexString(value));
            } //End block
        } //End block
        CharSequence var906C8D50B58AEBD50FC57EA01B63F94A_1427459493 = (padding(result, startIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.213 -0400", hash_original_method = "15D0DEB8422EE33E04C98AFC872D1D51", hash_generated_method = "FBC36849817479EDEEACEFBC9DF9E0E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromNull() {
        formatToken.flagZero = false;
        CharSequence varCF816A8169468B94C535E94A88F96752_1426921888 = (padding("null", 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //formatToken.flagZero = false;
        //return padding("null", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.213 -0400", hash_original_method = "28740AE89E2FC451EFE3093F54121A6C", hash_generated_method = "0096294700FC4E433CAA64878CA6A5CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromBigInteger() {
        int startIndex;
        startIndex = 0;
        StringBuilder result;
        result = new StringBuilder();
        BigInteger bigInt;
        bigInt = (BigInteger) arg;
        char currentConversionType;
        currentConversionType = formatToken.getConversionType();
        {
            CharSequence var05F215AB109523D2CFEFFC669E706EC0_1745850761 = (transformFromNull());
        } //End block
        boolean isNegative;
        isNegative = (bigInt.compareTo(BigInteger.ZERO) < 0);
        {
            CharSequence digits;
            digits = bigInt.toString(10);
            {
                digits = insertGrouping(digits);
            } //End block
            result.append(digits);
        } //End block
        {
            result.append(bigInt.toString(8));
        } //End block
        {
            result.append(bigInt.toString(16));
        } //End block
        {
            startIndex = isNegative ? 1 : 0;
            {
                result.insert(startIndex, "0");
                startIndex += 1;
            } //End block
            {
                result.insert(startIndex, "0x");
                startIndex += 2;
            } //End block
        } //End block
        {
            {
                result.insert(0, '+');
                startIndex += 1;
            } //End block
            {
                result.insert(0, ' ');
                startIndex += 1;
            } //End block
        } //End block
        {
            CharSequence varF450D26DBF6E25E6530DAFE24CDB393B_1505775077 = (wrapParentheses(result));
        } //End block
        {
            startIndex++;
        } //End block
        CharSequence var906C8D50B58AEBD50FC57EA01B63F94A_1210029093 = (padding(result, startIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.214 -0400", hash_original_method = "3FA485DEFE055FA59E9A89B7029B3055", hash_generated_method = "83390D8AB291B70DD2B2301509FA8824")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromDateTime() {
        {
            CharSequence var05F215AB109523D2CFEFFC669E706EC0_327760412 = (transformFromNull());
        } //End block
        Calendar calendar;
        {
            calendar = (Calendar) arg;
        } //End block
        {
            Date date;
            date = null;
            {
                date = new Date(((Long) arg).longValue());
            } //End block
            {
                date = (Date) arg;
            } //End block
            if (DroidSafeAndroidRuntime.control){
                throw badArgumentType();
            } //End block
            calendar = Calendar.getInstance(locale);
            calendar.setTime(date);
        } //End block
        StringBuilder result;
        result = new StringBuilder();
        {
            boolean varCAB943A58957944F491BEB3F9C12AAC8_1807323917 = (!appendT(result, formatToken.getDateSuffix(), calendar));
            if (DroidSafeAndroidRuntime.control){
                throw formatToken.unknownFormatConversionException();
            } //End block
        } //End collapsed parenthetic
        CharSequence var011EA2072D70C65DC591519D0B53769C_1308727816 = (padding(result, 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (arg == null) {
            //return transformFromNull();
        //}
        //Calendar calendar;
        //if (arg instanceof Calendar) {
            //calendar = (Calendar) arg;
        //} else {
            //Date date = null;
            //if (arg instanceof Long) {
                //date = new Date(((Long) arg).longValue());
            //} else if (arg instanceof Date) {
                //date = (Date) arg;
            //} else {
                //throw badArgumentType();
            //}
            //calendar = Calendar.getInstance(locale);
            //calendar.setTime(date);
        //}
        //StringBuilder result = new StringBuilder();
        //if (!appendT(result, formatToken.getDateSuffix(), calendar)) {
            //throw formatToken.unknownFormatConversionException();
        //}
        //return padding(result, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.214 -0400", hash_original_method = "6A85D50A5F6F83B5DE3D767D1CCF3B76", hash_generated_method = "8B06A6E72C31E925457245BAAE7CE50E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean appendT(StringBuilder result, char conversion, Calendar calendar) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(conversion);
        dsTaint.addTaint(calendar.dsTaint);
        //Begin case 'A' 
        result.append(localeData.longWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
        //End case 'A' 
        //Begin case 'a' 
        result.append(localeData.shortWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
        //End case 'a' 
        //Begin case 'B' 
        result.append(localeData.longMonthNames[calendar.get(Calendar.MONTH)]);
        //End case 'B' 
        //Begin case 'b' 'h' 
        result.append(localeData.shortMonthNames[calendar.get(Calendar.MONTH)]);
        //End case 'b' 'h' 
        //Begin case 'C' 
        appendLocalized(result, calendar.get(Calendar.YEAR) / 100, 2);
        //End case 'C' 
        //Begin case 'D' 
        appendT(result, 'm', calendar);
        //End case 'D' 
        //Begin case 'D' 
        result.append('/');
        //End case 'D' 
        //Begin case 'D' 
        appendT(result, 'd', calendar);
        //End case 'D' 
        //Begin case 'D' 
        result.append('/');
        //End case 'D' 
        //Begin case 'D' 
        appendT(result, 'y', calendar);
        //End case 'D' 
        //Begin case 'F' 
        appendT(result, 'Y', calendar);
        //End case 'F' 
        //Begin case 'F' 
        result.append('-');
        //End case 'F' 
        //Begin case 'F' 
        appendT(result, 'm', calendar);
        //End case 'F' 
        //Begin case 'F' 
        result.append('-');
        //End case 'F' 
        //Begin case 'F' 
        appendT(result, 'd', calendar);
        //End case 'F' 
        //Begin case 'H' 
        appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 2);
        //End case 'H' 
        //Begin case 'I' 
        appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 2);
        //End case 'I' 
        //Begin case 'L' 
        appendLocalized(result, calendar.get(Calendar.MILLISECOND), 3);
        //End case 'L' 
        //Begin case 'M' 
        appendLocalized(result, calendar.get(Calendar.MINUTE), 2);
        //End case 'M' 
        //Begin case 'N' 
        appendLocalized(result, calendar.get(Calendar.MILLISECOND) * 1000000L, 9);
        //End case 'N' 
        //Begin case 'Q' 
        appendLocalized(result, calendar.getTimeInMillis(), 0);
        //End case 'Q' 
        //Begin case 'R' 
        appendT(result, 'H', calendar);
        //End case 'R' 
        //Begin case 'R' 
        result.append(':');
        //End case 'R' 
        //Begin case 'R' 
        appendT(result, 'M', calendar);
        //End case 'R' 
        //Begin case 'S' 
        appendLocalized(result, calendar.get(Calendar.SECOND), 2);
        //End case 'S' 
        //Begin case 'T' 
        appendT(result, 'H', calendar);
        //End case 'T' 
        //Begin case 'T' 
        result.append(':');
        //End case 'T' 
        //Begin case 'T' 
        appendT(result, 'M', calendar);
        //End case 'T' 
        //Begin case 'T' 
        result.append(':');
        //End case 'T' 
        //Begin case 'T' 
        appendT(result, 'S', calendar);
        //End case 'T' 
        //Begin case 'Y' 
        appendLocalized(result, calendar.get(Calendar.YEAR), 4);
        //End case 'Y' 
        //Begin case 'Z' 
        TimeZone timeZone;
        timeZone = calendar.getTimeZone();
        //End case 'Z' 
        //Begin case 'Z' 
        result.append(timeZone.getDisplayName(timeZone.inDaylightTime(calendar.getTime()),
                    TimeZone.SHORT, locale));
        //End case 'Z' 
        //Begin case 'c' 
        appendT(result, 'a', calendar);
        //End case 'c' 
        //Begin case 'c' 
        result.append(' ');
        //End case 'c' 
        //Begin case 'c' 
        appendT(result, 'b', calendar);
        //End case 'c' 
        //Begin case 'c' 
        result.append(' ');
        //End case 'c' 
        //Begin case 'c' 
        appendT(result, 'd', calendar);
        //End case 'c' 
        //Begin case 'c' 
        result.append(' ');
        //End case 'c' 
        //Begin case 'c' 
        appendT(result, 'T', calendar);
        //End case 'c' 
        //Begin case 'c' 
        result.append(' ');
        //End case 'c' 
        //Begin case 'c' 
        appendT(result, 'Z', calendar);
        //End case 'c' 
        //Begin case 'c' 
        result.append(' ');
        //End case 'c' 
        //Begin case 'c' 
        appendT(result, 'Y', calendar);
        //End case 'c' 
        //Begin case 'd' 
        appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 2);
        //End case 'd' 
        //Begin case 'e' 
        appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 0);
        //End case 'e' 
        //Begin case 'j' 
        appendLocalized(result, calendar.get(Calendar.DAY_OF_YEAR), 3);
        //End case 'j' 
        //Begin case 'k' 
        appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 0);
        //End case 'k' 
        //Begin case 'l' 
        appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 0);
        //End case 'l' 
        //Begin case 'm' 
        appendLocalized(result, calendar.get(Calendar.MONTH) + 1, 2);
        //End case 'm' 
        //Begin case 'p' 
        result.append(localeData.amPm[calendar.get(Calendar.AM_PM)].toLowerCase(locale));
        //End case 'p' 
        //Begin case 'r' 
        appendT(result, 'I', calendar);
        //End case 'r' 
        //Begin case 'r' 
        result.append(':');
        //End case 'r' 
        //Begin case 'r' 
        appendT(result, 'M', calendar);
        //End case 'r' 
        //Begin case 'r' 
        result.append(':');
        //End case 'r' 
        //Begin case 'r' 
        appendT(result, 'S', calendar);
        //End case 'r' 
        //Begin case 'r' 
        result.append(' ');
        //End case 'r' 
        //Begin case 'r' 
        result.append(localeData.amPm[calendar.get(Calendar.AM_PM)]);
        //End case 'r' 
        //Begin case 's' 
        appendLocalized(result, calendar.getTimeInMillis() / 1000, 0);
        //End case 's' 
        //Begin case 'y' 
        appendLocalized(result, calendar.get(Calendar.YEAR) % 100, 2);
        //End case 'y' 
        //Begin case 'z' 
        long offset;
        offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        //End case 'z' 
        //Begin case 'z' 
        char sign;
        sign = '+';
        //End case 'z' 
        //Begin case 'z' 
        {
            sign = '-';
            offset = -offset;
        } //End block
        //End case 'z' 
        //Begin case 'z' 
        result.append(sign);
        //End case 'z' 
        //Begin case 'z' 
        appendLocalized(result, offset / 3600000, 2);
        //End case 'z' 
        //Begin case 'z' 
        appendLocalized(result, (offset % 3600000) / 60000, 2);
        //End case 'z' 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.215 -0400", hash_original_method = "07C369462F22245026E1280008B34AEC", hash_generated_method = "E2FA041C5EF1ED732D9D8D5EF86A983D")
    @DSModeled(DSC.SAFE)
    private int to12Hour(int hour) {
        dsTaint.addTaint(hour);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hour == 0 ? 12 : hour;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.215 -0400", hash_original_method = "60B30B4DC0B127EF94D361BC9EB2AF90", hash_generated_method = "27885792DC6EC109DFA416D93FC0EE1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendLocalized(StringBuilder result, long value, int width) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(width);
        dsTaint.addTaint(value);
        int paddingIndex;
        paddingIndex = result.length();
        char zeroDigit;
        zeroDigit = localeData.zeroDigit;
        {
            result.append(value);
        } //End block
        {
            result.append(localizeDigits(Long.toString(value)));
        } //End block
        int zeroCount;
        zeroCount = width - (result.length() - paddingIndex);
        {
            result.insert(paddingIndex, ZEROS, 0, zeroCount);
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    result.insert(paddingIndex, zeroDigit);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //int paddingIndex = result.length();
        //char zeroDigit = localeData.zeroDigit;
        //if (zeroDigit == '0') {
            //result.append(value);
        //} else {
            //result.append(localizeDigits(Long.toString(value)));
        //}
        //int zeroCount = width - (result.length() - paddingIndex);
        //if (zeroCount <= 0) {
            //return;
        //}
        //if (zeroDigit == '0') {
            //result.insert(paddingIndex, ZEROS, 0, zeroCount);
        //} else {
            //for (int i = 0; i < zeroCount; ++i) {
                //result.insert(paddingIndex, zeroDigit);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.215 -0400", hash_original_method = "977B62B975352D4F075C1101DB18FB73", hash_generated_method = "FD658912BE74662A999A40ABD367C079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromSpecialNumber(double d) {
        dsTaint.addTaint(d);
        String source;
        source = null;
        {
            boolean varF573A637641E1AB21D698815AEB110FB_128668473 = (Double.isNaN(d));
            {
                source = "NaN";
            } //End block
            {
                {
                    source = "+Infinity";
                } //End block
                {
                    source = " Infinity";
                } //End block
                {
                    source = "Infinity";
                } //End block
            } //End block
            {
                {
                    source = "(Infinity)";
                } //End block
                {
                    source = "-Infinity";
                } //End block
            } //End block
        } //End collapsed parenthetic
        formatToken.setPrecision(FormatToken.UNSET);
        formatToken.flagZero = false;
        CharSequence var07592184B4EF7BE63898842D0E4CE6A9_2022336992 = (padding(source, 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String source = null;
        //if (Double.isNaN(d)) {
            //source = "NaN";
        //} else if (d == Double.POSITIVE_INFINITY) {
            //if (formatToken.flagPlus) {
                //source = "+Infinity";
            //} else if (formatToken.flagSpace) {
                //source = " Infinity";
            //} else {
                //source = "Infinity";
            //}
        //} else if (d == Double.NEGATIVE_INFINITY) {
            //if (formatToken.flagParenthesis) {
                //source = "(Infinity)";
            //} else {
                //source = "-Infinity";
            //}
        //} else {
            //return null;
        //}
        //formatToken.setPrecision(FormatToken.UNSET);
        //formatToken.flagZero = false;
        //return padding(source, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.215 -0400", hash_original_method = "DECF7ECF8109F764E81E2CF8101BCB0C", hash_generated_method = "EC78BE16894FAE1EC0649904FEB03223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromFloat() {
        {
            CharSequence var05F215AB109523D2CFEFFC669E706EC0_152449879 = (transformFromNull());
        } //End block
        {
            Number number;
            number = (Number) arg;
            double d;
            d = number.doubleValue();
            {
                CharSequence var10F0CDC0673B0075AE7109E074D3F683_2145869433 = (transformFromSpecialNumber(d));
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control){
            throw badArgumentType();
        } //End block
        char conversionType;
        conversionType = formatToken.getConversionType();
        {
            boolean var4D48FD270E3C43B43C7CAFA231E3C2A7_253946194 = (conversionType != 'a' && conversionType != 'A' && !formatToken.isPrecisionSet());
            {
                formatToken.setPrecision(FormatToken.DEFAULT_PRECISION);
            } //End block
        } //End collapsed parenthetic
        StringBuilder result;
        result = new StringBuilder();
        //Begin case 'a' 'A' 
        transformA(result);
        //End case 'a' 'A' 
        //Begin case 'e' 'E' 
        transformE(result);
        //End case 'e' 'E' 
        //Begin case 'f' 
        transformF(result);
        //End case 'f' 
        //Begin case 'g' 'G' 
        transformG(result);
        //End case 'g' 'G' 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) {
        	throw formatToken.unknownFormatConversionException();
        }
        //End case default 
        formatToken.setPrecision(FormatToken.UNSET);
        int startIndex;
        startIndex = 0;
        {
            boolean varC4FD83BCDCE254D147FDF9D7B3AC13AA_1109737732 = (result.charAt(0) == localeData.minusSign);
            {
                {
                    CharSequence var55C578ADD9A87615405C43B1C9B54B88_2029242955 = (wrapParentheses(result));
                } //End block
            } //End block
            {
                {
                    result.insert(0, ' ');
                    startIndex++;
                } //End block
                {
                    result.insert(0, '+');
                    startIndex++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        char firstChar;
        firstChar = result.charAt(0);
        {
            startIndex = 1;
        } //End block
        {
            startIndex += 2;
        } //End block
        CharSequence var906C8D50B58AEBD50FC57EA01B63F94A_1587325420 = (padding(result, startIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.216 -0400", hash_original_method = "43DA2A76094CCA7D42287B4466035D61", hash_generated_method = "6A4E63421755D0261999EC44043C077E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transformE(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        final int precision;
        precision = formatToken.getPrecision();
        String pattern;
        pattern = "0E+00";
        {
            StringBuilder sb;
            sb = new StringBuilder("0.");
            char[] zeros;
            zeros = new char[precision];
            Arrays.fill(zeros, '0');
            sb.append(zeros);
            sb.append("E+00");
            pattern = sb.toString();
        } //End block
        NativeDecimalFormat nf;
        nf = getDecimalFormat(pattern);
        char[] chars;
        {
            chars = nf.formatBigDecimal((BigDecimal) arg, null);
        } //End block
        {
            chars = nf.formatDouble(((Number) arg).doubleValue(), null);
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    chars[i] = 'e';
                } //End block
            } //End block
        } //End collapsed parenthetic
        result.append(chars);
        {
            int indexOfE;
            indexOfE = result.indexOf("e");
            result.insert(indexOfE, localeData.decimalSeparator);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.216 -0400", hash_original_method = "1973123C0DFAE44325340FD650EA833E", hash_generated_method = "64C47B3BEBB1ADDB514E390417FF2B9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transformG(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        int precision;
        precision = formatToken.getPrecision();
        {
            precision = 1;
        } //End block
        formatToken.setPrecision(precision);
        double d;
        d = ((Number) arg).doubleValue();
        {
            precision--;
            formatToken.setPrecision(precision);
            transformF(result);
        } //End block
        boolean requireScientificRepresentation;
        requireScientificRepresentation = true;
        d = Math.abs(d);
        {
            boolean var3ECD0EAFA593A6ADC1E4F46524942B82_466404998 = (Double.isInfinite(d));
            {
                precision = formatToken.getPrecision();
                precision--;
                formatToken.setPrecision(precision);
                transformE(result);
            } //End block
        } //End collapsed parenthetic
        BigDecimal b;
        b = new BigDecimal(d, new MathContext(precision));
        d = b.doubleValue();
        long l;
        l = b.longValue();
        {
            boolean var7952BAED570DF8211C40DB97D6C9494B_154364697 = (d >= 1 && d < Math.pow(10, precision));
            {
                {
                    boolean var6DA2CA6307083AFD29BF7C8CBC3D16A4_637502717 = (l < Math.pow(10, precision));
                    {
                        requireScientificRepresentation = false;
                        precision -= String.valueOf(l).length();
                        precision = precision < 0 ? 0 : precision;
                        l = Math.round(d * Math.pow(10, precision + 1));
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_1139814679 = (String.valueOf(l).length() <= formatToken.getPrecision());
                            {
                                precision++;
                            } //End block
                        } //End collapsed parenthetic
                        formatToken.setPrecision(precision);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                l = b.movePointRight(4).longValue();
                {
                    boolean varFC5D9BA1CE39DA4CE1D6C7B756E730FB_327366484 = (d >= Math.pow(10, -4) && d < 1);
                    {
                        requireScientificRepresentation = false;
                        precision += 4 - String.valueOf(l).length();
                        l = b.movePointRight(precision + 1).longValue();
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_2046846192 = (String.valueOf(l).length() <= formatToken.getPrecision());
                            {
                                precision++;
                            } //End block
                        } //End collapsed parenthetic
                        l = b.movePointRight(precision).longValue();
                        {
                            boolean var48F2D010DC481B7F6EDFA70502BAD5C5_1452358428 = (l >= Math.pow(10, precision - 4));
                            {
                                formatToken.setPrecision(precision);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            precision = formatToken.getPrecision();
            precision--;
            formatToken.setPrecision(precision);
            transformE(result);
        } //End block
        {
            transformF(result);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "DF70A96812FA1EE536149F6B5D8F4C45", hash_generated_method = "DA07C48B5FEE6FBB79DF5727363862C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transformF(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        String pattern;
        pattern = "0.000000";
        final int precision;
        precision = formatToken.getPrecision();
        {
            StringBuilder patternBuilder;
            patternBuilder = new StringBuilder();
            {
                patternBuilder.append(',');
                int groupingSize;
                groupingSize = 3;
                char[] sharps;
                sharps = new char[groupingSize - 1];
                Arrays.fill(sharps, '#');
                patternBuilder.append(sharps);
            } //End block
            patternBuilder.append('0');
            {
                patternBuilder.append('.');
                {
                    int i;
                    i = 0;
                    {
                        patternBuilder.append('0');
                    } //End block
                } //End collapsed parenthetic
            } //End block
            pattern = patternBuilder.toString();
        } //End block
        NativeDecimalFormat nf;
        nf = getDecimalFormat(pattern);
        {
            result.append(nf.formatBigDecimal((BigDecimal) arg, null));
        } //End block
        {
            result.append(nf.formatDouble(((Number) arg).doubleValue(), null));
        } //End block
        {
            result.append(localeData.decimalSeparator);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "DCC3844221755C0C14FA659BF8647E6B", hash_generated_method = "DAA12F1287F2745B7B091FE7280163FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transformA(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        {
            result.append(Float.toHexString(((Float) arg).floatValue()));
        } //End block
        {
            result.append(Double.toHexString(((Double) arg).doubleValue()));
        } //End block
        if (DroidSafeAndroidRuntime.control) {
            throw badArgumentType();
        } //End block
        {
            boolean var0BA49339344F3E46004E2C66FA171DC0_1468553327 = (!formatToken.isPrecisionSet());
        } //End collapsed parenthetic
        int precision;
        precision = formatToken.getPrecision();
        {
            precision = 1;
        } //End block
        int indexOfFirstFractionalDigit;
        indexOfFirstFractionalDigit = result.indexOf(".") + 1;
        int indexOfP;
        indexOfP = result.indexOf("p");
        int fractionalLength;
        fractionalLength = indexOfP - indexOfFirstFractionalDigit;
        {
            char[] zeros;
            zeros = new char[precision - fractionalLength];
            Arrays.fill(zeros, '0');
            result.insert(indexOfP, zeros);
        } //End block
        result.delete(indexOfFirstFractionalDigit + precision, indexOfP);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public enum BigDecimalLayoutForm {
        SCIENTIFIC,
        DECIMAL_FLOAT
    }

    
    private static class CachedDecimalFormat {
        public NativeDecimalFormat decimalFormat;
        public LocaleData currentLocaleData;
        public String currentPattern;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "3AB4302EBBD3C6ECF16B79A91E887CC6", hash_generated_method = "D4DDF875FBF459480BA94EBB8D8F4C7F")
        @DSModeled(DSC.SAFE)
        public CachedDecimalFormat() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "784B3214258603820EA00D340F6FA563", hash_generated_method = "B990D1B20E2FEE4A8F2CD597527B219C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NativeDecimalFormat update(LocaleData localeData, String pattern) {
            dsTaint.addTaint(localeData.dsTaint);
            dsTaint.addTaint(pattern);
            {
                decimalFormat = new NativeDecimalFormat(currentPattern, currentLocaleData);
            } //End block
            {
                boolean varC04205845392AD76FE20C5C34EA780FF_1405882467 = (!pattern.equals(currentPattern));
                {
                    decimalFormat.applyPattern(pattern);
                } //End block
            } //End collapsed parenthetic
            {
                decimalFormat.setDecimalFormatSymbols(localeData);
            } //End block
            return (NativeDecimalFormat)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (decimalFormat == null) {
                //currentPattern = pattern;
                //currentLocaleData = localeData;
                //decimalFormat = new NativeDecimalFormat(currentPattern, currentLocaleData);
            //}
            //if (!pattern.equals(currentPattern)) {
                //decimalFormat.applyPattern(pattern);
                //currentPattern = pattern;
            //}
            //if (localeData != currentLocaleData) {
                //decimalFormat.setDecimalFormatSymbols(localeData);
                //currentLocaleData = localeData;
            //}
            //return decimalFormat;
        }

        
    }


    
    private static class FormatToken {
    	static final int LAST_ARGUMENT_INDEX = -2;
    	static final int UNSET = -1;
    	static final int FLAGS_UNSET = 0;
    	static final int DEFAULT_PRECISION = 6;
    	static final int FLAG_ZERO = 1 << 4;
    	private int argIndex = UNSET;
    	boolean flagComma;
    	boolean flagMinus;
    	boolean flagParenthesis;
    	boolean flagPlus;
    	boolean flagSharp;
    	boolean flagSpace;
    	boolean flagZero;
    	private char conversionType = (char) UNSET;
    	private char dateSuffix;
    	private int precision = UNSET;
    	private int width = UNSET;
    	private StringBuilder strFlags;

    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "A7B957B3122A1E0264F586D374F2E6B7", hash_generated_method = "4CDEB35F8023A23A776068ADDDF71EBB")
    	@DSModeled(DSC.SAFE)
    	boolean isDefault() {
    		return dsTaint.getTaintBoolean();
    		// ---------- Original Method ----------
    		//return !flagComma && !flagMinus && !flagParenthesis && !flagPlus && !flagSharp &&
    		//!flagSpace && !flagZero && width == UNSET && precision == UNSET;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "A13969ECEC9F8D1C94EA6A52CDFB6E17", hash_generated_method = "7039F5D11A28646BF7EFDDA34540E2C9")
    	@DSModeled(DSC.SAFE)
    	boolean isPrecisionSet() {
    		//DSFIXME:  CODE0009: Possible callback target function detected
    		return dsTaint.getTaintBoolean();
    		// ---------- Original Method ----------
    		//return precision != UNSET;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "3A74106121887CCA509F985D60DB5637", hash_generated_method = "1B908DD110F170735455C56AA5EA6DAE")
    	@DSModeled(DSC.SAFE)
    	int getArgIndex() {
    		return dsTaint.getTaintInt();
    		// ---------- Original Method ----------
    		//return argIndex;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "27CE41687BF54420F4C00D2CFB6A73FA", hash_generated_method = "AA389E7480E2C05236BE02E53CA95B55")
    	@DSModeled(DSC.SAFE)
    	void setArgIndex(int index) {
    		dsTaint.addTaint(index);
    		// ---------- Original Method ----------
    		//argIndex = index;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.217 -0400", hash_original_method = "40140C97EC91863535630C305615FEC1", hash_generated_method = "E6D1BC267AFE1C67940172986DD38627")
    	@DSModeled(DSC.SAFE)
    	int getWidth() {
    		return dsTaint.getTaintInt();
    		// ---------- Original Method ----------
    		//return width;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "5C954D9C93DF99E2E990960A3CC1749D", hash_generated_method = "103F73E3A4FAA171F9D02BE22BBE2FF6")
    	@DSModeled(DSC.SAFE)
    	void setWidth(int width) {
    		dsTaint.addTaint(width);
    		// ---------- Original Method ----------
    		//this.width = width;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "88B0946477EC80125F5C2950B9A78448")
    	@DSModeled(DSC.SAFE)
    	int getPrecision() {
    		return dsTaint.getTaintInt();
    		// ---------- Original Method ----------
    		//return precision;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "7515FB19ACE3C47DEBBD3E8357F6915C", hash_generated_method = "5C8F8A124155E0144E9736D3C97CF303")
    	@DSModeled(DSC.SAFE)
    	void setPrecision(int precise) {
    		dsTaint.addTaint(precise);
    		// ---------- Original Method ----------
    		//this.precision = precise;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "837A02C50E03265F058B23775F6F6197", hash_generated_method = "71890F022D3F2CEFB98EC9541081A9B3")
    	//DSFIXME:  CODE0002: Requires DSC value to be set
    	String getStrFlags() {
    		{
    			Object var338878CEE6E0CE344C967D45DDB8CEDC_934209378 = (strFlags.toString());
    		} //End flattened ternary
    		return dsTaint.getTaintString();
    		// ---------- Original Method ----------
    		//return (strFlags != null) ? strFlags.toString() : "";
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "E6ACD7E32E6ABC5AE16C357DB8116DB3", hash_generated_method = "76DDD153823966FEBA9786D5FB2C869E")
    	@DSModeled(DSC.SAFE)
    	boolean setFlag(int ch) {
    		dsTaint.addTaint(ch);
    		boolean dupe;
    		dupe = false;
    		//Begin case ',' 
    		dupe = flagComma;
    		//End case ',' 
    		//Begin case ',' 
    		flagComma = true;
    		//End case ',' 
    		//Begin case '-' 
    		dupe = flagMinus;
    		//End case '-' 
    		//Begin case '-' 
    		flagMinus = true;
    		//End case '-' 
    		//Begin case '(' 
    		dupe = flagParenthesis;
    		//End case '(' 
    		//Begin case '(' 
    		flagParenthesis = true;
    		//End case '(' 
    		//Begin case '+' 
    		dupe = flagPlus;
    		//End case '+' 
    		//Begin case '+' 
    		flagPlus = true;
    		//End case '+' 
    		//Begin case '#' 
    		dupe = flagSharp;
    		//End case '#' 
    		//Begin case '#' 
    		flagSharp = true;
    		//End case '#' 
    		//Begin case ' ' 
    		dupe = flagSpace;
    		//End case ' ' 
    		//Begin case ' ' 
    		flagSpace = true;
    		//End case ' ' 
    		//Begin case '0' 
    		dupe = flagZero;
    		//End case '0' 
    		//Begin case '0' 
    		flagZero = true;
    		//End case '0' 
    		if (DroidSafeAndroidRuntime.control) {
    			throw new DuplicateFormatFlagsException(String.valueOf(ch));
    		} //End block
    		{
    			strFlags = new StringBuilder(7);
    		} //End block
    		strFlags.append((char) ch);
    		return dsTaint.getTaintBoolean();
    		// ---------- Original Method ----------
    		// Original Method Too Long, Refer to Original Implementation
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "563B5213711441DEFA9BB3355CD61032", hash_generated_method = "BC796BAADE8386ED4AEC0351AEC8613B")
    	@DSModeled(DSC.SAFE)
    	char getConversionType() {
    		//DSFIXME:  CODE0009: Possible callback target function detected
    		return dsTaint.getTaintChar();
    		// ---------- Original Method ----------
    		//return conversionType;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "6C3279116A999B7A879305F448E4C7E6", hash_generated_method = "6D1281F217DD6D271F441AB4433E0AB6")
    	@DSModeled(DSC.SAFE)
    	void setConversionType(char c) {
    		//DSFIXME:  CODE0009: Possible callback target function detected
    		dsTaint.addTaint(c);
    		// ---------- Original Method ----------
    		//conversionType = c;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "EE45DA1AFAF958B13872135C146745E9", hash_generated_method = "9FDD5F47D8C9FC7962FC6D41E7E6AFCF")
    	@DSModeled(DSC.SAFE)
    	char getDateSuffix() {
    		return dsTaint.getTaintChar();
    		// ---------- Original Method ----------
    		//return dateSuffix;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "6F4F20E9A23952874C5B1A6A80E321B4", hash_generated_method = "D06D24537AC4691270FBFF6B1BB57D7A")
    	@DSModeled(DSC.SAFE)
    	void setDateSuffix(char c) {
    		dsTaint.addTaint(c);
    		// ---------- Original Method ----------
    		//dateSuffix = c;
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.218 -0400", hash_original_method = "67F4DE623207C5AE23B919ACAD45AA0B", hash_generated_method = "3E5885A97F34D30BBF40D769408E755A")
    	@DSModeled(DSC.SAFE)
    	boolean requireArgument() {
    		return dsTaint.getTaintBoolean();
    		// ---------- Original Method ----------
    		//return conversionType != '%' && conversionType != 'n';
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "34D9D8688BA6BF211700F1E1A866C731", hash_generated_method = "B793AA36BB0325790CF47510AE98AE7B")
    	@DSModeled(DSC.SAFE)
    	void checkFlags(Object arg) {
    		dsTaint.addTaint(arg.dsTaint);
    		boolean allowComma;
    		allowComma = false;
    		boolean allowMinus;
    		allowMinus = true;
    		boolean allowParenthesis;
    		allowParenthesis = false;
    		boolean allowPlus;
    		allowPlus = false;
    		boolean allowSharp;
    		allowSharp = false;
    		boolean allowSpace;
    		allowSpace = false;
    		boolean allowZero;
    		allowZero = false;
    		boolean allowPrecision;
    		allowPrecision = true;
    		boolean allowWidth;
    		allowWidth = true;
    		boolean allowArgument;
    		allowArgument = true;
    		//Begin case 'c' 'C' 't' 'T' 
    		allowPrecision = false;
    		//End case 'c' 'C' 't' 'T' 
    		//Begin case 's' 'S' 
    		{
    			allowSharp = true;
    		} //End block
    		//End case 's' 'S' 
    		//Begin case 'g' 'G' 
    		allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
    		//End case 'g' 'G' 
    		//Begin case 'f' 
    		allowComma = allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
    		//End case 'f' 
    		//Begin case 'e' 'E' 
    		allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
    		//End case 'e' 'E' 
    		//Begin case 'a' 'A' 
    		allowPlus = allowSharp = allowSpace = allowZero = true;
    		//End case 'a' 'A' 
    		//Begin case 'd' 
    		allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
    		//End case 'd' 
    		//Begin case 'd' 
    		allowPrecision = false;
    		//End case 'd' 
    		//Begin case 'o' 'x' 'X' 
    		allowSharp = allowZero = true;
    		//End case 'o' 'x' 'X' 
    		//Begin case 'o' 'x' 'X' 
    		{
    			allowParenthesis = allowPlus = allowSpace = true;
    		} //End block
    		//End case 'o' 'x' 'X' 
    		//Begin case 'o' 'x' 'X' 
    		allowPrecision = false;
    		//End case 'o' 'x' 'X' 
    		//Begin case 'n' 
    		allowMinus = false;
    		//End case 'n' 
    		//Begin case 'n' 
    		allowArgument = allowPrecision = allowWidth = false;
    		//End case 'n' 
    		//Begin case '%' 
    		allowArgument = false;
    		//End case '%' 
    		//Begin case '%' 
    		allowPrecision = false;
    		//End case '%' 
    		//Begin case default 
    		if (DroidSafeAndroidRuntime.control) {
    			throw unknownFormatConversionException();
    		}
    		//End case default 
    		String mismatch;
    		mismatch = null;
    		{
    			mismatch = ",";
    		} //End block
    		{
    			mismatch = "-";
    		} //End block
    		{
    			mismatch = "(";
    		} //End block
    		{
    			mismatch = "+";
    		} //End block
    		{
    			mismatch = "#";
    		} //End block
    		{
    			mismatch = " ";
    		} //End block
    		{
    			mismatch = "0";
    		} //End block
    		{
    			if (DroidSafeAndroidRuntime.control) {
    				throw new IllegalFormatFlagsException(mismatch);
    			} //End block
    			if (DroidSafeAndroidRuntime.control) {
    				throw new FormatFlagsConversionMismatchException(mismatch, conversionType);
    			} //End block
    		} //End block
    		if (DroidSafeAndroidRuntime.control) {
    			throw new MissingFormatWidthException("-" + conversionType);
    		} //End block
    		if (DroidSafeAndroidRuntime.control) {
    			throw new IllegalFormatFlagsException("%" + conversionType +
    					" doesn't take an argument");
    		} //End block
    		if (DroidSafeAndroidRuntime.control) {
    			throw new IllegalFormatPrecisionException(precision);
    		} //End block
    		if (DroidSafeAndroidRuntime.control) {
    			throw new IllegalFormatWidthException(width);
    		} //End block
    		if (DroidSafeAndroidRuntime.control) {
    			throw new IllegalFormatFlagsException("the '+' and ' ' flags are incompatible");
    		} //End block
    		if (DroidSafeAndroidRuntime.control) {
    			throw new IllegalFormatFlagsException("the '-' and '0' flags are incompatible");
    		} //End block
    		// ---------- Original Method ----------
    		// Original Method Too Long, Refer to Original Implementation
    	}


    	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "ECFEC3AA46FEEC6BDD34290E5303C5C1", hash_generated_method = "241C1A6B1C2DDB79D2EC34F5E2A7D95E")
    	@DSModeled(DSC.SAFE)
    	public UnknownFormatConversionException unknownFormatConversionException() {
    		//DSFIXME:  CODE0009: Possible callback target function detected
    		if (DroidSafeAndroidRuntime.control) {
    			throw new UnknownFormatConversionException(String.format("%c%c",
    					conversionType, dateSuffix));
    		} //End block
    		if (DroidSafeAndroidRuntime.control) {
    			throw new UnknownFormatConversionException(String.valueOf(conversionType));
    		}
    		return (UnknownFormatConversionException)dsTaint.getTaint();
    		// ---------- Original Method ----------
    		//if (conversionType == 't' || conversionType == 'T') {
    		//throw new UnknownFormatConversionException(String.format("%c%c",
    		//conversionType, dateSuffix));
    		//}
    		//throw new UnknownFormatConversionException(String.valueOf(conversionType));
    	}


    }


    
    private static class FormatSpecifierParser {
        private String format;
        private int length;
        private int startIndex;
        private int i;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "2EAAE714EE0AE41BF39DBCA3F91B9104", hash_generated_method = "39D424A9D38C5C99810312A6F3BB8F16")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FormatSpecifierParser(String format) {
            dsTaint.addTaint(format);
            this.length = format.length();
            // ---------- Original Method ----------
            //this.format = format;
            //this.length = format.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "F77740880648C3886F14C74FD023BD3A", hash_generated_method = "876C67E598C7BE2CB41322C9E8DDD3EF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FormatToken parseFormatToken(int offset) {
            dsTaint.addTaint(offset);
            FormatToken varE457B0C080B64A5470DC17853D206112_369240573 = (parseArgumentIndexAndFlags(new FormatToken()));
            return (FormatToken)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.startIndex = offset;
            //this.i = offset;
            //return parseArgumentIndexAndFlags(new FormatToken());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "7C388C74117CDF3E7844B526DC734D8C", hash_generated_method = "EA369E84C4959DA1BEFC92A05A882A75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getFormatSpecifierText() {
            String varA942D769BD9D8BB09CFD57C0C5C86AE5_1590612800 = (format.substring(startIndex, i));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return format.substring(startIndex, i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "6521B9C02DA744FF180556D39A74ED44", hash_generated_method = "DEFA22D8A2697703383B409C2D013D7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int peek() {
            {
                Object var765273F0E3B5EB95414F86EBEA317E40_408217792 = (format.charAt(i));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (i < length) ? format.charAt(i) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "F520742ED92EBACDB47FBF0D0B1F08F4", hash_generated_method = "F2E24942632BF81F316E14222F7A49B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private char advance() {
        	if (DroidSafeAndroidRuntime.control) {
                throw unknownFormatConversionException();
            } //End block
            char var7701A7CCE85ED6AA9880F4BA6BB09ECE_1037182361 = (format.charAt(i++));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (i >= length) {
                //throw unknownFormatConversionException();
            //}
            //return format.charAt(i++);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.219 -0400", hash_original_method = "DFAEBB829CC6A7AFE465DA1B9A0C1D5A", hash_generated_method = "36170992EEDD3C766BCD86E2F4D9F340")
        @DSModeled(DSC.SAFE)
        private UnknownFormatConversionException unknownFormatConversionException() {
        	if (DroidSafeAndroidRuntime.control) {
        		throw new UnknownFormatConversionException(getFormatSpecifierText());
        	}
            return (UnknownFormatConversionException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnknownFormatConversionException(getFormatSpecifierText());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.220 -0400", hash_original_method = "AD27190704DEC79DF3778A7C88589CDF", hash_generated_method = "DC1D116EAAAAE5228121F41F142A6B43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private FormatToken parseArgumentIndexAndFlags(FormatToken token) {
            dsTaint.addTaint(token.dsTaint);
            int position;
            position = i;
            int ch;
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_2001346499 = (Character.isDigit(ch));
                {
                    int number;
                    number = nextInt();
                    {
                        boolean varAF443300A994E05CBD4A93B1F0A6046B_1972169351 = (peek() == '$');
                        {
                            advance();
                            if (DroidSafeAndroidRuntime.control) {
                                throw new MissingFormatArgumentException(getFormatSpecifierText());
                            } //End block
                            token.setArgIndex(Math.max(0, number - 1));
                        } //End block
                        {
                            {
                                i = position;
                            } //End block
                            {
                                FormatToken var69DAEFA423934291D77A1FFC213F208E_1928243539 = (parseWidth(token, number));
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    token.setArgIndex(FormatToken.LAST_ARGUMENT_INDEX);
                    advance();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD959591D21FA1B51681982FB61D589FE_1276186808 = (token.setFlag(peek()));
                {
                    advance();
                } //End block
            } //End collapsed parenthetic
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_1031803330 = (Character.isDigit(ch));
                {
                    FormatToken var5A48663D783AAF0717FAF62ACD7859D7_367908565 = (parseWidth(token, nextInt()));
                } //End block
                {
                    FormatToken var31509ACF40811EFF270C1CF101979E79_547748945 = (parsePrecision(token));
                } //End block
                {
                    FormatToken var8B11D054AAC67E20E5AD77C09C6D9280_977528666 = (parseConversionType(token));
                } //End block
            } //End collapsed parenthetic
            return (FormatToken)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.220 -0400", hash_original_method = "F4C6E47C7F58A93445972E2EDFDFCD5C", hash_generated_method = "C74BDC106C8497120546657F62F22B87")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private FormatToken parseWidth(FormatToken token, int width) {
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(width);
            token.setWidth(width);
            int ch;
            ch = peek();
            {
                FormatToken varF2239DB28F754960FDCC1174ADECA38B_1522867957 = (parsePrecision(token));
            } //End block
            {
                FormatToken var10A662E1106310A5CAA7CBFB0467752C_520243209 = (parseConversionType(token));
            } //End block
            return (FormatToken)dsTaint.getTaint();
            // ---------- Original Method ----------
            //token.setWidth(width);
            //int ch = peek();
            //if (ch == '.') {
                //return parsePrecision(token);
            //} else {
                //return parseConversionType(token);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.220 -0400", hash_original_method = "06DE93E908B11B43F41251F270A468F2", hash_generated_method = "ABB64426AD425773F6347CEFD79B506D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private FormatToken parsePrecision(FormatToken token) {
            dsTaint.addTaint(token.dsTaint);
            advance();
            int ch;
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_1369150799 = (Character.isDigit(ch));
                {
                    token.setPrecision(nextInt());
                    FormatToken var8B11D054AAC67E20E5AD77C09C6D9280_527860197 = (parseConversionType(token));
                } //End block
                if (DroidSafeAndroidRuntime.control) {
                    throw unknownFormatConversionException();
                } //End block
            } //End collapsed parenthetic
            return (FormatToken)dsTaint.getTaint();
            // ---------- Original Method ----------
            //advance();
            //int ch = peek();
            //if (Character.isDigit(ch)) {
                //token.setPrecision(nextInt());
                //return parseConversionType(token);
            //} else {
                //throw unknownFormatConversionException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.220 -0400", hash_original_method = "779E7C7A9E24C2B8C7A984530163E241", hash_generated_method = "5AD52A5956648CB2CFF0EF92C10F000B")
        @DSModeled(DSC.SAFE)
        private FormatToken parseConversionType(FormatToken token) {
            dsTaint.addTaint(token.dsTaint);
            char conversionType;
            conversionType = advance();
            token.setConversionType(conversionType);
            {
                char dateSuffix;
                dateSuffix = advance();
                token.setDateSuffix(dateSuffix);
            } //End block
            return (FormatToken)dsTaint.getTaint();
            // ---------- Original Method ----------
            //char conversionType = advance();
            //token.setConversionType(conversionType);
            //if (conversionType == 't' || conversionType == 'T') {
                //char dateSuffix = advance(); 
                //token.setDateSuffix(dateSuffix);
            //}
            //return token;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.220 -0400", hash_original_method = "ADF8322FF676CF5038257F50E4E4E6DC", hash_generated_method = "166B14C9AD54A07F53CFA43F9BE11D35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int nextInt() {
            long value;
            value = 0;
            {
                boolean var89C0C9F591E86A0985096DE42B7326D1_297176815 = (i < length && Character.isDigit(format.charAt(i)));
                {
                    value = 10 * value + (format.charAt(i++) - '0');
                    {
                        int varBF2312BB009815DC54B749D4D210B6C9_1302379654 = (failNextInt());
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //long value = 0;
            //while (i < length && Character.isDigit(format.charAt(i))) {
                //value = 10 * value + (format.charAt(i++) - '0');
                //if (value > Integer.MAX_VALUE) {
                    //return failNextInt();
                //}
            //}
            //return (int) value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.220 -0400", hash_original_method = "F2814F47D4EB7F1D4CA24D9FE1C3918D", hash_generated_method = "7B3C8DA8917FF6FC7888813971850F7A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int failNextInt() {
            {
                boolean varDB282127B78D2B872AE9DB5E44D7F6B7_2040167105 = (Character.isDigit(peek()));
                {
                    advance();
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //while (Character.isDigit(peek())) {
                //advance();
            //}
            //return FormatToken.UNSET;
        }

        
    }


    
}


