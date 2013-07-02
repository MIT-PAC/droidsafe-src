package android.os.storage;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class OnObbStateChangeListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_method = "67C83AF74DC57D0B71995A60795CAB4A", hash_generated_method = "67C83AF74DC57D0B71995A60795CAB4A")
    public OnObbStateChangeListener ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_method = "8D4DBCB92EE624B36C1D9B80653BEEEA", hash_generated_method = "E6C0C687AA94AEBED94DE2777E36583A")
    public void onObbStateChange(String path, int state) {
        
        addTaint(path.getTaint());
        addTaint(state);
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "6BBA526C384F5A544398C878475D913D", hash_generated_field = "72AB3A6E0714445A3E8F5C7F68917D4B")

    public static final int MOUNTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "9F9F3625F2AF2DD05AC436895C8D30CC", hash_generated_field = "8B8E5D59CBB553514192DE4B107D2B82")

    public static final int UNMOUNTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "C28CE8EB2DDD2CDF1307A635B22AB90D", hash_generated_field = "E024DBAF733AE115525C186A76F8C907")

    public static final int ERROR_INTERNAL = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "C1E26F2B4F17E36C2B1819840E9BE0F6", hash_generated_field = "997E81BD7B647C96FDBE8D686C3874E3")

    public static final int ERROR_COULD_NOT_MOUNT = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "BB4806FDADDD85F626968082E0EED599", hash_generated_field = "E0ACDABE054BCBC9AF1B07F7F0719007")

    public static final int ERROR_COULD_NOT_UNMOUNT = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "1B1104E1FB3F2279D7B2EE0D336654AA", hash_generated_field = "6F7B0C7A290524BBBB4FDD7FB6BD7F35")

    public static final int ERROR_NOT_MOUNTED = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "A3216311DEDCE3AC6180EB4960C98051", hash_generated_field = "FAE45D5C26A59084E2805F664C3A8C08")

    public static final int ERROR_ALREADY_MOUNTED = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.594 -0400", hash_original_field = "D20B3D24EF1BC17C47CFFD54EC50118C", hash_generated_field = "E567FC4BC1A01330A0E2973C07A311E5")

    public static final int ERROR_PERMISSION_DENIED = 25;
}

