package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FileWriter extends OutputStreamWriter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.990 -0400", hash_original_method = "B243913791A4955722C7446949980DA0", hash_generated_method = "5D4D46EFA53E8F28CC5F5E95CC8BCF0D")
    public  FileWriter(File file) throws IOException {
        super(new FileOutputStream(file));
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.990 -0400", hash_original_method = "79860F10C9F09BC3FC3374E75EC2439D", hash_generated_method = "9109ECCE14EDA599D61883A638F98CFF")
    public  FileWriter(File file, boolean append) throws IOException {
        super(new FileOutputStream(file, append));
        addTaint(file.getTaint());
        addTaint(append);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.991 -0400", hash_original_method = "83907072F4E4E17B7331DF75EE7AA617", hash_generated_method = "50D1C76FC466FB770B374EED9727EA88")
    public  FileWriter(FileDescriptor fd) {
        super(new FileOutputStream(fd));
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.991 -0400", hash_original_method = "7A60608F9C8A66E68FB25FC3BD2DB01D", hash_generated_method = "0F92FC2994F73FEE5081DE3B38725F95")
    public  FileWriter(String filename) throws IOException {
        super(new FileOutputStream(new File(filename)));
        addTaint(filename.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.991 -0400", hash_original_method = "754E5DA17049F1720720C66817C48E5C", hash_generated_method = "08AE93227CFAA2CDA5591F1661B914A2")
    public  FileWriter(String filename, boolean append) throws IOException {
        super(new FileOutputStream(filename, append));
        addTaint(filename.getTaint());
        addTaint(append);
        // ---------- Original Method ----------
    }

    
}

