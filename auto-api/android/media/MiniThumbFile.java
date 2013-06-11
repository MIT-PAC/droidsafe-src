package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Hashtable;

public class MiniThumbFile {
    private static final String TAG = "MiniThumbFile";
    private static final int MINI_THUMB_DATA_FILE_VERSION = 3;
    public static final int BYTES_PER_MINTHUMB = 10000;
    private static final int HEADER_SIZE = 1 + 8 + 4;
    private Uri mUri;
    private RandomAccessFile mMiniThumbFile;
    private FileChannel mChannel;
    private ByteBuffer mBuffer;
    private static Hashtable<String, MiniThumbFile> sThumbFiles =
        new Hashtable<String, MiniThumbFile>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.943 -0400", hash_original_method = "4830D2FF2BD59004BFED5BEAD8B6AF84", hash_generated_method = "74465C2FF965081212C3B7DCAEDDFCB6")
    @DSModeled(DSC.SPEC)
    public MiniThumbFile(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        mBuffer = ByteBuffer.allocateDirect(BYTES_PER_MINTHUMB);
        // ---------- Original Method ----------
        //mUri = uri;
        //mBuffer = ByteBuffer.allocateDirect(BYTES_PER_MINTHUMB);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.943 -0400", hash_original_method = "406E9933F616CAE11878C7351DEAD585", hash_generated_method = "5612E90AC2A0FCD08B420C16A3AF337C")
    public static synchronized void reset() {
        for (MiniThumbFile file : sThumbFiles.values()) {
            file.deactivate();
        }
        sThumbFiles.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.943 -0400", hash_original_method = "5B305670FACEB174F31552A2E64ACC73", hash_generated_method = "691D5BFF7915D97850632CDCB0EE5D04")
    public static synchronized MiniThumbFile instance(Uri uri) {
        String type = uri.getPathSegments().get(1);
        MiniThumbFile file = sThumbFiles.get(type);
        if (file == null) {
            file = new MiniThumbFile(
                    Uri.parse("content://media/external/" + type + "/media"));
            sThumbFiles.put(type, file);
        }
        return file;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.943 -0400", hash_original_method = "83138AD8D526C72B89B2911A4A5BD2FA", hash_generated_method = "09988FCB25BE52078BA510C60E72D921")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String randomAccessFilePath(int version) {
        dsTaint.addTaint(version);
        String directoryName;
        directoryName = Environment.getExternalStorageDirectory().toString()
                + "/DCIM/.thumbnails";
        String var44EBE16A7404EFB25841EE4BE1CA9AD0_656780325 = (directoryName + "/.thumbdata" + version + "-" + mUri.hashCode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String directoryName =
                //Environment.getExternalStorageDirectory().toString()
                //+ "/DCIM/.thumbnails";
        //return directoryName + "/.thumbdata" + version + "-" + mUri.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.944 -0400", hash_original_method = "4E94300706FF7803E0D91C5BAD686F7F", hash_generated_method = "5C5DADEA9C2D20A7DBA73AE7817B9639")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeOldFile() {
        String oldPath;
        oldPath = randomAccessFilePath(MINI_THUMB_DATA_FILE_VERSION - 1);
        File oldFile;
        oldFile = new File(oldPath);
        {
            boolean var88BEF3734F90BD3D215E49E71A3A4F88_477484210 = (oldFile.exists());
            {
                try 
                {
                    oldFile.delete();
                } //End block
                catch (SecurityException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String oldPath = randomAccessFilePath(MINI_THUMB_DATA_FILE_VERSION - 1);
        //File oldFile = new File(oldPath);
        //if (oldFile.exists()) {
            //try {
                //oldFile.delete();
            //} catch (SecurityException ex) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.944 -0400", hash_original_method = "E122935DF7BCC080EF63276C2CD73A77", hash_generated_method = "3783FB3931825E628DD0E8F6DDADB24E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private RandomAccessFile miniThumbDataFile() {
        {
            removeOldFile();
            String path;
            path = randomAccessFilePath(MINI_THUMB_DATA_FILE_VERSION);
            File directory;
            directory = new File(path).getParentFile();
            {
                boolean varDBBA05A11B0097FE19B72FF7DC93AD92_1802107817 = (!directory.isDirectory());
                {
                    {
                        boolean varEC961049D3EC60837BB7740BA622CB2E_1893029686 = (!directory.mkdirs());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            File f;
            f = new File(path);
            try 
            {
                mMiniThumbFile = new RandomAccessFile(f, "rw");
            } //End block
            catch (IOException ex)
            {
                try 
                {
                    mMiniThumbFile = new RandomAccessFile(f, "r");
                } //End block
                catch (IOException ex2)
                { }
            } //End block
            {
                mChannel = mMiniThumbFile.getChannel();
            } //End block
        } //End block
        return (RandomAccessFile)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.944 -0400", hash_original_method = "5481B8A4C78F6F60D852A9A55F0BEBDF", hash_generated_method = "CFF36988725DB58589283148BB1EBE22")
    @DSModeled(DSC.SAFE)
    public synchronized void deactivate() {
        {
            try 
            {
                mMiniThumbFile.close();
                mMiniThumbFile = null;
            } //End block
            catch (IOException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mMiniThumbFile != null) {
            //try {
                //mMiniThumbFile.close();
                //mMiniThumbFile = null;
            //} catch (IOException ex) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.944 -0400", hash_original_method = "30677CE09F50871FBAF560D52310B443", hash_generated_method = "40231B96EFF019D663A7D3E24C86ED9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized long getMagic(long id) {
        dsTaint.addTaint(id);
        RandomAccessFile r;
        r = miniThumbDataFile();
        {
            long pos;
            pos = id * BYTES_PER_MINTHUMB;
            FileLock lock;
            lock = null;
            try 
            {
                mBuffer.clear();
                mBuffer.limit(1 + 8);
                lock = mChannel.lock(pos, 1 + 8, true);
                {
                    boolean varE7B823012BF0D48701B8D595640B9818_598478487 = (mChannel.read(mBuffer, pos) == 9);
                    {
                        mBuffer.position(0);
                        {
                            boolean var0836272062E1530D742DC8CDDF565BFE_1589334427 = (mBuffer.get() == 1);
                            {
                                long var955FE7596357A355445D1FFFC2085D80_309730235 = (mBuffer.getLong());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (IOException ex)
            { }
            catch (RuntimeException ex)
            { }
            finally 
            {
                try 
                {
                    lock.release();
                } //End block
                catch (IOException ex)
                { }
            } //End block
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.945 -0400", hash_original_method = "5902848FBDD417107FA8B8FF465E242F", hash_generated_method = "C5C975FE4406E9407D593876AAD41987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void saveMiniThumbToFile(byte[] data, long id, long magic) throws IOException {
        dsTaint.addTaint(id);
        dsTaint.addTaint(magic);
        dsTaint.addTaint(data);
        RandomAccessFile r;
        r = miniThumbDataFile();
        long pos;
        pos = id * BYTES_PER_MINTHUMB;
        FileLock lock;
        lock = null;
        try 
        {
            {
                mBuffer.clear();
                mBuffer.put((byte) 1);
                mBuffer.putLong(magic);
                mBuffer.putInt(data.length);
                mBuffer.put(data);
                mBuffer.flip();
                lock = mChannel.lock(pos, BYTES_PER_MINTHUMB, false);
                mChannel.write(mBuffer, pos);
            } //End block
        } //End block
        catch (IOException ex)
        {
            throw ex;
        } //End block
        catch (RuntimeException ex)
        { }
        finally 
        {
            try 
            {
                lock.release();
            } //End block
            catch (IOException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.945 -0400", hash_original_method = "782DC08BC67342494C7FCB80E02F8475", hash_generated_method = "90BE129B2C1C7521C4B49C9D4D6B72A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized byte [] getMiniThumbFromFile(long id, byte [] data) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(data.dsTaint);
        RandomAccessFile r;
        r = miniThumbDataFile();
        long pos;
        pos = id * BYTES_PER_MINTHUMB;
        FileLock lock;
        lock = null;
        try 
        {
            mBuffer.clear();
            lock = mChannel.lock(pos, BYTES_PER_MINTHUMB, true);
            int size;
            size = mChannel.read(mBuffer, pos);
            {
                mBuffer.position(0);
                byte flag;
                flag = mBuffer.get();
                long magic;
                magic = mBuffer.getLong();
                int length;
                length = mBuffer.getInt();
                {
                    mBuffer.get(data, 0, length);
                } //End block
            } //End block
        } //End block
        catch (IOException ex)
        { }
        catch (RuntimeException ex)
        { }
        finally 
        {
            try 
            {
                lock.release();
            } //End block
            catch (IOException ex)
            { }
        } //End block
        return (byte [])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


