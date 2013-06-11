package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.util.Formatter;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class Console implements Flushable {
    private static final Object CONSOLE_LOCK = new Object();
    private static final Console console = makeConsole();
    private final ConsoleReader reader;
    private final PrintWriter writer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.455 -0400", hash_original_method = "4BB1B19487B7F99D445DFF44E768497C", hash_generated_method = "70B83F2A06780A636B02B3AB3385A10F")
    @DSModeled(DSC.SAFE)
    private Console(InputStream in, OutputStream out) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(out.dsTaint);
        this.reader = new ConsoleReader(in);
        this.writer = new ConsoleWriter(out);
        // ---------- Original Method ----------
        //this.reader = new ConsoleReader(in);
        //this.writer = new ConsoleWriter(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.463 -0400", hash_original_method = "E042DF20162499E05BE37E1E3B35DC0F", hash_generated_method = "CE2F8AC88C532DF19218B2E8BBEFE4BE")
    public static Console getConsole() {
        return console;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.469 -0400", hash_original_method = "44FBB43D16293FCD0C78B59D6359E9A1", hash_generated_method = "A347205CFABAD67DAEEEE8A0659E862A")
    private static Console makeConsole() {
        if (!Libcore.os.isatty(FileDescriptor.in) || !Libcore.os.isatty(FileDescriptor.out)) {
            return null;
        }
        try {
            return new Console(System.in, System.out);
        } catch (IOException ex) {
            throw new AssertionError(ex);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.481 -0400", hash_original_method = "F7724246D188F0DD4BA6BF2BF289AD37", hash_generated_method = "5EE7939304F3BADBCF34723C5054355F")
    @DSModeled(DSC.SAFE)
    public void flush() {
        writer.flush();
        // ---------- Original Method ----------
        //writer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.492 -0400", hash_original_method = "92692099E41FF98F0151DCCF5CDE9533", hash_generated_method = "36020BF5D3C28F25115124E2A237591E")
    @DSModeled(DSC.SAFE)
    public Console format(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        Formatter f;
        f = new Formatter(writer);
        f.format(format, args);
        f.flush();
        return (Console)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Formatter f = new Formatter(writer);
        //f.format(format, args);
        //f.flush();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.508 -0400", hash_original_method = "DF820A490F330AE30ADE40F19C61D720", hash_generated_method = "21A6A0E3B06227A0B96CFE079E581F2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Console printf(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        Console var332B80BC927C6FFEEC76D8998999F86B_879729660 = (format(format, args));
        return (Console)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.517 -0400", hash_original_method = "6872D36E6DE03121BD2812355740CF6B", hash_generated_method = "B4C3F74648799A25DFB0849C893B5497")
    @DSModeled(DSC.SAFE)
    public Reader reader() {
        return (Reader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.524 -0400", hash_original_method = "1B0888B6F2590EE27349101E4345456E", hash_generated_method = "ED2594F1280CA7ACC60183D075ADDFCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readLine() {
        try 
        {
            String varBF6A70FE6C7CA100015768C7488C7388_1528620197 = (reader.readLine());
        } //End block
        catch (IOException e)
        {
            throw new IOError(e);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return reader.readLine();
        //} catch (IOException e) {
            //throw new IOError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.535 -0400", hash_original_method = "C57E41A9A92416727FE090794383909A", hash_generated_method = "EBB736F353C1080C962585D7E6C80D2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readLine(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        {
            format(format, args);
            String varDDF8AEA2E15236257E5E348824659A72_1968402764 = (readLine());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //format(format, args);
            //return readLine();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.559 -0400", hash_original_method = "762DE6C819CD7377980A2753C88FB126", hash_generated_method = "897D8888773885F7103ECF7AF564C39D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] readPassword() {
        {
            int previousState;
            previousState = setEcho(false, 0);
            try 
            {
                String password;
                password = readLine();
                writer.println();
                {
                    Object var9AA63BC8A85E36AA198831074E784F9B_875320950 = (password.toCharArray());
                } //End flattened ternary
            } //End block
            finally 
            {
                setEcho(true, previousState);
            } //End block
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //int previousState = setEcho(false, 0);
            //try {
                //String password = readLine();
                //writer.println(); 
                //return (password == null) ? null : password.toCharArray();
            //} finally {
                //setEcho(true, previousState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.569 -0400", hash_original_method = "366899432B3AD53D4041107C98D183D5", hash_generated_method = "EC07B1EC73AA052235667C4BF649789C")
    private static int setEcho(boolean on, int previousState) {
        try {
            return setEchoImpl(on, previousState);
        } catch (IOException ex) {
            throw new IOError(ex);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.575 -0400", hash_original_method = "B6C1FC4914B22110D706324D35B00A85", hash_generated_method = "30F4B92B5F660181749BC85257CBFFCC")
    private static int setEchoImpl(boolean on, int previousState) throws IOException {
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.585 -0400", hash_original_method = "530DA602FE8EDD29DED20DF1AD2FA025", hash_generated_method = "A7F9240D1549914404636F5F12479ED1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] readPassword(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        {
            format(format, args);
            char[] varFE64C0D15C2E24F41623FEB6BE40A9A5_526193208 = (readPassword());
        } //End block
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //format(format, args);
            //return readPassword();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.590 -0400", hash_original_method = "EF4D37EF542F65995124A506A5A02FEA", hash_generated_method = "F0CA19E7A3551C2D0DDCE6BD98218B69")
    @DSModeled(DSC.SAFE)
    public PrintWriter writer() {
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return writer;
    }

    
    private static class ConsoleReader extends BufferedReader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.599 -0400", hash_original_method = "3E2241309C439E282539AD753E3DFD21", hash_generated_method = "B9B442255645905E69D383A729CDF307")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ConsoleReader(InputStream in) throws IOException {
            super(new InputStreamReader(in, System.getProperty("file.encoding")), 256);
            dsTaint.addTaint(in.dsTaint);
            lock = CONSOLE_LOCK;
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.613 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1CDA3FDF568962C4A889B5852A7121B0")
        @DSModeled(DSC.SAFE)
        @Override
        public void close() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static class ConsoleWriter extends PrintWriter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.618 -0400", hash_original_method = "FA093E69A8E73F56316EC18ECB712B0D", hash_generated_method = "AE4A06C665A18885208E7D1D094B380B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ConsoleWriter(OutputStream out) {
            super(out, true);
            dsTaint.addTaint(out.dsTaint);
            lock = CONSOLE_LOCK;
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:08:44.623 -0400", hash_original_method = "75157B2273B6AA161A7B1B413AEDC095", hash_generated_method = "55D169B5C5882DA33D9249A6027412B3")
        @DSModeled(DSC.SAFE)
        @Override
        public void close() {
            flush();
            // ---------- Original Method ----------
            //flush();
        }

        
    }


    
}


