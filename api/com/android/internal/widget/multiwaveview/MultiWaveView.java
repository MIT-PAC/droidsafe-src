package com.android.internal.widget.multiwaveview;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import com.android.internal.R;
import android.os.Vibrator;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.MotionEvent;
import android.graphics.drawable.Drawable;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.accessibility.AccessibilityManager;
import android.graphics.RectF;
import android.text.TextUtils;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.content.res.TypedArray;
public class MultiWaveView extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.974 -0400", hash_original_field = "770DB2CF23EE860B024661A492221D78", hash_generated_field = "5623650447D8DBE3671B7B2C7750FA29")

    private TimeInterpolator mChevronAnimationInterpolator = Ease.Quad.easeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.975 -0400", hash_original_field = "E9BF4917522326074B5E44142C1F1005", hash_generated_field = "9B0382BB4749CCBD3232352066A792AD")

    private ArrayList<TargetDrawable> mTargetDrawables = new ArrayList<TargetDrawable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.975 -0400", hash_original_field = "C74C132F74688BDA5EA5BA0A7565B7DD", hash_generated_field = "6F05EF4654A1D7D21D9874E85913B7B0")

    private ArrayList<TargetDrawable> mChevronDrawables = new ArrayList<TargetDrawable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.975 -0400", hash_original_field = "951587147D98C61387ECED859795A5E4", hash_generated_field = "D424BE425979673156E8F55DD0FAECD9")

    private ArrayList<Tweener> mChevronAnimations = new ArrayList<Tweener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.975 -0400", hash_original_field = "128EE99A033A8645D9759D5D214A3136", hash_generated_field = "104C7C570B5CD8545674A2C76FDDA0A0")

    private ArrayList<Tweener> mTargetAnimations = new ArrayList<Tweener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.975 -0400", hash_original_field = "43D94E0C4C77B8D3E52E1FDF27A5A21E", hash_generated_field = "12ADF096FEAD4843768461FB5B5AC294")

    private ArrayList<String> mTargetDescriptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "AA20586B0407A1657E80B4F6AC4D0296", hash_generated_field = "D1AC8721F65699ECEAC58C0F191FACDD")

    private ArrayList<String> mDirectionDescriptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "160A180FC3CA16A88FFED67853892822", hash_generated_field = "6A8F7789B35F37BA9DC631B94C014DAD")

    private Tweener mHandleAnimation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "BB32CCD8F958DE59F4FB742C226D38D4", hash_generated_field = "B712B682ACEFEF430B86ECE8AB423B62")

    private OnTriggerListener mOnTriggerListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "BF9C5474EFB1B410B02DA9FD52B19944", hash_generated_field = "A9F787A386A665E55E259F3AD5572A5A")

    private TargetDrawable mHandleDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "D02AD32F267ECC752FE877BA517ABBE7", hash_generated_field = "A175AA33F97C0A474A03D74FDF533D87")

    private TargetDrawable mOuterRing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "560EC933FF5763F980C1AAA7887459D4", hash_generated_field = "28ADEC971991F1A5C05DC67784FF191A")

    private Vibrator mVibrator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "0A8C5BFFDA848369DB22ADA2B71E0006", hash_generated_field = "BCC67E2957FE1C28D1D60111D5F45346")

    private int mFeedbackCount = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "5B867444C7B1CE1D1343AA0EF806C751", hash_generated_field = "C44338C9DC766D26B0046A8A473C4823")

    private int mVibrationDuration = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "438A23C9285C50E8B4211BBFEE6E4479", hash_generated_field = "9B17E7D856CFFB1C739C8E8D60E29914")

    private int mGrabbedState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.976 -0400", hash_original_field = "67C487751FD6AD050E02740E79927E67", hash_generated_field = "099F1D1B612B222E38F0CE3541BF9FEC")

    private int mActiveTarget = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "0CB7C57C80067900EF796B7234F8C5FD", hash_generated_field = "606D95161D5735FB72E3DAEB2342CA3C")

    private float mTapRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "7FB90CC8D07631455DBE11B422B0EBA9", hash_generated_field = "A4E9A3682A1A68781A3CD155FE3DD289")

    private float mWaveCenterX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "31B8819E44AA3700666EB04F9AC88C01", hash_generated_field = "F4F97A0207211669AE61D37C9CC35D64")

    private float mWaveCenterY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "0BE384A684B56C62386155A095EBAD5A", hash_generated_field = "CA75A03DBB82F95634C869454E9E72AA")

    private float mVerticalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "BBEC6A907526E862E92F2788D5505B46", hash_generated_field = "E673E855233925C2C0F535800D30C925")

    private float mHorizontalOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "9D08C107A9DCD7ED6C0344D3650E26E5", hash_generated_field = "52FB83314525B49DF37046BC8C1B743C")

    private float mOuterRadius = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "8C8AC151D279222BC2BA8CC05DFCBCDE", hash_generated_field = "7D7751C56E843F1DE0B95997DCF7588D")

    private float mHitRadius = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "5996C6D477C1F6DD83256A6A3B59A99A", hash_generated_field = "6AC54BFB2D9746EE17EC8EA6EAD4A912")

    private float mSnapMargin = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "B3298065CA384AB9C76E95FF12D862DF", hash_generated_field = "28D9C38A63CC0E8BC9E397ABC91A037C")

    private boolean mDragging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.977 -0400", hash_original_field = "65B1E6FB2FD8A5FD5DAB535197816826", hash_generated_field = "52706B16C30AAD547A6FFBD8D616EED5")

    private int mNewTargetResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.978 -0400", hash_original_field = "F0406B7BEC3B3AE9011EF147A61FA430", hash_generated_field = "A65E1D123187798ED9A2748FE6DA0A17")

    private AnimatorListener mResetListener = new AnimatorListenerAdapter()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.978 -0400", hash_original_method = "3F9959D9F1F9418A7D45BD34A75FE6F6", hash_generated_method = "E3FEB93330BC6125C46B4B64D6A4C083")
        public void onAnimationEnd(Animator animator) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animator.getTaint());
switchToState(STATE_IDLE, mWaveCenterX, mWaveCenterY)
            // ---------- Original Method ----------
            //switchToState(STATE_IDLE, mWaveCenterX, mWaveCenterY);
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.979 -0400", hash_original_field = "E2EFCD08FAA2FFC5344A925AFCDF09D7", hash_generated_field = "8458E580EABAD5FE5BD7C368607F918E")

    private AnimatorListener mResetListenerWithPing = new AnimatorListenerAdapter()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.979 -0400", hash_original_method = "E40DA7622FD27C28E4C00BBC10B72B7D", hash_generated_method = "879DB56A4B14E2E15C0933D6D29A846E")
        public void onAnimationEnd(Animator animator) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animator.getTaint());
ping()switchToState(STATE_IDLE, mWaveCenterX, mWaveCenterY)
            // ---------- Original Method ----------
            //ping();
            //switchToState(STATE_IDLE, mWaveCenterX, mWaveCenterY);
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.980 -0400", hash_original_field = "52EDBAFE1A54C66E260F6EC1368A2706", hash_generated_field = "F31E405650267AD7E1BC3A80E5826FEE")

    private AnimatorUpdateListener mUpdateListener = new AnimatorUpdateListener()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.980 -0400", hash_original_method = "E5495CE2DDA25A7C1C41E9274879C280", hash_generated_method = "4ED8ED5911DA2AEB0DA47E3224C34A92")
        public void onAnimationUpdate(ValueAnimator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
invalidateGlobalRegion(mHandleDrawable)invalidate()
            // ---------- Original Method ----------
            //invalidateGlobalRegion(mHandleDrawable);
            //invalidate();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.980 -0400", hash_original_field = "C65DFC58007DF8529610EC1DFBDC95F6", hash_generated_field = "D68CE4EFD571A23653C17A3F8A181770")

    private boolean mAnimatingTargets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.982 -0400", hash_original_field = "A31C09D24992CE6394A9341E10727153", hash_generated_field = "49B8B76B28499BF345E2AC30135A718A")

    private AnimatorListener mTargetUpdateListener = new AnimatorListenerAdapter()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.981 -0400", hash_original_method = "8C472D8A6E94369FB8A5EF339863B5E6", hash_generated_method = "DB8E02FB38D862B8FDC32729247F94DC")
        public void onAnimationEnd(Animator animator) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animator.getTaint());
            if(mNewTargetResources!=0)            
            {
internalSetTargetResources(mNewTargetResources)mNewTargetResources=0hideTargets(false)
            } //End block
