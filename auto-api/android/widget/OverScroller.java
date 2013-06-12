package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller {
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;
    private final Interpolator mInterpolator;
    private final boolean mFlywheel;
    private static final int DEFAULT_DURATION = 250;
    private static final int SCROLL_MODE = 0;
    private static final int FLING_MODE = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.122 -0400", hash_original_method = "B9802AB7FB2D6944C0543E71DB189BC5", hash_generated_method = "1FEA8498A965DE7EBAEA08225BDAF779")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "F6227ED49D62C3697D2AC005A8942714", hash_generated_method = "C5E82A01DAF8B273AD1535DAD92970CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "8F06EBB42FF76B1717D428E4F6418D97", hash_generated_method = "1859F42D043018A2F87D0FD8F87F6CD3")
    @DSModeled(DSC.SAFE)
    public OverScroller(Context context, Interpolator interpolator, boolean flywheel) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(interpolator.dsTaint);
        dsTaint.addTaint(flywheel);
        mScrollerX = new SplineOverScroller();
        mScrollerY = new SplineOverScroller();
        SplineOverScroller.initFromContext(context);
        mInterpolator = interpolator;
        mFlywheel = flywheel;
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
        //mFlywheel = flywheel;
        //mScrollerX = new SplineOverScroller();
        //mScrollerY = new SplineOverScroller();
        //SplineOverScroller.initFromContext(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "0CF9495AD70A3403C1A28AE06C2DFE6A", hash_generated_method = "548639988929FC6C956162515BA78139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY) {
        this(context, interpolator, true);
        dsTaint.addTaint(bounceCoefficientY);
        dsTaint.addTaint(bounceCoefficientX);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "229999978F856549CB121738FDE882C4", hash_generated_method = "434E4A478B03F5F79BF368E0476F645D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        this(context, interpolator, flywheel);
        dsTaint.addTaint(bounceCoefficientY);
        dsTaint.addTaint(bounceCoefficientX);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(interpolator.dsTaint);
        dsTaint.addTaint(flywheel);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "E258F8966760114615A66C59C43DDBF7", hash_generated_method = "C02C52B6C1C65DD772CEFD120EC3D2EC")
    @DSModeled(DSC.SAFE)
    public final void setFriction(float friction) {
        dsTaint.addTaint(friction);
        mScrollerX.setFriction(friction);
        mScrollerY.setFriction(friction);
        // ---------- Original Method ----------
        //mScrollerX.setFriction(friction);
        //mScrollerY.setFriction(friction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "C0D588953F48F0F49E401C0010BD067A", hash_generated_method = "F9A35B4BCF49529388797136AFA15270")
    @DSModeled(DSC.SAFE)
    public final boolean isFinished() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollerX.mFinished && mScrollerY.mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "530BF62F40D21F1D1C05E22ECA085B25", hash_generated_method = "D2027BCC7CC8D673C5281551D79D907B")
    @DSModeled(DSC.SAFE)
    public final void forceFinished(boolean finished) {
        dsTaint.addTaint(finished);
        mScrollerX.mFinished = mScrollerY.mFinished = finished;
        // ---------- Original Method ----------
        //mScrollerX.mFinished = mScrollerY.mFinished = finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "935C47FB8A3CB470F597BC28E107035C", hash_generated_method = "66E19E5AB0F8E09F3B304CC21235C5BB")
    @DSModeled(DSC.SAFE)
    public final int getCurrX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerX.mCurrentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "4ECEC07425ABC9DEFD7B203A5114566B", hash_generated_method = "AE867B4618FEC2815126D9188557E461")
    @DSModeled(DSC.SAFE)
    public final int getCurrY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerY.mCurrentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "64BF41B2D89FD1AD797ACAED97E05500", hash_generated_method = "60DA23C9FF484566326F9743ADC3F32D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getCurrVelocity() {
        float squaredNorm;
        squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        float varD836AEECDA15973F990993130D0A04EB_277128920 = (FloatMath.sqrt(squaredNorm));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        //squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        //return FloatMath.sqrt(squaredNorm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "99101D94CAA5BDB5F4107BC8C52E5814", hash_generated_method = "41EAAA1F060AF50423BF1C1603DF5F89")
    @DSModeled(DSC.SAFE)
    public final int getStartX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerX.mStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "C3B7BC19CF57D40812EE2941701D8011", hash_generated_method = "F590EA1473A02EBAA85A0E4884B6F725")
    @DSModeled(DSC.SAFE)
    public final int getStartY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerY.mStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "B59ED352B9AEDA78AFFC00B7CFC03926", hash_generated_method = "E13402DD702F615442D42CC0CFBB81F1")
    @DSModeled(DSC.SAFE)
    public final int getFinalX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerX.mFinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "35D86359302D602175EC68518CA83146", hash_generated_method = "8EE455BB79D61A257AD8701562B4AB00")
    @DSModeled(DSC.SAFE)
    public final int getFinalY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerY.mFinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.123 -0400", hash_original_method = "9AE57030D7C8A0E7D6E4B9C3569B7863", hash_generated_method = "197EF4FF922EA6285E50EDDC384A867C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final int getDuration() {
        int var2AE19ED6BFD3EE2A01F12C594E911C5B_152534412 = (Math.max(mScrollerX.mDuration, mScrollerY.mDuration));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(mScrollerX.mDuration, mScrollerY.mDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "C8E559EF6FD22D868574182D9D2BCAF9", hash_generated_method = "46539A79814B82D59C06E0EB1A723C4F")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void extendDuration(int extend) {
        dsTaint.addTaint(extend);
        mScrollerX.extendDuration(extend);
        mScrollerY.extendDuration(extend);
        // ---------- Original Method ----------
        //mScrollerX.extendDuration(extend);
        //mScrollerY.extendDuration(extend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "21D9AD21BF731806972ABE02338AD0C0", hash_generated_method = "A1A7173516655A2DE23B3775A1245BB8")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setFinalX(int newX) {
        dsTaint.addTaint(newX);
        mScrollerX.setFinalPosition(newX);
        // ---------- Original Method ----------
        //mScrollerX.setFinalPosition(newX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "300115417BC2D028444CA0676224C129", hash_generated_method = "63EB57F7CCF22415466A5BD2C5FD1B6B")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setFinalY(int newY) {
        dsTaint.addTaint(newY);
        mScrollerY.setFinalPosition(newY);
        // ---------- Original Method ----------
        //mScrollerY.setFinalPosition(newY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "4391FF82C7FA76BDB2CDCD1D85612F8D", hash_generated_method = "90C1E848922755DE1D6793EE1425DE7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean computeScrollOffset() {
        {
            boolean var802B4329042ED423187FD338A790F5A6_1853936873 = (isFinished());
        } //End collapsed parenthetic
        //Begin case SCROLL_MODE 
        long time;
        time = AnimationUtils.currentAnimationTimeMillis();
        //End case SCROLL_MODE 
        //Begin case SCROLL_MODE 
        final long elapsedTime;
        elapsedTime = time - mScrollerX.mStartTime;
        //End case SCROLL_MODE 
        //Begin case SCROLL_MODE 
        final int duration;
        duration = mScrollerX.mDuration;
        //End case SCROLL_MODE 
        //Begin case SCROLL_MODE 
        {
            float q;
            q = (float) (elapsedTime) / duration;
            {
                q = Scroller.viscousFluid(q);
            } //End block
            {
                q = mInterpolator.getInterpolation(q);
            } //End block
            mScrollerX.updateScroll(q);
            mScrollerY.updateScroll(q);
        } //End block
        {
            abortAnimation();
        } //End block
        //End case SCROLL_MODE 
        //Begin case FLING_MODE 
        {
            {
                boolean varBFDC0FB1B43EB7BCC4E9E82DEDCD9FC2_843423032 = (!mScrollerX.update());
                {
                    {
                        boolean varC9F451BE971CCB0A82BBE1EBE98D8511_78230799 = (!mScrollerX.continueWhenFinished());
                        {
                            mScrollerX.finish();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case FLING_MODE 
        //Begin case FLING_MODE 
        {
            {
                boolean var139B509336DC22E8B49FCE36B537A826_412832390 = (!mScrollerY.update());
                {
                    {
                        boolean var4B1E7AEBADA7A1365CA571D290BAD045_1108225850 = (!mScrollerY.continueWhenFinished());
                        {
                            mScrollerY.finish();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case FLING_MODE 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "4FEB147BEF48913BD11605DE9EF0E82A")
    @DSModeled(DSC.SAFE)
    public void startScroll(int startX, int startY, int dx, int dy) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        // ---------- Original Method ----------
        //startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "C7C9FE1639F9BA6211C746BC2E590EF8", hash_generated_method = "F9C5E172BD9E6ADF1315969BA67AEA05")
    @DSModeled(DSC.SAFE)
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(duration);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        mMode = SCROLL_MODE;
        mScrollerX.startScroll(startX, dx, duration);
        mScrollerY.startScroll(startY, dy, duration);
        // ---------- Original Method ----------
        //mMode = SCROLL_MODE;
        //mScrollerX.startScroll(startX, dx, duration);
        //mScrollerY.startScroll(startY, dy, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "E8D7F5B96D38EF5E598258BCD9688B52", hash_generated_method = "521E10E2B9FDFA1B80AAD11E9B6140C9")
    @DSModeled(DSC.SAFE)
    public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(maxY);
        dsTaint.addTaint(maxX);
        dsTaint.addTaint(minX);
        dsTaint.addTaint(minY);
        mMode = FLING_MODE;
        final boolean spingbackX;
        spingbackX = mScrollerX.springback(startX, minX, maxX);
        final boolean spingbackY;
        spingbackY = mScrollerY.springback(startY, minY, maxY);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mMode = FLING_MODE;
        //final boolean spingbackX = mScrollerX.springback(startX, minX, maxX);
        //final boolean spingbackY = mScrollerY.springback(startY, minY, maxY);
        //return spingbackX || spingbackY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.124 -0400", hash_original_method = "DCC04315E1B3C3B4106F742F922D4431", hash_generated_method = "B97A496CDD94D459F20B6989E1C2636E")
    @DSModeled(DSC.SAFE)
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        dsTaint.addTaint(velocityX);
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(velocityY);
        dsTaint.addTaint(maxY);
        dsTaint.addTaint(maxX);
        dsTaint.addTaint(minX);
        dsTaint.addTaint(minY);
        fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
        // ---------- Original Method ----------
        //fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "38A7A19069D4290FC9AB0139CD44ADE1", hash_generated_method = "4C4AF772F7134AC388B4EA67E4591203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY, int overX, int overY) {
        dsTaint.addTaint(velocityX);
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(overY);
        dsTaint.addTaint(velocityY);
        dsTaint.addTaint(overX);
        dsTaint.addTaint(maxY);
        dsTaint.addTaint(maxX);
        dsTaint.addTaint(minX);
        dsTaint.addTaint(minY);
        {
            boolean var4A1974E054BEFB6E3D74B06DA75F60CA_292979902 = (mFlywheel && !isFinished());
            {
                float oldVelocityX;
                oldVelocityX = mScrollerX.mCurrVelocity;
                float oldVelocityY;
                oldVelocityY = mScrollerY.mCurrVelocity;
                {
                    boolean var66E0F4DCA5BEAF4B3B81E945E420E9B0_245606661 = (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY));
                    {
                        velocityX += oldVelocityX;
                        velocityY += oldVelocityY;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mMode = FLING_MODE;
        mScrollerX.fling(startX, velocityX, minX, maxX, overX);
        mScrollerY.fling(startY, velocityY, minY, maxY, overY);
        // ---------- Original Method ----------
        //if (mFlywheel && !isFinished()) {
            //float oldVelocityX = mScrollerX.mCurrVelocity;
            //float oldVelocityY = mScrollerY.mCurrVelocity;
            //if (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    //Math.signum(velocityY) == Math.signum(oldVelocityY)) {
                //velocityX += oldVelocityX;
                //velocityY += oldVelocityY;
            //}
        //}
        //mMode = FLING_MODE;
        //mScrollerX.fling(startX, velocityX, minX, maxX, overX);
        //mScrollerY.fling(startY, velocityY, minY, maxY, overY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "B9132D3CC6E7407A65F178898D94F282", hash_generated_method = "2C16DCD497F1122257A5871962C16BCB")
    @DSModeled(DSC.SAFE)
    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(overX);
        dsTaint.addTaint(finalX);
        mScrollerX.notifyEdgeReached(startX, finalX, overX);
        // ---------- Original Method ----------
        //mScrollerX.notifyEdgeReached(startX, finalX, overX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "EAACB5866396964CA4004FBBF9350F29", hash_generated_method = "D6F548488C1B9C62A7ABA43FFC8C0AD0")
    @DSModeled(DSC.SAFE)
    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        dsTaint.addTaint(startY);
        dsTaint.addTaint(overY);
        dsTaint.addTaint(finalY);
        mScrollerY.notifyEdgeReached(startY, finalY, overY);
        // ---------- Original Method ----------
        //mScrollerY.notifyEdgeReached(startY, finalY, overY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "AE5D891ECDFB8C77EC70A4859A3A8CFD", hash_generated_method = "C66550AC2C51CAF5C6AB76070B88E060")
    @DSModeled(DSC.SAFE)
    public boolean isOverScrolled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((!mScrollerX.mFinished &&
                //mScrollerX.mState != SplineOverScroller.SPLINE) ||
                //(!mScrollerY.mFinished &&
                        //mScrollerY.mState != SplineOverScroller.SPLINE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "E56D99D09F46A8AEF8DD628D53F963A5", hash_generated_method = "A33208DC8822D227E09B72E2DF5D5CA2")
    @DSModeled(DSC.SAFE)
    public void abortAnimation() {
        mScrollerX.finish();
        mScrollerY.finish();
        // ---------- Original Method ----------
        //mScrollerX.finish();
        //mScrollerY.finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "6776820FB8E88CBACCBB30EFABCCA565", hash_generated_method = "AD453DCF5E397395332DD2B824CFE621")
    @DSModeled(DSC.SAFE)
    public int timePassed() {
        final long time;
        time = AnimationUtils.currentAnimationTimeMillis();
        final long startTime;
        startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final long time = AnimationUtils.currentAnimationTimeMillis();
        //final long startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        //return (int) (time - startTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "EC43B1555D38CD3A665472CFA4E77643", hash_generated_method = "8B0EA9BBB906DBFDB93A1359F2E7B502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScrollingInDirection(float xvel, float yvel) {
        dsTaint.addTaint(xvel);
        dsTaint.addTaint(yvel);
        final int dx;
        dx = mScrollerX.mFinal - mScrollerX.mStart;
        final int dy;
        dy = mScrollerY.mFinal - mScrollerY.mStart;
        boolean var28334FACC04D30BF12E042D6701FB467_407469456 = (!isFinished() && Math.signum(xvel) == Math.signum(dx) &&
                Math.signum(yvel) == Math.signum(dy));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int dx = mScrollerX.mFinal - mScrollerX.mStart;
        //final int dy = mScrollerY.mFinal - mScrollerY.mStart;
        //return !isFinished() && Math.signum(xvel) == Math.signum(dx) &&
                //Math.signum(yvel) == Math.signum(dy);
    }

    
    static class SplineOverScroller {
        private int mStart;
        private int mCurrentPosition;
        private int mFinal;
        private int mVelocity;
        private float mCurrVelocity;
        private float mDeceleration;
        private long mStartTime;
        private int mDuration;
        private int mSplineDuration;
        private int mSplineDistance;
        private boolean mFinished;
        private int mOver;
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mState = SPLINE;
        private static final float GRAVITY = 2000.0f;
        private static float PHYSICAL_COEF;
        private static float DECELERATION_RATE = (float) (Math.log(0.78) / Math.log(0.9));
        private static final float INFLEXION = 0.35f;
        private static final float START_TENSION = 0.5f;
        private static final float END_TENSION = 1.0f;
        private static final float P1 = START_TENSION * INFLEXION;
        private static final float P2 = 1.0f - END_TENSION * (1.0f - INFLEXION);
        private static final int NB_SAMPLES = 100;
        private static final float[] SPLINE_POSITION = new float[NB_SAMPLES + 1];
        private static final float[] SPLINE_TIME = new float[NB_SAMPLES + 1];
        private static final int SPLINE = 0;
        private static final int CUBIC = 1;
        private static final int BALLISTIC = 2;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "D0177E162854BD0B51587B46D28F0B6A", hash_generated_method = "8B6DBA85A8DB0911721774553B814AB5")
        @DSModeled(DSC.SAFE)
         SplineOverScroller() {
            mFinished = true;
            // ---------- Original Method ----------
            //mFinished = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "C5E6E7B4566BE5624EF408255FF00E2C", hash_generated_method = "2324AD6408290D1AA4C8BE0B70E3FFDB")
        static void initFromContext(Context context) {
            final float ppi = context.getResources().getDisplayMetrics().density * 160.0f;
            PHYSICAL_COEF = SensorManager.GRAVITY_EARTH 
                    * 39.37f 
                    * ppi
                    * 0.84f;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "9532D02E94E4EAFA434C124BD0A8F760", hash_generated_method = "CAA182A56320EE493781643D0EDD3DC6")
        @DSModeled(DSC.SAFE)
         void setFriction(float friction) {
            dsTaint.addTaint(friction);
            // ---------- Original Method ----------
            //mFlingFriction = friction;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.125 -0400", hash_original_method = "64F0298C66739A6C01CABFBC1A2B2075", hash_generated_method = "5432119D60B0C5DF671B8309BFF80B57")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void updateScroll(float q) {
            dsTaint.addTaint(q);
            mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
            // ---------- Original Method ----------
            //mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "4EEF4AD88BADE833476CB83D5BE6FD85", hash_generated_method = "87EFC541E87F2305523397D7E92B08A7")
        static private float getDeceleration(int velocity) {
            return velocity > 0 ? -GRAVITY : GRAVITY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "97FBA6B7752D67B719405DAE507B2D91", hash_generated_method = "752062F42260D7EA5ADE94C168DCA783")
        @DSModeled(DSC.SAFE)
        private void adjustDuration(int start, int oldFinal, int newFinal) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(newFinal);
            dsTaint.addTaint(oldFinal);
            final int oldDistance;
            oldDistance = oldFinal - start;
            final int newDistance;
            newDistance = newFinal - start;
            final float x;
            x = Math.abs((float) newDistance / oldDistance);
            final int index;
            index = (int) (NB_SAMPLES * x);
            {
                final float x_inf;
                x_inf = (float) index / NB_SAMPLES;
                final float x_sup;
                x_sup = (float) (index + 1) / NB_SAMPLES;
                final float t_inf;
                t_inf = SPLINE_TIME[index];
                final float t_sup;
                t_sup = SPLINE_TIME[index + 1];
                final float timeCoef;
                timeCoef = t_inf + (x - x_inf) / (x_sup - x_inf) * (t_sup - t_inf);
                mDuration *= timeCoef;
            } //End block
            // ---------- Original Method ----------
            //final int oldDistance = oldFinal - start;
            //final int newDistance = newFinal - start;
            //final float x = Math.abs((float) newDistance / oldDistance);
            //final int index = (int) (NB_SAMPLES * x);
            //if (index < NB_SAMPLES) {
                //final float x_inf = (float) index / NB_SAMPLES;
                //final float x_sup = (float) (index + 1) / NB_SAMPLES;
                //final float t_inf = SPLINE_TIME[index];
                //final float t_sup = SPLINE_TIME[index + 1];
                //final float timeCoef = t_inf + (x - x_inf) / (x_sup - x_inf) * (t_sup - t_inf);
                //mDuration *= timeCoef;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "171266C35C248ABBEE6A2AAA833A0F85", hash_generated_method = "8238C885C7BB951FBFF3E6758CD8D845")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startScroll(int start, int distance, int duration) {
            dsTaint.addTaint(distance);
            dsTaint.addTaint(duration);
            dsTaint.addTaint(start);
            mFinished = false;
            mFinal = start + distance;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDeceleration = 0.0f;
            mVelocity = 0;
            // ---------- Original Method ----------
            //mFinished = false;
            //mStart = start;
            //mFinal = start + distance;
            //mStartTime = AnimationUtils.currentAnimationTimeMillis();
            //mDuration = duration;
            //mDeceleration = 0.0f;
            //mVelocity = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "435B8A6291C462C3A88DC285D8A7A1BB", hash_generated_method = "7383565EB5051F42B88814FBED5AB140")
        @DSModeled(DSC.SAFE)
         void finish() {
            mCurrentPosition = mFinal;
            mFinished = true;
            // ---------- Original Method ----------
            //mCurrentPosition = mFinal;
            //mFinished = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "0F10BE4F5BE9DF7795DBE421341ADDA6", hash_generated_method = "8E7392414D248B86FBD83AB629FF399D")
        @DSModeled(DSC.SAFE)
         void setFinalPosition(int position) {
            dsTaint.addTaint(position);
            mFinished = false;
            // ---------- Original Method ----------
            //mFinal = position;
            //mFinished = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "7F220CB7E5E59F74D99C7454C47E42C7", hash_generated_method = "71BE8C4800938B7A449E0B1E0CF6D1F9")
        @DSModeled(DSC.SAFE)
         void extendDuration(int extend) {
            dsTaint.addTaint(extend);
            final long time;
            time = AnimationUtils.currentAnimationTimeMillis();
            final int elapsedTime;
            elapsedTime = (int) (time - mStartTime);
            mDuration = elapsedTime + extend;
            mFinished = false;
            // ---------- Original Method ----------
            //final long time = AnimationUtils.currentAnimationTimeMillis();
            //final int elapsedTime = (int) (time - mStartTime);
            //mDuration = elapsedTime + extend;
            //mFinished = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "D12AE2ECF55023F539A88C111AC438E6", hash_generated_method = "6E2F66D8ADE1CCDB86A9F508B364E0DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean springback(int start, int min, int max) {
            dsTaint.addTaint(min);
            dsTaint.addTaint(max);
            dsTaint.addTaint(start);
            mFinished = true;
            mStart = mFinal = start;
            mVelocity = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = 0;
            {
                startSpringback(start, min, 0);
            } //End block
            {
                startSpringback(start, max, 0);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //mFinished = true;
            //mStart = mFinal = start;
            //mVelocity = 0;
            //mStartTime = AnimationUtils.currentAnimationTimeMillis();
            //mDuration = 0;
            //if (start < min) {
                //startSpringback(start, min, 0);
            //} else if (start > max) {
                //startSpringback(start, max, 0);
            //}
            //return !mFinished;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.126 -0400", hash_original_method = "FE4DCB4600DDD23F75B042FA5167B4E7", hash_generated_method = "635B5BD547A1D33A1ED8D2860B52D8D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void startSpringback(int start, int end, int velocity) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            dsTaint.addTaint(end);
            mFinished = false;
            mState = CUBIC;
            final int delta;
            delta = start - end;
            mDeceleration = getDeceleration(delta);
            mVelocity = -delta;
            mOver = Math.abs(delta);
            mDuration = (int) (1000.0 * Math.sqrt(-2.0 * delta / mDeceleration));
            // ---------- Original Method ----------
            //mFinished = false;
            //mState = CUBIC;
            //mStart = start;
            //mFinal = end;
            //final int delta = start - end;
            //mDeceleration = getDeceleration(delta);
            //mVelocity = -delta;
            //mOver = Math.abs(delta);
            //mDuration = (int) (1000.0 * Math.sqrt(-2.0 * delta / mDeceleration));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.127 -0400", hash_original_method = "8B3E33053E001BDAB851E620AED14FC0", hash_generated_method = "2F71A1D6EA39CE2EF8B92E1B4BE50174")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void fling(int start, int velocity, int min, int max, int over) {
            dsTaint.addTaint(min);
            dsTaint.addTaint(over);
            dsTaint.addTaint(max);
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            mFinished = false;
            mCurrVelocity = mVelocity = velocity;
            mDuration = mSplineDuration = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mCurrentPosition = mStart = start;
            {
                startAfterEdge(start, min, max, velocity);
            } //End block
            mState = SPLINE;
            double totalDistance;
            totalDistance = 0.0;
            {
                mDuration = mSplineDuration = getSplineFlingDuration(velocity);
                totalDistance = getSplineFlingDistance(velocity);
            } //End block
            mSplineDistance = (int) (totalDistance * Math.signum(velocity));
            mFinal = start + mSplineDistance;
            {
                adjustDuration(mStart, mFinal, min);
            } //End block
            {
                adjustDuration(mStart, mFinal, max);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.127 -0400", hash_original_method = "55451D958AF332430844B13377F10B18", hash_generated_method = "A6CFC35BFC97950FD4E290DE0DF79AB2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private double getSplineDeceleration(int velocity) {
            dsTaint.addTaint(velocity);
            double var13DD5CC47FE607CEAB2EC46D75E485B4_936407363 = (Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF)));
            return dsTaint.getTaintDouble();
            // ---------- Original Method ----------
            //return Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.127 -0400", hash_original_method = "7888FBEE8D14061C2ED981410CC88AC0", hash_generated_method = "B6DACCCF366A541AA5687F05D911A942")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private double getSplineFlingDistance(int velocity) {
            dsTaint.addTaint(velocity);
            final double l;
            l = getSplineDeceleration(velocity);
            final double decelMinusOne;
            decelMinusOne = DECELERATION_RATE - 1.0;
            double var1AE4D1075C6295F76A964E4AD022A173_2060818414 = (mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l));
            return dsTaint.getTaintDouble();
            // ---------- Original Method ----------
            //final double l = getSplineDeceleration(velocity);
            //final double decelMinusOne = DECELERATION_RATE - 1.0;
            //return mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.127 -0400", hash_original_method = "1F09855DFC7D15DA5ECD081A4B3F581B", hash_generated_method = "6A420F36CF30DDF1AD2572A541E47F88")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int getSplineFlingDuration(int velocity) {
            dsTaint.addTaint(velocity);
            final double l;
            l = getSplineDeceleration(velocity);
            final double decelMinusOne;
            decelMinusOne = DECELERATION_RATE - 1.0;
            int varE02D490CB65208CB9281B455204D3B5C_1289826490 = ((int) (1000.0 * Math.exp(l / decelMinusOne)));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final double l = getSplineDeceleration(velocity);
            //final double decelMinusOne = DECELERATION_RATE - 1.0;
            //return (int) (1000.0 * Math.exp(l / decelMinusOne));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.127 -0400", hash_original_method = "C51353CD784B93D7179DA830597304C4", hash_generated_method = "A36E52276CA9C09CB6F6FA4EDEA26000")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void fitOnBounceCurve(int start, int end, int velocity) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            dsTaint.addTaint(end);
            final float durationToApex;
            durationToApex = - velocity / mDeceleration;
            final float distanceToApex;
            distanceToApex = velocity * velocity / 2.0f / Math.abs(mDeceleration);
            final float distanceToEdge;
            distanceToEdge = Math.abs(end - start);
            final float totalDuration;
            totalDuration = (float) Math.sqrt(
                    2.0 * (distanceToApex + distanceToEdge) / Math.abs(mDeceleration));
            mStartTime -= (int) (1000.0f * (totalDuration - durationToApex));
            mVelocity = (int) (- mDeceleration * totalDuration);
            // ---------- Original Method ----------
            //final float durationToApex = - velocity / mDeceleration;
            //final float distanceToApex = velocity * velocity / 2.0f / Math.abs(mDeceleration);
            //final float distanceToEdge = Math.abs(end - start);
            //final float totalDuration = (float) Math.sqrt(
                    //2.0 * (distanceToApex + distanceToEdge) / Math.abs(mDeceleration));
            //mStartTime -= (int) (1000.0f * (totalDuration - durationToApex));
            //mStart = end;
            //mVelocity = (int) (- mDeceleration * totalDuration);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.127 -0400", hash_original_method = "5D48F28010F8FCB9211B58C3C36EC8CC", hash_generated_method = "EB61B9C647CC72DFC215C332CE6F4F17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void startBounceAfterEdge(int start, int end, int velocity) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            dsTaint.addTaint(end);
            mDeceleration = getDeceleration(velocity == 0 ? start - end : velocity);
            fitOnBounceCurve(start, end, velocity);
            onEdgeReached();
            // ---------- Original Method ----------
            //mDeceleration = getDeceleration(velocity == 0 ? start - end : velocity);
            //fitOnBounceCurve(start, end, velocity);
            //onEdgeReached();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.128 -0400", hash_original_method = "E644EF955DC6FD722F53E2DD199A395E", hash_generated_method = "CB7C61A3828C8F36ACD1DF639B95B71C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void startAfterEdge(int start, int min, int max, int velocity) {
            dsTaint.addTaint(min);
            dsTaint.addTaint(max);
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            {
                mFinished = true;
            } //End block
            final boolean positive;
            positive = start > max;
            int edge;
            edge = max;
            edge = min;
            final int overDistance;
            overDistance = start - edge;
            boolean keepIncreasing;
            keepIncreasing = overDistance * velocity >= 0;
            {
                startBounceAfterEdge(start, edge, velocity);
            } //End block
            {
                final double totalDistance;
                totalDistance = getSplineFlingDistance(velocity);
                {
                    boolean varAFFBEB20AB3CF5CAE72A649B507B5311_1818086538 = (totalDistance > Math.abs(overDistance));
                    {
                        fling(start, velocity, positive ? min : start, positive ? start : max, mOver);
                    } //End block
                    {
                        startSpringback(start, edge, velocity);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.130 -0400", hash_original_method = "D032297ACDC9C65A50161DCB548F10DC", hash_generated_method = "C52E5F6274F9CD13F8623AA5E7861649")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void notifyEdgeReached(int start, int end, int over) {
            dsTaint.addTaint(over);
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            {
                mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(start, end, end, (int) mCurrVelocity);
            } //End block
            // ---------- Original Method ----------
            //if (mState == SPLINE) {
                //mOver = over;
                //mStartTime = AnimationUtils.currentAnimationTimeMillis();
                //startAfterEdge(start, end, end, (int) mCurrVelocity);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.130 -0400", hash_original_method = "4D9D443F2B4C6EC9AAAB1FF452014EB4", hash_generated_method = "AFE5EBDA06BF61E07DCE8AD7C74E0FCE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void onEdgeReached() {
            float distance;
            distance = mVelocity * mVelocity / (2.0f * Math.abs(mDeceleration));
            final float sign;
            sign = Math.signum(mVelocity);
            {
                mDeceleration = - sign * mVelocity * mVelocity / (2.0f * mOver);
                distance = mOver;
            } //End block
            mOver = (int) distance;
            mState = BALLISTIC;
            mFinal = mStart + (int) (mVelocity > 0 ? distance : -distance);
            mDuration = - (int) (1000.0f * mVelocity / mDeceleration);
            // ---------- Original Method ----------
            //float distance = mVelocity * mVelocity / (2.0f * Math.abs(mDeceleration));
            //final float sign = Math.signum(mVelocity);
            //if (distance > mOver) {
                 //mDeceleration = - sign * mVelocity * mVelocity / (2.0f * mOver);
                 //distance = mOver;
            //}
            //mOver = (int) distance;
            //mState = BALLISTIC;
            //mFinal = mStart + (int) (mVelocity > 0 ? distance : -distance);
            //mDuration = - (int) (1000.0f * mVelocity / mDeceleration);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.130 -0400", hash_original_method = "6FDA077121143820AC37360810DDE80A", hash_generated_method = "8AA17730F826951A2DE3973171173B01")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean continueWhenFinished() {
            //Begin case SPLINE 
            {
                mStart = mFinal;
                mVelocity = (int) mCurrVelocity;
                mDeceleration = getDeceleration(mVelocity);
                mStartTime += mDuration;
                onEdgeReached();
            } //End block
            //End case SPLINE 
            //Begin case BALLISTIC 
            mStartTime += mDuration;
            //End case BALLISTIC 
            //Begin case BALLISTIC 
            startSpringback(mFinal, mStart, 0);
            //End case BALLISTIC 
            update();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:08.130 -0400", hash_original_method = "36FADD2423F4A31EF1611CA012E37B33", hash_generated_method = "D97942C3AC491F96D966DC7307660300")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean update() {
            final long time;
            time = AnimationUtils.currentAnimationTimeMillis();
            final long currentTime;
            currentTime = time - mStartTime;
            double distance;
            distance = 0.0;
            //Begin case SPLINE 
            {
                final float t;
                t = (float) currentTime / mSplineDuration;
                final int index;
                index = (int) (NB_SAMPLES * t);
                float distanceCoef;
                distanceCoef = 1.f;
                float velocityCoef;
                velocityCoef = 0.f;
                {
                    final float t_inf;
                    t_inf = (float) index / NB_SAMPLES;
                    final float t_sup;
                    t_sup = (float) (index + 1) / NB_SAMPLES;
                    final float d_inf;
                    d_inf = SPLINE_POSITION[index];
                    final float d_sup;
                    d_sup = SPLINE_POSITION[index + 1];
                    velocityCoef = (d_sup - d_inf) / (t_sup - t_inf);
                    distanceCoef = d_inf + (t - t_inf) * velocityCoef;
                } //End block
                distance = distanceCoef * mSplineDistance;
                mCurrVelocity = velocityCoef * mSplineDistance / mSplineDuration * 1000.0f;
            } //End block
            //End case SPLINE 
            //Begin case BALLISTIC 
            {
                final float t;
                t = currentTime / 1000.0f;
                mCurrVelocity = mVelocity + mDeceleration * t;
                distance = mVelocity * t + mDeceleration * t * t / 2.0f;
            } //End block
            //End case BALLISTIC 
            //Begin case CUBIC 
            {
                final float t;
                t = (float) (currentTime) / mDuration;
                final float t2;
                t2 = t * t;
                final float sign;
                sign = Math.signum(mVelocity);
                distance = sign * mOver * (3.0f * t2 - 2.0f * t * t2);
                mCurrVelocity = sign * mOver * 6.0f * (- t + t2);
            } //End block
            //End case CUBIC 
            mCurrentPosition = mStart + (int) Math.round(distance);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        static {
            float x_min = 0.0f;
            float y_min = 0.0f;
            for (int i = 0; i < NB_SAMPLES; i++) {
                final float alpha = (float) i / NB_SAMPLES;
                float x_max = 1.0f;
                float x, tx, coef;
                while (true) {
                    x = x_min + (x_max - x_min) / 2.0f;
                    coef = 3.0f * x * (1.0f - x);
                    tx = coef * ((1.0f - x) * P1 + x * P2) + x * x * x;
                    if (Math.abs(tx - alpha) < 1E-5) break;
                    if (tx > alpha) x_max = x;
                    else x_min = x;
                }
                SPLINE_POSITION[i] = coef * ((1.0f - x) * START_TENSION + x) + x * x * x;
                float y_max = 1.0f;
                float y, dy;
                while (true) {
                    y = y_min + (y_max - y_min) / 2.0f;
                    coef = 3.0f * y * (1.0f - y);
                    dy = coef * ((1.0f - y) * START_TENSION + y) + y * y * y;
                    if (Math.abs(dy - alpha) < 1E-5) break;
                    if (dy > alpha) y_max = y;
                    else y_min = y;
                }
                SPLINE_TIME[i] = coef * ((1.0f - y) * P1 + y * P2) + y * y * y;
            }
            SPLINE_POSITION[NB_SAMPLES] = SPLINE_TIME[NB_SAMPLES] = 1.0f;
        }
        
    }


    
}


