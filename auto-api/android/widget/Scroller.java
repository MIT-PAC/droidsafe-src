package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class Scroller {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.628 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.628 -0400", hash_original_field = "9801264300876A677AA3DC64764E3FC2", hash_generated_field = "28E51E686EEF26C8A77C03ED820E724F")

    private int mStartX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.628 -0400", hash_original_field = "D2D722716779C955F0ECDDD867837AC9", hash_generated_field = "2C4FD2F4594E993A1C0AA896A5F50971")

    private int mStartY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.628 -0400", hash_original_field = "0290041E535A652B7A5D076F92AD8748", hash_generated_field = "71B9BE40F3EB3F420DA51BED11A1FACC")

    private int mFinalX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "E945BD36FB44D6509A1812FCFC09A99C", hash_generated_field = "14970227CEB8B8463C037E05672A799A")

    private int mFinalY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "7CBEADDF3BF87C8E9592002066182081", hash_generated_field = "AD8B01E82643B27CD370F8D831F238C1")

    private int mMinX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "41704F54749AA189526CA9FAE67380B0", hash_generated_field = "B2C478BEE6C183081971A9B0A8AE4922")

    private int mMaxX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "9A9EF11E7F21CEC6B9588949DB8D8B36", hash_generated_field = "4011ABA5F49EA845B8922B89156403C8")

    private int mMinY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "E1883BCCD9952BD3FB3A6632B7B0AD20", hash_generated_field = "1B35EABD97FF7D29EE26B2F8FC71C0DC")

    private int mMaxY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "6BD2791CD07D2430F146D6C23A460588", hash_generated_field = "060DFB2652993DA63F3C736F2D32C4A0")

    private int mCurrX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "09D2830408454AE5F3DC6A19638B48BC", hash_generated_field = "DBCFB0FF1F686A6075CBC61640B46359")

    private int mCurrY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "88FA122E67CA1EBC0345CB7CDF675306", hash_generated_field = "C3F9F7F2BFB7C0487094A4AE88371035")

    private float mDurationReciprocal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "7506E0D544261999834610DAFF4B3959", hash_generated_field = "BD1886B2C0F2736203D0E4959638388A")

    private float mDeltaX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "15C5117A7F2734882A39F674EFD72C28", hash_generated_field = "B328B232FC86598D50E8994C967C8DF9")

    private float mDeltaY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

    private boolean mFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "0674FBD78043F84E1B63598E85DD9F83", hash_generated_field = "DB496AACF49E477CC5F54743876A46FF")

    private boolean mFlywheel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "437EB8FD5FAD507D203D1F22AFAD95FB", hash_generated_field = "4B9AC7BF5E01DBE21607C260ED737A0D")

    private float mVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "04F2FB84FDBD333F0C6C423EA089E199", hash_generated_field = "C2BDDF1F4D015B5A70949ADE337CCAA9")

    private float mDeceleration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_field = "0C6F53CC4039F5408DEF57C18E1965F5", hash_generated_field = "C099BB189EED7BFC70ED32FE3657313E")

    private float mPpi;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_method = "F0B1F091C7D17598674B0DE91138DFE8", hash_generated_method = "3BBBFF3F09D0AF83F934785F1CA71EED")
    public  Scroller(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.629 -0400", hash_original_method = "26C129B43F046C683A3A546D94D7B25F", hash_generated_method = "EF452702A7A73630AAA9B7C4E5B00ECB")
    public  Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator,
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
        addTaint(context.getTaint());
        addTaint(interpolator.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.630 -0400", hash_original_method = "DB17BDB963992533B7D3120B4F8AA0BD", hash_generated_method = "BAF062CCBB73EBD946542B564A845C7E")
    public  Scroller(Context context, Interpolator interpolator, boolean flywheel) {
        mFinished = true;
        mInterpolator = interpolator;
        mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        mFlywheel = flywheel;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.630 -0400", hash_original_method = "7DBB574AF8BCDDD777C332A70FF88B50", hash_generated_method = "C44A601CD635F484BC869D788997D666")
    public final void setFriction(float friction) {
        mDeceleration = computeDeceleration(friction);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.630 -0400", hash_original_method = "B6D5379ECD830F8ABC23D18179CF1E64", hash_generated_method = "738F78ED7B06890A50CA5EB7F2B90BC1")
    private float computeDeceleration(float friction) {
        addTaint(friction);
        float var546ADE640B6EDFBC8A086EF31347E768_1341365422 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1341365422;
        
        
                      
                      
                      
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.630 -0400", hash_original_method = "FC91CF543B97ECA9AF0E75894ECCBF47", hash_generated_method = "75641163620BA9B3B2D76C78471D6950")
    public final boolean isFinished() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1908751834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1908751834;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.631 -0400", hash_original_method = "D2A5F5698F1FC9281D0C68AF0BDE844E", hash_generated_method = "D6C7C127B9A2DD566E1703BC4B7A58DD")
    public final void forceFinished(boolean finished) {
        mFinished = finished;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.631 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "52F30DEB3B3C89E02E401B337887FBF9")
    public final int getDuration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583012204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583012204;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.632 -0400", hash_original_method = "BBE38D2570F755B77B8BCEE3883878A8", hash_generated_method = "A5D4BE4C3DD8876C3790B264221CED0E")
    public final int getCurrX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514070692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_514070692;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.632 -0400", hash_original_method = "F6ADC6344D48E201FCE3042AD823C1E1", hash_generated_method = "BB3860565A6738ECE245AB468A2EFE2B")
    public final int getCurrY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674118917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674118917;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.633 -0400", hash_original_method = "B027DED22A5B5763CA61B11517344C6D", hash_generated_method = "6052A505452C91F7683FA385DE591C57")
    public float getCurrVelocity() {
        float var4E1A0AA14190C662937E996756C006EC_1542349093 = (mVelocity - mDeceleration * timePassed() / 2000.0f);
        float var546ADE640B6EDFBC8A086EF31347E768_790795274 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_790795274;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.633 -0400", hash_original_method = "E9E5B4E6E70EEEC71B101472B8ED332D", hash_generated_method = "6AC86DE8D985BC782040B5028438969C")
    public final int getStartX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590305976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590305976;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.633 -0400", hash_original_method = "96DB239ADDDE6565887119C487206B3B", hash_generated_method = "E50EF35AF41C28DE3686D10601B79A90")
    public final int getStartY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315718491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315718491;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.634 -0400", hash_original_method = "FA811E85285FC4A5EAEC6F3CADDA829D", hash_generated_method = "D1ED0D0D5638F4309C923155CE253205")
    public final int getFinalX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407385543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407385543;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.634 -0400", hash_original_method = "39F49202EF2D412808D46FE4B1B455BA", hash_generated_method = "0BCA5AF9D066F1642AA3808FD99F23C9")
    public final int getFinalY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1497743303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1497743303;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.635 -0400", hash_original_method = "1D0B82032F5CA4B8FBC2BBD45CD555A7", hash_generated_method = "1E55228FB1145A2B1980C12190BF731C")
    public boolean computeScrollOffset() {
        int timePassed = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        {
            
            float x = timePassed * mDurationReciprocal;
            
            
            x = viscousFluid(x);
            x = mInterpolator.getInterpolation(x);
            
            
            mCurrX = mStartX + Math.round(x * mDeltaX);
            
            
            mCurrY = mStartY + Math.round(x * mDeltaY);
            
            
            final float t = (float) timePassed / mDuration;
            
            
            final int index = (int) (NB_SAMPLES * t);
            
            
            final float t_inf = (float) index / NB_SAMPLES;
            
            
            final float t_sup = (float) (index + 1) / NB_SAMPLES;
            
            
            final float d_inf = SPLINE[index];
            
            
            final float d_sup = SPLINE[index + 1];
            
            
            final float distanceCoef = d_inf + (t - t_inf) / (t_sup - t_inf) * (d_sup - d_inf);
            
            
            mCurrX = mStartX + Math.round(distanceCoef * (mFinalX - mStartX));
            
            
            mCurrX = Math.min(mCurrX, mMaxX);
            
            
            mCurrX = Math.max(mCurrX, mMinX);
            
            
            mCurrY = mStartY + Math.round(distanceCoef * (mFinalY - mStartY));
            
            
            mCurrY = Math.min(mCurrY, mMaxY);
            
            
            mCurrY = Math.max(mCurrY, mMinY);
            
            
            {
                mFinished = true;
            } 
            
        } 
        {
            mCurrX = mFinalX;
            mCurrY = mFinalY;
            mFinished = true;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224462165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224462165;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.635 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "A07157DD1E11902F09548DA565746592")
    public void startScroll(int startX, int startY, int dx, int dy) {
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        addTaint(startX);
        addTaint(startY);
        addTaint(dx);
        addTaint(dy);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.636 -0400", hash_original_method = "81DB7D22C5A12E34B7101A322373D8F4", hash_generated_method = "4116373163E1068BC0B7EF53F8D2F6A2")
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        mMode = SCROLL_MODE;
        mFinished = false;
        mDuration = duration;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = startX;
        mStartY = startY;
        mFinalX = startX + dx;
        mFinalY = startY + dy;
        mDeltaX = dx;
        mDeltaY = dy;
        mDurationReciprocal = 1.0f / (float) mDuration;
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.636 -0400", hash_original_method = "9117CBBBDEAEC710E4E0E8355A758A12", hash_generated_method = "888C8ADCAA13A83CFC5A8CA24178F764")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        {
            float oldVel = getCurrVelocity();
            float dx = (float) (mFinalX - mStartX);
            float dy = (float) (mFinalY - mStartY);
            float hyp = FloatMath.sqrt(dx * dx + dy * dy);
            float ndx = dx / hyp;
            float ndy = dy / hyp;
            float oldVelocityX = ndx * oldVel;
            float oldVelocityY = ndy * oldVel;
            {
                boolean var86A175506156C862CC1BDCAE0428DBA5_361363636 = (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY));
                {
                    velocityX += oldVelocityX;
                    velocityY += oldVelocityY;
                } 
            } 
        } 
        mMode = FLING_MODE;
        mFinished = false;
        float velocity = FloatMath.sqrt(velocityX * velocityX + velocityY * velocityY);
        mVelocity = velocity;
        final double l = Math.log(START_TENSION * velocity / ALPHA);
        mDuration = (int) (1000.0 * Math.exp(l / (DECELERATION_RATE - 1.0)));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = startX;
        mStartY = startY;
        float coeffX;
        coeffX = 1.0f;
        coeffX = velocityX / velocity;
        float coeffY;
        coeffY = 1.0f;
        coeffY = velocityY / velocity;
        int totalDistance = (int) (ALPHA * Math.exp(DECELERATION_RATE / (DECELERATION_RATE - 1.0) * l));
        mMinX = minX;
        mMaxX = maxX;
        mMinY = minY;
        mMaxY = maxY;
        mFinalX = startX + Math.round(totalDistance * coeffX);
        mFinalX = Math.min(mFinalX, mMaxX);
        mFinalX = Math.max(mFinalX, mMinX);
        mFinalY = startY + Math.round(totalDistance * coeffY);
        mFinalY = Math.min(mFinalY, mMaxY);
        mFinalY = Math.max(mFinalY, mMinY);
        addTaint(velocityX);
        addTaint(velocityY);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static float viscousFluid(float x) {
        x *= sViscousFluidScale;
        if (x < 1.0f) {
            x -= (1.0f - (float)Math.exp(-x));
        } else {
            float start = 0.36787944117f;   
            x = 1.0f - (float)Math.exp(1.0f - x);
            x = start + x * (1.0f - start);
        }
        x *= sViscousFluidNormalize;
        return x;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.637 -0400", hash_original_method = "685B5069D17FA4EA234CACB4808C2E58", hash_generated_method = "3080BC0F4CADDDC7981DD8286E6C232A")
    public void abortAnimation() {
        mCurrX = mFinalX;
        mCurrY = mFinalY;
        mFinished = true;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.637 -0400", hash_original_method = "B7B8889BAD93C262A7F1BCB27AD999FF", hash_generated_method = "7C57A056C34EC0EB988396CC50A8107D")
    public void extendDuration(int extend) {
        int passed = timePassed();
        mDuration = passed + extend;
        mDurationReciprocal = 1.0f / mDuration;
        mFinished = false;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.638 -0400", hash_original_method = "2E2DDE91830A97E8B4307DB61F63C9CC", hash_generated_method = "282F725DB7364D0E03657F65030647C7")
    public int timePassed() {
        int varB31274B63FB1A219A03CF7B3308E210D_1096668923 = ((int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_279892122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_279892122;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.638 -0400", hash_original_method = "EE7294042EF8679A239A5BDA33848B52", hash_generated_method = "21EC3B2014C84C3EE583448EE5BD5FA3")
    public void setFinalX(int newX) {
        mFinalX = newX;
        mDeltaX = mFinalX - mStartX;
        mFinished = false;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.638 -0400", hash_original_method = "E7F00F8A662510F71298FE30A619B84A", hash_generated_method = "695711FF07897043DCFF9272D8CE7BA1")
    public void setFinalY(int newY) {
        mFinalY = newY;
        mDeltaY = mFinalY - mStartY;
        mFinished = false;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.638 -0400", hash_original_method = "8B3C79E02507006E36F2788C827D3070", hash_generated_method = "77B6438F83558334D2018B4FDAF7C37B")
    public boolean isScrollingInDirection(float xvel, float yvel) {
        boolean var059728334551CBB30CCF37D7663E618C_949757689 = (!mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                Math.signum(yvel) == Math.signum(mFinalY - mStartY));
        addTaint(xvel);
        addTaint(yvel);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218383500 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218383500;
        
        
                
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "CE9861B4DE523D1EC20661AA772D40A0", hash_generated_field = "71A034DCC41856FE859BC1F065FC4DA6")

    private static final int DEFAULT_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "F504EA849E0919286438EDA205B8A9E4", hash_generated_field = "A767E7A0CD4C56577AF1FE7F420CA686")

    private static final int SCROLL_MODE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "FDE5999E3553362156971D68664D6C5B", hash_generated_field = "F3B8A415FA7A0B0422B61C4A171BBABD")

    private static final int FLING_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "19034483E00B29048133BC8926F1814A", hash_generated_field = "2564FD12FAC96B1440815F377BD8C411")

    private static float DECELERATION_RATE = (float) (Math.log(0.75) / Math.log(0.9));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "96145DE212B09BD4F27A0678A8A46438", hash_generated_field = "D1E55FA511AC8DBB15DE29964200AC6B")

    private static float ALPHA = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "FA9AC90B5A6E4380DADACDFD13974020", hash_generated_field = "B423EA056F8FF25F121E7449EFE88A98")

    private static float START_TENSION = 0.4f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "685EEB9A58FD714F2875D9DEC4260D27", hash_generated_field = "27DBFD6C76112C4B1F73E7F2EA5D3AA4")

    private static float END_TENSION = 1.0f - START_TENSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "0974E8FC7A93081E4C491C4AFD29D565", hash_generated_field = "3B6A479A94E023469276FA3773CA8C8D")

    private static final int NB_SAMPLES = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "C2A8B044ACE7DA8A6739566186BFBC78", hash_generated_field = "9F7FDC960AFC4BFEA9C812BBA50BD28B")

    private static final float[] SPLINE = new float[NB_SAMPLES + 1];
    static {
        float x_min = 0.0f;
        for (int i = 0; i <= NB_SAMPLES; i++) {
            final float t = (float) i / NB_SAMPLES;
            float x_max = 1.0f;
            float x, tx, coef;
            while (true) {
                x = x_min + (x_max - x_min) / 2.0f;
                coef = 3.0f * x * (1.0f - x);
                tx = coef * ((1.0f - x) * START_TENSION + x * END_TENSION) + x * x * x;
                if (Math.abs(tx - t) < 1E-5) break;
                if (tx > t) x_max = x;
                else x_min = x;
            }
            final float d = coef + x * x * x;
            SPLINE[i] = d;
        }
        SPLINE[NB_SAMPLES] = 1.0f;
        sViscousFluidScale = 8.0f;
        sViscousFluidNormalize = 1.0f;
        sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "8372C9E7F6EE29F03FED5990174B5C5B", hash_generated_field = "1C432C24B5FBB274ECE9C0B14CF36243")

    private static float sViscousFluidScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.639 -0400", hash_original_field = "B45C476255D3DD4A76FD8D0F03CB1163", hash_generated_field = "4E11B8A84F2C6FEABC4146BC9CB98208")

    private static float sViscousFluidNormalize;
}

