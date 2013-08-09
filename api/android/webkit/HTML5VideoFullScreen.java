package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.Metadata;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;





public class HTML5VideoFullScreen extends HTML5VideoView implements MediaPlayerControl, MediaPlayer.OnPreparedListener, View.OnTouchListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "577C208742D945E462EAA34C09855363", hash_generated_field = "995FA5F24A4C3D9EC1E030DE94C34639")

    private VideoSurfaceView mVideoSurfaceView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "8C9F6FC19D50AADA4959421485D997DD", hash_generated_field = "23A07B55D02F895AD551D2F26BB95165")

    private int mFullScreenMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "A57983EA22A29D716213C2400D6F1D7A", hash_generated_field = "FFE64F26EAFE41C0717BC03DFAEF93DE")

    private MediaController mMediaController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "6072A5355110211D8AD992A1E8763595", hash_generated_field = "846D019DBE1F3FC208D26AE6B51E7E7A")

    private SurfaceHolder mSurfaceHolder = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "260CDABACB2B7A4C6F8B739A9531399D", hash_generated_field = "F0F23120A5CAF86AFF0F96CAE67D6030")

    private boolean mCanSeekBack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "1042AFD5E2128CC06471C1ED59799B06", hash_generated_field = "AD1D51CB83FA72C2D49574CD80EEB438")

    private boolean mCanSeekForward;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "9A4623B61542BEC8D3E426C93DD77346", hash_generated_field = "F1E27FDEF752AF3B6AFE206F5E8D273F")

    private boolean mCanPause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "1873B2B1AC18422B33460DFB5D5CB345", hash_generated_field = "DE5AC282D1679F4F6686171A7EFF5F7A")

    private int mCurrentBufferPercentage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "ECDB7D63CE89453B0D96E6DC96178AAB", hash_generated_field = "1681CCE3F2816C80096F4BC1589307A6")

    private int mVideoWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.899 -0400", hash_original_field = "BF03935A9A0E39D0F45DBB78BE93B589", hash_generated_field = "4EA21094A26D2FB68A0C1EF72DA153C9")

    private int mVideoHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.785 -0400", hash_original_field = "1FB69BD30A94387173B150B37758527C", hash_generated_field = "C179BAE9DE0AFC3D1C34EC4DFE285114")

    SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.785 -0400", hash_original_method = "3F198B15E26BAFE43EE75044605DFD16", hash_generated_method = "3D802BD1DDECA265426C324D9430E94A")
        public void surfaceChanged(SurfaceHolder holder, int format,
                                    int w, int h) {
            {
                {
                    boolean var897EB098F08F185648904C85595F1D42_145119680 = (mMediaController.isShowing());
                    {
                        mMediaController.hide();
                    } 
                } 
                mMediaController.show();
            } 
            addTaint(holder.getTaint());
            addTaint(format);
            addTaint(w);
            addTaint(h);
            
            
                    
                
                    
                
                
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.785 -0400", hash_original_method = "94E02A68EADA9CB33F96FB8AB670115A", hash_generated_method = "1E0535E0C877A1119FDCC584F158C234")
        public void surfaceCreated(SurfaceHolder holder) {
            mSurfaceHolder = holder;
            mFullScreenMode = FULLSCREEN_SURFACECREATED;
            prepareForFullScreen();
            addTaint(holder.getTaint());
            
            
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.785 -0400", hash_original_method = "0F8144483E9FB8C5272FCB0807695B13", hash_generated_method = "449A2875ABE8A5FBDB1957D6E4144E03")
        public void surfaceDestroyed(SurfaceHolder holder) {
            pauseAndDispatch(mProxy);
            mPlayer.release();
            mSurfaceHolder = null;
            {
                mMediaController.hide();
            } 
            addTaint(holder.getTaint());
            
            
            
            
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.786 -0400", hash_original_field = "55FFCA4751537187A8982D3E5A69F88A", hash_generated_field = "C4A3583ED72DBDCEC29E2759A4D2C518")

    private final WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.786 -0400", hash_original_method = "5310CBE0D16478795A0BF544D70BB888", hash_generated_method = "3659616311AB6104A720F2EA1CD580E8")
        public void onCustomViewHidden() {
            
            mProxy.dispatchOnStopFullScreen();
            mLayout.removeView(getSurfaceView());
            {
                mLayout.removeView(mProgressView);
                mProgressView = null;
            } 
            mLayout = null;
            mProxy.getWebView().getViewManager().showAll();
            mProxy = null;
            mMediaController = null;
            mCurrentState = STATE_RELEASED;
            
            
            
            
                    
                    
                
            
            
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.786 -0400", hash_original_field = "586F4A1CD959A521D8527F9D0DB7C837", hash_generated_field = "05BD4E082473F28F5FFEEC2BBBEB8ECF")

    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.786 -0400", hash_original_method = "16726F937605C6D0A73F251CECEE924B", hash_generated_method = "FD12763B931B9411DD8FAD196940204B")
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            
            mCurrentBufferPercentage = percent;
            addTaint(mp.getTaint());
            addTaint(percent);
            
            
        }

        
};
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.900 -0400", hash_original_method = "F60EEA4D15F598668F4A6E94C09A46EA", hash_generated_method = "9E194C9A81931F4934CF59BEFC3A9D01")
      HTML5VideoFullScreen(Context context, int videoLayerId, int position,
            boolean autoStart) {
        addTaint(autoStart);
        addTaint(position);
        addTaint(videoLayerId);
        mVideoSurfaceView = new VideoSurfaceView(context);
        mFullScreenMode = FULLSCREEN_OFF;
        mVideoWidth = 0;
        mVideoHeight = 0;
        init(videoLayerId, position, autoStart);
        // ---------- Original Method ----------
        //mVideoSurfaceView = new VideoSurfaceView(context);
        //mFullScreenMode = FULLSCREEN_OFF;
        //mVideoWidth = 0;
        //mVideoHeight = 0;
        //init(videoLayerId, position, autoStart);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.900 -0400", hash_original_method = "AB3C62FD6F005880E77BC1927A87EEED", hash_generated_method = "7F016C9F8DFCB1EAFA418BF912203253")
    private SurfaceView getSurfaceView() {
SurfaceView var864033359B783656342F447F5243D0ED_1316160071 =         mVideoSurfaceView;
        var864033359B783656342F447F5243D0ED_1316160071.addTaint(taint);
        return var864033359B783656342F447F5243D0ED_1316160071;
        // ---------- Original Method ----------
        //return mVideoSurfaceView;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.900 -0400", hash_original_method = "1F74C4E95F456B4EB4EE7ED74E748A1C", hash_generated_method = "801799CB0C592DFB6B2E64277EBF8B7F")
    private void setMediaController(MediaController m) {
        mMediaController  = m;
        attachMediaController();
        // ---------- Original Method ----------
        //mMediaController  = m;
        //attachMediaController();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.900 -0400", hash_original_method = "BDA424FAC6D15253AC0E1C5DC76C6F7A", hash_generated_method = "4BA845F75A9141E62683E2F586729A80")
    private void attachMediaController() {
        if(mPlayer != null && mMediaController != null)        
        {
            mMediaController.setMediaPlayer(this);
            mMediaController.setAnchorView(mVideoSurfaceView);
            mMediaController.setEnabled(false);
        } //End block
        // ---------- Original Method ----------
        //if (mPlayer != null && mMediaController != null) {
            //mMediaController.setMediaPlayer(this);
            //mMediaController.setAnchorView(mVideoSurfaceView);
            //mMediaController.setEnabled(false);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.900 -0400", hash_original_method = "010B148200478BACA2EC38A18BA9574D", hash_generated_method = "88980725431A155BEDF1061FBBB25E49")
    @Override
    public void decideDisplayMode() {
        mPlayer.setDisplay(mSurfaceHolder);
        // ---------- Original Method ----------
        //mPlayer.setDisplay(mSurfaceHolder);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.900 -0400", hash_original_method = "55B4D124A95057AC3A279B37C798CFA8", hash_generated_method = "944F90C44367916A4DC4AB4D8CFB1BA7")
    private void prepareForFullScreen() {
        mPlayer.reset();
        MediaController mc = new FullScreenMediaController(mProxy.getContext(), mLayout);
        mc.setSystemUiVisibility(mLayout.getSystemUiVisibility());
        setMediaController(mc);
        mPlayer.setScreenOnWhilePlaying(true);
        prepareDataAndDisplayMode(mProxy);
        // ---------- Original Method ----------
        //mPlayer.reset();
        //MediaController mc = new FullScreenMediaController(mProxy.getContext(), mLayout);
        //mc.setSystemUiVisibility(mLayout.getSystemUiVisibility());
        //setMediaController(mc);
        //mPlayer.setScreenOnWhilePlaying(true);
        //prepareDataAndDisplayMode(mProxy);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.901 -0400", hash_original_method = "E102D2D0B33B8C0648E23B09161A5D91", hash_generated_method = "3FD9697155F837AC56FFFC09091C9312")
    private void toggleMediaControlsVisiblity() {
        if(mMediaController.isShowing())        
        {
            mMediaController.hide();
        } //End block
        else
        {
            mMediaController.show();
        } //End block
        // ---------- Original Method ----------
        //if (mMediaController.isShowing()) {
            //mMediaController.hide();
        //} else {
            //mMediaController.show();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.901 -0400", hash_original_method = "8210B7805670B2428155D9962ECCD498", hash_generated_method = "0B5D0351AA80A3CF8BFC7AD969F4A539")
    @Override
    public void onPrepared(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPrepared(mp);
        mVideoSurfaceView.setOnTouchListener(this);
        Metadata data = mp.getMetadata(MediaPlayer.METADATA_ALL,
                MediaPlayer.BYPASS_METADATA_FILTER);
        if(data != null)        
        {
            mCanPause = !data.has(Metadata.PAUSE_AVAILABLE)
                    || data.getBoolean(Metadata.PAUSE_AVAILABLE);
            mCanSeekBack = !data.has(Metadata.SEEK_BACKWARD_AVAILABLE)
                    || data.getBoolean(Metadata.SEEK_BACKWARD_AVAILABLE);
            mCanSeekForward = !data.has(Metadata.SEEK_FORWARD_AVAILABLE)
                    || data.getBoolean(Metadata.SEEK_FORWARD_AVAILABLE);
        } //End block
        else
        {
            mCanPause = mCanSeekBack = mCanSeekForward = true;
        } //End block
        if(mMediaController != null)        
        {
            mMediaController.setEnabled(true);
            if(getAutostart())            
            mMediaController.show();
            else
            mMediaController.show(0);
        } //End block
        if(mProgressView != null)        
        {
            mProgressView.setVisibility(View.GONE);
        } //End block
        mVideoWidth = mp.getVideoWidth();
        mVideoHeight = mp.getVideoHeight();
        mVideoSurfaceView.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.901 -0400", hash_original_method = "D38369E141B1495D009E7319C4B9F69F", hash_generated_method = "197A34623DF41B1B3C0BB144B5BEDB0A")
    public boolean fullScreenExited() {
        boolean varA93A45CC1C08EB972D4A6DEB1FE2CB96_317114872 = ((mLayout == null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16859639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16859639;
        // ---------- Original Method ----------
        //return (mLayout == null);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.902 -0400", hash_original_method = "A8AE00CC29C9049B47899131597AFF8D", hash_generated_method = "A2BCE3B2D185CEC0CD0772FB06D84590")
    @Override
    public void enterFullScreenVideoState(int layerId,
            HTML5VideoViewProxy proxy, WebView webView) {
        addTaint(webView.getTaint());
        addTaint(proxy.getTaint());
        addTaint(layerId);
        mFullScreenMode = FULLSCREEN_SURFACECREATING;
        mCurrentBufferPercentage = 0;
        mPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
        mProxy = proxy;
        mVideoSurfaceView.getHolder().addCallback(mSHCallback);
        mVideoSurfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mVideoSurfaceView.setFocusable(true);
        mVideoSurfaceView.setFocusableInTouchMode(true);
        mVideoSurfaceView.requestFocus();
        mLayout = new FrameLayout(mProxy.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            Gravity.CENTER);
        mLayout.addView(getSurfaceView(), layoutParams);
        mLayout.setVisibility(View.VISIBLE);
        WebChromeClient client = webView.getWebChromeClient();
        if(client != null)        
        {
            client.onShowCustomView(mLayout, mCallback);
            if(webView.getViewManager() != null)            
            webView.getViewManager().hideAll();
            mProgressView = client.getVideoLoadingProgressView();
            if(mProgressView != null)            
            {
                mLayout.addView(mProgressView, layoutParams);
                mProgressView.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.902 -0400", hash_original_method = "2F3070B25A278338AEEAB48124299E28", hash_generated_method = "74AC3F1CA95F3B60A9FD9F5DA7AF7672")
    public boolean isFullScreenMode() {
        boolean varB326B5062B2F0E69046810717534CB09_1842248206 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366144380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366144380;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.902 -0400", hash_original_method = "1DF27838EDEF437B2494B2DF149883EF", hash_generated_method = "C64CA10F3E86C128530993A70E01FC16")
    @Override
    public boolean canPause() {
        boolean var9A4623B61542BEC8D3E426C93DD77346_363669169 = (mCanPause);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859632795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859632795;
        // ---------- Original Method ----------
        //return mCanPause;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.902 -0400", hash_original_method = "B916F92CBCCEC1C42038C36AAFFAA2A8", hash_generated_method = "E8742EB7895B80DA5B2D5FEB4B74F174")
    @Override
    public boolean canSeekBackward() {
        boolean var260CDABACB2B7A4C6F8B739A9531399D_86555363 = (mCanSeekBack);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_799467898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_799467898;
        // ---------- Original Method ----------
        //return mCanSeekBack;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.902 -0400", hash_original_method = "7621B01EBEE0D0CEF34FD8A655C3B087", hash_generated_method = "FB648462277EDA8558D22E59DB9818F9")
    @Override
    public boolean canSeekForward() {
        boolean var1042AFD5E2128CC06471C1ED59799B06_2100157634 = (mCanSeekForward);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870715363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_870715363;
        // ---------- Original Method ----------
        //return mCanSeekForward;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.903 -0400", hash_original_method = "5712A5AFCA7A8FC23B7D8D35D8488604", hash_generated_method = "BB8139CC90505EF48597674A41063CF6")
    @Override
    public int getBufferPercentage() {
        if(mPlayer != null)        
        {
            int var1873B2B1AC18422B33460DFB5D5CB345_352998986 = (mCurrentBufferPercentage);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574811555 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574811555;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1976621317 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076606110 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076606110;
        // ---------- Original Method ----------
        //if (mPlayer != null) {
            //return mCurrentBufferPercentage;
        //}
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.903 -0400", hash_original_method = "6CF96CE118939EE02746CF132717D00A", hash_generated_method = "9702689373B0AE114489ADD6E678CE22")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(v.getTaint());
        if(mFullScreenMode >= FULLSCREEN_SURFACECREATED
                && mMediaController != null)        
        {
            toggleMediaControlsVisiblity();
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1191363406 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156763624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156763624;
        // ---------- Original Method ----------
        //if (mFullScreenMode >= FULLSCREEN_SURFACECREATED
                //&& mMediaController != null) {
            //toggleMediaControlsVisiblity();
        //}
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.903 -0400", hash_original_method = "768EF74C7E083D9FE3529A6C9E69F9F8", hash_generated_method = "F331AAB42E954B97E4895E585A9B451C")
    @Override
    protected void switchProgressView(boolean playerBuffering) {
        addTaint(playerBuffering);
        if(mProgressView != null)        
        {
            if(playerBuffering)            
            {
                mProgressView.setVisibility(View.VISIBLE);
            } //End block
            else
            {
                mProgressView.setVisibility(View.GONE);
            } //End block
        } //End block
        return;
        // ---------- Original Method ----------
        //if (mProgressView != null) {
            //if (playerBuffering) {
                //mProgressView.setVisibility(View.VISIBLE);
            //} else {
                //mProgressView.setVisibility(View.GONE);
            //}
        //}
        //return;
    }

    
    private class VideoSurfaceView extends SurfaceView {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.903 -0400", hash_original_method = "71BEE01FF22BBAA4C8AB5EB5F8B1B282", hash_generated_method = "81EEFE9A468C5967FB9EA2E3CB7D3BBE")
        public  VideoSurfaceView(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.904 -0400", hash_original_method = "9B50960AB78A53ECD97D5FCFD81C02C7", hash_generated_method = "A9195C0AFBDD862B72B1DC4CDD53C35F")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(heightMeasureSpec);
            addTaint(widthMeasureSpec);
            int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
            int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
            if(mVideoWidth > 0 && mVideoHeight > 0)            
            {
                if(mVideoWidth * height  > width * mVideoHeight)                
                {
                    height = width * mVideoHeight / mVideoWidth;
                } //End block
                else
                if(mVideoWidth * height  < width * mVideoHeight)                
                {
                    width = height * mVideoWidth / mVideoHeight;
                } //End block
            } //End block
            setMeasuredDimension(width, height);
            // ---------- Original Method ----------
            //int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
            //int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
            //if (mVideoWidth > 0 && mVideoHeight > 0) {
                //if ( mVideoWidth * height  > width * mVideoHeight ) {
                    //height = width * mVideoHeight / mVideoWidth;
                //} else if ( mVideoWidth * height  < width * mVideoHeight ) {
                    //width = height * mVideoWidth / mVideoHeight;
                //}
            //}
            //setMeasuredDimension(width, height);
        }

        
    }


    
    static class FullScreenMediaController extends MediaController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.904 -0400", hash_original_field = "DEC990904573CB9B0D065C89AD3A11D2", hash_generated_field = "E49B1FFE75183DE55D21F4CFB8705941")

        View mVideoView;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.904 -0400", hash_original_method = "4242A1CB7F524CD2844041A7C182F29C", hash_generated_method = "8D8F0072C8CE6F2E3E1B804E5EFAAC19")
        public  FullScreenMediaController(Context context, View video) {
            super(context);
            addTaint(context.getTaint());
            mVideoView = video;
            // ---------- Original Method ----------
            //mVideoView = video;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.904 -0400", hash_original_method = "5C37CDC7ADB20FAB9875274C523AD18A", hash_generated_method = "E9BD2B88B09359647271228EDD79FC97")
        @Override
        public void show() {
            super.show();
            if(mVideoView != null)            
            {
                mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            } //End block
            // ---------- Original Method ----------
            //super.show();
            //if (mVideoView != null) {
                //mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            //}
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.904 -0400", hash_original_method = "82DCA636A8398ED2FB754EAF8FD1AC92", hash_generated_method = "7836EC5B1B2083E36988EDFB4FF85DD7")
        @Override
        public void hide() {
            if(mVideoView != null)            
            {
                mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            } //End block
            super.hide();
            // ---------- Original Method ----------
            //if (mVideoView != null) {
                //mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                        //| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            //}
            //super.hide();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.905 -0400", hash_original_field = "F04BD482698D6831C345633B6AF5E4A0", hash_generated_field = "4A2BED61F2CA029DAEB32D748D9E7C92")

    static final int FULLSCREEN_OFF = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.905 -0400", hash_original_field = "CF2357B11ABD2867E3D00713F50DA9CD", hash_generated_field = "95ACD9F978B91416E7DD88440CCF98E8")

    static final int FULLSCREEN_SURFACECREATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.905 -0400", hash_original_field = "AF195748F54C2EDC23CB2A66348A54C6", hash_generated_field = "D0963B0C99500DEAD00BF4698232C2F7")

    static final int FULLSCREEN_SURFACECREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.905 -0400", hash_original_field = "356BEA1A72BD3DB0203E9E44A65DA2AB", hash_generated_field = "2544D9B3BCB2C2DD4A48F6808AD9E918")

    private static View mProgressView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.905 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "AA344AC873FB74428BAEEC0E5D10702B")

    private static FrameLayout mLayout;
}

