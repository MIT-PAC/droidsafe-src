package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;

public class BackupDataInput {
    int mBackupReader;
    private EntityHeader mHeader = new EntityHeader();
    private boolean mHeaderReady;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.722 -0400", hash_original_method = "582DAD329BBA9C3EE75CD90B1E443D9B", hash_generated_method = "07645964CC5B617EC743854A83133C55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackupDataInput(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        mBackupReader = ctor(fd);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Native initialization failed with fd=" + fd);
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) throw new NullPointerException();
        //mBackupReader = ctor(fd);
        //if (mBackupReader == 0) {
            //throw new RuntimeException("Native initialization failed with fd=" + fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.723 -0400", hash_original_method = "CC531F2C344F6B5BB4BC1EC54E3B5D76", hash_generated_method = "A564916A20D514B6CEBFCF02B6F4CC72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() throws Throwable {
        try 
        {
            dtor(mBackupReader);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //dtor(mBackupReader);
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.723 -0400", hash_original_method = "8876EC04BE968489185903B1495A889A", hash_generated_method = "45C09B405806ABDC813ACBBFFC7BD6E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean readNextHeader() throws IOException {
        int result;
        result = readNextHeader_native(mBackupReader, mHeader);
        {
            mHeaderReady = true;
        } //End block
        {
            mHeaderReady = false;
        } //End block
        {
            mHeaderReady = false;
            if (DroidSafeAndroidRuntime.control) throw new IOException("failed: 0x" + Integer.toHexString(result));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int result = readNextHeader_native(mBackupReader, mHeader);
        //if (result == 0) {
            //mHeaderReady = true;
            //return true;
        //} else if (result > 0) {
            //mHeaderReady = false;
            //return false;
        //} else {
            //mHeaderReady = false;
            //throw new IOException("failed: 0x" + Integer.toHexString(result));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.726 -0400", hash_original_method = "32914A2DCD27EDE5CD7416010D683812", hash_generated_method = "D15C880102F111A7F564F6BE7505A0D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getKey() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //return mHeader.key;
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.728 -0400", hash_original_method = "98B39A84BCE4F82002DB111D375A2105", hash_generated_method = "B740EE97F45523366098CF56A70F868A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDataSize() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //return mHeader.dataSize;
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.730 -0400", hash_original_method = "E6FF3430BADFF1BEAFD149782FA6CB07", hash_generated_method = "C44DDFDE44F891397D495C6F79D76745")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readEntityData(byte[] data, int offset, int size) throws IOException {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(size);
        {
            int result;
            result = readEntityData_native(mBackupReader, data, offset, size);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("result=0x" + Integer.toHexString(result));
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //int result = readEntityData_native(mBackupReader, data, offset, size);
            //if (result >= 0) {
                //return result;
            //} else {
                //throw new IOException("result=0x" + Integer.toHexString(result));
            //}
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.731 -0400", hash_original_method = "785DF45E42B32B78A3E788F04C2081B3", hash_generated_method = "2DE37E179F5DFBBFCC99691C85BA4EA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void skipEntityData() throws IOException {
        {
            skipEntityData_native(mBackupReader);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Entity header not read");
        } //End block
        // ---------- Original Method ----------
        //if (mHeaderReady) {
            //skipEntityData_native(mBackupReader);
        //} else {
            //throw new IllegalStateException("Entity header not read");
        //}
    }

    
        private static int ctor(FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void dtor(int mBackupReader) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.735 -0400", hash_original_method = "067EEAAC3A307CF566E8560CEDE5923E", hash_generated_method = "227440F59A404C093A1A3057D9F4152F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readNextHeader_native(int mBackupReader, EntityHeader entity) {
        dsTaint.addTaint(entity.dsTaint);
        dsTaint.addTaint(mBackupReader);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.735 -0400", hash_original_method = "F563013799B99B7F96D96C08DD61A38F", hash_generated_method = "1ECEAC12D615E4A9BD29CB64745610C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readEntityData_native(int mBackupReader, byte[] data, int offset, int size) {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(mBackupReader);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(size);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.735 -0400", hash_original_method = "13C96EB578BECC22D2FF8487AD4702B6", hash_generated_method = "F97936981B16D58B162130DA18E690BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int skipEntityData_native(int mBackupReader) {
        dsTaint.addTaint(mBackupReader);
        return dsTaint.getTaintInt();
    }

    
    private static class EntityHeader {
        String key;
        int dataSize;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.736 -0400", hash_original_method = "0492877BD1A4F88089F2FC0C57B9E304", hash_generated_method = "0492877BD1A4F88089F2FC0C57B9E304")
                public EntityHeader ()
        {
        }


    }


    
}

