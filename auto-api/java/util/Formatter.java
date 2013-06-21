package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Appendable out;
    private Locale locale;
    private Object arg;
    private boolean closed = false;
    private FormatToken formatToken;
    private IOException lastIOException;
    private LocaleData localeData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.096 -0400", hash_original_method = "776A8092D7EB6A8CE9FA3707C90FDC71", hash_generated_method = "84D520F5378D0961C20054F1B6C8CEC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter() {
        this(new StringBuilder(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.096 -0400", hash_original_method = "C10A7E7C6014F1D5457B2868B8DDD5FA", hash_generated_method = "E00B0A2B40334EFC1BFEEFACD02D6B32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(Appendable a) {
        this(a, Locale.getDefault());
        dsTaint.addTaint(a.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.096 -0400", hash_original_method = "949ED46E62E9C1FD97345CAB1F572157", hash_generated_method = "940D3C1195F98C467CB0F419AE634B96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(Locale l) {
        this(new StringBuilder(), l);
        dsTaint.addTaint(l.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.096 -0400", hash_original_method = "731A0E308D6775F1250BD9086CA3748C", hash_generated_method = "72CAA1FC5FE6462589C346E3D6D07B50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.096 -0400", hash_original_method = "55110CB3A063CDDA9DDF2A6FEEDBC4D6", hash_generated_method = "1BF370DE7C8D6454BC5BA830043F1238")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        dsTaint.addTaint(fileName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.097 -0400", hash_original_method = "D05AE6CA9B3694824C73C0B398D66198", hash_generated_method = "7DFB52375246620CB2C528A05B59B4EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(String fileName, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new File(fileName), csn);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.097 -0400", hash_original_method = "106406A68116E4DC11358A25DB96C9D8", hash_generated_method = "187D8E95B4CCC9DE3D14ED92B0F8A5BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(String fileName, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn, l);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.097 -0400", hash_original_method = "56C5088BBC7ACEBB0E3B42C5FC534A61", hash_generated_method = "D3D6C05102FBFE01F57373A9191FD543")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.097 -0400", hash_original_method = "15C3BB1BBEBB7DA2B256558B7A83F1D2", hash_generated_method = "A3A93D0FB0779B62CDAFEAF1EC5BF4BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(file, csn, Locale.getDefault());
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.097 -0400", hash_original_method = "11FC304A866A57AD6707E0AE5ACD74C6", hash_generated_method = "A8015CA8EED6FBF72843A19BCE3C335F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (UnsupportedEncodingException e)
        {
            IoUtils.closeQuietly(fout);
            if (DroidSafeAndroidRuntime.control) throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.097 -0400", hash_original_method = "18094D8509766CE6FC608D9540C5972B", hash_generated_method = "671BB3527B55651196C0722040895989")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(OutputStream os) {
        dsTaint.addTaint(os.dsTaint);
        out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        locale = Locale.getDefault();
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        //locale = Locale.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.098 -0400", hash_original_method = "F6295FD9F7AB3AB7F721531D402E7F81", hash_generated_method = "BEAA333E746D92CCD5649A86DA9BFCB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault());
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.098 -0400", hash_original_method = "339D31BAB557832A3B8A75EB377C0635", hash_generated_method = "AC2CA510D430BDA7DAE9213A4B0F537F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(OutputStream os, String csn, Locale l) throws UnsupportedEncodingException {
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(csn);
        out = new BufferedWriter(new OutputStreamWriter(os, csn));
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, csn));
        //locale = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.098 -0400", hash_original_method = "6A92C9283CC7B01627E24F0E27824A3B", hash_generated_method = "E4EEE003C231DD4C21E479DE21513F04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter(PrintStream ps) {
        dsTaint.addTaint(ps.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        locale = Locale.getDefault();
        // ---------- Original Method ----------
        //if (ps == null) {
            //throw new NullPointerException();
        //}
        //out = ps;
        //locale = Locale.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.098 -0400", hash_original_method = "9D62CCD9646FE324AC0FFA6EB7C17C6C", hash_generated_method = "9E8CAE6AEC5F2B7C14DF0B975AC487BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NativeDecimalFormat getDecimalFormat(String pattern) {
        dsTaint.addTaint(pattern);
        NativeDecimalFormat var05CD216C6F15BCB71649928EDE58E914_562270713 = (cachedDecimalFormat.get().update(localeData, pattern));
        return (NativeDecimalFormat)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cachedDecimalFormat.get().update(localeData, pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.098 -0400", hash_original_method = "E3DA6A4C963B6E9187963221C571CEC2", hash_generated_method = "CED13C9417F36F227519AB72CA97A589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new FormatterClosedException();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new FormatterClosedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.098 -0400", hash_original_method = "B5A8A4A4A455286143E3BD4E75C6F0FE", hash_generated_method = "E81CE886EB040F86DB07FB5C4E7DAF2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale locale() {
        checkNotClosed();
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.099 -0400", hash_original_method = "D73A5BF8E95D39CBD6819B9B1AA13C8D", hash_generated_method = "A375EFA87539B31F0578E0EA091F1DB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Appendable out() {
        checkNotClosed();
        return (Appendable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.099 -0400", hash_original_method = "39CF8FB3A631311648D12D228411CE26", hash_generated_method = "418AB3415B8C1B890CDBC33F1CDE1E61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        checkNotClosed();
        String var91AA98D26314697B1A25ED8404F7DE4C_1566286655 = (out.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.099 -0400", hash_original_method = "E9CBCF5548B5D691C8801114F0C41C59", hash_generated_method = "013B35C8AAE53BF641F7E9D982E1D4C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.099 -0400", hash_original_method = "16C1939C51EF65BBD0A872F925CE78BF", hash_generated_method = "707CBA92274B8C8AF142983EEBDF49F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.099 -0400", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "FEC86F0F7AF1AC832565D1F79B4EADD4")
    @DSModeled(DSC.SAFE)
    public IOException ioException() {
        return (IOException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lastIOException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.100 -0400", hash_original_method = "EE9FCF62B0D200225753D8BA586AA3F5", hash_generated_method = "E71C5A120AA5060E23EA58A438C775BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Formatter format(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        Formatter var5B9D05694FA5D917B581106730AA8E29_189878497 = (format(this.locale, format, args));
        return (Formatter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(this.locale, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.100 -0400", hash_original_method = "F45273151F6DD69ACB6CCC03C59753A4", hash_generated_method = "7F4F908542F6805F462008CDA9F114BB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.100 -0400", hash_original_method = "960E24FB807777DEBBE8328729AF6A3F", hash_generated_method = "52647714946A5544BF433E37C1425285")
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
                    boolean var15437F24151F4B9BB4CF0F9304E51BA9_763466186 = (token.requireArgument());
                    {
                        int index;
                        boolean varE3D8046091E4D6BBC992AF3D15742E1E_256466863 = (token.getArgIndex() == FormatToken.UNSET);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.101 -0400", hash_original_method = "4A93F3F0DF6F4E45CC93AF5660722832", hash_generated_method = "7253A993D496B973326510686123984B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.101 -0400", hash_original_method = "4EF20CF84298D39EE17983F53878C341", hash_generated_method = "ADE53FF7C7A42FF85CE8D5680BBC64A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object getArgument(Object[] args, int index, FormatSpecifierParser fsp,
            Object lastArgument, boolean hasLastArgumentSet) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(fsp.dsTaint);
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(hasLastArgumentSet);
        dsTaint.addTaint(lastArgument.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException("<");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException(fsp.getFormatSpecifierText());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.102 -0400", hash_original_method = "0237F1DF7BD7A386A4F4D1B44D43876F", hash_generated_method = "5EF613C02E8A7824837D74CDC4A198A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transform(FormatToken token, Object argument) {
        dsTaint.addTaint(argument.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        {
            boolean var774D16194421B6759CE7C28102870BC1_1163241646 = (token.isDefault());
            {
                {
                    Object var3AF4190693AD8752FD689B6D6C2F4FD0_715420141 = (token.getConversionType());
                    //Begin case 's' 
                    {
                        CharSequence varF00D2AACA373F717945507CC159D3E81_564526505 = (arg.toString());
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
                            Object varC69EE22EAA81A122340C191FB6828A6C_403504010 = (localizeDigits(result));
                        } //End flattened ternary
                    } //End block
                    //End case 'd' 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        formatToken.checkFlags(arg);
        CharSequence result;
        {
            Object var1A1A65DF413B75C3108F1920C1E23A5B_1621528874 = (token.getConversionType());
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
            if (DroidSafeAndroidRuntime.control) throw token.unknownFormatConversionException();
            //End case default 
        } //End collapsed parenthetic
        {
            boolean var1DB4C6B053C2BBEFBDA3D42D86D066E6_75104744 = (Character.isUpperCase(token.getConversionType()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.102 -0400", hash_original_method = "D44F27ADB431306CEB9F9E1F25036901", hash_generated_method = "CC5021A85DEF47FD39326B0A066A0DF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IllegalFormatConversionException badArgumentType() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
        return (IllegalFormatConversionException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.102 -0400", hash_original_method = "8CD3AC57424B332A3611698407D98FD3", hash_generated_method = "112DDD492A2D010139A964DC8ED093CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.103 -0400", hash_original_method = "CC3FF2DA7072A05A8664F97319F6C752", hash_generated_method = "DCCBE14CDD67DDEEB50DEA7F5C58721E")
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
            boolean var9A0E6F317753A236C52C55D585498BB1_2016266140 = (s.charAt(0) == '-');
            {
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
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_205880998 = (i < s.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.103 -0400", hash_original_method = "54F34C95EDCEEE411BD250D07A12E500", hash_generated_method = "25D358AD3E229FF048E870D336F10439")
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
        CharSequence var011EA2072D70C65DC591519D0B53769C_1661674217 = (padding(result, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.103 -0400", hash_original_method = "FEE63D21FF5AA7B8F21641D7D3CB6697", hash_generated_method = "F937B57972DBBF910B6AF95CAD218CE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromHashCode() {
        CharSequence result;
        {
            result = "null";
        } //End block
        {
            result = Integer.toHexString(arg.hashCode());
        } //End block
        CharSequence var011EA2072D70C65DC591519D0B53769C_1513982413 = (padding(result, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.103 -0400", hash_original_method = "41FDF272148D1D909A3CC241D4F2B404", hash_generated_method = "183AB3960D7D6EAB7EB653504B66036A")
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
                boolean varE5047B2B0C3ABA50902192D0CF9C9641_927605442 = (Character.isUpperCase(formatToken.getConversionType()));
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
        CharSequence var011EA2072D70C65DC591519D0B53769C_1580430054 = (padding(result, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.104 -0400", hash_original_method = "78103310C8550D540C751775D2E73F1B", hash_generated_method = "08D889BE40E871BD4C0A4DEA7C7A1B03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromCharacter() {
        {
            CharSequence var110FEB5E002D3B12E0D41B94578BEF77_956243819 = (padding("null", 0));
        } //End block
        {
            CharSequence var903E70783DB183030BB4031B6620F35A_486183905 = (padding(String.valueOf(arg), 0));
        } //End block
        {
            int codePoint;
            codePoint = ((Number) arg).intValue();
            {
                boolean var6F543C204E9C4F46177946447429AAE1_1297318515 = (!Character.isValidCodePoint(codePoint));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalFormatCodePointException(codePoint);
                } //End block
            } //End collapsed parenthetic
            CharSequence result;
            result = String.valueOf((char) codePoint);
            result = String.valueOf(Character.toChars(codePoint));
            CharSequence varD52663FB252B32832B0DD96BE06E99D2_682449138 = (padding(result, 0));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.104 -0400", hash_original_method = "1802F533F155B8AA49557FA5A74B7DBE", hash_generated_method = "34645B599F68B8F6FD8A85C49EA5A6A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromPercent() {
        CharSequence var127E49E72FC3D889FEBDC11FC78B3E63_1209017595 = (padding("%", 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return padding("%", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.104 -0400", hash_original_method = "EF7726D1BC858C4C5BDC40B9ACBD3ABF", hash_generated_method = "99848731C6F93BCE00F04C7C8C97711F")
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
                boolean var5580C15E55C4240F2395BB7B30D9E99A_486834428 = (formatToken.getConversionType() == 'd');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.105 -0400", hash_original_method = "AA67EEFB247ACC7BDA1BABCD03B30A80", hash_generated_method = "12EBBBB4A4CC5C29C112509B79D87677")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringBuilder toStringBuilder(CharSequence cs) {
        dsTaint.addTaint(cs);
        {
            Object var00489E376535EF9CD9558FFCCEDB7817_1412891911 = (new StringBuilder(cs));
        } //End flattened ternary
        return (StringBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.105 -0400", hash_original_method = "CE1A2CC9741A13D14659E3953A660AC1", hash_generated_method = "EA85E5180379CF7CF9A7E7CD2831FC1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.106 -0400", hash_original_method = "FADDE3D8C4FA639F028B03B661D10023", hash_generated_method = "7DE2A70F8D31045E2255C48F0CF0FC8B")
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
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
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
                    CharSequence var55C578ADD9A87615405C43B1C9B54B88_2043872737 = (wrapParentheses(result));
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
        CharSequence var906C8D50B58AEBD50FC57EA01B63F94A_1682799925 = (padding(result, startIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.106 -0400", hash_original_method = "15D0DEB8422EE33E04C98AFC872D1D51", hash_generated_method = "84F4DACAF1913F8DF751148FBEF5DEE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromNull() {
        formatToken.flagZero = false;
        CharSequence varCF816A8169468B94C535E94A88F96752_7941173 = (padding("null", 0));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //formatToken.flagZero = false;
        //return padding("null", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.106 -0400", hash_original_method = "28740AE89E2FC451EFE3093F54121A6C", hash_generated_method = "13B24A3ADA7FEF0944D3591041F60949")
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
            CharSequence var05F215AB109523D2CFEFFC669E706EC0_277513676 = (transformFromNull());
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
            CharSequence varF450D26DBF6E25E6530DAFE24CDB393B_1405341848 = (wrapParentheses(result));
        } //End block
        CharSequence var906C8D50B58AEBD50FC57EA01B63F94A_849213099 = (padding(result, startIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.107 -0400", hash_original_method = "3FA485DEFE055FA59E9A89B7029B3055", hash_generated_method = "71EAECFA4E7D84D98E09D9E4BD8DB4D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromDateTime() {
        {
            CharSequence var05F215AB109523D2CFEFFC669E706EC0_260917368 = (transformFromNull());
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
            {
                if (DroidSafeAndroidRuntime.control) throw badArgumentType();
            } //End block
            calendar = Calendar.getInstance(locale);
            calendar.setTime(date);
        } //End block
        StringBuilder result;
        result = new StringBuilder();
        {
            boolean varCAB943A58957944F491BEB3F9C12AAC8_2071123252 = (!appendT(result, formatToken.getDateSuffix(), calendar));
            {
                if (DroidSafeAndroidRuntime.control) throw formatToken.unknownFormatConversionException();
            } //End block
        } //End collapsed parenthetic
        CharSequence var011EA2072D70C65DC591519D0B53769C_966928371 = (padding(result, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.108 -0400", hash_original_method = "6A85D50A5F6F83B5DE3D767D1CCF3B76", hash_generated_method = "17005214CC83411E19E32E2DE3570DF7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.108 -0400", hash_original_method = "07C369462F22245026E1280008B34AEC", hash_generated_method = "33FB0C77EA884034133B35D42C73C728")
    @DSModeled(DSC.SAFE)
    private int to12Hour(int hour) {
        dsTaint.addTaint(hour);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hour == 0 ? 12 : hour;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.109 -0400", hash_original_method = "60B30B4DC0B127EF94D361BC9EB2AF90", hash_generated_method = "3004D6126FB3A3A718338B7B8ADB419B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.109 -0400", hash_original_method = "977B62B975352D4F075C1101DB18FB73", hash_generated_method = "5FDEF3D30DB935B1F91ACC0C07E19DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromSpecialNumber(double d) {
        dsTaint.addTaint(d);
        String source;
        source = null;
        {
            boolean varF573A637641E1AB21D698815AEB110FB_1969562788 = (Double.isNaN(d));
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
        CharSequence var07592184B4EF7BE63898842D0E4CE6A9_222511559 = (padding(source, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.110 -0400", hash_original_method = "DECF7ECF8109F764E81E2CF8101BCB0C", hash_generated_method = "4BFE89B9D6C312A088F2241AF9212A7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence transformFromFloat() {
        {
            CharSequence var05F215AB109523D2CFEFFC669E706EC0_226345316 = (transformFromNull());
        } //End block
        {
            Number number;
            number = (Number) arg;
            double d;
            d = number.doubleValue();
            {
                CharSequence var10F0CDC0673B0075AE7109E074D3F683_1915137254 = (transformFromSpecialNumber(d));
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } //End block
        char conversionType;
        conversionType = formatToken.getConversionType();
        {
            boolean var4D48FD270E3C43B43C7CAFA231E3C2A7_831299946 = (conversionType != 'a' && conversionType != 'A' && !formatToken.isPrecisionSet());
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
        if (DroidSafeAndroidRuntime.control) throw formatToken.unknownFormatConversionException();
        //End case default 
        formatToken.setPrecision(FormatToken.UNSET);
        int startIndex;
        startIndex = 0;
        {
            boolean varC4FD83BCDCE254D147FDF9D7B3AC13AA_412030789 = (result.charAt(0) == localeData.minusSign);
            {
                {
                    CharSequence var55C578ADD9A87615405C43B1C9B54B88_1022148812 = (wrapParentheses(result));
                } //End block
            } //End block
            {
                {
                    result.insert(0, ' ');
                } //End block
                {
                    result.insert(0, '+');
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
        CharSequence var906C8D50B58AEBD50FC57EA01B63F94A_1824703781 = (padding(result, startIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.110 -0400", hash_original_method = "43DA2A76094CCA7D42287B4466035D61", hash_generated_method = "C5E72A975B3F73F0D85D4875D2D4808A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transformE(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        int precision;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.111 -0400", hash_original_method = "1973123C0DFAE44325340FD650EA833E", hash_generated_method = "02E03B3B0E67D96B6BA41B9A838EC717")
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
            formatToken.setPrecision(precision);
            transformF(result);
        } //End block
        boolean requireScientificRepresentation;
        requireScientificRepresentation = true;
        d = Math.abs(d);
        {
            boolean var3ECD0EAFA593A6ADC1E4F46524942B82_1024768869 = (Double.isInfinite(d));
            {
                precision = formatToken.getPrecision();
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
            boolean var7952BAED570DF8211C40DB97D6C9494B_1394313031 = (d >= 1 && d < Math.pow(10, precision));
            {
                {
                    boolean var6DA2CA6307083AFD29BF7C8CBC3D16A4_1918109639 = (l < Math.pow(10, precision));
                    {
                        requireScientificRepresentation = false;
                        precision -= String.valueOf(l).length();
                        precision = precision < 0 ? 0 : precision;
                        l = Math.round(d * Math.pow(10, precision + 1));
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_1995058326 = (String.valueOf(l).length() <= formatToken.getPrecision());
                        } //End collapsed parenthetic
                        formatToken.setPrecision(precision);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                l = b.movePointRight(4).longValue();
                {
                    boolean varFC5D9BA1CE39DA4CE1D6C7B756E730FB_513475673 = (d >= Math.pow(10, -4) && d < 1);
                    {
                        requireScientificRepresentation = false;
                        precision += 4 - String.valueOf(l).length();
                        l = b.movePointRight(precision + 1).longValue();
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_287577799 = (String.valueOf(l).length() <= formatToken.getPrecision());
                        } //End collapsed parenthetic
                        l = b.movePointRight(precision).longValue();
                        {
                            boolean var48F2D010DC481B7F6EDFA70502BAD5C5_1802039731 = (l >= Math.pow(10, precision - 4));
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
            formatToken.setPrecision(precision);
            transformE(result);
        } //End block
        {
            transformF(result);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.112 -0400", hash_original_method = "DF70A96812FA1EE536149F6B5D8F4C45", hash_generated_method = "B6267338DB5F7E6F2C5ECE9A05ABFE20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transformF(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        String pattern;
        pattern = "0.000000";
        int precision;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.113 -0400", hash_original_method = "DCC3844221755C0C14FA659BF8647E6B", hash_generated_method = "9D24DA2D0DB6CAB78EC86220A10F313C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void transformA(StringBuilder result) {
        dsTaint.addTaint(result.dsTaint);
        {
            result.append(Float.toHexString(((Float) arg).floatValue()));
        } //End block
        {
            result.append(Double.toHexString(((Double) arg).doubleValue()));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } //End block
        {
            boolean var0BA49339344F3E46004E2C66FA171DC0_1165799800 = (!formatToken.isPrecisionSet());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.114 -0400", hash_original_method = "3AB4302EBBD3C6ECF16B79A91E887CC6", hash_generated_method = "C4149067CD2AF28823E946F111841C62")
        @DSModeled(DSC.SAFE)
        public CachedDecimalFormat() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.114 -0400", hash_original_method = "784B3214258603820EA00D340F6FA563", hash_generated_method = "45B149AF05BD88FE36462DD6FE3EAC73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NativeDecimalFormat update(LocaleData localeData, String pattern) {
            dsTaint.addTaint(localeData.dsTaint);
            dsTaint.addTaint(pattern);
            {
                decimalFormat = new NativeDecimalFormat(currentPattern, currentLocaleData);
            } //End block
            {
                boolean varC04205845392AD76FE20C5C34EA780FF_1342331873 = (!pattern.equals(currentPattern));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.114 -0400", hash_original_method = "0B8D6933413EDBEA1EAA68119DF7C0BF", hash_generated_method = "0B8D6933413EDBEA1EAA68119DF7C0BF")
                public FormatToken ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.114 -0400", hash_original_method = "A7B957B3122A1E0264F586D374F2E6B7", hash_generated_method = "62BB07AE5F19835B5935F60F0286F4E4")
        @DSModeled(DSC.SAFE)
         boolean isDefault() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return !flagComma && !flagMinus && !flagParenthesis && !flagPlus && !flagSharp &&
                    //!flagSpace && !flagZero && width == UNSET && precision == UNSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.114 -0400", hash_original_method = "A13969ECEC9F8D1C94EA6A52CDFB6E17", hash_generated_method = "E1E1DC83FAC798608D7145D7F962262A")
        @DSModeled(DSC.SAFE)
         boolean isPrecisionSet() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return precision != UNSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.114 -0400", hash_original_method = "3A74106121887CCA509F985D60DB5637", hash_generated_method = "E0005AB598498FA4E0B79A4E0FE5062A")
        @DSModeled(DSC.SAFE)
         int getArgIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return argIndex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.115 -0400", hash_original_method = "27CE41687BF54420F4C00D2CFB6A73FA", hash_generated_method = "BF1ADE286C1C1BDDE69A0DE38C856592")
        @DSModeled(DSC.SAFE)
         void setArgIndex(int index) {
            dsTaint.addTaint(index);
            // ---------- Original Method ----------
            //argIndex = index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.115 -0400", hash_original_method = "40140C97EC91863535630C305615FEC1", hash_generated_method = "AA99B4958806DD5FCC2251EDB5721138")
        @DSModeled(DSC.SAFE)
         int getWidth() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return width;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.115 -0400", hash_original_method = "5C954D9C93DF99E2E990960A3CC1749D", hash_generated_method = "0F72CE4B61F2F7BECBE10F29761B14A4")
        @DSModeled(DSC.SAFE)
         void setWidth(int width) {
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //this.width = width;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.115 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "AA8AB35F6011E83CFBAFFB362FF539B4")
        @DSModeled(DSC.SAFE)
         int getPrecision() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return precision;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.115 -0400", hash_original_method = "7515FB19ACE3C47DEBBD3E8357F6915C", hash_generated_method = "BF8D816B49F5798AC344F83244B88147")
        @DSModeled(DSC.SAFE)
         void setPrecision(int precise) {
            dsTaint.addTaint(precise);
            // ---------- Original Method ----------
            //this.precision = precise;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.116 -0400", hash_original_method = "837A02C50E03265F058B23775F6F6197", hash_generated_method = "FC331560212CBC7A1F3D379E8AF5B634")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getStrFlags() {
            {
                Object var338878CEE6E0CE344C967D45DDB8CEDC_1376069339 = (strFlags.toString());
            } //End flattened ternary
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return (strFlags != null) ? strFlags.toString() : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.116 -0400", hash_original_method = "E6ACD7E32E6ABC5AE16C357DB8116DB3", hash_generated_method = "1B0267855857DFD95FDEECD81C018FEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            {
                if (DroidSafeAndroidRuntime.control) throw new DuplicateFormatFlagsException(String.valueOf(ch));
            } //End block
            {
                strFlags = new StringBuilder(7);
            } //End block
            strFlags.append((char) ch);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.116 -0400", hash_original_method = "563B5213711441DEFA9BB3355CD61032", hash_generated_method = "7035F5E7223B9D4EE5DDB87D1ED7B7B9")
        @DSModeled(DSC.SAFE)
         char getConversionType() {
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //return conversionType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.116 -0400", hash_original_method = "6C3279116A999B7A879305F448E4C7E6", hash_generated_method = "A7340B403E7CB3C70EDA6A1B8FC4471D")
        @DSModeled(DSC.SAFE)
         void setConversionType(char c) {
            dsTaint.addTaint(c);
            // ---------- Original Method ----------
            //conversionType = c;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.117 -0400", hash_original_method = "EE45DA1AFAF958B13872135C146745E9", hash_generated_method = "E9AF4843508708042A060C9313F6A5A6")
        @DSModeled(DSC.SAFE)
         char getDateSuffix() {
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //return dateSuffix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.117 -0400", hash_original_method = "6F4F20E9A23952874C5B1A6A80E321B4", hash_generated_method = "E75A9EC6EE03D81C3FCE839A6C427127")
        @DSModeled(DSC.SAFE)
         void setDateSuffix(char c) {
            dsTaint.addTaint(c);
            // ---------- Original Method ----------
            //dateSuffix = c;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.117 -0400", hash_original_method = "67F4DE623207C5AE23B919ACAD45AA0B", hash_generated_method = "5B1F3E9AB3C394D52C6F39DC77EF9FE8")
        @DSModeled(DSC.SAFE)
         boolean requireArgument() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return conversionType != '%' && conversionType != 'n';
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.118 -0400", hash_original_method = "34D9D8688BA6BF211700F1E1A866C731", hash_generated_method = "2B18BB4411DE8052A5BD63CA2DBE6BB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
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
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException(mismatch);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new FormatFlagsConversionMismatchException(mismatch, conversionType);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new MissingFormatWidthException("-" + conversionType);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException("%" + conversionType +
                        " doesn't take an argument");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatPrecisionException(precision);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatWidthException(width);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException("the '+' and ' ' flags are incompatible");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalFormatFlagsException("the '-' and '0' flags are incompatible");
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.118 -0400", hash_original_method = "ECFEC3AA46FEEC6BDD34290E5303C5C1", hash_generated_method = "37C88B7F1F172FCC453F2F44DBCF465E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UnknownFormatConversionException unknownFormatConversionException() {
            {
                if (DroidSafeAndroidRuntime.control) throw new UnknownFormatConversionException(String.format("%c%c",
                        conversionType, dateSuffix));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnknownFormatConversionException(String.valueOf(conversionType));
            return (UnknownFormatConversionException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (conversionType == 't' || conversionType == 'T') {
                //throw new UnknownFormatConversionException(String.format("%c%c",
                        //conversionType, dateSuffix));
            //}
            //throw new UnknownFormatConversionException(String.valueOf(conversionType));
        }

        
        static final int LAST_ARGUMENT_INDEX = -2;
        static final int UNSET = -1;
        static final int FLAGS_UNSET = 0;
        static final int DEFAULT_PRECISION = 6;
        static final int FLAG_ZERO = 1 << 4;
    }


    
    private static class FormatSpecifierParser {
        private String format;
        private int length;
        private int startIndex;
        private int i;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.118 -0400", hash_original_method = "2EAAE714EE0AE41BF39DBCA3F91B9104", hash_generated_method = "FF570E6A996C5042DCBA3E90B0109B9F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FormatSpecifierParser(String format) {
            dsTaint.addTaint(format);
            this.length = format.length();
            // ---------- Original Method ----------
            //this.format = format;
            //this.length = format.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.119 -0400", hash_original_method = "F77740880648C3886F14C74FD023BD3A", hash_generated_method = "7F2C43C5C62417860F878BFAD7A1DDDE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FormatToken parseFormatToken(int offset) {
            dsTaint.addTaint(offset);
            FormatToken varE457B0C080B64A5470DC17853D206112_938818335 = (parseArgumentIndexAndFlags(new FormatToken()));
            return (FormatToken)dsTaint.getTaint();
            // ---------- Original Method ----------
            //this.startIndex = offset;
            //this.i = offset;
            //return parseArgumentIndexAndFlags(new FormatToken());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.119 -0400", hash_original_method = "7C388C74117CDF3E7844B526DC734D8C", hash_generated_method = "CA80D26F06C78EEAAE83806F0DED22EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         String getFormatSpecifierText() {
            String varA942D769BD9D8BB09CFD57C0C5C86AE5_489686864 = (format.substring(startIndex, i));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return format.substring(startIndex, i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.119 -0400", hash_original_method = "6521B9C02DA744FF180556D39A74ED44", hash_generated_method = "F80BCB29CCFA7120747B2E853DD8F76E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int peek() {
            {
                Object var765273F0E3B5EB95414F86EBEA317E40_1877994486 = (format.charAt(i));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (i < length) ? format.charAt(i) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.119 -0400", hash_original_method = "F520742ED92EBACDB47FBF0D0B1F08F4", hash_generated_method = "DE662A119E1F1AFFFD9F57163AA166F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private char advance() {
            {
                if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
            } //End block
            char var7701A7CCE85ED6AA9880F4BA6BB09ECE_1500583081 = (format.charAt(i++));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (i >= length) {
                //throw unknownFormatConversionException();
            //}
            //return format.charAt(i++);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.120 -0400", hash_original_method = "DFAEBB829CC6A7AFE465DA1B9A0C1D5A", hash_generated_method = "8802CE87C244380BED8B64B09C0CA5AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private UnknownFormatConversionException unknownFormatConversionException() {
            if (DroidSafeAndroidRuntime.control) throw new UnknownFormatConversionException(getFormatSpecifierText());
            return (UnknownFormatConversionException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnknownFormatConversionException(getFormatSpecifierText());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.120 -0400", hash_original_method = "AD27190704DEC79DF3778A7C88589CDF", hash_generated_method = "DC45250D5ACA2BADC40DDD9D1885B81B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private FormatToken parseArgumentIndexAndFlags(FormatToken token) {
            dsTaint.addTaint(token.dsTaint);
            int position;
            position = i;
            int ch;
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_282082463 = (Character.isDigit(ch));
                {
                    int number;
                    number = nextInt();
                    {
                        boolean varAF443300A994E05CBD4A93B1F0A6046B_1150526313 = (peek() == '$');
                        {
                            advance();
                            {
                                if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException(getFormatSpecifierText());
                            } //End block
                            token.setArgIndex(Math.max(0, number - 1));
                        } //End block
                        {
                            {
                                i = position;
                            } //End block
                            {
                                FormatToken var69DAEFA423934291D77A1FFC213F208E_163123010 = (parseWidth(token, number));
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
                boolean varD959591D21FA1B51681982FB61D589FE_1356585368 = (token.setFlag(peek()));
                {
                    advance();
                } //End block
            } //End collapsed parenthetic
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_719844915 = (Character.isDigit(ch));
                {
                    FormatToken var5A48663D783AAF0717FAF62ACD7859D7_1443700516 = (parseWidth(token, nextInt()));
                } //End block
                {
                    FormatToken var31509ACF40811EFF270C1CF101979E79_1006382660 = (parsePrecision(token));
                } //End block
                {
                    FormatToken var8B11D054AAC67E20E5AD77C09C6D9280_622941099 = (parseConversionType(token));
                } //End block
            } //End collapsed parenthetic
            return (FormatToken)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.120 -0400", hash_original_method = "F4C6E47C7F58A93445972E2EDFDFCD5C", hash_generated_method = "5F2A829E7126FB4067AC283C9FB5C405")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private FormatToken parseWidth(FormatToken token, int width) {
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(width);
            token.setWidth(width);
            int ch;
            ch = peek();
            {
                FormatToken varF2239DB28F754960FDCC1174ADECA38B_238056106 = (parsePrecision(token));
            } //End block
            {
                FormatToken var10A662E1106310A5CAA7CBFB0467752C_379722587 = (parseConversionType(token));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.120 -0400", hash_original_method = "06DE93E908B11B43F41251F270A468F2", hash_generated_method = "F84BFC0B50A8435A5132C608C2E290DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private FormatToken parsePrecision(FormatToken token) {
            dsTaint.addTaint(token.dsTaint);
            advance();
            int ch;
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_1170833499 = (Character.isDigit(ch));
                {
                    token.setPrecision(nextInt());
                    FormatToken var8B11D054AAC67E20E5AD77C09C6D9280_1860188561 = (parseConversionType(token));
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.121 -0400", hash_original_method = "779E7C7A9E24C2B8C7A984530163E241", hash_generated_method = "ED76918D1D5DEF9DD28023B5D001A9D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.121 -0400", hash_original_method = "ADF8322FF676CF5038257F50E4E4E6DC", hash_generated_method = "C1DDA44801B3CAD05AC375C4A0CDEEEE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int nextInt() {
            long value;
            value = 0;
            {
                boolean var89C0C9F591E86A0985096DE42B7326D1_846079411 = (i < length && Character.isDigit(format.charAt(i)));
                {
                    value = 10 * value + (format.charAt(i++) - '0');
                    {
                        int varBF2312BB009815DC54B749D4D210B6C9_1139008019 = (failNextInt());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.121 -0400", hash_original_method = "F2814F47D4EB7F1D4CA24D9FE1C3918D", hash_generated_method = "9855A3A66551073F13FE795478991F09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int failNextInt() {
            {
                boolean varDB282127B78D2B872AE9DB5E44D7F6B7_1426973442 = (Character.isDigit(peek()));
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


    
    private static final char[] ZEROS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0' };
    private static final ThreadLocal<CachedDecimalFormat> cachedDecimalFormat = new ThreadLocal<CachedDecimalFormat>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.121 -0400", hash_original_method = "3BF85501572F336E7CB9026A6524A649", hash_generated_method = "1252687DE61DD9AC27A7F467EDF0BC4F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected CachedDecimalFormat initialValue() {
            CachedDecimalFormat var15BDDD72111A5C229D7BF55E14AB03E4_2117869341 = (new CachedDecimalFormat());
            return (CachedDecimalFormat)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CachedDecimalFormat();
        }

        
}; //Transformed anonymous class
}

