package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Browser;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.internal.R;

class CallbackProxy extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.146 -0500", hash_original_field = "DD7504E4F438D772A13F5C792C582E02", hash_generated_field = "B8BCB03548AB3F60BD02883254FAF794")

    private static final String LOGTAG = "CallbackProxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.170 -0500", hash_original_field = "26F5D6A2E52928F9DAD6F3EAF4C36E79", hash_generated_field = "848D750C41316648518CD8F70F77F580")

    private static final int PAGE_STARTED                         = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.172 -0500", hash_original_field = "DFF37CE271E464E7A667E28114DA0936", hash_generated_field = "4C070FDA7C3353A448C6DD6B918D4011")

    private static final int RECEIVED_ICON                        = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.174 -0500", hash_original_field = "D26661DE6ED85072E1A9D8D3A984782B", hash_generated_field = "A0CE6E78E934117E9782D63B2FEB087C")

    private static final int RECEIVED_TITLE                       = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.177 -0500", hash_original_field = "53F39FEA98FAD3562A7175DE743C8FE7", hash_generated_field = "8AFE3F0322EFDE154B6ADC96D0D7F5E6")

    private static final int OVERRIDE_URL                         = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.179 -0500", hash_original_field = "86E7807DE9999E2CC535FD55BC48FCCA", hash_generated_field = "0F252CCD54E9D551DB6C5D2B2CA79448")

    private static final int AUTH_REQUEST                         = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.182 -0500", hash_original_field = "43784024F3D97B8E4C6DDD7A9B4CAE3D", hash_generated_field = "9B3FDF63312EC91BBA1DD5F25239A68F")

    private static final int SSL_ERROR                            = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.184 -0500", hash_original_field = "7022B06993A69DDD7BB4F90E94985B30", hash_generated_field = "95DAFA8ADE2A61A20D5E39C60D891614")

    private static final int PROGRESS                             = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.187 -0500", hash_original_field = "7726098981CC483B1F20E70B57AB805D", hash_generated_field = "4049E97E2BE052C03064CA677BE659A0")

    private static final int UPDATE_VISITED                       = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.189 -0500", hash_original_field = "EC061274553445E268D09444B367B6B6", hash_generated_field = "A7A0D1F5ACF78125BCA9701A5CC009E5")

    private static final int LOAD_RESOURCE                        = 108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.191 -0500", hash_original_field = "41307889D1727FAD4B03EF0126F4A6EE", hash_generated_field = "DEA96639CC695B0F757C9B991BCDA133")

    private static final int CREATE_WINDOW                        = 109;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.193 -0500", hash_original_field = "68EFAB26AFDDF53476B5753E55A49961", hash_generated_field = "8EAC4093DD440B6EF00A8E9F4DC1C4E0")

    private static final int CLOSE_WINDOW                         = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.197 -0500", hash_original_field = "BAE53681681FFB0F94B2BC9DEE5DF07E", hash_generated_field = "91798D07F2F908231AFDEFD1E6B2838D")

    private static final int SAVE_PASSWORD                        = 111;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.200 -0500", hash_original_field = "E0FA41165F466E0B9B56AEAB542EB03C", hash_generated_field = "3440F1A73B7E8491DE1EE40C87547131")

    private static final int JS_ALERT                             = 112;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.202 -0500", hash_original_field = "A085050C6A163C4DD0648324B695CD0A", hash_generated_field = "0CC6E044D6D37F23B6E16EA723CABB25")

    private static final int JS_CONFIRM                           = 113;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.204 -0500", hash_original_field = "B4CC9A2593733B0F06E78F0571EC0404", hash_generated_field = "AE03D743830B0E913C9B4A19C334D998")

    private static final int JS_PROMPT                            = 114;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.207 -0500", hash_original_field = "48C95743A9F8815BA84D2E91B013E361", hash_generated_field = "0174398F08F7C02FF7DF4D1A826D4E88")

    private static final int JS_UNLOAD                            = 115;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.209 -0500", hash_original_field = "E4386DBB8AAFE70BBB03FD35061108F8", hash_generated_field = "1E66D85BCF0A6507FE185C0BA8A8AAEC")

    private static final int ASYNC_KEYEVENTS                      = 116;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.212 -0500", hash_original_field = "4A7E4CED0C379A4FE5BC7AD53A402BB4", hash_generated_field = "D3C0B0285F58690CA9C630D2069D9952")

    private static final int DOWNLOAD_FILE                        = 118;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.214 -0500", hash_original_field = "944AE2B04C0279D7D0ECCEE03CC09EF9", hash_generated_field = "0FAC4F6750464F7121676D3E6DA87C34")

    private static final int REPORT_ERROR                         = 119;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.216 -0500", hash_original_field = "FB1D8245F7DF80CA2753CE7405CD5395", hash_generated_field = "6CC195242A0EB566B41683BE41C53B6E")

    private static final int RESEND_POST_DATA                     = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.218 -0500", hash_original_field = "9616DDBEF748F7D8F227AEA300D8785F", hash_generated_field = "9FE3EFB08388A4762A3B4605C12F9F28")

    private static final int PAGE_FINISHED                        = 121;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.221 -0500", hash_original_field = "99B8751076684CC7AA70131A2A9A1F2E", hash_generated_field = "B0B1B74A5F98AF2C70D4F8B3B80DC9F2")

    private static final int REQUEST_FOCUS                        = 122;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.223 -0500", hash_original_field = "FFDCBC229454B5B64E6CDB33F2393869", hash_generated_field = "B265FEFE7FCCDB0139C5B46EFA790F5D")

    private static final int SCALE_CHANGED                        = 123;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.226 -0500", hash_original_field = "BEBAAEC49CA6BFCE29386B087B0A4B54", hash_generated_field = "57532493DFCF0603E50E226A34E196A9")

    private static final int RECEIVED_CERTIFICATE                 = 124;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.228 -0500", hash_original_field = "3C5726B0F159D4AF133AD9145CED5979", hash_generated_field = "C787E348480EC1FDC28655E6D1E02A0E")

    private static final int SWITCH_OUT_HISTORY                   = 125;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.230 -0500", hash_original_field = "8ADE97227F1B56831CB4A844A393E7C5", hash_generated_field = "FB13A89EC337D2294B29823E36FF84A5")

    private static final int EXCEEDED_DATABASE_QUOTA              = 126;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.233 -0500", hash_original_field = "A01F2B656FB55D8FD929264AFAC68188", hash_generated_field = "BC55284D336C0FEA873DFF7A4A688792")

    private static final int REACHED_APPCACHE_MAXSIZE             = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.235 -0500", hash_original_field = "484970663195EF334FA27B712157DFA3", hash_generated_field = "0149997CB5F9EA65E0731208128064F0")

    private static final int JS_TIMEOUT                           = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.237 -0500", hash_original_field = "30719528B6D05AD28F8FF793EBBA2D29", hash_generated_field = "3DEBEE027386C9B59EB8F3BF23830816")

    private static final int ADD_MESSAGE_TO_CONSOLE               = 129;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.241 -0500", hash_original_field = "4C7D7DE3EEEC22EF8C013B951814EF3A", hash_generated_field = "9E058751C8EDCA9A479290263411F486")

    private static final int GEOLOCATION_PERMISSIONS_SHOW_PROMPT  = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.243 -0500", hash_original_field = "4F4B6F6D3EADC5567CB6ACA46403D52A", hash_generated_field = "EBBDFB81B17C0299328881EC5293A04F")

    private static final int GEOLOCATION_PERMISSIONS_HIDE_PROMPT  = 131;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.246 -0500", hash_original_field = "92192EE3D0CF116212EA95EBEF8EC0E9", hash_generated_field = "94BEF01A1474B70C6F1B865162349973")

    private static final int RECEIVED_TOUCH_ICON_URL              = 132;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.248 -0500", hash_original_field = "142D557B39290929B8FAFAB94B13045D", hash_generated_field = "14E0F99C2EE825C2B833110720A4E4A3")

    private static final int GET_VISITED_HISTORY                  = 133;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.250 -0500", hash_original_field = "00BC729179A04D1FFF54336D85DB3EA7", hash_generated_field = "E2026B263FE01AF8EA0927AE63D344F1")

    private static final int OPEN_FILE_CHOOSER                    = 134;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.253 -0500", hash_original_field = "8FD553615EA02A116E52D8AFCC8318E8", hash_generated_field = "345D7B90790909F7DE675D4763166882")

    private static final int ADD_HISTORY_ITEM                     = 135;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.255 -0500", hash_original_field = "74A5B8B5B6E5970465D6C919BB29B6C9", hash_generated_field = "D95397FC5C170E740C5303D3A8A05C5B")

    private static final int HISTORY_INDEX_CHANGED                = 136;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.257 -0500", hash_original_field = "95B21F2C24A6BF6A8B36538D6A84FB0A", hash_generated_field = "3DCF48A106D9F1BE6A3873E099553B4A")

    private static final int AUTH_CREDENTIALS                     = 137;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.260 -0500", hash_original_field = "987D65F524008829ACB186F24F9CD6EC", hash_generated_field = "A3AE08C91BB130064E206832AE02A418")

    private static final int SET_INSTALLABLE_WEBAPP               = 138;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.262 -0500", hash_original_field = "B28816699CF9BFAB588688955B6AD4C5", hash_generated_field = "C24B72196DDD74F7DDF12FB1EB4231BF")

    private static final int NOTIFY_SEARCHBOX_LISTENERS           = 139;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.265 -0500", hash_original_field = "106249966DB4794767615420C7FBA58A", hash_generated_field = "DF1FFC74E56844B757AE85139F652013")

    private static final int AUTO_LOGIN                           = 140;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.267 -0500", hash_original_field = "6389443CBD3C0A49C3EB05874ECD4E92", hash_generated_field = "DD570499086646796ECB453C67DFA7A2")

    private static final int CLIENT_CERT_REQUEST                  = 141;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.269 -0500", hash_original_field = "0CFAD837C13470DAFE9B2E9351E2D2CF", hash_generated_field = "3204AA037B01A2C415DD1AD8899FB540")

    private static final int SEARCHBOX_IS_SUPPORTED_CALLBACK      = 142;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.272 -0500", hash_original_field = "7B83907ADB16AD2DFDECF4957F51FB12", hash_generated_field = "23E6503B9321314390D6CC90C6F99F7C")

    private static final int SEARCHBOX_DISPATCH_COMPLETE_CALLBACK = 143;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.275 -0500", hash_original_field = "CAC9CEAE96D9632086242565D5A0E74E", hash_generated_field = "9051530C94DC9265299E5CDAF9B017D1")

    private static final int PROCEEDED_AFTER_SSL_ERROR            = 144;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.277 -0500", hash_original_field = "3121716653F16E942A1DC59CEFD60F68", hash_generated_field = "00F56014A24A80FE2F3360FDF7B1E405")

    private static final int NOTIFY                               = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.370 -0500", hash_original_field = "E57A1E8BC0FF12F1DBAFE03FB9279931", hash_generated_field = "5A721A5F9F13DD0E478255943C7C4F93")

    // WebViewClient functions.
    // NOTE: shouldOverrideKeyEvent is never called from the WebCore thread so
    // it is not necessary to include it here.
    //--------------------------------------------------------------------------

    // Performance probe
    private static final boolean PERF_PROBE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.148 -0500", hash_original_field = "64A3FAF5845AA7131035F60375BD84AC", hash_generated_field = "6F5FFC523604435BA0DD35F79F6A85A7")

    private volatile WebViewClient mWebViewClient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.151 -0500", hash_original_field = "EA305B9686C8F8A0BEEB051F9FEEB854", hash_generated_field = "63308D14F2EED559304A82F3B2608B81")

    private volatile WebChromeClient mWebChromeClient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.153 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private  WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.156 -0500", hash_original_field = "73C9BF270F62610465B17253197CC25A", hash_generated_field = "28B865E4101EE3CF35095A498919E885")

    private volatile DownloadListener mDownloadListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.158 -0500", hash_original_field = "16E1BCADB00B580EC867DBE75135A50A", hash_generated_field = "1A26E3791D15D6F62673D059D1AEED62")

    private boolean mProgressUpdatePending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.161 -0500", hash_original_field = "D6486F7E17967A32AD01AF024E50D08D", hash_generated_field = "2F198578A265525846C756C4912EFB64")

    // Start with 100 to indicate it is not in load for the empty page.
    private volatile int mLatestProgress = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.163 -0500", hash_original_field = "A10D2A779D38040EB4D09BAFF77529CC", hash_generated_field = "9FEA62D4C2030775B452E5264DAC80A8")

    private  WebBackForwardList mBackForwardList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.165 -0500", hash_original_field = "37AD4709A7DB2C31795BDC1BEAA829E1", hash_generated_field = "4D827BAF16349A0C02C13EAE658A3C84")

    private volatile WebBackForwardListClient mWebBackForwardListClient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.167 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.372 -0500", hash_original_field = "A25E71F04630B8FA027C374E5504F09F", hash_generated_field = "DF2188EEF215035517745E80E9FEC4E8")

    private long mWebCoreThreadTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.374 -0500", hash_original_field = "376225419077C4C9AD478A3936FD628F", hash_generated_field = "7B28D3E8445ABAD93158B33A74B93640")

    private long mWebCoreIdleTime;

    /**
     * Construct a new CallbackProxy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.292 -0500", hash_original_method = "5020D7570AC9675C7FDC286174BD125E", hash_generated_method = "3307EC3ACAFF9D192A5DFA1BA6459FE9")
    
public CallbackProxy(Context context, WebView w) {
        // Used to start a default activity.
        mContext = context;
        mWebView = w;
        mBackForwardList = new WebBackForwardList(this);
    }

    /**
     * Set the WebViewClient.
     * @param client An implementation of WebViewClient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.294 -0500", hash_original_method = "94198B28324F8EDCEFD396927CFF12D2", hash_generated_method = "BD94673FB310D96D529F6C9EED82FE04")
    
public void setWebViewClient(WebViewClient client) {
        mWebViewClient = client;
    }

    /**
     * Get the WebViewClient.
     * @return the current WebViewClient instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.296 -0500", hash_original_method = "F1A871AF9A3B10055BFFA9DC06A940C2", hash_generated_method = "D26228EECBDC7C3D2A75E622BC477A13")
    
public WebViewClient getWebViewClient() {
       return mWebViewClient;
    }

    /**
     * Set the WebChromeClient.
     * @param client An implementation of WebChromeClient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.298 -0500", hash_original_method = "92EB7E506A2EF4886CBEC1480289BCB6", hash_generated_method = "CD9580DA90300FA336F0CF8DF50CAF01")
    
public void setWebChromeClient(WebChromeClient client) {
        mWebChromeClient = client;
    }

    /**
     * Get the WebChromeClient.
     * @return the current WebChromeClient instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.300 -0500", hash_original_method = "578C7E32D2B540B07E657C95C84E837C", hash_generated_method = "D67BF301DD22BF2DCE8377F5F37BD801")
    
public WebChromeClient getWebChromeClient() {
       return mWebChromeClient;
    }

    /**
     * Set the client DownloadListener.
     * @param client An implementation of DownloadListener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.302 -0500", hash_original_method = "36DD14932709DFA3D074F96EC9039EDA", hash_generated_method = "8AEED75DFA9E5140AD126708A3E205BE")
    
public void setDownloadListener(DownloadListener client) {
        mDownloadListener = client;
        if (client != null) {
        }
    }

    /**
     * Get the Back/Forward list to return to the user or to update the cached
     * history list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.304 -0500", hash_original_method = "2A97B39171573BABF631C9DB7E378DC9", hash_generated_method = "6BE2FD83637C6A3DF0288107FC7A722F")
    
public WebBackForwardList getBackForwardList() {
        return mBackForwardList;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.306 -0500", hash_original_method = "69271AEE54C61C015B6B50CD212FE110", hash_generated_method = "69271AEE54C61C015B6B50CD212FE110")
    
void setWebBackForwardListClient(WebBackForwardListClient client) {
        mWebBackForwardListClient = client;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.308 -0500", hash_original_method = "32023A06CFA84B93B3A0030ADE6E4A41", hash_generated_method = "32023A06CFA84B93B3A0030ADE6E4A41")
    
WebBackForwardListClient getWebBackForwardListClient() {
        return mWebBackForwardListClient;
    }

    /**
     * Called by the UI side.  Calling overrideUrlLoading from the WebCore
     * side will post a message to call this method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.311 -0500", hash_original_method = "43AE5B1BF40E67157C7361E5EC862A6C", hash_generated_method = "77FCB2DD35C0BD735FD6211133F153EF")
    @DSVerified
    @DSSpec(DSCat.ANDROID_ACTIVITY_STARTING)
public boolean uiOverrideUrlLoading(String overrideUrl) {
        if (overrideUrl == null || overrideUrl.length() == 0) {
            return false;
        }
        boolean override = false;
        if (mWebViewClient != null) {
            override = mWebViewClient.shouldOverrideUrlLoading(mWebView,
                    overrideUrl);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(overrideUrl));
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            // If another application is running a WebView and launches the
            // Browser through this Intent, we want to reuse the same window if
            // possible.
            intent.putExtra(Browser.EXTRA_APPLICATION_ID,
                    mContext.getPackageName());
            try {
                mContext.startActivity(intent);
                override = true;
            } catch (ActivityNotFoundException ex) {
                // If no application can handle the URL, assume that the
                // browser can handle it.
            }
        }
        return override;
    }

    /**
     * Called by UI side.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.313 -0500", hash_original_method = "D32407A1261408285F08570A8F2494B0", hash_generated_method = "ED8F22F63B370289A396B2E826A8FAF9")
    
public boolean uiOverrideKeyEvent(KeyEvent event) {
        if (mWebViewClient != null) {
            return mWebViewClient.shouldOverrideKeyEvent(mWebView, event);
        }
        return false;
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.360 -0500", hash_original_method = "643B690E8360A657B90F531CC63147C4", hash_generated_method = "57CA8927B98B324A5347346B5B3E275D")
    
@Override
    public void handleMessage(Message msg) {
        // We don't have to do synchronization because this function operates
        // in the UI thread. The WebViewClient and WebChromeClient functions
        // that check for a non-null callback are ok because java ensures atomic
        // 32-bit reads and writes.
        switch (msg.what) {
            case PAGE_STARTED:
                String startedUrl = msg.getData().getString("url");
                mWebView.onPageStarted(startedUrl);
                if (mWebViewClient != null) {
                    mWebViewClient.onPageStarted(mWebView, startedUrl, (Bitmap) msg.obj);
                }
                break;

            case PAGE_FINISHED:
                String finishedUrl = (String) msg.obj;
                mWebView.onPageFinished(finishedUrl);
                if (mWebViewClient != null) {
                    mWebViewClient.onPageFinished(mWebView, finishedUrl);
                }
                break;

            case RECEIVED_ICON:
                if (mWebChromeClient != null) {
                    mWebChromeClient.onReceivedIcon(mWebView, (Bitmap) msg.obj);
                }
                break;

            case RECEIVED_TOUCH_ICON_URL:
                if (mWebChromeClient != null) {
                    mWebChromeClient.onReceivedTouchIconUrl(mWebView,
                            (String) msg.obj, msg.arg1 == 1);
                }
                break;

            case RECEIVED_TITLE:
                if (mWebChromeClient != null) {
                    mWebChromeClient.onReceivedTitle(mWebView,
                            (String) msg.obj);
                }
                break;

            case REPORT_ERROR:
                if (mWebViewClient != null) {
                    int reasonCode = msg.arg1;
                    final String description  = msg.getData().getString("description");
                    final String failUrl  = msg.getData().getString("failingUrl");
                    mWebViewClient.onReceivedError(mWebView, reasonCode,
                            description, failUrl);
                }
                break;

            case RESEND_POST_DATA:
                Message resend =
                        (Message) msg.getData().getParcelable("resend");
                Message dontResend =
                        (Message) msg.getData().getParcelable("dontResend");
                if (mWebViewClient != null) {
                    mWebViewClient.onFormResubmission(mWebView, dontResend,
                            resend);
                } else {
                    dontResend.sendToTarget();
                }
                break;

            case OVERRIDE_URL:
                String overrideUrl = msg.getData().getString("url");
                boolean override = uiOverrideUrlLoading(overrideUrl);
                ResultTransport<Boolean> result =
                        (ResultTransport<Boolean>) msg.obj;
                synchronized (this) {
                    result.setResult(override);
                    notify();
                }
                break;

            case AUTH_REQUEST:
                if (mWebViewClient != null) {
                    HttpAuthHandler handler = (HttpAuthHandler) msg.obj;
                    String host = msg.getData().getString("host");
                    String realm = msg.getData().getString("realm");
                    mWebViewClient.onReceivedHttpAuthRequest(mWebView, handler,
                            host, realm);
                }
                break;

            case SSL_ERROR:
                if (mWebViewClient != null) {
                    HashMap<String, Object> map =
                        (HashMap<String, Object>) msg.obj;
                    mWebViewClient.onReceivedSslError(mWebView,
                            (SslErrorHandler) map.get("handler"),
                            (SslError) map.get("error"));
                }
                break;

            case PROCEEDED_AFTER_SSL_ERROR:
                if (mWebViewClient != null) {
                    mWebViewClient.onProceededAfterSslError(mWebView,
                            (SslError) msg.obj);
                }
                break;

            case CLIENT_CERT_REQUEST:
                if (mWebViewClient != null) {
                    HashMap<String, Object> map =
                        (HashMap<String, Object>) msg.obj;
                    mWebViewClient.onReceivedClientCertRequest(mWebView,
                            (ClientCertRequestHandler) map.get("handler"),
                            (String) map.get("host_and_port"));
                }
                break;

            case PROGRESS:
                // Synchronize to ensure mLatestProgress is not modified after
                // setProgress is called and before mProgressUpdatePending is
                // changed.
                synchronized (this) {
                    if (mWebChromeClient != null) {
                        mWebChromeClient.onProgressChanged(mWebView,
                                mLatestProgress);
                    }
                    mProgressUpdatePending = false;
                }
                break;

            case UPDATE_VISITED:
                if (mWebViewClient != null) {
                    mWebViewClient.doUpdateVisitedHistory(mWebView,
                            (String) msg.obj, msg.arg1 != 0);
                }
                break;

            case LOAD_RESOURCE:
                if (mWebViewClient != null) {
                    mWebViewClient.onLoadResource(mWebView, (String) msg.obj);
                }
                break;

            case DOWNLOAD_FILE:
                if (mDownloadListener != null) {
                    String url = msg.getData().getString("url");
                    String userAgent = msg.getData().getString("userAgent");
                    String contentDisposition =
                        msg.getData().getString("contentDisposition");
                    String mimetype = msg.getData().getString("mimetype");
                    Long contentLength = msg.getData().getLong("contentLength");
                    mDownloadListener.onDownloadStart(url, userAgent,
                            contentDisposition, mimetype, contentLength);
                }
                break;

            case CREATE_WINDOW:
                if (mWebChromeClient != null) {
                    if (!mWebChromeClient.onCreateWindow(mWebView,
                                msg.arg1 == 1, msg.arg2 == 1,
                                (Message) msg.obj)) {
                        synchronized (this) {
                            notify();
                        }
                    }
                    mWebView.dismissZoomControl();
                }
                break;

            case REQUEST_FOCUS:
                if (mWebChromeClient != null) {
                    mWebChromeClient.onRequestFocus(mWebView);
                }
                break;

            case CLOSE_WINDOW:
                if (mWebChromeClient != null) {
                    mWebChromeClient.onCloseWindow((WebView) msg.obj);
                }
                break;

            case SAVE_PASSWORD:
                Bundle bundle = msg.getData();
                String schemePlusHost = bundle.getString("host");
                String username = bundle.getString("username");
                String password = bundle.getString("password");
                // If the client returned false it means that the notify message
                // will not be sent and we should notify WebCore ourselves.
                if (!mWebView.onSavePassword(schemePlusHost, username, password,
                            (Message) msg.obj)) {
                    synchronized (this) {
                        notify();
                    }
                }
                break;

            case ASYNC_KEYEVENTS:
                if (mWebViewClient != null) {
                    mWebViewClient.onUnhandledKeyEvent(mWebView,
                            (KeyEvent) msg.obj);
                }
                break;

            case EXCEEDED_DATABASE_QUOTA:
                if (mWebChromeClient != null) {
                    HashMap<String, Object> map =
                            (HashMap<String, Object>) msg.obj;
                    String databaseIdentifier =
                            (String) map.get("databaseIdentifier");
                    String url = (String) map.get("url");
                    long currentQuota =
                            ((Long) map.get("currentQuota")).longValue();
                    long totalUsedQuota =
                            ((Long) map.get("totalUsedQuota")).longValue();
                    long estimatedSize =
                            ((Long) map.get("estimatedSize")).longValue();
                    WebStorage.QuotaUpdater quotaUpdater =
                        (WebStorage.QuotaUpdater) map.get("quotaUpdater");

                    mWebChromeClient.onExceededDatabaseQuota(url,
                            databaseIdentifier, currentQuota, estimatedSize,
                            totalUsedQuota, quotaUpdater);
                }
                break;

            case REACHED_APPCACHE_MAXSIZE:
                if (mWebChromeClient != null) {
                    HashMap<String, Object> map =
                            (HashMap<String, Object>) msg.obj;
                    long spaceNeeded =
                            ((Long) map.get("spaceNeeded")).longValue();
                    long totalUsedQuota =
                        ((Long) map.get("totalUsedQuota")).longValue();
                    WebStorage.QuotaUpdater quotaUpdater =
                        (WebStorage.QuotaUpdater) map.get("quotaUpdater");

                    mWebChromeClient.onReachedMaxAppCacheSize(spaceNeeded,
                            totalUsedQuota, quotaUpdater);
                }
                break;

            case GEOLOCATION_PERMISSIONS_SHOW_PROMPT:
                if (mWebChromeClient != null) {
                    HashMap<String, Object> map =
                            (HashMap<String, Object>) msg.obj;
                    String origin = (String) map.get("origin");
                    GeolocationPermissions.Callback callback =
                            (GeolocationPermissions.Callback)
                            map.get("callback");
                    mWebChromeClient.onGeolocationPermissionsShowPrompt(origin,
                            callback);
                }
                break;

            case GEOLOCATION_PERMISSIONS_HIDE_PROMPT:
                if (mWebChromeClient != null) {
                    mWebChromeClient.onGeolocationPermissionsHidePrompt();
                }
                break;

            case JS_ALERT:
                if (mWebChromeClient != null) {
                    final JsResult res = (JsResult) msg.obj;
                    String message = msg.getData().getString("message");
                    String url = msg.getData().getString("url");
                    if (!mWebChromeClient.onJsAlert(mWebView, url, message,
                            res)) {
                        if (!canShowAlertDialog()) {
                            res.cancel();
                            res.setReady();
                            break;
                        }
                        new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setMessage(message)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                res.confirm();
                                            }
                                        })
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {
                                            public void onCancel(
                                                    DialogInterface dialog) {
                                                res.cancel();
                                            }
                                        })
                                .show();
                    }
                    res.setReady();
                }
                break;

            case JS_CONFIRM:
                if (mWebChromeClient != null) {
                    final JsResult res = (JsResult) msg.obj;
                    String message = msg.getData().getString("message");
                    String url = msg.getData().getString("url");
                    if (!mWebChromeClient.onJsConfirm(mWebView, url, message,
                            res)) {
                        if (!canShowAlertDialog()) {
                            res.cancel();
                            res.setReady();
                            break;
                        }
                        new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setMessage(message)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                res.confirm();
                                            }})
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                res.cancel();
                                            }})
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {
                                            public void onCancel(
                                                    DialogInterface dialog) {
                                                res.cancel();
                                            }
                                        })
                                .show();
                    }
                    // Tell the JsResult that it is ready for client
                    // interaction.
                    res.setReady();
                }
                break;

            case JS_PROMPT:
                if (mWebChromeClient != null) {
                    final JsPromptResult res = (JsPromptResult) msg.obj;
                    String message = msg.getData().getString("message");
                    String defaultVal = msg.getData().getString("default");
                    String url = msg.getData().getString("url");
                    if (!mWebChromeClient.onJsPrompt(mWebView, url, message,
                                defaultVal, res)) {
                        if (!canShowAlertDialog()) {
                            res.cancel();
                            res.setReady();
                            break;
                        }
                        final LayoutInflater factory = LayoutInflater
                                .from(mContext);
                        final View view = factory.inflate(R.layout.js_prompt,
                                null);
                        final EditText v = (EditText) view
                                .findViewById(R.id.value);
                        v.setText(defaultVal);
                        ((TextView) view.findViewById(R.id.message))
                                .setText(message);
                        new AlertDialog.Builder(mContext)
                                .setTitle(getJsDialogTitle(url))
                                .setView(view)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
                                                res.confirm(v.getText()
                                                        .toString());
                                            }
                                        })
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int whichButton) {
                                                res.cancel();
                                            }
                                        })
                                .setOnCancelListener(
                                        new DialogInterface.OnCancelListener() {
                                            public void onCancel(
                                                    DialogInterface dialog) {
                                                res.cancel();
                                            }
                                        })
                                .show();
                    }
                    // Tell the JsResult that it is ready for client
                    // interaction.
                    res.setReady();
                }
                break;

            case JS_UNLOAD:
                if (mWebChromeClient != null) {
                    final JsResult res = (JsResult) msg.obj;
                    String message = msg.getData().getString("message");
                    String url = msg.getData().getString("url");
                    if (!mWebChromeClient.onJsBeforeUnload(mWebView, url,
                            message, res)) {
                        if (!canShowAlertDialog()) {
                            res.cancel();
                            res.setReady();
                            break;
                        }
                        final String m = mContext.getString(
                                R.string.js_dialog_before_unload, message);
                        new AlertDialog.Builder(mContext)
                                .setMessage(m)
                                .setPositiveButton(R.string.ok,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                res.confirm();
                                            }
                                        })
                                .setNegativeButton(R.string.cancel,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                res.cancel();
                                            }
                                        })
                                .show();
                    }
                    res.setReady();
                }
                break;

            case JS_TIMEOUT:
                if(mWebChromeClient != null) {
                    final JsResult res = (JsResult) msg.obj;
                    if(mWebChromeClient.onJsTimeout()) {
                        res.confirm();
                    } else {
                        res.cancel();
                    }
                    res.setReady();
                }
                break;

            case RECEIVED_CERTIFICATE:
                mWebView.setCertificate((SslCertificate) msg.obj);
                break;

            case NOTIFY:
                synchronized (this) {
                    notify();
                }
                break;

            case SCALE_CHANGED:
                if (mWebViewClient != null) {
                    mWebViewClient.onScaleChanged(mWebView, msg.getData()
                            .getFloat("old"), msg.getData().getFloat("new"));
                }
                break;

            case SWITCH_OUT_HISTORY:
                mWebView.switchOutDrawHistory();
                break;

            case ADD_MESSAGE_TO_CONSOLE:
                if (mWebChromeClient == null) {
                    break;
                }
                String message = msg.getData().getString("message");
                String sourceID = msg.getData().getString("sourceID");
                int lineNumber = msg.getData().getInt("lineNumber");
                int msgLevel = msg.getData().getInt("msgLevel");
                int numberOfMessageLevels = ConsoleMessage.MessageLevel.values().length;
                // Sanity bounds check as we'll index an array with msgLevel
                if (msgLevel < 0 || msgLevel >= numberOfMessageLevels) {
                    msgLevel = 0;
                }

                ConsoleMessage.MessageLevel messageLevel =
                        ConsoleMessage.MessageLevel.values()[msgLevel];

                if (!mWebChromeClient.onConsoleMessage(new ConsoleMessage(message, sourceID,
                        lineNumber, messageLevel))) {
                    // If false was returned the user did not provide their own console function so
                    //  we should output some default messages to the system log.
                    String logTag = "Web Console";
                    String logMessage = message + " at " + sourceID + ":" + lineNumber;

                    switch (messageLevel) {
                        case TIP:
                            Log.v(logTag, logMessage);
                            break;
                        case LOG:
                            Log.i(logTag, logMessage);
                            break;
                        case WARNING:
                            Log.w(logTag, logMessage);
                            break;
                        case ERROR:
                            Log.e(logTag, logMessage);
                            break;
                        case DEBUG:
                            Log.d(logTag, logMessage);
                            break;
                    }
                }

                break;

            case GET_VISITED_HISTORY:
                if (mWebChromeClient != null) {
                    mWebChromeClient.getVisitedHistory((ValueCallback<String[]>)msg.obj);
                }
                break;

            case OPEN_FILE_CHOOSER:
                if (mWebChromeClient != null) {
                    UploadFileMessageData data = (UploadFileMessageData)msg.obj;
                    mWebChromeClient.openFileChooser(data.getUploadFile(), data.getAcceptType());
                }
                break;

            case ADD_HISTORY_ITEM:
                if (mWebBackForwardListClient != null) {
                    mWebBackForwardListClient.onNewHistoryItem(
                            (WebHistoryItem) msg.obj);
                }
                break;

            case HISTORY_INDEX_CHANGED:
                if (mWebBackForwardListClient != null) {
                    mWebBackForwardListClient.onIndexChanged(
                            (WebHistoryItem) msg.obj, msg.arg1);
                }
                break;
            case AUTH_CREDENTIALS: {
                String host = msg.getData().getString("host");
                String realm = msg.getData().getString("realm");
                username = msg.getData().getString("username");
                password = msg.getData().getString("password");
                mWebView.setHttpAuthUsernamePassword(
                        host, realm, username, password);
                break;
            }
            case SET_INSTALLABLE_WEBAPP:
                if (mWebChromeClient != null) {
                    mWebChromeClient.setInstallableWebApp();
                }
                break;
            case NOTIFY_SEARCHBOX_LISTENERS: {
                SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();

                @SuppressWarnings("unchecked")
                List<String> suggestions = (List<String>) msg.obj;
                searchBox.handleSuggestions(msg.getData().getString("query"), suggestions);
                break;
            }
            case AUTO_LOGIN: {
                if (mWebViewClient != null) {
                    String realm = msg.getData().getString("realm");
                    String account = msg.getData().getString("account");
                    String args = msg.getData().getString("args");
                    mWebViewClient.onReceivedLoginRequest(mWebView, realm,
                            account, args);
                }
                break;
            }
            case SEARCHBOX_IS_SUPPORTED_CALLBACK: {
                SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
                Boolean supported = (Boolean) msg.obj;
                searchBox.handleIsSupportedCallback(supported);
                break;
            }
            case SEARCHBOX_DISPATCH_COMPLETE_CALLBACK: {
                SearchBoxImpl searchBox = (SearchBoxImpl) mWebView.getSearchBox();
                Boolean success = (Boolean) msg.obj;
                searchBox.handleDispatchCompleteCallback(msg.getData().getString("function"),
                        msg.getData().getInt("id"), success);
                break;
            }
        }
    }

    /**
     * Return the latest progress.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.363 -0500", hash_original_method = "F4FA55F4EB9CE414FB8C02AF96B11745", hash_generated_method = "886D759526B4E918F1D3A1B99474A1F3")
    
public int getProgress() {
        return mLatestProgress;
    }
    
    private static class ResultTransport<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.280 -0500", hash_original_field = "C13B321A38074A0309A54D3D8023D02F", hash_generated_field = "8FF1976BF201D1F418EC84B9D35E5FAC")

        private E mResult;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.282 -0500", hash_original_method = "DD22213D197BC89445531F8496343FB8", hash_generated_method = "BA16ED2D1E99517E4221641F3574908F")
        
public ResultTransport(E defaultResult) {
            mResult = defaultResult;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.284 -0500", hash_original_method = "23B0DB25EF15209B12B4D98F75BC4826", hash_generated_method = "2D1DEDBD3EB171156A8B6EA6B9D9D8C9")
        
public synchronized void setResult(E result) {
            mResult = result;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.287 -0500", hash_original_method = "67EA7E4C242F8EF7A6CF084AEA447779", hash_generated_method = "F142C47FF8D1328273469DC02D7AEB01")
        
public synchronized E getResult() {
            return mResult;
        }
        
    }
    
    private static class UploadFileMessageData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.467 -0500", hash_original_field = "730E2803C3CB04DAD243EDB36218CA00", hash_generated_field = "141E146BCCC9E44E04F619B70ED78B17")

        private UploadFile mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.470 -0500", hash_original_field = "415E4F0173CA7B3EC7012F58C04C874C", hash_generated_field = "F1FEB7E52B3D4A532C0192C9EE3750CA")

        private String mAcceptType;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.472 -0500", hash_original_method = "506E5829DE4CA65822239D45E416BF71", hash_generated_method = "28654022368B3994DEFD317066BD07D6")
        
public UploadFileMessageData(UploadFile uploadFile, String acceptType) {
            mCallback = uploadFile;
            mAcceptType = acceptType;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.475 -0500", hash_original_method = "9D48109A15DDC7CFDE503C879117A387", hash_generated_method = "8664FDC21584D2830235AC34A6690D5C")
        
public UploadFile getUploadFile() {
            return mCallback;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.477 -0500", hash_original_method = "EE5645A876B8829341B5E714F10E353A", hash_generated_method = "72D9D0D3A142378C12634BFC271DA866")
        
public String getAcceptType() {
            return mAcceptType;
        }
        
    }
    
    private class UploadFile implements ValueCallback<Uri> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.481 -0500", hash_original_field = "5313D513DFCA6ABC354AE3BE1634D7D1", hash_generated_field = "D24B10CB4DFA145F1AD29B267930EA48")

        private Uri mValue;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.883 -0400", hash_original_method = "CA5F2E6F07869C80D280CD39F96B8098", hash_generated_method = "CA5F2E6F07869C80D280CD39F96B8098")
        public UploadFile ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.484 -0500", hash_original_method = "4E719BBCA95A35A86F37F83B7E6AA557", hash_generated_method = "6EDD6DB37643B812AC7DE64826C06DB7")
        
public void onReceiveValue(Uri value) {
            mValue = value;
            synchronized (CallbackProxy.this) {
                CallbackProxy.this.notify();
            }
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.487 -0500", hash_original_method = "546BF3EDB8840D5BF09D8B66103FFEC6", hash_generated_method = "B9C522A3A94306FE6506FA26199B9892")
        
public Uri getResult() {
            return mValue;
        }
        
    }

    /**
     * Called by WebCore side to switch out of history Picture drawing mode
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.365 -0500", hash_original_method = "ADEA75F6BB5426452E05F86965232852", hash_generated_method = "ADEA75F6BB5426452E05F86965232852")
    
void switchOutDrawHistory() {
        sendMessage(obtainMessage(SWITCH_OUT_HISTORY));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.836 -0400", hash_original_method = "2F62F4E531DE0AF4C82D66205801E78A", hash_generated_method = "239292A03E2A1C8071CF2D7C707703DE")
    private String getJsDialogTitle(String url) {
        addTaint(url.getTaint());
        String title = url;
        if(URLUtil.isDataUrl(url))        
        {
            title = mContext.getString(R.string.js_dialog_title_default);
        } //End block
        else
        {
            try 
            {
                URL aUrl = new URL(url);
                title = mContext.getString(R.string.js_dialog_title,
                        aUrl.getProtocol() + "://" + aUrl.getHost());
            } //End block
            catch (MalformedURLException ex)
            {
            } //End block
        } //End block
String varCD126D34DD1576383395AEE5945E9C28_1967986208 =         title;
        varCD126D34DD1576383395AEE5945E9C28_1967986208.addTaint(getTaint());
        return varCD126D34DD1576383395AEE5945E9C28_1967986208;
        // ---------- Original Method ----------
        //String title = url;
        //if (URLUtil.isDataUrl(url)) {
            //title = mContext.getString(R.string.js_dialog_title_default);
        //} else {
            //try {
                //URL aUrl = new URL(url);
                //title = mContext.getString(R.string.js_dialog_title,
                        //aUrl.getProtocol() + "://" + aUrl.getHost());
            //} catch (MalformedURLException ex) {
            //}
        //}
        //return title;
    }

    /*
     * If PERF_PROBE is true, this block needs to be added to MessageQueue.java.
     * startWait() and finishWait() should be called before and after wait().

    private WaitCallback mWaitCallback = null;
    public static interface WaitCallback {
        void startWait();
        void finishWait();
    }
    public final void setWaitCallback(WaitCallback callback) {
        mWaitCallback = callback;
    }
    */

    // un-comment this block if PERF_PROBE is true
    /*
    private IdleCallback mIdleCallback = new IdleCallback();

    private final class IdleCallback implements MessageQueue.WaitCallback {
        private long mStartTime = 0;

        public void finishWait() {
            mWebCoreIdleTime += SystemClock.uptimeMillis() - mStartTime;
        }

        public void startWait() {
            mStartTime = SystemClock.uptimeMillis();
        }
    }
    */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.377 -0500", hash_original_method = "FEA38F8F6B5615AC736396CA90380013", hash_generated_method = "91D172178D88C4DB31301C2E307BCC90")
    
