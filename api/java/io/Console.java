package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Formatter;

import libcore.io.Libcore;

import droidsafe.helpers.DSUtils;

public final class Console implements Flushable {

    /**
     * Secret accessor for {@code System.console}.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.426 -0500", hash_original_method = "E042DF20162499E05BE37E1E3B35DC0F", hash_generated_method = "CE2F8AC88C532DF19218B2E8BBEFE4BE")
    
public static Console getConsole() {
        return console;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.429 -0500", hash_original_method = "44FBB43D16293FCD0C78B59D6359E9A1", hash_generated_method = "6BFC4CBA2ADD2B5AF844E21342281D24")
    
private static Console makeConsole() {
        // We don't care about stderr, because this class only uses stdin and stdout.
        if (!Libcore.os.isatty(FileDescriptor.in) || !Libcore.os.isatty(FileDescriptor.out)) {
            return null;
        }
        try {
            return new Console(System.in, System.out);
        } catch (IOException ex) {
            throw new AssertionError(ex);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.452 -0500", hash_original_method = "366899432B3AD53D4041107C98D183D5", hash_generated_method = "EC07B1EC73AA052235667C4BF649789C")
    
private static int setEcho(boolean on, int previousState) {
        try {
            return setEchoImpl(on, previousState);
        } catch (IOException ex) {
            throw new IOError(ex);
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int setEchoImpl(boolean on, int previousState) throws IOException {
        return on? previousState : -previousState;    
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.416 -0500", hash_original_field = "BBCA88E2364A76AF3007D259E6D8A88C", hash_generated_field = "546A7D00A3DECA7028ABE7F203CC82FE")

    private static final Object CONSOLE_LOCK = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.419 -0500", hash_original_field = "D86A51B3BC21F2A21BE61CB7BEF830EE", hash_generated_field = "5493C82FF0BE1436D143CDAA63D9AEDB")

    private static final Console console = makeConsole();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.421 -0500", hash_original_field = "58293CE1EAA90810476F557AF923A37B", hash_generated_field = "E1481C92EA038B35574B186892F59636")

    private  ConsoleReader reader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.424 -0500", hash_original_field = "47BAA8D50DA4DDACCEB960B9BE04B99A", hash_generated_field = "91C0360688E01789B87DE4B98C351C86")

    private  PrintWriter writer;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.432 -0500", hash_original_method = "4BB1B19487B7F99D445DFF44E768497C", hash_generated_method = "7893804C010BDCD832EE6678ABEF1519")
    
private Console(InputStream in, OutputStream out) throws IOException {
        this.reader = new ConsoleReader(in);
        this.writer = new ConsoleWriter(out);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.434 -0500", hash_original_method = "F7724246D188F0DD4BA6BF2BF289AD37", hash_generated_method = "5CB497A23E3D98725A07724A313B13FD")
    
public void flush() {
        writer.flush();
    }

    /**
     * Writes a formatted string to the console using
     * the specified format string and arguments.
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return the console instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.437 -0500", hash_original_method = "92692099E41FF98F0151DCCF5CDE9533", hash_generated_method = "7FE21AC05C7F0A0FC6BB932DDC01DE96")
    
public Console format(String format, Object... args) {
        Formatter f = new Formatter(writer);
        f.format(format, args);
        f.flush();
        return this;
    }

    /**
     * Equivalent to {@code format(format, args)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.439 -0500", hash_original_method = "DF820A490F330AE30ADE40F19C61D720", hash_generated_method = "3EBFE9822BCE871720A426B1F8BE0307")
    
public Console printf(String format, Object... args) {
        return format(format, args);
    }

    /**
     * Returns the {@link Reader} associated with this console.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.441 -0500", hash_original_method = "6872D36E6DE03121BD2812355740CF6B", hash_generated_method = "1B34A1F2995B02D0623D166FB7B92B14")
    
public Reader reader() {
        return reader;
    }

    /**
     * Reads a line from the console.
     *
     * @return the line, or null at EOF.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.444 -0500", hash_original_method = "1B0888B6F2590EE27349101E4345456E", hash_generated_method = "2DF0FFA4A93FF56C0F67A3426C6CBE19")
    
public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IOError(e);
        }
    }

    /**
     * Reads a line from this console, using the specified prompt.
     * The prompt is given as a format string and optional arguments.
     * Note that this can be a source of errors: if it is possible that your
     * prompt contains {@code %} characters, you must use the format string {@code "%s"}
     * and pass the actual prompt as a parameter.
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return the line, or null at EOF.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.446 -0500", hash_original_method = "C57E41A9A92416727FE090794383909A", hash_generated_method = "2F1FF4D55692143DE7EF2CAC398D3622")
    
public String readLine(String format, Object... args) {
        synchronized (CONSOLE_LOCK) {
            format(format, args);
            return readLine();
        }
    }

    /**
     * Reads a password from the console. The password will not be echoed to the display.
     *
     * @return a character array containing the password, or null at EOF.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.448 -0500", hash_original_method = "762DE6C819CD7377980A2753C88FB126", hash_generated_method = "A959C451F098B68BBA6E50D6EF2D1D2C")
    
public char[] readPassword() {
        synchronized (CONSOLE_LOCK) {
            int previousState = setEcho(false, 0);
            try {
                String password = readLine();
                writer.println(); // We won't have echoed the user's newline.
                return (password == null) ? null : password.toCharArray();
            } finally {
                setEcho(true, previousState);
            }
        }
    }
    
    private static class ConsoleReader extends BufferedReader {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.466 -0500", hash_original_method = "3E2241309C439E282539AD753E3DFD21", hash_generated_method = "69CC72363FBE8C1D916398D13FD10521")
        
public ConsoleReader(InputStream in) throws IOException {
            super(new InputStreamReader(in, System.getProperty("file.encoding")), 256);
            lock = CONSOLE_LOCK;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.468 -0500", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "F57733FD7E5364F9B6017FD9FB0CBFAB")
        
@Override
        public void close() {
            // Console.reader cannot be closed.
        }
        
    }
    
    private static class ConsoleWriter extends PrintWriter {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.473 -0500", hash_original_method = "FA093E69A8E73F56316EC18ECB712B0D", hash_generated_method = "67FBCFEF5ED0B313D9140CDC4784401D")
        
public ConsoleWriter(OutputStream out) {
            super(out, true);
            lock = CONSOLE_LOCK;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.476 -0500", hash_original_method = "75157B2273B6AA161A7B1B413AEDC095", hash_generated_method = "7617F52AD8B0DD3F40B73D9405DB5418")
        
@Override
        public void close() {
            // Console.writer cannot be closed.
            flush();
        }
        
    }

    /**
     * Reads a password from the console. The password will not be echoed to the display.
     * A formatted prompt is also displayed.
     *
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args
     *            the list of arguments passed to the formatter. If there are
     *            more arguments than required by {@code format},
     *            additional arguments are ignored.
     * @return a character array containing the password, or null at EOF.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.459 -0500", hash_original_method = "530DA602FE8EDD29DED20DF1AD2FA025", hash_generated_method = "BB6489A580EA046E4810AB639A3B2AE3")
    
public char[] readPassword(String format, Object... args) {
        synchronized (CONSOLE_LOCK) {
            format(format, args);
            return readPassword();
        }
    }

    /**
     * Returns the {@link Writer} associated with this console.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:50.462 -0500", hash_original_method = "EF4D37EF542F65995124A506A5A02FEA", hash_generated_method = "9CAE9C29CB08D60BAEDA3F44B4247294")
    
public PrintWriter writer() {
        return writer;
    }
}

