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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.020 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "0FC26A15CA4A50E5DB35DC8C30DA85B0")

    protected ReasonPhraseCatalog reasonCatalog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.020 -0400", hash_original_method = "0B8909DC59B5514A6A7570D0CDE2DD57", hash_generated_method = "89F6B657AAD85EA24F5F10556BD4F802")
    public  DefaultHttpResponseFactory(ReasonPhraseCatalog catalog) {
    if(catalog == null)        
        {
            IllegalArgumentException var30D628BDDBCC9D67552851BD3A6628FB_1980474511 = new IllegalArgumentException
                ("Reason phrase catalog must not be null.");
            var30D628BDDBCC9D67552851BD3A6628FB_1980474511.addTaint(taint);
            throw var30D628BDDBCC9D67552851BD3A6628FB_1980474511;
        } //End block
        this.reasonCatalog = catalog;
        // ---------- Original Method ----------
        //if (catalog == null) {
            //throw new IllegalArgumentException
                //("Reason phrase catalog must not be null.");
        //}
        //this.reasonCatalog = catalog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.020 -0400", hash_original_method = "FFDB5398ED0A2C8E2758E409B21A6993", hash_generated_method = "579123A7FC42A066F2025CAC961F86CC")
    public  DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.020 -0400", hash_original_method = "EC452AB6471CEB13DACC9B1E83291CFC", hash_generated_method = "F9A6442FEE55621179243D92CFEB28E8")
    public HttpResponse newHttpResponse(final ProtocolVersion ver,
                                        final int status,
                                        HttpContext context) {
        addTaint(context.getTaint());
        addTaint(status);
        addTaint(ver.getTaint());
    if(ver == null)        
        {
            IllegalArgumentException var40180DD05D9C1D6C3834A04D0FF2FC4E_1360343572 = new IllegalArgumentException("HTTP version may not be null");
            var40180DD05D9C1D6C3834A04D0FF2FC4E_1360343572.addTaint(taint);
            throw var40180DD05D9C1D6C3834A04D0FF2FC4E_1360343572;
        } //End block
        final Locale loc = determineLocale(context);
        final String reason = reasonCatalog.getReason(status, loc);
        StatusLine statusline = new BasicStatusLine(ver, status, reason);
HttpResponse var5B7331AF545CF47BB674EB8B8981185E_1158834344 =         new BasicHttpResponse(statusline, reasonCatalog, loc);
        var5B7331AF545CF47BB674EB8B8981185E_1158834344.addTaint(taint);
        return var5B7331AF545CF47BB674EB8B8981185E_1158834344;
        // ---------- Original Method ----------
        //if (ver == null) {
            //throw new IllegalArgumentException("HTTP version may not be null");
        //}
        //final Locale loc      = determineLocale(context);
        //final String reason   = reasonCatalog.getReason(status, loc);
        //StatusLine statusline = new BasicStatusLine(ver, status, reason);
        //return new BasicHttpResponse(statusline, reasonCatalog, loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.021 -0400", hash_original_method = "5A7FFEFCFB2914E81957F795B443D54C", hash_generated_method = "E26861E00D457769D65E696FCF0ED8CF")
    public HttpResponse newHttpResponse(final StatusLine statusline,
                                        HttpContext context) {
        addTaint(context.getTaint());
        addTaint(statusline.getTaint());
    if(statusline == null)        
        {
            IllegalArgumentException var1636A5AFF6F53BF0101E09315281948D_652164520 = new IllegalArgumentException("Status line may not be null");
            var1636A5AFF6F53BF0101E09315281948D_652164520.addTaint(taint);
            throw var1636A5AFF6F53BF0101E09315281948D_652164520;
        } //End block
        final Locale loc = determineLocale(context);
HttpResponse var5B7331AF545CF47BB674EB8B8981185E_69550449 =         new BasicHttpResponse(statusline, reasonCatalog, loc);
        var5B7331AF545CF47BB674EB8B8981185E_69550449.addTaint(taint);
        return var5B7331AF545CF47BB674EB8B8981185E_69550449;
        // ---------- Original Method ----------
        //if (statusline == null) {
            //throw new IllegalArgumentException("Status line may not be null");
        //}
        //final Locale loc = determineLocale(context);
        //return new BasicHttpResponse(statusline, reasonCatalog, loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.021 -0400", hash_original_method = "D55AE22798B058ABD6A02EB9DF9528CC", hash_generated_method = "78ACB010AFE0E7468621F0579BE32B39")
    protected Locale determineLocale(HttpContext context) {
        addTaint(context.getTaint());
Locale var144C4164A13FF099CE3146F1062DBE38_674828017 =         Locale.getDefault();
        var144C4164A13FF099CE3146F1062DBE38_674828017.addTaint(taint);
        return var144C4164A13FF099CE3146F1062DBE38_674828017;
        // ---------- Original Method ----------
        //return Locale.getDefault();
    }

    
}

