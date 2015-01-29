package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Hashtable;

import android.net.Uri;
import android.os.Environment;

public class MiniThumbFile {

    /**
     * We store different types of thumbnails in different files. To remain backward compatibility,
     * we should hashcode of content://media/external/images/media remains the same.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.633 -0500", hash_original_method = "406E9933F616CAE11878C7351DEAD585", hash_generated_method = "5612E90AC2A0FCD08B420C16A3AF337C")
    
public static synchronized void reset() {
        for (MiniThumbFile file : sThumbFiles.values()) {
            file.deactivate();
        }
        sThumbFiles.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.636 -0500", hash_original_method = "3117C5735547D90DD2DA797C976402DD", hash_generated_method = "004AE318B12920B27086113D5B155CF8")
    
public static synchronized MiniThumbFile instance(Uri uri) {
        String type = uri.getPathSegments().get(1);
        MiniThumbFile file = sThumbFiles.get(type);
        // Log.v(TAG, "get minithumbfile for type: "+type);
        if (file == null) {
            file = new MiniThumbFile(
                    Uri.parse("content://media/external/" + type + "/media"));
            sThumbFiles.put(type, file);
        }

        return file;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.611 -0500", hash_original_field = "40B8CD86D19B0F52134F69FF681DB6E7", hash_generated_field = "CD8AD02F08A41EB0631E9AAD285208E6")

    private static final String TAG = "MiniThumbFile";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.613 -0500", hash_original_field = "75C9016C43E97463E9FFBC00A13EA84C", hash_generated_field = "E22EA0D619B63C46FD5F63771A2AB710")

    private static final int MINI_THUMB_DATA_FILE_VERSION = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.617 -0500", hash_original_field = "7F7158A5BF659C491E59AE0172B26A8A", hash_generated_field = "2C05F23AE6C4F6148D555E6D9902E712")

    public static final int BYTES_PER_MINTHUMB = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.619 -0500", hash_original_field = "4B107458E2C636CAD8D5BB87F867D003", hash_generated_field = "61842B245C0280EBD97E2B486B70844B")

    private static final int HEADER_SIZE = 1 + 8 + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.631 -0500", hash_original_field = "AF9193530490187A6B311BB2C09B3FB9", hash_generated_field = "1F13138A6603A9B7BA01A576B836EE49")

    private static Hashtable<String, MiniThumbFile> sThumbFiles =
        new Hashtable<String, MiniThumbFile>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.622 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.624 -0500", hash_original_field = "5915874BECC9BABAE7E7BA8E3CFB18E7", hash_generated_field = "6942619B577F803005D0A8BCAC39742B")

    private RandomAccessFile mMiniThumbFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.626 -0500", hash_original_field = "84F35CC67E3145EBB66512E045605FAF", hash_generated_field = "21533EA1492ED640DA73CD4394BCA694")

    private FileChannel mChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.628 -0500", hash_original_field = "FB05545F4651BAFFFA13E88DBDCA5C94", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

    private ByteBuffer mBuffer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.647 -0500", hash_original_method = "4830D2FF2BD59004BFED5BEAD8B6AF84", hash_generated_method = "72FD2B2BEBE24E3E45A9B7CBDD46665C")
    
public MiniThumbFile(Uri uri) {
        mUri = uri;
        mBuffer = ByteBuffer.allocateDirect(BYTES_PER_MINTHUMB);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.639 -0500", hash_original_method = "83138AD8D526C72B89B2911A4A5BD2FA", hash_generated_method = "4CB412C2AFF8D733ECCC919F6E9E6475")
    
private String randomAccessFilePath(int version) {
        String directoryName =
                Environment.getExternalStorageDirectory().toString()
                + "/DCIM/.thumbnails";
        return directoryName + "/.thumbdata" + version + "-" + mUri.hashCode();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.642 -0500", hash_original_method = "4E94300706FF7803E0D91C5BAD686F7F", hash_generated_method = "31375A94467FF330F26E364A8D609E47")
    
private void removeOldFile() {
        String oldPath = randomAccessFilePath(MINI_THUMB_DATA_FILE_VERSION - 1);
        File oldFile = new File(oldPath);
        if (oldFile.exists()) {
            try {
                oldFile.delete();
            } catch (SecurityException ex) {
                // ignore
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.644 -0500", hash_original_method = "E122935DF7BCC080EF63276C2CD73A77", hash_generated_method = "66493D3D6EA63703E235423E2859C881")
    
private RandomAccessFile miniThumbDataFile() {
        if (mMiniThumbFile == null) {
            removeOldFile();
            String path = randomAccessFilePath(MINI_THUMB_DATA_FILE_VERSION);
            File directory = new File(path).getParentFile();
            if (!directory.isDirectory()) {
                if (!directory.mkdirs()) {
                    Log.e(TAG, "Unable to create .thumbnails directory "
                            + directory.toString());
                }
            }
            File f = new File(path);
            try {
                mMiniThumbFile = new RandomAccessFile(f, "rw");
            } catch (IOException ex) {
                // Open as read-only so we can at least read the existing
                // thumbnails.
                try {
                    mMiniThumbFile = new RandomAccessFile(f, "r");
                } catch (IOException ex2) {
                    // ignore exception
                }
            }
            if (mMiniThumbFile != null) {
                mChannel = mMiniThumbFile.getChannel();
            }
        }
        return mMiniThumbFile;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.650 -0500", hash_original_method = "5481B8A4C78F6F60D852A9A55F0BEBDF", hash_generated_method = "21A459D1EC8190E7C316A3D38056F4D8")
    
public synchronized void deactivate() {
        if (mMiniThumbFile != null) {
            try {
                mMiniThumbFile.close();
                mMiniThumbFile = null;
            } catch (IOException ex) {
                // ignore exception
            }
        }
    }

    // Get the magic number for the specified id in the mini-thumb file.
    // Returns 0 if the magic is not available.
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.653 -0500", hash_original_method = "30677CE09F50871FBAF560D52310B443", hash_generated_method = "8AEC188DF61CA3E360164AAD85C9F391")
    
public synchronized long getMagic(long id) {
        // check the mini thumb file for the right data.  Right is
        // defined as having the right magic number at the offset
        // reserved for this "id".
        RandomAccessFile r = miniThumbDataFile();
        if (r != null) {
            long pos = id * BYTES_PER_MINTHUMB;
            FileLock lock = null;
            try {
                mBuffer.clear();
                mBuffer.limit(1 + 8);

                lock = mChannel.lock(pos, 1 + 8, true);
                // check that we can read the following 9 bytes
                // (1 for the "status" and 8 for the long)
                if (mChannel.read(mBuffer, pos) == 9) {
                    mBuffer.position(0);
                    if (mBuffer.get() == 1) {
                        return mBuffer.getLong();
                    }
                }
            } catch (IOException ex) {
                Log.v(TAG, "Got exception checking file magic: ", ex);
            } catch (RuntimeException ex) {
                // Other NIO related exception like disk full, read only channel..etc
                Log.e(TAG, "Got exception when reading magic, id = " + id +
                        ", disk full or mount read-only? " + ex.getClass());
            } finally {
                try {
                    if (lock != null) lock.release();
                }
                catch (IOException ex) {
                    // ignore it.
                }
            }
        }
        return 0;
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.656 -0500", hash_original_method = "5902848FBDD417107FA8B8FF465E242F", hash_generated_method = "1A502B4458D5771C05867BD5F635DFF1")
    
public synchronized void saveMiniThumbToFile(byte[] data, long id, long magic)
            throws IOException {
        RandomAccessFile r = miniThumbDataFile();
        if (r == null) return;

        long pos = id * BYTES_PER_MINTHUMB;
        FileLock lock = null;
        try {
            if (data != null) {
                if (data.length > BYTES_PER_MINTHUMB - HEADER_SIZE) {
                    // not enough space to store it.
                    return;
                }
                mBuffer.clear();
                mBuffer.put((byte) 1);
                mBuffer.putLong(magic);
                mBuffer.putInt(data.length);
                mBuffer.put(data);
                mBuffer.flip();

                lock = mChannel.lock(pos, BYTES_PER_MINTHUMB, false);
                mChannel.write(mBuffer, pos);
            }
        } catch (IOException ex) {
            Log.e(TAG, "couldn't save mini thumbnail data for "
                    + id + "; ", ex);
            throw ex;
        } catch (RuntimeException ex) {
            // Other NIO related exception like disk full, read only channel..etc
            Log.e(TAG, "couldn't save mini thumbnail data for "
                    + id + "; disk full or mount read-only? " + ex.getClass());
        } finally {
            try {
                if (lock != null) lock.release();
            }
            catch (IOException ex) {
                // ignore it.
            }
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.497 -0400", hash_original_method = "782DC08BC67342494C7FCB80E02F8475", hash_generated_method = "7C8D42E961B65A1320F67311EEB7BE11")
    public synchronized byte [] getMiniThumbFromFile(long id, byte [] data) {
        addTaint(data[0]);
        addTaint(id);
        RandomAccessFile r = miniThumbDataFile();
    if(r == null)        
        {
byte [] var540C13E9E156B687226421B24F2DF178_980742372 =         null;
        var540C13E9E156B687226421B24F2DF178_980742372.addTaint(getTaint());
        return var540C13E9E156B687226421B24F2DF178_980742372;
        }
        long pos = id * BYTES_PER_MINTHUMB;
        FileLock lock = null;
        try 
        {
            mBuffer.clear();
            lock = mChannel.lock(pos, BYTES_PER_MINTHUMB, true);
            int size = mChannel.read(mBuffer, pos);
    if(size > 1 + 8 + 4)            
            {
                mBuffer.position(0);
                byte flag = mBuffer.get();
                long magic = mBuffer.getLong();
                int length = mBuffer.getInt();
    if(size >= 1 + 8 + 4 + length && data.length >= length)                
                {
                    mBuffer.get(data, 0, length);
byte [] var0C8B2C9585EB05DD9CD70726CF8CBC07_1955523150 =                     data;
                    var0C8B2C9585EB05DD9CD70726CF8CBC07_1955523150.addTaint(getTaint());
                    return var0C8B2C9585EB05DD9CD70726CF8CBC07_1955523150;
                } //End block
            } //End block
        } //End block
        catch (IOException ex)
        {
        } //End block
        catch (RuntimeException ex)
        {
        } //End block
        finally 
        {
            try 
            {
    if(lock != null)                
                lock.release();
            } //End block
            catch (IOException ex)
            {
            } //End block
        } //End block
byte [] var540C13E9E156B687226421B24F2DF178_1109737605 =         null;
        var540C13E9E156B687226421B24F2DF178_1109737605.addTaint(getTaint());
        return var540C13E9E156B687226421B24F2DF178_1109737605;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
}

