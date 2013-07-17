package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class JsPromptResult extends JsResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.236 -0400", hash_original_field = "65BF78F49160CC97E406FB54EDF293C3", hash_generated_field = "EBA696E93844251FD8576C3F0CF71EE9")

    private String mStringResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.236 -0400", hash_original_method = "7ABE9E090B5E64D2572624CACEEEAFE1", hash_generated_method = "8482E21BC86D549D4718F6ABD385F17B")
      JsPromptResult(CallbackProxy proxy) {
        super(proxy,  false);
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.237 -0400", hash_original_method = "50CD500D47F4FCEE0A0F59D7183F0AD5", hash_generated_method = "4CEF0CC5E6D014FBB66CFBE927095099")
    public void confirm(String result) {
        mStringResult = result;
        confirm();
        // ---------- Original Method ----------
        //mStringResult = result;
        //confirm();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.238 -0400", hash_original_method = "A6887DA895C48DFEB95F5B019D028B73", hash_generated_method = "5986DA7E42E7ABFB8D5FAB4FD76A7FDC")
     String getStringResult() {
String var86F3C154467D7E7BC817481671B1E976_230254339 =         mStringResult;
        var86F3C154467D7E7BC817481671B1E976_230254339.addTaint(taint);
        return var86F3C154467D7E7BC817481671B1E976_230254339;
        // ---------- Original Method ----------
        //return mStringResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.239 -0400", hash_original_method = "7194C2D571222CB4C5E996180C4D4F3B", hash_generated_method = "63C08C99E3E2D2689D64ACA29B63B2FF")
    @Override
     void handleDefault() {
        mStringResult = null;
        super.handleDefault();
        // ---------- Original Method ----------
        //mStringResult = null;
        //super.handleDefault();
    }

    
}

