package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.os.SystemClock;
import com.android.internal.R;
import android.os.Parcelable;
import android.util.Log;
import android.graphics.Paint;
import android.graphics.BitmapFactory;
import android.view.View;
import android.os.Debug;
import android.view.HapticFeedbackConstants;
import android.view.accessibility.AccessibilityManager;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Canvas;
import android.os.Parcel;
import android.content.res.TypedArray;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;
import android.view.MotionEvent;
import android.graphics.Matrix;
import android.content.Context;
import android.util.AttributeSet;
public class LockPatternView extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.748 -0400", hash_original_field = "529F532585B3B3E8AD943453B6CC85DD", hash_generated_field = "283E44307323165532F8F082567806A5")

    private boolean mDrawingProfilingStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.748 -0400", hash_original_field = "1F593C5E1FA9C53F92379484654564D2", hash_generated_field = "04B4E10AE3E38C24827628B090CB2FA5")

    private Paint mPaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.748 -0400", hash_original_field = "14507E05B66C5FE974699CFFBE32F2E5", hash_generated_field = "AC4742002633DDCCAE006F8E59AFF6D4")

    private Paint mPathPaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.749 -0400", hash_original_field = "BB8B2E1A07C8454EE3FBC1598B6BB437", hash_generated_field = "91E854667646D2C3CA8E9D2119D05265")

    private OnPatternListener mOnPatternListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.749 -0400", hash_original_field = "25374BE62663029C2169CF7949CB5E45", hash_generated_field = "A19D76803C2A5CD566F3965508BF5BBC")

    private ArrayList<Cell> mPattern = new ArrayList<Cell>(9);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.749 -0400", hash_original_field = "241D66ABF95374875694DC736C145DF7", hash_generated_field = "E86D6929706669FA682EB848C921EB8D")

    private boolean[][] mPatternDrawLookup = new boolean;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.749 -0400", hash_original_field = "978C6ED0C3D5FFB32B7A1986D5B1DD77", hash_generated_field = "4C11B8C984D6C030CA7546F1C45FAA23")

    private float mInProgressX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.749 -0400", hash_original_field = "58D54154B6609A636C94CF3F029F83EB", hash_generated_field = "6ECC8E3E686196F48BE8B3CA3967B1C2")

    private float mInProgressY = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.749 -0400", hash_original_field = "CAB52A5049576468C31ABA15574A2D96", hash_generated_field = "61EEAB5C32CCAB4FF3F5113A41ABDB11")

    private long mAnimatingPeriodStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.750 -0400", hash_original_field = "FDB87151CA5F276350D398D6022CBE35", hash_generated_field = "4A66875283A49247BE747B2970B0F6BE")

    private DisplayMode mPatternDisplayMode = DisplayMode.Correct;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.750 -0400", hash_original_field = "71BEB54FF847DBEFBAED61A613BD4CB6", hash_generated_field = "41AAD4901F0029EEC6B8E63FD039E943")

    private boolean mInputEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.750 -0400", hash_original_field = "A7431777F67B26CAF979FD91DA11520B", hash_generated_field = "95FDA5F9CEAE659647EFE4130133186A")

    private boolean mInStealthMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.750 -0400", hash_original_field = "968237CE71458F8F333375A8063A474F", hash_generated_field = "A017AC3DEC468AE7E7E913F99B1EF808")

    private boolean mEnableHapticFeedback = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.750 -0400", hash_original_field = "986DAEC689A69389A29058DE339EB21F", hash_generated_field = "3E75BC55D06C84083495DC2D5C3DF662")

    private boolean mPatternInProgress = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.750 -0400", hash_original_field = "E9109C25FE73A31B969C377242F0408F", hash_generated_field = "5597DEE40A9317D4D7EC4681E9AF5345")

    private float mDiameterFactor = 0.10f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "8BDCBD37F10858619DA0AFA43EB2F805", hash_generated_field = "9E067082059BBC11EB30BFFB8FCE47B5")

    private final int mStrokeAlpha = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "A6026F930086BFE7898ADC72229F3AA0", hash_generated_field = "6D15498857D77F549B70451B5579DCD4")

    private float mHitFactor = 0.6f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "7FA2F883E77243D65038392D25B45C07", hash_generated_field = "0A0B079CB04DC900AAEEE518156DABF9")

    private float mSquareWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "FB276DE0D48A20A0DB9DA28FC7A18351", hash_generated_field = "938A9E99A11188E8BF918C7AE32A451E")

    private float mSquareHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "C9A5B6D28C54B62DCAAB0DD5675D2D1D", hash_generated_field = "912BBC69B624AEAB8AD03A9049FDE50E")

    private Bitmap mBitmapBtnDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "AD30CF515BD10940C08701F80870B743", hash_generated_field = "7E8EED2E789262F301E0B39715714E5B")

    private Bitmap mBitmapBtnTouched;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "69776C214FF34F4A57F8D4444A3E0F50", hash_generated_field = "B13AF2D59593EA83D03002D3EFC02E9F")

    private Bitmap mBitmapCircleDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.751 -0400", hash_original_field = "BB49C3D971C0053571C78D112BA46825", hash_generated_field = "0C819506F26073E8B03A6274E50056A0")

    private Bitmap mBitmapCircleGreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "06CA167E2338C4FBF04A4FC8CDBA49BD", hash_generated_field = "92C499D07642327D378CF843B9A25767")

    private Bitmap mBitmapCircleRed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "6BC4508A6558569F7F23E44B33A05A14", hash_generated_field = "87226C7E7A041CD81135D49BF54CAE30")

    private Bitmap mBitmapArrowGreenUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "C6A609239ADE62AB010C71C294001207", hash_generated_field = "3ED5705DA3D892B3EDAE8D9FC7DA93DA")

    private Bitmap mBitmapArrowRedUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "650ECC2C1DCE6748709A45758A2FF031", hash_generated_field = "A4728B92E5B683E7E3DCB3E6896123E1")

    private final Path mCurrentPath = new Path();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "0A89D8FCE7D2669FA3F23739A2CDAE80", hash_generated_field = "29D89654815C4DD328FBCD4EFB3E81BC")

    private final Rect mInvalidate = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "DE6A0ABB3CA1313B4F7BDFF407B4A18B", hash_generated_field = "568275F41A7E61D900F9F414E799383D")

    private int mBitmapWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "EE573FC7FF36074270F8BF43556DFB4C", hash_generated_field = "2EAFFA48F02C3807ED7A1FED6D773758")

    private int mBitmapHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "4A9E46E83BB859367D541DBF909B5A12", hash_generated_field = "C7D9F89D8B235637A6D0414B0D5D4192")

    private int mAspect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.752 -0400", hash_original_field = "37DEBC0813F346B12EE8391A2B225F0D", hash_generated_field = "22F9256D9A7C1F969F659EDB29B90DAE")

    private final Matrix mArrowMatrix = new Matrix();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.753 -0400", hash_original_field = "9EDB3B9E9908CEC3645FBCAB6FDDDA83", hash_generated_field = "C9B494DD5DD036B0B905A6441C30B7D2")

    private final Matrix mCircleMatrix = new Matrix();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.753 -0400", hash_original_method = "3A55554289B054FB996E5C71F5FA4CE9", hash_generated_method = "0F82A4D9C2E67DFB458F1BEAE1EA53B3")
    public  LockPatternView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.755 -0400", hash_original_method = "8D8A970BE77F11A5C01A5A31474CCEF0", hash_generated_method = "F3D137129195EE8B4691D351FE62DDAB")
    public  LockPatternView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LockPatternView);
        final String aspect = a.getString(R.styleable.LockPatternView_aspect);
        if("square".equals(aspect))        
        {
mAspect=ASPECT_SQUARE
        } //End block
        else
        if("lock_width".equals(aspect))        
        {
mAspect=ASPECT_LOCK_WIDTH
        } //End block
        else
        if("lock_height".equals(aspect))        
        {
mAspect=ASPECT_LOCK_HEIGHT
        } //End block
        else
        {
mAspect=ASPECT_SQUARE
        } //End block
