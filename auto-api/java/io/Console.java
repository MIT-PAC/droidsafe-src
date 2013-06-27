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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.657 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "E1481C92EA038B35574B186892F59636")

    private ConsoleReader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.663 -0400", hash_original_field = "A82FEEE3CC1AF8BCABDA979E8775EF0F", hash_generated_field = "91C0360688E01789B87DE4B98C351C86")

    private PrintWriter writer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.669 -0400", hash_original_method = "4BB1B19487B7F99D445DFF44E768497C", hash_generated_method = "F63CBA47110CFE9BD3FA9E844BE04033")
    private  Console(InputStream in, OutputStream out) throws IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.669 -0400", hash_original_method = "F7724246D188F0DD4BA6BF2BF289AD37", hash_generated_method = "4D7B28978F39C8925B3234F446DAAC01")
    public void flush() {
        writer.flush();
        // ---------- Original Method ----------
        //writer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.670 -0400", hash_original_method = "92692099E41FF98F0151DCCF5CDE9533", hash_generated_method = "02A2F33CF6ACE0308077D7085A3B8D9C")
    public Console format(String format, Object... args) {
        Console varB4EAC82CA7396A68D541C85D26508E83_1106859974 = null; //Variable for return #1
        Formatter f;
        f = new Formatter(writer);
        f.format(format, args);
        f.flush();
        varB4EAC82CA7396A68D541C85D26508E83_1106859974 = this;
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1106859974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1106859974;
        // ---------- Original Method ----------
        //Formatter f = new Formatter(writer);
        //f.format(format, args);
        //f.flush();
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.670 -0400", hash_original_method = "DF820A490F330AE30ADE40F19C61D720", hash_generated_method = "26C4A729BA8E5E8B9411AE212334901C")
    public Console printf(String format, Object... args) {
        Console varB4EAC82CA7396A68D541C85D26508E83_1795884460 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1795884460 = format(format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1795884460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1795884460;
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.680 -0400", hash_original_method = "6872D36E6DE03121BD2812355740CF6B", hash_generated_method = "9C29695182182E016410602CD9D8AFCD")
    public Reader reader() {
        Reader varB4EAC82CA7396A68D541C85D26508E83_88423030 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_88423030 = reader;
        varB4EAC82CA7396A68D541C85D26508E83_88423030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_88423030;
        // ---------- Original Method ----------
        //return reader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.680 -0400", hash_original_method = "1B0888B6F2590EE27349101E4345456E", hash_generated_method = "DD73E2CBFAA26BBA5528CAFE951B409E")
    public String readLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1753470577 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1753470577 = reader.readLine();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1753470577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1753470577;
        // ---------- Original Method ----------
        //try {
            //return reader.readLine();
        //} catch (IOException e) {
            //throw new IOError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.681 -0400", hash_original_method = "C57E41A9A92416727FE090794383909A", hash_generated_method = "54D157B173F7E87E7EA95C0169B4B27B")
    public String readLine(String format, Object... args) {
        String varB4EAC82CA7396A68D541C85D26508E83_1593940321 = null; //Variable for return #1
        {
            format(format, args);
            varB4EAC82CA7396A68D541C85D26508E83_1593940321 = readLine();
        } //End block
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1593940321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1593940321;
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //format(format, args);
            //return readLine();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.696 -0400", hash_original_method = "762DE6C819CD7377980A2753C88FB126", hash_generated_method = "BCBFFF4045A523A105583371F9A58582")
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
                    Object var9AA63BC8A85E36AA198831074E784F9B_1348786539 = (password.toCharArray());
                } //End flattened ternary
            } //End block
            finally 
            {
                setEcho(true, previousState);
            } //End block
        } //End block
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1290700318 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1290700318;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.697 -0400", hash_original_method = "530DA602FE8EDD29DED20DF1AD2FA025", hash_generated_method = "FB1E8D81F4BF5D1A7945E7229C1C221C")
    public char[] readPassword(String format, Object... args) {
        {
            format(format, args);
            char[] varFE64C0D15C2E24F41623FEB6BE40A9A5_1068320166 = (readPassword());
        } //End block
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_745388873 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_745388873;
        // ---------- Original Method ----------
        //synchronized (CONSOLE_LOCK) {
            //format(format, args);
            //return readPassword();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.698 -0400", hash_original_method = "EF4D37EF542F65995124A506A5A02FEA", hash_generated_method = "9B1BE9F01892BF5AA3B19D2332B35955")
    public PrintWriter writer() {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_1598330152 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1598330152 = writer;
        varB4EAC82CA7396A68D541C85D26508E83_1598330152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1598330152;
        // ---------- Original Method ----------
        //return writer;
    }

    
    private static class ConsoleReader extends BufferedReader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.698 -0400", hash_original_method = "3E2241309C439E282539AD753E3DFD21", hash_generated_method = "7FE09BB27DAAB12986D55CC29BB8FDA9")
        public  ConsoleReader(InputStream in) throws IOException {
            super(new InputStreamReader(in, System.getProperty("file.encoding")), 256);
            lock = CONSOLE_LOCK;
            addTaint(in.getTaint());
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.698 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
        @Override
        public void close() {
            // ---------- Original Method ----------
        }

        
    }


    
    private static class ConsoleWriter extends PrintWriter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.702 -0400", hash_original_method = "FA093E69A8E73F56316EC18ECB712B0D", hash_generated_method = "0A930CE09366A209C3028EE89CCCB9D7")
        public  ConsoleWriter(OutputStream out) {
            super(out, true);
            lock = CONSOLE_LOCK;
            addTaint(out.getTaint());
            // ---------- Original Method ----------
            //lock = CONSOLE_LOCK;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.703 -0400", hash_original_method = "75157B2273B6AA161A7B1B413AEDC095", hash_generated_method = "A5E65993A379E3EA99BEF40B638BA0C1")
        @Override
        public void close() {
            flush();
            // ---------- Original Method ----------
            //flush();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.703 -0400", hash_original_field = "E87DC735B5F607608BFD6221C432D896", hash_generated_field = "C877E914E9043F8C1D283445460BB46F")

    private static Object CONSOLE_LOCK = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.703 -0400", hash_original_field = "58E5F5166043786555088055759DF670", hash_generated_field = "3FBEB2B5F4449BB2850EA3487A66CB37")

    private static Console console = makeConsole();
}

