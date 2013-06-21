package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.TimerTask;

public abstract class SIPStackTimerTask extends TimerTask {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.712 -0400", hash_original_method = "5609EA825239FE4BDFA4F6ED845AA454", hash_generated_method = "5609EA825239FE4BDFA4F6ED845AA454")
        public SIPStackTimerTask ()
    {
    }


    protected abstract void runTask();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:23.712 -0400", hash_original_method = "83C0265BCA7923E7BED6DC913E28AE42", hash_generated_method = "B81B556CAB994BDEB0B84F4F8D69A273")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

