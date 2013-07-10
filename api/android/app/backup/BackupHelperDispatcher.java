package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class BackupHelperDispatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.471 -0400", hash_original_field = "4D8BD795E1A7491500B2A5C4EA157702", hash_generated_field = "087B9083817AA3054FE76BD13CD55CBF")

    TreeMap<String,BackupHelper> mHelpers = new TreeMap<String,BackupHelper>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.471 -0400", hash_original_method = "85B87DA3FD92CDAA8B7FFA5F20C0A756", hash_generated_method = "AF1A5159B4C616692A2600B7B383730D")
    public  BackupHelperDispatcher() {
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.472 -0400", hash_original_method = "A8E840254EBF3392B798809BE9F9086F", hash_generated_method = "7B83DF092E62F8C626E9B0E2446ED0B9")
    public void addHelper(String keyPrefix, BackupHelper helper) {
        mHelpers.put(keyPrefix, helper);
        addTaint(keyPrefix.getTaint());
        addTaint(helper.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.488 -0400", hash_original_method = "B596D5B1B749A849E47ABD34415972F7", hash_generated_method = "CAAE0B8A78ADBA92F795438664C3BFBE")
    public void performBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException {
        int err;
        Header header = new Header();
        TreeMap<String,BackupHelper> helpers = (TreeMap<String,BackupHelper>)mHelpers.clone();
        FileDescriptor oldStateFD = null;
        FileDescriptor newStateFD = newState.getFileDescriptor();
        {
            oldStateFD = oldState.getFileDescriptor();
            {
                boolean var6A636B5AEF3C8A8E30DD984F443C1E5D_178022757 = ((err = readHeader_native(header, oldStateFD)) >= 0);
                {
                    {
                        BackupHelper helper = helpers.get(header.keyPrefix);
                        Log.d(TAG, "handling existing helper '" + header.keyPrefix + "' " + helper);
                        {
                            doOneBackup(oldState, data, newState, header, helper);
                            helpers.remove(header.keyPrefix);
                        } 
                        {
                            skipChunk_native(oldStateFD, header.chunkSize);
                        } 
                    } 
                } 
            } 
        } 
        {
            Iterator<Map.Entry<String,BackupHelper>> var0B59813E1691BC5DECEA622019E15EDD_1976637648 = (helpers.entrySet()).iterator();
            var0B59813E1691BC5DECEA622019E15EDD_1976637648.hasNext();
            Map.Entry<String,BackupHelper> entry = var0B59813E1691BC5DECEA622019E15EDD_1976637648.next();
            {
                header.keyPrefix = entry.getKey();
                Log.d(TAG, "handling new helper '" + header.keyPrefix + "'");
                BackupHelper helper = entry.getValue();
                doOneBackup(oldState, data, newState, header, helper);
            } 
        } 
        addTaint(oldState.getTaint());
        addTaint(data.getTaint());
        addTaint(newState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.489 -0400", hash_original_method = "B20B211F99695DC29EC53BF566272BED", hash_generated_method = "746A4BCCB5810BF638B028FE6F73562B")
    private void doOneBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
            ParcelFileDescriptor newState, Header header, BackupHelper helper) throws IOException {
        int err;
        FileDescriptor newStateFD = newState.getFileDescriptor();
        int pos = allocateHeader_native(header, newStateFD);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("allocateHeader_native failed (error " + pos + ")");
        } 
        data.setKeyPrefix(header.keyPrefix);
        helper.performBackup(oldState, data, newState);
        err = writeHeader_native(header, newStateFD, pos);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("writeHeader_native failed (error " + err + ")");
        } 
        addTaint(oldState.getTaint());
        addTaint(data.getTaint());
        addTaint(newState.getTaint());
        addTaint(header.getTaint());
        addTaint(helper.getTaint());
        
        
        
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.505 -0400", hash_original_method = "5D2E23956580E2A3306D4050F8218E29", hash_generated_method = "946416893C9048889F9A6CD0D65F3529")
    public void performRestore(BackupDataInput input, int appVersionCode,
            ParcelFileDescriptor newState) throws IOException {
        boolean alreadyComplained = false;
        BackupDataInputStream stream = new BackupDataInputStream(input);
        {
            boolean varB2EEE1D51C4B54A685FC1C06A688C48D_521955852 = (input.readNextHeader());
            {
                String rawKey = input.getKey();
                int pos = rawKey.indexOf(':');
                {
                    String prefix = rawKey.substring(0, pos);
                    BackupHelper helper = mHelpers.get(prefix);
                    {
                        stream.dataSize = input.getDataSize();
                        stream.key = rawKey.substring(pos+1);
                        helper.restoreEntity(stream);
                    } 
                    {
                        {
                            alreadyComplained = true;
                        } 
                    } 
                } 
                {
                    {
                        alreadyComplained = true;
                    } 
                } 
                input.skipEntityData();
            } 
        } 
        {
            Iterator<BackupHelper> varD91491A680A3BCA4793E5DC911971BC9_1959071758 = (mHelpers.values()).iterator();
            varD91491A680A3BCA4793E5DC911971BC9_1959071758.hasNext();
            BackupHelper helper = varD91491A680A3BCA4793E5DC911971BC9_1959071758.next();
            {
                helper.writeNewStateDescription(newState);
            } 
        } 
        addTaint(input.getTaint());
        addTaint(appVersionCode);
        addTaint(newState.getTaint());
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.507 -0400", hash_original_field = "00255DCB7E7FE62F3DD8ED38644CC3EE", hash_generated_field = "8D4654446C9DD3E766BE07B4267F3234")

        int chunkSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.507 -0400", hash_original_field = "061552BCB5DC79075A2C9D6092A18D63", hash_generated_field = "A9486E3C3418813783566D03E4768EE1")

        String keyPrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.507 -0400", hash_original_method = "7DC9F4B0B6F0B6B866C998FD2825EB34", hash_generated_method = "7DC9F4B0B6F0B6B866C998FD2825EB34")
        public Header ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.507 -0400", hash_original_field = "D8CE60F5D7395BB05B4D07D8557ECD02", hash_generated_field = "AEF462BF91D0B416E4E3B66437F12C41")

    private static final String TAG = "BackupHelperDispatcher";
}

