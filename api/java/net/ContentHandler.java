package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class ContentHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.311 -0400", hash_original_method = "34235149EC6F1F14A33FF6A78502D340", hash_generated_method = "34235149EC6F1F14A33FF6A78502D340")
    public ContentHandler ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract Object getContent(URLConnection uConn) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.312 -0400", hash_original_method = "8659195BC6B56411F2DC6C9C918B5FC3", hash_generated_method = "6A257C485467202AD44E19FA7C9FC62D")
    @SuppressWarnings("unchecked")
    public Object getContent(URLConnection uConn, Class[] types) throws IOException {
        addTaint(types[0].getTaint());
        addTaint(uConn.getTaint());
        Object content = getContent(uConn);
for(int i = 0;i < types.length;i++)
        {
            if(types[i].isInstance(content))            
            {
Object varD442C91479410F76C84B872DA6AAE139_841645560 =                 content;
                varD442C91479410F76C84B872DA6AAE139_841645560.addTaint(taint);
                return varD442C91479410F76C84B872DA6AAE139_841645560;
            } //End block
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1057333194 =         null;
        var540C13E9E156B687226421B24F2DF178_1057333194.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1057333194;
        // ---------- Original Method ----------
        //Object content = getContent(uConn);
        //for (int i = 0; i < types.length; i++) {
            //if (types[i].isInstance(content)) {
                //return content;
            //}
        //}
        //return null;
    }

    
}

