package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class PrintWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.852 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "8FF81F1EABE94AA2FE1148793CBBDC2D")

    protected Writer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.852 -0400", hash_original_field = "4B4C3D08948825F5FE6B51A1087D503E", hash_generated_field = "C89C47EA16E34DEBAC0E78BF779BC70F")

    private boolean ioError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.852 -0400", hash_original_field = "9B67A50854B43F683C9C287FC0D8C97B", hash_generated_field = "C3BCA0E638347F15CBD7648899C5AE35")

    private boolean autoFlush;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.852 -0400", hash_original_method = "009ECF78166A7569006BEB577877B2F6", hash_generated_method = "05AE4D4E6FBDCE7DFE3FD0B82EBAE392")
    public  PrintWriter(OutputStream out) {
        this(new OutputStreamWriter(out), false);
        addTaint(out.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.853 -0400", hash_original_method = "A0422DBDFA7D458C1211AD61A93CCD24", hash_generated_method = "F92CCE09B8E5F3AD26C530AB611A2A40")
    public  PrintWriter(OutputStream out, boolean autoFlush) {
        this(new OutputStreamWriter(out), autoFlush);
        addTaint(out.getTaint());
        addTaint(autoFlush);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.853 -0400", hash_original_method = "7F68156580476879DAEA9DC9BCB75B06", hash_generated_method = "C6FFE76650824927030A4AE92F8987D0")
    public  PrintWriter(Writer wr) {
        this(wr, false);
        addTaint(wr.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.853 -0400", hash_original_method = "C1927249B88242DCE6CFA0FA4F3C29B3", hash_generated_method = "F14F2A3F33B8FBF372DAB923D7D74C2F")
    public  PrintWriter(Writer wr, boolean autoFlush) {
        super(wr);
        this.autoFlush = autoFlush;
        out = wr;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.853 -0400", hash_original_method = "2C96C347B82CB5135A3ACEC685E09DC1", hash_generated_method = "91AF885BEB09C1CB8435A480DE8FAF91")
    public  PrintWriter(File file) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file))), false);
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.854 -0400", hash_original_method = "B162E67684B075ABE078C3780599A018", hash_generated_method = "B18040A15ADD018D7747E4211578E6AC")
    public  PrintWriter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)), csn),
                false);
        addTaint(file.getTaint());
        addTaint(csn.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.854 -0400", hash_original_method = "BB4A7F43BD82DE5EABC7964AA01AA735", hash_generated_method = "0B4C3D5928920263AB6771C0EE855742")
    public  PrintWriter(String fileName) throws FileNotFoundException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName))),
                false);
        addTaint(fileName.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.854 -0400", hash_original_method = "75ACA8D301D7B4385F5F1D6D811FAD95", hash_generated_method = "42BA166DA0140D91CC7CA10BFC4A21FD")
    public  PrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        this(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(fileName)), csn),
                false);
        addTaint(fileName.getTaint());
        addTaint(csn.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.855 -0400", hash_original_method = "0D2606A00F6397A8DDF12D981BAB88CA", hash_generated_method = "FB6AA055A7765F7596D8F61C64716181")
    public boolean checkError() {
        Writer delegate = out;
        flush();
        boolean var1828C5393F7AF357FCA50D6B6EE1E98D_411736641 = (ioError || delegate.checkError());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_441360709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_441360709;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.855 -0400", hash_original_method = "9EE080B9329CC6FAACC493ECC7141CFB", hash_generated_method = "0FB396FA9B1359C29CF99D8928A9F51A")
    protected void clearError() {
        {
            ioError = false;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.856 -0400", hash_original_method = "914ABB48E88E0FB5E2AF825917F549B2", hash_generated_method = "EB4BA8E31D443EA85687457D0AC185FE")
    @Override
    public void close() {
        {
            {
                try 
                {
                    out.close();
                } 
                catch (IOException e)
                {
                    setError();
                } 
                out = null;
            } 
        } 
        
        
            
                
                    
                
                    
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.857 -0400", hash_original_method = "3747E1B1C7FB1936BAC6943C89A67163", hash_generated_method = "A6EA88BD7A269402EE536B58D01426FF")
    @Override
    public void flush() {
        {
            {
                try 
                {
                    out.flush();
                } 
                catch (IOException e)
                {
                    setError();
                } 
            } 
            {
                setError();
            } 
        } 
        
        
            
                
                    
                
                    
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.857 -0400", hash_original_method = "68BF859C2EE72E22FD2B6E3C884D672F", hash_generated_method = "13F198987B41146D4DFB047ABED16094")
    public PrintWriter format(String format, Object... args) {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_1826693720 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1826693720 = format(Locale.getDefault(), format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1826693720.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1826693720;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.858 -0400", hash_original_method = "D5634586266B3A8B702A8EF418739481", hash_generated_method = "AA7F81CCB26AE54EAD4DC346EBC090B5")
    public PrintWriter format(Locale l, String format, Object... args) {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_16025431 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("format == null");
        } 
        new Formatter(this, l).format(format, args);
        {
            flush();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_16025431 = this;
        addTaint(l.getTaint());
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_16025431.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_16025431;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.858 -0400", hash_original_method = "D4B734B1529E4ABCC31A727EC1C73F87", hash_generated_method = "180DE0380BCD78509395A54DCC78E37F")
    public PrintWriter printf(String format, Object... args) {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_892473882 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_892473882 = format(format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_892473882.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_892473882;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.859 -0400", hash_original_method = "31E00ED7FA07EDC8A599E35C64000277", hash_generated_method = "EA897A7C1C36DF7FC0A36E951ADC5ADA")
    public PrintWriter printf(Locale l, String format, Object... args) {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_364510131 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_364510131 = format(l, format, args);
        addTaint(l.getTaint());
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_364510131.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_364510131;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.859 -0400", hash_original_method = "9BEBBB6A7E36A898084CFD13E6678C15", hash_generated_method = "FB9935533082398BEB22FD3C67DBA495")
    public void print(char[] charArray) {
        print(new String(charArray, 0, charArray.length));
        addTaint(charArray[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.859 -0400", hash_original_method = "F35E4DD8AE097731F5674B94681A91A4", hash_generated_method = "71DECAA304FF508EB7FA802870AC7409")
    public void print(char ch) {
        print(String.valueOf(ch));
        addTaint(ch);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.859 -0400", hash_original_method = "1B10CD3CDAEEB6B80C16851B9025C53B", hash_generated_method = "0160FE744A612AC72AD8F87F39901DC6")
    public void print(double dnum) {
        print(String.valueOf(dnum));
        addTaint(dnum);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.860 -0400", hash_original_method = "1CE43F20E63C9B7E63DE59186E96F9C3", hash_generated_method = "08887F7444B536FA91A06234B503F7C6")
    public void print(float fnum) {
        print(String.valueOf(fnum));
        addTaint(fnum);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.860 -0400", hash_original_method = "7E641CDBDB4194A4ABD6D1C9C473BCDE", hash_generated_method = "271A7BD0E0FCEF1689E92F1D42113B09")
    public void print(int inum) {
        print(String.valueOf(inum));
        addTaint(inum);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.860 -0400", hash_original_method = "A3B835CD89D15A13CD365E547F38E002", hash_generated_method = "C3982311E7A44AA2F73F63C35CB63B1F")
    public void print(long lnum) {
        print(String.valueOf(lnum));
        addTaint(lnum);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.861 -0400", hash_original_method = "649E6082D773CF70C752E5716C5CC7C1", hash_generated_method = "56A164437E55B1832392FBFE9ACA20D7")
    public void print(Object obj) {
        print(String.valueOf(obj));
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.861 -0400", hash_original_method = "28AE2923CB2E212C4A1D24DC5B3A947D", hash_generated_method = "30AF9EBA4C66D64BC78CBF2346343153")
    public void print(String str) {
        write(str != null ? str : String.valueOf((Object) null));
        addTaint(str.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.861 -0400", hash_original_method = "55BF6AEFB35D15A1E34ADB671F9CB185", hash_generated_method = "1A81DB91757D4D410FB520DFA4E53CED")
    public void print(boolean bool) {
        print(String.valueOf(bool));
        addTaint(bool);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.861 -0400", hash_original_method = "F64EE4A89E44550272E2ED021897135C", hash_generated_method = "756F7D66597A8B251CC021C068E8DDCF")
    public void println() {
        {
            print(System.lineSeparator());
            {
                flush();
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.862 -0400", hash_original_method = "C86060CC83A142ED26FEFD1C4AFF06F6", hash_generated_method = "8938A2FE5FCD6DCE54D627E26B30D7E0")
    public void println(char[] chars) {
        println(new String(chars, 0, chars.length));
        addTaint(chars[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.862 -0400", hash_original_method = "0AD803DE0349B67DF3766F5E61BB22D0", hash_generated_method = "E883109E58E1B3212A2A4D94C6403399")
    public void println(char c) {
        println(String.valueOf(c));
        addTaint(c);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.862 -0400", hash_original_method = "1C71B315F5691439EEEA0D1A39435B84", hash_generated_method = "19D6C062E79E5EF1FDA3434CB27FFB03")
    public void println(double d) {
        println(String.valueOf(d));
        addTaint(d);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.862 -0400", hash_original_method = "303071589A63282B34174CD2B6A3FE64", hash_generated_method = "2CCEDF413E024865C9B4040D0DB5495F")
    public void println(float f) {
        println(String.valueOf(f));
        addTaint(f);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.863 -0400", hash_original_method = "5AD4BE5FC276B9D22B3857BC3A21F6AF", hash_generated_method = "D517C6540C59690B2D39E32236163C8A")
    public void println(int i) {
        println(String.valueOf(i));
        addTaint(i);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.863 -0400", hash_original_method = "13C762985E9CE0F97BF4916754E07523", hash_generated_method = "D9835000754D2834382A2FC263CF597A")
    public void println(long l) {
        println(String.valueOf(l));
        addTaint(l);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.863 -0400", hash_original_method = "1CC054989EBE4FE044F6C09E43625828", hash_generated_method = "7232368C63883E732804484ABE4825B0")
    public void println(Object obj) {
        println(String.valueOf(obj));
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.864 -0400", hash_original_method = "78EB2001D4D66C9EDDEA85708AB1EA5C", hash_generated_method = "8E7A353B89E5DF1EE279A945EACF802E")
    public void println(String str) {
        {
            print(str);
            println();
        } 
        addTaint(str.getTaint());
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.864 -0400", hash_original_method = "63B90E61F0F8C1638BDCBB4A882302BD", hash_generated_method = "BF0988F7DC1409736F6D1A810B4E7CEA")
    public void println(boolean b) {
        println(String.valueOf(b));
        addTaint(b);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.865 -0400", hash_original_method = "03F201CD8682A0C64485926BB6B35745", hash_generated_method = "2A2E0A41F670A08AE912C405A23E19BA")
    protected void setError() {
        {
            ioError = true;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.865 -0400", hash_original_method = "A3159CA9C79B3AD467B0FCF29995C9CC", hash_generated_method = "665B803A50FC14AFB796691DB3E09468")
    @Override
    public void write(char[] buf) {
        write(buf, 0, buf.length);
        addTaint(buf[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.866 -0400", hash_original_method = "F47BE159FF15FE26B09EE65FDEAB6B8C", hash_generated_method = "54FA83006C71F876B7992387D0D551CA")
    @Override
    public void write(char[] buf, int offset, int count) {
        doWrite(buf, offset, count);
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(count);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.866 -0400", hash_original_method = "28E681395D573BD9F19024ECEBC35F4A", hash_generated_method = "C92402DA6771B4E1ED379CB6F6E5EBB9")
    @Override
    public void write(int oneChar) {
        doWrite(new char[] { (char) oneChar }, 0, 1);
        addTaint(oneChar);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.867 -0400", hash_original_method = "A7437F4A37204482B8F05D868AC831D8", hash_generated_method = "944CB989A34869872ADB737C5E66A5BC")
    private final void doWrite(char[] buf, int offset, int count) {
        {
            {
                try 
                {
                    out.write(buf, offset, count);
                } 
                catch (IOException e)
                {
                    setError();
                } 
            } 
            {
                setError();
            } 
        } 
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(count);
        
        
            
                
                    
                
                    
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.867 -0400", hash_original_method = "CF32CDDE2940A658D82FD10746BC6D29", hash_generated_method = "66759AF6F467A1043A92F4318D252152")
    @Override
    public void write(String str) {
        write(str.toCharArray());
        addTaint(str.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.868 -0400", hash_original_method = "63C99944EF00B97313C46973AD4FFC8C", hash_generated_method = "EE6D08857CAE24DE90CF9BEBBB4C8545")
    @Override
    public void write(String str, int offset, int count) {
        write(str.substring(offset, offset + count).toCharArray());
        addTaint(str.getTaint());
        addTaint(offset);
        addTaint(count);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.869 -0400", hash_original_method = "4FD83DFE8717316B104D560444A12EF3", hash_generated_method = "EC44868E2A2218977F1AAA952658C778")
    @Override
    public PrintWriter append(char c) {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_1488427871 = null; 
        write(c);
        varB4EAC82CA7396A68D541C85D26508E83_1488427871 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1488427871.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1488427871;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.872 -0400", hash_original_method = "EC867D10B212AD9763F84A42EB42848B", hash_generated_method = "9BB0667259F964BE8100411E98953209")
    @Override
    public PrintWriter append(CharSequence csq) {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_1470824564 = null; 
        {
            csq = "null";
        } 
        append(csq, 0, csq.length());
        varB4EAC82CA7396A68D541C85D26508E83_1470824564 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1470824564.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1470824564;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.875 -0400", hash_original_method = "3313C31A52AD9501A690D6955A7EC57D", hash_generated_method = "E0F7DE21CDBA45F4F7341599B877032C")
    @Override
    public PrintWriter append(CharSequence csq, int start, int end) {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_1867707481 = null; 
        {
            csq = "null";
        } 
        String output = csq.subSequence(start, end).toString();
        write(output, 0, output.length());
        varB4EAC82CA7396A68D541C85D26508E83_1867707481 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1867707481.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1867707481;
        
        
            
        
        
        
        
    }

    
}

