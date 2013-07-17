package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Formatter;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class Console implements Flushable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.569 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "E1481C92EA038B35574B186892F59636")

    private ConsoleReader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.569 -0400", hash_original_field = "A82FEEE3CC1AF8BCABDA979E8775EF0F", hash_generated_field = "91C0360688E01789B87DE4B98C351C86")

    private PrintWriter writer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.570 -0400", hash_original_method = "4BB1B19487B7F99D445DFF44E768497C", hash_generated_method = "F63CBA47110CFE9BD3FA9E844BE04033")
    private  Console(InputStream in, OutputStream out) throws IOException {
        this.reader = new ConsoleReader(in);
        this.writer = new ConsoleWriter(out);
        // ---------- Original Method ----------
        //this.reader = new ConsoleReader(in);
        //this.writer = new ConsoleWriter(out);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.571 -0400", hash_original_method = "F7724246D188F0DD4BA6BF2BF289AD37", hash_generated_method = "4D7B28978F39C8925B3234F446DAAC01")
    public void flush() {
        writer.flush();
        // ---------- Original Method ----------
        //writer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.571 -0400", hash_original_method = "92692099E41FF98F0151DCCF5CDE9533", hash_generated_method = "EB989877B09B82818348162139499BCF")
    public Console format(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        Formatter f = new Formatter(writer);
        f.format(format, args);
        f.flush();
Console var72A74007B2BE62B849F475C7BDA4658B_674659442 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_674659442.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_674659442;
        // ---------- Original Method ----------
        //Formatter f = new Formatter(writer);
        //f.format(format, args);
        //f.flush();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.572 -0400", hash_original_method = "DF820A490F330AE30ADE40F19C61D720", hash_generated_method = "BF10FF5DA662413A512A44C12C6B1B59")
    public Console printf(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
Console var1C1A7E0ECC814A41656D8DF055D1B8DD_1781091968 =         format(format, args);
        var1C1A7E0ECC814A41656D8DF055D1B8DD_1781091968.addTaint(taint);
        return var1C1A7E0ECC814A41656D8DF055D1B8DD_1781091968;
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.572 -0400", hash_original_method = "6872D36E6DE03121BD2812355740CF6B", hash_generated_method = "1E0BB5EBF429A423844FF6A22C5107E9")
    public Reader reader() {
Reader var681AFDDDB48FD166DFCBFA04C65E6269_314543697 =         reader;
        var681AFDDDB48FD166DFCBFA04C65E6269_314543697.addTaint(taint);
        return var681AFDDDB48FD166DFCBFA04C65E6269_314543697;
        // ---------- Original Method ----------
        //return reader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.573 -0400", hash_original_method = "1B0888B6F2590EE27349101E4345456E", hash_generated_method = "D4C8B50C856450CB42BCFF6F04525B78")
    public String readLine() {
        try 
        {
String varA0A0B75A2C3B28E2BCA3874A2AF6FB2A_1859562639 =             reader.readLine();
            varA0A0B75A2C3B28E2BCA3874A2AF6FB2A_1859562639.addTaint(taint);
            return varA0A0B75A2C3B28E2BCA3874A2AF6FB2A_1859562639;
        } //End block
        catch (IOException e)
        {
            IOError varDAD4EC9CD68EF997C9389EB7A1B7124F_1400721233 = new IOError(e);
            varDAD4EC9CD68EF997C9389EB7A1B7124F_1400721233.addTaint(taint);
            throw varDAD4EC9CD68EF997C9389EB7A1B7124F_1400721233;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return reader.readLine();
        //} catch (IOException e) {
            //throw new IOError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.573 -0400", hash_original_method = "C57E41A9A92416727FE090794383909A", hash_generated_method = "00E8A27CE2AB32401B9857CB63DDEA60")
    public String readLine(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        synchronized
(CONSOLE_LOCK)        {
            format(format, args);
String var54932DCBE9604DD8D26100A2DD0CC65C_1559035034 =             readLine();
            var54932DCBE9604DD8D26100A2DD0CC65C_1559035034.addTaint(taint);
            return var54932DCBE9604DD8D26100A2DD0CC65C_1559035034;
        } //End block
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //format(format, args);
            //return readLine();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.573 -0400", hash_original_method = "762DE6C819CD7377980A2753C88FB126", hash_generated_method = "B49411AF3EB8941781F06BF0E655E569")
    public char[] readPassword() {
        synchronized
(CONSOLE_LOCK)        {
            int previousState = setEcho(false, 0);
            try 
            {
                String password = readLine();
                writer.println();
                char[] var9E7AB2C8A043C13D3A2102426F756EC2_314818533 = ((password == null) ? null : password.toCharArray());
                                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1071419967 = {getTaintChar()};
                return var50607924ABD4C17119BAF3A1CE41C0EC_1071419967;
            } //End block
            finally 
            {
                setEcho(true, previousState);
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    private static int setEchoImpl(boolean on, int previousState) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.574 -0400", hash_original_method = "530DA602FE8EDD29DED20DF1AD2FA025", hash_generated_method = "A65FF425D3FB17993D39D8B152082148")
    public char[] readPassword(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        synchronized
(CONSOLE_LOCK)        {
            format(format, args);
            char[] var4FA87729348AEF40F0E50B593E75DA06_1404486900 = (readPassword());
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_721840755 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_721840755;
        } //End block
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //format(format, args);
            //return readPassword();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.574 -0400", hash_original_method = "EF4D37EF542F65995124A506A5A02FEA", hash_generated_method = "CE8C9C9FE3A619A7B0A767B5347A62ED")
    public PrintWriter writer() {
PrintWriter varF684C05FE6F21143B285791952B93F74_1498134434 =         writer;
        varF684C05FE6F21143B285791952B93F74_1498134434.addTaint(taint);
        return varF684C05FE6F21143B285791952B93F74_1498134434;
        // ---------- Original Method ----------
        //return writer;
    }

    
    private static class ConsoleReader extends BufferedReader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.575 -0400", hash_original_method = "3E2241309C439E282539AD753E3DFD21", hash_generated_method = "0644BC6EE196A5609954302B5CBEC9D5")
        public  ConsoleReader(InputStream in) throws IOException {
            super(new InputStreamReader(in, System.getProperty("file.encoding")), 256);
            addTaint(in.getTaint());
            lock = CONSOLE_LOCK;
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.575 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
        @Override
        public void close() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static class ConsoleWriter extends PrintWriter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.575 -0400", hash_original_method = "FA093E69A8E73F56316EC18ECB712B0D", hash_generated_method = "FECF41157503BFF0E243D80A4D189A41")
        public  ConsoleWriter(OutputStream out) {
            super(out, true);
            addTaint(out.getTaint());
            lock = CONSOLE_LOCK;
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.575 -0400", hash_original_method = "75157B2273B6AA161A7B1B413AEDC095", hash_generated_method = "A5E65993A379E3EA99BEF40B638BA0C1")
        @Override
        public void close() {
            flush();
            // ---------- Original Method ----------
            //flush();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.575 -0400", hash_original_field = "E87DC735B5F607608BFD6221C432D896", hash_generated_field = "546A7D00A3DECA7028ABE7F203CC82FE")

    private static final Object CONSOLE_LOCK = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.575 -0400", hash_original_field = "58E5F5166043786555088055759DF670", hash_generated_field = "5493C82FF0BE1436D143CDAA63D9AEDB")

    private static final Console console = makeConsole();
}

