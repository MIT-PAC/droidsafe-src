package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class PrintWriter extends Writer {
    protected Writer out;
    private boolean ioError;
    private boolean autoFlush;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "009ECF78166A7569006BEB577877B2F6", hash_generated_method = "C512DD38B04D24F59CC8F6BA42D5F0A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(OutputStream out) {
        this(new OutputStreamWriter(out), false);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "A0422DBDFA7D458C1211AD61A93CCD24", hash_generated_method = "35763A5464CC43119B0E5469E72AE326")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(OutputStream out, boolean autoFlush) {
        this(new OutputStreamWriter(out), autoFlush);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "7F68156580476879DAEA9DC9BCB75B06", hash_generated_method = "7FE794A68D6348433875B6DDA4E9354B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(Writer wr) {
        this(wr, false);
        dsTaint.addTaint(wr.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "C1927249B88242DCE6CFA0FA4F3C29B3", hash_generated_method = "A96E1AFC4B8FAC733B0D08666BB46846")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(Writer wr, boolean autoFlush) {
        super(wr);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(wr.dsTaint);
        // ---------- Original Method ----------
        //this.autoFlush = autoFlush;
        //out = wr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "2C96C347B82CB5135A3ACEC685E09DC1", hash_generated_method = "489F405D678109768EF5200E7A3BAF4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(File file) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file))), false);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "B162E67684B075ABE078C3780599A018", hash_generated_method = "E2DBBF18A50807E84EE0CE35BA8ACF1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)), csn),
                false);
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "BB4A7F43BD82DE5EABC7964AA01AA735", hash_generated_method = "452633ED81320B8241E1C15B7B93AD3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(String fileName) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName))),
                false);
        dsTaint.addTaint(fileName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "75ACA8D301D7B4385F5F1D6D811FAD95", hash_generated_method = "00A2717E0729E972EBCA06CF69F6FE6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName)), csn),
                false);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "0D2606A00F6397A8DDF12D981BAB88CA", hash_generated_method = "2C621CB3D300E7F303B5F259805B8E09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean checkError() {
        Writer delegate;
        delegate = out;
        flush();
        boolean var1828C5393F7AF357FCA50D6B6EE1E98D_88431957 = (ioError || delegate.checkError());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Writer delegate = out;
        //if (delegate == null) {
            //return ioError;
        //}
        //flush();
        //return ioError || delegate.checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "9EE080B9329CC6FAACC493ECC7141CFB", hash_generated_method = "79BEA9BE227502AF027425E783DA59F4")
    @DSModeled(DSC.SAFE)
    protected void clearError() {
        {
            ioError = false;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //ioError = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "914ABB48E88E0FB5E2AF825917F549B2", hash_generated_method = "E1F47A8401F77B854A559BA228A6AC54")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        {
            {
                try 
                {
                    out.close();
                } //End block
                catch (IOException e)
                {
                    setError();
                } //End block
                out = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (out != null) {
                //try {
                    //out.close();
                //} catch (IOException e) {
                    //setError();
                //}
                //out = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "3747E1B1C7FB1936BAC6943C89A67163", hash_generated_method = "EC62DA69ADE99041C2CC11513563BDE3")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() {
        {
            {
                try 
                {
                    out.flush();
                } //End block
                catch (IOException e)
                {
                    setError();
                } //End block
            } //End block
            {
                setError();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (out != null) {
                //try {
                    //out.flush();
                //} catch (IOException e) {
                    //setError();
                //}
            //} else {
                //setError();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "68BF859C2EE72E22FD2B6E3C884D672F", hash_generated_method = "769E17CF67E5EFBFF3106DE3DD51824E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter format(String format, Object... args) {
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(format);
        PrintWriter varD8F2A1654CF3ACCC2BDB72B521CFFC4B_1462060405 = (format(Locale.getDefault(), format, args));
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "D5634586266B3A8B702A8EF418739481", hash_generated_method = "9A82BAB481C4835AE3E3D613B962B72E")
    @DSModeled(DSC.SAFE)
    public PrintWriter format(Locale l, String format, Object... args) {
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        {
            throw new NullPointerException("format == null");
        } //End block
        new Formatter(this, l).format(format, args);
        {
            flush();
        } //End block
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (format == null) {
            //throw new NullPointerException("format == null");
        //}
        //new Formatter(this, l).format(format, args);
        //if (autoFlush) {
            //flush();
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.665 -0400", hash_original_method = "D4B734B1529E4ABCC31A727EC1C73F87", hash_generated_method = "876F09DD54F88BC3C440DDEAB9BC2D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter printf(String format, Object... args) {
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(format);
        PrintWriter var332B80BC927C6FFEEC76D8998999F86B_67909479 = (format(format, args));
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "31E00ED7FA07EDC8A599E35C64000277", hash_generated_method = "46A4CD43389CB4FA4F787DBA71C4FA1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter printf(Locale l, String format, Object... args) {
        dsTaint.addTaint(args.dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        PrintWriter var2451FE83B7001C97A9C60A0560E8EC1F_490766077 = (format(l, format, args));
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "9BEBBB6A7E36A898084CFD13E6678C15", hash_generated_method = "005E2F88079E52F60340F696D92C00DC")
    @DSModeled(DSC.SAFE)
    public void print(char[] charArray) {
        dsTaint.addTaint(charArray);
        print(new String(charArray, 0, charArray.length));
        // ---------- Original Method ----------
        //print(new String(charArray, 0, charArray.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "F35E4DD8AE097731F5674B94681A91A4", hash_generated_method = "85229B10CCF8740CAC5FE61567D59C9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(char ch) {
        dsTaint.addTaint(ch);
        print(String.valueOf(ch));
        // ---------- Original Method ----------
        //print(String.valueOf(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "1B10CD3CDAEEB6B80C16851B9025C53B", hash_generated_method = "1A6A0BBBE3B8F84B89E89461134DF3FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(double dnum) {
        dsTaint.addTaint(dnum);
        print(String.valueOf(dnum));
        // ---------- Original Method ----------
        //print(String.valueOf(dnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "1CE43F20E63C9B7E63DE59186E96F9C3", hash_generated_method = "9CC1446C04AA4311591E3743664FA84C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(float fnum) {
        dsTaint.addTaint(fnum);
        print(String.valueOf(fnum));
        // ---------- Original Method ----------
        //print(String.valueOf(fnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "7E641CDBDB4194A4ABD6D1C9C473BCDE", hash_generated_method = "5F4B1256B20DFAC93533685E1A205B72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(int inum) {
        dsTaint.addTaint(inum);
        print(String.valueOf(inum));
        // ---------- Original Method ----------
        //print(String.valueOf(inum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "A3B835CD89D15A13CD365E547F38E002", hash_generated_method = "D37820B22CB63D8BC6B21627CC25F6B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(long lnum) {
        dsTaint.addTaint(lnum);
        print(String.valueOf(lnum));
        // ---------- Original Method ----------
        //print(String.valueOf(lnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "649E6082D773CF70C752E5716C5CC7C1", hash_generated_method = "CC2BD93F05657A7C440C035EA67E0E57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        print(String.valueOf(obj));
        // ---------- Original Method ----------
        //print(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "28AE2923CB2E212C4A1D24DC5B3A947D", hash_generated_method = "7299755565F1C4F85BF9F13840CF7CE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(String str) {
        dsTaint.addTaint(str);
        write(str != null ? str : String.valueOf((Object) null));
        // ---------- Original Method ----------
        //write(str != null ? str : String.valueOf((Object) null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "55BF6AEFB35D15A1E34ADB671F9CB185", hash_generated_method = "B4625D3B178FE6D96C8982C9D1A55E5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(boolean bool) {
        dsTaint.addTaint(bool);
        print(String.valueOf(bool));
        // ---------- Original Method ----------
        //print(String.valueOf(bool));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "F64EE4A89E44550272E2ED021897135C", hash_generated_method = "472F30B928BB264C39025A60A39F23DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println() {
        {
            print(System.lineSeparator());
            {
                flush();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //print(System.lineSeparator());
            //if (autoFlush) {
                //flush();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "C8C77177669095C0F059E09BE1E5EA29")
    @DSModeled(DSC.SAFE)
    public void println(char[] chars) {
        dsTaint.addTaint(chars);
        println(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //println(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "6BB00F7D4545ED5BE9F7D1CAAB2A253B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(char c) {
        dsTaint.addTaint(c);
        println(String.valueOf(c));
        // ---------- Original Method ----------
        //println(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "5E9413D0CA35917C6285D38A258A7754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(double d) {
        dsTaint.addTaint(d);
        println(String.valueOf(d));
        // ---------- Original Method ----------
        //println(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "B2938AFE1B036263C8D105B7996C2937")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(float f) {
        dsTaint.addTaint(f);
        println(String.valueOf(f));
        // ---------- Original Method ----------
        //println(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "FD5923EF14B202B2D7267FEA825202CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(int i) {
        dsTaint.addTaint(i);
        println(String.valueOf(i));
        // ---------- Original Method ----------
        //println(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "081851FA16F728B43506981E4542923C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(long l) {
        dsTaint.addTaint(l);
        println(String.valueOf(l));
        // ---------- Original Method ----------
        //println(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "1CC054989EBE4FE044F6C09E43625828", hash_generated_method = "8B161AEB29874796A063A561E93742FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        println(String.valueOf(obj));
        // ---------- Original Method ----------
        //println(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "78EB2001D4D66C9EDDEA85708AB1EA5C", hash_generated_method = "A75E2AADFF1607914F52ABF2DB7C5BD9")
    @DSModeled(DSC.SAFE)
    public void println(String str) {
        dsTaint.addTaint(str);
        {
            print(str);
            println();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //print(str);
            //println();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "D1EECBC180331F35E44B8AD48F2BE37F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(boolean b) {
        dsTaint.addTaint(b);
        println(String.valueOf(b));
        // ---------- Original Method ----------
        //println(String.valueOf(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.666 -0400", hash_original_method = "03F201CD8682A0C64485926BB6B35745", hash_generated_method = "43948ACA5D6A83D13281586DF258C6DD")
    @DSModeled(DSC.SAFE)
    protected void setError() {
        {
            ioError = true;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //ioError = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "A3159CA9C79B3AD467B0FCF29995C9CC", hash_generated_method = "F15690AE19496AD9C83FCE4F7447488F")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(char[] buf) {
        dsTaint.addTaint(buf);
        write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //write(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "F47BE159FF15FE26B09EE65FDEAB6B8C", hash_generated_method = "355D1E28DA8E8224D32A6FDBF62A9105")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(char[] buf, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf);
        doWrite(buf, offset, count);
        // ---------- Original Method ----------
        //doWrite(buf, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "28E681395D573BD9F19024ECEBC35F4A", hash_generated_method = "8A58B28F5BAD157A783FF07EF08ECC74")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(int oneChar) {
        dsTaint.addTaint(oneChar);
        doWrite(new char[] { (char) oneChar }, 0, 1);
        // ---------- Original Method ----------
        //doWrite(new char[] { (char) oneChar }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "A7437F4A37204482B8F05D868AC831D8", hash_generated_method = "4D2CD654E8A5202E97DD0E65A2E62EC7")
    @DSModeled(DSC.SAFE)
    private final void doWrite(char[] buf, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf);
        {
            {
                try 
                {
                    out.write(buf, offset, count);
                } //End block
                catch (IOException e)
                {
                    setError();
                } //End block
            } //End block
            {
                setError();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (out != null) {
                //try {
                    //out.write(buf, offset, count);
                //} catch (IOException e) {
                    //setError();
                //}
            //} else {
                //setError();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "CF32CDDE2940A658D82FD10746BC6D29", hash_generated_method = "51AC9F995EFEE58ED04BD218E8534803")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str) {
        dsTaint.addTaint(str);
        write(str.toCharArray());
        // ---------- Original Method ----------
        //write(str.toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "63C99944EF00B97313C46973AD4FFC8C", hash_generated_method = "2177958CBC046A13AB4F97650C3752C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str, int offset, int count) {
        dsTaint.addTaint(str);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        write(str.substring(offset, offset + count).toCharArray());
        // ---------- Original Method ----------
        //write(str.substring(offset, offset + count).toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "4FD83DFE8717316B104D560444A12EF3", hash_generated_method = "DBD355A63FD7366F2B1CF1A2DBF9E789")
    @DSModeled(DSC.SAFE)
    @Override
    public PrintWriter append(char c) {
        dsTaint.addTaint(c);
        write(c);
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "EC867D10B212AD9763F84A42EB42848B", hash_generated_method = "9286E85CFA8C159670F42BCF18709BA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PrintWriter append(CharSequence csq) {
        dsTaint.addTaint(csq);
        {
            csq = "null";
        } //End block
        append(csq, 0, csq.length());
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //append(csq, 0, csq.length());
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.667 -0400", hash_original_method = "3313C31A52AD9501A690D6955A7EC57D", hash_generated_method = "4987F15D298092B6AFF882BD632B4727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PrintWriter append(CharSequence csq, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(csq);
        dsTaint.addTaint(end);
        {
            csq = "null";
        } //End block
        String output;
        output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}