mAnimatingTargets=false
            // ---------- Original Method ----------
            //if (mNewTargetResources != 0) {
                //internalSetTargetResources(mNewTargetResources);
                //mNewTargetResources = 0;
                //hideTargets(false);
            //}
            //mAnimatingTargets = false;
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.982 -0400", hash_original_field = "84DA9E2FDBCBF88ADE08E8771214F9D8", hash_generated_field = "07A24BE88431CB658ACB09DF831CE60E")

    private int mTargetResourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.982 -0400", hash_original_field = "7A1F913515DF8A1B58FD27A3940B38C8", hash_generated_field = "3358C5EF18ABFAE5286185A2E93CC223")

    private int mTargetDescriptionsResourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.982 -0400", hash_original_field = "DEB61A5BFE30F92CA0323070B81BD023", hash_generated_field = "FFB63E8FB81B8FD989098E8FDFBA2105")

    private int mDirectionDescriptionsResourceId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.983 -0400", hash_original_method = "8EA258FBD458BBBE73B1A4193A44200E", hash_generated_method = "AB0E89C27064865E24FEB69F966B1070")
    public  MultiWaveView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.985 -0400", hash_original_method = "E4AB37481762BD8E0D897E83CA3D8170", hash_generated_method = "A1F54C06D17945E0043C797FCE0A500B")
    public  MultiWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        Resources res = context.getResources();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MultiWaveView);
mOuterRadius=a.getDimension(R.styleable.MultiWaveView_outerRadius, mOuterRadius)mHorizontalOffset=a.getDimension(R.styleable.MultiWaveView_horizontalOffset, mHorizontalOffset)mVerticalOffset=a.getDimension(R.styleable.MultiWaveView_verticalOffset, mVerticalOffset)mHitRadius=a.getDimension(R.styleable.MultiWaveView_hitRadius, mHitRadius)mSnapMargin=a.getDimension(R.styleable.MultiWaveView_snapMargin, mSnapMargin)mVibrationDuration=a.getInt(R.styleable.MultiWaveView_vibrationDuration, mVibrationDuration)mFeedbackCount=a.getInt(R.styleable.MultiWaveView_feedbackCount, mFeedbackCount)mHandleDrawable=new TargetDrawable(res, a.getDrawable(R.styleable.MultiWaveView_handleDrawable))mTapRadius=mHandleDrawable.getWidth()/2mOuterRing=new TargetDrawable(res, a.getDrawable(R.styleable.MultiWaveView_waveDrawable))        final int chevrons[] = { R.styleable.MultiWaveView_leftChevronDrawable,
                R.styleable.MultiWaveView_rightChevronDrawable,
                R.styleable.MultiWaveView_topChevronDrawable,
                R.styleable.MultiWaveView_bottomChevronDrawable
        };
for(int chevron : chevrons)
        {
            Drawable chevronDrawable = a.getDrawable(chevron);
for(int i = 0;i<mFeedbackCount;i)
            {
mChevronDrawables.add(chevronDrawable!=null?new TargetDrawable(res, chevronDrawable):new TargetDrawable(res, chevronDrawable))
            } //End block
        } //End block
        TypedValue outValue = new TypedValue();
        if(a.getValue(R.styleable.MultiWaveView_targetDrawables, outValue))        
        {
internalSetTargetResources(outValue.resourceId)
        } //End block
        if(mTargetDrawables==null||mTargetDrawables.size()==0)        
        {
            IllegalStateException varC77924C9B2B24558A451EF7BF5D43539_438283085 = new IllegalStateException("Must specify at least one target drawable");
            varC77924C9B2B24558A451EF7BF5D43539_438283085.addTaint(taint);
            throw varC77924C9B2B24558A451EF7BF5D43539_438283085;
        } //End block
        if(a.getValue(R.styleable.MultiWaveView_targetDescriptions, outValue))        
        {
            final int resourceId = outValue.resourceId;
            if(resourceId==0)            
            {
                IllegalStateException var3CEE354F5525E53590C672205AE12593_1167534501 = new IllegalStateException("Must specify target descriptions");
                var3CEE354F5525E53590C672205AE12593_1167534501.addTaint(taint);
                throw var3CEE354F5525E53590C672205AE12593_1167534501;
            } //End block
setTargetDescriptionsResourceId(resourceId)
        } //End block
        if(a.getValue(R.styleable.MultiWaveView_directionDescriptions, outValue))        
        {
            final int resourceId = outValue.resourceId;
            if(resourceId==0)            
            {
                IllegalStateException var5FD1E7E3743FBD6A0C767D1794B5CAD3_1032597415 = new IllegalStateException("Must specify direction descriptions");
                var5FD1E7E3743FBD6A0C767D1794B5CAD3_1032597415.addTaint(taint);
                throw var5FD1E7E3743FBD6A0C767D1794B5CAD3_1032597415;
            } //End block
setDirectionDescriptionsResourceId(resourceId)
        } //End block
