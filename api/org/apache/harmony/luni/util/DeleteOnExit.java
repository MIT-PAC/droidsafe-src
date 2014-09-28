package org.apache.harmony.luni.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class DeleteOnExit extends Thread {

    /**
     * Returns our singleton instance, creating it if necessary.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.371 -0500", hash_original_method = "5F2B916DEBE9B88C4D0351AB645CF666", hash_generated_method = "D55E2D40C001CB12E806F853D6224C5F")
    
public static synchronized DeleteOnExit getInstance() {
        if (instance == null) {
            instance = new DeleteOnExit();
            Runtime.getRuntime().addShutdownHook(instance);
        }

        return instance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.366 -0500", hash_original_field = "0BEA44D5F2B89CA572382212D1CF04F1", hash_generated_field = "1D7484B2D124716E795B5B3B920FBF1B")

    private static DeleteOnExit instance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.368 -0500", hash_original_field = "F2EB16A1C1929D27AB9BB521B26E3A8A", hash_generated_field = "47F1474B6B515F8F9C9704A4267BE62A")

    private ArrayList<String> files = new ArrayList<String>();
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.039 -0400", hash_original_method = "80FBB7FC28966FEC5371F3D04A9D4E08", hash_generated_method = "80FBB7FC28966FEC5371F3D04A9D4E08")
    public DeleteOnExit ()
    {
        //Synthesized constructor
    }

    /**
     * Schedules a file for deletion.
     *
     * @param filename The file to delete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.374 -0500", hash_original_method = "9511A18425627270E054955D67656A71", hash_generated_method = "0AB2DFAEA106666CF949B6C0829A17DD")
    
public void addFile(String filename) {
        synchronized(files) {
            if (!files.contains(filename)) {
                files.add(filename);
            }
        }
    }

    /**
     * Does the actual work. Note we (a) first sort the files lexicographically
     * and then (b) delete them in reverse order. This is to make sure files
     * get deleted before their parent directories.
     */
    @DSSpec(DSCat.THREADING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.377 -0500", hash_original_method = "557595D78AF878757FA1B104BCD5B60F", hash_generated_method = "E8CCDADFADCBC5BEA7486B573F3A1A3F")
    
@Override
    public void run() {
        Collections.sort(files);
        for (int i = files.size() - 1; i >= 0; i--) {
            new File(files.get(i)).delete();
        }
    }
}

