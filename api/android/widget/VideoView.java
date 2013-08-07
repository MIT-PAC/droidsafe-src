package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.Metadata;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController.MediaPlayerControl;





public class VideoView extends SurfaceView implements MediaPlayerControl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "CE75D1B054E16C63898691B02166B900", hash_generated_field = "C9C0A5B85686F17E8711EF81CEC90335")

    private String TAG = "VideoView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "BC598BB4DAC69C7D648657659FC9439B", hash_generated_field = "4E176381525D5CA440B5E063BC147908")

    private int mCurrentState = STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "28E7E66C06E7FB4BBAB97FBC40DBBFA6", hash_generated_field = "4ED5FCE6F3964D27DFE3048DB6A5A581")

    private int mTargetState = STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "6072A5355110211D8AD992A1E8763595", hash_generated_field = "846D019DBE1F3FC208D26AE6B51E7E7A")

    private SurfaceHolder mSurfaceHolder = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "DFC521A793828BDCECEBBE3FEC625B99", hash_generated_field = "4FEFABA7425402F743E354E21A00A144")

    private MediaPlayer mMediaPlayer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "ECDB7D63CE89453B0D96E6DC96178AAB", hash_generated_field = "1681CCE3F2816C80096F4BC1589307A6")

    private int mVideoWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "BF03935A9A0E39D0F45DBB78BE93B589", hash_generated_field = "4EA21094A26D2FB68A0C1EF72DA153C9")

    private int mVideoHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.141 -0400", hash_original_field = "0CBB906C5C0CA5C67E75A47AE741C464", hash_generated_field = "06A067A8647045AA4B52E753B7C97AA9")

    private int mSurfaceWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "CCA26F5480341D918006932F3B411411", hash_generated_field = "80231A972E82BEAD6BA6B233E4BF7C56")

    private int mSurfaceHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "A57983EA22A29D716213C2400D6F1D7A", hash_generated_field = "FFE64F26EAFE41C0717BC03DFAEF93DE")

    private MediaController mMediaController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "58EDA864F1A796AFB176C7FB07AA20E0", hash_generated_field = "EC9BCCBF3C86489E298221F5D4476C58")

    private OnCompletionListener mOnCompletionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "A5799EF941029779B8612CAB38609700", hash_generated_field = "0C4D61659F6E158734A6B77EB1739CA6")

    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "1873B2B1AC18422B33460DFB5D5CB345", hash_generated_field = "DE5AC282D1679F4F6686171A7EFF5F7A")

    private int mCurrentBufferPercentage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "8E38E8F2821E37DC1388D37AC12A00C5", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "4F55720660481A1587DCC83FD025E95D", hash_generated_field = "D9B315654ED4F1447587B54B57E51DC5")

    private int mSeekWhenPrepared;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "9A4623B61542BEC8D3E426C93DD77346", hash_generated_field = "F1E27FDEF752AF3B6AFE206F5E8D273F")

    private boolean mCanPause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "260CDABACB2B7A4C6F8B739A9531399D", hash_generated_field = "F0F23120A5CAF86AFF0F96CAE67D6030")

    private boolean mCanSeekBack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.142 -0400", hash_original_field = "1042AFD5E2128CC06471C1ED59799B06", hash_generated_field = "AD1D51CB83FA72C2D49574CD80EEB438")

    private boolean mCanSeekForward;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.143 -0400", hash_original_field = "1A7718F51A40911C6FE34A2288BFE12E", hash_generated_field = "CD2EDE786D0496A44DCE542DE41FFB17")

    MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.143 -0400", hash_original_method = "65C1900C93D820BA1B5709EC480BC8B9", hash_generated_method = "5A0376C9D05473741310A687D0A1D905")
        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(height);
            addTaint(width);
            addTaint(mp.getTaint());
            mVideoWidth = mp.getVideoWidth();
            mVideoHeight = mp.getVideoHeight();
            if(mVideoWidth != 0 && mVideoHeight != 0)            
            {
                getHolder().setFixedSize(mVideoWidth, mVideoHeight);
            } //End block
            // ---------- Original Method ----------
            //mVideoWidth = mp.getVideoWidth();
            //mVideoHeight = mp.getVideoHeight();
            //if (mVideoWidth != 0 && mVideoHeight != 0) {
                    //getHolder().setFixedSize(mVideoWidth, mVideoHeight);
                //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.146 -0400", hash_original_field = "6FA998399DAAAB96682C792379375439", hash_generated_field = "A6C46A6F86887F5A8FF30D809BE323AE")

    MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.145 -0400", hash_original_method = "0EF132CA9B43E797B9141E33932ED66A", hash_generated_method = "AF4648378D610AEF2F0F11C8233E2476")
        public void onPrepared(MediaPlayer mp) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(mp.getTaint());
            mCurrentState = STATE_PREPARED;
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
            if(mOnPreparedListener != null)            
            {
                mOnPreparedListener.onPrepared(mMediaPlayer);
            } //End block
            if(mMediaController != null)            
            {
                mMediaController.setEnabled(true);
            } //End block
            mVideoWidth = mp.getVideoWidth();
            mVideoHeight = mp.getVideoHeight();
            int seekToPosition = mSeekWhenPrepared;
            if(seekToPosition != 0)            
            {
                seekTo(seekToPosition);
            } //End block
            if(mVideoWidth != 0 && mVideoHeight != 0)            
            {
                getHolder().setFixedSize(mVideoWidth, mVideoHeight);
                if(mSurfaceWidth == mVideoWidth && mSurfaceHeight == mVideoHeight)                
                {
                    if(mTargetState == STATE_PLAYING)                    
                    {
                        start();
                        if(mMediaController != null)                        
                        {
                            mMediaController.show();
                        } //End block
                    } //End block
                    else
                    if(!isPlaying() &&
                               (seekToPosition != 0 || getCurrentPosition() > 0))                    
                    {
                        if(mMediaController != null)                        
                        {
                            mMediaController.show(0);
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
            {
                if(mTargetState == STATE_PLAYING)                
                {
                    start();
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.148 -0400", hash_original_field = "ED3CF789A31884E6ADAFA1D223558FAA", hash_generated_field = "2F31C8D08A7A8EEB4881A3B657E505CB")

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.148 -0400", hash_original_method = "ED920C0310CF61207D5F50C29A8DA263", hash_generated_method = "ABC2887D7206852167C55B84DACFB566")
        public void onCompletion(MediaPlayer mp) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(mp.getTaint());
            mCurrentState = STATE_PLAYBACK_COMPLETED;
            mTargetState = STATE_PLAYBACK_COMPLETED;
            if(mMediaController != null)            
            {
                mMediaController.hide();
            } //End block
            if(mOnCompletionListener != null)            
            {
                mOnCompletionListener.onCompletion(mMediaPlayer);
            } //End block
            // ---------- Original Method ----------
            //mCurrentState = STATE_PLAYBACK_COMPLETED;
            //mTargetState = STATE_PLAYBACK_COMPLETED;
            //if (mMediaController != null) {
                //mMediaController.hide();
            //}
            //if (mOnCompletionListener != null) {
                //mOnCompletionListener.onCompletion(mMediaPlayer);
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.151 -0400", hash_original_field = "3E68D0EC14257091AA025E7697E4D6A5", hash_generated_field = "363D54F68F59F0A0A38E0ABC176EF573")

    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.151 -0400", hash_original_method = "184ED7C09E4A303ABD8AE77B83A95A83", hash_generated_method = "34A7333DF3E85D757A358398D8CCB8B5")
        public boolean onError(MediaPlayer mp, int framework_err, int impl_err) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(impl_err);
            addTaint(framework_err);
            addTaint(mp.getTaint());
            Log.d(TAG, "Error: " + framework_err + "," + impl_err);
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
            if(mMediaController != null)            
            {
                mMediaController.hide();
            } //End block
            if(mOnErrorListener != null)            
            {
                if(mOnErrorListener.onError(mMediaPlayer, framework_err, impl_err))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1531830454 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140292406 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140292406;
                } //End block
            } //End block
            if(getWindowToken() != null)            
            {
                Resources r = mContext.getResources();
                int messageId;
                if(framework_err == MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK)                
                {
                    messageId = com.android.internal.R.string.VideoView_error_text_invalid_progressive_playback;
                } //End block
                else
                {
                    messageId = com.android.internal.R.string.VideoView_error_text_unknown;
                } //End block
                new AlertDialog.Builder(mContext)
                        .setTitle(com.android.internal.R.string.VideoView_error_title)
                        .setMessage(messageId)
                        .setPositiveButton(com.android.internal.R.string.VideoView_error_button,
                                new DialogInterface.OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.151 -0400", hash_original_method = "34424E1DFACB91566F8A1492C534FD5D", hash_generated_method = "85AE64EA9C14DCFDC773171C3D5E8347")
            public void onClick(DialogInterface dialog, int whichButton) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(whichButton);
                addTaint(dialog.getTaint());
                if(mOnCompletionListener != null)                
                {
                    mOnCompletionListener.onCompletion(mMediaPlayer);
                } //End block
                // ---------- Original Method ----------
                //if (mOnCompletionListener != null) {
                                            //mOnCompletionListener.onCompletion(mMediaPlayer);
                                        //}
            }
})
                        .setCancelable(false)
                        .show();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1431547122 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866672917 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_866672917;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.152 -0400", hash_original_field = "586F4A1CD959A521D8527F9D0DB7C837", hash_generated_field = "C6CDD3D40A42176310D2EA261BFD0698")

    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.152 -0400", hash_original_method = "16726F937605C6D0A73F251CECEE924B", hash_generated_method = "CAC6A4464B81DB183B5DDB584F5B66EB")
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(percent);
            addTaint(mp.getTaint());
            mCurrentBufferPercentage = percent;
            // ---------- Original Method ----------
            //mCurrentBufferPercentage = percent;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.155 -0400", hash_original_field = "95FF723B307E523297040401AEF7D7E6", hash_generated_field = "0369BDB4F6FE064FC2DACE8B422983D1")

    SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.153 -0400", hash_original_method = "59E6557DD0B959EA22EB5495D7EEA0EC", hash_generated_method = "3075542F7EFFC0339A991CD787F55263")
        public void surfaceChanged(SurfaceHolder holder, int format,
                                    int w, int h) {
            addTaint(h);
            addTaint(w);
            addTaint(format);
            addTaint(holder.getTaint());
            mSurfaceWidth = w;
            mSurfaceHeight = h;
            boolean isValidState = (mTargetState == STATE_PLAYING);
            boolean hasValidSize = (mVideoWidth == w && mVideoHeight == h);
            if(mMediaPlayer != null && isValidState && hasValidSize)            
            {
                if(mSeekWhenPrepared != 0)                
                {
                    seekTo(mSeekWhenPrepared);
                } //End block
                start();
            } //End block
            // ---------- Original Method ----------
            //mSurfaceWidth = w;
            //mSurfaceHeight = h;
            //boolean isValidState =  (mTargetState == STATE_PLAYING);
            //boolean hasValidSize = (mVideoWidth == w && mVideoHeight == h);
            //if (mMediaPlayer != null && isValidState && hasValidSize) {
                //if (mSeekWhenPrepared != 0) {
                    //seekTo(mSeekWhenPrepared);
                //}
                //start();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.154 -0400", hash_original_method = "3EDB4DEF9F778EE739B69F60EF0D2C92", hash_generated_method = "7AF4F5551ED1F6DB75C8A30B536A4699")
        public void surfaceCreated(SurfaceHolder holder) {
            addTaint(holder.getTaint());
            mSurfaceHolder = holder;
            openVideo();
            // ---------- Original Method ----------
            //mSurfaceHolder = holder;
            //openVideo();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.154 -0400", hash_original_method = "C2C5AB5140CC805E21FE518BD1FAEE6B", hash_generated_method = "03BE065F14AB47B609E741B9D5B60644")
        public void surfaceDestroyed(SurfaceHolder holder) {
            addTaint(holder.getTaint());
            mSurfaceHolder = null;
            if(mMediaController != null)            
            mMediaController.hide();
            release(true);
            // ---------- Original Method ----------
            //mSurfaceHolder = null;
            //if (mMediaController != null) mMediaController.hide();
            //release(true);
        }

        
};
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.155 -0400", hash_original_method = "84429BD4462769BE0107008470199557", hash_generated_method = "AD9C68C2945985C0871C1EE019319C9E")
    public  VideoView(Context context) {
        super(context);
        addTaint(context.getTaint());
        initVideoView();
        // ---------- Original Method ----------
        //initVideoView();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.155 -0400", hash_original_method = "9DA181463C1E3F8A8538BD444B82D669", hash_generated_method = "161454C144DF2289EAD7D4CCA9C21B6C")
    public  VideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initVideoView();
        // ---------- Original Method ----------
        //initVideoView();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.155 -0400", hash_original_method = "424FE4A877CF5C3A8D4BF3ED46B161CB", hash_generated_method = "A028DEC9CB2FB9A1AD2E5FEEFB4C54E9")
    public  VideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initVideoView();
        // ---------- Original Method ----------
        //initVideoView();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.156 -0400", hash_original_method = "399D33D7F524FC7B17B9973DF2D06AB6", hash_generated_method = "6E4AAD1C389460645763C98FA261FB00")
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
            else
            {
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
            //} else {
            //}
        //}
        //setMeasuredDimension(width, height);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.157 -0400", hash_original_method = "AA7DEE010D080A3F173498ECD8DB46CF", hash_generated_method = "1D0B5DB9A0B939E1B72936771EAAB006")
    public int resolveAdjustedSize(int desiredSize, int measureSpec) {
        addTaint(measureSpec);
        addTaint(desiredSize);
        int result = desiredSize;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
switch(specMode){
        case MeasureSpec.UNSPECIFIED:
        result = desiredSize;
        break;
        case MeasureSpec.AT_MOST:
        result = Math.min(desiredSize, specSize);
        break;
        case MeasureSpec.EXACTLY:
        result = specSize;
        break;
}        int varB4A88417B3D0170D754C647C30B7216A_1993818432 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817161037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817161037;
        // ---------- Original Method ----------
        //int result = desiredSize;
        //int specMode = MeasureSpec.getMode(measureSpec);
        //int specSize =  MeasureSpec.getSize(measureSpec);
        //switch (specMode) {
            //case MeasureSpec.UNSPECIFIED:
                //result = desiredSize;
                //break;
            //case MeasureSpec.AT_MOST:
                //result = Math.min(desiredSize, specSize);
                //break;
            //case MeasureSpec.EXACTLY:
                //result = specSize;
                //break;
        //}
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.158 -0400", hash_original_method = "BE85099A7AB9FDC5F9372F356FE70764", hash_generated_method = "D4EE1143999D59A12455EFD43719BE38")
    private void initVideoView() {
        mVideoWidth = 0;
        mVideoHeight = 0;
        getHolder().addCallback(mSHCallback);
        getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        mCurrentState = STATE_IDLE;
        mTargetState  = STATE_IDLE;
        // ---------- Original Method ----------
        //mVideoWidth = 0;
        //mVideoHeight = 0;
        //getHolder().addCallback(mSHCallback);
        //getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        //setFocusable(true);
        //setFocusableInTouchMode(true);
        //requestFocus();
        //mCurrentState = STATE_IDLE;
        //mTargetState  = STATE_IDLE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.159 -0400", hash_original_method = "FF7D3C0BAB1201EED63B4915116CA68A", hash_generated_method = "95164628E4AA5A48FA56C4666AF0D853")
    public void setVideoPath(String path) {
        addTaint(path.getTaint());
        setVideoURI(Uri.parse(path));
        // ---------- Original Method ----------
        //setVideoURI(Uri.parse(path));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.159 -0400", hash_original_method = "145B809162AC001B5D3448C75D9513F9", hash_generated_method = "6FEF308FD150ABD03EA089803542F5BB")
    public void setVideoURI(Uri uri) {
        addTaint(uri.getTaint());
        setVideoURI(uri, null);
        // ---------- Original Method ----------
        //setVideoURI(uri, null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.160 -0400", hash_original_method = "B0B8C66B3B0796135E0E0BD2E6D5E306", hash_generated_method = "88A06A4237B4C404B85728812147EBE1")
    public void setVideoURI(Uri uri, Map<String, String> headers) {
        mUri = uri;
        mHeaders = headers;
        mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
        // ---------- Original Method ----------
        //mUri = uri;
        //mHeaders = headers;
        //mSeekWhenPrepared = 0;
        //openVideo();
        //requestLayout();
        //invalidate();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.160 -0400", hash_original_method = "2BCECBBC48AF079CEFBE62EF5059D1F2", hash_generated_method = "3B66AC856C5F0C0203627C516CD32CEB")
    public void stopPlayback() {
        if(mMediaPlayer != null)        
        {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = STATE_IDLE;
            mTargetState  = STATE_IDLE;
        } //End block
        // ---------- Original Method ----------
        //if (mMediaPlayer != null) {
            //mMediaPlayer.stop();
            //mMediaPlayer.release();
            //mMediaPlayer = null;
            //mCurrentState = STATE_IDLE;
            //mTargetState  = STATE_IDLE;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.160 -0400", hash_original_method = "4401AC32A9DAF43DD0875A239764A2D5", hash_generated_method = "750156031A414222D79F960D9F7906CC")
    private void openVideo() {
        if(mUri == null || mSurfaceHolder == null)        
        {
            return;
        } //End block
        Intent i = new Intent("com.android.music.musicservicecommand");
        i.putExtra("command", "pause");
        mContext.sendBroadcast(i);
        release(false);
        try 
        {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setOnPreparedListener(mPreparedListener);
            mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
            mDuration = -1;
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
            mMediaPlayer.setOnErrorListener(mErrorListener);
            mMediaPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
            mCurrentBufferPercentage = 0;
            mMediaPlayer.setDataSource(mContext, mUri, mHeaders);
            mMediaPlayer.setDisplay(mSurfaceHolder);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setScreenOnWhilePlaying(true);
            mMediaPlayer.prepareAsync();
            mCurrentState = STATE_PREPARING;
            attachMediaController();
        } //End block
        catch (IOException ex)
        {
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
            mErrorListener.onError(mMediaPlayer, MediaPlayer.MEDIA_ERROR_UNKNOWN, 0);
            return;
        } //End block
        catch (IllegalArgumentException ex)
        {
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
            mErrorListener.onError(mMediaPlayer, MediaPlayer.MEDIA_ERROR_UNKNOWN, 0);
            return;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.161 -0400", hash_original_method = "A95D4CD6952F3C4C3839054BE152713C", hash_generated_method = "6D11B93EC781274E33DFC905F915B539")
    public void setMediaController(MediaController controller) {
        if(mMediaController != null)        
        {
            mMediaController.hide();
        } //End block
        mMediaController = controller;
        attachMediaController();
        // ---------- Original Method ----------
        //if (mMediaController != null) {
            //mMediaController.hide();
        //}
        //mMediaController = controller;
        //attachMediaController();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.161 -0400", hash_original_method = "4E9048D91253AD27AA53E4E66A36C9AD", hash_generated_method = "ACA4BFB4AF95A8F19B01F050AE7E0D1F")
    private void attachMediaController() {
        if(mMediaPlayer != null && mMediaController != null)        
        {
            mMediaController.setMediaPlayer(this);
            View anchorView = this.getParent() instanceof View ?
                    (View)this.getParent() : this;
            mMediaController.setAnchorView(anchorView);
            mMediaController.setEnabled(isInPlaybackState());
        } //End block
        // ---------- Original Method ----------
        //if (mMediaPlayer != null && mMediaController != null) {
            //mMediaController.setMediaPlayer(this);
            //View anchorView = this.getParent() instanceof View ?
                    //(View)this.getParent() : this;
            //mMediaController.setAnchorView(anchorView);
            //mMediaController.setEnabled(isInPlaybackState());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.162 -0400", hash_original_method = "D1A9D86A0084E612B3B59A1A4238CD00", hash_generated_method = "3710D8ED101BA92E0D7F5A21FDA53560")
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener l) {
        mOnPreparedListener = l;
        // ---------- Original Method ----------
        //mOnPreparedListener = l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.162 -0400", hash_original_method = "E72FB4A9E0939C099D3564FC711BE1EB", hash_generated_method = "3DEA5DC4F2B7AF9282FD8AA86CA654D0")
    public void setOnCompletionListener(OnCompletionListener l) {
        mOnCompletionListener = l;
        // ---------- Original Method ----------
        //mOnCompletionListener = l;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.162 -0400", hash_original_method = "1D9D4DF006E463AA131E1079BD21BB23", hash_generated_method = "F76228A81F30849808D6699A5C1AC6AA")
    public void setOnErrorListener(OnErrorListener l) {
        mOnErrorListener = l;
        // ---------- Original Method ----------
        //mOnErrorListener = l;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.163 -0400", hash_original_method = "99FF896B381D47748A631FF0CD5A79C0", hash_generated_method = "A79F037E170175C4699A27FB73531204")
    private void release(boolean cleartargetstate) {
        addTaint(cleartargetstate);
        if(mMediaPlayer != null)        
        {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = STATE_IDLE;
            if(cleartargetstate)            
            {
                mTargetState  = STATE_IDLE;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mMediaPlayer != null) {
            //mMediaPlayer.reset();
            //mMediaPlayer.release();
            //mMediaPlayer = null;
            //mCurrentState = STATE_IDLE;
            //if (cleartargetstate) {
                //mTargetState  = STATE_IDLE;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.163 -0400", hash_original_method = "4F4B3F8532DEC480E2D437E642010990", hash_generated_method = "880ACAB458BF1042B53915992C449143")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        if(isInPlaybackState() && mMediaController != null)        
        {
            toggleMediaControlsVisiblity();
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1326238562 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75696042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75696042;
        // ---------- Original Method ----------
        //if (isInPlaybackState() && mMediaController != null) {
            //toggleMediaControlsVisiblity();
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.164 -0400", hash_original_method = "8AF49D524D52FF5D4247E0FF5D02E5F0", hash_generated_method = "8C3017E95901C341AE8C8E5C2147D415")
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        if(isInPlaybackState() && mMediaController != null)        
        {
            toggleMediaControlsVisiblity();
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1218572474 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262204109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_262204109;
        // ---------- Original Method ----------
        //if (isInPlaybackState() && mMediaController != null) {
            //toggleMediaControlsVisiblity();
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.164 -0400", hash_original_method = "91A873FF1F5486FD2484C66FB73721D3", hash_generated_method = "E1FDA627572E0344F7F58D33F58A45C8")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean isKeyCodeSupported = keyCode != KeyEvent.KEYCODE_BACK &&
                                     keyCode != KeyEvent.KEYCODE_VOLUME_UP &&
                                     keyCode != KeyEvent.KEYCODE_VOLUME_DOWN &&
                                     keyCode != KeyEvent.KEYCODE_VOLUME_MUTE &&
                                     keyCode != KeyEvent.KEYCODE_MENU &&
                                     keyCode != KeyEvent.KEYCODE_CALL &&
                                     keyCode != KeyEvent.KEYCODE_ENDCALL;
        if(isInPlaybackState() && isKeyCodeSupported && mMediaController != null)        
        {
            if(keyCode == KeyEvent.KEYCODE_HEADSETHOOK ||
                    keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE)            
            {
                if(mMediaPlayer.isPlaying())                
                {
                    pause();
                    mMediaController.show();
                } //End block
                else
                {
                    start();
                    mMediaController.hide();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1151754873 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_994210402 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_994210402;
            } //End block
            else
            if(keyCode == KeyEvent.KEYCODE_MEDIA_PLAY)            
            {
                if(!mMediaPlayer.isPlaying())                
                {
                    start();
                    mMediaController.hide();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1153192086 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941459211 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941459211;
            } //End block
            else
            if(keyCode == KeyEvent.KEYCODE_MEDIA_STOP
                    || keyCode == KeyEvent.KEYCODE_MEDIA_PAUSE)            
            {
                if(mMediaPlayer.isPlaying())                
                {
                    pause();
                    mMediaController.show();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_616839940 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89293815 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_89293815;
            } //End block
            else
            {
                toggleMediaControlsVisiblity();
            } //End block
        } //End block
        boolean var947F0C250323B9F4475E02588E9A9740_394740061 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784609746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784609746;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.165 -0400", hash_original_method = "E102D2D0B33B8C0648E23B09161A5D91", hash_generated_method = "3FD9697155F837AC56FFFC09091C9312")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.165 -0400", hash_original_method = "DCAF238577388FDC9C26BFC1EEC7C15B", hash_generated_method = "9B73F7BCC30ECAC0BE2F192EEA0E3970")
    public void start() {
        if(isInPlaybackState())        
        {
            mMediaPlayer.start();
            mCurrentState = STATE_PLAYING;
        } //End block
        mTargetState = STATE_PLAYING;
        // ---------- Original Method ----------
        //if (isInPlaybackState()) {
            //mMediaPlayer.start();
            //mCurrentState = STATE_PLAYING;
        //}
        //mTargetState = STATE_PLAYING;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.166 -0400", hash_original_method = "4E2568FAF00FE360235DA18D47EB8EFF", hash_generated_method = "F3EB6CC2CAA6BE2BADB4E3488172B5E4")
    public void pause() {
        if(isInPlaybackState())        
        {
            if(mMediaPlayer.isPlaying())            
            {
                mMediaPlayer.pause();
                mCurrentState = STATE_PAUSED;
            } //End block
        } //End block
        mTargetState = STATE_PAUSED;
        // ---------- Original Method ----------
        //if (isInPlaybackState()) {
            //if (mMediaPlayer.isPlaying()) {
                //mMediaPlayer.pause();
                //mCurrentState = STATE_PAUSED;
            //}
        //}
        //mTargetState = STATE_PAUSED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.166 -0400", hash_original_method = "DB957E41439183A7A4B3F0D26130031C", hash_generated_method = "4898C2CBA953708EFFAC9A29E3A7A14C")
    public void suspend() {
        release(false);
        // ---------- Original Method ----------
        //release(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.166 -0400", hash_original_method = "E6E0A392D25FFAD71752A274562CC374", hash_generated_method = "D12BA13D773BAF0D6B22978BCBFC4335")
    public void resume() {
        openVideo();
        // ---------- Original Method ----------
        //openVideo();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.166 -0400", hash_original_method = "C1F40EE967CAE2C17948E71A2C41731D", hash_generated_method = "20386CCA735054C249718BF9C53CF231")
    public int getDuration() {
        if(isInPlaybackState())        
        {
            if(mDuration > 0)            
            {
                int var25395741BFE51A7D136A5C7109AAD2D8_1495181223 = (mDuration);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_812246308 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_812246308;
            } //End block
            mDuration = mMediaPlayer.getDuration();
            int var25395741BFE51A7D136A5C7109AAD2D8_659493981 = (mDuration);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549352184 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549352184;
        } //End block
        mDuration = -1;
        int var25395741BFE51A7D136A5C7109AAD2D8_2054404744 = (mDuration);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125976454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125976454;
        // ---------- Original Method ----------
        //if (isInPlaybackState()) {
            //if (mDuration > 0) {
                //return mDuration;
            //}
            //mDuration = mMediaPlayer.getDuration();
            //return mDuration;
        //}
        //mDuration = -1;
        //return mDuration;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "0795537A6D4F5DB67695C2A0F229C436", hash_generated_method = "2DA1852B92E30DF4D6C573DAB7E89003")
    public int getCurrentPosition() {
        if(isInPlaybackState())        
        {
            int var61A7926289BB780333BFB82793EA442D_585403837 = (mMediaPlayer.getCurrentPosition());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088922518 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088922518;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1133572804 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052077926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052077926;
        // ---------- Original Method ----------
        //if (isInPlaybackState()) {
            //return mMediaPlayer.getCurrentPosition();
        //}
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "3522617D91D50F05724CD0F38556C102", hash_generated_method = "B888166677814165658FC8F7EB5B5488")
    public void seekTo(int msec) {
        if(isInPlaybackState())        
        {
            mMediaPlayer.seekTo(msec);
            mSeekWhenPrepared = 0;
        } //End block
        else
        {
            mSeekWhenPrepared = msec;
        } //End block
        // ---------- Original Method ----------
        //if (isInPlaybackState()) {
            //mMediaPlayer.seekTo(msec);
            //mSeekWhenPrepared = 0;
        //} else {
            //mSeekWhenPrepared = msec;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "E0052DEB6F83AF3161983588D34DAB58", hash_generated_method = "3281FBAAF004DBBAA339138C2B3479B8")
    public boolean isPlaying() {
        boolean var8AEA42665765075ED010C2544315DC0F_2000481591 = (isInPlaybackState() && mMediaPlayer.isPlaying());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70088993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70088993;
        // ---------- Original Method ----------
        //return isInPlaybackState() && mMediaPlayer.isPlaying();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "FEBDDA350C03AAA5C15557B944427C9D", hash_generated_method = "54EAFB6BA065EB68688158178B3E97D0")
    public int getBufferPercentage() {
        if(mMediaPlayer != null)        
        {
            int var1873B2B1AC18422B33460DFB5D5CB345_1351656457 = (mCurrentBufferPercentage);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142745559 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_142745559;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_39734155 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171751493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171751493;
        // ---------- Original Method ----------
        //if (mMediaPlayer != null) {
            //return mCurrentBufferPercentage;
        //}
        //return 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "181624277C30FCEFD8B4CC029FACB2EE", hash_generated_method = "848DAE07A8B7659C54E3121118D4D53D")
    private boolean isInPlaybackState() {
        boolean var1C53704901E4033DF3FE8CE3B2EB3177_314261898 = ((mMediaPlayer != null &&
                mCurrentState != STATE_ERROR &&
                mCurrentState != STATE_IDLE &&
                mCurrentState != STATE_PREPARING));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867303231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867303231;
        // ---------- Original Method ----------
        //return (mMediaPlayer != null &&
                //mCurrentState != STATE_ERROR &&
                //mCurrentState != STATE_IDLE &&
                //mCurrentState != STATE_PREPARING);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "1DF27838EDEF437B2494B2DF149883EF", hash_generated_method = "BE3424ADDEAE28E5477BA85891CFBF0B")
    public boolean canPause() {
        boolean var9A4623B61542BEC8D3E426C93DD77346_1212796758 = (mCanPause);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894809030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_894809030;
        // ---------- Original Method ----------
        //return mCanPause;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "B916F92CBCCEC1C42038C36AAFFAA2A8", hash_generated_method = "049923351BECC0DE7BE16FC0000C7E43")
    public boolean canSeekBackward() {
        boolean var260CDABACB2B7A4C6F8B739A9531399D_618534737 = (mCanSeekBack);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202066073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202066073;
        // ---------- Original Method ----------
        //return mCanSeekBack;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.167 -0400", hash_original_method = "7621B01EBEE0D0CEF34FD8A655C3B087", hash_generated_method = "DE605ACF66C03604668420114E595529")
    public boolean canSeekForward() {
        boolean var1042AFD5E2128CC06471C1ED59799B06_326130909 = (mCanSeekForward);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_849027398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_849027398;
        // ---------- Original Method ----------
        //return mCanSeekForward;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.168 -0400", hash_original_field = "133FD24D629CFFD4E730B4E7513E117A", hash_generated_field = "6B005C8EBE8994279368951B4E210396")

    private static final int STATE_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.168 -0400", hash_original_field = "AEBCB16EA0142CCECDCE720235105004", hash_generated_field = "31A5ECBA709672BB7BAE010B1E1C3954")

    private static final int STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.168 -0400", hash_original_field = "9D23DC0D9A4CA01D1250BEFEE7712999", hash_generated_field = "CEB20AC92434E2026643E8549016B6C2")

    private static final int STATE_PREPARING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.168 -0400", hash_original_field = "95BFE9F657F45E05E13CA2B88A7E534C", hash_generated_field = "78095842E468B1AD54CE7DD2EADC098B")

    private static final int STATE_PREPARED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.168 -0400", hash_original_field = "F8E97D8069CEFFD6F193B01736254DA5", hash_generated_field = "EDB6898AF5557ECE8F7E39E37B1273A0")

    private static final int STATE_PLAYING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.168 -0400", hash_original_field = "A2EFD406F70488BC2BDBE84FB4BC47DB", hash_generated_field = "610665E644AB42267234233BBC59A26D")

    private static final int STATE_PAUSED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.168 -0400", hash_original_field = "F178E75866E6679F5A2239C5E7F7FA01", hash_generated_field = "389983E3069BF0C5742DDB1C6CB61964")

    private static final int STATE_PLAYBACK_COMPLETED = 5;
}

