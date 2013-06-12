package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.PrintWriter;

public class PrintWriterPrinter implements Printer {
    private final PrintWriter mPW;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.657 -0400", hash_original_method = "156210EF12921D469085B715E31A16AD", hash_generated_method = "CF51DB78F8E08714C0EBDED5F20ABA56")
    @DSModeled(DSC.SAFE)
    public PrintWriterPrinter(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        mPW = pw;
        // ---------- Original Method ----------
        //mPW = pw;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.657 -0400", hash_original_method = "5189B7E75DB8D4AF68FE0FEBEB42EF0B", hash_generated_method = "C632A50523F261BF103BC16E87B0B035")
    @DSModeled(DSC.SAFE)
    public void println(String x) {
        dsTaint.addTaint(x);
        mPW.println(x);
        // ---------- Original Method ----------
        //mPW.println(x);
    }

    
}


