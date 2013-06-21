package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class JsPromptResult extends JsResult {
    private String mStringResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.439 -0400", hash_original_method = "7ABE9E090B5E64D2572624CACEEEAFE1", hash_generated_method = "3966BAE2B0006C604C64596F0B646BAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     JsPromptResult(CallbackProxy proxy) {
        super(proxy,  false);
        dsTaint.addTaint(proxy.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.439 -0400", hash_original_method = "50CD500D47F4FCEE0A0F59D7183F0AD5", hash_generated_method = "3B72039511D080C619C6A09E93BDB537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void confirm(String result) {
        dsTaint.addTaint(result);
        confirm();
        // ---------- Original Method ----------
        //mStringResult = result;
        //confirm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.439 -0400", hash_original_method = "A6887DA895C48DFEB95F5B019D028B73", hash_generated_method = "BDF1EDB94B9AB06F4A28A5B62DA92FD5")
    @DSModeled(DSC.SAFE)
     String getStringResult() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mStringResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.439 -0400", hash_original_method = "7194C2D571222CB4C5E996180C4D4F3B", hash_generated_method = "63C08C99E3E2D2689D64ACA29B63B2FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void handleDefault() {
        mStringResult = null;
        super.handleDefault();
        // ---------- Original Method ----------
        //mStringResult = null;
        //super.handleDefault();
    }

    
}

