package android.nfc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;

public final class NfcManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.196 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "ED79E91C532F555A55D38CC488E317EF")

    private NfcAdapter mAdapter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.197 -0400", hash_original_method = "5612BA010CEBE1CDB104E5EE130CB87B", hash_generated_method = "C814310DA6C1045426BA808D96D99D59")
    public  NfcManager(Context context) {
        NfcAdapter adapter;
        context = context.getApplicationContext();
        try 
        {
            adapter = NfcAdapter.getNfcAdapter(context);
        } 
        catch (UnsupportedOperationException e)
        {
            adapter = null;
        } 
        mAdapter = adapter;
        addTaint(context.getTaint());
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.198 -0400", hash_original_method = "4CC1396725247CE50C996383E5F907DD", hash_generated_method = "DE58A586A1BE34EFF4CDABAD052A272D")
    public NfcAdapter getDefaultAdapter() {
        NfcAdapter varB4EAC82CA7396A68D541C85D26508E83_1287417403 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1287417403 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1287417403.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1287417403;
        
        
    }

    
}

