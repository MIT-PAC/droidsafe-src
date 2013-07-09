package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.hardware.SensorManager;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.305 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.305 -0400", hash_original_field = "3D9BF56A145B7A388A1FA15E02CE0CE1", hash_generated_field = "9FFB811B26F4EA1D9264A27559A21A04")

    private SplineOverScroller mScrollerX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.305 -0400", hash_original_field = "5C2E45939A356352B1EBE2C26A8AA079", hash_generated_field = "2EB0A894343F6510CC074954C4F3CB9E")

    private SplineOverScroller mScrollerY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.305 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.305 -0400", hash_original_field = "0674FBD78043F84E1B63598E85DD9F83", hash_generated_field = "DB496AACF49E477CC5F54743876A46FF")

    private boolean mFlywheel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.306 -0400", hash_original_method = "B9802AB7FB2D6944C0543E71DB189BC5", hash_generated_method = "398A849B67626D49F95C7274A5C25CD9")
    public  OverScroller(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.306 -0400", hash_original_method = "F6227ED49D62C3697D2AC005A8942714", hash_generated_method = "F0406746F46142B83E77832CDA8B54BE")
    public  OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
        addTaint(context.getTaint());
        addTaint(interpolator.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.307 -0400", hash_original_method = "8F06EBB42FF76B1717D428E4F6418D97", hash_generated_method = "D83BF6BB1339F9DC1BC68874B11932BC")
    public  OverScroller(Context context, Interpolator interpolator, boolean flywheel) {
        mInterpolator = interpolator;
        mFlywheel = flywheel;
        mScrollerX = new SplineOverScroller();
        mScrollerY = new SplineOverScroller();
        SplineOverScroller.initFromContext(context);
        addTaint(context.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.307 -0400", hash_original_method = "0CF9495AD70A3403C1A28AE06C2DFE6A", hash_generated_method = "DE2AB8B9A99186821FBEB62E512C3DE5")
    public  OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY) {
        this(context, interpolator, true);
        addTaint(context.getTaint());
        addTaint(interpolator.getTaint());
        addTaint(bounceCoefficientX);
        addTaint(bounceCoefficientY);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.307 -0400", hash_original_method = "229999978F856549CB121738FDE882C4", hash_generated_method = "D1694FB3B2BBB729C4E6DC723A36120A")
    public  OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        this(context, interpolator, flywheel);
        addTaint(context.getTaint());
        addTaint(interpolator.getTaint());
        addTaint(bounceCoefficientX);
        addTaint(bounceCoefficientY);
        addTaint(flywheel);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.307 -0400", hash_original_method = "E258F8966760114615A66C59C43DDBF7", hash_generated_method = "BCF8314E4838D01BC314FFB89D1B8029")
    public final void setFriction(float friction) {
        mScrollerX.setFriction(friction);
        mScrollerY.setFriction(friction);
        addTaint(friction);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.308 -0400", hash_original_method = "C0D588953F48F0F49E401C0010BD067A", hash_generated_method = "0139449470BBA71A2D896C2FA3ED805E")
    public final boolean isFinished() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970633312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_970633312;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.308 -0400", hash_original_method = "530BF62F40D21F1D1C05E22ECA085B25", hash_generated_method = "9E50CA69CA03FFBAA94AC2B7585A2958")
    public final void forceFinished(boolean finished) {
        mScrollerX.mFinished = mScrollerY.mFinished = finished;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.308 -0400", hash_original_method = "935C47FB8A3CB470F597BC28E107035C", hash_generated_method = "A67D824AE5F9D2D2C44DD7E83E4B7E2C")
    public final int getCurrX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352251420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352251420;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.309 -0400", hash_original_method = "4ECEC07425ABC9DEFD7B203A5114566B", hash_generated_method = "4C614369371AF6FF008134129BA126E5")
    public final int getCurrY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884125904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884125904;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.309 -0400", hash_original_method = "64BF41B2D89FD1AD797ACAED97E05500", hash_generated_method = "1C48883D46B8985EBDA93D19AF59FB63")
    public float getCurrVelocity() {
        float squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        float varD836AEECDA15973F990993130D0A04EB_2117839630 = (FloatMath.sqrt(squaredNorm));
        float var546ADE640B6EDFBC8A086EF31347E768_242176286 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_242176286;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.310 -0400", hash_original_method = "99101D94CAA5BDB5F4107BC8C52E5814", hash_generated_method = "BE2D5715B10BB353CDF2ABB4239FA573")
    public final int getStartX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696415008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696415008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.310 -0400", hash_original_method = "C3B7BC19CF57D40812EE2941701D8011", hash_generated_method = "FF5960DB09499A1E99062466FBB54223")
    public final int getStartY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078686703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1078686703;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.310 -0400", hash_original_method = "B59ED352B9AEDA78AFFC00B7CFC03926", hash_generated_method = "2826EB2437E18A52EACADE0CB06E0822")
    public final int getFinalX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045346536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045346536;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.310 -0400", hash_original_method = "35D86359302D602175EC68518CA83146", hash_generated_method = "0338150627F50B7D608D452C1300FE48")
    public final int getFinalY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384100990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384100990;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.311 -0400", hash_original_method = "9AE57030D7C8A0E7D6E4B9C3569B7863", hash_generated_method = "0078C4C2184AA068C8E07136D4594C9D")
    @Deprecated
    public final int getDuration() {
        int var2AE19ED6BFD3EE2A01F12C594E911C5B_1741411401 = (Math.max(mScrollerX.mDuration, mScrollerY.mDuration));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426817718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426817718;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.311 -0400", hash_original_method = "C8E559EF6FD22D868574182D9D2BCAF9", hash_generated_method = "85174D09178AD20C6307E259B2250F79")
    @Deprecated
    public void extendDuration(int extend) {
        mScrollerX.extendDuration(extend);
        mScrollerY.extendDuration(extend);
        addTaint(extend);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.311 -0400", hash_original_method = "21D9AD21BF731806972ABE02338AD0C0", hash_generated_method = "878798B17F47A9CDD4BEC2239BE950F0")
    @Deprecated
    public void setFinalX(int newX) {
        mScrollerX.setFinalPosition(newX);
        addTaint(newX);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.311 -0400", hash_original_method = "300115417BC2D028444CA0676224C129", hash_generated_method = "2B2791683CA13518092063DB4DC4F7CD")
    @Deprecated
    public void setFinalY(int newY) {
        mScrollerY.setFinalPosition(newY);
        addTaint(newY);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.312 -0400", hash_original_method = "4391FF82C7FA76BDB2CDCD1D85612F8D", hash_generated_method = "E828894428CE42A4835061B9C21D4FA3")
    public boolean computeScrollOffset() {
        {
            boolean var802B4329042ED423187FD338A790F5A6_1891165806 = (isFinished());
        } 
        
        long time = AnimationUtils.currentAnimationTimeMillis();
        
        
        final long elapsedTime = time - mScrollerX.mStartTime;
        
        
        final int duration = mScrollerX.mDuration;
        
        
        {
            float q = (float) (elapsedTime) / duration;
            {
                q = Scroller.viscousFluid(q);
            } 
            {
                q = mInterpolator.getInterpolation(q);
            } 
            mScrollerX.updateScroll(q);
            mScrollerY.updateScroll(q);
        } 
        {
            abortAnimation();
        } 
        
        
        {
            {
                boolean varBFDC0FB1B43EB7BCC4E9E82DEDCD9FC2_1852426744 = (!mScrollerX.update());
                {
                    {
                        boolean varC9F451BE971CCB0A82BBE1EBE98D8511_626426099 = (!mScrollerX.continueWhenFinished());
                        {
                            mScrollerX.finish();
                        } 
                    } 
                } 
            } 
        } 
        
        
        {
            {
                boolean var139B509336DC22E8B49FCE36B537A826_386948877 = (!mScrollerY.update());
                {
                    {
                        boolean var4B1E7AEBADA7A1365CA571D290BAD045_526801840 = (!mScrollerY.continueWhenFinished());
                        {
                            mScrollerY.finish();
                        } 
                    } 
                } 
            } 
        } 
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142800624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142800624;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.312 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "A07157DD1E11902F09548DA565746592")
    public void startScroll(int startX, int startY, int dx, int dy) {
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        addTaint(startX);
        addTaint(startY);
        addTaint(dx);
        addTaint(dy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.313 -0400", hash_original_method = "C7C9FE1639F9BA6211C746BC2E590EF8", hash_generated_method = "452D72A59FCC3AFBE64D318B53F21E2B")
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        mMode = SCROLL_MODE;
        mScrollerX.startScroll(startX, dx, duration);
        mScrollerY.startScroll(startY, dy, duration);
        addTaint(startX);
        addTaint(startY);
        addTaint(dx);
        addTaint(dy);
        addTaint(duration);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.313 -0400", hash_original_method = "E8D7F5B96D38EF5E598258BCD9688B52", hash_generated_method = "BFB92622A289F192F8F7E47C5DDA3DE6")
    public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        mMode = FLING_MODE;
        final boolean spingbackX = mScrollerX.springback(startX, minX, maxX);
        final boolean spingbackY = mScrollerY.springback(startY, minY, maxY);
        addTaint(startX);
        addTaint(startY);
        addTaint(minX);
        addTaint(maxX);
        addTaint(minY);
        addTaint(maxY);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92629821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92629821;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.313 -0400", hash_original_method = "DCC04315E1B3C3B4106F742F922D4431", hash_generated_method = "9DDA62B89487E25EE2B710DEA2345440")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
        addTaint(startX);
        addTaint(startY);
        addTaint(velocityX);
        addTaint(velocityY);
        addTaint(minX);
        addTaint(maxX);
        addTaint(minY);
        addTaint(maxY);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.314 -0400", hash_original_method = "38A7A19069D4290FC9AB0139CD44ADE1", hash_generated_method = "EF617B04537100E23176B3F98E3E4A4C")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY, int overX, int overY) {
        {
            boolean var4A1974E054BEFB6E3D74B06DA75F60CA_1681147947 = (mFlywheel && !isFinished());
            {
                float oldVelocityX = mScrollerX.mCurrVelocity;
                float oldVelocityY = mScrollerY.mCurrVelocity;
                {
                    boolean var66E0F4DCA5BEAF4B3B81E945E420E9B0_395732283 = (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY));
                    {
                        velocityX += oldVelocityX;
                        velocityY += oldVelocityY;
                    } 
                } 
            } 
        } 
        mMode = FLING_MODE;
        mScrollerX.fling(startX, velocityX, minX, maxX, overX);
        mScrollerY.fling(startY, velocityY, minY, maxY, overY);
        addTaint(startX);
        addTaint(startY);
        addTaint(velocityX);
        addTaint(velocityY);
        addTaint(minX);
        addTaint(maxX);
        addTaint(minY);
        addTaint(maxY);
        addTaint(overX);
        addTaint(overY);
        
        
            
            
            
                    
                
                
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.314 -0400", hash_original_method = "B9132D3CC6E7407A65F178898D94F282", hash_generated_method = "858F9726B4256E4CA817B1C33AFEFCE6")
    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        mScrollerX.notifyEdgeReached(startX, finalX, overX);
        addTaint(startX);
        addTaint(finalX);
        addTaint(overX);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.314 -0400", hash_original_method = "EAACB5866396964CA4004FBBF9350F29", hash_generated_method = "097C45C2369177B8DE722E650F0CC61A")
    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        mScrollerY.notifyEdgeReached(startY, finalY, overY);
        addTaint(startY);
        addTaint(finalY);
        addTaint(overY);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.315 -0400", hash_original_method = "AE5D891ECDFB8C77EC70A4859A3A8CFD", hash_generated_method = "09BF73D01902984F6DCBBC3227580A01")
    public boolean isOverScrolled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947946922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947946922;
        
        
                
                
                        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.315 -0400", hash_original_method = "E56D99D09F46A8AEF8DD628D53F963A5", hash_generated_method = "694AEC3319AADB935EA112A7C19DD2CD")
    public void abortAnimation() {
        mScrollerX.finish();
        mScrollerY.finish();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.315 -0400", hash_original_method = "6776820FB8E88CBACCBB30EFABCCA565", hash_generated_method = "062F8527EB3497B441EBC0883017E4A1")
    public int timePassed() {
        final long time = AnimationUtils.currentAnimationTimeMillis();
        final long startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233467220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1233467220;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.315 -0400", hash_original_method = "EC43B1555D38CD3A665472CFA4E77643", hash_generated_method = "C4D0C7AFA2CD8488B3C2502CBA15BF05")
    public boolean isScrollingInDirection(float xvel, float yvel) {
        final int dx = mScrollerX.mFinal - mScrollerX.mStart;
        final int dy = mScrollerY.mFinal - mScrollerY.mStart;
        boolean var28334FACC04D30BF12E042D6701FB467_274088395 = (!isFinished() && Math.signum(xvel) == Math.signum(dx) &&
                Math.signum(yvel) == Math.signum(dy));
        addTaint(xvel);
        addTaint(yvel);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105692729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_105692729;
        
        
        
        
                
    }

    
    static class SplineOverScroller {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "3410B4CF3B02AE7E9DFF04AC988DEDAB", hash_generated_field = "FE13D76CBAD645EF7CF68CBEE24BE852")

        private int mCurrentPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "E735B6B9FC33B7D3DDA6CD440F3BDA15", hash_generated_field = "11513992D0933717F94CBC19E723AC8C")

        private int mFinal;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "437EB8FD5FAD507D203D1F22AFAD95FB", hash_generated_field = "85E3A40D11424915EEDA19E22E0F1268")

        private int mVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "585D09384A00A2898F6C021E2CD6B799", hash_generated_field = "3B97D5E15B121E7CEE691E293BAEE40C")

        private float mCurrVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "04F2FB84FDBD333F0C6C423EA089E199", hash_generated_field = "C2BDDF1F4D015B5A70949ADE337CCAA9")

        private float mDeceleration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

        private long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

        private int mDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "D9F1174C11A50E30D4D2EF5301FC1791", hash_generated_field = "721D132701D554EDB5BAB6B0C82BA2AD")

        private int mSplineDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "6A2B1FFA8C7EF9E3845D87D0202265ED", hash_generated_field = "FB2527AAF2413392A894AD48A7665B3E")

        private int mSplineDistance;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

        private boolean mFinished;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "BD54FBF848D5ACDCFBD61A19868B4171", hash_generated_field = "7BDE7217F050298D12691D81F08CF1E5")

        private int mOver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "FFFEDF9CA49C0A23F2EACA5C73F0331B", hash_generated_field = "EC2A2C9A1BD34813CE9F1C74E40F5693")

        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_field = "4D387E60D28A59AEF7F7EF6073B1479C", hash_generated_field = "2497C3234CC32F88C528B3987263033C")

        private int mState = SPLINE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.316 -0400", hash_original_method = "D0177E162854BD0B51587B46D28F0B6A", hash_generated_method = "8DA67F7E3849D2B57321066409F02625")
          SplineOverScroller() {
            mFinished = true;
            
            
        }

        
        static void initFromContext(Context context) {
            final float ppi = context.getResources().getDisplayMetrics().density * 160.0f;
            PHYSICAL_COEF = SensorManager.GRAVITY_EARTH 
                    * 39.37f 
                    * ppi
                    * 0.84f;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.317 -0400", hash_original_method = "9532D02E94E4EAFA434C124BD0A8F760", hash_generated_method = "9C1BF5881133CE15D3AD6937E2102C77")
         void setFriction(float friction) {
            mFlingFriction = friction;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.317 -0400", hash_original_method = "64F0298C66739A6C01CABFBC1A2B2075", hash_generated_method = "8D0066CC0B7F2B3783E5F9BC60951860")
         void updateScroll(float q) {
            mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
            
            
        }

        
        @DSModeled(DSC.SAFE)
        static private float getDeceleration(int velocity) {
            return velocity > 0 ? -GRAVITY : GRAVITY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.318 -0400", hash_original_method = "97FBA6B7752D67B719405DAE507B2D91", hash_generated_method = "7125132B58A7EC63922267C4614E12BE")
        private void adjustDuration(int start, int oldFinal, int newFinal) {
            final int oldDistance = oldFinal - start;
            final int newDistance = newFinal - start;
            final float x = Math.abs((float) newDistance / oldDistance);
            final int index = (int) (NB_SAMPLES * x);
            {
                final float x_inf = (float) index / NB_SAMPLES;
                final float x_sup = (float) (index + 1) / NB_SAMPLES;
                final float t_inf = SPLINE_TIME[index];
                final float t_sup = SPLINE_TIME[index + 1];
                final float timeCoef = t_inf + (x - x_inf) / (x_sup - x_inf) * (t_sup - t_inf);
                mDuration *= timeCoef;
            } 
            addTaint(start);
            addTaint(oldFinal);
            addTaint(newFinal);
            
            
            
            
            
            
                
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.318 -0400", hash_original_method = "171266C35C248ABBEE6A2AAA833A0F85", hash_generated_method = "9E2FAA2015CD1CEF96EC33E5FACB2540")
         void startScroll(int start, int distance, int duration) {
            mFinished = false;
            mStart = start;
            mFinal = start + distance;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = duration;
            mDeceleration = 0.0f;
            mVelocity = 0;
            
            
            
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.319 -0400", hash_original_method = "435B8A6291C462C3A88DC285D8A7A1BB", hash_generated_method = "E81E47C77DE0F2409607E7F653A93387")
         void finish() {
            mCurrentPosition = mFinal;
            mFinished = true;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.319 -0400", hash_original_method = "0F10BE4F5BE9DF7795DBE421341ADDA6", hash_generated_method = "AD197AA15C3F2929E140667F0D116CA7")
         void setFinalPosition(int position) {
            mFinal = position;
            mFinished = false;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.320 -0400", hash_original_method = "7F220CB7E5E59F74D99C7454C47E42C7", hash_generated_method = "F3F2BE72F53D1A8F05BB2994680DD4A5")
         void extendDuration(int extend) {
            final long time = AnimationUtils.currentAnimationTimeMillis();
            final int elapsedTime = (int) (time - mStartTime);
            mDuration = elapsedTime + extend;
            mFinished = false;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.321 -0400", hash_original_method = "D12AE2ECF55023F539A88C111AC438E6", hash_generated_method = "94B328FF98B6FA83B0337851691977CB")
         boolean springback(int start, int min, int max) {
            mFinished = true;
            mStart = mFinal = start;
            mVelocity = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = 0;
            {
                startSpringback(start, min, 0);
            } 
            {
                startSpringback(start, max, 0);
            } 
            addTaint(min);
            addTaint(max);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353141787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353141787;
            
            
            
            
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.322 -0400", hash_original_method = "FE4DCB4600DDD23F75B042FA5167B4E7", hash_generated_method = "23A8A4EC4AE0716AE81D420648486F75")
        private void startSpringback(int start, int end, int velocity) {
            mFinished = false;
            mState = CUBIC;
            mStart = start;
            mFinal = end;
            final int delta = start - end;
            mDeceleration = getDeceleration(delta);
            mVelocity = -delta;
            mOver = Math.abs(delta);
            mDuration = (int) (1000.0 * Math.sqrt(-2.0 * delta / mDeceleration));
            addTaint(velocity);
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.323 -0400", hash_original_method = "8B3E33053E001BDAB851E620AED14FC0", hash_generated_method = "661E7F0F2B1ACEA065308900E9688269")
         void fling(int start, int velocity, int min, int max, int over) {
            mOver = over;
            mFinished = false;
            mCurrVelocity = mVelocity = velocity;
            mDuration = mSplineDuration = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mCurrentPosition = mStart = start;
            {
                startAfterEdge(start, min, max, velocity);
            } 
            mState = SPLINE;
            double totalDistance = 0.0;
            {
                mDuration = mSplineDuration = getSplineFlingDuration(velocity);
                totalDistance = getSplineFlingDistance(velocity);
            } 
            mSplineDistance = (int) (totalDistance * Math.signum(velocity));
            mFinal = start + mSplineDistance;
            {
                adjustDuration(mStart, mFinal, min);
                mFinal = min;
            } 
            {
                adjustDuration(mStart, mFinal, max);
                mFinal = max;
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.323 -0400", hash_original_method = "55451D958AF332430844B13377F10B18", hash_generated_method = "E51B08B20417EFBA7E6D90320D689A86")
        private double getSplineDeceleration(int velocity) {
            double var13DD5CC47FE607CEAB2EC46D75E485B4_2113542989 = (Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF)));
            addTaint(velocity);
            double varE8CD7DA078A86726031AD64F35F5A6C0_569648772 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_569648772;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.323 -0400", hash_original_method = "7888FBEE8D14061C2ED981410CC88AC0", hash_generated_method = "DD5502DC3046E2EC785658D5B9E8F8BE")
        private double getSplineFlingDistance(int velocity) {
            final double l = getSplineDeceleration(velocity);
            final double decelMinusOne = DECELERATION_RATE - 1.0;
            double var1AE4D1075C6295F76A964E4AD022A173_12797218 = (mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l));
            addTaint(velocity);
            double varE8CD7DA078A86726031AD64F35F5A6C0_1860913108 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1860913108;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.324 -0400", hash_original_method = "1F09855DFC7D15DA5ECD081A4B3F581B", hash_generated_method = "0AEE285D67351AB356AB8E544300D8D9")
        private int getSplineFlingDuration(int velocity) {
            final double l = getSplineDeceleration(velocity);
            final double decelMinusOne = DECELERATION_RATE - 1.0;
            int varE02D490CB65208CB9281B455204D3B5C_129140554 = ((int) (1000.0 * Math.exp(l / decelMinusOne)));
            addTaint(velocity);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378434685 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378434685;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.324 -0400", hash_original_method = "C51353CD784B93D7179DA830597304C4", hash_generated_method = "AC31F53CF15FE6169C73FE1B09FE8F71")
        private void fitOnBounceCurve(int start, int end, int velocity) {
            final float durationToApex = - velocity / mDeceleration;
            final float distanceToApex = velocity * velocity / 2.0f / Math.abs(mDeceleration);
            final float distanceToEdge = Math.abs(end - start);
            final float totalDuration = (float) Math.sqrt(
                    2.0 * (distanceToApex + distanceToEdge) / Math.abs(mDeceleration));
            mStartTime -= (int) (1000.0f * (totalDuration - durationToApex));
            mStart = end;
            mVelocity = (int) (- mDeceleration * totalDuration);
            addTaint(start);
            addTaint(velocity);
            
            
            
            
            
                    
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.325 -0400", hash_original_method = "5D48F28010F8FCB9211B58C3C36EC8CC", hash_generated_method = "280DD2F3E3E96A08E6F9099B68AC4415")
        private void startBounceAfterEdge(int start, int end, int velocity) {
            mDeceleration = getDeceleration(velocity == 0 ? start - end : velocity);
            fitOnBounceCurve(start, end, velocity);
            onEdgeReached();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.325 -0400", hash_original_method = "E644EF955DC6FD722F53E2DD199A395E", hash_generated_method = "D139C989E59D8E4FFE6A44651B03B295")
        private void startAfterEdge(int start, int min, int max, int velocity) {
            {
                mFinished = true;
            } 
            final boolean positive = start > max;
            int edge;
            edge = max;
            edge = min;
            final int overDistance = start - edge;
            boolean keepIncreasing = overDistance * velocity >= 0;
            {
                startBounceAfterEdge(start, edge, velocity);
            } 
            {
                final double totalDistance = getSplineFlingDistance(velocity);
                {
                    boolean varAFFBEB20AB3CF5CAE72A649B507B5311_1535090702 = (totalDistance > Math.abs(overDistance));
                    {
                        fling(start, velocity, positive ? min : start, positive ? start : max, mOver);
                    } 
                    {
                        startSpringback(start, edge, velocity);
                    } 
                } 
            } 
            addTaint(start);
            addTaint(min);
            addTaint(max);
            addTaint(velocity);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.325 -0400", hash_original_method = "D032297ACDC9C65A50161DCB548F10DC", hash_generated_method = "B7052428C321C2D1A1F5E1E1AD6C490A")
         void notifyEdgeReached(int start, int end, int over) {
            {
                mOver = over;
                mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(start, end, end, (int) mCurrVelocity);
            } 
            addTaint(start);
            addTaint(end);
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.326 -0400", hash_original_method = "4D9D443F2B4C6EC9AAAB1FF452014EB4", hash_generated_method = "6BEAC61D676D262E732DA6F92CCDA463")
        private void onEdgeReached() {
            float distance = mVelocity * mVelocity / (2.0f * Math.abs(mDeceleration));
            final float sign = Math.signum(mVelocity);
            {
                mDeceleration = - sign * mVelocity * mVelocity / (2.0f * mOver);
                distance = mOver;
            } 
            mOver = (int) distance;
            mState = BALLISTIC;
            mFinal = mStart + (int) (mVelocity > 0 ? distance : -distance);
            mDuration = - (int) (1000.0f * mVelocity / mDeceleration);
            
            
            
            
                 
                 
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.326 -0400", hash_original_method = "6FDA077121143820AC37360810DDE80A", hash_generated_method = "0BD4078BDC58890537835A582065003C")
         boolean continueWhenFinished() {
            
            {
                mStart = mFinal;
                mVelocity = (int) mCurrVelocity;
                mDeceleration = getDeceleration(mVelocity);
                mStartTime += mDuration;
                onEdgeReached();
            } 
            
            
            mStartTime += mDuration;
            
            
            startSpringback(mFinal, mStart, 0);
            
            update();
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179551589 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_179551589;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_method = "36FADD2423F4A31EF1611CA012E37B33", hash_generated_method = "9054D2C8574597D8D65407B709EA3B38")
         boolean update() {
            final long time = AnimationUtils.currentAnimationTimeMillis();
            final long currentTime = time - mStartTime;
            double distance = 0.0;
            
            {
                final float t = (float) currentTime / mSplineDuration;
                final int index = (int) (NB_SAMPLES * t);
                float distanceCoef = 1.f;
                float velocityCoef = 0.f;
                {
                    final float t_inf = (float) index / NB_SAMPLES;
                    final float t_sup = (float) (index + 1) / NB_SAMPLES;
                    final float d_inf = SPLINE_POSITION[index];
                    final float d_sup = SPLINE_POSITION[index + 1];
                    velocityCoef = (d_sup - d_inf) / (t_sup - t_inf);
                    distanceCoef = d_inf + (t - t_inf) * velocityCoef;
                } 
                distance = distanceCoef * mSplineDistance;
                mCurrVelocity = velocityCoef * mSplineDistance / mSplineDuration * 1000.0f;
            } 
            
            
            {
                final float t = currentTime / 1000.0f;
                mCurrVelocity = mVelocity + mDeceleration * t;
                distance = mVelocity * t + mDeceleration * t * t / 2.0f;
            } 
            
            
            {
                final float t = (float) (currentTime) / mDuration;
                final float t2 = t * t;
                final float sign = Math.signum(mVelocity);
                distance = sign * mOver * (3.0f * t2 - 2.0f * t * t2);
                mCurrVelocity = sign * mOver * 6.0f * (- t + t2);
            } 
            
            mCurrentPosition = mStart + (int) Math.round(distance);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373748508 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373748508;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "A3FC3FB3EBD69D2BC874FC42BC7E6189", hash_generated_field = "D27F709E38E95ABA41086ACB25759594")

        private static final float GRAVITY = 2000.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "2FBECDA6893099F480BB4DC681C8C5E5", hash_generated_field = "7154ED1E434BAFBB8BDDE7F776B01524")

        private static float PHYSICAL_COEF;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "23B45F68927597F4A3A8E640CA74B7FE", hash_generated_field = "D7A6A768456D7CA540BA35C2F5F4CAF3")

        private static float DECELERATION_RATE = (float) (Math.log(0.78) / Math.log(0.9));
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "689F71BA9DB511ABCD8E82B9A932323E", hash_generated_field = "F5AF9FD0335D28F24C02B98871C19D36")

        private static final float INFLEXION = 0.35f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "4B975D8F94FD867DCE3AE8395585827A", hash_generated_field = "A93A505D9C6A8EC9F395D0DADBA4FB3A")

        private static final float START_TENSION = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "0EEE270B858721887FD277A7CB7134D3", hash_generated_field = "E5BC907466FF72E47B72F7A5358BEBA3")

        private static final float END_TENSION = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "4A46C92BE033DFCF5B5A8839976B63C8", hash_generated_field = "07503A6558E00C157F6DAEB1FFF235FB")

        private static final float P1 = START_TENSION * INFLEXION;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "90972E8FCA39F7F9F2788BF2C834FC96", hash_generated_field = "AED1851DFEA041A28688E66279A924B5")

        private static final float P2 = 1.0f - END_TENSION * (1.0f - INFLEXION);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.327 -0400", hash_original_field = "0974E8FC7A93081E4C491C4AFD29D565", hash_generated_field = "3B6A479A94E023469276FA3773CA8C8D")

        private static final int NB_SAMPLES = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "D935E5334A007EC009654F9DA1820D37", hash_generated_field = "AFB1C8ECA979DA21163AB6B7EDBBE826")

        private static final float[] SPLINE_POSITION = new float[NB_SAMPLES + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "059AA0D92B7C7D177C729212899DCC6C", hash_generated_field = "54A23A411E21AEAF5076D8B767D6B0BA")

        private static final float[] SPLINE_TIME = new float[NB_SAMPLES + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "4F6750B447C28B81E55F69899C3E63E7", hash_generated_field = "AA9C489F36CD6D35B08E97A0F1D114BF")

        private static final int SPLINE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "5D4DD2356F66B98C6362168C03760082", hash_generated_field = "C623FEAD42C4A32B51D627806375CF8A")

        private static final int CUBIC = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "30BBDC1E753102EDED0BDEB90A544159", hash_generated_field = "DD51F66F60B0FB6BDDD97689538B82F5")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "CE9861B4DE523D1EC20661AA772D40A0", hash_generated_field = "71A034DCC41856FE859BC1F065FC4DA6")

    private static final int DEFAULT_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "F504EA849E0919286438EDA205B8A9E4", hash_generated_field = "A767E7A0CD4C56577AF1FE7F420CA686")

    private static final int SCROLL_MODE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.328 -0400", hash_original_field = "FDE5999E3553362156971D68664D6C5B", hash_generated_field = "F3B8A415FA7A0B0422B61C4A171BBABD")

    private static final int FLING_MODE = 1;
}

