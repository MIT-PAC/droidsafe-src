package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.widget.ImageView.ScaleType;
import android.graphics.Rect;
import com.android.internal.R;
import android.view.animation.Animation;
import android.os.Vibrator;
import android.util.Log;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.view.Gravity;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.content.Context;
import android.view.animation.Animation.AnimationListener;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.view.animation.AlphaAnimation;
import android.content.res.Resources;
import android.content.res.TypedArray;
public class SlidingTab extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.322 -0400", hash_original_field = "949A7EDC2976D9795F6AE187848A75B4", hash_generated_field = "87DD4E65E8BA8C1853DB66048F69C334")

    private boolean mHoldLeftOnTransition = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "DE497DFA16700E3A54D66948865F3C30", hash_generated_field = "27FDAEC5DDD09E03923FA91E070E03C7")

    private boolean mHoldRightOnTransition = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "BB32CCD8F958DE59F4FB742C226D38D4", hash_generated_field = "B712B682ACEFEF430B86ECE8AB423B62")

    private OnTriggerListener mOnTriggerListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "9401A080EFFEB267188E5A18F9B231F0", hash_generated_field = "B89829B5C1E4F1B375033ED91ED11EB3")

    private int mGrabbedState = OnTriggerListener.NO_HANDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "EEAE67ABEB40C78AC788EEDB981D579A", hash_generated_field = "03CAFF1CDCBC878A8017FEF1EDA41BE5")

    private boolean mTriggered = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "560EC933FF5763F980C1AAA7887459D4", hash_generated_field = "28ADEC971991F1A5C05DC67784FF191A")

    private Vibrator mVibrator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "174BB9FF4691CBE6254BA90AE9FA0B63", hash_generated_field = "3AA5A5B55A0934DBD9189CC23B24D00A")

    private float mDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "0B174D00997B828633D7025DB5B13B50")

    private int mOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "CF858703354F157DD59AA4409538865E", hash_generated_field = "90DFE06DDAE74DAA3EA213A9C6D1E6A6")

    private Slider mLeftSlider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "01A33C5F1A2E5F8084C44A9CAA091B22", hash_generated_field = "43248ADDDF958148F6E52E19E9AFBAF4")

    private Slider mRightSlider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.323 -0400", hash_original_field = "54ABF8494C31FA833CD5E2BCDC510E96", hash_generated_field = "89BEA8AC89D294843C1767B87673E8C2")

    private Slider mCurrentSlider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.324 -0400", hash_original_field = "1E1CC85914707D75E1771795C8BD6A9B", hash_generated_field = "D311D33EB50C15583CB88C72ABD7A592")

    private boolean mTracking;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.324 -0400", hash_original_field = "3C3C53D359DFC0BF874C1D7D1521B140", hash_generated_field = "1CE14C8672D308940325143A876CAF83")

    private float mThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.324 -0400", hash_original_field = "52AFA4E40CD660D85A26145C87838EA6", hash_generated_field = "B6F1054407E5FE4AAED7E08F20ECE2EF")

    private Slider mOtherSlider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.324 -0400", hash_original_field = "4CBE2C29B096DEAFE05278D33E5C3A71", hash_generated_field = "854092FC87CCBE5E499FE3FB8F6394C7")

    private boolean mAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.324 -0400", hash_original_field = "0331E47DC09228E0BAEE33B616D8B5D5", hash_generated_field = "0D58E99B18C0985375901538C8E673B1")

    private Rect mTmpRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.326 -0400", hash_original_field = "C4899C1263A2AA1B91BF78F76D8A9F54", hash_generated_field = "29D5EADB60A65AE79F3A432D3249A0A7")

    private final AnimationListener mAnimationDoneListener = new AnimationListener()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.325 -0400", hash_original_method = "72AD432A5D6B612A6CC4174C0C1E057D", hash_generated_method = "49F75D36E9220C354C54A62CF953C433")
        public void onAnimationStart(Animation animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.325 -0400", hash_original_method = "C6539FC3721A6B610C21747FF87D7A97", hash_generated_method = "613F2BDFC68B49C11B83816900750682")
        public void onAnimationRepeat(Animation animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.326 -0400", hash_original_method = "3C16D8B1C9A6749AEE45F242072141C6", hash_generated_method = "7A7FE4723C9332F69270F84F9A5D5D7A")
        public void onAnimationEnd(Animation animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
onAnimationDone()
            // ---------- Original Method ----------
            //onAnimationDone();
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.326 -0400", hash_original_method = "B10B59A627D1A251E99DD385E5ED67CA", hash_generated_method = "5A210CA459A6479C8F3672EC37AA2845")
    public  SlidingTab(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.327 -0400", hash_original_method = "6F2D3B40680A1E89F54FC01F838E6ABC", hash_generated_method = "5D77E0CD14DF3B84AC2A991245631101")
    public  SlidingTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
mTmpRect=new Rect()        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SlidingTab);
mOrientation=a.getInt(R.styleable.SlidingTab_orientation, HORIZONTAL)a.recycle()        Resources r = getResources();
mDensity=r.getDisplayMetrics().density        if(DBG)        
log("- Density: "+mDensity)
mLeftSlider=new Slider(this, R.drawable.jog_tab_left_generic, R.drawable.jog_tab_bar_left_generic, R.drawable.jog_tab_target_gray)mRightSlider=new Slider(this, R.drawable.jog_tab_right_generic, R.drawable.jog_tab_bar_right_generic, R.drawable.jog_tab_target_gray)
        // ---------- Original Method ----------
        //mTmpRect = new Rect();
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SlidingTab);
        //mOrientation = a.getInt(R.styleable.SlidingTab_orientation, HORIZONTAL);
        //a.recycle();
        //Resources r = getResources();
        //mDensity = r.getDisplayMetrics().density;
        //if (DBG) log("- Density: " + mDensity);
        //mLeftSlider = new Slider(this,
                //R.drawable.jog_tab_left_generic,
                //R.drawable.jog_tab_bar_left_generic,
                //R.drawable.jog_tab_target_gray);
        //mRightSlider = new Slider(this,
                //R.drawable.jog_tab_right_generic,
                //R.drawable.jog_tab_bar_right_generic,
                //R.drawable.jog_tab_target_gray);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.328 -0400", hash_original_method = "074293B702AE37004A536C67867B33F3", hash_generated_method = "9FAEA02AD6009769AEF1325EFBB49AAB")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if(DBG)        
        {
            if(widthSpecMode==MeasureSpec.UNSPECIFIED||heightSpecMode==MeasureSpec.UNSPECIFIED)            
            {
            } //End block
        } //End block
mLeftSlider.measure()mRightSlider.measure()        final int leftTabWidth = mLeftSlider.getTabWidth();
        final int rightTabWidth = mRightSlider.getTabWidth();
        final int leftTabHeight = mLeftSlider.getTabHeight();
        final int rightTabHeight = mRightSlider.getTabHeight();
        int width;
        int height;
        if(isHorizontal())        
        {
width=Math.max(widthSpecSize, leftTabWidth+rightTabWidth)height=Math.max(leftTabHeight, rightTabHeight)
        } //End block
        else
        {
width=Math.max(leftTabWidth, rightTabHeight)height=Math.max(heightSpecSize, leftTabHeight+rightTabHeight)
        } //End block
setMeasuredDimension(width, height)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.330 -0400", hash_original_method = "58C544845142811BC29A1FF5AC6784B1", hash_generated_method = "7E98C524A6C1D198CD210A0AC4153F22")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        final int action = event.getAction();
        final float x = event.getX();
        final float y = event.getY();
        if(mAnimating)        
        {
            boolean var68934A3E9455FA72420237EB05902327_827030959 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899609751 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_899609751;
        } //End block
        View leftHandle = mLeftSlider.tab;
leftHandle.getHitRect(mTmpRect)        boolean leftHit = mTmpRect.contains((int) x, (int) y);
        View rightHandle = mRightSlider.tab;
rightHandle.getHitRect(mTmpRect)        boolean rightHit = mTmpRect.contains((int)x, (int) y);
        if(!mTracking&&!(leftHit||rightHit))        
        {
            boolean var68934A3E9455FA72420237EB05902327_720735788 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114066083 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114066083;
        } //End block
        switch(action){
        case MotionEvent.ACTION_DOWN:
        {
mTracking=truemTriggered=falsevibrate(VIBRATE_SHORT)            if(leftHit)            
            {
mCurrentSlider=mLeftSlidermOtherSlider=mRightSlidermThreshold=isHorizontal()?THRESHOLD:THRESHOLDsetGrabbedState(OnTriggerListener.LEFT_HANDLE)
            } //End block
            else
            {
mCurrentSlider=mRightSlidermOtherSlider=mLeftSlidermThreshold=isHorizontal()?1.0f-THRESHOLD:1.0f-THRESHOLDsetGrabbedState(OnTriggerListener.RIGHT_HANDLE)
            } //End block
mCurrentSlider.setState(Slider.STATE_PRESSED)mCurrentSlider.showTarget()mOtherSlider.hide()            break;
        } //End block
}        boolean varB326B5062B2F0E69046810717534CB09_1063799907 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758747042 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758747042;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.331 -0400", hash_original_method = "A5FEB6131D54CD3455375D25EC50A622", hash_generated_method = "84E77BB8D9F70E52139166351E908A50")
    public void reset(boolean animate) {
        addTaint(animate);
mLeftSlider.reset(animate)mRightSlider.reset(animate)        if(!animate)        
        {
mAnimating=false
        } //End block
        // ---------- Original Method ----------
        //mLeftSlider.reset(animate);
        //mRightSlider.reset(animate);
        //if (!animate) {
            //mAnimating = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.331 -0400", hash_original_method = "ABD35D4B9055FEC4B75625AF4A0089AC", hash_generated_method = "B36E126066802AFDF7B6B2C0781F1247")
    @Override
    public void setVisibility(int visibility) {
        addTaint(visibility);
        if(visibility!=getVisibility()&&visibility==View.INVISIBLE)        
        {
reset(false)
        } //End block
super.setVisibility(visibility)
        // ---------- Original Method ----------
        //if (visibility != getVisibility() && visibility == View.INVISIBLE) {
           //reset(false);
        //}
        //super.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.332 -0400", hash_original_method = "FEDDAA167707A734F4A33F91DCC4603B", hash_generated_method = "C717E518758672FE0D5E268CEF48D0E4")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(mTracking)        
        {
            final int action = event.getAction();
            final float x = event.getX();
            final float y = event.getY();
            switch(action){
            case MotionEvent.ACTION_MOVE:
            if(withinView(x, y, this))            
            {
moveHandle(x, y)                float position = isHorizontal() ? x : y;
                float target = mThreshold * (isHorizontal() ? getWidth() : getHeight());
                boolean thresholdReached;
                if(isHorizontal())                
                {
thresholdReached=mCurrentSlider==mLeftSlider?position>target:position>target
                } //End block
                else
                {
thresholdReached=mCurrentSlider==mLeftSlider?position<target:position<target
                } //End block
                if(!mTriggered&&thresholdReached)                
                {
mTriggered=truemTracking=falsemCurrentSlider.setState(Slider.STATE_ACTIVE)                    boolean isLeft = mCurrentSlider == mLeftSlider;
dispatchTriggerEvent(isLeft?OnTriggerListener.LEFT_HANDLE:OnTriggerListener.LEFT_HANDLE)startAnimating(isLeft?mHoldLeftOnTransition:mHoldLeftOnTransition)setGrabbedState(OnTriggerListener.NO_HANDLE)
                } //End block
                break;
            } //End block
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
cancelGrab()            break;
}
        } //End block
        boolean varDA4B28F93C46355C9929A9FEFCEFFAE9_275141462 = (mTracking||super.onTouchEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471558258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471558258;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.333 -0400", hash_original_method = "FD31AEA49A51FAE202091A0C000F4336", hash_generated_method = "65060173493D752ACFEB5B717BAF6CF5")
    private void cancelGrab() {
mTracking=falsemTriggered=falsemOtherSlider.show(true)mCurrentSlider.reset(false)mCurrentSlider.hideTarget()mCurrentSlider=nullmOtherSlider=nullsetGrabbedState(OnTriggerListener.NO_HANDLE)
        // ---------- Original Method ----------
        //mTracking = false;
        //mTriggered = false;
        //mOtherSlider.show(true);
        //mCurrentSlider.reset(false);
        //mCurrentSlider.hideTarget();
        //mCurrentSlider = null;
        //mOtherSlider = null;
        //setGrabbedState(OnTriggerListener.NO_HANDLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.335 -0400", hash_original_method = "CFF2AB3ED932910407BA9F708ADF08AE", hash_generated_method = "9711CBD94C1506F944D3759243DDEE24")
     void startAnimating(final boolean holdAfter) {
        addTaint(holdAfter);
mAnimating=true        Animation trans1;
        Animation trans2;
        final Slider slider = mCurrentSlider;
        final Slider other = mOtherSlider;
        int dx;
        int dy;
        if(isHorizontal())        
        {
            int right = slider.tab.getRight();
            int width = slider.tab.getWidth();
            int left = slider.tab.getLeft();
            int viewWidth = getWidth();
            int holdOffset = holdAfter ? 0 : width;
dx=slider==mRightSlider?-(right+viewWidth-holdOffset):-(right+viewWidth-holdOffset)dy=0
        } //End block
        else
        {
            int top = slider.tab.getTop();
            int bottom = slider.tab.getBottom();
            int height = slider.tab.getHeight();
            int viewHeight = getHeight();
            int holdOffset = holdAfter ? 0 : height;
dx=0dy=slider==mRightSlider?(top+viewHeight-holdOffset):(top+viewHeight-holdOffset)
        } //End block
trans1=new TranslateAnimation(0, dx, 0, dy)trans1.setDuration(ANIM_DURATION)trans1.setInterpolator(new LinearInterpolator())trans1.setFillAfter(true)trans2=new TranslateAnimation(0, dx, 0, dy)trans2.setDuration(ANIM_DURATION)trans2.setInterpolator(new LinearInterpolator())trans2.setFillAfter(true)trans1.setAnimationListener(new AnimationListener()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.334 -0400", hash_original_method = "0DB757058418C18043B673CC6DA2AD44", hash_generated_method = "29E6ADADAB23A510A8F0980E132A2511")
        public void onAnimationEnd(Animation animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            Animation anim;
            if(holdAfter)            
            {
anim=new TranslateAnimation(dx, dx, dy, dy)anim.setDuration(1000)mAnimating=false
            } //End block
            else
            {
anim=new AlphaAnimation(0.5f, 1.0f)anim.setDuration(ANIM_DURATION)resetView()
            } //End block
anim.setAnimationListener(mAnimationDoneListener)mLeftSlider.startAnimation(anim, anim)mRightSlider.startAnimation(anim, anim)
            // ---------- Original Method ----------
            //Animation anim;
            //if (holdAfter) {
                    //anim = new TranslateAnimation(dx, dx, dy, dy);
                    //anim.setDuration(1000); 
                    //mAnimating = false;
                //} else {
                    //anim = new AlphaAnimation(0.5f, 1.0f);
                    //anim.setDuration(ANIM_DURATION);
                    //resetView();
                //}
            //anim.setAnimationListener(mAnimationDoneListener);
            //mLeftSlider.startAnimation(anim, anim);
            //mRightSlider.startAnimation(anim, anim);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.334 -0400", hash_original_method = "C6539FC3721A6B610C21747FF87D7A97", hash_generated_method = "613F2BDFC68B49C11B83816900750682")
        public void onAnimationRepeat(Animation animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.334 -0400", hash_original_method = "72AD432A5D6B612A6CC4174C0C1E057D", hash_generated_method = "49F75D36E9220C354C54A62CF953C433")
        public void onAnimationStart(Animation animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }
        }
)slider.hideTarget()slider.startAnimation(trans1, trans2)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.335 -0400", hash_original_method = "E98A2ABB86DB5FECCDF7AA9C3D004CAE", hash_generated_method = "1D526501026348456557647AF628E4C4")
    private void onAnimationDone() {
resetView()mAnimating=false
        // ---------- Original Method ----------
        //resetView();
        //mAnimating = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.335 -0400", hash_original_method = "87F8AB98224CF02404CF8C953D4EF82C", hash_generated_method = "D2F925F68799389AC35C52ED38F8E5B2")
    private boolean withinView(final float x, final float y, final View view) {
        addTaint(view.getTaint());
        addTaint(y);
        addTaint(x);
        boolean varCFC996E7C12C6BE42A645436BC109902_1108485254 = (isHorizontal()&&y>-TRACKING_MARGIN&&y<TRACKING_MARGIN+view.getHeight()||!isHorizontal()&&x>-TRACKING_MARGIN&&x<TRACKING_MARGIN+view.getWidth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2090150739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2090150739;
        // ---------- Original Method ----------
        //return isHorizontal() && y > - TRACKING_MARGIN && y < TRACKING_MARGIN + view.getHeight()
            //|| !isHorizontal() && x > -TRACKING_MARGIN && x < TRACKING_MARGIN + view.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.336 -0400", hash_original_method = "DCDAC0C48E424F3E822192B9FE12E714", hash_generated_method = "4A17DE3485DC612D9EEF3D949826BE2C")
    private boolean isHorizontal() {
        boolean var46133C5AEE158ADCCA6166947D25BEA2_829191172 = (mOrientation==HORIZONTAL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304435434 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304435434;
        // ---------- Original Method ----------
        //return mOrientation == HORIZONTAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.336 -0400", hash_original_method = "1C09F0BB8954910A0068BA2B1F49FDA1", hash_generated_method = "50AFA5B0F268F912B0EA1EAC5797B017")
    private void resetView() {
mLeftSlider.reset(false)mRightSlider.reset(false)
        // ---------- Original Method ----------
        //mLeftSlider.reset(false);
        //mRightSlider.reset(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.336 -0400", hash_original_method = "8A9E89F84859D4327D4F6A139BC750DC", hash_generated_method = "1EF0D1535AE04FBE864DDB2912182303")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
        if(!changed)        
        return;
mLeftSlider.layout(l, t, r, b, isHorizontal()?Slider.ALIGN_LEFT:Slider.ALIGN_LEFT)mRightSlider.layout(l, t, r, b, isHorizontal()?Slider.ALIGN_RIGHT:Slider.ALIGN_RIGHT)
        // ---------- Original Method ----------
        //if (!changed) return;
        //mLeftSlider.layout(l, t, r, b, isHorizontal() ? Slider.ALIGN_LEFT : Slider.ALIGN_BOTTOM);
        //mRightSlider.layout(l, t, r, b, isHorizontal() ? Slider.ALIGN_RIGHT : Slider.ALIGN_TOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.337 -0400", hash_original_method = "669A0EA726A965E44629701BAC91B72C", hash_generated_method = "C8260F75FFD327B1491048FCE792CF65")
    private void moveHandle(float x, float y) {
        addTaint(y);
        addTaint(x);
        final View handle = mCurrentSlider.tab;
        final View content = mCurrentSlider.text;
        if(isHorizontal())        
        {
            int deltaX = (int) x - handle.getLeft() - (handle.getWidth() / 2);
handle.offsetLeftAndRight(deltaX)content.offsetLeftAndRight(deltaX)
        } //End block
        else
        {
            int deltaY = (int) y - handle.getTop() - (handle.getHeight() / 2);
handle.offsetTopAndBottom(deltaY)content.offsetTopAndBottom(deltaY)
        } //End block
invalidate()
        // ---------- Original Method ----------
        //final View handle = mCurrentSlider.tab;
        //final View content = mCurrentSlider.text;
        //if (isHorizontal()) {
            //int deltaX = (int) x - handle.getLeft() - (handle.getWidth() / 2);
            //handle.offsetLeftAndRight(deltaX);
            //content.offsetLeftAndRight(deltaX);
        //} else {
            //int deltaY = (int) y - handle.getTop() - (handle.getHeight() / 2);
            //handle.offsetTopAndBottom(deltaY);
            //content.offsetTopAndBottom(deltaY);
        //}
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.337 -0400", hash_original_method = "7F403B65F3749D253F97D3BAE7991B03", hash_generated_method = "08CBF2996513F8F338B4D33C2F1AAC7D")
    public void setLeftTabResources(int iconId, int targetId, int barId, int tabId) {
        addTaint(tabId);
        addTaint(barId);
        addTaint(targetId);
        addTaint(iconId);
mLeftSlider.setIcon(iconId)mLeftSlider.setTarget(targetId)mLeftSlider.setBarBackgroundResource(barId)mLeftSlider.setTabBackgroundResource(tabId)mLeftSlider.updateDrawableStates()
        // ---------- Original Method ----------
        //mLeftSlider.setIcon(iconId);
        //mLeftSlider.setTarget(targetId);
        //mLeftSlider.setBarBackgroundResource(barId);
        //mLeftSlider.setTabBackgroundResource(tabId);
        //mLeftSlider.updateDrawableStates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.338 -0400", hash_original_method = "26919250F40976DF4A1B07B9509D2885", hash_generated_method = "B0DBEAB69829750A72655D567F73306B")
    public void setLeftHintText(int resId) {
        addTaint(resId);
        if(isHorizontal())        
        {
mLeftSlider.setHintText(resId)
        } //End block
        // ---------- Original Method ----------
        //if (isHorizontal()) {
            //mLeftSlider.setHintText(resId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.338 -0400", hash_original_method = "4A724E18A963D3715500EC3659764E38", hash_generated_method = "DEBBD9BFE655C59E4960B2E50B3A995C")
    public void setRightTabResources(int iconId, int targetId, int barId, int tabId) {
        addTaint(tabId);
        addTaint(barId);
        addTaint(targetId);
        addTaint(iconId);
mRightSlider.setIcon(iconId)mRightSlider.setTarget(targetId)mRightSlider.setBarBackgroundResource(barId)mRightSlider.setTabBackgroundResource(tabId)mRightSlider.updateDrawableStates()
        // ---------- Original Method ----------
        //mRightSlider.setIcon(iconId);
        //mRightSlider.setTarget(targetId);
        //mRightSlider.setBarBackgroundResource(barId);
        //mRightSlider.setTabBackgroundResource(tabId);
        //mRightSlider.updateDrawableStates();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.338 -0400", hash_original_method = "B07DD98D75F502910A1206A56D0DD3AC", hash_generated_method = "168432644F9AF14D141190F69F9DF5F9")
    public void setRightHintText(int resId) {
        addTaint(resId);
        if(isHorizontal())        
        {
mRightSlider.setHintText(resId)
        } //End block
        // ---------- Original Method ----------
        //if (isHorizontal()) {
            //mRightSlider.setHintText(resId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.339 -0400", hash_original_method = "DDD3F815BB5E96918559362167FD7054", hash_generated_method = "C8C2CACCAB9C982330368CC6D3FC8355")
    public void setHoldAfterTrigger(boolean holdLeft, boolean holdRight) {
        addTaint(holdRight);
        addTaint(holdLeft);
mHoldLeftOnTransition=holdLeftmHoldRightOnTransition=holdRight
        // ---------- Original Method ----------
        //mHoldLeftOnTransition = holdLeft;
        //mHoldRightOnTransition = holdRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.339 -0400", hash_original_method = "B33E756DD8C89F43C3A0B63F78052840", hash_generated_method = "6C19DF9FF91FDC6A53A654512A03AA5E")
    private synchronized void vibrate(long duration) {
        addTaint(duration);
        if(mVibrator==null)        
        {
mVibrator=(android.os.Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE)
        } //End block
mVibrator.vibrate(duration)
        // ---------- Original Method ----------
        //if (mVibrator == null) {
            //mVibrator = (android.os.Vibrator)
                    //getContext().getSystemService(Context.VIBRATOR_SERVICE);
        //}
        //mVibrator.vibrate(duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.339 -0400", hash_original_method = "55E97AC0CD8F0BA7A04BDE23F0852D07", hash_generated_method = "47476DEC32908605480C68DFE2ACFFF8")
    public void setOnTriggerListener(OnTriggerListener listener) {
        addTaint(listener.getTaint());
mOnTriggerListener=listener
        // ---------- Original Method ----------
        //mOnTriggerListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.340 -0400", hash_original_method = "12014E18CBCA46015F32E40C3F31C06F", hash_generated_method = "7394F2AE61B8CFFC91599BE358F851D4")
    private void dispatchTriggerEvent(int whichHandle) {
        addTaint(whichHandle);
vibrate(VIBRATE_LONG)        if(mOnTriggerListener!=null)        
        {
mOnTriggerListener.onTrigger(this, whichHandle)
        } //End block
        // ---------- Original Method ----------
        //vibrate(VIBRATE_LONG);
        //if (mOnTriggerListener != null) {
            //mOnTriggerListener.onTrigger(this, whichHandle);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.340 -0400", hash_original_method = "9778C9E27DD8DB580BC10669261422EB", hash_generated_method = "2AF05348E42FC2F305FBD4B00BC7EB61")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
        addTaint(changedView.getTaint());
super.onVisibilityChanged(changedView, visibility)        if(changedView==this&&visibility!=VISIBLE&&mGrabbedState!=OnTriggerListener.NO_HANDLE)        
        {
cancelGrab()
        } //End block
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (changedView == this && visibility != VISIBLE
                //&& mGrabbedState != OnTriggerListener.NO_HANDLE) {
            //cancelGrab();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.340 -0400", hash_original_method = "D0AA0F943C7457E241BB26C76D14FAEF", hash_generated_method = "48F4F4BED4108DE17247BCD833C010E9")
    private void setGrabbedState(int newState) {
        addTaint(newState);
        if(newState!=mGrabbedState)        
        {
mGrabbedState=newState            if(mOnTriggerListener!=null)            
            {
mOnTriggerListener.onGrabbedStateChange(this, mGrabbedState)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (newState != mGrabbedState) {
            //mGrabbedState = newState;
            //if (mOnTriggerListener != null) {
                //mOnTriggerListener.onGrabbedStateChange(this, mGrabbedState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.340 -0400", hash_original_method = "DB05E60B51779EDEE5A85D6BA3688CBD", hash_generated_method = "AF9F74719248F0F3DAA63C2925AE65A3")
    private void log(String msg) {
        addTaint(msg.getTaint());
Log.d(LOG_TAG, msg)
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, msg);
    }

    
    private static class Slider {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.341 -0400", hash_original_field = "E7F8CBD87D347BE881CBA92DAD128518", hash_generated_field = "2DBD581B63F5B6698EF0E7FB54566A01")

        private ImageView tab;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.341 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "E3E577D0101AB5B053E8694F321947D1")

        private TextView text;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.341 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "9AB77CB22D014629772A5D617A0F8190")

        private ImageView target;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.341 -0400", hash_original_field = "8A89AD3D37A95443F161F04DA01BD80E", hash_generated_field = "6CBC49042CF9DE00567CBE1D2B559A39")

        private int currentState = STATE_NORMAL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.341 -0400", hash_original_field = "476B0F673B6C651F77884AE7F754D6F5", hash_generated_field = "50A891254611D63AA713B9F13FC84BCE")

        private int alignment = ALIGN_UNKNOWN;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.341 -0400", hash_original_field = "FE274DF3072E4345BF1FE51EB69EA79C", hash_generated_field = "745B7A2CA9375FC2B02D4FE9BDB30776")

        private int alignment_value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.341 -0400", hash_original_method = "F7077FCB345D6D555BFE6C3E4C094881", hash_generated_method = "5DA2192C447814E0D0AE1A9E898A4271")
          Slider(ViewGroup parent, int tabId, int barId, int targetId) {
            addTaint(targetId);
            addTaint(barId);
            addTaint(tabId);
            addTaint(parent.getTaint());
tab=new ImageView(parent.getContext())tab.setBackgroundResource(tabId)tab.setScaleType(ScaleType.CENTER)tab.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))text=new TextView(parent.getContext())text.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT))text.setBackgroundResource(barId)text.setTextAppearance(parent.getContext(), R.style.TextAppearance_SlidingTabNormal)target=new ImageView(parent.getContext())target.setImageResource(targetId)target.setScaleType(ScaleType.CENTER)target.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))target.setVisibility(View.INVISIBLE)parent.addView(target)parent.addView(tab)parent.addView(text)
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.342 -0400", hash_original_method = "276ED8C0D16F417EAF68F062C0C795D2", hash_generated_method = "D000571234B42A87CACF15231D4D4158")
         void setIcon(int iconId) {
            addTaint(iconId);
tab.setImageResource(iconId)
            // ---------- Original Method ----------
            //tab.setImageResource(iconId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.342 -0400", hash_original_method = "4E6B7038F6722F2BBCB69FB950E121E8", hash_generated_method = "4B3DC8E667F4180878C4F62AFB8EF75E")
         void setTabBackgroundResource(int tabId) {
            addTaint(tabId);
tab.setBackgroundResource(tabId)
            // ---------- Original Method ----------
            //tab.setBackgroundResource(tabId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.342 -0400", hash_original_method = "7E01CC85BA8EC2760E5EB48E2C2CCD55", hash_generated_method = "AD8B1028472257561C40E207EB77A2DE")
         void setBarBackgroundResource(int barId) {
            addTaint(barId);
text.setBackgroundResource(barId)
            // ---------- Original Method ----------
            //text.setBackgroundResource(barId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.342 -0400", hash_original_method = "9D23CAAD8DDC284F268F2A4BA67694B3", hash_generated_method = "D26F24ED14A1A628A62CA71C42EE2C01")
         void setHintText(int resId) {
            addTaint(resId);
text.setText(resId)
            // ---------- Original Method ----------
            //text.setText(resId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.343 -0400", hash_original_method = "640D7AF6AAFADCCBBCEA37324537D91D", hash_generated_method = "86EE84D7D27AF80E74611283B61F131D")
         void hide() {
            boolean horiz = alignment == ALIGN_LEFT || alignment == ALIGN_RIGHT;
            int dx = horiz ? (alignment == ALIGN_LEFT ? alignment_value - tab.getRight()
                    : alignment_value - tab.getLeft()) : 0;
            int dy = horiz ? 0 : (alignment == ALIGN_TOP ? alignment_value - tab.getBottom()
                    : alignment_value - tab.getTop());
            Animation trans = new TranslateAnimation(0, dx, 0, dy);
trans.setDuration(ANIM_DURATION)trans.setFillAfter(true)tab.startAnimation(trans)text.startAnimation(trans)target.setVisibility(View.INVISIBLE)
            // ---------- Original Method ----------
            //boolean horiz = alignment == ALIGN_LEFT || alignment == ALIGN_RIGHT;
            //int dx = horiz ? (alignment == ALIGN_LEFT ? alignment_value - tab.getRight()
                    //: alignment_value - tab.getLeft()) : 0;
            //int dy = horiz ? 0 : (alignment == ALIGN_TOP ? alignment_value - tab.getBottom()
                    //: alignment_value - tab.getTop());
            //Animation trans = new TranslateAnimation(0, dx, 0, dy);
            //trans.setDuration(ANIM_DURATION);
            //trans.setFillAfter(true);
            //tab.startAnimation(trans);
            //text.startAnimation(trans);
            //target.setVisibility(View.INVISIBLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.343 -0400", hash_original_method = "C2E0429C4E0BE650FCE9FC10038A9FA7", hash_generated_method = "EE9A8AB99E16ABC6DA15EBBB7CF43014")
         void show(boolean animate) {
            addTaint(animate);
text.setVisibility(View.VISIBLE)tab.setVisibility(View.VISIBLE)            if(animate)            
            {
                boolean horiz = alignment == ALIGN_LEFT || alignment == ALIGN_RIGHT;
                int dx = horiz ? (alignment == ALIGN_LEFT ? tab.getWidth() : -tab.getWidth()) : 0;
                int dy = horiz ? 0: (alignment == ALIGN_TOP ? tab.getHeight() : -tab.getHeight());
                Animation trans = new TranslateAnimation(-dx, 0, -dy, 0);
trans.setDuration(ANIM_DURATION)tab.startAnimation(trans)text.startAnimation(trans)
            } //End block
            // ---------- Original Method ----------
            //text.setVisibility(View.VISIBLE);
            //tab.setVisibility(View.VISIBLE);
            //if (animate) {
                //boolean horiz = alignment == ALIGN_LEFT || alignment == ALIGN_RIGHT;
                //int dx = horiz ? (alignment == ALIGN_LEFT ? tab.getWidth() : -tab.getWidth()) : 0;
                //int dy = horiz ? 0: (alignment == ALIGN_TOP ? tab.getHeight() : -tab.getHeight());
                //Animation trans = new TranslateAnimation(-dx, 0, -dy, 0);
                //trans.setDuration(ANIM_DURATION);
                //tab.startAnimation(trans);
                //text.startAnimation(trans);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.343 -0400", hash_original_method = "7D3D5CE47C79BF7D2BA68560D9DEF7B0", hash_generated_method = "B345B14D44C214CC76E68FC0E219EA70")
         void setState(int state) {
            addTaint(state);
text.setPressed(state==STATE_PRESSED)tab.setPressed(state==STATE_PRESSED)            if(state==STATE_ACTIVE)            
            {
                final int[] activeState = new int[] {com.android.internal.R.attr.state_active};
                if(text.getBackground().isStateful())                
                {
text.getBackground().setState(activeState)
                } //End block
                if(tab.getBackground().isStateful())                
                {
tab.getBackground().setState(activeState)
                } //End block
text.setTextAppearance(text.getContext(), R.style.TextAppearance_SlidingTabActive)
            } //End block
            else
            {
text.setTextAppearance(text.getContext(), R.style.TextAppearance_SlidingTabNormal)
            } //End block
currentState=state
            // ---------- Original Method ----------
            //text.setPressed(state == STATE_PRESSED);
            //tab.setPressed(state == STATE_PRESSED);
            //if (state == STATE_ACTIVE) {
                //final int[] activeState = new int[] {com.android.internal.R.attr.state_active};
                //if (text.getBackground().isStateful()) {
                    //text.getBackground().setState(activeState);
                //}
                //if (tab.getBackground().isStateful()) {
                    //tab.getBackground().setState(activeState);
                //}
                //text.setTextAppearance(text.getContext(), R.style.TextAppearance_SlidingTabActive);
            //} else {
                //text.setTextAppearance(text.getContext(), R.style.TextAppearance_SlidingTabNormal);
            //}
            //currentState = state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.344 -0400", hash_original_method = "511975F638EE1EDD22B455FBFDA270CA", hash_generated_method = "BDEEA694DF510C934DAB468A389A5B3E")
         void showTarget() {
            AlphaAnimation alphaAnim = new AlphaAnimation(0.0f, 1.0f);
alphaAnim.setDuration(ANIM_TARGET_TIME)target.startAnimation(alphaAnim)target.setVisibility(View.VISIBLE)
            // ---------- Original Method ----------
            //AlphaAnimation alphaAnim = new AlphaAnimation(0.0f, 1.0f);
            //alphaAnim.setDuration(ANIM_TARGET_TIME);
            //target.startAnimation(alphaAnim);
            //target.setVisibility(View.VISIBLE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.344 -0400", hash_original_method = "A58EC5A2C999057A9AD392DE6914F1B4", hash_generated_method = "C81C27A59293B98318ECC744BD224BE3")
         void reset(boolean animate) {
            addTaint(animate);
setState(STATE_NORMAL)text.setVisibility(View.VISIBLE)text.setTextAppearance(text.getContext(), R.style.TextAppearance_SlidingTabNormal)tab.setVisibility(View.VISIBLE)target.setVisibility(View.INVISIBLE)            final boolean horiz = alignment == ALIGN_LEFT || alignment == ALIGN_RIGHT;
            int dx = horiz ? (alignment == ALIGN_LEFT ?  alignment_value - tab.getLeft()
                    : alignment_value - tab.getRight()) : 0;
            int dy = horiz ? 0 : (alignment == ALIGN_TOP ? alignment_value - tab.getTop()
                    : alignment_value - tab.getBottom());
            if(animate)            
            {
                TranslateAnimation trans = new TranslateAnimation(0, dx, 0, dy);
trans.setDuration(ANIM_DURATION)trans.setFillAfter(false)text.startAnimation(trans)tab.startAnimation(trans)
            } //End block
            else
            {
                if(horiz)                
                {
text.offsetLeftAndRight(dx)tab.offsetLeftAndRight(dx)
                } //End block
                else
                {
text.offsetTopAndBottom(dy)tab.offsetTopAndBottom(dy)
                } //End block
text.clearAnimation()tab.clearAnimation()target.clearAnimation()
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.345 -0400", hash_original_method = "50B743E15D5266AB08C678F3D0519F08", hash_generated_method = "5552662EF6E145F4A10D0C715480FB4A")
         void setTarget(int targetId) {
            addTaint(targetId);
target.setImageResource(targetId)
            // ---------- Original Method ----------
            //target.setImageResource(targetId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.345 -0400", hash_original_method = "407F649F099673FB64EA52DB187F126E", hash_generated_method = "F4B36B01512D5407494A88AE69A7749E")
         void layout(int l, int t, int r, int b, int alignment) {
            addTaint(alignment);
            addTaint(b);
            addTaint(r);
            addTaint(t);
            addTaint(l);
this.alignment=alignment            final Drawable tabBackground = tab.getBackground();
            final int handleWidth = tabBackground.getIntrinsicWidth();
            final int handleHeight = tabBackground.getIntrinsicHeight();
            final Drawable targetDrawable = target.getDrawable();
            final int targetWidth = targetDrawable.getIntrinsicWidth();
            final int targetHeight = targetDrawable.getIntrinsicHeight();
            final int parentWidth = r - l;
            final int parentHeight = b - t;
            final int leftTarget = (int) (THRESHOLD * parentWidth) - targetWidth + handleWidth / 2;
            final int rightTarget = (int) ((1.0f - THRESHOLD) * parentWidth) - handleWidth / 2;
            final int left = (parentWidth - handleWidth) / 2;
            final int right = left + handleWidth;
            if(alignment==ALIGN_LEFT||alignment==ALIGN_RIGHT)            
            {
                final int targetTop = (parentHeight - targetHeight) / 2;
                final int targetBottom = targetTop + targetHeight;
                final int top = (parentHeight - handleHeight) / 2;
                final int bottom = (parentHeight + handleHeight) / 2;
                if(alignment==ALIGN_LEFT)                
                {
tab.layout(0, top, handleWidth, bottom)text.layout(0-parentWidth, top, 0, bottom)text.setGravity(Gravity.RIGHT)target.layout(leftTarget, targetTop, leftTarget+targetWidth, targetBottom)alignment_value=l
                } //End block
                else
                {
tab.layout(parentWidth-handleWidth, top, parentWidth, bottom)text.layout(parentWidth, top, parentWidth+parentWidth, bottom)target.layout(rightTarget, targetTop, rightTarget+targetWidth, targetBottom)text.setGravity(Gravity.TOP)alignment_value=r
                } //End block
            } //End block
            else
            {
                final int targetLeft = (parentWidth - targetWidth) / 2;
                final int targetRight = (parentWidth + targetWidth) / 2;
                final int top = (int) (THRESHOLD * parentHeight) + handleHeight / 2 - targetHeight;
                final int bottom = (int) ((1.0f - THRESHOLD) * parentHeight) - handleHeight / 2;
                if(alignment==ALIGN_TOP)                
                {
tab.layout(left, 0, right, handleHeight)text.layout(left, 0-parentHeight, right, 0)target.layout(targetLeft, top, targetRight, top+targetHeight)alignment_value=t
                } //End block
                else
                {
tab.layout(left, parentHeight-handleHeight, right, parentHeight)text.layout(left, parentHeight, right, parentHeight+parentHeight)target.layout(targetLeft, bottom, targetRight, bottom+targetHeight)alignment_value=b
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.346 -0400", hash_original_method = "CD23C34B1990794CB13C55D9EF4062DD", hash_generated_method = "117C5BF774DCACE4979BBA73FB781C89")
        public void updateDrawableStates() {
setState(currentState)
            // ---------- Original Method ----------
            //setState(currentState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.346 -0400", hash_original_method = "4495036A771ADEE96F16C846CB384D39", hash_generated_method = "A205FD66FBE43E763772373EE1FC5EC5")
        public void measure() {
tab.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))text.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
            // ---------- Original Method ----------
            //tab.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    //View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            //text.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    //View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.347 -0400", hash_original_method = "21CD9C3949D5132A9BDD1D4141B34BBF", hash_generated_method = "290DC89D7E1E68CE1DFDA29FA102ADC4")
        public int getTabWidth() {
            int var837B65C7C964164129A8E155D9B15193_528688823 = (tab.getMeasuredWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227255664 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227255664;
            // ---------- Original Method ----------
            //return tab.getMeasuredWidth();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.347 -0400", hash_original_method = "7E4109537D07A7700A9DE4CCF3764402", hash_generated_method = "27B8315E607C4DFEDC3C11B83C34E245")
        public int getTabHeight() {
            int varDB5C8CEA772D4D4C21A722D346F0AE45_707707213 = (tab.getMeasuredHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126463995 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126463995;
            // ---------- Original Method ----------
            //return tab.getMeasuredHeight();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.347 -0400", hash_original_method = "D73A3C969644E28744584ACBF38EDA35", hash_generated_method = "FC3E759C6C81D9D34612FE34A778B677")
        public void startAnimation(Animation anim1, Animation anim2) {
            addTaint(anim2.getTaint());
            addTaint(anim1.getTaint());
tab.startAnimation(anim1)text.startAnimation(anim2)
            // ---------- Original Method ----------
            //tab.startAnimation(anim1);
            //text.startAnimation(anim2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.348 -0400", hash_original_method = "474FDFFAA6B585E5962958EA6A5E5F7B", hash_generated_method = "6EE0CD8F7DC6D1F6243EA90C8799BB15")
        public void hideTarget() {
target.clearAnimation()target.setVisibility(View.INVISIBLE)
            // ---------- Original Method ----------
            //target.clearAnimation();
            //target.setVisibility(View.INVISIBLE);
        }

        


    
    public interface OnTriggerListener {
        
        public static final int NO_HANDLE = 0;

        
        public static final int LEFT_HANDLE = 1;

        
        public static final int RIGHT_HANDLE = 2;

        
        void onTrigger(View v, int whichHandle);

        
        void onGrabbedStateChange(View v, int grabbedState);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "D7818DADD9FB8413C9157DCA3E19C908", hash_generated_field = "459DD5B08162681A6BD9B1AFF7E165FC")

    private static final String LOG_TAG = "SlidingTab";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "10CC209974739317E961EBD041018581", hash_generated_field = "FB2AF03A0D0E19237A68DC6CAC3EDFEF")

    private static final int HORIZONTAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "B9A581C9879D3D62C7911745C0873959", hash_generated_field = "FE13C9507EB3E0B2777A8026EAF21CFC")

    private static final int VERTICAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "E91DA9F1E84462526AE3BEF1BF0A50B1", hash_generated_field = "89974B51988006F7ACA56ADDADCE4F77")

    private static final float THRESHOLD = 2.0f/3.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "AB967DD4073F2E5E9DB8ECBE1EFDB41B", hash_generated_field = "EED8ABE56C92765D1B9CECDD832F9ECA")

    private static final long VIBRATE_SHORT = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "FC0A6D22419BEA7DB9DD14A888260B33", hash_generated_field = "3F931B0FBFCFDD230B20D16CF7ABBEBC")

    private static final long VIBRATE_LONG = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "C447F358464E2D4EAFF050EB795F36A2", hash_generated_field = "FF1EBA496C75F5882A42BFBDB3D79002")

    private static final int TRACKING_MARGIN = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "C00B7EF354A31BA4F8D9A567B14449DA", hash_generated_field = "43294A75D3A7FA30122E47A17DDF5C31")

    private static final int ANIM_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.349 -0400", hash_original_field = "7C0536DB83C77DE51CCE7675FFD2ADDC", hash_generated_field = "6A1440288B330FDC0B5515A2A67B7B49")

    private static final int ANIM_TARGET_TIME = 500;
}

