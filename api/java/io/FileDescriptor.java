package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.STDERR_FILENO;
import static libcore.io.OsConstants.STDIN_FILENO;
import static libcore.io.OsConstants.STDOUT_FILENO;
import libcore.io.ErrnoException;
import libcore.io.Libcore;

public final class FileDescriptor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.698 -0500", hash_original_field = "E31A4FF56F84766C5B153015E99E676F", hash_generated_field = "C19A0692982848458993186E6FD00EBE")

    public static final FileDescriptor in = new FileDescriptor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.701 -0500", hash_original_field = "26797CC20FDB239778A21A461A9F15CC", hash_generated_field = "D147B1CB00E288088DE893A1ECDA0D51")

    public static final FileDescriptor out = new FileDescriptor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.703 -0500", hash_original_field = "AF39EA9AA068638FF8E1E89D52A03B32", hash_generated_field = "B493CA9CC8E849FAF1BEFA5E04A026DF")

    public static final FileDescriptor err = new FileDescriptor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.706 -0500", hash_original_field = "D17F2DEAE17EE032C422372F031D91E8", hash_generated_field = "AD84990C5A466F07845F94B14109703E")

    @DSVAModeled
    private int descriptor = -1;

    /**
     * Constructs a new invalid FileDescriptor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.709 -0500", hash_original_method = "8A46F9D63ACB608022037D6ACF8ADC11", hash_generated_method = "5B6815BD039578BB6C860D2F4455A90B")
    
public FileDescriptor() {
    }

    /**
     * Ensures that data which is buffered within the underlying implementation
     * is written out to the appropriate device before returning.
     */
    @DSComment("Syncing file with storage")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.711 -0500", hash_original_method = "84EEC9A137856593BBF0A90E4A96E319", hash_generated_method = "C8E75F8E8502693FBE5612B9F636D819")
    
public void sync() throws SyncFailedException {
        try {
            Libcore.os.fsync(this);
        } catch (ErrnoException errnoException) {
            SyncFailedException sfe = new SyncFailedException(errnoException.getMessage());
            sfe.initCause(errnoException);
            throw sfe;
        }
    }

    /**
     * Tests whether this {@code FileDescriptor} is valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.714 -0500", hash_original_method = "1AD9601B3D5C4D14896E5C48E725B899", hash_generated_method = "A6433B482C11B2EC76D4DF937E1BCE76")
    
public boolean valid() {
        return toTaintBoolean(descriptor + -1);
    }

    /**
     * Returns the int fd. It's highly unlikely you should be calling this. Please discuss
     * your needs with a libcore maintainer before using this method.
     * @hide internal use only
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.716 -0500", hash_original_method = "4727A8983DC634F09BFA44F7F7F1F8B5", hash_generated_method = "6A3135E10972A8FF55936DA0CD4FC4B8")
    
public final int getInt$() {
        return descriptor;
    }

    /**
     * Sets the int fd. It's highly unlikely you should be calling this. Please discuss
     * your needs with a libcore maintainer before using this method.
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.719 -0500", hash_original_method = "AED03175AA9315DC6552DD5B6FFA10D4", hash_generated_method = "9D60E9F346FE944B7F00CC07F41B99D5")
    
public final void setInt$(int fd) {
        this.descriptor = fd;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.722 -0500", hash_original_method = "EF72FD893497B2D08C59E275939FAD05", hash_generated_method = "4BC44410938B2FB093B4BC89E5428735")
    
@Override public String toString() {
        return "FileDescriptor[" + descriptor + "]";
    }
    static {
        in.descriptor = STDIN_FILENO;
        out.descriptor = STDOUT_FILENO;
        err.descriptor = STDERR_FILENO;
    }
    
}

