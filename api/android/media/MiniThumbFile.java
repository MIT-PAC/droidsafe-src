package android.media;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.915 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.915 -0400", hash_original_field = "F590AE2A201D4D46CE15025972479F20", hash_generated_field = "6942619B577F803005D0A8BCAC39742B")

    private RandomAccessFile mMiniThumbFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.915 -0400", hash_original_field = "8E934369C1BCE6316A2C1FFFF8C383AB", hash_generated_field = "21533EA1492ED640DA73CD4394BCA694")

    private FileChannel mChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.915 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "FABD0AE272C28D49511B5C6B44D8F85C")

    private ByteBuffer mBuffer;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.916 -0400", hash_original_method = "4830D2FF2BD59004BFED5BEAD8B6AF84", hash_generated_method = "434CCADDBD0B76ADF3CB67EA4913C9CF")
    public  MiniThumbFile(Uri uri) {
        mUri = uri;
        mBuffer = ByteBuffer.allocateDirect(BYTES_PER_MINTHUMB);
        // ---------- Original Method ----------
        //mUri = uri;
        //mBuffer = ByteBuffer.allocateDirect(BYTES_PER_MINTHUMB);
    }

    
    @DSModeled(DSC.BAN)
    public static synchronized void reset() {
        for (MiniThumbFile file : sThumbFiles.values()) {
            file.deactivate();
        }
        sThumbFiles.clear();
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.917 -0400", hash_original_method = "83138AD8D526C72B89B2911A4A5BD2FA", hash_generated_method = "5C9BD13618A08FCFAC24D7DC7E2851C8")
    private String randomAccessFilePath(int version) {
        addTaint(version);
        String directoryName = Environment.getExternalStorageDirectory().toString()
                + "/DCIM/.thumbnails";
String var2C0F3AB1B0D21A590BACE6375CC48A8C_1086855637 =         directoryName + "/.thumbdata" + version + "-" + mUri.hashCode();
        var2C0F3AB1B0D21A590BACE6375CC48A8C_1086855637.addTaint(taint);
        return var2C0F3AB1B0D21A590BACE6375CC48A8C_1086855637;
        // ---------- Original Method ----------
        //String directoryName =
                //Environment.getExternalStorageDirectory().toString()
                //+ "/DCIM/.thumbnails";
        //return directoryName + "/.thumbdata" + version + "-" + mUri.hashCode();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.918 -0400", hash_original_method = "4E94300706FF7803E0D91C5BAD686F7F", hash_generated_method = "5FE508C1BC818E3186F2070544F07133")
    private void removeOldFile() {
        String oldPath = randomAccessFilePath(MINI_THUMB_DATA_FILE_VERSION - 1);
        File oldFile = new File(oldPath);
        if(oldFile.exists())        
        {
            try 
            {
                oldFile.delete();
            } //End block
            catch (SecurityException ex)
            {
            } //End block
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.919 -0400", hash_original_method = "E122935DF7BCC080EF63276C2CD73A77", hash_generated_method = "76FE9256F4504A6A4F6E7CE779A3CE5A")
    private RandomAccessFile miniThumbDataFile() {
        if(mMiniThumbFile == null)        
        {
            removeOldFile();
            String path = randomAccessFilePath(MINI_THUMB_DATA_FILE_VERSION);
            File directory = new File(path).getParentFile();
            if(!directory.isDirectory())            
            {
                if(!directory.mkdirs())                
                {
                } //End block
            } //End block
            File f = new File(path);
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
                {
                } //End block
            } //End block
            if(mMiniThumbFile != null)            
            {
                mChannel = mMiniThumbFile.getChannel();
            } //End block
        } //End block
RandomAccessFile var1F0510D6271C21B4187DB92369D83034_1373015443 =         mMiniThumbFile;
        var1F0510D6271C21B4187DB92369D83034_1373015443.addTaint(taint);
        return var1F0510D6271C21B4187DB92369D83034_1373015443;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.921 -0400", hash_original_method = "5481B8A4C78F6F60D852A9A55F0BEBDF", hash_generated_method = "572CF4CC775C35D5575054915D3E69DB")
    public synchronized void deactivate() {
        if(mMiniThumbFile != null)        
        {
            try 
            {
                mMiniThumbFile.close();
                mMiniThumbFile = null;
            } //End block
            catch (IOException ex)
            {
            } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.923 -0400", hash_original_method = "30677CE09F50871FBAF560D52310B443", hash_generated_method = "A96AC93692D2F711AB3D7098B20B317A")
    public synchronized long getMagic(long id) {
        addTaint(id);
        RandomAccessFile r = miniThumbDataFile();
        if(r != null)        
        {
            long pos = id * BYTES_PER_MINTHUMB;
            FileLock lock = null;
            try 
            {
                mBuffer.clear();
                mBuffer.limit(1 + 8);
                lock = mChannel.lock(pos, 1 + 8, true);
                if(mChannel.read(mBuffer, pos) == 9)                
                {
                    mBuffer.position(0);
                    if(mBuffer.get() == 1)                    
                    {
                        long var00F7E8AE2FDB978A6568A2BB56443028_1638401568 = (mBuffer.getLong());
                                                long var0F5264038205EDFB1AC05FBB0E8C5E94_143341342 = getTaintLong();
                        return var0F5264038205EDFB1AC05FBB0E8C5E94_143341342;
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
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_1719964485 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_440134769 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_440134769;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.928 -0400", hash_original_method = "5902848FBDD417107FA8B8FF465E242F", hash_generated_method = "CD42F22EB95DA067935FCCB7C7D10608")
    public synchronized void saveMiniThumbToFile(byte[] data, long id, long magic) throws IOException {
        addTaint(magic);
        addTaint(id);
        addTaint(data[0]);
        RandomAccessFile r = miniThumbDataFile();
        if(r == null)        
        return;
        long pos = id * BYTES_PER_MINTHUMB;
        FileLock lock = null;
        try 
        {
            if(data != null)            
            {
                if(data.length > BYTES_PER_MINTHUMB - HEADER_SIZE)                
                {
                    return;
                } //End block
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
            ex.addTaint(taint);
            throw ex;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.497 -0400", hash_original_method = "782DC08BC67342494C7FCB80E02F8475", hash_generated_method = "7C8D42E961B65A1320F67311EEB7BE11")
    public synchronized byte [] getMiniThumbFromFile(long id, byte [] data) {
        addTaint(data[0]);
        addTaint(id);
        RandomAccessFile r = miniThumbDataFile();
    if(r == null)        
        {
byte [] var540C13E9E156B687226421B24F2DF178_980742372 =         null;
        var540C13E9E156B687226421B24F2DF178_980742372.addTaint(taint);
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
                    var0C8B2C9585EB05DD9CD70726CF8CBC07_1955523150.addTaint(taint);
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
        var540C13E9E156B687226421B24F2DF178_1109737605.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1109737605;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.931 -0400", hash_original_field = "C8450948555749F5FE13C8F28BBE7C08", hash_generated_field = "CD8AD02F08A41EB0631E9AAD285208E6")

    private static final String TAG = "MiniThumbFile";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.931 -0400", hash_original_field = "DDF360DB307EAB1833283A8893617959", hash_generated_field = "E22EA0D619B63C46FD5F63771A2AB710")

    private static final int MINI_THUMB_DATA_FILE_VERSION = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.931 -0400", hash_original_field = "C7B7DB5EA8C2F3B6CE5EAEC24DCFAB38", hash_generated_field = "2C05F23AE6C4F6148D555E6D9902E712")

    public static final int BYTES_PER_MINTHUMB = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.932 -0400", hash_original_field = "D7F2EC05AB6107738CD04336F67FD4F2", hash_generated_field = "61842B245C0280EBD97E2B486B70844B")

    private static final int HEADER_SIZE = 1 + 8 + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.932 -0400", hash_original_field = "FA41C2125983D33E2FE38E281EA883BF", hash_generated_field = "1F13138A6603A9B7BA01A576B836EE49")

    private static Hashtable<String, MiniThumbFile> sThumbFiles = new Hashtable<String, MiniThumbFile>();
}

