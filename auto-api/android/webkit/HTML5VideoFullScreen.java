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
    private VideoSurfaceView mVideoSurfaceView;
    private int mFullScreenMode;
    private MediaController mMediaController;
    private SurfaceHolder mSurfaceHolder = null;
    private boolean mCanSeekBack;
    private boolean mCanSeekForward;
    private boolean mCanPause;
    private int mCurrentBufferPercentage;
    private int mVideoWidth;
    private int mVideoHeight;
    SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.304 -0400", hash_original_method = "3F198B15E26BAFE43EE75044605DFD16", hash_generated_method = "F10C19D2FC47CD454FB435D13EA74200")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void surfaceChanged(SurfaceHolder holder, int format,
                                    int w, int h) {
            dsTaint.addTaint(w);
            dsTaint.addTaint(holder.dsTaint);
            dsTaint.addTaint(format);
            dsTaint.addTaint(h);
            {
                {
                    boolean var897EB098F08F185648904C85595F1D42_1170061026 = (mMediaController.isShowing());
                    {
                        mMediaController.hide();
                    } //End block
                } //End collapsed parenthetic
                mMediaController.show();
            } //End block
            // ---------- Original Method ----------
            //if (mPlayer != null && mMediaController != null
                    //&& mCurrentState == STATE_PREPARED) {
                //if (mMediaController.isShowing()) {
                    //mMediaController.hide();
                //}
                //mMediaController.show();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.305 -0400", hash_original_method = "94E02A68EADA9CB33F96FB8AB670115A", hash_generated_method = "1C642A6E3F9323114B40F4D4633942AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void surfaceCreated(SurfaceHolder holder) {
            dsTaint.addTaint(holder.dsTaint);
            mSurfaceHolder = holder;
            mFullScreenMode = FULLSCREEN_SURFACECREATED;
            prepareForFullScreen();
            // ---------- Original Method ----------
            //mSurfaceHolder = holder;
            //mFullScreenMode = FULLSCREEN_SURFACECREATED;
            //prepareForFullScreen();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.305 -0400", hash_original_method = "0F8144483E9FB8C5272FCB0807695B13", hash_generated_method = "D9E789F267D1D413AB1E8C30874EB35C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void surfaceDestroyed(SurfaceHolder holder) {
            dsTaint.addTaint(holder.dsTaint);
            pauseAndDispatch(mProxy);
            mPlayer.release();
            mSurfaceHolder = null;
            {
                mMediaController.hide();
            } //End block
            // ---------- Original Method ----------
            //pauseAndDispatch(mProxy);
            //mPlayer.release();
            //mSurfaceHolder = null;
            //if (mMediaController != null) {
                //mMediaController.hide();
            //}
        }

        
}; //Transformed anonymous class
    private final WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.305 -0400", hash_original_method = "5310CBE0D16478795A0BF544D70BB888", hash_generated_method = "3659616311AB6104A720F2EA1CD580E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
}; //Transformed anonymous class
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.305 -0400", hash_original_method = "16726F937605C6D0A73F251CECEE924B", hash_generated_method = "034415AAE495466E7DD61929924AF062")
        @DSModeled(DSC.SAFE)
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(mp.dsTaint);
            dsTaint.addTaint(percent);
            mCurrentBufferPercentage = percent;
            // ---------- Original Method ----------
            //mCurrentBufferPercentage = percent;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.306 -0400", hash_original_method = "F60EEA4D15F598668F4A6E94C09A46EA", hash_generated_method = "E4BCD28901A10AFAA63B00F1D9A1E643")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HTML5VideoFullScreen(Context context, int videoLayerId, int position,
            boolean autoStart) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(autoStart);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(videoLayerId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.306 -0400", hash_original_method = "AB3C62FD6F005880E77BC1927A87EEED", hash_generated_method = "00E7882396219CA76E6990A56570AEB6")
    @DSModeled(DSC.SAFE)
    private SurfaceView getSurfaceView() {
        return (SurfaceView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mVideoSurfaceView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.306 -0400", hash_original_method = "1F74C4E95F456B4EB4EE7ED74E748A1C", hash_generated_method = "C05ADFF7CCC5BAD10657FD1208618678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setMediaController(MediaController m) {
        dsTaint.addTaint(m.dsTaint);
        attachMediaController();
        // ---------- Original Method ----------
        //mMediaController  = m;
        //attachMediaController();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.306 -0400", hash_original_method = "BDA424FAC6D15253AC0E1C5DC76C6F7A", hash_generated_method = "6E6C0EBA280BC165B66AE2F3F4D04753")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.306 -0400", hash_original_method = "010B148200478BACA2EC38A18BA9574D", hash_generated_method = "88980725431A155BEDF1061FBBB25E49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void decideDisplayMode() {
        mPlayer.setDisplay(mSurfaceHolder);
        // ---------- Original Method ----------
        //mPlayer.setDisplay(mSurfaceHolder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.307 -0400", hash_original_method = "55B4D124A95057AC3A279B37C798CFA8", hash_generated_method = "2AB33C5EEBDA12800368D97AF3E85F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.307 -0400", hash_original_method = "E102D2D0B33B8C0648E23B09161A5D91", hash_generated_method = "5C8D13C4C2AEBE1AF22F27EFE0D8E502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void toggleMediaControlsVisiblity() {
        {
            boolean varD4E8898DF2C2C1A6D73B41D6963FEA27_43475804 = (mMediaController.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.308 -0400", hash_original_method = "8210B7805670B2428155D9962ECCD498", hash_generated_method = "B652F9A96BC1051F3B2B9AE9507AB564")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPrepared(MediaPlayer mp) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(mp.dsTaint);
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
                boolean var6CE32148AB2E3015385EB11B759776A2_714598443 = (getAutostart());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.308 -0400", hash_original_method = "D38369E141B1495D009E7319C4B9F69F", hash_generated_method = "F2C8D993683312FAE493C00DAEA9D86E")
    @DSModeled(DSC.SAFE)
    public boolean fullScreenExited() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mLayout == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.308 -0400", hash_original_method = "A8AE00CC29C9049B47899131597AFF8D", hash_generated_method = "AF0CEADF7D6964342CDA67A58ECB5AA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void enterFullScreenVideoState(int layerId,
            HTML5VideoViewProxy proxy, WebView webView) {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(webView.dsTaint);
        dsTaint.addTaint(layerId);
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
                boolean var347010D71F6116A7007D9AE2C20C3127_1792645583 = (webView.getViewManager() != null);
                webView.getViewManager().hideAll();
            } //End collapsed parenthetic
            mProgressView = client.getVideoLoadingProgressView();
            {
                mLayout.addView(mProgressView, layoutParams);
                mProgressView.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.308 -0400", hash_original_method = "2F3070B25A278338AEEAB48124299E28", hash_generated_method = "919A92F5F3B0375F53172906B26ADCF9")
    @DSModeled(DSC.SAFE)
    public boolean isFullScreenMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.309 -0400", hash_original_method = "1DF27838EDEF437B2494B2DF149883EF", hash_generated_method = "25D9EA705E5887B50EC32846491C4345")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean canPause() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCanPause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.309 -0400", hash_original_method = "B916F92CBCCEC1C42038C36AAFFAA2A8", hash_generated_method = "384EE70F1A0F811AB377D3BD24E03602")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean canSeekBackward() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCanSeekBack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.309 -0400", hash_original_method = "7621B01EBEE0D0CEF34FD8A655C3B087", hash_generated_method = "D74B694AFCCA2D4005AC57414A6FF5F1")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean canSeekForward() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCanSeekForward;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.309 -0400", hash_original_method = "5712A5AFCA7A8FC23B7D8D35D8488604", hash_generated_method = "9234DD384EF4E1D7BA0DDF1335D8F8BA")
    @DSModeled(DSC.SAFE)
    @Override
    public int getBufferPercentage() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mPlayer != null) {
            //return mCurrentBufferPercentage;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.309 -0400", hash_original_method = "6CF96CE118939EE02746CF132717D00A", hash_generated_method = "7FDF4130F5A20F4BC85FBAD4581F6B38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        {
            toggleMediaControlsVisiblity();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mFullScreenMode >= FULLSCREEN_SURFACECREATED
                //&& mMediaController != null) {
            //toggleMediaControlsVisiblity();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.309 -0400", hash_original_method = "768EF74C7E083D9FE3529A6C9E69F9F8", hash_generated_method = "3AA52DD3906BEC5FDF4B589525FA7FA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void switchProgressView(boolean playerBuffering) {
        dsTaint.addTaint(playerBuffering);
        {
            {
                mProgressView.setVisibility(View.VISIBLE);
            } //End block
            {
                mProgressView.setVisibility(View.GONE);
            } //End block
        } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.310 -0400", hash_original_method = "71BEE01FF22BBAA4C8AB5EB5F8B1B282", hash_generated_method = "23928D4C64E78AA6745640346C244142")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public VideoSurfaceView(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.310 -0400", hash_original_method = "9B50960AB78A53ECD97D5FCFD81C02C7", hash_generated_method = "241D4F7DD0A4E6C8CE7363CFD51484BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(heightMeasureSpec);
            dsTaint.addTaint(widthMeasureSpec);
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
        View mVideoView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.310 -0400", hash_original_method = "4242A1CB7F524CD2844041A7C182F29C", hash_generated_method = "36C6531AD9A86C4F613A9A28495164D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FullScreenMediaController(Context context, View video) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(video.dsTaint);
            // ---------- Original Method ----------
            //mVideoView = video;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.310 -0400", hash_original_method = "5C37CDC7ADB20FAB9875274C523AD18A", hash_generated_method = "4E68293E9704C553AB907504EE8C063E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.311 -0400", hash_original_method = "82DCA636A8398ED2FB754EAF8FD1AC92", hash_generated_method = "284795290C307592280E0EB38F7AE6E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    static final int FULLSCREEN_OFF               = 0;
    static final int FULLSCREEN_SURFACECREATING   = 1;
    static final int FULLSCREEN_SURFACECREATED    = 2;
    private static View mProgressView;
    private static FrameLayout mLayout;
}

