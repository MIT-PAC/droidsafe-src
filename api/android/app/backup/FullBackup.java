package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import libcore.io.ErrnoException;
import libcore.io.Libcore;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import droidsafe.helpers.DSUtils;

public class FullBackup {
    
    static public int backupToTar(String packageName, String domain,
            String linkdomain, String rootpath, String path, BackupDataOutput output) {
        return DSUtils.UNKNOWN_INT;
    }

    /**
     * Copy data from a socket to the given File location on permanent storage.  The
     * modification time and access mode of the resulting file will be set if desired.
     * If the {@code type} parameter indicates that the result should be a directory,
     * the socket parameter may be {@code null}; even if it is valid, no data will be
     * read from it in this case.
     * <p>
     * If the {@code mode} argument is negative, then the resulting output file will not
     * have its access mode or last modification time reset as part of this operation.
     *
     * @param data Socket supplying the data to be copied to the output file.  If the
     *    output is a directory, this may be {@code null}.
     * @param size Number of bytes of data to copy from the socket to the file.  At least
     *    this much data must be available through the {@code data} parameter.
     * @param type Must be either {@link BackupAgent#TYPE_FILE} for ordinary file data
     *    or {@link BackupAgent#TYPE_DIRECTORY} for a directory.
     * @param mode Unix-style file mode (as used by the chmod(2) syscall) to be set on
     *    the output file or directory.  If this parameter is negative then neither
     *    the mode nor the mtime parameters will be used.
     * @param mtime A timestamp in the standard Unix epoch that will be imposed as the
     *    last modification time of the output file.  if the {@code mode} parameter is
     *    negative then this parameter will be ignored.
     * @param outFile Location within the filesystem to place the data.  This must point
     *    to a location that is writeable by the caller, prefereably using an absolute path.
     * @throws IOException
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.889 -0500", hash_original_method = "F9DFB08D12B24563CC8422B4E7125730", hash_generated_method = "961888451F126DE9730D91AC31697FB8")
    
static public void restoreFile(ParcelFileDescriptor data,
            long size, int type, long mode, long mtime, File outFile) throws IOException {
        if (type == BackupAgent.TYPE_DIRECTORY) {
            // Canonically a directory has no associated content, so we don't need to read
            // anything from the pipe in this case.  Just create the directory here and
            // drop down to the final metadata adjustment.
            if (outFile != null) outFile.mkdirs();
        } else {
            FileOutputStream out = null;

            // Pull the data from the pipe, copying it to the output file, until we're done
            try {
                if (outFile != null) {
                    File parent = outFile.getParentFile();
                    if (!parent.exists()) {
                        // in practice this will only be for the default semantic directories,
                        // and using the default mode for those is appropriate.
                        // TODO: support the edge case of apps that have adjusted the
                        //       permissions on these core directories
                        parent.mkdirs();
                    }
                    out = new FileOutputStream(outFile);
                }
            } catch (IOException e) {
                Log.e(TAG, "Unable to create/open file " + outFile.getPath(), e);
            }

            byte[] buffer = new byte[32 * 1024];
            final long origSize = size;
            FileInputStream in = new FileInputStream(data.getFileDescriptor());
            while (size > 0) {
                int toRead = (size > buffer.length) ? buffer.length : (int)size;
                int got = in.read(buffer, 0, toRead);
                if (got <= 0) {
                    Log.w(TAG, "Incomplete read: expected " + size + " but got "
                            + (origSize - size));
                    break;
                }
                if (out != null) {
                    try {
                        out.write(buffer, 0, got);
                    } catch (IOException e) {
                        // Problem writing to the file.  Quit copying data and delete
                        // the file, but of course keep consuming the input stream.
                        Log.e(TAG, "Unable to write to file " + outFile.getPath(), e);
                        out.close();
                        out = null;
                        outFile.delete();
                    }
                }
                size -= got;
            }
            if (out != null) out.close();
        }

        // Now twiddle the state to match the backup, assuming all went well
        if (mode >= 0 && outFile != null) {
            try {
                Libcore.os.chmod(outFile.getPath(), (int)mode);
            } catch (ErrnoException e) {
                e.rethrowAsIOException();
            }
            outFile.setLastModified(mtime);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.849 -0500", hash_original_field = "6EAD3247AD828AB3EB69FAFCFAC6E406", hash_generated_field = "D653D0907C71ABE401F9B043A993232F")

    static final String TAG = "FullBackup";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.852 -0500", hash_original_field = "E981F008616A41D7B878F9DA4901677A", hash_generated_field = "D9775026128515092C93F31EACE9EB8A")

    public static final String APK_TREE_TOKEN = "a";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.855 -0500", hash_original_field = "2A9E375BE89669169722BE08618E63CB", hash_generated_field = "90B28BE334297A0B3D32120A9059DEF3")

    public static final String OBB_TREE_TOKEN = "obb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.857 -0500", hash_original_field = "A8B6B4FFAF6B3964549F9710425CF2FC", hash_generated_field = "66C2CCFF3239241B2479A296770C6133")

    public static final String ROOT_TREE_TOKEN = "r";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.859 -0500", hash_original_field = "6DFFC1D0D29CBF6FED7459AD907C5F3E", hash_generated_field = "1B5FD799214AAF9E8B6BDCBA1FD7456E")

    public static final String DATA_TREE_TOKEN = "f";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.862 -0500", hash_original_field = "2D5A603A8FB8F0499DDC6971987D4B0D", hash_generated_field = "FBA35C1A6192AB9994C48D251CAECC02")

    public static final String DATABASE_TREE_TOKEN = "db";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.864 -0500", hash_original_field = "68C413504BA120C3708C16F8E9A6167D", hash_generated_field = "79960F3BF74B5E9A291F717CA0B701DA")

    public static final String SHAREDPREFS_TREE_TOKEN = "sp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.867 -0500", hash_original_field = "DE4CA414E08DE87865202FD42EE7B368", hash_generated_field = "A96ACAA267817BB1A150AAD1DC613584")

    public static final String CACHE_TREE_TOKEN = "c";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.869 -0500", hash_original_field = "CBCBEC1E425B632F698D2730C01BF5C1", hash_generated_field = "860B8AE14DAB52E7FA17916C477026E5")

    public static final String SHARED_STORAGE_TOKEN = "shared";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.871 -0500", hash_original_field = "9C21CE9E7A9A477D6B1975B75A5C889D", hash_generated_field = "7DCEEB367EE72AAAC7F240EC43FA960A")

    public static final String APPS_PREFIX = "apps/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.874 -0500", hash_original_field = "C2C3EC43B5EFA052B973C553DE7E6945", hash_generated_field = "2192D0DEC5AD60E570C532207FF50390")

    public static final String SHARED_PREFIX = SHARED_STORAGE_TOKEN + "/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.876 -0500", hash_original_field = "C1B1D83D86932E8CF5C70391F3C5801E", hash_generated_field = "0C934D4C26F9E2BF6DA50A8DB1E9BDFB")

    public static final String FULL_BACKUP_INTENT_ACTION = "fullback";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.879 -0500", hash_original_field = "E327DF17FB89028FE18E002BED29CDE7", hash_generated_field = "444C653AB98B9CF687C1840438401C92")

    public static final String FULL_RESTORE_INTENT_ACTION = "fullrest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:46.881 -0500", hash_original_field = "CDB6B24DBB38D9F2025A06DC29B41BC0", hash_generated_field = "8B42D8A2FC8538D2278CBEDF793D4F9D")

    public static final String CONF_TOKEN_INTENT_EXTRA = "conftoken";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.342 -0400", hash_original_method = "E56D2C5902E2E32DC49936A701F181C3", hash_generated_method = "E56D2C5902E2E32DC49936A701F181C3")
    public FullBackup ()
    {
        //Synthesized constructor
    }
}

