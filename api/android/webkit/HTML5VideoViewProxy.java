package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import droidsafe.helpers.DSUtils;

class HTML5VideoViewProxy extends Handler implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, SurfaceTexture.OnFrameAvailableListener {

    /**
     * The factory for HTML5VideoViewProxy instances.
     * @param webViewCore is the WebViewCore that is requesting the proxy.
     *
     * @return a new HTML5VideoViewProxy object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.402 -0500", hash_original_method = "A93731AE57D38F7B58F3F9EAB6B2C9A4", hash_generated_method = "E0253EA0479000DA7A7C30C3A414164B")
    
public static HTML5VideoViewProxy getInstance(WebViewCore webViewCore, int nativePtr) {
        return new HTML5VideoViewProxy(webViewCore.getWebView(), nativePtr);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeSendSurfaceTexture(SurfaceTexture texture,
            int baseLayer, int videoLayerId, int textureName,
            int playerState) {
        /*
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661271996 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661271996;
        */
        return 1 == (texture.getTaintInt() + baseLayer + videoLayerId +
                              textureName + playerState);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.196 -0500", hash_original_field = "E6AD586BAB234E94D45CE40212A71595", hash_generated_field = "49647B825D8BF64F7018D2D660AE2DD2")

    private static final String LOGTAG = "HTML5VideoViewProxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.198 -0500", hash_original_field = "0EF950F3F88EC256C897071AE4C398E5", hash_generated_field = "1A2E0BA6D922573100C47A11D967D412")

    private static final int PLAY                = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.200 -0500", hash_original_field = "FAA7CC294CD7875B0EE26E67FB211151", hash_generated_field = "F297D6EA66381DCD9F653B06169C148E")

    private static final int SEEK                = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.203 -0500", hash_original_field = "B1E02091FDABACDC73B63677E1F7B9F9", hash_generated_field = "92479A5B7CC3EBB08F6379E0A36FD263")

    private static final int PAUSE               = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.205 -0500", hash_original_field = "152513232D5FA24AF683E8F07F8DCA43", hash_generated_field = "FA5A5C59B608D4732861F55B1ED507AE")

    private static final int ERROR               = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.208 -0500", hash_original_field = "CFDCE34A8B1E7F3276251A1D07CABF60", hash_generated_field = "17423F4DA5C0885D4AE045DAC00FE0BD")

    private static final int LOAD_DEFAULT_POSTER = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.210 -0500", hash_original_field = "09B70F41A27CC7933286187FFDDF70E1", hash_generated_field = "CB858799F6E9BC8B0A67FBAC7E6CCABE")

    private static final int BUFFERING_START     = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.212 -0500", hash_original_field = "36A55D80992808D122EE34843C1B0EBA", hash_generated_field = "A2021E991942F90193594238D7EA38B3")

    private static final int BUFFERING_END       = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.215 -0500", hash_original_field = "6A1A935FD1A58AA8EA7F15CA81A86F40", hash_generated_field = "6FCD07752AAE7347A325132AEFCA6FAD")

    private static final int PREPARED          = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.217 -0500", hash_original_field = "6CEC60843E01437DCFC70E0575832735", hash_generated_field = "C3981D973342E27F2E6D4AC02D37EBE6")

    private static final int ENDED             = 201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.220 -0500", hash_original_field = "9AE463EB8483F0BCF2472BB194A3EE18", hash_generated_field = "3F063A1EF6E86BC17D1ADF423756387F")

    private static final int POSTER_FETCHED    = 202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.223 -0500", hash_original_field = "59E17B08BCB74571566DEA2C1B4EBE94", hash_generated_field = "F43659D42379C6E89435A6E22F31EA13")

    private static final int PAUSED            = 203;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.225 -0500", hash_original_field = "FEFED9FD8435728DBEB548EE7C600FC3", hash_generated_field = "9E94C7895AB3FAFCEA7EA4B9DAF117C1")

    private static final int STOPFULLSCREEN    = 204;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.227 -0500", hash_original_field = "96B4E5CCD9D244D86F6EB943D3C167E2", hash_generated_field = "D1EE50147F28681C567966EC0EF27CE7")

    private static final int TIMEUPDATE = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.229 -0500", hash_original_field = "096C00240C7DFE3D6E6EF8AC52FEEDCF", hash_generated_field = "096C00240C7DFE3D6E6EF8AC52FEEDCF")

    int mNativePointer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.231 -0500", hash_original_field = "252228790D84386FDEB3B82B54CC8420", hash_generated_field = "A9DBEFFFAA0F3783D1A7F1847C2580D0")

    private Handler mWebCoreHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.234 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.236 -0500", hash_original_field = "254B44153389B8C0802BF84ED70DB4B6", hash_generated_field = "C2E76D58762D0AA62A0DC6321FB34930")

    // This ref prevents the bitmap from being GC'ed.
    private Bitmap mPoster;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.238 -0500", hash_original_field = "18255F394E653D71AAB97B1F9207A70E", hash_generated_field = "A0257D682812DF18D1B88A5B56CE9BEA")

    private PosterDownloader mPosterDownloader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.240 -0500", hash_original_field = "F4C2507EAB08A3FF37764B8DB0B53E28", hash_generated_field = "698EBF6EB7B1DAA0F058A8EBFD2392EB")

    private int mSeekPosition;

    /**
     * Private constructor.
     * @param webView is the WebView that hosts the video.
     * @param nativePtr is the C++ pointer to the MediaPlayerPrivate object.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.369 -0500", hash_original_method = "3F3B5BEC7CE790314D5D416DECF5ACFD", hash_generated_method = "7C6CB4284404AF6DA1812629649587DD")
    
private HTML5VideoViewProxy(WebView webView, int nativePtr) {
        // This handler is for the main (UI) thread.
        super(Looper.getMainLooper());
        // Save the WebView object.
        mWebView = webView;
        // Pass Proxy into webview, such that every time we have a setBaseLayer
        // call, we tell this Proxy to call the native to update the layer tree
        // for the Video Layer's surface texture info
        mWebView.setHTML5VideoViewProxy(this);
        // Save the native ptr
        mNativePointer = nativePtr;
        // create the message handler for this thread
        createWebCoreHandler();
    }

    // A bunch event listeners for our VideoView
    // MediaPlayer.OnPreparedListener
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.286 -0500", hash_original_method = "CDB2DD287D3DEEC004B192544DE39644", hash_generated_method = "3D38B6910450B1E26B8136079DEAD9F4")
    
public void onPrepared(MediaPlayer mp) {
        VideoPlayer.onPrepared();
        Message msg = Message.obtain(mWebCoreHandler, PREPARED);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dur", new Integer(mp.getDuration()));
        map.put("width", new Integer(mp.getVideoWidth()));
        map.put("height", new Integer(mp.getVideoHeight()));
        msg.obj = map;
        mWebCoreHandler.sendMessage(msg);
    }

    // MediaPlayer.OnCompletionListener;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.288 -0500", hash_original_method = "82FFD8A4379253187C5EBB8D52946D71", hash_generated_method = "0A2198DCE6EA43C005883E23BEC58275")
    
public void onCompletion(MediaPlayer mp) {
        // The video ended by itself, so we need to
        // send a message to the UI thread to dismiss
        // the video view and to return to the WebView.
        // arg1 == 1 means the video ends by itself.
        sendMessage(obtainMessage(ENDED, 1, 0));
    }

    // MediaPlayer.OnErrorListener
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.291 -0500", hash_original_method = "655E6549044B32921535D006F146EAB8", hash_generated_method = "E264AF9B8CBD1F57A28C8FA69DFA20AC")
    
public boolean onError(MediaPlayer mp, int what, int extra) {
        sendMessage(obtainMessage(ERROR));
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.293 -0500", hash_original_method = "62621EBDF8B0A4EDB36AB4D032595D91", hash_generated_method = "E9E363F7AE7180457700A246D12DE21E")
    
public void dispatchOnEnded() {
        Message msg = Message.obtain(mWebCoreHandler, ENDED);
        mWebCoreHandler.sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.296 -0500", hash_original_method = "94DCE2F6FC10D862635A4D190DE0DC1E", hash_generated_method = "9950216CDA6431F3E4C12F69EEA21901")
    
public void dispatchOnPaused() {
        Message msg = Message.obtain(mWebCoreHandler, PAUSED);
        mWebCoreHandler.sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.298 -0500", hash_original_method = "550ED954EF76D5F12E77A6BAA299B5BF", hash_generated_method = "7561B4606FB7569A2DF89ED35F96BB9C")
    
public void dispatchOnStopFullScreen() {
        Message msg = Message.obtain(mWebCoreHandler, STOPFULLSCREEN);
        mWebCoreHandler.sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.300 -0500", hash_original_method = "C11D465DE26E4E34CC2ED3EA3C5CA265", hash_generated_method = "8EEB6FEA944CC2C06959D5C29BF3F3AD")
    
public void onTimeupdate() {
        sendMessage(obtainMessage(TIMEUPDATE));
    }

    // When there is a frame ready from surface texture, we should tell WebView
    // to refresh.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.302 -0500", hash_original_method = "BC25893B84FEC7EF5FFFF0FB0B5B6C05", hash_generated_method = "515AEFF23A3A863BE680B1AB0E16A556")
    
@Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        // TODO: This should support partial invalidation too.
        mWebView.invalidate();
    }

    // Handler for the messages from WebCore or Timer thread to the UI thread.
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.305 -0500", hash_original_method = "A79112D38F42B48A9F0E0FABCCDF1611", hash_generated_method = "16B25690385F2FE90C1EFDAD316B756A")
    
@Override
    public void handleMessage(Message msg) {
        // This executes on the UI thread.
        switch (msg.what) {
            case PLAY: {
                String url = (String) msg.obj;
                WebChromeClient client = mWebView.getWebChromeClient();
                int videoLayerID = msg.arg1;
                if (client != null) {
                    VideoPlayer.play(url, mSeekPosition, this, client, videoLayerID);
                }
                break;
            }
            case SEEK: {
                Integer time = (Integer) msg.obj;
                mSeekPosition = time;
                VideoPlayer.seek(mSeekPosition, this);
                break;
            }
            case PAUSE: {
                VideoPlayer.pause(this);
                break;
            }
            case ENDED:
                if (msg.arg1 == 1)
                    VideoPlayer.isVideoSelfEnded = true;
                VideoPlayer.end();
                break;
            case ERROR: {
                WebChromeClient client = mWebView.getWebChromeClient();
                if (client != null) {
                    client.onHideCustomView();
                }
                break;
            }
            case LOAD_DEFAULT_POSTER: {
                WebChromeClient client = mWebView.getWebChromeClient();
                if (client != null) {
                    doSetPoster(client.getDefaultVideoPoster());
                }
                break;
            }
            case TIMEUPDATE: {
                if (VideoPlayer.isPlaying(this)) {
                    sendTimeupdate();
                }
                break;
            }
            case BUFFERING_START: {
                VideoPlayer.setPlayerBuffering(true);
                break;
            }
            case BUFFERING_END: {
                VideoPlayer.setPlayerBuffering(false);
                break;
            }
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.389 -0400", hash_original_method = "1A016E6492F3E166AEDA862A5517C526", hash_generated_method = "33018A9ACDFEDC13B4E98D7147E35B5E")
    private void createWebCoreHandler() {
        mWebCoreHandler = new Handler() {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.373 -0500", hash_original_method = "B10F0183A0FABB1F34A9FD1B81A4AF54", hash_generated_method = "9F8C2EA302CAC5662012999657AF4032")
            
@Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case PREPARED: {
                        Map<String, Object> map = (Map<String, Object>) msg.obj;
                        Integer duration = (Integer) map.get("dur");
                        Integer width = (Integer) map.get("width");
                        Integer height = (Integer) map.get("height");
                        nativeOnPrepared(duration.intValue(), width.intValue(),
                                height.intValue(), mNativePointer);
                        break;
                    }
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
            }
};
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.378 -0500", hash_original_method = "76142FB417205DB77C8AC002D1DDBF45", hash_generated_method = "E35C68CC02047118323E86A2DFC8DC13")
    
private void doSetPoster(Bitmap poster) {
        if (poster == null) {
            return;
        }
        // Save a ref to the bitmap and send it over to the WebCore thread.
        mPoster = poster;
        Message msg = Message.obtain(mWebCoreHandler, POSTER_FETCHED);
        msg.obj = poster;
        mWebCoreHandler.sendMessage(msg);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.380 -0500", hash_original_method = "16EE14075D106C858D6DFA77C5B90D85", hash_generated_method = "218E0716F6D8C845B6B80057F56B1B64")
    
private void sendTimeupdate() {
        Message msg = Message.obtain(mWebCoreHandler, TIMEUPDATE);
        msg.arg1 = VideoPlayer.getCurrentPosition();
        mWebCoreHandler.sendMessage(msg);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.382 -0500", hash_original_method = "87AB58F6C80364970DB0BE0C32B4800B", hash_generated_method = "D1B10AE60E10911944870A6A2EA17821")
    
public Context getContext() {
        return mWebView.getContext();
    }

    // The public methods below are all called from WebKit only.
    /**
     * Play a video stream.
     * @param url is the URL of the video stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.384 -0500", hash_original_method = "93A8BD8C1053222363E314544DFAB05A", hash_generated_method = "85266787FA8D5402139CE7ABC9162878")
    
public void play(String url, int position, int videoLayerID) {
        if (url == null) {
            return;
        }

        if (position > 0) {
            seek(position);
        }
        Message message = obtainMessage(PLAY);
        message.arg1 = videoLayerID;
        message.obj = url;
        sendMessage(message);
    }

    /**
     * Seek into the video stream.
     * @param  time is the position in the video stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.387 -0500", hash_original_method = "5C4141091F743804B15461232C997D85", hash_generated_method = "0C5AED9817D2E54DE57533E1B3D2B8A4")
    
public void seek(int time) {
        Message message = obtainMessage(SEEK);
        message.obj = new Integer(time);
        sendMessage(message);
    }
    
    private static final class VideoPlayer {

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.253 -0500", hash_original_method = "2C97FA1745D17B93B94376FB01C85A2A", hash_generated_method = "6DA8CF7CD9F055C10800A4AB57037C28")
        
private static void setPlayerBuffering(boolean playerBuffering) {
            mHTML5VideoView.setPlayerBuffering(playerBuffering);
        }

        // Every time webView setBaseLayer, this will be called.
        // When we found the Video layer, then we set the Surface Texture to it.
        // Otherwise, we may want to delete the Surface Texture to save memory.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.256 -0500", hash_original_method = "B13AD79F750251E0A6091A20D137BF05", hash_generated_method = "AE3756AA04BA9F35FAC95A23C79114DF")
        
public static void setBaseLayer(int layer) {
            // Don't do this for full screen mode.
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

        // When a WebView is paused, we also want to pause the video in it.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.259 -0500", hash_original_method = "40C0695848AE7282503CA7866EE57E29", hash_generated_method = "6DC55EB725AF1AC0E8ED9E41EFDBD26E")
        
public static void pauseAndDispatch() {
            if (mHTML5VideoView != null) {
                mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                // When switching out, clean the video content on the old page
                // by telling the layer not readyToUseSurfTex.
                setBaseLayer(mBaseLayer);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.262 -0500", hash_original_method = "BE031CA7A3F4FA8EEF4A43996AC53C29", hash_generated_method = "A963407A651D6BDAAB39BB19734058FF")
        
public static void enterFullScreenVideo(int layerId, String url,
                HTML5VideoViewProxy proxy, WebView webView) {
                // Save the inline video info and inherit it in the full screen
                int savePosition = 0;
                boolean savedIsPlaying = false;
                if (mHTML5VideoView != null) {
                    // If we are playing the same video, then it is better to
                    // save the current position.
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

        // This is on the UI thread.
        // When native tell Java to play, we need to check whether or not it is
        // still the same video by using videoLayerId and treat it differently.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.265 -0500", hash_original_method = "6105FC23B73D1D5448A03FBA630F485E", hash_generated_method = "9C19545C30A84C3F55D59B31A8E1F290")
        
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
                // Here, we handle the case when switching to a new video,
                // either inside a WebView or across WebViews
                // For switching videos within a WebView or across the WebView,
                // we need to pause the old one and re-create a new media player
                // inside the HTML5VideoView.
                if (mHTML5VideoView != null) {
                    if (!backFromFullScreenMode) {
                        mHTML5VideoView.pauseAndDispatch(mCurrentProxy);
                    }
                    // release the media player to avoid finalize error
                    mHTML5VideoView.release();
                }
                mCurrentProxy = proxy;
                mHTML5VideoView = new HTML5VideoInline(videoLayerId, time, false);

                mHTML5VideoView.setVideoURI(url, mCurrentProxy);
                mHTML5VideoView.prepareDataAndDisplayMode(proxy);
            } else if (mCurrentProxy == proxy) {
                // Here, we handle the case when we keep playing with one video
                if (!mHTML5VideoView.isPlaying()) {
                    mHTML5VideoView.seekTo(time);
                    mHTML5VideoView.start();
                }
            } else if (mCurrentProxy != null) {
                // Some other video is already playing. Notify the caller that
                // its playback ended.
                proxy.dispatchOnEnded();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.268 -0500", hash_original_method = "08113A81906CB1F5AABEF145316B56BE", hash_generated_method = "35AF77E84CCB6A3FDF78AF84A02BD76C")
        
public static boolean isPlaying(HTML5VideoViewProxy proxy) {
            return (mCurrentProxy == proxy && mHTML5VideoView != null
                    && mHTML5VideoView.isPlaying());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.270 -0500", hash_original_method = "AE2CAC38FCF3DD992C6E5E183B85C04A", hash_generated_method = "375CD11F1BBDA4CC63593597ED14F860")
        
public static int getCurrentPosition() {
            int currentPosMs = 0;
            if (mHTML5VideoView != null) {
                currentPosMs = mHTML5VideoView.getCurrentPosition();
            }
            return currentPosMs;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.273 -0500", hash_original_method = "9BEA8AFADD24C927CEA42DFBBB0D2097", hash_generated_method = "BBA1B92EA542939961ADB2FE0500F033")
        
public static void seek(int time, HTML5VideoViewProxy proxy) {
            if (mCurrentProxy == proxy && time >= 0 && mHTML5VideoView != null) {
                mHTML5VideoView.seekTo(time);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.275 -0500", hash_original_method = "CD7036CAC1C347547F0A8AB2CA882C8A", hash_generated_method = "8B3B5E9051625D53FE7DECA5EA7BAC34")
        
public static void pause(HTML5VideoViewProxy proxy) {
            if (mCurrentProxy == proxy && mHTML5VideoView != null) {
                mHTML5VideoView.pause();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.278 -0500", hash_original_method = "DCC69BE37C38B8F71BBDDDB0F0F6FBFF", hash_generated_method = "F3946FA812385E1895CAD339D44374CB")
        
public static void onPrepared() {
            if (!mHTML5VideoView.isFullScreenMode() || mHTML5VideoView.getAutostart()) {
                mHTML5VideoView.start();
            }
            if (mBaseLayer != 0) {
                setBaseLayer(mBaseLayer);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.280 -0500", hash_original_method = "AABB2E884F5620C5400BECF76F06B0C6", hash_generated_method = "8F6AC272961314788FDA378B3EFB477A")
        
public static void end() {
            if (mCurrentProxy != null) {
                if (isVideoSelfEnded)
                    mCurrentProxy.dispatchOnEnded();
                else
                    mCurrentProxy.dispatchOnPaused();
            }
            isVideoSelfEnded = false;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.243 -0500", hash_original_field = "20B6A372E04A0F77E4CBFCE6058249AB", hash_generated_field = "4A3E3DA54FD2CE87A72A4D6B0E116413")

        private static HTML5VideoViewProxy mCurrentProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.245 -0500", hash_original_field = "BE431E5B0A4A961FAB022840EC1B3622", hash_generated_field = "02E0421ADB288132C9F4E5C8140A83DC")

        // http://b/issue?id=1973663 is fixed.
        private static HTML5VideoView mHTML5VideoView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.247 -0500", hash_original_field = "10716476251DD9CC249B86E6E7FD5AFC", hash_generated_field = "03E3F53D98F1C739148B69AE13616028")

        private static boolean isVideoSelfEnded = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.250 -0500", hash_original_field = "763799EB76D7DBFE0E78A50783744C41", hash_generated_field = "AA2AF51E33F0D08BE6D10B0A95002DAF")

        // identify the exact layer on the UI thread to use the SurfaceTexture.
        private static int mBaseLayer = 0;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.102 -0400", hash_original_method = "9A68A6C42721A074DDF281539068301A", hash_generated_method = "9A68A6C42721A074DDF281539068301A")
        public VideoPlayer ()
        {
            //Synthesized constructor
        }
    }
    
    private static final class PosterDownloader implements EventHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.309 -0500", hash_original_field = "2CFB054BACCE225829CD65D3DF87BAA7", hash_generated_field = "381C5A0A88CF182455E810191A19243F")

        private static RequestQueue mRequestQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.311 -0500", hash_original_field = "84EC8B991BCFC83794523396A6FBC3AD", hash_generated_field = "41C6B2C8620F8E9A8462DD7D6FE26631")

        private static int mQueueRefCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.313 -0500", hash_original_field = "35AA9D7E2308BE0323C19BB28F27EC67", hash_generated_field = "89E832BB000DD0963806253C292C25BE")

        private URL mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.316 -0500", hash_original_field = "7F2DF55E3D818C21E39C6278632E199C", hash_generated_field = "701E8A5CEFF22C717E0E1190038ED0C2")

        private  HTML5VideoViewProxy mProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.318 -0500", hash_original_field = "585AC3D1B2554E8886644FF35B2B5852", hash_generated_field = "B7F423E620814CC6F793E3C8C73A8DA4")

        private ByteArrayOutputStream mPosterBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.320 -0500", hash_original_field = "60897D6FF6EC53AEFD2E3CA0FC46E4F5", hash_generated_field = "D2C086119AFB2A8257E7CAD619AFA47F")

        private RequestHandle mRequestHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.323 -0500", hash_original_field = "FDFA4F4264773014D5F97717B076C5CB", hash_generated_field = "A03B65E05BCBAEC5D04E36F3DA55AA89")

        private int mStatusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.325 -0500", hash_original_field = "9035AF409A03B14F6004C0202B58C473", hash_generated_field = "13C03042313948D47B6F87C772F0131E")

        private Headers mHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.327 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.330 -0500", hash_original_method = "9561F290D28095FEEC4780B73D7797B0", hash_generated_method = "E21A98C4E72C1718CA2BF3ACCDE8C951")
        
public PosterDownloader(String url, HTML5VideoViewProxy proxy) {
            try {
                mUrl = new URL(url);
            } catch (MalformedURLException e) {
                mUrl = null;
            }
            mProxy = proxy;
            mHandler = new Handler();
        }
        // Start the download. Called on WebCore thread.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.332 -0500", hash_original_method = "CC810E3C0FAB270632EED4A599C0CF83", hash_generated_method = "8854D630A5AEDA058D113A26DA6B3C80")
        
public void start() {
            retainQueue();

            if (mUrl == null) {
                return;
            }

            // Only support downloading posters over http/https.
            // FIXME: Add support for other schemes. WebKit seems able to load
            // posters over other schemes e.g. file://, but gets the dimensions wrong.
            String protocol = mUrl.getProtocol();
            if ("http".equals(protocol) || "https".equals(protocol)) {
                mRequestHandle = mRequestQueue.queueRequest(mUrl.toString(), "GET", null,
                        this, null, 0);
            }
        }
        // Cancel the download if active and release the queue. Called on WebCore thread.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.335 -0500", hash_original_method = "8F7C386AF7191A4B819017852DB14B13", hash_generated_method = "05430B66A164B747AD9D873A3ACAA63C")
        
public void cancelAndReleaseQueue() {
            if (mRequestHandle != null) {
                mRequestHandle.cancel();
                mRequestHandle = null;
            }
            releaseQueue();
        }
        // EventHandler methods. Executed on the network thread.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.337 -0500", hash_original_method = "3D0957D11B46ABCB01980155EE173252", hash_generated_method = "4D392F7E6BD82EA306F362B165AF12C3")
        
public void status(int major_version,
                int minor_version,
                int code,
                String reason_phrase) {
            mStatusCode = code;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.339 -0500", hash_original_method = "BF40C4FA5E162E01EBED02AABC1482F3", hash_generated_method = "5909262717E4A6902BE2B73DD0F92BE6")
        
public void headers(Headers headers) {
            mHeaders = headers;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.342 -0500", hash_original_method = "859FCB672305C2E845A33390ED99DE51", hash_generated_method = "D1988A59F45B2D875C1CE0D127A12B49")
        
public void data(byte[] data, int len) {
            if (mPosterBytes == null) {
                mPosterBytes = new ByteArrayOutputStream();
            }
            mPosterBytes.write(data, 0, len);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.348 -0500", hash_original_method = "338E5BF0BBF2101BF0B2221F763D6960", hash_generated_method = "AC6A0B832D9739C0A5E232E22DBD2358")
        
public void endData() {
            if (mStatusCode == 200) {
                if (mPosterBytes.size() > 0) {
                    Bitmap poster = BitmapFactory.decodeByteArray(
                            mPosterBytes.toByteArray(), 0, mPosterBytes.size());
                    mProxy.doSetPoster(poster);
                }
                cleanup();
            } else if (mStatusCode >= 300 && mStatusCode < 400) {
                // We have a redirect.
                try {
                    mUrl = new URL(mHeaders.getLocation());
                } catch (MalformedURLException e) {
                    mUrl = null;
                }
                if (mUrl != null) {
                    mHandler.post(new Runnable() {
                       @DSSafe(DSCat.SAFE_LIST)
            public void run() {
                           if (mRequestHandle != null) {
                               mRequestHandle.setupRedirect(mUrl.toString(), mStatusCode,
                                       new HashMap<String, String>());
                           }
                       }
                    });
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.351 -0500", hash_original_method = "1CF1F157C74C81DF70E7D72EFED2A778", hash_generated_method = "7220393EB8B7131C3B5FF5D47C492C74")
        
public void certificate(SslCertificate certificate) {
            // Don't care.
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.353 -0500", hash_original_method = "6EDF05BF0C2DDE3A327FD5313CE1B221", hash_generated_method = "6DA7901708108DD3E2A8653BB60AA484")
        
public void error(int id, String description) {
            cleanup();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.356 -0500", hash_original_method = "4CC585D4993857C36C3ADB32AB66A34A", hash_generated_method = "B6409A8CA44258F5D4C3F84A9B71653B")
        
public boolean handleSslErrorRequest(SslError error) {
            // Don't care. If this happens, data() will never be called so
            // mPosterBytes will never be created, so no need to call cleanup.
            return false;
        }
        // Tears down the poster bytes stream. Called on network thread.
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.358 -0500", hash_original_method = "1FB179217FC31AC7E38E0A4A1EABBB3F", hash_generated_method = "2A18B39EBB4788FD1F28A4B30FECF306")
        
private void cleanup() {
            if (mPosterBytes != null) {
                try {
                    mPosterBytes.close();
                } catch (IOException ignored) {
                    // Ignored.
                } finally {
                    mPosterBytes = null;
                }
            }
        }

        // Queue management methods. Called on WebCore thread.
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.360 -0500", hash_original_method = "AF9CEA251B70F416DD7268C7CEF45292", hash_generated_method = "5CEF3DFDDF3EA2E0252FB35BB0336921")
        
private void retainQueue() {
            if (mRequestQueue == null) {
                mRequestQueue = new RequestQueue(mProxy.getContext());
            }
            mQueueRefCount++;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.363 -0500", hash_original_method = "AF9D604E006D921DB2DDEF5C99CED27E", hash_generated_method = "E1FA1A21BA9BB187A183AD453404B2FD")
        
private void releaseQueue() {
            if (mQueueRefCount == 0) {
                return;
            }
            if (--mQueueRefCount == 0) {
                mRequestQueue.shutdown();
                mRequestQueue = null;
            }
        }
    }

    /**
     * Pause the playback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.389 -0500", hash_original_method = "46912449E5F27493E09DC38DC6351C19", hash_generated_method = "CFB408F833CE2D2822C56458E6C46C9A")
    
public void pause() {
        Message message = obtainMessage(PAUSE);
        sendMessage(message);
    }

    /**
     * Tear down this proxy object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.391 -0500", hash_original_method = "9E02A818380AAE8C95423CA4DF6BB0F2", hash_generated_method = "BFBA7D2C1A20185D7C22E0B60CEDB86A")
    
public void teardown() {
        // This is called by the C++ MediaPlayerPrivate dtor.
        // Cancel any active poster download.
        if (mPosterDownloader != null) {
            mPosterDownloader.cancelAndReleaseQueue();
        }
        mNativePointer = 0;
    }

    /**
     * Load the poster image.
     * @param url is the URL of the poster image.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.393 -0500", hash_original_method = "F3233AD918CF97E4872803E9BFDDE6E6", hash_generated_method = "7BABBE41588CBA97ACA235C2C2414F90")
    
public void loadPoster(String url) {
        if (url == null) {
            Message message = obtainMessage(LOAD_DEFAULT_POSTER);
            sendMessage(message);
            return;
        }
        // Cancel any active poster download.
        if (mPosterDownloader != null) {
            mPosterDownloader.cancelAndReleaseQueue();
        }
        // Load the poster asynchronously
        mPosterDownloader = new PosterDownloader(url, this);
        mPosterDownloader.start();
    }

    // These three function are called from UI thread only by WebView.
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.396 -0500", hash_original_method = "6B4B481A9DF2B25B735CB7B52B3C6386", hash_generated_method = "D63A1B66E7826EC9A738812D459F59CC")
    
public void setBaseLayer(int layer) {
        VideoPlayer.setBaseLayer(layer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.398 -0500", hash_original_method = "6A592A0539FD41CAB4A89EA53CE8C509", hash_generated_method = "1C05D5D3DD31EB5A9831BDC117B7A359")
    
public void pauseAndDispatch() {
        VideoPlayer.pauseAndDispatch();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.400 -0500", hash_original_method = "096DB59D6464AC209548B8DCB36CACB7", hash_generated_method = "973586DCE07F1E52616C1C36D6A5DE7B")
    
public void enterFullScreenVideo(int layerId, String url) {
        VideoPlayer.enterFullScreenVideo(layerId, url, this, mWebView);
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.404 -0500", hash_original_method = "D61E1D458239E8CEF9B36F4B5C04FED9", hash_generated_method = "D61E1D458239E8CEF9B36F4B5C04FED9")
    
WebView getWebView() {
        return mWebView;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.408 -0500", hash_original_method = "450372CEC4ACF74D667E8FE30D4758C3", hash_generated_method = "C05D68BE24B8B8F67A680AE7FA17E932")
    
    private void nativeOnPrepared(int duration, int width, int height, int nativePointer){
    	//Formerly a native method
    	addTaint(duration);
    	addTaint(width);
    	addTaint(height);
    	addTaint(nativePointer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.411 -0500", hash_original_method = "69439EE53B1C4D974D568FFBF0847B4A", hash_generated_method = "7D202EBFFACA85F6A066CDE9078FE386")
    
    private void nativeOnEnded(int nativePointer){
    	//Formerly a native method
    	addTaint(nativePointer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.416 -0500", hash_original_method = "A4A54DE61D62E407521E72B4C5FDD860", hash_generated_method = "0643ECED1D157B3E3A40095555ECB5A9")
    
    private void nativeOnPaused(int nativePointer){
    	//Formerly a native method
    	addTaint(nativePointer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.420 -0500", hash_original_method = "84652220F84E924B202B7575A6B0DB08", hash_generated_method = "035A85A47EFF29C44B34EDE49356B86C")
    
    private void nativeOnPosterFetched(Bitmap poster, int nativePointer){
    	//Formerly a native method
    	addTaint(poster.getTaint());
    	addTaint(nativePointer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.423 -0500", hash_original_method = "40EE80299CDDB294EE4D171341428EFD", hash_generated_method = "5C4C6A7958E25050349CD1926402FD8D")
    
    private void nativeOnTimeupdate(int position, int nativePointer){
    	//Formerly a native method
    	addTaint(position);
    	addTaint(nativePointer);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.426 -0500", hash_original_method = "73782D526ACC6162F582FA042F7A8C14", hash_generated_method = "89E52BAB9BA605E3ACEF67B2E2C57EB0")
    
    private void nativeOnStopFullscreen(int nativePointer){
    	//Formerly a native method
    	addTaint(nativePointer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:58.433 -0500", hash_original_method = "F17ABD2D26205A567E8F07C068E86E0A", hash_generated_method = "A7D057398DA5B688839E23F713AF38FD")
    
@Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        if (what == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
            sendMessage(obtainMessage(BUFFERING_START, what, extra));
        } else if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
            sendMessage(obtainMessage(BUFFERING_END, what, extra));
        }
        return false;
    }
}

