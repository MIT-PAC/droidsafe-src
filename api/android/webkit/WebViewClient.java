package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;

public class WebViewClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.617 -0400", hash_original_method = "B78AAF28C2768A73FBC0F670C8F6188A", hash_generated_method = "B78AAF28C2768A73FBC0F670C8F6188A")
    public WebViewClient ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.618 -0400", hash_original_method = "B25B5EE312C01437108EEEF8D289ECD3", hash_generated_method = "4C2C2710B8ECBCA58E99F98B16B1BB40")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_687657121 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682820688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682820688;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.618 -0400", hash_original_method = "5314B6B2031A7AB7127460792C15BEA8", hash_generated_method = "D93B80D6F86035B05D74B08FEFCB8E77")
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(favicon.getTaint());
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.618 -0400", hash_original_method = "3C74EFC6CC5DEEE74470BD61275572DD", hash_generated_method = "18394219E58E831AFE36EAF99B8C48E2")
    public void onPageFinished(WebView view, String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.618 -0400", hash_original_method = "854E1155516A65D2A0AC69045B4275C1", hash_generated_method = "3814A17CF73A0CC7E65B049FD30BD4B2")
    public void onLoadResource(WebView view, String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.619 -0400", hash_original_method = "B5801BDD799BA7062410BD396AAB4B71", hash_generated_method = "1E544877150922E5C7FED1C77B0AF1EA")
    public WebResourceResponse shouldInterceptRequest(WebView view,
            String url) {
        addTaint(url.getTaint());
        addTaint(view.getTaint());
WebResourceResponse var540C13E9E156B687226421B24F2DF178_792244770 =         null;
        var540C13E9E156B687226421B24F2DF178_792244770.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_792244770;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.619 -0400", hash_original_method = "79CA4CDBF662362D6AFDE76E65301125", hash_generated_method = "844419A56C8CE06C4DC2C45325454572")
    @Deprecated
    public void onTooManyRedirects(WebView view, Message cancelMsg,
            Message continueMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(continueMsg.getTaint());
        addTaint(cancelMsg.getTaint());
        addTaint(view.getTaint());
        cancelMsg.sendToTarget();
        // ---------- Original Method ----------
        //cancelMsg.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.619 -0400", hash_original_method = "12ABA78EBE10E417F0C1B2A97120946D", hash_generated_method = "526469B4E594B6C070E8C51CE61C04B0")
    public void onReceivedError(WebView view, int errorCode,
            String description, String failingUrl) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(failingUrl.getTaint());
        addTaint(description.getTaint());
        addTaint(errorCode);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.620 -0400", hash_original_method = "F404DEEFBF7AA691DD4FBAFA7C65E80C", hash_generated_method = "D21809EDA5E6448F58E176C2251D6C20")
    public void onFormResubmission(WebView view, Message dontResend,
            Message resend) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(resend.getTaint());
        addTaint(dontResend.getTaint());
        addTaint(view.getTaint());
        dontResend.sendToTarget();
        // ---------- Original Method ----------
        //dontResend.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.620 -0400", hash_original_method = "17353DC9A8A29F2A1F6857B45DCA3F35", hash_generated_method = "75E4FF4C78A5FD0B0EDF76D6739C2FED")
    public void doUpdateVisitedHistory(WebView view, String url,
            boolean isReload) {
        addTaint(isReload);
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.620 -0400", hash_original_method = "292FE6324BA8FDA19777928FD16DC874", hash_generated_method = "5FCC10F1274F04813FE642DC23C298ED")
    public void onReceivedSslError(WebView view, SslErrorHandler handler,
            SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(error.getTaint());
        addTaint(handler.getTaint());
        addTaint(view.getTaint());
        handler.cancel();
        // ---------- Original Method ----------
        //handler.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.620 -0400", hash_original_method = "B2EE2F5677BCC95DB5D614A683A4C62D", hash_generated_method = "E76D4D6EE1DEFD7875B9B2AF2E567A59")
    public void onProceededAfterSslError(WebView view, SslError error) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(error.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.621 -0400", hash_original_method = "C5A42222BD6D7B11B03E8E8DC75486E5", hash_generated_method = "E8E037B69AB5D3E1175600D9CBB56F62")
    public void onReceivedClientCertRequest(WebView view,
            ClientCertRequestHandler handler, String host_and_port) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(host_and_port.getTaint());
        addTaint(handler.getTaint());
        addTaint(view.getTaint());
        handler.cancel();
        // ---------- Original Method ----------
        //handler.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.621 -0400", hash_original_method = "99DC3611344E7F5F6B557A987ADB25FE", hash_generated_method = "E3559A109C6D478005B6A2B159C3FB05")
    public void onReceivedHttpAuthRequest(WebView view,
            HttpAuthHandler handler, String host, String realm) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        addTaint(handler.getTaint());
        addTaint(view.getTaint());
        handler.cancel();
        // ---------- Original Method ----------
        //handler.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.621 -0400", hash_original_method = "1014277FB075F3AB2B83403F67794F88", hash_generated_method = "429786102C41A31FBAEB37D9C3A36BAE")
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_789950741 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484359372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484359372;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.622 -0400", hash_original_method = "0A322E8BE1639A0DBED358F3919BFB99", hash_generated_method = "EAB59AD094465F6C1908C9F29CC32974")
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.622 -0400", hash_original_method = "E786223707BD58A877E8AD07E09750F2", hash_generated_method = "23CAC2CD770F1D38FA4036177044B490")
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newScale);
        addTaint(oldScale);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.622 -0400", hash_original_method = "61AD7355C99E5A8A7ACA8AE385985070", hash_generated_method = "52D754F41502790021C2E35960D39E26")
    public void onReceivedLoginRequest(WebView view, String realm,
            String account, String args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(args.getTaint());
        addTaint(account.getTaint());
        addTaint(realm.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.622 -0400", hash_original_field = "CF5DC2750207B2DE87E5630F72282310", hash_generated_field = "6AB192206C2061B87FE32DC0D059FC0F")

    public static final int ERROR_UNKNOWN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.622 -0400", hash_original_field = "931F14AC5C76F424E428183EB37465F1", hash_generated_field = "72239920351FC89D2ED57BDF97EBFA27")

    public static final int ERROR_HOST_LOOKUP = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.622 -0400", hash_original_field = "7318F60216F08F0D06726063851F920C", hash_generated_field = "2CFCC24523B105163373EB236FD30AFF")

    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.622 -0400", hash_original_field = "7DC6BB4B42357E57AA3EB735704435EA", hash_generated_field = "22F331898A9FC0AAD055DD27C6091C1F")

    public static final int ERROR_AUTHENTICATION = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "740A8415B6A73BBBAF156B98A28A9CFC", hash_generated_field = "42008B6C2004A121650BFE6D956C7E51")

    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "83EB189816516EAFD1551E4975DD6667", hash_generated_field = "4A1B38F17D7BF96C7FEDDB20F79EBE0E")

    public static final int ERROR_CONNECT = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "45C798642DA006A4E6DDB2641078D776", hash_generated_field = "65780D7E0E775F00FF76AD01C9AC4497")

    public static final int ERROR_IO = -7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "BDD2EA3343745CDE4801F8EC674F9ADA", hash_generated_field = "7B06DE861E1953168CA194164D2C3176")

    public static final int ERROR_TIMEOUT = -8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "93B888DB16C8AB255E93CEC2B63FAD2E", hash_generated_field = "9DC0E6B5D6D9C05608115C117DB82C7B")

    public static final int ERROR_REDIRECT_LOOP = -9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "A107382E992491F44A2389DD5894FEDF", hash_generated_field = "674701B720681268494C1D44A8AD2ECE")

    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "E5A6390FEDD36D2BA4BC8E94313F64C1", hash_generated_field = "AB0D31876B9EF21E506ABB893C746DF4")

    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "16AE5B52EE63ACD25E6DEAECCB7748BF", hash_generated_field = "1E1D729D38F527DC3DEA2A962F063F30")

    public static final int ERROR_BAD_URL = -12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "862A3D1960B5DBAF0FDAA3B712AF70E6", hash_generated_field = "CCBDCDB5E74CEE9466B80982792E4DDE")

    public static final int ERROR_FILE = -13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "22CB4A5BC7C8AD7A7443DC1F497F842E", hash_generated_field = "38983ACBF2E5A0C5628CCCB24B08A301")

    public static final int ERROR_FILE_NOT_FOUND = -14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.623 -0400", hash_original_field = "601576FD54E650D4B9AAB86CA894B8FA", hash_generated_field = "B4EED3D9F39A49A72568F053E1CC61F2")

    public static final int ERROR_TOO_MANY_REQUESTS = -15;
}

