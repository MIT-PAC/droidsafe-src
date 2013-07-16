package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class Scroller {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.213 -0400", hash_original_field = "C5AB706852158521E9D44BF62A49B1C9", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.213 -0400", hash_original_field = "9801264300876A677AA3DC64764E3FC2", hash_generated_field = "28E51E686EEF26C8A77C03ED820E724F")

    private int mStartX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "D2D722716779C955F0ECDDD867837AC9", hash_generated_field = "2C4FD2F4594E993A1C0AA896A5F50971")

    private int mStartY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "0290041E535A652B7A5D076F92AD8748", hash_generated_field = "71B9BE40F3EB3F420DA51BED11A1FACC")

    private int mFinalX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "E945BD36FB44D6509A1812FCFC09A99C", hash_generated_field = "14970227CEB8B8463C037E05672A799A")

    private int mFinalY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "7CBEADDF3BF87C8E9592002066182081", hash_generated_field = "AD8B01E82643B27CD370F8D831F238C1")

    private int mMinX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "41704F54749AA189526CA9FAE67380B0", hash_generated_field = "B2C478BEE6C183081971A9B0A8AE4922")

    private int mMaxX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "9A9EF11E7F21CEC6B9588949DB8D8B36", hash_generated_field = "4011ABA5F49EA845B8922B89156403C8")

    private int mMinY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "E1883BCCD9952BD3FB3A6632B7B0AD20", hash_generated_field = "1B35EABD97FF7D29EE26B2F8FC71C0DC")

    private int mMaxY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "6BD2791CD07D2430F146D6C23A460588", hash_generated_field = "060DFB2652993DA63F3C736F2D32C4A0")

    private int mCurrX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "09D2830408454AE5F3DC6A19638B48BC", hash_generated_field = "DBCFB0FF1F686A6075CBC61640B46359")

    private int mCurrY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "88FA122E67CA1EBC0345CB7CDF675306", hash_generated_field = "C3F9F7F2BFB7C0487094A4AE88371035")

    private float mDurationReciprocal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "7506E0D544261999834610DAFF4B3959", hash_generated_field = "BD1886B2C0F2736203D0E4959638388A")

    private float mDeltaX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "15C5117A7F2734882A39F674EFD72C28", hash_generated_field = "B328B232FC86598D50E8994C967C8DF9")

    private float mDeltaY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

    private boolean mFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.214 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.215 -0400", hash_original_field = "0674FBD78043F84E1B63598E85DD9F83", hash_generated_field = "DB496AACF49E477CC5F54743876A46FF")

    private boolean mFlywheel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.215 -0400", hash_original_field = "437EB8FD5FAD507D203D1F22AFAD95FB", hash_generated_field = "4B9AC7BF5E01DBE21607C260ED737A0D")

    private float mVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.215 -0400", hash_original_field = "04F2FB84FDBD333F0C6C423EA089E199", hash_generated_field = "C2BDDF1F4D015B5A70949ADE337CCAA9")

    private float mDeceleration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.215 -0400", hash_original_field = "0C6F53CC4039F5408DEF57C18E1965F5", hash_generated_field = "C099BB189EED7BFC70ED32FE3657313E")

    private float mPpi;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.215 -0400", hash_original_method = "F0B1F091C7D17598674B0DE91138DFE8", hash_generated_method = "3BBBFF3F09D0AF83F934785F1CA71EED")
    public  Scroller(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.215 -0400", hash_original_method = "26C129B43F046C683A3A546D94D7B25F", hash_generated_method = "700036BB901E262AFB73DF574BB60A01")
    public  Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator,
                context.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
        addTaint(interpolator.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.216 -0400", hash_original_method = "DB17BDB963992533B7D3120B4F8AA0BD", hash_generated_method = "BAF062CCBB73EBD946542B564A845C7E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.217 -0400", hash_original_method = "7DBB574AF8BCDDD777C332A70FF88B50", hash_generated_method = "C44A601CD635F484BC869D788997D666")
    public final void setFriction(float friction) {
        mDeceleration = computeDeceleration(friction);
        // ---------- Original Method ----------
        //mDeceleration = computeDeceleration(friction);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.217 -0400", hash_original_method = "B6D5379ECD830F8ABC23D18179CF1E64", hash_generated_method = "717BC576018DEAEFA0809961CD23495A")
    private float computeDeceleration(float friction) {
        addTaint(friction);
        float varFCF8CA81EC5E30B9E22FC49415EDC416_895553278 = (SensorManager.GRAVITY_EARTH   
                      * 39.37f               
                      * mPpi                 
                      * friction);
                float var546ADE640B6EDFBC8A086EF31347E768_1916700497 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1916700497;
        // ---------- Original Method ----------
        //return SensorManager.GRAVITY_EARTH   
                      //* 39.37f               
                      //* mPpi                 
                      //* friction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.218 -0400", hash_original_method = "FC91CF543B97ECA9AF0E75894ECCBF47", hash_generated_method = "5028D913C2DE0EC6D9379B7314F8298C")
    public final boolean isFinished() {
        boolean varBB077E6B2FCDFA3F0EF71EB099A18F49_2113210479 = (mFinished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212874628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_212874628;
        // ---------- Original Method ----------
        //return mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.218 -0400", hash_original_method = "D2A5F5698F1FC9281D0C68AF0BDE844E", hash_generated_method = "D6C7C127B9A2DD566E1703BC4B7A58DD")
    public final void forceFinished(boolean finished) {
        mFinished = finished;
        // ---------- Original Method ----------
        //mFinished = finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.218 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "1EFFFDCE705F0619A7982A5AFD99676A")
    public final int getDuration() {
        int var25395741BFE51A7D136A5C7109AAD2D8_539196984 = (mDuration);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322003881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322003881;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.219 -0400", hash_original_method = "BBE38D2570F755B77B8BCEE3883878A8", hash_generated_method = "9472A318466F7FC8A3FFA77E8FB3D863")
    public final int getCurrX() {
        int var6BD2791CD07D2430F146D6C23A460588_430654273 = (mCurrX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128363812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128363812;
        // ---------- Original Method ----------
        //return mCurrX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.219 -0400", hash_original_method = "F6ADC6344D48E201FCE3042AD823C1E1", hash_generated_method = "F5B0AFF553A1962FB08EB9F428434652")
    public final int getCurrY() {
        int var09D2830408454AE5F3DC6A19638B48BC_1505384630 = (mCurrY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542134845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542134845;
        // ---------- Original Method ----------
        //return mCurrY;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.219 -0400", hash_original_method = "B027DED22A5B5763CA61B11517344C6D", hash_generated_method = "0B6645462F769C051E1D3F026428BB2A")
    public float getCurrVelocity() {
        float var71AD6C62DE88F3704D3F0CB1692E44A0_524459098 = (mVelocity - mDeceleration * timePassed() / 2000.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1501584549 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1501584549;
        // ---------- Original Method ----------
        //return mVelocity - mDeceleration * timePassed() / 2000.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.219 -0400", hash_original_method = "E9E5B4E6E70EEEC71B101472B8ED332D", hash_generated_method = "0375B0EE1F911DB56334FE65DA9A4992")
    public final int getStartX() {
        int var9801264300876A677AA3DC64764E3FC2_2069810412 = (mStartX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865489997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865489997;
        // ---------- Original Method ----------
        //return mStartX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.220 -0400", hash_original_method = "96DB239ADDDE6565887119C487206B3B", hash_generated_method = "F0FFD081060C61FE8CF0A47449F74A67")
    public final int getStartY() {
        int varD2D722716779C955F0ECDDD867837AC9_1643644839 = (mStartY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340559978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340559978;
        // ---------- Original Method ----------
        //return mStartY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.220 -0400", hash_original_method = "FA811E85285FC4A5EAEC6F3CADDA829D", hash_generated_method = "3575DF74723FDB546425AF02BDC3BD13")
    public final int getFinalX() {
        int var0290041E535A652B7A5D076F92AD8748_1971480344 = (mFinalX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166724635 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166724635;
        // ---------- Original Method ----------
        //return mFinalX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.220 -0400", hash_original_method = "39F49202EF2D412808D46FE4B1B455BA", hash_generated_method = "05BAAD6EFF5DD330CAC46B311ECEC147")
    public final int getFinalY() {
        int varE945BD36FB44D6509A1812FCFC09A99C_1698672933 = (mFinalY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202102291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202102291;
        // ---------- Original Method ----------
        //return mFinalY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.222 -0400", hash_original_method = "1D0B82032F5CA4B8FBC2BBD45CD555A7", hash_generated_method = "F4B46F664378CD6ADAC1D009246866F8")
    public boolean computeScrollOffset() {
    if(mFinished)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1010869156 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_959859925 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_959859925;
        } //End block
        int timePassed = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    if(timePassed < mDuration)        
        {
switch(mMode){
            case SCROLL_MODE:
            float x = timePassed * mDurationReciprocal;
    if(mInterpolator == null)            
            x = viscousFluid(x);
            else
            x = mInterpolator.getInterpolation(x);
            mCurrX = mStartX + Math.round(x * mDeltaX);
            mCurrY = mStartY + Math.round(x * mDeltaY);
            break;
            case FLING_MODE:
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
    if(mCurrX == mFinalX && mCurrY == mFinalY)            
            {
                mFinished = true;
            } //End block
            break;
}
        } //End block
        else
        {
            mCurrX = mFinalX;
            mCurrY = mFinalY;
            mFinished = true;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_303219634 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744290761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_744290761;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.222 -0400", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "1BD8BF39BAE975497B125E48604D318A")
    public void startScroll(int startX, int startY, int dx, int dy) {
        addTaint(dy);
        addTaint(dx);
        addTaint(startY);
        addTaint(startX);
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
        // ---------- Original Method ----------
        //startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.224 -0400", hash_original_method = "81DB7D22C5A12E34B7101A322373D8F4", hash_generated_method = "4116373163E1068BC0B7EF53F8D2F6A2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.226 -0400", hash_original_method = "9117CBBBDEAEC710E4E0E8355A758A12", hash_generated_method = "8405A35F0CC6473D2C0C2F4918701608")
    public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        addTaint(velocityY);
        addTaint(velocityX);
    if(mFlywheel && !mFinished)        
        {
            float oldVel = getCurrVelocity();
            float dx = (float) (mFinalX - mStartX);
            float dy = (float) (mFinalY - mStartY);
            float hyp = FloatMath.sqrt(dx * dx + dy * dy);
            float ndx = dx / hyp;
            float ndy = dy / hyp;
            float oldVelocityX = ndx * oldVel;
            float oldVelocityY = ndy * oldVel;
    if(Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY))            
            {
                velocityX += oldVelocityX;
                velocityY += oldVelocityY;
            } //End block
        } //End block
        mMode = FLING_MODE;
        mFinished = false;
        float velocity = FloatMath.sqrt(velocityX * velocityX + velocityY * velocityY);
        mVelocity = velocity;
        final double l = Math.log(START_TENSION * velocity / ALPHA);
        mDuration = (int) (1000.0 * Math.exp(l / (DECELERATION_RATE - 1.0)));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = startX;
        mStartY = startY;
        float coeffX = velocity == 0 ? 1.0f : velocityX / velocity;
        float coeffY = velocity == 0 ? 1.0f : velocityY / velocity;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.227 -0400", hash_original_method = "685B5069D17FA4EA234CACB4808C2E58", hash_generated_method = "3080BC0F4CADDDC7981DD8286E6C232A")
    public void abortAnimation() {
        mCurrX = mFinalX;
        mCurrY = mFinalY;
        mFinished = true;
        // ---------- Original Method ----------
        //mCurrX = mFinalX;
        //mCurrY = mFinalY;
        //mFinished = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.228 -0400", hash_original_method = "B7B8889BAD93C262A7F1BCB27AD999FF", hash_generated_method = "7C57A056C34EC0EB988396CC50A8107D")
    public void extendDuration(int extend) {
        int passed = timePassed();
        mDuration = passed + extend;
        mDurationReciprocal = 1.0f / mDuration;
        mFinished = false;
        // ---------- Original Method ----------
        //int passed = timePassed();
        //mDuration = passed + extend;
        //mDurationReciprocal = 1.0f / mDuration;
        //mFinished = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.229 -0400", hash_original_method = "2E2DDE91830A97E8B4307DB61F63C9CC", hash_generated_method = "37BA3FE8AA8C40550B42F26BC1A645D6")
    public int timePassed() {
        int var8BC71A871FB53CCEC5CBB2277EB0DE39_1285284300 = ((int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417164321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417164321;
        // ---------- Original Method ----------
        //return (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.229 -0400", hash_original_method = "EE7294042EF8679A239A5BDA33848B52", hash_generated_method = "21EC3B2014C84C3EE583448EE5BD5FA3")
    public void setFinalX(int newX) {
        mFinalX = newX;
        mDeltaX = mFinalX - mStartX;
        mFinished = false;
        // ---------- Original Method ----------
        //mFinalX = newX;
        //mDeltaX = mFinalX - mStartX;
        //mFinished = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.230 -0400", hash_original_method = "E7F00F8A662510F71298FE30A619B84A", hash_generated_method = "695711FF07897043DCFF9272D8CE7BA1")
    public void setFinalY(int newY) {
        mFinalY = newY;
        mDeltaY = mFinalY - mStartY;
        mFinished = false;
        // ---------- Original Method ----------
        //mFinalY = newY;
        //mDeltaY = mFinalY - mStartY;
        //mFinished = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.230 -0400", hash_original_method = "8B3C79E02507006E36F2788C827D3070", hash_generated_method = "9C6B2111BEF4ED5380C6E22EABC04830")
    public boolean isScrollingInDirection(float xvel, float yvel) {
        addTaint(yvel);
        addTaint(xvel);
        boolean varFC8255AF0CCAA80DACA7A376AEF34E62_1610018428 = (!mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                Math.signum(yvel) == Math.signum(mFinalY - mStartY));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654703922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654703922;
        // ---------- Original Method ----------
        //return !mFinished && Math.signum(xvel) == Math.signum(mFinalX - mStartX) &&
                //Math.signum(yvel) == Math.signum(mFinalY - mStartY);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.230 -0400", hash_original_field = "CE9861B4DE523D1EC20661AA772D40A0", hash_generated_field = "71A034DCC41856FE859BC1F065FC4DA6")

    private static final int DEFAULT_DURATION = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.230 -0400", hash_original_field = "F504EA849E0919286438EDA205B8A9E4", hash_generated_field = "A767E7A0CD4C56577AF1FE7F420CA686")

    private static final int SCROLL_MODE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.230 -0400", hash_original_field = "FDE5999E3553362156971D68664D6C5B", hash_generated_field = "F3B8A415FA7A0B0422B61C4A171BBABD")

    private static final int FLING_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.230 -0400", hash_original_field = "19034483E00B29048133BC8926F1814A", hash_generated_field = "2564FD12FAC96B1440815F377BD8C411")

    private static float DECELERATION_RATE = (float) (Math.log(0.75) / Math.log(0.9));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.230 -0400", hash_original_field = "96145DE212B09BD4F27A0678A8A46438", hash_generated_field = "D1E55FA511AC8DBB15DE29964200AC6B")

    private static float ALPHA = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.231 -0400", hash_original_field = "FA9AC90B5A6E4380DADACDFD13974020", hash_generated_field = "B423EA056F8FF25F121E7449EFE88A98")

    private static float START_TENSION = 0.4f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.231 -0400", hash_original_field = "685EEB9A58FD714F2875D9DEC4260D27", hash_generated_field = "27DBFD6C76112C4B1F73E7F2EA5D3AA4")

    private static float END_TENSION = 1.0f - START_TENSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.231 -0400", hash_original_field = "0974E8FC7A93081E4C491C4AFD29D565", hash_generated_field = "3B6A479A94E023469276FA3773CA8C8D")

    private static final int NB_SAMPLES = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.231 -0400", hash_original_field = "C2A8B044ACE7DA8A6739566186BFBC78", hash_generated_field = "9F7FDC960AFC4BFEA9C812BBA50BD28B")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.231 -0400", hash_original_field = "8372C9E7F6EE29F03FED5990174B5C5B", hash_generated_field = "1C432C24B5FBB274ECE9C0B14CF36243")

    private static float sViscousFluidScale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.231 -0400", hash_original_field = "B45C476255D3DD4A76FD8D0F03CB1163", hash_generated_field = "4E11B8A84F2C6FEABC4146BC9CB98208")

    private static float sViscousFluidNormalize;
}

