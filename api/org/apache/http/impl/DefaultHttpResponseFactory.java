package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.332 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "0FC26A15CA4A50E5DB35DC8C30DA85B0")

    protected ReasonPhraseCatalog reasonCatalog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.332 -0400", hash_original_method = "0B8909DC59B5514A6A7570D0CDE2DD57", hash_generated_method = "62B241530F56A8030A4C6D40942E19A6")
    public  DefaultHttpResponseFactory(ReasonPhraseCatalog catalog) {
        if(catalog == null)        
        {
            IllegalArgumentException var30D628BDDBCC9D67552851BD3A6628FB_929737650 = new IllegalArgumentException
                ("Reason phrase catalog must not be null.");
            var30D628BDDBCC9D67552851BD3A6628FB_929737650.addTaint(taint);
            throw var30D628BDDBCC9D67552851BD3A6628FB_929737650;
        } //End block
        this.reasonCatalog = catalog;
        // ---------- Original Method ----------
        //if (catalog == null) {
            //throw new IllegalArgumentException
                //("Reason phrase catalog must not be null.");
        //}
        //this.reasonCatalog = catalog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.332 -0400", hash_original_method = "FFDB5398ED0A2C8E2758E409B21A6993", hash_generated_method = "579123A7FC42A066F2025CAC961F86CC")
    public  DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.333 -0400", hash_original_method = "EC452AB6471CEB13DACC9B1E83291CFC", hash_generated_method = "FA4512428A00F98C197154EF9B2ECA83")
    public HttpResponse newHttpResponse(final ProtocolVersion ver,
                                        final int status,
                                        HttpContext context) {
        addTaint(context.getTaint());
        addTaint(status);
        addTaint(ver.getTaint());
        if(ver == null)        
        {
            IllegalArgumentException var40180DD05D9C1D6C3834A04D0FF2FC4E_1877706277 = new IllegalArgumentException("HTTP version may not be null");
            var40180DD05D9C1D6C3834A04D0FF2FC4E_1877706277.addTaint(taint);
            throw var40180DD05D9C1D6C3834A04D0FF2FC4E_1877706277;
        } //End block
        final Locale loc = determineLocale(context);
        final String reason = reasonCatalog.getReason(status, loc);
        StatusLine statusline = new BasicStatusLine(ver, status, reason);
HttpResponse var5B7331AF545CF47BB674EB8B8981185E_45090758 =         new BasicHttpResponse(statusline, reasonCatalog, loc);
        var5B7331AF545CF47BB674EB8B8981185E_45090758.addTaint(taint);
        return var5B7331AF545CF47BB674EB8B8981185E_45090758;
        // ---------- Original Method ----------
        //if (ver == null) {
            //throw new IllegalArgumentException("HTTP version may not be null");
        //}
        //final Locale loc      = determineLocale(context);
        //final String reason   = reasonCatalog.getReason(status, loc);
        //StatusLine statusline = new BasicStatusLine(ver, status, reason);
        //return new BasicHttpResponse(statusline, reasonCatalog, loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.333 -0400", hash_original_method = "5A7FFEFCFB2914E81957F795B443D54C", hash_generated_method = "5E1DB163FE0067D17387C978DD50CFBC")
    public HttpResponse newHttpResponse(final StatusLine statusline,
                                        HttpContext context) {
        addTaint(context.getTaint());
        addTaint(statusline.getTaint());
        if(statusline == null)        
        {
            IllegalArgumentException var1636A5AFF6F53BF0101E09315281948D_1941266356 = new IllegalArgumentException("Status line may not be null");
            var1636A5AFF6F53BF0101E09315281948D_1941266356.addTaint(taint);
            throw var1636A5AFF6F53BF0101E09315281948D_1941266356;
        } //End block
        final Locale loc = determineLocale(context);
HttpResponse var5B7331AF545CF47BB674EB8B8981185E_896881117 =         new BasicHttpResponse(statusline, reasonCatalog, loc);
        var5B7331AF545CF47BB674EB8B8981185E_896881117.addTaint(taint);
        return var5B7331AF545CF47BB674EB8B8981185E_896881117;
        // ---------- Original Method ----------
        //if (statusline == null) {
            //throw new IllegalArgumentException("Status line may not be null");
        //}
        //final Locale loc = determineLocale(context);
        //return new BasicHttpResponse(statusline, reasonCatalog, loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.333 -0400", hash_original_method = "D55AE22798B058ABD6A02EB9DF9528CC", hash_generated_method = "F3C48144619C9347C6E408609D7DC4EF")
    protected Locale determineLocale(HttpContext context) {
        addTaint(context.getTaint());
Locale var144C4164A13FF099CE3146F1062DBE38_1919133068 =         Locale.getDefault();
        var144C4164A13FF099CE3146F1062DBE38_1919133068.addTaint(taint);
        return var144C4164A13FF099CE3146F1062DBE38_1919133068;
        // ---------- Original Method ----------
        //return Locale.getDefault();
    }

    
}

