package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FileWriter extends OutputStreamWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.789 -0400", hash_original_method = "B243913791A4955722C7446949980DA0", hash_generated_method = "C53B156AA5801FC57F20BDDBDCA04222")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(File file) throws IOException {
        super(new FileOutputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.789 -0400", hash_original_method = "79860F10C9F09BC3FC3374E75EC2439D", hash_generated_method = "5C5F696AA3209C108CACAD330AED13B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(File file, boolean append) throws IOException {
        super(new FileOutputStream(file, append));
        dsTaint.addTaint(append);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.789 -0400", hash_original_method = "83907072F4E4E17B7331DF75EE7AA617", hash_generated_method = "5B4B3AD2711638ED2494C0EF7706A1A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(FileDescriptor fd) {
        super(new FileOutputStream(fd));
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.790 -0400", hash_original_method = "7A60608F9C8A66E68FB25FC3BD2DB01D", hash_generated_method = "BCD7507EAA5FA1F920668CD2598A6345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(String filename) throws IOException {
        super(new FileOutputStream(new File(filename)));
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.790 -0400", hash_original_method = "754E5DA17049F1720720C66817C48E5C", hash_generated_method = "E4A623C0EDCB08CA8464186B2350C1AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileWriter(String filename, boolean append) throws IOException {
        super(new FileOutputStream(filename, append));
        dsTaint.addTaint(append);
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
}

