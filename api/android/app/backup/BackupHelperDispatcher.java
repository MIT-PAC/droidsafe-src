package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class BackupHelperDispatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.084 -0400", hash_original_field = "4D8BD795E1A7491500B2A5C4EA157702", hash_generated_field = "087B9083817AA3054FE76BD13CD55CBF")

    TreeMap<String,BackupHelper> mHelpers = new TreeMap<String,BackupHelper>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.084 -0400", hash_original_method = "85B87DA3FD92CDAA8B7FFA5F20C0A756", hash_generated_method = "AF1A5159B4C616692A2600B7B383730D")
    public  BackupHelperDispatcher() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.085 -0400", hash_original_method = "A8E840254EBF3392B798809BE9F9086F", hash_generated_method = "A047BBD64C879EFF2262D85E46B41350")
    public void addHelper(String keyPrefix, BackupHelper helper) {
        addTaint(helper.getTaint());
        addTaint(keyPrefix.getTaint());
        mHelpers.put(keyPrefix, helper);
        // ---------- Original Method ----------
        //mHelpers.put(keyPrefix, helper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.086 -0400", hash_original_method = "B596D5B1B749A849E47ABD34415972F7", hash_generated_method = "7CC637D21FA3374A3006B573399A2C18")
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException {
        addTaint(newState.getTaint());
        addTaint(data.getTaint());
        addTaint(oldState.getTaint());
        int err;
        Header header = new Header();
        TreeMap<String,BackupHelper> helpers = (TreeMap<String,BackupHelper>)mHelpers.clone();
        FileDescriptor oldStateFD = null;
        FileDescriptor newStateFD = newState.getFileDescriptor();
    if(oldState != null)        
        {
            oldStateFD = oldState.getFileDescriptor();
            while
((err = readHeader_native(header, oldStateFD)) >= 0)            
            {
    if(err == 0)                
                {
                    BackupHelper helper = helpers.get(header.keyPrefix);
                    Log.d(TAG, "handling existing helper '" + header.keyPrefix + "' " + helper);
    if(helper != null)                    
                    {
                        doOneBackup(oldState, data, newState, header, helper);
                        helpers.remove(header.keyPrefix);
                    } //End block
                    else
                    {
                        skipChunk_native(oldStateFD, header.chunkSize);
                    } //End block
                } //End block
            } //End block
        } //End block
for(Map.Entry<String,BackupHelper> entry : helpers.entrySet())
        {
            header.keyPrefix = entry.getKey();
            Log.d(TAG, "handling new helper '" + header.keyPrefix + "'");
            BackupHelper helper = entry.getValue();
            doOneBackup(oldState, data, newState, header, helper);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.087 -0400", hash_original_method = "B20B211F99695DC29EC53BF566272BED", hash_generated_method = "05114B1C8121CBD71802F363493C22EC")
    private void doOneBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState, Header header, BackupHelper helper) throws IOException {
        addTaint(helper.getTaint());
        addTaint(header.getTaint());
        addTaint(newState.getTaint());
        addTaint(data.getTaint());
        addTaint(oldState.getTaint());
        int err;
        FileDescriptor newStateFD = newState.getFileDescriptor();
        int pos = allocateHeader_native(header, newStateFD);
    if(pos < 0)        
        {
            IOException var53BB185CEB30935184BC87E4B10CCF3D_52624052 = new IOException("allocateHeader_native failed (error " + pos + ")");
            var53BB185CEB30935184BC87E4B10CCF3D_52624052.addTaint(taint);
            throw var53BB185CEB30935184BC87E4B10CCF3D_52624052;
        } //End block
        data.setKeyPrefix(header.keyPrefix);
        helper.performBackup(oldState, data, newState);
        err = writeHeader_native(header, newStateFD, pos);
    if(err != 0)        
        {
            IOException var38E2598B011FF54A88CF76CE0BDC81B6_450546637 = new IOException("writeHeader_native failed (error " + err + ")");
            var38E2598B011FF54A88CF76CE0BDC81B6_450546637.addTaint(taint);
            throw var38E2598B011FF54A88CF76CE0BDC81B6_450546637;
        } //End block
        // ---------- Original Method ----------
        //int err;
        //FileDescriptor newStateFD = newState.getFileDescriptor();
        //int pos = allocateHeader_native(header, newStateFD);
        //if (pos < 0) {
            //throw new IOException("allocateHeader_native failed (error " + pos + ")");
        //}
        //data.setKeyPrefix(header.keyPrefix);
        //helper.performBackup(oldState, data, newState);
        //err = writeHeader_native(header, newStateFD, pos);
        //if (err != 0) {
            //throw new IOException("writeHeader_native failed (error " + err + ")");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.089 -0400", hash_original_method = "5D2E23956580E2A3306D4050F8218E29", hash_generated_method = "1DFB267EC009BBE50DCA3E664A7D995F")
    public void performRestore(BackupDataInput input, int appVersionCode,
            ParcelFileDescriptor newState) throws IOException {
        addTaint(newState.getTaint());
        addTaint(appVersionCode);
        addTaint(input.getTaint());
        boolean alreadyComplained = false;
        BackupDataInputStream stream = new BackupDataInputStream(input);
        while
(input.readNextHeader())        
        {
            String rawKey = input.getKey();
            int pos = rawKey.indexOf(':');
    if(pos > 0)            
            {
                String prefix = rawKey.substring(0, pos);
                BackupHelper helper = mHelpers.get(prefix);
    if(helper != null)                
                {
                    stream.dataSize = input.getDataSize();
                    stream.key = rawKey.substring(pos+1);
                    helper.restoreEntity(stream);
                } //End block
                else
                {
    if(!alreadyComplained)                    
                    {
                        alreadyComplained = true;
                    } //End block
                } //End block
            } //End block
            else
            {
    if(!alreadyComplained)                
                {
                    alreadyComplained = true;
                } //End block
            } //End block
            input.skipEntityData();
        } //End block
for(BackupHelper helper : mHelpers.values())
        {
            helper.writeNewStateDescription(newState);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static int readHeader_native(Header h, FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int skipChunk_native(FileDescriptor fd, int bytesToSkip) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int allocateHeader_native(Header h, FileDescriptor fd) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int writeHeader_native(Header h, FileDescriptor fd, int pos) {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static class Header {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.092 -0400", hash_original_field = "00255DCB7E7FE62F3DD8ED38644CC3EE", hash_generated_field = "8D4654446C9DD3E766BE07B4267F3234")

        int chunkSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.092 -0400", hash_original_field = "061552BCB5DC79075A2C9D6092A18D63", hash_generated_field = "A9486E3C3418813783566D03E4768EE1")

        String keyPrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.092 -0400", hash_original_method = "7DC9F4B0B6F0B6B866C998FD2825EB34", hash_generated_method = "7DC9F4B0B6F0B6B866C998FD2825EB34")
        public Header ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.092 -0400", hash_original_field = "D8CE60F5D7395BB05B4D07D8557ECD02", hash_generated_field = "AEF462BF91D0B416E4E3B66437F12C41")

    private static final String TAG = "BackupHelperDispatcher";
}

