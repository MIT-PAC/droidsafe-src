package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class PrintStream extends FilterOutputStream implements Appendable, Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.574 -0400", hash_original_field = "4B4C3D08948825F5FE6B51A1087D503E", hash_generated_field = "C89C47EA16E34DEBAC0E78BF779BC70F")

    private boolean ioError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.574 -0400", hash_original_field = "9B67A50854B43F683C9C287FC0D8C97B", hash_generated_field = "C3BCA0E638347F15CBD7648899C5AE35")

    private boolean autoFlush;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.575 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.575 -0400", hash_original_method = "DA75705BB6C20C2B5C6B266426BAE0E0", hash_generated_method = "FC23149913BBB28366859485A184CF3F")
    public  PrintStream(OutputStream out) {
        super(out);
        addTaint(out.getTaint());
    if(out == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2113222431 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2113222431.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2113222431;
        } //End block
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new NullPointerException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.576 -0400", hash_original_method = "4DF55F7DB2EC2DB5AB84BECA03073608", hash_generated_method = "8B574CDDB72B8A0573DC4D27F7706BA2")
    public  PrintStream(OutputStream out, boolean autoFlush) {
        super(out);
        addTaint(out.getTaint());
    if(out == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_268618108 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_268618108.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_268618108;
        } //End block
        this.autoFlush = autoFlush;
        // ---------- Original Method ----------
        //if (out == null) {
            //throw new NullPointerException();
        //}
        //this.autoFlush = autoFlush;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.578 -0400", hash_original_method = "88526CF0A98EC9AB97C7088D88161C3A", hash_generated_method = "2C3941D20A86DD2C2A9035ACDA7E3A90")
    public  PrintStream(OutputStream out, boolean autoFlush, String enc) throws UnsupportedEncodingException {
        super(out);
        addTaint(out.getTaint());
    if(out == null || enc == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1203932402 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1203932402.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1203932402;
        } //End block
        this.autoFlush = autoFlush;
        try 
        {
    if(!Charset.isSupported(enc))            
            {
                UnsupportedEncodingException var397991C29CD3376A5C5B3BD1C2DA8637_747371247 = new UnsupportedEncodingException(enc);
                var397991C29CD3376A5C5B3BD1C2DA8637_747371247.addTaint(taint);
                throw var397991C29CD3376A5C5B3BD1C2DA8637_747371247;
            } //End block
        } //End block
        catch (IllegalCharsetNameException e)
        {
            UnsupportedEncodingException var397991C29CD3376A5C5B3BD1C2DA8637_660389043 = new UnsupportedEncodingException(enc);
            var397991C29CD3376A5C5B3BD1C2DA8637_660389043.addTaint(taint);
            throw var397991C29CD3376A5C5B3BD1C2DA8637_660389043;
        } //End block
        encoding = enc;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.578 -0400", hash_original_method = "029BA830A503765157243541D9849231", hash_generated_method = "D927CED89129EFEE36BBC3AACBED05D4")
    public  PrintStream(File file) throws FileNotFoundException {
        super(new FileOutputStream(file));
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.579 -0400", hash_original_method = "7BD29578480474358E31B9B912D3F437", hash_generated_method = "B96AC091E47E90854CE75BD54D9859C1")
    public  PrintStream(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        super(new FileOutputStream(file));
        addTaint(file.getTaint());
    if(csn == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1060744488 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1060744488.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1060744488;
        } //End block
    if(!Charset.isSupported(csn))        
        {
            UnsupportedEncodingException var7859B5BCA746BF527B2AFF3653AB541B_955867369 = new UnsupportedEncodingException(csn);
            var7859B5BCA746BF527B2AFF3653AB541B_955867369.addTaint(taint);
            throw var7859B5BCA746BF527B2AFF3653AB541B_955867369;
        } //End block
        encoding = csn;
        // ---------- Original Method ----------
        //if (csn == null) {
            //throw new NullPointerException();
        //}
        //if (!Charset.isSupported(csn)) {
            //throw new UnsupportedEncodingException(csn);
        //}
        //encoding = csn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.580 -0400", hash_original_method = "75348CDEFC68D9839C10010605892932", hash_generated_method = "98625306DB9C5CF87A1D339A921DAB22")
    public  PrintStream(String fileName) throws FileNotFoundException {
        this(new File(fileName));
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.581 -0400", hash_original_method = "8131D7469DBCAB446E9D65623F4F3558", hash_generated_method = "2B953438F0B45202BBB23F1DF031E134")
    public  PrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(new File(fileName), csn);
        addTaint(csn.getTaint());
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.581 -0400", hash_original_method = "DD851A8041FFB3055294FF15D1DC9C59", hash_generated_method = "DC7C4619E05377B5560605413B51D8BC")
    public boolean checkError() {
        OutputStream delegate = out;
    if(delegate == null)        
        {
            boolean var4B4C3D08948825F5FE6B51A1087D503E_194201631 = (ioError);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506971959 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506971959;
        } //End block
        flush();
        boolean var1AB2E4CBCC9F33350E940BF281B2CFD6_909559449 = (ioError || delegate.checkError());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735767554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735767554;
        // ---------- Original Method ----------
        //OutputStream delegate = out;
        //if (delegate == null) {
            //return ioError;
        //}
        //flush();
        //return ioError || delegate.checkError();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.582 -0400", hash_original_method = "785F4CCF429F72C42E20A1AABCB6C5CE", hash_generated_method = "CC852D7FE95E7B5290039A783A243D73")
    protected void clearError() {
        ioError = false;
        // ---------- Original Method ----------
        //ioError = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.583 -0400", hash_original_method = "43C4845D6E61D29AF25E893F4FEF10C8", hash_generated_method = "E2F7CC8B487840533B4E8A43E9964DDF")
    @Override
    public synchronized void close() {
        flush();
    if(out != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.583 -0400", hash_original_method = "02B2E054E74BF295FB5EB637205E6B35", hash_generated_method = "3D3C502D61EAE66EEA9600FED466DC0A")
    @Override
    public synchronized void flush() {
    if(out != null)        
        {
            try 
            {
                out.flush();
                return;
            } //End block
            catch (IOException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.584 -0400", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "14F776B1396D56B7B55DDA48C98EEF7F")
    public PrintStream format(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
PrintStream varAC550D889141827F9746A4BB1DA8EE48_1639847283 =         format(Locale.getDefault(), format, args);
        varAC550D889141827F9746A4BB1DA8EE48_1639847283.addTaint(taint);
        return varAC550D889141827F9746A4BB1DA8EE48_1639847283;
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.585 -0400", hash_original_method = "A0786364FBC116E551740BAAD4532E24", hash_generated_method = "FD0793F4F1B4139C8B68BDBB51888293")
    public PrintStream format(Locale l, String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        addTaint(l.getTaint());
    if(format == null)        
        {
            NullPointerException var3D4C345142DA17934F9E5E26254068BE_1702381648 = new NullPointerException("format == null");
            var3D4C345142DA17934F9E5E26254068BE_1702381648.addTaint(taint);
            throw var3D4C345142DA17934F9E5E26254068BE_1702381648;
        } //End block
        new Formatter(this, l).format(format, args);
PrintStream var72A74007B2BE62B849F475C7BDA4658B_291712077 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_291712077.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_291712077;
        // ---------- Original Method ----------
        //if (format == null) {
            //throw new NullPointerException("format == null");
        //}
        //new Formatter(this, l).format(format, args);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.585 -0400", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "FE9AA43F3B713F871C0F232FBD2F0932")
    public PrintStream printf(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
PrintStream var1C1A7E0ECC814A41656D8DF055D1B8DD_890029342 =         format(format, args);
        var1C1A7E0ECC814A41656D8DF055D1B8DD_890029342.addTaint(taint);
        return var1C1A7E0ECC814A41656D8DF055D1B8DD_890029342;
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.586 -0400", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "57B043FF37B65D87CB8F079137C3A34D")
    public PrintStream printf(Locale l, String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        addTaint(l.getTaint());
PrintStream varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1714829998 =         format(l, format, args);
        varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1714829998.addTaint(taint);
        return varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1714829998;
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.586 -0400", hash_original_method = "171496FE667133D572716C296277B927", hash_generated_method = "26FA29E3F019DA8274A7A58369323ED3")
    private void newline() {
        print(System.lineSeparator());
        // ---------- Original Method ----------
        //print(System.lineSeparator());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.587 -0400", hash_original_method = "4DD9E13DA9D3ED57FA18E838A052301E", hash_generated_method = "9F77EA6BC9AEED51BDDF766DCFF11974")
    public void print(char[] chars) {
        addTaint(chars[0]);
        print(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //print(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.587 -0400", hash_original_method = "C9EF4F31D0CD27922D7B220DA437A7D8", hash_generated_method = "239FD5874D1F7E1E4213A8D7A7A62DF9")
    public void print(char c) {
        addTaint(c);
        print(String.valueOf(c));
        // ---------- Original Method ----------
        //print(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.588 -0400", hash_original_method = "7C6D053B4D54D80C9838D841006F1F5C", hash_generated_method = "555E4F6DED06789DC7191C91EC8137B6")
    public void print(double d) {
        addTaint(d);
        print(String.valueOf(d));
        // ---------- Original Method ----------
        //print(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.589 -0400", hash_original_method = "A190B4C4751A586A57985573C64F773B", hash_generated_method = "4B7B4838B93CAF6BB6073C0CA00B58E5")
    public void print(float f) {
        addTaint(f);
        print(String.valueOf(f));
        // ---------- Original Method ----------
        //print(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.589 -0400", hash_original_method = "9B0E5210436ABAF1CDC241F3CE945D0E", hash_generated_method = "E0499D48C26A4324BD98FD5D3294C522")
    public void print(int i) {
        addTaint(i);
        print(String.valueOf(i));
        // ---------- Original Method ----------
        //print(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.589 -0400", hash_original_method = "ABA84580B4C740A85A05D502E7787C38", hash_generated_method = "6FF2663BE6E1DB6409980517E4A5B3AA")
    public void print(long l) {
        addTaint(l);
        print(String.valueOf(l));
        // ---------- Original Method ----------
        //print(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.590 -0400", hash_original_method = "56B00C0EF01C99C01A3E7CAB0AC14873", hash_generated_method = "FA2DC51DC0CECC117748AAAC1BC5D8FF")
    public void print(Object o) {
        addTaint(o.getTaint());
        print(String.valueOf(o));
        // ---------- Original Method ----------
        //print(String.valueOf(o));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.591 -0400", hash_original_method = "EC0BC9FFC97B234EE7DA16C4D893B8BD", hash_generated_method = "C6E1AB81C2AD5C7E6C902ABECE000227")
    public synchronized void print(String str) {
        addTaint(str.getTaint());
    if(out == null)        
        {
            setError();
            return;
        } //End block
    if(str == null)        
        {
            print("null");
            return;
        } //End block
        try 
        {
    if(encoding == null)            
            {
                write(str.getBytes());
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.591 -0400", hash_original_method = "D26761927DA4C2D28104AACA6719892E", hash_generated_method = "03271D994C176003454726F03FC974BE")
    public void print(boolean b) {
        addTaint(b);
        print(String.valueOf(b));
        // ---------- Original Method ----------
        //print(String.valueOf(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.592 -0400", hash_original_method = "9182DD9F41FA957369047C0FC9C79FCF", hash_generated_method = "AE04CE77FFF014604388A9A7F5E28EEF")
    public void println() {
        newline();
        // ---------- Original Method ----------
        //newline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.592 -0400", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "5D13023447190678839A52E6EC0FD6E6")
    public void println(char[] chars) {
        addTaint(chars[0]);
        println(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //println(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.593 -0400", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "5B54C4A804342FB66DA39CD1A802F010")
    public void println(char c) {
        addTaint(c);
        println(String.valueOf(c));
        // ---------- Original Method ----------
        //println(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.593 -0400", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "3DD05D2B8A6F7FA399C6E8CD1479DBC2")
    public void println(double d) {
        addTaint(d);
        println(String.valueOf(d));
        // ---------- Original Method ----------
        //println(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.594 -0400", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "520DE5B296981CB84314D5F031E424FD")
    public void println(float f) {
        addTaint(f);
        println(String.valueOf(f));
        // ---------- Original Method ----------
        //println(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.594 -0400", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "2AF3FEFBD9F0D1A853D2AE3CC075FDE9")
    public void println(int i) {
        addTaint(i);
        println(String.valueOf(i));
        // ---------- Original Method ----------
        //println(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.595 -0400", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "D0CEAADD771279275CD5802BDD412D24")
    public void println(long l) {
        addTaint(l);
        println(String.valueOf(l));
        // ---------- Original Method ----------
        //println(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.595 -0400", hash_original_method = "320F49F677524EBEDCEEC6E202E646D4", hash_generated_method = "4DD07632C48EAE0E82D346837F8CC7F3")
    public void println(Object o) {
        addTaint(o.getTaint());
        println(String.valueOf(o));
        // ---------- Original Method ----------
        //println(String.valueOf(o));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.596 -0400", hash_original_method = "0E73500566456C691BD3FFBE8C8D630F", hash_generated_method = "95F2008FB2611F79E53BE2C405EDF08F")
    public synchronized void println(String str) {
        addTaint(str.getTaint());
        print(str);
        newline();
        // ---------- Original Method ----------
        //print(str);
        //newline();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.596 -0400", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "F50EDCD63B561F206F067626B5527EA3")
    public void println(boolean b) {
        addTaint(b);
        println(String.valueOf(b));
        // ---------- Original Method ----------
        //println(String.valueOf(b));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.597 -0400", hash_original_method = "203605AE3CB77711209DB798B89166F2", hash_generated_method = "F8950940439079B93D22633B21205292")
    protected void setError() {
        ioError = true;
        // ---------- Original Method ----------
        //ioError = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.597 -0400", hash_original_method = "F607EA18611E8A10720BC492B203762D", hash_generated_method = "A4550291CE5D3C3EB60289B80344327B")
    @Override
    public void write(byte[] buffer, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        synchronized
(this)        {
    if(out == null)            
            {
                setError();
                return;
            } //End block
            try 
            {
                out.write(buffer, offset, length);
    if(autoFlush)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.598 -0400", hash_original_method = "18F006677191AEE023EC3E30B84DCBEE", hash_generated_method = "EA0C00599F74485B07C047DC6C2112C3")
    @Override
    public synchronized void write(int oneByte) {
        addTaint(oneByte);
    if(out == null)        
        {
            setError();
            return;
        } //End block
        try 
        {
            out.write(oneByte);
            int b = oneByte & 0xFF;
            boolean isNewline = b == 0x0A || b == 0x15;
    if(autoFlush && isNewline)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.599 -0400", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "8242EC91D873E8344EB929A016EE2E12")
    public PrintStream append(char c) {
        addTaint(c);
        print(c);
PrintStream var72A74007B2BE62B849F475C7BDA4658B_2032469817 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2032469817.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2032469817;
        // ---------- Original Method ----------
        //print(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.600 -0400", hash_original_method = "FC28086FFC8546AD8E2DD12638EADD5B", hash_generated_method = "7457093A4371D1C9D113EEE9CB567486")
    public PrintStream append(CharSequence charSequence) {
        addTaint(charSequence.getTaint());
    if(charSequence == null)        
        {
            print("null");
        } //End block
        else
        {
            print(charSequence.toString());
        } //End block
PrintStream var72A74007B2BE62B849F475C7BDA4658B_1593595578 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1593595578.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1593595578;
        // ---------- Original Method ----------
        //if (charSequence == null) {
            //print("null");
        //} else {
            //print(charSequence.toString());
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.600 -0400", hash_original_method = "E6E1D45C488E30FA7AAEB51CD532F3E9", hash_generated_method = "0F0D82B63452B362AD6CF70A19EFDF7B")
    public PrintStream append(CharSequence charSequence, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(charSequence.getTaint());
    if(charSequence == null)        
        {
            charSequence = "null";
        } //End block
        print(charSequence.subSequence(start, end).toString());
PrintStream var72A74007B2BE62B849F475C7BDA4658B_464033899 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_464033899.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_464033899;
        // ---------- Original Method ----------
        //if (charSequence == null) {
            //charSequence = "null";
        //}
        //print(charSequence.subSequence(start, end).toString());
        //return this;
    }

    
}

