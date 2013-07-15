package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class ContentHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.479 -0400", hash_original_method = "34235149EC6F1F14A33FF6A78502D340", hash_generated_method = "34235149EC6F1F14A33FF6A78502D340")
    public ContentHandler ()
    {
        //Synthesized constructor
    }


    public abstract Object getContent(URLConnection uConn) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.480 -0400", hash_original_method = "8659195BC6B56411F2DC6C9C918B5FC3", hash_generated_method = "F9BF668C9276FDCE94BAB3489AF1F26B")
    @SuppressWarnings("unchecked")
    public Object getContent(URLConnection uConn, Class[] types) throws IOException {
        addTaint(types[0].getTaint());
        addTaint(uConn.getTaint());
        Object content = getContent(uConn);
for(int i = 0;i < types.length;i++)
        {
    if(types[i].isInstance(content))            
            {
Object varD442C91479410F76C84B872DA6AAE139_1305453201 =                 content;
                varD442C91479410F76C84B872DA6AAE139_1305453201.addTaint(taint);
                return varD442C91479410F76C84B872DA6AAE139_1305453201;
            } //End block
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1061965971 =         null;
        var540C13E9E156B687226421B24F2DF178_1061965971.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1061965971;
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

