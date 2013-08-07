package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;




public class AndroidException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.489 -0400", hash_original_method = "B114E564F5DD3A8162C6B705516D48E4", hash_generated_method = "8C3552774B1B809997CFE9A91843D730")
    public  AndroidException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.489 -0400", hash_original_method = "891590FF533F04EE265F2E23F15D3AEC", hash_generated_method = "A200939A713C215F75B07C58BDF9E469")
    public  AndroidException(String name) {
        super(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.489 -0400", hash_original_method = "B244007C3BAFD44F95BE0B614ABC1B32", hash_generated_method = "63860F47ED8BDB47B0F522340FC68ABA")
    public  AndroidException(String name, Throwable cause) {
        super(name, cause);
        addTaint(cause.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.489 -0400", hash_original_method = "C5375F3D80EA6460B68F9344F734F18D", hash_generated_method = "D38AF2A40FB5D1B4AEF74798B8F510D4")
    public  AndroidException(Exception cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