setClickable(true)mPathPaint.setAntiAlias(true)mPathPaint.setDither(true)mPathPaint.setColor(Color.WHITE)mPathPaint.setAlpha(mStrokeAlpha)mPathPaint.setStyle(Paint.Style.STROKE)mPathPaint.setStrokeJoin(Paint.Join.ROUND)mPathPaint.setStrokeCap(Paint.Cap.ROUND)mBitmapBtnDefault=getBitmapFor(R.drawable.btn_code_lock_default_holo)mBitmapBtnTouched=getBitmapFor(R.drawable.btn_code_lock_touched_holo)mBitmapCircleDefault=getBitmapFor(R.drawable.indicator_code_lock_point_area_default_holo)mBitmapCircleGreen=getBitmapFor(R.drawable.indicator_code_lock_point_area_green_holo)mBitmapCircleRed=getBitmapFor(R.drawable.indicator_code_lock_point_area_red_holo)mBitmapArrowGreenUp=getBitmapFor(R.drawable.indicator_code_lock_drag_direction_green_up)mBitmapArrowRedUp=getBitmapFor(R.drawable.indicator_code_lock_drag_direction_red_up)        final Bitmap bitmaps[] = { mBitmapBtnDefault, mBitmapBtnTouched, mBitmapCircleDefault,
                mBitmapCircleGreen, mBitmapCircleRed };
