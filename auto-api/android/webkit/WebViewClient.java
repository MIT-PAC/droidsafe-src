package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;

public class WebViewClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.389 -0400", hash_original_method = "B78AAF28C2768A73FBC0F670C8F6188A", hash_generated_method = "B78AAF28C2768A73FBC0F670C8F6188A")
    public WebViewClient ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.390 -0400", hash_original_method = "B25B5EE312C01437108EEEF8D289ECD3", hash_generated_method = "0D5B8FD4A01DBB8C0EE6E54E314EF412")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        addTaint(view.getTaint());
        addTaint(url.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565918051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_565918051;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.390 -0400", hash_original_method = "5314B6B2031A7AB7127460792C15BEA8", hash_generated_method = "8CF19BF8AB58A2E9400D25D274F7E0F5")
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        
        addTaint(view.getTaint());
        addTaint(url.getTaint());
        addTaint(favicon.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.390 -0400", hash_original_method = "3C74EFC6CC5DEEE74470BD61275572DD", hash_generated_method = "F3EEDF32F8F97D52AE282E549FFDECB4")
    public void onPageFinished(WebView view, String url) {
        
        addTaint(view.getTaint());
        addTaint(url.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.390 -0400", hash_original_method = "854E1155516A65D2A0AC69045B4275C1", hash_generated_method = "301A2E56108AABAD3D657642C28C094D")
    public void onLoadResource(WebView view, String url) {
        
        addTaint(view.getTaint());
        addTaint(url.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.391 -0400", hash_original_method = "B5801BDD799BA7062410BD396AAB4B71", hash_generated_method = "14BB939FD225B539B2E7E8B9C49B2892")
    public WebResourceResponse shouldInterceptRequest(WebView view,
            String url) {
        WebResourceResponse varB4EAC82CA7396A68D541C85D26508E83_361018242 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_361018242 = null;
        addTaint(view.getTaint());
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_361018242.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_361018242;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.391 -0400", hash_original_method = "79CA4CDBF662362D6AFDE76E65301125", hash_generated_method = "0A4BB1121836D26B07C8FBCEE73542AE")
    @Deprecated
    public void onTooManyRedirects(WebView view, Message cancelMsg,
            Message continueMsg) {
        
        cancelMsg.sendToTarget();
        addTaint(view.getTaint());
        addTaint(cancelMsg.getTaint());
        addTaint(continueMsg.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.391 -0400", hash_original_method = "12ABA78EBE10E417F0C1B2A97120946D", hash_generated_method = "8E08FC52ED5F8697EB4ABC241E570844")
    public void onReceivedError(WebView view, int errorCode,
            String description, String failingUrl) {
        
        addTaint(view.getTaint());
        addTaint(errorCode);
        addTaint(description.getTaint());
        addTaint(failingUrl.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.392 -0400", hash_original_method = "F404DEEFBF7AA691DD4FBAFA7C65E80C", hash_generated_method = "93388CC9F239834DCB4F6BAE902B2975")
    public void onFormResubmission(WebView view, Message dontResend,
            Message resend) {
        
        dontResend.sendToTarget();
        addTaint(view.getTaint());
        addTaint(dontResend.getTaint());
        addTaint(resend.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.392 -0400", hash_original_method = "17353DC9A8A29F2A1F6857B45DCA3F35", hash_generated_method = "F1AE5CC1814E2CBD1B8153CFBB33397A")
    public void doUpdateVisitedHistory(WebView view, String url,
            boolean isReload) {
        addTaint(view.getTaint());
        addTaint(url.getTaint());
        addTaint(isReload);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.392 -0400", hash_original_method = "292FE6324BA8FDA19777928FD16DC874", hash_generated_method = "7C5B347D2826EBB462188668A16CFCA4")
    public void onReceivedSslError(WebView view, SslErrorHandler handler,
            SslError error) {
        
        handler.cancel();
        addTaint(view.getTaint());
        addTaint(handler.getTaint());
        addTaint(error.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.392 -0400", hash_original_method = "B2EE2F5677BCC95DB5D614A683A4C62D", hash_generated_method = "C21C7E62F36C4232D664A6E0E0C16B22")
    public void onProceededAfterSslError(WebView view, SslError error) {
        
        addTaint(view.getTaint());
        addTaint(error.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.393 -0400", hash_original_method = "C5A42222BD6D7B11B03E8E8DC75486E5", hash_generated_method = "B51A73B48F7095041FA27F9E975520E5")
    public void onReceivedClientCertRequest(WebView view,
            ClientCertRequestHandler handler, String host_and_port) {
        
        handler.cancel();
        addTaint(view.getTaint());
        addTaint(handler.getTaint());
        addTaint(host_and_port.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.393 -0400", hash_original_method = "99DC3611344E7F5F6B557A987ADB25FE", hash_generated_method = "E674AA9BA1D615B50834CAF483A1F41D")
    public void onReceivedHttpAuthRequest(WebView view,
            HttpAuthHandler handler, String host, String realm) {
        
        handler.cancel();
        addTaint(view.getTaint());
        addTaint(handler.getTaint());
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.393 -0400", hash_original_method = "1014277FB075F3AB2B83403F67794F88", hash_generated_method = "4FFF6551BA260EB5DE60261D5BE88A1B")
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        addTaint(view.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476929850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476929850;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.393 -0400", hash_original_method = "0A322E8BE1639A0DBED358F3919BFB99", hash_generated_method = "82FA2AA75F185AEA1F1C538A3CC5C338")
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        
        addTaint(view.getTaint());
        addTaint(event.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.393 -0400", hash_original_method = "E786223707BD58A877E8AD07E09750F2", hash_generated_method = "165D8F6DF52EF43FE5A9D14E430D9375")
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        
        addTaint(view.getTaint());
        addTaint(oldScale);
        addTaint(newScale);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_method = "61AD7355C99E5A8A7ACA8AE385985070", hash_generated_method = "0919EFD4F655A6F89A1711FDD34B5AF5")
    public void onReceivedLoginRequest(WebView view, String realm,
            String account, String args) {
        
        addTaint(view.getTaint());
        addTaint(realm.getTaint());
        addTaint(account.getTaint());
        addTaint(args.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "CF5DC2750207B2DE87E5630F72282310", hash_generated_field = "6AB192206C2061B87FE32DC0D059FC0F")

    public static final int ERROR_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "931F14AC5C76F424E428183EB37465F1", hash_generated_field = "72239920351FC89D2ED57BDF97EBFA27")

    public static final int ERROR_HOST_LOOKUP = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "7318F60216F08F0D06726063851F920C", hash_generated_field = "2CFCC24523B105163373EB236FD30AFF")

    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "7DC6BB4B42357E57AA3EB735704435EA", hash_generated_field = "22F331898A9FC0AAD055DD27C6091C1F")

    public static final int ERROR_AUTHENTICATION = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "740A8415B6A73BBBAF156B98A28A9CFC", hash_generated_field = "42008B6C2004A121650BFE6D956C7E51")

    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "83EB189816516EAFD1551E4975DD6667", hash_generated_field = "4A1B38F17D7BF96C7FEDDB20F79EBE0E")

    public static final int ERROR_CONNECT = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "45C798642DA006A4E6DDB2641078D776", hash_generated_field = "65780D7E0E775F00FF76AD01C9AC4497")

    public static final int ERROR_IO = -7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "BDD2EA3343745CDE4801F8EC674F9ADA", hash_generated_field = "7B06DE861E1953168CA194164D2C3176")

    public static final int ERROR_TIMEOUT = -8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "93B888DB16C8AB255E93CEC2B63FAD2E", hash_generated_field = "9DC0E6B5D6D9C05608115C117DB82C7B")

    public static final int ERROR_REDIRECT_LOOP = -9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "A107382E992491F44A2389DD5894FEDF", hash_generated_field = "674701B720681268494C1D44A8AD2ECE")

    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "E5A6390FEDD36D2BA4BC8E94313F64C1", hash_generated_field = "AB0D31876B9EF21E506ABB893C746DF4")

    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "16AE5B52EE63ACD25E6DEAECCB7748BF", hash_generated_field = "1E1D729D38F527DC3DEA2A962F063F30")

    public static final int ERROR_BAD_URL = -12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "862A3D1960B5DBAF0FDAA3B712AF70E6", hash_generated_field = "CCBDCDB5E74CEE9466B80982792E4DDE")

    public static final int ERROR_FILE = -13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "22CB4A5BC7C8AD7A7443DC1F497F842E", hash_generated_field = "38983ACBF2E5A0C5628CCCB24B08A301")

    public static final int ERROR_FILE_NOT_FOUND = -14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.394 -0400", hash_original_field = "601576FD54E650D4B9AAB86CA894B8FA", hash_generated_field = "B4EED3D9F39A49A72568F053E1CC61F2")

    public static final int ERROR_TOO_MANY_REQUESTS = -15;
}

