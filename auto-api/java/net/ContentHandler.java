package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class ContentHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.748 -0400", hash_original_method = "89B13957F45BA60CB200C5AC69E407EF", hash_generated_method = "89B13957F45BA60CB200C5AC69E407EF")
        public ContentHandler ()
    {
    }


    public abstract Object getContent(URLConnection uConn) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.749 -0400", hash_original_method = "8659195BC6B56411F2DC6C9C918B5FC3", hash_generated_method = "5B545E7C8110883344CA0B0390EFF133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Object getContent(URLConnection uConn, Class[] types) throws IOException {
        dsTaint.addTaint(uConn.dsTaint);
        dsTaint.addTaint(types[0].dsTaint);
        Object content;
        content = getContent(uConn);
        {
            int i;
            i = 0;
            {
                {
                    boolean varD335B318B75970DDE3AA8452F6D1E99A_85754991 = (types[i].isInstance(content));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
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

