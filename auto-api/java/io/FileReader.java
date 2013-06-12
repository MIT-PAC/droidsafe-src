package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class FileReader extends InputStreamReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.460 -0400", hash_original_method = "0939BF332CE432F578D5C221A304222E", hash_generated_method = "7161009241209ECE3853DE0620BFA143")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileReader(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.460 -0400", hash_original_method = "13E06B0BF199770B67C55D66A2E28679", hash_generated_method = "500C28AC9A260DBE75ECA161D328A8EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileReader(FileDescriptor fd) {
        super(new FileInputStream(fd));
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.460 -0400", hash_original_method = "4AC2E8EE80FFC4D42725FA480AA6947B", hash_generated_method = "9BFC24332CAE6641C2BA0933539E49D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileReader(String filename) throws FileNotFoundException {
        super(new FileInputStream(filename));
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
}


