package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.TimerTask;

public abstract class SIPStackTimerTask extends TimerTask {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.030 -0400", hash_original_method = "CF93C0792FF2A4713A916D013DB0C142", hash_generated_method = "CF93C0792FF2A4713A916D013DB0C142")
    public SIPStackTimerTask ()
    {
        //Synthesized constructor
    }


    protected abstract void runTask();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:46.032 -0400", hash_original_method = "83C0265BCA7923E7BED6DC913E28AE42", hash_generated_method = "B81B556CAB994BDEB0B84F4F8D69A273")
    public final void run() {
        try 
        {
            runTask();
        } //End block
        catch (Throwable e)
        {
            System.out.println("SIP stack timer task failed due to exception:");
            e.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        //try {
            //runTask();
        //} catch (Throwable e) {
            //System.out.println("SIP stack timer task failed due to exception:");
            //e.printStackTrace();
        //}
    }

    
}

