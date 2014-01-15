package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class FileReader extends InputStreamReader {

    /**
     * Constructs a new FileReader on the given {@code file}.
     *
     * @param file
     *            a File to be opened for reading characters from.
     * @throws FileNotFoundException
     *             if {@code file} does not exist.
     */
    @DSComment("FileReader class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.668 -0500", hash_original_method = "0939BF332CE432F578D5C221A304222E", hash_generated_method = "DD63061D68715F93ADB26D2C55A0FFBB")
    
public FileReader(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
    }

    /**
     * Construct a new FileReader on the given FileDescriptor {@code fd}. Since
     * a previously opened FileDescriptor is passed as an argument, no
     * FileNotFoundException can be thrown.
     *
     * @param fd
     *            the previously opened file descriptor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.670 -0500", hash_original_method = "13E06B0BF199770B67C55D66A2E28679", hash_generated_method = "DE3333235C07BFE2E5A4EC123A0D5F68")
    
public FileReader(FileDescriptor fd) {
        super(new FileInputStream(fd));
    }

    /**
     * Construct a new FileReader on the given file named {@code filename}.
     *
     * @param filename
     *            an absolute or relative path specifying the file to open.
     * @throws FileNotFoundException
     *             if there is no file named {@code filename}.
     */
    @DSComment("FileReader class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.673 -0500", hash_original_method = "4AC2E8EE80FFC4D42725FA480AA6947B", hash_generated_method = "BD0CE6A83F0A740DDE78B9DFDC68AF98")
    
public FileReader(String filename) throws FileNotFoundException {
        super(new FileInputStream(filename));
    }
    
}

