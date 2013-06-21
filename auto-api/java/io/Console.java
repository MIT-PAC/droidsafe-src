package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Formatter;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class Console implements Flushable {
    private ConsoleReader reader;
    private PrintWriter writer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.459 -0400", hash_original_method = "4BB1B19487B7F99D445DFF44E768497C", hash_generated_method = "2E6755064C071DFE7489F52A7B285BBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Console(InputStream in, OutputStream out) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(out.dsTaint);
        this.reader = new ConsoleReader(in);
        this.writer = new ConsoleWriter(out);
        // ---------- Original Method ----------
        //this.reader = new ConsoleReader(in);
        //this.writer = new ConsoleWriter(out);
    }

    
        public static Console getConsole() {
        return console;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.460 -0400", hash_original_method = "F7724246D188F0DD4BA6BF2BF289AD37", hash_generated_method = "4D7B28978F39C8925B3234F446DAAC01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void flush() {
        writer.flush();
        // ---------- Original Method ----------
        //writer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.460 -0400", hash_original_method = "92692099E41FF98F0151DCCF5CDE9533", hash_generated_method = "73DE4FD85A4DEFAC48F00D54BE732FA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.460 -0400", hash_original_method = "DF820A490F330AE30ADE40F19C61D720", hash_generated_method = "A197EBDD35830D24EB0687408305A5C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Console printf(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        Console var332B80BC927C6FFEEC76D8998999F86B_838881161 = (format(format, args));
        return (Console)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.460 -0400", hash_original_method = "6872D36E6DE03121BD2812355740CF6B", hash_generated_method = "22A6EABB95863B26061795587AEB3980")
    @DSModeled(DSC.SAFE)
    public Reader reader() {
        return (Reader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return reader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.461 -0400", hash_original_method = "1B0888B6F2590EE27349101E4345456E", hash_generated_method = "3BB52D5D803133901B1D73F0B54EC862")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readLine() {
        try 
        {
            String varBF6A70FE6C7CA100015768C7488C7388_2127958961 = (reader.readLine());
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOError(e);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return reader.readLine();
        //} catch (IOException e) {
            //throw new IOError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.461 -0400", hash_original_method = "C57E41A9A92416727FE090794383909A", hash_generated_method = "162E9E8285DA1A494FF6FA85A74A65EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readLine(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        {
            format(format, args);
            String varDDF8AEA2E15236257E5E348824659A72_548327952 = (readLine());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //format(format, args);
            //return readLine();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.461 -0400", hash_original_method = "762DE6C819CD7377980A2753C88FB126", hash_generated_method = "39195D9C8D8B2CAE7DD6911DF78F0D97")
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
                    Object var9AA63BC8A85E36AA198831074E784F9B_175781287 = (password.toCharArray());
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

    
        private static int setEcho(boolean on, int previousState) {
        try {
            return setEchoImpl(on, previousState);
        } catch (IOException ex) {
            throw new IOError(ex);
        }
    }

    
        private static int setEchoImpl(boolean on, int previousState) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.462 -0400", hash_original_method = "530DA602FE8EDD29DED20DF1AD2FA025", hash_generated_method = "498956C44053085BEDA97D098A650095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char[] readPassword(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        {
            format(format, args);
            char[] varFE64C0D15C2E24F41623FEB6BE40A9A5_150566219 = (readPassword());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.462 -0400", hash_original_method = "EF4D37EF542F65995124A506A5A02FEA", hash_generated_method = "6CA3B1083C298698D88452775D09FA5F")
    @DSModeled(DSC.SAFE)
    public PrintWriter writer() {
        return (PrintWriter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return writer;
    }

    
    private static class ConsoleReader extends BufferedReader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.462 -0400", hash_original_method = "3E2241309C439E282539AD753E3DFD21", hash_generated_method = "5FF1552D94415DBB41DF41CD7DC1D17D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ConsoleReader(InputStream in) throws IOException {
            super(new InputStreamReader(in, System.getProperty("file.encoding")), 256);
            dsTaint.addTaint(in.dsTaint);
            lock = CONSOLE_LOCK;
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.462 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
        @DSModeled(DSC.SAFE)
        @Override
        public void close() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static class ConsoleWriter extends PrintWriter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.462 -0400", hash_original_method = "FA093E69A8E73F56316EC18ECB712B0D", hash_generated_method = "298E1C59A3ED6863695BC7B70EB16710")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ConsoleWriter(OutputStream out) {
            super(out, true);
            dsTaint.addTaint(out.dsTaint);
            lock = CONSOLE_LOCK;
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.463 -0400", hash_original_method = "75157B2273B6AA161A7B1B413AEDC095", hash_generated_method = "A5E65993A379E3EA99BEF40B638BA0C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() {
            flush();
            // ---------- Original Method ----------
            //flush();
        }

        
    }


    
    private static final Object CONSOLE_LOCK = new Object();
    private static final Console console = makeConsole();
}

