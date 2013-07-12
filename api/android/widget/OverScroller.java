package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.hardware.SensorManager;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.682 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.682 -0400", hash_original_field = "3D9BF56A145B7A388A1FA15E02CE0CE1", hash_generated_field = "9FFB811B26F4EA1D9264A27559A21A04")

    private SplineOverScroller mScrollerX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.682 -0400", hash_original_field = "5C2E45939A356352B1EBE2C26A8AA079", hash_generated_field = "2EB0A894343F6510CC074954C4F3CB9E")

    private SplineOverScroller mScrollerY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.682 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.682 -0400", hash_original_field = "0674FBD78043F84E1B63598E85DD9F83", hash_generated_field = "DB496AACF49E477CC5F54743876A46FF")

    private boolean mFlywheel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.706 -0400", hash_original_method = "B9802AB7FB2D6944C0543E71DB189BC5", hash_generated_method = "398A849B67626D49F95C7274A5C25CD9")
    public  OverScroller(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.706 -0400", hash_original_method = "F6227ED49D62C3697D2AC005A8942714", hash_generated_method = "DAF54356F4F3FB8CD0C05D29B935FAA6")
    public  OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
        addTaint(interpolator.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.706 -0400", hash_original_method = "8F06EBB42FF76B1717D428E4F6418D97", hash_generated_method = "6CC70F0454D9E7BF867254450C7A84AC")
    public  OverScroller(Context context, Interpolator interpolator, boolean flywheel) {
        addTaint(context.getTaint());
        mInterpolator = interpolator;
        mFlywheel = flywheel;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.706 -0400", hash_original_method = "0CF9495AD70A3403C1A28AE06C2DFE6A", hash_generated_method = "842488CA505C8C5F857E3EFD8901C95D")
    public  OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY) {
        this(context, interpolator, true);
        addTaint(bounceCoefficientY);
        addTaint(bounceCoefficientX);
        addTaint(interpolator.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.706 -0400", hash_original_method = "229999978F856549CB121738FDE882C4", hash_generated_method = "B0D2205542EC6B00530226F5B6D0A240")
    public  OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        this(context, interpolator, flywheel);
        addTaint(flywheel);
        addTaint(bounceCoefficientY);
        addTaint(bounceCoefficientX);
        addTaint(interpolator.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.706 -0400", hash_original_method = "E258F8966760114615A66C59C43DDBF7", hash_generated_method = "634FC718808689B396CB1A2B49C6A7C4")
    public final void setFriction(float friction) {
        addTaint(friction);
        mScrollerX.setFriction(friction);
        mScrollerY.setFriction(friction);
        // ---------- Original Method ----------
        //mScrollerX.setFriction(friction);
        //mScrollerY.setFriction(friction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.706 -0400", hash_original_method = "C0D588953F48F0F49E401C0010BD067A", hash_generated_method = "838D551C632982096FD81D623D0D821E")
    public final boolean isFinished() {
        boolean var0DB3E8C2664749C2162B19E4B34C7E33_335384967 = (mScrollerX.mFinished && mScrollerY.mFinished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757156549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757156549;
        // ---------- Original Method ----------
        //return mScrollerX.mFinished && mScrollerY.mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "530BF62F40D21F1D1C05E22ECA085B25", hash_generated_method = "9E50CA69CA03FFBAA94AC2B7585A2958")
    public final void forceFinished(boolean finished) {
        mScrollerX.mFinished = mScrollerY.mFinished = finished;
        // ---------- Original Method ----------
        //mScrollerX.mFinished = mScrollerY.mFinished = finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "935C47FB8A3CB470F597BC28E107035C", hash_generated_method = "4576B281B0F8FA49AA883A37086BC0A7")
    public final int getCurrX() {
        int varE75ACE107022639662FD371651D0ECD4_713174610 = (mScrollerX.mCurrentPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989967846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989967846;
        // ---------- Original Method ----------
        //return mScrollerX.mCurrentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "4ECEC07425ABC9DEFD7B203A5114566B", hash_generated_method = "725F7D34190FDC822EC481AE05E4B19D")
    public final int getCurrY() {
        int varEEB998B463EDBD97DFFC5C9DD5E23B8C_220078511 = (mScrollerY.mCurrentPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409984584 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409984584;
        // ---------- Original Method ----------
        //return mScrollerY.mCurrentPosition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "64BF41B2D89FD1AD797ACAED97E05500", hash_generated_method = "0448CA423454B63EA0FB11E0D5E75BBD")
    public float getCurrVelocity() {
        float squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        float var0D3EE44E7D58B2E51656DE42409E7E5B_1386952104 = (FloatMath.sqrt(squaredNorm));
                float var546ADE640B6EDFBC8A086EF31347E768_642437897 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_642437897;
        // ---------- Original Method ----------
        //float squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        //squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        //return FloatMath.sqrt(squaredNorm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "99101D94CAA5BDB5F4107BC8C52E5814", hash_generated_method = "903EACCA02B2C7EAF34C4FFC5363BD54")
    public final int getStartX() {
        int varC1EC4CC35CCC1E65284382B0A8D20B69_1889386319 = (mScrollerX.mStart);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441654516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441654516;
        // ---------- Original Method ----------
        //return mScrollerX.mStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "C3B7BC19CF57D40812EE2941701D8011", hash_generated_method = "3372FE616F7E800BDBCFA490B750205D")
    public final int getStartY() {
        int var12006AA0EEBE106A7C70A4B89A5E77F1_707526296 = (mScrollerY.mStart);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121573783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121573783;
        // ---------- Original Method ----------
        //return mScrollerY.mStart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "B59ED352B9AEDA78AFFC00B7CFC03926", hash_generated_method = "1B72C42D2AC81604A3E74440E79BA75C")
    public final int getFinalX() {
        int varED7C18F876C06D7AE5954809EE1DB0C2_1114585178 = (mScrollerX.mFinal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337321715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1337321715;
        // ---------- Original Method ----------
        //return mScrollerX.mFinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "35D86359302D602175EC68518CA83146", hash_generated_method = "6EF8D9E76246AFE8253C5C712D2C2AF6")
    public final int getFinalY() {
        int var7F5919007196DB74ACF1C481429A74C3_57093733 = (mScrollerY.mFinal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714985772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_714985772;
        // ---------- Original Method ----------
        //return mScrollerY.mFinal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.707 -0400", hash_original_method = "9AE57030D7C8A0E7D6E4B9C3569B7863", hash_generated_method = "6E5559D406FD6A8276ACBE7FD4A112D0")
    @Deprecated
    public final int getDuration() {
        int var05ECFC23DD853D79411811CEBAF78CA7_1766647343 = (Math.max(mScrollerX.mDuration, mScrollerY.mDuration));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402556202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1402556202;
        // ---------- Original Method ----------
        //return Math.max(mScrollerX.mDuration, mScrollerY.mDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.708 -0400", hash_original_method = "C8E559EF6FD22D868574182D9D2BCAF9", hash_generated_method = "035670F369EFE5298CE10FF9C80A594D")
    @Deprecated
    public void extendDuration(int extend) {
        addTaint(extend);
        mScrollerX.extendDuration(extend);
        mScrollerY.extendDuration(extend);
        // ---------- Original Method ----------
        //mScrollerX.extendDuration(extend);
        //mScrollerY.extendDuration(extend);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.708 -0400", hash_original_method = "21D9AD21BF731806972ABE02338AD0C0", hash_generated_method = "B77FB4DA3B1FDFF3BEFF281ED53615DB")
    @Deprecated
    public void setFinalX(int newX) {
        addTaint(newX);
        mScrollerX.setFinalPosition(newX);
        // ---------- Original Method ----------
        //mScrollerX.setFinalPosition(newX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.708 -0400", hash_original_method = "300115417BC2D028444CA0676224C129", hash_generated_method = "4BD9E36BCFB7A0D51CDE9E0CCF8A3D9C")
    @Deprecated
    public void setFinalY(int newY) {
        addTaint(newY);
        mScrollerY.setFinalPosition(newY);
        // ---------- Original Method ----------
        //mScrollerY.setFinalPosition(newY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.708 -0400", hash_original_method = "4391FF82C7FA76BDB2CDCD1D85612F8D", hash_generated_method = "37223A6C5483F7F8D6FEBAB42587C45F")
    public boolean computeScrollOffset() {
    if(isFinished())        
        {
            boolean var68934A3E9455FA72420237EB05902327_956840900 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1442166863 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1442166863;
        } //End block
switch(mMode){
        case SCROLL_MODE:
        long time = AnimationUtils.currentAnimationTimeMillis();
        final long elapsedTime = time - mScrollerX.mStartTime;
        final int duration = mScrollerX.mDuration;
    if(elapsedTime < duration)        
        {
            float q = (float) (elapsedTime) / duration;
    if(mInterpolator == null)            
            {
                q = Scroller.viscousFluid(q);
            } //End block
            else
            {
                q = mInterpolator.getInterpolation(q);
            } //End block
            mScrollerX.updateScroll(q);
            mScrollerY.updateScroll(q);
        } //End block
        else
        {
            abortAnimation();
        } //End block
        break;
        case FLING_MODE:
    if(!mScrollerX.mFinished)        
        {
    if(!mScrollerX.update())            
            {
    if(!mScrollerX.continueWhenFinished())                
                {
                    mScrollerX.finish();
                } //End block
            } //End block
        } //End block
    if(!mScrollerY.mFinished)        
        {
    if(!mScrollerY.update())            
            {
    if(!mScrollerY.continueWhenFinished())                
                {
                    mScrollerY.finish();
                } //End block
            } //End block
        } //End block
        break;
}        boolean varB326B5062B2F0E69046810717534CB09_559788482 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213961644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_213961644;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.708 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "1BD8BF39BAE975497B125E48604D318A")
    public void startScroll(int startX, int startY, int dx, int dy) {
        addTaint(dy);
        addTaint(dx);
        addTaint(startY);
        addTaint(startX);
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        // ---------- Original Method ----------
        //startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.709 -0400", hash_original_method = "C7C9FE1639F9BA6211C746BC2E590EF8", hash_generated_method = "4E11F69F49362EDEA684F20DFD5C8145")
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        addTaint(duration);
        addTaint(dy);
        addTaint(dx);
        addTaint(startY);
        addTaint(startX);
        mMode = SCROLL_MODE;
        mScrollerX.startScroll(startX, dx, duration);
        mScrollerY.startScroll(startY, dy, duration);
        // ---------- Original Method ----------
        //mMode = SCROLL_MODE;
        //mScrollerX.startScroll(startX, dx, duration);
        //mScrollerY.startScroll(startY, dy, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.709 -0400", hash_original_method = "E8D7F5B96D38EF5E598258BCD9688B52", hash_generated_method = "78CD8A14B106CACDBBF7E7245140A5F8")
    public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        addTaint(maxY);
        addTaint(minY);
        addTaint(maxX);
        addTaint(minX);
        addTaint(startY);
        addTaint(startX);
        mMode = FLING_MODE;
        final boolean spingbackX = mScrollerX.springback(startX, minX, maxX);
        final boolean spingbackY = mScrollerY.springback(startY, minY, maxY);
        boolean varC1ED648D2E61098796875DC470ABF9DE_1119038789 = (spingbackX || spingbackY);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393811690 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_393811690;
        // ---------- Original Method ----------
        //mMode = FLING_MODE;
        //final boolean spingbackX = mScrollerX.springback(startX, minX, maxX);
        //final boolean spingbackY = mScrollerY.springback(startY, minY, maxY);
        //return spingbackX || spingbackY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.709 -0400", hash_original_method = "DCC04315E1B3C3B4106F742F922D4431", hash_generated_method = "32BB7C371040E1A992615FF47A09FB11")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        addTaint(maxY);
        addTaint(minY);
        addTaint(maxX);
        addTaint(minX);
        addTaint(velocityY);
        addTaint(velocityX);
        addTaint(startY);
        addTaint(startX);
        fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
        // ---------- Original Method ----------
        //fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.709 -0400", hash_original_method = "38A7A19069D4290FC9AB0139CD44ADE1", hash_generated_method = "F6BB98922F160AF882135EE5C3E34381")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY, int overX, int overY) {
        addTaint(overY);
        addTaint(overX);
        addTaint(maxY);
        addTaint(minY);
        addTaint(maxX);
        addTaint(minX);
        addTaint(velocityY);
        addTaint(velocityX);
        addTaint(startY);
        addTaint(startX);
    if(mFlywheel && !isFinished())        
        {
            float oldVelocityX = mScrollerX.mCurrVelocity;
            float oldVelocityY = mScrollerY.mCurrVelocity;
    if(Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY))            
            {
                velocityX += oldVelocityX;
                velocityY += oldVelocityY;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.710 -0400", hash_original_method = "B9132D3CC6E7407A65F178898D94F282", hash_generated_method = "DA1AEA04A0D08C9734D9C5E5CFCE5ADD")
    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        addTaint(overX);
        addTaint(finalX);
        addTaint(startX);
        mScrollerX.notifyEdgeReached(startX, finalX, overX);
        // ---------- Original Method ----------
        //mScrollerX.notifyEdgeReached(startX, finalX, overX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.710 -0400", hash_original_method = "EAACB5866396964CA4004FBBF9350F29", hash_generated_method = "93A8B191CAA35ACECD5DDA1B8237B6B5")
    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        addTaint(overY);
        addTaint(finalY);
        addTaint(startY);
        mScrollerY.notifyEdgeReached(startY, finalY, overY);
        // ---------- Original Method ----------
        //mScrollerY.notifyEdgeReached(startY, finalY, overY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.710 -0400", hash_original_method = "AE5D891ECDFB8C77EC70A4859A3A8CFD", hash_generated_method = "0AF84B406C42F8C52A5B21299F50BD50")
    public boolean isOverScrolled() {
        boolean varFF1CE4C5A06BCC73BF7837A045CE34BE_1742514417 = (((!mScrollerX.mFinished &&
                mScrollerX.mState != SplineOverScroller.SPLINE) ||
                (!mScrollerY.mFinished &&
                        mScrollerY.mState != SplineOverScroller.SPLINE)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_363584635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_363584635;
        // ---------- Original Method ----------
        //return ((!mScrollerX.mFinished &&
                //mScrollerX.mState != SplineOverScroller.SPLINE) ||
                //(!mScrollerY.mFinished &&
                        //mScrollerY.mState != SplineOverScroller.SPLINE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.710 -0400", hash_original_method = "E56D99D09F46A8AEF8DD628D53F963A5", hash_generated_method = "694AEC3319AADB935EA112A7C19DD2CD")
    public void abortAnimation() {
        mScrollerX.finish();
        mScrollerY.finish();
        // ---------- Original Method ----------
        //mScrollerX.finish();
        //mScrollerY.finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.710 -0400", hash_original_method = "6776820FB8E88CBACCBB30EFABCCA565", hash_generated_method = "1409883F9D945538518043DA76454577")
    public int timePassed() {
        final long time = AnimationUtils.currentAnimationTimeMillis();
        final long startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        int var35863F92DD27E0007B82481C3D494F55_2122668850 = ((int) (time - startTime));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228812551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228812551;
        // ---------- Original Method ----------
        //final long time = AnimationUtils.currentAnimationTimeMillis();
        //final long startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        //return (int) (time - startTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.710 -0400", hash_original_method = "EC43B1555D38CD3A665472CFA4E77643", hash_generated_method = "91BD7A1A6E4DFB65ACE0537A4346C6F9")
    public boolean isScrollingInDirection(float xvel, float yvel) {
        addTaint(yvel);
        addTaint(xvel);
        final int dx = mScrollerX.mFinal - mScrollerX.mStart;
        final int dy = mScrollerY.mFinal - mScrollerY.mStart;
        boolean varE061763E300FCF8D9ABFB7158AC0FE58_234720568 = (!isFinished() && Math.signum(xvel) == Math.signum(dx) &&
                Math.signum(yvel) == Math.signum(dy));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336491135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336491135;
        // ---------- Original Method ----------
        //final int dx = mScrollerX.mFinal - mScrollerX.mStart;
        //final int dy = mScrollerY.mFinal - mScrollerY.mStart;
        //return !isFinished() && Math.signum(xvel) == Math.signum(dx) &&
                //Math.signum(yvel) == Math.signum(dy);
    }

    
    static class SplineOverScroller {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "3410B4CF3B02AE7E9DFF04AC988DEDAB", hash_generated_field = "FE13D76CBAD645EF7CF68CBEE24BE852")

        private int mCurrentPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "E735B6B9FC33B7D3DDA6CD440F3BDA15", hash_generated_field = "11513992D0933717F94CBC19E723AC8C")

        private int mFinal;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "437EB8FD5FAD507D203D1F22AFAD95FB", hash_generated_field = "85E3A40D11424915EEDA19E22E0F1268")

        private int mVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "585D09384A00A2898F6C021E2CD6B799", hash_generated_field = "3B97D5E15B121E7CEE691E293BAEE40C")

        private float mCurrVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "04F2FB84FDBD333F0C6C423EA089E199", hash_generated_field = "C2BDDF1F4D015B5A70949ADE337CCAA9")

        private float mDeceleration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

        private long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

        private int mDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "D9F1174C11A50E30D4D2EF5301FC1791", hash_generated_field = "721D132701D554EDB5BAB6B0C82BA2AD")

        private int mSplineDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "6A2B1FFA8C7EF9E3845D87D0202265ED", hash_generated_field = "FB2527AAF2413392A894AD48A7665B3E")

        private int mSplineDistance;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

        private boolean mFinished;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "BD54FBF848D5ACDCFBD61A19868B4171", hash_generated_field = "7BDE7217F050298D12691D81F08CF1E5")

        private int mOver;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "FFFEDF9CA49C0A23F2EACA5C73F0331B", hash_generated_field = "EC2A2C9A1BD34813CE9F1C74E40F5693")

        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_field = "4D387E60D28A59AEF7F7EF6073B1479C", hash_generated_field = "2497C3234CC32F88C528B3987263033C")

        private int mState = SPLINE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_method = "D0177E162854BD0B51587B46D28F0B6A", hash_generated_method = "8DA67F7E3849D2B57321066409F02625")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_method = "9532D02E94E4EAFA434C124BD0A8F760", hash_generated_method = "9C1BF5881133CE15D3AD6937E2102C77")
         void setFriction(float friction) {
            mFlingFriction = friction;
            // ---------- Original Method ----------
            //mFlingFriction = friction;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.711 -0400", hash_original_method = "64F0298C66739A6C01CABFBC1A2B2075", hash_generated_method = "8D0066CC0B7F2B3783E5F9BC60951860")
         void updateScroll(float q) {
            mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
            // ---------- Original Method ----------
            //mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
        }

        
                static private float getDeceleration(int velocity) {
            return velocity > 0 ? -GRAVITY : GRAVITY;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.712 -0400", hash_original_method = "97FBA6B7752D67B719405DAE507B2D91", hash_generated_method = "6594E547C56E3A36410B7595C40B7C75")
        private void adjustDuration(int start, int oldFinal, int newFinal) {
            addTaint(newFinal);
            addTaint(oldFinal);
            addTaint(start);
            final int oldDistance = oldFinal - start;
            final int newDistance = newFinal - start;
            final float x = Math.abs((float) newDistance / oldDistance);
            final int index = (int) (NB_SAMPLES * x);
    if(index < NB_SAMPLES)            
            {
                final float x_inf = (float) index / NB_SAMPLES;
                final float x_sup = (float) (index + 1) / NB_SAMPLES;
                final float t_inf = SPLINE_TIME[index];
                final float t_sup = SPLINE_TIME[index + 1];
                final float timeCoef = t_inf + (x - x_inf) / (x_sup - x_inf) * (t_sup - t_inf);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.712 -0400", hash_original_method = "171266C35C248ABBEE6A2AAA833A0F85", hash_generated_method = "9E2FAA2015CD1CEF96EC33E5FACB2540")
         void startScroll(int start, int distance, int duration) {
            mFinished = false;
            mStart = start;
            mFinal = start + distance;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = duration;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.712 -0400", hash_original_method = "435B8A6291C462C3A88DC285D8A7A1BB", hash_generated_method = "E81E47C77DE0F2409607E7F653A93387")
         void finish() {
            mCurrentPosition = mFinal;
            mFinished = true;
            // ---------- Original Method ----------
            //mCurrentPosition = mFinal;
            //mFinished = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.712 -0400", hash_original_method = "0F10BE4F5BE9DF7795DBE421341ADDA6", hash_generated_method = "AD197AA15C3F2929E140667F0D116CA7")
         void setFinalPosition(int position) {
            mFinal = position;
            mFinished = false;
            // ---------- Original Method ----------
            //mFinal = position;
            //mFinished = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.712 -0400", hash_original_method = "7F220CB7E5E59F74D99C7454C47E42C7", hash_generated_method = "F3F2BE72F53D1A8F05BB2994680DD4A5")
         void extendDuration(int extend) {
            final long time = AnimationUtils.currentAnimationTimeMillis();
            final int elapsedTime = (int) (time - mStartTime);
            mDuration = elapsedTime + extend;
            mFinished = false;
            // ---------- Original Method ----------
            //final long time = AnimationUtils.currentAnimationTimeMillis();
            //final int elapsedTime = (int) (time - mStartTime);
            //mDuration = elapsedTime + extend;
            //mFinished = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.712 -0400", hash_original_method = "D12AE2ECF55023F539A88C111AC438E6", hash_generated_method = "101B7FFF378FC5F50092F73E9B1CB575")
         boolean springback(int start, int min, int max) {
            addTaint(max);
            addTaint(min);
            mFinished = true;
            mStart = mFinal = start;
            mVelocity = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = 0;
    if(start < min)            
            {
                startSpringback(start, min, 0);
            } //End block
            else
    if(start > max)            
            {
                startSpringback(start, max, 0);
            } //End block
            boolean varBA1DFB924614110F73DA701F03C6D8E5_1338681146 = (!mFinished);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135080680 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_135080680;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.713 -0400", hash_original_method = "FE4DCB4600DDD23F75B042FA5167B4E7", hash_generated_method = "FB332897CE3805816FC5084D5602688B")
        private void startSpringback(int start, int end, int velocity) {
            addTaint(velocity);
            mFinished = false;
            mState = CUBIC;
            mStart = start;
            mFinal = end;
            final int delta = start - end;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.713 -0400", hash_original_method = "8B3E33053E001BDAB851E620AED14FC0", hash_generated_method = "94DC951FB15E33E6D79F8DD133008A13")
         void fling(int start, int velocity, int min, int max, int over) {
            mOver = over;
            mFinished = false;
            mCurrVelocity = mVelocity = velocity;
            mDuration = mSplineDuration = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mCurrentPosition = mStart = start;
    if(start > max || start < min)            
            {
                startAfterEdge(start, min, max, velocity);
                return;
            } //End block
            mState = SPLINE;
            double totalDistance = 0.0;
    if(velocity != 0)            
            {
                mDuration = mSplineDuration = getSplineFlingDuration(velocity);
                totalDistance = getSplineFlingDistance(velocity);
            } //End block
            mSplineDistance = (int) (totalDistance * Math.signum(velocity));
            mFinal = start + mSplineDistance;
    if(mFinal < min)            
            {
                adjustDuration(mStart, mFinal, min);
                mFinal = min;
            } //End block
    if(mFinal > max)            
            {
                adjustDuration(mStart, mFinal, max);
                mFinal = max;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.713 -0400", hash_original_method = "55451D958AF332430844B13377F10B18", hash_generated_method = "E1883289D85EF8F9FA255B550D3A80B6")
        private double getSplineDeceleration(int velocity) {
            addTaint(velocity);
            double varD1B1C69D973DAA983C2D5D5F3D37A7A8_1815057466 = (Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF)));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1322202813 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1322202813;
            // ---------- Original Method ----------
            //return Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.714 -0400", hash_original_method = "7888FBEE8D14061C2ED981410CC88AC0", hash_generated_method = "B26C7C8C9104DFEEEC96E4E757EDEC82")
        private double getSplineFlingDistance(int velocity) {
            addTaint(velocity);
            final double l = getSplineDeceleration(velocity);
            final double decelMinusOne = DECELERATION_RATE - 1.0;
            double var06250AFF64F4FEEA8997F33C732E31AB_1025690956 = (mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1740711968 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1740711968;
            // ---------- Original Method ----------
            //final double l = getSplineDeceleration(velocity);
            //final double decelMinusOne = DECELERATION_RATE - 1.0;
            //return mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.714 -0400", hash_original_method = "1F09855DFC7D15DA5ECD081A4B3F581B", hash_generated_method = "D470A96CDF72ED9345D6C735E7F73A5B")
        private int getSplineFlingDuration(int velocity) {
            addTaint(velocity);
            final double l = getSplineDeceleration(velocity);
            final double decelMinusOne = DECELERATION_RATE - 1.0;
            int varD3A1E5768EC189059450180A81FF7CB5_711153397 = ((int) (1000.0 * Math.exp(l / decelMinusOne)));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750131435 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_750131435;
            // ---------- Original Method ----------
            //final double l = getSplineDeceleration(velocity);
            //final double decelMinusOne = DECELERATION_RATE - 1.0;
            //return (int) (1000.0 * Math.exp(l / decelMinusOne));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.714 -0400", hash_original_method = "C51353CD784B93D7179DA830597304C4", hash_generated_method = "9EA133680B2BE4FC0D342AFF09BCCFC5")
        private void fitOnBounceCurve(int start, int end, int velocity) {
            addTaint(velocity);
            addTaint(start);
            final float durationToApex = - velocity / mDeceleration;
            final float distanceToApex = velocity * velocity / 2.0f / Math.abs(mDeceleration);
            final float distanceToEdge = Math.abs(end - start);
            final float totalDuration = (float) Math.sqrt(
                    2.0 * (distanceToApex + distanceToEdge) / Math.abs(mDeceleration));
            mStartTime -= (int) (1000.0f * (totalDuration - durationToApex));
            mStart = end;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.714 -0400", hash_original_method = "5D48F28010F8FCB9211B58C3C36EC8CC", hash_generated_method = "280DD2F3E3E96A08E6F9099B68AC4415")
        private void startBounceAfterEdge(int start, int end, int velocity) {
            mDeceleration = getDeceleration(velocity == 0 ? start - end : velocity);
            fitOnBounceCurve(start, end, velocity);
            onEdgeReached();
            // ---------- Original Method ----------
            //mDeceleration = getDeceleration(velocity == 0 ? start - end : velocity);
            //fitOnBounceCurve(start, end, velocity);
            //onEdgeReached();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.714 -0400", hash_original_method = "E644EF955DC6FD722F53E2DD199A395E", hash_generated_method = "3BD0B0E62F177AD5B32E70444624654D")
        private void startAfterEdge(int start, int min, int max, int velocity) {
            addTaint(velocity);
            addTaint(max);
            addTaint(min);
            addTaint(start);
    if(start > min && start < max)            
            {
                mFinished = true;
                return;
            } //End block
            final boolean positive = start > max;
            final int edge = positive ? max : min;
            final int overDistance = start - edge;
            boolean keepIncreasing = overDistance * velocity >= 0;
    if(keepIncreasing)            
            {
                startBounceAfterEdge(start, edge, velocity);
            } //End block
            else
            {
                final double totalDistance = getSplineFlingDistance(velocity);
    if(totalDistance > Math.abs(overDistance))                
                {
                    fling(start, velocity, positive ? min : start, positive ? start : max, mOver);
                } //End block
                else
                {
                    startSpringback(start, edge, velocity);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.715 -0400", hash_original_method = "D032297ACDC9C65A50161DCB548F10DC", hash_generated_method = "487A51958ECA4EC8835BC9A8EB259BF7")
         void notifyEdgeReached(int start, int end, int over) {
            addTaint(end);
            addTaint(start);
    if(mState == SPLINE)            
            {
                mOver = over;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.715 -0400", hash_original_method = "4D9D443F2B4C6EC9AAAB1FF452014EB4", hash_generated_method = "8E44A0A909749DBAFFA723A78E5AB9A4")
        private void onEdgeReached() {
            float distance = mVelocity * mVelocity / (2.0f * Math.abs(mDeceleration));
            final float sign = Math.signum(mVelocity);
    if(distance > mOver)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.715 -0400", hash_original_method = "6FDA077121143820AC37360810DDE80A", hash_generated_method = "7127006D53C8537C9BB9043DFC344A72")
         boolean continueWhenFinished() {
switch(mState){
            case SPLINE:
    if(mDuration < mSplineDuration)            
            {
                mStart = mFinal;
                mVelocity = (int) mCurrVelocity;
                mDeceleration = getDeceleration(mVelocity);
                mStartTime += mDuration;
                onEdgeReached();
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_907954124 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887977260 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887977260;
            } //End block
            break;
            case BALLISTIC:
            mStartTime += mDuration;
            startSpringback(mFinal, mStart, 0);
            break;
            case CUBIC:
            boolean var68934A3E9455FA72420237EB05902327_14246718 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1991750582 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1991750582;
}            update();
            boolean varB326B5062B2F0E69046810717534CB09_1125919498 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1710753718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1710753718;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_method = "36FADD2423F4A31EF1611CA012E37B33", hash_generated_method = "7BC276A94E57DCDC48A6736925727585")
         boolean update() {
            final long time = AnimationUtils.currentAnimationTimeMillis();
            final long currentTime = time - mStartTime;
    if(currentTime > mDuration)            
            {
                boolean var68934A3E9455FA72420237EB05902327_863684547 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2019017628 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2019017628;
            } //End block
            double distance = 0.0;
switch(mState){
            case SPLINE:
            {
                final float t = (float) currentTime / mSplineDuration;
                final int index = (int) (NB_SAMPLES * t);
                float distanceCoef = 1.f;
                float velocityCoef = 0.f;
    if(index < NB_SAMPLES)                
                {
                    final float t_inf = (float) index / NB_SAMPLES;
                    final float t_sup = (float) (index + 1) / NB_SAMPLES;
                    final float d_inf = SPLINE_POSITION[index];
                    final float d_sup = SPLINE_POSITION[index + 1];
                    velocityCoef = (d_sup - d_inf) / (t_sup - t_inf);
                    distanceCoef = d_inf + (t - t_inf) * velocityCoef;
                } //End block
                distance = distanceCoef * mSplineDistance;
                mCurrVelocity = velocityCoef * mSplineDistance / mSplineDuration * 1000.0f;
                break;
            } //End block
            case BALLISTIC:
            {
                final float t = currentTime / 1000.0f;
                mCurrVelocity = mVelocity + mDeceleration * t;
                distance = mVelocity * t + mDeceleration * t * t / 2.0f;
                break;
            } //End block
            case CUBIC:
            {
                final float t = (float) (currentTime) / mDuration;
                final float t2 = t * t;
                final float sign = Math.signum(mVelocity);
                distance = sign * mOver * (3.0f * t2 - 2.0f * t * t2);
                mCurrVelocity = sign * mOver * 6.0f * (- t + t2);
                break;
            } //End block
}            mCurrentPosition = mStart + (int) Math.round(distance);
            boolean varB326B5062B2F0E69046810717534CB09_456606586 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65024279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_65024279;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_field = "A3FC3FB3EBD69D2BC874FC42BC7E6189", hash_generated_field = "D27F709E38E95ABA41086ACB25759594")

        private static final float GRAVITY = 2000.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_field = "2FBECDA6893099F480BB4DC681C8C5E5", hash_generated_field = "7154ED1E434BAFBB8BDDE7F776B01524")

        private static float PHYSICAL_COEF;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_field = "23B45F68927597F4A3A8E640CA74B7FE", hash_generated_field = "D7A6A768456D7CA540BA35C2F5F4CAF3")

        private static float DECELERATION_RATE = (float) (Math.log(0.78) / Math.log(0.9));
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_field = "689F71BA9DB511ABCD8E82B9A932323E", hash_generated_field = "F5AF9FD0335D28F24C02B98871C19D36")

        private static final float INFLEXION = 0.35f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_field = "4B975D8F94FD867DCE3AE8395585827A", hash_generated_field = "A93A505D9C6A8EC9F395D0DADBA4FB3A")

        private static final float START_TENSION = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_field = "0EEE270B858721887FD277A7CB7134D3", hash_generated_field = "E5BC907466FF72E47B72F7A5358BEBA3")

        private static final float END_TENSION = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.716 -0400", hash_original_field = "4A46C92BE033DFCF5B5A8839976B63C8", hash_generated_field = "07503A6558E00C157F6DAEB1FFF235FB")

        private static final float P1 = START_TENSION * INFLEXION;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.717 -0400", hash_original_field = "90972E8FCA39F7F9F2788BF2C834FC96", hash_generated_field = "AED1851DFEA041A28688E66279A924B5")

        private static final float P2 = 1.0f - END_TENSION * (1.0f - INFLEXION);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.717 -0400", hash_original_field = "0974E8FC7A93081E4C491C4AFD29D565", hash_generated_field = "3B6A479A94E023469276FA3773CA8C8D")

        private static final int NB_SAMPLES = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.717 -0400", hash_original_field = "D935E5334A007EC009654F9DA1820D37", hash_generated_field = "AFB1C8ECA979DA21163AB6B7EDBBE826")

        private static final float[] SPLINE_POSITION = new float[NB_SAMPLES + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.717 -0400", hash_original_field = "059AA0D92B7C7D177C729212899DCC6C", hash_generated_field = "54A23A411E21AEAF5076D8B767D6B0BA")

        private static final float[] SPLINE_TIME = new float[NB_SAMPLES + 1];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.717 -0400", hash_original_field = "4F6750B447C28B81E55F69899C3E63E7", hash_generated_field = "AA9C489F36CD6D35B08E97A0F1D114BF")

        private static final int SPLINE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.717 -0400", hash_original_field = "5D4DD2356F66B98C6362168C03760082", hash_generated_field = "C623FEAD42C4A32B51D627806375CF8A")

        private static final int CUBIC = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.719 -0400", hash_original_field = "30BBDC1E753102EDED0BDEB90A544159", hash_generated_field = "DD51F66F60B0FB6BDDD97689538B82F5")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.720 -0400", hash_original_field = "CE9861B4DE523D1EC20661AA772D40A0", hash_generated_field = "71A034DCC41856FE859BC1F065FC4DA6")

    private static final int DEFAULT_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.720 -0400", hash_original_field = "F504EA849E0919286438EDA205B8A9E4", hash_generated_field = "A767E7A0CD4C56577AF1FE7F420CA686")

    private static final int SCROLL_MODE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:08.720 -0400", hash_original_field = "FDE5999E3553362156971D68664D6C5B", hash_generated_field = "F3B8A415FA7A0B0422B61C4A171BBABD")

    private static final int FLING_MODE = 1;
}

