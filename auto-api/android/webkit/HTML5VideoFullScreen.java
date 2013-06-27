package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "577C208742D945E462EAA34C09855363", hash_generated_field = "995FA5F24A4C3D9EC1E030DE94C34639")

    private VideoSurfaceView mVideoSurfaceView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "8C9F6FC19D50AADA4959421485D997DD", hash_generated_field = "23A07B55D02F895AD551D2F26BB95165")

    private int mFullScreenMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "A57983EA22A29D716213C2400D6F1D7A", hash_generated_field = "FFE64F26EAFE41C0717BC03DFAEF93DE")

    private MediaController mMediaController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "6072A5355110211D8AD992A1E8763595", hash_generated_field = "846D019DBE1F3FC208D26AE6B51E7E7A")

    private SurfaceHolder mSurfaceHolder = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "260CDABACB2B7A4C6F8B739A9531399D", hash_generated_field = "F0F23120A5CAF86AFF0F96CAE67D6030")

    private boolean mCanSeekBack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "1042AFD5E2128CC06471C1ED59799B06", hash_generated_field = "AD1D51CB83FA72C2D49574CD80EEB438")

    private boolean mCanSeekForward;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "9A4623B61542BEC8D3E426C93DD77346", hash_generated_field = "F1E27FDEF752AF3B6AFE206F5E8D273F")

    private boolean mCanPause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "1873B2B1AC18422B33460DFB5D5CB345", hash_generated_field = "DE5AC282D1679F4F6686171A7EFF5F7A")

    private int mCurrentBufferPercentage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "ECDB7D63CE89453B0D96E6DC96178AAB", hash_generated_field = "1681CCE3F2816C80096F4BC1589307A6")

    private int mVideoWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.573 -0400", hash_original_field = "BF03935A9A0E39D0F45DBB78BE93B589", hash_generated_field = "4EA21094A26D2FB68A0C1EF72DA153C9")

    private int mVideoHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.575 -0400", hash_original_field = "1FB69BD30A94387173B150B37758527C", hash_generated_field = "2373EDE384765412916A84D331190140")

    SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.574 -0400", hash_original_method = "3F198B15E26BAFE43EE75044605DFD16", hash_generated_method = "A2ECC2F3ACA78FED2945F5D887B4D7A9")
        public void surfaceChanged(SurfaceHolder holder, int format,
                                    int w, int h) {
            {
                {
                    boolean var897EB098F08F185648904C85595F1D42_1763822562 = (mMediaController.isShowing());
                    {
                        mMediaController.hide();
                    } //End block
                } //End collapsed parenthetic
                mMediaController.show();
            } //End block
            addTaint(holder.getTaint());
            addTaint(format);
            addTaint(w);
            addTaint(h);
            // ---------- Original Method ----------
            //if (mPlayer != null && mMediaController != null
                    //&& mCurrentState == STATE_PREPARED) {
                //if (mMediaController.isShowing()) {
                    //mMediaController.hide();
                //}
                //mMediaController.show();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.574 -0400", hash_original_method = "94E02A68EADA9CB33F96FB8AB670115A", hash_generated_method = "1E0535E0C877A1119FDCC584F158C234")
        public void surfaceCreated(SurfaceHolder holder) {
            mSurfaceHolder = holder;
            mFullScreenMode = FULLSCREEN_SURFACECREATED;
            prepareForFullScreen();
            addTaint(holder.getTaint());
            // ---------- Original Method ----------
            //mSurfaceHolder = holder;
            //mFullScreenMode = FULLSCREEN_SURFACECREATED;
            //prepareForFullScreen();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.575 -0400", hash_original_method = "0F8144483E9FB8C5272FCB0807695B13", hash_generated_method = "449A2875ABE8A5FBDB1957D6E4144E03")
        public void surfaceDestroyed(SurfaceHolder holder) {
            pauseAndDispatch(mProxy);
            mPlayer.release();
            mSurfaceHolder = null;
            {
                mMediaController.hide();
            } //End block
            addTaint(holder.getTaint());
            // ---------- Original Method ----------
            //pauseAndDispatch(mProxy);
            //mPlayer.release();
            //mSurfaceHolder = null;
            //if (mMediaController != null) {
                //mMediaController.hide();
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.591 -0400", hash_original_field = "55FFCA4751537187A8982D3E5A69F88A", hash_generated_field = "274576708A1DA061BC734796E3A8F3C0")

    private WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.591 -0400", hash_original_method = "5310CBE0D16478795A0BF544D70BB888", hash_generated_method = "3659616311AB6104A720F2EA1CD580E8")
        public void onCustomViewHidden() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mProxy.dispatchOnStopFullScreen();
            mLayout.removeView(getSurfaceView());
            {
                mLayout.removeView(mProgressView);
                mProgressView = null;
            } //End block
            mLayout = null;
            mProxy.getWebView().getViewManager().showAll();
            mProxy = null;
            mMediaController = null;
            mCurrentState = STATE_RELEASED;
            // ---------- Original Method ----------
            //mProxy.dispatchOnStopFullScreen();
            //mLayout.removeView(getSurfaceView());
            //if (mProgressView != null) {
                    //mLayout.removeView(mProgressView);
                    //mProgressView = null;
                //}
            //mLayout = null;
            //mProxy.getWebView().getViewManager().showAll();
            //mProxy = null;
            //mMediaController = null;
            //mCurrentState = STATE_RELEASED;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.592 -0400", hash_original_field = "586F4A1CD959A521D8527F9D0DB7C837", hash_generated_field = "4FDD9B7DE05A0F1370025FE5B5813919")

    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.592 -0400", hash_original_method = "16726F937605C6D0A73F251CECEE924B", hash_generated_method = "FD12763B931B9411DD8FAD196940204B")
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mCurrentBufferPercentage = percent;
            addTaint(mp.getTaint());
            addTaint(percent);
            // ---------- Original Method ----------
            //mCurrentBufferPercentage = percent;
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.592 -0400", hash_original_method = "F60EEA4D15F598668F4A6E94C09A46EA", hash_generated_method = "403ACD858975FBE23875EE80D7424CAD")
      HTML5VideoFullScreen(Context context, int videoLayerId, int position,
            boolean autoStart) {
        mVideoSurfaceView = new VideoSurfaceView(context);
        mFullScreenMode = FULLSCREEN_OFF;
        mVideoWidth = 0;
        mVideoHeight = 0;
        init(videoLayerId, position, autoStart);
        addTaint(videoLayerId);
        addTaint(position);
        addTaint(autoStart);
        // ---------- Original Method ----------
        //mVideoSurfaceView = new VideoSurfaceView(context);
        //mFullScreenMode = FULLSCREEN_OFF;
        //mVideoWidth = 0;
        //mVideoHeight = 0;
        //init(videoLayerId, position, autoStart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.593 -0400", hash_original_method = "AB3C62FD6F005880E77BC1927A87EEED", hash_generated_method = "291CCCB5180280FB98D69C662F84A99B")
    private SurfaceView getSurfaceView() {
        SurfaceView varB4EAC82CA7396A68D541C85D26508E83_694906241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_694906241 = mVideoSurfaceView;
        varB4EAC82CA7396A68D541C85D26508E83_694906241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_694906241;
        // ---------- Original Method ----------
        //return mVideoSurfaceView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.593 -0400", hash_original_method = "1F74C4E95F456B4EB4EE7ED74E748A1C", hash_generated_method = "801799CB0C592DFB6B2E64277EBF8B7F")
    private void setMediaController(MediaController m) {
        mMediaController  = m;
        attachMediaController();
        // ---------- Original Method ----------
        //mMediaController  = m;
        //attachMediaController();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.593 -0400", hash_original_method = "BDA424FAC6D15253AC0E1C5DC76C6F7A", hash_generated_method = "6E6C0EBA280BC165B66AE2F3F4D04753")
    private void attachMediaController() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.593 -0400", hash_original_method = "010B148200478BACA2EC38A18BA9574D", hash_generated_method = "88980725431A155BEDF1061FBBB25E49")
    @Override
    public void decideDisplayMode() {
        mPlayer.setDisplay(mSurfaceHolder);
        // ---------- Original Method ----------
        //mPlayer.setDisplay(mSurfaceHolder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.594 -0400", hash_original_method = "55B4D124A95057AC3A279B37C798CFA8", hash_generated_method = "2AB33C5EEBDA12800368D97AF3E85F65")
    private void prepareForFullScreen() {
        mPlayer.reset();
        MediaController mc;
        mc = new FullScreenMediaController(mProxy.getContext(), mLayout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.594 -0400", hash_original_method = "E102D2D0B33B8C0648E23B09161A5D91", hash_generated_method = "5E3AA3FB6D714E85CD87D5FD45A886E6")
    private void toggleMediaControlsVisiblity() {
        {
            boolean varD4E8898DF2C2C1A6D73B41D6963FEA27_846446929 = (mMediaController.isShowing());
            {
                mMediaController.hide();
            } //End block
            {
                mMediaController.show();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mMediaController.isShowing()) {
            //mMediaController.hide();
        //} else {
            //mMediaController.show();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.604 -0400", hash_original_method = "8210B7805670B2428155D9962ECCD498", hash_generated_method = "BB97E2A7D4B846ABF47DA8EC3A47596C")
    @Override
    public void onPrepared(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPrepared(mp);
        mVideoSurfaceView.setOnTouchListener(this);
        Metadata data;
        data = mp.getMetadata(MediaPlayer.METADATA_ALL,
                MediaPlayer.BYPASS_METADATA_FILTER);
        {
            mCanPause = !data.has(Metadata.PAUSE_AVAILABLE)
                    || data.getBoolean(Metadata.PAUSE_AVAILABLE);
            mCanSeekBack = !data.has(Metadata.SEEK_BACKWARD_AVAILABLE)
                    || data.getBoolean(Metadata.SEEK_BACKWARD_AVAILABLE);
            mCanSeekForward = !data.has(Metadata.SEEK_FORWARD_AVAILABLE)
                    || data.getBoolean(Metadata.SEEK_FORWARD_AVAILABLE);
        } //End block
        {
            mCanPause = mCanSeekBack = mCanSeekForward = true;
        } //End block
        {
            mMediaController.setEnabled(true);
            {
                boolean var6CE32148AB2E3015385EB11B759776A2_463873872 = (getAutostart());
                mMediaController.show();
                mMediaController.show(0);
            } //End collapsed parenthetic
        } //End block
        {
            mProgressView.setVisibility(View.GONE);
        } //End block
        mVideoWidth = mp.getVideoWidth();
        mVideoHeight = mp.getVideoHeight();
        mVideoSurfaceView.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.604 -0400", hash_original_method = "D38369E141B1495D009E7319C4B9F69F", hash_generated_method = "C299A92DD65F03E6D56F2DABAEADFEDF")
    public boolean fullScreenExited() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674585172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674585172;
        // ---------- Original Method ----------
        //return (mLayout == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.624 -0400", hash_original_method = "A8AE00CC29C9049B47899131597AFF8D", hash_generated_method = "90C9685FB2E77AF3D6FB7019FDC267B5")
    @Override
    public void enterFullScreenVideoState(int layerId,
            HTML5VideoViewProxy proxy, WebView webView) {
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
        FrameLayout.LayoutParams layoutParams;
        layoutParams = new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            Gravity.CENTER);
        mLayout.addView(getSurfaceView(), layoutParams);
        mLayout.setVisibility(View.VISIBLE);
        WebChromeClient client;
        client = webView.getWebChromeClient();
        {
            client.onShowCustomView(mLayout, mCallback);
            {
                boolean var347010D71F6116A7007D9AE2C20C3127_1436359243 = (webView.getViewManager() != null);
                webView.getViewManager().hideAll();
            } //End collapsed parenthetic
            mProgressView = client.getVideoLoadingProgressView();
            {
                mLayout.addView(mProgressView, layoutParams);
                mProgressView.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        addTaint(layerId);
        addTaint(proxy.getTaint());
        addTaint(webView.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.624 -0400", hash_original_method = "2F3070B25A278338AEEAB48124299E28", hash_generated_method = "EA0BADC9515946F61FA9743FB6C27A20")
    public boolean isFullScreenMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262385346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_262385346;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.624 -0400", hash_original_method = "1DF27838EDEF437B2494B2DF149883EF", hash_generated_method = "139F121D40F09617F36292A9E2A213D8")
    @Override
    public boolean canPause() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860585695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860585695;
        // ---------- Original Method ----------
        //return mCanPause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.625 -0400", hash_original_method = "B916F92CBCCEC1C42038C36AAFFAA2A8", hash_generated_method = "4ED626DD1925F75037F4BACF918741A3")
    @Override
    public boolean canSeekBackward() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1133199021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1133199021;
        // ---------- Original Method ----------
        //return mCanSeekBack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.625 -0400", hash_original_method = "7621B01EBEE0D0CEF34FD8A655C3B087", hash_generated_method = "5049D3F680CF004B8C0CFDB094D579D9")
    @Override
    public boolean canSeekForward() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_31321359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_31321359;
        // ---------- Original Method ----------
        //return mCanSeekForward;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.628 -0400", hash_original_method = "5712A5AFCA7A8FC23B7D8D35D8488604", hash_generated_method = "B7C008BE57A78557B77C09DF15314ADB")
    @Override
    public int getBufferPercentage() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305311759 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305311759;
        // ---------- Original Method ----------
        //if (mPlayer != null) {
            //return mCurrentBufferPercentage;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.628 -0400", hash_original_method = "6CF96CE118939EE02746CF132717D00A", hash_generated_method = "79C11FD0D627F3DBA469ADCF55DE3A44")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            toggleMediaControlsVisiblity();
        } //End block
        addTaint(v.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555910158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555910158;
        // ---------- Original Method ----------
        //if (mFullScreenMode >= FULLSCREEN_SURFACECREATED
                //&& mMediaController != null) {
            //toggleMediaControlsVisiblity();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.631 -0400", hash_original_method = "768EF74C7E083D9FE3529A6C9E69F9F8", hash_generated_method = "88B577C05942373895485FC8D1245DA9")
    @Override
    protected void switchProgressView(boolean playerBuffering) {
        {
            {
                mProgressView.setVisibility(View.VISIBLE);
            } //End block
            {
                mProgressView.setVisibility(View.GONE);
            } //End block
        } //End block
        addTaint(playerBuffering);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.632 -0400", hash_original_method = "71BEE01FF22BBAA4C8AB5EB5F8B1B282", hash_generated_method = "81EEFE9A468C5967FB9EA2E3CB7D3BBE")
        public  VideoSurfaceView(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.632 -0400", hash_original_method = "9B50960AB78A53ECD97D5FCFD81C02C7", hash_generated_method = "297D08ECD62B5A8FF7B42410E16C6D05")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int width;
            width = getDefaultSize(mVideoWidth, widthMeasureSpec);
            int height;
            height = getDefaultSize(mVideoHeight, heightMeasureSpec);
            {
                {
                    height = width * mVideoHeight / mVideoWidth;
                } //End block
                {
                    width = height * mVideoWidth / mVideoHeight;
                } //End block
            } //End block
            setMeasuredDimension(width, height);
            addTaint(widthMeasureSpec);
            addTaint(heightMeasureSpec);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.640 -0400", hash_original_field = "DEC990904573CB9B0D065C89AD3A11D2", hash_generated_field = "E49B1FFE75183DE55D21F4CFB8705941")

        View mVideoView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.657 -0400", hash_original_method = "4242A1CB7F524CD2844041A7C182F29C", hash_generated_method = "ACCE13EE3BBE1B8843443A845098CB7A")
        public  FullScreenMediaController(Context context, View video) {
            super(context);
            mVideoView = video;
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //mVideoView = video;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.658 -0400", hash_original_method = "5C37CDC7ADB20FAB9875274C523AD18A", hash_generated_method = "4E68293E9704C553AB907504EE8C063E")
        @Override
        public void show() {
            super.show();
            {
                mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            } //End block
            // ---------- Original Method ----------
            //super.show();
            //if (mVideoView != null) {
                //mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.658 -0400", hash_original_method = "82DCA636A8398ED2FB754EAF8FD1AC92", hash_generated_method = "284795290C307592280E0EB38F7AE6E6")
        @Override
        public void hide() {
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.658 -0400", hash_original_field = "F04BD482698D6831C345633B6AF5E4A0", hash_generated_field = "8ED67D4E2E38CE0BA0CC9B945992A325")

    static int FULLSCREEN_OFF = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.658 -0400", hash_original_field = "CF2357B11ABD2867E3D00713F50DA9CD", hash_generated_field = "FC6FB1C5874B3002E33AE20F0FB2CA2C")

    static int FULLSCREEN_SURFACECREATING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.658 -0400", hash_original_field = "AF195748F54C2EDC23CB2A66348A54C6", hash_generated_field = "5D3D9BE84ECDD7F50675BC312D58A3B9")

    static int FULLSCREEN_SURFACECREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.658 -0400", hash_original_field = "356BEA1A72BD3DB0203E9E44A65DA2AB", hash_generated_field = "2544D9B3BCB2C2DD4A48F6808AD9E918")

    private static View mProgressView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.658 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "AA344AC873FB74428BAEEC0E5D10702B")

    private static FrameLayout mLayout;
}

