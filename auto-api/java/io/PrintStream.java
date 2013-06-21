package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class PrintStream extends FilterOutputStream implements Appendable, Closeable {
    private boolean ioError;
    private boolean autoFlush;
    private String encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.203 -0400", hash_original_method = "DA75705BB6C20C2B5C6B266426BAE0E0", hash_generated_method = "EE77332F8FCFC3D4A07F5F4827DD80ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(OutputStream out) {
        super(out);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.203 -0400", hash_original_method = "4DF55F7DB2EC2DB5AB84BECA03073608", hash_generated_method = "F3833DD2E36B6CE119636F2447F05E3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(OutputStream out, boolean autoFlush) {
        super(out);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new NullPointerException();
        //}
        //this.autoFlush = autoFlush;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.203 -0400", hash_original_method = "88526CF0A98EC9AB97C7088D88161C3A", hash_generated_method = "64669F19FE4B1D28F43AF8FF313B6874")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(OutputStream out, boolean autoFlush, String enc) throws UnsupportedEncodingException {
        super(out);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(enc);
        dsTaint.addTaint(out.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        try 
        {
            {
                boolean var1619D1065190E523D5CEB80A273EC718_1294283824 = (!Charset.isSupported(enc));
                {
                    if (DroidSafeAndroidRuntime.control) throw new UnsupportedEncodingException(enc);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IllegalCharsetNameException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedEncodingException(enc);
        } //End block
        // ---------- Original Method ----------
        //if (out == null || enc == null) {
            //throw new NullPointerException();
        //}
        //this.autoFlush = autoFlush;
        //try {
            //if (!Charset.isSupported(enc)) {
                //throw new UnsupportedEncodingException(enc);
            //}
        //} catch (IllegalCharsetNameException e) {
            //throw new UnsupportedEncodingException(enc);
        //}
        //encoding = enc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.204 -0400", hash_original_method = "029BA830A503765157243541D9849231", hash_generated_method = "4BAC6560C58F049B141A2427954C4A6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(File file) throws FileNotFoundException {
        super(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.204 -0400", hash_original_method = "7BD29578480474358E31B9B912D3F437", hash_generated_method = "9FD7041C64BE31615D795A4A661366B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        super(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(csn);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var74A236C162A967F1ECD5EFC7D6467A04_930048867 = (!Charset.isSupported(csn));
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedEncodingException(csn);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (csn == null) {
            //throw new NullPointerException();
        //}
        //if (!Charset.isSupported(csn)) {
            //throw new UnsupportedEncodingException(csn);
        //}
        //encoding = csn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.204 -0400", hash_original_method = "75348CDEFC68D9839C10010605892932", hash_generated_method = "23AD6DE68F3866D8777D3B1E7369AE58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        dsTaint.addTaint(fileName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.204 -0400", hash_original_method = "8131D7469DBCAB446E9D65623F4F3558", hash_generated_method = "C24FC24E900BC3D05EBD791013539D7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.205 -0400", hash_original_method = "DD851A8041FFB3055294FF15D1DC9C59", hash_generated_method = "5AC41315BEA926E01D067C6C05B9A6DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean checkError() {
        OutputStream delegate;
        delegate = out;
        flush();
        boolean var1828C5393F7AF357FCA50D6B6EE1E98D_2118335973 = (ioError || delegate.checkError());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //OutputStream delegate = out;
        //if (delegate == null) {
            //return ioError;
        //}
        //flush();
        //return ioError || delegate.checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.205 -0400", hash_original_method = "785F4CCF429F72C42E20A1AABCB6C5CE", hash_generated_method = "CC852D7FE95E7B5290039A783A243D73")
    @DSModeled(DSC.SAFE)
    protected void clearError() {
        ioError = false;
        // ---------- Original Method ----------
        //ioError = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.205 -0400", hash_original_method = "43C4845D6E61D29AF25E893F4FEF10C8", hash_generated_method = "60AC52D337431F56BE65D46EF65784B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void close() {
        flush();
        {
            try 
            {
                out.close();
                out = null;
            } //End block
            catch (IOException e)
            {
                setError();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //flush();
        //if (out != null) {
            //try {
                //out.close();
                //out = null;
            //} catch (IOException e) {
                //setError();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.206 -0400", hash_original_method = "02B2E054E74BF295FB5EB637205E6B35", hash_generated_method = "2E5844F294C2AA82ABDA4B68E8A3C411")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void flush() {
        {
            try 
            {
                out.flush();
            } //End block
            catch (IOException e)
            { }
        } //End block
        setError();
        // ---------- Original Method ----------
        //if (out != null) {
            //try {
                //out.flush();
                //return;
            //} catch (IOException e) {
            //}
        //}
        //setError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.206 -0400", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "D467D6854BDADC247DE5A4062893D981")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream format(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        PrintStream varD8F2A1654CF3ACCC2BDB72B521CFFC4B_520069600 = (format(Locale.getDefault(), format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.206 -0400", hash_original_method = "A0786364FBC116E551740BAAD4532E24", hash_generated_method = "82D45203C514F8037F2F98B9965E2215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream format(Locale l, String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("format == null");
        } //End block
        new Formatter(this, l).format(format, args);
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (format == null) {
            //throw new NullPointerException("format == null");
        //}
        //new Formatter(this, l).format(format, args);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.206 -0400", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "6CEBB0EAB97CAA8E3102AC628638CAC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream printf(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        PrintStream var332B80BC927C6FFEEC76D8998999F86B_1296980124 = (format(format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.206 -0400", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "61B117781EC37CB63377567936F42A9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream printf(Locale l, String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        PrintStream var2451FE83B7001C97A9C60A0560E8EC1F_868010917 = (format(l, format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.207 -0400", hash_original_method = "171496FE667133D572716C296277B927", hash_generated_method = "26FA29E3F019DA8274A7A58369323ED3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void newline() {
        print(System.lineSeparator());
        // ---------- Original Method ----------
        //print(System.lineSeparator());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.207 -0400", hash_original_method = "4DD9E13DA9D3ED57FA18E838A052301E", hash_generated_method = "6942F02D5421F15E99CDFD019539C701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(char[] chars) {
        dsTaint.addTaint(chars[0]);
        print(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //print(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.207 -0400", hash_original_method = "C9EF4F31D0CD27922D7B220DA437A7D8", hash_generated_method = "88EC2B2A0CB540803B2C3D3D61C0BF69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(char c) {
        dsTaint.addTaint(c);
        print(String.valueOf(c));
        // ---------- Original Method ----------
        //print(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.207 -0400", hash_original_method = "7C6D053B4D54D80C9838D841006F1F5C", hash_generated_method = "C0024FA889A10BC22E9D7BDEE85E3A7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(double d) {
        dsTaint.addTaint(d);
        print(String.valueOf(d));
        // ---------- Original Method ----------
        //print(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.207 -0400", hash_original_method = "A190B4C4751A586A57985573C64F773B", hash_generated_method = "F4446CA2399538EC0F0F6FE29B0639D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(float f) {
        dsTaint.addTaint(f);
        print(String.valueOf(f));
        // ---------- Original Method ----------
        //print(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.207 -0400", hash_original_method = "9B0E5210436ABAF1CDC241F3CE945D0E", hash_generated_method = "FEA266DE46543E312379D9C9963513FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(int i) {
        dsTaint.addTaint(i);
        print(String.valueOf(i));
        // ---------- Original Method ----------
        //print(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.208 -0400", hash_original_method = "ABA84580B4C740A85A05D502E7787C38", hash_generated_method = "72E12FF63C477DDE10FD4E56574E38E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(long l) {
        dsTaint.addTaint(l);
        print(String.valueOf(l));
        // ---------- Original Method ----------
        //print(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.208 -0400", hash_original_method = "56B00C0EF01C99C01A3E7CAB0AC14873", hash_generated_method = "A9AB2FA8C73AD2D33DE32AB97978F82B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(Object o) {
        dsTaint.addTaint(o.dsTaint);
        print(String.valueOf(o));
        // ---------- Original Method ----------
        //print(String.valueOf(o));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.208 -0400", hash_original_method = "EC0BC9FFC97B234EE7DA16C4D893B8BD", hash_generated_method = "2856719A109727B2D05055A46EDEB24C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void print(String str) {
        dsTaint.addTaint(str);
        {
            setError();
        } //End block
        {
            print("null");
        } //End block
        try 
        {
            {
                write(str.getBytes());
            } //End block
            {
                write(str.getBytes(encoding));
            } //End block
        } //End block
        catch (IOException e)
        {
            setError();
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //setError();
            //return;
        //}
        //if (str == null) {
            //print("null");
            //return;
        //}
        //try {
            //if (encoding == null) {
                //write(str.getBytes());
            //} else {
                //write(str.getBytes(encoding));
            //}
        //} catch (IOException e) {
            //setError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.208 -0400", hash_original_method = "D26761927DA4C2D28104AACA6719892E", hash_generated_method = "C00F9A7256866A81FCB68389755910BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(boolean b) {
        dsTaint.addTaint(b);
        print(String.valueOf(b));
        // ---------- Original Method ----------
        //print(String.valueOf(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.209 -0400", hash_original_method = "9182DD9F41FA957369047C0FC9C79FCF", hash_generated_method = "AE04CE77FFF014604388A9A7F5E28EEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println() {
        newline();
        // ---------- Original Method ----------
        //newline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.209 -0400", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "9C892FBC543F24826B8D00180AF9048D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(char[] chars) {
        dsTaint.addTaint(chars[0]);
        println(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //println(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.209 -0400", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "3A6C5DC280D96FF7C0684D155150DB1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(char c) {
        dsTaint.addTaint(c);
        println(String.valueOf(c));
        // ---------- Original Method ----------
        //println(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.209 -0400", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "F327D202DFD11CF95D0F45E8471D436B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(double d) {
        dsTaint.addTaint(d);
        println(String.valueOf(d));
        // ---------- Original Method ----------
        //println(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.209 -0400", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "DC5BB6B36D91691C8E97CE3E64016A70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(float f) {
        dsTaint.addTaint(f);
        println(String.valueOf(f));
        // ---------- Original Method ----------
        //println(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.210 -0400", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "90757B8AA542FCBC922C8F389651D5E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(int i) {
        dsTaint.addTaint(i);
        println(String.valueOf(i));
        // ---------- Original Method ----------
        //println(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.210 -0400", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "12860BB855BD16E1889526FA2BCAAF48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(long l) {
        dsTaint.addTaint(l);
        println(String.valueOf(l));
        // ---------- Original Method ----------
        //println(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.211 -0400", hash_original_method = "320F49F677524EBEDCEEC6E202E646D4", hash_generated_method = "A9CBB1591237C4E71CD2336BB7B9967F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(Object o) {
        dsTaint.addTaint(o.dsTaint);
        println(String.valueOf(o));
        // ---------- Original Method ----------
        //println(String.valueOf(o));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.211 -0400", hash_original_method = "0E73500566456C691BD3FFBE8C8D630F", hash_generated_method = "768D4E574A1D1F7F59FB08A30F22AFBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void println(String str) {
        dsTaint.addTaint(str);
        print(str);
        newline();
        // ---------- Original Method ----------
        //print(str);
        //newline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.212 -0400", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "574B48D0122E997DB9C999CD27C06395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(boolean b) {
        dsTaint.addTaint(b);
        println(String.valueOf(b));
        // ---------- Original Method ----------
        //println(String.valueOf(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.212 -0400", hash_original_method = "203605AE3CB77711209DB798B89166F2", hash_generated_method = "F8950940439079B93D22633B21205292")
    @DSModeled(DSC.SAFE)
    protected void setError() {
        ioError = true;
        // ---------- Original Method ----------
        //ioError = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.212 -0400", hash_original_method = "F607EA18611E8A10720BC492B203762D", hash_generated_method = "B7A2AADF0146045B22E18A2498839103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] buffer, int offset, int length) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            {
                setError();
            } //End block
            try 
            {
                out.write(buffer, offset, length);
                {
                    flush();
                } //End block
            } //End block
            catch (IOException e)
            {
                setError();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //synchronized (this) {
            //if (out == null) {
                //setError();
                //return;
            //}
            //try {
                //out.write(buffer, offset, length);
                //if (autoFlush) {
                    //flush();
                //}
            //} catch (IOException e) {
                //setError();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.213 -0400", hash_original_method = "18F006677191AEE023EC3E30B84DCBEE", hash_generated_method = "D13FE8C0CF47B59D3E170AD1EE23DCB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void write(int oneByte) {
        dsTaint.addTaint(oneByte);
        {
            setError();
        } //End block
        try 
        {
            out.write(oneByte);
            int b;
            b = oneByte & 0xFF;
            boolean isNewline;
            isNewline = b == 0x0A || b == 0x15;
            {
                flush();
            } //End block
        } //End block
        catch (IOException e)
        {
            setError();
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //setError();
            //return;
        //}
        //try {
            //out.write(oneByte);
            //int b = oneByte & 0xFF;
            //boolean isNewline = b == 0x0A || b == 0x15;
            //if (autoFlush && isNewline) {
                //flush();
            //}
        //} catch (IOException e) {
            //setError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.213 -0400", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "3335E3B74E999CA3803203811CADA7EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream append(char c) {
        dsTaint.addTaint(c);
        print(c);
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //print(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.213 -0400", hash_original_method = "FC28086FFC8546AD8E2DD12638EADD5B", hash_generated_method = "C7D59C410879DBEFA633BA03D741427B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream append(CharSequence charSequence) {
        dsTaint.addTaint(charSequence);
        {
            print("null");
        } //End block
        {
            print(charSequence.toString());
        } //End block
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (charSequence == null) {
            //print("null");
        //} else {
            //print(charSequence.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.214 -0400", hash_original_method = "E6E1D45C488E30FA7AAEB51CD532F3E9", hash_generated_method = "5B5D6551E3A10CAC4F7F3D30D2416AE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream append(CharSequence charSequence, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(charSequence);
        dsTaint.addTaint(end);
        {
            charSequence = "null";
        } //End block
        print(charSequence.subSequence(start, end).toString());
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (charSequence == null) {
            //charSequence = "null";
        //}
        //print(charSequence.subSequence(start, end).toString());
        //return this;
    }

    
}

