package android.webkit;

// Droidsafe Imports
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.net.http.RequestHandle;
import android.net.http.RequestQueue;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

class HTML5VideoViewProxy extends Handler implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, SurfaceTexture.OnFrameAvailableListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.076 -0400", hash_original_field = "115C9224C60B3C5188E5DD3910D4FB3E", hash_generated_field = "096C00240C7DFE3D6E6EF8AC52FEEDCF")

    int mNativePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.077 -0400", hash_original_field = "9E1CD77DE55A8776417B373B956B63D6", hash_generated_field = "A9DBEFFFAA0F3783D1A7F1847C2580D0")

    private Handler mWebCoreHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.077 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.077 -0400", hash_original_field = "182F6FB856B5900AF9669F3E5011804D", hash_generated_field = "5857B95257DAF50C6CD63C1983865E12")

    private Bitmap mPoster;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.077 -0400", hash_original_field = "20614A9F76475FF831E1EFBD7338FD9D", hash_generated_field = "A0257D682812DF18D1B88A5B56CE9BEA")

    private PosterDownloader mPosterDownloader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.077 -0400", hash_original_field = "EC098B0D70132FDF30E2FE8BE82CA503", hash_generated_field = "698EBF6EB7B1DAA0F058A8EBFD2392EB")

    private int mSeekPosition;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.077 -0400", hash_original_method = "3F3B5BEC7CE790314D5D416DECF5ACFD", hash_generated_method = "2B7AC3ED4FD31337080CF71CF32EC316")
    private  HTML5VideoViewProxy(WebView webView, int nativePtr) {
        super(Looper.getMainLooper());
        mWebView = webView;
        mWebView.setHTML5VideoViewProxy(this);
        mNativePointer = nativePtr;
        createWebCoreHandler();
        // ---------- Original Method ----------
        //mWebView = webView;
        //mWebView.setHTML5VideoViewProxy(this);
        //mNativePointer = nativePtr;
        //createWebCoreHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.078 -0400", hash_original_method = "CDB2DD287D3DEEC004B192544DE39644", hash_generated_method = "3C01D5FD4F9EC7814C8341506F6E8FAE")
    public void onPrepared(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mp.getTaint());
        VideoPlayer.onPrepared();
        Message msg = Message.obtain(mWebCoreHandler, PREPARED);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dur", new Integer(mp.getDuration()));
        map.put("width", new Integer(mp.getVideoWidth()));
        map.put("height", new Integer(mp.getVideoHeight()));
        msg.obj = map;
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //VideoPlayer.onPrepared();
        //Message msg = Message.obtain(mWebCoreHandler, PREPARED);
        //Map<String, Object> map = new HashMap<String, Object>();
        //map.put("dur", new Integer(mp.getDuration()));
        //map.put("width", new Integer(mp.getVideoWidth()));
        //map.put("height", new Integer(mp.getVideoHeight()));
        //msg.obj = map;
        //mWebCoreHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.078 -0400", hash_original_method = "82FFD8A4379253187C5EBB8D52946D71", hash_generated_method = "3DD19A463AEB4719CBD153EC4246BF18")
    public void onCompletion(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mp.getTaint());
        sendMessage(obtainMessage(ENDED, 1, 0));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(ENDED, 1, 0));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.078 -0400", hash_original_method = "655E6549044B32921535D006F146EAB8", hash_generated_method = "6316EC6D496CE54D5F2579F9B560DDEE")
    public boolean onError(MediaPlayer mp, int what, int extra) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extra);
        addTaint(what);
        addTaint(mp.getTaint());
        sendMessage(obtainMessage(ERROR));
        boolean var68934A3E9455FA72420237EB05902327_507240886 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417606153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417606153;
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(ERROR));
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.079 -0400", hash_original_method = "62621EBDF8B0A4EDB36AB4D032595D91", hash_generated_method = "2F375E48F6E447CCC226130CA39C8C1A")
    public void dispatchOnEnded() {
        Message msg = Message.obtain(mWebCoreHandler, ENDED);
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, ENDED);
        //mWebCoreHandler.sendMessage(msg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.079 -0400", hash_original_method = "94DCE2F6FC10D862635A4D190DE0DC1E", hash_generated_method = "9A9C288C348B9F13F50F33873C67974C")
    public void dispatchOnPaused() {
        Message msg = Message.obtain(mWebCoreHandler, PAUSED);
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, PAUSED);
        //mWebCoreHandler.sendMessage(msg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.079 -0400", hash_original_method = "550ED954EF76D5F12E77A6BAA299B5BF", hash_generated_method = "963875518E6A9E46050D8C97B41525B1")
    public void dispatchOnStopFullScreen() {
        Message msg = Message.obtain(mWebCoreHandler, STOPFULLSCREEN);
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, STOPFULLSCREEN);
        //mWebCoreHandler.sendMessage(msg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.079 -0400", hash_original_method = "C11D465DE26E4E34CC2ED3EA3C5CA265", hash_generated_method = "C4D6A72BC32251196FAB8B8FF9FCA05A")
    public void onTimeupdate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendMessage(obtainMessage(TIMEUPDATE));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(TIMEUPDATE));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.080 -0400", hash_original_method = "BC25893B84FEC7EF5FFFF0FB0B5B6C05", hash_generated_method = "F70F47E4576D5C4AC85E967BA51C2C29")
    @Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(surfaceTexture.getTaint());
        mWebView.invalidate();
        // ---------- Original Method ----------
        //mWebView.invalidate();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.080 -0400", hash_original_method = "A79112D38F42B48A9F0E0FABCCDF1611", hash_generated_method = "78AD7D2E1CD464E06384A9780B46F474")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case PLAY:
        {
            String url = (String) msg.obj;
            WebChromeClient client = mWebView.getWebChromeClient();
            int videoLayerID = msg.arg1;
            if(client != null)            
            {
                VideoPlayer.play(url, mSeekPosition, this, client, videoLayerID);
            } //End block
            break;
        } //End block
        case SEEK:
        {
            Integer time = (Integer) msg.obj;
            mSeekPosition = time;
            VideoPlayer.seek(mSeekPosition, this);
            break;
        } //End block
        case PAUSE:
        {
            VideoPlayer.pause(this);
            break;
        } //End block
        case ENDED:
        if(msg.arg1 == 1)        
        VideoPlayer.isVideoSelfEnded = true;
        VideoPlayer.end();
        break;
        case ERROR:
        {
            WebChromeClient client = mWebView.getWebChromeClient();
            if(client != null)            
            {
                client.onHideCustomView();
            } //End block
            break;
        } //End block
        case LOAD_DEFAULT_POSTER:
        {
            WebChromeClient client = mWebView.getWebChromeClient();
            if(client != null)            
            {
                doSetPoster(client.getDefaultVideoPoster());
            } //End block
            break;
        } //End block
        case TIMEUPDATE:
        {
            if(VideoPlayer.isPlaying(this))            
            {
                sendTimeupdate();
            } //End block
            break;
        } //End block
        case BUFFERING_START:
        {
            VideoPlayer.setPlayerBuffering(true);
            break;
        } //End block
        case BUFFERING_END:
        {
            VideoPlayer.setPlayerBuffering(false);
            break;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.389 -0400", hash_original_method = "1A016E6492F3E166AEDA862A5517C526", hash_generated_method = "33018A9ACDFEDC13B4E98D7147E35B5E")
    private void createWebCoreHandler() {
        mWebCoreHandler = new Handler() {        
        @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.388 -0400", hash_original_method = "B10F0183A0FABB1F34A9FD1B81A4AF54", hash_generated_method = "F46A2FD336346BBE5803EEA110CD196E")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case PREPARED:
            {
                Map<String, Object> map = (Map<String, Object>) msg.obj;
                Integer duration = (Integer) map.get("dur");
                Integer width = (Integer) map.get("width");
                Integer height = (Integer) map.get("height");
                nativeOnPrepared(duration.intValue(), width.intValue(),
                                height.intValue(), mNativePointer);
                break;
            } //End block
            case ENDED:
            mSeekPosition = 0;
            nativeOnEnded(mNativePointer);
            break;
            case PAUSED:
            nativeOnPaused(mNativePointer);
            break;
            case POSTER_FETCHED:
            Bitmap poster = (Bitmap) msg.obj;
            nativeOnPosterFetched(poster, mNativePointer);
            break;
            case TIMEUPDATE:
            nativeOnTimeupdate(msg.arg1, mNativePointer);
            break;
            case STOPFULLSCREEN:
            nativeOnStopFullscreen(mNativePointer);
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
};
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.083 -0400", hash_original_method = "76142FB417205DB77C8AC002D1DDBF45", hash_generated_method = "89565AADB4E3B107EE3105852519D2CD")
    private void doSetPoster(Bitmap poster) {
        if(poster == null)        
        {
            return;
        } //End block
        mPoster = poster;
        Message msg = Message.obtain(mWebCoreHandler, POSTER_FETCHED);
        msg.obj = poster;
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //if (poster == null) {
            //return;
        //}
        //mPoster = poster;
        //Message msg = Message.obtain(mWebCoreHandler, POSTER_FETCHED);
        //msg.obj = poster;
        //mWebCoreHandler.sendMessage(msg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.083 -0400", hash_original_method = "16EE14075D106C858D6DFA77C5B90D85", hash_generated_method = "A1D8F1A3BA5BF901EA3EB26973B98198")
    private void sendTimeupdate() {
        Message msg = Message.obtain(mWebCoreHandler, TIMEUPDATE);
        msg.arg1 = VideoPlayer.getCurrentPosition();
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, TIMEUPDATE);
        //msg.arg1 = VideoPlayer.getCurrentPosition();
        //mWebCoreHandler.sendMessage(msg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.084 -0400", hash_original_method = "87AB58F6C80364970DB0BE0C32B4800B", hash_generated_method = "61924CB1EF94A31BF20CC184AF49FD6D")
    public Context getContext() {
Context var7A9501759E8A898311CFF24F0CB70875_809663722 =         mWebView.getContext();
        var7A9501759E8A898311CFF24F0CB70875_809663722.addTaint(taint);
        return var7A9501759E8A898311CFF24F0CB70875_809663722;
        // ---------- Original Method ----------
        //return mWebView.getContext();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.100 -0400", hash_original_method = "93A8BD8C1053222363E314544DFAB05A", hash_generated_method = "85209CAF16C03CC08C3BCC7AAC35EA0E")
    public void play(String url, int position, int videoLayerID) {
        addTaint(videoLayerID);
        addTaint(position);
        addTaint(url.getTaint());
        if(url == null)        
        {
            return;
        } //End block
        if(position > 0)        
        {
            seek(position);
        } //End block
        Message message = obtainMessage(PLAY);
        message.arg1 = videoLayerID;
        message.obj = url;
        sendMessage(message);
        // ---------- Original Method ----------
        //if (url == null) {
            //return;
        //}
        //if (position > 0) {
            //seek(position);
        //}
        //Message message = obtainMessage(PLAY);
        //message.arg1 = videoLayerID;
        //message.obj = url;
        //sendMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.100 -0400", hash_original_method = "5C4141091F743804B15461232C997D85", hash_generated_method = "53CEB95E463DE403098D52D0C683E414")
    public void seek(int time) {
        addTaint(time);
        Message message = obtainMessage(SEEK);
        message.obj = new Integer(time);
        sendMessage(message);
        // ---------- Original Method ----------
        //Message message = obtainMessage(SEEK);
        //message.obj = new Integer(time);
        //sendMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "46912449E5F27493E09DC38DC6351C19", hash_generated_method = "09CCCB37480D8E69FE8536E537982B51")
    public void pause() {
        Message message = obtainMessage(PAUSE);
        sendMessage(message);
        // ---------- Original Method ----------
        //Message message = obtainMessage(PAUSE);
        //sendMessage(message);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "9E02A818380AAE8C95423CA4DF6BB0F2", hash_generated_method = "C45124B7728B878B2EC099BAE52C9F8C")
    public void teardown() {
        if(mPosterDownloader != null)        
        {
            mPosterDownloader.cancelAndReleaseQueue();
        } //End block
        mNativePointer = 0;
        // ---------- Original Method ----------
        //if (mPosterDownloader != null) {
            //mPosterDownloader.cancelAndReleaseQueue();
        //}
        //mNativePointer = 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "F3233AD918CF97E4872803E9BFDDE6E6", hash_generated_method = "4AB8A915C01FFB23CDD41D2431358831")
    public void loadPoster(String url) {
        if(url == null)        
        {
            Message message = obtainMessage(LOAD_DEFAULT_POSTER);
            sendMessage(message);
            return;
        } //End block
        if(mPosterDownloader != null)        
        {
            mPosterDownloader.cancelAndReleaseQueue();
        } //End block
        mPosterDownloader = new PosterDownloader(url, this);
        mPosterDownloader.start();
        // ---------- Original Method ----------
        //if (url == null) {
            //Message message = obtainMessage(LOAD_DEFAULT_POSTER);
            //sendMessage(message);
            //return;
        //}
        //if (mPosterDownloader != null) {
            //mPosterDownloader.cancelAndReleaseQueue();
        //}
        //mPosterDownloader = new PosterDownloader(url, this);
        //mPosterDownloader.start();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "6B4B481A9DF2B25B735CB7B52B3C6386", hash_generated_method = "23B8560AD64E2D58969416BA812D65C3")
    public void setBaseLayer(int layer) {
        addTaint(layer);
        VideoPlayer.setBaseLayer(layer);
        // ---------- Original Method ----------
        //VideoPlayer.setBaseLayer(layer);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "6A592A0539FD41CAB4A89EA53CE8C509", hash_generated_method = "74BD114EA9D2C02C1D31A902EB31DAE1")
    public void pauseAndDispatch() {
        VideoPlayer.pauseAndDispatch();
        // ---------- Original Method ----------
        //VideoPlayer.pauseAndDispatch();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "096DB59D6464AC209548B8DCB36CACB7", hash_generated_method = "1D12F1DDBF3677EA7BE1F5951ADE04D3")
    public void enterFullScreenVideo(int layerId, String url) {
        addTaint(url.getTaint());
        addTaint(layerId);
        VideoPlayer.enterFullScreenVideo(layerId, url, this, mWebView);
        // ---------- Original Method ----------
        //VideoPlayer.enterFullScreenVideo(layerId, url, this, mWebView);
    }

    
    @DSModeled(DSC.SPEC)
    public static HTML5VideoViewProxy getInstance(WebViewCore webViewCore, int nativePtr) {
        return new HTML5VideoViewProxy(webViewCore.getWebView(), nativePtr);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "D61E1D458239E8CEF9B36F4B5C04FED9", hash_generated_method = "DD96449984F9A6A6B53FC458AE0BD8F5")
     WebView getWebView() {
WebView var09F63D9C996D86988FC60D7EA82D7F85_1457897790 =         mWebView;
        var09F63D9C996D86988FC60D7EA82D7F85_1457897790.addTaint(taint);
        return var09F63D9C996D86988FC60D7EA82D7F85_1457897790;
        // ---------- Original Method ----------
        //return mWebView;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "450372CEC4ACF74D667E8FE30D4758C3", hash_generated_method = "4F553D58F082C1728E8C193907AAEE2A")
    private void nativeOnPrepared(int duration, int width, int height, int nativePointer) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.101 -0400", hash_original_method = "69439EE53B1C4D974D568FFBF0847B4A", hash_generated_method = "606701CDB9ADB798998660283F8BB0CA")
    private void nativeOnEnded(int nativePointer) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.102 -0400", hash_original_method = "A4A54DE61D62E407521E72B4C5FDD860", hash_generated_method = "FCF75D98885EFEC14C33BE0CD19DDC1D")
    private void nativeOnPaused(int nativePointer) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.102 -0400", hash_original_method = "84652220F84E924B202B7575A6B0DB08", hash_generated_method = "244F590E15C6B3F7B8C744921F972E2E")
    private void nativeOnPosterFetched(Bitmap poster, int nativePointer) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.102 -0400", hash_original_method = "40EE80299CDDB294EE4D171341428EFD", hash_generated_method = "04ABF3516A1C313065D46866A8B341C6")
    private void nativeOnTimeupdate(int position, int nativePointer) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.102 -0400", hash_original_method = "73782D526ACC6162F582FA042F7A8C14", hash_generated_method = "1DA2104914209C6F0AED0256CC37B268")
    private void nativeOnStopFullscreen(int nativePointer) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSendSurfaceTexture(SurfaceTexture texture,
            int baseLayer, int videoLayerId, int textureName,
            int playerState) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661271996 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661271996;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.102 -0400", hash_original_method = "F17ABD2D26205A567E8F07C068E86E0A", hash_generated_method = "F1792EEA382D38FAAAFD04161E51CBFD")
    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extra);
        addTaint(what);
        addTaint(mp.getTaint());
        if(what == MediaPlayer.MEDIA_INFO_BUFFERING_START)        
        {
            sendMessage(obtainMessage(BUFFERING_START, what, extra));
        } //End block
        else
        if(what == MediaPlayer.MEDIA_INFO_BUFFERING_END)        
        {
            sendMessage(obtainMessage(BUFFERING_END, what, extra));
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_268461500 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905979636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905979636;
        // ---------- Original Method ----------
        //if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
            //sendMessage(obtainMessage(BUFFERING_START, what, extra));
        //} else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
            //sendMessage(obtainMessage(BUFFERING_END, what, extra));
        //}
        //return false;
    }

    
    private static final class VideoPlayer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.102 -0400", hash_original_method = "9A68A6C42721A074DDF281539068301A", hash_generated_method = "9A68A6C42721A074DDF281539068301A")
        public VideoPlayer ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        private static void setPlayerBuffering(boolean playerBuffering) {
            mHTML5VideoView.setPlayerBuffering(playerBuffering);
        }

        
        @DSModeled(DSC.SPEC)
        public static void setBaseLayer(int layer) {
            if (mHTML5VideoView != null
                && !mHTML5VideoView.isFullScreenMode()
                && !mHTML5VideoView.surfaceTextureDeleted()) {
                mBaseLayer = layer;
                int currentVideoLayerId = mHTML5VideoView.getVideoLayerId();
                SurfaceTexture surfTexture = mHTML5VideoView.getSurfaceTexture(currentVideoLayerId);
                int textureName = mHTML5VideoView.getTextureName();
                if (layer != 0 && surfTexture != null && currentVideoLayerId != -1) {
                    int playerState = mHTML5VideoView.getCurrentState();
                    if (mHTML5VideoView.getPlayerBuffering())
                        playerState = HTML5VideoView.STATE_NOTPREPARED;
                    boolean foundInTree = nativeSendSurfaceTexture(surfTexture,
                            layer, currentVideoLayerId, textureName,
                            playerState);
                    if (playerState >= HTML5VideoView.STATE_PREPARED
                            && !foundInTree) {
                        mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                        mHTML5VideoView.deleteSurfaceTexture();
                    }
                }
            }
        }

        
        @DSModeled(DSC.SPEC)
        public static void pauseAndDispatch() {
            if (mHTML5VideoView != null) {
                mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                setBaseLayer(mBaseLayer);
            }
        }

        
        public static void enterFullScreenVideo(int layerId, String url,
                HTML5VideoViewProxy proxy, WebView webView) {
            int savePosition = 0;
            boolean savedIsPlaying = false;
            if (mHTML5VideoView != null) {
                    if (layerId == mHTML5VideoView.getVideoLayerId()) {
                        savePosition = mHTML5VideoView.getCurrentPosition();
                        savedIsPlaying = mHTML5VideoView.isPlaying();
                    }
                    mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                    mHTML5VideoView.release();
                }
            mHTML5VideoView = new HTML5VideoFullScreen(proxy.getContext(),
                        layerId, savePosition, savedIsPlaying);
            mCurrentProxy = proxy;
            mHTML5VideoView.setVideoURI(url, mCurrentProxy);
            mHTML5VideoView.enterFullScreenVideoState(layerId, proxy, webView);
        }

        
        @DSModeled(DSC.SPEC)
        public static void play(String url, int time, HTML5VideoViewProxy proxy,
                WebChromeClient client, int videoLayerId) {
            int currentVideoLayerId = -1;
            boolean backFromFullScreenMode = false;
            if (mHTML5VideoView != null) {
                currentVideoLayerId = mHTML5VideoView.getVideoLayerId();
                backFromFullScreenMode = mHTML5VideoView.fullScreenExited();
            }
            if (backFromFullScreenMode
                || currentVideoLayerId != videoLayerId
                || mHTML5VideoView.surfaceTextureDeleted()) {
                if (mHTML5VideoView != null) {
                    if (!backFromFullScreenMode) {
                        mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                    }
                    mHTML5VideoView.release();
                }
                mCurrentProxy = proxy;
                mHTML5VideoView = new HTML5VideoInline(videoLayerId, time, false);
                mHTML5VideoView.setVideoURI(url, mCurrentProxy);
                mHTML5VideoView.prepareDataAndDisplayMode(proxy);
            } else if (mCurrentProxy == proxy) {
                if (!mHTML5VideoView.isPlaying()) {
                    mHTML5VideoView.seekTo(time);
                    mHTML5VideoView.start();
                }
            } else if (mCurrentProxy != null) {
                proxy.dispatchOnEnded();
            }
        }

        
        @DSModeled(DSC.SPEC)
        public static boolean isPlaying(HTML5VideoViewProxy proxy) {
            return (mCurrentProxy == proxy && mHTML5VideoView != null
                    && mHTML5VideoView.isPlaying());
        }

        
        @DSModeled(DSC.SPEC)
        public static int getCurrentPosition() {
            int currentPosMs = 0;
            if (mHTML5VideoView != null) {
                currentPosMs = mHTML5VideoView.getCurrentPosition();
            }
            return currentPosMs;
        }

        
        @DSModeled(DSC.SPEC)
        public static void seek(int time, HTML5VideoViewProxy proxy) {
            if (mCurrentProxy == proxy && time >= 0 && mHTML5VideoView != null) {
                mHTML5VideoView.seekTo(time);
            }
        }

        
        @DSModeled(DSC.SPEC)
        public static void pause(HTML5VideoViewProxy proxy) {
            if (mCurrentProxy == proxy && mHTML5VideoView != null) {
                mHTML5VideoView.pause();
            }
        }

        
        @DSModeled(DSC.SPEC)
        public static void onPrepared() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if (!mHTML5VideoView.isFullScreenMode() || mHTML5VideoView.getAutostart()) {
                mHTML5VideoView.start();
            }
            if (mBaseLayer != 0) {
                setBaseLayer(mBaseLayer);
            }
        }

        
        @DSModeled(DSC.SPEC)
        public static void end() {
            if (mCurrentProxy != null) {
                if (isVideoSelfEnded)
                    mCurrentProxy.dispatchOnEnded();
                else
                    mCurrentProxy.dispatchOnPaused();
            }
            isVideoSelfEnded = false;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "48C39BB6EC1199D9EBF7EEC283463BDE", hash_generated_field = "4A3E3DA54FD2CE87A72A4D6B0E116413")

        private static HTML5VideoViewProxy mCurrentProxy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "85399C39AAA033F22163A94210E28EFF", hash_generated_field = "80F1D13569588086211DB6AF91EA1FB2")

        private static HTML5VideoView mHTML5VideoView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "6D740ACA5ED030CAFAEDC7530D86FF2C", hash_generated_field = "03E3F53D98F1C739148B69AE13616028")

        private static boolean isVideoSelfEnded = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "914B44A98236EE30FAE19887F1298541", hash_generated_field = "6AD39D1B724E38A03C82BCDCEBAFCB2A")

        private static int mBaseLayer = 0;
    }


    
    private static final class PosterDownloader implements EventHandler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "89E832BB000DD0963806253C292C25BE")

        private URL mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "7D88DE9DD0EF018B770128257B4D159F", hash_generated_field = "701E8A5CEFF22C717E0E1190038ED0C2")

        private HTML5VideoViewProxy mProxy;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "B473BE954AD3CA98FC78D6D592C12BCD", hash_generated_field = "B7F423E620814CC6F793E3C8C73A8DA4")

        private ByteArrayOutputStream mPosterBytes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "8F2BBF6B97D2E4DAE439A5022B5DBE41", hash_generated_field = "D2C086119AFB2A8257E7CAD619AFA47F")

        private RequestHandle mRequestHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "7948B1EFB4AE211035F97F99CDB6078C", hash_generated_field = "A03B65E05BCBAEC5D04E36F3DA55AA89")

        private int mStatusCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "13C03042313948D47B6F87C772F0131E")

        private Headers mHeaders;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.103 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.104 -0400", hash_original_method = "9561F290D28095FEEC4780B73D7797B0", hash_generated_method = "486728A154E8B33973D0924E25BC67D4")
        public  PosterDownloader(String url, HTML5VideoViewProxy proxy) {
            try 
            {
                mUrl = new URL(url);
            } //End block
            catch (MalformedURLException e)
            {
                mUrl = null;
            } //End block
            mProxy = proxy;
            mHandler = new Handler();
            // ---------- Original Method ----------
            //try {
                //mUrl = new URL(url);
            //} catch (MalformedURLException e) {
                //mUrl = null;
            //}
            //mProxy = proxy;
            //mHandler = new Handler();
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.104 -0400", hash_original_method = "CC810E3C0FAB270632EED4A599C0CF83", hash_generated_method = "042082FBCFAB21AD6CA09C260B8F7ABD")
        public void start() {
            retainQueue();
            if(mUrl == null)            
            {
                return;
            } //End block
            String protocol = mUrl.getProtocol();
            if("http".equals(protocol) || "https".equals(protocol))            
            {
                mRequestHandle = mRequestQueue.queueRequest(mUrl.toString(), "GET", null,
                        this, null, 0);
            } //End block
            // ---------- Original Method ----------
            //retainQueue();
            //if (mUrl == null) {
                //return;
            //}
            //String protocol = mUrl.getProtocol();
            //if ("http".equals(protocol) || "https".equals(protocol)) {
                //mRequestHandle = mRequestQueue.queueRequest(mUrl.toString(), "GET", null,
                        //this, null, 0);
            //}
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.104 -0400", hash_original_method = "8F7C386AF7191A4B819017852DB14B13", hash_generated_method = "5AD607E8F258C88941C8A2356A927866")
        public void cancelAndReleaseQueue() {
            if(mRequestHandle != null)            
            {
                mRequestHandle.cancel();
                mRequestHandle = null;
            } //End block
            releaseQueue();
            // ---------- Original Method ----------
            //if (mRequestHandle != null) {
                //mRequestHandle.cancel();
                //mRequestHandle = null;
            //}
            //releaseQueue();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.104 -0400", hash_original_method = "3D0957D11B46ABCB01980155EE173252", hash_generated_method = "42980D93BA2A43E7DE94A7AE6CE8083D")
        public void status(int major_version,
                int minor_version,
                int code,
                String reason_phrase) {
            addTaint(reason_phrase.getTaint());
            addTaint(minor_version);
            addTaint(major_version);
            mStatusCode = code;
            // ---------- Original Method ----------
            //mStatusCode = code;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.104 -0400", hash_original_method = "BF40C4FA5E162E01EBED02AABC1482F3", hash_generated_method = "E45FA39053CF44926A6AA06D774A1F7D")
        public void headers(Headers headers) {
            mHeaders = headers;
            // ---------- Original Method ----------
            //mHeaders = headers;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.104 -0400", hash_original_method = "859FCB672305C2E845A33390ED99DE51", hash_generated_method = "510F9B09829ABB15B34200F866435054")
        public void data(byte[] data, int len) {
            addTaint(len);
            addTaint(data[0]);
            if(mPosterBytes == null)            
            {
                mPosterBytes = new ByteArrayOutputStream();
            } //End block
            mPosterBytes.write(data, 0, len);
            // ---------- Original Method ----------
            //if (mPosterBytes == null) {
                //mPosterBytes = new ByteArrayOutputStream();
            //}
            //mPosterBytes.write(data, 0, len);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "338E5BF0BBF2101BF0B2221F763D6960", hash_generated_method = "141C3B73DC0CDA8BD805841A16E0D059")
        public void endData() {
            if(mStatusCode == 200)            
            {
                if(mPosterBytes.size() > 0)                
                {
                    Bitmap poster = BitmapFactory.decodeByteArray(
                            mPosterBytes.toByteArray(), 0, mPosterBytes.size());
                    mProxy.doSetPoster(poster);
                } //End block
                cleanup();
            } //End block
            else
            if(mStatusCode >= 300 && mStatusCode < 400)            
            {
                try 
                {
                    mUrl = new URL(mHeaders.getLocation());
                } //End block
                catch (MalformedURLException e)
                {
                    mUrl = null;
                } //End block
                if(mUrl != null)                
                {
                    mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "92B9FBCB479F24310DB8CA88B9363005", hash_generated_method = "131559B1F4DDF864EC4E1598285BB900")
            public void run() {
                if(mRequestHandle != null)                
                {
                    mRequestHandle.setupRedirect(mUrl.toString(), mStatusCode,
                                       new HashMap<String, String>());
                } //End block
                // ---------- Original Method ----------
                //if (mRequestHandle != null) {
                               //mRequestHandle.setupRedirect(mUrl.toString(), mStatusCode,
                                       //new HashMap<String, String>());
                           //}
            }
});
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "1CF1F157C74C81DF70E7D72EFED2A778", hash_generated_method = "BA975D17C2A9DCB3141CC03D45651106")
        public void certificate(SslCertificate certificate) {
            addTaint(certificate.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "6EDF05BF0C2DDE3A327FD5313CE1B221", hash_generated_method = "38697E274A0137E093289B9D4F8FDF47")
        public void error(int id, String description) {
            addTaint(description.getTaint());
            addTaint(id);
            cleanup();
            // ---------- Original Method ----------
            //cleanup();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "4CC585D4993857C36C3ADB32AB66A34A", hash_generated_method = "6AC5D17A89D12D76D6E466A2AEDBB406")
        public boolean handleSslErrorRequest(SslError error) {
            addTaint(error.getTaint());
            boolean var68934A3E9455FA72420237EB05902327_1182686755 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268425993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_268425993;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "1FB179217FC31AC7E38E0A4A1EABBB3F", hash_generated_method = "B1C956A42341AFECA9581D13F21EDCBA")
        private void cleanup() {
            if(mPosterBytes != null)            
            {
                try 
                {
                    mPosterBytes.close();
                } //End block
                catch (IOException ignored)
                {
                } //End block
                finally 
                {
                    mPosterBytes = null;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (mPosterBytes != null) {
                //try {
                    //mPosterBytes.close();
                //} catch (IOException ignored) {
                //} finally {
                    //mPosterBytes = null;
                //}
            //}
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "AF9CEA251B70F416DD7268C7CEF45292", hash_generated_method = "1BE94035A69E59A948F5E1D829997099")
        private void retainQueue() {
            if(mRequestQueue == null)            
            {
                mRequestQueue = new RequestQueue(mProxy.getContext());
            } //End block
            mQueueRefCount++;
            // ---------- Original Method ----------
            //if (mRequestQueue == null) {
                //mRequestQueue = new RequestQueue(mProxy.getContext());
            //}
            //mQueueRefCount++;
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_method = "AF9D604E006D921DB2DDEF5C99CED27E", hash_generated_method = "CDB65C3CDCD342AAE33FCDB3799A75EB")
        private void releaseQueue() {
            if(mQueueRefCount == 0)            
            {
                return;
            } //End block
            if(--mQueueRefCount == 0)            
            {
                mRequestQueue.shutdown();
                mRequestQueue = null;
            } //End block
            // ---------- Original Method ----------
            //if (mQueueRefCount == 0) {
                //return;
            //}
            //if (--mQueueRefCount == 0) {
                //mRequestQueue.shutdown();
                //mRequestQueue = null;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_field = "446B3D97C833B98F7071BDDC6133F7E3", hash_generated_field = "381C5A0A88CF182455E810191A19243F")

        private static RequestQueue mRequestQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.105 -0400", hash_original_field = "9F6776BFE48A31F1386ECB84145BEC79", hash_generated_field = "41C6B2C8620F8E9A8462DD7D6FE26631")

        private static int mQueueRefCount = 0;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "41974BD5F90F5909D75003415C2AEFC3", hash_generated_field = "49647B825D8BF64F7018D2D660AE2DD2")

    private static final String LOGTAG = "HTML5VideoViewProxy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "A8A7423F5FE384902AE488C5776060DA", hash_generated_field = "1A2E0BA6D922573100C47A11D967D412")

    private static final int PLAY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "31FE0E2173C512B2F84D1C49E921041B", hash_generated_field = "F297D6EA66381DCD9F653B06169C148E")

    private static final int SEEK = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "78341FFC8FF21D87752376EB104594F2", hash_generated_field = "92479A5B7CC3EBB08F6379E0A36FD263")

    private static final int PAUSE = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "D8302050E7E873755CB12ABAFEFA833F", hash_generated_field = "FA5A5C59B608D4732861F55B1ED507AE")

    private static final int ERROR = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "FC81122DDEC552D23CDC08F565700631", hash_generated_field = "17423F4DA5C0885D4AE045DAC00FE0BD")

    private static final int LOAD_DEFAULT_POSTER = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "9CB774784338E3BF840A39A202FEDA1B", hash_generated_field = "CB858799F6E9BC8B0A67FBAC7E6CCABE")

    private static final int BUFFERING_START = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "7724426887167F27ABB80BDC514BAF60", hash_generated_field = "A2021E991942F90193594238D7EA38B3")

    private static final int BUFFERING_END = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "76BF0ADBB908B5670C31B12D966606F8", hash_generated_field = "6FCD07752AAE7347A325132AEFCA6FAD")

    private static final int PREPARED = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "C3968ABDCD4F6737EB65B7D60DD6008D", hash_generated_field = "C3981D973342E27F2E6D4AC02D37EBE6")

    private static final int ENDED = 201;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "EE258AB86AA1CB3902FE7C68CCB696DA", hash_generated_field = "3F063A1EF6E86BC17D1ADF423756387F")

    private static final int POSTER_FETCHED = 202;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "865B25C18582BA4E78F7B8FE76F98EC7", hash_generated_field = "F43659D42379C6E89435A6E22F31EA13")

    private static final int PAUSED = 203;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "6C417CF1D9738ED2B7F8D26EF3424932", hash_generated_field = "9E94C7895AB3FAFCEA7EA4B9DAF117C1")

    private static final int STOPFULLSCREEN = 204;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.106 -0400", hash_original_field = "F6A799184AA5A09FA5FCD23275E5EFFD", hash_generated_field = "D1EE50147F28681C567966EC0EF27CE7")

    private static final int TIMEUPDATE = 300;
}

