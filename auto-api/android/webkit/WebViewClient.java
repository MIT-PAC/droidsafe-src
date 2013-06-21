package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;

public class WebViewClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.987 -0400", hash_original_method = "4E938C7749B54291FC071031995AFC11", hash_generated_method = "4E938C7749B54291FC071031995AFC11")
        public WebViewClient ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.988 -0400", hash_original_method = "B25B5EE312C01437108EEEF8D289ECD3", hash_generated_method = "02203049C36635B3858842CE372FEBD6")
    @DSModeled(DSC.SAFE)
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.988 -0400", hash_original_method = "5314B6B2031A7AB7127460792C15BEA8", hash_generated_method = "EE04F678B805F4A5A039408E6303BF1B")
    @DSModeled(DSC.SAFE)
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(favicon.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.988 -0400", hash_original_method = "3C74EFC6CC5DEEE74470BD61275572DD", hash_generated_method = "3FA2D74517135E1D864C8167DEE03769")
    @DSModeled(DSC.SAFE)
    public void onPageFinished(WebView view, String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.988 -0400", hash_original_method = "854E1155516A65D2A0AC69045B4275C1", hash_generated_method = "C3A1CA395DFA07D4001C5362CA7AEC77")
    @DSModeled(DSC.SAFE)
    public void onLoadResource(WebView view, String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.988 -0400", hash_original_method = "B5801BDD799BA7062410BD396AAB4B71", hash_generated_method = "DD3DACB8F91669710989C8D25727344D")
    @DSModeled(DSC.SAFE)
    public WebResourceResponse shouldInterceptRequest(WebView view,
            String url) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        return (WebResourceResponse)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.989 -0400", hash_original_method = "79CA4CDBF662362D6AFDE76E65301125", hash_generated_method = "5574DC60B24B756F3DD897FAA78A37FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void onTooManyRedirects(WebView view, Message cancelMsg,
            Message continueMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cancelMsg.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(continueMsg.dsTaint);
        cancelMsg.sendToTarget();
        // ---------- Original Method ----------
        //cancelMsg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.989 -0400", hash_original_method = "12ABA78EBE10E417F0C1B2A97120946D", hash_generated_method = "23CD2BA19E3A3279ECEA5D7D68457EC7")
    @DSModeled(DSC.SAFE)
    public void onReceivedError(WebView view, int errorCode,
            String description, String failingUrl) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(description);
        dsTaint.addTaint(errorCode);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(failingUrl);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.989 -0400", hash_original_method = "F404DEEFBF7AA691DD4FBAFA7C65E80C", hash_generated_method = "361434CFB835AAA895E6C5DE7289C6E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onFormResubmission(WebView view, Message dontResend,
            Message resend) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resend.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(dontResend.dsTaint);
        dontResend.sendToTarget();
        // ---------- Original Method ----------
        //dontResend.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.989 -0400", hash_original_method = "17353DC9A8A29F2A1F6857B45DCA3F35", hash_generated_method = "41B0B458C61D3C8C638C1C6B95F94A63")
    @DSModeled(DSC.SAFE)
    public void doUpdateVisitedHistory(WebView view, String url,
            boolean isReload) {
        dsTaint.addTaint(isReload);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.989 -0400", hash_original_method = "292FE6324BA8FDA19777928FD16DC874", hash_generated_method = "5DCE5BA14FE765DF8A9D15532852C7EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedSslError(WebView view, SslErrorHandler handler,
            SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(error.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        handler.cancel();
        // ---------- Original Method ----------
        //handler.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.990 -0400", hash_original_method = "B2EE2F5677BCC95DB5D614A683A4C62D", hash_generated_method = "1372939E27D94BC4A72CC56899FDD4FC")
    @DSModeled(DSC.SAFE)
    public void onProceededAfterSslError(WebView view, SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(error.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.990 -0400", hash_original_method = "C5A42222BD6D7B11B03E8E8DC75486E5", hash_generated_method = "E52170681886ED1AA1B52DB342F7B2A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedClientCertRequest(WebView view,
            ClientCertRequestHandler handler, String host_and_port) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(host_and_port);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        handler.cancel();
        // ---------- Original Method ----------
        //handler.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.990 -0400", hash_original_method = "99DC3611344E7F5F6B557A987ADB25FE", hash_generated_method = "25ED8236D0101D0607E5F34EA3B9744B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReceivedHttpAuthRequest(WebView view,
            HttpAuthHandler handler, String host, String realm) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(host);
        dsTaint.addTaint(realm);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        handler.cancel();
        // ---------- Original Method ----------
        //handler.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.990 -0400", hash_original_method = "1014277FB075F3AB2B83403F67794F88", hash_generated_method = "B994E3B2916AF65268AC7540E660CEF0")
    @DSModeled(DSC.SAFE)
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.990 -0400", hash_original_method = "0A322E8BE1639A0DBED358F3919BFB99", hash_generated_method = "AB95B99CF553C01C1E06930D4D39D561")
    @DSModeled(DSC.SAFE)
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.990 -0400", hash_original_method = "E786223707BD58A877E8AD07E09750F2", hash_generated_method = "74D191FF9033185462C44F7E7B11A7EC")
    @DSModeled(DSC.SAFE)
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newScale);
        dsTaint.addTaint(oldScale);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.991 -0400", hash_original_method = "61AD7355C99E5A8A7ACA8AE385985070", hash_generated_method = "B92EF50646784A89DA29ED240DC8D56D")
    @DSModeled(DSC.SAFE)
    public void onReceivedLoginRequest(WebView view, String realm,
            String account, String args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(realm);
        dsTaint.addTaint(args);
        dsTaint.addTaint(account);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_IO = -7;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
}

