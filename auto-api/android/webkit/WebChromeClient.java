package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;

public class WebChromeClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.969 -0400", hash_original_method = "8410C237D05173D859BF6C8993FFBD31", hash_generated_method = "8410C237D05173D859BF6C8993FFBD31")
        public WebChromeClient ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.969 -0400", hash_original_method = "0356D3C5779031E83EBAA5536F22FD2C", hash_generated_method = "1C45E73D56F39038BD81A1A28DED8BF7")
    @DSModeled(DSC.SAFE)
    public void onProgressChanged(WebView view, int newProgress) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newProgress);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.969 -0400", hash_original_method = "EF8501574F8D969A2FEBAA77F34054B1", hash_generated_method = "A85DBDB25F4A39E4B94874584BFFBF24")
    @DSModeled(DSC.SAFE)
    public void onReceivedTitle(WebView view, String title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(title);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.969 -0400", hash_original_method = "29596704FB7D5BB460F59F26BE233C70", hash_generated_method = "45B059FB94E866A82F2D76F06B5AB75B")
    @DSModeled(DSC.SAFE)
    public void onReceivedIcon(WebView view, Bitmap icon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(icon.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.970 -0400", hash_original_method = "A4C5B5257D00BF3A62B0EECD068EB4AE", hash_generated_method = "ED028003F4297FC93C2A5C43D4322ADD")
    @DSModeled(DSC.SAFE)
    public void onReceivedTouchIconUrl(WebView view, String url,
            boolean precomposed) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(precomposed);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.970 -0400", hash_original_method = "77F78B4AA1FEBCA4548885095C178085", hash_generated_method = "53D9F6221400E3333BC70F73C37B128B")
    @DSModeled(DSC.SAFE)
    public void onShowCustomView(View view, CustomViewCallback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.970 -0400", hash_original_method = "42AC916863A44836B06C58A8705D2934", hash_generated_method = "E3D0A8E82647BD9E381ECE129F277995")
    @DSModeled(DSC.SAFE)
    public void onShowCustomView(View view, int requestedOrientation,
            CustomViewCallback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(requestedOrientation);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.970 -0400", hash_original_method = "3C82DC078459A71064D67069FEC24583", hash_generated_method = "63612F93E831F6A65719E999215E74B0")
    @DSModeled(DSC.SAFE)
    public void onHideCustomView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.970 -0400", hash_original_method = "0F7608F947A0ECBD179808AAF0AFEB9B", hash_generated_method = "1C368575031F15AEE15AC0905EDC2EDE")
    @DSModeled(DSC.SAFE)
    public boolean onCreateWindow(WebView view, boolean isDialog,
            boolean isUserGesture, Message resultMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resultMsg.dsTaint);
        dsTaint.addTaint(isDialog);
        dsTaint.addTaint(isUserGesture);
        dsTaint.addTaint(view.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.970 -0400", hash_original_method = "9D3C2A06B7A580B802B062ACCF072DA0", hash_generated_method = "20986F7E59D64B57FA67C537C92265F5")
    @DSModeled(DSC.SAFE)
    public void onRequestFocus(WebView view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.970 -0400", hash_original_method = "20C36406AC14D1B2BB4595DEF25401D6", hash_generated_method = "7129A218D9C7F34F8BE33058FD9D0FAC")
    @DSModeled(DSC.SAFE)
    public void onCloseWindow(WebView window) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(window.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.971 -0400", hash_original_method = "B665260C93890B7DFFFEE826876C181C", hash_generated_method = "2B4D92AA7FF3C987E7438185EAF3FA27")
    @DSModeled(DSC.SAFE)
    public boolean onJsAlert(WebView view, String url, String message,
            JsResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.971 -0400", hash_original_method = "96B1179CA869CC7F0C650459C80E91A1", hash_generated_method = "692596637A7C754395F2F3A3CD30D9D9")
    @DSModeled(DSC.SAFE)
    public boolean onJsConfirm(WebView view, String url, String message,
            JsResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.971 -0400", hash_original_method = "B0F8165C36C1E06488928BD9B36CF34F", hash_generated_method = "68BCE2D5EF3FA4B61F82F9AFECC1C655")
    @DSModeled(DSC.SAFE)
    public boolean onJsPrompt(WebView view, String url, String message,
            String defaultValue, JsPromptResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(url);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.971 -0400", hash_original_method = "9A70F346469CE5ADB362459FFD66F0CC", hash_generated_method = "45E13267BDD8D0DCB19816C9133B21CB")
    @DSModeled(DSC.SAFE)
    public boolean onJsBeforeUnload(WebView view, String url, String message,
            JsResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(message);
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(url);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.971 -0400", hash_original_method = "E698A9F452C6783F3C6DB7E7A071CA1D", hash_generated_method = "1F16FFB2DBCB409553F4233700F622CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onExceededDatabaseQuota(String url, String databaseIdentifier,
        long currentQuota, long estimatedSize, long totalUsedQuota,
        WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(quotaUpdater.dsTaint);
        dsTaint.addTaint(totalUsedQuota);
        dsTaint.addTaint(currentQuota);
        dsTaint.addTaint(estimatedSize);
        dsTaint.addTaint(databaseIdentifier);
        dsTaint.addTaint(url);
        quotaUpdater.updateQuota(currentQuota);
        // ---------- Original Method ----------
        //quotaUpdater.updateQuota(currentQuota);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.971 -0400", hash_original_method = "EC4B1817B796D6243C1BADFF5A19DD19", hash_generated_method = "A27849B6236D8CA78C3FEDF0CAAB76A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(quotaUpdater.dsTaint);
        dsTaint.addTaint(totalUsedQuota);
        dsTaint.addTaint(spaceNeeded);
        quotaUpdater.updateQuota(0);
        // ---------- Original Method ----------
        //quotaUpdater.updateQuota(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.972 -0400", hash_original_method = "98993092A89284EC0BBF79A8D8B73F2B", hash_generated_method = "C35A1ACEA52431BC0FDD1480E67DE532")
    @DSModeled(DSC.SAFE)
    public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(origin);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.972 -0400", hash_original_method = "C2C3AAB43EA40B6144BCEFE67B905422", hash_generated_method = "09A93B8FC5C244974809187C87D6D13D")
    @DSModeled(DSC.SAFE)
    public void onGeolocationPermissionsHidePrompt() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.972 -0400", hash_original_method = "D3576F706DC2F920D86267B1909BCF87", hash_generated_method = "7E471458DFA38BBE498F1CFB6E68D1DD")
    @DSModeled(DSC.SAFE)
    public boolean onJsTimeout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.972 -0400", hash_original_method = "79CD152A32E05A12E47F3ADA435EA3CF", hash_generated_method = "2A215679413C9BC9468C8F5D7097134B")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(sourceID);
        dsTaint.addTaint(message);
        dsTaint.addTaint(lineNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.972 -0400", hash_original_method = "CFDCDEC28BDAF7613A605474C11A52D7", hash_generated_method = "5404D7EEF285D21E5F8EB27A028664B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(consoleMessage.dsTaint);
        onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(),
                consoleMessage.sourceId());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(),
                //consoleMessage.sourceId());
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.972 -0400", hash_original_method = "B12C654EAF6D1EF1BD2CB65AEE47A82B", hash_generated_method = "B023F3A3F3A8DAA63BEE7814B16014B5")
    @DSModeled(DSC.SAFE)
    public Bitmap getDefaultVideoPoster() {
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.973 -0400", hash_original_method = "72F535BEAD962B4F42D879A83B63BF5A", hash_generated_method = "BBE9E080623E4D12ADBE0DDE9814E4A8")
    @DSModeled(DSC.SAFE)
    public View getVideoLoadingProgressView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.973 -0400", hash_original_method = "15B2ED72F970B566935619473880B5EF", hash_generated_method = "031423707B2389E5D8CFE0ED5A2EE2BA")
    @DSModeled(DSC.SAFE)
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        dsTaint.addTaint(callback.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.973 -0400", hash_original_method = "DA085B71ADFBAF37C9145F2BAEC7CA78", hash_generated_method = "CC916EB531AFBDBC2027F371A1E932CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void openFileChooser(ValueCallback<Uri> uploadFile, String acceptType) {
        dsTaint.addTaint(uploadFile.dsTaint);
        dsTaint.addTaint(acceptType);
        uploadFile.onReceiveValue(null);
        // ---------- Original Method ----------
        //uploadFile.onReceiveValue(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.973 -0400", hash_original_method = "BB19EC4B0210D5A42E9ED0382D14771D", hash_generated_method = "3785D8125E00E011E4B23B7F3B399B15")
    @DSModeled(DSC.SAFE)
    public void setInstallableWebApp() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.973 -0400", hash_original_method = "681C2C146739845C582C6BB934543E3C", hash_generated_method = "487F48AF587D56A50DF6995FB2BCCA5C")
    @DSModeled(DSC.SAFE)
    public void setupAutoFill(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
    }

    
    public interface CustomViewCallback {
        
        public void onCustomViewHidden();
    }
    
}

