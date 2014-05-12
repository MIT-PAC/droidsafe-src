package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.444 -0500", hash_original_field = "C255033DB4C73E44C9226A860E6D3764", hash_generated_field = "9DF99E95D1FB73C7D641285F7A19A5D8")

    // when to create the MediaPlayer accordingly.
    static final int FULLSCREEN_OFF               = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.446 -0500", hash_original_field = "E0E449BEAF64C233A34C135E151E2532", hash_generated_field = "95ACD9F978B91416E7DD88440CCF98E8")

    static final int FULLSCREEN_SURFACECREATING   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.448 -0500", hash_original_field = "B8F4232E444C118C20C73C9CDBBB6A0F", hash_generated_field = "D0963B0C99500DEAD00BF4698232C2F7")

    static final int FULLSCREEN_SURFACECREATED    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.465 -0500", hash_original_field = "474B93ED4948A93F94A7BE0247A5987F", hash_generated_field = "2544D9B3BCB2C2DD4A48F6808AD9E918")

    private static View mProgressView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.467 -0500", hash_original_field = "482155FC3D13455159CA6C6F653BC328", hash_generated_field = "AA344AC873FB74428BAEEC0E5D10702B")

    private static FrameLayout mLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.442 -0500", hash_original_field = "2582F4602A4AEAF45A521EEF5893AD83", hash_generated_field = "995FA5F24A4C3D9EC1E030DE94C34639")

    private VideoSurfaceView mVideoSurfaceView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.450 -0500", hash_original_field = "83E5B07402EC05A905C5C6E05456D19B", hash_generated_field = "23A07B55D02F895AD551D2F26BB95165")

    private int mFullScreenMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.452 -0500", hash_original_field = "C243BEDAA5C901F23F1B05843DE73EEF", hash_generated_field = "FFE64F26EAFE41C0717BC03DFAEF93DE")

    private MediaController mMediaController;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.455 -0500", hash_original_field = "E1BBA50B0E1B0B19BA81ABEA42AC80AC", hash_generated_field = "846D019DBE1F3FC208D26AE6B51E7E7A")

    private SurfaceHolder mSurfaceHolder = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.457 -0500", hash_original_field = "64865A3AEA54610F6680FA90E5F48714", hash_generated_field = "F0F23120A5CAF86AFF0F96CAE67D6030")

    private boolean mCanSeekBack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.459 -0500", hash_original_field = "4542E0113701637133AFC3EB2F5FA344", hash_generated_field = "AD1D51CB83FA72C2D49574CD80EEB438")

    private boolean mCanSeekForward;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.461 -0500", hash_original_field = "BE046AB8724C45B3CAF310B1CBA73120", hash_generated_field = "F1E27FDEF752AF3B6AFE206F5E8D273F")

    private boolean mCanPause;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.463 -0500", hash_original_field = "2DBF12F39B1FFA506F8E14E0F4BA535B", hash_generated_field = "DE5AC282D1679F4F6686171A7EFF5F7A")

    private int mCurrentBufferPercentage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.470 -0500", hash_original_field = "66CA0547E4B7B3C9D451FC50BB40A818", hash_generated_field = "046194AA385AE2FF57FEEA8D7B421608")

    // ratio is correct.
    private int mVideoWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.472 -0500", hash_original_field = "40CDF20752F82AFF4C53ED5C029BD20A", hash_generated_field = "4EA21094A26D2FB68A0C1EF72DA153C9")

    private int mVideoHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.785 -0400", hash_original_field = "1FB69BD30A94387173B150B37758527C", hash_generated_field = "C179BAE9DE0AFC3D1C34EC4DFE285114")

    SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.785 -0400", hash_original_method = "94E02A68EADA9CB33F96FB8AB670115A", hash_generated_method = "1E0535E0C877A1119FDCC584F158C234")
        public void surfaceCreated(SurfaceHolder holder) {
            mSurfaceHolder = holder;
            mFullScreenMode = FULLSCREEN_SURFACECREATED;
            prepareForFullScreen();
            addTaint(holder.getTaint());
            
        }
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.786 -0400", hash_original_method = "16726F937605C6D0A73F251CECEE924B", hash_generated_method = "FD12763B931B9411DD8FAD196940204B")
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            
            mCurrentBufferPercentage = percent;
            addTaint(mp.getTaint());
            addTaint(percent);
            
        }
        
};

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.488 -0500", hash_original_method = "F60EEA4D15F598668F4A6E94C09A46EA", hash_generated_method = "F60EEA4D15F598668F4A6E94C09A46EA")
    
