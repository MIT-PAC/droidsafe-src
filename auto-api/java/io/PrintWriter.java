package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class PrintWriter extends Writer {
    protected Writer out;
    private boolean ioError;
    private boolean autoFlush;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.224 -0400", hash_original_method = "009ECF78166A7569006BEB577877B2F6", hash_generated_method = "9335EE400B749E0D173764A2CBB0263D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(OutputStream out) {
        this(new OutputStreamWriter(out), false);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.224 -0400", hash_original_method = "A0422DBDFA7D458C1211AD61A93CCD24", hash_generated_method = "E07B4DBA822F084EDF0E9AE052F3E8B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(OutputStream out, boolean autoFlush) {
        this(new OutputStreamWriter(out), autoFlush);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.224 -0400", hash_original_method = "7F68156580476879DAEA9DC9BCB75B06", hash_generated_method = "5DEB5DE0CC19C55DA7C9F129750FB251")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(Writer wr) {
        this(wr, false);
        dsTaint.addTaint(wr.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.224 -0400", hash_original_method = "C1927249B88242DCE6CFA0FA4F3C29B3", hash_generated_method = "704588A45F55A6BA621A28A457472DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(Writer wr, boolean autoFlush) {
        super(wr);
        dsTaint.addTaint(autoFlush);
        dsTaint.addTaint(wr.dsTaint);
        // ---------- Original Method ----------
        //this.autoFlush = autoFlush;
        //out = wr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.224 -0400", hash_original_method = "2C96C347B82CB5135A3ACEC685E09DC1", hash_generated_method = "9E1BE85F94345EC0B34D85C27B336663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(File file) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file))), false);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.224 -0400", hash_original_method = "B162E67684B075ABE078C3780599A018", hash_generated_method = "F4BEB09E02B8EFA093316E30ABC9FD65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)), csn),
                false);
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.224 -0400", hash_original_method = "BB4A7F43BD82DE5EABC7964AA01AA735", hash_generated_method = "F20209E12BB67B58DB216FF4750380EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(String fileName) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName))),
                false);
        dsTaint.addTaint(fileName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.225 -0400", hash_original_method = "75ACA8D301D7B4385F5F1D6D811FAD95", hash_generated_method = "7AFEFD8A2E2777A94F65AEA3A66EF08A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName)), csn),
                false);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(csn);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.225 -0400", hash_original_method = "0D2606A00F6397A8DDF12D981BAB88CA", hash_generated_method = "F2DA197BFF6C3CF991A2DABB356709AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean checkError() {
        Writer delegate;
        delegate = out;
        flush();
        boolean var1828C5393F7AF357FCA50D6B6EE1E98D_409586651 = (ioError || delegate.checkError());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Writer delegate = out;
        //if (delegate == null) {
            //return ioError;
        //}
        //flush();
        //return ioError || delegate.checkError();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.225 -0400", hash_original_method = "9EE080B9329CC6FAACC493ECC7141CFB", hash_generated_method = "0FB396FA9B1359C29CF99D8928A9F51A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.225 -0400", hash_original_method = "914ABB48E88E0FB5E2AF825917F549B2", hash_generated_method = "EB4BA8E31D443EA85687457D0AC185FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.225 -0400", hash_original_method = "3747E1B1C7FB1936BAC6943C89A67163", hash_generated_method = "A6EA88BD7A269402EE536B58D01426FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.226 -0400", hash_original_method = "68BF859C2EE72E22FD2B6E3C884D672F", hash_generated_method = "1F513C992E3E9328A287D69DB16DDA5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter format(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        PrintWriter varD8F2A1654CF3ACCC2BDB72B521CFFC4B_2056720790 = (format(Locale.getDefault(), format, args));
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.226 -0400", hash_original_method = "D5634586266B3A8B702A8EF418739481", hash_generated_method = "1DAC6BF06A8C2B29D4D44531BFEE998B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter format(Locale l, String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("format == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.226 -0400", hash_original_method = "D4B734B1529E4ABCC31A727EC1C73F87", hash_generated_method = "B2B173D303A9E179356D17AE501FCA6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter printf(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        PrintWriter var332B80BC927C6FFEEC76D8998999F86B_1577536604 = (format(format, args));
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.226 -0400", hash_original_method = "31E00ED7FA07EDC8A599E35C64000277", hash_generated_method = "3DACF4D0ADF58EFAA6682FDD6089717C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PrintWriter printf(Locale l, String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        PrintWriter var2451FE83B7001C97A9C60A0560E8EC1F_1120651605 = (format(l, format, args));
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.226 -0400", hash_original_method = "9BEBBB6A7E36A898084CFD13E6678C15", hash_generated_method = "AAA1D7FA693524967DA38413E4EE6CE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(char[] charArray) {
        dsTaint.addTaint(charArray[0]);
        print(new String(charArray, 0, charArray.length));
        // ---------- Original Method ----------
        //print(new String(charArray, 0, charArray.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.226 -0400", hash_original_method = "F35E4DD8AE097731F5674B94681A91A4", hash_generated_method = "5B53C724AEBFAFABDE9226C8933BC0F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(char ch) {
        dsTaint.addTaint(ch);
        print(String.valueOf(ch));
        // ---------- Original Method ----------
        //print(String.valueOf(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.227 -0400", hash_original_method = "1B10CD3CDAEEB6B80C16851B9025C53B", hash_generated_method = "193E5BFD539278657A8DBF34E41262B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(double dnum) {
        dsTaint.addTaint(dnum);
        print(String.valueOf(dnum));
        // ---------- Original Method ----------
        //print(String.valueOf(dnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.227 -0400", hash_original_method = "1CE43F20E63C9B7E63DE59186E96F9C3", hash_generated_method = "F522E92C587247617A44C3B921A474ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(float fnum) {
        dsTaint.addTaint(fnum);
        print(String.valueOf(fnum));
        // ---------- Original Method ----------
        //print(String.valueOf(fnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.227 -0400", hash_original_method = "7E641CDBDB4194A4ABD6D1C9C473BCDE", hash_generated_method = "3327CF04222277C79ED4196F58CF5C49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(int inum) {
        dsTaint.addTaint(inum);
        print(String.valueOf(inum));
        // ---------- Original Method ----------
        //print(String.valueOf(inum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.227 -0400", hash_original_method = "A3B835CD89D15A13CD365E547F38E002", hash_generated_method = "AD6049EB8F7529CB525A781547D4333F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(long lnum) {
        dsTaint.addTaint(lnum);
        print(String.valueOf(lnum));
        // ---------- Original Method ----------
        //print(String.valueOf(lnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.227 -0400", hash_original_method = "649E6082D773CF70C752E5716C5CC7C1", hash_generated_method = "B8E63A121299213F03CA0C237461FB67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        print(String.valueOf(obj));
        // ---------- Original Method ----------
        //print(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.227 -0400", hash_original_method = "28AE2923CB2E212C4A1D24DC5B3A947D", hash_generated_method = "14C8ED3B1209C22CF80339C6435E3859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(String str) {
        dsTaint.addTaint(str);
        write(str != null ? str : String.valueOf((Object) null));
        // ---------- Original Method ----------
        //write(str != null ? str : String.valueOf((Object) null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.227 -0400", hash_original_method = "55BF6AEFB35D15A1E34ADB671F9CB185", hash_generated_method = "F08404EDC3F27171EA568D1EDD133621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void print(boolean bool) {
        dsTaint.addTaint(bool);
        print(String.valueOf(bool));
        // ---------- Original Method ----------
        //print(String.valueOf(bool));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.228 -0400", hash_original_method = "F64EE4A89E44550272E2ED021897135C", hash_generated_method = "756F7D66597A8B251CC021C068E8DDCF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.228 -0400", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "9C892FBC543F24826B8D00180AF9048D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(char[] chars) {
        dsTaint.addTaint(chars[0]);
        println(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //println(new String(chars, 0, chars.length));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.228 -0400", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "3A6C5DC280D96FF7C0684D155150DB1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(char c) {
        dsTaint.addTaint(c);
        println(String.valueOf(c));
        // ---------- Original Method ----------
        //println(String.valueOf(c));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.228 -0400", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "F327D202DFD11CF95D0F45E8471D436B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(double d) {
        dsTaint.addTaint(d);
        println(String.valueOf(d));
        // ---------- Original Method ----------
        //println(String.valueOf(d));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.228 -0400", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "DC5BB6B36D91691C8E97CE3E64016A70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(float f) {
        dsTaint.addTaint(f);
        println(String.valueOf(f));
        // ---------- Original Method ----------
        //println(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.228 -0400", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "90757B8AA542FCBC922C8F389651D5E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(int i) {
        dsTaint.addTaint(i);
        println(String.valueOf(i));
        // ---------- Original Method ----------
        //println(String.valueOf(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.228 -0400", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "12860BB855BD16E1889526FA2BCAAF48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(long l) {
        dsTaint.addTaint(l);
        println(String.valueOf(l));
        // ---------- Original Method ----------
        //println(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.229 -0400", hash_original_method = "1CC054989EBE4FE044F6C09E43625828", hash_generated_method = "7E191FBC9727071B1BFB26D0F8A75958")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        println(String.valueOf(obj));
        // ---------- Original Method ----------
        //println(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.229 -0400", hash_original_method = "78EB2001D4D66C9EDDEA85708AB1EA5C", hash_generated_method = "11D2496D43E2BDC78A96818530CB63D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.229 -0400", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "574B48D0122E997DB9C999CD27C06395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(boolean b) {
        dsTaint.addTaint(b);
        println(String.valueOf(b));
        // ---------- Original Method ----------
        //println(String.valueOf(b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.229 -0400", hash_original_method = "03F201CD8682A0C64485926BB6B35745", hash_generated_method = "2A2E0A41F670A08AE912C405A23E19BA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.229 -0400", hash_original_method = "A3159CA9C79B3AD467B0FCF29995C9CC", hash_generated_method = "60E617E157EB466A7C41509EBE5CA877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(char[] buf) {
        dsTaint.addTaint(buf[0]);
        write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //write(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.229 -0400", hash_original_method = "F47BE159FF15FE26B09EE65FDEAB6B8C", hash_generated_method = "E745E096097973CEB7010E072F7127A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(char[] buf, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        doWrite(buf, offset, count);
        // ---------- Original Method ----------
        //doWrite(buf, offset, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.229 -0400", hash_original_method = "28E681395D573BD9F19024ECEBC35F4A", hash_generated_method = "3333ACF17E886A0865780CD8270DE8D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(int oneChar) {
        dsTaint.addTaint(oneChar);
        doWrite(new char[] { (char) oneChar }, 0, 1);
        // ---------- Original Method ----------
        //doWrite(new char[] { (char) oneChar }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.230 -0400", hash_original_method = "A7437F4A37204482B8F05D868AC831D8", hash_generated_method = "D633D43B89BB9C819060B075A22D5C5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void doWrite(char[] buf, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.230 -0400", hash_original_method = "CF32CDDE2940A658D82FD10746BC6D29", hash_generated_method = "A796A4B8CFC5AEF3F4ED22D10D1692A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str) {
        dsTaint.addTaint(str);
        write(str.toCharArray());
        // ---------- Original Method ----------
        //write(str.toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.230 -0400", hash_original_method = "63C99944EF00B97313C46973AD4FFC8C", hash_generated_method = "A109471633B96E8DD031870B803CFE44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(str);
        dsTaint.addTaint(offset);
        write(str.substring(offset, offset + count).toCharArray());
        // ---------- Original Method ----------
        //write(str.substring(offset, offset + count).toCharArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.230 -0400", hash_original_method = "4FD83DFE8717316B104D560444A12EF3", hash_generated_method = "9BA9340B98113DC78E7A1CD52C4A2FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PrintWriter append(char c) {
        dsTaint.addTaint(c);
        write(c);
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.230 -0400", hash_original_method = "EC867D10B212AD9763F84A42EB42848B", hash_generated_method = "945402D58D4448DD74C7AB06B0677043")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.231 -0400", hash_original_method = "3313C31A52AD9501A690D6955A7EC57D", hash_generated_method = "F2603DEAA4BA7C1F6D9AD84E62630660")
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