for(Bitmap bitmap : bitmaps)
        {
mBitmapWidth=Math.max(mBitmapWidth, bitmap.getWidth())mBitmapHeight=Math.max(mBitmapHeight, bitmap.getHeight())
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.756 -0400", hash_original_method = "D379B940B8A5122B507532E7B01E3CF6", hash_generated_method = "B2CE8A6B96D3B8551B27ED86529528ED")
    private Bitmap getBitmapFor(int resId) {
        addTaint(resId);
Bitmap varE216A88D641E3F52FD4959B6883C74DD_2118400942 = BitmapFactory.decodeResource(getContext().getResources(), resId)        varE216A88D641E3F52FD4959B6883C74DD_2118400942.addTaint(taint);
        return varE216A88D641E3F52FD4959B6883C74DD_2118400942;
        // ---------- Original Method ----------
        //return BitmapFactory.decodeResource(getContext().getResources(), resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.757 -0400", hash_original_method = "C832487470C71995F0684606F15D6220", hash_generated_method = "4CDDD923045C04B036CD7FF37412A9A3")
    public boolean isInStealthMode() {
        boolean varEDFB0E1BF2D9B454C1B432E81195DAE7_1375137269 = (mInStealthMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912817770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912817770;
        // ---------- Original Method ----------
        //return mInStealthMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.757 -0400", hash_original_method = "E32B26219F58436C48473E5796900F81", hash_generated_method = "D28826B11C113F8A058723AB73DD1E72")
    public boolean isTactileFeedbackEnabled() {
        boolean var5C0898DE6237C8FC1FD998C464D27E63_1519855631 = (mEnableHapticFeedback);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2110026804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2110026804;
        // ---------- Original Method ----------
        //return mEnableHapticFeedback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.758 -0400", hash_original_method = "220E752D718C9E33B75D440DBFCCBBC6", hash_generated_method = "271D9EFCC6F33E67EE16E1B09A23746C")
    public void setInStealthMode(boolean inStealthMode) {
        addTaint(inStealthMode);
mInStealthMode=inStealthMode
        // ---------- Original Method ----------
        //mInStealthMode = inStealthMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.758 -0400", hash_original_method = "44478313EBC3668248C169AAFC476039", hash_generated_method = "2AA4CB6BEB657EAF1A99ADA45D8D0B9B")
    public void setTactileFeedbackEnabled(boolean tactileFeedbackEnabled) {
        addTaint(tactileFeedbackEnabled);
mEnableHapticFeedback=tactileFeedbackEnabled
        // ---------- Original Method ----------
        //mEnableHapticFeedback = tactileFeedbackEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.761 -0400", hash_original_method = "9CDB8217AF76E8EA5B494A38C5DBB606", hash_generated_method = "FE904D8DE834280A050F767716133CAC")
    public void setOnPatternListener(
            OnPatternListener onPatternListener) {
        addTaint(onPatternListener.getTaint());
mOnPatternListener=onPatternListener
        // ---------- Original Method ----------
        //mOnPatternListener = onPatternListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.761 -0400", hash_original_method = "0890E6C96C8252B11FAF97A2C48B43EF", hash_generated_method = "DA319B3D0B42CBE7772BB309950676D7")
    public void setPattern(DisplayMode displayMode, List<Cell> pattern) {
        addTaint(pattern.getTaint());
        addTaint(displayMode.getTaint());
mPattern.clear()mPattern.addAll(pattern)clearPatternDrawLookup()for(Cell cell : pattern)
        {
mPatternDrawLookup[cell.getRow()][cell.getColumn()]=true
        } //End block
setDisplayMode(displayMode)
        // ---------- Original Method ----------
        //mPattern.clear();
        //mPattern.addAll(pattern);
        //clearPatternDrawLookup();
        //for (Cell cell : pattern) {
            //mPatternDrawLookup[cell.getRow()][cell.getColumn()] = true;
        //}
        //setDisplayMode(displayMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.762 -0400", hash_original_method = "0C8B0C8B69248925D9C4A1B06C36760F", hash_generated_method = "BE056CF70C4236383109D84E391510DA")
    public void setDisplayMode(DisplayMode displayMode) {
        addTaint(displayMode.getTaint());
mPatternDisplayMode=displayMode        if(displayMode==DisplayMode.Animate)        
        {
            if(mPattern.size()==0)            
            {
                IllegalStateException varEE5F710D72F722921083C7FCBC080015_1769821685 = new IllegalStateException("you must have a pattern to "
                        + "animate if you want to set the display mode to animate");
                varEE5F710D72F722921083C7FCBC080015_1769821685.addTaint(taint);
                throw varEE5F710D72F722921083C7FCBC080015_1769821685;
            } //End block
mAnimatingPeriodStart=SystemClock.elapsedRealtime()            final Cell first = mPattern.get(0);
mInProgressX=getCenterXForColumn(first.getColumn())mInProgressY=getCenterYForRow(first.getRow())clearPatternDrawLookup()
        } //End block
invalidate()
        // ---------- Original Method ----------
        //mPatternDisplayMode = displayMode;
        //if (displayMode == DisplayMode.Animate) {
            //if (mPattern.size() == 0) {
                //throw new IllegalStateException("you must have a pattern to "
                        //+ "animate if you want to set the display mode to animate");
            //}
            //mAnimatingPeriodStart = SystemClock.elapsedRealtime();
            //final Cell first = mPattern.get(0);
            //mInProgressX = getCenterXForColumn(first.getColumn());
            //mInProgressY = getCenterYForRow(first.getRow());
            //clearPatternDrawLookup();
        //}
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.763 -0400", hash_original_method = "D99957C912BF304EB9776C5AA0F153BE", hash_generated_method = "0B71DE5E8904A6DC244E170B5A3A3919")
    private void notifyCellAdded() {
        if(mOnPatternListener!=null)        
        {
mOnPatternListener.onPatternCellAdded(mPattern)
        } //End block
sendAccessEvent(R.string.lockscreen_access_pattern_cell_added)
        // ---------- Original Method ----------
        //if (mOnPatternListener != null) {
            //mOnPatternListener.onPatternCellAdded(mPattern);
        //}
        //sendAccessEvent(R.string.lockscreen_access_pattern_cell_added);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.764 -0400", hash_original_method = "10DF8A387D30FA095B61AF2C82E4050F", hash_generated_method = "0B0E00139498ECFD222424C712D82D0F")
    private void notifyPatternStarted() {
        if(mOnPatternListener!=null)        
        {
mOnPatternListener.onPatternStart()
        } //End block
sendAccessEvent(R.string.lockscreen_access_pattern_start)
        // ---------- Original Method ----------
        //if (mOnPatternListener != null) {
            //mOnPatternListener.onPatternStart();
        //}
        //sendAccessEvent(R.string.lockscreen_access_pattern_start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.764 -0400", hash_original_method = "915619677AC48E721901811358E191BF", hash_generated_method = "0883A3AA3AA6670652605EA383118B45")
    private void notifyPatternDetected() {
        if(mOnPatternListener!=null)        
        {
mOnPatternListener.onPatternDetected(mPattern)
        } //End block
sendAccessEvent(R.string.lockscreen_access_pattern_detected)
        // ---------- Original Method ----------
        //if (mOnPatternListener != null) {
            //mOnPatternListener.onPatternDetected(mPattern);
        //}
        //sendAccessEvent(R.string.lockscreen_access_pattern_detected);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.765 -0400", hash_original_method = "0793DEA0AFFC5080EBF7D762FAEDD3AF", hash_generated_method = "5FBEFDD8FEBB04CF99A773ED8BC5CB58")
    private void notifyPatternCleared() {
        if(mOnPatternListener!=null)        
        {
mOnPatternListener.onPatternCleared()
        } //End block
sendAccessEvent(R.string.lockscreen_access_pattern_cleared)
        // ---------- Original Method ----------
        //if (mOnPatternListener != null) {
            //mOnPatternListener.onPatternCleared();
        //}
        //sendAccessEvent(R.string.lockscreen_access_pattern_cleared);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.766 -0400", hash_original_method = "CE5155D51E8AAE56828D736AE5756F06", hash_generated_method = "DCB3790ECB97BECF59EE3D2668044786")
    public void clearPattern() {
resetPattern()
        // ---------- Original Method ----------
        //resetPattern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.766 -0400", hash_original_method = "2097718109AB9DC6A2B25A83C4F7FC6C", hash_generated_method = "D8EA37AAB6795DE063936E0BC68ED98B")
    private void resetPattern() {
mPattern.clear()clearPatternDrawLookup()mPatternDisplayMode=DisplayMode.Correctinvalidate()
        // ---------- Original Method ----------
        //mPattern.clear();
        //clearPatternDrawLookup();
        //mPatternDisplayMode = DisplayMode.Correct;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.767 -0400", hash_original_method = "6EE9E9255BE08BF663B26700701C6CBF", hash_generated_method = "DBEE96181AACB7CA1D74A1C4A62635C9")
    private void clearPatternDrawLookup() {
for(int i = 0;i<3;i)
        {
for(int j = 0;j<3;j)
            {
mPatternDrawLookup[i][j]=false
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < 3; i++) {
            //for (int j = 0; j < 3; j++) {
                //mPatternDrawLookup[i][j] = false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.768 -0400", hash_original_method = "62D84A613B5FA2E60FBAE424703BC087", hash_generated_method = "D8137B99A30CA960D6D9BDE28B1E29CA")
    public void disableInput() {
mInputEnabled=false
        // ---------- Original Method ----------
        //mInputEnabled = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.768 -0400", hash_original_method = "B4904DBD61CCFC87499698EF15592733", hash_generated_method = "92541B56678C340C957683B66CFD351D")
    public void enableInput() {
mInputEnabled=true
        // ---------- Original Method ----------
        //mInputEnabled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.768 -0400", hash_original_method = "4BF47ED4065F72930433E92F842199D5", hash_generated_method = "AB8E4FE6F08717C925E2BEE379B351C1")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        final int width = w - mPaddingLeft - mPaddingRight;
mSquareWidth=width/3.0f        final int height = h - mPaddingTop - mPaddingBottom;
mSquareHeight=height/3.0f
        // ---------- Original Method ----------
        //final int width = w - mPaddingLeft - mPaddingRight;
        //mSquareWidth = width / 3.0f;
        //final int height = h - mPaddingTop - mPaddingBottom;
        //mSquareHeight = height / 3.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.769 -0400", hash_original_method = "4C2A169B2CBCC76B242870E677806C9D", hash_generated_method = "BE009E8FC633D11EDBBD80DBD433D826")
    private int resolveMeasured(int measureSpec, int desired) {
        addTaint(desired);
        addTaint(measureSpec);
        int result = 0;
        int specSize = MeasureSpec.getSize(measureSpec);
        switch(MeasureSpec.getMode(measureSpec)){
        case MeasureSpec.UNSPECIFIED:
result=desired        break;
        case MeasureSpec.AT_MOST:
result=Math.max(specSize, desired)        break;
        case MeasureSpec.EXACTLY:
        default:
result=specSize}        int varB4A88417B3D0170D754C647C30B7216A_937398504 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221069781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221069781;
        // ---------- Original Method ----------
        //int result = 0;
        //int specSize = MeasureSpec.getSize(measureSpec);
        //switch (MeasureSpec.getMode(measureSpec)) {
            //case MeasureSpec.UNSPECIFIED:
                //result = desired;
                //break;
            //case MeasureSpec.AT_MOST:
                //result = Math.max(specSize, desired);
                //break;
            //case MeasureSpec.EXACTLY:
            //default:
                //result = specSize;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.770 -0400", hash_original_method = "07EA91CB820BE4CA748490B23C1A7930", hash_generated_method = "40528EF2B554408F80EBEBF68483DCFE")
    @Override
    protected int getSuggestedMinimumWidth() {
        int varB1247AF913775BDB1B3479C4D6726583_281083962 = (3*mBitmapWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068589515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1068589515;
        // ---------- Original Method ----------
        //return 3 * mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.771 -0400", hash_original_method = "CE542CD9B2031968BBA599A380A9505F", hash_generated_method = "5B39E3825BD0D20EC6CF9D9D2DD85508")
    @Override
    protected int getSuggestedMinimumHeight() {
        int varB1247AF913775BDB1B3479C4D6726583_760545443 = (3*mBitmapWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619334963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619334963;
        // ---------- Original Method ----------
        //return 3 * mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.772 -0400", hash_original_method = "E267C1F0C833A8D50E70FB6278B81B80", hash_generated_method = "F82F6DE3D61517F751573C25974AAAAA")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int minimumWidth = getSuggestedMinimumWidth();
        final int minimumHeight = getSuggestedMinimumHeight();
        int viewWidth = resolveMeasured(widthMeasureSpec, minimumWidth);
        int viewHeight = resolveMeasured(heightMeasureSpec, minimumHeight);
        switch(mAspect){
        case ASPECT_SQUARE:
viewWidth=viewHeight=Math.min(viewWidth, viewHeight)        break;
        case ASPECT_LOCK_WIDTH:
viewHeight=Math.min(viewWidth, viewHeight)        break;
        case ASPECT_LOCK_HEIGHT:
viewWidth=Math.min(viewWidth, viewHeight)        break;
}setMeasuredDimension(viewWidth, viewHeight)
        // ---------- Original Method ----------
        //final int minimumWidth = getSuggestedMinimumWidth();
        //final int minimumHeight = getSuggestedMinimumHeight();
        //int viewWidth = resolveMeasured(widthMeasureSpec, minimumWidth);
        //int viewHeight = resolveMeasured(heightMeasureSpec, minimumHeight);
        //switch (mAspect) {
            //case ASPECT_SQUARE:
                //viewWidth = viewHeight = Math.min(viewWidth, viewHeight);
                //break;
            //case ASPECT_LOCK_WIDTH:
                //viewHeight = Math.min(viewWidth, viewHeight);
                //break;
            //case ASPECT_LOCK_HEIGHT:
                //viewWidth = Math.min(viewWidth, viewHeight);
                //break;
        //}
        //setMeasuredDimension(viewWidth, viewHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.775 -0400", hash_original_method = "FE98D21BCE9621C3AEE63E85B828BFAB", hash_generated_method = "6F05AF52BDB533492D0DA401C337559A")
    private Cell detectAndAddHit(float x, float y) {
        addTaint(y);
        addTaint(x);
        final Cell cell = checkForNewHit(x, y);
        if(cell!=null)        
        {
            Cell fillInGapCell = null;
            final ArrayList<Cell> pattern = mPattern;
            if(!pattern.isEmpty())            
            {
                final Cell lastCell = pattern.get(pattern.size() - 1);
                int dRow = cell.row - lastCell.row;
                int dColumn = cell.column - lastCell.column;
                int fillInRow = lastCell.row;
                int fillInColumn = lastCell.column;
                if(Math.abs(dRow)==2&&Math.abs(dColumn)!=1)                
                {
fillInRow=lastCell.row+((dRow>0)?1:1)
                } //End block
                if(Math.abs(dColumn)==2&&Math.abs(dRow)!=1)                
                {
fillInColumn=lastCell.column+((dColumn>0)?1:1)
                } //End block
fillInGapCell=Cell.of(fillInRow, fillInColumn)
            } //End block
            if(fillInGapCell!=null&&!mPatternDrawLookup[fillInGapCell.row][fillInGapCell.column])            
            {
addCellToPattern(fillInGapCell)
            } //End block
addCellToPattern(cell)            if(mEnableHapticFeedback)            
            {
performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING|HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING)
            } //End block
Cell var9663D565F853B3D861E7C748CE699513_1276428223 = cell            var9663D565F853B3D861E7C748CE699513_1276428223.addTaint(taint);
            return var9663D565F853B3D861E7C748CE699513_1276428223;
        } //End block
Cell var540C13E9E156B687226421B24F2DF178_416833487 = null        var540C13E9E156B687226421B24F2DF178_416833487.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_416833487;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.776 -0400", hash_original_method = "DC7440ACCA06C9D05579379277A5D8BC", hash_generated_method = "6F06BDA4783006B4EFED7295EF7C6617")
    private void addCellToPattern(Cell newCell) {
        addTaint(newCell.getTaint());
mPatternDrawLookup[newCell.getRow()][newCell.getColumn()]=truemPattern.add(newCell)notifyCellAdded()
        // ---------- Original Method ----------
        //mPatternDrawLookup[newCell.getRow()][newCell.getColumn()] = true;
        //mPattern.add(newCell);
        //notifyCellAdded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.777 -0400", hash_original_method = "9F2F7D70FA6D70EB8E11838FAFB9DB20", hash_generated_method = "25BE861C212388A0FB0C8E8C8E8F2881")
    private Cell checkForNewHit(float x, float y) {
        addTaint(y);
        addTaint(x);
        final int rowHit = getRowHit(y);
        if(rowHit<0)        
        {
Cell var540C13E9E156B687226421B24F2DF178_1105807617 = null            var540C13E9E156B687226421B24F2DF178_1105807617.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1105807617;
        } //End block
        final int columnHit = getColumnHit(x);
        if(columnHit<0)        
        {
Cell var540C13E9E156B687226421B24F2DF178_1480682672 = null            var540C13E9E156B687226421B24F2DF178_1480682672.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1480682672;
        } //End block
        if(mPatternDrawLookup[rowHit][columnHit])        
        {
Cell var540C13E9E156B687226421B24F2DF178_1264821720 = null            var540C13E9E156B687226421B24F2DF178_1264821720.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1264821720;
        } //End block
Cell var45B38436D390BC323CCED35CBBAFEC6A_1268548295 = Cell.of(rowHit, columnHit)        var45B38436D390BC323CCED35CBBAFEC6A_1268548295.addTaint(taint);
        return var45B38436D390BC323CCED35CBBAFEC6A_1268548295;
        // ---------- Original Method ----------
        //final int rowHit = getRowHit(y);
        //if (rowHit < 0) {
            //return null;
        //}
        //final int columnHit = getColumnHit(x);
        //if (columnHit < 0) {
            //return null;
        //}
        //if (mPatternDrawLookup[rowHit][columnHit]) {
            //return null;
        //}
        //return Cell.of(rowHit, columnHit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.779 -0400", hash_original_method = "641C8F984D7B9983FB423D40697F419D", hash_generated_method = "2A2E500BDEF6870577AFC61E269E38CB")
    private int getRowHit(float y) {
        addTaint(y);
        final float squareHeight = mSquareHeight;
        float hitSize = squareHeight * mHitFactor;
        float offset = mPaddingTop + (squareHeight - hitSize) / 2f;
for(int i = 0;i<3;i)
        {
            final float hitTop = offset + squareHeight * i;
            if(y>=hitTop&&y<=hitTop+hitSize)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1285423187 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993966416 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993966416;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_108885810 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004098698 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004098698;
        // ---------- Original Method ----------
        //final float squareHeight = mSquareHeight;
        //float hitSize = squareHeight * mHitFactor;
        //float offset = mPaddingTop + (squareHeight - hitSize) / 2f;
        //for (int i = 0; i < 3; i++) {
            //final float hitTop = offset + squareHeight * i;
            //if (y >= hitTop && y <= hitTop + hitSize) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.780 -0400", hash_original_method = "B3B83CD2E214452CC722665689C47926", hash_generated_method = "A38B2E06D3593D4AC95A68048434479D")
    private int getColumnHit(float x) {
        addTaint(x);
        final float squareWidth = mSquareWidth;
        float hitSize = squareWidth * mHitFactor;
        float offset = mPaddingLeft + (squareWidth - hitSize) / 2f;
for(int i = 0;i<3;i)
        {
            final float hitLeft = offset + squareWidth * i;
            if(x>=hitLeft&&x<=hitLeft+hitSize)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1086559010 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772543083 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772543083;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1830731268 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951037953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951037953;
        // ---------- Original Method ----------
        //final float squareWidth = mSquareWidth;
        //float hitSize = squareWidth * mHitFactor;
        //float offset = mPaddingLeft + (squareWidth - hitSize) / 2f;
        //for (int i = 0; i < 3; i++) {
            //final float hitLeft = offset + squareWidth * i;
            //if (x >= hitLeft && x <= hitLeft + hitSize) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.782 -0400", hash_original_method = "FF4AE971A2EAE39E843DF1D56F5160FE", hash_generated_method = "F7497869B73329A506BED361A92AF7DF")
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
        boolean var529D2E3159AA18EC09D8755785EF01BB_276523797 = (super.onHoverEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63641521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_63641521;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.783 -0400", hash_original_method = "CDC4D675A4FA48B09E16296085B09D6D", hash_generated_method = "5F19B73D1744D2DB4DAB57B5A347C52A")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(!mInputEnabled||!isEnabled())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1676454270 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292263057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_292263057;
        } //End block
        switch(event.getAction()){
        case MotionEvent.ACTION_DOWN:
handleActionDown(event)        boolean varB326B5062B2F0E69046810717534CB09_117025059 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000813293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000813293;
        case MotionEvent.ACTION_UP:
handleActionUp(event)        boolean varB326B5062B2F0E69046810717534CB09_1051955041 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_353104113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_353104113;
        case MotionEvent.ACTION_MOVE:
handleActionMove(event)        boolean varB326B5062B2F0E69046810717534CB09_315250976 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699281616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_699281616;
        case MotionEvent.ACTION_CANCEL:
resetPattern()mPatternInProgress=falsenotifyPatternCleared()        if(PROFILE_DRAWING)        
        {
            if(mDrawingProfilingStarted)            
            {
Debug.stopMethodTracing()mDrawingProfilingStarted=false
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_612996261 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_956610154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_956610154;
}        boolean var68934A3E9455FA72420237EB05902327_619838169 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544520895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544520895;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.786 -0400", hash_original_method = "4E8F7F78C78FFFC991F9211211C279DC", hash_generated_method = "EDBB3348473E61CB0BE92188343450F4")
    private void handleActionMove(MotionEvent event) {
        addTaint(event.getTaint());
        final int historySize = event.getHistorySize();
for(int i = 0;i<historySize+1;i)
        {
            final float x = i < historySize ? event.getHistoricalX(i) : event.getX();
            final float y = i < historySize ? event.getHistoricalY(i) : event.getY();
            final int patternSizePreHitDetect = mPattern.size();
            Cell hitCell = detectAndAddHit(x, y);
            final int patternSize = mPattern.size();
            if(hitCell!=null&&patternSize==1)            
            {
mPatternInProgress=truenotifyPatternStarted()
            } //End block
            final float dx = Math.abs(x - mInProgressX);
            final float dy = Math.abs(y - mInProgressY);
            if(dx+dy>mSquareWidth*0.01f)            
            {
                float oldX = mInProgressX;
                float oldY = mInProgressY;
mInProgressX=xmInProgressY=y                if(mPatternInProgress&&patternSize>0)                
                {
                    final ArrayList<Cell> pattern = mPattern;
                    final float radius = mSquareWidth * mDiameterFactor * 0.5f;
                    final Cell lastCell = pattern.get(patternSize - 1);
                    float startX = getCenterXForColumn(lastCell.column);
                    float startY = getCenterYForRow(lastCell.row);
                    float left;
                    float top;
                    float right;
                    float bottom;
                    final Rect invalidateRect = mInvalidate;
                    if(startX<x)                    
                    {
left=startXright=x
                    } //End block
                    else
                    {
left=xright=startX
                    } //End block
                    if(startY<y)                    
                    {
top=startYbottom=y
                    } //End block
                    else
                    {
top=ybottom=startY
                    } //End block
invalidateRect.set((int) (left-radius), (int) (top-radius), (int) (right+radius), (int) (bottom+radius))                    if(startX<oldX)                    
                    {
left=startXright=oldX
                    } //End block
                    else
                    {
left=oldXright=startX
                    } //End block
                    if(startY<oldY)                    
                    {
top=startYbottom=oldY
                    } //End block
                    else
                    {
top=oldYbottom=startY
                    } //End block
invalidateRect.union((int) (left-radius), (int) (top-radius), (int) (right+radius), (int) (bottom+radius))                    if(hitCell!=null)                    
                    {
startX=getCenterXForColumn(hitCell.column)startY=getCenterYForRow(hitCell.row)                        if(patternSize>=2)                        
                        {
hitCell=pattern.get(patternSize-1-(patternSize-patternSizePreHitDetect))oldX=getCenterXForColumn(hitCell.column)oldY=getCenterYForRow(hitCell.row)                            if(startX<oldX)                            
                            {
left=startXright=oldX
                            } //End block
                            else
                            {
left=oldXright=startX
                            } //End block
                            if(startY<oldY)                            
                            {
top=startYbottom=oldY
                            } //End block
                            else
                            {
top=oldYbottom=startY
                            } //End block
                        } //End block
                        else
                        {
left=right=startXtop=bottom=startY
                        } //End block
                        final float widthOffset = mSquareWidth / 2f;
                        final float heightOffset = mSquareHeight / 2f;
invalidateRect.set((int) (left-widthOffset), (int) (top-heightOffset), (int) (right+widthOffset), (int) (bottom+heightOffset))
                    } //End block
invalidate(invalidateRect)
                } //End block
                else
                {
invalidate()
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.787 -0400", hash_original_method = "828591C49C2F93AB5ACF13CE32D14AFC", hash_generated_method = "E03A3D348470D7CB426855E9DF7F4B6F")
    private void sendAccessEvent(int resId) {
        addTaint(resId);
setContentDescription(mContext.getString(resId))sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED)setContentDescription(null)
        // ---------- Original Method ----------
        //setContentDescription(mContext.getString(resId));
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //setContentDescription(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.795 -0400", hash_original_method = "847A2081B1BD1CBE4466DA9E5B8FFD59", hash_generated_method = "D3D481F473F4EFB393A9D4C3F433568C")
    private void handleActionUp(MotionEvent event) {
        addTaint(event.getTaint());
        if(!mPattern.isEmpty())        
        {
mPatternInProgress=falsenotifyPatternDetected()invalidate()
        } //End block
        if(PROFILE_DRAWING)        
        {
            if(mDrawingProfilingStarted)            
            {
Debug.stopMethodTracing()mDrawingProfilingStarted=false
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!mPattern.isEmpty()) {
            //mPatternInProgress = false;
            //notifyPatternDetected();
            //invalidate();
        //}
        //if (PROFILE_DRAWING) {
            //if (mDrawingProfilingStarted) {
                //Debug.stopMethodTracing();
                //mDrawingProfilingStarted = false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.797 -0400", hash_original_method = "89C6F23DECB7592DC9F7B1B543E58045", hash_generated_method = "6FDB80E724C17DBBEA8CADDA1D4B9779")
    private void handleActionDown(MotionEvent event) {
        addTaint(event.getTaint());
resetPattern()        final float x = event.getX();
        final float y = event.getY();
        final Cell hitCell = detectAndAddHit(x, y);
        if(hitCell!=null)        
        {
mPatternInProgress=truemPatternDisplayMode=DisplayMode.CorrectnotifyPatternStarted()
        } //End block
        else
        {
mPatternInProgress=falsenotifyPatternCleared()
        } //End block
        if(hitCell!=null)        
        {
            final float startX = getCenterXForColumn(hitCell.column);
            final float startY = getCenterYForRow(hitCell.row);
            final float widthOffset = mSquareWidth / 2f;
            final float heightOffset = mSquareHeight / 2f;
invalidate((int) (startX-widthOffset), (int) (startY-heightOffset), (int) (startX+widthOffset), (int) (startY+heightOffset))
        } //End block
mInProgressX=xmInProgressY=y        if(PROFILE_DRAWING)        
        {
            if(!mDrawingProfilingStarted)            
            {
Debug.startMethodTracing("LockPatternDrawing")mDrawingProfilingStarted=true
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.799 -0400", hash_original_method = "FDBC7D944A55F62EBCDE234BF9B2B07A", hash_generated_method = "B3AAF9C7A8DB030633461780FC80B920")
    private float getCenterXForColumn(int column) {
        addTaint(column);
        float varFE9E4B95D8337A95761124C9613453AA_695633885 = (mPaddingLeft+column*mSquareWidth+mSquareWidth/2f);
                float var546ADE640B6EDFBC8A086EF31347E768_316738203 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_316738203;
        // ---------- Original Method ----------
        //return mPaddingLeft + column * mSquareWidth + mSquareWidth / 2f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.800 -0400", hash_original_method = "90EA937E99D464CE86A6FF5BE06C9147", hash_generated_method = "2B41C36D48E0535590FF6CE2E0E5613C")
    private float getCenterYForRow(int row) {
        addTaint(row);
        float var04BC0700321EE81252DEBF3EEC5959C9_1051298860 = (mPaddingTop+row*mSquareHeight+mSquareHeight/2f);
                float var546ADE640B6EDFBC8A086EF31347E768_162089637 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_162089637;
        // ---------- Original Method ----------
        //return mPaddingTop + row * mSquareHeight + mSquareHeight / 2f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.802 -0400", hash_original_method = "11E34DC9B1CCCBC19F667DFE09D819E1", hash_generated_method = "261E5C12FA49C7DCDD5442C2B3680221")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        final ArrayList<Cell> pattern = mPattern;
        final int count = pattern.size();
        final boolean[][] drawLookup = mPatternDrawLookup;
        if(mPatternDisplayMode==DisplayMode.Animate)        
        {
            final int oneCycle = (count + 1) * MILLIS_PER_CIRCLE_ANIMATING;
            final int spotInCycle = (int) (SystemClock.elapsedRealtime() -
                    mAnimatingPeriodStart) % oneCycle;
            final int numCircles = spotInCycle / MILLIS_PER_CIRCLE_ANIMATING;
clearPatternDrawLookup()for(int i = 0;i<numCircles;i)
            {
                final Cell cell = pattern.get(i);
drawLookup[cell.getRow()][cell.getColumn()]=true
            } //End block
            final boolean needToUpdateInProgressPoint = numCircles > 0
                    && numCircles < count;
            if(needToUpdateInProgressPoint)            
            {
                final float percentageOfNextCircle = ((float) (spotInCycle % MILLIS_PER_CIRCLE_ANIMATING)) /
                                MILLIS_PER_CIRCLE_ANIMATING;
                final Cell currentCell = pattern.get(numCircles - 1);
                final float centerX = getCenterXForColumn(currentCell.column);
                final float centerY = getCenterYForRow(currentCell.row);
                final Cell nextCell = pattern.get(numCircles);
                final float dx = percentageOfNextCircle *
                        (getCenterXForColumn(nextCell.column) - centerX);
                final float dy = percentageOfNextCircle *
                        (getCenterYForRow(nextCell.row) - centerY);
mInProgressX=centerX+dxmInProgressY=centerY+dy
            } //End block
invalidate()
        } //End block
        final float squareWidth = mSquareWidth;
        final float squareHeight = mSquareHeight;
        float radius = (squareWidth * mDiameterFactor * 0.5f);
mPathPaint.setStrokeWidth(radius)        final Path currentPath = mCurrentPath;
currentPath.rewind()        final int paddingTop = mPaddingTop;
        final int paddingLeft = mPaddingLeft;
for(int i = 0;i<3;i)
        {
            float topY = paddingTop + i * squareHeight;
for(int j = 0;j<3;j)
            {
                float leftX = paddingLeft + j * squareWidth;
drawCircle(canvas, (int) leftX, (int) topY, drawLookup[i][j])
            } //End block
        } //End block
        final boolean drawPath = (!mInStealthMode || mPatternDisplayMode == DisplayMode.Wrong);
        boolean oldFlag = (mPaint.getFlags() & Paint.FILTER_BITMAP_FLAG) != 0;
mPaint.setFilterBitmap(true)        if(drawPath)        
        {
for(int i = 0;i<count-1;i)
            {
                Cell cell = pattern.get(i);
                Cell next = pattern.get(i + 1);
                if(!drawLookup[next.row][next.column])                
                {
                    break;
                } //End block
                float leftX = paddingLeft + cell.column * squareWidth;
                float topY = paddingTop + cell.row * squareHeight;
drawArrow(canvas, leftX, topY, cell, next)
            } //End block
        } //End block
        if(drawPath)        
        {
            boolean anyCircles = false;
for(int i = 0;i<count;i)
            {
                Cell cell = pattern.get(i);
                if(!drawLookup[cell.row][cell.column])                
                {
                    break;
                } //End block
anyCircles=true                float centerX = getCenterXForColumn(cell.column);
                float centerY = getCenterYForRow(cell.row);
                if(i==0)                
                {
currentPath.moveTo(centerX, centerY)
                } //End block
                else
                {
currentPath.lineTo(centerX, centerY)
                } //End block
            } //End block
            if((mPatternInProgress||mPatternDisplayMode==DisplayMode.Animate)&&anyCircles)            
            {
currentPath.lineTo(mInProgressX, mInProgressY)
            } //End block
canvas.drawPath(currentPath, mPathPaint)
        } //End block
mPaint.setFilterBitmap(oldFlag)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.804 -0400", hash_original_method = "9BB831C4EE0E0548E19AAF53D1528F4D", hash_generated_method = "60B0FBC7C6439A271C182777F69E0DEE")
    private void drawArrow(Canvas canvas, float leftX, float topY, Cell start, Cell end) {
        addTaint(end.getTaint());
        addTaint(start.getTaint());
        addTaint(topY);
        addTaint(leftX);
        addTaint(canvas.getTaint());
        boolean green = mPatternDisplayMode != DisplayMode.Wrong;
        final int endRow = end.row;
        final int startRow = start.row;
        final int endColumn = end.column;
        final int startColumn = start.column;
        final int offsetX = ((int) mSquareWidth - mBitmapWidth) / 2;
        final int offsetY = ((int) mSquareHeight - mBitmapHeight) / 2;
        Bitmap arrow = green ? mBitmapArrowGreenUp : mBitmapArrowRedUp;
        final int cellWidth = mBitmapWidth;
        final int cellHeight = mBitmapHeight;
        final float theta = (float) Math.atan2(
                (double) (endRow - startRow), (double) (endColumn - startColumn));
        final float angle = (float) Math.toDegrees(theta) + 90.0f;
        float sx = Math.min(mSquareWidth / mBitmapWidth, 1.0f);
        float sy = Math.min(mSquareHeight / mBitmapHeight, 1.0f);
mArrowMatrix.setTranslate(leftX+offsetX, topY+offsetY)mArrowMatrix.preTranslate(mBitmapWidth/2, mBitmapHeight/2)mArrowMatrix.preScale(sx, sy)mArrowMatrix.preTranslate(-mBitmapWidth/2, -mBitmapHeight/2)mArrowMatrix.preRotate(angle, cellWidth/2.0f, cellHeight/2.0f)mArrowMatrix.preTranslate((cellWidth-arrow.getWidth())/2.0f, 0.0f)canvas.drawBitmap(arrow, mArrowMatrix, mPaint)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.805 -0400", hash_original_method = "92AB9E42D4AEFD4F9347340A046B284A", hash_generated_method = "BE967B0526DC5F992470B8B8E1940298")
    private void drawCircle(Canvas canvas, int leftX, int topY, boolean partOfPattern) {
        addTaint(partOfPattern);
        addTaint(topY);
        addTaint(leftX);
        addTaint(canvas.getTaint());
        Bitmap outerCircle;
        Bitmap innerCircle;
        if(!partOfPattern||(mInStealthMode&&mPatternDisplayMode!=DisplayMode.Wrong))        
        {
outerCircle=mBitmapCircleDefaultinnerCircle=mBitmapBtnDefault
        } //End block
        else
        if(mPatternInProgress)        
        {
outerCircle=mBitmapCircleGreeninnerCircle=mBitmapBtnTouched
        } //End block
        else
        if(mPatternDisplayMode==DisplayMode.Wrong)        
        {
outerCircle=mBitmapCircleRedinnerCircle=mBitmapBtnDefault
        } //End block
        else
        if(mPatternDisplayMode==DisplayMode.Correct||mPatternDisplayMode==DisplayMode.Animate)        
        {
outerCircle=mBitmapCircleGreeninnerCircle=mBitmapBtnDefault
        } //End block
        else
        {
            IllegalStateException varEE00E4D5848CD985780FD11FBC719D9E_871874137 = new IllegalStateException("unknown display mode " + mPatternDisplayMode);
            varEE00E4D5848CD985780FD11FBC719D9E_871874137.addTaint(taint);
            throw varEE00E4D5848CD985780FD11FBC719D9E_871874137;
        } //End block
        final int width = mBitmapWidth;
        final int height = mBitmapHeight;
        final float squareWidth = mSquareWidth;
        final float squareHeight = mSquareHeight;
        int offsetX = (int) ((squareWidth - width) / 2f);
        int offsetY = (int) ((squareHeight - height) / 2f);
        float sx = Math.min(mSquareWidth / mBitmapWidth, 1.0f);
        float sy = Math.min(mSquareHeight / mBitmapHeight, 1.0f);
mCircleMatrix.setTranslate(leftX+offsetX, topY+offsetY)mCircleMatrix.preTranslate(mBitmapWidth/2, mBitmapHeight/2)mCircleMatrix.preScale(sx, sy)mCircleMatrix.preTranslate(-mBitmapWidth/2, -mBitmapHeight/2)canvas.drawBitmap(outerCircle, mCircleMatrix, mPaint)canvas.drawBitmap(innerCircle, mCircleMatrix, mPaint)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.806 -0400", hash_original_method = "3D61FC85573DDAFBCE8D31A99249017A", hash_generated_method = "94348A6E35F0106FE75DBCC6A25975E7")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
Parcelable var60210F288694284CECC406ADA846CD86_166069054 = new SavedState(superState, LockPatternUtils.patternToString(mPattern), mPatternDisplayMode.ordinal(), mInputEnabled, mInStealthMode, mEnableHapticFeedback)        var60210F288694284CECC406ADA846CD86_166069054.addTaint(taint);
        return var60210F288694284CECC406ADA846CD86_166069054;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //return new SavedState(superState,
                //LockPatternUtils.patternToString(mPattern),
                //mPatternDisplayMode.ordinal(),
                //mInputEnabled, mInStealthMode, mEnableHapticFeedback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.811 -0400", hash_original_method = "FFBB1E5E99F50EBF4DFFFF65AB30F9D8", hash_generated_method = "2171E8EB53C2242AA61DE928CB62E899")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        final SavedState ss = (SavedState) state;
super.onRestoreInstanceState(ss.getSuperState())setPattern(DisplayMode.Correct, LockPatternUtils.stringToPattern(ss.getSerializedPattern()))mPatternDisplayMode=DisplayMode.values()[ss.getDisplayMode()]mInputEnabled=ss.isInputEnabled()mInStealthMode=ss.isInStealthMode()mEnableHapticFeedback=ss.isTactileFeedbackEnabled()
        // ---------- Original Method ----------
        //final SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //setPattern(
                //DisplayMode.Correct,
                //LockPatternUtils.stringToPattern(ss.getSerializedPattern()));
        //mPatternDisplayMode = DisplayMode.values()[ss.getDisplayMode()];
        //mInputEnabled = ss.isInputEnabled();
        //mInStealthMode = ss.isInStealthMode();
        //mEnableHapticFeedback = ss.isTactileFeedbackEnabled();
    }

    
    public static class Cell {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.811 -0400", hash_original_field = "F1965A857BC285D26FE22023AA5AB50D", hash_generated_field = "3295C82375A7A7DEB6BCB6BCD0CDC92A")

        int row;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.812 -0400", hash_original_field = "1AFD32818D1C9525F82AFF4C09EFD254", hash_generated_field = "90576625319AB666908247B08CE7D656")

        int column;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.812 -0400", hash_original_method = "151A543CB7ABEC8758727350CE6C637F", hash_generated_method = "7CD0F44C26A458E40BFE30DAF8E72EFC")
        private  Cell(int row, int column) {
            addTaint(column);
            addTaint(row);
checkRange(row, column)this.row=rowthis.column=column
            // ---------- Original Method ----------
            //checkRange(row, column);
            //this.row = row;
            //this.column = column;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.813 -0400", hash_original_method = "AF7253ABD7DC8BD7526756750AFFDB80", hash_generated_method = "6795910E419942596476024ACF4367FF")
        public int getRow() {
            int varF1965A857BC285D26FE22023AA5AB50D_1771906946 = (row);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965288721 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965288721;
            // ---------- Original Method ----------
            //return row;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.813 -0400", hash_original_method = "C1D54B9B4F834129324011499D6C107B", hash_generated_method = "F94ADF5848B52E9AF2D28BAA26EFB989")
        public int getColumn() {
            int var1AFD32818D1C9525F82AFF4C09EFD254_555037978 = (column);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462254366 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462254366;
            // ---------- Original Method ----------
            //return column;
        }

        
                public static synchronized Cell of(int row, int column) {
            checkRange(row, column);
            return sCells[row][column];
        }

        
                private static void checkRange(int row, int column) {
            if (row < 0 || row > 2) {
                throw new IllegalArgumentException("row must be in range 0-2");
            }
            if (column < 0 || column > 2) {
                throw new IllegalArgumentException("column must be in range 0-2");
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.814 -0400", hash_original_method = "C0F7CD8AE3DE0884F724FA0E902E586A", hash_generated_method = "1F324E926050CDEE926FD456C2D5D562")
        public String toString() {
String varB38BB72C06EB67EFB9771E4B3E9C3B77_1630188747 = "(row="+row+",clmn="+column+")"            varB38BB72C06EB67EFB9771E4B3E9C3B77_1630188747.addTaint(taint);
            return varB38BB72C06EB67EFB9771E4B3E9C3B77_1630188747;
            // ---------- Original Method ----------
            //return "(row=" + row + ",clmn=" + column + ")";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.817 -0400", hash_original_field = "942CD02B66C1D0D464201BAE87DE4C83", hash_generated_field = "326745F73C1070F18A6E92697A7A482F")

        static Cell[][] sCells = new Cell;
        static {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sCells[i][j] = new Cell(i, j);
                }
            }
        }
        
    }


    
    public enum DisplayMode {
        Correct,
        Animate,
        Wrong
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.817 -0400", hash_original_field = "99F286DC26B71C58B647445F8DF5707B", hash_generated_field = "A130332A8FC560BB96D183BD967EB964")

        private String mSerializedPattern;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.818 -0400", hash_original_field = "9953FD083D5B32F30D24994E003D5A9C", hash_generated_field = "E94C836F8306F74CCDB7AA1A1D386E0A")

        private int mDisplayMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.818 -0400", hash_original_field = "BBA8781B7745F03B772BCBB5E1829DAD", hash_generated_field = "5C378AA07FAEF734578B0B5EF57499A8")

        private boolean mInputEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.818 -0400", hash_original_field = "EDFB0E1BF2D9B454C1B432E81195DAE7", hash_generated_field = "334B1749F7C2B96319B193821B1EA1C6")

        private boolean mInStealthMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.818 -0400", hash_original_field = "E3CCD72DBB36DCF918352D3834DAA4B2", hash_generated_field = "194511A4D4E2BB678A78B7F74D9601EE")

        private boolean mTactileFeedbackEnabled;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.819 -0400", hash_original_method = "08CDC0F6F8F2A7DA7360F4B56D8A8A24", hash_generated_method = "B7B6C750232B88CAA417FEF213037007")
        private  SavedState(Parcelable superState, String serializedPattern, int displayMode,
                boolean inputEnabled, boolean inStealthMode, boolean tactileFeedbackEnabled) {
            super(superState);
            addTaint(tactileFeedbackEnabled);
            addTaint(inStealthMode);
            addTaint(inputEnabled);
            addTaint(displayMode);
            addTaint(serializedPattern.getTaint());
            addTaint(superState.getTaint());
mSerializedPattern=serializedPatternmDisplayMode=displayModemInputEnabled=inputEnabledmInStealthMode=inStealthModemTactileFeedbackEnabled=tactileFeedbackEnabled
            // ---------- Original Method ----------
            //mSerializedPattern = serializedPattern;
            //mDisplayMode = displayMode;
            //mInputEnabled = inputEnabled;
            //mInStealthMode = inStealthMode;
            //mTactileFeedbackEnabled = tactileFeedbackEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.820 -0400", hash_original_method = "46D729832283D506E9BD6C6A8FED95F3", hash_generated_method = "5F8196ED4CA7BD96D7DE917F26B58DF4")
        private  SavedState(Parcel in) {
            super(in);
            addTaint(in.getTaint());
mSerializedPattern=in.readString()mDisplayMode=in.readInt()mInputEnabled=(Boolean) in.readValue(null)mInStealthMode=(Boolean) in.readValue(null)mTactileFeedbackEnabled=(Boolean) in.readValue(null)
            // ---------- Original Method ----------
            //mSerializedPattern = in.readString();
            //mDisplayMode = in.readInt();
            //mInputEnabled = (Boolean) in.readValue(null);
            //mInStealthMode = (Boolean) in.readValue(null);
            //mTactileFeedbackEnabled = (Boolean) in.readValue(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.820 -0400", hash_original_method = "AB882F9DC4D2BEB6011ECD96AD260189", hash_generated_method = "A05C31A464EC2DCF924A348F5895F7D0")
        public String getSerializedPattern() {
String varD09B1FB68BBAAAEA914D8D78BBC0E2E3_881774421 = mSerializedPattern            varD09B1FB68BBAAAEA914D8D78BBC0E2E3_881774421.addTaint(taint);
            return varD09B1FB68BBAAAEA914D8D78BBC0E2E3_881774421;
            // ---------- Original Method ----------
            //return mSerializedPattern;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.821 -0400", hash_original_method = "BB52164B3D3A8B1CBF5D8D6DC4EE5CA9", hash_generated_method = "F1AD77FAC6342FAB8B8BCFAF75B56433")
        public int getDisplayMode() {
            int var9953FD083D5B32F30D24994E003D5A9C_672976998 = (mDisplayMode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374815233 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374815233;
            // ---------- Original Method ----------
            //return mDisplayMode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.821 -0400", hash_original_method = "362068FF139CAB0B7C3BF996744A570E", hash_generated_method = "48D4494AF146712C800D74152EE20732")
        public boolean isInputEnabled() {
            boolean varBBA8781B7745F03B772BCBB5E1829DAD_32095110 = (mInputEnabled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_210539707 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_210539707;
            // ---------- Original Method ----------
            //return mInputEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.822 -0400", hash_original_method = "C832487470C71995F0684606F15D6220", hash_generated_method = "2DC67B84BCB4EA75562223CF43BBFFA0")
        public boolean isInStealthMode() {
            boolean varEDFB0E1BF2D9B454C1B432E81195DAE7_2133616333 = (mInStealthMode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981468214 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_981468214;
            // ---------- Original Method ----------
            //return mInStealthMode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.823 -0400", hash_original_method = "94C149817B40CA259F5CA0365896CE15", hash_generated_method = "083320D538E9D321F494263575B1ED3C")
        public boolean isTactileFeedbackEnabled() {
            boolean varE3CCD72DBB36DCF918352D3834DAA4B2_492136255 = (mTactileFeedbackEnabled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352994970 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_352994970;
            // ---------- Original Method ----------
            //return mTactileFeedbackEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.823 -0400", hash_original_method = "A6FF0013F334D62DB2DBEA0CE62DA12E", hash_generated_method = "F8BE938E992097CF41995EFBB8BF2BF4")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
super.writeToParcel(dest, flags)dest.writeString(mSerializedPattern)dest.writeInt(mDisplayMode)dest.writeValue(mInputEnabled)dest.writeValue(mInStealthMode)dest.writeValue(mTactileFeedbackEnabled)
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeString(mSerializedPattern);
            //dest.writeInt(mDisplayMode);
            //dest.writeValue(mInputEnabled);
            //dest.writeValue(mInStealthMode);
            //dest.writeValue(mTactileFeedbackEnabled);
        }

        


    
    public static interface OnPatternListener {

        
        void onPatternStart();

        
        void onPatternCleared();

        
        void onPatternCellAdded(List<Cell> pattern);

        
        void onPatternDetected(List<Cell> pattern);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.824 -0400", hash_original_field = "D9730ADE585D2E3CE91131D0CC4F194F", hash_generated_field = "B8931003D48E1AFC941E6992B8470462")

    private static final String TAG = "LockPatternView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.824 -0400", hash_original_field = "6FB1D2A1A8F549445F09A28BDA49775A", hash_generated_field = "A5E4117EF06D0238152D8794308FD276")

    private static final int ASPECT_SQUARE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.825 -0400", hash_original_field = "9202FCEAD4AF32760D0BD9CDC2FA9EDF", hash_generated_field = "0944C7937CD6FA345037AA573610358C")

    private static final int ASPECT_LOCK_WIDTH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.825 -0400", hash_original_field = "4AF0667707D1FAABEC5C0C2F6A8ED98F", hash_generated_field = "D50C8BA6E56DFE7D13E7EF33E771965C")

    private static final int ASPECT_LOCK_HEIGHT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.825 -0400", hash_original_field = "CB15214C92560C46757F3C0343F1F093", hash_generated_field = "F52D6F381E9EB3884BEEA64CDA790DB5")

    private static final boolean PROFILE_DRAWING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.825 -0400", hash_original_field = "762165DB518FDA6DA5758412832976CA", hash_generated_field = "D1A00CF50479A702B280EC3F3350FE70")

    static final int STATUS_BAR_HEIGHT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.826 -0400", hash_original_field = "E092FCDCD47698D5F8C3E6C06DFB2C8E", hash_generated_field = "C0D3B1730E3D44AE6D439322D6C300BA")

    private static final int MILLIS_PER_CIRCLE_ANIMATING = 700;
}

