package android.app.backup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class BackupAgentHelper extends BackupAgent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.140 -0400", hash_original_field = "5C5B05EB15E682152B7155938D6BF50C", hash_generated_field = "60A0C9A2E37C523B1D67C9306AA95150")

    BackupHelperDispatcher mDispatcher = new BackupHelperDispatcher();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.140 -0400", hash_original_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA", hash_generated_method = "DE5015AA9AF8D8BEBF76E2231F1F38FA")
    public BackupAgentHelper ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.141 -0400", hash_original_method = "9A231220123F2F65AC76F55439204202", hash_generated_method = "94C4FB5263DC8C53CA8D454B602BC996")
    @Override
    public void onBackup(ParcelFileDescriptor oldState, BackupDataOutput data,
             ParcelFileDescriptor newState) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newState.getTaint());
        addTaint(data.getTaint());
        addTaint(oldState.getTaint());
        mDispatcher.performBackup(oldState, data, newState);
        // ---------- Original Method ----------
        //mDispatcher.performBackup(oldState, data, newState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.142 -0400", hash_original_method = "73F73FE661E634DA2EF3458F6B4B1263", hash_generated_method = "473B3536DE7FF73FF42F5E2800F5B3A4")
    @Override
    public void onRestore(BackupDataInput data, int appVersionCode, ParcelFileDescriptor newState) throws IOException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newState.getTaint());
        addTaint(appVersionCode);
        addTaint(data.getTaint());
        mDispatcher.performRestore(data, appVersionCode, newState);
        // ---------- Original Method ----------
        //mDispatcher.performRestore(data, appVersionCode, newState);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.142 -0400", hash_original_method = "846FCA7C7B95F7683BAEC473D9697583", hash_generated_method = "CC6A80FE307316D8A1286EE020094397")
    public BackupHelperDispatcher getDispatcher() {
BackupHelperDispatcher var5DF19C452CAB59A9933C6AED8DEC3FBC_1671345947 =         mDispatcher;
        var5DF19C452CAB59A9933C6AED8DEC3FBC_1671345947.addTaint(taint);
        return var5DF19C452CAB59A9933C6AED8DEC3FBC_1671345947;
        // ---------- Original Method ----------
        //return mDispatcher;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.143 -0400", hash_original_method = "6BB48EA11B41145F61B4C8931E48479C", hash_generated_method = "0A5193F4F434B18414B86FFA41590D8B")
    public void addHelper(String keyPrefix, BackupHelper helper) {
        addTaint(helper.getTaint());
        addTaint(keyPrefix.getTaint());
        mDispatcher.addHelper(keyPrefix, helper);
        // ---------- Original Method ----------
        //mDispatcher.addHelper(keyPrefix, helper);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.143 -0400", hash_original_field = "209939500077D17CB247B021E7727F6C", hash_generated_field = "20CA2E7D14616BCC61CA084E80B8022D")

    static final String TAG = "BackupAgentHelper";
}

