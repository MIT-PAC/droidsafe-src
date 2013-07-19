package android.webkit;

// Droidsafe Imports
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WebChromeClient {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "99482C8BD0C5E621D29A3393913944E6", hash_generated_method = "99482C8BD0C5E621D29A3393913944E6")
    public WebChromeClient ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "0356D3C5779031E83EBAA5536F22FD2C", hash_generated_method = "A6997871206564D59D672702AADD906F")
    public void onProgressChanged(WebView view, int newProgress) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newProgress);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "EF8501574F8D969A2FEBAA77F34054B1", hash_generated_method = "C3A35C9613A05C94A61DE52FEFDD3430")
    public void onReceivedTitle(WebView view, String title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(title.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "29596704FB7D5BB460F59F26BE233C70", hash_generated_method = "921050E6336DB4AA7D36CE16C8B94C50")
    public void onReceivedIcon(WebView view, Bitmap icon) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(icon.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "A4C5B5257D00BF3A62B0EECD068EB4AE", hash_generated_method = "AED30A3DD34F932CFC7F8C195C875340")
    public void onReceivedTouchIconUrl(WebView view, String url,
            boolean precomposed) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(precomposed);
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "77F78B4AA1FEBCA4548885095C178085", hash_generated_method = "53388DB6ED9BD1E1036D321C577175DB")
    public void onShowCustomView(View view, CustomViewCallback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "42AC916863A44836B06C58A8705D2934", hash_generated_method = "5091CAD97AEFD1E63CA5C01C7131AEB1")
    public void onShowCustomView(View view, int requestedOrientation,
            CustomViewCallback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        addTaint(requestedOrientation);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "3C82DC078459A71064D67069FEC24583", hash_generated_method = "63612F93E831F6A65719E999215E74B0")
    public void onHideCustomView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.356 -0400", hash_original_method = "0F7608F947A0ECBD179808AAF0AFEB9B", hash_generated_method = "05E460104A27A9B97063B7B099BA4634")
    public boolean onCreateWindow(WebView view, boolean isDialog,
            boolean isUserGesture, Message resultMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(resultMsg.getTaint());
        addTaint(isUserGesture);
        addTaint(isDialog);
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_313693384 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1271111268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1271111268;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "9D3C2A06B7A580B802B062ACCF072DA0", hash_generated_method = "64D238AFAD4B295CDFBA5195914F9D59")
    public void onRequestFocus(WebView view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "20C36406AC14D1B2BB4595DEF25401D6", hash_generated_method = "17B0D6382CA8583138299CC5368185E2")
    public void onCloseWindow(WebView window) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(window.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "B665260C93890B7DFFFEE826876C181C", hash_generated_method = "C5C193132853EADCF12C942105E09AFD")
    public boolean onJsAlert(WebView view, String url, String message,
            JsResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_352192585 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598802348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598802348;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "96B1179CA869CC7F0C650459C80E91A1", hash_generated_method = "0A3213358BF9D9089AC0DBED57E032FC")
    public boolean onJsConfirm(WebView view, String url, String message,
            JsResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1120965080 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1917490585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1917490585;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "B0F8165C36C1E06488928BD9B36CF34F", hash_generated_method = "972F5945C5C927BB11A78C7EB72140AF")
    public boolean onJsPrompt(WebView view, String url, String message,
            String defaultValue, JsPromptResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        addTaint(defaultValue.getTaint());
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2008216740 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034905719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034905719;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "9A70F346469CE5ADB362459FFD66F0CC", hash_generated_method = "7F541B8C41448066143F319613876D87")
    public boolean onJsBeforeUnload(WebView view, String url, String message,
            JsResult result) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(result.getTaint());
        addTaint(message.getTaint());
        addTaint(url.getTaint());
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1796215779 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435235670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435235670;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "E698A9F452C6783F3C6DB7E7A071CA1D", hash_generated_method = "DB116A66BD870990516C98924E4255AD")
    public void onExceededDatabaseQuota(String url, String databaseIdentifier,
        long currentQuota, long estimatedSize, long totalUsedQuota,
        WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(quotaUpdater.getTaint());
        addTaint(totalUsedQuota);
        addTaint(estimatedSize);
        addTaint(currentQuota);
        addTaint(databaseIdentifier.getTaint());
        addTaint(url.getTaint());
        quotaUpdater.updateQuota(currentQuota);
        // ---------- Original Method ----------
        //quotaUpdater.updateQuota(currentQuota);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "EC4B1817B796D6243C1BADFF5A19DD19", hash_generated_method = "6110D7831AC1B16EA511FFC83210B4ED")
    public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(quotaUpdater.getTaint());
        addTaint(totalUsedQuota);
        addTaint(spaceNeeded);
        quotaUpdater.updateQuota(0);
        // ---------- Original Method ----------
        //quotaUpdater.updateQuota(0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "98993092A89284EC0BBF79A8D8B73F2B", hash_generated_method = "BAEC46BF2128A46C128DCCCB80EFB219")
    public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.357 -0400", hash_original_method = "C2C3AAB43EA40B6144BCEFE67B905422", hash_generated_method = "09A93B8FC5C244974809187C87D6D13D")
    public void onGeolocationPermissionsHidePrompt() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "D3576F706DC2F920D86267B1909BCF87", hash_generated_method = "F12711550324A559B64C29AD1A2EF41E")
    public boolean onJsTimeout() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean varB326B5062B2F0E69046810717534CB09_937153979 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911618705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911618705;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "79CD152A32E05A12E47F3ADA435EA3CF", hash_generated_method = "DB8A32286F3D6D9328027B29D01FDB17")
    @Deprecated
    public void onConsoleMessage(String message, int lineNumber, String sourceID) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(sourceID.getTaint());
        addTaint(lineNumber);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "CFDCDEC28BDAF7613A605474C11A52D7", hash_generated_method = "71EEE87836C795E34A2E6FEDAED15596")
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(consoleMessage.getTaint());
        onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(),
                consoleMessage.sourceId());
        boolean var68934A3E9455FA72420237EB05902327_1235736392 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260187323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260187323;
        // ---------- Original Method ----------
        //onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(),
                //consoleMessage.sourceId());
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "B12C654EAF6D1EF1BD2CB65AEE47A82B", hash_generated_method = "E27AC7AC59A324EF4E2847B3DEE98F2C")
    public Bitmap getDefaultVideoPoster() {
Bitmap var540C13E9E156B687226421B24F2DF178_1089706378 =         null;
        var540C13E9E156B687226421B24F2DF178_1089706378.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1089706378;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "72F535BEAD962B4F42D879A83B63BF5A", hash_generated_method = "46ED8132B85308716F41B3CBCB961ED3")
    public View getVideoLoadingProgressView() {
View var540C13E9E156B687226421B24F2DF178_1901397022 =         null;
        var540C13E9E156B687226421B24F2DF178_1901397022.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1901397022;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "15B2ED72F970B566935619473880B5EF", hash_generated_method = "BA512EB5D2761BE8B0438D5D592FEEEA")
    public void getVisitedHistory(ValueCallback<String[]> callback) {
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "DA085B71ADFBAF37C9145F2BAEC7CA78", hash_generated_method = "2D39771A005670BD753C3B0136EC94E3")
    public void openFileChooser(ValueCallback<Uri> uploadFile, String acceptType) {
        addTaint(acceptType.getTaint());
        addTaint(uploadFile.getTaint());
        uploadFile.onReceiveValue(null);
        // ---------- Original Method ----------
        //uploadFile.onReceiveValue(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "BB19EC4B0210D5A42E9ED0382D14771D", hash_generated_method = "3785D8125E00E011E4B23B7F3B399B15")
    public void setInstallableWebApp() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.358 -0400", hash_original_method = "681C2C146739845C582C6BB934543E3C", hash_generated_method = "C666B0A683AEF8D6BD999984A8F9AA26")
    public void setupAutoFill(Message msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    public interface CustomViewCallback {
        
        public void onCustomViewHidden();
    }
    
}

