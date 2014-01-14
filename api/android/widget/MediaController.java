package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.Formatter;
import java.util.Locale;

import android.content.Context;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
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

public class MediaController extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.766 -0500", hash_original_field = "51A7C007DC927AE81263901496BB16EF", hash_generated_field = "D48789DDA30E2CD97FBA0FDD6D61695B")

    private static final int    sDefaultTimeout = 3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.768 -0500", hash_original_field = "2ADEF79A83CC9708960A6EE72937BCA1", hash_generated_field = "9ABD36B6223DF65DDE8287EC24B7081F")

    private static final int    FADE_OUT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.771 -0500", hash_original_field = "7CB6710464D03B650611CB472CCCBA19", hash_generated_field = "70CE4AFAC8782487EDA0398517E5F691")

    private static final int    SHOW_PROGRESS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.740 -0500", hash_original_field = "9F93FA23B60E8D7CE73098ED27CD49FB", hash_generated_field = "C74867B897C11D551703ED8F09673E65")

    private MediaPlayerControl  mPlayer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.742 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context             mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.744 -0500", hash_original_field = "86801A6B1E54D7468FFA612E6FAA6E5E", hash_generated_field = "B5073E9D1328D8D85272F118048A8168")

    private View                mAnchor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.746 -0500", hash_original_field = "8933574E15F1C924E2824FC253C3961A", hash_generated_field = "0ED6566025E9B439A5328FE9C573194D")

    private View                mRoot;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.748 -0500", hash_original_field = "83A062836C11DD52DC32F4325712F233", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager       mWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.750 -0500", hash_original_field = "C6B08D42C8EA2CB56500460CAF662F4C", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window              mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.752 -0500", hash_original_field = "B4A10D2FE94FCA7877DCD1F8197DA38F", hash_generated_field = "BDE9FB2A6A09F560E3374107E2F57D26")

    private View                mDecor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.755 -0500", hash_original_field = "D0A635CD04B1C501C16A3DEEC61B23D3", hash_generated_field = "FE7534A506BE79955B21E465F7C91AA4")

    private WindowManager.LayoutParams mDecorLayoutParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.757 -0500", hash_original_field = "789276011B0B73E01A12C7020EDE82A8", hash_generated_field = "77244E1CDBA901DF4A72F7384A95707A")

    private ProgressBar         mProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "A0F28E4F5A99C619D8D824EA80594134", hash_generated_field = "A4C978CDA6C2D3809832A0A98832DBB6")

    private TextView mEndTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "268F636B4B5249EF5F354C806750D45C", hash_generated_field = "C0A1DCB994097ACA3510B7B3D309141F")

    private TextView mCurrentTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.761 -0500", hash_original_field = "C603A2A7CE7EB567C07371A80E0B1B92", hash_generated_field = "B79CA64D30F2326845D74336ECD5230C")

    private boolean             mShowing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.764 -0500", hash_original_field = "C34BF52F9E824E125AAB68548C2CBD0F", hash_generated_field = "28D9C38A63CC0E8BC9E397ABC91A037C")

    private boolean             mDragging;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.773 -0500", hash_original_field = "647F8F0214181EC025F6DBE11E45A608", hash_generated_field = "398745AA0BD03CA62F1A35ECD505B4A0")

    private boolean             mUseFastForward;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.774 -0500", hash_original_field = "481C56C999B76440E26DFF8D5243BE6F", hash_generated_field = "99698C9989636C991893ED4EDEAABFCA")

    private boolean             mFromXml;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.776 -0500", hash_original_field = "A3CBE3D7F0444E7D1305CD1089BCC17A", hash_generated_field = "461D33372C05A8FD7B0B0B88A3A8E8C8")

    private boolean             mListenersSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "AF42E80C05BFA2EDF3094674A5DA2DDB", hash_generated_field = "8AE10A114062F73ABA215E22225C6F88")

    private View.OnClickListener mNextListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "62A140AE126A21474397E00B2996BE52", hash_generated_field = "3F371EEFB52F4421082CFE70D26864AD")

    private View.OnClickListener mPrevListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.781 -0500", hash_original_field = "8ED0E2EC59DE8D5B5B0284133B2ABFA3", hash_generated_field = "8ED0E2EC59DE8D5B5B0284133B2ABFA3")

    StringBuilder               mFormatBuilder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.783 -0500", hash_original_field = "180E02EA47264C617605A9175AD35DD3", hash_generated_field = "180E02EA47264C617605A9175AD35DD3")

    Formatter                   mFormatter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.785 -0500", hash_original_field = "F9640C541885A6142B97848A9A81556D", hash_generated_field = "AAE39E66CF330D17558204D2F4FCB3A1")

    private ImageButton         mPauseButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.787 -0500", hash_original_field = "4EFE22AE13B49282E132EDB14D04E7B3", hash_generated_field = "8F96589974B5164F38263933E0F4391D")

    private ImageButton         mFfwdButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.789 -0500", hash_original_field = "E9BA318B528BAFF9BE9E3F14A24A4184", hash_generated_field = "F873DA12C5F252102530EBAB515330FA")

    private ImageButton         mRewButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.791 -0500", hash_original_field = "D3298ACFBAFE25F29AFCD2574929E66E", hash_generated_field = "3194EEB3EABDFDC508551D1FE5DE2F37")

    private ImageButton         mNextButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.793 -0500", hash_original_field = "6D7C5BE0C199DFC64C5BB4CB024ADB28", hash_generated_field = "6FECDBBC365C7E42CC171554AB2D09A0")

    private ImageButton         mPrevButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.958 -0400", hash_original_field = "660FD0A006FEE08090F60B78E5797043", hash_generated_field = "99EED3785EF0C907A603E89C20142DDB")

    private OnLayoutChangeListener mLayoutChangeListener = new OnLayoutChangeListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.958 -0400", hash_original_method = "B906B3E54DBAAD427317F640A60E799C", hash_generated_method = "02969F67A79B551D4857B063D0CDE2B2")
        public void onLayoutChange(View v, int left, int top, int right,
                int bottom, int oldLeft, int oldTop, int oldRight,
                int oldBottom) {
            
            updateFloatingWindowLayout();
            {
                mWindowManager.updateViewLayout(mDecor, mDecorLayoutParams);
            } 
            addTaint(v.getTaint());
            addTaint(left);
            addTaint(top);
            addTaint(right);
            addTaint(bottom);
            addTaint(oldLeft);
            addTaint(oldTop);
            addTaint(oldRight);
            addTaint(oldBottom);
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.959 -0400", hash_original_field = "73CE077A46042732A8F7D92A2C1AF8E9", hash_generated_field = "D5E2F5EC139F4E66D1268BA7AC51AD66")

    private OnTouchListener mTouchListener = new OnTouchListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.959 -0400", hash_original_method = "16F82C3AF10F7CC437B6D7BEE6D0DC69", hash_generated_method = "670745B700E2F0AEC3EB680BB5FE1569")
        public boolean onTouch(View v, MotionEvent event) {
            
            {
                boolean var1FBD87715268F23D17D833CE81073212_104829375 = (event.getAction() == MotionEvent.ACTION_DOWN);
                {
                    {
                        hide();
                    } 
                } 
            } 
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513393010 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_513393010;
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.959 -0400", hash_original_field = "52BC51643FEA9D0069B8F60CDBE72485", hash_generated_field = "07C335A7203DDCB0B6B0476786CDB55E")

    private Handler mHandler = new Handler() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.959 -0400", hash_original_method = "8F0BA1F98715C95935AC2F391AEFF8BC", hash_generated_method = "AAD2F5C855014B3F65805A54CE92C144")
        @Override
        public void handleMessage(Message msg) {
            int pos;
            
            hide();
            
            pos = setProgress();
            
            {
                boolean var35D9B4E6001F9970817DCA22BC2D906C_887351060 = (!mDragging && mShowing && mPlayer.isPlaying());
                {
                    msg = obtainMessage(SHOW_PROGRESS);
                    sendMessageDelayed(msg, 1000 - (pos % 1000));
                } 
            }
            
            addTaint(msg.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.960 -0400", hash_original_field = "3C390C0F3EC8C6E76F3F8507AC8E9757", hash_generated_field = "BE0735A4F6CFAEC244ADB1A1B9E79B8E")

    private View.OnClickListener mPauseListener = new View.OnClickListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.960 -0400", hash_original_method = "F90DC617061E164BAEBDBFB1EA5D02BB", hash_generated_method = "811C9C24B7A4723801F0D8BF2718901B")
        public void onClick(View v) {
            
            doPauseResume();
            show(sDefaultTimeout);
            addTaint(v.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.962 -0400", hash_original_field = "2008B1EA87DEDE92B83942CF8FDFADEE", hash_generated_field = "3F48026F72D34D65675A07880DC105DA")

    private OnSeekBarChangeListener mSeekListener = new OnSeekBarChangeListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.960 -0400", hash_original_method = "6758392684DBD95D44B26F154F80CA94", hash_generated_method = "F7437A498E3BC8B8A4C329E77821999A")
        public void onStartTrackingTouch(SeekBar bar) {
            
            show(3600000);
            mDragging = true;
            mHandler.removeMessages(SHOW_PROGRESS);
            addTaint(bar.getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.961 -0400", hash_original_method = "A0EB029A26053134120EC96D7E9882E8", hash_generated_method = "79AFAB679FF9035633BFBD81A27D25D1")
        public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {
            
            long duration = mPlayer.getDuration();
            long newposition = (duration * progress) / 1000L;
            mPlayer.seekTo( (int) newposition);
            mCurrentTime.setText(stringForTime( (int) newposition));
            addTaint(bar.getTaint());
            addTaint(progress);
            addTaint(fromuser);
                
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.962 -0400", hash_original_method = "53B60B6767600F274A52648AF75E3493", hash_generated_method = "AC47A2FB017606BEB8453C4173FA9028")
        public void onStopTrackingTouch(SeekBar bar) {
            
            mDragging = false;
            setProgress();
            updatePausePlay();
            show(sDefaultTimeout);
            mHandler.sendEmptyMessage(SHOW_PROGRESS);
            addTaint(bar.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.962 -0400", hash_original_field = "9A9DC70DF59B8B1F6B8A9A0C085DFDEA", hash_generated_field = "5DBE77CBBAA3F1DC86B3ACDF42D05696")

    private View.OnClickListener mRewListener = new View.OnClickListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.962 -0400", hash_original_method = "B5D53DC8A12E02793B3EF0C8511F70D5", hash_generated_method = "0956446804574FD1FF0574BB3CAF295E")
        public void onClick(View v) {
            
            int pos = mPlayer.getCurrentPosition();
            pos -= 5000;
            mPlayer.seekTo(pos);
            setProgress();
            show(sDefaultTimeout);
            addTaint(v.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.963 -0400", hash_original_field = "50D091DCCFB4B00402EDDB2863541762", hash_generated_field = "357A31A66BFB23DD2BBC706283F10430")

    private View.OnClickListener mFfwdListener = new View.OnClickListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.963 -0400", hash_original_method = "BF054D35499B7B032734EBAD3598DA2F", hash_generated_method = "43AF20A0E570119EBA30B6224936073D")
        public void onClick(View v) {
            
            int pos = mPlayer.getCurrentPosition();
            pos += 15000;
            mPlayer.seekTo(pos);
            setProgress();
            show(sDefaultTimeout);
            addTaint(v.getTaint());
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.796 -0500", hash_original_method = "3C97480952764669863839416E96E876", hash_generated_method = "94596EE07B21FB06526340B7B4E93FC5")
    
public MediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRoot = this;
        mContext = context;
        mUseFastForward = true;
        mFromXml = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.800 -0500", hash_original_method = "D7A2F0702C06D7B537ED0824ED57856A", hash_generated_method = "931342A4EBF620F037E7ABCA6888E811")
    
public MediaController(Context context, boolean useFastForward) {
        super(context);
        mContext = context;
        mUseFastForward = useFastForward;
        initFloatingWindowLayout();
        initFloatingWindow();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.803 -0500", hash_original_method = "7386C8F43CBDAAD1A4C1AD10A9F3EB18", hash_generated_method = "5878467175AF151BABDCB88E896C5161")
    
public MediaController(Context context) {
        this(context, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.798 -0500", hash_original_method = "73B20F41AD38A9B689CAB773B229DC2D", hash_generated_method = "81F5B3FB48311147DEAF28062695C8DE")
    
@Override
    public void onFinishInflate() {
        if (mRoot != null)
            initControllerView(mRoot);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.805 -0500", hash_original_method = "5AB721CF8AD66EE5762FE50902543B8E", hash_generated_method = "A2E6C609AA05496300AE2D87B08FBB89")
    
private void initFloatingWindow() {
        mWindowManager = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        mWindow = PolicyManager.makeNewWindow(mContext);
        mWindow.setWindowManager(mWindowManager, null, null);
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        mDecor = mWindow.getDecorView();
        mDecor.setOnTouchListener(mTouchListener);
        mWindow.setContentView(this);
        mWindow.setBackgroundDrawableResource(android.R.color.transparent);
        
        // While the media controller is up, the volume control keys should
        // affect the media stream type
        mWindow.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        setFocusable(true);
        setFocusableInTouchMode(true);
        setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
        requestFocus();
    }

    // Allocate and initialize the static parts of mDecorLayoutParams. Must
    // also call updateFloatingWindowLayout() to fill in the dynamic parts
    // (y and width) before mDecorLayoutParams can be used.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.808 -0500", hash_original_method = "A15216BA04857F16D27E94A01ED8D9C8", hash_generated_method = "91CBB2F75688F6C9CBEB6538E34269C1")
    
private void initFloatingWindowLayout() {
        mDecorLayoutParams = new WindowManager.LayoutParams();
        WindowManager.LayoutParams p = mDecorLayoutParams;
        p.gravity = Gravity.TOP;
        p.height = LayoutParams.WRAP_CONTENT;
        p.x = 0;
        p.format = PixelFormat.TRANSLUCENT;
        p.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        p.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
        p.token = null;
        p.windowAnimations = 0; // android.R.style.DropDownAnimationDown;
    }

    // Update the dynamic parts of mDecorLayoutParams
    // Must be called with mAnchor != NULL.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.810 -0500", hash_original_method = "273528B94A02173E736183C73352565A", hash_generated_method = "4A0ABB6EFFFD02F2E28FACC976ECCE7C")
    
private void updateFloatingWindowLayout() {
        int [] anchorPos = new int[2];
        mAnchor.getLocationOnScreen(anchorPos);

        WindowManager.LayoutParams p = mDecorLayoutParams;
        p.width = mAnchor.getWidth();
        p.y = anchorPos[1] + mAnchor.getHeight();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.823 -0500", hash_original_method = "9E3EB1A0CE9430F92BE04C3BC9E64024", hash_generated_method = "7118CE20BC98F0D53258D4E3DF5D3A5A")
    
public void setMediaPlayer(MediaPlayerControl player) {
        mPlayer = player;
        updatePausePlay();
    }

    /**
     * Set the view that acts as the anchor for the control view.
     * This can for example be a VideoView, or your Activity's main view.
     * @param view The view to which to anchor the controller when it is visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.826 -0500", hash_original_method = "A3367E3EA3926FFA5E8601886A545624", hash_generated_method = "5D5DD9F35E968A796296290E4C8D59CB")
    
public void setAnchorView(View view) {
        if (mAnchor != null) {
            mAnchor.removeOnLayoutChangeListener(mLayoutChangeListener);
        }
        mAnchor = view;
        if (mAnchor != null) {
            mAnchor.addOnLayoutChangeListener(mLayoutChangeListener);
        }

        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        removeAllViews();
        View v = makeControllerView();
        addView(v, frameParams);
    }

    /**
     * Create the view that holds the widgets that control playback.
     * Derived classes can override this to create their own.
     * @return The controller view.
     * @hide This doesn't work as advertised
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.828 -0500", hash_original_method = "47AAB8ACF83F9E0950F4FC2EF0028588", hash_generated_method = "6E6D285462F56F2CE61E3592B6007605")
    
protected View makeControllerView() {
        LayoutInflater inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRoot = inflate.inflate(com.android.internal.R.layout.media_controller, null);

        initControllerView(mRoot);

        return mRoot;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.831 -0500", hash_original_method = "6027E965805CA7D75D241C044D75CFC3", hash_generated_method = "1077BC0B8EEA742D986B8E9AFE2DFE30")
    
private void initControllerView(View v) {
        mPauseButton = (ImageButton) v.findViewById(com.android.internal.R.id.pause);
        if (mPauseButton != null) {
            mPauseButton.requestFocus();
            mPauseButton.setOnClickListener(mPauseListener);
        }

        mFfwdButton = (ImageButton) v.findViewById(com.android.internal.R.id.ffwd);
        if (mFfwdButton != null) {
            mFfwdButton.setOnClickListener(mFfwdListener);
            if (!mFromXml) {
                mFfwdButton.setVisibility(mUseFastForward ? View.VISIBLE : View.GONE);
            }
        }

        mRewButton = (ImageButton) v.findViewById(com.android.internal.R.id.rew);
        if (mRewButton != null) {
            mRewButton.setOnClickListener(mRewListener);
            if (!mFromXml) {
                mRewButton.setVisibility(mUseFastForward ? View.VISIBLE : View.GONE);
            }
        }

        // By default these are hidden. They will be enabled when setPrevNextListeners() is called 
        mNextButton = (ImageButton) v.findViewById(com.android.internal.R.id.next);
        if (mNextButton != null && !mFromXml && !mListenersSet) {
            mNextButton.setVisibility(View.GONE);
        }
        mPrevButton = (ImageButton) v.findViewById(com.android.internal.R.id.prev);
        if (mPrevButton != null && !mFromXml && !mListenersSet) {
            mPrevButton.setVisibility(View.GONE);
        }

        mProgress = (ProgressBar) v.findViewById(com.android.internal.R.id.mediacontroller_progress);
        if (mProgress != null) {
            if (mProgress instanceof SeekBar) {
                SeekBar seeker = (SeekBar) mProgress;
                seeker.setOnSeekBarChangeListener(mSeekListener);
            }
            mProgress.setMax(1000);
        }

        mEndTime = (TextView) v.findViewById(com.android.internal.R.id.time);
        mCurrentTime = (TextView) v.findViewById(com.android.internal.R.id.time_current);
        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());

        installPrevNextListeners();
    }

    /**
     * Show the controller on screen. It will go away
     * automatically after 3 seconds of inactivity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.834 -0500", hash_original_method = "F96F3B42B5EBC38D2746BE6361617E40", hash_generated_method = "140794B7EAECBBF51C26F18398A659C9")
    
public void show() {
        show(sDefaultTimeout);
    }

    /**
     * Disable pause or seek buttons if the stream cannot be paused or seeked.
     * This requires the control interface to be a MediaPlayerControlExt
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.836 -0500", hash_original_method = "4DD833D5B8F1F18277B038D9576E3A42", hash_generated_method = "E512E5CC6A42072B59F0748E78751F3C")
    
private void disableUnsupportedButtons() {
        try {
            if (mPauseButton != null && !mPlayer.canPause()) {
                mPauseButton.setEnabled(false);
            }
            if (mRewButton != null && !mPlayer.canSeekBackward()) {
                mRewButton.setEnabled(false);
            }
            if (mFfwdButton != null && !mPlayer.canSeekForward()) {
                mFfwdButton.setEnabled(false);
            }
        } catch (IncompatibleClassChangeError ex) {
            // We were given an old version of the interface, that doesn't have
            // the canPause/canSeekXYZ methods. This is OK, it just means we
            // assume the media can be paused and seeked, and so we don't disable
            // the buttons.
        }
    }
    
    /**
     * Show the controller on screen. It will go away
     * automatically after 'timeout' milliseconds of inactivity.
     * @param timeout The timeout in milliseconds. Use 0 to show
     * the controller until hide() is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.838 -0500", hash_original_method = "C16367489FF99029DA16F545FE506814", hash_generated_method = "2EAD8E95074DF4774208EB90B56F5723")
    
public void show(int timeout) {
        if (!mShowing && mAnchor != null) {
            setProgress();
            if (mPauseButton != null) {
                mPauseButton.requestFocus();
            }
            disableUnsupportedButtons();
            updateFloatingWindowLayout();
            mWindowManager.addView(mDecor, mDecorLayoutParams);
            mShowing = true;
        }
        updatePausePlay();
        
        // cause the progress bar to be updated even if mShowing
        // was already true.  This happens, for example, if we're
        // paused with the progress bar showing the user hits play.
        mHandler.sendEmptyMessage(SHOW_PROGRESS);

        Message msg = mHandler.obtainMessage(FADE_OUT);
        if (timeout != 0) {
            mHandler.removeMessages(FADE_OUT);
            mHandler.sendMessageDelayed(msg, timeout);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.841 -0500", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "C14BB39171429278E5F75B94242D6C8F")
    
public boolean isShowing() {
        return mShowing;
    }

    /**
     * Remove the controller from the screen.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.843 -0500", hash_original_method = "AF640FD924E8B1DADC076D8A3DA6C51B", hash_generated_method = "69B433B4EACB3A44B33996239DA58F38")
    
public void hide() {
        if (mAnchor == null)
            return;

        if (mShowing) {
            try {
                mHandler.removeMessages(SHOW_PROGRESS);
                mWindowManager.removeView(mDecor);
            } catch (IllegalArgumentException ex) {
                Log.w("MediaController", "already removed");
            }
            mShowing = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.851 -0500", hash_original_method = "E3DEF3CD65DC2BEF1837B2236B56198B", hash_generated_method = "34BD257A9BA58D38572C5D92672179BD")
    
private String stringForTime(int timeMs) {
        int totalSeconds = timeMs / 1000;

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours   = totalSeconds / 3600;

        mFormatBuilder.setLength(0);
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.853 -0500", hash_original_method = "972585652F798E535DB73510970F52DB", hash_generated_method = "885CF83E5506AB7B8C752DB32309D990")
    
private int setProgress() {
        if (mPlayer == null || mDragging) {
            return 0;
        }
        int position = mPlayer.getCurrentPosition();
        int duration = mPlayer.getDuration();
        if (mProgress != null) {
            if (duration > 0) {
                // use long to avoid overflow
                long pos = 1000L * position / duration;
                mProgress.setProgress( (int) pos);
            }
            int percent = mPlayer.getBufferPercentage();
            mProgress.setSecondaryProgress(percent * 10);
        }

        if (mEndTime != null)
            mEndTime.setText(stringForTime(duration));
        if (mCurrentTime != null)
            mCurrentTime.setText(stringForTime(position));

        return position;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.856 -0500", hash_original_method = "804998442429040CE8E4A7C248858770", hash_generated_method = "E258894509A40CA91A0B4BF9C8755959")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        show(sDefaultTimeout);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.858 -0500", hash_original_method = "294FBCC6A05258601D3163C3FD371667", hash_generated_method = "7DC3178355669E7D4254623572CFB246")
    
@Override
    public boolean onTrackballEvent(MotionEvent ev) {
        show(sDefaultTimeout);
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.861 -0500", hash_original_method = "F0666CB3DD2163E885B9F12838A0406B", hash_generated_method = "16B3406BD82DE95CED7F371746D659BE")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        final boolean uniqueDown = event.getRepeatCount() == 0
                && event.getAction() == KeyEvent.ACTION_DOWN;
        if (keyCode ==  KeyEvent.KEYCODE_HEADSETHOOK
                || keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE
                || keyCode == KeyEvent.KEYCODE_SPACE) {
            if (uniqueDown) {
                doPauseResume();
                show(sDefaultTimeout);
                if (mPauseButton != null) {
                    mPauseButton.requestFocus();
                }
            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_MEDIA_PLAY) {
            if (uniqueDown && !mPlayer.isPlaying()) {
                mPlayer.start();
                updatePausePlay();
                show(sDefaultTimeout);
            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_MEDIA_STOP
                || keyCode == KeyEvent.KEYCODE_MEDIA_PAUSE) {
            if (uniqueDown && mPlayer.isPlaying()) {
                mPlayer.pause();
                updatePausePlay();
                show(sDefaultTimeout);
            }
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN
                || keyCode == KeyEvent.KEYCODE_VOLUME_UP
                || keyCode == KeyEvent.KEYCODE_VOLUME_MUTE) {
            // don't show the controls for volume adjustment
            return super.dispatchKeyEvent(event);
        } else if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_MENU) {
            if (uniqueDown) {
                hide();
            }
            return true;
        }

        show(sDefaultTimeout);
        return super.dispatchKeyEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.869 -0500", hash_original_method = "B0869F9835F79F721C7D9CE04C896B2B", hash_generated_method = "8355708F6C7F243378A44C2457F5C274")
    
private void updatePausePlay() {
        if (mRoot == null || mPauseButton == null)
            return;

        if (mPlayer.isPlaying()) {
            mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_pause);
        } else {
            mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_play);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.871 -0500", hash_original_method = "F9113ED701E8317A61E1AB80861EF0B1", hash_generated_method = "2AE3244ADA5A5A27CBD2681B7914FEC2")
    
private void doPauseResume() {
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.start();
        }
        updatePausePlay();
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.885 -0500", hash_original_method = "E14B391343AAAAC9B9A5DC8FE6A0AD92", hash_generated_method = "0B071800A736A98EA4E171A302438D8B")
    
@Override
    public void setEnabled(boolean enabled) {
        if (mPauseButton != null) {
            mPauseButton.setEnabled(enabled);
        }
        if (mFfwdButton != null) {
            mFfwdButton.setEnabled(enabled);
        }
        if (mRewButton != null) {
            mRewButton.setEnabled(enabled);
        }
        if (mNextButton != null) {
            mNextButton.setEnabled(enabled && mNextListener != null);
        }
        if (mPrevButton != null) {
            mPrevButton.setEnabled(enabled && mPrevListener != null);
        }
        if (mProgress != null) {
            mProgress.setEnabled(enabled);
        }
        disableUnsupportedButtons();
        super.setEnabled(enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.897 -0500", hash_original_method = "8961D157AE11C5565BE89171B02042D7", hash_generated_method = "7F3433AB3B8ECE39C4B437F8D811BAA4")
    
private void installPrevNextListeners() {
        if (mNextButton != null) {
            mNextButton.setOnClickListener(mNextListener);
            mNextButton.setEnabled(mNextListener != null);
        }

        if (mPrevButton != null) {
            mPrevButton.setOnClickListener(mPrevListener);
            mPrevButton.setEnabled(mPrevListener != null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:56.899 -0500", hash_original_method = "89E197A0FA8E44785E0952D38D1CD31E", hash_generated_method = "47C3CD965EA398C1B63CD39F28F3ADE5")
    
public void setPrevNextListeners(View.OnClickListener next, View.OnClickListener prev) {
        mNextListener = next;
        mPrevListener = prev;
        mListenersSet = true;

        if (mRoot != null) {
            installPrevNextListeners();
            
            if (mNextButton != null && !mFromXml) {
                mNextButton.setVisibility(View.VISIBLE);
            }
            if (mPrevButton != null && !mFromXml) {
                mPrevButton.setVisibility(View.VISIBLE);
            }
        }
    }
}

