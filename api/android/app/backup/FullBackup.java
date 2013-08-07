package android.app.backup;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.342 -0400", hash_original_method = "E56D2C5902E2E32DC49936A701F181C3", hash_generated_method = "E56D2C5902E2E32DC49936A701F181C3")
    public FullBackup ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    static public int backupToTar(String packageName, String domain,
            String linkdomain, String rootpath, String path, BackupDataOutput output) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.BAN)
    static public void restoreFile(ParcelFileDescriptor data,
            long size, int type, long mode, long mtime, File outFile) throws IOException {
        if (type == BackupAgent.TYPE_DIRECTORY) {
            if (outFile != null) outFile.mkdirs();
        } else {
            FileOutputStream out = null;
            try {
                if (outFile != null) {
                    File parent = outFile.getParentFile();
                    if (!parent.exists()) {
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
        if (mode >= 0 && outFile != null) {
            try {
                Libcore.os.chmod(outFile.getPath(), (int)mode);
            } catch (ErrnoException e) {
                e.rethrowAsIOException();
            }
            outFile.setLastModified(mtime);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.344 -0400", hash_original_field = "13FB333B433788822081C4523FB8D4B5", hash_generated_field = "D653D0907C71ABE401F9B043A993232F")

    static final String TAG = "FullBackup";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.344 -0400", hash_original_field = "C5687A82B46906B957C5D35E8BE2DD98", hash_generated_field = "D9775026128515092C93F31EACE9EB8A")

    public static final String APK_TREE_TOKEN = "a";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.344 -0400", hash_original_field = "9763C720BE748535070C8086718B7765", hash_generated_field = "90B28BE334297A0B3D32120A9059DEF3")

    public static final String OBB_TREE_TOKEN = "obb";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.344 -0400", hash_original_field = "9A25415A321699EB26923F88A0F229E7", hash_generated_field = "66C2CCFF3239241B2479A296770C6133")

    public static final String ROOT_TREE_TOKEN = "r";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.344 -0400", hash_original_field = "B9833A9C239339E4B4A0BABF216A5968", hash_generated_field = "1B5FD799214AAF9E8B6BDCBA1FD7456E")

    public static final String DATA_TREE_TOKEN = "f";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "786DDE6ECB3F41E6C88848FB08F80336", hash_generated_field = "FBA35C1A6192AB9994C48D251CAECC02")

    public static final String DATABASE_TREE_TOKEN = "db";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "35758E3EECF6BFBD969E8C094E57C5CC", hash_generated_field = "79960F3BF74B5E9A291F717CA0B701DA")

    public static final String SHAREDPREFS_TREE_TOKEN = "sp";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "144C669D3BD1566E7018A2DE9C57F16F", hash_generated_field = "A96ACAA267817BB1A150AAD1DC613584")

    public static final String CACHE_TREE_TOKEN = "c";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "AEC20611D972915DFD547577E6CB873C", hash_generated_field = "860B8AE14DAB52E7FA17916C477026E5")

    public static final String SHARED_STORAGE_TOKEN = "shared";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "25F41CAFFE686119CD58D2921657F927", hash_generated_field = "7DCEEB367EE72AAAC7F240EC43FA960A")

    public static final String APPS_PREFIX = "apps/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "CBC6244847D58947CB6A498EC87C4632", hash_generated_field = "2192D0DEC5AD60E570C532207FF50390")

    public static final String SHARED_PREFIX = SHARED_STORAGE_TOKEN + "/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "73A3B1671AE261B78B4DC383A4497741", hash_generated_field = "0C934D4C26F9E2BF6DA50A8DB1E9BDFB")

    public static final String FULL_BACKUP_INTENT_ACTION = "fullback";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "DAE11233E8B31534FDC86770D9E74247", hash_generated_field = "444C653AB98B9CF687C1840438401C92")

    public static final String FULL_RESTORE_INTENT_ACTION = "fullrest";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.345 -0400", hash_original_field = "61B8299001860199D5F5177CA2A553D6", hash_generated_field = "8B42D8A2FC8538D2278CBEDF793D4F9D")

    public static final String CONF_TOKEN_INTENT_EXTRA = "conftoken";
}

