package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.657 -0500", hash_original_field = "AA32BA63E0527427A516BA30E06A641F", hash_generated_field = "6B005C8EBE8994279368951B4E210396")

    private static final int STATE_ERROR              = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.659 -0500", hash_original_field = "E39B828D2E7A099E9F830BC3FBD507AA", hash_generated_field = "31A5ECBA709672BB7BAE010B1E1C3954")

    private static final int STATE_IDLE               = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.661 -0500", hash_original_field = "55E01EB5875E1B03EA637BF98E90492D", hash_generated_field = "CEB20AC92434E2026643E8549016B6C2")

    private static final int STATE_PREPARING          = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.665 -0500", hash_original_field = "B0A3E1DC3514CB87DD4786EA7A2009BC", hash_generated_field = "78095842E468B1AD54CE7DD2EADC098B")

    private static final int STATE_PREPARED           = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.667 -0500", hash_original_field = "22F45C47A0AA05081B66E40F5D8E467E", hash_generated_field = "EDB6898AF5557ECE8F7E39E37B1273A0")

    private static final int STATE_PLAYING            = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.669 -0500", hash_original_field = "6EB7B3D07810BA0F41BADB7FA86168EF", hash_generated_field = "610665E644AB42267234233BBC59A26D")

    private static final int STATE_PAUSED             = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.672 -0500", hash_original_field = "8E914AC3C3C7E9B5A2CAC0049F432D40", hash_generated_field = "389983E3069BF0C5742DDB1C6CB61964")

    private static final int STATE_PLAYBACK_COMPLETED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.648 -0500", hash_original_field = "2B12018EE18B6E557469737C4CEE8792", hash_generated_field = "C9C0A5B85686F17E8711EF81CEC90335")

    private String TAG = "VideoView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.650 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri         mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.652 -0500", hash_original_field = "A7D525FA609C0F6270055E985F097B79", hash_generated_field = "A366B1C8ECA0EA3E5C2DAE5F1AFFA05D")

    private Map<String, String> mHeaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.654 -0500", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int         mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.674 -0500", hash_original_field = "F7FE8C9388B03D663E53119AE02645EA", hash_generated_field = "EB53FB0671B2A3CC2AF2AA72DC660045")

    // mTargetState is the state that a method caller intends to reach.
    // For instance, regardless the VideoView object's current state,
    // calling pause() intends to bring the object to a target state
    // of STATE_PAUSED.
    private int mCurrentState = STATE_IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.676 -0500", hash_original_field = "69BC41692C9E6A385577A8191A210195", hash_generated_field = "4ED5FCE6F3964D27DFE3048DB6A5A581")

    private int mTargetState  = STATE_IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.678 -0500", hash_original_field = "E1BBA50B0E1B0B19BA81ABEA42AC80AC", hash_generated_field = "846D019DBE1F3FC208D26AE6B51E7E7A")

    private SurfaceHolder mSurfaceHolder = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.680 -0500", hash_original_field = "BB777191FCA4BDD5784AD3881AAE2CF5", hash_generated_field = "4FEFABA7425402F743E354E21A00A144")

    private MediaPlayer mMediaPlayer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.682 -0500", hash_original_field = "66CA0547E4B7B3C9D451FC50BB40A818", hash_generated_field = "1681CCE3F2816C80096F4BC1589307A6")

    private int         mVideoWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.684 -0500", hash_original_field = "40CDF20752F82AFF4C53ED5C029BD20A", hash_generated_field = "4EA21094A26D2FB68A0C1EF72DA153C9")

    private int         mVideoHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.686 -0500", hash_original_field = "8DDD8ECA6EF0D69185482874B25B8769", hash_generated_field = "06A067A8647045AA4B52E753B7C97AA9")

    private int         mSurfaceWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.688 -0500", hash_original_field = "3B9D5AB05109DF0551403C1F69658C1A", hash_generated_field = "80231A972E82BEAD6BA6B233E4BF7C56")

    private int         mSurfaceHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.690 -0500", hash_original_field = "C243BEDAA5C901F23F1B05843DE73EEF", hash_generated_field = "FFE64F26EAFE41C0717BC03DFAEF93DE")

    private MediaController mMediaController;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.692 -0500", hash_original_field = "06A6FF6127C3C38B2E227EA62CA452A2", hash_generated_field = "EC9BCCBF3C86489E298221F5D4476C58")

    private OnCompletionListener mOnCompletionListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.695 -0500", hash_original_field = "103BF8F0DB743E25FBEB59618239E725", hash_generated_field = "0C4D61659F6E158734A6B77EB1739CA6")

    private MediaPlayer.OnPreparedListener mOnPreparedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.697 -0500", hash_original_field = "2DBF12F39B1FFA506F8E14E0F4BA535B", hash_generated_field = "DE5AC282D1679F4F6686171A7EFF5F7A")

    private int         mCurrentBufferPercentage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.699 -0500", hash_original_field = "C38C52334F0DC8BAE5DDF67054F8F272", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.701 -0500", hash_original_field = "1E356275BBAB0614B08A8D98530253F4", hash_generated_field = "D9B315654ED4F1447587B54B57E51DC5")

    private int         mSeekWhenPrepared;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.703 -0500", hash_original_field = "BE046AB8724C45B3CAF310B1CBA73120", hash_generated_field = "F1E27FDEF752AF3B6AFE206F5E8D273F")

    private boolean     mCanPause;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.705 -0500", hash_original_field = "64865A3AEA54610F6680FA90E5F48714", hash_generated_field = "F0F23120A5CAF86AFF0F96CAE67D6030")

    private boolean     mCanSeekBack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.708 -0500", hash_original_field = "4542E0113701637133AFC3EB2F5FA344", hash_generated_field = "AD1D51CB83FA72C2D49574CD80EEB438")

    private boolean     mCanSeekForward;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.143 -0400", hash_original_field = "1A7718F51A40911C6FE34A2288BFE12E", hash_generated_field = "CD2EDE786D0496A44DCE542DE41FFB17")

    MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.743 -0500", hash_original_method = "65C1900C93D820BA1B5709EC480BC8B9", hash_generated_method = "5CA401A91BCF944169B3F0930204739E")
        
