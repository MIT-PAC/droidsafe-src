package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;






public class PrintWriterPrinter implements Printer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.870 -0500", hash_original_field = "6E8D43D32266728EF3FE704F1F656E95", hash_generated_field = "F05012BDDB58D140166F54E133EB677E")

    private  PrintWriter mPW;
    
    /**
     * Create a new Printer that sends to a PrintWriter object.
     * 
     * @param pw The PrintWriter where you would like output to go.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.872 -0500", hash_original_method = "156210EF12921D469085B715E31A16AD", hash_generated_method = "617DBD356DA68C697216B4F6DA4CEFA7")
    
public PrintWriterPrinter(PrintWriter pw) {
        mPW = pw;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.874 -0500", hash_original_method = "5189B7E75DB8D4AF68FE0FEBEB42EF0B", hash_generated_method = "AE4CB45991A1B483DE0E313BC7443338")
    
public void println(String x) {
        mPW.println(x);
    }

    
}

