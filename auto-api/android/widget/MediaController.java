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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "01AE51C88036C324EFB5646FEE9EB109", hash_generated_field = "C74867B897C11D551703ED8F09673E65")

    private MediaPlayerControl mPlayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "8A2549E4A331F412E0868B04A8E3C179", hash_generated_field = "B5073E9D1328D8D85272F118048A8168")

    private View mAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "45682D04D23E9DFA9A87C72737AEDE4C", hash_generated_field = "0ED6566025E9B439A5328FE9C573194D")

    private View mRoot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "90456FC221E7A82F02F5F0D86665E9D8", hash_generated_field = "BDE9FB2A6A09F560E3374107E2F57D26")

    private View mDecor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "05002D02EF9B36A1B7BF79BD9FBEC54A", hash_generated_field = "FE7534A506BE79955B21E465F7C91AA4")

    private WindowManager.LayoutParams mDecorLayoutParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "8E57A1AD458E8C11842F6CF5D7E06883", hash_generated_field = "77244E1CDBA901DF4A72F7384A95707A")

    private ProgressBar mProgress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "A0F28E4F5A99C619D8D824EA80594134", hash_generated_field = "A4C978CDA6C2D3809832A0A98832DBB6")

    private TextView mEndTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "268F636B4B5249EF5F354C806750D45C", hash_generated_field = "C0A1DCB994097ACA3510B7B3D309141F")

    private TextView mCurrentTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "ED7142E6C56E85275A9E1F55586553C1", hash_generated_field = "B79CA64D30F2326845D74336ECD5230C")

    private boolean mShowing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "B3298065CA384AB9C76E95FF12D862DF", hash_generated_field = "28D9C38A63CC0E8BC9E397ABC91A037C")

    private boolean mDragging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "B3F4B254B7C00EE15B00ABE4F7F15F0B", hash_generated_field = "398745AA0BD03CA62F1A35ECD505B4A0")

    private boolean mUseFastForward;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "AEC13D368249EDDA656425EDDFBDD188", hash_generated_field = "99698C9989636C991893ED4EDEAABFCA")

    private boolean mFromXml;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "04B250C72B2A42201A5C438E3A8C914C", hash_generated_field = "461D33372C05A8FD7B0B0B88A3A8E8C8")

    private boolean mListenersSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "AF42E80C05BFA2EDF3094674A5DA2DDB", hash_generated_field = "8AE10A114062F73ABA215E22225C6F88")

    private View.OnClickListener mNextListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "62A140AE126A21474397E00B2996BE52", hash_generated_field = "3F371EEFB52F4421082CFE70D26864AD")

    private View.OnClickListener mPrevListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.414 -0400", hash_original_field = "2DD9B7DC9B992033B17036351C1ED2F9", hash_generated_field = "8ED0E2EC59DE8D5B5B0284133B2ABFA3")

    StringBuilder mFormatBuilder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.531 -0400", hash_original_field = "9F70B7A1463B032732E51B2DC5F8D2E4", hash_generated_field = "180E02EA47264C617605A9175AD35DD3")

    Formatter mFormatter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.531 -0400", hash_original_field = "3D20693DD5EFCB0E52DD2EC00EED830B", hash_generated_field = "AAE39E66CF330D17558204D2F4FCB3A1")

    private ImageButton mPauseButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.531 -0400", hash_original_field = "85601BC374137C7C9E358B5DE187A90C", hash_generated_field = "8F96589974B5164F38263933E0F4391D")

    private ImageButton mFfwdButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.532 -0400", hash_original_field = "D3BEAE5637F85D7FC02CA0338A80DDDF", hash_generated_field = "F873DA12C5F252102530EBAB515330FA")

    private ImageButton mRewButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.532 -0400", hash_original_field = "25A8D69C909160605880E75D8AC0CC0C", hash_generated_field = "3194EEB3EABDFDC508551D1FE5DE2F37")

    private ImageButton mNextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.532 -0400", hash_original_field = "0EE34D2F4F7AC2CA3C11B1B38A204D08", hash_generated_field = "6FECDBBC365C7E42CC171554AB2D09A0")

    private ImageButton mPrevButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.532 -0400", hash_original_field = "660FD0A006FEE08090F60B78E5797043", hash_generated_field = "C1F05F8F50A6DEB169D8D4E3D625EC60")

    private OnLayoutChangeListener mLayoutChangeListener = new OnLayoutChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.532 -0400", hash_original_method = "B906B3E54DBAAD427317F640A60E799C", hash_generated_method = "02969F67A79B551D4857B063D0CDE2B2")
        public void onLayoutChange(View v, int left, int top, int right,
                int bottom, int oldLeft, int oldTop, int oldRight,
                int oldBottom) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            updateFloatingWindowLayout();
            {
                mWindowManager.updateViewLayout(mDecor, mDecorLayoutParams);
            } //End block
            addTaint(v.getTaint());
            addTaint(left);
            addTaint(top);
            addTaint(right);
            addTaint(bottom);
            addTaint(oldLeft);
            addTaint(oldTop);
            addTaint(oldRight);
            addTaint(oldBottom);
            // ---------- Original Method ----------
            //updateFloatingWindowLayout();
            //if (mShowing) {
                //mWindowManager.updateViewLayout(mDecor, mDecorLayoutParams);
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.533 -0400", hash_original_field = "73CE077A46042732A8F7D92A2C1AF8E9", hash_generated_field = "DB47839177E6532586D5D32641669B04")

    private OnTouchListener mTouchListener = new OnTouchListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.533 -0400", hash_original_method = "16F82C3AF10F7CC437B6D7BEE6D0DC69", hash_generated_method = "7EAC1839BAAE3710A262AE431C52F7E4")
        public boolean onTouch(View v, MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var1FBD87715268F23D17D833CE81073212_1223003828 = (event.getAction() == MotionEvent.ACTION_DOWN);
                {
                    {
                        hide();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            addTaint(v.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689454055 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_689454055;
            // ---------- Original Method ----------
            //if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //if (mShowing) {
                    //hide();
                //}
            //}
            //return false;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.534 -0400", hash_original_field = "52BC51643FEA9D0069B8F60CDBE72485", hash_generated_field = "625E271BD7A7BA9E259D291EEEAF1F71")

    private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.534 -0400", hash_original_method = "8F0BA1F98715C95935AC2F391AEFF8BC", hash_generated_method = "16B1FB505C92ECA843D9DA7348B75B04")
        @Override
        public void handleMessage(Message msg) {
            int pos;
            //Begin case FADE_OUT 
            hide();
            //End case FADE_OUT 
            //Begin case SHOW_PROGRESS 
            pos = setProgress();
            //End case SHOW_PROGRESS 
            //Begin case SHOW_PROGRESS 
            {
                boolean var35D9B4E6001F9970817DCA22BC2D906C_2063063958 = (!mDragging && mShowing && mPlayer.isPlaying());
                {
                    msg = obtainMessage(SHOW_PROGRESS);
                    sendMessageDelayed(msg, 1000 - (pos % 1000));
                } //End block
            } //End collapsed parenthetic
            //End case SHOW_PROGRESS 
            addTaint(msg.getTaint());
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

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.535 -0400", hash_original_field = "3C390C0F3EC8C6E76F3F8507AC8E9757", hash_generated_field = "F594E2FB32A5D33511282EF28BDD213A")

    private View.OnClickListener mPauseListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.535 -0400", hash_original_method = "F90DC617061E164BAEBDBFB1EA5D02BB", hash_generated_method = "811C9C24B7A4723801F0D8BF2718901B")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            doPauseResume();
            show(sDefaultTimeout);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            //doPauseResume();
            //show(sDefaultTimeout);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.537 -0400", hash_original_field = "2008B1EA87DEDE92B83942CF8FDFADEE", hash_generated_field = "55BDA96FB8D8CE6CF724DAA48FC1B109")

    private OnSeekBarChangeListener mSeekListener = new OnSeekBarChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.535 -0400", hash_original_method = "6758392684DBD95D44B26F154F80CA94", hash_generated_method = "F7437A498E3BC8B8A4C329E77821999A")
        public void onStartTrackingTouch(SeekBar bar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            show(3600000);
            mDragging = true;
            mHandler.removeMessages(SHOW_PROGRESS);
            addTaint(bar.getTaint());
            // ---------- Original Method ----------
            //show(3600000);
            //mDragging = true;
            //mHandler.removeMessages(SHOW_PROGRESS);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.536 -0400", hash_original_method = "A0EB029A26053134120EC96D7E9882E8", hash_generated_method = "F79F34AF3061D3D5F357D21432426A65")
        public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            long duration;
            duration = mPlayer.getDuration();
            long newposition;
            newposition = (duration * progress) / 1000L;
            mPlayer.seekTo( (int) newposition);
            mCurrentTime.setText(stringForTime( (int) newposition));
            addTaint(bar.getTaint());
            addTaint(progress);
            addTaint(fromuser);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.537 -0400", hash_original_method = "53B60B6767600F274A52648AF75E3493", hash_generated_method = "AC47A2FB017606BEB8453C4173FA9028")
        public void onStopTrackingTouch(SeekBar bar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDragging = false;
            setProgress();
            updatePausePlay();
            show(sDefaultTimeout);
            mHandler.sendEmptyMessage(SHOW_PROGRESS);
            addTaint(bar.getTaint());
            // ---------- Original Method ----------
            //mDragging = false;
            //setProgress();
            //updatePausePlay();
            //show(sDefaultTimeout);
            //mHandler.sendEmptyMessage(SHOW_PROGRESS);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.540 -0400", hash_original_field = "9A9DC70DF59B8B1F6B8A9A0C085DFDEA", hash_generated_field = "EFB437624E8ED984FC3EC97C9F9494EE")

    private View.OnClickListener mRewListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.540 -0400", hash_original_method = "B5D53DC8A12E02793B3EF0C8511F70D5", hash_generated_method = "16D86295205B43BD41D26CCE2690C26F")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int pos;
            pos = mPlayer.getCurrentPosition();
            pos -= 5000;
            mPlayer.seekTo(pos);
            setProgress();
            show(sDefaultTimeout);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            //int pos = mPlayer.getCurrentPosition();
            //pos -= 5000;
            //mPlayer.seekTo(pos);
            //setProgress();
            //show(sDefaultTimeout);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.540 -0400", hash_original_field = "50D091DCCFB4B00402EDDB2863541762", hash_generated_field = "9BA9E900524B8C78F01DF3EACADF9AE1")

    private View.OnClickListener mFfwdListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.540 -0400", hash_original_method = "BF054D35499B7B032734EBAD3598DA2F", hash_generated_method = "DBA8B2188B03C20350E769926ED4A269")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            int pos;
            pos = mPlayer.getCurrentPosition();
            pos += 15000;
            mPlayer.seekTo(pos);
            setProgress();
            show(sDefaultTimeout);
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            //int pos = mPlayer.getCurrentPosition();
            //pos += 15000;
            //mPlayer.seekTo(pos);
            //setProgress();
            //show(sDefaultTimeout);
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.559 -0400", hash_original_method = "3C97480952764669863839416E96E876", hash_generated_method = "803705B89AE5AE47280A7C06171A868A")
    public  MediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRoot = this;
        mContext = context;
        mUseFastForward = true;
        mFromXml = true;
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //mRoot = this;
        //mContext = context;
        //mUseFastForward = true;
        //mFromXml = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.559 -0400", hash_original_method = "D7A2F0702C06D7B537ED0824ED57856A", hash_generated_method = "B65AF034FAB2F65FF040F15D7506060C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.560 -0400", hash_original_method = "7386C8F43CBDAAD1A4C1AD10A9F3EB18", hash_generated_method = "BAEFEC7F4C63BFD48EB9DB265AE5D93D")
    public  MediaController(Context context) {
        this(context, true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.560 -0400", hash_original_method = "73B20F41AD38A9B689CAB773B229DC2D", hash_generated_method = "5065BD46B7C5F2139BCBE70E1A5E9581")
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        initControllerView(mRoot);
        // ---------- Original Method ----------
        //if (mRoot != null)
            //initControllerView(mRoot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.561 -0400", hash_original_method = "5AB721CF8AD66EE5762FE50902543B8E", hash_generated_method = "23191FD52B96F9E7404E05B0D03554AA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.581 -0400", hash_original_method = "A15216BA04857F16D27E94A01ED8D9C8", hash_generated_method = "17BE4F9613FD542D16205973D3B48E9A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.582 -0400", hash_original_method = "273528B94A02173E736183C73352565A", hash_generated_method = "632D4E6BC23514C0A110F17AE75F3F27")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.583 -0400", hash_original_method = "9E3EB1A0CE9430F92BE04C3BC9E64024", hash_generated_method = "23FF24D7ABA4F4BB5C5B958C3ED006D7")
    public void setMediaPlayer(MediaPlayerControl player) {
        mPlayer = player;
        updatePausePlay();
        // ---------- Original Method ----------
        //mPlayer = player;
        //updatePausePlay();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.583 -0400", hash_original_method = "A3367E3EA3926FFA5E8601886A545624", hash_generated_method = "5AD66E9943D41BE982AA32D7EAB0BDE3")
    public void setAnchorView(View view) {
        {
            mAnchor.removeOnLayoutChangeListener(mLayoutChangeListener);
        } //End block
        mAnchor = view;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.584 -0400", hash_original_method = "47AAB8ACF83F9E0950F4FC2EF0028588", hash_generated_method = "1E41028A6D17C6E1776999AE53B2D157")
    protected View makeControllerView() {
        View varB4EAC82CA7396A68D541C85D26508E83_564224304 = null; //Variable for return #1
        LayoutInflater inflate;
        inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mRoot = inflate.inflate(com.android.internal.R.layout.media_controller, null);
        initControllerView(mRoot);
        varB4EAC82CA7396A68D541C85D26508E83_564224304 = mRoot;
        varB4EAC82CA7396A68D541C85D26508E83_564224304.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_564224304;
        // ---------- Original Method ----------
        //LayoutInflater inflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //mRoot = inflate.inflate(com.android.internal.R.layout.media_controller, null);
        //initControllerView(mRoot);
        //return mRoot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.600 -0400", hash_original_method = "6027E965805CA7D75D241C044D75CFC3", hash_generated_method = "394613F024A1CC4E77FBFCE3B40916D1")
    private void initControllerView(View v) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.601 -0400", hash_original_method = "F96F3B42B5EBC38D2746BE6361617E40", hash_generated_method = "5CD112AEC01E8D805545E23D791EAB4F")
    public void show() {
        show(sDefaultTimeout);
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.601 -0400", hash_original_method = "4DD833D5B8F1F18277B038D9576E3A42", hash_generated_method = "9423255075747BEDC0068513B35D0F19")
    private void disableUnsupportedButtons() {
        try 
        {
            {
                boolean var04420E786547552434EA412F4670514B_1606673519 = (mPauseButton != null && !mPlayer.canPause());
                {
                    mPauseButton.setEnabled(false);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varFB4189471DF28B1D9A20DFA7E064DD07_1640232655 = (mRewButton != null && !mPlayer.canSeekBackward());
                {
                    mRewButton.setEnabled(false);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBD8FEE18503E03CF186AC55EA6F38B48_783628697 = (mFfwdButton != null && !mPlayer.canSeekForward());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.602 -0400", hash_original_method = "C16367489FF99029DA16F545FE506814", hash_generated_method = "54C1363AE0CCF12BE434279FC5D3BAA6")
    public void show(int timeout) {
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
        addTaint(timeout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.602 -0400", hash_original_method = "F21458EB6FE36A924A49B40493E1F9F8", hash_generated_method = "FA9C61AC4A464BB29117CF59C5778A0B")
    public boolean isShowing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990083029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990083029;
        // ---------- Original Method ----------
        //return mShowing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.616 -0400", hash_original_method = "AF640FD924E8B1DADC076D8A3DA6C51B", hash_generated_method = "1F5C46428125BAD24C2F883E583D0333")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.617 -0400", hash_original_method = "E3DEF3CD65DC2BEF1837B2236B56198B", hash_generated_method = "AF33C55E923D2A4CD4A75CEB95A5598B")
    private String stringForTime(int timeMs) {
        String varB4EAC82CA7396A68D541C85D26508E83_561062572 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1872747707 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_561062572 = mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1872747707 = mFormatter.format("%02d:%02d", minutes, seconds).toString();
        } //End block
        addTaint(timeMs);
        String varA7E53CE21691AB073D9660D615818899_230644777; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_230644777 = varB4EAC82CA7396A68D541C85D26508E83_561062572;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_230644777 = varB4EAC82CA7396A68D541C85D26508E83_1872747707;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_230644777.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_230644777;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.617 -0400", hash_original_method = "972585652F798E535DB73510970F52DB", hash_generated_method = "A4B5FC8911DC90811C106A5B9019D72D")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484918512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1484918512;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.618 -0400", hash_original_method = "804998442429040CE8E4A7C248858770", hash_generated_method = "C8C5320A9D6E2305D7AC2AFE7AFAAB8A")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        show(sDefaultTimeout);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473879890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473879890;
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.618 -0400", hash_original_method = "294FBCC6A05258601D3163C3FD371667", hash_generated_method = "D110171AE147B044B94FA1B40EF8559D")
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        show(sDefaultTimeout);
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593550354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593550354;
        // ---------- Original Method ----------
        //show(sDefaultTimeout);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.619 -0400", hash_original_method = "F0666CB3DD2163E885B9F12838A0406B", hash_generated_method = "CE141F64302E39D0A100B958A9495067")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
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
                boolean varF17116D0C67035A5A337856ABC12607F_1511394729 = (uniqueDown && !mPlayer.isPlaying());
                {
                    mPlayer.start();
                    updatePausePlay();
                    show(sDefaultTimeout);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var27755F5C4D0C9AF06EFD67EBF4777196_1722542357 = (uniqueDown && mPlayer.isPlaying());
                {
                    mPlayer.pause();
                    updatePausePlay();
                    show(sDefaultTimeout);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varD6051F78D5E57D3CCCE2FBA8ECC49974_1283858582 = (super.dispatchKeyEvent(event));
        } //End block
        {
            {
                hide();
            } //End block
        } //End block
        show(sDefaultTimeout);
        boolean varD8A05597F0CCFB3ED5A50CCF86C0200D_2020455747 = (super.dispatchKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1641002458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1641002458;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.625 -0400", hash_original_method = "B0869F9835F79F721C7D9CE04C896B2B", hash_generated_method = "60B0D877E9F6A29715DB112542764001")
    private void updatePausePlay() {
        {
            boolean var39B4349F3FF67B6FA000A266CC9AF48C_1122026719 = (mPlayer.isPlaying());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.626 -0400", hash_original_method = "F9113ED701E8317A61E1AB80861EF0B1", hash_generated_method = "0A5CD35630CE069C9B5EFB55134F97DA")
    private void doPauseResume() {
        {
            boolean var39B4349F3FF67B6FA000A266CC9AF48C_405379004 = (mPlayer.isPlaying());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.626 -0400", hash_original_method = "E14B391343AAAAC9B9A5DC8FE6A0AD92", hash_generated_method = "7BA2984B6DE143AB90B08012AA2D25C6")
    @Override
    public void setEnabled(boolean enabled) {
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
        addTaint(enabled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.635 -0400", hash_original_method = "8961D157AE11C5565BE89171B02042D7", hash_generated_method = "38F86077F05FB924FB4C8C295DECE528")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.636 -0400", hash_original_method = "89E197A0FA8E44785E0952D38D1CD31E", hash_generated_method = "26EA8E1AE5243AD077819E1F71EA8A5F")
    public void setPrevNextListeners(View.OnClickListener next, View.OnClickListener prev) {
        mNextListener = next;
        mPrevListener = prev;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.636 -0400", hash_original_field = "7BE17AB0EB2ECC15A01C1787C7756C84", hash_generated_field = "C726B3BFD77CE47446ADAEA147019302")

    private static int sDefaultTimeout = 3000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.636 -0400", hash_original_field = "D4F6313C7D99CC2802E4CD3712C497AE", hash_generated_field = "42A3A5DC181958DBEDCBB0B68D3A5FD0")

    private static int FADE_OUT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:07.636 -0400", hash_original_field = "A6A1C610F332DB572E36F2177FB85997", hash_generated_field = "60FEDE54C7FB45861884FE64E057FF68")

    private static int SHOW_PROGRESS = 2;
}

