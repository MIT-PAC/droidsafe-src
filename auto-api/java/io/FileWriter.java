package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class FileWriter extends OutputStreamWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.463 -0400", hash_original_method = "B243913791A4955722C7446949980DA0", hash_generated_method = "A8F8489C1818686FAEB7EDC3CDE59B64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(File file) throws IOException {
        super(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.463 -0400", hash_original_method = "79860F10C9F09BC3FC3374E75EC2439D", hash_generated_method = "721C276BF176E8B2CE5B9864590E2539")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(File file, boolean append) throws IOException {
        super(new FileOutputStream(file, append));
        dsTaint.addTaint(append);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.463 -0400", hash_original_method = "83907072F4E4E17B7331DF75EE7AA617", hash_generated_method = "A1ECBB71D1728B00BF0F9C3838A0C04D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(FileDescriptor fd) {
        super(new FileOutputStream(fd));
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.463 -0400", hash_original_method = "7A60608F9C8A66E68FB25FC3BD2DB01D", hash_generated_method = "1A9426FE1DBC79F23F147F654D24B19C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(String filename) throws IOException {
        super(new FileOutputStream(new File(filename)));
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.463 -0400", hash_original_method = "754E5DA17049F1720720C66817C48E5C", hash_generated_method = "DA47348F42AD11413A6EF0A7B8138849")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(String filename, boolean append) throws IOException {
        super(new FileOutputStream(filename, append));
        dsTaint.addTaint(append);
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
}


