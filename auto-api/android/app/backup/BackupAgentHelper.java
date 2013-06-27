package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class BackupAgentHelper extends BackupAgent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.337 -0400", hash_original_field = "5C5B05EB15E682152B7155938D6BF50C", hash_generated_field = "60A0C9A2E37C523B1D67C9306AA95150")

    BackupHelperDispatcher mDispatcher = new BackupHelperDispatcher();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.337 -0400", hash_original_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA", hash_generated_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA")
    public BackupAgentHelper ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.340 -0400", hash_original_method = "9A231220123F2F65AC76F55439204202", hash_generated_method = "71A9218ACAB5A27C04DC9719D03E8F4A")
    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mDispatcher.performBackup(oldState, data, newState);
        addTaint(oldState.getTaint());
        addTaint(data.getTaint());
        addTaint(newState.getTaint());
        // ---------- Original Method ----------
        //mDispatcher.performBackup(oldState, data, newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.345 -0400", hash_original_method = "73F73FE661E634DA2EF3458F6B4B1263", hash_generated_method = "3FEE493A9826F3F7AA65EE8E916D0CE8")
    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mDispatcher.performRestore(data, appVersionCode, newState);
        addTaint(data.getTaint());
        addTaint(appVersionCode);
        addTaint(newState.getTaint());
        // ---------- Original Method ----------
        //mDispatcher.performRestore(data, appVersionCode, newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.350 -0400", hash_original_method = "846FCA7C7B95F7683BAEC473D9697583", hash_generated_method = "0FCE14A03114231DFF0D0B5D8800CDBC")
    public BackupHelperDispatcher getDispatcher() {
        BackupHelperDispatcher varB4EAC82CA7396A68D541C85D26508E83_885468719 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_885468719 = mDispatcher;
        varB4EAC82CA7396A68D541C85D26508E83_885468719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_885468719;
        // ---------- Original Method ----------
        //return mDispatcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.352 -0400", hash_original_method = "6BB48EA11B41145F61B4C8931E48479C", hash_generated_method = "2F9323B6D1DBF2BDB4F92B6FC43A984D")
    public void addHelper(String keyPrefix, BackupHelper helper) {
        mDispatcher.addHelper(keyPrefix, helper);
        addTaint(keyPrefix.getTaint());
        addTaint(helper.getTaint());
        // ---------- Original Method ----------
        //mDispatcher.addHelper(keyPrefix, helper);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.363 -0400", hash_original_field = "209939500077D17CB247B021E7727F6C", hash_generated_field = "8AAE7B87279AE05999D62FAD935DCC2B")

    static String TAG = "BackupAgentHelper";
}

