package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;





public class HTML5VideoView implements MediaPlayer.OnPreparedListener {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.319 -0500", hash_original_method = "E7A7C1FACF5557FF1118289C74D9F6F1", hash_generated_method = "983388AEFCE2277E2911A4A303FA7073")
    protected static Map<String, String> generateHeaders(String url,
            HTML5VideoViewProxy proxy) {
        boolean isPrivate = proxy.getWebView().isPrivateBrowsingEnabled();
        String cookieValue = CookieManager.getInstance().getCookie(url, isPrivate);
        Map<String, String> headers = new HashMap<String, String>();
        if (cookieValue != null) {
            headers.put(COOKIE, cookieValue);
        }
        if (isPrivate) {
            headers.put(HIDE_URL_LOGS, "true");
        }

        return headers;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.293 -0500", hash_original_field = "27C2FDB1BB9B57104A1BF97BF4760D17", hash_generated_field = "F28BD250BE49F871DBD48569862C0B31")


    protected static final String LOGTAG = "HTML5VideoView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.294 -0500", hash_original_field = "7AB772E4CFA16A63CA44E093873284F9", hash_generated_field = "DA39A01DF5AB155F9CB6B9FF9001FE68")


    protected static final String COOKIE = "Cookie";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.295 -0500", hash_original_field = "29F8BB5FC2696F760DC8DD912D0A0CD5", hash_generated_field = "9881974001B645494AB5FC175DFA6D3E")

    protected static final String HIDE_URL_LOGS = "x-hide-urls-from-log";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:05.733 -0500", hash_original_field = "316F2FF1C388ECA3484F1694B55EB5CA", hash_generated_field = "6A94B6B90000A3673F8193803A29BDA9")

    // the video is prepared. Therefore, we differentiate the state between
    // prepared and not prepared.
    // When the video is not prepared, we will have to save the seekTo time,
    // and use it when prepared to play.
    // NOTE: these values are in sync with VideoLayerAndroid.h in webkit side.
    // Please keep them in sync when changed.
    static final int STATE_INITIALIZED        = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.297 -0500", hash_original_field = "E1D8AA4DC305286CE74FD143DFCAA451", hash_generated_field = "5FB03EFA27A8E29EFAB8448370D21C6E")

    static final int STATE_NOTPREPARED        = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.297 -0500", hash_original_field = "B0A3E1DC3514CB87DD4786EA7A2009BC", hash_generated_field = "ED6A5A72E4407D351D0E711B5368AB37")

    static final int STATE_PREPARED           = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.298 -0500", hash_original_field = "22F45C47A0AA05081B66E40F5D8E467E", hash_generated_field = "980EFA6A2B53D27841C185532A5FD596")

    static final int STATE_PLAYING            = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.299 -0500", hash_original_field = "651D59D4C7CFDCCE607A7D4ACC67ECCA", hash_generated_field = "7597F5A47281EA761032DDC95EFD8646")

    static final int STATE_RELEASED           = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:05.743 -0500", hash_original_field = "0530D7DA7365EAABF4E2D913BD8C5F2C", hash_generated_field = "0F5229158B2BFD876508157983810133")

    // See http://www.whatwg.org/specs/web-apps/current-work/#event-media-timeupdate
    protected static Timer mTimer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.307 -0500", hash_original_field = "64751FF4608AD695F6C4CA6F60073AE7", hash_generated_field = "803E0BB34E42CE66FDB6CAF172B04845")

    private static final int TIMEUPDATE_PERIOD = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.300 -0500", hash_original_field = "C3CD87657B7D1FF6B167B2FB7EA1B5DB", hash_generated_field = "D427CDF1FC427D67E4945D1E0E231D42")

    protected int mCurrentState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.301 -0500", hash_original_field = "7F2DF55E3D818C21E39C6278632E199C", hash_generated_field = "A9417E42DC0EBFA2CF2015D2CB329A68")


    protected HTML5VideoViewProxy mProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:05.739 -0500", hash_original_field = "DDE2675BE8BA6AA015C4C481A797132E", hash_generated_field = "8EC60FEEC043F814DAF6E2A263524B4F")

    // video besides initial load.
    protected int mSaveSeekTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.303 -0500", hash_original_field = "876F57FE990F16C9C6415908262B0A25", hash_generated_field = "0752FEDDB1622AE4DFBC1A284DB7079B")

    protected int mVideoLayerId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:05.740 -0500", hash_original_field = "5F7707D5EA4011B85B33B90A42726925", hash_generated_field = "B50DF2C6EAD5AE8A22AD091140C5594D")

