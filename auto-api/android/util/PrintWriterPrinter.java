package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.PrintWriter;

public class PrintWriterPrinter implements Printer {
    private PrintWriter mPW;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.314 -0400", hash_original_method = "156210EF12921D469085B715E31A16AD", hash_generated_method = "3C38F2A765C540BF25E30D990D6E1876")
    @DSModeled(DSC.SAFE)
    public PrintWriterPrinter(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        // ---------- Original Method ----------
        //mPW = pw;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.314 -0400", hash_original_method = "5189B7E75DB8D4AF68FE0FEBEB42EF0B", hash_generated_method = "3E57EF2B35D05641A913CBEE4245872D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void println(String x) {
        dsTaint.addTaint(x);
        mPW.println(x);
        // ---------- Original Method ----------
        //mPW.println(x);
    }

    
}

