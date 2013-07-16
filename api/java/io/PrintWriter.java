package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class PrintWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.690 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "8FF81F1EABE94AA2FE1148793CBBDC2D")

    protected Writer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.690 -0400", hash_original_field = "4B4C3D08948825F5FE6B51A1087D503E", hash_generated_field = "C89C47EA16E34DEBAC0E78BF779BC70F")

    private boolean ioError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.690 -0400", hash_original_field = "9B67A50854B43F683C9C287FC0D8C97B", hash_generated_field = "C3BCA0E638347F15CBD7648899C5AE35")

    private boolean autoFlush;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.690 -0400", hash_original_method = "009ECF78166A7569006BEB577877B2F6", hash_generated_method = "05AE4D4E6FBDCE7DFE3FD0B82EBAE392")
    public  PrintWriter(OutputStream out) {
        this(new OutputStreamWriter(out), false);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.691 -0400", hash_original_method = "A0422DBDFA7D458C1211AD61A93CCD24", hash_generated_method = "0DBD8D5D52D6E0F06AC9665BF6EBD740")
    public  PrintWriter(OutputStream out, boolean autoFlush) {
        this(new OutputStreamWriter(out), autoFlush);
        addTaint(autoFlush);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.691 -0400", hash_original_method = "7F68156580476879DAEA9DC9BCB75B06", hash_generated_method = "C6FFE76650824927030A4AE92F8987D0")
    public  PrintWriter(Writer wr) {
        this(wr, false);
        addTaint(wr.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.692 -0400", hash_original_method = "C1927249B88242DCE6CFA0FA4F3C29B3", hash_generated_method = "F14F2A3F33B8FBF372DAB923D7D74C2F")
    public  PrintWriter(Writer wr, boolean autoFlush) {
        super(wr);
        this.autoFlush = autoFlush;
        out = wr;
        // ---------- Original Method ----------
        //this.autoFlush = autoFlush;
        //out = wr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.694 -0400", hash_original_method = "2C96C347B82CB5135A3ACEC685E09DC1", hash_generated_method = "91AF885BEB09C1CB8435A480DE8FAF91")
    public  PrintWriter(File file) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file))), false);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.694 -0400", hash_original_method = "B162E67684B075ABE078C3780599A018", hash_generated_method = "5F45F9440501EB5A531F5F29804A1C50")
    public  PrintWriter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)), csn),
                false);
        addTaint(csn.getTaint());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.695 -0400", hash_original_method = "BB4A7F43BD82DE5EABC7964AA01AA735", hash_generated_method = "0B4C3D5928920263AB6771C0EE855742")
    public  PrintWriter(String fileName) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName))),
                false);
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.695 -0400", hash_original_method = "75ACA8D301D7B4385F5F1D6D811FAD95", hash_generated_method = "4B84B31D73CBF1A37794AB1B2BB92F66")
    public  PrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName)), csn),
                false);
        addTaint(csn.getTaint());
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.696 -0400", hash_original_method = "0D2606A00F6397A8DDF12D981BAB88CA", hash_generated_method = "D7350052596E6929096E2F1344DCD0C0")
    public boolean checkError() {
        Writer delegate = out;
    if(delegate == null)        
        {
            boolean var4B4C3D08948825F5FE6B51A1087D503E_509594511 = (ioError);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515609933 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515609933;
        } //End block
        flush();
        boolean var1AB2E4CBCC9F33350E940BF281B2CFD6_58464121 = (ioError || delegate.checkError());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833729033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_833729033;
        // ---------- Original Method ----------
        //Writer delegate = out;
        //if (delegate == null) {
            //return ioError;
        //}
        //flush();
        //return ioError || delegate.checkError();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.696 -0400", hash_original_method = "9EE080B9329CC6FAACC493ECC7141CFB", hash_generated_method = "142ACE148ABAB14D975495F03D509B72")
    protected void clearError() {
        synchronized
(lock)        {
            ioError = false;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //ioError = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.697 -0400", hash_original_method = "914ABB48E88E0FB5E2AF825917F549B2", hash_generated_method = "3A6BC395F5583C68D84F0A4F52ECD770")
    @Override
    public void close() {
        synchronized
(lock)        {
    if(out != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.698 -0400", hash_original_method = "3747E1B1C7FB1936BAC6943C89A67163", hash_generated_method = "8C3F08D2CC22D5B937A4AA00C111DFAC")
    @Override
    public void flush() {
        synchronized
(lock)        {
    if(out != null)            
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
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.699 -0400", hash_original_method = "68BF859C2EE72E22FD2B6E3C884D672F", hash_generated_method = "0ADB4493C3E2729AF5DB64CD558A337E")
    public PrintWriter format(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
PrintWriter varAC550D889141827F9746A4BB1DA8EE48_661550189 =         format(Locale.getDefault(), format, args);
        varAC550D889141827F9746A4BB1DA8EE48_661550189.addTaint(taint);
        return varAC550D889141827F9746A4BB1DA8EE48_661550189;
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.700 -0400", hash_original_method = "D5634586266B3A8B702A8EF418739481", hash_generated_method = "52AC6D0EDA2DE58DAFC98A0C4AC81E20")
    public PrintWriter format(Locale l, String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        addTaint(l.getTaint());
    if(format == null)        
        {
            NullPointerException var3D4C345142DA17934F9E5E26254068BE_1607784489 = new NullPointerException("format == null");
            var3D4C345142DA17934F9E5E26254068BE_1607784489.addTaint(taint);
            throw var3D4C345142DA17934F9E5E26254068BE_1607784489;
        } //End block
        new Formatter(this, l).format(format, args);
    if(autoFlush)        
        {
            flush();
        } //End block
PrintWriter var72A74007B2BE62B849F475C7BDA4658B_2068351061 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2068351061.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2068351061;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.701 -0400", hash_original_method = "D4B734B1529E4ABCC31A727EC1C73F87", hash_generated_method = "A48ED3CB4CFD28DD86C9967C5A7401C5")
    public PrintWriter printf(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
PrintWriter var1C1A7E0ECC814A41656D8DF055D1B8DD_146151118 =         format(format, args);
        var1C1A7E0ECC814A41656D8DF055D1B8DD_146151118.addTaint(taint);
        return var1C1A7E0ECC814A41656D8DF055D1B8DD_146151118;
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.702 -0400", hash_original_method = "31E00ED7FA07EDC8A599E35C64000277", hash_generated_method = "060914ECF37A7A266C2034F9D8F1417F")
    public PrintWriter printf(Locale l, String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        addTaint(l.getTaint());
PrintWriter varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1958878469 =         format(l, format, args);
        varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1958878469.addTaint(taint);
        return varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1958878469;
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.702 -0400", hash_original_method = "9BEBBB6A7E36A898084CFD13E6678C15", hash_generated_method = "3486C37664FA541B5040893E2C1275CE")
    public void print(char[] charArray) {
        addTaint(charArray[0]);
        print(new String(charArray, 0, charArray.length));
        // ---------- Original Method ----------
        //print(new String(charArray, 0, charArray.length));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.703 -0400", hash_original_method = "F35E4DD8AE097731F5674B94681A91A4", hash_generated_method = "045C30FA2D98CA82AC0ADDCDA34B6B51")
    public void print(char ch) {
        addTaint(ch);
        print(String.valueOf(ch));
        // ---------- Original Method ----------
        //print(String.valueOf(ch));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.704 -0400", hash_original_method = "1B10CD3CDAEEB6B80C16851B9025C53B", hash_generated_method = "12E80EBA3820F680F987E0B6D479BF62")
    public void print(double dnum) {
        addTaint(dnum);
        print(String.valueOf(dnum));
        // ---------- Original Method ----------
        //print(String.valueOf(dnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.704 -0400", hash_original_method = "1CE43F20E63C9B7E63DE59186E96F9C3", hash_generated_method = "02E18306D5B567A2084BFFC0A5364E7D")
    public void print(float fnum) {
        addTaint(fnum);
        print(String.valueOf(fnum));
        // ---------- Original Method ----------
        //print(String.valueOf(fnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.705 -0400", hash_original_method = "7E641CDBDB4194A4ABD6D1C9C473BCDE", hash_generated_method = "72C5D7D36660318C7E669F743B82FA10")
    public void print(int inum) {
        addTaint(inum);
        print(String.valueOf(inum));
        // ---------- Original Method ----------
        //print(String.valueOf(inum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.705 -0400", hash_original_method = "A3B835CD89D15A13CD365E547F38E002", hash_generated_method = "5350C4AC42B46E8FF7E70AE518A6A18F")
    public void print(long lnum) {
        addTaint(lnum);
        print(String.valueOf(lnum));
        // ---------- Original Method ----------
        //print(String.valueOf(lnum));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.706 -0400", hash_original_method = "649E6082D773CF70C752E5716C5CC7C1", hash_generated_method = "693ABB32D1E0310A5EFB40FE7E5DB7AA")
    public void print(Object obj) {
        addTaint(obj.getTaint());
        print(String.valueOf(obj));
        // ---------- Original Method ----------
        //print(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.706 -0400", hash_original_method = "28AE2923CB2E212C4A1D24DC5B3A947D", hash_generated_method = "5A026D312550580FCBBAAA7BB9AD2D92")
    public void print(String str) {
        addTaint(str.getTaint());
        write(str != null ? str : String.valueOf((Object) null));
        // ---------- Original Method ----------
        //write(str != null ? str : String.valueOf((Object) null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.707 -0400", hash_original_method = "55BF6AEFB35D15A1E34ADB671F9CB185", hash_generated_method = "B1FD8862E230788623D6EED22ED4B1DF")
    public void print(boolean bool) {
        addTaint(bool);
        print(String.valueOf(bool));
        // ---------- Original Method ----------
        //print(String.valueOf(bool));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.707 -0400", hash_original_method = "F64EE4A89E44550272E2ED021897135C", hash_generated_method = "5A9D8C9CDABC6EB192238814801CE86C")
    public void println() {
        synchronized
(lock)        {
            print(System.lineSeparator());
    if(autoFlush)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.708 -0400", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "5D13023447190678839A52E6EC0FD6E6")
    public void println(char[] chars) {
        addTaint(chars[0]);
        println(new String(chars, 0, chars.length));
        // ---------- Original Method ----------
        //println(new String(chars, 0, chars.length));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.708 -0400", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "5B54C4A804342FB66DA39CD1A802F010")
    public void println(char c) {
        addTaint(c);
        println(String.valueOf(c));
        // ---------- Original Method ----------
        //println(String.valueOf(c));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.709 -0400", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "3DD05D2B8A6F7FA399C6E8CD1479DBC2")
    public void println(double d) {
        addTaint(d);
        println(String.valueOf(d));
        // ---------- Original Method ----------
        //println(String.valueOf(d));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.709 -0400", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "520DE5B296981CB84314D5F031E424FD")
    public void println(float f) {
        addTaint(f);
        println(String.valueOf(f));
        // ---------- Original Method ----------
        //println(String.valueOf(f));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.710 -0400", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "2AF3FEFBD9F0D1A853D2AE3CC075FDE9")
    public void println(int i) {
        addTaint(i);
        println(String.valueOf(i));
        // ---------- Original Method ----------
        //println(String.valueOf(i));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.710 -0400", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "D0CEAADD771279275CD5802BDD412D24")
    public void println(long l) {
        addTaint(l);
        println(String.valueOf(l));
        // ---------- Original Method ----------
        //println(String.valueOf(l));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.711 -0400", hash_original_method = "1CC054989EBE4FE044F6C09E43625828", hash_generated_method = "08E57207BFBB43EAD7A7328C4C72C6F1")
    public void println(Object obj) {
        addTaint(obj.getTaint());
        println(String.valueOf(obj));
        // ---------- Original Method ----------
        //println(String.valueOf(obj));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.711 -0400", hash_original_method = "78EB2001D4D66C9EDDEA85708AB1EA5C", hash_generated_method = "41751A7C4771E148A4B4B0169BC0B8B2")
    public void println(String str) {
        addTaint(str.getTaint());
        synchronized
(lock)        {
            print(str);
            println();
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //print(str);
            //println();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.712 -0400", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "F50EDCD63B561F206F067626B5527EA3")
    public void println(boolean b) {
        addTaint(b);
        println(String.valueOf(b));
        // ---------- Original Method ----------
        //println(String.valueOf(b));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.712 -0400", hash_original_method = "03F201CD8682A0C64485926BB6B35745", hash_generated_method = "E19F709760A48D2E58E1640EA92F744E")
    protected void setError() {
        synchronized
(lock)        {
            ioError = true;
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //ioError = true;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.713 -0400", hash_original_method = "A3159CA9C79B3AD467B0FCF29995C9CC", hash_generated_method = "3724A19C23B3F2EE07A60FEC7F3E7C0F")
    @Override
    public void write(char[] buf) {
        addTaint(buf[0]);
        write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //write(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.713 -0400", hash_original_method = "F47BE159FF15FE26B09EE65FDEAB6B8C", hash_generated_method = "28BFB103FC18830EB2F0EBB80758FC72")
    @Override
    public void write(char[] buf, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(buf[0]);
        doWrite(buf, offset, count);
        // ---------- Original Method ----------
        //doWrite(buf, offset, count);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.714 -0400", hash_original_method = "28E681395D573BD9F19024ECEBC35F4A", hash_generated_method = "39D68CAD32D8FB616634ECC972B68645")
    @Override
    public void write(int oneChar) {
        addTaint(oneChar);
        doWrite(new char[] { (char) oneChar }, 0, 1);
        // ---------- Original Method ----------
        //doWrite(new char[] { (char) oneChar }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.715 -0400", hash_original_method = "A7437F4A37204482B8F05D868AC831D8", hash_generated_method = "3773A7D8F5FAA97017538EA58EC7E194")
    private final void doWrite(char[] buf, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(buf[0]);
        synchronized
(lock)        {
    if(out != null)            
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
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.715 -0400", hash_original_method = "CF32CDDE2940A658D82FD10746BC6D29", hash_generated_method = "7A17B49248C98CFFABCDBD9CE387376E")
    @Override
    public void write(String str) {
        addTaint(str.getTaint());
        write(str.toCharArray());
        // ---------- Original Method ----------
        //write(str.toCharArray());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.716 -0400", hash_original_method = "63C99944EF00B97313C46973AD4FFC8C", hash_generated_method = "18A84DE5C687FFDD671BD947D6A5E9B2")
    @Override
    public void write(String str, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(str.getTaint());
        write(str.substring(offset, offset + count).toCharArray());
        // ---------- Original Method ----------
        //write(str.substring(offset, offset + count).toCharArray());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.716 -0400", hash_original_method = "4FD83DFE8717316B104D560444A12EF3", hash_generated_method = "4C43CB8D76EC3A8A7B06CD3D6B910C52")
    @Override
    public PrintWriter append(char c) {
        addTaint(c);
        write(c);
PrintWriter var72A74007B2BE62B849F475C7BDA4658B_30956472 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_30956472.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_30956472;
        // ---------- Original Method ----------
        //write(c);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.717 -0400", hash_original_method = "EC867D10B212AD9763F84A42EB42848B", hash_generated_method = "5DE11AE5687D0F972410DB8FE9539E6F")
    @Override
    public PrintWriter append(CharSequence csq) {
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } //End block
        append(csq, 0, csq.length());
PrintWriter var72A74007B2BE62B849F475C7BDA4658B_258145174 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_258145174.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_258145174;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //append(csq, 0, csq.length());
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.718 -0400", hash_original_method = "3313C31A52AD9501A690D6955A7EC57D", hash_generated_method = "2A8345AC691C7A4100CA6779297E1D0F")
    @Override
    public PrintWriter append(CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
    if(csq == null)        
        {
            csq = "null";
        } //End block
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
PrintWriter var72A74007B2BE62B849F475C7BDA4658B_1278958138 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1278958138.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1278958138;
        // ---------- Original Method ----------
        //if (csq == null) {
            //csq = "null";
        //}
        //String output = csq.subSequence(start, end).toString();
        //write(output, 0, output.length());
        //return this;
    }

    
}

