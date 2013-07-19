package android.util;

// Droidsafe Imports
import java.io.PrintWriter;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PrintWriterPrinter implements Printer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.005 -0400", hash_original_field = "1CF9037BCEA86E09FF4A32CFA952E82E", hash_generated_field = "F05012BDDB58D140166F54E133EB677E")

    private PrintWriter mPW;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.005 -0400", hash_original_method = "156210EF12921D469085B715E31A16AD", hash_generated_method = "5BD9FACD9BB576FC7B4D8B53A94EB0CB")
    public  PrintWriterPrinter(PrintWriter pw) {
        mPW = pw;
        // ---------- Original Method ----------
        //mPW = pw;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.006 -0400", hash_original_method = "5189B7E75DB8D4AF68FE0FEBEB42EF0B", hash_generated_method = "9238571C2E8450C6CAF9490458B52112")
    public void println(String x) {
        addTaint(x.getTaint());
        mPW.println(x);
        // ---------- Original Method ----------
        //mPW.println(x);
    }

    
}