    // SurfaceTexture, there is only one MediaPlayer in action. Every time we
    // switch videos, a new instance of MediaPlayer will be created in reset().
    // Switching between inline and full screen will also create a new instance.
    protected MediaPlayer mPlayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:05.741 -0500", hash_original_field = "3F6467504377843F029B4C4CEF836351", hash_generated_field = "75AF30403FAFFFE766C98BD1A1A8A385")

    // Set to true only when switching into full screen while playing
    protected boolean mAutostart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.305 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "4309285A2AF5294EC8D8A6725673F542")

    protected Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.305 -0500", hash_original_field = "A7D525FA609C0F6270055E985F097B79", hash_generated_field = "DE0CB0B3CC8CF9FE0713E37CB69C3430")

    protected Map<String, String> mHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.308 -0500", hash_original_field = "4DAFF75E9D6BA4CBDD1B91A72F208961", hash_generated_field = "4B797C0AD5CBAEABB54B83FEF8D06E8A")


    protected boolean mPauseDuringPreparing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.337 -0500", hash_original_field = "A1A1FD872AB58074E8C4CC540F226B71", hash_generated_field = "3C382F7E45E0380C589CD364462525D1")

    public boolean mPlayerBuffering = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.318 -0500", hash_original_method = "28D653DD01D92986A2B4676333E22F44", hash_generated_method = "0DDAE4F950D92719B95655EE43F24E23")
    protected HTML5VideoView() {
    }
    // common Video control FUNCTIONS:
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.309 -0500", hash_original_method = "3012844A52D4FF8D08A8750FA45AE671", hash_generated_method = "40B8A76D7595BA3EDF281F5550EBC279")
    public void start() {
        if (mCurrentState == STATE_PREPARED) {
            // When replaying the same video, there is no onPrepared call.
            // Therefore, the timer should be set up here.
            if (mTimer == null)
            {
                mTimer = new Timer();
                mTimer.schedule(new TimeupdateTask(mProxy), TIMEUPDATE_PERIOD,
                        TIMEUPDATE_PERIOD);
            }
            mPlayer.start();
            setPlayerBuffering(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.309 -0500", hash_original_method = "53F6A4797DD5828003875392A3AF17CE", hash_generated_method = "E08265121D73EF3E31C272FD6AB8DAD1")
    public void pause() {
        if (isPlaying()) {
            mPlayer.pause();
        } else if (mCurrentState == STATE_NOTPREPARED) {
            mPauseDuringPreparing = true;
        }
        // Delete the Timer to stop it since there is no stop call.
        if (mTimer != null) {
            mTimer.purge();
            mTimer.cancel();
            mTimer = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.310 -0500", hash_original_method = "439630F284E895C4A0EC26592582E769", hash_generated_method = "31B194CEA9661BDF123265EB135F9BBC")
    public int getDuration() {
        if (mCurrentState == STATE_PREPARED) {
            return mPlayer.getDuration();
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.311 -0500", hash_original_method = "5E9270330E1DC98C2EF1834461EFA6AE", hash_generated_method = "69019C8C603E48EF4B4E30A539264224")
    public int getCurrentPosition() {
        if (mCurrentState == STATE_PREPARED) {
            return mPlayer.getCurrentPosition();
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.312 -0500", hash_original_method = "29179F4E6F5DEF8BE6DF61D7C781E0A2", hash_generated_method = "8A27CA426294C0CE66B219881880B786")
    public void seekTo(int pos) {
        if (mCurrentState == STATE_PREPARED)
            mPlayer.seekTo(pos);
        else
            mSaveSeekTime = pos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.312 -0500", hash_original_method = "FFF63CE630758A2DC8461EEC2B2493E2", hash_generated_method = "26072BF1DD954DF349A09D1636AC44C2")
    public boolean isPlaying() {
        if (mCurrentState == STATE_PREPARED) {
            return mPlayer.isPlaying();
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.313 -0500", hash_original_method = "0FBE82A8FF8F42AB54B25C4455F7DE4C", hash_generated_method = "7AAE5EF7983579A91F5FA1CABE932ABC")
    public void release() {
        if (mCurrentState != STATE_RELEASED) {
            mPlayer.release();
        }
        mCurrentState = STATE_RELEASED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.314 -0500", hash_original_method = "59D4F83219BBDE4F48B39B417FC8C6D3", hash_generated_method = "C605A9F2B8BE487C8766FD9A5807346F")
    public void stopPlayback() {
        if (mCurrentState == STATE_PREPARED) {
            mPlayer.stop();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.315 -0500", hash_original_method = "FE87C901FEC48725BE9A00E5A7A6B389", hash_generated_method = "9BBFC126B369B55B424DCEC44F5CC75F")
    public boolean getAutostart() {
        return mAutostart;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.316 -0500", hash_original_method = "83FF2150FEBE6917B81E8E4D5EFDEDB8", hash_generated_method = "DD0F1269AEF34CBF589CA6EF265D115D")
    public boolean getPauseDuringPreparing() {
        return mPauseDuringPreparing;
    }

    // Every time we start a new Video, we create a VideoView and a MediaPlayer
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.317 -0500", hash_original_method = "25A3A58F4D699286035B0F84C85D6FDC", hash_generated_method = "1BCFD5FAC722720DEBAF2A69EB6E3BD8")
    public void init(int videoLayerId, int position, boolean autoStart) {
        mPlayer = new MediaPlayer();
        mCurrentState = STATE_INITIALIZED;
        mProxy = null;
        mVideoLayerId = videoLayerId;
        mSaveSeekTime = position;
        mAutostart = autoStart;
        mTimer = null;
        mPauseDuringPreparing = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.320 -0500", hash_original_method = "4A72F313DB07B237CDCFE2148C78F1A8", hash_generated_method = "460AF598562878476A547654494F7EA8")
    public void setVideoURI(String uri, HTML5VideoViewProxy proxy) {
        // When switching players, surface texture will be reused.
        mUri = Uri.parse(uri);
        mHeaders = generateHeaders(uri, proxy);
    }

    // Listeners setup FUNCTIONS:
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.321 -0500", hash_original_method = "7F2C5845AC97F9E01BF6739081098AFA", hash_generated_method = "727BB9D2244E8FE31568C787C1FA3C7C")
    public void setOnCompletionListener(HTML5VideoViewProxy proxy) {
        mPlayer.setOnCompletionListener(proxy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.322 -0500", hash_original_method = "B3DA09063B346725FC2FACD292CDBF3D", hash_generated_method = "5EA88AF68AB4E57576C6BCBFF8CB952D")
    public void setOnErrorListener(HTML5VideoViewProxy proxy) {
        mPlayer.setOnErrorListener(proxy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.322 -0500", hash_original_method = "88BA8808B84DAD90592F4339F231D5ED", hash_generated_method = "16CE62822581C1DEF024AD07E690C920")
    public void setOnPreparedListener(HTML5VideoViewProxy proxy) {
        mProxy = proxy;
        mPlayer.setOnPreparedListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.323 -0500", hash_original_method = "9B3DE5A2AE36BDD54043208A8ECFD89C", hash_generated_method = "D2E9652D6F72F48637DE178162DC35F0")
    public void setOnInfoListener(HTML5VideoViewProxy proxy) {
        mPlayer.setOnInfoListener(proxy);
    }

    // Normally called immediately after setVideoURI. But for full screen,
    // this should be after surface holder created
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.324 -0500", hash_original_method = "F9607B1B919A7A6BBECF31855FC93C59", hash_generated_method = "7CAB3DDD05A239CDF6E2734DA05A1D03")
    public void prepareDataAndDisplayMode(HTML5VideoViewProxy proxy) {
        // SurfaceTexture will be created lazily here for inline mode
        decideDisplayMode();

        setOnCompletionListener(proxy);
        setOnPreparedListener(proxy);
        setOnErrorListener(proxy);
        setOnInfoListener(proxy);
        // When there is exception, we could just bail out silently.
        // No Video will be played though. Write the stack for debug
        try {
            mPlayer.setDataSource(mProxy.getContext(), mUri, mHeaders);
            mPlayer.prepareAsync();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mCurrentState = STATE_NOTPREPARED;
    }


    // Common code
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.325 -0500", hash_original_method = "4F2E24A50F82208E59877C3E2625C348", hash_generated_method = "59CEAAB3DF0B6642DCB3E5A015706848")
    public int getVideoLayerId() {
        return mVideoLayerId;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.326 -0500", hash_original_method = "90E098B5ED1DEFDE8C60551334D6CBD4", hash_generated_method = "E94138417590464CF75C0CE756A08C7B")
    public int getCurrentState() {
        if (isPlaying()) {
            return STATE_PLAYING;
        } else {
            return mCurrentState;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.330 -0500", hash_original_method = "023FEEEA138ACC710F3FC682E3FCF8D2", hash_generated_method = "D77ABFD0BA7F324B8E3AEA49F66E50A4")
    @Override
public void onPrepared(MediaPlayer mp) {
        mCurrentState = STATE_PREPARED;
        seekTo(mSaveSeekTime);
        if (mProxy != null) {
            mProxy.onPrepared(mp);
        }
        if (mPauseDuringPreparing) {
            pauseAndDispatch(mProxy);
            mPauseDuringPreparing = false;
        }
    }

    // Pause the play and update the play/pause button
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.331 -0500", hash_original_method = "61063445AE0708B1C305C74A0C0CFD4D", hash_generated_method = "2BC0D4915283DA053AFAA6F77CCD93DD")
    public void pauseAndDispatch(HTML5VideoViewProxy proxy) {
        pause();
        if (proxy != null) {
            proxy.dispatchOnPaused();
        }
    }

    // Below are functions that are different implementation on inline and full-
    // screen mode. Some are specific to one type, but currently are called
    // directly from the proxy.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.332 -0500", hash_original_method = "9BC7893A1A30D65DD41983AD520ABA24", hash_generated_method = "4E64D53899FEDB854F6812CB4FCEC3CC")
    public void enterFullScreenVideoState(int layerId,
            HTML5VideoViewProxy proxy, WebView webView) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.332 -0500", hash_original_method = "040F96FADC077BA4992C03214586310A", hash_generated_method = "0E9D4C4DE6859B7768B1E4F1BB97D44F")
    public boolean isFullScreenMode() {
        return false;
    }

    
    private static final class TimeupdateTask extends TimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.327 -0500", hash_original_field = "7F2DF55E3D818C21E39C6278632E199C", hash_generated_field = "701E8A5CEFF22C717E0E1190038ED0C2")

        private HTML5VideoViewProxy mProxy;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.328 -0500", hash_original_method = "3C26C895A00D8A9565624E1D679282AA", hash_generated_method = "28450E7EFE5E6C31592BCF9B4CFC93A9")
        public TimeupdateTask(HTML5VideoViewProxy proxy) {
            mProxy = proxy;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.329 -0500", hash_original_method = "BCE01212467B54ADF40E3CF16EDCE71A", hash_generated_method = "9BDB3CECC549A3D525B96DC09C640576")
        @Override
public void run() {
            mProxy.onTimeupdate();
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.333 -0500", hash_original_method = "576D7BAAE83D7D96FC7F76762AF5D519", hash_generated_method = "BC9CE176105443952F7393C58BBD2D38")
    public void decideDisplayMode() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.334 -0500", hash_original_method = "C9A7CF84D371C51EADC63585245E2DF8", hash_generated_method = "A85EED1F77D2020994DEDE6CC5F6187A")
    public boolean getReadyToUseSurfTex() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.335 -0500", hash_original_method = "EB4C543379CBB61A7D197317729D4B81", hash_generated_method = "7E7D293D3502124CFE202328B06F4519")
    public SurfaceTexture getSurfaceTexture(int videoLayerId) {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.336 -0500", hash_original_method = "F878AB9D8B307F7725C7D90E69C96D89", hash_generated_method = "B53D80A30F388C560F1902A7279E8708")
    public void deleteSurfaceTexture() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.336 -0500", hash_original_method = "4BDE667A00FC91D9C95E5191E09A54C3", hash_generated_method = "5FAB636108D0BD3392863D59FF29FEAB")
    public int getTextureName() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.338 -0500", hash_original_method = "BA6BA92F877820EFB4A7324F8FF815C7", hash_generated_method = "A091967EDDAB6E8CE97607BCF97D50CC")
    public boolean getPlayerBuffering() {
        return mPlayerBuffering;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.339 -0500", hash_original_method = "90D4C50A046C8B21871A46FE1FDA531C", hash_generated_method = "12B889799F11D033820B8AB6DBA91DB8")
    public void setPlayerBuffering(boolean playerBuffering) {
        mPlayerBuffering = playerBuffering;
        switchProgressView(playerBuffering);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.340 -0500", hash_original_method = "D1649F9781058EFE73B80767CB5DBB7F", hash_generated_method = "14E1292FE683BC52C08C4EDC53BBD809")
    protected void switchProgressView(boolean playerBuffering) {
        // Only used in HTML5VideoFullScreen
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.340 -0500", hash_original_method = "620458B5B8BB9506BFC901A9D3B27999", hash_generated_method = "3C5656C8CD1FFA783C42C6660F8B1AC2")
    public boolean surfaceTextureDeleted() {
        // Only meaningful for HTML5VideoInline
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:28.341 -0500", hash_original_method = "8A279E58756D4B031794A7C12A636619", hash_generated_method = "C127A5B4891D5FF85A48FA7198E02BB3")
    public boolean fullScreenExited() {
        // Only meaningful for HTML5VideoFullScreen
        return false;
    }
}

