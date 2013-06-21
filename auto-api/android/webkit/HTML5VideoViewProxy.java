package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class HTML5VideoViewProxy extends Handler implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, SurfaceTexture.OnFrameAvailableListener {
    int mNativePointer;
    private Handler mWebCoreHandler;
    private WebView mWebView;
    private Bitmap mPoster;
    private PosterDownloader mPosterDownloader;
    private int mSeekPosition;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.352 -0400", hash_original_method = "3F3B5BEC7CE790314D5D416DECF5ACFD", hash_generated_method = "D7D35E31B0F5C9D4380CB35C5E243A64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private HTML5VideoViewProxy(WebView webView, int nativePtr) {
        super(Looper.getMainLooper());
        dsTaint.addTaint(nativePtr);
        dsTaint.addTaint(webView.dsTaint);
        mWebView.setHTML5VideoViewProxy(this);
        createWebCoreHandler();
        // ---------- Original Method ----------
        //mWebView = webView;
        //mWebView.setHTML5VideoViewProxy(this);
        //mNativePointer = nativePtr;
        //createWebCoreHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.353 -0400", hash_original_method = "CDB2DD287D3DEEC004B192544DE39644", hash_generated_method = "D078182E84655A8EF42745B0831F9888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onPrepared(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mp.dsTaint);
        VideoPlayer.onPrepared();
        Message msg;
        msg = Message.obtain(mWebCoreHandler, PREPARED);
        Map<String, Object> map;
        map = new HashMap<String, Object>();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.353 -0400", hash_original_method = "82FFD8A4379253187C5EBB8D52946D71", hash_generated_method = "CBA6F5F7A766B6BB948473E20EDCD0F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onCompletion(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mp.dsTaint);
        sendMessage(obtainMessage(ENDED, 1, 0));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(ENDED, 1, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.353 -0400", hash_original_method = "655E6549044B32921535D006F146EAB8", hash_generated_method = "D2661C8C21460280AF370586617BA9E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onError(MediaPlayer mp, int what, int extra) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mp.dsTaint);
        dsTaint.addTaint(what);
        dsTaint.addTaint(extra);
        sendMessage(obtainMessage(ERROR));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(ERROR));
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.353 -0400", hash_original_method = "62621EBDF8B0A4EDB36AB4D032595D91", hash_generated_method = "80AFC6BA99338F66A43C2401A7AABE19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchOnEnded() {
        Message msg;
        msg = Message.obtain(mWebCoreHandler, ENDED);
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, ENDED);
        //mWebCoreHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.354 -0400", hash_original_method = "94DCE2F6FC10D862635A4D190DE0DC1E", hash_generated_method = "0A78528446C831607B1A9061C3BCD7D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchOnPaused() {
        Message msg;
        msg = Message.obtain(mWebCoreHandler, PAUSED);
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, PAUSED);
        //mWebCoreHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.354 -0400", hash_original_method = "550ED954EF76D5F12E77A6BAA299B5BF", hash_generated_method = "F6F96A4DC6D64B2051C1130A795FB1D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchOnStopFullScreen() {
        Message msg;
        msg = Message.obtain(mWebCoreHandler, STOPFULLSCREEN);
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, STOPFULLSCREEN);
        //mWebCoreHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.354 -0400", hash_original_method = "C11D465DE26E4E34CC2ED3EA3C5CA265", hash_generated_method = "C4D6A72BC32251196FAB8B8FF9FCA05A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onTimeupdate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        sendMessage(obtainMessage(TIMEUPDATE));
        // ---------- Original Method ----------
        //sendMessage(obtainMessage(TIMEUPDATE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.354 -0400", hash_original_method = "BC25893B84FEC7EF5FFFF0FB0B5B6C05", hash_generated_method = "8F37F843A2311CCAFD7ABE445C922ABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(surfaceTexture.dsTaint);
        mWebView.invalidate();
        // ---------- Original Method ----------
        //mWebView.invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.355 -0400", hash_original_method = "A79112D38F42B48A9F0E0FABCCDF1611", hash_generated_method = "390AFF7F31E6A8CCFED2674085E2085C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case PLAY 
        {
            String url;
            url = (String) msg.obj;
            WebChromeClient client;
            client = mWebView.getWebChromeClient();
            int videoLayerID;
            videoLayerID = msg.arg1;
            {
                VideoPlayer.play(url, mSeekPosition, this, client, videoLayerID);
            } //End block
        } //End block
        //End case PLAY 
        //Begin case SEEK 
        {
            Integer time;
            time = (Integer) msg.obj;
            mSeekPosition = time;
            VideoPlayer.seek(mSeekPosition, this);
        } //End block
        //End case SEEK 
        //Begin case PAUSE 
        {
            VideoPlayer.pause(this);
        } //End block
        //End case PAUSE 
        //Begin case ENDED 
        VideoPlayer.isVideoSelfEnded = true;
        //End case ENDED 
        //Begin case ENDED 
        VideoPlayer.end();
        //End case ENDED 
        //Begin case ERROR 
        {
            WebChromeClient client;
            client = mWebView.getWebChromeClient();
            {
                client.onHideCustomView();
            } //End block
        } //End block
        //End case ERROR 
        //Begin case LOAD_DEFAULT_POSTER 
        {
            WebChromeClient client;
            client = mWebView.getWebChromeClient();
            {
                doSetPoster(client.getDefaultVideoPoster());
            } //End block
        } //End block
        //End case LOAD_DEFAULT_POSTER 
        //Begin case TIMEUPDATE 
        {
            {
                boolean var5B158A5B0EFB46B96646F59F4969BBB6_1562482490 = (VideoPlayer.isPlaying(this));
                {
                    sendTimeupdate();
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case TIMEUPDATE 
        //Begin case BUFFERING_START 
        {
            VideoPlayer.setPlayerBuffering(true);
        } //End block
        //End case BUFFERING_START 
        //Begin case BUFFERING_END 
        {
            VideoPlayer.setPlayerBuffering(false);
        } //End block
        //End case BUFFERING_END 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.356 -0400", hash_original_method = "1A016E6492F3E166AEDA862A5517C526", hash_generated_method = "C2A9DAB66E32E634E647CD4137C1E5F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createWebCoreHandler() {
        mWebCoreHandler = new Handler() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.355 -0400", hash_original_method = "B10F0183A0FABB1F34A9FD1B81A4AF54", hash_generated_method = "CEE03FA5589C14B8BD5B116D3A203E21")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void handleMessage(Message msg) {
                dsTaint.addTaint(msg.dsTaint);
                //Begin case PREPARED 
                {
                    Map<String, Object> map;
                    map = (Map<String, Object>) msg.obj;
                    Integer duration;
                    duration = (Integer) map.get("dur");
                    Integer width;
                    width = (Integer) map.get("width");
                    Integer height;
                    height = (Integer) map.get("height");
                    nativeOnPrepared(duration.intValue(), width.intValue(),
                                height.intValue(), mNativePointer);
                } //End block
                //End case PREPARED 
                //Begin case ENDED 
                mSeekPosition = 0;
                //End case ENDED 
                //Begin case ENDED 
                nativeOnEnded(mNativePointer);
                //End case ENDED 
                //Begin case PAUSED 
                nativeOnPaused(mNativePointer);
                //End case PAUSED 
                //Begin case POSTER_FETCHED 
                Bitmap poster;
                poster = (Bitmap) msg.obj;
                //End case POSTER_FETCHED 
                //Begin case POSTER_FETCHED 
                nativeOnPosterFetched(poster, mNativePointer);
                //End case POSTER_FETCHED 
                //Begin case TIMEUPDATE 
                nativeOnTimeupdate(msg.arg1, mNativePointer);
                //End case TIMEUPDATE 
                //Begin case STOPFULLSCREEN 
                nativeOnStopFullscreen(mNativePointer);
                //End case STOPFULLSCREEN 
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
};
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.356 -0400", hash_original_method = "76142FB417205DB77C8AC002D1DDBF45", hash_generated_method = "E36ED48037A926C180627DDA800F0F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doSetPoster(Bitmap poster) {
        dsTaint.addTaint(poster.dsTaint);
        Message msg;
        msg = Message.obtain(mWebCoreHandler, POSTER_FETCHED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.356 -0400", hash_original_method = "16EE14075D106C858D6DFA77C5B90D85", hash_generated_method = "EC8F969F2AF0A64DDDACAF0DD03B71FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendTimeupdate() {
        Message msg;
        msg = Message.obtain(mWebCoreHandler, TIMEUPDATE);
        msg.arg1 = VideoPlayer.getCurrentPosition();
        mWebCoreHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain(mWebCoreHandler, TIMEUPDATE);
        //msg.arg1 = VideoPlayer.getCurrentPosition();
        //mWebCoreHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.356 -0400", hash_original_method = "87AB58F6C80364970DB0BE0C32B4800B", hash_generated_method = "818E80956CED0755517AFB6B4BFE8EA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Context getContext() {
        Context var4C8BF7B08921369C20F5FB87A41FCDC9_2000934667 = (mWebView.getContext());
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebView.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.356 -0400", hash_original_method = "93A8BD8C1053222363E314544DFAB05A", hash_generated_method = "D24A7F7F53A6896BD3D8AB697344ABF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void play(String url, int position, int videoLayerID) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(videoLayerID);
        dsTaint.addTaint(url);
        {
            seek(position);
        } //End block
        Message message;
        message = obtainMessage(PLAY);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.357 -0400", hash_original_method = "5C4141091F743804B15461232C997D85", hash_generated_method = "7D5406F7D7C867C21316B7278654E21D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void seek(int time) {
        dsTaint.addTaint(time);
        Message message;
        message = obtainMessage(SEEK);
        message.obj = new Integer(time);
        sendMessage(message);
        // ---------- Original Method ----------
        //Message message = obtainMessage(SEEK);
        //message.obj = new Integer(time);
        //sendMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.357 -0400", hash_original_method = "46912449E5F27493E09DC38DC6351C19", hash_generated_method = "0B4BD71F8D14185D13DD553C44880FCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pause() {
        Message message;
        message = obtainMessage(PAUSE);
        sendMessage(message);
        // ---------- Original Method ----------
        //Message message = obtainMessage(PAUSE);
        //sendMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.357 -0400", hash_original_method = "9E02A818380AAE8C95423CA4DF6BB0F2", hash_generated_method = "41E3FC28AA66F4582EE0BE4C6F05BBC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void teardown() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.357 -0400", hash_original_method = "F3233AD918CF97E4872803E9BFDDE6E6", hash_generated_method = "923E91D27382F4EA1A7049D237B46BE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadPoster(String url) {
        dsTaint.addTaint(url);
        {
            Message message;
            message = obtainMessage(LOAD_DEFAULT_POSTER);
            sendMessage(message);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.357 -0400", hash_original_method = "6B4B481A9DF2B25B735CB7B52B3C6386", hash_generated_method = "B5E608FF391020BE8F335245A3E728E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBaseLayer(int layer) {
        dsTaint.addTaint(layer);
        VideoPlayer.setBaseLayer(layer);
        // ---------- Original Method ----------
        //VideoPlayer.setBaseLayer(layer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.358 -0400", hash_original_method = "6A592A0539FD41CAB4A89EA53CE8C509", hash_generated_method = "74BD114EA9D2C02C1D31A902EB31DAE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pauseAndDispatch() {
        VideoPlayer.pauseAndDispatch();
        // ---------- Original Method ----------
        //VideoPlayer.pauseAndDispatch();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.358 -0400", hash_original_method = "096DB59D6464AC209548B8DCB36CACB7", hash_generated_method = "6D2BDCA76EDA0402D59D0EA0CC3AB264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enterFullScreenVideo(int layerId, String url) {
        dsTaint.addTaint(layerId);
        dsTaint.addTaint(url);
        VideoPlayer.enterFullScreenVideo(layerId, url, this, mWebView);
        // ---------- Original Method ----------
        //VideoPlayer.enterFullScreenVideo(layerId, url, this, mWebView);
    }

    
        public static HTML5VideoViewProxy getInstance(WebViewCore webViewCore, int nativePtr) {
        return new HTML5VideoViewProxy(webViewCore.getWebView(), nativePtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.358 -0400", hash_original_method = "D61E1D458239E8CEF9B36F4B5C04FED9", hash_generated_method = "7FFA6514EDCAA08F4BAA371C1E2D501F")
    @DSModeled(DSC.SAFE)
     WebView getWebView() {
        return (WebView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWebView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.358 -0400", hash_original_method = "450372CEC4ACF74D667E8FE30D4758C3", hash_generated_method = "6D90859C05C69931F8965C286AF6DCEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeOnPrepared(int duration, int width, int height, int nativePointer) {
        dsTaint.addTaint(duration);
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(nativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.358 -0400", hash_original_method = "69439EE53B1C4D974D568FFBF0847B4A", hash_generated_method = "BCFD4A9D32CF5B59A9234A4ACD6AABC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeOnEnded(int nativePointer) {
        dsTaint.addTaint(nativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.358 -0400", hash_original_method = "A4A54DE61D62E407521E72B4C5FDD860", hash_generated_method = "297804A260C5F105513856473DED0C9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeOnPaused(int nativePointer) {
        dsTaint.addTaint(nativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.359 -0400", hash_original_method = "84652220F84E924B202B7575A6B0DB08", hash_generated_method = "B3D9B4741D21E3577D351D395B728D78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeOnPosterFetched(Bitmap poster, int nativePointer) {
        dsTaint.addTaint(poster.dsTaint);
        dsTaint.addTaint(nativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.359 -0400", hash_original_method = "40EE80299CDDB294EE4D171341428EFD", hash_generated_method = "8837867CC0FE9951D8C4C8FDBE52C022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeOnTimeupdate(int position, int nativePointer) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(nativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.359 -0400", hash_original_method = "73782D526ACC6162F582FA042F7A8C14", hash_generated_method = "139DCB63A74AC33581AE167CAE691E70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nativeOnStopFullscreen(int nativePointer) {
        dsTaint.addTaint(nativePointer);
    }

    
        private static boolean nativeSendSurfaceTexture(SurfaceTexture texture,
            int baseLayer, int videoLayerId, int textureName,
            int playerState) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.359 -0400", hash_original_method = "F17ABD2D26205A567E8F07C068E86E0A", hash_generated_method = "6A7146DFD42943C54F1F7A8413501A69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mp.dsTaint);
        dsTaint.addTaint(what);
        dsTaint.addTaint(extra);
        {
            sendMessage(obtainMessage(BUFFERING_START, what, extra));
        } //End block
        {
            sendMessage(obtainMessage(BUFFERING_END, what, extra));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
            //sendMessage(obtainMessage(BUFFERING_START, what, extra));
        //} else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
            //sendMessage(obtainMessage(BUFFERING_END, what, extra));
        //}
        //return false;
    }

    
    private static final class VideoPlayer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.359 -0400", hash_original_method = "EA09E83FB1CA4E7869ADB9EF55F704B2", hash_generated_method = "EA09E83FB1CA4E7869ADB9EF55F704B2")
                public VideoPlayer ()
        {
        }


                private static void setPlayerBuffering(boolean playerBuffering) {
            mHTML5VideoView.setPlayerBuffering(playerBuffering);
        }

        
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

        
                public static boolean isPlaying(HTML5VideoViewProxy proxy) {
            return (mCurrentProxy == proxy && mHTML5VideoView != null
                    && mHTML5VideoView.isPlaying());
        }

        
                public static int getCurrentPosition() {
            int currentPosMs = 0;
            if (mHTML5VideoView != null) {
                currentPosMs = mHTML5VideoView.getCurrentPosition();
            }
            return currentPosMs;
        }

        
                public static void seek(int time, HTML5VideoViewProxy proxy) {
            if (mCurrentProxy == proxy && time >= 0 && mHTML5VideoView != null) {
                mHTML5VideoView.seekTo(time);
            }
        }

        
                public static void pause(HTML5VideoViewProxy proxy) {
            if (mCurrentProxy == proxy && mHTML5VideoView != null) {
                mHTML5VideoView.pause();
            }
        }

        
                public static void onPrepared() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if (!mHTML5VideoView.isFullScreenMode() || mHTML5VideoView.getAutostart()) {
                mHTML5VideoView.start();
            }
            if (mBaseLayer != 0) {
                setBaseLayer(mBaseLayer);
            }
        }

        
                public static void end() {
            if (mCurrentProxy != null) {
                if (isVideoSelfEnded)
                    mCurrentProxy.dispatchOnEnded();
                else
                    mCurrentProxy.dispatchOnPaused();
            }
            isVideoSelfEnded = false;
        }

        
        private static HTML5VideoViewProxy mCurrentProxy;
        private static HTML5VideoView mHTML5VideoView;
        private static boolean isVideoSelfEnded = false;
        private static int mBaseLayer = 0;
    }


    
    private static final class PosterDownloader implements EventHandler {
        private URL mUrl;
        private HTML5VideoViewProxy mProxy;
        private ByteArrayOutputStream mPosterBytes;
        private RequestHandle mRequestHandle;
        private int mStatusCode;
        private Headers mHeaders;
        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.361 -0400", hash_original_method = "9561F290D28095FEEC4780B73D7797B0", hash_generated_method = "277EAD1AB36F24B41CCA526EB0806A3C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PosterDownloader(String url, HTML5VideoViewProxy proxy) {
            dsTaint.addTaint(proxy.dsTaint);
            dsTaint.addTaint(url);
            try 
            {
                mUrl = new URL(url);
            } //End block
            catch (MalformedURLException e)
            {
                mUrl = null;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.362 -0400", hash_original_method = "CC810E3C0FAB270632EED4A599C0CF83", hash_generated_method = "D18ED9C03B025C4F0F101F60C90D14C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void start() {
            retainQueue();
            String protocol;
            protocol = mUrl.getProtocol();
            {
                boolean var9BA6E91288E25B566A4C9DD07AC65D8B_1572642333 = ("http".equals(protocol) || "https".equals(protocol));
                {
                    mRequestHandle = mRequestQueue.queueRequest(mUrl.toString(), "GET", null,
                        this, null, 0);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.362 -0400", hash_original_method = "8F7C386AF7191A4B819017852DB14B13", hash_generated_method = "58A1947F8D5AFC8F40A04CAEFB4AA722")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void cancelAndReleaseQueue() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.362 -0400", hash_original_method = "3D0957D11B46ABCB01980155EE173252", hash_generated_method = "B647B792E290F72F609B1BD503844328")
        @DSModeled(DSC.SAFE)
        public void status(int major_version,
                int minor_version,
                int code,
                String reason_phrase) {
            dsTaint.addTaint(minor_version);
            dsTaint.addTaint(reason_phrase);
            dsTaint.addTaint(major_version);
            dsTaint.addTaint(code);
            // ---------- Original Method ----------
            //mStatusCode = code;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.362 -0400", hash_original_method = "BF40C4FA5E162E01EBED02AABC1482F3", hash_generated_method = "D8AD5F5A4C901B4C6AE14734E37C6518")
        @DSModeled(DSC.SAFE)
        public void headers(Headers headers) {
            dsTaint.addTaint(headers.dsTaint);
            // ---------- Original Method ----------
            //mHeaders = headers;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.363 -0400", hash_original_method = "859FCB672305C2E845A33390ED99DE51", hash_generated_method = "63E24CFE8C6D095DB5551D6C431D13BB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void data(byte[] data, int len) {
            dsTaint.addTaint(data[0]);
            dsTaint.addTaint(len);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.363 -0400", hash_original_method = "338E5BF0BBF2101BF0B2221F763D6960", hash_generated_method = "76F3A1301B08C0D9DF49D4915B8DCBBA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void endData() {
            {
                {
                    boolean var1D86D4881D55DB6F1EEACDECF9B5F3D6_1563186085 = (mPosterBytes.size() > 0);
                    {
                        Bitmap poster;
                        poster = BitmapFactory.decodeByteArray(
                            mPosterBytes.toByteArray(), 0, mPosterBytes.size());
                        mProxy.doSetPoster(poster);
                    } //End block
                } //End collapsed parenthetic
                cleanup();
            } //End block
            {
                try 
                {
                    mUrl = new URL(mHeaders.getLocation());
                } //End block
                catch (MalformedURLException e)
                {
                    mUrl = null;
                } //End block
                {
                    mHandler.post(new Runnable() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.363 -0400", hash_original_method = "92B9FBCB479F24310DB8CA88B9363005", hash_generated_method = "4A4AEE36678852CC5C424FF536C502D0")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public void run() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.363 -0400", hash_original_method = "1CF1F157C74C81DF70E7D72EFED2A778", hash_generated_method = "04C1CD61F2D93321F0A0912010517956")
        @DSModeled(DSC.SAFE)
        public void certificate(SslCertificate certificate) {
            dsTaint.addTaint(certificate.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.364 -0400", hash_original_method = "6EDF05BF0C2DDE3A327FD5313CE1B221", hash_generated_method = "9BE2804F963E66FCDB9809D70249B21A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void error(int id, String description) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(description);
            cleanup();
            // ---------- Original Method ----------
            //cleanup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.364 -0400", hash_original_method = "4CC585D4993857C36C3ADB32AB66A34A", hash_generated_method = "E374D940C5EA914C5568215EA778F9B5")
        @DSModeled(DSC.SAFE)
        public boolean handleSslErrorRequest(SslError error) {
            dsTaint.addTaint(error.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.364 -0400", hash_original_method = "1FB179217FC31AC7E38E0A4A1EABBB3F", hash_generated_method = "F4FADDC4049994D9CBBB93C2948EFD73")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void cleanup() {
            {
                try 
                {
                    mPosterBytes.close();
                } //End block
                catch (IOException ignored)
                { }
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.364 -0400", hash_original_method = "AF9CEA251B70F416DD7268C7CEF45292", hash_generated_method = "D57A3B4053BF0CC77D99642113419936")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void retainQueue() {
            {
                mRequestQueue = new RequestQueue(mProxy.getContext());
            } //End block
            // ---------- Original Method ----------
            //if (mRequestQueue == null) {
                //mRequestQueue = new RequestQueue(mProxy.getContext());
            //}
            //mQueueRefCount++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.364 -0400", hash_original_method = "AF9D604E006D921DB2DDEF5C99CED27E", hash_generated_method = "F230447B3A1FCBC85F643B82258EC694")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void releaseQueue() {
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

        
        private static RequestQueue mRequestQueue;
        private static int mQueueRefCount = 0;
    }


    
    private static final String LOGTAG = "HTML5VideoViewProxy";
    private static final int PLAY                = 100;
    private static final int SEEK                = 101;
    private static final int PAUSE               = 102;
    private static final int ERROR               = 103;
    private static final int LOAD_DEFAULT_POSTER = 104;
    private static final int BUFFERING_START     = 105;
    private static final int BUFFERING_END       = 106;
    private static final int PREPARED          = 200;
    private static final int ENDED             = 201;
    private static final int POSTER_FETCHED    = 202;
    private static final int PAUSED            = 203;
    private static final int STOPFULLSCREEN    = 204;
    private static final int TIMEUPDATE = 300;
}

