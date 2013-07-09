package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class JsPromptResult extends JsResult {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.985 -0400", hash_original_field = "65BF78F49160CC97E406FB54EDF293C3", hash_generated_field = "EBA696E93844251FD8576C3F0CF71EE9")

    private String mStringResult;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.985 -0400", hash_original_method = "7ABE9E090B5E64D2572624CACEEEAFE1", hash_generated_method = "8482E21BC86D549D4718F6ABD385F17B")
      JsPromptResult(CallbackProxy proxy) {
        super(proxy,  false);
        addTaint(proxy.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.985 -0400", hash_original_method = "50CD500D47F4FCEE0A0F59D7183F0AD5", hash_generated_method = "4CEF0CC5E6D014FBB66CFBE927095099")
    public void confirm(String result) {
        mStringResult = result;
        confirm();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.986 -0400", hash_original_method = "A6887DA895C48DFEB95F5B019D028B73", hash_generated_method = "E73D290A4C60961A6BD4AE61AD0CCB3F")
     String getStringResult() {
        String varB4EAC82CA7396A68D541C85D26508E83_1902675282 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1902675282 = mStringResult;
        varB4EAC82CA7396A68D541C85D26508E83_1902675282.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1902675282;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.986 -0400", hash_original_method = "7194C2D571222CB4C5E996180C4D4F3B", hash_generated_method = "63C08C99E3E2D2689D64ACA29B63B2FF")
    @Override
     void handleDefault() {
        mStringResult = null;
        super.handleDefault();
        
        
        
    }

    
}

