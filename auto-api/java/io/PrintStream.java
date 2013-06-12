package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "DA75705BB6C20C2B5C6B266426BAE0E0", hash_generated_method = "AB6066D56F2E951618470CB5CB0A7191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(OutputStream out) {
        super(out);
        dsTaint.addTaint(out.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "4DF55F7DB2EC2DB5AB84BECA03073608", hash_generated_method = "63E4D51A9BA7919FFD1FC6BFF497E8FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(OutputStream out, boolean autoFlush) {
        super(out);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(out.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new NullPointerException();
        //}
        //this.autoFlush = autoFlush;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "88526CF0A98EC9AB97C7088D88161C3A", hash_generated_method = "009E2FCC37FAADDF2A601539C9F9D443")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(OutputStream out, boolean autoFlush, String enc) throws UnsupportedEncodingException {
        super(out);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(out.dsTaint);
        dsTaint.addTaint(enc);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        try 
        {
            {
                boolean var1619D1065190E523D5CEB80A273EC718_1735836820 = (!Charset.isSupported(enc));
                if(DroidSafeAndroidRuntime.control) {
                    throw new UnsupportedEncodingException(enc);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IllegalCharsetNameException e)
        {
            throw new UnsupportedEncodingException(enc);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "029BA830A503765157243541D9849231", hash_generated_method = "A0698BBDA212481B4E27AD2F6DFB7ED2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(File file) throws FileNotFoundException {
        super(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "7BD29578480474358E31B9B912D3F437", hash_generated_method = "A7D5B7ED3ECB24D7F5C19534B924A9C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        super(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(csn);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        {
            boolean var74A236C162A967F1ECD5EFC7D6467A04_1873561063 = (!Charset.isSupported(csn));
            if(DroidSafeAndroidRuntime.control) {
                throw new UnsupportedEncodingException(csn);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "75348CDEFC68D9839C10010605892932", hash_generated_method = "55F0D009FBB9AFAAFA7A7BD035F5E3D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        dsTaint.addTaint(fileName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "8131D7469DBCAB446E9D65623F4F3558", hash_generated_method = "EFD2551B5281D07868CB42725537FEF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "DD851A8041FFB3055294FF15D1DC9C59", hash_generated_method = "0B11F86C6DB2DBCF14C9CE2175C92081")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean checkError() {
        OutputStream delegate;
        delegate = out;
        flush();
        boolean var1828C5393F7AF357FCA50D6B6EE1E98D_1598929895 = (ioError || delegate.checkError());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //OutputStream delegate = out;
        //if (delegate == null) {
            //return ioError;
        //}
        //flush();
        //return ioError || delegate.checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "785F4CCF429F72C42E20A1AABCB6C5CE", hash_generated_method = "29ADE1EBB541916272C7A4B7A78A5015")
    @DSModeled(DSC.SAFE)
    protected void clearError() {
        ioError = false;
        // ---------- Original Method ----------
        //ioError = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "43C4845D6E61D29AF25E893F4FEF10C8", hash_generated_method = "5E2C234C3DEB489F241C3D076A14D86C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "02B2E054E74BF295FB5EB637205E6B35", hash_generated_method = "1335EEBB7FD7A052CD45019ECA640F5F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "4C0E41AEFAEDE5A1DE01BFE6F3035A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream format(String format, Object... args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(format);
        PrintStream varD8F2A1654CF3ACCC2BDB72B521CFFC4B_1653345004 = (format(Locale.getDefault(), format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.655 -0400", hash_original_method = "A0786364FBC116E551740BAAD4532E24", hash_generated_method = "28CB37B1E97B086834A5BC5F996C4054")
    @DSModeled(DSC.SAFE)
    public PrintStream format(Locale l, String format, Object... args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException("format == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "DBE300366D9A509D47712B4B771DD88B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream printf(String format, Object... args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(format);
        PrintStream var332B80BC927C6FFEEC76D8998999F86B_593620557 = (format(format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "D1007D2B1FB89999B7A20982FC00B5A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintStream printf(Locale l, String format, Object... args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        PrintStream var2451FE83B7001C97A9C60A0560E8EC1F_1171272312 = (format(l, format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "171496FE667133D572716C296277B927", hash_generated_method = "7C92933E23B45C9E9321614C5E78ACC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void newline() {
        print(System.lineSeparator());
        // ---------- Original Method ----------
        //print(System.lineSeparator());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "4DD9E13DA9D3ED57FA18E838A052301E", hash_generated_method = "FA8C7FD7CB16E948D0805FCEE88DC865")
    @DSModeled(DSC.SAFE)
    public void print(char[] chars) {
        dsTaint.addTaint(chars);
        print(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //print(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "C9EF4F31D0CD27922D7B220DA437A7D8", hash_generated_method = "C4E498C40EAB31FD92D2956B0A50A618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(char c) {
        dsTaint.addTaint(c);
        print(String.valueOf(c));
        // ---------- Original Method ----------
        //print(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "7C6D053B4D54D80C9838D841006F1F5C", hash_generated_method = "6340FBE3971BF988C2F918CA6565B6CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(double d) {
        dsTaint.addTaint(d);
        print(String.valueOf(d));
        // ---------- Original Method ----------
        //print(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "A190B4C4751A586A57985573C64F773B", hash_generated_method = "A098C4ED3D39AEB945C1857DEA9A6867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(float f) {
        dsTaint.addTaint(f);
        print(String.valueOf(f));
        // ---------- Original Method ----------
        //print(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "9B0E5210436ABAF1CDC241F3CE945D0E", hash_generated_method = "2B60B18E90BC7281059E303F573ABE57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(int i) {
        dsTaint.addTaint(i);
        print(String.valueOf(i));
        // ---------- Original Method ----------
        //print(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "ABA84580B4C740A85A05D502E7787C38", hash_generated_method = "1CAD6A84BE2B52DA56B96DD13A78C64A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(long l) {
        dsTaint.addTaint(l);
        print(String.valueOf(l));
        // ---------- Original Method ----------
        //print(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "56B00C0EF01C99C01A3E7CAB0AC14873", hash_generated_method = "30F93CC9A78B51DDC265E2C8C53FB483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(Object o) {
        dsTaint.addTaint(o.dsTaint);
        print(String.valueOf(o));
        // ---------- Original Method ----------
        //print(String.valueOf(o));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "EC0BC9FFC97B234EE7DA16C4D893B8BD", hash_generated_method = "1C35C56375BD6BADFF89818A765BA576")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "D26761927DA4C2D28104AACA6719892E", hash_generated_method = "2A04358684A0D3EA6312A55F02330096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(boolean b) {
        dsTaint.addTaint(b);
        print(String.valueOf(b));
        // ---------- Original Method ----------
        //print(String.valueOf(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "9182DD9F41FA957369047C0FC9C79FCF", hash_generated_method = "A9BBBED5486837BD341675E2D04C34E7")
    @DSModeled(DSC.SAFE)
    public void println() {
        newline();
        // ---------- Original Method ----------
        //newline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "C8C77177669095C0F059E09BE1E5EA29")
    @DSModeled(DSC.SAFE)
    public void println(char[] chars) {
        dsTaint.addTaint(chars);
        println(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //println(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "6BB00F7D4545ED5BE9F7D1CAAB2A253B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(char c) {
        dsTaint.addTaint(c);
        println(String.valueOf(c));
        // ---------- Original Method ----------
        //println(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "5E9413D0CA35917C6285D38A258A7754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(double d) {
        dsTaint.addTaint(d);
        println(String.valueOf(d));
        // ---------- Original Method ----------
        //println(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "B2938AFE1B036263C8D105B7996C2937")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(float f) {
        dsTaint.addTaint(f);
        println(String.valueOf(f));
        // ---------- Original Method ----------
        //println(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "FD5923EF14B202B2D7267FEA825202CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(int i) {
        dsTaint.addTaint(i);
        println(String.valueOf(i));
        // ---------- Original Method ----------
        //println(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "081851FA16F728B43506981E4542923C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(long l) {
        dsTaint.addTaint(l);
        println(String.valueOf(l));
        // ---------- Original Method ----------
        //println(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.656 -0400", hash_original_method = "320F49F677524EBEDCEEC6E202E646D4", hash_generated_method = "4E491CF0CBB06E66E5B302D776734708")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(Object o) {
        dsTaint.addTaint(o.dsTaint);
        println(String.valueOf(o));
        // ---------- Original Method ----------
        //println(String.valueOf(o));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "0E73500566456C691BD3FFBE8C8D630F", hash_generated_method = "FBABD5B0D1AAE1BE6A010AF7C8A83967")
    @DSModeled(DSC.SAFE)
    public synchronized void println(String str) {
        dsTaint.addTaint(str);
        print(str);
        newline();
        // ---------- Original Method ----------
        //print(str);
        //newline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "D1EECBC180331F35E44B8AD48F2BE37F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(boolean b) {
        dsTaint.addTaint(b);
        println(String.valueOf(b));
        // ---------- Original Method ----------
        //println(String.valueOf(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "203605AE3CB77711209DB798B89166F2", hash_generated_method = "F594F78FAF6CE475A242148327C0EDCE")
    @DSModeled(DSC.SAFE)
    protected void setError() {
        ioError = true;
        // ---------- Original Method ----------
        //ioError = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "F607EA18611E8A10720BC492B203762D", hash_generated_method = "B031609521015005694E7A24A877662F")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(byte[] buffer, int offset, int length) {
        dsTaint.addTaint(buffer);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "18F006677191AEE023EC3E30B84DCBEE", hash_generated_method = "6AA723967A472FE23604428C2719CE83")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "7F5249B0BA37C4B24B89EF19FCDA7DEF")
    @DSModeled(DSC.SAFE)
    public PrintStream append(char c) {
        dsTaint.addTaint(c);
        print(c);
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //print(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "FC28086FFC8546AD8E2DD12638EADD5B", hash_generated_method = "CF7A107895280C71E90F32CE98BE4B4D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.657 -0400", hash_original_method = "E6E1D45C488E30FA7AAEB51CD532F3E9", hash_generated_method = "4123A78A854C2CA1824C89BF9DA13246")
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


