package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FileReader extends InputStreamReader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.878 -0400", hash_original_method = "0939BF332CE432F578D5C221A304222E", hash_generated_method = "75E46C7E98044334C539CA4679FBA01F")
    public  FileReader(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.879 -0400", hash_original_method = "13E06B0BF199770B67C55D66A2E28679", hash_generated_method = "638BA5852A1A0315FBD3EF4022495C6A")
    public  FileReader(FileDescriptor fd) {
        super(new FileInputStream(fd));
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.880 -0400", hash_original_method = "4AC2E8EE80FFC4D42725FA480AA6947B", hash_generated_method = "91630CB4DF8A8DF6EA83C591D4B2EE03")
    public  FileReader(String filename) throws FileNotFoundException {
        super(new FileInputStream(filename));
        addTaint(filename.getTaint());
        // ---------- Original Method ----------
    }

    
}

