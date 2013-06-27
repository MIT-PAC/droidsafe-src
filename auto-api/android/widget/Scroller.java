package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class Scroller {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "9801264300876A677AA3DC64764E3FC2", hash_generated_field = "28E51E686EEF26C8A77C03ED820E724F")

    private int mStartX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "D2D722716779C955F0ECDDD867837AC9", hash_generated_field = "2C4FD2F4594E993A1C0AA896A5F50971")

    private int mStartY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "0290041E535A652B7A5D076F92AD8748", hash_generated_field = "71B9BE40F3EB3F420DA51BED11A1FACC")

    private int mFinalX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "E945BD36FB44D6509A1812FCFC09A99C", hash_generated_field = "14970227CEB8B8463C037E05672A799A")

    private int mFinalY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "7CBEADDF3BF87C8E9592002066182081", hash_generated_field = "AD8B01E82643B27CD370F8D831F238C1")

    private int mMinX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "41704F54749AA189526CA9FAE67380B0", hash_generated_field = "B2C478BEE6C183081971A9B0A8AE4922")

    private int mMaxX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "9A9EF11E7F21CEC6B9588949DB8D8B36", hash_generated_field = "4011ABA5F49EA845B8922B89156403C8")

    private int mMinY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "E1883BCCD9952BD3FB3A6632B7B0AD20", hash_generated_field = "1B35EABD97FF7D29EE26B2F8FC71C0DC")

    private int mMaxY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "6BD2791CD07D2430F146D6C23A460588", hash_generated_field = "060DFB2652993DA63F3C736F2D32C4A0")

    private int mCurrX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "09D2830408454AE5F3DC6A19638B48BC", hash_generated_field = "DBCFB0FF1F686A6075CBC61640B46359")

    private int mCurrY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "88FA122E67CA1EBC0345CB7CDF675306", hash_generated_field = "C3F9F7F2BFB7C0487094A4AE88371035")

    private float mDurationReciprocal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "7506E0D544261999834610DAFF4B3959", hash_generated_field = "BD1886B2C0F2736203D0E4959638388A")

    private float mDeltaX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "15C5117A7F2734882A39F674EFD72C28", hash_generated_field = "B328B232FC86598D50E8994C967C8DF9")

    private float mDeltaY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

    private boolean mFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "0674FBD78043F84E1B63598E85DD9F83", hash_generated_field = "DB496AACF49E477CC5F54743876A46FF")

    private boolean mFlywheel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.952 -0400", hash_original_field = "437EB8FD5FAD507D203D1F22AFAD95FB", hash_generated_field = "4B9AC7BF5E01DBE21607C260ED737A0D")

    private float mVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.953 -0400", hash_original_field = "04F2FB84FDBD333F0C6C423EA089E199", hash_generated_field = "C2BDDF1F4D015B5A70949ADE337CCAA9")

    private float mDeceleration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.953 -0400", hash_original_field = "0C6F53CC4039F5408DEF57C18E1965F5", hash_generated_field = "C099BB189EED7BFC70ED32FE3657313E")

    private float mPpi;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.953 -0400", hash_original_method = "F0B1F091C7D17598674B0DE91138DFE8", hash_generated_method = "3BBBFF3F09D0AF83F934785F1CA71EED")
    public  Scroller(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.953 -0400", hash_original_method = "26C129B43F046C683A3A546D94D7B25F", hash_generated_method = "EF452702A7A73630AAA9B7C4E5B00ECB")
    public  Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator,
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
        addTaint(context.getTaint());
        addTaint(interpolator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.969 -0400", hash_original_method = "DB17BDB963992533B7D3120B4F8AA0BD", hash_generated_method = "BAF062CCBB73EBD946542B564A845C7E")
    public  Scroller(Context context, Interpolator interpolator, boolean flywheel) {
        mFinished = true;
        mInterpolator = interpolator;
        mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        mFlywheel = flywheel;
        // ---------- Original Method ----------
        //mFinished = true;
        //mInterpolator = interpolator;
        //mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        //mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        //mFlywheel = flywheel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.972 -0400", hash_original_method = "7DBB574AF8BCDDD777C332A70FF88B50", hash_generated_method = "C44A601CD635F484BC869D788997D666")
    public final void setFriction(float friction) {
        mDeceleration = computeDeceleration(friction);
        // ---------- Original Method ----------
        //mDeceleration = computeDeceleration(friction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.973 -0400", hash_original_method = "B6D5379ECD830F8ABC23D18179CF1E64", hash_generated_method = "354E4AC385DD8782E5B575193C60FD79")
    private float computeDeceleration(float friction) {
        addTaint(friction);
        float var546ADE640B6EDFBC8A086EF31347E768_1121728135 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1121728135;
        // ---------- Original Method ----------
        //return SensorManager.GRAVITY_EARTH   
                      //* 39.37f               
                      //* mPpi                 
                      //* friction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.973 -0400", hash_original_method = "FC91CF543B97ECA9AF0E75894ECCBF47", hash_generated_method = "3F6C85EEF6EB11438DFFC5235E10D1F0")
    public final boolean isFinished() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676048578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676048578;
        // ---------- Original Method ----------
        //return mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.975 -0400", hash_original_method = "D2A5F5698F1FC9281D0C68AF0BDE844E", hash_generated_method = "D6C7C127B9A2DD566E1703BC4B7A58DD")
    public final void forceFinished(boolean finished) {
        mFinished = finished;
        // ---------- Original Method ----------
        //mFinished = finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.975 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "60FBA94FEFBBB652472C5EC891BFE884")
    public final int getDuration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863594854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863594854;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.975 -0400", hash_original_method = "BBE38D2570F755B77B8BCEE3883878A8", hash_generated_method = "3555436432B999278A6D011E848C06A4")
    public final int getCurrX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590747146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1590747146;
        // ---------- Original Method ----------
        //return mCurrX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.976 -0400", hash_original_method = "F6ADC6344D48E201FCE3042AD823C1E1", hash_generated_method = "80383BE74DCCF004EAA07E4B3AD206DE")
    public final int getCurrY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409798490 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409798490;
        // ---------- Original Method ----------
        //return mCurrY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.976 -0400", hash_original_method = "B027DED22A5B5763CA61B11517344C6D", hash_generated_method = "A72F52CD7C1915E9F054601D3A3C11B6")
    public float getCurrVelocity() {
        float var4E1A0AA14190C662937E996756C006EC_1217023549 = (mVelocity - mDeceleration * timePassed() / 2000.0f);
        float var546ADE640B6EDFBC8A086EF31347E768_336639099 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_336639099;
        // ---------- Original Method ----------
        //return mVelocity - mDeceleration * timePassed() / 2000.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.976 -0400", hash_original_method = "E9E5B4E6E70EEEC71B101472B8ED332D", hash_generated_method = "E202DC37836D2D1363FB472CBD026C2E")
    public final int getStartX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866540769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866540769;
        // ---------- Original Method ----------
        //return mStartX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.976 -0400", hash_original_method = "96DB239ADDDE6565887119C487206B3B", hash_generated_method = "39BE1396F118A83C2AD1B18C234FCB23")
    public final int getStartY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1766305499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1766305499;
        // ---------- Original Method ----------
        //return mStartY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.978 -0400", hash_original_method = "FA811E85285FC4A5EAEC6F3CADDA829D", hash_generated_method = "A5DE813095DD3C71502CD4421667A6ED")
    public final int getFinalX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686477749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686477749;
        // ---------- Original Method ----------
        //return mFinalX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.978 -0400", hash_original_method = "39F49202EF2D412808D46FE4B1B455BA", hash_generated_method = "CCA6C4BB65AD9394CC8306C480664F5A")
    public final int getFinalY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716994581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716994581;
        // ---------- Original Method ----------
        //return mFinalY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.994 -0400", hash_original_method = "1D0B82032F5CA4B8FBC2BBD45CD555A7", hash_generated_method = "77F92F2875BEB31C407163D709FB75A1")
    public boolean computeScrollOffset() {
        int timePassed;
        timePassed = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        {
            //Begin case SCROLL_MODE 
            float x;
            x = timePassed * mDurationReciprocal;
            //End case SCROLL_MODE 
            //Begin case SCROLL_MODE 
            x = viscousFluid(x);
            x = mInterpolator.getInterpolation(x);
            //End case SCROLL_MODE 
            //Begin case SCROLL_MODE 
            mCurrX = mStartX + Math.round(x * mDeltaX);
            //End case SCROLL_MODE 
            //Begin case SCROLL_MODE 
            mCurrY = mStartY + Math.round(x * mDeltaY);
            //End case SCROLL_MODE 
            //Begin case FLING_MODE 
            float t;
            t = (float) timePassed / mDuration;
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            int index;
            index = (int) (NB_SAMPLES * t);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            float t_inf;
            t_inf = (float) index / NB_SAMPLES;
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            float t_sup;
            t_sup = (float) (index + 1) / NB_SAMPLES;
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            float d_inf;
            d_inf = SPLINE[index];
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            float d_sup;
            d_sup = SPLINE[index + 1];
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            float distanceCoef;
            distanceCoef = d_inf + (t - t_inf) / (t_sup - t_inf) * (d_sup - d_inf);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrX = mStartX + Math.round(distanceCoef * (mFinalX - mStartX));
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrX = Math.min(mCurrX, mMaxX);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrX = Math.max(mCurrX, mMinX);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrY = mStartY + Math.round(distanceCoef * (mFinalY - mStartY));
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrY = Math.min(mCurrY, mMaxY);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            mCurrY = Math.max(mCurrY, mMinY);
            //End case FLING_MODE 
            //Begin case FLING_MODE 
            {
                mFinished = true;
            } //End block
            //End case FLING_MODE 
        } //End block
        {
            mCurrX = mFinalX;
            mCurrY = mFinalY;
            mFinished = true;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113156866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113156866;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:10.994 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "A07157DD1E11902F09548DA565746592")
    public void startScroll(int startX, int startY, int dx, int dy) {
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        addTaint(startX);
        addTaint(startY);
        addTaint(dx);
        addTaint(dy);
        // ---------- Original Method ----------
        //startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.086 -0400", hash_original_method = "81DB7D22C5A12E34B7101A322373D8F4", hash_generated_method = "4116373163E1068BC0B7EF53F8D2F6A2")
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
        // ---------- Original Method ----------
        //mMode = SCROLL_MODE;
        //mFinished = false;
        //mDuration = duration;
        //mStartTime = AnimationUtils.currentAnimationTimeMillis();
        //mStartX = startX;
        //mStartY = startY;
        //mFinalX = startX + dx;
        //mFinalY = startY + dy;
        //mDeltaX = dx;
        //mDeltaY = dy;
        //mDurationReciprocal = 1.0f / (float) mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.093 -0400", hash_original_method = "9117CBBBDEAEC710E4E0E8355A758A12", hash_generated_method = "0856AD259918E6FEAA96B6D4AA7E39B8")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        {
            float oldVel;
            oldVel = getCurrVelocity();
            float dx;
            dx = (float) (mFinalX - mStartX);
            float dy;
            dy = (float) (mFinalY - mStartY);
            float hyp;
            hyp = FloatMath.sqrt(dx * dx + dy * dy);
            float ndx;
            ndx = dx / hyp;
            float ndy;
            ndy = dy / hyp;
            float oldVelocityX;
            oldVelocityX = ndx * oldVel;
            float oldVelocityY;
            oldVelocityY = ndy * oldVel;
            {
                boolean var86A175506156C862CC1BDCAE0428DBA5_1374646675 = (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY));
                {
                    velocityX += oldVelocityX;
                    velocityY += oldVelocityY;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mMode = FLING_MODE;
        mFinished = false;
        float velocity;
        velocity = FloatMath.sqrt(velocityX * velocityX + velocityY * velocityY);
        mVelocity = velocity;
        double l;
        l = Math.log(START_TENSION * velocity / ALPHA);
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
        int totalDistance;
        totalDistance = (int) (ALPHA * Math.exp(DECELERATION_RATE / (DECELERATION_RATE - 1.0) * l));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.096 -0400", hash_original_method = "685B5069D17FA4EA234CACB4808C2E58", hash_generated_method = "3080BC0F4CADDDC7981DD8286E6C232A")
    public void abortAnimation() {
        mCurrX = mFinalX;
        mCurrY = mFinalY;
        mFinished = true;
        // ---------- Original Method ----------
        //mCurrX = mFinalX;
        //mCurrY = mFinalY;
        //mFinished = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.097 -0400", hash_original_method = "B7B8889BAD93C262A7F1BCB27AD999FF", hash_generated_method = "C440E9767C6FEC511E49812B6B1D1E58")
    public void extendDuration(int extend) {
        int passed;
        passed = timePassed();
        mDuration = passed + extend;
        mDurationReciprocal = 1.0f / mDuration;
        mFinished = false;
        // ---------- Original Method ----------
        //int passed = timePassed();
        //mDuration = passed + extend;
        //mDurationReciprocal = 1.0f / mDuration;
        //mFinished = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.097 -0400", hash_original_method = "2E2DDE91830A97E8B4307DB61F63C9CC", hash_generated_method = "D5018F16369319F983B1F104C76982EE")
    public int timePassed() {
        int varB31274B63FB1A219A03CF7B3308E210D_15595199 = ((int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941391681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941391681;
        // ---------- Original Method ----------
        //return (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.098 -0400", hash_original_method = "EE7294042EF8679A239A5BDA33848B52", hash_generated_method = "21EC3B2014C84C3EE583448EE5BD5FA3")
    public void setFinalX(int newX) {
        mFinalX = newX;
        mDeltaX = mFinalX - mStartX;
        mFinished = false;
        // ---------- Original Method ----------
        //mFinalX = newX;
        //mDeltaX = mFinalX - mStartX;
        //mFinished = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.098 -0400", hash_original_method = "E7F00F8A662510F71298FE30A619B84A", hash_generated_method = "695711FF07897043DCFF9272D8CE7BA1")
    public void setFinalY(int newY) {
        mFinalY = newY;
        mDeltaY = mFinalY - mStartY;
        mFinished = false;
        // ---------- Original Method ----------
        //mFinalY = newY;
        //mDeltaY = mFinalY - mStartY;
        //mFinished = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_method = "8B3C79E02507006E36F2788C827D3070", hash_generated_method = "0987C0F23896E72F301D969A3B9D7559")
    public boolean isScrollingInDirection(float xvel, float yvel) {
        boolean var059728334551CBB30CCF37D7663E618C_1097996335 = (!mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                Math.signum(yvel) == Math.signum(mFinalY - mStartY));
        addTaint(xvel);
        addTaint(yvel);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257040233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257040233;
        // ---------- Original Method ----------
        //return !mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                //Math.signum(yvel) == Math.signum(mFinalY - mStartY);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "CE9861B4DE523D1EC20661AA772D40A0", hash_generated_field = "CA7BCE631E650DEB07A51879EA48B1C0")

    private static int DEFAULT_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "F504EA849E0919286438EDA205B8A9E4", hash_generated_field = "C112D93115638A046D164717A3779591")

    private static int SCROLL_MODE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "FDE5999E3553362156971D68664D6C5B", hash_generated_field = "5B3C0A52CF9919E7137022E4D10DEEE7")

    private static int FLING_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "19034483E00B29048133BC8926F1814A", hash_generated_field = "2564FD12FAC96B1440815F377BD8C411")

    private static float DECELERATION_RATE = (float) (Math.log(0.75) / Math.log(0.9));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "96145DE212B09BD4F27A0678A8A46438", hash_generated_field = "D1E55FA511AC8DBB15DE29964200AC6B")

    private static float ALPHA = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "FA9AC90B5A6E4380DADACDFD13974020", hash_generated_field = "B423EA056F8FF25F121E7449EFE88A98")

    private static float START_TENSION = 0.4f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "685EEB9A58FD714F2875D9DEC4260D27", hash_generated_field = "27DBFD6C76112C4B1F73E7F2EA5D3AA4")

    private static float END_TENSION = 1.0f - START_TENSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "0974E8FC7A93081E4C491C4AFD29D565", hash_generated_field = "6706058D788CA3F6D1F2D0B2805E9E76")

    private static int NB_SAMPLES = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "C2A8B044ACE7DA8A6739566186BFBC78", hash_generated_field = "9B19D38E190956436FCC4A5344A01F94")

    private static float[] SPLINE = new float[NB_SAMPLES + 1];
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "8372C9E7F6EE29F03FED5990174B5C5B", hash_generated_field = "1C432C24B5FBB274ECE9C0B14CF36243")

    private static float sViscousFluidScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.099 -0400", hash_original_field = "B45C476255D3DD4A76FD8D0F03CB1163", hash_generated_field = "4E11B8A84F2C6FEABC4146BC9CB98208")

    private static float sViscousFluidNormalize;
}

