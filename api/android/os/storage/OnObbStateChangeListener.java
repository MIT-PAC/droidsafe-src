package android.os.storage;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class OnObbStateChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.900 -0500", hash_original_field = "0FA8F94F6F155CFFF48E555DB5861E69", hash_generated_field = "72AB3A6E0714445A3E8F5C7F68917D4B")

    public static final int MOUNTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.902 -0500", hash_original_field = "7E26218A2C3282104E4E4BA9C13E1C24", hash_generated_field = "8B8E5D59CBB553514192DE4B107D2B82")

    public static final int UNMOUNTED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.904 -0500", hash_original_field = "645C9814279908B285BEC1287424295A", hash_generated_field = "E024DBAF733AE115525C186A76F8C907")

    public static final int ERROR_INTERNAL = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.906 -0500", hash_original_field = "EDDDFE548525B10B25ADF85993910F3E", hash_generated_field = "997E81BD7B647C96FDBE8D686C3874E3")

    public static final int ERROR_COULD_NOT_MOUNT = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.909 -0500", hash_original_field = "716B374BD1641EFA89372CEB6C13477B", hash_generated_field = "E0ACDABE054BCBC9AF1B07F7F0719007")

    public static final int ERROR_COULD_NOT_UNMOUNT = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.911 -0500", hash_original_field = "E8305E09AAB69420B54D72288CF7C9DD", hash_generated_field = "6F7B0C7A290524BBBB4FDD7FB6BD7F35")

    public static final int ERROR_NOT_MOUNTED = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.913 -0500", hash_original_field = "B347EFDE46B9EEA308A543EF34C0BE24", hash_generated_field = "FAE45D5C26A59084E2805F664C3A8C08")

    public static final int ERROR_ALREADY_MOUNTED = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.916 -0500", hash_original_field = "726A47721BCD176BE141F637BC4B3241", hash_generated_field = "E567FC4BC1A01330A0E2973C07A311E5")

    public static final int ERROR_PERMISSION_DENIED = 25;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.020 -0400", hash_original_method = "67C83AF74DC57D0B71995A60795CAB4A", hash_generated_method = "67C83AF74DC57D0B71995A60795CAB4A")
    public OnObbStateChangeListener ()
    {
        //Synthesized constructor
    }

    /**
     * Called when an OBB has changed states.
     * 
     * @param path path to the OBB file the state change has happened on
     * @param state the current state of the OBB
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:33.918 -0500", hash_original_method = "8D4DBCB92EE624B36C1D9B80653BEEEA", hash_generated_method = "2B7F988CEDF2A109C681D39B5CE213CF")
    
public void onObbStateChange(String path, int state) {
    }
}

