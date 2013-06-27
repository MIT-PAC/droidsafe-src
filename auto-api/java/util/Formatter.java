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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.222 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "3DC9338DC786F95D1A95A8961D85A2A6")

    private Appendable out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.222 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.233 -0400", hash_original_field = "61DD86C2DC75C3F569EC619BD283A33F", hash_generated_field = "613B0CE96D5332BFAF1329D4F111938C")

    private Object arg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.233 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.233 -0400", hash_original_field = "B7B849C43DF0AE6D73905E0D7DFFBD21", hash_generated_field = "FB61E2282DE2F9A3C415CEE063007787")

    private FormatToken formatToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.233 -0400", hash_original_field = "460DFB1105EAD6E581494BC8EB7172AC", hash_generated_field = "94160D1F6EC5CF5867F2CCE7946E9FCB")

    private IOException lastIOException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.233 -0400", hash_original_field = "E3E7EE28E6489646D907CCB03E05DAAD", hash_generated_field = "C9E2992A298A3ADEBF6945150F771649")

    private LocaleData localeData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.234 -0400", hash_original_method = "776A8092D7EB6A8CE9FA3707C90FDC71", hash_generated_method = "84D520F5378D0961C20054F1B6C8CEC3")
    public  Formatter() {
        this(new StringBuilder(), Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.234 -0400", hash_original_method = "C10A7E7C6014F1D5457B2868B8DDD5FA", hash_generated_method = "31E6013FD29F4E00375F2E0819EFEC43")
    public  Formatter(Appendable a) {
        this(a, Locale.getDefault());
        addTaint(a.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.234 -0400", hash_original_method = "949ED46E62E9C1FD97345CAB1F572157", hash_generated_method = "1F77DEC42C276C4F532BB809AEBFC555")
    public  Formatter(Locale l) {
        this(new StringBuilder(), l);
        addTaint(l.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.239 -0400", hash_original_method = "731A0E308D6775F1250BD9086CA3748C", hash_generated_method = "76EB4A86010C765538F0CD5F267904FB")
    public  Formatter(Appendable a, Locale l) {
        {
            out = new StringBuilder();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.239 -0400", hash_original_method = "55110CB3A063CDDA9DDF2A6FEEDBC4D6", hash_generated_method = "70BDD2B3DD755EDDD96C2C4A66B6ADFD")
    public  Formatter(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.240 -0400", hash_original_method = "D05AE6CA9B3694824C73C0B398D66198", hash_generated_method = "5E175B6E8111D40A645C215D023FFEEA")
    public  Formatter(String fileName, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new File(fileName), csn);
        addTaint(fileName.getTaint());
        addTaint(csn.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.240 -0400", hash_original_method = "106406A68116E4DC11358A25DB96C9D8", hash_generated_method = "5E89EAE84986EA97D043AD55A3E15F94")
    public  Formatter(String fileName, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn, l);
        addTaint(fileName.getTaint());
        addTaint(csn.getTaint());
        addTaint(l.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.240 -0400", hash_original_method = "56C5088BBC7ACEBB0E3B42C5FC534A61", hash_generated_method = "589E7B2AC2ADE54B3D54DCD41B50441F")
    public  Formatter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.240 -0400", hash_original_method = "15C3BB1BBEBB7DA2B256558B7A83F1D2", hash_generated_method = "F5E9451ABCBDE9893AA26A6A1D7AA59B")
    public  Formatter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(file, csn, Locale.getDefault());
        addTaint(file.getTaint());
        addTaint(csn.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.241 -0400", hash_original_method = "11FC304A866A57AD6707E0AE5ACD74C6", hash_generated_method = "66CFD219CFA238E5D23F00C12D075619")
    public  Formatter(File file, String csn, Locale l) throws FileNotFoundException, UnsupportedEncodingException {
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
        locale = l;
        addTaint(file.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.242 -0400", hash_original_method = "18094D8509766CE6FC608D9540C5972B", hash_generated_method = "86DB88A0468A92B37477CC3A3583D801")
    public  Formatter(OutputStream os) {
        out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        locale = Locale.getDefault();
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, Charset.defaultCharset()));
        //locale = Locale.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.242 -0400", hash_original_method = "F6295FD9F7AB3AB7F721531D402E7F81", hash_generated_method = "84790D15860A1225F92619D8FE2D1847")
    public  Formatter(OutputStream os, String csn) throws UnsupportedEncodingException {
        this(os, csn, Locale.getDefault());
        addTaint(os.getTaint());
        addTaint(csn.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.246 -0400", hash_original_method = "339D31BAB557832A3B8A75EB377C0635", hash_generated_method = "8BEF5CEA51D6B567DEC1210198AC5CE9")
    public  Formatter(OutputStream os, String csn, Locale l) throws UnsupportedEncodingException {
        out = new BufferedWriter(new OutputStreamWriter(os, csn));
        locale = l;
        // ---------- Original Method ----------
        //out = new BufferedWriter(new OutputStreamWriter(os, csn));
        //locale = l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.247 -0400", hash_original_method = "6A92C9283CC7B01627E24F0E27824A3B", hash_generated_method = "EF9BC443EC2682F3121DB34BBAB1CB88")
    public  Formatter(PrintStream ps) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.256 -0400", hash_original_method = "9D62CCD9646FE324AC0FFA6EB7C17C6C", hash_generated_method = "D61B27A6DE26EE81C30D46150263A647")
    private NativeDecimalFormat getDecimalFormat(String pattern) {
        NativeDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_1000873642 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1000873642 = cachedDecimalFormat.get().update(localeData, pattern);
        addTaint(pattern.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1000873642.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1000873642;
        // ---------- Original Method ----------
        //return cachedDecimalFormat.get().update(localeData, pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.257 -0400", hash_original_method = "E3DA6A4C963B6E9187963221C571CEC2", hash_generated_method = "CED13C9417F36F227519AB72CA97A589")
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new FormatterClosedException();
        } //End block
        // ---------- Original Method ----------
        //if (closed) {
            //throw new FormatterClosedException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.257 -0400", hash_original_method = "B5A8A4A4A455286143E3BD4E75C6F0FE", hash_generated_method = "A018C6C7DB06DA4E858D700EBC581032")
    public Locale locale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1504472737 = null; //Variable for return #1
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_1504472737 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_1504472737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1504472737;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.257 -0400", hash_original_method = "D73A5BF8E95D39CBD6819B9B1AA13C8D", hash_generated_method = "902DD0EAFDA950BDD6B824076DB34E40")
    public Appendable out() {
        Appendable varB4EAC82CA7396A68D541C85D26508E83_500915850 = null; //Variable for return #1
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_500915850 = out;
        varB4EAC82CA7396A68D541C85D26508E83_500915850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_500915850;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.258 -0400", hash_original_method = "39CF8FB3A631311648D12D228411CE26", hash_generated_method = "A4802686B126C2FD8ABC344B6622BCCA")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_815891732 = null; //Variable for return #1
        checkNotClosed();
        varB4EAC82CA7396A68D541C85D26508E83_815891732 = out.toString();
        varB4EAC82CA7396A68D541C85D26508E83_815891732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_815891732;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return out.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.258 -0400", hash_original_method = "E9CBCF5548B5D691C8801114F0C41C59", hash_generated_method = "013B35C8AAE53BF641F7E9D982E1D4C6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.259 -0400", hash_original_method = "16C1939C51EF65BBD0A872F925CE78BF", hash_generated_method = "707CBA92274B8C8AF142983EEBDF49F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.259 -0400", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "F23CD95D816404C2765A2424151E2A01")
    public IOException ioException() {
        IOException varB4EAC82CA7396A68D541C85D26508E83_126044296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_126044296 = lastIOException;
        varB4EAC82CA7396A68D541C85D26508E83_126044296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_126044296;
        // ---------- Original Method ----------
        //return lastIOException;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.268 -0400", hash_original_method = "EE9FCF62B0D200225753D8BA586AA3F5", hash_generated_method = "871DF1DE868E7EC049232D16005187EF")
    public Formatter format(String format, Object... args) {
        Formatter varB4EAC82CA7396A68D541C85D26508E83_235226080 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_235226080 = format(this.locale, format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_235226080.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_235226080;
        // ---------- Original Method ----------
        //return format(this.locale, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.269 -0400", hash_original_method = "F45273151F6DD69ACB6CCC03C59753A4", hash_generated_method = "54E332607813200261B08CE17235E407")
    public Formatter format(Locale l, String format, Object... args) {
        Formatter varB4EAC82CA7396A68D541C85D26508E83_219724498 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_219724498 = this;
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_219724498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_219724498;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.270 -0400", hash_original_method = "960E24FB807777DEBBE8328729AF6A3F", hash_generated_method = "C8DC0198B18E1FDF3CEBF31365C992F6")
    private void doFormat(String format, Object... args) {
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
                    boolean var15437F24151F4B9BB4CF0F9304E51BA9_76864861 = (token.requireArgument());
                    {
                        int index;
                        boolean varE3D8046091E4D6BBC992AF3D15742E1E_1149505584 = (token.getArgIndex() == FormatToken.UNSET);
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
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.278 -0400", hash_original_method = "4A93F3F0DF6F4E45CC93AF5660722832", hash_generated_method = "7B8F10843DEF23B6000374A8576830D5")
    private void outputCharSequence(CharSequence cs, int start, int end) {
        try 
        {
            out.append(cs, start, end);
        } //End block
        catch (IOException e)
        {
            lastIOException = e;
        } //End block
        addTaint(cs.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //try {
            //out.append(cs, start, end);
        //} catch (IOException e) {
            //lastIOException = e;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.279 -0400", hash_original_method = "4EF20CF84298D39EE17983F53878C341", hash_generated_method = "C9BC21D89AF24B658BB63AE83EA6979F")
    private Object getArgument(Object[] args, int index, FormatSpecifierParser fsp,
            Object lastArgument, boolean hasLastArgumentSet) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1102875242 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_895794714 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1944106513 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException("<");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1102875242 = null;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new MissingFormatArgumentException(fsp.getFormatSpecifierText());
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_895794714 = lastArgument;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1944106513 = args[index];
        addTaint(args[0].getTaint());
        addTaint(index);
        addTaint(fsp.getTaint());
        addTaint(lastArgument.getTaint());
        addTaint(hasLastArgumentSet);
        Object varA7E53CE21691AB073D9660D615818899_501242425; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_501242425 = varB4EAC82CA7396A68D541C85D26508E83_1102875242;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_501242425 = varB4EAC82CA7396A68D541C85D26508E83_895794714;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_501242425 = varB4EAC82CA7396A68D541C85D26508E83_1944106513;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_501242425.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_501242425;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.292 -0400", hash_original_method = "0237F1DF7BD7A386A4F4D1B44D43876F", hash_generated_method = "6AA744FA9316AF7E94BC19BABD11355B")
    private CharSequence transform(FormatToken token, Object argument) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_797677058 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_164261119 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_635171869 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_997899096 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2081961334 = null; //Variable for return #5
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2045036181 = null; //Variable for return #6
        this.formatToken = token;
        this.arg = argument;
        {
            boolean var774D16194421B6759CE7C28102870BC1_1056328516 = (token.isDefault());
            {
                {
                    Object var3AF4190693AD8752FD689B6D6C2F4FD0_411359809 = (token.getConversionType());
                    //Begin case 's' 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_797677058 = "null";
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_164261119 = arg.toString();
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
                            varB4EAC82CA7396A68D541C85D26508E83_635171869 = null;
                        } //End block
                        {
                            IntegralToString.appendLong((StringBuilder) out, ((Long) arg).longValue());
                            varB4EAC82CA7396A68D541C85D26508E83_997899096 = null;
                        } //End block
                    } //End block
                    //End case 'd' 
                    //Begin case 'd' 
                    {
                        String result;
                        result = arg.toString();
                        varB4EAC82CA7396A68D541C85D26508E83_2081961334 = needLocalizedDigits ? localizeDigits(result) : result;
                    } //End block
                    //End case 'd' 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        formatToken.checkFlags(arg);
        CharSequence result;
        {
            Object var1A1A65DF413B75C3108F1920C1E23A5B_1002985357 = (token.getConversionType());
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
            boolean var1DB4C6B053C2BBEFBDA3D42D86D066E6_1156635032 = (Character.isUpperCase(token.getConversionType()));
            {
                {
                    result = result.toString().toUpperCase(locale);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2045036181 = result;
        CharSequence varA7E53CE21691AB073D9660D615818899_1723500585; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1723500585 = varB4EAC82CA7396A68D541C85D26508E83_797677058;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1723500585 = varB4EAC82CA7396A68D541C85D26508E83_164261119;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1723500585 = varB4EAC82CA7396A68D541C85D26508E83_635171869;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1723500585 = varB4EAC82CA7396A68D541C85D26508E83_997899096;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1723500585 = varB4EAC82CA7396A68D541C85D26508E83_2081961334;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1723500585 = varB4EAC82CA7396A68D541C85D26508E83_2045036181;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1723500585.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1723500585;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.292 -0400", hash_original_method = "D44F27ADB431306CEB9F9E1F25036901", hash_generated_method = "124E61E1871259646BE10006ACCFBD1F")
    private IllegalFormatConversionException badArgumentType() {
        if (DroidSafeAndroidRuntime.control) throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
        // ---------- Original Method ----------
        //throw new IllegalFormatConversionException(formatToken.getConversionType(), arg.getClass());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.293 -0400", hash_original_method = "8CD3AC57424B332A3611698407D98FD3", hash_generated_method = "1F638624888998830EF549E9297710B2")
    private CharSequence localizeDigits(CharSequence s) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2131957147 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2131957147 = result;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2131957147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2131957147;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.311 -0400", hash_original_method = "CC3FF2DA7072A05A8664F97319F6C752", hash_generated_method = "7EFEEC311493EAB1D3F91F5965ED8A19")
    private CharSequence insertGrouping(CharSequence s) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_741048011 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(s.length() + s.length()/3);
        int digitsLength;
        digitsLength = s.length();
        int i;
        i = 0;
        {
            boolean var9A0E6F317753A236C52C55D585498BB1_681184938 = (s.charAt(0) == '-');
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
            boolean var9E95E9D345FEFD15BDBA0B863D5CE5D9_343917682 = (i < s.length());
            i += 3;
            {
                result.append(localeData.groupingSeparator);
                result.append(s, i, i + 3);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_741048011 = result;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_741048011.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_741048011;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.312 -0400", hash_original_method = "54F34C95EDCEEE411BD250D07A12E500", hash_generated_method = "DD6798C55CAD06A8B20B0C022F6763DE")
    private CharSequence transformFromBoolean() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1006559755 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1006559755 = padding(result, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1006559755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1006559755;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.312 -0400", hash_original_method = "FEE63D21FF5AA7B8F21641D7D3CB6697", hash_generated_method = "379956CD5900BEA17C854C8E14625FC5")
    private CharSequence transformFromHashCode() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_761014341 = null; //Variable for return #1
        CharSequence result;
        {
            result = "null";
        } //End block
        {
            result = Integer.toHexString(arg.hashCode());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_761014341 = padding(result, 0);
        varB4EAC82CA7396A68D541C85D26508E83_761014341.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761014341;
        // ---------- Original Method ----------
        //CharSequence result;
        //if (arg == null) {
            //result = "null";
        //} else {
            //result = Integer.toHexString(arg.hashCode());
        //}
        //return padding(result, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.313 -0400", hash_original_method = "41FDF272148D1D909A3CC241D4F2B404", hash_generated_method = "545D9FD920ADB78A7C3ACF5F67BAF2EC")
    private CharSequence transformFromString() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1165420654 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1518675671 = null; //Variable for return #2
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
                boolean varE5047B2B0C3ABA50902192D0CF9C9641_2145679397 = (Character.isUpperCase(formatToken.getConversionType()));
                {
                    flags |= FormattableFlags.UPPERCASE;
                } //End block
            } //End collapsed parenthetic
            ((Formattable) arg).formatTo(this, flags, formatToken.getWidth(),
                    formatToken.getPrecision());
            varB4EAC82CA7396A68D541C85D26508E83_1165420654 = null;
        } //End block
        CharSequence result;
        result = arg.toString();
        result = "null";
        varB4EAC82CA7396A68D541C85D26508E83_1518675671 = padding(result, 0);
        CharSequence varA7E53CE21691AB073D9660D615818899_360592498; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_360592498 = varB4EAC82CA7396A68D541C85D26508E83_1165420654;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_360592498 = varB4EAC82CA7396A68D541C85D26508E83_1518675671;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_360592498.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_360592498;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.323 -0400", hash_original_method = "78103310C8550D540C751775D2E73F1B", hash_generated_method = "115612040C09B020C3E31139106B9882")
    private CharSequence transformFromCharacter() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_624916292 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1759700963 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1040316364 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_624916292 = padding("null", 0);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1759700963 = padding(String.valueOf(arg), 0);
        } //End block
        {
            int codePoint;
            codePoint = ((Number) arg).intValue();
            {
                boolean var6F543C204E9C4F46177946447429AAE1_1227513057 = (!Character.isValidCodePoint(codePoint));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalFormatCodePointException(codePoint);
                } //End block
            } //End collapsed parenthetic
            CharSequence result;
            result = String.valueOf((char) codePoint);
            result = String.valueOf(Character.toChars(codePoint));
            varB4EAC82CA7396A68D541C85D26508E83_1040316364 = padding(result, 0);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } //End block
        CharSequence varA7E53CE21691AB073D9660D615818899_652993926; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_652993926 = varB4EAC82CA7396A68D541C85D26508E83_624916292;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_652993926 = varB4EAC82CA7396A68D541C85D26508E83_1759700963;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_652993926 = varB4EAC82CA7396A68D541C85D26508E83_1040316364;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_652993926.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_652993926;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.333 -0400", hash_original_method = "1802F533F155B8AA49557FA5A74B7DBE", hash_generated_method = "BC31FD914D37EF6AF3A81A276E774F93")
    private CharSequence transformFromPercent() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1959091886 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1959091886 = padding("%", 0);
        varB4EAC82CA7396A68D541C85D26508E83_1959091886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1959091886;
        // ---------- Original Method ----------
        //return padding("%", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.343 -0400", hash_original_method = "EF7726D1BC858C4C5BDC40B9ACBD3ABF", hash_generated_method = "C21CB2DF34C8D517993294A8B521D4F1")
    private CharSequence padding(CharSequence source, int startIndex) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_840449034 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1624945176 = null; //Variable for return #2
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_840449034 = source;
        } //End block
        char paddingChar;
        paddingChar = '\u0020';
        {
            {
                boolean var5580C15E55C4240F2395BB7B30D9E99A_985090986 = (formatToken.getConversionType() == 'd');
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
        varB4EAC82CA7396A68D541C85D26508E83_1624945176 = result;
        addTaint(source.getTaint());
        addTaint(startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_547644374; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_547644374 = varB4EAC82CA7396A68D541C85D26508E83_840449034;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_547644374 = varB4EAC82CA7396A68D541C85D26508E83_1624945176;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_547644374.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_547644374;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.346 -0400", hash_original_method = "AA67EEFB247ACC7BDA1BABCD03B30A80", hash_generated_method = "7613B332C68A74F5A5767A184C478547")
    private StringBuilder toStringBuilder(CharSequence cs) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_1475106851 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1475106851 = cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
        addTaint(cs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1475106851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1475106851;
        // ---------- Original Method ----------
        //return cs instanceof StringBuilder ? (StringBuilder) cs : new StringBuilder(cs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.347 -0400", hash_original_method = "CE1A2CC9741A13D14659E3953A660AC1", hash_generated_method = "FFA4E0996135329AB24ED670FC3EF442")
    private StringBuilder wrapParentheses(StringBuilder result) {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_533845643 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_533845643 = result;
        addTaint(result.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_533845643.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_533845643;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.361 -0400", hash_original_method = "FADDE3D8C4FA639F028B03B661D10023", hash_generated_method = "AE15258427E003922DF7B2B95354CCB7")
    private CharSequence transformFromInteger() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1889261 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_879789797 = null; //Variable for return #2
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
                    varB4EAC82CA7396A68D541C85D26508E83_1889261 = wrapParentheses(result);
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
        varB4EAC82CA7396A68D541C85D26508E83_879789797 = padding(result, startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_1034925211; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1034925211 = varB4EAC82CA7396A68D541C85D26508E83_1889261;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1034925211 = varB4EAC82CA7396A68D541C85D26508E83_879789797;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1034925211.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1034925211;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.362 -0400", hash_original_method = "15D0DEB8422EE33E04C98AFC872D1D51", hash_generated_method = "FA379B423A306D6DD801FDC2AC23DFC2")
    private CharSequence transformFromNull() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1519764292 = null; //Variable for return #1
        formatToken.flagZero = false;
        varB4EAC82CA7396A68D541C85D26508E83_1519764292 = padding("null", 0);
        varB4EAC82CA7396A68D541C85D26508E83_1519764292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519764292;
        // ---------- Original Method ----------
        //formatToken.flagZero = false;
        //return padding("null", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.382 -0400", hash_original_method = "28740AE89E2FC451EFE3093F54121A6C", hash_generated_method = "C19FDAA67F1C1EE2D77F12943B3AA9E3")
    private CharSequence transformFromBigInteger() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1114101913 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_624787625 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1504883310 = null; //Variable for return #3
        int startIndex;
        startIndex = 0;
        StringBuilder result;
        result = new StringBuilder();
        BigInteger bigInt;
        bigInt = (BigInteger) arg;
        char currentConversionType;
        currentConversionType = formatToken.getConversionType();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1114101913 = transformFromNull();
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
            varB4EAC82CA7396A68D541C85D26508E83_624787625 = wrapParentheses(result);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1504883310 = padding(result, startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_1899396296; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1899396296 = varB4EAC82CA7396A68D541C85D26508E83_1114101913;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1899396296 = varB4EAC82CA7396A68D541C85D26508E83_624787625;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1899396296 = varB4EAC82CA7396A68D541C85D26508E83_1504883310;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1899396296.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1899396296;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.394 -0400", hash_original_method = "3FA485DEFE055FA59E9A89B7029B3055", hash_generated_method = "511E563442006353B284D957ED4FE113")
    private CharSequence transformFromDateTime() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_402692599 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_892046889 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_402692599 = transformFromNull();
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
            boolean varCAB943A58957944F491BEB3F9C12AAC8_1352805561 = (!appendT(result, formatToken.getDateSuffix(), calendar));
            {
                if (DroidSafeAndroidRuntime.control) throw formatToken.unknownFormatConversionException();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_892046889 = padding(result, 0);
        CharSequence varA7E53CE21691AB073D9660D615818899_1145730221; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1145730221 = varB4EAC82CA7396A68D541C85D26508E83_402692599;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1145730221 = varB4EAC82CA7396A68D541C85D26508E83_892046889;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1145730221.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1145730221;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.400 -0400", hash_original_method = "6A85D50A5F6F83B5DE3D767D1CCF3B76", hash_generated_method = "161647A5391FD2CF2D58AEC448BB75EF")
    private boolean appendT(StringBuilder result, char conversion, Calendar calendar) {
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
        addTaint(result.getTaint());
        addTaint(conversion);
        addTaint(calendar.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_124076993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_124076993;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.401 -0400", hash_original_method = "07C369462F22245026E1280008B34AEC", hash_generated_method = "DBB283FB0D3C776EF33B97D855A6289E")
    private int to12Hour(int hour) {
        addTaint(hour);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399494362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399494362;
        // ---------- Original Method ----------
        //return hour == 0 ? 12 : hour;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.523 -0400", hash_original_method = "60B30B4DC0B127EF94D361BC9EB2AF90", hash_generated_method = "B21775F826EB3A831071CAF4CEC6C17C")
    private void appendLocalized(StringBuilder result, long value, int width) {
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
        addTaint(result.getTaint());
        addTaint(value);
        addTaint(width);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.525 -0400", hash_original_method = "977B62B975352D4F075C1101DB18FB73", hash_generated_method = "3A6D1178F3EEA5FEE0074E79C9C2E2AD")
    private CharSequence transformFromSpecialNumber(double d) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_912252484 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1633589589 = null; //Variable for return #2
        String source;
        source = null;
        {
            boolean varF573A637641E1AB21D698815AEB110FB_1387685967 = (Double.isNaN(d));
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
            {
                varB4EAC82CA7396A68D541C85D26508E83_912252484 = null;
            } //End block
        } //End collapsed parenthetic
        formatToken.setPrecision(FormatToken.UNSET);
        formatToken.flagZero = false;
        varB4EAC82CA7396A68D541C85D26508E83_1633589589 = padding(source, 0);
        addTaint(d);
        CharSequence varA7E53CE21691AB073D9660D615818899_1996429677; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1996429677 = varB4EAC82CA7396A68D541C85D26508E83_912252484;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1996429677 = varB4EAC82CA7396A68D541C85D26508E83_1633589589;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1996429677.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1996429677;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.527 -0400", hash_original_method = "DECF7ECF8109F764E81E2CF8101BCB0C", hash_generated_method = "D97911A087572361D6E9C69EE27307F1")
    private CharSequence transformFromFloat() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_701687647 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_951173437 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_863990172 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1089336274 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_701687647 = transformFromNull();
        } //End block
        {
            Number number;
            number = (Number) arg;
            double d;
            d = number.doubleValue();
            {
                varB4EAC82CA7396A68D541C85D26508E83_951173437 = transformFromSpecialNumber(d);
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw badArgumentType();
        } //End block
        char conversionType;
        conversionType = formatToken.getConversionType();
        {
            boolean var4D48FD270E3C43B43C7CAFA231E3C2A7_826071105 = (conversionType != 'a' && conversionType != 'A' && !formatToken.isPrecisionSet());
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
            boolean varC4FD83BCDCE254D147FDF9D7B3AC13AA_1185602984 = (result.charAt(0) == localeData.minusSign);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_863990172 = wrapParentheses(result);
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
        varB4EAC82CA7396A68D541C85D26508E83_1089336274 = padding(result, startIndex);
        CharSequence varA7E53CE21691AB073D9660D615818899_1824329279; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1824329279 = varB4EAC82CA7396A68D541C85D26508E83_701687647;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1824329279 = varB4EAC82CA7396A68D541C85D26508E83_951173437;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1824329279 = varB4EAC82CA7396A68D541C85D26508E83_863990172;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1824329279 = varB4EAC82CA7396A68D541C85D26508E83_1089336274;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1824329279.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1824329279;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.528 -0400", hash_original_method = "43DA2A76094CCA7D42287B4466035D61", hash_generated_method = "949F9C42786386F6F8D50D31E9DB8F14")
    private void transformE(StringBuilder result) {
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
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.564 -0400", hash_original_method = "1973123C0DFAE44325340FD650EA833E", hash_generated_method = "DEE14E33E9EDF441A9823594AA79557C")
    private void transformG(StringBuilder result) {
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
            boolean var3ECD0EAFA593A6ADC1E4F46524942B82_202261271 = (Double.isInfinite(d));
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
            boolean var7952BAED570DF8211C40DB97D6C9494B_549929838 = (d >= 1 && d < Math.pow(10, precision));
            {
                {
                    boolean var6DA2CA6307083AFD29BF7C8CBC3D16A4_320637568 = (l < Math.pow(10, precision));
                    {
                        requireScientificRepresentation = false;
                        precision -= String.valueOf(l).length();
                        precision = precision < 0 ? 0 : precision;
                        l = Math.round(d * Math.pow(10, precision + 1));
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_996436456 = (String.valueOf(l).length() <= formatToken.getPrecision());
                        } //End collapsed parenthetic
                        formatToken.setPrecision(precision);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                l = b.movePointRight(4).longValue();
                {
                    boolean varFC5D9BA1CE39DA4CE1D6C7B756E730FB_971432201 = (d >= Math.pow(10, -4) && d < 1);
                    {
                        requireScientificRepresentation = false;
                        precision += 4 - String.valueOf(l).length();
                        l = b.movePointRight(precision + 1).longValue();
                        {
                            boolean varC0398DDD0FEAEEB1CB8B19A12469A8A5_1539017322 = (String.valueOf(l).length() <= formatToken.getPrecision());
                        } //End collapsed parenthetic
                        l = b.movePointRight(precision).longValue();
                        {
                            boolean var48F2D010DC481B7F6EDFA70502BAD5C5_1745412752 = (l >= Math.pow(10, precision - 4));
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
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.565 -0400", hash_original_method = "DF70A96812FA1EE536149F6B5D8F4C45", hash_generated_method = "78C4D6B4769C83AB925F5AAFCD169C70")
    private void transformF(StringBuilder result) {
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
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.566 -0400", hash_original_method = "DCC3844221755C0C14FA659BF8647E6B", hash_generated_method = "52A70E9F9E74D2DC4BC191A2158E78B6")
    private void transformA(StringBuilder result) {
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
            boolean var0BA49339344F3E46004E2C66FA171DC0_174807558 = (!formatToken.isPrecisionSet());
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
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public enum BigDecimalLayoutForm {
        SCIENTIFIC,
        DECIMAL_FLOAT
    }

    
    private static class CachedDecimalFormat {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.566 -0400", hash_original_field = "DBECB303151001B254CD458C962BFA06", hash_generated_field = "57B03D121D93C35DC4CD446F8684FFFD")

        public NativeDecimalFormat decimalFormat;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.566 -0400", hash_original_field = "0DC9450ED9A8CE4C2B3A1D132A9E7261", hash_generated_field = "F1A921FEF7693E6D4DF1F57B4D8F992B")

        public LocaleData currentLocaleData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.582 -0400", hash_original_field = "0B0F76B47F491349A26FCE54BEF066C1", hash_generated_field = "79B878750A67D50688DF69A25D47682C")

        public String currentPattern;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.582 -0400", hash_original_method = "3AB4302EBBD3C6ECF16B79A91E887CC6", hash_generated_method = "C4149067CD2AF28823E946F111841C62")
        public  CachedDecimalFormat() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.584 -0400", hash_original_method = "784B3214258603820EA00D340F6FA563", hash_generated_method = "612879D09B1F53DB014CEBB37CB45FA5")
        public NativeDecimalFormat update(LocaleData localeData, String pattern) {
            NativeDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_371796258 = null; //Variable for return #1
            {
                currentPattern = pattern;
                currentLocaleData = localeData;
                decimalFormat = new NativeDecimalFormat(currentPattern, currentLocaleData);
            } //End block
            {
                boolean varC04205845392AD76FE20C5C34EA780FF_1035961879 = (!pattern.equals(currentPattern));
                {
                    decimalFormat.applyPattern(pattern);
                    currentPattern = pattern;
                } //End block
            } //End collapsed parenthetic
            {
                decimalFormat.setDecimalFormatSymbols(localeData);
                currentLocaleData = localeData;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_371796258 = decimalFormat;
            varB4EAC82CA7396A68D541C85D26508E83_371796258.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_371796258;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.585 -0400", hash_original_field = "CABEE536F594A7425CADCE9FE8AB1016", hash_generated_field = "772417271F7F0BDFEA0E64414172A084")

        private int argIndex = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "AF7A833327A8AE088613AF6547808B22", hash_generated_field = "98479ABC53D035AE015748B6501BED19")

        boolean flagComma;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "77D00CCF13983863513393B04DE90A5E", hash_generated_field = "84E0FE8767B1823F9BD483DE94C8D5B6")

        boolean flagMinus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "58EB12214972261349BEFF4AFEEBADE7", hash_generated_field = "6268F94D7EC6432771FAC9A81C06B277")

        boolean flagParenthesis;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "2FC88FB85E37FA3049E7C4FB6131D130", hash_generated_field = "B18F735AA5B0F0DABBD7E427068CC4C3")

        boolean flagPlus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "CA9A273EC976964302B347E1A888F814", hash_generated_field = "C720CA7CDB619DB58116FBA407D9470B")

        boolean flagSharp;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "0A9A68E8CA9C930B3BD25AC0267A50F6", hash_generated_field = "A2EE573CAED7292D13BAD741251059A4")

        boolean flagSpace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "23AC23B8E4A938ABDC183973ABADFBB2", hash_generated_field = "79C0F430E2F3E53D9DF49552E4733685")

        boolean flagZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "06BB72258511A33C8D897372F71D9BEB", hash_generated_field = "E9F667FE63992DF0A85E5D7A0685E01F")

        private char conversionType = (char) UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "CBA7C70F75D3196A71CEB9803FA45256", hash_generated_field = "6AC9B9E35F29643906A8717247B50CCB")

        private char dateSuffix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "448C0902A81C3D78DB12BA0C73991461", hash_generated_field = "1A5EEC185E39D6E54480D34E352CE283")

        private int precision = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "E3737662F9BF753CD6F77C63AE3B771F", hash_generated_field = "7F084C83D0F1982A47DE9354FC0CF9F1")

        private int width = UNSET;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.590 -0400", hash_original_field = "8A84BD7A36073EE32C37C1B79462B501", hash_generated_field = "0527ECB4D15D76D63A180FF8CBB184B2")

        private StringBuilder strFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.591 -0400", hash_original_method = "98998A93ECCA1CEE378BE6F5FF82B45F", hash_generated_method = "98998A93ECCA1CEE378BE6F5FF82B45F")
        public FormatToken ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.591 -0400", hash_original_method = "A7B957B3122A1E0264F586D374F2E6B7", hash_generated_method = "9FD21A5A77DBB73248BED31F09CA10C3")
         boolean isDefault() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610464376 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610464376;
            // ---------- Original Method ----------
            //return !flagComma && !flagMinus && !flagParenthesis && !flagPlus && !flagSharp &&
                    //!flagSpace && !flagZero && width == UNSET && precision == UNSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.591 -0400", hash_original_method = "A13969ECEC9F8D1C94EA6A52CDFB6E17", hash_generated_method = "7572BEF8E1BD3D4F61ED32AABD3A2E01")
         boolean isPrecisionSet() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_948985745 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_948985745;
            // ---------- Original Method ----------
            //return precision != UNSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.592 -0400", hash_original_method = "3A74106121887CCA509F985D60DB5637", hash_generated_method = "59B7480D5EAA018E51C462D7F5F39C09")
         int getArgIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158124674 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158124674;
            // ---------- Original Method ----------
            //return argIndex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.592 -0400", hash_original_method = "27CE41687BF54420F4C00D2CFB6A73FA", hash_generated_method = "F3E94D0F268DD41F463EE67139BE9385")
         void setArgIndex(int index) {
            argIndex = index;
            // ---------- Original Method ----------
            //argIndex = index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.592 -0400", hash_original_method = "40140C97EC91863535630C305615FEC1", hash_generated_method = "1840BE7F9B19C847D065A7EA8E6CF818")
         int getWidth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413145974 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413145974;
            // ---------- Original Method ----------
            //return width;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.622 -0400", hash_original_method = "5C954D9C93DF99E2E990960A3CC1749D", hash_generated_method = "D40BD430ACB0EA3E0D63770A2976B08D")
         void setWidth(int width) {
            this.width = width;
            // ---------- Original Method ----------
            //this.width = width;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.622 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "3DD11CF9C80022CB6BF06B910E35C3AD")
         int getPrecision() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464924209 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464924209;
            // ---------- Original Method ----------
            //return precision;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.623 -0400", hash_original_method = "7515FB19ACE3C47DEBBD3E8357F6915C", hash_generated_method = "5866B10F1157266750859E3B0502D979")
         void setPrecision(int precise) {
            this.precision = precise;
            // ---------- Original Method ----------
            //this.precision = precise;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.624 -0400", hash_original_method = "837A02C50E03265F058B23775F6F6197", hash_generated_method = "391399241DDA2FB9B7EBC7A3BD631354")
         String getStrFlags() {
            String varB4EAC82CA7396A68D541C85D26508E83_410645240 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_410645240 = (strFlags != null) ? strFlags.toString() : "";
            varB4EAC82CA7396A68D541C85D26508E83_410645240.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_410645240;
            // ---------- Original Method ----------
            //return (strFlags != null) ? strFlags.toString() : "";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.639 -0400", hash_original_method = "E6ACD7E32E6ABC5AE16C357DB8116DB3", hash_generated_method = "266C9E2FF92ECFE71454EEAECAD63E34")
         boolean setFlag(int ch) {
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
            addTaint(ch);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1315237846 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1315237846;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.639 -0400", hash_original_method = "563B5213711441DEFA9BB3355CD61032", hash_generated_method = "5A87F1ED9B2BBFF8F73CE1FB8E0D9B95")
         char getConversionType() {
            char varA87DEB01C5F539E6BDA34829C8EF2368_447681633 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_447681633;
            // ---------- Original Method ----------
            //return conversionType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.639 -0400", hash_original_method = "6C3279116A999B7A879305F448E4C7E6", hash_generated_method = "37AF4C580148FD1E99691D99021A9434")
         void setConversionType(char c) {
            conversionType = c;
            // ---------- Original Method ----------
            //conversionType = c;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.640 -0400", hash_original_method = "EE45DA1AFAF958B13872135C146745E9", hash_generated_method = "7AE174F40D2C8C8EA4668C28DBE00288")
         char getDateSuffix() {
            char varA87DEB01C5F539E6BDA34829C8EF2368_1107812795 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1107812795;
            // ---------- Original Method ----------
            //return dateSuffix;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.640 -0400", hash_original_method = "6F4F20E9A23952874C5B1A6A80E321B4", hash_generated_method = "B3184FE9D51C912BE0F6FB157BD6AF85")
         void setDateSuffix(char c) {
            dateSuffix = c;
            // ---------- Original Method ----------
            //dateSuffix = c;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.640 -0400", hash_original_method = "67F4DE623207C5AE23B919ACAD45AA0B", hash_generated_method = "EA57481F92F75B08ED3C04F0EE3B8718")
         boolean requireArgument() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977458773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_977458773;
            // ---------- Original Method ----------
            //return conversionType != '%' && conversionType != 'n';
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.670 -0400", hash_original_method = "34D9D8688BA6BF211700F1E1A866C731", hash_generated_method = "56FE71540218C91494B42CA3F736F857")
         void checkFlags(Object arg) {
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
            addTaint(arg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.671 -0400", hash_original_method = "ECFEC3AA46FEEC6BDD34290E5303C5C1", hash_generated_method = "1F40DF5C85005D492273A294DD80B82F")
        public UnknownFormatConversionException unknownFormatConversionException() {
            {
                if (DroidSafeAndroidRuntime.control) throw new UnknownFormatConversionException(String.format("%c%c",
                        conversionType, dateSuffix));
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UnknownFormatConversionException(String.valueOf(conversionType));
            // ---------- Original Method ----------
            //if (conversionType == 't' || conversionType == 'T') {
                //throw new UnknownFormatConversionException(String.format("%c%c",
                        //conversionType, dateSuffix));
            //}
            //throw new UnknownFormatConversionException(String.valueOf(conversionType));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.671 -0400", hash_original_field = "0D32D75D80197F9844932D7929DB5015", hash_generated_field = "4838A237F0CA625FBEF0C47D75A467F3")

        static int LAST_ARGUMENT_INDEX = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.671 -0400", hash_original_field = "682DBD04772A37CB99D92EB22481F8C6", hash_generated_field = "CF0957A0598B24AFC845C2D7EA89AC9D")

        static int UNSET = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.671 -0400", hash_original_field = "8FE6A229232BC2E57ECCA9364408A298", hash_generated_field = "822D4D5D37D288CD3F0EE0538BD215B6")

        static int FLAGS_UNSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.671 -0400", hash_original_field = "AEFDD97FD64534132DA681FF73D9FC6D", hash_generated_field = "8568B544001A5D706A13E03FC312BB1B")

        static int DEFAULT_PRECISION = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.672 -0400", hash_original_field = "60A2F91F5F69F60923439B86F77F3E9E", hash_generated_field = "B609C087757A73DA0A261F76F6BF2C2A")

        static int FLAG_ZERO = 1 << 4;
    }


    
    private static class FormatSpecifierParser {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.672 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "3AFBEC2146BDEA5BFCBD2772D27C43DD")

        private String format;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.672 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

        private int length;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.672 -0400", hash_original_field = "04D77DDD9C9389CC56939726D3DA8089", hash_generated_field = "4DF8ED554EC7B2C7483518163DCC894C")

        private int startIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.672 -0400", hash_original_field = "865C0C0B4AB0E063E5CAA3387C1A8741", hash_generated_field = "DDFC4038967415E2F22993ABFD9A3B3F")

        private int i;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.672 -0400", hash_original_method = "2EAAE714EE0AE41BF39DBCA3F91B9104", hash_generated_method = "99616AB8C1E30FEFAAC91AD743EEE46F")
          FormatSpecifierParser(String format) {
            this.format = format;
            this.length = format.length();
            // ---------- Original Method ----------
            //this.format = format;
            //this.length = format.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.686 -0400", hash_original_method = "F77740880648C3886F14C74FD023BD3A", hash_generated_method = "693F116143425E99016BEBC633F98D07")
         FormatToken parseFormatToken(int offset) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_351552592 = null; //Variable for return #1
            this.startIndex = offset;
            this.i = offset;
            varB4EAC82CA7396A68D541C85D26508E83_351552592 = parseArgumentIndexAndFlags(new FormatToken());
            varB4EAC82CA7396A68D541C85D26508E83_351552592.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_351552592;
            // ---------- Original Method ----------
            //this.startIndex = offset;
            //this.i = offset;
            //return parseArgumentIndexAndFlags(new FormatToken());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.687 -0400", hash_original_method = "7C388C74117CDF3E7844B526DC734D8C", hash_generated_method = "CC079BD0C7E33CD798B931F1E2383EAA")
         String getFormatSpecifierText() {
            String varB4EAC82CA7396A68D541C85D26508E83_1540003471 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1540003471 = format.substring(startIndex, i);
            varB4EAC82CA7396A68D541C85D26508E83_1540003471.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1540003471;
            // ---------- Original Method ----------
            //return format.substring(startIndex, i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.687 -0400", hash_original_method = "6521B9C02DA744FF180556D39A74ED44", hash_generated_method = "497086B916AF445955078DF068260054")
        private int peek() {
            {
                Object var765273F0E3B5EB95414F86EBEA317E40_849986338 = (format.charAt(i));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280572037 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280572037;
            // ---------- Original Method ----------
            //return (i < length) ? format.charAt(i) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.687 -0400", hash_original_method = "F520742ED92EBACDB47FBF0D0B1F08F4", hash_generated_method = "A299749288C2E72FE85C02A751B623BF")
        private char advance() {
            {
                if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
            } //End block
            char var7701A7CCE85ED6AA9880F4BA6BB09ECE_1137715258 = (format.charAt(i++));
            char varA87DEB01C5F539E6BDA34829C8EF2368_1282467617 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1282467617;
            // ---------- Original Method ----------
            //if (i >= length) {
                //throw unknownFormatConversionException();
            //}
            //return format.charAt(i++);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.688 -0400", hash_original_method = "DFAEBB829CC6A7AFE465DA1B9A0C1D5A", hash_generated_method = "30FA7929508460104EF53B75E4099319")
        private UnknownFormatConversionException unknownFormatConversionException() {
            if (DroidSafeAndroidRuntime.control) throw new UnknownFormatConversionException(getFormatSpecifierText());
            // ---------- Original Method ----------
            //throw new UnknownFormatConversionException(getFormatSpecifierText());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.709 -0400", hash_original_method = "AD27190704DEC79DF3778A7C88589CDF", hash_generated_method = "26E9293E584CFB7C474F20E5866A8E1A")
        private FormatToken parseArgumentIndexAndFlags(FormatToken token) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1971972733 = null; //Variable for return #1
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_229711706 = null; //Variable for return #2
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_2051387731 = null; //Variable for return #3
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1240968954 = null; //Variable for return #4
            int position;
            position = i;
            int ch;
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_784368501 = (Character.isDigit(ch));
                {
                    int number;
                    number = nextInt();
                    {
                        boolean varAF443300A994E05CBD4A93B1F0A6046B_1257321927 = (peek() == '$');
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
                                varB4EAC82CA7396A68D541C85D26508E83_1971972733 = parseWidth(token, number);
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
                boolean varD959591D21FA1B51681982FB61D589FE_1763853073 = (token.setFlag(peek()));
                {
                    advance();
                } //End block
            } //End collapsed parenthetic
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_289384124 = (Character.isDigit(ch));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_229711706 = parseWidth(token, nextInt());
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2051387731 = parsePrecision(token);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1240968954 = parseConversionType(token);
                } //End block
            } //End collapsed parenthetic
            addTaint(token.getTaint());
            FormatToken varA7E53CE21691AB073D9660D615818899_489069412; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_489069412 = varB4EAC82CA7396A68D541C85D26508E83_1971972733;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_489069412 = varB4EAC82CA7396A68D541C85D26508E83_229711706;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_489069412 = varB4EAC82CA7396A68D541C85D26508E83_2051387731;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_489069412 = varB4EAC82CA7396A68D541C85D26508E83_1240968954;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_489069412.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_489069412;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.710 -0400", hash_original_method = "F4C6E47C7F58A93445972E2EDFDFCD5C", hash_generated_method = "7021D4A31D5149F97DA3D8B23BA77653")
        private FormatToken parseWidth(FormatToken token, int width) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1169111944 = null; //Variable for return #1
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_1678143010 = null; //Variable for return #2
            token.setWidth(width);
            int ch;
            ch = peek();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1169111944 = parsePrecision(token);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1678143010 = parseConversionType(token);
            } //End block
            addTaint(token.getTaint());
            addTaint(width);
            FormatToken varA7E53CE21691AB073D9660D615818899_642981611; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_642981611 = varB4EAC82CA7396A68D541C85D26508E83_1169111944;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_642981611 = varB4EAC82CA7396A68D541C85D26508E83_1678143010;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_642981611.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_642981611;
            // ---------- Original Method ----------
            //token.setWidth(width);
            //int ch = peek();
            //if (ch == '.') {
                //return parsePrecision(token);
            //} else {
                //return parseConversionType(token);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.715 -0400", hash_original_method = "06DE93E908B11B43F41251F270A468F2", hash_generated_method = "08F3C926789452F259A842A56F46F3D8")
        private FormatToken parsePrecision(FormatToken token) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_134138821 = null; //Variable for return #1
            advance();
            int ch;
            ch = peek();
            {
                boolean varDFC3E7B8AB55A9B54C0F9DEC46B1A118_1992682545 = (Character.isDigit(ch));
                {
                    token.setPrecision(nextInt());
                    varB4EAC82CA7396A68D541C85D26508E83_134138821 = parseConversionType(token);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw unknownFormatConversionException();
                } //End block
            } //End collapsed parenthetic
            addTaint(token.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_134138821.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_134138821;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.741 -0400", hash_original_method = "779E7C7A9E24C2B8C7A984530163E241", hash_generated_method = "E7C3CE4C8BF0E9E9E22782433499E328")
        private FormatToken parseConversionType(FormatToken token) {
            FormatToken varB4EAC82CA7396A68D541C85D26508E83_203319331 = null; //Variable for return #1
            char conversionType;
            conversionType = advance();
            token.setConversionType(conversionType);
            {
                char dateSuffix;
                dateSuffix = advance();
                token.setDateSuffix(dateSuffix);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_203319331 = token;
            addTaint(token.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_203319331.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_203319331;
            // ---------- Original Method ----------
            //char conversionType = advance();
            //token.setConversionType(conversionType);
            //if (conversionType == 't' || conversionType == 'T') {
                //char dateSuffix = advance(); 
                //token.setDateSuffix(dateSuffix);
            //}
            //return token;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.742 -0400", hash_original_method = "ADF8322FF676CF5038257F50E4E4E6DC", hash_generated_method = "42D00989F6CDA5F844A3BD4DD3C1B08D")
        private int nextInt() {
            long value;
            value = 0;
            {
                boolean var89C0C9F591E86A0985096DE42B7326D1_1830326268 = (i < length && Character.isDigit(format.charAt(i)));
                {
                    value = 10 * value + (format.charAt(i++) - '0');
                    {
                        int varBF2312BB009815DC54B749D4D210B6C9_1033577079 = (failNextInt());
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65303653 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_65303653;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.742 -0400", hash_original_method = "F2814F47D4EB7F1D4CA24D9FE1C3918D", hash_generated_method = "BD26CB5A1AE5BB2CFDC4444BBB3A4771")
        private int failNextInt() {
            {
                boolean varDB282127B78D2B872AE9DB5E44D7F6B7_1992755277 = (Character.isDigit(peek()));
                {
                    advance();
                } //End block
            } //End collapsed parenthetic
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345275945 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1345275945;
            // ---------- Original Method ----------
            //while (Character.isDigit(peek())) {
                //advance();
            //}
            //return FormatToken.UNSET;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.742 -0400", hash_original_field = "A2B3A99FDB3C7974C9307D50BA09396A", hash_generated_field = "83C24A683F165D37EA212CE26252E31E")

    private static char[] ZEROS = new char[] { '0', '0', '0', '0', '0', '0', '0', '0', '0' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.743 -0400", hash_original_field = "2E22D2BB824CAE76137397D7BB1A476C", hash_generated_field = "1048904B2ED8452BAFA6FF5C2969AC81")

    private static ThreadLocal<CachedDecimalFormat> cachedDecimalFormat = new ThreadLocal<CachedDecimalFormat>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:51.743 -0400", hash_original_method = "3BF85501572F336E7CB9026A6524A649", hash_generated_method = "8EF259F81B34C69FE9693535F36825AC")
        @Override
        protected CachedDecimalFormat initialValue() {
            CachedDecimalFormat varB4EAC82CA7396A68D541C85D26508E83_83452667 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_83452667 = new CachedDecimalFormat();
            varB4EAC82CA7396A68D541C85D26508E83_83452667.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_83452667;
            // ---------- Original Method ----------
            //return new CachedDecimalFormat();
        }

        
};
}

