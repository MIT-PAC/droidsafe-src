package android.app.backup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;

import droidsafe.helpers.DSUtils;

public class BackupDataInput {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int ctor(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void dtor(int mBackupReader) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.887 -0500", hash_original_field = "EDA18C2AC17158AC38AD184085CE67B9", hash_generated_field = "EDA18C2AC17158AC38AD184085CE67B9")

    int mBackupReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.889 -0500", hash_original_field = "9AD750C29E704355D9FBFD7F116111B5", hash_generated_field = "09487E77E28DE2A84CA8495B9D491E4C")

    private EntityHeader mHeader = new EntityHeader();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.892 -0500", hash_original_field = "CD7987B8E176B0A798F349F334CBA4F7", hash_generated_field = "DDC1B46C787D236D68304697B8C07639")

    private boolean mHeaderReady;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.902 -0500", hash_original_method = "582DAD329BBA9C3EE75CD90B1E443D9B", hash_generated_method = "E32900915B2BD90DA47E6E2505788540")
    
public BackupDataInput(FileDescriptor fd) {
        if (fd == null) throw new NullPointerException();
        mBackupReader = ctor(fd);
        if (mBackupReader == 0) {
            throw new RuntimeException("Native initialization failed with fd=" + fd);
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.904 -0500", hash_original_method = "CC531F2C344F6B5BB4BC1EC54E3B5D76", hash_generated_method = "D52E7A0AF44ED50AF850B2C6E2ED8701")
    
protected void finalize() throws Throwable {
        try {
            dtor(mBackupReader);
        } finally {
            super.finalize();
        }
    }

    /**
     * Extract the next entity header from the restore stream.  After this method
     * return success, the {@link #getKey()} and {@link #getDataSize()} methods can
     * be used to inspect the entity that is now available for processing.
     *
     * @return <code>true</code> when there is an entity ready for consumption from the
     *    restore stream, <code>false</code> if the restore stream has been fully consumed.
     * @throws IOException if an error occurred while reading the restore stream
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.906 -0500", hash_original_method = "8876EC04BE968489185903B1495A889A", hash_generated_method = "1BFE0A1BA71649A1AF47D5AC3D94240F")
    
public boolean readNextHeader() throws IOException {
        int result = readNextHeader_native(mBackupReader, mHeader);
        if (result == 0) {
            // read successfully
            mHeaderReady = true;
            return true;
        } else if (result > 0) {
            // done
            mHeaderReady = false;
            return false;
        } else {
            // error
            mHeaderReady = false;
            throw new IOException("failed: 0x" + Integer.toHexString(result));
        }
    }

    /**
     * Report the key associated with the current entity in the restore stream
     * @return the current entity's key string
     * @throws IllegalStateException if the next record header has not yet been read
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.909 -0500", hash_original_method = "32914A2DCD27EDE5CD7416010D683812", hash_generated_method = "94A49A84F5FA78DF906CF35F12E563B5")
    
public String getKey() {
        if (mHeaderReady) {
            return mHeader.key;
        } else {
            throw new IllegalStateException("Entity header not read");
        }
    }

    /**
     * Report the size in bytes of the data associated with the current entity in the
     * restore stream.
     *
     * @return The size of the record's raw data, in bytes
     * @throws IllegalStateException if the next record header has not yet been read
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.911 -0500", hash_original_method = "98B39A84BCE4F82002DB111D375A2105", hash_generated_method = "B05050FF734E888147555784F56BEBCB")
    
public int getDataSize() {
        if (mHeaderReady) {
            return mHeader.dataSize;
        } else {
            throw new IllegalStateException("Entity header not read");
        }
    }

    /**
     * Read a record's raw data from the restore stream.  The record's header must first
     * have been processed by the {@link #readNextHeader()} method.  Multiple calls to
     * this method may be made in order to process the data in chunks; not all of it
     * must be read in a single call.  Once all of the raw data for the current entity
     * has been read, further calls to this method will simply return zero.
     *
     * @param data An allocated byte array of at least 'size' bytes
     * @param offset Offset within the 'data' array at which the data will be placed
     *    when read from the stream
     * @param size The number of bytes to read in this pass
     * @return The number of bytes of data read.  Once all of the data for this entity
     *    has been read, further calls to this method will return zero.
     * @throws IOException if an error occurred when trying to read the restore data stream
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.914 -0500", hash_original_method = "E6FF3430BADFF1BEAFD149782FA6CB07", hash_generated_method = "59C9B714AA6091C6C9DF5F1E9D70EE88")
    
public int readEntityData(byte[] data, int offset, int size) throws IOException {
        if (mHeaderReady) {
            int result = readEntityData_native(mBackupReader, data, offset, size);
            if (result >= 0) {
                return result;
            } else {
                throw new IOException("result=0x" + Integer.toHexString(result));
            }
        } else {
            throw new IllegalStateException("Entity header not read");
        }
    }

    /**
     * Consume the current entity's data without extracting it into a buffer
     * for further processing.  This allows a {@link android.app.backup.BackupAgent} to
     * efficiently discard obsolete or otherwise uninteresting records during the
     * restore operation.
     * 
     * @throws IOException if an error occurred when trying to read the restore data stream
     */
    @DSComment("Backup subsystem")
    @DSSpec(DSCat.BACKUP_SUBSYSTEM)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.916 -0500", hash_original_method = "785DF45E42B32B78A3E788F04C2081B3", hash_generated_method = "81CAA9E1074A9F87741022D5401C5DA3")
    
public void skipEntityData() throws IOException {
        if (mHeaderReady) {
            skipEntityData_native(mBackupReader);
        } else {
            throw new IllegalStateException("Entity header not read");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.929 -0500", hash_original_method = "067EEAAC3A307CF566E8560CEDE5923E", hash_generated_method = "3BE778386736586B8497FE8482ACAEE2")
    
    private int readNextHeader_native(int mBackupReader, EntityHeader entity){
    	//Formerly a native method
    	addTaint(mBackupReader);
    	addTaint(entity.getTaint());
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.933 -0500", hash_original_method = "F563013799B99B7F96D96C08DD61A38F", hash_generated_method = "6DBF246326CF816325CD3E3CF7B4B7EF")
    
    private int readEntityData_native(int mBackupReader, byte[] data, int offset, int size){
    	//Formerly a native method
    	addTaint(mBackupReader);
    	addTaint(data[0]);
    	addTaint(offset);
    	addTaint(size);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.937 -0500", hash_original_method = "13C96EB578BECC22D2FF8487AD4702B6", hash_generated_method = "059C8CBE1AA90B948C011431FA8DE540")
    
    private int skipEntityData_native(int mBackupReader){
    	//Formerly a native method
    	addTaint(mBackupReader);
    	return getTaintInt();
    }
    
    private static class EntityHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.895 -0500", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "FFE7EE17DFA37A68070A0F0495753B29")

        String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:45.897 -0500", hash_original_field = "BE50627D89367B94B26C95254370D367", hash_generated_field = "BE50627D89367B94B26C95254370D367")

        int dataSize;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.173 -0400", hash_original_method = "0CA45CB3FD81751EFF77E1E1D96ACA74", hash_generated_method = "0CA45CB3FD81751EFF77E1E1D96ACA74")
        public EntityHeader ()
        {
            //Synthesized constructor
        }

    }
    
}

