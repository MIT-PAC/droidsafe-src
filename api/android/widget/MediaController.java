package android.widget;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "01AE51C88036C324EFB5646FEE9EB109", hash_generated_field = "C74867B897C11D551703ED8F09673E65")

    private MediaPlayerControl mPlayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "8A2549E4A331F412E0868B04A8E3C179", hash_generated_field = "B5073E9D1328D8D85272F118048A8168")

    private View mAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "45682D04D23E9DFA9A87C72737AEDE4C", hash_generated_field = "0ED6566025E9B439A5328FE9C573194D")

    private View mRoot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "90456FC221E7A82F02F5F0D86665E9D8", hash_generated_field = "BDE9FB2A6A09F560E3374107E2F57D26")

    private View mDecor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "05002D02EF9B36A1B7BF79BD9FBEC54A", hash_generated_field = "FE7534A506BE79955B21E465F7C91AA4")

    private WindowManager.LayoutParams mDecorLayoutParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "77244E1CDBA901DF4A72F7384A95707A")

    private ProgressBar mProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "A0F28E4F5A99C619D8D824EA80594134", hash_generated_field = "A4C978CDA6C2D3809832A0A98832DBB6")

    private TextView mEndTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "268F636B4B5249EF5F354C806750D45C", hash_generated_field = "C0A1DCB994097ACA3510B7B3D309141F")

    private TextView mCurrentTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "ED7142E6C56E85275A9E1F55586553C1", hash_generated_field = "B79CA64D30F2326845D74336ECD5230C")

    private boolean mShowing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "B3298065CA384AB9C76E95FF12D862DF", hash_generated_field = "28D9C38A63CC0E8BC9E397ABC91A037C")

    private boolean mDragging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "B3F4B254B7C00EE15B00ABE4F7F15F0B", hash_generated_field = "398745AA0BD03CA62F1A35ECD505B4A0")

    private boolean mUseFastForward;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.320 -0400", hash_original_field = "AEC13D368249EDDA656425EDDFBDD188", hash_generated_field = "99698C9989636C991893ED4EDEAABFCA")

    private boolean mFromXml;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "04B250C72B2A42201A5C438E3A8C914C", hash_generated_field = "461D33372C05A8FD7B0B0B88A3A8E8C8")

    private boolean mListenersSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "AF42E80C05BFA2EDF3094674A5DA2DDB", hash_generated_field = "8AE10A114062F73ABA215E22225C6F88")

    private View.OnClickListener mNextListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "62A140AE126A21474397E00B2996BE52", hash_generated_field = "3F371EEFB52F4421082CFE70D26864AD")

    private View.OnClickListener mPrevListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "2DD9B7DC9B992033B17036351C1ED2F9", hash_generated_field = "8ED0E2EC59DE8D5B5B0284133B2ABFA3")

    StringBuilder mFormatBuilder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "9F70B7A1463B032732E51B2DC5F8D2E4", hash_generated_field = "180E02EA47264C617605A9175AD35DD3")

    Formatter mFormatter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "3D20693DD5EFCB0E52DD2EC00EED830B", hash_generated_field = "AAE39E66CF330D17558204D2F4FCB3A1")

    private ImageButton mPauseButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "85601BC374137C7C9E358B5DE187A90C", hash_generated_field = "8F96589974B5164F38263933E0F4391D")

    private ImageButton mFfwdButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "D3BEAE5637F85D7FC02CA0338A80DDDF", hash_generated_field = "F873DA12C5F252102530EBAB515330FA")

    private ImageButton mRewButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "25A8D69C909160605880E75D8AC0CC0C", hash_generated_field = "3194EEB3EABDFDC508551D1FE5DE2F37")

    private ImageButton mNextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.321 -0400", hash_original_field = "0EE34D2F4F7AC2CA3C11B1B38A204D08", hash_generated_field = "6FECDBBC365C7E42CC171554AB2D09A0")

    private ImageButton mPrevButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.958 -0400", hash_original_field = "660FD0A006FEE08090F60B78E5797043", hash_generated_field = "99EED3785EF0C907A603E89C20142DDB")

    private OnLayoutChangeListener mLayoutChangeListener = new OnLayoutChangeListener() {        
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.960 -0400", hash_original_method = "F90DC617061E164BAEBDBFB1EA5D02BB", hash_generated_method = "811C9C24B7A4723801F0D8BF2718901B")
        public void onClick(View v) {
            
            doPauseResume();
            show(sDefaultTimeout);
            addTaint(v.getTaint());
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.962 -0400", hash_original_field = "2008B1EA87DEDE92B83942CF8FDFADEE", hash_generated_field = "3F48026F72D34D65675A07880DC105DA")

    private OnSeekBarChangeListener mSeekListener = new OnSeekBarChangeListener() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:12.960 -0400", hash_original_method = "6758392684DBD95D44B26F154F80CA94", hash_generated_method = "F7437A498E3BC8B8A4C329E77821999A")
        public void onStartTrackingTouch(SeekBar bar) {
            
            show(3600000);
            mDragging = true;
            mHandler.removeMessages(SHOW_PROGRESS);
            addTaint(bar.getTaint());
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
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

        
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
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
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.322 -0400", hash_original_method = "3C97480952764669863839416E96E876", hash_generated_method = "B3632A88919CFD244D8A039DE08FAC9B")
    public  MediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        mRoot = this;
        mContext = context;
        mUseFastForward = true;
        mFromXml = true;
        // ---------- Original Method ----------
        //mRoot = this;
        //mContext = context;
        //mUseFastForward = true;
        //mFromXml = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.323 -0400", hash_original_method = "D7A2F0702C06D7B537ED0824ED57856A", hash_generated_method = "B65AF034FAB2F65FF040F15D7506060C")
    public  MediaController(Context context, boolean useFastForward) {
        super(context);
        mContext = context;
        mUseFastForward = useFastForward;
        initFloatingWindowLayout();
        initFloatingWindow();
        // ---------- Original Method ----------
        //mContext = context;
        //mUseFastForward = useFastForward;
        //initFloatingWindowLayout();
        //initFloatingWindow();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.323 -0400", hash_original_method = "7386C8F43CBDAAD1A4C1AD10A9F3EB18", hash_generated_method = "BAEFEC7F4C63BFD48EB9DB265AE5D93D")
    public  MediaController(Context context) {
        this(context, true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.323 -0400", hash_original_method = "73B20F41AD38A9B689CAB773B229DC2D", hash_generated_method = "CE88E5124B8C53CF9E94382EA0C9CFDD")
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mRoot != null)        
        initControllerView(mRoot);
        // ---------- Original Method ----------
        //if (mRoot != null)
            //initControllerView(mRoot);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.324 -0400", hash_original_method = "5AB721CF8AD66EE5762FE50902543B8E", hash_generated_method = "23191FD52B96F9E7404E05B0D03554AA")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.325 -0400", hash_original_method = "A15216BA04857F16D27E94A01ED8D9C8", hash_generated_method = "1511A01BAD7F587E281791C0F994A377")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.326 -0400", hash_original_method = "273528B94A02173E736183C73352565A", hash_generated_method = "6603F115B58AD0A111D498ADAC13E1E7")
    private void updateFloatingWindowLayout() {
        int [] anchorPos = new int[2];
        mAnchor.getLocationOnScreen(anchorPos);
        WindowManager.LayoutParams p = mDecorLayoutParams;
        p.width = mAnchor.getWidth();
        p.y = anchorPos[1] + mAnchor.getHeight();
        // ---------- Original Method ----------
        //int [] anchorPos = new int[2];
        //mAnchor.getLocationOnScreen(anchorPos);
        //WindowManager.LayoutParams p = mDecorLayoutParams;
        //p.width = mAnchor.getWidth();
        //p.y = anchorPos[1] + mAnchor.getHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.326 -0400", hash_original_method = "9E3EB1A0CE9430F92BE04C3BC9E64024", hash_generated_method = "23FF24D7ABA4F4BB5C5B958C3ED006D7")
    public void setMediaPlayer(MediaPlayerControl player) {
        mPlayer = player;
        updatePausePlay();
        // ---------- Original Method ----------
        //mPlayer = player;
        //updatePausePlay();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.327 -0400", hash_original_method = "A3367E3EA3926FFA5E8601886A545624", hash_generated_method = "53F6D77E7B0EB6AF6F03BBB5513D6514")
    public void setAnchorView(View view) {
        if(mAnchor != null)        
        {
            mAnchor.removeOnLayoutChangeListener(mLayoutChangeListener);
        } //End block
        mAnchor = view;
        if(mAnchor != null)        
        {
            mAnchor.addOnLayoutChangeListener(mLayoutChangeListener);
        } //End block
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        removeAllViews();
        View v = makeControllerView();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.327 -0400", hash_original_method = "47AAB8ACF83F9E0950F4FC2EF0028588", hash_generated_method = "7EDEA8B1312AEC865B53889C8FEE2A79")
    protected View makeControllerView() {
        LayoutInflater inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRoot = inflate.inflate(com.android.internal.R.layout.media_controller, null);
        initControllerView(mRoot);
View var17ED5111C4228ECEE4A6CF715C735C69_1852993487 =         mRoot;
        var17ED5111C4228ECEE4A6CF715C735C69_1852993487.addTaint(taint);
        return var17ED5111C4228ECEE4A6CF715C735C69_1852993487;
        // ---------- Original Method ----------
        //LayoutInflater inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //mRoot = inflate.inflate(com.android.internal.R.layout.media_controller, null);
        //initControllerView(mRoot);
        //return mRoot;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.329 -0400", hash_original_method = "6027E965805CA7D75D241C044D75CFC3", hash_generated_method = "DAD6B2D6E532D12D8E10E912B1ECFC80")
    private void initControllerView(View v) {
        mPauseButton = (ImageButton) v.findViewById(com.android.internal.R.id.pause);
        if(mPauseButton != null)        
        {
            mPauseButton.requestFocus();
            mPauseButton.setOnClickListener(mPauseListener);
        } //End block
        mFfwdButton = (ImageButton) v.findViewById(com.android.internal.R.id.ffwd);
        if(mFfwdButton != null)        
        {
            mFfwdButton.setOnClickListener(mFfwdListener);
            if(!mFromXml)            
            {
                mFfwdButton.setVisibility(mUseFastForward ? View.VISIBLE : View.GONE);
            } //End block
        } //End block
        mRewButton = (ImageButton) v.findViewById(com.android.internal.R.id.rew);
        if(mRewButton != null)        
        {
            mRewButton.setOnClickListener(mRewListener);
            if(!mFromXml)            
            {
                mRewButton.setVisibility(mUseFastForward ? View.VISIBLE : View.GONE);
            } //End block
        } //End block
        mNextButton = (ImageButton) v.findViewById(com.android.internal.R.id.next);
        if(mNextButton != null && !mFromXml && !mListenersSet)        
        {
            mNextButton.setVisibility(View.GONE);
        } //End block
        mPrevButton = (ImageButton) v.findViewById(com.android.internal.R.id.prev);
        if(mPrevButton != null && !mFromXml && !mListenersSet)        
        {
            mPrevButton.setVisibility(View.GONE);
        } //End block
        mProgress = (ProgressBar) v.findViewById(com.android.internal.R.id.mediacontroller_progress);
        if(mProgress != null)        
        {
            if(mProgress instanceof SeekBar)            
            {
                SeekBar seeker = (SeekBar) mProgress;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.329 -0400", hash_original_method = "F96F3B42B5EBC38D2746BE6361617E40", hash_generated_method = "5CD112AEC01E8D805545E23D791EAB4F")
    public void show() {
        show(sDefaultTimeout);
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.330 -0400", hash_original_method = "4DD833D5B8F1F18277B038D9576E3A42", hash_generated_method = "37FCB9CE942835039AF687B7705C1DCE")
    private void disableUnsupportedButtons() {
        try 
        {
            if(mPauseButton != null && !mPlayer.canPause())            
            {
                mPauseButton.setEnabled(false);
            } //End block
            if(mRewButton != null && !mPlayer.canSeekBackward())            
            {
                mRewButton.setEnabled(false);
            } //End block
            if(mFfwdButton != null && !mPlayer.canSeekForward())            
            {
                mFfwdButton.setEnabled(false);
            } //End block
        } //End block
        catch (IncompatibleClassChangeError ex)
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.330 -0400", hash_original_method = "C16367489FF99029DA16F545FE506814", hash_generated_method = "9561BAC55FC933C86FA2F8D6A3C92E26")
    public void show(int timeout) {
        addTaint(timeout);
        if(!mShowing && mAnchor != null)        
        {
            setProgress();
            if(mPauseButton != null)            
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
        Message msg = mHandler.obtainMessage(FADE_OUT);
        if(timeout != 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.331 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "76B0B56677FA48F9EF7B887D4887B0F6")
    public boolean isShowing() {
        boolean varED7142E6C56E85275A9E1F55586553C1_886985816 = (mShowing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293494845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293494845;
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.331 -0400", hash_original_method = "AF640FD924E8B1DADC076D8A3DA6C51B", hash_generated_method = "1AF7E64AD5D150C0D49E4D6DCDD1224E")
    public void hide() {
        if(mAnchor == null)        
        return;
        if(mShowing)        
        {
            try 
            {
                mHandler.removeMessages(SHOW_PROGRESS);
                mWindowManager.removeView(mDecor);
            } //End block
            catch (IllegalArgumentException ex)
            {
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.331 -0400", hash_original_method = "E3DEF3CD65DC2BEF1837B2236B56198B", hash_generated_method = "8B10064358DC24ED920F97AFD767FB55")
    private String stringForTime(int timeMs) {
        addTaint(timeMs);
        int totalSeconds = timeMs / 1000;
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        mFormatBuilder.setLength(0);
        if(hours > 0)        
        {
String varCE7E2E10EFE2470EBFC4F3C6DE6DB9DC_1424429020 =             mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
            varCE7E2E10EFE2470EBFC4F3C6DE6DB9DC_1424429020.addTaint(taint);
            return varCE7E2E10EFE2470EBFC4F3C6DE6DB9DC_1424429020;
        } //End block
        else
        {
String var62E3B0507D0D1F6D3251AAF88ECDF1E3_2049617016 =             mFormatter.format("%02d:%02d", minutes, seconds).toString();
            var62E3B0507D0D1F6D3251AAF88ECDF1E3_2049617016.addTaint(taint);
            return var62E3B0507D0D1F6D3251AAF88ECDF1E3_2049617016;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.332 -0400", hash_original_method = "972585652F798E535DB73510970F52DB", hash_generated_method = "6092BD05F91DFDC2AFFEE8393D3AAADE")
    private int setProgress() {
        if(mPlayer == null || mDragging)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1859155390 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701698100 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701698100;
        } //End block
        int position = mPlayer.getCurrentPosition();
        int duration = mPlayer.getDuration();
        if(mProgress != null)        
        {
            if(duration > 0)            
            {
                long pos = 1000L * position / duration;
                mProgress.setProgress( (int) pos);
            } //End block
            int percent = mPlayer.getBufferPercentage();
            mProgress.setSecondaryProgress(percent * 10);
        } //End block
        if(mEndTime != null)        
        mEndTime.setText(stringForTime(duration));
        if(mCurrentTime != null)        
        mCurrentTime.setText(stringForTime(position));
        int var4757FE07FD492A8BE0EA6A760D683D6E_1403427841 = (position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477500192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477500192;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.332 -0400", hash_original_method = "804998442429040CE8E4A7C248858770", hash_generated_method = "BB6195689EEEE7CB2F65DDDA9A9606B1")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        show(sDefaultTimeout);
        boolean varB326B5062B2F0E69046810717534CB09_394603873 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912606085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912606085;
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.332 -0400", hash_original_method = "294FBCC6A05258601D3163C3FD371667", hash_generated_method = "77E0234D9E13C7C519D14F0AA99A9CA1")
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        show(sDefaultTimeout);
        boolean var68934A3E9455FA72420237EB05902327_1624075418 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474946801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474946801;
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.333 -0400", hash_original_method = "F0666CB3DD2163E885B9F12838A0406B", hash_generated_method = "14E4F1BB4B1AE0107D41DFE36121649D")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        int keyCode = event.getKeyCode();
        final boolean uniqueDown = event.getRepeatCount() == 0
                && event.getAction() == KeyEvent.ACTION_DOWN;
        if(keyCode ==  KeyEvent.KEYCODE_HEADSETHOOK
                || keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE
                || keyCode == KeyEvent.KEYCODE_SPACE)        
        {
            if(uniqueDown)            
            {
                doPauseResume();
                show(sDefaultTimeout);
                if(mPauseButton != null)                
                {
                    mPauseButton.requestFocus();
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_2094745591 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431706375 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431706375;
        } //End block
        else
        if(keyCode == KeyEvent.KEYCODE_MEDIA_PLAY)        
        {
            if(uniqueDown && !mPlayer.isPlaying())            
            {
                mPlayer.start();
                updatePausePlay();
                show(sDefaultTimeout);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1008596611 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1203754172 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1203754172;
        } //End block
        else
        if(keyCode == KeyEvent.KEYCODE_MEDIA_STOP
                || keyCode == KeyEvent.KEYCODE_MEDIA_PAUSE)        
        {
            if(uniqueDown && mPlayer.isPlaying())            
            {
                mPlayer.pause();
                updatePausePlay();
                show(sDefaultTimeout);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_901872039 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918805796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_918805796;
        } //End block
        else
        if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN
                || keyCode == KeyEvent.KEYCODE_VOLUME_UP
                || keyCode == KeyEvent.KEYCODE_VOLUME_MUTE)        
        {
            boolean var639DD27D10E8FF69097B1398D445D1B9_1708297469 = (super.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1766011709 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1766011709;
        } //End block
        else
        if(keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_MENU)        
        {
            if(uniqueDown)            
            {
                hide();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1920889034 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545891003 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_545891003;
        } //End block
        show(sDefaultTimeout);
        boolean var639DD27D10E8FF69097B1398D445D1B9_1124342971 = (super.dispatchKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220608075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_220608075;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.334 -0400", hash_original_method = "B0869F9835F79F721C7D9CE04C896B2B", hash_generated_method = "C426C429605339CC86F18F1CAAB69E49")
    private void updatePausePlay() {
        if(mRoot == null || mPauseButton == null)        
        return;
        if(mPlayer.isPlaying())        
        {
            mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_pause);
        } //End block
        else
        {
            mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_play);
        } //End block
        // ---------- Original Method ----------
        //if (mRoot == null || mPauseButton == null)
            //return;
        //if (mPlayer.isPlaying()) {
            //mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_pause);
        //} else {
            //mPauseButton.setImageResource(com.android.internal.R.drawable.ic_media_play);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.334 -0400", hash_original_method = "F9113ED701E8317A61E1AB80861EF0B1", hash_generated_method = "A150864218C42F04F8F737162601D6BC")
    private void doPauseResume() {
        if(mPlayer.isPlaying())        
        {
            mPlayer.pause();
        } //End block
        else
        {
            mPlayer.start();
        } //End block
        updatePausePlay();
        // ---------- Original Method ----------
        //if (mPlayer.isPlaying()) {
            //mPlayer.pause();
        //} else {
            //mPlayer.start();
        //}
        //updatePausePlay();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.334 -0400", hash_original_method = "E14B391343AAAAC9B9A5DC8FE6A0AD92", hash_generated_method = "0AE0DE52DF2F525DF70DF8204A7FEAE2")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        if(mPauseButton != null)        
        {
            mPauseButton.setEnabled(enabled);
        } //End block
        if(mFfwdButton != null)        
        {
            mFfwdButton.setEnabled(enabled);
        } //End block
        if(mRewButton != null)        
        {
            mRewButton.setEnabled(enabled);
        } //End block
        if(mNextButton != null)        
        {
            mNextButton.setEnabled(enabled && mNextListener != null);
        } //End block
        if(mPrevButton != null)        
        {
            mPrevButton.setEnabled(enabled && mPrevListener != null);
        } //End block
        if(mProgress != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.335 -0400", hash_original_method = "8961D157AE11C5565BE89171B02042D7", hash_generated_method = "C56F3110B781E6F5A49332579E6C2734")
    private void installPrevNextListeners() {
        if(mNextButton != null)        
        {
            mNextButton.setOnClickListener(mNextListener);
            mNextButton.setEnabled(mNextListener != null);
        } //End block
        if(mPrevButton != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.336 -0400", hash_original_method = "89E197A0FA8E44785E0952D38D1CD31E", hash_generated_method = "04E78F473A4E8B881DD48F75D74FC695")
    public void setPrevNextListeners(View.OnClickListener next, View.OnClickListener prev) {
        mNextListener = next;
        mPrevListener = prev;
        mListenersSet = true;
        if(mRoot != null)        
        {
            installPrevNextListeners();
            if(mNextButton != null && !mFromXml)            
            {
                mNextButton.setVisibility(View.VISIBLE);
            } //End block
            if(mPrevButton != null && !mFromXml)            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.336 -0400", hash_original_field = "7BE17AB0EB2ECC15A01C1787C7756C84", hash_generated_field = "D48789DDA30E2CD97FBA0FDD6D61695B")

    private static final int sDefaultTimeout = 3000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.336 -0400", hash_original_field = "D4F6313C7D99CC2802E4CD3712C497AE", hash_generated_field = "9ABD36B6223DF65DDE8287EC24B7081F")

    private static final int FADE_OUT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.336 -0400", hash_original_field = "A6A1C610F332DB572E36F2177FB85997", hash_generated_field = "70CE4AFAC8782487EDA0398517E5F691")

    private static final int SHOW_PROGRESS = 2;
}

