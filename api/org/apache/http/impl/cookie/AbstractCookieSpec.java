package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

public abstract class AbstractCookieSpec implements CookieSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.205 -0400", hash_original_field = "495FEB68394F20BD9FD7141BB4B46729", hash_generated_field = "25D17092F85E51EF7D67F5963CE29C57")

    private Map<String, CookieAttributeHandler> attribHandlerMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.205 -0400", hash_original_method = "0B3B80B58135DE0CE3912FEB5FB0300B", hash_generated_method = "AD2F0091602CAB4242D76446C8217611")
    public  AbstractCookieSpec() {
        super();
        this.attribHandlerMap = new HashMap<String, CookieAttributeHandler>(10);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.206 -0400", hash_original_method = "9190789BDD8DB6BFF150C07D3746174E", hash_generated_method = "B40031AD9E591D23DA381AC54E960013")
    public void registerAttribHandler(
            final String name, final CookieAttributeHandler handler) {
        
        addTaint(handler.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException varA390B70006C1E514A593DE2D1F4678FE_1753277672 = new IllegalArgumentException("Attribute name may not be null");
            varA390B70006C1E514A593DE2D1F4678FE_1753277672.addTaint(taint);
            throw varA390B70006C1E514A593DE2D1F4678FE_1753277672;
        } 
    if(handler == null)        
        {
            IllegalArgumentException var3E1C6FBDD5FF4F5B7F0BD01CC53EE29B_1974665883 = new IllegalArgumentException("Attribute handler may not be null");
            var3E1C6FBDD5FF4F5B7F0BD01CC53EE29B_1974665883.addTaint(taint);
            throw var3E1C6FBDD5FF4F5B7F0BD01CC53EE29B_1974665883;
        } 
        this.attribHandlerMap.put(name, handler);
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.206 -0400", hash_original_method = "BCC9FF9C8AB53BB12822345DA7DF2FF0", hash_generated_method = "771D2672809655808439C348D7949D4E")
    protected CookieAttributeHandler findAttribHandler(final String name) {
        addTaint(name.getTaint());
CookieAttributeHandler var7CB6F905BCF04D6249C4063CC6DBE304_415983569 =         this.attribHandlerMap.get(name);
        var7CB6F905BCF04D6249C4063CC6DBE304_415983569.addTaint(taint);
        return var7CB6F905BCF04D6249C4063CC6DBE304_415983569;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.207 -0400", hash_original_method = "F6557A039F439C9724E0D7B320BEE361", hash_generated_method = "C76EBF9B276FF927305E4CD84EBDD48D")
    protected CookieAttributeHandler getAttribHandler(final String name) {
        addTaint(name.getTaint());
        CookieAttributeHandler handler = findAttribHandler(name);
    if(handler == null)        
        {
            IllegalStateException var10744B93194C74D7CF3940968F159D2D_1137728493 = new IllegalStateException("Handler not registered for " +
                                            name + " attribute.");
            var10744B93194C74D7CF3940968F159D2D_1137728493.addTaint(taint);
            throw var10744B93194C74D7CF3940968F159D2D_1137728493;
        } 
        else
        {
CookieAttributeHandler var3E73215C2EA435E7F052AAB7C8597D27_1378687607 =             handler;
            var3E73215C2EA435E7F052AAB7C8597D27_1378687607.addTaint(taint);
            return var3E73215C2EA435E7F052AAB7C8597D27_1378687607;
        } 
        
        
        
            
                                            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.207 -0400", hash_original_method = "BF6A284618BDB748E6134235BAFA5C45", hash_generated_method = "4FAC1BF26B32B041D95CAEB5FA40E7A8")
    protected Collection<CookieAttributeHandler> getAttribHandlers() {
Collection<CookieAttributeHandler> var4186A4F29AAD2C613AF1424EC7B20E08_1357204114 =         this.attribHandlerMap.values();
        var4186A4F29AAD2C613AF1424EC7B20E08_1357204114.addTaint(taint);
        return var4186A4F29AAD2C613AF1424EC7B20E08_1357204114;
        
        
    }

    
}

