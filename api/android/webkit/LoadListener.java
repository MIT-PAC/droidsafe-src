package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ParseException;
import android.net.Uri;
import android.net.WebAddress;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.net.http.HttpAuthHeader;
import android.net.http.RequestHandle;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.CacheManager.CacheResult;

import com.android.internal.R;






class LoadListener extends Handler implements EventHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "1F82295670D8C49C778553291F467693", hash_generated_field = "C2ADEC4B7675869DD34EF84CA5DC8ADA")

    private final ByteArrayBuilder mDataBuilder = new ByteArrayBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

    private String mUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "93793E19832E1B2CEA9B3AE18495201F")

    private WebAddress mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "5CE6426C79F06E218F426F0E1851F643", hash_generated_field = "632697020547475B21783FF9A242BA30")

    private boolean mPermanent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "C71E6F27982C162E3D48504B7CE95EEE", hash_generated_field = "568234C9B8DA241BFA5B09B8101F8B12")

    private String mOriginalUrl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "210C1862D81E3FCC2FD87A83EA255D40", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "8B6CED6C3251DC4BFDDBC4CCDF1CAA54", hash_generated_field = "CFE8D432F2D30F6D44FDB0D4F89E9956")

    private int mNativeLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "D6D2783B71AE4BF9CBF84D44336E2BF9")

    private String mMimeType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "98F3D6B51351657C10385D44B0C0054D")

    private String mEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "2DF3ED20DD5FCAD4BBC54FFEAFD60E5D", hash_generated_field = "5B5A898734AC0BC3BD56BC7A1B09A1AA")

    private String mTransferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "7948B1EFB4AE211035F97F99CDB6078C", hash_generated_field = "A03B65E05BCBAEC5D04E36F3DA55AA89")

    private int mStatusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "E376B2491257EB4CB20B17AAF2E5520C", hash_generated_field = "8308E02599DA7B9492281855AF586F6A")

    private String mStatusText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "D4BC2D0F0185C97879D7062C4CEFD633", hash_generated_field = "1ACBF6AD05D624BD330C1EA27911AFED")

    public long mContentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "1813307BAF5C3869F23F1AC0318DE4BE", hash_generated_field = "582F041564D3B399F48E8AE230C16FEE")

    private boolean mCancelled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "0191A284F8F26AE941D84E8E2ADF5731", hash_generated_field = "11E3D87CDBCDF8F27F5BCF75E88255E5")

    private boolean mAuthFailed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "6C485DBF404EED3828D28EAB5B75583E", hash_generated_field = "7D2D2225EC07E109A425BA1C9069B594")

    private CacheLoader mCacheLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "F48561BA425AAC50D6E8B7A4F82555FB", hash_generated_field = "7BD10F8B23449D67AF64947251567443")

    private boolean mFromCache = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "D88F8961E896B36F45BC65C0E5C94B4F", hash_generated_field = "F92F68007E24C2007F5E8613B464C2BA")

    private HttpAuthHeader mAuthHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "16DE1F4FBED47663F1B008C927D7B64E", hash_generated_field = "CFF6FAF13B4D5230E9FF26C0A80758BB")

    private int mErrorID = OK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "4B18E53CCE831597CAE997F39A2FB253", hash_generated_field = "9A2F4E95853CE87C657553938570C697")

    private String mErrorDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "99A9A437E48C76D1556026A0A85B5820", hash_generated_field = "260FF327C4645479FF5E5DCF19E349AD")

    private SslError mSslError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "8F2BBF6B97D2E4DAE439A5022B5DBE41", hash_generated_field = "D2C086119AFB2A8257E7CAD619AFA47F")

    private RequestHandle mRequestHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "049D0917259EC924AF2E8D101BAF0656", hash_generated_field = "1D3366ACEEB83C50B8FD0D2EE0AAAE40")

    private RequestHandle mSslErrorRequestHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "326FAE0022967BEB3C583F6C15C54AA4", hash_generated_field = "B0E361E4F3B0293B8C4D8932D9873B39")

    private long mPostIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "428D706CEC47D9F07779621FC1626C5A", hash_generated_field = "E5EA8984DD22A9073BFFEAE2B245DF81")

    private boolean mSetNativeResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "46D356CEC2B798E53528C0BD5F09C873")

    private String mMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "0A064CD66C89784C0961CEF3F748A30D", hash_generated_field = "223EBD1E69C1299B02B1F1776461294B")

    private Map<String, String> mRequestHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "AF86FBE15EC2C25B16B35C7E4DD756CA", hash_generated_field = "C5200C1F2575A09491B18B8CE6E6A375")

    private byte[] mPostData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.475 -0400", hash_original_field = "E3B093022B51696D8A9249A5CBB1B7C1", hash_generated_field = "FB6DD9E423DD8E3B65713D050C1DF4CF")

    private boolean mSynchronous;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "9B951BA0E0DD99654367267037A17F00", hash_generated_field = "8086EB07D920976B70D832288B336380")

    private Vector<Message> mMessageQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "F0D779550E246389EBE13C14C5F7FDB9", hash_generated_field = "E2600D589BA8423FB6859BA77F68989A")

    private boolean mIsMainPageLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "AF36715AAF25E2195BB18F3B33004164", hash_generated_field = "75023DD9A0A12C6512FD4F2D45866B50")

    private boolean mIsMainResourceLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "5E8195D2B1BFC9907987B84962F03AEB", hash_generated_field = "D928F63690A6A62BFF2AD4D16739AD6F")

    private boolean mUserGesture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "13C03042313948D47B6F87C772F0131E")

    private Headers mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "2FB3EB7CD104D0E14FE0487884A12591", hash_generated_field = "50564F75BBDED0F5A11BFE739FB8373A")

    private String mUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_field = "4B9E95174875242C9A98A092137F2AE1", hash_generated_field = "DC46C8F8C9ECAF31EBEBF94599D29CFE")

    private int mCacheRedirectCount;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_method = "63FB01D41A0193C36F7BC9C3E9D1276B", hash_generated_method = "40E7E2337EB9D6C2143D67606021D986")
      LoadListener(Context context, BrowserFrame frame, String url,
            int nativeLoader, boolean synchronous, boolean isMainPageLoader,
            boolean isMainResource, boolean userGesture, long postIdentifier,
            String username, String password) {
        addTaint(url.getTaint());
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        mContext = context;
        mBrowserFrame = frame;
        setUrl(url);
        mNativeLoader = nativeLoader;
        mSynchronous = synchronous;
        if(synchronous)        
        {
            mMessageQueue = new Vector<Message>();
        } //End block
        mIsMainPageLoader = isMainPageLoader;
        mIsMainResourceLoader = isMainResource;
        mUserGesture = userGesture;
        mPostIdentifier = postIdentifier;
        mUsername = username;
        mPassword = password;
        // ---------- Original Method ----------
        //assert !JniUtil.useChromiumHttpStack();
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener constructor url=" + url);
        //}
        //mContext = context;
        //mBrowserFrame = frame;
        //setUrl(url);
        //mNativeLoader = nativeLoader;
        //mSynchronous = synchronous;
        //if (synchronous) {
            //mMessageQueue = new Vector<Message>();
        //}
        //mIsMainPageLoader = isMainPageLoader;
        //mIsMainResourceLoader = isMainResource;
        //mUserGesture = userGesture;
        //mPostIdentifier = postIdentifier;
        //mUsername = username;
        //mPassword = password;
    }

    
    @DSModeled(DSC.SAFE)
    public static LoadListener getLoadListener(Context context,
            BrowserFrame frame, String url, int nativeLoader,
            boolean synchronous, boolean isMainPageLoader,
            boolean isMainResource, boolean userGesture, long postIdentifier,
            String username, String password) {
        sNativeLoaderCount += 1;
        return new LoadListener(context, frame, url, nativeLoader, synchronous,
                isMainPageLoader, isMainResource, userGesture, postIdentifier,
                username, password);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getNativeLoaderCount() {
        return sNativeLoaderCount;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.476 -0400", hash_original_method = "E8BFBC0989CB1303890EF6ABB82F2DCB", hash_generated_method = "1D30724615CFE0039A108856FCC50022")
    private void clearNativeLoader() {
        sNativeLoaderCount -= 1;
        mNativeLoader = 0;
        mSetNativeResponse = false;
        // ---------- Original Method ----------
        //sNativeLoaderCount -= 1;
        //mNativeLoader = 0;
        //mSetNativeResponse = false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.477 -0400", hash_original_method = "77CD0D13F9C2AAAECAF2A5910AFEFD4A", hash_generated_method = "C6901FD65DBD483939CFC2585159F446")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case MSG_CONTENT_HEADERS:
        handleHeaders((Headers) msg.obj);
        break;
        case MSG_CONTENT_DATA:
        if(mNativeLoader != 0 && !ignoreCallbacks())        
        {
            commitLoad();
        } //End block
        break;
        case MSG_CONTENT_FINISHED:
        handleEndData();
        break;
        case MSG_CONTENT_ERROR:
        handleError(msg.arg1, (String) msg.obj);
        break;
        case MSG_LOCATION_CHANGED:
        doRedirect();
        break;
        case MSG_LOCATION_CHANGED_REQUEST:
        Message contMsg = obtainMessage(MSG_LOCATION_CHANGED);
        Message stopMsg = obtainMessage(MSG_CONTENT_FINISHED);
        mBrowserFrame.getCallbackProxy().onFormResubmission(
                        stopMsg, contMsg);
        break;
        case MSG_STATUS:
        HashMap status = (HashMap) msg.obj;
        handleStatus(((Integer) status.get("major")).intValue(),
                        ((Integer) status.get("minor")).intValue(),
                        ((Integer) status.get("code")).intValue(),
                        (String) status.get("reason"));
        break;
        case MSG_SSL_CERTIFICATE:
        handleCertificate((SslCertificate) msg.obj);
        break;
        case MSG_SSL_ERROR:
        handleSslError((SslError) msg.obj);
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.477 -0400", hash_original_method = "172B6AEABEB6A05CD87E0FF0F77BADEB", hash_generated_method = "0EB832213882DBE1AA09F7815625B613")
     BrowserFrame getFrame() {
BrowserFrame varF88C24EE0B3CCB203533CF4B13D08A2B_598618264 =         mBrowserFrame;
        varF88C24EE0B3CCB203533CF4B13D08A2B_598618264.addTaint(taint);
        return varF88C24EE0B3CCB203533CF4B13D08A2B_598618264;
        // ---------- Original Method ----------
        //return mBrowserFrame;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.477 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "7E13C99B0395F94F734C2CFEB070DE22")
     Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_189826987 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_189826987.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_189826987;
        // ---------- Original Method ----------
        //return mContext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.477 -0400", hash_original_method = "8DEF62308917FED7D5E9DE4FE979D5DE", hash_generated_method = "0F7E04B085681D70FEC93327F23251BD")
     boolean isSynchronous() {
        boolean varE3B093022B51696D8A9249A5CBB1B7C1_570821994 = (mSynchronous);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119547899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119547899;
        // ---------- Original Method ----------
        //return mSynchronous;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.477 -0400", hash_original_method = "E8044B5DC56667FC9DCFE8CB33E5852B", hash_generated_method = "3290C3FFFD59403527036F9ACB79138A")
    public boolean cancelled() {
        boolean var1813307BAF5C3869F23F1AC0318DE4BE_1159203619 = (mCancelled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438842758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438842758;
        // ---------- Original Method ----------
        //return mCancelled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.477 -0400", hash_original_method = "454399D3A9345FFC357883E67C1190C2", hash_generated_method = "B7A918ACC89E271EF3DB080CA5DCE61E")
    public void headers(Headers headers) {
        addTaint(headers.getTaint());
        if(DebugFlags.LOAD_LISTENER){ }        if(mCancelled)        
        return;
        ArrayList<String> cookies = headers.getSetCookie();
for(int i = 0;i < cookies.size();++i)
        {
            CookieManager.getInstance().setCookie(mUri, cookies.get(i));
        } //End block
        sendMessageInternal(obtainMessage(MSG_CONTENT_HEADERS, headers));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) Log.v(LOGTAG, "LoadListener.headers");
        //if (mCancelled) return;
        //ArrayList<String> cookies = headers.getSetCookie();
        //for (int i = 0; i < cookies.size(); ++i) {
            //CookieManager.getInstance().setCookie(mUri, cookies.get(i));
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_HEADERS, headers));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.478 -0400", hash_original_method = "311EC7904C0F96CC61CCD61A611678E4", hash_generated_method = "3093922A30DF6CD932A7DCA690CEA10B")
    private void handleHeaders(Headers headers) {
        if(mCancelled)        
        return;
        if(mStatusCode == HTTP_PARTIAL_CONTENT)        
        {
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
            return;
        } //End block
        mHeaders = headers;
        long contentLength = headers.getContentLength();
        if(contentLength != Headers.NO_CONTENT_LENGTH)        
        {
            mContentLength = contentLength;
        } //End block
        else
        {
            mContentLength = 0;
        } //End block
        String contentType = headers.getContentType();
        if(contentType != null)        
        {
            parseContentTypeHeader(contentType);
            mMimeType = MimeTypeMap.getSingleton().remapGenericMimeType(
                    mMimeType, mUrl, headers.getContentDisposition());
        } //End block
        else
        {
            guessMimeType();
        } //End block
        if(mIsMainPageLoader && mIsMainResourceLoader && mUserGesture &&
                Pattern.matches(XML_MIME_TYPE, mMimeType) &&
                !mMimeType.equalsIgnoreCase("application/xhtml+xml"))        
        {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setDataAndType(Uri.parse(url()), mMimeType);
            ResolveInfo info = mContext.getPackageManager().resolveActivity(i,
                    PackageManager.MATCH_DEFAULT_ONLY);
            if(info != null && !mContext.getPackageName().equals(
                    info.activityInfo.packageName))            
            {
                try 
                {
                    mContext.startActivity(i);
                    mBrowserFrame.stopLoading();
                    return;
                } //End block
                catch (ActivityNotFoundException ex)
                {
                } //End block
            } //End block
        } //End block
        boolean mustAuthenticate = (mStatusCode == HTTP_AUTH ||
                mStatusCode == HTTP_PROXY_AUTH);
        boolean isProxyAuthRequest = (mStatusCode == HTTP_PROXY_AUTH);
        mAuthFailed = false;
        if(mAuthHeader != null)        
        {
            mAuthFailed = (mustAuthenticate &&
                    isProxyAuthRequest == mAuthHeader.isProxy());
            if(!mAuthFailed && mAuthHeader.isProxy())            
            {
                Network network = Network.getInstance(mContext);
                if(network.isValidProxySet())                
                {
                    synchronized
(network)                    {
                        network.setProxyUsername(mAuthHeader.getUsername());
                        network.setProxyPassword(mAuthHeader.getPassword());
                    } //End block
                } //End block
            } //End block
        } //End block
        mAuthHeader = null;
        if(mustAuthenticate)        
        {
            if(mStatusCode == HTTP_AUTH)            
            {
                mAuthHeader = parseAuthHeader(
                        headers.getWwwAuthenticate());
            } //End block
            else
            {
                mAuthHeader = parseAuthHeader(
                        headers.getProxyAuthenticate());
                if(mAuthHeader != null)                
                {
                    mAuthHeader.setProxy();
                } //End block
            } //End block
        } //End block
        if((mStatusCode == HTTP_OK ||
                mStatusCode == HTTP_FOUND ||
                mStatusCode == HTTP_MOVED_PERMANENTLY ||
                mStatusCode == HTTP_TEMPORARY_REDIRECT) && 
                mNativeLoader != 0)        
        {
            if(!mFromCache && mRequestHandle != null
                    && (!mRequestHandle.getMethod().equals("POST")
                            || mPostIdentifier != 0))            
            {
                WebViewWorker.CacheCreateData data = new WebViewWorker.CacheCreateData();
                data.mListener = this;
                data.mUrl = mUrl;
                data.mMimeType = mMimeType;
                data.mStatusCode = mStatusCode;
                data.mPostId = mPostIdentifier;
                data.mHeaders = headers;
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_CREATE_CACHE, data).sendToTarget();
            } //End block
            WebViewWorker.CacheEncoding ce = new WebViewWorker.CacheEncoding();
            ce.mEncoding = mEncoding;
            ce.mListener = this;
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_UPDATE_CACHE_ENCODING, ce).sendToTarget();
        } //End block
        commitHeadersCheckRedirect();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.479 -0400", hash_original_method = "700C126D7DD3A2A28FA66689BEC1C959", hash_generated_method = "C74B1A58E0CDD8BC08C9525A27C5F9A1")
     boolean proxyAuthenticate() {
        if(mAuthHeader != null)        
        {
            boolean var39EFACF9B5B85588F081606C1A280B56_219589436 = (mAuthHeader.isProxy());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_907936322 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_907936322;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2093947823 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305747276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305747276;
        // ---------- Original Method ----------
        //if (mAuthHeader != null) {
            //return mAuthHeader.isProxy();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.479 -0400", hash_original_method = "DDF05333033BF6873CD233D3316FD8A3", hash_generated_method = "717A6CDE16B01039394ABF9B74831F43")
    public void status(int majorVersion, int minorVersion,
            int code,  String reasonPhrase) {
        addTaint(reasonPhrase.getTaint());
        addTaint(code);
        addTaint(minorVersion);
        addTaint(majorVersion);
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        HashMap status = new HashMap();
        status.put("major", majorVersion);
        status.put("minor", minorVersion);
        status.put("code", code);
        status.put("reason", reasonPhrase);
        mDataBuilder.clear();
        mMimeType = "";
        mEncoding = "";
        mTransferEncoding = "";
        sendMessageInternal(obtainMessage(MSG_STATUS, status));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener: from: " + mUrl
                    //+ " major: " + majorVersion
                    //+ " minor: " + minorVersion
                    //+ " code: " + code
                    //+ " reason: " + reasonPhrase);
        //}
        //HashMap status = new HashMap();
        //status.put("major", majorVersion);
        //status.put("minor", minorVersion);
        //status.put("code", code);
        //status.put("reason", reasonPhrase);
        //mDataBuilder.clear();
        //mMimeType = "";
        //mEncoding = "";
        //mTransferEncoding = "";
        //sendMessageInternal(obtainMessage(MSG_STATUS, status));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.479 -0400", hash_original_method = "80BDEC9DD0BC19198E8FAA3CF681EF16", hash_generated_method = "39D031018CCD7899ED29AE530F4F9284")
    private void handleStatus(int major, int minor, int code, String reason) {
        addTaint(minor);
        addTaint(major);
        if(mCancelled)        
        return;
        mStatusCode = code;
        mStatusText = reason;
        mPermanent = false;
        // ---------- Original Method ----------
        //if (mCancelled) return;
        //mStatusCode = code;
        //mStatusText = reason;
        //mPermanent = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.479 -0400", hash_original_method = "E4096ABF23EF8731F97354B434FC290A", hash_generated_method = "96C4A04234643CA592FA1BFBB5C4DBAC")
    public void certificate(SslCertificate certificate) {
        addTaint(certificate.getTaint());
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, certificate));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.certificate: " + certificate);
        //}
        //sendMessageInternal(obtainMessage(MSG_SSL_CERTIFICATE, certificate));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.479 -0400", hash_original_method = "0FA338360DC1BF86862C5325E0DDE15B", hash_generated_method = "A1AB9795B9B45F432C01417840B80351")
    private void handleCertificate(SslCertificate certificate) {
        addTaint(certificate.getTaint());
        if(mIsMainPageLoader && mIsMainResourceLoader)        
        {
            mBrowserFrame.certificate(certificate);
        } //End block
        // ---------- Original Method ----------
        //if (mIsMainPageLoader && mIsMainResourceLoader) {
            //mBrowserFrame.certificate(certificate);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.479 -0400", hash_original_method = "89A45FCA5400E7297D291CB9BD4FA531", hash_generated_method = "FB80FD6BE8A11C37F4F939CB922A128E")
    public void error(int id, String description) {
        addTaint(description.getTaint());
        addTaint(id);
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, id, 0, description));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.error url:" +
                    //url() + " id:" + id + " description:" + description);
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_ERROR, id, 0, description));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.479 -0400", hash_original_method = "FF98E8647B63FEBC8B925077CB2E6971", hash_generated_method = "BFAA29B7AE658444FE661E602E4F9A12")
    private void handleError(int id, String description) {
        mErrorID = id;
        mErrorDescription = description;
        detachRequestHandle();
        notifyError();
        tearDown();
        // ---------- Original Method ----------
        //mErrorID = id;
        //mErrorDescription = description;
        //detachRequestHandle();
        //notifyError();
        //tearDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.480 -0400", hash_original_method = "842D88ADC63F459E21BBD6FC9BF11FA0", hash_generated_method = "82E91D56EDF49AFF0DA2B3DEE023C951")
    public void data(byte[] data, int length) {
        addTaint(length);
        addTaint(data[0]);
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        boolean sendMessage = false;
        synchronized
(mDataBuilder)        {
            sendMessage = mDataBuilder.isEmpty();
            mDataBuilder.append(data, 0, length);
        } //End block
        if(sendMessage)        
        {
            sendMessageInternal(obtainMessage(MSG_CONTENT_DATA));
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.data(): url: " + url());
        //}
        //boolean sendMessage = false;
        //synchronized (mDataBuilder) {
            //sendMessage = mDataBuilder.isEmpty();
            //mDataBuilder.append(data, 0, length);
        //}
        //if (sendMessage) {
            //sendMessageInternal(obtainMessage(MSG_CONTENT_DATA));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.480 -0400", hash_original_method = "57E1AB7C57BAD02879F9C8B9B633558A", hash_generated_method = "77B0810173F40CF52797E5DDAC847630")
    public void endData() {
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        sendMessageInternal(obtainMessage(MSG_CONTENT_FINISHED));
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.endData(): url: " + url());
        //}
        //sendMessageInternal(obtainMessage(MSG_CONTENT_FINISHED));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.480 -0400", hash_original_method = "CDF3DE93E351C5A11A75DE0E367F817E", hash_generated_method = "23F01B99D514F0583EB9ED5BC36911BD")
    private void handleEndData() {
        if(mCancelled)        
        return;
switch(mStatusCode){
        case HTTP_MOVED_PERMANENTLY:
        mPermanent = true;
        case HTTP_FOUND:
        case HTTP_SEE_OTHER:
        case HTTP_TEMPORARY_REDIRECT:
        if(mStatusCode == HTTP_TEMPORARY_REDIRECT)        
        {
            if(mRequestHandle != null && 
                                mRequestHandle.getMethod().equals("POST"))            
            {
                sendMessageInternal(obtainMessage(
                                MSG_LOCATION_CHANGED_REQUEST));
            } //End block
            else
            if(mMethod != null && mMethod.equals("POST"))            
            {
                sendMessageInternal(obtainMessage(
                                MSG_LOCATION_CHANGED_REQUEST));
            } //End block
            else
            {
                sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
            } //End block
        } //End block
        else
        {
            sendMessageInternal(obtainMessage(MSG_LOCATION_CHANGED));
        } //End block
        return;
        case HTTP_AUTH:
        case HTTP_PROXY_AUTH:
        if(mAuthHeader != null &&
                        (Network.getInstance(mContext).isValidProxySet() ||
                         !mAuthHeader.isProxy()))        
        {
            if(!mAuthFailed && mUsername != null && mPassword != null)            
            {
                String host = mAuthHeader.isProxy() ?
                                Network.getInstance(mContext).getProxyHostname() :
                                mUri.getHost();
                HttpAuthHandlerImpl.onReceivedCredentials(this, host,
                                mAuthHeader.getRealm(), mUsername, mPassword);
                makeAuthResponse(mUsername, mPassword);
            } //End block
            else
            {
                Network.getInstance(mContext).handleAuthRequest(this);
            } //End block
            return;
        } //End block
        break;
        case HTTP_NOT_MODIFIED:
        if(mCacheLoader != null)        
        {
            if(isSynchronous())            
            {
                mCacheLoader.load();
            } //End block
            else
            {
                WebViewWorker.getHandler().obtainMessage(
                                WebViewWorker.MSG_ADD_STREAMLOADER, mCacheLoader)
                                .sendToTarget();
            } //End block
            mFromCache = true;
            if(DebugFlags.LOAD_LISTENER)            
            {
            } //End block
            return;
        } //End block
        break;
        case HTTP_NOT_FOUND:
        default:
        break;
}        detachRequestHandle();
        tearDown();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.481 -0400", hash_original_method = "986192BD953D202BDF33831C4485C789", hash_generated_method = "47CBFFEFBA2BEBDF39A8136B3A86A818")
     void setCacheLoader(CacheLoader c) {
        mCacheLoader = c;
        mFromCache = true;
        // ---------- Original Method ----------
        //mCacheLoader = c;
        //mFromCache = true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.481 -0400", hash_original_method = "0AD650AC52F38566687E74B5EF113675", hash_generated_method = "E379D942E27357C9E1F68A99F414EF30")
     boolean checkCache(Map<String, String> headers) {
        addTaint(headers.getTaint());
        CacheResult result = CacheManager.getCacheFile(url(), mPostIdentifier,
                headers);
        mCacheLoader = null;
        mFromCache = false;
        if(result != null)        
        {
            mCacheLoader = new CacheLoader(this, result);
            if(!headers.containsKey(
                    CacheManager.HEADER_KEY_IFNONEMATCH) &&
                    !headers.containsKey(
                            CacheManager.HEADER_KEY_IFMODIFIEDSINCE))            
            {
                if(DebugFlags.LOAD_LISTENER)                
                {
                } //End block
                if(isSynchronous())                
                {
                    mCacheLoader.load();
                } //End block
                else
                {
                    WebViewWorker.getHandler().obtainMessage(
                            WebViewWorker.MSG_ADD_STREAMLOADER, mCacheLoader)
                            .sendToTarget();
                } //End block
                mFromCache = true;
                boolean varB326B5062B2F0E69046810717534CB09_51131938 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349465177 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349465177;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1583062922 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861671657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861671657;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.481 -0400", hash_original_method = "DAC212856E10133D124E798AA1F9AF10", hash_generated_method = "88526B8B32B799600136D5CBC679437E")
    public boolean handleSslErrorRequest(SslError error) {
        addTaint(error.getTaint());
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        if(Network.getInstance(mContext).checkSslPrefTable(this, error))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_647784546 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1553234000 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1553234000;
        } //End block
        if(isSynchronous())        
        {
            mRequestHandle.handleSslErrorResponse(false);
            boolean varB326B5062B2F0E69046810717534CB09_1200850456 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432788961 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432788961;
        } //End block
        sendMessageInternal(obtainMessage(MSG_SSL_ERROR, error));
        if(!mCancelled)        
        {
            mSslErrorRequestHandle = mRequestHandle;
        } //End block
        boolean var75BF4A42F14D90D863A456943A4B7544_831972670 = (!mCancelled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951522769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951522769;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG,
                    //"LoadListener.handleSslErrorRequest(): url:" + url() +
                    //" primary error: " + error.getPrimaryError() +
                    //" certificate: " + error.getCertificate());
        //}
        //if (Network.getInstance(mContext).checkSslPrefTable(this, error)) {
            //return true;
        //}
        //if (isSynchronous()) {
            //mRequestHandle.handleSslErrorResponse(false);
            //return true;
        //}
        //sendMessageInternal(obtainMessage(MSG_SSL_ERROR, error));
        //if (!mCancelled) {
            //mSslErrorRequestHandle = mRequestHandle;
        //}
        //return !mCancelled;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.482 -0400", hash_original_method = "8A34681F6BA1F3EEE132C403DE00B59E", hash_generated_method = "8F093FE924D1B726DB567D3881E8DDF2")
    private void handleSslError(SslError error) {
        if(!mCancelled)        
        {
            mSslError = error;
            Network.getInstance(mContext).handleSslErrorRequest(this);
        } //End block
        else
        if(mSslErrorRequestHandle != null)        
        {
            mSslErrorRequestHandle.handleSslErrorResponse(true);
        } //End block
        mSslErrorRequestHandle = null;
        // ---------- Original Method ----------
        //if (!mCancelled) {
            //mSslError = error;
            //Network.getInstance(mContext).handleSslErrorRequest(this);
        //} else if (mSslErrorRequestHandle != null) {
            //mSslErrorRequestHandle.handleSslErrorResponse(true);
        //}
        //mSslErrorRequestHandle = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.482 -0400", hash_original_method = "273C3FB8F6276DB18167E6647E9B9071", hash_generated_method = "941C943FBBBF873116E727BF2A86D42C")
     String realm() {
        if(mAuthHeader == null)        
        {
String var540C13E9E156B687226421B24F2DF178_109746373 =             null;
            var540C13E9E156B687226421B24F2DF178_109746373.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_109746373;
        } //End block
        else
        {
String varA1467F36AB8D46FBEFB668AC536E44F2_347321673 =             mAuthHeader.getRealm();
            varA1467F36AB8D46FBEFB668AC536E44F2_347321673.addTaint(taint);
            return varA1467F36AB8D46FBEFB668AC536E44F2_347321673;
        } //End block
        // ---------- Original Method ----------
        //if (mAuthHeader == null) {
            //return null;
        //} else {
            //return mAuthHeader.getRealm();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.482 -0400", hash_original_method = "B53822BFF4A674DE454739734B590814", hash_generated_method = "0557F778BAC58B17060F31CD253E1B3F")
     boolean authCredentialsInvalid() {
        boolean var973A58CDB21ED1EEBD357971AFFE2BED_434636136 = ((mAuthFailed &&
                !(mAuthHeader.isDigest() && mAuthHeader.getStale())));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282966117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282966117;
        // ---------- Original Method ----------
        //return (mAuthFailed &&
                //!(mAuthHeader.isDigest() && mAuthHeader.getStale()));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.482 -0400", hash_original_method = "D83DC2897E3C9B13E1B0E03447F2258A", hash_generated_method = "D7A8A7812D055234DB22AB92AE2A7526")
     SslError sslError() {
SslError varC06B1D712E386771D5CA99DC6DD229BD_2146670641 =         mSslError;
        varC06B1D712E386771D5CA99DC6DD229BD_2146670641.addTaint(taint);
        return varC06B1D712E386771D5CA99DC6DD229BD_2146670641;
        // ---------- Original Method ----------
        //return mSslError;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.482 -0400", hash_original_method = "98A7269FE5209374A8ED24F438AC19C3", hash_generated_method = "EAE06C4664FA8C45030D0CFBC70CCBF2")
     void handleSslErrorResponse(boolean proceed) {
        addTaint(proceed);
        if(mRequestHandle != null)        
        {
            mRequestHandle.handleSslErrorResponse(proceed);
        } //End block
        if(!proceed)        
        {
            mBrowserFrame.stopLoading();
            tearDown();
        } //End block
        // ---------- Original Method ----------
        //if (mRequestHandle != null) {
            //mRequestHandle.handleSslErrorResponse(proceed);
        //}
        //if (!proceed) {
            //mBrowserFrame.stopLoading();
            //tearDown();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.482 -0400", hash_original_method = "7E02E9AA12C4A958E94F9A413E55434A", hash_generated_method = "1744E0F8A3B48074901456074B9257C0")
     void handleAuthResponse(String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        if(username != null && password != null)        
        {
            makeAuthResponse(username, password);
        } //End block
        else
        {
            commitLoad();
            tearDown();
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.handleAuthResponse: url: " + mUrl
                    //+ " username: " + username
                    //+ " password: " + password);
        //}
        //if (username != null && password != null) {
            //makeAuthResponse(username, password);
        //} else {
            //commitLoad();
            //tearDown();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.483 -0400", hash_original_method = "D4EC792204E12F6CD4476F22DB2D7416", hash_generated_method = "25E96C93BEC7C7DD3649A8FEBC3C8FDA")
     void makeAuthResponse(String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        if(mAuthHeader == null || mRequestHandle == null)        
        {
            return;
        } //End block
        mAuthHeader.setUsername(username);
        mAuthHeader.setPassword(password);
        int scheme = mAuthHeader.getScheme();
        if(scheme == HttpAuthHeader.BASIC)        
        {
            boolean isProxy = mAuthHeader.isProxy();
            mRequestHandle.setupBasicAuthResponse(isProxy, username, password);
        } //End block
        else
        if(scheme == HttpAuthHeader.DIGEST)        
        {
            boolean isProxy = mAuthHeader.isProxy();
            String realm = mAuthHeader.getRealm();
            String nonce = mAuthHeader.getNonce();
            String qop = mAuthHeader.getQop();
            String algorithm = mAuthHeader.getAlgorithm();
            String opaque = mAuthHeader.getOpaque();
            mRequestHandle.setupDigestAuthResponse(isProxy, username, password,
                    realm, nonce, qop, algorithm, opaque);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.483 -0400", hash_original_method = "0354530277F06C2F68A7F9A147112FDC", hash_generated_method = "B9828203D5B8AB72FF779428888DC616")
     void setRequestData(String method, Map<String, String> headers, 
            byte[] postData) {
        mMethod = method;
        mRequestHeaders = headers;
        mPostData = postData;
        // ---------- Original Method ----------
        //mMethod = method;
        //mRequestHeaders = headers;
        //mPostData = postData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.483 -0400", hash_original_method = "50C2A5A94CFD2B09208EC5050A570E5D", hash_generated_method = "C0B4DF8A9CDC18DEE66072342B6CEF0B")
     String url() {
String varF1E91891753CD7C4305CCDECB60B9DDF_58359914 =         mUrl;
        varF1E91891753CD7C4305CCDECB60B9DDF_58359914.addTaint(taint);
        return varF1E91891753CD7C4305CCDECB60B9DDF_58359914;
        // ---------- Original Method ----------
        //return mUrl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.483 -0400", hash_original_method = "C2839DA6285DEBF5C5C20951F1E9FC61", hash_generated_method = "BB8F01B0C98FDB69DD8616A93F00F8FC")
     WebAddress getWebAddress() {
WebAddress var7D41D50876117CE5D7DFAD684A455037_546797236 =         mUri;
        var7D41D50876117CE5D7DFAD684A455037_546797236.addTaint(taint);
        return var7D41D50876117CE5D7DFAD684A455037_546797236;
        // ---------- Original Method ----------
        //return mUri;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.483 -0400", hash_original_method = "0451B8994B1846476A8FE8B0355ADDFF", hash_generated_method = "C3C312A66AB9F1CC8F55810429AE8980")
     String host() {
        if(mUri != null)        
        {
String var90E8B81BB1D381A386FAE46FE802A963_919031614 =             mUri.getHost();
            var90E8B81BB1D381A386FAE46FE802A963_919031614.addTaint(taint);
            return var90E8B81BB1D381A386FAE46FE802A963_919031614;
        } //End block
String var540C13E9E156B687226421B24F2DF178_346222982 =         null;
        var540C13E9E156B687226421B24F2DF178_346222982.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_346222982;
        // ---------- Original Method ----------
        //if (mUri != null) {
            //return mUri.getHost();
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.484 -0400", hash_original_method = "BC027B9D5395B8E20CC57CD534FC36DC", hash_generated_method = "2113015CCEB946627F373369DDCA9B11")
     String originalUrl() {
        if(mOriginalUrl != null)        
        {
String var4DE70E97E870523D447117920A26D343_1684813828 =             mOriginalUrl;
            var4DE70E97E870523D447117920A26D343_1684813828.addTaint(taint);
            return var4DE70E97E870523D447117920A26D343_1684813828;
        } //End block
        else
        {
String varF1E91891753CD7C4305CCDECB60B9DDF_1826923279 =             mUrl;
            varF1E91891753CD7C4305CCDECB60B9DDF_1826923279.addTaint(taint);
            return varF1E91891753CD7C4305CCDECB60B9DDF_1826923279;
        } //End block
        // ---------- Original Method ----------
        //if (mOriginalUrl != null) {
            //return mOriginalUrl;
        //} else {
            //return mUrl;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.484 -0400", hash_original_method = "1FD4A483F618FB6B6B2EA6F438798B25", hash_generated_method = "DC6C49EEEF273FCE611D6A62167C9740")
     long postIdentifier() {
        long var326FAE0022967BEB3C583F6C15C54AA4_122643911 = (mPostIdentifier);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_72501738 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_72501738;
        // ---------- Original Method ----------
        //return mPostIdentifier;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.484 -0400", hash_original_method = "555C5182696D3D1E5A8F07F29E226BC9", hash_generated_method = "6EB087C7E803115BBA701FFB7B953F51")
     void attachRequestHandle(RequestHandle requestHandle) {
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        mRequestHandle = requestHandle;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.attachRequestHandle(): " +
                    //"requestHandle: " +  requestHandle);
        //}
        //mRequestHandle = requestHandle;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.484 -0400", hash_original_method = "A03FA80E3F939CA589BDCCBFD92DE3E2", hash_generated_method = "33DAFFD5D390508C3285020545D149C9")
     void detachRequestHandle() {
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        mRequestHandle = null;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "LoadListener.detachRequestHandle(): " +
                    //"requestHandle: " + mRequestHandle);
        //}
        //mRequestHandle = null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.484 -0400", hash_original_method = "34F543213ABA35F3500E526ABE3EA0BF", hash_generated_method = "C51EE3EB880DEE2C6E9A9DFF6BE15A5F")
     void downloadFile() {
        WebViewWorker.getHandler().obtainMessage(
                WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        mBrowserFrame.getCallbackProxy().onDownloadStart(url(), 
                mBrowserFrame.getUserAgentString(),
                mHeaders.getContentDisposition(), 
                mMimeType, mContentLength);
        cancel();
        // ---------- Original Method ----------
        //WebViewWorker.getHandler().obtainMessage(
                //WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        //mBrowserFrame.getCallbackProxy().onDownloadStart(url(), 
                //mBrowserFrame.getUserAgentString(),
                //mHeaders.getContentDisposition(), 
                //mMimeType, mContentLength);
        //cancel();
    }

    
    @DSModeled(DSC.SAFE)
    static boolean willLoadFromCache(String url, long identifier) {
        assert !JniUtil.useChromiumHttpStack();
        boolean inCache =
                CacheManager.getCacheFile(url, identifier, null) != null;
        if (DebugFlags.LOAD_LISTENER) {
            Log.v(LOGTAG, "willLoadFromCache: " + url + " in cache: " + 
                    inCache);
        }
        return inCache;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.484 -0400", hash_original_method = "D1C1DC94D32429EE46F2E8034E6F3CAD", hash_generated_method = "E5BFBF4C61B75C3DF875FCDE0EEBC18D")
     void resetCancel() {
        mCancelled = false;
        // ---------- Original Method ----------
        //mCancelled = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.485 -0400", hash_original_method = "AB4E07CAED8783333F5D8E2EFE2FEA5A", hash_generated_method = "E5BEF6C137EB27A8EB335063EE802D0C")
     String mimeType() {
String varBE38DA462B031CDCB7789EAC19C3FD2D_1965596958 =         mMimeType;
        varBE38DA462B031CDCB7789EAC19C3FD2D_1965596958.addTaint(taint);
        return varBE38DA462B031CDCB7789EAC19C3FD2D_1965596958;
        // ---------- Original Method ----------
        //return mMimeType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.485 -0400", hash_original_method = "EDB0721EF3A307F050BF15E668A80271", hash_generated_method = "21DA5BE88D881B473C94A8865ACFD61D")
     String transferEncoding() {
String varC435B1B6BE37769F851B818623C35399_21893807 =         mTransferEncoding;
        varC435B1B6BE37769F851B818623C35399_21893807.addTaint(taint);
        return varC435B1B6BE37769F851B818623C35399_21893807;
        // ---------- Original Method ----------
        //return mTransferEncoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.485 -0400", hash_original_method = "A0A208846C45918947FC3EEE159224A3", hash_generated_method = "7F79EDFF9E8AB282A753C4B464B82303")
     long contentLength() {
        long varD4BC2D0F0185C97879D7062C4CEFD633_1499285870 = (mContentLength);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_226092368 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_226092368;
        // ---------- Original Method ----------
        //return mContentLength;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.485 -0400", hash_original_method = "78D8A8AE22C18C73CE2907680A09633B", hash_generated_method = "3DCB9B423105DB3EEF38DE83F4513AEE")
    private void commitHeadersCheckRedirect() {
        if(mCancelled)        
        return;
        if((mStatusCode >= 301 && mStatusCode <= 303) || mStatusCode == 307 ||
                (mStatusCode == 304 && mCacheLoader != null))        
        {
            return;
        } //End block
        commitHeaders();
        // ---------- Original Method ----------
        //if (mCancelled) return;
        //if ((mStatusCode >= 301 && mStatusCode <= 303) || mStatusCode == 307 ||
                //(mStatusCode == 304 && mCacheLoader != null)) {
            //return;
        //}
        //commitHeaders();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.485 -0400", hash_original_method = "8E8E66962C082FBF4981B6E1121BFDBD", hash_generated_method = "C61667B6FC1FA27B1FE6176AB1C3C983")
    private void commitHeaders() {
        if(mIsMainPageLoader && CertTool.getCertType(mMimeType) != null)        
        {
            return;
        } //End block
        if(mAuthHeader != null)        
        {
            return;
        } //End block
        setNativeResponse();
        // ---------- Original Method ----------
        //if (mIsMainPageLoader && CertTool.getCertType(mMimeType) != null) {
            //return;
        //}
        //if (mAuthHeader != null) {
            //return;
        //}
        //setNativeResponse();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.488 -0400", hash_original_method = "E28F47114E6BDDF9FD429A699C881F5C", hash_generated_method = "C28ED8FE5AE4C35EBB24DC321B47FC1C")
    private void setNativeResponse() {
        int nativeResponse = createNativeResponse();
        nativeReceivedResponse(nativeResponse);
        mSetNativeResponse = true;
        // ---------- Original Method ----------
        //int nativeResponse = createNativeResponse();
        //nativeReceivedResponse(nativeResponse);
        //mSetNativeResponse = true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.488 -0400", hash_original_method = "90DA669053E3EAB1E41208AD478B9563", hash_generated_method = "16CAF5DC7E81AA0CA9CBDEB1CC4C143D")
    private int createNativeResponse() {
        int statusCode = (mStatusCode == HTTP_NOT_MODIFIED &&
                mCacheLoader != null) ? HTTP_OK : mStatusCode;
        final int nativeResponse = nativeCreateResponse(
                originalUrl(), statusCode, mStatusText,
                mMimeType, mContentLength, mEncoding);
        if(mHeaders != null)        
        {
            mHeaders.getHeaders(new Headers.HeaderCallback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.488 -0400", hash_original_method = "69E60F28B81345DBCE843A767C941042", hash_generated_method = "B6C15EB8876B6B3A10ED5B8B98F99F85")
        public void header(String name, String value) {
            addTaint(value.getTaint());
            addTaint(name.getTaint());
            nativeSetResponseHeader(nativeResponse, name, value);
            // ---------- Original Method ----------
            //nativeSetResponseHeader(nativeResponse, name, value);
        }
});
        } //End block
        int var03DA75041C97002F9817AD239E4B7895_546350548 = (nativeResponse);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881836661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_881836661;
        // ---------- Original Method ----------
        //int statusCode = (mStatusCode == HTTP_NOT_MODIFIED &&
                //mCacheLoader != null) ? HTTP_OK : mStatusCode;
        //final int nativeResponse = nativeCreateResponse(
                //originalUrl(), statusCode, mStatusText,
                //mMimeType, mContentLength, mEncoding);
        //if (mHeaders != null) {
            //mHeaders.getHeaders(new Headers.HeaderCallback() {
                    //public void header(String name, String value) {
                        //nativeSetResponseHeader(nativeResponse, name, value);
                    //}
                //});
        //}
        //return nativeResponse;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.488 -0400", hash_original_method = "6C3510E057E7F86D9E5BFE641B751A6D", hash_generated_method = "8D3C7523265FABC000FBB7CB8CE88B5F")
    private void commitLoad() {
        if(mCancelled)        
        return;
        if(!mSetNativeResponse)        
        {
            setNativeResponse();
        } //End block
        if(mIsMainPageLoader)        
        {
            String type = CertTool.getCertType(mMimeType);
            if(type != null)            
            {
                synchronized
(mDataBuilder)                {
                    byte[] cert = new byte[mDataBuilder.getByteSize()];
                    int offset = 0;
                    while
(true)                    
                    {
                        ByteArrayBuilder.Chunk c = mDataBuilder.getFirstChunk();
                        if(c == null)                        
                        break;
                        if(c.mLength != 0)                        
                        {
                            System.arraycopy(c.mArray, 0, cert, offset, c.mLength);
                            offset += c.mLength;
                        } //End block
                        c.release();
                    } //End block
                    CertTool.addCertificate(mContext, type, cert);
                    mBrowserFrame.stopLoading();
                    return;
                } //End block
            } //End block
        } //End block
        ByteArrayBuilder.Chunk c;
        while
(true)        
        {
            c = mDataBuilder.getFirstChunk();
            if(c == null)            
            break;
            if(c.mLength != 0)            
            {
                nativeAddData(c.mArray, c.mLength);
                WebViewWorker.CacheData data = new WebViewWorker.CacheData();
                data.mListener = this;
                data.mChunk = c;
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_APPEND_CACHE, data).sendToTarget();
            } //End block
            else
            {
                c.release();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.491 -0400", hash_original_method = "622A6BD0A40561F44F0949C5CF1F5483", hash_generated_method = "0F2943AA8A1572F247CE8458D3C53651")
     void tearDown() {
        if(getErrorID() == OK)        
        {
            WebViewWorker.CacheSaveData data = new WebViewWorker.CacheSaveData();
            data.mListener = this;
            data.mUrl = mUrl;
            data.mPostId = mPostIdentifier;
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
        } //End block
        else
        {
            WebViewWorker.getHandler().obtainMessage(
                    WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        } //End block
        if(mNativeLoader != 0)        
        {
            if(!mSetNativeResponse)            
            {
                setNativeResponse();
            } //End block
            nativeFinished();
            clearNativeLoader();
        } //End block
        // ---------- Original Method ----------
        //if (getErrorID() == OK) {
            //WebViewWorker.CacheSaveData data = new WebViewWorker.CacheSaveData();
            //data.mListener = this;
            //data.mUrl = mUrl;
            //data.mPostId = mPostIdentifier;
            //WebViewWorker.getHandler().obtainMessage(
                    //WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
        //} else {
            //WebViewWorker.getHandler().obtainMessage(
                    //WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        //}
        //if (mNativeLoader != 0) {
            //if (!mSetNativeResponse) {
                //setNativeResponse();
            //}
            //nativeFinished();
            //clearNativeLoader();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.491 -0400", hash_original_method = "209FBE9F3E1C7384DEBC7D7B19E27A8A", hash_generated_method = "184A6E36506D96229650E20EB782DB74")
    private int getErrorID() {
        int varD8DD47A761DBCF70988BC325F1308BC8_2145228197 = (mErrorID);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023354564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023354564;
        // ---------- Original Method ----------
        //return mErrorID;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.491 -0400", hash_original_method = "D67F514368DCF056FAAB1F778CFC87BD", hash_generated_method = "9F21E237D68FFC07BC0835D5B30325A6")
    private String getErrorDescription() {
String varC737508C9F8C89DB7BD4BC133B497C01_326508499 =         mErrorDescription;
        varC737508C9F8C89DB7BD4BC133B497C01_326508499.addTaint(taint);
        return varC737508C9F8C89DB7BD4BC133B497C01_326508499;
        // ---------- Original Method ----------
        //return mErrorDescription;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.491 -0400", hash_original_method = "E680E4717FCBA329FAA87BAD42E56CAC", hash_generated_method = "A79CED6EE3BB5BF131234A8C1AD63296")
     void notifyError() {
        if(mNativeLoader != 0)        
        {
            String description = getErrorDescription();
            if(description == null)            
            description = "";
            nativeError(getErrorID(), description, url());
            clearNativeLoader();
        } //End block
        // ---------- Original Method ----------
        //if (mNativeLoader != 0) {
            //String description = getErrorDescription();
            //if (description == null) description = "";
            //nativeError(getErrorID(), description, url());
            //clearNativeLoader();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.492 -0400", hash_original_method = "DFC23EFD31E5C4FF40E98CE1A64FD5ED", hash_generated_method = "98388433302CE192CEC91FE1302C924E")
     void pauseLoad(boolean pause) {
        addTaint(pause);
        if(mRequestHandle != null)        
        {
            mRequestHandle.pauseRequest(pause);
        } //End block
        // ---------- Original Method ----------
        //if (mRequestHandle != null) {
            //mRequestHandle.pauseRequest(pause);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.492 -0400", hash_original_method = "1181D36634AC97975F684A5C861366C7", hash_generated_method = "D4C419FF8C124F461EFC80074C9D533D")
    public void cancel() {
        if(DebugFlags.LOAD_LISTENER)        
        {
            if(mRequestHandle == null)            
            {
            } //End block
            else
            {
            } //End block
        } //End block
        if(mRequestHandle != null)        
        {
            mRequestHandle.cancel();
            mRequestHandle = null;
        } //End block
        WebViewWorker.getHandler().obtainMessage(
                WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        mCancelled = true;
        clearNativeLoader();
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //if (mRequestHandle == null) {
                //Log.v(LOGTAG, "LoadListener.cancel(): no requestHandle");
            //} else {
                //Log.v(LOGTAG, "LoadListener.cancel()");
            //}
        //}
        //if (mRequestHandle != null) {
            //mRequestHandle.cancel();
            //mRequestHandle = null;
        //}
        //WebViewWorker.getHandler().obtainMessage(
                //WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
        //mCancelled = true;
        //clearNativeLoader();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.508 -0400", hash_original_method = "A28FBC4A594C62B1FB221C43DC1C2583", hash_generated_method = "B8B505D541F89B5EC49AD7F8FCB79BA1")
    private void doRedirect() {
        if(mCancelled)        
        {
            return;
        } //End block
        if(mCacheRedirectCount >= RequestHandle.MAX_REDIRECT_COUNT)        
        {
            handleError(EventHandler.ERROR_REDIRECT_LOOP, mContext.getString(
                    R.string.httpErrorRedirectLoop));
            return;
        } //End block
        String redirectTo = mHeaders.getLocation();
        if(redirectTo != null)        
        {
            int nativeResponse = createNativeResponse();
            redirectTo =
                    nativeRedirectedToUrl(mUrl, redirectTo, nativeResponse);
            if(mCancelled)            
            {
                return;
            } //End block
            if(redirectTo == null)            
            {
                Log.d(LOGTAG, "Redirection failed for "
                        + mHeaders.getLocation());
                cancel();
                return;
            } //End block
            else
            if(!URLUtil.isNetworkUrl(redirectTo))            
            {
                final String text = mContext
                        .getString(R.string.open_permission_deny)
                        + "\n" + redirectTo;
                if(!mSetNativeResponse)                
                {
                    setNativeResponse();
                } //End block
                nativeAddData(text.getBytes(), text.length());
                nativeFinished();
                clearNativeLoader();
                return;
            } //End block
            if(getErrorID() == OK)            
            {
                WebViewWorker.CacheSaveData data = new WebViewWorker.CacheSaveData();
                data.mListener = this;
                data.mUrl = mUrl;
                data.mPostId = mPostIdentifier;
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_SAVE_CACHE, data).sendToTarget();
            } //End block
            else
            {
                WebViewWorker.getHandler().obtainMessage(
                        WebViewWorker.MSG_REMOVE_CACHE, this).sendToTarget();
            } //End block
            mOriginalUrl = redirectTo;
            setUrl(redirectTo);
            if(mRequestHeaders == null)            
            {
                mRequestHeaders = new HashMap<String, String>();
            } //End block
            boolean fromCache = false;
            if(mCacheLoader != null)            
            {
                mCacheRedirectCount++;
                fromCache = true;
            } //End block
            if(!checkCache(mRequestHeaders))            
            {
                if(mRequestHandle != null)                
                {
                    try 
                    {
                        mRequestHandle.setupRedirect(mUrl, mStatusCode,
                                mRequestHeaders);
                    } //End block
                    catch (RuntimeException e)
                    {
                        handleError(EventHandler.ERROR_BAD_URL,
                                mContext.getString(R.string.httpErrorBadUrl));
                        return;
                    } //End block
                } //End block
                else
                {
                    Network network = Network.getInstance(getContext());
                    if(!network.requestURL(mMethod, mRequestHeaders,
                            mPostData, this))                    
                    {
                        handleError(EventHandler.ERROR_BAD_URL,
                                mContext.getString(R.string.httpErrorBadUrl));
                        return;
                    } //End block
                } //End block
                if(fromCache)                
                {
                    mRequestHandle.setRedirectCount(mCacheRedirectCount);
                } //End block
            } //End block
            else
            if(!fromCache)            
            {
                mCacheRedirectCount = mRequestHandle.getRedirectCount() + 1;
            } //End block
        } //End block
        else
        {
            commitHeaders();
            commitLoad();
            tearDown();
        } //End block
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.508 -0400", hash_original_method = "F42460285C9091878E41158B4AED6A71", hash_generated_method = "395BFB813E695405C530164CCD202C13")
     void parseContentTypeHeader(String contentType) {
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
        if(contentType != null)        
        {
            int i = contentType.indexOf(';');
            if(i >= 0)            
            {
                mMimeType = contentType.substring(0, i);
                int j = contentType.indexOf('=', i);
                if(j > 0)                
                {
                    i = contentType.indexOf(';', j);
                    if(i < j)                    
                    {
                        i = contentType.length();
                    } //End block
                    mEncoding = contentType.substring(j + 1, i);
                } //End block
                else
                {
                    mEncoding = contentType.substring(i + 1);
                } //End block
                mEncoding = mEncoding.trim().toLowerCase();
                if(i < contentType.length() - 1)                
                {
                    mTransferEncoding =
                            contentType.substring(i + 1).trim().toLowerCase();
                } //End block
            } //End block
            else
            {
                mMimeType = contentType;
            } //End block
            mMimeType = mMimeType.trim();
            try 
            {
                Matcher m = CONTENT_TYPE_PATTERN.matcher(mMimeType);
                if(m.find())                
                {
                    mMimeType = m.group(1);
                } //End block
                else
                {
                    guessMimeType();
                } //End block
            } //End block
            catch (IllegalStateException ex)
            {
                guessMimeType();
            } //End block
        } //End block
        mMimeType = mMimeType.toLowerCase();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.514 -0400", hash_original_method = "AE0FC74CC8A0BC926B5DCE69D72EC94D", hash_generated_method = "25802EC394AD6458F1E12138B6EED77E")
    private HttpAuthHeader parseAuthHeader(String header) {
        addTaint(header.getTaint());
        if(header != null)        
        {
            int posMax = 256;
            int posLen = 0;
            int[] pos = new int [posMax];
            int headerLen = header.length();
            if(headerLen > 0)            
            {
                boolean quoted = false;
for(int i = 0;i < headerLen && posLen < posMax;++i)
                {
                    if(header.charAt(i) == '\"')                    
                    {
                        quoted = !quoted;
                    } //End block
                    else
                    {
                        if(!quoted)                        
                        {
                            if(header.regionMatches(true, i,
                                    HttpAuthHeader.BASIC_TOKEN, 0,
                                    HttpAuthHeader.BASIC_TOKEN.length()))                            
                            {
                                pos[posLen++] = i;
                                continue;
                            } //End block
                            if(header.regionMatches(true, i,
                                    HttpAuthHeader.DIGEST_TOKEN, 0,
                                    HttpAuthHeader.DIGEST_TOKEN.length()))                            
                            {
                                pos[posLen++] = i;
                                continue;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            if(posLen > 0)            
            {
for(int i = 0;i < posLen;i++)
                {
                    if(header.regionMatches(true, pos[i],
                                HttpAuthHeader.DIGEST_TOKEN, 0,
                                HttpAuthHeader.DIGEST_TOKEN.length()))                    
                    {
                        String sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));
                        HttpAuthHeader rval = new HttpAuthHeader(sub);
                        if(rval.isSupportedScheme())                        
                        {
HttpAuthHeader varED8A80714839B9C0BFBED436B84AB17A_1299939341 =                             rval;
                            varED8A80714839B9C0BFBED436B84AB17A_1299939341.addTaint(taint);
                            return varED8A80714839B9C0BFBED436B84AB17A_1299939341;
                        } //End block
                    } //End block
                } //End block
for(int i = 0;i < posLen;i++)
                {
                    if(header.regionMatches(true, pos[i],
                                HttpAuthHeader.BASIC_TOKEN, 0,
                                HttpAuthHeader.BASIC_TOKEN.length()))                    
                    {
                        String sub = header.substring(pos[i],
                                (i + 1 < posLen ? pos[i + 1] : headerLen));
                        HttpAuthHeader rval = new HttpAuthHeader(sub);
                        if(rval.isSupportedScheme())                        
                        {
HttpAuthHeader varED8A80714839B9C0BFBED436B84AB17A_1127806648 =                             rval;
                            varED8A80714839B9C0BFBED436B84AB17A_1127806648.addTaint(taint);
                            return varED8A80714839B9C0BFBED436B84AB17A_1127806648;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
HttpAuthHeader var540C13E9E156B687226421B24F2DF178_11755733 =         null;
        var540C13E9E156B687226421B24F2DF178_11755733.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_11755733;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.514 -0400", hash_original_method = "977413F84EEA9D9E0B7BBB5D674FC9E7", hash_generated_method = "D9C501D50799F4A927177E6B2EBD1B42")
    private boolean ignoreCallbacks() {
        boolean var99935062AE79A9C6C1FC7DE99B97AB18_1913363639 = ((mCancelled || mAuthHeader != null ||
                (mStatusCode > 300 && mStatusCode < 400 && mStatusCode != 305)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606952710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606952710;
        // ---------- Original Method ----------
        //return (mCancelled || mAuthHeader != null ||
                //(mStatusCode > 300 && mStatusCode < 400 && mStatusCode != 305));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.516 -0400", hash_original_method = "B1CFB6FACF3C8464BDC576EEF15EE2EE", hash_generated_method = "125E634D88ED9B7391AF2CF7E3417CF7")
     void setUrl(String url) {
        if(url != null)        
        {
            mUri = null;
            if(URLUtil.isNetworkUrl(url))            
            {
                mUrl = URLUtil.stripAnchor(url);
                try 
                {
                    mUri = new WebAddress(mUrl);
                } //End block
                catch (ParseException e)
                {
                    e.printStackTrace();
                } //End block
            } //End block
            else
            {
                mUrl = url;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (url != null) {
            //mUri = null;
            //if (URLUtil.isNetworkUrl(url)) {
                //mUrl = URLUtil.stripAnchor(url);
                //try {
                    //mUri = new WebAddress(mUrl);
                //} catch (ParseException e) {
                    //e.printStackTrace();
                //}
            //} else {
                //mUrl = url;
            //}
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.516 -0400", hash_original_method = "EF260C0902D2E84B94B185FE48F20D51", hash_generated_method = "28711DD643CF34608F49D6D8562CDC72")
    private void guessMimeType() {
        if(URLUtil.isDataUrl(mUrl) && mMimeType.length() != 0)        
        {
            cancel();
            final String text = mContext.getString(R.string.httpErrorBadUrl);
            handleError(EventHandler.ERROR_BAD_URL, text);
        } //End block
        else
        {
            mMimeType = "text/html";
            String newMimeType = guessMimeTypeFromExtension(mUrl);
            if(newMimeType != null)            
            {
                mMimeType = newMimeType;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (URLUtil.isDataUrl(mUrl) && mMimeType.length() != 0) {
            //cancel();
            //final String text = mContext.getString(R.string.httpErrorBadUrl);
            //handleError(EventHandler.ERROR_BAD_URL, text);
        //} else {
            //mMimeType = "text/html";
            //String newMimeType = guessMimeTypeFromExtension(mUrl);
            //if (newMimeType != null) {
                //mMimeType = newMimeType;
            //}
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.516 -0400", hash_original_method = "2EA3CE69FA8B837FDAA4CA6DE51D2499", hash_generated_method = "B33E62641DBBCB9D882938679B16B709")
    private String guessMimeTypeFromExtension(String url) {
        addTaint(url.getTaint());
        if(DebugFlags.LOAD_LISTENER)        
        {
        } //End block
String var03409C10DCA5CE89E0AD48CDF1A78421_1243645540 =         MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                MimeTypeMap.getFileExtensionFromUrl(url));
        var03409C10DCA5CE89E0AD48CDF1A78421_1243645540.addTaint(taint);
        return var03409C10DCA5CE89E0AD48CDF1A78421_1243645540;
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER) {
            //Log.v(LOGTAG, "guessMimeTypeFromExtension: url = " + url);
        //}
        //return MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                //MimeTypeMap.getFileExtensionFromUrl(url));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.516 -0400", hash_original_method = "4C14C55105A23524352CD131708D205A", hash_generated_method = "236EF38E8295B93154FA549C85020C0C")
    private void sendMessageInternal(Message msg) {
        addTaint(msg.getTaint());
        if(mSynchronous)        
        {
            mMessageQueue.add(msg);
        } //End block
        else
        {
            sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (mSynchronous) {
            //mMessageQueue.add(msg);
        //} else {
            //sendMessage(msg);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.517 -0400", hash_original_method = "84B3C85DEED8CE51C1D689DF257AD721", hash_generated_method = "4FAC56879A8CAD5DD905F5B7EF81C60F")
     void loadSynchronousMessages() {
        if(DebugFlags.LOAD_LISTENER && !mSynchronous)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_250175680 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_250175680.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_250175680;
        } //End block
        while
(!mMessageQueue.isEmpty())        
        {
            handleMessage(mMessageQueue.remove(0));
        } //End block
        // ---------- Original Method ----------
        //if (DebugFlags.LOAD_LISTENER && !mSynchronous) {
            //throw new AssertionError();
        //}
        //while (!mMessageQueue.isEmpty()) {
            //handleMessage(mMessageQueue.remove(0));
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.517 -0400", hash_original_method = "4DA58223C4F20A38192632BBFEEE57C8", hash_generated_method = "AB194D5ECF038E86BB704C2F46B1319A")
    private int nativeCreateResponse(String url, int statusCode,
            String statusText, String mimeType, long expectedLength,
            String encoding) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721871869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721871869;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.517 -0400", hash_original_method = "BA6D20A53269A42AE8656C6EBDDFC70F", hash_generated_method = "2EE95CDE989B39A0D0DDF8BD2F00F5D0")
    private void nativeSetResponseHeader(int nativeResponse, String key,
            String val) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.518 -0400", hash_original_method = "41C6950B308582DB9C9A99E22648CC08", hash_generated_method = "4463E5BF89AC3DAA3138235FBCA35550")
    private void nativeReceivedResponse(int nativeResponse) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.518 -0400", hash_original_method = "CB7AF973B7AC5B91CFB8AF007E1C0D32", hash_generated_method = "2DC911843AB3EF8DD3A2BB1A5E9C90C7")
    private void nativeAddData(byte[] data, int length) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.518 -0400", hash_original_method = "49549DEACC297430F7E9805D3678A016", hash_generated_method = "F76CF5604F7D206ECF3936D4EC9118B8")
    private void nativeFinished() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.190 -0400", hash_original_method = "33F440D9D1697DCCED15CDDD044058A8", hash_generated_method = "29EA735C0797FDF2B21BDCB4EDCF36A9")
    private String nativeRedirectedToUrl(String baseUrl,
            String redirectTo, int nativeResponse) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_method = "BCCFE0CFBD3782D8BEDE6CB5D0F9DEA3", hash_generated_method = "5B90DA7D769D000F23CD21F1BE24C0C0")
    private void nativeError(int id, String desc, String failingUrl) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "509AF2834ADA401F28B3A49D3B705FD7", hash_generated_field = "411E409FCE3C58BE9BA3E6203E80B6AB")

    private static final int MSG_CONTENT_HEADERS = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "7355BAE53F9D568830324A8969C07267", hash_generated_field = "DAA6BB961A1AB150C7D4C79F2F45075C")

    private static final int MSG_CONTENT_DATA = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "A2D250A3518B45A65154B96127A6F664", hash_generated_field = "821C83A5F10056724A1264EDF4B243C7")

    private static final int MSG_CONTENT_FINISHED = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "675853C8435F9866A52B73DF381042EF", hash_generated_field = "B2A41EFD129FF10B9F368F8C3B6CABAB")

    private static final int MSG_CONTENT_ERROR = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "4CF18A1C721AB1F4A835A45350590E10", hash_generated_field = "DEE25F2AAC38E6182B595E5F1A7B9DF8")

    private static final int MSG_LOCATION_CHANGED = 140;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "2481F0AA6F79937644E1A5A293AFBAC3", hash_generated_field = "66AC92B296B18CD4FFA79CCBEBEFDEDC")

    private static final int MSG_LOCATION_CHANGED_REQUEST = 150;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "B7A45E8514F101F74E05513138B304C8", hash_generated_field = "8CE8B590CBF427BDEBAF776EA07B635E")

    private static final int MSG_STATUS = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "15F7BB0E8BD2B4E568C46B6504FE8D7A", hash_generated_field = "77AEDD03EFF9D007A9FF71685ED9B603")

    private static final int MSG_SSL_CERTIFICATE = 170;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "608CB7C17A9F5C4E9F987C213FF631BA", hash_generated_field = "4A5C4BFACAE94926B45870B18FFAEC2B")

    private static final int MSG_SSL_ERROR = 180;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "4800DC2FC1B39792E563783C8F6B5A15", hash_generated_field = "C8D2666C9BA638414EEC6A741AFCFBE7")

    private static final int HTTP_OK = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "0760F8C3033E9095987F4D9935F2063D", hash_generated_field = "D8436253A0E1590995389DEF643C7AC4")

    private static final int HTTP_PARTIAL_CONTENT = 206;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "0DF4FEB60449DF34F1AD9AA9936765DE", hash_generated_field = "A21DD64CACF18DF6C575E72962C46F9E")

    private static final int HTTP_MOVED_PERMANENTLY = 301;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "97B42AAB3CD04F3E73E4AE80BA351129", hash_generated_field = "F16818D73EBE4718633BC72A35C64865")

    private static final int HTTP_FOUND = 302;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "181D1EAE3C8C62D9A4E824819B863C2E", hash_generated_field = "949A18F982649D59B83F6E75D3E98A68")

    private static final int HTTP_SEE_OTHER = 303;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "0FF390CB90ACDFA99B5AA910382219DE", hash_generated_field = "DBCD47929E85185D8F234889685C9320")

    private static final int HTTP_NOT_MODIFIED = 304;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "9BEEF7C99885EE31AD26A587958D111A", hash_generated_field = "A37E4C811DC81991FD4504CDD85F4F53")

    private static final int HTTP_TEMPORARY_REDIRECT = 307;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.524 -0400", hash_original_field = "8E590EA7EB338033302726F6757CBE86", hash_generated_field = "19163CCE00330334DC887A0C1853E241")

    private static final int HTTP_AUTH = 401;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.525 -0400", hash_original_field = "B970EF697AC248BDAD36A5826B50E965", hash_generated_field = "0E33C348AEF88770DA8DCD09874C3305")

    private static final int HTTP_NOT_FOUND = 404;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.525 -0400", hash_original_field = "63AD218BFAC63DB6FD5C0ED2F32ADDA7", hash_generated_field = "6F18BE030B574644F542FCCDBD4B8DCE")

    private static final int HTTP_PROXY_AUTH = 407;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.525 -0400", hash_original_field = "52191F22AFD6839461470104D6DB2030", hash_generated_field = "4FCBFD819BC0278295B9EC4188A35F2D")

    private static int sNativeLoaderCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.525 -0400", hash_original_field = "C18621DE80ED88424E67439E8D952773", hash_generated_field = "F163785717C82BE5535ACE6D74FC3873")

    private static final String XML_MIME_TYPE = "^[\\w_\\-+~!$\\^{}|.%'`#&*]+/" +
            "[\\w_\\-+~!$\\^{}|.%'`#&*]+\\+xml$";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.525 -0400", hash_original_field = "459CF722BCB9467407E6E09F9891AF1C", hash_generated_field = "9A0633094294E861E914F60D234070F3")

    private static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile("^((?:[xX]-)?[a-zA-Z\\*]+/[\\w\\+\\*-]+[\\.[\\w\\+-]+]*)$");
}

