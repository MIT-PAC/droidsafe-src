package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.PrintWriter;

public class PrintWriterPrinter implements Printer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.251 -0400", hash_original_field = "1CF9037BCEA86E09FF4A32CFA952E82E", hash_generated_field = "F05012BDDB58D140166F54E133EB677E")

    private PrintWriter mPW;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.252 -0400", hash_original_method = "156210EF12921D469085B715E31A16AD", hash_generated_method = "5BD9FACD9BB576FC7B4D8B53A94EB0CB")
    public  PrintWriterPrinter(PrintWriter pw) {
        mPW = pw;
        // ---------- Original Method ----------
        //mPW = pw;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.252 -0400", hash_original_method = "5189B7E75DB8D4AF68FE0FEBEB42EF0B", hash_generated_method = "4A7D534B36BC83BA24A89ED219748C76")
    public void println(String x) {
        mPW.println(x);
        addTaint(x.getTaint());
        // ---------- Original Method ----------
        //mPW.println(x);
    }

    
}