a.recycle()setVibrateEnabled(mVibrationDuration>0)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.987 -0400", hash_original_method = "4089B5AD6DCCD2B602EBCDBAE57068BF", hash_generated_method = "6E04B276DC72C76D82C3DA7211DB88BD")
    private void dump() {
        // ---------- Original Method ----------
        //Log.v(TAG, "Outer Radius = " + mOuterRadius);
        //Log.v(TAG, "HitRadius = " + mHitRadius);
        //Log.v(TAG, "SnapMargin = " + mSnapMargin);
        //Log.v(TAG, "FeedbackCount = " + mFeedbackCount);
        //Log.v(TAG, "VibrationDuration = " + mVibrationDuration);
        //Log.v(TAG, "TapRadius = " + mTapRadius);
        //Log.v(TAG, "WaveCenterX = " + mWaveCenterX);
        //Log.v(TAG, "WaveCenterY = " + mWaveCenterY);
        //Log.v(TAG, "HorizontalOffset = " + mHorizontalOffset);
        //Log.v(TAG, "VerticalOffset = " + mVerticalOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.987 -0400", hash_original_method = "FD3F0602E16671E966137B98C9932AF4", hash_generated_method = "DEEC1D659660BC99E5E1AF281889044A")
    @Override
    protected int getSuggestedMinimumWidth() {
        int varF783322AF5F2ACC0C5ECC8482C7951A8_1897117430 = (mOuterRing.getWidth()+(mTargetDrawables.size()>0?(mTargetDrawables.get(0).getWidth()/2):(mTargetDrawables.get(0).getWidth()/2)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722711796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722711796;
        // ---------- Original Method ----------
        //return mOuterRing.getWidth()
                //+ (mTargetDrawables.size() > 0 ? (mTargetDrawables.get(0).getWidth()/2) : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.988 -0400", hash_original_method = "6D14A817BE681255232537ACD4517D78", hash_generated_method = "76D88C833BA2B5CCA125851ABBC7440E")
    @Override
    protected int getSuggestedMinimumHeight() {
        int var161589D625F37F66177098F37CAEED1A_1697436804 = (mOuterRing.getHeight()+(mTargetDrawables.size()>0?(mTargetDrawables.get(0).getHeight()/2):(mTargetDrawables.get(0).getHeight()/2)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029534451 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029534451;
        // ---------- Original Method ----------
        //return mOuterRing.getHeight()
                //+ (mTargetDrawables.size() > 0 ? (mTargetDrawables.get(0).getHeight()/2) : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.989 -0400", hash_original_method = "9B1AD73F07FDE187F4B8FF1B87513724", hash_generated_method = "ECFF7C5C69C66C8A9E0BB8792A40F65F")
    private int resolveMeasured(int measureSpec, int desired) {
        addTaint(desired);
        addTaint(measureSpec);
        int result = 0;
        int specSize = MeasureSpec.getSize(measureSpec);
        switch(MeasureSpec.getMode(measureSpec)){
        case MeasureSpec.UNSPECIFIED:
result=desired        break;
        case MeasureSpec.AT_MOST:
result=Math.min(specSize, desired)        break;
        case MeasureSpec.EXACTLY:
        default:
result=specSize}        int varB4A88417B3D0170D754C647C30B7216A_2078161123 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948429261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948429261;
        // ---------- Original Method ----------
        //int result = 0;
        //int specSize = MeasureSpec.getSize(measureSpec);
        //switch (MeasureSpec.getMode(measureSpec)) {
            //case MeasureSpec.UNSPECIFIED:
                //result = desired;
                //break;
            //case MeasureSpec.AT_MOST:
                //result = Math.min(specSize, desired);
                //break;
            //case MeasureSpec.EXACTLY:
            //default:
                //result = specSize;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.989 -0400", hash_original_method = "8B18E95982328DEBC71DDC3116D3E58E", hash_generated_method = "0414B45EF4ACDCB337F45907757BEFF5")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int minimumWidth = getSuggestedMinimumWidth();
        final int minimumHeight = getSuggestedMinimumHeight();
        int viewWidth = resolveMeasured(widthMeasureSpec, minimumWidth);
        int viewHeight = resolveMeasured(heightMeasureSpec, minimumHeight);
setMeasuredDimension(viewWidth, viewHeight)
        // ---------- Original Method ----------
        //final int minimumWidth = getSuggestedMinimumWidth();
        //final int minimumHeight = getSuggestedMinimumHeight();
        //int viewWidth = resolveMeasured(widthMeasureSpec, minimumWidth);
        //int viewHeight = resolveMeasured(heightMeasureSpec, minimumHeight);
        //setMeasuredDimension(viewWidth, viewHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.990 -0400", hash_original_method = "E6C4FA794AF765DE363A6C272A80F152", hash_generated_method = "1A84A8B8C79292DBFABCE1C56B9CC7BE")
    private void switchToState(int state, float x, float y) {
        addTaint(y);
        addTaint(x);
        addTaint(state);
        switch(state){
        case STATE_IDLE:
deactivateTargets()mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE)        break;
        case STATE_FIRST_TOUCH:
stopHandleAnimation()deactivateTargets()showTargets(true)mHandleDrawable.setState(TargetDrawable.STATE_ACTIVE)setGrabbedState(OnTriggerListener.CENTER_HANDLE)        if(AccessibilityManager.getInstance(mContext).isEnabled())        
        {
announceTargets()
        } //End block
        break;
        case STATE_TRACKING:
        break;
        case STATE_SNAP:
        break;
        case STATE_FINISH:
doFinish()        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.991 -0400", hash_original_method = "A4C683B00EE3A980366B0BE300EBA325", hash_generated_method = "E5FEC6C828436F4C46723B95BC92693E")
    private void startChevronAnimation() {
        final float r = mHandleDrawable.getWidth() * 0.4f;
        final float chevronAnimationDistance = mOuterRadius * 0.9f;
        final float from[][] = {
                {mWaveCenterX - r, mWaveCenterY},  
                {mWaveCenterX + r, mWaveCenterY},  
                {mWaveCenterX, mWaveCenterY - r},  
                {mWaveCenterX, mWaveCenterY + r} };
        final float to[][] = {
                {mWaveCenterX - chevronAnimationDistance, mWaveCenterY},  
                {mWaveCenterX + chevronAnimationDistance, mWaveCenterY},  
                {mWaveCenterX, mWaveCenterY - chevronAnimationDistance},  
                {mWaveCenterX, mWaveCenterY + chevronAnimationDistance} };
mChevronAnimations.clear()        final float startScale = 0.5f;
        final float endScale = 2.0f;
for(int direction = 0;direction<4;direction)
        {
for(int count = 0;count<mFeedbackCount;count)
            {
                int delay = count * CHEVRON_INCREMENTAL_DELAY;
                final TargetDrawable icon = mChevronDrawables.get(direction*mFeedbackCount + count);
                if(icon==null)                
                {
                    continue;
                } //End block
mChevronAnimations.add(Tweener.to(icon, CHEVRON_ANIMATION_DURATION, "ease", mChevronAnimationInterpolator, "delay", delay, "x", new float, "y", new float, "alpha", new float, "scaleX", new float, "scaleY", new float, "onUpdate", mUpdateListener))
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.991 -0400", hash_original_method = "E9D92271D84CC612B30D0389733A4838", hash_generated_method = "28B7A5D286E4A26A89536B1F76F19DBC")
    private void stopChevronAnimation() {
for(Tweener anim : mChevronAnimations)
        {
anim.animator.end()
        } //End block
mChevronAnimations.clear()
        // ---------- Original Method ----------
        //for (Tweener anim : mChevronAnimations) {
            //anim.animator.end();
        //}
        //mChevronAnimations.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.992 -0400", hash_original_method = "7D711FD8197822CB7BC4E7AF538AD8F9", hash_generated_method = "1E761CD7F7B8219828A54793735FF8F8")
    private void stopHandleAnimation() {
        if(mHandleAnimation!=null)        
        {
mHandleAnimation.animator.end()mHandleAnimation=null
        } //End block
        // ---------- Original Method ----------
        //if (mHandleAnimation != null) {
            //mHandleAnimation.animator.end();
            //mHandleAnimation = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.992 -0400", hash_original_method = "479E12436BCB7B3605A02A6CBB3B9C0C", hash_generated_method = "D6E3EE4C840F6E2AB61C52537E75B0EA")
    private void deactivateTargets() {
for(TargetDrawable target : mTargetDrawables)
        {
target.setState(TargetDrawable.STATE_INACTIVE)
        } //End block
mActiveTarget=-1
        // ---------- Original Method ----------
        //for (TargetDrawable target : mTargetDrawables) {
            //target.setState(TargetDrawable.STATE_INACTIVE);
        //}
        //mActiveTarget = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.993 -0400", hash_original_method = "6FF538BC67A17B4CC5AA8D9301094EBA", hash_generated_method = "58630D41F4368F215D11985A0430461E")
     void invalidateGlobalRegion(TargetDrawable drawable) {
        addTaint(drawable.getTaint());
        int width = drawable.getWidth();
        int height = drawable.getHeight();
        RectF childBounds = new RectF(0, 0, width, height);
childBounds.offset(drawable.getX()-width/2, drawable.getY()-height/2)        View view = this;
        while
(view.getParent()!=null&&view.getParent() instanceof View)        
        {
view=(View) view.getParent()view.getMatrix().mapRect(childBounds)view.invalidate((int) Math.floor(childBounds.left), (int) Math.floor(childBounds.top), (int) Math.ceil(childBounds.right), (int) Math.ceil(childBounds.bottom))
        } //End block
        // ---------- Original Method ----------
        //int width = drawable.getWidth();
        //int height = drawable.getHeight();
        //RectF childBounds = new RectF(0, 0, width, height);
        //childBounds.offset(drawable.getX() - width/2, drawable.getY() - height/2);
        //View view = this;
        //while (view.getParent() != null && view.getParent() instanceof View) {
            //view = (View) view.getParent();
            //view.getMatrix().mapRect(childBounds);
            //view.invalidate((int) Math.floor(childBounds.left),
                    //(int) Math.floor(childBounds.top),
                    //(int) Math.ceil(childBounds.right),
                    //(int) Math.ceil(childBounds.bottom));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.993 -0400", hash_original_method = "EF6BBB1669A3664E481CB5C234516A98", hash_generated_method = "C0475A29C151927C46A3377ADD7AE76F")
    private void dispatchTriggerEvent(int whichHandle) {
        addTaint(whichHandle);
vibrate()        if(mOnTriggerListener!=null)        
        {
mOnTriggerListener.onTrigger(this, whichHandle)
        } //End block
        // ---------- Original Method ----------
        //vibrate();
        //if (mOnTriggerListener != null) {
            //mOnTriggerListener.onTrigger(this, whichHandle);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.994 -0400", hash_original_method = "F756E39AB2D3A9EADC0F8BFA375F2D16", hash_generated_method = "13D6FDFEB0FA891E66A74199D5F6D8D3")
    private void dispatchGrabbedEvent(int whichHandler) {
        addTaint(whichHandler);
vibrate()        if(mOnTriggerListener!=null)        
        {
mOnTriggerListener.onGrabbed(this, whichHandler)
        } //End block
        // ---------- Original Method ----------
        //vibrate();
        //if (mOnTriggerListener != null) {
            //mOnTriggerListener.onGrabbed(this, whichHandler);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.995 -0400", hash_original_method = "212E5C313A97DDC67173E958C9D8B63A", hash_generated_method = "09A190786610D1A0978410F186ABDB0D")
    private void doFinish() {
        final int activeTarget = mActiveTarget;
        boolean targetHit = activeTarget != -1;
hideTargets(true)mHandleDrawable.setAlpha(targetHit?0.0f:0.0f)        if(targetHit)        
        {
mTargetDrawables.get(activeTarget).setState(TargetDrawable.STATE_ACTIVE)hideUnselected(activeTarget)            if(DEBUG){ }dispatchTriggerEvent(mActiveTarget)mHandleAnimation=Tweener.to(mHandleDrawable, 0, "ease", Ease.Quart.easeOut, "delay", RETURN_TO_HOME_DELAY, "alpha", 1.0f, "x", mWaveCenterX, "y", mWaveCenterY, "onUpdate", mUpdateListener, "onComplete", mResetListener)
        } //End block
        else
        {
mHandleAnimation=Tweener.to(mHandleDrawable, RETURN_TO_HOME_DURATION, "ease", Ease.Quart.easeOut, "delay", 0, "alpha", 1.0f, "x", mWaveCenterX, "y", mWaveCenterY, "onUpdate", mUpdateListener, "onComplete", mDragging?mResetListenerWithPing:mResetListenerWithPing)
        } //End block
setGrabbedState(OnTriggerListener.NO_HANDLE)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.995 -0400", hash_original_method = "4CD3B527088572D7C846DF7FEEBD5AEA", hash_generated_method = "B70434A357661991403620DE7692468D")
    private void hideUnselected(int active) {
        addTaint(active);
for(int i = 0;i<mTargetDrawables.size();i)
        {
            if(i!=active)            
            {
mTargetDrawables.get(i).setAlpha(0.0f)
            } //End block
        } //End block
mOuterRing.setAlpha(0.0f)
        // ---------- Original Method ----------
        //for (int i = 0; i < mTargetDrawables.size(); i++) {
            //if (i != active) {
                //mTargetDrawables.get(i).setAlpha(0.0f);
            //}
        //}
        //mOuterRing.setAlpha(0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.996 -0400", hash_original_method = "42BB6DBC70AA39C9CA1A0FBD37C8C73D", hash_generated_method = "8E7071D2786FD155E619BEF383B4AC9D")
    private void hideTargets(boolean animate) {
        addTaint(animate);
        if(mTargetAnimations.size()>0)        
        {
stopTargetAnimation()
        } //End block
mAnimatingTargets=animate        if(animate)        
        {
            final int duration = animate ? HIDE_ANIMATION_DURATION : 0;
for(TargetDrawable target : mTargetDrawables)
            {
target.setState(TargetDrawable.STATE_INACTIVE)mTargetAnimations.add(Tweener.to(target, duration, "alpha", 0.0f, "delay", HIDE_ANIMATION_DELAY, "onUpdate", mUpdateListener))
            } //End block
mTargetAnimations.add(Tweener.to(mOuterRing, duration, "alpha", 0.0f, "delay", HIDE_ANIMATION_DELAY, "onUpdate", mUpdateListener, "onComplete", mTargetUpdateListener))
        } //End block
        else
        {
for(TargetDrawable target : mTargetDrawables)
            {
target.setState(TargetDrawable.STATE_INACTIVE)target.setAlpha(0.0f)
            } //End block
mOuterRing.setAlpha(0.0f)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.997 -0400", hash_original_method = "0467448312C67795DC15B44C8D6EC17E", hash_generated_method = "DEBFA5A38015FA35075CF69CF9E6A40C")
    private void showTargets(boolean animate) {
        addTaint(animate);
        if(mTargetAnimations.size()>0)        
        {
stopTargetAnimation()
        } //End block
mAnimatingTargets=animate        if(animate)        
        {
for(TargetDrawable target : mTargetDrawables)
            {
target.setState(TargetDrawable.STATE_INACTIVE)mTargetAnimations.add(Tweener.to(target, SHOW_ANIMATION_DURATION, "alpha", 1.0f, "delay", SHOW_ANIMATION_DELAY, "onUpdate", mUpdateListener))
            } //End block
mTargetAnimations.add(Tweener.to(mOuterRing, SHOW_ANIMATION_DURATION, "alpha", 1.0f, "delay", SHOW_ANIMATION_DELAY, "onUpdate", mUpdateListener, "onComplete", mTargetUpdateListener))
        } //End block
        else
        {
for(TargetDrawable target : mTargetDrawables)
            {
target.setState(TargetDrawable.STATE_INACTIVE)target.setAlpha(1.0f)
            } //End block
mOuterRing.setAlpha(1.0f)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.998 -0400", hash_original_method = "0EB5E3EF1854CA58C2DD24CC7F3B9937", hash_generated_method = "DF987FFB462286A0E5908E4AF864E530")
    private void stopTargetAnimation() {
for(Tweener anim : mTargetAnimations)
        {
anim.animator.end()
        } //End block
mTargetAnimations.clear()
        // ---------- Original Method ----------
        //for (Tweener anim : mTargetAnimations) {
            //anim.animator.end();
        //}
        //mTargetAnimations.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.999 -0400", hash_original_method = "CEF6C52D658CEE87AFFD6FADC4CE8BDC", hash_generated_method = "AFB2D36FC2245BF3C9C9198BBF1480A2")
    private void vibrate() {
        if(mVibrator!=null)        
        {
mVibrator.vibrate(mVibrationDuration)
        } //End block
        // ---------- Original Method ----------
        //if (mVibrator != null) {
            //mVibrator.vibrate(mVibrationDuration);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.000 -0400", hash_original_method = "3080F8B690D28B031500E7653EEB305F", hash_generated_method = "A9E7D4593696D112324426D7B054C053")
    private void internalSetTargetResources(int resourceId) {
        addTaint(resourceId);
        Resources res = getContext().getResources();
        TypedArray array = res.obtainTypedArray(resourceId);
        int count = array.length();
        ArrayList<TargetDrawable> targetDrawables = new ArrayList<TargetDrawable>(count);
for(int i = 0;i<count;i)
        {
            Drawable drawable = array.getDrawable(i);
targetDrawables.add(new TargetDrawable(res, drawable))
        } //End block
array.recycle()mTargetResourceId=resourceIdmTargetDrawables=targetDrawablesupdateTargetPositions()
        // ---------- Original Method ----------
        //Resources res = getContext().getResources();
        //TypedArray array = res.obtainTypedArray(resourceId);
        //int count = array.length();
        //ArrayList<TargetDrawable> targetDrawables = new ArrayList<TargetDrawable>(count);
        //for (int i = 0; i < count; i++) {
            //Drawable drawable = array.getDrawable(i);
            //targetDrawables.add(new TargetDrawable(res, drawable));
        //}
        //array.recycle();
        //mTargetResourceId = resourceId;
        //mTargetDrawables = targetDrawables;
        //updateTargetPositions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.000 -0400", hash_original_method = "F7D270A5BB63675F8D3BBD06E0D4BCEB", hash_generated_method = "6A2E2C7BA764E9E78D043B12B2C29164")
    public void setTargetResources(int resourceId) {
        addTaint(resourceId);
        if(mAnimatingTargets)        
        {
mNewTargetResources=resourceId
        } //End block
        else
        {
internalSetTargetResources(resourceId)
        } //End block
        // ---------- Original Method ----------
        //if (mAnimatingTargets) {
            //mNewTargetResources = resourceId;
        //} else {
            //internalSetTargetResources(resourceId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.001 -0400", hash_original_method = "7B679F7F5FAEAD152E62C4710FAFF876", hash_generated_method = "458F3DDB5823E1A26B64E98A8B482F3F")
    public int getTargetResourceId() {
        int var84DA9E2FDBCBF88ADE08E8771214F9D8_73673776 = (mTargetResourceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900517554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900517554;
        // ---------- Original Method ----------
        //return mTargetResourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.002 -0400", hash_original_method = "831CD65D010886921946F9B92CD46DE4", hash_generated_method = "27FC8266BF364A1E2F1A1017B3955513")
    public void setTargetDescriptionsResourceId(int resourceId) {
        addTaint(resourceId);
mTargetDescriptionsResourceId=resourceId        if(mTargetDescriptions!=null)        
        {
mTargetDescriptions.clear()
        } //End block
        // ---------- Original Method ----------
        //mTargetDescriptionsResourceId = resourceId;
        //if (mTargetDescriptions != null) {
            //mTargetDescriptions.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.002 -0400", hash_original_method = "6B6FB4886B392E8BC9DF0B0D53BC8C01", hash_generated_method = "EB8CAACDB11B67D04BFDFF2B5455EF00")
    public int getTargetDescriptionsResourceId() {
        int var7A1F913515DF8A1B58FD27A3940B38C8_708200694 = (mTargetDescriptionsResourceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502370814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502370814;
        // ---------- Original Method ----------
        //return mTargetDescriptionsResourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.003 -0400", hash_original_method = "AFD389852D9CF0E12A1ED10511C0DC19", hash_generated_method = "1A9137998BF87413E86CC304ACC19D97")
    public void setDirectionDescriptionsResourceId(int resourceId) {
        addTaint(resourceId);
mDirectionDescriptionsResourceId=resourceId        if(mDirectionDescriptions!=null)        
        {
mDirectionDescriptions.clear()
        } //End block
        // ---------- Original Method ----------
        //mDirectionDescriptionsResourceId = resourceId;
        //if (mDirectionDescriptions != null) {
            //mDirectionDescriptions.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.003 -0400", hash_original_method = "22EF62F9755FE061458FFB111570FE0A", hash_generated_method = "37F10914AE20354253C64952E8AA6C5A")
    public int getDirectionDescriptionsResourceId() {
        int varDEB61A5BFE30F92CA0323070B81BD023_906774353 = (mDirectionDescriptionsResourceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399478590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399478590;
        // ---------- Original Method ----------
        //return mDirectionDescriptionsResourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.004 -0400", hash_original_method = "54763BA6D37544C435422E0F0F41C164", hash_generated_method = "0B716D2F9655EB23471ACF58CB7DDD0E")
    public void setVibrateEnabled(boolean enabled) {
        addTaint(enabled);
        if(enabled&&mVibrator==null)        
        {
mVibrator=(Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE)
        } //End block
        else
        {
mVibrator=null
        } //End block
        // ---------- Original Method ----------
        //if (enabled && mVibrator == null) {
            //mVibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        //} else {
            //mVibrator = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.004 -0400", hash_original_method = "A9436BEFB39B9C3607948C24A6628847", hash_generated_method = "73E0EBCB8110071278DBE23C85A8F01A")
    public void ping() {
stopChevronAnimation()startChevronAnimation()
        // ---------- Original Method ----------
        //stopChevronAnimation();
        //startChevronAnimation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.005 -0400", hash_original_method = "4380B0209E599E70AE09D0E5D1979378", hash_generated_method = "C0CF04567BE368FABC5C851EAB5F4C8F")
    public void reset(boolean animate) {
        addTaint(animate);
stopChevronAnimation()stopHandleAnimation()stopTargetAnimation()hideChevrons()hideTargets(animate)mHandleDrawable.setX(mWaveCenterX)mHandleDrawable.setY(mWaveCenterY)mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE)Tweener.reset()
        // ---------- Original Method ----------
        //stopChevronAnimation();
        //stopHandleAnimation();
        //stopTargetAnimation();
        //hideChevrons();
        //hideTargets(animate);
        //mHandleDrawable.setX(mWaveCenterX);
        //mHandleDrawable.setY(mWaveCenterY);
        //mHandleDrawable.setState(TargetDrawable.STATE_INACTIVE);
        //Tweener.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.005 -0400", hash_original_method = "B575AA4FE844B1446C78EC75E092BCF3", hash_generated_method = "CF76D543987E2A3174CEFC36E462BF32")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        final int action = event.getAction();
        boolean handled = false;
        switch(action){
        case MotionEvent.ACTION_DOWN:
handleDown(event)handled=true        break;
        case MotionEvent.ACTION_MOVE:
handleMove(event)handled=true        break;
        case MotionEvent.ACTION_UP:
handleMove(event)handleUp(event)handled=true        break;
        case MotionEvent.ACTION_CANCEL:
handleMove(event)handled=true        break;
}invalidate()        boolean var24298A14C64C4464799307444B35521B_1841819181 = (handled?true:true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979412197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_979412197;
        // ---------- Original Method ----------
        //final int action = event.getAction();
        //boolean handled = false;
        //switch (action) {
            //case MotionEvent.ACTION_DOWN:
                //handleDown(event);
                //handled = true;
                //break;
            //case MotionEvent.ACTION_MOVE:
                //handleMove(event);
                //handled = true;
                //break;
            //case MotionEvent.ACTION_UP:
                //handleMove(event);
                //handleUp(event);
                //handled = true;
                //break;
            //case MotionEvent.ACTION_CANCEL:
                //handleMove(event);
                //handled = true;
                //break;
        //}
        //invalidate();
        //return handled ? true : super.onTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.006 -0400", hash_original_method = "C5060525E528DE70BB65DF4E48061532", hash_generated_method = "54E13AE05DA0571E89B784CAD1AE840A")
    private void moveHandleTo(float x, float y, boolean animate) {
        addTaint(animate);
        addTaint(y);
        addTaint(x);
mHandleDrawable.setX(x)mHandleDrawable.setY(y)
        // ---------- Original Method ----------
        //mHandleDrawable.setX(x);
        //mHandleDrawable.setY(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.006 -0400", hash_original_method = "75457195CF6B10D494B06E045EA809FB", hash_generated_method = "8D2A16D9A1980504D5CCC8A5C36A134B")
    private void handleDown(MotionEvent event) {
        addTaint(event.getTaint());
        if(!trySwitchToFirstTouchState(event))        
        {
mDragging=falsestopTargetAnimation()ping()
        } //End block
        // ---------- Original Method ----------
        //if (!trySwitchToFirstTouchState(event)) {
            //mDragging = false;
            //stopTargetAnimation();
            //ping();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.006 -0400", hash_original_method = "06BAB2D81E4CB1A67D3ABC75A09098E5", hash_generated_method = "09E27306B8BCDDC3F0C808228B4C6731")
    private void handleUp(MotionEvent event) {
        addTaint(event.getTaint());
        if(DEBUG&&mDragging){ }switchToState(STATE_FINISH, event.getX(), event.getY())
        // ---------- Original Method ----------
        //if (DEBUG && mDragging) Log.v(TAG, "** Handle RELEASE");
        //switchToState(STATE_FINISH, event.getX(), event.getY());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.008 -0400", hash_original_method = "2B24357570ECEB4BD3FFD5404F643324", hash_generated_method = "DEBA2320A71A6431E5BA9011DD97A113")
    private void handleMove(MotionEvent event) {
        addTaint(event.getTaint());
        if(!mDragging)        
        {
trySwitchToFirstTouchState(event)            return;
        } //End block
        int activeTarget = -1;
        final int historySize = event.getHistorySize();
for(int k = 0;k<historySize+1;k)
        {
            float x = k < historySize ? event.getHistoricalX(k) : event.getX();
            float y = k < historySize ? event.getHistoricalY(k) : event.getY();
            float tx = x - mWaveCenterX;
            float ty = y - mWaveCenterY;
            float touchRadius = (float) Math.sqrt(dist2(tx, ty));
            final float scale = touchRadius > mOuterRadius ? mOuterRadius / touchRadius : 1.0f;
            float limitX = mWaveCenterX + tx * scale;
            float limitY = mWaveCenterY + ty * scale;
            boolean singleTarget = mTargetDrawables.size() == 1;
            if(singleTarget)            
            {
                float snapRadius = mOuterRadius - mSnapMargin;
                if(touchRadius>snapRadius)                
                {
activeTarget=0x=limitXy=limitY
                } //End block
            } //End block
            else
            {
                float best = Float.MAX_VALUE;
                final float hitRadius2 = mHitRadius * mHitRadius;
for(int i = 0;i<mTargetDrawables.size();i)
                {
                    TargetDrawable target = mTargetDrawables.get(i);
                    float dx = limitX - target.getX();
                    float dy = limitY - target.getY();
                    float dist2 = dx*dx + dy*dy;
                    if(target.isValid()&&dist2<hitRadius2&&dist2<best)                    
                    {
activeTarget=ibest=dist2
                    } //End block
                } //End block
x=limitXy=limitY
            } //End block
            if(activeTarget!=-1)            
            {
switchToState(STATE_SNAP, x, y)                float newX = singleTarget ? limitX : mTargetDrawables.get(activeTarget).getX();
                float newY = singleTarget ? limitY : mTargetDrawables.get(activeTarget).getY();
moveHandleTo(newX, newY, false)                TargetDrawable currentTarget = mTargetDrawables.get(activeTarget);
                if(currentTarget.hasState(TargetDrawable.STATE_FOCUSED))                
                {
currentTarget.setState(TargetDrawable.STATE_FOCUSED)mHandleDrawable.setAlpha(0.0f)
                } //End block
            } //End block
            else
            {
switchToState(STATE_TRACKING, x, y)moveHandleTo(x, y, false)mHandleDrawable.setAlpha(1.0f)
            } //End block
        } //End block
invalidateGlobalRegion(mHandleDrawable)        if(mActiveTarget!=activeTarget&&activeTarget!=-1)        
        {
dispatchGrabbedEvent(activeTarget)            if(AccessibilityManager.getInstance(mContext).isEnabled())            
            {
                String targetContentDescription = getTargetDescription(activeTarget);
announceText(targetContentDescription)
            } //End block
        } //End block
mActiveTarget=activeTarget
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.010 -0400", hash_original_method = "FF4AE971A2EAE39E843DF1D56F5160FE", hash_generated_method = "1E694F3B8D0A5163CF0946B70D726A51")
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
        boolean var529D2E3159AA18EC09D8755785EF01BB_795703923 = (super.onHoverEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2087415028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2087415028;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.011 -0400", hash_original_method = "53298DD5AACE62E95D303B1BDF9E0483", hash_generated_method = "CFD2D88CDFF2DB76505F6D077901C0CF")
    private void setGrabbedState(int newState) {
        addTaint(newState);
        if(newState!=mGrabbedState)        
        {
            if(newState!=OnTriggerListener.NO_HANDLE)            
            {
vibrate()
            } //End block
mGrabbedState=newState            if(mOnTriggerListener!=null)            
            {
mOnTriggerListener.onGrabbedStateChange(this, mGrabbedState)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (newState != mGrabbedState) {
            //if (newState != OnTriggerListener.NO_HANDLE) {
                //vibrate();
            //}
            //mGrabbedState = newState;
            //if (mOnTriggerListener != null) {
                //mOnTriggerListener.onGrabbedStateChange(this, mGrabbedState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.012 -0400", hash_original_method = "CE095C44EA1042A5C041FE88D08212C6", hash_generated_method = "8E8F7B6C68444FDB07C8F6F5C3D527E8")
    private boolean trySwitchToFirstTouchState(MotionEvent event) {
        addTaint(event.getTaint());
        final float x = event.getX();
        final float y = event.getY();
        final float dx = x - mWaveCenterX;
        final float dy = y - mWaveCenterY;
        if(dist2(dx, dy)<=getScaledTapRadiusSquared())        
        {
            if(DEBUG){ }switchToState(STATE_FIRST_TOUCH, x, y)moveHandleTo(x, y, false)mDragging=true            boolean varB326B5062B2F0E69046810717534CB09_1419405878 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_24541540 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_24541540;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2013664091 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951403231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951403231;
        // ---------- Original Method ----------
        //final float x = event.getX();
        //final float y = event.getY();
        //final float dx = x - mWaveCenterX;
        //final float dy = y - mWaveCenterY;
        //if (dist2(dx,dy) <= getScaledTapRadiusSquared()) {
            //if (DEBUG) Log.v(TAG, "** Handle HIT");
            //switchToState(STATE_FIRST_TOUCH, x, y);
            //moveHandleTo(x, y, false);
            //mDragging = true;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.012 -0400", hash_original_method = "3BE5937572517C83B4E2116CC8F12759", hash_generated_method = "350357532EEF1EEA089E3B99BF4E2191")
    private void performInitialLayout(float centerX, float centerY) {
        addTaint(centerY);
        addTaint(centerX);
        if(mOuterRadius==0.0f)        
        {
mOuterRadius=0.5f*(float) Math.sqrt(dist2(centerX, centerY))
        } //End block
        if(mHitRadius==0.0f)        
        {
mHitRadius=mTargetDrawables.get(0).getWidth()/2.0f
        } //End block
        if(mSnapMargin==0.0f)        
        {
mSnapMargin=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, SNAP_MARGIN_DEFAULT, getContext().getResources().getDisplayMetrics())
        } //End block
hideChevrons()hideTargets(false)moveHandleTo(centerX, centerY, false)
        // ---------- Original Method ----------
        //if (mOuterRadius == 0.0f) {
            //mOuterRadius = 0.5f*(float) Math.sqrt(dist2(centerX, centerY));
        //}
        //if (mHitRadius == 0.0f) {
            //mHitRadius = mTargetDrawables.get(0).getWidth() / 2.0f;
        //}
        //if (mSnapMargin == 0.0f) {
            //mSnapMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    //SNAP_MARGIN_DEFAULT, getContext().getResources().getDisplayMetrics());
        //}
        //hideChevrons();
        //hideTargets(false);
        //moveHandleTo(centerX, centerY, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.013 -0400", hash_original_method = "FFD5D385039DB60FB5E4E4FE004F9D7E", hash_generated_method = "D3B16DF3722758B0932FF547FD4C9CFD")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
super.onLayout(changed, left, top, right, bottom)        final int width = right - left;
        final int height = bottom - top;
        float newWaveCenterX = mHorizontalOffset + Math.max(width, mOuterRing.getWidth() ) / 2;
        float newWaveCenterY = mVerticalOffset + Math.max(height, mOuterRing.getHeight()) / 2;
        if(newWaveCenterX!=mWaveCenterX||newWaveCenterY!=mWaveCenterY)        
        {
            if(mWaveCenterX==0&&mWaveCenterY==0)            
            {
performInitialLayout(newWaveCenterX, newWaveCenterY)
            } //End block
mWaveCenterX=newWaveCenterXmWaveCenterY=newWaveCenterYmOuterRing.setX(mWaveCenterX)mOuterRing.setY(Math.max(mWaveCenterY, mWaveCenterY))updateTargetPositions()
        } //End block
        if(DEBUG)        
dump()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.013 -0400", hash_original_method = "5C1EEC34A7A8FDB5B264D91A351C1363", hash_generated_method = "FC2ECEAE2173462FAA62D1742167D619")
    private void updateTargetPositions() {
for(int i = 0;i<mTargetDrawables.size();i)
        {
            final TargetDrawable targetIcon = mTargetDrawables.get(i);
            double angle = -2.0f * Math.PI * i / mTargetDrawables.size();
            float xPosition = mWaveCenterX + mOuterRadius * (float) Math.cos(angle);
            float yPosition = mWaveCenterY + mOuterRadius * (float) Math.sin(angle);
targetIcon.setX(xPosition)targetIcon.setY(yPosition)
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < mTargetDrawables.size(); i++) {
            //final TargetDrawable targetIcon = mTargetDrawables.get(i);
            //double angle = -2.0f * Math.PI * i / mTargetDrawables.size();
            //float xPosition = mWaveCenterX + mOuterRadius * (float) Math.cos(angle);
            //float yPosition = mWaveCenterY + mOuterRadius * (float) Math.sin(angle);
            //targetIcon.setX(xPosition);
            //targetIcon.setY(yPosition);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.014 -0400", hash_original_method = "606D0725810036E294B63C5DECB5EDB6", hash_generated_method = "7908EC9085D39AE9D8CD9E664DDFE22B")
    private void hideChevrons() {
for(TargetDrawable chevron : mChevronDrawables)
        {
            if(chevron!=null)            
            {
chevron.setAlpha(0.0f)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (TargetDrawable chevron : mChevronDrawables) {
            //if (chevron != null) {
                //chevron.setAlpha(0.0f);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.014 -0400", hash_original_method = "5292F32DD879C4ED0A93FB6CEFD8207B", hash_generated_method = "4627B83DDD6ECE54EC83F88498EF0DE1")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
mOuterRing.draw(canvas)for(TargetDrawable target : mTargetDrawables)
        {
            if(target!=null)            
            {
target.draw(canvas)
            } //End block
        } //End block
for(TargetDrawable target : mChevronDrawables)
        {
            if(target!=null)            
            {
target.draw(canvas)
            } //End block
        } //End block
mHandleDrawable.draw(canvas)
        // ---------- Original Method ----------
        //mOuterRing.draw(canvas);
        //for (TargetDrawable target : mTargetDrawables) {
            //if (target != null) {
                //target.draw(canvas);
            //}
        //}
        //for (TargetDrawable target : mChevronDrawables) {
            //if (target != null) {
                //target.draw(canvas);
            //}
        //}
        //mHandleDrawable.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.015 -0400", hash_original_method = "55E97AC0CD8F0BA7A04BDE23F0852D07", hash_generated_method = "47476DEC32908605480C68DFE2ACFFF8")
    public void setOnTriggerListener(OnTriggerListener listener) {
        addTaint(listener.getTaint());
mOnTriggerListener=listener
        // ---------- Original Method ----------
        //mOnTriggerListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.015 -0400", hash_original_method = "9B5D2B04F06AA8C25B441EB2FF629ABC", hash_generated_method = "E88B4A0F8C208CC10D66834CBD1C72F6")
    private float square(float d) {
        addTaint(d);
        float varA4BD906EE23757091273A971ABDE4667_1823331008 = (d*d);
                float var546ADE640B6EDFBC8A086EF31347E768_1011361183 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1011361183;
        // ---------- Original Method ----------
        //return d * d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.016 -0400", hash_original_method = "947C5679ED9CF8C5B7CE09815DE2B436", hash_generated_method = "7E23585166763AA4DC1D966543EA5682")
    private float dist2(float dx, float dy) {
        addTaint(dy);
        addTaint(dx);
        float varA71E1CF3E2EE0A5FEE8FEA9734FA7116_1751380905 = (dx*dx+dy*dy);
                float var546ADE640B6EDFBC8A086EF31347E768_348299814 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_348299814;
        // ---------- Original Method ----------
        //return dx*dx + dy*dy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.017 -0400", hash_original_method = "45BF1DE73B045AFCB17B8E3B23E84F48", hash_generated_method = "2A6CD14DD032BCC4D160E99A7EC5AED7")
    private float getScaledTapRadiusSquared() {
        float scaledTapRadius;
        if(AccessibilityManager.getInstance(mContext).isEnabled())        
        {
scaledTapRadius=TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED*mTapRadius
        } //End block
        else
        {
scaledTapRadius=mTapRadius
        } //End block
        float var4BD8CA25116549EF1A86D033D1318CED_1976658153 = (square(scaledTapRadius));
                float var546ADE640B6EDFBC8A086EF31347E768_2063330017 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2063330017;
        // ---------- Original Method ----------
        //final float scaledTapRadius;
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //scaledTapRadius = TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED * mTapRadius;
        //} else {
            //scaledTapRadius = mTapRadius;
        //}
        //return square(scaledTapRadius);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.017 -0400", hash_original_method = "0DEF5CA89BD6A7FAC3B32708CBA4E35A", hash_generated_method = "CE64C6621416D3935BFCE398FB2FCCFA")
    private void announceTargets() {
        StringBuilder utterance = new StringBuilder();
        final int targetCount = mTargetDrawables.size();
for(int i = 0;i<targetCount;i)
        {
            String targetDescription = getTargetDescription(i);
            String directionDescription = getDirectionDescription(i);
            if(!TextUtils.isEmpty(targetDescription)&&!TextUtils.isEmpty(directionDescription))            
            {
                String text = String.format(directionDescription, targetDescription);
utterance.append(text)
            } //End block
            if(utterance.length()>0)            
            {
announceText(utterance.toString())
            } //End block
        } //End block
        // ---------- Original Method ----------
        //StringBuilder utterance = new StringBuilder();
        //final int targetCount = mTargetDrawables.size();
        //for (int i = 0; i < targetCount; i++) {
            //String targetDescription = getTargetDescription(i);
            //String directionDescription = getDirectionDescription(i);
            //if (!TextUtils.isEmpty(targetDescription)
                    //&& !TextUtils.isEmpty(directionDescription)) {
                //String text = String.format(directionDescription, targetDescription);
                //utterance.append(text);
            //}
            //if (utterance.length() > 0) {
                //announceText(utterance.toString());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.018 -0400", hash_original_method = "2A9A5C2A17E0D068EC89D4D88947C61F", hash_generated_method = "A94B7E8EC6631005472E1FCB4E2903F2")
    private void announceText(String text) {
        addTaint(text.getTaint());
setContentDescription(text)sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)setContentDescription(null)
        // ---------- Original Method ----------
        //setContentDescription(text);
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        //setContentDescription(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.018 -0400", hash_original_method = "ECF0A1ED799E849C3AC2DE94DA500128", hash_generated_method = "2C9ECE22ABFFFF80A4A514B4BA718DEF")
    private String getTargetDescription(int index) {
        addTaint(index);
        if(mTargetDescriptions==null||mTargetDescriptions.isEmpty())        
        {
mTargetDescriptions=loadDescriptions(mTargetDescriptionsResourceId)            if(mTargetDrawables.size()!=mTargetDescriptions.size())            
            {
String var540C13E9E156B687226421B24F2DF178_471553246 = null                var540C13E9E156B687226421B24F2DF178_471553246.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_471553246;
            } //End block
        } //End block
String var1DFF661BCA8C1A4AB02B50BDFA91BC08_1516234113 = mTargetDescriptions.get(index)        var1DFF661BCA8C1A4AB02B50BDFA91BC08_1516234113.addTaint(taint);
        return var1DFF661BCA8C1A4AB02B50BDFA91BC08_1516234113;
        // ---------- Original Method ----------
        //if (mTargetDescriptions == null || mTargetDescriptions.isEmpty()) {
            //mTargetDescriptions = loadDescriptions(mTargetDescriptionsResourceId);
            //if (mTargetDrawables.size() != mTargetDescriptions.size()) {
                //Log.w(TAG, "The number of target drawables must be"
                        //+ " euqal to the number of target descriptions.");
                //return null;
            //}
        //}
        //return mTargetDescriptions.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.019 -0400", hash_original_method = "BF12F6377909E5D56A625E9CB035A8F0", hash_generated_method = "6B0EFC1FCB6D3DD4A8D2049B0DBF59EC")
    private String getDirectionDescription(int index) {
        addTaint(index);
        if(mDirectionDescriptions==null||mDirectionDescriptions.isEmpty())        
        {
mDirectionDescriptions=loadDescriptions(mDirectionDescriptionsResourceId)            if(mTargetDrawables.size()!=mDirectionDescriptions.size())            
            {
String var540C13E9E156B687226421B24F2DF178_598764235 = null                var540C13E9E156B687226421B24F2DF178_598764235.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_598764235;
            } //End block
        } //End block
String var3E7473965464507FC3C6F44DDCEDDD27_684582464 = mDirectionDescriptions.get(index)        var3E7473965464507FC3C6F44DDCEDDD27_684582464.addTaint(taint);
        return var3E7473965464507FC3C6F44DDCEDDD27_684582464;
        // ---------- Original Method ----------
        //if (mDirectionDescriptions == null || mDirectionDescriptions.isEmpty()) {
            //mDirectionDescriptions = loadDescriptions(mDirectionDescriptionsResourceId);
            //if (mTargetDrawables.size() != mDirectionDescriptions.size()) {
                //Log.w(TAG, "The number of target drawables must be"
                        //+ " euqal to the number of direction descriptions.");
                //return null;
            //}
        //}
        //return mDirectionDescriptions.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.019 -0400", hash_original_method = "067ABD96EFC0199FC7EF751DA29DBDCD", hash_generated_method = "E8919F8B2DD447A29F0F6160FFD779FA")
    private ArrayList<String> loadDescriptions(int resourceId) {
        addTaint(resourceId);
        TypedArray array = getContext().getResources().obtainTypedArray(resourceId);
        final int count = array.length();
        ArrayList<String> targetContentDescriptions = new ArrayList<String>(count);
for(int i = 0;i<count;i)
        {
            String contentDescription = array.getString(i);
targetContentDescriptions.add(contentDescription)
        } //End block
array.recycle()ArrayList<String> var37370D41CD6E769F19F86277B6569DFF_1589809770 = targetContentDescriptions        var37370D41CD6E769F19F86277B6569DFF_1589809770.addTaint(taint);
        return var37370D41CD6E769F19F86277B6569DFF_1589809770;
        // ---------- Original Method ----------
        //TypedArray array = getContext().getResources().obtainTypedArray(resourceId);
        //final int count = array.length();
        //ArrayList<String> targetContentDescriptions = new ArrayList<String>(count);
        //for (int i = 0; i < count; i++) {
            //String contentDescription = array.getString(i);
            //targetContentDescriptions.add(contentDescription);
        //}
        //array.recycle();
        //return targetContentDescriptions;
    }

    
    public interface OnTriggerListener {
        int NO_HANDLE = 0;
        int CENTER_HANDLE = 1;
        public void onGrabbed(View v, int handle);
        public void onReleased(View v, int handle);
        public void onTrigger(View v, int target);
        public void onGrabbedStateChange(View v, int handle);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.020 -0400", hash_original_field = "3F6433883A9A7BE722A9E2AF8979BC24", hash_generated_field = "BB121B86DE2D4BAFF97B9160C9212B21")

    private static final String TAG = "MultiWaveView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.020 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.020 -0400", hash_original_field = "AEBCB16EA0142CCECDCE720235105004", hash_generated_field = "31A5ECBA709672BB7BAE010B1E1C3954")

    private static final int STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.020 -0400", hash_original_field = "BD6F39A49CD3D8E17F7AEBDFC595F2B6", hash_generated_field = "8C13115FE5334ED3E8186A897E079B71")

    private static final int STATE_FIRST_TOUCH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.020 -0400", hash_original_field = "2A1D8350BE1EAC7172554BE05AAD0713", hash_generated_field = "FB0D71A7D10E60A95AF2043254559F00")

    private static final int STATE_TRACKING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.020 -0400", hash_original_field = "F24CFE7E4F2D2A0E25E23888610E11A6", hash_generated_field = "B030E75C9BC99CBD66C10D0AA4DE10A2")

    private static final int STATE_SNAP = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.020 -0400", hash_original_field = "21C462C47250FB2C6CCDFBA6FED5A06D", hash_generated_field = "B3E7D3A02AD5773C61F05640EEF33241")

    private static final int STATE_FINISH = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "B092D2796C60F39178B2BB4992B32409", hash_generated_field = "652560B6E87BD9DB36A0FDEC6F94887C")

    private static final float SNAP_MARGIN_DEFAULT = 20.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "EE0BC9363BFDBA2AE7770B45B422DE2F", hash_generated_field = "7D060F5813DA05DAF9E896DEA86D53AD")

    private static final int CHEVRON_INCREMENTAL_DELAY = 160;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "AB55B6B4B7B1BCBA17BE36353D15A630", hash_generated_field = "6BF1DD88FEA58084F3F4FB662A0C7202")

    private static final int CHEVRON_ANIMATION_DURATION = 850;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "203F7E52A548C192E3E12B8253203F4E", hash_generated_field = "B77E1A27B57D2BF2E3FA4FA816D68212")

    private static final int RETURN_TO_HOME_DELAY = 1200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "C8822DBCC5F02476BF364087C25B37F4", hash_generated_field = "38FC66F0A7426462694A74FCEC462673")

    private static final int RETURN_TO_HOME_DURATION = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "3EDDE06D6CD6A096A48E6B616ED24EE8", hash_generated_field = "0E9D353620C943EA21E81D8CC57B674A")

    private static final int HIDE_ANIMATION_DELAY = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "21517AD5C7802FDF1A4F1A23079AE530", hash_generated_field = "969AAC9F3E66931735F43A25ACA16137")

    private static final int HIDE_ANIMATION_DURATION = RETURN_TO_HOME_DELAY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "B01ACD30A96D90718B849CDDC5205EA8", hash_generated_field = "ABAA992664D7B8097897143049EEE5D7")

    private static final int SHOW_ANIMATION_DURATION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "58DDC1BD7FF22E1BBC772A9B8300C23B", hash_generated_field = "D600B42756F47EDD1ACE5DC59F48BD91")

    private static final int SHOW_ANIMATION_DELAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.021 -0400", hash_original_field = "E69729844D1789B41EED335F3B770733", hash_generated_field = "682AECA685C9D0CC235F8AC9FE6CF2D7")

    private static final float TAP_RADIUS_SCALE_ACCESSIBILITY_ENABLED = 1.3f;
}