public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                mVideoWidth = mp.getVideoWidth();
                mVideoHeight = mp.getVideoHeight();
                if (mVideoWidth != 0 && mVideoHeight != 0) {
                    getHolder().setFixedSize(mVideoWidth, mVideoHeight);
                }
            }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.146 -0400", hash_original_field = "6FA998399DAAAB96682C792379375439", hash_generated_field = "A6C46A6F86887F5A8FF30D809BE323AE")

    MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.750 -0500", hash_original_method = "0EF132CA9B43E797B9141E33932ED66A", hash_generated_method = "D305B85F5AC7B0A4F8327190BDF78150")
        
public void onPrepared(MediaPlayer mp) {
            mCurrentState = STATE_PREPARED;

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

            if (mOnPreparedListener != null) {
                mOnPreparedListener.onPrepared(mMediaPlayer);
            }
            if (mMediaController != null) {
                mMediaController.setEnabled(true);
            }
            mVideoWidth = mp.getVideoWidth();
            mVideoHeight = mp.getVideoHeight();

            int seekToPosition = mSeekWhenPrepared;  // mSeekWhenPrepared may be changed after seekTo() call
            if (seekToPosition != 0) {
                seekTo(seekToPosition);
            }
            if (mVideoWidth != 0 && mVideoHeight != 0) {
                //Log.i("@@@@", "video size: " + mVideoWidth +"/"+ mVideoHeight);
                getHolder().setFixedSize(mVideoWidth, mVideoHeight);
                if (mSurfaceWidth == mVideoWidth && mSurfaceHeight == mVideoHeight) {
                    // We didn't actually change the size (it was already at the size
                    // we need), so we won't get a "surface changed" callback, so
                    // start the video here instead of in the callback.
                    if (mTargetState == STATE_PLAYING) {
                        start();
                        if (mMediaController != null) {
                            mMediaController.show();
                        }
                    } else if (!isPlaying() &&
                               (seekToPosition != 0 || getCurrentPosition() > 0)) {
                       if (mMediaController != null) {
                           // Show the media controls when we're paused into a video and make 'em stick.
                           mMediaController.show(0);
                       }
                   }
                }
            } else {
                // We don't know the video size yet, but should start anyway.
                // The video size might be reported to us later.
                if (mTargetState == STATE_PLAYING) {
                    start();
                }
            }
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.148 -0400", hash_original_field = "ED3CF789A31884E6ADAFA1D223558FAA", hash_generated_field = "2F31C8D08A7A8EEB4881A3B657E505CB")

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.756 -0500", hash_original_method = "ED920C0310CF61207D5F50C29A8DA263", hash_generated_method = "871CF1672E22EA6EF75BE99147B2F0B3")
        
public void onCompletion(MediaPlayer mp) {
            mCurrentState = STATE_PLAYBACK_COMPLETED;
            mTargetState = STATE_PLAYBACK_COMPLETED;
            if (mMediaController != null) {
                mMediaController.hide();
            }
            if (mOnCompletionListener != null) {
                mOnCompletionListener.onCompletion(mMediaPlayer);
            }
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.151 -0400", hash_original_field = "3E68D0EC14257091AA025E7697E4D6A5", hash_generated_field = "363D54F68F59F0A0A38E0ABC176EF573")

    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.766 -0500", hash_original_method = "184ED7C09E4A303ABD8AE77B83A95A83", hash_generated_method = "99BE4FBF0AC1E5CBC22C9720645C92F6")
        
public boolean onError(MediaPlayer mp, int framework_err, int impl_err) {
            Log.d(TAG, "Error: " + framework_err + "," + impl_err);
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
            if (mMediaController != null) {
                mMediaController.hide();
            }

            /* If an error handler has been supplied, use it and finish. */
            if (mOnErrorListener != null) {
                if (mOnErrorListener.onError(mMediaPlayer, framework_err, impl_err)) {
                    return true;
                }
            }

            /* Otherwise, pop up an error dialog so the user knows that
             * something bad has happened. Only try and pop up the dialog
             * if we're attached to a window. When we're going away and no
             * longer have a window, don't bother showing the user an error.
             */
            if (getWindowToken() != null) {
                Resources r = mContext.getResources();
                int messageId;

                if (framework_err == MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK) {
                    messageId = com.android.internal.R.string.VideoView_error_text_invalid_progressive_playback;
                } else {
                    messageId = com.android.internal.R.string.VideoView_error_text_unknown;
                }

                new AlertDialog.Builder(mContext)
                        .setTitle(com.android.internal.R.string.VideoView_error_title)
                        .setMessage(messageId)
                        .setPositiveButton(com.android.internal.R.string.VideoView_error_button,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        /* If we get here, there is no onError listener, so
                                         * at least inform them that the video is over.
                                         */
                                        if (mOnCompletionListener != null) {
                                            mOnCompletionListener.onCompletion(mMediaPlayer);
                                        }
                                    }
                                })
                        .setCancelable(false)
                        .show();
            }
            return true;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.152 -0400", hash_original_field = "586F4A1CD959A521D8527F9D0DB7C837", hash_generated_field = "C6CDD3D40A42176310D2EA261BFD0698")

    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.772 -0500", hash_original_method = "16726F937605C6D0A73F251CECEE924B", hash_generated_method = "77BFA175675E1FBE15B9D670C7DF7D9F")
        
public void onBufferingUpdate(MediaPlayer mp, int percent) {
            mCurrentBufferPercentage = percent;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.155 -0400", hash_original_field = "95FF723B307E523297040401AEF7D7E6", hash_generated_field = "0369BDB4F6FE064FC2DACE8B422983D1")

    SurfaceHolder.Callback mSHCallback = new SurfaceHolder.Callback() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.784 -0500", hash_original_method = "59E6557DD0B959EA22EB5495D7EEA0EC", hash_generated_method = "EFC5CBDE0EBE94B54BEC6805C6F8EEA4")
        
public void surfaceChanged(SurfaceHolder holder, int format,
                                    int w, int h)
        {
            mSurfaceWidth = w;
            mSurfaceHeight = h;
            boolean isValidState =  (mTargetState == STATE_PLAYING);
            boolean hasValidSize = (mVideoWidth == w && mVideoHeight == h);
            if (mMediaPlayer != null && isValidState && hasValidSize) {
                if (mSeekWhenPrepared != 0) {
                    seekTo(mSeekWhenPrepared);
                }
                start();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.786 -0500", hash_original_method = "3EDB4DEF9F778EE739B69F60EF0D2C92", hash_generated_method = "9BD518EEEB1645B22A9D0617966740ED")
        
public void surfaceCreated(SurfaceHolder holder)
        {
            mSurfaceHolder = holder;
            openVideo();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.788 -0500", hash_original_method = "C2C5AB5140CC805E21FE518BD1FAEE6B", hash_generated_method = "CF76E4DD88DABCDB3F5C0AC520E945B6")
        
public void surfaceDestroyed(SurfaceHolder holder)
        {
            // after we return from this we can't use the surface any more
            mSurfaceHolder = null;
            if (mMediaController != null) mMediaController.hide();
            release(true);
        }

        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.710 -0500", hash_original_method = "84429BD4462769BE0107008470199557", hash_generated_method = "D419452986F58FA2C07BB22660FCDA16")
    
public VideoView(Context context) {
        super(context);
        initVideoView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.713 -0500", hash_original_method = "9DA181463C1E3F8A8538BD444B82D669", hash_generated_method = "014787D126A1C04F68EB494859288C0E")
    
public VideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initVideoView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.715 -0500", hash_original_method = "424FE4A877CF5C3A8D4BF3ED46B161CB", hash_generated_method = "E6755EA68A3830AF33892F6DC3E92839")
    
public VideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initVideoView();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.718 -0500", hash_original_method = "399D33D7F524FC7B17B9973DF2D06AB6", hash_generated_method = "854FB58340B5B4CEA22D6CC5EBC9B6C4")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //Log.i("@@@@", "onMeasure");
        int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
        int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
        if (mVideoWidth > 0 && mVideoHeight > 0) {
            if ( mVideoWidth * height  > width * mVideoHeight ) {
                //Log.i("@@@", "image too tall, correcting");
                height = width * mVideoHeight / mVideoWidth;
            } else if ( mVideoWidth * height  < width * mVideoHeight ) {
                //Log.i("@@@", "image too wide, correcting");
                width = height * mVideoWidth / mVideoHeight;
            } else {
                //Log.i("@@@", "aspect ratio is correct: " +
                        //width+"/"+height+"="+
                        //mVideoWidth+"/"+mVideoHeight);
            }
        }
        //Log.i("@@@@@@@@@@", "setting size: " + width + 'x' + height);
        setMeasuredDimension(width, height);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.720 -0500", hash_original_method = "AA7DEE010D080A3F173498ECD8DB46CF", hash_generated_method = "E9CC7E6EBF385513B90CF1B2F81ABCBB")
    
public int resolveAdjustedSize(int desiredSize, int measureSpec) {
        int result = desiredSize;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize =  MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                /* Parent says we can be as big as we want. Just don't be larger
                 * than max size imposed on ourselves.
                 */
                result = desiredSize;
                break;

            case MeasureSpec.AT_MOST:
                /* Parent says we can be as big as we want, up to specSize.
                 * Don't be larger than specSize, and don't be larger than
                 * the max size imposed on ourselves.
                 */
                result = Math.min(desiredSize, specSize);
                break;

            case MeasureSpec.EXACTLY:
                // No choice. Do what we are told.
                result = specSize;
                break;
        }
        return result;
}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.722 -0500", hash_original_method = "BE85099A7AB9FDC5F9372F356FE70764", hash_generated_method = "5FDEE21DE38A14A407B383FEAECF4089")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.724 -0500", hash_original_method = "FF7D3C0BAB1201EED63B4915116CA68A", hash_generated_method = "F35268F14E7AFAC02756F635A19682C9")
    
public void setVideoPath(String path) {
        setVideoURI(Uri.parse(path));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.726 -0500", hash_original_method = "145B809162AC001B5D3448C75D9513F9", hash_generated_method = "1B2C0DB4F375C7541DA23E33848CE746")
    
public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.729 -0500", hash_original_method = "B0B8C66B3B0796135E0E0BD2E6D5E306", hash_generated_method = "C446C689B6D788FA2FD5E81CA16E0770")
    
public void setVideoURI(Uri uri, Map<String, String> headers) {
        mUri = uri;
        mHeaders = headers;
        mSeekWhenPrepared = 0;
        openVideo();
        requestLayout();
        invalidate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.732 -0500", hash_original_method = "2BCECBBC48AF079CEFBE62EF5059D1F2", hash_generated_method = "E05A72D0E7393920D5A975CF90D0B5AA")
    
public void stopPlayback() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = STATE_IDLE;
            mTargetState  = STATE_IDLE;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.735 -0500", hash_original_method = "4401AC32A9DAF43DD0875A239764A2D5", hash_generated_method = "ACDEF9183AB22BE081DB989542B01F46")
    
private void openVideo() {
        if (mUri == null || mSurfaceHolder == null) {
            // not ready for playback just yet, will try again later
            return;
        }
        // Tell the music playback service to pause
        // TODO: these constants need to be published somewhere in the framework.
        Intent i = new Intent("com.android.music.musicservicecommand");
        i.putExtra("command", "pause");
        mContext.sendBroadcast(i);

        // we shouldn't clear the target state, because somebody might have
        // called start() previously
        release(false);
        try {
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
            // we don't set the target state here either, but preserve the
            // target state that was there before.
            mCurrentState = STATE_PREPARING;
            attachMediaController();
        } catch (IOException ex) {
            Log.w(TAG, "Unable to open content: " + mUri, ex);
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
            mErrorListener.onError(mMediaPlayer, MediaPlayer.MEDIA_ERROR_UNKNOWN, 0);
            return;
        } catch (IllegalArgumentException ex) {
            Log.w(TAG, "Unable to open content: " + mUri, ex);
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
            mErrorListener.onError(mMediaPlayer, MediaPlayer.MEDIA_ERROR_UNKNOWN, 0);
            return;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.737 -0500", hash_original_method = "A95D4CD6952F3C4C3839054BE152713C", hash_generated_method = "5FDB60AB5E24EBE14C2EB94776D5E284")
    
public void setMediaController(MediaController controller) {
        if (mMediaController != null) {
            mMediaController.hide();
        }
        mMediaController = controller;
        attachMediaController();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.740 -0500", hash_original_method = "4E9048D91253AD27AA53E4E66A36C9AD", hash_generated_method = "05DEC7217773A09DAD0162440FB49642")
    
private void attachMediaController() {
        if (mMediaPlayer != null && mMediaController != null) {
            mMediaController.setMediaPlayer(this);
            View anchorView = this.getParent() instanceof View ?
                    (View)this.getParent() : this;
            mMediaController.setAnchorView(anchorView);
            mMediaController.setEnabled(isInPlaybackState());
        }
    }

    /**
     * Register a callback to be invoked when the media file
     * is loaded and ready to go.
     *
     * @param l The callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.777 -0500", hash_original_method = "D1A9D86A0084E612B3B59A1A4238CD00", hash_generated_method = "C017A99C96589FF5CD5FC26F13496F26")
    
public void setOnPreparedListener(MediaPlayer.OnPreparedListener l)
    {
        mOnPreparedListener = l;
    }

    /**
     * Register a callback to be invoked when the end of a media file
     * has been reached during playback.
     *
     * @param l The callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.779 -0500", hash_original_method = "E72FB4A9E0939C099D3564FC711BE1EB", hash_generated_method = "56EF9777CF687A5EF2F63E987236C467")
    
public void setOnCompletionListener(OnCompletionListener l)
    {
        mOnCompletionListener = l;
    }

    /**
     * Register a callback to be invoked when an error occurs
     * during playback or setup.  If no listener is specified,
     * or if the listener returned false, VideoView will inform
     * the user of any errors.
     *
     * @param l The callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.781 -0500", hash_original_method = "1D9D4DF006E463AA131E1079BD21BB23", hash_generated_method = "D2226C2AEE46E386CEEAE20829BB160C")
    
public void setOnErrorListener(OnErrorListener l)
    {
        mOnErrorListener = l;
    }

    /*
     * release the media player in any state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.793 -0500", hash_original_method = "99FF896B381D47748A631FF0CD5A79C0", hash_generated_method = "F2E61E873D06AB1255B5128E6D67AF80")
    
private void release(boolean cleartargetstate) {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = STATE_IDLE;
            if (cleartargetstate) {
                mTargetState  = STATE_IDLE;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.796 -0500", hash_original_method = "4F4B3F8532DEC480E2D437E642010990", hash_generated_method = "E553B93678264A4E5026632917F84686")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isInPlaybackState() && mMediaController != null) {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.798 -0500", hash_original_method = "8AF49D524D52FF5D4247E0FF5D02E5F0", hash_generated_method = "2DE181A73BF9DC78EE288FD4FF15E686")
    
@Override
    public boolean onTrackballEvent(MotionEvent ev) {
        if (isInPlaybackState() && mMediaController != null) {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.801 -0500", hash_original_method = "91A873FF1F5486FD2484C66FB73721D3", hash_generated_method = "4393D6FDF2A3619228871AF0ED28A0A3")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        boolean isKeyCodeSupported = keyCode != KeyEvent.KEYCODE_BACK &&
                                     keyCode != KeyEvent.KEYCODE_VOLUME_UP &&
                                     keyCode != KeyEvent.KEYCODE_VOLUME_DOWN &&
                                     keyCode != KeyEvent.KEYCODE_VOLUME_MUTE &&
                                     keyCode != KeyEvent.KEYCODE_MENU &&
                                     keyCode != KeyEvent.KEYCODE_CALL &&
                                     keyCode != KeyEvent.KEYCODE_ENDCALL;
        if (isInPlaybackState() && isKeyCodeSupported && mMediaController != null) {
            if (keyCode == KeyEvent.KEYCODE_HEADSETHOOK ||
                    keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE) {
                if (mMediaPlayer.isPlaying()) {
                    pause();
                    mMediaController.show();
                } else {
                    start();
                    mMediaController.hide();
                }
                return true;
            } else if (keyCode == KeyEvent.KEYCODE_MEDIA_PLAY) {
                if (!mMediaPlayer.isPlaying()) {
                    start();
                    mMediaController.hide();
                }
                return true;
            } else if (keyCode == KeyEvent.KEYCODE_MEDIA_STOP
                    || keyCode == KeyEvent.KEYCODE_MEDIA_PAUSE) {
                if (mMediaPlayer.isPlaying()) {
                    pause();
                    mMediaController.show();
                }
                return true;
            } else {
                toggleMediaControlsVisiblity();
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.803 -0500", hash_original_method = "E102D2D0B33B8C0648E23B09161A5D91", hash_generated_method = "117B787CDC5EAA33653E35830F63BC2F")
    
private void toggleMediaControlsVisiblity() {
        if (mMediaController.isShowing()) {
            mMediaController.hide();
        } else {
            mMediaController.show();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.805 -0500", hash_original_method = "DCAF238577388FDC9C26BFC1EEC7C15B", hash_generated_method = "872BC7D9520AA3BF732701B75C4425C0")
    
public void start() {
        if (isInPlaybackState()) {
            mMediaPlayer.start();
            mCurrentState = STATE_PLAYING;
        }
        mTargetState = STATE_PLAYING;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.808 -0500", hash_original_method = "4E2568FAF00FE360235DA18D47EB8EFF", hash_generated_method = "4519A5D9FAF6948CEB46F9B582FE5A59")
    
public void pause() {
        if (isInPlaybackState()) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.pause();
                mCurrentState = STATE_PAUSED;
            }
        }
        mTargetState = STATE_PAUSED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.810 -0500", hash_original_method = "DB957E41439183A7A4B3F0D26130031C", hash_generated_method = "AB2D3051160285DD1D42A74A74F3CDD1")
    
public void suspend() {
        release(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.812 -0500", hash_original_method = "E6E0A392D25FFAD71752A274562CC374", hash_generated_method = "5A91188CDDB57ACD70BC432C1899287C")
    
public void resume() {
        openVideo();
    }

    // cache duration as mDuration for faster access
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.814 -0500", hash_original_method = "C1F40EE967CAE2C17948E71A2C41731D", hash_generated_method = "A649601A52D505DD00BC0F60E29669E4")
    
public int getDuration() {
        if (isInPlaybackState()) {
            if (mDuration > 0) {
                return mDuration;
            }
            mDuration = mMediaPlayer.getDuration();
            return mDuration;
        }
        mDuration = -1;
        return mDuration;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.816 -0500", hash_original_method = "0795537A6D4F5DB67695C2A0F229C436", hash_generated_method = "2CB25376E75EBBD3D5C7ED29508C8590")
    
public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.818 -0500", hash_original_method = "3522617D91D50F05724CD0F38556C102", hash_generated_method = "9FCBC19A9A45945C24AEE48E956728DE")
    
public void seekTo(int msec) {
        if (isInPlaybackState()) {
            mMediaPlayer.seekTo(msec);
            mSeekWhenPrepared = 0;
        } else {
            mSeekWhenPrepared = msec;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.821 -0500", hash_original_method = "E0052DEB6F83AF3161983588D34DAB58", hash_generated_method = "9D1BCED499AEC453514AD56256F0CA1A")
    
public boolean isPlaying() {
        return isInPlaybackState() && mMediaPlayer.isPlaying();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.823 -0500", hash_original_method = "FEBDDA350C03AAA5C15557B944427C9D", hash_generated_method = "58A79B210E234FAED8A0D28C0D1B6B1E")
    
public int getBufferPercentage() {
        if (mMediaPlayer != null) {
            return mCurrentBufferPercentage;
        }
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.825 -0500", hash_original_method = "181624277C30FCEFD8B4CC029FACB2EE", hash_generated_method = "ED16C580D7BB9789EACC029EB3106496")
    
private boolean isInPlaybackState() {
        return (mMediaPlayer != null &&
                mCurrentState != STATE_ERROR &&
                mCurrentState != STATE_IDLE &&
                mCurrentState != STATE_PREPARING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.827 -0500", hash_original_method = "1DF27838EDEF437B2494B2DF149883EF", hash_generated_method = "72E89334CF9AAE1EC8E3E869548973AF")
    
public boolean canPause() {
        return mCanPause;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.829 -0500", hash_original_method = "B916F92CBCCEC1C42038C36AAFFAA2A8", hash_generated_method = "E94C9243E319F80C6BBAA81D8F9C6FFA")
    
public boolean canSeekBackward() {
        return mCanSeekBack;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:55.832 -0500", hash_original_method = "7621B01EBEE0D0CEF34FD8A655C3B087", hash_generated_method = "DC022B91E8B1E2F38DF6961EC161DFE8")
    
public boolean canSeekForward() {
        return mCanSeekForward;
    }
}

