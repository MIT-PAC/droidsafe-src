package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;


public class ActivityNotFoundException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.381 -0400", hash_original_method = "56CBB1B0D6656A7AA127BFCDE1D30401", hash_generated_method = "4E0E0AF74E2E85C69CA75532FB0A998B")
    public  ActivityNotFoundException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.382 -0400", hash_original_method = "8587D789BC6C40698A73B5C613EDE1A6", hash_generated_method = "3FC941F31BDBB63A56CF0164D895B2A3")
    public  ActivityNotFoundException(String name) {
        super(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
}

