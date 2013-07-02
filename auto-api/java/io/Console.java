package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Formatter;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class Console implements Flushable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.598 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "E1481C92EA038B35574B186892F59636")

    private ConsoleReader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.598 -0400", hash_original_field = "A82FEEE3CC1AF8BCABDA979E8775EF0F", hash_generated_field = "91C0360688E01789B87DE4B98C351C86")

    private PrintWriter writer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.598 -0400", hash_original_method = "4BB1B19487B7F99D445DFF44E768497C", hash_generated_method = "F63CBA47110CFE9BD3FA9E844BE04033")
    private  Console(InputStream in, OutputStream out) throws IOException {
        this.reader = new ConsoleReader(in);
        this.writer = new ConsoleWriter(out);
        
        
        
    }

    
    public static Console getConsole() {
        return console;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.599 -0400", hash_original_method = "F7724246D188F0DD4BA6BF2BF289AD37", hash_generated_method = "4D7B28978F39C8925B3234F446DAAC01")
    public void flush() {
        writer.flush();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.600 -0400", hash_original_method = "92692099E41FF98F0151DCCF5CDE9533", hash_generated_method = "5D1BC07F296CBB14886E4AC9CFF6B538")
    public Console format(String format, Object... args) {
        Console varB4EAC82CA7396A68D541C85D26508E83_631302059 = null; 
        Formatter f = new Formatter(writer);
        f.format(format, args);
        f.flush();
        varB4EAC82CA7396A68D541C85D26508E83_631302059 = this;
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_631302059.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_631302059;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.600 -0400", hash_original_method = "DF820A490F330AE30ADE40F19C61D720", hash_generated_method = "D8A084F7E5FD624EF4CA5B6E1D0B7BFC")
    public Console printf(String format, Object... args) {
        Console varB4EAC82CA7396A68D541C85D26508E83_1759731471 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1759731471 = format(format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1759731471.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1759731471;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.601 -0400", hash_original_method = "6872D36E6DE03121BD2812355740CF6B", hash_generated_method = "3A15D4969348E43CBFAC414C48B49CFE")
    public Reader reader() {
        Reader varB4EAC82CA7396A68D541C85D26508E83_1862069813 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1862069813 = reader;
        varB4EAC82CA7396A68D541C85D26508E83_1862069813.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1862069813;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.602 -0400", hash_original_method = "1B0888B6F2590EE27349101E4345456E", hash_generated_method = "CB8DF427DA0D39B3790BF2AFCF9E9FB5")
    public String readLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_933132953 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_933132953 = reader.readLine();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_933132953.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_933132953;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.602 -0400", hash_original_method = "C57E41A9A92416727FE090794383909A", hash_generated_method = "E7F08A844C57BFA746FB05E9264C9399")
    public String readLine(String format, Object... args) {
        String varB4EAC82CA7396A68D541C85D26508E83_202137959 = null; 
        {
            format(format, args);
            varB4EAC82CA7396A68D541C85D26508E83_202137959 = readLine();
        } 
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_202137959.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_202137959;
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.603 -0400", hash_original_method = "762DE6C819CD7377980A2753C88FB126", hash_generated_method = "2E15C2BD04DC27DD530DF41DF4623967")
    public char[] readPassword() {
        {
            int previousState = setEcho(false, 0);
            try 
            {
                String password = readLine();
                writer.println();
                {
                    Object var9AA63BC8A85E36AA198831074E784F9B_421089592 = (password.toCharArray());
                } 
            } 
            finally 
            {
                setEcho(true, previousState);
            } 
        } 
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_2017493631 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_2017493631;
        
        
            
            
                
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.604 -0400", hash_original_method = "530DA602FE8EDD29DED20DF1AD2FA025", hash_generated_method = "3E1DF8E2800CE4514812DDDBB28867CC")
    public char[] readPassword(String format, Object... args) {
        {
            format(format, args);
            char[] varFE64C0D15C2E24F41623FEB6BE40A9A5_2134479170 = (readPassword());
        } 
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_875617723 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_875617723;
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.604 -0400", hash_original_method = "EF4D37EF542F65995124A506A5A02FEA", hash_generated_method = "71ECE298A66C2DE04274070D5EC064B1")
    public PrintWriter writer() {
        PrintWriter varB4EAC82CA7396A68D541C85D26508E83_1516536533 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1516536533 = writer;
        varB4EAC82CA7396A68D541C85D26508E83_1516536533.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1516536533;
        
        
    }

    
    private static class ConsoleReader extends BufferedReader {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.605 -0400", hash_original_method = "3E2241309C439E282539AD753E3DFD21", hash_generated_method = "7FE09BB27DAAB12986D55CC29BB8FDA9")
        public  ConsoleReader(InputStream in) throws IOException {
            super(new InputStreamReader(in, System.getProperty("file.encoding")), 256);
            lock = CONSOLE_LOCK;
            addTaint(in.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.605 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
        @Override
        public void close() {
            
        }

        
    }


    
    private static class ConsoleWriter extends PrintWriter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.605 -0400", hash_original_method = "FA093E69A8E73F56316EC18ECB712B0D", hash_generated_method = "0A930CE09366A209C3028EE89CCCB9D7")
        public  ConsoleWriter(OutputStream out) {
            super(out, true);
            lock = CONSOLE_LOCK;
            addTaint(out.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.605 -0400", hash_original_method = "75157B2273B6AA161A7B1B413AEDC095", hash_generated_method = "A5E65993A379E3EA99BEF40B638BA0C1")
        @Override
        public void close() {
            flush();
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.605 -0400", hash_original_field = "E87DC735B5F607608BFD6221C432D896", hash_generated_field = "546A7D00A3DECA7028ABE7F203CC82FE")

    private static final Object CONSOLE_LOCK = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.605 -0400", hash_original_field = "58E5F5166043786555088055759DF670", hash_generated_field = "5493C82FF0BE1436D143CDAA63D9AEDB")

    private static final Console console = makeConsole();
}

