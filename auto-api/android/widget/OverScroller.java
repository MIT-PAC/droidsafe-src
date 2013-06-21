package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private SplineOverScroller mScrollerX;
    private SplineOverScroller mScrollerY;
    private Interpolator mInterpolator;
    private boolean mFlywheel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.868 -0400", hash_original_method = "B9802AB7FB2D6944C0543E71DB189BC5", hash_generated_method = "1CFE7E9F656FCA4A4F4A9D105A4801C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.868 -0400", hash_original_method = "F6227ED49D62C3697D2AC005A8942714", hash_generated_method = "EAA6E93BDA77D21BEDE58A3443A6DDB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.869 -0400", hash_original_method = "8F06EBB42FF76B1717D428E4F6418D97", hash_generated_method = "C954E7ABB0B54F699DA599B831C433B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context, Interpolator interpolator, boolean flywheel) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(flywheel);
        dsTaint.addTaint(interpolator.dsTaint);
        mScrollerX = new SplineOverScroller();
        mScrollerY = new SplineOverScroller();
        SplineOverScroller.initFromContext(context);
        // ---------- Original Method ----------
        //mInterpolator = interpolator;
        //mFlywheel = flywheel;
        //mScrollerX = new SplineOverScroller();
        //mScrollerY = new SplineOverScroller();
        //SplineOverScroller.initFromContext(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.869 -0400", hash_original_method = "0CF9495AD70A3403C1A28AE06C2DFE6A", hash_generated_method = "E58EEEC5B3E65F0D87826761F525251F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.869 -0400", hash_original_method = "229999978F856549CB121738FDE882C4", hash_generated_method = "062A4D7A0D67328B67315827DC8415CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        this(context, interpolator, flywheel);
        dsTaint.addTaint(bounceCoefficientY);
        dsTaint.addTaint(bounceCoefficientX);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(flywheel);
        dsTaint.addTaint(interpolator.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.869 -0400", hash_original_method = "E258F8966760114615A66C59C43DDBF7", hash_generated_method = "462A4D0A3C075B9600F2FF259E8A0713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setFriction(float friction) {
        dsTaint.addTaint(friction);
        mScrollerX.setFriction(friction);
        mScrollerY.setFriction(friction);
        // ---------- Original Method ----------
        //mScrollerX.setFriction(friction);
        //mScrollerY.setFriction(friction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.869 -0400", hash_original_method = "C0D588953F48F0F49E401C0010BD067A", hash_generated_method = "0614F8CB94B185FCE15A5225B551369F")
    @DSModeled(DSC.SAFE)
    public final boolean isFinished() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollerX.mFinished && mScrollerY.mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.869 -0400", hash_original_method = "530BF62F40D21F1D1C05E22ECA085B25", hash_generated_method = "7779BFBFA16AE830340927F8FBD3FD06")
    @DSModeled(DSC.SAFE)
    public final void forceFinished(boolean finished) {
        dsTaint.addTaint(finished);
        mScrollerX.mFinished = mScrollerY.mFinished = finished;
        // ---------- Original Method ----------
        //mScrollerX.mFinished = mScrollerY.mFinished = finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.870 -0400", hash_original_method = "935C47FB8A3CB470F597BC28E107035C", hash_generated_method = "F2990D35E2F7C6D7BBAE498472186440")
    @DSModeled(DSC.SAFE)
    public final int getCurrX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerX.mCurrentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.870 -0400", hash_original_method = "4ECEC07425ABC9DEFD7B203A5114566B", hash_generated_method = "171C6247B354B6F641CBDE2059F13E69")
    @DSModeled(DSC.SAFE)
    public final int getCurrY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerY.mCurrentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.870 -0400", hash_original_method = "64BF41B2D89FD1AD797ACAED97E05500", hash_generated_method = "2C4A9CCC48B9512723A50904976B1AB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getCurrVelocity() {
        float squaredNorm;
        squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        float varD836AEECDA15973F990993130D0A04EB_1052742234 = (FloatMath.sqrt(squaredNorm));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //float squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        //squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        //return FloatMath.sqrt(squaredNorm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.870 -0400", hash_original_method = "99101D94CAA5BDB5F4107BC8C52E5814", hash_generated_method = "F056408A4706AF1107ED4449094EF211")
    @DSModeled(DSC.SAFE)
    public final int getStartX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerX.mStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.870 -0400", hash_original_method = "C3B7BC19CF57D40812EE2941701D8011", hash_generated_method = "590C9DF7DE6D94A804D1C440705A7752")
    @DSModeled(DSC.SAFE)
    public final int getStartY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerY.mStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.870 -0400", hash_original_method = "B59ED352B9AEDA78AFFC00B7CFC03926", hash_generated_method = "911947E6BFD281713DC3A87049166A6F")
    @DSModeled(DSC.SAFE)
    public final int getFinalX() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerX.mFinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.871 -0400", hash_original_method = "35D86359302D602175EC68518CA83146", hash_generated_method = "E98CC7971B0F7C9424D0D399B67E6DAF")
    @DSModeled(DSC.SAFE)
    public final int getFinalY() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScrollerY.mFinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.871 -0400", hash_original_method = "9AE57030D7C8A0E7D6E4B9C3569B7863", hash_generated_method = "8AB0F63021A686556AA1DD866C94AE66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final int getDuration() {
        int var2AE19ED6BFD3EE2A01F12C594E911C5B_436550988 = (Math.max(mScrollerX.mDuration, mScrollerY.mDuration));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Math.max(mScrollerX.mDuration, mScrollerY.mDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.871 -0400", hash_original_method = "C8E559EF6FD22D868574182D9D2BCAF9", hash_generated_method = "28AA754D377CFF01D447F9E0658B0DF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void extendDuration(int extend) {
        dsTaint.addTaint(extend);
        mScrollerX.extendDuration(extend);
        mScrollerY.extendDuration(extend);
        // ---------- Original Method ----------
        //mScrollerX.extendDuration(extend);
        //mScrollerY.extendDuration(extend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.871 -0400", hash_original_method = "21D9AD21BF731806972ABE02338AD0C0", hash_generated_method = "86EA5F5EA7C391746429BA8AC9BE9A16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setFinalX(int newX) {
        dsTaint.addTaint(newX);
        mScrollerX.setFinalPosition(newX);
        // ---------- Original Method ----------
        //mScrollerX.setFinalPosition(newX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.871 -0400", hash_original_method = "300115417BC2D028444CA0676224C129", hash_generated_method = "D855AA7D96A1251CE9E0B66F9DC0E7F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setFinalY(int newY) {
        dsTaint.addTaint(newY);
        mScrollerY.setFinalPosition(newY);
        // ---------- Original Method ----------
        //mScrollerY.setFinalPosition(newY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.872 -0400", hash_original_method = "4391FF82C7FA76BDB2CDCD1D85612F8D", hash_generated_method = "1D7BDE17CC10D7859394DF22E8780992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean computeScrollOffset() {
        {
            boolean var802B4329042ED423187FD338A790F5A6_787245349 = (isFinished());
        } //End collapsed parenthetic
        //Begin case SCROLL_MODE 
        long time;
        time = AnimationUtils.currentAnimationTimeMillis();
        //End case SCROLL_MODE 
        //Begin case SCROLL_MODE 
        long elapsedTime;
        elapsedTime = time - mScrollerX.mStartTime;
        //End case SCROLL_MODE 
        //Begin case SCROLL_MODE 
        int duration;
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
                boolean varBFDC0FB1B43EB7BCC4E9E82DEDCD9FC2_921962428 = (!mScrollerX.update());
                {
                    {
                        boolean varC9F451BE971CCB0A82BBE1EBE98D8511_917590266 = (!mScrollerX.continueWhenFinished());
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
                boolean var139B509336DC22E8B49FCE36B537A826_378495421 = (!mScrollerY.update());
                {
                    {
                        boolean var4B1E7AEBADA7A1365CA571D290BAD045_199987700 = (!mScrollerY.continueWhenFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.872 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "0DC814646443983F552E03C5B6023BD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startScroll(int startX, int startY, int dx, int dy) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(dx);
        dsTaint.addTaint(dy);
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        // ---------- Original Method ----------
        //startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.872 -0400", hash_original_method = "C7C9FE1639F9BA6211C746BC2E590EF8", hash_generated_method = "21A46ADF7AD02552A949E72B13503EE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        dsTaint.addTaint(duration);
        dsTaint.addTaint(startX);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.872 -0400", hash_original_method = "E8D7F5B96D38EF5E598258BCD9688B52", hash_generated_method = "BB70F938765003B7CED64043726DD751")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(maxY);
        dsTaint.addTaint(maxX);
        dsTaint.addTaint(minX);
        dsTaint.addTaint(minY);
        mMode = FLING_MODE;
        boolean spingbackX;
        spingbackX = mScrollerX.springback(startX, minX, maxX);
        boolean spingbackY;
        spingbackY = mScrollerY.springback(startY, minY, maxY);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mMode = FLING_MODE;
        //final boolean spingbackX = mScrollerX.springback(startX, minX, maxX);
        //final boolean spingbackY = mScrollerY.springback(startY, minY, maxY);
        //return spingbackX || spingbackY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.873 -0400", hash_original_method = "DCC04315E1B3C3B4106F742F922D4431", hash_generated_method = "058AF1B7291527C2F073C5A643CF104B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.873 -0400", hash_original_method = "38A7A19069D4290FC9AB0139CD44ADE1", hash_generated_method = "35A37D32BF5705B5C65DD8FDCC7D1AB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY, int overX, int overY) {
        dsTaint.addTaint(velocityX);
        dsTaint.addTaint(startX);
        dsTaint.addTaint(startY);
        dsTaint.addTaint(overY);
        dsTaint.addTaint(overX);
        dsTaint.addTaint(velocityY);
        dsTaint.addTaint(maxY);
        dsTaint.addTaint(maxX);
        dsTaint.addTaint(minX);
        dsTaint.addTaint(minY);
        {
            boolean var4A1974E054BEFB6E3D74B06DA75F60CA_1224764603 = (mFlywheel && !isFinished());
            {
                float oldVelocityX;
                oldVelocityX = mScrollerX.mCurrVelocity;
                float oldVelocityY;
                oldVelocityY = mScrollerY.mCurrVelocity;
                {
                    boolean var66E0F4DCA5BEAF4B3B81E945E420E9B0_1497525963 = (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.873 -0400", hash_original_method = "B9132D3CC6E7407A65F178898D94F282", hash_generated_method = "E130128ADF8F1D16C3C6BC2564A185AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        dsTaint.addTaint(startX);
        dsTaint.addTaint(overX);
        dsTaint.addTaint(finalX);
        mScrollerX.notifyEdgeReached(startX, finalX, overX);
        // ---------- Original Method ----------
        //mScrollerX.notifyEdgeReached(startX, finalX, overX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.873 -0400", hash_original_method = "EAACB5866396964CA4004FBBF9350F29", hash_generated_method = "A1158B7B3DD6CB17401850255041B847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        dsTaint.addTaint(startY);
        dsTaint.addTaint(overY);
        dsTaint.addTaint(finalY);
        mScrollerY.notifyEdgeReached(startY, finalY, overY);
        // ---------- Original Method ----------
        //mScrollerY.notifyEdgeReached(startY, finalY, overY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.874 -0400", hash_original_method = "AE5D891ECDFB8C77EC70A4859A3A8CFD", hash_generated_method = "6CD7958CBA9ED324706DB2542754D7ED")
    @DSModeled(DSC.SAFE)
    public boolean isOverScrolled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((!mScrollerX.mFinished &&
                //mScrollerX.mState != SplineOverScroller.SPLINE) ||
                //(!mScrollerY.mFinished &&
                        //mScrollerY.mState != SplineOverScroller.SPLINE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.874 -0400", hash_original_method = "E56D99D09F46A8AEF8DD628D53F963A5", hash_generated_method = "694AEC3319AADB935EA112A7C19DD2CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void abortAnimation() {
        mScrollerX.finish();
        mScrollerY.finish();
        // ---------- Original Method ----------
        //mScrollerX.finish();
        //mScrollerY.finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.874 -0400", hash_original_method = "6776820FB8E88CBACCBB30EFABCCA565", hash_generated_method = "D5D0D823EE4E87623849CC8103068C26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int timePassed() {
        long time;
        time = AnimationUtils.currentAnimationTimeMillis();
        long startTime;
        startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final long time = AnimationUtils.currentAnimationTimeMillis();
        //final long startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        //return (int) (time - startTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.874 -0400", hash_original_method = "EC43B1555D38CD3A665472CFA4E77643", hash_generated_method = "9F98230217C6C74BB44F467DB33F741E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isScrollingInDirection(float xvel, float yvel) {
        dsTaint.addTaint(xvel);
        dsTaint.addTaint(yvel);
        int dx;
        dx = mScrollerX.mFinal - mScrollerX.mStart;
        int dy;
        dy = mScrollerY.mFinal - mScrollerY.mStart;
        boolean var28334FACC04D30BF12E042D6701FB467_767624016 = (!isFinished() && Math.signum(xvel) == Math.signum(dx) &&
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.874 -0400", hash_original_method = "D0177E162854BD0B51587B46D28F0B6A", hash_generated_method = "8DA67F7E3849D2B57321066409F02625")
        @DSModeled(DSC.SAFE)
         SplineOverScroller() {
            mFinished = true;
            // ---------- Original Method ----------
            //mFinished = true;
        }

        
                static void initFromContext(Context context) {
            final float ppi = context.getResources().getDisplayMetrics().density * 160.0f;
            PHYSICAL_COEF = SensorManager.GRAVITY_EARTH 
                    * 39.37f 
                    * ppi
                    * 0.84f;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.875 -0400", hash_original_method = "9532D02E94E4EAFA434C124BD0A8F760", hash_generated_method = "2432F17D61F8F275C5DBA590C08F9FB4")
        @DSModeled(DSC.SAFE)
         void setFriction(float friction) {
            dsTaint.addTaint(friction);
            // ---------- Original Method ----------
            //mFlingFriction = friction;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.875 -0400", hash_original_method = "64F0298C66739A6C01CABFBC1A2B2075", hash_generated_method = "6D41D6615327E59F0BA50244E1D2D5AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void updateScroll(float q) {
            dsTaint.addTaint(q);
            mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
            // ---------- Original Method ----------
            //mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
        }

        
                static private float getDeceleration(int velocity) {
            return velocity > 0 ? -GRAVITY : GRAVITY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.875 -0400", hash_original_method = "97FBA6B7752D67B719405DAE507B2D91", hash_generated_method = "C337AE4960483862901170AE5A4FBE32")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void adjustDuration(int start, int oldFinal, int newFinal) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(newFinal);
            dsTaint.addTaint(oldFinal);
            int oldDistance;
            oldDistance = oldFinal - start;
            int newDistance;
            newDistance = newFinal - start;
            float x;
            x = Math.abs((float) newDistance / oldDistance);
            int index;
            index = (int) (NB_SAMPLES * x);
            {
                float x_inf;
                x_inf = (float) index / NB_SAMPLES;
                float x_sup;
                x_sup = (float) (index + 1) / NB_SAMPLES;
                float t_inf;
                t_inf = SPLINE_TIME[index];
                float t_sup;
                t_sup = SPLINE_TIME[index + 1];
                float timeCoef;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.876 -0400", hash_original_method = "171266C35C248ABBEE6A2AAA833A0F85", hash_generated_method = "8ADD618ECF8DA63EA134313AA1E643A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void startScroll(int start, int distance, int duration) {
            dsTaint.addTaint(duration);
            dsTaint.addTaint(distance);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.876 -0400", hash_original_method = "435B8A6291C462C3A88DC285D8A7A1BB", hash_generated_method = "E81E47C77DE0F2409607E7F653A93387")
        @DSModeled(DSC.SAFE)
         void finish() {
            mCurrentPosition = mFinal;
            mFinished = true;
            // ---------- Original Method ----------
            //mCurrentPosition = mFinal;
            //mFinished = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.876 -0400", hash_original_method = "0F10BE4F5BE9DF7795DBE421341ADDA6", hash_generated_method = "84C69C02774B80A2D225387247DDEE6E")
        @DSModeled(DSC.SAFE)
         void setFinalPosition(int position) {
            dsTaint.addTaint(position);
            mFinished = false;
            // ---------- Original Method ----------
            //mFinal = position;
            //mFinished = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.876 -0400", hash_original_method = "7F220CB7E5E59F74D99C7454C47E42C7", hash_generated_method = "610A2CDDE1BBA42A559571567CD3BC03")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void extendDuration(int extend) {
            dsTaint.addTaint(extend);
            long time;
            time = AnimationUtils.currentAnimationTimeMillis();
            int elapsedTime;
            elapsedTime = (int) (time - mStartTime);
            mDuration = elapsedTime + extend;
            mFinished = false;
            // ---------- Original Method ----------
            //final long time = AnimationUtils.currentAnimationTimeMillis();
            //final int elapsedTime = (int) (time - mStartTime);
            //mDuration = elapsedTime + extend;
            //mFinished = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.876 -0400", hash_original_method = "D12AE2ECF55023F539A88C111AC438E6", hash_generated_method = "863F7AAC92488FA06F3926B679431958")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.877 -0400", hash_original_method = "FE4DCB4600DDD23F75B042FA5167B4E7", hash_generated_method = "F24B9BD459CD67E83D23798A93D32EC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void startSpringback(int start, int end, int velocity) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            dsTaint.addTaint(end);
            mFinished = false;
            mState = CUBIC;
            int delta;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.877 -0400", hash_original_method = "8B3E33053E001BDAB851E620AED14FC0", hash_generated_method = "2BBD279B6EA6424AACA348E79C63B7C4")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.878 -0400", hash_original_method = "55451D958AF332430844B13377F10B18", hash_generated_method = "AF887813AA2FCE03D522A9B59B456773")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private double getSplineDeceleration(int velocity) {
            dsTaint.addTaint(velocity);
            double var13DD5CC47FE607CEAB2EC46D75E485B4_1501606059 = (Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF)));
            return dsTaint.getTaintDouble();
            // ---------- Original Method ----------
            //return Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.878 -0400", hash_original_method = "7888FBEE8D14061C2ED981410CC88AC0", hash_generated_method = "898A02A07DC2677EC6F653F259A10071")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private double getSplineFlingDistance(int velocity) {
            dsTaint.addTaint(velocity);
            double l;
            l = getSplineDeceleration(velocity);
            double decelMinusOne;
            decelMinusOne = DECELERATION_RATE - 1.0;
            double var1AE4D1075C6295F76A964E4AD022A173_942315438 = (mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l));
            return dsTaint.getTaintDouble();
            // ---------- Original Method ----------
            //final double l = getSplineDeceleration(velocity);
            //final double decelMinusOne = DECELERATION_RATE - 1.0;
            //return mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.878 -0400", hash_original_method = "1F09855DFC7D15DA5ECD081A4B3F581B", hash_generated_method = "11A4228DD845C5ADBB2DD5B6F0E4E704")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int getSplineFlingDuration(int velocity) {
            dsTaint.addTaint(velocity);
            double l;
            l = getSplineDeceleration(velocity);
            double decelMinusOne;
            decelMinusOne = DECELERATION_RATE - 1.0;
            int varE02D490CB65208CB9281B455204D3B5C_1187797345 = ((int) (1000.0 * Math.exp(l / decelMinusOne)));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //final double l = getSplineDeceleration(velocity);
            //final double decelMinusOne = DECELERATION_RATE - 1.0;
            //return (int) (1000.0 * Math.exp(l / decelMinusOne));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.878 -0400", hash_original_method = "C51353CD784B93D7179DA830597304C4", hash_generated_method = "DFF8A93136C72915F3E62E3E7F0D3FF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void fitOnBounceCurve(int start, int end, int velocity) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            dsTaint.addTaint(end);
            float durationToApex;
            durationToApex = - velocity / mDeceleration;
            float distanceToApex;
            distanceToApex = velocity * velocity / 2.0f / Math.abs(mDeceleration);
            float distanceToEdge;
            distanceToEdge = Math.abs(end - start);
            float totalDuration;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.879 -0400", hash_original_method = "5D48F28010F8FCB9211B58C3C36EC8CC", hash_generated_method = "EC449359B6F8F27F28FBB44DB8A87041")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.879 -0400", hash_original_method = "E644EF955DC6FD722F53E2DD199A395E", hash_generated_method = "E69CE1D5B3DB635A2C111AF0145B3F96")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void startAfterEdge(int start, int min, int max, int velocity) {
            dsTaint.addTaint(min);
            dsTaint.addTaint(max);
            dsTaint.addTaint(start);
            dsTaint.addTaint(velocity);
            {
                mFinished = true;
            } //End block
            boolean positive;
            positive = start > max;
            int edge;
            edge = max;
            edge = min;
            int overDistance;
            overDistance = start - edge;
            boolean keepIncreasing;
            keepIncreasing = overDistance * velocity >= 0;
            {
                startBounceAfterEdge(start, edge, velocity);
            } //End block
            {
                double totalDistance;
                totalDistance = getSplineFlingDistance(velocity);
                {
                    boolean varAFFBEB20AB3CF5CAE72A649B507B5311_756711360 = (totalDistance > Math.abs(overDistance));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.879 -0400", hash_original_method = "D032297ACDC9C65A50161DCB548F10DC", hash_generated_method = "912777EFA1D55AF7B5BD874271E4A6F6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.880 -0400", hash_original_method = "4D9D443F2B4C6EC9AAAB1FF452014EB4", hash_generated_method = "EDA052BAFBB7C8C5A047F2E3B76C2C54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void onEdgeReached() {
            float distance;
            distance = mVelocity * mVelocity / (2.0f * Math.abs(mDeceleration));
            float sign;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.880 -0400", hash_original_method = "6FDA077121143820AC37360810DDE80A", hash_generated_method = "6C29F1F7C2CF14F7CB43DBD0CC7A9DA0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.881 -0400", hash_original_method = "36FADD2423F4A31EF1611CA012E37B33", hash_generated_method = "338E0B6EFDE928817EFF5D7EDD1DB746")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean update() {
            long time;
            time = AnimationUtils.currentAnimationTimeMillis();
            long currentTime;
            currentTime = time - mStartTime;
            double distance;
            distance = 0.0;
            //Begin case SPLINE 
            {
                float t;
                t = (float) currentTime / mSplineDuration;
                int index;
                index = (int) (NB_SAMPLES * t);
                float distanceCoef;
                distanceCoef = 1.f;
                float velocityCoef;
                velocityCoef = 0.f;
                {
                    float t_inf;
                    t_inf = (float) index / NB_SAMPLES;
                    float t_sup;
                    t_sup = (float) (index + 1) / NB_SAMPLES;
                    float d_inf;
                    d_inf = SPLINE_POSITION[index];
                    float d_sup;
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
                float t;
                t = currentTime / 1000.0f;
                mCurrVelocity = mVelocity + mDeceleration * t;
                distance = mVelocity * t + mDeceleration * t * t / 2.0f;
            } //End block
            //End case BALLISTIC 
            //Begin case CUBIC 
            {
                float t;
                t = (float) (currentTime) / mDuration;
                float t2;
                t2 = t * t;
                float sign;
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


    
    private static final int DEFAULT_DURATION = 250;
    private static final int SCROLL_MODE = 0;
    private static final int FLING_MODE = 1;
}

