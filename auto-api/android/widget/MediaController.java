package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.android.internal.policy.PolicyManager;
import java.util.Formatter;
import java.util.Locale;

public class MediaController extends FrameLayout {
    private MediaPlayerControl  mPlayer;
    private Context             mContext;
    private View                mAnchor;
    private View                mRoot;
    private WindowManager       mWindowManager;
    private Window              mWindow;
    private View                mDecor;
    private WindowManager.LayoutParams mDecorLayoutParams;
    private ProgressBar         mProgress;
    private TextView            mEndTime, mCurrentTime;
    private boolean             mShowing;
    private boolean             mDragging;
    private boolean             mUseFastForward;
    private boolean             mFromXml;
    private boolean             mListenersSet;
    private View.OnClickListener mNextListener, mPrevListener;
    StringBuilder               mFormatBuilder;
    Formatter                   mFormatter;
    private ImageButton         mPauseButton;
    private ImageButton         mFfwdButton;
    private ImageButton         mRewButton;
    private ImageButton         mNextButton;
    private ImageButton         mPrevButton;
    private OnLayoutChangeListener mLayoutChangeListener = new OnLayoutChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.788 -0400", hash_original_method = "B906B3E54DBAAD427317F640A60E799C", hash_generated_method = "809ECCD97ADDAD286A89260B10E31B28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onLayoutChange(View v, int left, int top, int right,
                int bottom, int oldLeft, int oldTop, int oldRight,
                int oldBottom) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(oldLeft);
            dsTaint.addTaint(oldBottom);
            dsTaint.addTaint(oldRight);
            dsTaint.addTaint(bottom);
            dsTaint.addTaint(left);
            dsTaint.addTaint(right);
            dsTaint.addTaint(oldTop);
            dsTaint.addTaint(top);
            updateFloatingWindowLayout();
            {
                mWindowManager.updateViewLayout(mDecor, mDecorLayoutParams);
            } //End block
            // ---------- Original Method ----------
            //updateFloatingWindowLayout();
            //if (mShowing) {
                //mWindowManager.updateViewLayout(mDecor, mDecorLayoutParams);
            //}
        }

        
}; //Transformed anonymous class
    private OnTouchListener mTouchListener = new OnTouchListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.788 -0400", hash_original_method = "16F82C3AF10F7CC437B6D7BEE6D0DC69", hash_generated_method = "AAAF7FC386FD99D9A9FD164479D4098C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onTouch(View v, MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(event.dsTaint);
            {
                boolean var1FBD87715268F23D17D833CE81073212_744046251 = (event.getAction() == MotionEvent.ACTION_DOWN);
                {
                    {
                        hide();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //if (mShowing) {
                    //hide();
                //}
            //}
            //return false;
        }

        
}; //Transformed anonymous class
    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.788 -0400", hash_original_method = "8F0BA1F98715C95935AC2F391AEFF8BC", hash_generated_method = "E38A2B80D57A2074D10C2AB7B7E33BAF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            int pos;
            //Begin case FADE_OUT 
            hide();
            //End case FADE_OUT 
            //Begin case SHOW_PROGRESS 
            pos = setProgress();
            //End case SHOW_PROGRESS 
            //Begin case SHOW_PROGRESS 
            {
                boolean var35D9B4E6001F9970817DCA22BC2D906C_1322059204 = (!mDragging && mShowing && mPlayer.isPlaying());
                {
                    msg = obtainMessage(SHOW_PROGRESS);
                    sendMessageDelayed(msg, 1000 - (pos % 1000));
                } //End block
            } //End collapsed parenthetic
            //End case SHOW_PROGRESS 
            // ---------- Original Method ----------
            //int pos;
            //switch (msg.what) {
                //case FADE_OUT:
                    //hide();
                    //break;
                //case SHOW_PROGRESS:
                    //pos = setProgress();
                    //if (!mDragging && mShowing && mPlayer.isPlaying()) {
                        //msg = obtainMessage(SHOW_PROGRESS);
                        //sendMessageDelayed(msg, 1000 - (pos % 1000));
                    //}
                    //break;
            //}
        }

        
}; //Transformed anonymous class
    private View.OnClickListener mPauseListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.788 -0400", hash_original_method = "F90DC617061E164BAEBDBFB1EA5D02BB", hash_generated_method = "91298A1C7715CB103DE207D88E402F49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            doPauseResume();
            show(sDefaultTimeout);
            // ---------- Original Method ----------
            //doPauseResume();
            //show(sDefaultTimeout);
        }

        
}; //Transformed anonymous class
    private OnSeekBarChangeListener mSeekListener = new OnSeekBarChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.789 -0400", hash_original_method = "6758392684DBD95D44B26F154F80CA94", hash_generated_method = "A1AB80BB5852BE1E9D9349A53889AD30")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onStartTrackingTouch(SeekBar bar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(bar.dsTaint);
            show(3600000);
            mDragging = true;
            mHandler.removeMessages(SHOW_PROGRESS);
            // ---------- Original Method ----------
            //show(3600000);
            //mDragging = true;
            //mHandler.removeMessages(SHOW_PROGRESS);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.789 -0400", hash_original_method = "A0EB029A26053134120EC96D7E9882E8", hash_generated_method = "4EE678B8CEE0527A50B0F5EE6DBE9A0C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(progress);
            dsTaint.addTaint(fromuser);
            dsTaint.addTaint(bar.dsTaint);
            long duration;
            duration = mPlayer.getDuration();
            long newposition;
            newposition = (duration * progress) / 1000L;
            mPlayer.seekTo( (int) newposition);
            mCurrentTime.setText(stringForTime( (int) newposition));
            // ---------- Original Method ----------
            //if (!fromuser) {
                //return;
            //}
            //long duration = mPlayer.getDuration();
            //long newposition = (duration * progress) / 1000L;
            //mPlayer.seekTo( (int) newposition);
            //if (mCurrentTime != null)
                //mCurrentTime.setText(stringForTime( (int) newposition));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.789 -0400", hash_original_method = "53B60B6767600F274A52648AF75E3493", hash_generated_method = "B0C46C53278D8334A7EF6C42A062C6CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onStopTrackingTouch(SeekBar bar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(bar.dsTaint);
            mDragging = false;
            setProgress();
            updatePausePlay();
            show(sDefaultTimeout);
            mHandler.sendEmptyMessage(SHOW_PROGRESS);
            // ---------- Original Method ----------
            //mDragging = false;
            //setProgress();
            //updatePausePlay();
            //show(sDefaultTimeout);
            //mHandler.sendEmptyMessage(SHOW_PROGRESS);
        }

        
}; //Transformed anonymous class
    private View.OnClickListener mRewListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.789 -0400", hash_original_method = "B5D53DC8A12E02793B3EF0C8511F70D5", hash_generated_method = "A08195D449C8FF28E9AE94A741451882")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            int pos;
            pos = mPlayer.getCurrentPosition();
            pos -= 5000;
            mPlayer.seekTo(pos);
            setProgress();
            show(sDefaultTimeout);
            // ---------- Original Method ----------
            //int pos = mPlayer.getCurrentPosition();
            //pos -= 5000;
            //mPlayer.seekTo(pos);
            //setProgress();
            //show(sDefaultTimeout);
        }

        
}; //Transformed anonymous class
    private View.OnClickListener mFfwdListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.790 -0400", hash_original_method = "BF054D35499B7B032734EBAD3598DA2F", hash_generated_method = "70E85AF27EA5262FBCFC4EECB2115E21")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            int pos;
            pos = mPlayer.getCurrentPosition();
            pos += 15000;
            mPlayer.seekTo(pos);
            setProgress();
            show(sDefaultTimeout);
            // ---------- Original Method ----------
            //int pos = mPlayer.getCurrentPosition();
            //pos += 15000;
            //mPlayer.seekTo(pos);
            //setProgress();
            //show(sDefaultTimeout);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.790 -0400", hash_original_method = "3C97480952764669863839416E96E876", hash_generated_method = "BD997BD4AD1D9965B901241F29BE6BCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mRoot = this;
        mUseFastForward = true;
        mFromXml = true;
        // ---------- Original Method ----------
        //mRoot = this;
        //mContext = context;
        //mUseFastForward = true;
        //mFromXml = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.790 -0400", hash_original_method = "D7A2F0702C06D7B537ED0824ED57856A", hash_generated_method = "84D858DE5C86CCA4F1A96623FCA48698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MediaController(Context context, boolean useFastForward) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(useFastForward);
        initFloatingWindowLayout();
        initFloatingWindow();
        // ---------- Original Method ----------
        //mContext = context;
        //mUseFastForward = useFastForward;
        //initFloatingWindowLayout();
        //initFloatingWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.790 -0400", hash_original_method = "7386C8F43CBDAAD1A4C1AD10A9F3EB18", hash_generated_method = "95FCF03A97D78B8B0590B3CEF43AEF9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MediaController(Context context) {
        this(context, true);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.790 -0400", hash_original_method = "73B20F41AD38A9B689CAB773B229DC2D", hash_generated_method = "5065BD46B7C5F2139BCBE70E1A5E9581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initControllerView(mRoot);
        // ---------- Original Method ----------
        //if (mRoot != null)
            //initControllerView(mRoot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.791 -0400", hash_original_method = "5AB721CF8AD66EE5762FE50902543B8E", hash_generated_method = "23191FD52B96F9E7404E05B0D03554AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFloatingWindow() {
        mWindowManager = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        mWindow = PolicyManager.makeNewWindow(mContext);
        mWindow.setWindowManager(mWindowManager, null, null);
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        mDecor = mWindow.getDecorView();
        mDecor.setOnTouchListener(mTouchListener);
        mWindow.setContentView(this);
        mWindow.setBackgroundDrawableResource(android.R.color.transparent);
        mWindow.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
        requestFocus();
        // ---------- Original Method ----------
        //mWindowManager = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        //mWindow = PolicyManager.makeNewWindow(mContext);
        //mWindow.setWindowManager(mWindowManager, null, null);
        //mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        //mDecor = mWindow.getDecorView();
        //mDecor.setOnTouchListener(mTouchListener);
        //mWindow.setContentView(this);
        //mWindow.setBackgroundDrawableResource(android.R.color.transparent);
        //mWindow.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        //setFocusable(true);
        //setFocusableInTouchMode(true);
        //setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
        //requestFocus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.791 -0400", hash_original_method = "A15216BA04857F16D27E94A01ED8D9C8", hash_generated_method = "17BE4F9613FD542D16205973D3B48E9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFloatingWindowLayout() {
        mDecorLayoutParams = new WindowManager.LayoutParams();
        WindowManager.LayoutParams p;
        p = mDecorLayoutParams;
        p.gravity = Gravity.TOP;
        p.height = LayoutParams.WRAP_CONTENT;
        p.x = 0;
        p.format = PixelFormat.TRANSLUCENT;
        p.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        p.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
        p.token = null;
        p.windowAnimations = 0;
        // ---------- Original Method ----------
        //mDecorLayoutParams = new WindowManager.LayoutParams();
        //WindowManager.LayoutParams p = mDecorLayoutParams;
        //p.gravity = Gravity.TOP;
        //p.height = LayoutParams.WRAP_CONTENT;
        //p.x = 0;
        //p.format = PixelFormat.TRANSLUCENT;
        //p.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        //p.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                //| WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                //| WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
        //p.token = null;
        //p.windowAnimations = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.791 -0400", hash_original_method = "273528B94A02173E736183C73352565A", hash_generated_method = "632D4E6BC23514C0A110F17AE75F3F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateFloatingWindowLayout() {
        int [] anchorPos;
        anchorPos = new int[2];
        mAnchor.getLocationOnScreen(anchorPos);
        WindowManager.LayoutParams p;
        p = mDecorLayoutParams;
        p.width = mAnchor.getWidth();
        p.y = anchorPos[1] + mAnchor.getHeight();
        // ---------- Original Method ----------
        //int [] anchorPos = new int[2];
        //mAnchor.getLocationOnScreen(anchorPos);
        //WindowManager.LayoutParams p = mDecorLayoutParams;
        //p.width = mAnchor.getWidth();
        //p.y = anchorPos[1] + mAnchor.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.791 -0400", hash_original_method = "9E3EB1A0CE9430F92BE04C3BC9E64024", hash_generated_method = "F5BDFB2E353CFA7BBD57971D375F526B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMediaPlayer(MediaPlayerControl player) {
        dsTaint.addTaint(player.dsTaint);
        updatePausePlay();
        // ---------- Original Method ----------
        //mPlayer = player;
        //updatePausePlay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.792 -0400", hash_original_method = "A3367E3EA3926FFA5E8601886A545624", hash_generated_method = "225BE7177C8AF88B0FF4595F8AFE1199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAnchorView(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            mAnchor.removeOnLayoutChangeListener(mLayoutChangeListener);
        } //End block
        {
            mAnchor.addOnLayoutChangeListener(mLayoutChangeListener);
        } //End block
        FrameLayout.LayoutParams frameParams;
        frameParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        removeAllViews();
        View v;
        v = makeControllerView();
        addView(v, frameParams);
        // ---------- Original Method ----------
        //if (mAnchor != null) {
            //mAnchor.removeOnLayoutChangeListener(mLayoutChangeListener);
        //}
        //mAnchor = view;
        //if (mAnchor != null) {
            //mAnchor.addOnLayoutChangeListener(mLayoutChangeListener);
        //}
        //FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
                //ViewGroup.LayoutParams.MATCH_PARENT
        //);
        //removeAllViews();
        //View v = makeControllerView();
        //addView(v, frameParams);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.792 -0400", hash_original_method = "47AAB8ACF83F9E0950F4FC2EF0028588", hash_generated_method = "937773D99A34555C3ECABB1A8C956F06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View makeControllerView() {
        LayoutInflater inflate;
        inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRoot = inflate.inflate(com.android.internal.R.layout.media_controller, null);
        initControllerView(mRoot);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LayoutInflater inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //mRoot = inflate.inflate(com.android.internal.R.layout.media_controller, null);
        //initControllerView(mRoot);
        //return mRoot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.793 -0400", hash_original_method = "6027E965805CA7D75D241C044D75CFC3", hash_generated_method = "5BA1519BAFC4F35AD22858728E3C105D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initControllerView(View v) {
        dsTaint.addTaint(v.dsTaint);
        mPauseButton = (ImageButton) v.findViewById(com.android.internal.R.id.pause);
        {
            mPauseButton.requestFocus();
            mPauseButton.setOnClickListener(mPauseListener);
        } //End block
        mFfwdButton = (ImageButton) v.findViewById(com.android.internal.R.id.ffwd);
        {
            mFfwdButton.setOnClickListener(mFfwdListener);
            {
                mFfwdButton.setVisibility(mUseFastForward ? View.VISIBLE : View.GONE);
            } //End block
        } //End block
        mRewButton = (ImageButton) v.findViewById(com.android.internal.R.id.rew);
        {
            mRewButton.setOnClickListener(mRewListener);
            {
                mRewButton.setVisibility(mUseFastForward ? View.VISIBLE : View.GONE);
            } //End block
        } //End block
        mNextButton = (ImageButton) v.findViewById(com.android.internal.R.id.next);
        {
            mNextButton.setVisibility(View.GONE);
        } //End block
        mPrevButton = (ImageButton) v.findViewById(com.android.internal.R.id.prev);
        {
            mPrevButton.setVisibility(View.GONE);
        } //End block
        mProgress = (ProgressBar) v.findViewById(com.android.internal.R.id.mediacontroller_progress);
        {
            {
                SeekBar seeker;
                seeker = (SeekBar) mProgress;
                seeker.setOnSeekBarChangeListener(mSeekListener);
            } //End block
            mProgress.setMax(1000);
        } //End block
        mEndTime = (TextView) v.findViewById(com.android.internal.R.id.time);
        mCurrentTime = (TextView) v.findViewById(com.android.internal.R.id.time_current);
        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        installPrevNextListeners();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.793 -0400", hash_original_method = "F96F3B42B5EBC38D2746BE6361617E40", hash_generated_method = "5CD112AEC01E8D805545E23D791EAB4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        show(sDefaultTimeout);
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.793 -0400", hash_original_method = "4DD833D5B8F1F18277B038D9576E3A42", hash_generated_method = "EC697D716EA9733422BEB2C9879660D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void disableUnsupportedButtons() {
        try 
        {
            {
                boolean var04420E786547552434EA412F4670514B_1553782418 = (mPauseButton != null && !mPlayer.canPause());
                {
                    mPauseButton.setEnabled(false);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFB4189471DF28B1D9A20DFA7E064DD07_2038440028 = (mRewButton != null && !mPlayer.canSeekBackward());
                {
                    mRewButton.setEnabled(false);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBD8FEE18503E03CF186AC55EA6F38B48_1572449783 = (mFfwdButton != null && !mPlayer.canSeekForward());
                {
                    mFfwdButton.setEnabled(false);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IncompatibleClassChangeError ex)
        { }
        // ---------- Original Method ----------
        //try {
            //if (mPauseButton != null && !mPlayer.canPause()) {
                //mPauseButton.setEnabled(false);
            //}
            //if (mRewButton != null && !mPlayer.canSeekBackward()) {
                //mRewButton.setEnabled(false);
            //}
            //if (mFfwdButton != null && !mPlayer.canSeekForward()) {
                //mFfwdButton.setEnabled(false);
            //}
        //} catch (IncompatibleClassChangeError ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.794 -0400", hash_original_method = "C16367489FF99029DA16F545FE506814", hash_generated_method = "B8A0545EA799278038BDD5B7619A42DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show(int timeout) {
        dsTaint.addTaint(timeout);
        {
            setProgress();
            {
                mPauseButton.requestFocus();
            } //End block
            disableUnsupportedButtons();
            updateFloatingWindowLayout();
            mWindowManager.addView(mDecor, mDecorLayoutParams);
            mShowing = true;
        } //End block
        updatePausePlay();
        mHandler.sendEmptyMessage(SHOW_PROGRESS);
        Message msg;
        msg = mHandler.obtainMessage(FADE_OUT);
        {
            mHandler.removeMessages(FADE_OUT);
            mHandler.sendMessageDelayed(msg, timeout);
        } //End block
        // ---------- Original Method ----------
        //if (!mShowing && mAnchor != null) {
            //setProgress();
            //if (mPauseButton != null) {
                //mPauseButton.requestFocus();
            //}
            //disableUnsupportedButtons();
            //updateFloatingWindowLayout();
            //mWindowManager.addView(mDecor, mDecorLayoutParams);
            //mShowing = true;
        //}
        //updatePausePlay();
        //mHandler.sendEmptyMessage(SHOW_PROGRESS);
        //Message msg = mHandler.obtainMessage(FADE_OUT);
        //if (timeout != 0) {
            //mHandler.removeMessages(FADE_OUT);
            //mHandler.sendMessageDelayed(msg, timeout);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.794 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "A750A7C7A899819E05726851055511DF")
    @DSModeled(DSC.SAFE)
    public boolean isShowing() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.794 -0400", hash_original_method = "AF640FD924E8B1DADC076D8A3DA6C51B", hash_generated_method = "1F5C46428125BAD24C2F883E583D0333")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hide() {
        {
            try 
            {
                mHandler.removeMessages(SHOW_PROGRESS);
                mWindowManager.removeView(mDecor);
            } //End block
            catch (IllegalArgumentException ex)
            { }
            mShowing = false;
        } //End block
        // ---------- Original Method ----------
        //if (mAnchor == null)
            //return;
        //if (mShowing) {
            //try {
                //mHandler.removeMessages(SHOW_PROGRESS);
                //mWindowManager.removeView(mDecor);
            //} catch (IllegalArgumentException ex) {
                //Log.w("MediaController", "already removed");
            //}
            //mShowing = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.794 -0400", hash_original_method = "E3DEF3CD65DC2BEF1837B2236B56198B", hash_generated_method = "A1BABEA801CF90C7E8E3F7B1C4A564AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String stringForTime(int timeMs) {
        dsTaint.addTaint(timeMs);
        int totalSeconds;
        totalSeconds = timeMs / 1000;
        int seconds;
        seconds = totalSeconds % 60;
        int minutes;
        minutes = (totalSeconds / 60) % 60;
        int hours;
        hours = totalSeconds / 3600;
        mFormatBuilder.setLength(0);
        {
            String varA891BFF27044A433139D29A7B34E496D_496964402 = (mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString());
        } //End block
        {
            String var5119FD4E5B6DE265AFC2CC963D8FAD42_280879909 = (mFormatter.format("%02d:%02d", minutes, seconds).toString());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int totalSeconds = timeMs / 1000;
        //int seconds = totalSeconds % 60;
        //int minutes = (totalSeconds / 60) % 60;
        //int hours   = totalSeconds / 3600;
        //mFormatBuilder.setLength(0);
        //if (hours > 0) {
            //return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        //} else {
            //return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.795 -0400", hash_original_method = "972585652F798E535DB73510970F52DB", hash_generated_method = "B6B4DA244D4AF26BB01D0847FB89DC21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int setProgress() {
        int position;
        position = mPlayer.getCurrentPosition();
        int duration;
        duration = mPlayer.getDuration();
        {
            {
                long pos;
                pos = 1000L * position / duration;
                mProgress.setProgress( (int) pos);
            } //End block
            int percent;
            percent = mPlayer.getBufferPercentage();
            mProgress.setSecondaryProgress(percent * 10);
        } //End block
        mEndTime.setText(stringForTime(duration));
        mCurrentTime.setText(stringForTime(position));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mPlayer == null || mDragging) {
            //return 0;
        //}
        //int position = mPlayer.getCurrentPosition();
        //int duration = mPlayer.getDuration();
        //if (mProgress != null) {
            //if (duration > 0) {
                //long pos = 1000L * position / duration;
                //mProgress.setProgress( (int) pos);
            //}
            //int percent = mPlayer.getBufferPercentage();
            //mProgress.setSecondaryProgress(percent * 10);
        //}
        //if (mEndTime != null)
            //mEndTime.setText(stringForTime(duration));
        //if (mCurrentTime != null)
            //mCurrentTime.setText(stringForTime(position));
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.795 -0400", hash_original_method = "804998442429040CE8E4A7C248858770", hash_generated_method = "B8B43D88BF245A0259F01A64F3228414")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        show(sDefaultTimeout);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.795 -0400", hash_original_method = "294FBCC6A05258601D3163C3FD371667", hash_generated_method = "05F4F7E55767F790BD6A4125F6324536")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ev.dsTaint);
        show(sDefaultTimeout);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.796 -0400", hash_original_method = "F0666CB3DD2163E885B9F12838A0406B", hash_generated_method = "1BB07BD719DAB9DC93F1609FD24679AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        int keyCode;
        keyCode = event.getKeyCode();
        boolean uniqueDown;
        uniqueDown = event.getRepeatCount() == 0
                && event.getAction() == KeyEvent.ACTION_DOWN;
        {
            {
                doPauseResume();
                show(sDefaultTimeout);
                {
                    mPauseButton.requestFocus();
                } //End block
            } //End block
        } //End block
        {
            {
                boolean varF17116D0C67035A5A337856ABC12607F_585124217 = (uniqueDown && !mPlayer.isPlaying());
                {
                    mPlayer.start();
                    updatePausePlay();
                    show(sDefaultTimeout);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var27755F5C4D0C9AF06EFD67EBF4777196_1062194563 = (uniqueDown && mPlayer.isPlaying());
                {
                    mPlayer.pause();
                    updatePausePlay();
                    show(sDefaultTimeout);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_619811315 = (super.dispatchKeyEvent(event));
        } //End block
        {
            {
                hide();
            } //End block
        } //End block
        show(sDefaultTimeout);
        boolean varD8A05597F0CCFB3ED5A50CCF86C0200D_1986875724 = (super.dispatchKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.796 -0400", hash_original_method = "B0869F9835F79F721C7D9CE04C896B2B", hash_generated_method = "3CC1AE125E502F6D84558607CDAABBD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updatePausePlay() {
        {
            boolean var39B4349F3FF67B6FA000A266CC9AF48C_799077236 = (mPlayer.isPlaying());
            {
                mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_pause);
            } //End block
            {
                mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_play);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mRoot == null || mPauseButton == null)
            //return;
        //if (mPlayer.isPlaying()) {
            //mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_pause);
        //} else {
            //mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_play);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.796 -0400", hash_original_method = "F9113ED701E8317A61E1AB80861EF0B1", hash_generated_method = "5547027747EBEA83966F8F0E3D6B47EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doPauseResume() {
        {
            boolean var39B4349F3FF67B6FA000A266CC9AF48C_1720809908 = (mPlayer.isPlaying());
            {
                mPlayer.pause();
            } //End block
            {
                mPlayer.start();
            } //End block
        } //End collapsed parenthetic
        updatePausePlay();
        // ---------- Original Method ----------
        //if (mPlayer.isPlaying()) {
            //mPlayer.pause();
        //} else {
            //mPlayer.start();
        //}
        //updatePausePlay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.796 -0400", hash_original_method = "E14B391343AAAAC9B9A5DC8FE6A0AD92", hash_generated_method = "77A0B2D960234DF148426D22569DCE14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
            mPauseButton.setEnabled(enabled);
        } //End block
        {
            mFfwdButton.setEnabled(enabled);
        } //End block
        {
            mRewButton.setEnabled(enabled);
        } //End block
        {
            mNextButton.setEnabled(enabled && mNextListener != null);
        } //End block
        {
            mPrevButton.setEnabled(enabled && mPrevListener != null);
        } //End block
        {
            mProgress.setEnabled(enabled);
        } //End block
        disableUnsupportedButtons();
        super.setEnabled(enabled);
        // ---------- Original Method ----------
        //if (mPauseButton != null) {
            //mPauseButton.setEnabled(enabled);
        //}
        //if (mFfwdButton != null) {
            //mFfwdButton.setEnabled(enabled);
        //}
        //if (mRewButton != null) {
            //mRewButton.setEnabled(enabled);
        //}
        //if (mNextButton != null) {
            //mNextButton.setEnabled(enabled && mNextListener != null);
        //}
        //if (mPrevButton != null) {
            //mPrevButton.setEnabled(enabled && mPrevListener != null);
        //}
        //if (mProgress != null) {
            //mProgress.setEnabled(enabled);
        //}
        //disableUnsupportedButtons();
        //super.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.797 -0400", hash_original_method = "8961D157AE11C5565BE89171B02042D7", hash_generated_method = "38F86077F05FB924FB4C8C295DECE528")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void installPrevNextListeners() {
        {
            mNextButton.setOnClickListener(mNextListener);
            mNextButton.setEnabled(mNextListener != null);
        } //End block
        {
            mPrevButton.setOnClickListener(mPrevListener);
            mPrevButton.setEnabled(mPrevListener != null);
        } //End block
        // ---------- Original Method ----------
        //if (mNextButton != null) {
            //mNextButton.setOnClickListener(mNextListener);
            //mNextButton.setEnabled(mNextListener != null);
        //}
        //if (mPrevButton != null) {
            //mPrevButton.setOnClickListener(mPrevListener);
            //mPrevButton.setEnabled(mPrevListener != null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.797 -0400", hash_original_method = "89E197A0FA8E44785E0952D38D1CD31E", hash_generated_method = "8E2C28DC7F01E80A0DD8CE5C7B00B39D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPrevNextListeners(View.OnClickListener next, View.OnClickListener prev) {
        dsTaint.addTaint(next.dsTaint);
        dsTaint.addTaint(prev.dsTaint);
        mListenersSet = true;
        {
            installPrevNextListeners();
            {
                mNextButton.setVisibility(View.VISIBLE);
            } //End block
            {
                mPrevButton.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mNextListener = next;
        //mPrevListener = prev;
        //mListenersSet = true;
        //if (mRoot != null) {
            //installPrevNextListeners();
            //if (mNextButton != null && !mFromXml) {
                //mNextButton.setVisibility(View.VISIBLE);
            //}
            //if (mPrevButton != null && !mFromXml) {
                //mPrevButton.setVisibility(View.VISIBLE);
            //}
        //}
    }

    
    public interface MediaPlayerControl {
        void    start();
        void    pause();
        int     getDuration();
        int     getCurrentPosition();
        void    seekTo(int pos);
        boolean isPlaying();
        int     getBufferPercentage();
        boolean canPause();
        boolean canSeekBackward();
        boolean canSeekForward();
    }
    
    private static final int    sDefaultTimeout = 3000;
    private static final int    FADE_OUT = 1;
    private static final int    SHOW_PROGRESS = 2;
}

