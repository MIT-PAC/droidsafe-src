package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FileReader extends InputStreamReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.783 -0400", hash_original_method = "0939BF332CE432F578D5C221A304222E", hash_generated_method = "1B51C9F6CF790A55B05126D9815A9344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileReader(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.783 -0400", hash_original_method = "13E06B0BF199770B67C55D66A2E28679", hash_generated_method = "C9859396B5DEA9BE91058FD8F125E836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileReader(FileDescriptor fd) {
        super(new FileInputStream(fd));
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.784 -0400", hash_original_method = "4AC2E8EE80FFC4D42725FA480AA6947B", hash_generated_method = "6658F5ED0C8232DBFD3B7F380D5A4F86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileReader(String filename) throws FileNotFoundException {
        super(new FileInputStream(filename));
        dsTaint.addTaint(filename);
        // ---------- Original Method ----------
    }

    
}

