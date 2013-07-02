package android.app.backup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class BackupAgentHelper extends BackupAgent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.394 -0400", hash_original_field = "5C5B05EB15E682152B7155938D6BF50C", hash_generated_field = "60A0C9A2E37C523B1D67C9306AA95150")

    BackupHelperDispatcher mDispatcher = new BackupHelperDispatcher();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.394 -0400", hash_original_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA", hash_generated_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA")
    public BackupAgentHelper ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.394 -0400", hash_original_method = "9A231220123F2F65AC76F55439204202", hash_generated_method = "71A9218ACAB5A27C04DC9719D03E8F4A")
    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException {
        
        mDispatcher.performBackup(oldState, data, newState);
        addTaint(oldState.getTaint());
        addTaint(data.getTaint());
        addTaint(newState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.395 -0400", hash_original_method = "73F73FE661E634DA2EF3458F6B4B1263", hash_generated_method = "3FEE493A9826F3F7AA65EE8E916D0CE8")
    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        
        mDispatcher.performRestore(data, appVersionCode, newState);
        addTaint(data.getTaint());
        addTaint(appVersionCode);
        addTaint(newState.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.395 -0400", hash_original_method = "846FCA7C7B95F7683BAEC473D9697583", hash_generated_method = "B5C819C1D50F4A00152A944C82527AAD")
    public BackupHelperDispatcher getDispatcher() {
        BackupHelperDispatcher varB4EAC82CA7396A68D541C85D26508E83_775410918 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_775410918 = mDispatcher;
        varB4EAC82CA7396A68D541C85D26508E83_775410918.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_775410918;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.396 -0400", hash_original_method = "6BB48EA11B41145F61B4C8931E48479C", hash_generated_method = "2F9323B6D1DBF2BDB4F92B6FC43A984D")
    public void addHelper(String keyPrefix, BackupHelper helper) {
        mDispatcher.addHelper(keyPrefix, helper);
        addTaint(keyPrefix.getTaint());
        addTaint(helper.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.396 -0400", hash_original_field = "209939500077D17CB247B021E7727F6C", hash_generated_field = "20CA2E7D14616BCC61CA084E80B8022D")

    static final String TAG = "BackupAgentHelper";
}