HTML5VideoFullScreen(Context context, int videoLayerId, int position,
            boolean autoStart) {
        mVideoSurfaceView = new VideoSurfaceView(context);
        mFullScreenMode = FULLSCREEN_OFF;
        mVideoWidth = 0;
        mVideoHeight = 0;
        init(videoLayerId, position, autoStart);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.485 -0500", hash_original_method = "AB3C62FD6F005880E77BC1927A87EEED", hash_generated_method = "C184EA17A320E37EECCC4CD54E6945BB")
    
private SurfaceView getSurfaceView() {
        return mVideoSurfaceView;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.490 -0500", hash_original_method = "1F74C4E95F456B4EB4EE7ED74E748A1C", hash_generated_method = "13035CB7A0BCE51668A5B11FE79586AC")
    
private void setMediaController(MediaController m) {
        mMediaController  = m;
        attachMediaController();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.492 -0500", hash_original_method = "BDA424FAC6D15253AC0E1C5DC76C6F7A", hash_generated_method = "4E6AFC513FF84B2D57CFE775AADA9051")
    
private void attachMediaController() {
        if (mPlayer != null && mMediaController != null) {
            mMediaController.setMediaPlayer(this);
            mMediaController.setAnchorView(mVideoSurfaceView);
            //Will be enabled when prepared
            mMediaController.setEnabled(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.494 -0500", hash_original_method = "010B148200478BACA2EC38A18BA9574D", hash_generated_method = "1D6E07485A2CA0747D93E7FD2BE2DE8F")
    
@Override
    public void decideDisplayMode() {
        mPlayer.setDisplay(mSurfaceHolder);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.496 -0500", hash_original_method = "55B4D124A95057AC3A279B37C798CFA8", hash_generated_method = "0A6F2F74E1A3F9EB9D0488B7F76F0334")
    
private void prepareForFullScreen() {
        // So in full screen, we reset the MediaPlayer
        mPlayer.reset();
        MediaController mc = new FullScreenMediaController(mProxy.getContext(), mLayout);
        mc.setSystemUiVisibility(mLayout.getSystemUiVisibility());
        setMediaController(mc);
        mPlayer.setScreenOnWhilePlaying(true);
        prepareDataAndDisplayMode(mProxy);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.499 -0500", hash_original_method = "E102D2D0B33B8C0648E23B09161A5D91", hash_generated_method = "117B787CDC5EAA33653E35830F63BC2F")
    
private void toggleMediaControlsVisiblity() {
        if (mMediaController.isShowing()) {
            mMediaController.hide();
        } else {
            mMediaController.show();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.502 -0500", hash_original_method = "8210B7805670B2428155D9962ECCD498", hash_generated_method = "0E7FBDD39542A2C6E2F9C70D68FF8FF5")
    
@Override
    public void onPrepared(MediaPlayer mp) {
        super.onPrepared(mp);

        mVideoSurfaceView.setOnTouchListener(this);
        // Get the capabilities of the player for this stream
        Metadata data = mp.getMetadata(MediaPlayer.METADATA_ALL,
                MediaPlayer.BYPASS_METADATA_FILTER);
        if (data != null) {
            mCanPause = !data.has(Metadata.PAUSE_AVAILABLE)
                    || data.getBoolean(Metadata.PAUSE_AVAILABLE);
            mCanSeekBack = !data.has(Metadata.SEEK_BACKWARD_AVAILABLE)
                    || data.getBoolean(Metadata.SEEK_BACKWARD_AVAILABLE);
            mCanSeekForward = !data.has(Metadata.SEEK_FORWARD_AVAILABLE)
                    || data.getBoolean(Metadata.SEEK_FORWARD_AVAILABLE);
        } else {
            mCanPause = mCanSeekBack = mCanSeekForward = true;
        }

        // mMediaController status depends on the Metadata result, so put it
        // after reading the MetaData
        if (mMediaController != null) {
            mMediaController.setEnabled(true);
            // If paused , should show the controller for ever!
            if (getAutostart())
                mMediaController.show();
            else
                mMediaController.show(0);
        }

        if (mProgressView != null) {
            mProgressView.setVisibility(View.GONE);
        }

        mVideoWidth = mp.getVideoWidth();
        mVideoHeight = mp.getVideoHeight();
        // This will trigger the onMeasure to get the display size right.
        mVideoSurfaceView.getHolder().setFixedSize(mVideoWidth, mVideoHeight);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.504 -0500", hash_original_method = "D38369E141B1495D009E7319C4B9F69F", hash_generated_method = "04ED3005547B9B2C20DA2EF0473D725A")
    
public boolean fullScreenExited() {
        return (mLayout == null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.514 -0500", hash_original_method = "A8AE00CC29C9049B47899131597AFF8D", hash_generated_method = "262A7AA0605F483216B019E0F8A339DD")
    
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

        // Create a FrameLayout that will contain the VideoView and the
        // progress view (if any).
        mLayout = new FrameLayout(mProxy.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            Gravity.CENTER);

        mLayout.addView(getSurfaceView(), layoutParams);

        mLayout.setVisibility(View.VISIBLE);
        WebChromeClient client = webView.getWebChromeClient();
        if (client != null) {
            client.onShowCustomView(mLayout, mCallback);
            // Plugins like Flash will draw over the video so hide
            // them while we're playing.
            if (webView.getViewManager() != null)
                webView.getViewManager().hideAll();

            mProgressView = client.getVideoLoadingProgressView();
            if (mProgressView != null) {
                mLayout.addView(mProgressView, layoutParams);
                mProgressView.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * @return true when we are in full screen mode, even the surface not fully
     * created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.516 -0500", hash_original_method = "2F3070B25A278338AEEAB48124299E28", hash_generated_method = "4E1E2C9DCA210EC68D2BDADC517372A9")
    
public boolean isFullScreenMode() {
        return true;
    }

    // MediaController FUNCTIONS:
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.518 -0500", hash_original_method = "1DF27838EDEF437B2494B2DF149883EF", hash_generated_method = "C35DD4766A46F4CBA1279C1586296BF1")
    
@Override
    public boolean canPause() {
        return mCanPause;
    }
    
    private class VideoSurfaceView extends SurfaceView {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.434 -0500", hash_original_method = "71BEE01FF22BBAA4C8AB5EB5F8B1B282", hash_generated_method = "0A21FF7F7D89BEAC974E6506A11A38E2")
        
public VideoSurfaceView(Context context) {
            super(context);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.438 -0500", hash_original_method = "9B50960AB78A53ECD97D5FCFD81C02C7", hash_generated_method = "592C9998B8CF8D9C3E90CDDAF8483057")
        
@Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
            int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
            if (mVideoWidth > 0 && mVideoHeight > 0) {
                if ( mVideoWidth * height  > width * mVideoHeight ) {
                    height = width * mVideoHeight / mVideoWidth;
                } else if ( mVideoWidth * height  < width * mVideoHeight ) {
                    width = height * mVideoWidth / mVideoHeight;
                }
            }
            setMeasuredDimension(width, height);
        }
        
    }
    
    static class FullScreenMediaController extends MediaController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.538 -0500", hash_original_field = "E49B1FFE75183DE55D21F4CFB8705941", hash_generated_field = "E49B1FFE75183DE55D21F4CFB8705941")

        View mVideoView;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.540 -0500", hash_original_method = "4242A1CB7F524CD2844041A7C182F29C", hash_generated_method = "6DBEE0806F068A5DD63EF9FBAB663F59")
        
public FullScreenMediaController(Context context, View video) {
            super(context);
            mVideoView = video;
        }

        @DSSafe(DSCat.GUI)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.542 -0500", hash_original_method = "5C37CDC7ADB20FAB9875274C523AD18A", hash_generated_method = "97818857D0E370C844660997C7404E6A")
        
@Override
        public void show() {
            super.show();
            if (mVideoView != null) {
                mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }

        @DSSafe(DSCat.GUI)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.545 -0500", hash_original_method = "82DCA636A8398ED2FB754EAF8FD1AC92", hash_generated_method = "AC5DFDAA003ABCB216CC20C1AD19606E")
        
@Override
        public void hide() {
            if (mVideoView != null) {
                mVideoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
            super.hide();
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.520 -0500", hash_original_method = "B916F92CBCCEC1C42038C36AAFFAA2A8", hash_generated_method = "664ED596094EB1B919F14E0955876CE8")
    
@Override
    public boolean canSeekBackward() {
        return mCanSeekBack;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.522 -0500", hash_original_method = "7621B01EBEE0D0CEF34FD8A655C3B087", hash_generated_method = "4F7A84D645306C3358A6D9D541225DB4")
    
@Override
    public boolean canSeekForward() {
        return mCanSeekForward;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.524 -0500", hash_original_method = "5712A5AFCA7A8FC23B7D8D35D8488604", hash_generated_method = "0824E837C076630396EF937D98B2FDFD")
    
@Override
    public int getBufferPercentage() {
        if (mPlayer != null) {
            return mCurrentBufferPercentage;
        }
    return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.532 -0500", hash_original_method = "6CF96CE118939EE02746CF132717D00A", hash_generated_method = "5F1F49AB9E8AE5A39AFA621533B66954")
    
@Override
    public boolean onTouch(View v, MotionEvent event) {
        if (mFullScreenMode >= FULLSCREEN_SURFACECREATED
                && mMediaController != null) {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:17.535 -0500", hash_original_method = "768EF74C7E083D9FE3529A6C9E69F9F8", hash_generated_method = "4201002C4A38A2A60166FDDBCE83A2C3")
    
@Override
    protected void switchProgressView(boolean playerBuffering) {
        if (mProgressView != null) {
            if (playerBuffering) {
                mProgressView.setVisibility(View.VISIBLE);
            } else {
                mProgressView.setVisibility(View.GONE);
            }
        }
        return;
    }
}