public void onPageStarted(String url, Bitmap favicon) {
        // We need to send the message even if no WebViewClient is set, because we need to call
        // WebView.onPageStarted().

        // Performance probe
        if (PERF_PROBE) {
            mWebCoreThreadTime = SystemClock.currentThreadTimeMillis();
            mWebCoreIdleTime = 0;
            Network.getInstance(mContext).startTiming();
            // un-comment this if PERF_PROBE is true
//            Looper.myQueue().setWaitCallback(mIdleCallback);
        }
        Message msg = obtainMessage(PAGE_STARTED);
        msg.obj = favicon;
        msg.getData().putString("url", url);
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.380 -0500", hash_original_method = "0C202F92443A2E2B58845ECCCDAD23DA", hash_generated_method = "CAFDA78C9A7B36CC4AEC3941C215B740")
    
public void onPageFinished(String url) {
        // Performance probe
        if (PERF_PROBE) {
            // un-comment this if PERF_PROBE is true
//            Looper.myQueue().setWaitCallback(null);
            Log.d("WebCore", "WebCore thread used " +
                    (SystemClock.currentThreadTimeMillis() - mWebCoreThreadTime)
                    + " ms and idled " + mWebCoreIdleTime + " ms");
            Network.getInstance(mContext).stopTiming();
        }
        Message msg = obtainMessage(PAGE_FINISHED, url);
        sendMessage(msg);
    }

    // Because this method is public and because CallbackProxy is mistakenly
    // party of the public classes, we cannot remove this method.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.382 -0500", hash_original_method = "CAA94892A4D7B008F19D8BD2AD9FB2D3", hash_generated_method = "74445500E16E79D626A3000C3ADE1550")
    
public void onTooManyRedirects(Message cancelMsg, Message continueMsg) {
        // deprecated.
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.385 -0500", hash_original_method = "E5C6F1F12DEE48235072B52E91052ED8", hash_generated_method = "0ABCE03DC37A9ACCF66B5792B083591E")
    
public void onReceivedError(int errorCode, String description,
            String failingUrl) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            return;
        }

        Message msg = obtainMessage(REPORT_ERROR);
        msg.arg1 = errorCode;
        msg.getData().putString("description", description);
        msg.getData().putString("failingUrl", failingUrl);
        sendMessage(msg);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.387 -0500", hash_original_method = "5E30734A74D85B2FEB399A04359A0FF5", hash_generated_method = "2386A9D1BBD50B32D795A2A9FFC8B055")
    
public void onFormResubmission(Message dontResend,
            Message resend) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            dontResend.sendToTarget();
            return;
        }

        Message msg = obtainMessage(RESEND_POST_DATA);
        Bundle bundle = msg.getData();
        bundle.putParcelable("resend", resend);
        bundle.putParcelable("dontResend", dontResend);
        sendMessage(msg);
    }

    /**
     * Called by the WebCore side
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.389 -0500", hash_original_method = "6A31F6EEFC7A56081588A72CFCF2411E", hash_generated_method = "C3EFCEFD670D6F541200D7B9FEC157C9")
    
public boolean shouldOverrideUrlLoading(String url) {
        // We have a default behavior if no client exists so always send the
        // message.
        ResultTransport<Boolean> res = new ResultTransport<Boolean>(false);
        Message msg = obtainMessage(OVERRIDE_URL);
        msg.getData().putString("url", url);
        msg.obj = res;
        synchronized (this) {
            sendMessage(msg);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for overrideUrl");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return res.getResult().booleanValue();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.392 -0500", hash_original_method = "4FA57A455CA03EC6D649ED38E4E56F01", hash_generated_method = "BD4E6242F8F93B85C93C30B9C9592776")
    
public void onReceivedHttpAuthRequest(HttpAuthHandler handler,
            String hostName, String realmName) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            handler.cancel();
            return;
        }
        Message msg = obtainMessage(AUTH_REQUEST, handler);
        msg.getData().putString("host", hostName);
        msg.getData().putString("realm", realmName);
        sendMessage(msg);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.394 -0500", hash_original_method = "8BC2AAF24BCB58C98055A520D9453CBA", hash_generated_method = "8F3AF956262433DCF879FCF3AFE458BD")
    
public void onReceivedSslError(SslErrorHandler handler, SslError error) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            handler.cancel();
            return;
        }
        Message msg = obtainMessage(SSL_ERROR);
        HashMap<String, Object> map = new HashMap();
        map.put("handler", handler);
        map.put("error", error);
        msg.obj = map;
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.397 -0500", hash_original_method = "024A377297E93EBA7DF0A134D94D78F7", hash_generated_method = "4A37451A903E3BA2B5A61856AFC95E42")
    
public void onProceededAfterSslError(SslError error) {
        if (mWebViewClient == null) {
            return;
        }
        Message msg = obtainMessage(PROCEEDED_AFTER_SSL_ERROR);
        msg.obj = error;
        sendMessage(msg);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.399 -0500", hash_original_method = "86B49DF771A8EEA4B9DCFCD28BAACF5B", hash_generated_method = "0EDDD42EE012BC0BA9A2D0A07A5D4C20")
    
public void onReceivedClientCertRequest(ClientCertRequestHandler handler, String host_and_port) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            handler.cancel();
            return;
        }
        Message msg = obtainMessage(CLIENT_CERT_REQUEST);
        HashMap<String, Object> map = new HashMap();
        map.put("handler", handler);
        map.put("host_and_port", host_and_port);
        msg.obj = map;
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.401 -0500", hash_original_method = "39DDC3E15586955BE54A8DF95CFEEEEF", hash_generated_method = "2A53DB5F15440C61108092BB38C01852")
    
public void onReceivedCertificate(SslCertificate certificate) {
        // here, certificate can be null (if the site is not secure)
        sendMessage(obtainMessage(RECEIVED_CERTIFICATE, certificate));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.403 -0500", hash_original_method = "1419AC91B69314146C4F39503A4D545B", hash_generated_method = "AA3A7E3188EF36AD82DCBCAEEBF6EB7D")
    
public void doUpdateVisitedHistory(String url, boolean isReload) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            return;
        }
        sendMessage(obtainMessage(UPDATE_VISITED, isReload ? 1 : 0, 0, url));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.406 -0500", hash_original_method = "E95ED4984215917AB442D7D69416BDAD", hash_generated_method = "84D2EF311938B67022B57B3805091121")
    
WebResourceResponse shouldInterceptRequest(String url) {
        if (mWebViewClient == null) {
            return null;
        }
        // Note: This method does _not_ send a message.
        WebResourceResponse r =
                mWebViewClient.shouldInterceptRequest(mWebView, url);
        if (r == null) {
            sendMessage(obtainMessage(LOAD_RESOURCE, url));
        }
        return r;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.408 -0500", hash_original_method = "AE6FAC3658CBE746F7970ADD50E1DD7A", hash_generated_method = "1AB3DE97524D42BAE03C6DFDC1253017")
    
public void onUnhandledKeyEvent(KeyEvent event) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            return;
        }
        sendMessage(obtainMessage(ASYNC_KEYEVENTS, event));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.410 -0500", hash_original_method = "32F0A585D03AD391628455766053FDEF", hash_generated_method = "A99349676DDAA42398CC7EC57D87817C")
    
public void onScaleChanged(float oldScale, float newScale) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            return;
        }
        Message msg = obtainMessage(SCALE_CHANGED);
        Bundle bundle = msg.getData();
        bundle.putFloat("old", oldScale);
        bundle.putFloat("new", newScale);
        sendMessage(msg);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.412 -0500", hash_original_method = "96CFDF49B56568DC278F123893B1481C", hash_generated_method = "B8B064A8FB5EC16B2D709389F7F5BC3A")
    
void onReceivedLoginRequest(String realm, String account, String args) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebViewClient == null) {
            return;
        }
        Message msg = obtainMessage(AUTO_LOGIN);
        Bundle bundle = msg.getData();
        bundle.putString("realm", realm);
        bundle.putString("account", account);
        bundle.putString("args", args);
        sendMessage(msg);
    }

    //--------------------------------------------------------------------------
    // DownloadListener functions.
    //--------------------------------------------------------------------------

    /**
     * Starts a download if a download listener has been registered, otherwise
     * return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.414 -0500", hash_original_method = "757A7F1755FBEFCF499F2AF609552311", hash_generated_method = "668D0695CBFE9527D8AC9CE7602B8447")
    
public boolean onDownloadStart(String url, String userAgent,
            String contentDisposition, String mimetype, long contentLength) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mDownloadListener == null) {
            // Cancel the download if there is no browser client.
            return false;
        }

        Message msg = obtainMessage(DOWNLOAD_FILE);
        Bundle bundle = msg.getData();
        bundle.putString("url", url);
        bundle.putString("userAgent", userAgent);
        bundle.putString("mimetype", mimetype);
        bundle.putLong("contentLength", contentLength);
        bundle.putString("contentDisposition", contentDisposition);
        sendMessage(msg);
        return true;
    }

    //--------------------------------------------------------------------------
    // WebView specific functions that do not interact with a client. These
    // functions just need to operate within the UI thread.
    //--------------------------------------------------------------------------

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.417 -0500", hash_original_method = "E36C2E9038F101EB831B9776820C94AF", hash_generated_method = "87ADD216F5284C663BE60BDDF26D8EF3")
    
public boolean onSavePassword(String schemePlusHost, String username,
            String password, Message resumeMsg) {
        // resumeMsg should be null at this point because we want to create it
        // within the CallbackProxy.
        if (DebugFlags.CALLBACK_PROXY) {
            junit.framework.Assert.assertNull(resumeMsg);
        }
        resumeMsg = obtainMessage(NOTIFY);

        Message msg = obtainMessage(SAVE_PASSWORD, resumeMsg);
        Bundle bundle = msg.getData();
        bundle.putString("host", schemePlusHost);
        bundle.putString("username", username);
        bundle.putString("password", password);
        synchronized (this) {
            sendMessage(msg);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG,
                        "Caught exception while waiting for onSavePassword");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        // Doesn't matter here
        return false;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.421 -0500", hash_original_method = "FE09891259ADB46761F758E0F5C88D74", hash_generated_method = "E5F54F99B31B7DC5E49E53CFED216D77")
    
public void onReceivedHttpAuthCredentials(String host, String realm,
            String username, String password) {
        Message msg = obtainMessage(AUTH_CREDENTIALS);
        msg.getData().putString("host", host);
        msg.getData().putString("realm", realm);
        msg.getData().putString("username", username);
        msg.getData().putString("password", password);
        sendMessage(msg);
    }

    //--------------------------------------------------------------------------
    // WebChromeClient methods
    //--------------------------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.423 -0500", hash_original_method = "7D23376057076E49A1BAAD127CCE1E2E", hash_generated_method = "32E2E038DF84F44768575B70DFDA455A")
    
public void onProgressChanged(int newProgress) {
        // Synchronize so that mLatestProgress is up-to-date.
        synchronized (this) {
            // update mLatestProgress even mWebChromeClient is null as
            // WebView.getProgress() needs it
            if (mLatestProgress == newProgress) {
                return;
            }
            mLatestProgress = newProgress;
            if (mWebChromeClient == null) {
                return;
            }
            if (!mProgressUpdatePending) {
                sendEmptyMessage(PROGRESS);
                mProgressUpdatePending = true;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.426 -0500", hash_original_method = "B29F2764BB6A56E843DFC7CBC2F6C034", hash_generated_method = "7B2FF353AFBE09D38AE2281AFEBF2F92")
    
public BrowserFrame createWindow(boolean dialog, boolean userGesture) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return null;
        }

        WebView.WebViewTransport transport = mWebView.new WebViewTransport();
        final Message msg = obtainMessage(NOTIFY);
        msg.obj = transport;
        synchronized (this) {
            sendMessage(obtainMessage(CREATE_WINDOW, dialog ? 1 : 0,
                    userGesture ? 1 : 0, msg));
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG,
                        "Caught exception while waiting for createWindow");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }

        WebView w = transport.getWebView();
        if (w != null) {
            WebViewCore core = w.getWebViewCore();
            // If WebView.destroy() has been called, core may be null.  Skip
            // initialization in that case and return null.
            if (core != null) {
                core.initializeSubwindow();
                return core.getBrowserFrame();
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.428 -0500", hash_original_method = "08655C1DEC40A72DA93F91A66B628CEC", hash_generated_method = "B9A67D1BD3E0EE626DF35C67C53B2196")
    
public void onRequestFocus() {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return;
        }

        sendEmptyMessage(REQUEST_FOCUS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.430 -0500", hash_original_method = "6FD913BE3AA43F9AAEFF1CB8B9D39A33", hash_generated_method = "C30BAC952EFC0722597133248CD54EA9")
    
public void onCloseWindow(WebView window) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return;
        }
        sendMessage(obtainMessage(CLOSE_WINDOW, window));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.433 -0500", hash_original_method = "F08C9B8424214ACDF6DD6A6D99BF0681", hash_generated_method = "C27A713E12DD9687358DC73772B53753")
    
public void onReceivedIcon(Bitmap icon) {
        // The current item might be null if the icon was already stored in the
        // database and this is a new WebView.
        WebHistoryItem i = mBackForwardList.getCurrentItem();
        if (i != null) {
            i.setFavicon(icon);
        }
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return;
        }
        sendMessage(obtainMessage(RECEIVED_ICON, icon));
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.435 -0500", hash_original_method = "F0350B43E0ECCB1BDA5D312CA7F06F8A", hash_generated_method = "D638516BC3AA29793275AE2A3368BEC4")
    
void onReceivedTouchIconUrl(String url, boolean precomposed) {
        // We should have a current item but we do not want to crash so check
        // for null.
        WebHistoryItem i = mBackForwardList.getCurrentItem();
        if (i != null) {
            i.setTouchIconUrl(url, precomposed);
        }
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return;
        }
        sendMessage(obtainMessage(RECEIVED_TOUCH_ICON_URL,
                precomposed ? 1 : 0, 0, url));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.437 -0500", hash_original_method = "91CD241BD0413BEA62EE65C753144C77", hash_generated_method = "F3AF5771B1DCD564F2A76E5DBD37281A")
    
public void onReceivedTitle(String title) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return;
        }
        sendMessage(obtainMessage(RECEIVED_TITLE, title));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.439 -0500", hash_original_method = "7099C31F609DFFDBC7FE4DB990C0E80D", hash_generated_method = "D0D5EDB579D9F2403AAB59A56D5AF397")
    
public void onJsAlert(String url, String message) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return;
        }
        JsResult result = new JsResult(this, false);
        Message alert = obtainMessage(JS_ALERT, result);
        alert.getData().putString("message", message);
        alert.getData().putString("url", url);
        synchronized (this) {
            sendMessage(alert);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsAlert");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.442 -0500", hash_original_method = "043F4DC8C3BE16DF648461B096D08CDF", hash_generated_method = "FCDFA7DCA0790D2EFF56BD77BC8CEF97")
    
public boolean onJsConfirm(String url, String message) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return false;
        }
        JsResult result = new JsResult(this, false);
        Message confirm = obtainMessage(JS_CONFIRM, result);
        confirm.getData().putString("message", message);
        confirm.getData().putString("url", url);
        synchronized (this) {
            sendMessage(confirm);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsConfirm");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return result.getResult();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.444 -0500", hash_original_method = "994C85F742AA26A8662DEB752BD55192", hash_generated_method = "1D773C27183AC6500970BC475B568A72")
    
public String onJsPrompt(String url, String message, String defaultValue) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return null;
        }
        JsPromptResult result = new JsPromptResult(this);
        Message prompt = obtainMessage(JS_PROMPT, result);
        prompt.getData().putString("message", message);
        prompt.getData().putString("default", defaultValue);
        prompt.getData().putString("url", url);
        synchronized (this) {
            sendMessage(prompt);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsPrompt");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return result.getStringResult();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.447 -0500", hash_original_method = "C62C6CDF3925B75D5791E39530CD4D60", hash_generated_method = "B7358504F02A381F8E4662FC8D4EF1CA")
    
public boolean onJsBeforeUnload(String url, String message) {
        // Do an unsynchronized quick check to avoid posting if no callback has
        // been set.
        if (mWebChromeClient == null) {
            return true;
        }
        JsResult result = new JsResult(this, true);
        Message confirm = obtainMessage(JS_UNLOAD, result);
        confirm.getData().putString("message", message);
        confirm.getData().putString("url", url);
        synchronized (this) {
            sendMessage(confirm);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsUnload");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return result.getResult();
    }

    /**
     * Called by WebViewCore to inform the Java side that the current origin
     * has overflowed it's database quota. Called in the WebCore thread so
     * posts a message to the UI thread that will prompt the WebChromeClient
     * for what to do. On return back to C++ side, the WebCore thread will
     * sleep pending a new quota value.
     * @param url The URL that caused the quota overflow.
     * @param databaseIdentifier The identifier of the database that the
     *     transaction that caused the overflow was running on.
     * @param currentQuota The current quota the origin is allowed.
     * @param estimatedSize The estimated size of the database.
     * @param totalUsedQuota is the sum of all origins' quota.
     * @param quotaUpdater An instance of a class encapsulating a callback
     *     to WebViewCore to run when the decision to allow or deny more
     *     quota has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.450 -0500", hash_original_method = "2A1C263B6B48827DF8BFBCAAE8358B4D", hash_generated_method = "AA91954FE5C4B6E408DC40FCFD74CE28")
    
public void onExceededDatabaseQuota(
            String url, String databaseIdentifier, long currentQuota,
            long estimatedSize, long totalUsedQuota,
            WebStorage.QuotaUpdater quotaUpdater) {
        if (mWebChromeClient == null) {
            quotaUpdater.updateQuota(currentQuota);
            return;
        }

        Message exceededQuota = obtainMessage(EXCEEDED_DATABASE_QUOTA);
        HashMap<String, Object> map = new HashMap();
        map.put("databaseIdentifier", databaseIdentifier);
        map.put("url", url);
        map.put("currentQuota", currentQuota);
        map.put("estimatedSize", estimatedSize);
        map.put("totalUsedQuota", totalUsedQuota);
        map.put("quotaUpdater", quotaUpdater);
        exceededQuota.obj = map;
        sendMessage(exceededQuota);
    }

    /**
     * Called by WebViewCore to inform the Java side that the appcache has
     * exceeded its max size.
     * @param spaceNeeded is the amount of disk space that would be needed
     * in order for the last appcache operation to succeed.
     * @param totalUsedQuota is the sum of all origins' quota.
     * @param quotaUpdater An instance of a class encapsulating a callback
     * to WebViewCore to run when the decision to allow or deny a bigger
     * app cache size has been made.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.453 -0500", hash_original_method = "6FEDE2ECE3E4B773BADE3DEA30808B9D", hash_generated_method = "7302537741E84B1619DFC382DA6A24A1")
    
public void onReachedMaxAppCacheSize(long spaceNeeded,
            long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        if (mWebChromeClient == null) {
            quotaUpdater.updateQuota(0);
            return;
        }

        Message msg = obtainMessage(REACHED_APPCACHE_MAXSIZE);
        HashMap<String, Object> map = new HashMap();
        map.put("spaceNeeded", spaceNeeded);
        map.put("totalUsedQuota", totalUsedQuota);
        map.put("quotaUpdater", quotaUpdater);
        msg.obj = map;
        sendMessage(msg);
    }

    /**
     * Called by WebViewCore to instruct the browser to display a prompt to ask
     * the user to set the Geolocation permission state for the given origin.
     * @param origin The origin requesting Geolocation permsissions.
     * @param callback The callback to call once a permission state has been
     *     obtained.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.455 -0500", hash_original_method = "26533187FD051756DFC2CF1CEE3F806F", hash_generated_method = "AFB532D9142F8E963569017B277A8172")
    
public void onGeolocationPermissionsShowPrompt(String origin,
            GeolocationPermissions.Callback callback) {
        if (mWebChromeClient == null) {
            return;
        }

        Message showMessage =
                obtainMessage(GEOLOCATION_PERMISSIONS_SHOW_PROMPT);
        HashMap<String, Object> map = new HashMap();
        map.put("origin", origin);
        map.put("callback", callback);
        showMessage.obj = map;
        sendMessage(showMessage);
    }

    /**
     * Called by WebViewCore to instruct the browser to hide the Geolocation
     * permissions prompt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.457 -0500", hash_original_method = "9C25F80E0E6C6F6C487DBDD3AFCBA4E7", hash_generated_method = "9D05A5A8AED2B7188976ABC7326CCF8B")
    
public void onGeolocationPermissionsHidePrompt() {
        if (mWebChromeClient == null) {
            return;
        }

        Message hideMessage = obtainMessage(GEOLOCATION_PERMISSIONS_HIDE_PROMPT);
        sendMessage(hideMessage);
    }

    /**
     * Called by WebViewCore when we have a message to be added to the JavaScript
     * error console. Sends a message to the Java side with the details.
     * @param message The message to add to the console.
     * @param lineNumber The lineNumber of the source file on which the error
     *     occurred.
     * @param sourceID The filename of the source file in which the error
     *     occurred.
     * @param msgLevel The message level, corresponding to the MessageLevel enum in
     *     WebCore/page/Console.h
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.460 -0500", hash_original_method = "E08EA131E9320463E856348907B813CB", hash_generated_method = "664617F0F17BA9E1B53827ED2EDDA9E9")
    
public void addMessageToConsole(String message, int lineNumber, String sourceID, int msgLevel) {
        if (mWebChromeClient == null) {
            return;
        }

        Message msg = obtainMessage(ADD_MESSAGE_TO_CONSOLE);
        msg.getData().putString("message", message);
        msg.getData().putString("sourceID", sourceID);
        msg.getData().putInt("lineNumber", lineNumber);
        msg.getData().putInt("msgLevel", msgLevel);
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.462 -0500", hash_original_method = "288C2B13F2CEF8B24515719050488B19", hash_generated_method = "A7A1CF185739990D3712DB573185C5E2")
    
public boolean onJsTimeout() {
        //always interrupt timedout JS by default
        if (mWebChromeClient == null) {
            return true;
        }
        JsResult result = new JsResult(this, true);
        Message timeout = obtainMessage(JS_TIMEOUT, result);
        synchronized (this) {
            sendMessage(timeout);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG, "Caught exception while waiting for jsUnload");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return result.getResult();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.464 -0500", hash_original_method = "F9E2141EE9507A71AC258BF46DA1BEA9", hash_generated_method = "2D9309C61937C9E443B00CD621211527")
    
public void getVisitedHistory(ValueCallback<String[]> callback) {
        if (mWebChromeClient == null) {
            return;
        }
        Message msg = obtainMessage(GET_VISITED_HISTORY);
        msg.obj = callback;
        sendMessage(msg);
    }

    /**
     * Called by WebViewCore to open a file chooser.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.491 -0500", hash_original_method = "FE04684AB3D72B8C190BB2063ADDA47F", hash_generated_method = "FE04684AB3D72B8C190BB2063ADDA47F")
    
Uri openFileChooser(String acceptType) {
        if (mWebChromeClient == null) {
            return null;
        }
        Message myMessage = obtainMessage(OPEN_FILE_CHOOSER);
        UploadFile uploadFile = new UploadFile();
        UploadFileMessageData data = new UploadFileMessageData(uploadFile, acceptType);
        myMessage.obj = data;
        synchronized (this) {
            sendMessage(myMessage);
            try {
                wait();
            } catch (InterruptedException e) {
                Log.e(LOGTAG,
                        "Caught exception while waiting for openFileChooser");
                Log.e(LOGTAG, Log.getStackTraceString(e));
            }
        }
        return uploadFile.getResult();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.493 -0500", hash_original_method = "047BE1D111CE2C04D81802E658F23AB3", hash_generated_method = "047BE1D111CE2C04D81802E658F23AB3")
    
void onNewHistoryItem(WebHistoryItem item) {
        if (mWebBackForwardListClient == null) {
            return;
        }
        Message msg = obtainMessage(ADD_HISTORY_ITEM, item);
        sendMessage(msg);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.496 -0500", hash_original_method = "895FE5553DA6237DB0B5BAA6BAF66947", hash_generated_method = "895FE5553DA6237DB0B5BAA6BAF66947")
    
void onIndexChanged(WebHistoryItem item, int index) {
        if (mWebBackForwardListClient == null) {
            return;
        }
        Message msg = obtainMessage(HISTORY_INDEX_CHANGED, index, 0, item);
        sendMessage(msg);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.498 -0500", hash_original_method = "8F94850AD3F63EF799E6BEFB2C67734D", hash_generated_method = "8F94850AD3F63EF799E6BEFB2C67734D")
    
void setInstallableWebApp() {
        if (mWebChromeClient == null) {
            return;
        }
        sendMessage(obtainMessage(SET_INSTALLABLE_WEBAPP));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.500 -0500", hash_original_method = "8DF8998B34FE58BC5486ECCDB22BE44D", hash_generated_method = "14A5D5E98155DB5FF55FAF4A6FE1707E")
    
boolean canShowAlertDialog() {
        // We can only display the alert dialog if mContext is
        // an Activity context.
        // FIXME: Should we display dialogs if mContext does
        // not have the window focus (e.g. if the user is viewing
        // another Activity when the alert should be displayed?
        // See bug 3166409
        return mContext instanceof Activity;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.502 -0500", hash_original_method = "C20FB9F0C31604564B2DC30DE7E0C643", hash_generated_method = "C20FB9F0C31604564B2DC30DE7E0C643")
    
void onSearchboxSuggestionsReceived(String query, List<String> suggestions) {
        Message msg = obtainMessage(NOTIFY_SEARCHBOX_LISTENERS);
        msg.obj = suggestions;
        msg.getData().putString("query", query);

        sendMessage(msg);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.504 -0500", hash_original_method = "350C274DFDDA43015C8C93D9651125A1", hash_generated_method = "350C274DFDDA43015C8C93D9651125A1")
    
void onIsSupportedCallback(boolean isSupported) {
        Message msg = obtainMessage(SEARCHBOX_IS_SUPPORTED_CALLBACK);
        msg.obj = new Boolean(isSupported);
        sendMessage(msg);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:14.506 -0500", hash_original_method = "18679CF45F0FBF6C3076A4EAE4B01ADE", hash_generated_method = "18679CF45F0FBF6C3076A4EAE4B01ADE")
    
void onSearchboxDispatchCompleteCallback(String function, int id, boolean success) {
        Message msg = obtainMessage(SEARCHBOX_DISPATCH_COMPLETE_CALLBACK);
        msg.obj = Boolean.valueOf(success);
        msg.getData().putString("function", function);
        msg.getData().putInt("id", id);

        sendMessage(msg);
    }
}

