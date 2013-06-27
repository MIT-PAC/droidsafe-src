package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.951 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "0FC26A15CA4A50E5DB35DC8C30DA85B0")

    protected ReasonPhraseCatalog reasonCatalog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.954 -0400", hash_original_method = "0B8909DC59B5514A6A7570D0CDE2DD57", hash_generated_method = "464B66BF6589189CBFA494A7F19F4E60")
    public  DefaultHttpResponseFactory(ReasonPhraseCatalog catalog) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Reason phrase catalog must not be null.");
        } //End block
        this.reasonCatalog = catalog;
        // ---------- Original Method ----------
        //if (catalog == null) {
            //throw new IllegalArgumentException
                //("Reason phrase catalog must not be null.");
        //}
        //this.reasonCatalog = catalog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.955 -0400", hash_original_method = "FFDB5398ED0A2C8E2758E409B21A6993", hash_generated_method = "579123A7FC42A066F2025CAC961F86CC")
    public  DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.955 -0400", hash_original_method = "EC452AB6471CEB13DACC9B1E83291CFC", hash_generated_method = "9778CD6E210D22664C52775CC6900B1C")
    public HttpResponse newHttpResponse(final ProtocolVersion ver,
                                        final int status,
                                        HttpContext context) {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1947036327 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP version may not be null");
        } //End block
        Locale loc;
        loc = determineLocale(context);
        String reason;
        reason = reasonCatalog.getReason(status, loc);
        StatusLine statusline;
        statusline = new BasicStatusLine(ver, status, reason);
        varB4EAC82CA7396A68D541C85D26508E83_1947036327 = new BasicHttpResponse(statusline, reasonCatalog, loc);
        addTaint(ver.getTaint());
        addTaint(status);
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1947036327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1947036327;
        // ---------- Original Method ----------
        //if (ver == null) {
            //throw new IllegalArgumentException("HTTP version may not be null");
        //}
        //final Locale loc      = determineLocale(context);
        //final String reason   = reasonCatalog.getReason(status, loc);
        //StatusLine statusline = new BasicStatusLine(ver, status, reason);
        //return new BasicHttpResponse(statusline, reasonCatalog, loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.956 -0400", hash_original_method = "5A7FFEFCFB2914E81957F795B443D54C", hash_generated_method = "04B050CF07E8A3E899BE5F31F342A0A2")
    public HttpResponse newHttpResponse(final StatusLine statusline,
                                        HttpContext context) {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1603352156 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Status line may not be null");
        } //End block
        Locale loc;
        loc = determineLocale(context);
        varB4EAC82CA7396A68D541C85D26508E83_1603352156 = new BasicHttpResponse(statusline, reasonCatalog, loc);
        addTaint(statusline.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1603352156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603352156;
        // ---------- Original Method ----------
        //if (statusline == null) {
            //throw new IllegalArgumentException("Status line may not be null");
        //}
        //final Locale loc = determineLocale(context);
        //return new BasicHttpResponse(statusline, reasonCatalog, loc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.956 -0400", hash_original_method = "D55AE22798B058ABD6A02EB9DF9528CC", hash_generated_method = "99A242C74F3F6C0543B9A30DC107B617")
    protected Locale determineLocale(HttpContext context) {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1917132662 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1917132662 = Locale.getDefault();
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1917132662.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1917132662;
        // ---------- Original Method ----------
        //return Locale.getDefault();
    }

    
}

