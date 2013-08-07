package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import com.android.internal.R;
import android.os.Vibrator;
import android.util.Log;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.MotionEvent;
import android.graphics.BitmapFactory;
import android.view.accessibility.AccessibilityManager;
import android.text.TextUtils;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.content.Context;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.content.res.Resources;
public class WaveView extends View implements ValueAnimator.AnimatorUpdateListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.615 -0400", hash_original_field = "560EC933FF5763F980C1AAA7887459D4", hash_generated_field = "28ADEC971991F1A5C05DC67784FF191A")

    private Vibrator mVibrator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "BB32CCD8F958DE59F4FB742C226D38D4", hash_generated_field = "B712B682ACEFEF430B86ECE8AB423B62")

    private OnTriggerListener mOnTriggerListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "1ECDCDDA74E7680E8AFDFC61833CEF13", hash_generated_field = "277009000B992B87CDD82F2BE7DFFDD8")

    private ArrayList<DrawableHolder> mDrawables = new ArrayList<DrawableHolder>(3);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "EAEDADE7DBD576C655F79EE54335152C", hash_generated_field = "0E8B4481BDEE1E3F0926CD56299B8EDE")

    private ArrayList<DrawableHolder> mLightWaves = new ArrayList<DrawableHolder>(WAVE_COUNT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "E038D570F9DF39DD1BAF5B422158DC6B", hash_generated_field = "274B65D77949F80EE1A24329F50EFAF0")

    private boolean mFingerDown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "AC54484A7B60B24E7693A1D8F0667CD0", hash_generated_field = "7B1E282D63FBB66BC556571FCB38A5AC")

    private float mRingRadius = 182.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "21933284E378346D54785C1B134E7E85", hash_generated_field = "9711A0EFB2CD92CC0A68A0D5FF73B961")

    private int mSnapRadius = 136;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "793D86391C8D5A1D71942E825DCEDF5D", hash_generated_field = "B3C63A1F208782260E2C8BFDBACF2D59")

    private int mWaveCount = WAVE_COUNT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "7C7650CA078DF1CAD1BB306081E07FB9", hash_generated_field = "968D73B0D3E09801E72D3EA3033635B9")

    private long mWaveTimerDelay = WAVE_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "E2B448223E5B93C45E9BE13BF1F359BB", hash_generated_field = "3AF9562D5FF6B1E12CDC855215EBD85A")

    private int mCurrentWave = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "E33A9E0589296C65951F9DA48F3C7491", hash_generated_field = "6D5BF38CCADBDAE2457894D9439AAAE0")

    private float mLockCenterX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.616 -0400", hash_original_field = "A39C939F4F22E793EBA2F2C2A1998DBC", hash_generated_field = "EBBC44ED407D3963958CB903494C9502")

    private float mLockCenterY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "5233541B1A6F7ED3A42BE18AAA56483E", hash_generated_field = "88FE2A46E9C94BC5EE416D7E3E361666")

    private float mMouseX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "0A67D4222E7D03CBF3CE641DBA370F6E", hash_generated_field = "5CA5C599F43DB83B993D1A5C6E6AED3C")

    private float mMouseY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "6DB67C75107C3E7CD48D7EE777F3380F", hash_generated_field = "9233AE9933B56F4875C9E12E4A59AACF")

    private DrawableHolder mUnlockRing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "CD005E17F1270DCD2560FE3833750570", hash_generated_field = "8CDC2D763B900CDD51C75DC65C31451C")

    private DrawableHolder mUnlockDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "A02C3575B4ECA6DC0FF6767A08767186", hash_generated_field = "C0A22F5FD5A4F530C03043EAD68E0298")

    private DrawableHolder mUnlockHalo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "7C0469D7AAA5A84F1CA494F403FB140C", hash_generated_field = "17BB36C67AB5DD775C4594322C1BF725")

    private int mLockState = STATE_RESET_LOCK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "9401A080EFFEB267188E5A18F9B231F0", hash_generated_field = "B89829B5C1E4F1B375033ED91ED11EB3")

    private int mGrabbedState = OnTriggerListener.NO_HANDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "BB1BB1290DB50FD0D71D2C47AF3FA5CD", hash_generated_field = "25C9888CF5A8DA4095A5B561C85432DA")

    private boolean mWavesRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.617 -0400", hash_original_field = "FF2DB02A81409787D88C2DAB7CB00B35", hash_generated_field = "F4E92A9103CC6AB903C9C627A5255868")

    private boolean mFinishWaves;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.618 -0400", hash_original_field = "654D136A2ACA07B12C98AE937159D4D0", hash_generated_field = "D751F09DA11CB363E7CD515C4ED09CB2")

    private final Runnable mLockTimerActions = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.618 -0400", hash_original_method = "AFAD99468B0F44BC978BE69421BF2B29", hash_generated_method = "9960DF1997A016F652A495F64C65D442")
        public void run() {
            if(DBG){ }            if(mLockState==STATE_ATTEMPTING)            
            {
                if(DBG){ }mLockState=STATE_RESET_LOCK
            } //End block
            if(mLockState==STATE_UNLOCK_SUCCESS)            
            {
                if(DBG){ }mLockState=STATE_RESET_LOCK
            } //End block
invalidate()
            // ---------- Original Method ----------
            //if (DBG) Log.v(TAG, "LockTimerActions");
            //if (mLockState == STATE_ATTEMPTING) {
                //if (DBG) Log.v(TAG, "Timer resets to STATE_RESET_LOCK");
                //mLockState = STATE_RESET_LOCK;
            //}
            //if (mLockState == STATE_UNLOCK_SUCCESS) {
                //if (DBG) Log.v(TAG, "Timer resets to STATE_RESET_LOCK after success");
                //mLockState = STATE_RESET_LOCK;
            //}
            //invalidate();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.620 -0400", hash_original_field = "DDAD1AE53B30BC4FC9EE2026D959A3EF", hash_generated_field = "EBE7361031C967F45FD260DB148E413B")

    private final Runnable mAddWaveAction = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.619 -0400", hash_original_method = "DF3E1F26B4457D9DF0EB635E9CD6AD46", hash_generated_method = "A452745FB2C8D4AA69A9CFB8DDBB8F12")
        public void run() {
            double distX = mMouseX - mLockCenterX;
            double distY = mMouseY - mLockCenterY;
            int dragDistance = (int) Math.ceil(Math.hypot(distX, distY));
            if(mLockState==STATE_ATTEMPTING&&dragDistance<mSnapRadius&&mWaveTimerDelay>=WAVE_DELAY)            
            {
mWaveTimerDelay=Math.min(WAVE_DURATION, mWaveTimerDelay+DELAY_INCREMENT)                DrawableHolder wave = mLightWaves.get(mCurrentWave);
wave.setAlpha(0.0f)wave.setScaleX(0.2f)wave.setScaleY(0.2f)wave.setX(mMouseX)wave.setY(mMouseY)wave.addAnimTo(WAVE_DURATION, 0, "x", mLockCenterX, true)wave.addAnimTo(WAVE_DURATION, 0, "y", mLockCenterY, true)wave.addAnimTo(WAVE_DURATION*2/3, 0, "alpha", 1.0f, true)wave.addAnimTo(WAVE_DURATION, 0, "scaleX", 1.0f, true)wave.addAnimTo(WAVE_DURATION, 0, "scaleY", 1.0f, true)wave.addAnimTo(1000, RING_DELAY, "alpha", 0.0f, false)wave.startAnimations(WaveView.this)mCurrentWave=(mCurrentWave+1)%mWaveCount                if(DBG){ }
            } //End block
            else
            {
mWaveTimerDelay+=DELAY_INCREMENT2
            } //End block
            if(mFinishWaves)            
            {
mWavesRunning=false
            } //End block
            else
            {
postDelayed(mAddWaveAction, mWaveTimerDelay)
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.621 -0400", hash_original_method = "3F6A86D5022F38F6DCA195A788AD3CA4", hash_generated_method = "3A4CD128FCFF97674B51EC2F499F68A3")
    public  WaveView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.621 -0400", hash_original_method = "6E4A73E8D4FCA5814863585D20F8A785", hash_generated_method = "3A8E6768F1C2D51547804E160362E632")
    public  WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
initDrawables()
        // ---------- Original Method ----------
        //initDrawables();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.621 -0400", hash_original_method = "05F906FBDB31A2744E3D33E16D0B60B9", hash_generated_method = "4B8B52FC01582587786184DEE766DEB9")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
mLockCenterX=0.5f*wmLockCenterY=0.5f*hsuper.onSizeChanged(w, h, oldw, oldh)
        // ---------- Original Method ----------
        //mLockCenterX = 0.5f * w;
        //mLockCenterY = 0.5f * h;
        //super.onSizeChanged(w, h, oldw, oldh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.622 -0400", hash_original_method = "196A33644EBF9F57AD38D2F6C3B6F707", hash_generated_method = "BAFEE72803F3EAA91F739794FE6B8623")
    @Override
    protected int getSuggestedMinimumWidth() {
        int var97BEC8BBE58067ECCC1B092DAD8D3972_1747555057 = (mUnlockRing.getWidth()+mUnlockHalo.getWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301100994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301100994;
        // ---------- Original Method ----------
        //return mUnlockRing.getWidth() + mUnlockHalo.getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.622 -0400", hash_original_method = "83E76E0C1064117030D4AA5284C06C02", hash_generated_method = "DEB5B2570303B9CD7C7B9D78DE97099F")
    @Override
    protected int getSuggestedMinimumHeight() {
        int var344B43CA719169ADC3D3D8D749A8F3FA_895980178 = (mUnlockRing.getHeight()+mUnlockHalo.getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326681976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326681976;
        // ---------- Original Method ----------
        //return mUnlockRing.getHeight() + mUnlockHalo.getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.623 -0400", hash_original_method = "2A2E149C3A7A1644999A148C37025723", hash_generated_method = "8F5DFFBABEBE5D1762007545FE59F6F8")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if(widthSpecMode==MeasureSpec.AT_MOST)        
        {
width=Math.min(widthSpecSize, getSuggestedMinimumWidth())
        } //End block
        else
        if(widthSpecMode==MeasureSpec.EXACTLY)        
        {
width=widthSpecSize
        } //End block
        else
        {
width=getSuggestedMinimumWidth()
        } //End block
        if(heightSpecMode==MeasureSpec.AT_MOST)        
        {
height=Math.min(heightSpecSize, getSuggestedMinimumWidth())
        } //End block
        else
        if(heightSpecMode==MeasureSpec.EXACTLY)        
        {
height=heightSpecSize
        } //End block
        else
        {
height=getSuggestedMinimumHeight()
        } //End block
setMeasuredDimension(width, height)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.624 -0400", hash_original_method = "A9098B41823477D7FDD70182B2DC7A77", hash_generated_method = "FDF8CCD302B664537D9C35696F014A3A")
    private void initDrawables() {
mUnlockRing=new DrawableHolder(createDrawable(R.drawable.unlock_ring))mUnlockRing.setX(mLockCenterX)mUnlockRing.setY(mLockCenterY)mUnlockRing.setScaleX(0.1f)mUnlockRing.setScaleY(0.1f)mUnlockRing.setAlpha(0.0f)mDrawables.add(mUnlockRing)mUnlockDefault=new DrawableHolder(createDrawable(R.drawable.unlock_default))mUnlockDefault.setX(mLockCenterX)mUnlockDefault.setY(mLockCenterY)mUnlockDefault.setScaleX(0.1f)mUnlockDefault.setScaleY(0.1f)mUnlockDefault.setAlpha(0.0f)mDrawables.add(mUnlockDefault)mUnlockHalo=new DrawableHolder(createDrawable(R.drawable.unlock_halo))mUnlockHalo.setX(mLockCenterX)mUnlockHalo.setY(mLockCenterY)mUnlockHalo.setScaleX(0.1f)mUnlockHalo.setScaleY(0.1f)mUnlockHalo.setAlpha(0.0f)mDrawables.add(mUnlockHalo)        BitmapDrawable wave = createDrawable(R.drawable.unlock_wave);
for(int i = 0;i<mWaveCount;i)
        {
            DrawableHolder holder = new DrawableHolder(wave);
mLightWaves.add(holder)holder.setAlpha(0.0f)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.629 -0400", hash_original_method = "14C100BBAB71B835BFB226B66DBD17A8", hash_generated_method = "84950EA9A24B35B48EA4185E7E434F55")
    private void waveUpdateFrame(float mouseX, float mouseY, boolean fingerDown) {
        addTaint(fingerDown);
        addTaint(mouseY);
        addTaint(mouseX);
        double distX = mouseX - mLockCenterX;
        double distY = mouseY - mLockCenterY;
        int dragDistance = (int) Math.ceil(Math.hypot(distX, distY));
        double touchA = Math.atan2(distX, distY);
        float ringX = (float) (mLockCenterX + mRingRadius * Math.sin(touchA));
        float ringY = (float) (mLockCenterY + mRingRadius * Math.cos(touchA));
        switch(mLockState){
        case STATE_RESET_LOCK:
        if(DBG){ }mWaveTimerDelay=WAVE_DELAYfor(int i = 0;i<mLightWaves.size();i)
        {
            DrawableHolder holder = mLightWaves.get(i);
holder.addAnimTo(300, 0, "alpha", 0.0f, false)
        } //End block
for(int i = 0;i<mLightWaves.size();i)
        {
mLightWaves.get(i).startAnimations(this)
        } //End block
mUnlockRing.addAnimTo(DURATION, 0, "x", mLockCenterX, true)mUnlockRing.addAnimTo(DURATION, 0, "y", mLockCenterY, true)mUnlockRing.addAnimTo(DURATION, 0, "scaleX", 0.1f, true)mUnlockRing.addAnimTo(DURATION, 0, "scaleY", 0.1f, true)mUnlockRing.addAnimTo(DURATION, 0, "alpha", 0.0f, true)mUnlockDefault.removeAnimationFor("x")mUnlockDefault.removeAnimationFor("y")mUnlockDefault.removeAnimationFor("scaleX")mUnlockDefault.removeAnimationFor("scaleY")mUnlockDefault.removeAnimationFor("alpha")mUnlockDefault.setX(mLockCenterX)mUnlockDefault.setY(mLockCenterY)mUnlockDefault.setScaleX(0.1f)mUnlockDefault.setScaleY(0.1f)mUnlockDefault.setAlpha(0.0f)mUnlockDefault.addAnimTo(DURATION, SHORT_DELAY, "scaleX", 1.0f, true)mUnlockDefault.addAnimTo(DURATION, SHORT_DELAY, "scaleY", 1.0f, true)mUnlockDefault.addAnimTo(DURATION, SHORT_DELAY, "alpha", 1.0f, true)mUnlockHalo.removeAnimationFor("x")mUnlockHalo.removeAnimationFor("y")mUnlockHalo.removeAnimationFor("scaleX")mUnlockHalo.removeAnimationFor("scaleY")mUnlockHalo.removeAnimationFor("alpha")mUnlockHalo.setX(mLockCenterX)mUnlockHalo.setY(mLockCenterY)mUnlockHalo.setScaleX(0.1f)mUnlockHalo.setScaleY(0.1f)mUnlockHalo.setAlpha(0.0f)mUnlockHalo.addAnimTo(DURATION, SHORT_DELAY, "x", mLockCenterX, true)mUnlockHalo.addAnimTo(DURATION, SHORT_DELAY, "y", mLockCenterY, true)mUnlockHalo.addAnimTo(DURATION, SHORT_DELAY, "scaleX", 1.0f, true)mUnlockHalo.addAnimTo(DURATION, SHORT_DELAY, "scaleY", 1.0f, true)mUnlockHalo.addAnimTo(DURATION, SHORT_DELAY, "alpha", 1.0f, true)removeCallbacks(mLockTimerActions)mLockState=STATE_READY        break;
        case STATE_READY:
        if(DBG){ }mWaveTimerDelay=WAVE_DELAY        break;
        case STATE_START_ATTEMPT:
        if(DBG){ }mUnlockDefault.removeAnimationFor("x")mUnlockDefault.removeAnimationFor("y")mUnlockDefault.removeAnimationFor("scaleX")mUnlockDefault.removeAnimationFor("scaleY")mUnlockDefault.removeAnimationFor("alpha")mUnlockDefault.setX(mLockCenterX+182)mUnlockDefault.setY(mLockCenterY)mUnlockDefault.setScaleX(0.1f)mUnlockDefault.setScaleY(0.1f)mUnlockDefault.setAlpha(0.0f)mUnlockDefault.addAnimTo(DURATION, SHORT_DELAY, "scaleX", 1.0f, false)mUnlockDefault.addAnimTo(DURATION, SHORT_DELAY, "scaleY", 1.0f, false)mUnlockDefault.addAnimTo(DURATION, SHORT_DELAY, "alpha", 1.0f, false)mUnlockRing.addAnimTo(DURATION, 0, "scaleX", 1.0f, true)mUnlockRing.addAnimTo(DURATION, 0, "scaleY", 1.0f, true)mUnlockRing.addAnimTo(DURATION, 0, "alpha", 1.0f, true)mLockState=STATE_ATTEMPTING        break;
        case STATE_ATTEMPTING:
        if(DBG){ }        if(dragDistance>mSnapRadius)        
        {
mFinishWaves=true            if(fingerDown)            
            {
mUnlockHalo.addAnimTo(0, 0, "x", ringX, true)mUnlockHalo.addAnimTo(0, 0, "y", ringY, true)mUnlockHalo.addAnimTo(0, 0, "scaleX", 1.0f, true)mUnlockHalo.addAnimTo(0, 0, "scaleY", 1.0f, true)mUnlockHalo.addAnimTo(0, 0, "alpha", 1.0f, true)
            } //End block
            else
            {
                if(DBG){ }mLockState=STATE_UNLOCK_ATTEMPT
            } //End block
        } //End block
        else
        {
            if(!mWavesRunning)            
            {
mWavesRunning=truemFinishWaves=falsepostDelayed(mAddWaveAction, mWaveTimerDelay)
            } //End block
mUnlockHalo.addAnimTo(0, 0, "x", mouseX, true)mUnlockHalo.addAnimTo(0, 0, "y", mouseY, true)mUnlockHalo.addAnimTo(0, 0, "scaleX", 1.0f, true)mUnlockHalo.addAnimTo(0, 0, "scaleY", 1.0f, true)mUnlockHalo.addAnimTo(0, 0, "alpha", 1.0f, true)
        } //End block
        break;
        case STATE_UNLOCK_ATTEMPT:
        if(DBG){ }        if(dragDistance>mSnapRadius)        
        {
for(int n = 0;n<mLightWaves.size();n)
            {
                DrawableHolder wave = mLightWaves.get(n);
                long delay = 1000L*(6 + n - mCurrentWave)/10L;
wave.addAnimTo(FINAL_DURATION, delay, "x", ringX, true)wave.addAnimTo(FINAL_DURATION, delay, "y", ringY, true)wave.addAnimTo(FINAL_DURATION, delay, "scaleX", 0.1f, true)wave.addAnimTo(FINAL_DURATION, delay, "scaleY", 0.1f, true)wave.addAnimTo(FINAL_DURATION, delay, "alpha", 0.0f, true)
            } //End block
for(int i = 0;i<mLightWaves.size();i)
            {
mLightWaves.get(i).startAnimations(this)
            } //End block
mUnlockRing.addAnimTo(FINAL_DURATION, 0, "x", ringX, false)mUnlockRing.addAnimTo(FINAL_DURATION, 0, "y", ringY, false)mUnlockRing.addAnimTo(FINAL_DURATION, 0, "scaleX", 0.1f, false)mUnlockRing.addAnimTo(FINAL_DURATION, 0, "scaleY", 0.1f, false)mUnlockRing.addAnimTo(FINAL_DURATION, 0, "alpha", 0.0f, false)mUnlockRing.addAnimTo(FINAL_DURATION, FINAL_DELAY, "alpha", 0.0f, false)mUnlockDefault.removeAnimationFor("x")mUnlockDefault.removeAnimationFor("y")mUnlockDefault.removeAnimationFor("scaleX")mUnlockDefault.removeAnimationFor("scaleY")mUnlockDefault.removeAnimationFor("alpha")mUnlockDefault.setX(ringX)mUnlockDefault.setY(ringY)mUnlockDefault.setScaleX(0.1f)mUnlockDefault.setScaleY(0.1f)mUnlockDefault.setAlpha(0.0f)mUnlockDefault.addAnimTo(FINAL_DURATION, 0, "x", ringX, true)mUnlockDefault.addAnimTo(FINAL_DURATION, 0, "y", ringY, true)mUnlockDefault.addAnimTo(FINAL_DURATION, 0, "scaleX", 1.0f, true)mUnlockDefault.addAnimTo(FINAL_DURATION, 0, "scaleY", 1.0f, true)mUnlockDefault.addAnimTo(FINAL_DURATION, 0, "alpha", 1.0f, true)mUnlockDefault.addAnimTo(FINAL_DURATION, FINAL_DELAY, "scaleX", 3.0f, false)mUnlockDefault.addAnimTo(FINAL_DURATION, FINAL_DELAY, "scaleY", 3.0f, false)mUnlockDefault.addAnimTo(FINAL_DURATION, FINAL_DELAY, "alpha", 0.0f, false)mUnlockHalo.addAnimTo(FINAL_DURATION, 0, "x", ringX, false)mUnlockHalo.addAnimTo(FINAL_DURATION, 0, "y", ringY, false)mUnlockHalo.addAnimTo(FINAL_DURATION, FINAL_DELAY, "scaleX", 3.0f, false)mUnlockHalo.addAnimTo(FINAL_DURATION, FINAL_DELAY, "scaleY", 3.0f, false)mUnlockHalo.addAnimTo(FINAL_DURATION, FINAL_DELAY, "alpha", 0.0f, false)removeCallbacks(mLockTimerActions)postDelayed(mLockTimerActions, RESET_TIMEOUT)dispatchTriggerEvent(OnTriggerListener.CENTER_HANDLE)mLockState=STATE_UNLOCK_SUCCESS
        } //End block
        else
        {
mLockState=STATE_RESET_LOCK
        } //End block
        break;
        case STATE_UNLOCK_SUCCESS:
        if(DBG){ }removeCallbacks(mAddWaveAction)        break;
        default:
        if(DBG){ }        break;
}mUnlockDefault.startAnimations(this)mUnlockHalo.startAnimations(this)mUnlockRing.startAnimations(this)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.630 -0400", hash_original_method = "7D097FCC3196C2C6F423808205EA38A3", hash_generated_method = "A32878980DB1979C9F786AE4AC7A448F")
     BitmapDrawable createDrawable(int resId) {
        addTaint(resId);
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, resId);
BitmapDrawable varCDFF0A50B7C4535D0BBD7A6A0A8D20D9_1140185727 = new BitmapDrawable(res, bitmap)        varCDFF0A50B7C4535D0BBD7A6A0A8D20D9_1140185727.addTaint(taint);
        return varCDFF0A50B7C4535D0BBD7A6A0A8D20D9_1140185727;
        // ---------- Original Method ----------
        //Resources res = getResources();
        //Bitmap bitmap = BitmapFactory.decodeResource(res, resId);
        //return new BitmapDrawable(res, bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.631 -0400", hash_original_method = "BA750B29AD981634F754BBCDC682B8D7", hash_generated_method = "F0EBC4287C4E731E206FCA4171A332A4")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
waveUpdateFrame(mMouseX, mMouseY, mFingerDown)for(int i = 0;i<mDrawables.size();++i)
        {
mDrawables.get(i).draw(canvas)
        } //End block
for(int i = 0;i<mLightWaves.size();++i)
        {
mLightWaves.get(i).draw(canvas)
        } //End block
        // ---------- Original Method ----------
        //waveUpdateFrame(mMouseX, mMouseY, mFingerDown);
        //for (int i = 0; i < mDrawables.size(); ++i) {
            //mDrawables.get(i).draw(canvas);
        //}
        //for (int i = 0; i < mLightWaves.size(); ++i) {
            //mLightWaves.get(i).draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.632 -0400", hash_original_method = "FF4AE971A2EAE39E843DF1D56F5160FE", hash_generated_method = "223CA4CE2C9FF254ABF32D43C9733E77")
    @Override
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(AccessibilityManager.getInstance(mContext).isTouchExplorationEnabled())        
        {
            final int action = event.getAction();
            switch(action){
            case MotionEvent.ACTION_HOVER_ENTER:
event.setAction(MotionEvent.ACTION_DOWN)            break;
            case MotionEvent.ACTION_HOVER_MOVE:
event.setAction(MotionEvent.ACTION_MOVE)            break;
            case MotionEvent.ACTION_HOVER_EXIT:
event.setAction(MotionEvent.ACTION_UP)            break;
}onTouchEvent(event)event.setAction(action)
        } //End block
        boolean var529D2E3159AA18EC09D8755785EF01BB_410275873 = (super.onHoverEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_593756250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_593756250;
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isTouchExplorationEnabled()) {
            //final int action = event.getAction();
            //switch (action) {
                //case MotionEvent.ACTION_HOVER_ENTER:
                    //event.setAction(MotionEvent.ACTION_DOWN);
                    //break;
                //case MotionEvent.ACTION_HOVER_MOVE:
                    //event.setAction(MotionEvent.ACTION_MOVE);
                    //break;
                //case MotionEvent.ACTION_HOVER_EXIT:
                    //event.setAction(MotionEvent.ACTION_UP);
                    //break;
            //}
            //onTouchEvent(event);
            //event.setAction(action);
        //}
        //return super.onHoverEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.633 -0400", hash_original_method = "3200F7336FB9312E39697D8A99F2E2ED", hash_generated_method = "AF3EAC92452D9C23D77A40DC4FCF66B6")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        final int action = event.getAction();
mMouseX=event.getX()mMouseY=event.getY()        boolean handled = false;
        switch(action){
        case MotionEvent.ACTION_DOWN:
removeCallbacks(mLockTimerActions)mFingerDown=truetryTransitionToStartAttemptState(event)handled=true        break;
        case MotionEvent.ACTION_MOVE:
tryTransitionToStartAttemptState(event)handled=true        break;
        case MotionEvent.ACTION_UP:
        if(DBG){ }mFingerDown=falsepostDelayed(mLockTimerActions, RESET_TIMEOUT)setGrabbedState(OnTriggerListener.NO_HANDLE)waveUpdateFrame(mMouseX, mMouseY, mFingerDown)handled=true        break;
        case MotionEvent.ACTION_CANCEL:
mFingerDown=falsehandled=true        break;
}invalidate()        boolean var24298A14C64C4464799307444B35521B_1928088409 = (handled?true:true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564871455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564871455;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.634 -0400", hash_original_method = "E58FE6E8586C3FB08566F5D2F0B7FC52", hash_generated_method = "D75DC2C7BF050E21DC4AEFF25FCE8415")
    private void tryTransitionToStartAttemptState(MotionEvent event) {
        addTaint(event.getTaint());
        final float dx = event.getX() - mUnlockHalo.getX();
        final float dy = event.getY() - mUnlockHalo.getY();
        float dist = (float) Math.hypot(dx, dy);
        if(dist<=getScaledGrabHandleRadius())        
        {
setGrabbedState(OnTriggerListener.CENTER_HANDLE)            if(mLockState==STATE_READY)            
            {
mLockState=STATE_START_ATTEMPT                if(AccessibilityManager.getInstance(mContext).isEnabled())                
                {
announceUnlockHandle()
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final float dx = event.getX() - mUnlockHalo.getX();
        //final float dy = event.getY() - mUnlockHalo.getY();
        //float dist = (float) Math.hypot(dx, dy);
        //if (dist <= getScaledGrabHandleRadius()) {
            //setGrabbedState(OnTriggerListener.CENTER_HANDLE);
            //if (mLockState == STATE_READY) {
                //mLockState = STATE_START_ATTEMPT;
                //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
                    //announceUnlockHandle();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.635 -0400", hash_original_method = "2899AB025A1759788624A56F17C567F4", hash_generated_method = "C2054CA60BFD4C2B830659ABE9F1C962")
    private float getScaledGrabHandleRadius() {
        if(AccessibilityManager.getInstance(mContext).isEnabled())        
        {
            float var67220C68BC1695F157483C0CCBD70CA0_1361846806 = (GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_ENABLED*mUnlockHalo.getWidth());
                        float var546ADE640B6EDFBC8A086EF31347E768_1756159935 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1756159935;
        } //End block
        else
        {
            float var114C16072E4C159AAA5682AB366DF19F_1330133375 = (GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED*mUnlockHalo.getWidth());
                        float var546ADE640B6EDFBC8A086EF31347E768_385754880 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_385754880;
        } //End block
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //return GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_ENABLED * mUnlockHalo.getWidth();
        //} else {
            //return GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED * mUnlockHalo.getWidth();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.635 -0400", hash_original_method = "08CECB9AE13DD42FE7B037358DD42B53", hash_generated_method = "6B23180A0CAA8501330AD51E1E4AA00C")
    private void announceUnlockHandle() {
setContentDescription(mContext.getString(R.string.description_target_unlock_tablet))sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)setContentDescription(null)
        // ---------- Original Method ----------
        //setContentDescription(mContext.getString(R.string.description_target_unlock_tablet));
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        //setContentDescription(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.636 -0400", hash_original_method = "B33E756DD8C89F43C3A0B63F78052840", hash_generated_method = "6C19DF9FF91FDC6A53A654512A03AA5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.636 -0400", hash_original_method = "55E97AC0CD8F0BA7A04BDE23F0852D07", hash_generated_method = "47476DEC32908605480C68DFE2ACFFF8")
    public void setOnTriggerListener(OnTriggerListener listener) {
        addTaint(listener.getTaint());
mOnTriggerListener=listener
        // ---------- Original Method ----------
        //mOnTriggerListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.636 -0400", hash_original_method = "12014E18CBCA46015F32E40C3F31C06F", hash_generated_method = "7394F2AE61B8CFFC91599BE358F851D4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.637 -0400", hash_original_method = "D0AA0F943C7457E241BB26C76D14FAEF", hash_generated_method = "48F4F4BED4108DE17247BCD833C010E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.638 -0400", hash_original_method = "B7497F13EAA07AC611F0522926097AB8", hash_generated_method = "51597F0C442DB195D27F5B6A8AB6E190")
    public void onAnimationUpdate(ValueAnimator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
invalidate()
        // ---------- Original Method ----------
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.638 -0400", hash_original_method = "21F39A2D94AA749C4B1F419A4E78C923", hash_generated_method = "6DF67C334431BFB38198C24BF3F17ACC")
    public void reset() {
        if(DBG){ }mLockState=STATE_RESET_LOCKinvalidate()
        // ---------- Original Method ----------
        //if (DBG) Log.v(TAG, "reset() : resets state to STATE_RESET_LOCK");
        //mLockState = STATE_RESET_LOCK;
        //invalidate();
    }

    
    public interface OnTriggerListener {
        
        public static final int NO_HANDLE = 0;

        
        public static final int CENTER_HANDLE = 10;

        
        void onTrigger(View v, int whichHandle);

        
        void onGrabbedStateChange(View v, int grabbedState);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.638 -0400", hash_original_field = "0448F360409CF171FFEDEAF9DB19D2B5", hash_generated_field = "0B8F055A1F94ED007576E26BA70B5106")

    private static final String TAG = "WaveView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.638 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.638 -0400", hash_original_field = "746F4BC07E5A7F06DF0DB1327949DFCD", hash_generated_field = "91CBDB9CF0B27C5A8F78B3E9FEEE7308")

    private static final int WAVE_COUNT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.638 -0400", hash_original_field = "241A061C6A7D4B7F491D1F3B6EF9C3BC", hash_generated_field = "05FE33E056ABA628ECB29C00641D5B19")

    private static final long VIBRATE_SHORT = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.638 -0400", hash_original_field = "651E257AC056B6080290DE2C51BC5370", hash_generated_field = "A8B4877353A872E74043C571C2C04C2E")

    private static final long VIBRATE_LONG = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "94A70A6B0588633E3A53FFBA305BB551", hash_generated_field = "D70DCC9F3B9D63BF713C48700F984418")

    private static final int STATE_RESET_LOCK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "D88E5D15381242DB3C48E48F7253DE63", hash_generated_field = "CB019192329A333889E73298BAEF033D")

    private static final int STATE_READY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "32ADED799AB06544834998CA1A3DA5DC", hash_generated_field = "790C454B96F8AEC6AB3B264CDD59E383")

    private static final int STATE_START_ATTEMPT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "51F64A7B8C5E42B2774C3AE131A8404D", hash_generated_field = "1E29591EE205C2830834FCC64E5F1859")

    private static final int STATE_ATTEMPTING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "25A99B3EF280CD878DC4056D76A04FE2", hash_generated_field = "47E172AA9B64EF12EEC83459C7F8C206")

    private static final int STATE_UNLOCK_ATTEMPT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "7DDCD323F8E43C94684A9791BBA5A581", hash_generated_field = "9A242428AE2722736B80D87EB31227DA")

    private static final int STATE_UNLOCK_SUCCESS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "ACD80AEB2BB764857F80DEE33CF99C6E", hash_generated_field = "965727AA138AA03EDE28F44433128543")

    private static final long DURATION = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "71C4AFA231E8AD0518267C9B1799F935", hash_generated_field = "CCF392B1A1CC054632E67ED56E158215")

    private static final long FINAL_DURATION = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "1732BCBC141A4EDE1D45AF7623F1DA68", hash_generated_field = "EE32772B977BBA7F1E1B0DAC83AA09F2")

    private static final long RING_DELAY = 1300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.639 -0400", hash_original_field = "1FA04EABDBDFE90D884A4676F294FF16", hash_generated_field = "21B9379F0046349467CD5C08E74742C8")

    private static final long FINAL_DELAY = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "0648549B5657DAB907391EC4E82A0F85", hash_generated_field = "124116CB4797D427672E41811C49AF23")

    private static final long SHORT_DELAY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "F4FC8A58047D364F4962154A55712A2D", hash_generated_field = "5BEA5974907458052E83FAD2D187617D")

    private static final long WAVE_DURATION = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "B2A8A39FB92023DED2B47FB7AEFE6318", hash_generated_field = "A9362434A6DC78D81E744CF5292E6CB7")

    private static final long RESET_TIMEOUT = 3000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "D110463AAE728217A010ADE14B4FBE47", hash_generated_field = "8C0E18BBADB90F2067A9FA622B81E3C3")

    private static final long DELAY_INCREMENT = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "38723E963D6CEF4EB5463F8B928258D4", hash_generated_field = "0CBBDD94F36F07C2B4195D7434852EED")

    private static final long DELAY_INCREMENT2 = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "AB5AA0DF2D6F40F70F0CEF106514F42A", hash_generated_field = "1705EB648E1E3CC74F3682D25222F038")

    private static final long WAVE_DELAY = WAVE_DURATION/WAVE_COUNT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "F1C3A720F02333CD7982DC47B96CC200", hash_generated_field = "6CB0C03B2D4D1E75C1EB05682DD12CB6")

    private static final float GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_DISABLED = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.640 -0400", hash_original_field = "B3FCABE697240B6033DE6ED550E193AC", hash_generated_field = "AA13EFDAE8B90597C640E54D32B12738")

    private static final float GRAB_HANDLE_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.0f;
}

