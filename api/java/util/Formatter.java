package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.537 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "3DC9338DC786F95D1A95A8961D85A2A6")

    private Appendable out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.537 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.537 -0400", hash_original_field = "61DD86C2DC75C3F569EC619BD283A33F", hash_generated_field = "613B0CE96D5332BFAF1329D4F111938C")

    private Object arg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.537 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.537 -0400", hash_original_field = "B7B849C43DF0AE6D73905E0D7DFFBD21", hash_generated_field = "FB61E2282DE2F9A3C415CEE063007787")

    private FormatToken formatToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.537 -0400", hash_original_field = "460DFB1105EAD6E581494BC8EB7172AC", hash_generated_field = "94160D1F6EC5CF5867F2CCE7946E9FCB")

    private IOException lastIOException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.538 -0400", hash_original_field = "E3E7EE28E6489646D907CCB03E05DAAD", hash_generated_field = "C9E2992A298A3ADEBF6945150F771649")

    private LocaleData localeData;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.538 -0400", hash_original_method = "776A8092D7EB6A8CE9FA3707C90FDC71", hash_generated_method = "84D520F5378D0961C20054F1B6C8CEC3")
    public  Formatter() {
        this(new StringBuilder(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.538 -0400", hash_original_method = "C10A7E7C6014F1D5457B2868B8DDD5FA", hash_generated_method = "31E6013FD29F4E00375F2E0819EFEC43")
    public  Formatter(Appendable a) {
        this(a, Locale.getDefault());
        addTaint(a.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.538 -0400", hash_original_method = "949ED46E62E9C1FD97345CAB1F572157", hash_generated_method = "1F77DEC42C276C4F532BB809AEBFC555")
    public  Formatter(Locale l) {
        this(new StringBuilder(), l);
        addTaint(l.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.539 -0400", hash_original_method = "731A0E308D6775F1250BD9086CA3748C", hash_generated_method = "470B7F8F60748480EE3440031861637F")
    public  Formatter(Appendable a, Locale l) {
    if(a == null)        
        {
            out = new StringBuilder();
        } //End block
        else
        {
            out = a;
        } //End block
        locale = l;
        // ---------- Original Method ----------
        //if (a == null) {
            //out = new StringBuilder();
        //} else {
            //out = a;
        //}
        //locale = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.540 -0400", hash_original_method = "55110CB3A063CDDA9DDF2A6FEEDBC4D6", hash_generated_method = "70BDD2B3DD755EDDD96C2C4A66B6ADFD")
    public  Formatter(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.540 -0400", hash_original_method = "D05AE6CA9B3694824C73C0B398D66198", hash_generated_method = "F00C95169A2C801D9F2667AF05A8DEA3")
    public  Formatter(String fileName, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new File(fileName), csn);
        addTaint(csn.getTaint());
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.540 -0400", hash_original_method = "106406A68116E4DC11358A25DB96C9D8", hash_generated_method = "3C730AAB253E20740C1D3314BBCAE1DB")
    public  Formatter(String fileName, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn, l);
        addTaint(l.getTaint());
        addTaint(csn.getTaint());
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.541 -0400", hash_original_method = "56C5088BBC7ACEBB0E3B42C5FC534A61", hash_generated_method = "589E7B2AC2ADE54B3D54DCD41B50441F")
    public  Formatter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.541 -0400", hash_original_method = "15C3BB1BBEBB7DA2B256558B7A83F1D2", hash_generated_method = "C1739D626FDEC289527DD1A976635F93")
    public  Formatter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(file, csn, Locale.getDefault());
        addTaint(csn.getTaint());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.542 -0400", hash_original_method = "11FC304A866A57AD6707E0AE5ACD74C6", hash_generated_method = "322FB5E5CA52A8C798F67AB147F0CEA3")
    public  Formatter(File file, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        addTaint(file.getTaint());
        FileOutputStream fout = null;
        try 
        {
            fout = new FileOutputStream(file);
            out = new BufferedWriter(new OutputStreamWriter(fout, csn));
        } //End block
        catch (RuntimeException e)
        {
            IoUtils.closeQuietly(fout);
            e.addTaint(taint);
            throw e;
        } //End block
        catch (UnsupportedEncodingException e)
        {
            IoUtils.closeQuietly(fout);
            e.addTaint(taint);
            throw e;
        } //End block
        locale = l;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.543 -0400", hash_original_method = "18094D8509766CE6FC608D9540C5972B", hash_generated_method = "86DB88A0468A92B37477CC3A3583D801")
    public  Formatter(OutputStream os) {
        out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        locale = Locale.getDefault();
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        //locale = Locale.getDefault();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.543 -0400", hash_original_method = "F6295FD9F7AB3AB7F721531D402E7F81", hash_generated_method = "1D099F685783C7C0CE31B5FF23D472D0")
    public  Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault());
        addTaint(csn.getTaint());
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.544 -0400", hash_original_method = "339D31BAB557832A3B8A75EB377C0635", hash_generated_method = "8BEF5CEA51D6B567DEC1210198AC5CE9")
    public  Formatter(OutputStream os, String csn, Locale l) throws UnsupportedEncodingException {
        out = new BufferedWriter(new OutputStreamWriter(os, csn));
        locale = l;
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, csn));
        //locale = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.544 -0400", hash_original_method = "6A92C9283CC7B01627E24F0E27824A3B", hash_generated_method = "1FB44483F510116A2A4A5B346B964275")
    public  Formatter(PrintStream ps) {
    if(ps == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_169098531 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_169098531.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_169098531;
        } //End block
        out = ps;
        locale = Locale.getDefault();
        // ---------- Original Method ----------
        //if (ps == null) {
            //throw new NullPointerException();
        //}
        //out = ps;
        //locale = Locale.getDefault();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.545 -0400", hash_original_method = "9D62CCD9646FE324AC0FFA6EB7C17C6C", hash_generated_method = "B23CB135B6FDDEF7097882A5786FBB04")
    private NativeDecimalFormat getDecimalFormat(String pattern) {
        addTaint(pattern.getTaint());
NativeDecimalFormat varF1A011F64A3D62CFB9F23834C4DD6D2F_1266283775 =         cachedDecimalFormat.get().update(localeData, pattern);
        varF1A011F64A3D62CFB9F23834C4DD6D2F_1266283775.addTaint(taint);
        return varF1A011F64A3D62CFB9F23834C4DD6D2F_1266283775;
        // ---------- Original Method ----------
        //return cachedDecimalFormat.get().update(localeData, pattern);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.545 -0400", hash_original_method = "E3DA6A4C963B6E9187963221C571CEC2", hash_generated_method = "A7DFCECBAB0E5B45EFF067A9EBD4568C")
    private void checkNotClosed() {
    if(closed)        
        {
            FormatterClosedException varDB7DCCFFD440B3B16365950F96FACF48_960234413 = new FormatterClosedException();
            varDB7DCCFFD440B3B16365950F96FACF48_960234413.addTaint(taint);
            throw varDB7DCCFFD440B3B16365950F96FACF48_960234413;
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new FormatterClosedException();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.546 -0400", hash_original_method = "B5A8A4A4A455286143E3BD4E75C6F0FE", hash_generated_method = "C42AD3195FAB2CE4EC1FA227DAE52EA9")
    public Locale locale() {
        checkNotClosed();
Locale varB14E682FEAD06D8198D8ADBCBD62DEDB_1196543822 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_1196543822.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_1196543822;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return locale;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.546 -0400", hash_original_method = "D73A5BF8E95D39CBD6819B9B1AA13C8D", hash_generated_method = "EB5A7356945C8971CE59ED66350DB69B")
    public Appendable out() {
        checkNotClosed();
Appendable varFE81D892BE5757A0E16305825903D324_1997337794 =         out;
        varFE81D892BE5757A0E16305825903D324_1997337794.addTaint(taint);
        return varFE81D892BE5757A0E16305825903D324_1997337794;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.546 -0400", hash_original_method = "39CF8FB3A631311648D12D228411CE26", hash_generated_method = "569C38BC3E8BAED62D1DD0F9B5A7D973")
    @Override
    public String toString() {
        checkNotClosed();
String var07C2101459B2E370F2E153543C128998_228639206 =         out.toString();
        var07C2101459B2E370F2E153543C128998_228639206.addTaint(taint);
        return var07C2101459B2E370F2E153543C128998_228639206;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.547 -0400", hash_original_method = "E9CBCF5548B5D691C8801114F0C41C59", hash_generated_method = "EFADF5E12C87CC67BAEC7A45000362DA")
    public void flush() {
        checkNotClosed();
    if(out instanceof Flushable)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.547 -0400", hash_original_method = "16C1939C51EF65BBD0A872F925CE78BF", hash_generated_method = "8962EA430320F1A230DCFF6EF0BF0AAF")
    public void close() {
    if(!closed)        
        {
            closed = true;
            try 
            {
    if(out instanceof Closeable)                
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.548 -0400", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "2A6C2B121DB03FC52DAEB793C331CF4A")
    public IOException ioException() {
IOException var1C9C3579611AFFB9BDE735EED6EBCBD7_916574172 =         lastIOException;
        var1C9C3579611AFFB9BDE735EED6EBCBD7_916574172.addTaint(taint);
        return var1C9C3579611AFFB9BDE735EED6EBCBD7_916574172;
        // ---------- Original Method ----------
        //return lastIOException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.548 -0400", hash_original_method = "EE9FCF62B0D200225753D8BA586AA3F5", hash_generated_method = "0C8E57ABE73949A4F853562EA270E923")
    public Formatter format(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
Formatter var8E35EA3485BA181532EAD8B41057C295_1356189114 =         format(this.locale, format, args);
        var8E35EA3485BA181532EAD8B41057C295_1356189114.addTaint(taint);
        return var8E35EA3485BA181532EAD8B41057C295_1356189114;
        // ---------- Original Method ----------
        //return format(this.locale, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.549 -0400", hash_original_method = "F45273151F6DD69ACB6CCC03C59753A4", hash_generated_method = "85F30CBEF81E558A21A5BEF2D9602197")
    public Formatter format(Locale l, String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        Locale originalLocale = locale;
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
Formatter var72A74007B2BE62B849F475C7BDA4658B_2407461 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2407461.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2407461;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.550 -0400", hash_original_method = "960E24FB807777DEBBE8328729AF6A3F", hash_generated_method = "8DFF86604E32DA382D5DAC4BDAD8027D")
    private void doFormat(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        checkNotClosed();
        FormatSpecifierParser fsp = new FormatSpecifierParser(format);
        int currentObjectIndex = 0;
        Object lastArgument = null;
        boolean hasLastArgumentSet = false;
        int length = format.length();
        int i = 0;
        while
(i < length)        
        {
            int plainTextStart = i;
            int nextPercent = format.indexOf('%', i);
            int plainTextEnd = (nextPercent == -1) ? length : nextPercent;
    if(plainTextEnd > plainTextStart)            
            {
                outputCharSequence(format, plainTextStart, plainTextEnd);
            } //End block
            i = plainTextEnd;
    if(i < length)            
            {
                FormatToken token = fsp.parseFormatToken(i + 1);
                Object argument = null;
    if(token.requireArgument())                
                {
                    int index = token.getArgIndex() == FormatToken.UNSET ? currentObjectIndex++ : token.getArgIndex();
                    argument = getArgument(args, index, fsp, lastArgument, hasLastArgumentSet);
                    lastArgument = argument;
                    hasLastArgumentSet = true;
                } //End block
                CharSequence substitution = transform(token, argument);
    if(substitution != null)                
                {
                    outputCharSequence(substitution, 0, substitution.length());
                } //End block
                i = fsp.i;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.551 -0400", hash_original_method = "4A93F3F0DF6F4E45CC93AF5660722832", hash_generated_method = "8A6638FE494E3D64F5738509388116C7")
    private void outputCharSequence(CharSequence cs, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(cs.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.551 -0400", hash_original_method = "4EF20CF84298D39EE17983F53878C341", hash_generated_method = "E707293968A92FE5B504ED7667121A59")
    private Object getArgument(Object[] args, int index, FormatSpecifierParser fsp,
            Object lastArgument, boolean hasLastArgumentSet) {
        addTaint(hasLastArgumentSet);
        addTaint(lastArgument.getTaint());
        addTaint(fsp.getTaint());
        addTaint(index);
        addTaint(args[0].getTaint());
    if(index == FormatToken.LAST_ARGUMENT_INDEX && !hasLastArgumentSet)        
        {
            MissingFormatArgumentException varC793CF7636E4205D1F1A29E771920DF1_678001637 = new MissingFormatArgumentException("<");
            varC793CF7636E4205D1F1A29E771920DF1_678001637.addTaint(taint);
            throw varC793CF7636E4205D1F1A29E771920DF1_678001637;
        } //End block
    if(args == null)        
        {
Object var540C13E9E156B687226421B24F2DF178_2129924779 =             null;
            var540C13E9E156B687226421B24F2DF178_2129924779.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2129924779;
        } //End block
    if(index >= args.length)        
        {
            MissingFormatArgumentException var9B5CAE4F6750A14D247271DCE4FF64AB_881483416 = new MissingFormatArgumentException(fsp.getFormatSpecifierText());
            var9B5CAE4F6750A14D247271DCE4FF64AB_881483416.addTaint(taint);
            throw var9B5CAE4F6750A14D247271DCE4FF64AB_881483416;
        } //End block
    if(index == FormatToken.LAST_ARGUMENT_INDEX)        
        {
Object var4281D021F64DF87C38BFCFDA86485B52_1043861315 =             lastArgument;
            var4281D021F64DF87C38BFCFDA86485B52_1043861315.addTaint(taint);
            return var4281D021F64DF87C38BFCFDA86485B52_1043861315;
        } //End block
Object var0F0E04C2C9573F1EA16ACDFC27A934D9_392002272 =         args[index];
        var0F0E04C2C9573F1EA16ACDFC27A934D9_392002272.addTaint(taint);
        return var0F0E04C2C9573F1EA16ACDFC27A934D9_392002272;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.571 -0400", hash_original_method = "0237F1DF7BD7A386A4F4D1B44D43876F", hash_generated_method = "3B94DE0E63561DBD3E47F830F925836B")
    private CharSequence transform(FormatToken token, Object argument) {
        this.formatToken = token;
        this.arg = argument;
    if(token.isDefault())        
        {
switch(token.getConversionType()){
            case 's':
    if(arg == null)            
            {
CharSequence var1D801F10795A50869C3F1F514D9B9BF5_1100564016 =                 "null";
                var1D801F10795A50869C3F1F514D9B9BF5_1100564016.addTaint(taint);
                return var1D801F10795A50869C3F1F514D9B9BF5_1100564016;
            } //End block
            else
    if(!(arg instanceof Formattable))            
            {
CharSequence var47BDA2C3136BDDAAB63E8E76220E5341_371459545 =                 arg.toString();
                var47BDA2C3136BDDAAB63E8E76220E5341_371459545.addTaint(taint);
                return var47BDA2C3136BDDAAB63E8E76220E5341_371459545;
            } //End block
            break;
            case 'd':
            boolean needLocalizedDigits = (localeData.zeroDigit != '0');
    if(out instanceof StringBuilder && !needLocalizedDigits)            
            {
    if(arg instanceof Integer || arg instanceof Short || arg instanceof Byte)                
                {
                    IntegralToString.appendInt((StringBuilder) out, ((Number) arg).intValue());
CharSequence var540C13E9E156B687226421B24F2DF178_1936919117 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1936919117.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1936919117;
                } //End block
                else
    if(arg instanceof Long)                
                {
                    IntegralToString.appendLong((StringBuilder) out, ((Long) arg).longValue());
CharSequence var540C13E9E156B687226421B24F2DF178_2103975973 =                     null;
                    var540C13E9E156B687226421B24F2DF178_2103975973.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_2103975973;
                } //End block
            } //End block
    if(arg instanceof Integer || arg instanceof Long || arg instanceof Short || arg instanceof Byte)            
            {
                String result = arg.toString();
CharSequence varAB8ABE709B1A47CC2CFE1E2C0F8D6B75_834597793 =                 needLocalizedDigits ? localizeDigits(result) : result;
                varAB8ABE709B1A47CC2CFE1E2C0F8D6B75_834597793.addTaint(taint);
                return varAB8ABE709B1A47CC2CFE1E2C0F8D6B75_834597793;
            } //End block
}
        } //End block
        formatToken.checkFlags(arg);
        CharSequence result;
switch(token.getConversionType()){
        case 'B':
        case 'b':
        result = transformFromBoolean();
        break;
        case 'H':
        case 'h':
        result = transformFromHashCode();
        break;
        case 'S':
        case 's':
        result = transformFromString();
        break;
        case 'C':
        case 'c':
        result = transformFromCharacter();
        break;
        case 'd':
        case 'o':
        case 'x':
        case 'X':
    if(arg == null || arg instanceof BigInteger)        
        {
            result = transformFromBigInteger();
        } //End block
        else
        {
            result = transformFromInteger();
        } //End block
        break;
        case 'A':
        case 'a':
        case 'E':
        case 'e':
        case 'f':
        case 'G':
        case 'g':
        result = transformFromFloat();
        break;
        case '%':
        result = transformFromPercent();
        break;
        case 'n':
        result = System.lineSeparator();
        break;
        case 't':
        case 'T':
        result = transformFromDateTime();
        break;
        default:
        java.util.UnknownFormatConversionException var208067E908B5592DB164F82935D81B52_1013888840 = token.unknownFormatConversionException();
        var208067E908B5592DB164F82935D81B52_1013888840.addTaint(taint);
        throw var208067E908B5592DB164F82935D81B52_1013888840;
}    if(Character.isUpperCase(token.getConversionType()))        
        {
    if(result != null)            
            {
                result = result.toString().toUpperCase(locale);
            } //End block
        } //End block
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_1094200576 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1094200576.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1094200576;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.572 -0400", hash_original_method = "D44F27ADB431306CEB9F9E1F25036901", hash_generated_method = "FEA15854DC24FC73872B1FFE913788BC")
    private IllegalFormatConversionException badArgumentType() {
        IllegalFormatConversionException var8D9A9D73BB7B70CBBFC4949C6CAE468B_2030247720 = new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
        var8D9A9D73BB7B70CBBFC4949C6CAE468B_2030247720.addTaint(taint);
        throw var8D9A9D73BB7B70CBBFC4949C6CAE468B_2030247720;
        // ---------- Original Method ----------
        //throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.573 -0400", hash_original_method = "8CD3AC57424B332A3611698407D98FD3", hash_generated_method = "2EF05838445B194EBAB57DD2B99401C2")
    private CharSequence localizeDigits(CharSequence s) {
        addTaint(s.getTaint());
        int length = s.length();
        int offsetToLocalizedDigits = localeData.zeroDigit - '0';
        StringBuilder result = new StringBuilder(length);
for(int i = 0;i < length;++i)
        {
            char ch = s.charAt(i);
    if(ch >= '0' && ch <= '9')            
            {
                ch += offsetToLocalizedDigits;
            } //End block
            result.append(ch);
        } //End block
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_1660905223 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1660905223.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1660905223;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.574 -0400", hash_original_method = "CC3FF2DA7072A05A8664F97319F6C752", hash_generated_method = "484A3468AFBED2408300A9111D0BC50B")
    private CharSequence insertGrouping(CharSequence s) {
        addTaint(s.getTaint());
        StringBuilder result = new StringBuilder(s.length() + s.length()/3);
        int digitsLength = s.length();
        int i = 0;
    if(s.charAt(0) == '-')        
        {
            --digitsLength;
            ++i;
            result.append('-');
        } //End block
        int headLength = digitsLength % 3;
    if(headLength == 0)        
        {
            headLength = 3;
        } //End block
        result.append(s, i, i + headLength);
        i += headLength;
for(;i < s.length();i += 3)
        {
            result.append(localeData.groupingSeparator);
            result.append(s, i, i + 3);
        } //End block
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_676191315 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_676191315.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_676191315;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.574 -0400", hash_original_method = "54F34C95EDCEEE411BD250D07A12E500", hash_generated_method = "7AE081367027A3219CD96437497BB82A")
    private CharSequence transformFromBoolean() {
        CharSequence result;
    if(arg instanceof Boolean)        
        {
            result = arg.toString();
        } //End block
        else
    if(arg == null)        
        {
            result = "false";
        } //End block
        else
        {
            result = "true";
        } //End block
CharSequence var60F8A6E047F2F602EBD809018D02719B_262455140 =         padding(result, 0);
        var60F8A6E047F2F602EBD809018D02719B_262455140.addTaint(taint);
        return var60F8A6E047F2F602EBD809018D02719B_262455140;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.575 -0400", hash_original_method = "FEE63D21FF5AA7B8F21641D7D3CB6697", hash_generated_method = "877E2E2A69E190695D0332E47E56BF02")
    private CharSequence transformFromHashCode() {
        CharSequence result;
    if(arg == null)        
        {
            result = "null";
        } //End block
        else
        {
            result = Integer.toHexString(arg.hashCode());
        } //End block
CharSequence var60F8A6E047F2F602EBD809018D02719B_1934759919 =         padding(result, 0);
        var60F8A6E047F2F602EBD809018D02719B_1934759919.addTaint(taint);
        return var60F8A6E047F2F602EBD809018D02719B_1934759919;
        // ---------- Original Method ----------
        //CharSequence result;
        //if (arg == null) {
            //result = "null";
        //} else {
            //result = Integer.toHexString(arg.hashCode());
        //}
        //return padding(result, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.576 -0400", hash_original_method = "41FDF272148D1D909A3CC241D4F2B404", hash_generated_method = "71250C9766D213CFE10359432AA69657")
    private CharSequence transformFromString() {
    if(arg instanceof Formattable)        
        {
            int flags = 0;
    if(formatToken.flagMinus)            
            {
                flags |= FormattableFlags.LEFT_JUSTIFY;
            } //End block
    if(formatToken.flagSharp)            
            {
                flags |= FormattableFlags.ALTERNATE;
            } //End block
    if(Character.isUpperCase(formatToken.getConversionType()))            
            {
                flags |= FormattableFlags.UPPERCASE;
            } //End block
            ((Formattable) arg).formatTo(this, flags, formatToken.getWidth(),
                    formatToken.getPrecision());
CharSequence var540C13E9E156B687226421B24F2DF178_1200156733 =             null;
            var540C13E9E156B687226421B24F2DF178_1200156733.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1200156733;
        } //End block
        CharSequence result = arg != null ? arg.toString() : "null";
CharSequence var60F8A6E047F2F602EBD809018D02719B_303617012 =         padding(result, 0);
        var60F8A6E047F2F602EBD809018D02719B_303617012.addTaint(taint);
        return var60F8A6E047F2F602EBD809018D02719B_303617012;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.586 -0400", hash_original_method = "78103310C8550D540C751775D2E73F1B", hash_generated_method = "EA124265309F1D0FE8926BDEE8C78178")
    private CharSequence transformFromCharacter() {
    if(arg == null)        
        {
CharSequence var45945176AADF4B8A5B5D84B27915BF58_1031887277 =             padding("null", 0);
            var45945176AADF4B8A5B5D84B27915BF58_1031887277.addTaint(taint);
            return var45945176AADF4B8A5B5D84B27915BF58_1031887277;
        } //End block
    if(arg instanceof Character)        
        {
CharSequence varD5C33FD989D72B0C9E434BC342547F6E_1499255244 =             padding(String.valueOf(arg), 0);
            varD5C33FD989D72B0C9E434BC342547F6E_1499255244.addTaint(taint);
            return varD5C33FD989D72B0C9E434BC342547F6E_1499255244;
        } //End block
        else
    if(arg instanceof Byte || arg instanceof Short || arg instanceof Integer)        
        {
            int codePoint = ((Number) arg).intValue();
    if(!Character.isValidCodePoint(codePoint))            
            {
                IllegalFormatCodePointException var9AD0D3AF697915D77E7D36CE21B52583_91240865 = new IllegalFormatCodePointException(codePoint);
                var9AD0D3AF697915D77E7D36CE21B52583_91240865.addTaint(taint);
                throw var9AD0D3AF697915D77E7D36CE21B52583_91240865;
            } //End block
            CharSequence result = (codePoint < Character.MIN_SUPPLEMENTARY_CODE_POINT)
                    ? String.valueOf((char) codePoint)
                    : String.valueOf(Character.toChars(codePoint));
CharSequence var60F8A6E047F2F602EBD809018D02719B_430989559 =             padding(result, 0);
            var60F8A6E047F2F602EBD809018D02719B_430989559.addTaint(taint);
            return var60F8A6E047F2F602EBD809018D02719B_430989559;
        } //End block
        else
        {
            java.util.IllegalFormatConversionException var9C39893A6EC12A3AA5B5E2ACF5548E23_1936640964 = badArgumentType();
            var9C39893A6EC12A3AA5B5E2ACF5548E23_1936640964.addTaint(taint);
            throw var9C39893A6EC12A3AA5B5E2ACF5548E23_1936640964;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.587 -0400", hash_original_method = "1802F533F155B8AA49557FA5A74B7DBE", hash_generated_method = "E1F7EE472221D9DCE6328F5B004DF845")
    private CharSequence transformFromPercent() {
CharSequence var3B37D2693C4C26B1B03169D06EE532D9_1618242259 =         padding("%", 0);
        var3B37D2693C4C26B1B03169D06EE532D9_1618242259.addTaint(taint);
        return var3B37D2693C4C26B1B03169D06EE532D9_1618242259;
        // ---------- Original Method ----------
        //return padding("%", 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.588 -0400", hash_original_method = "EF7726D1BC858C4C5BDC40B9ACBD3ABF", hash_generated_method = "B7C8D4CDF24273364AE01F62B9DF3910")
    private CharSequence padding(CharSequence source, int startIndex) {
        addTaint(startIndex);
        addTaint(source.getTaint());
        int start = startIndex;
        int width = formatToken.getWidth();
        int precision = formatToken.getPrecision();
        int length = source.length();
    if(precision >= 0)        
        {
            length = Math.min(length, precision);
    if(source instanceof StringBuilder)            
            {
                ((StringBuilder) source).setLength(length);
            } //End block
            else
            {
                source = source.subSequence(0, length);
            } //End block
        } //End block
    if(width > 0)        
        {
            width = Math.max(source.length(), width);
        } //End block
    if(length >= width)        
        {
CharSequence var87D92E4D22D3928BDE6A72969186AF86_2101570589 =             source;
            var87D92E4D22D3928BDE6A72969186AF86_2101570589.addTaint(taint);
            return var87D92E4D22D3928BDE6A72969186AF86_2101570589;
        } //End block
        char paddingChar = '\u0020';
    if(formatToken.flagZero)        
        {
    if(formatToken.getConversionType() == 'd')            
            {
                paddingChar = localeData.zeroDigit;
            } //End block
            else
            {
                paddingChar = '0';
            } //End block
        } //End block
        else
        {
            start = 0;
        } //End block
        char[] paddingChars = new char[width - length];
        Arrays.fill(paddingChars, paddingChar);
        boolean paddingRight = formatToken.flagMinus;
        StringBuilder result = toStringBuilder(source);
    if(paddingRight)        
        {
            result.append(paddingChars);
        } //End block
        else
        {
            result.insert(start, paddingChars);
        } //End block
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_408197534 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_408197534.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_408197534;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.589 -0400", hash_original_method = "AA67EEFB247ACC7BDA1BABCD03B30A80", hash_generated_method = "ED07D5B5DA1D6AD994BB4A7D5814B1CD")
    private StringBuilder toStringBuilder(CharSequence cs) {
        addTaint(cs.getTaint());
StringBuilder var7D98D02202DEE9E6FC80D24C7671D12C_818497572 =         cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
        var7D98D02202DEE9E6FC80D24C7671D12C_818497572.addTaint(taint);
        return var7D98D02202DEE9E6FC80D24C7671D12C_818497572;
        // ---------- Original Method ----------
        //return cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.590 -0400", hash_original_method = "CE1A2CC9741A13D14659E3953A660AC1", hash_generated_method = "2FD364A265CB64E4FB06BA5F1CE23A87")
    private StringBuilder wrapParentheses(StringBuilder result) {
        addTaint(result.getTaint());
        result.setCharAt(0, '(');
    if(formatToken.flagZero)        
        {
            formatToken.setWidth(formatToken.getWidth() - 1);
            result = (StringBuilder) padding(result, 1);
            result.append(')');
        } //End block
        else
        {
            result.append(')');
            result = (StringBuilder) padding(result, 0);
        } //End block
StringBuilder varDC838461EE2FA0CA4C9BBB70A15456B0_326647643 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_326647643.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_326647643;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.615 -0400", hash_original_method = "FADDE3D8C4FA639F028B03B661D10023", hash_generated_method = "8CD42CA4522374773B9E6C0FFC1A461E")
    private CharSequence transformFromInteger() {
        int startIndex = 0;
        StringBuilder result = new StringBuilder();
        char currentConversionType = formatToken.getConversionType();
        long value;
    if(arg instanceof Long)        
        {
            value = ((Long) arg).longValue();
        } //End block
        else
    if(arg instanceof Integer)        
        {
            value = ((Integer) arg).longValue();
        } //End block
        else
    if(arg instanceof Short)        
        {
            value = ((Short) arg).longValue();
        } //End block
        else
    if(arg instanceof Byte)        
        {
            value = ((Byte) arg).longValue();
        } //End block
        else
        {
            java.util.IllegalFormatConversionException var9C39893A6EC12A3AA5B5E2ACF5548E23_1620252436 = badArgumentType();
            var9C39893A6EC12A3AA5B5E2ACF5548E23_1620252436.addTaint(taint);
            throw var9C39893A6EC12A3AA5B5E2ACF5548E23_1620252436;
        } //End block
    if(formatToken.flagSharp)        
        {
    if(currentConversionType == 'o')            
            {
                result.append("0");
                startIndex += 1;
            } //End block
            else
            {
                result.append("0x");
                startIndex += 2;
            } //End block
        } //End block
    if(currentConversionType == 'd')        
        {
            CharSequence digits = Long.toString(value);
    if(formatToken.flagComma)            
            {
                digits = insertGrouping(digits);
            } //End block
    if(localeData.zeroDigit != '0')            
            {
                digits = localizeDigits(digits);
            } //End block
            result.append(digits);
    if(value < 0)            
            {
    if(formatToken.flagParenthesis)                
                {
CharSequence var41C2604B5A23F4EEB6A0946B3943BBD6_796153477 =                     wrapParentheses(result);
                    var41C2604B5A23F4EEB6A0946B3943BBD6_796153477.addTaint(taint);
                    return var41C2604B5A23F4EEB6A0946B3943BBD6_796153477;
                } //End block
                else
    if(formatToken.flagZero)                
                {
                    startIndex++;
                } //End block
            } //End block
            else
            {
    if(formatToken.flagPlus)                
                {
                    result.insert(0, '+');
                    startIndex += 1;
                } //End block
                else
    if(formatToken.flagSpace)                
                {
                    result.insert(0, ' ');
                    startIndex += 1;
                } //End block
            } //End block
        } //End block
        else
        {
    if(arg instanceof Byte)            
            {
                value &= 0xffL;
            } //End block
            else
    if(arg instanceof Short)            
            {
                value &= 0xffffL;
            } //End block
            else
    if(arg instanceof Integer)            
            {
                value &= 0xffffffffL;
            } //End block
    if(currentConversionType == 'o')            
            {
                result.append(Long.toOctalString(value));
            } //End block
            else
            {
                result.append(Long.toHexString(value));
            } //End block
        } //End block
CharSequence varE4AAF0D88C94F7EDF0E0F68A12FC9293_1418304749 =         padding(result, startIndex);
        varE4AAF0D88C94F7EDF0E0F68A12FC9293_1418304749.addTaint(taint);
        return varE4AAF0D88C94F7EDF0E0F68A12FC9293_1418304749;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.616 -0400", hash_original_method = "15D0DEB8422EE33E04C98AFC872D1D51", hash_generated_method = "D4F6497D0608D61356351665B5CD616D")
    private CharSequence transformFromNull() {
        formatToken.flagZero = false;
CharSequence var45945176AADF4B8A5B5D84B27915BF58_1482531898 =         padding("null", 0);
        var45945176AADF4B8A5B5D84B27915BF58_1482531898.addTaint(taint);
        return var45945176AADF4B8A5B5D84B27915BF58_1482531898;
        // ---------- Original Method ----------
        //formatToken.flagZero = false;
        //return padding("null", 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.618 -0400", hash_original_method = "28740AE89E2FC451EFE3093F54121A6C", hash_generated_method = "0C3A8D6F201015E2C113A78FA1F4F359")
    private CharSequence transformFromBigInteger() {
        int startIndex = 0;
        StringBuilder result = new StringBuilder();
        BigInteger bigInt = (BigInteger) arg;
        char currentConversionType = formatToken.getConversionType();
    if(bigInt == null)        
        {
CharSequence var8E84C70E278B61733C6D728DF0048660_32752827 =             transformFromNull();
            var8E84C70E278B61733C6D728DF0048660_32752827.addTaint(taint);
            return var8E84C70E278B61733C6D728DF0048660_32752827;
        } //End block
        boolean isNegative = (bigInt.compareTo(BigInteger.ZERO) < 0);
    if(currentConversionType == 'd')        
        {
            CharSequence digits = bigInt.toString(10);
    if(formatToken.flagComma)            
            {
                digits = insertGrouping(digits);
            } //End block
            result.append(digits);
        } //End block
        else
    if(currentConversionType == 'o')        
        {
            result.append(bigInt.toString(8));
        } //End block
        else
        {
            result.append(bigInt.toString(16));
        } //End block
    if(formatToken.flagSharp)        
        {
            startIndex = isNegative ? 1 : 0;
    if(currentConversionType == 'o')            
            {
                result.insert(startIndex, "0");
                startIndex += 1;
            } //End block
            else
    if(currentConversionType == 'x' || currentConversionType == 'X')            
            {
                result.insert(startIndex, "0x");
                startIndex += 2;
            } //End block
        } //End block
    if(!isNegative)        
        {
    if(formatToken.flagPlus)            
            {
                result.insert(0, '+');
                startIndex += 1;
            } //End block
    if(formatToken.flagSpace)            
            {
                result.insert(0, ' ');
                startIndex += 1;
            } //End block
        } //End block
    if(isNegative && formatToken.flagParenthesis)        
        {
CharSequence var41C2604B5A23F4EEB6A0946B3943BBD6_804861802 =             wrapParentheses(result);
            var41C2604B5A23F4EEB6A0946B3943BBD6_804861802.addTaint(taint);
            return var41C2604B5A23F4EEB6A0946B3943BBD6_804861802;
        } //End block
    if(isNegative && formatToken.flagZero)        
        {
            startIndex++;
        } //End block
CharSequence varE4AAF0D88C94F7EDF0E0F68A12FC9293_1329218267 =         padding(result, startIndex);
        varE4AAF0D88C94F7EDF0E0F68A12FC9293_1329218267.addTaint(taint);
        return varE4AAF0D88C94F7EDF0E0F68A12FC9293_1329218267;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.628 -0400", hash_original_method = "3FA485DEFE055FA59E9A89B7029B3055", hash_generated_method = "6E4B0B152137E97DFEB43F0A0034C2D1")
    private CharSequence transformFromDateTime() {
    if(arg == null)        
        {
CharSequence var8E84C70E278B61733C6D728DF0048660_1371425112 =             transformFromNull();
            var8E84C70E278B61733C6D728DF0048660_1371425112.addTaint(taint);
            return var8E84C70E278B61733C6D728DF0048660_1371425112;
        } //End block
        Calendar calendar;
    if(arg instanceof Calendar)        
        {
            calendar = (Calendar) arg;
        } //End block
        else
        {
            Date date = null;
    if(arg instanceof Long)            
            {
                date = new Date(((Long) arg).longValue());
            } //End block
            else
    if(arg instanceof Date)            
            {
                date = (Date) arg;
            } //End block
            else
            {
                java.util.IllegalFormatConversionException var9C39893A6EC12A3AA5B5E2ACF5548E23_1451738750 = badArgumentType();
                var9C39893A6EC12A3AA5B5E2ACF5548E23_1451738750.addTaint(taint);
                throw var9C39893A6EC12A3AA5B5E2ACF5548E23_1451738750;
            } //End block
            calendar = Calendar.getInstance(locale);
            calendar.setTime(date);
        } //End block
        StringBuilder result = new StringBuilder();
    if(!appendT(result, formatToken.getDateSuffix(), calendar))        
        {
            java.util.UnknownFormatConversionException varC5A83382DFB85648592F35074607F3BE_2142397142 = formatToken.unknownFormatConversionException();
            varC5A83382DFB85648592F35074607F3BE_2142397142.addTaint(taint);
            throw varC5A83382DFB85648592F35074607F3BE_2142397142;
        } //End block
CharSequence var60F8A6E047F2F602EBD809018D02719B_1872211283 =         padding(result, 0);
        var60F8A6E047F2F602EBD809018D02719B_1872211283.addTaint(taint);
        return var60F8A6E047F2F602EBD809018D02719B_1872211283;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.631 -0400", hash_original_method = "6A85D50A5F6F83B5DE3D767D1CCF3B76", hash_generated_method = "6D6B5A353826F372CFBABF8A80D86CE5")
    private boolean appendT(StringBuilder result, char conversion, Calendar calendar) {
        addTaint(calendar.getTaint());
        addTaint(conversion);
        addTaint(result.getTaint());
switch(conversion){
        case 'A':
        result.append(localeData.longWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
        boolean varB326B5062B2F0E69046810717534CB09_1013722858 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122113591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_122113591;
        case 'a':
        result.append(localeData.shortWeekdayNames[calendar.get(Calendar.DAY_OF_WEEK)]);
        boolean varB326B5062B2F0E69046810717534CB09_725518980 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706973413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706973413;
        case 'B':
        result.append(localeData.longMonthNames[calendar.get(Calendar.MONTH)]);
        boolean varB326B5062B2F0E69046810717534CB09_385531143 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_945762220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_945762220;
        case 'b':
        case 'h':
        result.append(localeData.shortMonthNames[calendar.get(Calendar.MONTH)]);
        boolean varB326B5062B2F0E69046810717534CB09_1415608462 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87838091 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_87838091;
        case 'C':
        appendLocalized(result, calendar.get(Calendar.YEAR) / 100, 2);
        boolean varB326B5062B2F0E69046810717534CB09_1698080103 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202031465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202031465;
        case 'D':
        appendT(result, 'm', calendar);
        result.append('/');
        appendT(result, 'd', calendar);
        result.append('/');
        appendT(result, 'y', calendar);
        boolean varB326B5062B2F0E69046810717534CB09_2118692073 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488846542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488846542;
        case 'F':
        appendT(result, 'Y', calendar);
        result.append('-');
        appendT(result, 'm', calendar);
        result.append('-');
        appendT(result, 'd', calendar);
        boolean varB326B5062B2F0E69046810717534CB09_1524757417 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372990904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372990904;
        case 'H':
        appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 2);
        boolean varB326B5062B2F0E69046810717534CB09_1643699629 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513826426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513826426;
        case 'I':
        appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 2);
        boolean varB326B5062B2F0E69046810717534CB09_1246703175 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003194945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003194945;
        case 'L':
        appendLocalized(result, calendar.get(Calendar.MILLISECOND), 3);
        boolean varB326B5062B2F0E69046810717534CB09_1953428819 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1977217978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1977217978;
        case 'M':
        appendLocalized(result, calendar.get(Calendar.MINUTE), 2);
        boolean varB326B5062B2F0E69046810717534CB09_819566202 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442331249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442331249;
        case 'N':
        appendLocalized(result, calendar.get(Calendar.MILLISECOND) * 1000000L, 9);
        boolean varB326B5062B2F0E69046810717534CB09_113756502 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546730426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546730426;
        case 'Q':
        appendLocalized(result, calendar.getTimeInMillis(), 0);
        boolean varB326B5062B2F0E69046810717534CB09_1825666910 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_760799873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_760799873;
        case 'R':
        appendT(result, 'H', calendar);
        result.append(':');
        appendT(result, 'M', calendar);
        boolean varB326B5062B2F0E69046810717534CB09_1787408984 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700499443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_700499443;
        case 'S':
        appendLocalized(result, calendar.get(Calendar.SECOND), 2);
        boolean varB326B5062B2F0E69046810717534CB09_294085661 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158375996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158375996;
        case 'T':
        appendT(result, 'H', calendar);
        result.append(':');
        appendT(result, 'M', calendar);
        result.append(':');
        appendT(result, 'S', calendar);
        boolean varB326B5062B2F0E69046810717534CB09_1039866196 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067793627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067793627;
        case 'Y':
        appendLocalized(result, calendar.get(Calendar.YEAR), 4);
        boolean varB326B5062B2F0E69046810717534CB09_1766798406 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746511369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746511369;
        case 'Z':
        TimeZone timeZone = calendar.getTimeZone();
        result.append(timeZone.getDisplayName(timeZone.inDaylightTime(calendar.getTime()),
                    TimeZone.SHORT, locale));
        boolean varB326B5062B2F0E69046810717534CB09_1488691173 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1522243421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1522243421;
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
        boolean varB326B5062B2F0E69046810717534CB09_1691689528 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266572989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_266572989;
        case 'd':
        appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 2);
        boolean varB326B5062B2F0E69046810717534CB09_1773045161 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1836806247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1836806247;
        case 'e':
        appendLocalized(result, calendar.get(Calendar.DAY_OF_MONTH), 0);
        boolean varB326B5062B2F0E69046810717534CB09_1783126997 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444399467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444399467;
        case 'j':
        appendLocalized(result, calendar.get(Calendar.DAY_OF_YEAR), 3);
        boolean varB326B5062B2F0E69046810717534CB09_1903922742 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1270337014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1270337014;
        case 'k':
        appendLocalized(result, calendar.get(Calendar.HOUR_OF_DAY), 0);
        boolean varB326B5062B2F0E69046810717534CB09_1086333037 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115752613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115752613;
        case 'l':
        appendLocalized(result, to12Hour(calendar.get(Calendar.HOUR)), 0);
        boolean varB326B5062B2F0E69046810717534CB09_496901738 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637603806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637603806;
        case 'm':
        appendLocalized(result, calendar.get(Calendar.MONTH) + 1, 2);
        boolean varB326B5062B2F0E69046810717534CB09_1148172554 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864892833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864892833;
        case 'p':
        result.append(localeData.amPm[calendar.get(Calendar.AM_PM)].toLowerCase(locale));
        boolean varB326B5062B2F0E69046810717534CB09_877287314 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135694650 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135694650;
        case 'r':
        appendT(result, 'I', calendar);
        result.append(':');
        appendT(result, 'M', calendar);
        result.append(':');
        appendT(result, 'S', calendar);
        result.append(' ');
        result.append(localeData.amPm[calendar.get(Calendar.AM_PM)]);
        boolean varB326B5062B2F0E69046810717534CB09_1439040963 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265807428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265807428;
        case 's':
        appendLocalized(result, calendar.getTimeInMillis() / 1000, 0);
        boolean varB326B5062B2F0E69046810717534CB09_695879787 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577312394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577312394;
        case 'y':
        appendLocalized(result, calendar.get(Calendar.YEAR) % 100, 2);
        boolean varB326B5062B2F0E69046810717534CB09_404587093 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172757126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172757126;
        case 'z':
        long offset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        char sign = '+';
    if(offset < 0)        
        {
            sign = '-';
            offset = -offset;
        } //End block
        result.append(sign);
        appendLocalized(result, offset / 3600000, 2);
        appendLocalized(result, (offset % 3600000) / 60000, 2);
        boolean varB326B5062B2F0E69046810717534CB09_1776283831 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220198827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220198827;
}        boolean var68934A3E9455FA72420237EB05902327_1225866517 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200606819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_200606819;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.632 -0400", hash_original_method = "07C369462F22245026E1280008B34AEC", hash_generated_method = "10C67F75C7EA739550778958A99E90ED")
    private int to12Hour(int hour) {
        addTaint(hour);
        int var1A484E953C5CAB3BD2BECDB8115C2E0B_113323287 = (hour == 0 ? 12 : hour);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7015636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_7015636;
        // ---------- Original Method ----------
        //return hour == 0 ? 12 : hour;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.633 -0400", hash_original_method = "60B30B4DC0B127EF94D361BC9EB2AF90", hash_generated_method = "F932EDC027880E6B8472E25FE2452DFC")
    private void appendLocalized(StringBuilder result, long value, int width) {
        addTaint(width);
        addTaint(value);
        addTaint(result.getTaint());
        int paddingIndex = result.length();
        char zeroDigit = localeData.zeroDigit;
    if(zeroDigit == '0')        
        {
            result.append(value);
        } //End block
        else
        {
            result.append(localizeDigits(Long.toString(value)));
        } //End block
        int zeroCount = width - (result.length() - paddingIndex);
    if(zeroCount <= 0)        
        {
            return;
        } //End block
    if(zeroDigit == '0')        
        {
            result.insert(paddingIndex, ZEROS, 0, zeroCount);
        } //End block
        else
        {
for(int i = 0;i < zeroCount;++i)
            {
                result.insert(paddingIndex, zeroDigit);
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.635 -0400", hash_original_method = "977B62B975352D4F075C1101DB18FB73", hash_generated_method = "C6198FB99FA8CDB8CB5C08251D6541AC")
    private CharSequence transformFromSpecialNumber(double d) {
        addTaint(d);
        String source = null;
    if(Double.isNaN(d))        
        {
            source = "NaN";
        } //End block
        else
    if(d == Double.POSITIVE_INFINITY)        
        {
    if(formatToken.flagPlus)            
            {
                source = "+Infinity";
            } //End block
            else
    if(formatToken.flagSpace)            
            {
                source = " Infinity";
            } //End block
            else
            {
                source = "Infinity";
            } //End block
        } //End block
        else
    if(d == Double.NEGATIVE_INFINITY)        
        {
    if(formatToken.flagParenthesis)            
            {
                source = "(Infinity)";
            } //End block
            else
            {
                source = "-Infinity";
            } //End block
        } //End block
        else
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1891617038 =             null;
            var540C13E9E156B687226421B24F2DF178_1891617038.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1891617038;
        } //End block
        formatToken.setPrecision(FormatToken.UNSET);
        formatToken.flagZero = false;
CharSequence varDC725D1E462A197A483AC17012C8475C_1590178981 =         padding(source, 0);
        varDC725D1E462A197A483AC17012C8475C_1590178981.addTaint(taint);
        return varDC725D1E462A197A483AC17012C8475C_1590178981;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.651 -0400", hash_original_method = "DECF7ECF8109F764E81E2CF8101BCB0C", hash_generated_method = "27DBEECF61BB11D05320D7D434D06E1F")
    private CharSequence transformFromFloat() {
    if(arg == null)        
        {
CharSequence var8E84C70E278B61733C6D728DF0048660_821916821 =             transformFromNull();
            var8E84C70E278B61733C6D728DF0048660_821916821.addTaint(taint);
            return var8E84C70E278B61733C6D728DF0048660_821916821;
        } //End block
        else
    if(arg instanceof Float || arg instanceof Double)        
        {
            Number number = (Number) arg;
            double d = number.doubleValue();
    if(d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY)            
            {
CharSequence var52717C66C20915DE64278473EC1B040F_1917658416 =                 transformFromSpecialNumber(d);
                var52717C66C20915DE64278473EC1B040F_1917658416.addTaint(taint);
                return var52717C66C20915DE64278473EC1B040F_1917658416;
            } //End block
        } //End block
        else
    if(arg instanceof BigDecimal)        
        {
        } //End block
        else
        {
            java.util.IllegalFormatConversionException var9C39893A6EC12A3AA5B5E2ACF5548E23_1248537924 = badArgumentType();
            var9C39893A6EC12A3AA5B5E2ACF5548E23_1248537924.addTaint(taint);
            throw var9C39893A6EC12A3AA5B5E2ACF5548E23_1248537924;
        } //End block
        char conversionType = formatToken.getConversionType();
    if(conversionType != 'a' && conversionType != 'A' && !formatToken.isPrecisionSet())        
        {
            formatToken.setPrecision(FormatToken.DEFAULT_PRECISION);
        } //End block
        StringBuilder result = new StringBuilder();
switch(conversionType){
        case 'a':
        case 'A':
        transformA(result);
        break;
        case 'e':
        case 'E':
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
        java.util.UnknownFormatConversionException varC5A83382DFB85648592F35074607F3BE_1798160852 = formatToken.unknownFormatConversionException();
        varC5A83382DFB85648592F35074607F3BE_1798160852.addTaint(taint);
        throw varC5A83382DFB85648592F35074607F3BE_1798160852;
}        formatToken.setPrecision(FormatToken.UNSET);
        int startIndex = 0;
    if(result.charAt(0) == localeData.minusSign)        
        {
    if(formatToken.flagParenthesis)            
            {
CharSequence var41C2604B5A23F4EEB6A0946B3943BBD6_1392051814 =                 wrapParentheses(result);
                var41C2604B5A23F4EEB6A0946B3943BBD6_1392051814.addTaint(taint);
                return var41C2604B5A23F4EEB6A0946B3943BBD6_1392051814;
            } //End block
        } //End block
        else
        {
    if(formatToken.flagSpace)            
            {
                result.insert(0, ' ');
                startIndex++;
            } //End block
    if(formatToken.flagPlus)            
            {
                result.insert(0, '+');
                startIndex++;
            } //End block
        } //End block
        char firstChar = result.charAt(0);
    if(formatToken.flagZero && (firstChar == '+' || firstChar == localeData.minusSign))        
        {
            startIndex = 1;
        } //End block
    if(conversionType == 'a' || conversionType == 'A')        
        {
            startIndex += 2;
        } //End block
CharSequence varE4AAF0D88C94F7EDF0E0F68A12FC9293_753048770 =         padding(result, startIndex);
        varE4AAF0D88C94F7EDF0E0F68A12FC9293_753048770.addTaint(taint);
        return varE4AAF0D88C94F7EDF0E0F68A12FC9293_753048770;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.653 -0400", hash_original_method = "43DA2A76094CCA7D42287B4466035D61", hash_generated_method = "E36FB1996AB88BFD207776B0592654E8")
    private void transformE(StringBuilder result) {
        addTaint(result.getTaint());
        final int precision = formatToken.getPrecision();
        String pattern = "0E+00";
    if(precision > 0)        
        {
            StringBuilder sb = new StringBuilder("0.");
            char[] zeros = new char[precision];
            Arrays.fill(zeros, '0');
            sb.append(zeros);
            sb.append("E+00");
            pattern = sb.toString();
        } //End block
        NativeDecimalFormat nf = getDecimalFormat(pattern);
        char[] chars;
    if(arg instanceof BigDecimal)        
        {
            chars = nf.formatBigDecimal((BigDecimal) arg, null);
        } //End block
        else
        {
            chars = nf.formatDouble(((Number) arg).doubleValue(), null);
        } //End block
for(int i = 0;i < chars.length;++i)
        {
    if(chars[i] == 'E')            
            {
                chars[i] = 'e';
            } //End block
        } //End block
        result.append(chars);
    if(formatToken.flagSharp && precision == 0)        
        {
            int indexOfE = result.indexOf("e");
            result.insert(indexOfE, localeData.decimalSeparator);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.655 -0400", hash_original_method = "1973123C0DFAE44325340FD650EA833E", hash_generated_method = "2DD48D3579EAD5FA7F76C0A2D7C6C446")
    private void transformG(StringBuilder result) {
        addTaint(result.getTaint());
        int precision = formatToken.getPrecision();
    if(precision == 0)        
        {
            precision = 1;
        } //End block
        formatToken.setPrecision(precision);
        double d = ((Number) arg).doubleValue();
    if(d == 0.0)        
        {
            precision--;
            formatToken.setPrecision(precision);
            transformF(result);
            return;
        } //End block
        boolean requireScientificRepresentation = true;
        d = Math.abs(d);
    if(Double.isInfinite(d))        
        {
            precision = formatToken.getPrecision();
            precision--;
            formatToken.setPrecision(precision);
            transformE(result);
            return;
        } //End block
        BigDecimal b = new BigDecimal(d, new MathContext(precision));
        d = b.doubleValue();
        long l = b.longValue();
    if(d >= 1 && d < Math.pow(10, precision))        
        {
    if(l < Math.pow(10, precision))            
            {
                requireScientificRepresentation = false;
                precision -= String.valueOf(l).length();
                precision = precision < 0 ? 0 : precision;
                l = Math.round(d * Math.pow(10, precision + 1));
    if(String.valueOf(l).length() <= formatToken.getPrecision())                
                {
                    precision++;
                } //End block
                formatToken.setPrecision(precision);
            } //End block
        } //End block
        else
        {
            l = b.movePointRight(4).longValue();
    if(d >= Math.pow(10, -4) && d < 1)            
            {
                requireScientificRepresentation = false;
                precision += 4 - String.valueOf(l).length();
                l = b.movePointRight(precision + 1).longValue();
    if(String.valueOf(l).length() <= formatToken.getPrecision())                
                {
                    precision++;
                } //End block
                l = b.movePointRight(precision).longValue();
    if(l >= Math.pow(10, precision - 4))                
                {
                    formatToken.setPrecision(precision);
                } //End block
            } //End block
        } //End block
    if(requireScientificRepresentation)        
        {
            precision = formatToken.getPrecision();
            precision--;
            formatToken.setPrecision(precision);
            transformE(result);
        } //End block
        else
        {
            transformF(result);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.656 -0400", hash_original_method = "DF70A96812FA1EE536149F6B5D8F4C45", hash_generated_method = "73CA128BB4E92C92DE0A0FB72A654D51")
    private void transformF(StringBuilder result) {
        addTaint(result.getTaint());
        String pattern = "0.000000";
        final int precision = formatToken.getPrecision();
    if(formatToken.flagComma || precision != FormatToken.DEFAULT_PRECISION)        
        {
            StringBuilder patternBuilder = new StringBuilder();
    if(formatToken.flagComma)            
            {
                patternBuilder.append(',');
                int groupingSize = 3;
                char[] sharps = new char[groupingSize - 1];
                Arrays.fill(sharps, '#');
                patternBuilder.append(sharps);
            } //End block
            patternBuilder.append('0');
    if(precision > 0)            
            {
                patternBuilder.append('.');
for(int i = 0;i < precision;++i)
                {
                    patternBuilder.append('0');
                } //End block
            } //End block
            pattern = patternBuilder.toString();
        } //End block
        NativeDecimalFormat nf = getDecimalFormat(pattern);
    if(arg instanceof BigDecimal)        
        {
            result.append(nf.formatBigDecimal((BigDecimal) arg, null));
        } //End block
        else
        {
            result.append(nf.formatDouble(((Number) arg).doubleValue(), null));
        } //End block
    if(formatToken.flagSharp && precision == 0)        
        {
            result.append(localeData.decimalSeparator);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.668 -0400", hash_original_method = "DCC3844221755C0C14FA659BF8647E6B", hash_generated_method = "D2B8CEDEB27DA02EEA0DB0A9A8C39D05")
    private void transformA(StringBuilder result) {
        addTaint(result.getTaint());
    if(arg instanceof Float)        
        {
            result.append(Float.toHexString(((Float) arg).floatValue()));
        } //End block
        else
    if(arg instanceof Double)        
        {
            result.append(Double.toHexString(((Double) arg).doubleValue()));
        } //End block
        else
        {
            java.util.IllegalFormatConversionException var9C39893A6EC12A3AA5B5E2ACF5548E23_590106000 = badArgumentType();
            var9C39893A6EC12A3AA5B5E2ACF5548E23_590106000.addTaint(taint);
            throw var9C39893A6EC12A3AA5B5E2ACF5548E23_590106000;
        } //End block
    if(!formatToken.isPrecisionSet())        
        {
            return;
        } //End block
        int precision = formatToken.getPrecision();
    if(precision == 0)        
        {
            precision = 1;
        } //End block
        int indexOfFirstFractionalDigit = result.indexOf(".") + 1;
        int indexOfP = result.indexOf("p");
        int fractionalLength = indexOfP - indexOfFirstFractionalDigit;
    if(fractionalLength == precision)        
        {
            return;
        } //End block
    if(fractionalLength < precision)        
        {
            char[] zeros = new char[precision - fractionalLength];
            Arrays.fill(zeros, '0');
            result.insert(indexOfP, zeros);
            return;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.669 -0400", hash_original_field = "DBECB303151001B254CD458C962BFA06", hash_generated_field = "57B03D121D93C35DC4CD446F8684FFFD")

        public NativeDecimalFormat decimalFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.669 -0400", hash_original_field = "0DC9450ED9A8CE4C2B3A1D132A9E7261", hash_generated_field = "F1A921FEF7693E6D4DF1F57B4D8F992B")

        public LocaleData currentLocaleData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.669 -0400", hash_original_field = "0B0F76B47F491349A26FCE54BEF066C1", hash_generated_field = "79B878750A67D50688DF69A25D47682C")

        public String currentPattern;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.670 -0400", hash_original_method = "3AB4302EBBD3C6ECF16B79A91E887CC6", hash_generated_method = "C4149067CD2AF28823E946F111841C62")
        public  CachedDecimalFormat() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.671 -0400", hash_original_method = "784B3214258603820EA00D340F6FA563", hash_generated_method = "340CB4ABEF96C6C838EED0817176CCE0")
        public NativeDecimalFormat update(LocaleData localeData, String pattern) {
    if(decimalFormat == null)            
            {
                currentPattern = pattern;
                currentLocaleData = localeData;
                decimalFormat = new NativeDecimalFormat(currentPattern, currentLocaleData);
            } //End block
    if(!pattern.equals(currentPattern))            
            {
                decimalFormat.applyPattern(pattern);
                currentPattern = pattern;
            } //End block
    if(localeData != currentLocaleData)            
            {
                decimalFormat.setDecimalFormatSymbols(localeData);
                currentLocaleData = localeData;
            } //End block
NativeDecimalFormat var786B68CE85DDA5DF40C19A5AF9A0EE7F_2146651837 =             decimalFormat;
            var786B68CE85DDA5DF40C19A5AF9A0EE7F_2146651837.addTaint(taint);
            return var786B68CE85DDA5DF40C19A5AF9A0EE7F_2146651837;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "CABEE536F594A7425CADCE9FE8AB1016", hash_generated_field = "772417271F7F0BDFEA0E64414172A084")

        private int argIndex = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "AF7A833327A8AE088613AF6547808B22", hash_generated_field = "98479ABC53D035AE015748B6501BED19")

        boolean flagComma;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "77D00CCF13983863513393B04DE90A5E", hash_generated_field = "84E0FE8767B1823F9BD483DE94C8D5B6")

        boolean flagMinus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "58EB12214972261349BEFF4AFEEBADE7", hash_generated_field = "6268F94D7EC6432771FAC9A81C06B277")

        boolean flagParenthesis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "2FC88FB85E37FA3049E7C4FB6131D130", hash_generated_field = "B18F735AA5B0F0DABBD7E427068CC4C3")

        boolean flagPlus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "CA9A273EC976964302B347E1A888F814", hash_generated_field = "C720CA7CDB619DB58116FBA407D9470B")

        boolean flagSharp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "0A9A68E8CA9C930B3BD25AC0267A50F6", hash_generated_field = "A2EE573CAED7292D13BAD741251059A4")

        boolean flagSpace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "23AC23B8E4A938ABDC183973ABADFBB2", hash_generated_field = "79C0F430E2F3E53D9DF49552E4733685")

        boolean flagZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "06BB72258511A33C8D897372F71D9BEB", hash_generated_field = "E9F667FE63992DF0A85E5D7A0685E01F")

        private char conversionType = (char) UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "CBA7C70F75D3196A71CEB9803FA45256", hash_generated_field = "6AC9B9E35F29643906A8717247B50CCB")

        private char dateSuffix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.672 -0400", hash_original_field = "448C0902A81C3D78DB12BA0C73991461", hash_generated_field = "1A5EEC185E39D6E54480D34E352CE283")

        private int precision = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.673 -0400", hash_original_field = "E3737662F9BF753CD6F77C63AE3B771F", hash_generated_field = "7F084C83D0F1982A47DE9354FC0CF9F1")

        private int width = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.673 -0400", hash_original_field = "8A84BD7A36073EE32C37C1B79462B501", hash_generated_field = "0527ECB4D15D76D63A180FF8CBB184B2")

        private StringBuilder strFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.673 -0400", hash_original_method = "98998A93ECCA1CEE378BE6F5FF82B45F", hash_generated_method = "98998A93ECCA1CEE378BE6F5FF82B45F")
        public FormatToken ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.673 -0400", hash_original_method = "A7B957B3122A1E0264F586D374F2E6B7", hash_generated_method = "A9E6F83D6DC88124E4D5C338B96B616E")
         boolean isDefault() {
            boolean var28140EBBDF82DDCB5EB8A5FBDA09514D_554973684 = (!flagComma && !flagMinus && !flagParenthesis && !flagPlus && !flagSharp &&
                    !flagSpace && !flagZero && width == UNSET && precision == UNSET);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162444392 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_162444392;
            // ---------- Original Method ----------
            //return !flagComma && !flagMinus && !flagParenthesis && !flagPlus && !flagSharp &&
                    //!flagSpace && !flagZero && width == UNSET && precision == UNSET;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.673 -0400", hash_original_method = "A13969ECEC9F8D1C94EA6A52CDFB6E17", hash_generated_method = "D553D48E973CF00404656A45F67B76E3")
         boolean isPrecisionSet() {
            boolean var9ED884D0B304588BA5ECD752C41FDFCC_252868673 = (precision != UNSET);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928291795 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928291795;
            // ---------- Original Method ----------
            //return precision != UNSET;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.674 -0400", hash_original_method = "3A74106121887CCA509F985D60DB5637", hash_generated_method = "36CFC7E3C63A5CFF962F10E7879AA76F")
         int getArgIndex() {
            int varE98B70DDC6CAD42E024EF89296FC99E9_2008208100 = (argIndex);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891288913 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891288913;
            // ---------- Original Method ----------
            //return argIndex;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.674 -0400", hash_original_method = "27CE41687BF54420F4C00D2CFB6A73FA", hash_generated_method = "F3E94D0F268DD41F463EE67139BE9385")
         void setArgIndex(int index) {
            argIndex = index;
            // ---------- Original Method ----------
            //argIndex = index;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.674 -0400", hash_original_method = "40140C97EC91863535630C305615FEC1", hash_generated_method = "6A0E6319CE1FB6AE43C79DD850572C2C")
         int getWidth() {
            int varEAAE26A6FB20ED3EF54FB23BFA0B1FCC_1760221666 = (width);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577393606 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577393606;
            // ---------- Original Method ----------
            //return width;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.675 -0400", hash_original_method = "5C954D9C93DF99E2E990960A3CC1749D", hash_generated_method = "D40BD430ACB0EA3E0D63770A2976B08D")
         void setWidth(int width) {
            this.width = width;
            // ---------- Original Method ----------
            //this.width = width;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.675 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "C532FFE1B32342AC481C0304DB297273")
         int getPrecision() {
            int varE2794D8F12719281EFF5601251C8A680_1631837850 = (precision);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223168494 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223168494;
            // ---------- Original Method ----------
            //return precision;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.676 -0400", hash_original_method = "7515FB19ACE3C47DEBBD3E8357F6915C", hash_generated_method = "5866B10F1157266750859E3B0502D979")
         void setPrecision(int precise) {
            this.precision = precise;
            // ---------- Original Method ----------
            //this.precision = precise;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.676 -0400", hash_original_method = "837A02C50E03265F058B23775F6F6197", hash_generated_method = "49E9AED0E36C50C9408B468AA470F8AF")
         String getStrFlags() {
String varE356DE50F486C3F72B629C8B7984509F_2053697223 =             (strFlags != null) ? strFlags.toString() : "";
            varE356DE50F486C3F72B629C8B7984509F_2053697223.addTaint(taint);
            return varE356DE50F486C3F72B629C8B7984509F_2053697223;
            // ---------- Original Method ----------
            //return (strFlags != null) ? strFlags.toString() : "";
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.678 -0400", hash_original_method = "E6ACD7E32E6ABC5AE16C357DB8116DB3", hash_generated_method = "3B967B323E5138305958D1C8E1BDC81C")
         boolean setFlag(int ch) {
            addTaint(ch);
            boolean dupe = false;
switch(ch){
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
            boolean var68934A3E9455FA72420237EB05902327_1888694932 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439729322 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439729322;
}    if(dupe)            
            {
                DuplicateFormatFlagsException varE46C01B7694668ED351C304AE21978F4_609072185 = new DuplicateFormatFlagsException(String.valueOf(ch));
                varE46C01B7694668ED351C304AE21978F4_609072185.addTaint(taint);
                throw varE46C01B7694668ED351C304AE21978F4_609072185;
            } //End block
    if(strFlags == null)            
            {
                strFlags = new StringBuilder(7);
            } //End block
            strFlags.append((char) ch);
            boolean varB326B5062B2F0E69046810717534CB09_1167598674 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626852014 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_626852014;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.678 -0400", hash_original_method = "563B5213711441DEFA9BB3355CD61032", hash_generated_method = "CBC72744BA507A163F9A14CE744032F9")
         char getConversionType() {
            char varD37DF0D77BC2D7B3B7A88AC969424DC3_1703322150 = (conversionType);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1764742600 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1764742600;
            // ---------- Original Method ----------
            //return conversionType;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.679 -0400", hash_original_method = "6C3279116A999B7A879305F448E4C7E6", hash_generated_method = "37AF4C580148FD1E99691D99021A9434")
         void setConversionType(char c) {
            conversionType = c;
            // ---------- Original Method ----------
            //conversionType = c;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.679 -0400", hash_original_method = "EE45DA1AFAF958B13872135C146745E9", hash_generated_method = "60B18252F1639DB9F664C16C367B3A65")
         char getDateSuffix() {
            char varCBA7C70F75D3196A71CEB9803FA45256_2120497302 = (dateSuffix);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_2109341674 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_2109341674;
            // ---------- Original Method ----------
            //return dateSuffix;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.679 -0400", hash_original_method = "6F4F20E9A23952874C5B1A6A80E321B4", hash_generated_method = "B3184FE9D51C912BE0F6FB157BD6AF85")
         void setDateSuffix(char c) {
            dateSuffix = c;
            // ---------- Original Method ----------
            //dateSuffix = c;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.680 -0400", hash_original_method = "67F4DE623207C5AE23B919ACAD45AA0B", hash_generated_method = "EB6D79CA7F88DAD8189CAF6634B9A421")
         boolean requireArgument() {
            boolean var91C0CD36DD417856F3F54E899E46D03B_2030757165 = (conversionType != '%' && conversionType != 'n');
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87215760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_87215760;
            // ---------- Original Method ----------
            //return conversionType != '%' && conversionType != 'n';
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.705 -0400", hash_original_method = "34D9D8688BA6BF211700F1E1A866C731", hash_generated_method = "952F29F8E70F669EFD5D0538F7AF2A3E")
         void checkFlags(Object arg) {
            addTaint(arg.getTaint());
            boolean allowComma = false;
            boolean allowMinus = true;
            boolean allowParenthesis = false;
            boolean allowPlus = false;
            boolean allowSharp = false;
            boolean allowSpace = false;
            boolean allowZero = false;
            boolean allowPrecision = true;
            boolean allowWidth = true;
            boolean allowArgument = true;
switch(conversionType){
            case 'c':
            case 'C':
            case 't':
            case 'T':
            allowPrecision = false;
            break;
            case 's':
            case 'S':
    if(arg instanceof Formattable)            
            {
                allowSharp = true;
            } //End block
            break;
            case 'g':
            case 'G':
            allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
            break;
            case 'f':
            allowComma = allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
            break;
            case 'e':
            case 'E':
            allowParenthesis = allowPlus = allowSharp = allowSpace = allowZero = true;
            break;
            case 'a':
            case 'A':
            allowPlus = allowSharp = allowSpace = allowZero = true;
            break;
            case 'd':
            allowComma = allowParenthesis = allowPlus = allowSpace = allowZero = true;
            allowPrecision = false;
            break;
            case 'o':
            case 'x':
            case 'X':
            allowSharp = allowZero = true;
    if(arg == null || arg instanceof BigInteger)            
            {
                allowParenthesis = allowPlus = allowSpace = true;
            } //End block
            allowPrecision = false;
            break;
            case 'n':
            allowMinus = false;
            allowArgument = allowPrecision = allowWidth = false;
            break;
            case '%':
            allowArgument = false;
            allowPrecision = false;
            break;
            case 'b':
            case 'B':
            case 'h':
            case 'H':
            break;
            default:
            java.util.UnknownFormatConversionException varE94728C2EE01EF2E47B081E37CD15751_825596612 = unknownFormatConversionException();
            varE94728C2EE01EF2E47B081E37CD15751_825596612.addTaint(taint);
            throw varE94728C2EE01EF2E47B081E37CD15751_825596612;
}            String mismatch = null;
    if(!allowComma && flagComma)            
            {
                mismatch = ",";
            } //End block
            else
    if(!allowMinus && flagMinus)            
            {
                mismatch = "-";
            } //End block
            else
    if(!allowParenthesis && flagParenthesis)            
            {
                mismatch = "(";
            } //End block
            else
    if(!allowPlus && flagPlus)            
            {
                mismatch = "+";
            } //End block
            else
    if(!allowSharp && flagSharp)            
            {
                mismatch = "#";
            } //End block
            else
    if(!allowSpace && flagSpace)            
            {
                mismatch = " ";
            } //End block
            else
    if(!allowZero && flagZero)            
            {
                mismatch = "0";
            } //End block
    if(mismatch != null)            
            {
    if(conversionType == 'n')                
                {
                    IllegalFormatFlagsException var576EDC1C972BB7992BC3C0C383912673_700720715 = new IllegalFormatFlagsException(mismatch);
                    var576EDC1C972BB7992BC3C0C383912673_700720715.addTaint(taint);
                    throw var576EDC1C972BB7992BC3C0C383912673_700720715;
                } //End block
                else
                {
                    FormatFlagsConversionMismatchException var90156AA985647322C200AA96939849DF_642785527 = new FormatFlagsConversionMismatchException(mismatch, conversionType);
                    var90156AA985647322C200AA96939849DF_642785527.addTaint(taint);
                    throw var90156AA985647322C200AA96939849DF_642785527;
                } //End block
            } //End block
    if((flagMinus || flagZero) && width == UNSET)            
            {
                MissingFormatWidthException var99982044224B9C7FF3707A99C2B2CBB2_1052482854 = new MissingFormatWidthException("-" + conversionType);
                var99982044224B9C7FF3707A99C2B2CBB2_1052482854.addTaint(taint);
                throw var99982044224B9C7FF3707A99C2B2CBB2_1052482854;
            } //End block
    if(!allowArgument && argIndex != UNSET)            
            {
                IllegalFormatFlagsException varFD86C6D83F16D2ACEFB036A9D62F98C5_593708802 = new IllegalFormatFlagsException("%" + conversionType +
                        " doesn't take an argument");
                varFD86C6D83F16D2ACEFB036A9D62F98C5_593708802.addTaint(taint);
                throw varFD86C6D83F16D2ACEFB036A9D62F98C5_593708802;
            } //End block
    if(!allowPrecision && precision != UNSET)            
            {
                IllegalFormatPrecisionException var17D8944173B5971EB077A95711D805DE_711360358 = new IllegalFormatPrecisionException(precision);
                var17D8944173B5971EB077A95711D805DE_711360358.addTaint(taint);
                throw var17D8944173B5971EB077A95711D805DE_711360358;
            } //End block
    if(!allowWidth && width != UNSET)            
            {
                IllegalFormatWidthException varC82EEE007F85E63FDF24EDA522E15192_941192658 = new IllegalFormatWidthException(width);
                varC82EEE007F85E63FDF24EDA522E15192_941192658.addTaint(taint);
                throw varC82EEE007F85E63FDF24EDA522E15192_941192658;
            } //End block
    if(flagPlus && flagSpace)            
            {
                IllegalFormatFlagsException var22F7D12B3FBFAABA52EE025C0B568BBC_1891935578 = new IllegalFormatFlagsException("the '+' and ' ' flags are incompatible");
                var22F7D12B3FBFAABA52EE025C0B568BBC_1891935578.addTaint(taint);
                throw var22F7D12B3FBFAABA52EE025C0B568BBC_1891935578;
            } //End block
    if(flagMinus && flagZero)            
            {
                IllegalFormatFlagsException varD7B01F44CA0572C51E46BEE1B89DB7B9_738748176 = new IllegalFormatFlagsException("the '-' and '0' flags are incompatible");
                varD7B01F44CA0572C51E46BEE1B89DB7B9_738748176.addTaint(taint);
                throw varD7B01F44CA0572C51E46BEE1B89DB7B9_738748176;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.707 -0400", hash_original_method = "ECFEC3AA46FEEC6BDD34290E5303C5C1", hash_generated_method = "B33708AD9C9A9F0DDF3393797DCEB8EA")
        public UnknownFormatConversionException unknownFormatConversionException() {
    if(conversionType == 't' || conversionType == 'T')            
            {
                UnknownFormatConversionException var4F6D8D61C9250026C8EDFE62D831DDDE_1448571227 = new UnknownFormatConversionException(String.format("%c%c",
                        conversionType, dateSuffix));
                var4F6D8D61C9250026C8EDFE62D831DDDE_1448571227.addTaint(taint);
                throw var4F6D8D61C9250026C8EDFE62D831DDDE_1448571227;
            } //End block
            UnknownFormatConversionException var5E44CB2C1D7A7977697352FB7FD82C5D_948816253 = new UnknownFormatConversionException(String.valueOf(conversionType));
            var5E44CB2C1D7A7977697352FB7FD82C5D_948816253.addTaint(taint);
            throw var5E44CB2C1D7A7977697352FB7FD82C5D_948816253;
            // ---------- Original Method ----------
            //if (conversionType == 't' || conversionType == 'T') {
                //throw new UnknownFormatConversionException(String.format("%c%c",
                        //conversionType, dateSuffix));
            //}
            //throw new UnknownFormatConversionException(String.valueOf(conversionType));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.707 -0400", hash_original_field = "0D32D75D80197F9844932D7929DB5015", hash_generated_field = "1BAD064282D47A986023D9014C2CC686")

        static final int LAST_ARGUMENT_INDEX = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.707 -0400", hash_original_field = "682DBD04772A37CB99D92EB22481F8C6", hash_generated_field = "DE29D11B6980854EC22F3C15E7DA3A93")

        static final int UNSET = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.707 -0400", hash_original_field = "8FE6A229232BC2E57ECCA9364408A298", hash_generated_field = "6514D206AC3CB1872EE1D615A4517002")

        static final int FLAGS_UNSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.708 -0400", hash_original_field = "AEFDD97FD64534132DA681FF73D9FC6D", hash_generated_field = "5A822570BEDDD49CF98C09711A50F2C5")

        static final int DEFAULT_PRECISION = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.708 -0400", hash_original_field = "60A2F91F5F69F60923439B86F77F3E9E", hash_generated_field = "9C5453ECCDBB9489F68E15932C42DB5C")

        static final int FLAG_ZERO = 1 << 4;
    }


    
    private static class FormatSpecifierParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.708 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "3AFBEC2146BDEA5BFCBD2772D27C43DD")

        private String format;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.708 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private int length;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.708 -0400", hash_original_field = "04D77DDD9C9389CC56939726D3DA8089", hash_generated_field = "4DF8ED554EC7B2C7483518163DCC894C")

        private int startIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.709 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "DDFC4038967415E2F22993ABFD9A3B3F")

        private int i;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.709 -0400", hash_original_method = "2EAAE714EE0AE41BF39DBCA3F91B9104", hash_generated_method = "99616AB8C1E30FEFAAC91AD743EEE46F")
          FormatSpecifierParser(String format) {
            this.format = format;
            this.length = format.length();
            // ---------- Original Method ----------
            //this.format = format;
            //this.length = format.length();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.710 -0400", hash_original_method = "F77740880648C3886F14C74FD023BD3A", hash_generated_method = "5E164A703B221C58FF94750D6D2AA90C")
         FormatToken parseFormatToken(int offset) {
            this.startIndex = offset;
            this.i = offset;
FormatToken varFD067A616111CF6DE4BAF9A334082E81_1804394574 =             parseArgumentIndexAndFlags(new FormatToken());
            varFD067A616111CF6DE4BAF9A334082E81_1804394574.addTaint(taint);
            return varFD067A616111CF6DE4BAF9A334082E81_1804394574;
            // ---------- Original Method ----------
            //this.startIndex = offset;
            //this.i = offset;
            //return parseArgumentIndexAndFlags(new FormatToken());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.710 -0400", hash_original_method = "7C388C74117CDF3E7844B526DC734D8C", hash_generated_method = "13F5C4765414A00BC5AA93374330AFB9")
         String getFormatSpecifierText() {
String varAEB69BD2749C34A7344D72401C529AA5_1259294541 =             format.substring(startIndex, i);
            varAEB69BD2749C34A7344D72401C529AA5_1259294541.addTaint(taint);
            return varAEB69BD2749C34A7344D72401C529AA5_1259294541;
            // ---------- Original Method ----------
            //return format.substring(startIndex, i);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.710 -0400", hash_original_method = "6521B9C02DA744FF180556D39A74ED44", hash_generated_method = "ACA9899119C930BC794B6C34711A4B8D")
        private int peek() {
            int var1FC742731B74CA4A1561C852ACE9793B_1326250663 = ((i < length) ? format.charAt(i) : -1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984820569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984820569;
            // ---------- Original Method ----------
            //return (i < length) ? format.charAt(i) : -1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.713 -0400", hash_original_method = "F520742ED92EBACDB47FBF0D0B1F08F4", hash_generated_method = "6D091790AF1F2F960D4056D0EB554E6C")
        private char advance() {
    if(i >= length)            
            {
                java.util.UnknownFormatConversionException varE94728C2EE01EF2E47B081E37CD15751_204146377 = unknownFormatConversionException();
                varE94728C2EE01EF2E47B081E37CD15751_204146377.addTaint(taint);
                throw varE94728C2EE01EF2E47B081E37CD15751_204146377;
            } //End block
            char varEBF93018222DDA3A5E85B8A54787F536_1662342579 = (format.charAt(i++));
                        char varA87DEB01C5F539E6BDA34829C8EF2368_67783112 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_67783112;
            // ---------- Original Method ----------
            //if (i >= length) {
                //throw unknownFormatConversionException();
            //}
            //return format.charAt(i++);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.714 -0400", hash_original_method = "DFAEBB829CC6A7AFE465DA1B9A0C1D5A", hash_generated_method = "ACA87FDD10C15EA2620ADE347C19BA40")
        private UnknownFormatConversionException unknownFormatConversionException() {
            UnknownFormatConversionException varE6C5B89159EB5EDE089CB95AF18D63D4_817919297 = new UnknownFormatConversionException(getFormatSpecifierText());
            varE6C5B89159EB5EDE089CB95AF18D63D4_817919297.addTaint(taint);
            throw varE6C5B89159EB5EDE089CB95AF18D63D4_817919297;
            // ---------- Original Method ----------
            //throw new UnknownFormatConversionException(getFormatSpecifierText());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.714 -0400", hash_original_method = "AD27190704DEC79DF3778A7C88589CDF", hash_generated_method = "C9B3EDB33271251A149A9EE5797C777F")
        private FormatToken parseArgumentIndexAndFlags(FormatToken token) {
            addTaint(token.getTaint());
            int position = i;
            int ch = peek();
    if(Character.isDigit(ch))            
            {
                int number = nextInt();
    if(peek() == '$')                
                {
                    advance();
    if(number == FormatToken.UNSET)                    
                    {
                        MissingFormatArgumentException var8046F958303BE18FCA38F24961B498E9_246746523 = new MissingFormatArgumentException(getFormatSpecifierText());
                        var8046F958303BE18FCA38F24961B498E9_246746523.addTaint(taint);
                        throw var8046F958303BE18FCA38F24961B498E9_246746523;
                    } //End block
                    token.setArgIndex(Math.max(0, number - 1));
                } //End block
                else
                {
    if(ch == '0')                    
                    {
                        i = position;
                    } //End block
                    else
                    {
FormatToken var684C47571DB3E03F99CBB844BCA9E4A8_1252474129 =                         parseWidth(token, number);
                        var684C47571DB3E03F99CBB844BCA9E4A8_1252474129.addTaint(taint);
                        return var684C47571DB3E03F99CBB844BCA9E4A8_1252474129;
                    } //End block
                } //End block
            } //End block
            else
    if(ch == '<')            
            {
                token.setArgIndex(FormatToken.LAST_ARGUMENT_INDEX);
                advance();
            } //End block
            while
(token.setFlag(peek()))            
            {
                advance();
            } //End block
            ch = peek();
    if(Character.isDigit(ch))            
            {
FormatToken var0CD1657A27650EE13647F755A52406CB_1791484054 =                 parseWidth(token, nextInt());
                var0CD1657A27650EE13647F755A52406CB_1791484054.addTaint(taint);
                return var0CD1657A27650EE13647F755A52406CB_1791484054;
            } //End block
            else
    if(ch == '.')            
            {
FormatToken var5C7D950B3E357B68630D3D58E872BE79_1848733694 =                 parsePrecision(token);
                var5C7D950B3E357B68630D3D58E872BE79_1848733694.addTaint(taint);
                return var5C7D950B3E357B68630D3D58E872BE79_1848733694;
            } //End block
            else
            {
FormatToken var57DCFD229290E8B525C83F6EBF3A9765_1365469568 =                 parseConversionType(token);
                var57DCFD229290E8B525C83F6EBF3A9765_1365469568.addTaint(taint);
                return var57DCFD229290E8B525C83F6EBF3A9765_1365469568;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.716 -0400", hash_original_method = "F4C6E47C7F58A93445972E2EDFDFCD5C", hash_generated_method = "10B0255B0E425EF68012AE303A0AF43B")
        private FormatToken parseWidth(FormatToken token, int width) {
            addTaint(width);
            addTaint(token.getTaint());
            token.setWidth(width);
            int ch = peek();
    if(ch == '.')            
            {
FormatToken var5C7D950B3E357B68630D3D58E872BE79_1043859202 =                 parsePrecision(token);
                var5C7D950B3E357B68630D3D58E872BE79_1043859202.addTaint(taint);
                return var5C7D950B3E357B68630D3D58E872BE79_1043859202;
            } //End block
            else
            {
FormatToken var57DCFD229290E8B525C83F6EBF3A9765_529958764 =                 parseConversionType(token);
                var57DCFD229290E8B525C83F6EBF3A9765_529958764.addTaint(taint);
                return var57DCFD229290E8B525C83F6EBF3A9765_529958764;
            } //End block
            // ---------- Original Method ----------
            //token.setWidth(width);
            //int ch = peek();
            //if (ch == '.') {
                //return parsePrecision(token);
            //} else {
                //return parseConversionType(token);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.719 -0400", hash_original_method = "06DE93E908B11B43F41251F270A468F2", hash_generated_method = "16F95A8C26AEA557A331C37962D3540F")
        private FormatToken parsePrecision(FormatToken token) {
            addTaint(token.getTaint());
            advance();
            int ch = peek();
    if(Character.isDigit(ch))            
            {
                token.setPrecision(nextInt());
FormatToken var57DCFD229290E8B525C83F6EBF3A9765_2097664726 =                 parseConversionType(token);
                var57DCFD229290E8B525C83F6EBF3A9765_2097664726.addTaint(taint);
                return var57DCFD229290E8B525C83F6EBF3A9765_2097664726;
            } //End block
            else
            {
                java.util.UnknownFormatConversionException varE94728C2EE01EF2E47B081E37CD15751_107559443 = unknownFormatConversionException();
                varE94728C2EE01EF2E47B081E37CD15751_107559443.addTaint(taint);
                throw varE94728C2EE01EF2E47B081E37CD15751_107559443;
            } //End block
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.720 -0400", hash_original_method = "779E7C7A9E24C2B8C7A984530163E241", hash_generated_method = "271C787B5E247EF12EA3ACCB51740DEC")
        private FormatToken parseConversionType(FormatToken token) {
            addTaint(token.getTaint());
            char conversionType = advance();
            token.setConversionType(conversionType);
    if(conversionType == 't' || conversionType == 'T')            
            {
                char dateSuffix = advance();
                token.setDateSuffix(dateSuffix);
            } //End block
FormatToken var84AE1F94A3CF2A5D8DE4571F3693A75E_1502827763 =             token;
            var84AE1F94A3CF2A5D8DE4571F3693A75E_1502827763.addTaint(taint);
            return var84AE1F94A3CF2A5D8DE4571F3693A75E_1502827763;
            // ---------- Original Method ----------
            //char conversionType = advance();
            //token.setConversionType(conversionType);
            //if (conversionType == 't' || conversionType == 'T') {
                //char dateSuffix = advance(); 
                //token.setDateSuffix(dateSuffix);
            //}
            //return token;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.720 -0400", hash_original_method = "ADF8322FF676CF5038257F50E4E4E6DC", hash_generated_method = "263DC58DF7EF6BA44E66CA5D1E966AA7")
        private int nextInt() {
            long value = 0;
            while
(i < length && Character.isDigit(format.charAt(i)))            
            {
                value = 10 * value + (format.charAt(i++) - '0');
    if(value > Integer.MAX_VALUE)                
                {
                    int var64C18E1B2678587ABC1A12C2E03B36EF_410616887 = (failNextInt());
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080419398 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080419398;
                } //End block
            } //End block
            int varA873F4A71211BFDACBAEFBA0F9FCF91B_1261465266 = ((int) value);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_614383422 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_614383422;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.721 -0400", hash_original_method = "F2814F47D4EB7F1D4CA24D9FE1C3918D", hash_generated_method = "633A9C08E195AE0FBBF507D938AB3A44")
        private int failNextInt() {
            while
(Character.isDigit(peek()))            
            {
                advance();
            } //End block
            int var717E546AC0C48222D75A724765D2F5D5_824422240 = (FormatToken.UNSET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548610705 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548610705;
            // ---------- Original Method ----------
            //while (Character.isDigit(peek())) {
                //advance();
            //}
            //return FormatToken.UNSET;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.721 -0400", hash_original_field = "A2B3A99FDB3C7974C9307D50BA09396A", hash_generated_field = "936B09C441C4FA32E24FFDE50779B4D5")

    private static final char[] ZEROS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.533 -0400", hash_original_field = "2E22D2BB824CAE76137397D7BB1A476C", hash_generated_field = "A22626209D6F7C1DAB7E829778351877")

    private static final ThreadLocal<CachedDecimalFormat> cachedDecimalFormat = new ThreadLocal<CachedDecimalFormat>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:08.533 -0400", hash_original_method = "3BF85501572F336E7CB9026A6524A649", hash_generated_method = "1EC7F54F0E895EC060EFCA96009F4258")
        @Override
        protected CachedDecimalFormat initialValue() {
            CachedDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_1389458477 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1389458477 = new CachedDecimalFormat();
            varB4EAC82CA7396A68D541C85D26508E83_1389458477.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1389458477;
            
            
        }

        
};
}

