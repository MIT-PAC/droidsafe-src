package org.apache.http.impl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.impl.EnglishReasonPhraseCatalog;

public class DefaultHttpResponseFactory implements HttpResponseFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.698 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "0FC26A15CA4A50E5DB35DC8C30DA85B0")

    protected ReasonPhraseCatalog reasonCatalog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.699 -0400", hash_original_method = "0B8909DC59B5514A6A7570D0CDE2DD57", hash_generated_method = "464B66BF6589189CBFA494A7F19F4E60")
    public  DefaultHttpResponseFactory(ReasonPhraseCatalog catalog) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Reason phrase catalog must not be null.");
        } 
        this.reasonCatalog = catalog;
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.700 -0400", hash_original_method = "FFDB5398ED0A2C8E2758E409B21A6993", hash_generated_method = "579123A7FC42A066F2025CAC961F86CC")
    public  DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.700 -0400", hash_original_method = "EC452AB6471CEB13DACC9B1E83291CFC", hash_generated_method = "CF8C253B94982CF6E28C1DA2AD5B9211")
    public HttpResponse newHttpResponse(final ProtocolVersion ver,
                                        final int status,
                                        HttpContext context) {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1126231000 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP version may not be null");
        } 
        final Locale loc = determineLocale(context);
        final String reason = reasonCatalog.getReason(status, loc);
        StatusLine statusline = new BasicStatusLine(ver, status, reason);
        varB4EAC82CA7396A68D541C85D26508E83_1126231000 = new BasicHttpResponse(statusline, reasonCatalog, loc);
        addTaint(ver.getTaint());
        addTaint(status);
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1126231000.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1126231000;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.701 -0400", hash_original_method = "5A7FFEFCFB2914E81957F795B443D54C", hash_generated_method = "7B43605DE05C67B186C19A42AFFDD247")
    public HttpResponse newHttpResponse(final StatusLine statusline,
                                        HttpContext context) {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_228050673 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Status line may not be null");
        } 
        final Locale loc = determineLocale(context);
        varB4EAC82CA7396A68D541C85D26508E83_228050673 = new BasicHttpResponse(statusline, reasonCatalog, loc);
        addTaint(statusline.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_228050673.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_228050673;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.702 -0400", hash_original_method = "D55AE22798B058ABD6A02EB9DF9528CC", hash_generated_method = "98214A106A5AF6E042F417854650F801")
    protected Locale determineLocale(HttpContext context) {
        Locale varB4EAC82CA7396A68D541C85D26508E83_480559151 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_480559151 = Locale.getDefault();
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_480559151.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_480559151;
        
        
    }

    
}

