package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class FileWriter extends OutputStreamWriter {

    /**
     * Creates a FileWriter using the File {@code file}.
     *
     * @param file
     *            the non-null File to write bytes to.
     * @throws IOException
     *             if {@code file} cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.163 -0500", hash_original_method = "B243913791A4955722C7446949980DA0", hash_generated_method = "D6DAF213F6D3B38533FFD8AF2E1BB16E")
    
public FileWriter(File file) throws IOException {
        super(new FileOutputStream(file));
    }

    /**
     * Creates a FileWriter using the File {@code file}. The parameter
     * {@code append} determines whether or not the file is opened and appended
     * to or just opened and overwritten.
     *
     * @param file
     *            the non-null File to write bytes to.
     * @param append
     *            indicates whether or not to append to an existing file.
     * @throws IOException
     *             if the {@code file} cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.166 -0500", hash_original_method = "79860F10C9F09BC3FC3374E75EC2439D", hash_generated_method = "7EFD327773EA8ABA2873A2E9933FED3A")
    
public FileWriter(File file, boolean append) throws IOException {
        super(new FileOutputStream(file, append));
    }

    /**
     * Creates a FileWriter using the existing FileDescriptor {@code fd}.
     *
     * @param fd
     *            the non-null FileDescriptor to write bytes to.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.168 -0500", hash_original_method = "83907072F4E4E17B7331DF75EE7AA617", hash_generated_method = "67AC3D6EBB5AD77899C2BAC092758EA4")
    
public FileWriter(FileDescriptor fd) {
        super(new FileOutputStream(fd));
    }

    /**
     * Creates a FileWriter using the platform dependent {@code filename}.
     *
     * @param filename
     *            the non-null name of the file to write bytes to.
     * @throws IOException
     *             if the file cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.172 -0500", hash_original_method = "7A60608F9C8A66E68FB25FC3BD2DB01D", hash_generated_method = "2434875F8167778129CD26B8C797A068")
    
public FileWriter(String filename) throws IOException {
        super(new FileOutputStream(new File(filename)));
    }

    /**
     * Creates a FileWriter using the platform dependent {@code filename}. The
     * parameter {@code append} determines whether or not the file is opened and
     * appended to or just opened and overwritten.
     *
     * @param filename
     *            the non-null name of the file to write bytes to.
     * @param append
     *            indicates whether or not to append to an existing file.
     * @throws IOException
     *             if the {@code file} cannot be opened for writing.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.174 -0500", hash_original_method = "754E5DA17049F1720720C66817C48E5C", hash_generated_method = "A8E2C54EB46A112F5B8B861711B5F8D6")
    
public FileWriter(String filename, boolean append) throws IOException {
        super(new FileOutputStream(filename, append));
    }
    
}

