package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;




public abstract class AbstractCookieSpec implements CookieSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.525 -0400", hash_original_field = "495FEB68394F20BD9FD7141BB4B46729", hash_generated_field = "25D17092F85E51EF7D67F5963CE29C57")

    private Map<String, CookieAttributeHandler> attribHandlerMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.526 -0400", hash_original_method = "0B3B80B58135DE0CE3912FEB5FB0300B", hash_generated_method = "AD2F0091602CAB4242D76446C8217611")
    public  AbstractCookieSpec() {
        super();
        this.attribHandlerMap = new HashMap<String, CookieAttributeHandler>(10);
        // ---------- Original Method ----------
        //this.attribHandlerMap = new HashMap<String, CookieAttributeHandler>(10);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.526 -0400", hash_original_method = "9190789BDD8DB6BFF150C07D3746174E", hash_generated_method = "CCBD7DF22F4FF56488A395A75FDAD55E")
    public void registerAttribHandler(
            final String name, final CookieAttributeHandler handler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(handler.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException varA390B70006C1E514A593DE2D1F4678FE_1271352135 = new IllegalArgumentException("Attribute name may not be null");
            varA390B70006C1E514A593DE2D1F4678FE_1271352135.addTaint(taint);
            throw varA390B70006C1E514A593DE2D1F4678FE_1271352135;
        } //End block
        if(handler == null)        
        {
            IllegalArgumentException var3E1C6FBDD5FF4F5B7F0BD01CC53EE29B_406822547 = new IllegalArgumentException("Attribute handler may not be null");
            var3E1C6FBDD5FF4F5B7F0BD01CC53EE29B_406822547.addTaint(taint);
            throw var3E1C6FBDD5FF4F5B7F0BD01CC53EE29B_406822547;
        } //End block
        this.attribHandlerMap.put(name, handler);
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Attribute name may not be null");
        //}
        //if (handler == null) {
            //throw new IllegalArgumentException("Attribute handler may not be null");
        //}
        //this.attribHandlerMap.put(name, handler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.527 -0400", hash_original_method = "BCC9FF9C8AB53BB12822345DA7DF2FF0", hash_generated_method = "89291137683F1A7E3BD7616BDD9E27E7")
    protected CookieAttributeHandler findAttribHandler(final String name) {
        addTaint(name.getTaint());
CookieAttributeHandler var7CB6F905BCF04D6249C4063CC6DBE304_748946437 =         this.attribHandlerMap.get(name);
        var7CB6F905BCF04D6249C4063CC6DBE304_748946437.addTaint(taint);
        return var7CB6F905BCF04D6249C4063CC6DBE304_748946437;
        // ---------- Original Method ----------
        //return this.attribHandlerMap.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.527 -0400", hash_original_method = "F6557A039F439C9724E0D7B320BEE361", hash_generated_method = "8058DCB1FE0A33C6E46D593E01CDF160")
    protected CookieAttributeHandler getAttribHandler(final String name) {
        addTaint(name.getTaint());
        CookieAttributeHandler handler = findAttribHandler(name);
        if(handler == null)        
        {
            IllegalStateException var10744B93194C74D7CF3940968F159D2D_35567777 = new IllegalStateException("Handler not registered for " +
                                            name + " attribute.");
            var10744B93194C74D7CF3940968F159D2D_35567777.addTaint(taint);
            throw var10744B93194C74D7CF3940968F159D2D_35567777;
        } //End block
        else
        {
CookieAttributeHandler var3E73215C2EA435E7F052AAB7C8597D27_887618459 =             handler;
            var3E73215C2EA435E7F052AAB7C8597D27_887618459.addTaint(taint);
            return var3E73215C2EA435E7F052AAB7C8597D27_887618459;
        } //End block
        // ---------- Original Method ----------
        //CookieAttributeHandler handler = findAttribHandler(name);
        //if (handler == null) {
            //throw new IllegalStateException("Handler not registered for " +
                                            //name + " attribute.");
        //} else {
            //return handler;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.528 -0400", hash_original_method = "BF6A284618BDB748E6134235BAFA5C45", hash_generated_method = "9BAC6B88A5D4F2DEB2FC693A7CF7188B")
    protected Collection<CookieAttributeHandler> getAttribHandlers() {
Collection<CookieAttributeHandler> var4186A4F29AAD2C613AF1424EC7B20E08_827240114 =         this.attribHandlerMap.values();
        var4186A4F29AAD2C613AF1424EC7B20E08_827240114.addTaint(taint);
        return var4186A4F29AAD2C613AF1424EC7B20E08_827240114;
        // ---------- Original Method ----------
        //return this.attribHandlerMap.values();
    }

    
}

